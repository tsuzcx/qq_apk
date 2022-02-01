package com.tencent.mm.ui.chatting.p;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.e.b;
import com.tencent.mm.plugin.messenger.e.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.e.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
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
    AppMethodBeat.i(266896);
    String str1 = (String)paramMap.get(paramString + ".title");
    final String str2 = (String)paramMap.get(paramString + ".username");
    final String str3 = (String)paramMap.get(paramString + ".appid");
    paramString = (String)paramMap.get(paramString + ".appname");
    final String str4 = (String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.memberlist.member.nickname");
    final String str5 = paramBundle.getString("conv_talker_username");
    SpannableString localSpannableString = new SpannableString(str1);
    localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a(paramWeakReference, str4)
    {
      public final void onClickImp(final View paramAnonymousView)
      {
        AppMethodBeat.i(269137);
        paramAnonymousView = (Context)paramWeakReference.get();
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(269137);
          return;
        }
        final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(paramAnonymousView, 1, true);
        locale.j(Util.safeFormatString(paramAnonymousView.getString(R.l.etT), new Object[] { str4, paramString }), 17, com.tencent.mm.ci.a.fromDPToPix(paramAnonymousView, 14));
        locale.ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(282078);
            paramAnonymous2o.d(100, paramAnonymousView.getResources().getString(R.l.eRc));
            paramAnonymous2o.d(101, Util.safeFormatString(paramAnonymousView.getResources().getString(R.l.etS), new Object[] { c.1.this.nHB }));
            AppMethodBeat.o(282078);
          }
        };
        locale.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(289551);
            locale.bYF();
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(289551);
              return;
              paramAnonymous2MenuItem = c.this;
              Object localObject1 = c.1.this.iXG;
              Object localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(localObject1);
              paramAnonymous2MenuItem.a(-1L, (LinkedList)localObject2, 0);
              AppMethodBeat.o(289551);
              return;
              paramAnonymous2MenuItem = c.this;
              localObject1 = paramAnonymousView;
              localObject2 = c.1.this.val$appId;
              String str1 = c.1.this.nHB;
              String str2 = c.1.this.XaP;
              com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)localObject1, 1, true);
              locale.j(Util.safeFormatString(((Context)localObject1).getString(R.l.etR, new Object[] { str1 }), new Object[0]), 17, com.tencent.mm.ci.a.fromDPToPix((Context)localObject1, 14));
              locale.ODT = new c.2(paramAnonymous2MenuItem, (Context)localObject1);
              locale.ODU = new c.3(paramAnonymous2MenuItem, (String)localObject2, str2, (Context)localObject1, locale);
              locale.eik();
            }
          }
        };
        locale.eik();
        ((com.tencent.mm.plugin.messenger.a.e)h.ae(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_unbindapp", paramMap, paramBundle);
        AppMethodBeat.o(269137);
      }
    }, 0, str1.length(), 33);
    AppMethodBeat.o(266896);
    return localSpannableString;
  }
  
  public final String eSz()
  {
    return "link_revoke_unbindapp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p.c
 * JD-Core Version:    0.7.0.1
 */