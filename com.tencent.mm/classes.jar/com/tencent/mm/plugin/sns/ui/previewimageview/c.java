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
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class c
  extends b
{
  private HashMap<String, Bitmap> EuX;
  boolean Eva;
  private int FbB;
  private boolean FbC;
  private boolean FbD;
  a FbE;
  private int FbF;
  
  public c(Context paramContext, List<?> paramList, boolean paramBoolean, a parama)
  {
    super(paramContext);
    AppMethodBeat.i(100268);
    this.EuX = new HashMap();
    this.FbF = 0;
    super.hl(hm(paramList));
    this.FbB = 9;
    this.FbC = paramBoolean;
    this.FbE = parama;
    fku();
    fkv();
    AppMethodBeat.o(100268);
  }
  
  private void fku()
  {
    AppMethodBeat.i(100270);
    int i = 0;
    while (i < this.FbA)
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
  
  private List<d> hm(List<?> paramList)
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
  
  public final boolean aaf(int paramInt)
  {
    AppMethodBeat.i(100277);
    if (paramInt < this.FbA)
    {
      AppMethodBeat.o(100277);
      return false;
    }
    if (this.FbD)
    {
      if (paramInt != getCount() - 1)
      {
        AppMethodBeat.o(100277);
        return true;
      }
      AppMethodBeat.o(100277);
      return false;
    }
    boolean bool = super.aaf(paramInt);
    AppMethodBeat.o(100277);
    return bool;
  }
  
  public final boolean aag(int paramInt)
  {
    AppMethodBeat.i(100278);
    if (paramInt < this.FbA)
    {
      AppMethodBeat.o(100278);
      return false;
    }
    if (this.FbD)
    {
      if (paramInt != getCount() - 1)
      {
        AppMethodBeat.o(100278);
        return true;
      }
      AppMethodBeat.o(100278);
      return false;
    }
    boolean bool = super.aag(paramInt);
    AppMethodBeat.o(100278);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(100272);
    super.clear();
    this.FbD = false;
    AppMethodBeat.o(100272);
  }
  
  public final void fkv()
  {
    AppMethodBeat.i(100271);
    Log.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", new Object[] { Boolean.valueOf(this.FbC), Integer.valueOf(getCount()), Integer.valueOf(this.FbA), Integer.valueOf(this.FbB), Boolean.valueOf(this.FbD) });
    if ((this.FbC) && (fkw() < this.FbB))
    {
      if (!this.FbD)
      {
        this.FbD = true;
        add("");
        AppMethodBeat.o(100271);
      }
    }
    else {
      this.FbD = false;
    }
    AppMethodBeat.o(100271);
  }
  
  public final int fkw()
  {
    AppMethodBeat.i(100274);
    int j = getCount();
    int k = this.FbA;
    if (this.FbD) {}
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
      localObject1 = LayoutInflater.from(getContext()).inflate(2131496478, paramViewGroup, false);
      localObject2 = new b((View)localObject1, (byte)0);
      ((View)localObject1).setTag(2131302628, localObject2);
      localObject3 = ((b)localObject2).dKU;
      if (this.FbF == 0)
      {
        aj.faD();
        i = com.tencent.mm.plugin.sns.storage.r.getScreenWidth();
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (i != 0) {
          this.FbF = ((i - this.mContext.getResources().getDimensionPixelSize(2131166972) * 4 - this.mContext.getResources().getDimensionPixelSize(2131165501) * 2) / 3);
        }
      }
      else
      {
        paramView = (LinearLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
        paramView.width = this.FbF;
        paramView.height = this.FbF;
        ((ImageView)localObject3).setLayoutParams(paramView);
        paramView = (View)localObject1;
        paramViewGroup = (ViewGroup)localObject2;
      }
      localObject1 = getItem(paramInt).toString();
      localObject2 = paramViewGroup.dKU;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label320;
      }
      ((ImageView)localObject2).setBackgroundResource(2131101156);
      ((ImageView)localObject2).setImageResource(2131689539);
      ((ImageView)localObject2).setContentDescription(paramViewGroup.dKU.getContext().getString(2131765995));
      int i = paramViewGroup.FbG.FbF * 35 / 100;
      ((ImageView)localObject2).setPadding(i, i, i, i);
      if (paramInt <= 0) {
        break label293;
      }
      paramViewGroup.view.setTag(Integer.valueOf(-1));
      label257:
      if (paramInt >= this.FbA) {
        break label445;
      }
      paramViewGroup.dKU.setVisibility(4);
    }
    for (;;)
    {
      AppMethodBeat.o(100275);
      return paramView;
      paramViewGroup = (b)paramView.getTag(2131302628);
      break;
      label293:
      if (paramInt >= paramViewGroup.FbG.FbA) {
        break label257;
      }
      paramViewGroup.view.setTag(Integer.valueOf(2147483647));
      break label257;
      label320:
      paramViewGroup.view.setTag(Integer.valueOf(paramInt - paramViewGroup.FbG.FbA));
      ((ImageView)localObject2).setBackgroundDrawable(null);
      ((ImageView)localObject2).setTag(localObject1);
      ((ImageView)localObject2).setContentDescription(paramViewGroup.dKU.getContext().getString(2131766075));
      ((ImageView)localObject2).setPadding(0, 0, 0, 0);
      localObject3 = (Bitmap)paramViewGroup.FbG.EuX.get(localObject1);
      if (!com.tencent.mm.plugin.sns.data.r.M((Bitmap)localObject3))
      {
        new c(paramViewGroup.FbG, (ImageView)localObject2, (String)localObject1).y(new String[] { "" });
        break label257;
      }
      ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
      break label257;
      label445:
      paramViewGroup.dKU.setVisibility(0);
      paramView.setVisibility(0);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final void hl(List<?> paramList)
  {
    AppMethodBeat.i(100273);
    super.hl(hm(paramList));
    fku();
    fkv();
    AppMethodBeat.o(100273);
  }
  
  public final void iT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100279);
    super.iT(paramInt1, paramInt2);
    if (this.FbE != null) {
      this.FbE.iK(paramInt1 - this.FbA, paramInt2 - this.FbA);
    }
    AppMethodBeat.o(100279);
  }
  
  public static abstract interface a
  {
    public abstract void iK(int paramInt1, int paramInt2);
    
    public abstract void removeItem(int paramInt);
  }
  
  final class b
  {
    ImageView dKU;
    View view;
    
    private b(View paramView)
    {
      AppMethodBeat.i(100263);
      this.view = paramView;
      this.dKU = ((ImageView)paramView.findViewById(2131302874));
      AppMethodBeat.o(100263);
    }
  }
  
  final class c
    extends h<String, Integer, Boolean>
  {
    private ImageView dPk;
    private Bitmap iKs;
    private String path;
    
    public c(ImageView paramImageView, String paramString)
    {
      this.dPk = paramImageView;
      this.path = paramString;
    }
    
    public final ExecutorService eGk()
    {
      AppMethodBeat.i(179372);
      ExecutorService localExecutorService = aj.fay();
      AppMethodBeat.o(179372);
      return localExecutorService;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.c
 * JD-Core Version:    0.7.0.1
 */