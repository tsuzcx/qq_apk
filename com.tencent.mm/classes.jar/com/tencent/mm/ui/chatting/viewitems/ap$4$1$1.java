package com.tencent.mm.ui.chatting.viewitems;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.vfs.e;

final class ap$4$1$1
  implements f
{
  ap$4$1$1(ap.4.1 param1) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33386);
    ab.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramInt1 + " errCode " + paramInt2 + "  scene " + paramm.getType());
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = this.zYe.zYd.zXY.field_content;
      if (paramString == null) {
        break label330;
      }
    }
    label330:
    for (paramString = j.b.mY(paramString);; paramString = null)
    {
      if (paramString != null)
      {
        long l = this.zYe.zYd.zXY.field_msgId;
        paramString = al.aUJ().nw(l);
        if (paramString != null) {
          ab.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[] { Boolean.valueOf(e.deleteFile(paramString.field_fileFullPath)), Boolean.valueOf(al.aUJ().delete(paramString, new String[] { "msgInfoId" })), Long.valueOf(paramString.field_msgInfoId), paramString.field_mediaSvrId, paramString.field_fileFullPath, bo.dtY() });
        }
      }
      bf.gw(this.zYe.zYd.zXY.field_msgId);
      Toast.makeText(ap.a(this.zYe.zYd.zYa).zJz.getContext(), ap.a(this.zYe.zYd.zYa).zJz.getMMResources().getString(2131298220), 0).show();
      aw.Rc().b(331, ap.b(this.zYe.zYd.zYa));
      ap.a(this.zYe.zYd.zYa, null);
      if (ap.c(this.zYe.zYd.zYa) != null) {
        ap.c(this.zYe.zYd.zYa).dismiss();
      }
      AppMethodBeat.o(33386);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.4.1.1
 * JD-Core Version:    0.7.0.1
 */