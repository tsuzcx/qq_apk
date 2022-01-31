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
import com.tencent.mm.protocal.c.azs;
import java.util.LinkedList;

final class SDKOAuthUI$a
  extends BaseAdapter
{
  private LayoutInflater Lu;
  private LinkedList<azs> rlY;
  
  public SDKOAuthUI$a(Context paramContext, LinkedList<azs> paramLinkedList)
  {
    this.Lu = LayoutInflater.from(paramContext);
    this.rlY = paramLinkedList;
  }
  
  private azs Cz(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.rlY.size())) {
      return (azs)this.rlY.get(paramInt);
    }
    return null;
  }
  
  public final LinkedList<String> cdG()
  {
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.rlY.size())
    {
      azs localazs = (azs)this.rlY.get(i);
      if ((localazs.tvP == 2) || (localazs.tvP == 3)) {
        localLinkedList.add(localazs.scope);
      }
      i += 1;
    }
    return localLinkedList;
  }
  
  public final int getCount()
  {
    if (this.rlY == null) {
      return 0;
    }
    return this.rlY.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.rlY == null) || (this.rlY.size() <= 0)) {
      paramViewGroup = null;
    }
    azs localazs;
    do
    {
      return paramViewGroup;
      localazs = Cz(paramInt);
      paramViewGroup = paramView;
    } while (localazs == null);
    if (paramView == null)
    {
      paramViewGroup = new SDKOAuthUI.a.a((byte)0);
      paramView = this.Lu.inflate(R.i.sdk_authorize_scope_item, null, false);
      paramViewGroup.fYe = ((ImageView)paramView.findViewById(R.h.app_auth_state));
      paramViewGroup.fYf = ((TextView)paramView.findViewById(R.h.app_auth_desc));
      paramView.setTag(paramViewGroup);
      if (localazs.tvP != 1) {
        break label163;
      }
      paramViewGroup.fYe.setImageResource(R.k.login_auth_state_not_selected);
    }
    for (;;)
    {
      paramViewGroup.fYf.setText(localazs.desc);
      ImageView localImageView = paramViewGroup.fYe;
      paramViewGroup.fYe.setOnClickListener(new SDKOAuthUI.a.1(this, localazs, localImageView));
      return paramView;
      paramViewGroup = (SDKOAuthUI.a.a)paramView.getTag();
      break;
      label163:
      if (localazs.tvP == 3) {
        paramViewGroup.fYe.setImageResource(R.k.login_auth_state_must_select);
      } else {
        paramViewGroup.fYe.setImageResource(R.k.login_auth_state_default_select);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.a
 * JD-Core Version:    0.7.0.1
 */