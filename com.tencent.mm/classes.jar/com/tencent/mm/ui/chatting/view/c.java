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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class c
{
  OptionPicker Iht;
  OptionPicker Ihu;
  public a Ihv;
  ArrayList<Long> Ihw;
  private Button gAJ;
  private Button gCY;
  private View khe;
  private int lcC;
  private BottomSheetBehavior lcD;
  Context mContext;
  android.support.design.widget.a tyZ;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(36725);
    this.Ihw = new ArrayList(42);
    this.mContext = paramContext;
    this.khe = View.inflate(this.mContext, 2131495247, null);
    this.tyZ = new android.support.design.widget.a(this.mContext);
    this.tyZ.setContentView(this.khe);
    this.tyZ.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        c.this.tyZ = null;
      }
    });
    this.Iht = ((OptionPicker)this.khe.findViewById(2131303043));
    this.Ihu = ((OptionPicker)this.khe.findViewById(2131303045));
    this.Iht.setValue(0);
    this.Iht.setMinWidth(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 60));
    this.Ihu.setMinWidth(com.tencent.mm.cc.a.fromDPToPix(this.mContext, 60));
    this.Iht.setOptionsArray(fqs());
    this.Ihu.setOptionsArray(abL(0));
    this.Iht.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
    {
      public final void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(36722);
        ac.d("MicroMsg.MMRemindDatePicker", "[onValueChange] oldVal:%s newVal:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        c.this.Ihu.setOptionsArray(c.this.abL(paramAnonymousInt2));
        paramAnonymousInt1 = Calendar.getInstance().get(11);
        if (paramAnonymousInt2 == 0)
        {
          c.this.Ihu.setValue(0);
          AppMethodBeat.o(36722);
          return;
        }
        c.this.Ihu.setValue(paramAnonymousInt1);
        AppMethodBeat.o(36722);
      }
    });
    paramContext = (FrameLayout.LayoutParams)this.khe.getLayoutParams();
    paramContext.height = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 288);
    this.khe.setLayoutParams(paramContext);
    this.lcC = com.tencent.mm.cc.a.fromDPToPix(this.mContext, 350);
    this.lcD = BottomSheetBehavior.l((View)this.khe.getParent());
    if (this.lcD != null)
    {
      this.lcD.J(this.lcC);
      this.lcD.mg = false;
    }
    this.gAJ = ((Button)this.khe.findViewById(2131302999));
    this.gAJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36723);
        c localc;
        long l;
        int i;
        int j;
        if (c.this.Ihv != null)
        {
          paramAnonymousView = c.this.Ihv;
          localc = c.this;
          l = System.currentTimeMillis();
          i = localc.Iht.getValue();
          j = localc.Ihu.getValue();
          if (i != 0) {
            break label151;
          }
          if (!b.eUk()) {
            break label135;
          }
          l += 360000L;
        }
        for (;;)
        {
          ac.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", new Object[] { h.formatTime(localc.mContext.getString(2131759518) + "HH:mm", l / 1000L) });
          paramAnonymousView.Bc(l);
          AppMethodBeat.o(36723);
          return;
          label135:
          l += (j + 1) * 3600000L;
          continue;
          label151:
          l = ((Long)localc.Ihw.get(i)).longValue() + (j + 1) * 3600000L;
        }
      }
    });
    this.gCY = ((Button)this.khe.findViewById(2131297690));
    this.gCY.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(36724);
        if (c.this.Ihv != null) {
          c.this.Ihv.onCancel();
        }
        AppMethodBeat.o(36724);
      }
    });
    AppMethodBeat.o(36725);
  }
  
  private String[] fqs()
  {
    int j = 0;
    AppMethodBeat.i(36729);
    this.Ihw.clear();
    Object localObject = new ArrayList();
    Calendar localCalendar = Calendar.getInstance();
    int i = 0;
    if (i < localCalendar.getActualMaximum(5))
    {
      if ((b.eUk()) && (i == 0))
      {
        ((ArrayList)localObject).add("test");
        this.Ihw.add(Long.valueOf(localCalendar.getTimeInMillis()));
      }
      label109:
      String str;
      if (i == 0)
      {
        localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L * i);
        this.Ihw.add(Long.valueOf(localCalendar.getTimeInMillis()));
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
        this.Ihw.add(Long.valueOf(localCalendar.getTimeInMillis()));
        break label109;
        label227:
        if (i == 1) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(2131759543));
        } else if (i == 2) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(2131759533));
        } else {
          ((ArrayList)localObject).add(str + " " + h.ao(this.mContext, localCalendar.get(7)));
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
        this.Ihw.add(Long.valueOf(localCalendar.getTimeInMillis()));
        ((ArrayList)localObject).add(String.valueOf(h.formatTime(this.mContext.getString(2131759518), localCalendar.getTimeInMillis() / 1000L)));
        i += 1;
        break;
        localCalendar.set(2, m + i);
      }
    }
    localObject = bs.gX((List)localObject);
    AppMethodBeat.o(36729);
    return localObject;
  }
  
  final String[] abL(int paramInt)
  {
    AppMethodBeat.i(36728);
    ArrayList localArrayList = new ArrayList();
    int i;
    label50:
    StringBuilder localStringBuilder;
    if (b.eUk())
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
        localObject = bs.gX(localArrayList);
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
    if (this.tyZ != null) {
      this.tyZ.dismiss();
    }
    AppMethodBeat.o(36727);
  }
  
  public final void show()
  {
    AppMethodBeat.i(36726);
    if (this.tyZ != null) {
      this.tyZ.show();
    }
    AppMethodBeat.o(36726);
  }
  
  public static abstract interface a
  {
    public abstract void Bc(long paramLong);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.c
 * JD-Core Version:    0.7.0.1
 */