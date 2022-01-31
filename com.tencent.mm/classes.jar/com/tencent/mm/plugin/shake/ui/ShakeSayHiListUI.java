package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class ShakeSayHiListUI
  extends MMActivity
{
  private ListView gvV;
  private long jDz;
  private n.d jSn;
  private int limit;
  private int pdM;
  private int pdN;
  private bu qPs;
  private int qRA;
  private b qRB;
  
  public ShakeSayHiListUI()
  {
    AppMethodBeat.i(24884);
    this.qRA = 0;
    this.qPs = null;
    this.limit = 0;
    this.pdM = 0;
    this.pdN = 0;
    this.jSn = new ShakeSayHiListUI.2(this);
    AppMethodBeat.o(24884);
  }
  
  public int getLayoutId()
  {
    return 2130969979;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24890);
    Object localObject = getLayoutInflater().inflate(2130970596, null);
    this.gvV = ((ListView)findViewById(2131825413));
    ((View)localObject).setOnClickListener(new ShakeSayHiListUI.1(this, (View)localObject));
    addTextOptionMenu(0, getString(2131296891), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(24876);
        h.a(ShakeSayHiListUI.this.getContext(), true, ShakeSayHiListUI.this.getString(2131302875), "", ShakeSayHiListUI.this.getString(2131302874), ShakeSayHiListUI.this.getString(2131296888), new ShakeSayHiListUI.3.1(this), new ShakeSayHiListUI.3.2(this));
        AppMethodBeat.o(24876);
        return true;
      }
    });
    if (this.pdM == 0)
    {
      TextView localTextView = (TextView)findViewById(2131821852);
      localTextView.setText(2131302880);
      localTextView.setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.pdM > 0) && (this.limit < this.pdM)) {
      this.gvV.addFooterView((View)localObject);
    }
    this.qRB = new b(this, this.qPs, this.limit);
    this.qRB.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dc(View paramAnonymousView)
      {
        AppMethodBeat.i(24877);
        int i = ShakeSayHiListUI.d(ShakeSayHiListUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(24877);
        return i;
      }
    });
    this.qRB.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(24878);
        ShakeSayHiListUI.d(ShakeSayHiListUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(24878);
      }
    });
    this.qRB.a(new ShakeSayHiListUI.6(this));
    this.gvV.setAdapter(this.qRB);
    this.gvV.setOnItemClickListener(new ShakeSayHiListUI.7(this));
    localObject = new l(this);
    this.gvV.setOnItemLongClickListener(new ShakeSayHiListUI.8(this, (l)localObject));
    setBackBtn(new ShakeSayHiListUI.9(this));
    setToTop(new ShakeSayHiListUI.10(this));
    AppMethodBeat.o(24890);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24885);
    super.onCreate(paramBundle);
    this.qRA = getIntent().getIntExtra("IntentSayHiType", 1);
    if (this.qRA == 1)
    {
      this.qPs = d.alk();
      setMMTitle(2131302879);
      this.pdN = this.qPs.bbZ();
      if (this.pdN != 0) {
        break label160;
      }
    }
    label160:
    for (int i = 8;; i = this.pdN)
    {
      this.limit = i;
      this.pdM = this.qPs.getCount();
      paramBundle = this.qPs;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      AppMethodBeat.o(24885);
      return;
      setMMTitle(2131302877);
      break;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(24891);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.jDz = ((bt)this.qRB.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131296901);
    AppMethodBeat.o(24891);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24887);
    this.qRB.bKb();
    super.onDestroy();
    AppMethodBeat.o(24887);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(24889);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(24889);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(24888);
    super.onPause();
    if (this.qRB.jSe != null) {
      this.qRB.jSe.bKk();
    }
    AppMethodBeat.o(24888);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24886);
    super.onResume();
    if (this.pdM != this.qPs.getCount())
    {
      this.pdM = this.qPs.getCount();
      if (this.pdM == 0)
      {
        TextView localTextView = (TextView)findViewById(2131821852);
        localTextView.setText(2131302880);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.qRB.Ku();
    }
    this.qRB.notifyDataSetChanged();
    AppMethodBeat.o(24886);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI
 * JD-Core Version:    0.7.0.1
 */