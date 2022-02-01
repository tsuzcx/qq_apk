package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.widget.picker.d.f;
import com.tencent.mm.ui.widget.picker.d.g;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class CustomDatePickerNew
  extends FrameLayout
{
  private h LwY;
  private boolean LwZ;
  private Context context;
  private int lhm;
  private int lhn;
  private int lho;
  private View mView;
  private Date npA;
  private Date npB;
  private int npF;
  private int npG;
  private int npH;
  private boolean npu;
  private boolean npv;
  private boolean npw;
  
  public CustomDatePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679));
    AppMethodBeat.i(200441);
    this.mView = null;
    this.npw = true;
    this.npv = true;
    this.npu = true;
    this.LwZ = false;
    this.context = paramContext;
    this.LwY = new h(paramContext);
    AppMethodBeat.o(200441);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679), paramAttributeSet);
    AppMethodBeat.i(200442);
    this.mView = null;
    this.npw = true;
    this.npv = true;
    this.npu = true;
    this.LwZ = false;
    this.context = paramContext;
    this.LwY = new h(paramContext);
    AppMethodBeat.o(200442);
  }
  
  public CustomDatePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200443);
    this.mView = null;
    this.npw = true;
    this.npv = true;
    this.npu = true;
    this.LwZ = false;
    this.context = paramContext;
    this.LwY = new h(paramContext);
    AppMethodBeat.o(200443);
  }
  
  public final void aP(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(200446);
    this.lhm = paramInt1;
    this.lhn = paramInt2;
    this.lho = paramInt3;
    if (this.mView == null) {
      this.mView = this.LwY.aQD();
    }
    AppMethodBeat.o(200446);
  }
  
  public final void aW(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.npw = paramBoolean2;
    this.npv = paramBoolean1;
    this.npu = true;
  }
  
  public final String currentValue()
  {
    AppMethodBeat.i(200444);
    this.LwY.aQB();
    if (this.npw)
    {
      str = String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(this.npF), Integer.valueOf(this.npG), Integer.valueOf(this.npH) });
      AppMethodBeat.o(200444);
      return str;
    }
    if (this.npv)
    {
      str = String.format(Locale.US, "%04d-%02d", new Object[] { Integer.valueOf(this.npF), Integer.valueOf(this.npG) });
      AppMethodBeat.o(200444);
      return str;
    }
    String str = String.format(Locale.US, "%04d", new Object[] { Integer.valueOf(this.npF) });
    AppMethodBeat.o(200444);
    return str;
  }
  
  public int getDayOfMonth()
  {
    AppMethodBeat.i(200451);
    if (this.LwY != null) {
      this.LwY.aQB();
    }
    int i = this.npH;
    AppMethodBeat.o(200451);
    return i;
  }
  
  public int getMonth()
  {
    AppMethodBeat.i(200450);
    if (this.LwY != null) {
      this.LwY.aQB();
    }
    int i = this.npG;
    AppMethodBeat.o(200450);
    return i;
  }
  
  public View getView()
  {
    AppMethodBeat.i(200445);
    if (this.mView == null) {
      this.mView = this.LwY.aQD();
    }
    View localView = this.mView;
    AppMethodBeat.o(200445);
    return localView;
  }
  
  public int getYear()
  {
    AppMethodBeat.i(200449);
    if (this.LwY != null) {
      this.LwY.aQB();
    }
    int i = this.npF;
    AppMethodBeat.o(200449);
    return i;
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(200452);
    if (this.LwZ) {
      this.lhm += 1;
    }
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(this.lhm, this.lhn - 1, this.lho);
    Object localObject2 = Calendar.getInstance();
    if (this.npA == null) {
      this.npA = new Date(((Calendar)localObject1).getTimeInMillis());
    }
    ((Calendar)localObject2).setTime(this.npA);
    Calendar localCalendar = Calendar.getInstance();
    if (this.npB == null)
    {
      localObject3 = Calendar.getInstance();
      ((Calendar)localObject3).set(this.lhm + 100, this.lhn - 1, this.lho);
      this.npB = new Date(((Calendar)localObject3).getTimeInMillis());
    }
    localCalendar.setTime(this.npB);
    Object localObject3 = this.LwY;
    boolean bool = this.LwZ;
    ((h)localObject3).LxK = bool;
    if (((h)localObject3).LxJ != null) {
      ((h)localObject3).LxJ.LxW = bool;
    }
    localObject3 = new com.tencent.mm.ui.widget.picker.b.b(this.context, new g()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(200440);
        CustomDatePickerNew.a(CustomDatePickerNew.this, paramAnonymousDate);
        ap.i("pvTime", "onTimeSelect", new Object[0]);
        AppMethodBeat.o(200440);
      }
    });
    f local1 = new f()
    {
      public final void fRe()
      {
        AppMethodBeat.i(200439);
        ap.i("pvTime", "onTimeSelectChanged", new Object[0]);
        AppMethodBeat.o(200439);
      }
    };
    ((com.tencent.mm.ui.widget.picker.b.b)localObject3).LwV.LyL = local1;
    localObject1 = ((com.tencent.mm.ui.widget.picker.b.b)localObject3).fRt().c(new boolean[] { this.npu, this.npv, this.npw, false, false, false }).b((Calendar)localObject1).b((Calendar)localObject2, localCalendar);
    int i = this.context.getResources().getDimensionPixelSize(2131165292);
    ((com.tencent.mm.ui.widget.picker.b.b)localObject1).LwV.kl = i;
    ((com.tencent.mm.ui.widget.picker.b.b)localObject1).c(this.LwY);
    this.LwY.setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    this.context.getResources().getDimensionPixelSize(2131165292);
    localObject1 = this.LwY;
    bool = this.LwZ;
    if (((h)localObject1).LxJ != null)
    {
      localObject1 = ((h)localObject1).LxJ;
      ((j)localObject1).LxW = bool;
      ((j)localObject1).LxV.LyH = bool;
      ((j)localObject1).LxP.setLongTermYear(bool);
      ((j)localObject1).LxQ.setLongTermMonthDay(bool);
      ((j)localObject1).LxR.setLongTermMonthDay(bool);
    }
    localObject1 = this.LwY;
    i = android.support.v4.content.b.n(this.context, 2131099656);
    ((h)localObject1).LxJ.setDividerColor(i);
    this.LwY.du(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    localObject1 = this.LwY.fRk().iterator();
    i = 0;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WheelView)((Iterator)localObject1).next();
      if ((this.LwZ) && (this.lhm == 2) && (i > 0)) {
        ((WheelView)localObject2).agp(0).ago(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
      }
      for (;;)
      {
        i += 1;
        break;
        ((WheelView)localObject2).agp(android.support.v4.content.b.n(this.context, 2131099664)).ago(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
      }
    }
    localObject1 = this.LwY.fRk();
    if (((List)localObject1).size() == 1)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(200452);
      return;
    }
    if (((List)localObject1).size() == 2)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(200452);
      return;
    }
    if (((List)localObject1).size() == 3)
    {
      ((WheelView)((List)localObject1).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject1).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
    }
    AppMethodBeat.o(200452);
  }
  
  public void setLongTermYear(boolean paramBoolean)
  {
    this.LwZ = paramBoolean;
  }
  
  public void setMaxDate(Long paramLong)
  {
    AppMethodBeat.i(200447);
    this.npB = new Date(paramLong.longValue());
    AppMethodBeat.o(200447);
  }
  
  public void setMinDate(Long paramLong)
  {
    AppMethodBeat.i(200448);
    this.npA = new Date(paramLong.longValue());
    AppMethodBeat.o(200448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomDatePickerNew
 * JD-Core Version:    0.7.0.1
 */