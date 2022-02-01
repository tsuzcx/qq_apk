package com.tencent.mm.wear.app.d.a.b;

import android.media.AudioRecord;
import com.tencent.mm.wear.a.b.a;
import java.util.concurrent.BlockingQueue;

public final class d
  extends Thread
{
  private long ahA;
  private long ahB;
  private int ahf;
  private BlockingQueue<g> ahr;
  private boolean ahs;
  private boolean aht;
  private AudioRecord ahx;
  private int ahy = 0;
  private e ahz;
  
  public d(BlockingQueue<g> paramBlockingQueue, int paramInt)
  {
    this.ahr = paramBlockingQueue;
    this.ahf = paramInt;
    this.ahy = AudioRecord.getMinBufferSize(paramInt, 16, 2);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMAudioRecorder", "recordBufSize=%d", new Object[] { Integer.valueOf(this.ahy) });
  }
  
  private boolean nD()
  {
    byte[] arrayOfByte = new byte[this.ahy];
    for (;;)
    {
      int n = this.ahx.read(arrayOfByte, 0, arrayOfByte.length);
      if (n > 0)
      {
        g localg = new g();
        localg.data = new byte[n];
        localg.size = n;
        System.arraycopy(arrayOfByte, 0, localg.data, 0, n);
        this.ahr.add(localg);
      }
      int i = 0;
      int k;
      for (final int j = 0; i < n / 2; j = k)
      {
        int m = (short)(arrayOfByte[(i * 2)] & 0xFF | arrayOfByte[(i * 2 + 1)] << 8);
        k = j;
        if (m > j) {
          k = m;
        }
        i += 1;
      }
      if (this.aht) {
        com.tencent.mm.wear.a.c.d.d("MicroMsg.MMAudioRecorder", "OnError: cancel", new Object[0]);
      }
      while ((this.ahs) || (this.aht))
      {
        return true;
        if (this.ahz != null) {
          a.amv.post(new Runnable()
          {
            public final void run()
            {
              d.a(d.this).cl(j);
            }
          });
        }
      }
    }
  }
  
  public final void a(e parame)
  {
    this.ahz = parame;
  }
  
  public final void nB()
  {
    this.ahB = System.currentTimeMillis();
    this.ahs = true;
  }
  
  public final long nC()
  {
    return this.ahB - this.ahA;
  }
  
  public final void run()
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMAudioRecorder", "init audio record", new Object[0]);
    this.ahx = new AudioRecord(0, this.ahf, 16, 2, 8192);
    if (this.ahx.getState() != 1)
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMAudioRecorder", "first init audioRecord is not successful, try to init again", new Object[0]);
      this.ahx.release();
      this.ahx = new AudioRecord(0, this.ahf, 16, 2, 8192);
      if (this.ahx.getState() != 1)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.MMAudioRecorder", "init audio record second time fail", new Object[0]);
        this.ahx.release();
        if (this.aht) {
          com.tencent.mm.wear.a.c.d.d("MicroMsg.MMAudioRecorder", "OnError: cancel", new Object[0]);
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label169;
      }
      return;
      if (this.ahz == null) {
        break;
      }
      a.amv.post(new Runnable()
      {
        public final void run()
        {
          d.a(d.this);
        }
      });
      break;
    }
    label169:
    this.ahx.startRecording();
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMAudioRecorder", "startRecording RecordStatus %d", new Object[] { Integer.valueOf(this.ahx.getState()) });
    nD();
    this.ahx.stop();
    this.ahx.release();
    this.ahx = null;
    this.ahB = System.currentTimeMillis();
  }
  
  public final void start()
  {
    try
    {
      super.start();
      this.ahA = System.currentTimeMillis();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.b.d
 * JD-Core Version:    0.7.0.1
 */