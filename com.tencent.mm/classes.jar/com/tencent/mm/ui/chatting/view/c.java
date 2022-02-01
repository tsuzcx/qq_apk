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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class c
{
  OptionPicker Kuh;
  OptionPicker Kui;
  public a Kuj;
  ArrayList<Long> Kuk;
  private Button gXc;
  private Button gZv;
  private View kFh;
  private int lEa;
  private BottomSheetBehavior lEb;
  Context mContext;
  android.support.design.widget.a uNn;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(36725);
    this.Kuk = new ArrayList(42);
    this.mContext = paramContext;
    this.kFh = View.inflate(this.mContext, 2131495247, null);
    this.uNn = new android.support.design.widget.a(this.mContext);
    this.uNn.setContentView(this.kFh);
    this.uNn.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.uNn = null;
      }
    });
    this.Kuh = ((OptionPicker)this.kFh.findViewById(2131303043));
    this.Kui = ((OptionPicker)this.kFh.findViewById(2131303045));
    this.Kuh.setValue(0);
    this.Kuh.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 60));
    this.Kui.setMinWidth(com.tencent.mm.cb.a.fromDPToPix(this.mContext, 60));
    this.Kuh.setOptionsArray(fLx());
    this.Kui.setOptionsArray(aeO(0));
    this.Kuh.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36722);
        ae.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.this.Kui.setOptionsArray(c.this.aeO(paramAnonymousInt2));
        paramAnonymousInt1 = Calendar.getInstance().get(11);
        if (paramAnonymousInt2 == 0)
        {
          c.this.Kui.setValue(0);
          AppMethodBeat.o(36722);
          return;
        }
        c.this.Kui.setValue(paramAnonymousInt1);
        AppMethodBeat.o(36722);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.kFh.getLayoutParams();
    paramContext.height = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 288);
    this.kFh.setLayoutParams(paramContext);
    this.lEa = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 350);
    this.lEb = BottomSheetBehavior.l((View)this.kFh.getParent());
    if (this.lEb != null)
    {
      this.lEb.J(this.lEa);
      this.lEb.nZ = false;
    }
    this.gXc = ((Button)this.kFh.findViewById(2131302999));
    this.gXc.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36723);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        long l;
        int i;
        int j;
        if (c.this.Kuj != null)
        {
          paramAnonymousView = c.this.Kuj;
          localObject = c.this;
          l = System.currentTimeMillis();
          i = ((c)localObject).Kuh.getValue();
          j = ((c)localObject).Kui.getValue();
          if (i != 0) {
            break label195;
          }
          if (!com.tencent.mm.sdk.a.b.fnF()) {
            break label179;
          }
          l += 360000L;
        }
        for (;;)
        {
          ae.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", new Object[] { i.formatTime(((c)localObject).mContext.getString(2131759518) + "HH:mm", l / 1000L) });
          paramAnonymousView.Ep(l);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(36723);
          return;
          label179:
          l += (j + 1) * 3600000L;
          continue;
          label195:
          l = ((Long)((c)localObject).Kuk.get(i)).longValue() + (j + 1) * 3600000L;
        }
      }
    });
    this.gZv = ((Button)this.kFh.findViewById(2131297690));
    this.gZv.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36724);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (c.this.Kuj != null) {
          c.this.Kuj.onCancel();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/view/MMRemindDatePicker$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(36724);
      }
    });
    AppMethodBeat.o(36725);
  }
  
  private String[] fLx()
  {
    int j = 0;
    AppMethodBeat.i(36729);
    this.Kuk.clear();
    Object localObject = new ArrayList();
    Calendar localCalendar = Calendar.getInstance();
    int i = 0;
    if (i < localCalendar.getActualMaximum(5))
    {
      if ((com.tencent.mm.sdk.a.b.fnF()) && (i == 0))
      {
        ((ArrayList)localObject).add("test");
        this.Kuk.add(Long.valueOf(localCalendar.getTimeInMillis()));
      }
      label109:
      String str;
      if (i == 0)
      {
        localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L * i);
        this.Kuk.add(Long.valueOf(localCalendar.getTimeInMillis()));
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
        this.Kuk.add(Long.valueOf(localCalendar.getTimeInMillis()));
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
        this.Kuk.add(Long.valueOf(localCalendar.getTimeInMillis()));
        ((ArrayList)localObject).add(String.valueOf(i.formatTime(this.mContext.getString(2131759518), localCalendar.getTimeInMillis() / 1000L)));
        i += 1;
        break;
        localCalendar.set(2, m + i);
      }
    }
    localObject = bu.hs((List)localObject);
    AppMethodBeat.o(36729);
    return localObject;
  }
  
  final String[] aeO(int paramInt)
  {
    AppMethodBeat.i(36728);
    ArrayList localArrayList = new ArrayList();
    int i;
    label50:
    StringBuilder localStringBuilder;
    if (com.tencent.mm.sdk.a.b.fnF())
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
        localObject = bu.hs(localArrayList);
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
    if (this.uNn != null) {
      this.uNn.dismiss();
    }
    AppMethodBeat.o(36727);
  }
  
  public final void show()
  {
    AppMethodBeat.i(36726);
    if (this.uNn != null) {
      this.uNn.show();
    }
    AppMethodBeat.o(36726);
  }
  
  public static abstract interface a
  {
    public abstract void Ep(long paramLong);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.c
 * JD-Core Version:    0.7.0.1
 */