package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.ui.aa;

public class NotInterestMenu
  extends LinearLayout
{
  private static int[] Drk = { 2131766071, 2131766069, 2131766070 };
  private SnsInfo DqO;
  private ListView Drj;
  private c Drl;
  private b Drm;
  private Context mContext;
  
  public NotInterestMenu(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94941);
    this.mContext = null;
    this.DqO = null;
    this.Drl = null;
    this.Drm = null;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(94941);
  }
  
  public NotInterestMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94942);
    this.mContext = null;
    this.DqO = null;
    this.Drl = null;
    this.Drm = null;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(94942);
  }
  
  private void init()
  {
    AppMethodBeat.i(94943);
    aa.jQ(this.mContext).inflate(2131495859, this);
    this.Drj = ((ListView)findViewById(2131305492));
    this.Drj.setAdapter(new a());
    this.Drj.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(94937);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/sns/abtest/NotInterestMenu$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (NotInterestMenu.a(NotInterestMenu.this) != null) {
          NotInterestMenu.a(NotInterestMenu.this).eWx();
        }
        if (NotInterestMenu.b(NotInterestMenu.this) != null) {
          switch (paramAnonymousInt)
          {
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/sns/abtest/NotInterestMenu$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(94937);
          return;
          NotInterestMenu.b(NotInterestMenu.this).c(NotInterestMenu.c(NotInterestMenu.this));
          continue;
          NotInterestMenu.b(NotInterestMenu.this).d(NotInterestMenu.c(NotInterestMenu.this));
          continue;
          NotInterestMenu.b(NotInterestMenu.this).e(NotInterestMenu.c(NotInterestMenu.this));
        }
      }
    });
    AppMethodBeat.o(94943);
  }
  
  public void setOnClickMenuListener(b paramb)
  {
    this.Drm = paramb;
  }
  
  public void setOnSelectMenuItemListener(c paramc)
  {
    this.Drl = paramc;
  }
  
  public void setSnsInfo(SnsInfo paramSnsInfo)
  {
    this.DqO = paramSnsInfo;
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(94938);
      int i = NotInterestMenu.eWw().length;
      AppMethodBeat.o(94938);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(94939);
      paramInt = NotInterestMenu.eWw()[paramInt];
      AppMethodBeat.o(94939);
      return Integer.valueOf(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(94940);
      View localView = paramView;
      if (paramView == null)
      {
        localView = aa.jQ(NotInterestMenu.d(NotInterestMenu.this)).inflate(2131495860, paramViewGroup, false);
        paramView = new a();
        paramView.Dro = ((TextView)localView.findViewById(2131305493));
        localView.setTag(paramView);
      }
      ((a)localView.getTag()).Dro.setText(NotInterestMenu.eWw()[paramInt]);
      AppMethodBeat.o(94940);
      return localView;
    }
    
    final class a
    {
      TextView Dro;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void eWx();
  }
  
  public static abstract interface c
  {
    public abstract void c(SnsInfo paramSnsInfo);
    
    public abstract void d(SnsInfo paramSnsInfo);
    
    public abstract void e(SnsInfo paramSnsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.NotInterestMenu
 * JD-Core Version:    0.7.0.1
 */