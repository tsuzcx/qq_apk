package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.j.a;
import com.tencent.mm.f.b.j;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class k
{
  private static k rGh = null;
  public long duration;
  public com.tencent.mm.compatible.util.b eLi = new com.tencent.mm.compatible.util.b(ae.getContext());
  public boolean ibC;
  public boolean ibD;
  public final am ibI = new am(new k.5(this), true);
  private final ah ibJ = new ah()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      k.b(k.this);
    }
  };
  public long ibp = -1L;
  private Toast ibq;
  public long jlU;
  public j kcn;
  public TextView kdD;
  public String path = "";
  public com.tencent.mm.modelvoice.k rGf;
  public String rGg = "";
  public int rGi = 0;
  public a rGj;
  public l rGk = null;
  public final ah rGl = new k.4(this);
  
  public static k chy()
  {
    if (rGh == null) {
      rGh = new k();
    }
    return rGh;
  }
  
  public static k chz()
  {
    return rGh;
  }
  
  public static void destroy()
  {
    rGh = null;
  }
  
  private long getDuration()
  {
    if (this.jlU == 0L) {
      return 0L;
    }
    return bk.cp(this.jlU);
  }
  
  public final void aRi()
  {
    if (!this.ibC) {
      return;
    }
    this.rGl.removeMessages(4096);
    if (this.rGg.equals("speex"))
    {
      this.rGf.uh();
      if (this.eLi != null) {
        this.eLi.zE();
      }
      this.duration = getDuration();
      if (this.duration >= 800L) {
        break label138;
      }
    }
    label138:
    for (int i = 1;; i = 0)
    {
      this.ibI.stopTimer();
      if (i != 0)
      {
        com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(this.path);
        if (localb.exists()) {
          localb.delete();
        }
        this.ibJ.sendEmptyMessageDelayed(0, 500L);
      }
      this.ibC = false;
      return;
      this.kcn.uh();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k
 * JD-Core Version:    0.7.0.1
 */