package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.l;
import com.tencent.mm.as.o;
import com.tencent.mm.cf.h;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

final class MsgRetransmitUI$4$1
  implements DialogInterface.OnClickListener
{
  MsgRetransmitUI$4$1(MsgRetransmitUI.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    com.tencent.mm.as.g localg;
    com.tencent.mm.as.e locale;
    if (MsgRetransmitUI.e(this.wgH.wgG) != null)
    {
      au.Dk().c(MsgRetransmitUI.e(this.wgH.wgG));
      paramInt = (int)MsgRetransmitUI.e(this.wgH.wgG).eoN;
      paramDialogInterface = o.OJ().iH(paramInt);
      if (paramDialogInterface != null)
      {
        localg = o.OJ();
        locale = localg.iH(paramInt);
        if ((locale != null) && (locale.enp == paramInt)) {
          break label128;
        }
      }
    }
    for (;;)
    {
      au.Hx();
      c.Fy().fe(paramDialogInterface.enx);
      Toast.makeText(this.wgH.wgG, R.l.msgretr_share_cancel, 1).show();
      this.wgH.wgG.finish();
      return;
      label128:
      com.tencent.mm.vfs.e.deleteFile(localg.o(locale.enq, "", ""));
      com.tencent.mm.vfs.e.deleteFile(localg.o(locale.ens, "", ""));
      com.tencent.mm.vfs.e.deleteFile(localg.o(locale.ens, "", "") + "hd");
      localg.dXo.delete("ImgInfo2", "id=?", new String[] { String.valueOf(paramInt) });
      if (locale.Or())
      {
        locale = localg.iH(locale.enz);
        if (locale != null)
        {
          com.tencent.mm.vfs.e.deleteFile(localg.o(locale.enq, "", ""));
          com.tencent.mm.vfs.e.deleteFile(localg.o(locale.ens, "", ""));
          com.tencent.mm.vfs.e.deleteFile(localg.o(locale.ens, "", "") + "hd");
          localg.dXo.delete("ImgInfo2", "id=?", new String[] { locale.enp });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.4.1
 * JD-Core Version:    0.7.0.1
 */