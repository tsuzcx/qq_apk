package com.tencent.mm.plugin.pwdgroup.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.plugin.pwdgroup.b.a;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.LinkedList;

public final class a
  extends BaseAdapter
{
  private LinkedList<xr> hkd = new LinkedList();
  private Animation lwn;
  private Context mContext;
  private Animation nbx;
  private Animation nby;
  private HashMap<String, Boolean> nbz = new HashMap();
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.lwn = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_in);
    this.nby = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_in);
    this.nbx = AnimationUtils.loadAnimation(this.mContext, R.a.alpha_out);
    this.lwn.setInterpolator(new AccelerateDecelerateInterpolator());
    this.nby.setInterpolator(new AccelerateInterpolator());
    this.nbx.setInterpolator(new AccelerateDecelerateInterpolator());
    this.lwn.setDuration(300L);
    this.nby.setDuration(1000L);
    this.nbx.setDuration(1000L);
  }
  
  private static String a(xr paramxr)
  {
    if (paramxr == null) {
      return "";
    }
    if (bk.bl(paramxr.hPY)) {
      return paramxr.sUr;
    }
    return paramxr.hPY;
  }
  
  public final int getCount()
  {
    if (this.hkd == null) {
      return 1;
    }
    return this.hkd.size() + 1;
  }
  
  public final Object getItem(int paramInt)
  {
    if (this.hkd == null) {}
    while (paramInt >= this.hkd.size()) {
      return null;
    }
    return this.hkd.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(this.mContext).inflate(R.i.facing_create_chatroom_detail_item, null);
      paramViewGroup = new a.a(this, paramView);
      paramView.setTag(paramViewGroup);
      localObject = (xr)getItem(paramInt);
      if (localObject != null)
      {
        if (!bk.bl(((xr)localObject).hRf)) {
          break label251;
        }
        paramViewGroup.fcy.setText(((xr)localObject).hPY);
        label79:
        if (bk.bl(((xr)localObject).hPY)) {
          break label266;
        }
        b.a.a(paramViewGroup.hic, ((xr)localObject).hPY);
      }
    }
    for (;;)
    {
      localObject = a((xr)localObject);
      paramView.clearAnimation();
      if ((this.nbz.containsKey(localObject)) && (!((Boolean)this.nbz.get(localObject)).booleanValue()))
      {
        paramView.startAnimation(this.lwn);
        this.nbz.put(localObject, Boolean.valueOf(true));
      }
      if (paramInt + 1 == getCount())
      {
        paramViewGroup.fcy.setText("");
        paramViewGroup.hic.setImageResource(R.g.account_avatar_bg_pwd);
        if (paramView != null)
        {
          this.nby.setAnimationListener(new a.1(this, paramView));
          this.nbx.setAnimationListener(new a.2(this, paramView));
          paramView.startAnimation(this.nby);
        }
      }
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
      break;
      label251:
      paramViewGroup.fcy.setText(((xr)localObject).hRf);
      break label79;
      label266:
      b.a.a(paramViewGroup.hic, ((xr)localObject).sUr);
    }
  }
  
  public final void setData(LinkedList<xr> paramLinkedList)
  {
    this.hkd = paramLinkedList;
    if ((this.hkd != null) && (this.hkd.size() > 0))
    {
      int j = this.hkd.size();
      int i = 0;
      while (i < j)
      {
        paramLinkedList = a((xr)this.hkd.get(i));
        if (!this.nbz.containsKey(paramLinkedList)) {
          this.nbz.put(paramLinkedList, Boolean.valueOf(false));
        }
        i += 1;
      }
    }
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.pwdgroup.ui.a
 * JD-Core Version:    0.7.0.1
 */