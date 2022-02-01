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
  public boolean Slj;
  public boolean Slk;
  public c Sll;
  public com.tencent.tmediacodec.a.a Slm;
  final com.tencent.tmediacodec.f.a Sln;
  public boolean Slo;
  private boolean Slp;
  final String Slq;
  b.b Slr;
  
  public b(String paramString, b.b paramb)
  {
    AppMethodBeat.i(190089);
    this.Slo = true;
    this.Slq = paramString;
    this.Slr = paramb;
    this.Sln = new com.tencent.tmediacodec.f.a(d.by(this.Slq));
    AppMethodBeat.o(190089);
  }
  
  private void hpp()
  {
    AppMethodBeat.i(190092);
    this.Sln.hpE();
    this.Sln.hpF();
    this.Sln.Ed(this.Slj);
    AppMethodBeat.o(190092);
  }
  
  private void hpq()
  {
    AppMethodBeat.i(190093);
    this.Sln.Ee(this.Slk);
    e.bb(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190080);
        if (b.this.Sll != null) {
          b.this.Sll.a(b.this.Slm);
        }
        if (b.this.Slm != null) {
          b.this.Slm.onCreate(Boolean.valueOf(b.this.Slk));
        }
        AppMethodBeat.o(190080);
      }
    });
    AppMethodBeat.o(190093);
  }
  
  private void hpr()
  {
    AppMethodBeat.i(190094);
    this.Sln.hpG();
    e.bb(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190081);
        if (b.this.Slm != null)
        {
          com.tencent.tmediacodec.a.a locala = b.this.Slm;
          boolean bool = b.this.Slk;
          com.tencent.tmediacodec.f.a locala1 = b.this.Sln;
          if (TextUtils.isEmpty(locala1.SmT))
          {
            StringBuilder localStringBuilder = new StringBuilder("{");
            localStringBuilder.append("\"isVideo\":");
            localStringBuilder.append(locala1.SmU + " ,");
            if (locala1.SmS)
            {
              localStringBuilder.append("\"isReuse\":");
              localStringBuilder.append(locala1.SmQ + " ,");
            }
            localStringBuilder.append("\"reuseEnable\":");
            localStringBuilder.append(locala1.SmR + " ,");
            Iterator localIterator = locala1.SmO.entrySet().iterator();
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
            locala1.SmT = localStringBuilder.toString();
          }
          locala.onStarted(Boolean.valueOf(bool), locala1.SmT);
        }
        AppMethodBeat.o(190081);
      }
    });
    AppMethodBeat.o(190094);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(190096);
    if (this.Sll != null) {
      this.Sll.a(paramInt1, paramInt2, paramLong, paramInt3);
    }
    AppMethodBeat.o(190096);
  }
  
  public final void a(int paramInt1, MediaCodec.CryptoInfo paramCryptoInfo, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(190095);
    if (this.Sll != null)
    {
      MediaCodec localMediaCodec = this.Sll.hps();
      if (localMediaCodec != null) {
        localMediaCodec.queueSecureInputBuffer(paramInt1, 0, paramCryptoInfo, paramLong, paramInt2);
      }
    }
    AppMethodBeat.o(190095);
  }
  
  public final void a(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto)
  {
    AppMethodBeat.i(190090);
    if (this.Slp)
    {
      new StringBuilder("configure ignored, mediaFormat:").append(paramMediaFormat).append(" surface:").append(paramSurface).append(" crypto:").append(paramMediaCrypto).append(" flags:0 stack:").append(Log.getStackTraceString(new Throwable()));
      com.tencent.tmediacodec.g.b.bqS("TMediaCodec");
      AppMethodBeat.o(190090);
      return;
    }
    this.Slp = true;
    hpp();
    try
    {
      this.Sll = a.hpn().a(paramMediaFormat, paramSurface, paramMediaCrypto, this);
      hpq();
      AppMethodBeat.o(190090);
      return;
    }
    catch (IOException paramSurface)
    {
      for (;;)
      {
        "createCodec mediaFormat:".concat(String.valueOf(paramMediaFormat));
        com.tencent.tmediacodec.g.b.bqV("TMediaCodec");
      }
    }
  }
  
  public final int dequeueInputBuffer(long paramLong)
  {
    AppMethodBeat.i(190097);
    if (this.Sll != null)
    {
      int i = this.Sll.dequeueInputBuffer(paramLong);
      AppMethodBeat.o(190097);
      return i;
    }
    AppMethodBeat.o(190097);
    return -1000;
  }
  
  public final void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(190098);
    if (this.Sll != null) {
      this.Sll.releaseOutputBuffer(paramInt, paramBoolean);
    }
    AppMethodBeat.o(190098);
  }
  
  public final void start()
  {
    AppMethodBeat.i(190091);
    if (com.tencent.tmediacodec.g.b.isLogEnable())
    {
      new StringBuilder("start codecWrapper:").append(this.Sll);
      com.tencent.tmediacodec.g.b.bqQ("TMediaCodec");
    }
    this.Sln.SmP = System.currentTimeMillis();
    if (this.Sll != null) {
      this.Sll.start();
    }
    hpr();
    AppMethodBeat.o(190091);
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
    private final b Slw;
    private final b.a Slx;
    
    public c(b paramb, b.a parama)
    {
      this.Slw = paramb;
      this.Slx = parama;
    }
    
    public final void onError(MediaCodec paramMediaCodec, MediaCodec.CodecException paramCodecException)
    {
      AppMethodBeat.i(190088);
      if (this.Slx != null) {
        this.Slx.onError(this.Slw, paramCodecException);
      }
      AppMethodBeat.o(190088);
    }
    
    public final void onInputBufferAvailable(MediaCodec paramMediaCodec, int paramInt)
    {
      AppMethodBeat.i(190086);
      if (this.Slx != null) {
        this.Slx.onInputBufferAvailable(this.Slw, paramInt);
      }
      AppMethodBeat.o(190086);
    }
    
    public final void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
    {
      AppMethodBeat.i(190085);
      if (this.Slx != null) {
        this.Slx.onOutputBufferAvailable(this.Slw, paramInt, paramBufferInfo);
      }
      AppMethodBeat.o(190085);
    }
    
    public final void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
    {
      AppMethodBeat.i(190087);
      if (this.Slx != null) {
        this.Slx.onOutputFormatChanged(this.Slw, paramMediaFormat);
      }
      AppMethodBeat.o(190087);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.b
 * JD-Core Version:    0.7.0.1
 */