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
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class c
{
  com.google.android.material.bottomsheet.a Jjv;
  OptionPicker aeLv;
  OptionPicker aeLw;
  public a aeLx;
  ArrayList<Long> aeLy;
  Context mContext;
  private Button nhC;
  private Button njI;
  private View rootView;
  private int sRu;
  private BottomSheetBehavior sRv;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(36725);
    this.aeLy = new ArrayList(42);
    this.mContext = paramContext;
    this.rootView = View.inflate(this.mContext, R.i.gnA, null);
    this.Jjv = new com.google.android.material.bottomsheet.a(this.mContext);
    this.Jjv.setContentView(this.rootView);
    this.Jjv.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.Jjv = null;
      }
    });
    this.aeLv = ((OptionPicker)this.rootView.findViewById(R.h.fSK));
    this.aeLw = ((OptionPicker)this.rootView.findViewById(R.h.option_second_picker));
    this.aeLv.setValue(0);
    this.aeLv.setMinWidth(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 60));
    this.aeLw.setMinWidth(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 60));
    this.aeLv.setOptionsArray(jxf());
    this.aeLw.setOptionsArray(aDl(0));
    this.aeLv.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36722);
        Log.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.this.aeLw.setOptionsArray(c.this.aDl(paramAnonymousInt2));
        paramAnonymousInt1 = Calendar.getInstance().get(11);
        if (paramAnonymousInt2 == 0)
        {
          c.this.aeLw.setValue(0);
          AppMethodBeat.o(36722);
          return;
        }
        c.this.aeLw.setValue(paramAnonymousInt1);
        AppMethodBeat.o(36722);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.rootView.getLayoutParams();
    paramContext.height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 288);
    this.rootView.setLayoutParams(paramContext);
    this.sRu = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 350);
    this.sRv = BottomSheetBehavior.cC((View)this.rootView.getParent());
    if (this.sRv != null)
    {
      this.sRv.setPeekHeight(this.sRu);
      this.sRv.dqC = false;
    }
    this.nhC = ((Button)this.rootView.findViewById(R.h.ok_btn));
    this.nhC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36723);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        long l;
        int i;
        int j;
        if (c.this.aeLx != null)
        {
          paramAnonymousView = c.this.aeLx;
          localObject = c.this;
          l = System.currentTimeMillis();
          i = ((c)localObject).aeLv.getValue();
          j = ((c)localObject).aeLw.getValue();
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
          paramAnonymousView.zJ(l);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36723);
          return;
          label180:
          l += (j + 1) * 3600000L;
          continue;
          label196:
          l = ((Long)((c)localObject).aeLy.get(i)).longValue() + (j + 1) * 3600000L;
        }
      }
    });
    this.njI = ((Button)this.rootView.findViewById(R.h.cancel_btn));
    this.njI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36724);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (c.this.aeLx != null) {
          c.this.aeLx.onCancel();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(36724);
      }
    });
    AppMethodBeat.o(36725);
  }
  
  private String[] jxf()
  {
    int j = 0;
    AppMethodBeat.i(36729);
    this.aeLy.clear();
    Object localObject = new ArrayList();
    Calendar localCalendar = Calendar.getInstance();
    int i = 0;
    if (i < localCalendar.getActualMaximum(5))
    {
      if ((CrashReportFactory.hasDebuger()) && (i == 0))
      {
        ((ArrayList)localObject).add("test");
        this.aeLy.add(Long.valueOf(localCalendar.getTimeInMillis()));
      }
      label109:
      String str;
      if (i == 0)
      {
        localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L * i);
        this.aeLy.add(Long.valueOf(localCalendar.getTimeInMillis()));
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
        this.aeLy.add(Long.valueOf(localCalendar.getTimeInMillis()));
        break label109;
        label229:
        if (i == 1) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(R.l.fmt_pre_tomorrow));
        } else if (i == 2) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(R.l.fmt_pre_dayaftertomorrow));
        } else {
          ((ArrayList)localObject).add(str + " " + f.bl(this.mContext, localCalendar.get(7)));
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
        this.aeLy.add(Long.valueOf(localCalendar.getTimeInMillis()));
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
  
  final String[] aDl(int paramInt)
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
          localArrayList.add(this.mContext.getResources().getString(R.l.grc, new Object[] { Integer.valueOf(paramInt) }));
          paramInt += 1;
        }
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(36727);
    if (this.Jjv != null) {
      this.Jjv.dismiss();
    }
    AppMethodBeat.o(36727);
  }
  
  public final void show()
  {
    AppMethodBeat.i(36726);
    if (this.Jjv != null) {
      this.Jjv.show();
    }
    AppMethodBeat.o(36726);
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void zJ(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.c
 * JD-Core Version:    0.7.0.1
 */