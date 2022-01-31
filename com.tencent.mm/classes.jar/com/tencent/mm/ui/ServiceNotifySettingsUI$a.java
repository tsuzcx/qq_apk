package com.tencent.mm.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import java.util.LinkedList;

final class ServiceNotifySettingsUI$a
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mLayoutInflater;
  private int mMode;
  private View.OnClickListener mOnClickListener;
  private String mSceneId;
  LinkedList<ServiceNotifySettingsUI.a.a> zeV;
  LinkedList<ServiceNotifySettingsUI.a.a> zeW;
  private c zeX;
  
  public ServiceNotifySettingsUI$a(Context paramContext, LayoutInflater paramLayoutInflater, int paramInt, String paramString)
  {
    AppMethodBeat.i(29857);
    this.mContext = paramContext;
    this.mMode = paramInt;
    this.mSceneId = paramString;
    this.mLayoutInflater = paramLayoutInflater;
    this.zeV = new LinkedList();
    this.zeW = new LinkedList();
    this.mOnClickListener = new ServiceNotifySettingsUI.a.1(this, paramInt);
    paramContext = new c.a();
    paramContext.eOk = true;
    paramContext.eOb = com.tencent.mm.modelappbrand.a.a.acC();
    this.zeX = paramContext.ahY();
    AppMethodBeat.o(29857);
  }
  
  private ServiceNotifySettingsUI.a.a Ov(int paramInt)
  {
    AppMethodBeat.i(29859);
    ServiceNotifySettingsUI.a.a locala = (ServiceNotifySettingsUI.a.a)this.zeV.get(paramInt);
    AppMethodBeat.o(29859);
    return locala;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(29858);
    int i = this.zeV.size();
    AppMethodBeat.o(29858);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(29860);
    ServiceNotifySettingsUI.a.a locala = Ov(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.mLayoutInflater.inflate(2130970677, paramViewGroup, false);
      paramView = new ServiceNotifySettingsUI.a.b((byte)0);
      paramView.ehv = ((ImageView)localView.findViewById(2131827576));
      paramView.titleTv = ((TextView)localView.findViewById(2131821335));
      paramView.zfb = ((TextView)localView.findViewById(2131827577));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      o.ahG().a(locala.url, paramViewGroup.ehv, this.zeX);
      paramViewGroup.titleTv.setText(locala.title);
      if (this.mMode != 1) {
        break label190;
      }
      paramViewGroup.zfb.setText(this.mContext.getString(2131301982));
    }
    for (;;)
    {
      paramViewGroup.zfb.setTag(locala.username);
      paramViewGroup.zfb.setOnClickListener(this.mOnClickListener);
      AppMethodBeat.o(29860);
      return localView;
      paramViewGroup = (ServiceNotifySettingsUI.a.b)paramView.getTag();
      localView = paramView;
      break;
      label190:
      paramViewGroup.zfb.setText(this.mContext.getString(2131301983));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.ServiceNotifySettingsUI.a
 * JD-Core Version:    0.7.0.1
 */