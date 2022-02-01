package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.ui.widget.picker.b.a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@a(3)
public class FixToolsUplogUI
  extends MMWizardActivity
{
  private static String BrH;
  private Button CYB;
  private TextView CYC;
  private SimpleDateFormat CYD;
  private LinearLayout oMS;
  private SimpleDateFormat oMZ;
  
  public FixToolsUplogUI()
  {
    AppMethodBeat.i(73827);
    this.CYD = new SimpleDateFormat("yyyy.MM.dd");
    this.oMZ = new SimpleDateFormat("yyyyMMdd");
    AppMethodBeat.o(73827);
  }
  
  public int getLayoutId()
  {
    return 2131494695;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73830);
    setMMTitle(2131760723);
    this.CYB = ((Button)findViewById(2131301560));
    this.oMS = ((LinearLayout)findViewById(2131298661));
    this.CYC = ((TextView)findViewById(2131301555));
    this.CYC.setText(this.CYD.format(new Date()));
    BrH = this.oMZ.format(new Date());
    this.CYB.setOnClickListener(new FixToolsUplogUI.2(this));
    this.oMS.setOnClickListener(new FixToolsUplogUI.3(this));
    setBackBtn(new FixToolsUplogUI.4(this));
    AppMethodBeat.o(73830);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73828);
    super.onCreate(paramBundle);
    if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false))
    {
      AppMethodBeat.o(73828);
      return;
    }
    int i = getIntent().getIntExtra("entry_fix_tools_uplog", 5);
    h.CyF.idkeyStat(873L, i, 1L, false);
    h.CyF.idkeyStat(873L, 8L, 1L, false);
    initView();
    AppMethodBeat.o(73828);
  }
  
  protected Dialog onCreateDialog(final int paramInt)
  {
    AppMethodBeat.i(73829);
    Object localObject = Calendar.getInstance();
    long l1 = Util.nowMilliSecond();
    ((Calendar)localObject).setTimeInMillis(l1);
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    final long l3 = l1 / 86400000L * 86400000L + 57600000L - 1L;
    long l2 = l1 / 86400000L * 86400000L + 57600000L - 864000000L;
    localObject = new e(getContext(), new DatePickerDialog.OnDateSetListener()
    {
      public final void onDateSet(DatePicker paramAnonymousDatePicker, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(73823);
        switch (paramInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(73823);
          return;
          paramAnonymousDatePicker = new StringBuffer().append(String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt1) })).append(".").append(String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt2 + 1) })).append(".").append(String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt3) }));
          FixToolsUplogUI.a(FixToolsUplogUI.this).setText(paramAnonymousDatePicker);
          FixToolsUplogUI.eU(String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt1) }) + String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt2 + 1) }) + String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt3) }));
          Log.i("MicroMsg.FixToolsUplogUI", "uplog choose time maxTime[%d], date[%s]", new Object[] { Long.valueOf(l3), FixToolsUplogUI.BrH });
        }
      }
    }, i, j, ((Calendar)localObject).get(5), ((Calendar)localObject).getTimeInMillis(), (byte)0);
    ((e)localObject).setCanceledOnTouchOutside(false);
    if (l2 > 0L) {
      l1 = l2;
    }
    try
    {
      for (;;)
      {
        ((e)localObject).Ob(l1);
        ((e)localObject).Oa(l3);
        AppMethodBeat.o(73829);
        return localObject;
        l1 = 0L;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.FixToolsUplogUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), localException });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI
 * JD-Core Version:    0.7.0.1
 */