package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class SelectRemittanceContactUI
  extends MMBaseSelectContactUI
{
  private List<String> dru;
  private int fromScene;
  private View lYc;
  private List<String> nCT;
  
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
    if (this.fromScene == 1) {
      return getString(a.i.wallet_select_conversation_title);
    }
    return getString(a.i.remittance_title);
  }
  
  protected final o VF()
  {
    return new d(this, this.nCT, this.dru, this.fromScene);
  }
  
  protected final m VG()
  {
    return new q(this, this.dru, false, this.scene);
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    super.a(paramListView, paramInt);
    View localView;
    TextView localTextView;
    if (this.lYc == null)
    {
      localView = View.inflate(this, a.g.select_conversation_header, null);
      this.lYc = localView.findViewById(a.f.content);
      localTextView = (TextView)localView.findViewById(a.f.tip_tv);
      if (this.fromScene != 1) {
        break label75;
      }
      localTextView.setText(a.i.wallet_select_conversation_create);
    }
    for (;;)
    {
      paramListView.addHeaderView(localView);
      this.lYc.setVisibility(paramInt);
      return;
      label75:
      localTextView.setText(a.i.remittance_go_select_contact);
    }
  }
  
  public final int[] bgw()
  {
    if (this.fromScene == 1) {
      return new int[] { 131072, 131075 };
    }
    return new int[] { 131072 };
  }
  
  protected final void bgx()
  {
    super.bgx();
    XM();
  }
  
  public final void jP(int paramInt)
  {
    Object localObject;
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      y.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      y.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
      localObject = new Intent();
      if (this.fromScene == 1)
      {
        ((Intent)localObject).putExtra("list_attr", s.v(new int[] { s.vMq, 16384, 64, 4096, 262144 }));
        ((Intent)localObject).putExtra("min_limit_num", 1);
        ((Intent)localObject).putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        ((Intent)localObject).putExtra("titile", getString(a.i.wallet_select_create_chatroom_title));
        ((Intent)localObject).putExtra("without_openim", true);
        com.tencent.mm.br.d.c(this, ".ui.contact.SelectContactUI", (Intent)localObject, 1);
        overridePendingTransition(a.a.push_up_in, a.a.fast_faded_out);
      }
    }
    for (;;)
    {
      return;
      paramInt = s.v(new int[] { 16, 1, 2, 4, 16384 });
      ((Intent)localObject).putExtra("list_type", 0);
      ((Intent)localObject).putExtra("list_attr", paramInt);
      ((Intent)localObject).putExtra("titile", getString(a.i.remittance_select_receiver_title));
      ((Intent)localObject).putExtra("sub_title", getString(a.i.wallet_wechat_authenticate_safely));
      break;
      localObject = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ui.contact.a.a)localObject).dnp;
        if (localObject != null)
        {
          localObject = ((ao)localObject).field_username;
          y.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[] { localObject });
          Intent localIntent = new Intent();
          localIntent.putExtra("Select_Conv_User", (String)localObject);
          setResult(-1, localIntent);
          finish();
          XM();
          if ((cHE() instanceof d))
          {
            paramInt -= getContentLV().getHeaderViewsCount();
            localObject = (d)cHE();
            y.d("MicroMsg.RecentConversationAdapter", "pos: %s", new Object[] { Integer.valueOf(paramInt) });
            if (((d)localObject).nCR >= 0) {
              if (((d)localObject).nCS < 0) {
                paramInt = 1;
              }
            }
            while (paramInt != 0)
            {
              h.nFQ.f(13721, new Object[] { Integer.valueOf(6), Integer.valueOf(1) });
              return;
              if ((paramInt > ((d)localObject).nCR) && (paramInt < ((d)localObject).nCS)) {
                paramInt = 1;
              } else {
                paramInt = 0;
              }
            }
          }
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      y.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    while (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        y.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
        setResult(-1, paramIntent);
        finish();
      }
      return;
      y.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
    }
    y.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = " + paramInt1);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getKeyCode() == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      bgx();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected final void xK()
  {
    super.xK();
    this.fromScene = getIntent().getIntExtra("key_from_scene", 0);
    Object localObject = getIntent().getStringExtra("recent_remittance_contact_list");
    y.v("MicroMsg.SelectRemittanceContactUI", "recent list:" + (String)localObject);
    this.nCT = new ArrayList();
    if (!bk.bl((String)localObject)) {
      this.nCT = bk.G(((String)localObject).split(","));
    }
    localObject = new HashSet();
    ((HashSet)localObject).addAll(s.cHO());
    ((HashSet)localObject).addAll(s.cHP());
    String str = getIntent().getStringExtra("Select_block_List");
    if (!bk.bl(str)) {
      ((HashSet)localObject).addAll(bk.G(str.split(",")));
    }
    this.dru = new ArrayList();
    this.dru.addAll((Collection)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.SelectRemittanceContactUI
 * JD-Core Version:    0.7.0.1
 */