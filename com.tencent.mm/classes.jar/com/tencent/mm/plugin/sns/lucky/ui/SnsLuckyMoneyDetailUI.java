package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.l.a;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI
  extends LuckyMoneyBaseUI
{
  private ListView ojo;
  AbsListView.OnScrollListener ojv;
  private final int otx;
  private final int oty;
  private b rcy;
  
  public SnsLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(45185);
    this.ojv = new SnsLuckyMoneyDetailUI.1(this);
    this.otx = 750;
    this.oty = 240;
    AppMethodBeat.o(45185);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(45188);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(45188);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2130970898;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45187);
    getResources().getDrawable(2130839340);
    setMMTitle(2131303881);
    setBackBtn(new SnsLuckyMoneyDetailUI.2(this));
    this.ojo = ((ListView)findViewById(2131825658));
    this.rcy = new b(getContext());
    this.ojo.setAdapter(this.rcy);
    this.ojo.setOnScrollListener(this.ojv);
    this.ojo.setOnItemClickListener(new SnsLuckyMoneyDetailUI.3(this));
    AppMethodBeat.o(45187);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45186);
    super.onCreate(paramBundle);
    initView();
    paramBundle = a.So(getIntent().getStringExtra("key_feedid"));
    if ((paramBundle == null) || (paramBundle.size() == 0))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        int i = getResources().getColor(2131690496);
        getWindow().setStatusBarColor(i);
      }
      setMMSubTitle(null);
      AppMethodBeat.o(45186);
      return;
    }
    b localb = this.rcy;
    if (paramBundle == null) {
      new LinkedList();
    }
    for (;;)
    {
      localb.notifyDataSetChanged();
      break;
      localb.oja = paramBundle;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(45189);
    super.onDestroy();
    AppMethodBeat.o(45189);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */