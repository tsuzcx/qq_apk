package com.tencent.mm.plugin.sns.ad.timeline.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public abstract class b<T extends c>
  implements c
{
  Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  protected void a(T paramT, SnsInfo paramSnsInfo, d paramd) {}
  
  public boolean a(View paramView, int paramInt, SnsInfo paramSnsInfo, d paramd)
  {
    boolean bool1;
    if ((paramView == null) || (paramSnsInfo == null)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        c localc = j(paramSnsInfo);
        if (localc != null)
        {
          boolean bool2 = localc.a(paramView, paramInt, paramSnsInfo, paramd);
          bool1 = bool2;
          if (!bool2) {
            continue;
          }
          a(localc, paramSnsInfo, paramd);
          return bool2;
        }
      }
      catch (Throwable paramView) {}
    }
    return false;
  }
  
  protected abstract T j(SnsInfo paramSnsInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.a.b
 * JD-Core Version:    0.7.0.1
 */