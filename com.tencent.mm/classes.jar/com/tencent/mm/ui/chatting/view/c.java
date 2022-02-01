package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.j.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class c
{
  com.google.android.material.bottomsheet.a DpN;
  OptionPicker XbN;
  OptionPicker XbO;
  public a XbP;
  ArrayList<Long> XbQ;
  private Button kEt;
  private Button kGN;
  Context mContext;
  private View oFW;
  private int pMB;
  private BottomSheetBehavior pMC;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(36725);
    this.XbQ = new ArrayList(42);
    this.mContext = paramContext;
    this.oFW = View.inflate(this.mContext, R.i.ekv, null);
    this.DpN = new com.google.android.material.bottomsheet.a(this.mContext);
    this.DpN.setContentView(this.oFW);
    this.DpN.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.DpN = null;
      }
    });
    this.XbN = ((OptionPicker)this.oFW.findViewById(R.h.dQF));
    this.XbO = ((OptionPicker)this.oFW.findViewById(R.h.option_second_picker));
    this.XbN.setValue(0);
    this.XbN.setMinWidth(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 60));
    this.XbO.setMinWidth(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 60));
    this.XbN.setOptionsArray(hTC());
    this.XbO.setOptionsArray(awD(0));
    this.XbN.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36722);
        Log.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.this.XbO.setOptionsArray(c.this.awD(paramAnonymousInt2));
        paramAnonymousInt1 = Calendar.getInstance().get(11);
        if (paramAnonymousInt2 == 0)
        {
          c.this.XbO.setValue(0);
          AppMethodBeat.o(36722);
          return;
        }
        c.this.XbO.setValue(paramAnonymousInt1);
        AppMethodBeat.o(36722);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.oFW.getLayoutParams();
    paramContext.height = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 288);
    this.oFW.setLayoutParams(paramContext);
    this.pMB = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 350);
    this.pMC = BottomSheetBehavior.cg((View)this.oFW.getParent());
    if (this.pMC != null)
    {
      this.pMC.D(this.pMB);
      this.pMC.bxz = false;
    }
    this.kEt = ((Button)this.oFW.findViewById(R.h.ok_btn));
    this.kEt.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36723);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        long l;
        int i;
        int j;
        if (c.this.XbP != null)
        {
          paramAnonymousView = c.this.XbP;
          localObject = c.this;
          l = System.currentTimeMillis();
          i = ((c)localObject).XbN.getValue();
          j = ((c)localObject).XbO.getValue();
          if (i != 0) {
            break label196;
          }
          if (!CrashReportFactory.hasDebuger()) {
            break label180;
          }
          l += 30000L;
        }
        for (;;)
        {
          Log.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", new Object[] { f.formatTime(((c)localObject).mContext.getString(R.l.fmt_longdate_with_full) + "HH:mm", l / 1000L) });
          paramAnonymousView.VB(l);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36723);
          return;
          label180:
          l += (j + 1) * 3600000L;
          continue;
          label196:
          l = ((Long)((c)localObject).XbQ.get(i)).longValue() + (j + 1) * 3600000L;
        }
      }
    });
    this.kGN = ((Button)this.oFW.findViewById(R.h.cancel_btn));
    this.kGN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36724);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (c.this.XbP != null) {
          c.this.XbP.onCancel();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(36724);
      }
    });
    AppMethodBeat.o(36725);
  }
  
  private String[] hTC()
  {
    int j = 0;
    AppMethodBeat.i(36729);
    this.XbQ.clear();
    Object localObject = new ArrayList();
    Calendar localCalendar = Calendar.getInstance();
    int i = 0;
    if (i < localCalendar.getActualMaximum(5))
    {
      if ((CrashReportFactory.hasDebuger()) && (i == 0))
      {
        ((ArrayList)localObject).add("test");
        this.XbQ.add(Long.valueOf(localCalendar.getTimeInMillis()));
      }
      label109:
      String str;
      if (i == 0)
      {
        localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L * i);
        this.XbQ.add(Long.valueOf(localCalendar.getTimeInMillis()));
        str = f.formatTime(this.mContext.getString(R.l.fmt_date), localCalendar.getTimeInMillis() / 1000L);
        if (i != 0) {
          break label229;
        }
        ((ArrayList)localObject).add(this.mContext.getResources().getString(R.l.fmt_pre_nowday));
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
        this.XbQ.add(Long.valueOf(localCalendar.getTimeInMillis()));
        break label109;
        label229:
        if (i == 1) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(R.l.fmt_pre_tomorrow));
        } else if (i == 2) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(R.l.fmt_pre_dayaftertomorrow));
        } else {
          ((ArrayList)localObject).add(str + " " + f.aS(this.mContext, localCalendar.get(7)));
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
        this.XbQ.add(Long.valueOf(localCalendar.getTimeInMillis()));
        ((ArrayList)localObject).add(String.valueOf(f.formatTime(this.mContext.getString(R.l.fmt_longdate_with_full), localCalendar.getTimeInMillis() / 1000L)));
        i += 1;
        break;
        localCalendar.set(2, m + i);
      }
    }
    localObject = Util.listToStrings((List)localObject);
    AppMethodBeat.o(36729);
    return localObject;
  }
  
  final String[] awD(int paramInt)
  {
    AppMethodBeat.i(36728);
    ArrayList localArrayList = new ArrayList();
    int i;
    label50:
    StringBuilder localStringBuilder;
    if (CrashReportFactory.hasDebuger())
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
      localArrayList.add("after 30 second");
      for (;;)
      {
        localObject = Util.listToStrings(localArrayList);
        AppMethodBeat.o(36728);
        return localObject;
        i = Calendar.getInstance().get(11);
        paramInt = 1;
        while (paramInt <= 24 - i)
        {
          localArrayList.add(this.mContext.getResources().getString(R.l.eod, new Object[] { Integer.valueOf(paramInt) }));
          paramInt += 1;
        }
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(36727);
    if (this.DpN != null) {
      this.DpN.dismiss();
    }
    AppMethodBeat.o(36727);
  }
  
  public final void show()
  {
    AppMethodBeat.i(36726);
    if (this.DpN != null) {
      this.DpN.show();
    }
    AppMethodBeat.o(36726);
  }
  
  public static abstract interface a
  {
    public abstract void VB(long paramLong);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.c
 * JD-Core Version:    0.7.0.1
 */