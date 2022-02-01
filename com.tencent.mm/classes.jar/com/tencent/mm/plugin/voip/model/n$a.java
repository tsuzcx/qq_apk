package com.tencent.mm.plugin.voip.model;

import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class n$a
  extends b
{
  boolean Cto = false;
  boolean Ctp = false;
  byte[] Ctq = null;
  ByteBuffer Ctr = null;
  int Cts = 0;
  
  n$a(n paramn) {}
  
  public final String getKey()
  {
    return "stop_video_decode_runnable";
  }
  
  public final void run()
  {
    AppMethodBeat.i(114945);
    if ((this.Ctn.pcM == 2) && (!this.Ctp))
    {
      long l1 = System.currentTimeMillis();
      int i;
      int j;
      boolean bool1;
      boolean bool2;
      Object localObject1;
      if (this.Ctn.Cpd.ezM())
      {
        if (this.Ctq == null)
        {
          this.Ctr = ByteBuffer.allocateDirect(this.Ctn.Cpd.Csj.defaultWidth * this.Ctn.Cpd.Csj.defaultHeight * 4).order(ByteOrder.nativeOrder());
          this.Ctr.position(0);
          this.Ctq = new byte[this.Ctr.remaining()];
          ae.i("MicroMsg.Voip.VoipDeviceHandler", "init remoteImageByteBuffer, defaultWidth:%s, defaultHeight:%s", new Object[] { Integer.valueOf(this.Ctn.Cpd.Csj.defaultWidth), Integer.valueOf(this.Ctn.Cpd.Csj.defaultHeight) });
        }
        i = 0;
        if (this.Ctr != null)
        {
          this.Ctr.clear();
          i = this.Ctn.Cpd.Csj.videoDecodeBB(this.Ctr);
        }
        if (i == 1)
        {
          this.Cts += 1;
          this.Ctr.get(this.Ctq);
          i = this.Ctn.Cpd.Csj.field_remoteImgWidth;
          j = this.Ctn.Cpd.Csj.field_remoteImgHeight;
          if ((i != 0) || (j >= 3)) {
            break label561;
          }
          bool1 = true;
          if (this.Cts % 200 == 10) {
            ae.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec statistics: total:%d, soft:%d, size:%dx%d, HW:%b", new Object[] { Integer.valueOf(this.Cts), Integer.valueOf(this.Ctn.Cpd.Csj.Cyv), Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool1) });
          }
          bool2 = false;
          if (!bool1) {
            break label604;
          }
          if (!this.Cto)
          {
            localObject1 = this.Ctn;
            ((n)localObject1).Ctd |= 0x1;
            this.Ctn.Cpd.Csk.setHWDecMode(this.Ctn.Ctd);
            bool2 = true;
            ae.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec, restart decoder!");
            localObject1 = t.Cvc;
            t.eAO();
          }
          if (v2protocal.CyL == null) {}
        }
      }
      for (;;)
      {
        try
        {
          for (;;)
          {
            i = this.Ctn.Cpd.Csj.field_remoteImgLength;
            ae.d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=".concat(String.valueOf(i)));
            j = this.Ctn.Cpd.Csj.field_remoteImgHeight;
            localObject1 = new byte[i];
            System.arraycopy(this.Ctq, 0, localObject1, 0, i);
            v2protocal.CyL.f((byte[])localObject1, j, bool2);
            long l2 = System.currentTimeMillis();
            ae.d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (l2 - l1) + ", startTime = " + l1);
            this.Cto = bool1;
            try
            {
              Thread.sleep(10L);
            }
            catch (InterruptedException localInterruptedException)
            {
              ae.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", localInterruptedException, "", new Object[0]);
            }
          }
          break;
          label561:
          bool1 = false;
        }
        catch (Exception localException)
        {
          ae.e("EncodeDecode", "interrupted while waiting");
          ae.e("MicroMsg.Voip.VoipDeviceHandler", " error:" + localException.toString());
          continue;
        }
        label604:
        Object localObject2;
        if (this.Cto)
        {
          localObject2 = this.Ctn;
          ((n)localObject2).Ctd &= 0xFFFFFFFE;
          if (v2protocal.CyL != null) {
            v2protocal.CyL.wqk = false;
          }
          this.Ctn.Cpd.Csk.setHWDecMode(this.Ctn.Ctd);
          ae.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
          localObject2 = t.Cvc;
          t.eAP();
        }
        int k = this.Ctn.Cpd.Csj.field_remoteImgLength;
        if ((k > 0) && (this.Ctn.Cpd.Csk != null))
        {
          localObject2 = this.Ctn.Cpd.Csj;
          ((v2protocal)localObject2).Cyv += 1;
          this.Ctn.Cpd.Csk.e(i, j, this.Ctq);
          if (this.Ctn.Cpd.Csj.Cyv % 100 == 0)
          {
            localObject2 = new byte[5];
            int m = i * 33 + 33;
            int n = i * 34 - 34;
            int i1 = i * j / 2 + i / 2;
            int i2 = (j - 34) * i + 33;
            int i3 = (j - 34) * i + i - 34;
            if ((this.Ctq != null) && (i3 < this.Ctq.length))
            {
              localObject2[0] = this.Ctq[m];
              localObject2[1] = this.Ctq[n];
              localObject2[2] = this.Ctq[i1];
              localObject2[3] = this.Ctq[i2];
              localObject2[4] = this.Ctq[i3];
              ae.i("MicroMsg.Voip.VoipDeviceHandler", "steve: SW dec to render: cnt:%d, size:%dx%d, outlen:%d, samples:%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.Ctn.Cpd.Csj.Cyv), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Byte.valueOf(localObject2[0]), Byte.valueOf(localObject2[1]), Byte.valueOf(localObject2[2]), Byte.valueOf(localObject2[3]), Byte.valueOf(localObject2[4]) });
              ae.i("MicroMsg.Voip.VoipDeviceHandler", "steve: first 5 samples:%d,%d,%d,%d,%d", new Object[] { Byte.valueOf(this.Ctq[0]), Byte.valueOf(this.Ctq[1]), Byte.valueOf(this.Ctq[2]), Byte.valueOf(this.Ctq[3]), Byte.valueOf(this.Ctq[4]) });
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
                localObject2 = t.Cvc;
                t.eAW();
              }
            }
            else
            {
              ae.i("MicroMsg.Voip.VoipDeviceHandler", "steve: dec null pointer or out of memory! size:%dx%d, idx:%d,%d,%d,%d,%d, len:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.Ctq.length) });
            }
          }
        }
      }
    }
    AppMethodBeat.o(114945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.n.a
 * JD-Core Version:    0.7.0.1
 */