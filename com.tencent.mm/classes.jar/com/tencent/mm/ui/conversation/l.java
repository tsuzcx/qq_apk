package com.tencent.mm.ui.conversation;

import android.os.HandlerThread;
import android.widget.ListView;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

public final class l
{
  d dnR = new d(new l.1(this));
  h vPG;
  ListView vPc;
  boolean vTJ = false;
  private ai vTK;
  private Runnable vTL;
  int vTM = -1;
  
  final void cIs()
  {
    if (!this.vTJ)
    {
      y.d("MicroMsg.PreLoadHelper", "Jacks cancel PreLoad.");
      this.vTJ = true;
    }
    if ((this.vTK != null) && (this.vTL != null)) {
      this.vTK.crf().removeCallbacks(this.vTL);
    }
    if (this.vTK != null)
    {
      this.vTK.mnU.quit();
      this.vTK = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.l
 * JD-Core Version:    0.7.0.1
 */