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
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.protocal.protobuf.ddj;
import java.util.LinkedList;

final class SDKOAuthUI$a
  extends BaseAdapter
{
  private LinkedList<ddj> QbY;
  private LayoutInflater mInflater;
  
  public SDKOAuthUI$a(Context paramContext, LinkedList<ddj> paramLinkedList)
  {
    AppMethodBeat.i(79749);
    this.mInflater = LayoutInflater.from(paramContext);
    this.QbY = paramLinkedList;
    AppMethodBeat.o(79749);
  }
  
  private ddj aot(int paramInt)
  {
    AppMethodBeat.i(79752);
    if ((paramInt >= 0) && (paramInt < this.QbY.size()))
    {
      ddj localddj = (ddj)this.QbY.get(paramInt);
      AppMethodBeat.o(79752);
      return localddj;
    }
    AppMethodBeat.o(79752);
    return null;
  }
  
  public final LinkedList<String> gXA()
  {
    AppMethodBeat.i(79750);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < this.QbY.size())
    {
      ddj localddj = (ddj)this.QbY.get(i);
      if ((localddj.TLg == 2) || (localddj.TLg == 3)) {
        localLinkedList.add(localddj.scope);
      }
      i += 1;
    }
    AppMethodBeat.o(79750);
    return localLinkedList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(79751);
    if (this.QbY == null)
    {
      AppMethodBeat.o(79751);
      return 0;
    }
    int i = this.QbY.size();
    AppMethodBeat.o(79751);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(79753);
    if ((this.QbY == null) || (this.QbY.size() <= 0))
    {
      AppMethodBeat.o(79753);
      return null;
    }
    final ddj localddj = aot(paramInt);
    if (localddj == null)
    {
      AppMethodBeat.o(79753);
      return paramView;
    }
    if (paramView == null)
    {
      paramViewGroup = new a((byte)0);
      paramView = this.mInflater.inflate(c.g.sdk_authorize_scope_item, null, false);
      paramViewGroup.Qcb = ((ImageView)paramView.findViewById(c.f.app_auth_state));
      paramViewGroup.rrB = ((TextView)paramView.findViewById(c.f.app_auth_desc));
      paramView.setTag(paramViewGroup);
      if (localddj.TLg != 1) {
        break label181;
      }
      paramViewGroup.Qcb.setImageResource(c.h.login_auth_state_not_selected);
    }
    for (;;)
    {
      paramViewGroup.rrB.setText(localddj.desc);
      final ImageView localImageView = paramViewGroup.Qcb;
      paramViewGroup.Qcb.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(79748);
          b localb = new b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (localddj.TLg == 2)
          {
            localImageView.setImageResource(c.h.login_auth_state_not_selected);
            localddj.TLg = 1;
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(79748);
            return;
            if (localddj.TLg == 1)
            {
              localImageView.setImageResource(c.h.login_auth_state_default_select);
              localddj.TLg = 2;
            }
          }
        }
      });
      AppMethodBeat.o(79753);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label181:
      if (localddj.TLg == 3) {
        paramViewGroup.Qcb.setImageResource(c.h.login_auth_state_must_select);
      } else {
        paramViewGroup.Qcb.setImageResource(c.h.login_auth_state_default_select);
      }
    }
  }
  
  static final class a
  {
    ImageView Qcb;
    TextView rrB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.a
 * JD-Core Version:    0.7.0.1
 */