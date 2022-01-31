package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.e;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class FixToolsUplogUI
  extends MMWizardActivity
{
  private static String qFq;
  private LinearLayout jCE;
  private SimpleDateFormat jCL;
  private Button qFo;
  private TextView qFp;
  private SimpleDateFormat qFr;
  
  public FixToolsUplogUI()
  {
    AppMethodBeat.i(126898);
    this.qFr = new SimpleDateFormat("yyyy.MM.dd");
    this.jCL = new SimpleDateFormat("yyyyMMdd");
    AppMethodBeat.o(126898);
  }
  
  public int getLayoutId()
  {
    return 2130969601;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126901);
    setMMTitle(2131299986);
    this.qFo = ((Button)findViewById(2131824185));
    this.jCE = ((LinearLayout)findViewById(2131824182));
    this.qFp = ((TextView)findViewById(2131824184));
    this.qFp.setText(this.qFr.format(new Date()));
    qFq = this.jCL.format(new Date());
    this.qFo.setOnClickListener(new FixToolsUplogUI.2(this));
    this.jCE.setOnClickListener(new FixToolsUplogUI.3(this));
    setBackBtn(new FixToolsUplogUI.4(this));
    AppMethodBeat.o(126901);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126899);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false))
    {
      AppMethodBeat.o(126899);
      return;
    }
    int i = getIntent().getIntExtra("entry_fix_tools_uplog", 5);
    h.qsU.idkeyStat(873L, i, 1L, false);
    h.qsU.idkeyStat(873L, 8L, 1L, false);
    initView();
    AppMethodBeat.o(126899);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    AppMethodBeat.i(126900);
    Object localObject = Calendar.getInstance();
    long l1 = bo.aoy();
    ((Calendar)localObject).setTimeInMillis(l1);
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    long l3 = l1 / 86400000L * 86400000L + 57600000L - 1L;
    long l2 = l1 / 86400000L * 86400000L + 57600000L - 864000000L;
    localObject = new e(getContext(), new FixToolsUplogUI.1(this, paramInt, l3), i, j, ((Calendar)localObject).get(5), ((Calendar)localObject).getTimeInMillis(), (byte)0);
    ((e)localObject).setCanceledOnTouchOutside(false);
    if (l2 > 0L) {
      l1 = l2;
    }
    try
    {
      for (;;)
      {
        ((e)localObject).oU(l1);
        ((e)localObject).oT(l3);
        AppMethodBeat.o(126900);
        return localObject;
        l1 = 0L;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.FixToolsUplogUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), localException });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI
 * JD-Core Version:    0.7.0.1
 */