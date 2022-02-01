package com.tencent.mm.plugin.setting.ui.setting.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/permission/SettingSportPermissionUI;", "Lcom/tencent/mm/plugin/setting/ui/setting/permission/BaseSettingPermissionUI;", "()V", "getContentLayoutId", "", "getPermissionDesc", "getTitleId", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SettingSportPermissionUI
  extends BaseSettingPermissionUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public final int dTn()
  {
    return b.g.setting_permission_sport_layout;
  }
  
  public final int gWA()
  {
    return b.i.settings_permission_healthy_title;
  }
  
  public final int gWz()
  {
    return b.i.setting_permission_healthy_desc;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.permission.SettingSportPermissionUI
 * JD-Core Version:    0.7.0.1
 */