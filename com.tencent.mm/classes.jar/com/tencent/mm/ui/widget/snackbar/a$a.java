package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import java.util.Queue;

public final class a$a
{
  private int FY = -1;
  String ljq;
  private Context mContext;
  String wpJ;
  private int wpK = 0;
  private Parcelable wpL;
  private short wpM = 3500;
  a wpV;
  private int wpW = 0;
  
  public a$a(Activity paramActivity)
  {
    this.mContext = paramActivity.getApplicationContext();
    this.wpV = new a(paramActivity, this.wpW);
  }
  
  public a$a(Context paramContext, View paramView)
  {
    this.mContext = paramContext;
    this.wpV = new a(paramContext, paramView, this.wpW);
  }
  
  public final a a(a.c paramc)
  {
    this.wpV.wpQ = paramc;
    return this;
  }
  
  public final a a(Short paramShort)
  {
    this.wpM = paramShort.shortValue();
    return this;
  }
  
  public final a cKv()
  {
    Object localObject2 = this.ljq;
    Object localObject1;
    int j;
    Object localObject3;
    short s;
    if (this.wpJ != null)
    {
      localObject1 = this.wpJ.toUpperCase();
      j = this.wpK;
      localObject3 = this.wpL;
      s = this.wpM;
      if (this.FY == -1) {
        break label188;
      }
    }
    label188:
    for (int i = this.FY;; i = this.mContext.getResources().getColor(com.tencent.mm.ci.a.c.wechat_green))
    {
      localObject2 = new Snack((String)localObject2, (String)localObject1, j, (Parcelable)localObject3, s, i);
      Object localObject4 = this.wpV;
      localObject1 = ((a)localObject4).wpO;
      localObject3 = ((a)localObject4).mParentView;
      localObject4 = ((a)localObject4).wpQ;
      if ((((View)localObject3).getParent() != null) && (((View)localObject3).getParent() != localObject1)) {
        ((ViewGroup)((View)localObject3).getParent()).removeView((View)localObject3);
      }
      localObject2 = new SnackContainer.a((Snack)localObject2, (View)localObject3, (a.c)localObject4, (byte)0);
      ((SnackContainer)localObject1).wpY.offer(localObject2);
      if (((SnackContainer)localObject1).wpY.size() == 1) {
        ((SnackContainer)localObject1).a((SnackContainer.a)localObject2);
      }
      return this.wpV;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.a.a
 * JD-Core Version:    0.7.0.1
 */