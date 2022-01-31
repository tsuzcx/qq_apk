package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.at.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private Context context;
  private String feq;
  private List<b.a> list;
  private List<b.a> luW = new ArrayList();
  int[] luY;
  boolean luZ = false;
  
  public c(Context paramContext, List<b.a> paramList)
  {
    this.context = paramContext;
    this.list = paramList;
    bcW();
    bcX();
  }
  
  private void bcW()
  {
    int i = 0;
    int j = this.list.size();
    while (i < j)
    {
      this.luW.add(this.list.get(i));
      i += 1;
    }
  }
  
  private void bcX()
  {
    this.luY = new int[this.list.size()];
    int j = this.list.size();
    int i = 0;
    while (i < j)
    {
      this.luY[i] = ((b.a)this.list.get(i)).esi;
      i += 1;
    }
  }
  
  private static String sL(int paramInt)
  {
    if (x.cqH()) {
      return Integer.toString(paramInt) + "劃";
    }
    return String.valueOf((char)paramInt);
  }
  
  public final int getCount()
  {
    return this.list.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    b.a locala = (b.a)getItem(paramInt);
    label87:
    int i;
    if (paramView == null) {
      if (!x.cqH())
      {
        paramView = View.inflate(this.context, R.i.country_code_item, null);
        paramViewGroup = new a();
        paramViewGroup.lvb = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
        paramViewGroup.drB = ((TextView)paramView.findViewById(R.h.contactitem_nick));
        paramViewGroup.lvc = ((TextView)paramView.findViewById(R.h.contactitem_signature));
        paramView.setTag(paramViewGroup);
        if (paramInt <= 0) {
          break label196;
        }
        i = this.luY[(paramInt - 1)];
        label101:
        if (paramInt != 0) {
          break label202;
        }
        paramViewGroup.lvb.setVisibility(0);
        paramViewGroup.lvb.setText(sL(this.luY[paramInt]));
      }
    }
    for (;;)
    {
      paramViewGroup.drB.setText(locala.esg);
      paramViewGroup.lvc.setText(locala.esf);
      if (!this.luZ) {
        break label256;
      }
      paramViewGroup.lvc.setVisibility(0);
      return paramView;
      paramView = View.inflate(this.context, R.i.country_code_item_big5, null);
      break;
      paramViewGroup = (a)paramView.getTag();
      break label87;
      label196:
      i = -1;
      break label101;
      label202:
      if ((paramInt > 0) && (this.luY[paramInt] != i))
      {
        paramViewGroup.lvb.setVisibility(0);
        paramViewGroup.lvb.setText(sL(this.luY[paramInt]));
      }
      else
      {
        paramViewGroup.lvb.setVisibility(8);
      }
    }
    label256:
    paramViewGroup.lvc.setVisibility(4);
    return paramView;
  }
  
  public final void pA(String paramString)
  {
    if (paramString != null)
    {
      this.feq = paramString.trim();
      this.list.clear();
      int j = this.luW.size();
      int i = 0;
      while (i < j)
      {
        if ((((b.a)this.luW.get(i)).esg.toUpperCase().contains(this.feq.toUpperCase())) || (((b.a)this.luW.get(i)).esh.toUpperCase().contains(this.feq.toUpperCase())) || (((b.a)this.luW.get(i)).esf.contains(this.feq))) {
          this.list.add(this.luW.get(i));
        }
        i += 1;
      }
      bcX();
      super.notifyDataSetChanged();
    }
  }
  
  static final class a
  {
    TextView drB;
    TextView lvb;
    TextView lvc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */