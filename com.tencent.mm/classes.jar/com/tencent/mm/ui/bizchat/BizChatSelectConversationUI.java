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
import com.tencent.mm.ak.t;
import com.tencent.mm.al.a.c;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.a.l;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.p;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.aec;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.r;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(19)
public class BizChatSelectConversationUI
  extends MMBaseSelectContactUI
  implements p
{
  k PaM;
  private TextView PbU;
  private String ppO = null;
  private int scene = 0;
  private com.tencent.mm.ui.base.q tipDialog = null;
  
  private com.tencent.mm.ui.widget.a.d a(String paramString1, String paramString2, String paramString3, final String paramString4, final long paramLong)
  {
    AppMethodBeat.i(34043);
    paramString1 = com.tencent.mm.pluginsdk.ui.applet.o.a(getController(), paramString1, paramString3, paramString2, true, getResources().getString(2131755976), new y.a()
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
  
  private void a(String paramString, long paramLong, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(34040);
    Log.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (this.scene == 2)
    {
      if (getIntent().getBooleanExtra("enterprise_extra_params", true))
      {
        r(paramString, String.valueOf(paramCharSequence), paramLong);
        AppMethodBeat.o(34040);
        return;
      }
      s(paramString, String.valueOf(paramCharSequence), paramLong);
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
  
  private void gMi()
  {
    AppMethodBeat.i(34034);
    if (Util.isNullOrNil(this.ppO))
    {
      this.ppO = getIntent().getStringExtra("enterprise_biz_name");
      if (Util.isNullOrNil(this.ppO))
      {
        Log.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
        finish();
      }
    }
    AppMethodBeat.o(34034);
  }
  
  private void r(final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(34041);
    com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, paramLong, getString(2131764634), paramString2, getString(2131755976), new y.a()
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
  
  private void s(final String paramString1, String paramString2, final long paramLong)
  {
    AppMethodBeat.i(34042);
    com.tencent.mm.pluginsdk.ui.applet.o.a(this.mController, paramLong, getString(2131764634), paramString2, getString(2131755976), new y.a()
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
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(232793);
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(232793);
      return;
    }
    if (!(getContentLV().getAdapter().getItem(paramInt) instanceof a))
    {
      Log.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
      AppMethodBeat.o(232793);
      return;
    }
    paramView = (a)getContentLV().getAdapter().getItem(paramInt);
    if (paramView == null)
    {
      AppMethodBeat.o(232793);
      return;
    }
    String str = paramView.username;
    long l = paramView.ppv;
    if ((str == null) || (l == -1L))
    {
      Log.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", new Object[] { str, Long.valueOf(l) });
      AppMethodBeat.o(232793);
      return;
    }
    a(str, l, paramView.jVL);
    AppMethodBeat.o(232793);
  }
  
  public final void a(int paramInt, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(34046);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramq.getType() == 1355)
    {
      paramq = ((com.tencent.mm.al.a.o)paramq).baD();
      paramq = ag.baj().NE(paramq.Lpw.LPp.KTl);
      if (paramq == null)
      {
        Toast.makeText(MMApplicationContext.getContext(), getString(2131764661), 0).show();
        AppMethodBeat.o(34046);
        return;
      }
      a(this.ppO, paramq.field_bizChatLocalId, paramq.field_chatName);
    }
    AppMethodBeat.o(34046);
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(34037);
    super.a(paramListView, paramInt);
    if (this.PbU == null)
    {
      Object localObject = new BizChatSelectConversationUI.1(this);
      String str = getString(2131765139);
      View localView = com.tencent.mm.ui.aa.jQ(this).inflate(2131494993, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131299223);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.PbU = ((TextView)localObject);
    }
    this.PbU.setVisibility(paramInt);
    AppMethodBeat.o(34037);
  }
  
  public final boolean bmA()
  {
    return false;
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(34044);
    String str = com.tencent.mm.model.aa.getDisplayName(this.ppO);
    AppMethodBeat.o(34044);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.q bmC()
  {
    AppMethodBeat.i(34035);
    gMi();
    d locald = new d(this, this.ppO);
    AppMethodBeat.o(34035);
    return locald;
  }
  
  public final com.tencent.mm.ui.contact.o bmD()
  {
    AppMethodBeat.i(34036);
    gMi();
    r localr = new r(this, this.ppO);
    AppMethodBeat.o(34036);
    return localr;
  }
  
  public final boolean bmz()
  {
    return false;
  }
  
  public final void egJ()
  {
    AppMethodBeat.i(34038);
    super.egJ();
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
    bfs localbfs;
    if (paramIntent != null)
    {
      Log.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
      String str = paramIntent.getString("enterprise_members");
      localbfs = new bfs();
      c localc = new c();
      if (this.PaM != null)
      {
        paramIntent = this.PaM.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.ppO;
        if (!e.a(localc, str, null, localbfs)) {
          break label257;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label204;
        }
        a(this.ppO, localc.field_bizChatLocalId, localc.field_chatName);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(this, getString(2131764661), 0).show();
        AppMethodBeat.o(34045);
        return;
        paramIntent = null;
        break;
        label204:
        ag.baq();
        paramIntent = com.tencent.mm.al.a.h.a(this.ppO, localbfs, this);
        getString(2131755998);
        this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(2131755186), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(34030);
            bg.azz().a(paramIntent);
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
    gMi();
    paramBundle = ag.bal().fC(this.ppO);
    this.PaM = ag.bal().fB(paramBundle);
    String str = this.ppO;
    if (this.PaM == null) {
      bool = true;
    }
    Log.i("MicroMsg.BizChatSelectConversationUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
    if ((Util.isNullOrNil(paramBundle)) || (this.PaM == null) || (this.PaM.bay()) || (Util.isNullOrNil(this.PaM.field_addMemberUrl)))
    {
      ag.baq();
      com.tencent.mm.al.a.h.a(this.ppO, this);
      paramBundle = getActivity();
      getString(2131755998);
      this.tipDialog = com.tencent.mm.ui.base.h.a(paramBundle, getString(2131756029), true, new DialogInterface.OnCancelListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI
 * JD-Core Version:    0.7.0.1
 */