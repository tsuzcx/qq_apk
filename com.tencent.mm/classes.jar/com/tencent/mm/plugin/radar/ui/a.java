package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "", "mGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "mContext", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "count", "", "getCount", "()I", "mColumn", "getMContext", "()Landroid/content/Context;", "getMGridView", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "fillDataToTable", "", "getChanged", "", "position", "getItem", "getView", "Landroid/view/View;", "convertView", "makeRow", "Landroid/widget/TableRow;", "notifyDataChanged", "Companion", "plugin-radar_release"})
public abstract class a
{
  private static final String TAG = "MicroMsg.RadarGridView.GridDataAdapter";
  public static final a.a xjt = new a.a((byte)0);
  private final Context mContext;
  private int xjr;
  final RadarSpecialGridView xjs;
  
  public a(RadarSpecialGridView paramRadarSpecialGridView, Context paramContext)
  {
    this.xjs = paramRadarSpecialGridView;
    this.mContext = paramContext;
    this.xjr = 3;
  }
  
  public abstract View am(View paramView, int paramInt);
  
  public final void bDh()
  {
    if (this.xjr == 0)
    {
      ad.e(TAG, "column is 0, pls check!");
      return;
    }
    int k = getCount();
    final int i = 0;
    if (i < k)
    {
      int j = i / this.xjr;
      int m = this.xjs.getMTable().getChildCount();
      Object localObject;
      label93:
      label117:
      View localView1;
      View localView2;
      if (m > j)
      {
        localObject = this.xjs.getMTable().getChildAt(m - 1 - j);
        if (localObject == null) {
          throw new v("null cannot be cast to non-null type android.widget.TableRow");
        }
        localObject = (TableRow)localObject;
        m = i % this.xjr;
        int n = ((TableRow)localObject).getChildCount();
        if (n > m) {
          break label237;
        }
        j = 1;
        localView1 = null;
        m = n - 1 - m;
        if (j == 0) {
          localView1 = ((TableRow)localObject).getChildAt(m);
        }
        localView2 = am(localView1, i);
        if (j == 0) {
          break label242;
        }
        ((TableRow)localObject).addView(localView2, 0);
      }
      for (;;)
      {
        localView2.setOnClickListener((View.OnClickListener)new b(this, i));
        i += 1;
        break;
        localObject = new TableRow(this.mContext);
        ((TableRow)localObject).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        this.xjs.getMTable().addView((View)localObject, 0);
        break label93;
        label237:
        j = 0;
        break label117;
        label242:
        if (localView2 != localView1)
        {
          ((TableRow)localObject).removeViewAt(m);
          ((TableRow)localObject).addView(localView2, m);
        }
      }
    }
    ad.v(TAG, "mTable rows count : " + this.xjs.getMTable().getChildCount());
  }
  
  public abstract int getCount();
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138585);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/radar/ui/GridDataAdapter$fillDataToTable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      localObject = this.xju.xjs.getOnItemClickListener();
      if (localObject != null)
      {
        int i = i;
        p.g(paramView, "v");
        ((RadarSpecialGridView.a)localObject).b(i, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/radar/ui/GridDataAdapter$fillDataToTable$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(138585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.a
 * JD-Core Version:    0.7.0.1
 */