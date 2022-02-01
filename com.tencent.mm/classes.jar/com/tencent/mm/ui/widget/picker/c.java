package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.picker.d.d;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public LinearLayout KGj;
  private Button Lxf;
  private String[] Lxk;
  private ArrayList<List<String>> Lxl;
  private ArrayList<List<String>> Lxm;
  private CustomOptionPickNew Lxn;
  public CustomOptionPickNew Lxo;
  private CustomOptionPickNew Lxp;
  public c.a Lxq;
  private LinearLayout Lxr;
  private LinearLayout Lxs;
  private LinearLayout Lxt;
  private LinearLayout OAy;
  private boolean OAz;
  private Button gXc;
  private Button gZv;
  private View kFh;
  private int lEa;
  private BottomSheetBehavior lEb;
  private Context mContext;
  private android.support.design.widget.a uNn;
  
  public c(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(159540);
    this.Lxl = null;
    this.Lxm = null;
    this.OAz = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.Lxk = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    initView();
    AppMethodBeat.o(159540);
  }
  
  public c(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1)
  {
    AppMethodBeat.i(159541);
    this.Lxl = null;
    this.Lxm = null;
    this.OAz = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.Lxk = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.Lxl = paramArrayList1;
    initView();
    AppMethodBeat.o(159541);
  }
  
  public c(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(159539);
    this.Lxl = null;
    this.Lxm = null;
    this.OAz = false;
    this.mContext = paramContext;
    this.Lxk = paramArrayOfString;
    initView();
    AppMethodBeat.o(159539);
  }
  
  private String[] aeO(int paramInt)
  {
    AppMethodBeat.i(224518);
    if (this.Lxl != null)
    {
      Object localObject = (ArrayList)this.Lxl.get(paramInt);
      if (localObject != null)
      {
        localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
        AppMethodBeat.o(224518);
        return localObject;
      }
    }
    AppMethodBeat.o(224518);
    return null;
  }
  
  private String[] amO(int paramInt)
  {
    AppMethodBeat.i(224519);
    if (this.Lxm != null)
    {
      Object localObject = (ArrayList)this.Lxm.get(paramInt);
      if (localObject != null)
      {
        localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
        AppMethodBeat.o(224519);
        return localObject;
      }
    }
    AppMethodBeat.o(224519);
    return null;
  }
  
  private void initView()
  {
    AppMethodBeat.i(159542);
    this.uNn = new android.support.design.widget.a(this.mContext);
    this.kFh = View.inflate(this.mContext, 2131495059, null);
    this.KGj = ((LinearLayout)this.kFh.findViewById(2131307217));
    this.OAy = ((LinearLayout)this.kFh.findViewById(2131297696));
    this.Lxr = ((LinearLayout)this.kFh.findViewById(2131303044));
    this.Lxn = new CustomOptionPickNew(this.mContext);
    this.Lxn.setOptionsArray(this.Lxk);
    this.Lxr.removeAllViews();
    this.Lxr.setGravity(17);
    this.Lxr.addView(this.Lxn.getView(), new LinearLayout.LayoutParams(-2, -1));
    this.Lxs = ((LinearLayout)this.kFh.findViewById(2131303045));
    this.Lxt = ((LinearLayout)this.kFh.findViewById(2131308504));
    if (this.Lxl != null)
    {
      this.Lxs.setVisibility(0);
      this.Lxo = new CustomOptionPickNew(this.mContext);
      this.Lxs.removeAllViews();
      this.Lxs.setGravity(17);
      this.Lxs.addView(this.Lxo.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.Lxo.setOptionsArray(aeO(this.Lxn.getValue()));
      if (!this.OAz) {
        this.Lxn.setOnValueChangedListener(new d()
        {
          public final void qW(int paramAnonymousInt)
          {
            AppMethodBeat.i(200478);
            c.a(c.this).setOptionsArray(c.a(c.this, paramAnonymousInt));
            AppMethodBeat.o(200478);
          }
        });
      }
      if (this.Lxm == null) {
        break label594;
      }
      this.Lxt.setVisibility(0);
      this.Lxp = new CustomOptionPickNew(this.mContext);
      this.Lxt.removeAllViews();
      this.Lxt.setGravity(17);
      this.Lxt.addView(this.Lxp.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.Lxp.setOptionsArray(amO(this.Lxo.getValue()));
      if (!this.OAz) {
        this.Lxo.setOnValueChangedListener(new d()
        {
          public final void qW(int paramAnonymousInt)
          {
            AppMethodBeat.i(200479);
            c.c(c.this).setOptionsArray(c.b(c.this, paramAnonymousInt));
            AppMethodBeat.o(200479);
          }
        });
      }
    }
    for (;;)
    {
      this.gXc = ((Button)this.kFh.findViewById(2131302999));
      this.gXc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject1 = null;
          AppMethodBeat.i(159537);
          Object localObject2 = new b();
          ((b)localObject2).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).ahF());
          localObject2 = c.this;
          if (c.b(c.this) == null)
          {
            paramAnonymousView = null;
            if (c.a(c.this) != null) {
              break label168;
            }
          }
          for (;;)
          {
            c.a((c)localObject2, true, paramAnonymousView, localObject1);
            if (c.b(c.this) != null) {
              c.b(c.this).currentValue();
            }
            if (c.a(c.this) != null) {
              c.a(c.this).currentValue();
            }
            if (c.c(c.this) != null) {
              c.c(c.this).currentValue();
            }
            c.fST();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(159537);
            return;
            paramAnonymousView = c.b(c.this).currentValue();
            break;
            label168:
            localObject1 = c.a(c.this).currentValue();
          }
        }
      });
      this.gZv = ((Button)this.kFh.findViewById(2131297690));
      this.gZv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(200480);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          c.a(c.this, false, null, null);
          c.fST();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200480);
        }
      });
      this.Lxf = ((Button)this.kFh.findViewById(2131297600));
      this.Lxf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject1 = null;
          AppMethodBeat.i(200481);
          Object localObject2 = new b();
          ((b)localObject2).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).ahF());
          localObject2 = c.this;
          if (c.b(c.this) == null)
          {
            paramAnonymousView = null;
            if (c.a(c.this) != null) {
              break label168;
            }
          }
          for (;;)
          {
            c.a((c)localObject2, true, paramAnonymousView, localObject1);
            if (c.b(c.this) != null) {
              c.b(c.this).currentValue();
            }
            if (c.a(c.this) != null) {
              c.a(c.this).currentValue();
            }
            if (c.c(c.this) != null) {
              c.c(c.this).currentValue();
            }
            c.fST();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(200481);
            return;
            paramAnonymousView = c.b(c.this).currentValue();
            break;
            label168:
            localObject1 = c.a(c.this).currentValue();
          }
        }
      });
      this.uNn.setContentView(this.kFh);
      this.lEa = aq.fromDPToPix(this.mContext, 420);
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
          AppMethodBeat.i(200482);
          c.d(c.this);
          AppMethodBeat.o(200482);
        }
      });
      AppMethodBeat.o(159542);
      return;
      this.Lxs.setVisibility(8);
      break;
      label594:
      this.Lxt.setVisibility(8);
    }
  }
  
  public final void agm(int paramInt)
  {
    AppMethodBeat.i(159547);
    if (this.Lxn != null)
    {
      this.Lxn.setValue(paramInt);
      this.Lxn.agl(paramInt);
      if ((this.Lxo != null) && (this.Lxl != null)) {
        this.Lxo.setOptionsArray(aeO(paramInt));
      }
    }
    AppMethodBeat.o(159547);
  }
  
  public final int fRg()
  {
    AppMethodBeat.i(159546);
    int i = 0;
    if (this.Lxn != null) {
      i = this.Lxn.getValue();
    }
    AppMethodBeat.o(159546);
    return i;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159545);
    if (this.uNn != null) {
      this.uNn.dismiss();
    }
    AppMethodBeat.o(159545);
  }
  
  public final void kr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159548);
    if ((this.Lxn != null) && (this.Lxo != null))
    {
      this.Lxn.setValue(paramInt1);
      this.Lxn.agl(paramInt1);
      this.Lxo.setOptionsArray(aeO(paramInt1));
      this.Lxo.setValue(paramInt2);
      this.Lxo.agl(paramInt2);
      this.Lxo.invalidate();
    }
    AppMethodBeat.o(159548);
  }
  
  public final void onGlobalLayout() {}
  
  public final void show()
  {
    AppMethodBeat.i(159544);
    if (this.uNn != null) {
      this.uNn.show();
    }
    AppMethodBeat.o(159544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */