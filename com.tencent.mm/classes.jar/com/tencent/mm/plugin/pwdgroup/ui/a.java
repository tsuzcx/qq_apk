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
import com.tencent.mm.protocal.protobuf.ara;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  private Animation JNq;
  private Animation Nho;
  private Animation Nhp;
  private HashMap<String, Boolean> Nhq;
  private Context mContext;
  private LinkedList<ara> xWZ;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(27672);
    this.xWZ = new LinkedList();
    this.Nhq = new HashMap();
    this.mContext = paramContext;
    this.JNq = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_in);
    this.Nhp = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_in);
    this.Nho = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_out);
    this.JNq.setInterpolator(new AccelerateDecelerateInterpolator());
    this.Nhp.setInterpolator(new AccelerateInterpolator());
    this.Nho.setInterpolator(new AccelerateDecelerateInterpolator());
    this.JNq.setDuration(300L);
    this.Nhp.setDuration(1000L);
    this.Nho.setDuration(1000L);
    AppMethodBeat.o(27672);
  }
  
  private static String a(ara paramara)
  {
    AppMethodBeat.i(27677);
    if (paramara == null)
    {
      AppMethodBeat.o(27677);
      return "";
    }
    if (Util.isNullOrNil(paramara.UserName))
    {
      paramara = paramara.Zyp;
      AppMethodBeat.o(27677);
      return paramara;
    }
    paramara = paramara.UserName;
    AppMethodBeat.o(27677);
    return paramara;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(27674);
    if (this.xWZ == null)
    {
      AppMethodBeat.o(27674);
      return 1;
    }
    int i = this.xWZ.size();
    AppMethodBeat.o(27674);
    return i + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(27675);
    if (this.xWZ == null)
    {
      AppMethodBeat.o(27675);
      return null;
    }
    if (paramInt >= this.xWZ.size())
    {
      AppMethodBeat.o(27675);
      return null;
    }
    Object localObject = this.xWZ.get(paramInt);
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
      paramView = LayoutInflater.from(this.mContext).inflate(R.i.gjR, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      localObject = (ara)getItem(paramInt);
      if (localObject != null)
      {
        if (!Util.isNullOrNil(((ara)localObject).vhX)) {
          break label262;
        }
        paramViewGroup.mll.setText(((ara)localObject).UserName);
        label85:
        if (Util.isNullOrNil(((ara)localObject).UserName)) {
          break label277;
        }
        b.a.g(paramViewGroup.dpM, ((ara)localObject).UserName);
      }
    }
    for (;;)
    {
      localObject = a((ara)localObject);
      paramView.clearAnimation();
      if ((this.Nhq.containsKey(localObject)) && (!((Boolean)this.Nhq.get(localObject)).booleanValue()))
      {
        paramView.startAnimation(this.JNq);
        this.Nhq.put(localObject, Boolean.TRUE);
      }
      if (paramInt + 1 == getCount())
      {
        paramViewGroup.mll.setText("");
        paramViewGroup.dpM.setImageResource(R.g.fmo);
        if (paramView != null)
        {
          this.Nhp.setAnimationListener(new Animation.AnimationListener()
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
          this.Nho.setAnimationListener(new Animation.AnimationListener()
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
          paramView.startAnimation(this.Nhp);
        }
      }
      AppMethodBeat.o(27676);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label262:
      paramViewGroup.mll.setText(((ara)localObject).vhX);
      break label85;
      label277:
      b.a.g(paramViewGroup.dpM, ((ara)localObject).Zyp);
    }
  }
  
  public final void setData(LinkedList<ara> paramLinkedList)
  {
    AppMethodBeat.i(27673);
    this.xWZ = paramLinkedList;
    if ((this.xWZ != null) && (this.xWZ.size() > 0))
    {
      int j = this.xWZ.size();
      int i = 0;
      while (i < j)
      {
        paramLinkedList = a((ara)this.xWZ.get(i));
        if (!this.Nhq.containsKey(paramLinkedList)) {
          this.Nhq.put(paramLinkedList, Boolean.FALSE);
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
    AppMethodBeat.o(27673);
  }
  
  final class a
  {
    ImageView dpM;
    TextView mll;
    
    public a(View paramView)
    {
      AppMethodBeat.i(27671);
      this.dpM = ((ImageView)paramView.findViewById(R.h.fHB));
      this.mll = ((TextView)paramView.findViewById(R.h.fHK));
      AppMethodBeat.o(27671);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.a
 * JD-Core Version:    0.7.0.1
 */