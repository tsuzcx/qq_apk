package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "", "mGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "mContext", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "count", "", "getCount", "()I", "mColumn", "getMContext", "()Landroid/content/Context;", "getMGridView", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "fillDataToTable", "", "getChanged", "", "position", "getItem", "getView", "Landroid/view/View;", "convertView", "makeRow", "Landroid/widget/TableRow;", "notifyDataChanged", "Companion", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a.a Nsy = new a.a((byte)0);
  private static final String TAG = "MicroMsg.RadarGridView.GridDataAdapter";
  private int NsA;
  private final RadarSpecialGridView Nsz;
  private final Context mContext;
  
  public a(RadarSpecialGridView paramRadarSpecialGridView, Context paramContext)
  {
    this.Nsz = paramRadarSpecialGridView;
    this.mContext = paramContext;
    this.NsA = 3;
  }
  
  private static final void a(a parama, int paramInt, View paramView)
  {
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/radar/ui/GridDataAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "this$0");
    parama = parama.Nsz.getOnItemClickListener();
    if (parama != null)
    {
      s.s(paramView, "v");
      parama.c(paramInt, paramView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/radar/ui/GridDataAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public abstract View aK(View paramView, int paramInt);
  
  public final void cPy()
  {
    if (this.NsA == 0)
    {
      Log.e(TAG, "column is 0, pls check!");
      return;
    }
    int m = getCount();
    if (m > 0) {}
    int k;
    label128:
    label278:
    label283:
    label309:
    for (int i = 0;; i = k)
    {
      k = i + 1;
      int j = i / this.NsA;
      int n = this.Nsz.getMTable().getChildCount();
      Object localObject;
      View localView1;
      View localView2;
      if (n > j)
      {
        localObject = this.Nsz.getMTable().getChildAt(n - 1 - j);
        if (localObject == null) {
          throw new NullPointerException("null cannot be cast to non-null type android.widget.TableRow");
        }
        localObject = (TableRow)localObject;
        n = i % this.NsA;
        int i1 = ((TableRow)localObject).getChildCount();
        boolean bool = gFd();
        if (i1 > n) {
          break label278;
        }
        j = 1;
        if ((j != 0) || (bool))
        {
          localView1 = null;
          n = i1 - 1 - n;
          if (j == 0) {
            localView1 = ((TableRow)localObject).getChildAt(n);
          }
          localView2 = aK(localView1, i);
          if (j == 0) {
            break label283;
          }
          ((TableRow)localObject).addView(localView2, 0);
        }
      }
      for (;;)
      {
        localView2.setOnClickListener(new a..ExternalSyntheticLambda0(this, i));
        if (k < m) {
          break label309;
        }
        Log.v(TAG, s.X("mTable rows count : ", Integer.valueOf(this.Nsz.getMTable().getChildCount())));
        return;
        localObject = new TableRow(this.mContext);
        ((TableRow)localObject).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        this.Nsz.getMTable().addView((View)localObject, 0);
        break;
        j = 0;
        break label128;
        if (localView2 != localView1)
        {
          ((TableRow)localObject).removeViewAt(n);
          ((TableRow)localObject).addView(localView2, n);
        }
      }
    }
  }
  
  public abstract boolean gFd();
  
  public abstract int getCount();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.a
 * JD-Core Version:    0.7.0.1
 */