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
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.pwdgroup.b.a;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  private Animation DWh;
  private Animation HjB;
  private Animation HjC;
  private HashMap<String, Boolean> HjD;
  private Context mContext;
  private LinkedList<anh> uOp;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(27672);
    this.uOp = new LinkedList();
    this.HjD = new HashMap();
    this.mContext = paramContext;
    this.DWh = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_in);
    this.HjC = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_in);
    this.HjB = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_out);
    this.DWh.setInterpolator(new AccelerateDecelerateInterpolator());
    this.HjC.setInterpolator(new AccelerateInterpolator());
    this.HjB.setInterpolator(new AccelerateDecelerateInterpolator());
    this.DWh.setDuration(300L);
    this.HjC.setDuration(1000L);
    this.HjB.setDuration(1000L);
    AppMethodBeat.o(27672);
  }
  
  private static String a(anh paramanh)
  {
    AppMethodBeat.i(27677);
    if (paramanh == null)
    {
      AppMethodBeat.o(27677);
      return "";
    }
    if (Util.isNullOrNil(paramanh.UserName))
    {
      paramanh = paramanh.Sxx;
      AppMethodBeat.o(27677);
      return paramanh;
    }
    paramanh = paramanh.UserName;
    AppMethodBeat.o(27677);
    return paramanh;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(27674);
    if (this.uOp == null)
    {
      AppMethodBeat.o(27674);
      return 1;
    }
    int i = this.uOp.size();
    AppMethodBeat.o(27674);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(27675);
    if (this.uOp == null)
    {
      AppMethodBeat.o(27675);
      return null;
    }
    if (paramInt >= this.uOp.size())
    {
      AppMethodBeat.o(27675);
      return null;
    }
    Object localObject = this.uOp.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(R.i.egV, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localObject = (anh)getItem(paramInt);
      if (localObject != null)
      {
        if (!Util.isNullOrNil(((anh)localObject).rWI)) {
          break label262;
        }
        paramViewGroup.jMg.setText(((anh)localObject).UserName);
        label85:
        if (Util.isNullOrNil(((anh)localObject).UserName)) {
          break label277;
        }
        b.a.c(paramViewGroup.bwJ, ((anh)localObject).UserName);
      }
    }
    for (;;)
    {
      localObject = a((anh)localObject);
      paramView.clearAnimation();
      if ((this.HjD.containsKey(localObject)) && (!((Boolean)this.HjD.get(localObject)).booleanValue()))
      {
        paramView.startAnimation(this.DWh);
        this.HjD.put(localObject, Boolean.TRUE);
      }
      if (paramInt + 1 == getCount())
      {
        paramViewGroup.jMg.setText("");
        paramViewGroup.bwJ.setImageResource(R.g.dlX);
        if (paramView != null)
        {
          this.HjC.setAnimationListener(new Animation.AnimationListener()
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
          this.HjB.setAnimationListener(new Animation.AnimationListener()
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
          paramView.startAnimation(this.HjC);
        }
      }
      AppMethodBeat.o(27676);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label262:
      paramViewGroup.jMg.setText(((anh)localObject).rWI);
      break label85;
      label277:
      b.a.c(paramViewGroup.bwJ, ((anh)localObject).Sxx);
    }
  }
  
  public final void setData(LinkedList<anh> paramLinkedList)
  {
    AppMethodBeat.i(27673);
    this.uOp = paramLinkedList;
    if ((this.uOp != null) && (this.uOp.size() > 0))
    {
      int j = this.uOp.size();
      int i = 0;
      while (i < j)
      {
        paramLinkedList = a((anh)this.uOp.get(i));
        if (!this.HjD.containsKey(paramLinkedList)) {
          this.HjD.put(paramLinkedList, Boolean.FALSE);
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    AppMethodBeat.o(27673);
  }
  
  final class a
  {
    ImageView bwJ;
    TextView jMg;
    
    public a(View paramView)
    {
      AppMethodBeat.i(27671);
      this.bwJ = ((ImageView)paramView.findViewById(R.h.dGv));
      this.jMg = ((TextView)paramView.findViewById(R.h.dGE));
      AppMethodBeat.o(27671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.a
 * JD-Core Version:    0.7.0.1
 */