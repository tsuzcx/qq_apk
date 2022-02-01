package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
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
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
{
  public com.google.android.material.bottomsheet.a DpN;
  public TextView Lsj;
  public q.f ODT;
  public q.g ODU;
  public o ODY;
  public ListView YrZ;
  public View Ysa;
  public ArrayList<Integer> Ysb;
  public a Ysc;
  public b Ysd;
  public Button kEt;
  public Button kGN;
  public Context mContext;
  public View oFW;
  public int pMB;
  private BottomSheetBehavior pMC;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(159571);
    this.mContext = paramContext;
    this.ODY = new o(this.mContext);
    this.DpN = new com.google.android.material.bottomsheet.a(this.mContext);
    this.oFW = View.inflate(this.mContext, a.g.mm_multi_picker_panel, null);
    this.YrZ = ((ListView)this.oFW.findViewById(a.f.multi_listview));
    this.kEt = ((Button)this.oFW.findViewById(a.f.ok_btn));
    this.kGN = ((Button)this.oFW.findViewById(a.f.cancel_btn));
    this.Ysa = this.oFW.findViewById(a.f.header_ll);
    this.Lsj = ((TextView)this.oFW.findViewById(a.f.header_title));
    this.DpN.setContentView(this.oFW);
    this.pMB = (aw.aZ(this.mContext, a.d.BottomSheetListMaxHeight) + aw.aZ(this.mContext, a.d.BottomSheetTextTitleHeight));
    this.pMC = BottomSheetBehavior.cg((View)this.oFW.getParent());
    if (this.pMC != null)
    {
      this.pMC.D(this.pMB);
      this.pMC.bxz = false;
    }
    this.DpN.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        d.this.DpN = null;
      }
    });
    AppMethodBeat.o(159571);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159572);
    if (this.DpN != null) {
      this.DpN.dismiss();
    }
    AppMethodBeat.o(159572);
  }
  
  public final class a
    extends BaseAdapter
  {
    public HashMap<Integer, Boolean> Ysf;
    private ArrayList<Integer> Ysg;
    private Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159565);
      this.Ysf = new HashMap();
      this.context = paramContext;
      AppMethodBeat.o(159565);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159566);
      int i = d.this.ODY.size();
      AppMethodBeat.o(159566);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159567);
      Object localObject = d.this.ODY.WkP.get(paramInt);
      AppMethodBeat.o(159567);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(159568);
      final p localp = (p)d.this.ODY.WkP.get(paramInt);
      paramViewGroup = LayoutInflater.from(this.context);
      View localView;
      if (paramView == null)
      {
        localView = paramViewGroup.inflate(a.g.mm_multi_picker_item, null);
        paramView = new a();
        paramView.OEi = ((LinearLayout)localView.findViewById(a.f.item_ll));
        paramView.checkBox = ((CheckBox)localView.findViewById(a.f.item_check));
        paramView.mNb = ((TextView)localView.findViewById(a.f.item_title));
        paramView.mrM = ((TextView)localView.findViewById(a.f.item_desc));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.mNb.setText(localp.getTitle());
        paramViewGroup.OEi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159564);
            b localb = new b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (d.this.ODU != null) {
              d.this.ODU.onMMMenuItemSelected(d.this.ODY.getItem(paramInt), paramInt);
            }
            if (localp.qfB)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159564);
              return;
            }
            if (((Boolean)d.a.a(d.a.this).get(Integer.valueOf(paramInt))).booleanValue()) {
              d.a.a(d.a.this).put(Integer.valueOf(paramInt), Boolean.FALSE);
            }
            for (;;)
            {
              d.a.this.Ysf = d.a.a(d.a.this);
              d.a.this.notifyDataSetChanged();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159564);
              return;
              d.a.a(d.a.this).put(Integer.valueOf(paramInt), Boolean.TRUE);
            }
          }
        });
        if (paramViewGroup.mrM != null)
        {
          if ((localp.BOZ == null) || (localp.BOZ.length() <= 0)) {
            break label311;
          }
          paramViewGroup.mrM.setVisibility(0);
          paramViewGroup.mrM.setText(localp.BOZ);
        }
        label203:
        if (!localp.qfB) {
          break label323;
        }
        paramViewGroup.mNb.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_color_disable));
        paramViewGroup.mrM.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_color_disable));
        paramViewGroup.checkBox.setChecked(((Boolean)this.Ysf.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.checkBox.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(159568);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label311:
        paramViewGroup.mrM.setVisibility(8);
        break label203;
        label323:
        paramViewGroup.mNb.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_color));
        paramViewGroup.mrM.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_desc_color));
        paramViewGroup.checkBox.setChecked(((Boolean)this.Ysf.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.checkBox.setEnabled(true);
      }
    }
    
    public final void idr()
    {
      AppMethodBeat.i(159569);
      if (d.this.Ysb == null)
      {
        AppMethodBeat.o(159569);
        return;
      }
      int i = 0;
      if (i < getCount())
      {
        if (d.this.Ysb.contains(Integer.valueOf(i))) {
          this.Ysf.put(Integer.valueOf(i), Boolean.TRUE);
        }
        for (;;)
        {
          i += 1;
          break;
          this.Ysf.put(Integer.valueOf(i), Boolean.FALSE);
        }
      }
      AppMethodBeat.o(159569);
    }
    
    public final ArrayList<Integer> ids()
    {
      AppMethodBeat.i(159570);
      if (this.Ysf == null)
      {
        AppMethodBeat.o(159570);
        return null;
      }
      this.Ysg = new ArrayList();
      int i = 0;
      while (i < getCount())
      {
        if (((Boolean)this.Ysf.get(Integer.valueOf(i))).booleanValue()) {
          this.Ysg.add(Integer.valueOf(i));
        }
        i += 1;
      }
      ArrayList localArrayList = this.Ysg;
      AppMethodBeat.o(159570);
      return localArrayList;
    }
    
    final class a
    {
      LinearLayout OEi;
      CheckBox checkBox;
      TextView mNb;
      TextView mrM;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void xg(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */