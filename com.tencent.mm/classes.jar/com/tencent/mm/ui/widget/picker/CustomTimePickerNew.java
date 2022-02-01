package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.picker.d.g;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CustomTimePickerNew
  extends FrameLayout
{
  h LwY;
  private Context context;
  int currentHour;
  int currentMinute;
  private int lhP;
  private int lhQ;
  private int mMaxTimeHour;
  private int mMaxTimeMinute;
  private int mMinTimeHour;
  private int mMinTimeMinute;
  private View mView;
  
  public CustomTimePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679));
    AppMethodBeat.i(200468);
    this.mView = null;
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    this.lhP = -1;
    this.lhQ = -1;
    this.context = paramContext;
    this.LwY = new h(paramContext);
    AppMethodBeat.o(200468);
  }
  
  public CustomTimePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821679), paramAttributeSet);
    AppMethodBeat.i(200469);
    this.mView = null;
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    this.lhP = -1;
    this.lhQ = -1;
    this.context = paramContext;
    this.LwY = new h(paramContext);
    AppMethodBeat.o(200469);
  }
  
  public CustomTimePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(200470);
    this.mView = null;
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    this.lhP = -1;
    this.lhQ = -1;
    this.context = paramContext;
    this.LwY = new h(paramContext);
    AppMethodBeat.o(200470);
  }
  
  public View getView()
  {
    AppMethodBeat.i(200471);
    if (this.mView == null) {
      this.mView = this.LwY.aQD();
    }
    View localView = this.mView;
    AppMethodBeat.o(200471);
    return localView;
  }
  
  public final void init(int paramInt1, int paramInt2)
  {
    this.lhP = paramInt1;
    this.lhQ = paramInt2;
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(200472);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(11, this.lhP);
    ((Calendar)localObject).set(12, this.lhQ);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(11, this.mMinTimeHour);
    localCalendar1.set(12, this.mMinTimeMinute);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(11, this.mMaxTimeHour);
    localCalendar2.set(12, this.mMaxTimeMinute);
    localObject = new com.tencent.mm.ui.widget.picker.b.b(this.context, new g()
    {
      public final void a(Date paramAnonymousDate)
      {
        AppMethodBeat.i(200467);
        CustomTimePickerNew.a(CustomTimePickerNew.this, paramAnonymousDate);
        AppMethodBeat.o(200467);
      }
    }).c(new boolean[] { 0, 0, 0, 1, 1, 0 }).b((Calendar)localObject).b(localCalendar1, localCalendar2).fRt();
    int i = android.support.v4.content.b.n(this.context, 2131099656);
    ((com.tencent.mm.ui.widget.picker.b.b)localObject).LwV.iNG = i;
    ((com.tencent.mm.ui.widget.picker.b.b)localObject).c(this.LwY);
    this.LwY.setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165923));
    this.context.getResources().getDimensionPixelSize(2131165292);
    this.LwY.du(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
    localObject = this.LwY.LxJ.aQG().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WheelView)((Iterator)localObject).next()).agp(android.support.v4.content.b.n(this.context, 2131099664)).ago(this.context.getResources().getDimensionPixelSize(2131165289)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    }
    localObject = this.LwY.LxJ.aQG();
    if (((List)localObject).size() == 1)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(200472);
      return;
    }
    if (((List)localObject).size() == 2)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
      AppMethodBeat.o(200472);
      return;
    }
    if (((List)localObject).size() == 3)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289));
      ((WheelView)((List)localObject).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131165274), this.context.getResources().getDimensionPixelSize(2131165289), 0, this.context.getResources().getDimensionPixelSize(2131165289));
    }
    AppMethodBeat.o(200472);
  }
  
  public final void setMaxTime(int paramInt1, int paramInt2)
  {
    this.mMaxTimeHour = paramInt1;
    this.mMaxTimeMinute = paramInt2;
  }
  
  public final void setMinTime(int paramInt1, int paramInt2)
  {
    this.mMinTimeHour = paramInt1;
    this.mMinTimeMinute = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomTimePickerNew
 * JD-Core Version:    0.7.0.1
 */