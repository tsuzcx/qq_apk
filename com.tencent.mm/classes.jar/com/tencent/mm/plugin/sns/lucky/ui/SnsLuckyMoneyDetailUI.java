package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.q.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI
  extends LuckyMoneyBaseUI
{
  private final int KBX;
  private final int KBY;
  private ListView KmY;
  AbsListView.OnScrollListener Knf;
  private b Qqd;
  
  public SnsLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(68357);
    this.Knf = new AbsListView.OnScrollListener()
    {
      private boolean Kng = false;
      private boolean Knh;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(68355);
        if ((paramAnonymousInt3 == 0) || (!this.Kng))
        {
          AppMethodBeat.o(68355);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label61:
        label108:
        label111:
        for (;;)
        {
          if (this.Knh != bool)
          {
            if (bool)
            {
              SnsLuckyMoneyDetailUI.this.getResources().getDrawable(a.c.sns_lucky_background_start_color);
              SnsLuckyMoneyDetailUI.hfp();
              this.Knh = bool;
            }
          }
          else
          {
            AppMethodBeat.o(68355);
            return;
            paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(paramAnonymousInt1);
            if (paramAnonymousAbsListView == null) {
              break label108;
            }
          }
          for (paramAnonymousInt1 = 0 - paramAnonymousAbsListView.getTop();; paramAnonymousInt1 = 0)
          {
            if (paramAnonymousInt1 > 100) {
              break label111;
            }
            bool = false;
            break;
            SnsLuckyMoneyDetailUI.hfq();
            break label61;
          }
        }
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(68354);
        if (paramAnonymousAbsListView.getCount() == 0)
        {
          AppMethodBeat.o(68354);
          return;
        }
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(68354);
          return;
          this.Kng = false;
          AppMethodBeat.o(68354);
          return;
          this.Kng = true;
        }
      }
    };
    this.KBX = 750;
    this.KBY = 240;
    AppMethodBeat.o(68357);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68360);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(68360);
    return bool;
  }
  
  public int getLayoutId()
  {
    return a.g.snslucky_money_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68359);
    getResources().getDrawable(a.e.lucky_money_actionbar_bg);
    setMMTitle(a.i.sns_lucky_detail_ui_title);
    setBackBtn(new SnsLuckyMoneyDetailUI.2(this));
    this.KmY = ((ListView)findViewById(a.f.lucky_money_detail_record_list));
    this.Qqd = new b(getContext());
    this.KmY.setAdapter(this.Qqd);
    this.KmY.setOnScrollListener(this.Knf);
    this.KmY.setOnItemClickListener(new SnsLuckyMoneyDetailUI.3(this));
    AppMethodBeat.o(68359);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68358);
    super.onCreate(paramBundle);
    initView();
    paramBundle = a.aKr(getIntent().getStringExtra("key_feedid"));
    if ((paramBundle == null) || (paramBundle.size() == 0))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        int i = getResources().getColor(a.c.sns_lucky_detail_ui_status_bar_color);
        getWindow().setStatusBarColor(i);
      }
      setMMSubTitle(null);
      AppMethodBeat.o(68358);
      return;
    }
    b localb = this.Qqd;
    if (paramBundle == null) {
      new LinkedList();
    }
    for (;;)
    {
      localb.notifyDataSetChanged();
      break;
      localb.KmK = paramBundle;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68361);
    super.onDestroy();
    AppMethodBeat.o(68361);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */