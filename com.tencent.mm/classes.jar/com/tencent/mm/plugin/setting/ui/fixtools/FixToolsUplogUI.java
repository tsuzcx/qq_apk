package com.tencent.mm.plugin.setting.ui.fixtools;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.ui.widget.picker.b.a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@com.tencent.mm.ui.base.a(3)
public class FixToolsUplogUI
  extends MMWizardActivity
{
  private static String xbO;
  private SimpleDateFormat nwF;
  private LinearLayout nwy;
  private Button yDD;
  private TextView yDE;
  private SimpleDateFormat yDF;
  
  public FixToolsUplogUI()
  {
    AppMethodBeat.i(73827);
    this.yDF = new SimpleDateFormat("yyyy.MM.dd");
    this.nwF = new SimpleDateFormat("yyyyMMdd");
    AppMethodBeat.o(73827);
  }
  
  public int getLayoutId()
  {
    return 2131494141;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73830);
    setMMTitle(2131759434);
    this.yDD = ((Button)findViewById(2131300120));
    this.nwy = ((LinearLayout)findViewById(2131298271));
    this.yDE = ((TextView)findViewById(2131300115));
    this.yDE.setText(this.yDF.format(new Date()));
    xbO = this.nwF.format(new Date());
    this.yDD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(73824);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUplogUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        g.yhR.idkeyStat(873L, 16L, 1L, false);
        paramAnonymousView = new Intent(FixToolsUplogUI.this.getContext(), FixToolsUpLogUploadingUI.class);
        paramAnonymousView.putExtra("date", FixToolsUplogUI.xbO);
        MMWizardActivity.al(FixToolsUplogUI.this, paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUplogUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(73824);
      }
    });
    this.nwy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(73825);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUplogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        FixToolsUplogUI.b(FixToolsUplogUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/fixtools/FixToolsUplogUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(73825);
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(73826);
        FixToolsUplogUI.this.finish();
        AppMethodBeat.o(73826);
        return true;
      }
    });
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
    g.yhR.idkeyStat(873L, i, 1L, false);
    g.yhR.idkeyStat(873L, 8L, 1L, false);
    initView();
    AppMethodBeat.o(73828);
  }
  
  protected Dialog onCreateDialog(final int paramInt)
  {
    AppMethodBeat.i(73829);
    Object localObject = Calendar.getInstance();
    long l1 = bt.flT();
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
          FixToolsUplogUI.eg(String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt1) }) + String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt2 + 1) }) + String.format("%02d", new Object[] { Integer.valueOf(paramAnonymousInt3) }));
          ad.i("MicroMsg.FixToolsUplogUI", "uplog choose time maxTime[%d], date[%s]", new Object[] { Long.valueOf(l3), FixToolsUplogUI.xbO });
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
        ((e)localObject).Es(l1);
        ((e)localObject).Er(l3);
        AppMethodBeat.o(73829);
        return localObject;
        l1 = 0L;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.FixToolsUplogUI", "DatePicker exception!! minTime:%d, maxTime:%d, exception:%s", new Object[] { Long.valueOf(l2), Long.valueOf(l3), localException });
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUplogUI
 * JD-Core Version:    0.7.0.1
 */