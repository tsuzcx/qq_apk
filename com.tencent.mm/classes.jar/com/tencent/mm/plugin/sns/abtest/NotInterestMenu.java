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
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.ui.z;

public class NotInterestMenu
  extends LinearLayout
{
  private static int[] yWi = { 2131763845, 2131763843, 2131763844 };
  private Context mContext;
  private p yVM;
  private ListView yWh;
  private c yWj;
  private b yWk;
  
  public NotInterestMenu(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(94941);
    this.mContext = null;
    this.yVM = null;
    this.yWj = null;
    this.yWk = null;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(94941);
  }
  
  public NotInterestMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(94942);
    this.mContext = null;
    this.yVM = null;
    this.yWj = null;
    this.yWk = null;
    this.mContext = paramContext;
    init();
    AppMethodBeat.o(94942);
  }
  
  private void init()
  {
    AppMethodBeat.i(94943);
    z.jO(this.mContext).inflate(2131495027, this);
    this.yWh = ((ListView)findViewById(2131302908));
    this.yWh.setAdapter(new a());
    this.yWh.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(94937);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/sns/abtest/NotInterestMenu$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (NotInterestMenu.a(NotInterestMenu.this) != null) {
          NotInterestMenu.a(NotInterestMenu.this).dRa();
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
    this.yWk = paramb;
  }
  
  public void setOnSelectMenuItemListener(c paramc)
  {
    this.yWj = paramc;
  }
  
  public void setSnsInfo(p paramp)
  {
    this.yVM = paramp;
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(94938);
      int i = NotInterestMenu.dQZ().length;
      AppMethodBeat.o(94938);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(94939);
      paramInt = NotInterestMenu.dQZ()[paramInt];
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
        localView = z.jO(NotInterestMenu.d(NotInterestMenu.this)).inflate(2131495028, paramViewGroup, false);
        paramView = new a();
        paramView.yWm = ((TextView)localView.findViewById(2131302909));
        localView.setTag(paramView);
      }
      ((a)localView.getTag()).yWm.setText(NotInterestMenu.dQZ()[paramInt]);
      AppMethodBeat.o(94940);
      return localView;
    }
    
    final class a
    {
      TextView yWm;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void dRa();
  }
  
  public static abstract interface c
  {
    public abstract void c(p paramp);
    
    public abstract void d(p paramp);
    
    public abstract void e(p paramp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.NotInterestMenu
 * JD-Core Version:    0.7.0.1
 */