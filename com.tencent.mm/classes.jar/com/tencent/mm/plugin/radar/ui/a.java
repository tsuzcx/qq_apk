package com.tencent.mm.plugin.radar.ui;

import a.k;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import com.tencent.mm.sdk.platformtools.y;

public abstract class a
{
  private static final String TAG = "MicroMsg.RadarGridView.GridDataAdapter";
  public static final a.a nlJ = new a.a((byte)0);
  private final Context mContext;
  private int nlH;
  final RadarSpecialGridView nlI;
  
  public a(RadarSpecialGridView paramRadarSpecialGridView, Context paramContext)
  {
    this.nlI = paramRadarSpecialGridView;
    this.mContext = paramContext;
    this.nlH = 3;
  }
  
  public abstract View L(View paramView, int paramInt);
  
  public final void buD()
  {
    if (this.nlH == 0)
    {
      y.e(TAG, "column is 0, pls check!");
      return;
    }
    int k = getCount();
    int i = 0;
    if (i < k)
    {
      int j = i / this.nlH;
      int m = this.nlI.getMTable().getChildCount();
      Object localObject;
      label93:
      label117:
      View localView1;
      View localView2;
      if (m > j)
      {
        localObject = this.nlI.getMTable().getChildAt(m - 1 - j);
        if (localObject == null) {
          throw new k("null cannot be cast to non-null type android.widget.TableRow");
        }
        localObject = (TableRow)localObject;
        m = i % this.nlH;
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
        localView2 = L(localView1, i);
        if (j == 0) {
          break label242;
        }
        ((TableRow)localObject).addView(localView2, 0);
      }
      for (;;)
      {
        localView2.setOnClickListener((View.OnClickListener)new a.b(this, i));
        i += 1;
        break;
        localObject = new TableRow(this.mContext);
        ((TableRow)localObject).setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        this.nlI.getMTable().addView((View)localObject, 0);
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
    y.v(TAG, "mTable rows count : " + this.nlI.getMTable().getChildCount());
  }
  
  public abstract int getCount();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.a
 * JD-Core Version:    0.7.0.1
 */