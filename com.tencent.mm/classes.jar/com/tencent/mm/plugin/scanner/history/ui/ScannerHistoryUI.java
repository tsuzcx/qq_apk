package com.tencent.mm.plugin.scanner.history.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.a.a;
import com.tencent.mm.ui.MMActivity;

public class ScannerHistoryUI
  extends MMActivity
{
  private LinearLayout kxQ;
  private View kxR;
  private TextView kxS;
  private ListView mListView;
  private ScannerHistoryUI.a qtN;
  private View xy;
  
  private void bcI()
  {
    AppMethodBeat.i(80816);
    if (com.tencent.mm.plugin.scanner.e.chX().cib().getCount() > 0)
    {
      this.mListView.setVisibility(0);
      this.xy.setVisibility(8);
      this.kxR.setVisibility(0);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.qtN.notifyDataSetChanged();
      AppMethodBeat.o(80816);
      return;
      this.mListView.setVisibility(8);
      this.xy.setVisibility(0);
      this.kxR.setVisibility(8);
      enableOptionMenu(false);
    }
  }
  
  public int getLayoutId()
  {
    return 2130970605;
  }
  
  public void initView()
  {
    AppMethodBeat.i(80815);
    setMMTitle(2131302902);
    setBackBtn(new ScannerHistoryUI.1(this));
    this.mListView = ((ListView)findViewById(2131827430));
    this.kxQ = ((LinearLayout)View.inflate(getBaseContext(), 2130970604, null));
    this.mListView.addHeaderView(this.kxQ);
    this.qtN = new ScannerHistoryUI.a(this);
    this.mListView.setAdapter(this.qtN);
    this.mListView.setOnItemClickListener(new ScannerHistoryUI.2(this));
    this.mListView.setOnItemLongClickListener(new ScannerHistoryUI.3(this));
    addTextOptionMenu(0, getString(2131297876), new ScannerHistoryUI.4(this));
    this.xy = findViewById(2131821981);
    this.kxR = View.inflate(this, 2130970603, null);
    if (this.kxQ != null) {
      this.kxQ.addView(this.kxR);
    }
    this.kxS = ((TextView)this.kxR.findViewById(2131827429));
    this.kxS.setText(2131300649);
    bcI();
    AppMethodBeat.o(80815);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(80812);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(80812);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(80814);
    super.onDestroy();
    AppMethodBeat.o(80814);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(80813);
    super.onResume();
    AppMethodBeat.o(80813);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI
 * JD-Core Version:    0.7.0.1
 */