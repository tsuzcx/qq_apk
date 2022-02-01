package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.f.a.sw;
import com.tencent.mm.f.a.zc;
import com.tencent.mm.f.a.zd;
import com.tencent.mm.f.b.a.ah;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.plugin.findersdk.a.y.b;
import com.tencent.mm.plugin.findersdk.a.y.c;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.ad.f.p.b;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.at.b;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADInfo.c;
import com.tencent.mm.plugin.sns.storage.ADInfo.c.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.e;
import com.tencent.mm.plugin.sns.storage.ADXml.f;
import com.tencent.mm.plugin.sns.storage.ADXml.j;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.SnsWsFoldDetailUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bm.b;
import com.tencent.mm.plugin.sns.ui.bt;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.h.a;
import com.tencent.mm.plugin.sns.ui.item.r.a;
import com.tencent.mm.plugin.sns.ui.item.r.b;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.ejo;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.protocal.protobuf.ejx;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.protocal.protobuf.ekj;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class c
{
  ai KCs;
  public View.OnClickListener KEA;
  protected com.tencent.mm.plugin.sns.ad.f.l KPn;
  volatile com.tencent.mm.plugin.sns.ui.b.b.b LoL;
  volatile com.tencent.mm.plugin.sns.ui.b.b.a LoM;
  volatile com.tencent.mm.plugin.sns.ui.b.a.b LoN;
  volatile com.tencent.mm.plugin.sns.ui.b.a.a LoO;
  public b LoP;
  public View.OnClickListener LoQ;
  public View.OnLongClickListener LoR;
  public d LoS;
  public View.OnClickListener LoT;
  public View.OnClickListener LoU;
  public View.OnClickListener LoV;
  public View.OnClickListener LoW;
  public View.OnClickListener LoX;
  public View.OnClickListener LoY;
  public View.OnClickListener LoZ;
  public b.e Loc;
  public View.OnClickListener LpA = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100219);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      if (paramAnonymousView.getTag() == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100219);
        return;
      }
      localObject1 = c.gJ(paramAnonymousView);
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
        j = com.tencent.mm.plugin.sns.storage.y.lj(((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl(), ((SnsInfo)localObject1).getUxinfo());
        if (j > 0)
        {
          i = 1;
          localObject2 = ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl();
          String str1 = ((SnsInfo)localObject1).getUxinfo();
          com.tencent.mm.kernel.h.aHE();
          String str2 = com.tencent.mm.kernel.b.aGq();
          if (i == 0) {
            break label281;
          }
          if (i == 0) {
            break label286;
          }
          k = 0;
          label182:
          com.tencent.mm.plugin.sns.storage.y.b((String)localObject2, str1, str2, j, k, "");
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject2 = ((SnsInfo)localObject1).getTimeLine();
        if ((((TimeLineObject)localObject2).ContentObj.Sqq == 15) && (((TimeLineObject)localObject2).sightFolded != 1)) {
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
          if (((((TimeLineObject)localObject2).ContentObj.Sqq == 1) && (((TimeLineObject)localObject2).ContentObj.Sqr.size() == 1)) || (((TimeLineObject)localObject2).ContentObj.Sqq == 7)) {
            c.b(c.this, paramAnonymousView, (SnsInfo)localObject1, 1002, ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getRightCanvasInfo(), bool);
          }
        }
      }
    }
  };
  public View.OnClickListener LpB;
  public bm.b LpC;
  int LpD;
  private IListener<zd> LpE = new IListener() {};
  private IListener<zc> LpF = new IListener() {};
  public View.OnClickListener LpG = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(201022);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      localObject1 = paramAnonymousView.getTag();
      Object localObject3 = null;
      Object localObject2;
      if ((localObject1 instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        localObject1 = com.tencent.mm.plugin.sns.storage.f.bbk(((BaseTimeLineItem.BaseViewHolder)localObject2).fLp);
        localObject3 = ((BaseTimeLineItem.BaseViewHolder)localObject2).LkU;
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
            if ((((SnsInfo)localObject1).getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(((SnsInfo)localObject1).getAdSnsInfo().field_adxml)))
            {
              localObject5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.R((SnsInfo)localObject1);
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
                  localObject2 = ((TimeLineObject)localObject2).ContentObj.Sqr;
                  if (((List)localObject2).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((cvt)((List)localObject2).get(0)).TDF);
                  }
                }
                paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (c.this.source != 2) {
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
                localObject2 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramAnonymousView.aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject2).startActivity((Intent)paramAnonymousView.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.this.activity.overridePendingTransition(0, 0);
                j = c.this.source;
                if (c.this.source != 0) {
                  break label669;
                }
              }
              label652:
              label669:
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 23, 21));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201022);
                return;
                if (!(localObject1 instanceof SnsInfo)) {
                  break label1354;
                }
                localObject1 = (SnsInfo)localObject1;
                localObject2 = (MMImageView)paramAnonymousView.getTag(i.f.link_ad_left_iv);
                break;
                if (localObject2 == null) {
                  break label211;
                }
                ((MMImageView)localObject2).getLocationInWindow((int[])localObject4);
                i = ((MMImageView)localObject2).getWidth();
                j = ((MMImageView)localObject2).getHeight();
                break label211;
                if (c.this.source != 1) {
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
              com.tencent.mm.by.c.b(c.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
              j = c.this.source;
              if (c.this.source == 0) {}
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 23, 11));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201022);
                return;
              }
            }
            if (c.a(c.this, (ADInfo)localObject5, (SnsInfo)localObject1, false))
            {
              j = c.this.source;
              if (c.this.source == 0) {}
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 23, 31));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(201022);
                return;
              }
            }
          }
          int j = c.this.source;
          if (c.this.source != 0) {
            break label1343;
          }
          i = 1;
          localObject3 = new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 23, 0);
          com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject3);
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
          if (ac.mFV) {
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
                localObject2 = com.tencent.mm.plugin.sns.data.t.kw(paramAnonymousView, localADInfo.uxInfo);
                com.tencent.mm.plugin.sns.data.t.g((Intent)localObject5, localADInfo.uxInfo);
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
          ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("pre_username", ((SnsInfo)localObject1).field_userName);
          ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("preUsername", ((SnsInfo)localObject1).field_userName);
          com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject5, c.this.activity);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201022);
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
  public View.OnClickListener Lpa;
  public View.OnClickListener Lpb;
  public d Lpc;
  public d Lpd;
  public d Lpe;
  public d Lpf;
  public d Lpg;
  public d Lph;
  public d Lpi;
  d Lpj;
  public d Lpk;
  public d Lpl;
  public View.OnClickListener Lpm;
  public View.OnClickListener Lpn;
  public View.OnClickListener Lpo;
  public View.OnClickListener Lpp;
  public View.OnClickListener Lpq;
  public View.OnClickListener Lpr;
  public View.OnClickListener Lps;
  public View.OnClickListener Lpt;
  public View.OnClickListener Lpu;
  public View.OnClickListener Lpv;
  public View.OnClickListener Lpw;
  public AdapterView.OnItemClickListener Lpx;
  public AdapterView.OnItemClickListener Lpy;
  public View.OnClickListener Lpz = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100199);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      if (paramAnonymousView.getTag() == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100199);
        return;
      }
      localObject1 = c.gJ(paramAnonymousView);
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
        j = com.tencent.mm.plugin.sns.storage.y.lj(((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl(), ((SnsInfo)localObject1).getUxinfo());
        if (j > 0)
        {
          i = 1;
          localObject2 = ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl();
          String str1 = ((SnsInfo)localObject1).getUxinfo();
          com.tencent.mm.kernel.h.aHE();
          String str2 = com.tencent.mm.kernel.b.aGq();
          if (i == 0) {
            break label281;
          }
          if (i == 0) {
            break label286;
          }
          k = 0;
          label182:
          com.tencent.mm.plugin.sns.storage.y.b((String)localObject2, str1, str2, j, k, "");
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject2 = ((SnsInfo)localObject1).getTimeLine();
        if ((((TimeLineObject)localObject2).ContentObj.Sqq == 15) && (((TimeLineObject)localObject2).sightFolded != 1)) {
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
          if (((((TimeLineObject)localObject2).ContentObj.Sqq == 1) && (((TimeLineObject)localObject2).ContentObj.Sqr.size() == 1)) || (((TimeLineObject)localObject2).ContentObj.Sqq == 7)) {
            c.b(c.this, paramAnonymousView, (SnsInfo)localObject1, 1001, ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getLeftCanvasInfo(), bool);
          }
        }
      }
    }
  };
  Activity activity;
  int source = 0;
  public View.OnTouchListener yQj;
  
  public c(int paramInt, Activity paramActivity, ai paramai)
  {
    this.source = paramInt;
    this.activity = paramActivity;
    this.KCs = paramai;
    this.LpD = Util.getInt(com.tencent.mm.n.h.axc().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
    Log.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[] { Integer.valueOf(this.LpD) });
    this.LoP = new b(this.activity, this.source, this.KCs);
    this.Lpa = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100258);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Long)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100258);
          return;
        }
        long l = ((Long)paramAnonymousView.getTag()).longValue();
        AdSnsInfo localAdSnsInfo = aj.fOL().QX(l);
        SnsInfo localSnsInfo = localAdSnsInfo.convertToSnsInfo();
        com.tencent.mm.plugin.sns.ad.f.p.a(p.b.JGd, com.tencent.mm.plugin.sns.ad.f.p.a.JGb, localAdSnsInfo.convertToSnsInfo(), c.this.source);
        localAdSnsInfo.getSource();
        localObject1 = localSnsInfo.getAdInfoLink();
        paramAnonymousView = (View)localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          paramAnonymousView = localSnsInfo.getAdLink();
        }
        int i;
        Object localObject2;
        int j;
        if ((localSnsInfo != null) && (localSnsInfo.isAd()))
        {
          localObject1 = c.a(c.this, localSnsInfo);
          i = -1;
          localObject2 = com.tencent.mm.model.c.d.bgC().buS("Sns_CanvasAd_DetailLink_JumpWay");
          if (((com.tencent.mm.storage.a)localObject2).isValid()) {
            i = Util.getInt(((com.tencent.mm.storage.a)localObject2).field_value, -1);
          }
          if ((localObject1 != null) && (((ADInfo)localObject1).adActionType == 1))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("key_card_id", ((ADInfo)localObject1).adActionCardTpId);
            paramAnonymousView.putExtra("key_card_ext", ((ADInfo)localObject1).adActionCardExt);
            paramAnonymousView.putExtra("key_from_scene", 21);
            paramAnonymousView.putExtra("key_stastic_scene", 15);
            com.tencent.mm.by.c.b(c.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
            j = c.this.source;
            if (c.this.source == 0) {}
            for (i = 1;; i = 2)
            {
              paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 11);
              com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, localSnsInfo, 3);
              com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100258);
              return;
            }
          }
          if ((localObject1 != null) && (i == 1))
          {
            if ((localSnsInfo.getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(localSnsInfo.getAdSnsInfo().field_adxml)))
            {
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.R(localSnsInfo);
              if (!Util.isNullOrNil(paramAnonymousView)) {
                localAdSnsInfo.field_adxml = paramAnonymousView;
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
                localObject1 = ((TimeLineObject)localObject1).ContentObj.Sqr;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((cvt)((List)localObject1).get(0)).TDF);
                }
              }
              c.a(c.this, paramAnonymousView, localSnsInfo);
              paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
              i = 9;
              if (c.this.source == 2)
              {
                i = 16;
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", localSnsInfo.getAdSnsInfo().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", localSnsInfo.getAdRecSrc());
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                paramAnonymousView.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
                localObject1 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousView.aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                j = c.this.source;
                if (c.this.source != 0) {
                  break label827;
                }
              }
              label827:
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 21);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, localSnsInfo, 3);
                com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100258);
                return;
                if (c.this.source != 1) {
                  break;
                }
                i = 10;
                break;
              }
            }
          }
          else if ((localObject1 != null) && (i == 0))
          {
            if ((!localSnsInfo.getAdXml().isLandingPagesAd()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(localSnsInfo.getAdSnsInfo().field_adxml))) {
              break label2113;
            }
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.R(localSnsInfo);
            if (!Util.isNullOrNil((String)localObject1)) {
              localAdSnsInfo.field_adxml = ((String)localObject1);
            }
            localObject1 = XmlParser.parseXml(localSnsInfo.getAdSnsInfo().field_adxml, "adxml", null);
            if (localObject1 != null)
            {
              localObject1 = Util.nullAs((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareWebUrl"), "");
              if (Util.isNullOrNil((String)localObject1)) {
                break label2113;
              }
              paramAnonymousView = (View)localObject1;
            }
          }
        }
        label2107:
        label2113:
        for (;;)
        {
          j = c.this.source;
          label962:
          Intent localIntent;
          if (c.this.source == 0)
          {
            i = 1;
            localObject2 = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 0);
            com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject2, c.this.KPn, localSnsInfo, 3);
            com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject2);
            Log.i("MicroMsg.TimelineClickListener", "adTagClick, adlink url " + paramAnonymousView + " " + localSnsInfo.getAdXml().webrightBar);
            localIntent = new Intent();
            if (localSnsInfo.getAdXml().webrightBar != 0) {
              break label2107;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            if (ac.mFV) {
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
                  localObject1 = com.tencent.mm.plugin.sns.ad.c.a.a.aYo(com.tencent.mm.plugin.sns.data.t.kw(paramAnonymousView, localADInfo.uxInfo));
                  com.tencent.mm.plugin.sns.data.t.g(localIntent, localADInfo.uxInfo);
                }
              }
            }
            localIntent.putExtra("KRightBtn", bool);
            paramAnonymousView = new Bundle();
            paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject2);
            paramAnonymousView.putString("key_snsad_statextstr", localAdSnsInfo.getTimeLine().statExtStr);
            localIntent.putExtra("jsapiargs", paramAnonymousView);
            localIntent.putExtra("rawUrl", (String)localObject1);
            localIntent.putExtra("useJs", true);
            localIntent.putExtra("srcUsername", localSnsInfo.field_userName);
            localIntent.putExtra("sns_local_id", localSnsInfo.getLocalid());
            localIntent.putExtra("stastic_scene", 15);
            localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId));
            localIntent.putExtra("pre_username", localSnsInfo.field_userName);
            localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId));
            localIntent.putExtra("preUsername", localSnsInfo.field_userName);
            com.tencent.mm.plugin.sns.c.a.mIG.h(localIntent, c.this.activity);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100258);
            return;
            Log.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + localSnsInfo.getAdSnsInfo().field_adxml);
            break;
            if ((localObject1 != null) && (i == -1) && (((ADInfo)localObject1).adActionType == 3))
            {
              if ((!localSnsInfo.getAdXml().isLandingPagesAd()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(localSnsInfo.getAdSnsInfo().field_adxml))) {
                break label2113;
              }
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.R(localSnsInfo);
              if (!Util.isNullOrNil(paramAnonymousView)) {
                localAdSnsInfo.field_adxml = paramAnonymousView;
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
                localObject1 = ((TimeLineObject)localObject1).ContentObj.Sqr;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((cvt)((List)localObject1).get(0)).TDF);
                }
              }
              c.a(c.this, paramAnonymousView, localSnsInfo);
              paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
              i = 9;
              if (c.this.source == 2)
              {
                i = 16;
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", localSnsInfo.getAdSnsInfo().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", localSnsInfo.getAdRecSrc());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                paramAnonymousView.putExtra("sns_landing_page_start_time", System.currentTimeMillis());
                localObject1 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousView.aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                j = c.this.source;
                if (c.this.source != 0) {
                  break label1895;
                }
              }
              label1895:
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 21);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, localSnsInfo, 3);
                com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100258);
                return;
                if (c.this.source != 1) {
                  break;
                }
                i = 10;
                break;
              }
            }
            if (c.a(c.this, (ADInfo)localObject1, localSnsInfo, false))
            {
              j = c.this.source;
              if (c.this.source == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 31);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, localSnsInfo, 3);
                com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100258);
                return;
              }
            }
            if (!com.tencent.mm.plugin.sns.ad.d.l.a(c.this.activity, localSnsInfo.getAdXml(), localSnsInfo.getAdInfo(), localSnsInfo.field_snsId, 2)) {
              break label2113;
            }
            j = c.this.source;
            if (c.this.source == 0) {}
            for (i = 1;; i = 2)
            {
              paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 41);
              com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, localSnsInfo, 3);
              com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100258);
              return;
            }
            i = 2;
            break label962;
          }
        }
      }
    };
    this.Lpn = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(100259);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        localObject1 = aj.fOI().bbl(paramAnonymousView);
        if (localObject1 == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        Object localObject2 = ((SnsInfo)localObject1).getTimeLine();
        Object localObject3 = ((TimeLineObject)localObject2).Location;
        Object localObject4;
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
          int j = c.this.source;
          if (c.this.source == 0) {}
          for (int i = 1;; i = 2)
          {
            localObject3 = new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 19, 0);
            com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject3, c.this.KPn, (SnsInfo)localObject1, 19);
            com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject3);
            if (!Util.isNullOrNil(((ADInfo)localObject2).adActionPOILink)) {
              break;
            }
            Log.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
          if (c.this.source == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.l.wO(724);; paramAnonymousView = com.tencent.mm.modelsns.l.wP(724))
          {
            paramAnonymousView.Xf(com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject1)).wR(((SnsInfo)localObject1).field_type).gx(((SnsInfo)localObject1).isAd()).Xf(((SnsInfo)localObject1).getUxinfo()).Xf("").Xf("").Xf("").Xf("").Xf(((ADInfo)localObject2).adActionPOIName).Xf("").Xf("");
            paramAnonymousView.bpa();
            Log.i("MicroMsg.TimelineClickListener", "open webview url : " + ((ADInfo)localObject2).adActionPOILink);
            paramAnonymousView = new Intent();
            if ((localObject1 != null) && (((SnsInfo)localObject1).isAd()))
            {
              localObject4 = c.a(c.this, (SnsInfo)localObject1);
              if (localObject4 != null) {
                paramAnonymousView.putExtra("KsnsViewId", ((ADInfo)localObject4).viewId);
              }
            }
            localObject4 = new Bundle();
            ((Bundle)localObject4).putParcelable("KSnsAdTag", (Parcelable)localObject3);
            paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject4);
            paramAnonymousView.putExtra("useJs", true);
            paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject1).field_snsId));
            paramAnonymousView.putExtra("pre_username", ((SnsInfo)localObject1).field_userName);
            paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject1).field_snsId));
            paramAnonymousView.putExtra("preUsername", ((SnsInfo)localObject1).field_userName);
            paramAnonymousView.putExtra("rawUrl", com.tencent.mm.plugin.sns.data.t.kw(((ADInfo)localObject2).adActionPOILink, ((ADInfo)localObject2).uxInfo));
            com.tencent.mm.plugin.sns.c.a.mIG.h(paramAnonymousView, c.this.activity);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
        }
        if (c.this.source == 0) {}
        for (paramAnonymousView = com.tencent.mm.modelsns.l.wO(724);; paramAnonymousView = com.tencent.mm.modelsns.l.wP(724))
        {
          paramAnonymousView.Xf(com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject1)).wR(((SnsInfo)localObject1).field_type).gx(((SnsInfo)localObject1).isAd()).Xf(((SnsInfo)localObject1).getUxinfo()).Xf(((cst)localObject3).SOz).wR(((cst)localObject3).KFw).Xf(((cst)localObject3).ScP).Xf(((cst)localObject3).ScO).Xf(((cst)localObject3).poiName).Xf(((cst)localObject3).KFu).Xf(((cst)localObject3).mVA);
          paramAnonymousView.bpa();
          paramAnonymousView = new Intent();
          localObject1 = new eka();
          ((eka)localObject1).ScO = ((cst)localObject3).ScO;
          ((eka)localObject1).ScP = ((cst)localObject3).ScP;
          ((eka)localObject1).mVA = ((cst)localObject3).mVA;
          ((eka)localObject1).poiName = ((cst)localObject3).poiName;
          ((eka)localObject1).KFu = ((cst)localObject3).KFu;
          ((eka)localObject1).SOz = ((cst)localObject3).SOz;
          ((eka)localObject1).KFw = ((cst)localObject3).KFw;
          ((eka)localObject1).TAy = ((cst)localObject3).TAy;
          ((eka)localObject1).TAz = ((cst)localObject3).TAz;
          ((eka)localObject1).TAA = ((cst)localObject3).TAA;
          ((eka)localObject1).KFz = ((cst)localObject3).KFz;
          localObject4 = com.tencent.mm.plugin.report.service.h.IzE;
          com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.y.class);
          ((com.tencent.mm.plugin.report.service.h)localObject4).p(1663L, 0L, 1L);
          ((com.tencent.mm.plugin.findersdk.a.y)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.findersdk.a.y.class)).a((eka)localObject1, y.a.Bvj, ((TimeLineObject)localObject2).Id, new y.c()
          {
            public final void a(y.b paramAnonymous2b)
            {
              AppMethodBeat.i(193804);
              int i;
              if (paramAnonymous2b == y.b.Bvm) {
                if (!Util.isNullOrNil(this.LpU.SOz)) {
                  i = 1;
                }
              }
              for (;;)
              {
                if (i == 0)
                {
                  paramAnonymousView.putExtra("map_view_type", 7);
                  paramAnonymousView.putExtra("kwebmap_slat", this.LpU.ScP);
                  paramAnonymousView.putExtra("kwebmap_lng", this.LpU.ScO);
                  paramAnonymousView.putExtra("kPoiName", this.LpU.poiName);
                  paramAnonymousView.putExtra("Kwebmap_locaion", this.LpU.KFu);
                  com.tencent.mm.by.c.b(c.this.activity, "location", ".ui.RedirectUI", paramAnonymousView);
                  AppMethodBeat.o(193804);
                  return;
                  i = 0;
                  continue;
                  if (paramAnonymous2b == y.b.Bvq) {
                    i = 0;
                  }
                }
                else
                {
                  if (c.this.LpD == 0) {}
                  for (paramAnonymous2b = String.format(com.tencent.mm.protocal.d.RAM, new Object[] { this.LpU.SOz });; paramAnonymous2b = String.format(com.tencent.mm.protocal.d.RAN, new Object[] { this.LpU.SOz, this.KXr.Id }))
                  {
                    paramAnonymousView.putExtra("rawUrl", paramAnonymous2b);
                    com.tencent.mm.plugin.sns.c.a.mIG.h(paramAnonymousView, c.this.activity);
                    AppMethodBeat.o(193804);
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
    this.Lpr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100260);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        paramAnonymousView = aj.fOI().bbl(paramAnonymousView);
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
          String str = com.tencent.mm.plugin.sns.data.t.kw(paramAnonymousView.adActionExtTailLink, paramAnonymousView.uxInfo);
          com.tencent.mm.plugin.sns.data.t.g((Intent)localObject, paramAnonymousView.uxInfo);
          ((Intent)localObject).putExtra("rawUrl", str);
          com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject, c.this.activity);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100260);
      }
    };
    this.Lps = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100261);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        int j;
        if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          localObject = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).fAg;
          localObject = aj.fOI().bbl((String)localObject);
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100261);
            return;
          }
          if (((SnsInfo)localObject).isAd())
          {
            Log.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
            j = c.this.source;
            if (c.this.source != 0) {
              break label193;
            }
          }
        }
        label193:
        for (int i = 1;; i = 2)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(j, i, ((SnsInfo)localObject).field_snsId, 24, 0);
          com.tencent.mm.plugin.sns.data.m.a(localSnsAdClick, c.this.KPn, (SnsInfo)localObject, 24);
          com.tencent.mm.plugin.sns.data.t.a(localSnsAdClick);
          c.this.gw(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100261);
          return;
        }
      }
    };
    this.LoQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100262);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        Object localObject2 = (String)paramAnonymousView.getTag();
        Log.d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(localObject2)));
        Object localObject3 = new Intent();
        int j;
        int i;
        if (((paramAnonymousView instanceof MaskImageButton)) && (((MaskImageButton)paramAnonymousView).kQV != null))
        {
          localObject1 = (String)((MaskImageButton)paramAnonymousView).kQV;
          localObject1 = aj.fOI().bbl((String)localObject1);
          if ((localObject1 != null) && (((SnsInfo)localObject1).isAd()))
          {
            Object localObject5 = ((SnsInfo)localObject1).getAdXml();
            j = c.this.source;
            if (c.this.source == 0)
            {
              i = 1;
              localObject4 = new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 1, 0);
              com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject4, c.this.KPn, (SnsInfo)localObject1, 1);
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
                paramAnonymousView = com.tencent.mm.plugin.sns.data.t.kw((String)localObject2, ((ADInfo)localObject3).uxInfo);
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
              com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject2, c.this.activity);
              com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject4);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100262);
              return;
              i = 2;
              break;
            }
            label412:
            if (com.tencent.mm.plugin.sns.ad.d.l.a(c.this.activity, (ADXml)localObject5, c.a(c.this, (SnsInfo)localObject1), ((SnsInfo)localObject1).field_snsId, 1))
            {
              com.tencent.mm.plugin.sns.ad.i.k.a((SnsAdClick)localObject4, 41);
              com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject4);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100262);
              return;
            }
            localObject5 = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
            ((com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject5).put("ext_sns_ad_click", localObject4);
            Object localObject4 = com.tencent.mm.plugin.sns.ad.timeline.a.a.e(1, c.this.activity);
            if ((localObject4 != null) && (((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject4).a(paramAnonymousView, c.this.source, (SnsInfo)localObject1, (com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject5)))
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
            if (c.this.source != 0) {
              break label823;
            }
            if (paramAnonymousView.isAd())
            {
              j = 722;
              localObject1 = com.tencent.mm.modelsns.l.wO(j);
              ((com.tencent.mm.modelsns.l)localObject1).Xf(com.tencent.mm.plugin.sns.data.t.w(paramAnonymousView)).wR(paramAnonymousView.field_type).gx(paramAnonymousView.isAd()).Xf(paramAnonymousView.getUxinfo()).Xf((String)localObject2);
              ((com.tencent.mm.modelsns.l)localObject1).bpa();
            }
          }
          else
          {
            if (i == 0) {
              break label860;
            }
            j = c.this.source;
            if (c.this.source != 0) {
              break label850;
            }
            i = 1;
            label680:
            localObject1 = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 1, 40);
            com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject1, c.this.KPn, paramAnonymousView, 1);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            ((Intent)localObject3).putExtra("KSnsAdTag", (Parcelable)localObject1);
            ((Intent)localObject3).putExtra("Contact_Scene", 78);
            if (c.this.source != 0) {
              break label855;
            }
          }
          label823:
          label850:
          label855:
          for (i = 6;; i = 1)
          {
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            com.tencent.mm.plugin.sns.c.a.mIG.c((Intent)localObject3, c.this.activity);
            Log.i("MicroMsg.TimelineClickListener", "startContactInfo, addScene=78");
            com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject1);
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
          c.this.KCs.fOn().e(paramAnonymousView, true);
          if (c.this.source == 0)
          {
            paramAnonymousView = com.tencent.mm.modelsns.l.wO(746);
            localObject1 = z.bcZ();
            paramAnonymousView.Xf((String)localObject2).gx(((String)localObject2).endsWith((String)localObject1));
            paramAnonymousView.b((Intent)localObject3, "intent_key_StatisticsOplog");
            if (c.this.source != 0) {
              break label1023;
            }
          }
          label1023:
          for (i = 6;; i = 1)
          {
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            com.tencent.mm.plugin.sns.c.a.mIG.c((Intent)localObject3, c.this.activity);
            ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).report22210((String)localObject2, 6L);
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
    this.LoR = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100202);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        final String str = (String)paramAnonymousView.getTag();
        Log.d("MicroMsg.TimelineClickListener", "onCommentLongClick:".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(100202);
          return true;
        }
        if (str.equals(aj.fOo()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(100202);
          return true;
        }
        final SnsInfo localSnsInfo;
        if ((((MaskImageButton)paramAnonymousView).kQV != null) && ((((MaskImageButton)paramAnonymousView).kQV instanceof String)))
        {
          localObject = (String)((MaskImageButton)paramAnonymousView).kQV;
          new Intent();
          localSnsInfo = aj.fOI().bbl((String)localObject);
          if ((localSnsInfo == null) || (!localSnsInfo.isAd())) {
            break label318;
          }
        }
        label318:
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(100202);
            return false;
            localObject = "";
            break;
          }
          int[] arrayOfInt = new int[2];
          if ((paramAnonymousView.getTag(i.f.touch_loc) instanceof int[])) {
            arrayOfInt = (int[])paramAnonymousView.getTag(i.f.touch_loc);
          }
          for (;;)
          {
            new com.tencent.mm.ui.widget.b.a(c.this.activity).a(paramAnonymousView, new View.OnCreateContextMenuListener()new q.g
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(100200);
                com.tencent.mm.kernel.h.aHH();
                paramAnonymous2View = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwh(localSnsInfo.getUserName());
                int i;
                if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("MMSocialBlackListFlag", 1) == 1)
                {
                  i = 1;
                  if ((paramAnonymous2View == null) || (localSnsInfo == null) || (!com.tencent.mm.storage.as.bvK(localSnsInfo.getUserName())) || (!"3552365301".equals(paramAnonymous2View.field_openImAppid))) {
                    break label188;
                  }
                  if (i == 0) {
                    break label168;
                  }
                }
                label168:
                for (paramAnonymous2View = c.this.activity.getString(i.j.contact_info_op_permission);; paramAnonymous2View = c.this.activity.getString(i.j.contact_info_op_sns_permission_openim))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View);
                  paramAnonymous2ContextMenu.add(1, 1, 0, c.this.activity.getString(i.j.sns_timeline_expose));
                  AppMethodBeat.o(100200);
                  return;
                  i = 0;
                  break;
                }
                label188:
                if (i != 0) {}
                for (paramAnonymous2View = c.this.activity.getString(i.j.contact_info_op_permission);; paramAnonymous2View = c.this.activity.getString(i.j.contact_info_op_sns_permission))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View);
                  break;
                }
              }
            }, new q.g()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                long l = 0L;
                AppMethodBeat.i(100201);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                default: 
                  AppMethodBeat.o(100201);
                  return;
                case 0: 
                  localObject1 = new Intent();
                  if (localSnsInfo == null)
                  {
                    ((Intent)localObject1).putExtra("sns_permission_snsinfo_svr_id", l);
                    ((Intent)localObject1).putExtra("sns_permission_userName", str);
                    ((Intent)localObject1).putExtra("sns_permission_anim", true);
                    ((Intent)localObject1).putExtra("sns_permission_block_scene", 5);
                    paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vWD, 0);
                    localObject2 = c.this.activity;
                    if (paramAnonymous2Int != 0) {
                      break label163;
                    }
                  }
                  label163:
                  for (paramAnonymous2MenuItem = ".ui.PermissionSettingUI";; paramAnonymous2MenuItem = ".ui.PermissionSettingUI2")
                  {
                    com.tencent.mm.by.c.b((Context)localObject2, "profile", paramAnonymous2MenuItem, (Intent)localObject1, 11);
                    AppMethodBeat.o(100201);
                    return;
                    l = localSnsInfo.field_snsId;
                    break;
                  }
                }
                Object localObject2 = new Intent();
                Object localObject1 = aj.fOI().bbl(this.LpJ);
                if (localObject1 == null)
                {
                  Log.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + this.LpJ);
                  AppMethodBeat.o(100201);
                  return;
                }
                Log.i("MicroMsg.TimelineClickListener", "expose id " + ((SnsInfo)localObject1).getSnsId() + " " + ((SnsInfo)localObject1).field_userName);
                if (localObject1 == null)
                {
                  label268:
                  ((Intent)localObject2).putExtra("k_expose_msg_id", l);
                  if (localObject1 != null) {
                    break label438;
                  }
                }
                label438:
                for (paramAnonymous2MenuItem = "";; paramAnonymous2MenuItem = ((SnsInfo)localObject1).field_userName)
                {
                  ((Intent)localObject2).putExtra("k_username", paramAnonymous2MenuItem);
                  ((Intent)localObject2).putExtra("showShare", false);
                  ((Intent)localObject2).putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(33) }));
                  com.tencent.mm.by.c.b(c.this.activity, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
                  com.tencent.mm.kernel.h.aHH();
                  paramAnonymous2MenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwh(localSnsInfo.getUserName());
                  if ((paramAnonymous2MenuItem == null) || (localSnsInfo == null) || (!com.tencent.mm.storage.as.bvK(localSnsInfo.getUserName())) || (!"3552365301".equals(paramAnonymous2MenuItem.field_openImAppid))) {
                    break;
                  }
                  paramAnonymous2MenuItem = com.tencent.mm.plugin.sns.k.g.Kia;
                  com.tencent.mm.plugin.sns.k.g.baP(((SnsInfo)localObject1).getUserName());
                  break;
                  l = ((SnsInfo)localObject1).field_snsId;
                  break label268;
                }
              }
            }, arrayOfInt[0], arrayOfInt[1]);
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(100202);
            return false;
          }
        }
      }
    };
    this.LoS = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100203);
        paramAnonymousContextMenuInfo = (bi)paramAnonymousView.getTag();
        paramAnonymousView = aj.fOI().bbk(paramAnonymousContextMenuInfo.fLp);
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(100203);
          return;
        }
        paramAnonymousContextMenu.add(0, 0, 0, c.this.activity.getString(i.j.app_copy));
        if (com.tencent.mm.by.c.blP("favorite")) {
          paramAnonymousContextMenu.add(0, 1, 0, c.this.activity.getString(i.j.plugin_favorite_opt));
        }
        TimeLineObject localTimeLineObject = paramAnonymousView.getTimeLine();
        int i;
        if ((paramAnonymousContextMenuInfo.KVI) || ((localTimeLineObject != null) && (localTimeLineObject.contentDescShowType != 1) && (!paramAnonymousContextMenuInfo.KVJ)))
        {
          if (!paramAnonymousContextMenuInfo.fWO()) {
            at.a(paramAnonymousContextMenu, true);
          }
        }
        else
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousView);
          if (((c.this.activity instanceof SnsTimeLineUI)) || ((c.this.activity instanceof SnsCommentDetailUI)) || ((c.this.activity instanceof SnsWsFoldDetailUI)))
          {
            paramAnonymousContextMenu.add(0, 27, 0, c.this.activity.getString(i.j.find_friends_search));
            paramAnonymousContextMenu = Util.nullAs(paramAnonymousView.getTimeLine().ContentDesc, "");
            i = 0;
            if (!(c.this.activity instanceof SnsCommentDetailUI)) {
              break label287;
            }
            i = 5;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.websearch.api.ar.a(1, com.tencent.mm.plugin.fts.a.d.Sx(77), 77, 0, "", "", com.tencent.mm.plugin.sns.data.t.Qu(paramAnonymousView.field_snsId), 3, "", 0L, paramAnonymousContextMenu.length(), i, "", "", -1);
          AppMethodBeat.o(100203);
          return;
          at.b(paramAnonymousContextMenu, true);
          break;
          label287:
          if ((c.this.activity instanceof SnsWsFoldDetailUI)) {
            i = 6;
          } else if ((c.this.activity instanceof SnsTimeLineUI)) {
            i = 5;
          }
        }
      }
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(100204);
        if ((paramAnonymousView.getTag() instanceof bi))
        {
          Object localObject = (bi)paramAnonymousView.getTag();
          localObject = aj.fOI().bbk(((bi)localObject).fLp);
          if (localObject == null)
          {
            AppMethodBeat.o(100204);
            return false;
          }
          String str = ((SnsInfo)localObject).getLocalid();
          c.this.LoP.a(paramAnonymousView, str, ((SnsInfo)localObject).getTimeLine());
          AppMethodBeat.o(100204);
          return true;
        }
        AppMethodBeat.o(100204);
        return false;
      }
    };
    this.Lph = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100206);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof SnsInfo)) || ((paramAnonymousContextMenuInfo instanceof av)) || ((paramAnonymousContextMenuInfo instanceof be)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.c.a.b))) {
          if ((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.f.bbk(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).fLp);
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
            if ((paramAnonymousContextMenuInfo instanceof av))
            {
              paramAnonymousContextMenuInfo = (av)paramAnonymousContextMenuInfo;
              paramAnonymousContextMenuInfo = aj.fOI().bbl(paramAnonymousContextMenuInfo.fAg);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof be))
            {
              paramAnonymousContextMenuInfo = ((be)paramAnonymousView.getTag()).fCM;
              paramAnonymousContextMenuInfo = aj.fOI().bbl(paramAnonymousContextMenuInfo);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).Jzk;
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
            if (com.tencent.mm.plugin.sns.ad.d.l.a(paramAnonymousContextMenuInfo.getAdXml(), paramAnonymousContextMenuInfo.getAdInfo()))
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (com.tencent.mm.by.c.blP("favorite"))
            {
              if (paramAnonymousContextMenuInfo.getAdXml().isCardAd()) {
                paramAnonymousContextMenu.add(0, 20, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
              }
              em localem = new em();
              localem.fAp.fAg = paramAnonymousContextMenuInfo.getLocalid();
              EventCenter.instance.publish(localem);
              if (localem.fAq.fzO) {
                paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(i.j.app_open));
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
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(100205);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof SnsInfo)) || ((paramAnonymousView.getTag() instanceof av)) || ((paramAnonymousView.getTag() instanceof be)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.f.bbk(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).fLp);
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
              if ((localObject instanceof av))
              {
                localObject = (av)localObject;
                localObject = aj.fOI().bbl(((av)localObject).fAg);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof be))
              {
                localObject = ((be)paramAnonymousView.getTag()).fCM;
                localObject = aj.fOI().bbl((String)localObject);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
                localObject = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).Jzk;
              }
            }
            else
            {
              if ((((SnsInfo)localObject).getAdXml() == null) || (!((SnsInfo)localObject).getAdXml().isCardAd()) || (((SnsInfo)localObject).getAdXml().adLiveInfo != null))
              {
                AppMethodBeat.o(100205);
                return false;
              }
              c.this.LoP.a(paramAnonymousView, ((SnsInfo)localObject).getLocalid(), ((SnsInfo)localObject).getTimeLine());
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
    this.Lpi = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100208);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof SnsInfo)))
        {
          if (!(paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            break label179;
          }
          paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.f.bbk(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).fLp);
        }
        for (;;)
        {
          Object localObject;
          ADInfo localADInfo;
          if (com.tencent.mm.by.c.blP("favorite"))
          {
            localObject = paramAnonymousContextMenuInfo.getAdXml();
            localADInfo = c.a(c.this, paramAnonymousContextMenuInfo);
            if (((ADXml)localObject).isLinkAd())
            {
              if (!((ADXml)localObject).isLandingPagesAd()) {
                break label194;
              }
              paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
            }
          }
          for (;;)
          {
            localObject = new em();
            ((em)localObject).fAp.fAg = paramAnonymousContextMenuInfo.getLocalid();
            EventCenter.instance.publish((IEvent)localObject);
            if (((em)localObject).fAq.fzO) {
              paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(i.j.app_open));
            }
            if (paramAnonymousContextMenuInfo != null) {
              com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            }
            AppMethodBeat.o(100208);
            return;
            label179:
            if (!(paramAnonymousContextMenuInfo instanceof SnsInfo)) {
              break label225;
            }
            paramAnonymousContextMenuInfo = (SnsInfo)paramAnonymousContextMenuInfo;
            break;
            label194:
            if (localADInfo.adActionType == 0) {
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
            }
          }
          label225:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(100207);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof SnsInfo)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.f.bbk(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).fLp);
          }
        }
        for (;;)
        {
          if (localObject != null) {
            c.this.LoP.a(paramAnonymousView, ((SnsInfo)localObject).getLocalid(), ((SnsInfo)localObject).getTimeLine());
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
    this.Lpe = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100209);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.s)) {
          c.this.Lpj.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
        }
        AppMethodBeat.o(100209);
      }
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(100210);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.s)paramAnonymousView.getTag()).fAg;
          SnsInfo localSnsInfo = aj.fOI().bbl(str);
          c.this.LoP.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(100210);
          return true;
        }
        AppMethodBeat.o(100210);
        return false;
      }
    };
    this.Lpk = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100211);
        if (com.tencent.mm.by.c.blP("favorite")) {
          paramAnonymousContextMenu.add(0, 24, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
        }
        AppMethodBeat.o(100211);
      }
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(100212);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.ak))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.ak)paramAnonymousView.getTag()).fAg;
          SnsInfo localSnsInfo = aj.fOI().bbl(str);
          c.this.LoP.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(100212);
          return true;
        }
        AppMethodBeat.o(100212);
        return false;
      }
    };
    this.Lpd = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100214);
        be localbe;
        Object localObject1;
        Object localObject2;
        int j;
        int i;
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof be)))
        {
          localbe = (be)paramAnonymousView.getTag();
          localObject1 = localbe.fCM;
          paramAnonymousContextMenuInfo = aj.fOI().bbl((String)localObject1);
          if (com.tencent.mm.by.c.blP("favorite"))
          {
            paramAnonymousContextMenu.add(0, 2, 0, c.this.activity.getString(i.j.plugin_favorite_opt));
            localObject2 = new em();
            ((em)localObject2).fAp.fAg = ((String)localObject1);
            EventCenter.instance.publish((IEvent)localObject2);
            if (((em)localObject2).fAq.fzO) {
              paramAnonymousContextMenu.add(0, 18, 0, c.this.activity.getString(i.j.app_open));
            }
          }
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
          localObject1 = paramAnonymousContextMenu.add(0, 21, 0, c.this.activity.getString(i.j.sns_edit_image));
          localObject2 = new int[2];
          if (paramAnonymousView == null) {
            break label489;
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
          if (((c.this.activity instanceof SnsTimeLineUI)) || ((c.this.activity instanceof SnsCommentDetailUI)))
          {
            paramAnonymousContextMenu.add(0, 26, 0, c.this.activity.getString(i.j.find_friends_search));
            if (!(c.this.activity instanceof SnsTimeLineUI)) {
              break label471;
            }
            i = 10;
            paramAnonymousContextMenu = paramAnonymousContextMenuInfo.getTimeLine();
            if (localbe.index >= paramAnonymousContextMenu.ContentObj.Sqr.size()) {
              break label478;
            }
          }
          label471:
          label478:
          for (paramAnonymousContextMenu = (cvt)paramAnonymousContextMenu.ContentObj.Sqr.get(localbe.index);; paramAnonymousContextMenu = new cvt())
          {
            paramAnonymousView = new ah();
            paramAnonymousContextMenuInfo = paramAnonymousView.iX("").iY(com.tencent.mm.plugin.sns.data.t.Qu(paramAnonymousContextMenuInfo.field_snsId));
            paramAnonymousContextMenuInfo.giu = i;
            paramAnonymousContextMenuInfo.geN = 1;
            paramAnonymousContextMenuInfo.ggl = 81;
            paramAnonymousView.iZ("");
            paramAnonymousView.ja("");
            paramAnonymousView.jb(com.tencent.mm.b.g.getMD5(com.tencent.mm.plugin.sns.model.aq.kD(aj.getAccSnsPath(), paramAnonymousContextMenu.Id) + com.tencent.mm.plugin.sns.data.t.k(paramAnonymousContextMenu)));
            paramAnonymousView.giA = System.currentTimeMillis();
            paramAnonymousView.bpa();
            com.tencent.mm.plugin.websearch.api.ar.a(paramAnonymousView);
            AppMethodBeat.o(100214);
            return;
            i = 7;
            break;
          }
          label489:
          i = 0;
          j = 0;
        }
      }
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(100213);
        if ((paramAnonymousView.getTag() instanceof be))
        {
          String str = ((be)paramAnonymousView.getTag()).fCM;
          SnsInfo localSnsInfo = aj.fOI().bbl(str);
          c.this.LoP.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(100213);
          return true;
        }
        AppMethodBeat.o(100213);
        return false;
      }
    };
    this.Lpg = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(198229);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if ((paramAnonymousContextMenuInfo instanceof be)) {
          paramAnonymousContextMenuInfo = ((be)paramAnonymousContextMenuInfo).fCM;
        }
        for (;;)
        {
          if (paramAnonymousContextMenuInfo != null)
          {
            paramAnonymousContextMenuInfo = aj.fOI().bbl(paramAnonymousContextMenuInfo);
            TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.getTimeLine();
            if (com.tencent.mm.by.c.blP("favorite")) {
              switch (localTimeLineObject.ContentObj.Sqq)
              {
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            AppMethodBeat.o(198229);
            return;
            if (!(paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.s)) {
              break label160;
            }
            paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.s)paramAnonymousContextMenuInfo).fAg;
            break;
            paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
            continue;
            paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
          }
          label160:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(198223);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof be)) {
          localObject = ((be)localObject).fCM;
        }
        for (;;)
        {
          if (localObject != null)
          {
            SnsInfo localSnsInfo = aj.fOI().bbl((String)localObject);
            c.this.LoP.a(paramAnonymousView, (String)localObject, localSnsInfo.getTimeLine());
            AppMethodBeat.o(198223);
            return true;
            if ((localObject instanceof com.tencent.mm.plugin.sns.ui.s)) {
              localObject = ((com.tencent.mm.plugin.sns.ui.s)localObject).fAg;
            }
          }
          else
          {
            AppMethodBeat.o(198223);
            return false;
          }
          localObject = null;
        }
      }
    };
    this.KEA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100216);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        localObject1 = null;
        if ((paramAnonymousView.getTag() instanceof be)) {
          localObject1 = ((be)paramAnonymousView.getTag()).fCM;
        }
        Object localObject2;
        for (;;)
        {
          localObject2 = com.tencent.mm.plugin.sns.storage.f.bbl((String)localObject1);
          if (localObject2 != null) {
            break;
          }
          Log.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(localObject1)));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
          if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).fAg;
          } else if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
            localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).Jzk.getLocalid();
          }
        }
        if ((((SnsInfo)localObject2).isAd()) && (((SnsInfo)localObject2).getAdXml() != null) && ((((SnsInfo)localObject2).getAdXml().isCardAd()) || (((SnsInfo)localObject2).getAdXml().isFullCardAd())))
        {
          c.this.LpB.onClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
        }
        if (((SnsInfo)localObject2).getTimeLine().ContentObj.Sqq == 21)
        {
          if (z.bcZ().equals(((SnsInfo)localObject2).getUserName()))
          {
            ((SnsInfo)localObject2).getTimeLine();
            com.tencent.mm.plugin.sns.lucky.a.m.z((SnsInfo)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.m.y((SnsInfo)localObject2);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.rE(25);
          }
          if (!z.bcZ().equals(((SnsInfo)localObject2).getUserName()))
          {
            com.tencent.mm.plugin.sns.lucky.b.a.c(2, (SnsInfo)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.b.rE(30);
          }
        }
        int j;
        int i;
        Object localObject3;
        if (((SnsInfo)localObject2).isAd())
        {
          localObject1 = ((SnsInfo)localObject2).getAdXml();
          if (localObject1 != null) {
            com.tencent.mm.plugin.sns.ad.d.a.O(c.this.activity, ((ADXml)localObject1).appGiftPackCode, ((ADXml)localObject1).appGiftPackCodeTips);
          }
          localObject1 = c.a(c.this, (SnsInfo)localObject2);
          if ((((SnsInfo)localObject2).getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(((SnsInfo)localObject2).getAdSnsInfo().field_adxml)))
          {
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.R((SnsInfo)localObject2);
            if (!Util.isNullOrNil((String)localObject1)) {
              ((SnsInfo)localObject2).getAdSnsInfo().field_adxml = ((String)localObject1);
            }
            j = c.this.source;
            if (c.this.source == 0)
            {
              i = 1;
              localObject1 = new SnsAdClick(j, i, ((SnsInfo)localObject2).field_snsId, 21, 21);
              com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject1, c.this.KPn, (SnsInfo)localObject2, 21);
              com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject1);
              localObject3 = new int[2];
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
                localObject3 = ((TimeLineObject)localObject3).ContentObj.Sqr;
                if (((List)localObject3).size() > 0)
                {
                  ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((cvt)((List)localObject3).get(0)).TDF);
                  ((Intent)localObject1).putExtra("sns_landing_pages_from_outer_index", ((be)paramAnonymousView.getTag()).index);
                }
              }
              ((Intent)localObject1).setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
              if (c.this.source != 2) {
                break label1102;
              }
              i = 16;
            }
          }
        }
        for (;;)
        {
          label730:
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
          localObject3 = c.this.activity;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
          com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!((SnsInfo)localObject2).getAdXml().forbiddenCustomAnimation) {
            c.this.activity.overridePendingTransition(0, 0);
          }
          if (c.this.KCs != null) {
            c.this.KCs.fOn().N((SnsInfo)localObject2);
          }
          label958:
          paramAnonymousView = (be)paramAnonymousView.getTag();
          if ((paramAnonymousView.KOn) && (localObject2 != null))
          {
            com.tencent.mm.plugin.sns.ui.a.c.h((SnsInfo)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.ui.a.c.i((SnsInfo)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.model.bc.baq(((SnsInfo)localObject2).getLocalid());
          }
          if (localObject2 != null)
          {
            localObject1 = ((SnsInfo)localObject2).getTimeLine();
            if (localObject1 != null) {
              if (((TimeLineObject)localObject1).AppInfo != null) {
                break label1338;
              }
            }
          }
          label1338:
          for (paramAnonymousView = null;; paramAnonymousView = ((TimeLineObject)localObject1).AppInfo.Id)
          {
            if (!Util.isNullOrNil(paramAnonymousView))
            {
              localObject2 = com.tencent.mm.plugin.sns.c.a.mIH.gY(paramAnonymousView);
              com.tencent.mm.plugin.sns.c.a.mIH.a(null, paramAnonymousView, (String)localObject2, ((TimeLineObject)localObject1).UserName, 2, 4, 4, ((TimeLineObject)localObject1).statisticsData, ((TimeLineObject)localObject1).Id);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100216);
            return;
            i = 2;
            break;
            label1102:
            if (c.this.source != 1) {
              break label1350;
            }
            i = 2;
            break label730;
            if (c.a(c.this, (ADInfo)localObject1, (SnsInfo)localObject2, false))
            {
              j = c.this.source;
              if (c.this.source == 0) {}
              for (i = 1;; i = 2)
              {
                localObject1 = new SnsAdClick(j, i, ((SnsInfo)localObject2).field_snsId, 21, 31);
                com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject1, c.this.KPn, (SnsInfo)localObject2, 21);
                com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject1);
                break;
              }
            }
            if (bm.Z((SnsInfo)localObject2) == 2)
            {
              if (com.tencent.mm.plugin.sns.ad.d.l.a(c.this.activity, ((SnsInfo)localObject2).getAdXml(), (ADInfo)localObject1, ((SnsInfo)localObject2).field_snsId))
              {
                j = c.this.source;
                if (c.this.source == 0) {}
                for (i = 1;; i = 2)
                {
                  localObject1 = new SnsAdClick(j, i, ((SnsInfo)localObject2).field_snsId, 21, 37);
                  com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject1, c.this.KPn, (SnsInfo)localObject2, 21);
                  com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject1);
                  break;
                }
              }
              c.this.dV(paramAnonymousView);
              break label958;
            }
            c.this.dV(paramAnonymousView);
            break label958;
            c.this.dV(paramAnonymousView);
            break label958;
          }
          label1350:
          i = 1;
        }
      }
    };
    this.LoT = new c.11(this);
    this.LoU = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(100220);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        new f.a(c.this.activity).bBl(c.this.activity.getResources().getString(i.j.sns_timeline_ui_confirm_del)).bBp(c.this.activity.getResources().getString(i.j.app_delete)).ayq(c.this.activity.getResources().getColor(i.c.red_text_color)).b(new f.c()
        {
          public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(196660);
            if (!(paramAnonymousView.getTag() instanceof String))
            {
              AppMethodBeat.o(196660);
              return;
            }
            paramAnonymous2String = (String)paramAnonymousView.getTag();
            Log.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymous2String)));
            SnsInfo localSnsInfo = aj.fOI().bbl(paramAnonymous2String);
            if (localSnsInfo == null)
            {
              Log.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(196660);
              return;
            }
            Object localObject2;
            if (localSnsInfo.isDieItem())
            {
              Log.i("MicroMsg.TimelineClickListener", "dead item");
              aj.fOI().agJ(localSnsInfo.localid);
              if (c.this.LpC != null) {
                c.this.LpC.fXk();
              }
              if (c.this.source == 0)
              {
                localObject1 = com.tencent.mm.modelsns.l.wO(739);
                localObject2 = ((com.tencent.mm.modelsns.l)localObject1).Xf(com.tencent.mm.plugin.sns.data.t.w(localSnsInfo)).wR(localSnsInfo.field_type);
                if (!localSnsInfo.isDieItem()) {
                  break label238;
                }
                paramAnonymous2String = "2";
              }
              for (;;)
              {
                ((com.tencent.mm.modelsns.l)localObject2).Xf(paramAnonymous2String);
                ((com.tencent.mm.modelsns.l)localObject1).bpa();
                if (localSnsInfo.getTypeFlag() == 21) {
                  com.tencent.mm.plugin.sns.lucky.a.g.fNB().fND();
                }
                AppMethodBeat.o(196660);
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
              Log.i("MicroMsg.TimelineClickListener", "cancel item " + localSnsInfo.getLocalid());
              aj.fOE().K(localSnsInfo);
              paramAnonymous2String = localSnsInfo.getTimeLine();
              j = 0;
              i = j;
              if (paramAnonymous2String != null)
              {
                i = j;
                if (paramAnonymous2String.ContentObj != null)
                {
                  i = j;
                  if (paramAnonymous2String.ContentObj.fFJ != null)
                  {
                    i = j;
                    if (paramAnonymous2String.ContentObj.fFJ.localId != 0L) {
                      i = 1;
                    }
                  }
                }
              }
              if ((Util.secondsToNow(localSnsInfo.getCreateTime()) < com.tencent.mm.plugin.sns.model.as.JZW) && (i == 0)) {
                aj.fOU().E(localSnsInfo);
              }
              c.this.fTs();
              AppMethodBeat.o(196660);
              return;
            }
            Log.i("MicroMsg.TimelineClickListener", "delete by server");
            paramAnonymous2String = localSnsInfo.getSnsId();
            aj.fOH().QK(com.tencent.mm.plugin.sns.storage.y.aYS(paramAnonymous2String));
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.sns.model.s(com.tencent.mm.plugin.sns.storage.y.aYS(paramAnonymous2String), 1), 0);
            Object localObject1 = localSnsInfo.getTimeLine();
            int j = 0;
            int i = j;
            if (localObject1 != null)
            {
              i = j;
              if (((TimeLineObject)localObject1).ContentObj != null)
              {
                i = j;
                if (((TimeLineObject)localObject1).ContentObj.fFJ != null)
                {
                  i = j;
                  if (((TimeLineObject)localObject1).ContentObj.fFJ.localId != 0L) {
                    i = 1;
                  }
                }
              }
            }
            if ((Util.secondsToNow(localSnsInfo.getCreateTime()) < com.tencent.mm.plugin.sns.model.as.JZW) && (i == 0)) {
              aj.fOU().E(localSnsInfo);
            }
            aj.fOI().delete(com.tencent.mm.plugin.sns.storage.y.aYS(paramAnonymous2String));
            aj.fON().Rb(com.tencent.mm.plugin.sns.storage.y.aYS(paramAnonymous2String));
            com.tencent.mm.plugin.sns.storage.g.Ra(com.tencent.mm.plugin.sns.storage.y.aYS(paramAnonymous2String));
            c.this.fTs();
            if (localObject1 != null)
            {
              if (((TimeLineObject)localObject1).AppInfo != null) {
                break label766;
              }
              paramAnonymous2String = null;
              if ((!Util.isNullOrNil(paramAnonymous2String)) && (com.tencent.mm.plugin.sns.c.a.mIH.ha(paramAnonymous2String)))
              {
                localObject2 = com.tencent.mm.plugin.sns.c.a.mIH.gY(paramAnonymous2String);
                sw localsw = new sw();
                localsw.fSi.appId = paramAnonymous2String;
                localsw.fSi.fSj = ((TimeLineObject)localObject1).UserName;
                localsw.fSi.pkgName = ((String)localObject2);
                localsw.fSi.mediaTagName = ((TimeLineObject)localObject1).statisticsData;
                EventCenter.instance.publish(localsw);
              }
            }
            if (c.this.source == 0)
            {
              localObject1 = com.tencent.mm.modelsns.l.wO(739);
              label716:
              localObject2 = ((com.tencent.mm.modelsns.l)localObject1).Xf(com.tencent.mm.plugin.sns.data.t.w(localSnsInfo)).wR(localSnsInfo.field_type);
              if (!localSnsInfo.isDieItem()) {
                break label789;
              }
              paramAnonymous2String = "2";
            }
            for (;;)
            {
              ((com.tencent.mm.modelsns.l)localObject2).Xf(paramAnonymous2String);
              ((com.tencent.mm.modelsns.l)localObject1).bpa();
              AppMethodBeat.o(196660);
              return;
              label766:
              paramAnonymous2String = ((TimeLineObject)localObject1).AppInfo.Id;
              break;
              localObject1 = com.tencent.mm.modelsns.l.wP(739);
              break label716;
              label789:
              if (localSnsInfo.field_snsId == 0L) {
                paramAnonymous2String = "1";
              } else {
                paramAnonymous2String = "0";
              }
            }
          }
        }).bBq(c.this.activity.getResources().getString(i.j.app_cancel)).a(new f.c()
        {
          public final void g(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100220);
      }
    };
    this.LoV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100221);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        paramAnonymousView = (String)paramAnonymousView.getTag();
        Log.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymousView)));
        paramAnonymousView = aj.fOI().bbl(paramAnonymousView).getTimeLine();
        localObject1 = paramAnonymousView.actionInfo;
        if (((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
        }
        String str = com.tencent.mm.plugin.sns.c.a.mIH.gY(((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.lVG);
        int i = 0;
        if (paramAnonymousView.ContentObj.Sqq == 1) {
          i = 2;
        }
        while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(paramAnonymousView, c.this.activity))
        {
          com.tencent.mm.plugin.sns.c.a.mIH.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.lVG, str, paramAnonymousView.UserName, i, 11, 9, ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.RFI, paramAnonymousView.Id);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
          if (paramAnonymousView.ContentObj.Sqq == 3) {
            i = 5;
          } else if (paramAnonymousView.ContentObj.Sqq == 15) {
            i = 38;
          }
        }
        switch (((com.tencent.mm.protocal.protobuf.bc)localObject1).rWu)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("rawUrl", ((com.tencent.mm.protocal.protobuf.bc)localObject1).Url);
          com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject2, c.this.activity);
          com.tencent.mm.plugin.sns.c.a.mIH.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.lVG, str, paramAnonymousView.UserName, i, 11, 1, ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.RFI, paramAnonymousView.Id);
          continue;
          if (((com.tencent.mm.protocal.protobuf.bc)localObject1).CPw == 1)
          {
            localObject2 = new ji();
            ((ji)localObject2).fGD.actionCode = 2;
            ((ji)localObject2).fGD.scene = 3;
            ((ji)localObject2).fGD.appId = ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.lVG;
            ((ji)localObject2).fGD.context = c.this.activity;
            EventCenter.instance.publish((IEvent)localObject2);
            com.tencent.mm.plugin.sns.c.a.mIH.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.lVG, str, paramAnonymousView.UserName, i, 11, 6, ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.RFI, paramAnonymousView.Id);
            continue;
            int j = com.tencent.mm.plugin.sns.ui.aq.b(c.this.activity, (com.tencent.mm.protocal.protobuf.bc)localObject1);
            if (j == 1)
            {
              localObject2 = new ji();
              ((ji)localObject2).fGD.context = c.this.activity;
              ((ji)localObject2).fGD.actionCode = 2;
              ((ji)localObject2).fGD.appId = ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.lVG;
              ((ji)localObject2).fGD.messageAction = ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.RFK;
              ((ji)localObject2).fGD.messageExt = ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.RFJ;
              ((ji)localObject2).fGD.scene = 3;
              EventCenter.instance.publish((IEvent)localObject2);
              com.tencent.mm.plugin.sns.c.a.mIH.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.lVG, str, paramAnonymousView.UserName, i, 11, 6, ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.RFI, paramAnonymousView.Id);
            }
            else if (j == 2)
            {
              localObject2 = new ji();
              ((ji)localObject2).fGD.context = c.this.activity;
              ((ji)localObject2).fGD.actionCode = 1;
              ((ji)localObject2).fGD.appId = ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.lVG;
              ((ji)localObject2).fGD.messageAction = ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.RFK;
              ((ji)localObject2).fGD.messageExt = ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.RFJ;
              ((ji)localObject2).fGD.scene = 3;
              EventCenter.instance.publish((IEvent)localObject2);
              com.tencent.mm.plugin.sns.c.a.mIH.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.lVG, str, paramAnonymousView.UserName, i, 11, 3, ((com.tencent.mm.protocal.protobuf.bc)localObject1).RFO.RFI, paramAnonymousView.Id);
            }
          }
        }
      }
    };
    this.Lpb = new View.OnClickListener()
    {
      private static void bcx(String paramAnonymousString)
      {
        AppMethodBeat.i(268983);
        long l = aj.fOI().bbl(paramAnonymousString).field_snsId;
        Object localObject1 = aj.fOI().Rd(l);
        if (localObject1 != null)
        {
          Object localObject2 = ((SnsInfo)localObject1).getTimeLine();
          if (localObject2 != null)
          {
            localObject2 = ((TimeLineObject)localObject2).ContentObj.Sqr;
            if (((List)localObject2).size() > 0) {
              ((List)localObject2).get(0);
            }
          }
          localObject2 = an.D((SnsInfo)localObject1);
          localObject1 = new ArrayList();
          localObject2 = ((SnsObject)localObject2).SnsRedEnvelops.Umz;
          if (localObject2 != null)
          {
            int i = 0;
            while (i < ((List)localObject2).size())
            {
              ejx localejx = (ejx)((List)localObject2).get(i);
              com.tencent.mm.plugin.r.a.a locala = new com.tencent.mm.plugin.r.a.a();
              locala.pRV = localejx.Username;
              locala.EsP = localejx.CreateTime;
              locala.EsQ = localejx.Ulq;
              ((List)localObject1).add(locala);
              i += 1;
            }
          }
          com.tencent.mm.plugin.r.a.z(paramAnonymousString, (List)localObject1);
        }
        AppMethodBeat.o(268983);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100223);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if ((paramAnonymousView.getTag() instanceof SnsInfo))
        {
          paramAnonymousView = (SnsInfo)paramAnonymousView.getTag();
          if ((paramAnonymousView.getTypeFlag() == 21) && (z.bcZ().equals(paramAnonymousView.getUserName())))
          {
            paramAnonymousView.getTimeLine();
            com.tencent.mm.plugin.sns.lucky.a.m.z(paramAnonymousView);
            com.tencent.mm.plugin.sns.lucky.a.m.y(paramAnonymousView);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.rE(24);
          }
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_sendid", paramAnonymousView.getSnsId());
          ((Intent)localObject2).putExtra("key_feedid", paramAnonymousView.getLocalid());
          ((Intent)localObject2).setClassName(c.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
          localObject1 = c.this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = paramAnonymousView.getLocalid();
          paramAnonymousView.getSnsId();
          bcx((String)localObject1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100223);
      }
    };
    this.LoW = new c.16(this);
    this.LoX = new c.17(this);
    this.LoY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((paramAnonymousView.getTag() instanceof String))
        {
          paramAnonymousView = (String)paramAnonymousView.getTag();
          Log.d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(paramAnonymousView)));
          an.afU(com.tencent.mm.plugin.sns.storage.y.bbI(paramAnonymousView));
          an.afT(com.tencent.mm.plugin.sns.storage.y.bbI(paramAnonymousView));
          aj.fOE().fNd();
          c.this.fTs();
          if (c.this.LpC != null) {
            c.this.LpC.fXk();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100226);
      }
    };
    this.LoZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(270263);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        try
        {
          int i = com.tencent.mm.plugin.sns.storage.y.bbI((String)paramAnonymousView.getTag());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_label_sns_info", i);
          com.tencent.mm.plugin.sns.c.a.mIG.s(paramAnonymousView, c.this.activity);
          label77:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(270263);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          break label77;
        }
      }
    };
    this.Lpc = new d()
    {
      private static boolean c(com.tencent.mm.plugin.sns.ui.m paramAnonymousm)
      {
        AppMethodBeat.i(224240);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousm != null)
        {
          bool1 = bool2;
          if (paramAnonymousm.JVu != null)
          {
            bool1 = bool2;
            if (!Util.isNullOrNil(paramAnonymousm.JVu.Uls)) {
              bool1 = true;
            }
          }
        }
        AppMethodBeat.o(224240);
        return bool1;
      }
      
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(224273);
        int i;
        long l;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          if (((!com.tencent.mm.plugin.sns.ui.widget.e.ki(paramAnonymousView.JVu.Ulr, 16)) || (paramAnonymousView.scene == 2)) && (!c(paramAnonymousView))) {
            paramAnonymousContextMenu.add(0, 11, 0, c.this.activity.getString(i.j.app_copy));
          }
          if ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE)) {
            break label447;
          }
          i = 1;
          if (((i != 0) && (!Util.isNullOrNil(paramAnonymousView.KCG)) && (paramAnonymousView.KCG.equals(z.bcZ()))) || ((paramAnonymousView.UserName != null) && (paramAnonymousView.UserName.equals(z.bcZ())))) {
            paramAnonymousContextMenu.add(0, 7, 0, c.this.activity.getString(i.j.app_delete));
          }
          if ((!com.tencent.mm.plugin.sns.ui.widget.e.ki(paramAnonymousView.JVu.Ulr, 16)) && (!c(paramAnonymousView)))
          {
            paramAnonymousContextMenuInfo = paramAnonymousView.KCE;
            StringBuilder localStringBuilder = new StringBuilder();
            if (paramAnonymousView.JVu.Uln == 0) {
              break label480;
            }
            l = paramAnonymousView.JVu.Uln;
            label226:
            paramAnonymousContextMenuInfo = at.kE(paramAnonymousContextMenuInfo, l);
            i = -1;
            if (paramAnonymousView.scene != 1) {
              break label492;
            }
            i = 2;
            label255:
            paramAnonymousContextMenuInfo = at.bal(paramAnonymousContextMenuInfo);
            if ((paramAnonymousContextMenuInfo == null) || (!paramAnonymousContextMenuInfo.lwF) || (paramAnonymousContextMenuInfo.lAQ) || ((i & paramAnonymousContextMenuInfo.showFlag) == 0)) {
              break label506;
            }
            i = 1;
            label291:
            if (i != 0) {
              break label512;
            }
            at.a(paramAnonymousContextMenu, false);
          }
          label301:
          if (((c.this.activity instanceof SnsTimeLineUI)) || ((c.this.activity instanceof SnsCommentDetailUI)) || ((c.this.activity instanceof SnsWsFoldDetailUI)))
          {
            paramAnonymousContextMenu.add(0, 29, 0, c.this.activity.getString(i.j.find_friends_search));
            paramAnonymousContextMenu = Util.nullAs(paramAnonymousView.lpy, "");
            i = 0;
            if (!(c.this.activity instanceof SnsCommentDetailUI)) {
              break label520;
            }
            i = 7;
          }
        }
        for (;;)
        {
          paramAnonymousView = com.tencent.mm.plugin.sns.storage.f.bbl(paramAnonymousView.KCD);
          com.tencent.mm.plugin.websearch.api.ar.a(1, com.tencent.mm.plugin.fts.a.d.Sx(77), 77, 0, "", "", com.tencent.mm.plugin.sns.data.t.Qu(paramAnonymousView.field_snsId), 3, "", 0L, paramAnonymousContextMenu.length(), i, "", "", -1);
          AppMethodBeat.o(224273);
          return;
          label447:
          if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vNk, 0) == 1)
          {
            i = 1;
            break;
          }
          i = 0;
          break;
          label480:
          l = paramAnonymousView.JVu.Ulp;
          break label226;
          label492:
          if (paramAnonymousView.scene != 2) {
            break label255;
          }
          i = 4;
          break label255;
          label506:
          i = 0;
          break label291;
          label512:
          at.b(paramAnonymousContextMenu, false);
          break label301;
          label520:
          if ((c.this.activity instanceof SnsWsFoldDetailUI)) {
            i = 6;
          } else if ((c.this.activity instanceof SnsTimeLineUI)) {
            i = 7;
          }
        }
      }
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(224276);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject = aj.fOI().bbk(((com.tencent.mm.plugin.sns.ui.m)localObject).KCE);
          c.this.LoP.a(paramAnonymousView, ((SnsInfo)localObject).getLocalid(), ((SnsInfo)localObject).getTimeLine());
          AppMethodBeat.o(224276);
          return true;
        }
        AppMethodBeat.o(224276);
        return false;
      }
    };
    this.yQj = new c.21(this);
    this.Lpm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100232);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousView.getTag() instanceof bi))
        {
          paramAnonymousView = (bi)paramAnonymousView.getTag();
          localObject = aj.fOI().bbk(paramAnonymousView.fLp);
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100232);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((SnsInfo)localObject).getTimeLine().ContentDesc);
          paramAnonymousView.putExtra("sns_local_id", ((SnsInfo)localObject).getLocalid());
          paramAnonymousView.putExtra("sns_content_source", 1);
          paramAnonymousView.setClass(c.this.activity, SnsSingleTextViewUI.class);
          localObject = c.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject).startActivity((Intent)paramAnonymousView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100232);
      }
    };
    this.Lpp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100239);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        com.tencent.mm.plugin.sns.ui.s locals;
        Object localObject2;
        Object localObject3;
        String str1;
        int i;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          locals = (com.tencent.mm.plugin.sns.ui.s)paramAnonymousView.getTag();
          localObject2 = (cvt)locals.KCX.ContentObj.Sqr.get(0);
          localObject1 = locals.fAg;
          aj.fOI().bbk((String)localObject1);
          localObject1 = "";
          localObject3 = com.tencent.mm.plugin.sns.model.aq.kD(aj.getAccSnsPath(), ((cvt)localObject2).Id);
          str1 = "";
          String str2 = com.tencent.mm.plugin.sns.data.t.i((cvt)localObject2);
          if (u.agG((String)localObject3 + str2))
          {
            localObject1 = (String)localObject3 + str2;
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.t.d((cvt)localObject2);
          }
          if (u.agG((String)localObject3 + com.tencent.mm.plugin.sns.data.t.o((cvt)localObject2)))
          {
            localObject1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.t.o((cvt)localObject2);
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.t.m((cvt)localObject2);
          }
          localObject2 = new int[2];
          localObject3 = paramAnonymousView.findViewById(i.f.content_preview);
          if (localObject3 == null) {
            break label536;
          }
          ((View)localObject3).getLocationInWindow((int[])localObject2);
          i = ((View)localObject3).getWidth();
        }
        for (int j = ((View)localObject3).getHeight();; j = paramAnonymousView.getHeight())
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(c.this.activity, SnsOnlineVideoActivity.class);
          paramAnonymousView.putExtra("intent_videopath", (String)localObject1);
          paramAnonymousView.putExtra("intent_thumbpath", str1);
          paramAnonymousView.putExtra("intent_localid", locals.fAg);
          paramAnonymousView.putExtra("intent_isad", false);
          paramAnonymousView.putExtra("intent_from_scene", c.this.source);
          paramAnonymousView.putExtra("img_gallery_left", localObject2[0]);
          paramAnonymousView.putExtra("img_gallery_top", localObject2[1]);
          paramAnonymousView.putExtra("img_gallery_width", i);
          paramAnonymousView.putExtra("img_gallery_height", j);
          localObject1 = c.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousView.aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)paramAnonymousView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          c.this.activity.overridePendingTransition(0, 0);
          c.a(c.this, locals.KCX);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100239);
          return;
          label536:
          paramAnonymousView.getLocationInWindow((int[])localObject2);
          i = paramAnonymousView.getWidth();
        }
      }
    };
    this.Lpo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(196470);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        Log.i("MicroMsg.TimelineClickListener", "onsight click");
        if ((paramAnonymousView.getTag() instanceof av)) {
          localObject1 = (av)paramAnonymousView.getTag();
        }
        for (;;)
        {
          final SnsInfo localSnsInfo = aj.fOI().bbl(((av)localObject1).fAg);
          if (localSnsInfo == null)
          {
            Log.i("MicroMsg.TimelineClickListener", "onsight click but info is null localid %s", new Object[] { ((av)localObject1).fAg });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(196470);
            return;
            if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
            {
              localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).JKG;
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
              localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).JKG;
            }
          }
          else
          {
            if (c.this.KCs != null) {
              c.this.KCs.fOn().N(localSnsInfo);
            }
            final boolean bool = localSnsInfo.isAd();
            Object localObject2 = localSnsInfo.getAdXml();
            if ((bool) && (localObject2 != null) && ((((ADXml)localObject2).isCardAd()) || (((ADXml)localObject2).isFullCardAd())))
            {
              c.this.LpB.onClick(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(196470);
              return;
            }
            if ((bool) && (localObject2 != null)) {
              com.tencent.mm.plugin.sns.ad.d.a.O(c.this.activity, ((ADXml)localObject2).appGiftPackCode, ((ADXml)localObject2).appGiftPackCodeTips);
            }
            final TimeLineObject localTimeLineObject = ((av)localObject1).KKi;
            if ((localTimeLineObject.ContentObj.Sqr == null) || (localTimeLineObject.ContentObj.Sqr.size() == 0))
            {
              Log.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(196470);
              return;
            }
            Object localObject4 = (cvt)localTimeLineObject.ContentObj.Sqr.get(0);
            if (bool)
            {
              aj.fOF();
              if (!com.tencent.mm.plugin.sns.model.g.u((cvt)localObject4))
              {
                ((av)localObject1).JAL.setVisibility(8);
                ((av)localObject1).KKn.setVisibility(0);
                ((av)localObject1).KKn.hZF();
                aj.fOF().A((cvt)localObject4);
                paramAnonymousView = aj.fOD();
                localObject1 = bp.hzm();
                ((bp)localObject1).time = localTimeLineObject.CreateTime;
                paramAnonymousView.a((cvt)localObject4, 4, null, (bp)localObject1);
                if (bool) {
                  com.tencent.mm.plugin.sns.ad.f.p.a(p.b.JGd, com.tencent.mm.plugin.sns.ad.f.p.a.JFU, localSnsInfo, c.this.source);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196470);
                return;
              }
            }
            if ((localSnsInfo.isAd()) && (localSnsInfo.getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(localSnsInfo.getAdSnsInfo().field_adxml))) {}
            int j;
            Object localObject3;
            for (int i = 1; (i == 0) && (bool) && (aj.fOF().v((cvt)localObject4)); i = 0)
            {
              aj.fOF().A((cvt)localObject4);
              ((av)localObject1).JAL.setVisibility(8);
              ((av)localObject1).KKn.setVisibility(8);
              paramAnonymousView = aj.fOF();
              localObject2 = ((av)localObject1).KKk;
              i = c.this.activity.hashCode();
              j = ((av)localObject1).position;
              localObject3 = bp.hzm();
              ((bp)localObject3).time = localTimeLineObject.CreateTime;
              paramAnonymousView.a(localSnsInfo, (cvt)localObject4, (VideoSightView)localObject2, i, j, (bp)localObject3, bool);
              ((av)localObject1).KKk.start();
              if (bool) {
                com.tencent.mm.plugin.sns.ad.f.p.a(p.b.JGd, com.tencent.mm.plugin.sns.ad.f.p.a.JFU, localSnsInfo, c.this.source);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(196470);
              return;
            }
            com.tencent.mm.modelsns.l locall;
            label776:
            Object localObject5;
            label1050:
            int k;
            if (c.this.source == 0)
            {
              localObject2 = com.tencent.mm.modelsns.l.wO(717);
              ((com.tencent.mm.modelsns.l)localObject2).Xf(com.tencent.mm.plugin.sns.data.t.w(localSnsInfo)).wR(localSnsInfo.field_type).gx(localSnsInfo.isAd()).Xf(localSnsInfo.getUxinfo()).Xf(((cvt)localObject4).Id);
              ((com.tencent.mm.modelsns.l)localObject2).bpa();
              if (c.this.source != 0) {
                break label1586;
              }
              locall = com.tencent.mm.modelsns.l.wO(745);
              locall.Xf(com.tencent.mm.plugin.sns.data.t.w(localSnsInfo)).wR(localSnsInfo.field_type).gx(localSnsInfo.isAd());
              if ((bool) && ((!localSnsInfo.getAdXml().isLandingPagesAd()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(localSnsInfo.getAdSnsInfo().field_adxml)))) {
                com.tencent.mm.plugin.sns.ad.f.p.a(p.b.JGd, com.tencent.mm.plugin.sns.ad.f.p.a.JFV, localSnsInfo, c.this.source);
              }
              localObject2 = "";
              localObject5 = com.tencent.mm.plugin.sns.model.aq.kD(aj.getAccSnsPath(), ((cvt)localObject4).Id);
              localObject3 = "";
              String str = com.tencent.mm.plugin.sns.data.t.i((cvt)localObject4);
              if (u.agG((String)localObject5 + str))
              {
                localObject2 = (String)localObject5 + str;
                localObject3 = (String)localObject5 + com.tencent.mm.plugin.sns.data.t.d((cvt)localObject4);
              }
              if (u.agG((String)localObject5 + com.tencent.mm.plugin.sns.data.t.o((cvt)localObject4)))
              {
                localObject2 = (String)localObject5 + com.tencent.mm.plugin.sns.data.t.o((cvt)localObject4);
                localObject3 = (String)localObject5 + com.tencent.mm.plugin.sns.data.t.m((cvt)localObject4);
              }
              localObject5 = new int[2];
              if (!com.tencent.mm.ui.ar.hIH()) {
                break label1597;
              }
              paramAnonymousView.getLocationOnScreen((int[])localObject5);
              j = paramAnonymousView.getWidth();
              k = paramAnonymousView.getHeight();
              com.tencent.mm.plugin.report.service.h.IzE.a(11444, new Object[] { Integer.valueOf(3) });
              if (bool) {
                break label1670;
              }
              Log.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
              localObject4 = new Intent();
              ((Intent)localObject4).setClass(c.this.activity, SnsOnlineVideoActivity.class);
              ((Intent)localObject4).putExtra("intent_videopath", (String)localObject2);
              ((Intent)localObject4).putExtra("intent_thumbpath", (String)localObject3);
              ((Intent)localObject4).putExtra("intent_localid", ((av)localObject1).fAg);
              ((Intent)localObject4).putExtra("intent_isad", bool);
              ((Intent)localObject4).putExtra("intent_from_scene", c.this.source);
              ((Intent)localObject4).putExtra("sns_video_scene", ((av)localObject1).KKq);
              paramAnonymousView = com.tencent.mm.plugin.sns.ui.helper.a.LkD;
              paramAnonymousView = ((av)localObject1).KKi.actionInfo.RFO.lVG;
              localObject2 = ((av)localObject1).KKi.actionInfo.RFO.RFJ;
              if ((!TextUtils.isEmpty((CharSequence)paramAnonymousView)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
                break label1606;
              }
              paramAnonymousView = "";
            }
            for (;;)
            {
              ((Intent)localObject4).putExtra("intent_third_sdk_msg", paramAnonymousView);
              ((Intent)localObject4).putExtra("intent_publish_id", com.tencent.mm.plugin.sns.data.t.Qv(localSnsInfo.field_snsId));
              ((Intent)localObject4).putExtra("intent_bottom_height", com.tencent.mm.ui.ax.aB(c.this.activity));
              paramAnonymousView = com.tencent.mm.plugin.sns.ui.video.e.fZg().bcC(localTimeLineObject.Id);
              if ((paramAnonymousView != null) && (paramAnonymousView.isPlaying()))
              {
                ((Intent)localObject4).putExtra("intent_fromplayingvideo", true);
                ((Intent)localObject4).putExtra("intent_fromplayingvideo_tlobjid", localTimeLineObject.Id);
                ((Intent)localObject4).putExtra("intent_session_id", paramAnonymousView.getSessionId());
                ((Intent)localObject4).putExtra("intent_session_timestamp", paramAnonymousView.getSessionTimestamp());
                if (((av)localObject1).KKj != null) {
                  ((av)localObject1).KKj.findViewById(i.f.thumb_mask).setVisibility(0);
                }
              }
              ((Intent)localObject4).putExtra("img_gallery_left", localObject5[0]);
              ((Intent)localObject4).putExtra("img_gallery_top", localObject5[1]);
              ((Intent)localObject4).putExtra("img_gallery_width", j);
              ((Intent)localObject4).putExtra("img_gallery_height", k);
              locall.b((Intent)localObject4, "intent_key_StatisticsOplog");
              paramAnonymousView = c.this.activity;
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject4);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              c.this.activity.overridePendingTransition(0, 0);
              c.a(c.this, localSnsInfo.getTimeLine());
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(196470);
              return;
              localObject2 = com.tencent.mm.modelsns.l.wP(717);
              break;
              label1586:
              locall = com.tencent.mm.modelsns.l.wP(745);
              break label776;
              label1597:
              paramAnonymousView.getLocationInWindow((int[])localObject5);
              break label1050;
              label1606:
              if (paramAnonymousView == null) {}
              do
              {
                for (;;)
                {
                  paramAnonymousView = "";
                  break;
                  switch (paramAnonymousView.hashCode())
                  {
                  }
                }
              } while (!paramAnonymousView.equals("wxa5e0de08d96cc09d"));
              if (localObject2 == null) {
                kotlin.g.b.p.iCn();
              }
              paramAnonymousView = com.tencent.mm.plugin.sns.ui.helper.a.bcq((String)localObject2);
            }
            label1670:
            if ((localSnsInfo.isAd()) && (localSnsInfo.getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.bbf(localSnsInfo.getAdSnsInfo().field_adxml)))
            {
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.R(localSnsInfo);
              if (!Util.isNullOrNil(paramAnonymousView)) {
                localSnsInfo.getAdSnsInfo().field_adxml = paramAnonymousView;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("img_gallery_left", localObject5[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject5[1]);
              paramAnonymousView.putExtra("img_gallery_width", j);
              paramAnonymousView.putExtra("img_gallery_height", k);
              paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localSnsInfo.getSnsId());
              paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localSnsInfo.getTimeLine().Id);
              paramAnonymousView.putExtra("sns_landing_pages_ux_info", localSnsInfo.getUxinfo());
              localObject1 = localSnsInfo.getTimeLine();
              if (localObject1 != null)
              {
                localObject1 = ((TimeLineObject)localObject1).ContentObj.Sqr;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((cvt)((List)localObject1).get(0)).TDF);
                }
              }
              c.a(c.this, paramAnonymousView, localSnsInfo);
              paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
              i = 1;
              if (c.this.source == 2)
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
                localObject1 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousView.aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (!localSnsInfo.getAdXml().forbiddenCustomAnimation) {
                  c.this.activity.overridePendingTransition(0, 0);
                }
                j = c.this.source;
                if (c.this.source != 0) {
                  break label2204;
                }
              }
              label2204:
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 21, 21);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, localSnsInfo, 21);
                com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(196470);
                return;
                if (c.this.source != 1) {
                  break;
                }
                i = 2;
                break;
              }
            }
            if ((localSnsInfo.isAd()) && (localSnsInfo.getAdInfo() != null) && (localSnsInfo.getAdInfo().isWeapp()))
            {
              c.a(c.this, localSnsInfo.getAdInfo(), localSnsInfo, false);
              j = c.this.source;
              if (c.this.source == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 21, 31);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, localSnsInfo, 21);
                com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
                break;
              }
            }
            int m;
            if (localSnsInfo.isAd())
            {
              m = c.this.source;
              if (c.this.source == 0)
              {
                i = 1;
                label2347:
                paramAnonymousView = new SnsAdClick(m, i, localSnsInfo.field_snsId, 17, 0);
                com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, localSnsInfo, 17);
                com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
              }
            }
            else
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.setClass(c.this.activity, SnsSightPlayerUI.class);
              paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
              paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
              paramAnonymousView.putExtra("intent_localid", ((av)localObject1).fAg);
              paramAnonymousView.putExtra("intent_isad", bool);
              paramAnonymousView.putExtra("intent_from_scene", c.this.source);
              paramAnonymousView.putExtra("img_gallery_left", localObject5[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject5[1]);
              paramAnonymousView.putExtra("img_gallery_width", j);
              paramAnonymousView.putExtra("img_gallery_height", k);
              locall.b(paramAnonymousView, "intent_key_StatisticsOplog");
              localObject2 = c.this.activity;
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramAnonymousView.aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Activity)localObject2).startActivity((Intent)paramAnonymousView.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              c.this.activity.overridePendingTransition(0, 0);
              new MMHandler().postDelayed(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(236392);
                  if (aj.fOF().v(this.JJb))
                  {
                    this.LpO.KKk.f(null, false, 0);
                    com.tencent.mm.plugin.sns.model.g localg = aj.fOF();
                    SnsInfo localSnsInfo = localSnsInfo;
                    cvt localcvt = this.JJb;
                    VideoSightView localVideoSightView = this.LpO.KKk;
                    int i = c.this.activity.hashCode();
                    int j = this.LpO.position;
                    bp localbp = bp.hzm();
                    localbp.time = localTimeLineObject.CreateTime;
                    localg.a(localSnsInfo, localcvt, localVideoSightView, i, j, localbp, bool);
                    this.LpO.KKk.start();
                    this.LpO.JAL.setVisibility(0);
                    this.LpO.KKn.setVisibility(8);
                    this.LpO.JAL.setImageDrawable(com.tencent.mm.ci.a.m(c.this.activity, i.i.shortvideo_play_btn));
                  }
                  AppMethodBeat.o(236392);
                }
              }, 500L);
              paramAnonymousView = new int[3];
              if ((bool) || (aj.fOF().a(localSnsInfo, paramAnonymousView) <= 5)) {
                break label3171;
              }
              aj.fOF().z((cvt)localObject4);
              i = 1;
            }
            label3284:
            for (;;)
            {
              label2672:
              int n = paramAnonymousView[0];
              int i1 = paramAnonymousView[1];
              if (i == 2) {}
              for (m = 1;; m = 0)
              {
                for (;;)
                {
                  int i2 = paramAnonymousView[2];
                  paramAnonymousView = localSnsInfo.getTimeLine();
                  localObject1 = new com.tencent.mm.modelsns.n();
                  ((com.tencent.mm.modelsns.n)localObject1).m("20FeedId", paramAnonymousView.Id + ",");
                  ((com.tencent.mm.modelsns.n)localObject1).m("21AdUxInfo", localSnsInfo.getUxinfo() + ",");
                  for (;;)
                  {
                    try
                    {
                      paramAnonymousView = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
                      if (paramAnonymousView.ObjectOperations == null) {
                        continue;
                      }
                      paramAnonymousView = (ekj)new ekj().parseFrom(paramAnonymousView.ObjectOperations.Tkb.UH);
                      if (paramAnonymousView.Umf == null) {
                        continue;
                      }
                      k = paramAnonymousView.Umf.SrQ;
                    }
                    catch (Exception paramAnonymousView)
                    {
                      label3171:
                      k = 0;
                      Log.printErrStackTrace("MicroMsg.TimelineClickListener", paramAnonymousView, "", new Object[0]);
                      j = 0;
                      continue;
                      if (NetStatusUtil.is2G(MMApplicationContext.getContext()))
                      {
                        i = 2;
                        continue;
                      }
                      if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
                      {
                        i = 3;
                        continue;
                      }
                      if (!NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                        continue;
                      }
                      i = 4;
                      continue;
                      j = 0;
                      k = 0;
                      continue;
                      i = 2;
                    }
                    try
                    {
                      j = paramAnonymousView.Umf.SrR;
                      ((com.tencent.mm.modelsns.n)localObject1).m("22LayerId", k + ",");
                      ((com.tencent.mm.modelsns.n)localObject1).m("23ExpId", j + ",");
                      ((com.tencent.mm.modelsns.n)localObject1).m("24ClickState", i + ",");
                      ((com.tencent.mm.modelsns.n)localObject1).m("25ClickTime", Util.nowSecond() + ",");
                      i = 0;
                      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                        continue;
                      }
                      i = 1;
                      ((com.tencent.mm.modelsns.n)localObject1).m("26NetworkType", i + ",");
                      ((com.tencent.mm.modelsns.n)localObject1).m("27IsFlowControl", n + ",");
                      ((com.tencent.mm.modelsns.n)localObject1).m("28AutoDownloadSetting", i1 + ",");
                      ((com.tencent.mm.modelsns.n)localObject1).m("29IsAutoPlay", m + ",");
                      ((com.tencent.mm.modelsns.n)localObject1).m("30IsFlowControlDatePeriod", i2 + ",");
                      Log.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + ((com.tencent.mm.modelsns.n)localObject1).agI());
                      com.tencent.mm.plugin.report.service.h.IzE.a(13323, new Object[] { localObject1 });
                    }
                    catch (Exception paramAnonymousView) {}
                  }
                }
                i = 2;
                break label2347;
                if ((!bool) || (aj.fOF().b(localSnsInfo, paramAnonymousView) <= 5)) {
                  break label3284;
                }
                aj.fOF().z((cvt)localObject4);
                i = 1;
                break label2672;
              }
            }
          }
          localObject1 = null;
        }
      }
    };
    this.Lpf = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(218696);
        if ((paramAnonymousView.getTag() instanceof av))
        {
          paramAnonymousView = (av)paramAnonymousView.getTag();
          if (!paramAnonymousView.isAd) {
            paramAnonymousContextMenu.add(0, 19, 0, c.this.activity.getString(i.j.chatting_long_click_menu_mute_play));
          }
          if (Util.safeParseInt(com.tencent.mm.n.h.axc().getValue("SIGHTCannotTransmitForFav")) != 0) {
            break label311;
          }
          if (paramAnonymousView.KKi.ContentObj.Sqr.size() <= 0) {
            break label304;
          }
          paramAnonymousContextMenuInfo = (cvt)paramAnonymousView.KKi.ContentObj.Sqr.get(0);
          String str = paramAnonymousContextMenuInfo.Id;
          str = com.tencent.mm.plugin.sns.model.aq.kD(aj.getAccSnsPath(), str) + com.tencent.mm.plugin.sns.data.t.d(paramAnonymousContextMenuInfo);
          paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.ax.a(paramAnonymousView.fAg, paramAnonymousContextMenuInfo);
          boolean bool1 = u.agG(str);
          boolean bool2 = u.agG(paramAnonymousContextMenuInfo);
          Log.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool1) || (!bool2)) {
            break label311;
          }
        }
        label304:
        label311:
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.by.c.blP("favorite")) {
            paramAnonymousContextMenu.add(0, 10, 0, c.this.activity.getString(i.j.plugin_favorite_opt));
          }
          if (i != 0)
          {
            paramAnonymousContextMenuInfo = new em();
            paramAnonymousContextMenuInfo.fAp.fAg = paramAnonymousView.fAg;
            EventCenter.instance.publish(paramAnonymousContextMenuInfo);
            if (paramAnonymousContextMenuInfo.fAq.fzO) {
              paramAnonymousContextMenu.add(0, 18, 0, c.this.activity.getString(i.j.app_open));
            }
          }
          AppMethodBeat.o(218696);
          return;
          Log.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
        }
      }
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(218702);
        if ((paramAnonymousView.getTag() instanceof av))
        {
          String str = ((av)paramAnonymousView.getTag()).fAg;
          SnsInfo localSnsInfo = aj.fOI().bbl(str);
          c.this.LoP.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(218702);
          return true;
        }
        AppMethodBeat.o(218702);
        return false;
      }
    };
    this.Lpq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(242702);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        c.this.gz(paramAnonymousView);
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.e)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(242702);
          return;
        }
        localObject = (com.tencent.mm.plugin.sns.data.e)paramAnonymousView.getTag();
        paramAnonymousView = aj.fOI().bbl(((com.tencent.mm.plugin.sns.data.e)localObject).fAg);
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(242702);
          return;
        }
        int j;
        if (paramAnonymousView.isAd())
        {
          ((com.tencent.mm.plugin.sns.data.e)localObject).JPX = System.currentTimeMillis();
          j = c.this.source;
          if (c.this.source != 0) {
            break label214;
          }
        }
        label214:
        for (int i = 1;; i = 2)
        {
          localObject = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 20, 0);
          com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject, c.this.KPn, paramAnonymousView, 20);
          com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(242702);
          return;
        }
      }
    };
    this.Lpx = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100244);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        Log.i("MicroMsg.TimelineClickListener", "unlike click");
        if (!(paramAnonymousAdapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c))
        {
          Log.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(100244);
          return;
        }
        Object localObject2 = (com.tencent.mm.plugin.sns.data.e)paramAnonymousView.getTag();
        SnsInfo localSnsInfo = aj.fOI().bbl(((com.tencent.mm.plugin.sns.data.e)localObject2).fAg);
        if (localSnsInfo == null) {
          try
          {
            c.this.fTu();
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
              ((com.tencent.mm.plugin.sns.b.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.sns.b.d.class)).b(11855, localSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(3), localObject1, Integer.valueOf(localSnsInfo.getAdRecSrc()) });
            }
          }
          else
          {
            if (!((com.tencent.mm.plugin.sns.data.e)localObject2).JPW.LeY.adUnlikeInfo.fQB()) {
              break label404;
            }
            paramAnonymousView = (com.tencent.mm.plugin.sns.ui.c)paramAnonymousAdapterView.getAdapter();
            paramAnonymousView.oxQ += 1;
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousAdapterView.setOnItemClickListener(c.this.Lpy);
            c.this.fTt();
            paramAnonymousAdapterView = new ADInfo.c.a();
            paramAnonymousAdapterView.Kjn = ADInfo.c.a.Kjj;
            paramAnonymousAdapterView.JPX = ((com.tencent.mm.plugin.sns.data.e)localObject2).JPX;
            paramAnonymousAdapterView.Kjq = 0L;
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.s(localSnsInfo.field_snsId, 8, paramAnonymousAdapterView);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousAdapterView, 0);
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
          if (((com.tencent.mm.plugin.sns.data.e)localObject2).JPW.LeY.forbidClick)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          c.this.gA(paramAnonymousView);
          paramAnonymousAdapterView = new ADInfo.c.a();
          paramAnonymousAdapterView.JPX = ((com.tencent.mm.plugin.sns.data.e)localObject2).JPX;
          paramAnonymousAdapterView.Kjq = System.currentTimeMillis();
          paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.s(localSnsInfo.field_snsId, 8, paramAnonymousAdapterView);
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousAdapterView, 0);
          continue;
          if (((com.tencent.mm.plugin.sns.data.e)localObject2).JPW.LeX.adFeedbackInfo == null)
          {
            Log.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          paramAnonymousAdapterView = ((com.tencent.mm.plugin.sns.data.e)localObject2).JPW.LeX.adFeedbackInfo;
          paramAnonymousInt -= 1;
          if (paramAnonymousInt < paramAnonymousAdapterView.list.size()) {
            paramAnonymousAdapterView = ((ADXml.f)paramAnonymousAdapterView.list.get(paramAnonymousInt)).url;
          }
          try
          {
            paramAnonymousView = String.format("snsid=%s", new Object[] { localSnsInfo.getTimeLine().Id });
            localObject1 = String.format("aid=%s", new Object[] { localSnsInfo.getAid() });
            localObject2 = String.format("traceid=%s", new Object[] { localSnsInfo.getTraceid() });
            com.tencent.mm.kernel.h.aHE();
            paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.m(paramAnonymousAdapterView, new String[] { paramAnonymousView, localObject1, localObject2, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.b.aGq() }) });
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
          paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId));
          paramAnonymousView.putExtra("pre_username", localSnsInfo.field_userName);
          paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(localSnsInfo.field_snsId));
          paramAnonymousView.putExtra("preUsername", localSnsInfo.field_userName);
          com.tencent.mm.plugin.sns.c.a.mIG.h(paramAnonymousView, c.this.activity);
        }
      }
    };
    this.Lpy = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(198802);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.e)))
        {
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.data.e)paramAnonymousView.getTag();
          if (paramAnonymousInt < paramAnonymousAdapterView.JPW.LeY.adUnlikeInfo.fQA().size())
          {
            if (paramAnonymousAdapterView.JPW.LeY.forbidClick)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(198802);
              return;
            }
            localObject = (ADInfo.c.a)paramAnonymousAdapterView.JPW.LeY.adUnlikeInfo.fQA().get(paramAnonymousInt);
            Log.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[] { ((ADInfo.c.a)localObject).Kjk, Integer.valueOf(((ADInfo.c.a)localObject).Kjn) });
            SnsInfo localSnsInfo = aj.fOI().bbl(paramAnonymousAdapterView.fAg);
            if (localSnsInfo == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(198802);
              return;
            }
            c.this.gA(paramAnonymousView);
            ((ADInfo.c.a)localObject).JPX = paramAnonymousAdapterView.JPX;
            ((ADInfo.c.a)localObject).Kjq = System.currentTimeMillis();
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.s(localSnsInfo.field_snsId, 8, localObject);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousAdapterView, 0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(198802);
      }
    };
    this.Lpw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163130);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          localObject = (TimeLineObject)paramAnonymousView.getTag();
          bje localbje = ((TimeLineObject)localObject).ContentObj.fFJ;
          Intent localIntent = new Intent();
          localIntent.putExtra("feed_object_id", com.tencent.mm.plugin.sns.data.t.aZs(localbje.objectId));
          localIntent.putExtra("feed_object_nonceId", localbje.objectNonceId);
          localIntent.putExtra("business_type", 0);
          localIntent.putExtra("finder_user_name", localbje.username);
          localIntent.putExtra("report_scene", 3);
          localIntent.putExtra("from_user", ((TimeLineObject)localObject).UserName);
          ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).fillContextIdToIntent(4, 2, 25, localIntent);
          ((com.tencent.mm.plugin.findersdk.a.ak)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.findersdk.a.ak.class)).enterFinderShareFeedUI(paramAnonymousView.getContext(), localIntent);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163130);
      }
    };
    this.LpB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(267366);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if ((paramAnonymousView.getTag() == null) || ((!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) && (!(paramAnonymousView.getTag() instanceof be)) && (!(paramAnonymousView.getTag() instanceof av)) && (!(paramAnonymousView.getTag() instanceof MaskImageView)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(267366);
          return;
        }
        localObject1 = null;
        int m = 0;
        int j = 0;
        int n = 0;
        int k = 0;
        int i = 0;
        Object localObject3;
        if ((paramAnonymousView.getTag() instanceof be))
        {
          localObject3 = com.tencent.mm.plugin.sns.storage.f.bbl(((be)paramAnonymousView.getTag()).fCM);
          if ((paramAnonymousView instanceof LinearLayout))
          {
            i = 0;
            if (!((be)paramAnonymousView.getTag()).KKr) {
              break label5309;
            }
            k = ((be)paramAnonymousView.getTag()).index;
            if (k <= 0) {
              break label238;
            }
            j = 2;
          }
        }
        for (;;)
        {
          m = i;
          i = j;
          j = m;
          if ((localObject3 == null) || (!((SnsInfo)localObject3).isAd()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(267366);
            return;
            i = 1;
            break;
            label238:
            j = 1;
            continue;
            if ((paramAnonymousView.getTag() instanceof MaskImageView))
            {
              localObject3 = (MaskImageView)paramAnonymousView.getTag();
              if (!(((MaskImageView)localObject3).getTag() instanceof be)) {
                break label5304;
              }
              localObject3 = com.tencent.mm.plugin.sns.storage.f.bbl(((be)((MaskImageView)localObject3).getTag()).fCM);
              localObject1 = localObject3;
              j = n;
              if ((paramAnonymousView instanceof LinearLayout)) {
                break label458;
              }
              i = 1;
              localObject1 = localObject3;
            }
          }
          for (;;)
          {
            m = 0;
            k = 0;
            j = i;
            i = m;
            localObject3 = localObject1;
            break;
            if ((paramAnonymousView.getTag() instanceof av))
            {
              localObject1 = (av)paramAnonymousView.getTag();
              localObject3 = aj.fOI().bbl(((av)localObject1).fAg);
              if ((paramAnonymousView instanceof LinearLayout))
              {
                j = 0;
                label368:
                if (!((av)localObject1).KKr) {
                  break label5295;
                }
                k = ((av)localObject1).KKs;
                if (k <= 0) {
                  break label398;
                }
                i = 2;
              }
            }
            for (;;)
            {
              break;
              j = 1;
              break label368;
              label398:
              i = 1;
              continue;
              if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
              {
                localObject3 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                localObject1 = com.tencent.mm.plugin.sns.storage.f.bbk(((BaseTimeLineItem.BaseViewHolder)localObject3).fLp);
                if (!(localObject3 instanceof r.b)) {
                  break label5290;
                }
                j = ((r.b)localObject3).LnZ.index;
                if (j > 0) {
                  i = 2;
                }
              }
              for (;;)
              {
                label458:
                k = j;
                j = 0;
                localObject3 = localObject1;
                break;
                i = 1;
                continue;
                if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b))
                {
                  localObject3 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).Jzk;
                  localObject1 = localObject3;
                  j = n;
                  if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.i))
                  {
                    j = ((com.tencent.mm.plugin.sns.ui.c.a.i)paramAnonymousView.getTag()).currentIndex;
                    if (j > 0) {}
                    for (i = 2;; i = 1)
                    {
                      localObject1 = localObject3;
                      break;
                    }
                    for (;;)
                    {
                      try
                      {
                        localObject1 = c.a(c.this, (SnsInfo)localObject3);
                        if (localObject1 != null) {
                          continue;
                        }
                        localObject1 = "";
                        localObject4 = ((SnsInfo)localObject3).getTimeLine().Id;
                        if (!((SnsInfo)localObject3).isRecExpAd())
                        {
                          localObject5 = com.tencent.mm.plugin.report.service.h.IzE;
                          if (c.this.source != 0) {
                            continue;
                          }
                          m = 1;
                          if (j == 0) {
                            continue;
                          }
                          j = 1;
                          ((com.tencent.mm.plugin.report.service.h)localObject5).a(14066, new Object[] { Integer.valueOf(m), Integer.valueOf(j), localObject4, localObject1 });
                        }
                      }
                      catch (Exception localException)
                      {
                        Object localObject6;
                        Log.e("MicroMsg.TimelineClickListener", "report click ad card style error " + localException.getMessage());
                        continue;
                        localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject4).JKG;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).JKG;
                        Object localObject4 = null;
                        continue;
                        if (c.this.KCs == null) {
                          continue;
                        }
                        c.this.KCs.fOn().N((SnsInfo)localObject3);
                        boolean bool = ((SnsInfo)localObject3).isAd();
                        if ((((TimeLineObject)localObject6).ContentObj.Sqr != null) && (((TimeLineObject)localObject6).ContentObj.Sqr.size() != 0)) {
                          continue;
                        }
                        Log.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(267366);
                        return;
                        cvt localcvt = (cvt)((TimeLineObject)localObject6).ContentObj.Sqr.get(k);
                        if (!bool) {
                          continue;
                        }
                        aj.fOF();
                        if ((com.tencent.mm.plugin.sns.model.g.u(localcvt)) || (localObject2 == null)) {
                          continue;
                        }
                        ((av)localObject2).JAL.setVisibility(8);
                        ((av)localObject2).KKn.setVisibility(0);
                        ((av)localObject2).KKn.hZF();
                        aj.fOF().A(localcvt);
                        paramAnonymousView = aj.fOD();
                        localObject2 = bp.hzm();
                        ((bp)localObject2).time = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a(localcvt, 4, null, (bp)localObject2);
                        if (!bool) {
                          continue;
                        }
                        com.tencent.mm.plugin.sns.ad.f.p.a(p.b.JGd, com.tencent.mm.plugin.sns.ad.f.p.a.JFU, (SnsInfo)localObject3, c.this.source);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(267366);
                        return;
                        if ((!((SnsInfo)localObject3).isAd()) || (!((SnsInfo)localObject3).getAdXml().isLandingPagesAd())) {
                          continue;
                        }
                        String str = ((SnsInfo)localObject3).getAdSnsInfo().field_adxml;
                        if (k <= 0) {
                          continue;
                        }
                        Object localObject5 = "adTurnCanvasInfo";
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.lc(str, (String)localObject5)) {
                          continue;
                        }
                        m = 1;
                        if ((m != 0) || (!bool) || (!aj.fOF().v(localcvt)) || (localObject2 == null)) {
                          continue;
                        }
                        aj.fOF().A(localcvt);
                        ((av)localObject2).JAL.setVisibility(8);
                        ((av)localObject2).KKn.setVisibility(8);
                        paramAnonymousView = aj.fOF();
                        localObject4 = ((av)localObject2).KKk;
                        i = c.this.activity.hashCode();
                        j = ((av)localObject2).position;
                        localObject5 = bp.hzm();
                        ((bp)localObject5).time = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a((SnsInfo)localObject3, localcvt, (VideoSightView)localObject4, i, j, (bp)localObject5, bool);
                        ((av)localObject2).KKk.start();
                        if (!bool) {
                          continue;
                        }
                        com.tencent.mm.plugin.sns.ad.f.p.a(p.b.JGd, com.tencent.mm.plugin.sns.ad.f.p.a.JFU, (SnsInfo)localObject3, c.this.source);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(267366);
                        return;
                        localObject5 = "adCanvasInfo";
                        continue;
                        m = 0;
                        continue;
                        if (c.this.source != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.l.wO(717);
                        ((com.tencent.mm.modelsns.l)localObject2).Xf(com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject3)).wR(((SnsInfo)localObject3).field_type).gx(((SnsInfo)localObject3).isAd()).Xf(((SnsInfo)localObject3).getUxinfo()).Xf(localcvt.Id);
                        ((com.tencent.mm.modelsns.l)localObject2).bpa();
                        if (c.this.source != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.l.wO(745);
                        ((com.tencent.mm.modelsns.l)localObject2).Xf(com.tencent.mm.plugin.sns.data.t.w((SnsInfo)localObject3)).wR(((SnsInfo)localObject3).field_type).gx(((SnsInfo)localObject3).isAd());
                        localObject2 = new int[2];
                        j = 0;
                        n = 0;
                        i = 0;
                        if (localObject4 == null) {
                          continue;
                        }
                        if (!(localObject4 instanceof h.a)) {
                          continue;
                        }
                        localObject4 = (h.a)localObject4;
                        if (((h.a)localObject4).Lnh.xYJ == null) {
                          continue;
                        }
                        ((h.a)localObject4).Lnh.xYJ.getLocationInWindow((int[])localObject2);
                        j = ((h.a)localObject4).Lnh.xYJ.getWidth();
                        i = ((h.a)localObject4).Lnh.xYJ.getHeight();
                        n = j;
                        j = i;
                        i = n;
                        com.tencent.mm.plugin.report.service.h.IzE.a(11444, new Object[] { Integer.valueOf(3) });
                        localObject4 = c.a(c.this, (SnsInfo)localObject3);
                        if (!com.tencent.mm.plugin.sns.data.m.a(c.this.activity, (SnsInfo)localObject3, (ADInfo)localObject4, c.this.source, c.this.KPn)) {
                          continue;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(267366);
                        return;
                        localObject2 = com.tencent.mm.modelsns.l.wP(717);
                        continue;
                        localObject2 = com.tencent.mm.modelsns.l.wP(745);
                        continue;
                        if (!(localObject4 instanceof com.tencent.mm.plugin.sns.ui.item.g.a)) {
                          continue;
                        }
                        localObject4 = (com.tencent.mm.plugin.sns.ui.item.g.a)localObject4;
                        i = n;
                        if (((com.tencent.mm.plugin.sns.ui.item.g.a)localObject4).xYJ == null) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.item.g.a)localObject4).xYJ.getLocationInWindow((int[])localObject2);
                        j = ((com.tencent.mm.plugin.sns.ui.item.g.a)localObject4).xYJ.getWidth();
                        i = ((com.tencent.mm.plugin.sns.ui.item.g.a)localObject4).xYJ.getHeight();
                        n = i;
                        i = j;
                        j = n;
                        continue;
                        if (((BaseTimeLineItem.BaseViewHolder)localObject4).JKG.KKm == null) {
                          continue;
                        }
                        ((BaseTimeLineItem.BaseViewHolder)localObject4).JKG.KKm.getLocationInWindow((int[])localObject2);
                        i = ((BaseTimeLineItem.BaseViewHolder)localObject4).JKG.KKm.getWidth();
                        j = ((BaseTimeLineItem.BaseViewHolder)localObject4).JKG.KKm.getHeight();
                        continue;
                        if (((TimeLineObject)localObject6).ContentObj.Sqq != 27) {
                          continue;
                        }
                        ((r.b)localObject4).LnX.getLocationInWindow((int[])localObject2);
                        i = ((r.b)localObject4).LnX.getWidth();
                        j = ((r.b)localObject4).LnX.getHeight();
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof av)) {
                          continue;
                        }
                        localObject4 = (av)paramAnonymousView.getTag();
                        if (localObject4 == null) {
                          continue;
                        }
                        ((av)localObject4).KKm.getLocationInWindow((int[])localObject2);
                        i = ((av)localObject4).KKm.getWidth();
                        j = ((av)localObject4).KKm.getHeight();
                        continue;
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView.getLocationInWindow((int[])localObject2);
                        i = paramAnonymousView.getWidth();
                        j = paramAnonymousView.getHeight();
                        continue;
                        if (m == 0) {
                          continue;
                        }
                        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                          continue;
                        }
                        c.this.a((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag(), null);
                        n = c.this.source;
                        if (c.this.source != 0) {
                          continue;
                        }
                        m = 1;
                        paramAnonymousView = new SnsAdClick(n, m, ((SnsInfo)localObject3).field_snsId, 22, 21);
                        com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, (SnsInfo)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
                        localObject4 = new Intent();
                        ((Intent)localObject4).putExtra("img_gallery_left", localObject2[0]);
                        ((Intent)localObject4).putExtra("img_gallery_top", localObject2[1]);
                        ((Intent)localObject4).putExtra("img_gallery_width", i);
                        ((Intent)localObject4).putExtra("img_gallery_height", j);
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_sns_id", ((SnsInfo)localObject3).getSnsId());
                        ((Intent)localObject4).putExtra("sns_landing_pages_rawSnsId", ((SnsInfo)localObject3).getTimeLine().Id);
                        ((Intent)localObject4).putExtra("sns_landing_pages_ux_info", ((SnsInfo)localObject3).getUxinfo());
                        paramAnonymousView = ((SnsInfo)localObject3).getTimeLine();
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView = paramAnonymousView.ContentObj.Sqr;
                        if (paramAnonymousView.size() <= k) {
                          continue;
                        }
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_thumb_url", ((cvt)paramAnonymousView.get(k)).TDF);
                        ((Intent)localObject4).setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                        i = 1;
                        if (c.this.source != 2) {
                          continue;
                        }
                        i = 16;
                        ((Intent)localObject4).putExtra("sns_landig_pages_from_source", i);
                        if (k <= 0) {
                          continue;
                        }
                        paramAnonymousView = ((SnsInfo)localObject3).getAdXml().getTurnCanvasInfo();
                        ((Intent)localObject4).putExtra("sns_landing_pages_xml", paramAnonymousView);
                        ((Intent)localObject4).putExtra("sns_landing_pages_rec_src", ((SnsInfo)localObject3).getAdRecSrc());
                        ((Intent)localObject4).putExtra("sns_landing_pages_xml_prefix", "adxml");
                        ((Intent)localObject4).putExtra("sns_landing_page_start_time", System.currentTimeMillis());
                        if (((SnsInfo)localObject3).getAdXml().forbiddenCustomAnimation) {
                          continue;
                        }
                        ((Intent)localObject4).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        ((Intent)localObject4).putExtra("sns_landing_is_native_sight_ad", true);
                        paramAnonymousView = c.this.activity;
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject4);
                        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
                        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        if (((SnsInfo)localObject3).getAdXml().forbiddenCustomAnimation) {
                          continue;
                        }
                        c.this.activity.overridePendingTransition(0, 0);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(267366);
                        return;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
                          continue;
                        }
                        c.this.a((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag(), null);
                        continue;
                        m = 2;
                        continue;
                        if (c.this.source != 1) {
                          continue;
                        }
                        i = 2;
                        continue;
                        paramAnonymousView = ((SnsInfo)localObject3).getAdSnsInfo().field_adxml;
                        continue;
                        localObject2 = c.this;
                        localObject4 = c.a(c.this, (SnsInfo)localObject3);
                        if (k <= 0) {
                          continue;
                        }
                        bool = true;
                        if (!c.a((c)localObject2, (ADInfo)localObject4, (SnsInfo)localObject3, bool)) {
                          continue;
                        }
                        try
                        {
                          com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.fLk().a(c.this.source, (SnsInfo)localObject3);
                          j = c.this.source;
                          if (c.this.source == 0)
                          {
                            i = 1;
                            paramAnonymousView = new SnsAdClick(j, i, ((SnsInfo)localObject3).field_snsId, 22, 31);
                            com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, (SnsInfo)localObject3, 22);
                            com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(267366);
                            return;
                            bool = false;
                            continue;
                          }
                          i = 2;
                          continue;
                          try
                          {
                            localObject2 = com.tencent.mm.plugin.sns.ad.timeline.a.a.e(4, c.this.activity);
                            if (localObject2 != null)
                            {
                              localObject4 = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
                              ((com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject4).put("snsAdStatistic", c.this.KPn);
                              bool = ((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject2).a(paramAnonymousView, c.this.source, (SnsInfo)localObject3, (com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject4);
                              if (bool)
                              {
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(267366);
                                return;
                              }
                            }
                          }
                          catch (Throwable paramAnonymousView)
                          {
                            j = c.this.source;
                            if (c.this.source == 0)
                            {
                              i = 1;
                              localObject4 = new SnsAdClick(j, i, ((SnsInfo)localObject3).field_snsId, 22, 0);
                              com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject4, c.this.KPn, (SnsInfo)localObject3, 22);
                              com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject4);
                              if (k > 0)
                              {
                                localObject2 = ((SnsInfo)localObject3).getAdXml().adTurnInfo.adActionLink;
                                paramAnonymousView = (View)localObject2;
                                if (Util.isNullOrNil((String)localObject2)) {
                                  paramAnonymousView = ((SnsInfo)localObject3).getAdLink();
                                }
                                Log.i("MicroMsg.TimelineClickListener", "video cardAdClick, adlink url " + paramAnonymousView + " " + ((SnsInfo)localObject3).getAdXml().webrightBar);
                                if (!Util.isNullOrNil(paramAnonymousView)) {
                                  continue;
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(267366);
                              }
                            }
                            else
                            {
                              i = 2;
                              continue;
                            }
                            localObject2 = ((SnsInfo)localObject3).getAdInfoLink();
                            continue;
                            localObject5 = new Intent();
                            if (((SnsInfo)localObject3).getAdXml().webrightBar != 0) {
                              continue;
                            }
                          }
                          bool = true;
                          if (ac.mFV) {
                            bool = false;
                          }
                          localObject2 = paramAnonymousView;
                          if (localObject3 != null)
                          {
                            localObject2 = paramAnonymousView;
                            if (((SnsInfo)localObject3).isAd())
                            {
                              localObject6 = c.a(c.this, (SnsInfo)localObject3);
                              localObject2 = paramAnonymousView;
                              if (localObject6 != null)
                              {
                                ((Intent)localObject5).putExtra("KsnsViewId", ((ADInfo)localObject6).viewId);
                                localObject2 = com.tencent.mm.plugin.sns.ad.c.a.a.aYo(com.tencent.mm.plugin.sns.data.t.kw(paramAnonymousView, ((ADInfo)localObject6).uxInfo));
                                com.tencent.mm.plugin.sns.data.t.g((Intent)localObject5, ((ADInfo)localObject6).uxInfo);
                              }
                            }
                          }
                          ((Intent)localObject5).putExtra("KRightBtn", bool);
                          paramAnonymousView = new Bundle();
                          paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                          paramAnonymousView.putString("key_snsad_statextstr", ((SnsInfo)localObject3).getTimeLine().statExtStr);
                          ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
                          ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                          ((Intent)localObject5).putExtra("useJs", true);
                          ((Intent)localObject5).putExtra("srcUsername", ((SnsInfo)localObject3).field_userName);
                          ((Intent)localObject5).putExtra("stastic_scene", 15);
                          ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject3).field_snsId));
                          ((Intent)localObject5).putExtra("pre_username", ((SnsInfo)localObject3).field_userName);
                          ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject3).field_snsId));
                          ((Intent)localObject5).putExtra("preUsername", ((SnsInfo)localObject3).field_userName);
                          com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject5, c.this.activity);
                          continue;
                          bool = false;
                          continue;
                          if (((((TimeLineObject)localObject6).ContentObj.Sqq != 1) || (((TimeLineObject)localObject6).ContentObj.Sqr.size() != 1)) && (((TimeLineObject)localObject6).ContentObj.Sqq != 7) && ((((TimeLineObject)localObject6).ContentObj.Sqq != 27) || (((TimeLineObject)localObject6).ContentObj.Sqr.size() <= k) || (((cvt)((TimeLineObject)localObject6).ContentObj.Sqr.get(k)).rWu != 2))) {
                            continue;
                          }
                          localObject2 = c.a(c.this, (SnsInfo)localObject3);
                          if (com.tencent.mm.plugin.sns.data.m.a(c.this.activity, (SnsInfo)localObject3, (ADInfo)localObject2, c.this.source, c.this.KPn))
                          {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(267366);
                            return;
                          }
                          if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
                          {
                            localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.a.a))
                            {
                              localObject2 = ((com.tencent.mm.plugin.sns.ui.item.a.a)paramAnonymousView.getTag()).JKs;
                              if (!((SnsInfo)localObject3).getAdXml().isLandingPagesAd()) {
                                continue;
                              }
                              localObject5 = ((SnsInfo)localObject3).getAdSnsInfo().field_adxml;
                              if (k > 0)
                              {
                                localObject4 = "adTurnCanvasInfo";
                                if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.lc((String)localObject5, (String)localObject4)) {
                                  continue;
                                }
                                m = c.this.source;
                                if (c.this.source != 0) {
                                  continue;
                                }
                                j = 1;
                                localObject4 = new SnsAdClick(m, j, ((SnsInfo)localObject3).field_snsId, 21, i, (byte)0);
                                com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject4, c.this.KPn, (SnsInfo)localObject3, 22);
                                com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject4);
                                if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                                  continue;
                                }
                                c.this.a((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag(), null);
                                paramAnonymousView = new int[2];
                                ((View)localObject2).getLocationInWindow(paramAnonymousView);
                                i = ((View)localObject2).getWidth();
                                j = ((View)localObject2).getHeight();
                                localObject2 = new Intent();
                                ((Intent)localObject2).putExtra("img_gallery_left", paramAnonymousView[0]);
                                ((Intent)localObject2).putExtra("img_gallery_top", paramAnonymousView[1]);
                                ((Intent)localObject2).putExtra("img_gallery_width", i);
                                ((Intent)localObject2).putExtra("img_gallery_height", j);
                                ((Intent)localObject2).putExtra("sns_landing_pages_share_sns_id", ((SnsInfo)localObject3).getSnsId());
                                ((Intent)localObject2).putExtra("sns_landing_pages_rawSnsId", ((SnsInfo)localObject3).getTimeLine().Id);
                                ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", ((SnsInfo)localObject3).getUxinfo());
                                ((Intent)localObject2).putExtra("sns_landing_pages_aid", ((SnsInfo)localObject3).getAid());
                                ((Intent)localObject2).putExtra("sns_landing_pages_traceid", ((SnsInfo)localObject3).getTraceid());
                                paramAnonymousView = ((SnsInfo)localObject3).getTimeLine();
                                if (paramAnonymousView != null)
                                {
                                  paramAnonymousView = paramAnonymousView.ContentObj.Sqr;
                                  if (paramAnonymousView.size() <= k) {
                                    continue;
                                  }
                                  ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((cvt)paramAnonymousView.get(k)).TDF);
                                }
                                ((Intent)localObject2).setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                                i = 1;
                                if (c.this.source != 2) {
                                  continue;
                                }
                                i = 16;
                                ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
                                if (k <= 0) {
                                  continue;
                                }
                                paramAnonymousView = ((SnsInfo)localObject3).getAdXml().getTurnCanvasInfo();
                                ((Intent)localObject2).putExtra("sns_landing_pages_xml", paramAnonymousView);
                                ((Intent)localObject2).putExtra("sns_landing_pages_rec_src", ((SnsInfo)localObject3).getAdRecSrc());
                                ((Intent)localObject2).putExtra("sns_landing_pages_xml_prefix", "adxml");
                                ((Intent)localObject2).putExtra("sns_landing_page_start_time", System.currentTimeMillis());
                                if (!((SnsInfo)localObject3).getAdXml().forbiddenCustomAnimation) {
                                  ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                }
                                paramAnonymousView = c.this.activity;
                                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
                                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
                                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                if (!((SnsInfo)localObject3).getAdXml().forbiddenCustomAnimation) {
                                  c.this.activity.overridePendingTransition(0, 0);
                                }
                                if (c.this.KCs == null) {
                                  continue;
                                }
                                c.this.KCs.fOn().N((SnsInfo)localObject3);
                              }
                            }
                            else
                            {
                              if ((paramAnonymousView.getTag() instanceof h.a))
                              {
                                localObject2 = ((h.a)paramAnonymousView.getTag()).Lnh.JKs;
                                continue;
                              }
                              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.g.a))
                              {
                                localObject2 = ((com.tencent.mm.plugin.sns.ui.item.g.a)paramAnonymousView.getTag()).JKs;
                                continue;
                              }
                              if ((localObject2 instanceof r.b))
                              {
                                localObject2 = (TagImageView)((r.b)localObject2).LnZ.view;
                                continue;
                              }
                              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.p.a))
                              {
                                localObject2 = ((com.tencent.mm.plugin.sns.ui.item.p.a)paramAnonymousView.getTag()).LnJ;
                                continue;
                              }
                              localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject2).Lll.agW(0);
                              continue;
                            }
                          }
                          else
                          {
                            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b))
                            {
                              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
                              {
                                localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.c)paramAnonymousView.getTag()).Ljf;
                                continue;
                              }
                              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.e))
                              {
                                localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.e)paramAnonymousView.getTag()).LjM.JKs;
                                continue;
                              }
                              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.d))
                              {
                                localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.d)paramAnonymousView.getTag()).JKs;
                                continue;
                              }
                              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.i))
                              {
                                localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.i)paramAnonymousView.getTag()).contentView;
                                continue;
                              }
                              if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.g)) {
                                continue;
                              }
                              localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.g)paramAnonymousView.getTag()).contentView;
                              continue;
                            }
                            if ((paramAnonymousView.getTag() instanceof MaskImageView))
                            {
                              localObject2 = (MaskImageView)paramAnonymousView.getTag();
                              continue;
                            }
                            if (!(paramAnonymousView.getTag() instanceof TagImageView)) {
                              continue;
                            }
                            localObject2 = (TagImageView)paramAnonymousView;
                            continue;
                          }
                          localObject4 = "adCanvasInfo";
                          continue;
                          j = 2;
                          continue;
                          if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
                            continue;
                          }
                          c.this.a((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag(), null);
                          continue;
                          if (paramAnonymousView.size() <= 0) {
                            continue;
                          }
                          ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((cvt)paramAnonymousView.get(0)).TDF);
                          continue;
                          if (c.this.source != 1) {
                            continue;
                          }
                          i = 2;
                          continue;
                          paramAnonymousView = ((SnsInfo)localObject3).getAdSnsInfo().field_adxml;
                          continue;
                          localObject2 = c.this;
                          localObject4 = c.a(c.this, (SnsInfo)localObject3);
                          if (k > 0)
                          {
                            bool = true;
                            if (!c.a((c)localObject2, (ADInfo)localObject4, (SnsInfo)localObject3, bool)) {
                              continue;
                            }
                          }
                          try
                          {
                            com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.fLk().a(c.this.source, (SnsInfo)localObject3);
                            k = c.this.source;
                            if (c.this.source == 0)
                            {
                              j = 1;
                              paramAnonymousView = new SnsAdClick(k, j, ((SnsInfo)localObject3).field_snsId, 31, i, (byte)0);
                              com.tencent.mm.plugin.sns.data.m.a(paramAnonymousView, c.this.KPn, (SnsInfo)localObject3, 22);
                              com.tencent.mm.plugin.sns.data.t.a(paramAnonymousView);
                              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                              AppMethodBeat.o(267366);
                              return;
                              bool = false;
                              continue;
                            }
                            j = 2;
                            continue;
                            try
                            {
                              localObject2 = com.tencent.mm.plugin.sns.ad.timeline.a.a.e(4, c.this.activity);
                              if (localObject2 != null)
                              {
                                localObject4 = new com.tencent.mm.plugin.sns.ad.timeline.a.d("flipStatus", Integer.valueOf(i));
                                ((com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject4).put("snsAdStatistic", c.this.KPn);
                                bool = ((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject2).a(paramAnonymousView, c.this.source, (SnsInfo)localObject3, (com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject4);
                                if (bool)
                                {
                                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                  AppMethodBeat.o(267366);
                                  return;
                                }
                              }
                            }
                            catch (Throwable paramAnonymousView)
                            {
                              if (k > 0)
                              {
                                localObject2 = ((SnsInfo)localObject3).getAdXml().adTurnInfo.adActionLink;
                                paramAnonymousView = (View)localObject2;
                                if (Util.isNullOrNil((String)localObject2)) {
                                  paramAnonymousView = ((SnsInfo)localObject3).getAdLink();
                                }
                                Log.i("MicroMsg.TimelineClickListener", "photo cardAdClick, adlink url " + paramAnonymousView + " " + ((SnsInfo)localObject3).getAdXml().webrightBar);
                                if (Util.isNullOrNil(paramAnonymousView))
                                {
                                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                  AppMethodBeat.o(267366);
                                }
                              }
                              else
                              {
                                localObject2 = ((SnsInfo)localObject3).getAdInfoLink();
                                continue;
                              }
                              k = c.this.source;
                              if (c.this.source == 0)
                              {
                                j = 1;
                                localObject4 = new SnsAdClick(k, j, ((SnsInfo)localObject3).field_snsId, 0, i, (byte)0);
                                com.tencent.mm.plugin.sns.data.m.a((SnsAdClick)localObject4, c.this.KPn, (SnsInfo)localObject3, 22);
                                com.tencent.mm.plugin.sns.data.t.a((SnsAdClick)localObject4);
                                localObject5 = new Intent();
                                if (((SnsInfo)localObject3).getAdXml().webrightBar == 0)
                                {
                                  bool = true;
                                  if (ac.mFV) {
                                    bool = false;
                                  }
                                  localObject2 = paramAnonymousView;
                                  if (localObject3 != null)
                                  {
                                    localObject2 = paramAnonymousView;
                                    if (((SnsInfo)localObject3).isAd())
                                    {
                                      localObject6 = c.a(c.this, (SnsInfo)localObject3);
                                      localObject2 = paramAnonymousView;
                                      if (localObject6 != null)
                                      {
                                        ((Intent)localObject5).putExtra("KsnsViewId", ((ADInfo)localObject6).viewId);
                                        localObject2 = com.tencent.mm.plugin.sns.ad.c.a.a.aYo(com.tencent.mm.plugin.sns.data.t.kw(paramAnonymousView, ((ADInfo)localObject6).uxInfo));
                                        com.tencent.mm.plugin.sns.data.t.g((Intent)localObject5, ((ADInfo)localObject6).uxInfo);
                                      }
                                    }
                                  }
                                  ((Intent)localObject5).putExtra("KRightBtn", bool);
                                  paramAnonymousView = new Bundle();
                                  paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                                  paramAnonymousView.putString("key_snsad_statextstr", ((SnsInfo)localObject3).getTimeLine().statExtStr);
                                  ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
                                  ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                                  ((Intent)localObject5).putExtra("useJs", true);
                                  ((Intent)localObject5).putExtra("srcUsername", ((SnsInfo)localObject3).field_userName);
                                  ((Intent)localObject5).putExtra("stastic_scene", 15);
                                  ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject3).field_snsId));
                                  ((Intent)localObject5).putExtra("pre_username", ((SnsInfo)localObject3).field_userName);
                                  ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject3).field_snsId));
                                  ((Intent)localObject5).putExtra("preUsername", ((SnsInfo)localObject3).field_userName);
                                  com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject5, c.this.activity);
                                }
                              }
                              else
                              {
                                j = 2;
                                continue;
                              }
                              bool = false;
                              continue;
                            }
                          }
                          catch (Throwable paramAnonymousView)
                          {
                            continue;
                          }
                        }
                        catch (Throwable paramAnonymousView)
                        {
                          continue;
                          localObject2 = null;
                          continue;
                        }
                        i = 0;
                        j = 0;
                        continue;
                        j = 0;
                        continue;
                        localObject4 = null;
                        continue;
                        localObject2 = null;
                        continue;
                      }
                      localObject1 = ((SnsInfo)localObject3).getAdXml();
                      if ((((SnsInfo)localObject3).isAd()) && (localObject1 != null) && (!((ADXml)localObject1).isFullCardAd())) {
                        com.tencent.mm.plugin.sns.ad.d.a.O(c.this.activity, ((ADXml)localObject1).appGiftPackCode, ((ADXml)localObject1).appGiftPackCodeTips);
                      }
                      if (((SnsInfo)localObject3).getAdSnsInfo().getAdXml().hasVoteInfo())
                      {
                        localObject1 = ((SnsInfo)localObject3).getAdSnsInfo().getAdXml().getAdVoteComponentUrl();
                        localObject4 = ((SnsInfo)localObject3).getUxinfo();
                        com.tencent.mm.kernel.h.aHE();
                        localObject5 = com.tencent.mm.kernel.b.aGq();
                        com.tencent.mm.plugin.sns.storage.y.b((String)localObject1, (String)localObject4, (String)localObject5, com.tencent.mm.plugin.sns.storage.y.aM((String)localObject1, (String)localObject4, (String)localObject5), 0, "");
                      }
                      localObject6 = ((SnsInfo)localObject3).getTimeLine();
                      if (((((TimeLineObject)localObject6).ContentObj.Sqq != 15) || (((TimeLineObject)localObject6).sightFolded == 1)) && ((((TimeLineObject)localObject6).ContentObj.Sqq != 27) || (((TimeLineObject)localObject6).ContentObj.Sqr.size() <= k) || (((cvt)((TimeLineObject)localObject6).ContentObj.Sqr.get(k)).rWu != 6))) {
                        continue;
                      }
                      Log.i("MicroMsg.TimelineClickListener", "onsight click");
                      if (!(paramAnonymousView.getTag() instanceof av)) {
                        continue;
                      }
                      localObject1 = (av)paramAnonymousView.getTag();
                      if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                        continue;
                      }
                      localObject4 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                      if (((TimeLineObject)localObject6).ContentObj.Sqq != 27) {
                        continue;
                      }
                      localObject1 = ((r.b)localObject4).Loa;
                      if (localObject3 != null) {
                        continue;
                      }
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(267366);
                      return;
                      localObject1 = ((ADInfo)localObject1).viewId;
                      continue;
                      m = 2;
                      continue;
                      j = 2;
                    }
                  }
                }
                else
                {
                  Object localObject2 = null;
                  j = n;
                  continue;
                  label5290:
                  i = 0;
                }
              }
              label5295:
              i = 0;
              k = m;
            }
            label5304:
            i = 0;
          }
          label5309:
          j = 0;
        }
      }
    };
    this.Lpl = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(243543);
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)) && (com.tencent.mm.by.c.blP("favorite"))) {
          paramAnonymousContextMenu.add(0, 25, 0, c.this.activity.getString(i.j.plugin_favorite_opt));
        }
        AppMethodBeat.o(243543);
      }
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(243542);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          TimeLineObject localTimeLineObject = (TimeLineObject)paramAnonymousView.getTag();
          Object localObject = aj.fOI();
          String str = localTimeLineObject.Id;
          SnsInfo localSnsInfo = new SnsInfo();
          if (!((com.tencent.mm.plugin.sns.storage.n)localObject).Kzz)
          {
            localObject = ((com.tencent.mm.plugin.sns.storage.n)localObject).lvy.query("SnsInfo", null, "stringSeq=?", new String[] { String.valueOf(str) }, null, null, null, 2);
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
              c.this.LoP.a(paramAnonymousView, (String)localObject, localTimeLineObject);
            }
            AppMethodBeat.o(243542);
            return true;
            localObject = ((com.tencent.mm.plugin.sns.storage.n)localObject).lvy.query("SnsInfo", null, "snsId=?", new String[] { com.tencent.mm.plugin.sns.storage.n.bby(new StringBuilder().append(str).toString()) }, null, null, null, 2);
            break;
            label196:
            ((Cursor)localObject).close();
          }
        }
        AppMethodBeat.o(243542);
        return false;
      }
    };
    this.Lpj = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(263968);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        Object localObject;
        if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          paramAnonymousContextMenuInfo = (com.tencent.mm.plugin.sns.ui.s)paramAnonymousContextMenuInfo;
          localObject = paramAnonymousContextMenuInfo.KCX;
          if (com.tencent.mm.by.c.blP("favorite")) {
            switch (((TimeLineObject)localObject).ContentObj.Sqq)
            {
            default: 
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, aj.fOI().bbl(paramAnonymousContextMenuInfo.fAg));
          AppMethodBeat.o(263968);
          return;
          paramAnonymousContextMenu.add(0, 4, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
          localObject = new em();
          ((em)localObject).fAp.fAg = paramAnonymousContextMenuInfo.fAg;
          EventCenter.instance.publish((IEvent)localObject);
          if (((em)localObject).fAq.fzO)
          {
            paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(i.j.app_open));
            continue;
            paramAnonymousContextMenu.add(0, 28, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
            localObject = new em();
            ((em)localObject).fAp.fAg = paramAnonymousContextMenuInfo.fAg;
            EventCenter.instance.publish((IEvent)localObject);
            if (((em)localObject).fAq.fzO)
            {
              paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(i.j.app_open));
              continue;
              paramAnonymousContextMenu.add(0, 5, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
              continue;
              paramAnonymousContextMenu.add(0, 9, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
              continue;
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
              localObject = new em();
              ((em)localObject).fAp.fAg = paramAnonymousContextMenuInfo.fAg;
              EventCenter.instance.publish((IEvent)localObject);
              if (((em)localObject).fAq.fzO)
              {
                paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(i.j.app_open));
                continue;
                paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
                continue;
                paramAnonymousContextMenu.add(0, 22, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
                continue;
                paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
                continue;
                paramAnonymousContextMenu.add(0, 23, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
                continue;
                paramAnonymousContextMenu.add(0, 24, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
              }
            }
          }
        }
      }
      
      public final boolean gK(View paramAnonymousView)
      {
        AppMethodBeat.i(263964);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          localObject = (com.tencent.mm.plugin.sns.ui.s)localObject;
          TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ui.s)localObject).KCX;
          if ((localTimeLineObject.ContentObj.Sqq == 10) || (localTimeLineObject.ContentObj.Sqq == 17) || (localTimeLineObject.ContentObj.Sqq == 22) || (localTimeLineObject.ContentObj.Sqq == 23))
          {
            AppMethodBeat.o(263964);
            return false;
          }
          c.this.LoP.a(paramAnonymousView, ((com.tencent.mm.plugin.sns.ui.s)localObject).fAg, localTimeLineObject);
          AppMethodBeat.o(263964);
          return true;
        }
        AppMethodBeat.o(263964);
        return false;
      }
    };
    this.Loc = new b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(202945);
        if ((paramAnonymousb != null) && (paramAnonymousInt == 0)) {
          if (paramAnonymousb.Jsf == null) {
            break label88;
          }
        }
        label88:
        for (paramAnonymousb = (View)paramAnonymousb.Jsf.get();; paramAnonymousb = null)
        {
          if ((paramAnonymousb != null) && ((paramAnonymousb instanceof com.tencent.mm.plugin.sight.decode.a.a)))
          {
            paramAnonymousb = (com.tencent.mm.plugin.sight.decode.a.a)paramAnonymousb;
            paramAnonymousb.getVideoPath();
            if ((paramAnonymousb.getTagObject() != null) && ((paramAnonymousb.getTagObject() instanceof av))) {
              paramAnonymousb.getTagObject();
            }
          }
          AppMethodBeat.o(202945);
          return;
        }
      }
    };
    this.Lpt = new c.36(this);
    this.Lpu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163134);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        c.this.fTv();
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.i)))
        {
          paramAnonymousView = aj.fOI().bbl(((com.tencent.mm.plugin.sns.data.i)paramAnonymousView.getTag()).fAg);
          if (paramAnonymousView != null)
          {
            localObject = com.tencent.mm.plugin.sns.k.g.Kia;
            com.tencent.mm.plugin.sns.k.g.baO(paramAnonymousView.getUserName());
            paramAnonymousView = new com.tencent.mm.plugin.sns.model.s(paramAnonymousView.field_snsId, 9);
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousView, 0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163134);
      }
    };
    this.Lpv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264309);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject1 = paramAnonymousView.JVu;
          if ((localObject1 != null) && (!Util.isNullOrNil(((ejo)localObject1).Uls)) && (((ejo)localObject1).Uls.get(0) != null))
          {
            Object localObject2 = ((eju)((ejo)localObject1).Uls.get(0)).Md5;
            EmojiInfo localEmojiInfo = bj.hyV().VFH.bxK((String)localObject2);
            Intent localIntent = new Intent();
            localIntent.putExtra("custom_smiley_preview_md5", (String)localObject2);
            if ((localEmojiInfo.field_catalog != EmojiGroupInfo.YCw) && (localEmojiInfo.field_catalog != EmojiGroupInfo.YCv) && (localEmojiInfo.field_catalog != EmojiGroupInfo.YCu)) {
              localIntent.putExtra("custom_smiley_preview_productid", localEmojiInfo.field_groupId);
            }
            com.tencent.mm.by.c.b(c.this.activity, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
            localObject2 = com.tencent.mm.plugin.sns.k.g.Kia;
            long l = com.tencent.mm.plugin.sns.storage.y.aYS(paramAnonymousView.KCE);
            paramAnonymousView = String.valueOf(((ejo)localObject1).Uln);
            localObject1 = com.tencent.mm.plugin.sns.data.t.Qu(l);
            localObject1 = (com.tencent.mm.plugin.sns.k.g.a)((com.tencent.mm.plugin.sns.k.g)localObject2).Kin.get(localObject1);
            if ((localObject1 != null) && (!((com.tencent.mm.plugin.sns.k.g.a)localObject1).KiZ.contains(paramAnonymousView))) {
              ((com.tencent.mm.plugin.sns.k.g.a)localObject1).KiZ.add(paramAnonymousView);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(264309);
      }
    };
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
        String str = com.tencent.mm.plugin.sns.data.t.Qu(paramSnsInfo.field_snsId) + ":" + localADInfo.uxInfo + ":" + aj.fOo() + ":" + System.currentTimeMillis();
        if (paramInt == 0) {}
        for (paramInt = 1045;; paramInt = 1046)
        {
          com.tencent.mm.plugin.sns.data.t.a(paramString1, paramString2, paramString3, paramSnsInfo.getAid(), paramSnsInfo.getTraceid(), str, localADInfo.uxInfo, paramInt);
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
  
  public final void a(com.tencent.mm.plugin.sns.ui.c.a.b paramb, Bundle paramBundle)
  {
    if (this.LoN != null)
    {
      Log.w("MicroMsg.TimelineClickListener", "has already prepare detail click animation");
      return;
    }
    if ((paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
    {
      this.LoN = new com.tencent.mm.plugin.sns.ui.b.a.d(paramb);
      this.LoO = new com.tencent.mm.plugin.sns.ui.b.a.c((MMActivity)this.activity, paramb);
      return;
    }
    boolean bool4;
    boolean bool3;
    boolean bool2;
    boolean bool1;
    if (((paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.e)) || ((paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.d)))
    {
      if (paramBundle == null) {
        break label411;
      }
      bool4 = paramBundle.getBoolean("isFromTwist", false);
      bool3 = paramBundle.getBoolean("isSimpleTwistAnim", false);
      bool2 = paramBundle.getBoolean("isTwistClockwise", false);
      bool1 = paramBundle.getBoolean("isFromShake", false);
    }
    for (;;)
    {
      if ((paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.e))
      {
        if (bool4) {
          if (bool3) {
            this.LoN = new com.tencent.mm.plugin.sns.ui.b.a.j((MMActivity)this.activity, paramb, bool2);
          }
        }
        for (;;)
        {
          this.LoO = new com.tencent.mm.plugin.sns.ui.b.a.f((MMActivity)this.activity, paramb);
          return;
          if (!bool1) {
            this.LoN = new com.tencent.mm.plugin.sns.ui.b.a.h((MMActivity)this.activity, paramb);
          }
        }
      }
      if (bool4) {
        if (bool3) {
          this.LoN = new com.tencent.mm.plugin.sns.ui.b.a.i((MMActivity)this.activity, paramb, bool2);
        }
      }
      for (;;)
      {
        this.LoO = new com.tencent.mm.plugin.sns.ui.b.a.e((MMActivity)this.activity, paramb);
        return;
        if (!bool1) {
          this.LoN = new com.tencent.mm.plugin.sns.ui.b.a.g((MMActivity)this.activity, paramb);
        }
      }
      if ((paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.i))
      {
        this.LoN = new com.tencent.mm.plugin.sns.ui.b.a.p((MMActivity)this.activity, paramb);
        this.LoO = new com.tencent.mm.plugin.sns.ui.b.a.o((MMActivity)this.activity, paramb);
        return;
      }
      if ((paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.g))
      {
        this.LoN = new com.tencent.mm.plugin.sns.ui.b.a.n((MMActivity)this.activity, paramb);
        this.LoO = new com.tencent.mm.plugin.sns.ui.b.a.m((MMActivity)this.activity, paramb);
        return;
      }
      if (!(paramb instanceof com.tencent.mm.plugin.sns.ui.c.a.f)) {
        break;
      }
      this.LoN = new com.tencent.mm.plugin.sns.ui.b.a.l((MMActivity)this.activity, paramb);
      this.LoO = new com.tencent.mm.plugin.sns.ui.b.a.k((MMActivity)this.activity, paramb);
      return;
      label411:
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, Bundle paramBundle)
  {
    if (this.LoL != null)
    {
      Log.w("MicroMsg.TimelineClickListener", "has already prepare click animation");
      return;
    }
    if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.a.a))
    {
      this.LoL = new com.tencent.mm.plugin.sns.ui.b.b.d((MMActivity)this.activity, paramBaseViewHolder);
      this.LoM = new com.tencent.mm.plugin.sns.ui.b.b.c((MMActivity)this.activity, paramBaseViewHolder);
      ((com.tencent.mm.plugin.sns.ui.item.a.a)paramBaseViewHolder).JKq = true;
      return;
    }
    boolean bool4;
    boolean bool3;
    boolean bool2;
    boolean bool1;
    if (((paramBaseViewHolder instanceof h.a)) || ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.g.a)))
    {
      if (paramBundle == null) {
        break label448;
      }
      bool4 = paramBundle.getBoolean("isFromTwist", false);
      bool3 = paramBundle.getBoolean("isSimpleTwistAnim", false);
      bool2 = paramBundle.getBoolean("isTwistClockwise", false);
      bool1 = paramBundle.getBoolean("isFromShake", false);
    }
    for (;;)
    {
      if ((paramBaseViewHolder instanceof h.a))
      {
        if (bool4) {
          if (bool3) {
            this.LoL = new com.tencent.mm.plugin.sns.ui.b.b.j((MMActivity)this.activity, paramBaseViewHolder, bool2);
          }
        }
        for (;;)
        {
          this.LoM = new com.tencent.mm.plugin.sns.ui.b.b.f((MMActivity)this.activity, paramBaseViewHolder);
          ((h.a)paramBaseViewHolder).Lnh.JKO.JKq = true;
          return;
          if (!bool1) {
            this.LoL = new com.tencent.mm.plugin.sns.ui.b.b.h((MMActivity)this.activity, paramBaseViewHolder);
          }
        }
      }
      if (bool4) {
        if (bool3) {
          this.LoL = new com.tencent.mm.plugin.sns.ui.b.b.i((MMActivity)this.activity, paramBaseViewHolder, bool2);
        }
      }
      for (;;)
      {
        this.LoM = new com.tencent.mm.plugin.sns.ui.b.b.e((MMActivity)this.activity, paramBaseViewHolder);
        ((com.tencent.mm.plugin.sns.ui.item.g.a)paramBaseViewHolder).JKq = true;
        return;
        if (!bool1) {
          this.LoL = new com.tencent.mm.plugin.sns.ui.b.b.g((MMActivity)this.activity, paramBaseViewHolder);
        }
      }
      if ((paramBaseViewHolder instanceof r.b))
      {
        this.LoL = new com.tencent.mm.plugin.sns.ui.b.b.p((MMActivity)this.activity, paramBaseViewHolder);
        this.LoM = new com.tencent.mm.plugin.sns.ui.b.b.o((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
      if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.p.a))
      {
        this.LoL = new com.tencent.mm.plugin.sns.ui.b.b.n((MMActivity)this.activity, paramBaseViewHolder);
        this.LoM = new com.tencent.mm.plugin.sns.ui.b.b.m((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
      if (!(paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ad.timeline.c.a.a.a)) {
        break;
      }
      this.LoL = new com.tencent.mm.plugin.sns.ui.b.b.l((MMActivity)this.activity, paramBaseViewHolder);
      this.LoM = new com.tencent.mm.plugin.sns.ui.b.b.k((MMActivity)this.activity, paramBaseViewHolder);
      return;
      label448:
      bool1 = false;
      bool2 = false;
      bool3 = false;
      bool4 = false;
    }
  }
  
  public final void c(com.tencent.mm.plugin.sns.ad.f.l paraml)
  {
    this.KPn = paraml;
    if (this.LoP != null) {
      this.LoP.c(paraml);
    }
  }
  
  public abstract void dV(Object paramObject);
  
  public final void eKx()
  {
    this.LoP.eKx();
    EventCenter.instance.addListener(this.LpE);
    EventCenter.instance.addListener(this.LpF);
  }
  
  public abstract void fTs();
  
  public abstract void fTt();
  
  public abstract void fTu();
  
  public abstract void fTv();
  
  public abstract void gA(View paramView);
  
  public abstract void gB(View paramView);
  
  public abstract void gv(View paramView);
  
  public abstract void gw(View paramView);
  
  public abstract void gx(View paramView);
  
  public abstract void gy(View paramView);
  
  public abstract void gz(View paramView);
  
  public final void removeListener()
  {
    this.LoP.removeListener();
    EventCenter.instance.removeListener(this.LpE);
    EventCenter.instance.removeListener(this.LpF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c
 * JD-Core Version:    0.7.0.1
 */