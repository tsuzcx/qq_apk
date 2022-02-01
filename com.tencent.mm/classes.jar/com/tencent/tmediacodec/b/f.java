package com.tencent.tmediacodec.b;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoException;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.e.a.a;
import com.tencent.tmediacodec.e.a.b;
import com.tencent.tmediacodec.g.d;
import com.tencent.tmediacodec.hook.PreloadSurface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f
  implements c
{
  private static final Map<Surface, f> ZOB = new ConcurrentHashMap();
  public boolean QCj;
  private int[] ZOA = new int[2];
  private boolean ZOC = false;
  private boolean ZOD = false;
  private int ZOE = 0;
  public f.b ZOl = f.b.ZOQ;
  public final e ZOm;
  protected final b ZOn;
  private String ZOo = "";
  private boolean ZOp;
  private f.a ZOq = f.a.ZOI;
  private final a.a ZOr;
  private final HashSet<Integer> ZOs = new HashSet();
  private long ZOt;
  private final ArrayList<Long> ZOu = new ArrayList();
  public com.tencent.tmediacodec.a.a ZOv;
  private boolean ZOw;
  private a.b ZOx = a.b.ZPm;
  private boolean ZOy;
  private final Set<SurfaceTexture> ZOz = new LinkedHashSet();
  public boolean bcA;
  public boolean bcB;
  private MediaCodecInfo.CodecCapabilities bcC;
  private final MediaCodec bcN;
  protected final String juk;
  protected Surface mSurface;
  
  public f(MediaCodec paramMediaCodec, e parame)
  {
    this.bcN = paramMediaCodec;
    this.ZOm = parame;
    this.ZOn = new b(parame.maxWidth, parame.maxHeight, parame.aMR);
    this.juk = d.a(this.bcN);
    paramMediaCodec = this.juk;
    if ((Build.VERSION.SDK_INT <= 25) && ("OMX.Exynos.avc.dec.secure" == paramMediaCodec) && ((Build.MODEL.startsWith("SM-T585")) || (Build.MODEL.startsWith("SM-A510")) || (Build.MODEL.startsWith("SM-A520")) || (Build.MODEL.startsWith("SM-J700"))))
    {
      paramMediaCodec = a.a.ZPk;
      this.ZOr = paramMediaCodec;
      if (Build.VERSION.SDK_INT >= 18) {
        this.bcC = this.bcN.getCodecInfo().getCapabilitiesForType(parame.aMQ);
      }
      if ((this.bcC == null) || (!d.a(this.bcC))) {
        break label347;
      }
      bool1 = true;
      label250:
      this.bcA = bool1;
      if ((this.bcC == null) || (!d.b(this.bcC))) {
        break label352;
      }
    }
    label347:
    label352:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bcB = bool1;
      return;
      if ((Build.VERSION.SDK_INT < 24) && (("OMX.Nvidia.h264.decode" == paramMediaCodec) || ("OMX.Nvidia.h264.decode.secure" == paramMediaCodec)) && (("flounder" == Build.DEVICE) || ("flounder_lte" == Build.DEVICE) || ("grouper" == Build.DEVICE) || ("tilapia" == Build.DEVICE)))
      {
        paramMediaCodec = a.a.ZPj;
        break;
      }
      paramMediaCodec = a.a.ZPi;
      break;
      bool1 = false;
      break label250;
    }
  }
  
  private void IC(boolean paramBoolean)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", releaseStoreSurfaceTexture mStoreToRelease:").append(this.ZOz);
      com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
    }
    final ArrayList localArrayList;
    if (!this.ZOz.isEmpty())
    {
      localArrayList = new ArrayList(this.ZOz);
      this.ZOz.clear();
      if (paramBoolean) {
        com.tencent.tmediacodec.g.e.execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(224302);
            f.a(f.this, localArrayList);
            AppMethodBeat.o(224302);
          }
        });
      }
    }
    else
    {
      return;
    }
    kY(localArrayList);
  }
  
  public static c a(MediaCodec paramMediaCodec, String paramString, e parame)
  {
    if (d.bJ(paramString)) {
      return new g(paramMediaCodec, parame);
    }
    return new a(paramMediaCodec, parame);
  }
  
  private void a(int paramInt, String paramString, Throwable paramThrowable, boolean paramBoolean, Surface paramSurface)
  {
    this.ZOC = true;
    String str;
    if (paramThrowable == null) {
      str = "";
    }
    for (;;)
    {
      paramString = paramString + " handleCoreAPIException exception:" + str;
      int i = paramInt;
      if (paramBoolean)
      {
        int j = r(paramSurface);
        i = paramInt;
        if (j != 0) {
          i = j;
        }
      }
      paramSurface = new JSONObject();
      try
      {
        paramSurface.put("errorCode", i);
        paramSurface.put("exceptionMsg", paramString);
        if (this.ZOv != null) {
          this.ZOv.onReuseCodecAPIException(paramSurface.toString(), paramThrowable);
        }
        label118:
        new StringBuilder("hasReused:").append(this.ZOw).append("    errorCode:").append(i).append(", ").append(paramString);
        com.tencent.tmediacodec.g.b.bDU("ReuseCodecWrapper");
        aCj(i);
        return;
        str = paramThrowable.getLocalizedMessage();
      }
      catch (JSONException paramThrowable)
      {
        break label118;
      }
    }
  }
  
  private void aCj(int paramInt)
  {
    if (paramInt < 40000) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new StringBuilder().append(this).append("    releaseCodecWhenError, errorCode:").append(paramInt);
        com.tencent.tmediacodec.g.b.bDT("ReuseCodecWrapper");
        release();
      }
      return;
    }
  }
  
  private final void bDM(String paramString)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", removeStoreSurfaceTexture nameSurfaceTexture:").append(paramString);
      com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
    }
    Iterator localIterator = this.ZOz.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(localIterator.next().toString(), paramString)) {
        localIterator.remove();
      }
    }
  }
  
  @TargetApi(23)
  private void c(Surface paramSurface, boolean paramBoolean)
  {
    if (this.mSurface == paramSurface)
    {
      new StringBuilder().append(this).append(", innerSetOutputSurface error surface:").append(paramSurface).append(" is same, stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.bDR("ReuseCodecWrapper");
      return;
    }
    String str = null;
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      str = this + " configure, call innerSetOutputSurface surface:" + paramSurface + "  decodeState:" + this.ZOl + " callByInner:" + paramBoolean;
      com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
    }
    try
    {
      setSurface(paramSurface);
      this.bcN.setOutputSurface(paramSurface);
      IC(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      i = 0;
      if (!(localThrowable instanceof IllegalStateException)) {
        break label169;
      }
    }
    int i = 30000;
    for (;;)
    {
      a(i, str, localThrowable, true, paramSurface);
      throw localThrowable;
      label169:
      if ((localThrowable instanceof IllegalArgumentException)) {
        i = 30001;
      }
    }
  }
  
  private void d(int paramInt, String paramString, Throwable paramThrowable)
  {
    a(paramInt, paramString, paramThrowable, false, this.mSurface);
  }
  
  private void d(Set paramSet1, Set paramSet2)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", removeSurfaceBinding toReleaseNameSet:").append(paramSet1).append(" toReleaseCodecSet:").append(paramSet2);
      com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
    }
    Iterator localIterator = ZOB.entrySet().iterator();
    label147:
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = d.s((Surface)localEntry.getKey());
      if ((paramSet1.contains(str)) || (paramSet2.contains(localEntry.getValue()))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label147;
        }
        localIterator.remove();
        com.tencent.tmediacodec.hook.a.bDN(str);
        break;
      }
    }
  }
  
  private boolean itb()
  {
    return Thread.currentThread().getId() != this.ZOt;
  }
  
  private final void kY(List<SurfaceTexture> paramList)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", releaseSurfaceTexture toReleaseSet:").append(paramList);
      com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)paramList.next();
      com.tencent.tmediacodec.hook.a.w(localSurfaceTexture);
      localLinkedHashSet.add(localSurfaceTexture.toString());
    }
    z(localLinkedHashSet);
  }
  
  private void od(int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((!this.ZOD) && (oe(paramInt1, paramInt2)))
    {
      this.ZOD = true;
      StringBuilder localStringBuilder = new StringBuilder().append(this).append(", trackDecodeApi state:").append(this.ZOq).append("  surfaceState:");
      if (this.mSurface == null) {
        break label95;
      }
      localObject = Boolean.valueOf(this.mSurface.isValid());
      localObject = localObject;
      if (paramInt1 != 0) {
        break label100;
      }
      d(40002, (String)localObject, null);
    }
    label95:
    label100:
    while (paramInt1 != 1)
    {
      return;
      localObject = null;
      break;
    }
    d(60002, (String)localObject, null);
  }
  
  private boolean oe(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 == -1)
    {
      int[] arrayOfInt = this.ZOA;
      arrayOfInt[paramInt1] += 1;
      if (this.ZOA[paramInt1] > 100) {
        bool = true;
      }
      return bool;
    }
    this.ZOA[paramInt1] = 0;
    return false;
  }
  
  private static int r(Surface paramSurface)
  {
    if (paramSurface == null) {
      return 10003;
    }
    if (!paramSurface.isValid()) {
      return 10004;
    }
    return 0;
  }
  
  private final void setSurface(Surface paramSurface)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", oldSurface:").append(this.mSurface).append(" CodecWrapperSetSurface surface:").append(paramSurface);
      com.tencent.tmediacodec.g.b.bDQ("ReuseCodecWrapper");
    }
    com.tencent.tmediacodec.hook.a.bDN(this.ZOo);
    z(new HashSet(Collections.singletonList(this.ZOo)));
    localObject = this.mSurface;
    try
    {
      if ((localObject instanceof PreloadSurface))
      {
        SurfaceTexture localSurfaceTexture = ((PreloadSurface)localObject).surfaceTexture;
        if ((localSurfaceTexture instanceof com.tencent.tmediacodec.hook.b)) {
          this.ZOz.add(localSurfaceTexture);
        }
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          new StringBuilder("markPreloadSurfaceTexture oldSurface:").append(localObject).append(" success");
          com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        new StringBuilder("markPreloadSurfaceTexture oldSurface:").append(localObject).append(" failed");
        com.tencent.tmediacodec.g.b.bDU("ReuseCodecWrapper");
        continue;
        boolean bool = false;
      }
    }
    this.mSurface = paramSurface;
    this.ZOo = "";
    if (paramSurface != null) {
      this.ZOo = d.s(paramSurface);
    }
    bDM(this.ZOo);
    if (paramSurface != null)
    {
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder().append(this).append(" checkSurfaceBinding size:").append(ZOB.size()).append(" mSurfaceMap:").append(ZOB);
        com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
      }
      if (ZOB.containsKey(paramSurface))
      {
        localObject = (f)ZOB.get(paramSurface);
        if ((localObject == null) || (!((f)localObject).ZOp)) {
          break label399;
        }
        bool = true;
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          new StringBuilder().append(this).append(", surface:").append(paramSurface).append(" has been used by ").append(localObject).append(" isReleaseCalled:").append(bool).append(", ignore but we can release it...");
          com.tencent.tmediacodec.g.b.bDT("ReuseCodecWrapper");
        }
        if (bool) {
          ((f)localObject).recycle();
        }
      }
      ZOB.put(paramSurface, this);
      com.tencent.tmediacodec.hook.a.a(this.ZOo, new com.tencent.tmediacodec.hook.c()
      {
        public final void v(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(224297);
          if (TextUtils.equals(f.a(f.this), paramAnonymousSurfaceTexture.toString()))
          {
            f.b(f.this).add(paramAnonymousSurfaceTexture);
            new StringBuilder().append(f.this).append("      surfaceDestroyed ... surfaceTexture:").append(paramAnonymousSurfaceTexture).append("     mStoreToRelease.size:").append(f.b(f.this).size());
            com.tencent.tmediacodec.g.b.bDR("ReuseCodecWrapper");
          }
          AppMethodBeat.o(224297);
        }
      });
    }
    else
    {
      return;
    }
  }
  
  private void z(Set paramSet)
  {
    d(paramSet, Collections.emptySet());
  }
  
  public final int EX(long paramLong)
  {
    int i = 0;
    if (itb())
    {
      com.tencent.tmediacodec.g.b.bDR("ReuseCodecWrapper");
      return -1;
    }
    Object localObject2 = null;
    String str = null;
    Object localObject1 = localObject2;
    try
    {
      int j = this.bcN.dequeueInputBuffer(paramLong);
      localObject1 = localObject2;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        localObject1 = localObject2;
        str = this + ", dequeueInputBuffer state:" + this.ZOq + " decodeState:" + this.ZOl + " , result=" + j;
        localObject1 = str;
        com.tencent.tmediacodec.g.b.bDO("ReuseCodecWrapper");
      }
      localObject1 = str;
      this.ZOl = f.b.ZOR;
      localObject1 = str;
      this.ZOq = f.a.ZOM;
      localObject1 = str;
      od(0, j);
      return j;
    }
    catch (Throwable localThrowable)
    {
      if (!(localThrowable instanceof IllegalStateException)) {
        break label176;
      }
    }
    i = 40000;
    for (;;)
    {
      d(i, (String)localObject1, localThrowable);
      throw localThrowable;
      label176:
      if ((localThrowable instanceof IllegalArgumentException)) {
        i = 40001;
      }
    }
  }
  
  public final int a(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    if (itb())
    {
      com.tencent.tmediacodec.g.b.bDR("ReuseCodecWrapper");
      return -1;
    }
    String str = null;
    Object localObject2 = null;
    Object localObject1 = str;
    int i;
    try
    {
      i = this.bcN.dequeueOutputBuffer(paramBufferInfo, paramLong);
      paramBufferInfo = localObject2;
      localObject1 = str;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        localObject1 = str;
        str = this + ", dequeueOutputBuffer outIndex:" + i;
        paramBufferInfo = str;
        localObject1 = str;
        if ((this instanceof g))
        {
          localObject1 = str;
          com.tencent.tmediacodec.g.b.bDO("ReuseCodecWrapper");
          paramBufferInfo = str;
        }
      }
      localObject1 = paramBufferInfo;
      this.ZOs.add(Integer.valueOf(i));
      localObject1 = paramBufferInfo;
      this.ZOl = f.b.ZOT;
      localObject1 = paramBufferInfo;
      od(1, i);
      return i;
    }
    catch (Throwable paramBufferInfo)
    {
      i = 0;
      if (Build.VERSION.SDK_INT < 21) {
        break label181;
      }
    }
    if ((paramBufferInfo instanceof MediaCodec.CodecException)) {
      i = 60001;
    }
    for (;;)
    {
      d(i, (String)localObject1, paramBufferInfo);
      throw paramBufferInfo;
      label181:
      if ((paramBufferInfo instanceof IllegalStateException)) {
        i = 60000;
      }
    }
  }
  
  public abstract a.b a(e parame);
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if (itb())
    {
      com.tencent.tmediacodec.g.b.bDR("ReuseCodecWrapper");
      return;
    }
    String str;
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      str = this + ", queueInputBuffer index:" + paramInt1 + " offset:0 size:" + paramInt2 + " presentationTimeUs:" + paramLong + ' ' + "flags:" + paramInt3 + " state:" + this.ZOq + " decodeState:" + this.ZOl;
      com.tencent.tmediacodec.g.b.bDO("ReuseCodecWrapper");
    }
    for (;;)
    {
      try
      {
        if (!this.ZOw) {
          break label243;
        }
        switch (4.ZOH[this.ZOx.ordinal()])
        {
        case 1: 
          this.ZOl = f.b.ZOS;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (Build.VERSION.SDK_INT < 21) {
          break label259;
        }
      }
      if ((localThrowable instanceof MediaCodec.CodecException)) {
        paramInt1 = 50001;
      }
      for (;;)
      {
        d(paramInt1, str, localThrowable);
        throw localThrowable;
        com.tencent.tmediacodec.g.b.bDR("ReuseCodecWrapper");
        break;
        this.bcN.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
        break;
        this.bcN.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
        break;
        label243:
        this.bcN.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
        break;
        label259:
        if ((localThrowable instanceof IllegalStateException)) {
          paramInt1 = 50000;
        } else if ((localThrowable instanceof MediaCodec.CryptoException)) {
          paramInt1 = 50002;
        } else {
          paramInt1 = 0;
        }
      }
      str = null;
    }
  }
  
  public final void a(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt)
  {
    paramInt = 0;
    if (itb()) {
      com.tencent.tmediacodec.g.b.bDR("ReuseCodecWrapper");
    }
    label218:
    do
    {
      return;
      this.ZOy = true;
      for (;;)
      {
        try
        {
          this.ZOp = false;
          Object localObject1 = this.ZOq;
          Object localObject2 = f.a.ZOI;
          if (localObject1 != localObject2) {
            break;
          }
          Object localObject3 = null;
          localObject2 = null;
          localObject1 = localObject3;
          try
          {
            if (com.tencent.tmediacodec.g.b.isLogEnable())
            {
              localObject1 = localObject3;
              localObject2 = this + ", realConfigure mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " crypto:" + paramMediaCrypto + " flags:0" + " state:" + this.ZOq + " mHasConfigureCalled：" + this.ZOy;
              localObject1 = localObject2;
              com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
            }
            localObject1 = localObject2;
            this.bcN.configure(paramMediaFormat, paramSurface, paramMediaCrypto, 0);
            localObject1 = localObject2;
            setSurface(paramSurface);
            localObject1 = localObject2;
            this.ZOq = f.a.ZOJ;
            return;
          }
          catch (Throwable paramMediaFormat)
          {
            if (!(paramMediaFormat instanceof IllegalStateException)) {
              break label218;
            }
          }
          paramInt = 10000;
          a(paramInt, (String)localObject1, paramMediaFormat, true, paramSurface);
          throw paramMediaFormat;
        }
        catch (Throwable paramMediaFormat)
        {
          throw paramMediaFormat;
        }
        if ((paramMediaFormat instanceof MediaCodec.CryptoException)) {
          paramInt = 10001;
        }
      }
    } while (paramSurface == null);
    this.ZOA[0] = 0;
    this.ZOA[1] = 0;
    c(paramSurface, true);
  }
  
  public final void a(com.tencent.tmediacodec.a.a parama)
  {
    this.ZOv = parama;
  }
  
  public final a.b b(e parame)
  {
    this.ZOx = a(parame);
    return this.ZOx;
  }
  
  public final void flush()
  {
    if (itb()) {
      com.tencent.tmediacodec.g.b.bDR("ReuseCodecWrapper");
    }
    Object localObject2 = null;
    String str = null;
    Object localObject1 = localObject2;
    int i;
    try
    {
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        localObject1 = localObject2;
        str = this + ", flush state:" + this.ZOq;
        localObject1 = str;
        com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
      }
      localObject1 = str;
      this.bcN.flush();
      localObject1 = str;
      this.ZOq = f.a.ZOL;
      return;
    }
    catch (Throwable localThrowable)
    {
      i = 0;
      if (Build.VERSION.SDK_INT < 21) {
        break label116;
      }
    }
    if ((localThrowable instanceof MediaCodec.CodecException)) {
      i = 90001;
    }
    for (;;)
    {
      d(i, (String)localObject1, localThrowable);
      throw localThrowable;
      label116:
      if ((localThrowable instanceof IllegalStateException)) {
        i = 90000;
      }
    }
  }
  
  public final MediaCodec isY()
  {
    return this.bcN;
  }
  
  public final void isZ()
  {
    long l = Thread.currentThread().getId();
    if (this.ZOu.contains(Long.valueOf(l))) {}
    do
    {
      return;
      this.ZOt = l;
      this.ZOu.add(Long.valueOf(this.ZOt));
    } while (this.ZOu.size() <= 100);
    this.ZOu.remove(0);
  }
  
  public final void ita()
  {
    this.ZOD = false;
    this.ZOE = 0;
    if (this.ZOq != f.a.ZOL) {
      flush();
    }
    this.ZOw = true;
  }
  
  public boolean itc()
  {
    return (!this.ZOC) && (com.tencent.tmediacodec.a.isT().ZNN);
  }
  
  public final void itd()
  {
    this.ZOE += 1;
  }
  
  public final boolean ite()
  {
    return this.ZOE >= 3;
  }
  
  public final String itf()
  {
    return this.juk;
  }
  
  @TargetApi(23)
  public final void q(Surface paramSurface)
  {
    c(paramSurface, false);
  }
  
  public final void recycle()
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", recycle isRecycled:").append(this.QCj).append(" ...... stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
    }
    this.ZOy = false;
    this.QCj = true;
    d(Collections.emptySet(), Collections.singleton(this));
    com.tencent.tmediacodec.g.e.runOnSubThread(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 24
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 17	com/tencent/tmediacodec/b/f$3:ZOF	Lcom/tencent/tmediacodec/b/f;
        //   9: invokestatic 34	com/tencent/tmediacodec/b/f:c	(Lcom/tencent/tmediacodec/b/f;)Landroid/media/MediaCodec;
        //   12: invokevirtual 39	android/media/MediaCodec:stop	()V
        //   15: aload_0
        //   16: getfield 17	com/tencent/tmediacodec/b/f$3:ZOF	Lcom/tencent/tmediacodec/b/f;
        //   19: invokestatic 34	com/tencent/tmediacodec/b/f:c	(Lcom/tencent/tmediacodec/b/f;)Landroid/media/MediaCodec;
        //   22: invokevirtual 42	android/media/MediaCodec:release	()V
        //   25: aload_0
        //   26: getfield 17	com/tencent/tmediacodec/b/f$3:ZOF	Lcom/tencent/tmediacodec/b/f;
        //   29: invokestatic 45	com/tencent/tmediacodec/b/f:d	(Lcom/tencent/tmediacodec/b/f;)V
        //   32: aload_0
        //   33: getfield 17	com/tencent/tmediacodec/b/f$3:ZOF	Lcom/tencent/tmediacodec/b/f;
        //   36: invokestatic 49	com/tencent/tmediacodec/b/f:e	(Lcom/tencent/tmediacodec/b/f;)Lcom/tencent/tmediacodec/a/a;
        //   39: ifnull +15 -> 54
        //   42: aload_0
        //   43: getfield 17	com/tencent/tmediacodec/b/f$3:ZOF	Lcom/tencent/tmediacodec/b/f;
        //   46: invokestatic 49	com/tencent/tmediacodec/b/f:e	(Lcom/tencent/tmediacodec/b/f;)Lcom/tencent/tmediacodec/a/a;
        //   49: invokeinterface 54 1 0
        //   54: ldc 24
        //   56: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   59: return
        //   60: astore_1
        //   61: aload_0
        //   62: getfield 17	com/tencent/tmediacodec/b/f$3:ZOF	Lcom/tencent/tmediacodec/b/f;
        //   65: invokestatic 34	com/tencent/tmediacodec/b/f:c	(Lcom/tencent/tmediacodec/b/f;)Landroid/media/MediaCodec;
        //   68: invokevirtual 42	android/media/MediaCodec:release	()V
        //   71: ldc 24
        //   73: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: aload_1
        //   77: athrow
        //   78: astore_1
        //   79: ldc 59
        //   81: invokestatic 65	com/tencent/tmediacodec/g/b:bDS	(Ljava/lang/String;)V
        //   84: goto -52 -> 32
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	this	3
        //   60	17	1	localObject	Object
        //   78	1	1	localThrowable	Throwable
        // Exception table:
        //   from	to	target	type
        //   5	15	60	finally
        //   15	32	78	java/lang/Throwable
        //   61	78	78	java/lang/Throwable
      }
    });
    if (this.mSurface != null) {
      ZOB.remove(this.mSurface);
    }
    this.ZOq = f.a.ZOI;
  }
  
  public final void release()
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(" call release mHoldBufferOutIndex:").append(this.ZOs).append(" mReleaseCalled:").append(this.ZOp).append(" stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
    }
    this.ZOp = true;
    this.ZOy = false;
    if (itc())
    {
      flush();
      com.tencent.tmediacodec.a.isT().b(this);
      return;
    }
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder("Don't not keep the codec, release it ..., mErrorHappened:").append(this.ZOC);
      com.tencent.tmediacodec.g.b.bDR("ReuseCodecWrapper");
    }
    com.tencent.tmediacodec.a.isT().a(this);
    recycle();
    this.ZOq = f.a.ZOO;
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if (itb())
    {
      com.tencent.tmediacodec.g.b.bDR("ReuseCodecWrapper");
      return;
    }
    String str;
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      str = this + ", releaseOutputBuffer render:" + paramBoolean;
      com.tencent.tmediacodec.g.b.bDO("ReuseCodecWrapper");
    }
    for (;;)
    {
      try
      {
        this.ZOs.remove(Integer.valueOf(paramInt));
        this.bcN.releaseOutputBuffer(paramInt, paramBoolean);
        this.ZOl = f.b.ZOU;
        return;
      }
      catch (Throwable localThrowable)
      {
        if (this.ZOq != f.a.ZOL)
        {
          new StringBuilder().append(this).append(", releaseOutputBuffer failed, ignore e:");
          com.tencent.tmediacodec.g.b.bDS("ReuseCodecWrapper");
        }
        paramInt = 0;
        if (Build.VERSION.SDK_INT < 21) {
          break label149;
        }
      }
      if ((localThrowable instanceof MediaCodec.CodecException)) {
        paramInt = 70002;
      }
      for (;;)
      {
        d(paramInt, str, localThrowable);
        break;
        label149:
        if ((localThrowable instanceof IllegalStateException)) {
          paramInt = 70001;
        }
      }
      str = null;
    }
  }
  
  public final void start()
  {
    if (this.ZOq != f.a.ZOJ)
    {
      new StringBuilder("start ignore:").append(this.ZOq);
      com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
    }
    Object localObject1;
    int i;
    for (;;)
    {
      return;
      Object localObject2 = null;
      String str = null;
      localObject1 = localObject2;
      try
      {
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          localObject1 = localObject2;
          str = this + ", start state:" + this.ZOq;
          localObject1 = str;
          com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
        }
        localObject1 = str;
        if (this.ZOq == f.a.ZOJ)
        {
          localObject1 = str;
          this.bcN.start();
          localObject1 = str;
          this.ZOq = f.a.ZOM;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        i = 0;
        if (Build.VERSION.SDK_INT < 21) {
          break label150;
        }
      }
    }
    if ((localThrowable instanceof MediaCodec.CodecException)) {
      i = 20001;
    }
    for (;;)
    {
      d(i, (String)localObject1, localThrowable);
      throw localThrowable;
      label150:
      if ((localThrowable instanceof IllegalStateException)) {
        i = 20000;
      }
    }
  }
  
  public final void stop()
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", stop");
      com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
    }
    if (!itc())
    {
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder().append(this).append(", codec real stop");
        com.tencent.tmediacodec.g.b.bDP("ReuseCodecWrapper");
      }
      this.bcN.stop();
      this.ZOq = f.a.ZOI;
    }
  }
  
  public String toString()
  {
    return super.toString() + " mReleaseCalled:" + this.ZOp + " isRecycled:" + this.QCj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.f
 * JD-Core Version:    0.7.0.1
 */