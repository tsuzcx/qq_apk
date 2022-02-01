package com.tencent.mm.ui.chatting.l;

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
import com.tencent.mm.plugin.messenger.f.b;
import com.tencent.mm.plugin.messenger.f.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.e.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
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
    AppMethodBeat.i(254396);
    String str1 = (String)paramMap.get(paramString + ".title");
    final String str2 = (String)paramMap.get(paramString + ".username");
    final String str3 = (String)paramMap.get(paramString + ".appid");
    paramString = (String)paramMap.get(paramString + ".appname");
    final String str4 = (String)paramMap.get(".sysmsg.sysmsgtemplate.content_template.link_list.link.memberlist.member.nickname");
    final String str5 = paramBundle.getString("conv_talker_username");
    SpannableString localSpannableString = new SpannableString(str1);
    localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a(paramWeakReference)
    {
      public final void onClickImp(final View paramAnonymousView)
      {
        AppMethodBeat.i(254388);
        paramAnonymousView = (Context)paramWeakReference.get();
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(254388);
          return;
        }
        final f localf = new f(paramAnonymousView, 1, true);
        localf.h(Util.safeFormatString(paramAnonymousView.getString(R.l.gwr), new Object[] { str4, paramString }), 17, com.tencent.mm.cd.a.fromDPToPix(paramAnonymousView, 14));
        localf.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(254391);
            paramAnonymous2s.c(100, paramAnonymousView.getResources().getString(R.l.gTI));
            paramAnonymous2s.c(101, Util.safeFormatString(paramAnonymousView.getResources().getString(R.l.gwq), new Object[] { c.1.this.qHo }));
            AppMethodBeat.o(254391);
          }
        };
        localf.GAC = new u.i()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(254392);
            localf.cyW();
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(254392);
              return;
              paramAnonymous2MenuItem = c.this;
              Object localObject1 = c.1.this.lzC;
              Object localObject2 = new LinkedList();
              ((LinkedList)localObject2).add(localObject1);
              paramAnonymous2MenuItem.a(-1L, (LinkedList)localObject2, 0);
              AppMethodBeat.o(254392);
              return;
              paramAnonymous2MenuItem = c.this;
              localObject1 = paramAnonymousView;
              localObject2 = c.1.this.etl;
              String str1 = c.1.this.qHo;
              String str2 = c.1.this.aexg;
              f localf = new f((Context)localObject1, 1, true);
              localf.h(Util.safeFormatString(((Context)localObject1).getString(R.l.gwp, new Object[] { str1 }), new Object[0]), 17, com.tencent.mm.cd.a.fromDPToPix((Context)localObject1, 14));
              localf.Vtg = new c.2(paramAnonymous2MenuItem, (Context)localObject1);
              localf.GAC = new c.3(paramAnonymous2MenuItem, (String)localObject2, str2, (Context)localObject1, localf);
              localf.dDn();
            }
          }
        };
        localf.dDn();
        ((com.tencent.mm.plugin.messenger.a.e)h.ax(com.tencent.mm.plugin.messenger.a.e.class)).a("link_revoke_unbindapp", paramMap, paramBundle);
        AppMethodBeat.o(254388);
      }
    }, 0, str1.length(), 33);
    AppMethodBeat.o(254396);
    return localSpannableString;
  }
  
  public final String gbt()
  {
    return "link_revoke_unbindapp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.c
 * JD-Core Version:    0.7.0.1
 */