package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.setting.b.c;
import com.tencent.mm.plugin.setting.b.d;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.plugin.setting.b.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.HashMap;

@k
public class SettingsAboutMicroMsgFlavorBlue
  extends MMPreference
{
  private String[] JfO;
  private String[] JfP;
  HashMap<String, String> JfQ;
  private f screen;
  
  public SettingsAboutMicroMsgFlavorBlue()
  {
    AppMethodBeat.i(263592);
    this.JfO = new String[] { "7.0.21", "7.0.20", "7.0.19", "7.0.18" };
    this.JfP = new String[] { "小程序\n   1.connectWifi Android 10适配\n   2.视频相关bug修改\n   3.音视频编辑组件网络流添加断点续传功能，能对网络资源进行缓存;网络流添加seek支持;硬编码改成兼容性更好的VBR（动态码率）模式，编解码速度更快\n   4.websocket细分返回的错误信息\n小游戏\n   1.connectWifi Android 10适配\n   2.视频相关bug修改\n   3.音视频编辑组件网络流添加断点续传功能，能对网络资源进行缓存;网络流添加seek支持;硬编码改成兼容性更好的VBR（动态码率）模式，编解码速度更快\n   4.websocket细分返回的错误信息\n   5.小游戏性能优化方案渲染层更新\n", "小程序\n   1.优化小程序进程分配策略\n   2.优化小程序js注入耗时\n   3.修复全屏相关bug\n小游戏\n   1.启动阶段功能模块懒加载，进程加载优化，优化启动速度\n   2.性能面板增加js注入耗时、首屏渲染耗时\n   3.优化从朋友圈分享的卡片点开跳转速度\n", "小程序\n   1.优化识别二维码打开小程序的速度\n   2.worker 支持 CPU Profile\n   3.修复蓝牙线程安全问题\n   4.WebSocket切后台时支持主动断开连接\n   5.音频延迟以及CPU占用优化\n小游戏\n   1.worker 支持 CPU Profile\n   2.修复蓝牙线程安全问题\n   3.WebSocket切后台时支持主动断开连接\n   4.音频延迟以及CPU占用优化\n", "小程序\n   1.小程序正式版,拥有体验版权限的开发者能打开菜单中的开发调试\n   2.小程序webiew与service通信优化\n   3.小程序界面层级优化\n   4.小程序界面显示重构\n小游戏\n   1.小游戏正式版,拥有体验版权限的开发者能打开菜单中的开发调试\n   2.修复相同图片重复解码时内存泄漏问题\n" };
    this.JfQ = new HashMap();
    AppMethodBeat.o(263592);
  }
  
  private void fFW()
  {
    AppMethodBeat.i(263605);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    int i = 0;
    while (i < this.JfO.length)
    {
      IconPreference localIconPreference = new IconPreference(this);
      this.screen.b(localIconPreference);
      localIconPreference.setKey(this.JfO[i]);
      localIconPreference.setTitle(this.JfO[i]);
      i += 1;
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(263605);
  }
  
  public int getResourceId()
  {
    return b.k.settings_pref_about_micromsg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(263601);
    setMMTitle(getResources().getString(b.i.funtion_about_flavor_blue));
    setActionbarColor(getContext().getResources().getColor(b.c.BG_2));
    setBackGroundColorResource(b.c.white);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(263205);
        SettingsAboutMicroMsgFlavorBlue.this.hideVKB();
        SettingsAboutMicroMsgFlavorBlue.this.finish();
        AppMethodBeat.o(263205);
        return true;
      }
    });
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(b.d.Edge_3A);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getContext().getResources().getColor(b.c.BG_2));
    }
    fFW();
    AppMethodBeat.o(263601);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(263597);
    super.onCreate(paramBundle);
    hideActionbarLine();
    int i = 0;
    while (i < this.JfO.length)
    {
      this.JfQ.put(this.JfO[i], this.JfP[i]);
      i += 1;
    }
    initView();
    AppMethodBeat.o(263597);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(263600);
    super.onDestroy();
    AppMethodBeat.o(263600);
  }
  
  public boolean onPreferenceTreeClick(f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(263608);
    Object localObject = paramPreference.mKey;
    Log.i("MicroMsg.SettingsAboutMicroMsgFlavorBlue", (String)localObject + " item has been clicked!");
    paramf = (String)this.JfQ.get(localObject);
    paramPreference = new g(getContext(), 2, 2);
    paramPreference.ah(getResources().getString(b.i.app_i_know));
    paramPreference.ayu(0);
    paramPreference.YnF = new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(264403);
        paramPreference.bYF();
        AppMethodBeat.o(264403);
      }
    };
    paramPreference.aT((CharSequence)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setText(paramf);
    paramPreference.setCustomView((View)localObject);
    paramPreference.eik();
    AppMethodBeat.o(263608);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(263599);
    super.onResume();
    fFW();
    AppMethodBeat.o(263599);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgFlavorBlue
 * JD-Core Version:    0.7.0.1
 */