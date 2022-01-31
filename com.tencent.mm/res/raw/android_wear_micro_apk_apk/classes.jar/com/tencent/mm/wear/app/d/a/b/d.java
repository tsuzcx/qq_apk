package com.tencent.mm.wear.app.d.a.b;

import android.media.AudioRecord;
import com.tencent.mm.wear.a.b.a;
import java.util.concurrent.BlockingQueue;

public final class d
  extends Thread
{
  private int adD;
  private BlockingQueue<g> adP;
  private boolean adQ;
  private boolean adR;
  private AudioRecord adV;
  private int adW = 0;
  private e adX;
  private long adY;
  private long adZ;
  
  public d(BlockingQueue<g> paramBlockingQueue, int paramInt)
  {
    this.adP = paramBlockingQueue;
    this.adD = paramInt;
    this.adW = AudioRecord.getMinBufferSize(paramInt, 16, 2);
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMAudioRecorder", "recordBufSize=%d", new Object[] { Integer.valueOf(this.adW) });
  }
  
  private boolean mR()
  {
    byte[] arrayOfByte = new byte[this.adW];
    for (;;)
    {
      int n = this.adV.read(arrayOfByte, 0, arrayOfByte.length);
      if (n > 0)
      {
        g localg = new g();
        localg.data = new byte[n];
        localg.size = n;
        System.arraycopy(arrayOfByte, 0, localg.data, 0, n);
        this.adP.add(localg);
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
      if (this.adR) {
        com.tencent.mm.wear.a.c.d.e("MicroMsg.MMAudioRecorder", "OnError: cancel", new Object[0]);
      }
      while ((this.adQ) || (this.adR))
      {
        return true;
        if (this.adX != null) {
          a.aiT.post(new Runnable()
          {
            public final void run()
            {
              d.a(d.this).bP(j);
            }
          });
        }
      }
    }
  }
  
  public final void a(e parame)
  {
    this.adX = parame;
  }
  
  public final void mP()
  {
    this.adZ = System.currentTimeMillis();
    this.adQ = true;
  }
  
  public final long mQ()
  {
    return this.adZ - this.adY;
  }
  
  public final void run()
  {
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMAudioRecorder", "init audio record", new Object[0]);
    this.adV = new AudioRecord(0, this.adD, 16, 2, 8192);
    if (this.adV.getState() != 1)
    {
      com.tencent.mm.wear.a.c.d.c("MicroMsg.MMAudioRecorder", "first init audioRecord is not successful, try to init again", new Object[0]);
      this.adV.release();
      this.adV = new AudioRecord(0, this.adD, 16, 2, 8192);
      if (this.adV.getState() != 1)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.MMAudioRecorder", "init audio record second time fail", new Object[0]);
        this.adV.release();
        if (this.adR) {
          com.tencent.mm.wear.a.c.d.e("MicroMsg.MMAudioRecorder", "OnError: cancel", new Object[0]);
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        break label169;
      }
      return;
      if (this.adX == null) {
        break;
      }
      a.aiT.post(new Runnable()
      {
        public final void run() {}
      });
      break;
    }
    label169:
    this.adV.startRecording();
    com.tencent.mm.wear.a.c.d.c("MicroMsg.MMAudioRecorder", "startRecording RecordStatus %d", new Object[] { Integer.valueOf(this.adV.getState()) });
    mR();
    this.adV.stop();
    this.adV.release();
    this.adV = null;
    this.adZ = System.currentTimeMillis();
  }
  
  public final void start()
  {
    try
    {
      super.start();
      this.adY = System.currentTimeMillis();
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