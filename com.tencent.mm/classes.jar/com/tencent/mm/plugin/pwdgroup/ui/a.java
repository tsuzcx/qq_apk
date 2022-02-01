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
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private LinkedList<ags> pjZ;
  private Animation tPe;
  private Animation vRV;
  private Animation vRW;
  private HashMap<String, Boolean> vRX;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(27672);
    this.pjZ = new LinkedList();
    this.vRX = new HashMap();
    this.mContext = paramContext;
    this.tPe = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.vRW = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.vRV = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    this.tPe.setInterpolator(new AccelerateDecelerateInterpolator());
    this.vRW.setInterpolator(new AccelerateInterpolator());
    this.vRV.setInterpolator(new AccelerateDecelerateInterpolator());
    this.tPe.setDuration(300L);
    this.vRW.setDuration(1000L);
    this.vRV.setDuration(1000L);
    AppMethodBeat.o(27672);
  }
  
  private static String a(ags paramags)
  {
    AppMethodBeat.i(27677);
    if (paramags == null)
    {
      AppMethodBeat.o(27677);
      return "";
    }
    if (bs.isNullOrNil(paramags.ncR))
    {
      paramags = paramags.EyO;
      AppMethodBeat.o(27677);
      return paramags;
    }
    paramags = paramags.ncR;
    AppMethodBeat.o(27677);
    return paramags;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(27674);
    if (this.pjZ == null)
    {
      AppMethodBeat.o(27674);
      return 1;
    }
    int i = this.pjZ.size();
    AppMethodBeat.o(27674);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(27675);
    if (this.pjZ == null)
    {
      AppMethodBeat.o(27675);
      return null;
    }
    if (paramInt >= this.pjZ.size())
    {
      AppMethodBeat.o(27675);
      return null;
    }
    Object localObject = this.pjZ.get(paramInt);
    AppMethodBeat.o(27675);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, final View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27676);
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131493936, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localObject = (ags)getItem(paramInt);
      if (localObject != null)
      {
        if (!bs.isNullOrNil(((ags)localObject).ndW)) {
          break label260;
        }
        paramViewGroup.fUk.setText(((ags)localObject).ncR);
        label84:
        if (bs.isNullOrNil(((ags)localObject).ncR)) {
          break label275;
        }
        b.a.c(paramViewGroup.ig, ((ags)localObject).ncR);
      }
    }
    for (;;)
    {
      localObject = a((ags)localObject);
      paramView.clearAnimation();
      if ((this.vRX.containsKey(localObject)) && (!((Boolean)this.vRX.get(localObject)).booleanValue()))
      {
        paramView.startAnimation(this.tPe);
        this.vRX.put(localObject, Boolean.TRUE);
      }
      if (paramInt + 1 == getCount())
      {
        paramViewGroup.fUk.setText("");
        paramViewGroup.ig.setImageResource(2131230836);
        if (paramView != null)
        {
          this.vRW.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(27669);
              paramView.startAnimation(a.a(a.this));
              AppMethodBeat.o(27669);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation) {}
          });
          this.vRV.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(27670);
              paramView.startAnimation(a.b(a.this));
              AppMethodBeat.o(27670);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation) {}
          });
          paramView.startAnimation(this.vRW);
        }
      }
      AppMethodBeat.o(27676);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label260:
      paramViewGroup.fUk.setText(((ags)localObject).ndW);
      break label84;
      label275:
      b.a.c(paramViewGroup.ig, ((ags)localObject).EyO);
    }
  }
  
  public final void setData(LinkedList<ags> paramLinkedList)
  {
    AppMethodBeat.i(27673);
    this.pjZ = paramLinkedList;
    if ((this.pjZ != null) && (this.pjZ.size() > 0))
    {
      int j = this.pjZ.size();
      int i = 0;
      while (i < j)
      {
        paramLinkedList = a((ags)this.pjZ.get(i));
        if (!this.vRX.containsKey(paramLinkedList)) {
          this.vRX.put(paramLinkedList, Boolean.FALSE);
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    AppMethodBeat.o(27673);
  }
  
  final class a
  {
    TextView fUk;
    ImageView ig;
    
    public a(View paramView)
    {
      AppMethodBeat.i(27671);
      this.ig = ((ImageView)paramView.findViewById(2131299742));
      this.fUk = ((TextView)paramView.findViewById(2131299751));
      AppMethodBeat.o(27671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.a
 * JD-Core Version:    0.7.0.1
 */