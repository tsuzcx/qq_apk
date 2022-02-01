package com.tencent.tmediacodec.b;

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
  private static final Map<Surface, f> ahTC = new ConcurrentHashMap();
  public boolean Xvs;
  private final Set<SurfaceTexture> ahTA = new LinkedHashSet();
  private int[] ahTB = new int[2];
  private boolean ahTD = false;
  private boolean ahTE = false;
  private int ahTF = 0;
  public b ahTm = b.ahTR;
  public final e ahTn;
  protected final b ahTo;
  private String ahTp = "";
  private boolean ahTq;
  private a ahTr = a.ahTJ;
  private final a.a ahTs;
  private final HashSet<Integer> ahTt = new HashSet();
  private long ahTu;
  private final ArrayList<Long> ahTv = new ArrayList();
  public com.tencent.tmediacodec.a.a ahTw;
  private boolean ahTx;
  private a.b ahTy = a.b.ahUn;
  private boolean ahTz;
  public boolean cWv;
  public boolean cWw;
  private MediaCodecInfo.CodecCapabilities cWx;
  private final MediaCodec codec;
  protected final String lXB;
  protected Surface mSurface;
  
  public f(MediaCodec paramMediaCodec, e parame)
  {
    this.codec = paramMediaCodec;
    this.ahTn = parame;
    this.ahTo = new b(parame.maxWidth, parame.maxHeight, parame.cGO);
    this.lXB = d.a(this.codec);
    paramMediaCodec = this.lXB;
    if ((Build.VERSION.SDK_INT <= 25) && ("OMX.Exynos.avc.dec.secure" == paramMediaCodec) && ((Build.MODEL.startsWith("SM-T585")) || (Build.MODEL.startsWith("SM-A510")) || (Build.MODEL.startsWith("SM-A520")) || (Build.MODEL.startsWith("SM-J700"))))
    {
      paramMediaCodec = a.a.ahUl;
      this.ahTs = paramMediaCodec;
      if (Build.VERSION.SDK_INT >= 18) {
        this.cWx = this.codec.getCodecInfo().getCapabilitiesForType(parame.cGN);
      }
      if ((this.cWx == null) || (!d.isAdaptive(this.cWx))) {
        break label347;
      }
      bool1 = true;
      label250:
      this.cWv = bool1;
      if ((this.cWx == null) || (!d.isSecure(this.cWx))) {
        break label352;
      }
    }
    label347:
    label352:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cWw = bool1;
      return;
      if ((Build.VERSION.SDK_INT < 24) && (("OMX.Nvidia.h264.decode" == paramMediaCodec) || ("OMX.Nvidia.h264.decode.secure" == paramMediaCodec)) && (("flounder" == Build.DEVICE) || ("flounder_lte" == Build.DEVICE) || ("grouper" == Build.DEVICE) || ("tilapia" == Build.DEVICE)))
      {
        paramMediaCodec = a.a.ahUk;
        break;
      }
      paramMediaCodec = a.a.ahUj;
      break;
      bool1 = false;
      break label250;
    }
  }
  
  private void L(Set paramSet)
  {
    e(paramSet, Collections.emptySet());
  }
  
  private void OF(boolean paramBoolean)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", releaseStoreSurfaceTexture mStoreToRelease:").append(this.ahTA);
      com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
    }
    final ArrayList localArrayList;
    if (!this.ahTA.isEmpty())
    {
      localArrayList = new ArrayList(this.ahTA);
      this.ahTA.clear();
      if (paramBoolean) {
        com.tencent.tmediacodec.g.e.execute(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210787);
            f.a(f.this, localArrayList);
            AppMethodBeat.o(210787);
          }
        });
      }
    }
    else
    {
      return;
    }
    ov(localArrayList);
  }
  
  public static c a(MediaCodec paramMediaCodec, String paramString, e parame)
  {
    if (d.isVideo(paramString)) {
      return new g(paramMediaCodec, parame);
    }
    return new a(paramMediaCodec, parame);
  }
  
  private void a(int paramInt, String paramString, Throwable paramThrowable, boolean paramBoolean, Surface paramSurface)
  {
    this.ahTD = true;
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
        int j = w(paramSurface);
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
        if (this.ahTw != null) {
          this.ahTw.onReuseCodecAPIException(paramSurface.toString(), paramThrowable);
        }
        label118:
        new StringBuilder("hasReused:").append(this.ahTx).append("    errorCode:").append(i).append(", ").append(paramString);
        com.tencent.tmediacodec.g.b.U("ReuseCodecWrapper");
        aIY(i);
        return;
        str = paramThrowable.getLocalizedMessage();
      }
      catch (JSONException paramThrowable)
      {
        break label118;
      }
    }
  }
  
  private void aIY(int paramInt)
  {
    if (paramInt < 40000) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        new StringBuilder().append(this).append("    releaseCodecWhenError, errorCode:").append(paramInt);
        com.tencent.tmediacodec.g.b.T("ReuseCodecWrapper");
        release();
      }
      return;
    }
  }
  
  private final void bGr(String paramString)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", removeStoreSurfaceTexture nameSurfaceTexture:").append(paramString);
      com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
    }
    Iterator localIterator = this.ahTA.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(localIterator.next().toString(), paramString)) {
        localIterator.remove();
      }
    }
  }
  
  private void c(Surface paramSurface, boolean paramBoolean)
  {
    if (this.mSurface == paramSurface)
    {
      new StringBuilder().append(this).append(", innerSetOutputSurface error surface:").append(paramSurface).append(" is same, stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.R("ReuseCodecWrapper");
      return;
    }
    String str = null;
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      str = this + " configure, call innerSetOutputSurface surface:" + paramSurface + "  decodeState:" + this.ahTm + " callByInner:" + paramBoolean;
      com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
    }
    try
    {
      setSurface(paramSurface);
      this.codec.setOutputSurface(paramSurface);
      OF(true);
      return;
    }
    finally
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
  
  private void e(Set paramSet1, Set paramSet2)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", removeSurfaceBinding toReleaseNameSet:").append(paramSet1).append(" toReleaseCodecSet:").append(paramSet2);
      com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
    }
    Iterator localIterator = ahTC.entrySet().iterator();
    label147:
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = d.x((Surface)localEntry.getKey());
      if ((paramSet1.contains(str)) || (paramSet2.contains(localEntry.getValue()))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label147;
        }
        localIterator.remove();
        com.tencent.tmediacodec.hook.a.bGs(str);
        break;
      }
    }
  }
  
  private void f(int paramInt, String paramString, Throwable paramThrowable)
  {
    a(paramInt, paramString, paramThrowable, false, this.mSurface);
  }
  
  private boolean kcv()
  {
    return Thread.currentThread().getId() != this.ahTu;
  }
  
  private final void ov(List<SurfaceTexture> paramList)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", releaseSurfaceTexture toReleaseSet:").append(paramList);
      com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SurfaceTexture localSurfaceTexture = (SurfaceTexture)paramList.next();
      com.tencent.tmediacodec.hook.a.y(localSurfaceTexture);
      localLinkedHashSet.add(localSurfaceTexture.toString());
    }
    L(localLinkedHashSet);
  }
  
  private void qa(int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((!this.ahTE) && (qb(paramInt1, paramInt2)))
    {
      this.ahTE = true;
      StringBuilder localStringBuilder = new StringBuilder().append(this).append(", trackDecodeApi state:").append(this.ahTr).append("  surfaceState:");
      if (this.mSurface == null) {
        break label95;
      }
      localObject = Boolean.valueOf(this.mSurface.isValid());
      localObject = localObject;
      if (paramInt1 != 0) {
        break label100;
      }
      f(40002, (String)localObject, null);
    }
    label95:
    label100:
    while (paramInt1 != 1)
    {
      return;
      localObject = null;
      break;
    }
    f(60002, (String)localObject, null);
  }
  
  private boolean qb(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 == -1)
    {
      int[] arrayOfInt = this.ahTB;
      arrayOfInt[paramInt1] += 1;
      if (this.ahTB[paramInt1] > 100) {
        bool = true;
      }
      return bool;
    }
    this.ahTB[paramInt1] = 0;
    return false;
  }
  
  private final void setSurface(Surface paramSurface)
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", oldSurface:").append(this.mSurface).append(" CodecWrapperSetSurface surface:").append(paramSurface);
      com.tencent.tmediacodec.g.b.Q("ReuseCodecWrapper");
    }
    com.tencent.tmediacodec.hook.a.bGs(this.ahTp);
    L(new HashSet(Collections.singletonList(this.ahTp)));
    localObject1 = this.mSurface;
    try
    {
      if ((localObject1 instanceof PreloadSurface))
      {
        SurfaceTexture localSurfaceTexture = ((PreloadSurface)localObject1).surfaceTexture;
        if ((localSurfaceTexture instanceof com.tencent.tmediacodec.hook.b)) {
          this.ahTA.add(localSurfaceTexture);
        }
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          new StringBuilder("markPreloadSurfaceTexture oldSurface:").append(localObject1).append(" success");
          com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
        }
      }
    }
    finally
    {
      for (;;)
      {
        new StringBuilder("markPreloadSurfaceTexture oldSurface:").append(localObject1).append(" failed");
        com.tencent.tmediacodec.g.b.U("ReuseCodecWrapper");
        continue;
        boolean bool = false;
      }
    }
    this.mSurface = paramSurface;
    this.ahTp = "";
    if (paramSurface != null) {
      this.ahTp = d.x(paramSurface);
    }
    bGr(this.ahTp);
    if (paramSurface != null)
    {
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder().append(this).append(" checkSurfaceBinding size:").append(ahTC.size()).append(" mSurfaceMap:").append(ahTC);
        com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
      }
      if (ahTC.containsKey(paramSurface))
      {
        localObject1 = (f)ahTC.get(paramSurface);
        if ((localObject1 == null) || (!((f)localObject1).ahTq)) {
          break label399;
        }
        bool = true;
        if (com.tencent.tmediacodec.g.b.isLogEnable())
        {
          new StringBuilder().append(this).append(", surface:").append(paramSurface).append(" has been used by ").append(localObject1).append(" isReleaseCalled:").append(bool).append(", ignore but we can release it...");
          com.tencent.tmediacodec.g.b.T("ReuseCodecWrapper");
        }
        if (bool) {
          ((f)localObject1).recycle();
        }
      }
      ahTC.put(paramSurface, this);
      com.tencent.tmediacodec.hook.a.a(this.ahTp, new com.tencent.tmediacodec.hook.c()
      {
        public final void x(SurfaceTexture paramAnonymousSurfaceTexture)
        {
          AppMethodBeat.i(210795);
          if (TextUtils.equals(f.a(f.this), paramAnonymousSurfaceTexture.toString()))
          {
            f.b(f.this).add(paramAnonymousSurfaceTexture);
            new StringBuilder().append(f.this).append("      surfaceDestroyed ... surfaceTexture:").append(paramAnonymousSurfaceTexture).append("     mStoreToRelease.size:").append(f.b(f.this).size());
            com.tencent.tmediacodec.g.b.R("ReuseCodecWrapper");
          }
          AppMethodBeat.o(210795);
        }
      });
    }
    else
    {
      return;
    }
  }
  
  private static int w(Surface paramSurface)
  {
    if (paramSurface == null) {
      return 10003;
    }
    if (!paramSurface.isValid()) {
      return 10004;
    }
    return 0;
  }
  
  public abstract a.b a(e parame);
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if (kcv())
    {
      com.tencent.tmediacodec.g.b.R("ReuseCodecWrapper");
      return;
    }
    String str;
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      str = this + ", queueInputBuffer index:" + paramInt1 + " offset:0 size:" + paramInt2 + " presentationTimeUs:" + paramLong + ' ' + "flags:" + paramInt3 + " state:" + this.ahTr + " decodeState:" + this.ahTm;
      com.tencent.tmediacodec.g.b.bGt("ReuseCodecWrapper");
    }
    for (;;)
    {
      try
      {
        if (!this.ahTx) {
          break label243;
        }
        switch (4.ahTI[this.ahTy.ordinal()])
        {
        case 1: 
          this.ahTm = b.ahTT;
          return;
        }
      }
      finally
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
        f(paramInt1, str, localThrowable);
        throw localThrowable;
        com.tencent.tmediacodec.g.b.R("ReuseCodecWrapper");
        break;
        this.codec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
        break;
        this.codec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
        break;
        label243:
        this.codec.queueInputBuffer(paramInt1, 0, paramInt2, paramLong, paramInt3);
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
    this.ahTw = parama;
  }
  
  public final a.b b(e parame)
  {
    this.ahTy = a(parame);
    return this.ahTy;
  }
  
  public final void configure(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt)
  {
    paramInt = 0;
    if (kcv()) {
      com.tencent.tmediacodec.g.b.R("ReuseCodecWrapper");
    }
    label218:
    do
    {
      return;
      this.ahTz = true;
      for (;;)
      {
        try
        {
          this.ahTq = false;
          Object localObject1 = this.ahTr;
          Object localObject2 = a.ahTJ;
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
              localObject2 = this + ", realConfigure mediaFormat:" + paramMediaFormat + " surface:" + paramSurface + " crypto:" + paramMediaCrypto + " flags:0" + " state:" + this.ahTr + " mHasConfigureCalled：" + this.ahTz;
              localObject1 = localObject2;
              com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
            }
            localObject1 = localObject2;
            this.codec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, 0);
            localObject1 = localObject2;
            setSurface(paramSurface);
            localObject1 = localObject2;
            this.ahTr = a.ahTK;
            return;
          }
          finally
          {
            if (!(paramMediaFormat instanceof IllegalStateException)) {
              break label218;
            }
          }
          paramInt = 10000;
          a(paramInt, (String)localObject1, paramMediaFormat, true, paramSurface);
          throw paramMediaFormat;
        }
        finally {}
        if ((paramMediaFormat instanceof MediaCodec.CryptoException)) {
          paramInt = 10001;
        }
      }
    } while (paramSurface == null);
    this.ahTB[0] = 0;
    this.ahTB[1] = 0;
    c(paramSurface, true);
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    int i = 0;
    if (kcv())
    {
      com.tencent.tmediacodec.g.b.R("ReuseCodecWrapper");
      return -1;
    }
    Object localObject2 = null;
    String str = null;
    Object localObject1 = localObject2;
    try
    {
      int j = this.codec.dequeueInputBuffer(paramLong);
      localObject1 = localObject2;
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        localObject1 = localObject2;
        str = this + ", dequeueInputBuffer state:" + this.ahTr + " decodeState:" + this.ahTm + " , result=" + j;
        localObject1 = str;
        com.tencent.tmediacodec.g.b.bGt("ReuseCodecWrapper");
      }
      localObject1 = str;
      this.ahTm = b.ahTS;
      localObject1 = str;
      this.ahTr = a.ahTN;
      localObject1 = str;
      qa(0, j);
      return j;
    }
    finally
    {
      if (!(localThrowable instanceof IllegalStateException)) {
        break label176;
      }
    }
    i = 40000;
    for (;;)
    {
      f(i, (String)localObject1, localThrowable);
      throw localThrowable;
      label176:
      if ((localThrowable instanceof IllegalArgumentException)) {
        i = 40001;
      }
    }
  }
  
  public final int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    if (kcv())
    {
      com.tencent.tmediacodec.g.b.R("ReuseCodecWrapper");
      return -1;
    }
    String str = null;
    Object localObject2 = null;
    Object localObject1 = str;
    int i;
    try
    {
      i = this.codec.dequeueOutputBuffer(paramBufferInfo, paramLong);
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
          com.tencent.tmediacodec.g.b.bGt("ReuseCodecWrapper");
          paramBufferInfo = str;
        }
      }
      localObject1 = paramBufferInfo;
      this.ahTt.add(Integer.valueOf(i));
      localObject1 = paramBufferInfo;
      this.ahTm = b.ahTU;
      localObject1 = paramBufferInfo;
      qa(1, i);
      return i;
    }
    finally
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
      f(i, (String)localObject1, paramBufferInfo);
      throw paramBufferInfo;
      label181:
      if ((paramBufferInfo instanceof IllegalStateException)) {
        i = 60000;
      }
    }
  }
  
  public final void flush()
  {
    if (kcv()) {
      com.tencent.tmediacodec.g.b.R("ReuseCodecWrapper");
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
        str = this + ", flush state:" + this.ahTr;
        localObject1 = str;
        com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
      }
      localObject1 = str;
      this.codec.flush();
      localObject1 = str;
      this.ahTr = a.ahTM;
      return;
    }
    finally
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
      f(i, (String)localObject1, localThrowable);
      throw localThrowable;
      label116:
      if ((localThrowable instanceof IllegalStateException)) {
        i = 90000;
      }
    }
  }
  
  public final MediaCodec kcs()
  {
    return this.codec;
  }
  
  public final void kct()
  {
    long l = Thread.currentThread().getId();
    if (this.ahTv.contains(Long.valueOf(l))) {}
    do
    {
      return;
      this.ahTu = l;
      this.ahTv.add(Long.valueOf(this.ahTu));
    } while (this.ahTv.size() <= 100);
    this.ahTv.remove(0);
  }
  
  public final void kcu()
  {
    this.ahTE = false;
    this.ahTF = 0;
    if (this.ahTr != a.ahTM) {
      flush();
    }
    this.ahTx = true;
  }
  
  public boolean kcw()
  {
    return (!this.ahTD) && (com.tencent.tmediacodec.a.kcn().ahSO);
  }
  
  public final void kcx()
  {
    this.ahTF += 1;
  }
  
  public final boolean kcy()
  {
    return this.ahTF >= 3;
  }
  
  public final String kcz()
  {
    return this.lXB;
  }
  
  public final void recycle()
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(", recycle isRecycled:").append(this.Xvs).append(" ...... stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
    }
    this.ahTz = false;
    this.Xvs = true;
    e(Collections.emptySet(), Collections.singleton(this));
    com.tencent.tmediacodec.g.e.runOnSubThread(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 22
        //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: aload_0
        //   6: getfield 17	com/tencent/tmediacodec/b/f$3:ahTG	Lcom/tencent/tmediacodec/b/f;
        //   9: invokestatic 32	com/tencent/tmediacodec/b/f:c	(Lcom/tencent/tmediacodec/b/f;)Landroid/media/MediaCodec;
        //   12: invokevirtual 37	android/media/MediaCodec:stop	()V
        //   15: aload_0
        //   16: getfield 17	com/tencent/tmediacodec/b/f$3:ahTG	Lcom/tencent/tmediacodec/b/f;
        //   19: invokestatic 32	com/tencent/tmediacodec/b/f:c	(Lcom/tencent/tmediacodec/b/f;)Landroid/media/MediaCodec;
        //   22: invokevirtual 40	android/media/MediaCodec:release	()V
        //   25: aload_0
        //   26: getfield 17	com/tencent/tmediacodec/b/f$3:ahTG	Lcom/tencent/tmediacodec/b/f;
        //   29: invokestatic 43	com/tencent/tmediacodec/b/f:d	(Lcom/tencent/tmediacodec/b/f;)V
        //   32: aload_0
        //   33: getfield 17	com/tencent/tmediacodec/b/f$3:ahTG	Lcom/tencent/tmediacodec/b/f;
        //   36: invokestatic 47	com/tencent/tmediacodec/b/f:e	(Lcom/tencent/tmediacodec/b/f;)Lcom/tencent/tmediacodec/a/a;
        //   39: ifnull +15 -> 54
        //   42: aload_0
        //   43: getfield 17	com/tencent/tmediacodec/b/f$3:ahTG	Lcom/tencent/tmediacodec/b/f;
        //   46: invokestatic 47	com/tencent/tmediacodec/b/f:e	(Lcom/tencent/tmediacodec/b/f;)Lcom/tencent/tmediacodec/a/a;
        //   49: invokeinterface 52 1 0
        //   54: ldc 22
        //   56: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   59: return
        //   60: astore_1
        //   61: aload_0
        //   62: getfield 17	com/tencent/tmediacodec/b/f$3:ahTG	Lcom/tencent/tmediacodec/b/f;
        //   65: invokestatic 32	com/tencent/tmediacodec/b/f:c	(Lcom/tencent/tmediacodec/b/f;)Landroid/media/MediaCodec;
        //   68: invokevirtual 40	android/media/MediaCodec:release	()V
        //   71: ldc 22
        //   73: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   76: aload_1
        //   77: athrow
        //   78: astore_1
        //   79: ldc 57
        //   81: invokestatic 63	com/tencent/tmediacodec/g/b:S	(Ljava/lang/String;)V
        //   84: goto -52 -> 32
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	87	0	this	3
        //   60	17	1	localObject1	Object
        //   78	1	1	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   5	15	60	finally
        //   15	32	78	finally
        //   61	78	78	finally
      }
    });
    if (this.mSurface != null) {
      ahTC.remove(this.mSurface);
    }
    this.ahTr = a.ahTJ;
  }
  
  public final void release()
  {
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder().append(this).append(" call release mHoldBufferOutIndex:").append(this.ahTt).append(" mReleaseCalled:").append(this.ahTq).append(" stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
    }
    this.ahTq = true;
    this.ahTz = false;
    if (kcw())
    {
      flush();
      com.tencent.tmediacodec.a.kcn().b(this);
      return;
    }
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder("Don't not keep the codec, release it ..., mErrorHappened:").append(this.ahTD);
      com.tencent.tmediacodec.g.b.R("ReuseCodecWrapper");
    }
    com.tencent.tmediacodec.a.kcn().a(this);
    recycle();
    this.ahTr = a.ahTP;
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if (kcv())
    {
      com.tencent.tmediacodec.g.b.R("ReuseCodecWrapper");
      return;
    }
    String str;
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      str = this + ", releaseOutputBuffer render:" + paramBoolean;
      com.tencent.tmediacodec.g.b.bGt("ReuseCodecWrapper");
    }
    for (;;)
    {
      try
      {
        this.ahTt.remove(Integer.valueOf(paramInt));
        this.codec.releaseOutputBuffer(paramInt, paramBoolean);
        this.ahTm = b.ahTV;
        return;
      }
      finally
      {
        if (this.ahTr != a.ahTM)
        {
          new StringBuilder().append(this).append(", releaseOutputBuffer failed, ignore e:");
          com.tencent.tmediacodec.g.b.S("ReuseCodecWrapper");
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
        f(paramInt, str, localThrowable);
        break;
        label149:
        if ((localThrowable instanceof IllegalStateException)) {
          paramInt = 70001;
        }
      }
      str = null;
    }
  }
  
  public final void setOutputSurface(Surface paramSurface)
  {
    c(paramSurface, false);
  }
  
  public final void start()
  {
    if (this.ahTr != a.ahTK)
    {
      new StringBuilder("start ignore:").append(this.ahTr);
      com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
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
          str = this + ", start state:" + this.ahTr;
          localObject1 = str;
          com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
        }
        localObject1 = str;
        if (this.ahTr == a.ahTK)
        {
          localObject1 = str;
          this.codec.start();
          localObject1 = str;
          this.ahTr = a.ahTN;
          return;
        }
      }
      finally
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
      f(i, (String)localObject1, localThrowable);
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
      com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
    }
    if (!kcw())
    {
      if (com.tencent.tmediacodec.g.b.isLogEnable())
      {
        new StringBuilder().append(this).append(", codec real stop");
        com.tencent.tmediacodec.g.b.O("ReuseCodecWrapper");
      }
      this.codec.stop();
      this.ahTr = a.ahTJ;
    }
  }
  
  public String toString()
  {
    return super.toString() + " mReleaseCalled:" + this.ahTq + " isRecycled:" + this.Xvs;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(210784);
      ahTJ = new a("Uninitialized", 0);
      ahTK = new a("Configured", 1);
      ahTL = new a("Error", 2);
      ahTM = new a("Flushed", 3);
      ahTN = new a("Running", 4);
      ahTO = new a("EndOfStream", 5);
      ahTP = new a("Released", 6);
      ahTQ = new a[] { ahTJ, ahTK, ahTL, ahTM, ahTN, ahTO, ahTP };
      AppMethodBeat.o(210784);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(210790);
      ahTR = new b("Started", 0);
      ahTS = new b("DequeueIn", 1);
      ahTT = new b("QueueIn", 2);
      ahTU = new b("DequeueOut", 3);
      ahTV = new b("ReleaseOut", 4);
      ahTW = new b[] { ahTR, ahTS, ahTT, ahTU, ahTV };
      AppMethodBeat.o(210790);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b.f
 * JD-Core Version:    0.7.0.1
 */