package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AudioMixer
{
  public static final int OUTPUT_CHANNEL_COUNT = 1;
  public static final int OUTPUT_SAMPLE_RATE = 44100;
  private ByteBuffer cachedByteBuffer;
  private ByteBuffer cachedMergedBuffer;
  private short[] cachedMergedBytes;
  private int destAudioChannelCount;
  private int destAudioSampleRate;
  private ByteBuffer emptyAudioBuffer;
  private long nativeContext;
  private int pcmEncoding;
  private short[] resampleBuffer;
  private short[] sampleBuffer;
  private float sampleFactor;
  private boolean singleChannel;
  
  static
  {
    AppMethodBeat.i(201724);
    System.out.println("loadlibrary : tav start");
    System.loadLibrary("tav");
    System.out.println("loadlibrary : tav end");
    AppMethodBeat.o(201724);
  }
  
  public AudioMixer()
  {
    this(44100, 1);
  }
  
  public AudioMixer(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201718);
    this.destAudioSampleRate = paramInt1;
    this.destAudioChannelCount = paramInt2;
    this.nativeContext = nativeSetup(this.destAudioSampleRate, this.destAudioChannelCount);
    this.sampleFactor = 1.0F;
    if (paramInt2 == 1) {}
    for (;;)
    {
      this.singleChannel = bool;
      this.pcmEncoding = 2;
      AppMethodBeat.o(201718);
      return;
      bool = false;
    }
  }
  
  private short[] getCachedSampleBuffer(int paramInt)
  {
    if ((this.sampleBuffer == null) || (this.sampleBuffer.length < paramInt))
    {
      short[] arrayOfShort = new short[paramInt];
      this.sampleBuffer = arrayOfShort;
      return arrayOfShort;
    }
    return this.sampleBuffer;
  }
  
  private int getResampleLength(int paramInt)
  {
    int i = (int)(paramInt * this.sampleFactor);
    paramInt = i;
    if (i % 2 == 1) {
      paramInt = i - 1;
    }
    return paramInt;
  }
  
  private native void nativeRelease(long paramLong);
  
  private native long nativeSetup(int paramInt1, int paramInt2);
  
  private native void readShortFromStream(long paramLong, short[] paramArrayOfShort);
  
  private short[] resample(short[] paramArrayOfShort, int paramInt)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(201719);
    if (this.sampleFactor == 1.0F)
    {
      AppMethodBeat.o(201719);
      return paramArrayOfShort;
    }
    int m = getResampleLength(paramInt);
    short[] arrayOfShort;
    if ((this.resampleBuffer == null) || (this.resampleBuffer.length < m))
    {
      arrayOfShort = new short[m];
      this.resampleBuffer = arrayOfShort;
    }
    float f;
    for (;;)
    {
      f = 1.0F / this.sampleFactor;
      paramInt = k;
      if (!this.singleChannel) {
        break;
      }
      paramInt = j;
      while (paramInt < m)
      {
        int i = paramArrayOfShort[((int)(paramInt * f))];
        arrayOfShort[(paramInt + 1)] = i;
        arrayOfShort[paramInt] = i;
        paramInt += 2;
      }
      arrayOfShort = this.resampleBuffer;
    }
    while (paramInt < m)
    {
      j = (int)(paramInt * 0.5D * f) * 2;
      arrayOfShort[paramInt] = paramArrayOfShort[j];
      arrayOfShort[(paramInt + 1)] = paramArrayOfShort[(j + 1)];
      paramInt += 2;
    }
    AppMethodBeat.o(201719);
    return arrayOfShort;
  }
  
  private native int writeShortToStream(long paramLong, short[] paramArrayOfShort, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3);
  
  protected void finalize()
  {
    AppMethodBeat.i(201722);
    release();
    AppMethodBeat.o(201722);
  }
  
  public int getDestAudioChannelCount()
  {
    return this.destAudioChannelCount;
  }
  
  public ByteBuffer mergeSamples(ShortBuffer paramShortBuffer1, ShortBuffer paramShortBuffer2)
  {
    AppMethodBeat.i(201721);
    ShortBuffer localShortBuffer;
    short[] arrayOfShort;
    int m;
    int j;
    label117:
    int k;
    int i;
    if ((this.cachedMergedBuffer == null) || (this.cachedMergedBuffer.capacity() < paramShortBuffer1.limit() * 2))
    {
      this.cachedMergedBuffer = ByteBuffer.allocateDirect(paramShortBuffer1.limit() * 2);
      this.cachedMergedBuffer.order(paramShortBuffer1.order());
      if ((this.cachedMergedBytes == null) || (this.cachedMergedBytes.length < paramShortBuffer1.limit() * 2)) {
        this.cachedMergedBytes = new short[paramShortBuffer1.limit() * 2];
      }
      localShortBuffer = this.cachedMergedBuffer.asShortBuffer();
      arrayOfShort = this.cachedMergedBytes;
      m = Math.min(paramShortBuffer1.limit(), paramShortBuffer2.limit());
      j = 0;
      if (j >= m) {
        break label196;
      }
      k = paramShortBuffer1.get(j) + paramShortBuffer2.get(j);
      if (k >= -32768) {
        break label178;
      }
      i = -32768;
    }
    for (;;)
    {
      arrayOfShort[j] = ((short)i);
      j += 1;
      break label117;
      this.cachedMergedBuffer.clear();
      break;
      label178:
      i = k;
      if (k > 32767) {
        i = 32767;
      }
    }
    label196:
    localShortBuffer.put(arrayOfShort, 0, m);
    if (m < paramShortBuffer1.limit())
    {
      paramShortBuffer1.position(m);
      localShortBuffer.put(paramShortBuffer1);
    }
    this.cachedMergedBuffer.position(0);
    this.cachedMergedBuffer.limit(paramShortBuffer1.limit() * 2);
    paramShortBuffer1 = this.cachedMergedBuffer;
    AppMethodBeat.o(201721);
    return paramShortBuffer1;
  }
  
  public ByteBuffer processBytes(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(201720);
    if ((paramFloat1 == 1.0F) && (paramFloat2 == 1.0F) && (paramFloat3 == 1.0F) && (this.sampleFactor == 1.0F))
    {
      AppMethodBeat.o(201720);
      return paramByteBuffer;
    }
    Object localObject2;
    int i;
    Object localObject1;
    int j;
    if (this.pcmEncoding == 2)
    {
      localObject2 = paramByteBuffer.asShortBuffer();
      i = ((ShortBuffer)localObject2).limit();
      localObject1 = getCachedSampleBuffer(i);
      ((ShortBuffer)localObject2).get((short[])localObject1, 0, i);
      localObject2 = resample((short[])localObject1, i);
      j = getResampleLength(i);
      if (paramFloat2 != 0.0F) {
        break label290;
      }
      i = (int)(j / paramFloat1);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (paramFloat2 != 0.0F) {
        break label366;
      }
      if ((this.emptyAudioBuffer == null) || (this.emptyAudioBuffer.limit() < i * 2))
      {
        this.emptyAudioBuffer = ByteBuffer.allocateDirect(i * 2);
        this.emptyAudioBuffer.order(paramByteBuffer.order());
        this.emptyAudioBuffer.put(new byte[i * 2]);
      }
      paramByteBuffer = this.emptyAudioBuffer;
      paramByteBuffer.position(0);
      paramByteBuffer.limit(i * 2);
      AppMethodBeat.o(201720);
      return paramByteBuffer;
      if (this.pcmEncoding == 3)
      {
        int k = paramByteBuffer.limit();
        byte[] arrayOfByte = new byte[k];
        paramByteBuffer.get(arrayOfByte, 0, k);
        localObject2 = getCachedSampleBuffer(k);
        j = 0;
        for (;;)
        {
          localObject1 = localObject2;
          i = k;
          if (j >= k) {
            break;
          }
          localObject2[j] = ((short)arrayOfByte[j]);
          j += 1;
        }
      }
      AppMethodBeat.o(201720);
      return paramByteBuffer;
      label290:
      if ((paramFloat1 == 1.0F) && (paramFloat2 == 1.0F))
      {
        i = j;
        localObject1 = localObject2;
        if (paramFloat3 == 1.0F) {}
      }
      else
      {
        i = writeShortToStream(this.nativeContext, (short[])localObject2, j / this.destAudioChannelCount, paramFloat1, paramFloat2, paramFloat3) * this.destAudioChannelCount;
        localObject1 = getCachedSampleBuffer(i);
        readShortFromStream(this.nativeContext, (short[])localObject1);
      }
    }
    label366:
    if ((this.cachedByteBuffer == null) || (this.cachedByteBuffer.capacity() < i * 2))
    {
      localObject2 = ByteBuffer.allocateDirect(i * 2);
      this.cachedByteBuffer = ((ByteBuffer)localObject2);
      ((ByteBuffer)localObject2).order(paramByteBuffer.order());
      paramByteBuffer = (ByteBuffer)localObject2;
    }
    for (;;)
    {
      paramByteBuffer.asShortBuffer().put((short[])localObject1, 0, i);
      break;
      paramByteBuffer = this.cachedByteBuffer;
      paramByteBuffer.clear();
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(201723);
    nativeRelease(this.nativeContext);
    this.nativeContext = 0L;
    AppMethodBeat.o(201723);
  }
  
  public void setAudioInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    this.sampleFactor = (this.destAudioSampleRate * this.destAudioChannelCount / (paramInt1 * paramInt2 * 1.0F));
    if (paramInt2 == 1) {}
    for (;;)
    {
      this.singleChannel = bool;
      this.pcmEncoding = paramInt3;
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.AudioMixer
 * JD-Core Version:    0.7.0.1
 */