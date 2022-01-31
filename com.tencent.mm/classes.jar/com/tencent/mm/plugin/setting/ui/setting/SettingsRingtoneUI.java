package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;

public class SettingsRingtoneUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, Runnable
{
  private Cursor Js;
  private ak mHandler;
  private RingtoneManager qJK;
  LayoutInflater qJL;
  private int qJM = -1;
  private int qJN = -1;
  private Ringtone qJO;
  
  public int getLayoutId()
  {
    return 2130970699;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(127430);
    super.onCreate(paramBundle);
    this.mHandler = new ak();
    this.qJL = LayoutInflater.from(this);
    this.qJK = new RingtoneManager(this);
    this.qJK.setType(2);
    setVolumeControlStream(5);
    this.qJO = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
    setMMTitle(2131303353);
    setBackBtn(new SettingsRingtoneUI.1(this));
    addTextOptionMenu(0, getString(2131303285), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(127425);
        SharedPreferences.Editor localEditor = SettingsRingtoneUI.this.getSharedPreferences(ah.dsP(), 0).edit();
        paramAnonymousMenuItem = f.etD;
        if (SettingsRingtoneUI.a(SettingsRingtoneUI.this) != 0)
        {
          Object localObject = SettingsRingtoneUI.a(SettingsRingtoneUI.this, SettingsRingtoneUI.a(SettingsRingtoneUI.this));
          ab.d("RingtonePickerActivity", "set ringtone to ".concat(String.valueOf(localObject)));
          if (localObject != null)
          {
            paramAnonymousMenuItem = ((Uri)localObject).toString();
            localObject = SettingsRingtoneUI.a(SettingsRingtoneUI.this, (Uri)localObject);
            localEditor.putString("settings.ringtone.name", (String)localObject);
            ab.d("RingtonePickerActivity", "ringtone name: ".concat(String.valueOf(localObject)));
          }
        }
        for (;;)
        {
          localEditor.commit();
          f.lt(paramAnonymousMenuItem);
          SettingsRingtoneUI.this.finish();
          AppMethodBeat.o(127425);
          return true;
          paramAnonymousMenuItem = f.etD;
          localEditor.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(2131303352));
          ab.d("RingtonePickerActivity", "set ringtone follow system");
          continue;
          paramAnonymousMenuItem = f.etD;
          localEditor.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(2131303352));
          ab.d("RingtonePickerActivity", "set ringtone follow system");
        }
      }
    }, null, q.b.zby);
    paramBundle = (ListView)findViewById(2131827637);
    Object localObject = new View(this);
    int i = getResources().getDimensionPixelSize(2131427772);
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, i));
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
    ((View)localObject).setClickable(false);
    localView.setClickable(false);
    paramBundle.addHeaderView((View)localObject);
    paramBundle.addFooterView(localView);
    this.Js = this.qJK.getCursor();
    paramBundle.setAdapter(new SettingsRingtoneUI.a(this, this.Js));
    paramBundle.setItemsCanFocus(false);
    paramBundle.setOnItemClickListener(this);
    localObject = f.MF();
    if (localObject != f.etD)
    {
      localObject = Uri.parse((String)localObject);
      i = this.qJK.getRingtonePosition((Uri)localObject);
      if (i >= 0)
      {
        i += 2;
        this.qJM = i;
        if (this.qJM == 1)
        {
          getSharedPreferences(ah.dsP(), 0).edit().putString("settings.ringtone.name", getString(2131303352)).commit();
          ab.d("RingtonePickerActivity", "set ringtone follow system");
        }
        this.qJN = (this.qJM - 1);
      }
    }
    for (;;)
    {
      paramBundle.setItemChecked(this.qJM, true);
      paramBundle.setSelection(this.qJM);
      AppMethodBeat.o(127430);
      return;
      i = 1;
      break;
      this.qJM = 1;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127434);
    this.mHandler.removeCallbacks(this);
    if ((this.Js != null) && (!this.Js.isClosed()))
    {
      this.Js.close();
      this.Js = null;
    }
    super.onDestroy();
    AppMethodBeat.o(127434);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(127431);
    this.mHandler.removeCallbacks(this);
    this.qJN = (paramInt - 1);
    this.mHandler.postDelayed(this, 300L);
    AppMethodBeat.o(127431);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(127435);
    if ((paramInt == 24) || (paramInt == 25))
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(127435);
      return bool;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(127435);
    return bool;
  }
  
  public void onStop()
  {
    AppMethodBeat.i(127433);
    this.qJK.stopPreviousRingtone();
    super.onStop();
    AppMethodBeat.o(127433);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void run()
  {
    AppMethodBeat.i(127432);
    if (isFinishing())
    {
      AppMethodBeat.o(127432);
      return;
    }
    if (this.qJN == 0) {}
    for (Ringtone localRingtone = this.qJO;; localRingtone = this.qJK.getRingtone(this.qJN - 1))
    {
      if (localRingtone == null) {
        break label78;
      }
      try
      {
        localRingtone.play();
        AppMethodBeat.o(127432);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("RingtonePickerActivity", localException, "play ringtone error", new Object[0]);
      }
    }
    label78:
    AppMethodBeat.o(127432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI
 * JD-Core Version:    0.7.0.1
 */