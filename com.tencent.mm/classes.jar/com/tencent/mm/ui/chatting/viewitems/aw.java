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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.bk;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aw
{
  private static final int IlF = 2131298134;
  private static final int IlG = 2131298133;
  
  public static void a(Context paramContext, com.tencent.mm.ui.chatting.d.a parama, String paramString, CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, bo parambo, int paramInt)
  {
    AppMethodBeat.i(196725);
    q.a(paramContext, parama, paramString, paramCharSequence, paramMMNeat7extView, parambo, paramInt);
    AppMethodBeat.o(196725);
  }
  
  public static void a(boolean paramBoolean, aw.f paramf, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(180039);
    if (paramf == null)
    {
      AppMethodBeat.o(180039);
      return;
    }
    if (paramBoolean)
    {
      paramf.IjQ.setBackgroundResource(2131231647);
      paramf.IjR.setTextColor(parama.HZF.getContext().getResources().getColor(2131099673));
      paramf.IjR.setText(2131760124);
      AppMethodBeat.o(180039);
      return;
    }
    paramf.IjQ.setBackgroundResource(2131231648);
    paramf.IjR.setTextColor(parama.HZF.getContext().getResources().getColor(2131099699));
    paramf.IjR.setText(2131760126);
    AppMethodBeat.o(180039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw
 * JD-Core Version:    0.7.0.1
 */