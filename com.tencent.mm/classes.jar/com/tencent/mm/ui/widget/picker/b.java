package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.e;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.List;

public class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private com.google.android.material.bottomsheet.a DpN;
  private LinearLayout XpQ;
  private Button YrC;
  private String[] YrH;
  private ArrayList<List<String>> YrI;
  private ArrayList<List<String>> YrJ;
  private CustomOptionPickNew YrK;
  public CustomOptionPickNew YrL;
  private CustomOptionPickNew YrM;
  public b YrN;
  private b.a YrO;
  private LinearLayout YrP;
  private LinearLayout YrQ;
  private LinearLayout YrR;
  private LinearLayout YrS;
  private boolean YrT;
  private Button kEt;
  private Button kGN;
  private Context mContext;
  private View oFW;
  private int pMB;
  private BottomSheetBehavior pMC;
  
  public b(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(159540);
    this.YrI = null;
    this.YrJ = null;
    this.YrT = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.YrH = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    initView();
    AppMethodBeat.o(159540);
  }
  
  public b(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1)
  {
    AppMethodBeat.i(159541);
    this.YrI = null;
    this.YrJ = null;
    this.YrT = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.YrH = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.YrI = paramArrayList1;
    initView();
    AppMethodBeat.o(159541);
  }
  
  public b(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1, ArrayList<List<String>> paramArrayList2)
  {
    AppMethodBeat.i(250179);
    this.YrI = null;
    this.YrJ = null;
    this.YrT = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.YrH = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.YrI = paramArrayList1;
    this.YrJ = paramArrayList2;
    this.YrT = false;
    initView();
    AppMethodBeat.o(250179);
  }
  
  public b(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(159539);
    this.YrI = null;
    this.YrJ = null;
    this.YrT = false;
    this.mContext = paramContext;
    this.YrH = paramArrayOfString;
    initView();
    AppMethodBeat.o(159539);
  }
  
  private String[] awD(int paramInt)
  {
    AppMethodBeat.i(250197);
    if (this.YrI != null)
    {
      Object localObject = (ArrayList)this.YrI.get(paramInt);
      if (localObject != null)
      {
        localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
        AppMethodBeat.o(250197);
        return localObject;
      }
    }
    AppMethodBeat.o(250197);
    return null;
  }
  
  private String[] ayL(int paramInt)
  {
    AppMethodBeat.i(250199);
    if (this.YrJ != null)
    {
      Object localObject = (ArrayList)this.YrJ.get(paramInt);
      if (localObject != null)
      {
        localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
        AppMethodBeat.o(250199);
        return localObject;
      }
    }
    AppMethodBeat.o(250199);
    return null;
  }
  
  private void initView()
  {
    AppMethodBeat.i(159542);
    this.DpN = new com.google.android.material.bottomsheet.a(this.mContext);
    this.oFW = View.inflate(this.mContext, a.g.mm_option_picker_panel, null);
    this.XpQ = ((LinearLayout)this.oFW.findViewById(a.f.option_picker_header));
    this.YrS = ((LinearLayout)this.oFW.findViewById(a.f.option_picker_footer));
    this.YrP = ((LinearLayout)this.oFW.findViewById(a.f.option_picker));
    this.YrK = new CustomOptionPickNew(this.mContext);
    this.YrK.setOptionsArray(this.YrH);
    this.YrP.removeAllViews();
    this.YrP.setGravity(17);
    this.YrP.addView(this.YrK.getView(), new LinearLayout.LayoutParams(-2, -1));
    this.YrQ = ((LinearLayout)this.oFW.findViewById(a.f.option_second_picker));
    this.YrR = ((LinearLayout)this.oFW.findViewById(a.f.option_third_picker));
    if (this.YrI != null)
    {
      this.YrQ.setVisibility(0);
      this.YrL = new CustomOptionPickNew(this.mContext);
      this.YrQ.removeAllViews();
      this.YrQ.setGravity(17);
      this.YrQ.addView(this.YrL.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.YrL.setOptionsArray(awD(this.YrK.getValue()));
      if (!this.YrT) {
        this.YrK.setOnValueChangedListener(new com.tencent.mm.picker.d.b()
        {
          public final void xS(int paramAnonymousInt)
          {
            AppMethodBeat.i(249513);
            b.a(b.this).setOptionsArray(b.a(b.this, paramAnonymousInt));
            if ((b.b(b.this) != null) && (b.c(b.this) != null))
            {
              int j = 0;
              int i = 0;
              while (j < paramAnonymousInt)
              {
                i += ((List)b.d(b.this).get(j)).size();
                j += 1;
              }
              paramAnonymousInt = b.a(b.this).getValue();
              b.c(b.this).setOptionsArray(b.b(b.this, paramAnonymousInt + i));
            }
            AppMethodBeat.o(249513);
          }
        });
      }
      if (this.YrJ == null) {
        break label603;
      }
      this.YrR.setVisibility(0);
      this.YrM = new CustomOptionPickNew(this.mContext);
      this.YrR.removeAllViews();
      this.YrR.setGravity(17);
      this.YrR.addView(this.YrM.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.YrM.setOptionsArray(ayL(this.YrL.getValue()));
      if (!this.YrT) {
        this.YrL.setOnValueChangedListener(new com.tencent.mm.picker.d.b()
        {
          public final void xS(int paramAnonymousInt)
          {
            AppMethodBeat.i(250828);
            int k = b.e(b.this).getValue();
            int i = 0;
            int j = 0;
            while (i < k)
            {
              j += ((List)b.d(b.this).get(i)).size();
              i += 1;
            }
            b.c(b.this).setOptionsArray(b.b(b.this, j + paramAnonymousInt));
            AppMethodBeat.o(250828);
          }
        });
      }
    }
    for (;;)
    {
      this.kEt = ((Button)this.oFW.findViewById(a.f.ok_btn));
      this.kEt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject2 = null;
          AppMethodBeat.i(159537);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          b localb = b.this;
          if (b.e(b.this) == null)
          {
            paramAnonymousView = null;
            if (b.a(b.this) != null) {
              break label155;
            }
            localObject1 = null;
            label66:
            b.a(localb, true, paramAnonymousView, localObject1);
            localb = b.this;
            if (b.e(b.this) != null) {
              break label169;
            }
            paramAnonymousView = null;
            label92:
            if (b.a(b.this) != null) {
              break label183;
            }
            localObject1 = null;
            label104:
            if (b.c(b.this) != null) {
              break label197;
            }
          }
          for (;;)
          {
            b.a(localb, true, paramAnonymousView, localObject1, localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(159537);
            return;
            paramAnonymousView = b.e(b.this).currentValue();
            break;
            label155:
            localObject1 = b.a(b.this).currentValue();
            break label66;
            label169:
            paramAnonymousView = b.e(b.this).currentValue();
            break label92;
            label183:
            localObject1 = b.a(b.this).currentValue();
            break label104;
            label197:
            localObject2 = b.c(b.this).currentValue();
          }
        }
      });
      this.kGN = ((Button)this.oFW.findViewById(a.f.cancel_btn));
      this.kGN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(249938);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          b.a(b.this, false, null, null);
          b.a(b.this, false, null, null, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(249938);
        }
      });
      this.YrC = ((Button)this.oFW.findViewById(a.f.btn_single));
      this.YrC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject2 = null;
          AppMethodBeat.i(250241);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMOptionPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          b localb = b.this;
          if (b.e(b.this) == null)
          {
            paramAnonymousView = null;
            if (b.a(b.this) != null) {
              break label155;
            }
            localObject1 = null;
            label66:
            b.a(localb, true, paramAnonymousView, localObject1);
            localb = b.this;
            if (b.e(b.this) != null) {
              break label169;
            }
            paramAnonymousView = null;
            label92:
            if (b.a(b.this) != null) {
              break label183;
            }
            localObject1 = null;
            label104:
            if (b.c(b.this) != null) {
              break label197;
            }
          }
          for (;;)
          {
            b.a(localb, true, paramAnonymousView, localObject1, localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250241);
            return;
            paramAnonymousView = b.e(b.this).currentValue();
            break;
            label155:
            localObject1 = b.a(b.this).currentValue();
            break label66;
            label169:
            paramAnonymousView = b.e(b.this).currentValue();
            break label92;
            label183:
            localObject1 = b.a(b.this).currentValue();
            break label104;
            label197:
            localObject2 = b.c(b.this).currentValue();
          }
        }
      });
      this.DpN.setContentView(this.oFW);
      this.pMB = aw.fromDPToPix(this.mContext, 420);
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
          AppMethodBeat.i(250265);
          b.f(b.this);
          AppMethodBeat.o(250265);
        }
      });
      AppMethodBeat.o(159542);
      return;
      this.YrQ.setVisibility(8);
      break;
      label603:
      this.YrR.setVisibility(8);
    }
  }
  
  public final void a(b.a parama)
  {
    this.YrO = parama;
  }
  
  public final void a(b paramb)
  {
    this.YrN = paramb;
  }
  
  public final void aU(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(250183);
    if (this.kEt != null) {
      this.kEt.setText(paramCharSequence);
    }
    AppMethodBeat.o(250183);
  }
  
  public final void ayJ(int paramInt)
  {
    AppMethodBeat.i(250185);
    if (this.kEt != null) {
      this.kEt.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(250185);
  }
  
  public final void ayK(int paramInt)
  {
    AppMethodBeat.i(159547);
    if (this.YrK != null)
    {
      this.YrK.setValue(paramInt);
      this.YrK.ayI(paramInt);
      if ((this.YrL != null) && (this.YrI != null)) {
        this.YrL.setOptionsArray(awD(paramInt));
      }
    }
    AppMethodBeat.o(159547);
  }
  
  public final void ays(int paramInt)
  {
    AppMethodBeat.i(250184);
    if (this.kGN != null) {
      this.kGN.setTextColor(paramInt);
    }
    AppMethodBeat.o(250184);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159545);
    if (this.DpN != null) {
      this.DpN.dismiss();
    }
    AppMethodBeat.o(159545);
  }
  
  public final void ido()
  {
    AppMethodBeat.i(250187);
    if (this.kEt != null)
    {
      this.kEt.setTextColor(this.mContext.getResources().getColor(a.c.color_btn_text_selector));
      this.kEt.setBackgroundResource(a.e.btn_solid_red);
    }
    AppMethodBeat.o(250187);
  }
  
  public final int idp()
  {
    AppMethodBeat.i(159546);
    int i = 0;
    if (this.YrK != null) {
      i = this.YrK.getValue();
    }
    AppMethodBeat.o(159546);
    return i;
  }
  
  public final void idq()
  {
    AppMethodBeat.i(250195);
    if ((this.YrK != null) && (this.YrL != null) && (this.YrM != null))
    {
      this.YrK.setValue(1);
      this.YrK.ayI(1);
      this.YrL.setOptionsArray(awD(1));
      this.YrL.setValue(12);
      this.YrL.ayI(12);
      this.YrL.invalidate();
      this.YrM.setOptionsArray(ayL(12));
      this.YrM.setValue(0);
      this.YrM.ayI(0);
      this.YrM.invalidate();
    }
    AppMethodBeat.o(250195);
  }
  
  public final void nc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159548);
    if ((this.YrK != null) && (this.YrL != null))
    {
      this.YrK.setValue(paramInt1);
      this.YrK.ayI(paramInt1);
      this.YrL.setOptionsArray(awD(paramInt1));
      this.YrL.setValue(paramInt2);
      this.YrL.ayI(paramInt2);
      this.YrL.invalidate();
    }
    AppMethodBeat.o(159548);
  }
  
  public void onGlobalLayout() {}
  
  public final void setFooterView(View paramView)
  {
    AppMethodBeat.i(250190);
    if (this.YrS != null)
    {
      if (paramView == null)
      {
        this.YrS.setVisibility(8);
        AppMethodBeat.o(250190);
        return;
      }
      this.YrS.setVisibility(0);
      this.YrS.removeAllViews();
      this.YrS.setGravity(17);
      this.YrS.addView(paramView, new LinearLayout.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(250190);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(250188);
    if (this.XpQ != null)
    {
      if (paramView == null)
      {
        this.XpQ.setVisibility(8);
        AppMethodBeat.o(250188);
        return;
      }
      this.XpQ.setVisibility(0);
      this.XpQ.removeAllViews();
      this.XpQ.setGravity(17);
      this.XpQ.addView(paramView, new LinearLayout.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(250188);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159544);
    if (this.DpN != null) {
      this.DpN.show();
    }
    AppMethodBeat.o(159544);
  }
  
  public static abstract interface b<T>
  {
    public abstract void onResult(boolean paramBoolean, T paramT1, T paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */