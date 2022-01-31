package com.tencent.mm.ui.bizchat;

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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.a.c;
import com.tencent.mm.ai.a.e;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.ai.a.k;
import com.tencent.mm.ai.z;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.rx;
import com.tencent.mm.protocal.c.zp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import java.util.HashMap;

@com.tencent.mm.ui.base.a(19)
public class BizChatSelectConversationUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.ai.n
{
  private String idQ = null;
  private int scene = 0;
  private com.tencent.mm.ui.base.p tipDialog = null;
  j veR;
  private TextView vfO;
  
  private void a(final String paramString, final long paramLong, CharSequence paramCharSequence)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (this.scene == 2) {
      if (getIntent().getBooleanExtra("enterprise_extra_params", true))
      {
        paramCharSequence = String.valueOf(paramCharSequence);
        g.a(this.mController, paramLong, getString(R.l.retransmit_to_conv_comfirm2), paramCharSequence, getString(R.l.app_send), new BizChatSelectConversationUI.2(this, paramString, paramLong));
      }
    }
    while (this.scene != 1)
    {
      return;
      paramCharSequence = String.valueOf(paramCharSequence);
      g.a(this.mController, paramLong, getString(R.l.retransmit_to_conv_comfirm2), paramCharSequence, getString(R.l.app_send), new BizChatSelectConversationUI.3(this, paramString, paramLong));
      return;
    }
    Object localObject = (HashMap)getIntent().getSerializableExtra("enterprise_extra_params");
    paramCharSequence = (String)((HashMap)localObject).get("img_url");
    String str = (String)((HashMap)localObject).get("desc");
    localObject = (String)((HashMap)localObject).get("title");
    g.a(this.mController, (String)localObject, paramCharSequence, str, true, getResources().getString(R.l.app_send), new q.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        if (paramAnonymousBoolean)
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("enterprise_biz_name", paramString);
          localIntent.putExtra("key_biz_chat_id", paramLong);
          localIntent.putExtra("key_is_biz_chat", true);
          if (!bk.bl(paramAnonymousString)) {
            localIntent.putExtra("enterprise_share_append_text", paramAnonymousString);
          }
          BizChatSelectConversationUI.this.setResult(-1, localIntent);
          BizChatSelectConversationUI.this.finish();
        }
      }
    });
  }
  
  private void cBI()
  {
    if (bk.bl(this.idQ))
    {
      this.idQ = getIntent().getStringExtra("enterprise_biz_name");
      if (bk.bl(this.idQ))
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
        finish();
      }
    }
  }
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return false;
  }
  
  protected final String VE()
  {
    return r.gV(this.idQ);
  }
  
  protected final o VF()
  {
    cBI();
    return new d(this, this.idQ);
  }
  
  protected final com.tencent.mm.ui.contact.m VG()
  {
    cBI();
    return new com.tencent.mm.ui.contact.p(this, this.idQ);
  }
  
  public final void a(int paramInt, com.tencent.mm.ah.m paramm)
  {
    if ((this.tipDialog != null) && (this.tipDialog.isShowing()))
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramm.getType() == 1355)
    {
      paramm = ((com.tencent.mm.ai.a.n)paramm).MT();
      paramm = z.MA().lp(paramm.sPX.sYQ.sCI);
      if (paramm == null) {
        Toast.makeText(ae.getContext(), getString(R.l.room_change_add_memberfail), 0).show();
      }
    }
    else
    {
      return;
    }
    a(this.idQ, paramm.field_bizChatLocalId, paramm.field_chatName);
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    super.a(paramListView, paramInt);
    if (this.vfO == null)
    {
      Object localObject = new BizChatSelectConversationUI.1(this);
      String str = getString(R.l.select_conversation_create);
      View localView = com.tencent.mm.ui.y.gt(this).inflate(R.i.group_card_item, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(R.h.content_tv);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.vfO = ((TextView)localObject);
    }
    this.vfO.setVisibility(paramInt);
  }
  
  protected final void bgx()
  {
    super.bgx();
  }
  
  public final void jP(int paramInt)
  {
    if (paramInt < getContentLV().getHeaderViewsCount()) {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
    }
    a locala;
    do
    {
      return;
      if (!(getContentLV().getAdapter().getItem(paramInt) instanceof a))
      {
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
        return;
      }
      locala = (a)getContentLV().getAdapter().getItem(paramInt);
    } while (locala == null);
    String str = locala.username;
    long l = locala.idK;
    if ((str == null) || (l == -1L))
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", new Object[] { str, Long.valueOf(l) });
      return;
    }
    a(str, l, locala.eXK);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    label180:
    label233:
    label241:
    for (;;)
    {
      return;
      switch (paramInt1)
      {
      default: 
        return;
      }
      paramIntent = paramIntent.getBundleExtra("result_data");
      zp localzp;
      if (paramIntent != null)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
        String str = paramIntent.getString("enterprise_members");
        localzp = new zp();
        c localc = new c();
        if (this.veR != null)
        {
          paramIntent = this.veR.field_addMemberUrl;
          localc.field_addMemberUrl = paramIntent;
          localc.field_brandUserName = this.idQ;
          if (!e.a(localc, str, null, localzp)) {
            break label233;
          }
          if (localc.field_bizChatLocalId == -1L) {
            break label180;
          }
          a(this.idQ, localc.field_bizChatLocalId, localc.field_chatName);
          paramInt1 = 1;
        }
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label241;
        }
        Toast.makeText(this, getString(R.l.room_change_add_memberfail), 0).show();
        return;
        paramIntent = null;
        break;
        z.MG();
        paramIntent = com.tencent.mm.ai.a.h.a(this.idQ, localzp, this);
        getString(R.l.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.b(this, getString(R.l.adding_room_mem), true, new BizChatSelectConversationUI.5(this, paramIntent));
        paramInt1 = 1;
        continue;
        paramInt1 = 0;
        continue;
        paramInt1 = 0;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
    cBI();
    paramBundle = z.MC().bZ(this.idQ);
    this.veR = z.MC().bY(paramBundle);
    String str = this.idQ;
    if (this.veR == null) {
      bool = true;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BizChatSelectConversationUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
    if ((bk.bl(paramBundle)) || (this.veR == null) || (this.veR.MO()) || (bk.bl(this.veR.field_addMemberUrl)))
    {
      z.MG();
      com.tencent.mm.ai.a.h.a(this.idQ, this);
      paramBundle = getActivity();
      getString(R.l.app_tip);
      this.tipDialog = com.tencent.mm.ui.base.h.b(paramBundle, getString(R.l.app_waiting), true, new BizChatSelectConversationUI.6(this));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI
 * JD-Core Version:    0.7.0.1
 */