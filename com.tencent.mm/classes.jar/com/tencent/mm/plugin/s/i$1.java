package com.tencent.mm.plugin.s;

import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.y;

final class i$1
  implements ah.a
{
  i$1(i parami) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    switch (i)
    {
    default: 
      y.w("MicroMsg.VideoPlayer", "%s it has no idea for msg %d ", new Object[] { this.meH.ayN(), Integer.valueOf(i) });
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                y.i("MicroMsg.VideoPlayer", "%s call prepared ", new Object[] { this.meH.ayN() });
              } while (this.meH.meF == null);
              this.meH.meF.kA();
              return false;
              y.i("MicroMsg.VideoPlayer", "%s call completion ", new Object[] { this.meH.ayN() });
            } while (this.meH.meF == null);
            this.meH.meF.ug();
            return false;
            y.i("MicroMsg.VideoPlayer", "%s call seek completion ", new Object[] { this.meH.ayN() });
          } while (this.meH.meF == null);
          this.meH.meF.aKN();
          return false;
          y.i("MicroMsg.VideoPlayer", "%s call video size changed size [%d, %d] degrees[%d]", new Object[] { this.meH.ayN(), Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2), Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
        } while (this.meH.meF == null);
        this.meH.meF.F(paramMessage.arg1, paramMessage.arg2, ((Integer)paramMessage.obj).intValue());
        return false;
        y.e("MicroMsg.VideoPlayer", "%s call play error [%d, %d]", new Object[] { this.meH.ayN(), Integer.valueOf(paramMessage.arg1), Integer.valueOf(paramMessage.arg2) });
      } while (this.meH.meF == null);
      this.meH.meF.onError(paramMessage.arg1, paramMessage.arg2);
      return false;
    }
    try
    {
      paramMessage = this.meH;
      y.i("MicroMsg.VideoPlayer", "%s clear now.", new Object[] { paramMessage.ayN() });
      paramMessage.meB.quit();
      paramMessage.meC.quit();
      if (paramMessage.meD != null) {
        paramMessage.meD.quit();
      }
      paramMessage.meA.removeMessages(1);
      paramMessage.meA.removeMessages(2);
      paramMessage.meA.removeMessages(3);
      paramMessage.meA.removeMessages(4);
      paramMessage.meA.removeMessages(5);
      paramMessage.meB = null;
      paramMessage.meC = null;
      paramMessage.meA = null;
      paramMessage.mez = null;
      paramMessage.meF = null;
      paramMessage.meE = null;
      return false;
    }
    catch (Exception paramMessage) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.s.i.1
 * JD-Core Version:    0.7.0.1
 */