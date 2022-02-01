package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.loader.d;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.h;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct;", "", "()V", "AppMsgFinderProductHolder", "ChattingItemAppMsgFinderProductFrom", "ChattingItemAppMsgFinderProductTo", "Companion", "FinderProductDelegate", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ChattingItemAppMsgFinderProduct
{
  private static final String TAG;
  public static final c aeQl;
  
  static
  {
    AppMethodBeat.i(255242);
    aeQl = new c((byte)0);
    TAG = "MicroMsg.ChattingItemAppMsgFinderProduct";
    AppMethodBeat.o(255242);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$AppMsgFinderProductHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "()V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "setAvatar", "(Landroid/widget/ImageView;)V", "coverIv", "getCoverIv", "setCoverIv", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "detailLayout", "Landroid/view/View;", "getDetailLayout", "()Landroid/view/View;", "setDetailLayout", "(Landroid/view/View;)V", "itemMaskView", "getItemMaskView", "setItemMaskView", "nicknameTv", "getNicknameTv", "setNicknameTv", "storeLayout", "getStoreLayout", "setStoreLayout", "tickIV", "getTickIV", "setTickIV", "titleTv", "getTitleTv", "setTitleTv", "build", "view", "isSend", "", "getMainContainerView", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class AppMsgFinderProductHolder
    extends c.a
  {
    private ImageView avatar;
    private ImageView coverIv;
    private TextView descTv;
    private View detailLayout;
    private View itemMaskView;
    private TextView nicknameTv;
    private View storeLayout;
    private ImageView tickIV;
    private TextView titleTv;
    
    public final AppMsgFinderProductHolder build(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(254950);
      kotlin.g.b.s.u(paramView, "view");
      super.create(paramView);
      this.detailLayout = paramView.findViewById(R.h.fxi);
      Object localObject = paramView.findViewById(R.h.fAr);
      if ((localObject instanceof TextView))
      {
        localObject = (TextView)localObject;
        if (localObject != null) {
          this.userTV = ((TextView)localObject);
        }
        this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
        this.maskView = paramView.findViewById(R.h.fzn);
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
        if (!paramBoolean) {
          break label217;
        }
        this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      }
      for (;;)
      {
        this.avatar = ((ImageView)paramView.findViewById(R.h.frF));
        this.nicknameTv = ((TextView)paramView.findViewById(R.h.frG));
        this.titleTv = ((TextView)paramView.findViewById(R.h.frJ));
        this.descTv = ((TextView)paramView.findViewById(R.h.frw));
        this.coverIv = ((ImageView)paramView.findViewById(R.h.frv));
        this.itemMaskView = paramView.findViewById(R.h.fyX);
        this.storeLayout = paramView.findViewById(R.h.fYm);
        AppMethodBeat.o(254950);
        return this;
        localObject = null;
        break;
        label217:
        localObject = this.uploadingPB;
        if (localObject != null) {
          ((ProgressBar)localObject).setVisibility(8);
        }
      }
    }
    
    public final ImageView getAvatar()
    {
      return this.avatar;
    }
    
    public final ImageView getCoverIv()
    {
      return this.coverIv;
    }
    
    public final TextView getDescTv()
    {
      return this.descTv;
    }
    
    public final View getDetailLayout()
    {
      return this.detailLayout;
    }
    
    public final View getItemMaskView()
    {
      return this.itemMaskView;
    }
    
    public final View getMainContainerView()
    {
      return this.detailLayout;
    }
    
    public final TextView getNicknameTv()
    {
      return this.nicknameTv;
    }
    
    public final View getStoreLayout()
    {
      return this.storeLayout;
    }
    
    public final ImageView getTickIV()
    {
      return this.tickIV;
    }
    
    public final TextView getTitleTv()
    {
      return this.titleTv;
    }
    
    public final void setAvatar(ImageView paramImageView)
    {
      this.avatar = paramImageView;
    }
    
    public final void setCoverIv(ImageView paramImageView)
    {
      this.coverIv = paramImageView;
    }
    
    public final void setDescTv(TextView paramTextView)
    {
      this.descTv = paramTextView;
    }
    
    public final void setDetailLayout(View paramView)
    {
      this.detailLayout = paramView;
    }
    
    public final void setItemMaskView(View paramView)
    {
      this.itemMaskView = paramView;
    }
    
    public final void setNicknameTv(TextView paramTextView)
    {
      this.nicknameTv = paramTextView;
    }
    
    public final void setStoreLayout(View paramView)
    {
      this.storeLayout = paramView;
    }
    
    public final void setTickIV(ImageView paramImageView)
    {
      this.tickIV = paramImageView;
    }
    
    public final void setTitleTv(TextView paramTextView)
    {
      this.titleTv = paramTextView;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$ChattingItemAppMsgFinderProductFrom;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/ChattingListEventListener$StateBtnClickListener;", "()V", "dlg", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$FinderProductDelegate;", "getDlg", "()Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$FinderProductDelegate;", "filling", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "support", "msgType", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends c
    implements v.n
  {
    private final ChattingItemAppMsgFinderProduct.d aeQm;
    
    public a()
    {
      AppMethodBeat.i(255611);
      this.aeQm = new ChattingItemAppMsgFinderProduct.d(true);
      AppMethodBeat.o(255611);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255618);
      paramLayoutInflater = this.aeQm.a(paramLayoutInflater, paramView);
      AppMethodBeat.o(255618);
      return paramLayoutInflater;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255623);
      kotlin.g.b.s.u(parama1, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      paramString = this.aeQm;
      c localc = (c)this;
      if ((parama instanceof ChattingItemAppMsgFinderProduct.AppMsgFinderProductHolder)) {}
      for (parama = (ChattingItemAppMsgFinderProduct.AppMsgFinderProductHolder)parama;; parama = null)
      {
        paramString.a(localc, parama, paramInt, parama1, paramcc);
        AppMethodBeat.o(255623);
        return;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255633);
      kotlin.g.b.s.u(paramcc, "msg");
      boolean bool = ChattingItemAppMsgFinderProduct.d.a(paramMenuItem, parama, paramcc);
      AppMethodBeat.o(255633);
      return bool;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255626);
      kotlin.g.b.s.u(paramcc, "msg");
      boolean bool = this.aeQm.a((c)this, params, paramView, paramcc);
      AppMethodBeat.o(255626);
      return bool;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255638);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      this.aeQm.b(paramView, parama, paramcc);
      AppMethodBeat.o(255638);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255630);
      kotlin.g.b.s.u(paramcc, "msg");
      boolean bool = ChattingItemAppMsgFinderProduct.d.c(paramView, parama, paramcc);
      AppMethodBeat.o(255630);
      return bool;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(255614);
      paramBoolean = this.aeQm.cM(paramInt, paramBoolean);
      AppMethodBeat.o(255614);
      return paramBoolean;
    }
    
    public final boolean fXn()
    {
      AppMethodBeat.i(255635);
      boolean bool = this.aeQm.fXn();
      AppMethodBeat.o(255635);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$ChattingItemAppMsgFinderProductTo;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/ChattingListEventListener$StateBtnClickListener;", "()V", "dlg", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$FinderProductDelegate;", "getDlg", "()Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$FinderProductDelegate;", "filling", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "support", "msgType", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends c
    implements v.n
  {
    private final ChattingItemAppMsgFinderProduct.d aeQm;
    
    public b()
    {
      AppMethodBeat.i(255613);
      this.aeQm = new ChattingItemAppMsgFinderProduct.d(false);
      AppMethodBeat.o(255613);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255627);
      paramLayoutInflater = this.aeQm.a(paramLayoutInflater, paramView);
      AppMethodBeat.o(255627);
      return paramLayoutInflater;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(255634);
      kotlin.g.b.s.u(parama1, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      paramString = this.aeQm;
      c localc = (c)this;
      if ((parama instanceof ChattingItemAppMsgFinderProduct.AppMsgFinderProductHolder)) {}
      for (parama = (ChattingItemAppMsgFinderProduct.AppMsgFinderProductHolder)parama;; parama = null)
      {
        paramString.a(localc, parama, paramInt, parama1, paramcc);
        AppMethodBeat.o(255634);
        return;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255650);
      kotlin.g.b.s.u(paramcc, "msg");
      boolean bool = ChattingItemAppMsgFinderProduct.d.a(paramMenuItem, parama, paramcc);
      AppMethodBeat.o(255650);
      return bool;
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255641);
      kotlin.g.b.s.u(paramcc, "msg");
      boolean bool = this.aeQm.a((c)this, params, paramView, paramcc);
      AppMethodBeat.o(255641);
      return bool;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255666);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      this.aeQm.b(paramView, parama, paramcc);
      AppMethodBeat.o(255666);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255646);
      kotlin.g.b.s.u(paramcc, "msg");
      boolean bool = ChattingItemAppMsgFinderProduct.d.c(paramView, parama, paramcc);
      AppMethodBeat.o(255646);
      return bool;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(255621);
      paramBoolean = this.aeQm.cM(paramInt, paramBoolean);
      AppMethodBeat.o(255621);
      return paramBoolean;
    }
    
    public final boolean fXn()
    {
      AppMethodBeat.i(255657);
      boolean bool = this.aeQm.fXn();
      AppMethodBeat.o(255657);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$Companion;", "", "()V", "TAG", "", "enterShoppingWeApp", "", "context", "Landroid/content/Context;", "appId", "enterPath", "sceneNote", "shareToken", "isLiving", "", "coverData", "onItemClick", "v", "Landroid/view/View;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "onQuoteLiveMsgClick", "username", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static boolean c(View paramView, final com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255603);
      kotlin.g.b.s.u(paramcc, "msg");
      String str1 = paramcc.field_content;
      Object localObject = null;
      if (str1 != null) {
        localObject = k.b.aP(str1, paramcc.field_reserved);
      }
      int i;
      int j;
      label96:
      String str2;
      if ((localObject != null) && (parama != null))
      {
        final bth localbth = ((h)((k.b)localObject).aK(h.class)).HbZ;
        localObject = (CharSequence)localbth.aabe;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label263;
          }
          j = 1177;
          str2 = parama.getTalkerUserName();
          if (!au.bwE(str2)) {
            break label271;
          }
          i = 3;
          label112:
          ah.f localf = new ah.f();
          StringBuilder localStringBuilder = new StringBuilder();
          str1 = localbth.finderUsername;
          localObject = str1;
          if (str1 == null) {
            localObject = "";
          }
          localf.aqH = ((String)localObject + ':' + i + ':' + str2 + ':' + j);
          localObject = com.tencent.mm.plugin.finder.utils.ah.Ghp;
          localObject = parama.aezO.getContext();
          kotlin.g.b.s.s(localObject, "ui.context");
          com.tencent.mm.plugin.finder.utils.ah.a((Context)localObject, localbth, (kotlin.g.a.s)new a(localf, localbth, parama));
        }
      }
      for (;;)
      {
        localObject = com.tencent.mm.ui.chatting.component.c.aeok;
        com.tencent.mm.ui.chatting.component.c.a.d(parama, paramView, paramcc);
        AppMethodBeat.o(255603);
        return true;
        i = 0;
        break;
        label263:
        j = 1195;
        break label96;
        label271:
        if (au.bwF(str2))
        {
          i = 4;
          break label112;
        }
        if (au.bwO(str2))
        {
          i = 2;
          break label112;
        }
        i = 1;
        break label112;
        Log.i(ChattingItemAppMsgFinderProduct.access$getTAG$cp(), "onItemClick content is null");
      }
    }
    
    public static boolean d(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255600);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      boolean bool = c(paramView, parama, paramcc);
      AppMethodBeat.o(255600);
      return bool;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode", "isLiving", "isProductInLivingRoom", "requestId", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.s<Integer, Integer, Integer, Integer, String, kotlin.ah>
    {
      a(ah.f<String> paramf, bth parambth, com.tencent.mm.ui.chatting.d.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$FinderProductDelegate;", "", "from", "", "(Z)V", "getFrom", "()Z", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "chattingItem", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$AppMsgFinderProductHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    private final boolean aePy;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public d(boolean paramBoolean)
    {
      this.aePy = paramBoolean;
    }
    
    private static void a(Activity paramActivity, cc paramcc)
    {
      AppMethodBeat.i(255648);
      kotlin.g.b.s.u(paramActivity, "context");
      kotlin.g.b.s.u(paramcc, "msg");
      if (!Util.isNullOrNil(paramcc.field_content))
      {
        k.b localb = k.b.Hf(paramcc.field_content);
        if (localb != null)
        {
          Intent localIntent = new Intent((Context)paramActivity, MsgRetransmitUI.class);
          localIntent.putExtra("Retr_Msg_Id", paramcc.field_msgId);
          localIntent.putExtra("Retr_Msg_Type", 30);
          localIntent.putExtra("Multi_Retr", true);
          localIntent.putExtra("Retr_Msg_content", k.b.a(localb, null, null));
          localIntent.putExtra("Retr_go_to_chattingUI", false);
          localIntent.putExtra("Retr_show_success_tips", true);
          paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramcc.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$FinderProductDelegate", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramActivity.startActivity((Intent)paramcc.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgFinderProduct$FinderProductDelegate", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      AppMethodBeat.o(255648);
    }
    
    private static final void a(ChattingItemAppMsgFinderProduct.AppMsgFinderProductHolder paramAppMsgFinderProductHolder)
    {
      int j = 0;
      AppMethodBeat.i(255656);
      Object localObject = paramAppMsgFinderProductHolder.getStoreLayout();
      int i;
      if (localObject == null)
      {
        i = 0;
        localObject = paramAppMsgFinderProductHolder.getStoreLayout();
        if (localObject != null) {
          break label80;
        }
        label27:
        localObject = paramAppMsgFinderProductHolder.getItemMaskView();
        if (localObject != null) {
          break label88;
        }
      }
      label80:
      label88:
      for (localObject = null;; localObject = ((View)localObject).getLayoutParams())
      {
        if (localObject != null)
        {
          ((ViewGroup.LayoutParams)localObject).width = i;
          ((ViewGroup.LayoutParams)localObject).height = j;
          paramAppMsgFinderProductHolder = paramAppMsgFinderProductHolder.getItemMaskView();
          if (paramAppMsgFinderProductHolder != null) {
            paramAppMsgFinderProductHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        AppMethodBeat.o(255656);
        return;
        i = ((View)localObject).getWidth();
        break;
        j = ((View)localObject).getHeight();
        break label27;
      }
    }
    
    public static boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255645);
      kotlin.g.b.s.u(paramcc, "msg");
      if ((paramMenuItem == null) || (parama == null))
      {
        AppMethodBeat.o(255645);
        return false;
      }
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = parama.aezO.getContext();
        kotlin.g.b.s.s(paramMenuItem, "ui.context");
        a(paramMenuItem, paramcc);
        AppMethodBeat.o(255645);
        return true;
      }
      AppMethodBeat.o(255645);
      return false;
    }
    
    public static boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255642);
      kotlin.g.b.s.u(paramcc, "msg");
      ChattingItemAppMsgFinderProduct.c localc = ChattingItemAppMsgFinderProduct.aeQl;
      boolean bool = ChattingItemAppMsgFinderProduct.c.c(paramView, parama, paramcc);
      AppMethodBeat.o(255642);
      return bool;
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(255668);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        if (!this.aePy) {
          break label88;
        }
        paramLayoutInflater = (View)new ap(paramLayoutInflater, R.i.gfK);
        paramView = (ap)paramLayoutInflater;
        localObject = new ChattingItemAppMsgFinderProduct.AppMsgFinderProductHolder();
        if (this.aePy) {
          break label106;
        }
      }
      label88:
      label106:
      for (boolean bool = true;; bool = false)
      {
        paramView.setTag(((ChattingItemAppMsgFinderProduct.AppMsgFinderProductHolder)localObject).build(paramLayoutInflater, bool));
        localObject = paramLayoutInflater;
        AppMethodBeat.o(255668);
        return localObject;
        paramLayoutInflater = (View)new ap(paramLayoutInflater, R.i.ggK);
        break;
      }
    }
    
    public final void a(c paramc, ChattingItemAppMsgFinderProduct.AppMsgFinderProductHolder paramAppMsgFinderProductHolder, int paramInt, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255679);
      kotlin.g.b.s.u(paramc, "chattingItem");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      this.aeiK = parama;
      if (paramAppMsgFinderProductHolder == null)
      {
        Log.i(ChattingItemAppMsgFinderProduct.access$getTAG$cp(), "filling not AppMsgFinderProductHolder");
        AppMethodBeat.o(255679);
        return;
      }
      Object localObject1 = com.tencent.mm.ui.chatting.component.c.aeok;
      com.tencent.mm.ui.chatting.component.c.a.c(parama, paramAppMsgFinderProductHolder.convertView, paramcc);
      localObject1 = paramcc.field_content;
      if (localObject1 != null) {}
      for (localObject1 = k.b.aP((String)localObject1, paramcc.field_reserved);; localObject1 = null)
      {
        Object localObject2;
        label347:
        int i;
        if (localObject1 == null)
        {
          localObject2 = null;
          if (localObject2 != null)
          {
            bth localbth = ((h)((k.b)localObject1).aK(h.class)).HbZ;
            localObject1 = paramAppMsgFinderProductHolder.getAvatar();
            Object localObject4;
            if (localObject1 != null)
            {
              localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
              localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
              localObject3 = new com.tencent.mm.plugin.finder.loader.s(localbth.aabl, v.FKZ);
              localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
              ((d)localObject2).a(localObject3, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExP));
            }
            localObject1 = paramAppMsgFinderProductHolder.getNicknameTv();
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)parama.aezO.getContext(), (CharSequence)localbth.ESn));
            }
            localObject1 = paramAppMsgFinderProductHolder.getTitleTv();
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)parama.aezO.getContext(), (CharSequence)localbth.aabi));
            }
            localObject1 = paramAppMsgFinderProductHolder.getDescTv();
            if (localObject1 != null)
            {
              localObject2 = aw.Gjk;
              ((TextView)localObject1).setText((CharSequence)kotlin.g.b.s.X("￥", aw.Uu(localbth.aabk)));
              localObject2 = aw.Gjk;
              aw.f((TextView)localObject1, false);
              if (localbth.aabk > 0) {
                break label691;
              }
              Log.i(ChattingItemAppMsgFinderProduct.access$getTAG$cp(), kotlin.g.b.s.X("price invalid, ", Integer.valueOf(localbth.aabk)));
              ((TextView)localObject1).setVisibility(8);
            }
            Object localObject3 = paramAppMsgFinderProductHolder.getCoverIv();
            if (localObject3 != null)
            {
              localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
              localObject4 = com.tencent.mm.plugin.finder.loader.p.eCn();
              localObject2 = localbth.coverUrl;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = "";
              }
              localObject1 = new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKZ);
              localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
              ((d)localObject4).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
              localObject1 = (CharSequence)localbth.coverUrl;
              if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
                break label700;
              }
              i = 1;
              label451:
              if (i != 0) {
                Log.i(ChattingItemAppMsgFinderProduct.access$getTAG$cp(), "coverUrl is empty");
              }
            }
            paramAppMsgFinderProductHolder.clickArea.setOnClickListener((View.OnClickListener)paramc.d(parama));
            paramAppMsgFinderProductHolder.clickArea.setOnLongClickListener((View.OnLongClickListener)paramc.c(parama));
            localObject2 = paramAppMsgFinderProductHolder.clickArea;
            localObject1 = (m)parama.cm(m.class);
            if (localObject1 != null) {
              break label706;
            }
          }
        }
        label691:
        label700:
        label706:
        for (localObject1 = null;; localObject1 = ((m)localObject1).jqv())
        {
          ((View)localObject2).setOnTouchListener((View.OnTouchListener)localObject1);
          localObject1 = new bz(paramcc, parama.juG(), paramInt, null, '\000');
          paramAppMsgFinderProductHolder.clickArea.setTag(localObject1);
          localObject1 = paramAppMsgFinderProductHolder.getStoreLayout();
          if (localObject1 != null) {
            ((View)localObject1).post(new ChattingItemAppMsgFinderProduct.d..ExternalSyntheticLambda0(paramAppMsgFinderProductHolder));
          }
          if ((this.aePy) || (!c.jxj())) {
            break label747;
          }
          if (paramAppMsgFinderProductHolder.uploadingPB != null) {
            paramAppMsgFinderProductHolder.uploadingPB.setVisibility(8);
          }
          if ((paramcc.field_status != 2) || (!c.b((m)parama.cm(m.class), paramcc.field_msgId))) {
            break label718;
          }
          if (paramAppMsgFinderProductHolder.getTickIV() == null) {
            break label796;
          }
          paramc = paramAppMsgFinderProductHolder.getTickIV();
          kotlin.g.b.s.checkNotNull(paramc);
          paramc.setVisibility(0);
          AppMethodBeat.o(255679);
          return;
          localObject2 = (h)((k.b)localObject1).aK(h.class);
          break;
          ((TextView)localObject1).setVisibility(0);
          break label347;
          i = 0;
          break label451;
        }
        label718:
        if (paramAppMsgFinderProductHolder.getTickIV() != null)
        {
          paramc = paramAppMsgFinderProductHolder.getTickIV();
          kotlin.g.b.s.checkNotNull(paramc);
          paramc.setVisibility(8);
          AppMethodBeat.o(255679);
          return;
          label747:
          if (paramAppMsgFinderProductHolder.getTickIV() != null)
          {
            parama = paramAppMsgFinderProductHolder.getTickIV();
            kotlin.g.b.s.checkNotNull(parama);
            parama.setVisibility(8);
          }
          paramAppMsgFinderProductHolder = (c.a)paramAppMsgFinderProductHolder;
          if (paramcc.field_status >= 2) {
            break label803;
          }
        }
        label796:
        label803:
        for (boolean bool = true;; bool = false)
        {
          paramc.b(paramAppMsgFinderProductHolder, bool);
          AppMethodBeat.o(255679);
          return;
        }
      }
    }
    
    public final boolean a(c paramc, com.tencent.mm.ui.base.s params, View paramView, cc paramcc)
    {
      AppMethodBeat.i(255683);
      kotlin.g.b.s.u(paramc, "chattingItem");
      if ((params == null) || (paramView == null))
      {
        AppMethodBeat.o(255683);
        return false;
      }
      paramc = this.aeiK;
      int i;
      if (paramc != null)
      {
        if (!this.aePy) {
          break label129;
        }
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
          AppMethodBeat.o(255683);
          throw paramc;
        }
        i = ((bz)paramView).position;
        if (paramcc != null)
        {
          params.a(i, 111, (CharSequence)paramc.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
          params.removeItem(116);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(255683);
        return true;
        label129:
        Object localObject = paramView.getTag();
        if (localObject == null)
        {
          paramc = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
          AppMethodBeat.o(255683);
          throw paramc;
        }
        i = ((bz)localObject).position;
        if (paramcc != null)
        {
          params.a(i, 111, (CharSequence)paramc.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
          params.removeItem(116);
          if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c.c(paramcc, paramc)) && (c.bBs(paramcc.field_talker)) && (!au.Hh(paramc.getTalkerUserName()))) {
            params.a(i, 123, (CharSequence)paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
          }
        }
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(255688);
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "ui");
      kotlin.g.b.s.u(paramcc, "msg");
      if ((!this.aePy) && (paramcc.fxR()))
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
      }
      AppMethodBeat.o(255688);
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      if (this.aePy) {
        if ((paramBoolean) || (paramInt != 974127153)) {}
      }
      while ((paramBoolean) && (paramInt == 974127153))
      {
        return true;
        return false;
      }
      return false;
    }
    
    public final boolean fXn()
    {
      return !this.aePy;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChattingItemAppMsgFinderProduct
 * JD-Core Version:    0.7.0.1
 */