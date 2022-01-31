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
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.picker.OptionPicker;
import java.util.ArrayList;
import java.util.Calendar;

public final class b
{
  private BottomSheetBehavior fK;
  private Button fbO;
  private Button hPe;
  private View jdj;
  Context mContext;
  OptionPicker vAA;
  c vAB;
  private int vAC;
  public b.a vAD;
  ArrayList<Long> vAE = new ArrayList(42);
  OptionPicker vAz;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdj = View.inflate(this.mContext, R.i.remind_date_picker_panel, null);
    this.vAB = new c(this.mContext);
    this.vAB.setContentView(this.jdj);
    this.vAB.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        b.this.vAB = null;
      }
    });
    this.vAz = ((OptionPicker)this.jdj.findViewById(R.h.option_first_picker));
    this.vAA = ((OptionPicker)this.jdj.findViewById(R.h.option_second_picker));
    this.vAz.setValue(0);
    this.vAz.setMinWidth(a.fromDPToPix(this.mContext, 60));
    this.vAA.setMinWidth(a.fromDPToPix(this.mContext, 60));
    this.vAz.setOptionsArray(cHa());
    this.vAA.setOptionsArray(HI(0));
    this.vAz.setOnValueChangedListener(new b.2(this));
    paramContext = (FrameLayout.LayoutParams)this.jdj.getLayoutParams();
    paramContext.height = a.fromDPToPix(this.mContext, 288);
    this.jdj.setLayoutParams(paramContext);
    this.vAC = a.fromDPToPix(this.mContext, 350);
    this.fK = BottomSheetBehavior.i((View)this.jdj.getParent());
    if (this.fK != null)
    {
      this.fK.u(this.vAC);
      this.fK.fq = false;
    }
    this.fbO = ((Button)this.jdj.findViewById(R.h.ok_btn));
    this.fbO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        b localb;
        long l;
        int i;
        int j;
        if (b.this.vAD != null)
        {
          paramAnonymousView = b.this.vAD;
          localb = b.this;
          l = System.currentTimeMillis();
          i = localb.vAz.getValue();
          j = localb.vAA.getValue();
          if (i != 0) {
            break label142;
          }
          if (!com.tencent.mm.sdk.a.b.cqk()) {
            break label126;
          }
          l += 360000L;
        }
        for (;;)
        {
          y.i("MicroMsg.MMRemindDatePicker", "[getTimestamp] date:%s", new Object[] { h.g(localb.mContext.getString(R.l.fmt_longdate_with_full) + "HH:mm", l / 1000L) });
          paramAnonymousView.hP(l);
          return;
          label126:
          l += (j + 1) * 3600000L;
          continue;
          label142:
          l = ((Long)localb.vAE.get(i)).longValue() + (j + 1) * 3600000L;
        }
      }
    });
    this.hPe = ((Button)this.jdj.findViewById(R.h.cancel_btn));
    this.hPe.setOnClickListener(new b.4(this));
  }
  
  private String[] cHa()
  {
    int j = 0;
    this.vAE.clear();
    ArrayList localArrayList = new ArrayList();
    Calendar localCalendar = Calendar.getInstance();
    int i = 0;
    if (i < localCalendar.getActualMaximum(5))
    {
      if ((com.tencent.mm.sdk.a.b.cqk()) && (i == 0))
      {
        localArrayList.add("test");
        this.vAE.add(Long.valueOf(localCalendar.getTimeInMillis()));
      }
      label104:
      String str;
      if (i == 0)
      {
        localCalendar.setTimeInMillis(System.currentTimeMillis() + 86400000L * i);
        this.vAE.add(Long.valueOf(localCalendar.getTimeInMillis()));
        str = h.g(this.mContext.getString(R.l.fmt_date), localCalendar.getTimeInMillis() / 1000L);
        if (i != 0) {
          break label224;
        }
        localArrayList.add(this.mContext.getResources().getString(R.l.fmt_pre_nowday));
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
        this.vAE.add(Long.valueOf(localCalendar.getTimeInMillis()));
        break label104;
        label224:
        if (i == 1) {
          localArrayList.add(str + " " + this.mContext.getResources().getString(R.l.fmt_pre_tomorrow));
        } else if (i == 2) {
          localArrayList.add(str + " " + this.mContext.getResources().getString(R.l.fmt_pre_dayaftertomorrow));
        } else {
          localArrayList.add(str + " " + h.U(this.mContext, localCalendar.get(7)));
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
        this.vAE.add(Long.valueOf(localCalendar.getTimeInMillis()));
        localArrayList.add(String.valueOf(h.g(this.mContext.getString(R.l.fmt_longdate_with_full), localCalendar.getTimeInMillis() / 1000L)));
        i += 1;
        break;
        localCalendar.set(2, m + i);
      }
    }
    return bk.dj(localArrayList);
  }
  
  final String[] HI(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    label46:
    StringBuilder localStringBuilder;
    if (com.tencent.mm.sdk.a.b.cqk())
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
            break label189;
          }
        }
        break;
      }
    }
    label189:
    for (Object localObject = "0" + paramInt;; localObject = Integer.valueOf(paramInt))
    {
      localArrayList.add(localObject + ":00");
      paramInt += 1;
      break label46;
      i = 0;
      break;
      localArrayList.add("after 6 min");
      for (;;)
      {
        return bk.dj(localArrayList);
        i = Calendar.getInstance().get(11);
        paramInt = 1;
        while (paramInt <= 24 - i)
        {
          localArrayList.add(this.mContext.getResources().getString(R.l.after_time_remind, new Object[] { Integer.valueOf(paramInt) }));
          paramInt += 1;
        }
      }
    }
  }
  
  public final void hide()
  {
    if (this.vAB != null) {
      this.vAB.dismiss();
    }
  }
  
  public final void show()
  {
    if (this.vAB != null) {
      this.vAB.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.b
 * JD-Core Version:    0.7.0.1
 */