package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.bk;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.s.e;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMTextView;

public final class av
{
  private static final int GLI = 2131298134;
  private static final int GLJ = 2131298133;
  
  public static void a(Context paramContext, com.tencent.mm.ui.chatting.d.a parama, String paramString, CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, bl parambl, int paramInt)
  {
    AppMethodBeat.i(191647);
    q.a(paramContext, parama, paramString, paramCharSequence, paramMMNeat7extView, parambl, paramInt);
    AppMethodBeat.o(191647);
  }
  
  public static void a(boolean paramBoolean, av.f paramf, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(180039);
    if (paramf == null)
    {
      AppMethodBeat.o(180039);
      return;
    }
    if (paramBoolean)
    {
      paramf.GJT.setBackgroundResource(2131231647);
      paramf.GJU.setTextColor(parama.GzJ.getContext().getResources().getColor(2131099673));
      paramf.GJU.setText(2131760124);
      AppMethodBeat.o(180039);
      return;
    }
    paramf.GJT.setBackgroundResource(2131231648);
    paramf.GJU.setTextColor(parama.GzJ.getContext().getResources().getColor(2131099699));
    paramf.GJU.setText(2131760126);
    AppMethodBeat.o(180039);
  }
  
  static final class e
    extends s.e
  {
    public e(com.tencent.mm.ui.chatting.d.a parama)
    {
      super();
    }
    
    public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37419);
      parama = (bi)paramView.getTag();
      if (parambl.eLS())
      {
        if (this.Gob != null)
        {
          h.vKh.kvStat(10221, "1");
          paramView = new Intent();
          paramView.addFlags(67108864);
          d.b(this.Gob.GzJ.getContext(), "shake", ".ui.ShakeReportUI", paramView);
        }
        AppMethodBeat.o(37419);
        return;
      }
      if ((parambl.isText()) && ((paramView instanceof MMTextView)))
      {
        paramView = (MMTextView)paramView;
        com.tencent.mm.ui.chatting.l.a.a.fat();
        com.tencent.mm.ui.chatting.l.a.a.a(paramView.getText(), parama.drF);
      }
      AppMethodBeat.o(37419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.av
 * JD-Core Version:    0.7.0.1
 */