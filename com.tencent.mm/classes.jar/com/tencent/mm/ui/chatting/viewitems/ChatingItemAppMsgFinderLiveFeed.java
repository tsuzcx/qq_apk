package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Keep;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.report.live.s.av;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.n;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.aj.b;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.view.NinePatchCropImageView;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed;", "", "()V", "AppMsgFinderLiveFeedHolder", "ChattingItemAppMsgFinderLiveFeedFrom", "ChattingItemAppMsgFinderLiveFeedTo", "Companion", "app_release"})
public final class ChatingItemAppMsgFinderLiveFeed
{
  public static final c PGG;
  private static final String TAG = "ChatingItemAppMsgFinderLiveFeed";
  
  static
  {
    AppMethodBeat.i(231370);
    PGG = new c((byte)0);
    TAG = "ChatingItemAppMsgFinderLiveFeed";
    AppMethodBeat.o(231370);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "()V", "detailLayout", "Landroid/view/View;", "getDetailLayout", "()Landroid/view/View;", "setDetailLayout", "(Landroid/view/View;)V", "finderAvatar", "Landroid/widget/ImageView;", "getFinderAvatar", "()Landroid/widget/ImageView;", "setFinderAvatar", "(Landroid/widget/ImageView;)V", "finderDesc", "Landroid/widget/TextView;", "getFinderDesc", "()Landroid/widget/TextView;", "setFinderDesc", "(Landroid/widget/TextView;)V", "finderIcon", "getFinderIcon", "setFinderIcon", "finderNickname", "getFinderNickname", "setFinderNickname", "finderText", "getFinderText", "setFinderText", "finderThumb", "getFinderThumb", "setFinderThumb", "liveEndTag", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getLiveEndTag", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setLiveEndTag", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "liveTag", "getLiveTag", "setLiveTag", "tickIV", "getTickIV", "setTickIV", "width", "", "getWidth", "()I", "setWidth", "(I)V", "createAppMsgFinderFeedHolder", "view", "isSend", "", "getMainContainerView", "app_release"})
  @Keep
  public static final class AppMsgFinderLiveFeedHolder
    extends c.a
  {
    private View detailLayout;
    private ImageView finderAvatar;
    private TextView finderDesc;
    private ImageView finderIcon;
    private TextView finderNickname;
    private TextView finderText;
    private ImageView finderThumb;
    private FinderLiveOnliveWidget liveEndTag;
    private FinderLiveOnliveWidget liveTag;
    private ImageView tickIV;
    private int width;
    
    public final AppMsgFinderLiveFeedHolder createAppMsgFinderFeedHolder(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(231350);
      kotlin.g.b.p.h(paramView, "view");
      super.create(paramView);
      Object localObject1 = (LinearLayout)paramView.findViewById(2131298411);
      Object localObject2 = paramView.getContext();
      Point localPoint = au.az((Context)localObject2);
      int i = Math.min(localPoint.x, localPoint.y);
      kotlin.g.b.p.g(localObject2, "context");
      float f = ((Context)localObject2).getResources().getDimension(2131165289);
      this.width = ((int)((i - f) / 2.0F));
      kotlin.g.b.p.g(localObject1, "clickArea");
      localObject2 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        paramView = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(231350);
        throw paramView;
      }
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout.LayoutParams)localObject2).width = this.width;
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = ChatingItemAppMsgFinderLiveFeed.PGG;
      Log.i(ChatingItemAppMsgFinderLiveFeed.access$getTAG$cp(), "real widthPixels:" + i + " ,dp:" + f + " , width:" + this.width);
      this.finderAvatar = ((ImageView)paramView.findViewById(2131298472));
      this.finderNickname = ((TextView)paramView.findViewById(2131298477));
      this.finderThumb = ((ImageView)paramView.findViewById(2131298481));
      this.finderDesc = ((TextView)paramView.findViewById(2131298473));
      this.finderText = ((TextView)paramView.findViewById(2131298480));
      this.finderIcon = ((ImageView)paramView.findViewById(2131298474));
      this.liveEndTag = ((FinderLiveOnliveWidget)paramView.findViewById(2131300979));
      localObject2 = paramView.findViewById(2131298566);
      localObject1 = localObject2;
      if (!(localObject2 instanceof TextView)) {
        localObject1 = null;
      }
      localObject1 = (TextView)localObject1;
      if (localObject1 != null) {
        this.userTV = ((TextView)localObject1);
      }
      this.detailLayout = paramView.findViewById(2131298394);
      this.liveTag = ((FinderLiveOnliveWidget)paramView.findViewById(2131301031));
      if (!((aj)g.ah(aj.class)).showFinderEntry()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
          this.maskView = paramView.findViewById(2131298508);
        }
        if (!paramBoolean) {
          break label525;
        }
        this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
        this.tickIV = ((ImageView)paramView.findViewById(2131298556));
        if (!(this.finderThumb instanceof NinePatchCropImageView)) {
          break label485;
        }
        paramView = this.finderThumb;
        if (paramView != null) {
          break;
        }
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.view.NinePatchCropImageView");
        AppMethodBeat.o(231350);
        throw paramView;
      }
      ((NinePatchCropImageView)paramView).setNinePatchId(2131231809);
      for (;;)
      {
        label485:
        paramView = this.finderIcon;
        if (paramView != null) {
          paramView.setImageDrawable(ar.m(paramView.getContext(), 2131690801, com.tencent.mm.cb.a.n(paramView.getContext(), 2131099792)));
        }
        AppMethodBeat.o(231350);
        return this;
        label525:
        if ((this.finderThumb instanceof NinePatchCropImageView))
        {
          paramView = this.finderThumb;
          if (paramView == null)
          {
            paramView = new t("null cannot be cast to non-null type com.tencent.mm.view.NinePatchCropImageView");
            AppMethodBeat.o(231350);
            throw paramView;
          }
          ((NinePatchCropImageView)paramView).setNinePatchId(2131231692);
        }
      }
    }
    
    public final View getDetailLayout()
    {
      return this.detailLayout;
    }
    
    public final ImageView getFinderAvatar()
    {
      return this.finderAvatar;
    }
    
    public final TextView getFinderDesc()
    {
      return this.finderDesc;
    }
    
    public final ImageView getFinderIcon()
    {
      return this.finderIcon;
    }
    
    public final TextView getFinderNickname()
    {
      return this.finderNickname;
    }
    
    public final TextView getFinderText()
    {
      return this.finderText;
    }
    
    public final ImageView getFinderThumb()
    {
      return this.finderThumb;
    }
    
    public final FinderLiveOnliveWidget getLiveEndTag()
    {
      return this.liveEndTag;
    }
    
    public final FinderLiveOnliveWidget getLiveTag()
    {
      return this.liveTag;
    }
    
    public final View getMainContainerView()
    {
      return this.detailLayout;
    }
    
    public final ImageView getTickIV()
    {
      return this.tickIV;
    }
    
    public final int getWidth()
    {
      return this.width;
    }
    
    public final void setDetailLayout(View paramView)
    {
      this.detailLayout = paramView;
    }
    
    public final void setFinderAvatar(ImageView paramImageView)
    {
      this.finderAvatar = paramImageView;
    }
    
    public final void setFinderDesc(TextView paramTextView)
    {
      this.finderDesc = paramTextView;
    }
    
    public final void setFinderIcon(ImageView paramImageView)
    {
      this.finderIcon = paramImageView;
    }
    
    public final void setFinderNickname(TextView paramTextView)
    {
      this.finderNickname = paramTextView;
    }
    
    public final void setFinderText(TextView paramTextView)
    {
      this.finderText = paramTextView;
    }
    
    public final void setFinderThumb(ImageView paramImageView)
    {
      this.finderThumb = paramImageView;
    }
    
    public final void setLiveEndTag(FinderLiveOnliveWidget paramFinderLiveOnliveWidget)
    {
      this.liveEndTag = paramFinderLiveOnliveWidget;
    }
    
    public final void setLiveTag(FinderLiveOnliveWidget paramFinderLiveOnliveWidget)
    {
      this.liveTag = paramFinderLiveOnliveWidget;
    }
    
    public final void setTickIV(ImageView paramImageView)
    {
      this.tickIV = paramImageView;
    }
    
    public final void setWidth(int paramInt)
    {
      this.width = paramInt;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedFrom;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "support", "msgType", "Companion", "app_release"})
  public static final class a
    extends c
  {
    public static final ChatingItemAppMsgFinderLiveFeed.a.a PGH;
    private com.tencent.mm.ui.chatting.e.a PhN;
    
    static
    {
      AppMethodBeat.i(231357);
      PGH = new ChatingItemAppMsgFinderLiveFeed.a.a((byte)0);
      AppMethodBeat.o(231357);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(231352);
      kotlin.g.b.p.h(paramLayoutInflater, "inflater");
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localView = (View)new an(paramLayoutInflater, 2131493534);
        localView.setTag(new ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder().createAppMsgFinderFeedHolder(localView, false));
      }
      AppMethodBeat.o(231352);
      return localView;
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(231353);
      kotlin.g.b.p.h(parama, "tag");
      kotlin.g.b.p.h(parama1, "ui");
      kotlin.g.b.p.h(paramca, "msg");
      kotlin.g.b.p.h(paramString, "userName");
      this.PhN = parama1;
      paramString = (ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama;
      parama = paramString.getDetailLayout();
      if (parama == null) {
        kotlin.g.b.p.hyc();
      }
      parama.animate().cancel();
      parama = paramString.getDetailLayout();
      if (parama == null) {
        kotlin.g.b.p.hyc();
      }
      parama.setTag(Long.valueOf(System.currentTimeMillis()));
      Object localObject1 = paramca.getContent();
      parama = null;
      if (localObject1 != null) {
        parama = k.b.aD((String)localObject1, paramca.ajQ());
      }
      Object localObject2;
      Object localObject3;
      int i;
      if (parama != null)
      {
        localObject1 = (com.tencent.mm.plugin.i.a.b)parama.as(com.tencent.mm.plugin.i.a.b.class);
        if (localObject1 != null)
        {
          parama = com.tencent.mm.plugin.finder.loader.m.uJa;
          parama = com.tencent.mm.plugin.finder.loader.m.dka();
          localObject2 = new com.tencent.mm.plugin.finder.loader.p(((com.tencent.mm.plugin.i.a.b)localObject1).wDV.headUrl, com.tencent.mm.plugin.finder.storage.x.vEo);
          localObject3 = paramString.getFinderAvatar();
          if (localObject3 == null) {
            kotlin.g.b.p.hyc();
          }
          com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          parama.a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJh));
          parama = paramString.getFinderNickname();
          if (parama == null) {
            kotlin.g.b.p.hyc();
          }
          parama.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)parama1.getContext(), (CharSequence)((com.tencent.mm.plugin.i.a.b)localObject1).wDV.nickName));
          parama = paramString.getFinderNickname();
          if (parama == null) {
            kotlin.g.b.p.hyc();
          }
          ao.a((Paint)parama.getPaint(), 0.8F);
          if (((com.tencent.mm.plugin.i.a.b)localObject1).wDV.liveStatus != 1) {
            break label709;
          }
          parama = (CharSequence)((com.tencent.mm.plugin.i.a.b)localObject1).wDV.coverUrl;
          if ((parama != null) && (parama.length() != 0)) {
            break label645;
          }
          i = 1;
          if (i != 0) {
            break label651;
          }
          parama = ((com.tencent.mm.plugin.i.a.b)localObject1).wDV.coverUrl;
          label312:
          localObject2 = paramString.getLiveTag();
          if (localObject2 != null) {
            ((FinderLiveOnliveWidget)localObject2).setVisibility(0);
          }
          localObject2 = paramString.getLiveEndTag();
          if (localObject2 != null) {
            ((FinderLiveOnliveWidget)localObject2).setVisibility(8);
          }
          localObject2 = paramString.getLiveTag();
          if (localObject2 != null)
          {
            localObject3 = parama1.getContext();
            kotlin.g.b.p.g(localObject3, "ui.context");
            localObject3 = ((Activity)localObject3).getResources().getString(2131760176);
            kotlin.g.b.p.g(localObject3, "ui.context.resources.get…live_share_onlive_status)");
            ((FinderLiveOnliveWidget)localObject2).setText((String)localObject3);
          }
          ((aj)g.ah(aj.class)).loadImage(parama, paramString.getFinderThumb());
          com.tencent.mm.ac.d.a(200L, (kotlin.g.a.a)new b(paramString, (com.tencent.mm.plugin.i.a.b)localObject1, parama1));
          label444:
          parama = ChatingItemAppMsgFinderLiveFeed.PGG;
          ChatingItemAppMsgFinderLiveFeed.c.a(paramString);
          parama = paramString.getFinderThumb();
          if (parama == null) {
            kotlin.g.b.p.hyc();
          }
          parama.setVisibility(0);
          parama = (CharSequence)((com.tencent.mm.plugin.i.a.b)localObject1).wDV.desc;
          if ((parama != null) && (parama.length() != 0)) {
            break label963;
          }
          i = 1;
          label499:
          if (i == 0) {
            break label969;
          }
          parama = paramString.getFinderDesc();
          if (parama == null) {
            kotlin.g.b.p.hyc();
          }
          parama.setVisibility(8);
        }
      }
      for (;;)
      {
        paramString.clickArea.setOnClickListener((View.OnClickListener)d(parama1));
        paramString.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
        parama = paramString.clickArea;
        parama1 = parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
        kotlin.g.b.p.g(parama1, "ui.component(IChattingLi…terComponent::class.java)");
        parama.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.ui.chatting.d.b.k)parama1).gOC());
        parama = this.PhN;
        if (parama == null) {
          kotlin.g.b.p.hyc();
        }
        parama = new bq(paramca, parama.gRM(), paramInt, null, '\000');
        parama1 = paramString.clickArea;
        kotlin.g.b.p.g(parama1, "holder.clickArea");
        parama1.setTag(parama);
        AppMethodBeat.o(231353);
        return;
        label645:
        i = 0;
        break;
        label651:
        parama = (CharSequence)((com.tencent.mm.plugin.i.a.b)localObject1).wDV.headUrl;
        if ((parama == null) || (parama.length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label702;
          }
          parama = ((com.tencent.mm.plugin.i.a.b)localObject1).wDV.headUrl;
          break;
        }
        label702:
        parama = "";
        break label312;
        label709:
        if (((com.tencent.mm.plugin.i.a.b)localObject1).wDV.liveStatus != 2) {
          break label444;
        }
        parama = "";
        localObject2 = (CharSequence)((com.tencent.mm.plugin.i.a.b)localObject1).wDV.coverUrl;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          label756:
          if (i != 0) {
            break label902;
          }
          parama = ((com.tencent.mm.plugin.i.a.b)localObject1).wDV.coverUrl;
          kotlin.g.b.p.g(parama, "finderObject.shareObject.coverUrl");
        }
        label902:
        label961:
        for (;;)
        {
          localObject2 = paramString.getLiveTag();
          if (localObject2 != null) {
            ((FinderLiveOnliveWidget)localObject2).setVisibility(8);
          }
          localObject2 = paramString.getLiveEndTag();
          if (localObject2 != null) {
            ((FinderLiveOnliveWidget)localObject2).setVisibility(0);
          }
          localObject2 = paramString.getLiveTag();
          if (localObject2 != null)
          {
            localObject3 = parama1.getContext();
            kotlin.g.b.p.g(localObject3, "ui.context");
            localObject3 = ((Activity)localObject3).getResources().getString(2131760176);
            kotlin.g.b.p.g(localObject3, "ui.context.resources.get…live_share_onlive_status)");
            ((FinderLiveOnliveWidget)localObject2).setText((String)localObject3);
          }
          ((aj)g.ah(aj.class)).getFinderUtilApi().g(paramString.getFinderThumb(), parama);
          break;
          i = 0;
          break label756;
          localObject2 = (CharSequence)((com.tencent.mm.plugin.i.a.b)localObject1).wDV.headUrl;
          if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label961;
            }
            parama = ((com.tencent.mm.plugin.i.a.b)localObject1).wDV.headUrl;
            kotlin.g.b.p.g(parama, "finderObject.shareObject.headUrl");
            break;
          }
        }
        label963:
        i = 0;
        break label499;
        label969:
        parama = paramString.getFinderDesc();
        if (parama == null) {
          kotlin.g.b.p.hyc();
        }
        parama.setVisibility(0);
        parama = paramString.getFinderDesc();
        if (parama == null) {
          kotlin.g.b.p.hyc();
        }
        parama.setText((CharSequence)((com.tencent.mm.plugin.i.a.b)localObject1).wDV.desc);
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(231355);
      kotlin.g.b.p.h(paramMenuItem, "item");
      kotlin.g.b.p.h(parama, "ui");
      kotlin.g.b.p.h(paramca, "msg");
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(231355);
        return false;
      }
      paramMenuItem = ChatingItemAppMsgFinderLiveFeed.PGG;
      paramMenuItem = parama.getContext();
      kotlin.g.b.p.g(paramMenuItem, "ui.context");
      ChatingItemAppMsgFinderLiveFeed.c.a(paramMenuItem, paramca);
      AppMethodBeat.o(231355);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(231354);
      kotlin.g.b.p.h(paramm, "menu");
      kotlin.g.b.p.h(paramView, "v");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramm = new t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(231354);
        throw paramm;
      }
      int i = ((bq)paramView).position;
      if (paramca != null)
      {
        paramView = this.PhN;
        if (paramView == null) {
          kotlin.g.b.p.hyc();
        }
        paramm.a(i, 111, (CharSequence)paramView.getResources().getString(2131764628), 2131690674);
        paramm.removeItem(116);
      }
      AppMethodBeat.o(231354);
      return true;
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 973078577);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(231356);
      kotlin.g.b.p.h(paramView, "v");
      kotlin.g.b.p.h(parama, "ui");
      kotlin.g.b.p.h(paramca, "msg");
      Object localObject = paramca.getContent();
      paramView = null;
      if (localObject != null) {
        paramView = k.b.aD((String)localObject, paramca.ajQ());
      }
      long l2;
      long l3;
      if (paramView != null)
      {
        localObject = (com.tencent.mm.plugin.i.a.b)paramView.as(com.tencent.mm.plugin.i.a.b.class);
        if (localObject != null)
        {
          l2 = com.tencent.mm.ac.d.Ga(((com.tencent.mm.plugin.i.a.b)localObject).wDV.feedId);
          l3 = com.tencent.mm.ac.d.Ga(((com.tencent.mm.plugin.i.a.b)localObject).wDV.hJs);
          if (l2 != 0L)
          {
            paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (!((Boolean)com.tencent.mm.plugin.finder.storage.c.dvR().value()).booleanValue()) {
              break label180;
            }
            paramView = new Intent();
            paramView.putExtra("feed_object_id", l2);
            paramView.putExtra("feed_object_nonceId", ((com.tencent.mm.plugin.i.a.b)localObject).wDV.objectNonceId);
            ((aj)g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramView);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(231356);
        return false;
        label180:
        if (!Util.isEqual(((com.tencent.mm.plugin.i.a.b)localObject).wDV.username, z.aUg())) {
          break;
        }
        ((aj)g.ah(aj.class)).enterFinderLiveAnchorUI(MMApplicationContext.getContext(), l2, Long.valueOf(l3), ((com.tencent.mm.plugin.i.a.b)localObject).wDV.objectNonceId, ((com.tencent.mm.plugin.i.a.b)localObject).wDV.desc, "", "");
      }
      paramca = a(parama, paramca);
      paramView = paramca;
      if (paramca == null)
      {
        paramView = parama.getTalker();
        kotlin.g.b.p.g(paramView, "ui.talker");
        paramView = paramView.getUsername();
      }
      paramca = paramView;
      if (paramView == null) {
        paramca = "";
      }
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = paramca;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs(parama.getTalker().gMZ);
      paramView = com.tencent.mm.plugin.finder.report.live.k.vkd;
      String str1 = ((com.tencent.mm.plugin.i.a.b)localObject).wDV.username;
      kotlin.g.b.p.g(str1, "finderObject.shareObject.username");
      s.p localp = s.p.voF;
      String str2 = s.j.vnS.scene;
      if (((com.tencent.mm.plugin.i.a.b)localObject).wDV.liveStatus == 1) {}
      for (long l1 = s.n.vop.jii;; l1 = s.n.voq.jii)
      {
        paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        long l4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.cPi();
        parama = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq;
        paramView = parama;
        if (parama == null) {
          paramView = "";
        }
        paramca = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr;
        parama = paramca;
        if (paramca == null) {
          parama = "";
        }
        com.tencent.mm.plugin.finder.report.live.k.b(new com.tencent.mm.plugin.finder.report.live.q(l2, l3, str1, 0L, -1L, localp, str2, l1, l4, paramView, parama, System.currentTimeMillis(), s.av.vsc));
        ((aj)g.ah(aj.class)).enterFinderLiveVisitorUI(MMApplicationContext.getContext(), l2, Long.valueOf(l3), ((com.tencent.mm.plugin.i.a.b)localObject).wDV.username, ((com.tencent.mm.plugin.i.a.b)localObject).wDV.objectNonceId, ((com.tencent.mm.plugin.i.a.b)localObject).wDV.desc, "", "");
        break;
      }
    }
    
    public final boolean gTT()
    {
      return false;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, com.tencent.mm.plugin.i.a.b paramb, com.tencent.mm.ui.chatting.e.a parama)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedTo;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/ChattingListEventListener$StateBtnClickListener;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "filling", "", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "support", "msgType", "Companion", "app_release"})
  public static final class b
    extends c
    implements t.n
  {
    public static final ChatingItemAppMsgFinderLiveFeed.b.a PGL;
    private com.tencent.mm.ui.chatting.e.a PhN;
    
    static
    {
      AppMethodBeat.i(231365);
      PGL = new ChatingItemAppMsgFinderLiveFeed.b.a((byte)0);
      AppMethodBeat.o(231365);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(231359);
      kotlin.g.b.p.h(paramLayoutInflater, "inflater");
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localView = (View)new an(paramLayoutInflater, 2131493585);
        localView.setTag(new ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder().createAppMsgFinderFeedHolder(localView, true));
      }
      AppMethodBeat.o(231359);
      return localView;
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(231360);
      kotlin.g.b.p.h(parama, "tag");
      kotlin.g.b.p.h(parama1, "ui");
      kotlin.g.b.p.h(paramca, "msg");
      kotlin.g.b.p.h(paramString, "userName");
      this.PhN = parama1;
      paramString = (ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama;
      parama = paramString.getDetailLayout();
      if (parama == null) {
        kotlin.g.b.p.hyc();
      }
      parama.animate().cancel();
      parama = paramString.getDetailLayout();
      if (parama == null) {
        kotlin.g.b.p.hyc();
      }
      parama.setTag(Long.valueOf(System.currentTimeMillis()));
      Object localObject1 = paramca.getContent();
      parama = null;
      if (localObject1 != null) {
        parama = k.b.aD((String)localObject1, paramca.ajQ());
      }
      Object localObject2;
      Object localObject3;
      int i;
      if (parama != null)
      {
        localObject1 = ((com.tencent.mm.plugin.i.a.b)parama.as(com.tencent.mm.plugin.i.a.b.class)).wDV;
        if (localObject1 != null)
        {
          parama = com.tencent.mm.plugin.finder.loader.m.uJa;
          parama = com.tencent.mm.plugin.finder.loader.m.dka();
          localObject2 = new com.tencent.mm.plugin.finder.loader.p(((axf)localObject1).headUrl, com.tencent.mm.plugin.finder.storage.x.vEo);
          localObject3 = paramString.getFinderAvatar();
          if (localObject3 == null) {
            kotlin.g.b.p.hyc();
          }
          com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          parama.a(localObject2, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJh));
          parama = paramString.getFinderNickname();
          if (parama == null) {
            kotlin.g.b.p.hyc();
          }
          parama.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)parama1.getContext(), (CharSequence)((axf)localObject1).nickName));
          parama = paramString.getFinderNickname();
          if (parama == null) {
            kotlin.g.b.p.hyc();
          }
          ao.a((Paint)parama.getPaint(), 0.8F);
          if (((axf)localObject1).liveStatus != 1) {
            break label808;
          }
          parama = (CharSequence)((axf)localObject1).coverUrl;
          if ((parama == null) || (parama.length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label756;
            }
            parama = ((axf)localObject1).coverUrl;
            label300:
            localObject2 = paramString.getLiveTag();
            if (localObject2 != null) {
              ((FinderLiveOnliveWidget)localObject2).setVisibility(0);
            }
            localObject2 = paramString.getLiveEndTag();
            if (localObject2 != null) {
              ((FinderLiveOnliveWidget)localObject2).setVisibility(8);
            }
            localObject2 = paramString.getLiveTag();
            if (localObject2 != null)
            {
              localObject3 = parama1.getContext();
              kotlin.g.b.p.g(localObject3, "ui.context");
              localObject3 = ((Activity)localObject3).getResources().getString(2131760176);
              kotlin.g.b.p.g(localObject3, "ui.context.resources.get…live_share_onlive_status)");
              ((FinderLiveOnliveWidget)localObject2).setText((String)localObject3);
            }
            ((aj)g.ah(aj.class)).loadImage(parama, paramString.getFinderThumb());
            com.tencent.mm.ac.d.a(200L, (kotlin.g.a.a)new b(paramString, (axf)localObject1, parama1));
            label432:
            parama = ChatingItemAppMsgFinderLiveFeed.PGG;
            ChatingItemAppMsgFinderLiveFeed.c.a(paramString);
            parama = paramString.getFinderThumb();
            if (parama == null) {
              kotlin.g.b.p.hyc();
            }
            parama.setVisibility(0);
            parama = (CharSequence)((axf)localObject1).desc;
            if ((parama != null) && (parama.length() != 0)) {
              break label1047;
            }
            i = 1;
            label484:
            if (i == 0) {
              break label1053;
            }
            parama = paramString.getFinderDesc();
            if (parama == null) {
              kotlin.g.b.p.hyc();
            }
            parama.setVisibility(8);
          }
        }
        else
        {
          label508:
          paramString.clickArea.setOnClickListener((View.OnClickListener)d(parama1));
          paramString.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
          parama = paramString.clickArea;
          localObject1 = parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
          kotlin.g.b.p.g(localObject1, "ui.component(IChattingLi…terComponent::class.java)");
          parama.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.ui.chatting.d.b.k)localObject1).gOC());
          parama = this.PhN;
          if (parama == null) {
            kotlin.g.b.p.hyc();
          }
          parama = new bq(paramca, parama.gRM(), paramInt, null, '\000');
          localObject1 = paramString.clickArea;
          kotlin.g.b.p.g(localObject1, "holder.clickArea");
          ((View)localObject1).setTag(parama);
        }
      }
      else
      {
        if (!c.gTW()) {
          break label1129;
        }
        if (paramString.uploadingPB != null)
        {
          parama = paramString.uploadingPB;
          kotlin.g.b.p.g(parama, "holder.uploadingPB");
          parama.setVisibility(8);
        }
        if ((paramca.getStatus() != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), paramca.ajL()))) {
          break label1099;
        }
        if (paramString.getTickIV() != null)
        {
          parama = paramString.getTickIV();
          if (parama == null) {
            kotlin.g.b.p.hyc();
          }
          parama.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, (c.a)paramString, paramca, parama1.gRI(), parama1.gRM(), parama1, (t.n)this);
        AppMethodBeat.o(231360);
        return;
        i = 0;
        break;
        label756:
        parama = (CharSequence)((axf)localObject1).headUrl;
        if ((parama == null) || (parama.length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label801;
          }
          parama = ((axf)localObject1).headUrl;
          break;
        }
        label801:
        parama = "";
        break label300;
        label808:
        if (((axf)localObject1).liveStatus != 2) {
          break label432;
        }
        parama = "";
        localObject2 = (CharSequence)((axf)localObject1).coverUrl;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          label849:
          if (i != 0) {
            break label992;
          }
          parama = ((axf)localObject1).coverUrl;
          kotlin.g.b.p.g(parama, "finderObject.coverUrl");
        }
        label1045:
        for (;;)
        {
          localObject2 = paramString.getLiveTag();
          if (localObject2 != null) {
            ((FinderLiveOnliveWidget)localObject2).setVisibility(8);
          }
          localObject2 = paramString.getLiveEndTag();
          if (localObject2 != null) {
            ((FinderLiveOnliveWidget)localObject2).setVisibility(0);
          }
          localObject2 = paramString.getLiveTag();
          if (localObject2 != null)
          {
            localObject3 = parama1.getContext();
            kotlin.g.b.p.g(localObject3, "ui.context");
            localObject3 = ((Activity)localObject3).getResources().getString(2131760176);
            kotlin.g.b.p.g(localObject3, "ui.context.resources.get…live_share_onlive_status)");
            ((FinderLiveOnliveWidget)localObject2).setText((String)localObject3);
          }
          ((aj)g.ah(aj.class)).getFinderUtilApi().g(paramString.getFinderThumb(), parama);
          break;
          i = 0;
          break label849;
          label992:
          localObject2 = (CharSequence)((axf)localObject1).headUrl;
          if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label1045;
            }
            parama = ((axf)localObject1).headUrl;
            kotlin.g.b.p.g(parama, "finderObject.headUrl");
            break;
          }
        }
        label1047:
        i = 0;
        break label484;
        label1053:
        parama = paramString.getFinderDesc();
        if (parama == null) {
          kotlin.g.b.p.hyc();
        }
        parama.setVisibility(0);
        parama = paramString.getFinderDesc();
        if (parama == null) {
          kotlin.g.b.p.hyc();
        }
        parama.setText((CharSequence)((axf)localObject1).desc);
        break label508;
        label1099:
        if (paramString.getTickIV() != null)
        {
          parama = paramString.getTickIV();
          if (parama == null) {
            kotlin.g.b.p.hyc();
          }
          parama.setVisibility(8);
        }
      }
      label1129:
      if (paramString.getTickIV() != null)
      {
        parama = paramString.getTickIV();
        if (parama == null) {
          kotlin.g.b.p.hyc();
        }
        parama.setVisibility(8);
      }
      parama = (c.a)paramString;
      if (paramca.getStatus() < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(parama, bool);
        break;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(231363);
      kotlin.g.b.p.h(paramMenuItem, "item");
      kotlin.g.b.p.h(parama, "ui");
      kotlin.g.b.p.h(paramca, "msg");
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(231363);
        return false;
      }
      paramMenuItem = ChatingItemAppMsgFinderLiveFeed.PGG;
      paramMenuItem = parama.getContext();
      kotlin.g.b.p.g(paramMenuItem, "ui.context");
      ChatingItemAppMsgFinderLiveFeed.c.a(paramMenuItem, paramca);
      AppMethodBeat.o(231363);
      return true;
    }
    
    public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
    {
      AppMethodBeat.i(231362);
      kotlin.g.b.p.h(paramm, "menu");
      kotlin.g.b.p.h(paramView, "v");
      Object localObject = paramView.getTag();
      if (localObject == null)
      {
        paramm = new t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(231362);
        throw paramm;
      }
      int i = ((bq)localObject).position;
      if (paramca != null)
      {
        localObject = this.PhN;
        if (localObject == null) {
          kotlin.g.b.p.hyc();
        }
        paramm.a(i, 111, (CharSequence)((com.tencent.mm.ui.chatting.e.a)localObject).getResources().getString(2131764628), 2131690674);
        paramm.removeItem(116);
        if (((paramca.getStatus() == 2) || (paramca.ajS() == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.ajO())))
        {
          paramca = this.PhN;
          if (paramca == null) {
            kotlin.g.b.p.hyc();
          }
          if (!paramca.gRO()) {
            paramm.a(i, 123, (CharSequence)paramView.getContext().getString(2131757446), 2131690650);
          }
        }
      }
      AppMethodBeat.o(231362);
      return true;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(231361);
      kotlin.g.b.p.h(paramView, "v");
      kotlin.g.b.p.h(parama, "ui");
      kotlin.g.b.p.h(paramca, "msg");
      if (paramca.dOQ())
      {
        com.tencent.mm.pluginsdk.model.app.m.aS(paramca);
        bp.Ad(paramca.ajL());
        parama.BN(true);
      }
      AppMethodBeat.o(231361);
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 973078577);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(231364);
      kotlin.g.b.p.h(paramView, "v");
      kotlin.g.b.p.h(parama, "ui");
      kotlin.g.b.p.h(paramca, "msg");
      Object localObject = paramca.getContent();
      paramView = null;
      if (localObject != null) {
        paramView = k.b.aD((String)localObject, paramca.ajQ());
      }
      long l2;
      long l3;
      if (paramView != null)
      {
        localObject = (com.tencent.mm.plugin.i.a.b)paramView.as(com.tencent.mm.plugin.i.a.b.class);
        if (localObject != null)
        {
          l2 = com.tencent.mm.ac.d.Ga(((com.tencent.mm.plugin.i.a.b)localObject).wDV.feedId);
          l3 = com.tencent.mm.ac.d.Ga(((com.tencent.mm.plugin.i.a.b)localObject).wDV.hJs);
          if (l2 != 0L)
          {
            paramView = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (!((Boolean)com.tencent.mm.plugin.finder.storage.c.dvR().value()).booleanValue()) {
              break label180;
            }
            paramView = new Intent();
            paramView.putExtra("feed_object_id", l2);
            paramView.putExtra("feed_object_nonceId", ((com.tencent.mm.plugin.i.a.b)localObject).wDV.objectNonceId);
            ((aj)g.ah(aj.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramView);
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(231364);
        return false;
        label180:
        paramca = a(parama, paramca);
        paramView = paramca;
        if (paramca == null)
        {
          paramView = parama.getTalker();
          kotlin.g.b.p.g(paramView, "ui.talker");
          paramView = paramView.getUsername();
        }
        paramca = paramView;
        if (paramView == null) {
          paramca = "";
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = paramca;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs(parama.getTalker().gMZ);
        if (!Util.isEqual(((com.tencent.mm.plugin.i.a.b)localObject).wDV.username, z.aUg())) {
          break;
        }
        ((aj)g.ah(aj.class)).enterFinderLiveAnchorUI(MMApplicationContext.getContext(), l2, Long.valueOf(l3), ((com.tencent.mm.plugin.i.a.b)localObject).wDV.objectNonceId, ((com.tencent.mm.plugin.i.a.b)localObject).wDV.desc, "", "");
      }
      paramView = com.tencent.mm.plugin.finder.report.live.k.vkd;
      String str1 = ((com.tencent.mm.plugin.i.a.b)localObject).wDV.username;
      kotlin.g.b.p.g(str1, "finderObject.shareObject.username");
      s.p localp = s.p.voF;
      String str2 = s.j.vnS.scene;
      if (((com.tencent.mm.plugin.i.a.b)localObject).wDV.liveStatus == 1) {}
      for (long l1 = s.n.vop.jii;; l1 = s.n.voq.jii)
      {
        paramView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        long l4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.cPi();
        parama = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq;
        paramView = parama;
        if (parama == null) {
          paramView = "";
        }
        paramca = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr;
        parama = paramca;
        if (paramca == null) {
          parama = "";
        }
        com.tencent.mm.plugin.finder.report.live.k.b(new com.tencent.mm.plugin.finder.report.live.q(l2, l3, str1, 0L, -1L, localp, str2, l1, l4, paramView, parama, System.currentTimeMillis(), s.av.vsc));
        ((aj)g.ah(aj.class)).enterFinderLiveVisitorUI(MMApplicationContext.getContext(), l2, Long.valueOf(l3), ((com.tencent.mm.plugin.i.a.b)localObject).wDV.username, ((com.tencent.mm.plugin.i.a.b)localObject).wDV.objectNonceId, ((com.tencent.mm.plugin.i.a.b)localObject).wDV.desc, "", "");
        break;
      }
    }
    
    public final boolean gTT()
    {
      return true;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, axf paramaxf, com.tencent.mm.ui.chatting.e.a parama)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adjustMediaHeight", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "width", "", "height", "checkLiveStatus", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "retransmit", "context", "Landroid/app/Activity;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "app_release"})
  public static final class c
  {
    public static void a(Activity paramActivity, ca paramca)
    {
      AppMethodBeat.i(231368);
      kotlin.g.b.p.h(paramActivity, "context");
      kotlin.g.b.p.h(paramca, "msg");
      if (!Util.isNullOrNil(paramca.getContent()))
      {
        paramca = k.b.HD(paramca.getContent());
        if (paramca != null)
        {
          Intent localIntent = new Intent((Context)paramActivity, MsgRetransmitUI.class);
          localIntent.putExtra("Retr_Msg_Type", 23);
          localIntent.putExtra("Multi_Retr", true);
          localIntent.putExtra("Retr_Msg_content", k.b.a(paramca, null, null));
          localIntent.putExtra("Retr_go_to_chattingUI", false);
          localIntent.putExtra("Retr_show_success_tips", true);
          paramca = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
          com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramca.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramActivity.startActivity((Intent)paramca.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      AppMethodBeat.o(231368);
    }
    
    public static void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder)
    {
      AppMethodBeat.i(231367);
      kotlin.g.b.p.h(paramAppMsgFinderLiveFeedHolder, "holder");
      int i = paramAppMsgFinderLiveFeedHolder.getWidth();
      Object localObject = paramAppMsgFinderLiveFeedHolder.getFinderThumb();
      if (localObject == null) {
        kotlin.g.b.p.hyc();
      }
      localObject = ((ImageView)localObject).getLayoutParams();
      if (localObject == null)
      {
        paramAppMsgFinderLiveFeedHolder = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(231367);
        throw paramAppMsgFinderLiveFeedHolder;
      }
      localObject = (FrameLayout.LayoutParams)localObject;
      ((FrameLayout.LayoutParams)localObject).height = i;
      paramAppMsgFinderLiveFeedHolder = paramAppMsgFinderLiveFeedHolder.getFinderThumb();
      if (paramAppMsgFinderLiveFeedHolder == null) {
        kotlin.g.b.p.hyc();
      }
      paramAppMsgFinderLiveFeedHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(231367);
    }
    
    public static void a(final ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, axf paramaxf, com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(231369);
      kotlin.g.b.p.h(paramAppMsgFinderLiveFeedHolder, "holder");
      kotlin.g.b.p.h(paramaxf, "shareObject");
      kotlin.g.b.p.h(parama, "ui");
      parama = paramaxf.hJs;
      if (parama != null)
      {
        parama = n.buB(parama);
        if (parama == null) {}
      }
      for (long l = parama.longValue();; l = 0L)
      {
        ((aj)g.ah(aj.class)).refreshLiveStatus(Long.valueOf(l), (aj.b)new a(l, paramaxf, paramAppMsgFinderLiveFeedHolder));
        AppMethodBeat.o(231369);
        return;
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "liveId", "", "status", "", "liveInfo", "", "kotlin.jvm.PlatformType", "onLiveStatusCallback"})
    static final class a
      implements aj.b
    {
      a(long paramLong, axf paramaxf, ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder) {}
      
      public final void a(long paramLong, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(231366);
        paramObject = ChatingItemAppMsgFinderLiveFeed.PGG;
        Log.i(ChatingItemAppMsgFinderLiveFeed.access$getTAG$cp(), "[checkLiveStatus] thisLiveId:" + this.EYq + ",liveID:" + paramLong + ",desc:" + paramAppMsgFinderLiveFeedHolder.desc + ",share status:" + paramAppMsgFinderLiveFeedHolder.liveStatus + ",callback liveStatus:" + paramInt);
        if (this.EYq == paramLong)
        {
          paramObject = (CharSequence)paramAppMsgFinderLiveFeedHolder.coverUrl;
          int i;
          if ((paramObject == null) || (paramObject.length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label229;
            }
            paramObject = paramAppMsgFinderLiveFeedHolder.coverUrl;
          }
          for (;;)
          {
            if (paramInt != 2) {
              break label289;
            }
            paramAppMsgFinderLiveFeedHolder.liveStatus = paramInt;
            FinderLiveOnliveWidget localFinderLiveOnliveWidget = this.PGI.getLiveTag();
            if (localFinderLiveOnliveWidget != null) {
              localFinderLiveOnliveWidget.setVisibility(8);
            }
            localFinderLiveOnliveWidget = this.PGI.getLiveEndTag();
            if (localFinderLiveOnliveWidget != null) {
              localFinderLiveOnliveWidget.setVisibility(0);
            }
            ((aj)g.ah(aj.class)).getFinderUtilApi().g(this.PGI.getFinderThumb(), paramObject);
            AppMethodBeat.o(231366);
            return;
            i = 0;
            break;
            label229:
            paramObject = (CharSequence)paramAppMsgFinderLiveFeedHolder.headUrl;
            if ((paramObject == null) || (paramObject.length() == 0)) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label282;
              }
              paramObject = paramAppMsgFinderLiveFeedHolder.headUrl;
              break;
            }
            label282:
            paramObject = "";
          }
          label289:
          if (paramInt == 1) {
            paramAppMsgFinderLiveFeedHolder.liveStatus = paramInt;
          }
        }
        AppMethodBeat.o(231366);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed
 * JD-Core Version:    0.7.0.1
 */