package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
{
  public TextView FdD;
  public o.f HLX;
  public o.g HLY;
  public m HMc;
  public ListView QTo;
  public View QTp;
  public ArrayList<Integer> QTq;
  public a QTr;
  public b QTs;
  public Button hPX;
  public Button hSq;
  public View lJI;
  public Context mContext;
  public int mLJ;
  private BottomSheetBehavior mLK;
  public android.support.design.widget.a yfL;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(159571);
    this.mContext = paramContext;
    this.HMc = new m(this.mContext);
    this.yfL = new android.support.design.widget.a(this.mContext);
    this.lJI = View.inflate(this.mContext, 2131495709, null);
    this.QTo = ((ListView)this.lJI.findViewById(2131304996));
    this.hPX = ((Button)this.lJI.findViewById(2131305592));
    this.hSq = ((Button)this.lJI.findViewById(2131297963));
    this.QTp = this.lJI.findViewById(2131302295);
    this.FdD = ((TextView)this.lJI.findViewById(2131302312));
    this.yfL.setContentView(this.lJI);
    this.mLJ = (at.aH(this.mContext, 2131165206) + at.aH(this.mContext, 2131165207));
    this.mLK = BottomSheetBehavior.l((View)this.lJI.getParent());
    if (this.mLK != null)
    {
      this.mLK.J(this.mLJ);
      this.mLK.ob = false;
    }
    this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        e.this.yfL = null;
      }
    });
    AppMethodBeat.o(159571);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159572);
    if (this.yfL != null) {
      this.yfL.dismiss();
    }
    AppMethodBeat.o(159572);
  }
  
  public final class a
    extends BaseAdapter
  {
    public HashMap<Integer, Boolean> QTu;
    private ArrayList<Integer> QTv;
    private Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159565);
      this.QTu = new HashMap();
      this.context = paramContext;
      AppMethodBeat.o(159565);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159566);
      int i = e.this.HMc.size();
      AppMethodBeat.o(159566);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159567);
      Object localObject = e.this.HMc.ORD.get(paramInt);
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
      final n localn = (n)e.this.HMc.ORD.get(paramInt);
      paramViewGroup = LayoutInflater.from(this.context);
      View localView;
      if (paramView == null)
      {
        localView = paramViewGroup.inflate(2131495708, null);
        paramView = new a();
        paramView.HMm = ((LinearLayout)localView.findViewById(2131302830));
        paramView.checkBox = ((CheckBox)localView.findViewById(2131302797));
        paramView.jVO = ((TextView)localView.findViewById(2131302870));
        paramView.jBR = ((TextView)localView.findViewById(2131302804));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.jVO.setText(localn.getTitle());
        paramViewGroup.HMm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159564);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (e.this.HLY != null) {
              e.this.HLY.onMMMenuItemSelected(e.this.HMc.getItem(paramInt), paramInt);
            }
            if (localn.neT)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159564);
              return;
            }
            if (((Boolean)e.a.a(e.a.this).get(Integer.valueOf(paramInt))).booleanValue()) {
              e.a.a(e.a.this).put(Integer.valueOf(paramInt), Boolean.FALSE);
            }
            for (;;)
            {
              e.a.this.QTu = e.a.a(e.a.this);
              e.a.this.notifyDataSetChanged();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159564);
              return;
              e.a.a(e.a.this).put(Integer.valueOf(paramInt), Boolean.TRUE);
            }
          }
        });
        if (paramViewGroup.jBR != null)
        {
          if ((localn.xdb == null) || (localn.xdb.length() <= 0)) {
            break label304;
          }
          paramViewGroup.jBR.setVisibility(0);
          paramViewGroup.jBR.setText(localn.xdb);
        }
        label198:
        if (!localn.neT) {
          break label316;
        }
        paramViewGroup.jVO.setTextColor(e.this.mContext.getResources().getColor(2131100057));
        paramViewGroup.jBR.setTextColor(e.this.mContext.getResources().getColor(2131100057));
        paramViewGroup.checkBox.setChecked(((Boolean)this.QTu.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.checkBox.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(159568);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label304:
        paramViewGroup.jBR.setVisibility(8);
        break label198;
        label316:
        paramViewGroup.jVO.setTextColor(e.this.mContext.getResources().getColor(2131100056));
        paramViewGroup.jBR.setTextColor(e.this.mContext.getResources().getColor(2131100058));
        paramViewGroup.checkBox.setChecked(((Boolean)this.QTu.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.checkBox.setEnabled(true);
      }
    }
    
    public final void hck()
    {
      AppMethodBeat.i(159569);
      if (e.this.QTq == null)
      {
        AppMethodBeat.o(159569);
        return;
      }
      int i = 0;
      if (i < getCount())
      {
        if (e.this.QTq.contains(Integer.valueOf(i))) {
          this.QTu.put(Integer.valueOf(i), Boolean.TRUE);
        }
        for (;;)
        {
          i += 1;
          break;
          this.QTu.put(Integer.valueOf(i), Boolean.FALSE);
        }
      }
      AppMethodBeat.o(159569);
    }
    
    public final ArrayList<Integer> hcl()
    {
      AppMethodBeat.i(159570);
      if (this.QTu == null)
      {
        AppMethodBeat.o(159570);
        return null;
      }
      this.QTv = new ArrayList();
      int i = 0;
      while (i < getCount())
      {
        if (((Boolean)this.QTu.get(Integer.valueOf(i))).booleanValue()) {
          this.QTv.add(Integer.valueOf(i));
        }
        i += 1;
      }
      ArrayList localArrayList = this.QTv;
      AppMethodBeat.o(159570);
      return localArrayList;
    }
    
    final class a
    {
      LinearLayout HMm;
      CheckBox checkBox;
      TextView jBR;
      TextView jVO;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void tK(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */