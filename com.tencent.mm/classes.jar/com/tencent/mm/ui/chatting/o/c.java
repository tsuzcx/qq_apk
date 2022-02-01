package com.tencent.mm.ui.chatting.o;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.plugin.messenger.foundation.a.c.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends b
{
  public c(b.b paramb)
  {
    super(paramb);
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(194259);
    String str1 = (String)paramMap.get(paramString + ".title");
    final String str2 = (String)paramMap.get(paramString + ".username");
    final String str3 = (String)paramMap.get(paramString + ".appid");
    paramString = (String)paramMap.get(paramString + ".appname");
    final String str4 = (String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.memberlist.member.nickname");
    final String str5 = paramBundle.getString("conv_talker_username");
    SpannableString localSpannableString = new SpannableString(str1);
    localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
    {
      public final void onClickImp(final View paramAnonymousView)
      {
        AppMethodBeat.i(194256);
        paramAnonymousView = (Context)paramWeakReference.get();
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(194256);
          return;
        }
        final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramAnonymousView, 1, true);
        locale.i(bt.x(paramAnonymousView.getString(2131766871), new Object[] { str4, paramString }), 17, com.tencent.mm.cc.a.fromDPToPix(paramAnonymousView, 14));
        locale.KJy = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(194254);
            paramAnonymous2l.c(100, paramAnonymousView.getResources().getString(2131762609));
            paramAnonymous2l.c(101, bt.x(paramAnonymousView.getResources().getString(2131766869), new Object[] { c.1.this.jIA }));
            AppMethodBeat.o(194254);
          }
        };
        locale.KJz = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(194255);
            locale.bpT();
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(194255);
              return;
              paramAnonymous2MenuItem = c.this;
              Object localObject1 = c.1.this.fNr;
              Object localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(localObject1);
              paramAnonymous2MenuItem.a(-1L, (LinkedList)localObject2, 0);
              AppMethodBeat.o(194255);
              return;
              paramAnonymous2MenuItem = c.this;
              localObject1 = paramAnonymousView;
              localObject2 = c.1.this.val$appId;
              String str1 = c.1.this.jIA;
              String str2 = c.1.this.JXs;
              com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)localObject1, 1, true);
              locale.i(bt.x(((Context)localObject1).getString(2131766866, new Object[] { str1 }), new Object[0]), 17, com.tencent.mm.cc.a.fromDPToPix((Context)localObject1, 14));
              locale.KJy = new c.2(paramAnonymous2MenuItem, (Context)localObject1);
              locale.KJz = new c.3(paramAnonymous2MenuItem, (String)localObject2, str2, (Context)localObject1, locale);
              locale.cMW();
            }
          }
        };
        locale.cMW();
        ((com.tencent.mm.plugin.messenger.a.e)g.ab(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_unbindapp", paramMap, paramBundle);
        AppMethodBeat.o(194256);
      }
    }, 0, str1.length(), 33);
    AppMethodBeat.o(194259);
    return localSpannableString;
  }
  
  public final String dmf()
  {
    return "link_revoke_unbindapp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.c
 * JD-Core Version:    0.7.0.1
 */