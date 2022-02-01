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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
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
    AppMethodBeat.i(233526);
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
        AppMethodBeat.i(233523);
        paramAnonymousView = (Context)paramWeakReference.get();
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(233523);
          return;
        }
        final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramAnonymousView, 1, true);
        locale.j(Util.safeFormatString(paramAnonymousView.getString(2131757247), new Object[] { str4, paramString }), 17, com.tencent.mm.cb.a.fromDPToPix(paramAnonymousView, 14));
        locale.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(233521);
            paramAnonymous2m.d(100, paramAnonymousView.getResources().getString(2131764691));
            paramAnonymous2m.d(101, Util.safeFormatString(paramAnonymousView.getResources().getString(2131757246), new Object[] { c.1.this.kNB }));
            AppMethodBeat.o(233521);
          }
        };
        locale.HLY = new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(233522);
            locale.bMo();
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(233522);
              return;
              paramAnonymous2MenuItem = c.this;
              Object localObject1 = c.1.this.gtu;
              Object localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(localObject1);
              paramAnonymous2MenuItem.a(-1L, (LinkedList)localObject2, 0);
              AppMethodBeat.o(233522);
              return;
              paramAnonymous2MenuItem = c.this;
              localObject1 = paramAnonymousView;
              localObject2 = c.1.this.val$appId;
              String str1 = c.1.this.kNB;
              String str2 = c.1.this.PFZ;
              com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)localObject1, 1, true);
              locale.j(Util.safeFormatString(((Context)localObject1).getString(2131757243, new Object[] { str1 }), new Object[0]), 17, com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 14));
              locale.HLX = new c.2(paramAnonymous2MenuItem, (Context)localObject1);
              locale.HLY = new c.3(paramAnonymous2MenuItem, (String)localObject2, str2, (Context)localObject1, locale);
              locale.dGm();
            }
          }
        };
        locale.dGm();
        ((com.tencent.mm.plugin.messenger.a.e)g.af(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_unbindapp", paramMap, paramBundle);
        AppMethodBeat.o(233523);
      }
    }, 0, str1.length(), 33);
    AppMethodBeat.o(233526);
    return localSpannableString;
  }
  
  public final String eiT()
  {
    return "link_revoke_unbindapp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.c
 * JD-Core Version:    0.7.0.1
 */