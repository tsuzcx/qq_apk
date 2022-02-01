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
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class e
{
  public TextView ASX;
  public l ECx;
  public n.d LfS;
  public n.e LfT;
  public View LxA;
  public ArrayList<Integer> LxB;
  public a LxC;
  public b LxD;
  public ListView Lxz;
  public Button gXc;
  public Button gZv;
  public View kFh;
  public int lEa;
  private BottomSheetBehavior lEb;
  public Context mContext;
  public android.support.design.widget.a uNn;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(159571);
    this.mContext = paramContext;
    this.ECx = new l(this.mContext);
    this.uNn = new android.support.design.widget.a(this.mContext);
    this.kFh = View.inflate(this.mContext, 2131494966, null);
    this.Lxz = ((ListView)this.kFh.findViewById(2131302564));
    this.gXc = ((Button)this.kFh.findViewById(2131302999));
    this.gZv = ((Button)this.kFh.findViewById(2131297690));
    this.LxA = this.kFh.findViewById(2131300720);
    this.ASX = ((TextView)this.kFh.findViewById(2131300731));
    this.uNn.setContentView(this.kFh);
    this.lEa = (aq.ay(this.mContext, 2131165203) + aq.ay(this.mContext, 2131165204));
    this.lEb = BottomSheetBehavior.l((View)this.kFh.getParent());
    if (this.lEb != null)
    {
      this.lEb.J(this.lEa);
      this.lEb.nZ = false;
    }
    this.uNn.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        e.this.uNn = null;
      }
    });
    AppMethodBeat.o(159571);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159572);
    if (this.uNn != null) {
      this.uNn.dismiss();
    }
    AppMethodBeat.o(159572);
  }
  
  public final class a
    extends BaseAdapter
  {
    public HashMap<Integer, Boolean> LxF;
    private ArrayList<Integer> LxG;
    private Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159565);
      this.LxF = new HashMap();
      this.context = paramContext;
      AppMethodBeat.o(159565);
    }
    
    public final void fRi()
    {
      AppMethodBeat.i(159569);
      if (e.this.LxB == null)
      {
        AppMethodBeat.o(159569);
        return;
      }
      int i = 0;
      if (i < getCount())
      {
        if (e.this.LxB.contains(Integer.valueOf(i))) {
          this.LxF.put(Integer.valueOf(i), Boolean.TRUE);
        }
        for (;;)
        {
          i += 1;
          break;
          this.LxF.put(Integer.valueOf(i), Boolean.FALSE);
        }
      }
      AppMethodBeat.o(159569);
    }
    
    public final ArrayList<Integer> fRj()
    {
      AppMethodBeat.i(159570);
      if (this.LxF == null)
      {
        AppMethodBeat.o(159570);
        return null;
      }
      this.LxG = new ArrayList();
      int i = 0;
      while (i < getCount())
      {
        if (((Boolean)this.LxF.get(Integer.valueOf(i))).booleanValue()) {
          this.LxG.add(Integer.valueOf(i));
        }
        i += 1;
      }
      ArrayList localArrayList = this.LxG;
      AppMethodBeat.o(159570);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159566);
      int i = e.this.ECx.size();
      AppMethodBeat.o(159566);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159567);
      Object localObject = e.this.ECx.JGM.get(paramInt);
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
      final m localm = (m)e.this.ECx.JGM.get(paramInt);
      paramViewGroup = LayoutInflater.from(this.context);
      View localView;
      if (paramView == null)
      {
        localView = paramViewGroup.inflate(2131494965, null);
        paramView = new a();
        paramView.LtE = ((LinearLayout)localView.findViewById(2131301167));
        paramView.iFD = ((CheckBox)localView.findViewById(2131301143));
        paramView.iYj = ((TextView)localView.findViewById(2131301198));
        paramView.iFO = ((TextView)localView.findViewById(2131301149));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.iYj.setText(localm.getTitle());
        paramViewGroup.LtE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159564);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (e.this.LfT != null) {
              e.this.LfT.onMMMenuItemSelected(e.this.ECx.getItem(paramInt), paramInt);
            }
            if (localm.lXh)
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
              e.a.this.LxF = e.a.a(e.a.this);
              e.a.this.notifyDataSetChanged();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159564);
              return;
              e.a.a(e.a.this).put(Integer.valueOf(paramInt), Boolean.TRUE);
            }
          }
        });
        if (paramViewGroup.iFO != null)
        {
          if ((localm.tMa == null) || (localm.tMa.length() <= 0)) {
            break label304;
          }
          paramViewGroup.iFO.setVisibility(0);
          paramViewGroup.iFO.setText(localm.tMa);
        }
        label198:
        if (!localm.lXh) {
          break label316;
        }
        paramViewGroup.iYj.setTextColor(e.this.mContext.getResources().getColor(2131100031));
        paramViewGroup.iFO.setTextColor(e.this.mContext.getResources().getColor(2131100031));
        paramViewGroup.iFD.setChecked(((Boolean)this.LxF.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.iFD.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(159568);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label304:
        paramViewGroup.iFO.setVisibility(8);
        break label198;
        label316:
        paramViewGroup.iYj.setTextColor(e.this.mContext.getResources().getColor(2131100030));
        paramViewGroup.iFO.setTextColor(e.this.mContext.getResources().getColor(2131100032));
        paramViewGroup.iFD.setChecked(((Boolean)this.LxF.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.iFD.setEnabled(true);
      }
    }
    
    final class a
    {
      LinearLayout LtE;
      CheckBox iFD;
      TextView iFO;
      TextView iYj;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void qt(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */