package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.v;
import com.tencent.mm.plugin.sns.ui.v.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;
import java.util.List;

public final class e
  implements v
{
  private Context context;
  TextView rHh;
  private ImageView rTS;
  private boolean skB;
  c skC;
  DynamicGridView skD;
  v.a skE;
  float skF;
  View skG;
  ImageView skH;
  private View skI;
  private View skJ;
  private int skK;
  private Rect skL;
  
  public e(View paramView1, View paramView2, View paramView3, Context paramContext, List<String> paramList, DynamicGridView paramDynamicGridView, v.a parama, c.a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(40331);
    this.skB = paramBoolean;
    this.context = paramContext;
    this.skE = parama;
    this.skG = paramView2;
    this.skI = paramView3;
    this.skD = paramDynamicGridView;
    this.skH = ((ImageView)paramView2.findViewById(2131828182));
    this.rHh = ((TextView)paramView2.findViewById(2131827973));
    this.skJ = paramView1;
    paramDynamicGridView.setWobbleInEditMode(false);
    ag.coU();
    this.skK = ((s.getScreenWidth() - paramContext.getResources().getDimensionPixelSize(2131428718) * 4 - paramContext.getResources().getDimensionPixelSize(2131427775) * 2) / 3);
    paramDynamicGridView.setColumnWidth(this.skK + paramContext.getResources().getDimensionPixelSize(2131428718) * 2);
    paramDynamicGridView.setNumColumns(3);
    paramDynamicGridView.setOverScrollMode(2);
    paramDynamicGridView.setStretchMode(0);
    paramDynamicGridView.setClipChildren(false);
    paramDynamicGridView.setClipToPadding(false);
    paramDynamicGridView.setSelector(new ColorDrawable(0));
    this.skC = new c(paramContext, paramList, paramBoolean, parama1);
    cxb();
    paramDynamicGridView.setAdapter(this.skC);
    paramDynamicGridView.setOnDragListener(new e.1(this, paramDynamicGridView));
    paramDynamicGridView.setOnItemLongClickListener(new e.2(this));
    paramDynamicGridView.setOnItemClickListener(new e.3(this));
    paramDynamicGridView.setOnDropListener(new e.4(this, paramDynamicGridView, paramView1));
    paramDynamicGridView.getViewTreeObserver().addOnPreDrawListener(new e.5(this, paramDynamicGridView, paramList));
    ag.coU();
    if (s.getScreenWidth() == 0) {
      new ak().postDelayed(new e.6(this, paramList), 50L);
    }
    AppMethodBeat.o(40331);
  }
  
  private void cxb()
  {
    AppMethodBeat.i(40333);
    if ((ah.dsQ().getBoolean("key_show_tips", true)) && (this.skC.cxa() > 1))
    {
      this.skI.setVisibility(0);
      this.rTS = ((ImageView)this.skI.findViewById(2131828175));
      this.rTS.setOnClickListener(new e.7(this));
      AppMethodBeat.o(40333);
      return;
    }
    this.skI.setVisibility(8);
    AppMethodBeat.o(40333);
  }
  
  public final void Fm(int paramInt)
  {
    int i = 3;
    AppMethodBeat.i(40332);
    ag.coU();
    this.skK = ((s.getScreenWidth() - this.context.getResources().getDimensionPixelSize(2131428718) * 4 - this.context.getResources().getDimensionPixelSize(2131427775) * 2) / 3);
    this.skD.setColumnWidth(this.skK + this.context.getResources().getDimensionPixelSize(2131428718) * 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.skD.getLayoutParams();
    ag.coU();
    ab.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", new Object[] { Integer.valueOf(s.getScreenWidth()) });
    paramInt = (paramInt + 3) / 3;
    if (paramInt > 3) {
      paramInt = i;
    }
    for (;;)
    {
      i = localMarginLayoutParams.leftMargin;
      int j = this.skJ.getHeight();
      int k = this.skK;
      int m = this.context.getResources().getDimensionPixelSize(2131428718);
      int n = localMarginLayoutParams.rightMargin;
      float f = d.aow().density;
      localMarginLayoutParams.setMargins(i, j - k - m * 2, n, (int)((4 - paramInt) * (f * 32.0F)));
      this.skD.setLayoutParams(localMarginLayoutParams);
      AppMethodBeat.o(40332);
      return;
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(40335);
    if ((this.skD != null) && (this.skD.getAdapter() == null)) {
      ((c)this.skD.getAdapter()).rKr = true;
    }
    AppMethodBeat.o(40335);
  }
  
  public final View getView()
  {
    return this.skD;
  }
  
  public final void setImageClick(v.a parama)
  {
    this.skE = parama;
  }
  
  public final void setIsShowAddImage(boolean paramBoolean)
  {
    this.skB = paramBoolean;
  }
  
  public final void setList$22875ea3(List<String> paramList)
  {
    AppMethodBeat.i(40334);
    if (this.skC != null)
    {
      this.skC.du(paramList);
      cxb();
    }
    AppMethodBeat.o(40334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.e
 * JD-Core Version:    0.7.0.1
 */