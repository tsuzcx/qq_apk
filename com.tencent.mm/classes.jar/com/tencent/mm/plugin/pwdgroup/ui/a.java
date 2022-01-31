package com.tencent.mm.plugin.pwdgroup.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.pwdgroup.b.a;
import com.tencent.mm.protocal.protobuf.abw;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  private LinkedList<abw> lqf;
  private Context mContext;
  private Animation nTC;
  private Animation pGP;
  private Animation pGQ;
  private HashMap<String, Boolean> pGR;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(24033);
    this.lqf = new LinkedList();
    this.pGR = new HashMap();
    this.mContext = paramContext;
    this.nTC = AnimationUtils.loadAnimation(this.mContext, 2131034125);
    this.pGQ = AnimationUtils.loadAnimation(this.mContext, 2131034125);
    this.pGP = AnimationUtils.loadAnimation(this.mContext, 2131034126);
    this.nTC.setInterpolator(new AccelerateDecelerateInterpolator());
    this.pGQ.setInterpolator(new AccelerateInterpolator());
    this.pGP.setInterpolator(new AccelerateDecelerateInterpolator());
    this.nTC.setDuration(300L);
    this.pGQ.setDuration(1000L);
    this.pGP.setDuration(1000L);
    AppMethodBeat.o(24033);
  }
  
  private static String a(abw paramabw)
  {
    AppMethodBeat.i(24038);
    if (paramabw == null)
    {
      AppMethodBeat.o(24038);
      return "";
    }
    if (bo.isNullOrNil(paramabw.jJA))
    {
      paramabw = paramabw.wSo;
      AppMethodBeat.o(24038);
      return paramabw;
    }
    paramabw = paramabw.jJA;
    AppMethodBeat.o(24038);
    return paramabw;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(24035);
    if (this.lqf == null)
    {
      AppMethodBeat.o(24035);
      return 1;
    }
    int i = this.lqf.size();
    AppMethodBeat.o(24035);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(24036);
    if (this.lqf == null)
    {
      AppMethodBeat.o(24036);
      return null;
    }
    if (paramInt >= this.lqf.size())
    {
      AppMethodBeat.o(24036);
      return null;
    }
    Object localObject = this.lqf.get(paramInt);
    AppMethodBeat.o(24036);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24037);
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2130969523, null);
      paramViewGroup = new a.a(this, paramView);
      paramView.setTag(paramViewGroup);
      localObject = (abw)getItem(paramInt);
      if (localObject != null)
      {
        if (!bo.isNullOrNil(((abw)localObject).jKG)) {
          break label260;
        }
        paramViewGroup.gui.setText(((abw)localObject).jJA);
        label84:
        if (bo.isNullOrNil(((abw)localObject).jJA)) {
          break label275;
        }
        b.a.c(paramViewGroup.iTH, ((abw)localObject).jJA);
      }
    }
    for (;;)
    {
      localObject = a((abw)localObject);
      paramView.clearAnimation();
      if ((this.pGR.containsKey(localObject)) && (!((Boolean)this.pGR.get(localObject)).booleanValue()))
      {
        paramView.startAnimation(this.nTC);
        this.pGR.put(localObject, Boolean.TRUE);
      }
      if (paramInt + 1 == getCount())
      {
        paramViewGroup.gui.setText("");
        paramViewGroup.iTH.setImageResource(2130837611);
        if (paramView != null)
        {
          this.pGQ.setAnimationListener(new a.1(this, paramView));
          this.pGP.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(24031);
              paramView.startAnimation(a.b(a.this));
              AppMethodBeat.o(24031);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation) {}
          });
          paramView.startAnimation(this.pGQ);
        }
      }
      AppMethodBeat.o(24037);
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label260:
      paramViewGroup.gui.setText(((abw)localObject).jKG);
      break label84;
      label275:
      b.a.c(paramViewGroup.iTH, ((abw)localObject).wSo);
    }
  }
  
  public final void setData(LinkedList<abw> paramLinkedList)
  {
    AppMethodBeat.i(24034);
    this.lqf = paramLinkedList;
    if ((this.lqf != null) && (this.lqf.size() > 0))
    {
      int j = this.lqf.size();
      int i = 0;
      while (i < j)
      {
        paramLinkedList = a((abw)this.lqf.get(i));
        if (!this.pGR.containsKey(paramLinkedList)) {
          this.pGR.put(paramLinkedList, Boolean.FALSE);
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    AppMethodBeat.o(24034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.a
 * JD-Core Version:    0.7.0.1
 */