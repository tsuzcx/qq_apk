package com.tencent.mm.plugin.voip.model;

import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class n$a
  extends b
{
  boolean ACM = false;
  boolean ACN = false;
  byte[] ACO = null;
  ByteBuffer ACP = null;
  int ACQ = 0;
  
  n$a(n paramn) {}
  
  public final String getKey()
  {
    return "stop_video_decode_runnable";
  }
  
  public final void run()
  {
    AppMethodBeat.i(114945);
    if ((this.ACL.osN == 2) && (!this.ACN))
    {
      long l1 = System.currentTimeMillis();
      int i;
      int j;
      boolean bool1;
      boolean bool2;
      Object localObject1;
      if (this.ACL.Ayh.eiu())
      {
        if (this.ACO == null)
        {
          this.ACP = ByteBuffer.allocateDirect(this.ACL.Ayh.ABJ.defaultWidth * this.ACL.Ayh.ABJ.defaultHeight * 4).order(ByteOrder.nativeOrder());
          this.ACP.position(0);
          this.ACO = new byte[this.ACP.remaining()];
          ac.i("MicroMsg.Voip.VoipDeviceHandler", "init remoteImageByteBuffer, defaultWidth:%s, defaultHeight:%s", new Object[] { Integer.valueOf(this.ACL.Ayh.ABJ.defaultWidth), Integer.valueOf(this.ACL.Ayh.ABJ.defaultHeight) });
        }
        i = 0;
        if (this.ACP != null)
        {
          this.ACP.clear();
          i = this.ACL.Ayh.ABJ.videoDecodeBB(this.ACP);
        }
        if (i == 1)
        {
          this.ACQ += 1;
          this.ACP.get(this.ACO);
          i = this.ACL.Ayh.ABJ.field_remoteImgWidth;
          j = this.ACL.Ayh.ABJ.field_remoteImgHeight;
          if ((i != 0) || (j >= 3)) {
            break label561;
          }
          bool1 = true;
          if (this.ACQ % 200 == 10) {
            ac.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec statistics: total:%d, soft:%d, size:%dx%d, HW:%b", new Object[] { Integer.valueOf(this.ACQ), Integer.valueOf(this.ACL.Ayh.ABJ.AHT), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
          }
          bool2 = false;
          if (!bool1) {
            break label604;
          }
          if (!this.ACM)
          {
            localObject1 = this.ACL;
            ((n)localObject1).ACD |= 0x1;
            this.ACL.Ayh.ABK.setHWDecMode(this.ACL.ACD);
            bool2 = true;
            ac.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec, restart decoder!");
            localObject1 = t.AEB;
            t.ejw();
          }
          if (v2protocal.AIj == null) {}
        }
      }
      for (;;)
      {
        try
        {
          for (;;)
          {
            i = this.ACL.Ayh.ABJ.field_remoteImgLength;
            ac.d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=".concat(String.valueOf(i)));
            j = this.ACL.Ayh.ABJ.field_remoteImgHeight;
            localObject1 = new byte[i];
            System.arraycopy(this.ACO, 0, localObject1, 0, i);
            v2protocal.AIj.f((byte[])localObject1, j, bool2);
            long l2 = System.currentTimeMillis();
            ac.d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (l2 - l1) + ", startTime = " + l1);
            this.ACM = bool1;
            try
            {
              Thread.sleep(10L);
            }
            catch (InterruptedException localInterruptedException)
            {
              ac.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", localInterruptedException, "", new Object[0]);
            }
          }
          break;
          label561:
          bool1 = false;
        }
        catch (Exception localException)
        {
          ac.e("EncodeDecode", "interrupted while waiting");
          ac.e("MicroMsg.Voip.VoipDeviceHandler", " error:" + localException.toString());
          continue;
        }
        label604:
        Object localObject2;
        if (this.ACM)
        {
          localObject2 = this.ACL;
          ((n)localObject2).ACD &= 0xFFFFFFFE;
          if (v2protocal.AIj != null) {
            v2protocal.AIj.Azd = false;
          }
          this.ACL.Ayh.ABK.setHWDecMode(this.ACL.ACD);
          ac.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
          localObject2 = t.AEB;
          t.ejx();
        }
        int k = this.ACL.Ayh.ABJ.field_remoteImgLength;
        if ((k > 0) && (this.ACL.Ayh.ABK != null))
        {
          localObject2 = this.ACL.Ayh.ABJ;
          ((v2protocal)localObject2).AHT += 1;
          this.ACL.Ayh.ABK.d(i, j, this.ACO);
          if (this.ACL.Ayh.ABJ.AHT % 100 == 0)
          {
            localObject2 = new byte[5];
            int m = i * 33 + 33;
            int n = i * 34 - 34;
            int i1 = i * j / 2 + i / 2;
            int i2 = (j - 34) * i + 33;
            int i3 = (j - 34) * i + i - 34;
            if ((this.ACO != null) && (i3 < this.ACO.length))
            {
              localObject2[0] = this.ACO[m];
              localObject2[1] = this.ACO[n];
              localObject2[2] = this.ACO[i1];
              localObject2[3] = this.ACO[i2];
              localObject2[4] = this.ACO[i3];
              ac.i("MicroMsg.Voip.VoipDeviceHandler", "steve: SW dec to render: cnt:%d, size:%dx%d, outlen:%d, samples:%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.ACL.Ayh.ABJ.AHT), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Byte.valueOf(localObject2[0]), Byte.valueOf(localObject2[1]), Byte.valueOf(localObject2[2]), Byte.valueOf(localObject2[3]), Byte.valueOf(localObject2[4]) });
              ac.i("MicroMsg.Voip.VoipDeviceHandler", "steve: first 5 samples:%d,%d,%d,%d,%d", new Object[] { Byte.valueOf(this.ACO[0]), Byte.valueOf(this.ACO[1]), Byte.valueOf(this.ACO[2]), Byte.valueOf(this.ACO[3]), Byte.valueOf(this.ACO[4]) });
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
                localObject2 = t.AEB;
                t.ejE();
              }
            }
            else
            {
              ac.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec null pointer or out of memory! size:%dx%d, idx:%d,%d,%d,%d,%d, len:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.ACO.length) });
            }
          }
        }
      }
    }
    AppMethodBeat.o(114945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n.a
 * JD-Core Version:    0.7.0.1
 */