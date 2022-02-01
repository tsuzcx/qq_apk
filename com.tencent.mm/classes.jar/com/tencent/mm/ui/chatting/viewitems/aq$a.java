package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import java.util.Map;

final class aq$a
  implements View.OnClickListener
{
  private aq$a(aq paramaq) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(37238);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if (!(paramView.getTag() instanceof cc))
    {
      Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37238);
      return;
    }
    localObject = (cc)paramView.getTag();
    if (localObject == null)
    {
      Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37238);
      return;
    }
    final Map localMap = XmlParser.parseXml(((fi)localObject).field_content, "msg", null);
    if ((localMap == null) || (localMap.size() == 0))
    {
      Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(37238);
      return;
    }
    final String str = Util.nullAsNil((String)localMap.get(".msg.fromusername"));
    f localf = new f(paramView.getContext(), 1, false);
    localf.Vtg = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(37233);
        if (((com.tencent.mm.plugin.biz.a.a)h.ax(com.tencent.mm.plugin.biz.a.a.class)).Hh(str)) {}
        for (String str = paramView.getResources().getString(R.l.gQq);; str = paramView.getResources().getString(R.l.gQo))
        {
          paramAnonymouss.add(0, 2, 0, str);
          AppMethodBeat.o(37233);
          return;
        }
      }
    };
    localf.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(37237);
        Log.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", new Object[] { Integer.valueOf(paramAnonymousMenuItem.getItemId()), Integer.valueOf(paramAnonymousInt) });
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(37237);
          return;
          aq.a(aq.a.this.aeTe, paramView, this.oiL, localMap, str);
        }
      }
    };
    localf.dDn();
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq.a
 * JD-Core Version:    0.7.0.1
 */