package com.tencent.mm.plugin.voip.model;

import android.os.ConditionVariable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class n$a
  extends b
{
  ConditionVariable UAa;
  boolean UAb;
  boolean UAc;
  byte[] UAd;
  ByteBuffer UAe;
  int UAf;
  int UAg;
  
  n$a(n paramn)
  {
    AppMethodBeat.i(293338);
    this.UAa = new ConditionVariable();
    this.UAb = false;
    this.UAc = false;
    this.UAd = null;
    this.UAe = null;
    this.UAf = 0;
    this.UAg = 0;
    AppMethodBeat.o(293338);
  }
  
  public final String getKey()
  {
    return "stop_video_decode_runnable";
  }
  
  public final void hXa()
  {
    AppMethodBeat.i(293340);
    this.UAc = true;
    this.UAa.open();
    AppMethodBeat.o(293340);
  }
  
  public final void run()
  {
    AppMethodBeat.i(114945);
    int k;
    int m;
    int i1;
    int j;
    boolean bool1;
    label295:
    label593:
    do
    {
      if ((this.UzZ.wTK != 2) || (this.UAc)) {
        break;
      }
      long l1 = System.currentTimeMillis();
      int i = 0;
      boolean bool2;
      Object localObject1;
      if (this.UzZ.UvO.hWI())
      {
        if (this.UAe == null)
        {
          this.UAe = ByteBuffer.allocateDirect((this.UzZ.UvO.UyU.defaultWidth + 64) * (this.UzZ.UvO.UyU.defaultHeight + 64) * 4).order(ByteOrder.nativeOrder());
          this.UAe.position(0);
          this.UAd = new byte[this.UAe.remaining()];
          Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "init remoteImageByteBuffer, defaultWidth:%s, defaultHeight:%s", new Object[] { Integer.valueOf(this.UzZ.UvO.UyU.defaultWidth), Integer.valueOf(this.UzZ.UvO.UyU.defaultHeight) });
        }
        i = 0;
        if (this.UAe != null)
        {
          this.UAe.clear();
          i = this.UzZ.UvO.UyU.videoDecodeBB(this.UAe);
        }
        if (i == 1)
        {
          this.UAf += 1;
          k = this.UzZ.UvO.UyU.field_remoteImgWidth;
          m = this.UzZ.UvO.UyU.field_remoteImgHeight;
          i1 = this.UzZ.UvO.UyU.field_remoteImgOrien;
          j = 0;
          if (this.UAg != i1)
          {
            j = 1;
            this.UAg = i1;
          }
          if ((k != 0) || (m >= 3)) {
            break label630;
          }
          bool1 = true;
          if (this.UAf % 200 == 10) {
            Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: dec statistics: total:%d, soft:%d, size:%dx%d, HW:%b", new Object[] { Integer.valueOf(this.UAf), Integer.valueOf(this.UzZ.UvO.UyU.UFB), Integer.valueOf(k), Integer.valueOf(m), Boolean.valueOf(bool1) });
          }
          bool2 = false;
          if (!bool1) {
            break label676;
          }
          if (!this.UAb)
          {
            localObject1 = this.UzZ;
            ((n)localObject1).UzN |= 0x1;
            this.UzZ.UvO.UyV.setHWDecMode(this.UzZ.UzN);
            bool2 = true;
            Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: change to HW dec, restart decoder!");
            localObject1 = t.UBA;
            t.hYa();
          }
          if (v2protocal.UFS == null) {}
        }
      }
      try
      {
        k = this.UzZ.UvO.UyU.field_remoteImgLength;
        Log.d("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve:video decode successfully!..len=".concat(String.valueOf(k)));
        m = this.UzZ.UvO.UyU.field_remoteImgHeight;
        localObject1 = new byte[k];
        System.arraycopy(this.UAe.array(), this.UAe.arrayOffset(), localObject1, 0, k);
        v2protocal.UFS.f((byte[])localObject1, m, bool2);
        long l2 = System.currentTimeMillis();
        Log.d("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: fill in AvcDecoder take time = " + (l2 - l1) + ", startTime = " + l1);
        if (j != 0) {
          this.UzZ.UvO.UyV.VR(i1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("EncodeDecode", "interrupted while waiting");
          Log.e("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", " error:" + localException.toString());
        }
      }
      this.UAb = bool1;
      if (i == 1) {
        break label1358;
      }
    } while ((!this.UAa.block(10L)) || (!this.UAc));
    for (;;)
    {
      AppMethodBeat.o(114945);
      return;
      label630:
      bool1 = false;
      break label295;
      label676:
      if (this.UAb)
      {
        localObject2 = this.UzZ;
        ((n)localObject2).UzN &= 0xFFFFFFFE;
        if (v2protocal.UFS != null) {
          v2protocal.UFS.LmX = false;
        }
        this.UzZ.UvO.UyV.setHWDecMode(this.UzZ.UzN);
        Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: change to SW dec");
        localObject2 = t.UBA;
        t.hYb();
      }
      int n = this.UzZ.UvO.UyU.field_remoteImgLength;
      if ((n <= 0) || (this.UzZ.UvO.UyV == null)) {
        break label593;
      }
      Object localObject2 = this.UzZ.UvO.UyU;
      ((v2protocal)localObject2).UFB += 1;
      int i2 = k * m * 3 / 2;
      System.arraycopy(this.UAe.array(), this.UAe.arrayOffset(), this.UAd, 0, i2);
      this.UzZ.UvO.UyV.c(k, m, this.UAd);
      int i3;
      int i4;
      int i5;
      int i6;
      if (this.UzZ.UvO.UyU.UFB % 100 == 0)
      {
        localObject2 = new byte[5];
        i2 = k * 33 + 33;
        i3 = k * 34 - 34;
        i4 = k * m / 2 + k / 2;
        i5 = (m - 34) * k + 33;
        i6 = (m - 34) * k + k - 34;
        if ((this.UAd == null) || (i6 >= this.UAd.length)) {
          break label1274;
        }
        localObject2[0] = this.UAd[i2];
        localObject2[1] = this.UAd[i3];
        localObject2[2] = this.UAd[i4];
        localObject2[3] = this.UAd[i5];
        localObject2[4] = this.UAd[i6];
        Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: SW dec to render: cnt:%d, size:%dx%d, outlen:%d, samples:%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.UzZ.UvO.UyU.UFB), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Byte.valueOf(localObject2[0]), Byte.valueOf(localObject2[1]), Byte.valueOf(localObject2[2]), Byte.valueOf(localObject2[3]), Byte.valueOf(localObject2[4]) });
        Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: first 5 samples:%d,%d,%d,%d,%d", new Object[] { Byte.valueOf(this.UAd[0]), Byte.valueOf(this.UAd[1]), Byte.valueOf(this.UAd[2]), Byte.valueOf(this.UAd[3]), Byte.valueOf(this.UAd[4]) });
        m = 0;
        k = 0;
        while (k < 5)
        {
          n = m;
          if (localObject2[k] == 0) {
            n = m + 1;
          }
          k += 1;
          m = n;
        }
        if (m >= 5)
        {
          localObject2 = t.UBA;
          t.hYi();
        }
      }
      for (;;)
      {
        if (j == 0) {
          break label1356;
        }
        this.UzZ.UvO.UyV.VR(i1);
        break;
        label1274:
        Log.i("MicroMsg.Voip.VoipDeviceHandler.VideoRunnable", "steve: dec null pointer or out of memory! size:%dx%d, idx:%d,%d,%d,%d,%d, len:%d ", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(this.UAd.length) });
      }
      label1356:
      break label593;
      label1358:
      if (!this.UAc) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n.a
 * JD-Core Version:    0.7.0.1
 */