package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.picker.d.d;
import java.util.ArrayList;
import java.util.List;

public final class c
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public LinearLayout GSX;
  private Button HIN;
  private String[] HIS;
  private ArrayList<List<String>> HIT;
  private CustomOptionPickNew HIU;
  public CustomOptionPickNew HIV;
  public c.a HIW;
  private LinearLayout HIX;
  private LinearLayout HIY;
  private Button hJg;
  private Button hJh;
  private View jGG;
  private int kBk;
  private BottomSheetBehavior kBl;
  private Context mContext;
  private a sri;
  
  public c(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(159540);
    this.HIT = null;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.HIS = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    initView();
    AppMethodBeat.o(159540);
  }
  
  public c(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1)
  {
    AppMethodBeat.i(159541);
    this.HIT = null;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.HIS = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.HIT = paramArrayList1;
    initView();
    AppMethodBeat.o(159541);
  }
  
  public c(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(159539);
    this.HIT = null;
    this.mContext = paramContext;
    this.HIS = paramArrayOfString;
    initView();
    AppMethodBeat.o(159539);
  }
  
  private String[] aaS(int paramInt)
  {
    AppMethodBeat.i(159549);
    if (this.HIT != null)
    {
      Object localObject = (ArrayList)this.HIT.get(paramInt);
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
    this.sri = new a(this.mContext);
    this.jGG = View.inflate(this.mContext, 2131495059, null);
    this.GSX = ((LinearLayout)this.jGG.findViewById(2131307217));
    this.HIX = ((LinearLayout)this.jGG.findViewById(2131303044));
    this.HIU = new CustomOptionPickNew(this.mContext);
    this.HIU.setOptionsArray(this.HIS);
    this.HIX.removeAllViews();
    this.HIX.setGravity(17);
    this.HIX.addView(this.HIU.getView(), new LinearLayout.LayoutParams(-2, -1));
    this.HIY = ((LinearLayout)this.jGG.findViewById(2131303045));
    if (this.HIT != null)
    {
      this.HIY.setVisibility(0);
      this.HIV = new CustomOptionPickNew(this.mContext);
      this.HIY.removeAllViews();
      this.HIY.setGravity(17);
      this.HIY.addView(this.HIV.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.HIV.setOptionsArray(aaS(this.HIU.getValue()));
      this.HIU.setOnValueChangedListener(new d()
      {
        public final void pG(int paramAnonymousInt)
        {
          AppMethodBeat.i(195292);
          c.a(c.this).setOptionsArray(c.a(c.this, paramAnonymousInt));
          AppMethodBeat.o(195292);
        }
      });
    }
    for (;;)
    {
      this.hJh = ((Button)this.jGG.findViewById(2131302999));
      this.hJh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject = null;
          AppMethodBeat.i(159536);
          c localc = c.this;
          if (c.b(c.this) == null)
          {
            paramAnonymousView = null;
            if (c.a(c.this) != null) {
              break label61;
            }
          }
          for (;;)
          {
            c.a(localc, true, paramAnonymousView, localObject);
            AppMethodBeat.o(159536);
            return;
            paramAnonymousView = c.b(c.this).currentValue();
            break;
            label61:
            localObject = c.a(c.this).currentValue();
          }
        }
      });
      this.hJg = ((Button)this.jGG.findViewById(2131297690));
      this.hJg.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159537);
          c.a(c.this, false, null, null);
          AppMethodBeat.o(159537);
        }
      });
      this.HIN = ((Button)this.jGG.findViewById(2131297600));
      this.HIN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject = null;
          AppMethodBeat.i(195293);
          c localc = c.this;
          if (c.b(c.this) == null)
          {
            paramAnonymousView = null;
            if (c.a(c.this) != null) {
              break label61;
            }
          }
          for (;;)
          {
            c.a(localc, true, paramAnonymousView, localObject);
            AppMethodBeat.o(195293);
            return;
            paramAnonymousView = c.b(c.this).currentValue();
            break;
            label61:
            localObject = c.a(c.this).currentValue();
          }
        }
      });
      this.sri.setContentView(this.jGG);
      this.kBk = ao.fromDPToPix(this.mContext, 420);
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
          AppMethodBeat.i(195294);
          c.c(c.this);
          AppMethodBeat.o(195294);
        }
      });
      AppMethodBeat.o(159542);
      return;
      this.HIY.setVisibility(8);
    }
  }
  
  public final void aaR(int paramInt)
  {
    AppMethodBeat.i(159547);
    if (this.HIU != null)
    {
      this.HIU.setValue(paramInt);
      this.HIU.aaQ(paramInt);
      if ((this.HIV != null) && (this.HIT != null)) {
        this.HIV.setOptionsArray(aaS(paramInt));
      }
    }
    AppMethodBeat.o(159547);
  }
  
  public final int ffZ()
  {
    AppMethodBeat.i(159546);
    int i = 0;
    if (this.HIU != null) {
      i = this.HIU.getValue();
    }
    AppMethodBeat.o(159546);
    return i;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159545);
    if (this.sri != null) {
      this.sri.dismiss();
    }
    AppMethodBeat.o(159545);
  }
  
  public final void jL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159548);
    if ((this.HIU != null) && (this.HIV != null))
    {
      this.HIU.setValue(paramInt1);
      this.HIU.aaQ(paramInt1);
      this.HIV.setOptionsArray(aaS(paramInt1));
      this.HIV.setValue(paramInt2);
      this.HIV.aaQ(paramInt2);
      this.HIV.invalidate();
    }
    AppMethodBeat.o(159548);
  }
  
  public final void onGlobalLayout() {}
  
  public final void show()
  {
    AppMethodBeat.i(159544);
    if (this.sri != null) {
      this.sri.show();
    }
    AppMethodBeat.o(159544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */