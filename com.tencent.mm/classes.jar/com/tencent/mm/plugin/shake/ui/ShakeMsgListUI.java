package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class ShakeMsgListUI
  extends MMActivity
{
  private int from;
  private long jDz;
  private n.d jSn;
  private TextView kQD;
  private int limit;
  private int mType;
  private int pdM;
  private int pdN;
  private g qPX;
  private d qPY;
  private ListView qPZ;
  
  public ShakeMsgListUI()
  {
    AppMethodBeat.i(24758);
    this.qPX = null;
    this.limit = 0;
    this.pdM = 0;
    this.pdN = 0;
    this.jSn = new ShakeMsgListUI.6(this);
    AppMethodBeat.o(24758);
  }
  
  private void clW()
  {
    AppMethodBeat.i(24764);
    this.kQD.setText(2131303609);
    this.kQD.setVisibility(0);
    enableOptionMenu(false);
    AppMethodBeat.o(24764);
  }
  
  public int getLayoutId()
  {
    return 2130970715;
  }
  
  public void initView()
  {
    AppMethodBeat.i(24762);
    setMMTitle(getIntent().getStringExtra("shake_msg_list_title"));
    setBackBtn(new ShakeMsgListUI.1(this));
    addTextOptionMenu(0, getString(2131296891), new ShakeMsgListUI.2(this));
    this.kQD = ((TextView)findViewById(2131821852));
    if (this.pdM == 0) {
      clW();
    }
    this.qPZ = ((ListView)findViewById(2131827710));
    Object localObject = getLayoutInflater().inflate(2130970596, null);
    ((View)localObject).setOnClickListener(new ShakeMsgListUI.3(this, (View)localObject));
    if ((this.pdM > 0) && (this.limit < this.pdM)) {
      this.qPZ.addFooterView((View)localObject);
    }
    this.qPY = new d(this);
    this.qPY.qPU = this.limit;
    this.qPZ.setAdapter(this.qPY);
    this.qPZ.setOnItemClickListener(new ShakeMsgListUI.4(this));
    localObject = new l(this);
    this.qPZ.setOnItemLongClickListener(new ShakeMsgListUI.5(this, (l)localObject));
    AppMethodBeat.o(24762);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24759);
    super.onCreate(paramBundle);
    this.mType = getIntent().getIntExtra("shake_msg_type", 0);
    this.qPX = m.clo();
    this.pdN = this.qPX.bbZ();
    int i;
    if (this.pdN == 0)
    {
      i = 8;
      this.limit = i;
      this.pdM = this.qPX.getCount();
      this.from = getIntent().getIntExtra("shake_msg_from", 1);
      if (this.from != 1) {
        break label190;
      }
      h.qsU.e(11313, new Object[] { Integer.valueOf(this.pdN), e.cmo() });
    }
    for (;;)
    {
      paramBundle = this.qPX;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(1));
      paramBundle.db.update(paramBundle.getTableName(), localContentValues, "status!=? ", new String[] { "1" });
      initView();
      AppMethodBeat.o(24759);
      return;
      i = this.pdN;
      break;
      label190:
      h.qsU.e(11315, new Object[] { Integer.valueOf(this.pdN), e.cmo() });
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(24763);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.jDz = ((f)this.qPY.getItem(paramView.position)).field_svrid;
    paramContextMenu.add(paramView.position, 0, 0, 2131296901);
    AppMethodBeat.o(24763);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(24761);
    this.qPY.bKb();
    super.onDestroy();
    AppMethodBeat.o(24761);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(24760);
    super.onResume();
    if (this.pdM != this.qPX.getCount())
    {
      this.pdM = this.qPX.getCount();
      if (this.pdM == 0) {
        clW();
      }
      this.qPY.Ku();
    }
    this.qPY.notifyDataSetChanged();
    AppMethodBeat.o(24760);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeMsgListUI
 * JD-Core Version:    0.7.0.1
 */