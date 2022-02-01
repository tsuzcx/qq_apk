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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
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
  private int fFv;
  private float fontScale;
  private String jku;
  private TextView titleView;
  private SwitchAccountGridView yDY;
  private View yDZ;
  private View yEa;
  private ArrayList<SwitchAccountModel> yEb;
  private Map<String, SwitchAccountModel> yEc;
  private av yEd;
  
  public FakeSwitchAccountUI()
  {
    AppMethodBeat.i(73883);
    this.yEc = new HashMap();
    AppMethodBeat.o(73883);
  }
  
  private int dNm()
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
      } while (!localRunningAppProcessInfo.processName.equals("com.tencent.mm"));
      ad.i("MicroMsg.FakeSwitchAccountUI", "process %s, %s", new Object[] { localRunningAppProcessInfo.processName, Integer.valueOf(localRunningAppProcessInfo.pid) });
      int i = localRunningAppProcessInfo.pid;
      AppMethodBeat.o(73886);
      return i;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Exception: " + localException.toString());
      AppMethodBeat.o(73886);
      return 0;
    }
    catch (Error localError)
    {
      for (;;)
      {
        ad.e("MicroMsg.FakeSwitchAccountUI", "isMMProcessExist Error: " + localError.toString());
      }
    }
  }
  
  public int getLayoutId()
  {
    return 2131495406;
  }
  
  public void initView()
  {
    AppMethodBeat.i(73885);
    ad.i("MicroMsg.FakeSwitchAccountUI", "FakeSwitchAccount onCreate");
    setMMTitle("");
    getSupportActionBar().hide();
    getController().q(this, getResources().getColor(2131101179));
    this.titleView = ((TextView)findViewById(2131305572));
    this.yDY = ((SwitchAccountGridView)findViewById(2131305570));
    this.yDY.setRowCount(1);
    this.yDY.setClickable(false);
    this.fFv = getIntent().getIntExtra("key_mm_process_pid", 0);
    this.jku = getIntent().getStringExtra("key_switch_from_wx_username");
    ad.i("MicroMsg.FakeSwitchAccountUI", "title %s", new Object[] { getResources().getString(2131763447) });
    this.titleView.setText(getResources().getString(2131763447));
    this.yEb = getIntent().getParcelableArrayListExtra("key_switch_account_users");
    if (this.yEb != null)
    {
      Iterator localIterator = this.yEb.iterator();
      while (localIterator.hasNext())
      {
        SwitchAccountModel localSwitchAccountModel = (SwitchAccountModel)localIterator.next();
        this.yEc.put(localSwitchAccountModel.yCV, localSwitchAccountModel);
      }
    }
    this.yDZ = findViewById(2131305568);
    this.yDZ.setVisibility(8);
    this.yEa = findViewById(2131305566);
    this.yEa.setVisibility(8);
    ad.i("MicroMsg.FakeSwitchAccountUI", "account count %d", new Object[] { Integer.valueOf(this.yEc.size()) });
    this.yDY.setUseSystemDecoder(true);
    this.yDY.aB(this.yEc);
    this.yDY.setLastLoginWxUsername(this.jku);
    this.yDY.setLogoutState(true);
    this.yDY.dOp();
    this.yEd = new av(Looper.myLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(73882);
        int i = FakeSwitchAccountUI.a(FakeSwitchAccountUI.this);
        ad.i("MicroMsg.FakeSwitchAccountUI", "oldPid %d, mm pid %d", new Object[] { Integer.valueOf(FakeSwitchAccountUI.b(FakeSwitchAccountUI.this)), Integer.valueOf(i) });
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
    if (this.yEd != null) {
      this.yEd.az(1500L, 500L);
    }
    AppMethodBeat.o(73885);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(73884);
    super.onCreate(paramBundle);
    this.country = getIntent().getStringExtra("key_langauage_code");
    this.fontScale = getIntent().getFloatExtra("key_font_scale_size", 1.0F);
    if (!bt.isNullOrNil(this.country))
    {
      ad.i("MicroMsg.FakeSwitchAccountUI", "country %s", new Object[] { this.country });
      bp.setProperty("language_key", this.country);
      MMActivity.initLanguage(aj.getContext(), this.country);
    }
    ad.i("MicroMsg.FakeSwitchAccountUI", "fontScale %f", new Object[] { Float.valueOf(this.fontScale) });
    com.tencent.mm.cc.a.h(aj.getContext(), this.fontScale);
    initView();
    AppMethodBeat.o(73884);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(73890);
    super.onDestroy();
    ad.i("MicroMsg.FakeSwitchAccountUI", "fake switch account destroy");
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
    ad.i("MicroMsg.FakeSwitchAccountUI", "fake switch account resume");
    Intent localIntent = new Intent("action_kill_mm_process");
    localIntent.setPackage(aj.getPackageName());
    sendBroadcast(localIntent);
    AppMethodBeat.o(73888);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(73889);
    super.onStop();
    ad.i("MicroMsg.FakeSwitchAccountUI", "fake switch account stop");
    AppMethodBeat.o(73889);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.FakeSwitchAccountUI
 * JD-Core Version:    0.7.0.1
 */