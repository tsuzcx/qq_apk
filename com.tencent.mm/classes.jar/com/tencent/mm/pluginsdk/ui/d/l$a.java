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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;
import junit.framework.Assert;

final class l$a
  extends BaseAdapter
{
  private Context mContext;
  private List<String> nxh;
  private DialogInterface.OnDismissListener wcy;
  l.a.a wcz;
  private Bundle xG;
  
  public l$a(List<String> paramList, Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener, Bundle paramBundle)
  {
    AppMethodBeat.i(28141);
    this.nxh = null;
    this.mContext = null;
    this.wcy = null;
    this.xG = null;
    this.wcz = null;
    if (paramContext != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.nxh = paramList;
      this.mContext = paramContext;
      this.wcy = paramOnDismissListener;
      this.xG = paramBundle;
      AppMethodBeat.o(28141);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(28142);
    if (this.nxh == null)
    {
      AppMethodBeat.o(28142);
      return 0;
    }
    int i = this.nxh.size();
    AppMethodBeat.o(28142);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(28143);
    Object localObject = this.nxh.get(paramInt);
    AppMethodBeat.o(28143);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(28144);
    String str = (String)this.nxh.get(paramInt);
    if (this.mContext.getString(2131298275).equals(str))
    {
      AppMethodBeat.o(28144);
      return 1;
    }
    AppMethodBeat.o(28144);
    return 0;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28145);
    String str = (String)getItem(paramInt);
    paramInt = getItemViewType(paramInt);
    if (paramView == null)
    {
      paramView = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
      if (paramInt == 1)
      {
        paramView = paramView.inflate(2130969098, paramViewGroup, false);
        paramViewGroup = new l.a.b(this, (byte)0);
        ((l.a.b)paramViewGroup).gui = ((TextView)paramView.findViewById(2131820680));
        ((l.a.b)paramViewGroup).mzN = ((Button)paramView.findViewById(2131822726));
        ((l.a.b)paramViewGroup).wcB = ((TextView)paramView.findViewById(2131822707));
        paramView.setTag(paramViewGroup);
        switch (paramInt)
        {
        default: 
          label116:
          ab.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(28145);
      return paramView;
      paramView = paramView.inflate(2130969099, paramViewGroup, false);
      paramViewGroup = new l.a.c(this, (byte)0);
      ((l.a.c)paramViewGroup).gui = ((TextView)paramView.findViewById(2131820680));
      break;
      paramViewGroup = paramView.getTag();
      break label116;
      paramViewGroup = (l.a.c)paramViewGroup;
      paramViewGroup.gui.setText(j.b(this.mContext, bo.nullAsNil(str), paramViewGroup.gui.getTextSize()));
      continue;
      paramViewGroup = (l.a.b)paramViewGroup;
      paramViewGroup.gui.setText(j.b(this.mContext, bo.nullAsNil(str), paramViewGroup.gui.getTextSize()));
      paramViewGroup.wcB.setText(this.mContext.getString(2131298281));
      paramViewGroup.mzN.setOnClickListener(new l.a.1(this));
    }
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