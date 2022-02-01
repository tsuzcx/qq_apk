package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "multi", "", "(IZ)V", "content", "", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "memberMatch", "Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;", "getMemberMatch", "()Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;", "setMemberMatch", "(Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;)V", "getMulti", "()Z", "nickname", "getNickname", "setNickname", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "viewHolder", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewHolder;", "getViewHolder", "()Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewHolder;", "viewHolder$delegate", "Lkotlin/Lazy;", "viewItem", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewItem;", "getViewItem", "()Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewItem;", "viewItem$delegate", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "ChatroomMemberViewHolder", "ChatroomMemberViewItem", "ui-selectcontact_release"})
public final class d
  extends a
{
  private final kotlin.f XxB;
  private final kotlin.f XxC;
  public com.tencent.mm.plugin.fts.a.a.g XxD;
  final boolean XxE;
  CharSequence kLX;
  CharSequence mMY;
  String username;
  
  public d(int paramInt, boolean paramBoolean)
  {
    super(8, paramInt);
    AppMethodBeat.i(186931);
    this.XxE = paramBoolean;
    this.XxB = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.XxC = kotlin.g.ar((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(186931);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    Object localObject3 = null;
    AppMethodBeat.i(186928);
    com.tencent.mm.plugin.fts.a.a.g localg;
    Object localObject1;
    Object localObject2;
    if ((parama instanceof a))
    {
      localg = this.XxD;
      localObject1 = this.XxD;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.fts.a.a.g)localObject1).username;
        if ((localg == null) || (localObject1 == null)) {
          break label482;
        }
        this.username = localg.username;
        localObject2 = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
        p.j(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
        as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject2).bbL().bwc((String)localObject1);
        localObject2 = localas;
        if (localas == null)
        {
          localObject2 = h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          p.j(localObject2, "MMKernel.service(IMessengerStorage::class.java)");
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject2).bbL().bwh((String)localObject1);
        }
        aF((as)localObject2);
        localObject1 = (b)h.ae(b.class);
        localObject2 = fqR();
        p.j(localObject2, "getContact()");
        localObject1 = ((b)localObject1).aL(((as)localObject2).getUsername(), hVy());
        if (!p.h(localObject1, localg.BIs)) {
          break label315;
        }
        this.mMY = ((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, (CharSequence)localObject1, com.tencent.mm.ci.a.aY(paramContext, a.c.NormalTextSize)));
        localObject1 = new e();
        ((e)localObject1).BHX = this.mMY;
        ((e)localObject1).BHY = hVx();
        ((e)localObject1).BHZ = localg.BHZ;
        ((e)localObject1).BIa = localg.BIv;
        paramContext = ((a)parama).mrM;
        if (paramContext == null) {
          break label310;
        }
      }
      label310:
      for (paramContext = paramContext.getPaint();; paramContext = null)
      {
        ((e)localObject1).bzo = paramContext;
        this.mMY = com.tencent.mm.plugin.fts.a.f.a((e)localObject1).BIp;
        AppMethodBeat.o(186928);
        return;
        localObject1 = null;
        break;
      }
      label315:
      this.mMY = ((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, (CharSequence)localObject1, com.tencent.mm.ci.a.aY(paramContext, a.c.NormalTextSize)));
      localObject1 = (CharSequence)localg.BIs;
      localObject2 = ((a)parama).mrM;
      if (localObject2 == null) {
        break label488;
      }
      localObject2 = ((TextView)localObject2).getPaint();
      if (localObject2 == null) {
        break label488;
      }
    }
    label482:
    label488:
    for (float f = ((TextPaint)localObject2).getTextSize();; f = 0.0F)
    {
      paramContext = com.tencent.mm.pluginsdk.ui.span.l.b(paramContext, (CharSequence)localObject1, f);
      p.j(paramContext, "MMSpanManager.spanForSmi…V?.paint?.textSize ?: 0f)");
      paramContext = (CharSequence)paramContext;
      localObject1 = new e();
      ((e)localObject1).BHX = paramContext;
      ((e)localObject1).BHY = hVx();
      ((e)localObject1).BHZ = localg.BHZ;
      ((e)localObject1).BIa = localg.BIv;
      parama = ((a)parama).mrM;
      paramContext = localObject3;
      if (parama != null) {
        paramContext = parama.getPaint();
      }
      ((e)localObject1).bzo = paramContext;
      this.kLX = com.tencent.mm.plugin.fts.a.f.a((e)localObject1).BIp;
      AppMethodBeat.o(186928);
      return;
    }
  }
  
  public final a.b bwF()
  {
    AppMethodBeat.i(186922);
    a.b localb = (a.b)this.XxB.getValue();
    AppMethodBeat.o(186922);
    return localb;
  }
  
  protected final a.a bwG()
  {
    AppMethodBeat.i(186924);
    a.a locala = (a.a)this.XxC.getValue();
    AppMethodBeat.o(186924);
    return locala;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem;)V", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "descTV", "Landroid/widget/TextView;", "getDescTV", "()Landroid/widget/TextView;", "setDescTV", "(Landroid/widget/TextView;)V", "selectCb", "Landroid/widget/CheckBox;", "getSelectCb", "()Landroid/widget/CheckBox;", "setSelectCb", "(Landroid/widget/CheckBox;)V", "titleTV", "getTitleTV", "setTitleTV", "ui-selectcontact_release"})
  public final class a
    extends a.a
  {
    View contentView;
    public ImageView iZG;
    CheckBox jbE;
    TextView mNb;
    TextView mrM;
    
    public a()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "multi", "", "(Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem;Z)V", "getMulti", "()Z", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "originConvertView", "onItemClick", "v", "ui-selectcontact_release"})
  public final class b
    extends a.b
  {
    private final boolean XxE;
    
    public b()
    {
      super();
      boolean bool;
      this.XxE = bool;
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(187077);
      if (com.tencent.mm.ci.a.ko(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = d.this.bwG();
        if (paramViewGroup != null) {
          break;
        }
        paramContext = new t("null cannot be cast to non-null type com.tencent.mm.ui.contact.item.ChatroomMemberDataItem.ChatroomMemberViewHolder");
        AppMethodBeat.o(187077);
        throw paramContext;
      }
      paramViewGroup = (d.a)paramViewGroup;
      View localView = paramContext.findViewById(a.e.avatar_iv);
      if (localView == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(187077);
        throw paramContext;
      }
      paramViewGroup.iZG = ((ImageView)localView);
      localView = paramContext.findViewById(a.e.select_cb);
      if (localView == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.CheckBox");
        AppMethodBeat.o(187077);
        throw paramContext;
      }
      paramViewGroup.jbE = ((CheckBox)localView);
      localView = paramContext.findViewById(a.e.title_tv);
      if (localView == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(187077);
        throw paramContext;
      }
      paramViewGroup.mNb = ((TextView)localView);
      localView = paramContext.findViewById(a.e.desc_tv);
      if (localView == null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(187077);
        throw paramContext;
      }
      paramViewGroup.mrM = ((TextView)localView);
      paramViewGroup.contentView = paramContext.findViewById(a.e.select_item_content_layout);
      p.j(paramContext, "convertView");
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(187077);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(187073);
      int i;
      if (((parama instanceof d.a)) && ((parama1 instanceof d)))
      {
        paramContext = ((d)parama1).username;
        if (paramContext == null) {
          break label205;
        }
        if (((CharSequence)paramContext).length() <= 0) {
          break label199;
        }
        i = 1;
        if (i != 1) {
          break label205;
        }
        paramContext = ((d.a)parama).iZG;
        if (paramContext != null) {
          paramContext.setTag(((d)parama1).username);
        }
        com.tencent.mm.pluginsdk.ui.a.b.d(((d.a)parama).iZG, ((d)parama1).username, 0.1F);
        label94:
        paramContext = ((d.a)parama).jbE;
        if (paramContext != null)
        {
          if (!this.XxE) {
            break label249;
          }
          paramContext.setVisibility(0);
          paramContext.setBackgroundResource(a.d.mm_checkbox_btn);
          if (!paramBoolean1) {
            break label235;
          }
          paramContext.setChecked(true);
          paramContext.setEnabled(false);
          if (!ar.isDarkMode()) {
            break label227;
          }
          i = a.g.checkbox_selected_grey_dark;
          label151:
          paramContext.setBackgroundResource(i);
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.n.a(((d)parama1).mMY, ((d.a)parama).mNb);
        com.tencent.mm.plugin.fts.ui.n.a(((d)parama1).kLX, ((d.a)parama).mrM);
        AppMethodBeat.o(187073);
        return;
        label199:
        i = 0;
        break;
        label205:
        paramContext = ((d.a)parama).iZG;
        if (paramContext == null) {
          break label94;
        }
        paramContext.setImageResource(a.d.default_avatar);
        break label94;
        label227:
        i = a.g.checkbox_selected_grey;
        break label151;
        label235:
        paramContext.setChecked(paramBoolean2);
        paramContext.setEnabled(true);
        continue;
        label249:
        paramContext = ((d.a)parama).jbE;
        if (paramContext != null) {
          paramContext.setVisibility(8);
        }
      }
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewHolder;", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<d.a>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewItem;", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<d.b>
  {
    d(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d
 * JD-Core Version:    0.7.0.1
 */