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
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  private Context mContext;
  private LinkedList<aft> oGz;
  private Animation sHx;
  private Animation uJe;
  private Animation uJf;
  private HashMap<String, Boolean> uJg;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(27672);
    this.oGz = new LinkedList();
    this.uJg = new HashMap();
    this.mContext = paramContext;
    this.sHx = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.uJf = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.uJe = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    this.sHx.setInterpolator(new AccelerateDecelerateInterpolator());
    this.uJf.setInterpolator(new AccelerateInterpolator());
    this.uJe.setInterpolator(new AccelerateDecelerateInterpolator());
    this.sHx.setDuration(300L);
    this.uJf.setDuration(1000L);
    this.uJe.setDuration(1000L);
    AppMethodBeat.o(27672);
  }
  
  private static String a(aft paramaft)
  {
    AppMethodBeat.i(27677);
    if (paramaft == null)
    {
      AppMethodBeat.o(27677);
      return "";
    }
    if (bt.isNullOrNil(paramaft.mAQ))
    {
      paramaft = paramaft.DfI;
      AppMethodBeat.o(27677);
      return paramaft;
    }
    paramaft = paramaft.mAQ;
    AppMethodBeat.o(27677);
    return paramaft;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(27674);
    if (this.oGz == null)
    {
      AppMethodBeat.o(27674);
      return 1;
    }
    int i = this.oGz.size();
    AppMethodBeat.o(27674);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(27675);
    if (this.oGz == null)
    {
      AppMethodBeat.o(27675);
      return null;
    }
    if (paramInt >= this.oGz.size())
    {
      AppMethodBeat.o(27675);
      return null;
    }
    Object localObject = this.oGz.get(paramInt);
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
      localObject = (aft)getItem(paramInt);
      if (localObject != null)
      {
        if (!bt.isNullOrNil(((aft)localObject).mBV)) {
          break label260;
        }
        paramViewGroup.fQp.setText(((aft)localObject).mAQ);
        label84:
        if (bt.isNullOrNil(((aft)localObject).mAQ)) {
          break label275;
        }
        b.a.c(paramViewGroup.hg, ((aft)localObject).mAQ);
      }
    }
    for (;;)
    {
      localObject = a((aft)localObject);
      paramView.clearAnimation();
      if ((this.uJg.containsKey(localObject)) && (!((Boolean)this.uJg.get(localObject)).booleanValue()))
      {
        paramView.startAnimation(this.sHx);
        this.uJg.put(localObject, Boolean.TRUE);
      }
      if (paramInt + 1 == getCount())
      {
        paramViewGroup.fQp.setText("");
        paramViewGroup.hg.setImageResource(2131230836);
        if (paramView != null)
        {
          this.uJf.setAnimationListener(new Animation.AnimationListener()
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
          this.uJe.setAnimationListener(new Animation.AnimationListener()
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
          paramView.startAnimation(this.uJf);
        }
      }
      AppMethodBeat.o(27676);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label260:
      paramViewGroup.fQp.setText(((aft)localObject).mBV);
      break label84;
      label275:
      b.a.c(paramViewGroup.hg, ((aft)localObject).DfI);
    }
  }
  
  public final void setData(LinkedList<aft> paramLinkedList)
  {
    AppMethodBeat.i(27673);
    this.oGz = paramLinkedList;
    if ((this.oGz != null) && (this.oGz.size() > 0))
    {
      int j = this.oGz.size();
      int i = 0;
      while (i < j)
      {
        paramLinkedList = a((aft)this.oGz.get(i));
        if (!this.uJg.containsKey(paramLinkedList)) {
          this.uJg.put(paramLinkedList, Boolean.FALSE);
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    AppMethodBeat.o(27673);
  }
  
  final class a
  {
    TextView fQp;
    ImageView hg;
    
    public a(View paramView)
    {
      AppMethodBeat.i(27671);
      this.hg = ((ImageView)paramView.findViewById(2131299742));
      this.fQp = ((TextView)paramView.findViewById(2131299751));
      AppMethodBeat.o(27671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.a
 * JD-Core Version:    0.7.0.1
 */