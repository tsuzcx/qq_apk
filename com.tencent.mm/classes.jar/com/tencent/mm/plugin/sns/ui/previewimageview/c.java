package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class c
  extends b
{
  private HashMap<String, Bitmap> rKo;
  boolean rKr;
  private int skv;
  private boolean skw;
  private boolean skx;
  c.a sky;
  private int skz;
  
  public c(Context paramContext, List<?> paramList, boolean paramBoolean, c.a parama)
  {
    super(paramContext);
    AppMethodBeat.i(40306);
    this.rKo = new HashMap();
    this.skz = 0;
    super.du(dv(paramList));
    this.skv = 9;
    this.skw = paramBoolean;
    this.sky = parama;
    cwY();
    cwZ();
    AppMethodBeat.o(40306);
  }
  
  private void cwY()
  {
    AppMethodBeat.i(40308);
    int i = 0;
    while (i < this.sku)
    {
      c.d locald = new c.d(this, (byte)0);
      locald.data = "";
      locald.id = getCount();
      locald.id = getCount();
      add(i, locald);
      i += 1;
    }
    AppMethodBeat.o(40308);
  }
  
  private List<c.d> dv(List<?> paramList)
  {
    AppMethodBeat.i(40307);
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      c.d locald = new c.d(this, (byte)0);
      locald.data = localObject;
      locald.id = i;
      localArrayList.add(locald);
      i += 1;
    }
    AppMethodBeat.o(40307);
    return localArrayList;
  }
  
  public final boolean Fk(int paramInt)
  {
    AppMethodBeat.i(40315);
    if (paramInt < this.sku)
    {
      AppMethodBeat.o(40315);
      return false;
    }
    if (this.skx)
    {
      if (paramInt != getCount() - 1)
      {
        AppMethodBeat.o(40315);
        return true;
      }
      AppMethodBeat.o(40315);
      return false;
    }
    boolean bool = super.Fk(paramInt);
    AppMethodBeat.o(40315);
    return bool;
  }
  
  public final boolean Fl(int paramInt)
  {
    AppMethodBeat.i(40316);
    if (paramInt < this.sku)
    {
      AppMethodBeat.o(40316);
      return false;
    }
    if (this.skx)
    {
      if (paramInt != getCount() - 1)
      {
        AppMethodBeat.o(40316);
        return true;
      }
      AppMethodBeat.o(40316);
      return false;
    }
    boolean bool = super.Fl(paramInt);
    AppMethodBeat.o(40316);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(40310);
    super.clear();
    this.skx = false;
    AppMethodBeat.o(40310);
  }
  
  public final void cwZ()
  {
    AppMethodBeat.i(40309);
    ab.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", new Object[] { Boolean.valueOf(this.skw), Integer.valueOf(getCount()), Integer.valueOf(this.sku), Integer.valueOf(this.skv), Boolean.valueOf(this.skx) });
    if ((this.skw) && (cxa() < this.skv))
    {
      if (!this.skx)
      {
        this.skx = true;
        add("");
        AppMethodBeat.o(40309);
      }
    }
    else {
      this.skx = false;
    }
    AppMethodBeat.o(40309);
  }
  
  public final int cxa()
  {
    AppMethodBeat.i(40312);
    int j = getCount();
    int k = this.sku;
    if (this.skx) {}
    for (int i = 1;; i = 0)
    {
      AppMethodBeat.o(40312);
      return j - k - i;
    }
  }
  
  public final void du(List<?> paramList)
  {
    AppMethodBeat.i(40311);
    super.du(dv(paramList));
    cwY();
    cwZ();
    AppMethodBeat.o(40311);
  }
  
  public final void fO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40317);
    super.fO(paramInt1, paramInt2);
    if (this.sky != null) {
      this.sky.fH(paramInt1 - this.sku, paramInt2 - this.sku);
    }
    AppMethodBeat.o(40317);
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(40314);
    if (TextUtils.isEmpty(getItem(paramInt).toString()))
    {
      AppMethodBeat.o(40314);
      return 1;
    }
    AppMethodBeat.o(40314);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(40313);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(getContext()).inflate(2130970857, paramViewGroup, false);
      localObject2 = new c.b(this, (View)localObject1, (byte)0);
      ((View)localObject1).setTag(2131820631, localObject2);
      localObject3 = ((c.b)localObject2).cuM;
      if (this.skz == 0)
      {
        ag.coU();
        i = s.getScreenWidth();
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i != 0) {
          this.skz = ((i - this.mContext.getResources().getDimensionPixelSize(2131428718) * 4 - this.mContext.getResources().getDimensionPixelSize(2131427775) * 2) / 3);
        }
      }
      else
      {
        paramView = (LinearLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
        paramView.width = this.skz;
        paramView.height = this.skz;
        ((ImageView)localObject3).setLayoutParams(paramView);
        paramView = (View)localObject1;
        paramViewGroup = (ViewGroup)localObject2;
      }
      localObject1 = getItem(paramInt).toString();
      localObject2 = paramViewGroup.cuM;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label321;
      }
      ((ImageView)localObject2).setBackgroundResource(2131690511);
      ((ImageView)localObject2).setImageResource(2131230781);
      ((ImageView)localObject2).setContentDescription(paramViewGroup.cuM.getContext().getString(2131303770));
      int i = paramViewGroup.skA.skz * 35 / 100;
      ((ImageView)localObject2).setPadding(i, i, i, i);
      if (paramInt <= 0) {
        break label294;
      }
      paramViewGroup.view.setTag(Integer.valueOf(-1));
      label258:
      if (paramInt >= this.sku) {
        break label446;
      }
      paramViewGroup.cuM.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(40313);
      return paramView;
      paramViewGroup = (c.b)paramView.getTag(2131820631);
      break;
      label294:
      if (paramInt >= paramViewGroup.skA.sku) {
        break label258;
      }
      paramViewGroup.view.setTag(Integer.valueOf(2147483647));
      break label258;
      label321:
      paramViewGroup.view.setTag(Integer.valueOf(paramInt - paramViewGroup.skA.sku));
      ((ImageView)localObject2).setBackgroundDrawable(null);
      ((ImageView)localObject2).setTag(localObject1);
      ((ImageView)localObject2).setContentDescription(paramViewGroup.cuM.getContext().getString(2131303840));
      ((ImageView)localObject2).setPadding(0, 0, 0, 0);
      localObject3 = (Bitmap)paramViewGroup.skA.rKo.get(localObject1);
      if (!i.A((Bitmap)localObject3))
      {
        new c.c(paramViewGroup.skA, (ImageView)localObject2, (String)localObject1).v(new String[] { "" });
        break label258;
      }
      ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
      break label258;
      label446:
      paramViewGroup.cuM.setVisibility(0);
      paramView.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.c
 * JD-Core Version:    0.7.0.1
 */