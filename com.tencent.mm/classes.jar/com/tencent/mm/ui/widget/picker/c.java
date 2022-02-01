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
  public LinearLayout KjP;
  private Button LaH;
  private String[] LaM;
  private ArrayList<List<String>> LaN;
  private CustomOptionPickNew LaO;
  public CustomOptionPickNew LaP;
  public a LaQ;
  private LinearLayout LaR;
  private LinearLayout LaS;
  private Button gUt;
  private Button gWI;
  private View kBS;
  private int lzC;
  private BottomSheetBehavior lzD;
  private Context mContext;
  private android.support.design.widget.a uBI;
  
  public c(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(159540);
    this.LaN = null;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.LaM = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    initView();
    AppMethodBeat.o(159540);
  }
  
  public c(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1)
  {
    AppMethodBeat.i(159541);
    this.LaN = null;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.LaM = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.LaN = paramArrayList1;
    initView();
    AppMethodBeat.o(159541);
  }
  
  public c(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(159539);
    this.LaN = null;
    this.mContext = paramContext;
    this.LaM = paramArrayOfString;
    initView();
    AppMethodBeat.o(159539);
  }
  
  private String[] afE(int paramInt)
  {
    AppMethodBeat.i(159549);
    if (this.LaN != null)
    {
      Object localObject = (ArrayList)this.LaN.get(paramInt);
      if (localObject != null)
      {
        localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
        AppMethodBeat.o(159549);
        return localObject;
      }
    }
    AppMethodBeat.o(159549);
    return null;
  }
  
  private void initView()
  {
    AppMethodBeat.i(159542);
    this.uBI = new android.support.design.widget.a(this.mContext);
    this.kBS = View.inflate(this.mContext, 2131495059, null);
    this.KjP = ((LinearLayout)this.kBS.findViewById(2131307217));
    this.LaR = ((LinearLayout)this.kBS.findViewById(2131303044));
    this.LaO = new CustomOptionPickNew(this.mContext);
    this.LaO.setOptionsArray(this.LaM);
    this.LaR.removeAllViews();
    this.LaR.setGravity(17);
    this.LaR.addView(this.LaO.getView(), new LinearLayout.LayoutParams(-2, -1));
    this.LaS = ((LinearLayout)this.kBS.findViewById(2131303045));
    if (this.LaN != null)
    {
      this.LaS.setVisibility(0);
      this.LaP = new CustomOptionPickNew(this.mContext);
      this.LaS.removeAllViews();
      this.LaS.setGravity(17);
      this.LaS.addView(this.LaP.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.LaP.setOptionsArray(afE(this.LaO.getValue()));
      this.LaO.setOnValueChangedListener(new d()
      {
        public final void qT(int paramAnonymousInt)
        {
          AppMethodBeat.i(192708);
          c.a(c.this).setOptionsArray(c.a(c.this, paramAnonymousInt));
          AppMethodBeat.o(192708);
        }
      });
    }
    for (;;)
    {
      this.gUt = ((Button)this.kBS.findViewById(2131302999));
      this.gUt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject1 = null;
          AppMethodBeat.i(159536);
          Object localObject2 = new b();
          ((b)localObject2).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).ahq());
          localObject2 = c.this;
          if (c.b(c.this) == null)
          {
            paramAnonymousView = null;
            if (c.a(c.this) != null) {
              break label102;
            }
          }
          for (;;)
          {
            c.a((c)localObject2, true, paramAnonymousView, localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(159536);
            return;
            paramAnonymousView = c.b(c.this).currentValue();
            break;
            label102:
            localObject1 = c.a(c.this).currentValue();
          }
        }
      });
      this.gWI = ((Button)this.kBS.findViewById(2131297690));
      this.gWI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159537);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          c.a(c.this, false, null, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159537);
        }
      });
      this.LaH = ((Button)this.kBS.findViewById(2131297600));
      this.LaH.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject1 = null;
          AppMethodBeat.i(192709);
          Object localObject2 = new b();
          ((b)localObject2).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject2).ahq());
          localObject2 = c.this;
          if (c.b(c.this) == null)
          {
            paramAnonymousView = null;
            if (c.a(c.this) != null) {
              break label102;
            }
          }
          for (;;)
          {
            c.a((c)localObject2, true, paramAnonymousView, localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(192709);
            return;
            paramAnonymousView = c.b(c.this).currentValue();
            break;
            label102:
            localObject1 = c.a(c.this).currentValue();
          }
        }
      });
      this.uBI.setContentView(this.kBS);
      this.lzC = aq.fromDPToPix(this.mContext, 420);
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
          AppMethodBeat.i(192710);
          c.c(c.this);
          AppMethodBeat.o(192710);
        }
      });
      AppMethodBeat.o(159542);
      return;
      this.LaS.setVisibility(8);
    }
  }
  
  public final void afD(int paramInt)
  {
    AppMethodBeat.i(159547);
    if (this.LaO != null)
    {
      this.LaO.setValue(paramInt);
      this.LaO.afC(paramInt);
      if ((this.LaP != null) && (this.LaN != null)) {
        this.LaP.setOptionsArray(afE(paramInt));
      }
    }
    AppMethodBeat.o(159547);
  }
  
  public final int fMM()
  {
    AppMethodBeat.i(159546);
    int i = 0;
    if (this.LaO != null) {
      i = this.LaO.getValue();
    }
    AppMethodBeat.o(159546);
    return i;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159545);
    if (this.uBI != null) {
      this.uBI.dismiss();
    }
    AppMethodBeat.o(159545);
  }
  
  public final void kk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159548);
    if ((this.LaO != null) && (this.LaP != null))
    {
      this.LaO.setValue(paramInt1);
      this.LaO.afC(paramInt1);
      this.LaP.setOptionsArray(afE(paramInt1));
      this.LaP.setValue(paramInt2);
      this.LaP.afC(paramInt2);
      this.LaP.invalidate();
    }
    AppMethodBeat.o(159548);
  }
  
  public final void onGlobalLayout() {}
  
  public final void show()
  {
    AppMethodBeat.i(159544);
    if (this.uBI != null) {
      this.uBI.show();
    }
    AppMethodBeat.o(159544);
  }
  
  public static abstract interface a<T>
  {
    public abstract void onResult(boolean paramBoolean, T paramT1, T paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */