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
  h QSK;
  private Context context;
  int currentHour;
  int currentMinute;
  public int mMaxTimeHour;
  public int mMaxTimeMinute;
  public int mMinTimeHour;
  public int mMinTimeMinute;
  private View mView;
  public int mnn;
  public int mno;
  
  public CustomTimePickerNew(Context paramContext)
  {
    super(new ContextThemeWrapper(paramContext, 2131821727));
    AppMethodBeat.i(198414);
    this.mView = null;
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    this.mnn = -1;
    this.mno = -1;
    this.context = paramContext;
    this.QSK = new h(paramContext);
    AppMethodBeat.o(198414);
  }
  
  public CustomTimePickerNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(new ContextThemeWrapper(paramContext, 2131821727), paramAttributeSet);
    AppMethodBeat.i(198415);
    this.mView = null;
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    this.mnn = -1;
    this.mno = -1;
    this.context = paramContext;
    this.QSK = new h(paramContext);
    AppMethodBeat.o(198415);
  }
  
  public CustomTimePickerNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(198416);
    this.mView = null;
    this.mMinTimeHour = -1;
    this.mMinTimeMinute = -1;
    this.mMaxTimeHour = -1;
    this.mMaxTimeMinute = -1;
    this.mnn = -1;
    this.mno = -1;
    this.context = paramContext;
    this.QSK = new h(paramContext);
    AppMethodBeat.o(198416);
  }
  
  public View getView()
  {
    AppMethodBeat.i(198417);
    if (this.mView == null) {
      this.mView = this.QSK.bli();
    }
    View localView = this.mView;
    AppMethodBeat.o(198417);
    return localView;
  }
  
  public final void onShow()
  {
    AppMethodBeat.i(198418);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(11, this.mnn);
    ((Calendar)localObject).set(12, this.mno);
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
        AppMethodBeat.i(198413);
        CustomTimePickerNew.a(CustomTimePickerNew.this, paramAnonymousDate);
        AppMethodBeat.o(198413);
      }
    }).c(new boolean[] { 0, 0, 0, 1, 1, 0 }).b((Calendar)localObject).b(localCalendar1, localCalendar2).hcv();
    int i = android.support.v4.content.b.n(this.context, 2131099657);
    ((com.tencent.mm.ui.widget.picker.b.b)localObject).QSH.jKu = i;
    ((com.tencent.mm.ui.widget.picker.b.b)localObject).c(this.QSK);
    this.QSK.setDividerHeight(this.context.getResources().getDimensionPixelSize(2131165950));
    this.context.getResources().getDimensionPixelSize(2131165299);
    this.QSK.dE(this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296));
    localObject = this.QSK.QTy.bll().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((WheelView)((Iterator)localObject).next()).aps(android.support.v4.content.b.n(this.context, 2131099669)).apr(this.context.getResources().getDimensionPixelSize(2131165296)).setBackgroundColor(android.support.v4.content.b.n(this.context, 2131099653));
    }
    localObject = this.QSK.QTy.bll();
    if (((List)localObject).size() == 1)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165296), 0, this.context.getResources().getDimensionPixelSize(2131165296));
      AppMethodBeat.o(198418);
      return;
    }
    if (((List)localObject).size() == 2)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165296), 0, this.context.getResources().getDimensionPixelSize(2131165296));
      AppMethodBeat.o(198418);
      return;
    }
    if (((List)localObject).size() == 3)
    {
      ((WheelView)((List)localObject).get(0)).setPadding(0, this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296));
      ((WheelView)((List)localObject).get(1)).setPadding(this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296), this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296));
      ((WheelView)((List)localObject).get(2)).setPadding(this.context.getResources().getDimensionPixelSize(2131165277), this.context.getResources().getDimensionPixelSize(2131165296), 0, this.context.getResources().getDimensionPixelSize(2131165296));
    }
    AppMethodBeat.o(198418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.CustomTimePickerNew
 * JD-Core Version:    0.7.0.1
 */