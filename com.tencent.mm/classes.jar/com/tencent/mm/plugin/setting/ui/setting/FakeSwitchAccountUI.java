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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class FakeSwitchAccountUI
  extends MMActivity
{
  private int count;
  private String country;
  private int dZK;
  private float fontScale;
  private String gEZ;
  private SwitchAccountGridView qFN;
  private View qFO;
  private View qFP;
  private ArrayList<SwitchAccountModel> qFQ;
  private Map<String, SwitchAccountModel> qFR;
  private ap qFS;
  private TextView titleView;
  
  public FakeSwitchAccountUI()
  {
    AppMethodBeat.i(126955);
    this.qFR = new HashMap();
    AppMethodBeat.o(126955);
  }
  
  private int cjT()
  {
    AppMethodBeat.i(126958);
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
      ab.i("MicroMsg.FakeSwitchAccountUI", "process %s, %s", new Object[] { localRunningAppProcessInfo.processName, Integer.valueOf(localRunningAppProcessInfo.pid) });
      int i = localRunningAppProcessInfo.pid;
      AppMethodBeat.o(126958);
      return i;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Exception: " + localException.toString());
      AppMethodBeat.o(126958);
      return 0;
    }
    catch (Error localError)
    {
      for (;;)
      {
        ab.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Error: " + localError.toString());
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2130970703;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126957);
    ab.i("MicroMsg.FakeSwitchAccountUI", "FakeSwitchAccount onCreate");
    setMMTitle("");
    getSupportActionBar().hide();
    getController().n(this, -1);
    this.titleView = ((TextView)findViewById(2131827656));
    this.qFN = ((SwitchAccountGridView)findViewById(2131827657));
    this.qFN.setRowCount(1);
    this.qFN.setClickable(false);
    this.dZK = getIntent().getIntExtra("key_mm_process_pid", 0);
    this.gEZ = getIntent().getStringExtra("key_switch_from_wx_username");
    ab.i("MicroMsg.FakeSwitchAccountUI", "title %s", new Object[] { getResources().getString(2131303465) });
    this.titleView.setText(getResources().getString(2131303465));
    this.qFQ = getIntent().getParcelableArrayListExtra("key_switch_account_users");
    if (this.qFQ != null)
    {
      Iterator localIterator = this.qFQ.iterator();
      while (localIterator.hasNext())
      {
        SwitchAccountModel localSwitchAccountModel = (SwitchAccountModel)localIterator.next();
        this.qFR.put(localSwitchAccountModel.qEJ, localSwitchAccountModel);
      }
    }
    this.qFO = findViewById(2131827658);
    this.qFO.setVisibility(8);
    this.qFP = findViewById(2131827651);
    this.qFP.setVisibility(8);
    ab.i("MicroMsg.FakeSwitchAccountUI", "account count %d", new Object[] { Integer.valueOf(this.qFR.size()) });
    this.qFN.setUseSystemDecoder(true);
    this.qFN.ab(this.qFR);
    this.qFN.setLastLoginWxUsername(this.gEZ);
    this.qFN.setLogoutState(true);
    this.qFN.ckO();
    this.qFS = new ap(Looper.myLooper(), new FakeSwitchAccountUI.1(this), true);
    if (this.qFS != null) {
      this.qFS.ag(1500L, 500L);
    }
    AppMethodBeat.o(126957);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(126956);
    super.onCreate(paramBundle);
    this.country = getIntent().getStringExtra("key_langauage_code");
    this.fontScale = getIntent().getFloatExtra("key_font_scale_size", 1.0F);
    if (!bo.isNullOrNil(this.country))
    {
      ab.i("MicroMsg.FakeSwitchAccountUI", "country %s", new Object[] { this.country });
      bk.setProperty("language_key", this.country);
      MMActivity.initLanguage(ah.getContext(), this.country);
    }
    ab.i("MicroMsg.FakeSwitchAccountUI", "fontScale %f", new Object[] { Float.valueOf(this.fontScale) });
    com.tencent.mm.cb.a.h(ah.getContext(), this.fontScale);
    initView();
    AppMethodBeat.o(126956);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(126962);
    super.onDestroy();
    ab.i("MicroMsg.FakeSwitchAccountUI", "fake switch account destroy");
    AppMethodBeat.o(126962);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(126959);
    if (paramInt == 4)
    {
      AppMethodBeat.o(126959);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(126959);
    return bool;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(126960);
    super.onResume();
    ab.i("MicroMsg.FakeSwitchAccountUI", "fake switch account resume");
    Intent localIntent = new Intent("action_kill_mm_process");
    localIntent.setPackage(ah.getPackageName());
    sendBroadcast(localIntent);
    AppMethodBeat.o(126960);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(126961);
    super.onStop();
    ab.i("MicroMsg.FakeSwitchAccountUI", "fake switch account stop");
    AppMethodBeat.o(126961);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI
 * JD-Core Version:    0.7.0.1
 */