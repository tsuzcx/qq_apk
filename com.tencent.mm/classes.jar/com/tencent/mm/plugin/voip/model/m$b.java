package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class m$b
  implements Runnable
{
  boolean tvW = false;
  boolean tvX = false;
  byte[] tvY = null;
  ByteBuffer tvZ = null;
  int twa = 0;
  
  m$b(m paramm) {}
  
  public final void run()
  {
    AppMethodBeat.i(4440);
    if ((this.tvV.kJF == 2) && (!this.tvX))
    {
      long l1 = System.currentTimeMillis();
      int i;
      int j;
      boolean bool1;
      boolean bool2;
      Object localObject1;
      if (this.tvV.ttm.cMh())
      {
        if (this.tvY == null)
        {
          this.tvZ = ByteBuffer.allocateDirect(this.tvV.ttm.tvj.defaultWidth * this.tvV.ttm.tvj.defaultHeight * 4).order(ByteOrder.nativeOrder());
          this.tvZ.position(0);
          this.tvY = new byte[this.tvZ.remaining()];
          ab.i("MicroMsg.Voip.VoipDeviceHandler", "init remoteImageByteBuffer, defaultWidth:%s, defaultHeight:%s", new Object[] { Integer.valueOf(this.tvV.ttm.tvj.defaultWidth), Integer.valueOf(this.tvV.ttm.tvj.defaultHeight) });
        }
        i = 0;
        if (this.tvZ != null)
        {
          this.tvZ.clear();
          i = this.tvV.ttm.tvj.videoDecodeBB(this.tvZ);
        }
        if (i == 1)
        {
          this.twa += 1;
          this.tvZ.get(this.tvY);
          i = this.tvV.ttm.tvj.field_remoteImgWidth;
          j = this.tvV.ttm.tvj.field_remoteImgHeight;
          if ((i != 0) || (j >= 3)) {
            break label562;
          }
          bool1 = true;
          if (this.twa % 200 == 10) {
            ab.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec statistics: total:%d, soft:%d, size:%dx%d, HW:%b", new Object[] { Integer.valueOf(this.twa), Integer.valueOf(this.tvV.ttm.tvj.tBB), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
          }
          bool2 = false;
          if (!bool1) {
            break label605;
          }
          if (!this.tvW)
          {
            localObject1 = this.tvV;
            ((m)localObject1).tvP |= 0x1;
            this.tvV.ttm.tvk.setHWDecMode(this.tvV.tvP);
            bool2 = true;
            ab.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec, restart decoder!");
            localObject1 = s.tyN;
            s.cNI();
          }
          if (v2protocal.tBP == null) {}
        }
      }
      for (;;)
      {
        try
        {
          for (;;)
          {
            i = this.tvV.ttm.tvj.field_remoteImgLength;
            ab.d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=".concat(String.valueOf(i)));
            j = this.tvV.ttm.tvj.field_remoteImgHeight;
            localObject1 = new byte[i];
            System.arraycopy(this.tvY, 0, localObject1, 0, i);
            v2protocal.tBP.h((byte[])localObject1, j, bool2);
            long l2 = System.currentTimeMillis();
            ab.d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (l2 - l1) + ", startTime = " + l1);
            this.tvW = bool1;
            try
            {
              Thread.sleep(10L);
            }
            catch (InterruptedException localInterruptedException)
            {
              ab.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", localInterruptedException, "", new Object[0]);
            }
          }
          break;
          label562:
          bool1 = false;
        }
        catch (Exception localException)
        {
          ab.e("EncodeDecode", "interrupted while waiting");
          ab.e("MicroMsg.Voip.VoipDeviceHandler", " error:" + localException.toString());
          continue;
        }
        label605:
        Object localObject2;
        if (this.tvW)
        {
          localObject2 = this.tvV;
          ((m)localObject2).tvP &= 0xFFFFFFFE;
          if (v2protocal.tBP != null) {
            v2protocal.tBP.tuf = false;
          }
          this.tvV.ttm.tvk.setHWDecMode(this.tvV.tvP);
          ab.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
          localObject2 = s.tyN;
          s.cNJ();
        }
        int k = this.tvV.ttm.tvj.field_remoteImgLength;
        if ((k > 0) && (this.tvV.ttm.tvk != null))
        {
          localObject2 = this.tvV.ttm.tvj;
          ((v2protocal)localObject2).tBB += 1;
          this.tvV.ttm.tvk.e(i, j, this.tvY);
          if (this.tvV.ttm.tvj.tBB % 100 == 0)
          {
            localObject2 = new byte[5];
            int m = i * 33 + 33;
            int n = i * 34 - 34;
            int i1 = i * j / 2 + i / 2;
            int i2 = (j - 34) * i + 33;
            int i3 = (j - 34) * i + i - 34;
            if ((this.tvY != null) && (i3 < this.tvY.length))
            {
              localObject2[0] = this.tvY[m];
              localObject2[1] = this.tvY[n];
              localObject2[2] = this.tvY[i1];
              localObject2[3] = this.tvY[i2];
              localObject2[4] = this.tvY[i3];
              ab.i("MicroMsg.Voip.VoipDeviceHandler", "steve: SW dec to render: cnt:%d, size:%dx%d, outlen:%d, samples:%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.tvV.ttm.tvj.tBB), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Byte.valueOf(localObject2[0]), Byte.valueOf(localObject2[1]), Byte.valueOf(localObject2[2]), Byte.valueOf(localObject2[3]), Byte.valueOf(localObject2[4]) });
              ab.i("MicroMsg.Voip.VoipDeviceHandler", "steve: first 5 samples:%d,%d,%d,%d,%d", new Object[] { Byte.valueOf(this.tvY[0]), Byte.valueOf(this.tvY[1]), Byte.valueOf(this.tvY[2]), Byte.valueOf(this.tvY[3]), Byte.valueOf(this.tvY[4]) });
              j = 0;
              i = 0;
              while (i < 5)
              {
                k = j;
                if (localObject2[i] == 0) {
                  k = j + 1;
                }
                i += 1;
                j = k;
              }
              if (j >= 5)
              {
                localObject2 = s.tyN;
                s.cNQ();
              }
            }
            else
            {
              ab.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec null pointer or out of memory! size:%dx%d, idx:%d,%d,%d,%d,%d, len:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.tvY.length) });
            }
          }
        }
      }
    }
    AppMethodBeat.o(4440);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.m.b
 * JD-Core Version:    0.7.0.1
 */