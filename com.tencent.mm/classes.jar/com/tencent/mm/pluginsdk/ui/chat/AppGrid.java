package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;

public class AppGrid
  extends GridView
{
  Context context;
  private SharedPreferences dnD;
  AdapterView.OnItemClickListener idL = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).Eg(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).zn(paramAnonymousInt));
    }
  };
  AdapterView.OnItemLongClickListener kec = new AdapterView.OnItemLongClickListener()
  {
    public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
      int i = AppGrid.c(AppGrid.this).Eg(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
      AppGrid.d(AppGrid.this).zn(paramAnonymousInt);
      paramAnonymousAdapterView.Eh(i);
      return true;
    }
  };
  int sdA;
  int sdB = 0;
  int sdC = 0;
  int sdD;
  int sdE;
  AppGrid.a sdF;
  private AppGrid.b sdz;
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
  }
  
  public int getCount()
  {
    return this.sdF.getCount();
  }
  
  public void setOnAppSelectedListener(AppGrid.b paramb)
  {
    this.sdz = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid
 * JD-Core Version:    0.7.0.1
 */