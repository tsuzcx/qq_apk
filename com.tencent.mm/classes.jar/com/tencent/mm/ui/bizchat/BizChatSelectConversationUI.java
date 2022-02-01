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
import com.tencent.mm.al.n;
import com.tencent.mm.am.a.c;
import com.tencent.mm.am.a.e;
import com.tencent.mm.am.a.k;
import com.tencent.mm.am.a.l;
import com.tencent.mm.am.ag;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.abr;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.mz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.z;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(19)
public class BizChatSelectConversationUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.am.p
{
  k JuS;
  private TextView JvZ;
  private String nZh = null;
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
          if (!bt.isNullOrNil(paramAnonymousString)) {
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
    ad.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", new Object[] { paramString });
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
  
  private void fzZ()
  {
    AppMethodBeat.i(34034);
    if (bt.isNullOrNil(this.nZh))
    {
      this.nZh = getIntent().getStringExtra("enterprise_biz_name");
      if (bt.isNullOrNil(this.nZh))
      {
        ad.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
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
      paramn = ((com.tencent.mm.am.a.o)paramn).aGu();
      paramn = ag.aGb().Eo(paramn.Gbn.GrN.FGU);
      if (paramn == null)
      {
        Toast.makeText(aj.getContext(), getString(2131762583), 0).show();
        AppMethodBeat.o(34046);
        return;
      }
      a(this.nZh, paramn.field_bizChatLocalId, paramn.field_chatName);
    }
    AppMethodBeat.o(34046);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(34037);
    super.a(paramListView, paramInt);
    if (this.JvZ == null)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(34026);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/bizchat/BizChatSelectConversationUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          BizChatSelectConversationUI.a(BizChatSelectConversationUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatSelectConversationUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34026);
        }
      };
      String str = getString(2131763002);
      View localView = z.jO(this).inflate(2131494420, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131298778);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.JvZ = ((TextView)localObject);
    }
    this.JvZ.setVisibility(paramInt);
    AppMethodBeat.o(34037);
  }
  
  public final boolean aRu()
  {
    return false;
  }
  
  public final boolean aRv()
  {
    return false;
  }
  
  public final String aRw()
  {
    AppMethodBeat.i(34044);
    String str = v.zf(this.nZh);
    AppMethodBeat.o(34044);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.q aRx()
  {
    AppMethodBeat.i(34035);
    fzZ();
    d locald = new d(this, this.nZh);
    AppMethodBeat.o(34035);
    return locald;
  }
  
  public final com.tencent.mm.ui.contact.o aRy()
  {
    AppMethodBeat.i(34036);
    fzZ();
    r localr = new r(this, this.nZh);
    AppMethodBeat.o(34036);
    return localr;
  }
  
  public final void djK()
  {
    AppMethodBeat.i(34038);
    super.djK();
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
    att localatt;
    if (paramIntent != null)
    {
      ad.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
      String str = paramIntent.getString("enterprise_members");
      localatt = new att();
      c localc = new c();
      if (this.JuS != null)
      {
        paramIntent = this.JuS.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.nZh;
        if (!e.a(localc, str, null, localatt)) {
          break label257;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label204;
        }
        a(this.nZh, localc.field_bizChatLocalId, localc.field_chatName);
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
        ag.aGh();
        paramIntent = com.tencent.mm.am.a.h.a(this.nZh, localatt, this);
        getString(2131755906);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(2131755168), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(34030);
            ba.aiU().a(paramIntent);
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
    fzZ();
    paramBundle = ag.aGd().eL(this.nZh);
    this.JuS = ag.aGd().eK(paramBundle);
    String str = this.nZh;
    if (this.JuS == null) {
      bool = true;
    }
    ad.i("MicroMsg.BizChatSelectConversationUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
    if ((bt.isNullOrNil(paramBundle)) || (this.JuS == null) || (this.JuS.aGp()) || (bt.isNullOrNil(this.JuS.field_addMemberUrl)))
    {
      ag.aGh();
      com.tencent.mm.am.a.h.a(this.nZh, this);
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
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(34039);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ad.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(34039);
      return;
    }
    if (!(getContentLV().getAdapter().getItem(paramInt) instanceof a))
    {
      ad.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
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
    long l = locala.nYO;
    if ((str == null) || (l == -1L))
    {
      ad.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", new Object[] { str, Long.valueOf(l) });
      AppMethodBeat.o(34039);
      return;
    }
    a(str, l, locala.iVn);
    AppMethodBeat.o(34039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI
 * JD-Core Version:    0.7.0.1
 */