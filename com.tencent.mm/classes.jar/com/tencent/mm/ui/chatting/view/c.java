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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class c
{
  ArrayList<Long> PGA;
  OptionPicker PGx;
  OptionPicker PGy;
  public a PGz;
  private Button hPX;
  private Button hSq;
  private View lJI;
  Context mContext;
  private int mLJ;
  private BottomSheetBehavior mLK;
  android.support.design.widget.a yfL;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(36725);
    this.PGA = new ArrayList(42);
    this.mContext = paramContext;
    this.lJI = View.inflate(this.mContext, 2131496093, null);
    this.yfL = new android.support.design.widget.a(this.mContext);
    this.yfL.setContentView(this.lJI);
    this.yfL.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.yfL = null;
      }
    });
    this.PGx = ((OptionPicker)this.lJI.findViewById(2131305646));
    this.PGy = ((OptionPicker)this.lJI.findViewById(2131305650));
    this.PGx.setValue(0);
    this.PGx.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 60));
    this.PGy.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 60));
    this.PGx.setOptionsArray(gTS());
    this.PGy.setOptionsArray(anz(0));
    this.PGx.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36722);
        Log.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.this.PGy.setOptionsArray(c.this.anz(paramAnonymousInt2));
        paramAnonymousInt1 = Calendar.getInstance().get(11);
        if (paramAnonymousInt2 == 0)
        {
          c.this.PGy.setValue(0);
          AppMethodBeat.o(36722);
          return;
        }
        c.this.PGy.setValue(paramAnonymousInt1);
        AppMethodBeat.o(36722);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.lJI.getLayoutParams();
    paramContext.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 288);
    this.lJI.setLayoutParams(paramContext);
    this.mLJ = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 350);
    this.mLK = BottomSheetBehavior.l((View)this.lJI.getParent());
    if (this.mLK != null)
    {
      this.mLK.J(this.mLJ);
      this.mLK.ob = false;
    }
    this.hPX = ((Button)this.lJI.findViewById(2131305592));
    this.hPX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36723);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        long l;
        int i;
        int j;
        if (c.this.PGz != null)
        {
          paramAnonymousView = c.this.PGz;
          localObject = c.this;
          l = System.currentTimeMillis();
          i = ((c)localObject).PGx.getValue();
          j = ((c)localObject).PGy.getValue();
          if (i != 0) {
            break label195;
          }
          if (!CrashReportFactory.hasDebuger()) {
            break label179;
          }
          l += 30000L;
        }
        for (;;)
        {
          Log.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", new Object[] { f.formatTime(((c)localObject).mContext.getString(2131760833) + "HH:mm", l / 1000L) });
          paramAnonymousView.Nt(l);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36723);
          return;
          label179:
          l += (j + 1) * 3600000L;
          continue;
          label195:
          l = ((Long)((c)localObject).PGA.get(i)).longValue() + (j + 1) * 3600000L;
        }
      }
    });
    this.hSq = ((Button)this.lJI.findViewById(2131297963));
    this.hSq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36724);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (c.this.PGz != null) {
          c.this.PGz.onCancel();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(36724);
      }
    });
    AppMethodBeat.o(36725);
  }
  
  private String[] gTS()
  {
    int j = 0;
    AppMethodBeat.i(36729);
    this.PGA.clear();
    Object localObject = new ArrayList();
    Calendar localCalendar = Calendar.getInstance();
    int i = 0;
    if (i < localCalendar.getActualMaximum(5))
    {
      if ((CrashReportFactory.hasDebuger()) && (i == 0))
      {
        ((ArrayList)localObject).add("test");
        this.PGA.add(Long.valueOf(localCalendar.getTimeInMillis()));
      }
      label109:
      String str;
      if (i == 0)
      {
        localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L * i);
        this.PGA.add(Long.valueOf(localCalendar.getTimeInMillis()));
        str = f.formatTime(this.mContext.getString(2131760813), localCalendar.getTimeInMillis() / 1000L);
        if (i != 0) {
          break label227;
        }
        ((ArrayList)localObject).add(this.mContext.getResources().getString(2131760859));
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
        this.PGA.add(Long.valueOf(localCalendar.getTimeInMillis()));
        break label109;
        label227:
        if (i == 1) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(2131760860));
        } else if (i == 2) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(2131760850));
        } else {
          ((ArrayList)localObject).add(str + " " + f.aA(this.mContext, localCalendar.get(7)));
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
        this.PGA.add(Long.valueOf(localCalendar.getTimeInMillis()));
        ((ArrayList)localObject).add(String.valueOf(f.formatTime(this.mContext.getString(2131760833), localCalendar.getTimeInMillis() / 1000L)));
        i += 1;
        break;
        localCalendar.set(2, m + i);
      }
    }
    localObject = Util.listToStrings((List)localObject);
    AppMethodBeat.o(36729);
    return localObject;
  }
  
  final String[] anz(int paramInt)
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
          localArrayList.add(this.mContext.getResources().getString(2131755279, new Object[] { Integer.valueOf(paramInt) }));
          paramInt += 1;
        }
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(36727);
    if (this.yfL != null) {
      this.yfL.dismiss();
    }
    AppMethodBeat.o(36727);
  }
  
  public final void show()
  {
    AppMethodBeat.i(36726);
    if (this.yfL != null) {
      this.yfL.show();
    }
    AppMethodBeat.o(36726);
  }
  
  public static abstract interface a
  {
    public abstract void Nt(long paramLong);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.c
 * JD-Core Version:    0.7.0.1
 */