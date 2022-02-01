package com.tencent.mm.plugin.sns.ui.d;

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
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xw;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.i.a.y.a;
import com.tencent.mm.plugin.i.a.y.b;
import com.tencent.mm.plugin.i.a.y.c;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.ad.g.o.a;
import com.tencent.mm.plugin.sns.ad.g.o.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.au.b;
import com.tencent.mm.plugin.sns.model.ay;
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
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bk.b;
import com.tencent.mm.plugin.sns.ui.bq;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.n.a;
import com.tencent.mm.plugin.sns.ui.item.p.a;
import com.tencent.mm.plugin.sns.ui.item.p.b;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.protocal.protobuf.ear;
import com.tencent.mm.protocal.protobuf.fa;
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
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class c
{
  protected com.tencent.mm.plugin.sns.ad.g.k EBv;
  public b.e EZJ;
  com.tencent.mm.plugin.sns.model.ai Epj;
  public View.OnClickListener Erh;
  public View.OnClickListener FaA;
  public View.OnClickListener FaB;
  public View.OnClickListener FaC;
  public View.OnClickListener FaD;
  public d FaE;
  public d FaF;
  public d FaG;
  public d FaH;
  public d FaI;
  public d FaJ;
  public d FaK;
  d FaL;
  public d FaM;
  public d FaN;
  public View.OnClickListener FaO;
  public View.OnClickListener FaP;
  public View.OnClickListener FaQ;
  public View.OnClickListener FaR;
  public View.OnClickListener FaS;
  public View.OnClickListener FaT;
  public View.OnClickListener FaU;
  public View.OnClickListener FaV;
  public View.OnClickListener FaW;
  public View.OnClickListener FaX;
  public View.OnClickListener FaY;
  public AdapterView.OnItemClickListener FaZ;
  volatile com.tencent.mm.plugin.sns.ui.b.b.b Fan;
  volatile com.tencent.mm.plugin.sns.ui.b.b.a Fao;
  volatile com.tencent.mm.plugin.sns.ui.b.a.b Fap;
  volatile com.tencent.mm.plugin.sns.ui.b.a.a Faq;
  public b Far;
  public View.OnClickListener Fas;
  public View.OnLongClickListener Fat;
  public d Fau;
  public View.OnClickListener Fav;
  public View.OnClickListener Faw;
  public View.OnClickListener Fax;
  public View.OnClickListener Fay;
  public View.OnClickListener Faz;
  public AdapterView.OnItemClickListener Fba;
  public View.OnClickListener Fbb = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100199);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      if (paramAnonymousView.getTag() == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100199);
        return;
      }
      localObject1 = c.fC(paramAnonymousView);
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
        j = com.tencent.mm.plugin.sns.storage.y.kN(((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl(), ((SnsInfo)localObject1).getUxinfo());
        if (j > 0)
        {
          i = 1;
          localObject2 = ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl();
          String str1 = ((SnsInfo)localObject1).getUxinfo();
          com.tencent.mm.kernel.g.aAf();
          String str2 = com.tencent.mm.kernel.a.ayV();
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
        if ((((TimeLineObject)localObject2).ContentObj.LoU == 15) && (((TimeLineObject)localObject2).sightFolded != 1)) {
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
          if (((((TimeLineObject)localObject2).ContentObj.LoU == 1) && (((TimeLineObject)localObject2).ContentObj.LoV.size() == 1)) || (((TimeLineObject)localObject2).ContentObj.LoU == 7)) {
            c.b(c.this, paramAnonymousView, (SnsInfo)localObject1, 1001, ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getLeftCanvasInfo(), bool);
          }
        }
      }
    }
  };
  public View.OnClickListener Fbc = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100219);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      if (paramAnonymousView.getTag() == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100219);
        return;
      }
      localObject1 = c.fC(paramAnonymousView);
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
        j = com.tencent.mm.plugin.sns.storage.y.kN(((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl(), ((SnsInfo)localObject1).getUxinfo());
        if (j > 0)
        {
          i = 1;
          localObject2 = ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getAdVoteComponentUrl();
          String str1 = ((SnsInfo)localObject1).getUxinfo();
          com.tencent.mm.kernel.g.aAf();
          String str2 = com.tencent.mm.kernel.a.ayV();
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
        if ((((TimeLineObject)localObject2).ContentObj.LoU == 15) && (((TimeLineObject)localObject2).sightFolded != 1)) {
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
          if (((((TimeLineObject)localObject2).ContentObj.LoU == 1) && (((TimeLineObject)localObject2).ContentObj.LoV.size() == 1)) || (((TimeLineObject)localObject2).ContentObj.LoU == 7)) {
            c.b(c.this, paramAnonymousView, (SnsInfo)localObject1, 1002, ((SnsInfo)localObject1).getAdSnsInfo().getAdXml().getRightCanvasInfo(), bool);
          }
        }
      }
    }
  };
  public View.OnClickListener Fbd;
  public bk.b Fbe;
  int Fbf;
  private IListener<xw> Fbg = new IListener() {};
  private IListener<xv> Fbh = new IListener() {};
  public View.OnClickListener Fbi = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(203975);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      localObject1 = paramAnonymousView.getTag();
      Object localObject3 = null;
      Object localObject2;
      if ((localObject1 instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        localObject1 = com.tencent.mm.plugin.sns.storage.f.aQl(((BaseTimeLineItem.BaseViewHolder)localObject2).dRS);
        localObject3 = ((BaseTimeLineItem.BaseViewHolder)localObject2).EWG;
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
          int k = ((AdSnsInfo)localObject4).getSource();
          if ((localObject1 != null) && (((SnsInfo)localObject1).isAd()))
          {
            localObject5 = c.a(c.this, (SnsInfo)localObject1);
            if ((((SnsInfo)localObject1).getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(((SnsInfo)localObject1).getAdSnsInfo().field_adxml)))
            {
              localObject5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Q((SnsInfo)localObject1);
              if (!Util.isNullOrNil((String)localObject5)) {
                ((AdSnsInfo)localObject4).field_adxml = ((String)localObject5);
              }
              localObject4 = new int[2];
              paramAnonymousView.getLocationInWindow((int[])localObject4);
              i = paramAnonymousView.getWidth();
              int j = paramAnonymousView.getHeight();
              if (localObject3 != null)
              {
                ((TagImageView)localObject3).getLocationInWindow((int[])localObject4);
                i = ((TagImageView)localObject3).getWidth();
                j = ((TagImageView)localObject3).getHeight();
                label218:
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
                  localObject2 = ((TimeLineObject)localObject2).ContentObj.LoV;
                  if (((List)localObject2).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((cnb)((List)localObject2).get(0)).Msz);
                  }
                }
                paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (k != 2) {
                  break label630;
                }
                i = 16;
                label382:
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", ((SnsInfo)localObject1).getAdSnsInfo().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", ((SnsInfo)localObject1).getAdRecSrc());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject2 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramAnonymousView.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject2).startActivity((Intent)paramAnonymousView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.this.activity.overridePendingTransition(0, 0);
                if (k != 0) {
                  break label642;
                }
              }
              label642:
              for (i = 1;; i = 2)
              {
                r.a(new SnsAdClick(k, i, ((SnsInfo)localObject1).field_snsId, 23, 21));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203975);
                return;
                if (!(localObject1 instanceof SnsInfo)) {
                  break label1291;
                }
                localObject1 = (SnsInfo)localObject1;
                localObject2 = (MMImageView)paramAnonymousView.getTag(2131303213);
                break;
                if (localObject2 == null) {
                  break label218;
                }
                ((MMImageView)localObject2).getLocationInWindow((int[])localObject4);
                i = ((MMImageView)localObject2).getWidth();
                j = ((MMImageView)localObject2).getHeight();
                break label218;
                label630:
                if (k != 1) {
                  break label382;
                }
                i = 10;
                break label382;
              }
            }
            if ((localObject5 != null) && (((ADInfo)localObject5).adActionType == 1))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_id", ((ADInfo)localObject5).adActionCardTpId);
              paramAnonymousView.putExtra("key_card_ext", ((ADInfo)localObject5).adActionCardExt);
              paramAnonymousView.putExtra("key_from_scene", 21);
              paramAnonymousView.putExtra("key_stastic_scene", 15);
              com.tencent.mm.br.c.b(c.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
              if (k == 0) {}
              for (i = 1;; i = 2)
              {
                r.a(new SnsAdClick(k, i, ((SnsInfo)localObject1).field_snsId, 23, 11));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203975);
                return;
              }
            }
            if (c.a(c.this, (ADInfo)localObject5, (SnsInfo)localObject1, false))
            {
              if (k == 0) {}
              for (i = 1;; i = 2)
              {
                r.a(new SnsAdClick(k, i, ((SnsInfo)localObject1).field_snsId, 23, 31));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203975);
                return;
              }
            }
          }
          if (k != 0) {
            break label1280;
          }
          i = 1;
          localObject3 = new SnsAdClick(k, i, ((SnsInfo)localObject1).field_snsId, 23, 0);
          r.a((SnsAdClick)localObject3);
          localObject2 = ((SnsInfo)localObject1).getAdInfoLink();
          paramAnonymousView = (View)localObject2;
          if (Util.isNullOrNil((String)localObject2)) {
            paramAnonymousView = ((SnsInfo)localObject1).getAdLink();
          }
          Log.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((SnsInfo)localObject1).getAdXml().webrightBar);
          localObject5 = new Intent();
          if (((SnsInfo)localObject1).getAdXml().webrightBar != 0) {
            break label1285;
          }
        }
        label1280:
        label1285:
        for (boolean bool = true;; bool = false)
        {
          if (ac.jOL) {
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
                localObject2 = r.kb(paramAnonymousView, localADInfo.uxInfo);
                r.h((Intent)localObject5, localADInfo.uxInfo);
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
          ((Intent)localObject5).putExtra("KPublisherId", "sns_" + r.Jb(((SnsInfo)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("pre_username", ((SnsInfo)localObject1).field_userName);
          ((Intent)localObject5).putExtra("prePublishId", "sns_" + r.Jb(((SnsInfo)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("preUsername", ((SnsInfo)localObject1).field_userName);
          com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject5, c.this.activity);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203975);
          return;
          i = 2;
          break;
        }
        label1291:
        localObject2 = null;
        localObject1 = null;
      }
    }
  };
  Activity activity;
  int source = 0;
  public View.OnTouchListener uwC;
  
  public c(int paramInt, Activity paramActivity, com.tencent.mm.plugin.sns.model.ai paramai)
  {
    this.source = paramInt;
    this.activity = paramActivity;
    this.Epj = paramai;
    this.Fbf = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
    Log.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[] { Integer.valueOf(this.Fbf) });
    this.Far = new b(this.activity, this.source, this.Epj);
    this.FaC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100258);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Long)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100258);
          return;
        }
        long l = ((Long)paramAnonymousView.getTag()).longValue();
        AdSnsInfo localAdSnsInfo = aj.faR().JE(l);
        SnsInfo localSnsInfo = localAdSnsInfo.convertToSnsInfo();
        o.a(o.b.DwB, o.a.Dwz, localAdSnsInfo.convertToSnsInfo(), c.this.source);
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
          localObject2 = com.tencent.mm.model.c.d.aXv().biB("Sns_CanvasAd_DetailLink_JumpWay");
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
            com.tencent.mm.br.c.b(c.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
            j = c.this.source;
            if (c.this.source == 0) {}
            for (i = 1;; i = 2)
            {
              paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 11);
              com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.EBv, localSnsInfo, 3);
              r.a(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100258);
              return;
            }
          }
          if ((localObject1 != null) && (i == 1))
          {
            if ((localSnsInfo.getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(localSnsInfo.getAdSnsInfo().field_adxml)))
            {
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Q(localSnsInfo);
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
                localObject1 = ((TimeLineObject)localObject1).ContentObj.LoV;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((cnb)((List)localObject1).get(0)).Msz);
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
                localObject1 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                j = c.this.source;
                if (c.this.source != 0) {
                  break label816;
                }
              }
              label816:
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 21);
                com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.EBv, localSnsInfo, 3);
                r.a(paramAnonymousView);
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
            if ((!localSnsInfo.getAdXml().isLandingPagesAd()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(localSnsInfo.getAdSnsInfo().field_adxml))) {
              break label1983;
            }
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Q(localSnsInfo);
            if (!Util.isNullOrNil((String)localObject1)) {
              localAdSnsInfo.field_adxml = ((String)localObject1);
            }
            localObject1 = XmlParser.parseXml(localSnsInfo.getAdSnsInfo().field_adxml, "adxml", null);
            if (localObject1 != null)
            {
              localObject1 = Util.nullAs((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareWebUrl"), "");
              if (Util.isNullOrNil((String)localObject1)) {
                break label1983;
              }
              paramAnonymousView = (View)localObject1;
            }
          }
        }
        label951:
        label1977:
        label1983:
        for (;;)
        {
          j = c.this.source;
          Intent localIntent;
          if (c.this.source == 0)
          {
            i = 1;
            localObject2 = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 0);
            com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, c.this.EBv, localSnsInfo, 3);
            r.a((SnsAdClick)localObject2);
            Log.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + localSnsInfo.getAdXml().webrightBar);
            localIntent = new Intent();
            if (localSnsInfo.getAdXml().webrightBar != 0) {
              break label1977;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            if (ac.jOL) {
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
                  localObject1 = com.tencent.mm.plugin.sns.ad.d.a.a.aND(r.kb(paramAnonymousView, localADInfo.uxInfo));
                  r.h(localIntent, localADInfo.uxInfo);
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
            localIntent.putExtra("KPublisherId", "sns_" + r.Jb(localSnsInfo.field_snsId));
            localIntent.putExtra("pre_username", localSnsInfo.field_userName);
            localIntent.putExtra("prePublishId", "sns_" + r.Jb(localSnsInfo.field_snsId));
            localIntent.putExtra("preUsername", localSnsInfo.field_userName);
            com.tencent.mm.plugin.sns.c.a.jRt.i(localIntent, c.this.activity);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100258);
            return;
            Log.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + localSnsInfo.getAdSnsInfo().field_adxml);
            break;
            if ((localObject1 != null) && (i == -1) && (((ADInfo)localObject1).adActionType == 3))
            {
              if ((!localSnsInfo.getAdXml().isLandingPagesAd()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(localSnsInfo.getAdSnsInfo().field_adxml))) {
                break label1983;
              }
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Q(localSnsInfo);
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
                localObject1 = ((TimeLineObject)localObject1).ContentObj.LoV;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((cnb)((List)localObject1).get(0)).Msz);
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
                localObject1 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                j = c.this.source;
                if (c.this.source != 0) {
                  break label1873;
                }
              }
              label1873:
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 21);
                com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.EBv, localSnsInfo, 3);
                r.a(paramAnonymousView);
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
            if (!c.a(c.this, (ADInfo)localObject1, localSnsInfo, false)) {
              break label1983;
            }
            j = c.this.source;
            if (c.this.source == 0) {}
            for (i = 1;; i = 2)
            {
              paramAnonymousView = new SnsAdClick(j, i, localSnsInfo.field_snsId, 3, 31);
              com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.EBv, localSnsInfo, 3);
              r.a(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100258);
              return;
            }
            i = 2;
            break label951;
          }
        }
      }
    };
    this.FaP = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(100259);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        localObject1 = aj.faO().aQm(paramAnonymousView);
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
          int j = c.this.source;
          if (c.this.source == 0) {}
          for (int i = 1;; i = 2)
          {
            localObject3 = new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 19, 0);
            com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject3, c.this.EBv, (SnsInfo)localObject1, 19);
            r.a((SnsAdClick)localObject3);
            if (!Util.isNullOrNil(((ADInfo)localObject2).adActionPOILink)) {
              break;
            }
            Log.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
          if (c.this.source == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.k.tO(724);; paramAnonymousView = com.tencent.mm.modelsns.k.tP(724))
          {
            paramAnonymousView.PH(r.v((SnsInfo)localObject1)).tR(((SnsInfo)localObject1).field_type).fL(((SnsInfo)localObject1).isAd()).PH(((SnsInfo)localObject1).getUxinfo()).PH("").PH("").PH("").PH("").PH(((ADInfo)localObject2).adActionPOIName).PH("").PH("");
            paramAnonymousView.bfK();
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
            paramAnonymousView.putExtra("KPublisherId", "sns_" + r.Jb(((SnsInfo)localObject1).field_snsId));
            paramAnonymousView.putExtra("pre_username", ((SnsInfo)localObject1).field_userName);
            paramAnonymousView.putExtra("prePublishId", "sns_" + r.Jb(((SnsInfo)localObject1).field_snsId));
            paramAnonymousView.putExtra("preUsername", ((SnsInfo)localObject1).field_userName);
            paramAnonymousView.putExtra("rawUrl", r.kb(((ADInfo)localObject2).adActionPOILink, ((ADInfo)localObject2).uxInfo));
            com.tencent.mm.plugin.sns.c.a.jRt.i(paramAnonymousView, c.this.activity);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
        }
        if (c.this.source == 0) {}
        for (paramAnonymousView = com.tencent.mm.modelsns.k.tO(724);; paramAnonymousView = com.tencent.mm.modelsns.k.tP(724))
        {
          paramAnonymousView.PH(r.v((SnsInfo)localObject1)).tR(((SnsInfo)localObject1).field_type).fL(((SnsInfo)localObject1).isAd()).PH(((SnsInfo)localObject1).getUxinfo()).PH(((cjy)localObject3).LIb).tR(((cjy)localObject3).Esb).PH(((cjy)localObject3).LbD).PH(((cjy)localObject3).LbC).PH(((cjy)localObject3).kHV).PH(((cjy)localObject3).ErZ).PH(((cjy)localObject3).kea);
          paramAnonymousView.bfK();
          paramAnonymousView = new Intent();
          localObject1 = new eaa();
          ((eaa)localObject1).LbC = ((cjy)localObject3).LbC;
          ((eaa)localObject1).LbD = ((cjy)localObject3).LbD;
          ((eaa)localObject1).kea = ((cjy)localObject3).kea;
          ((eaa)localObject1).kHV = ((cjy)localObject3).kHV;
          ((eaa)localObject1).ErZ = ((cjy)localObject3).ErZ;
          ((eaa)localObject1).LIb = ((cjy)localObject3).LIb;
          ((eaa)localObject1).Esb = ((cjy)localObject3).Esb;
          ((eaa)localObject1).Mpt = ((cjy)localObject3).Mpt;
          ((eaa)localObject1).Mpu = ((cjy)localObject3).Mpu;
          ((eaa)localObject1).Mpv = ((cjy)localObject3).Mpv;
          ((eaa)localObject1).Esd = ((cjy)localObject3).Esd;
          ((com.tencent.mm.plugin.i.a.y)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.y.class)).a((eaa)localObject1, y.a.wEe, ((TimeLineObject)localObject2).Id, new y.c()
          {
            public final void a(y.b paramAnonymous2b)
            {
              AppMethodBeat.i(203976);
              int i;
              if (paramAnonymous2b == y.b.wEg) {
                if (!Util.isNullOrNil(this.Fbw.LIb)) {
                  i = 1;
                }
              }
              for (;;)
              {
                if (i == 0)
                {
                  paramAnonymousView.putExtra("map_view_type", 7);
                  paramAnonymousView.putExtra("kwebmap_slat", this.Fbw.LbD);
                  paramAnonymousView.putExtra("kwebmap_lng", this.Fbw.LbC);
                  paramAnonymousView.putExtra("kPoiName", this.Fbw.kHV);
                  paramAnonymousView.putExtra("Kwebmap_locaion", this.Fbw.ErZ);
                  com.tencent.mm.br.c.b(c.this.activity, "location", ".ui.RedirectUI", paramAnonymousView);
                  AppMethodBeat.o(203976);
                  return;
                  i = 0;
                  continue;
                  if (paramAnonymous2b == y.b.wEk) {
                    i = 0;
                  }
                }
                else
                {
                  if (c.this.Fbf == 0) {}
                  for (paramAnonymous2b = String.format(com.tencent.mm.protocal.d.KyX, new Object[] { this.Fbw.LIb });; paramAnonymous2b = String.format(com.tencent.mm.protocal.d.KyY, new Object[] { this.Fbw.LIb, this.EJq.Id }))
                  {
                    paramAnonymousView.putExtra("rawUrl", paramAnonymous2b);
                    com.tencent.mm.plugin.sns.c.a.jRt.i(paramAnonymousView, c.this.activity);
                    AppMethodBeat.o(203976);
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
    this.FaT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100260);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        paramAnonymousView = aj.faO().aQm(paramAnonymousView);
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
          String str = r.kb(paramAnonymousView.adActionExtTailLink, paramAnonymousView.uxInfo);
          r.h((Intent)localObject, paramAnonymousView.uxInfo);
          ((Intent)localObject).putExtra("rawUrl", str);
          com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject, c.this.activity);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100260);
      }
    };
    this.FaU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100261);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        int j;
        if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          localObject = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dHp;
          localObject = aj.faO().aQm((String)localObject);
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
          com.tencent.mm.plugin.sns.data.k.a(localSnsAdClick, c.this.EBv, (SnsInfo)localObject, 24);
          r.a(localSnsAdClick);
          c.this.fp(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100261);
          return;
        }
      }
    };
    this.Fas = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int m = 6;
        int j = 0;
        boolean bool = false;
        int k = 1;
        AppMethodBeat.i(100262);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        Object localObject2 = (String)paramAnonymousView.getTag();
        Log.d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(localObject2)));
        Intent localIntent = new Intent();
        int i;
        if (((paramAnonymousView instanceof MaskImageButton)) && (((MaskImageButton)paramAnonymousView).ico != null))
        {
          localObject1 = (String)((MaskImageButton)paramAnonymousView).ico;
          SnsInfo localSnsInfo = aj.faO().aQm((String)localObject1);
          i = j;
          localObject1 = localSnsInfo;
          if (localSnsInfo != null)
          {
            i = j;
            localObject1 = localSnsInfo;
            if (localSnsInfo.isAd())
            {
              ADXml localADXml = localSnsInfo.getAdXml();
              j = c.this.source;
              if (c.this.source == 0) {}
              for (i = 1;; i = 2)
              {
                localObject3 = new SnsAdClick(j, i, localSnsInfo.field_snsId, 1, 0);
                com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject3, c.this.EBv, localSnsInfo, 1);
                if (localADXml == null) {
                  break label566;
                }
                if ((localADXml.headClickType != 1) || (Util.isNullOrNil(localADXml.headClickParam))) {
                  break;
                }
                localObject1 = localADXml.headClickParam;
                localObject2 = c.a(c.this, localSnsInfo);
                paramAnonymousView = (View)localObject1;
                if (localObject2 != null) {
                  paramAnonymousView = r.kb((String)localObject1, ((ADInfo)localObject2).uxInfo);
                }
                Log.i("MicroMsg.TimelineClickListener", "headClickParam url " + paramAnonymousView + " " + localADXml.headClickRightBarShow);
                localObject1 = new Intent();
                if (localADXml.headClickRightBarShow == 0) {
                  bool = true;
                }
                ((Intent)localObject1).putExtra("KsnsViewId", c.a(c.this, localSnsInfo).viewId);
                ((Intent)localObject1).putExtra("KRightBtn", bool);
                ((Intent)localObject1).putExtra("jsapiargs", new Bundle());
                ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
                ((Intent)localObject1).putExtra("useJs", true);
                com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject1, c.this.activity);
                r.a((SnsAdClick)localObject3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100262);
                return;
              }
              if (com.tencent.mm.plugin.sns.ad.e.h.b(c.this.activity, localADXml, c.a(c.this, localSnsInfo), localSnsInfo.field_snsId))
              {
                com.tencent.mm.plugin.sns.ad.i.j.a((SnsAdClick)localObject3, 41);
                r.a((SnsAdClick)localObject3);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100262);
                return;
              }
              localObject1 = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
              ((com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject1).put("ext_sns_ad_click", localObject3);
              Object localObject3 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(1, c.this.activity);
              if ((localObject3 != null) && (((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject3).a(paramAnonymousView, c.this.source, localSnsInfo, (com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject1)))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100262);
                return;
              }
              label566:
              i = 1;
              localObject1 = localSnsInfo;
            }
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
          if (localObject1 != null)
          {
            if (c.this.source != 0) {
              break label845;
            }
            if (((SnsInfo)localObject1).isAd())
            {
              j = 722;
              paramAnonymousView = com.tencent.mm.modelsns.k.tO(j);
              paramAnonymousView.PH(r.v((SnsInfo)localObject1)).tR(((SnsInfo)localObject1).field_type).fL(((SnsInfo)localObject1).isAd()).PH(((SnsInfo)localObject1).getUxinfo()).PH((String)localObject2);
              paramAnonymousView.bfK();
            }
          }
          else
          {
            if (i == 0) {
              break label877;
            }
            j = c.this.source;
            if (c.this.source != 0) {
              break label872;
            }
          }
          label845:
          label872:
          for (i = 1;; i = 2)
          {
            paramAnonymousView = new SnsAdClick(j, i, ((SnsInfo)localObject1).field_snsId, 1, 40);
            com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.EBv, (SnsInfo)localObject1, 1);
            localIntent.putExtra("Contact_User", (String)localObject2);
            localIntent.putExtra("KSnsAdTag", paramAnonymousView);
            localIntent.putExtra("Contact_Scene", 78);
            i = k;
            if (c.this.source == 0) {
              i = 6;
            }
            localIntent.putExtra("CONTACT_INFO_UI_SOURCE", i);
            com.tencent.mm.plugin.sns.c.a.jRt.c(localIntent, c.this.activity);
            Log.i("MicroMsg.TimelineClickListener", "startContactInfo, addScene=78");
            r.a(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100262);
            return;
            j = 721;
            break;
            if (((SnsInfo)localObject1).isAd()) {}
            for (j = 722;; j = 721)
            {
              paramAnonymousView = com.tencent.mm.modelsns.k.tP(j);
              break;
            }
          }
          label877:
          c.this.Epj.fat().e((SnsInfo)localObject1, true);
          if (c.this.source == 0)
          {
            paramAnonymousView = com.tencent.mm.modelsns.k.tO(746);
            localObject1 = z.aTY();
            paramAnonymousView.PH((String)localObject2).fL(((String)localObject2).endsWith((String)localObject1));
            paramAnonymousView.b(localIntent, "intent_key_StatisticsOplog");
            if (c.this.source != 0) {
              break label1041;
            }
          }
          label1041:
          for (i = m;; i = 1)
          {
            localIntent.putExtra("CONTACT_INFO_UI_SOURCE", i);
            localIntent.putExtra("Contact_User", (String)localObject2);
            com.tencent.mm.plugin.sns.c.a.jRt.c(localIntent, c.this.activity);
            ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22210((String)localObject2, 6L);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100262);
            return;
            paramAnonymousView = com.tencent.mm.modelsns.k.tP(746);
            break;
          }
          localObject1 = null;
          i = j;
        }
      }
    };
    this.Fat = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100202);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        final String str = (String)paramAnonymousView.getTag();
        Log.d("MicroMsg.TimelineClickListener", "onCommentLongClick:".concat(String.valueOf(str)));
        if (Util.isNullOrNil(str))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(100202);
          return true;
        }
        if (str.equals(aj.fau()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(100202);
          return true;
        }
        final SnsInfo localSnsInfo;
        if ((((MaskImageButton)paramAnonymousView).ico != null) && ((((MaskImageButton)paramAnonymousView).ico instanceof String)))
        {
          localObject = (String)((MaskImageButton)paramAnonymousView).ico;
          new Intent();
          localSnsInfo = aj.faO().aQm((String)localObject);
          if ((localSnsInfo == null) || (!localSnsInfo.isAd())) {
            break label316;
          }
        }
        label316:
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
          if ((paramAnonymousView.getTag(2131309367) instanceof int[])) {
            arrayOfInt = (int[])paramAnonymousView.getTag(2131309367);
          }
          for (;;)
          {
            new com.tencent.mm.ui.widget.b.a(c.this.activity).a(paramAnonymousView, new View.OnCreateContextMenuListener()new o.g
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(100200);
                com.tencent.mm.kernel.g.aAi();
                paramAnonymous2View = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjK(localSnsInfo.getUserName());
                paramAnonymous2ContextMenuInfo = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ();
                int i;
                if (BuildInfo.DEBUG)
                {
                  i = 1;
                  if (paramAnonymous2ContextMenuInfo.getInt("MMSocialBlackListFlag", i) != 1) {
                    break label178;
                  }
                  i = 1;
                  label73:
                  if ((paramAnonymous2View == null) || (localSnsInfo == null) || (!as.bjp(localSnsInfo.getUserName())) || (!"3552365301".equals(paramAnonymous2View.field_openImAppid))) {
                    break label203;
                  }
                  if (i == 0) {
                    break label184;
                  }
                }
                label178:
                label184:
                for (paramAnonymous2View = c.this.activity.getString(2131757983);; paramAnonymous2View = c.this.activity.getString(2131757985))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View);
                  paramAnonymous2ContextMenu.add(1, 1, 0, c.this.activity.getString(2131766260));
                  AppMethodBeat.o(100200);
                  return;
                  i = 0;
                  break;
                  i = 0;
                  break label73;
                }
                label203:
                if (i != 0) {}
                for (paramAnonymous2View = c.this.activity.getString(2131757983);; paramAnonymous2View = c.this.activity.getString(2131757984))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View);
                  break;
                }
              }
            }, new o.g()
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
                    paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.slQ, 0);
                    localObject2 = c.this.activity;
                    if (paramAnonymous2Int != 0) {
                      break label163;
                    }
                  }
                  label163:
                  for (paramAnonymous2MenuItem = ".ui.PermissionSettingUI";; paramAnonymous2MenuItem = ".ui.PermissionSettingUI2")
                  {
                    com.tencent.mm.br.c.b((Context)localObject2, "profile", paramAnonymous2MenuItem, (Intent)localObject1, 11);
                    AppMethodBeat.o(100201);
                    return;
                    l = localSnsInfo.field_snsId;
                    break;
                  }
                }
                Object localObject2 = new Intent();
                Object localObject1 = aj.faO().aQm(this.Fbl);
                if (localObject1 == null)
                {
                  Log.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + this.Fbl);
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
                  ((Intent)localObject2).putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(33) }));
                  com.tencent.mm.br.c.b(c.this.activity, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
                  com.tencent.mm.kernel.g.aAi();
                  paramAnonymous2MenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjK(localSnsInfo.getUserName());
                  if ((paramAnonymous2MenuItem == null) || (localSnsInfo == null) || (!as.bjp(localSnsInfo.getUserName())) || (!"3552365301".equals(paramAnonymous2MenuItem.field_openImAppid))) {
                    break;
                  }
                  paramAnonymous2MenuItem = com.tencent.mm.plugin.sns.k.e.DUQ;
                  com.tencent.mm.plugin.sns.k.e.aPR(((SnsInfo)localObject1).getUserName());
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
    this.Fau = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100203);
        paramAnonymousContextMenuInfo = (bg)paramAnonymousView.getTag();
        paramAnonymousView = aj.faO().aQl(paramAnonymousContextMenuInfo.dRS);
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(100203);
          return;
        }
        paramAnonymousContextMenu.add(0, 0, 0, c.this.activity.getString(2131755772));
        if (com.tencent.mm.br.c.aZU("favorite")) {
          paramAnonymousContextMenu.add(0, 1, 0, c.this.activity.getString(2131763947));
        }
        TimeLineObject localTimeLineObject = paramAnonymousView.getTimeLine();
        if ((paramAnonymousContextMenuInfo.EHG) || ((localTimeLineObject != null) && (localTimeLineObject.contentDescShowType != 1) && (!paramAnonymousContextMenuInfo.EHH)))
        {
          if (!paramAnonymousContextMenuInfo.fiA()) {
            au.a(paramAnonymousContextMenu, true);
          }
        }
        else
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousView);
          if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) && (((c.this.activity instanceof SnsTimeLineUI)) || ((c.this.activity instanceof SnsCommentDetailUI))))
          {
            paramAnonymousContextMenu.add(0, 27, 0, c.this.activity.getString(2131759440));
            paramAnonymousContextMenu = Util.nullAs(paramAnonymousView.getTimeLine().ContentDesc, "");
            if (!(c.this.activity instanceof SnsTimeLineUI)) {
              break label278;
            }
          }
        }
        label278:
        for (int i = 3;; i = 5)
        {
          com.tencent.mm.plugin.websearch.api.ar.a(1, com.tencent.mm.plugin.fts.a.d.Nj(77), 77, 0, "", "", r.Jb(paramAnonymousView.field_snsId), i, "", 0L, paramAnonymousContextMenu.length());
          AppMethodBeat.o(100203);
          return;
          au.b(paramAnonymousContextMenu, true);
          break;
        }
      }
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(100204);
        if ((paramAnonymousView.getTag() instanceof bg))
        {
          Object localObject = (bg)paramAnonymousView.getTag();
          localObject = aj.faO().aQl(((bg)localObject).dRS);
          if (localObject == null)
          {
            AppMethodBeat.o(100204);
            return false;
          }
          String str = ((SnsInfo)localObject).getLocalid();
          c.this.Far.a(paramAnonymousView, str, ((SnsInfo)localObject).getTimeLine());
          AppMethodBeat.o(100204);
          return true;
        }
        AppMethodBeat.o(100204);
        return false;
      }
    };
    this.FaJ = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100206);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof SnsInfo)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.at)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.bc)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.c.a.a))) {
          if ((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.f.aQl(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).dRS);
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
            if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.at))
            {
              paramAnonymousContextMenuInfo = (com.tencent.mm.plugin.sns.ui.at)paramAnonymousContextMenuInfo;
              paramAnonymousContextMenuInfo = aj.faO().aQm(paramAnonymousContextMenuInfo.dHp);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bc))
            {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.bc)paramAnonymousView.getTag()).dJX;
              paramAnonymousContextMenuInfo = aj.faO().aQm(paramAnonymousContextMenuInfo);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).DsC;
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
            if (com.tencent.mm.br.c.aZU("favorite"))
            {
              if (paramAnonymousContextMenuInfo.getAdXml().isCardAd()) {
                paramAnonymousContextMenu.add(0, 20, 0, paramAnonymousView.getContext().getString(2131763947));
              }
              ef localef = new ef();
              localef.dHy.dHp = paramAnonymousContextMenuInfo.getLocalid();
              EventCenter.instance.publish(localef);
              if (localef.dHz.dGX) {
                paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755922));
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
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(100205);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof SnsInfo)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.at)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bc)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.f.aQl(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dRS);
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
              if ((localObject instanceof com.tencent.mm.plugin.sns.ui.at))
              {
                localObject = (com.tencent.mm.plugin.sns.ui.at)localObject;
                localObject = aj.faO().aQm(((com.tencent.mm.plugin.sns.ui.at)localObject).dHp);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bc))
              {
                localObject = ((com.tencent.mm.plugin.sns.ui.bc)paramAnonymousView.getTag()).dJX;
                localObject = aj.faO().aQm((String)localObject);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                localObject = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).DsC;
              }
            }
            else
            {
              if ((((SnsInfo)localObject).getAdXml() == null) || (!((SnsInfo)localObject).getAdXml().isCardAd()))
              {
                AppMethodBeat.o(100205);
                return false;
              }
              c.this.Far.a(paramAnonymousView, ((SnsInfo)localObject).getLocalid(), ((SnsInfo)localObject).getTimeLine());
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
    this.FaK = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100208);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof SnsInfo)))
        {
          if (!(paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            break label177;
          }
          paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.f.aQl(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).dRS);
        }
        for (;;)
        {
          Object localObject;
          ADInfo localADInfo;
          if (com.tencent.mm.br.c.aZU("favorite"))
          {
            localObject = paramAnonymousContextMenuInfo.getAdXml();
            localADInfo = c.a(c.this, paramAnonymousContextMenuInfo);
            if (((ADXml)localObject).isLinkAd())
            {
              if (!((ADXml)localObject).isLandingPagesAd()) {
                break label192;
              }
              paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131763947));
            }
          }
          for (;;)
          {
            localObject = new ef();
            ((ef)localObject).dHy.dHp = paramAnonymousContextMenuInfo.getLocalid();
            EventCenter.instance.publish((IEvent)localObject);
            if (((ef)localObject).dHz.dGX) {
              paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755922));
            }
            if (paramAnonymousContextMenuInfo != null) {
              com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            }
            AppMethodBeat.o(100208);
            return;
            label177:
            if (!(paramAnonymousContextMenuInfo instanceof SnsInfo)) {
              break label222;
            }
            paramAnonymousContextMenuInfo = (SnsInfo)paramAnonymousContextMenuInfo;
            break;
            label192:
            if (localADInfo.adActionType == 0) {
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131763947));
            }
          }
          label222:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(100207);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof SnsInfo)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.f.aQl(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dRS);
          }
        }
        for (;;)
        {
          if (localObject != null) {
            c.this.Far.a(paramAnonymousView, ((SnsInfo)localObject).getLocalid(), ((SnsInfo)localObject).getTimeLine());
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
    this.FaG = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100209);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.s)) {
          c.this.FaL.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
        }
        AppMethodBeat.o(100209);
      }
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(100210);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.s)paramAnonymousView.getTag()).dHp;
          SnsInfo localSnsInfo = aj.faO().aQm(str);
          c.this.Far.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(100210);
          return true;
        }
        AppMethodBeat.o(100210);
        return false;
      }
    };
    this.FaM = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100211);
        if (com.tencent.mm.br.c.aZU("favorite")) {
          paramAnonymousContextMenu.add(0, 24, 0, paramAnonymousView.getContext().getString(2131763947));
        }
        AppMethodBeat.o(100211);
      }
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(100212);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.ai))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.ai)paramAnonymousView.getTag()).dHp;
          SnsInfo localSnsInfo = aj.faO().aQm(str);
          c.this.Far.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(100212);
          return true;
        }
        AppMethodBeat.o(100212);
        return false;
      }
    };
    this.FaF = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100214);
        com.tencent.mm.plugin.sns.ui.bc localbc;
        Object localObject1;
        Object localObject2;
        int j;
        int i;
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bc)))
        {
          localbc = (com.tencent.mm.plugin.sns.ui.bc)paramAnonymousView.getTag();
          localObject1 = localbc.dJX;
          paramAnonymousContextMenuInfo = aj.faO().aQm((String)localObject1);
          if (com.tencent.mm.br.c.aZU("favorite"))
          {
            paramAnonymousContextMenu.add(0, 2, 0, c.this.activity.getString(2131763947));
            localObject2 = new ef();
            ((ef)localObject2).dHy.dHp = ((String)localObject1);
            EventCenter.instance.publish((IEvent)localObject2);
            if (((ef)localObject2).dHz.dGX) {
              paramAnonymousContextMenu.add(0, 18, 0, c.this.activity.getString(2131755922));
            }
          }
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
          localObject1 = paramAnonymousContextMenu.add(0, 21, 0, c.this.activity.getString(2131766033));
          localObject2 = new int[2];
          if (paramAnonymousView == null) {
            break label501;
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
          if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (((c.this.activity instanceof SnsTimeLineUI)) || ((c.this.activity instanceof SnsCommentDetailUI))))
          {
            paramAnonymousContextMenu.add(0, 26, 0, c.this.activity.getString(2131759440));
            if (!(c.this.activity instanceof SnsTimeLineUI)) {
              break label483;
            }
            i = 10;
            paramAnonymousContextMenu = paramAnonymousContextMenuInfo.getTimeLine();
            if (localbc.index >= paramAnonymousContextMenu.ContentObj.LoV.size()) {
              break label490;
            }
          }
          label483:
          label490:
          for (paramAnonymousContextMenu = (cnb)paramAnonymousContextMenu.ContentObj.LoV.get(localbc.index);; paramAnonymousContextMenu = new cnb())
          {
            paramAnonymousView = new ab();
            paramAnonymousContextMenuInfo = paramAnonymousView.ie("").jdMethod_if(r.Jb(paramAnonymousContextMenuInfo.field_snsId));
            paramAnonymousContextMenuInfo.enp = i;
            paramAnonymousContextMenuInfo.eki = 1;
            paramAnonymousContextMenuInfo.enq = 81;
            paramAnonymousView.ig("");
            paramAnonymousView.ih("");
            paramAnonymousView.ii(com.tencent.mm.b.g.getMD5(com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramAnonymousContextMenu.Id) + r.l(paramAnonymousContextMenu)));
            paramAnonymousView.enx = System.currentTimeMillis();
            paramAnonymousView.bfK();
            com.tencent.mm.plugin.websearch.api.ar.a(paramAnonymousView);
            AppMethodBeat.o(100214);
            return;
            i = 7;
            break;
          }
          label501:
          i = 0;
          j = 0;
        }
      }
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(100213);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bc))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.bc)paramAnonymousView.getTag()).dJX;
          SnsInfo localSnsInfo = aj.faO().aQm(str);
          c.this.Far.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(100213);
          return true;
        }
        AppMethodBeat.o(100213);
        return false;
      }
    };
    this.FaI = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(203954);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.bc)) {
          paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.bc)paramAnonymousContextMenuInfo).dJX;
        }
        for (;;)
        {
          if (paramAnonymousContextMenuInfo != null)
          {
            paramAnonymousContextMenuInfo = aj.faO().aQm(paramAnonymousContextMenuInfo);
            TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.getTimeLine();
            if (com.tencent.mm.br.c.aZU("favorite")) {
              switch (localTimeLineObject.ContentObj.LoU)
              {
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            AppMethodBeat.o(203954);
            return;
            if (!(paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.s)) {
              break label158;
            }
            paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.s)paramAnonymousContextMenuInfo).dHp;
            break;
            paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(2131763947));
            continue;
            paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131763947));
          }
          label158:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(203953);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof com.tencent.mm.plugin.sns.ui.bc)) {
          localObject = ((com.tencent.mm.plugin.sns.ui.bc)localObject).dJX;
        }
        for (;;)
        {
          if (localObject != null)
          {
            SnsInfo localSnsInfo = aj.faO().aQm((String)localObject);
            c.this.Far.a(paramAnonymousView, (String)localObject, localSnsInfo.getTimeLine());
            AppMethodBeat.o(203953);
            return true;
            if ((localObject instanceof com.tencent.mm.plugin.sns.ui.s)) {
              localObject = ((com.tencent.mm.plugin.sns.ui.s)localObject).dHp;
            }
          }
          else
          {
            AppMethodBeat.o(203953);
            return false;
          }
          localObject = null;
        }
      }
    };
    this.Erh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100216);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        localObject1 = null;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bc)) {
          localObject1 = ((com.tencent.mm.plugin.sns.ui.bc)paramAnonymousView.getTag()).dJX;
        }
        Object localObject2;
        for (;;)
        {
          localObject2 = com.tencent.mm.plugin.sns.storage.f.aQm((String)localObject1);
          if (localObject2 != null) {
            break;
          }
          Log.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(localObject1)));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
          if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dHp;
          } else if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
            localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).DsC.getLocalid();
          }
        }
        if ((((SnsInfo)localObject2).isAd()) && (((SnsInfo)localObject2).getAdXml() != null) && ((((SnsInfo)localObject2).getAdXml().isCardAd()) || (((SnsInfo)localObject2).getAdXml().isFullCardAd())))
        {
          c.this.Fbd.onClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
        }
        if (((SnsInfo)localObject2).getTimeLine().ContentObj.LoU == 21)
        {
          if (z.aTY().equals(((SnsInfo)localObject2).getUserName()))
          {
            ((SnsInfo)localObject2).getTimeLine();
            com.tencent.mm.plugin.sns.lucky.a.m.y((SnsInfo)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.m.x((SnsInfo)localObject2);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.pl(25);
          }
          if (!z.aTY().equals(((SnsInfo)localObject2).getUserName()))
          {
            com.tencent.mm.plugin.sns.lucky.b.a.c(2, (SnsInfo)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.b.pl(30);
          }
        }
        int j;
        int i;
        Object localObject3;
        if (((SnsInfo)localObject2).isAd())
        {
          localObject1 = c.a(c.this, (SnsInfo)localObject2);
          if ((((SnsInfo)localObject2).getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(((SnsInfo)localObject2).getAdSnsInfo().field_adxml)))
          {
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Q((SnsInfo)localObject2);
            if (!Util.isNullOrNil((String)localObject1)) {
              ((SnsInfo)localObject2).getAdSnsInfo().field_adxml = ((String)localObject1);
            }
            j = c.this.source;
            if (c.this.source == 0)
            {
              i = 1;
              localObject1 = new SnsAdClick(j, i, ((SnsInfo)localObject2).field_snsId, 21, 21);
              com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject1, c.this.EBv, (SnsInfo)localObject2, 21);
              r.a((SnsAdClick)localObject1);
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
                localObject3 = ((TimeLineObject)localObject3).ContentObj.LoV;
                if (((List)localObject3).size() > 0)
                {
                  ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((cnb)((List)localObject3).get(0)).Msz);
                  ((Intent)localObject1).putExtra("sns_landing_pages_from_outer_index", ((com.tencent.mm.plugin.sns.ui.bc)paramAnonymousView.getTag()).index);
                }
              }
              ((Intent)localObject1).setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
              if (c.this.source != 2) {
                break label1058;
              }
              i = 16;
            }
          }
        }
        for (;;)
        {
          label698:
          ((Intent)localObject1).putExtra("sns_landig_pages_from_source", i);
          ((Intent)localObject1).putExtra("sns_landing_pages_xml", ((SnsInfo)localObject2).getAdSnsInfo().field_adxml);
          ((Intent)localObject1).putExtra("sns_landing_pages_rec_src", ((SnsInfo)localObject2).getAdRecSrc());
          ((Intent)localObject1).putExtra("sns_landing_pages_xml_prefix", "adxml");
          if (!((SnsInfo)localObject2).getAdXml().forbiddenCustomAnimation)
          {
            ((Intent)localObject1).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            ((Intent)localObject1).putExtra("sns_landing_pages_is_normal_ad_animation", true);
          }
          localObject3 = c.this.activity;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          if (!((SnsInfo)localObject2).getAdXml().forbiddenCustomAnimation) {
            c.this.activity.overridePendingTransition(0, 0);
          }
          if (c.this.Epj != null) {
            c.this.Epj.fat().M((SnsInfo)localObject2);
          }
          label914:
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.bc)paramAnonymousView.getTag();
          if ((paramAnonymousView.EAv) && (localObject2 != null))
          {
            com.tencent.mm.plugin.sns.ui.a.c.g((SnsInfo)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.ui.a.c.h((SnsInfo)localObject2, paramAnonymousView.index);
            bd.aPu(((SnsInfo)localObject2).getLocalid());
          }
          if (localObject2 != null)
          {
            localObject1 = ((SnsInfo)localObject2).getTimeLine();
            if (localObject1 != null) {
              if (((TimeLineObject)localObject1).AppInfo != null) {
                break label1294;
              }
            }
          }
          label1294:
          for (paramAnonymousView = null;; paramAnonymousView = ((TimeLineObject)localObject1).AppInfo.Id)
          {
            if (!Util.isNullOrNil(paramAnonymousView))
            {
              localObject2 = com.tencent.mm.plugin.sns.c.a.jRu.go(paramAnonymousView);
              com.tencent.mm.plugin.sns.c.a.jRu.a(null, paramAnonymousView, (String)localObject2, ((TimeLineObject)localObject1).UserName, 2, 4, 4, ((TimeLineObject)localObject1).statisticsData, ((TimeLineObject)localObject1).Id);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100216);
            return;
            i = 2;
            break;
            label1058:
            if (c.this.source != 1) {
              break label1306;
            }
            i = 2;
            break label698;
            if (c.a(c.this, (ADInfo)localObject1, (SnsInfo)localObject2, false))
            {
              j = c.this.source;
              if (c.this.source == 0) {}
              for (i = 1;; i = 2)
              {
                localObject1 = new SnsAdClick(j, i, ((SnsInfo)localObject2).field_snsId, 21, 31);
                com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject1, c.this.EBv, (SnsInfo)localObject2, 21);
                r.a((SnsAdClick)localObject1);
                break;
              }
            }
            if (bk.Y((SnsInfo)localObject2) == 2)
            {
              if (com.tencent.mm.plugin.sns.ad.e.h.a(c.this.activity, ((SnsInfo)localObject2).getAdXml(), (ADInfo)localObject1, ((SnsInfo)localObject2).field_snsId))
              {
                j = c.this.source;
                if (c.this.source == 0) {}
                for (i = 1;; i = 2)
                {
                  localObject1 = new SnsAdClick(j, i, ((SnsInfo)localObject2).field_snsId, 21, 37);
                  com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject1, c.this.EBv, (SnsInfo)localObject2, 21);
                  r.a((SnsAdClick)localObject1);
                  break;
                }
              }
              c.this.dS(paramAnonymousView);
              break label914;
            }
            c.this.dS(paramAnonymousView);
            break label914;
            c.this.dS(paramAnonymousView);
            break label914;
          }
          label1306:
          i = 1;
        }
      }
    };
    this.Fav = new c.11(this);
    this.Faw = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(100220);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        new com.tencent.mm.ui.widget.a.f.a(c.this.activity).bow(c.this.activity.getResources().getString(2131766262)).boA(c.this.activity.getResources().getString(2131755778)).apb(c.this.activity.getResources().getColor(2131100996)).b(new f.c()
        {
          public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(203955);
            if (!(paramAnonymousView.getTag() instanceof String))
            {
              AppMethodBeat.o(203955);
              return;
            }
            paramAnonymous2String = (String)paramAnonymousView.getTag();
            Log.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymous2String)));
            SnsInfo localSnsInfo = aj.faO().aQm(paramAnonymous2String);
            if (localSnsInfo == null)
            {
              Log.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(203955);
              return;
            }
            Object localObject2;
            if (localSnsInfo.isDieItem())
            {
              Log.i("MicroMsg.TimelineClickListener", "dead item");
              aj.faO().Zs(localSnsInfo.localid);
              if (c.this.Fbe != null) {
                c.this.Fbe.fiX();
              }
              if (c.this.source == 0)
              {
                localObject1 = com.tencent.mm.modelsns.k.tO(739);
                localObject2 = ((com.tencent.mm.modelsns.k)localObject1).PH(r.v(localSnsInfo)).tR(localSnsInfo.field_type);
                if (!localSnsInfo.isDieItem()) {
                  break label238;
                }
                paramAnonymous2String = "2";
              }
              for (;;)
              {
                ((com.tencent.mm.modelsns.k)localObject2).PH(paramAnonymous2String);
                ((com.tencent.mm.modelsns.k)localObject1).bfK();
                if (localSnsInfo.getTypeFlag() == 21) {
                  com.tencent.mm.plugin.sns.lucky.a.g.eZK().eZM();
                }
                AppMethodBeat.o(203955);
                return;
                localObject1 = com.tencent.mm.modelsns.k.tP(739);
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
              aj.faK().J(localSnsInfo);
              paramAnonymous2String = localSnsInfo.getTimeLine();
              j = 0;
              i = j;
              if (paramAnonymous2String != null)
              {
                i = j;
                if (paramAnonymous2String.ContentObj != null)
                {
                  i = j;
                  if (paramAnonymous2String.ContentObj.dME != null)
                  {
                    i = j;
                    if (paramAnonymous2String.ContentObj.dME.localId != 0L) {
                      i = 1;
                    }
                  }
                }
              }
              if ((Util.secondsToNow(localSnsInfo.getCreateTime()) < com.tencent.mm.plugin.sns.model.at.DMU) && (i == 0)) {
                aj.fba().D(localSnsInfo);
              }
              c.this.ffw();
              AppMethodBeat.o(203955);
              return;
            }
            Log.i("MicroMsg.TimelineClickListener", "delete by server");
            paramAnonymous2String = localSnsInfo.getSnsId();
            aj.faN().Jr(com.tencent.mm.plugin.sns.storage.y.aOa(paramAnonymous2String));
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.s(com.tencent.mm.plugin.sns.storage.y.aOa(paramAnonymous2String), 1), 0);
            Object localObject1 = localSnsInfo.getTimeLine();
            int j = 0;
            int i = j;
            if (localObject1 != null)
            {
              i = j;
              if (((TimeLineObject)localObject1).ContentObj != null)
              {
                i = j;
                if (((TimeLineObject)localObject1).ContentObj.dME != null)
                {
                  i = j;
                  if (((TimeLineObject)localObject1).ContentObj.dME.localId != 0L) {
                    i = 1;
                  }
                }
              }
            }
            if ((Util.secondsToNow(localSnsInfo.getCreateTime()) < com.tencent.mm.plugin.sns.model.at.DMU) && (i == 0)) {
              aj.fba().D(localSnsInfo);
            }
            aj.faO().delete(com.tencent.mm.plugin.sns.storage.y.aOa(paramAnonymous2String));
            aj.faT().JI(com.tencent.mm.plugin.sns.storage.y.aOa(paramAnonymous2String));
            com.tencent.mm.plugin.sns.storage.g.JH(com.tencent.mm.plugin.sns.storage.y.aOa(paramAnonymous2String));
            c.this.ffw();
            if (localObject1 != null)
            {
              if (((TimeLineObject)localObject1).AppInfo != null) {
                break label766;
              }
              paramAnonymous2String = null;
              if ((!Util.isNullOrNil(paramAnonymous2String)) && (com.tencent.mm.plugin.sns.c.a.jRu.gq(paramAnonymous2String)))
              {
                localObject2 = com.tencent.mm.plugin.sns.c.a.jRu.go(paramAnonymous2String);
                rw localrw = new rw();
                localrw.dYr.appId = paramAnonymous2String;
                localrw.dYr.dYs = ((TimeLineObject)localObject1).UserName;
                localrw.dYr.pkgName = ((String)localObject2);
                localrw.dYr.mediaTagName = ((TimeLineObject)localObject1).statisticsData;
                EventCenter.instance.publish(localrw);
              }
            }
            if (c.this.source == 0)
            {
              localObject1 = com.tencent.mm.modelsns.k.tO(739);
              label716:
              localObject2 = ((com.tencent.mm.modelsns.k)localObject1).PH(r.v(localSnsInfo)).tR(localSnsInfo.field_type);
              if (!localSnsInfo.isDieItem()) {
                break label789;
              }
              paramAnonymous2String = "2";
            }
            for (;;)
            {
              ((com.tencent.mm.modelsns.k)localObject2).PH(paramAnonymous2String);
              ((com.tencent.mm.modelsns.k)localObject1).bfK();
              AppMethodBeat.o(203955);
              return;
              label766:
              paramAnonymous2String = ((TimeLineObject)localObject1).AppInfo.Id;
              break;
              localObject1 = com.tencent.mm.modelsns.k.tP(739);
              break label716;
              label789:
              if (localSnsInfo.field_snsId == 0L) {
                paramAnonymous2String = "1";
              } else {
                paramAnonymous2String = "0";
              }
            }
          }
        }).boB(c.this.activity.getResources().getString(2131755761)).a(new f.c()
        {
          public final void e(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100220);
      }
    };
    this.Fax = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100221);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = (String)paramAnonymousView.getTag();
        Log.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymousView)));
        paramAnonymousView = aj.faO().aQm(paramAnonymousView).getTimeLine();
        localObject1 = paramAnonymousView.actionInfo;
        if (((com.tencent.mm.protocal.protobuf.be)localObject1).KEw == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
        }
        String str = com.tencent.mm.plugin.sns.c.a.jRu.go(((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.jfi);
        int i = 0;
        if (paramAnonymousView.ContentObj.LoU == 1) {
          i = 2;
        }
        while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(paramAnonymousView, c.this.activity))
        {
          com.tencent.mm.plugin.sns.c.a.jRu.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.jfi, str, paramAnonymousView.UserName, i, 11, 9, ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.KEq, paramAnonymousView.Id);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
          if (paramAnonymousView.ContentObj.LoU == 3) {
            i = 5;
          } else if (paramAnonymousView.ContentObj.LoU == 15) {
            i = 38;
          }
        }
        switch (((com.tencent.mm.protocal.protobuf.be)localObject1).oUv)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("rawUrl", ((com.tencent.mm.protocal.protobuf.be)localObject1).Url);
          com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject2, c.this.activity);
          com.tencent.mm.plugin.sns.c.a.jRu.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.jfi, str, paramAnonymousView.UserName, i, 11, 1, ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.KEq, paramAnonymousView.Id);
          continue;
          if (((com.tencent.mm.protocal.protobuf.be)localObject1).Scene == 1)
          {
            localObject2 = new is();
            ((is)localObject2).dNr.actionCode = 2;
            ((is)localObject2).dNr.scene = 3;
            ((is)localObject2).dNr.appId = ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.jfi;
            ((is)localObject2).dNr.context = c.this.activity;
            EventCenter.instance.publish((IEvent)localObject2);
            com.tencent.mm.plugin.sns.c.a.jRu.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.jfi, str, paramAnonymousView.UserName, i, 11, 6, ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.KEq, paramAnonymousView.Id);
            continue;
            int j = com.tencent.mm.plugin.sns.ui.ao.b(c.this.activity, (com.tencent.mm.protocal.protobuf.be)localObject1);
            if (j == 1)
            {
              localObject2 = new is();
              ((is)localObject2).dNr.context = c.this.activity;
              ((is)localObject2).dNr.actionCode = 2;
              ((is)localObject2).dNr.appId = ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.jfi;
              ((is)localObject2).dNr.messageAction = ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.KEs;
              ((is)localObject2).dNr.messageExt = ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.KEr;
              ((is)localObject2).dNr.scene = 3;
              EventCenter.instance.publish((IEvent)localObject2);
              com.tencent.mm.plugin.sns.c.a.jRu.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.jfi, str, paramAnonymousView.UserName, i, 11, 6, ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.KEq, paramAnonymousView.Id);
            }
            else if (j == 2)
            {
              localObject2 = new is();
              ((is)localObject2).dNr.context = c.this.activity;
              ((is)localObject2).dNr.actionCode = 1;
              ((is)localObject2).dNr.appId = ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.jfi;
              ((is)localObject2).dNr.messageAction = ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.KEs;
              ((is)localObject2).dNr.messageExt = ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.KEr;
              ((is)localObject2).dNr.scene = 3;
              EventCenter.instance.publish((IEvent)localObject2);
              com.tencent.mm.plugin.sns.c.a.jRu.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.jfi, str, paramAnonymousView.UserName, i, 11, 3, ((com.tencent.mm.protocal.protobuf.be)localObject1).KEw.KEq, paramAnonymousView.Id);
            }
          }
        }
      }
    };
    this.FaD = new View.OnClickListener()
    {
      private static void aRs(String paramAnonymousString)
      {
        AppMethodBeat.i(203956);
        long l = aj.faO().aQm(paramAnonymousString).field_snsId;
        Object localObject1 = aj.faO().JJ(l);
        if (localObject1 != null)
        {
          Object localObject2 = ((SnsInfo)localObject1).getTimeLine();
          if (localObject2 != null)
          {
            localObject2 = ((TimeLineObject)localObject2).ContentObj.LoV;
            if (((List)localObject2).size() > 0) {
              ((List)localObject2).get(0);
            }
          }
          localObject2 = an.C((SnsInfo)localObject1);
          localObject1 = new ArrayList();
          localObject2 = ((SnsObject)localObject2).SnsRedEnvelops.Naf;
          if (localObject2 != null)
          {
            int i = 0;
            while (i < ((List)localObject2).size())
            {
              dzx localdzx = (dzx)((List)localObject2).get(i);
              com.tencent.mm.plugin.l.a.a locala = new com.tencent.mm.plugin.l.a.a();
              locala.mRa = localdzx.Username;
              locala.yOR = localdzx.CreateTime;
              locala.yOS = localdzx.MYW;
              ((List)localObject1).add(locala);
              i += 1;
            }
          }
          com.tencent.mm.plugin.l.a.z(paramAnonymousString, (List)localObject1);
        }
        AppMethodBeat.o(203956);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100223);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if ((paramAnonymousView.getTag() instanceof SnsInfo))
        {
          paramAnonymousView = (SnsInfo)paramAnonymousView.getTag();
          if ((paramAnonymousView.getTypeFlag() == 21) && (z.aTY().equals(paramAnonymousView.getUserName())))
          {
            paramAnonymousView.getTimeLine();
            com.tencent.mm.plugin.sns.lucky.a.m.y(paramAnonymousView);
            com.tencent.mm.plugin.sns.lucky.a.m.x(paramAnonymousView);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.pl(24);
          }
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_sendid", paramAnonymousView.getSnsId());
          ((Intent)localObject2).putExtra("key_feedid", paramAnonymousView.getLocalid());
          ((Intent)localObject2).setClassName(c.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
          localObject1 = c.this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = paramAnonymousView.getLocalid();
          paramAnonymousView.getSnsId();
          aRs((String)localObject1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100223);
      }
    };
    this.Fay = new c.16(this);
    this.Faz = new c.17(this);
    this.FaA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((paramAnonymousView.getTag() instanceof String))
        {
          paramAnonymousView = (String)paramAnonymousView.getTag();
          Log.d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(paramAnonymousView)));
          an.YD(com.tencent.mm.plugin.sns.storage.y.aQI(paramAnonymousView));
          an.YB(com.tencent.mm.plugin.sns.storage.y.aQI(paramAnonymousView));
          aj.faK().eZn();
          c.this.ffw();
          if (c.this.Fbe != null) {
            c.this.Fbe.fiX();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100226);
      }
    };
    this.FaB = new c.19(this);
    this.FaE = new d()
    {
      private static boolean c(com.tencent.mm.plugin.sns.ui.m paramAnonymousm)
      {
        AppMethodBeat.i(203958);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousm != null)
        {
          bool1 = bool2;
          if (paramAnonymousm.DIu != null)
          {
            bool1 = bool2;
            if (!Util.isNullOrNil(paramAnonymousm.DIu.MYY)) {
              bool1 = true;
            }
          }
        }
        AppMethodBeat.o(203958);
        return bool1;
      }
      
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(203959);
        int i;
        long l;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          if (((!com.tencent.mm.plugin.sns.ui.widget.e.iY(paramAnonymousView.DIu.MYX, 16)) || (paramAnonymousView.scene == 2)) && (!c(paramAnonymousView))) {
            paramAnonymousContextMenu.add(0, 11, 0, c.this.activity.getString(2131755772));
          }
          if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE))
          {
            i = 1;
            if (((i != 0) && (!Util.isNullOrNil(paramAnonymousView.Epx)) && (paramAnonymousView.Epx.equals(z.aTY()))) || ((paramAnonymousView.UserName != null) && (paramAnonymousView.UserName.equals(z.aTY())))) {
              paramAnonymousContextMenu.add(0, 7, 0, c.this.activity.getString(2131755778));
            }
            if ((com.tencent.mm.plugin.sns.ui.widget.e.iY(paramAnonymousView.DIu.MYX, 16)) || (c(paramAnonymousView))) {
              break label372;
            }
            paramAnonymousContextMenuInfo = paramAnonymousView.Epv;
            StringBuilder localStringBuilder = new StringBuilder();
            if (paramAnonymousView.DIu.MYT == 0) {
              break label335;
            }
            l = paramAnonymousView.DIu.MYT;
            label224:
            paramAnonymousContextMenuInfo = au.kj(paramAnonymousContextMenuInfo, l);
            if (paramAnonymousView.scene != 1) {
              break label347;
            }
            i = 2;
          }
        }
        for (;;)
        {
          label250:
          paramAnonymousView = au.aPp(paramAnonymousContextMenuInfo);
          if ((paramAnonymousView != null) && (paramAnonymousView.iGD) && (!paramAnonymousView.aGI) && ((i & paramAnonymousView.showFlag) != 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label367;
            }
            au.a(paramAnonymousContextMenu, false);
            AppMethodBeat.o(203959);
            return;
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sdQ, 0) == 1)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
            label335:
            l = paramAnonymousView.DIu.MYV;
            break label224;
            label347:
            if (paramAnonymousView.scene != 2) {
              break label378;
            }
            i = 4;
            break label250;
          }
          label367:
          au.b(paramAnonymousContextMenu, false);
          label372:
          AppMethodBeat.o(203959);
          return;
          label378:
          i = -1;
        }
      }
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(203960);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject = aj.faO().aQl(((com.tencent.mm.plugin.sns.ui.m)localObject).Epv);
          c.this.Far.a(paramAnonymousView, ((SnsInfo)localObject).getLocalid(), ((SnsInfo)localObject).getTimeLine());
          AppMethodBeat.o(203960);
          return true;
        }
        AppMethodBeat.o(203960);
        return false;
      }
    };
    this.uwC = new c.21(this);
    this.FaO = new c.22(this);
    this.FaR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100239);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        com.tencent.mm.plugin.sns.ui.s locals;
        Object localObject2;
        Object localObject3;
        String str1;
        int i;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          locals = (com.tencent.mm.plugin.sns.ui.s)paramAnonymousView.getTag();
          localObject2 = (cnb)locals.EpO.ContentObj.LoV.get(0);
          localObject1 = locals.dHp;
          aj.faO().aQl((String)localObject1);
          localObject1 = "";
          localObject3 = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), ((cnb)localObject2).Id);
          str1 = "";
          String str2 = r.j((cnb)localObject2);
          if (com.tencent.mm.vfs.s.YS((String)localObject3 + str2))
          {
            localObject1 = (String)localObject3 + str2;
            str1 = (String)localObject3 + r.e((cnb)localObject2);
          }
          if (com.tencent.mm.vfs.s.YS((String)localObject3 + r.p((cnb)localObject2)))
          {
            localObject1 = (String)localObject3 + r.p((cnb)localObject2);
            str1 = (String)localObject3 + r.n((cnb)localObject2);
          }
          localObject2 = new int[2];
          localObject3 = paramAnonymousView.findViewById(2131299213);
          if (localObject3 == null) {
            break label535;
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
          paramAnonymousView.putExtra("intent_localid", locals.dHp);
          paramAnonymousView.putExtra("intent_isad", false);
          paramAnonymousView.putExtra("intent_from_scene", c.this.source);
          paramAnonymousView.putExtra("img_gallery_left", localObject2[0]);
          paramAnonymousView.putExtra("img_gallery_top", localObject2[1]);
          paramAnonymousView.putExtra("img_gallery_width", i);
          paramAnonymousView.putExtra("img_gallery_height", j);
          localObject1 = c.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)paramAnonymousView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          c.this.activity.overridePendingTransition(0, 0);
          c.a(c.this, locals.EpO);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100239);
          return;
          label535:
          paramAnonymousView.getLocationInWindow((int[])localObject2);
          i = paramAnonymousView.getWidth();
        }
      }
    };
    this.FaQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203963);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        Log.i("MicroMsg.TimelineClickListener", "onsight click");
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.at)) {
          localObject1 = (com.tencent.mm.plugin.sns.ui.at)paramAnonymousView.getTag();
        }
        for (;;)
        {
          final SnsInfo localSnsInfo = aj.faO().aQm(((com.tencent.mm.plugin.sns.ui.at)localObject1).dHp);
          if (localSnsInfo == null)
          {
            Log.i("MicroMsg.TimelineClickListener", "onsight click but info is null localid %s", new Object[] { ((com.tencent.mm.plugin.sns.ui.at)localObject1).dHp });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203963);
            return;
            if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
            {
              localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).EUK;
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
              localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).EUK;
            }
          }
          else
          {
            if (c.this.Epj != null) {
              c.this.Epj.fat().M(localSnsInfo);
            }
            final boolean bool = localSnsInfo.isAd();
            if ((bool) && (localSnsInfo.getAdXml() != null) && ((localSnsInfo.getAdXml().isCardAd()) || (localSnsInfo.getAdXml().isFullCardAd())))
            {
              c.this.Fbd.onClick(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(203963);
              return;
            }
            final TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ui.at)localObject1).Ewq;
            if ((localTimeLineObject.ContentObj.LoV == null) || (localTimeLineObject.ContentObj.LoV.size() == 0))
            {
              Log.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(203963);
              return;
            }
            final cnb localcnb = (cnb)localTimeLineObject.ContentObj.LoV.get(0);
            if (bool)
            {
              aj.faL();
              if (!com.tencent.mm.plugin.sns.model.g.u(localcnb))
              {
                ((com.tencent.mm.plugin.sns.ui.at)localObject1).EeS.setVisibility(8);
                ((com.tencent.mm.plugin.sns.ui.at)localObject1).Ewv.setVisibility(0);
                ((com.tencent.mm.plugin.sns.ui.at)localObject1).Ewv.gYN();
                aj.faL().A(localcnb);
                paramAnonymousView = aj.faJ();
                localObject1 = bp.gCZ();
                ((bp)localObject1).hXs = localTimeLineObject.CreateTime;
                paramAnonymousView.a(localcnb, 4, null, (bp)localObject1);
                if (bool) {
                  o.a(o.b.DwB, o.a.Dws, localSnsInfo, c.this.source);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203963);
                return;
              }
            }
            if ((localSnsInfo.isAd()) && (localSnsInfo.getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(localSnsInfo.getAdSnsInfo().field_adxml))) {}
            int j;
            Object localObject3;
            for (int i = 1; (i == 0) && (bool) && (aj.faL().v(localcnb)); i = 0)
            {
              aj.faL().A(localcnb);
              ((com.tencent.mm.plugin.sns.ui.at)localObject1).EeS.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.at)localObject1).Ewv.setVisibility(8);
              paramAnonymousView = aj.faL();
              localObject2 = ((com.tencent.mm.plugin.sns.ui.at)localObject1).Ews;
              i = c.this.activity.hashCode();
              j = ((com.tencent.mm.plugin.sns.ui.at)localObject1).position;
              localObject3 = bp.gCZ();
              ((bp)localObject3).hXs = localTimeLineObject.CreateTime;
              paramAnonymousView.a(localSnsInfo, localcnb, (VideoSightView)localObject2, i, j, (bp)localObject3, bool);
              ((com.tencent.mm.plugin.sns.ui.at)localObject1).Ews.start();
              if (bool) {
                o.a(o.b.DwB, o.a.Dws, localSnsInfo, c.this.source);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(203963);
              return;
            }
            com.tencent.mm.modelsns.k localk;
            label748:
            int m;
            label801:
            label822:
            int k;
            label837:
            label881:
            Object localObject4;
            if (c.this.source == 0)
            {
              localObject2 = com.tencent.mm.modelsns.k.tO(717);
              ((com.tencent.mm.modelsns.k)localObject2).PH(r.v(localSnsInfo)).tR(localSnsInfo.field_type).fL(localSnsInfo.isAd()).PH(localSnsInfo.getUxinfo()).PH(localcnb.Id);
              ((com.tencent.mm.modelsns.k)localObject2).bfK();
              if (c.this.source != 0) {
                break label1544;
              }
              localk = com.tencent.mm.modelsns.k.tO(745);
              localk.PH(r.v(localSnsInfo)).tR(localSnsInfo.field_type).fL(localSnsInfo.isAd());
              if (bool)
              {
                m = c.this.source;
                if (c.this.source != 0) {
                  break label1555;
                }
                i = 1;
                long l = localSnsInfo.field_snsId;
                if (!localSnsInfo.getAdXml().isLandingPagesAd()) {
                  break label1560;
                }
                j = 21;
                if (!localSnsInfo.getAdXml().isLandingPagesAd()) {
                  break label1566;
                }
                k = 21;
                localObject2 = new SnsAdClick(m, i, l, j, k);
                if (!localSnsInfo.getAdXml().isLandingPagesAd()) {
                  break label1572;
                }
                com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, c.this.EBv, localSnsInfo, 21);
                r.a((SnsAdClick)localObject2);
                if ((!localSnsInfo.getAdXml().isLandingPagesAd()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(localSnsInfo.getAdSnsInfo().field_adxml))) {
                  o.a(o.b.DwB, o.a.Dwt, localSnsInfo, c.this.source);
                }
              }
              localObject2 = "";
              localObject4 = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), localcnb.Id);
              localObject3 = "";
              String str = r.j(localcnb);
              if (com.tencent.mm.vfs.s.YS((String)localObject4 + str))
              {
                localObject2 = (String)localObject4 + str;
                localObject3 = (String)localObject4 + r.e(localcnb);
              }
              if (com.tencent.mm.vfs.s.YS((String)localObject4 + r.p(localcnb)))
              {
                localObject2 = (String)localObject4 + r.p(localcnb);
                localObject3 = (String)localObject4 + r.n(localcnb);
              }
              localObject4 = new int[2];
              if (!com.tencent.mm.ui.ao.gJK()) {
                break label1591;
              }
              paramAnonymousView.getLocationOnScreen((int[])localObject4);
            }
            for (;;)
            {
              i = paramAnonymousView.getWidth();
              j = paramAnonymousView.getHeight();
              com.tencent.mm.plugin.report.service.h.CyF.a(11444, new Object[] { Integer.valueOf(3) });
              if (bool) {
                break label1600;
              }
              Log.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
              paramAnonymousView = new Intent();
              paramAnonymousView.setClass(c.this.activity, SnsOnlineVideoActivity.class);
              paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
              paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
              paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.at)localObject1).dHp);
              paramAnonymousView.putExtra("intent_isad", bool);
              paramAnonymousView.putExtra("intent_from_scene", c.this.source);
              paramAnonymousView.putExtra("sns_video_scene", ((com.tencent.mm.plugin.sns.ui.at)localObject1).Ewx);
              localObject2 = com.tencent.mm.plugin.sns.ui.video.d.fkS().aRx(localTimeLineObject.Id);
              if ((localObject2 != null) && (((SnsTimelineVideoView)localObject2).isPlaying()))
              {
                paramAnonymousView.putExtra("intent_fromplayingvideo", true);
                paramAnonymousView.putExtra("intent_fromplayingvideo_tlobjid", localTimeLineObject.Id);
                paramAnonymousView.putExtra("intent_session_id", ((SnsTimelineVideoView)localObject2).getSessionId());
                paramAnonymousView.putExtra("intent_session_timestamp", ((SnsTimelineVideoView)localObject2).getSessionTimestamp());
                if (((com.tencent.mm.plugin.sns.ui.at)localObject1).Ewr != null) {
                  ((com.tencent.mm.plugin.sns.ui.at)localObject1).Ewr.findViewById(2131309074).setVisibility(0);
                }
              }
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              localk.b(paramAnonymousView, "intent_key_StatisticsOplog");
              localObject1 = c.this.activity;
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Activity)localObject1).startActivity((Intent)paramAnonymousView.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              c.this.activity.overridePendingTransition(0, 0);
              c.a(c.this, localSnsInfo.getTimeLine());
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(203963);
              return;
              localObject2 = com.tencent.mm.modelsns.k.tP(717);
              break;
              label1544:
              localk = com.tencent.mm.modelsns.k.tP(745);
              break label748;
              label1555:
              i = 2;
              break label801;
              label1560:
              j = 17;
              break label822;
              label1566:
              k = 0;
              break label837;
              label1572:
              com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, c.this.EBv, localSnsInfo, 17);
              break label881;
              label1591:
              paramAnonymousView.getLocationInWindow((int[])localObject4);
            }
            label1600:
            if ((localSnsInfo.isAd()) && (localSnsInfo.getAdXml().isLandingPagesAd()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aQg(localSnsInfo.getAdSnsInfo().field_adxml)))
            {
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Q(localSnsInfo);
              if (!Util.isNullOrNil(paramAnonymousView)) {
                localSnsInfo.getAdSnsInfo().field_adxml = paramAnonymousView;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localSnsInfo.getSnsId());
              paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localSnsInfo.getTimeLine().Id);
              paramAnonymousView.putExtra("sns_landing_pages_ux_info", localSnsInfo.getUxinfo());
              localObject1 = localSnsInfo.getTimeLine();
              if (localObject1 != null)
              {
                localObject1 = ((TimeLineObject)localObject1).ContentObj.LoV;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((cnb)((List)localObject1).get(0)).Msz);
                }
              }
              c.a(c.this, paramAnonymousView, localSnsInfo);
              paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
              i = 1;
              if (c.this.source == 2) {
                i = 16;
              }
              for (;;)
              {
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", localSnsInfo.getAdSnsInfo().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", localSnsInfo.getAdRecSrc());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                if (!localSnsInfo.getAdXml().forbiddenCustomAnimation)
                {
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                  paramAnonymousView.putExtra("sns_landing_pages_is_normal_ad_animation", true);
                }
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject1 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                if (!localSnsInfo.getAdXml().forbiddenCustomAnimation) {
                  c.this.activity.overridePendingTransition(0, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203963);
                return;
                if (c.this.source == 1) {
                  i = 2;
                }
              }
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(c.this.activity, SnsSightPlayerUI.class);
            paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
            paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
            paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.at)localObject1).dHp);
            paramAnonymousView.putExtra("intent_isad", bool);
            paramAnonymousView.putExtra("intent_from_scene", c.this.source);
            paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
            paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
            paramAnonymousView.putExtra("img_gallery_width", i);
            paramAnonymousView.putExtra("img_gallery_height", j);
            localk.b(paramAnonymousView, "intent_key_StatisticsOplog");
            Object localObject2 = c.this.activity;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramAnonymousView.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject2).startActivity((Intent)paramAnonymousView.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            c.this.activity.overridePendingTransition(0, 0);
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(203962);
                if (aj.faL().v(localcnb))
                {
                  this.Fbq.Ews.e(null, false, 0);
                  com.tencent.mm.plugin.sns.model.g localg = aj.faL();
                  SnsInfo localSnsInfo = localSnsInfo;
                  cnb localcnb = localcnb;
                  VideoSightView localVideoSightView = this.Fbq.Ews;
                  int i = c.this.activity.hashCode();
                  int j = this.Fbq.position;
                  bp localbp = bp.gCZ();
                  localbp.hXs = localTimeLineObject.CreateTime;
                  localg.a(localSnsInfo, localcnb, localVideoSightView, i, j, localbp, bool);
                  this.Fbq.Ews.start();
                  this.Fbq.EeS.setVisibility(0);
                  this.Fbq.Ewv.setVisibility(8);
                  this.Fbq.EeS.setImageDrawable(com.tencent.mm.cb.a.l(c.this.activity, 2131691480));
                }
                AppMethodBeat.o(203962);
              }
            }, 500L);
            paramAnonymousView = new int[3];
            if ((!bool) && (aj.faL().a(localSnsInfo, paramAnonymousView) > 5))
            {
              aj.faL().z(localcnb);
              i = 1;
            }
            label2954:
            for (;;)
            {
              label2350:
              int n = paramAnonymousView[0];
              int i1 = paramAnonymousView[1];
              if (i == 2) {}
              for (m = 1;; m = 0)
              {
                for (;;)
                {
                  int i2 = paramAnonymousView[2];
                  paramAnonymousView = localSnsInfo.getTimeLine();
                  localObject1 = new com.tencent.mm.modelsns.m();
                  ((com.tencent.mm.modelsns.m)localObject1).n("20FeedId", paramAnonymousView.Id + ",");
                  ((com.tencent.mm.modelsns.m)localObject1).n("21AdUxInfo", localSnsInfo.getUxinfo() + ",");
                  for (;;)
                  {
                    try
                    {
                      paramAnonymousView = (SnsObject)new SnsObject().parseFrom(localSnsInfo.field_attrBuf);
                      if (paramAnonymousView.ObjectOperations == null) {
                        continue;
                      }
                      paramAnonymousView = (eaj)new eaj().parseFrom(paramAnonymousView.ObjectOperations.getBufferToBytes());
                      if (paramAnonymousView.MZL == null) {
                        continue;
                      }
                      k = paramAnonymousView.MZL.Lqt;
                    }
                    catch (Exception paramAnonymousView)
                    {
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
                      j = paramAnonymousView.MZL.Lqu;
                      ((com.tencent.mm.modelsns.m)localObject1).n("22LayerId", k + ",");
                      ((com.tencent.mm.modelsns.m)localObject1).n("23ExpId", j + ",");
                      ((com.tencent.mm.modelsns.m)localObject1).n("24ClickState", i + ",");
                      ((com.tencent.mm.modelsns.m)localObject1).n("25ClickTime", Util.nowSecond() + ",");
                      i = 0;
                      if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                        continue;
                      }
                      i = 1;
                      ((com.tencent.mm.modelsns.m)localObject1).n("26NetworkType", i + ",");
                      ((com.tencent.mm.modelsns.m)localObject1).n("27IsFlowControl", n + ",");
                      ((com.tencent.mm.modelsns.m)localObject1).n("28AutoDownloadSetting", i1 + ",");
                      ((com.tencent.mm.modelsns.m)localObject1).n("29IsAutoPlay", m + ",");
                      ((com.tencent.mm.modelsns.m)localObject1).n("30IsFlowControlDatePeriod", i2 + ",");
                      Log.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + ((com.tencent.mm.modelsns.m)localObject1).abW());
                      com.tencent.mm.plugin.report.service.h.CyF.a(13323, new Object[] { localObject1 });
                    }
                    catch (Exception paramAnonymousView) {}
                  }
                }
                if ((!bool) || (aj.faL().b(localSnsInfo, paramAnonymousView) <= 5)) {
                  break label2954;
                }
                aj.faL().z(localcnb);
                i = 1;
                break label2350;
              }
            }
          }
          localObject1 = null;
        }
      }
    };
    this.FaH = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(203964);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.at))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.at)paramAnonymousView.getTag();
          if (!paramAnonymousView.isAd) {
            paramAnonymousContextMenu.add(0, 19, 0, c.this.activity.getString(2131757439));
          }
          if (Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("SIGHTCannotTransmitForFav")) != 0) {
            break label308;
          }
          if (paramAnonymousView.Ewq.ContentObj.LoV.size() <= 0) {
            break label301;
          }
          paramAnonymousContextMenuInfo = (cnb)paramAnonymousView.Ewq.ContentObj.LoV.get(0);
          String str = paramAnonymousContextMenuInfo.Id;
          str = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), str) + r.e(paramAnonymousContextMenuInfo);
          paramAnonymousContextMenuInfo = ay.a(paramAnonymousView.dHp, paramAnonymousContextMenuInfo);
          boolean bool1 = com.tencent.mm.vfs.s.YS(str);
          boolean bool2 = com.tencent.mm.vfs.s.YS(paramAnonymousContextMenuInfo);
          Log.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool1) || (!bool2)) {
            break label308;
          }
        }
        label301:
        label308:
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.br.c.aZU("favorite")) {
            paramAnonymousContextMenu.add(0, 10, 0, c.this.activity.getString(2131763947));
          }
          if (i != 0)
          {
            paramAnonymousContextMenuInfo = new ef();
            paramAnonymousContextMenuInfo.dHy.dHp = paramAnonymousView.dHp;
            EventCenter.instance.publish(paramAnonymousContextMenuInfo);
            if (paramAnonymousContextMenuInfo.dHz.dGX) {
              paramAnonymousContextMenu.add(0, 18, 0, c.this.activity.getString(2131755922));
            }
          }
          AppMethodBeat.o(203964);
          return;
          Log.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
        }
      }
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(203965);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.at))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.at)paramAnonymousView.getTag()).dHp;
          SnsInfo localSnsInfo = aj.faO().aQm(str);
          c.this.Far.a(paramAnonymousView, str, localSnsInfo.getTimeLine());
          AppMethodBeat.o(203965);
          return true;
        }
        AppMethodBeat.o(203965);
        return false;
      }
    };
    this.FaS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203966);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        c.this.fs(paramAnonymousView);
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.c)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203966);
          return;
        }
        localObject = (com.tencent.mm.plugin.sns.data.c)paramAnonymousView.getTag();
        paramAnonymousView = aj.faO().aQm(((com.tencent.mm.plugin.sns.data.c)localObject).dHp);
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203966);
          return;
        }
        int j;
        if (paramAnonymousView.isAd())
        {
          ((com.tencent.mm.plugin.sns.data.c)localObject).DDs = System.currentTimeMillis();
          j = c.this.source;
          if (c.this.source != 0) {
            break label214;
          }
        }
        label214:
        for (int i = 1;; i = 2)
        {
          localObject = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 20, 0);
          com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject, c.this.EBv, paramAnonymousView, 20);
          r.a((SnsAdClick)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203966);
          return;
        }
      }
    };
    this.FaZ = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100244);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        Log.i("MicroMsg.TimelineClickListener", "unlike click");
        if (!(paramAnonymousAdapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c))
        {
          Log.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(100244);
          return;
        }
        Object localObject2 = (com.tencent.mm.plugin.sns.data.c)paramAnonymousView.getTag();
        SnsInfo localSnsInfo = aj.faO().aQm(((com.tencent.mm.plugin.sns.data.c)localObject2).dHp);
        if (localSnsInfo == null) {
          try
          {
            c.this.ffy();
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
              ((com.tencent.mm.plugin.sns.b.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sns.b.d.class)).a(11855, localSnsInfo.getAdRecSrc(), new Object[] { Integer.valueOf(3), localObject1, Integer.valueOf(localSnsInfo.getAdRecSrc()) });
            }
          }
          else
          {
            if (!((com.tencent.mm.plugin.sns.data.c)localObject2).DDr.EQZ.adUnlikeInfo.fcI()) {
              break label404;
            }
            paramAnonymousView = (com.tencent.mm.plugin.sns.ui.c)paramAnonymousAdapterView.getAdapter();
            paramAnonymousView.lCq += 1;
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousAdapterView.setOnItemClickListener(c.this.Fba);
            c.this.ffx();
            paramAnonymousAdapterView = new ADInfo.c.a();
            paramAnonymousAdapterView.DWd = ADInfo.c.a.DVZ;
            paramAnonymousAdapterView.DDs = ((com.tencent.mm.plugin.sns.data.c)localObject2).DDs;
            paramAnonymousAdapterView.DWe = 0L;
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.s(localSnsInfo.field_snsId, 8, paramAnonymousAdapterView);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(paramAnonymousAdapterView, 0);
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
          if (((com.tencent.mm.plugin.sns.data.c)localObject2).DDr.EQZ.forbidClick)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          c.this.ft(paramAnonymousView);
          paramAnonymousAdapterView = new ADInfo.c.a();
          paramAnonymousAdapterView.DDs = ((com.tencent.mm.plugin.sns.data.c)localObject2).DDs;
          paramAnonymousAdapterView.DWe = System.currentTimeMillis();
          paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.s(localSnsInfo.field_snsId, 8, paramAnonymousAdapterView);
          com.tencent.mm.kernel.g.aAi();
          com.tencent.mm.kernel.g.aAg().hqi.a(paramAnonymousAdapterView, 0);
          continue;
          if (((com.tencent.mm.plugin.sns.data.c)localObject2).DDr.EQY.adFeedbackInfo == null)
          {
            Log.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          paramAnonymousAdapterView = ((com.tencent.mm.plugin.sns.data.c)localObject2).DDr.EQY.adFeedbackInfo;
          paramAnonymousInt -= 1;
          if (paramAnonymousInt < paramAnonymousAdapterView.list.size()) {
            paramAnonymousAdapterView = ((ADXml.f)paramAnonymousAdapterView.list.get(paramAnonymousInt)).url;
          }
          try
          {
            paramAnonymousView = String.format("snsid=%s", new Object[] { localSnsInfo.getTimeLine().Id });
            localObject1 = String.format("aid=%s", new Object[] { localSnsInfo.getAid() });
            localObject2 = String.format("traceid=%s", new Object[] { localSnsInfo.getTraceid() });
            com.tencent.mm.kernel.g.aAf();
            paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.n(paramAnonymousAdapterView, new String[] { paramAnonymousView, localObject1, localObject2, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.ayV() }) });
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
          paramAnonymousView.putExtra("KPublisherId", "sns_" + r.Jb(localSnsInfo.field_snsId));
          paramAnonymousView.putExtra("pre_username", localSnsInfo.field_userName);
          paramAnonymousView.putExtra("prePublishId", "sns_" + r.Jb(localSnsInfo.field_snsId));
          paramAnonymousView.putExtra("preUsername", localSnsInfo.field_userName);
          com.tencent.mm.plugin.sns.c.a.jRt.i(paramAnonymousView, c.this.activity);
        }
      }
    };
    this.Fba = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(203967);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.c)))
        {
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.data.c)paramAnonymousView.getTag();
          if (paramAnonymousInt < paramAnonymousAdapterView.DDr.EQZ.adUnlikeInfo.fcH().size())
          {
            if (paramAnonymousAdapterView.DDr.EQZ.forbidClick)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(203967);
              return;
            }
            localObject = (ADInfo.c.a)paramAnonymousAdapterView.DDr.EQZ.adUnlikeInfo.fcH().get(paramAnonymousInt);
            Log.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[] { ((ADInfo.c.a)localObject).DWa, Integer.valueOf(((ADInfo.c.a)localObject).DWd) });
            SnsInfo localSnsInfo = aj.faO().aQm(paramAnonymousAdapterView.dHp);
            if (localSnsInfo == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(203967);
              return;
            }
            c.this.ft(paramAnonymousView);
            ((ADInfo.c.a)localObject).DDs = paramAnonymousAdapterView.DDs;
            ((ADInfo.c.a)localObject).DWe = System.currentTimeMillis();
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.s(localSnsInfo.field_snsId, 8, localObject);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a(paramAnonymousAdapterView, 0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(203967);
      }
    };
    this.FaY = new c.30(this);
    this.Fbd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203968);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if ((paramAnonymousView.getTag() == null) || ((!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bc)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.at)) && (!(paramAnonymousView.getTag() instanceof MaskImageView)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203968);
          return;
        }
        localObject1 = null;
        int m = 0;
        int j = 0;
        int n = 0;
        int k = 0;
        int i = 0;
        Object localObject3;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bc))
        {
          localObject3 = com.tencent.mm.plugin.sns.storage.f.aQm(((com.tencent.mm.plugin.sns.ui.bc)paramAnonymousView.getTag()).dJX);
          if ((paramAnonymousView instanceof LinearLayout))
          {
            i = 0;
            if (!((com.tencent.mm.plugin.sns.ui.bc)paramAnonymousView.getTag()).Ewy) {
              break label5018;
            }
            k = ((com.tencent.mm.plugin.sns.ui.bc)paramAnonymousView.getTag()).index;
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
            AppMethodBeat.o(203968);
            return;
            i = 1;
            break;
            label238:
            j = 1;
            continue;
            if ((paramAnonymousView.getTag() instanceof MaskImageView))
            {
              localObject3 = (MaskImageView)paramAnonymousView.getTag();
              if (!(((MaskImageView)localObject3).getTag() instanceof com.tencent.mm.plugin.sns.ui.bc)) {
                break label5013;
              }
              localObject3 = com.tencent.mm.plugin.sns.storage.f.aQm(((com.tencent.mm.plugin.sns.ui.bc)((MaskImageView)localObject3).getTag()).dJX);
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
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.at))
            {
              localObject1 = (com.tencent.mm.plugin.sns.ui.at)paramAnonymousView.getTag();
              localObject3 = aj.faO().aQm(((com.tencent.mm.plugin.sns.ui.at)localObject1).dHp);
              if ((paramAnonymousView instanceof LinearLayout))
              {
                j = 0;
                label368:
                if (!((com.tencent.mm.plugin.sns.ui.at)localObject1).Ewy) {
                  break label5004;
                }
                k = ((com.tencent.mm.plugin.sns.ui.at)localObject1).Ewz;
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
                localObject1 = com.tencent.mm.plugin.sns.storage.f.aQl(((BaseTimeLineItem.BaseViewHolder)localObject3).dRS);
                if (!(localObject3 instanceof p.b)) {
                  break label4999;
                }
                j = ((p.b)localObject3).EZF.index;
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
                if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))
                {
                  localObject3 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).DsC;
                  localObject1 = localObject3;
                  j = n;
                  if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.f))
                  {
                    j = ((com.tencent.mm.plugin.sns.ui.c.a.f)paramAnonymousView.getTag()).currentIndex;
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
                          localObject5 = com.tencent.mm.plugin.report.service.h.CyF;
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
                        localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject4).EUK;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).EUK;
                        continue;
                        if (c.this.Epj == null) {
                          continue;
                        }
                        c.this.Epj.fat().M((SnsInfo)localObject3);
                        boolean bool = ((SnsInfo)localObject3).isAd();
                        if ((((TimeLineObject)localObject6).ContentObj.LoV != null) && (((TimeLineObject)localObject6).ContentObj.LoV.size() != 0)) {
                          continue;
                        }
                        Log.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203968);
                        return;
                        cnb localcnb = (cnb)((TimeLineObject)localObject6).ContentObj.LoV.get(k);
                        if (!bool) {
                          continue;
                        }
                        aj.faL();
                        if ((com.tencent.mm.plugin.sns.model.g.u(localcnb)) || (localObject2 == null)) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.at)localObject2).EeS.setVisibility(8);
                        ((com.tencent.mm.plugin.sns.ui.at)localObject2).Ewv.setVisibility(0);
                        ((com.tencent.mm.plugin.sns.ui.at)localObject2).Ewv.gYN();
                        aj.faL().A(localcnb);
                        paramAnonymousView = aj.faJ();
                        localObject2 = bp.gCZ();
                        ((bp)localObject2).hXs = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a(localcnb, 4, null, (bp)localObject2);
                        if (!bool) {
                          continue;
                        }
                        o.a(o.b.DwB, o.a.Dws, (SnsInfo)localObject3, c.this.source);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203968);
                        return;
                        if ((!((SnsInfo)localObject3).isAd()) || (!((SnsInfo)localObject3).getAdXml().isLandingPagesAd())) {
                          continue;
                        }
                        String str = ((SnsInfo)localObject3).getAdSnsInfo().field_adxml;
                        if (k <= 0) {
                          continue;
                        }
                        Object localObject5 = "adTurnCanvasInfo";
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.kG(str, (String)localObject5)) {
                          continue;
                        }
                        m = 1;
                        if ((m != 0) || (!bool) || (!aj.faL().v(localcnb)) || (localObject2 == null)) {
                          continue;
                        }
                        aj.faL().A(localcnb);
                        ((com.tencent.mm.plugin.sns.ui.at)localObject2).EeS.setVisibility(8);
                        ((com.tencent.mm.plugin.sns.ui.at)localObject2).Ewv.setVisibility(8);
                        paramAnonymousView = aj.faL();
                        Object localObject4 = ((com.tencent.mm.plugin.sns.ui.at)localObject2).Ews;
                        i = c.this.activity.hashCode();
                        j = ((com.tencent.mm.plugin.sns.ui.at)localObject2).position;
                        localObject5 = bp.gCZ();
                        ((bp)localObject5).hXs = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a((SnsInfo)localObject3, localcnb, (VideoSightView)localObject4, i, j, (bp)localObject5, bool);
                        ((com.tencent.mm.plugin.sns.ui.at)localObject2).Ews.start();
                        if (!bool) {
                          continue;
                        }
                        o.a(o.b.DwB, o.a.Dws, (SnsInfo)localObject3, c.this.source);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203968);
                        return;
                        localObject5 = "adCanvasInfo";
                        continue;
                        m = 0;
                        continue;
                        if (c.this.source != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.k.tO(717);
                        ((com.tencent.mm.modelsns.k)localObject2).PH(r.v((SnsInfo)localObject3)).tR(((SnsInfo)localObject3).field_type).fL(((SnsInfo)localObject3).isAd()).PH(((SnsInfo)localObject3).getUxinfo()).PH(localcnb.Id);
                        ((com.tencent.mm.modelsns.k)localObject2).bfK();
                        if (c.this.source != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.k.tO(745);
                        ((com.tencent.mm.modelsns.k)localObject2).PH(r.v((SnsInfo)localObject3)).tR(((SnsInfo)localObject3).field_type).fL(((SnsInfo)localObject3).isAd());
                        localObject2 = new int[2];
                        if (localObject4 == null) {
                          continue;
                        }
                        if (((BaseTimeLineItem.BaseViewHolder)localObject4).EUK.Ewu == null) {
                          continue;
                        }
                        ((BaseTimeLineItem.BaseViewHolder)localObject4).EUK.Ewu.getLocationInWindow((int[])localObject2);
                        j = ((BaseTimeLineItem.BaseViewHolder)localObject4).EUK.Ewu.getWidth();
                        i = ((BaseTimeLineItem.BaseViewHolder)localObject4).EUK.Ewu.getHeight();
                        com.tencent.mm.plugin.report.service.h.CyF.a(11444, new Object[] { Integer.valueOf(3) });
                        localObject4 = c.a(c.this, (SnsInfo)localObject3);
                        if (!com.tencent.mm.plugin.sns.data.k.a(c.this.activity, (SnsInfo)localObject3, (ADInfo)localObject4, c.this.source, c.this.EBv)) {
                          continue;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203968);
                        return;
                        localObject2 = com.tencent.mm.modelsns.k.tP(717);
                        continue;
                        localObject2 = com.tencent.mm.modelsns.k.tP(745);
                        continue;
                        if (((TimeLineObject)localObject6).ContentObj.LoU != 27) {
                          continue;
                        }
                        ((p.b)localObject4).EZD.getLocationInWindow((int[])localObject2);
                        j = ((p.b)localObject4).EZD.getWidth();
                        i = ((p.b)localObject4).EZD.getHeight();
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.at)) {
                          continue;
                        }
                        localObject4 = (com.tencent.mm.plugin.sns.ui.at)paramAnonymousView.getTag();
                        if (localObject4 == null) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.at)localObject4).Ewu.getLocationInWindow((int[])localObject2);
                        j = ((com.tencent.mm.plugin.sns.ui.at)localObject4).Ewu.getWidth();
                        i = ((com.tencent.mm.plugin.sns.ui.at)localObject4).Ewu.getHeight();
                        continue;
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView.getLocationInWindow((int[])localObject2);
                        j = paramAnonymousView.getWidth();
                        i = paramAnonymousView.getHeight();
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
                        com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.EBv, (SnsInfo)localObject3, 22);
                        r.a(paramAnonymousView);
                        localObject4 = new Intent();
                        ((Intent)localObject4).putExtra("img_gallery_left", localObject2[0]);
                        ((Intent)localObject4).putExtra("img_gallery_top", localObject2[1]);
                        ((Intent)localObject4).putExtra("img_gallery_width", j);
                        ((Intent)localObject4).putExtra("img_gallery_height", i);
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_sns_id", ((SnsInfo)localObject3).getSnsId());
                        ((Intent)localObject4).putExtra("sns_landing_pages_rawSnsId", ((SnsInfo)localObject3).getTimeLine().Id);
                        ((Intent)localObject4).putExtra("sns_landing_pages_ux_info", ((SnsInfo)localObject3).getUxinfo());
                        paramAnonymousView = ((SnsInfo)localObject3).getTimeLine();
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView = paramAnonymousView.ContentObj.LoV;
                        if (paramAnonymousView.size() <= k) {
                          continue;
                        }
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_thumb_url", ((cnb)paramAnonymousView.get(k)).Msz);
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
                        if (((SnsInfo)localObject3).getAdXml().forbiddenCustomAnimation) {
                          continue;
                        }
                        ((Intent)localObject4).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        ((Intent)localObject4).putExtra("sns_landing_is_native_sight_ad", true);
                        paramAnonymousView = c.this.activity;
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject4);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        if (((SnsInfo)localObject3).getAdXml().forbiddenCustomAnimation) {
                          continue;
                        }
                        c.this.activity.overridePendingTransition(0, 0);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203968);
                        return;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        c.this.a((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag(), null);
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
                          com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI().a(c.this.source, (SnsInfo)localObject3);
                          j = c.this.source;
                          if (c.this.source == 0)
                          {
                            i = 1;
                            paramAnonymousView = new SnsAdClick(j, i, ((SnsInfo)localObject3).field_snsId, 22, 31);
                            com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.EBv, (SnsInfo)localObject3, 22);
                            r.a(paramAnonymousView);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(203968);
                            return;
                            bool = false;
                            continue;
                          }
                          i = 2;
                          continue;
                          try
                          {
                            localObject2 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(4, c.this.activity);
                            if (localObject2 != null)
                            {
                              localObject4 = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
                              ((com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject4).put("snsAdStatistic", c.this.EBv);
                              bool = ((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject2).a(paramAnonymousView, c.this.source, (SnsInfo)localObject3, (com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject4);
                              if (bool)
                              {
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(203968);
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
                              com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject4, c.this.EBv, (SnsInfo)localObject3, 22);
                              r.a((SnsAdClick)localObject4);
                              if (k > 0)
                              {
                                localObject2 = ((SnsInfo)localObject3).getAdXml().adTurnInfo.adActionLink;
                                paramAnonymousView = (View)localObject2;
                                if (Util.isNullOrNil((String)localObject2)) {
                                  paramAnonymousView = ((SnsInfo)localObject3).getAdLink();
                                }
                                if (!Util.isNullOrNil(paramAnonymousView)) {
                                  continue;
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(203968);
                              }
                            }
                            else
                            {
                              i = 2;
                              continue;
                            }
                            localObject2 = ((SnsInfo)localObject3).getAdInfoLink();
                            continue;
                            Log.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((SnsInfo)localObject3).getAdXml().webrightBar);
                            localObject5 = new Intent();
                            if (((SnsInfo)localObject3).getAdXml().webrightBar != 0) {
                              continue;
                            }
                          }
                          bool = true;
                          if (ac.jOL) {
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
                                localObject2 = com.tencent.mm.plugin.sns.ad.d.a.a.aND(r.kb(paramAnonymousView, ((ADInfo)localObject6).uxInfo));
                                r.h((Intent)localObject5, ((ADInfo)localObject6).uxInfo);
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
                          ((Intent)localObject5).putExtra("KPublisherId", "sns_" + r.Jb(((SnsInfo)localObject3).field_snsId));
                          ((Intent)localObject5).putExtra("pre_username", ((SnsInfo)localObject3).field_userName);
                          ((Intent)localObject5).putExtra("prePublishId", "sns_" + r.Jb(((SnsInfo)localObject3).field_snsId));
                          ((Intent)localObject5).putExtra("preUsername", ((SnsInfo)localObject3).field_userName);
                          com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject5, c.this.activity);
                          continue;
                          bool = false;
                          continue;
                          if (((((TimeLineObject)localObject6).ContentObj.LoU != 1) || (((TimeLineObject)localObject6).ContentObj.LoV.size() != 1)) && (((TimeLineObject)localObject6).ContentObj.LoU != 7) && ((((TimeLineObject)localObject6).ContentObj.LoU != 27) || (((TimeLineObject)localObject6).ContentObj.LoV.size() <= k) || (((cnb)((TimeLineObject)localObject6).ContentObj.LoV.get(k)).oUv != 2))) {
                            continue;
                          }
                          localObject2 = c.a(c.this, (SnsInfo)localObject3);
                          if (com.tencent.mm.plugin.sns.data.k.a(c.this.activity, (SnsInfo)localObject3, (ADInfo)localObject2, c.this.source, c.this.EBv))
                          {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(203968);
                            return;
                          }
                          if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
                          {
                            localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.a.a))
                            {
                              localObject2 = ((com.tencent.mm.plugin.sns.ui.item.a.a)paramAnonymousView.getTag()).EVm;
                              if (!((SnsInfo)localObject3).getAdXml().isLandingPagesAd()) {
                                continue;
                              }
                              localObject5 = ((SnsInfo)localObject3).getAdSnsInfo().field_adxml;
                              if (k > 0)
                              {
                                localObject4 = "adTurnCanvasInfo";
                                if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.kG((String)localObject5, (String)localObject4)) {
                                  continue;
                                }
                                m = c.this.source;
                                if (c.this.source != 0) {
                                  continue;
                                }
                                j = 1;
                                localObject4 = new SnsAdClick(m, j, ((SnsInfo)localObject3).field_snsId, 21, i, (byte)0);
                                com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject4, c.this.EBv, (SnsInfo)localObject3, 22);
                                r.a((SnsAdClick)localObject4);
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
                                  paramAnonymousView = paramAnonymousView.ContentObj.LoV;
                                  if (paramAnonymousView.size() <= k) {
                                    continue;
                                  }
                                  ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((cnb)paramAnonymousView.get(k)).Msz);
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
                                if (!((SnsInfo)localObject3).getAdXml().forbiddenCustomAnimation) {
                                  ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                }
                                paramAnonymousView = c.this.activity;
                                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
                                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                if (!((SnsInfo)localObject3).getAdXml().forbiddenCustomAnimation) {
                                  c.this.activity.overridePendingTransition(0, 0);
                                }
                                if (c.this.Epj == null) {
                                  continue;
                                }
                                c.this.Epj.fat().M((SnsInfo)localObject3);
                              }
                            }
                            else
                            {
                              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.f.a))
                              {
                                localObject2 = ((com.tencent.mm.plugin.sns.ui.item.f.a)paramAnonymousView.getTag()).EVm;
                                continue;
                              }
                              if ((localObject2 instanceof p.b))
                              {
                                localObject2 = (TagImageView)((p.b)localObject2).EZF.view;
                                continue;
                              }
                              if ((paramAnonymousView.getTag() instanceof n.a))
                              {
                                localObject2 = ((n.a)paramAnonymousView.getTag()).EZp;
                                continue;
                              }
                              localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject2).EWX.ZD(0);
                              continue;
                            }
                          }
                          else
                          {
                            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))
                            {
                              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b))
                              {
                                localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).EUS;
                                continue;
                              }
                              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
                              {
                                localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.c)paramAnonymousView.getTag()).EVm;
                                continue;
                              }
                              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.f))
                              {
                                localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.f)paramAnonymousView.getTag()).contentView;
                                continue;
                              }
                              if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.d)) {
                                continue;
                              }
                              localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.d)paramAnonymousView.getTag()).contentView;
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
                          if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                            continue;
                          }
                          c.this.a((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag(), null);
                          continue;
                          if (paramAnonymousView.size() <= 0) {
                            continue;
                          }
                          ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((cnb)paramAnonymousView.get(0)).Msz);
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
                            com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI().a(c.this.source, (SnsInfo)localObject3);
                            k = c.this.source;
                            if (c.this.source == 0)
                            {
                              j = 1;
                              paramAnonymousView = new SnsAdClick(k, j, ((SnsInfo)localObject3).field_snsId, 31, i, (byte)0);
                              com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.EBv, (SnsInfo)localObject3, 22);
                              r.a(paramAnonymousView);
                              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                              AppMethodBeat.o(203968);
                              return;
                              bool = false;
                              continue;
                            }
                            j = 2;
                            continue;
                            try
                            {
                              localObject2 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(4, c.this.activity);
                              if (localObject2 != null)
                              {
                                localObject4 = new com.tencent.mm.plugin.sns.ad.timeline.a.d("flipStatus", Integer.valueOf(i));
                                ((com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject4).put("snsAdStatistic", c.this.EBv);
                                bool = ((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject2).a(paramAnonymousView, c.this.source, (SnsInfo)localObject3, (com.tencent.mm.plugin.sns.ad.timeline.a.d)localObject4);
                                if (bool)
                                {
                                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                  AppMethodBeat.o(203968);
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
                                if (Util.isNullOrNil(paramAnonymousView))
                                {
                                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                  AppMethodBeat.o(203968);
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
                                com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject4, c.this.EBv, (SnsInfo)localObject3, 22);
                                r.a((SnsAdClick)localObject4);
                                Log.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((SnsInfo)localObject3).getAdXml().webrightBar);
                                localObject5 = new Intent();
                                if (((SnsInfo)localObject3).getAdXml().webrightBar == 0)
                                {
                                  bool = true;
                                  if (ac.jOL) {
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
                                        localObject2 = com.tencent.mm.plugin.sns.ad.d.a.a.aND(r.kb(paramAnonymousView, ((ADInfo)localObject6).uxInfo));
                                        r.h((Intent)localObject5, ((ADInfo)localObject6).uxInfo);
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
                                  ((Intent)localObject5).putExtra("KPublisherId", "sns_" + r.Jb(((SnsInfo)localObject3).field_snsId));
                                  ((Intent)localObject5).putExtra("pre_username", ((SnsInfo)localObject3).field_userName);
                                  ((Intent)localObject5).putExtra("prePublishId", "sns_" + r.Jb(((SnsInfo)localObject3).field_snsId));
                                  ((Intent)localObject5).putExtra("preUsername", ((SnsInfo)localObject3).field_userName);
                                  com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject5, c.this.activity);
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
                        continue;
                      }
                      if (((SnsInfo)localObject3).getAdSnsInfo().getAdXml().hasVoteInfo())
                      {
                        localObject1 = ((SnsInfo)localObject3).getAdSnsInfo().getAdXml().getAdVoteComponentUrl();
                        localObject4 = ((SnsInfo)localObject3).getUxinfo();
                        com.tencent.mm.kernel.g.aAf();
                        localObject5 = com.tencent.mm.kernel.a.ayV();
                        com.tencent.mm.plugin.sns.storage.y.b((String)localObject1, (String)localObject4, (String)localObject5, com.tencent.mm.plugin.sns.storage.y.aS((String)localObject1, (String)localObject4, (String)localObject5), 0, "");
                      }
                      localObject6 = ((SnsInfo)localObject3).getTimeLine();
                      if (((((TimeLineObject)localObject6).ContentObj.LoU != 15) || (((TimeLineObject)localObject6).sightFolded == 1)) && ((((TimeLineObject)localObject6).ContentObj.LoU != 27) || (((TimeLineObject)localObject6).ContentObj.LoV.size() <= k) || (((cnb)((TimeLineObject)localObject6).ContentObj.LoV.get(k)).oUv != 6))) {
                        continue;
                      }
                      Log.i("MicroMsg.TimelineClickListener", "onsight click");
                      localObject1 = null;
                      localObject4 = null;
                      if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.at)) {
                        localObject1 = (com.tencent.mm.plugin.sns.ui.at)paramAnonymousView.getTag();
                      }
                      if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                        continue;
                      }
                      localObject4 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                      if (((TimeLineObject)localObject6).ContentObj.LoU != 27) {
                        continue;
                      }
                      localObject1 = ((p.b)localObject4).EZG;
                      if (localObject3 != null) {
                        continue;
                      }
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(203968);
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
                  label4999:
                  i = 0;
                }
              }
              label5004:
              i = 0;
              k = m;
            }
            label5013:
            i = 0;
          }
          label5018:
          j = 0;
        }
      }
    };
    this.FaN = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(203970);
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)) && (com.tencent.mm.br.c.aZU("favorite"))) {
          paramAnonymousContextMenu.add(0, 25, 0, c.this.activity.getString(2131763947));
        }
        AppMethodBeat.o(203970);
      }
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(203969);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          TimeLineObject localTimeLineObject = (TimeLineObject)paramAnonymousView.getTag();
          Object localObject = aj.faO();
          String str = localTimeLineObject.Id;
          SnsInfo localSnsInfo = new SnsInfo();
          if (!((n)localObject).Emq)
          {
            localObject = ((n)localObject).iFy.query("SnsInfo", null, "stringSeq=?", new String[] { String.valueOf(str) }, null, null, null, 2);
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
              c.this.Far.a(paramAnonymousView, (String)localObject, localTimeLineObject);
            }
            AppMethodBeat.o(203969);
            return true;
            localObject = ((n)localObject).iFy.query("SnsInfo", null, "snsId=?", new String[] { n.aQy(new StringBuilder().append(str).toString()) }, null, null, null, 2);
            break;
            label196:
            ((Cursor)localObject).close();
          }
        }
        AppMethodBeat.o(203969);
        return false;
      }
    };
    this.FaL = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(203972);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        Object localObject;
        if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          paramAnonymousContextMenuInfo = (com.tencent.mm.plugin.sns.ui.s)paramAnonymousContextMenuInfo;
          localObject = paramAnonymousContextMenuInfo.EpO;
          if (com.tencent.mm.br.c.aZU("favorite")) {
            switch (((TimeLineObject)localObject).ContentObj.LoU)
            {
            default: 
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131763947));
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, aj.faO().aQm(paramAnonymousContextMenuInfo.dHp));
          AppMethodBeat.o(203972);
          return;
          paramAnonymousContextMenu.add(0, 4, 0, paramAnonymousView.getContext().getString(2131763947));
          localObject = new ef();
          ((ef)localObject).dHy.dHp = paramAnonymousContextMenuInfo.dHp;
          EventCenter.instance.publish((IEvent)localObject);
          if (((ef)localObject).dHz.dGX)
          {
            paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755922));
            continue;
            paramAnonymousContextMenu.add(0, 28, 0, paramAnonymousView.getContext().getString(2131763947));
            localObject = new ef();
            ((ef)localObject).dHy.dHp = paramAnonymousContextMenuInfo.dHp;
            EventCenter.instance.publish((IEvent)localObject);
            if (((ef)localObject).dHz.dGX)
            {
              paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755922));
              continue;
              paramAnonymousContextMenu.add(0, 5, 0, paramAnonymousView.getContext().getString(2131763947));
              continue;
              paramAnonymousContextMenu.add(0, 9, 0, paramAnonymousView.getContext().getString(2131763947));
              continue;
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131763947));
              localObject = new ef();
              ((ef)localObject).dHy.dHp = paramAnonymousContextMenuInfo.dHp;
              EventCenter.instance.publish((IEvent)localObject);
              if (((ef)localObject).dHz.dGX)
              {
                paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755922));
                continue;
                paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(2131763947));
                continue;
                paramAnonymousContextMenu.add(0, 22, 0, paramAnonymousView.getContext().getString(2131763947));
                continue;
                paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131763947));
                continue;
                paramAnonymousContextMenu.add(0, 23, 0, paramAnonymousView.getContext().getString(2131763947));
                continue;
                paramAnonymousContextMenu.add(0, 24, 0, paramAnonymousView.getContext().getString(2131763947));
              }
            }
          }
        }
      }
      
      public final boolean fD(View paramAnonymousView)
      {
        AppMethodBeat.i(203971);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof com.tencent.mm.plugin.sns.ui.s))
        {
          localObject = (com.tencent.mm.plugin.sns.ui.s)localObject;
          TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ui.s)localObject).EpO;
          if ((localTimeLineObject.ContentObj.LoU == 10) || (localTimeLineObject.ContentObj.LoU == 17) || (localTimeLineObject.ContentObj.LoU == 22) || (localTimeLineObject.ContentObj.LoU == 23))
          {
            AppMethodBeat.o(203971);
            return false;
          }
          c.this.Far.a(paramAnonymousView, ((com.tencent.mm.plugin.sns.ui.s)localObject).dHp, localTimeLineObject);
          AppMethodBeat.o(203971);
          return true;
        }
        AppMethodBeat.o(203971);
        return false;
      }
    };
    this.EZJ = new b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(203973);
        if ((paramAnonymousb != null) && (paramAnonymousInt == 0)) {
          if (paramAnonymousb.DmA == null) {
            break label88;
          }
        }
        label88:
        for (paramAnonymousb = (View)paramAnonymousb.DmA.get();; paramAnonymousb = null)
        {
          if ((paramAnonymousb != null) && ((paramAnonymousb instanceof com.tencent.mm.plugin.sight.decode.a.a)))
          {
            paramAnonymousb = (com.tencent.mm.plugin.sight.decode.a.a)paramAnonymousb;
            paramAnonymousb.getVideoPath();
            if ((paramAnonymousb.getTagObject() != null) && ((paramAnonymousb.getTagObject() instanceof com.tencent.mm.plugin.sns.ui.at))) {
              paramAnonymousb.getTagObject();
            }
          }
          AppMethodBeat.o(203973);
          return;
        }
      }
    };
    this.FaV = new c.36(this);
    this.FaW = new c.37(this);
    this.FaX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203974);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject1 = paramAnonymousView.DIu;
          if ((localObject1 != null) && (!Util.isNullOrNil(((dzo)localObject1).MYY)) && (((dzo)localObject1).MYY.get(0) != null))
          {
            Object localObject2 = ((dzu)((dzo)localObject1).MYY.get(0)).Md5;
            EmojiInfo localEmojiInfo = bj.gCJ().OpN.blk((String)localObject2);
            Intent localIntent = new Intent();
            localIntent.putExtra("custom_smiley_preview_md5", (String)localObject2);
            if ((localEmojiInfo.field_catalog != EmojiGroupInfo.Uuo) && (localEmojiInfo.field_catalog != EmojiGroupInfo.Uun) && (localEmojiInfo.field_catalog != EmojiGroupInfo.Uum)) {
              localIntent.putExtra("custom_smiley_preview_productid", localEmojiInfo.field_groupId);
            }
            com.tencent.mm.br.c.b(c.this.activity, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
            localObject2 = com.tencent.mm.plugin.sns.k.e.DUQ;
            long l = com.tencent.mm.plugin.sns.storage.y.aOa(paramAnonymousView.Epv);
            paramAnonymousView = String.valueOf(((dzo)localObject1).MYT);
            localObject1 = r.Jb(l);
            localObject1 = (e.a)((com.tencent.mm.plugin.sns.k.e)localObject2).DVd.get(localObject1);
            if ((localObject1 != null) && (!((e.a)localObject1).DVP.contains(paramAnonymousView))) {
              ((e.a)localObject1).DVP.add(paramAnonymousView);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203974);
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
        String str = r.Jb(paramSnsInfo.field_snsId) + ":" + localADInfo.uxInfo + ":" + aj.fau() + ":" + System.currentTimeMillis();
        if (paramInt == 0) {}
        for (paramInt = 1045;; paramInt = 1046)
        {
          r.a(paramString1, paramString2, paramString3, paramSnsInfo.getAid(), paramSnsInfo.getTraceid(), str, localADInfo.uxInfo, paramInt);
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
  
  public final void a(com.tencent.mm.plugin.sns.ui.c.a.a parama, Bundle paramBundle)
  {
    if (this.Fap != null)
    {
      Log.w("MicroMsg.TimelineClickListener", "has already prepare detail click animation");
      return;
    }
    if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.b))
    {
      this.Fap = new com.tencent.mm.plugin.sns.ui.b.a.d((MMActivity)this.activity, parama);
      this.Faq = new com.tencent.mm.plugin.sns.ui.b.a.c((MMActivity)this.activity, parama);
      return;
    }
    boolean bool3;
    boolean bool2;
    boolean bool1;
    if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
    {
      if (paramBundle == null) {
        break label266;
      }
      bool3 = paramBundle.getBoolean("isFromTwist", false);
      bool2 = paramBundle.getBoolean("isSimpleTwistAnim", false);
      bool1 = paramBundle.getBoolean("isTwistClockwise", false);
    }
    for (;;)
    {
      if (bool3) {
        if (!bool2) {}
      }
      for (this.Fap = new com.tencent.mm.plugin.sns.ui.b.a.g((MMActivity)this.activity, parama, bool1);; this.Fap = new com.tencent.mm.plugin.sns.ui.b.a.f((MMActivity)this.activity, parama))
      {
        this.Faq = new com.tencent.mm.plugin.sns.ui.b.a.e((MMActivity)this.activity, parama);
        return;
      }
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.f))
      {
        this.Fap = new com.tencent.mm.plugin.sns.ui.b.a.k((MMActivity)this.activity, parama);
        this.Faq = new com.tencent.mm.plugin.sns.ui.b.a.j((MMActivity)this.activity, parama);
        return;
      }
      if (!(parama instanceof com.tencent.mm.plugin.sns.ui.c.a.d)) {
        break;
      }
      this.Fap = new com.tencent.mm.plugin.sns.ui.b.a.i((MMActivity)this.activity, parama);
      this.Faq = new com.tencent.mm.plugin.sns.ui.b.a.h((MMActivity)this.activity, parama);
      return;
      label266:
      bool1 = false;
      bool2 = false;
      bool3 = false;
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, Bundle paramBundle)
  {
    if (this.Fan != null)
    {
      Log.w("MicroMsg.TimelineClickListener", "has already prepare click animation");
      return;
    }
    if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.a.a))
    {
      this.Fan = new com.tencent.mm.plugin.sns.ui.b.b.d((MMActivity)this.activity, paramBaseViewHolder);
      this.Fao = new com.tencent.mm.plugin.sns.ui.b.b.c((MMActivity)this.activity, paramBaseViewHolder);
      ((com.tencent.mm.plugin.sns.ui.item.a.a)paramBaseViewHolder).EYi = true;
      return;
    }
    com.tencent.mm.plugin.sns.ui.item.f.a locala;
    boolean bool3;
    boolean bool2;
    boolean bool1;
    if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.f.a))
    {
      locala = (com.tencent.mm.plugin.sns.ui.item.f.a)paramBaseViewHolder;
      if (paramBundle == null) {
        break label286;
      }
      bool3 = paramBundle.getBoolean("isFromTwist", false);
      bool2 = paramBundle.getBoolean("isSimpleTwistAnim", false);
      bool1 = paramBundle.getBoolean("isTwistClockwise", false);
    }
    for (;;)
    {
      if (bool3) {
        if (!bool2) {}
      }
      for (this.Fan = new com.tencent.mm.plugin.sns.ui.b.b.g((MMActivity)this.activity, paramBaseViewHolder, bool1);; this.Fan = new com.tencent.mm.plugin.sns.ui.b.b.f((MMActivity)this.activity, paramBaseViewHolder))
      {
        this.Fao = new com.tencent.mm.plugin.sns.ui.b.b.e((MMActivity)this.activity, paramBaseViewHolder);
        locala.EYi = true;
        return;
      }
      if ((paramBaseViewHolder instanceof p.b))
      {
        this.Fan = new com.tencent.mm.plugin.sns.ui.b.b.k((MMActivity)this.activity, paramBaseViewHolder);
        this.Fao = new com.tencent.mm.plugin.sns.ui.b.b.j((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
      if (!(paramBaseViewHolder instanceof n.a)) {
        break;
      }
      this.Fan = new com.tencent.mm.plugin.sns.ui.b.b.i((MMActivity)this.activity, paramBaseViewHolder);
      this.Fao = new com.tencent.mm.plugin.sns.ui.b.b.h((MMActivity)this.activity, paramBaseViewHolder);
      return;
      label286:
      bool1 = false;
      bool2 = false;
      bool3 = false;
    }
  }
  
  public final void c(com.tencent.mm.plugin.sns.ad.g.k paramk)
  {
    this.EBv = paramk;
    if (this.Far != null) {
      this.Far.c(paramk);
    }
  }
  
  public abstract void dS(Object paramObject);
  
  public final void ebz()
  {
    this.Far.ebz();
    EventCenter.instance.addListener(this.Fbg);
    EventCenter.instance.addListener(this.Fbh);
  }
  
  public abstract void ffw();
  
  public abstract void ffx();
  
  public abstract void ffy();
  
  public abstract void ffz();
  
  public abstract void fo(View paramView);
  
  public abstract void fp(View paramView);
  
  public abstract void fq(View paramView);
  
  public abstract void fr(View paramView);
  
  public abstract void fs(View paramView);
  
  public abstract void ft(View paramView);
  
  public abstract void fu(View paramView);
  
  public final void removeListener()
  {
    this.Far.removeListener();
    EventCenter.instance.removeListener(this.Fbg);
    EventCenter.instance.removeListener(this.Fbh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c
 * JD-Core Version:    0.7.0.1
 */