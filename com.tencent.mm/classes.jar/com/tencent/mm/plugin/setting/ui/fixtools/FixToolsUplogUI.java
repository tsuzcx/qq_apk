package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.d;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class FixToolsUplogUI
  extends MMWizardActivity
{
  private static String nRs;
  private LinearLayout hJe;
  private SimpleDateFormat hJl = new SimpleDateFormat("yyyyMMdd");
  private Button nRq;
  private TextView nRr;
  private SimpleDateFormat nRt = new SimpleDateFormat("yyyy.MM.dd");
  
  protected final int getLayoutId()
  {
    return a.g.fix_tools_uplog;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.fix_tools_uplog);
    this.nRq = ((Button)findViewById(a.f.fix_tools_uplog_upload));
    this.hJe = ((LinearLayout)findViewById(a.f.choose_time));
    this.nRr = ((TextView)findViewById(a.f.fix_tools_log_time));
    this.nRr.setText(this.nRt.format(new Date()));
    nRs = this.hJl.format(new Date());
    this.nRq.setOnClickListener(new FixToolsUplogUI.2(this));
    this.hJe.setOnClickListener(new FixToolsUplogUI.3(this));
    setBackBtn(new FixToolsUplogUI.4(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
      return;
    }
    int i = getIntent().getIntExtra("entry_fix_tools_uplog", 5);
    h.nFQ.a(873L, i, 1L, false);
    h.nFQ.a(873L, 8L, 1L, false);
    initView();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = Calendar.getInstance();
    long l1 = bk.UY();
    ((Calendar)localObject).setTimeInMillis(l1);
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    long l2 = l1 / 86400000L * 86400000L + 57600000L - 1L;
    l1 = l1 / 86400000L * 86400000L + 57600000L - 864000000L;
    localObject = new d(this.mController.uMN, new FixToolsUplogUI.1(this, paramInt, l2), i, j, ((Calendar)localObject).get(5), ((Calendar)localObject).getTimeInMillis(), (byte)0);
    ((d)localObject).setCanceledOnTouchOutside(false);
    ((d)localObject).ih(l2);
    if (l1 > 0L) {}
    for (;;)
    {
      ((d)localObject).ii(l1);
      return localObject;
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI
 * JD-Core Version:    0.7.0.1
 */