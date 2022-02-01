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
import com.tencent.mm.protocal.protobuf.ajs;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private LinkedList<ajs> pUe;
  private Animation vdD;
  private Animation xoW;
  private Animation xoX;
  private HashMap<String, Boolean> xoY;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(27672);
    this.pUe = new LinkedList();
    this.xoY = new HashMap();
    this.mContext = paramContext;
    this.vdD = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.xoX = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.xoW = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    this.vdD.setInterpolator(new AccelerateDecelerateInterpolator());
    this.xoX.setInterpolator(new AccelerateInterpolator());
    this.xoW.setInterpolator(new AccelerateDecelerateInterpolator());
    this.vdD.setDuration(300L);
    this.xoX.setDuration(1000L);
    this.xoW.setDuration(1000L);
    AppMethodBeat.o(27672);
  }
  
  private static String a(ajs paramajs)
  {
    AppMethodBeat.i(27677);
    if (paramajs == null)
    {
      AppMethodBeat.o(27677);
      return "";
    }
    if (bu.isNullOrNil(paramajs.nIJ))
    {
      paramajs = paramajs.Gzj;
      AppMethodBeat.o(27677);
      return paramajs;
    }
    paramajs = paramajs.nIJ;
    AppMethodBeat.o(27677);
    return paramajs;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(27674);
    if (this.pUe == null)
    {
      AppMethodBeat.o(27674);
      return 1;
    }
    int i = this.pUe.size();
    AppMethodBeat.o(27674);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(27675);
    if (this.pUe == null)
    {
      AppMethodBeat.o(27675);
      return null;
    }
    if (paramInt >= this.pUe.size())
    {
      AppMethodBeat.o(27675);
      return null;
    }
    Object localObject = this.pUe.get(paramInt);
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
      localObject = (ajs)getItem(paramInt);
      if (localObject != null)
      {
        if (!bu.isNullOrNil(((ajs)localObject).nJO)) {
          break label260;
        }
        paramViewGroup.gqi.setText(((ajs)localObject).nIJ);
        label84:
        if (bu.isNullOrNil(((ajs)localObject).nIJ)) {
          break label275;
        }
        b.a.c(paramViewGroup.ka, ((ajs)localObject).nIJ);
      }
    }
    for (;;)
    {
      localObject = a((ajs)localObject);
      paramView.clearAnimation();
      if ((this.xoY.containsKey(localObject)) && (!((Boolean)this.xoY.get(localObject)).booleanValue()))
      {
        paramView.startAnimation(this.vdD);
        this.xoY.put(localObject, Boolean.TRUE);
      }
      if (paramInt + 1 == getCount())
      {
        paramViewGroup.gqi.setText("");
        paramViewGroup.ka.setImageResource(2131230836);
        if (paramView != null)
        {
          this.xoX.setAnimationListener(new Animation.AnimationListener()
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
          this.xoW.setAnimationListener(new Animation.AnimationListener()
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
          paramView.startAnimation(this.xoX);
        }
      }
      AppMethodBeat.o(27676);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label260:
      paramViewGroup.gqi.setText(((ajs)localObject).nJO);
      break label84;
      label275:
      b.a.c(paramViewGroup.ka, ((ajs)localObject).Gzj);
    }
  }
  
  public final void setData(LinkedList<ajs> paramLinkedList)
  {
    AppMethodBeat.i(27673);
    this.pUe = paramLinkedList;
    if ((this.pUe != null) && (this.pUe.size() > 0))
    {
      int j = this.pUe.size();
      int i = 0;
      while (i < j)
      {
        paramLinkedList = a((ajs)this.pUe.get(i));
        if (!this.xoY.containsKey(paramLinkedList)) {
          this.xoY.put(paramLinkedList, Boolean.FALSE);
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    AppMethodBeat.o(27673);
  }
  
  final class a
  {
    TextView gqi;
    ImageView ka;
    
    public a(View paramView)
    {
      AppMethodBeat.i(27671);
      this.ka = ((ImageView)paramView.findViewById(2131299742));
      this.gqi = ((TextView)paramView.findViewById(2131299751));
      AppMethodBeat.o(27671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.a
 * JD-Core Version:    0.7.0.1
 */