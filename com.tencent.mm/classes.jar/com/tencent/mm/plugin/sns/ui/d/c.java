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
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wr;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.ar.b;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.storage.a.c;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.b.j;
import com.tencent.mm.plugin.sns.storage.k;
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
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.plugin.sns.ui.az;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bh.b;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.protocal.protobuf.dfw;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class c
{
  protected com.tencent.mm.plugin.sns.ad.d.i Abd;
  public com.tencent.mm.plugin.sight.decode.a.b.e AxL;
  public View.OnClickListener AyA;
  public View.OnClickListener AyB;
  public View.OnClickListener AyC;
  public d AyD;
  public d AyE;
  public d AyF;
  public d AyG;
  public d AyH;
  public d AyI;
  public d AyJ;
  d AyK;
  public d AyL;
  public d AyM;
  public View.OnClickListener AyN;
  public View.OnClickListener AyO;
  public View.OnClickListener AyP;
  public View.OnClickListener AyQ;
  public View.OnClickListener AyR;
  public View.OnClickListener AyS;
  public View.OnClickListener AyT;
  public View.OnClickListener AyU;
  public View.OnClickListener AyV;
  public View.OnClickListener AyW;
  public View.OnClickListener AyX;
  public AdapterView.OnItemClickListener AyY;
  public AdapterView.OnItemClickListener AyZ;
  volatile com.tencent.mm.plugin.sns.ui.b.b.b Aym;
  volatile com.tencent.mm.plugin.sns.ui.b.b.a Ayn;
  volatile com.tencent.mm.plugin.sns.ui.b.a.b Ayo;
  volatile com.tencent.mm.plugin.sns.ui.b.a.a Ayp;
  public b Ayq;
  public View.OnClickListener Ayr;
  public View.OnLongClickListener Ays;
  public d Ayt;
  public View.OnClickListener Ayu;
  public View.OnClickListener Ayv;
  public View.OnClickListener Ayw;
  public View.OnClickListener Ayx;
  public View.OnClickListener Ayy;
  public View.OnClickListener Ayz;
  public View.OnClickListener Aza = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100199);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      if (paramAnonymousView.getTag() == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100199);
        return;
      }
      localObject1 = c.fn(paramAnonymousView);
      if ((localObject1 == null) || (!((p)localObject1).QM(32)))
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
      if (((p)localObject1).dYU().dRL().dWf())
      {
        j = x.jS(((p)localObject1).dYU().dRL().dVX(), ((p)localObject1).dYT());
        if (j > 0)
        {
          i = 1;
          localObject2 = ((p)localObject1).dYU().dRL().dVX();
          String str1 = ((p)localObject1).dYT();
          com.tencent.mm.kernel.g.ajA();
          String str2 = com.tencent.mm.kernel.a.aiq();
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
        localObject2 = ((p)localObject1).dYl();
        if ((((TimeLineObject)localObject2).HAT.GaP == 15) && (((TimeLineObject)localObject2).HBa != 1)) {
          c.a(c.this, paramAnonymousView, (p)localObject1, 1001, ((p)localObject1).dYU().dRL().dWg(), bool);
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
          if (((((TimeLineObject)localObject2).HAT.GaP == 1) && (((TimeLineObject)localObject2).HAT.GaQ.size() == 1)) || (((TimeLineObject)localObject2).HAT.GaP == 7)) {
            c.b(c.this, paramAnonymousView, (p)localObject1, 1001, ((p)localObject1).dYU().dRL().dWg(), bool);
          }
        }
      }
    }
  };
  public View.OnClickListener Azb = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100219);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      if (paramAnonymousView.getTag() == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100219);
        return;
      }
      localObject1 = c.fn(paramAnonymousView);
      if ((localObject1 == null) || (!((p)localObject1).QM(32)))
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
      if (((p)localObject1).dYU().dRL().dWf())
      {
        j = x.jS(((p)localObject1).dYU().dRL().dVX(), ((p)localObject1).dYT());
        if (j > 0)
        {
          i = 1;
          localObject2 = ((p)localObject1).dYU().dRL().dVX();
          String str1 = ((p)localObject1).dYT();
          com.tencent.mm.kernel.g.ajA();
          String str2 = com.tencent.mm.kernel.a.aiq();
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
        localObject2 = ((p)localObject1).dYl();
        if ((((TimeLineObject)localObject2).HAT.GaP == 15) && (((TimeLineObject)localObject2).HBa != 1)) {
          c.a(c.this, paramAnonymousView, (p)localObject1, 1002, ((p)localObject1).dYU().dRL().dWh(), bool);
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
          if (((((TimeLineObject)localObject2).HAT.GaP == 1) && (((TimeLineObject)localObject2).HAT.GaQ.size() == 1)) || (((TimeLineObject)localObject2).HAT.GaP == 7)) {
            c.b(c.this, paramAnonymousView, (p)localObject1, 1002, ((p)localObject1).dYU().dRL().dWh(), bool);
          }
        }
      }
    }
  };
  public View.OnClickListener Azc;
  public bh.b Azd;
  int Aze;
  private com.tencent.mm.sdk.b.c<wr> Azf = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.sdk.b.c<wq> Azg = new com.tencent.mm.sdk.b.c() {};
  public View.OnClickListener Azh = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(198588);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      localObject1 = paramAnonymousView.getTag();
      Object localObject3 = null;
      Object localObject2;
      if ((localObject1 instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        localObject1 = com.tencent.mm.plugin.sns.storage.h.azZ(((BaseTimeLineItem.BaseViewHolder)localObject2).dzb);
        localObject3 = ((BaseTimeLineItem.BaseViewHolder)localObject2).Avf;
        localObject2 = null;
      }
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        int i;
        if (localObject1 != null)
        {
          localObject4 = ((p)localObject1).dYU();
          int k = ((com.tencent.mm.plugin.sns.storage.e)localObject4).getSource();
          if ((localObject1 != null) && (((p)localObject1).QM(32)))
          {
            localObject5 = c.a(c.this, (p)localObject1);
            if ((((p)localObject1).dRL().dVU()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(((p)localObject1).dYU().field_adxml)))
            {
              localObject5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J((p)localObject1);
              if (!bt.isNullOrNil((String)localObject5)) {
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
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", ((p)localObject1).dYl().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", ((p)localObject1).dYT());
                localObject2 = ((p)localObject1).dYl();
                if (localObject2 != null)
                {
                  localObject2 = ((TimeLineObject)localObject2).HAT.GaQ;
                  if (((List)localObject2).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((byn)((List)localObject2).get(0)).GSI);
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
                paramAnonymousView.putExtra("sns_landing_pages_xml", ((p)localObject1).dYU().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", ((p)localObject1).dYV());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject2 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramAnonymousView.ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject2).startActivity((Intent)paramAnonymousView.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.this.activity.overridePendingTransition(0, 0);
                if (k != 0) {
                  break label644;
                }
              }
              label644:
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 21));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198588);
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
            if ((localObject5 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject5).zuA == 1))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject5).zuC);
              paramAnonymousView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject5).zuD);
              paramAnonymousView.putExtra("key_from_scene", 21);
              paramAnonymousView.putExtra("key_stastic_scene", 15);
              com.tencent.mm.bs.d.b(c.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
              if (k == 0) {}
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 11));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198588);
                return;
              }
            }
            if (c.a(c.this, (com.tencent.mm.plugin.sns.storage.a)localObject5, (p)localObject1, false))
            {
              if (k == 0) {}
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 31));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198588);
                return;
              }
            }
          }
          if (k != 0) {
            break label1284;
          }
          i = 1;
          localObject3 = new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 0);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject3);
          localObject2 = ((p)localObject1).dYS();
          paramAnonymousView = (View)localObject2;
          if (bt.isNullOrNil((String)localObject2)) {
            paramAnonymousView = ((p)localObject1).dYR();
          }
          ad.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject1).dRL().zvx);
          localObject5 = new Intent();
          if (((p)localObject1).dRL().zvx != 0) {
            break label1289;
          }
        }
        label1284:
        label1289:
        for (boolean bool = true;; bool = false)
        {
          if (ac.iOW) {
            bool = false;
          }
          localObject2 = paramAnonymousView;
          if (localObject1 != null)
          {
            localObject2 = paramAnonymousView;
            if (((p)localObject1).QM(32))
            {
              com.tencent.mm.plugin.sns.storage.a locala = c.a(c.this, (p)localObject1);
              localObject2 = paramAnonymousView;
              if (locala != null)
              {
                ((Intent)localObject5).putExtra("KsnsViewId", locala.aQj);
                localObject2 = com.tencent.mm.plugin.sns.data.q.jh(paramAnonymousView, locala.dFy);
                com.tencent.mm.plugin.sns.data.q.g((Intent)localObject5, locala.dFy);
              }
            }
          }
          ((Intent)localObject5).putExtra("KRightBtn", bool);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject3);
          paramAnonymousView.putString("key_snsad_statextstr", ((com.tencent.mm.plugin.sns.storage.e)localObject4).dYl().zRz);
          ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
          ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
          ((Intent)localObject5).putExtra("useJs", true);
          ((Intent)localObject5).putExtra("srcUsername", ((p)localObject1).field_userName);
          ((Intent)localObject5).putExtra("stastic_scene", 15);
          ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((p)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("pre_username", ((p)localObject1).field_userName);
          ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((p)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("preUsername", ((p)localObject1).field_userName);
          com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject5, c.this.activity);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198588);
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
  Activity activity;
  int dnh = 0;
  private ClipboardManager rBg;
  public View.OnTouchListener tKQ;
  af zPG;
  public View.OnClickListener zRv;
  
  public c(int paramInt, Activity paramActivity, af paramaf)
  {
    this.dnh = paramInt;
    this.activity = paramActivity;
    this.zPG = paramaf;
    this.Aze = bt.getInt(com.tencent.mm.n.g.acA().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
    ad.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[] { Integer.valueOf(this.Aze) });
    this.rBg = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
    this.Ayq = new b(this.activity, this.dnh, this.zPG);
    this.AyB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100258);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Long)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100258);
          return;
        }
        long l = ((Long)paramAnonymousView.getTag()).longValue();
        com.tencent.mm.plugin.sns.storage.e locale = com.tencent.mm.plugin.sns.model.ag.dUh().zZ(l);
        p localp = locale.dYr();
        com.tencent.mm.plugin.sns.ad.d.m.a(com.tencent.mm.plugin.sns.ad.d.m.b.yZR, com.tencent.mm.plugin.sns.ad.d.m.a.yZP, locale.dYr(), c.this.dnh);
        locale.getSource();
        paramAnonymousView = localp.dYS();
        if (bt.isNullOrNil(paramAnonymousView)) {
          paramAnonymousView = localp.dYR();
        }
        label810:
        label1963:
        for (;;)
        {
          int i;
          Object localObject2;
          int j;
          if (localp.QM(32))
          {
            localObject1 = c.a(c.this, localp);
            i = -1;
            localObject2 = com.tencent.mm.model.c.d.aDt().aSj("Sns_CanvasAd_DetailLink_JumpWay");
            if (((com.tencent.mm.storage.a)localObject2).isValid()) {
              i = bt.getInt(((com.tencent.mm.storage.a)localObject2).field_value, -1);
            }
            if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).zuA == 1))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject1).zuC);
              paramAnonymousView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject1).zuD);
              paramAnonymousView.putExtra("key_from_scene", 21);
              paramAnonymousView.putExtra("key_stastic_scene", 15);
              com.tencent.mm.bs.d.b(c.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
              j = c.this.dnh;
              if (c.this.dnh == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 11);
                com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, c.this.Abd, localp, 3);
                com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100258);
                return;
              }
            }
            if ((localObject1 != null) && (i == 1))
            {
              if ((localp.dRL().dVU()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(localp.dYU().field_adxml)))
              {
                paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J(localp);
                if (!bt.isNullOrNil(paramAnonymousView)) {
                  locale.field_adxml = paramAnonymousView;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dYl().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dYT());
                paramAnonymousView.putExtra("sns_landing_pages_aid", localp.dYP());
                paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.dYQ());
                localObject1 = localp.dYl();
                if (localObject1 != null)
                {
                  localObject1 = ((TimeLineObject)localObject1).HAT.GaQ;
                  if (((List)localObject1).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((byn)((List)localObject1).get(0)).GSI);
                  }
                }
                paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (c.this.dnh == 2)
                {
                  i = 16;
                  paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                  paramAnonymousView.putExtra("sns_landing_pages_xml", localp.dYU().field_adxml);
                  paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                  paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dYV());
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                  localObject1 = c.this.activity;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)paramAnonymousView.mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  c.this.activity.overridePendingTransition(0, 0);
                  j = c.this.dnh;
                  if (c.this.dnh != 0) {
                    break label810;
                  }
                }
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 21);
                  com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, c.this.Abd, localp, 3);
                  com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100258);
                  return;
                  if (c.this.dnh != 1) {
                    break;
                  }
                  i = 10;
                  break;
                }
              }
            }
            else if ((localObject1 != null) && (i == 0))
            {
              if ((!localp.dRL().dVU()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(localp.dYU().field_adxml))) {
                break label1969;
              }
              localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J(localp);
              if (!bt.isNullOrNil((String)localObject1)) {
                locale.field_adxml = ((String)localObject1);
              }
              localObject1 = bw.M(localp.dYU().field_adxml, "adxml");
              if (localObject1 != null)
              {
                localObject1 = bt.bI((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareWebUrl"), "");
                if (!bt.isNullOrNil((String)localObject1)) {
                  paramAnonymousView = (View)localObject1;
                }
              }
            }
          }
          label944:
          label1969:
          for (;;)
          {
            j = c.this.dnh;
            Intent localIntent;
            if (c.this.dnh == 0)
            {
              i = 1;
              localObject2 = new SnsAdClick(j, i, localp.field_snsId, 3, 0);
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, c.this.Abd, localp, 3);
              com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
              ad.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + localp.dRL().zvx);
              localIntent = new Intent();
              if (localp.dRL().zvx != 0) {
                break label1963;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              if (ac.iOW) {
                bool = false;
              }
              localObject1 = paramAnonymousView;
              if (localp.QM(32))
              {
                com.tencent.mm.plugin.sns.storage.a locala = c.a(c.this, localp);
                localObject1 = paramAnonymousView;
                if (locala != null)
                {
                  localIntent.putExtra("KsnsViewId", locala.aQj);
                  localObject1 = com.tencent.mm.plugin.sns.data.q.jh(paramAnonymousView, locala.dFy);
                  com.tencent.mm.plugin.sns.data.q.g(localIntent, locala.dFy);
                }
              }
              localIntent.putExtra("KRightBtn", bool);
              paramAnonymousView = new Bundle();
              paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject2);
              paramAnonymousView.putString("key_snsad_statextstr", locale.dYl().zRz);
              localIntent.putExtra("jsapiargs", paramAnonymousView);
              localIntent.putExtra("rawUrl", (String)localObject1);
              localIntent.putExtra("useJs", true);
              localIntent.putExtra("srcUsername", localp.field_userName);
              localIntent.putExtra("sns_local_id", localp.dYK());
              localIntent.putExtra("stastic_scene", 15);
              localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId));
              localIntent.putExtra("pre_username", localp.field_userName);
              localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId));
              localIntent.putExtra("preUsername", localp.field_userName);
              com.tencent.mm.plugin.sns.c.a.iRG.i(localIntent, c.this.activity);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100258);
              return;
              ad.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + localp.dYU().field_adxml);
              break;
              if ((localObject1 != null) && (i == -1) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).zuA == 3))
              {
                if ((!localp.dRL().dVU()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(localp.dYU().field_adxml))) {
                  break label1969;
                }
                paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J(localp);
                if (!bt.isNullOrNil(paramAnonymousView)) {
                  locale.field_adxml = paramAnonymousView;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dYl().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dYT());
                paramAnonymousView.putExtra("sns_landing_pages_aid", localp.dYP());
                paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.dYQ());
                localObject1 = localp.dYl();
                if (localObject1 != null)
                {
                  localObject1 = ((TimeLineObject)localObject1).HAT.GaQ;
                  if (((List)localObject1).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((byn)((List)localObject1).get(0)).GSI);
                  }
                }
                paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (c.this.dnh == 2)
                {
                  i = 16;
                  paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                  paramAnonymousView.putExtra("sns_landing_pages_xml", localp.dYU().field_adxml);
                  paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dYV());
                  paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                  localObject1 = c.this.activity;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)paramAnonymousView.mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  c.this.activity.overridePendingTransition(0, 0);
                  j = c.this.dnh;
                  if (c.this.dnh != 0) {
                    break label1859;
                  }
                }
                label1859:
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 21);
                  com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, c.this.Abd, localp, 3);
                  com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(100258);
                  return;
                  if (c.this.dnh != 1) {
                    break;
                  }
                  i = 10;
                  break;
                }
              }
              if (!c.a(c.this, (com.tencent.mm.plugin.sns.storage.a)localObject1, localp, false)) {
                break label1969;
              }
              j = c.this.dnh;
              if (c.this.dnh == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 31);
                com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, c.this.Abd, localp, 3);
                com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
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
    this.AyO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100259);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        localObject1 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousView);
        if (localObject1 == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        if (((p)localObject1).QM(32))
        {
          ad.i("MicroMsg.TimelineClickListener", "click the ad poi button");
          localObject2 = c.a(c.this, (p)localObject1);
          if (localObject2 == null)
          {
            ad.e("MicroMsg.TimelineClickListener", "the adInfo is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
          int j = c.this.dnh;
          if (c.this.dnh == 0) {}
          for (int i = 1;; i = 2)
          {
            localObject3 = new SnsAdClick(j, i, ((p)localObject1).field_snsId, 19, 0);
            com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject3, c.this.Abd, (p)localObject1, 19);
            com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject3);
            if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject2).zuI)) {
              break;
            }
            ad.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
          if (c.this.dnh == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.e.pV(724);; paramAnonymousView = com.tencent.mm.modelsns.e.pW(724))
          {
            paramAnonymousView.Gs(com.tencent.mm.plugin.sns.data.q.n((p)localObject1)).pY(((p)localObject1).field_type).eS(((p)localObject1).QM(32)).Gs(((p)localObject1).dYT()).Gs("").Gs("").Gs("").Gs("").Gs(((com.tencent.mm.plugin.sns.storage.a)localObject2).zuH).Gs("").Gs("");
            paramAnonymousView.aLk();
            ad.i("MicroMsg.TimelineClickListener", "open webview url : " + ((com.tencent.mm.plugin.sns.storage.a)localObject2).zuI);
            paramAnonymousView = new Intent();
            if ((localObject1 != null) && (((p)localObject1).QM(32)))
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
            paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((p)localObject1).field_snsId));
            paramAnonymousView.putExtra("pre_username", ((p)localObject1).field_userName);
            paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((p)localObject1).field_snsId));
            paramAnonymousView.putExtra("preUsername", ((p)localObject1).field_userName);
            paramAnonymousView.putExtra("rawUrl", com.tencent.mm.plugin.sns.data.q.jh(((com.tencent.mm.plugin.sns.storage.a)localObject2).zuI, ((com.tencent.mm.plugin.sns.storage.a)localObject2).dFy));
            com.tencent.mm.plugin.sns.c.a.iRG.i(paramAnonymousView, c.this.activity);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100259);
            return;
          }
        }
        Object localObject3 = ((p)localObject1).dYl();
        Object localObject4 = ((TimeLineObject)localObject3).HAR;
        Object localObject2 = new Intent();
        if (c.this.dnh == 0) {}
        for (paramAnonymousView = com.tencent.mm.modelsns.e.pV(724);; paramAnonymousView = com.tencent.mm.modelsns.e.pW(724))
        {
          paramAnonymousView.Gs(com.tencent.mm.plugin.sns.data.q.n((p)localObject1)).pY(((p)localObject1).field_type).eS(((p)localObject1).QM(32)).Gs(((p)localObject1).dYT()).Gs(((bvq)localObject4).Gnu).pY(((bvq)localObject4).zSm).Gs(((bvq)localObject4).FOB).Gs(((bvq)localObject4).FOA).Gs(((bvq)localObject4).jDf).Gs(((bvq)localObject4).zSk).Gs(((bvq)localObject4).jde);
          paramAnonymousView.aLk();
          if (!bt.isNullOrNil(((bvq)localObject4).Gnu)) {
            break;
          }
          ((Intent)localObject2).putExtra("map_view_type", 7);
          ((Intent)localObject2).putExtra("kwebmap_slat", ((bvq)localObject4).FOB);
          ((Intent)localObject2).putExtra("kwebmap_lng", ((bvq)localObject4).FOA);
          ((Intent)localObject2).putExtra("kPoiName", ((bvq)localObject4).jDf);
          ((Intent)localObject2).putExtra("Kwebmap_locaion", ((bvq)localObject4).zSk);
          com.tencent.mm.bs.d.b(c.this.activity, "location", ".ui.RedirectUI", (Intent)localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100259);
          return;
        }
        if (c.this.Aze == 0) {}
        for (paramAnonymousView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[] { ((bvq)localObject4).Gnu });; paramAnonymousView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[] { ((bvq)localObject4).Gnu, ((TimeLineObject)localObject3).Id }))
        {
          ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
          com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject2, c.this.activity);
          break;
        }
      }
    };
    this.AyS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100260);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        paramAnonymousView = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousView);
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        if (paramAnonymousView.QM(32))
        {
          ad.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
          paramAnonymousView = c.a(c.this, paramAnonymousView);
          if (paramAnonymousView == null)
          {
            ad.e("MicroMsg.TimelineClickListener", "the adInfo is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100260);
            return;
          }
          if (bt.isNullOrNil(paramAnonymousView.zuL))
          {
            ad.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100260);
            return;
          }
          ad.i("MicroMsg.TimelineClickListener", "open webview url : " + paramAnonymousView.zuL);
          localObject = new Intent();
          ((Intent)localObject).putExtra("jsapiargs", new Bundle());
          ((Intent)localObject).putExtra("useJs", true);
          String str = com.tencent.mm.plugin.sns.data.q.jh(paramAnonymousView.zuL, paramAnonymousView.dFy);
          com.tencent.mm.plugin.sns.data.q.g((Intent)localObject, paramAnonymousView.dFy);
          ((Intent)localObject).putExtra("rawUrl", str);
          com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject, c.this.activity);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100260);
          return;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100260);
      }
    };
    this.AyT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100261);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        int j;
        if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          localObject = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).doX;
          localObject = com.tencent.mm.plugin.sns.model.ag.dUe().aAa((String)localObject);
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100261);
            return;
          }
          if (((p)localObject).QM(32))
          {
            ad.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
            j = c.this.dnh;
            if (c.this.dnh != 0) {
              break label195;
            }
          }
        }
        label195:
        for (int i = 1;; i = 2)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(j, i, ((p)localObject).field_snsId, 24, 0);
          com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, c.this.Abd, (p)localObject, 24);
          com.tencent.mm.plugin.sns.data.q.a(localSnsAdClick);
          c.this.fb(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100261);
          return;
        }
      }
    };
    this.Ayr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        int m = 1;
        int k = 1;
        AppMethodBeat.i(100262);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        Object localObject2 = (String)paramAnonymousView.getTag();
        ad.d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(localObject2)));
        Object localObject3 = new Intent();
        int j;
        int i;
        if (((paramAnonymousView instanceof MaskImageButton)) && (((MaskImageButton)paramAnonymousView).hgD != null))
        {
          paramAnonymousView = (String)((MaskImageButton)paramAnonymousView).hgD;
          localObject1 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousView);
          if ((localObject1 != null) && (((p)localObject1).QM(32)))
          {
            com.tencent.mm.plugin.sns.storage.b localb = ((p)localObject1).dRL();
            j = c.this.dnh;
            if (c.this.dnh == 0) {}
            for (i = 1;; i = 2)
            {
              paramAnonymousView = new SnsAdClick(j, i, ((p)localObject1).field_snsId, 1, 0);
              com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, c.this.Abd, (p)localObject1, 1);
              com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
              if ((localb == null) || (localb.zvH != 1) || (bt.isNullOrNil(localb.zvI))) {
                break;
              }
              localObject2 = localb.zvI;
              localObject3 = c.a(c.this, (p)localObject1);
              paramAnonymousView = (View)localObject2;
              if (localObject3 != null) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.q.jh((String)localObject2, ((com.tencent.mm.plugin.sns.storage.a)localObject3).dFy);
              }
              ad.i("MicroMsg.TimelineClickListener", "headClickParam url " + paramAnonymousView + " " + localb.zvJ);
              localObject2 = new Intent();
              if (localb.zvJ == 0) {
                bool = true;
              }
              ((Intent)localObject2).putExtra("KsnsViewId", c.a(c.this, (p)localObject1).aQj);
              ((Intent)localObject2).putExtra("KRightBtn", bool);
              ((Intent)localObject2).putExtra("jsapiargs", new Bundle());
              ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject2).putExtra("useJs", true);
              com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject2, c.this.activity);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100262);
              return;
            }
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
            if (c.this.dnh != 0) {
              break label686;
            }
            if (paramAnonymousView.QM(32))
            {
              j = 722;
              localObject1 = com.tencent.mm.modelsns.e.pV(j);
              ((com.tencent.mm.modelsns.e)localObject1).Gs(com.tencent.mm.plugin.sns.data.q.n(paramAnonymousView)).pY(paramAnonymousView.field_type).eS(paramAnonymousView.QM(32)).Gs(paramAnonymousView.dYT()).Gs((String)localObject2);
              ((com.tencent.mm.modelsns.e)localObject1).aLk();
            }
          }
          else
          {
            if (i == 0) {
              break label720;
            }
            j = c.this.dnh;
            if (c.this.dnh != 0) {
              break label715;
            }
          }
          label686:
          label715:
          for (i = 1;; i = 2)
          {
            localObject1 = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 1, 0);
            com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject1, c.this.Abd, paramAnonymousView, 1);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            ((Intent)localObject3).putExtra("KSnsAdTag", (Parcelable)localObject1);
            ((Intent)localObject3).putExtra("Contact_Scene", 78);
            i = k;
            if (c.this.dnh == 0) {
              i = 6;
            }
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            com.tencent.mm.plugin.sns.c.a.iRG.c((Intent)localObject3, c.this.activity);
            ad.i("MicroMsg.TimelineClickListener", "startContactInfo, addScene=78");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100262);
            return;
            j = 721;
            break;
            if (paramAnonymousView.QM(32)) {}
            for (j = 722;; j = 721)
            {
              localObject1 = com.tencent.mm.modelsns.e.pW(j);
              break;
            }
          }
          label720:
          c.this.zPG.dTI().a(paramAnonymousView, true);
          if (c.this.dnh == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.e.pV(746);; paramAnonymousView = com.tencent.mm.modelsns.e.pW(746))
          {
            localObject1 = u.aAm();
            paramAnonymousView.Gs((String)localObject2).eS(((String)localObject2).endsWith((String)localObject1));
            paramAnonymousView.b((Intent)localObject3, "intent_key_StatisticsOplog");
            i = m;
            if (c.this.dnh == 0) {
              i = 6;
            }
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            com.tencent.mm.plugin.sns.c.a.iRG.c((Intent)localObject3, c.this.activity);
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
    this.Ays = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100202);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        final String str = (String)paramAnonymousView.getTag();
        ad.d("MicroMsg.TimelineClickListener", "onCommentLongClick:".concat(String.valueOf(str)));
        if (bt.isNullOrNil(str))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(100202);
          return true;
        }
        if (str.equals(com.tencent.mm.plugin.sns.model.ag.dTJ()))
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(100202);
          return true;
        }
        final p localp;
        if ((((MaskImageButton)paramAnonymousView).hgD != null) && ((((MaskImageButton)paramAnonymousView).hgD instanceof String)))
        {
          localObject = (String)((MaskImageButton)paramAnonymousView).hgD;
          new Intent();
          localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa((String)localObject);
          if ((localp == null) || (!localp.QM(32))) {
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
          if ((paramAnonymousView.getTag(2131306044) instanceof int[])) {
            arrayOfInt = (int[])paramAnonymousView.getTag(2131306044);
          }
          for (;;)
          {
            new com.tencent.mm.ui.widget.b.a(c.this.activity).a(paramAnonymousView, new View.OnCreateContextMenuListener()new n.e
            {
              public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
              {
                AppMethodBeat.i(100200);
                com.tencent.mm.kernel.g.ajD();
                paramAnonymous2View = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTk(localp.field_userName);
                paramAnonymous2ContextMenuInfo = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acA();
                int i;
                if (com.tencent.mm.sdk.platformtools.i.DEBUG)
                {
                  i = 1;
                  if (paramAnonymous2ContextMenuInfo.getInt("MMSocialBlackListFlag", i) != 1) {
                    break label178;
                  }
                  i = 1;
                  label73:
                  if ((paramAnonymous2View == null) || (localp == null) || (!am.aSQ(localp.field_userName)) || (!"3552365301".equals(paramAnonymous2View.field_openImAppid))) {
                    break label203;
                  }
                  if (i == 0) {
                    break label184;
                  }
                }
                label178:
                label184:
                for (paramAnonymous2View = c.this.activity.getString(2131757746);; paramAnonymous2View = c.this.activity.getString(2131757748))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View);
                  paramAnonymous2ContextMenu.add(1, 1, 0, c.this.activity.getString(2131764022));
                  AppMethodBeat.o(100200);
                  return;
                  i = 0;
                  break;
                  i = 0;
                  break label73;
                }
                label203:
                if (i != 0) {}
                for (paramAnonymous2View = c.this.activity.getString(2131757746);; paramAnonymous2View = c.this.activity.getString(2131757747))
                {
                  paramAnonymous2ContextMenu.add(0, 0, 0, paramAnonymous2View);
                  break;
                }
              }
            }, new n.e()
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
                  if (localp == null)
                  {
                    ((Intent)localObject1).putExtra("sns_permission_snsinfo_svr_id", l);
                    ((Intent)localObject1).putExtra("sns_permission_userName", str);
                    ((Intent)localObject1).putExtra("sns_permission_anim", true);
                    ((Intent)localObject1).putExtra("sns_permission_block_scene", 5);
                    paramAnonymous2Int = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHe, 0);
                    localObject2 = c.this.activity;
                    if (paramAnonymous2Int != 0) {
                      break label163;
                    }
                  }
                  label163:
                  for (paramAnonymous2MenuItem = ".ui.PermissionSettingUI";; paramAnonymous2MenuItem = ".ui.PermissionSettingUI2")
                  {
                    com.tencent.mm.bs.d.b((Context)localObject2, "profile", paramAnonymous2MenuItem, (Intent)localObject1, 11);
                    AppMethodBeat.o(100201);
                    return;
                    l = localp.field_snsId;
                    break;
                  }
                }
                Object localObject2 = new Intent();
                Object localObject1 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(this.Azk);
                if (localObject1 == null)
                {
                  ad.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + this.Azk);
                  AppMethodBeat.o(100201);
                  return;
                }
                ad.i("MicroMsg.TimelineClickListener", "expose id " + ((p)localObject1).getSnsId() + " " + ((p)localObject1).field_userName);
                if (localObject1 == null)
                {
                  label268:
                  ((Intent)localObject2).putExtra("k_expose_msg_id", l);
                  if (localObject1 != null) {
                    break label437;
                  }
                }
                label437:
                for (paramAnonymous2MenuItem = "";; paramAnonymous2MenuItem = ((p)localObject1).field_userName)
                {
                  ((Intent)localObject2).putExtra("k_username", paramAnonymous2MenuItem);
                  ((Intent)localObject2).putExtra("showShare", false);
                  ((Intent)localObject2).putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
                  com.tencent.mm.bs.d.b(c.this.activity, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
                  com.tencent.mm.kernel.g.ajD();
                  paramAnonymous2MenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTk(localp.field_userName);
                  if ((paramAnonymous2MenuItem == null) || (localp == null) || (!am.aSQ(localp.field_userName)) || (!"3552365301".equals(paramAnonymous2MenuItem.field_openImAppid))) {
                    break;
                  }
                  paramAnonymous2MenuItem = com.tencent.mm.plugin.sns.j.e.ztz;
                  com.tencent.mm.plugin.sns.j.e.azG(((p)localObject1).field_userName);
                  break;
                  l = ((p)localObject1).field_snsId;
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
    this.Ayt = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100203);
        paramAnonymousView = (com.tencent.mm.plugin.sns.ui.bd)paramAnonymousView.getTag();
        paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.ag.dUe().azZ(paramAnonymousView.dzb);
        if (paramAnonymousContextMenuInfo == null)
        {
          AppMethodBeat.o(100203);
          return;
        }
        paramAnonymousContextMenu.add(0, 0, 0, c.this.activity.getString(2131755701));
        if (com.tencent.mm.bs.d.aIu("favorite")) {
          paramAnonymousContextMenu.add(0, 1, 0, c.this.activity.getString(2131761941));
        }
        TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.dYl();
        if ((paramAnonymousView.Ahc) || ((localTimeLineObject != null) && (localTimeLineObject.HAV != 1) && (!paramAnonymousView.Ahd)))
        {
          if (paramAnonymousView.ect()) {
            break label143;
          }
          ar.a(paramAnonymousContextMenu, true);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
          AppMethodBeat.o(100203);
          return;
          label143:
          ar.b(paramAnonymousContextMenu, true);
        }
      }
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(100204);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bd))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.bd)paramAnonymousView.getTag();
          localObject = com.tencent.mm.plugin.sns.model.ag.dUe().azZ(((com.tencent.mm.plugin.sns.ui.bd)localObject).dzb);
          if (localObject == null)
          {
            AppMethodBeat.o(100204);
            return false;
          }
          String str = ((p)localObject).dYK();
          c.this.Ayq.a(paramAnonymousView, str, ((p)localObject).dYl());
          AppMethodBeat.o(100204);
          return true;
        }
        AppMethodBeat.o(100204);
        return false;
      }
    };
    this.AyI = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100206);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof p)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.aq)) || ((paramAnonymousContextMenuInfo instanceof az)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.c.a.a))) {
          if ((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.h.azZ(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).dzb);
          }
        }
        for (;;)
        {
          if (!paramAnonymousContextMenuInfo.QM(32))
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
              paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousContextMenuInfo.doX);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof az))
            {
              paramAnonymousContextMenuInfo = ((az)paramAnonymousView.getTag()).drH;
              paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousContextMenuInfo);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).yXF;
            }
          }
          else
          {
            if ((paramAnonymousContextMenuInfo.dRL() == null) || (!paramAnonymousContextMenuInfo.dRL().dVZ()))
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (c.a(c.this, paramAnonymousContextMenuInfo).zuS != null)
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (com.tencent.mm.bs.d.aIu("favorite"))
            {
              if (paramAnonymousContextMenuInfo.dRL().dVZ()) {
                paramAnonymousContextMenu.add(0, 20, 0, paramAnonymousView.getContext().getString(2131761941));
              }
              eb localeb = new eb();
              localeb.dpg.doX = paramAnonymousContextMenuInfo.dYK();
              com.tencent.mm.sdk.b.a.IbL.l(localeb);
              if (localeb.dph.doF) {
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
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(100205);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof p)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq)) || ((paramAnonymousView.getTag() instanceof az)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.h.azZ(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dzb);
          }
        }
        for (;;)
        {
          if (localObject != null)
          {
            if (!((p)localObject).QM(32))
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
                localObject = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((com.tencent.mm.plugin.sns.ui.aq)localObject).doX);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof az))
              {
                localObject = ((az)paramAnonymousView.getTag()).drH;
                localObject = com.tencent.mm.plugin.sns.model.ag.dUe().aAa((String)localObject);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                localObject = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).yXF;
              }
            }
            else
            {
              if ((((p)localObject).dRL() == null) || (!((p)localObject).dRL().dVZ()))
              {
                AppMethodBeat.o(100205);
                return false;
              }
              c.this.Ayq.a(paramAnonymousView, ((p)localObject).dYK(), ((p)localObject).dYl());
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
    this.AyJ = new d()
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
          paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.h.azZ(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).dzb);
        }
        for (;;)
        {
          Object localObject;
          com.tencent.mm.plugin.sns.storage.a locala;
          if (com.tencent.mm.bs.d.aIu("favorite"))
          {
            localObject = paramAnonymousContextMenuInfo.dRL();
            locala = c.a(c.this, paramAnonymousContextMenuInfo);
            if (((com.tencent.mm.plugin.sns.storage.b)localObject).dVY())
            {
              if (!((com.tencent.mm.plugin.sns.storage.b)localObject).dVU()) {
                break label192;
              }
              paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
          for (;;)
          {
            localObject = new eb();
            ((eb)localObject).dpg.doX = paramAnonymousContextMenuInfo.dYK();
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            if (((eb)localObject).dph.doF) {
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
            if (locala.zuA == 0) {
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
          label222:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(100207);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof p)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.h.azZ(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dzb);
          }
        }
        for (;;)
        {
          if (localObject != null) {
            c.this.Ayq.a(paramAnonymousView, ((p)localObject).dYK(), ((p)localObject).dYl());
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
    this.AyF = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100209);
        if ((paramAnonymousView.getTag() instanceof s)) {
          c.this.AyK.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
        }
        AppMethodBeat.o(100209);
      }
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(100210);
        if ((paramAnonymousView.getTag() instanceof s))
        {
          String str = ((s)paramAnonymousView.getTag()).doX;
          p localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(str);
          c.this.Ayq.a(paramAnonymousView, str, localp.dYl());
          AppMethodBeat.o(100210);
          return true;
        }
        AppMethodBeat.o(100210);
        return false;
      }
    };
    this.AyL = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100211);
        if (com.tencent.mm.bs.d.aIu("favorite")) {
          paramAnonymousContextMenu.add(0, 24, 0, paramAnonymousView.getContext().getString(2131761941));
        }
        AppMethodBeat.o(100211);
      }
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(100212);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.ag))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.ag)paramAnonymousView.getTag()).doX;
          p localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(str);
          c.this.Ayq.a(paramAnonymousView, str, localp.dYl());
          AppMethodBeat.o(100212);
          return true;
        }
        AppMethodBeat.o(100212);
        return false;
      }
    };
    this.AyE = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100214);
        int j;
        int i;
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof az)))
        {
          paramAnonymousContextMenuInfo = ((az)paramAnonymousView.getTag()).drH;
          p localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousContextMenuInfo);
          if (com.tencent.mm.bs.d.aIu("favorite"))
          {
            paramAnonymousContextMenu.add(0, 2, 0, c.this.activity.getString(2131761941));
            eb localeb = new eb();
            localeb.dpg.doX = paramAnonymousContextMenuInfo;
            com.tencent.mm.sdk.b.a.IbL.l(localeb);
            if (localeb.dph.doF) {
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
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(100213);
        if ((paramAnonymousView.getTag() instanceof az))
        {
          String str = ((az)paramAnonymousView.getTag()).drH;
          p localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(str);
          c.this.Ayq.a(paramAnonymousView, str, localp.dYl());
          AppMethodBeat.o(100213);
          return true;
        }
        AppMethodBeat.o(100213);
        return false;
      }
    };
    this.AyH = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(198567);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if ((paramAnonymousContextMenuInfo instanceof az)) {
          paramAnonymousContextMenuInfo = ((az)paramAnonymousContextMenuInfo).drH;
        }
        for (;;)
        {
          if (paramAnonymousContextMenuInfo != null)
          {
            paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousContextMenuInfo);
            TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.dYl();
            if (com.tencent.mm.bs.d.aIu("favorite")) {
              switch (localTimeLineObject.HAT.GaP)
              {
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            AppMethodBeat.o(198567);
            return;
            if (!(paramAnonymousContextMenuInfo instanceof s)) {
              break label158;
            }
            paramAnonymousContextMenuInfo = ((s)paramAnonymousContextMenuInfo).doX;
            break;
            paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131761941));
          }
          label158:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(198566);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof az)) {
          localObject = ((az)localObject).drH;
        }
        for (;;)
        {
          if (localObject != null)
          {
            p localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa((String)localObject);
            c.this.Ayq.a(paramAnonymousView, (String)localObject, localp.dYl());
            AppMethodBeat.o(198566);
            return true;
            if ((localObject instanceof s)) {
              localObject = ((s)localObject).doX;
            }
          }
          else
          {
            AppMethodBeat.o(198566);
            return false;
          }
          localObject = null;
        }
      }
    };
    this.zRv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100216);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        localObject1 = null;
        if ((paramAnonymousView.getTag() instanceof az)) {
          localObject1 = ((az)paramAnonymousView.getTag()).drH;
        }
        Object localObject2;
        for (;;)
        {
          localObject2 = com.tencent.mm.plugin.sns.storage.h.aAa((String)localObject1);
          if (localObject2 != null) {
            break;
          }
          ad.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(localObject1)));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
          if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).doX;
          } else if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
            localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).yXF.dYK();
          }
        }
        if ((((p)localObject2).QM(32)) && (((p)localObject2).dRL() != null) && ((((p)localObject2).dRL().dVZ()) || (((p)localObject2).dRL().dWa())))
        {
          c.this.Azc.onClick(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100216);
          return;
        }
        if (((p)localObject2).dYl().HAT.GaP == 21)
        {
          if (u.aAm().equals(((p)localObject2).field_userName))
          {
            ((p)localObject2).dYl();
            com.tencent.mm.plugin.sns.lucky.a.m.r((p)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.m.q((p)localObject2);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.ma(25);
          }
          if (!u.aAm().equals(((p)localObject2).field_userName))
          {
            com.tencent.mm.plugin.sns.lucky.b.a.a(2, (p)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.b.ma(30);
          }
        }
        int j;
        int i;
        Object localObject3;
        if (((p)localObject2).QM(32))
        {
          localObject1 = c.a(c.this, (p)localObject2);
          if ((((p)localObject2).dRL().dVU()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(((p)localObject2).dYU().field_adxml)))
          {
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J((p)localObject2);
            if (!bt.isNullOrNil((String)localObject1)) {
              ((p)localObject2).dYU().field_adxml = ((String)localObject1);
            }
            j = c.this.dnh;
            if (c.this.dnh == 0)
            {
              i = 1;
              localObject1 = new SnsAdClick(j, i, ((p)localObject2).field_snsId, 21, 21);
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject1, c.this.Abd, (p)localObject2, 21);
              com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject1);
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
              ((Intent)localObject1).putExtra("sns_landing_pages_rawSnsId", ((p)localObject2).dYl().Id);
              ((Intent)localObject1).putExtra("sns_landing_pages_ux_info", ((p)localObject2).dYT());
              ((Intent)localObject1).putExtra("sns_landing_pages_aid", ((p)localObject2).dYP());
              ((Intent)localObject1).putExtra("sns_landing_pages_traceid", ((p)localObject2).dYQ());
              localObject3 = ((p)localObject2).dYl();
              if (localObject3 != null)
              {
                localObject3 = ((TimeLineObject)localObject3).HAT.GaQ;
                if (((List)localObject3).size() > 0)
                {
                  ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((byn)((List)localObject3).get(0)).GSI);
                  ((Intent)localObject1).putExtra("sns_landing_pages_from_outer_index", ((az)paramAnonymousView.getTag()).index);
                }
              }
              ((Intent)localObject1).setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
              if (c.this.dnh != 2) {
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
          ((Intent)localObject1).putExtra("sns_landing_pages_xml", ((p)localObject2).dYU().field_adxml);
          ((Intent)localObject1).putExtra("sns_landing_pages_rec_src", ((p)localObject2).dYV());
          ((Intent)localObject1).putExtra("sns_landing_pages_xml_prefix", "adxml");
          ((Intent)localObject1).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
          ((Intent)localObject1).putExtra("sns_landing_pages_is_normal_ad_animation", true);
          localObject3 = c.this.activity;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          c.this.activity.overridePendingTransition(0, 0);
          if (c.this.zPG != null) {
            c.this.zPG.dTI().F((p)localObject2);
          }
          label896:
          paramAnonymousView = (az)paramAnonymousView.getTag();
          if ((paramAnonymousView.Aae) && (localObject2 != null))
          {
            com.tencent.mm.plugin.sns.ui.a.c.g((p)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.ui.a.c.h((p)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.model.ba.azh(((p)localObject2).dYK());
          }
          if (localObject2 != null)
          {
            localObject1 = ((p)localObject2).dYl();
            if (localObject1 != null) {
              if (((TimeLineObject)localObject1).HAS != null) {
                break label1171;
              }
            }
          }
          label1040:
          label1171:
          for (paramAnonymousView = null;; paramAnonymousView = ((TimeLineObject)localObject1).HAS.Id)
          {
            if (!bt.isNullOrNil(paramAnonymousView))
            {
              localObject2 = com.tencent.mm.plugin.sns.c.a.iRH.fw(paramAnonymousView);
              com.tencent.mm.plugin.sns.c.a.iRH.a(null, paramAnonymousView, (String)localObject2, ((TimeLineObject)localObject1).nDo, 2, 4, 4, ((TimeLineObject)localObject1).HAX, ((TimeLineObject)localObject1).Id);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100216);
            return;
            i = 2;
            break;
            if (c.this.dnh != 1) {
              break label1183;
            }
            i = 2;
            break label702;
            if ((bh.R((p)localObject2) == 2) && (c.a(c.this, (com.tencent.mm.plugin.sns.storage.a)localObject1, (p)localObject2, false)))
            {
              j = c.this.dnh;
              if (c.this.dnh == 0) {}
              for (i = 1;; i = 2)
              {
                localObject1 = new SnsAdClick(j, i, ((p)localObject2).field_snsId, 21, 31);
                com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject1, c.this.Abd, (p)localObject2, 21);
                com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject1);
                break;
              }
            }
            c.this.dI(paramAnonymousView);
            break label896;
            c.this.dI(paramAnonymousView);
            break label896;
          }
          label1183:
          i = 1;
        }
      }
    };
    this.Ayu = new c.11(this);
    this.Ayv = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(100220);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        new f.a(c.this.activity).aXO(c.this.activity.getResources().getString(2131764024)).aXS(c.this.activity.getResources().getString(2131755707)).afq(c.this.activity.getResources().getColor(2131100800)).b(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            AppMethodBeat.i(198568);
            if (!(paramAnonymousView.getTag() instanceof String))
            {
              AppMethodBeat.o(198568);
              return;
            }
            paramAnonymous2String = (String)paramAnonymousView.getTag();
            ad.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymous2String)));
            p localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymous2String);
            if (localp == null)
            {
              ad.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[] { paramAnonymous2String });
              AppMethodBeat.o(198568);
              return;
            }
            Object localObject2;
            if (localp.dYM())
            {
              ad.i("MicroMsg.TimelineClickListener", "dead item");
              com.tencent.mm.plugin.sns.model.ag.dUe().QQ(localp.zMC);
              if (c.this.Azd != null) {
                c.this.Azd.ecP();
              }
              if (c.this.dnh == 0)
              {
                localObject1 = com.tencent.mm.modelsns.e.pV(739);
                localObject2 = ((com.tencent.mm.modelsns.e)localObject1).Gs(com.tencent.mm.plugin.sns.data.q.n(localp)).pY(localp.field_type);
                if (!localp.dYM()) {
                  break label234;
                }
                paramAnonymous2String = "2";
              }
              for (;;)
              {
                ((com.tencent.mm.modelsns.e)localObject2).Gs(paramAnonymous2String);
                ((com.tencent.mm.modelsns.e)localObject1).aLk();
                if (localp.field_type == 21) {
                  com.tencent.mm.plugin.sns.lucky.a.g.dTc().dTe();
                }
                AppMethodBeat.o(198568);
                return;
                localObject1 = com.tencent.mm.modelsns.e.pW(739);
                break;
                label234:
                if (localp.field_snsId == 0L) {
                  paramAnonymous2String = "1";
                } else {
                  paramAnonymous2String = "0";
                }
              }
            }
            if (localp.dTN())
            {
              ad.i("MicroMsg.TimelineClickListener", "cancel item " + localp.dYK());
              com.tencent.mm.plugin.sns.model.ag.dUa().C(localp);
              if (bt.rM(localp.field_createTime) < com.tencent.mm.plugin.sns.model.aq.zlC) {
                com.tencent.mm.plugin.sns.model.ag.dUo().w(localp);
              }
              c.this.dZC();
              AppMethodBeat.o(198568);
              return;
            }
            ad.i("MicroMsg.TimelineClickListener", "delete by server");
            paramAnonymous2String = localp.getSnsId();
            com.tencent.mm.plugin.sns.model.ag.dUd().zN(x.axN(paramAnonymous2String));
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.sns.model.q(x.axN(paramAnonymous2String), 1), 0);
            if (bt.rM(localp.field_createTime) < com.tencent.mm.plugin.sns.model.aq.zlC) {
              com.tencent.mm.plugin.sns.model.ag.dUo().w(localp);
            }
            com.tencent.mm.plugin.sns.model.ag.dUe().delete(x.axN(paramAnonymous2String));
            com.tencent.mm.plugin.sns.model.ag.dUj().Ad(x.axN(paramAnonymous2String));
            com.tencent.mm.plugin.sns.storage.i.Ac(x.axN(paramAnonymous2String));
            c.this.dZC();
            Object localObject1 = localp.dYl();
            if (localObject1 != null)
            {
              if (((TimeLineObject)localObject1).HAS != null) {
                break label630;
              }
              paramAnonymous2String = null;
              if ((!bt.isNullOrNil(paramAnonymous2String)) && (com.tencent.mm.plugin.sns.c.a.iRH.fy(paramAnonymous2String)))
              {
                localObject2 = com.tencent.mm.plugin.sns.c.a.iRH.fw(paramAnonymous2String);
                rb localrb = new rb();
                localrb.dFC.appId = paramAnonymous2String;
                localrb.dFC.dFE = ((TimeLineObject)localObject1).nDo;
                localrb.dFC.dFD = ((String)localObject2);
                localrb.dFC.mediaTagName = ((TimeLineObject)localObject1).HAX;
                com.tencent.mm.sdk.b.a.IbL.l(localrb);
              }
            }
            if (c.this.dnh == 0)
            {
              localObject1 = com.tencent.mm.modelsns.e.pV(739);
              label582:
              localObject2 = ((com.tencent.mm.modelsns.e)localObject1).Gs(com.tencent.mm.plugin.sns.data.q.n(localp)).pY(localp.field_type);
              if (!localp.dYM()) {
                break label651;
              }
              paramAnonymous2String = "2";
            }
            for (;;)
            {
              ((com.tencent.mm.modelsns.e)localObject2).Gs(paramAnonymous2String);
              ((com.tencent.mm.modelsns.e)localObject1).aLk();
              AppMethodBeat.o(198568);
              return;
              label630:
              paramAnonymous2String = ((TimeLineObject)localObject1).HAS.Id;
              break;
              localObject1 = com.tencent.mm.modelsns.e.pW(739);
              break label582;
              label651:
              if (localp.field_snsId == 0L) {
                paramAnonymous2String = "1";
              } else {
                paramAnonymous2String = "0";
              }
            }
          }
        }).aXT(c.this.activity.getResources().getString(2131755691)).a(new f.c()
        {
          public final void d(boolean paramAnonymous2Boolean, String paramAnonymous2String) {}
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100220);
      }
    };
    this.Ayw = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100221);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        paramAnonymousView = (String)paramAnonymousView.getTag();
        ad.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymousView)));
        paramAnonymousView = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousView).dYl();
        localObject1 = paramAnonymousView.znQ;
        if (((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
        }
        String str = com.tencent.mm.plugin.sns.c.a.iRH.fw(((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.iht);
        int i = 0;
        if (paramAnonymousView.HAT.GaP == 1) {
          i = 2;
        }
        while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(paramAnonymousView, c.this.activity))
        {
          com.tencent.mm.plugin.sns.c.a.iRH.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.iht, str, paramAnonymousView.nDo, i, 11, 9, ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.Fss, paramAnonymousView.Id);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
          if (paramAnonymousView.HAT.GaP == 3) {
            i = 5;
          } else if (paramAnonymousView.HAT.GaP == 15) {
            i = 38;
          }
        }
        switch (((com.tencent.mm.protocal.protobuf.ba)localObject1).nEf)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100221);
          return;
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("rawUrl", ((com.tencent.mm.protocal.protobuf.ba)localObject1).Url);
          com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject2, c.this.activity);
          com.tencent.mm.plugin.sns.c.a.iRH.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.iht, str, paramAnonymousView.nDo, i, 11, 1, ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.Fss, paramAnonymousView.Id);
          continue;
          if (((com.tencent.mm.protocal.protobuf.ba)localObject1).Scene == 1)
          {
            localObject2 = new ic();
            ((ic)localObject2).duF.actionCode = 2;
            ((ic)localObject2).duF.scene = 3;
            ((ic)localObject2).duF.appId = ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.iht;
            ((ic)localObject2).duF.context = c.this.activity;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
            com.tencent.mm.plugin.sns.c.a.iRH.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.iht, str, paramAnonymousView.nDo, i, 11, 6, ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.Fss, paramAnonymousView.Id);
            continue;
            int j = al.a(c.this.activity, (com.tencent.mm.protocal.protobuf.ba)localObject1);
            if (j == 1)
            {
              localObject2 = new ic();
              ((ic)localObject2).duF.context = c.this.activity;
              ((ic)localObject2).duF.actionCode = 2;
              ((ic)localObject2).duF.appId = ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.iht;
              ((ic)localObject2).duF.messageAction = ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.Fsu;
              ((ic)localObject2).duF.messageExt = ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.Fst;
              ((ic)localObject2).duF.scene = 3;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
              com.tencent.mm.plugin.sns.c.a.iRH.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.iht, str, paramAnonymousView.nDo, i, 11, 6, ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.Fss, paramAnonymousView.Id);
            }
            else if (j == 2)
            {
              localObject2 = new ic();
              ((ic)localObject2).duF.context = c.this.activity;
              ((ic)localObject2).duF.actionCode = 1;
              ((ic)localObject2).duF.appId = ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.iht;
              ((ic)localObject2).duF.messageAction = ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.Fsu;
              ((ic)localObject2).duF.messageExt = ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.Fst;
              ((ic)localObject2).duF.scene = 3;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject2);
              com.tencent.mm.plugin.sns.c.a.iRH.a(c.this.activity, ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.iht, str, paramAnonymousView.nDo, i, 11, 3, ((com.tencent.mm.protocal.protobuf.ba)localObject1).Fsy.Fss, paramAnonymousView.Id);
            }
          }
        }
      }
    };
    this.AyC = new View.OnClickListener()
    {
      private static void aBf(String paramAnonymousString)
      {
        AppMethodBeat.i(198569);
        long l = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousString).field_snsId;
        Object localObject1 = com.tencent.mm.plugin.sns.model.ag.dUe().Ai(l);
        if (localObject1 != null)
        {
          Object localObject2 = ((p)localObject1).dYl();
          if (localObject2 != null)
          {
            localObject2 = ((TimeLineObject)localObject2).HAT.GaQ;
            if (((List)localObject2).size() > 0) {
              ((List)localObject2).get(0);
            }
          }
          localObject2 = ak.v((p)localObject1);
          localObject1 = new ArrayList();
          localObject2 = ((SnsObject)localObject2).SnsRedEnvelops.HuR;
          if (localObject2 != null)
          {
            int i = 0;
            while (i < ((List)localObject2).size())
            {
              dfw localdfw = (dfw)((List)localObject2).get(i);
              com.tencent.mm.plugin.l.a.a locala = new com.tencent.mm.plugin.l.a.a();
              locala.lEN = localdfw.Username;
              locala.viC = localdfw.CreateTime;
              locala.viD = localdfw.HtK;
              ((List)localObject1).add(locala);
              i += 1;
            }
          }
          com.tencent.mm.plugin.l.a.u(paramAnonymousString, (List)localObject1);
        }
        AppMethodBeat.o(198569);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100223);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if ((paramAnonymousView.getTag() instanceof p))
        {
          paramAnonymousView = (p)paramAnonymousView.getTag();
          if ((paramAnonymousView.field_type == 21) && (u.aAm().equals(paramAnonymousView.field_userName)))
          {
            paramAnonymousView.dYl();
            com.tencent.mm.plugin.sns.lucky.a.m.r(paramAnonymousView);
            com.tencent.mm.plugin.sns.lucky.a.m.q(paramAnonymousView);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.ma(24);
          }
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_sendid", paramAnonymousView.getSnsId());
          ((Intent)localObject2).putExtra("key_feedid", paramAnonymousView.dYK());
          ((Intent)localObject2).setClassName(c.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
          localObject1 = c.this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = paramAnonymousView.dYK();
          paramAnonymousView.getSnsId();
          aBf((String)localObject1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100223);
      }
    };
    this.Ayx = new c.16(this);
    this.Ayy = new c.17(this);
    this.Ayz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((paramAnonymousView.getTag() instanceof String))
        {
          paramAnonymousView = (String)paramAnonymousView.getTag();
          ad.d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(paramAnonymousView)));
          ak.PY(x.aAw(paramAnonymousView));
          ak.PW(x.aAw(paramAnonymousView));
          com.tencent.mm.plugin.sns.model.ag.dUa().dSE();
          c.this.dZC();
          if (c.this.Azd != null) {
            c.this.Azd.ecP();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100226);
      }
    };
    this.AyA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198570);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        try
        {
          int i = x.aAw((String)paramAnonymousView.getTag());
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_label_sns_info", i);
          com.tencent.mm.plugin.sns.c.a.iRG.u(paramAnonymousView, c.this.activity);
          label77:
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198570);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          break label77;
        }
      }
    };
    this.AyD = new d()
    {
      private static boolean c(com.tencent.mm.plugin.sns.ui.m paramAnonymousm)
      {
        AppMethodBeat.i(198571);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousm != null)
        {
          bool1 = bool2;
          if (paramAnonymousm.zhw != null)
          {
            bool1 = bool2;
            if (!bt.hj(paramAnonymousm.zhw.HtM)) {
              bool1 = true;
            }
          }
        }
        AppMethodBeat.o(198571);
        return bool1;
      }
      
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(198572);
        int i;
        long l;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          if (((!com.tencent.mm.plugin.sns.ui.widget.e.ia(paramAnonymousView.zhw.HtL, 16)) || (paramAnonymousView.scene == 2)) && (!c(paramAnonymousView))) {
            paramAnonymousContextMenu.add(0, 11, 0, c.this.activity.getString(2131755701));
          }
          if ((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE))
          {
            i = 1;
            if (((i != 0) && (!bt.isNullOrNil(paramAnonymousView.zPU)) && (paramAnonymousView.zPU.equals(u.aAm()))) || ((paramAnonymousView.nDo != null) && (paramAnonymousView.nDo.equals(u.aAm())))) {
              paramAnonymousContextMenu.add(0, 7, 0, c.this.activity.getString(2131755707));
            }
            if ((com.tencent.mm.plugin.sns.ui.widget.e.ia(paramAnonymousView.zhw.HtL, 16)) || (c(paramAnonymousView))) {
              break label372;
            }
            paramAnonymousContextMenuInfo = paramAnonymousView.zPS;
            StringBuilder localStringBuilder = new StringBuilder();
            if (paramAnonymousView.zhw.HtH == 0) {
              break label335;
            }
            l = paramAnonymousView.zhw.HtH;
            label224:
            paramAnonymousContextMenuInfo = ar.jp(paramAnonymousContextMenuInfo, l);
            if (paramAnonymousView.scene != 1) {
              break label347;
            }
            i = 2;
          }
        }
        for (;;)
        {
          label250:
          paramAnonymousView = ar.azc(paramAnonymousContextMenuInfo);
          if ((paramAnonymousView != null) && (paramAnonymousView.hII) && (!paramAnonymousView.aGQ) && ((i & paramAnonymousView.ePo) != 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label367;
            }
            ar.a(paramAnonymousContextMenu, false);
            AppMethodBeat.o(198572);
            return;
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qBq, 0) == 1)
            {
              i = 1;
              break;
            }
            i = 0;
            break;
            label335:
            l = paramAnonymousView.zhw.HtJ;
            break label224;
            label347:
            if (paramAnonymousView.scene != 2) {
              break label378;
            }
            i = 4;
            break label250;
          }
          label367:
          ar.b(paramAnonymousContextMenu, false);
          label372:
          AppMethodBeat.o(198572);
          return;
          label378:
          i = -1;
        }
      }
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(198573);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject = com.tencent.mm.plugin.sns.model.ag.dUe().azZ(((com.tencent.mm.plugin.sns.ui.m)localObject).zPS);
          c.this.Ayq.a(paramAnonymousView, ((p)localObject).dYK(), ((p)localObject).dYl());
          AppMethodBeat.o(198573);
          return true;
        }
        AppMethodBeat.o(198573);
        return false;
      }
    };
    this.tKQ = new c.21(this);
    this.AyN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100232);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.bd))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.bd)paramAnonymousView.getTag();
          localObject = com.tencent.mm.plugin.sns.model.ag.dUe().azZ(paramAnonymousView.dzb);
          if (localObject == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100232);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((p)localObject).dYl().HAQ);
          paramAnonymousView.putExtra("sns_local_id", ((p)localObject).dYK());
          paramAnonymousView.setClass(c.this.activity, SnsSingleTextViewUI.class);
          localObject = c.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject).startActivity((Intent)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100232);
      }
    };
    this.AyQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100239);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        s locals;
        Object localObject2;
        Object localObject3;
        String str1;
        int i;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          localObject2 = (byn)locals.zQl.HAT.GaQ.get(0);
          localObject1 = locals.doX;
          com.tencent.mm.plugin.sns.model.ag.dUe().azZ((String)localObject1);
          localObject1 = "";
          localObject3 = ao.jo(com.tencent.mm.plugin.sns.model.ag.getAccSnsPath(), ((byn)localObject2).Id);
          str1 = "";
          String str2 = com.tencent.mm.plugin.sns.data.q.i((byn)localObject2);
          if (com.tencent.mm.vfs.i.fv((String)localObject3 + str2))
          {
            localObject1 = (String)localObject3 + str2;
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.q.d((byn)localObject2);
          }
          if (com.tencent.mm.vfs.i.fv((String)localObject3 + com.tencent.mm.plugin.sns.data.q.o((byn)localObject2)))
          {
            localObject1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.q.o((byn)localObject2);
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.q.m((byn)localObject2);
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
          paramAnonymousView.putExtra("intent_localid", locals.doX);
          paramAnonymousView.putExtra("intent_isad", false);
          paramAnonymousView.putExtra("intent_from_scene", c.this.dnh);
          paramAnonymousView.putExtra("img_gallery_left", localObject2[0]);
          paramAnonymousView.putExtra("img_gallery_top", localObject2[1]);
          paramAnonymousView.putExtra("img_gallery_width", i);
          paramAnonymousView.putExtra("img_gallery_height", j);
          localObject1 = c.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)paramAnonymousView.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          c.this.activity.overridePendingTransition(0, 0);
          c.a(c.this, locals.zQl);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(100239);
          return;
          label535:
          paramAnonymousView.getLocationInWindow((int[])localObject2);
          i = paramAnonymousView.getWidth();
        }
      }
    };
    this.AyP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198576);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        ad.i("MicroMsg.TimelineClickListener", "onsight click");
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq)) {
          localObject1 = (com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag();
        }
        for (;;)
        {
          final p localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((com.tencent.mm.plugin.sns.ui.aq)localObject1).doX);
          if (localp == null)
          {
            ad.i("MicroMsg.TimelineClickListener", "onsight click but info is null localid %s", new Object[] { ((com.tencent.mm.plugin.sns.ui.aq)localObject1).doX });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198576);
            return;
            if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
            {
              localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).Atv;
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
              localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).Atv;
            }
          }
          else
          {
            if (c.this.zPG != null) {
              c.this.zPG.dTI().F(localp);
            }
            final boolean bool = localp.QM(32);
            if ((bool) && (localp.dRL() != null) && ((localp.dRL().dVZ()) || (localp.dRL().dWa())))
            {
              c.this.Azc.onClick(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198576);
              return;
            }
            final TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWw;
            if ((localTimeLineObject.HAT.GaQ == null) || (localTimeLineObject.HAT.GaQ.size() == 0))
            {
              ad.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198576);
              return;
            }
            final byn localbyn = (byn)localTimeLineObject.HAT.GaQ.get(0);
            if (bool)
            {
              com.tencent.mm.plugin.sns.model.ag.dUb();
              if (!com.tencent.mm.plugin.sns.model.f.t(localbyn))
              {
                ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zFD.setVisibility(8);
                ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWB.setVisibility(0);
                ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWB.fLr();
                com.tencent.mm.plugin.sns.model.ag.dUb().z(localbyn);
                paramAnonymousView = com.tencent.mm.plugin.sns.model.ag.dTZ();
                localObject1 = bj.frs();
                ((bj)localObject1).hbR = localTimeLineObject.CreateTime;
                paramAnonymousView.a(localbyn, 4, null, (bj)localObject1);
                if (bool) {
                  com.tencent.mm.plugin.sns.ad.d.m.a(com.tencent.mm.plugin.sns.ad.d.m.b.yZR, com.tencent.mm.plugin.sns.ad.d.m.a.yZI, localp, c.this.dnh);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198576);
                return;
              }
            }
            if ((localp.QM(32)) && (localp.dRL().dVU()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(localp.dYU().field_adxml))) {}
            int j;
            Object localObject3;
            for (int i = 1; (i == 0) && (bool) && (com.tencent.mm.plugin.sns.model.ag.dUb().u(localbyn)); i = 0)
            {
              com.tencent.mm.plugin.sns.model.ag.dUb().z(localbyn);
              ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zFD.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWB.setVisibility(8);
              paramAnonymousView = com.tencent.mm.plugin.sns.model.ag.dUb();
              localObject2 = ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWy;
              i = c.this.activity.hashCode();
              j = ((com.tencent.mm.plugin.sns.ui.aq)localObject1).position;
              localObject3 = bj.frs();
              ((bj)localObject3).hbR = localTimeLineObject.CreateTime;
              paramAnonymousView.a(localp, localbyn, (VideoSightView)localObject2, i, j, (bj)localObject3, bool);
              ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWy.start();
              if (bool) {
                com.tencent.mm.plugin.sns.ad.d.m.a(com.tencent.mm.plugin.sns.ad.d.m.b.yZR, com.tencent.mm.plugin.sns.ad.d.m.a.yZI, localp, c.this.dnh);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198576);
              return;
            }
            com.tencent.mm.modelsns.e locale;
            label754:
            int m;
            label809:
            label830:
            int k;
            if (c.this.dnh == 0)
            {
              localObject2 = com.tencent.mm.modelsns.e.pV(717);
              ((com.tencent.mm.modelsns.e)localObject2).Gs(com.tencent.mm.plugin.sns.data.q.n(localp)).pY(localp.field_type).eS(localp.QM(32)).Gs(localp.dYT()).Gs(localbyn.Id);
              ((com.tencent.mm.modelsns.e)localObject2).aLk();
              if (c.this.dnh != 0) {
                break label1546;
              }
              locale = com.tencent.mm.modelsns.e.pV(745);
              locale.Gs(com.tencent.mm.plugin.sns.data.q.n(localp)).pY(localp.field_type).eS(localp.QM(32));
              if (bool)
              {
                m = c.this.dnh;
                if (c.this.dnh != 0) {
                  break label1557;
                }
                i = 1;
                long l = localp.field_snsId;
                if (!localp.dRL().dVU()) {
                  break label1562;
                }
                j = 21;
                if (!localp.dRL().dVU()) {
                  break label1568;
                }
                k = 21;
                label845:
                localObject2 = new SnsAdClick(m, i, l, j, k);
                if (!localp.dRL().dVU()) {
                  break label1574;
                }
                com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, c.this.Abd, localp, 21);
              }
            }
            Object localObject4;
            for (;;)
            {
              com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
              if ((!localp.dRL().dVU()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(localp.dYU().field_adxml))) {
                com.tencent.mm.plugin.sns.ad.d.m.a(com.tencent.mm.plugin.sns.ad.d.m.b.yZR, com.tencent.mm.plugin.sns.ad.d.m.a.yZJ, localp, c.this.dnh);
              }
              localObject2 = "";
              localObject4 = ao.jo(com.tencent.mm.plugin.sns.model.ag.getAccSnsPath(), localbyn.Id);
              localObject3 = "";
              String str = com.tencent.mm.plugin.sns.data.q.i(localbyn);
              if (com.tencent.mm.vfs.i.fv((String)localObject4 + str))
              {
                localObject2 = (String)localObject4 + str;
                localObject3 = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.d(localbyn);
              }
              if (com.tencent.mm.vfs.i.fv((String)localObject4 + com.tencent.mm.plugin.sns.data.q.o(localbyn)))
              {
                localObject2 = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.o(localbyn);
                localObject3 = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.m(localbyn);
              }
              localObject4 = new int[2];
              paramAnonymousView.getLocationInWindow((int[])localObject4);
              i = paramAnonymousView.getWidth();
              j = paramAnonymousView.getHeight();
              com.tencent.mm.plugin.report.service.g.yhR.f(11444, new Object[] { Integer.valueOf(3) });
              if (bool) {
                break label1593;
              }
              ad.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
              paramAnonymousView = new Intent();
              paramAnonymousView.setClass(c.this.activity, SnsOnlineVideoActivity.class);
              paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
              paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
              paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.aq)localObject1).doX);
              paramAnonymousView.putExtra("intent_isad", bool);
              paramAnonymousView.putExtra("intent_from_scene", c.this.dnh);
              paramAnonymousView.putExtra("sns_video_scene", ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWD);
              localObject2 = com.tencent.mm.plugin.sns.ui.video.d.eeK().aBk(localTimeLineObject.Id);
              if ((localObject2 != null) && (((SnsTimelineVideoView)localObject2).isPlaying()))
              {
                paramAnonymousView.putExtra("intent_fromplayingvideo", true);
                paramAnonymousView.putExtra("intent_fromplayingvideo_tlobjid", localTimeLineObject.Id);
                paramAnonymousView.putExtra("intent_session_id", ((SnsTimelineVideoView)localObject2).getSessionId());
                paramAnonymousView.putExtra("intent_session_timestamp", ((SnsTimelineVideoView)localObject2).getSessionTimestamp());
                if (((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWx != null) {
                  ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWx.findViewById(2131305799).setVisibility(0);
                }
              }
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              locale.b(paramAnonymousView, "intent_key_StatisticsOplog");
              localObject1 = c.this.activity;
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Activity)localObject1).startActivity((Intent)paramAnonymousView.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              c.this.activity.overridePendingTransition(0, 0);
              c.a(c.this, localp.dYl());
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198576);
              return;
              localObject2 = com.tencent.mm.modelsns.e.pW(717);
              break;
              label1546:
              locale = com.tencent.mm.modelsns.e.pW(745);
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
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, c.this.Abd, localp, 17);
            }
            label1593:
            if ((localp.QM(32)) && (localp.dRL().dVU()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.azV(localp.dYU().field_adxml)))
            {
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.J(localp);
              if (!bt.isNullOrNil(paramAnonymousView)) {
                localp.dYU().field_adxml = paramAnonymousView;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
              paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dYl().Id);
              paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dYT());
              localObject1 = localp.dYl();
              if (localObject1 != null)
              {
                localObject1 = ((TimeLineObject)localObject1).HAT.GaQ;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((byn)((List)localObject1).get(0)).GSI);
                }
              }
              paramAnonymousView.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
              i = 1;
              if (c.this.dnh == 2) {
                i = 16;
              }
              for (;;)
              {
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", localp.dYU().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dYV());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                paramAnonymousView.putExtra("sns_landing_pages_is_normal_ad_animation", true);
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject1 = c.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                c.this.activity.overridePendingTransition(0, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198576);
                return;
                if (c.this.dnh == 1) {
                  i = 2;
                }
              }
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(c.this.activity, SnsSightPlayerUI.class);
            paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
            paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
            paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.aq)localObject1).doX);
            paramAnonymousView.putExtra("intent_isad", bool);
            paramAnonymousView.putExtra("intent_from_scene", c.this.dnh);
            paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
            paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
            paramAnonymousView.putExtra("img_gallery_width", i);
            paramAnonymousView.putExtra("img_gallery_height", j);
            locale.b(paramAnonymousView, "intent_key_StatisticsOplog");
            Object localObject2 = c.this.activity;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramAnonymousView.ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject2).startActivity((Intent)paramAnonymousView.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$31", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            c.this.activity.overridePendingTransition(0, 0);
            new ap().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(198575);
                if (com.tencent.mm.plugin.sns.model.ag.dUb().u(localbyn))
                {
                  this.Azp.zWy.e(null, false, 0);
                  com.tencent.mm.plugin.sns.model.f localf = com.tencent.mm.plugin.sns.model.ag.dUb();
                  p localp = localp;
                  byn localbyn = localbyn;
                  VideoSightView localVideoSightView = this.Azp.zWy;
                  int i = c.this.activity.hashCode();
                  int j = this.Azp.position;
                  bj localbj = bj.frs();
                  localbj.hbR = localTimeLineObject.CreateTime;
                  localf.a(localp, localbyn, localVideoSightView, i, j, localbj, bool);
                  this.Azp.zWy.start();
                  this.Azp.zFD.setVisibility(0);
                  this.Azp.zWB.setVisibility(8);
                  this.Azp.zFD.setImageDrawable(com.tencent.mm.cc.a.l(c.this.activity, 2131691166));
                }
                AppMethodBeat.o(198575);
              }
            }, 500L);
            paramAnonymousView = new int[3];
            if ((!bool) && (com.tencent.mm.plugin.sns.model.ag.dUb().a(localp, paramAnonymousView) > 5))
            {
              com.tencent.mm.plugin.sns.model.ag.dUb().y(localbyn);
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
                  paramAnonymousView = localp.dYl();
                  localObject1 = new com.tencent.mm.modelsns.g();
                  ((com.tencent.mm.modelsns.g)localObject1).m("20FeedId", paramAnonymousView.Id + ",");
                  ((com.tencent.mm.modelsns.g)localObject1).m("21AdUxInfo", localp.dYT() + ",");
                  for (;;)
                  {
                    try
                    {
                      paramAnonymousView = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
                      if (paramAnonymousView.ObjectOperations == null) {
                        continue;
                      }
                      paramAnonymousView = (dgh)new dgh().parseFrom(paramAnonymousView.ObjectOperations.getBufferToBytes());
                      if (paramAnonymousView.HuB == null) {
                        continue;
                      }
                      k = paramAnonymousView.HuB.Gch;
                    }
                    catch (Exception paramAnonymousView)
                    {
                      k = 0;
                      ad.printErrStackTrace("MicroMsg.TimelineClickListener", paramAnonymousView, "", new Object[0]);
                      j = 0;
                      continue;
                      if (com.tencent.mm.sdk.platformtools.ay.is2G(aj.getContext()))
                      {
                        i = 2;
                        continue;
                      }
                      if (com.tencent.mm.sdk.platformtools.ay.is3G(aj.getContext()))
                      {
                        i = 3;
                        continue;
                      }
                      if (!com.tencent.mm.sdk.platformtools.ay.is4G(aj.getContext())) {
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
                      j = paramAnonymousView.HuB.Gci;
                      ((com.tencent.mm.modelsns.g)localObject1).m("22LayerId", k + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("23ExpId", j + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("24ClickState", i + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("25ClickTime", bt.aQJ() + ",");
                      i = 0;
                      if (!com.tencent.mm.sdk.platformtools.ay.isWifi(aj.getContext())) {
                        continue;
                      }
                      i = 1;
                      ((com.tencent.mm.modelsns.g)localObject1).m("26NetworkType", i + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("27IsFlowControl", n + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("28AutoDownloadSetting", i1 + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("29IsAutoPlay", m + ",");
                      ((com.tencent.mm.modelsns.g)localObject1).m("30IsFlowControlDatePeriod", i2 + ",");
                      ad.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + ((com.tencent.mm.modelsns.g)localObject1).RE());
                      com.tencent.mm.plugin.report.service.g.yhR.f(13323, new Object[] { localObject1 });
                    }
                    catch (Exception paramAnonymousView) {}
                  }
                }
                if ((!bool) || (com.tencent.mm.plugin.sns.model.ag.dUb().b(localp, paramAnonymousView) <= 5)) {
                  break label2917;
                }
                com.tencent.mm.plugin.sns.model.ag.dUb().y(localbyn);
                i = 1;
                break label2313;
              }
            }
          }
          localObject1 = null;
        }
      }
    };
    this.AyG = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(198577);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag();
          if (!paramAnonymousView.isAd) {
            paramAnonymousContextMenu.add(0, 19, 0, c.this.activity.getString(2131757227));
          }
          if (bt.aRe(com.tencent.mm.n.g.acA().getValue("SIGHTCannotTransmitForFav")) != 0) {
            break label308;
          }
          if (paramAnonymousView.zWw.HAT.GaQ.size() <= 0) {
            break label301;
          }
          paramAnonymousContextMenuInfo = (byn)paramAnonymousView.zWw.HAT.GaQ.get(0);
          String str = paramAnonymousContextMenuInfo.Id;
          str = ao.jo(com.tencent.mm.plugin.sns.model.ag.getAccSnsPath(), str) + com.tencent.mm.plugin.sns.data.q.d(paramAnonymousContextMenuInfo);
          paramAnonymousContextMenuInfo = av.a(paramAnonymousView.doX, paramAnonymousContextMenuInfo);
          boolean bool1 = com.tencent.mm.vfs.i.fv(str);
          boolean bool2 = com.tencent.mm.vfs.i.fv(paramAnonymousContextMenuInfo);
          ad.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool1) || (!bool2)) {
            break label308;
          }
        }
        label301:
        label308:
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.bs.d.aIu("favorite")) {
            paramAnonymousContextMenu.add(0, 10, 0, c.this.activity.getString(2131761941));
          }
          if (i != 0)
          {
            paramAnonymousContextMenuInfo = new eb();
            paramAnonymousContextMenuInfo.dpg.doX = paramAnonymousView.doX;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousContextMenuInfo);
            if (paramAnonymousContextMenuInfo.dph.doF) {
              paramAnonymousContextMenu.add(0, 18, 0, c.this.activity.getString(2131755836));
            }
          }
          AppMethodBeat.o(198577);
          return;
          ad.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
        }
      }
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(198578);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag()).doX;
          p localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(str);
          c.this.Ayq.a(paramAnonymousView, str, localp.dYl());
          AppMethodBeat.o(198578);
          return true;
        }
        AppMethodBeat.o(198578);
        return false;
      }
    };
    this.AyR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198579);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        c.this.fe(paramAnonymousView);
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198579);
          return;
        }
        localObject = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
        paramAnonymousView = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((com.tencent.mm.plugin.sns.data.b)localObject).doX);
        if (paramAnonymousView == null)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198579);
          return;
        }
        int j;
        if (paramAnonymousView.QM(32))
        {
          ((com.tencent.mm.plugin.sns.data.b)localObject).zcr = System.currentTimeMillis();
          j = c.this.dnh;
          if (c.this.dnh != 0) {
            break label216;
          }
        }
        label216:
        for (int i = 1;; i = 2)
        {
          localObject = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 20, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject, c.this.Abd, paramAnonymousView, 20);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198579);
          return;
        }
      }
    };
    this.AyY = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100244);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        ad.i("MicroMsg.TimelineClickListener", "unlike click");
        if (!(paramAnonymousAdapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c))
        {
          ad.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(100244);
          return;
        }
        Object localObject2 = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
        p localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((com.tencent.mm.plugin.sns.data.b)localObject2).doX);
        if (localp == null) {
          try
          {
            c.this.dZE();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          catch (Exception paramAnonymousAdapterView)
          {
            for (;;)
            {
              ad.e("MicroMsg.TimelineClickListener", "onUnLikeFinishError exp=" + paramAnonymousAdapterView.toString());
            }
          }
        }
        if (paramAnonymousInt == 0) {
          if (localp.QM(32))
          {
            localObject1 = c.a(c.this, localp);
            if (localObject1 == null)
            {
              localObject1 = "";
              ((com.tencent.mm.plugin.sns.b.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.d.class)).a(11855, localp.dYV(), new Object[] { Integer.valueOf(3), localObject1, Integer.valueOf(localp.dYV()) });
            }
          }
          else
          {
            if (!((com.tencent.mm.plugin.sns.data.b)localObject2).zcq.ApS.zuT.dVS()) {
              break label406;
            }
            paramAnonymousView = (com.tencent.mm.plugin.sns.ui.c)paramAnonymousAdapterView.getAdapter();
            paramAnonymousView.kuN += 1;
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousAdapterView.setOnItemClickListener(c.this.AyZ);
            c.this.dZD();
            paramAnonymousAdapterView = new a.c.a();
            paramAnonymousAdapterView.zvp = a.c.a.zvl;
            paramAnonymousAdapterView.zcr = ((com.tencent.mm.plugin.sns.data.b)localObject2).zcr;
            paramAnonymousAdapterView.zvq = 0L;
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.q(localp.field_snsId, 8, paramAnonymousAdapterView);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousAdapterView, 0);
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
          if (((com.tencent.mm.plugin.sns.data.b)localObject2).zcq.ApS.zuX)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          c.this.ff(paramAnonymousView);
          paramAnonymousAdapterView = new a.c.a();
          paramAnonymousAdapterView.zcr = ((com.tencent.mm.plugin.sns.data.b)localObject2).zcr;
          paramAnonymousAdapterView.zvq = System.currentTimeMillis();
          paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.q(localp.field_snsId, 8, paramAnonymousAdapterView);
          com.tencent.mm.kernel.g.ajD();
          com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousAdapterView, 0);
          continue;
          if (((com.tencent.mm.plugin.sns.data.b)localObject2).zcq.ApR.zwr == null)
          {
            ad.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(100244);
            return;
          }
          paramAnonymousAdapterView = ((com.tencent.mm.plugin.sns.data.b)localObject2).zcq.ApR.zwr;
          paramAnonymousInt -= 1;
          if (paramAnonymousInt < paramAnonymousAdapterView.list.size()) {
            paramAnonymousAdapterView = ((b.f)paramAnonymousAdapterView.list.get(paramAnonymousInt)).url;
          }
          try
          {
            paramAnonymousView = String.format("snsid=%s", new Object[] { localp.dYl().Id });
            localObject1 = String.format("aid=%s", new Object[] { localp.dYP() });
            localObject2 = String.format("traceid=%s", new Object[] { localp.dYQ() });
            com.tencent.mm.kernel.g.ajA();
            paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.n(paramAnonymousAdapterView, new String[] { paramAnonymousView, localObject1, localObject2, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.aiq() }) });
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
          paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId));
          paramAnonymousView.putExtra("pre_username", localp.field_userName);
          paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(localp.field_snsId));
          paramAnonymousView.putExtra("preUsername", localp.field_userName);
          com.tencent.mm.plugin.sns.c.a.iRG.i(paramAnonymousView, c.this.activity);
        }
      }
    };
    this.AyZ = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(198580);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
        {
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
          if (paramAnonymousInt < paramAnonymousAdapterView.zcq.ApS.zuT.dVR().size())
          {
            if (paramAnonymousAdapterView.zcq.ApS.zuX)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(198580);
              return;
            }
            localObject = (a.c.a)paramAnonymousAdapterView.zcq.ApS.zuT.dVR().get(paramAnonymousInt);
            ad.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[] { ((a.c.a)localObject).zvm, Integer.valueOf(((a.c.a)localObject).zvp) });
            p localp = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousAdapterView.doX);
            if (localp == null)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(198580);
              return;
            }
            c.this.ff(paramAnonymousView);
            ((a.c.a)localObject).zcr = paramAnonymousAdapterView.zcr;
            ((a.c.a)localObject).zvq = System.currentTimeMillis();
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.q(localp.field_snsId, 8, localObject);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousAdapterView, 0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(198580);
      }
    };
    this.AyX = new c.30(this);
    this.Azc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198581);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if ((paramAnonymousView.getTag() == null) || ((!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) && (!(paramAnonymousView.getTag() instanceof az)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq)) && (!(paramAnonymousView.getTag() instanceof MaskImageView)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198581);
          return;
        }
        localObject1 = null;
        int m = 0;
        int j = 0;
        int n = 0;
        int k = 0;
        int i = 0;
        Object localObject3;
        if ((paramAnonymousView.getTag() instanceof az))
        {
          localObject3 = com.tencent.mm.plugin.sns.storage.h.aAa(((az)paramAnonymousView.getTag()).drH);
          if ((paramAnonymousView instanceof LinearLayout))
          {
            i = 0;
            if (!((az)paramAnonymousView.getTag()).zWE) {
              break label4753;
            }
            k = ((az)paramAnonymousView.getTag()).index;
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
          if ((localObject3 == null) || (!((p)localObject3).QM(32)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198581);
            return;
            i = 1;
            break;
            label240:
            j = 1;
            continue;
            if ((paramAnonymousView.getTag() instanceof MaskImageView))
            {
              localObject3 = (MaskImageView)paramAnonymousView.getTag();
              if (!(((MaskImageView)localObject3).getTag() instanceof az)) {
                break label4748;
              }
              localObject3 = com.tencent.mm.plugin.sns.storage.h.aAa(((az)((MaskImageView)localObject3).getTag()).drH);
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
              localObject3 = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((com.tencent.mm.plugin.sns.ui.aq)localObject1).doX);
              if ((paramAnonymousView instanceof LinearLayout))
              {
                j = 0;
                label370:
                if (!((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWE) {
                  break label4739;
                }
                k = ((com.tencent.mm.plugin.sns.ui.aq)localObject1).zWF;
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
                localObject1 = com.tencent.mm.plugin.sns.storage.h.azZ(((BaseTimeLineItem.BaseViewHolder)localObject3).dzb);
                if (!(localObject3 instanceof com.tencent.mm.plugin.sns.ui.item.m.b)) {
                  break label4734;
                }
                j = ((com.tencent.mm.plugin.sns.ui.item.m.b)localObject3).AxH.index;
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
                  localObject3 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).yXF;
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
                        localObject4 = ((p)localObject3).dYl().Id;
                        if (!((p)localObject3).dWk())
                        {
                          localObject5 = com.tencent.mm.plugin.report.service.g.yhR;
                          if (c.this.dnh != 0) {
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
                        ad.e("MicroMsg.TimelineClickListener", "report click ad card style error " + localException.getMessage());
                        continue;
                        localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject4).Atv;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).Atv;
                        continue;
                        if (c.this.zPG == null) {
                          continue;
                        }
                        c.this.zPG.dTI().F((p)localObject3);
                        boolean bool = ((p)localObject3).QM(32);
                        if ((((TimeLineObject)localObject6).HAT.GaQ != null) && (((TimeLineObject)localObject6).HAT.GaQ.size() != 0)) {
                          continue;
                        }
                        ad.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198581);
                        return;
                        byn localbyn = (byn)((TimeLineObject)localObject6).HAT.GaQ.get(k);
                        if (!bool) {
                          continue;
                        }
                        com.tencent.mm.plugin.sns.model.ag.dUb();
                        if ((com.tencent.mm.plugin.sns.model.f.t(localbyn)) || (localObject2 == null)) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).zFD.setVisibility(8);
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).zWB.setVisibility(0);
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).zWB.fLr();
                        com.tencent.mm.plugin.sns.model.ag.dUb().z(localbyn);
                        paramAnonymousView = com.tencent.mm.plugin.sns.model.ag.dTZ();
                        localObject2 = bj.frs();
                        ((bj)localObject2).hbR = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a(localbyn, 4, null, (bj)localObject2);
                        if (!bool) {
                          continue;
                        }
                        com.tencent.mm.plugin.sns.ad.d.m.a(com.tencent.mm.plugin.sns.ad.d.m.b.yZR, com.tencent.mm.plugin.sns.ad.d.m.a.yZI, (p)localObject3, c.this.dnh);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198581);
                        return;
                        if ((!((p)localObject3).QM(32)) || (!((p)localObject3).dRL().dVU())) {
                          continue;
                        }
                        String str = ((p)localObject3).dYU().field_adxml;
                        if (k <= 0) {
                          continue;
                        }
                        Object localObject5 = "adTurnCanvasInfo";
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jM(str, (String)localObject5)) {
                          continue;
                        }
                        m = 1;
                        if ((m != 0) || (!bool) || (!com.tencent.mm.plugin.sns.model.ag.dUb().u(localbyn)) || (localObject2 == null)) {
                          continue;
                        }
                        com.tencent.mm.plugin.sns.model.ag.dUb().z(localbyn);
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).zFD.setVisibility(8);
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).zWB.setVisibility(8);
                        paramAnonymousView = com.tencent.mm.plugin.sns.model.ag.dUb();
                        Object localObject4 = ((com.tencent.mm.plugin.sns.ui.aq)localObject2).zWy;
                        i = c.this.activity.hashCode();
                        j = ((com.tencent.mm.plugin.sns.ui.aq)localObject2).position;
                        localObject5 = bj.frs();
                        ((bj)localObject5).hbR = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a((p)localObject3, localbyn, (VideoSightView)localObject4, i, j, (bj)localObject5, bool);
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject2).zWy.start();
                        if (!bool) {
                          continue;
                        }
                        com.tencent.mm.plugin.sns.ad.d.m.a(com.tencent.mm.plugin.sns.ad.d.m.b.yZR, com.tencent.mm.plugin.sns.ad.d.m.a.yZI, (p)localObject3, c.this.dnh);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198581);
                        return;
                        localObject5 = "adCanvasInfo";
                        continue;
                        m = 0;
                        continue;
                        if (c.this.dnh != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.e.pV(717);
                        ((com.tencent.mm.modelsns.e)localObject2).Gs(com.tencent.mm.plugin.sns.data.q.n((p)localObject3)).pY(((p)localObject3).field_type).eS(((p)localObject3).QM(32)).Gs(((p)localObject3).dYT()).Gs(localbyn.Id);
                        ((com.tencent.mm.modelsns.e)localObject2).aLk();
                        if (c.this.dnh != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.e.pV(745);
                        ((com.tencent.mm.modelsns.e)localObject2).Gs(com.tencent.mm.plugin.sns.data.q.n((p)localObject3)).pY(((p)localObject3).field_type).eS(((p)localObject3).QM(32));
                        localObject2 = new int[2];
                        if (localObject4 == null) {
                          continue;
                        }
                        if (((BaseTimeLineItem.BaseViewHolder)localObject4).Atv.zWA == null) {
                          continue;
                        }
                        ((BaseTimeLineItem.BaseViewHolder)localObject4).Atv.zWA.getLocationInWindow((int[])localObject2);
                        j = ((BaseTimeLineItem.BaseViewHolder)localObject4).Atv.zWA.getWidth();
                        i = ((BaseTimeLineItem.BaseViewHolder)localObject4).Atv.zWA.getHeight();
                        com.tencent.mm.plugin.report.service.g.yhR.f(11444, new Object[] { Integer.valueOf(3) });
                        localObject4 = c.a(c.this, (p)localObject3);
                        if (!com.tencent.mm.plugin.sns.data.j.a(c.this.activity, (p)localObject3, (com.tencent.mm.plugin.sns.storage.a)localObject4, c.this.dnh, c.this.Abd)) {
                          continue;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198581);
                        return;
                        localObject2 = com.tencent.mm.modelsns.e.pW(717);
                        continue;
                        localObject2 = com.tencent.mm.modelsns.e.pW(745);
                        continue;
                        if (((TimeLineObject)localObject6).HAT.GaP != 27) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.item.m.b)localObject4).AxF.getLocationInWindow((int[])localObject2);
                        j = ((com.tencent.mm.plugin.sns.ui.item.m.b)localObject4).AxF.getWidth();
                        i = ((com.tencent.mm.plugin.sns.ui.item.m.b)localObject4).AxF.getHeight();
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq)) {
                          continue;
                        }
                        localObject4 = (com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag();
                        if (localObject4 == null) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.aq)localObject4).zWA.getLocationInWindow((int[])localObject2);
                        j = ((com.tencent.mm.plugin.sns.ui.aq)localObject4).zWA.getWidth();
                        i = ((com.tencent.mm.plugin.sns.ui.aq)localObject4).zWA.getHeight();
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
                        n = c.this.dnh;
                        if (c.this.dnh != 0) {
                          continue;
                        }
                        m = 1;
                        paramAnonymousView = new SnsAdClick(n, m, ((p)localObject3).field_snsId, 22, 21);
                        com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, c.this.Abd, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                        localObject4 = new Intent();
                        ((Intent)localObject4).putExtra("img_gallery_left", localObject2[0]);
                        ((Intent)localObject4).putExtra("img_gallery_top", localObject2[1]);
                        ((Intent)localObject4).putExtra("img_gallery_width", j);
                        ((Intent)localObject4).putExtra("img_gallery_height", i);
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_sns_id", ((p)localObject3).getSnsId());
                        ((Intent)localObject4).putExtra("sns_landing_pages_rawSnsId", ((p)localObject3).dYl().Id);
                        ((Intent)localObject4).putExtra("sns_landing_pages_ux_info", ((p)localObject3).dYT());
                        paramAnonymousView = ((p)localObject3).dYl();
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView = paramAnonymousView.HAT.GaQ;
                        if (paramAnonymousView.size() <= k) {
                          continue;
                        }
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_thumb_url", ((byn)paramAnonymousView.get(k)).GSI);
                        ((Intent)localObject4).setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                        i = 1;
                        if (c.this.dnh != 2) {
                          continue;
                        }
                        i = 16;
                        ((Intent)localObject4).putExtra("sns_landig_pages_from_source", i);
                        if (k <= 0) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dRL().dWi();
                        ((Intent)localObject4).putExtra("sns_landing_pages_xml", paramAnonymousView);
                        ((Intent)localObject4).putExtra("sns_landing_pages_rec_src", ((p)localObject3).dYV());
                        ((Intent)localObject4).putExtra("sns_landing_pages_xml_prefix", "adxml");
                        ((Intent)localObject4).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        ((Intent)localObject4).putExtra("sns_landing_is_native_sight_ad", true);
                        paramAnonymousView = c.this.activity;
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject4);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        c.this.activity.overridePendingTransition(0, 0);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198581);
                        return;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        c.this.a((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag());
                        continue;
                        m = 2;
                        continue;
                        if (c.this.dnh != 1) {
                          continue;
                        }
                        i = 2;
                        continue;
                        paramAnonymousView = ((p)localObject3).dYU().field_adxml;
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
                        j = c.this.dnh;
                        if (c.this.dnh != 0) {
                          continue;
                        }
                        i = 1;
                        paramAnonymousView = new SnsAdClick(j, i, ((p)localObject3).field_snsId, 22, 31);
                        com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, c.this.Abd, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198581);
                        return;
                        bool = false;
                        continue;
                        i = 2;
                        continue;
                        j = c.this.dnh;
                        if (c.this.dnh != 0) {
                          continue;
                        }
                        i = 1;
                        localObject4 = new SnsAdClick(j, i, ((p)localObject3).field_snsId, 22, 0);
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, c.this.Abd, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
                        if (k <= 0) {
                          continue;
                        }
                        localObject2 = ((p)localObject3).dRL().zwo.zuE;
                        paramAnonymousView = (View)localObject2;
                        if (!bt.isNullOrNil((String)localObject2)) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dYR();
                        if (!bt.isNullOrNil(paramAnonymousView)) {
                          continue;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198581);
                        return;
                        i = 2;
                        continue;
                        localObject2 = ((p)localObject3).dYS();
                        continue;
                        ad.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject3).dRL().zvx);
                        localObject5 = new Intent();
                        if (((p)localObject3).dRL().zvx != 0) {
                          continue;
                        }
                        bool = true;
                        if (!ac.iOW) {
                          continue;
                        }
                        bool = false;
                        localObject2 = paramAnonymousView;
                        if (localObject3 == null) {
                          continue;
                        }
                        localObject2 = paramAnonymousView;
                        if (!((p)localObject3).QM(32)) {
                          continue;
                        }
                        Object localObject6 = c.a(c.this, (p)localObject3);
                        localObject2 = paramAnonymousView;
                        if (localObject6 == null) {
                          continue;
                        }
                        ((Intent)localObject5).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject6).aQj);
                        localObject2 = com.tencent.mm.plugin.sns.data.q.jh(paramAnonymousView, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dFy);
                        com.tencent.mm.plugin.sns.data.q.g((Intent)localObject5, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dFy);
                        ((Intent)localObject5).putExtra("KRightBtn", bool);
                        paramAnonymousView = new Bundle();
                        paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                        paramAnonymousView.putString("key_snsad_statextstr", ((p)localObject3).dYl().zRz);
                        ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
                        ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                        ((Intent)localObject5).putExtra("useJs", true);
                        ((Intent)localObject5).putExtra("srcUsername", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("stastic_scene", 15);
                        ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("pre_username", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("preUsername", ((p)localObject3).field_userName);
                        com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject5, c.this.activity);
                        continue;
                        bool = false;
                        continue;
                        if (((((TimeLineObject)localObject6).HAT.GaP != 1) || (((TimeLineObject)localObject6).HAT.GaQ.size() != 1)) && (((TimeLineObject)localObject6).HAT.GaP != 7) && ((((TimeLineObject)localObject6).HAT.GaP != 27) || (((TimeLineObject)localObject6).HAT.GaQ.size() <= k) || (((byn)((TimeLineObject)localObject6).HAT.GaQ.get(k)).nEf != 2))) {
                          continue;
                        }
                        localObject2 = c.a(c.this, (p)localObject3);
                        if (!com.tencent.mm.plugin.sns.data.j.a(c.this.activity, (p)localObject3, (com.tencent.mm.plugin.sns.storage.a)localObject2, c.this.dnh, c.this.Abd)) {
                          continue;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198581);
                        return;
                        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                          continue;
                        }
                        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.a.a)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.item.a.a)paramAnonymousView.getTag()).AtT;
                        if (!((p)localObject3).dRL().dVU()) {
                          continue;
                        }
                        localObject5 = ((p)localObject3).dYU().field_adxml;
                        if (k <= 0) {
                          continue;
                        }
                        localObject4 = "adTurnCanvasInfo";
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jM((String)localObject5, (String)localObject4)) {
                          continue;
                        }
                        m = c.this.dnh;
                        if (c.this.dnh != 0) {
                          continue;
                        }
                        j = 1;
                        localObject4 = new SnsAdClick(m, j, ((p)localObject3).field_snsId, 21, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, c.this.Abd, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
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
                        ((Intent)localObject2).putExtra("sns_landing_pages_rawSnsId", ((p)localObject3).dYl().Id);
                        ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", ((p)localObject3).dYT());
                        ((Intent)localObject2).putExtra("sns_landing_pages_aid", ((p)localObject3).dYP());
                        ((Intent)localObject2).putExtra("sns_landing_pages_traceid", ((p)localObject3).dYQ());
                        paramAnonymousView = ((p)localObject3).dYl();
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView = paramAnonymousView.HAT.GaQ;
                        if (paramAnonymousView.size() <= k) {
                          continue;
                        }
                        ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((byn)paramAnonymousView.get(k)).GSI);
                        ((Intent)localObject2).setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                        i = 1;
                        if (c.this.dnh != 2) {
                          continue;
                        }
                        i = 16;
                        ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
                        if (k <= 0) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dRL().dWi();
                        ((Intent)localObject2).putExtra("sns_landing_pages_xml", paramAnonymousView);
                        ((Intent)localObject2).putExtra("sns_landing_pages_rec_src", ((p)localObject3).dYV());
                        ((Intent)localObject2).putExtra("sns_landing_pages_xml_prefix", "adxml");
                        ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        paramAnonymousView = c.this.activity;
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        c.this.activity.overridePendingTransition(0, 0);
                        if (c.this.zPG == null) {
                          continue;
                        }
                        c.this.zPG.dTI().F((p)localObject3);
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.e.a)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.item.e.a)paramAnonymousView.getTag()).AtT;
                        continue;
                        if (!(localObject2 instanceof com.tencent.mm.plugin.sns.ui.item.m.b)) {
                          continue;
                        }
                        localObject2 = (TagImageView)((com.tencent.mm.plugin.sns.ui.item.m.b)localObject2).AxH.view;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof k.a)) {
                          continue;
                        }
                        localObject2 = ((k.a)paramAnonymousView.getTag()).Axr;
                        continue;
                        localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject2).Avw.Ra(0);
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).AtC;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.c)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.c)paramAnonymousView.getTag()).AtT;
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
                        ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((byn)paramAnonymousView.get(0)).GSI);
                        continue;
                        if (c.this.dnh != 1) {
                          continue;
                        }
                        i = 2;
                        continue;
                        paramAnonymousView = ((p)localObject3).dYU().field_adxml;
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
                        k = c.this.dnh;
                        if (c.this.dnh != 0) {
                          continue;
                        }
                        j = 1;
                        paramAnonymousView = new SnsAdClick(k, j, ((p)localObject3).field_snsId, 31, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, c.this.Abd, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198581);
                        return;
                        bool = false;
                        continue;
                        j = 2;
                        continue;
                        if (k <= 0) {
                          continue;
                        }
                        localObject2 = ((p)localObject3).dRL().zwo.zuE;
                        paramAnonymousView = (View)localObject2;
                        if (!bt.isNullOrNil((String)localObject2)) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dYR();
                        if (!bt.isNullOrNil(paramAnonymousView)) {
                          continue;
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(198581);
                        return;
                        localObject2 = ((p)localObject3).dYS();
                        continue;
                        k = c.this.dnh;
                        if (c.this.dnh != 0) {
                          continue;
                        }
                        j = 1;
                        localObject4 = new SnsAdClick(k, j, ((p)localObject3).field_snsId, 0, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, c.this.Abd, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
                        ad.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject3).dRL().zvx);
                        localObject5 = new Intent();
                        if (((p)localObject3).dRL().zvx != 0) {
                          continue;
                        }
                        bool = true;
                        if (!ac.iOW) {
                          continue;
                        }
                        bool = false;
                        localObject2 = paramAnonymousView;
                        if (localObject3 == null) {
                          continue;
                        }
                        localObject2 = paramAnonymousView;
                        if (!((p)localObject3).QM(32)) {
                          continue;
                        }
                        localObject6 = c.a(c.this, (p)localObject3);
                        localObject2 = paramAnonymousView;
                        if (localObject6 == null) {
                          continue;
                        }
                        ((Intent)localObject5).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject6).aQj);
                        localObject2 = com.tencent.mm.plugin.sns.data.q.jh(paramAnonymousView, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dFy);
                        com.tencent.mm.plugin.sns.data.q.g((Intent)localObject5, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dFy);
                        ((Intent)localObject5).putExtra("KRightBtn", bool);
                        paramAnonymousView = new Bundle();
                        paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                        paramAnonymousView.putString("key_snsad_statextstr", ((p)localObject3).dYl().zRz);
                        ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
                        ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                        ((Intent)localObject5).putExtra("useJs", true);
                        ((Intent)localObject5).putExtra("srcUsername", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("stastic_scene", 15);
                        ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("pre_username", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.zw(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("preUsername", ((p)localObject3).field_userName);
                        com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject5, c.this.activity);
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
                      if (((p)localObject3).dYU().dRL().dWf())
                      {
                        localObject1 = ((p)localObject3).dYU().dRL().dVX();
                        localObject4 = ((p)localObject3).dYT();
                        com.tencent.mm.kernel.g.ajA();
                        localObject5 = com.tencent.mm.kernel.a.aiq();
                        x.b((String)localObject1, (String)localObject4, (String)localObject5, x.aH((String)localObject1, (String)localObject4, (String)localObject5), 0, "");
                      }
                      localObject6 = ((p)localObject3).dYl();
                      if (((((TimeLineObject)localObject6).HAT.GaP != 15) || (((TimeLineObject)localObject6).HBa == 1)) && ((((TimeLineObject)localObject6).HAT.GaP != 27) || (((TimeLineObject)localObject6).HAT.GaQ.size() <= k) || (((byn)((TimeLineObject)localObject6).HAT.GaQ.get(k)).nEf != 6))) {
                        continue;
                      }
                      ad.i("MicroMsg.TimelineClickListener", "onsight click");
                      localObject1 = null;
                      localObject4 = null;
                      if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aq)) {
                        localObject1 = (com.tencent.mm.plugin.sns.ui.aq)paramAnonymousView.getTag();
                      }
                      if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                        continue;
                      }
                      localObject4 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                      if (((TimeLineObject)localObject6).HAT.GaP != 27) {
                        continue;
                      }
                      localObject1 = ((com.tencent.mm.plugin.sns.ui.item.m.b)localObject4).AxI;
                      if (localObject3 != null) {
                        continue;
                      }
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(198581);
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
                  label4734:
                  i = 0;
                }
              }
              label4739:
              i = 0;
              k = m;
            }
            label4748:
            i = 0;
          }
          label4753:
          j = 0;
        }
      }
    };
    this.AyM = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(198583);
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)) && (com.tencent.mm.bs.d.aIu("favorite"))) {
          paramAnonymousContextMenu.add(0, 25, 0, c.this.activity.getString(2131761941));
        }
        AppMethodBeat.o(198583);
      }
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(198582);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof TimeLineObject)))
        {
          TimeLineObject localTimeLineObject = (TimeLineObject)paramAnonymousView.getTag();
          Object localObject = com.tencent.mm.plugin.sns.model.ag.dUe();
          String str = localTimeLineObject.Id;
          p localp = new p();
          if (!((com.tencent.mm.plugin.sns.storage.q)localObject).zMR)
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
              localObject = ((p)localObject).dYK();
              c.this.Ayq.a(paramAnonymousView, (String)localObject, localTimeLineObject);
            }
            AppMethodBeat.o(198582);
            return true;
            localObject = ((com.tencent.mm.plugin.sns.storage.q)localObject).db.a("SnsInfo", null, "snsId=?", new String[] { com.tencent.mm.plugin.sns.storage.q.aAm(new StringBuilder().append(str).toString()) }, null, null, null, 2);
            break;
            label200:
            ((Cursor)localObject).close();
          }
        }
        AppMethodBeat.o(198582);
        return false;
      }
    };
    this.AyK = new d()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(198585);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        Object localObject;
        if ((paramAnonymousContextMenuInfo instanceof s))
        {
          paramAnonymousContextMenuInfo = (s)paramAnonymousContextMenuInfo;
          localObject = paramAnonymousContextMenuInfo.zQl;
          if (com.tencent.mm.bs.d.aIu("favorite")) {
            switch (((TimeLineObject)localObject).HAT.GaP)
            {
            default: 
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, com.tencent.mm.plugin.sns.model.ag.dUe().aAa(paramAnonymousContextMenuInfo.doX));
          AppMethodBeat.o(198585);
          return;
          paramAnonymousContextMenu.add(0, 4, 0, paramAnonymousView.getContext().getString(2131761941));
          localObject = new eb();
          ((eb)localObject).dpg.doX = paramAnonymousContextMenuInfo.doX;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          if (((eb)localObject).dph.doF)
          {
            paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755836));
            continue;
            paramAnonymousContextMenu.add(0, 5, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 9, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            localObject = new eb();
            ((eb)localObject).dpg.doX = paramAnonymousContextMenuInfo.doX;
            com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
            if (((eb)localObject).dph.doF)
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
      
      public final boolean fo(View paramAnonymousView)
      {
        AppMethodBeat.i(198584);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof s))
        {
          localObject = (s)localObject;
          TimeLineObject localTimeLineObject = ((s)localObject).zQl;
          if ((localTimeLineObject.HAT.GaP == 10) || (localTimeLineObject.HAT.GaP == 17) || (localTimeLineObject.HAT.GaP == 22) || (localTimeLineObject.HAT.GaP == 23))
          {
            AppMethodBeat.o(198584);
            return false;
          }
          c.this.Ayq.a(paramAnonymousView, ((s)localObject).doX, localTimeLineObject);
          AppMethodBeat.o(198584);
          return true;
        }
        AppMethodBeat.o(198584);
        return false;
      }
    };
    this.AxL = new com.tencent.mm.plugin.sight.decode.a.b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(198586);
        if ((paramAnonymousb != null) && (paramAnonymousInt == 0)) {
          if (paramAnonymousb.yRz == null) {
            break label88;
          }
        }
        label88:
        for (paramAnonymousb = (View)paramAnonymousb.yRz.get();; paramAnonymousb = null)
        {
          if ((paramAnonymousb != null) && ((paramAnonymousb instanceof com.tencent.mm.plugin.sight.decode.a.a)))
          {
            paramAnonymousb = (com.tencent.mm.plugin.sight.decode.a.a)paramAnonymousb;
            paramAnonymousb.getVideoPath();
            if ((paramAnonymousb.getTagObject() != null) && ((paramAnonymousb.getTagObject() instanceof com.tencent.mm.plugin.sns.ui.aq))) {
              paramAnonymousb.getTagObject();
            }
          }
          AppMethodBeat.o(198586);
          return;
        }
      }
    };
    this.AyU = new c.36(this);
    this.AyV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163134);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        c.this.dZF();
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.e)))
        {
          paramAnonymousView = com.tencent.mm.plugin.sns.model.ag.dUe().aAa(((com.tencent.mm.plugin.sns.data.e)paramAnonymousView.getTag()).doX);
          if (paramAnonymousView != null)
          {
            localObject = com.tencent.mm.plugin.sns.j.e.ztz;
            com.tencent.mm.plugin.sns.j.e.azF(paramAnonymousView.field_userName);
            paramAnonymousView = new com.tencent.mm.plugin.sns.model.q(paramAnonymousView.field_snsId, 9);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousView, 0);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163134);
      }
    };
    this.AyW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198587);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject1 = paramAnonymousView.zhw;
          if ((localObject1 != null) && (!bt.hj(((dfn)localObject1).HtM)) && (((dfn)localObject1).HtM.get(0) != null))
          {
            Object localObject2 = ((dft)((dfn)localObject1).HtM.get(0)).Md5;
            EmojiInfo localEmojiInfo = com.tencent.mm.storage.bd.frc().ILn.aUK((String)localObject2);
            Intent localIntent = new Intent();
            localIntent.putExtra("custom_smiley_preview_md5", (String)localObject2);
            if ((localEmojiInfo.field_catalog != EmojiGroupInfo.OeM) && (localEmojiInfo.field_catalog != EmojiGroupInfo.OeL) && (localEmojiInfo.field_catalog != EmojiGroupInfo.OeK)) {
              localIntent.putExtra("custom_smiley_preview_productid", localEmojiInfo.field_groupId);
            }
            com.tencent.mm.bs.d.b(c.this.activity, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
            localObject2 = com.tencent.mm.plugin.sns.j.e.ztz;
            long l = x.axN(paramAnonymousView.zPS);
            paramAnonymousView = String.valueOf(((dfn)localObject1).HtH);
            localObject1 = com.tencent.mm.plugin.sns.data.q.zw(l);
            localObject1 = (com.tencent.mm.plugin.sns.j.e.a)((com.tencent.mm.plugin.sns.j.e)localObject2).ztK.get(localObject1);
            if ((localObject1 != null) && (!((com.tencent.mm.plugin.sns.j.e.a)localObject1).zuq.contains(paramAnonymousView))) {
              ((com.tencent.mm.plugin.sns.j.e.a)localObject1).zuq.add(paramAnonymousView);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(198587);
      }
    };
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, p paramp, int paramInt)
  {
    try
    {
      if (!bt.isNullOrNil(paramString1))
      {
        if (paramInt == 2) {}
        for (com.tencent.mm.plugin.sns.storage.a locala = paramp.dYi(); locala == null; locala = paramp.dRK())
        {
          ad.e("MicroMsg.TimelineClickListener", "jumpWeApp adInfo==null");
          return false;
        }
        String str = com.tencent.mm.plugin.sns.data.q.zw(paramp.field_snsId) + ":" + locala.dFy + ":" + com.tencent.mm.plugin.sns.model.ag.dTJ() + ":" + System.currentTimeMillis();
        if (paramInt == 0) {}
        for (paramInt = 1045;; paramInt = 1046)
        {
          com.tencent.mm.plugin.sns.data.q.a(paramString1, paramString2, paramString3, paramp.dYP(), paramp.dYQ(), str, locala.dFy, paramInt);
          return true;
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.TimelineClickListener", "jumpWeApp exp:" + paramString1.toString());
    }
  }
  
  public final void a(com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    if (this.Ayo != null) {
      ad.w("MicroMsg.TimelineClickListener", "has already prepare detail click animation");
    }
    do
    {
      return;
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.b))
      {
        this.Ayo = new com.tencent.mm.plugin.sns.ui.b.a.d((MMActivity)this.activity, parama);
        this.Ayp = new com.tencent.mm.plugin.sns.ui.b.a.c((MMActivity)this.activity, parama);
        return;
      }
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
      {
        this.Ayo = new com.tencent.mm.plugin.sns.ui.b.a.f((MMActivity)this.activity, parama);
        this.Ayp = new com.tencent.mm.plugin.sns.ui.b.a.e((MMActivity)this.activity, parama);
        return;
      }
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.e))
      {
        this.Ayo = new com.tencent.mm.plugin.sns.ui.b.a.j((MMActivity)this.activity, parama);
        this.Ayp = new com.tencent.mm.plugin.sns.ui.b.a.i((MMActivity)this.activity, parama);
        return;
      }
    } while (!(parama instanceof com.tencent.mm.plugin.sns.ui.c.a.d));
    this.Ayo = new com.tencent.mm.plugin.sns.ui.b.a.h((MMActivity)this.activity, parama);
    this.Ayp = new com.tencent.mm.plugin.sns.ui.b.a.g((MMActivity)this.activity, parama);
  }
  
  public final void b(com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    this.Abd = parami;
    if (this.Ayq != null) {
      this.Ayq.b(parami);
    }
  }
  
  public abstract void dI(Object paramObject);
  
  public abstract void dZC();
  
  public abstract void dZD();
  
  public abstract void dZE();
  
  public abstract void dZF();
  
  public final void deP()
  {
    this.Ayq.deP();
    com.tencent.mm.sdk.b.a.IbL.c(this.Azf);
    com.tencent.mm.sdk.b.a.IbL.c(this.Azg);
  }
  
  public abstract void fa(View paramView);
  
  public abstract void fb(View paramView);
  
  public abstract void fc(View paramView);
  
  public abstract void fd(View paramView);
  
  public abstract void fe(View paramView);
  
  public abstract void ff(View paramView);
  
  public abstract void fg(View paramView);
  
  public final void m(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    if (this.Aym != null) {
      ad.w("MicroMsg.TimelineClickListener", "has already prepare click animation");
    }
    do
    {
      return;
      if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.a.a))
      {
        this.Aym = new com.tencent.mm.plugin.sns.ui.b.b.d((MMActivity)this.activity, paramBaseViewHolder);
        this.Ayn = new com.tencent.mm.plugin.sns.ui.b.b.c((MMActivity)this.activity, paramBaseViewHolder);
        ((com.tencent.mm.plugin.sns.ui.item.a.a)paramBaseViewHolder).AwE = true;
        return;
      }
      if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.e.a))
      {
        this.Aym = new com.tencent.mm.plugin.sns.ui.b.b.f((MMActivity)this.activity, paramBaseViewHolder);
        this.Ayn = new com.tencent.mm.plugin.sns.ui.b.b.e((MMActivity)this.activity, paramBaseViewHolder);
        ((com.tencent.mm.plugin.sns.ui.item.e.a)paramBaseViewHolder).AwE = true;
        return;
      }
      if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.m.b))
      {
        this.Aym = new com.tencent.mm.plugin.sns.ui.b.b.j((MMActivity)this.activity, paramBaseViewHolder);
        this.Ayn = new com.tencent.mm.plugin.sns.ui.b.b.i((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
    } while (!(paramBaseViewHolder instanceof k.a));
    this.Aym = new com.tencent.mm.plugin.sns.ui.b.b.h((MMActivity)this.activity, paramBaseViewHolder);
    this.Ayn = new com.tencent.mm.plugin.sns.ui.b.b.g((MMActivity)this.activity, paramBaseViewHolder);
  }
  
  public final void removeListener()
  {
    this.Ayq.removeListener();
    com.tencent.mm.sdk.b.a.IbL.d(this.Azf);
    com.tencent.mm.sdk.b.a.IbL.d(this.Azg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.c
 * JD-Core Version:    0.7.0.1
 */