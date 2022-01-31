package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.az.a;
import com.tencent.mm.az.m;
import com.tencent.mm.az.n;
import com.tencent.mm.cf.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.storage.z;

final class SettingsSelectBgUI$a
  extends com.tencent.mm.ui.r<m>
{
  private Context context;
  private int iAj;
  
  public SettingsSelectBgUI$a(SettingsSelectBgUI paramSettingsSelectBgUI, Context paramContext, int paramInt)
  {
    super(paramContext, new m());
    this.context = paramContext;
    this.iAj = paramInt;
  }
  
  public final int getCount()
  {
    return getCursor().getCount() + 2;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i;
    a locala;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, a.g.settings_select_bg_view, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.iAj, this.iAj));
      paramViewGroup = new b();
      paramViewGroup.nXC = ((LinearLayout)paramView.findViewById(a.f.select_bg_downloading_ll));
      paramViewGroup.nXD = ((LinearLayout)paramView.findViewById(a.f.select_bg_downloaded_ll));
      paramViewGroup.nXE = ((LinearLayout)paramView.findViewById(a.f.select_bg_undownloaded_ll));
      paramViewGroup.nXF = ((LinearLayout)paramView.findViewById(a.f.select_bg_using_ll));
      paramViewGroup.nXG = ((LinearLayout)paramView.findViewById(a.f.select_bg_canceling_ll));
      paramView.setTag(paramViewGroup);
      i = bk.a((Integer)g.DP().Dz().get(12311, null), -2);
      locala = com.tencent.mm.az.r.PL().mI(SettingsSelectBgUI.f(this.nVW));
      if (paramInt != 0) {
        break label276;
      }
      if (((!SettingsSelectBgUI.c(this.nVW)) || (i != -2)) && ((SettingsSelectBgUI.c(this.nVW)) || (i != -2) || (locala != null)) && ((locala == null) || (locala.ewu != -2))) {
        break label267;
      }
      paramViewGroup.Mt("using");
    }
    for (;;)
    {
      paramViewGroup = c.a(BitmapFactory.decodeResource(this.context.getResources(), a.e.chatting_bg_purecolor_thumb), true, 10.0F);
      ((ImageView)paramView.findViewById(a.f.select_bg_pkg_iv)).setImageBitmap(paramViewGroup);
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label267:
      paramViewGroup.Mt("downloaded");
    }
    label276:
    if (paramInt == 1)
    {
      if (((SettingsSelectBgUI.c(this.nVW)) && (i == 0)) || ((!SettingsSelectBgUI.c(this.nVW)) && (i == 0) && (locala == null)) || ((locala != null) && (locala.ewu == 0))) {
        paramViewGroup.Mt("using");
      }
      for (;;)
      {
        paramViewGroup = c.a(BitmapFactory.decodeResource(this.context.getResources(), a.e.chatting_bg_default_thumb), true, 10.0F);
        ((ImageView)paramView.findViewById(a.f.select_bg_pkg_iv)).setImageBitmap(paramViewGroup);
        return paramView;
        paramViewGroup.Mt("downloaded");
      }
    }
    m localm = (m)getItem(paramInt - 2);
    com.tencent.mm.az.r.PK();
    if (!g.DP().isSDCardAvailable()) {}
    for (Bitmap localBitmap = BitmapFactory.decodeResource(this.nVW.getResources(), a.e.nosdcard_chatting_bg_thumb); localBitmap != null; localBitmap = c.YW(n.PH() + n.bq(localm.id, localm.bOa)))
    {
      localBitmap = c.a(localBitmap, true, 10.0F);
      ((ImageView)paramView.findViewById(a.f.select_bg_pkg_iv)).setImageBitmap(localBitmap);
      switch (localm.status)
      {
      default: 
        return paramView;
      case 1: 
        if ((SettingsSelectBgUI.c(this.nVW)) || (locala == null) || (locala.ewu == localm.id)) {
          break label628;
        }
        paramViewGroup.Mt("downloaded");
        return paramView;
      }
    }
    paramViewGroup.Mt("downloading");
    return paramView;
    if ((!SettingsSelectBgUI.c(this.nVW)) && (locala != null) && (locala.ewu == localm.id))
    {
      paramViewGroup.Mt("using");
      return paramView;
    }
    paramViewGroup.Mt("downloaded");
    return paramView;
    paramViewGroup.Mt("undownloaded");
    return paramView;
    label628:
    paramViewGroup.Mt("using");
    return paramView;
    paramViewGroup.Mt("canceling");
    return paramView;
  }
  
  public final void yc()
  {
    setCursor(com.tencent.mm.az.r.PK().dXo.a("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=1", null, 0));
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SettingsSelectBgUI.a
 * JD-Core Version:    0.7.0.1
 */