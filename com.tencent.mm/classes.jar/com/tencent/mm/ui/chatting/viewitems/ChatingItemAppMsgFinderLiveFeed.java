package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
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
import androidx.annotation.Keep;
import com.tencent.c.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.report.s.bj;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.r;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.view.NinePatchCropImageView;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed;", "", "()V", "AppMsgFinderLiveFeedHolder", "ChattingItemAppMsgFinderLiveFeedFrom", "ChattingItemAppMsgFinderLiveFeedTo", "Companion", "IChattingItemAppMsgFinderLiveFeed", "app_release"})
public final class ChatingItemAppMsgFinderLiveFeed
{
  private static final String TAG = "ChatingItemAppMsgFinderLiveFeed";
  public static final c XbY;
  
  static
  {
    AppMethodBeat.i(280696);
    XbY = new c((byte)0);
    TAG = "ChatingItemAppMsgFinderLiveFeed";
    AppMethodBeat.o(280696);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "()V", "detailLayout", "Landroid/view/View;", "getDetailLayout", "()Landroid/view/View;", "setDetailLayout", "(Landroid/view/View;)V", "finderAvatar", "Landroid/widget/ImageView;", "getFinderAvatar", "()Landroid/widget/ImageView;", "setFinderAvatar", "(Landroid/widget/ImageView;)V", "finderDesc", "Landroid/widget/TextView;", "getFinderDesc", "()Landroid/widget/TextView;", "setFinderDesc", "(Landroid/widget/TextView;)V", "finderIcon", "getFinderIcon", "setFinderIcon", "finderNickname", "getFinderNickname", "setFinderNickname", "finderText", "getFinderText", "setFinderText", "finderThumb", "getFinderThumb", "setFinderThumb", "liveEndTag", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getLiveEndTag", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setLiveEndTag", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "liveTag", "getLiveTag", "setLiveTag", "tickIV", "getTickIV", "setTickIV", "width", "", "getWidth", "()I", "setWidth", "(I)V", "createAppMsgFinderFeedHolder", "view", "isSend", "", "getMainContainerView", "app_release"})
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
      AppMethodBeat.i(277675);
      p.k(paramView, "view");
      super.create(paramView);
      Object localObject1 = (LinearLayout)paramView.findViewById(R.h.chatting_click_area);
      Object localObject2 = paramView.getContext();
      Point localPoint = ax.au((Context)localObject2);
      int i = Math.min(localPoint.x, localPoint.y);
      p.j(localObject2, "context");
      float f = ((Context)localObject2).getResources().getDimension(R.f.Edge_1_5_A);
      this.width = ((int)((i - f) / 2.0F));
      p.j(localObject1, "clickArea");
      localObject2 = ((LinearLayout)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(277675);
        throw paramView;
      }
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout.LayoutParams)localObject2).width = this.width;
      ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = ChatingItemAppMsgFinderLiveFeed.XbY;
      Log.i(ChatingItemAppMsgFinderLiveFeed.access$getTAG$cp(), "real widthPixels:" + i + " ,dp:" + f + " , width:" + this.width);
      this.finderAvatar = ((ImageView)paramView.findViewById(R.h.dxY));
      this.finderNickname = ((TextView)paramView.findViewById(R.h.dye));
      this.finderThumb = ((ImageView)paramView.findViewById(R.h.dyi));
      this.finderDesc = ((TextView)paramView.findViewById(R.h.dxZ));
      this.finderText = ((TextView)paramView.findViewById(R.h.dyh));
      this.finderIcon = ((ImageView)paramView.findViewById(R.h.dya));
      this.liveEndTag = ((FinderLiveOnliveWidget)paramView.findViewById(R.h.finder_live_end_tag));
      localObject2 = paramView.findViewById(R.h.chatting_user_tv);
      localObject1 = localObject2;
      if (!(localObject2 instanceof TextView)) {
        localObject1 = null;
      }
      localObject1 = (TextView)localObject1;
      if (localObject1 != null) {
        this.userTV = ((TextView)localObject1);
      }
      this.detailLayout = paramView.findViewById(R.h.dwR);
      this.liveTag = ((FinderLiveOnliveWidget)paramView.findViewById(R.h.finder_live_icon));
      if (!((ak)h.ag(ak.class)).showFinderEntry()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0)
        {
          this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
          this.maskView = paramView.findViewById(R.h.dyD);
        }
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
        if (!paramBoolean) {
          break label538;
        }
        this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        if (!(this.finderThumb instanceof NinePatchCropImageView)) {
          break label498;
        }
        paramView = this.finderThumb;
        if (paramView != null) {
          break;
        }
        paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.NinePatchCropImageView");
        AppMethodBeat.o(277675);
        throw paramView;
      }
      ((NinePatchCropImageView)paramView).setNinePatchId(R.g.chatto_finder_image_bg);
      for (;;)
      {
        label498:
        paramView = this.finderIcon;
        if (paramView != null) {
          paramView.setImageDrawable(au.o(paramView.getContext(), R.k.icons_outlined_finder_icon, com.tencent.mm.ci.a.w(paramView.getContext(), R.e.Orange)));
        }
        AppMethodBeat.o(277675);
        return this;
        label538:
        paramView = this.uploadingPB;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        if ((this.finderThumb instanceof NinePatchCropImageView))
        {
          paramView = this.finderThumb;
          if (paramView == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.NinePatchCropImageView");
            AppMethodBeat.o(277675);
            throw paramView;
          }
          ((NinePatchCropImageView)paramView).setNinePatchId(R.g.chatfrom_finder_image_bg);
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedFrom;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$IChattingItemAppMsgFinderLiveFeed;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "filling", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "Companion", "app_release"})
  public static class a
    extends c
  {
    public static final ChatingItemAppMsgFinderLiveFeed.a.a XbZ;
    private com.tencent.mm.ui.chatting.e.a WBq;
    
    static
    {
      AppMethodBeat.i(270781);
      XbZ = new ChatingItemAppMsgFinderLiveFeed.a.a((byte)0);
      AppMethodBeat.o(270781);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(270772);
      p.k(paramLayoutInflater, "inflater");
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() != 0) {
          break label88;
        }
      }
      label88:
      for (int i = R.i.ecR;; i = R.i.ecS)
      {
        localView = (View)new aq(paramLayoutInflater, i);
        localView.setTag(new ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder().createAppMsgFinderFeedHolder(localView, false));
        AppMethodBeat.o(270772);
        return localView;
      }
    }
    
    public void a(Activity paramActivity, ca paramca)
    {
      AppMethodBeat.i(270779);
      p.k(paramActivity, "context");
      p.k(paramca, "msg");
      ChatingItemAppMsgFinderLiveFeed.c localc = ChatingItemAppMsgFinderLiveFeed.XbY;
      ChatingItemAppMsgFinderLiveFeed.c.a(paramActivity, paramca);
      AppMethodBeat.o(270779);
    }
    
    public void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bcp parambcp, com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(270780);
      p.k(paramAppMsgFinderLiveFeedHolder, "holder");
      p.k(parambcp, "shareObject");
      p.k(parama, "ui");
      ChatingItemAppMsgFinderLiveFeed.c localc = ChatingItemAppMsgFinderLiveFeed.XbY;
      ChatingItemAppMsgFinderLiveFeed.c.a(paramAppMsgFinderLiveFeedHolder, parambcp, parama);
      AppMethodBeat.o(270780);
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(270773);
      p.k(parama, "tag");
      p.k(parama1, "ui");
      p.k(paramca, "msg");
      p.k(paramString, "userName");
      this.WBq = parama1;
      final ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder localAppMsgFinderLiveFeedHolder = (ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama;
      parama = localAppMsgFinderLiveFeedHolder.getDetailLayout();
      if (parama == null) {
        p.iCn();
      }
      parama.animate().cancel();
      parama = localAppMsgFinderLiveFeedHolder.getDetailLayout();
      if (parama == null) {
        p.iCn();
      }
      parama.setTag(Long.valueOf(System.currentTimeMillis()));
      parama = paramca.getContent();
      if (parama != null) {}
      for (parama = k.b.aG(parama, paramca.apL());; parama = null)
      {
        final com.tencent.mm.plugin.findersdk.a.b localb;
        Object localObject;
        int i;
        if (parama != null)
        {
          localb = (com.tencent.mm.plugin.findersdk.a.b)parama.ar(com.tencent.mm.plugin.findersdk.a.b.class);
          if (localb != null)
          {
            parama = com.tencent.mm.plugin.finder.loader.t.ztT;
            parama = com.tencent.mm.plugin.finder.loader.t.dJh();
            paramString = new com.tencent.mm.plugin.finder.loader.x(localb.Bvb.headUrl, u.Alz);
            localObject = localAppMsgFinderLiveFeedHolder.getFinderAvatar();
            if (localObject == null) {
              p.iCn();
            }
            com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
            parama.a(paramString, (ImageView)localObject, com.tencent.mm.plugin.finder.loader.t.a(t.a.zua));
            parama = localAppMsgFinderLiveFeedHolder.getFinderNickname();
            if (parama == null) {
              p.iCn();
            }
            parama.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)parama1.getContext(), (CharSequence)localb.Bvb.nickName));
            parama = localAppMsgFinderLiveFeedHolder.getFinderNickname();
            if (parama == null) {
              p.iCn();
            }
            ar.a((Paint)parama.getPaint(), 0.8F);
            if (localb.Bvb.liveStatus != 1) {
              break label706;
            }
            parama = (CharSequence)localb.Bvb.coverUrl;
            if ((parama != null) && (parama.length() != 0)) {
              break label642;
            }
            i = 1;
            if (i != 0) {
              break label648;
            }
            parama = localb.Bvb.coverUrl;
            label308:
            paramString = localAppMsgFinderLiveFeedHolder.getLiveTag();
            if (paramString != null) {
              paramString.setVisibility(0);
            }
            paramString = localAppMsgFinderLiveFeedHolder.getLiveEndTag();
            if (paramString != null) {
              paramString.setVisibility(8);
            }
            paramString = localAppMsgFinderLiveFeedHolder.getLiveTag();
            if (paramString != null)
            {
              localObject = parama1.getContext();
              p.j(localObject, "ui.context");
              localObject = ((Activity)localObject).getResources().getString(R.l.finder_live_share_onlive_status);
              p.j(localObject, "ui.context.resources.get…live_share_onlive_status)");
              paramString.setText((String)localObject);
            }
            ((ak)h.ag(ak.class)).loadImage(parama, localAppMsgFinderLiveFeedHolder.getFinderThumb());
            com.tencent.mm.ae.d.a(200L, (kotlin.g.a.a)new b(this, localAppMsgFinderLiveFeedHolder, localb, parama1));
            label441:
            parama = ChatingItemAppMsgFinderLiveFeed.XbY;
            ChatingItemAppMsgFinderLiveFeed.c.a(localAppMsgFinderLiveFeedHolder);
            parama = localAppMsgFinderLiveFeedHolder.getFinderThumb();
            if (parama == null) {
              p.iCn();
            }
            parama.setVisibility(0);
            parama = (CharSequence)localb.Bvb.desc;
            if ((parama != null) && (parama.length() != 0)) {
              break label972;
            }
            i = 1;
            label496:
            if (i == 0) {
              break label978;
            }
            parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
            if (parama == null) {
              p.iCn();
            }
            parama.setVisibility(8);
          }
        }
        for (;;)
        {
          localAppMsgFinderLiveFeedHolder.clickArea.setOnClickListener((View.OnClickListener)d(parama1));
          localAppMsgFinderLiveFeedHolder.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
          parama = localAppMsgFinderLiveFeedHolder.clickArea;
          parama1 = parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class);
          p.j(parama1, "ui.component(IChattingLi…terComponent::class.java)");
          parama.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.ui.chatting.d.b.k)parama1).hNO());
          parama = this.WBq;
          if (parama == null) {
            p.iCn();
          }
          parama = new by(paramca, parama.hRi(), paramInt, null, '\000');
          parama1 = localAppMsgFinderLiveFeedHolder.clickArea;
          p.j(parama1, "holder.clickArea");
          parama1.setTag(parama);
          AppMethodBeat.o(270773);
          return;
          label642:
          i = 0;
          break;
          label648:
          parama = (CharSequence)localb.Bvb.headUrl;
          if ((parama == null) || (parama.length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label699;
            }
            parama = localb.Bvb.headUrl;
            break;
          }
          label699:
          parama = "";
          break label308;
          label706:
          if (localb.Bvb.liveStatus != 2) {
            break label441;
          }
          parama = "";
          paramString = (CharSequence)localb.Bvb.coverUrl;
          if ((paramString == null) || (paramString.length() == 0))
          {
            i = 1;
            label753:
            if (i != 0) {
              break label905;
            }
            paramString = localb.Bvb.coverUrl;
            parama = paramString;
            if (paramString == null) {
              parama = "";
            }
          }
          label905:
          label970:
          for (;;)
          {
            paramString = localAppMsgFinderLiveFeedHolder.getLiveTag();
            if (paramString != null) {
              paramString.setVisibility(8);
            }
            paramString = localAppMsgFinderLiveFeedHolder.getLiveEndTag();
            if (paramString != null) {
              paramString.setVisibility(0);
            }
            paramString = localAppMsgFinderLiveFeedHolder.getLiveTag();
            if (paramString != null)
            {
              localObject = parama1.getContext();
              p.j(localObject, "ui.context");
              localObject = ((Activity)localObject).getResources().getString(R.l.finder_live_share_onlive_status);
              p.j(localObject, "ui.context.resources.get…live_share_onlive_status)");
              paramString.setText((String)localObject);
            }
            ((ak)h.ag(ak.class)).getFinderUtilApi().f(localAppMsgFinderLiveFeedHolder.getFinderThumb(), parama);
            break;
            i = 0;
            break label753;
            paramString = (CharSequence)localb.Bvb.headUrl;
            if ((paramString == null) || (paramString.length() == 0)) {}
            for (i = 1;; i = 0)
            {
              if (i != 0) {
                break label970;
              }
              paramString = localb.Bvb.headUrl;
              parama = paramString;
              if (paramString == null) {
                parama = "";
              }
              break;
            }
          }
          label972:
          i = 0;
          break label496;
          label978:
          parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
          if (parama == null) {
            p.iCn();
          }
          parama.setVisibility(0);
          parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
          if (parama == null) {
            p.iCn();
          }
          parama.setText((CharSequence)localb.Bvb.desc);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(270776);
      p.k(paramMenuItem, "item");
      p.k(parama, "ui");
      p.k(paramca, "msg");
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(270776);
        return false;
      }
      paramMenuItem = parama.getContext();
      p.j(paramMenuItem, "ui.context");
      a(paramMenuItem, paramca);
      AppMethodBeat.o(270776);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(270774);
      p.k(paramo, "menu");
      p.k(paramView, "v");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramo = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(270774);
        throw paramo;
      }
      int i = ((by)paramView).position;
      if (paramca != null)
      {
        paramView = this.WBq;
        if (paramView == null) {
          p.iCn();
        }
        paramo.a(i, 111, (CharSequence)paramView.getResources().getString(R.l.retransmit), R.k.icons_filled_share);
        paramo.removeItem(116);
      }
      AppMethodBeat.o(270774);
      return true;
    }
    
    public boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 973078577);
    }
    
    public boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(270778);
      p.k(paramView, "v");
      p.k(parama, "ui");
      p.k(paramca, "msg");
      Object localObject1 = paramca.getContent();
      paramView = null;
      if (localObject1 != null) {
        paramView = k.b.aG((String)localObject1, paramca.apL());
      }
      Object localObject3;
      long l2;
      long l3;
      if (paramView != null)
      {
        localObject3 = (com.tencent.mm.plugin.findersdk.a.b)paramView.ar(com.tencent.mm.plugin.findersdk.a.b.class);
        if (localObject3 != null)
        {
          l2 = com.tencent.mm.ae.d.Nb(((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.feedId);
          l3 = com.tencent.mm.ae.d.Nb(((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.kwM);
          if (l2 != 0L)
          {
            paramView = com.tencent.c.a.a.a.a.a.Zlt;
            if (!((Boolean)com.tencent.c.a.a.a.a.a.imm().aSr()).booleanValue()) {
              break label180;
            }
            paramView = new Intent();
            paramView.putExtra("feed_object_id", l2);
            paramView.putExtra("feed_object_nonceId", ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.objectNonceId);
            ((ak)h.ag(ak.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramView);
          }
        }
      }
      label180:
      Object localObject2;
      for (;;)
      {
        AppMethodBeat.o(270778);
        return false;
        if (!Util.isEqual(((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.username, z.bdh())) {
          break;
        }
        paramca = new Intent();
        paramca.putExtra("KEY_PARAMS_SOURCE_TYPE", ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.sourceType);
        localObject1 = (com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class);
        localObject2 = MMApplicationContext.getContext();
        parama = ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.objectNonceId;
        paramView = parama;
        if (parama == null) {
          paramView = "";
        }
        ((com.tencent.c.a.a.a.b)localObject1).enterFinderLiveAnchorUI(paramca, (Context)localObject2, l2, Long.valueOf(l3), paramView, ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.desc, "", "", "");
      }
      paramca = a(parama, paramca);
      paramView = paramca;
      if (paramca == null)
      {
        paramView = parama.getTalker();
        p.j(paramView, "ui.talker");
        paramView = paramView.getUsername();
      }
      paramca = paramView;
      if (paramView == null) {
        paramca = "";
      }
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl = paramca;
      com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(parama.getTalker().jxt);
      paramView = com.tencent.mm.plugin.finder.live.report.k.yBj;
      paramca = ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.username;
      paramView = paramca;
      if (paramca == null) {
        paramView = "";
      }
      Object localObject4 = s.t.yGS;
      Object localObject5 = s.l.yFU.scene;
      long l1;
      if (((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.liveStatus == 1)
      {
        l1 = s.r.yGC.status;
        label407:
        paramca = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        long l4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.deb();
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl;
        paramca = (ca)localObject1;
        if (localObject1 == null) {
          paramca = "";
        }
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.plugin.finder.live.report.k.b(new com.tencent.mm.plugin.finder.live.report.q(l2, l3, paramView, 0L, -1L, (s.t)localObject4, (String)localObject5, l1, l4, paramca, (String)localObject1, System.currentTimeMillis(), s.bj.yMa, null, null, null, null, 122880));
        if (parama.hRh()) {
          break label747;
        }
      }
      label747:
      for (paramView = ((ak)h.ag(ak.class)).genContextId(2, 2, 65);; paramView = ((ak)h.ag(ak.class)).genContextId(2, 3, 65))
      {
        localObject2 = new Intent();
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl;
        paramca = (ca)localObject1;
        if (localObject1 == null) {
          paramca = "";
        }
        ((Intent)localObject2).putExtra("key_enter_live_param_share_username", paramca);
        ((Intent)localObject2).putExtra("key_enter_live_param_from_share_scene", 0);
        ((Intent)localObject2).putExtra("key_enter_live_param_visitor_enter_scene", 1);
        localObject4 = (com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class);
        localObject5 = (Context)parama.getContext();
        paramca = ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.username;
        parama = paramca;
        if (paramca == null) {
          parama = "";
        }
        localObject1 = ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.objectNonceId;
        paramca = (ca)localObject1;
        if (localObject1 == null) {
          paramca = "";
        }
        localObject1 = ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.desc;
        p.j(paramView, "contextId");
        localObject3 = h.ag(ak.class);
        p.j(localObject3, "MMKernel.plugin(IPluginFinder::class.java)");
        localObject3 = ((ak)localObject3).getFinderUtilApi();
        p.j(localObject3, "MMKernel.plugin(IPluginF…class.java).finderUtilApi");
        ((com.tencent.c.a.a.a.b)localObject4).enterFinderLiveVisitorUI((Intent)localObject2, (Context)localObject5, l2, Long.valueOf(l3), parama, paramca, (String)localObject1, paramView, "", "", 0, "", 1, ((ag)localObject3).eeK());
        break;
        l1 = s.r.yGD.status;
        break label407;
      }
    }
    
    public final boolean hTD()
    {
      return false;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(ChatingItemAppMsgFinderLiveFeed.a parama, ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, com.tencent.mm.plugin.findersdk.a.b paramb, com.tencent.mm.ui.chatting.e.a parama1)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$ChattingItemAppMsgFinderLiveFeedTo;", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$IChattingItemAppMsgFinderLiveFeed;", "Lcom/tencent/mm/ui/chatting/ChattingListEventListener$StateBtnClickListener;", "()V", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "checkLiveStatus", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "filling", "tag", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem$BaseViewHolder;", "position", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "userName", "", "inflating", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "convertView", "isSender", "", "onContextItemSelected", "item", "Landroid/view/MenuItem;", "onCreateContextMenu", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onItemClick", "onStateBtnClick", "retransmit", "context", "Landroid/app/Activity;", "support", "msgType", "Companion", "app_release"})
  public static class b
    extends c
    implements t.n
  {
    public static final ChatingItemAppMsgFinderLiveFeed.b.a Xce;
    private com.tencent.mm.ui.chatting.e.a WBq;
    
    static
    {
      AppMethodBeat.i(270612);
      Xce = new ChatingItemAppMsgFinderLiveFeed.b.a((byte)0);
      AppMethodBeat.o(270612);
    }
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(270602);
      p.k(paramLayoutInflater, "inflater");
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() != 0) {
          break label88;
        }
      }
      label88:
      for (int i = R.i.edR;; i = R.i.edS)
      {
        localView = (View)new aq(paramLayoutInflater, i);
        localView.setTag(new ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder().createAppMsgFinderFeedHolder(localView, true));
        AppMethodBeat.o(270602);
        return localView;
      }
    }
    
    public void a(Activity paramActivity, ca paramca)
    {
      AppMethodBeat.i(270610);
      p.k(paramActivity, "context");
      p.k(paramca, "msg");
      ChatingItemAppMsgFinderLiveFeed.c localc = ChatingItemAppMsgFinderLiveFeed.XbY;
      ChatingItemAppMsgFinderLiveFeed.c.a(paramActivity, paramca);
      AppMethodBeat.o(270610);
    }
    
    public void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bcp parambcp, com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(270611);
      p.k(paramAppMsgFinderLiveFeedHolder, "holder");
      p.k(parambcp, "shareObject");
      p.k(parama, "ui");
      ChatingItemAppMsgFinderLiveFeed.c localc = ChatingItemAppMsgFinderLiveFeed.XbY;
      ChatingItemAppMsgFinderLiveFeed.c.a(paramAppMsgFinderLiveFeedHolder, parambcp, parama);
      AppMethodBeat.o(270611);
    }
    
    public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(270605);
      p.k(parama, "tag");
      p.k(parama1, "ui");
      p.k(paramca, "msg");
      p.k(paramString, "userName");
      this.WBq = parama1;
      final ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder localAppMsgFinderLiveFeedHolder = (ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder)parama;
      parama = localAppMsgFinderLiveFeedHolder.getDetailLayout();
      if (parama == null) {
        p.iCn();
      }
      parama.animate().cancel();
      parama = localAppMsgFinderLiveFeedHolder.getDetailLayout();
      if (parama == null) {
        p.iCn();
      }
      parama.setTag(Long.valueOf(System.currentTimeMillis()));
      paramString = paramca.getContent();
      parama = null;
      if (paramString != null) {
        parama = k.b.aG(paramString, paramca.apL());
      }
      final bcp localbcp;
      Object localObject;
      int i;
      if (parama != null)
      {
        localbcp = ((com.tencent.mm.plugin.findersdk.a.b)parama.ar(com.tencent.mm.plugin.findersdk.a.b.class)).Bvb;
        if (localbcp != null)
        {
          parama = com.tencent.mm.plugin.finder.loader.t.ztT;
          parama = com.tencent.mm.plugin.finder.loader.t.dJh();
          paramString = new com.tencent.mm.plugin.finder.loader.x(localbcp.headUrl, u.Alz);
          localObject = localAppMsgFinderLiveFeedHolder.getFinderAvatar();
          if (localObject == null) {
            p.iCn();
          }
          com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
          parama.a(paramString, (ImageView)localObject, com.tencent.mm.plugin.finder.loader.t.a(t.a.zua));
          parama = localAppMsgFinderLiveFeedHolder.getFinderNickname();
          if (parama == null) {
            p.iCn();
          }
          parama.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)parama1.getContext(), (CharSequence)localbcp.nickName));
          parama = localAppMsgFinderLiveFeedHolder.getFinderNickname();
          if (parama == null) {
            p.iCn();
          }
          ar.a((Paint)parama.getPaint(), 0.8F);
          if (localbcp.liveStatus != 1) {
            break label810;
          }
          parama = (CharSequence)localbcp.coverUrl;
          if ((parama == null) || (parama.length() == 0))
          {
            i = 1;
            if (i != 0) {
              break label758;
            }
            parama = localbcp.coverUrl;
            label301:
            paramString = localAppMsgFinderLiveFeedHolder.getLiveTag();
            if (paramString != null) {
              paramString.setVisibility(0);
            }
            paramString = localAppMsgFinderLiveFeedHolder.getLiveEndTag();
            if (paramString != null) {
              paramString.setVisibility(8);
            }
            paramString = localAppMsgFinderLiveFeedHolder.getLiveTag();
            if (paramString != null)
            {
              localObject = parama1.getContext();
              p.j(localObject, "ui.context");
              localObject = ((Activity)localObject).getResources().getString(R.l.finder_live_share_onlive_status);
              p.j(localObject, "ui.context.resources.get…live_share_onlive_status)");
              paramString.setText((String)localObject);
            }
            ((ak)h.ag(ak.class)).loadImage(parama, localAppMsgFinderLiveFeedHolder.getFinderThumb());
            com.tencent.mm.ae.d.a(200L, (kotlin.g.a.a)new b(this, localAppMsgFinderLiveFeedHolder, localbcp, parama1));
            label434:
            parama = ChatingItemAppMsgFinderLiveFeed.XbY;
            ChatingItemAppMsgFinderLiveFeed.c.a(localAppMsgFinderLiveFeedHolder);
            parama = localAppMsgFinderLiveFeedHolder.getFinderThumb();
            if (parama == null) {
              p.iCn();
            }
            parama.setVisibility(0);
            parama = (CharSequence)localbcp.desc;
            if ((parama != null) && (parama.length() != 0)) {
              break label1061;
            }
            i = 1;
            label486:
            if (i == 0) {
              break label1067;
            }
            parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
            if (parama == null) {
              p.iCn();
            }
            parama.setVisibility(8);
          }
        }
        else
        {
          label510:
          localAppMsgFinderLiveFeedHolder.clickArea.setOnClickListener((View.OnClickListener)d(parama1));
          localAppMsgFinderLiveFeedHolder.clickArea.setOnLongClickListener((View.OnLongClickListener)c(parama1));
          parama = localAppMsgFinderLiveFeedHolder.clickArea;
          paramString = parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class);
          p.j(paramString, "ui.component(IChattingLi…terComponent::class.java)");
          parama.setOnTouchListener((View.OnTouchListener)((com.tencent.mm.ui.chatting.d.b.k)paramString).hNO());
          parama = this.WBq;
          if (parama == null) {
            p.iCn();
          }
          parama = new by(paramca, parama.hRi(), paramInt, null, '\000');
          paramString = localAppMsgFinderLiveFeedHolder.clickArea;
          p.j(paramString, "holder.clickArea");
          paramString.setTag(parama);
        }
      }
      else
      {
        if (!c.hTG()) {
          break label1143;
        }
        if (localAppMsgFinderLiveFeedHolder.uploadingPB != null)
        {
          parama = localAppMsgFinderLiveFeedHolder.uploadingPB;
          p.j(parama, "holder.uploadingPB");
          parama.setVisibility(8);
        }
        if ((paramca.getStatus() != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class), paramca.apG()))) {
          break label1113;
        }
        if (localAppMsgFinderLiveFeedHolder.getTickIV() != null)
        {
          parama = localAppMsgFinderLiveFeedHolder.getTickIV();
          if (parama == null) {
            p.iCn();
          }
          parama.setVisibility(0);
        }
      }
      for (;;)
      {
        a(paramInt, (c.a)localAppMsgFinderLiveFeedHolder, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, (t.n)this);
        AppMethodBeat.o(270605);
        return;
        i = 0;
        break;
        label758:
        parama = (CharSequence)localbcp.headUrl;
        if ((parama == null) || (parama.length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label803;
          }
          parama = localbcp.headUrl;
          break;
        }
        label803:
        parama = "";
        break label301;
        label810:
        if (localbcp.liveStatus != 2) {
          break label434;
        }
        parama = "";
        paramString = (CharSequence)localbcp.coverUrl;
        if ((paramString == null) || (paramString.length() == 0))
        {
          i = 1;
          label851:
          if (i != 0) {
            break label1000;
          }
          paramString = localbcp.coverUrl;
          parama = paramString;
          if (paramString == null) {
            parama = "";
          }
        }
        label1059:
        for (;;)
        {
          paramString = localAppMsgFinderLiveFeedHolder.getLiveTag();
          if (paramString != null) {
            paramString.setVisibility(8);
          }
          paramString = localAppMsgFinderLiveFeedHolder.getLiveEndTag();
          if (paramString != null) {
            paramString.setVisibility(0);
          }
          paramString = localAppMsgFinderLiveFeedHolder.getLiveTag();
          if (paramString != null)
          {
            localObject = parama1.getContext();
            p.j(localObject, "ui.context");
            localObject = ((Activity)localObject).getResources().getString(R.l.finder_live_share_onlive_status);
            p.j(localObject, "ui.context.resources.get…live_share_onlive_status)");
            paramString.setText((String)localObject);
          }
          ((ak)h.ag(ak.class)).getFinderUtilApi().f(localAppMsgFinderLiveFeedHolder.getFinderThumb(), parama);
          break;
          i = 0;
          break label851;
          label1000:
          paramString = (CharSequence)localbcp.headUrl;
          if ((paramString == null) || (paramString.length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label1059;
            }
            paramString = localbcp.headUrl;
            parama = paramString;
            if (paramString == null) {
              parama = "";
            }
            break;
          }
        }
        label1061:
        i = 0;
        break label486;
        label1067:
        parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
        if (parama == null) {
          p.iCn();
        }
        parama.setVisibility(0);
        parama = localAppMsgFinderLiveFeedHolder.getFinderDesc();
        if (parama == null) {
          p.iCn();
        }
        parama.setText((CharSequence)localbcp.desc);
        break label510;
        label1113:
        if (localAppMsgFinderLiveFeedHolder.getTickIV() != null)
        {
          parama = localAppMsgFinderLiveFeedHolder.getTickIV();
          if (parama == null) {
            p.iCn();
          }
          parama.setVisibility(8);
        }
      }
      label1143:
      if (localAppMsgFinderLiveFeedHolder.getTickIV() != null)
      {
        parama = localAppMsgFinderLiveFeedHolder.getTickIV();
        if (parama == null) {
          p.iCn();
        }
        parama.setVisibility(8);
      }
      parama = (c.a)localAppMsgFinderLiveFeedHolder;
      if (paramca.getStatus() < 2) {}
      for (boolean bool = true;; bool = false)
      {
        b(parama, bool);
        break;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(270608);
      p.k(paramMenuItem, "item");
      p.k(parama, "ui");
      p.k(paramca, "msg");
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(270608);
        return false;
      }
      paramMenuItem = parama.getContext();
      p.j(paramMenuItem, "ui.context");
      a(paramMenuItem, paramca);
      AppMethodBeat.o(270608);
      return true;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(270607);
      p.k(paramo, "menu");
      p.k(paramView, "v");
      Object localObject = paramView.getTag();
      if (localObject == null)
      {
        paramo = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.chatting.viewitems.ItemDataTag");
        AppMethodBeat.o(270607);
        throw paramo;
      }
      int i = ((by)localObject).position;
      if (paramca != null)
      {
        localObject = this.WBq;
        if (localObject == null) {
          p.iCn();
        }
        paramo.a(i, 111, (CharSequence)((com.tencent.mm.ui.chatting.e.a)localObject).getResources().getString(R.l.retransmit), R.k.icons_filled_share);
        paramo.removeItem(116);
        if (((paramca.getStatus() == 2) || (paramca.apO() == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.apJ())))
        {
          paramca = this.WBq;
          if (paramca == null) {
            p.iCn();
          }
          if (!paramca.hRk()) {
            paramo.a(i, 123, (CharSequence)paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
          }
        }
      }
      AppMethodBeat.o(270607);
      return true;
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(270606);
      p.k(paramView, "v");
      p.k(parama, "ui");
      p.k(paramca, "msg");
      if (paramca.erk())
      {
        m.bh(paramca);
        bq.Gk(paramca.apG());
        parama.Gi(true);
      }
      AppMethodBeat.o(270606);
    }
    
    public boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 973078577);
    }
    
    public boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(270609);
      p.k(paramView, "v");
      p.k(parama, "ui");
      p.k(paramca, "msg");
      Object localObject1 = paramca.getContent();
      paramView = null;
      if (localObject1 != null) {
        paramView = k.b.aG((String)localObject1, paramca.apL());
      }
      Object localObject3;
      long l2;
      long l3;
      if (paramView != null)
      {
        localObject3 = (com.tencent.mm.plugin.findersdk.a.b)paramView.ar(com.tencent.mm.plugin.findersdk.a.b.class);
        if (localObject3 != null)
        {
          l2 = com.tencent.mm.ae.d.Nb(((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.feedId);
          l3 = com.tencent.mm.ae.d.Nb(((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.kwM);
          if (l2 != 0L)
          {
            paramView = com.tencent.c.a.a.a.a.a.Zlt;
            if (!((Boolean)com.tencent.c.a.a.a.a.a.imm().aSr()).booleanValue()) {
              break label180;
            }
            paramView = new Intent();
            paramView.putExtra("feed_object_id", l2);
            paramView.putExtra("feed_object_nonceId", ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.objectNonceId);
            ((ak)h.ag(ak.class)).enterFinderShareFeedUI(MMApplicationContext.getContext(), paramView);
          }
        }
      }
      label180:
      Object localObject2;
      for (;;)
      {
        AppMethodBeat.o(270609);
        return false;
        paramca = a(parama, paramca);
        paramView = paramca;
        if (paramca == null)
        {
          paramView = parama.getTalker();
          p.j(paramView, "ui.talker");
          paramView = paramView.getUsername();
        }
        paramca = paramView;
        if (paramView == null) {
          paramca = "";
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl = paramca;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm = com.tencent.mm.plugin.expt.hellhound.core.b.Fw(parama.getTalker().jxt);
        if (!Util.isEqual(((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.username, z.bdh())) {
          break;
        }
        paramca = new Intent();
        paramca.putExtra("KEY_PARAMS_SOURCE_TYPE", ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.sourceType);
        localObject1 = (com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class);
        localObject2 = MMApplicationContext.getContext();
        parama = ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.objectNonceId;
        paramView = parama;
        if (parama == null) {
          paramView = "";
        }
        ((com.tencent.c.a.a.a.b)localObject1).enterFinderLiveAnchorUI(paramca, (Context)localObject2, l2, Long.valueOf(l3), paramView, ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.desc, "", "", "");
      }
      paramView = com.tencent.mm.plugin.finder.live.report.k.yBj;
      paramca = ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.username;
      paramView = paramca;
      if (paramca == null) {
        paramView = "";
      }
      Object localObject4 = s.t.yGS;
      Object localObject5 = s.l.yFU.scene;
      long l1;
      if (((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.liveStatus == 1)
      {
        l1 = s.r.yGC.status;
        label407:
        paramca = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        long l4 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.deb();
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl;
        paramca = (ca)localObject1;
        if (localObject1 == null) {
          paramca = "";
        }
        localObject2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        com.tencent.mm.plugin.finder.live.report.k.b(new com.tencent.mm.plugin.finder.live.report.q(l2, l3, paramView, 0L, -1L, (s.t)localObject4, (String)localObject5, l1, l4, paramca, (String)localObject1, System.currentTimeMillis(), s.bj.yMa, null, null, null, null, 122880));
        if (parama.hRh()) {
          break label747;
        }
      }
      label747:
      for (paramView = ((ak)h.ag(ak.class)).genContextId(2, 2, 65);; paramView = ((ak)h.ag(ak.class)).genContextId(2, 3, 65))
      {
        localObject2 = new Intent();
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl;
        paramca = (ca)localObject1;
        if (localObject1 == null) {
          paramca = "";
        }
        ((Intent)localObject2).putExtra("key_enter_live_param_share_username", paramca);
        ((Intent)localObject2).putExtra("key_enter_live_param_from_share_scene", 0);
        ((Intent)localObject2).putExtra("key_enter_live_param_visitor_enter_scene", 1);
        localObject4 = (com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class);
        localObject5 = (Context)parama.getContext();
        paramca = ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.username;
        parama = paramca;
        if (paramca == null) {
          parama = "";
        }
        localObject1 = ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.objectNonceId;
        paramca = (ca)localObject1;
        if (localObject1 == null) {
          paramca = "";
        }
        localObject1 = ((com.tencent.mm.plugin.findersdk.a.b)localObject3).Bvb.desc;
        p.j(paramView, "contextId");
        localObject3 = h.ag(ak.class);
        p.j(localObject3, "MMKernel.plugin(IPluginFinder::class.java)");
        localObject3 = ((ak)localObject3).getFinderUtilApi();
        p.j(localObject3, "MMKernel.plugin(IPluginF…class.java).finderUtilApi");
        ((com.tencent.c.a.a.a.b)localObject4).enterFinderLiveVisitorUI((Intent)localObject2, (Context)localObject5, l2, Long.valueOf(l3), parama, paramca, (String)localObject1, paramView, "", "", 0, "", 1, ((ag)localObject3).eeK());
        break;
        l1 = s.r.yGD.status;
        break label407;
      }
    }
    
    public final boolean hTD()
    {
      return true;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      b(ChatingItemAppMsgFinderLiveFeed.b paramb, ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bcp parambcp, com.tencent.mm.ui.chatting.e.a parama)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "adjustMediaHeight", "", "holder", "Lcom/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$AppMsgFinderLiveFeedHolder;", "width", "", "height", "checkLiveStatus", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "ui", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "retransmit", "context", "Landroid/app/Activity;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "app_release"})
  public static final class c
  {
    public static void a(Activity paramActivity, ca paramca)
    {
      AppMethodBeat.i(221595);
      p.k(paramActivity, "context");
      p.k(paramca, "msg");
      if (!Util.isNullOrNil(paramca.getContent()))
      {
        paramca = k.b.OQ(paramca.getContent());
        if (paramca != null)
        {
          Intent localIntent = new Intent((Context)paramActivity, MsgRetransmitUI.class);
          localIntent.putExtra("Retr_Msg_Type", 23);
          localIntent.putExtra("Multi_Retr", true);
          localIntent.putExtra("Retr_Msg_content", k.b.a(paramca, null, null));
          localIntent.putExtra("Retr_go_to_chattingUI", false);
          localIntent.putExtra("Retr_show_success_tips", true);
          paramca = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
          com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramca.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramActivity.startActivity((Intent)paramca.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion", "retransmit", "(Landroid/app/Activity;Lcom/tencent/mm/storage/MsgInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
      AppMethodBeat.o(221595);
    }
    
    public static void a(ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder)
    {
      AppMethodBeat.i(221593);
      p.k(paramAppMsgFinderLiveFeedHolder, "holder");
      Object localObject = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() == 0)
      {
        i = (int)(paramAppMsgFinderLiveFeedHolder.getWidth() * 1.333333373069763D);
        localObject = paramAppMsgFinderLiveFeedHolder.getFinderThumb();
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((ImageView)localObject).getLayoutParams();
        if (localObject == null)
        {
          paramAppMsgFinderLiveFeedHolder = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(221593);
          throw paramAppMsgFinderLiveFeedHolder;
        }
        localObject = (FrameLayout.LayoutParams)localObject;
        ((FrameLayout.LayoutParams)localObject).height = i;
        paramAppMsgFinderLiveFeedHolder = paramAppMsgFinderLiveFeedHolder.getFinderThumb();
        if (paramAppMsgFinderLiveFeedHolder == null) {
          p.iCn();
        }
        paramAppMsgFinderLiveFeedHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(221593);
        return;
      }
      int i = paramAppMsgFinderLiveFeedHolder.getWidth();
      localObject = paramAppMsgFinderLiveFeedHolder.getFinderThumb();
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((ImageView)localObject).getLayoutParams();
      if (localObject == null)
      {
        paramAppMsgFinderLiveFeedHolder = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(221593);
        throw paramAppMsgFinderLiveFeedHolder;
      }
      localObject = (FrameLayout.LayoutParams)localObject;
      ((FrameLayout.LayoutParams)localObject).height = i;
      paramAppMsgFinderLiveFeedHolder = paramAppMsgFinderLiveFeedHolder.getFinderThumb();
      if (paramAppMsgFinderLiveFeedHolder == null) {
        p.iCn();
      }
      paramAppMsgFinderLiveFeedHolder.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(221593);
    }
    
    public static void a(final ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder, bcp parambcp, com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(221598);
      p.k(paramAppMsgFinderLiveFeedHolder, "holder");
      p.k(parambcp, "shareObject");
      p.k(parama, "ui");
      Object localObject = parambcp.kwM;
      if (localObject != null)
      {
        localObject = n.bHD((String)localObject);
        if (localObject == null) {}
      }
      for (long l = ((Long)localObject).longValue();; l = 0L)
      {
        parambcp = new a(l, parambcp, paramAppMsgFinderLiveFeedHolder);
        if (!(parama.getContext() instanceof MMFragmentActivity)) {
          break label137;
        }
        paramAppMsgFinderLiveFeedHolder = parama.getContext();
        if (paramAppMsgFinderLiveFeedHolder != null) {
          break;
        }
        paramAppMsgFinderLiveFeedHolder = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
        AppMethodBeat.o(221598);
        throw paramAppMsgFinderLiveFeedHolder;
      }
      label137:
      for (paramAppMsgFinderLiveFeedHolder = (MMFragmentActivity)paramAppMsgFinderLiveFeedHolder;; paramAppMsgFinderLiveFeedHolder = null)
      {
        ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).refreshLiveStatus(l, (com.tencent.mm.vending.e.b)paramAppMsgFinderLiveFeedHolder, (b.d)parambcp);
        AppMethodBeat.o(221598);
        return;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/viewitems/ChatingItemAppMsgFinderLiveFeed$Companion$checkLiveStatus$statusCallBack$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "status", "", "liveInfo", "", "app_release"})
    public static final class a
      implements b.d
    {
      a(long paramLong, bcp parambcp, ChatingItemAppMsgFinderLiveFeed.AppMsgFinderLiveFeedHolder paramAppMsgFinderLiveFeedHolder) {}
      
      public final void a(long paramLong, int paramInt, Object paramObject)
      {
        AppMethodBeat.i(278486);
        paramObject = ChatingItemAppMsgFinderLiveFeed.XbY;
        Log.i(ChatingItemAppMsgFinderLiveFeed.access$getTAG$cp(), "[checkLiveStatus] thisLiveId:" + this.LmD + ",liveID:" + paramLong + ",desc:" + paramAppMsgFinderLiveFeedHolder.desc + ",share status:" + paramAppMsgFinderLiveFeedHolder.liveStatus + ",callback liveStatus:" + paramInt);
        if (this.LmD == paramLong)
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
            FinderLiveOnliveWidget localFinderLiveOnliveWidget = this.Xcb.getLiveTag();
            if (localFinderLiveOnliveWidget != null) {
              localFinderLiveOnliveWidget.setVisibility(8);
            }
            localFinderLiveOnliveWidget = this.Xcb.getLiveEndTag();
            if (localFinderLiveOnliveWidget != null) {
              localFinderLiveOnliveWidget.setVisibility(0);
            }
            ((ak)h.ag(ak.class)).getFinderUtilApi().f(this.Xcb.getFinderThumb(), paramObject);
            AppMethodBeat.o(278486);
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
        AppMethodBeat.o(278486);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ChatingItemAppMsgFinderLiveFeed
 * JD-Core Version:    0.7.0.1
 */