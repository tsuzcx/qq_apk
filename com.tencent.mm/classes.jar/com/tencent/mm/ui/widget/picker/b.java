package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.picker.d.c;
import com.tencent.mm.ui.bd;
import java.util.ArrayList;
import java.util.List;

public class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private Button ErU;
  private com.google.android.material.bottomsheet.a Jjv;
  private LinearLayout afbs;
  private String[] agjW;
  private ArrayList<List<String>> agjX;
  private ArrayList<List<String>> agjY;
  public CustomOptionPickNew agjZ;
  public CustomOptionPickNew agka;
  public CustomOptionPickNew agkb;
  public b.b agkc;
  public b.a agkd;
  private LinearLayout agke;
  private LinearLayout agkf;
  private LinearLayout agkg;
  public LinearLayout agkh;
  private boolean agki;
  public Context mContext;
  public Button nhC;
  private Button njI;
  private View rootView;
  private int sRu;
  private BottomSheetBehavior sRv;
  
  public b(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(159540);
    this.agjX = null;
    this.agjY = null;
    this.agki = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.agjW = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    initView();
    AppMethodBeat.o(159540);
  }
  
  public b(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1)
  {
    AppMethodBeat.i(159541);
    this.agjX = null;
    this.agjY = null;
    this.agki = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.agjW = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.agjX = paramArrayList1;
    initView();
    AppMethodBeat.o(159541);
  }
  
  public b(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1, ArrayList<List<String>> paramArrayList2)
  {
    AppMethodBeat.i(252679);
    this.agjX = null;
    this.agjY = null;
    this.agki = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.agjW = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.agjX = paramArrayList1;
    this.agjY = paramArrayList2;
    this.agki = false;
    initView();
    AppMethodBeat.o(252679);
  }
  
  public b(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(159539);
    this.agjX = null;
    this.agjY = null;
    this.agki = false;
    this.mContext = paramContext;
    this.agjW = paramArrayOfString;
    initView();
    AppMethodBeat.o(159539);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159542);
    this.Jjv = new com.google.android.material.bottomsheet.a(this.mContext);
    this.rootView = View.inflate(this.mContext, a.g.mm_option_picker_panel, null);
    this.afbs = ((LinearLayout)this.rootView.findViewById(a.f.option_picker_header));
    this.agkh = ((LinearLayout)this.rootView.findViewById(a.f.option_picker_footer));
    this.agke = ((LinearLayout)this.rootView.findViewById(a.f.option_picker));
    this.agjZ = new CustomOptionPickNew(this.mContext);
    this.agjZ.setOptionsArray(this.agjW);
    this.agke.removeAllViews();
    this.agke.setGravity(17);
    this.agke.addView(this.agjZ.getView(), new LinearLayout.LayoutParams(-2, -1));
    this.agkf = ((LinearLayout)this.rootView.findViewById(a.f.option_second_picker));
    this.agkg = ((LinearLayout)this.rootView.findViewById(a.f.option_third_picker));
    if (this.agjX != null)
    {
      this.agkf.setVisibility(0);
      this.agka = new CustomOptionPickNew(this.mContext);
      this.agkf.removeAllViews();
      this.agkf.setGravity(17);
      this.agkf.addView(this.agka.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.agka.setOptionsArray(aDl(this.agjZ.getValue()));
      if (!this.agki) {
        this.agjZ.setOnValueChangedListener(new c()
        {
          public final void xX(int paramAnonymousInt)
          {
            AppMethodBeat.i(252676);
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
            AppMethodBeat.o(252676);
          }
        });
      }
      if (this.agjY == null) {
        break label603;
      }
      this.agkg.setVisibility(0);
      this.agkb = new CustomOptionPickNew(this.mContext);
      this.agkg.removeAllViews();
      this.agkg.setGravity(17);
      this.agkg.addView(this.agkb.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.agkb.setOptionsArray(aFr(this.agka.getValue()));
      if (!this.agki) {
        this.agka.setOnValueChangedListener(new c()
        {
          public final void xX(int paramAnonymousInt)
          {
            AppMethodBeat.i(252681);
            int k = b.e(b.this).getValue();
            int i = 0;
            int j = 0;
            while (i < k)
            {
              j += ((List)b.d(b.this).get(i)).size();
              i += 1;
            }
            b.c(b.this).setOptionsArray(b.b(b.this, j + paramAnonymousInt));
            AppMethodBeat.o(252681);
          }
        });
      }
    }
    for (;;)
    {
      this.nhC = ((Button)this.rootView.findViewById(a.f.ok_btn));
      this.nhC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject2 = null;
          AppMethodBeat.i(159537);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
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
      this.njI = ((Button)this.rootView.findViewById(a.f.cancel_btn));
      this.njI.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(252683);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          b.a(b.this, false, null, null);
          b.a(b.this, false, null, null, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(252683);
        }
      });
      this.ErU = ((Button)this.rootView.findViewById(a.f.btn_single));
      this.ErU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject2 = null;
          AppMethodBeat.i(252686);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/picker/MMOptionPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
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
            AppMethodBeat.o(252686);
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
      this.Jjv.setContentView(this.rootView);
      this.sRu = bd.fromDPToPix(this.mContext, 420);
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
          AppMethodBeat.i(252685);
          b.f(b.this);
          AppMethodBeat.o(252685);
        }
      });
      AppMethodBeat.o(159542);
      return;
      this.agkf.setVisibility(8);
      break;
      label603:
      this.agkg.setVisibility(8);
    }
  }
  
  public final String[] aDl(int paramInt)
  {
    AppMethodBeat.i(252732);
    if (this.agjX != null)
    {
      Object localObject = (ArrayList)this.agjX.get(paramInt);
      if (localObject != null)
      {
        localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
        AppMethodBeat.o(252732);
        return localObject;
      }
    }
    AppMethodBeat.o(252732);
    return null;
  }
  
  public final void aFb(int paramInt)
  {
    AppMethodBeat.i(252713);
    if (this.njI != null) {
      this.njI.setTextColor(paramInt);
    }
    AppMethodBeat.o(252713);
  }
  
  public final void aFp(int paramInt)
  {
    AppMethodBeat.i(252716);
    if (this.nhC != null) {
      this.nhC.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(252716);
  }
  
  public final void aFq(int paramInt)
  {
    AppMethodBeat.i(159547);
    if (this.agjZ != null)
    {
      this.agjZ.setValue(paramInt);
      this.agjZ.aFo(paramInt);
      if ((this.agka != null) && (this.agjX != null)) {
        this.agka.setOptionsArray(aDl(paramInt));
      }
    }
    AppMethodBeat.o(159547);
  }
  
  public final String[] aFr(int paramInt)
  {
    AppMethodBeat.i(252735);
    if (this.agjY != null)
    {
      Object localObject = (ArrayList)this.agjY.get(paramInt);
      if (localObject != null)
      {
        localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
        AppMethodBeat.o(252735);
        return localObject;
      }
    }
    AppMethodBeat.o(252735);
    return null;
  }
  
  public final void bi(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(252711);
    if (this.nhC != null) {
      this.nhC.setText(paramCharSequence);
    }
    AppMethodBeat.o(252711);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159545);
    if (this.Jjv != null) {
      this.Jjv.dismiss();
    }
    AppMethodBeat.o(159545);
  }
  
  public final int jIz()
  {
    AppMethodBeat.i(159546);
    int i = 0;
    if (this.agjZ != null) {
      i = this.agjZ.getValue();
    }
    AppMethodBeat.o(159546);
    return i;
  }
  
  public final void oY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159548);
    if ((this.agjZ != null) && (this.agka != null))
    {
      this.agjZ.setValue(paramInt1);
      this.agjZ.aFo(paramInt1);
      this.agka.setOptionsArray(aDl(paramInt1));
      this.agka.setValue(paramInt2);
      this.agka.aFo(paramInt2);
      this.agka.invalidate();
    }
    AppMethodBeat.o(159548);
  }
  
  public void onGlobalLayout() {}
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(252718);
    if (this.afbs != null)
    {
      if (paramView == null)
      {
        this.afbs.setVisibility(8);
        AppMethodBeat.o(252718);
        return;
      }
      this.afbs.setVisibility(0);
      this.afbs.removeAllViews();
      this.afbs.setGravity(17);
      this.afbs.addView(paramView, new LinearLayout.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(252718);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159544);
    if (this.Jjv != null) {
      this.Jjv.show();
    }
    AppMethodBeat.o(159544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */