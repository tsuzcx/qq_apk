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
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d
{
  public u.i GAC;
  public com.google.android.material.bottomsheet.a Jjv;
  public TextView RVm;
  public u.g Vtg;
  public s Vtk;
  public ListView agko;
  public View agkp;
  public ArrayList<Integer> agkq;
  public a agkr;
  public b agks;
  public Context mContext;
  public Button nhC;
  public Button njI;
  public View rootView;
  public int sRu;
  private BottomSheetBehavior sRv;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(159571);
    this.mContext = paramContext;
    this.Vtk = new s(this.mContext);
    this.Jjv = new com.google.android.material.bottomsheet.a(this.mContext);
    this.rootView = View.inflate(this.mContext, a.g.mm_multi_picker_panel, null);
    this.agko = ((ListView)this.rootView.findViewById(a.f.multi_listview));
    this.nhC = ((Button)this.rootView.findViewById(a.f.ok_btn));
    this.njI = ((Button)this.rootView.findViewById(a.f.cancel_btn));
    this.agkp = this.rootView.findViewById(a.f.header_ll);
    this.RVm = ((TextView)this.rootView.findViewById(a.f.header_title));
    this.Jjv.setContentView(this.rootView);
    this.sRu = (bd.bs(this.mContext, a.d.BottomSheetListMaxHeight) + bd.bs(this.mContext, a.d.BottomSheetTextTitleHeight));
    this.sRv = BottomSheetBehavior.cC((View)this.rootView.getParent());
    if (this.sRv != null)
    {
      this.sRv.setPeekHeight(this.sRu);
      this.sRv.dqC = false;
    }
    this.Jjv.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        d.this.Jjv = null;
      }
    });
    AppMethodBeat.o(159571);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159572);
    if (this.Jjv != null) {
      this.Jjv.dismiss();
    }
    AppMethodBeat.o(159572);
  }
  
  public final class a
    extends BaseAdapter
  {
    public HashMap<Integer, Boolean> agku;
    private ArrayList<Integer> agkv;
    private Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159565);
      this.agku = new HashMap();
      this.context = paramContext;
      AppMethodBeat.o(159565);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159566);
      int i = d.this.Vtk.size();
      AppMethodBeat.o(159566);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159567);
      Object localObject = d.this.Vtk.adRW.get(paramInt);
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
      final t localt = (t)d.this.Vtk.adRW.get(paramInt);
      paramViewGroup = LayoutInflater.from(this.context);
      View localView;
      if (paramView == null)
      {
        localView = paramViewGroup.inflate(a.g.mm_multi_picker_item, null);
        paramView = new a();
        paramView.Vtt = ((LinearLayout)localView.findViewById(a.f.item_ll));
        paramView.checkBox = ((CheckBox)localView.findViewById(a.f.item_check));
        paramView.pJJ = ((TextView)localView.findViewById(a.f.item_title));
        paramView.plr = ((TextView)localView.findViewById(a.f.item_desc));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.pJJ.setText(localt.getTitle());
        paramViewGroup.Vtt.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159564);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (d.this.GAC != null) {
              d.this.GAC.onMMMenuItemSelected(d.this.Vtk.getItem(paramInt), paramInt);
            }
            if (localt.disable)
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
              d.a.this.agku = d.a.a(d.a.this);
              d.a.this.notifyDataSetChanged();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159564);
              return;
              d.a.a(d.a.this).put(Integer.valueOf(paramInt), Boolean.TRUE);
            }
          }
        });
        if (paramViewGroup.plr != null)
        {
          if ((localt.BdX == null) || (localt.BdX.length() <= 0)) {
            break label311;
          }
          paramViewGroup.plr.setVisibility(0);
          paramViewGroup.plr.setText(localt.BdX);
        }
        label203:
        if (!localt.disable) {
          break label323;
        }
        paramViewGroup.pJJ.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_color_disable));
        paramViewGroup.plr.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_color_disable));
        paramViewGroup.checkBox.setChecked(((Boolean)this.agku.get(Integer.valueOf(paramInt))).booleanValue());
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
        paramViewGroup.plr.setVisibility(8);
        break label203;
        label323:
        paramViewGroup.pJJ.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_color));
        paramViewGroup.plr.setTextColor(d.this.mContext.getResources().getColor(a.c.bottom_sheet_text_desc_color));
        paramViewGroup.checkBox.setChecked(((Boolean)this.agku.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.checkBox.setEnabled(true);
      }
    }
    
    public final void jIA()
    {
      AppMethodBeat.i(159569);
      if (d.this.agkq == null)
      {
        AppMethodBeat.o(159569);
        return;
      }
      int i = 0;
      if (i < getCount())
      {
        if (d.this.agkq.contains(Integer.valueOf(i))) {
          this.agku.put(Integer.valueOf(i), Boolean.TRUE);
        }
        for (;;)
        {
          i += 1;
          break;
          this.agku.put(Integer.valueOf(i), Boolean.FALSE);
        }
      }
      AppMethodBeat.o(159569);
    }
    
    public final ArrayList<Integer> jIB()
    {
      AppMethodBeat.i(159570);
      if (this.agku == null)
      {
        AppMethodBeat.o(159570);
        return null;
      }
      this.agkv = new ArrayList();
      int i = 0;
      while (i < getCount())
      {
        if (((Boolean)this.agku.get(Integer.valueOf(i))).booleanValue()) {
          this.agkv.add(Integer.valueOf(i));
        }
        i += 1;
      }
      ArrayList localArrayList = this.agkv;
      AppMethodBeat.o(159570);
      return localArrayList;
    }
    
    final class a
    {
      LinearLayout Vtt;
      CheckBox checkBox;
      TextView pJJ;
      TextView plr;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void BH(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.d
 * JD-Core Version:    0.7.0.1
 */