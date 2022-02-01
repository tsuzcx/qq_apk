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
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s.b;
import java.lang.reflect.Field;

public class SettingsRingtoneUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, Runnable
{
  private Cursor Tc;
  private ap mHandler;
  private RingtoneManager yIH;
  LayoutInflater yII;
  private int yIJ = -1;
  private int yIK = -1;
  private Ringtone yIL;
  
  public int getLayoutId()
  {
    return 2131495402;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74366);
    super.onCreate(paramBundle);
    this.mHandler = new ap();
    this.yII = LayoutInflater.from(this);
    this.yIH = new RingtoneManager(this);
    this.yIH.setType(2);
    setVolumeControlStream(5);
    this.yIL = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
    setMMTitle(2131763335);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74360);
        SettingsRingtoneUI.this.hideVKB();
        SettingsRingtoneUI.this.finish();
        AppMethodBeat.o(74360);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131763254), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(74361);
        SharedPreferences.Editor localEditor = SettingsRingtoneUI.this.getSharedPreferences(aj.fkC(), 0).edit();
        paramAnonymousMenuItem = f.gek;
        if (SettingsRingtoneUI.a(SettingsRingtoneUI.this) != 0)
        {
          Object localObject = SettingsRingtoneUI.a(SettingsRingtoneUI.this, SettingsRingtoneUI.a(SettingsRingtoneUI.this));
          ad.d("RingtonePickerActivity", "set ringtone to ".concat(String.valueOf(localObject)));
          if (localObject != null)
          {
            paramAnonymousMenuItem = ((Uri)localObject).toString();
            localObject = SettingsRingtoneUI.a(SettingsRingtoneUI.this, (Uri)localObject);
            localEditor.putString("settings.ringtone.name", (String)localObject);
            ad.d("RingtonePickerActivity", "ringtone name: ".concat(String.valueOf(localObject)));
          }
        }
        for (;;)
        {
          localEditor.commit();
          f.vy(paramAnonymousMenuItem);
          SettingsRingtoneUI.this.finish();
          AppMethodBeat.o(74361);
          return true;
          paramAnonymousMenuItem = f.gek;
          localEditor.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(2131763334));
          ad.d("RingtonePickerActivity", "set ringtone follow system");
          continue;
          paramAnonymousMenuItem = f.gek;
          localEditor.putString("settings.ringtone.name", SettingsRingtoneUI.this.getString(2131763334));
          ad.d("RingtonePickerActivity", "set ringtone follow system");
        }
      }
    }, null, s.b.JbS);
    paramBundle = (ListView)findViewById(2131304668);
    Object localObject = new View(this);
    int i = getResources().getDimensionPixelSize(2131165480);
    ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(-1, i));
    View localView = new View(this);
    localView.setLayoutParams(new AbsListView.LayoutParams(-1, i));
    ((View)localObject).setClickable(false);
    localView.setClickable(false);
    paramBundle.addHeaderView((View)localObject);
    paramBundle.addFooterView(localView);
    this.Tc = this.yIH.getCursor();
    paramBundle.setAdapter(new a(this.Tc));
    paramBundle.setItemsCanFocus(false);
    paramBundle.setOnItemClickListener(this);
    localObject = f.abP();
    if (localObject != f.gek)
    {
      localObject = Uri.parse((String)localObject);
      i = this.yIH.getRingtonePosition((Uri)localObject);
      if (i >= 0)
      {
        i += 2;
        this.yIJ = i;
        if (this.yIJ == 1)
        {
          getSharedPreferences(aj.fkC(), 0).edit().putString("settings.ringtone.name", getString(2131763334)).commit();
          ad.d("RingtonePickerActivity", "set ringtone follow system");
        }
        this.yIK = (this.yIJ - 1);
      }
    }
    for (;;)
    {
      paramBundle.setItemChecked(this.yIJ, true);
      paramBundle.setSelection(this.yIJ);
      AppMethodBeat.o(74366);
      return;
      i = 1;
      break;
      this.yIJ = 1;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74370);
    this.mHandler.removeCallbacks(this);
    if ((this.Tc != null) && (!this.Tc.isClosed()))
    {
      this.Tc.close();
      this.Tc = null;
    }
    RingtoneManager localRingtoneManager = this.yIH;
    if (localRingtoneManager != null) {}
    try
    {
      Field localField = localRingtoneManager.getClass().getDeclaredField("mActivity");
      com.tencent.mm.plugin.crashfix.c.a.c(localField);
      localField.setAccessible(true);
      localField.set(localRingtoneManager, null);
      label82:
      super.onDestroy();
      AppMethodBeat.o(74370);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label82;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label82;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(74367);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsRingtoneUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    this.mHandler.removeCallbacks(this);
    this.yIK = (paramInt - 1);
    this.mHandler.postDelayed(this, 300L);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsRingtoneUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(74367);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74371);
    if ((paramInt == 24) || (paramInt == 25))
    {
      bool = super.onKeyUp(paramInt, paramKeyEvent);
      AppMethodBeat.o(74371);
      return bool;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(74371);
    return bool;
  }
  
  public void onStop()
  {
    AppMethodBeat.i(74369);
    this.yIH.stopPreviousRingtone();
    super.onStop();
    AppMethodBeat.o(74369);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void run()
  {
    AppMethodBeat.i(74368);
    if (isFinishing())
    {
      AppMethodBeat.o(74368);
      return;
    }
    if (this.yIK == 0) {}
    for (Ringtone localRingtone = this.yIL;; localRingtone = this.yIH.getRingtone(this.yIK - 1))
    {
      if (localRingtone == null) {
        break label78;
      }
      try
      {
        localRingtone.play();
        AppMethodBeat.o(74368);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("RingtonePickerActivity", localException, "play ringtone error", new Object[0]);
      }
    }
    label78:
    AppMethodBeat.o(74368);
  }
  
  final class a
    extends BaseAdapter
  {
    int count;
    Cursor dqD;
    int padding;
    
    public a(Cursor paramCursor)
    {
      AppMethodBeat.i(74362);
      this.count = 0;
      this.padding = 0;
      this.dqD = paramCursor;
      this.count = (paramCursor.getCount() + 1);
      ad.d("RingtonePickerActivity", "count = " + this.count);
      this.padding = SettingsRingtoneUI.this.getResources().getDimensionPixelSize(2131165516);
      AppMethodBeat.o(74362);
    }
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(74364);
      if ((this.dqD.isClosed()) || (!this.dqD.moveToPosition(paramInt - 1)))
      {
        AppMethodBeat.o(74364);
        return "";
      }
      String str = this.dqD.getString(this.dqD.getColumnIndex("title"));
      AppMethodBeat.o(74364);
      return str;
    }
    
    public final int getCount()
    {
      return this.count;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(74363);
      paramView = (CheckedTextView)SettingsRingtoneUI.this.yII.inflate(2131495345, null);
      if (paramInt == 0)
      {
        paramView.setBackgroundResource(2131231818);
        paramView.setText(2131763334);
      }
      for (;;)
      {
        paramView.setPadding(this.padding, 0, this.padding, 0);
        paramView.setCheckMarkDrawable(2131233872);
        AppMethodBeat.o(74363);
        return paramView;
        paramView.setBackgroundResource(2131231818);
        paramView.setText(getItem(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsRingtoneUI
 * JD-Core Version:    0.7.0.1
 */