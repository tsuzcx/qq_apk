package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.HashMap;

@i
public class SettingsAboutMicroMsgFlavorBlue
  extends MMPreference
{
  private f screen;
  HashMap<String, String> yVA;
  private String[] yVy;
  private String[] yVz;
  
  public SettingsAboutMicroMsgFlavorBlue()
  {
    AppMethodBeat.i(190331);
    this.yVy = new String[] { "7.0.18.f2", "7.0.18.f1" };
    this.yVz = new String[] { "小程序\n   1.小程序界面层级优化\n   2.小程序界面显示重构\n小游戏\n   1.修复相同图片重复解码时内存泄漏问题\n", "小程序\n   1.小程序正式版,拥有体验版权限的开发者能打开菜单中的开发调试\n   2.小程序webiew与service通信优化\n小游戏\n   1.小游戏正式版,拥有体验版权限的开发者能打开菜单中的开发调试" };
    this.yVA = new HashMap();
    AppMethodBeat.o(190331);
  }
  
  private void dQR()
  {
    AppMethodBeat.i(190336);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    int i = 0;
    while (i < this.yVy.length)
    {
      IconPreference localIconPreference = new IconPreference(this);
      this.screen.b(localIconPreference);
      localIconPreference.setKey(this.yVy[i]);
      localIconPreference.setTitle(this.yVy[i]);
      i += 1;
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(190336);
  }
  
  public int getResourceId()
  {
    return 2131951722;
  }
  
  public void initView()
  {
    AppMethodBeat.i(190335);
    setMMTitle(getResources().getString(2131767085));
    setActionbarColor(getContext().getResources().getColor(2131099650));
    setBackGroundColorResource(2131101179);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(190329);
        SettingsAboutMicroMsgFlavorBlue.this.hideVKB();
        SettingsAboutMicroMsgFlavorBlue.this.finish();
        AppMethodBeat.o(190329);
        return true;
      }
    });
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(2131165292);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getContext().getResources().getColor(2131099650));
    }
    dQR();
    AppMethodBeat.o(190335);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190332);
    super.onCreate(paramBundle);
    hideActionbarLine();
    int i = 0;
    while (i < this.yVy.length)
    {
      this.yVA.put(this.yVy[i], this.yVz[i]);
      i += 1;
    }
    initView();
    AppMethodBeat.o(190332);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(190334);
    super.onDestroy();
    AppMethodBeat.o(190334);
  }
  
  public boolean onPreferenceTreeClick(f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(190337);
    Object localObject = paramPreference.mKey;
    ae.i("MicroMsg.SettingsAboutMicroMsgFlavorBlue", (String)localObject + " item has been clicked!");
    paramf = (String)this.yVA.get(localObject);
    paramPreference = new g(getContext(), 2, 2);
    paramPreference.aw(getResources().getString(2131755792));
    paramPreference.agb(0);
    paramPreference.LtZ = new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(190330);
        paramPreference.bqD();
        AppMethodBeat.o(190330);
      }
    };
    paramPreference.ax((CharSequence)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setText(paramf);
    paramPreference.setCustomView((View)localObject);
    paramPreference.cPF();
    AppMethodBeat.o(190337);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(190333);
    super.onResume();
    dQR();
    AppMethodBeat.o(190333);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgFlavorBlue
 * JD-Core Version:    0.7.0.1
 */