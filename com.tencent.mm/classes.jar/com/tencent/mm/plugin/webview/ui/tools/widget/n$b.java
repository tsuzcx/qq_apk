package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.protocal.c.bna;
import java.util.LinkedList;

final class n$b
  extends BaseAdapter
{
  private LinkedList<bna> fYa;
  
  public n$b(LinkedList<bna> paramLinkedList)
  {
    Object localObject;
    this.fYa = localObject;
  }
  
  private bna kN(int paramInt)
  {
    return (bna)this.fYa.get(paramInt);
  }
  
  public final int getCount()
  {
    if (this.fYa == null) {
      return 0;
    }
    return this.fYa.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.fYa == null) || (this.fYa.size() <= 0)) {
      return null;
    }
    bna localbna = kN(paramInt);
    Object localObject;
    if (paramView == null)
    {
      paramView = new n.b.a(this, (byte)0);
      localObject = View.inflate(paramViewGroup.getContext(), R.i.authorize_scope_item, null);
      paramView.fYe = ((ImageView)((View)localObject).findViewById(R.h.app_auth_state));
      paramView.fYf = ((TextView)((View)localObject).findViewById(R.h.app_auth_desc));
      ((View)localObject).setTag(paramView);
      paramViewGroup = paramView;
      paramView = (View)localObject;
      if (localbna.tGf != 1) {
        break label163;
      }
      paramViewGroup.fYe.setImageResource(R.k.login_auth_state_not_selected);
    }
    for (;;)
    {
      paramViewGroup.fYf.setText(localbna.kRN);
      localObject = paramViewGroup.fYe;
      paramViewGroup.fYe.setOnClickListener(new n.b.1(this, localbna, (ImageView)localObject));
      return paramView;
      paramViewGroup = (n.b.a)paramView.getTag();
      break;
      label163:
      if (localbna.tGf == 3) {
        paramViewGroup.fYe.setImageResource(R.k.login_auth_state_must_select);
      } else {
        paramViewGroup.fYe.setImageResource(R.k.login_auth_state_default_select);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.b
 * JD-Core Version:    0.7.0.1
 */