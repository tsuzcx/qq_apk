package com.tencent.mm.ui.bizchat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.ag;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.auj;
import com.tencent.mm.protocal.protobuf.nb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.z;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(19)
public class BizChatSelectConversationUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.al.p
{
  k JPI;
  private TextView JQP;
  private String oeQ = null;
  private int scene = 0;
  private com.tencent.mm.ui.base.p tipDialog = null;
  
  private com.tencent.mm.ui.widget.a.d a(String paramString1, String paramString2, String paramString3, final String paramString4, final long paramLong)
  {
    AppMethodBeat.i(34043);
    paramString1 = com.tencent.mm.pluginsdk.ui.applet.o.a(getController(), paramString1, paramString3, paramString2, true, getResources().getString(2131755884), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(34029);
        if (paramAnonymousBoolean)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enterprise_biz_name", paramString4);
          localIntent.putExtra("key_biz_chat_id", paramLong);
          localIntent.putExtra("key_is_biz_chat", true);
          if (!bu.isNullOrNil(paramAnonymousString)) {
            localIntent.putExtra("enterprise_share_append_text", paramAnonymousString);
          }
          BizChatSelectConversationUI.this.setResult(-1, localIntent);
          BizChatSelectConversationUI.this.finish();
        }
        AppMethodBeat.o(34029);
      }
    });
    AppMethodBeat.o(34043);
    return paramString1;
  }
  
  private void a(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(34040);
    ae.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (this.scene == 2)
    {
      if (getIntent().getBooleanExtra("enterprise_extra_params", true))
      {
        p(paramString, String.valueOf(paramCharSequence), paramLong);
        AppMethodBeat.o(34040);
        return;
      }
      q(paramString, String.valueOf(paramCharSequence), paramLong);
      AppMethodBeat.o(34040);
      return;
    }
    if (this.scene == 1)
    {
      paramCharSequence = (HashMap)getIntent().getSerializableExtra("enterprise_extra_params");
      String str1 = (String)paramCharSequence.get("img_url");
      String str2 = (String)paramCharSequence.get("desc");
      a((String)paramCharSequence.get("title"), str2, str1, paramString, paramLong);
    }
    AppMethodBeat.o(34040);
  }
  
  private void fEb()
  {
    AppMethodBeat.i(34034);
    if (bu.isNullOrNil(this.oeQ))
    {
      this.oeQ = getIntent().getStringExtra("enterprise_biz_name");
      if (bu.isNullOrNil(this.oeQ))
      {
        ae.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
        finish();
      }
    }
    AppMethodBeat.o(34034);
  }
  
  private void p(final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(34041);
    com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, paramLong, getString(2131762565), paramString2, getString(2131755884), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(34027);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("enterprise_biz_name", paramString1);
          paramAnonymousString.putExtra("key_biz_chat_id", paramLong);
          paramAnonymousString.putExtra("key_is_biz_chat", true);
          BizChatSelectConversationUI.this.setResult(-1, paramAnonymousString);
          BizChatSelectConversationUI.this.finish();
        }
        AppMethodBeat.o(34027);
      }
    });
    AppMethodBeat.o(34041);
  }
  
  private void q(final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(34042);
    com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, paramLong, getString(2131762565), paramString2, getString(2131755884), new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(34028);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtra("enterprise_biz_name", paramString1);
          paramAnonymousString.putExtra("key_biz_chat_id", paramLong);
          paramAnonymousString.putExtra("key_is_biz_chat", true);
          BizChatSelectConversationUI.this.setResult(-1, paramAnonymousString);
          BizChatSelectConversationUI.this.finish();
        }
        AppMethodBeat.o(34028);
      }
    });
    AppMethodBeat.o(34042);
  }
  
  public final void a(int paramInt, n paramn)
  {
    AppMethodBeat.i(34046);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramn.getType() == 1355)
    {
      paramn = ((com.tencent.mm.al.a.o)paramn).aGK();
      paramn = ag.aGr().EQ(paramn.GtU.GLl.FZq);
      if (paramn == null)
      {
        Toast.makeText(ak.getContext(), getString(2131762583), 0).show();
        AppMethodBeat.o(34046);
        return;
      }
      a(this.oeQ, paramn.field_bizChatLocalId, paramn.field_chatName);
    }
    AppMethodBeat.o(34046);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(34037);
    super.a(paramListView, paramInt);
    if (this.JQP == null)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(34026);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatSelectConversationUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          BizChatSelectConversationUI.a(BizChatSelectConversationUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatSelectConversationUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34026);
        }
      };
      String str = getString(2131763002);
      View localView = z.jV(this).inflate(2131494420, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131298778);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.JQP = ((TextView)localObject);
    }
    this.JQP.setVisibility(paramInt);
    AppMethodBeat.o(34037);
  }
  
  public final boolean aRT()
  {
    return false;
  }
  
  public final boolean aRU()
  {
    return false;
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(34044);
    String str = w.zP(this.oeQ);
    AppMethodBeat.o(34044);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.q aRW()
  {
    AppMethodBeat.i(34035);
    fEb();
    d locald = new d(this, this.oeQ);
    AppMethodBeat.o(34035);
    return locald;
  }
  
  public final com.tencent.mm.ui.contact.o aRX()
  {
    AppMethodBeat.i(34036);
    fEb();
    r localr = new r(this, this.oeQ);
    AppMethodBeat.o(34036);
    return localr;
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(34038);
    super.dmJ();
    AppMethodBeat.o(34038);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(34045);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(34045);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(34045);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    auj localauj;
    if (paramIntent != null)
    {
      ae.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
      String str = paramIntent.getString("enterprise_members");
      localauj = new auj();
      c localc = new c();
      if (this.JPI != null)
      {
        paramIntent = this.JPI.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.oeQ;
        if (!e.a(localc, str, null, localauj)) {
          break label257;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label204;
        }
        a(this.oeQ, localc.field_bizChatLocalId, localc.field_chatName);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this, getString(2131762583), 0).show();
        AppMethodBeat.o(34045);
        return;
        paramIntent = null;
        break;
        label204:
        ag.aGx();
        paramIntent = com.tencent.mm.al.a.h.a(this.oeQ, localauj, this);
        getString(2131755906);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131755168), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(34030);
            bc.ajj().a(paramIntent);
            AppMethodBeat.o(34030);
          }
        });
        paramInt1 = 1;
        continue;
        label257:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(34045);
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(34032);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
    fEb();
    paramBundle = ag.aGt().eQ(this.oeQ);
    this.JPI = ag.aGt().eP(paramBundle);
    String str = this.oeQ;
    if (this.JPI == null) {
      bool = true;
    }
    ae.i("MicroMsg.BizChatSelectConversationUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
    if ((bu.isNullOrNil(paramBundle)) || (this.JPI == null) || (this.JPI.aGF()) || (bu.isNullOrNil(this.JPI.field_addMemberUrl)))
    {
      ag.aGx();
      com.tencent.mm.al.a.h.a(this.oeQ, this);
      paramBundle = getActivity();
      getString(2131755906);
      this.tipDialog = com.tencent.mm.ui.base.h.b(paramBundle, getString(2131755936), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(34031);
          BizChatSelectConversationUI.this.finish();
          AppMethodBeat.o(34031);
        }
      });
    }
    AppMethodBeat.o(34032);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34033);
    super.onDestroy();
    AppMethodBeat.o(34033);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(34039);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ae.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34039);
      return;
    }
    if (!(getContentLV().getAdapter().getItem(paramInt) instanceof a))
    {
      ae.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
      AppMethodBeat.o(34039);
      return;
    }
    a locala = (a)getContentLV().getAdapter().getItem(paramInt);
    if (locala == null)
    {
      AppMethodBeat.o(34039);
      return;
    }
    String str = locala.username;
    long l = locala.oex;
    if ((str == null) || (l == -1L))
    {
      ae.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", new Object[] { str, Long.valueOf(l) });
      AppMethodBeat.o(34039);
      return;
    }
    a(str, l, locala.iYg);
    AppMethodBeat.o(34039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI
 * JD-Core Version:    0.7.0.1
 */