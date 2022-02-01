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
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private LinkedList<aji> pNz;
  private Animation uRR;
  private Animation wZf;
  private Animation wZg;
  private HashMap<String, Boolean> wZh;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(27672);
    this.pNz = new LinkedList();
    this.wZh = new HashMap();
    this.mContext = paramContext;
    this.uRR = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.wZg = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.wZf = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    this.uRR.setInterpolator(new AccelerateDecelerateInterpolator());
    this.wZg.setInterpolator(new AccelerateInterpolator());
    this.wZf.setInterpolator(new AccelerateDecelerateInterpolator());
    this.uRR.setDuration(300L);
    this.wZg.setDuration(1000L);
    this.wZf.setDuration(1000L);
    AppMethodBeat.o(27672);
  }
  
  private static String a(aji paramaji)
  {
    AppMethodBeat.i(27677);
    if (paramaji == null)
    {
      AppMethodBeat.o(27677);
      return "";
    }
    if (bt.isNullOrNil(paramaji.nDo))
    {
      paramaji = paramaji.GgA;
      AppMethodBeat.o(27677);
      return paramaji;
    }
    paramaji = paramaji.nDo;
    AppMethodBeat.o(27677);
    return paramaji;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(27674);
    if (this.pNz == null)
    {
      AppMethodBeat.o(27674);
      return 1;
    }
    int i = this.pNz.size();
    AppMethodBeat.o(27674);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(27675);
    if (this.pNz == null)
    {
      AppMethodBeat.o(27675);
      return null;
    }
    if (paramInt >= this.pNz.size())
    {
      AppMethodBeat.o(27675);
      return null;
    }
    Object localObject = this.pNz.get(paramInt);
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
      localObject = (aji)getItem(paramInt);
      if (localObject != null)
      {
        if (!bt.isNullOrNil(((aji)localObject).nEt)) {
          break label260;
        }
        paramViewGroup.gnM.setText(((aji)localObject).nDo);
        label84:
        if (bt.isNullOrNil(((aji)localObject).nDo)) {
          break label275;
        }
        b.a.c(paramViewGroup.ka, ((aji)localObject).nDo);
      }
    }
    for (;;)
    {
      localObject = a((aji)localObject);
      paramView.clearAnimation();
      if ((this.wZh.containsKey(localObject)) && (!((Boolean)this.wZh.get(localObject)).booleanValue()))
      {
        paramView.startAnimation(this.uRR);
        this.wZh.put(localObject, Boolean.TRUE);
      }
      if (paramInt + 1 == getCount())
      {
        paramViewGroup.gnM.setText("");
        paramViewGroup.ka.setImageResource(2131230836);
        if (paramView != null)
        {
          this.wZg.setAnimationListener(new Animation.AnimationListener()
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
          this.wZf.setAnimationListener(new Animation.AnimationListener()
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
          paramView.startAnimation(this.wZg);
        }
      }
      AppMethodBeat.o(27676);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label260:
      paramViewGroup.gnM.setText(((aji)localObject).nEt);
      break label84;
      label275:
      b.a.c(paramViewGroup.ka, ((aji)localObject).GgA);
    }
  }
  
  public final void setData(LinkedList<aji> paramLinkedList)
  {
    AppMethodBeat.i(27673);
    this.pNz = paramLinkedList;
    if ((this.pNz != null) && (this.pNz.size() > 0))
    {
      int j = this.pNz.size();
      int i = 0;
      while (i < j)
      {
        paramLinkedList = a((aji)this.pNz.get(i));
        if (!this.wZh.containsKey(paramLinkedList)) {
          this.wZh.put(paramLinkedList, Boolean.FALSE);
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    AppMethodBeat.o(27673);
  }
  
  final class a
  {
    TextView gnM;
    ImageView ka;
    
    public a(View paramView)
    {
      AppMethodBeat.i(27671);
      this.ka = ((ImageView)paramView.findViewById(2131299742));
      this.gnM = ((TextView)paramView.findViewById(2131299751));
      AppMethodBeat.o(27671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.a
 * JD-Core Version:    0.7.0.1
 */