package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public final class l
{
  private int bgColor;
  private Context context;
  private int gHR;
  private int gHS;
  private ViewGroup nhB;
  private LinkedHashMap<String, i> oJh;
  private LayoutInflater oJi;
  private List<s> oKY;
  
  public l(List<s> paramList, Context paramContext, int paramInt, ViewGroup paramViewGroup)
  {
    this.oKY = paramList;
    this.context = paramContext;
    this.bgColor = paramInt;
    this.nhB = paramViewGroup;
  }
  
  public final Collection<i> bFL()
  {
    if (this.oJh == null) {
      return Collections.EMPTY_LIST;
    }
    return this.oJh.values();
  }
  
  public final void bFX()
  {
    if ((this.oKY == null) || (this.oKY.isEmpty())) {
      return;
    }
    if (this.oJh == null) {
      this.oJh = new LinkedHashMap();
    }
    Object localObject;
    if (this.oJi == null)
    {
      this.oJi = ((LayoutInflater)this.context.getSystemService("layout_inflater"));
      localObject = (WindowManager)this.context.getSystemService("window");
      this.gHR = ((WindowManager)localObject).getDefaultDisplay().getWidth();
      this.gHS = ((WindowManager)localObject).getDefaultDisplay().getHeight();
    }
    int i = 0;
    while (i < this.oKY.size())
    {
      s locals = (s)this.oKY.get(i);
      localObject = (i)this.oJh.get(locals.oDg);
      if (localObject != null) {
        ((i)localObject).a(locals);
      }
      try
      {
        label156:
        if (this.nhB != ((i)localObject).getView().getParent())
        {
          if (this.nhB.getChildCount() <= i) {
            break label243;
          }
          this.nhB.addView(((i)localObject).getView(), i);
        }
        for (;;)
        {
          i += 1;
          break;
          i locali = al.a(this.context, locals, this.nhB, this.bgColor);
          localObject = locali;
          if (locali == null) {
            break label156;
          }
          this.oJh.put(locals.oDg, locali);
          localObject = locali;
          break label156;
          label243:
          this.nhB.addView(((i)localObject).getView());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("CompRenderer", "component may have same id %s,%s", new Object[] { locals.oDg, bk.j(localException) });
        }
      }
    }
  }
  
  public final void cA(List<s> paramList)
  {
    if ((paramList != null) && (!paramList.equals(this.oKY)))
    {
      this.oKY = paramList;
      bFX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l
 * JD-Core Version:    0.7.0.1
 */