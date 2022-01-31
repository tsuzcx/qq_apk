package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.List;

final class Sort3rdAppUI$a
  extends ArrayAdapter<f>
{
  private c lKi;
  List<f> lee;
  private Context mContext;
  private long xCZ;
  
  public Sort3rdAppUI$a(Context paramContext, List<f> paramList, long paramLong)
  {
    super(paramContext, 2130970901, paramList);
    AppMethodBeat.i(29902);
    this.xCZ = paramLong;
    this.mContext = paramContext;
    this.lee = paramList;
    paramContext = new c.a();
    paramContext.eNY = 2130839759;
    this.lKi = paramContext.ahY();
    AppMethodBeat.o(29902);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    AppMethodBeat.i(29903);
    f localf;
    Object localObject;
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130970901, null);
      paramViewGroup = new Sort3rdAppUI.a.a(paramView);
      paramView.setTag(paramViewGroup);
      localf = (f)getItem(paramInt);
      paramViewGroup.gpL.setText(localf.field_appName);
      localObject = g.b(localf.field_appId, 1, com.tencent.mm.cb.a.getDensity(this.mContext));
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label166;
      }
      paramViewGroup.ivs.setImageBitmap((Bitmap)localObject);
      label100:
      localObject = paramViewGroup.iDy;
      if ((localf.field_appInfoFlag & 0x4000) != 0) {
        break label188;
      }
    }
    for (;;)
    {
      ((MMSwitchBtn)localObject).setCheck(bool);
      paramViewGroup.iDy.setSwitchListener(new Sort3rdAppUI.a.1(this, localf));
      paramView.setVisibility(0);
      AppMethodBeat.o(29903);
      return paramView;
      paramViewGroup = (Sort3rdAppUI.a.a)paramView.getTag();
      break;
      label166:
      o.ahG().a(localf.field_appIconUrl, paramViewGroup.ivs, this.lKi);
      break label100;
      label188:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.Sort3rdAppUI.a
 * JD-Core Version:    0.7.0.1
 */