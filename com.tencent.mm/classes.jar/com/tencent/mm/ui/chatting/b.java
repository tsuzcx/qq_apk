package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

final class b
  extends BaseAdapter
{
  private Context context;
  private c jAJ;
  private List<ab> vho;
  boolean vhp = false;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
    this.vho = new ArrayList();
    paramContext = new c.a();
    paramContext.eru = R.g.my_device_default_icon;
    this.jAJ = paramContext.OV();
    bc(null);
  }
  
  private ab GH(int paramInt)
  {
    return (ab)this.vho.get(paramInt);
  }
  
  public final void bc(List<ab> paramList)
  {
    this.vho.clear();
    if ((paramList != null) && (paramList.size() != 0)) {
      this.vho.addAll(paramList);
    }
    if (this.vhp)
    {
      paramList = this.vho;
      localab = new ab();
      localab.kCB = R.g.send_data_system_open;
      localab.dtK = this.context.getString(R.l.chatting_send_system_open);
      paramList.add(localab);
    }
    paramList = this.vho;
    ab localab = new ab();
    localab.kCB = R.g.send_data_settings;
    localab.dtK = this.context.getString(R.l.settings_title);
    paramList.add(localab);
    y.d("MicroMsg.AppInfoListAdapter", "updateData mDeviceInfoList.size() = %d.", new Object[] { Integer.valueOf(this.vho.size()) });
  }
  
  public final int getCount()
  {
    return this.vho.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ab localab = GH(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new as();
      localObject = View.inflate(paramViewGroup.getContext(), R.i.send_data_to_device_item, null);
      paramView.jDJ = ((View)localObject).findViewById(R.h.container);
      paramView.fhD = ((TextView)((View)localObject).findViewById(R.h.nameTV));
      paramView.gSx = ((ImageView)((View)localObject).findViewById(R.h.iconIV));
      paramView.vlE = ((TextView)((View)localObject).findViewById(R.h.sendStateTV));
      paramView.vnu = ((SendDataToDeviceProgressBar)((View)localObject).findViewById(R.h.sendProgress));
      paramView.vnu.setVisibility(4);
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      paramViewGroup.fhD.setText(localab.dtK);
      y.v("MicroMsg.AppInfoListAdapter", "position(%s), name(%s).", new Object[] { Integer.valueOf(paramInt), localab.dtK });
      if (localab.kCB == 0) {
        break label205;
      }
      paramViewGroup.gSx.setImageResource(localab.kCB);
    }
    for (;;)
    {
      paramViewGroup.jDJ.setTag(Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = (as)paramView.getTag();
      break;
      label205:
      localObject = g.b(localab.appId, 1, com.tencent.mm.cb.a.getDensity(this.context));
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
        paramViewGroup.gSx.setImageBitmap((Bitmap)localObject);
      } else {
        o.ON().a(localab.iconUrl, paramViewGroup.gSx, this.jAJ);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b
 * JD-Core Version:    0.7.0.1
 */