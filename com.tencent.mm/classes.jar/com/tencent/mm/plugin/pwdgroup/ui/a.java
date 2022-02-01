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
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  private Animation Bpi;
  private Animation Bpj;
  private HashMap<String, Boolean> Bpk;
  private Context mContext;
  private LinkedList<amg> rld;
  private Animation ywd;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(27672);
    this.rld = new LinkedList();
    this.Bpk = new HashMap();
    this.mContext = paramContext;
    this.ywd = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.Bpj = AnimationUtils.loadAnimation(this.mContext, 2130771981);
    this.Bpi = AnimationUtils.loadAnimation(this.mContext, 2130771982);
    this.ywd.setInterpolator(new AccelerateDecelerateInterpolator());
    this.Bpj.setInterpolator(new AccelerateInterpolator());
    this.Bpi.setInterpolator(new AccelerateDecelerateInterpolator());
    this.ywd.setDuration(300L);
    this.Bpj.setDuration(1000L);
    this.Bpi.setDuration(1000L);
    AppMethodBeat.o(27672);
  }
  
  private static String a(amg paramamg)
  {
    AppMethodBeat.i(27677);
    if (paramamg == null)
    {
      AppMethodBeat.o(27677);
      return "";
    }
    if (Util.isNullOrNil(paramamg.UserName))
    {
      paramamg = paramamg.LuX;
      AppMethodBeat.o(27677);
      return paramamg;
    }
    paramamg = paramamg.UserName;
    AppMethodBeat.o(27677);
    return paramamg;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(27674);
    if (this.rld == null)
    {
      AppMethodBeat.o(27674);
      return 1;
    }
    int i = this.rld.size();
    AppMethodBeat.o(27674);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(27675);
    if (this.rld == null)
    {
      AppMethodBeat.o(27675);
      return null;
    }
    if (paramInt >= this.rld.size())
    {
      AppMethodBeat.o(27675);
      return null;
    }
    Object localObject = this.rld.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(2131494104, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localObject = (amg)getItem(paramInt);
      if (localObject != null)
      {
        if (!Util.isNullOrNil(((amg)localObject).oUJ)) {
          break label260;
        }
        paramViewGroup.hbb.setText(((amg)localObject).UserName);
        label84:
        if (Util.isNullOrNil(((amg)localObject).UserName)) {
          break label275;
        }
        b.a.c(paramViewGroup.kc, ((amg)localObject).UserName);
      }
    }
    for (;;)
    {
      localObject = a((amg)localObject);
      paramView.clearAnimation();
      if ((this.Bpk.containsKey(localObject)) && (!((Boolean)this.Bpk.get(localObject)).booleanValue()))
      {
        paramView.startAnimation(this.ywd);
        this.Bpk.put(localObject, Boolean.TRUE);
      }
      if (paramInt + 1 == getCount())
      {
        paramViewGroup.hbb.setText("");
        paramViewGroup.kc.setImageResource(2131230848);
        if (paramView != null)
        {
          this.Bpj.setAnimationListener(new Animation.AnimationListener()
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
          this.Bpi.setAnimationListener(new Animation.AnimationListener()
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
          paramView.startAnimation(this.Bpj);
        }
      }
      AppMethodBeat.o(27676);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label260:
      paramViewGroup.hbb.setText(((amg)localObject).oUJ);
      break label84;
      label275:
      b.a.c(paramViewGroup.kc, ((amg)localObject).LuX);
    }
  }
  
  public final void setData(LinkedList<amg> paramLinkedList)
  {
    AppMethodBeat.i(27673);
    this.rld = paramLinkedList;
    if ((this.rld != null) && (this.rld.size() > 0))
    {
      int j = this.rld.size();
      int i = 0;
      while (i < j)
      {
        paramLinkedList = a((amg)this.rld.get(i));
        if (!this.Bpk.containsKey(paramLinkedList)) {
          this.Bpk.put(paramLinkedList, Boolean.FALSE);
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    AppMethodBeat.o(27673);
  }
  
  final class a
  {
    TextView hbb;
    ImageView kc;
    
    public a(View paramView)
    {
      AppMethodBeat.i(27671);
      this.kc = ((ImageView)paramView.findViewById(2131300408));
      this.hbb = ((TextView)paramView.findViewById(2131300417));
      AppMethodBeat.o(27671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.a
 * JD-Core Version:    0.7.0.1
 */