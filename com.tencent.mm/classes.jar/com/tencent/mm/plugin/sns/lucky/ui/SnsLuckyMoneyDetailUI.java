package com.tencent.mm.plugin.sns.lucky.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.l.a;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import java.util.LinkedList;
import java.util.List;

public class SnsLuckyMoneyDetailUI
  extends LuckyMoneyBaseUI
{
  private ListView uhp;
  AbsListView.OnScrollListener uhw;
  private final int uuv;
  private final int uuw;
  private b xPj;
  
  public SnsLuckyMoneyDetailUI()
  {
    AppMethodBeat.i(68357);
    this.uhw = new AbsListView.OnScrollListener()
    {
      private boolean uhx = false;
      private boolean uhy;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        boolean bool = true;
        AppMethodBeat.i(68355);
        if ((paramAnonymousInt3 == 0) || (!this.uhx))
        {
          AppMethodBeat.o(68355);
          return;
        }
        if (paramAnonymousInt1 > 0) {}
        label60:
        label107:
        label110:
        for (;;)
        {
          if (this.uhy != bool)
          {
            if (bool)
            {
              SnsLuckyMoneyDetailUI.this.getResources().getDrawable(2131100918);
              SnsLuckyMoneyDetailUI.dGS();
              this.uhy = bool;
            }
          }
          else
          {
            AppMethodBeat.o(68355);
            return;
            paramAnonymousAbsListView = paramAnonymousAbsListView.getChildAt(paramAnonymousInt1);
            if (paramAnonymousAbsListView == null) {
              break label107;
            }
          }
          for (paramAnonymousInt1 = 0 - paramAnonymousAbsListView.getTop();; paramAnonymousInt1 = 0)
          {
            if (paramAnonymousInt1 > 100) {
              break label110;
            }
            bool = false;
            break;
            SnsLuckyMoneyDetailUI.dGT();
            break label60;
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
          this.uhx = false;
          AppMethodBeat.o(68354);
          return;
          this.uhx = true;
        }
      }
    };
    this.uuv = 750;
    this.uuw = 240;
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
    return 2131495625;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68359);
    getResources().getDrawable(2131232950);
    setMMTitle(2131763892);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68356);
        SnsLuckyMoneyDetailUI.this.finish();
        AppMethodBeat.o(68356);
        return true;
      }
    });
    this.uhp = ((ListView)findViewById(2131301770));
    this.xPj = new b(getContext());
    this.uhp.setAdapter(this.xPj);
    this.uhp.setOnScrollListener(this.uhw);
    this.uhp.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
    });
    AppMethodBeat.o(68359);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68358);
    super.onCreate(paramBundle);
    initView();
    paramBundle = a.akb(getIntent().getStringExtra("key_feedid"));
    if ((paramBundle == null) || (paramBundle.size() == 0))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        int i = getResources().getColor(2131100921);
        getWindow().setStatusBarColor(i);
      }
      setMMSubTitle(null);
      AppMethodBeat.o(68358);
      return;
    }
    b localb = this.xPj;
    if (paramBundle == null) {
      new LinkedList();
    }
    for (;;)
    {
      localb.notifyDataSetChanged();
      break;
      localb.uhb = paramBundle;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(68361);
    super.onDestroy();
    AppMethodBeat.o(68361);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI
 * JD-Core Version:    0.7.0.1
 */