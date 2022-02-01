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
  public TextView ABw;
  public l Ekt;
  public n.d KJy;
  public n.e KJz;
  public ListView LaY;
  public View LaZ;
  public ArrayList<Integer> Lba;
  public a Lbb;
  public b Lbc;
  public Button gUt;
  public Button gWI;
  public View kBS;
  public int lzC;
  private BottomSheetBehavior lzD;
  public Context mContext;
  public android.support.design.widget.a uBI;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(159571);
    this.mContext = paramContext;
    this.Ekt = new l(this.mContext);
    this.uBI = new android.support.design.widget.a(this.mContext);
    this.kBS = View.inflate(this.mContext, 2131494966, null);
    this.LaY = ((ListView)this.kBS.findViewById(2131302564));
    this.gUt = ((Button)this.kBS.findViewById(2131302999));
    this.gWI = ((Button)this.kBS.findViewById(2131297690));
    this.LaZ = this.kBS.findViewById(2131300720);
    this.ABw = ((TextView)this.kBS.findViewById(2131300731));
    this.uBI.setContentView(this.kBS);
    this.lzC = (aq.ay(this.mContext, 2131165203) + aq.ay(this.mContext, 2131165204));
    this.lzD = BottomSheetBehavior.l((View)this.kBS.getParent());
    if (this.lzD != null)
    {
      this.lzD.J(this.lzC);
      this.lzD.nZ = false;
    }
    this.uBI.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        e.this.uBI = null;
      }
    });
    AppMethodBeat.o(159571);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159572);
    if (this.uBI != null) {
      this.uBI.dismiss();
    }
    AppMethodBeat.o(159572);
  }
  
  public final class a
    extends BaseAdapter
  {
    public HashMap<Integer, Boolean> Lbe;
    private ArrayList<Integer> Lbf;
    private Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159565);
      this.Lbe = new HashMap();
      this.context = paramContext;
      AppMethodBeat.o(159565);
    }
    
    public final void fMN()
    {
      AppMethodBeat.i(159569);
      if (e.this.Lba == null)
      {
        AppMethodBeat.o(159569);
        return;
      }
      int i = 0;
      if (i < getCount())
      {
        if (e.this.Lba.contains(Integer.valueOf(i))) {
          this.Lbe.put(Integer.valueOf(i), Boolean.TRUE);
        }
        for (;;)
        {
          i += 1;
          break;
          this.Lbe.put(Integer.valueOf(i), Boolean.FALSE);
        }
      }
      AppMethodBeat.o(159569);
    }
    
    public final ArrayList<Integer> fMO()
    {
      AppMethodBeat.i(159570);
      if (this.Lbe == null)
      {
        AppMethodBeat.o(159570);
        return null;
      }
      this.Lbf = new ArrayList();
      int i = 0;
      while (i < getCount())
      {
        if (((Boolean)this.Lbe.get(Integer.valueOf(i))).booleanValue()) {
          this.Lbf.add(Integer.valueOf(i));
        }
        i += 1;
      }
      ArrayList localArrayList = this.Lbf;
      AppMethodBeat.o(159570);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159566);
      int i = e.this.Ekt.size();
      AppMethodBeat.o(159566);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159567);
      Object localObject = e.this.Ekt.JlY.get(paramInt);
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
      final m localm = (m)e.this.Ekt.JlY.get(paramInt);
      paramViewGroup = LayoutInflater.from(this.context);
      View localView;
      if (paramView == null)
      {
        localView = paramViewGroup.inflate(2131494965, null);
        paramView = new a();
        paramView.KXg = ((LinearLayout)localView.findViewById(2131301167));
        paramView.iCK = ((CheckBox)localView.findViewById(2131301143));
        paramView.iVq = ((TextView)localView.findViewById(2131301198));
        paramView.iCV = ((TextView)localView.findViewById(2131301149));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.iVq.setText(localm.getTitle());
        paramViewGroup.KXg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159564);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (e.this.KJz != null) {
              e.this.KJz.onMMMenuItemSelected(e.this.Ekt.getItem(paramInt), paramInt);
            }
            if (localm.lSG)
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
              e.a.this.Lbe = e.a.a(e.a.this);
              e.a.this.notifyDataSetChanged();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MultiPicker$ListViewAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(159564);
              return;
              e.a.a(e.a.this).put(Integer.valueOf(paramInt), Boolean.TRUE);
            }
          }
        });
        if (paramViewGroup.iCV != null)
        {
          if ((localm.tBj == null) || (localm.tBj.length() <= 0)) {
            break label304;
          }
          paramViewGroup.iCV.setVisibility(0);
          paramViewGroup.iCV.setText(localm.tBj);
        }
        label198:
        if (!localm.lSG) {
          break label316;
        }
        paramViewGroup.iVq.setTextColor(e.this.mContext.getResources().getColor(2131100031));
        paramViewGroup.iCV.setTextColor(e.this.mContext.getResources().getColor(2131100031));
        paramViewGroup.iCK.setChecked(((Boolean)this.Lbe.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.iCK.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(159568);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label304:
        paramViewGroup.iCV.setVisibility(8);
        break label198;
        label316:
        paramViewGroup.iVq.setTextColor(e.this.mContext.getResources().getColor(2131100030));
        paramViewGroup.iCV.setTextColor(e.this.mContext.getResources().getColor(2131100032));
        paramViewGroup.iCK.setChecked(((Boolean)this.Lbe.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.iCK.setEnabled(true);
      }
    }
    
    final class a
    {
      LinearLayout KXg;
      CheckBox iCK;
      TextView iCV;
      TextView iVq;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void qm(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */