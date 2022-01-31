package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.g;
import com.tencent.mm.at.l;
import com.tencent.mm.at.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;

final class MsgRetransmitUI$4$1
  implements DialogInterface.OnClickListener
{
  MsgRetransmitUI$4$1(MsgRetransmitUI.4 param4) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(35064);
    g localg;
    com.tencent.mm.at.e locale;
    if (MsgRetransmitUI.e(this.Azy.Azx) != null)
    {
      aw.Rc().a(MsgRetransmitUI.e(this.Azy.Azx));
      paramInt = (int)MsgRetransmitUI.e(this.Azy.Azx).fFk;
      paramDialogInterface = o.ahC().lv(paramInt);
      if (paramDialogInterface != null)
      {
        localg = o.ahC();
        locale = localg.lv(paramInt);
        if ((locale != null) && (locale.fDL == paramInt)) {
          break label137;
        }
      }
    }
    for (;;)
    {
      aw.aaz();
      c.YC().kC(paramDialogInterface.fDU);
      Toast.makeText(this.Azy.Azx, 2131301641, 1).show();
      this.Azy.Azx.finish();
      AppMethodBeat.o(35064);
      return;
      label137:
      com.tencent.mm.vfs.e.deleteFile(localg.q(locale.fDM, "", ""));
      com.tencent.mm.vfs.e.deleteFile(localg.q(locale.fDR, "", ""));
      com.tencent.mm.vfs.e.deleteFile(localg.q(locale.fDO, "", ""));
      com.tencent.mm.vfs.e.deleteFile(localg.q(locale.fDO, "", "") + "hd");
      localg.fnw.delete("ImgInfo2", "id=?", new String[] { String.valueOf(paramInt) });
      if (locale.ahh())
      {
        locale = localg.lv(locale.fDW);
        if (locale != null)
        {
          com.tencent.mm.vfs.e.deleteFile(localg.q(locale.fDM, "", ""));
          com.tencent.mm.vfs.e.deleteFile(localg.q(locale.fDR, "", ""));
          com.tencent.mm.vfs.e.deleteFile(localg.q(locale.fDO, "", ""));
          com.tencent.mm.vfs.e.deleteFile(localg.q(locale.fDO, "", "") + "hd");
          localg.fnw.delete("ImgInfo2", "id=?", new String[] { locale.fDL });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.4.1
 * JD-Core Version:    0.7.0.1
 */