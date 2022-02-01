package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.a;
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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
{
  public l BoA;
  public ListView HJe;
  public View HJf;
  public ArrayList<Integer> HJg;
  public a HJh;
  public b HJi;
  public n.c HrX;
  public n.d HrY;
  public Button hJg;
  public Button hJh;
  public View jGG;
  public int kBk;
  private BottomSheetBehavior kBl;
  public Context mContext;
  public a sri;
  public TextView xWz;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(159571);
    this.mContext = paramContext;
    this.BoA = new l(this.mContext);
    this.sri = new a(this.mContext);
    this.jGG = View.inflate(this.mContext, 2131494966, null);
    this.HJe = ((ListView)this.jGG.findViewById(2131302564));
    this.hJh = ((Button)this.jGG.findViewById(2131302999));
    this.hJg = ((Button)this.jGG.findViewById(2131297690));
    this.HJf = this.jGG.findViewById(2131300720);
    this.xWz = ((TextView)this.jGG.findViewById(2131300731));
    this.sri.setContentView(this.jGG);
    this.kBk = (ao.ap(this.mContext, 2131165203) + ao.ap(this.mContext, 2131165204));
    this.kBl = BottomSheetBehavior.l((View)this.jGG.getParent());
    if (this.kBl != null)
    {
      this.kBl.J(this.kBk);
      this.kBl.lh = false;
    }
    this.sri.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        e.this.sri = null;
      }
    });
    AppMethodBeat.o(159571);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159572);
    if (this.sri != null) {
      this.sri.dismiss();
    }
    AppMethodBeat.o(159572);
  }
  
  public final class a
    extends BaseAdapter
  {
    public HashMap<Integer, Boolean> HJk;
    private ArrayList<Integer> HJl;
    private Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159565);
      this.HJk = new HashMap();
      this.context = paramContext;
      AppMethodBeat.o(159565);
    }
    
    public final void fga()
    {
      AppMethodBeat.i(159569);
      if (e.this.HJg == null)
      {
        AppMethodBeat.o(159569);
        return;
      }
      int i = 0;
      if (i < getCount())
      {
        if (e.this.HJg.contains(Integer.valueOf(i))) {
          this.HJk.put(Integer.valueOf(i), Boolean.TRUE);
        }
        for (;;)
        {
          i += 1;
          break;
          this.HJk.put(Integer.valueOf(i), Boolean.FALSE);
        }
      }
      AppMethodBeat.o(159569);
    }
    
    public final ArrayList<Integer> fgb()
    {
      AppMethodBeat.i(159570);
      if (this.HJk == null)
      {
        AppMethodBeat.o(159570);
        return null;
      }
      this.HJl = new ArrayList();
      int i = 0;
      while (i < getCount())
      {
        if (((Boolean)this.HJk.get(Integer.valueOf(i))).booleanValue()) {
          this.HJl.add(Integer.valueOf(i));
        }
        i += 1;
      }
      ArrayList localArrayList = this.HJl;
      AppMethodBeat.o(159570);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159566);
      int i = e.this.BoA.size();
      AppMethodBeat.o(159566);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159567);
      Object localObject = e.this.BoA.FYt.get(paramInt);
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
      final m localm = (m)e.this.BoA.FYt.get(paramInt);
      paramViewGroup = LayoutInflater.from(this.context);
      View localView;
      if (paramView == null)
      {
        localView = paramViewGroup.inflate(2131494965, null);
        paramView = new a();
        paramView.HFv = ((LinearLayout)localView.findViewById(2131301167));
        paramView.hIS = ((CheckBox)localView.findViewById(2131301143));
        paramView.ica = ((TextView)localView.findViewById(2131301198));
        paramView.hJe = ((TextView)localView.findViewById(2131301149));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.ica.setText(localm.getTitle());
        paramViewGroup.HFv.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159564);
            if (e.this.HrY != null) {
              e.this.HrY.onMMMenuItemSelected(e.this.BoA.getItem(paramInt), paramInt);
            }
            if (localm.kRX)
            {
              AppMethodBeat.o(159564);
              return;
            }
            if (((Boolean)e.a.a(e.a.this).get(Integer.valueOf(paramInt))).booleanValue()) {
              e.a.a(e.a.this).put(Integer.valueOf(paramInt), Boolean.FALSE);
            }
            for (;;)
            {
              e.a.this.HJk = e.a.a(e.a.this);
              e.a.this.notifyDataSetChanged();
              AppMethodBeat.o(159564);
              return;
              e.a.a(e.a.this).put(Integer.valueOf(paramInt), Boolean.TRUE);
            }
          }
        });
        if (paramViewGroup.hJe != null)
        {
          if ((localm.rvA == null) || (localm.rvA.length() <= 0)) {
            break label304;
          }
          paramViewGroup.hJe.setVisibility(0);
          paramViewGroup.hJe.setText(localm.rvA);
        }
        label198:
        if (!localm.kRX) {
          break label316;
        }
        paramViewGroup.ica.setTextColor(e.this.mContext.getResources().getColor(2131100031));
        paramViewGroup.hJe.setTextColor(e.this.mContext.getResources().getColor(2131100031));
        paramViewGroup.hIS.setChecked(((Boolean)this.HJk.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.hIS.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(159568);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label304:
        paramViewGroup.hJe.setVisibility(8);
        break label198;
        label316:
        paramViewGroup.ica.setTextColor(e.this.mContext.getResources().getColor(2131100030));
        paramViewGroup.hJe.setTextColor(e.this.mContext.getResources().getColor(2131100032));
        paramViewGroup.hIS.setChecked(((Boolean)this.HJk.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.hIS.setEnabled(true);
      }
    }
    
    final class a
    {
      LinearLayout HFv;
      CheckBox hIS;
      TextView hJe;
      TextView ica;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void oP(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */