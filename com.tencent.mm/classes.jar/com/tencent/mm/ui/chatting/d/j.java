package com.tencent.mm.ui.chatting.d;

import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.c;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.s;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.i.class)
class j
  extends a
  implements com.tencent.mm.ui.chatting.d.b.i
{
  public final boolean fDn()
  {
    AppMethodBeat.i(193997);
    boolean bool = am.aSV(this.cWM.getTalkerUserName());
    AppMethodBeat.o(193997);
    return bool;
  }
  
  public final void fDo()
  {
    AppMethodBeat.i(193998);
    this.cWM.JOR.setMMTitle(this.cWM.BYG.adv());
    Object localObject = ((e)g.ab(e.class)).aii(this.cWM.getTalkerUserName());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      ad.e("GameLife.ChattingComponent", "talker username get failed!");
      AppMethodBeat.o(193998);
      return;
    }
    localObject = ((b)g.ab(b.class)).amA((String)localObject);
    if (localObject == null)
    {
      ad.e("GameLife.ChattingComponent", "talker contact get failed!");
      AppMethodBeat.o(193998);
      return;
    }
    if ((!TextUtils.isEmpty(((com.tencent.mm.plugin.gamelife.a.a)localObject).getTag())) && (((com.tencent.mm.plugin.gamelife.a.a)localObject).daC() == 1)) {
      this.cWM.JOR.setMMSubTitle(((com.tencent.mm.plugin.gamelife.a.a)localObject).getTag());
    }
    AppMethodBeat.o(193998);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(193999);
    super.fwu();
    if (!fDn())
    {
      AppMethodBeat.o(193999);
      return;
    }
    com.tencent.mm.plugin.gamelife.a.a locala = ((b)g.ab(b.class)).amA(this.cWM.fFr());
    if (locala == null) {
      ad.e("GameLife.ChattingComponent", "self contact get failed!");
    }
    for (;;)
    {
      ((c)g.ab(c.class)).aie(this.cWM.getTalkerUserName());
      if (!bt.isNullOrNil(this.cWM.getTalkerUserName())) {
        h.LTJ.aS(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193996);
            List localList = ((l)g.ab(l.class)).dlK().dlX();
            Iterator localIterator = localList.iterator();
            while (localIterator.hasNext())
            {
              bu localbu = (bu)localIterator.next();
              localbu.setStatus(5);
              ((l)g.ab(l.class)).dlK().a(localbu.field_msgId, localbu);
            }
            ad.i("GameLife.ChattingComponent", "sending msg size=%s talker=%s username=%s", new Object[] { Integer.valueOf(localList.size()), j.this.cWM.fCR(), j.this.cWM.getTalkerUserName() });
            AppMethodBeat.o(193996);
          }
        });
      }
      AppMethodBeat.o(193999);
      return;
      ChatFooter localChatFooter = ((s)this.cWM.bh(s.class)).fDC();
      if (localChatFooter != null)
      {
        Object localObject = (MMEditText)this.cWM.findViewById(2131298072);
        localObject = new StringBuilder(TextUtils.ellipsize(new StringBuilder(locala.daA().field_nickname), ((MMEditText)localObject).getPaint(), Layout.getDesiredWidth("六个字的长度...", ((MMEditText)localObject).getPaint()), TextUtils.TruncateAt.END));
        if ((!TextUtils.isEmpty(locala.getTag())) && (locala.daC() == 1)) {
          ((StringBuilder)localObject).append(" (").append(locala.getTag()).append(")");
        }
        if (((StringBuilder)localObject).length() != 0) {
          ((StringBuilder)localObject).append(" :");
        }
        localChatFooter.a(this.cWM.fFr(), Boolean.FALSE, k.c(this.cWM.JOR.getContext(), (CharSequence)localObject));
      }
    }
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(194000);
    super.fwx();
    if (!fDn())
    {
      AppMethodBeat.o(194000);
      return;
    }
    ((c)g.ab(c.class)).aie(this.cWM.getTalkerUserName());
    AppMethodBeat.o(194000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.j
 * JD-Core Version:    0.7.0.1
 */