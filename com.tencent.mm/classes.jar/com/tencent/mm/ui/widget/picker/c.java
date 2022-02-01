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
  public LinearLayout Itj;
  private Button Jjk;
  private String[] Jjp;
  private ArrayList<List<String>> Jjq;
  private CustomOptionPickNew Jjr;
  public CustomOptionPickNew Jjs;
  public c.a Jjt;
  private LinearLayout Jju;
  private LinearLayout Jjv;
  private Button gAJ;
  private Button gCY;
  private View khe;
  private int lcC;
  private BottomSheetBehavior lcD;
  private Context mContext;
  private a tyZ;
  
  public c(Context paramContext, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(159540);
    this.Jjq = null;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.Jjp = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    initView();
    AppMethodBeat.o(159540);
  }
  
  public c(Context paramContext, ArrayList<String> paramArrayList, ArrayList<List<String>> paramArrayList1)
  {
    AppMethodBeat.i(159541);
    this.Jjq = null;
    this.mContext = paramContext;
    if (paramArrayList != null) {
      this.Jjp = ((String[])paramArrayList.toArray(new String[paramArrayList.size()]));
    }
    this.Jjq = paramArrayList1;
    initView();
    AppMethodBeat.o(159541);
  }
  
  public c(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(159539);
    this.Jjq = null;
    this.mContext = paramContext;
    this.Jjp = paramArrayOfString;
    initView();
    AppMethodBeat.o(159539);
  }
  
  private String[] ade(int paramInt)
  {
    AppMethodBeat.i(159549);
    if (this.Jjq != null)
    {
      Object localObject = (ArrayList)this.Jjq.get(paramInt);
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
    this.tyZ = new a(this.mContext);
    this.khe = View.inflate(this.mContext, 2131495059, null);
    this.Itj = ((LinearLayout)this.khe.findViewById(2131307217));
    this.Jju = ((LinearLayout)this.khe.findViewById(2131303044));
    this.Jjr = new CustomOptionPickNew(this.mContext);
    this.Jjr.setOptionsArray(this.Jjp);
    this.Jju.removeAllViews();
    this.Jju.setGravity(17);
    this.Jju.addView(this.Jjr.getView(), new LinearLayout.LayoutParams(-2, -1));
    this.Jjv = ((LinearLayout)this.khe.findViewById(2131303045));
    if (this.Jjq != null)
    {
      this.Jjv.setVisibility(0);
      this.Jjs = new CustomOptionPickNew(this.mContext);
      this.Jjv.removeAllViews();
      this.Jjv.setGravity(17);
      this.Jjv.addView(this.Jjs.getView(), new LinearLayout.LayoutParams(-2, -1));
      this.Jjs.setOptionsArray(ade(this.Jjr.getValue()));
      this.Jjr.setOnValueChangedListener(new d()
      {
        public final void qt(int paramAnonymousInt)
        {
          AppMethodBeat.i(199762);
          c.a(c.this).setOptionsArray(c.a(c.this, paramAnonymousInt));
          AppMethodBeat.o(199762);
        }
      });
    }
    for (;;)
    {
      this.gAJ = ((Button)this.khe.findViewById(2131302999));
      this.gAJ.setOnClickListener(new View.OnClickListener()
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
      this.gCY = ((Button)this.khe.findViewById(2131297690));
      this.gCY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159537);
          c.a(c.this, false, null, null);
          AppMethodBeat.o(159537);
        }
      });
      this.Jjk = ((Button)this.khe.findViewById(2131297600));
      this.Jjk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          Object localObject = null;
          AppMethodBeat.i(199763);
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
            AppMethodBeat.o(199763);
            return;
            paramAnonymousView = c.b(c.this).currentValue();
            break;
            label61:
            localObject = c.a(c.this).currentValue();
          }
        }
      });
      this.tyZ.setContentView(this.khe);
      this.lcC = ao.fromDPToPix(this.mContext, 420);
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
          AppMethodBeat.i(199764);
          c.c(c.this);
          AppMethodBeat.o(199764);
        }
      });
      AppMethodBeat.o(159542);
      return;
      this.Jjv.setVisibility(8);
    }
  }
  
  public final void adc(int paramInt)
  {
    AppMethodBeat.i(159547);
    if (this.Jjr != null)
    {
      this.Jjr.setValue(paramInt);
      this.Jjr.adb(paramInt);
      if ((this.Jjs != null) && (this.Jjq != null)) {
        this.Jjs.setOptionsArray(ade(paramInt));
      }
    }
    AppMethodBeat.o(159547);
  }
  
  public final int fvY()
  {
    AppMethodBeat.i(159546);
    int i = 0;
    if (this.Jjr != null) {
      i = this.Jjr.getValue();
    }
    AppMethodBeat.o(159546);
    return i;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(159545);
    if (this.tyZ != null) {
      this.tyZ.dismiss();
    }
    AppMethodBeat.o(159545);
  }
  
  public final void jX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159548);
    if ((this.Jjr != null) && (this.Jjs != null))
    {
      this.Jjr.setValue(paramInt1);
      this.Jjr.adb(paramInt1);
      this.Jjs.setOptionsArray(ade(paramInt1));
      this.Jjs.setValue(paramInt2);
      this.Jjs.adb(paramInt2);
      this.Jjs.invalidate();
    }
    AppMethodBeat.o(159548);
  }
  
  public final void onGlobalLayout() {}
  
  public final void show()
  {
    AppMethodBeat.i(159544);
    if (this.tyZ != null) {
      this.tyZ.show();
    }
    AppMethodBeat.o(159544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */