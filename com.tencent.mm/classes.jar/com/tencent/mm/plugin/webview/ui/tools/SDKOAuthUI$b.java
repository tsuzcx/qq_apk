package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.protocal.c.azp;
import java.util.LinkedList;

final class SDKOAuthUI$b
  extends BaseAdapter
{
  private LayoutInflater Lu;
  LinkedList<azp> rmp;
  private c.a rmq;
  private Context rmr;
  private int rms;
  
  public SDKOAuthUI$b(Context paramContext, LinkedList<azp> paramLinkedList, int paramInt)
  {
    this.Lu = LayoutInflater.from(paramContext);
    this.rmp = paramLinkedList;
    this.rmq = new c.a();
    this.rmq.eru = R.k.native_oauth_default_head_img;
    this.rmr = paramContext;
    this.rms = paramInt;
  }
  
  public final azp CA(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.rmp.size())) {
      return (azp)this.rmp.get(paramInt);
    }
    return null;
  }
  
  public final int getCount()
  {
    if (this.rmp == null) {
      return 0;
    }
    return this.rmp.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    azp localazp = CA(paramInt);
    if (localazp == null) {
      return paramView;
    }
    View localView;
    if (paramView == null)
    {
      paramView = new SDKOAuthUI.b.a((byte)0);
      localView = this.Lu.inflate(R.i.avatar_item, null, false);
      paramView.rmt = ((ImageView)localView.findViewById(R.h.avatar_icon));
      paramView.rmu = ((TextView)localView.findViewById(R.h.avatar_name));
      paramView.rmv = ((TextView)localView.findViewById(R.h.avatar_comment));
      paramView.rmw = ((ImageView)localView.findViewById(R.h.avatar_state));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.rmu.setText(localazp.nickname);
      o.ON().a(localazp.tgf, paramViewGroup.rmt, this.rmq.OV());
      if (localazp.desc == null) {
        break label208;
      }
      paramViewGroup.rmv.setText(localazp.desc);
      paramViewGroup.rmv.setVisibility(0);
    }
    for (;;)
    {
      if (localazp.id != this.rms) {
        break label220;
      }
      paramViewGroup.rmw.setVisibility(0);
      return localView;
      paramViewGroup = (SDKOAuthUI.b.a)paramView.getTag();
      localView = paramView;
      break;
      label208:
      paramViewGroup.rmv.setVisibility(8);
    }
    label220:
    paramViewGroup.rmw.setVisibility(4);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.b
 * JD-Core Version:    0.7.0.1
 */