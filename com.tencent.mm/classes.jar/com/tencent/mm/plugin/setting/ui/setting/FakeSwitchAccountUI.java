package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.SystemProperty;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class FakeSwitchAccountUI
  extends MMActivity
{
  private SwitchAccountGridView Ppc;
  private ArrayList<SwitchAccountModel> Ppd;
  private Map<String, SwitchAccountModel> Ppe;
  private MTimerHandler Ppf;
  private int count;
  private String country;
  private float fontScale;
  private int lsP;
  private String qaF;
  private TextView titleView;
  
  public FakeSwitchAccountUI()
  {
    AppMethodBeat.i(73883);
    this.Ppe = new HashMap();
    AppMethodBeat.o(73883);
  }
  
  private int gVb()
  {
    AppMethodBeat.i(73886);
    Object localObject = (ActivityManager)getSystemService("activity");
    try
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      } while (!localRunningAppProcessInfo.processName.equals(MMApplicationContext.getApplicationId()));
      Log.i("MicroMsg.FakeSwitchAccountUI", "process %s, %s", new Object[] { localRunningAppProcessInfo.processName, Integer.valueOf(localRunningAppProcessInfo.pid) });
      int i = localRunningAppProcessInfo.pid;
      AppMethodBeat.o(73886);
      return i;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Exception: " + localException.toString());
      AppMethodBeat.o(73886);
      return 0;
    }
    catch (Error localError)
    {
      for (;;)
      {
        Log.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Error: " + localError.toString());
      }
    }
  }
  
  public int getLayoutId()
  {
    return b.g.settings_switch_account;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73885);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(b.c.settings_bg));
    setBackBtnVisible(false);
    Log.i("MicroMsg.FakeSwitchAccountUI", "FakeSwitchAccount onCreate");
    this.titleView = ((TextView)findViewById(b.f.switch_account_title));
    this.Ppc = ((SwitchAccountGridView)findViewById(b.f.switch_account_grid));
    this.Ppc.setClickable(false);
    this.lsP = getIntent().getIntExtra("key_mm_process_pid", 0);
    this.qaF = getIntent().getStringExtra("key_switch_from_wx_username");
    Log.i("MicroMsg.FakeSwitchAccountUI", "title %s", new Object[] { getResources().getString(b.i.settings_switch_account_login_title) });
    this.titleView.setText(getResources().getString(b.i.settings_switch_account_login_title));
    this.Ppd = getIntent().getParcelableArrayListExtra("key_switch_account_users");
    if (this.Ppd != null)
    {
      Iterator localIterator = this.Ppd.iterator();
      while (localIterator.hasNext())
      {
        SwitchAccountModel localSwitchAccountModel = (SwitchAccountModel)localIterator.next();
        this.Ppe.put(localSwitchAccountModel.PnR, localSwitchAccountModel);
      }
    }
    Log.i("MicroMsg.FakeSwitchAccountUI", "account count %d", new Object[] { Integer.valueOf(this.Ppe.size()) });
    this.Ppc.setUseSystemDecoder(true);
    this.Ppc.aQ(this.Ppe);
    this.Ppc.setLastLoginWxUsername(this.qaF);
    this.Ppc.setLogoutState(true);
    this.Ppc.gWD();
    this.Ppf = new MTimerHandler(Looper.myLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(73882);
        int i = FakeSwitchAccountUI.a(FakeSwitchAccountUI.this);
        Log.i("MicroMsg.FakeSwitchAccountUI", "oldPid %d, mm pid %d", new Object[] { Integer.valueOf(FakeSwitchAccountUI.b(FakeSwitchAccountUI.this)), Integer.valueOf(i) });
        if ((FakeSwitchAccountUI.b(FakeSwitchAccountUI.this) != 0) && (i != 0) && (FakeSwitchAccountUI.b(FakeSwitchAccountUI.this) != i))
        {
          if (FakeSwitchAccountUI.c(FakeSwitchAccountUI.this) <= 0)
          {
            FakeSwitchAccountUI.d(FakeSwitchAccountUI.this);
            AppMethodBeat.o(73882);
            return true;
          }
          FakeSwitchAccountUI.e(FakeSwitchAccountUI.this);
          AppMethodBeat.o(73882);
          return false;
        }
        FakeSwitchAccountUI.d(FakeSwitchAccountUI.this);
        if (FakeSwitchAccountUI.c(FakeSwitchAccountUI.this) <= 20)
        {
          AppMethodBeat.o(73882);
          return true;
        }
        FakeSwitchAccountUI.e(FakeSwitchAccountUI.this);
        AppMethodBeat.o(73882);
        return false;
      }
    }, true);
    if (this.Ppf != null) {
      this.Ppf.startTimer(1500L, 500L);
    }
    AppMethodBeat.o(73885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73884);
    super.onCreate(paramBundle);
    try
    {
      this.country = getIntent().getStringExtra("key_langauage_code");
      this.fontScale = getIntent().getFloatExtra("key_font_scale_size", 1.0F);
      if (!Util.isNullOrNil(this.country))
      {
        Log.i("MicroMsg.FakeSwitchAccountUI", "country %s", new Object[] { this.country });
        SystemProperty.setProperty("language_key", this.country);
        MMActivity.initLanguage(MMApplicationContext.getContext(), this.country);
      }
      Log.i("MicroMsg.FakeSwitchAccountUI", "fontScale %f", new Object[] { Float.valueOf(this.fontScale) });
      com.tencent.mm.cd.a.i(MMApplicationContext.getContext(), this.fontScale);
      return;
    }
    finally
    {
      finish();
      AppMethodBeat.o(73884);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73890);
    super.onDestroy();
    Log.i("MicroMsg.FakeSwitchAccountUI", "fake switch account destroy");
    AppMethodBeat.o(73890);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(73887);
    if (paramInt == 4)
    {
      AppMethodBeat.o(73887);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(73887);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(73888);
    super.onResume();
    Log.i("MicroMsg.FakeSwitchAccountUI", "fake switch account resume");
    Intent localIntent = new Intent("action_kill_mm_process");
    localIntent.setPackage(MMApplicationContext.getPackageName());
    sendBroadcast(localIntent);
    AppMethodBeat.o(73888);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(73889);
    super.onStop();
    Log.i("MicroMsg.FakeSwitchAccountUI", "fake switch account stop");
    AppMethodBeat.o(73889);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI
 * JD-Core Version:    0.7.0.1
 */