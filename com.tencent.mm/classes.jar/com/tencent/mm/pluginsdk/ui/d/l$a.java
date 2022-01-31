package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import junit.framework.Assert;

final class l$a
  extends BaseAdapter
{
  private List<String> kZk = null;
  private Context mContext = null;
  private DialogInterface.OnDismissListener sjR = null;
  l.a.a sjS = null;
  private Bundle xk = null;
  
  public l$a(List<String> paramList, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
  {
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.kZk = paramList;
      this.mContext = paramContext;
      this.sjR = paramOnDismissListener;
      this.xk = paramBundle;
      return;
    }
  }
  
  public final int getCount()
  {
    if (this.kZk == null) {
      return 0;
    }
    return this.kZk.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.kZk.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    String str = (String)this.kZk.get(paramInt);
    if (this.mContext.getString(R.l.chatting_phone_download_wxpb).equals(str)) {
      return 1;
    }
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    String str = (String)getItem(paramInt);
    paramInt = getItemViewType(paramInt);
    if (paramView == null)
    {
      paramView = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      if (paramInt == 1)
      {
        paramView = paramView.inflate(R.i.chatting_item_phone_alert_item_download, paramViewGroup, false);
        paramViewGroup = new l.a.b(this, (byte)0);
        ((l.a.b)paramViewGroup).fcy = ((TextView)paramView.findViewById(R.h.title));
        ((l.a.b)paramViewGroup).kfe = ((Button)paramView.findViewById(R.h.download_btn));
        ((l.a.b)paramViewGroup).sjU = ((TextView)paramView.findViewById(R.h.tip_msg));
        label109:
        paramView.setTag(paramViewGroup);
      }
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        y.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
        return paramView;
        paramView = paramView.inflate(R.i.chatting_item_phone_alert_item_normal, paramViewGroup, false);
        paramViewGroup = new l.a.c(this, (byte)0);
        ((l.a.c)paramViewGroup).fcy = ((TextView)paramView.findViewById(R.h.title));
        break label109;
        paramViewGroup = paramView.getTag();
      }
    }
    paramViewGroup = (l.a.c)paramViewGroup;
    paramViewGroup.fcy.setText(j.a(this.mContext, bk.pm(str), paramViewGroup.fcy.getTextSize()));
    return paramView;
    paramViewGroup = (l.a.b)paramViewGroup;
    paramViewGroup.fcy.setText(j.a(this.mContext, bk.pm(str), paramViewGroup.fcy.getTextSize()));
    paramViewGroup.sjU.setText(this.mContext.getString(R.l.chatting_phone_wx_pb_tips));
    paramViewGroup.kfe.setOnClickListener(new l.a.1(this));
    return paramView;
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.a
 * JD-Core Version:    0.7.0.1
 */