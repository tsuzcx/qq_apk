package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.ClipboardManager;
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
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.wu;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.ad.e.n;
import com.tencent.mm.plugin.sns.ad.e.n.a;
import com.tencent.mm.plugin.sns.ad.e.n.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.as.b;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.storage.a.c;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.b.g;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bh.b;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.plugin.sns.ui.item.m.a;
import com.tencent.mm.plugin.sns.ui.item.m.b;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class c
{
  volatile com.tencent.mm.plugin.sns.ui.b.b.b APG;
  volatile com.tencent.mm.plugin.sns.ui.b.b.a APH;
  volatile com.tencent.mm.plugin.sns.ui.b.a.b APJ;
  volatile com.tencent.mm.plugin.sns.ui.b.a.a APK;
  public b APL;
  public View.OnClickListener APM;
  public View.OnLongClickListener APN;
  public d APO;
  public View.OnClickListener APQ;
  public View.OnClickListener APR;
  public View.OnClickListener APS;
  public View.OnClickListener APT;
  public View.OnClickListener APU;
  public View.OnClickListener APV;
  public View.OnClickListener APW;
  public View.OnClickListener APX;
  public View.OnClickListener APY;
  public d APZ;
  public b.e APe;
  int AQA;
  private com.tencent.mm.sdk.b.c<wv> AQB = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.sdk.b.c<wu> AQC = new com.tencent.mm.sdk.b.c() {};
  public View.OnClickListener AQD = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(220133);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      localObject1 = paramAnonymousView.getTag();
      Object localObject3 = null;
      Object localObject2;
      if ((localObject1 instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        localObject1 = com.tencent.mm.plugin.sns.storage.h.aBq(((BaseTimeLineItem.BaseViewHolder)localObject2).dAg);
        localObject3 = ((BaseTimeLineItem.BaseViewHolder)localObject2).AMv;
        localObject2 = null;
      }
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        int i;
        if (localObject1 != null)
        {
          localObject4 = ((p)localObject1).ecy();
          int k = ((com.tencent.mm.plugin.sns.storage.e)localObject4).getSource();
          if ((localObject1 != null) && (((p)localObject1).Rt(32)))
          {
            localObject5 = c.a(c.this, (p)localObject1);
            if ((((p)localObject1).dVj().dZv()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aBm(((p)localObject1).ecy().field_adxml)))
            {
              localObject5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J((p)localObject1);
              if (!bu.isNullOrNil((String)localObject5)) {
                ((com.tencent.mm.plugin.sns.storage.e)localObject4).field_adxml = ((String)localObject5);
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
                label220:
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
                paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
                paramAnonymousView.putExtra("img_gallery_width", i);
                paramAnonymousView.putExtra("img_gallery_height", j);
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", ((p)localObject1).getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", ((p)localObject1).ebP().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", ((p)localObject1).ecx());
                localObject2 = ((p)localObject1).ebP();
                if (localObject2 != null)
                {
                  localObject2 = ((TimeLineObject)localObject2).HUG.Gtx;
                  if (((List)localObject2).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((bzh)((List)localObject2).get(0)).Hmj);
                  }
                }
                paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (k != 2) {
                  break label632;
                }
                i = 16;
                label384:
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", ((p)localObject1).ecy().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", ((p)localObject1).ecz());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject2 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramAnonymousView.ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject2).startActivity((Intent)paramAnonymousView.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.this.activity.overridePendingTransition(0, 0);
                if (k != 0) {
                  break label644;
                }
              }
              label644:
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 21));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220133);
                return;
                if (!(localObject1 instanceof p)) {
                  break label1295;
                }
                localObject1 = (p)localObject1;
                localObject2 = (MMImageView)paramAnonymousView.getTag(2131301433);
                break;
                if (localObject2 == null) {
                  break label220;
                }
                ((MMImageView)localObject2).getLocationInWindow((int[])localObject4);
                i = ((MMImageView)localObject2).getWidth();
                j = ((MMImageView)localObject2).getHeight();
                break label220;
                label632:
                if (k != 1) {
                  break label384;
                }
                i = 10;
                break label384;
              }
            }
            if ((localObject5 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject5).zLR == 1))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject5).zLT);
              paramAnonymousView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject5).zLU);
              paramAnonymousView.putExtra("key_from_scene", 21);
              paramAnonymousView.putExtra("key_stastic_scene", 15);
              com.tencent.mm.br.d.b(c.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
              if (k == 0) {}
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 11));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220133);
                return;
              }
            }
            if (c.a(c.this, (com.tencent.mm.plugin.sns.storage.a)localObject5, (p)localObject1, false))
            {
              if (k == 0) {}
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 31));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220133);
                return;
              }
            }
          }
          if (k != 0) {
            break label1284;
          }
          i = 1;
          localObject3 = new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 0);
          com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject3);
          localObject2 = ((p)localObject1).ecw();
          paramAnonymousView = (View)localObject2;
          if (bu.isNullOrNil((String)localObject2)) {
            paramAnonymousView = ((p)localObject1).ecv();
          }
          ae.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject1).dVj().zMS);
          localObject5 = new Intent();
          if (((p)localObject1).dVj().zMS != 0) {
            break label1289;
          }
        }
        label1284:
        label1289:
        for (boolean bool = true;; bool = false)
        {
          if (ac.iRQ) {
            bool = false;
          }
          localObject2 = paramAnonymousView;
          if (localObject1 != null)
          {
            localObject2 = paramAnonymousView;
            if (((p)localObject1).Rt(32))
            {
              com.tencent.mm.plugin.sns.storage.a locala = c.a(c.this, (p)localObject1);
              localObject2 = paramAnonymousView;
              if (locala != null)
              {
                ((Intent)localObject5).putExtra("KsnsViewId", locala.aQj);
                localObject2 = com.tencent.mm.plugin.sns.data.r.jo(paramAnonymousView, locala.dGD);
                com.tencent.mm.plugin.sns.data.r.g((Intent)localObject5, locala.dGD);
              }
            }
          }
          ((Intent)localObject5).putExtra("KRightBtn", bool);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject3);
          paramAnonymousView.putString("key_snsad_statextstr", ((com.tencent.mm.plugin.sns.storage.e)localObject4).ebP().AiG);
          ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
          ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
          ((Intent)localObject5).putExtra("useJs", true);
          ((Intent)localObject5).putExtra("srcUsername", ((p)localObject1).field_userName);
          ((Intent)localObject5).putExtra("stastic_scene", 15);
          ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((p)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("pre_username", ((p)localObject1).field_userName);
          ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((p)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("preUsername", ((p)localObject1).field_userName);
          com.tencent.mm.plugin.sns.c.a.iUz.i((Intent)localObject5, c.this.activity);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220133);
          return;
          i = 2;
          break;
        }
        label1295:
        localObject2 = null;
        localObject1 = null;
      }
    }
  };
  public d AQa;
  public d AQb;
  public d AQc;
  public d AQd;
  public d AQe;
  public d AQf;
  d AQg;
  public d AQh;
  public d AQi;
  public View.OnClickListener AQj;
  public View.OnClickListener AQk;
  public View.OnClickListener AQl;
  public View.OnClickListener AQm;
  public View.OnClickListener AQn;
  public View.OnClickListener AQo;
  public View.OnClickListener AQp;
  public View.OnClickListener AQq;
  public View.OnClickListener AQr;
  public View.OnClickListener AQs;
  public View.OnClickListener AQt;
  public AdapterView.OnItemClickListener AQu;
  public AdapterView.OnItemClickListener AQv;
  public View.OnClickListener AQw = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100199);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      if (paramAnonymousView.getTag() == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100199);
        return;
      }
      localObject1 = c.fm(paramAnonymousView);
      if ((localObject1 == null) || (!((p)localObject1).Rt(32)))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100199);
        return;
      }
      int j;
      int i;
      Object localObject2;
      label177:
      int k;
      if (((p)localObject1).ecy().dVj().dZG())
      {
        j = x.jZ(((p)localObject1).ecy().dVj().dZy(), ((p)localObject1).ecx());
        if (j > 0)
        {
          i = 1;
          localObject2 = ((p)localObject1).ecy().dVj().dZy();
          String str1 = ((p)localObject1).ecx();
          com.tencent.mm.kernel.g.ajP();
          String str2 = com.tencent.mm.kernel.a.aiF();
          if (i == 0) {
            break label283;
          }
          if (i == 0) {
            break label288;
          }
          k = 0;
          label184:
          x.b((String)localObject2, str1, str2, j, k, "");
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject2 = ((p)localObject1).ebP();
        if ((((TimeLineObject)localObject2).HUG.Gtw == 15) && (((TimeLineObject)localObject2).HUN != 1)) {
          c.a(c.this, paramAnonymousView, (p)localObject1, 1001, ((p)localObject1).ecy().dVj().dZH(), bool);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100199);
          return;
          i = 0;
          break;
          label283:
          j = 1;
          break label177;
          label288:
          k = 1;
          break label184;
          if (((((TimeLineObject)localObject2).HUG.Gtw == 1) && (((TimeLineObject)localObject2).HUG.Gtx.size() == 1)) || (((TimeLineObject)localObject2).HUG.Gtw == 7)) {
            c.b(c.this, paramAnonymousView, (p)localObject1, 1001, ((p)localObject1).ecy().dVj().dZH(), bool);
          }
        }
      }
    }
  };
  public View.OnClickListener AQx = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100219);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      if (paramAnonymousView.getTag() == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100219);
        return;
      }
      localObject1 = c.fm(paramAnonymousView);
      if ((localObject1 == null) || (!((p)localObject1).Rt(32)))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100219);
        return;
      }
      int j;
      int i;
      Object localObject2;
      label177:
      int k;
      if (((p)localObject1).ecy().dVj().dZG())
      {
        j = x.jZ(((p)localObject1).ecy().dVj().dZy(), ((p)localObject1).ecx());
        if (j > 0)
        {
          i = 1;
          localObject2 = ((p)localObject1).ecy().dVj().dZy();
          String str1 = ((p)localObject1).ecx();
          com.tencent.mm.kernel.g.ajP();
          String str2 = com.tencent.mm.kernel.a.aiF();
          if (i == 0) {
            break label283;
          }
          if (i == 0) {
            break label288;
          }
          k = 0;
          label184:
          x.b((String)localObject2, str1, str2, j, k, "");
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject2 = ((p)localObject1).ebP();
        if ((((TimeLineObject)localObject2).HUG.Gtw == 15) && (((TimeLineObject)localObject2).HUN != 1)) {
          c.a(c.this, paramAnonymousView, (p)localObject1, 1002, ((p)localObject1).ecy().dVj().dZI(), bool);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100219);
          return;
          i = 0;
          break;
          label283:
          j = 2;
          break label177;
          label288:
          k = 1;
          break label184;
          if (((((TimeLineObject)localObject2).HUG.Gtw == 1) && (((TimeLineObject)localObject2).HUG.Gtx.size() == 1)) || (((TimeLineObject)localObject2).HUG.Gtw == 7)) {
            c.b(c.this, paramAnonymousView, (p)localObject1, 1002, ((p)localObject1).ecy().dVj().dZI(), bool);
          }
        }
      }
    }
  };
  public View.OnClickListener AQy;
  public bh.b AQz;
  com.tencent.mm.plugin.sns.model.ag AgN;
  public View.OnClickListener AiC;
  protected com.tencent.mm.plugin.sns.ad.e.j Asq;
  Activity activity;
  int doj = 0;
  private ClipboardManager rJr;
  public View.OnTouchListener tVH;
  
  public c(int paramInt, Activity paramActivity, com.tencent.mm.plugin.sns.model.ag paramag)
  {
    this.doj = paramInt;
    this.activity = paramActivity;
    this.AgN = paramag;
    this.AQA = bu.getInt(com.tencent.mm.n.g.acL().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
    ae.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[] { Integer.valueOf(this.AQA) });
    this.rJr = ((ClipboardManager)ak.getContext().getSystemService("clipboard"));
    this.APL = new b(this.activity, this.doj, this.AgN);
    this.APX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100258);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Long)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100258);
          return;
        }
        long l = ((Long)paramAnonymousView.getTag()).longValue();
        com.tencent.mm.plugin.sns.storage.e locale = ah.dXH().Ax(l);
        p localp = locale.ebV();
        n.a(n.b.zqs, n.a.zqq, locale.ebV(), c.this.doj);
        locale.getSource();
        paramAnonymousView = localp.ecw();
        if (bu.isNullOrNil(paramAnonymousView)) {
          paramAnonymousView = localp.ecv();
        }
        label810:
        label1966:
        for (;;)
        {
          int i;
          Object localObject2;
          int j;
          if (localp.Rt(32))
          {
            localObject1 = c.a(c.this, localp);
            i = -1;
            localObject2 = com.tencent.mm.model.c.d.aDJ().aTG("Sns_CanvasAd_DetailLink_JumpWay");
            if (((com.tencent.mm.storage.a)localObject2).isValid()) {
              i = bu.getInt(((com.tencent.mm.storage.a)localObject2).field_value, -1);
            }
            if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).zLR == 1))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject1).zLT);
              paramAnonymousView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject1).zLU);
              paramAnonymousView.putExtra("key_from_scene", 21);
              paramAnonymousView.putExtra("key_stastic_scene", 15);
              com.tencent.mm.br.d.b(c.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
              j = c.this.doj;
              if (c.this.doj == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 11);
                com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.Asq, localp, 3);
                com.tencent.mm.plugin.sns.data.r.a(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100258);
                return;
              }
            }
            if ((localObject1 != null) && (i == 1))
            {
              if ((localp.dVj().dZv()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aBm(localp.ecy().field_adxml)))
              {
                paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J(localp);
                if (!bu.isNullOrNil(paramAnonymousView)) {
                  locale.field_adxml = paramAnonymousView;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.ebP().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.ecx());
                paramAnonymousView.putExtra("sns_landing_pages_aid", localp.ect());
                paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.ecu());
                localObject1 = localp.ebP();
                if (localObject1 != null)
                {
                  localObject1 = ((TimeLineObject)localObject1).HUG.Gtx;
                  if (((List)localObject1).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((bzh)((List)localObject1).get(0)).Hmj);
                  }
                }
                paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (c.this.doj == 2)
                {
                  i = 16;
                  paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                  paramAnonymousView.putExtra("sns_landing_pages_xml", localp.ecy().field_adxml);
                  paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                  paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.ecz());
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                  localObject1 = c.this.activity;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)paramAnonymousView.mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  c.this.activity.overridePendingTransition(0, 0);
                  j = c.this.doj;
                  if (c.this.doj != 0) {
                    break label810;
                  }
                }
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 21);
                  com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.Asq, localp, 3);
                  com.tencent.mm.plugin.sns.data.r.a(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100258);
                  return;
                  if (c.this.doj != 1) {
                    break;
                  }
                  i = 10;
                  break;
                }
              }
            }
            else if ((localObject1 != null) && (i == 0))
            {
              if ((!localp.dVj().dZv()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aBm(localp.ecy().field_adxml))) {
                break label1972;
              }
              localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J(localp);
              if (!bu.isNullOrNil((String)localObject1)) {
                locale.field_adxml = ((String)localObject1);
              }
              localObject1 = bx.M(localp.ecy().field_adxml, "adxml");
              if (localObject1 != null)
              {
                localObject1 = bu.bI((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareWebUrl"), "");
                if (!bu.isNullOrNil((String)localObject1)) {
                  paramAnonymousView = (View)localObject1;
                }
              }
            }
          }
          label944:
          label1972:
          for (;;)
          {
            j = c.this.doj;
            Intent localIntent;
            if (c.this.doj == 0)
            {
              i = 1;
              localObject2 = new SnsAdClick(j, i, localp.field_snsId, 3, 0);
              com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, c.this.Asq, localp, 3);
              com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject2);
              ae.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + localp.dVj().zMS);
              localIntent = new Intent();
              if (localp.dVj().zMS != 0) {
                break label1966;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              if (ac.iRQ) {
                bool = false;
              }
              localObject1 = paramAnonymousView;
              if (localp.Rt(32))
              {
                com.tencent.mm.plugin.sns.storage.a locala = c.a(c.this, localp);
                localObject1 = paramAnonymousView;
                if (locala != null)
                {
                  localIntent.putExtra("KsnsViewId", locala.aQj);
                  localObject1 = com.tencent.mm.plugin.sns.ad.b.a.a.ayT(com.tencent.mm.plugin.sns.data.r.jo(paramAnonymousView, locala.dGD));
                  com.tencent.mm.plugin.sns.data.r.g(localIntent, locala.dGD);
                }
              }
              localIntent.putExtra("KRightBtn", bool);
              paramAnonymousView = new Bundle();
              paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject2);
              paramAnonymousView.putString("key_snsad_statextstr", locale.ebP().AiG);
              localIntent.putExtra("jsapiargs", paramAnonymousView);
              localIntent.putExtra("rawUrl", (String)localObject1);
              localIntent.putExtra("useJs", true);
              localIntent.putExtra("srcUsername", localp.field_userName);
              localIntent.putExtra("sns_local_id", localp.eco());
              localIntent.putExtra("stastic_scene", 15);
              localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(localp.field_snsId));
              localIntent.putExtra("pre_username", localp.field_userName);
              localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(localp.field_snsId));
              localIntent.putExtra("preUsername", localp.field_userName);
              com.tencent.mm.plugin.sns.c.a.iUz.i(localIntent, c.this.activity);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100258);
              return;
              ae.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + localp.ecy().field_adxml);
              break;
              if ((localObject1 != null) && (i == -1) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).zLR == 3))
              {
                if ((!localp.dVj().dZv()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aBm(localp.ecy().field_adxml))) {
                  break label1972;
                }
                paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J(localp);
                if (!bu.isNullOrNil(paramAnonymousView)) {
                  locale.field_adxml = paramAnonymousView;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.ebP().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.ecx());
                paramAnonymousView.putExtra("sns_landing_pages_aid", localp.ect());
                paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.ecu());
                localObject1 = localp.ebP();
                if (localObject1 != null)
                {
                  localObject1 = ((TimeLineObject)localObject1).HUG.Gtx;
                  if (((List)localObject1).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((bzh)((List)localObject1).get(0)).Hmj);
                  }
                }
                paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (c.this.doj == 2)
                {
                  i = 16;
                  paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                  paramAnonymousView.putExtra("sns_landing_pages_xml", localp.ecy().field_adxml);
                  paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.ecz());
                  paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                  localObject1 = c.this.activity;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)paramAnonymousView.mt(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  c.this.activity.overridePendingTransition(0, 0);
                  j = c.this.doj;
                  if (c.this.doj != 0) {
                    break label1862;
                  }
                }
                label1862:
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 21);
                  com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.Asq, localp, 3);
                  com.tencent.mm.plugin.sns.data.r.a(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100258);
                  return;
                  if (c.this.doj != 1) {
                    break;
                  }
                  i = 10;
                  break;
                }
              }
              if (!c.a(c.this, (com.tencent.mm.plugin.sns.storage.a)localObject1, localp, false)) {
                break label1972;
              }
              j = c.this.doj;
              if (c.this.doj == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 31);
                com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.Asq, localp, 3);
                com.tencent.mm.plugin.sns.data.r.a(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100258);
                return;
              }
              i = 2;
              break label944;
            }
          }
        }
      }
    };
    this.AQk = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100259);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        localObject1 = ah.dXE().aBr(paramAnonymousView);
        if (localObject1 == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        if (((p)localObject1).Rt(32))
        {
          ae.i("MicroMsg.TimelineClickListener", "click the ad poi button");
          localObject2 = c.a(c.this, (p)localObject1);
          if (localObject2 == null)
          {
            ae.e("MicroMsg.TimelineClickListener", "the adInfo is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
          int j = c.this.doj;
          if (c.this.doj == 0) {}
          for (int i = 1;; i = 2)
          {
            localObject3 = new SnsAdClick(j, i, ((p)localObject1).field_snsId, 19, 0);
            com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject3, c.this.Asq, (p)localObject1, 19);
            com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject3);
            if (!bu.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject2).zLZ)) {
              break;
            }
            ae.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
          if (c.this.doj == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.e.pY(724);; paramAnonymousView = com.tencent.mm.modelsns.e.pZ(724))
          {
            paramAnonymousView.GU(com.tencent.mm.plugin.sns.data.r.o((p)localObject1)).qb(((p)localObject1).field_type).eV(((p)localObject1).Rt(32)).GU(((p)localObject1).ecx()).GU("").GU("").GU("").GU("").GU(((com.tencent.mm.plugin.sns.storage.a)localObject2).zLY).GU("").GU("");
            paramAnonymousView.aLH();
            ae.i("MicroMsg.TimelineClickListener", "open webview url : " + ((com.tencent.mm.plugin.sns.storage.a)localObject2).zLZ);
            paramAnonymousView = new Intent();
            if ((localObject1 != null) && (((p)localObject1).Rt(32)))
            {
              localObject4 = c.a(c.this, (p)localObject1);
              if (localObject4 != null) {
                paramAnonymousView.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject4).aQj);
              }
            }
            localObject4 = new Bundle();
            ((Bundle)localObject4).putParcelable("KSnsAdTag", (Parcelable)localObject3);
            paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject4);
            paramAnonymousView.putExtra("useJs", true);
            paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((p)localObject1).field_snsId));
            paramAnonymousView.putExtra("pre_username", ((p)localObject1).field_userName);
            paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((p)localObject1).field_snsId));
            paramAnonymousView.putExtra("preUsername", ((p)localObject1).field_userName);
            paramAnonymousView.putExtra("rawUrl", com.tencent.mm.plugin.sns.data.r.jo(((com.tencent.mm.plugin.sns.storage.a)localObject2).zLZ, ((com.tencent.mm.plugin.sns.storage.a)localObject2).dGD));
            com.tencent.mm.plugin.sns.c.a.iUz.i(paramAnonymousView, c.this.activity);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
        }
        Object localObject3 = ((p)localObject1).ebP();
        Object localObject4 = ((TimeLineObject)localObject3).HUE;
        Object localObject2 = new Intent();
        if (c.this.doj == 0) {}
        for (paramAnonymousView = com.tencent.mm.modelsns.e.pY(724);; paramAnonymousView = com.tencent.mm.modelsns.e.pZ(724))
        {
          paramAnonymousView.GU(com.tencent.mm.plugin.sns.data.r.o((p)localObject1)).qb(((p)localObject1).field_type).eV(((p)localObject1).Rt(32)).GU(((p)localObject1).ecx()).GU(((bwk)localObject4).GGA).qb(((bwk)localObject4).Ajt).GU(((bwk)localObject4).Gha).GU(((bwk)localObject4).GgZ).GU(((bwk)localObject4).jGd).GU(((bwk)localObject4).Ajr).GU(((bwk)localObject4).jfX);
          paramAnonymousView.aLH();
          if (!bu.isNullOrNil(((bwk)localObject4).GGA)) {
            break;
          }
          ((Intent)localObject2).putExtra("map_view_type", 7);
          ((Intent)localObject2).putExtra("kwebmap_slat", ((bwk)localObject4).Gha);
          ((Intent)localObject2).putExtra("kwebmap_lng", ((bwk)localObject4).GgZ);
          ((Intent)localObject2).putExtra("kPoiName", ((bwk)localObject4).jGd);
          ((Intent)localObject2).putExtra("Kwebmap_locaion", ((bwk)localObject4).Ajr);
          com.tencent.mm.br.d.b(c.this.activity, "location", ".ui.RedirectUI", (Intent)localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        if (c.this.AQA == 0) {}
        for (paramAnonymousView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[] { ((bwk)localObject4).GGA });; paramAnonymousView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[] { ((bwk)localObject4).GGA, ((TimeLineObject)localObject3).Id }))
        {
          ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
          com.tencent.mm.plugin.sns.c.a.iUz.i((Intent)localObject2, c.this.activity);
          break;
        }
      }
    };
    this.AQo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100260);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        paramAnonymousView = ah.dXE().aBr(paramAnonymousView);
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        if (paramAnonymousView.Rt(32))
        {
          ae.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
          paramAnonymousView = c.a(c.this, paramAnonymousView);
          if (paramAnonymousView == null)
          {
            ae.e("MicroMsg.TimelineClickListener", "the adInfo is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100260);
            return;
          }
          if (bu.isNullOrNil(paramAnonymousView.zMc))
          {
            ae.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100260);
            return;
          }
          ae.i("MicroMsg.TimelineClickListener", "open webview url : " + paramAnonymousView.zMc);
          localObject = new Intent();
          ((Intent)localObject).putExtra("jsapiargs", new Bundle());
          ((Intent)localObject).putExtra("useJs", true);
          String str = com.tencent.mm.plugin.sns.data.r.jo(paramAnonymousView.zMc, paramAnonymousView.dGD);
          com.tencent.mm.plugin.sns.data.r.g((Intent)localObject, paramAnonymousView.dGD);
          ((Intent)localObject).putExtra("rawUrl", str);
          com.tencent.mm.plugin.sns.c.a.iUz.i((Intent)localObject, c.this.activity);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100260);
      }
    };
    this.AQp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100261);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        int j;
        if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          localObject = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dqc;
          localObject = ah.dXE().aBr((String)localObject);
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100261);
            return;
          }
          if (((p)localObject).Rt(32))
          {
            ae.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
            j = c.this.doj;
            if (c.this.doj != 0) {
              break label195;
            }
          }
        }
        label195:
        for (int i = 1;; i = 2)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(j, i, ((p)localObject).field_snsId, 24, 0);
          com.tencent.mm.plugin.sns.data.k.a(localSnsAdClick, c.this.Asq, (p)localObject, 24);
          com.tencent.mm.plugin.sns.data.r.a(localSnsAdClick);
          c.this.fa(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100261);
          return;
        }
      }
    };
    this.APM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        int m = 1;
        int k = 1;
        AppMethodBeat.i(100262);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        Object localObject2 = (String)paramAnonymousView.getTag();
        ae.d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(localObject2)));
        Object localObject3 = new Intent();
        int j;
        int i;
        if (((paramAnonymousView instanceof MaskImageButton)) && (((MaskImageButton)paramAnonymousView).hjr != null))
        {
          paramAnonymousView = (String)((MaskImageButton)paramAnonymousView).hjr;
          localObject1 = ah.dXE().aBr(paramAnonymousView);
          if ((localObject1 != null) && (((p)localObject1).Rt(32)))
          {
            com.tencent.mm.plugin.sns.storage.b localb = ((p)localObject1).dVj();
            j = c.this.doj;
            if (c.this.doj == 0) {}
            for (i = 1;; i = 2)
            {
              paramAnonymousView = new SnsAdClick(j, i, ((p)localObject1).field_snsId, 1, 0);
              com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.Asq, (p)localObject1, 1);
              com.tencent.mm.plugin.sns.data.r.a(paramAnonymousView);
              if (localb == null) {
                break label459;
              }
              if ((localb.zNc != 1) || (bu.isNullOrNil(localb.zNd))) {
                break;
              }
              localObject2 = localb.zNd;
              localObject3 = c.a(c.this, (p)localObject1);
              paramAnonymousView = (View)localObject2;
              if (localObject3 != null) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.r.jo((String)localObject2, ((com.tencent.mm.plugin.sns.storage.a)localObject3).dGD);
              }
              ae.i("MicroMsg.TimelineClickListener", "headClickParam url " + paramAnonymousView + " " + localb.zNe);
              localObject2 = new Intent();
              if (localb.zNe == 0) {
                bool = true;
              }
              ((Intent)localObject2).putExtra("KsnsViewId", c.a(c.this, (p)localObject1).aQj);
              ((Intent)localObject2).putExtra("KRightBtn", bool);
              ((Intent)localObject2).putExtra("jsapiargs", new Bundle());
              ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject2).putExtra("useJs", true);
              com.tencent.mm.plugin.sns.c.a.iUz.i((Intent)localObject2, c.this.activity);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100262);
              return;
            }
            if (com.tencent.mm.plugin.sns.ad.c.d.b(c.this.activity, localb, c.a(c.this, (p)localObject1), ((p)localObject1).field_snsId))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100262);
              return;
            }
            label459:
            i = 1;
            paramAnonymousView = (View)localObject1;
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
            if (c.this.doj != 0) {
              break label733;
            }
            if (paramAnonymousView.Rt(32))
            {
              j = 722;
              localObject1 = com.tencent.mm.modelsns.e.pY(j);
              ((com.tencent.mm.modelsns.e)localObject1).GU(com.tencent.mm.plugin.sns.data.r.o(paramAnonymousView)).qb(paramAnonymousView.field_type).eV(paramAnonymousView.Rt(32)).GU(paramAnonymousView.ecx()).GU((String)localObject2);
              ((com.tencent.mm.modelsns.e)localObject1).aLH();
            }
          }
          else
          {
            if (i == 0) {
              break label767;
            }
            j = c.this.doj;
            if (c.this.doj != 0) {
              break label762;
            }
          }
          label733:
          label762:
          for (i = 1;; i = 2)
          {
            localObject1 = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 1, 0);
            com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject1, c.this.Asq, paramAnonymousView, 1);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            ((Intent)localObject3).putExtra("KSnsAdTag", (Parcelable)localObject1);
            ((Intent)localObject3).putExtra("Contact_Scene", 78);
            i = k;
            if (c.this.doj == 0) {
              i = 6;
            }
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            com.tencent.mm.plugin.sns.c.a.iUz.c((Intent)localObject3, c.this.activity);
            ae.i("MicroMsg.TimelineClickListener", "startContactInfo, addScene=78");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100262);
            return;
            j = 721;
            break;
            if (paramAnonymousView.Rt(32)) {}
            for (j = 722;; j = 721)
            {
              localObject1 = com.tencent.mm.modelsns.e.pZ(j);
              break;
            }
          }
          label767:
          c.this.AgN.dXi().a(paramAnonymousView, true);
          if (c.this.doj == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.e.pY(746);; paramAnonymousView = com.tencent.mm.modelsns.e.pZ(746))
          {
            localObject1 = v.aAC();
            paramAnonymousView.GU((String)localObject2).eV(((String)localObject2).endsWith((String)localObject1));
            paramAnonymousView.b((Intent)localObject3, "intent_key_StatisticsOplog");
            i = m;
            if (c.this.doj == 0) {
              i = 6;
            }
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            com.tencent.mm.plugin.sns.c.a.iUz.c((Intent)localObject3, c.this.activity);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100262);
            return;
          }
          i = 0;
          paramAnonymousView = (View)localObject1;
          continue;
          paramAnonymousView = null;
          i = 0;
        }
      }
    };
    this.APN = new c.2(this);
    this.APO = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100203);
        paramAnonymousView = (bd)paramAnonymousView.getTag();
        paramAnonymousContextMenuInfo = ah.dXE().aBq(paramAnonymousView.dAg);
        if (paramAnonymousContextMenuInfo == null)
        {
          AppMethodBeat.o(100203);
          return;
        }
        paramAnonymousContextMenu.add(0, 0, 0, c.this.activity.getString(2131755701));
        if (com.tencent.mm.br.d.aJN("favorite")) {
          paramAnonymousContextMenu.add(0, 1, 0, c.this.activity.getString(2131761941));
        }
        TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.ebP();
        if ((paramAnonymousView.Ayo) || ((localTimeLineObject != null) && (localTimeLineObject.HUI != 1) && (!paramAnonymousView.Ayp)))
        {
          if (paramAnonymousView.ega()) {
            break label143;
          }
          as.a(paramAnonymousContextMenu, true);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
          AppMethodBeat.o(100203);
          return;
          label143:
          as.b(paramAnonymousContextMenu, true);
        }
      }
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(100204);
        if ((paramAnonymousView.getTag() instanceof bd))
        {
          Object localObject = (bd)paramAnonymousView.getTag();
          localObject = ah.dXE().aBq(((bd)localObject).dAg);
          if (localObject == null)
          {
            AppMethodBeat.o(100204);
            return false;
          }
          String str = ((p)localObject).eco();
          c.this.APL.a(paramAnonymousView, str, ((p)localObject).ebP());
          AppMethodBeat.o(100204);
          return true;
        }
        AppMethodBeat.o(100204);
        return false;
      }
    };
    this.AQe = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100206);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof p)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.aq)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.az)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.c.a.a))) {
          if ((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.h.aBq(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).dAg);
          }
        }
        for (;;)
        {
          if (!paramAnonymousContextMenuInfo.Rt(32))
          {
            AppMethodBeat.o(100206);
            return;
            if ((paramAnonymousContextMenuInfo instanceof p))
            {
              paramAnonymousContextMenuInfo = (p)paramAnonymousContextMenuInfo;
              continue;
            }
            if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.aq))
            {
              paramAnonymousContextMenuInfo = (com.tencent.mm.plugin.sns.ui.aq)paramAnonymousContextMenuInfo;
              paramAnonymousContextMenuInfo = ah.dXE().aBr(paramAnonymousContextMenuInfo.dqc);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.az))
            {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.az)paramAnonymousView.getTag()).dsN;
              paramAnonymousContextMenuInfo = ah.dXE().aBr(paramAnonymousContextMenuInfo);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).znm;
            }
          }
          else
          {
            if ((paramAnonymousContextMenuInfo.dVj() == null) || (!paramAnonymousContextMenuInfo.dVj().dZA()))
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (c.a(c.this, paramAnonymousContextMenuInfo).zMn != null)
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (com.tencent.mm.br.d.aJN("favorite"))
            {
              if (paramAnonymousContextMenuInfo.dVj().dZA()) {
                paramAnonymousContextMenu.add(0, 20, 0, paramAnonymousView.getContext().getString(2131761941));
              }
              ec localec = new ec();
              localec.dql.dqc = paramAnonymousContextMenuInfo.eco();
              com.tencent.mm.sdk.b.a.IvT.l(localec);
              if (localec.dqm.dpK) {
                paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755836));
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
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(100205);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof p)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.az)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.h.aBq(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dAg);
          }
        }
        for (;;)
        {
          if (localObject != null)
          {
            if (!((p)localObject).Rt(32))
            {
              AppMethodBeat.o(100205);
              return false;
              if ((localObject instanceof p))
              {
                localObject = (p)localObject;
                continue;
              }
              if ((localObject instanceof com.tencent.mm.plugin.sns.ui.aq))
              {
                localObject = (com.tencent.mm.plugin.sns.ui.aq)localObject;
                localObject = ah.dXE().aBr(((com.tencent.mm.plugin.sns.ui.aq)localObject).dqc);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.az))
              {
                localObject = ((com.tencent.mm.plugin.sns.ui.az)paramAnonymousView.getTag()).dsN;
                localObject = ah.dXE().aBr((String)localObject);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                localObject = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).znm;
              }
            }
            else
            {
              if ((((p)localObject).dVj() == null) || (!((p)localObject).dVj().dZA()))
              {
                AppMethodBeat.o(100205);
                return false;
              }
              c.this.APL.a(paramAnonymousView, ((p)localObject).eco(), ((p)localObject).ebP());
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
    this.AQf = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100208);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof p)))
        {
          if (!(paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            break label177;
          }
          paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.h.aBq(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).dAg);
        }
        for (;;)
        {
          Object localObject;
          com.tencent.mm.plugin.sns.storage.a locala;
          if (com.tencent.mm.br.d.aJN("favorite"))
          {
            localObject = paramAnonymousContextMenuInfo.dVj();
            locala = c.a(c.this, paramAnonymousContextMenuInfo);
            if (((com.tencent.mm.plugin.sns.storage.b)localObject).dZz())
            {
              if (!((com.tencent.mm.plugin.sns.storage.b)localObject).dZv()) {
                break label192;
              }
              paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
          for (;;)
          {
            localObject = new ec();
            ((ec)localObject).dql.dqc = paramAnonymousContextMenuInfo.eco();
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
            if (((ec)localObject).dqm.dpK) {
              paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755836));
            }
            if (paramAnonymousContextMenuInfo != null) {
              com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            }
            AppMethodBeat.o(100208);
            return;
            label177:
            if (!(paramAnonymousContextMenuInfo instanceof p)) {
              break label222;
            }
            paramAnonymousContextMenuInfo = (p)paramAnonymousContextMenuInfo;
            break;
            label192:
            if (locala.zLR == 0) {
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
          label222:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(100207);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof p)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.h.aBq(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dAg);
          }
        }
        for (;;)
        {
          if (localObject != null) {
            c.this.APL.a(paramAnonymousView, ((p)localObject).eco(), ((p)localObject).ebP());
          }
          AppMethodBeat.o(100207);
          return true;
          if ((localObject instanceof p))
          {
            localObject = (p)localObject;
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
    this.AQb = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100209);
        if ((paramAnonymousView.getTag() instanceof s)) {
          c.this.AQg.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
        }
        AppMethodBeat.o(100209);
      }
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(100210);
        if ((paramAnonymousView.getTag() instanceof s))
        {
          String str = ((s)paramAnonymousView.getTag()).dqc;
          p localp = ah.dXE().aBr(str);
          c.this.APL.a(paramAnonymousView, str, localp.ebP());
          AppMethodBeat.o(100210);
          return true;
        }
        AppMethodBeat.o(100210);
        return false;
      }
    };
    this.AQh = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100211);
        if (com.tencent.mm.br.d.aJN("favorite")) {
          paramAnonymousContextMenu.add(0, 24, 0, paramAnonymousView.getContext().getString(2131761941));
        }
        AppMethodBeat.o(100211);
      }
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(100212);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.ag))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.ag)paramAnonymousView.getTag()).dqc;
          p localp = ah.dXE().aBr(str);
          c.this.APL.a(paramAnonymousView, str, localp.ebP());
          AppMethodBeat.o(100212);
          return true;
        }
        AppMethodBeat.o(100212);
        return false;
      }
    };
    this.AQa = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100214);
        int j;
        int i;
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.az)))
        {
          paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.az)paramAnonymousView.getTag()).dsN;
          p localp = ah.dXE().aBr(paramAnonymousContextMenuInfo);
          if (com.tencent.mm.br.d.aJN("favorite"))
          {
            paramAnonymousContextMenu.add(0, 2, 0, c.this.activity.getString(2131761941));
            ec localec = new ec();
            localec.dql.dqc = paramAnonymousContextMenuInfo;
            com.tencent.mm.sdk.b.a.IvT.l(localec);
            if (localec.dqm.dpK) {
              paramAnonymousContextMenu.add(0, 18, 0, c.this.activity.getString(2131755836));
            }
          }
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, localp);
          paramAnonymousContextMenu = paramAnonymousContextMenu.add(0, 21, 0, c.this.activity.getString(2131763809));
          paramAnonymousContextMenuInfo = new int[2];
          if (paramAnonymousView == null) {
            break label238;
          }
          j = paramAnonymousView.getWidth();
          i = paramAnonymousView.getHeight();
          paramAnonymousView.getLocationInWindow(paramAnonymousContextMenuInfo);
        }
        for (;;)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("img_gallery_width", j).putExtra("img_gallery_height", i).putExtra("img_gallery_left", paramAnonymousContextMenuInfo[0]).putExtra("img_gallery_top", paramAnonymousContextMenuInfo[1]);
          paramAnonymousContextMenu.setIntent(paramAnonymousView);
          AppMethodBeat.o(100214);
          return;
          label238:
          i = 0;
          j = 0;
        }
      }
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(100213);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.az))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.az)paramAnonymousView.getTag()).dsN;
          p localp = ah.dXE().aBr(str);
          c.this.APL.a(paramAnonymousView, str, localp.ebP());
          AppMethodBeat.o(100213);
          return true;
        }
        AppMethodBeat.o(100213);
        return false;
      }
    };
    this.AQd = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(220112);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.az)) {
          paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.az)paramAnonymousContextMenuInfo).dsN;
        }
        for (;;)
        {
          if (paramAnonymousContextMenuInfo != null)
          {
            paramAnonymousContextMenuInfo = ah.dXE().aBr(paramAnonymousContextMenuInfo);
            TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.ebP();
            if (com.tencent.mm.br.d.aJN("favorite")) {
              switch (localTimeLineObject.HUG.Gtw)
              {
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            AppMethodBeat.o(220112);
            return;
            if (!(paramAnonymousContextMenuInfo instanceof s)) {
              break label158;
            }
            paramAnonymousContextMenuInfo = ((s)paramAnonymousContextMenuInfo).dqc;
            break;
            paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131761941));
          }
          label158:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(220111);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof com.tencent.mm.plugin.sns.ui.az)) {
          localObject = ((com.tencent.mm.plugin.sns.ui.az)localObject).dsN;
        }
        for (;;)
        {
          if (localObject != null)
          {
            p localp = ah.dXE().aBr((String)localObject);
            c.this.APL.a(paramAnonymousView, (String)localObject, localp.ebP());
            AppMethodBeat.o(220111);
            return true;
            if ((localObject instanceof s)) {
              localObject = ((s)localObject).dqc;
            }
          }
          else
          {
            AppMethodBeat.o(220111);
            return false;
          }
          localObject = null;
        }
      }
    };
    this.AiC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100216);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        localObject1 = null;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.az)) {
          localObject1 = ((com.tencent.mm.plugin.sns.ui.az)paramAnonymousView.getTag()).dsN;
        }
        Object localObject2;
        for (;;)
        {
          localObject2 = com.tencent.mm.plugin.sns.storage.h.aBr((String)localObject1);
          if (localObject2 != null) {
            break;
          }
          ae.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(localObject1)));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
          if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dqc;
          } else if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
            localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).znm.eco();
          }
        }
        if ((((p)localObject2).Rt(32)) && (((p)localObject2).dVj() != null) && ((((p)localObject2).dVj().dZA()) || (((p)localObject2).dVj().dZB())))
        {
          c.this.AQy.onClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
        }
        if (((p)localObject2).ebP().HUG.Gtw == 21)
        {
          if (v.aAC().equals(((p)localObject2).field_userName))
          {
            ((p)localObject2).ebP();
            com.tencent.mm.plugin.sns.lucky.a.m.r((p)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.m.q((p)localObject2);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.md(25);
          }
          if (!v.aAC().equals(((p)localObject2).field_userName))
          {
            com.tencent.mm.plugin.sns.lucky.b.a.a(2, (p)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.b.md(30);
          }
        }
        int j;
        int i;
        Object localObject3;
        if (((p)localObject2).Rt(32))
        {
          localObject1 = c.a(c.this, (p)localObject2);
          if ((((p)localObject2).dVj().dZv()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aBm(((p)localObject2).ecy().field_adxml)))
          {
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J((p)localObject2);
            if (!bu.isNullOrNil((String)localObject1)) {
              ((p)localObject2).ecy().field_adxml = ((String)localObject1);
            }
            j = c.this.doj;
            if (c.this.doj == 0)
            {
              i = 1;
              localObject1 = new SnsAdClick(j, i, ((p)localObject2).field_snsId, 21, 21);
              com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject1, c.this.Asq, (p)localObject2, 21);
              com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject1);
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
              ((Intent)localObject1).putExtra("sns_landing_pages_share_sns_id", ((p)localObject2).getSnsId());
              ((Intent)localObject1).putExtra("sns_landing_pages_rawSnsId", ((p)localObject2).ebP().Id);
              ((Intent)localObject1).putExtra("sns_landing_pages_ux_info", ((p)localObject2).ecx());
              ((Intent)localObject1).putExtra("sns_landing_pages_aid", ((p)localObject2).ect());
              ((Intent)localObject1).putExtra("sns_landing_pages_traceid", ((p)localObject2).ecu());
              localObject3 = ((p)localObject2).ebP();
              if (localObject3 != null)
              {
                localObject3 = ((TimeLineObject)localObject3).HUG.Gtx;
                if (((List)localObject3).size() > 0)
                {
                  ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((bzh)((List)localObject3).get(0)).Hmj);
                  ((Intent)localObject1).putExtra("sns_landing_pages_from_outer_index", ((com.tencent.mm.plugin.sns.ui.az)paramAnonymousView.getTag()).index);
                }
              }
              ((Intent)localObject1).setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
              if (c.this.doj != 2) {
                break label1040;
              }
              i = 16;
            }
          }
        }
        for (;;)
        {
          label702:
          ((Intent)localObject1).putExtra("sns_landig_pages_from_source", i);
          ((Intent)localObject1).putExtra("sns_landing_pages_xml", ((p)localObject2).ecy().field_adxml);
          ((Intent)localObject1).putExtra("sns_landing_pages_rec_src", ((p)localObject2).ecz());
          ((Intent)localObject1).putExtra("sns_landing_pages_xml_prefix", "adxml");
          ((Intent)localObject1).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
          ((Intent)localObject1).putExtra("sns_landing_pages_is_normal_ad_animation", true);
          localObject3 = c.this.activity;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          c.this.activity.overridePendingTransition(0, 0);
          if (c.this.AgN != null) {
            c.this.AgN.dXi().F((p)localObject2);
          }
          label896:
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.az)paramAnonymousView.getTag();
          if ((paramAnonymousView.Arr) && (localObject2 != null))
          {
            com.tencent.mm.plugin.sns.ui.a.c.g((p)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.ui.a.c.h((p)localObject2, paramAnonymousView.index);
            bb.aAy(((p)localObject2).eco());
          }
          if (localObject2 != null)
          {
            localObject1 = ((p)localObject2).ebP();
            if (localObject1 != null) {
              if (((TimeLineObject)localObject1).HUF != null) {
                break label1276;
              }
            }
          }
          label1040:
          label1276:
          for (paramAnonymousView = null;; paramAnonymousView = ((TimeLineObject)localObject1).HUF.Id)
          {
            if (!bu.isNullOrNil(paramAnonymousView))
            {
              localObject2 = com.tencent.mm.plugin.sns.c.a.iUA.fC(paramAnonymousView);
              com.tencent.mm.plugin.sns.c.a.iUA.a(null, paramAnonymousView, (String)localObject2, ((TimeLineObject)localObject1).nIJ, 2, 4, 4, ((TimeLineObject)localObject1).HUK, ((TimeLineObject)localObject1).Id);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100216);
            return;
            i = 2;
            break;
            if (c.this.doj != 1) {
              break label1288;
            }
            i = 2;
            break label702;
            if (c.a(c.this, (com.tencent.mm.plugin.sns.storage.a)localObject1, (p)localObject2, false))
            {
              j = c.this.doj;
              if (c.this.doj == 0) {}
              for (i = 1;; i = 2)
              {
                localObject1 = new SnsAdClick(j, i, ((p)localObject2).field_snsId, 21, 31);
                com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject1, c.this.Asq, (p)localObject2, 21);
                com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject1);
                break;
              }
            }
            if (bh.R((p)localObject2) == 2)
            {
              if (com.tencent.mm.plugin.sns.ad.c.d.a(c.this.activity, ((p)localObject2).dVj(), (com.tencent.mm.plugin.sns.storage.a)localObject1, ((p)localObject2).field_snsId))
              {
                j = c.this.doj;
                if (c.this.doj == 0) {}
                for (i = 1;; i = 2)
                {
                  localObject1 = new SnsAdClick(j, i, ((p)localObject2).field_snsId, 21, 37);
                  com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject1, c.this.Asq, (p)localObject2, 21);
                  com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject1);
                  break;
                }
              }
              c.this.dJ(paramAnonymousView);
              break label896;
            }
            c.this.dJ(paramAnonymousView);
            break label896;
            c.this.dJ(paramAnonymousView);
            break label896;
          }
          label1288:
          i = 1;
        }
      }
    };
    this.APQ = new c.11(this);
    this.APR = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(100220);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        new f.a(c.this.activity).aZq(c.this.activity.getResources().getString(2131764024)).aZu(c.this.activity.getResources().getString(2131755707)).afZ(c.this.activity.getResources().getColor(2131100800)).b(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(220113);
            if (!(paramAnonymousView.getTag() instanceof String))
            {
              AppMethodBeat.o(220113);
              return;
            }
            paramAnonymous2String = (String)paramAnonymousView.getTag();
            ae.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymous2String)));
            p localp = ah.dXE().aBr(paramAnonymous2String);
            if (localp == null)
            {
              ae.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(220113);
              return;
            }
            Object localObject2;
            if (localp.ecq())
            {
              ae.i("MicroMsg.TimelineClickListener", "dead item");
              ah.dXE().Rx(localp.AdJ);
              if (c.this.AQz != null) {
                c.this.AQz.egw();
              }
              if (c.this.doj == 0)
              {
                localObject1 = com.tencent.mm.modelsns.e.pY(739);
                localObject2 = ((com.tencent.mm.modelsns.e)localObject1).GU(com.tencent.mm.plugin.sns.data.r.o(localp)).qb(localp.field_type);
                if (!localp.ecq()) {
                  break label234;
                }
                paramAnonymous2String = "2";
              }
              for (;;)
              {
                ((com.tencent.mm.modelsns.e)localObject2).GU(paramAnonymous2String);
                ((com.tencent.mm.modelsns.e)localObject1).aLH();
                if (localp.field_type == 21) {
                  com.tencent.mm.plugin.sns.lucky.a.g.dWC().dWE();
                }
                AppMethodBeat.o(220113);
                return;
                localObject1 = com.tencent.mm.modelsns.e.pZ(739);
                break;
                label234:
                if (localp.field_snsId == 0L) {
                  paramAnonymous2String = "1";
                } else {
                  paramAnonymous2String = "0";
                }
              }
            }
            if (localp.dXn())
            {
              ae.i("MicroMsg.TimelineClickListener", "cancel item " + localp.eco());
              ah.dXA().C(localp);
              if (bu.rZ(localp.field_createTime) < ar.zCR) {
                ah.dXO().w(localp);
              }
              c.this.edh();
              AppMethodBeat.o(220113);
              return;
            }
            ae.i("MicroMsg.TimelineClickListener", "delete by server");
            paramAnonymous2String = localp.getSnsId();
            ah.dXD().Al(x.aze(paramAnonymous2String));
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(new com.tencent.mm.plugin.sns.model.r(x.aze(paramAnonymous2String), 1), 0);
            if (bu.rZ(localp.field_createTime) < ar.zCR) {
              ah.dXO().w(localp);
            }
            ah.dXE().delete(x.aze(paramAnonymous2String));
            ah.dXJ().AB(x.aze(paramAnonymous2String));
            com.tencent.mm.plugin.sns.storage.i.AA(x.aze(paramAnonymous2String));
            c.this.edh();
            Object localObject1 = localp.ebP();
            if (localObject1 != null)
            {
              if (((TimeLineObject)localObject1).HUF != null) {
                break label630;
              }
              paramAnonymous2String = null;
              if ((!bu.isNullOrNil(paramAnonymous2String)) && (com.tencent.mm.plugin.sns.c.a.iUA.fE(paramAnonymous2String)))
              {
                localObject2 = com.tencent.mm.plugin.sns.c.a.iUA.fC(paramAnonymous2String);
                rc localrc = new rc();
                localrc.dGH.appId = paramAnonymous2String;
                localrc.dGH.dGJ = ((TimeLineObject)localObject1).nIJ;
                localrc.dGH.dGI = ((String)localObject2);
                localrc.dGH.mediaTagName = ((TimeLineObject)localObject1).HUK;
                com.tencent.mm.sdk.b.a.IvT.l(localrc);
              }
            }
            if (c.this.doj == 0)
            {
              localObject1 = com.tencent.mm.modelsns.e.pY(739);
              label582:
              localObject2 = ((com.tencent.mm.modelsns.e)localObject1).GU(com.tencent.mm.plugin.sns.data.r.o(localp)).qb(localp.field_type);
              if (!localp.ecq()) {
                break label651;
              }
              paramAnonymous2String = "2";
            }
            for (;;)
            {
              ((com.tencent.mm.modelsns.e)localObject2).GU(paramAnonymous2String);
              ((com.tencent.mm.modelsns.e)localObject1).aLH();
              AppMethodBeat.o(220113);
              return;
              label630:
              paramAnonymous2String = ((TimeLineObject)localObject1).HUF.Id;
              break;
              localObject1 = com.tencent.mm.modelsns.e.pZ(739);
              break label582;
              label651:
              if (localp.field_snsId == 0L) {
                paramAnonymous2String = "1";
              } else {
                paramAnonymous2String = "0";
              }
            }
          }
        }).aZv(c.this.activity.getResources().getString(2131755691)).a(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100220);
      }
    };
    this.APS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100221);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        paramAnonymousView = (String)paramAnonymousView.getTag();
        ae.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymousView)));
        paramAnonymousView = ah.dXE().aBr(paramAnonymousView).ebP();
        localObject1 = paramAnonymousView.zFf;
        if (((ba)localObject1).FKW == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
        }
        String str = com.tencent.mm.plugin.sns.c.a.iUA.fC(((ba)localObject1).FKW.ikm);
        int i = 0;
        if (paramAnonymousView.HUG.Gtw == 1) {
          i = 2;
        }
        while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(paramAnonymousView, c.this.activity))
        {
          com.tencent.mm.plugin.sns.c.a.iUA.a(c.this.activity, ((ba)localObject1).FKW.ikm, str, paramAnonymousView.nIJ, i, 11, 9, ((ba)localObject1).FKW.FKQ, paramAnonymousView.Id);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
          if (paramAnonymousView.HUG.Gtw == 3) {
            i = 5;
          } else if (paramAnonymousView.HUG.Gtw == 15) {
            i = 38;
          }
        }
        switch (((ba)localObject1).nJA)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("rawUrl", ((ba)localObject1).Url);
          com.tencent.mm.plugin.sns.c.a.iUz.i((Intent)localObject2, c.this.activity);
          com.tencent.mm.plugin.sns.c.a.iUA.a(c.this.activity, ((ba)localObject1).FKW.ikm, str, paramAnonymousView.nIJ, i, 11, 1, ((ba)localObject1).FKW.FKQ, paramAnonymousView.Id);
          continue;
          if (((ba)localObject1).Scene == 1)
          {
            localObject2 = new id();
            ((id)localObject2).dvK.actionCode = 2;
            ((id)localObject2).dvK.scene = 3;
            ((id)localObject2).dvK.appId = ((ba)localObject1).FKW.ikm;
            ((id)localObject2).dvK.context = c.this.activity;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
            com.tencent.mm.plugin.sns.c.a.iUA.a(c.this.activity, ((ba)localObject1).FKW.ikm, str, paramAnonymousView.nIJ, i, 11, 6, ((ba)localObject1).FKW.FKQ, paramAnonymousView.Id);
            continue;
            int j = com.tencent.mm.plugin.sns.ui.al.a(c.this.activity, (ba)localObject1);
            if (j == 1)
            {
              localObject2 = new id();
              ((id)localObject2).dvK.context = c.this.activity;
              ((id)localObject2).dvK.actionCode = 2;
              ((id)localObject2).dvK.appId = ((ba)localObject1).FKW.ikm;
              ((id)localObject2).dvK.messageAction = ((ba)localObject1).FKW.FKS;
              ((id)localObject2).dvK.messageExt = ((ba)localObject1).FKW.FKR;
              ((id)localObject2).dvK.scene = 3;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
              com.tencent.mm.plugin.sns.c.a.iUA.a(c.this.activity, ((ba)localObject1).FKW.ikm, str, paramAnonymousView.nIJ, i, 11, 6, ((ba)localObject1).FKW.FKQ, paramAnonymousView.Id);
            }
            else if (j == 2)
            {
              localObject2 = new id();
              ((id)localObject2).dvK.context = c.this.activity;
              ((id)localObject2).dvK.actionCode = 1;
              ((id)localObject2).dvK.appId = ((ba)localObject1).FKW.ikm;
              ((id)localObject2).dvK.messageAction = ((ba)localObject1).FKW.FKS;
              ((id)localObject2).dvK.messageExt = ((ba)localObject1).FKW.FKR;
              ((id)localObject2).dvK.scene = 3;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
              com.tencent.mm.plugin.sns.c.a.iUA.a(c.this.activity, ((ba)localObject1).FKW.ikm, str, paramAnonymousView.nIJ, i, 11, 3, ((ba)localObject1).FKW.FKQ, paramAnonymousView.Id);
            }
          }
        }
      }
    };
    this.APY = new View.OnClickListener()
    {
      private static void aCw(String paramAnonymousString)
      {
        AppMethodBeat.i(220114);
        long l = ah.dXE().aBr(paramAnonymousString).field_snsId;
        Object localObject1 = ah.dXE().AG(l);
        if (localObject1 != null)
        {
          Object localObject2 = ((p)localObject1).ebP();
          if (localObject2 != null)
          {
            localObject2 = ((TimeLineObject)localObject2).HUG.Gtx;
            if (((List)localObject2).size() > 0) {
              ((List)localObject2).get(0);
            }
          }
          localObject2 = com.tencent.mm.plugin.sns.model.al.v((p)localObject1);
          localObject1 = new ArrayList();
          localObject2 = ((SnsObject)localObject2).SnsRedEnvelops.HOu;
          if (localObject2 != null)
          {
            int i = 0;
            while (i < ((List)localObject2).size())
            {
              dgq localdgq = (dgq)((List)localObject2).get(i);
              com.tencent.mm.plugin.l.a.a locala = new com.tencent.mm.plugin.l.a.a();
              locala.lJm = localdgq.Username;
              locala.vuH = localdgq.CreateTime;
              locala.vuI = localdgq.HNn;
              ((List)localObject1).add(locala);
              i += 1;
            }
          }
          com.tencent.mm.plugin.l.a.v(paramAnonymousString, (List)localObject1);
        }
        AppMethodBeat.o(220114);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100223);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if ((paramAnonymousView.getTag() instanceof p))
        {
          paramAnonymousView = (p)paramAnonymousView.getTag();
          if ((paramAnonymousView.field_type == 21) && (v.aAC().equals(paramAnonymousView.field_userName)))
          {
            paramAnonymousView.ebP();
            com.tencent.mm.plugin.sns.lucky.a.m.r(paramAnonymousView);
            com.tencent.mm.plugin.sns.lucky.a.m.q(paramAnonymousView);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.md(24);
          }
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_sendid", paramAnonymousView.getSnsId());
          ((Intent)localObject2).putExtra("key_feedid", paramAnonymousView.eco());
          ((Intent)localObject2).setClassName(c.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
          localObject1 = c.this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = paramAnonymousView.eco();
          paramAnonymousView.getSnsId();
          aCw((String)localObject1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100223);
      }
    };
    this.APT = new c.16(this);
    this.APU = new c.17(this);
    this.APV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((paramAnonymousView.getTag() instanceof String))
        {
          paramAnonymousView = (String)paramAnonymousView.getTag();
          ae.d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(paramAnonymousView)));
          com.tencent.mm.plugin.sns.model.al.QF(x.aBN(paramAnonymousView));
          com.tencent.mm.plugin.sns.model.al.QD(x.aBN(paramAnonymousView));
          ah.dXA().dWc();
          c.this.edh();
          if (c.this.AQz != null) {
            c.this.AQz.egw();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100226);
      }
    };
    this.APW = new c.19(this);
    this.APZ = new d()
    {
      private static boolean c(com.tencent.mm.plugin.sns.ui.m paramAnonymousm)
      {
        AppMethodBeat.i(220116);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousm != null)
        {
          bool1 = bool2;
          if (paramAnonymousm.zyl != null)
          {
            bool1 = bool2;
            if (!bu.ht(paramAnonymousm.zyl.HNp)) {
              bool1 = true;
            }
          }
        }
        AppMethodBeat.o(220116);
        return bool1;
      }
      
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(220117);
        int i;
        long l;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          if (((!com.tencent.mm.plugin.sns.ui.widget.e.id(paramAnonymousView.zyl.HNo, 16)) || (paramAnonymousView.scene == 2)) && (!c(paramAnonymousView))) {
            paramAnonymousContextMenu.add(0, 11, 0, c.this.activity.getString(2131755701));
          }
          if ((com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE))
          {
            i = 1;
            if (((i != 0) && (!bu.isNullOrNil(paramAnonymousView.Ahb)) && (paramAnonymousView.Ahb.equals(v.aAC()))) || ((paramAnonymousView.nIJ != null) && (paramAnonymousView.nIJ.equals(v.aAC())))) {
              paramAnonymousContextMenu.add(0, 7, 0, c.this.activity.getString(2131755707));
            }
            if ((com.tencent.mm.plugin.sns.ui.widget.e.id(paramAnonymousView.zyl.HNo, 16)) || (c(paramAnonymousView))) {
              break label372;
            }
            paramAnonymousContextMenuInfo = paramAnonymousView.AgZ;
            StringBuilder localStringBuilder = new StringBuilder();
            if (paramAnonymousView.zyl.HNk == 0) {
              break label335;
            }
            l = paramAnonymousView.zyl.HNk;
            label224:
            paramAnonymousContextMenuInfo = as.jw(paramAnonymousContextMenuInfo, l);
            if (paramAnonymousView.scene != 1) {
              break label347;
            }
            i = 2;
          }
        }
        for (;;)
        {
          label250:
          paramAnonymousView = as.aAt(paramAnonymousContextMenuInfo);
          if ((paramAnonymousView != null) && (paramAnonymousView.hLB) && (!paramAnonymousView.aGQ) && ((i & paramAnonymousView.eQZ) != 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label367;
            }
            as.a(paramAnonymousContextMenu, false);
            AppMethodBeat.o(220117);
            return;
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qIJ, 0) == 1)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
            label335:
            l = paramAnonymousView.zyl.HNm;
            break label224;
            label347:
            if (paramAnonymousView.scene != 2) {
              break label378;
            }
            i = 4;
            break label250;
          }
          label367:
          as.b(paramAnonymousContextMenu, false);
          label372:
          AppMethodBeat.o(220117);
          return;
          label378:
          i = -1;
        }
      }
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(220118);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject = ah.dXE().aBq(((com.tencent.mm.plugin.sns.ui.m)localObject).AgZ);
          c.this.APL.a(paramAnonymousView, ((p)localObject).eco(), ((p)localObject).ebP());
          AppMethodBeat.o(220118);
          return true;
        }
        AppMethodBeat.o(220118);
        return false;
      }
    };
    this.tVH = new c.21(this);
    this.AQj = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100232);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousView.getTag() instanceof bd))
        {
          paramAnonymousView = (bd)paramAnonymousView.getTag();
          localObject = ah.dXE().aBq(paramAnonymousView.dAg);
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100232);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((p)localObject).ebP().HUD);
          paramAnonymousView.putExtra("sns_local_id", ((p)localObject).eco());
          paramAnonymousView.setClass(c.this.activity, SnsSingleTextViewUI.class);
          localObject = c.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject).startActivity((Intent)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100232);
      }
    };
    this.AQm = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100239);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        s locals;
        Object localObject2;
        Object localObject3;
        String str1;
        int i;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          localObject2 = (bzh)locals.Ahs.HUG.Gtx.get(0);
          localObject1 = locals.dqc;
          ah.dXE().aBq((String)localObject1);
          localObject1 = "";
          localObject3 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject2).Id);
          str1 = "";
          String str2 = com.tencent.mm.plugin.sns.data.r.i((bzh)localObject2);
          if (o.fB((String)localObject3 + str2))
          {
            localObject1 = (String)localObject3 + str2;
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.r.d((bzh)localObject2);
          }
          if (o.fB((String)localObject3 + com.tencent.mm.plugin.sns.data.r.o((bzh)localObject2)))
          {
            localObject1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.r.o((bzh)localObject2);
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.r.m((bzh)localObject2);
          }
          localObject2 = new int[2];
          localObject3 = paramAnonymousView.findViewById(2131298769);
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
          paramAnonymousView.putExtra("intent_localid", locals.dqc);
          paramAnonymousView.putExtra("intent_isad", false);
          paramAnonymousView.putExtra("intent_from_scene", c.this.doj);
          paramAnonymousView.putExtra("img_gallery_left", localObject2[0]);
          paramAnonymousView.putExtra("img_gallery_top", localObject2[1]);
          paramAnonymousView.putExtra("img_gallery_width", i);
          paramAnonymousView.putExtra("img_gallery_height", j);
          localObject1 = c.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)paramAnonymousView.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          c.this.activity.overridePendingTransition(0, 0);
          c.a(c.this, locals.Ahs);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100239);
          return;
          label535:
          paramAnonymousView.getLocationInWindow((int[])localObject2);
          i = paramAnonymousView.getWidth();
        }
      }
    };
    this.AQl = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220121);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        ae.i("MicroMsg.TimelineClickListener", "onsight click");
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq)) {
          localObject1 = (com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag();
        }
        for (;;)
        {
          final p localp = ah.dXE().aBr(((com.tencent.mm.plugin.sns.ui.aq)localObject1).dqc);
          if (localp == null)
          {
            ae.i("MicroMsg.TimelineClickListener", "onsight click but info is null localid %s", new Object[] { ((com.tencent.mm.plugin.sns.ui.aq)localObject1).dqc });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(220121);
            return;
            if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
            {
              localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).AKJ;
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
              localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).AKJ;
            }
          }
          else
          {
            if (c.this.AgN != null) {
              c.this.AgN.dXi().F(localp);
            }
            final boolean bool = localp.Rt(32);
            if ((bool) && (localp.dVj() != null) && ((localp.dVj().dZA()) || (localp.dVj().dZB())))
            {
              c.this.AQy.onClick(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(220121);
              return;
            }
            final TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnF;
            if ((localTimeLineObject.HUG.Gtx == null) || (localTimeLineObject.HUG.Gtx.size() == 0))
            {
              ae.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(220121);
              return;
            }
            final bzh localbzh = (bzh)localTimeLineObject.HUG.Gtx.get(0);
            if (bool)
            {
              ah.dXB();
              if (!com.tencent.mm.plugin.sns.model.g.t(localbzh))
              {
                ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWJ.setVisibility(8);
                ((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnK.setVisibility(0);
                ((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnK.fPL();
                ah.dXB().z(localbzh);
                paramAnonymousView = ah.dXz();
                localObject1 = bk.fvs();
                ((bk)localObject1).heF = localTimeLineObject.CreateTime;
                paramAnonymousView.a(localbzh, 4, null, (bk)localObject1);
                if (bool) {
                  n.a(n.b.zqs, n.a.zqj, localp, c.this.doj);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220121);
                return;
              }
            }
            if ((localp.Rt(32)) && (localp.dVj().dZv()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aBm(localp.ecy().field_adxml))) {}
            int j;
            Object localObject3;
            for (int i = 1; (i == 0) && (bool) && (ah.dXB().u(localbzh)); i = 0)
            {
              ah.dXB().z(localbzh);
              ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWJ.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnK.setVisibility(8);
              paramAnonymousView = ah.dXB();
              localObject2 = ((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnH;
              i = c.this.activity.hashCode();
              j = ((com.tencent.mm.plugin.sns.ui.aq)localObject1).position;
              localObject3 = bk.fvs();
              ((bk)localObject3).heF = localTimeLineObject.CreateTime;
              paramAnonymousView.a(localp, localbzh, (VideoSightView)localObject2, i, j, (bk)localObject3, bool);
              ((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnH.start();
              if (bool) {
                n.a(n.b.zqs, n.a.zqj, localp, c.this.doj);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(220121);
              return;
            }
            com.tencent.mm.modelsns.e locale;
            label754:
            int m;
            label809:
            label830:
            int k;
            if (c.this.doj == 0)
            {
              localObject2 = com.tencent.mm.modelsns.e.pY(717);
              ((com.tencent.mm.modelsns.e)localObject2).GU(com.tencent.mm.plugin.sns.data.r.o(localp)).qb(localp.field_type).eV(localp.Rt(32)).GU(localp.ecx()).GU(localbzh.Id);
              ((com.tencent.mm.modelsns.e)localObject2).aLH();
              if (c.this.doj != 0) {
                break label1546;
              }
              locale = com.tencent.mm.modelsns.e.pY(745);
              locale.GU(com.tencent.mm.plugin.sns.data.r.o(localp)).qb(localp.field_type).eV(localp.Rt(32));
              if (bool)
              {
                m = c.this.doj;
                if (c.this.doj != 0) {
                  break label1557;
                }
                i = 1;
                long l = localp.field_snsId;
                if (!localp.dVj().dZv()) {
                  break label1562;
                }
                j = 21;
                if (!localp.dVj().dZv()) {
                  break label1568;
                }
                k = 21;
                label845:
                localObject2 = new SnsAdClick(m, i, l, j, k);
                if (!localp.dVj().dZv()) {
                  break label1574;
                }
                com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, c.this.Asq, localp, 21);
              }
            }
            Object localObject4;
            for (;;)
            {
              com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject2);
              if ((!localp.dVj().dZv()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aBm(localp.ecy().field_adxml))) {
                n.a(n.b.zqs, n.a.zqk, localp, c.this.doj);
              }
              localObject2 = "";
              localObject4 = ap.jv(ah.getAccSnsPath(), localbzh.Id);
              localObject3 = "";
              String str = com.tencent.mm.plugin.sns.data.r.i(localbzh);
              if (o.fB((String)localObject4 + str))
              {
                localObject2 = (String)localObject4 + str;
                localObject3 = (String)localObject4 + com.tencent.mm.plugin.sns.data.r.d(localbzh);
              }
              if (o.fB((String)localObject4 + com.tencent.mm.plugin.sns.data.r.o(localbzh)))
              {
                localObject2 = (String)localObject4 + com.tencent.mm.plugin.sns.data.r.o(localbzh);
                localObject3 = (String)localObject4 + com.tencent.mm.plugin.sns.data.r.m(localbzh);
              }
              localObject4 = new int[2];
              paramAnonymousView.getLocationInWindow((int[])localObject4);
              i = paramAnonymousView.getWidth();
              j = paramAnonymousView.getHeight();
              com.tencent.mm.plugin.report.service.g.yxI.f(11444, new Object[] { Integer.valueOf(3) });
              if (bool) {
                break label1593;
              }
              ae.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
              paramAnonymousView = new Intent();
              paramAnonymousView.setClass(c.this.activity, SnsOnlineVideoActivity.class);
              paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
              paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
              paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.aq)localObject1).dqc);
              paramAnonymousView.putExtra("intent_isad", bool);
              paramAnonymousView.putExtra("intent_from_scene", c.this.doj);
              paramAnonymousView.putExtra("sns_video_scene", ((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnM);
              localObject2 = com.tencent.mm.plugin.sns.ui.video.d.eir().aCB(localTimeLineObject.Id);
              if ((localObject2 != null) && (((SnsTimelineVideoView)localObject2).isPlaying()))
              {
                paramAnonymousView.putExtra("intent_fromplayingvideo", true);
                paramAnonymousView.putExtra("intent_fromplayingvideo_tlobjid", localTimeLineObject.Id);
                paramAnonymousView.putExtra("intent_session_id", ((SnsTimelineVideoView)localObject2).getSessionId());
                paramAnonymousView.putExtra("intent_session_timestamp", ((SnsTimelineVideoView)localObject2).getSessionTimestamp());
                if (((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnG != null) {
                  ((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnG.findViewById(2131305799).setVisibility(0);
                }
              }
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              locale.b(paramAnonymousView, "intent_key_StatisticsOplog");
              localObject1 = c.this.activity;
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Activity)localObject1).startActivity((Intent)paramAnonymousView.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              c.this.activity.overridePendingTransition(0, 0);
              c.a(c.this, localp.ebP());
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(220121);
              return;
              localObject2 = com.tencent.mm.modelsns.e.pZ(717);
              break;
              label1546:
              locale = com.tencent.mm.modelsns.e.pZ(745);
              break label754;
              label1557:
              i = 2;
              break label809;
              label1562:
              j = 17;
              break label830;
              label1568:
              k = 0;
              break label845;
              label1574:
              com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject2, c.this.Asq, localp, 17);
            }
            label1593:
            if ((localp.Rt(32)) && (localp.dVj().dZv()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.aBm(localp.ecy().field_adxml)))
            {
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J(localp);
              if (!bu.isNullOrNil(paramAnonymousView)) {
                localp.ecy().field_adxml = paramAnonymousView;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
              paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.ebP().Id);
              paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.ecx());
              localObject1 = localp.ebP();
              if (localObject1 != null)
              {
                localObject1 = ((TimeLineObject)localObject1).HUG.Gtx;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((bzh)((List)localObject1).get(0)).Hmj);
                }
              }
              paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
              i = 1;
              if (c.this.doj == 2) {
                i = 16;
              }
              for (;;)
              {
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", localp.ecy().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.ecz());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                paramAnonymousView.putExtra("sns_landing_pages_is_normal_ad_animation", true);
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject1 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.this.activity.overridePendingTransition(0, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(220121);
                return;
                if (c.this.doj == 1) {
                  i = 2;
                }
              }
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(c.this.activity, SnsSightPlayerUI.class);
            paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
            paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
            paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.aq)localObject1).dqc);
            paramAnonymousView.putExtra("intent_isad", bool);
            paramAnonymousView.putExtra("intent_from_scene", c.this.doj);
            paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
            paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
            paramAnonymousView.putExtra("img_gallery_width", i);
            paramAnonymousView.putExtra("img_gallery_height", j);
            locale.b(paramAnonymousView, "intent_key_StatisticsOplog");
            Object localObject2 = c.this.activity;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramAnonymousView.ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject2).startActivity((Intent)paramAnonymousView.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            c.this.activity.overridePendingTransition(0, 0);
            new com.tencent.mm.sdk.platformtools.aq().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(220120);
                if (ah.dXB().u(localbzh))
                {
                  this.AQL.AnH.e(null, false, 0);
                  com.tencent.mm.plugin.sns.model.g localg = ah.dXB();
                  p localp = localp;
                  bzh localbzh = localbzh;
                  VideoSightView localVideoSightView = this.AQL.AnH;
                  int i = c.this.activity.hashCode();
                  int j = this.AQL.position;
                  bk localbk = bk.fvs();
                  localbk.heF = localTimeLineObject.CreateTime;
                  localg.a(localp, localbzh, localVideoSightView, i, j, localbk, bool);
                  this.AQL.AnH.start();
                  this.AQL.zWJ.setVisibility(0);
                  this.AQL.AnK.setVisibility(8);
                  this.AQL.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(c.this.activity, 2131691166));
                }
                AppMethodBeat.o(220120);
              }
            }, 500L);
            paramAnonymousView = new int[3];
            if ((!bool) && (ah.dXB().a(localp, paramAnonymousView) > 5))
            {
              ah.dXB().y(localbzh);
              i = 1;
            }
            label2313:
            label2917:
            for (;;)
            {
              int n = paramAnonymousView[0];
              int i1 = paramAnonymousView[1];
              if (i == 2) {}
              for (m = 1;; m = 0)
              {
                for (;;)
                {
                  int i2 = paramAnonymousView[2];
                  paramAnonymousView = localp.ebP();
                  localObject1 = new com.tencent.mm.modelsns.g();
                  ((com.tencent.mm.modelsns.g)localObject1).m("20FeedId", paramAnonymousView.Id + ",");
                  ((com.tencent.mm.modelsns.g)localObject1).m("21AdUxInfo", localp.ecx() + ",");
                  for (;;)
                  {
                    try
                    {
                      paramAnonymousView = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
                      if (paramAnonymousView.ObjectOperations == null) {
                        continue;
                      }
                      paramAnonymousView = (dhb)new dhb().parseFrom(paramAnonymousView.ObjectOperations.getBufferToBytes());
                      if (paramAnonymousView.HOe == null) {
                        continue;
                      }
                      k = paramAnonymousView.HOe.GuO;
                    }
                    catch (Exception paramAnonymousView)
                    {
                      k = 0;
                      ae.printErrStackTrace("MicroMsg.TimelineClickListener", paramAnonymousView, "", new Object[0]);
                      j = 0;
                      continue;
                      if (com.tencent.mm.sdk.platformtools.az.is2G(ak.getContext()))
                      {
                        i = 2;
                        continue;
                      }
                      if (com.tencent.mm.sdk.platformtools.az.is3G(ak.getContext()))
                      {
                        i = 3;
                        continue;
                      }
                      if (!com.tencent.mm.sdk.platformtools.az.is4G(ak.getContext())) {
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
                      j = paramAnonymousView.HOe.GuP;
                      ((com.tencent.mm.modelsns.g)localObject1).m("22LayerId", k + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("23ExpId", j + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("24ClickState", i + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("25ClickTime", bu.aRi() + ",");
                      i = 0;
                      if (!com.tencent.mm.sdk.platformtools.az.isWifi(ak.getContext())) {
                        continue;
                      }
                      i = 1;
                      ((com.tencent.mm.modelsns.g)localObject1).m("26NetworkType", i + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("27IsFlowControl", n + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("28AutoDownloadSetting", i1 + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("29IsAutoPlay", m + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("30IsFlowControlDatePeriod", i2 + ",");
                      ae.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + ((com.tencent.mm.modelsns.g)localObject1).RD());
                      com.tencent.mm.plugin.report.service.g.yxI.f(13323, new Object[] { localObject1 });
                    }
                    catch (Exception paramAnonymousView) {}
                  }
                }
                if ((!bool) || (ah.dXB().b(localp, paramAnonymousView) <= 5)) {
                  break label2917;
                }
                ah.dXB().y(localbzh);
                i = 1;
                break label2313;
              }
            }
          }
          localObject1 = null;
        }
      }
    };
    this.AQc = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(220122);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag();
          if (!paramAnonymousView.isAd) {
            paramAnonymousContextMenu.add(0, 19, 0, c.this.activity.getString(2131757227));
          }
          if (bu.aSB(com.tencent.mm.n.g.acL().getValue("SIGHTCannotTransmitForFav")) != 0) {
            break label308;
          }
          if (paramAnonymousView.AnF.HUG.Gtx.size() <= 0) {
            break label301;
          }
          paramAnonymousContextMenuInfo = (bzh)paramAnonymousView.AnF.HUG.Gtx.get(0);
          String str = paramAnonymousContextMenuInfo.Id;
          str = ap.jv(ah.getAccSnsPath(), str) + com.tencent.mm.plugin.sns.data.r.d(paramAnonymousContextMenuInfo);
          paramAnonymousContextMenuInfo = aw.a(paramAnonymousView.dqc, paramAnonymousContextMenuInfo);
          boolean bool1 = o.fB(str);
          boolean bool2 = o.fB(paramAnonymousContextMenuInfo);
          ae.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool1) || (!bool2)) {
            break label308;
          }
        }
        label301:
        label308:
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.br.d.aJN("favorite")) {
            paramAnonymousContextMenu.add(0, 10, 0, c.this.activity.getString(2131761941));
          }
          if (i != 0)
          {
            paramAnonymousContextMenuInfo = new ec();
            paramAnonymousContextMenuInfo.dql.dqc = paramAnonymousView.dqc;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousContextMenuInfo);
            if (paramAnonymousContextMenuInfo.dqm.dpK) {
              paramAnonymousContextMenu.add(0, 18, 0, c.this.activity.getString(2131755836));
            }
          }
          AppMethodBeat.o(220122);
          return;
          ae.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
        }
      }
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(220123);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag()).dqc;
          p localp = ah.dXE().aBr(str);
          c.this.APL.a(paramAnonymousView, str, localp.ebP());
          AppMethodBeat.o(220123);
          return true;
        }
        AppMethodBeat.o(220123);
        return false;
      }
    };
    this.AQn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220124);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        c.this.fd(paramAnonymousView);
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220124);
          return;
        }
        localObject = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
        paramAnonymousView = ah.dXE().aBr(((com.tencent.mm.plugin.sns.data.b)localObject).dqc);
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220124);
          return;
        }
        int j;
        if (paramAnonymousView.Rt(32))
        {
          ((com.tencent.mm.plugin.sns.data.b)localObject).zte = System.currentTimeMillis();
          j = c.this.doj;
          if (c.this.doj != 0) {
            break label216;
          }
        }
        label216:
        for (int i = 1;; i = 2)
        {
          localObject = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 20, 0);
          com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject, c.this.Asq, paramAnonymousView, 20);
          com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220124);
          return;
        }
      }
    };
    this.AQu = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100244);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        ae.i("MicroMsg.TimelineClickListener", "unlike click");
        if (!(paramAnonymousAdapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c))
        {
          ae.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(100244);
          return;
        }
        Object localObject2 = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
        p localp = ah.dXE().aBr(((com.tencent.mm.plugin.sns.data.b)localObject2).dqc);
        if (localp == null) {
          try
          {
            c.this.edj();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          catch (Exception paramAnonymousAdapterView)
          {
            for (;;)
            {
              ae.e("MicroMsg.TimelineClickListener", "onUnLikeFinishError exp=" + paramAnonymousAdapterView.toString());
            }
          }
        }
        if (paramAnonymousInt == 0) {
          if (localp.Rt(32))
          {
            localObject1 = c.a(c.this, localp);
            if (localObject1 == null)
            {
              localObject1 = "";
              ((com.tencent.mm.plugin.sns.b.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.d.class)).a(11855, localp.ecz(), new Object[] { Integer.valueOf(3), localObject1, Integer.valueOf(localp.ecz()) });
            }
          }
          else
          {
            if (!((com.tencent.mm.plugin.sns.data.b)localObject2).ztd.AHi.zMo.dZt()) {
              break label406;
            }
            paramAnonymousView = (com.tencent.mm.plugin.sns.ui.c)paramAnonymousAdapterView.getAdapter();
            paramAnonymousView.kyd += 1;
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousAdapterView.setOnItemClickListener(c.this.AQv);
            c.this.edi();
            paramAnonymousAdapterView = new a.c.a();
            paramAnonymousAdapterView.zMK = a.c.a.zMG;
            paramAnonymousAdapterView.zte = ((com.tencent.mm.plugin.sns.data.b)localObject2).zte;
            paramAnonymousAdapterView.zML = 0L;
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.r(localp.field_snsId, 8, paramAnonymousAdapterView);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousAdapterView, 0);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(100244);
          return;
          localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).aQj;
          break;
          label406:
          if (((com.tencent.mm.plugin.sns.data.b)localObject2).ztd.AHi.zMs)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          c.this.fe(paramAnonymousView);
          paramAnonymousAdapterView = new a.c.a();
          paramAnonymousAdapterView.zte = ((com.tencent.mm.plugin.sns.data.b)localObject2).zte;
          paramAnonymousAdapterView.zML = System.currentTimeMillis();
          paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.r(localp.field_snsId, 8, paramAnonymousAdapterView);
          com.tencent.mm.kernel.g.ajS();
          com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousAdapterView, 0);
          continue;
          if (((com.tencent.mm.plugin.sns.data.b)localObject2).ztd.AHh.zNM == null)
          {
            ae.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          paramAnonymousAdapterView = ((com.tencent.mm.plugin.sns.data.b)localObject2).ztd.AHh.zNM;
          paramAnonymousInt -= 1;
          if (paramAnonymousInt < paramAnonymousAdapterView.list.size()) {
            paramAnonymousAdapterView = ((b.g)paramAnonymousAdapterView.list.get(paramAnonymousInt)).url;
          }
          try
          {
            paramAnonymousView = String.format("snsid=%s", new Object[] { localp.ebP().Id });
            localObject1 = String.format("aid=%s", new Object[] { localp.ect() });
            localObject2 = String.format("traceid=%s", new Object[] { localp.ecu() });
            com.tencent.mm.kernel.g.ajP();
            paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.n(paramAnonymousAdapterView, new String[] { paramAnonymousView, localObject1, localObject2, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.aiF() }) });
            paramAnonymousAdapterView = paramAnonymousView;
          }
          catch (Exception paramAnonymousView)
          {
            label701:
            break label701;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView);
          paramAnonymousView.putExtra("useJs", true);
          paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(localp.field_snsId));
          paramAnonymousView.putExtra("pre_username", localp.field_userName);
          paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(localp.field_snsId));
          paramAnonymousView.putExtra("preUsername", localp.field_userName);
          com.tencent.mm.plugin.sns.c.a.iUz.i(paramAnonymousView, c.this.activity);
        }
      }
    };
    this.AQv = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(220125);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
        {
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
          if (paramAnonymousInt < paramAnonymousAdapterView.ztd.AHi.zMo.dZs().size())
          {
            if (paramAnonymousAdapterView.ztd.AHi.zMs)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(220125);
              return;
            }
            localObject = (a.c.a)paramAnonymousAdapterView.ztd.AHi.zMo.dZs().get(paramAnonymousInt);
            ae.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[] { ((a.c.a)localObject).zMH, Integer.valueOf(((a.c.a)localObject).zMK) });
            p localp = ah.dXE().aBr(paramAnonymousAdapterView.dqc);
            if (localp == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(220125);
              return;
            }
            c.this.fe(paramAnonymousView);
            ((a.c.a)localObject).zte = paramAnonymousAdapterView.zte;
            ((a.c.a)localObject).zML = System.currentTimeMillis();
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.r(localp.field_snsId, 8, localObject);
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousAdapterView, 0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(220125);
      }
    };
    this.AQt = new c.30(this);
    this.AQy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220126);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if ((paramAnonymousView.getTag() == null) || ((!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.az)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq)) && (!(paramAnonymousView.getTag() instanceof MaskImageView)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220126);
          return;
        }
        localObject1 = null;
        int m = 0;
        int j = 0;
        int n = 0;
        int k = 0;
        int i = 0;
        Object localObject3;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.az))
        {
          localObject3 = com.tencent.mm.plugin.sns.storage.h.aBr(((com.tencent.mm.plugin.sns.ui.az)paramAnonymousView.getTag()).dsN);
          if ((paramAnonymousView instanceof LinearLayout))
          {
            i = 0;
            if (!((com.tencent.mm.plugin.sns.ui.az)paramAnonymousView.getTag()).AnN) {
              break label4759;
            }
            k = ((com.tencent.mm.plugin.sns.ui.az)paramAnonymousView.getTag()).index;
            if (k <= 0) {
              break label240;
            }
            j = 2;
          }
        }
        for (;;)
        {
          m = i;
          i = j;
          j = m;
          if ((localObject3 == null) || (!((p)localObject3).Rt(32)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(220126);
            return;
            i = 1;
            break;
            label240:
            j = 1;
            continue;
            if ((paramAnonymousView.getTag() instanceof MaskImageView))
            {
              localObject3 = (MaskImageView)paramAnonymousView.getTag();
              if (!(((MaskImageView)localObject3).getTag() instanceof com.tencent.mm.plugin.sns.ui.az)) {
                break label4754;
              }
              localObject3 = com.tencent.mm.plugin.sns.storage.h.aBr(((com.tencent.mm.plugin.sns.ui.az)((MaskImageView)localObject3).getTag()).dsN);
              localObject1 = localObject3;
              j = n;
              if ((paramAnonymousView instanceof LinearLayout)) {
                break label460;
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
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq))
            {
              localObject1 = (com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag();
              localObject3 = ah.dXE().aBr(((com.tencent.mm.plugin.sns.ui.aq)localObject1).dqc);
              if ((paramAnonymousView instanceof LinearLayout))
              {
                j = 0;
                label370:
                if (!((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnN) {
                  break label4745;
                }
                k = ((com.tencent.mm.plugin.sns.ui.aq)localObject1).AnO;
                if (k <= 0) {
                  break label400;
                }
                i = 2;
              }
            }
            for (;;)
            {
              break;
              j = 1;
              break label370;
              label400:
              i = 1;
              continue;
              if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
              {
                localObject3 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                localObject1 = com.tencent.mm.plugin.sns.storage.h.aBq(((BaseTimeLineItem.BaseViewHolder)localObject3).dAg);
                if (!(localObject3 instanceof m.b)) {
                  break label4740;
                }
                j = ((m.b)localObject3).APa.index;
                if (j > 0) {
                  i = 2;
                }
              }
              for (;;)
              {
                label460:
                k = j;
                j = 0;
                localObject3 = localObject1;
                break;
                i = 1;
                continue;
                if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))
                {
                  localObject3 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).znm;
                  localObject1 = localObject3;
                  j = n;
                  if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.e))
                  {
                    j = ((com.tencent.mm.plugin.sns.ui.c.a.e)paramAnonymousView.getTag()).currentIndex;
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
                        localObject1 = c.a(c.this, (p)localObject3);
                        if (localObject1 != null) {
                          continue;
                        }
                        localObject1 = "";
                        localObject4 = ((p)localObject3).ebP().Id;
                        if (!((p)localObject3).dZL())
                        {
                          localObject5 = com.tencent.mm.plugin.report.service.g.yxI;
                          if (c.this.doj != 0) {
                            continue;
                          }
                          m = 1;
                          if (j == 0) {
                            continue;
                          }
                          j = 1;
                          ((com.tencent.mm.plugin.report.service.g)localObject5).f(14066, new Object[] { Integer.valueOf(m), Integer.valueOf(j), localObject4, localObject1 });
                        }
                      }
                      catch (Exception localException)
                      {
                        ae.e("MicroMsg.TimelineClickListener", "report click ad card style error " + localException.getMessage());
                        continue;
                        localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject4).AKJ;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).AKJ;
                        continue;
                        if (c.this.AgN == null) {
                          continue;
                        }
                        c.this.AgN.dXi().F((p)localObject3);
                        boolean bool = ((p)localObject3).Rt(32);
                        if ((((TimeLineObject)localObject6).HUG.Gtx != null) && (((TimeLineObject)localObject6).HUG.Gtx.size() != 0)) {
                          continue;
                        }
                        ae.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(220126);
                        return;
                        bzh localbzh = (bzh)((TimeLineObject)localObject6).HUG.Gtx.get(k);
                        if (!bool) {
                          continue;
                        }
                        ah.dXB();
                        if ((com.tencent.mm.plugin.sns.model.g.t(localbzh)) || (localObject2 == null)) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).zWJ.setVisibility(8);
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).AnK.setVisibility(0);
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).AnK.fPL();
                        ah.dXB().z(localbzh);
                        paramAnonymousView = ah.dXz();
                        localObject2 = bk.fvs();
                        ((bk)localObject2).heF = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a(localbzh, 4, null, (bk)localObject2);
                        if (!bool) {
                          continue;
                        }
                        n.a(n.b.zqs, n.a.zqj, (p)localObject3, c.this.doj);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(220126);
                        return;
                        if ((!((p)localObject3).Rt(32)) || (!((p)localObject3).dVj().dZv())) {
                          continue;
                        }
                        String str = ((p)localObject3).ecy().field_adxml;
                        if (k <= 0) {
                          continue;
                        }
                        Object localObject5 = "adTurnCanvasInfo";
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jS(str, (String)localObject5)) {
                          continue;
                        }
                        m = 1;
                        if ((m != 0) || (!bool) || (!ah.dXB().u(localbzh)) || (localObject2 == null)) {
                          continue;
                        }
                        ah.dXB().z(localbzh);
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).zWJ.setVisibility(8);
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).AnK.setVisibility(8);
                        paramAnonymousView = ah.dXB();
                        Object localObject4 = ((com.tencent.mm.plugin.sns.ui.aq)localObject2).AnH;
                        i = c.this.activity.hashCode();
                        j = ((com.tencent.mm.plugin.sns.ui.aq)localObject2).position;
                        localObject5 = bk.fvs();
                        ((bk)localObject5).heF = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a((p)localObject3, localbzh, (VideoSightView)localObject4, i, j, (bk)localObject5, bool);
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).AnH.start();
                        if (!bool) {
                          continue;
                        }
                        n.a(n.b.zqs, n.a.zqj, (p)localObject3, c.this.doj);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(220126);
                        return;
                        localObject5 = "adCanvasInfo";
                        continue;
                        m = 0;
                        continue;
                        if (c.this.doj != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.e.pY(717);
                        ((com.tencent.mm.modelsns.e)localObject2).GU(com.tencent.mm.plugin.sns.data.r.o((p)localObject3)).qb(((p)localObject3).field_type).eV(((p)localObject3).Rt(32)).GU(((p)localObject3).ecx()).GU(localbzh.Id);
                        ((com.tencent.mm.modelsns.e)localObject2).aLH();
                        if (c.this.doj != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.e.pY(745);
                        ((com.tencent.mm.modelsns.e)localObject2).GU(com.tencent.mm.plugin.sns.data.r.o((p)localObject3)).qb(((p)localObject3).field_type).eV(((p)localObject3).Rt(32));
                        localObject2 = new int[2];
                        if (localObject4 == null) {
                          continue;
                        }
                        if (((BaseTimeLineItem.BaseViewHolder)localObject4).AKJ.AnJ == null) {
                          continue;
                        }
                        ((BaseTimeLineItem.BaseViewHolder)localObject4).AKJ.AnJ.getLocationInWindow((int[])localObject2);
                        j = ((BaseTimeLineItem.BaseViewHolder)localObject4).AKJ.AnJ.getWidth();
                        i = ((BaseTimeLineItem.BaseViewHolder)localObject4).AKJ.AnJ.getHeight();
                        com.tencent.mm.plugin.report.service.g.yxI.f(11444, new Object[] { Integer.valueOf(3) });
                        localObject4 = c.a(c.this, (p)localObject3);
                        if (!com.tencent.mm.plugin.sns.data.k.a(c.this.activity, (p)localObject3, (com.tencent.mm.plugin.sns.storage.a)localObject4, c.this.doj, c.this.Asq)) {
                          continue;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(220126);
                        return;
                        localObject2 = com.tencent.mm.modelsns.e.pZ(717);
                        continue;
                        localObject2 = com.tencent.mm.modelsns.e.pZ(745);
                        continue;
                        if (((TimeLineObject)localObject6).HUG.Gtw != 27) {
                          continue;
                        }
                        ((m.b)localObject4).AOY.getLocationInWindow((int[])localObject2);
                        j = ((m.b)localObject4).AOY.getWidth();
                        i = ((m.b)localObject4).AOY.getHeight();
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq)) {
                          continue;
                        }
                        localObject4 = (com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag();
                        if (localObject4 == null) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject4).AnJ.getLocationInWindow((int[])localObject2);
                        j = ((com.tencent.mm.plugin.sns.ui.aq)localObject4).AnJ.getWidth();
                        i = ((com.tencent.mm.plugin.sns.ui.aq)localObject4).AnJ.getHeight();
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
                        c.this.m((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag());
                        n = c.this.doj;
                        if (c.this.doj != 0) {
                          continue;
                        }
                        m = 1;
                        paramAnonymousView = new SnsAdClick(n, m, ((p)localObject3).field_snsId, 22, 21);
                        com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.Asq, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.r.a(paramAnonymousView);
                        localObject4 = new Intent();
                        ((Intent)localObject4).putExtra("img_gallery_left", localObject2[0]);
                        ((Intent)localObject4).putExtra("img_gallery_top", localObject2[1]);
                        ((Intent)localObject4).putExtra("img_gallery_width", j);
                        ((Intent)localObject4).putExtra("img_gallery_height", i);
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_sns_id", ((p)localObject3).getSnsId());
                        ((Intent)localObject4).putExtra("sns_landing_pages_rawSnsId", ((p)localObject3).ebP().Id);
                        ((Intent)localObject4).putExtra("sns_landing_pages_ux_info", ((p)localObject3).ecx());
                        paramAnonymousView = ((p)localObject3).ebP();
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView = paramAnonymousView.HUG.Gtx;
                        if (paramAnonymousView.size() <= k) {
                          continue;
                        }
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_thumb_url", ((bzh)paramAnonymousView.get(k)).Hmj);
                        ((Intent)localObject4).setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                        i = 1;
                        if (c.this.doj != 2) {
                          continue;
                        }
                        i = 16;
                        ((Intent)localObject4).putExtra("sns_landig_pages_from_source", i);
                        if (k <= 0) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dVj().dZJ();
                        ((Intent)localObject4).putExtra("sns_landing_pages_xml", paramAnonymousView);
                        ((Intent)localObject4).putExtra("sns_landing_pages_rec_src", ((p)localObject3).ecz());
                        ((Intent)localObject4).putExtra("sns_landing_pages_xml_prefix", "adxml");
                        ((Intent)localObject4).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        ((Intent)localObject4).putExtra("sns_landing_is_native_sight_ad", true);
                        paramAnonymousView = c.this.activity;
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject4);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        c.this.activity.overridePendingTransition(0, 0);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(220126);
                        return;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        c.this.a((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag());
                        continue;
                        m = 2;
                        continue;
                        if (c.this.doj != 1) {
                          continue;
                        }
                        i = 2;
                        continue;
                        paramAnonymousView = ((p)localObject3).ecy().field_adxml;
                        continue;
                        paramAnonymousView = c.this;
                        localObject2 = c.a(c.this, (p)localObject3);
                        if (k <= 0) {
                          continue;
                        }
                        bool = true;
                        if (!c.a(paramAnonymousView, (com.tencent.mm.plugin.sns.storage.a)localObject2, (p)localObject3, bool)) {
                          continue;
                        }
                        j = c.this.doj;
                        if (c.this.doj != 0) {
                          continue;
                        }
                        i = 1;
                        paramAnonymousView = new SnsAdClick(j, i, ((p)localObject3).field_snsId, 22, 31);
                        com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.Asq, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.r.a(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(220126);
                        return;
                        bool = false;
                        continue;
                        i = 2;
                        continue;
                        j = c.this.doj;
                        if (c.this.doj != 0) {
                          continue;
                        }
                        i = 1;
                        localObject4 = new SnsAdClick(j, i, ((p)localObject3).field_snsId, 22, 0);
                        com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject4, c.this.Asq, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject4);
                        if (k <= 0) {
                          continue;
                        }
                        localObject2 = ((p)localObject3).dVj().zNJ.zLV;
                        paramAnonymousView = (View)localObject2;
                        if (!bu.isNullOrNil((String)localObject2)) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).ecv();
                        if (!bu.isNullOrNil(paramAnonymousView)) {
                          continue;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(220126);
                        return;
                        i = 2;
                        continue;
                        localObject2 = ((p)localObject3).ecw();
                        continue;
                        ae.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject3).dVj().zMS);
                        localObject5 = new Intent();
                        if (((p)localObject3).dVj().zMS != 0) {
                          continue;
                        }
                        bool = true;
                        if (!ac.iRQ) {
                          continue;
                        }
                        bool = false;
                        localObject2 = paramAnonymousView;
                        if (localObject3 == null) {
                          continue;
                        }
                        localObject2 = paramAnonymousView;
                        if (!((p)localObject3).Rt(32)) {
                          continue;
                        }
                        Object localObject6 = c.a(c.this, (p)localObject3);
                        localObject2 = paramAnonymousView;
                        if (localObject6 == null) {
                          continue;
                        }
                        ((Intent)localObject5).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject6).aQj);
                        localObject2 = com.tencent.mm.plugin.sns.ad.b.a.a.ayT(com.tencent.mm.plugin.sns.data.r.jo(paramAnonymousView, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dGD));
                        com.tencent.mm.plugin.sns.data.r.g((Intent)localObject5, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dGD);
                        ((Intent)localObject5).putExtra("KRightBtn", bool);
                        paramAnonymousView = new Bundle();
                        paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                        paramAnonymousView.putString("key_snsad_statextstr", ((p)localObject3).ebP().AiG);
                        ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
                        ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                        ((Intent)localObject5).putExtra("useJs", true);
                        ((Intent)localObject5).putExtra("srcUsername", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("stastic_scene", 15);
                        ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("pre_username", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("preUsername", ((p)localObject3).field_userName);
                        com.tencent.mm.plugin.sns.c.a.iUz.i((Intent)localObject5, c.this.activity);
                        continue;
                        bool = false;
                        continue;
                        if (((((TimeLineObject)localObject6).HUG.Gtw != 1) || (((TimeLineObject)localObject6).HUG.Gtx.size() != 1)) && (((TimeLineObject)localObject6).HUG.Gtw != 7) && ((((TimeLineObject)localObject6).HUG.Gtw != 27) || (((TimeLineObject)localObject6).HUG.Gtx.size() <= k) || (((bzh)((TimeLineObject)localObject6).HUG.Gtx.get(k)).nJA != 2))) {
                          continue;
                        }
                        localObject2 = c.a(c.this, (p)localObject3);
                        if (!com.tencent.mm.plugin.sns.data.k.a(c.this.activity, (p)localObject3, (com.tencent.mm.plugin.sns.storage.a)localObject2, c.this.doj, c.this.Asq)) {
                          continue;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(220126);
                        return;
                        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                          continue;
                        }
                        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.a.a)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.item.a.a)paramAnonymousView.getTag()).ALi;
                        if (!((p)localObject3).dVj().dZv()) {
                          continue;
                        }
                        localObject5 = ((p)localObject3).ecy().field_adxml;
                        if (k <= 0) {
                          continue;
                        }
                        localObject4 = "adTurnCanvasInfo";
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jS((String)localObject5, (String)localObject4)) {
                          continue;
                        }
                        m = c.this.doj;
                        if (c.this.doj != 0) {
                          continue;
                        }
                        j = 1;
                        localObject4 = new SnsAdClick(m, j, ((p)localObject3).field_snsId, 21, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject4, c.this.Asq, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject4);
                        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                          continue;
                        }
                        c.this.m((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag());
                        paramAnonymousView = new int[2];
                        ((View)localObject2).getLocationInWindow(paramAnonymousView);
                        i = ((View)localObject2).getWidth();
                        j = ((View)localObject2).getHeight();
                        localObject2 = new Intent();
                        ((Intent)localObject2).putExtra("img_gallery_left", paramAnonymousView[0]);
                        ((Intent)localObject2).putExtra("img_gallery_top", paramAnonymousView[1]);
                        ((Intent)localObject2).putExtra("img_gallery_width", i);
                        ((Intent)localObject2).putExtra("img_gallery_height", j);
                        ((Intent)localObject2).putExtra("sns_landing_pages_share_sns_id", ((p)localObject3).getSnsId());
                        ((Intent)localObject2).putExtra("sns_landing_pages_rawSnsId", ((p)localObject3).ebP().Id);
                        ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", ((p)localObject3).ecx());
                        ((Intent)localObject2).putExtra("sns_landing_pages_aid", ((p)localObject3).ect());
                        ((Intent)localObject2).putExtra("sns_landing_pages_traceid", ((p)localObject3).ecu());
                        paramAnonymousView = ((p)localObject3).ebP();
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView = paramAnonymousView.HUG.Gtx;
                        if (paramAnonymousView.size() <= k) {
                          continue;
                        }
                        ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((bzh)paramAnonymousView.get(k)).Hmj);
                        ((Intent)localObject2).setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                        i = 1;
                        if (c.this.doj != 2) {
                          continue;
                        }
                        i = 16;
                        ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
                        if (k <= 0) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dVj().dZJ();
                        ((Intent)localObject2).putExtra("sns_landing_pages_xml", paramAnonymousView);
                        ((Intent)localObject2).putExtra("sns_landing_pages_rec_src", ((p)localObject3).ecz());
                        ((Intent)localObject2).putExtra("sns_landing_pages_xml_prefix", "adxml");
                        ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        paramAnonymousView = c.this.activity;
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        c.this.activity.overridePendingTransition(0, 0);
                        if (c.this.AgN == null) {
                          continue;
                        }
                        c.this.AgN.dXi().F((p)localObject3);
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.e.a)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.item.e.a)paramAnonymousView.getTag()).ALi;
                        continue;
                        if (!(localObject2 instanceof m.b)) {
                          continue;
                        }
                        localObject2 = (TagImageView)((m.b)localObject2).APa.view;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof k.a)) {
                          continue;
                        }
                        localObject2 = ((k.a)paramAnonymousView.getTag()).AOK;
                        continue;
                        localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject2).AMM.RH(0);
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).AKR;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.c)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.c)paramAnonymousView.getTag()).ALi;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.e)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.e)paramAnonymousView.getTag()).contentView;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.d)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.d)paramAnonymousView.getTag()).contentView;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof MaskImageView)) {
                          continue;
                        }
                        localObject2 = (MaskImageView)paramAnonymousView.getTag();
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof TagImageView)) {
                          continue;
                        }
                        localObject2 = (TagImageView)paramAnonymousView;
                        continue;
                        localObject4 = "adCanvasInfo";
                        continue;
                        j = 2;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        c.this.a((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag());
                        continue;
                        if (paramAnonymousView.size() <= 0) {
                          continue;
                        }
                        ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((bzh)paramAnonymousView.get(0)).Hmj);
                        continue;
                        if (c.this.doj != 1) {
                          continue;
                        }
                        i = 2;
                        continue;
                        paramAnonymousView = ((p)localObject3).ecy().field_adxml;
                        continue;
                        paramAnonymousView = c.this;
                        localObject2 = c.a(c.this, (p)localObject3);
                        if (k <= 0) {
                          continue;
                        }
                        bool = true;
                        if (!c.a(paramAnonymousView, (com.tencent.mm.plugin.sns.storage.a)localObject2, (p)localObject3, bool)) {
                          continue;
                        }
                        k = c.this.doj;
                        if (c.this.doj != 0) {
                          continue;
                        }
                        j = 1;
                        paramAnonymousView = new SnsAdClick(k, j, ((p)localObject3).field_snsId, 31, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.k.a(paramAnonymousView, c.this.Asq, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.r.a(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(220126);
                        return;
                        bool = false;
                        continue;
                        j = 2;
                        continue;
                        if (k <= 0) {
                          continue;
                        }
                        localObject2 = ((p)localObject3).dVj().zNJ.zLV;
                        paramAnonymousView = (View)localObject2;
                        if (!bu.isNullOrNil((String)localObject2)) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).ecv();
                        if (!bu.isNullOrNil(paramAnonymousView)) {
                          continue;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(220126);
                        return;
                        localObject2 = ((p)localObject3).ecw();
                        continue;
                        k = c.this.doj;
                        if (c.this.doj != 0) {
                          continue;
                        }
                        j = 1;
                        localObject4 = new SnsAdClick(k, j, ((p)localObject3).field_snsId, 0, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.k.a((SnsAdClick)localObject4, c.this.Asq, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.r.a((SnsAdClick)localObject4);
                        ae.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject3).dVj().zMS);
                        localObject5 = new Intent();
                        if (((p)localObject3).dVj().zMS != 0) {
                          continue;
                        }
                        bool = true;
                        if (!ac.iRQ) {
                          continue;
                        }
                        bool = false;
                        localObject2 = paramAnonymousView;
                        if (localObject3 == null) {
                          continue;
                        }
                        localObject2 = paramAnonymousView;
                        if (!((p)localObject3).Rt(32)) {
                          continue;
                        }
                        localObject6 = c.a(c.this, (p)localObject3);
                        localObject2 = paramAnonymousView;
                        if (localObject6 == null) {
                          continue;
                        }
                        ((Intent)localObject5).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject6).aQj);
                        localObject2 = com.tencent.mm.plugin.sns.ad.b.a.a.ayT(com.tencent.mm.plugin.sns.data.r.jo(paramAnonymousView, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dGD));
                        com.tencent.mm.plugin.sns.data.r.g((Intent)localObject5, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dGD);
                        ((Intent)localObject5).putExtra("KRightBtn", bool);
                        paramAnonymousView = new Bundle();
                        paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                        paramAnonymousView.putString("key_snsad_statextstr", ((p)localObject3).ebP().AiG);
                        ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
                        ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                        ((Intent)localObject5).putExtra("useJs", true);
                        ((Intent)localObject5).putExtra("srcUsername", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("stastic_scene", 15);
                        ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("pre_username", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.r.zV(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("preUsername", ((p)localObject3).field_userName);
                        com.tencent.mm.plugin.sns.c.a.iUz.i((Intent)localObject5, c.this.activity);
                        continue;
                        j = 2;
                        continue;
                        bool = false;
                        continue;
                        localObject2 = null;
                        continue;
                        i = 0;
                        j = 0;
                        continue;
                        continue;
                      }
                      if (((p)localObject3).ecy().dVj().dZG())
                      {
                        localObject1 = ((p)localObject3).ecy().dVj().dZy();
                        localObject4 = ((p)localObject3).ecx();
                        com.tencent.mm.kernel.g.ajP();
                        localObject5 = com.tencent.mm.kernel.a.aiF();
                        x.b((String)localObject1, (String)localObject4, (String)localObject5, x.aH((String)localObject1, (String)localObject4, (String)localObject5), 0, "");
                      }
                      localObject6 = ((p)localObject3).ebP();
                      if (((((TimeLineObject)localObject6).HUG.Gtw != 15) || (((TimeLineObject)localObject6).HUN == 1)) && ((((TimeLineObject)localObject6).HUG.Gtw != 27) || (((TimeLineObject)localObject6).HUG.Gtx.size() <= k) || (((bzh)((TimeLineObject)localObject6).HUG.Gtx.get(k)).nJA != 6))) {
                        continue;
                      }
                      ae.i("MicroMsg.TimelineClickListener", "onsight click");
                      localObject1 = null;
                      localObject4 = null;
                      if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq)) {
                        localObject1 = (com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag();
                      }
                      if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                        continue;
                      }
                      localObject4 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                      if (((TimeLineObject)localObject6).HUG.Gtw != 27) {
                        continue;
                      }
                      localObject1 = ((m.b)localObject4).APb;
                      if (localObject3 != null) {
                        continue;
                      }
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(220126);
                      return;
                      localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).aQj;
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
                  label4740:
                  i = 0;
                }
              }
              label4745:
              i = 0;
              k = m;
            }
            label4754:
            i = 0;
          }
          label4759:
          j = 0;
        }
      }
    };
    this.AQi = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(220128);
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)) && (com.tencent.mm.br.d.aJN("favorite"))) {
          paramAnonymousContextMenu.add(0, 25, 0, c.this.activity.getString(2131761941));
        }
        AppMethodBeat.o(220128);
      }
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(220127);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          TimeLineObject localTimeLineObject = (TimeLineObject)paramAnonymousView.getTag();
          Object localObject = ah.dXE();
          String str = localTimeLineObject.Id;
          p localp = new p();
          if (!((com.tencent.mm.plugin.sns.storage.q)localObject).AdY)
          {
            localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.a("SnsInfo", null, "stringSeq=?", new String[] { String.valueOf(str) }, null, null, null, 2);
            if (!((Cursor)localObject).moveToFirst()) {
              break label200;
            }
            localp.convertFrom((Cursor)localObject);
            ((Cursor)localObject).close();
          }
          for (localObject = localp;; localObject = null)
          {
            if (localObject != null)
            {
              localObject = ((p)localObject).eco();
              c.this.APL.a(paramAnonymousView, (String)localObject, localTimeLineObject);
            }
            AppMethodBeat.o(220127);
            return true;
            localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.a("SnsInfo", null, "snsId=?", new String[] { com.tencent.mm.plugin.sns.storage.q.aBD(new StringBuilder().append(str).toString()) }, null, null, null, 2);
            break;
            label200:
            ((Cursor)localObject).close();
          }
        }
        AppMethodBeat.o(220127);
        return false;
      }
    };
    this.AQg = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(220130);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        Object localObject;
        if ((paramAnonymousContextMenuInfo instanceof s))
        {
          paramAnonymousContextMenuInfo = (s)paramAnonymousContextMenuInfo;
          localObject = paramAnonymousContextMenuInfo.Ahs;
          if (com.tencent.mm.br.d.aJN("favorite")) {
            switch (((TimeLineObject)localObject).HUG.Gtw)
            {
            default: 
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, ah.dXE().aBr(paramAnonymousContextMenuInfo.dqc));
          AppMethodBeat.o(220130);
          return;
          paramAnonymousContextMenu.add(0, 4, 0, paramAnonymousView.getContext().getString(2131761941));
          localObject = new ec();
          ((ec)localObject).dql.dqc = paramAnonymousContextMenuInfo.dqc;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          if (((ec)localObject).dqm.dpK)
          {
            paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755836));
            continue;
            paramAnonymousContextMenu.add(0, 5, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 9, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            localObject = new ec();
            ((ec)localObject).dql.dqc = paramAnonymousContextMenuInfo.dqc;
            com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
            if (((ec)localObject).dqm.dpK)
            {
              paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755836));
              continue;
              paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(2131761941));
              continue;
              paramAnonymousContextMenu.add(0, 22, 0, paramAnonymousView.getContext().getString(2131761941));
              continue;
              paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131761941));
              continue;
              paramAnonymousContextMenu.add(0, 23, 0, paramAnonymousView.getContext().getString(2131761941));
              continue;
              paramAnonymousContextMenu.add(0, 24, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
        }
      }
      
      public final boolean fn(View paramAnonymousView)
      {
        AppMethodBeat.i(220129);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof s))
        {
          localObject = (s)localObject;
          TimeLineObject localTimeLineObject = ((s)localObject).Ahs;
          if ((localTimeLineObject.HUG.Gtw == 10) || (localTimeLineObject.HUG.Gtw == 17) || (localTimeLineObject.HUG.Gtw == 22) || (localTimeLineObject.HUG.Gtw == 23))
          {
            AppMethodBeat.o(220129);
            return false;
          }
          c.this.APL.a(paramAnonymousView, ((s)localObject).dqc, localTimeLineObject);
          AppMethodBeat.o(220129);
          return true;
        }
        AppMethodBeat.o(220129);
        return false;
      }
    };
    this.APe = new b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(220131);
        if ((paramAnonymousb != null) && (paramAnonymousInt == 0)) {
          if (paramAnonymousb.zhJ == null) {
            break label88;
          }
        }
        label88:
        for (paramAnonymousb = (View)paramAnonymousb.zhJ.get();; paramAnonymousb = null)
        {
          if ((paramAnonymousb != null) && ((paramAnonymousb instanceof com.tencent.mm.plugin.sight.decode.a.a)))
          {
            paramAnonymousb = (com.tencent.mm.plugin.sight.decode.a.a)paramAnonymousb;
            paramAnonymousb.getVideoPath();
            if ((paramAnonymousb.getTagObject() != null) && ((paramAnonymousb.getTagObject() instanceof com.tencent.mm.plugin.sns.ui.aq))) {
              paramAnonymousb.getTagObject();
            }
          }
          AppMethodBeat.o(220131);
          return;
        }
      }
    };
    this.AQq = new c.36(this);
    this.AQr = new c.37(this);
    this.AQs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(220132);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject1 = paramAnonymousView.zyl;
          if ((localObject1 != null) && (!bu.ht(((dgh)localObject1).HNp)) && (((dgh)localObject1).HNp.get(0) != null))
          {
            Object localObject2 = ((dgn)((dgh)localObject1).HNp.get(0)).Md5;
            EmojiInfo localEmojiInfo = be.fvc().JfU.aWl((String)localObject2);
            Intent localIntent = new Intent();
            localIntent.putExtra("custom_smiley_preview_md5", (String)localObject2);
            if ((localEmojiInfo.field_catalog != EmojiGroupInfo.OzT) && (localEmojiInfo.field_catalog != EmojiGroupInfo.OzS) && (localEmojiInfo.field_catalog != EmojiGroupInfo.OzR)) {
              localIntent.putExtra("custom_smiley_preview_productid", localEmojiInfo.field_groupId);
            }
            com.tencent.mm.br.d.b(c.this.activity, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
            localObject2 = com.tencent.mm.plugin.sns.j.e.zKO;
            long l = x.aze(paramAnonymousView.AgZ);
            paramAnonymousView = String.valueOf(((dgh)localObject1).HNk);
            localObject1 = com.tencent.mm.plugin.sns.data.r.zV(l);
            localObject1 = (com.tencent.mm.plugin.sns.j.e.a)((com.tencent.mm.plugin.sns.j.e)localObject2).zLb.get(localObject1);
            if ((localObject1 != null) && (!((com.tencent.mm.plugin.sns.j.e.a)localObject1).zLH.contains(paramAnonymousView))) {
              ((com.tencent.mm.plugin.sns.j.e.a)localObject1).zLH.add(paramAnonymousView);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(220132);
      }
    };
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, p paramp, int paramInt)
  {
    try
    {
      if (!bu.isNullOrNil(paramString1))
      {
        if (paramInt == 2) {}
        for (com.tencent.mm.plugin.sns.storage.a locala = paramp.ebM(); locala == null; locala = paramp.dVi())
        {
          ae.e("MicroMsg.TimelineClickListener", "jumpWeApp adInfo==null");
          return false;
        }
        String str = com.tencent.mm.plugin.sns.data.r.zV(paramp.field_snsId) + ":" + locala.dGD + ":" + ah.dXj() + ":" + System.currentTimeMillis();
        if (paramInt == 0) {}
        for (paramInt = 1045;; paramInt = 1046)
        {
          com.tencent.mm.plugin.sns.data.r.a(paramString1, paramString2, paramString3, paramp.ect(), paramp.ecu(), str, locala.dGD, paramInt);
          return true;
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      ae.e("MicroMsg.TimelineClickListener", "jumpWeApp exp:" + paramString1.toString());
    }
  }
  
  public final void a(com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    if (this.APJ != null) {
      ae.w("MicroMsg.TimelineClickListener", "has already prepare detail click animation");
    }
    do
    {
      return;
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.b))
      {
        this.APJ = new com.tencent.mm.plugin.sns.ui.b.a.d((MMActivity)this.activity, parama);
        this.APK = new com.tencent.mm.plugin.sns.ui.b.a.c((MMActivity)this.activity, parama);
        return;
      }
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
      {
        this.APJ = new com.tencent.mm.plugin.sns.ui.b.a.f((MMActivity)this.activity, parama);
        this.APK = new com.tencent.mm.plugin.sns.ui.b.a.e((MMActivity)this.activity, parama);
        return;
      }
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.e))
      {
        this.APJ = new com.tencent.mm.plugin.sns.ui.b.a.j((MMActivity)this.activity, parama);
        this.APK = new com.tencent.mm.plugin.sns.ui.b.a.i((MMActivity)this.activity, parama);
        return;
      }
    } while (!(parama instanceof com.tencent.mm.plugin.sns.ui.c.a.d));
    this.APJ = new com.tencent.mm.plugin.sns.ui.b.a.h((MMActivity)this.activity, parama);
    this.APK = new com.tencent.mm.plugin.sns.ui.b.a.g((MMActivity)this.activity, parama);
  }
  
  public final void b(com.tencent.mm.plugin.sns.ad.e.j paramj)
  {
    this.Asq = paramj;
    if (this.APL != null) {
      this.APL.b(paramj);
    }
  }
  
  public abstract void dJ(Object paramObject);
  
  public final void dhH()
  {
    this.APL.dhH();
    com.tencent.mm.sdk.b.a.IvT.c(this.AQB);
    com.tencent.mm.sdk.b.a.IvT.c(this.AQC);
  }
  
  public abstract void eZ(View paramView);
  
  public abstract void edh();
  
  public abstract void edi();
  
  public abstract void edj();
  
  public abstract void edk();
  
  public abstract void fa(View paramView);
  
  public abstract void fb(View paramView);
  
  public abstract void fc(View paramView);
  
  public abstract void fd(View paramView);
  
  public abstract void fe(View paramView);
  
  public abstract void ff(View paramView);
  
  public final void m(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    if (this.APG != null) {
      ae.w("MicroMsg.TimelineClickListener", "has already prepare click animation");
    }
    do
    {
      return;
      if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.a.a))
      {
        this.APG = new com.tencent.mm.plugin.sns.ui.b.b.d((MMActivity)this.activity, paramBaseViewHolder);
        this.APH = new com.tencent.mm.plugin.sns.ui.b.b.c((MMActivity)this.activity, paramBaseViewHolder);
        ((com.tencent.mm.plugin.sns.ui.item.a.a)paramBaseViewHolder).ANW = true;
        return;
      }
      if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.e.a))
      {
        this.APG = new com.tencent.mm.plugin.sns.ui.b.b.f((MMActivity)this.activity, paramBaseViewHolder);
        this.APH = new com.tencent.mm.plugin.sns.ui.b.b.e((MMActivity)this.activity, paramBaseViewHolder);
        ((com.tencent.mm.plugin.sns.ui.item.e.a)paramBaseViewHolder).ANW = true;
        return;
      }
      if ((paramBaseViewHolder instanceof m.b))
      {
        this.APG = new com.tencent.mm.plugin.sns.ui.b.b.j((MMActivity)this.activity, paramBaseViewHolder);
        this.APH = new com.tencent.mm.plugin.sns.ui.b.b.i((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
    } while (!(paramBaseViewHolder instanceof k.a));
    this.APG = new com.tencent.mm.plugin.sns.ui.b.b.h((MMActivity)this.activity, paramBaseViewHolder);
    this.APH = new com.tencent.mm.plugin.sns.ui.b.b.g((MMActivity)this.activity, paramBaseViewHolder);
  }
  
  public final void removeListener()
  {
    this.APL.removeListener();
    com.tencent.mm.sdk.b.a.IvT.d(this.AQB);
    com.tencent.mm.sdk.b.a.IvT.d(this.AQC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c
 * JD-Core Version:    0.7.0.1
 */