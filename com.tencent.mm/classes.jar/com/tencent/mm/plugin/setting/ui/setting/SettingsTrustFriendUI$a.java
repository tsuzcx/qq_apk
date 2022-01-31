package com.tencent.mm.plugin.setting.ui.setting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;

final class SettingsTrustFriendUI$a
  extends BaseAdapter
{
  private SettingsTrustFriendUI$a(SettingsTrustFriendUI paramSettingsTrustFriendUI) {}
  
  public final int getCount()
  {
    int i = SettingsTrustFriendUI.e(this.nWp).size();
    if (SettingsTrustFriendUI.b(this.nWp)) {
      return i;
    }
    if (i == 0) {
      return 1;
    }
    if ((i > 0) && (i < SettingsTrustFriendUI.su())) {
      return i + 2;
    }
    if (i >= SettingsTrustFriendUI.su()) {
      return i + 1;
    }
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    if (getItemViewType(paramInt) == 0) {
      return SettingsTrustFriendUI.e(this.nWp).get(paramInt);
    }
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    int j = 1;
    int k = SettingsTrustFriendUI.e(this.nWp).size();
    int i;
    if ((SettingsTrustFriendUI.b(this.nWp)) || (paramInt < k)) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (k == 0);
      if (k >= SettingsTrustFriendUI.su()) {
        return 2;
      }
      i = j;
    } while (paramInt == k);
    if (paramInt == k + 1) {
      return 2;
    }
    return -1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.nWp.getLayoutInflater().inflate(a.g.settings_trust_friend_item, null);
      Object localObject1 = (ImageView)paramView.findViewById(a.f.trust_friend_avatar);
      Object localObject2 = (ImageView)paramView.findViewById(a.f.trust_friend_del_btn);
      TextView localTextView = (TextView)paramView.findViewById(a.f.trust_friend_name);
      paramViewGroup = new SettingsTrustFriendUI.a.a(this, (byte)0);
      paramViewGroup.nOd = ((ImageView)localObject1);
      paramViewGroup.nWs = ((ImageView)localObject2);
      paramViewGroup.hPg = localTextView;
      paramView.setTag(paramViewGroup);
      if (getItemViewType(paramInt) != 0) {
        break label223;
      }
      localObject1 = (String)SettingsTrustFriendUI.e(this.nWp).get(paramInt);
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl((String)localObject1);
      paramViewGroup.nOd.setScaleType(ImageView.ScaleType.FIT_XY);
      a.b.a(paramViewGroup.nOd, (String)localObject1);
      paramViewGroup.hPg.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.nWp, ((ad)localObject2).Bq(), paramViewGroup.hPg.getTextSize()));
      if (!SettingsTrustFriendUI.b(this.nWp)) {
        break label212;
      }
      paramViewGroup.nWs.setVisibility(0);
    }
    label212:
    label223:
    do
    {
      return paramView;
      paramViewGroup = (SettingsTrustFriendUI.a.a)paramView.getTag();
      break;
      paramViewGroup.nWs.setVisibility(8);
      return paramView;
      paramViewGroup.hPg.setVisibility(4);
      paramViewGroup.nWs.setVisibility(8);
      paramViewGroup.nOd.setScaleType(ImageView.ScaleType.FIT_XY);
      if (getItemViewType(paramInt) == 1)
      {
        paramViewGroup.nOd.setImageResource(a.e.big_add_selector);
        return paramView;
      }
    } while (getItemViewType(paramInt) != 2);
    paramViewGroup.nOd.setImageResource(a.e.big_del_selector);
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsTrustFriendUI.a
 * JD-Core Version:    0.7.0.1
 */