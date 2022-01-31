package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FakeSwitchAccountUI
  extends MMActivity
{
  private int count;
  private String country;
  private int diq;
  private String fnG;
  private float fontScale;
  private SwitchAccountGridView nRP;
  private View nRQ;
  private View nRR;
  private ArrayList<SwitchAccountModel> nRS;
  private Map<String, SwitchAccountModel> nRT = new HashMap();
  private am nRU;
  
  private int byJ()
  {
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
      } while (!localRunningAppProcessInfo.processName.equals("com.tencent.mm"));
      y.i("MicroMsg.FakeSwitchAccountUI", "process %s, %s", new Object[] { localRunningAppProcessInfo.processName, Integer.valueOf(localRunningAppProcessInfo.pid) });
      int i = localRunningAppProcessInfo.pid;
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Exception: " + localException.toString());
      return 0;
    }
    catch (Error localError)
    {
      for (;;)
      {
        y.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Error: " + localError.toString());
      }
    }
  }
  
  protected final int getLayoutId()
  {
    return a.g.settings_switch_account;
  }
  
  protected final void initView()
  {
    y.i("MicroMsg.FakeSwitchAccountUI", "FakeSwitchAccount onCreate");
    setMMTitle("");
    getSupportActionBar().hide();
    this.nRP = ((SwitchAccountGridView)findViewById(a.f.switch_account_grid));
    this.nRP.setRowCount(1);
    this.nRP.setClickable(false);
    this.diq = getIntent().getIntExtra("key_mm_process_pid", 0);
    this.fnG = getIntent().getStringExtra("key_switch_from_wx_username");
    y.i("MicroMsg.FakeSwitchAccountUI", "title %s", new Object[] { getResources().getString(a.i.settings_switch_account_login_title) });
    this.nRS = getIntent().getParcelableArrayListExtra("key_switch_account_users");
    if (this.nRS != null)
    {
      Iterator localIterator = this.nRS.iterator();
      while (localIterator.hasNext())
      {
        SwitchAccountModel localSwitchAccountModel = (SwitchAccountModel)localIterator.next();
        this.nRT.put(localSwitchAccountModel.nQM, localSwitchAccountModel);
      }
    }
    this.nRQ = findViewById(a.f.switch_account_delete_btn);
    this.nRQ.setVisibility(8);
    this.nRR = findViewById(a.f.switch_account_cancel_btn);
    this.nRR.setVisibility(8);
    y.i("MicroMsg.FakeSwitchAccountUI", "account count %d", new Object[] { Integer.valueOf(this.nRT.size()) });
    this.nRP.setUseSystemDecoder(true);
    this.nRP.J(this.nRT);
    this.nRP.setLastLoginWxUsername(this.fnG);
    this.nRP.setLogoutState(true);
    this.nRP.bzE();
    this.nRU = new am(Looper.myLooper(), new FakeSwitchAccountUI.1(this), true);
    if (this.nRU != null) {
      this.nRU.S(1500L, 500L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.country = getIntent().getStringExtra("key_langauage_code");
    this.fontScale = getIntent().getFloatExtra("key_font_scale_size", 1.0F);
    if (!bk.bl(this.country))
    {
      y.i("MicroMsg.FakeSwitchAccountUI", "country %s", new Object[] { this.country });
      bg.setProperty("language_key", this.country);
      s.by(ae.getContext(), this.country);
    }
    y.i("MicroMsg.FakeSwitchAccountUI", "fontScale %f", new Object[] { Float.valueOf(this.fontScale) });
    com.tencent.mm.cb.a.g(ae.getContext(), this.fontScale);
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    y.i("MicroMsg.FakeSwitchAccountUI", "fake switch account destroy");
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onResume()
  {
    super.onResume();
    y.i("MicroMsg.FakeSwitchAccountUI", "fake switch account resume");
  }
  
  protected void onStop()
  {
    super.onStop();
    y.i("MicroMsg.FakeSwitchAccountUI", "fake switch account stop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI
 * JD-Core Version:    0.7.0.1
 */