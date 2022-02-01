package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.a.c;
import com.tencent.mm.an.a.h;
import com.tencent.mm.an.a.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.r;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(19)
public class BizChatSelectConversationUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.an.p
{
  com.tencent.mm.an.a.k aebr;
  private TextView aecz;
  private int scene = 0;
  private w tipDialog = null;
  private String vEu = null;
  
  private void a(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(34040);
    Log.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (this.scene == 2)
    {
      if (getIntent().getBooleanExtra("enterprise_extra_params", true))
      {
        v(paramString, String.valueOf(paramCharSequence), paramLong);
        AppMethodBeat.o(34040);
        return;
      }
      w(paramString, String.valueOf(paramCharSequence), paramLong);
      AppMethodBeat.o(34040);
      return;
    }
    if (this.scene == 1)
    {
      paramCharSequence = (HashMap)getIntent().getSerializableExtra("enterprise_extra_params");
      String str1 = (String)paramCharSequence.get("img_url");
      String str2 = (String)paramCharSequence.get("desc");
      b((String)paramCharSequence.get("title"), str2, str1, paramString, paramLong);
    }
    AppMethodBeat.o(34040);
  }
  
  private com.tencent.mm.ui.widget.a.e b(String paramString1, String paramString2, String paramString3, final String paramString4, final long paramLong)
  {
    AppMethodBeat.i(34043);
    paramString1 = com.tencent.mm.pluginsdk.ui.applet.o.a(getController(), paramString1, paramString3, paramString2, true, getResources().getString(R.l.app_send), new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(34029);
        if (paramAnonymousBoolean)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enterprise_biz_name", paramString4);
          localIntent.putExtra("key_biz_chat_id", paramLong);
          localIntent.putExtra("key_is_biz_chat", true);
          if (!Util.isNullOrNil(paramAnonymousString)) {
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
  
  private void jnR()
  {
    AppMethodBeat.i(34034);
    if (Util.isNullOrNil(this.vEu))
    {
      this.vEu = getIntent().getStringExtra("enterprise_biz_name");
      if (Util.isNullOrNil(this.vEu))
      {
        Log.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
        finish();
      }
    }
    AppMethodBeat.o(34034);
  }
  
  private void v(final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(34041);
    com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, paramLong, getString(R.l.retransmit_to_conv_comfirm2), paramString2, getString(R.l.app_send), new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
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
  
  private void w(final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(34042);
    com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, paramLong, getString(R.l.retransmit_to_conv_comfirm2), paramString2, getString(R.l.app_send), new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
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
  
  public final void a(int paramInt, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(34046);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramp.getType() == 1355)
    {
      paramp = ((com.tencent.mm.an.a.o)paramp).bHE();
      paramp = com.tencent.mm.an.af.bHh().MZ(paramp.ZpT.aajx.YRJ);
      if (paramp == null)
      {
        Toast.makeText(MMApplicationContext.getContext(), getString(R.l.gTp), 0).show();
        AppMethodBeat.o(34046);
        return;
      }
      a(this.vEu, paramp.field_bizChatLocalId, paramp.field_chatName);
    }
    AppMethodBeat.o(34046);
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(250762);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(250762);
      return;
    }
    if (!(getContentLV().getAdapter().getItem(paramInt) instanceof a))
    {
      Log.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
      AppMethodBeat.o(250762);
      return;
    }
    paramAdapterView = (a)getContentLV().getAdapter().getItem(paramInt);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(250762);
      return;
    }
    paramView = paramAdapterView.username;
    paramLong = paramAdapterView.vEb;
    if ((paramView == null) || (paramLong == -1L))
    {
      Log.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", new Object[] { paramView, Long.valueOf(paramLong) });
      AppMethodBeat.o(250762);
      return;
    }
    a(paramView, paramLong, paramAdapterView.pJG);
    AppMethodBeat.o(250762);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(34037);
    super.a(paramListView, paramInt);
    if (this.aecz == null)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(34026);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/bizchat/BizChatSelectConversationUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          BizChatSelectConversationUI.a(BizChatSelectConversationUI.this);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatSelectConversationUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34026);
        }
      };
      String str = getString(R.l.gUD);
      View localView = com.tencent.mm.ui.af.mU(this).inflate(R.i.gkq, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(R.h.content_tv);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.aecz = ((TextView)localObject);
    }
    this.aecz.setVisibility(paramInt);
    AppMethodBeat.o(34037);
  }
  
  public final r bVA()
  {
    AppMethodBeat.i(34035);
    jnR();
    d locald = new d(this, this.vEu);
    AppMethodBeat.o(34035);
    return locald;
  }
  
  public final com.tencent.mm.ui.contact.p bVB()
  {
    AppMethodBeat.i(34036);
    jnR();
    com.tencent.mm.ui.contact.s locals = new com.tencent.mm.ui.contact.s(this, this.vEu);
    AppMethodBeat.o(34036);
    return locals;
  }
  
  public final boolean bVx()
  {
    return false;
  }
  
  public final boolean bVy()
  {
    return false;
  }
  
  public final String bVz()
  {
    AppMethodBeat.i(34044);
    String str = aa.getDisplayName(this.vEu);
    AppMethodBeat.o(34044);
    return str;
  }
  
  public final void fYZ()
  {
    AppMethodBeat.i(34038);
    super.fYZ();
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
    cam localcam;
    if (paramIntent != null)
    {
      Log.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
      String str = paramIntent.getString("enterprise_members");
      localcam = new cam();
      c localc = new c();
      if (this.aebr != null)
      {
        paramIntent = this.aebr.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.vEu;
        if (!com.tencent.mm.an.a.e.a(localc, str, null, localcam)) {
          break label257;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label204;
        }
        a(this.vEu, localc.field_bizChatLocalId, localc.field_chatName);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this, getString(R.l.gTp), 0).show();
        AppMethodBeat.o(34045);
        return;
        paramIntent = null;
        break;
        label204:
        com.tencent.mm.an.af.bHp();
        paramIntent = h.a(this.vEu, localcam, this);
        getString(R.l.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.k.a(this, getString(R.l.gpQ), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(34030);
            bh.aZW().a(paramIntent);
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
    jnR();
    paramBundle = com.tencent.mm.an.af.bHj().hN(this.vEu);
    this.aebr = com.tencent.mm.an.af.bHj().hM(paramBundle);
    String str = this.vEu;
    if (this.aebr == null) {
      bool = true;
    }
    Log.i("MicroMsg.BizChatSelectConversationUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
    if ((Util.isNullOrNil(paramBundle)) || (this.aebr == null) || (this.aebr.bHy()) || (Util.isNullOrNil(this.aebr.field_addMemberUrl)))
    {
      com.tencent.mm.an.af.bHp();
      h.a(this.vEu, this);
      paramBundle = getActivity();
      getString(R.l.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.k.a(paramBundle, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI
 * JD-Core Version:    0.7.0.1
 */