package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class c
{
  OptionPicker JXO;
  OptionPicker JXP;
  public a JXQ;
  ArrayList<Long> JXR;
  private Button gUt;
  private Button gWI;
  private View kBS;
  private int lzC;
  private BottomSheetBehavior lzD;
  Context mContext;
  android.support.design.widget.a uBI;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(36725);
    this.JXR = new ArrayList(42);
    this.mContext = paramContext;
    this.kBS = View.inflate(this.mContext, 2131495247, null);
    this.uBI = new android.support.design.widget.a(this.mContext);
    this.uBI.setContentView(this.kBS);
    this.uBI.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.uBI = null;
      }
    });
    this.JXO = ((OptionPicker)this.kBS.findViewById(2131303043));
    this.JXP = ((OptionPicker)this.kBS.findViewById(2131303045));
    this.JXO.setValue(0);
    this.JXO.setMinWidth(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 60));
    this.JXP.setMinWidth(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 60));
    this.JXO.setOptionsArray(fHf());
    this.JXP.setOptionsArray(aef(0));
    this.JXO.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36722);
        ad.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.this.JXP.setOptionsArray(c.this.aef(paramAnonymousInt2));
        paramAnonymousInt1 = Calendar.getInstance().get(11);
        if (paramAnonymousInt2 == 0)
        {
          c.this.JXP.setValue(0);
          AppMethodBeat.o(36722);
          return;
        }
        c.this.JXP.setValue(paramAnonymousInt1);
        AppMethodBeat.o(36722);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.kBS.getLayoutParams();
    paramContext.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 288);
    this.kBS.setLayoutParams(paramContext);
    this.lzC = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 350);
    this.lzD = BottomSheetBehavior.l((View)this.kBS.getParent());
    if (this.lzD != null)
    {
      this.lzD.J(this.lzC);
      this.lzD.nZ = false;
    }
    this.gUt = ((Button)this.kBS.findViewById(2131302999));
    this.gUt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36723);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        long l;
        int i;
        int j;
        if (c.this.JXQ != null)
        {
          paramAnonymousView = c.this.JXQ;
          localObject = c.this;
          l = System.currentTimeMillis();
          i = ((c)localObject).JXO.getValue();
          j = ((c)localObject).JXP.getValue();
          if (i != 0) {
            break label195;
          }
          if (!com.tencent.mm.sdk.a.b.fjN()) {
            break label179;
          }
          l += 360000L;
        }
        for (;;)
        {
          ad.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", new Object[] { i.formatTime(((c)localObject).mContext.getString(2131759518) + "HH:mm", l / 1000L) });
          paramAnonymousView.DQ(l);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36723);
          return;
          label179:
          l += (j + 1) * 3600000L;
          continue;
          label195:
          l = ((Long)((c)localObject).JXR.get(i)).longValue() + (j + 1) * 3600000L;
        }
      }
    });
    this.gWI = ((Button)this.kBS.findViewById(2131297690));
    this.gWI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36724);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (c.this.JXQ != null) {
          c.this.JXQ.onCancel();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(36724);
      }
    });
    AppMethodBeat.o(36725);
  }
  
  private String[] fHf()
  {
    int j = 0;
    AppMethodBeat.i(36729);
    this.JXR.clear();
    Object localObject = new ArrayList();
    Calendar localCalendar = Calendar.getInstance();
    int i = 0;
    if (i < localCalendar.getActualMaximum(5))
    {
      if ((com.tencent.mm.sdk.a.b.fjN()) && (i == 0))
      {
        ((ArrayList)localObject).add("test");
        this.JXR.add(Long.valueOf(localCalendar.getTimeInMillis()));
      }
      label109:
      String str;
      if (i == 0)
      {
        localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L * i);
        this.JXR.add(Long.valueOf(localCalendar.getTimeInMillis()));
        str = i.formatTime(this.mContext.getString(2131759498), localCalendar.getTimeInMillis() / 1000L);
        if (i != 0) {
          break label227;
        }
        ((ArrayList)localObject).add(this.mContext.getResources().getString(2131759542));
      }
      for (;;)
      {
        i += 1;
        break;
        localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L * i);
        localCalendar.set(11, 0);
        localCalendar.set(12, 0);
        localCalendar.set(13, 0);
        localCalendar.set(14, 0);
        this.JXR.add(Long.valueOf(localCalendar.getTimeInMillis()));
        break label109;
        label227:
        if (i == 1) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(2131759543));
        } else if (i == 2) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(2131759533));
        } else {
          ((ArrayList)localObject).add(str + " " + i.ar(this.mContext, localCalendar.get(7)));
        }
      }
    }
    int k = localCalendar.get(1);
    int m = localCalendar.get(2) + 1;
    i = j;
    if (i < 12)
    {
      if (m + i > 12)
      {
        localCalendar.set(1, k + 1);
        localCalendar.set(2, m + i - 12);
      }
      for (;;)
      {
        localCalendar.set(5, 1);
        this.JXR.add(Long.valueOf(localCalendar.getTimeInMillis()));
        ((ArrayList)localObject).add(String.valueOf(i.formatTime(this.mContext.getString(2131759518), localCalendar.getTimeInMillis() / 1000L)));
        i += 1;
        break;
        localCalendar.set(2, m + i);
      }
    }
    localObject = bt.hi((List)localObject);
    AppMethodBeat.o(36729);
    return localObject;
  }
  
  final String[] aef(int paramInt)
  {
    AppMethodBeat.i(36728);
    ArrayList localArrayList = new ArrayList();
    int i;
    label50:
    StringBuilder localStringBuilder;
    if (com.tencent.mm.sdk.a.b.fjN())
    {
      i = 1;
      switch (paramInt - i)
      {
      default: 
        paramInt = 1;
        if (paramInt <= 24)
        {
          localStringBuilder = new StringBuilder();
          if (paramInt >= 10) {
            break label194;
          }
        }
        break;
      }
    }
    label194:
    for (Object localObject = "0".concat(String.valueOf(paramInt));; localObject = Integer.valueOf(paramInt))
    {
      localArrayList.add(localObject + ":00");
      paramInt += 1;
      break label50;
      i = 0;
      break;
      localArrayList.add("after 6 min");
      for (;;)
      {
        localObject = bt.hi(localArrayList);
        AppMethodBeat.o(36728);
        return localObject;
        i = Calendar.getInstance().get(11);
        paramInt = 1;
        while (paramInt <= 24 - i)
        {
          localArrayList.add(this.mContext.getResources().getString(2131755245, new Object[] { Integer.valueOf(paramInt) }));
          paramInt += 1;
        }
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(36727);
    if (this.uBI != null) {
      this.uBI.dismiss();
    }
    AppMethodBeat.o(36727);
  }
  
  public final void show()
  {
    AppMethodBeat.i(36726);
    if (this.uBI != null) {
      this.uBI.show();
    }
    AppMethodBeat.o(36726);
  }
  
  public static abstract interface a
  {
    public abstract void DQ(long paramLong);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.c
 * JD-Core Version:    0.7.0.1
 */