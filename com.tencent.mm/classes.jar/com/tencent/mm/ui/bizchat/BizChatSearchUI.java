package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelvoiceaddr.ui.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;

@a(3)
public class BizChatSearchUI
  extends MMActivity
  implements b.a, BizChatSearchListView.a
{
  String idQ;
  b idl;
  private AbsListView.OnScrollListener kXQ = new BizChatSearchUI.1(this);
  private int scene;
  private String vfd;
  private BizChatSearchUI.c vfe;
  BizChatSearchListView vff;
  TextView vfg;
  private BizChatSearchUI.a vfh;
  
  public final void GE(int paramInt)
  {
    BizChatSearchUI.c localc;
    if (this.vfe != null) {
      localc = this.vfe;
    }
    switch (paramInt)
    {
    default: 
      localc.v(false, false);
      return;
    case 1: 
      localc.v(true, false);
      return;
    }
    localc.v(false, true);
  }
  
  public final void TP()
  {
    XM();
  }
  
  public final void Wl()
  {
    finish();
  }
  
  public final void Wm() {}
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  public final void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong, int paramInt) {}
  
  public final boolean axC()
  {
    XM();
    return false;
  }
  
  protected final int getLayoutId()
  {
    return R.i.enterprise_bizchat_search;
  }
  
  protected final void initView()
  {
    if (bk.bl(this.idQ))
    {
      this.idQ = getIntent().getStringExtra("enterprise_biz_name");
      this.scene = getIntent().getIntExtra("biz_chat_search_scene", 1);
      this.vfd = getIntent().getStringExtra("biz_chat_search_text");
      if (bk.bl(this.idQ)) {
        finish();
      }
    }
    this.vff = ((BizChatSearchListView)findViewById(R.h.bizchat_lv));
    this.vfg = ((TextView)findViewById(R.h.no_result_tv));
    this.vfh = new BizChatSearchUI.a(this.mController.uMN, this.idQ, this.scene);
    if (BizChatSearchUI.a.a(this.vfh))
    {
      this.vfe = new BizChatSearchUI.c((byte)0);
      BizChatSearchListView localBizChatSearchListView = this.vff;
      BizChatSearchUI.c localc = this.vfe;
      View localView = View.inflate(this.mController.uMN, R.i.loading_footer, null);
      localc.ida = localView.findViewById(R.h.loading_progress);
      localc.idb = localView.findViewById(R.h.loading_end);
      localc.idc = localView.findViewById(R.h.loading_tip);
      localc.ida.setVisibility(8);
      localc.idb.setVisibility(8);
      localc.idc.setVisibility(8);
      localBizChatSearchListView.addFooterView(localView);
      GE(0);
    }
    this.vff.setAdapter(this.vfh);
    this.vff.setOnItemClickListener(new BizChatSearchUI.2(this));
    this.vff.setOnTouchListener(this);
    if (BizChatSearchUI.a.a(this.vfh)) {
      this.vff.setOnScrollListener(this.kXQ);
    }
    this.idl = new b();
    this.idl.nK(BizChatSearchUI.a.b(this.vfh));
    this.idl.a(this);
    this.idl.eNe = false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.idl.a(this, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.idl.cancel();
    this.idl.clearFocus();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    this.idl.a(this, paramMenu);
    return true;
  }
  
  public final boolean pB(String paramString)
  {
    XM();
    return true;
  }
  
  public final void pC(String paramString)
  {
    BizChatSearchUI.a locala = null;
    if ((bk.bl(paramString)) && (this.vfd != null))
    {
      paramString = this.vfd;
      this.vfd = null;
      if (!paramString.equals("")) {
        this.idl.setSearchContent(paramString);
      }
      b localb = this.idl;
      if (BizChatSearchUI.a.b(this.vfh))
      {
        paramString = this.mController.uMN.getResources().getString(R.l.bizchat_search_main_hint);
        localb.setHint(paramString);
        this.idl.clearFocus();
      }
    }
    do
    {
      return;
      if (BizChatSearchUI.a.a(this.vfh))
      {
        paramString = this.mController.uMN.getResources().getString(R.l.bizchat_search_user_hint);
        break;
      }
      paramString = locala;
      if (!BizChatSearchUI.a.d(this.vfh)) {
        break;
      }
      paramString = this.mController.uMN.getResources().getString(R.l.bizchat_search_group_hint);
      break;
      locala = this.vfh;
      locala.drv = paramString;
      if (bk.bl(paramString))
      {
        locala.adg();
        locala.vfx = false;
        locala.vfB = false;
        locala.nh(true);
        return;
      }
      if (locala.cBF())
      {
        locala.vfx = true;
        locala.vfB = false;
        locala.cBH();
        locala.bK(paramString, false);
        locala.adk(paramString);
        return;
      }
      locala.bK(paramString, true);
    } while ((!locala.vfl) || (!locala.vfx));
    locala.adk(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSearchUI
 * JD-Core Version:    0.7.0.1
 */