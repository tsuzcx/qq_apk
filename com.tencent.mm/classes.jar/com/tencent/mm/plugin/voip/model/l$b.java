package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.y;

final class l$b
  implements Runnable
{
  boolean pQS = false;
  boolean pQT = false;
  
  l$b(l paraml) {}
  
  public final void run()
  {
    if ((this.pQR.iEu == 2) && (!this.pQT))
    {
      long l1 = System.currentTimeMillis();
      int i;
      int j;
      boolean bool;
      Object localObject1;
      if ((this.pQR.pNq.bQd()) && (this.pQR.pNq.pQe.videoDecode(this.pQR.pNq.pQe.pVv) == 1))
      {
        i = this.pQR.pNq.pQe.field_remoteImgWidth;
        j = this.pQR.pNq.pQe.field_remoteImgHeight;
        if ((i != 0) || (j >= 3)) {
          break label335;
        }
        bool = true;
        if (!bool) {
          break label378;
        }
        if (!this.pQS)
        {
          localObject1 = this.pQR;
          ((l)localObject1).pQL |= 0x1;
          this.pQR.pNq.pQf.setHWDecMode(this.pQR.pQL);
          y.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec");
        }
        if (v2protocal.pWk == null) {}
      }
      for (;;)
      {
        try
        {
          for (;;)
          {
            i = this.pQR.pNq.pQe.field_remoteImgLength;
            y.d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=" + i);
            j = this.pQR.pNq.pQe.field_remoteImgHeight;
            localObject1 = new byte[i];
            this.pQR.pNq.pQe.getVideoHWDecode(this.pQR.pNq.pQe.pVv, (byte[])localObject1, i);
            v2protocal.pWk.R((byte[])localObject1, j);
            long l2 = System.currentTimeMillis();
            y.d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (l2 - l1) + ", startTime = " + l1);
            this.pQS = bool;
            try
            {
              Thread.sleep(10L);
            }
            catch (InterruptedException localInterruptedException)
            {
              y.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", localInterruptedException, "", new Object[0]);
            }
          }
          break;
          label335:
          bool = false;
        }
        catch (Exception localException)
        {
          y.e("EncodeDecode", "interrupted while waiting");
          y.e("MicroMsg.Voip.VoipDeviceHandler", " error:" + localException.toString());
          continue;
        }
        label378:
        Object localObject2;
        if (this.pQS)
        {
          localObject2 = this.pQR;
          ((l)localObject2).pQL &= 0xFFFFFFFE;
          if (v2protocal.pWk != null) {
            v2protocal.pWk.pOl = false;
          }
          this.pQR.pNq.pQf.setHWDecMode(this.pQR.pQL);
          y.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
        }
        if ((this.pQR.pNq.pQe.field_remoteImgLength > 0) && (this.pQR.pNq.pQf != null))
        {
          localObject2 = this.pQR.pNq.pQe;
          ((v2protocal)localObject2).pVW += 1;
          this.pQR.pNq.pQf.b(i, j, this.pQR.pNq.pQe.pVv);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.b
 * JD-Core Version:    0.7.0.1
 */