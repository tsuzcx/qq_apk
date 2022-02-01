package com.tencent.tmediacodec;

import android.annotation.TargetApi;
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
  public boolean ZNU;
  public boolean ZNV;
  public c ZNW;
  public com.tencent.tmediacodec.a.a ZNX;
  private final com.tencent.tmediacodec.f.a ZNY;
  public boolean ZNZ;
  private boolean ZOa;
  final String ZOb;
  b.b ZOc;
  
  private b(String paramString, b.b paramb)
  {
    AppMethodBeat.i(224181);
    this.ZNZ = true;
    this.ZOb = paramString;
    this.ZOc = paramb;
    this.ZNY = new com.tencent.tmediacodec.f.a(d.bJ(this.ZOb));
    AppMethodBeat.o(224181);
  }
  
  public static b bDL(String paramString)
  {
    AppMethodBeat.i(224178);
    paramString = new b(paramString, b.b.ZOe);
    AppMethodBeat.o(224178);
    return paramString;
  }
  
  private void isV()
  {
    AppMethodBeat.i(224190);
    this.ZNY.itl();
    this.ZNY.itm();
    this.ZNY.IE(this.ZNU);
    AppMethodBeat.o(224190);
  }
  
  private void isW()
  {
    AppMethodBeat.i(224192);
    this.ZNY.IF(this.ZNV);
    e.bi(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224123);
        if (b.a(b.this) != null) {
          b.a(b.this).a(b.b(b.this));
        }
        if (b.b(b.this) != null) {
          b.b(b.this).onCreate(Boolean.valueOf(b.this.ZNV));
        }
        AppMethodBeat.o(224123);
      }
    });
    AppMethodBeat.o(224192);
  }
  
  private void isX()
  {
    AppMethodBeat.i(224195);
    this.ZNY.itn();
    e.bi(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224139);
        if (b.b(b.this) != null)
        {
          com.tencent.tmediacodec.a.a locala = b.b(b.this);
          boolean bool = b.this.ZNV;
          com.tencent.tmediacodec.f.a locala1 = b.c(b.this);
          if (TextUtils.isEmpty(locala1.ZPE))
          {
            StringBuilder localStringBuilder = new StringBuilder("{");
            localStringBuilder.append("\"isVideo\":");
            localStringBuilder.append(locala1.ZPF + " ,");
            if (locala1.ZPD)
            {
              localStringBuilder.append("\"isReuse\":");
              localStringBuilder.append(locala1.ZPB + " ,");
            }
            localStringBuilder.append("\"reuseEnable\":");
            localStringBuilder.append(locala1.ZPC + " ,");
            Iterator localIterator = locala1.ZPz.entrySet().iterator();
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
            locala1.ZPE = localStringBuilder.toString();
          }
          locala.onStarted(Boolean.valueOf(bool), locala1.ZPE);
        }
        AppMethodBeat.o(224139);
      }
    });
    AppMethodBeat.o(224195);
  }
  
  public final int EX(long paramLong)
  {
    AppMethodBeat.i(224208);
    if (this.ZNW != null)
    {
      int i = this.ZNW.EX(paramLong);
      AppMethodBeat.o(224208);
      return i;
    }
    AppMethodBeat.o(224208);
    return -1000;
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(224205);
    if (this.ZNW != null) {
      this.ZNW.a(paramInt1, paramInt2, paramLong, paramInt3);
    }
    AppMethodBeat.o(224205);
  }
  
  public final void a(int paramInt1, MediaCodec.CryptoInfo paramCryptoInfo, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(224199);
    if (this.ZNW != null)
    {
      MediaCodec localMediaCodec = this.ZNW.isY();
      if (localMediaCodec != null) {
        localMediaCodec.queueSecureInputBuffer(paramInt1, 0, paramCryptoInfo, paramLong, paramInt2);
      }
    }
    AppMethodBeat.o(224199);
  }
  
  public final void a(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto)
  {
    AppMethodBeat.i(224183);
    if (this.ZOa)
    {
      new StringBuilder("configure ignored, mediaFormat:").append(paramMediaFormat).append(" surface:").append(paramSurface).append(" crypto:").append(paramMediaCrypto).append(" flags:0 stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.bDR("TMediaCodec");
      AppMethodBeat.o(224183);
      return;
    }
    this.ZOa = true;
    isV();
    try
    {
      this.ZNW = a.isT().a(paramMediaFormat, paramSurface, paramMediaCrypto, this);
      isW();
      AppMethodBeat.o(224183);
      return;
    }
    catch (IOException paramSurface)
    {
      for (;;)
      {
        "createCodec mediaFormat:".concat(String.valueOf(paramMediaFormat));
        com.tencent.tmediacodec.g.b.bDU("TMediaCodec");
      }
    }
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(224210);
    if (this.ZNW != null) {
      this.ZNW.releaseOutputBuffer(paramInt, paramBoolean);
    }
    AppMethodBeat.o(224210);
  }
  
  public final void start()
  {
    AppMethodBeat.i(224188);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder("start codecWrapper:").append(this.ZNW);
      com.tencent.tmediacodec.g.b.bDP("TMediaCodec");
    }
    this.ZNY.ZPA = System.currentTimeMillis();
    if (this.ZNW != null) {
      this.ZNW.start();
    }
    isX();
    AppMethodBeat.o(224188);
  }
  
  public static abstract class a
  {
    public abstract void onError(b paramb, MediaCodec.CodecException paramCodecException);
    
    public abstract void onInputBufferAvailable(b paramb, int paramInt);
    
    public abstract void onOutputBufferAvailable(b paramb, int paramInt, MediaCodec.BufferInfo paramBufferInfo);
    
    public abstract void onOutputFormatChanged(b paramb, MediaFormat paramMediaFormat);
  }
  
  @TargetApi(21)
  public static final class c
    extends MediaCodec.Callback
  {
    private final b ZOh;
    private final b.a ZOi;
    
    public c(b paramb, b.a parama)
    {
      this.ZOh = paramb;
      this.ZOi = parama;
    }
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(224165);
      if (this.ZOi != null) {
        this.ZOi.onError(this.ZOh, paramCodecException);
      }
      AppMethodBeat.o(224165);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(224158);
      if (this.ZOi != null) {
        this.ZOi.onInputBufferAvailable(this.ZOh, paramInt);
      }
      AppMethodBeat.o(224158);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(224154);
      if (this.ZOi != null) {
        this.ZOi.onOutputBufferAvailable(this.ZOh, paramInt, paramBufferInfo);
      }
      AppMethodBeat.o(224154);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(224161);
      if (this.ZOi != null) {
        this.ZOi.onOutputFormatChanged(this.ZOh, paramMediaFormat);
      }
      AppMethodBeat.o(224161);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.b
 * JD-Core Version:    0.7.0.1
 */