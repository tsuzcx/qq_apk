package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter;", "", "mGridView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "mContext", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;Landroid/content/Context;)V", "count", "", "getCount", "()I", "mColumn", "getMContext", "()Landroid/content/Context;", "getMGridView", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "fillDataToTable", "", "getChanged", "", "position", "getItem", "getView", "Landroid/view/View;", "convertView", "makeRow", "Landroid/widget/TableRow;", "notifyDataChanged", "Companion", "plugin-radar_release"})
public abstract class a
{
  private static final String TAG = "MicroMsg.RadarGridView.GridDataAdapter";
  public static final a uSV = new a((byte)0);
  private final Context mContext;
  private int uST;
  final RadarSpecialGridView uSU;
  
  public a(RadarSpecialGridView paramRadarSpecialGridView, Context paramContext)
  {
    this.uSU = paramRadarSpecialGridView;
    this.mContext = paramContext;
    this.uST = 3;
  }
  
  public abstract View ak(View paramView, int paramInt);
  
  public final void bsd()
  {
    if (this.uST == 0)
    {
      ad.e(TAG, "column is 0, pls check!");
      return;
    }
    int k = getCount();
    final int i = 0;
    if (i < k)
    {
      int j = i / this.uST;
      int m = this.uSU.getMTable().getChildCount();
      Object localObject;
      label93:
      label117:
      View localView1;
      View localView2;
      if (m > j)
      {
        localObject = this.uSU.getMTable().getChildAt(m - 1 - j);
        if (localObject == null) {
          throw new v("null cannot be cast to non-null type android.widget.TableRow");
        }
        localObject = (TableRow)localObject;
        m = i % this.uST;
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
        localView2 = ak(localView1, i);
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
        this.uSU.getMTable().addView((View)localObject, 0);
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
    ad.v(TAG, "mTable rows count : " + this.uSU.getMTable().getChildCount());
  }
  
  public abstract int getCount();
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/GridDataAdapter$Companion;", "", "()V", "TAG", "", "plugin-radar_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(138585);
      RadarSpecialGridView.a locala = this.uSW.uSU.getOnItemClickListener();
      if (locala != null)
      {
        int i = i;
        k.g(paramView, "v");
        locala.b(i, paramView);
        AppMethodBeat.o(138585);
        return;
      }
      AppMethodBeat.o(138585);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.a
 * JD-Core Version:    0.7.0.1
 */