package com.tencent.mm.plugin.sns.ui.listener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aaw;
import com.tencent.mm.autogen.a.aax;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.autogen.a.kj;
import com.tencent.mm.autogen.a.ul;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.comm.b.e.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.bi;
import com.tencent.mm.plugin.findersdk.a.bi.a;
import com.tencent.mm.plugin.findersdk.a.bi.b;
import com.tencent.mm.plugin.findersdk.a.bi.c;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.g.p.a;
import com.tencent.mm.plugin.sns.ad.timeline.b.b.a.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.av.b;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.statistics.h.a;
import com.tencent.mm.plugin.sns.statistics.j.a;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.e;
import com.tencent.mm.plugin.sns.storage.ADXml.f;
import com.tencent.mm.plugin.sns.storage.ADXml.h;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.bj;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bn.b;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.f.a;
import com.tencent.mm.plugin.sns.ui.item.n.a;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.fdv;
import com.tencent.mm.protocal.protobuf.feb;
import com.tencent.mm.protocal.protobuf.fef;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.protocal.protobuf.fez;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class c
{
  public View.OnTouchListener DIP;
  private com.tencent.mm.plugin.sns.ad.timeline.a.a.c QaL;
  public SightPlayController.d RNF;
  private volatile com.tencent.mm.plugin.sns.ui.b.b.b RPQ;
  private volatile com.tencent.mm.plugin.sns.ui.b.b.a RPR;
  private volatile com.tencent.mm.plugin.sns.ui.b.a.b RPS;
  private volatile com.tencent.mm.plugin.sns.ui.b.a.a RPT;
  public b RPU;
  public View.OnClickListener RPV;
  public View.OnLongClickListener RPW;
  public d RPX;
  public View.OnClickListener RPY;
  public View.OnClickListener RPZ;
  public View.OnClickListener RQA;
  public View.OnClickListener RQB;
  public AdapterView.OnItemClickListener RQC;
  public AdapterView.OnItemClickListener RQD;
  public View.OnClickListener RQE = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100199);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      if (paramAnonymousView.getTag() == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100199);
        return;
      }
      localObject1 = c.jP(paramAnonymousView);
      if ((localObject1 == null) || (!((SnsInfo)localObject1).isAd()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100199);
        return;
      }
      int j;
      int i;
      Object localObject2;
      label175:
      int k;
      if (((SnsInfo)localObject1).getAdSnsInfo().getAdXml().hasVoteInfo())
      {
        j = com.tencent.mm.plugin.sns.storage.ai.mS(((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl(), ((SnsInfo)localObject1).getUxinfo());
        if (j > 0)
        {
          i = 1;
          localObject2 = ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl();
          String str1 = ((SnsInfo)localObject1).getUxinfo();
          com.tencent.mm.kernel.h.baC();
          String str2 = com.tencent.mm.kernel.b.aZs();
          if (i == 0) {
            break label281;
          }
          if (i == 0) {
            break label286;
          }
          k = 0;
          label182:
          com.tencent.mm.plugin.sns.storage.ai.b((String)localObject2, str1, str2, j, k, "");
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject2 = ((SnsInfo)localObject1).getTimeLine();
        if ((((TimeLineObject)localObject2).ContentObj.Zpq == 15) && (((TimeLineObject)localObject2).sightFolded != 1)) {
          c.a(c.this, paramAnonymousView, (SnsInfo)localObject1, 1001, ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getLeftCanvasInfo(), bool);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100199);
          return;
          i = 0;
          break;
          label281:
          j = 1;
          break label175;
          label286:
          k = 1;
          break label182;
          if (((((TimeLineObject)localObject2).ContentObj.Zpq == 1) && (((TimeLineObject)localObject2).ContentObj.Zpr.size() == 1)) || (((TimeLineObject)localObject2).ContentObj.Zpq == 7)) {
            c.b(c.this, paramAnonymousView, (SnsInfo)localObject1, 1001, ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getLeftCanvasInfo(), bool);
          }
        }
      }
    }
  };
  public View.OnClickListener RQF = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100219);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      if (paramAnonymousView.getTag() == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100219);
        return;
      }
      localObject1 = c.jP(paramAnonymousView);
      if ((localObject1 == null) || (!((SnsInfo)localObject1).isAd()))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100219);
        return;
      }
      int j;
      int i;
      Object localObject2;
      label175:
      int k;
      if (((SnsInfo)localObject1).getAdSnsInfo().getAdXml().hasVoteInfo())
      {
        j = com.tencent.mm.plugin.sns.storage.ai.mS(((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl(), ((SnsInfo)localObject1).getUxinfo());
        if (j > 0)
        {
          i = 1;
          localObject2 = ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl();
          String str1 = ((SnsInfo)localObject1).getUxinfo();
          com.tencent.mm.kernel.h.baC();
          String str2 = com.tencent.mm.kernel.b.aZs();
          if (i == 0) {
            break label281;
          }
          if (i == 0) {
            break label286;
          }
          k = 0;
          label182:
          com.tencent.mm.plugin.sns.storage.ai.b((String)localObject2, str1, str2, j, k, "");
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject2 = ((SnsInfo)localObject1).getTimeLine();
        if ((((TimeLineObject)localObject2).ContentObj.Zpq == 15) && (((TimeLineObject)localObject2).sightFolded != 1)) {
          c.a(c.this, paramAnonymousView, (SnsInfo)localObject1, 1002, ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getRightCanvasInfo(), bool);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100219);
          return;
          i = 0;
          break;
          label281:
          j = 2;
          break label175;
          label286:
          k = 1;
          break label182;
          if (((((TimeLineObject)localObject2).ContentObj.Zpq == 1) && (((TimeLineObject)localObject2).ContentObj.Zpr.size() == 1)) || (((TimeLineObject)localObject2).ContentObj.Zpq == 7)) {
            c.b(c.this, paramAnonymousView, (SnsInfo)localObject1, 1002, ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getRightCanvasInfo(), bool);
          }
        }
      }
    }
  };
  public View.OnClickListener RQG;
  public bn.b RQH;
  private int RQI;
  private IListener<aax> RQJ = new TimelineClickListener.3(this, com.tencent.mm.app.f.hfK);
  private IListener<aaw> RQK = new TimelineClickListener.4(this, com.tencent.mm.app.f.hfK);
  public View.OnClickListener RQL = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(308534);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      localObject1 = paramAnonymousView.getTag();
      Object localObject3 = null;
      Object localObject2;
      if ((localObject1 instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        localObject1 = com.tencent.mm.plugin.sns.storage.l.aZK(((BaseTimeLineItem.BaseViewHolder)localObject2).hQX);
        localObject3 = ((BaseTimeLineItem.BaseViewHolder)localObject2).RKJ;
        localObject2 = null;
      }
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        int i;
        if (localObject1 != null)
        {
          localObject4 = ((SnsInfo)localObject1).getAdSnsInfo();
          if ((localObject1 != null) && (((SnsInfo)localObject1).isAd()))
          {
            localObject5 = c.a(c.this, (SnsInfo)localObject1);
            if ((((SnsInfo)localObject1).getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(((SnsInfo)localObject1).getAdSnsInfo().field_adxml)))
            {
              localObject5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.T((SnsInfo)localObject1);
              if (!Util.isNullOrNil((String)localObject5)) {
                ((AdSnsInfo)localObject4).field_adxml = ((String)localObject5);
              }
              localObject4 = new int[2];
              paramAnonymousView.getLocationInWindow((int[])localObject4);
              i = paramAnonymousView.getWidth();
              j = paramAnonymousView.getHeight();
              if (localObject3 != null)
              {
                ((TagImageView)localObject3).getLocationInWindow((int[])localObject4);
                i = ((TagImageView)localObject3).getWidth();
                j = ((TagImageView)localObject3).getHeight();
                label211:
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
                paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
                paramAnonymousView.putExtra("img_gallery_width", i);
                paramAnonymousView.putExtra("img_gallery_height", j);
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", ((SnsInfo)localObject1).getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", ((SnsInfo)localObject1).getTimeLine().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", ((SnsInfo)localObject1).getUxinfo());
                localObject2 = ((SnsInfo)localObject1).getTimeLine();
                if (localObject2 != null)
                {
                  localObject2 = ((TimeLineObject)localObject2).ContentObj.Zpr;
                  if (((List)localObject2).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((dmz)((List)localObject2).get(0)).aaTl);
                  }
                }
                paramAnonymousView.setClass(c.f(c.this), SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (c.j(c.this) != 2) {
                  break label652;
                }
                i = 16;
                label380:
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", ((SnsInfo)localObject1).getAdSnsInfo().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", ((SnsInfo)localObject1).getAdRecSrc());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                paramAnonymousView.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
                localObject2 = c.f(c.this);
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramAnonymousView.aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject2).startActivity((Intent)paramAnonymousView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.f(c.this).overridePendingTransition(0, 0);
                j = c.j(c.this);
                if (c.j(c.this) != 0) {
                  break label669;
                }
              }
              label652:
              label669:
              for (i = 1;; i = 2)
              {
                t.a(new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 23, 21));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(308534);
                return;
                if (!(localObject1 instanceof SnsInfo)) {
                  break label1354;
                }
                localObject1 = (SnsInfo)localObject1;
                localObject2 = (MMImageView)paramAnonymousView.getTag(b.f.link_ad_left_iv);
                break;
                if (localObject2 == null) {
                  break label211;
                }
                ((MMImageView)localObject2).getLocationInWindow((int[])localObject4);
                i = ((MMImageView)localObject2).getWidth();
                j = ((MMImageView)localObject2).getHeight();
                break label211;
                if (c.j(c.this) != 1) {
                  break label380;
                }
                i = 10;
                break label380;
              }
            }
            if ((localObject5 != null) && (((ADInfo)localObject5).adActionType == 1))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_id", ((ADInfo)localObject5).adActionCardTpId);
              paramAnonymousView.putExtra("key_card_ext", ((ADInfo)localObject5).adActionCardExt);
              paramAnonymousView.putExtra("key_from_scene", 21);
              paramAnonymousView.putExtra("key_stastic_scene", 15);
              com.tencent.mm.br.c.b(c.f(c.this), "card", ".ui.CardDetailUI", paramAnonymousView);
              j = c.j(c.this);
              if (c.j(c.this) == 0) {}
              for (i = 1;; i = 2)
              {
                t.a(new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 23, 11));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(308534);
                return;
              }
            }
            if (c.a(c.this, (ADInfo)localObject5, (SnsInfo)localObject1, false))
            {
              j = c.j(c.this);
              if (c.j(c.this) == 0) {}
              for (i = 1;; i = 2)
              {
                t.a(new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 23, 31));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(308534);
                return;
              }
            }
          }
          int j = c.j(c.this);
          if (c.j(c.this) != 0) {
            break label1343;
          }
          i = 1;
          localObject3 = new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 23, 0);
          t.a((SnsAdClick)localObject3);
          localObject2 = ((SnsInfo)localObject1).getAdInfoLink();
          paramAnonymousView = (View)localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            paramAnonymousView = ((SnsInfo)localObject1).getAdLink();
          }
          Log.i("MicroMsg.TimelineClickListener", "linkAdClick, adlink url " + paramAnonymousView + " " + ((SnsInfo)localObject1).getAdXml().webrightBar);
          localObject5 = new Intent();
          if (((SnsInfo)localObject1).getAdXml().webrightBar != 0) {
            break label1348;
          }
        }
        label1343:
        label1348:
        for (boolean bool = true;; bool = false)
        {
          if (com.tencent.mm.platformtools.z.pCv) {
            bool = false;
          }
          localObject2 = paramAnonymousView;
          if (localObject1 != null)
          {
            localObject2 = paramAnonymousView;
            if (((SnsInfo)localObject1).isAd())
            {
              ADInfo localADInfo = c.a(c.this, (SnsInfo)localObject1);
              localObject2 = paramAnonymousView;
              if (localADInfo != null)
              {
                ((Intent)localObject5).putExtra("KsnsViewId", localADInfo.viewId);
                localObject2 = t.lY(paramAnonymousView, localADInfo.uxInfo);
                t.i((Intent)localObject5, localADInfo.uxInfo);
              }
            }
          }
          ((Intent)localObject5).putExtra("KRightBtn", bool);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject3);
          paramAnonymousView.putString("key_snsad_statextstr", ((AdSnsInfo)localObject4).getTimeLine().statExtStr);
          ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
          ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
          ((Intent)localObject5).putExtra("useJs", true);
          ((Intent)localObject5).putExtra("srcUsername", ((SnsInfo)localObject1).field_userName);
          ((Intent)localObject5).putExtra("stastic_scene", 15);
          ((Intent)localObject5).putExtra("KPublisherId", "sns_" + t.uA(((SnsInfo)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("pre_username", ((SnsInfo)localObject1).field_userName);
          ((Intent)localObject5).putExtra("prePublishId", "sns_" + t.uA(((SnsInfo)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("preUsername", ((SnsInfo)localObject1).field_userName);
          com.tencent.mm.plugin.sns.d.a.pFn.h((Intent)localObject5, c.f(c.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308534);
          return;
          i = 2;
          break;
        }
        label1354:
        localObject2 = null;
        localObject1 = null;
      }
    }
  };
  public View.OnClickListener RQa;
  public View.OnClickListener RQb;
  public View.OnClickListener RQc;
  public View.OnClickListener RQd;
  public View.OnClickListener RQe;
  public View.OnClickListener RQf;
  public View.OnClickListener RQg;
  public d RQh;
  public d RQi;
  public d RQj;
  public d RQk;
  public d RQl;
  public d RQm;
  public d RQn;
  private d RQo;
  public d RQp;
  public d RQq;
  public View.OnClickListener RQr;
  public View.OnClickListener RQs;
  public View.OnClickListener RQt;
  public View.OnClickListener RQu;
  public View.OnClickListener RQv;
  public View.OnClickListener RQw;
  public View.OnClickListener RQx;
  public View.OnClickListener RQy;
  public View.OnClickListener RQz;
  private ak Rca;
  public View.OnClickListener Rea;
  protected com.tencent.mm.plugin.sns.ad.g.l RoZ;
  private Activity activity;
  private int source = 0;
  
  public c(int paramInt, Activity paramActivity, ak paramak)
  {
    this.source = paramInt;
    this.activity = paramActivity;
    this.Rca = paramak;
    this.RQI = Util.getInt(com.tencent.mm.k.i.aRC().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
    Log.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[] { Integer.valueOf(this.RQI) });
    this.RPU = new b(this.activity, this.source, this.Rca);
    this.RQf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100258);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Long)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100258);
          return;
        }
        long l = ((Long)paramAnonymousView.getTag()).longValue();
        Object localObject2 = com.tencent.mm.plugin.sns.model.al.hgE().vd(l);
        SnsInfo localSnsInfo = ((AdSnsInfo)localObject2).convertToSnsInfo();
        com.tencent.mm.plugin.sns.ad.g.p.a(com.tencent.mm.plugin.sns.ad.g.p.b.PXd, p.a.PXb, ((AdSnsInfo)localObject2).convertToSnsInfo(), c.j(c.this));
        ((AdSnsInfo)localObject2).getSource();
        localObject1 = localSnsInfo.getAdInfoLink();
        paramAnonymousView = (View)localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          paramAnonymousView = localSnsInfo.getAdLink();
        }
        Object localObject3;
        if ((localSnsInfo != null) && (localSnsInfo.isAd()))
        {
          localObject1 = c.a(c.this, localSnsInfo);
          localObject3 = com.tencent.mm.model.newabtest.d.bEu().buZ("Sns_CanvasAd_DetailLink_JumpWay");
          if ((localObject3 == null) || (!((com.tencent.mm.storage.a)localObject3).isValid())) {
            break label2405;
          }
        }
        label904:
        label1039:
        label1995:
        label2396:
        label2402:
        label2405:
        for (int i = Util.getInt(((com.tencent.mm.storage.a)localObject3).field_value, -1);; i = -1)
        {
          if (com.tencent.mm.plugin.sns.data.m.a(c.f(c.this), localSnsInfo, (ADInfo)localObject1, c.j(c.this), c.this.RoZ, 3, 0))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100258);
            return;
          }
          int j;
          if ((localObject1 != null) && (((ADInfo)localObject1).adActionType == 1))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_card_id", ((ADInfo)localObject1).adActionCardTpId);
            paramAnonymousView.putExtra("key_card_ext", ((ADInfo)localObject1).adActionCardExt);
            paramAnonymousView.putExtra("key_from_scene", 21);
            paramAnonymousView.putExtra("key_stastic_scene", 15);
            com.tencent.mm.br.c.b(c.f(c.this), "card", ".ui.CardDetailUI", paramAnonymousView);
            j = c.j(c.this);
            if (c.j(c.this) == 0) {}
            for (i = 1;; i = 2)
            {
              paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 11);
              com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.RoZ, localSnsInfo, 3);
              t.a(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100258);
              return;
            }
          }
          if ((localObject1 != null) && (i == 1))
          {
            if ((localSnsInfo.getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(localSnsInfo.getAdSnsInfo().field_adxml)))
            {
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.T(localSnsInfo);
              if (!Util.isNullOrNil(paramAnonymousView)) {
                ((AdSnsInfo)localObject2).field_adxml = paramAnonymousView;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localSnsInfo.getSnsId());
              paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localSnsInfo.getTimeLine().Id);
              paramAnonymousView.putExtra("sns_landing_pages_ux_info", localSnsInfo.getUxinfo());
              paramAnonymousView.putExtra("sns_landing_pages_aid", localSnsInfo.getAid());
              paramAnonymousView.putExtra("sns_landing_pages_traceid", localSnsInfo.getTraceid());
              localObject1 = localSnsInfo.getTimeLine();
              if (localObject1 != null)
              {
                localObject2 = ((TimeLineObject)localObject1).ContentObj.Zpr;
                if (((List)localObject2).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((dmz)((List)localObject2).get(0)).aaTl);
                }
                if (((TimeLineObject)localObject1).ContentObj.Zpq == 15) {
                  paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                }
              }
              c.a(c.this, paramAnonymousView, localSnsInfo);
              paramAnonymousView.setClass(c.f(c.this), SnsAdNativeLandingPagesUI.class);
              i = 9;
              if (c.j(c.this) == 2)
              {
                i = 16;
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", localSnsInfo.getAdSnsInfo().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", localSnsInfo.getAdRecSrc());
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                paramAnonymousView.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
                localObject1 = c.f(c.this);
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousView.aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                j = c.j(c.this);
                if (c.j(c.this) != 0) {
                  break label904;
                }
              }
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 21);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.RoZ, localSnsInfo, 3);
                t.a(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100258);
                return;
                if (c.j(c.this) != 1) {
                  break;
                }
                i = 10;
                break;
              }
            }
          }
          else if ((localObject1 != null) && (i == 0))
          {
            if ((!localSnsInfo.getAdXml().isLandingPagesAd()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(localSnsInfo.getAdSnsInfo().field_adxml))) {
              break label2402;
            }
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.T(localSnsInfo);
            if (!Util.isNullOrNil((String)localObject1)) {
              ((AdSnsInfo)localObject2).field_adxml = ((String)localObject1);
            }
            localObject1 = XmlParser.parseXml(localSnsInfo.getAdSnsInfo().field_adxml, "adxml", null);
            if (localObject1 != null)
            {
              localObject1 = Util.nullAs((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareWebUrl"), "");
              if (Util.isNullOrNil((String)localObject1)) {
                break label2402;
              }
              paramAnonymousView = (View)localObject1;
            }
          }
          for (;;)
          {
            j = c.j(c.this);
            Intent localIntent;
            if (c.j(c.this) == 0)
            {
              i = 1;
              localObject3 = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 0);
              com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject3, c.this.RoZ, localSnsInfo, 3);
              t.a((SnsAdClick)localObject3);
              Log.i("MicroMsg.TimelineClickListener", "adTagClick, adlink url " + paramAnonymousView + " " + localSnsInfo.getAdXml().webrightBar);
              localIntent = new Intent();
              if (localSnsInfo.getAdXml().webrightBar != 0) {
                break label2396;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              if (com.tencent.mm.platformtools.z.pCv) {
                bool = false;
              }
              localObject1 = paramAnonymousView;
              if (localSnsInfo != null)
              {
                localObject1 = paramAnonymousView;
                if (localSnsInfo.isAd())
                {
                  ADInfo localADInfo = c.a(c.this, localSnsInfo);
                  localObject1 = paramAnonymousView;
                  if (localADInfo != null)
                  {
                    localIntent.putExtra("KsnsViewId", localADInfo.viewId);
                    localObject1 = com.tencent.mm.plugin.sns.ad.c.a.a.aWj(t.lY(paramAnonymousView, localADInfo.uxInfo));
                    t.i(localIntent, localADInfo.uxInfo);
                  }
                }
              }
              localIntent.putExtra("KRightBtn", bool);
              paramAnonymousView = new Bundle();
              paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject3);
              paramAnonymousView.putString("key_snsad_statextstr", ((AdSnsInfo)localObject2).getTimeLine().statExtStr);
              localIntent.putExtra("jsapiargs", paramAnonymousView);
              localIntent.putExtra("rawUrl", (String)localObject1);
              localIntent.putExtra("useJs", true);
              localIntent.putExtra("srcUsername", localSnsInfo.field_userName);
              localIntent.putExtra("sns_local_id", localSnsInfo.getLocalid());
              localIntent.putExtra("stastic_scene", 15);
              localIntent.putExtra("KPublisherId", "sns_" + t.uA(localSnsInfo.field_snsId));
              localIntent.putExtra("pre_username", localSnsInfo.field_userName);
              localIntent.putExtra("prePublishId", "sns_" + t.uA(localSnsInfo.field_snsId));
              localIntent.putExtra("preUsername", localSnsInfo.field_userName);
              com.tencent.mm.plugin.sns.d.a.pFn.h(localIntent, c.f(c.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100258);
              return;
              Log.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + localSnsInfo.getAdSnsInfo().field_adxml);
              break;
              if ((localObject1 != null) && (i == -1) && (((ADInfo)localObject1).adActionType == 3))
              {
                if ((!localSnsInfo.getAdXml().isLandingPagesAd()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(localSnsInfo.getAdSnsInfo().field_adxml))) {
                  break label2402;
                }
                paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.T(localSnsInfo);
                if (!Util.isNullOrNil(paramAnonymousView)) {
                  ((AdSnsInfo)localObject2).field_adxml = paramAnonymousView;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localSnsInfo.getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localSnsInfo.getTimeLine().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", localSnsInfo.getUxinfo());
                paramAnonymousView.putExtra("sns_landing_pages_aid", localSnsInfo.getAid());
                paramAnonymousView.putExtra("sns_landing_pages_traceid", localSnsInfo.getTraceid());
                localObject1 = localSnsInfo.getTimeLine();
                if (localObject1 != null)
                {
                  localObject2 = ((TimeLineObject)localObject1).ContentObj.Zpr;
                  if (((List)localObject2).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((dmz)((List)localObject2).get(0)).aaTl);
                  }
                  if (((TimeLineObject)localObject1).ContentObj.Zpq == 15) {
                    paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                  }
                }
                c.a(c.this, paramAnonymousView, localSnsInfo);
                paramAnonymousView.setClass(c.f(c.this), SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (c.j(c.this) == 2)
                {
                  i = 16;
                  paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                  paramAnonymousView.putExtra("sns_landing_pages_xml", localSnsInfo.getAdSnsInfo().field_adxml);
                  paramAnonymousView.putExtra("sns_landing_pages_rec_src", localSnsInfo.getAdRecSrc());
                  paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                  paramAnonymousView.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
                  localObject1 = c.f(c.this);
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousView.aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)paramAnonymousView.sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  j = c.j(c.this);
                  if (c.j(c.this) != 0) {
                    break label1995;
                  }
                }
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 21);
                  com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.RoZ, localSnsInfo, 3);
                  t.a(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100258);
                  return;
                  if (c.j(c.this) != 1) {
                    break;
                  }
                  i = 10;
                  break;
                }
              }
              if (c.a(c.this, (ADInfo)localObject1, localSnsInfo, false))
              {
                j = c.j(c.this);
                if (c.j(c.this) == 0) {}
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 31);
                  com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.RoZ, localSnsInfo, 3);
                  t.a(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100258);
                  return;
                }
              }
              if (com.tencent.mm.plugin.sns.ad.d.n.a(c.f(c.this), localSnsInfo.getAdXml(), localSnsInfo.getAdInfo(), localSnsInfo.field_snsId, 2))
              {
                j = c.j(c.this);
                if (c.j(c.this) == 0) {}
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 41);
                  com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.RoZ, localSnsInfo, 3);
                  t.a(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100258);
                  return;
                }
              }
              if (!c.ag(localSnsInfo)) {
                break label2402;
              }
              if ((localSnsInfo == null) || (localSnsInfo.getAdXml() == null) || (localSnsInfo.getAdXml().adActionLinkClickInfo == null))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100258);
                return;
              }
              paramAnonymousView = localSnsInfo.getAdXml().adActionLinkClickInfo.finderUsername;
              if (paramAnonymousView == null)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100258);
                return;
              }
              com.tencent.mm.plugin.sns.ad.d.n.a(c.f(c.this), paramAnonymousView, localSnsInfo.getUxinfo(), t.uA(localSnsInfo.field_snsId), 2);
              j = c.j(c.this);
              if (c.j(c.this) == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 41);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.RoZ, localSnsInfo, 3);
                t.a(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100258);
                return;
              }
              i = 2;
              break label1039;
            }
          }
        }
      }
    };
    this.RQs = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(100259);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        localObject1 = com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymousView);
        if (localObject1 == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        Object localObject2 = ((SnsInfo)localObject1).getTimeLine();
        Object localObject3 = ((TimeLineObject)localObject2).Location;
        if (((SnsInfo)localObject1).isAd())
        {
          Log.i("MicroMsg.TimelineClickListener", "click the ad poi button");
          localObject2 = c.a(c.this, (SnsInfo)localObject1);
          if (localObject2 == null)
          {
            Log.e("MicroMsg.TimelineClickListener", "the adInfo is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
          int j = c.j(c.this);
          if (c.j(c.this) == 0) {}
          for (int i = 1;; i = 2)
          {
            localObject3 = new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 19, 0);
            com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject3, c.this.RoZ, (SnsInfo)localObject1, 19);
            t.a((SnsAdClick)localObject3);
            if (!Util.isNullOrNil(((ADInfo)localObject2).adActionPOILink)) {
              break;
            }
            Log.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
          if (c.j(c.this) == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.l.wO(724);; paramAnonymousView = com.tencent.mm.modelsns.l.wP(724))
          {
            paramAnonymousView.Ph(t.x((SnsInfo)localObject1)).wR(((SnsInfo)localObject1).field_type).hm(((SnsInfo)localObject1).isAd()).Ph(((SnsInfo)localObject1).getUxinfo()).Ph("").Ph("").Ph("").Ph("").Ph(((ADInfo)localObject2).adActionPOIName).Ph("").Ph("");
            paramAnonymousView.bMH();
            Log.i("MicroMsg.TimelineClickListener", "open webview url : " + ((ADInfo)localObject2).adActionPOILink);
            paramAnonymousView = new Intent();
            if ((localObject1 != null) && (((SnsInfo)localObject1).isAd()))
            {
              localObject4 = c.a(c.this, (SnsInfo)localObject1);
              if (localObject4 != null) {
                paramAnonymousView.putExtra("KsnsViewId", ((ADInfo)localObject4).viewId);
              }
            }
            Object localObject4 = new Bundle();
            ((Bundle)localObject4).putParcelable("KSnsAdTag", (Parcelable)localObject3);
            paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject4);
            paramAnonymousView.putExtra("useJs", true);
            paramAnonymousView.putExtra("KPublisherId", "sns_" + t.uA(((SnsInfo)localObject1).field_snsId));
            paramAnonymousView.putExtra("pre_username", ((SnsInfo)localObject1).field_userName);
            paramAnonymousView.putExtra("prePublishId", "sns_" + t.uA(((SnsInfo)localObject1).field_snsId));
            paramAnonymousView.putExtra("preUsername", ((SnsInfo)localObject1).field_userName);
            paramAnonymousView.putExtra("rawUrl", t.lY(((ADInfo)localObject2).adActionPOILink, ((ADInfo)localObject2).uxInfo));
            com.tencent.mm.plugin.sns.d.a.pFn.h(paramAnonymousView, c.f(c.this));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
        }
        if (c.j(c.this) == 0) {}
        for (paramAnonymousView = com.tencent.mm.modelsns.l.wO(724);; paramAnonymousView = com.tencent.mm.modelsns.l.wP(724))
        {
          paramAnonymousView.Ph(t.x((SnsInfo)localObject1)).wR(((SnsInfo)localObject1).field_type).hm(((SnsInfo)localObject1).isAd()).Ph(((SnsInfo)localObject1).getUxinfo()).Ph(((djv)localObject3).ZWG).wR(((djv)localObject3).ReW).Ph(((djv)localObject3).ZaH).Ph(((djv)localObject3).ZaG).Ph(((djv)localObject3).poiName).Ph(((djv)localObject3).ReU).Ph(((djv)localObject3).pSh);
          paramAnonymousView.bMH();
          paramAnonymousView = new Intent();
          localObject1 = new fei();
          ((fei)localObject1).ZaG = ((djv)localObject3).ZaG;
          ((fei)localObject1).ZaH = ((djv)localObject3).ZaH;
          ((fei)localObject1).pSh = ((djv)localObject3).pSh;
          ((fei)localObject1).poiName = ((djv)localObject3).poiName;
          ((fei)localObject1).ReU = ((djv)localObject3).ReU;
          ((fei)localObject1).ZWG = ((djv)localObject3).ZWG;
          ((fei)localObject1).ReW = ((djv)localObject3).ReW;
          ((fei)localObject1).aaPM = ((djv)localObject3).aaPM;
          ((fei)localObject1).aaPN = ((djv)localObject3).aaPN;
          ((fei)localObject1).aaPO = ((djv)localObject3).aaPO;
          ((fei)localObject1).ReZ = ((djv)localObject3).ReZ;
          com.tencent.mm.plugin.report.service.h.OAn.p(((bi)com.tencent.mm.kernel.h.ax(bi.class)).ePz(), 0L, 1L);
          ((bi)com.tencent.mm.kernel.h.ax(bi.class)).a(c.f(c.this), (fei)localObject1, bi.a.Hco, ((TimeLineObject)localObject2).Id, new bi.c()
          {
            public final void a(bi.b paramAnonymous2b)
            {
              AppMethodBeat.i(308539);
              int i;
              if (paramAnonymous2b == bi.b.Hcr) {
                if (!Util.isNullOrNil(this.RQZ.ZWG)) {
                  i = 1;
                }
              }
              for (;;)
              {
                if (i == 0)
                {
                  paramAnonymousView.putExtra("map_view_type", 7);
                  paramAnonymousView.putExtra("kwebmap_slat", this.RQZ.ZaH);
                  paramAnonymousView.putExtra("kwebmap_lng", this.RQZ.ZaG);
                  paramAnonymousView.putExtra("kPoiName", this.RQZ.poiName);
                  paramAnonymousView.putExtra("Kwebmap_locaion", this.RQZ.ReU);
                  com.tencent.mm.br.c.b(c.f(c.this), "location", ".ui.RedirectUI", paramAnonymousView);
                  AppMethodBeat.o(308539);
                  return;
                  i = 0;
                  continue;
                  if (paramAnonymous2b == bi.b.Hcv) {
                    i = 0;
                  }
                }
                else
                {
                  if (c.k(c.this) == 0) {}
                  for (paramAnonymous2b = String.format(com.tencent.mm.protocal.d.Yxq, new Object[] { this.RQZ.ZWG });; paramAnonymous2b = String.format(com.tencent.mm.protocal.d.Yxr, new Object[] { this.RQZ.ZWG, this.Rxs.Id }))
                  {
                    paramAnonymousView.putExtra("rawUrl", paramAnonymous2b);
                    com.tencent.mm.plugin.sns.d.a.pFn.h(paramAnonymousView, c.f(c.this));
                    AppMethodBeat.o(308539);
                    return;
                  }
                }
                i = 1;
              }
            }
          });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
      }
    };
    this.RQw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100260);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        paramAnonymousView = com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymousView);
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        if (paramAnonymousView.isAd())
        {
          Log.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
          paramAnonymousView = c.a(c.this, paramAnonymousView);
          if (paramAnonymousView == null)
          {
            Log.e("MicroMsg.TimelineClickListener", "the adInfo is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100260);
            return;
          }
          if (Util.isNullOrNil(paramAnonymousView.adActionExtTailLink))
          {
            Log.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100260);
            return;
          }
          Log.i("MicroMsg.TimelineClickListener", "open webview url : " + paramAnonymousView.adActionExtTailLink);
          localObject = new Intent();
          ((Intent)localObject).putExtra("jsapiargs", new Bundle());
          ((Intent)localObject).putExtra("useJs", true);
          String str = t.lY(paramAnonymousView.adActionExtTailLink, paramAnonymousView.uxInfo);
          t.i((Intent)localObject, paramAnonymousView.uxInfo);
          ((Intent)localObject).putExtra("rawUrl", str);
          com.tencent.mm.plugin.sns.d.a.pFn.h((Intent)localObject, c.f(c.this));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100260);
      }
    };
    this.RQx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100261);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        int j;
        if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          localObject = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).hES;
          localObject = com.tencent.mm.plugin.sns.model.al.hgB().aZL((String)localObject);
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100261);
            return;
          }
          if (((SnsInfo)localObject).isAd())
          {
            Log.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
            j = c.j(c.this);
            if (c.j(c.this) != 0) {
              break label193;
            }
          }
        }
        label193:
        for (int i = 1;; i = 2)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(j, i, ((SnsInfo)localObject).field_snsId, 24, 0);
          com.tencent.mm.plugin.sns.data.m.a(localSnsAdClick, c.this.RoZ, (SnsInfo)localObject, 24);
          t.a(localSnsAdClick);
          c.this.jA(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100261);
          return;
        }
      }
    };
    this.RPV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100262);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        Object localObject2 = (String)paramAnonymousView.getTag();
        Log.d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(localObject2)));
        Object localObject3 = new Intent();
        int j;
        int i;
        if (((paramAnonymousView instanceof MaskImageButton)) && (((MaskImageButton)paramAnonymousView).nsy != null))
        {
          localObject1 = (String)((MaskImageButton)paramAnonymousView).nsy;
          localObject1 = com.tencent.mm.plugin.sns.model.al.hgB().aZL((String)localObject1);
          if ((localObject1 != null) && (((SnsInfo)localObject1).isAd()))
          {
            Object localObject5 = ((SnsInfo)localObject1).getAdXml();
            j = c.j(c.this);
            if (c.j(c.this) == 0)
            {
              i = 1;
              localObject4 = new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 1, 0);
              com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject4, c.this.RoZ, (SnsInfo)localObject1, 1);
              if (localObject5 == null) {
                break label549;
              }
              if ((((ADXml)localObject5).headClickType != 1) || (Util.isNullOrNil(((ADXml)localObject5).headClickParam))) {
                break label412;
              }
              localObject2 = ((ADXml)localObject5).headClickParam;
              localObject3 = c.a(c.this, (SnsInfo)localObject1);
              paramAnonymousView = (View)localObject2;
              if (localObject3 != null) {
                paramAnonymousView = t.lY((String)localObject2, ((ADInfo)localObject3).uxInfo);
              }
              Log.i("MicroMsg.TimelineClickListener", "headClickParam url " + paramAnonymousView + " " + ((ADXml)localObject5).headClickRightBarShow);
              localObject2 = new Intent();
              if (((ADXml)localObject5).headClickRightBarShow != 0) {
                break label406;
              }
            }
            label406:
            for (boolean bool = true;; bool = false)
            {
              ((Intent)localObject2).putExtra("KsnsViewId", c.a(c.this, (SnsInfo)localObject1).viewId);
              ((Intent)localObject2).putExtra("KRightBtn", bool);
              ((Intent)localObject2).putExtra("jsapiargs", new Bundle());
              ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject2).putExtra("useJs", true);
              com.tencent.mm.plugin.sns.d.a.pFn.h((Intent)localObject2, c.f(c.this));
              t.a((SnsAdClick)localObject4);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100262);
              return;
              i = 2;
              break;
            }
            label412:
            if (com.tencent.mm.plugin.sns.ad.d.n.a(c.f(c.this), (ADXml)localObject5, c.a(c.this, (SnsInfo)localObject1), ((SnsInfo)localObject1).field_snsId, 1))
            {
              com.tencent.mm.plugin.sns.ad.j.k.a((SnsAdClick)localObject4, 41);
              t.a((SnsAdClick)localObject4);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100262);
              return;
            }
            localObject5 = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
            ((com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject5).put("ext_sns_ad_click", localObject4);
            Object localObject4 = com.tencent.mm.plugin.sns.ad.timeline.a.a.f(1, c.f(c.this));
            if ((localObject4 != null) && (((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject4).a(paramAnonymousView, c.j(c.this), (SnsInfo)localObject1, (com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject5)))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100262);
              return;
            }
            label549:
            paramAnonymousView = (View)localObject1;
            i = 1;
          }
        }
        for (;;)
        {
          if (((String)localObject2).endsWith("@ad"))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100262);
            return;
          }
          if (paramAnonymousView != null)
          {
            if (c.j(c.this) != 0) {
              break label823;
            }
            if (paramAnonymousView.isAd())
            {
              j = 722;
              localObject1 = com.tencent.mm.modelsns.l.wO(j);
              ((com.tencent.mm.modelsns.l)localObject1).Ph(t.x(paramAnonymousView)).wR(paramAnonymousView.field_type).hm(paramAnonymousView.isAd()).Ph(paramAnonymousView.getUxinfo()).Ph((String)localObject2);
              ((com.tencent.mm.modelsns.l)localObject1).bMH();
            }
          }
          else
          {
            if (i == 0) {
              break label860;
            }
            j = c.j(c.this);
            if (c.j(c.this) != 0) {
              break label850;
            }
            i = 1;
            label680:
            localObject1 = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 1, 40);
            com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject1, c.this.RoZ, paramAnonymousView, 1);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            ((Intent)localObject3).putExtra("KSnsAdTag", (Parcelable)localObject1);
            ((Intent)localObject3).putExtra("Contact_Scene", 78);
            if (c.j(c.this) != 0) {
              break label855;
            }
          }
          label823:
          label850:
          label855:
          for (i = 6;; i = 1)
          {
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            com.tencent.mm.plugin.sns.d.a.pFn.c((Intent)localObject3, c.f(c.this));
            Log.i("MicroMsg.TimelineClickListener", "startContactInfo, addScene=78");
            t.a((SnsAdClick)localObject1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100262);
            return;
            j = 721;
            break;
            if (paramAnonymousView.isAd()) {}
            for (j = 722;; j = 721)
            {
              localObject1 = com.tencent.mm.modelsns.l.wP(j);
              break;
            }
            i = 2;
            break label680;
          }
          label860:
          c.l(c.this).hgf().e(paramAnonymousView, true);
          if (c.j(c.this) == 0)
          {
            paramAnonymousView = com.tencent.mm.modelsns.l.wO(746);
            localObject1 = com.tencent.mm.model.z.bAM();
            paramAnonymousView.Ph((String)localObject2).hm(((String)localObject2).endsWith((String)localObject1));
            paramAnonymousView.b((Intent)localObject3, "intent_key_StatisticsOplog");
            if (c.j(c.this) != 0) {
              break label1023;
            }
          }
          label1023:
          for (i = 6;; i = 1)
          {
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            com.tencent.mm.plugin.sns.d.a.pFn.c((Intent)localObject3, c.f(c.this));
            ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210((String)localObject2, 6L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100262);
            return;
            paramAnonymousView = com.tencent.mm.modelsns.l.wP(746);
            break;
          }
          paramAnonymousView = (View)localObject1;
          i = 0;
          continue;
          paramAnonymousView = null;
          i = 0;
        }
      }
    };
    this.RPW = new c.2(this);
    this.RPX = new d()
    {
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100203);
        paramAnonymousContextMenuInfo = (bj)paramAnonymousView.getTag();
        paramAnonymousView = com.tencent.mm.plugin.sns.model.al.hgB().aZK(paramAnonymousContextMenuInfo.hQX);
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(100203);
          return;
        }
        if (!paramAnonymousView.isNoCopy()) {
          paramAnonymousContextMenu.add(0, 0, 0, c.f(c.this).getString(b.j.app_copy));
        }
        if (com.tencent.mm.br.c.blq("favorite")) {
          paramAnonymousContextMenu.add(0, 1, 0, c.f(c.this).getString(b.j.plugin_favorite_opt));
        }
        TimeLineObject localTimeLineObject = paramAnonymousView.getTimeLine();
        int i;
        if ((paramAnonymousContextMenuInfo.RvF) || ((localTimeLineObject != null) && (localTimeLineObject.contentDescShowType != 1) && (!paramAnonymousContextMenuInfo.RvG)))
        {
          if (!paramAnonymousContextMenuInfo.hph()) {
            av.a(paramAnonymousContextMenu, true);
          }
        }
        else
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousView);
          if ((((c.f(c.this) instanceof SnsTimeLineUI)) || ((c.f(c.this) instanceof SnsCommentDetailUI)) || ((c.f(c.this) instanceof SnsWsFoldDetailUI))) && (!aj.aBu()))
          {
            paramAnonymousContextMenu.add(0, 27, 0, c.f(c.this).getString(b.j.find_friends_search));
            paramAnonymousContextMenu = Util.nullAs(paramAnonymousView.getTimeLine().ContentDesc, "");
            i = 0;
            if (!(c.f(c.this) instanceof SnsCommentDetailUI)) {
              break label300;
            }
            i = 5;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.websearch.api.as.a(1, com.tencent.mm.plugin.fts.a.d.We(77), 77, 0, "", "", t.uA(paramAnonymousView.field_snsId), 3, "", 0L, paramAnonymousContextMenu.length(), i, "", "", -1);
          AppMethodBeat.o(100203);
          return;
          av.b(paramAnonymousContextMenu, true);
          break;
          label300:
          if ((c.f(c.this) instanceof SnsWsFoldDetailUI)) {
            i = 6;
          } else if ((c.f(c.this) instanceof SnsTimeLineUI)) {
            i = 5;
          }
        }
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(100204);
        if ((paramAnonymousView.getTag() instanceof bj))
        {
          Object localObject = (bj)paramAnonymousView.getTag();
          localObject = com.tencent.mm.plugin.sns.model.al.hgB().aZK(((bj)localObject).hQX);
          if (localObject == null)
          {
            AppMethodBeat.o(100204);
            return false;
          }
          String str = ((SnsInfo)localObject).getLocalid();
          c.this.RPU.a(paramAnonymousView, str, ((SnsInfo)localObject).getTimeLine());
          AppMethodBeat.o(100204);
          return true;
        }
        AppMethodBeat.o(100204);
        return false;
      }
    };
    this.RQm = new d()
    {
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100206);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof SnsInfo)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.aw)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.bf)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.c.a.b))) {
          if ((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.l.aZK(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).hQX);
          }
        }
        for (;;)
        {
          if (!paramAnonymousContextMenuInfo.isAd())
          {
            AppMethodBeat.o(100206);
            return;
            if ((paramAnonymousContextMenuInfo instanceof SnsInfo))
            {
              paramAnonymousContextMenuInfo = (SnsInfo)paramAnonymousContextMenuInfo;
              continue;
            }
            if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.aw))
            {
              paramAnonymousContextMenuInfo = (com.tencent.mm.plugin.sns.ui.aw)paramAnonymousContextMenuInfo;
              paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymousContextMenuInfo.hES);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bf))
            {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.bf)paramAnonymousView.getTag()).hHB;
              paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymousContextMenuInfo);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).PNI;
            }
          }
          else
          {
            if ((paramAnonymousContextMenuInfo.getAdXml() == null) || (!paramAnonymousContextMenuInfo.getAdXml().isCardAd()))
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (c.a(c.this, paramAnonymousContextMenuInfo).actionExtWeApp != null)
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (com.tencent.mm.plugin.sns.ad.d.n.a(paramAnonymousContextMenuInfo.getAdXml(), paramAnonymousContextMenuInfo.getAdInfo()))
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (com.tencent.mm.br.c.blq("favorite"))
            {
              if (paramAnonymousContextMenuInfo.getAdXml().isCardAd()) {
                paramAnonymousContextMenu.add(0, 20, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
              }
              ex localex = new ex();
              localex.hFc.hES = paramAnonymousContextMenuInfo.getLocalid();
              localex.publish();
              if (localex.hFd.hEn) {
                paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(b.j.app_open));
              }
            }
            if (paramAnonymousContextMenuInfo != null) {
              com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            }
            AppMethodBeat.o(100206);
            return;
          }
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(100205);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof SnsInfo)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bf)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.l.aZK(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).hQX);
          }
        }
        for (;;)
        {
          if (localObject != null)
          {
            if (!((SnsInfo)localObject).isAd())
            {
              AppMethodBeat.o(100205);
              return false;
              if ((localObject instanceof SnsInfo))
              {
                localObject = (SnsInfo)localObject;
                continue;
              }
              if ((localObject instanceof com.tencent.mm.plugin.sns.ui.aw))
              {
                localObject = (com.tencent.mm.plugin.sns.ui.aw)localObject;
                localObject = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((com.tencent.mm.plugin.sns.ui.aw)localObject).hES);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bf))
              {
                localObject = ((com.tencent.mm.plugin.sns.ui.bf)paramAnonymousView.getTag()).hHB;
                localObject = com.tencent.mm.plugin.sns.model.al.hgB().aZL((String)localObject);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
                localObject = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).PNI;
              }
            }
            else
            {
              if ((((SnsInfo)localObject).getAdXml() == null) || (!((SnsInfo)localObject).getAdXml().isCardAd()) || (((SnsInfo)localObject).getAdXml().adLiveInfo != null))
              {
                AppMethodBeat.o(100205);
                return false;
              }
              c.this.RPU.a(paramAnonymousView, ((SnsInfo)localObject).getLocalid(), ((SnsInfo)localObject).getTimeLine());
            }
          }
          else
          {
            AppMethodBeat.o(100205);
            return true;
            AppMethodBeat.o(100205);
            return false;
          }
          localObject = null;
        }
      }
    };
    this.RQn = new d()
    {
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100208);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof SnsInfo)))
        {
          if (!(paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            break label176;
          }
          paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.l.aZK(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).hQX);
        }
        for (;;)
        {
          Object localObject;
          ADInfo localADInfo;
          if (com.tencent.mm.br.c.blq("favorite"))
          {
            localObject = paramAnonymousContextMenuInfo.getAdXml();
            localADInfo = c.a(c.this, paramAnonymousContextMenuInfo);
            if (((ADXml)localObject).isLinkAd())
            {
              if (!((ADXml)localObject).isLandingPagesAd()) {
                break label191;
              }
              paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
            }
          }
          for (;;)
          {
            localObject = new ex();
            ((ex)localObject).hFc.hES = paramAnonymousContextMenuInfo.getLocalid();
            ((ex)localObject).publish();
            if (((ex)localObject).hFd.hEn) {
              paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(b.j.app_open));
            }
            if (paramAnonymousContextMenuInfo != null) {
              com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            }
            AppMethodBeat.o(100208);
            return;
            label176:
            if (!(paramAnonymousContextMenuInfo instanceof SnsInfo)) {
              break label222;
            }
            paramAnonymousContextMenuInfo = (SnsInfo)paramAnonymousContextMenuInfo;
            break;
            label191:
            if (localADInfo.adActionType == 0) {
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
            }
          }
          label222:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(100207);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof SnsInfo)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.l.aZK(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).hQX);
          }
        }
        for (;;)
        {
          if (localObject != null) {
            c.this.RPU.a(paramAnonymousView, ((SnsInfo)localObject).getLocalid(), ((SnsInfo)localObject).getTimeLine());
          }
          AppMethodBeat.o(100207);
          return true;
          if ((localObject instanceof SnsInfo))
          {
            localObject = (SnsInfo)localObject;
            continue;
            AppMethodBeat.o(100207);
            return false;
          }
          else
          {
            localObject = null;
          }
        }
      }
    };
    this.RQj = new d()
    {
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100209);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.s)) {
          c.m(c.this).onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
        }
        AppMethodBeat.o(100209);
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(100210);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.s)paramAnonymousView.getTag()).hES;
          SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(str);
          c.this.RPU.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(100210);
          return true;
        }
        AppMethodBeat.o(100210);
        return false;
      }
    };
    this.RQp = new d()
    {
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100211);
        if (com.tencent.mm.br.c.blq("favorite")) {
          paramAnonymousContextMenu.add(0, 24, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
        }
        AppMethodBeat.o(100211);
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(100212);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.al))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.al)paramAnonymousView.getTag()).hES;
          SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(str);
          c.this.RPU.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(100212);
          return true;
        }
        AppMethodBeat.o(100212);
        return false;
      }
    };
    this.RQi = new d()
    {
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100214);
        com.tencent.mm.plugin.sns.ui.bf localbf;
        Object localObject1;
        Object localObject2;
        int j;
        int i;
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bf)))
        {
          localbf = (com.tencent.mm.plugin.sns.ui.bf)paramAnonymousView.getTag();
          localObject1 = localbf.hHB;
          paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL((String)localObject1);
          if (com.tencent.mm.br.c.blq("favorite"))
          {
            paramAnonymousContextMenu.add(0, 2, 0, c.f(c.this).getString(b.j.plugin_favorite_opt));
            localObject2 = new ex();
            ((ex)localObject2).hFc.hES = ((String)localObject1);
            ((ex)localObject2).publish();
            if (((ex)localObject2).hFd.hEn) {
              paramAnonymousContextMenu.add(0, 18, 0, c.f(c.this).getString(b.j.app_open));
            }
          }
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
          localObject1 = paramAnonymousContextMenu.add(0, 21, 0, c.f(c.this).getString(b.j.sns_edit_image));
          localObject2 = new int[2];
          if (paramAnonymousView == null) {
            break label492;
          }
          j = paramAnonymousView.getWidth();
          i = paramAnonymousView.getHeight();
          paramAnonymousView.getLocationInWindow((int[])localObject2);
        }
        for (;;)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", localObject2[0]).putExtra("img_gallery_top", localObject2[1]);
          ((MenuItem)localObject1).setIntent(paramAnonymousView);
          if ((((c.f(c.this) instanceof SnsTimeLineUI)) || ((c.f(c.this) instanceof SnsCommentDetailUI))) && (!aj.aBu()))
          {
            paramAnonymousContextMenu.add(0, 26, 0, c.f(c.this).getString(b.j.find_friends_search));
            if (!(c.f(c.this) instanceof SnsTimeLineUI)) {
              break label474;
            }
            i = 10;
            paramAnonymousContextMenu = paramAnonymousContextMenuInfo.getTimeLine();
            if (localbf.index >= paramAnonymousContextMenu.ContentObj.Zpr.size()) {
              break label481;
            }
          }
          label474:
          label481:
          for (paramAnonymousContextMenu = (dmz)paramAnonymousContextMenu.ContentObj.Zpr.get(localbf.index);; paramAnonymousContextMenu = new dmz())
          {
            paramAnonymousView = new com.tencent.mm.autogen.mmdata.rpt.ap();
            paramAnonymousContextMenuInfo = paramAnonymousView.kC("").kD(t.uA(paramAnonymousContextMenuInfo.field_snsId));
            paramAnonymousContextMenuInfo.ioZ = i;
            paramAnonymousContextMenuInfo.ilm = 1;
            paramAnonymousContextMenuInfo.imW = 81;
            paramAnonymousView.kE("");
            paramAnonymousView.kF("");
            paramAnonymousView.kG(com.tencent.mm.b.g.getMD5(com.tencent.mm.plugin.sns.model.as.mg(com.tencent.mm.plugin.sns.model.al.getAccSnsPath(), paramAnonymousContextMenu.Id) + t.k(paramAnonymousContextMenu)));
            paramAnonymousView.ipe = System.currentTimeMillis();
            paramAnonymousView.bMH();
            com.tencent.mm.plugin.websearch.api.as.a(paramAnonymousView);
            AppMethodBeat.o(100214);
            return;
            i = 7;
            break;
          }
          label492:
          i = 0;
          j = 0;
        }
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(100213);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bf))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.bf)paramAnonymousView.getTag()).hHB;
          SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(str);
          c.this.RPU.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(100213);
          return true;
        }
        AppMethodBeat.o(100213);
        return false;
      }
    };
    this.RQl = new d()
    {
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(308520);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.bf)) {
          paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.bf)paramAnonymousContextMenuInfo).hHB;
        }
        for (;;)
        {
          if (paramAnonymousContextMenuInfo != null)
          {
            paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymousContextMenuInfo);
            TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.getTimeLine();
            if (com.tencent.mm.br.c.blq("favorite")) {
              switch (localTimeLineObject.ContentObj.Zpq)
              {
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            AppMethodBeat.o(308520);
            return;
            if (!(paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.s)) {
              break label160;
            }
            paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.s)paramAnonymousContextMenuInfo).hES;
            break;
            paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
            continue;
            paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
          }
          label160:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(308518);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof com.tencent.mm.plugin.sns.ui.bf)) {
          localObject = ((com.tencent.mm.plugin.sns.ui.bf)localObject).hHB;
        }
        for (;;)
        {
          if (localObject != null)
          {
            SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL((String)localObject);
            c.this.RPU.a(paramAnonymousView, (String)localObject, localSnsInfo.getTimeLine());
            AppMethodBeat.o(308518);
            return true;
            if ((localObject instanceof com.tencent.mm.plugin.sns.ui.s)) {
              localObject = ((com.tencent.mm.plugin.sns.ui.s)localObject).hES;
            }
          }
          else
          {
            AppMethodBeat.o(308518);
            return false;
          }
          localObject = null;
        }
      }
    };
    this.Rea = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100216);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        localObject1 = null;
        int j = -1;
        int i;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bf))
        {
          localObject1 = ((com.tencent.mm.plugin.sns.ui.bf)paramAnonymousView.getTag()).hHB;
          i = ((com.tencent.mm.plugin.sns.ui.bf)paramAnonymousView.getTag()).index;
        }
        Object localObject2;
        for (;;)
        {
          localObject2 = com.tencent.mm.plugin.sns.storage.l.aZL((String)localObject1);
          if (localObject2 != null) {
            break;
          }
          Log.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(localObject1)));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
          if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
          {
            localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).hES;
            i = j;
          }
          else
          {
            i = j;
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b))
            {
              localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).PNI.getLocalid();
              i = j;
            }
          }
        }
        if ((((SnsInfo)localObject2).isAd()) && (((SnsInfo)localObject2).getAdXml() != null) && ((((SnsInfo)localObject2).getAdXml().isCardAd()) || (((SnsInfo)localObject2).getAdXml().isFullCardAd())))
        {
          c.this.RQG.onClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
        }
        if (((SnsInfo)localObject2).getTimeLine().ContentObj.Zpq == 21)
        {
          if (com.tencent.mm.model.z.bAM().equals(((SnsInfo)localObject2).getUserName()))
          {
            ((SnsInfo)localObject2).getTimeLine();
            com.tencent.mm.plugin.sns.lucky.a.m.A((SnsInfo)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.m.z((SnsInfo)localObject2);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.rG(25);
          }
          if (!com.tencent.mm.model.z.bAM().equals(((SnsInfo)localObject2).getUserName()))
          {
            com.tencent.mm.plugin.sns.lucky.b.a.e(2, (SnsInfo)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.b.rG(30);
          }
        }
        if (((SnsInfo)localObject2).isAd())
        {
          localObject1 = ((SnsInfo)localObject2).getAdXml();
          if (localObject1 != null) {
            com.tencent.mm.plugin.sns.ad.d.b.P(c.f(c.this), ((ADXml)localObject1).appGiftPackCode, ((ADXml)localObject1).appGiftPackCodeTips);
          }
          localObject1 = c.a(c.this, (SnsInfo)localObject2);
          if (!com.tencent.mm.plugin.sns.data.m.a(c.f(c.this), (SnsInfo)localObject2, (ADInfo)localObject1, c.j(c.this), c.this.RoZ, 21, i))
          {
            if ((!((SnsInfo)localObject2).getAdXml().isLandingPagesAd()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(((SnsInfo)localObject2).getAdSnsInfo().field_adxml))) {
              break label1173;
            }
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.T((SnsInfo)localObject2);
            if (!Util.isNullOrNil((String)localObject1)) {
              ((SnsInfo)localObject2).getAdSnsInfo().field_adxml = ((String)localObject1);
            }
            j = c.j(c.this);
            if (c.j(c.this) != 0) {
              break label1152;
            }
            i = 1;
            localObject1 = new SnsAdClick(j, i, ((SnsInfo)localObject2).field_snsId, 21, 21);
            com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject1, c.this.RoZ, (SnsInfo)localObject2, 21);
            t.a((SnsAdClick)localObject1);
            Object localObject3 = new int[2];
            if (paramAnonymousView != null) {
              paramAnonymousView.getLocationInWindow((int[])localObject3);
            }
            i = paramAnonymousView.getWidth();
            j = paramAnonymousView.getHeight();
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("img_gallery_left", localObject3[0]);
            ((Intent)localObject1).putExtra("img_gallery_top", localObject3[1]);
            ((Intent)localObject1).putExtra("img_gallery_width", i);
            ((Intent)localObject1).putExtra("img_gallery_height", j);
            ((Intent)localObject1).putExtra("sns_landing_pages_share_sns_id", ((SnsInfo)localObject2).getSnsId());
            ((Intent)localObject1).putExtra("sns_landing_pages_rawSnsId", ((SnsInfo)localObject2).getTimeLine().Id);
            ((Intent)localObject1).putExtra("sns_landing_pages_ux_info", ((SnsInfo)localObject2).getUxinfo());
            ((Intent)localObject1).putExtra("sns_landing_pages_aid", ((SnsInfo)localObject2).getAid());
            ((Intent)localObject1).putExtra("sns_landing_pages_traceid", ((SnsInfo)localObject2).getTraceid());
            localObject3 = ((SnsInfo)localObject2).getTimeLine();
            if (localObject3 != null)
            {
              localObject3 = ((TimeLineObject)localObject3).ContentObj.Zpr;
              if (((List)localObject3).size() > 0)
              {
                ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((dmz)((List)localObject3).get(0)).aaTl);
                ((Intent)localObject1).putExtra("sns_landing_pages_from_outer_index", ((com.tencent.mm.plugin.sns.ui.bf)paramAnonymousView.getTag()).index);
              }
            }
            ((Intent)localObject1).setClass(c.f(c.this), SnsAdNativeLandingPagesUI.class);
            i = 1;
            if (c.j(c.this) != 2) {
              break label1157;
            }
            i = 16;
            label785:
            ((Intent)localObject1).putExtra("sns_landig_pages_from_source", i);
            ((Intent)localObject1).putExtra("sns_landing_pages_xml", ((SnsInfo)localObject2).getAdSnsInfo().field_adxml);
            ((Intent)localObject1).putExtra("sns_landing_pages_rec_src", ((SnsInfo)localObject2).getAdRecSrc());
            ((Intent)localObject1).putExtra("sns_landing_pages_xml_prefix", "adxml");
            ((Intent)localObject1).putExtra("sns_landing_page_start_time", System.currentTimeMillis());
            if (!((SnsInfo)localObject2).getAdXml().forbiddenCustomAnimation)
            {
              ((Intent)localObject1).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
              ((Intent)localObject1).putExtra("sns_landing_pages_is_normal_ad_animation", true);
            }
            localObject3 = c.f(c.this);
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            if (!((SnsInfo)localObject2).getAdXml().forbiddenCustomAnimation) {
              c.f(c.this).overridePendingTransition(0, 0);
            }
            if (c.l(c.this) != null) {
              c.l(c.this).hgf().P((SnsInfo)localObject2);
            }
          }
          label1013:
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.bf)paramAnonymousView.getTag();
          if ((paramAnonymousView.Roa) && (localObject2 != null))
          {
            com.tencent.mm.plugin.sns.ui.a.c.i((SnsInfo)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.ui.a.c.j((SnsInfo)localObject2, paramAnonymousView.index);
            be.aYK(((SnsInfo)localObject2).getLocalid());
          }
          if (localObject2 != null)
          {
            localObject1 = ((SnsInfo)localObject2).getTimeLine();
            if (localObject1 != null) {
              if (((TimeLineObject)localObject1).AppInfo != null) {
                break label1426;
              }
            }
          }
        }
        label1152:
        label1157:
        label1426:
        for (paramAnonymousView = null;; paramAnonymousView = ((TimeLineObject)localObject1).AppInfo.Id)
        {
          if (!Util.isNullOrNil(paramAnonymousView))
          {
            localObject2 = com.tencent.mm.plugin.sns.d.a.pFo.iz(paramAnonymousView);
            com.tencent.mm.plugin.sns.d.a.pFo.a(null, paramAnonymousView, (String)localObject2, ((TimeLineObject)localObject1).UserName, 2, 4, 4, ((TimeLineObject)localObject1).statisticsData, ((TimeLineObject)localObject1).Id);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
          i = 2;
          break;
          if (c.j(c.this) != 1) {
            break label785;
          }
          i = 2;
          break label785;
          label1173:
          if ((localObject1 != null) && (((ADInfo)localObject1).checkCurIndexCanJump(i)))
          {
            c.a(c.this, paramAnonymousView, (SnsInfo)localObject2, (ADInfo)localObject1, i, 7);
            break label1013;
          }
          if (c.a(c.this, (ADInfo)localObject1, (SnsInfo)localObject2, false))
          {
            j = c.j(c.this);
            if (c.j(c.this) == 0) {}
            for (i = 1;; i = 2)
            {
              localObject1 = new SnsAdClick(j, i, ((SnsInfo)localObject2).field_snsId, 21, 31);
              com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject1, c.this.RoZ, (SnsInfo)localObject2, 21);
              t.a((SnsAdClick)localObject1);
              break;
            }
          }
          if (bn.g((SnsInfo)localObject2, true) == 2)
          {
            if (com.tencent.mm.plugin.sns.ad.d.n.a(c.f(c.this), ((SnsInfo)localObject2).getAdXml(), (ADInfo)localObject1, ((SnsInfo)localObject2).field_snsId))
            {
              j = c.j(c.this);
              if (c.j(c.this) == 0) {}
              for (i = 1;; i = 2)
              {
                localObject1 = new SnsAdClick(j, i, ((SnsInfo)localObject2).field_snsId, 21, 37);
                com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject1, c.this.RoZ, (SnsInfo)localObject2, 21);
                t.a((SnsAdClick)localObject1);
                break;
              }
            }
            c.this.gt(paramAnonymousView);
            break label1013;
          }
          c.this.gt(paramAnonymousView);
          break label1013;
          c.this.gt(paramAnonymousView);
          break label1013;
        }
      }
    };
    this.RPY = new c.11(this);
    this.RPZ = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(100220);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        new g.a(c.f(c.this)).bDE(c.f(c.this).getResources().getString(b.j.sns_timeline_ui_confirm_del)).bDI(c.f(c.this).getResources().getString(b.j.app_delete)).aEY(c.f(c.this).getResources().getColor(b.c.red_text_color)).b(new g.c()
        {
          public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(308523);
            if (!(paramAnonymousView.getTag() instanceof String))
            {
              AppMethodBeat.o(308523);
              return;
            }
            paramAnonymous2String = (String)paramAnonymousView.getTag();
            Log.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymous2String)));
            SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymous2String);
            if (localSnsInfo == null)
            {
              Log.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(308523);
              return;
            }
            Object localObject2;
            if (localSnsInfo.isDieItem())
            {
              Log.i("MicroMsg.TimelineClickListener", "dead item");
              com.tencent.mm.plugin.sns.model.al.hgB().alC(localSnsInfo.localid);
              if (c.n(c.this) != null) {
                c.n(c.this).hpD();
              }
              if (c.j(c.this) == 0)
              {
                localObject1 = com.tencent.mm.modelsns.l.wO(739);
                localObject2 = ((com.tencent.mm.modelsns.l)localObject1).Ph(t.x(localSnsInfo)).wR(localSnsInfo.field_type);
                if (!localSnsInfo.isDieItem()) {
                  break label238;
                }
                paramAnonymous2String = "2";
              }
              for (;;)
              {
                ((com.tencent.mm.modelsns.l)localObject2).Ph(paramAnonymous2String);
                ((com.tencent.mm.modelsns.l)localObject1).bMH();
                if (localSnsInfo.getTypeFlag() == 21) {
                  com.tencent.mm.plugin.sns.lucky.a.g.hfm().hfo();
                }
                AppMethodBeat.o(308523);
                return;
                localObject1 = com.tencent.mm.modelsns.l.wP(739);
                break;
                label238:
                if (localSnsInfo.field_snsId == 0L) {
                  paramAnonymous2String = "1";
                } else {
                  paramAnonymous2String = "0";
                }
              }
            }
            if (localSnsInfo.isInValid())
            {
              com.tencent.mm.plugin.comm.b.e.xfd.a("SnsPublishProcess", "opresult_", Integer.valueOf(5), com.tencent.mm.plugin.comm.b.c.xeS);
              paramAnonymous2String = com.tencent.mm.plugin.sns.statistics.h.QFO;
              h.a.aZm(localSnsInfo.localid);
              ((com.tencent.mm.plugin.secdata.g)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.secdata.g.class)).removeFromStorage(16, localSnsInfo.localid, null);
              Log.i("MicroMsg.TimelineClickListener", "cancel item " + localSnsInfo.getLocalid());
              com.tencent.mm.plugin.sns.model.al.hgx().L(localSnsInfo);
              paramAnonymous2String = localSnsInfo.getTimeLine();
              j = 0;
              i = j;
              if (paramAnonymous2String != null)
              {
                i = j;
                if (paramAnonymous2String.ContentObj != null)
                {
                  i = j;
                  if (paramAnonymous2String.ContentObj.hKU != null)
                  {
                    i = j;
                    if (paramAnonymous2String.ContentObj.hKU.localId != 0L) {
                      i = 1;
                    }
                  }
                }
              }
              if ((Util.secondsToNow(localSnsInfo.getCreateTime()) < au.Qxf) && (i == 0)) {
                com.tencent.mm.plugin.sns.model.al.hgO().F(localSnsInfo);
              }
              c.this.hlJ();
              AppMethodBeat.o(308523);
              return;
            }
            Log.i("MicroMsg.TimelineClickListener", "delete by server");
            paramAnonymous2String = localSnsInfo.getSnsId();
            com.tencent.mm.plugin.sns.model.al.hgA().uQ(com.tencent.mm.plugin.sns.storage.ai.aXe(paramAnonymous2String));
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.sns.model.s(com.tencent.mm.plugin.sns.storage.ai.aXe(paramAnonymous2String), 1), 0);
            Object localObject1 = localSnsInfo.getTimeLine();
            int j = 0;
            int i = j;
            if (localObject1 != null)
            {
              i = j;
              if (((TimeLineObject)localObject1).ContentObj != null)
              {
                i = j;
                if (((TimeLineObject)localObject1).ContentObj.hKU != null)
                {
                  i = j;
                  if (((TimeLineObject)localObject1).ContentObj.hKU.localId != 0L) {
                    i = 1;
                  }
                }
              }
            }
            if ((Util.secondsToNow(localSnsInfo.getCreateTime()) < au.Qxf) && (i == 0)) {
              com.tencent.mm.plugin.sns.model.al.hgO().F(localSnsInfo);
            }
            com.tencent.mm.plugin.sns.model.al.hgB().delete(com.tencent.mm.plugin.sns.storage.ai.aXe(paramAnonymous2String));
            com.tencent.mm.plugin.sns.model.al.hgH().vh(com.tencent.mm.plugin.sns.storage.ai.aXe(paramAnonymous2String));
            com.tencent.mm.plugin.sns.storage.n.vg(com.tencent.mm.plugin.sns.storage.ai.aXe(paramAnonymous2String));
            c.this.hlJ();
            if (localObject1 != null)
            {
              if (((TimeLineObject)localObject1).AppInfo != null) {
                break label840;
              }
              paramAnonymous2String = null;
              if ((!Util.isNullOrNil(paramAnonymous2String)) && (com.tencent.mm.plugin.sns.d.a.pFo.iB(paramAnonymous2String)))
              {
                localObject2 = com.tencent.mm.plugin.sns.d.a.pFo.iz(paramAnonymous2String);
                ul localul = new ul();
                localul.hYf.appId = paramAnonymous2String;
                localul.hYf.hYg = ((TimeLineObject)localObject1).UserName;
                localul.hYf.pkgName = ((String)localObject2);
                localul.hYf.mediaTagName = ((TimeLineObject)localObject1).statisticsData;
                localul.publish();
              }
            }
            if (c.j(c.this) == 0)
            {
              localObject1 = com.tencent.mm.modelsns.l.wO(739);
              label790:
              localObject2 = ((com.tencent.mm.modelsns.l)localObject1).Ph(t.x(localSnsInfo)).wR(localSnsInfo.field_type);
              if (!localSnsInfo.isDieItem()) {
                break label863;
              }
              paramAnonymous2String = "2";
            }
            for (;;)
            {
              ((com.tencent.mm.modelsns.l)localObject2).Ph(paramAnonymous2String);
              ((com.tencent.mm.modelsns.l)localObject1).bMH();
              AppMethodBeat.o(308523);
              return;
              label840:
              paramAnonymous2String = ((TimeLineObject)localObject1).AppInfo.Id;
              break;
              localObject1 = com.tencent.mm.modelsns.l.wP(739);
              break label790;
              label863:
              if (localSnsInfo.field_snsId == 0L) {
                paramAnonymous2String = "1";
              } else {
                paramAnonymous2String = "0";
              }
            }
          }
        }).bDJ(c.f(c.this).getResources().getString(b.j.app_cancel)).a(new g.c()
        {
          public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100220);
      }
    };
    this.RQa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100221);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        paramAnonymousView = (String)paramAnonymousView.getTag();
        Log.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymousView)));
        paramAnonymousView = com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymousView).getTimeLine();
        localObject1 = paramAnonymousView.actionInfo;
        if (((bh)localObject1).YCC == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
        }
        String str = com.tencent.mm.plugin.sns.d.a.pFo.iz(((bh)localObject1).YCC.oOI);
        int i = 0;
        if (paramAnonymousView.ContentObj.Zpq == 1) {
          i = 2;
        }
        while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(paramAnonymousView, c.f(c.this)))
        {
          com.tencent.mm.plugin.sns.d.a.pFo.a(c.f(c.this), ((bh)localObject1).YCC.oOI, str, paramAnonymousView.UserName, i, 11, 9, ((bh)localObject1).YCC.YCm, paramAnonymousView.Id);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
          if (paramAnonymousView.ContentObj.Zpq == 3) {
            i = 5;
          } else if (paramAnonymousView.ContentObj.Zpq == 15) {
            i = 38;
          }
        }
        switch (((bh)localObject1).vhJ)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("rawUrl", ((bh)localObject1).Url);
          com.tencent.mm.plugin.sns.d.a.pFn.h((Intent)localObject2, c.f(c.this));
          com.tencent.mm.plugin.sns.d.a.pFo.a(c.f(c.this), ((bh)localObject1).YCC.oOI, str, paramAnonymousView.UserName, i, 11, 1, ((bh)localObject1).YCC.YCm, paramAnonymousView.Id);
          continue;
          if (((bh)localObject1).IJG == 1)
          {
            localObject2 = new kj();
            ((kj)localObject2).hLZ.actionCode = 2;
            ((kj)localObject2).hLZ.scene = 3;
            ((kj)localObject2).hLZ.appId = ((bh)localObject1).YCC.oOI;
            ((kj)localObject2).hLZ.context = c.f(c.this);
            ((kj)localObject2).publish();
            com.tencent.mm.plugin.sns.d.a.pFo.a(c.f(c.this), ((bh)localObject1).YCC.oOI, str, paramAnonymousView.UserName, i, 11, 6, ((bh)localObject1).YCC.YCm, paramAnonymousView.Id);
            continue;
            int j = ar.b(c.f(c.this), (bh)localObject1);
            if (j == 1)
            {
              localObject2 = new kj();
              ((kj)localObject2).hLZ.context = c.f(c.this);
              ((kj)localObject2).hLZ.actionCode = 2;
              ((kj)localObject2).hLZ.appId = ((bh)localObject1).YCC.oOI;
              ((kj)localObject2).hLZ.messageAction = ((bh)localObject1).YCC.YCo;
              ((kj)localObject2).hLZ.messageExt = ((bh)localObject1).YCC.YCn;
              ((kj)localObject2).hLZ.scene = 3;
              ((kj)localObject2).publish();
              com.tencent.mm.plugin.sns.d.a.pFo.a(c.f(c.this), ((bh)localObject1).YCC.oOI, str, paramAnonymousView.UserName, i, 11, 6, ((bh)localObject1).YCC.YCm, paramAnonymousView.Id);
            }
            else if (j == 2)
            {
              localObject2 = new kj();
              ((kj)localObject2).hLZ.context = c.f(c.this);
              ((kj)localObject2).hLZ.actionCode = 1;
              ((kj)localObject2).hLZ.appId = ((bh)localObject1).YCC.oOI;
              ((kj)localObject2).hLZ.messageAction = ((bh)localObject1).YCC.YCo;
              ((kj)localObject2).hLZ.messageExt = ((bh)localObject1).YCC.YCn;
              ((kj)localObject2).hLZ.scene = 3;
              ((kj)localObject2).publish();
              com.tencent.mm.plugin.sns.d.a.pFo.a(c.f(c.this), ((bh)localObject1).YCC.oOI, str, paramAnonymousView.UserName, i, 11, 3, ((bh)localObject1).YCC.YCm, paramAnonymousView.Id);
            }
          }
        }
      }
    };
    this.RQg = new View.OnClickListener()
    {
      private static void bbe(String paramAnonymousString)
      {
        AppMethodBeat.i(308543);
        long l = com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymousString).field_snsId;
        Object localObject1 = com.tencent.mm.plugin.sns.model.al.hgB().vj(l);
        if (localObject1 != null)
        {
          Object localObject2 = ((SnsInfo)localObject1).getTimeLine();
          if (localObject2 != null)
          {
            localObject2 = ((TimeLineObject)localObject2).ContentObj.Zpr;
            if (((List)localObject2).size() > 0) {
              ((List)localObject2).get(0);
            }
          }
          localObject2 = com.tencent.mm.plugin.sns.model.ap.E((SnsInfo)localObject1);
          localObject1 = new ArrayList();
          localObject2 = ((SnsObject)localObject2).SnsRedEnvelops.abEG;
          if (localObject2 != null)
          {
            int i = 0;
            while (i < ((List)localObject2).size())
            {
              fef localfef = (fef)((List)localObject2).get(i);
              com.tencent.mm.plugin.q.a.a locala = new com.tencent.mm.plugin.q.a.a();
              locala.sWX = localfef.Username;
              locala.Klv = localfef.CreateTime;
              locala.Klw = localfef.abDk;
              ((List)localObject1).add(locala);
              i += 1;
            }
          }
          com.tencent.mm.plugin.q.a.D(paramAnonymousString, (List)localObject1);
        }
        AppMethodBeat.o(308543);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100223);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if ((paramAnonymousView.getTag() instanceof SnsInfo))
        {
          paramAnonymousView = (SnsInfo)paramAnonymousView.getTag();
          if ((paramAnonymousView.getTypeFlag() == 21) && (com.tencent.mm.model.z.bAM().equals(paramAnonymousView.getUserName())))
          {
            paramAnonymousView.getTimeLine();
            com.tencent.mm.plugin.sns.lucky.a.m.A(paramAnonymousView);
            com.tencent.mm.plugin.sns.lucky.a.m.z(paramAnonymousView);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.rG(24);
          }
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_sendid", paramAnonymousView.getSnsId());
          ((Intent)localObject2).putExtra("key_feedid", paramAnonymousView.getLocalid());
          ((Intent)localObject2).setClassName(c.f(c.this), "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
          localObject1 = c.f(c.this);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = paramAnonymousView.getLocalid();
          paramAnonymousView.getSnsId();
          bbe((String)localObject1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100223);
      }
    };
    this.RQb = new c.16(this);
    this.RQc = new c.17(this);
    this.RQd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((paramAnonymousView.getTag() instanceof String))
        {
          paramAnonymousView = (String)paramAnonymousView.getTag();
          Log.d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(paramAnonymousView)));
          com.tencent.mm.plugin.sns.model.ap.akJ(com.tencent.mm.plugin.sns.storage.ai.bap(paramAnonymousView));
          com.tencent.mm.plugin.sns.model.ap.akI(com.tencent.mm.plugin.sns.storage.ai.bap(paramAnonymousView));
          com.tencent.mm.plugin.sns.model.al.hgx().hej();
          c.this.hlJ();
          if (c.n(c.this) != null) {
            c.n(c.this).hpD();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100226);
      }
    };
    this.RQe = new c.19(this);
    this.RQh = new d()
    {
      private static boolean c(com.tencent.mm.plugin.sns.ui.m paramAnonymousm)
      {
        AppMethodBeat.i(308535);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousm != null)
        {
          bool1 = bool2;
          if (paramAnonymousm.Qsv != null)
          {
            bool1 = bool2;
            if (!Util.isNullOrNil(paramAnonymousm.Qsv.abDm)) {
              bool1 = true;
            }
          }
        }
        AppMethodBeat.o(308535);
        return bool1;
      }
      
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(308542);
        int i;
        long l;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          if ((!com.tencent.mm.plugin.sns.ui.widget.g.lU(paramAnonymousView.Qsv.abDl, 64)) && ((!com.tencent.mm.plugin.sns.ui.widget.g.lU(paramAnonymousView.Qsv.abDl, 16)) || (paramAnonymousView.scene == 2)) && (!c(paramAnonymousView))) {
            paramAnonymousContextMenu.add(0, 11, 0, c.f(c.this).getString(b.j.app_copy));
          }
          if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE)) {
            break label468;
          }
          i = 1;
          if (((i != 0) && (!Util.isNullOrNil(paramAnonymousView.Rco)) && (paramAnonymousView.Rco.equals(com.tencent.mm.model.z.bAM()))) || ((paramAnonymousView.UserName != null) && (paramAnonymousView.UserName.equals(com.tencent.mm.model.z.bAM())))) {
            paramAnonymousContextMenu.add(0, 7, 0, c.f(c.this).getString(b.j.app_delete));
          }
          if ((!com.tencent.mm.plugin.sns.ui.widget.g.lU(paramAnonymousView.Qsv.abDl, 16)) && (!c(paramAnonymousView)))
          {
            paramAnonymousContextMenuInfo = paramAnonymousView.Rcm;
            StringBuilder localStringBuilder = new StringBuilder();
            if (paramAnonymousView.Qsv.abDh == 0) {
              break label501;
            }
            l = paramAnonymousView.Qsv.abDh;
            label241:
            paramAnonymousContextMenuInfo = av.mj(paramAnonymousContextMenuInfo, l);
            i = -1;
            if (paramAnonymousView.scene != 1) {
              break label513;
            }
            i = 2;
            label270:
            paramAnonymousContextMenuInfo = av.aYE(paramAnonymousContextMenuInfo);
            if ((paramAnonymousContextMenuInfo == null) || (!paramAnonymousContextMenuInfo.ooe) || (paramAnonymousContextMenuInfo.oss) || ((i & paramAnonymousContextMenuInfo.showFlag) == 0)) {
              break label527;
            }
            i = 1;
            label306:
            if (i != 0) {
              break label533;
            }
            av.a(paramAnonymousContextMenu, false);
          }
          label316:
          if ((((c.f(c.this) instanceof SnsTimeLineUI)) || ((c.f(c.this) instanceof SnsCommentDetailUI)) || ((c.f(c.this) instanceof SnsWsFoldDetailUI))) && (!aj.aBu()))
          {
            paramAnonymousContextMenu.add(0, 29, 0, c.f(c.this).getString(b.j.find_friends_search));
            paramAnonymousContextMenu = Util.nullAs(paramAnonymousView.nUB, "");
            i = 0;
            if (!(c.f(c.this) instanceof SnsCommentDetailUI)) {
              break label541;
            }
            i = 7;
          }
        }
        for (;;)
        {
          paramAnonymousView = com.tencent.mm.plugin.sns.storage.l.aZL(paramAnonymousView.Rcl);
          com.tencent.mm.plugin.websearch.api.as.a(1, com.tencent.mm.plugin.fts.a.d.We(77), 77, 0, "", "", t.uA(paramAnonymousView.field_snsId), 3, "", 0L, paramAnonymousContextMenu.length(), i, "", "", -1);
          AppMethodBeat.o(308542);
          return;
          label468:
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zfj, 1) == 1)
          {
            i = 1;
            break;
          }
          i = 0;
          break;
          label501:
          l = paramAnonymousView.Qsv.abDj;
          break label241;
          label513:
          if (paramAnonymousView.scene != 2) {
            break label270;
          }
          i = 4;
          break label270;
          label527:
          i = 0;
          break label306;
          label533:
          av.b(paramAnonymousContextMenu, false);
          break label316;
          label541:
          if ((c.f(c.this) instanceof SnsWsFoldDetailUI)) {
            i = 6;
          } else if ((c.f(c.this) instanceof SnsTimeLineUI)) {
            i = 7;
          }
        }
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(308544);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject = com.tencent.mm.plugin.sns.model.al.hgB().aZK(((com.tencent.mm.plugin.sns.ui.m)localObject).Rcm);
          c.this.RPU.a(paramAnonymousView, ((SnsInfo)localObject).getLocalid(), ((SnsInfo)localObject).getTimeLine());
          AppMethodBeat.o(308544);
          return true;
        }
        AppMethodBeat.o(308544);
        return false;
      }
    };
    this.DIP = new c.21(this);
    this.RQr = new c.22(this);
    this.RQu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100239);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        com.tencent.mm.plugin.sns.ui.s locals;
        Object localObject2;
        Object localObject3;
        String str1;
        int i;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          locals = (com.tencent.mm.plugin.sns.ui.s)paramAnonymousView.getTag();
          localObject2 = (dmz)locals.RcF.ContentObj.Zpr.get(0);
          localObject1 = locals.hES;
          com.tencent.mm.plugin.sns.model.al.hgB().aZK((String)localObject1);
          localObject1 = "";
          localObject3 = com.tencent.mm.plugin.sns.model.as.mg(com.tencent.mm.plugin.sns.model.al.getAccSnsPath(), ((dmz)localObject2).Id);
          str1 = "";
          String str2 = t.i((dmz)localObject2);
          if (y.ZC((String)localObject3 + str2))
          {
            localObject1 = (String)localObject3 + str2;
            str1 = (String)localObject3 + t.d((dmz)localObject2);
          }
          if (y.ZC((String)localObject3 + t.o((dmz)localObject2)))
          {
            localObject1 = (String)localObject3 + t.o((dmz)localObject2);
            str1 = (String)localObject3 + t.m((dmz)localObject2);
          }
          localObject2 = new int[2];
          localObject3 = paramAnonymousView.findViewById(b.f.content_preview);
          if (localObject3 == null) {
            break label536;
          }
          ((View)localObject3).getLocationInWindow((int[])localObject2);
          i = ((View)localObject3).getWidth();
        }
        for (int j = ((View)localObject3).getHeight();; j = paramAnonymousView.getHeight())
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(c.f(c.this), SnsOnlineVideoActivity.class);
          paramAnonymousView.putExtra("intent_videopath", (String)localObject1);
          paramAnonymousView.putExtra("intent_thumbpath", str1);
          paramAnonymousView.putExtra("intent_localid", locals.hES);
          paramAnonymousView.putExtra("intent_isad", false);
          paramAnonymousView.putExtra("intent_from_scene", c.j(c.this));
          paramAnonymousView.putExtra("img_gallery_left", localObject2[0]);
          paramAnonymousView.putExtra("img_gallery_top", localObject2[1]);
          paramAnonymousView.putExtra("img_gallery_width", i);
          paramAnonymousView.putExtra("img_gallery_height", j);
          localObject1 = c.f(c.this);
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousView.aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)paramAnonymousView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          c.f(c.this).overridePendingTransition(0, 0);
          c.a(c.this, locals.RcF);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100239);
          return;
          label536:
          paramAnonymousView.getLocationInWindow((int[])localObject2);
          i = paramAnonymousView.getWidth();
        }
      }
    };
    this.RQt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308555);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        Log.i("MicroMsg.TimelineClickListener", "onsight click");
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw)) {
          localObject1 = (com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag();
        }
        for (;;)
        {
          final SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((com.tencent.mm.plugin.sns.ui.aw)localObject1).hES);
          if (localSnsInfo == null)
          {
            Log.i("MicroMsg.TimelineClickListener", "onsight click but info is null localid %s", new Object[] { ((com.tencent.mm.plugin.sns.ui.aw)localObject1).hES });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(308555);
            return;
            if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
            {
              localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).Qcj;
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
              localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).Qcj;
            }
          }
          else
          {
            if (c.l(c.this) != null) {
              c.l(c.this).hgf().P(localSnsInfo);
            }
            final boolean bool = localSnsInfo.isAd();
            Object localObject2 = localSnsInfo.getAdXml();
            if ((bool) && (localObject2 != null) && ((((ADXml)localObject2).isCardAd()) || (((ADXml)localObject2).isFullCardAd())))
            {
              c.this.RQG.onClick(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(308555);
              return;
            }
            if ((bool) && (localObject2 != null)) {
              com.tencent.mm.plugin.sns.ad.d.b.P(c.f(c.this), ((ADXml)localObject2).appGiftPackCode, ((ADXml)localObject2).appGiftPackCodeTips);
            }
            final TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ui.aw)localObject1).RjK;
            if ((localTimeLineObject.ContentObj.Zpr == null) || (localTimeLineObject.ContentObj.Zpr.size() == 0))
            {
              Log.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(308555);
              return;
            }
            final dmz localdmz = (dmz)localTimeLineObject.ContentObj.Zpr.get(0);
            if (bool)
            {
              com.tencent.mm.plugin.sns.model.al.hgy();
              if (!com.tencent.mm.plugin.sns.model.g.u(localdmz))
              {
                if (!localSnsInfo.isBreakFrameAd())
                {
                  ((com.tencent.mm.plugin.sns.ui.aw)localObject1).PQu.setVisibility(8);
                  ((com.tencent.mm.plugin.sns.ui.aw)localObject1).RjP.setVisibility(0);
                  ((com.tencent.mm.plugin.sns.ui.aw)localObject1).RjP.jEN();
                }
                com.tencent.mm.plugin.sns.model.al.hgy().A(localdmz);
                paramAnonymousView = com.tencent.mm.plugin.sns.model.al.hgw();
                localObject1 = br.jbm();
                ((br)localObject1).time = localTimeLineObject.CreateTime;
                paramAnonymousView.a(localdmz, 4, null, (br)localObject1);
                if (bool) {
                  com.tencent.mm.plugin.sns.ad.g.p.a(com.tencent.mm.plugin.sns.ad.g.p.b.PXd, p.a.PWU, localSnsInfo, c.j(c.this));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(308555);
                return;
              }
            }
            if ((localSnsInfo.isAd()) && (localSnsInfo.getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(localSnsInfo.getAdSnsInfo().field_adxml))) {}
            int j;
            Object localObject3;
            for (int i = 1; (i == 0) && (bool) && (com.tencent.mm.plugin.sns.model.al.hgy().v(localdmz)); i = 0)
            {
              com.tencent.mm.plugin.sns.model.al.hgy().A(localdmz);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject1).PQu.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject1).RjP.setVisibility(8);
              paramAnonymousView = com.tencent.mm.plugin.sns.model.al.hgy();
              localObject2 = ((com.tencent.mm.plugin.sns.ui.aw)localObject1).RjM;
              i = c.f(c.this).hashCode();
              j = ((com.tencent.mm.plugin.sns.ui.aw)localObject1).position;
              localObject3 = br.jbm();
              ((br)localObject3).time = localTimeLineObject.CreateTime;
              paramAnonymousView.a(localSnsInfo, localdmz, (VideoSightView)localObject2, i, j, (br)localObject3, bool);
              ((com.tencent.mm.plugin.sns.ui.aw)localObject1).RjM.start();
              if (bool) {
                com.tencent.mm.plugin.sns.ad.g.p.a(com.tencent.mm.plugin.sns.ad.g.p.b.PXd, p.a.PWU, localSnsInfo, c.j(c.this));
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(308555);
              return;
            }
            com.tencent.mm.modelsns.l locall;
            label784:
            Object localObject4;
            if (c.j(c.this) == 0)
            {
              localObject2 = com.tencent.mm.modelsns.l.wO(717);
              ((com.tencent.mm.modelsns.l)localObject2).Ph(t.x(localSnsInfo)).wR(localSnsInfo.field_type).hm(localSnsInfo.isAd()).Ph(localSnsInfo.getUxinfo()).Ph(localdmz.Id);
              ((com.tencent.mm.modelsns.l)localObject2).bMH();
              if (c.j(c.this) != 0) {
                break label1540;
              }
              locall = com.tencent.mm.modelsns.l.wO(745);
              locall.Ph(t.x(localSnsInfo)).wR(localSnsInfo.field_type).hm(localSnsInfo.isAd());
              if ((bool) && ((!localSnsInfo.getAdXml().isLandingPagesAd()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(localSnsInfo.getAdSnsInfo().field_adxml)))) {
                com.tencent.mm.plugin.sns.ad.g.p.a(com.tencent.mm.plugin.sns.ad.g.p.b.PXd, p.a.PWV, localSnsInfo, c.j(c.this));
              }
              localObject2 = "";
              localObject4 = com.tencent.mm.plugin.sns.model.as.mg(com.tencent.mm.plugin.sns.model.al.getAccSnsPath(), localdmz.Id);
              localObject3 = "";
              localObject5 = t.i(localdmz);
              if (y.ZC((String)localObject4 + (String)localObject5))
              {
                localObject2 = (String)localObject4 + (String)localObject5;
                localObject3 = (String)localObject4 + t.d(localdmz);
              }
              if (y.ZC((String)localObject4 + t.o(localdmz)))
              {
                localObject2 = (String)localObject4 + t.o(localdmz);
                localObject3 = (String)localObject4 + t.m(localdmz);
              }
              localObject4 = new int[2];
              if (!com.tencent.mm.ui.aw.jkS()) {
                break label1551;
              }
              paramAnonymousView.getLocationOnScreen((int[])localObject4);
            }
            int k;
            for (;;)
            {
              j = paramAnonymousView.getWidth();
              k = paramAnonymousView.getHeight();
              com.tencent.mm.plugin.report.service.h.OAn.b(11444, new Object[] { Integer.valueOf(3) });
              if (bool) {
                break label1560;
              }
              Log.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
              paramAnonymousView = new Intent();
              paramAnonymousView.setClass(c.f(c.this), SnsOnlineVideoActivity.class);
              paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
              paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
              paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.aw)localObject1).hES);
              paramAnonymousView.putExtra("intent_isad", bool);
              paramAnonymousView.putExtra("intent_from_scene", c.j(c.this));
              paramAnonymousView.putExtra("sns_video_scene", ((com.tencent.mm.plugin.sns.ui.aw)localObject1).RjS);
              localObject2 = com.tencent.mm.plugin.sns.ui.helper.a.RKs;
              paramAnonymousView.putExtra("intent_third_sdk_msg", com.tencent.mm.plugin.sns.ui.helper.a.baW(((com.tencent.mm.plugin.sns.ui.aw)localObject1).RjK.actionInfo.YCC.YCn));
              paramAnonymousView.putExtra("intent_publish_id", t.uB(localSnsInfo.field_snsId));
              paramAnonymousView.putExtra("intent_bottom_height", com.tencent.mm.ui.bf.bk(c.f(c.this)));
              localObject2 = com.tencent.mm.plugin.sns.ui.video.e.hsu().bbq(localTimeLineObject.Id);
              if ((localObject2 != null) && (((SnsTimelineVideoView)localObject2).isPlaying()))
              {
                paramAnonymousView.putExtra("intent_fromplayingvideo", true);
                paramAnonymousView.putExtra("intent_fromplayingvideo_tlobjid", localTimeLineObject.Id);
                paramAnonymousView.putExtra("intent_session_id", ((SnsTimelineVideoView)localObject2).getSessionId());
                paramAnonymousView.putExtra("intent_session_timestamp", ((SnsTimelineVideoView)localObject2).getSessionTimestamp());
                if (((com.tencent.mm.plugin.sns.ui.aw)localObject1).RjL != null) {
                  ((com.tencent.mm.plugin.sns.ui.aw)localObject1).RjL.findViewById(b.f.thumb_mask).setVisibility(0);
                }
              }
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", j);
              paramAnonymousView.putExtra("img_gallery_height", k);
              locall.b(paramAnonymousView, "intent_key_StatisticsOplog");
              localObject1 = c.f(c.this);
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousView.aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Activity)localObject1).startActivity((Intent)paramAnonymousView.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              c.f(c.this).overridePendingTransition(0, 0);
              c.a(c.this, localSnsInfo.getTimeLine());
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(308555);
              return;
              localObject2 = com.tencent.mm.modelsns.l.wP(717);
              break;
              label1540:
              locall = com.tencent.mm.modelsns.l.wP(745);
              break label784;
              label1551:
              paramAnonymousView.getLocationInWindow((int[])localObject4);
            }
            label1560:
            Object localObject5 = c.a(c.this, localSnsInfo);
            if (com.tencent.mm.plugin.sns.data.m.a(c.f(c.this), localSnsInfo, (ADInfo)localObject5, c.j(c.this), c.this.RoZ, 21, 0))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(308555);
              return;
            }
            if ((localSnsInfo.isAd()) && (localSnsInfo.getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.aZJ(localSnsInfo.getAdSnsInfo().field_adxml)))
            {
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.T(localSnsInfo);
              if (!Util.isNullOrNil(paramAnonymousView)) {
                localSnsInfo.getAdSnsInfo().field_adxml = paramAnonymousView;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", j);
              paramAnonymousView.putExtra("img_gallery_height", k);
              paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localSnsInfo.getSnsId());
              paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localSnsInfo.getTimeLine().Id);
              paramAnonymousView.putExtra("sns_landing_pages_ux_info", localSnsInfo.getUxinfo());
              localObject1 = localSnsInfo.getTimeLine();
              if (localObject1 != null)
              {
                localObject1 = ((TimeLineObject)localObject1).ContentObj.Zpr;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((dmz)((List)localObject1).get(0)).aaTl);
                }
              }
              c.a(c.this, paramAnonymousView, localSnsInfo);
              paramAnonymousView.setClass(c.f(c.this), SnsAdNativeLandingPagesUI.class);
              i = 1;
              if (c.j(c.this) == 2)
              {
                i = 16;
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", localSnsInfo.getAdSnsInfo().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", localSnsInfo.getAdRecSrc());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
                if (!localSnsInfo.getAdXml().forbiddenCustomAnimation)
                {
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                  paramAnonymousView.putExtra("sns_landing_pages_is_normal_ad_animation", true);
                }
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject1 = c.f(c.this);
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousView.aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (!localSnsInfo.getAdXml().forbiddenCustomAnimation) {
                  c.f(c.this).overridePendingTransition(0, 0);
                }
                j = c.j(c.this);
                if (c.j(c.this) != 0) {
                  break label2157;
                }
                i = 1;
                label2085:
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 21, 21);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.RoZ, localSnsInfo, 21);
                t.a(paramAnonymousView);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(308555);
              return;
              if (c.j(c.this) != 1) {
                break;
              }
              i = 2;
              break;
              label2157:
              i = 2;
              break label2085;
              if ((localObject5 == null) || (!((ADInfo)localObject5).checkCurIndexCanJump(0))) {
                break label2194;
              }
              c.a(c.this, paramAnonymousView, localSnsInfo, (ADInfo)localObject5, 0, 8);
            }
            label2194:
            if ((localSnsInfo.isAd()) && (localSnsInfo.getAdInfo() != null) && (localSnsInfo.getAdInfo().isWeapp()))
            {
              c.a(c.this, localSnsInfo.getAdInfo(), localSnsInfo, false);
              j = c.j(c.this);
              if (c.j(c.this) == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 21, 31);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.RoZ, localSnsInfo, 21);
                t.a(paramAnonymousView);
                break;
              }
            }
            int m;
            if (localSnsInfo.isAd())
            {
              m = c.j(c.this);
              if (c.j(c.this) == 0)
              {
                i = 1;
                label2332:
                paramAnonymousView = new SnsAdClick(m, i, localSnsInfo.field_snsId, 17, 0);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.RoZ, localSnsInfo, 17);
                t.a(paramAnonymousView);
              }
            }
            else
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.setClass(c.f(c.this), SnsSightPlayerUI.class);
              paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
              paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
              paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.aw)localObject1).hES);
              paramAnonymousView.putExtra("intent_isad", bool);
              paramAnonymousView.putExtra("intent_from_scene", c.j(c.this));
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", j);
              paramAnonymousView.putExtra("img_gallery_height", k);
              locall.b(paramAnonymousView, "intent_key_StatisticsOplog");
              localObject2 = c.f(c.this);
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramAnonymousView.aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Activity)localObject2).startActivity((Intent)paramAnonymousView.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              c.f(c.this).overridePendingTransition(0, 0);
              new MMHandler().postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(308530);
                  if (com.tencent.mm.plugin.sns.model.al.hgy().v(localdmz))
                  {
                    this.RQT.RjM.e(null, false, 0);
                    com.tencent.mm.plugin.sns.model.g localg = com.tencent.mm.plugin.sns.model.al.hgy();
                    SnsInfo localSnsInfo = localSnsInfo;
                    dmz localdmz = localdmz;
                    VideoSightView localVideoSightView = this.RQT.RjM;
                    int i = c.f(c.this).hashCode();
                    int j = this.RQT.position;
                    br localbr = br.jbm();
                    localbr.time = localTimeLineObject.CreateTime;
                    localg.a(localSnsInfo, localdmz, localVideoSightView, i, j, localbr, bool);
                    this.RQT.RjM.start();
                    this.RQT.PQu.setVisibility(0);
                    this.RQT.RjP.setVisibility(8);
                    this.RQT.PQu.setImageDrawable(com.tencent.mm.cd.a.m(c.f(c.this), b.i.shortvideo_play_btn));
                  }
                  AppMethodBeat.o(308530);
                }
              }, 500L);
              paramAnonymousView = new int[3];
              if ((bool) || (com.tencent.mm.plugin.sns.model.al.hgy().a(localSnsInfo, paramAnonymousView) <= 5)) {
                break label2696;
              }
              com.tencent.mm.plugin.sns.model.al.hgy().z(localdmz);
              i = 1;
            }
            for (;;)
            {
              label2657:
              k = paramAnonymousView[0];
              m = paramAnonymousView[1];
              if (i == 2) {}
              for (j = 1;; j = 0)
              {
                c.a(localSnsInfo, i, k, m, j, paramAnonymousView[2]);
                break;
                i = 2;
                break label2332;
                label2696:
                if ((!bool) || (com.tencent.mm.plugin.sns.model.al.hgy().b(localSnsInfo, paramAnonymousView) <= 5)) {
                  break label2732;
                }
                com.tencent.mm.plugin.sns.model.al.hgy().z(localdmz);
                i = 1;
                break label2657;
              }
              label2732:
              i = 2;
            }
          }
          localObject1 = null;
        }
      }
    };
    this.RQk = new d()
    {
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(308540);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag();
          if (!paramAnonymousView.isAd) {
            paramAnonymousContextMenu.add(0, 19, 0, c.f(c.this).getString(b.j.chatting_long_click_menu_mute_play));
          }
          if (Util.safeParseInt(com.tencent.mm.k.i.aRC().getValue("SIGHTCannotTransmitForFav")) != 0) {
            break label308;
          }
          if (paramAnonymousView.RjK.ContentObj.Zpr.size() <= 0) {
            break label301;
          }
          paramAnonymousContextMenuInfo = (dmz)paramAnonymousView.RjK.ContentObj.Zpr.get(0);
          String str = paramAnonymousContextMenuInfo.Id;
          str = com.tencent.mm.plugin.sns.model.as.mg(com.tencent.mm.plugin.sns.model.al.getAccSnsPath(), str) + t.d(paramAnonymousContextMenuInfo);
          paramAnonymousContextMenuInfo = az.a(paramAnonymousView.hES, paramAnonymousContextMenuInfo);
          boolean bool1 = y.ZC(str);
          boolean bool2 = y.ZC(paramAnonymousContextMenuInfo);
          Log.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool1) || (!bool2)) {
            break label308;
          }
        }
        label301:
        label308:
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.br.c.blq("favorite")) {
            paramAnonymousContextMenu.add(0, 10, 0, c.f(c.this).getString(b.j.plugin_favorite_opt));
          }
          if (i != 0)
          {
            paramAnonymousContextMenuInfo = new ex();
            paramAnonymousContextMenuInfo.hFc.hES = paramAnonymousView.hES;
            paramAnonymousContextMenuInfo.publish();
            if (paramAnonymousContextMenuInfo.hFd.hEn) {
              paramAnonymousContextMenu.add(0, 18, 0, c.f(c.this).getString(b.j.app_open));
            }
          }
          AppMethodBeat.o(308540);
          return;
          Log.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
        }
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(308541);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag()).hES;
          SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(str);
          c.this.RPU.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(308541);
          return true;
        }
        AppMethodBeat.o(308541);
        return false;
      }
    };
    this.RQv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308537);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        c.this.jD(paramAnonymousView);
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.e)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308537);
          return;
        }
        localObject = (com.tencent.mm.plugin.sns.data.e)paramAnonymousView.getTag();
        paramAnonymousView = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((com.tencent.mm.plugin.sns.data.e)localObject).hES);
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308537);
          return;
        }
        int j;
        if (paramAnonymousView.isAd())
        {
          ((com.tencent.mm.plugin.sns.data.e)localObject).QmE = System.currentTimeMillis();
          j = c.j(c.this);
          if (c.j(c.this) != 0) {
            break label214;
          }
        }
        label214:
        for (int i = 1;; i = 2)
        {
          localObject = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 20, 0);
          com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject, c.this.RoZ, paramAnonymousView, 20);
          t.a((SnsAdClick)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308537);
          return;
        }
      }
    };
    this.RQC = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100244);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        Log.i("MicroMsg.TimelineClickListener", "unlike click");
        if (!(paramAnonymousAdapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c))
        {
          Log.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(100244);
          return;
        }
        Object localObject2 = (com.tencent.mm.plugin.sns.data.e)paramAnonymousView.getTag();
        SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(((com.tencent.mm.plugin.sns.data.e)localObject2).hES);
        if (localSnsInfo == null) {
          try
          {
            c.this.hlL();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          catch (Exception paramAnonymousAdapterView)
          {
            for (;;)
            {
              Log.e("MicroMsg.TimelineClickListener", "onUnLikeFinishError exp=" + paramAnonymousAdapterView.toString());
            }
          }
        }
        if (paramAnonymousInt == 0) {
          if (localSnsInfo.isAd())
          {
            localObject1 = c.a(c.this, localSnsInfo);
            if (localObject1 == null)
            {
              localObject1 = "";
              ((com.tencent.mm.plugin.sns.c.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.sns.c.d.class)).b(11855, localSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(3), localObject1, Integer.valueOf(localSnsInfo.getAdRecSrc()) });
            }
          }
          else
          {
            if (!((com.tencent.mm.plugin.sns.data.e)localObject2).QmD.RFi.adUnlikeInfo.hiz()) {
              break label404;
            }
            paramAnonymousView = (com.tencent.mm.plugin.sns.ui.c)paramAnonymousAdapterView.getAdapter();
            paramAnonymousView.rBp += 1;
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousAdapterView.setOnItemClickListener(c.this.RQD);
            c.this.hlK();
            paramAnonymousAdapterView = new ADInfo.c.a();
            paramAnonymousAdapterView.QHk = ADInfo.c.a.QHg;
            paramAnonymousAdapterView.QmE = ((com.tencent.mm.plugin.sns.data.e)localObject2).QmE;
            paramAnonymousAdapterView.QHn = 0L;
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.s(localSnsInfo.field_snsId, 8, paramAnonymousAdapterView);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousAdapterView, 0);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(100244);
          return;
          localObject1 = ((ADInfo)localObject1).viewId;
          break;
          label404:
          if (((com.tencent.mm.plugin.sns.data.e)localObject2).QmD.RFi.forbidClick)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          c.this.jE(paramAnonymousView);
          paramAnonymousAdapterView = new ADInfo.c.a();
          paramAnonymousAdapterView.QmE = ((com.tencent.mm.plugin.sns.data.e)localObject2).QmE;
          paramAnonymousAdapterView.QHn = System.currentTimeMillis();
          paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.s(localSnsInfo.field_snsId, 8, paramAnonymousAdapterView);
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousAdapterView, 0);
          continue;
          if (((com.tencent.mm.plugin.sns.data.e)localObject2).QmD.RFh.adFeedbackInfo == null)
          {
            Log.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          paramAnonymousAdapterView = ((com.tencent.mm.plugin.sns.data.e)localObject2).QmD.RFh.adFeedbackInfo;
          paramAnonymousInt -= 1;
          if (paramAnonymousInt < paramAnonymousAdapterView.list.size()) {
            paramAnonymousAdapterView = ((ADXml.f)paramAnonymousAdapterView.list.get(paramAnonymousInt)).url;
          }
          try
          {
            paramAnonymousView = String.format("snsid=%s", new Object[] { localSnsInfo.getTimeLine().Id });
            localObject1 = String.format("aid=%s", new Object[] { localSnsInfo.getAid() });
            localObject2 = String.format("traceid=%s", new Object[] { localSnsInfo.getTraceid() });
            com.tencent.mm.kernel.h.baC();
            paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.n(paramAnonymousAdapterView, new String[] { paramAnonymousView, localObject1, localObject2, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.b.aZs() }) });
            paramAnonymousAdapterView = paramAnonymousView;
          }
          catch (Exception paramAnonymousView)
          {
            label699:
            break label699;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView);
          paramAnonymousView.putExtra("useJs", true);
          paramAnonymousView.putExtra("KPublisherId", "sns_" + t.uA(localSnsInfo.field_snsId));
          paramAnonymousView.putExtra("pre_username", localSnsInfo.field_userName);
          paramAnonymousView.putExtra("prePublishId", "sns_" + t.uA(localSnsInfo.field_snsId));
          paramAnonymousView.putExtra("preUsername", localSnsInfo.field_userName);
          com.tencent.mm.plugin.sns.d.a.pFn.h(paramAnonymousView, c.f(c.this));
        }
      }
    };
    this.RQD = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(308536);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.e)))
        {
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.data.e)paramAnonymousView.getTag();
          if (paramAnonymousInt < paramAnonymousAdapterView.QmD.RFi.adUnlikeInfo.hiy().size())
          {
            if (paramAnonymousAdapterView.QmD.RFi.forbidClick)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(308536);
              return;
            }
            localObject = (ADInfo.c.a)paramAnonymousAdapterView.QmD.RFi.adUnlikeInfo.hiy().get(paramAnonymousInt);
            Log.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[] { ((ADInfo.c.a)localObject).QHh, Integer.valueOf(((ADInfo.c.a)localObject).QHk) });
            SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymousAdapterView.hES);
            if (localSnsInfo == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(308536);
              return;
            }
            c.this.jE(paramAnonymousView);
            ((ADInfo.c.a)localObject).QmE = paramAnonymousAdapterView.QmE;
            ((ADInfo.c.a)localObject).QHn = System.currentTimeMillis();
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.s(localSnsInfo.field_snsId, 8, localObject);
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousAdapterView, 0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(308536);
      }
    };
    this.RQB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163130);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          localObject = (TimeLineObject)paramAnonymousView.getTag();
          bvl localbvl = ((TimeLineObject)localObject).ContentObj.hKU;
          Intent localIntent = new Intent();
          localIntent.putExtra("feed_object_id", t.aXD(localbvl.objectId));
          localIntent.putExtra("feed_object_nonceId", localbvl.objectNonceId);
          localIntent.putExtra("business_type", 0);
          localIntent.putExtra("finder_user_name", localbvl.username);
          localIntent.putExtra("report_scene", 3);
          localIntent.putExtra("from_user", ((TimeLineObject)localObject).UserName);
          ((cn)com.tencent.mm.kernel.h.az(cn.class)).fillContextIdToIntent(4, 2, 25, localIntent);
          ((cn)com.tencent.mm.kernel.h.az(cn.class)).enterFinderShareFeedUI(paramAnonymousView.getContext(), localIntent);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163130);
      }
    };
    this.RQG = new View.OnClickListener()
    {
      /* Error */
      public final void onClick(View paramAnonymousView)
      {
        // Byte code:
        //   0: ldc 23
        //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: new 31	com/tencent/mm/hellhoundlib/b/b
        //   8: dup
        //   9: invokespecial 32	com/tencent/mm/hellhoundlib/b/b:<init>	()V
        //   12: astore 10
        //   14: aload 10
        //   16: aload_1
        //   17: invokevirtual 36	com/tencent/mm/hellhoundlib/b/b:cH	(Ljava/lang/Object;)V
        //   20: ldc 38
        //   22: ldc 39
        //   24: ldc 40
        //   26: ldc 41
        //   28: aload_0
        //   29: aload 10
        //   31: invokevirtual 45	com/tencent/mm/hellhoundlib/b/b:aYj	()[Ljava/lang/Object;
        //   34: invokestatic 51	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
        //   37: aload_1
        //   38: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   41: ifnull +53 -> 94
        //   44: aload_1
        //   45: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   48: instanceof 59
        //   51: ifne +61 -> 112
        //   54: aload_1
        //   55: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   58: instanceof 61
        //   61: ifne +51 -> 112
        //   64: aload_1
        //   65: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   68: instanceof 63
        //   71: ifne +41 -> 112
        //   74: aload_1
        //   75: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   78: instanceof 65
        //   81: ifne +31 -> 112
        //   84: aload_1
        //   85: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   88: instanceof 67
        //   91: ifne +21 -> 112
        //   94: aload_0
        //   95: ldc 38
        //   97: ldc 39
        //   99: ldc 40
        //   101: ldc 41
        //   103: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   106: ldc 23
        //   108: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   111: return
        //   112: aconst_null
        //   113: astore 10
        //   115: iconst_0
        //   116: istore 5
        //   118: iconst_0
        //   119: istore_3
        //   120: iconst_0
        //   121: istore 6
        //   123: iconst_0
        //   124: istore 4
        //   126: iconst_0
        //   127: istore_2
        //   128: aload_1
        //   129: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   132: instanceof 61
        //   135: ifeq +108 -> 243
        //   138: aload_1
        //   139: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   142: checkcast 61	com/tencent/mm/plugin/sns/ui/bf
        //   145: getfield 78	com/tencent/mm/plugin/sns/ui/bf:hHB	Ljava/lang/String;
        //   148: invokestatic 84	com/tencent/mm/plugin/sns/storage/l:aZL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
        //   151: astore 11
        //   153: aload_1
        //   154: instanceof 86
        //   157: ifeq +76 -> 233
        //   160: iconst_0
        //   161: istore_2
        //   162: aload_1
        //   163: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   166: checkcast 61	com/tencent/mm/plugin/sns/ui/bf
        //   169: getfield 90	com/tencent/mm/plugin/sns/ui/bf:RjT	Z
        //   172: ifeq +5115 -> 5287
        //   175: aload_1
        //   176: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   179: checkcast 61	com/tencent/mm/plugin/sns/ui/bf
        //   182: getfield 94	com/tencent/mm/plugin/sns/ui/bf:index	I
        //   185: istore 4
        //   187: iload 4
        //   189: ifle +49 -> 238
        //   192: iconst_2
        //   193: istore_3
        //   194: iload_2
        //   195: istore 5
        //   197: iload_3
        //   198: istore_2
        //   199: iload 5
        //   201: istore_3
        //   202: aload 11
        //   204: ifnull +11 -> 215
        //   207: aload 11
        //   209: invokevirtual 100	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
        //   212: ifne +331 -> 543
        //   215: aload_0
        //   216: ldc 38
        //   218: ldc 39
        //   220: ldc 40
        //   222: ldc 41
        //   224: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   227: ldc 23
        //   229: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   232: return
        //   233: iconst_1
        //   234: istore_2
        //   235: goto -73 -> 162
        //   238: iconst_1
        //   239: istore_3
        //   240: goto -46 -> 194
        //   243: aload_1
        //   244: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   247: instanceof 65
        //   250: ifeq +77 -> 327
        //   253: aload_1
        //   254: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   257: checkcast 65	com/tencent/mm/plugin/sns/ui/MaskImageView
        //   260: astore 11
        //   262: aload 11
        //   264: invokevirtual 101	com/tencent/mm/plugin/sns/ui/MaskImageView:getTag	()Ljava/lang/Object;
        //   267: instanceof 61
        //   270: ifeq +5012 -> 5282
        //   273: aload 11
        //   275: invokevirtual 101	com/tencent/mm/plugin/sns/ui/MaskImageView:getTag	()Ljava/lang/Object;
        //   278: checkcast 61	com/tencent/mm/plugin/sns/ui/bf
        //   281: getfield 78	com/tencent/mm/plugin/sns/ui/bf:hHB	Ljava/lang/String;
        //   284: invokestatic 84	com/tencent/mm/plugin/sns/storage/l:aZL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
        //   287: astore 11
        //   289: aload 11
        //   291: astore 10
        //   293: iload 6
        //   295: istore_3
        //   296: aload_1
        //   297: instanceof 86
        //   300: ifne +158 -> 458
        //   303: iconst_1
        //   304: istore_2
        //   305: aload 11
        //   307: astore 10
        //   309: iconst_0
        //   310: istore 5
        //   312: iconst_0
        //   313: istore 4
        //   315: iload_2
        //   316: istore_3
        //   317: iload 5
        //   319: istore_2
        //   320: aload 10
        //   322: astore 11
        //   324: goto -122 -> 202
        //   327: aload_1
        //   328: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   331: instanceof 63
        //   334: ifeq +69 -> 403
        //   337: aload_1
        //   338: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   341: checkcast 63	com/tencent/mm/plugin/sns/ui/aw
        //   344: astore 10
        //   346: invokestatic 107	com/tencent/mm/plugin/sns/model/al:hgB	()Lcom/tencent/mm/plugin/sns/storage/w;
        //   349: aload 10
        //   351: getfield 110	com/tencent/mm/plugin/sns/ui/aw:hES	Ljava/lang/String;
        //   354: invokevirtual 113	com/tencent/mm/plugin/sns/storage/w:aZL	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
        //   357: astore 11
        //   359: aload_1
        //   360: instanceof 86
        //   363: ifeq +30 -> 393
        //   366: iconst_0
        //   367: istore_3
        //   368: aload 10
        //   370: getfield 114	com/tencent/mm/plugin/sns/ui/aw:RjT	Z
        //   373: ifeq +4900 -> 5273
        //   376: aload 10
        //   378: getfield 117	com/tencent/mm/plugin/sns/ui/aw:RjU	I
        //   381: istore 4
        //   383: iload 4
        //   385: ifle +13 -> 398
        //   388: iconst_2
        //   389: istore_2
        //   390: goto -188 -> 202
        //   393: iconst_1
        //   394: istore_3
        //   395: goto -27 -> 368
        //   398: iconst_1
        //   399: istore_2
        //   400: goto -10 -> 390
        //   403: aload_1
        //   404: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   407: instanceof 59
        //   410: ifeq +65 -> 475
        //   413: aload_1
        //   414: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   417: checkcast 59	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder
        //   420: astore 11
        //   422: aload 11
        //   424: getfield 120	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder:hQX	Ljava/lang/String;
        //   427: invokestatic 123	com/tencent/mm/plugin/sns/storage/l:aZK	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
        //   430: astore 10
        //   432: aload 11
        //   434: instanceof 125
        //   437: ifeq +4831 -> 5268
        //   440: aload 11
        //   442: checkcast 125	com/tencent/mm/plugin/sns/ui/item/p$b
        //   445: getfield 129	com/tencent/mm/plugin/sns/ui/item/p$b:RNC	Lcom/tencent/mm/plugin/sns/ui/item/p$a;
        //   448: getfield 132	com/tencent/mm/plugin/sns/ui/item/p$a:index	I
        //   451: istore_3
        //   452: iload_3
        //   453: ifle +17 -> 470
        //   456: iconst_2
        //   457: istore_2
        //   458: iload_3
        //   459: istore 4
        //   461: iconst_0
        //   462: istore_3
        //   463: aload 10
        //   465: astore 11
        //   467: goto -265 -> 202
        //   470: iconst_1
        //   471: istore_2
        //   472: goto -14 -> 458
        //   475: aload_1
        //   476: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   479: instanceof 67
        //   482: ifeq +4777 -> 5259
        //   485: aload_1
        //   486: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   489: checkcast 67	com/tencent/mm/plugin/sns/ui/c/a/b
        //   492: getfield 136	com/tencent/mm/plugin/sns/ui/c/a/b:PNI	Lcom/tencent/mm/plugin/sns/storage/SnsInfo;
        //   495: astore 11
        //   497: aload 11
        //   499: astore 10
        //   501: iload 6
        //   503: istore_3
        //   504: aload_1
        //   505: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   508: instanceof 138
        //   511: ifeq -53 -> 458
        //   514: aload_1
        //   515: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   518: checkcast 138	com/tencent/mm/plugin/sns/ui/c/a/h
        //   521: getfield 141	com/tencent/mm/plugin/sns/ui/c/a/h:currentIndex	I
        //   524: istore_3
        //   525: iload_3
        //   526: ifle +12 -> 538
        //   529: iconst_2
        //   530: istore_2
        //   531: aload 11
        //   533: astore 10
        //   535: goto -77 -> 458
        //   538: iconst_1
        //   539: istore_2
        //   540: goto -9 -> 531
        //   543: aload_0
        //   544: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   547: aload 11
        //   549: invokestatic 144	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/listener/c;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
        //   552: astore 10
        //   554: aload 10
        //   556: ifnonnull +440 -> 996
        //   559: ldc 146
        //   561: astore 10
        //   563: aload 11
        //   565: invokevirtual 150	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
        //   568: getfield 155	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
        //   571: astore 12
        //   573: aload 11
        //   575: invokevirtual 158	com/tencent/mm/plugin/sns/storage/SnsInfo:isRecExpAd	()Z
        //   578: ifne +64 -> 642
        //   581: getstatic 164	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   584: astore 13
        //   586: aload_0
        //   587: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   590: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   593: ifne +413 -> 1006
        //   596: iconst_1
        //   597: istore 5
        //   599: iload_3
        //   600: ifeq +412 -> 1012
        //   603: iconst_1
        //   604: istore_3
        //   605: aload 13
        //   607: sipush 14066
        //   610: iconst_4
        //   611: anewarray 4	java/lang/Object
        //   614: dup
        //   615: iconst_0
        //   616: iload 5
        //   618: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   621: aastore
        //   622: dup
        //   623: iconst_1
        //   624: iload_3
        //   625: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   628: aastore
        //   629: dup
        //   630: iconst_2
        //   631: aload 12
        //   633: aastore
        //   634: dup
        //   635: iconst_3
        //   636: aload 10
        //   638: aastore
        //   639: invokevirtual 178	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
        //   642: aload 11
        //   644: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   647: astore 10
        //   649: aload 11
        //   651: invokevirtual 100	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
        //   654: ifeq +36 -> 690
        //   657: aload 10
        //   659: ifnull +31 -> 690
        //   662: aload 10
        //   664: invokevirtual 187	com/tencent/mm/plugin/sns/storage/ADXml:isFullCardAd	()Z
        //   667: ifne +23 -> 690
        //   670: aload_0
        //   671: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   674: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   677: aload 10
        //   679: getfield 194	com/tencent/mm/plugin/sns/storage/ADXml:appGiftPackCode	Ljava/lang/String;
        //   682: aload 10
        //   684: getfield 197	com/tencent/mm/plugin/sns/storage/ADXml:appGiftPackCodeTips	Ljava/lang/String;
        //   687: invokestatic 203	com/tencent/mm/plugin/sns/ad/d/b:P	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
        //   690: aload 11
        //   692: aload_0
        //   693: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   696: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   699: invokestatic 208	com/tencent/mm/plugin/sns/ui/ay:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Landroid/content/Context;)Z
        //   702: ifeq +55 -> 757
        //   705: aload 11
        //   707: ifnull +50 -> 757
        //   710: aload 11
        //   712: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   715: invokevirtual 211	com/tencent/mm/plugin/sns/storage/ADXml:hasActionBtn	()Z
        //   718: ifeq +39 -> 757
        //   721: aload_0
        //   722: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   725: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   728: ifne +321 -> 1049
        //   731: iconst_1
        //   732: istore_3
        //   733: aload 11
        //   735: ifnull +319 -> 1054
        //   738: aload 11
        //   740: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   743: lstore 7
        //   745: aload 11
        //   747: iload_3
        //   748: iload_3
        //   749: lload 7
        //   751: invokestatic 221	com/tencent/mm/plugin/sns/ui/ay$c:bc	(IJ)I
        //   754: invokestatic 224	com/tencent/mm/plugin/sns/ui/ay:b	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;II)V
        //   757: aload 11
        //   759: invokevirtual 228	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdSnsInfo	()Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
        //   762: invokevirtual 231	com/tencent/mm/plugin/sns/storage/AdSnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   765: invokevirtual 234	com/tencent/mm/plugin/sns/storage/ADXml:hasVoteInfo	()Z
        //   768: ifeq +53 -> 821
        //   771: aload 11
        //   773: invokevirtual 228	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdSnsInfo	()Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
        //   776: invokevirtual 231	com/tencent/mm/plugin/sns/storage/AdSnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   779: invokevirtual 238	com/tencent/mm/plugin/sns/storage/ADXml:getAdVoteComponentUrl	()Ljava/lang/String;
        //   782: astore 10
        //   784: aload 11
        //   786: invokevirtual 241	com/tencent/mm/plugin/sns/storage/SnsInfo:getUxinfo	()Ljava/lang/String;
        //   789: astore 12
        //   791: invokestatic 247	com/tencent/mm/kernel/h:baC	()Lcom/tencent/mm/kernel/b;
        //   794: pop
        //   795: invokestatic 252	com/tencent/mm/kernel/b:aZs	()Ljava/lang/String;
        //   798: astore 13
        //   800: aload 10
        //   802: aload 12
        //   804: aload 13
        //   806: aload 10
        //   808: aload 12
        //   810: aload 13
        //   812: invokestatic 258	com/tencent/mm/plugin/sns/storage/ai:be	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
        //   815: iconst_0
        //   816: ldc 146
        //   818: invokestatic 261	com/tencent/mm/plugin/sns/storage/ai:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V
        //   821: aload 11
        //   823: invokevirtual 150	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
        //   826: astore 14
        //   828: aload 14
        //   830: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   833: getfield 270	com/tencent/mm/protocal/protobuf/agh:Zpq	I
        //   836: bipush 15
        //   838: if_icmpne +12 -> 850
        //   841: aload 14
        //   843: getfield 273	com/tencent/mm/protocal/protobuf/TimeLineObject:sightFolded	I
        //   846: iconst_1
        //   847: if_icmpne +56 -> 903
        //   850: aload 14
        //   852: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   855: getfield 270	com/tencent/mm/protocal/protobuf/agh:Zpq	I
        //   858: bipush 27
        //   860: if_icmpne +2484 -> 3344
        //   863: aload 14
        //   865: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   868: getfield 277	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
        //   871: invokevirtual 283	java/util/LinkedList:size	()I
        //   874: iload 4
        //   876: if_icmple +2468 -> 3344
        //   879: aload 14
        //   881: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   884: getfield 277	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
        //   887: iload 4
        //   889: invokevirtual 287	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   892: checkcast 289	com/tencent/mm/protocal/protobuf/dmz
        //   895: getfield 292	com/tencent/mm/protocal/protobuf/dmz:vhJ	I
        //   898: bipush 6
        //   900: if_icmpne +2444 -> 3344
        //   903: ldc_w 294
        //   906: ldc_w 296
        //   909: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   912: aload_1
        //   913: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   916: instanceof 63
        //   919: ifeq +4334 -> 5253
        //   922: aload_1
        //   923: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   926: checkcast 63	com/tencent/mm/plugin/sns/ui/aw
        //   929: astore 10
        //   931: aload_1
        //   932: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   935: instanceof 59
        //   938: ifeq +132 -> 1070
        //   941: aload_1
        //   942: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   945: checkcast 59	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder
        //   948: astore 12
        //   950: aload 14
        //   952: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   955: getfield 270	com/tencent/mm/protocal/protobuf/agh:Zpq	I
        //   958: bipush 27
        //   960: if_icmpne +100 -> 1060
        //   963: aload 12
        //   965: checkcast 125	com/tencent/mm/plugin/sns/ui/item/p$b
        //   968: getfield 305	com/tencent/mm/plugin/sns/ui/item/p$b:RND	Lcom/tencent/mm/plugin/sns/ui/aw;
        //   971: astore 10
        //   973: aload 11
        //   975: ifnonnull +123 -> 1098
        //   978: aload_0
        //   979: ldc 38
        //   981: ldc 39
        //   983: ldc 40
        //   985: ldc 41
        //   987: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   990: ldc 23
        //   992: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   995: return
        //   996: aload 10
        //   998: getfield 310	com/tencent/mm/plugin/sns/storage/ADInfo:viewId	Ljava/lang/String;
        //   1001: astore 10
        //   1003: goto -440 -> 563
        //   1006: iconst_2
        //   1007: istore 5
        //   1009: goto -410 -> 599
        //   1012: iconst_2
        //   1013: istore_3
        //   1014: goto -409 -> 605
        //   1017: astore 10
        //   1019: ldc_w 294
        //   1022: new 312	java/lang/StringBuilder
        //   1025: dup
        //   1026: ldc_w 314
        //   1029: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   1032: aload 10
        //   1034: invokevirtual 320	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   1037: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   1040: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   1043: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1046: goto -404 -> 642
        //   1049: iconst_2
        //   1050: istore_3
        //   1051: goto -318 -> 733
        //   1054: lconst_0
        //   1055: lstore 7
        //   1057: goto -312 -> 745
        //   1060: aload 12
        //   1062: getfield 333	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
        //   1065: astore 10
        //   1067: goto -94 -> 973
        //   1070: aload_1
        //   1071: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   1074: instanceof 67
        //   1077: ifeq +4170 -> 5247
        //   1080: aload_1
        //   1081: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   1084: checkcast 67	com/tencent/mm/plugin/sns/ui/c/a/b
        //   1087: getfield 334	com/tencent/mm/plugin/sns/ui/c/a/b:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
        //   1090: astore 10
        //   1092: aconst_null
        //   1093: astore 12
        //   1095: goto -122 -> 973
        //   1098: aload_0
        //   1099: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1102: invokestatic 338	com/tencent/mm/plugin/sns/ui/listener/c:l	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Lcom/tencent/mm/plugin/sns/model/ak;
        //   1105: ifnull +20 -> 1125
        //   1108: aload_0
        //   1109: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1112: invokestatic 338	com/tencent/mm/plugin/sns/ui/listener/c:l	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Lcom/tencent/mm/plugin/sns/model/ak;
        //   1115: invokeinterface 344 1 0
        //   1120: aload 11
        //   1122: invokevirtual 349	com/tencent/mm/plugin/sns/statistics/e:P	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
        //   1125: aload 11
        //   1127: invokevirtual 100	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
        //   1130: istore 9
        //   1132: aload 14
        //   1134: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   1137: getfield 277	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
        //   1140: ifnull +17 -> 1157
        //   1143: aload 14
        //   1145: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   1148: getfield 277	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
        //   1151: invokevirtual 283	java/util/LinkedList:size	()I
        //   1154: ifne +30 -> 1184
        //   1157: ldc_w 294
        //   1160: ldc_w 351
        //   1163: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   1166: aload_0
        //   1167: ldc 38
        //   1169: ldc 39
        //   1171: ldc 40
        //   1173: ldc 41
        //   1175: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   1178: ldc 23
        //   1180: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1183: return
        //   1184: aload 14
        //   1186: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   1189: getfield 277	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
        //   1192: iload 4
        //   1194: invokevirtual 287	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   1197: checkcast 289	com/tencent/mm/protocal/protobuf/dmz
        //   1200: astore 15
        //   1202: iload 9
        //   1204: ifeq +134 -> 1338
        //   1207: invokestatic 355	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
        //   1210: pop
        //   1211: aload 15
        //   1213: invokestatic 361	com/tencent/mm/plugin/sns/model/g:u	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
        //   1216: ifne +122 -> 1338
        //   1219: aload 10
        //   1221: ifnull +117 -> 1338
        //   1224: aload 11
        //   1226: invokevirtual 364	com/tencent/mm/plugin/sns/storage/SnsInfo:isBreakFrameAd	()Z
        //   1229: ifne +30 -> 1259
        //   1232: aload 10
        //   1234: getfield 368	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
        //   1237: bipush 8
        //   1239: invokevirtual 373	android/widget/ImageView:setVisibility	(I)V
        //   1242: aload 10
        //   1244: getfield 377	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
        //   1247: iconst_0
        //   1248: invokevirtual 380	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
        //   1251: aload 10
        //   1253: getfield 377	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
        //   1256: invokevirtual 383	com/tencent/mm/ui/widget/MMPinProgressBtn:jEN	()V
        //   1259: invokestatic 355	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
        //   1262: aload 15
        //   1264: invokevirtual 387	com/tencent/mm/plugin/sns/model/g:A	(Lcom/tencent/mm/protocal/protobuf/dmz;)V
        //   1267: invokestatic 391	com/tencent/mm/plugin/sns/model/al:hgw	()Lcom/tencent/mm/plugin/sns/model/c;
        //   1270: astore_1
        //   1271: invokestatic 397	com/tencent/mm/storage/br:jbm	()Lcom/tencent/mm/storage/br;
        //   1274: astore 10
        //   1276: aload 10
        //   1278: aload 14
        //   1280: getfield 400	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
        //   1283: putfield 403	com/tencent/mm/storage/br:time	I
        //   1286: aload_1
        //   1287: aload 15
        //   1289: iconst_4
        //   1290: aconst_null
        //   1291: aload 10
        //   1293: invokevirtual 408	com/tencent/mm/plugin/sns/model/c:a	(Lcom/tencent/mm/protocal/protobuf/dmz;ILcom/tencent/mm/plugin/sns/data/p;Lcom/tencent/mm/storage/br;)Z
        //   1296: pop
        //   1297: iload 9
        //   1299: ifeq +21 -> 1320
        //   1302: getstatic 414	com/tencent/mm/plugin/sns/ad/g/p$b:PXd	Lcom/tencent/mm/plugin/sns/ad/g/p$b;
        //   1305: getstatic 420	com/tencent/mm/plugin/sns/ad/g/p$a:PWU	Lcom/tencent/mm/plugin/sns/ad/g/p$a;
        //   1308: aload 11
        //   1310: aload_0
        //   1311: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1314: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   1317: invokestatic 425	com/tencent/mm/plugin/sns/ad/g/p:a	(Lcom/tencent/mm/plugin/sns/ad/g/p$b;Lcom/tencent/mm/plugin/sns/ad/g/p$a;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
        //   1320: aload_0
        //   1321: ldc 38
        //   1323: ldc 39
        //   1325: ldc 40
        //   1327: ldc 41
        //   1329: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   1332: ldc 23
        //   1334: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1337: return
        //   1338: aload 11
        //   1340: invokevirtual 100	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
        //   1343: ifeq +219 -> 1562
        //   1346: aload 11
        //   1348: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   1351: invokevirtual 428	com/tencent/mm/plugin/sns/storage/ADXml:isLandingPagesAd	()Z
        //   1354: ifeq +208 -> 1562
        //   1357: aload 11
        //   1359: invokevirtual 228	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdSnsInfo	()Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
        //   1362: getfield 431	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_adxml	Ljava/lang/String;
        //   1365: astore 16
        //   1367: iload 4
        //   1369: ifle +185 -> 1554
        //   1372: ldc_w 433
        //   1375: astore 13
        //   1377: aload 16
        //   1379: aload 13
        //   1381: invokestatic 439	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/l:mL	(Ljava/lang/String;Ljava/lang/String;)Z
        //   1384: ifeq +178 -> 1562
        //   1387: iconst_1
        //   1388: istore 5
        //   1390: iload 5
        //   1392: ifne +176 -> 1568
        //   1395: iload 9
        //   1397: ifeq +171 -> 1568
        //   1400: invokestatic 355	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
        //   1403: aload 15
        //   1405: invokevirtual 442	com/tencent/mm/plugin/sns/model/g:v	(Lcom/tencent/mm/protocal/protobuf/dmz;)Z
        //   1408: ifeq +160 -> 1568
        //   1411: aload 10
        //   1413: ifnull +155 -> 1568
        //   1416: invokestatic 355	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
        //   1419: aload 15
        //   1421: invokevirtual 387	com/tencent/mm/plugin/sns/model/g:A	(Lcom/tencent/mm/protocal/protobuf/dmz;)V
        //   1424: aload 10
        //   1426: getfield 368	com/tencent/mm/plugin/sns/ui/aw:PQu	Landroid/widget/ImageView;
        //   1429: bipush 8
        //   1431: invokevirtual 373	android/widget/ImageView:setVisibility	(I)V
        //   1434: aload 10
        //   1436: getfield 377	com/tencent/mm/plugin/sns/ui/aw:RjP	Lcom/tencent/mm/ui/widget/MMPinProgressBtn;
        //   1439: bipush 8
        //   1441: invokevirtual 380	com/tencent/mm/ui/widget/MMPinProgressBtn:setVisibility	(I)V
        //   1444: invokestatic 355	com/tencent/mm/plugin/sns/model/al:hgy	()Lcom/tencent/mm/plugin/sns/model/g;
        //   1447: astore_1
        //   1448: aload 10
        //   1450: getfield 446	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
        //   1453: astore 12
        //   1455: aload_0
        //   1456: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1459: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   1462: invokevirtual 449	java/lang/Object:hashCode	()I
        //   1465: istore_2
        //   1466: aload 10
        //   1468: getfield 452	com/tencent/mm/plugin/sns/ui/aw:position	I
        //   1471: istore_3
        //   1472: invokestatic 397	com/tencent/mm/storage/br:jbm	()Lcom/tencent/mm/storage/br;
        //   1475: astore 13
        //   1477: aload 13
        //   1479: aload 14
        //   1481: getfield 400	com/tencent/mm/protocal/protobuf/TimeLineObject:CreateTime	I
        //   1484: putfield 403	com/tencent/mm/storage/br:time	I
        //   1487: aload_1
        //   1488: aload 11
        //   1490: aload 15
        //   1492: aload 12
        //   1494: iload_2
        //   1495: iload_3
        //   1496: aload 13
        //   1498: iload 9
        //   1500: invokevirtual 455	com/tencent/mm/plugin/sns/model/g:a	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/protocal/protobuf/dmz;Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;IILcom/tencent/mm/storage/br;Z)Z
        //   1503: pop
        //   1504: aload 10
        //   1506: getfield 446	com/tencent/mm/plugin/sns/ui/aw:RjM	Lcom/tencent/mm/pluginsdk/ui/tools/VideoSightView;
        //   1509: invokevirtual 460	com/tencent/mm/pluginsdk/ui/tools/VideoSightView:start	()Z
        //   1512: pop
        //   1513: iload 9
        //   1515: ifeq +21 -> 1536
        //   1518: getstatic 414	com/tencent/mm/plugin/sns/ad/g/p$b:PXd	Lcom/tencent/mm/plugin/sns/ad/g/p$b;
        //   1521: getstatic 420	com/tencent/mm/plugin/sns/ad/g/p$a:PWU	Lcom/tencent/mm/plugin/sns/ad/g/p$a;
        //   1524: aload 11
        //   1526: aload_0
        //   1527: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1530: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   1533: invokestatic 425	com/tencent/mm/plugin/sns/ad/g/p:a	(Lcom/tencent/mm/plugin/sns/ad/g/p$b;Lcom/tencent/mm/plugin/sns/ad/g/p$a;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
        //   1536: aload_0
        //   1537: ldc 38
        //   1539: ldc 39
        //   1541: ldc 40
        //   1543: ldc 41
        //   1545: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   1548: ldc 23
        //   1550: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1553: return
        //   1554: ldc_w 462
        //   1557: astore 13
        //   1559: goto -182 -> 1377
        //   1562: iconst_0
        //   1563: istore 5
        //   1565: goto -175 -> 1390
        //   1568: aload_0
        //   1569: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1572: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   1575: ifne +268 -> 1843
        //   1578: sipush 717
        //   1581: invokestatic 468	com/tencent/mm/modelsns/l:wO	(I)Lcom/tencent/mm/modelsns/l;
        //   1584: astore 10
        //   1586: aload 10
        //   1588: aload 11
        //   1590: invokestatic 474	com/tencent/mm/plugin/sns/data/t:x	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Ljava/lang/String;
        //   1593: invokevirtual 478	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
        //   1596: aload 11
        //   1598: getfield 481	com/tencent/mm/plugin/sns/storage/SnsInfo:field_type	I
        //   1601: invokevirtual 484	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
        //   1604: aload 11
        //   1606: invokevirtual 100	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
        //   1609: invokevirtual 488	com/tencent/mm/modelsns/l:hm	(Z)Lcom/tencent/mm/modelsns/l;
        //   1612: aload 11
        //   1614: invokevirtual 241	com/tencent/mm/plugin/sns/storage/SnsInfo:getUxinfo	()Ljava/lang/String;
        //   1617: invokevirtual 478	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
        //   1620: aload 15
        //   1622: getfield 489	com/tencent/mm/protocal/protobuf/dmz:Id	Ljava/lang/String;
        //   1625: invokevirtual 478	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
        //   1628: pop
        //   1629: aload 10
        //   1631: invokevirtual 492	com/tencent/mm/modelsns/l:bMH	()Z
        //   1634: pop
        //   1635: aload_0
        //   1636: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1639: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   1642: ifne +212 -> 1854
        //   1645: sipush 745
        //   1648: invokestatic 468	com/tencent/mm/modelsns/l:wO	(I)Lcom/tencent/mm/modelsns/l;
        //   1651: astore 10
        //   1653: aload 10
        //   1655: aload 11
        //   1657: invokestatic 474	com/tencent/mm/plugin/sns/data/t:x	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Ljava/lang/String;
        //   1660: invokevirtual 478	com/tencent/mm/modelsns/l:Ph	(Ljava/lang/String;)Lcom/tencent/mm/modelsns/l;
        //   1663: aload 11
        //   1665: getfield 481	com/tencent/mm/plugin/sns/storage/SnsInfo:field_type	I
        //   1668: invokevirtual 484	com/tencent/mm/modelsns/l:wR	(I)Lcom/tencent/mm/modelsns/l;
        //   1671: aload 11
        //   1673: invokevirtual 100	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
        //   1676: invokevirtual 488	com/tencent/mm/modelsns/l:hm	(Z)Lcom/tencent/mm/modelsns/l;
        //   1679: pop
        //   1680: iconst_2
        //   1681: newarray int
        //   1683: astore 10
        //   1685: iconst_0
        //   1686: istore_2
        //   1687: aload 12
        //   1689: ifnull +280 -> 1969
        //   1692: aload 12
        //   1694: instanceof 494
        //   1697: ifeq +168 -> 1865
        //   1700: aload 12
        //   1702: checkcast 494	com/tencent/mm/plugin/sns/ui/item/f$a
        //   1705: astore 12
        //   1707: aload 12
        //   1709: getfield 498	com/tencent/mm/plugin/sns/ui/item/f$a:RMK	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
        //   1712: getfield 504	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Cxb	Landroid/view/View;
        //   1715: ifnull +3527 -> 5242
        //   1718: aload 12
        //   1720: getfield 498	com/tencent/mm/plugin/sns/ui/item/f$a:RMK	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
        //   1723: getfield 504	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Cxb	Landroid/view/View;
        //   1726: aload 10
        //   1728: invokevirtual 508	android/view/View:getLocationInWindow	([I)V
        //   1731: aload 12
        //   1733: getfield 498	com/tencent/mm/plugin/sns/ui/item/f$a:RMK	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
        //   1736: getfield 504	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Cxb	Landroid/view/View;
        //   1739: invokevirtual 511	android/view/View:getWidth	()I
        //   1742: istore_2
        //   1743: aload 12
        //   1745: getfield 498	com/tencent/mm/plugin/sns/ui/item/f$a:RMK	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
        //   1748: getfield 504	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:Cxb	Landroid/view/View;
        //   1751: invokevirtual 514	android/view/View:getHeight	()I
        //   1754: istore_3
        //   1755: iload_3
        //   1756: istore 6
        //   1758: iload_2
        //   1759: istore_3
        //   1760: iload 6
        //   1762: istore_2
        //   1763: getstatic 164	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
        //   1766: sipush 11444
        //   1769: iconst_1
        //   1770: anewarray 4	java/lang/Object
        //   1773: dup
        //   1774: iconst_0
        //   1775: iconst_3
        //   1776: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   1779: aastore
        //   1780: invokevirtual 178	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
        //   1783: aload_0
        //   1784: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1787: aload 11
        //   1789: invokestatic 144	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/listener/c;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
        //   1792: astore 12
        //   1794: aload_0
        //   1795: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1798: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   1801: aload 11
        //   1803: aload 12
        //   1805: aload_0
        //   1806: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1809: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   1812: aload_0
        //   1813: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   1816: getfield 518	com/tencent/mm/plugin/sns/ui/listener/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
        //   1819: invokestatic 523	com/tencent/mm/plugin/sns/data/m:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/storage/ADInfo;ILcom/tencent/mm/plugin/sns/ad/g/l;)Z
        //   1822: ifeq +225 -> 2047
        //   1825: aload_0
        //   1826: ldc 38
        //   1828: ldc 39
        //   1830: ldc 40
        //   1832: ldc 41
        //   1834: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   1837: ldc 23
        //   1839: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   1842: return
        //   1843: sipush 717
        //   1846: invokestatic 526	com/tencent/mm/modelsns/l:wP	(I)Lcom/tencent/mm/modelsns/l;
        //   1849: astore 10
        //   1851: goto -265 -> 1586
        //   1854: sipush 745
        //   1857: invokestatic 526	com/tencent/mm/modelsns/l:wP	(I)Lcom/tencent/mm/modelsns/l;
        //   1860: astore 10
        //   1862: goto -209 -> 1653
        //   1865: aload 12
        //   1867: getfield 333	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
        //   1870: getfield 529	com/tencent/mm/plugin/sns/ui/aw:RjO	Landroid/view/View;
        //   1873: ifnull +43 -> 1916
        //   1876: aload 12
        //   1878: getfield 333	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
        //   1881: getfield 529	com/tencent/mm/plugin/sns/ui/aw:RjO	Landroid/view/View;
        //   1884: aload 10
        //   1886: invokevirtual 508	android/view/View:getLocationInWindow	([I)V
        //   1889: aload 12
        //   1891: getfield 333	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
        //   1894: getfield 529	com/tencent/mm/plugin/sns/ui/aw:RjO	Landroid/view/View;
        //   1897: invokevirtual 511	android/view/View:getWidth	()I
        //   1900: istore_3
        //   1901: aload 12
        //   1903: getfield 333	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder:Qcj	Lcom/tencent/mm/plugin/sns/ui/aw;
        //   1906: getfield 529	com/tencent/mm/plugin/sns/ui/aw:RjO	Landroid/view/View;
        //   1909: invokevirtual 514	android/view/View:getHeight	()I
        //   1912: istore_2
        //   1913: goto -150 -> 1763
        //   1916: aload 14
        //   1918: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   1921: getfield 270	com/tencent/mm/protocal/protobuf/agh:Zpq	I
        //   1924: bipush 27
        //   1926: if_icmpne +3309 -> 5235
        //   1929: aload 12
        //   1931: checkcast 125	com/tencent/mm/plugin/sns/ui/item/p$b
        //   1934: getfield 532	com/tencent/mm/plugin/sns/ui/item/p$b:RNA	Landroid/view/View;
        //   1937: aload 10
        //   1939: invokevirtual 508	android/view/View:getLocationInWindow	([I)V
        //   1942: aload 12
        //   1944: checkcast 125	com/tencent/mm/plugin/sns/ui/item/p$b
        //   1947: getfield 532	com/tencent/mm/plugin/sns/ui/item/p$b:RNA	Landroid/view/View;
        //   1950: invokevirtual 511	android/view/View:getWidth	()I
        //   1953: istore_3
        //   1954: aload 12
        //   1956: checkcast 125	com/tencent/mm/plugin/sns/ui/item/p$b
        //   1959: getfield 532	com/tencent/mm/plugin/sns/ui/item/p$b:RNA	Landroid/view/View;
        //   1962: invokevirtual 514	android/view/View:getHeight	()I
        //   1965: istore_2
        //   1966: goto -203 -> 1763
        //   1969: aload_1
        //   1970: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   1973: instanceof 63
        //   1976: ifeq +48 -> 2024
        //   1979: aload_1
        //   1980: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   1983: checkcast 63	com/tencent/mm/plugin/sns/ui/aw
        //   1986: astore 12
        //   1988: aload 12
        //   1990: ifnull +13 -> 2003
        //   1993: aload 12
        //   1995: getfield 529	com/tencent/mm/plugin/sns/ui/aw:RjO	Landroid/view/View;
        //   1998: aload 10
        //   2000: invokevirtual 508	android/view/View:getLocationInWindow	([I)V
        //   2003: aload 12
        //   2005: getfield 529	com/tencent/mm/plugin/sns/ui/aw:RjO	Landroid/view/View;
        //   2008: invokevirtual 511	android/view/View:getWidth	()I
        //   2011: istore_3
        //   2012: aload 12
        //   2014: getfield 529	com/tencent/mm/plugin/sns/ui/aw:RjO	Landroid/view/View;
        //   2017: invokevirtual 514	android/view/View:getHeight	()I
        //   2020: istore_2
        //   2021: goto -258 -> 1763
        //   2024: aload_1
        //   2025: ifnull +9 -> 2034
        //   2028: aload_1
        //   2029: aload 10
        //   2031: invokevirtual 508	android/view/View:getLocationInWindow	([I)V
        //   2034: aload_1
        //   2035: invokevirtual 511	android/view/View:getWidth	()I
        //   2038: istore_3
        //   2039: aload_1
        //   2040: invokevirtual 514	android/view/View:getHeight	()I
        //   2043: istore_2
        //   2044: goto -281 -> 1763
        //   2047: iload 5
        //   2049: ifeq +556 -> 2605
        //   2052: aload_1
        //   2053: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   2056: instanceof 59
        //   2059: ifeq +485 -> 2544
        //   2062: aload_0
        //   2063: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2066: aload_1
        //   2067: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   2070: checkcast 59	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder
        //   2073: invokevirtual 536	com/tencent/mm/plugin/sns/ui/listener/c:m	(Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;)V
        //   2076: aload_0
        //   2077: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2080: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   2083: istore 6
        //   2085: aload_0
        //   2086: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2089: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   2092: ifne +479 -> 2571
        //   2095: iconst_1
        //   2096: istore 5
        //   2098: new 538	com/tencent/mm/modelsns/SnsAdClick
        //   2101: dup
        //   2102: iload 6
        //   2104: iload 5
        //   2106: aload 11
        //   2108: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   2111: bipush 22
        //   2113: bipush 21
        //   2115: invokespecial 541	com/tencent/mm/modelsns/SnsAdClick:<init>	(IIJII)V
        //   2118: astore_1
        //   2119: aload_1
        //   2120: aload_0
        //   2121: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2124: getfield 518	com/tencent/mm/plugin/sns/ui/listener/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
        //   2127: aload 11
        //   2129: bipush 22
        //   2131: invokestatic 544	com/tencent/mm/plugin/sns/data/m:a	(Lcom/tencent/mm/modelsns/SnsAdClick;Lcom/tencent/mm/plugin/sns/ad/g/l;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
        //   2134: aload_1
        //   2135: invokestatic 547	com/tencent/mm/plugin/sns/data/t:a	(Lcom/tencent/mm/modelsns/SnsAdClick;)V
        //   2138: new 549	android/content/Intent
        //   2141: dup
        //   2142: invokespecial 550	android/content/Intent:<init>	()V
        //   2145: astore 12
        //   2147: aload 12
        //   2149: ldc_w 552
        //   2152: aload 10
        //   2154: iconst_0
        //   2155: iaload
        //   2156: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   2159: pop
        //   2160: aload 12
        //   2162: ldc_w 558
        //   2165: aload 10
        //   2167: iconst_1
        //   2168: iaload
        //   2169: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   2172: pop
        //   2173: aload 12
        //   2175: ldc_w 560
        //   2178: iload_3
        //   2179: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   2182: pop
        //   2183: aload 12
        //   2185: ldc_w 562
        //   2188: iload_2
        //   2189: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   2192: pop
        //   2193: aload 12
        //   2195: ldc_w 564
        //   2198: aload 11
        //   2200: invokevirtual 567	com/tencent/mm/plugin/sns/storage/SnsInfo:getSnsId	()Ljava/lang/String;
        //   2203: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   2206: pop
        //   2207: aload 12
        //   2209: ldc_w 572
        //   2212: aload 11
        //   2214: invokevirtual 150	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
        //   2217: getfield 155	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
        //   2220: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   2223: pop
        //   2224: aload 12
        //   2226: ldc_w 574
        //   2229: aload 11
        //   2231: invokevirtual 241	com/tencent/mm/plugin/sns/storage/SnsInfo:getUxinfo	()Ljava/lang/String;
        //   2234: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   2237: pop
        //   2238: aload 11
        //   2240: invokevirtual 150	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
        //   2243: astore_1
        //   2244: aload_1
        //   2245: ifnull +45 -> 2290
        //   2248: aload_1
        //   2249: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   2252: getfield 277	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
        //   2255: astore_1
        //   2256: aload_1
        //   2257: invokeinterface 577 1 0
        //   2262: iload 4
        //   2264: if_icmple +26 -> 2290
        //   2267: aload 12
        //   2269: ldc_w 579
        //   2272: aload_1
        //   2273: iload 4
        //   2275: invokeinterface 580 2 0
        //   2280: checkcast 289	com/tencent/mm/protocal/protobuf/dmz
        //   2283: getfield 583	com/tencent/mm/protocal/protobuf/dmz:aaTl	Ljava/lang/String;
        //   2286: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   2289: pop
        //   2290: aload 12
        //   2292: aload_0
        //   2293: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2296: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   2299: ldc_w 585
        //   2302: invokevirtual 589	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
        //   2305: pop
        //   2306: iconst_1
        //   2307: istore_2
        //   2308: aload_0
        //   2309: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2312: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   2315: iconst_2
        //   2316: if_icmpne +261 -> 2577
        //   2319: bipush 16
        //   2321: istore_2
        //   2322: aload 12
        //   2324: ldc_w 591
        //   2327: iload_2
        //   2328: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   2331: pop
        //   2332: iload 4
        //   2334: ifle +259 -> 2593
        //   2337: aload 11
        //   2339: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   2342: invokevirtual 594	com/tencent/mm/plugin/sns/storage/ADXml:getTurnCanvasInfo	()Ljava/lang/String;
        //   2345: astore_1
        //   2346: aload 12
        //   2348: ldc_w 596
        //   2351: aload_1
        //   2352: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   2355: pop
        //   2356: aload 12
        //   2358: ldc_w 598
        //   2361: aload 11
        //   2363: invokevirtual 601	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdRecSrc	()I
        //   2366: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   2369: pop
        //   2370: aload 12
        //   2372: ldc_w 603
        //   2375: ldc_w 605
        //   2378: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   2381: pop
        //   2382: aload 12
        //   2384: ldc_w 607
        //   2387: invokestatic 613	java/lang/System:currentTimeMillis	()J
        //   2390: invokevirtual 616	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
        //   2393: pop
        //   2394: aload 11
        //   2396: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   2399: getfield 619	com/tencent/mm/plugin/sns/storage/ADXml:forbiddenCustomAnimation	Z
        //   2402: ifne +13 -> 2415
        //   2405: aload 12
        //   2407: ldc_w 621
        //   2410: iconst_1
        //   2411: invokevirtual 624	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   2414: pop
        //   2415: aload 12
        //   2417: ldc_w 626
        //   2420: iconst_1
        //   2421: invokevirtual 624	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   2424: pop
        //   2425: aload_0
        //   2426: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2429: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   2432: astore_1
        //   2433: new 628	com/tencent/mm/hellhoundlib/b/a
        //   2436: dup
        //   2437: invokespecial 629	com/tencent/mm/hellhoundlib/b/a:<init>	()V
        //   2440: aload 12
        //   2442: invokevirtual 633	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
        //   2445: astore 10
        //   2447: aload_1
        //   2448: aload 10
        //   2450: invokevirtual 636	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
        //   2453: ldc 38
        //   2455: ldc 40
        //   2457: ldc 41
        //   2459: ldc_w 638
        //   2462: ldc_w 640
        //   2465: ldc_w 642
        //   2468: invokestatic 645	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   2471: aload_1
        //   2472: aload 10
        //   2474: iconst_0
        //   2475: invokevirtual 648	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
        //   2478: checkcast 549	android/content/Intent
        //   2481: invokevirtual 652	android/app/Activity:startActivity	(Landroid/content/Intent;)V
        //   2484: aload_1
        //   2485: ldc 38
        //   2487: ldc 40
        //   2489: ldc 41
        //   2491: ldc_w 638
        //   2494: ldc_w 640
        //   2497: ldc_w 642
        //   2500: invokestatic 655	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   2503: aload 11
        //   2505: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   2508: getfield 619	com/tencent/mm/plugin/sns/storage/ADXml:forbiddenCustomAnimation	Z
        //   2511: ifne +15 -> 2526
        //   2514: aload_0
        //   2515: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2518: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   2521: iconst_0
        //   2522: iconst_0
        //   2523: invokevirtual 659	android/app/Activity:overridePendingTransition	(II)V
        //   2526: aload_0
        //   2527: ldc 38
        //   2529: ldc 39
        //   2531: ldc 40
        //   2533: ldc 41
        //   2535: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   2538: ldc 23
        //   2540: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   2543: return
        //   2544: aload_1
        //   2545: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   2548: instanceof 67
        //   2551: ifeq -475 -> 2076
        //   2554: aload_0
        //   2555: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2558: aload_1
        //   2559: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   2562: checkcast 67	com/tencent/mm/plugin/sns/ui/c/a/b
        //   2565: invokevirtual 662	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/c/a/b;)V
        //   2568: goto -492 -> 2076
        //   2571: iconst_2
        //   2572: istore 5
        //   2574: goto -476 -> 2098
        //   2577: aload_0
        //   2578: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2581: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   2584: iconst_1
        //   2585: if_icmpne -263 -> 2322
        //   2588: iconst_2
        //   2589: istore_2
        //   2590: goto -268 -> 2322
        //   2593: aload 11
        //   2595: invokevirtual 228	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdSnsInfo	()Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
        //   2598: getfield 431	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_adxml	Ljava/lang/String;
        //   2601: astore_1
        //   2602: goto -256 -> 2346
        //   2605: aload_0
        //   2606: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2609: astore 10
        //   2611: aload_0
        //   2612: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2615: aload 11
        //   2617: invokestatic 144	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/listener/c;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
        //   2620: astore 12
        //   2622: iload 4
        //   2624: ifle +119 -> 2743
        //   2627: iconst_1
        //   2628: istore 9
        //   2630: aload 10
        //   2632: aload 12
        //   2634: aload 11
        //   2636: iload 9
        //   2638: invokestatic 665	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/listener/c;Lcom/tencent/mm/plugin/sns/storage/ADInfo;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Z)Z
        //   2641: ifeq +113 -> 2754
        //   2644: aload_0
        //   2645: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2648: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   2651: pop
        //   2652: invokestatic 671	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:hbB	()Lcom/tencent/mm/plugin/sns/ad/timeline/dynamic/a;
        //   2655: aload_0
        //   2656: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2659: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   2662: aload 11
        //   2664: invokevirtual 674	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:c	(ILcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
        //   2667: aload_0
        //   2668: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2671: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   2674: istore_3
        //   2675: aload_0
        //   2676: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2679: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   2682: ifne +67 -> 2749
        //   2685: iconst_1
        //   2686: istore_2
        //   2687: new 538	com/tencent/mm/modelsns/SnsAdClick
        //   2690: dup
        //   2691: iload_3
        //   2692: iload_2
        //   2693: aload 11
        //   2695: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   2698: bipush 22
        //   2700: bipush 31
        //   2702: invokespecial 541	com/tencent/mm/modelsns/SnsAdClick:<init>	(IIJII)V
        //   2705: astore_1
        //   2706: aload_1
        //   2707: aload_0
        //   2708: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2711: getfield 518	com/tencent/mm/plugin/sns/ui/listener/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
        //   2714: aload 11
        //   2716: bipush 22
        //   2718: invokestatic 544	com/tencent/mm/plugin/sns/data/m:a	(Lcom/tencent/mm/modelsns/SnsAdClick;Lcom/tencent/mm/plugin/sns/ad/g/l;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
        //   2721: aload_1
        //   2722: invokestatic 547	com/tencent/mm/plugin/sns/data/t:a	(Lcom/tencent/mm/modelsns/SnsAdClick;)V
        //   2725: aload_0
        //   2726: ldc 38
        //   2728: ldc 39
        //   2730: ldc 40
        //   2732: ldc 41
        //   2734: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   2737: ldc 23
        //   2739: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   2742: return
        //   2743: iconst_0
        //   2744: istore 9
        //   2746: goto -116 -> 2630
        //   2749: iconst_2
        //   2750: istore_2
        //   2751: goto -64 -> 2687
        //   2754: iconst_4
        //   2755: aload_0
        //   2756: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2759: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   2762: invokestatic 679	com/tencent/mm/plugin/sns/ad/timeline/a/a:f	(ILandroid/content/Context;)Lcom/tencent/mm/plugin/sns/ad/timeline/a/c;
        //   2765: astore 10
        //   2767: aload 10
        //   2769: ifnull +73 -> 2842
        //   2772: new 681	com/tencent/mm/plugin/sns/ad/timeline/a/d
        //   2775: dup
        //   2776: invokespecial 682	com/tencent/mm/plugin/sns/ad/timeline/a/d:<init>	()V
        //   2779: astore 12
        //   2781: aload 12
        //   2783: ldc_w 684
        //   2786: aload_0
        //   2787: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2790: getfield 518	com/tencent/mm/plugin/sns/ui/listener/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
        //   2793: invokevirtual 688	com/tencent/mm/plugin/sns/ad/timeline/a/d:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
        //   2796: pop
        //   2797: aload 10
        //   2799: aload_1
        //   2800: aload_0
        //   2801: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2804: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   2807: aload 11
        //   2809: aload 12
        //   2811: invokeinterface 693 5 0
        //   2816: istore 9
        //   2818: iload 9
        //   2820: ifeq +22 -> 2842
        //   2823: aload_0
        //   2824: ldc 38
        //   2826: ldc 39
        //   2828: ldc 40
        //   2830: ldc 41
        //   2832: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   2835: ldc 23
        //   2837: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   2840: return
        //   2841: astore_1
        //   2842: aload_0
        //   2843: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2846: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   2849: istore_3
        //   2850: aload_0
        //   2851: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2854: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   2857: ifne +145 -> 3002
        //   2860: iconst_1
        //   2861: istore_2
        //   2862: new 538	com/tencent/mm/modelsns/SnsAdClick
        //   2865: dup
        //   2866: iload_3
        //   2867: iload_2
        //   2868: aload 11
        //   2870: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   2873: bipush 22
        //   2875: iconst_0
        //   2876: invokespecial 541	com/tencent/mm/modelsns/SnsAdClick:<init>	(IIJII)V
        //   2879: astore 12
        //   2881: aload 12
        //   2883: aload_0
        //   2884: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   2887: getfield 518	com/tencent/mm/plugin/sns/ui/listener/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
        //   2890: aload 11
        //   2892: bipush 22
        //   2894: invokestatic 544	com/tencent/mm/plugin/sns/data/m:a	(Lcom/tencent/mm/modelsns/SnsAdClick;Lcom/tencent/mm/plugin/sns/ad/g/l;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
        //   2897: aload 12
        //   2899: invokestatic 547	com/tencent/mm/plugin/sns/data/t:a	(Lcom/tencent/mm/modelsns/SnsAdClick;)V
        //   2902: iload 4
        //   2904: ifle +103 -> 3007
        //   2907: aload 11
        //   2909: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   2912: getfield 697	com/tencent/mm/plugin/sns/storage/ADXml:adTurnInfo	Lcom/tencent/mm/plugin/sns/storage/ADXml$j;
        //   2915: getfield 702	com/tencent/mm/plugin/sns/storage/ADXml$j:adActionLink	Ljava/lang/String;
        //   2918: astore 10
        //   2920: aload 10
        //   2922: astore_1
        //   2923: aload 10
        //   2925: invokestatic 708	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   2928: ifeq +9 -> 2937
        //   2931: aload 11
        //   2933: invokevirtual 711	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdLink	()Ljava/lang/String;
        //   2936: astore_1
        //   2937: ldc_w 294
        //   2940: new 312	java/lang/StringBuilder
        //   2943: dup
        //   2944: ldc_w 713
        //   2947: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   2950: aload_1
        //   2951: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2954: ldc_w 715
        //   2957: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   2960: aload 11
        //   2962: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   2965: getfield 718	com/tencent/mm/plugin/sns/storage/ADXml:webrightBar	I
        //   2968: invokevirtual 721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   2971: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   2974: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   2977: aload_1
        //   2978: invokestatic 708	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   2981: ifeq +36 -> 3017
        //   2984: aload_0
        //   2985: ldc 38
        //   2987: ldc 39
        //   2989: ldc 40
        //   2991: ldc 41
        //   2993: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   2996: ldc 23
        //   2998: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   3001: return
        //   3002: iconst_2
        //   3003: istore_2
        //   3004: goto -142 -> 2862
        //   3007: aload 11
        //   3009: invokevirtual 724	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfoLink	()Ljava/lang/String;
        //   3012: astore 10
        //   3014: goto -94 -> 2920
        //   3017: new 549	android/content/Intent
        //   3020: dup
        //   3021: invokespecial 550	android/content/Intent:<init>	()V
        //   3024: astore 13
        //   3026: aload 11
        //   3028: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   3031: getfield 718	com/tencent/mm/plugin/sns/storage/ADXml:webrightBar	I
        //   3034: ifne +304 -> 3338
        //   3037: iconst_1
        //   3038: istore 9
        //   3040: getstatic 729	com/tencent/mm/platformtools/z:pCv	Z
        //   3043: ifeq +6 -> 3049
        //   3046: iconst_0
        //   3047: istore 9
        //   3049: aload_1
        //   3050: astore 10
        //   3052: aload 11
        //   3054: ifnull +71 -> 3125
        //   3057: aload_1
        //   3058: astore 10
        //   3060: aload 11
        //   3062: invokevirtual 100	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
        //   3065: ifeq +60 -> 3125
        //   3068: aload_0
        //   3069: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3072: aload 11
        //   3074: invokestatic 144	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/listener/c;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
        //   3077: astore 14
        //   3079: aload_1
        //   3080: astore 10
        //   3082: aload 14
        //   3084: ifnull +41 -> 3125
        //   3087: aload 13
        //   3089: ldc_w 731
        //   3092: aload 14
        //   3094: getfield 310	com/tencent/mm/plugin/sns/storage/ADInfo:viewId	Ljava/lang/String;
        //   3097: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3100: pop
        //   3101: aload_1
        //   3102: aload 14
        //   3104: getfield 734	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
        //   3107: invokestatic 738	com/tencent/mm/plugin/sns/data/t:lY	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   3110: invokestatic 744	com/tencent/mm/plugin/sns/ad/c/a/a:aWj	(Ljava/lang/String;)Ljava/lang/String;
        //   3113: astore 10
        //   3115: aload 13
        //   3117: aload 14
        //   3119: getfield 734	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
        //   3122: invokestatic 747	com/tencent/mm/plugin/sns/data/t:i	(Landroid/content/Intent;Ljava/lang/String;)V
        //   3125: aload 13
        //   3127: ldc_w 749
        //   3130: iload 9
        //   3132: invokevirtual 624	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   3135: pop
        //   3136: new 751	android/os/Bundle
        //   3139: dup
        //   3140: invokespecial 752	android/os/Bundle:<init>	()V
        //   3143: astore_1
        //   3144: aload_1
        //   3145: ldc_w 754
        //   3148: aload 12
        //   3150: invokevirtual 758	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
        //   3153: aload_1
        //   3154: ldc_w 760
        //   3157: aload 11
        //   3159: invokevirtual 150	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
        //   3162: getfield 763	com/tencent/mm/protocal/protobuf/TimeLineObject:statExtStr	Ljava/lang/String;
        //   3165: invokevirtual 766	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   3168: aload 13
        //   3170: ldc_w 768
        //   3173: aload_1
        //   3174: invokevirtual 771	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
        //   3177: pop
        //   3178: aload 13
        //   3180: ldc_w 773
        //   3183: aload 10
        //   3185: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3188: pop
        //   3189: aload 13
        //   3191: ldc_w 775
        //   3194: iconst_1
        //   3195: invokevirtual 624	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   3198: pop
        //   3199: aload 13
        //   3201: ldc_w 777
        //   3204: aload 11
        //   3206: getfield 780	com/tencent/mm/plugin/sns/storage/SnsInfo:field_userName	Ljava/lang/String;
        //   3209: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3212: pop
        //   3213: aload 13
        //   3215: ldc_w 782
        //   3218: bipush 15
        //   3220: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   3223: pop
        //   3224: aload 13
        //   3226: ldc_w 784
        //   3229: new 312	java/lang/StringBuilder
        //   3232: dup
        //   3233: ldc_w 786
        //   3236: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   3239: aload 11
        //   3241: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   3244: invokestatic 790	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
        //   3247: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   3250: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   3253: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3256: pop
        //   3257: aload 13
        //   3259: ldc_w 792
        //   3262: aload 11
        //   3264: getfield 780	com/tencent/mm/plugin/sns/storage/SnsInfo:field_userName	Ljava/lang/String;
        //   3267: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3270: pop
        //   3271: aload 13
        //   3273: ldc_w 794
        //   3276: new 312	java/lang/StringBuilder
        //   3279: dup
        //   3280: ldc_w 786
        //   3283: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   3286: aload 11
        //   3288: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   3291: invokestatic 790	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
        //   3294: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   3297: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   3300: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3303: pop
        //   3304: aload 13
        //   3306: ldc_w 796
        //   3309: aload 11
        //   3311: getfield 780	com/tencent/mm/plugin/sns/storage/SnsInfo:field_userName	Ljava/lang/String;
        //   3314: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3317: pop
        //   3318: getstatic 802	com/tencent/mm/plugin/sns/d/a:pFn	Lcom/tencent/mm/pluginsdk/m;
        //   3321: aload 13
        //   3323: aload_0
        //   3324: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3327: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   3330: invokeinterface 808 3 0
        //   3335: goto -809 -> 2526
        //   3338: iconst_0
        //   3339: istore 9
        //   3341: goto -301 -> 3040
        //   3344: aload 14
        //   3346: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   3349: getfield 270	com/tencent/mm/protocal/protobuf/agh:Zpq	I
        //   3352: iconst_1
        //   3353: if_icmpne +18 -> 3371
        //   3356: aload 14
        //   3358: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   3361: getfield 277	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
        //   3364: invokevirtual 283	java/util/LinkedList:size	()I
        //   3367: iconst_1
        //   3368: if_icmpeq +68 -> 3436
        //   3371: aload 14
        //   3373: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   3376: getfield 270	com/tencent/mm/protocal/protobuf/agh:Zpq	I
        //   3379: bipush 7
        //   3381: if_icmpeq +55 -> 3436
        //   3384: aload 14
        //   3386: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   3389: getfield 270	com/tencent/mm/protocal/protobuf/agh:Zpq	I
        //   3392: bipush 27
        //   3394: if_icmpne -868 -> 2526
        //   3397: aload 14
        //   3399: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   3402: getfield 277	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
        //   3405: invokevirtual 283	java/util/LinkedList:size	()I
        //   3408: iload 4
        //   3410: if_icmple -884 -> 2526
        //   3413: aload 14
        //   3415: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   3418: getfield 277	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
        //   3421: iload 4
        //   3423: invokevirtual 287	java/util/LinkedList:get	(I)Ljava/lang/Object;
        //   3426: checkcast 289	com/tencent/mm/protocal/protobuf/dmz
        //   3429: getfield 292	com/tencent/mm/protocal/protobuf/dmz:vhJ	I
        //   3432: iconst_2
        //   3433: if_icmpne -907 -> 2526
        //   3436: aload_0
        //   3437: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3440: aload 11
        //   3442: invokestatic 144	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/listener/c;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
        //   3445: astore 10
        //   3447: aload_0
        //   3448: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3451: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   3454: aload 11
        //   3456: aload 10
        //   3458: aload_0
        //   3459: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3462: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   3465: aload_0
        //   3466: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3469: getfield 518	com/tencent/mm/plugin/sns/ui/listener/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
        //   3472: invokestatic 523	com/tencent/mm/plugin/sns/data/m:a	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Lcom/tencent/mm/plugin/sns/storage/ADInfo;ILcom/tencent/mm/plugin/sns/ad/g/l;)Z
        //   3475: ifeq +21 -> 3496
        //   3478: aload_0
        //   3479: ldc 38
        //   3481: ldc 39
        //   3483: ldc 40
        //   3485: ldc 41
        //   3487: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   3490: ldc 23
        //   3492: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   3495: return
        //   3496: aload_1
        //   3497: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   3500: instanceof 59
        //   3503: ifeq +712 -> 4215
        //   3506: aload_1
        //   3507: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   3510: checkcast 59	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder
        //   3513: astore 10
        //   3515: aload_1
        //   3516: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   3519: instanceof 810
        //   3522: ifeq +599 -> 4121
        //   3525: aload_1
        //   3526: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   3529: checkcast 810	com/tencent/mm/plugin/sns/ui/item/a$a
        //   3532: getfield 814	com/tencent/mm/plugin/sns/ui/item/a$a:QbZ	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
        //   3535: astore 10
        //   3537: aload 11
        //   3539: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   3542: invokevirtual 428	com/tencent/mm/plugin/sns/storage/ADXml:isLandingPagesAd	()Z
        //   3545: ifeq +926 -> 4471
        //   3548: aload 11
        //   3550: invokevirtual 228	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdSnsInfo	()Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
        //   3553: getfield 431	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_adxml	Ljava/lang/String;
        //   3556: astore 13
        //   3558: iload 4
        //   3560: ifle +809 -> 4369
        //   3563: ldc_w 433
        //   3566: astore 12
        //   3568: aload 13
        //   3570: aload 12
        //   3572: invokestatic 439	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/l:mL	(Ljava/lang/String;Ljava/lang/String;)Z
        //   3575: ifeq +896 -> 4471
        //   3578: aload_0
        //   3579: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3582: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   3585: istore 5
        //   3587: aload_0
        //   3588: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3591: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   3594: ifne +783 -> 4377
        //   3597: iconst_1
        //   3598: istore_3
        //   3599: new 538	com/tencent/mm/modelsns/SnsAdClick
        //   3602: dup
        //   3603: iload 5
        //   3605: iload_3
        //   3606: aload 11
        //   3608: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   3611: bipush 21
        //   3613: iload_2
        //   3614: iconst_0
        //   3615: invokespecial 817	com/tencent/mm/modelsns/SnsAdClick:<init>	(IIJIIB)V
        //   3618: astore 12
        //   3620: aload 12
        //   3622: aload_0
        //   3623: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3626: getfield 518	com/tencent/mm/plugin/sns/ui/listener/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
        //   3629: aload 11
        //   3631: bipush 22
        //   3633: invokestatic 544	com/tencent/mm/plugin/sns/data/m:a	(Lcom/tencent/mm/modelsns/SnsAdClick;Lcom/tencent/mm/plugin/sns/ad/g/l;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
        //   3636: aload 12
        //   3638: invokestatic 547	com/tencent/mm/plugin/sns/data/t:a	(Lcom/tencent/mm/modelsns/SnsAdClick;)V
        //   3641: aload_1
        //   3642: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   3645: instanceof 59
        //   3648: ifeq +734 -> 4382
        //   3651: aload_0
        //   3652: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3655: aload_1
        //   3656: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   3659: checkcast 59	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder
        //   3662: invokevirtual 536	com/tencent/mm/plugin/sns/ui/listener/c:m	(Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;)V
        //   3665: iconst_2
        //   3666: newarray int
        //   3668: astore_1
        //   3669: aload 10
        //   3671: aload_1
        //   3672: invokevirtual 508	android/view/View:getLocationInWindow	([I)V
        //   3675: aload 10
        //   3677: invokevirtual 511	android/view/View:getWidth	()I
        //   3680: istore_2
        //   3681: aload 10
        //   3683: invokevirtual 514	android/view/View:getHeight	()I
        //   3686: istore_3
        //   3687: new 549	android/content/Intent
        //   3690: dup
        //   3691: invokespecial 550	android/content/Intent:<init>	()V
        //   3694: astore 10
        //   3696: aload 10
        //   3698: ldc_w 552
        //   3701: aload_1
        //   3702: iconst_0
        //   3703: iaload
        //   3704: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   3707: pop
        //   3708: aload 10
        //   3710: ldc_w 558
        //   3713: aload_1
        //   3714: iconst_1
        //   3715: iaload
        //   3716: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   3719: pop
        //   3720: aload 10
        //   3722: ldc_w 560
        //   3725: iload_2
        //   3726: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   3729: pop
        //   3730: aload 10
        //   3732: ldc_w 562
        //   3735: iload_3
        //   3736: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   3739: pop
        //   3740: aload 10
        //   3742: ldc_w 564
        //   3745: aload 11
        //   3747: invokevirtual 567	com/tencent/mm/plugin/sns/storage/SnsInfo:getSnsId	()Ljava/lang/String;
        //   3750: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3753: pop
        //   3754: aload 10
        //   3756: ldc_w 572
        //   3759: aload 11
        //   3761: invokevirtual 150	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
        //   3764: getfield 155	com/tencent/mm/protocal/protobuf/TimeLineObject:Id	Ljava/lang/String;
        //   3767: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3770: pop
        //   3771: aload 10
        //   3773: ldc_w 574
        //   3776: aload 11
        //   3778: invokevirtual 241	com/tencent/mm/plugin/sns/storage/SnsInfo:getUxinfo	()Ljava/lang/String;
        //   3781: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3784: pop
        //   3785: aload 10
        //   3787: ldc_w 819
        //   3790: aload 11
        //   3792: invokevirtual 822	com/tencent/mm/plugin/sns/storage/SnsInfo:getAid	()Ljava/lang/String;
        //   3795: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3798: pop
        //   3799: aload 10
        //   3801: ldc_w 824
        //   3804: aload 11
        //   3806: invokevirtual 827	com/tencent/mm/plugin/sns/storage/SnsInfo:getTraceid	()Ljava/lang/String;
        //   3809: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3812: pop
        //   3813: aload 11
        //   3815: invokevirtual 150	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
        //   3818: astore_1
        //   3819: aload_1
        //   3820: ifnull +45 -> 3865
        //   3823: aload_1
        //   3824: getfield 265	com/tencent/mm/protocal/protobuf/TimeLineObject:ContentObj	Lcom/tencent/mm/protocal/protobuf/agh;
        //   3827: getfield 277	com/tencent/mm/protocal/protobuf/agh:Zpr	Ljava/util/LinkedList;
        //   3830: astore_1
        //   3831: aload_1
        //   3832: invokeinterface 577 1 0
        //   3837: iload 4
        //   3839: if_icmple +570 -> 4409
        //   3842: aload 10
        //   3844: ldc_w 579
        //   3847: aload_1
        //   3848: iload 4
        //   3850: invokeinterface 580 2 0
        //   3855: checkcast 289	com/tencent/mm/protocal/protobuf/dmz
        //   3858: getfield 583	com/tencent/mm/protocal/protobuf/dmz:aaTl	Ljava/lang/String;
        //   3861: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3864: pop
        //   3865: aload 10
        //   3867: aload_0
        //   3868: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3871: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   3874: ldc_w 585
        //   3877: invokevirtual 589	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
        //   3880: pop
        //   3881: iconst_1
        //   3882: istore_2
        //   3883: aload_0
        //   3884: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3887: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   3890: iconst_2
        //   3891: if_icmpne +552 -> 4443
        //   3894: bipush 16
        //   3896: istore_2
        //   3897: aload 10
        //   3899: ldc_w 591
        //   3902: iload_2
        //   3903: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   3906: pop
        //   3907: iload 4
        //   3909: ifle +550 -> 4459
        //   3912: aload 11
        //   3914: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   3917: invokevirtual 594	com/tencent/mm/plugin/sns/storage/ADXml:getTurnCanvasInfo	()Ljava/lang/String;
        //   3920: astore_1
        //   3921: aload 10
        //   3923: ldc_w 596
        //   3926: aload_1
        //   3927: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3930: pop
        //   3931: aload 10
        //   3933: ldc_w 598
        //   3936: aload 11
        //   3938: invokevirtual 601	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdRecSrc	()I
        //   3941: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   3944: pop
        //   3945: aload 10
        //   3947: ldc_w 603
        //   3950: ldc_w 605
        //   3953: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   3956: pop
        //   3957: aload 10
        //   3959: ldc_w 607
        //   3962: invokestatic 613	java/lang/System:currentTimeMillis	()J
        //   3965: invokevirtual 616	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
        //   3968: pop
        //   3969: aload 11
        //   3971: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   3974: getfield 619	com/tencent/mm/plugin/sns/storage/ADXml:forbiddenCustomAnimation	Z
        //   3977: ifne +13 -> 3990
        //   3980: aload 10
        //   3982: ldc_w 621
        //   3985: iconst_1
        //   3986: invokevirtual 624	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   3989: pop
        //   3990: aload_0
        //   3991: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   3994: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   3997: astore_1
        //   3998: new 628	com/tencent/mm/hellhoundlib/b/a
        //   4001: dup
        //   4002: invokespecial 629	com/tencent/mm/hellhoundlib/b/a:<init>	()V
        //   4005: aload 10
        //   4007: invokevirtual 633	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
        //   4010: astore 10
        //   4012: aload_1
        //   4013: aload 10
        //   4015: invokevirtual 636	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
        //   4018: ldc 38
        //   4020: ldc 40
        //   4022: ldc 41
        //   4024: ldc_w 638
        //   4027: ldc_w 640
        //   4030: ldc_w 642
        //   4033: invokestatic 645	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   4036: aload_1
        //   4037: aload 10
        //   4039: iconst_0
        //   4040: invokevirtual 648	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
        //   4043: checkcast 549	android/content/Intent
        //   4046: invokevirtual 652	android/app/Activity:startActivity	(Landroid/content/Intent;)V
        //   4049: aload_1
        //   4050: ldc 38
        //   4052: ldc 40
        //   4054: ldc 41
        //   4056: ldc_w 638
        //   4059: ldc_w 640
        //   4062: ldc_w 642
        //   4065: invokestatic 655	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   4068: aload 11
        //   4070: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   4073: getfield 619	com/tencent/mm/plugin/sns/storage/ADXml:forbiddenCustomAnimation	Z
        //   4076: ifne +15 -> 4091
        //   4079: aload_0
        //   4080: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4083: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   4086: iconst_0
        //   4087: iconst_0
        //   4088: invokevirtual 659	android/app/Activity:overridePendingTransition	(II)V
        //   4091: aload_0
        //   4092: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4095: invokestatic 338	com/tencent/mm/plugin/sns/ui/listener/c:l	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Lcom/tencent/mm/plugin/sns/model/ak;
        //   4098: ifnull -1572 -> 2526
        //   4101: aload_0
        //   4102: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4105: invokestatic 338	com/tencent/mm/plugin/sns/ui/listener/c:l	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Lcom/tencent/mm/plugin/sns/model/ak;
        //   4108: invokeinterface 344 1 0
        //   4113: aload 11
        //   4115: invokevirtual 349	com/tencent/mm/plugin/sns/statistics/e:P	(Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
        //   4118: goto -1592 -> 2526
        //   4121: aload_1
        //   4122: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4125: instanceof 494
        //   4128: ifeq +21 -> 4149
        //   4131: aload_1
        //   4132: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4135: checkcast 494	com/tencent/mm/plugin/sns/ui/item/f$a
        //   4138: getfield 498	com/tencent/mm/plugin/sns/ui/item/f$a:RMK	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
        //   4141: getfield 828	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:QbZ	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
        //   4144: astore 10
        //   4146: goto -609 -> 3537
        //   4149: aload 10
        //   4151: instanceof 125
        //   4154: ifeq +22 -> 4176
        //   4157: aload 10
        //   4159: checkcast 125	com/tencent/mm/plugin/sns/ui/item/p$b
        //   4162: getfield 129	com/tencent/mm/plugin/sns/ui/item/p$b:RNC	Lcom/tencent/mm/plugin/sns/ui/item/p$a;
        //   4165: getfield 831	com/tencent/mm/plugin/sns/ui/item/p$a:view	Landroid/view/View;
        //   4168: checkcast 833	com/tencent/mm/plugin/sns/ui/TagImageView
        //   4171: astore 10
        //   4173: goto -636 -> 3537
        //   4176: aload_1
        //   4177: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4180: instanceof 835
        //   4183: ifeq +18 -> 4201
        //   4186: aload_1
        //   4187: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4190: checkcast 835	com/tencent/mm/plugin/sns/ui/item/n$a
        //   4193: getfield 839	com/tencent/mm/plugin/sns/ui/item/n$a:RNm	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView;
        //   4196: astore 10
        //   4198: goto -661 -> 3537
        //   4201: aload 10
        //   4203: getfield 843	com/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder:RKZ	Lcom/tencent/mm/plugin/sns/ui/PhotosContent;
        //   4206: iconst_0
        //   4207: invokevirtual 849	com/tencent/mm/plugin/sns/ui/PhotosContent:alP	(I)Lcom/tencent/mm/plugin/sns/ui/TagImageView;
        //   4210: astore 10
        //   4212: goto -675 -> 3537
        //   4215: aload_1
        //   4216: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4219: instanceof 67
        //   4222: ifeq +106 -> 4328
        //   4225: aload_1
        //   4226: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4229: instanceof 851
        //   4232: ifeq +18 -> 4250
        //   4235: aload_1
        //   4236: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4239: checkcast 851	com/tencent/mm/plugin/sns/ui/c/a/c
        //   4242: getfield 854	com/tencent/mm/plugin/sns/ui/c/a/c:RJh	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
        //   4245: astore 10
        //   4247: goto -710 -> 3537
        //   4250: aload_1
        //   4251: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4254: instanceof 856
        //   4257: ifeq +21 -> 4278
        //   4260: aload_1
        //   4261: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4264: checkcast 856	com/tencent/mm/plugin/sns/ui/c/a/d
        //   4267: getfield 859	com/tencent/mm/plugin/sns/ui/c/a/d:RJA	Lcom/tencent/mm/plugin/sns/ad/timeline/b/b/a$b;
        //   4270: getfield 828	com/tencent/mm/plugin/sns/ad/timeline/b/b/a$b:QbZ	Lcom/tencent/mm/plugin/sns/ui/MaskImageView;
        //   4273: astore 10
        //   4275: goto -738 -> 3537
        //   4278: aload_1
        //   4279: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4282: instanceof 138
        //   4285: ifeq +18 -> 4303
        //   4288: aload_1
        //   4289: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4292: checkcast 138	com/tencent/mm/plugin/sns/ui/c/a/h
        //   4295: getfield 862	com/tencent/mm/plugin/sns/ui/c/a/h:contentView	Landroid/view/View;
        //   4298: astore 10
        //   4300: goto -763 -> 3537
        //   4303: aload_1
        //   4304: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4307: instanceof 864
        //   4310: ifeq +919 -> 5229
        //   4313: aload_1
        //   4314: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4317: checkcast 864	com/tencent/mm/plugin/sns/ui/c/a/f
        //   4320: getfield 865	com/tencent/mm/plugin/sns/ui/c/a/f:contentView	Landroid/view/View;
        //   4323: astore 10
        //   4325: goto -788 -> 3537
        //   4328: aload_1
        //   4329: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4332: instanceof 65
        //   4335: ifeq +15 -> 4350
        //   4338: aload_1
        //   4339: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4342: checkcast 65	com/tencent/mm/plugin/sns/ui/MaskImageView
        //   4345: astore 10
        //   4347: goto -810 -> 3537
        //   4350: aload_1
        //   4351: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4354: instanceof 833
        //   4357: ifeq +872 -> 5229
        //   4360: aload_1
        //   4361: checkcast 833	com/tencent/mm/plugin/sns/ui/TagImageView
        //   4364: astore 10
        //   4366: goto -829 -> 3537
        //   4369: ldc_w 462
        //   4372: astore 12
        //   4374: goto -806 -> 3568
        //   4377: iconst_2
        //   4378: istore_3
        //   4379: goto -780 -> 3599
        //   4382: aload_1
        //   4383: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4386: instanceof 67
        //   4389: ifeq -724 -> 3665
        //   4392: aload_0
        //   4393: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4396: aload_1
        //   4397: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
        //   4400: checkcast 67	com/tencent/mm/plugin/sns/ui/c/a/b
        //   4403: invokevirtual 662	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/c/a/b;)V
        //   4406: goto -741 -> 3665
        //   4409: aload_1
        //   4410: invokeinterface 577 1 0
        //   4415: ifle -550 -> 3865
        //   4418: aload 10
        //   4420: ldc_w 579
        //   4423: aload_1
        //   4424: iconst_0
        //   4425: invokeinterface 580 2 0
        //   4430: checkcast 289	com/tencent/mm/protocal/protobuf/dmz
        //   4433: getfield 583	com/tencent/mm/protocal/protobuf/dmz:aaTl	Ljava/lang/String;
        //   4436: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   4439: pop
        //   4440: goto -575 -> 3865
        //   4443: aload_0
        //   4444: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4447: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   4450: iconst_1
        //   4451: if_icmpne -554 -> 3897
        //   4454: iconst_2
        //   4455: istore_2
        //   4456: goto -559 -> 3897
        //   4459: aload 11
        //   4461: invokevirtual 228	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdSnsInfo	()Lcom/tencent/mm/plugin/sns/storage/AdSnsInfo;
        //   4464: getfield 431	com/tencent/mm/plugin/sns/storage/AdSnsInfo:field_adxml	Ljava/lang/String;
        //   4467: astore_1
        //   4468: goto -547 -> 3921
        //   4471: aload_0
        //   4472: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4475: astore 10
        //   4477: aload_0
        //   4478: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4481: aload 11
        //   4483: invokestatic 144	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/listener/c;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
        //   4486: astore 12
        //   4488: iload 4
        //   4490: ifle +121 -> 4611
        //   4493: iconst_1
        //   4494: istore 9
        //   4496: aload 10
        //   4498: aload 12
        //   4500: aload 11
        //   4502: iload 9
        //   4504: invokestatic 665	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/listener/c;Lcom/tencent/mm/plugin/sns/storage/ADInfo;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;Z)Z
        //   4507: ifeq +115 -> 4622
        //   4510: aload_0
        //   4511: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4514: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   4517: pop
        //   4518: invokestatic 671	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:hbB	()Lcom/tencent/mm/plugin/sns/ad/timeline/dynamic/a;
        //   4521: aload_0
        //   4522: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4525: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   4528: aload 11
        //   4530: invokevirtual 674	com/tencent/mm/plugin/sns/ad/timeline/dynamic/a:c	(ILcom/tencent/mm/plugin/sns/storage/SnsInfo;)V
        //   4533: aload_0
        //   4534: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4537: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   4540: istore 4
        //   4542: aload_0
        //   4543: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4546: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   4549: ifne +68 -> 4617
        //   4552: iconst_1
        //   4553: istore_3
        //   4554: new 538	com/tencent/mm/modelsns/SnsAdClick
        //   4557: dup
        //   4558: iload 4
        //   4560: iload_3
        //   4561: aload 11
        //   4563: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   4566: bipush 31
        //   4568: iload_2
        //   4569: iconst_0
        //   4570: invokespecial 817	com/tencent/mm/modelsns/SnsAdClick:<init>	(IIJIIB)V
        //   4573: astore_1
        //   4574: aload_1
        //   4575: aload_0
        //   4576: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4579: getfield 518	com/tencent/mm/plugin/sns/ui/listener/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
        //   4582: aload 11
        //   4584: bipush 22
        //   4586: invokestatic 544	com/tencent/mm/plugin/sns/data/m:a	(Lcom/tencent/mm/modelsns/SnsAdClick;Lcom/tencent/mm/plugin/sns/ad/g/l;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
        //   4589: aload_1
        //   4590: invokestatic 547	com/tencent/mm/plugin/sns/data/t:a	(Lcom/tencent/mm/modelsns/SnsAdClick;)V
        //   4593: aload_0
        //   4594: ldc 38
        //   4596: ldc 39
        //   4598: ldc 40
        //   4600: ldc 41
        //   4602: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   4605: ldc 23
        //   4607: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   4610: return
        //   4611: iconst_0
        //   4612: istore 9
        //   4614: goto -118 -> 4496
        //   4617: iconst_2
        //   4618: istore_3
        //   4619: goto -65 -> 4554
        //   4622: iconst_4
        //   4623: aload_0
        //   4624: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4627: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   4630: invokestatic 679	com/tencent/mm/plugin/sns/ad/timeline/a/a:f	(ILandroid/content/Context;)Lcom/tencent/mm/plugin/sns/ad/timeline/a/c;
        //   4633: astore 10
        //   4635: aload 10
        //   4637: ifnull +80 -> 4717
        //   4640: new 681	com/tencent/mm/plugin/sns/ad/timeline/a/d
        //   4643: dup
        //   4644: ldc_w 867
        //   4647: iload_2
        //   4648: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   4651: invokespecial 870	com/tencent/mm/plugin/sns/ad/timeline/a/d:<init>	(Ljava/lang/String;Ljava/lang/Object;)V
        //   4654: astore 12
        //   4656: aload 12
        //   4658: ldc_w 684
        //   4661: aload_0
        //   4662: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4665: getfield 518	com/tencent/mm/plugin/sns/ui/listener/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
        //   4668: invokevirtual 688	com/tencent/mm/plugin/sns/ad/timeline/a/d:put	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
        //   4671: pop
        //   4672: aload 10
        //   4674: aload_1
        //   4675: aload_0
        //   4676: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4679: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   4682: aload 11
        //   4684: aload 12
        //   4686: invokeinterface 693 5 0
        //   4691: istore 9
        //   4693: iload 9
        //   4695: ifeq +22 -> 4717
        //   4698: aload_0
        //   4699: ldc 38
        //   4701: ldc 39
        //   4703: ldc 40
        //   4705: ldc 41
        //   4707: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   4710: ldc 23
        //   4712: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   4715: return
        //   4716: astore_1
        //   4717: iload 4
        //   4719: ifle +98 -> 4817
        //   4722: aload 11
        //   4724: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   4727: getfield 697	com/tencent/mm/plugin/sns/storage/ADXml:adTurnInfo	Lcom/tencent/mm/plugin/sns/storage/ADXml$j;
        //   4730: getfield 702	com/tencent/mm/plugin/sns/storage/ADXml$j:adActionLink	Ljava/lang/String;
        //   4733: astore 10
        //   4735: aload 10
        //   4737: astore_1
        //   4738: aload 10
        //   4740: invokestatic 708	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   4743: ifeq +9 -> 4752
        //   4746: aload 11
        //   4748: invokevirtual 711	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdLink	()Ljava/lang/String;
        //   4751: astore_1
        //   4752: ldc_w 294
        //   4755: new 312	java/lang/StringBuilder
        //   4758: dup
        //   4759: ldc_w 872
        //   4762: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   4765: aload_1
        //   4766: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   4769: ldc_w 715
        //   4772: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   4775: aload 11
        //   4777: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   4780: getfield 718	com/tencent/mm/plugin/sns/storage/ADXml:webrightBar	I
        //   4783: invokevirtual 721	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   4786: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   4789: invokestatic 301	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   4792: aload_1
        //   4793: invokestatic 708	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
        //   4796: ifeq +31 -> 4827
        //   4799: aload_0
        //   4800: ldc 38
        //   4802: ldc 39
        //   4804: ldc 40
        //   4806: ldc 41
        //   4808: invokestatic 71	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   4811: ldc 23
        //   4813: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   4816: return
        //   4817: aload 11
        //   4819: invokevirtual 724	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdInfoLink	()Ljava/lang/String;
        //   4822: astore 10
        //   4824: goto -89 -> 4735
        //   4827: aload_0
        //   4828: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4831: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   4834: istore 4
        //   4836: aload_0
        //   4837: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4840: invokestatic 168	com/tencent/mm/plugin/sns/ui/listener/c:j	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)I
        //   4843: ifne +367 -> 5210
        //   4846: iconst_1
        //   4847: istore_3
        //   4848: new 538	com/tencent/mm/modelsns/SnsAdClick
        //   4851: dup
        //   4852: iload 4
        //   4854: iload_3
        //   4855: aload 11
        //   4857: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   4860: iconst_0
        //   4861: iload_2
        //   4862: iconst_0
        //   4863: invokespecial 817	com/tencent/mm/modelsns/SnsAdClick:<init>	(IIJIIB)V
        //   4866: astore 12
        //   4868: aload 12
        //   4870: aload_0
        //   4871: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4874: getfield 518	com/tencent/mm/plugin/sns/ui/listener/c:RoZ	Lcom/tencent/mm/plugin/sns/ad/g/l;
        //   4877: aload 11
        //   4879: bipush 22
        //   4881: invokestatic 544	com/tencent/mm/plugin/sns/data/m:a	(Lcom/tencent/mm/modelsns/SnsAdClick;Lcom/tencent/mm/plugin/sns/ad/g/l;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;I)V
        //   4884: aload 12
        //   4886: invokestatic 547	com/tencent/mm/plugin/sns/data/t:a	(Lcom/tencent/mm/modelsns/SnsAdClick;)V
        //   4889: new 549	android/content/Intent
        //   4892: dup
        //   4893: invokespecial 550	android/content/Intent:<init>	()V
        //   4896: astore 13
        //   4898: aload 11
        //   4900: invokevirtual 182	com/tencent/mm/plugin/sns/storage/SnsInfo:getAdXml	()Lcom/tencent/mm/plugin/sns/storage/ADXml;
        //   4903: getfield 718	com/tencent/mm/plugin/sns/storage/ADXml:webrightBar	I
        //   4906: ifne +309 -> 5215
        //   4909: iconst_1
        //   4910: istore 9
        //   4912: getstatic 729	com/tencent/mm/platformtools/z:pCv	Z
        //   4915: ifeq +6 -> 4921
        //   4918: iconst_0
        //   4919: istore 9
        //   4921: aload_1
        //   4922: astore 10
        //   4924: aload 11
        //   4926: ifnull +71 -> 4997
        //   4929: aload_1
        //   4930: astore 10
        //   4932: aload 11
        //   4934: invokevirtual 100	com/tencent/mm/plugin/sns/storage/SnsInfo:isAd	()Z
        //   4937: ifeq +60 -> 4997
        //   4940: aload_0
        //   4941: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   4944: aload 11
        //   4946: invokestatic 144	com/tencent/mm/plugin/sns/ui/listener/c:a	(Lcom/tencent/mm/plugin/sns/ui/listener/c;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)Lcom/tencent/mm/plugin/sns/storage/ADInfo;
        //   4949: astore 14
        //   4951: aload_1
        //   4952: astore 10
        //   4954: aload 14
        //   4956: ifnull +41 -> 4997
        //   4959: aload 13
        //   4961: ldc_w 731
        //   4964: aload 14
        //   4966: getfield 310	com/tencent/mm/plugin/sns/storage/ADInfo:viewId	Ljava/lang/String;
        //   4969: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   4972: pop
        //   4973: aload_1
        //   4974: aload 14
        //   4976: getfield 734	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
        //   4979: invokestatic 738	com/tencent/mm/plugin/sns/data/t:lY	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   4982: invokestatic 744	com/tencent/mm/plugin/sns/ad/c/a/a:aWj	(Ljava/lang/String;)Ljava/lang/String;
        //   4985: astore 10
        //   4987: aload 13
        //   4989: aload 14
        //   4991: getfield 734	com/tencent/mm/plugin/sns/storage/ADInfo:uxInfo	Ljava/lang/String;
        //   4994: invokestatic 747	com/tencent/mm/plugin/sns/data/t:i	(Landroid/content/Intent;Ljava/lang/String;)V
        //   4997: aload 13
        //   4999: ldc_w 749
        //   5002: iload 9
        //   5004: invokevirtual 624	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   5007: pop
        //   5008: new 751	android/os/Bundle
        //   5011: dup
        //   5012: invokespecial 752	android/os/Bundle:<init>	()V
        //   5015: astore_1
        //   5016: aload_1
        //   5017: ldc_w 754
        //   5020: aload 12
        //   5022: invokevirtual 758	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
        //   5025: aload_1
        //   5026: ldc_w 760
        //   5029: aload 11
        //   5031: invokevirtual 150	com/tencent/mm/plugin/sns/storage/SnsInfo:getTimeLine	()Lcom/tencent/mm/protocal/protobuf/TimeLineObject;
        //   5034: getfield 763	com/tencent/mm/protocal/protobuf/TimeLineObject:statExtStr	Ljava/lang/String;
        //   5037: invokevirtual 766	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
        //   5040: aload 13
        //   5042: ldc_w 768
        //   5045: aload_1
        //   5046: invokevirtual 771	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Bundle;)Landroid/content/Intent;
        //   5049: pop
        //   5050: aload 13
        //   5052: ldc_w 773
        //   5055: aload 10
        //   5057: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   5060: pop
        //   5061: aload 13
        //   5063: ldc_w 775
        //   5066: iconst_1
        //   5067: invokevirtual 624	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
        //   5070: pop
        //   5071: aload 13
        //   5073: ldc_w 777
        //   5076: aload 11
        //   5078: getfield 780	com/tencent/mm/plugin/sns/storage/SnsInfo:field_userName	Ljava/lang/String;
        //   5081: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   5084: pop
        //   5085: aload 13
        //   5087: ldc_w 782
        //   5090: bipush 15
        //   5092: invokevirtual 556	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
        //   5095: pop
        //   5096: aload 13
        //   5098: ldc_w 784
        //   5101: new 312	java/lang/StringBuilder
        //   5104: dup
        //   5105: ldc_w 786
        //   5108: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   5111: aload 11
        //   5113: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   5116: invokestatic 790	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
        //   5119: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   5122: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   5125: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   5128: pop
        //   5129: aload 13
        //   5131: ldc_w 792
        //   5134: aload 11
        //   5136: getfield 780	com/tencent/mm/plugin/sns/storage/SnsInfo:field_userName	Ljava/lang/String;
        //   5139: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   5142: pop
        //   5143: aload 13
        //   5145: ldc_w 794
        //   5148: new 312	java/lang/StringBuilder
        //   5151: dup
        //   5152: ldc_w 786
        //   5155: invokespecial 317	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   5158: aload 11
        //   5160: getfield 215	com/tencent/mm/plugin/sns/storage/SnsInfo:field_snsId	J
        //   5163: invokestatic 790	com/tencent/mm/plugin/sns/data/t:uA	(J)Ljava/lang/String;
        //   5166: invokevirtual 324	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   5169: invokevirtual 327	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   5172: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   5175: pop
        //   5176: aload 13
        //   5178: ldc_w 796
        //   5181: aload 11
        //   5183: getfield 780	com/tencent/mm/plugin/sns/storage/SnsInfo:field_userName	Ljava/lang/String;
        //   5186: invokevirtual 570	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
        //   5189: pop
        //   5190: getstatic 802	com/tencent/mm/plugin/sns/d/a:pFn	Lcom/tencent/mm/pluginsdk/m;
        //   5193: aload 13
        //   5195: aload_0
        //   5196: getfield 14	com/tencent/mm/plugin/sns/ui/listener/c$30:RQM	Lcom/tencent/mm/plugin/sns/ui/listener/c;
        //   5199: invokestatic 191	com/tencent/mm/plugin/sns/ui/listener/c:f	(Lcom/tencent/mm/plugin/sns/ui/listener/c;)Landroid/app/Activity;
        //   5202: invokeinterface 808 3 0
        //   5207: goto -2681 -> 2526
        //   5210: iconst_2
        //   5211: istore_3
        //   5212: goto -364 -> 4848
        //   5215: iconst_0
        //   5216: istore 9
        //   5218: goto -306 -> 4912
        //   5221: astore_1
        //   5222: goto -689 -> 4533
        //   5225: astore_1
        //   5226: goto -2559 -> 2667
        //   5229: aconst_null
        //   5230: astore 10
        //   5232: goto -1695 -> 3537
        //   5235: iconst_0
        //   5236: istore_2
        //   5237: iconst_0
        //   5238: istore_3
        //   5239: goto -3476 -> 1763
        //   5242: iconst_0
        //   5243: istore_3
        //   5244: goto -3489 -> 1755
        //   5247: aconst_null
        //   5248: astore 12
        //   5250: goto -4277 -> 973
        //   5253: aconst_null
        //   5254: astore 10
        //   5256: goto -4325 -> 931
        //   5259: aconst_null
        //   5260: astore 10
        //   5262: iload 6
        //   5264: istore_3
        //   5265: goto -4807 -> 458
        //   5268: iconst_0
        //   5269: istore_2
        //   5270: goto -4812 -> 458
        //   5273: iconst_0
        //   5274: istore_2
        //   5275: iload 5
        //   5277: istore 4
        //   5279: goto -4889 -> 390
        //   5282: iconst_0
        //   5283: istore_2
        //   5284: goto -4975 -> 309
        //   5287: iconst_0
        //   5288: istore_3
        //   5289: goto -5095 -> 194
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	5292	0	this	30
        //   0	5292	1	paramAnonymousView	View
        //   127	5157	2	i	int
        //   119	5170	3	j	int
        //   124	5154	4	k	int
        //   116	5160	5	m	int
        //   121	5142	6	n	int
        //   743	313	7	l	long
        //   1130	4087	9	bool	boolean
        //   12	990	10	localObject1	Object
        //   1017	16	10	localException	Exception
        //   1065	4196	10	localObject2	Object
        //   151	5031	11	localObject3	Object
        //   571	4678	12	localObject4	Object
        //   584	4610	13	localObject5	Object
        //   826	4164	14	localObject6	Object
        //   1200	421	15	localdmz	dmz
        //   1365	13	16	str	String
        // Exception table:
        //   from	to	target	type
        //   543	554	1017	java/lang/Exception
        //   563	596	1017	java/lang/Exception
        //   605	642	1017	java/lang/Exception
        //   996	1003	1017	java/lang/Exception
        //   2754	2767	2841	finally
        //   2772	2818	2841	finally
        //   4622	4635	4716	finally
        //   4640	4693	4716	finally
        //   4510	4533	5221	finally
        //   2644	2667	5225	finally
      }
    };
    this.RQq = new d()
    {
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(308525);
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)) && (com.tencent.mm.br.c.blq("favorite"))) {
          paramAnonymousContextMenu.add(0, 25, 0, c.f(c.this).getString(b.j.plugin_favorite_opt));
        }
        AppMethodBeat.o(308525);
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(308524);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          TimeLineObject localTimeLineObject = (TimeLineObject)paramAnonymousView.getTag();
          Object localObject = com.tencent.mm.plugin.sns.model.al.hgB();
          String str = localTimeLineObject.Id;
          SnsInfo localSnsInfo = new SnsInfo();
          if (!((w)localObject).QYS)
          {
            localObject = ((w)localObject).QYR.query("SnsInfo", null, "stringSeq=?", new String[] { String.valueOf(str) }, null, null, null, 2);
            if (!((Cursor)localObject).moveToFirst()) {
              break label196;
            }
            localSnsInfo.convertFrom((Cursor)localObject);
            ((Cursor)localObject).close();
          }
          for (localObject = localSnsInfo;; localObject = null)
          {
            if (localObject != null)
            {
              localObject = ((SnsInfo)localObject).getLocalid();
              c.this.RPU.a(paramAnonymousView, (String)localObject, localTimeLineObject);
            }
            AppMethodBeat.o(308524);
            return true;
            localObject = ((w)localObject).QYR.query("SnsInfo", null, "snsId=?", new String[] { w.baf(new StringBuilder().append(str).toString()) }, null, null, null, 2);
            break;
            label196:
            ((Cursor)localObject).close();
          }
        }
        AppMethodBeat.o(308524);
        return false;
      }
    };
    this.RQo = new d()
    {
      public final void b(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(308533);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        Object localObject;
        if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          paramAnonymousContextMenuInfo = (com.tencent.mm.plugin.sns.ui.s)paramAnonymousContextMenuInfo;
          localObject = paramAnonymousContextMenuInfo.RcF;
          if (com.tencent.mm.br.c.blq("favorite")) {
            switch (((TimeLineObject)localObject).ContentObj.Zpq)
            {
            default: 
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, com.tencent.mm.plugin.sns.model.al.hgB().aZL(paramAnonymousContextMenuInfo.hES));
          AppMethodBeat.o(308533);
          return;
          paramAnonymousContextMenu.add(0, 4, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
          localObject = new ex();
          ((ex)localObject).hFc.hES = paramAnonymousContextMenuInfo.hES;
          ((ex)localObject).publish();
          if (((ex)localObject).hFd.hEn)
          {
            paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(b.j.app_open));
            continue;
            paramAnonymousContextMenu.add(0, 4, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
            localObject = new ex();
            ((ex)localObject).hFc.hES = paramAnonymousContextMenuInfo.hES;
            ((ex)localObject).publish();
            if (((ex)localObject).hFd.hEn)
            {
              paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(b.j.app_open));
              continue;
              paramAnonymousContextMenu.add(0, 28, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
              localObject = new ex();
              ((ex)localObject).hFc.hES = paramAnonymousContextMenuInfo.hES;
              ((ex)localObject).publish();
              if (((ex)localObject).hFd.hEn)
              {
                paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(b.j.app_open));
                continue;
                paramAnonymousContextMenu.add(0, 5, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
                continue;
                paramAnonymousContextMenu.add(0, 9, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
                continue;
                paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
                localObject = new ex();
                ((ex)localObject).hFc.hES = paramAnonymousContextMenuInfo.hES;
                ((ex)localObject).publish();
                if (((ex)localObject).hFd.hEn)
                {
                  paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(b.j.app_open));
                  continue;
                  paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
                  continue;
                  paramAnonymousContextMenu.add(0, 22, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
                  continue;
                  paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
                  continue;
                  paramAnonymousContextMenu.add(0, 23, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
                  continue;
                  paramAnonymousContextMenu.add(0, 24, 0, paramAnonymousView.getContext().getString(b.j.plugin_favorite_opt));
                }
              }
            }
          }
        }
      }
      
      public final boolean jQ(View paramAnonymousView)
      {
        AppMethodBeat.i(308526);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          localObject = (com.tencent.mm.plugin.sns.ui.s)localObject;
          TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ui.s)localObject).RcF;
          if ((localTimeLineObject.ContentObj.Zpq == 10) || (localTimeLineObject.ContentObj.Zpq == 17) || (localTimeLineObject.ContentObj.Zpq == 22) || (localTimeLineObject.ContentObj.Zpq == 23))
          {
            AppMethodBeat.o(308526);
            return false;
          }
          c.this.RPU.a(paramAnonymousView, ((com.tencent.mm.plugin.sns.ui.s)localObject).hES, localTimeLineObject);
          AppMethodBeat.o(308526);
          return true;
        }
        AppMethodBeat.o(308526);
        return false;
      }
    };
    this.RNF = new SightPlayController.d()
    {
      public final void c(SightPlayController paramAnonymousSightPlayController, int paramAnonymousInt)
      {
        AppMethodBeat.i(308527);
        if ((paramAnonymousSightPlayController != null) && (paramAnonymousInt == 0)) {
          if (paramAnonymousSightPlayController.PFH == null) {
            break label88;
          }
        }
        label88:
        for (paramAnonymousSightPlayController = (View)paramAnonymousSightPlayController.PFH.get();; paramAnonymousSightPlayController = null)
        {
          if ((paramAnonymousSightPlayController != null) && ((paramAnonymousSightPlayController instanceof com.tencent.mm.plugin.sight.decode.model.a)))
          {
            paramAnonymousSightPlayController = (com.tencent.mm.plugin.sight.decode.model.a)paramAnonymousSightPlayController;
            paramAnonymousSightPlayController.getVideoPath();
            if ((paramAnonymousSightPlayController.getTagObject() != null) && ((paramAnonymousSightPlayController.getTagObject() instanceof com.tencent.mm.plugin.sns.ui.aw))) {
              paramAnonymousSightPlayController.getTagObject();
            }
          }
          AppMethodBeat.o(308527);
          return;
        }
      }
    };
    this.RQy = new c.34(this);
    this.RQz = new c.35(this);
    this.RQA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308528);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject1 = paramAnonymousView.Qsv;
          if ((localObject1 != null) && (!Util.isNullOrNil(((fdv)localObject1).abDm)) && (((fdv)localObject1).abDm.get(0) != null))
          {
            Object localObject2 = ((feb)((fdv)localObject1).abDm.get(0)).Md5;
            EmojiInfo localEmojiInfo = bl.jba().adju.bza((String)localObject2);
            Intent localIntent = new Intent();
            localIntent.putExtra("custom_smiley_preview_md5", (String)localObject2);
            if ((localEmojiInfo.field_catalog != EmojiGroupInfo.aklF) && (localEmojiInfo.field_catalog != EmojiGroupInfo.aklE) && (localEmojiInfo.field_catalog != EmojiGroupInfo.aklD)) {
              localIntent.putExtra("custom_smiley_preview_productid", localEmojiInfo.field_groupId);
            }
            com.tencent.mm.br.c.b(c.f(c.this), "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
            localObject2 = com.tencent.mm.plugin.sns.statistics.j.QFS;
            long l = com.tencent.mm.plugin.sns.storage.ai.aXe(paramAnonymousView.Rcm);
            paramAnonymousView = String.valueOf(((fdv)localObject1).abDh);
            localObject1 = t.uA(l);
            localObject1 = (j.a)((com.tencent.mm.plugin.sns.statistics.j)localObject2).QGg.get(localObject1);
            if ((localObject1 != null) && (!((j.a)localObject1).QGW.contains(paramAnonymousView))) {
              ((j.a)localObject1).QGW.add(paramAnonymousView);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308528);
      }
    };
  }
  
  private void a(View paramView, SnsInfo paramSnsInfo, int paramInt)
  {
    if (paramSnsInfo == null) {
      Log.e("MicroMsg.TimelineClickListener", "snsInfo is null");
    }
    for (;;)
    {
      return;
      ADXml.h localh = paramSnsInfo.getAdXml().getAdSelectInfo();
      if ((localh == null) || (this.QaL == null))
      {
        Log.e("MicroMsg.TimelineClickListener", "adSelectInfo or adClickActionHandler is null");
        return;
      }
      AdClickActionInfo localAdClickActionInfo = null;
      if (paramInt == 1001) {
        localAdClickActionInfo = localh.QHR;
      }
      while (localAdClickActionInfo != null)
      {
        this.QaL.a(localAdClickActionInfo, paramSnsInfo, 0);
        this.QaL.jg(paramView);
        return;
        if (paramInt == 1002) {
          localAdClickActionInfo = localh.QHS;
        }
      }
    }
  }
  
  private void a(View paramView, SnsInfo paramSnsInfo, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      try
      {
        if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          m((BaseTimeLineItem.BaseViewHolder)paramView.getTag());
          paramView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.T(paramSnsInfo);
          if (!Util.isNullOrNil(paramView)) {
            paramSnsInfo.getAdSnsInfo().field_adxml = paramView;
          }
          int k = this.source;
          if (this.source == 0)
          {
            i = 1;
            long l = paramSnsInfo.field_snsId;
            if (!paramBoolean) {
              break label522;
            }
            j = 22;
            paramView = new SnsAdClick(k, i, l, paramInt1, j);
            com.tencent.mm.plugin.sns.data.m.a(paramView, this.RoZ, paramSnsInfo, paramInt1);
            t.a(paramView);
            paramView = new Intent();
            paramView.putExtra("img_gallery_left", paramArrayOfInt[0]);
            paramView.putExtra("img_gallery_top", paramArrayOfInt[1]);
            paramView.putExtra("img_gallery_width", paramInt3);
            paramView.putExtra("img_gallery_height", paramInt4);
            paramView.putExtra("sns_landing_pages_share_sns_id", paramSnsInfo.getSnsId());
            paramView.putExtra("sns_landing_pages_rawSnsId", paramSnsInfo.getTimeLine().Id);
            paramView.putExtra("sns_landing_pages_ux_info", paramSnsInfo.getUxinfo());
            if (paramInt2 != 2) {
              break label529;
            }
            paramView.putExtra("sns_landing_pages_aid", paramSnsInfo.getAid());
            paramView.putExtra("sns_landing_pages_traceid", paramSnsInfo.getTraceid());
            paramArrayOfInt = paramSnsInfo.getTimeLine();
            if (paramArrayOfInt != null)
            {
              paramArrayOfInt = paramArrayOfInt.ContentObj.Zpr;
              if (paramArrayOfInt.size() > 0) {
                paramView.putExtra("sns_landing_pages_share_thumb_url", ((dmz)paramArrayOfInt.get(0)).aaTl);
              }
            }
            paramView.setClass(this.activity, SnsAdNativeLandingPagesUI.class);
            paramInt1 = 1;
            if (this.source != 2) {
              break label547;
            }
            paramInt1 = 16;
            paramView.putExtra("sns_landig_pages_from_source", paramInt1);
            paramView.putExtra("sns_landing_pages_xml", paramString);
            paramView.putExtra("sns_landing_pages_rec_src", paramSnsInfo.getAdRecSrc());
            paramView.putExtra("sns_landing_pages_xml_prefix", "adxml");
            paramView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            paramView.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
            paramString = this.activity;
            paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
            com.tencent.mm.hellhoundlib.a.a.b(paramString, paramView.aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener", "selectCardBtnJumpCanvas", "(Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;ILjava/lang/String;ZI[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)paramView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener", "selectCardBtnJumpCanvas", "(Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;ILjava/lang/String;ZI[III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            this.activity.overridePendingTransition(0, 0);
            if ((paramInt2 != 2) || (this.Rca == null)) {
              break;
            }
            this.Rca.hgf().P(paramSnsInfo);
          }
        }
        else
        {
          if (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
            continue;
          }
          a((com.tencent.mm.plugin.sns.ui.c.a.b)paramView.getTag());
          continue;
        }
        int i = 2;
      }
      finally
      {
        Log.e("MicroMsg.TimelineClickListener", paramView.toString());
        return;
      }
      continue;
      label522:
      int j = 21;
      continue;
      label529:
      if (paramInt2 == 1)
      {
        paramView.putExtra("sns_landing_is_native_sight_ad", true);
        continue;
        label547:
        paramInt3 = this.source;
        if (paramInt3 == 1) {
          paramInt1 = 2;
        }
      }
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, SnsInfo paramSnsInfo, int paramInt)
  {
    try
    {
      if (!Util.isNullOrNil(paramString1))
      {
        if (paramInt == 2) {}
        for (ADInfo localADInfo = paramSnsInfo.getAtAdInfo(); localADInfo == null; localADInfo = paramSnsInfo.getAdInfo())
        {
          Log.e("MicroMsg.TimelineClickListener", "jumpWeApp adInfo==null");
          return false;
        }
        String str = t.uA(paramSnsInfo.field_snsId) + ":" + localADInfo.uxInfo + ":" + com.tencent.mm.plugin.sns.model.al.hgg() + ":" + System.currentTimeMillis();
        if (paramInt == 0) {}
        for (paramInt = 1045;; paramInt = 1046)
        {
          t.a(paramString1, com.tencent.mm.plugin.sns.data.m.cW(paramString2, localADInfo.addClickTimeToWeAppPath), paramString3, paramSnsInfo.getAid(), paramSnsInfo.getTraceid(), str, localADInfo.uxInfo, paramInt);
          return true;
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.TimelineClickListener", "jumpWeApp exp:" + paramString1.toString());
    }
  }
  
  private ADInfo j(SnsInfo paramSnsInfo)
  {
    if (paramSnsInfo != null)
    {
      if (this.source == 2) {
        return paramSnsInfo.getAtAdInfo();
      }
      return paramSnsInfo.getAdInfo();
    }
    return null;
  }
  
  public final void a(a.b paramb, Bundle paramBundle)
  {
    if (this.RPQ != null)
    {
      Log.w("MicroMsg.TimelineClickListener", "preapre FullCardAnim, timelineClickAnimation!=null");
      return;
    }
    boolean bool4;
    boolean bool3;
    boolean bool2;
    boolean bool1;
    if (paramBundle != null)
    {
      bool4 = paramBundle.getBoolean("ad_no_click_anim", false);
      bool3 = paramBundle.getBoolean("ad_no_back_anim", false);
      bool2 = paramBundle.getBoolean("isSimpleTwistAnim", false);
      bool1 = paramBundle.getBoolean("isTwistClockwise", false);
    }
    for (;;)
    {
      if (bool2) {
        this.RPQ = new com.tencent.mm.plugin.sns.ui.b.b.g((MMActivity)this.activity, paramb, bool1);
      }
      for (;;)
      {
        if (!bool3) {
          this.RPR = new com.tencent.mm.plugin.sns.ui.b.b.e((MMActivity)this.activity, paramb);
        }
        paramb.Qcx.QbV = true;
        return;
        if (!bool4) {
          this.RPQ = new com.tencent.mm.plugin.sns.ui.b.b.f((MMActivity)this.activity, paramb);
        }
      }
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
  }
  
  public final void a(com.tencent.mm.plugin.sns.ui.c.a.b paramb)
  {
    if (this.RPS != null) {
      Log.w("MicroMsg.TimelineClickListener", "has already prepare detail click animation");
    }
    do
    {
      return;
      if ((paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
      {
        this.RPS = new com.tencent.mm.plugin.sns.ui.b.a.d(paramb);
        this.RPT = new com.tencent.mm.plugin.sns.ui.b.a.c((MMActivity)this.activity, paramb);
        return;
      }
      if ((paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.d))
      {
        a(((com.tencent.mm.plugin.sns.ui.c.a.d)paramb).RJA, null);
        return;
      }
      if ((paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.h))
      {
        this.RPS = new com.tencent.mm.plugin.sns.ui.b.a.j((MMActivity)this.activity, paramb);
        this.RPT = new com.tencent.mm.plugin.sns.ui.b.a.i((MMActivity)this.activity, paramb);
        return;
      }
      if ((paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.f))
      {
        this.RPS = new com.tencent.mm.plugin.sns.ui.b.a.h((MMActivity)this.activity, paramb);
        this.RPT = new com.tencent.mm.plugin.sns.ui.b.a.g((MMActivity)this.activity, paramb);
        return;
      }
    } while (!(paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.e));
    this.RPS = new com.tencent.mm.plugin.sns.ui.b.a.f((MMActivity)this.activity, paramb);
    this.RPT = new com.tencent.mm.plugin.sns.ui.b.a.e((MMActivity)this.activity, paramb);
  }
  
  public final void c(com.tencent.mm.plugin.sns.ad.g.l paraml)
  {
    this.RoZ = paraml;
    if (this.RPU != null) {
      this.RPU.c(paraml);
    }
    this.QaL = new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.activity, this.source, this.RoZ, null, null);
  }
  
  public final void fSy()
  {
    this.RPU.fSy();
    this.RQJ.alive();
    this.RQK.alive();
  }
  
  public abstract void gt(Object paramObject);
  
  public abstract void hlJ();
  
  public abstract void hlK();
  
  public abstract void hlL();
  
  public abstract void hlM();
  
  public abstract void jA(View paramView);
  
  public abstract void jB(View paramView);
  
  public abstract void jC(View paramView);
  
  public abstract void jD(View paramView);
  
  public abstract void jE(View paramView);
  
  public abstract void jF(View paramView);
  
  public abstract void jz(View paramView);
  
  public final void m(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    if (this.RPQ != null) {
      Log.w("MicroMsg.TimelineClickListener", "has already prepare click animation");
    }
    do
    {
      return;
      if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.a.a))
      {
        this.RPQ = new com.tencent.mm.plugin.sns.ui.b.b.d((MMActivity)this.activity, paramBaseViewHolder);
        this.RPR = new com.tencent.mm.plugin.sns.ui.b.b.c((MMActivity)this.activity, paramBaseViewHolder);
        ((com.tencent.mm.plugin.sns.ui.item.a.a)paramBaseViewHolder).QbV = true;
        return;
      }
      if ((paramBaseViewHolder instanceof f.a))
      {
        a(((f.a)paramBaseViewHolder).RMK, null);
        return;
      }
      if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.p.b))
      {
        this.RPQ = new com.tencent.mm.plugin.sns.ui.b.b.m((MMActivity)this.activity, paramBaseViewHolder);
        this.RPR = new com.tencent.mm.plugin.sns.ui.b.b.l((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
      if ((paramBaseViewHolder instanceof n.a))
      {
        this.RPQ = new com.tencent.mm.plugin.sns.ui.b.b.k((MMActivity)this.activity, paramBaseViewHolder);
        this.RPR = new com.tencent.mm.plugin.sns.ui.b.b.j((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
    } while (!(paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ad.timeline.b.a.a.a));
    this.RPQ = new com.tencent.mm.plugin.sns.ui.b.b.i((MMActivity)this.activity, paramBaseViewHolder);
    this.RPR = new com.tencent.mm.plugin.sns.ui.b.b.h((MMActivity)this.activity, paramBaseViewHolder);
  }
  
  public final void removeListener()
  {
    this.RPU.removeListener();
    this.RQJ.dead();
    this.RQK.dead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.listener.c
 * JD-Core Version:    0.7.0.1
 */