package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.q.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI
  extends LuckyMoneyBaseUI
{
  private ListView lLU;
  AbsListView.OnScrollListener lMb = new SnsLuckyMoneyDetailUI.1(this);
  private final int lVx = 750;
  private final int lVy = 240;
  private b ooh;
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected final int getLayoutId()
  {
    return a.g.snslucky_money_detail_ui;
  }
  
  protected final void initView()
  {
    getResources().getDrawable(a.e.lucky_money_actionbar_bg);
    setMMTitle(a.i.sns_lucky_detail_ui_title);
    setBackBtn(new SnsLuckyMoneyDetailUI.2(this));
    this.lLU = ((ListView)findViewById(a.f.lucky_money_detail_record_list));
    this.ooh = new b(this.mController.uMN);
    this.lLU.setAdapter(this.ooh);
    this.lLU.setOnScrollListener(this.lMb);
    this.lLU.setOnItemClickListener(new SnsLuckyMoneyDetailUI.3(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
    paramBundle = a.GK(getIntent().getStringExtra("key_feedid"));
    if ((paramBundle == null) || (paramBundle.size() == 0))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        int i = getResources().getColor(a.c.sns_lucky_detail_ui_status_bar_color);
        getWindow().setStatusBarColor(i);
      }
      setMMSubTitle(null);
      return;
    }
    b localb = this.ooh;
    if (paramBundle == null) {
      new LinkedList();
    }
    for (;;)
    {
      localb.notifyDataSetChanged();
      break;
      localb.lLG = paramBundle;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */