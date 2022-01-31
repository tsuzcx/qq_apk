package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;

public class ShakeMsgListUI
  extends MMActivity
{
  private int from;
  private long hJW;
  private n.d hZq = new ShakeMsgListUI.6(this);
  private TextView iJY;
  private int limit = 0;
  private int mDK = 0;
  private int mDL = 0;
  private int mType;
  private g obQ = null;
  private d obR;
  private ListView obS;
  
  private void bAC()
  {
    this.iJY.setText(R.l.shake_msg_list_empty_tips);
    this.iJY.setVisibility(0);
    enableOptionMenu(false);
  }
  
  protected final int getLayoutId()
  {
    return R.i.shake_msg_list;
  }
  
  protected final void initView()
  {
    setMMTitle(getIntent().getStringExtra("shake_msg_list_title"));
    setBackBtn(new ShakeMsgListUI.1(this));
    addTextOptionMenu(0, getString(R.l.app_clear), new ShakeMsgListUI.2(this));
    this.iJY = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    if (this.mDK == 0) {
      bAC();
    }
    this.obS = ((ListView)findViewById(R.h.shake_msg_listview));
    Object localObject = getLayoutInflater().inflate(R.i.say_hi_list_footer, null);
    ((View)localObject).setOnClickListener(new ShakeMsgListUI.3(this, (View)localObject));
    if ((this.mDK > 0) && (this.limit < this.mDK)) {
      this.obS.addFooterView((View)localObject);
    }
    this.obR = new d(this);
    this.obR.obN = this.limit;
    this.obS.setAdapter(this.obR);
    this.obS.setOnItemClickListener(new ShakeMsgListUI.4(this));
    localObject = new j(this);
    this.obS.setOnItemLongClickListener(new ShakeMsgListUI.5(this, (j)localObject));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("shake_msg_type", 0);
    this.obQ = m.bzV();
    this.mDL = this.obQ.aAo();
    int i;
    if (this.mDL == 0)
    {
      i = 8;
      this.limit = i;
      this.mDK = this.obQ.getCount();
      this.from = getIntent().getIntExtra("shake_msg_from", 1);
      if (this.from != 1) {
        break label179;
      }
      h.nFQ.f(11313, new Object[] { Integer.valueOf(this.mDL), e.bAS() });
    }
    for (;;)
    {
      paramBundle = this.obQ;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(1));
      paramBundle.dXw.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "1" });
      initView();
      return;
      i = this.mDL;
      break;
      label179:
      h.nFQ.f(11315, new Object[] { Integer.valueOf(this.mDL), e.bAS() });
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.hJW = ((f)this.obR.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, R.l.app_delete);
  }
  
  public void onDestroy()
  {
    this.obR.bcS();
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.mDK != this.obQ.getCount())
    {
      this.mDK = this.obQ.getCount();
      if (this.mDK == 0) {
        bAC();
      }
      this.obR.yc();
    }
    this.obR.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI
 * JD-Core Version:    0.7.0.1
 */