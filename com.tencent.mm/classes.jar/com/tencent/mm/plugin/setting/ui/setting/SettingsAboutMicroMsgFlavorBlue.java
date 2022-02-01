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
import com.tencent.mm.sdk.platformtools.Log;
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
  private String[] Dan;
  private String[] Dao;
  HashMap<String, String> Dap;
  private f screen;
  
  public SettingsAboutMicroMsgFlavorBlue()
  {
    AppMethodBeat.i(256499);
    this.Dan = new String[] { "7.0.21", "7.0.20", "7.0.19", "7.0.18" };
    this.Dao = new String[] { "小程序\n   1.connectWifi Android 10适配\n   2.视频相关bug修改\n   3.音视频编辑组件网络流添加断点续传功能，能对网络资源进行缓存;网络流添加seek支持;硬编码改成兼容性更好的VBR（动态码率）模式，编解码速度更快\n   4.websocket细分返回的错误信息\n小游戏\n   1.connectWifi Android 10适配\n   2.视频相关bug修改\n   3.音视频编辑组件网络流添加断点续传功能，能对网络资源进行缓存;网络流添加seek支持;硬编码改成兼容性更好的VBR（动态码率）模式，编解码速度更快\n   4.websocket细分返回的错误信息\n   5.小游戏性能优化方案渲染层更新\n", "小程序\n   1.优化小程序进程分配策略\n   2.优化小程序js注入耗时\n   3.修复全屏相关bug\n小游戏\n   1.启动阶段功能模块懒加载，进程加载优化，优化启动速度\n   2.性能面板增加js注入耗时、首屏渲染耗时\n   3.优化从朋友圈分享的卡片点开跳转速度\n", "小程序\n   1.优化识别二维码打开小程序的速度\n   2.worker 支持 CPU Profile\n   3.修复蓝牙线程安全问题\n   4.WebSocket切后台时支持主动断开连接\n   5.音频延迟以及CPU占用优化\n小游戏\n   1.worker 支持 CPU Profile\n   2.修复蓝牙线程安全问题\n   3.WebSocket切后台时支持主动断开连接\n   4.音频延迟以及CPU占用优化\n", "小程序\n   1.小程序正式版,拥有体验版权限的开发者能打开菜单中的开发调试\n   2.小程序webiew与service通信优化\n   3.小程序界面层级优化\n   4.小程序界面显示重构\n小游戏\n   1.小游戏正式版,拥有体验版权限的开发者能打开菜单中的开发调试\n   2.修复相同图片重复解码时内存泄漏问题\n" };
    this.Dap = new HashMap();
    AppMethodBeat.o(256499);
  }
  
  private void eSS()
  {
    AppMethodBeat.i(256504);
    this.screen = getPreferenceScreen();
    this.screen.removeAll();
    int i = 0;
    while (i < this.Dan.length)
    {
      IconPreference localIconPreference = new IconPreference(this);
      this.screen.c(localIconPreference);
      localIconPreference.setKey(this.Dan[i]);
      localIconPreference.setTitle(this.Dan[i]);
      i += 1;
    }
    this.screen.notifyDataSetChanged();
    AppMethodBeat.o(256504);
  }
  
  public int getResourceId()
  {
    return 2132017267;
  }
  
  public void initView()
  {
    AppMethodBeat.i(256503);
    setMMTitle(getResources().getString(2131761069));
    setActionbarColor(getContext().getResources().getColor(2131099650));
    setBackGroundColorResource(2131101424);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256497);
        SettingsAboutMicroMsgFlavorBlue.this.hideVKB();
        SettingsAboutMicroMsgFlavorBlue.this.finish();
        AppMethodBeat.o(256497);
        return true;
      }
    });
    if (getListView() != null)
    {
      int i = getContext().getResources().getDimensionPixelSize(2131165299);
      getListView().setPadding(i, 0, i, 0);
      getListView().setBackgroundColor(getContext().getResources().getColor(2131099650));
    }
    eSS();
    AppMethodBeat.o(256503);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256500);
    super.onCreate(paramBundle);
    hideActionbarLine();
    int i = 0;
    while (i < this.Dan.length)
    {
      this.Dap.put(this.Dan[i], this.Dao[i]);
      i += 1;
    }
    initView();
    AppMethodBeat.o(256500);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(256502);
    super.onDestroy();
    AppMethodBeat.o(256502);
  }
  
  public boolean onPreferenceTreeClick(f paramf, final Preference paramPreference)
  {
    AppMethodBeat.i(256505);
    Object localObject = paramPreference.mKey;
    Log.i("MicroMsg.SettingsAboutMicroMsgFlavorBlue", (String)localObject + " item has been clicked!");
    paramf = (String)this.Dap.get(localObject);
    paramPreference = new g(getContext(), 2, 2);
    paramPreference.T(getResources().getString(2131755873));
    paramPreference.ape(0);
    paramPreference.QOT = new g.a()
    {
      public final void onClick()
      {
        AppMethodBeat.i(256498);
        paramPreference.bMo();
        AppMethodBeat.o(256498);
      }
    };
    paramPreference.aE((CharSequence)localObject);
    localObject = new TextView(this);
    ((TextView)localObject).setText(paramf);
    paramPreference.setCustomView((View)localObject);
    paramPreference.dGm();
    AppMethodBeat.o(256505);
    return true;
  }
  
  public void onResume()
  {
    AppMethodBeat.i(256501);
    super.onResume();
    eSS();
    AppMethodBeat.o(256501);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgFlavorBlue
 * JD-Core Version:    0.7.0.1
 */