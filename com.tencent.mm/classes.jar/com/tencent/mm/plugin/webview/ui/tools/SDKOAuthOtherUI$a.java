package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.protocal.c.azs;
import java.util.LinkedList;

final class SDKOAuthOtherUI$a
  extends BaseAdapter
{
  private LayoutInflater Lu;
  private Context mContext;
  LinkedList<azs> rlY;
  
  public SDKOAuthOtherUI$a(Context paramContext, LinkedList<azs> paramLinkedList)
  {
    this.Lu = LayoutInflater.from(paramContext);
    this.rlY = paramLinkedList;
    this.mContext = paramContext;
  }
  
  private azs Cz(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.rlY.size())) {
      return (azs)this.rlY.get(paramInt);
    }
    return null;
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
    final azs localazs;
    do
    {
      return paramViewGroup;
      localazs = Cz(paramInt);
      paramViewGroup = paramView;
    } while (localazs == null);
    if (paramView == null)
    {
      paramViewGroup = new SDKOAuthOtherUI.a.a((byte)0);
      paramView = this.Lu.inflate(R.i.sdk_authorize_scope_item_new, null, false);
      paramViewGroup.fYe = ((ImageView)paramView.findViewById(R.h.app_auth_state));
      paramViewGroup.fYf = ((TextView)paramView.findViewById(R.h.app_auth_desc));
      paramView.setTag(paramViewGroup);
      if (localazs.tvP != 1) {
        break label163;
      }
      paramViewGroup.fYe.setImageResource(R.k.login_auth_state_radar_not_selected);
    }
    for (;;)
    {
      paramViewGroup.fYf.setText(localazs.desc);
      final ImageView localImageView = paramViewGroup.fYe;
      paramViewGroup.fYe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (localazs.tvP == 2)
          {
            localImageView.setImageResource(R.k.login_auth_state_radar_not_selected);
            localazs.tvP = 1;
          }
          while (localazs.tvP != 1) {
            return;
          }
          localImageView.setImageResource(R.k.login_auth_state_radar_default_select);
          localazs.tvP = 2;
        }
      });
      return paramView;
      paramViewGroup = (SDKOAuthOtherUI.a.a)paramView.getTag();
      break;
      label163:
      if (localazs.tvP == 3) {
        paramViewGroup.fYe.setImageResource(R.k.login_auth_state_radar_must_select);
      } else {
        paramViewGroup.fYe.setImageResource(R.k.login_auth_state_radar_default_select);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.a
 * JD-Core Version:    0.7.0.1
 */