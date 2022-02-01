package com.tencent.mm.ui.chatting.viewitems.a;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$TmplHolderV1;", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/IFinderLiveNotifyTmpl$ITmplHolder;", "()V", "auth", "Landroid/widget/ImageView;", "getAuth", "()Landroid/widget/ImageView;", "setAuth", "(Landroid/widget/ImageView;)V", "avatar", "getAvatar", "setAvatar", "infoList", "Landroid/widget/LinearLayout;", "getInfoList", "()Landroid/widget/LinearLayout;", "setInfoList", "(Landroid/widget/LinearLayout;)V", "itemView", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "liveWidgetLayout", "getLiveWidgetLayout", "setLiveWidgetLayout", "more", "getMore", "setMore", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", "reject", "getReject", "setReject", "tail", "getTail", "setTail", "tailLayout", "getTailLayout", "setTailLayout", "title", "getTitle", "setTitle", "addInfo", "", "itemList", "", "Lcom/tencent/mm/ui/chatting/viewitems/fnderlivenotifytmpl/FinderLiveNotifyTmplV1$InfoItem;", "hideOrShow", "isShow", "", "initView", "view", "refreshLiveWidget", "url", "", "state", "", "setOnLongClickListener", "listener", "Landroid/view/View$OnLongClickListener;", "tag", "", "setOnTouchListener", "ls", "Landroid/view/View$OnTouchListener;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$c
  implements d.a
{
  TextView Eoo;
  ImageView aeZr;
  View aeZs;
  private LinearLayout aeZt;
  View aeZu;
  TextView aeZv;
  View aeZw;
  View aeZx;
  ImageView avatar;
  View caK;
  TextView mll;
  
  public final void Mv(boolean paramBoolean)
  {
    AppMethodBeat.i(255468);
    View localView = this.caK;
    if (localView != null) {
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(255468);
      return;
    }
  }
  
  public final void a(View.OnLongClickListener paramOnLongClickListener, Object paramObject)
  {
    AppMethodBeat.i(255473);
    s.u(paramOnLongClickListener, "listener");
    s.u(paramObject, "tag");
    View localView = this.caK;
    if (localView != null) {
      localView.setOnLongClickListener(paramOnLongClickListener);
    }
    paramOnLongClickListener = this.caK;
    if (paramOnLongClickListener != null) {
      paramOnLongClickListener.setTag(paramObject);
    }
    AppMethodBeat.o(255473);
  }
  
  public final void iS(View paramView)
  {
    AppMethodBeat.i(255464);
    s.u(paramView, "view");
    this.caK = paramView.findViewById(R.h.gaf);
    View localView = this.caK;
    if (localView != null)
    {
      this.avatar = ((ImageView)localView.findViewById(R.h.fSv));
      this.Eoo = ((TextView)localView.findViewById(R.h.fSy));
      this.aeZr = ((ImageView)localView.findViewById(R.h.fSu));
      this.aeZs = localView.findViewById(R.h.fSx);
      this.mll = ((TextView)localView.findViewById(R.h.fMJ));
      paramView = this.mll;
      if (paramView != null) {
        break label185;
      }
    }
    label185:
    for (paramView = null;; paramView = paramView.getPaint())
    {
      aw.a((Paint)paramView, 0.8F);
      this.aeZt = ((LinearLayout)localView.findViewById(R.h.fSw));
      this.aeZu = localView.findViewById(R.h.fIf);
      this.aeZv = ((TextView)localView.findViewById(R.h.fSA));
      this.aeZw = localView.findViewById(R.h.fSz);
      this.aeZx = localView.findViewById(R.h.fSt);
      AppMethodBeat.o(255464);
      return;
    }
  }
  
  public final void iY(String paramString, int paramInt)
  {
    View localView2 = null;
    AppMethodBeat.i(255490);
    s.u(paramString, "url");
    Object localObject = this.aeZu;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.aeZu;
    View localView1;
    label59:
    View localView3;
    label70:
    int i;
    if (localObject == null)
    {
      localObject = null;
      localView1 = this.aeZu;
      if (localView1 != null) {
        break label154;
      }
      localView1 = null;
      localView3 = this.aeZu;
      if (localView3 != null) {
        break label167;
      }
      if (((CharSequence)paramString).length() <= 0) {
        break label180;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (paramInt == 1)
        {
          ((cn)h.az(cn.class)).loadImage(paramString, (ImageView)localObject);
          if (localView1 != null) {
            localView1.setVisibility(0);
          }
          if (localView2 == null) {
            break label250;
          }
          localView2.setVisibility(8);
          AppMethodBeat.o(255490);
          return;
          localObject = (ImageView)((View)localObject).findViewById(R.h.fIg);
          break;
          label154:
          localView1 = localView1.findViewById(R.h.finder_live_icon);
          break label59;
          label167:
          localView2 = localView3.findViewById(R.h.finder_live_end_tag);
          break label70;
          label180:
          i = 0;
          continue;
        }
        ((cn)h.az(cn.class)).getFinderUtilApi().a((ImageView)localObject, paramString);
        if (localView1 != null) {
          localView1.setVisibility(8);
        }
        if (localView2 == null) {
          break label250;
        }
        localView2.setVisibility(0);
        AppMethodBeat.o(255490);
        return;
      }
    }
    paramString = this.aeZu;
    if (paramString != null) {
      paramString.setVisibility(8);
    }
    label250:
    AppMethodBeat.o(255490);
  }
  
  public final void nL(List<c.b> paramList)
  {
    AppMethodBeat.i(255482);
    s.u(paramList, "itemList");
    View localView = this.caK;
    if (localView != null)
    {
      Object localObject1 = this.aeZt;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).removeAllViews();
      }
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        Object localObject2 = (c.b)paramList.next();
        localObject1 = af.mU(localView.getContext()).inflate(R.i.gjZ, null);
        ((TextView)((View)localObject1).findViewById(R.h.fKB)).setText((CharSequence)((c.b)localObject2).key);
        ((TextView)((View)localObject1).findViewById(R.h.fKC)).setText((CharSequence)((c.b)localObject2).value);
        localObject2 = this.aeZt;
        if (localObject2 != null) {
          ((LinearLayout)localObject2).addView((View)localObject1);
        }
      }
    }
    AppMethodBeat.o(255482);
  }
  
  public final void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(255476);
    s.u(paramOnTouchListener, "ls");
    View localView = this.caK;
    if (localView != null) {
      localView.setOnTouchListener(paramOnTouchListener);
    }
    AppMethodBeat.o(255476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.a.c.c
 * JD-Core Version:    0.7.0.1
 */