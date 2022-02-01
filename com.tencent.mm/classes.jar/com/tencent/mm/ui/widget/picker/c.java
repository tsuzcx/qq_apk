package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.picker.d.d;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private LinearLayout PTf;
  private Button QSR;
  private String[] QSW;
  private ArrayList<List<String>> QSX;
  private ArrayList<List<String>> QSY;
  private CustomOptionPickNew QSZ;
  public CustomOptionPickNew QTa;
  private CustomOptionPickNew QTb;
  public b QTc;
  private c.a QTd;
  private LinearLayout QTe;
  private LinearLayout QTf;
  private LinearLayout QTg;
  private LinearLayout QTh;
  private boolean QTi;
  private Button hPX;
  private Button hSq;
  private View lJI;
  private Context mContext;
  private int mLJ;
  private BottomSheetBehavior mLK;
  private android.support.design.widget.a yfL;
  
  public c(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(159540);
    this.QSX = null;
    this.QSY = null;
    this.QTi = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.QSW = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    initView();
    AppMethodBeat.o(159540);
  }
  
  public c(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1)
  {
    AppMethodBeat.i(159541);
    this.QSX = null;
    this.QSY = null;
    this.QTi = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.QSW = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.QSX = paramArrayList1;
    initView();
    AppMethodBeat.o(159541);
  }
  
  public c(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1, ArrayList<List<String>> paramArrayList2)
  {
    AppMethodBeat.i(198429);
    this.QSX = null;
    this.QSY = null;
    this.QTi = false;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.QSW = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.QSX = paramArrayList1;
    this.QSY = paramArrayList2;
    this.QTi = false;
    initView();
    AppMethodBeat.o(198429);
  }
  
  public c(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(159539);
    this.QSX = null;
    this.QSY = null;
    this.QTi = false;
    this.mContext = paramContext;
    this.QSW = paramArrayOfString;
    initView();
    AppMethodBeat.o(159539);
  }
  
  private String[] anz(int paramInt)
  {
    AppMethodBeat.i(198437);
    if (this.QSX != null)
    {
      Object localObject = (ArrayList)this.QSX.get(paramInt);
      if (localObject != null)
      {
        localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
        AppMethodBeat.o(198437);
        return localObject;
      }
    }
    AppMethodBeat.o(198437);
    return null;
  }
  
  private String[] apq(int paramInt)
  {
    AppMethodBeat.i(198438);
    if (this.QSY != null)
    {
      Object localObject = (ArrayList)this.QSY.get(paramInt);
      if (localObject != null)
      {
        localObject = (String[])((ArrayList)localObject).toArray(new String[((ArrayList)localObject).size()]);
        AppMethodBeat.o(198438);
        return localObject;
      }
    }
    AppMethodBeat.o(198438);
    return null;
  }
  
  private void initView()
  {
    AppMethodBeat.i(159542);
    this.yfL = new android.support.design.widget.a(this.mContext);
    this.lJI = View.inflate(this.mContext, 2131495893, null);
    this.PTf = ((LinearLayout)this.lJI.findViewById(2131305649));
    this.QTh = ((LinearLayout)this.lJI.findViewById(2131305648));
    this.QTe = ((LinearLayout)this.lJI.findViewById(2131305647));
    this.QSZ = new CustomOptionPickNew(this.mContext);
    this.QSZ.setOptionsArray(this.QSW);
    this.QTe.removeAllViews();
    this.QTe.setGravity(17);
    this.QTe.addView(this.QSZ.getView(), new LinearLayout.LayoutParams(-2, -1));
    this.QTf = ((LinearLayout)this.lJI.findViewById(2131305650));
    this.QTg = ((LinearLayout)this.lJI.findViewById(2131305651));
    if (this.QSX != null)
    {
      this.QTf.setVisibility(0);
      this.QTa = new CustomOptionPickNew(this.mContext);
      this.QTf.removeAllViews();
      this.QTf.setGravity(17);
      this.QTf.addView(this.QTa.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.QTa.setOptionsArray(anz(this.QSZ.getValue()));
      if (!this.QTi) {
        this.QSZ.setOnValueChangedListener(new d()
        {
          public final void uO(int paramAnonymousInt)
          {
            AppMethodBeat.i(198424);
            c.a(c.this).setOptionsArray(c.a(c.this, paramAnonymousInt));
            if ((c.b(c.this) != null) && (c.c(c.this) != null))
            {
              int j = 0;
              int i = 0;
              while (j < paramAnonymousInt)
              {
                i += ((List)c.d(c.this).get(j)).size();
                j += 1;
              }
              paramAnonymousInt = c.a(c.this).getValue();
              c.c(c.this).setOptionsArray(c.b(c.this, paramAnonymousInt + i));
            }
            AppMethodBeat.o(198424);
          }
        });
      }
      if (this.QSY == null) {
        break label594;
      }
      this.QTg.setVisibility(0);
      this.QTb = new CustomOptionPickNew(this.mContext);
      this.QTg.removeAllViews();
      this.QTg.setGravity(17);
      this.QTg.addView(this.QTb.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.QTb.setOptionsArray(apq(this.QTa.getValue()));
      if (!this.QTi) {
        this.QTa.setOnValueChangedListener(new d()
        {
          public final void uO(int paramAnonymousInt)
          {
            AppMethodBeat.i(198425);
            int k = c.e(c.this).getValue();
            int i = 0;
            int j = 0;
            while (i < k)
            {
              j += ((List)c.d(c.this).get(i)).size();
              i += 1;
            }
            c.c(c.this).setOptionsArray(c.b(c.this, j + paramAnonymousInt));
            AppMethodBeat.o(198425);
          }
        });
      }
    }
    for (;;)
    {
      this.hPX = ((Button)this.lJI.findViewById(2131305592));
      this.hPX.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject2 = null;
          AppMethodBeat.i(159537);
          Object localObject1 = new b();
          ((b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
          c localc = c.this;
          if (c.e(c.this) == null)
          {
            paramAnonymousView = null;
            if (c.a(c.this) != null) {
              break label155;
            }
            localObject1 = null;
            label66:
            c.a(localc, true, paramAnonymousView, localObject1);
            localc = c.this;
            if (c.e(c.this) != null) {
              break label169;
            }
            paramAnonymousView = null;
            label92:
            if (c.a(c.this) != null) {
              break label183;
            }
            localObject1 = null;
            label104:
            if (c.c(c.this) != null) {
              break label197;
            }
          }
          for (;;)
          {
            c.a(localc, true, paramAnonymousView, localObject1, localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(159537);
            return;
            paramAnonymousView = c.e(c.this).currentValue();
            break;
            label155:
            localObject1 = c.a(c.this).currentValue();
            break label66;
            label169:
            paramAnonymousView = c.e(c.this).currentValue();
            break label92;
            label183:
            localObject1 = c.a(c.this).currentValue();
            break label104;
            label197:
            localObject2 = c.c(c.this).currentValue();
          }
        }
      });
      this.hSq = ((Button)this.lJI.findViewById(2131297963));
      this.hSq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198426);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          c.a(c.this, false, null, null);
          c.a(c.this, false, null, null, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198426);
        }
      });
      this.QSR = ((Button)this.lJI.findViewById(2131297850));
      this.QSR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject2 = null;
          AppMethodBeat.i(198427);
          Object localObject1 = new b();
          ((b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/picker/MMOptionPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
          c localc = c.this;
          if (c.e(c.this) == null)
          {
            paramAnonymousView = null;
            if (c.a(c.this) != null) {
              break label155;
            }
            localObject1 = null;
            label66:
            c.a(localc, true, paramAnonymousView, localObject1);
            localc = c.this;
            if (c.e(c.this) != null) {
              break label169;
            }
            paramAnonymousView = null;
            label92:
            if (c.a(c.this) != null) {
              break label183;
            }
            localObject1 = null;
            label104:
            if (c.c(c.this) != null) {
              break label197;
            }
          }
          for (;;)
          {
            c.a(localc, true, paramAnonymousView, localObject1, localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/picker/MMOptionPicker$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198427);
            return;
            paramAnonymousView = c.e(c.this).currentValue();
            break;
            label155:
            localObject1 = c.a(c.this).currentValue();
            break label66;
            label169:
            paramAnonymousView = c.e(c.this).currentValue();
            break label92;
            label183:
            localObject1 = c.a(c.this).currentValue();
            break label104;
            label197:
            localObject2 = c.c(c.this).currentValue();
          }
        }
      });
      this.yfL.setContentView(this.lJI);
      this.mLJ = at.fromDPToPix(this.mContext, 420);
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
          AppMethodBeat.i(198428);
          c.f(c.this);
          AppMethodBeat.o(198428);
        }
      });
      AppMethodBeat.o(159542);
      return;
      this.QTf.setVisibility(8);
      break;
      label594:
      this.QTg.setVisibility(8);
    }
  }
  
  public final void a(c.a parama)
  {
    this.QTd = parama;
  }
  
  public final void aF(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(198430);
    if (this.hPX != null) {
      this.hPX.setText(paramCharSequence);
    }
    AppMethodBeat.o(198430);
  }
  
  public final void apd(int paramInt)
  {
    AppMethodBeat.i(198431);
    if (this.hSq != null) {
      this.hSq.setTextColor(paramInt);
    }
    AppMethodBeat.o(198431);
  }
  
  public final void app(int paramInt)
  {
    AppMethodBeat.i(159547);
    if (this.QSZ != null)
    {
      this.QSZ.setValue(paramInt);
      this.QSZ.apo(paramInt);
      if ((this.QTa != null) && (this.QSX != null)) {
        this.QTa.setOptionsArray(anz(paramInt));
      }
    }
    AppMethodBeat.o(159547);
  }
  
  public final void hcg()
  {
    AppMethodBeat.i(198432);
    if (this.hPX != null) {
      this.hPX.setBackgroundResource(2131232579);
    }
    AppMethodBeat.o(198432);
  }
  
  public final void hch()
  {
    AppMethodBeat.i(198433);
    if (this.hPX != null)
    {
      this.hPX.setTextColor(this.mContext.getResources().getColor(2131100194));
      this.hPX.setBackgroundResource(2131231434);
    }
    AppMethodBeat.o(198433);
  }
  
  public final int hci()
  {
    AppMethodBeat.i(159546);
    int i = 0;
    if (this.QSZ != null) {
      i = this.QSZ.getValue();
    }
    AppMethodBeat.o(159546);
    return i;
  }
  
  public final void hcj()
  {
    AppMethodBeat.i(198436);
    if ((this.QSZ != null) && (this.QTa != null) && (this.QTb != null))
    {
      this.QSZ.setValue(1);
      this.QSZ.apo(1);
      this.QTa.setOptionsArray(anz(1));
      this.QTa.setValue(12);
      this.QTa.apo(12);
      this.QTa.invalidate();
      this.QTb.setOptionsArray(apq(12));
      this.QTb.setValue(0);
      this.QTb.apo(0);
      this.QTb.invalidate();
    }
    AppMethodBeat.o(198436);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159545);
    if (this.yfL != null) {
      this.yfL.dismiss();
    }
    AppMethodBeat.o(159545);
  }
  
  public final void lM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159548);
    if ((this.QSZ != null) && (this.QTa != null))
    {
      this.QSZ.setValue(paramInt1);
      this.QSZ.apo(paramInt1);
      this.QTa.setOptionsArray(anz(paramInt1));
      this.QTa.setValue(paramInt2);
      this.QTa.apo(paramInt2);
      this.QTa.invalidate();
    }
    AppMethodBeat.o(159548);
  }
  
  public final void onGlobalLayout() {}
  
  public final void setFooterView(View paramView)
  {
    AppMethodBeat.i(198435);
    if (this.QTh != null)
    {
      if (paramView == null)
      {
        this.QTh.setVisibility(8);
        AppMethodBeat.o(198435);
        return;
      }
      this.QTh.setVisibility(0);
      this.QTh.removeAllViews();
      this.QTh.setGravity(17);
      this.QTh.addView(paramView, new LinearLayout.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(198435);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(198434);
    if (this.PTf != null)
    {
      if (paramView == null)
      {
        this.PTf.setVisibility(8);
        AppMethodBeat.o(198434);
        return;
      }
      this.PTf.setVisibility(0);
      this.PTf.removeAllViews();
      this.PTf.setGravity(17);
      this.PTf.addView(paramView, new LinearLayout.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(198434);
  }
  
  public final void show()
  {
    AppMethodBeat.i(159544);
    if (this.yfL != null) {
      this.yfL.show();
    }
    AppMethodBeat.o(159544);
  }
  
  public static abstract interface b<T>
  {
    public abstract void onResult(boolean paramBoolean, T paramT1, T paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */