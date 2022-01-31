package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ci.a.c;
import com.tencent.mm.ci.a.d;
import com.tencent.mm.ci.a.f;
import com.tencent.mm.ci.a.g;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
{
  private BottomSheetBehavior fK;
  public Button fbO;
  public Button hPe;
  public View jdj;
  public Context mContext;
  public n.c phH;
  public n.d phI;
  public l phJ;
  public c vAB;
  public int vAC;
  public ListView woA;
  public View woB;
  public TextView woC;
  public ArrayList<Integer> woD;
  public a woE;
  public d.b woF;
  
  public d(Context paramContext)
  {
    this.mContext = paramContext;
    this.phJ = new l(this.mContext);
    this.vAB = new c(this.mContext);
    this.jdj = View.inflate(this.mContext, a.g.multi_picker_panel, null);
    this.woA = ((ListView)this.jdj.findViewById(a.f.multi_listview));
    this.fbO = ((Button)this.jdj.findViewById(a.f.ok_btn));
    this.hPe = ((Button)this.jdj.findViewById(a.f.cancel_btn));
    this.woB = this.jdj.findViewById(a.f.header_ll);
    this.woC = ((TextView)this.jdj.findViewById(a.f.header_title));
    this.vAB.setContentView(this.jdj);
    this.vAC = (ap.ab(this.mContext, a.d.BottomSheetListMaxHeight) + ap.ab(this.mContext, a.d.BottomSheetTextTitleHeight));
    this.fK = BottomSheetBehavior.i((View)this.jdj.getParent());
    if (this.fK != null)
    {
      this.fK.u(this.vAC);
      this.fK.fq = false;
    }
    this.vAB.setOnDismissListener(new d.1(this));
  }
  
  public final void hide()
  {
    if (this.vAB != null) {
      this.vAB.dismiss();
    }
  }
  
  public final class a
    extends BaseAdapter
  {
    private Context context;
    public HashMap<Integer, Boolean> woH = new HashMap();
    private ArrayList<Integer> woI;
    
    public a(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public final void cKl()
    {
      if (d.this.woD == null) {
        return;
      }
      int i = 0;
      label13:
      if (i < getCount())
      {
        if (!d.this.woD.contains(Integer.valueOf(i))) {
          break label61;
        }
        this.woH.put(Integer.valueOf(i), Boolean.valueOf(true));
      }
      for (;;)
      {
        i += 1;
        break label13;
        break;
        label61:
        this.woH.put(Integer.valueOf(i), Boolean.valueOf(false));
      }
    }
    
    public final ArrayList<Integer> cKm()
    {
      if (this.woH == null) {
        return null;
      }
      this.woI = new ArrayList();
      int i = 0;
      while (i < getCount())
      {
        if (((Boolean)this.woH.get(Integer.valueOf(i))).booleanValue()) {
          this.woI.add(Integer.valueOf(i));
        }
        i += 1;
      }
      return this.woI;
    }
    
    public final int getCount()
    {
      return d.this.phJ.size();
    }
    
    public final Object getItem(int paramInt)
    {
      return d.this.phJ.uWD.get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      m localm = (m)d.this.phJ.uWD.get(paramInt);
      paramViewGroup = LayoutInflater.from(this.context);
      View localView;
      if (paramView == null)
      {
        localView = paramViewGroup.inflate(a.g.multi_picker_item, null);
        paramView = new d.a.a(this);
        paramView.wnt = ((LinearLayout)localView.findViewById(a.f.item_ll));
        paramView.khV = ((CheckBox)localView.findViewById(a.f.item_check));
        paramView.eXO = ((TextView)localView.findViewById(a.f.item_title));
        paramView.eXP = ((TextView)localView.findViewById(a.f.item_desc));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.eXO.setText(localm.getTitle());
        paramViewGroup.wnt.setOnClickListener(new d.a.1(this, paramInt, localm));
        if (paramViewGroup.eXP != null)
        {
          if ((localm.kDf == null) || (localm.kDf.length() <= 0)) {
            break label301;
          }
          paramViewGroup.eXP.setVisibility(0);
          paramViewGroup.eXP.setText(localm.kDf);
        }
      }
      for (;;)
      {
        if (!localm.tMS) {
          break label313;
        }
        paramViewGroup.eXO.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_color_disable));
        paramViewGroup.eXP.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_color_disable));
        paramViewGroup.khV.setChecked(((Boolean)this.woH.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.khV.setEnabled(false);
        return localView;
        paramViewGroup = (d.a.a)paramView.getTag();
        localView = paramView;
        break;
        label301:
        paramViewGroup.eXP.setVisibility(8);
      }
      label313:
      paramViewGroup.eXO.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_color));
      paramViewGroup.eXP.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_desc_color));
      paramViewGroup.khV.setChecked(((Boolean)this.woH.get(Integer.valueOf(paramInt))).booleanValue());
      paramViewGroup.khV.setEnabled(true);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */