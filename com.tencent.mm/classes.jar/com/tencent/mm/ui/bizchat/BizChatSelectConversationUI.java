package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.a.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.protocal.protobuf.aeh;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.protocal.protobuf.vs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.w;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(19)
public class BizChatSelectConversationUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.aj.n
{
  private String jUE = null;
  private int scene = 0;
  private com.tencent.mm.ui.base.p tipDialog = null;
  j ztq;
  private TextView zun;
  
  private com.tencent.mm.ui.widget.b.c a(String paramString1, String paramString2, String paramString3, final String paramString4, final long paramLong)
  {
    AppMethodBeat.i(30191);
    paramString1 = g.a(getController(), paramString1, paramString3, paramString2, true, getResources().getString(2131297067), new q.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(30177);
        if (paramAnonymousBoolean)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enterprise_biz_name", paramString4);
          localIntent.putExtra("key_biz_chat_id", paramLong);
          localIntent.putExtra("key_is_biz_chat", true);
          if (!bo.isNullOrNil(paramAnonymousString)) {
            localIntent.putExtra("enterprise_share_append_text", paramAnonymousString);
          }
          BizChatSelectConversationUI.this.setResult(-1, localIntent);
          BizChatSelectConversationUI.this.finish();
        }
        AppMethodBeat.o(30177);
      }
    });
    AppMethodBeat.o(30191);
    return paramString1;
  }
  
  private void a(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(30188);
    ab.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (this.scene == 2)
    {
      if (getIntent().getBooleanExtra("enterprise_extra_params", true))
      {
        s(paramString, String.valueOf(paramCharSequence), paramLong);
        AppMethodBeat.o(30188);
        return;
      }
      t(paramString, String.valueOf(paramCharSequence), paramLong);
      AppMethodBeat.o(30188);
      return;
    }
    if (this.scene == 1)
    {
      paramCharSequence = (HashMap)getIntent().getSerializableExtra("enterprise_extra_params");
      String str1 = (String)paramCharSequence.get("img_url");
      String str2 = (String)paramCharSequence.get("desc");
      a((String)paramCharSequence.get("title"), str2, str1, paramString, paramLong);
    }
    AppMethodBeat.o(30188);
  }
  
  private void dFe()
  {
    AppMethodBeat.i(30182);
    if (bo.isNullOrNil(this.jUE))
    {
      this.jUE = getIntent().getStringExtra("enterprise_biz_name");
      if (bo.isNullOrNil(this.jUE))
      {
        ab.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
        finish();
      }
    }
    AppMethodBeat.o(30182);
  }
  
  private void s(final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(30189);
    g.a(this.mController, paramLong, getString(2131302656), paramString2, getString(2131297067), new q.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(30175);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("enterprise_biz_name", paramString1);
          paramAnonymousString.putExtra("key_biz_chat_id", paramLong);
          paramAnonymousString.putExtra("key_is_biz_chat", true);
          BizChatSelectConversationUI.this.setResult(-1, paramAnonymousString);
          BizChatSelectConversationUI.this.finish();
        }
        AppMethodBeat.o(30175);
      }
    });
    AppMethodBeat.o(30189);
  }
  
  private void t(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(30190);
    g.a(this.mController, paramLong, getString(2131302656), paramString2, getString(2131297067), new BizChatSelectConversationUI.3(this, paramString1, paramLong));
    AppMethodBeat.o(30190);
  }
  
  public final void a(int paramInt, m paramm)
  {
    AppMethodBeat.i(30194);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramm.getType() == 1355)
    {
      paramm = ((com.tencent.mm.aj.a.n)paramm).afD();
      paramm = z.afk().sl(paramm.wOs.wXl.wyb);
      if (paramm == null)
      {
        Toast.makeText(ah.getContext(), getString(2131302674), 0).show();
        AppMethodBeat.o(30194);
        return;
      }
      a(this.jUE, paramm.field_bizChatLocalId, paramm.field_chatName);
    }
    AppMethodBeat.o(30194);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(30185);
    super.a(paramListView, paramInt);
    if (this.zun == null)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(30174);
          BizChatSelectConversationUI.a(BizChatSelectConversationUI.this);
          AppMethodBeat.o(30174);
        }
      };
      String str = getString(2131303056);
      View localView = w.hM(this).inflate(2130969849, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131823022);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.zun = ((TextView)localObject);
    }
    this.zun.setVisibility(paramInt);
    AppMethodBeat.o(30185);
  }
  
  public final boolean apa()
  {
    return false;
  }
  
  public final boolean apb()
  {
    return false;
  }
  
  public final String apc()
  {
    AppMethodBeat.i(30192);
    String str = s.nE(this.jUE);
    AppMethodBeat.o(30192);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.p apd()
  {
    AppMethodBeat.i(30183);
    dFe();
    d locald = new d(this, this.jUE);
    AppMethodBeat.o(30183);
    return locald;
  }
  
  public final com.tencent.mm.ui.contact.n ape()
  {
    AppMethodBeat.i(30184);
    dFe();
    q localq = new q(this, this.jUE);
    AppMethodBeat.o(30184);
    return localq;
  }
  
  public final void bOq()
  {
    AppMethodBeat.i(30186);
    super.bOq();
    AppMethodBeat.o(30186);
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(30187);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ab.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(30187);
      return;
    }
    if (!(getContentLV().getAdapter().getItem(paramInt) instanceof a))
    {
      ab.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
      AppMethodBeat.o(30187);
      return;
    }
    a locala = (a)getContentLV().getAdapter().getItem(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(30187);
      return;
    }
    String str = locala.username;
    long l = locala.jUy;
    if ((str == null) || (l == -1L))
    {
      ab.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", new Object[] { str, Long.valueOf(l) });
      AppMethodBeat.o(30187);
      return;
    }
    a(str, l, locala.gpH);
    AppMethodBeat.o(30187);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(30193);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(30193);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(30193);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    aeh localaeh;
    if (paramIntent != null)
    {
      ab.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
      String str = paramIntent.getString("enterprise_members");
      localaeh = new aeh();
      com.tencent.mm.aj.a.c localc = new com.tencent.mm.aj.a.c();
      if (this.ztq != null)
      {
        paramIntent = this.ztq.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.jUE;
        if (!e.a(localc, str, null, localaeh)) {
          break label257;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label204;
        }
        a(this.jUE, localc.field_bizChatLocalId, localc.field_chatName);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this, getString(2131302674), 0).show();
        AppMethodBeat.o(30193);
        return;
        paramIntent = null;
        break;
        label204:
        z.afq();
        paramIntent = com.tencent.mm.aj.a.h.a(this.jUE, localaeh, this);
        getString(2131297087);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131296440), true, new BizChatSelectConversationUI.5(this, paramIntent));
        paramInt1 = 1;
        continue;
        label257:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(30193);
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(30180);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
    dFe();
    paramBundle = z.afm().dg(this.jUE);
    this.ztq = z.afm().df(paramBundle);
    String str = this.jUE;
    if (this.ztq == null) {
      bool = true;
    }
    ab.i("MicroMsg.BizChatSelectConversationUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
    if ((bo.isNullOrNil(paramBundle)) || (this.ztq == null) || (this.ztq.afy()) || (bo.isNullOrNil(this.ztq.field_addMemberUrl)))
    {
      z.afq();
      com.tencent.mm.aj.a.h.a(this.jUE, this);
      paramBundle = getActivity();
      getString(2131297087);
      this.tipDialog = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131297112), true, new BizChatSelectConversationUI.6(this));
    }
    AppMethodBeat.o(30180);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(30181);
    super.onDestroy();
    AppMethodBeat.o(30181);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI
 * JD-Core Version:    0.7.0.1
 */