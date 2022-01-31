package com.tencent.mm.plugin.scanner.history.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.plugin.scanner.history.a.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.ui.MMActivity;

public class ScannerHistoryUI
  extends MMActivity
{
  private ListView Nn;
  private View hrf;
  private LinearLayout iwM;
  private View iwN;
  private TextView iwO;
  private ScannerHistoryUI.a nGw;
  
  private void aAW()
  {
    if (c.bxe().getCount() > 0)
    {
      this.Nn.setVisibility(0);
      this.hrf.setVisibility(8);
      this.iwN.setVisibility(0);
      enableOptionMenu(true);
    }
    for (;;)
    {
      this.nGw.notifyDataSetChanged();
      return;
      this.Nn.setVisibility(8);
      this.hrf.setVisibility(0);
      this.iwN.setVisibility(8);
      enableOptionMenu(false);
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.scan_history_list_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(R.l.scan_history_ttile);
    setBackBtn(new ScannerHistoryUI.1(this));
    this.Nn = ((ListView)findViewById(R.h.scan_history_lv));
    this.iwM = ((LinearLayout)View.inflate(getBaseContext(), R.i.scan_history_list_header_view, null));
    this.Nn.addHeaderView(this.iwM);
    this.nGw = new ScannerHistoryUI.a(this);
    this.Nn.setAdapter(this.nGw);
    this.Nn.setOnItemClickListener(new ScannerHistoryUI.2(this));
    this.Nn.setOnItemLongClickListener(new ScannerHistoryUI.3(this));
    addTextOptionMenu(0, getString(R.l.card_clear), new ScannerHistoryUI.4(this));
    this.hrf = findViewById(R.h.content_no_data);
    this.iwN = View.inflate(this, R.i.scan_history_list_header_tips_layout, null);
    if (this.iwM != null) {
      this.iwM.addView(this.iwN);
    }
    this.iwO = ((TextView)this.iwN.findViewById(R.h.history_list_header_tips));
    this.iwO.setText(R.l.history_only_show_product);
    aAW();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.history.ui.ScannerHistoryUI
 * JD-Core Version:    0.7.0.1
 */