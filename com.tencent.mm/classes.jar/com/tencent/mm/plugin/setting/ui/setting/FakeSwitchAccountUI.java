package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.SystemProperty;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class FakeSwitchAccountUI
  extends MMActivity
{
  private SwitchAccountGridView CYW;
  private View CYX;
  private View CYY;
  private ArrayList<SwitchAccountModel> CYZ;
  private Map<String, SwitchAccountModel> CZa;
  private MTimerHandler CZb;
  private int count;
  private String country;
  private float fontScale;
  private int gmK;
  private String klw;
  private TextView titleView;
  
  public FakeSwitchAccountUI()
  {
    AppMethodBeat.i(73883);
    this.CZa = new HashMap();
    AppMethodBeat.o(73883);
  }
  
  private int eSJ()
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
    return 2131496268;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73885);
    Log.i("MicroMsg.FakeSwitchAccountUI", "FakeSwitchAccount onCreate");
    setMMTitle("");
    getSupportActionBar().hide();
    getController().p(this, getResources().getColor(2131101424));
    this.titleView = ((TextView)findViewById(2131308796));
    this.CYW = ((SwitchAccountGridView)findViewById(2131308794));
    this.CYW.setRowCount(1);
    this.CYW.setClickable(false);
    this.gmK = getIntent().getIntExtra("key_mm_process_pid", 0);
    this.klw = getIntent().getStringExtra("key_switch_from_wx_username");
    Log.i("MicroMsg.FakeSwitchAccountUI", "title %s", new Object[] { getResources().getString(2131765629) });
    this.titleView.setText(getResources().getString(2131765629));
    this.CYZ = getIntent().getParcelableArrayListExtra("key_switch_account_users");
    if (this.CYZ != null)
    {
      Iterator localIterator = this.CYZ.iterator();
      while (localIterator.hasNext())
      {
        SwitchAccountModel localSwitchAccountModel = (SwitchAccountModel)localIterator.next();
        this.CZa.put(localSwitchAccountModel.CXS, localSwitchAccountModel);
      }
    }
    this.CYX = findViewById(2131308792);
    this.CYX.setVisibility(8);
    this.CYY = findViewById(2131308790);
    this.CYY.setVisibility(8);
    Log.i("MicroMsg.FakeSwitchAccountUI", "account count %d", new Object[] { Integer.valueOf(this.CZa.size()) });
    this.CYW.setUseSystemDecoder(true);
    this.CYW.aG(this.CZa);
    this.CYW.setLastLoginWxUsername(this.klw);
    this.CYW.setLogoutState(true);
    this.CYW.eTN();
    this.CZb = new MTimerHandler(Looper.myLooper(), new MTimerHandler.CallBack()
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
    if (this.CZb != null) {
      this.CZb.startTimer(1500L, 500L);
    }
    AppMethodBeat.o(73885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73884);
    super.onCreate(paramBundle);
    this.country = getIntent().getStringExtra("key_langauage_code");
    this.fontScale = getIntent().getFloatExtra("key_font_scale_size", 1.0F);
    if (!Util.isNullOrNil(this.country))
    {
      Log.i("MicroMsg.FakeSwitchAccountUI", "country %s", new Object[] { this.country });
      SystemProperty.setProperty("language_key", this.country);
      MMActivity.initLanguage(MMApplicationContext.getContext(), this.country);
    }
    Log.i("MicroMsg.FakeSwitchAccountUI", "fontScale %f", new Object[] { Float.valueOf(this.fontScale) });
    com.tencent.mm.cb.a.h(MMApplicationContext.getContext(), this.fontScale);
    initView();
    AppMethodBeat.o(73884);
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