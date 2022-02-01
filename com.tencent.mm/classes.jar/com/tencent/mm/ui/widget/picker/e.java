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
  public l CGH;
  public n.c ISu;
  public n.d ISv;
  public ListView JjB;
  public View JjC;
  public ArrayList<Integer> JjD;
  public a JjE;
  public b JjF;
  public Button gAJ;
  public Button gCY;
  public View khe;
  public int lcC;
  private BottomSheetBehavior lcD;
  public Context mContext;
  public a tyZ;
  public TextView zjv;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(159571);
    this.mContext = paramContext;
    this.CGH = new l(this.mContext);
    this.tyZ = new a(this.mContext);
    this.khe = View.inflate(this.mContext, 2131494966, null);
    this.JjB = ((ListView)this.khe.findViewById(2131302564));
    this.gAJ = ((Button)this.khe.findViewById(2131302999));
    this.gCY = ((Button)this.khe.findViewById(2131297690));
    this.JjC = this.khe.findViewById(2131300720);
    this.zjv = ((TextView)this.khe.findViewById(2131300731));
    this.tyZ.setContentView(this.khe);
    this.lcC = (ao.av(this.mContext, 2131165203) + ao.av(this.mContext, 2131165204));
    this.lcD = BottomSheetBehavior.l((View)this.khe.getParent());
    if (this.lcD != null)
    {
      this.lcD.J(this.lcC);
      this.lcD.mg = false;
    }
    this.tyZ.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        e.this.tyZ = null;
      }
    });
    AppMethodBeat.o(159571);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159572);
    if (this.tyZ != null) {
      this.tyZ.dismiss();
    }
    AppMethodBeat.o(159572);
  }
  
  public final class a
    extends BaseAdapter
  {
    public HashMap<Integer, Boolean> JjH;
    private ArrayList<Integer> JjI;
    private Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(159565);
      this.JjH = new HashMap();
      this.context = paramContext;
      AppMethodBeat.o(159565);
    }
    
    public final void fvZ()
    {
      AppMethodBeat.i(159569);
      if (e.this.JjD == null)
      {
        AppMethodBeat.o(159569);
        return;
      }
      int i = 0;
      if (i < getCount())
      {
        if (e.this.JjD.contains(Integer.valueOf(i))) {
          this.JjH.put(Integer.valueOf(i), Boolean.TRUE);
        }
        for (;;)
        {
          i += 1;
          break;
          this.JjH.put(Integer.valueOf(i), Boolean.FALSE);
        }
      }
      AppMethodBeat.o(159569);
    }
    
    public final ArrayList<Integer> fwa()
    {
      AppMethodBeat.i(159570);
      if (this.JjH == null)
      {
        AppMethodBeat.o(159570);
        return null;
      }
      this.JjI = new ArrayList();
      int i = 0;
      while (i < getCount())
      {
        if (((Boolean)this.JjH.get(Integer.valueOf(i))).booleanValue()) {
          this.JjI.add(Integer.valueOf(i));
        }
        i += 1;
      }
      ArrayList localArrayList = this.JjI;
      AppMethodBeat.o(159570);
      return localArrayList;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159566);
      int i = e.this.CGH.size();
      AppMethodBeat.o(159566);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(159567);
      Object localObject = e.this.CGH.Hyi.get(paramInt);
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
      final m localm = (m)e.this.CGH.Hyi.get(paramInt);
      paramViewGroup = LayoutInflater.from(this.context);
      View localView;
      if (paramView == null)
      {
        localView = paramViewGroup.inflate(2131494965, null);
        paramView = new a();
        paramView.JfS = ((LinearLayout)localView.findViewById(2131301167));
        paramView.ijt = ((CheckBox)localView.findViewById(2131301143));
        paramView.iCg = ((TextView)localView.findViewById(2131301198));
        paramView.ijE = ((TextView)localView.findViewById(2131301149));
        localView.setTag(paramView);
        paramViewGroup = paramView;
        paramViewGroup.iCg.setText(localm.getTitle());
        paramViewGroup.JfS.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159564);
            if (e.this.ISv != null) {
              e.this.ISv.onMMMenuItemSelected(e.this.CGH.getItem(paramInt), paramInt);
            }
            if (localm.ltx)
            {
              AppMethodBeat.o(159564);
              return;
            }
            if (((Boolean)e.a.a(e.a.this).get(Integer.valueOf(paramInt))).booleanValue()) {
              e.a.a(e.a.this).put(Integer.valueOf(paramInt), Boolean.FALSE);
            }
            for (;;)
            {
              e.a.this.JjH = e.a.a(e.a.this);
              e.a.this.notifyDataSetChanged();
              AppMethodBeat.o(159564);
              return;
              e.a.a(e.a.this).put(Integer.valueOf(paramInt), Boolean.TRUE);
            }
          }
        });
        if (paramViewGroup.ijE != null)
        {
          if ((localm.sEs == null) || (localm.sEs.length() <= 0)) {
            break label304;
          }
          paramViewGroup.ijE.setVisibility(0);
          paramViewGroup.ijE.setText(localm.sEs);
        }
        label198:
        if (!localm.ltx) {
          break label316;
        }
        paramViewGroup.iCg.setTextColor(e.this.mContext.getResources().getColor(2131100031));
        paramViewGroup.ijE.setTextColor(e.this.mContext.getResources().getColor(2131100031));
        paramViewGroup.ijt.setChecked(((Boolean)this.JjH.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.ijt.setEnabled(false);
      }
      for (;;)
      {
        AppMethodBeat.o(159568);
        return localView;
        paramViewGroup = (a)paramView.getTag();
        localView = paramView;
        break;
        label304:
        paramViewGroup.ijE.setVisibility(8);
        break label198;
        label316:
        paramViewGroup.iCg.setTextColor(e.this.mContext.getResources().getColor(2131100030));
        paramViewGroup.ijE.setTextColor(e.this.mContext.getResources().getColor(2131100032));
        paramViewGroup.ijt.setChecked(((Boolean)this.JjH.get(Integer.valueOf(paramInt))).booleanValue());
        paramViewGroup.ijt.setEnabled(true);
      }
    }
    
    final class a
    {
      LinearLayout JfS;
      TextView iCg;
      TextView ijE;
      CheckBox ijt;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void pN(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.e
 * JD-Core Version:    0.7.0.1
 */