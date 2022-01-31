package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ListView;
import com.tencent.mm.model.bj;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ReaderItemListView
  extends ListView
{
  private Context context;
  private LayoutInflater fhz;
  n.d ifj;
  List<bj> npj = new ArrayList();
  ReaderItemListView.a npk;
  View.OnCreateContextMenuListener npl;
  private DisplayMetrics npm;
  int position = 0;
  int type = 0;
  
  public ReaderItemListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ReaderItemListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    boolean bool = false;
    this.context = paramContext;
    this.fhz = y.gt(paramContext);
    this.type = ((Activity)paramContext).getIntent().getIntExtra("type", 0);
    if (bj.hS(this.type) != null) {
      bool = true;
    }
    Assert.assertTrue(bool);
    this.npm = getResources().getDisplayMetrics();
    this.npk = new ReaderItemListView.a(this);
    setAdapter(this.npk);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.ui.ReaderItemListView
 * JD-Core Version:    0.7.0.1
 */