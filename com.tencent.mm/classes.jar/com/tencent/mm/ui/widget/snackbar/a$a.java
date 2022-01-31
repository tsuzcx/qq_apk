package com.tencent.mm.ui.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;

public final class a$a
{
  String AKn;
  private int AKo;
  private Parcelable AKp;
  private short AKq;
  private a AKz;
  private int GF;
  private int hQn;
  private Context mContext;
  String nGF;
  
  public a$a(Activity paramActivity)
  {
    AppMethodBeat.i(112976);
    this.AKo = 0;
    this.AKq = 3500;
    this.GF = -1;
    this.hQn = 0;
    this.mContext = paramActivity.getApplicationContext();
    this.AKz = new a(paramActivity, this.hQn);
    AppMethodBeat.o(112976);
  }
  
  public a$a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(112977);
    this.AKo = 0;
    this.AKq = 3500;
    this.GF = -1;
    this.hQn = 0;
    this.mContext = paramContext;
    this.AKz = new a(paramContext, paramView, this.hQn);
    AppMethodBeat.o(112977);
  }
  
  public final a a(a.b paramb)
  {
    this.AKz.AKt = paramb;
    return this;
  }
  
  public final a a(a.c paramc)
  {
    this.AKz.AKu = paramc;
    return this;
  }
  
  public final a a(Short paramShort)
  {
    AppMethodBeat.i(112978);
    this.AKq = paramShort.shortValue();
    AppMethodBeat.o(112978);
    return this;
  }
  
  public final a dPA()
  {
    AppMethodBeat.i(112979);
    Object localObject2 = this.nGF;
    Object localObject1;
    int j;
    Object localObject3;
    short s;
    if (this.AKn != null)
    {
      localObject1 = this.AKn.toUpperCase();
      j = this.AKo;
      localObject3 = this.AKp;
      s = this.AKq;
      if (this.GF == -1) {
        break label210;
      }
    }
    label210:
    for (int i = this.GF;; i = this.mContext.getResources().getColor(2131690701))
    {
      localObject2 = new Snack((String)localObject2, (String)localObject1, j, (Parcelable)localObject3, s, i);
      Object localObject4 = this.AKz;
      if (((a)localObject4).AKs != null)
      {
        localObject1 = ((a)localObject4).AKs;
        localObject3 = ((a)localObject4).mParentView;
        localObject4 = ((a)localObject4).AKu;
        if ((((View)localObject3).getParent() != null) && (((View)localObject3).getParent() != localObject1)) {
          ((ViewGroup)((View)localObject3).getParent()).removeView((View)localObject3);
        }
        localObject2 = new SnackContainer.a((Snack)localObject2, (View)localObject3, (a.c)localObject4, (byte)0);
        ((SnackContainer)localObject1).AKB.offer(localObject2);
        if (((SnackContainer)localObject1).AKB.size() == 1) {
          ((SnackContainer)localObject1).a((SnackContainer.a)localObject2);
        }
      }
      localObject1 = this.AKz;
      AppMethodBeat.o(112979);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.a.a
 * JD-Core Version:    0.7.0.1
 */