package com.tencent.tmediacodec;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.Callback;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.b.c;
import com.tencent.tmediacodec.g.d;
import com.tencent.tmediacodec.g.e;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  public boolean ahSV;
  public boolean ahSW;
  public c ahSX;
  public com.tencent.tmediacodec.a.a ahSY;
  private final com.tencent.tmediacodec.f.a ahSZ;
  public boolean ahTa;
  private boolean ahTb;
  final String ahTc;
  b.b ahTd;
  
  private b(String paramString, b.b paramb)
  {
    AppMethodBeat.i(210733);
    this.ahTa = true;
    this.ahTc = paramString;
    this.ahTd = paramb;
    this.ahSZ = new com.tencent.tmediacodec.f.a(d.isVideo(this.ahTc));
    AppMethodBeat.o(210733);
  }
  
  public static b bGq(String paramString)
  {
    AppMethodBeat.i(210730);
    paramString = new b(paramString, b.b.ahTf);
    AppMethodBeat.o(210730);
    return paramString;
  }
  
  private void kcp()
  {
    AppMethodBeat.i(210741);
    this.ahSZ.kcF();
    this.ahSZ.kcG();
    this.ahSZ.OG(this.ahSV);
    AppMethodBeat.o(210741);
  }
  
  private void kcq()
  {
    AppMethodBeat.i(210747);
    this.ahSZ.OH(this.ahSW);
    e.br(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210737);
        if (b.a(b.this) != null) {
          b.a(b.this).a(b.b(b.this));
        }
        if (b.b(b.this) != null) {
          b.b(b.this).onCreate(Boolean.valueOf(b.this.ahSW));
        }
        AppMethodBeat.o(210737);
      }
    });
    AppMethodBeat.o(210747);
  }
  
  private void kcr()
  {
    AppMethodBeat.i(210752);
    this.ahSZ.kcH();
    e.br(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210739);
        if (b.b(b.this) != null)
        {
          com.tencent.tmediacodec.a.a locala = b.b(b.this);
          boolean bool = b.this.ahSW;
          com.tencent.tmediacodec.f.a locala1 = b.c(b.this);
          if (TextUtils.isEmpty(locala1.ahUF))
          {
            StringBuilder localStringBuilder = new StringBuilder("{");
            localStringBuilder.append("\"isVideo\":");
            localStringBuilder.append(locala1.ahUG + " ,");
            if (locala1.ahUE)
            {
              localStringBuilder.append("\"isReuse\":");
              localStringBuilder.append(locala1.ahUC + " ,");
            }
            localStringBuilder.append("\"reuseEnable\":");
            localStringBuilder.append(locala1.ahUD + " ,");
            Iterator localIterator = locala1.ahUA.entrySet().iterator();
            long l2;
            for (long l1 = 0L; localIterator.hasNext(); l1 = l2)
            {
              Map.Entry localEntry = (Map.Entry)localIterator.next();
              l2 = l1;
              if (localEntry != null) {
                l2 = l1 + ((Number)localEntry.getValue()).longValue();
              }
              localStringBuilder.append("\"" + localEntry.getKey() + "\":");
              localStringBuilder.append(((Number)localEntry.getValue()).longValue() + " ,");
            }
            localStringBuilder.append("\"totalCodec\":");
            localStringBuilder.append(l1);
            localStringBuilder.append("}");
            locala1.ahUF = localStringBuilder.toString();
          }
          locala.onStarted(Boolean.valueOf(bool), locala1.ahUF);
        }
        AppMethodBeat.o(210739);
      }
    });
    AppMethodBeat.o(210752);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(210818);
    if (this.ahSX != null) {
      this.ahSX.a(paramInt1, paramInt2, paramLong, paramInt3);
    }
    AppMethodBeat.o(210818);
  }
  
  public final void a(int paramInt1, MediaCodec.CryptoInfo paramCryptoInfo, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(210813);
    if (this.ahSX != null)
    {
      MediaCodec localMediaCodec = this.ahSX.kcs();
      if (localMediaCodec != null) {
        localMediaCodec.queueSecureInputBuffer(paramInt1, 0, paramCryptoInfo, paramLong, paramInt2);
      }
    }
    AppMethodBeat.o(210813);
  }
  
  public final void a(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto)
  {
    AppMethodBeat.i(210781);
    if (this.ahTb)
    {
      new StringBuilder("configure ignored, mediaFormat:").append(paramMediaFormat).append(" surface:").append(paramSurface).append(" crypto:").append(paramMediaCrypto).append(" flags:0 stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.R("TMediaCodec");
      AppMethodBeat.o(210781);
      return;
    }
    this.ahTb = true;
    kcp();
    try
    {
      this.ahSX = a.kcn().a(paramMediaFormat, paramSurface, paramMediaCrypto, this);
      kcq();
      AppMethodBeat.o(210781);
      return;
    }
    catch (IOException paramSurface)
    {
      for (;;)
      {
        "createCodec mediaFormat:".concat(String.valueOf(paramMediaFormat));
        com.tencent.tmediacodec.g.b.U("TMediaCodec");
      }
    }
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    AppMethodBeat.i(210826);
    if (this.ahSX != null)
    {
      int i = this.ahSX.dequeueInputBuffer(paramLong);
      AppMethodBeat.o(210826);
      return i;
    }
    AppMethodBeat.o(210826);
    return -1000;
  }
  
  public final void release()
  {
    AppMethodBeat.i(210792);
    if (this.ahSX != null) {
      this.ahSX.release();
    }
    AppMethodBeat.o(210792);
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(210832);
    if (this.ahSX != null) {
      this.ahSX.releaseOutputBuffer(paramInt, paramBoolean);
    }
    AppMethodBeat.o(210832);
  }
  
  public final void start()
  {
    AppMethodBeat.i(210785);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder("start codecWrapper:").append(this.ahSX);
      com.tencent.tmediacodec.g.b.O("TMediaCodec");
    }
    this.ahSZ.ahUB = System.currentTimeMillis();
    if (this.ahSX != null) {
      this.ahSX.start();
    }
    kcr();
    AppMethodBeat.o(210785);
  }
  
  public static abstract class a
  {
    public abstract void onError(b paramb, MediaCodec.CodecException paramCodecException);
    
    public abstract void onInputBufferAvailable(b paramb, int paramInt);
    
    public abstract void onOutputBufferAvailable(b paramb, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
    
    public abstract void onOutputFormatChanged(b paramb, MediaFormat paramMediaFormat);
  }
  
  public static final class c
    extends MediaCodec.Callback
  {
    private final b ahTi;
    private final b.a ahTj;
    
    public c(b paramb, b.a parama)
    {
      this.ahTi = paramb;
      this.ahTj = parama;
    }
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(210854);
      if (this.ahTj != null) {
        this.ahTj.onError(this.ahTi, paramCodecException);
      }
      AppMethodBeat.o(210854);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(210840);
      if (this.ahTj != null) {
        this.ahTj.onInputBufferAvailable(this.ahTi, paramInt);
      }
      AppMethodBeat.o(210840);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(210834);
      if (this.ahTj != null) {
        this.ahTj.onOutputBufferAvailable(this.ahTi, paramInt, paramBufferInfo);
      }
      AppMethodBeat.o(210834);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(210846);
      if (this.ahTj != null) {
        this.ahTj.onOutputFormatChanged(this.ahTi, paramMediaFormat);
      }
      AppMethodBeat.o(210846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b
 * JD-Core Version:    0.7.0.1
 */