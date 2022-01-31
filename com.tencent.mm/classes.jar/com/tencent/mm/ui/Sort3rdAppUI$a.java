package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.List;

final class Sort3rdAppUI$a
  extends ArrayAdapter<f>
{
  List<f> iVa;
  private c jAJ;
  private Context mContext;
  private long tBq;
  
  public Sort3rdAppUI$a(Context paramContext, List<f> paramList, long paramLong)
  {
    super(paramContext, R.i.sort_3rd_app_ui_item, paramList);
    this.tBq = paramLong;
    this.mContext = paramContext;
    this.iVa = paramList;
    paramContext = new c.a();
    paramContext.eru = R.g.my_device_default_icon;
    this.jAJ = paramContext.OV();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    f localf;
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, R.i.sort_3rd_app_ui_item, null);
      paramViewGroup = new Sort3rdAppUI.a.a(paramView);
      paramView.setTag(paramViewGroup);
      localf = (f)getItem(paramInt);
      paramViewGroup.eXO.setText(localf.field_appName);
      localObject = g.b(localf.field_appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label155;
      }
      paramViewGroup.gSx.setImageBitmap((Bitmap)localObject);
      label95:
      localObject = paramViewGroup.lAy;
      if ((localf.field_appInfoFlag & 0x4000) != 0) {
        break label177;
      }
    }
    for (;;)
    {
      ((MMSwitchBtn)localObject).setCheck(bool);
      paramViewGroup.lAy.setSwitchListener(new Sort3rdAppUI.a.1(this, localf));
      paramView.setVisibility(0);
      return paramView;
      paramViewGroup = (Sort3rdAppUI.a.a)paramView.getTag();
      break;
      label155:
      o.ON().a(localf.field_appIconUrl, paramViewGroup.gSx, this.jAJ);
      break label95;
      label177:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI.a
 * JD-Core Version:    0.7.0.1
 */