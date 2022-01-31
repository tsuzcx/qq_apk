package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ai.a.b.a;
import com.tencent.mm.ai.a.b.a.b;
import com.tencent.mm.ai.a.d;
import com.tencent.mm.ai.a.d.a;
import com.tencent.mm.ai.a.s;
import com.tencent.mm.ai.n;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;

public class BizChatFavUI
  extends MMActivity
  implements n
{
  private TextView emptyTipTv;
  private ListView hZn;
  private n.d hZq;
  private com.tencent.mm.ui.base.p hdi;
  private long idK;
  private String idQ;
  private boolean isCurrentActivity;
  private b.a veT;
  private d.a veU;
  private c veZ;
  
  public final void a(int paramInt, m paramm)
  {
    if (this.hdi != null) {
      this.hdi.dismiss();
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.enterprise_bizchat_fav;
  }
  
  protected final void initView()
  {
    this.hZn = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.bizchat_no_fav_conversation);
    this.hZn.setOnScrollListener(new BizChatFavUI.8(this));
    this.veZ = new c(this, new BizChatFavUI.9(this), this.idQ);
    this.veZ.setGetViewPositionCallback(new BizChatFavUI.10(this));
    this.veZ.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void D(View paramAnonymousView, int paramAnonymousInt)
      {
        BizChatFavUI.e(BizChatFavUI.this).performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
      }
    });
    this.veZ.a(new BizChatFavUI.12(this));
    this.hZn.setAdapter(this.veZ);
    this.hZq = new BizChatFavUI.13(this);
    com.tencent.mm.ui.tools.j localj = new com.tencent.mm.ui.tools.j(this);
    this.hZn.setOnItemLongClickListener(new BizChatFavUI.2(this, localj));
    this.hZn.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = (com.tencent.mm.ai.a.c)BizChatFavUI.c(BizChatFavUI.this).getItem(paramAnonymousInt);
        BizChatFavUI.b(BizChatFavUI.this, paramAnonymousAdapterView.field_bizChatLocalId);
      }
    });
    setBackBtn(new BizChatFavUI.7(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.idQ = getIntent().getStringExtra("Contact_User");
    y.i("MicroMsg.BizChatFavUI", "[registerListener]");
    this.veT = new b.a()
    {
      public final void a(b.a.b paramAnonymousb)
      {
        if ((paramAnonymousb != null) && (paramAnonymousb.ehn != null) && (BizChatFavUI.a(BizChatFavUI.this).equals(paramAnonymousb.ehn.field_brandUserName)))
        {
          y.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).yc();
          }
        }
      }
    };
    this.veU = new BizChatFavUI.6(this);
    z.MB().a(this.veT, getMainLooper());
    z.MA().a(this.veU, getMainLooper());
    initView();
    z.MG();
    paramBundle = new s(this.idQ);
    g.DO().dJT.a(paramBundle, 0);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.idK = ((com.tencent.mm.ai.a.c)this.veZ.getItem(paramView.position)).field_bizChatLocalId;
    paramContextMenu.add(paramView.position, 0, 1, R.l.bizchat_remove_fav);
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
    z.MB().a(this.veT);
    z.MA().a(this.veU);
    this.veZ.bcS();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.veZ.onPause();
    this.isCurrentActivity = false;
    au.getNotification().ew("");
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.idQ);
    if ((localad == null) || (!com.tencent.mm.n.a.gR(localad.field_type)))
    {
      finish();
      return;
    }
    setTitleMuteIconVisibility(8);
    this.isCurrentActivity = true;
    this.veZ.a(null, null);
    au.getNotification().ew(this.idQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatFavUI
 * JD-Core Version:    0.7.0.1
 */