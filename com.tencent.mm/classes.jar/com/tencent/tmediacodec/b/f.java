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
  private static final Map<Surface, f> SlQ = new ConcurrentHashMap();
  public b SlA = b.Smf;
  public final e SlB;
  protected final b SlC;
  private String SlD = "";
  private boolean SlE;
  private a SlF = a.SlX;
  private final a.a SlG;
  private final HashSet<Integer> SlH = new HashSet();
  private long SlI;
  private final ArrayList<Long> SlJ = new ArrayList();
  public com.tencent.tmediacodec.a.a SlK;
  private boolean SlL;
  private a.b SlM = a.b.SmB;
  private boolean SlN;
  private final Set<SurfaceTexture> SlO = new LinkedHashSet();
  private int[] SlP = new int[2];
  private boolean SlR = false;
  private boolean SlS = false;
  private int SlT = 0;
  public boolean aHN;
  public boolean bsX;
  public boolean bsY;
  private MediaCodecInfo.CodecCapabilities bsZ;
  private final MediaCodec btk;
  protected final String gJW;
  protected Surface mSurface;
  
  public f(MediaCodec paramMediaCodec, e parame)
  {
    this.btk = paramMediaCodec;
    this.SlB = parame;
    this.SlC = new b(parame.maxWidth, parame.maxHeight, parame.bdr);
    this.gJW = d.a(this.btk);
    paramMediaCodec = this.gJW;
    if ((Build.VERSION.SDK_INT <= 25) && ("OMX.Exynos.avc.dec.secure" == paramMediaCodec) && ((Build.MODEL.startsWith("SM-T585")) || (Build.MODEL.startsWith("SM-A510")) || (Build.MODEL.startsWith("SM-A520")) || (Build.MODEL.startsWith("SM-J700"))))
    {
      paramMediaCodec = a.a.Smz;
      this.SlG = paramMediaCodec;
      if (Build.VERSION.SDK_INT >= 18) {
        this.bsZ = this.btk.getCodecInfo().getCapabilitiesForType(parame.bdq);
      }
      if ((this.bsZ == null) || (!d.a(this.bsZ))) {
        break label347;
      }
      bool1 = true;
      label250:
      this.bsX = bool1;
      if ((this.bsZ == null) || (!d.b(this.bsZ))) {
        break label352;
      }
    }
    label347:
    label352:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bsY = bool1;
      return;
      if ((Build.VERSION.SDK_INT < 24) && (("OMX.Nvidia.h264.decode" == paramMediaCodec) || ("OMX.Nvidia.h264.decode.secure" == paramMediaCodec)) && (("flounder" == Build.DEVICE) || ("flounder_lte" == Build.DEVICE) || ("grouper" == Build.DEVICE) || ("tilapia" == Build.DEVICE)))
      {
        paramMediaCodec = a.a.Smy;
        break;
      }
      paramMediaCodec = a.a.Smx;
      break;
      bool1 = false;
      break label250;
    }
  }
  
  private void Eb(boolean paramBoolean)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", releaseStoreSurfaceTexture mStoreToRelease:").append(this.SlO);
      com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
    }
    final ArrayList localArrayList;
    if (!this.SlO.isEmpty())
    {
      localArrayList = new ArrayList(this.SlO);
      this.SlO.clear();
      if (paramBoolean) {
        com.tencent.tmediacodec.g.e.execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(190121);
            f.a(f.this, localArrayList);
            AppMethodBeat.o(190121);
          }
        });
      }
    }
    else
    {
      return;
    }
    ke(localArrayList);
  }
  
  public static c a(MediaCodec paramMediaCodec, String paramString, e parame)
  {
    if (d.by(paramString)) {
      return new g(paramMediaCodec, parame);
    }
    return new a(paramMediaCodec, parame);
  }
  
  private void a(int paramInt, String paramString, Throwable paramThrowable, boolean paramBoolean, Surface paramSurface)
  {
    this.SlR = true;
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
        int j = m(paramSurface);
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
        if (this.SlK != null) {
          this.SlK.onReuseCodecAPIException(paramSurface.toString(), paramThrowable);
        }
        label118:
        new StringBuilder("hasReused:").append(this.SlL).append("    errorCode:").append(i).append(", ").append(paramString);
        com.tencent.tmediacodec.g.b.bqV("ReuseCodecWrapper");
        asv(i);
        return;
        str = paramThrowable.getLocalizedMessage();
      }
      catch (JSONException paramThrowable)
      {
        break label118;
      }
    }
  }
  
  private void asv(int paramInt)
  {
    if (paramInt < 40000) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new StringBuilder().append(this).append("    releaseCodecWhenError, errorCode:").append(paramInt);
        com.tencent.tmediacodec.g.b.bqU("ReuseCodecWrapper");
        release();
      }
      return;
    }
  }
  
  private final void bqN(String paramString)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", removeStoreSurfaceTexture nameSurfaceTexture:").append(paramString);
      com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
    }
    Iterator localIterator = this.SlO.iterator();
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
      com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
      return;
    }
    String str = null;
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      str = this + " configure, call innerSetOutputSurface surface:" + paramSurface + "  decodeState:" + this.SlA + " callByInner:" + paramBoolean;
      com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
    }
    try
    {
      setSurface(paramSurface);
      this.btk.setOutputSurface(paramSurface);
      Eb(true);
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
      com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
    }
    Iterator localIterator = SlQ.entrySet().iterator();
    label147:
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = d.n((Surface)localEntry.getKey());
      if ((paramSet1.contains(str)) || (paramSet2.contains(localEntry.getValue()))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label147;
        }
        localIterator.remove();
        com.tencent.tmediacodec.hook.a.bqO(str);
        break;
      }
    }
  }
  
  private boolean hpv()
  {
    return Thread.currentThread().getId() != this.SlI;
  }
  
  private final void ke(List<SurfaceTexture> paramList)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", releaseSurfaceTexture toReleaseSet:").append(paramList);
      com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)paramList.next();
      com.tencent.tmediacodec.hook.a.t(localSurfaceTexture);
      localLinkedHashSet.add(localSurfaceTexture.toString());
    }
    z(localLinkedHashSet);
  }
  
  private static int m(Surface paramSurface)
  {
    if (paramSurface == null) {
      return 10003;
    }
    if (!paramSurface.isValid()) {
      return 10004;
    }
    return 0;
  }
  
  private void mL(int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((!this.SlS) && (mM(paramInt1, paramInt2)))
    {
      this.SlS = true;
      StringBuilder localStringBuilder = new StringBuilder().append(this).append(", trackDecodeApi state:").append(this.SlF).append("  surfaceState:");
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
  
  private boolean mM(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 == -1)
    {
      int[] arrayOfInt = this.SlP;
      arrayOfInt[paramInt1] += 1;
      if (this.SlP[paramInt1] > 100) {
        bool = true;
      }
      return bool;
    }
    this.SlP[paramInt1] = 0;
    return false;
  }
  
  private final void setSurface(Surface paramSurface)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", oldSurface:").append(this.mSurface).append(" CodecWrapperSetSurface surface:").append(paramSurface);
      com.tencent.tmediacodec.g.b.bqR("ReuseCodecWrapper");
    }
    com.tencent.tmediacodec.hook.a.bqO(this.SlD);
    z(new HashSet(Collections.singletonList(this.SlD)));
    localObject = this.mSurface;
    try
    {
      if ((localObject instanceof PreloadSurface))
      {
        SurfaceTexture localSurfaceTexture = ((PreloadSurface)localObject).surfaceTexture;
        if ((localSurfaceTexture instanceof com.tencent.tmediacodec.hook.b)) {
          this.SlO.add(localSurfaceTexture);
        }
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          new StringBuilder("markPreloadSurfaceTexture oldSurface:").append(localObject).append(" success");
          com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        new StringBuilder("markPreloadSurfaceTexture oldSurface:").append(localObject).append(" failed");
        com.tencent.tmediacodec.g.b.bqV("ReuseCodecWrapper");
        continue;
        boolean bool = false;
      }
    }
    this.mSurface = paramSurface;
    this.SlD = "";
    if (paramSurface != null) {
      this.SlD = d.n(paramSurface);
    }
    bqN(this.SlD);
    if (paramSurface != null)
    {
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder().append(this).append(" checkSurfaceBinding size:").append(SlQ.size()).append(" mSurfaceMap:").append(SlQ);
        com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
      }
      if (SlQ.containsKey(paramSurface))
      {
        localObject = (f)SlQ.get(paramSurface);
        if ((localObject == null) || (!((f)localObject).SlE)) {
          break label399;
        }
        bool = true;
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          new StringBuilder().append(this).append(", surface:").append(paramSurface).append(" has been used by ").append(localObject).append(" isReleaseCalled:").append(bool).append(", ignore but we can release it...");
          com.tencent.tmediacodec.g.b.bqU("ReuseCodecWrapper");
        }
        if (bool) {
          ((f)localObject).recycle();
        }
      }
      SlQ.put(paramSurface, this);
      com.tencent.tmediacodec.hook.a.a(this.SlD, new com.tencent.tmediacodec.hook.c()
      {
        public final void s(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(190120);
          if (TextUtils.equals(f.a(f.this), paramAnonymousSurfaceTexture.toString()))
          {
            f.b(f.this).add(paramAnonymousSurfaceTexture);
            new StringBuilder().append(f.this).append("      surfaceDestroyed ... surfaceTexture:").append(paramAnonymousSurfaceTexture).append("     mStoreToRelease.size:").append(f.b(f.this).size());
            com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
          }
          AppMethodBeat.o(190120);
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
  
  public abstract a.b a(e parame);
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if (hpv())
    {
      com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
      return;
    }
    String str;
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      str = this + ", queueInputBuffer index:" + paramInt1 + " offset:0 size:" + paramInt2 + " presentationTimeUs:" + paramLong + ' ' + "flags:" + paramInt3 + " state:" + this.SlF + " decodeState:" + this.SlA;
      com.tencent.tmediacodec.g.b.bqP("ReuseCodecWrapper");
    }
    for (;;)
    {
      try
      {
        if (!this.SlL) {
          break label243;
        }
        switch (4.SlW[this.SlM.ordinal()])
        {
        case 1: 
          this.SlA = b.Smh;
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
        com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
        break;
        this.btk.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
        break;
        this.btk.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
        break;
        label243:
        this.btk.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
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
  
  public final void a(com.tencent.tmediacodec.a.a parama)
  {
    this.SlK = parama;
  }
  
  public final a.b b(e parame)
  {
    this.SlM = a(parame);
    return this.SlM;
  }
  
  public final void configure(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt)
  {
    paramInt = 0;
    if (hpv()) {
      com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
    }
    label218:
    do
    {
      return;
      this.SlN = true;
      for (;;)
      {
        try
        {
          this.SlE = false;
          Object localObject1 = this.SlF;
          Object localObject2 = a.SlX;
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
              localObject2 = this + ", realConfigure mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " crypto:" + paramMediaCrypto + " flags:0" + " state:" + this.SlF + " mHasConfigureCalled：" + this.SlN;
              localObject1 = localObject2;
              com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
            }
            localObject1 = localObject2;
            this.btk.configure(paramMediaFormat, paramSurface, paramMediaCrypto, 0);
            localObject1 = localObject2;
            setSurface(paramSurface);
            localObject1 = localObject2;
            this.SlF = a.SlY;
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
    this.SlP[0] = 0;
    this.SlP[1] = 0;
    c(paramSurface, true);
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    int i = 0;
    if (hpv())
    {
      com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
      return -1;
    }
    Object localObject2 = null;
    String str = null;
    Object localObject1 = localObject2;
    try
    {
      int j = this.btk.dequeueInputBuffer(paramLong);
      localObject1 = localObject2;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        localObject1 = localObject2;
        str = this + ", dequeueInputBuffer state:" + this.SlF + " decodeState:" + this.SlA + " , result=" + j;
        localObject1 = str;
        com.tencent.tmediacodec.g.b.bqP("ReuseCodecWrapper");
      }
      localObject1 = str;
      this.SlA = b.Smg;
      localObject1 = str;
      this.SlF = a.Smb;
      localObject1 = str;
      mL(0, j);
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
  
  public final int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    if (hpv())
    {
      com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
      return -1;
    }
    String str = null;
    Object localObject2 = null;
    Object localObject1 = str;
    int i;
    try
    {
      i = this.btk.dequeueOutputBuffer(paramBufferInfo, paramLong);
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
          com.tencent.tmediacodec.g.b.bqP("ReuseCodecWrapper");
          paramBufferInfo = str;
        }
      }
      localObject1 = paramBufferInfo;
      this.SlH.add(Integer.valueOf(i));
      localObject1 = paramBufferInfo;
      this.SlA = b.Smi;
      localObject1 = paramBufferInfo;
      mL(1, i);
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
  
  public final void flush()
  {
    if (hpv()) {
      com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
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
        str = this + ", flush state:" + this.SlF;
        localObject1 = str;
        com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
      }
      localObject1 = str;
      this.btk.flush();
      localObject1 = str;
      this.SlF = a.Sma;
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
  
  public final MediaCodec hps()
  {
    return this.btk;
  }
  
  public final void hpt()
  {
    long l = Thread.currentThread().getId();
    if (this.SlJ.contains(Long.valueOf(l))) {}
    do
    {
      return;
      this.SlI = l;
      this.SlJ.add(Long.valueOf(this.SlI));
    } while (this.SlJ.size() <= 100);
    this.SlJ.remove(0);
  }
  
  public final void hpu()
  {
    this.SlS = false;
    this.SlT = 0;
    if (this.SlF != a.Sma) {
      flush();
    }
    this.SlL = true;
  }
  
  public boolean hpw()
  {
    return (!this.SlR) && (com.tencent.tmediacodec.a.hpn().Slc);
  }
  
  public final void hpx()
  {
    this.SlT += 1;
  }
  
  public final boolean hpy()
  {
    return this.SlT >= 3;
  }
  
  public final String hpz()
  {
    return this.gJW;
  }
  
  public final void recycle()
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", recycle isRecycled:").append(this.aHN).append(" ...... stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
    }
    this.SlN = false;
    this.aHN = true;
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
        //   6: getfield 17	com/tencent/tmediacodec/b/f$3:SlU	Lcom/tencent/tmediacodec/b/f;
        //   9: invokestatic 34	com/tencent/tmediacodec/b/f:c	(Lcom/tencent/tmediacodec/b/f;)Landroid/media/MediaCodec;
        //   12: invokevirtual 39	android/media/MediaCodec:stop	()V
        //   15: aload_0
        //   16: getfield 17	com/tencent/tmediacodec/b/f$3:SlU	Lcom/tencent/tmediacodec/b/f;
        //   19: invokestatic 34	com/tencent/tmediacodec/b/f:c	(Lcom/tencent/tmediacodec/b/f;)Landroid/media/MediaCodec;
        //   22: invokevirtual 42	android/media/MediaCodec:release	()V
        //   25: aload_0
        //   26: getfield 17	com/tencent/tmediacodec/b/f$3:SlU	Lcom/tencent/tmediacodec/b/f;
        //   29: invokestatic 45	com/tencent/tmediacodec/b/f:d	(Lcom/tencent/tmediacodec/b/f;)V
        //   32: aload_0
        //   33: getfield 17	com/tencent/tmediacodec/b/f$3:SlU	Lcom/tencent/tmediacodec/b/f;
        //   36: invokestatic 49	com/tencent/tmediacodec/b/f:e	(Lcom/tencent/tmediacodec/b/f;)Lcom/tencent/tmediacodec/a/a;
        //   39: ifnull +15 -> 54
        //   42: aload_0
        //   43: getfield 17	com/tencent/tmediacodec/b/f$3:SlU	Lcom/tencent/tmediacodec/b/f;
        //   46: invokestatic 49	com/tencent/tmediacodec/b/f:e	(Lcom/tencent/tmediacodec/b/f;)Lcom/tencent/tmediacodec/a/a;
        //   49: invokeinterface 54 1 0
        //   54: ldc 24
        //   56: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   59: return
        //   60: astore_1
        //   61: aload_0
        //   62: getfield 17	com/tencent/tmediacodec/b/f$3:SlU	Lcom/tencent/tmediacodec/b/f;
        //   65: invokestatic 34	com/tencent/tmediacodec/b/f:c	(Lcom/tencent/tmediacodec/b/f;)Landroid/media/MediaCodec;
        //   68: invokevirtual 42	android/media/MediaCodec:release	()V
        //   71: ldc 24
        //   73: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: aload_1
        //   77: athrow
        //   78: astore_1
        //   79: ldc 59
        //   81: invokestatic 65	com/tencent/tmediacodec/g/b:bqT	(Ljava/lang/String;)V
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
      SlQ.remove(this.mSurface);
    }
    this.SlF = a.SlX;
  }
  
  public final void release()
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(" call release mHoldBufferOutIndex:").append(this.SlH).append(" mReleaseCalled:").append(this.SlE).append(" stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
    }
    this.SlE = true;
    this.SlN = false;
    if (hpw())
    {
      flush();
      com.tencent.tmediacodec.a.hpn().b(this);
      return;
    }
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder("Don't not keep the codec, release it ..., mErrorHappened:").append(this.SlR);
      com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
    }
    com.tencent.tmediacodec.a.hpn().a(this);
    recycle();
    this.SlF = a.Smd;
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if (hpv())
    {
      com.tencent.tmediacodec.g.b.bqS("ReuseCodecWrapper");
      return;
    }
    String str;
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      str = this + ", releaseOutputBuffer render:" + paramBoolean;
      com.tencent.tmediacodec.g.b.bqP("ReuseCodecWrapper");
    }
    for (;;)
    {
      try
      {
        this.SlH.remove(Integer.valueOf(paramInt));
        this.btk.releaseOutputBuffer(paramInt, paramBoolean);
        this.SlA = b.Smj;
        return;
      }
      catch (Throwable localThrowable)
      {
        if (this.SlF != a.Sma)
        {
          new StringBuilder().append(this).append(", releaseOutputBuffer failed, ignore e:");
          com.tencent.tmediacodec.g.b.bqT("ReuseCodecWrapper");
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
  
  @TargetApi(23)
  public final void setOutputSurface(Surface paramSurface)
  {
    c(paramSurface, false);
  }
  
  public final void start()
  {
    if (this.SlF != a.SlY)
    {
      new StringBuilder("start ignore:").append(this.SlF);
      com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
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
          str = this + ", start state:" + this.SlF;
          localObject1 = str;
          com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
        }
        localObject1 = str;
        if (this.SlF == a.SlY)
        {
          localObject1 = str;
          this.btk.start();
          localObject1 = str;
          this.SlF = a.Smb;
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
      com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
    }
    if (!hpw())
    {
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder().append(this).append(", codec real stop");
        com.tencent.tmediacodec.g.b.bqQ("ReuseCodecWrapper");
      }
      this.btk.stop();
      this.SlF = a.SlX;
    }
  }
  
  public String toString()
  {
    return super.toString() + " mReleaseCalled:" + this.SlE + " isRecycled:" + this.aHN;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(190126);
      SlX = new a("Uninitialized", 0);
      SlY = new a("Configured", 1);
      SlZ = new a("Error", 2);
      Sma = new a("Flushed", 3);
      Smb = new a("Running", 4);
      Smc = new a("EndOfStream", 5);
      Smd = new a("Released", 6);
      Sme = new a[] { SlX, SlY, SlZ, Sma, Smb, Smc, Smd };
      AppMethodBeat.o(190126);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(190129);
      Smf = new b("Started", 0);
      Smg = new b("DequeueIn", 1);
      Smh = new b("QueueIn", 2);
      Smi = new b("DequeueOut", 3);
      Smj = new b("ReleaseOut", 4);
      Smk = new b[] { Smf, Smg, Smh, Smi, Smj };
      AppMethodBeat.o(190129);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.b.f
 * JD-Core Version:    0.7.0.1
 */