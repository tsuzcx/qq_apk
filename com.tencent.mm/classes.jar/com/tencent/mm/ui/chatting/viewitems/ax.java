package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ax
{
  private static final int Kyx = 2131298134;
  private static final int Kyy = 2131298133;
  
  public static void a(Context paramContext, com.tencent.mm.ui.chatting.e.a parama, String paramString, CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, bv parambv, int paramInt)
  {
    AppMethodBeat.i(187891);
    r.a(paramContext, parama, paramString, paramCharSequence, paramMMNeat7extView, parambv, paramInt);
    AppMethodBeat.o(187891);
  }
  
  public static void a(boolean paramBoolean, ax.f paramf, com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(180039);
    if (paramf == null)
    {
      AppMethodBeat.o(180039);
      return;
    }
    if (paramBoolean)
    {
      paramf.KwH.setBackgroundResource(2131231647);
      paramf.KwI.setTextColor(parama.Kkd.getContext().getResources().getColor(2131099673));
      paramf.KwI.setText(2131760124);
      AppMethodBeat.o(180039);
      return;
    }
    paramf.KwH.setBackgroundResource(2131231648);
    paramf.KwI.setTextColor(parama.Kkd.getContext().getResources().getColor(2131099699));
    paramf.KwI.setText(2131760126);
    AppMethodBeat.o(180039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax
 * JD-Core Version:    0.7.0.1
 */