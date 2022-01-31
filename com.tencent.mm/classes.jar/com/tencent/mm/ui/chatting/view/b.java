package com.tencent.mm.ui.chatting.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class b
{
  private BottomSheetBehavior gE;
  private Button gtF;
  private View iDS;
  private Button jIG;
  Context mContext;
  OptionPicker zQY;
  OptionPicker zQZ;
  c zRa;
  private int zRb;
  public a zRc;
  ArrayList<Long> zRd;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(32780);
    this.zRd = new ArrayList(42);
    this.mContext = paramContext;
    this.iDS = View.inflate(this.mContext, 2130970564, null);
    this.zRa = new c(this.mContext);
    this.zRa.setContentView(this.iDS);
    this.zRa.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        b.this.zRa = null;
      }
    });
    this.zQY = ((OptionPicker)this.iDS.findViewById(2131827178));
    this.zQZ = ((OptionPicker)this.iDS.findViewById(2131826644));
    this.zQY.setValue(0);
    this.zQY.setMinWidth(a.fromDPToPix(this.mContext, 60));
    this.zQZ.setMinWidth(a.fromDPToPix(this.mContext, 60));
    this.zQY.setOptionsArray(dLn());
    this.zQZ.setOptionsArray(Qq(0));
    this.zQY.setOnValueChangedListener(new b.2(this));
    paramContext = (FrameLayout.LayoutParams)this.iDS.getLayoutParams();
    paramContext.height = a.fromDPToPix(this.mContext, 288);
    this.iDS.setLayoutParams(paramContext);
    this.zRb = a.fromDPToPix(this.mContext, 350);
    this.gE = BottomSheetBehavior.i((View)this.iDS.getParent());
    if (this.gE != null)
    {
      this.gE.t(this.zRb);
      this.gE.go = false;
    }
    this.gtF = ((Button)this.iDS.findViewById(2131823301));
    this.gtF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32778);
        b localb;
        long l;
        int i;
        int j;
        if (b.this.zRc != null)
        {
          paramAnonymousView = b.this.zRc;
          localb = b.this;
          l = System.currentTimeMillis();
          i = localb.zQY.getValue();
          j = localb.zQZ.getValue();
          if (i != 0) {
            break label151;
          }
          if (!com.tencent.mm.sdk.a.b.dsf()) {
            break label135;
          }
          l += 360000L;
        }
        for (;;)
        {
          ab.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", new Object[] { h.formatTime(localb.mContext.getString(2131300051) + "HH:mm", l / 1000L) });
          paramAnonymousView.oB(l);
          AppMethodBeat.o(32778);
          return;
          label135:
          l += (j + 1) * 3600000L;
          continue;
          label151:
          l = ((Long)localb.zRd.get(i)).longValue() + (j + 1) * 3600000L;
        }
      }
    });
    this.jIG = ((Button)this.iDS.findViewById(2131822887));
    this.jIG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(32779);
        if (b.this.zRc != null) {
          b.this.zRc.onCancel();
        }
        AppMethodBeat.o(32779);
      }
    });
    AppMethodBeat.o(32780);
  }
  
  private String[] dLn()
  {
    int j = 0;
    AppMethodBeat.i(32784);
    this.zRd.clear();
    Object localObject = new ArrayList();
    Calendar localCalendar = Calendar.getInstance();
    int i = 0;
    if (i < localCalendar.getActualMaximum(5))
    {
      if ((com.tencent.mm.sdk.a.b.dsf()) && (i == 0))
      {
        ((ArrayList)localObject).add("test");
        this.zRd.add(Long.valueOf(localCalendar.getTimeInMillis()));
      }
      label109:
      String str;
      if (i == 0)
      {
        localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L * i);
        this.zRd.add(Long.valueOf(localCalendar.getTimeInMillis()));
        str = h.formatTime(this.mContext.getString(2131300031), localCalendar.getTimeInMillis() / 1000L);
        if (i != 0) {
          break label227;
        }
        ((ArrayList)localObject).add(this.mContext.getResources().getString(2131300075));
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
        this.zRd.add(Long.valueOf(localCalendar.getTimeInMillis()));
        break label109;
        label227:
        if (i == 1) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(2131300076));
        } else if (i == 2) {
          ((ArrayList)localObject).add(str + " " + this.mContext.getResources().getString(2131300066));
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
        this.zRd.add(Long.valueOf(localCalendar.getTimeInMillis()));
        ((ArrayList)localObject).add(String.valueOf(h.formatTime(this.mContext.getString(2131300051), localCalendar.getTimeInMillis() / 1000L)));
        i += 1;
        break;
        localCalendar.set(2, m + i);
      }
    }
    localObject = bo.er((List)localObject);
    AppMethodBeat.o(32784);
    return localObject;
  }
  
  final String[] Qq(int paramInt)
  {
    AppMethodBeat.i(32783);
    ArrayList localArrayList = new ArrayList();
    int i;
    label50:
    StringBuilder localStringBuilder;
    if (com.tencent.mm.sdk.a.b.dsf())
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
        localObject = bo.er(localArrayList);
        AppMethodBeat.o(32783);
        return localObject;
        i = Calendar.getInstance().get(11);
        paramInt = 1;
        while (paramInt <= 24 - i)
        {
          localArrayList.add(this.mContext.getResources().getString(2131296513, new Object[] { Integer.valueOf(paramInt) }));
          paramInt += 1;
        }
      }
    }
  }
  
  public final void hide()
  {
    AppMethodBeat.i(32782);
    if (this.zRa != null) {
      this.zRa.dismiss();
    }
    AppMethodBeat.o(32782);
  }
  
  public final void show()
  {
    AppMethodBeat.i(32781);
    if (this.zRa != null) {
      this.zRa.show();
    }
    AppMethodBeat.o(32781);
  }
  
  public static abstract interface a
  {
    public abstract void oB(long paramLong);
    
    public abstract void onCancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.b
 * JD-Core Version:    0.7.0.1
 */