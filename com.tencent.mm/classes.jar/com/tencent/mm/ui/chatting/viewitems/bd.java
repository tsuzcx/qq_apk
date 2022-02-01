package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.am;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard;", "", "()V", "CardItemHolder", "CardOnClickListener", "ChattingItemOpenIMKefuNameCardFrom", "ChattingItemOpenIMKefuNameCardTo", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
{
  public static final e aeVg;
  
  static
  {
    AppMethodBeat.i(255149);
    aeVg = new e((byte)0);
    AppMethodBeat.o(255149);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$CardItemHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "()V", "avatarFIV", "Landroid/widget/ImageView;", "getAvatarFIV", "()Landroid/widget/ImageView;", "setAvatarFIV", "(Landroid/widget/ImageView;)V", "cardUserTV", "Landroid/widget/TextView;", "getCardUserTV", "()Landroid/widget/TextView;", "setCardUserTV", "(Landroid/widget/TextView;)V", "chatWidth", "", "getChatWidth", "()I", "setChatWidth", "(I)V", "imgIV", "getImgIV", "setImgIV", "nicknameTV", "getNicknameTV", "setNicknameTV", "sourceTV", "getSourceTV", "setSourceTV", "tickImageView", "getTickImageView", "setTickImageView", "typeTV", "getTypeTV", "setTypeTV", "createHolder", "convertView", "Landroid/view/View;", "from", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c.a
  {
    ImageView aeNG;
    int aeOt;
    ImageView aeQb;
    TextView aeQc;
    TextView aeQd;
    TextView lBD;
    
    public final c.a P(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(255067);
      kotlin.g.b.s.u(paramView, "convertView");
      super.create(paramView);
      this.aeQb = ((ImageView)paramView.findViewById(R.h.fxm));
      this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
      this.aeQc = ((TextView)paramView.findViewById(R.h.fAp));
      this.aeQd = ((TextView)paramView.findViewById(R.h.fAs));
      this.lBD = ((TextView)paramView.findViewById(R.h.fzB));
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      this.clickArea = paramView.findViewById(R.h.chatting_click_area);
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
      this.maskView = paramView.findViewById(R.h.fzn);
      if (!paramBoolean)
      {
        this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
        this.aeNG = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
      }
      this.aeOt = c.nn(MMApplicationContext.getContext());
      paramView = (c.a)this;
      AppMethodBeat.o(255067);
      return paramView;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$CardOnClickListener;", "Landroid/view/View$OnClickListener;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "onClick", "", "view", "Landroid/view/View;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    implements View.OnClickListener
  {
    private final com.tencent.mm.ui.chatting.d.a aeiK;
    
    public b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(255057);
      this.aeiK = parama;
      AppMethodBeat.o(255057);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(255061);
      b localb = new b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$CardOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      if (paramView == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$CardOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255061);
        return;
      }
      if ((paramView.getTag() instanceof bz))
      {
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
          AppMethodBeat.o(255061);
          throw paramView;
        }
      }
      for (paramView = (bz)paramView; paramView == null; paramView = null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$CardOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(255061);
        return;
      }
      ((am)this.aeiK.cm(am.class)).x(paramView.userName, paramView.OMx);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$CardOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(255061);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$ChattingItemOpenIMKefuNameCardFrom;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "isShowRemindMenu", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "support", "msgType", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255032);
      kotlin.g.b.s.u(paramLayoutInflater, "inflater");
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localView = (View)new ap(paramLayoutInflater, R.i.ggd);
        ((ap)localView).setTag(new bd.a().P(localView, true));
      }
      AppMethodBeat.o(255032);
      return localView;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255044);
      kotlin.g.b.s.u(parama, "tag");
      kotlin.g.b.s.u(parama1, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      kotlin.g.b.s.u(paramString, "userName");
      this.aeiK = parama1;
      bd.a locala = (bd.a)parama;
      locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
      com.tencent.mm.openim.a.e locale = ((com.tencent.mm.openim.api.c)h.ax(com.tencent.mm.openim.api.c.class)).RD(paramcc.field_content);
      int i;
      if (locale != null)
      {
        if (((CharSequence)locale.username).length() != 0) {
          break label270;
        }
        i = 1;
        if (i == 0) {}
      }
      else
      {
        Log.e("MicroMsg.ChattingItemOpenIMKefuNameCard", "alvinluo fillingOpenIMKefuCard content invalid");
      }
      parama = bd.aeVg;
      bd.e.a(parama1, locale, locala);
      View localView = locala.clickArea;
      boolean bool = parama1.juG();
      if (locale == null) {
        parama = "";
      }
      for (;;)
      {
        parama = new bz(paramcc, bool, paramInt, parama, '\000');
        paramcc = new Bundle();
        paramcc.putString("kefu_card_ticket", locale.hFb);
        paramString = ah.aiuX;
        parama.OMx = paramcc;
        paramcc = ah.aiuX;
        localView.setTag(parama);
        locala.clickArea.setOnClickListener((View.OnClickListener)new bd.b(parama1));
        locala.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
        locala.clickArea.setOnTouchListener((View.OnTouchListener)((m)parama1.cm(m.class)).jqv());
        AppMethodBeat.o(255044);
        return;
        label270:
        i = 0;
        break;
        paramString = locale.username;
        parama = paramString;
        if (paramString == null) {
          parama = "";
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255051);
      kotlin.g.b.s.u(paramMenuItem, "item");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = bd.aeVg;
        bd.e.j(parama, paramcc);
        AppMethodBeat.o(255051);
        return true;
      }
      AppMethodBeat.o(255051);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255047);
      kotlin.g.b.s.u(params, "menu");
      kotlin.g.b.s.u(paramView, "v");
      if (paramcc == null)
      {
        AppMethodBeat.o(255047);
        return true;
      }
      paramContextMenuInfo = paramView.getTag();
      if (paramContextMenuInfo == null)
      {
        params = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(255047);
        throw params;
      }
      int i = ((bz)paramContextMenuInfo).position;
      paramContextMenuInfo = this.aeiK;
      kotlin.g.b.s.checkNotNull(paramContextMenuInfo);
      params.a(i, 111, (CharSequence)paramContextMenuInfo.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      params.removeItem(116);
      if (this.aeiK != null)
      {
        paramContextMenuInfo = this.aeiK;
        kotlin.g.b.s.checkNotNull(paramContextMenuInfo);
        if (!paramContextMenuInfo.juH()) {
          params.a(i, 100, (CharSequence)paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
        }
      }
      AppMethodBeat.o(255047);
      return true;
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255055);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      AppMethodBeat.o(255055);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 67);
    }
    
    public final boolean fXn()
    {
      return false;
    }
    
    protected final boolean jxi()
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$ChattingItemOpenIMKefuNameCardTo;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/ChattingListEventListener$StateBtnClickListener;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "isShowRemindMenu", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "support", "msgType", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends c
    implements v.n
  {
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255053);
      kotlin.g.b.s.u(paramLayoutInflater, "inflater");
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localView = (View)new ap(paramLayoutInflater, R.i.ghb);
        ((ap)localView).setTag(new bd.a().P(localView, false));
      }
      AppMethodBeat.o(255053);
      return localView;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255063);
      kotlin.g.b.s.u(parama, "tag");
      kotlin.g.b.s.u(parama1, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      kotlin.g.b.s.u(paramString, "userName");
      this.aeiK = parama1;
      bd.a locala = (bd.a)parama;
      locala.resetChatBubbleWidth(locala.clickArea, locala.aeOt);
      Object localObject = ((com.tencent.mm.openim.api.c)h.ax(com.tencent.mm.openim.api.c.class)).RD(paramcc.field_content);
      int i;
      if (localObject != null)
      {
        if (((CharSequence)((com.tencent.mm.openim.a.e)localObject).username).length() != 0) {
          break label386;
        }
        i = 1;
        if (i == 0) {}
      }
      else
      {
        Log.e("MicroMsg.ChattingItemOpenIMKefuNameCard", "alvinluo fillingOpenIMKefuCard content invalid");
      }
      parama = bd.aeVg;
      bd.e.a(parama1, (com.tencent.mm.openim.a.e)localObject, locala);
      View localView = locala.clickArea;
      boolean bool = parama1.juG();
      if (localObject == null)
      {
        parama = "";
        label146:
        parama = new bz(paramcc, bool, paramInt, parama, '\000');
        paramString = new Bundle();
        paramString.putString("kefu_card_ticket", ((com.tencent.mm.openim.a.e)localObject).hFb);
        localObject = ah.aiuX;
        parama.OMx = paramString;
        paramString = ah.aiuX;
        localView.setTag(parama);
        locala.clickArea.setOnClickListener((View.OnClickListener)new bd.b(parama1));
        locala.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
        locala.clickArea.setOnTouchListener((View.OnTouchListener)((m)parama1.cm(m.class)).jqv());
        Log.v("MicroMsg.ChattingItemOpenIMKefuNameCard", "alvinluo fillingNameCard msg.status: %s, showSend: %s", new Object[] { Integer.valueOf(paramcc.field_status), Boolean.valueOf(c.jxj()) });
        if (!c.jxj()) {
          break label432;
        }
        b((c.a)locala, false);
        if ((paramcc.field_status != 2) || (!b((m)parama1.cm(m.class), paramcc.field_msgId))) {
          break label413;
        }
        parama = locala.aeNG;
        if (parama != null) {
          parama.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, (c.a)locala, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, (v.n)this);
        AppMethodBeat.o(255063);
        return;
        label386:
        i = 0;
        break;
        paramString = ((com.tencent.mm.openim.a.e)localObject).username;
        parama = paramString;
        if (paramString != null) {
          break label146;
        }
        parama = "";
        break label146;
        label413:
        parama = locala.aeNG;
        if (parama != null) {
          parama.setVisibility(8);
        }
      }
      label432:
      parama = (c.a)locala;
      if (paramcc.field_status < 2) {}
      for (bool = true;; bool = false)
      {
        b(parama, bool);
        break;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255079);
      kotlin.g.b.s.u(paramMenuItem, "item");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = bd.aeVg;
        bd.e.j(parama, paramcc);
        AppMethodBeat.o(255079);
        return true;
      }
      AppMethodBeat.o(255079);
      return false;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255075);
      kotlin.g.b.s.u(params, "menu");
      kotlin.g.b.s.u(paramView, "v");
      if (paramcc == null)
      {
        AppMethodBeat.o(255075);
        return true;
      }
      paramContextMenuInfo = paramView.getTag();
      if (paramContextMenuInfo == null)
      {
        params = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(255075);
        throw params;
      }
      int i = ((bz)paramContextMenuInfo).position;
      paramContextMenuInfo = this.aeiK;
      kotlin.g.b.s.checkNotNull(paramContextMenuInfo);
      params.a(i, 111, (CharSequence)paramContextMenuInfo.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
      params.removeItem(116);
      if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)))
      {
        paramContextMenuInfo = this.aeiK;
        kotlin.g.b.s.checkNotNull(paramContextMenuInfo);
        if (!au.Hh(paramContextMenuInfo.getTalkerUserName())) {
          params.a(i, 123, (CharSequence)paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(255075);
        return true;
        if (this.aeiK != null)
        {
          paramContextMenuInfo = this.aeiK;
          kotlin.g.b.s.checkNotNull(paramContextMenuInfo);
          if (!paramContextMenuInfo.juH()) {
            params.a(i, 100, (CharSequence)paramView.getContext().getString(R.l.gyo), R.k.icons_filled_delete);
          }
        }
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255069);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      if ((paramcc.field_isSend == 1) && (paramcc.getType() == 67))
      {
        paramcc.unsetOmittedFailResend();
        bh.bCz();
        com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
        ((am)parama.cm(am.class)).cU(paramcc);
      }
      AppMethodBeat.o(255069);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255084);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      AppMethodBeat.o(255084);
      return false;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 67);
    }
    
    public final boolean fXn()
    {
      return true;
    }
    
    protected final boolean jxi()
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$Companion;", "", "()V", "KEFU_CARD_CONTENT_TICKET", "", "TAG", "fillingCardContent", "", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "cardContent", "Lcom/tencent/mm/openim/contact/OpenIMKefuContactCardContent;", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$CardItemHolder;", "transmitCard", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
  {
    public static void a(com.tencent.mm.ui.chatting.d.a parama, com.tencent.mm.openim.a.e parame, bd.a parama1)
    {
      com.tencent.mm.openim.api.e locale = null;
      AppMethodBeat.i(255065);
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(parama1, "holder");
      Object localObject1;
      Object localObject2;
      if (parame == null)
      {
        localObject1 = "";
        localObject2 = parama1.aeQb;
        if (localObject2 != null) {
          ((ImageView)localObject2).setBackgroundResource(R.g.default_avatar);
        }
        c.x(parama1.aeQb, (String)localObject1);
        TextView localTextView = parama1.lBD;
        if (localTextView != null)
        {
          Context localContext = (Context)parama.aezO.getContext();
          if (parame != null) {
            break label290;
          }
          localObject1 = "";
          label87:
          localObject1 = (CharSequence)localObject1;
          localObject2 = parama1.lBD;
          kotlin.g.b.s.checkNotNull(localObject2);
          localTextView.setText((CharSequence)p.b(localContext, (CharSequence)localObject1, ((TextView)localObject2).getTextSize()));
        }
        localObject1 = parama1.aeQc;
        if (localObject1 != null) {
          ((TextView)localObject1).setText(R.l.gyS);
        }
        if (parame != null) {
          break label312;
        }
        localObject1 = null;
        label151:
        if (parame != null) {
          break label321;
        }
        parame = locale;
        label158:
        if (Util.isNullOrNil((String)localObject1)) {
          break label329;
        }
        locale = (com.tencent.mm.openim.api.e)h.ax(com.tencent.mm.openim.api.e.class);
        parama = (Context)parama.aezO.getContext();
        localObject2 = parama1.aeQd;
        kotlin.g.b.s.checkNotNull(localObject2);
        parama = locale.a(parama, (String)localObject1, parame, ((TextView)localObject2).getTextSize());
        label215:
        if ((parama != null) && (parama.length() != 0)) {
          break label337;
        }
      }
      label290:
      label312:
      label321:
      label329:
      label337:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label342;
        }
        parame = parama1.aeQd;
        if (parame != null) {
          parame.setVisibility(0);
        }
        parame = parama1.aeQd;
        if (parame == null) {
          break label357;
        }
        parame.setText(parama);
        AppMethodBeat.o(255065);
        return;
        localObject2 = parame.username;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "";
        break;
        localObject2 = parame.nickName;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label87;
        }
        localObject1 = "";
        break label87;
        localObject1 = parame.prQ;
        break label151;
        parame = parame.prR;
        break label158;
        parama = (CharSequence)parame;
        break label215;
      }
      label342:
      parama = parama1.aeQd;
      if (parama != null) {
        parama.setVisibility(8);
      }
      label357:
      AppMethodBeat.o(255065);
    }
    
    public static void j(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255073);
      kotlin.g.b.s.u(parama, "ui");
      if (paramcc == null)
      {
        AppMethodBeat.o(255073);
        return;
      }
      Intent localIntent = new Intent((Context)parama.aezO.getContext(), MsgRetransmitUI.class);
      localIntent.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
      localIntent.putExtra("Retr_Msg_Type", 8);
      localIntent.putExtra("Retr_Msg_Id", paramcc.field_msgId);
      paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramcc.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$Companion", "transmitCard", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramcc.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemOpenIMKefuNameCard$Companion", "transmitCard", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(255073);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd
 * JD-Core Version:    0.7.0.1
 */