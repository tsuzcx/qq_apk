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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.selectcontact.a.c;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.g;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "multi", "", "(IZ)V", "content", "", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "memberMatch", "Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;", "getMemberMatch", "()Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;", "setMemberMatch", "(Lcom/tencent/mm/plugin/fts/api/model/FTSMemberMatch;)V", "getMulti", "()Z", "nickname", "getNickname", "setNickname", "username", "", "getUsername", "()Ljava/lang/String;", "setUsername", "(Ljava/lang/String;)V", "viewHolder", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewHolder;", "getViewHolder", "()Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewHolder;", "viewHolder$delegate", "Lkotlin/Lazy;", "viewItem", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewItem;", "getViewItem", "()Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewItem;", "viewItem$delegate", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "ChatroomMemberViewHolder", "ChatroomMemberViewItem", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  final boolean afjK;
  private final j afjL;
  private final j afjM;
  public i afjN;
  CharSequence nnT;
  CharSequence pJG;
  String username;
  
  public d(int paramInt, boolean paramBoolean)
  {
    super(8, paramInt);
    AppMethodBeat.i(253516);
    this.afjK = paramBoolean;
    this.afjL = k.cm((kotlin.g.a.a)new d(this));
    this.afjM = k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(253516);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    Object localObject3 = null;
    AppMethodBeat.i(253528);
    Object localObject1;
    Object localObject2;
    label270:
    label278:
    float f;
    if ((parama instanceof a))
    {
      i locali = this.afjN;
      localObject1 = this.afjN;
      if (localObject1 == null)
      {
        localObject1 = null;
        if ((locali == null) || (localObject1 == null)) {
          break label423;
        }
        this.username = locali.username;
        au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxq((String)localObject1);
        localObject2 = localau;
        if (localau == null) {
          localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxv((String)localObject1);
        }
        this.contact = ((au)localObject2);
        localObject1 = ((b)com.tencent.mm.kernel.h.ax(b.class)).aV(this.contact.field_username, this.hCy);
        if (!s.p(localObject1, locali.Hta)) {
          break label278;
        }
        this.pJG = ((CharSequence)p.d(paramContext, (CharSequence)localObject1, com.tencent.mm.cd.a.br(paramContext, a.c.NormalTextSize)));
        localObject1 = new g();
        ((g)localObject1).HsG = this.pJG;
        ((g)localObject1).FWt = this.FWt;
        ((g)localObject1).HsH = locali.HsH;
        ((g)localObject1).HsI = locali.Htd;
        paramContext = ((a)parama).plr;
        if (paramContext != null) {
          break label270;
        }
      }
      for (paramContext = null;; paramContext = paramContext.getPaint())
      {
        ((g)localObject1).dso = paramContext;
        this.pJG = f.a((g)localObject1).HsX;
        AppMethodBeat.o(253528);
        return;
        localObject1 = ((i)localObject1).username;
        break;
      }
      this.pJG = ((CharSequence)p.d(paramContext, (CharSequence)localObject1, com.tencent.mm.cd.a.br(paramContext, a.c.NormalTextSize)));
      localObject1 = (CharSequence)locali.Hta;
      localObject2 = ((a)parama).plr;
      if (localObject2 != null) {
        break label429;
      }
      f = 0.0F;
      paramContext = p.b(paramContext, (CharSequence)localObject1, f);
      s.s(paramContext, "spanForSmiley(context, m…V?.paint?.textSize ?: 0f)");
      paramContext = (CharSequence)paramContext;
      localObject1 = new g();
      ((g)localObject1).HsG = paramContext;
      ((g)localObject1).FWt = this.FWt;
      ((g)localObject1).HsH = locali.HsH;
      ((g)localObject1).HsI = locali.Htd;
      paramContext = ((a)parama).plr;
      if (paramContext != null) {
        break label455;
      }
    }
    label423:
    label429:
    label455:
    for (paramContext = localObject3;; paramContext = paramContext.getPaint())
    {
      ((g)localObject1).dso = paramContext;
      this.nnT = f.a((g)localObject1).HsX;
      AppMethodBeat.o(253528);
      return;
      localObject2 = ((TextView)localObject2).getPaint();
      if (localObject2 == null)
      {
        f = 0.0F;
        break;
      }
      f = ((TextPaint)localObject2).getTextSize();
      break;
    }
  }
  
  public final a.b bVv()
  {
    AppMethodBeat.i(253519);
    a.b localb = (a.b)this.afjL.getValue();
    AppMethodBeat.o(253519);
    return localb;
  }
  
  protected final a.a bVw()
  {
    AppMethodBeat.i(253521);
    a.a locala = (a.a)this.afjM.getValue();
    AppMethodBeat.o(253521);
    return locala;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem;)V", "avatarIV", "Landroid/widget/ImageView;", "getAvatarIV", "()Landroid/widget/ImageView;", "setAvatarIV", "(Landroid/widget/ImageView;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "descTV", "Landroid/widget/TextView;", "getDescTV", "()Landroid/widget/TextView;", "setDescTV", "(Landroid/widget/TextView;)V", "selectCb", "Landroid/widget/CheckBox;", "getSelectCb", "()Landroid/widget/CheckBox;", "setSelectCb", "(Landroid/widget/CheckBox;)V", "titleTV", "getTitleTV", "setTitleTV", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends a.a
  {
    View contentView;
    public ImageView lBC;
    CheckBox lDE;
    TextView pJJ;
    TextView plr;
    
    public a()
    {
      super();
      AppMethodBeat.i(253540);
      AppMethodBeat.o(253540);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "multi", "", "(Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem;Z)V", "getMulti", "()Z", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "originConvertView", "onItemClick", "v", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends a.b
  {
    private final boolean afjK;
    
    public b()
    {
      super();
      AppMethodBeat.i(253534);
      boolean bool;
      this.afjK = bool;
      AppMethodBeat.o(253534);
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(253550);
      if (com.tencent.mm.cd.a.mp(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.f.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = (d.a)d.this.bVw();
        localView = paramContext.findViewById(a.e.avatar_iv);
        if (localView != null) {
          break;
        }
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(253550);
        throw paramContext;
      }
      paramViewGroup.lBC = ((ImageView)localView);
      View localView = paramContext.findViewById(a.e.select_cb);
      if (localView == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
        AppMethodBeat.o(253550);
        throw paramContext;
      }
      paramViewGroup.lDE = ((CheckBox)localView);
      localView = paramContext.findViewById(a.e.title_tv);
      if (localView == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(253550);
        throw paramContext;
      }
      paramViewGroup.pJJ = ((TextView)localView);
      localView = paramContext.findViewById(a.e.desc_tv);
      if (localView == null)
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(253550);
        throw paramContext;
      }
      paramViewGroup.plr = ((TextView)localView);
      paramViewGroup.contentView = paramContext.findViewById(a.e.select_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(253550);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(253546);
      int i;
      if (((parama instanceof d.a)) && ((parama1 instanceof d)))
      {
        paramContext = ((d)parama1).username;
        if (paramContext == null) {
          break label214;
        }
        if (((CharSequence)paramContext).length() <= 0) {
          break label208;
        }
        i = 1;
        if (i != 1) {
          break label214;
        }
        i = 1;
        label55:
        if (i == 0) {
          break label220;
        }
        paramContext = ((d.a)parama).lBC;
        if (paramContext != null) {
          paramContext.setTag(((d)parama1).username);
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(((d.a)parama).lBC, ((d)parama1).username, 0.1F, false);
        label103:
        paramContext = ((d.a)parama).lDE;
        if (paramContext != null)
        {
          if (!this.afjK) {
            break label264;
          }
          paramContext.setVisibility(0);
          paramContext.setBackgroundResource(a.d.mm_checkbox_btn);
          if (!paramBoolean1) {
            break label250;
          }
          paramContext.setChecked(true);
          paramContext.setEnabled(false);
          if (!aw.isDarkMode()) {
            break label242;
          }
          i = a.g.checkbox_selected_grey_dark;
          label160:
          paramContext.setBackgroundResource(i);
        }
      }
      for (;;)
      {
        o.a(((d)parama1).pJG, ((d.a)parama).pJJ);
        o.a(((d)parama1).nnT, ((d.a)parama).plr);
        AppMethodBeat.o(253546);
        return;
        label208:
        i = 0;
        break;
        label214:
        i = 0;
        break label55;
        label220:
        paramContext = ((d.a)parama).lBC;
        if (paramContext == null) {
          break label103;
        }
        paramContext.setImageResource(a.d.default_avatar);
        break label103;
        label242:
        i = a.g.checkbox_selected_grey;
        break label160;
        label250:
        paramContext.setChecked(paramBoolean2);
        paramContext.setEnabled(true);
        continue;
        label264:
        paramContext = ((d.a)parama).lDE;
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewHolder;", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<d.a>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem$ChatroomMemberViewItem;", "Lcom/tencent/mm/ui/contact/item/ChatroomMemberDataItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<d.b>
  {
    d(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.d
 * JD-Core Version:    0.7.0.1
 */