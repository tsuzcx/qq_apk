package com.tencent.mm.plugin.setting.ui.setting;

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
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.m.f;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;

public class SettingsRingtoneUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, Runnable
{
  private Cursor JM;
  private ah mHandler;
  private RingtoneManager nVB;
  LayoutInflater nVC;
  private int nVD = -1;
  private int nVE = -1;
  private Ringtone nVF;
  
  protected final int getLayoutId()
  {
    return a.g.settings_ringtone_picker;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mHandler = new ah();
    this.nVC = LayoutInflater.from(this);
    this.nVB = new RingtoneManager(this);
    this.nVB.setType(2);
    setVolumeControlStream(5);
    this.nVF = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
    setMMTitle(a.i.settings_notification_ringtone_title);
    setBackBtn(new SettingsRingtoneUI.1(this));
    a(0, getString(a.i.settings_language_save), new SettingsRingtoneUI.2(this), s.b.uNx);
    paramBundle = (ListView)findViewById(a.f.settings_ringtone_picker_lv);
    Object localObject = new View(this);
    int i = getResources().getDimensionPixelSize(a.d.LargePadding);
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, i));
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
    ((View)localObject).setClickable(false);
    localView.setClickable(false);
    paramBundle.addHeaderView((View)localObject);
    paramBundle.addFooterView(localView);
    this.JM = this.nVB.getCursor();
    paramBundle.setAdapter(new SettingsRingtoneUI.a(this, this.JM));
    paramBundle.setItemsCanFocus(false);
    paramBundle.setOnItemClickListener(this);
    localObject = f.zU();
    if (localObject != f.dAe)
    {
      localObject = Uri.parse((String)localObject);
      i = this.nVB.getRingtonePosition((Uri)localObject);
      if (i >= 0)
      {
        i += 2;
        this.nVD = i;
        if (this.nVD == 1)
        {
          getSharedPreferences(ae.cqR(), 0).edit().putString("settings.ringtone.name", getString(a.i.settings_notification_ringtone_sys)).commit();
          y.d("RingtonePickerActivity", "set ringtone follow system");
        }
        this.nVE = (this.nVD - 1);
      }
    }
    for (;;)
    {
      paramBundle.setItemChecked(this.nVD, true);
      paramBundle.setSelection(this.nVD);
      return;
      i = 1;
      break;
      this.nVD = 1;
    }
  }
  
  protected void onDestroy()
  {
    this.mHandler.removeCallbacks(this);
    if ((this.JM != null) && (!this.JM.isClosed()))
    {
      this.JM.close();
      this.JM = null;
    }
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.mHandler.removeCallbacks(this);
    this.nVE = (paramInt - 1);
    this.mHandler.postDelayed(this, 300L);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 24) || (paramInt == 25)) {
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onStop()
  {
    this.nVB.stopPreviousRingtone();
    super.onStop();
  }
  
  public void run()
  {
    if (isFinishing()) {}
    for (;;)
    {
      return;
      if (this.nVE == 0) {}
      Ringtone localRingtone2;
      for (Ringtone localRingtone1 = this.nVF; localRingtone1 != null; localRingtone2 = this.nVB.getRingtone(this.nVE - 1)) {
        try
        {
          localRingtone1.play();
          return;
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("RingtonePickerActivity", localException, "play ringtone error", new Object[0]);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI
 * JD-Core Version:    0.7.0.1
 */