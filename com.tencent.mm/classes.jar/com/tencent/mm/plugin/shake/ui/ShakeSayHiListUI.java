package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bh.d;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;

public class ShakeSayHiListUI
  extends MMActivity
{
  private ListView fem;
  private long hJW;
  private n.d hZq = new ShakeSayHiListUI.2(this);
  private int limit = 0;
  private int mDK = 0;
  private int mDL = 0;
  private bu obk = null;
  private int odt = 0;
  private b odu;
  
  protected final int getLayoutId()
  {
    return R.i.lbs_say_hi_list;
  }
  
  protected final void initView()
  {
    Object localObject = getLayoutInflater().inflate(R.i.say_hi_list_footer, null);
    this.fem = ((ListView)findViewById(R.h.say_hi_lv));
    ((View)localObject).setOnClickListener(new ShakeSayHiListUI.1(this, (View)localObject));
    addTextOptionMenu(0, getString(R.l.app_clear), new ShakeSayHiListUI.3(this));
    if (this.mDK == 0)
    {
      TextView localTextView = (TextView)findViewById(R.h.empty_msg_tip_tv);
      localTextView.setText(R.l.say_hi_non);
      localTextView.setVisibility(0);
      enableOptionMenu(false);
    }
    if ((this.mDK > 0) && (this.limit < this.mDK)) {
      this.fem.addFooterView((View)localObject);
    }
    this.odu = new b(this, this.obk, this.limit);
    this.odu.setGetViewPositionCallback(new ShakeSayHiListUI.4(this));
    this.odu.setPerformItemClickListener(new ShakeSayHiListUI.5(this));
    this.odu.a(new ShakeSayHiListUI.6(this));
    this.fem.setAdapter(this.odu);
    this.fem.setOnItemClickListener(new ShakeSayHiListUI.7(this));
    localObject = new j(this);
    this.fem.setOnItemLongClickListener(new ShakeSayHiListUI.8(this, (j)localObject));
    setBackBtn(new ShakeSayHiListUI.9(this));
    new ShakeSayHiListUI.10(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.odt = getIntent().getIntExtra("IntentSayHiType", 1);
    if (this.odt == 1)
    {
      this.obk = d.Sa();
      setMMTitle(R.l.say_hi_list_shake_title);
      this.mDL = this.obk.aAo();
      if (this.mDL != 0) {
        break label150;
      }
    }
    label150:
    for (int i = 8;; i = this.mDL)
    {
      this.limit = i;
      this.mDK = this.obk.getCount();
      paramBundle = this.obk;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(4));
      if (paramBundle.dXw.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "4" }) != 0) {
        paramBundle.doNotify();
      }
      initView();
      return;
      setMMTitle(R.l.say_hi_list_lbs_title);
      break;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.hJW = ((bt)this.odu.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, R.l.app_delete);
  }
  
  public void onDestroy()
  {
    this.odu.bcS();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.odu.hZg != null) {
      this.odu.hZg.bdb();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.mDK != this.obk.getCount())
    {
      this.mDK = this.obk.getCount();
      if (this.mDK == 0)
      {
        TextView localTextView = (TextView)findViewById(R.h.empty_msg_tip_tv);
        localTextView.setText(R.l.say_hi_non);
        localTextView.setVisibility(0);
        enableOptionMenu(false);
      }
      this.odu.yc();
    }
    this.odu.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeSayHiListUI
 * JD-Core Version:    0.7.0.1
 */