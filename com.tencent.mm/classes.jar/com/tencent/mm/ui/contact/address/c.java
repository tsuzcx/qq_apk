package com.tencent.mm.ui.contact.address;

import android.graphics.Paint;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/address/AddressItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/ui/contact/address/AddressLiveListItem;", "()V", "createViewHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "convertView", "Landroid/view/View;", "getLayoutId", "", "onBindViewHolder", "", "holder", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "Companion", "ViewHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends f<d>
{
  public static final c.a afjd;
  
  static
  {
    AppMethodBeat.i(253233);
    afjd = new c.a((byte)0);
    AppMethodBeat.o(253233);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(253247);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(253247);
  }
  
  public final j b(RecyclerView paramRecyclerView, View paramView)
  {
    AppMethodBeat.i(253243);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramView, "convertView");
    long l = cn.bDw();
    paramRecyclerView = new b(paramView);
    Log.i("MicroMsg.Mvvm.AddressItemConvert", s.X("createViewHolder ", Long.valueOf(cn.bDw() - l)));
    paramRecyclerView = (j)paramRecyclerView;
    AppMethodBeat.o(253243);
    return paramRecyclerView;
  }
  
  public final int getLayoutId()
  {
    return R.i.gdY;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/address/AddressItemConvert$ViewHolder;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/ui/contact/address/AddressItemConvert;Landroid/view/View;)V", "avatarIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getAvatarIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "catalog", "Landroid/widget/TextView;", "getCatalog", "()Landroid/widget/TextView;", "categoryLayout", "Landroid/widget/RelativeLayout;", "getCategoryLayout", "()Landroid/widget/RelativeLayout;", "nicknameTV", "getNicknameTV", "nicknameTableLayout", "getNicknameTableLayout", "()Landroid/view/View;", "openImDescTV", "getOpenImDescTV", "selectorView", "getSelectorView", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends j
  {
    final TextView JMf;
    final WeImageView afje;
    final TextView afjf;
    final RelativeLayout afjg;
    final RelativeLayout afjh;
    private final View afji;
    final TextView lBD;
    
    public b()
    {
      super();
      AppMethodBeat.i(253258);
      this.JMf = ((TextView)localObject.findViewById(R.h.contactitem_catalog));
      this.lBD = ((TextView)localObject.findViewById(R.h.nickname_tv));
      this.afje = ((WeImageView)localObject.findViewById(R.h.avatar_iv));
      this.afjf = ((TextView)localObject.findViewById(R.h.openim_desc_tv));
      this.afjg = ((RelativeLayout)localObject.findViewById(R.h.fDs));
      this.afjh = ((RelativeLayout)localObject.findViewById(R.h.fDm));
      this.afji = localObject.findViewById(R.h.fRr);
      if (this.lBD.getPaint() != null) {
        aw.a((Paint)this.lBD.getPaint(), 0.1F);
      }
      AppMethodBeat.o(253258);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.address.c
 * JD-Core Version:    0.7.0.1
 */