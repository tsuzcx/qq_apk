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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class c
  extends b
{
  private boolean AzA;
  a AzB;
  private int AzC;
  private int Azy;
  private boolean Azz;
  private HashMap<String, Bitmap> zVd;
  boolean zVg;
  
  public c(Context paramContext, List<?> paramList, boolean paramBoolean, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(100268);
    this.zVd = new HashMap();
    this.AzC = 0;
    super.gf(gg(paramList));
    this.Azy = 9;
    this.Azz = paramBoolean;
    this.AzB = parama;
    eel();
    eem();
    AppMethodBeat.o(100268);
  }
  
  private void eel()
  {
    AppMethodBeat.i(100270);
    int i = 0;
    while (i < this.Azx)
    {
      d locald = new d((byte)0);
      locald.data = "";
      locald.id = getCount();
      locald.id = getCount();
      add(i, locald);
      i += 1;
    }
    AppMethodBeat.o(100270);
  }
  
  private List<d> gg(List<?> paramList)
  {
    AppMethodBeat.i(100269);
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      d locald = new d((byte)0);
      locald.data = localObject;
      locald.id = i;
      localArrayList.add(locald);
      i += 1;
    }
    AppMethodBeat.o(100269);
    return localArrayList;
  }
  
  public final boolean RC(int paramInt)
  {
    AppMethodBeat.i(100277);
    if (paramInt < this.Azx)
    {
      AppMethodBeat.o(100277);
      return false;
    }
    if (this.AzA)
    {
      if (paramInt != getCount() - 1)
      {
        AppMethodBeat.o(100277);
        return true;
      }
      AppMethodBeat.o(100277);
      return false;
    }
    boolean bool = super.RC(paramInt);
    AppMethodBeat.o(100277);
    return bool;
  }
  
  public final boolean RD(int paramInt)
  {
    AppMethodBeat.i(100278);
    if (paramInt < this.Azx)
    {
      AppMethodBeat.o(100278);
      return false;
    }
    if (this.AzA)
    {
      if (paramInt != getCount() - 1)
      {
        AppMethodBeat.o(100278);
        return true;
      }
      AppMethodBeat.o(100278);
      return false;
    }
    boolean bool = super.RD(paramInt);
    AppMethodBeat.o(100278);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(100272);
    super.clear();
    this.AzA = false;
    AppMethodBeat.o(100272);
  }
  
  public final void eem()
  {
    AppMethodBeat.i(100271);
    ad.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", new Object[] { Boolean.valueOf(this.Azz), Integer.valueOf(getCount()), Integer.valueOf(this.Azx), Integer.valueOf(this.Azy), Boolean.valueOf(this.AzA) });
    if ((this.Azz) && (een() < this.Azy))
    {
      if (!this.AzA)
      {
        this.AzA = true;
        add("");
        AppMethodBeat.o(100271);
      }
    }
    else {
      this.AzA = false;
    }
    AppMethodBeat.o(100271);
  }
  
  public final int een()
  {
    AppMethodBeat.i(100274);
    int j = getCount();
    int k = this.Azx;
    if (this.AzA) {}
    for (int i = 1;; i = 0)
    {
      AppMethodBeat.o(100274);
      return j - k - i;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(100276);
    if (TextUtils.isEmpty(getItem(paramInt).toString()))
    {
      AppMethodBeat.o(100276);
      return 1;
    }
    AppMethodBeat.o(100276);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(100275);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(getContext()).inflate(2131495581, paramViewGroup, false);
      localObject2 = new b((View)localObject1, (byte)0);
      ((View)localObject1).setTag(2131300987, localObject2);
      localObject3 = ((b)localObject2).dsD;
      if (this.AzC == 0)
      {
        ag.dTT();
        i = u.getScreenWidth();
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i != 0) {
          this.AzC = ((i - this.mContext.getResources().getDimensionPixelSize(2131166845) * 4 - this.mContext.getResources().getDimensionPixelSize(2131165483) * 2) / 3);
        }
      }
      else
      {
        paramView = (LinearLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
        paramView.width = this.AzC;
        paramView.height = this.AzC;
        ((ImageView)localObject3).setLayoutParams(paramView);
        paramView = (View)localObject1;
        paramViewGroup = (ViewGroup)localObject2;
      }
      localObject1 = getItem(paramInt).toString();
      localObject2 = paramViewGroup.dsD;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label320;
      }
      ((ImageView)localObject2).setBackgroundResource(2131100938);
      ((ImageView)localObject2).setImageResource(2131689536);
      ((ImageView)localObject2).setContentDescription(paramViewGroup.dsD.getContext().getString(2131763773));
      int i = paramViewGroup.AzD.AzC * 35 / 100;
      ((ImageView)localObject2).setPadding(i, i, i, i);
      if (paramInt <= 0) {
        break label293;
      }
      paramViewGroup.view.setTag(Integer.valueOf(-1));
      label257:
      if (paramInt >= this.Azx) {
        break label445;
      }
      paramViewGroup.dsD.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(100275);
      return paramView;
      paramViewGroup = (b)paramView.getTag(2131300987);
      break;
      label293:
      if (paramInt >= paramViewGroup.AzD.Azx) {
        break label257;
      }
      paramViewGroup.view.setTag(Integer.valueOf(2147483647));
      break label257;
      label320:
      paramViewGroup.view.setTag(Integer.valueOf(paramInt - paramViewGroup.AzD.Azx));
      ((ImageView)localObject2).setBackgroundDrawable(null);
      ((ImageView)localObject2).setTag(localObject1);
      ((ImageView)localObject2).setContentDescription(paramViewGroup.dsD.getContext().getString(2131763849));
      ((ImageView)localObject2).setPadding(0, 0, 0, 0);
      localObject3 = (Bitmap)paramViewGroup.AzD.zVd.get(localObject1);
      if (!q.I((Bitmap)localObject3))
      {
        new c.c(paramViewGroup.AzD, (ImageView)localObject2, (String)localObject1).x(new String[] { "" });
        break label257;
      }
      ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
      break label257;
      label445:
      paramViewGroup.dsD.setVisibility(0);
      paramView.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final void gf(List<?> paramList)
  {
    AppMethodBeat.i(100273);
    super.gf(gg(paramList));
    eel();
    eem();
    AppMethodBeat.o(100273);
  }
  
  public final void hV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100279);
    super.hV(paramInt1, paramInt2);
    if (this.AzB != null) {
      this.AzB.hN(paramInt1 - this.Azx, paramInt2 - this.Azx);
    }
    AppMethodBeat.o(100279);
  }
  
  public static abstract interface a
  {
    public abstract void hN(int paramInt1, int paramInt2);
    
    public abstract void removeItem(int paramInt);
  }
  
  final class b
  {
    ImageView dsD;
    View view;
    
    private b(View paramView)
    {
      AppMethodBeat.i(100263);
      this.view = paramView;
      this.dsD = ((ImageView)paramView.findViewById(2131301202));
      AppMethodBeat.o(100263);
    }
  }
  
  final class d
  {
    public Object data;
    public int id;
    
    private d() {}
    
    public final int hashCode()
    {
      return this.id;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(100267);
      String str = this.data.toString();
      AppMethodBeat.o(100267);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.c
 * JD-Core Version:    0.7.0.1
 */