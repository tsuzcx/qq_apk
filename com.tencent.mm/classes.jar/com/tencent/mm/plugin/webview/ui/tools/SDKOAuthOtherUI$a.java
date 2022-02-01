package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.protocal.protobuf.ddj;
import com.tencent.mm.ui.ar;
import java.util.LinkedList;

final class SDKOAuthOtherUI$a
  extends BaseAdapter
{
  LinkedList<ddj> QbY;
  private Context mContext;
  private LayoutInflater mInflater;
  
  public SDKOAuthOtherUI$a(Context paramContext, LinkedList<ddj> paramLinkedList)
  {
    AppMethodBeat.i(79716);
    this.mInflater = LayoutInflater.from(paramContext);
    this.QbY = paramLinkedList;
    this.mContext = paramContext;
    AppMethodBeat.o(79716);
  }
  
  private ddj aot(int paramInt)
  {
    AppMethodBeat.i(79718);
    if ((paramInt >= 0) && (paramInt < this.QbY.size()))
    {
      ddj localddj = (ddj)this.QbY.get(paramInt);
      AppMethodBeat.o(79718);
      return localddj;
    }
    AppMethodBeat.o(79718);
    return null;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(79717);
    if (this.QbY == null)
    {
      AppMethodBeat.o(79717);
      return 0;
    }
    int i = this.QbY.size();
    AppMethodBeat.o(79717);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(79719);
    if ((this.QbY == null) || (this.QbY.size() <= 0))
    {
      AppMethodBeat.o(79719);
      return null;
    }
    final ddj localddj = aot(paramInt);
    if (localddj == null)
    {
      AppMethodBeat.o(79719);
      return paramView;
    }
    if (paramView == null)
    {
      paramViewGroup = new a((byte)0);
      paramView = this.mInflater.inflate(c.g.sdk_authorize_scope_item_new, null, false);
      paramViewGroup.Qcb = ((ImageView)paramView.findViewById(c.f.app_auth_state));
      paramViewGroup.rrB = ((TextView)paramView.findViewById(c.f.app_auth_desc));
      paramView.setTag(paramViewGroup);
      if (localddj.TLg != 1) {
        break label181;
      }
      paramViewGroup.Qcb.setImageResource(c.e.checkbox_unselected_small);
    }
    for (;;)
    {
      paramViewGroup.rrB.setText(localddj.desc);
      final ImageView localImageView = paramViewGroup.Qcb;
      paramViewGroup.Qcb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79715);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (localddj.TLg == 2)
          {
            localImageView.setImageResource(c.e.checkbox_unselected_small);
            localddj.TLg = 1;
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthOtherUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(79715);
            return;
            if (localddj.TLg == 1)
            {
              localImageView.setImageResource(c.h.checkbox_selected_small);
              localddj.TLg = 2;
            }
          }
        }
      });
      AppMethodBeat.o(79719);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label181:
      if (localddj.TLg == 3)
      {
        localImageView = paramViewGroup.Qcb;
        if (ar.isDarkMode()) {}
        for (paramInt = c.h.checkbox_selected_grey_dark_small;; paramInt = c.h.checkbox_selected_grey_small)
        {
          localImageView.setImageResource(paramInt);
          break;
        }
      }
      paramViewGroup.Qcb.setImageResource(c.h.checkbox_selected_small);
    }
  }
  
  static final class a
  {
    ImageView Qcb;
    TextView rrB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthOtherUI.a
 * JD-Core Version:    0.7.0.1
 */