package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.component.api.bc;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class bj
{
  private static final int aeQA = R.h.fyZ;
  private static final int aeQz = R.h.fza;
  
  public static void a(Context paramContext, com.tencent.mm.ui.chatting.d.a parama, String paramString, CharSequence paramCharSequence, MMNeat7extView paramMMNeat7extView, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(255280);
    x.a(paramContext, parama, paramString, paramCharSequence, paramMMNeat7extView, paramcc, paramInt);
    AppMethodBeat.o(255280);
  }
  
  public static void a(boolean paramBoolean, bj.f paramf, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(180039);
    if (paramf == null)
    {
      AppMethodBeat.o(180039);
      return;
    }
    if (paramBoolean)
    {
      paramf.aeOr.setBackgroundResource(R.g.fne);
      paramf.aeOs.setTextColor(parama.aezO.getContext().getResources().getColor(R.e.BW_100_Alpha_0_8));
      paramf.aeOs.setText(R.l.gJk);
      AppMethodBeat.o(180039);
      return;
    }
    paramf.aeOr.setBackgroundResource(R.g.fnf);
    paramf.aeOs.setTextColor(parama.aezO.getContext().getResources().getColor(R.e.Brand));
    paramf.aeOs.setText(R.l.gJl);
    AppMethodBeat.o(180039);
  }
  
  public static Bundle dG(cc paramcc)
  {
    AppMethodBeat.i(255289);
    Bundle localBundle = new Bundle();
    localBundle.putLong("msgSvrId", paramcc.field_msgSvrId);
    AppMethodBeat.o(255289);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj
 * JD-Core Version:    0.7.0.1
 */