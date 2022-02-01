package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelpackage.u;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;

final class bi
  extends bg.a
{
  public final void b(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc)
  {
    AppMethodBeat.i(37381);
    String str = parama1.getTalkerUserName();
    parama = (bg.b)parama;
    Bundle localBundle = new Bundle();
    localBundle.putString("conv_talker_username", str);
    if ((parama1.aezO instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI))
    {
      paramInt = 10;
      localBundle.putInt("scene", paramInt);
      localBundle.putLong("msg_id", paramcc.field_msgId);
      localBundle.putLong("msg_sever_id", paramcc.field_msgSvrId);
      localBundle.putString("send_msg_username", paramcc.field_talker);
      localBundle.putString("local_session", parama1.aezT);
      paramcc = ((e)h.ax(e.class)).b(paramcc.field_content, localBundle, new WeakReference(parama1.aezO.getContext()), new WeakReference(parama.aeVA));
      if ((paramcc != null) && (paramcc.length() != 0)) {
        break label339;
      }
      parama.convertView.setVisibility(8);
      label173:
      paramcc = u.bLI().OM(str);
      bh.bCz();
      paramInt = ((Integer)c.ban().d(12311, Integer.valueOf(-2))).intValue();
      if (((paramcc == null) || (paramcc.oQj == -2)) && ((paramcc != null) || (paramInt == -2))) {
        break label359;
      }
      parama.aeVA.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.chatting_to_text_color));
      parama.aeVA.setBackground(parama1.aezO.getContext().getResources().getDrawable(R.g.chat_tips_light_bg));
    }
    for (;;)
    {
      parama.aeVA.setOnClickListener(new bi.1(this));
      parama.aeVA.invalidate();
      AppMethodBeat.o(37381);
      return;
      if (parama1.juG())
      {
        paramInt = 2;
        break;
      }
      if (ab.IS(str))
      {
        paramInt = 7;
        break;
      }
      paramInt = 1;
      break;
      label339:
      parama.convertView.setVisibility(0);
      parama.aeVA.aZ(paramcc);
      break label173;
      label359:
      parama.aeVA.setTextColor(parama1.aezO.getContext().getResources().getColor(R.e.FG_2));
      parama.aeVA.setBackground(parama1.aezO.getContext().getResources().getDrawable(R.g.chat_tips_bg));
    }
  }
  
  public final void b(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc)
  {
    int i = 1;
    AppMethodBeat.i(255245);
    bg.b localb = (bg.b)parama;
    parama = "";
    if (localb.aeVB != null) {
      if (paramcc.jcl())
      {
        parama = Util.nullAsNil(paramcc.jbr());
        parama = parama1.aezO.getContext().getResources().getString(R.l.select_record_msg_share_tips, new Object[] { parama });
        i = 0;
      }
    }
    for (;;)
    {
      if (localb.aeVB != null)
      {
        if (TextUtils.isEmpty(parama)) {
          break label183;
        }
        localb.aeVB.setVisibility(0);
        if (localb.aeVC != null) {
          localb.aeVC.setText(parama);
        }
      }
      for (;;)
      {
        if (localb.uploadingPB != null)
        {
          if (i != 0)
          {
            localb.uploadingPB.setVisibility(0);
            AppMethodBeat.o(255245);
            return;
            if (!com.tencent.mm.plugin.selectrecord.e.b.aVx(paramcc.field_historyId)) {
              break label212;
            }
            parama = Util.nullAsNil(paramcc.jbr());
            parama = parama1.aezO.getContext().getResources().getString(R.l.select_record_msg_share_tips, new Object[] { parama });
            break;
            label183:
            localb.aeVB.setVisibility(8);
            continue;
          }
          localb.uploadingPB.setVisibility(8);
        }
      }
      AppMethodBeat.o(255245);
      return;
      label212:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bi
 * JD-Core Version:    0.7.0.1
 */