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
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class c
{
  ArrayList<Long> GHA;
  OptionPicker GHx;
  OptionPicker GHy;
  public a GHz;
  private Button hJg;
  private Button hJh;
  private View jGG;
  private int kBk;
  private BottomSheetBehavior kBl;
  Context mContext;
  android.support.design.widget.a sri;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(36725);
    this.GHA = new ArrayList(42);
    this.mContext = paramContext;
    this.jGG = View.inflate(this.mContext, 2131495247, null);
    this.sri = new android.support.design.widget.a(this.mContext);
    this.sri.setContentView(this.jGG);
    this.sri.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.sri = null;
      }
    });
    this.GHx = ((OptionPicker)this.jGG.findViewById(2131303043));
    this.GHy = ((OptionPicker)this.jGG.findViewById(2131303045));
    this.GHx.setValue(0);
    this.GHx.setMinWidth(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 60));
    this.GHy.setMinWidth(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 60));
    this.GHx.setOptionsArray(faC());
    this.GHy.setOptionsArray(Zz(0));
    this.GHx.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36722);
        ad.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.this.GHy.setOptionsArray(c.this.Zz(paramAnonymousInt2));
        paramAnonymousInt1 = Calendar.getInstance().get(11);
        if (paramAnonymousInt2 == 0)
        {
          c.this.GHy.setValue(0);
          AppMethodBeat.o(36722);
          return;
        }
        c.this.GHy.setValue(paramAnonymousInt1);
        AppMethodBeat.o(36722);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.jGG.getLayoutParams();
    paramContext.height = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 288);
    this.jGG.setLayoutParams(paramContext);
    this.kBk = com.tencent.mm.cd.a.fromDPToPix(this.mContext, 350);
    this.kBl = BottomSheetBehavior.l((View)this.jGG.getParent());
    if (this.kBl != null)
    {
      this.kBl.J(this.kBk);
      this.kBl.lh = false;
    }
    this.hJh = ((Button)this.jGG.findViewById(2131302999));
    this.hJh.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36723);
        c localc;
        long l;
        int i;
        int j;
        if (c.this.GHz != null)
        {
          paramAnonymousView = c.this.GHz;
          localc = c.this;
          l = System.currentTimeMillis();
          i = localc.GHx.getValue();
          j = localc.GHy.getValue();
          if (i != 0) {
            break label151;
          }
          if (!b.eEQ()) {
            break label135;
          }
          l += 360000L;
        }
        for (;;)
        {
          ad.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", new Object[] { h.formatTime(localc.mContext.getString(2131759518) + "HH:mm", l / 1000L) });
          paramAnonymousView.wz(l);
          AppMethodBeat.o(36723);
          return;
          label135:
          l += (j + 1) * 3600000L;
          continue;
          label151:
          l = ((Long)localc.GHA.get(i)).longValue() + (j + 1) * 3600000L;
        }
      }
    });
    this.hJg = ((Button)this.jGG.findViewById(2131297690));
    this.hJg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36724);
        if (c.this.GHz != null) {
          c.this.GHz.onCancel();
        }
        AppMethodBeat.o(36724);
      }
    });
    AppMethodBeat.o(36725);
  }
  
  private String[] faC()
  {
    int j = 0;
    AppMethodBeat.i(36729);
    this.GHA.clear();
    Object localObject = new ArrayList();
    Calendar localCalendar = Calendar.getInstance();
    int i = 0;
    if (i < localCalendar.getActualMaximum(5))
    {
      if ((b.eEQ()) && (i == 0))
      {
        ((ArrayList)localObject).add("test");
        this.GHA.add(Long.valueOf(localCalendar.getTimeInMillis()));
      }
      label109:
      String str;
      if (i == 0)
      {
        localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L * i);
        this.GHA.add(Long.valueOf(localCalendar.getTimeInMillis()));
        str = h.formatTime(this.mContext.getString(2131759498), localCalendar.getTimeInMillis() / 1000L);
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
        this.GHA.add(Long.valueOf(localCalendar.getTimeInMillis()));
        break label109;
        label227:
        if (i == 1) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(2131759543));
        } else if (i == 2) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(2131759533));
        } else {
          ((ArrayList)localObject).add(str + " " + h.ai(this.mContext, localCalendar.get(7)));
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
        this.GHA.add(Long.valueOf(localCalendar.getTimeInMillis()));
        ((ArrayList)localObject).add(String.valueOf(h.formatTime(this.mContext.getString(2131759518), localCalendar.getTimeInMillis() / 1000L)));
        i += 1;
        break;
        localCalendar.set(2, m + i);
      }
    }
    localObject = bt.gK((List)localObject);
    AppMethodBeat.o(36729);
    return localObject;
  }
  
  final String[] Zz(int paramInt)
  {
    AppMethodBeat.i(36728);
    ArrayList localArrayList = new ArrayList();
    int i;
    label50:
    StringBuilder localStringBuilder;
    if (b.eEQ())
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
        localObject = bt.gK(localArrayList);
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
    if (this.sri != null) {
      this.sri.dismiss();
    }
    AppMethodBeat.o(36727);
  }
  
  public final void show()
  {
    AppMethodBeat.i(36726);
    if (this.sri != null) {
      this.sri.show();
    }
    AppMethodBeat.o(36726);
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void wz(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.c
 * JD-Core Version:    0.7.0.1
 */