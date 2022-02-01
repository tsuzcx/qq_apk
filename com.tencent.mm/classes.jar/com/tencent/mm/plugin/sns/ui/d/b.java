package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.a.vy;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.ad.d.m.a;
import com.tencent.mm.plugin.sns.ad.d.m.b;
import com.tencent.mm.plugin.sns.j.f.a;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.b;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.a.c;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.b.j;
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
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.be.b;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.plugin.sns.ui.item.i.a;
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.plugin.sns.ui.item.k.b;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.cha;
import com.tencent.mm.protocal.protobuf.daa;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.daj;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.dbb;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class b
{
  Activity activity;
  int dbL = 0;
  private ClipboardManager qRg;
  public View.OnTouchListener sOi;
  public View.OnClickListener yAf;
  protected com.tencent.mm.plugin.sns.ad.d.i yJJ;
  ae yyv;
  public com.tencent.mm.plugin.sight.decode.a.b.e zfM;
  public View.OnClickListener zgA;
  public View.OnClickListener zgB;
  public c zgC;
  public c zgD;
  public c zgE;
  public c zgF;
  public c zgG;
  public c zgH;
  public c zgI;
  c zgJ;
  public View.OnClickListener zgK;
  public View.OnClickListener zgL;
  public View.OnClickListener zgM;
  public View.OnClickListener zgN;
  public View.OnClickListener zgO;
  public View.OnClickListener zgP;
  public View.OnClickListener zgQ;
  public View.OnClickListener zgR;
  public View.OnClickListener zgS;
  public View.OnClickListener zgT;
  public View.OnClickListener zgU;
  public AdapterView.OnItemClickListener zgV;
  public AdapterView.OnItemClickListener zgW;
  public View.OnClickListener zgX = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100199);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(100199);
        return;
      }
      p localp = b.eY(paramAnonymousView);
      if ((localp == null) || (!localp.Pe(32)))
      {
        AppMethodBeat.o(100199);
        return;
      }
      int j;
      int i;
      Object localObject;
      label121:
      int k;
      if (localp.dME().dFR().dJP())
      {
        j = x.jF(localp.dME().dFR().dJJ(), localp.dMD());
        if (j > 0)
        {
          i = 1;
          localObject = localp.dME().dFR().dJJ();
          String str1 = localp.dMD();
          com.tencent.mm.kernel.g.agP();
          String str2 = com.tencent.mm.kernel.a.afE();
          if (i == 0) {
            break label215;
          }
          if (i == 0) {
            break label220;
          }
          k = 0;
          label128:
          x.b((String)localObject, str1, str2, j, k, "");
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject = localp.dLV();
        if ((((TimeLineObject)localObject).FQo.Ety == 15) && (((TimeLineObject)localObject).FQv != 1))
        {
          b.a(b.this, paramAnonymousView, localp, 1001, localp.dME().dFR().dJQ(), bool);
          AppMethodBeat.o(100199);
          return;
          i = 0;
          break;
          label215:
          j = 1;
          break label121;
          label220:
          k = 1;
          break label128;
        }
        if (((((TimeLineObject)localObject).FQo.Ety == 1) && (((TimeLineObject)localObject).FQo.Etz.size() == 1)) || (((TimeLineObject)localObject).FQo.Ety == 7)) {
          b.b(b.this, paramAnonymousView, localp, 1001, localp.dME().dFR().dJQ(), bool);
        }
        AppMethodBeat.o(100199);
        return;
      }
    }
  };
  public View.OnClickListener zgY = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      AppMethodBeat.i(100219);
      if (paramAnonymousView.getTag() == null)
      {
        AppMethodBeat.o(100219);
        return;
      }
      p localp = b.eY(paramAnonymousView);
      if ((localp == null) || (!localp.Pe(32)))
      {
        AppMethodBeat.o(100219);
        return;
      }
      int j;
      int i;
      Object localObject;
      label121:
      int k;
      if (localp.dME().dFR().dJP())
      {
        j = x.jF(localp.dME().dFR().dJJ(), localp.dMD());
        if (j > 0)
        {
          i = 1;
          localObject = localp.dME().dFR().dJJ();
          String str1 = localp.dMD();
          com.tencent.mm.kernel.g.agP();
          String str2 = com.tencent.mm.kernel.a.afE();
          if (i == 0) {
            break label215;
          }
          if (i == 0) {
            break label220;
          }
          k = 0;
          label128:
          x.b((String)localObject, str1, str2, j, k, "");
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject = localp.dLV();
        if ((((TimeLineObject)localObject).FQo.Ety == 15) && (((TimeLineObject)localObject).FQv != 1))
        {
          b.a(b.this, paramAnonymousView, localp, 1002, localp.dME().dFR().dJR(), bool);
          AppMethodBeat.o(100219);
          return;
          i = 0;
          break;
          label215:
          j = 2;
          break label121;
          label220:
          k = 1;
          break label128;
        }
        if (((((TimeLineObject)localObject).FQo.Ety == 1) && (((TimeLineObject)localObject).FQo.Etz.size() == 1)) || (((TimeLineObject)localObject).FQo.Ety == 7)) {
          b.b(b.this, paramAnonymousView, localp, 1002, localp.dME().dFR().dJR(), bool);
        }
        AppMethodBeat.o(100219);
        return;
      }
    }
  };
  public View.OnClickListener zgZ;
  volatile com.tencent.mm.plugin.sns.ui.b.b.b zgl;
  volatile com.tencent.mm.plugin.sns.ui.b.b.a zgm;
  volatile com.tencent.mm.plugin.sns.ui.b.a.b zgn;
  volatile com.tencent.mm.plugin.sns.ui.b.a.a zgo;
  public a zgp;
  public View.OnClickListener zgq;
  public View.OnLongClickListener zgr;
  public c zgs;
  public View.OnClickListener zgt;
  public View.OnClickListener zgu;
  public View.OnClickListener zgv;
  public View.OnClickListener zgw;
  public View.OnClickListener zgx;
  public View.OnClickListener zgy;
  public View.OnClickListener zgz;
  public be.b zha;
  int zhb;
  private com.tencent.mm.sdk.b.c<vy> zhc = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.sdk.b.c<vx> zhd = new com.tencent.mm.sdk.b.c() {};
  public View.OnClickListener zhe = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(163134);
      Object localObject1 = paramAnonymousView.getTag();
      Object localObject3 = null;
      Object localObject2;
      if ((localObject1 instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
        localObject1 = com.tencent.mm.plugin.sns.storage.h.auS(((BaseTimeLineItem.BaseViewHolder)localObject2).dnn);
        localObject3 = ((BaseTimeLineItem.BaseViewHolder)localObject2).zdp;
        localObject2 = null;
      }
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        int i;
        if (localObject1 != null)
        {
          localObject4 = ((p)localObject1).dME();
          int k = ((com.tencent.mm.plugin.sns.storage.e)localObject4).getSource();
          if ((localObject1 != null) && (((p)localObject1).Pe(32)))
          {
            localObject5 = b.a(b.this, (p)localObject1);
            if ((((p)localObject1).dFR().dJG()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(((p)localObject1).dME().field_adxml)))
            {
              localObject5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.H((p)localObject1);
              if (!bs.isNullOrNil((String)localObject5)) {
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
                label188:
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
                paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
                paramAnonymousView.putExtra("img_gallery_width", i);
                paramAnonymousView.putExtra("img_gallery_height", j);
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", ((p)localObject1).getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", ((p)localObject1).dLV().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", ((p)localObject1).dMD());
                localObject2 = ((p)localObject1).dLV();
                if (localObject2 != null)
                {
                  localObject2 = ((TimeLineObject)localObject2).FQo.Etz;
                  if (((List)localObject2).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((btz)((List)localObject2).get(0)).Fjh);
                  }
                }
                paramAnonymousView.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (k != 2) {
                  break label588;
                }
                i = 16;
                label352:
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", ((p)localObject1).dME().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", ((p)localObject1).dMF());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject2 = b.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramAnonymousView.aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject2).startActivity((Intent)paramAnonymousView.lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                b.this.activity.overridePendingTransition(0, 0);
                if (k != 0) {
                  break label600;
                }
              }
              label588:
              label600:
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 21));
                AppMethodBeat.o(163134);
                return;
                if (!(localObject1 instanceof p)) {
                  break label1215;
                }
                localObject1 = (p)localObject1;
                localObject2 = (MMImageView)paramAnonymousView.getTag(2131301433);
                break;
                if (localObject2 == null) {
                  break label188;
                }
                ((MMImageView)localObject2).getLocationInWindow((int[])localObject4);
                i = ((MMImageView)localObject2).getWidth();
                j = ((MMImageView)localObject2).getHeight();
                break label188;
                if (k != 1) {
                  break label352;
                }
                i = 10;
                break label352;
              }
            }
            if ((localObject5 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject5).yez == 1))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject5).yeB);
              paramAnonymousView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject5).yeC);
              paramAnonymousView.putExtra("key_from_scene", 21);
              paramAnonymousView.putExtra("key_stastic_scene", 15);
              com.tencent.mm.br.d.b(b.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
              if (k == 0) {}
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 11));
                AppMethodBeat.o(163134);
                return;
              }
            }
            if (b.a(b.this, (com.tencent.mm.plugin.sns.storage.a)localObject5, (p)localObject1, false))
            {
              if (k == 0) {}
              for (i = 1;; i = 2)
              {
                com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 31));
                AppMethodBeat.o(163134);
                return;
              }
            }
          }
          if (k != 0) {
            break label1204;
          }
          i = 1;
          localObject3 = new SnsAdClick(k, i, ((p)localObject1).field_snsId, 23, 0);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject3);
          localObject2 = ((p)localObject1).dMC();
          paramAnonymousView = (View)localObject2;
          if (bs.isNullOrNil((String)localObject2)) {
            paramAnonymousView = ((p)localObject1).dMB();
          }
          ac.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject1).dFR().yfv);
          localObject5 = new Intent();
          if (((p)localObject1).dFR().yfv != 0) {
            break label1209;
          }
        }
        label1204:
        label1209:
        for (boolean bool = true;; bool = false)
        {
          if (ab.ivP) {
            bool = false;
          }
          localObject2 = paramAnonymousView;
          if (localObject1 != null)
          {
            localObject2 = paramAnonymousView;
            if (((p)localObject1).Pe(32))
            {
              com.tencent.mm.plugin.sns.storage.a locala = b.a(b.this, (p)localObject1);
              localObject2 = paramAnonymousView;
              if (locala != null)
              {
                ((Intent)localObject5).putExtra("KsnsViewId", locala.dyy);
                localObject2 = com.tencent.mm.plugin.sns.data.q.iV(paramAnonymousView, locala.dtx);
                com.tencent.mm.plugin.sns.data.q.g((Intent)localObject5, locala.dtx);
              }
            }
          }
          ((Intent)localObject5).putExtra("KRightBtn", bool);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject3);
          paramAnonymousView.putString("key_snsad_statextstr", ((com.tencent.mm.plugin.sns.storage.e)localObject4).dLV().yAj);
          ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
          ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
          ((Intent)localObject5).putExtra("useJs", true);
          ((Intent)localObject5).putExtra("srcUsername", ((p)localObject1).field_userName);
          ((Intent)localObject5).putExtra("stastic_scene", 15);
          ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(((p)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("pre_username", ((p)localObject1).field_userName);
          ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(((p)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("preUsername", ((p)localObject1).field_userName);
          com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject5, b.this.activity);
          AppMethodBeat.o(163134);
          return;
          i = 2;
          break;
        }
        label1215:
        localObject2 = null;
        localObject1 = null;
      }
    }
  };
  
  public b(int paramInt, Activity paramActivity, ae paramae)
  {
    this.dbL = paramInt;
    this.activity = paramActivity;
    this.yyv = paramae;
    this.zhb = bs.getInt(com.tencent.mm.m.g.ZY().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
    ac.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[] { Integer.valueOf(this.zhb) });
    this.qRg = ((ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard"));
    this.zgp = new a(this.activity, this.dbL, this.yyv);
    this.zgA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100258);
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof Long)))
        {
          AppMethodBeat.o(100258);
          return;
        }
        long l = ((Long)paramAnonymousView.getTag()).longValue();
        com.tencent.mm.plugin.sns.storage.e locale = af.dHU().xB(l);
        p localp = locale.dMb();
        com.tencent.mm.plugin.sns.ad.d.m.a(m.b.xKC, m.a.xKA, locale.dMb(), b.this.dbL);
        locale.getSource();
        paramAnonymousView = localp.dMC();
        if (bs.isNullOrNil(paramAnonymousView)) {
          paramAnonymousView = localp.dMB();
        }
        for (;;)
        {
          Object localObject1;
          int i;
          Object localObject2;
          int j;
          if (localp.Pe(32))
          {
            localObject1 = b.a(b.this, localp);
            i = -1;
            localObject2 = com.tencent.mm.model.c.d.aAq().aMC("Sns_CanvasAd_DetailLink_JumpWay");
            if (((com.tencent.mm.storage.a)localObject2).isValid()) {
              i = bs.getInt(((com.tencent.mm.storage.a)localObject2).field_value, -1);
            }
            if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).yez == 1))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject1).yeB);
              paramAnonymousView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject1).yeC);
              paramAnonymousView.putExtra("key_from_scene", 21);
              paramAnonymousView.putExtra("key_stastic_scene", 15);
              com.tencent.mm.br.d.b(b.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
              j = b.this.dbL;
              if (b.this.dbL == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 11);
                com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.yJJ, localp, 3);
                com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                AppMethodBeat.o(100258);
                return;
              }
            }
            if ((localObject1 != null) && (i == 1))
            {
              if ((localp.dFR().dJG()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(localp.dME().field_adxml)))
              {
                paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.H(localp);
                if (!bs.isNullOrNil(paramAnonymousView)) {
                  locale.field_adxml = paramAnonymousView;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dLV().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dMD());
                paramAnonymousView.putExtra("sns_landing_pages_aid", localp.dMz());
                paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.dMA());
                localObject1 = localp.dLV();
                if (localObject1 != null)
                {
                  localObject1 = ((TimeLineObject)localObject1).FQo.Etz;
                  if (((List)localObject1).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((btz)((List)localObject1).get(0)).Fjh);
                  }
                }
                paramAnonymousView.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (b.this.dbL == 2)
                {
                  i = 16;
                  paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                  paramAnonymousView.putExtra("sns_landing_pages_xml", localp.dME().field_adxml);
                  paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                  paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dMF());
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                  localObject1 = b.this.activity;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)paramAnonymousView.lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  b.this.activity.overridePendingTransition(0, 0);
                  j = b.this.dbL;
                  if (b.this.dbL != 0) {
                    break label744;
                  }
                }
                label744:
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 21);
                  com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.yJJ, localp, 3);
                  com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                  AppMethodBeat.o(100258);
                  return;
                  if (b.this.dbL != 1) {
                    break;
                  }
                  i = 10;
                  break;
                }
              }
            }
            else if ((localObject1 != null) && (i == 0))
            {
              if ((!localp.dFR().dJG()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(localp.dME().field_adxml))) {
                break label1869;
              }
              localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.H(localp);
              if (!bs.isNullOrNil((String)localObject1)) {
                locale.field_adxml = ((String)localObject1);
              }
              localObject1 = bv.L(localp.dME().field_adxml, "adxml");
              if (localObject1 != null)
              {
                localObject1 = bs.bG((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareWebUrl"), "");
                if (!bs.isNullOrNil((String)localObject1)) {
                  paramAnonymousView = (View)localObject1;
                }
              }
            }
          }
          label1863:
          label1869:
          for (;;)
          {
            j = b.this.dbL;
            label878:
            Intent localIntent;
            if (b.this.dbL == 0)
            {
              i = 1;
              localObject2 = new SnsAdClick(j, i, localp.field_snsId, 3, 0);
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, b.this.yJJ, localp, 3);
              com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
              ac.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + localp.dFR().yfv);
              localIntent = new Intent();
              if (localp.dFR().yfv != 0) {
                break label1863;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              if (ab.ivP) {
                bool = false;
              }
              localObject1 = paramAnonymousView;
              if (localp.Pe(32))
              {
                com.tencent.mm.plugin.sns.storage.a locala = b.a(b.this, localp);
                localObject1 = paramAnonymousView;
                if (locala != null)
                {
                  localIntent.putExtra("KsnsViewId", locala.dyy);
                  localObject1 = com.tencent.mm.plugin.sns.data.q.iV(paramAnonymousView, locala.dtx);
                  com.tencent.mm.plugin.sns.data.q.g(localIntent, locala.dtx);
                }
              }
              localIntent.putExtra("KRightBtn", bool);
              paramAnonymousView = new Bundle();
              paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject2);
              paramAnonymousView.putString("key_snsad_statextstr", locale.dLV().yAj);
              localIntent.putExtra("jsapiargs", paramAnonymousView);
              localIntent.putExtra("rawUrl", (String)localObject1);
              localIntent.putExtra("useJs", true);
              localIntent.putExtra("srcUsername", localp.field_userName);
              localIntent.putExtra("sns_local_id", localp.dMu());
              localIntent.putExtra("stastic_scene", 15);
              localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId));
              localIntent.putExtra("pre_username", localp.field_userName);
              localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId));
              localIntent.putExtra("preUsername", localp.field_userName);
              com.tencent.mm.plugin.sns.c.a.iyx.i(localIntent, b.this.activity);
              AppMethodBeat.o(100258);
              return;
              ac.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + localp.dME().field_adxml);
              break;
              if ((localObject1 != null) && (i == -1) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).yez == 3))
              {
                if ((!localp.dFR().dJG()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(localp.dME().field_adxml))) {
                  break label1869;
                }
                paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.H(localp);
                if (!bs.isNullOrNil(paramAnonymousView)) {
                  locale.field_adxml = paramAnonymousView;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dLV().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dMD());
                paramAnonymousView.putExtra("sns_landing_pages_aid", localp.dMz());
                paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.dMA());
                localObject1 = localp.dLV();
                if (localObject1 != null)
                {
                  localObject1 = ((TimeLineObject)localObject1).FQo.Etz;
                  if (((List)localObject1).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((btz)((List)localObject1).get(0)).Fjh);
                  }
                }
                paramAnonymousView.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (b.this.dbL == 2)
                {
                  i = 16;
                  paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                  paramAnonymousView.putExtra("sns_landing_pages_xml", localp.dME().field_adxml);
                  paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dMF());
                  paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                  localObject1 = b.this.activity;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)paramAnonymousView.lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  b.this.activity.overridePendingTransition(0, 0);
                  j = b.this.dbL;
                  if (b.this.dbL != 0) {
                    break label1771;
                  }
                }
                label1771:
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 21);
                  com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.yJJ, localp, 3);
                  com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                  AppMethodBeat.o(100258);
                  return;
                  if (b.this.dbL != 1) {
                    break;
                  }
                  i = 10;
                  break;
                }
              }
              if (!b.a(b.this, (com.tencent.mm.plugin.sns.storage.a)localObject1, localp, false)) {
                break label1869;
              }
              j = b.this.dbL;
              if (b.this.dbL == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 31);
                com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.yJJ, localp, 3);
                com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                AppMethodBeat.o(100258);
                return;
              }
              i = 2;
              break label878;
            }
          }
        }
      }
    };
    this.zgL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100259);
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          AppMethodBeat.o(100259);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        p localp = af.dHR().auT(paramAnonymousView);
        if (localp == null)
        {
          AppMethodBeat.o(100259);
          return;
        }
        if (localp.Pe(32))
        {
          ac.i("MicroMsg.TimelineClickListener", "click the ad poi button");
          localObject1 = b.a(b.this, localp);
          if (localObject1 == null)
          {
            ac.e("MicroMsg.TimelineClickListener", "the adInfo is null");
            AppMethodBeat.o(100259);
            return;
          }
          int j = b.this.dbL;
          if (b.this.dbL == 0) {}
          for (int i = 1;; i = 2)
          {
            localObject2 = new SnsAdClick(j, i, localp.field_snsId, 19, 0);
            com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, b.this.yJJ, localp, 19);
            com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
            if (!bs.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject1).yeH)) {
              break;
            }
            ac.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
            AppMethodBeat.o(100259);
            return;
          }
          if (b.this.dbL == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.d.ps(724);; paramAnonymousView = com.tencent.mm.modelsns.d.pt(724))
          {
            paramAnonymousView.Dn(com.tencent.mm.plugin.sns.data.q.l(localp)).pv(localp.field_type).eQ(localp.Pe(32)).Dn(localp.dMD()).Dn("").Dn("").Dn("").Dn("").Dn(((com.tencent.mm.plugin.sns.storage.a)localObject1).yeG).Dn("").Dn("");
            paramAnonymousView.aHZ();
            ac.i("MicroMsg.TimelineClickListener", "open webview url : " + ((com.tencent.mm.plugin.sns.storage.a)localObject1).yeH);
            paramAnonymousView = new Intent();
            if ((localp != null) && (localp.Pe(32)))
            {
              localObject3 = b.a(b.this, localp);
              if (localObject3 != null) {
                paramAnonymousView.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject3).dyy);
              }
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putParcelable("KSnsAdTag", (Parcelable)localObject2);
            paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject3);
            paramAnonymousView.putExtra("useJs", true);
            paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId));
            paramAnonymousView.putExtra("pre_username", localp.field_userName);
            paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId));
            paramAnonymousView.putExtra("preUsername", localp.field_userName);
            paramAnonymousView.putExtra("rawUrl", com.tencent.mm.plugin.sns.data.q.iV(((com.tencent.mm.plugin.sns.storage.a)localObject1).yeH, ((com.tencent.mm.plugin.sns.storage.a)localObject1).dtx));
            com.tencent.mm.plugin.sns.c.a.iyx.i(paramAnonymousView, b.this.activity);
            AppMethodBeat.o(100259);
            return;
          }
        }
        Object localObject2 = localp.dLV();
        Object localObject3 = ((TimeLineObject)localObject2).FQm;
        Object localObject1 = new Intent();
        if (b.this.dbL == 0) {}
        for (paramAnonymousView = com.tencent.mm.modelsns.d.ps(724);; paramAnonymousView = com.tencent.mm.modelsns.d.pt(724))
        {
          paramAnonymousView.Dn(com.tencent.mm.plugin.sns.data.q.l(localp)).pv(localp.field_type).eQ(localp.Pe(32)).Dn(localp.dMD()).Dn(((brd)localObject3).EFm).pv(((brd)localObject3).yAX).Dn(((brd)localObject3).Ehu).Dn(((brd)localObject3).Eht).Dn(((brd)localObject3).gPy).Dn(((brd)localObject3).yAV).Dn(((brd)localObject3).iJV);
          paramAnonymousView.aHZ();
          if (!bs.isNullOrNil(((brd)localObject3).EFm)) {
            break;
          }
          ((Intent)localObject1).putExtra("map_view_type", 7);
          ((Intent)localObject1).putExtra("kwebmap_slat", ((brd)localObject3).Ehu);
          ((Intent)localObject1).putExtra("kwebmap_lng", ((brd)localObject3).Eht);
          ((Intent)localObject1).putExtra("kPoiName", ((brd)localObject3).gPy);
          ((Intent)localObject1).putExtra("Kwebmap_locaion", ((brd)localObject3).yAV);
          com.tencent.mm.br.d.b(b.this.activity, "location", ".ui.RedirectUI", (Intent)localObject1);
          AppMethodBeat.o(100259);
          return;
        }
        if (b.this.zhb == 0) {}
        for (paramAnonymousView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[] { ((brd)localObject3).EFm });; paramAnonymousView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[] { ((brd)localObject3).EFm, ((TimeLineObject)localObject2).Id }))
        {
          ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
          com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject1, b.this.activity);
          AppMethodBeat.o(100259);
          return;
        }
      }
    };
    this.zgP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100260);
        if (!(paramAnonymousView.getTag() instanceof String))
        {
          AppMethodBeat.o(100260);
          return;
        }
        paramAnonymousView = (String)paramAnonymousView.getTag();
        paramAnonymousView = af.dHR().auT(paramAnonymousView);
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(100260);
          return;
        }
        if (paramAnonymousView.Pe(32))
        {
          ac.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
          paramAnonymousView = b.a(b.this, paramAnonymousView);
          if (paramAnonymousView == null)
          {
            ac.e("MicroMsg.TimelineClickListener", "the adInfo is null");
            AppMethodBeat.o(100260);
            return;
          }
          if (bs.isNullOrNil(paramAnonymousView.yeK))
          {
            ac.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
            AppMethodBeat.o(100260);
            return;
          }
          ac.i("MicroMsg.TimelineClickListener", "open webview url : " + paramAnonymousView.yeK);
          Intent localIntent = new Intent();
          localIntent.putExtra("jsapiargs", new Bundle());
          localIntent.putExtra("useJs", true);
          String str = com.tencent.mm.plugin.sns.data.q.iV(paramAnonymousView.yeK, paramAnonymousView.dtx);
          com.tencent.mm.plugin.sns.data.q.g(localIntent, paramAnonymousView.dtx);
          localIntent.putExtra("rawUrl", str);
          com.tencent.mm.plugin.sns.c.a.iyx.i(localIntent, b.this.activity);
          AppMethodBeat.o(100260);
          return;
        }
        AppMethodBeat.o(100260);
      }
    };
    this.zgQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100261);
        Object localObject;
        int j;
        if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          localObject = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).ddB;
          localObject = af.dHR().auT((String)localObject);
          if (localObject == null)
          {
            AppMethodBeat.o(100261);
            return;
          }
          if (((p)localObject).Pe(32))
          {
            ac.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
            j = b.this.dbL;
            if (b.this.dbL != 0) {
              break label139;
            }
          }
        }
        label139:
        for (int i = 1;; i = 2)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(j, i, ((p)localObject).field_snsId, 24, 0);
          com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, b.this.yJJ, (p)localObject, 24);
          com.tencent.mm.plugin.sns.data.q.a(localSnsAdClick);
          b.this.eM(paramAnonymousView);
          AppMethodBeat.o(100261);
          return;
        }
      }
    };
    this.zgq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        int m = 1;
        int k = 1;
        AppMethodBeat.i(100262);
        Object localObject2 = (String)paramAnonymousView.getTag();
        ac.d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(localObject2)));
        Object localObject3 = new Intent();
        Object localObject1;
        int j;
        int i;
        if (((paramAnonymousView instanceof MaskImageButton)) && (((MaskImageButton)paramAnonymousView).gMG != null))
        {
          paramAnonymousView = (String)((MaskImageButton)paramAnonymousView).gMG;
          localObject1 = af.dHR().auT(paramAnonymousView);
          if ((localObject1 != null) && (((p)localObject1).Pe(32)))
          {
            com.tencent.mm.plugin.sns.storage.b localb = ((p)localObject1).dFR();
            j = b.this.dbL;
            if (b.this.dbL == 0) {}
            for (i = 1;; i = 2)
            {
              paramAnonymousView = new SnsAdClick(j, i, ((p)localObject1).field_snsId, 1, 0);
              com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.yJJ, (p)localObject1, 1);
              com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
              if ((localb == null) || (localb.yfF != 1) || (bs.isNullOrNil(localb.yfG))) {
                break;
              }
              localObject2 = localb.yfG;
              localObject3 = b.a(b.this, (p)localObject1);
              paramAnonymousView = (View)localObject2;
              if (localObject3 != null) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iV((String)localObject2, ((com.tencent.mm.plugin.sns.storage.a)localObject3).dtx);
              }
              ac.i("MicroMsg.TimelineClickListener", "headClickParam url " + paramAnonymousView + " " + localb.yfH);
              localObject2 = new Intent();
              if (localb.yfH == 0) {
                bool = true;
              }
              ((Intent)localObject2).putExtra("KsnsViewId", b.a(b.this, (p)localObject1).dyy);
              ((Intent)localObject2).putExtra("KRightBtn", bool);
              ((Intent)localObject2).putExtra("jsapiargs", new Bundle());
              ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject2).putExtra("useJs", true);
              com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject2, b.this.activity);
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
            AppMethodBeat.o(100262);
            return;
          }
          if (paramAnonymousView != null)
          {
            if (b.this.dbL != 0) {
              break label615;
            }
            if (paramAnonymousView.Pe(32))
            {
              j = 722;
              localObject1 = com.tencent.mm.modelsns.d.ps(j);
              ((com.tencent.mm.modelsns.d)localObject1).Dn(com.tencent.mm.plugin.sns.data.q.l(paramAnonymousView)).pv(paramAnonymousView.field_type).eQ(paramAnonymousView.Pe(32)).Dn(paramAnonymousView.dMD()).Dn((String)localObject2);
              ((com.tencent.mm.modelsns.d)localObject1).aHZ();
            }
          }
          else
          {
            if (i == 0) {
              break label649;
            }
            j = b.this.dbL;
            if (b.this.dbL != 0) {
              break label644;
            }
          }
          label644:
          for (i = 1;; i = 2)
          {
            localObject1 = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 1, 0);
            com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject1, b.this.yJJ, paramAnonymousView, 1);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            ((Intent)localObject3).putExtra("KSnsAdTag", (Parcelable)localObject1);
            ((Intent)localObject3).putExtra("Contact_Scene", 78);
            i = k;
            if (b.this.dbL == 0) {
              i = 6;
            }
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            com.tencent.mm.plugin.sns.c.a.iyx.c((Intent)localObject3, b.this.activity);
            ac.i("MicroMsg.TimelineClickListener", "startContactInfo, addScene=78");
            AppMethodBeat.o(100262);
            return;
            j = 721;
            break;
            label615:
            if (paramAnonymousView.Pe(32)) {}
            for (j = 722;; j = 721)
            {
              localObject1 = com.tencent.mm.modelsns.d.pt(j);
              break;
            }
          }
          label649:
          b.this.yyv.dHw().a(paramAnonymousView, true);
          if (b.this.dbL == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.d.ps(746);; paramAnonymousView = com.tencent.mm.modelsns.d.pt(746))
          {
            localObject1 = u.axw();
            paramAnonymousView.Dn((String)localObject2).eQ(((String)localObject2).endsWith((String)localObject1));
            paramAnonymousView.b((Intent)localObject3, "intent_key_StatisticsOplog");
            i = m;
            if (b.this.dbL == 0) {
              i = 6;
            }
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            com.tencent.mm.plugin.sns.c.a.iyx.c((Intent)localObject3, b.this.activity);
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
    this.zgr = new b.2(this);
    this.zgs = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100203);
        paramAnonymousView = (com.tencent.mm.plugin.sns.ui.ba)paramAnonymousView.getTag();
        paramAnonymousContextMenuInfo = af.dHR().auS(paramAnonymousView.dnn);
        if (paramAnonymousContextMenuInfo == null)
        {
          AppMethodBeat.o(100203);
          return;
        }
        paramAnonymousContextMenu.add(0, 0, 0, b.this.activity.getString(2131755701));
        if (com.tencent.mm.br.d.aCT("favorite")) {
          paramAnonymousContextMenu.add(0, 1, 0, b.this.activity.getString(2131761941));
        }
        TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.dLV();
        if ((paramAnonymousView.yPG) || ((localTimeLineObject != null) && (localTimeLineObject.FQq != 1) && (!paramAnonymousView.yPH)))
        {
          if (paramAnonymousView.dQd()) {
            break label143;
          }
          aq.a(paramAnonymousContextMenu, true);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
          AppMethodBeat.o(100203);
          return;
          label143:
          aq.b(paramAnonymousContextMenu, true);
        }
      }
      
      public final boolean eZ(View paramAnonymousView)
      {
        AppMethodBeat.i(100204);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.ba))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.ba)paramAnonymousView.getTag();
          localObject = af.dHR().auS(((com.tencent.mm.plugin.sns.ui.ba)localObject).dnn);
          if (localObject == null)
          {
            AppMethodBeat.o(100204);
            return false;
          }
          String str = ((p)localObject).dMu();
          b.this.zgp.a(paramAnonymousView, str, ((p)localObject).dLV());
          AppMethodBeat.o(100204);
          return true;
        }
        AppMethodBeat.o(100204);
        return false;
      }
    };
    this.zgH = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100206);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof p)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.an)) || ((paramAnonymousContextMenuInfo instanceof aw)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.c.a.a))) {
          if ((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.h.auS(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).dnn);
          }
        }
        for (;;)
        {
          if (!paramAnonymousContextMenuInfo.Pe(32))
          {
            AppMethodBeat.o(100206);
            return;
            if ((paramAnonymousContextMenuInfo instanceof p))
            {
              paramAnonymousContextMenuInfo = (p)paramAnonymousContextMenuInfo;
              continue;
            }
            if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.an))
            {
              paramAnonymousContextMenuInfo = (com.tencent.mm.plugin.sns.ui.an)paramAnonymousContextMenuInfo;
              paramAnonymousContextMenuInfo = af.dHR().auT(paramAnonymousContextMenuInfo.ddB);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof aw))
            {
              paramAnonymousContextMenuInfo = ((aw)paramAnonymousView.getTag()).dgl;
              paramAnonymousContextMenuInfo = af.dHR().auT(paramAnonymousContextMenuInfo);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).xIq;
            }
          }
          else
          {
            if ((paramAnonymousContextMenuInfo.dFR() == null) || (!paramAnonymousContextMenuInfo.dFR().dJL()))
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (b.a(b.this, paramAnonymousContextMenuInfo).yeR != null)
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (com.tencent.mm.br.d.aCT("favorite"))
            {
              if (paramAnonymousContextMenuInfo.dFR().dJL()) {
                paramAnonymousContextMenu.add(0, 20, 0, paramAnonymousView.getContext().getString(2131761941));
              }
              dy localdy = new dy();
              localdy.ddK.ddB = paramAnonymousContextMenuInfo.dMu();
              com.tencent.mm.sdk.b.a.GpY.l(localdy);
              if (localdy.ddL.ddj) {
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
      
      public final boolean eZ(View paramAnonymousView)
      {
        AppMethodBeat.i(100205);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof p)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) || ((paramAnonymousView.getTag() instanceof aw)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.h.auS(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dnn);
          }
        }
        for (;;)
        {
          if (localObject != null)
          {
            if (!((p)localObject).Pe(32))
            {
              AppMethodBeat.o(100205);
              return false;
              if ((localObject instanceof p))
              {
                localObject = (p)localObject;
                continue;
              }
              if ((localObject instanceof com.tencent.mm.plugin.sns.ui.an))
              {
                localObject = (com.tencent.mm.plugin.sns.ui.an)localObject;
                localObject = af.dHR().auT(((com.tencent.mm.plugin.sns.ui.an)localObject).ddB);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof aw))
              {
                localObject = ((aw)paramAnonymousView.getTag()).dgl;
                localObject = af.dHR().auT((String)localObject);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                localObject = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).xIq;
              }
            }
            else
            {
              if ((((p)localObject).dFR() == null) || (!((p)localObject).dFR().dJL()))
              {
                AppMethodBeat.o(100205);
                return false;
              }
              b.this.zgp.a(paramAnonymousView, ((p)localObject).dMu(), ((p)localObject).dLV());
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
    this.zgI = new c()
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
          paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.h.auS(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).dnn);
        }
        for (;;)
        {
          Object localObject;
          com.tencent.mm.plugin.sns.storage.a locala;
          if (com.tencent.mm.br.d.aCT("favorite"))
          {
            localObject = paramAnonymousContextMenuInfo.dFR();
            locala = b.a(b.this, paramAnonymousContextMenuInfo);
            if (((com.tencent.mm.plugin.sns.storage.b)localObject).dJK())
            {
              if (!((com.tencent.mm.plugin.sns.storage.b)localObject).dJG()) {
                break label192;
              }
              paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
          for (;;)
          {
            localObject = new dy();
            ((dy)localObject).ddK.ddB = paramAnonymousContextMenuInfo.dMu();
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            if (((dy)localObject).ddL.ddj) {
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
            if (locala.yez == 0) {
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
          label222:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean eZ(View paramAnonymousView)
      {
        AppMethodBeat.i(100207);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof p)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.h.auS(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dnn);
          }
        }
        for (;;)
        {
          if (localObject != null) {
            b.this.zgp.a(paramAnonymousView, ((p)localObject).dMu(), ((p)localObject).dLV());
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
    this.zgE = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100209);
        if ((paramAnonymousView.getTag() instanceof s)) {
          b.this.zgJ.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
        }
        AppMethodBeat.o(100209);
      }
      
      public final boolean eZ(View paramAnonymousView)
      {
        AppMethodBeat.i(100210);
        if ((paramAnonymousView.getTag() instanceof s))
        {
          String str = ((s)paramAnonymousView.getTag()).ddB;
          p localp = af.dHR().auT(str);
          b.this.zgp.a(paramAnonymousView, str, localp.dLV());
          AppMethodBeat.o(100210);
          return true;
        }
        AppMethodBeat.o(100210);
        return false;
      }
    };
    this.zgD = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100211);
        int j;
        int i;
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof aw)))
        {
          paramAnonymousContextMenuInfo = ((aw)paramAnonymousView.getTag()).dgl;
          p localp = af.dHR().auT(paramAnonymousContextMenuInfo);
          if (com.tencent.mm.br.d.aCT("favorite"))
          {
            paramAnonymousContextMenu.add(0, 2, 0, b.this.activity.getString(2131761941));
            dy localdy = new dy();
            localdy.ddK.ddB = paramAnonymousContextMenuInfo;
            com.tencent.mm.sdk.b.a.GpY.l(localdy);
            if (localdy.ddL.ddj) {
              paramAnonymousContextMenu.add(0, 18, 0, b.this.activity.getString(2131755836));
            }
          }
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, localp);
          paramAnonymousContextMenu = paramAnonymousContextMenu.add(0, 21, 0, b.this.activity.getString(2131763809));
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
          AppMethodBeat.o(100211);
          return;
          label238:
          i = 0;
          j = 0;
        }
      }
      
      public final boolean eZ(View paramAnonymousView)
      {
        AppMethodBeat.i(100212);
        if ((paramAnonymousView.getTag() instanceof aw))
        {
          String str = ((aw)paramAnonymousView.getTag()).dgl;
          p localp = af.dHR().auT(str);
          b.this.zgp.a(paramAnonymousView, str, localp.dLV());
          AppMethodBeat.o(100212);
          return true;
        }
        AppMethodBeat.o(100212);
        return false;
      }
    };
    this.zgG = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100214);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if ((paramAnonymousContextMenuInfo instanceof aw)) {
          paramAnonymousContextMenuInfo = ((aw)paramAnonymousContextMenuInfo).dgl;
        }
        for (;;)
        {
          if (paramAnonymousContextMenuInfo != null)
          {
            paramAnonymousContextMenuInfo = af.dHR().auT(paramAnonymousContextMenuInfo);
            TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.dLV();
            if (com.tencent.mm.br.d.aCT("favorite")) {
              switch (localTimeLineObject.FQo.Ety)
              {
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            AppMethodBeat.o(100214);
            return;
            if (!(paramAnonymousContextMenuInfo instanceof s)) {
              break label158;
            }
            paramAnonymousContextMenuInfo = ((s)paramAnonymousContextMenuInfo).ddB;
            break;
            paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131761941));
          }
          label158:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean eZ(View paramAnonymousView)
      {
        AppMethodBeat.i(100213);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof aw)) {
          localObject = ((aw)localObject).dgl;
        }
        for (;;)
        {
          if (localObject != null)
          {
            p localp = af.dHR().auT((String)localObject);
            b.this.zgp.a(paramAnonymousView, (String)localObject, localp.dLV());
            AppMethodBeat.o(100213);
            return true;
            if ((localObject instanceof s)) {
              localObject = ((s)localObject).ddB;
            }
          }
          else
          {
            AppMethodBeat.o(100213);
            return false;
          }
          localObject = null;
        }
      }
    };
    this.yAf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100215);
        Object localObject1 = null;
        if ((paramAnonymousView.getTag() instanceof aw)) {
          localObject1 = ((aw)paramAnonymousView.getTag()).dgl;
        }
        Object localObject2;
        for (;;)
        {
          localObject2 = com.tencent.mm.plugin.sns.storage.h.auT((String)localObject1);
          if (localObject2 != null) {
            break;
          }
          ac.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(100215);
          return;
          if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).ddB;
          } else if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
            localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).xIq.dMu();
          }
        }
        if ((((p)localObject2).Pe(32)) && (((p)localObject2).dFR() != null) && ((((p)localObject2).dFR().dJL()) || (((p)localObject2).dFR().dJM())))
        {
          b.this.zgZ.onClick(paramAnonymousView);
          AppMethodBeat.o(100215);
          return;
        }
        if (((p)localObject2).dLV().FQo.Ety == 21)
        {
          if (u.axw().equals(((p)localObject2).field_userName))
          {
            ((p)localObject2).dLV();
            com.tencent.mm.plugin.sns.lucky.a.m.p((p)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.m.o((p)localObject2);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.lA(25);
          }
          if (!u.axw().equals(((p)localObject2).field_userName))
          {
            com.tencent.mm.plugin.sns.lucky.b.a.a(2, (p)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.b.lA(30);
          }
        }
        int i;
        Object localObject3;
        if (((p)localObject2).Pe(32))
        {
          b.a(b.this, (p)localObject2);
          if ((((p)localObject2).dFR().dJG()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(((p)localObject2).dME().field_adxml)))
          {
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.H((p)localObject2);
            if (!bs.isNullOrNil((String)localObject1)) {
              ((p)localObject2).dME().field_adxml = ((String)localObject1);
            }
            int j = b.this.dbL;
            if (b.this.dbL == 0)
            {
              i = 1;
              localObject1 = new SnsAdClick(j, i, ((p)localObject2).field_snsId, 21, 21);
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject1, b.this.yJJ, (p)localObject2, 21);
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
              ((Intent)localObject1).putExtra("sns_landing_pages_rawSnsId", ((p)localObject2).dLV().Id);
              ((Intent)localObject1).putExtra("sns_landing_pages_ux_info", ((p)localObject2).dMD());
              ((Intent)localObject1).putExtra("sns_landing_pages_aid", ((p)localObject2).dMz());
              ((Intent)localObject1).putExtra("sns_landing_pages_traceid", ((p)localObject2).dMA());
              localObject3 = ((p)localObject2).dLV();
              if (localObject3 != null)
              {
                localObject3 = ((TimeLineObject)localObject3).FQo.Etz;
                if (((List)localObject3).size() > 0)
                {
                  ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((btz)((List)localObject3).get(0)).Fjh);
                  ((Intent)localObject1).putExtra("sns_landing_pages_from_outer_index", ((aw)paramAnonymousView.getTag()).index);
                }
              }
              ((Intent)localObject1).setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
              if (b.this.dbL != 2) {
                break label971;
              }
              i = 16;
            }
          }
        }
        for (;;)
        {
          label639:
          ((Intent)localObject1).putExtra("sns_landig_pages_from_source", i);
          ((Intent)localObject1).putExtra("sns_landing_pages_xml", ((p)localObject2).dME().field_adxml);
          ((Intent)localObject1).putExtra("sns_landing_pages_rec_src", ((p)localObject2).dMF());
          ((Intent)localObject1).putExtra("sns_landing_pages_xml_prefix", "adxml");
          ((Intent)localObject1).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
          ((Intent)localObject1).putExtra("sns_landing_pages_is_normal_ad_animation", true);
          localObject3 = b.this.activity;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          b.this.activity.overridePendingTransition(0, 0);
          if (b.this.yyv != null) {
            b.this.yyv.dHw().D((p)localObject2);
          }
          label839:
          paramAnonymousView = (aw)paramAnonymousView.getTag();
          if ((paramAnonymousView.yIK) && (localObject2 != null))
          {
            com.tencent.mm.plugin.sns.ui.a.c.f((p)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.ui.a.c.g((p)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.model.az.auc(((p)localObject2).dMu());
          }
          if (localObject2 != null)
          {
            localObject1 = ((p)localObject2).dLV();
            if (localObject1 != null) {
              if (((TimeLineObject)localObject1).FQn != null) {
                break label1009;
              }
            }
          }
          label971:
          label1009:
          for (paramAnonymousView = null;; paramAnonymousView = ((TimeLineObject)localObject1).FQn.Id)
          {
            if (!bs.isNullOrNil(paramAnonymousView))
            {
              localObject2 = com.tencent.mm.plugin.sns.c.a.iyy.eB(paramAnonymousView);
              com.tencent.mm.plugin.sns.c.a.iyy.a(null, paramAnonymousView, (String)localObject2, ((TimeLineObject)localObject1).ncR, 2, 4, 4, ((TimeLineObject)localObject1).FQs, ((TimeLineObject)localObject1).Id);
            }
            AppMethodBeat.o(100215);
            return;
            i = 2;
            break;
            if (b.this.dbL != 1) {
              break label1021;
            }
            i = 2;
            break label639;
            b.this.dF(paramAnonymousView);
            break label839;
            b.this.dF(paramAnonymousView);
            break label839;
          }
          label1021:
          i = 1;
        }
      }
    };
    this.zgt = new b.10(this);
    this.zgu = new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(100218);
        com.tencent.mm.ui.base.h.b(b.this.activity, 2131764024, 2131755906, 2131755707, 2131755691, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(100217);
            if (!(paramAnonymousView.getTag() instanceof String))
            {
              AppMethodBeat.o(100217);
              return;
            }
            paramAnonymous2DialogInterface = (String)paramAnonymousView.getTag();
            ac.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymous2DialogInterface)));
            p localp = af.dHR().auT(paramAnonymous2DialogInterface);
            if (localp == null)
            {
              ac.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[] { paramAnonymous2DialogInterface });
              AppMethodBeat.o(100217);
              return;
            }
            Object localObject2;
            if (localp.dMw())
            {
              ac.i("MicroMsg.TimelineClickListener", "dead item");
              af.dHR().Pi(localp.yvp);
              if (b.this.zha != null) {
                b.this.zha.dQy();
              }
              if (b.this.dbL == 0)
              {
                localObject1 = com.tencent.mm.modelsns.d.ps(739);
                localObject2 = ((com.tencent.mm.modelsns.d)localObject1).Dn(com.tencent.mm.plugin.sns.data.q.l(localp)).pv(localp.field_type);
                if (!localp.dMw()) {
                  break label234;
                }
                paramAnonymous2DialogInterface = "2";
              }
              for (;;)
              {
                ((com.tencent.mm.modelsns.d)localObject2).Dn(paramAnonymous2DialogInterface);
                ((com.tencent.mm.modelsns.d)localObject1).aHZ();
                if (localp.field_type == 21) {
                  com.tencent.mm.plugin.sns.lucky.a.g.dGP().dGR();
                }
                AppMethodBeat.o(100217);
                return;
                localObject1 = com.tencent.mm.modelsns.d.pt(739);
                break;
                label234:
                if (localp.field_snsId == 0L) {
                  paramAnonymous2DialogInterface = "1";
                } else {
                  paramAnonymous2DialogInterface = "0";
                }
              }
            }
            if (localp.dHA())
            {
              ac.i("MicroMsg.TimelineClickListener", "cancel item " + localp.dMu());
              af.dHN().A(localp);
              if (bs.pN(localp.field_createTime) < ap.xVG) {
                af.dIb().u(localp);
              }
              b.this.dNn();
              AppMethodBeat.o(100217);
              return;
            }
            ac.i("MicroMsg.TimelineClickListener", "delete by server");
            paramAnonymous2DialogInterface = localp.getSnsId();
            af.dHQ().xo(x.asL(paramAnonymous2DialogInterface));
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.sns.model.q(x.asL(paramAnonymous2DialogInterface), 1), 0);
            if (bs.pN(localp.field_createTime) < ap.xVG) {
              af.dIb().u(localp);
            }
            af.dHR().delete(x.asL(paramAnonymous2DialogInterface));
            af.dHW().xF(x.asL(paramAnonymous2DialogInterface));
            com.tencent.mm.plugin.sns.storage.i.xE(x.asL(paramAnonymous2DialogInterface));
            b.this.dNn();
            Object localObject1 = localp.dLV();
            if (localObject1 != null)
            {
              if (((TimeLineObject)localObject1).FQn != null) {
                break label630;
              }
              paramAnonymous2DialogInterface = null;
              if ((!bs.isNullOrNil(paramAnonymous2DialogInterface)) && (com.tencent.mm.plugin.sns.c.a.iyy.eD(paramAnonymous2DialogInterface)))
              {
                localObject2 = com.tencent.mm.plugin.sns.c.a.iyy.eB(paramAnonymous2DialogInterface);
                qq localqq = new qq();
                localqq.dtB.appId = paramAnonymous2DialogInterface;
                localqq.dtB.dtD = ((TimeLineObject)localObject1).ncR;
                localqq.dtB.dtC = ((String)localObject2);
                localqq.dtB.mediaTagName = ((TimeLineObject)localObject1).FQs;
                com.tencent.mm.sdk.b.a.GpY.l(localqq);
              }
            }
            if (b.this.dbL == 0)
            {
              localObject1 = com.tencent.mm.modelsns.d.ps(739);
              label582:
              localObject2 = ((com.tencent.mm.modelsns.d)localObject1).Dn(com.tencent.mm.plugin.sns.data.q.l(localp)).pv(localp.field_type);
              if (!localp.dMw()) {
                break label651;
              }
              paramAnonymous2DialogInterface = "2";
            }
            for (;;)
            {
              ((com.tencent.mm.modelsns.d)localObject2).Dn(paramAnonymous2DialogInterface);
              ((com.tencent.mm.modelsns.d)localObject1).aHZ();
              AppMethodBeat.o(100217);
              return;
              label630:
              paramAnonymous2DialogInterface = ((TimeLineObject)localObject1).FQn.Id;
              break;
              localObject1 = com.tencent.mm.modelsns.d.pt(739);
              break label582;
              label651:
              if (localp.field_snsId == 0L) {
                paramAnonymous2DialogInterface = "1";
              } else {
                paramAnonymous2DialogInterface = "0";
              }
            }
          }
        }, null);
        AppMethodBeat.o(100218);
      }
    };
    this.zgv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100220);
        paramAnonymousView = (String)paramAnonymousView.getTag();
        ac.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymousView)));
        paramAnonymousView = af.dHR().auT(paramAnonymousView).dLV();
        com.tencent.mm.protocal.protobuf.ba localba = paramAnonymousView.xXR;
        if (localba.DNt == null)
        {
          AppMethodBeat.o(100220);
          return;
        }
        String str = com.tencent.mm.plugin.sns.c.a.iyy.eB(localba.DNt.hOf);
        int i = 0;
        if (paramAnonymousView.FQo.Ety == 1) {
          i = 2;
        }
        while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(paramAnonymousView, b.this.activity))
        {
          com.tencent.mm.plugin.sns.c.a.iyy.a(b.this.activity, localba.DNt.hOf, str, paramAnonymousView.ncR, i, 11, 9, localba.DNt.DNn, paramAnonymousView.Id);
          AppMethodBeat.o(100220);
          return;
          if (paramAnonymousView.FQo.Ety == 3) {
            i = 5;
          } else if (paramAnonymousView.FQo.Ety == 15) {
            i = 38;
          }
        }
        switch (localba.ndI)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(100220);
          return;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", localba.Url);
          com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject, b.this.activity);
          com.tencent.mm.plugin.sns.c.a.iyy.a(b.this.activity, localba.DNt.hOf, str, paramAnonymousView.ncR, i, 11, 1, localba.DNt.DNn, paramAnonymousView.Id);
          AppMethodBeat.o(100220);
          return;
          if (localba.Scene == 1)
          {
            localObject = new hv();
            ((hv)localObject).diT.actionCode = 2;
            ((hv)localObject).diT.scene = 3;
            ((hv)localObject).diT.appId = localba.DNt.hOf;
            ((hv)localObject).diT.context = b.this.activity;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            com.tencent.mm.plugin.sns.c.a.iyy.a(b.this.activity, localba.DNt.hOf, str, paramAnonymousView.ncR, i, 11, 6, localba.DNt.DNn, paramAnonymousView.Id);
            AppMethodBeat.o(100220);
            return;
            int j = com.tencent.mm.plugin.sns.ui.ai.a(b.this.activity, localba);
            if (j == 1)
            {
              localObject = new hv();
              ((hv)localObject).diT.context = b.this.activity;
              ((hv)localObject).diT.actionCode = 2;
              ((hv)localObject).diT.appId = localba.DNt.hOf;
              ((hv)localObject).diT.messageAction = localba.DNt.DNp;
              ((hv)localObject).diT.messageExt = localba.DNt.DNo;
              ((hv)localObject).diT.scene = 3;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
              com.tencent.mm.plugin.sns.c.a.iyy.a(b.this.activity, localba.DNt.hOf, str, paramAnonymousView.ncR, i, 11, 6, localba.DNt.DNn, paramAnonymousView.Id);
              AppMethodBeat.o(100220);
              return;
            }
            if (j == 2)
            {
              localObject = new hv();
              ((hv)localObject).diT.context = b.this.activity;
              ((hv)localObject).diT.actionCode = 1;
              ((hv)localObject).diT.appId = localba.DNt.hOf;
              ((hv)localObject).diT.messageAction = localba.DNt.DNp;
              ((hv)localObject).diT.messageExt = localba.DNt.DNo;
              ((hv)localObject).diT.scene = 3;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
              com.tencent.mm.plugin.sns.c.a.iyy.a(b.this.activity, localba.DNt.hOf, str, paramAnonymousView.ncR, i, 11, 3, localba.DNt.DNn, paramAnonymousView.Id);
            }
          }
        }
      }
    };
    this.zgB = new View.OnClickListener()
    {
      private static void avY(String paramAnonymousString)
      {
        AppMethodBeat.i(100222);
        long l = af.dHR().auT(paramAnonymousString).field_snsId;
        Object localObject1 = af.dHR().xK(l);
        if (localObject1 != null)
        {
          Object localObject2 = ((p)localObject1).dLV();
          if (localObject2 != null)
          {
            localObject2 = ((TimeLineObject)localObject2).FQo.Etz;
            if (((List)localObject2).size() > 0) {
              ((List)localObject2).get(0);
            }
          }
          localObject2 = aj.t((p)localObject1);
          localObject1 = new ArrayList();
          localObject2 = ((SnsObject)localObject2).SnsRedEnvelops.FKj;
          if (localObject2 != null)
          {
            int i = 0;
            while (i < ((List)localObject2).size())
            {
              daj localdaj = (daj)((List)localObject2).get(i);
              com.tencent.mm.plugin.l.a.a locala = new com.tencent.mm.plugin.l.a.a();
              locala.lhM = localdaj.Username;
              locala.ufS = localdaj.CreateTime;
              locala.ufT = localdaj.FJc;
              ((List)localObject1).add(locala);
              i += 1;
            }
          }
          com.tencent.mm.plugin.l.a.s(paramAnonymousString, (List)localObject1);
        }
        AppMethodBeat.o(100222);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100221);
        if ((paramAnonymousView.getTag() instanceof p))
        {
          paramAnonymousView = (p)paramAnonymousView.getTag();
          if ((paramAnonymousView.field_type == 21) && (u.axw().equals(paramAnonymousView.field_userName)))
          {
            paramAnonymousView.dLV();
            com.tencent.mm.plugin.sns.lucky.a.m.p(paramAnonymousView);
            com.tencent.mm.plugin.sns.lucky.a.m.o(paramAnonymousView);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.lA(24);
          }
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_sendid", paramAnonymousView.getSnsId());
          ((Intent)localObject2).putExtra("key_feedid", paramAnonymousView.dMu());
          ((Intent)localObject2).setClassName(b.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
          Object localObject1 = b.this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = paramAnonymousView.dMu();
          paramAnonymousView.getSnsId();
          avY((String)localObject1);
        }
        AppMethodBeat.o(100221);
      }
    };
    this.zgw = new b.15(this);
    this.zgx = new b.16(this);
    this.zgy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100225);
        if ((paramAnonymousView.getTag() instanceof String))
        {
          paramAnonymousView = (String)paramAnonymousView.getTag();
          ac.d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(paramAnonymousView)));
          aj.Or(x.avp(paramAnonymousView));
          aj.Op(x.avp(paramAnonymousView));
          af.dHN().dGr();
          b.this.dNn();
          if (b.this.zha != null) {
            b.this.zha.dQy();
          }
        }
        AppMethodBeat.o(100225);
      }
    };
    this.zgz = new b.18(this);
    this.zgC = new c()
    {
      private static boolean c(com.tencent.mm.plugin.sns.ui.m paramAnonymousm)
      {
        AppMethodBeat.i(100227);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousm != null)
        {
          bool1 = bool2;
          if (paramAnonymousm.xRC != null)
          {
            bool1 = bool2;
            if (!bs.gY(paramAnonymousm.xRC.FJe)) {
              bool1 = true;
            }
          }
        }
        AppMethodBeat.o(100227);
        return bool1;
      }
      
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100228);
        long l;
        int i;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          if (((!com.tencent.mm.plugin.sns.ui.widget.e.hJ(paramAnonymousView.xRC.FJd, 16)) || (paramAnonymousView.scene == 2)) && (!c(paramAnonymousView))) {
            paramAnonymousContextMenu.add(0, 11, 0, b.this.activity.getString(2131755701));
          }
          if ((paramAnonymousView.ncR != null) && (paramAnonymousView.ncR.equals(u.axw()))) {
            paramAnonymousContextMenu.add(0, 7, 0, b.this.activity.getString(2131755707));
          }
          if ((!com.tencent.mm.plugin.sns.ui.widget.e.hJ(paramAnonymousView.xRC.FJd, 16)) && (!c(paramAnonymousView)))
          {
            paramAnonymousContextMenuInfo = paramAnonymousView.yyH;
            StringBuilder localStringBuilder = new StringBuilder();
            if (paramAnonymousView.xRC.FIZ != 0)
            {
              l = paramAnonymousView.xRC.FIZ;
              paramAnonymousContextMenuInfo = aq.jd(paramAnonymousContextMenuInfo, l);
              if (paramAnonymousView.scene != 1) {
                break label265;
              }
              i = 2;
            }
          }
        }
        for (;;)
        {
          label201:
          paramAnonymousView = aq.atX(paramAnonymousContextMenuInfo);
          if ((paramAnonymousView != null) && (paramAnonymousView.hqq) && (!paramAnonymousView.aEZ) && ((i & paramAnonymousView.exP) != 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label285;
            }
            aq.a(paramAnonymousContextMenu, false);
            AppMethodBeat.o(100228);
            return;
            l = paramAnonymousView.xRC.FJb;
            break;
            label265:
            if (paramAnonymousView.scene != 2) {
              break label296;
            }
            i = 4;
            break label201;
          }
          label285:
          aq.b(paramAnonymousContextMenu, false);
          AppMethodBeat.o(100228);
          return;
          label296:
          i = -1;
        }
      }
      
      public final boolean eZ(View paramAnonymousView)
      {
        AppMethodBeat.i(100229);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject = af.dHR().auS(((com.tencent.mm.plugin.sns.ui.m)localObject).yyH);
          b.this.zgp.a(paramAnonymousView, ((p)localObject).dMu(), ((p)localObject).dLV());
          AppMethodBeat.o(100229);
          return true;
        }
        AppMethodBeat.o(100229);
        return false;
      }
    };
    this.sOi = new b.20(this);
    this.zgK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100231);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.ba))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.ba)paramAnonymousView.getTag();
          Object localObject = af.dHR().auS(paramAnonymousView.dnn);
          if (localObject == null)
          {
            AppMethodBeat.o(100231);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((p)localObject).dLV().FQl);
          paramAnonymousView.putExtra("sns_local_id", ((p)localObject).dMu());
          paramAnonymousView.setClass(b.this.activity, SnsSingleTextViewUI.class);
          localObject = b.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$28", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject).startActivity((Intent)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$28", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(100231);
      }
    };
    this.zgN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100232);
        s locals;
        Object localObject2;
        Object localObject1;
        Object localObject3;
        String str1;
        int i;
        if ((paramAnonymousView.getTag() instanceof s))
        {
          locals = (s)paramAnonymousView.getTag();
          localObject2 = (btz)locals.yyZ.FQo.Etz.get(0);
          localObject1 = locals.ddB;
          af.dHR().auS((String)localObject1);
          localObject1 = "";
          localObject3 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject2).Id);
          str1 = "";
          String str2 = com.tencent.mm.plugin.sns.data.q.i((btz)localObject2);
          if (com.tencent.mm.vfs.i.eA((String)localObject3 + str2))
          {
            localObject1 = (String)localObject3 + str2;
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.q.d((btz)localObject2);
          }
          if (com.tencent.mm.vfs.i.eA((String)localObject3 + com.tencent.mm.plugin.sns.data.q.o((btz)localObject2)))
          {
            localObject1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.q.o((btz)localObject2);
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.q.m((btz)localObject2);
          }
          localObject2 = new int[2];
          localObject3 = paramAnonymousView.findViewById(2131298769);
          if (localObject3 == null) {
            break label491;
          }
          ((View)localObject3).getLocationInWindow((int[])localObject2);
          i = ((View)localObject3).getWidth();
        }
        for (int j = ((View)localObject3).getHeight();; j = paramAnonymousView.getHeight())
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setClass(b.this.activity, SnsOnlineVideoActivity.class);
          paramAnonymousView.putExtra("intent_videopath", (String)localObject1);
          paramAnonymousView.putExtra("intent_thumbpath", str1);
          paramAnonymousView.putExtra("intent_localid", locals.ddB);
          paramAnonymousView.putExtra("intent_isad", false);
          paramAnonymousView.putExtra("intent_from_scene", b.this.dbL);
          paramAnonymousView.putExtra("img_gallery_left", localObject2[0]);
          paramAnonymousView.putExtra("img_gallery_top", localObject2[1]);
          paramAnonymousView.putExtra("img_gallery_width", i);
          paramAnonymousView.putExtra("img_gallery_height", j);
          localObject1 = b.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          b.this.activity.overridePendingTransition(0, 0);
          b.a(b.this, locals.yyZ);
          AppMethodBeat.o(100232);
          return;
          label491:
          paramAnonymousView.getLocationInWindow((int[])localObject2);
          i = paramAnonymousView.getWidth();
        }
      }
    };
    this.zgM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100239);
        ac.i("MicroMsg.TimelineClickListener", "onsight click");
        Object localObject1;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) {
          localObject1 = (com.tencent.mm.plugin.sns.ui.an)paramAnonymousView.getTag();
        }
        for (;;)
        {
          final p localp = af.dHR().auT(((com.tencent.mm.plugin.sns.ui.an)localObject1).ddB);
          if (localp == null)
          {
            ac.i("MicroMsg.TimelineClickListener", "onsight click but info is null localid %s", new Object[] { ((com.tencent.mm.plugin.sns.ui.an)localObject1).ddB });
            AppMethodBeat.o(100239);
            return;
            if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
            {
              localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).zbE;
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
              localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).zbE;
            }
          }
          else
          {
            if (b.this.yyv != null) {
              b.this.yyv.dHw().D(localp);
            }
            final boolean bool = localp.Pe(32);
            if ((bool) && (localp.dFR() != null) && ((localp.dFR().dJL()) || (localp.dFR().dJM())))
            {
              b.this.zgZ.onClick(paramAnonymousView);
              AppMethodBeat.o(100239);
              return;
            }
            final TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ui.an)localObject1).yFb;
            if ((localTimeLineObject.FQo.Etz == null) || (localTimeLineObject.FQo.Etz.size() == 0))
            {
              ac.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
              AppMethodBeat.o(100239);
              return;
            }
            final btz localbtz = (btz)localTimeLineObject.FQo.Etz.get(0);
            if (bool)
            {
              af.dHO();
              if (!com.tencent.mm.plugin.sns.model.f.t(localbtz))
              {
                ((com.tencent.mm.plugin.sns.ui.an)localObject1).yoI.setVisibility(8);
                ((com.tencent.mm.plugin.sns.ui.an)localObject1).yFg.setVisibility(0);
                ((com.tencent.mm.plugin.sns.ui.an)localObject1).yFg.fuE();
                af.dHO().z(localbtz);
                paramAnonymousView = af.dHM();
                localObject1 = bf.fbp();
                ((bf)localObject1).gIh = localTimeLineObject.CreateTime;
                paramAnonymousView.a(localbtz, 4, null, (bf)localObject1);
                if (bool) {
                  com.tencent.mm.plugin.sns.ad.d.m.a(m.b.xKC, m.a.xKt, localp, b.this.dbL);
                }
                AppMethodBeat.o(100239);
                return;
              }
            }
            if ((localp.Pe(32)) && (localp.dFR().dJG()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(localp.dME().field_adxml))) {}
            int j;
            Object localObject3;
            for (int i = 1; (i == 0) && (bool) && (af.dHO().u(localbtz)); i = 0)
            {
              af.dHO().z(localbtz);
              ((com.tencent.mm.plugin.sns.ui.an)localObject1).yoI.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.an)localObject1).yFg.setVisibility(8);
              paramAnonymousView = af.dHO();
              localObject2 = ((com.tencent.mm.plugin.sns.ui.an)localObject1).yFd;
              i = b.this.activity.hashCode();
              j = ((com.tencent.mm.plugin.sns.ui.an)localObject1).position;
              localObject3 = bf.fbp();
              ((bf)localObject3).gIh = localTimeLineObject.CreateTime;
              paramAnonymousView.a(localp, localbtz, (VideoSightView)localObject2, i, j, (bf)localObject3, bool);
              ((com.tencent.mm.plugin.sns.ui.an)localObject1).yFd.start();
              if (bool) {
                com.tencent.mm.plugin.sns.ad.d.m.a(m.b.xKC, m.a.xKt, localp, b.this.dbL);
              }
              AppMethodBeat.o(100239);
              return;
            }
            com.tencent.mm.modelsns.d locald;
            label662:
            int m;
            label717:
            label738:
            int k;
            if (b.this.dbL == 0)
            {
              localObject2 = com.tencent.mm.modelsns.d.ps(717);
              ((com.tencent.mm.modelsns.d)localObject2).Dn(com.tencent.mm.plugin.sns.data.q.l(localp)).pv(localp.field_type).eQ(localp.Pe(32)).Dn(localp.dMD()).Dn(localbtz.Id);
              ((com.tencent.mm.modelsns.d)localObject2).aHZ();
              if (b.this.dbL != 0) {
                break label1448;
              }
              locald = com.tencent.mm.modelsns.d.ps(745);
              locald.Dn(com.tencent.mm.plugin.sns.data.q.l(localp)).pv(localp.field_type).eQ(localp.Pe(32));
              if (bool)
              {
                m = b.this.dbL;
                if (b.this.dbL != 0) {
                  break label1459;
                }
                i = 1;
                long l = localp.field_snsId;
                if (!localp.dFR().dJG()) {
                  break label1464;
                }
                j = 21;
                if (!localp.dFR().dJG()) {
                  break label1470;
                }
                k = 21;
                label753:
                localObject2 = new SnsAdClick(m, i, l, j, k);
                if (!localp.dFR().dJG()) {
                  break label1476;
                }
                com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, b.this.yJJ, localp, 21);
              }
            }
            Object localObject4;
            for (;;)
            {
              com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
              if ((!localp.dFR().dJG()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(localp.dME().field_adxml))) {
                com.tencent.mm.plugin.sns.ad.d.m.a(m.b.xKC, m.a.xKu, localp, b.this.dbL);
              }
              localObject2 = "";
              localObject4 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), localbtz.Id);
              localObject3 = "";
              String str = com.tencent.mm.plugin.sns.data.q.i(localbtz);
              if (com.tencent.mm.vfs.i.eA((String)localObject4 + str))
              {
                localObject2 = (String)localObject4 + str;
                localObject3 = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.d(localbtz);
              }
              if (com.tencent.mm.vfs.i.eA((String)localObject4 + com.tencent.mm.plugin.sns.data.q.o(localbtz)))
              {
                localObject2 = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.o(localbtz);
                localObject3 = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.m(localbtz);
              }
              localObject4 = new int[2];
              paramAnonymousView.getLocationInWindow((int[])localObject4);
              i = paramAnonymousView.getWidth();
              j = paramAnonymousView.getHeight();
              com.tencent.mm.plugin.report.service.h.wUl.f(11444, new Object[] { Integer.valueOf(3) });
              if (bool) {
                break label1495;
              }
              ac.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
              paramAnonymousView = new Intent();
              paramAnonymousView.setClass(b.this.activity, SnsOnlineVideoActivity.class);
              paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
              paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
              paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.an)localObject1).ddB);
              paramAnonymousView.putExtra("intent_isad", bool);
              paramAnonymousView.putExtra("intent_from_scene", b.this.dbL);
              paramAnonymousView.putExtra("sns_video_scene", ((com.tencent.mm.plugin.sns.ui.an)localObject1).yFi);
              localObject2 = com.tencent.mm.plugin.sns.ui.video.d.dSq().awc(localTimeLineObject.Id);
              if ((localObject2 != null) && (((SnsTimelineVideoView)localObject2).isPlaying()))
              {
                paramAnonymousView.putExtra("intent_fromplayingvideo", true);
                paramAnonymousView.putExtra("intent_fromplayingvideo_tlobjid", localTimeLineObject.Id);
                paramAnonymousView.putExtra("intent_session_id", ((SnsTimelineVideoView)localObject2).getSessionId());
                paramAnonymousView.putExtra("intent_session_timestamp", ((SnsTimelineVideoView)localObject2).getSessionTimestamp());
                if (((com.tencent.mm.plugin.sns.ui.an)localObject1).yFc != null) {
                  ((com.tencent.mm.plugin.sns.ui.an)localObject1).yFc.findViewById(2131305799).setVisibility(0);
                }
              }
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              locald.b(paramAnonymousView, "intent_key_StatisticsOplog");
              localObject1 = b.this.activity;
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Activity)localObject1).startActivity((Intent)paramAnonymousView.lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              b.this.activity.overridePendingTransition(0, 0);
              b.a(b.this, localp.dLV());
              AppMethodBeat.o(100239);
              return;
              localObject2 = com.tencent.mm.modelsns.d.pt(717);
              break;
              label1448:
              locald = com.tencent.mm.modelsns.d.pt(745);
              break label662;
              label1459:
              i = 2;
              break label717;
              label1464:
              j = 17;
              break label738;
              label1470:
              k = 0;
              break label753;
              label1476:
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, b.this.yJJ, localp, 17);
            }
            label1495:
            if ((localp.Pe(32)) && (localp.dFR().dJG()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.auO(localp.dME().field_adxml)))
            {
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.H(localp);
              if (!bs.isNullOrNil(paramAnonymousView)) {
                localp.dME().field_adxml = paramAnonymousView;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
              paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dLV().Id);
              paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dMD());
              localObject1 = localp.dLV();
              if (localObject1 != null)
              {
                localObject1 = ((TimeLineObject)localObject1).FQo.Etz;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((btz)((List)localObject1).get(0)).Fjh);
                }
              }
              paramAnonymousView.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
              i = 1;
              if (b.this.dbL == 2) {
                i = 16;
              }
              for (;;)
              {
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", localp.dME().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dMF());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                paramAnonymousView.putExtra("sns_landing_pages_is_normal_ad_animation", true);
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject1 = b.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                b.this.activity.overridePendingTransition(0, 0);
                AppMethodBeat.o(100239);
                return;
                if (b.this.dbL == 1) {
                  i = 2;
                }
              }
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(b.this.activity, SnsSightPlayerUI.class);
            paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
            paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
            paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.an)localObject1).ddB);
            paramAnonymousView.putExtra("intent_isad", bool);
            paramAnonymousView.putExtra("intent_from_scene", b.this.dbL);
            paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
            paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
            paramAnonymousView.putExtra("img_gallery_width", i);
            paramAnonymousView.putExtra("img_gallery_height", j);
            locald.b(paramAnonymousView, "intent_key_StatisticsOplog");
            Object localObject2 = b.this.activity;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramAnonymousView.aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject2).startActivity((Intent)paramAnonymousView.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            b.this.activity.overridePendingTransition(0, 0);
            new ao().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100238);
                if (af.dHO().u(localbtz))
                {
                  this.zhn.yFd.e(null, false, 0);
                  com.tencent.mm.plugin.sns.model.f localf = af.dHO();
                  p localp = localp;
                  btz localbtz = localbtz;
                  VideoSightView localVideoSightView = this.zhn.yFd;
                  int i = b.this.activity.hashCode();
                  int j = this.zhn.position;
                  bf localbf = bf.fbp();
                  localbf.gIh = localTimeLineObject.CreateTime;
                  localf.a(localp, localbtz, localVideoSightView, i, j, localbf, bool);
                  this.zhn.yFd.start();
                  this.zhn.yoI.setVisibility(0);
                  this.zhn.yFg.setVisibility(8);
                  this.zhn.yoI.setImageDrawable(com.tencent.mm.cc.a.l(b.this.activity, 2131691166));
                }
                AppMethodBeat.o(100238);
              }
            }, 500L);
            paramAnonymousView = new int[3];
            if ((!bool) && (af.dHO().a(localp, paramAnonymousView) > 5))
            {
              af.dHO().y(localbtz);
              i = 1;
            }
            label2822:
            for (;;)
            {
              int n = paramAnonymousView[0];
              int i1 = paramAnonymousView[1];
              if (i == 2) {}
              for (m = 1;; m = 0)
              {
                int i2 = paramAnonymousView[2];
                paramAnonymousView = localp.dLV();
                localObject1 = new com.tencent.mm.modelsns.f();
                ((com.tencent.mm.modelsns.f)localObject1).n("20FeedId", paramAnonymousView.Id + ",");
                ((com.tencent.mm.modelsns.f)localObject1).n("21AdUxInfo", localp.dMD() + ",");
                for (;;)
                {
                  try
                  {
                    paramAnonymousView = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
                    if (paramAnonymousView.ObjectOperations == null) {
                      continue;
                    }
                    paramAnonymousView = (dau)new dau().parseFrom(paramAnonymousView.ObjectOperations.getBufferToBytes());
                    if (paramAnonymousView.FJT == null) {
                      continue;
                    }
                    k = paramAnonymousView.FJT.EuN;
                  }
                  catch (Exception paramAnonymousView)
                  {
                    k = 0;
                    ac.printErrStackTrace("MicroMsg.TimelineClickListener", paramAnonymousView, "", new Object[0]);
                    j = 0;
                    continue;
                    if (ax.is2G(com.tencent.mm.sdk.platformtools.ai.getContext()))
                    {
                      i = 2;
                      continue;
                    }
                    if (ax.is3G(com.tencent.mm.sdk.platformtools.ai.getContext()))
                    {
                      i = 3;
                      continue;
                    }
                    if (!ax.is4G(com.tencent.mm.sdk.platformtools.ai.getContext())) {
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
                    j = paramAnonymousView.FJT.EuO;
                    ((com.tencent.mm.modelsns.f)localObject1).n("22LayerId", k + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).n("23ExpId", j + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).n("24ClickState", i + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).n("25ClickTime", bs.aNx() + ",");
                    i = 0;
                    if (!ax.isWifi(com.tencent.mm.sdk.platformtools.ai.getContext())) {
                      continue;
                    }
                    i = 1;
                    ((com.tencent.mm.modelsns.f)localObject1).n("26NetworkType", i + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).n("27IsFlowControl", n + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).n("28AutoDownloadSetting", i1 + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).n("29IsAutoPlay", m + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).n("30IsFlowControlDatePeriod", i2 + ",");
                    ac.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + ((com.tencent.mm.modelsns.f)localObject1).PS());
                    com.tencent.mm.plugin.report.service.h.wUl.f(13323, new Object[] { localObject1 });
                    AppMethodBeat.o(100239);
                    return;
                  }
                  catch (Exception paramAnonymousView) {}
                }
                if ((!bool) || (af.dHO().b(localp, paramAnonymousView) <= 5)) {
                  break label2822;
                }
                af.dHO().y(localbtz);
                i = 1;
                break;
              }
            }
          }
          localObject1 = null;
        }
      }
    };
    this.zgF = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100240);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.an)paramAnonymousView.getTag();
          if (!paramAnonymousView.isAd) {
            paramAnonymousContextMenu.add(0, 19, 0, b.this.activity.getString(2131757227));
          }
          if (bs.aLy(com.tencent.mm.m.g.ZY().getValue("SIGHTCannotTransmitForFav")) != 0) {
            break label308;
          }
          if (paramAnonymousView.yFb.FQo.Etz.size() <= 0) {
            break label301;
          }
          paramAnonymousContextMenuInfo = (btz)paramAnonymousView.yFb.FQo.Etz.get(0);
          String str = paramAnonymousContextMenuInfo.Id;
          str = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), str) + com.tencent.mm.plugin.sns.data.q.d(paramAnonymousContextMenuInfo);
          paramAnonymousContextMenuInfo = au.a(paramAnonymousView.ddB, paramAnonymousContextMenuInfo);
          boolean bool1 = com.tencent.mm.vfs.i.eA(str);
          boolean bool2 = com.tencent.mm.vfs.i.eA(paramAnonymousContextMenuInfo);
          ac.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool1) || (!bool2)) {
            break label308;
          }
        }
        label301:
        label308:
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.br.d.aCT("favorite")) {
            paramAnonymousContextMenu.add(0, 10, 0, b.this.activity.getString(2131761941));
          }
          if (i != 0)
          {
            paramAnonymousContextMenuInfo = new dy();
            paramAnonymousContextMenuInfo.ddK.ddB = paramAnonymousView.ddB;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousContextMenuInfo);
            if (paramAnonymousContextMenuInfo.ddL.ddj) {
              paramAnonymousContextMenu.add(0, 18, 0, b.this.activity.getString(2131755836));
            }
          }
          AppMethodBeat.o(100240);
          return;
          ac.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
        }
      }
      
      public final boolean eZ(View paramAnonymousView)
      {
        AppMethodBeat.i(100241);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.an)paramAnonymousView.getTag()).ddB;
          p localp = af.dHR().auT(str);
          b.this.zgp.a(paramAnonymousView, str, localp.dLV());
          AppMethodBeat.o(100241);
          return true;
        }
        AppMethodBeat.o(100241);
        return false;
      }
    };
    this.zgO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100242);
        b.this.eP(paramAnonymousView);
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
        {
          AppMethodBeat.o(100242);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
        paramAnonymousView = af.dHR().auT(((com.tencent.mm.plugin.sns.data.b)localObject).ddB);
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(100242);
          return;
        }
        int j;
        if (paramAnonymousView.Pe(32))
        {
          ((com.tencent.mm.plugin.sns.data.b)localObject).xMz = System.currentTimeMillis();
          j = b.this.dbL;
          if (b.this.dbL != 0) {
            break label148;
          }
        }
        label148:
        for (int i = 1;; i = 2)
        {
          localObject = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 20, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject, b.this.yJJ, paramAnonymousView, 20);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject);
          AppMethodBeat.o(100242);
          return;
        }
      }
    };
    this.zgV = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100243);
        ac.i("MicroMsg.TimelineClickListener", "unlike click");
        if (!(paramAnonymousAdapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c))
        {
          ac.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
          AppMethodBeat.o(100243);
          return;
        }
        Object localObject2 = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
        p localp = af.dHR().auT(((com.tencent.mm.plugin.sns.data.b)localObject2).ddB);
        if (localp == null) {
          try
          {
            b.this.dNp();
            AppMethodBeat.o(100243);
            return;
          }
          catch (Exception paramAnonymousAdapterView)
          {
            ac.e("MicroMsg.TimelineClickListener", "onUnLikeFinishError exp=" + paramAnonymousAdapterView.toString());
            AppMethodBeat.o(100243);
            return;
          }
        }
        Object localObject1;
        if (paramAnonymousInt == 0)
        {
          if (localp.Pe(32))
          {
            localObject1 = b.a(b.this, localp);
            if (localObject1 != null) {
              break label312;
            }
          }
          label312:
          for (localObject1 = "";; localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).dyy)
          {
            ((com.tencent.mm.plugin.sns.b.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.b.d.class)).a(11855, localp.dMF(), new Object[] { Integer.valueOf(3), localObject1, Integer.valueOf(localp.dMF()) });
            if (!((com.tencent.mm.plugin.sns.data.b)localObject2).xMy.yYh.yeS.dJE()) {
              break;
            }
            paramAnonymousView = (com.tencent.mm.plugin.sns.ui.c)paramAnonymousAdapterView.getAdapter();
            paramAnonymousView.kar += 1;
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousAdapterView.setOnItemClickListener(b.this.zgW);
            b.this.dNo();
            paramAnonymousAdapterView = new a.c.a();
            paramAnonymousAdapterView.yfn = a.c.a.yfj;
            paramAnonymousAdapterView.xMz = ((com.tencent.mm.plugin.sns.data.b)localObject2).xMz;
            paramAnonymousAdapterView.yfo = 0L;
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.q(localp.field_snsId, 8, paramAnonymousAdapterView);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousAdapterView, 0);
            AppMethodBeat.o(100243);
            return;
          }
          if (((com.tencent.mm.plugin.sns.data.b)localObject2).xMy.yYh.yeW)
          {
            AppMethodBeat.o(100243);
            return;
          }
          b.this.eQ(paramAnonymousView);
          paramAnonymousAdapterView = new a.c.a();
          paramAnonymousAdapterView.xMz = ((com.tencent.mm.plugin.sns.data.b)localObject2).xMz;
          paramAnonymousAdapterView.yfo = System.currentTimeMillis();
          paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.q(localp.field_snsId, 8, paramAnonymousAdapterView);
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousAdapterView, 0);
          AppMethodBeat.o(100243);
          return;
        }
        if (((com.tencent.mm.plugin.sns.data.b)localObject2).xMy.yYg.ygp == null)
        {
          ac.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
          AppMethodBeat.o(100243);
          return;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.plugin.sns.data.b)localObject2).xMy.yYg.ygp;
        paramAnonymousInt -= 1;
        if (paramAnonymousInt < paramAnonymousAdapterView.list.size()) {
          paramAnonymousAdapterView = ((b.f)paramAnonymousAdapterView.list.get(paramAnonymousInt)).url;
        }
        try
        {
          paramAnonymousView = String.format("snsid=%s", new Object[] { localp.dLV().Id });
          localObject1 = String.format("aid=%s", new Object[] { localp.dMz() });
          localObject2 = String.format("traceid=%s", new Object[] { localp.dMA() });
          com.tencent.mm.kernel.g.agP();
          paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.n(paramAnonymousAdapterView, new String[] { paramAnonymousView, localObject1, localObject2, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.afE() }) });
          paramAnonymousAdapterView = paramAnonymousView;
        }
        catch (Exception paramAnonymousView)
        {
          label595:
          break label595;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", paramAnonymousAdapterView);
        paramAnonymousView.putExtra("useJs", true);
        paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId));
        paramAnonymousView.putExtra("pre_username", localp.field_userName);
        paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(localp.field_snsId));
        paramAnonymousView.putExtra("preUsername", localp.field_userName);
        com.tencent.mm.plugin.sns.c.a.iyx.i(paramAnonymousView, b.this.activity);
        AppMethodBeat.o(100243);
      }
    };
    this.zgW = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100244);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
        {
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
          if (paramAnonymousInt < paramAnonymousAdapterView.xMy.yYh.yeS.dJD().size())
          {
            if (paramAnonymousAdapterView.xMy.yYh.yeW)
            {
              AppMethodBeat.o(100244);
              return;
            }
            a.c.a locala = (a.c.a)paramAnonymousAdapterView.xMy.yYh.yeS.dJD().get(paramAnonymousInt);
            ac.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[] { locala.yfk, Integer.valueOf(locala.yfn) });
            p localp = af.dHR().auT(paramAnonymousAdapterView.ddB);
            if (localp == null)
            {
              AppMethodBeat.o(100244);
              return;
            }
            b.this.eQ(paramAnonymousView);
            locala.xMz = paramAnonymousAdapterView.xMz;
            locala.yfo = System.currentTimeMillis();
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.q(localp.field_snsId, 8, locala);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(paramAnonymousAdapterView, 0);
          }
        }
        AppMethodBeat.o(100244);
      }
    };
    this.zgU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100245);
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          TimeLineObject localTimeLineObject = (TimeLineObject)paramAnonymousView.getTag();
          anx localanx = localTimeLineObject.FQo.EtD;
          Intent localIntent = new Intent();
          localIntent.putExtra("feed_object_id", com.tencent.mm.plugin.sns.data.q.atd(localanx.objectId));
          localIntent.putExtra("feed_object_nonceId", localanx.objectNonceId);
          localIntent.putExtra("report_scene", 3);
          localIntent.putExtra("from_user", localTimeLineObject.ncR);
          ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).enterFinderShareFeedUI(paramAnonymousView.getContext(), localIntent);
        }
        AppMethodBeat.o(100245);
      }
    };
    this.zgZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163130);
        if ((paramAnonymousView.getTag() == null) || ((!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) && (!(paramAnonymousView.getTag() instanceof aw)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) && (!(paramAnonymousView.getTag() instanceof MaskImageView)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))))
        {
          AppMethodBeat.o(163130);
          return;
        }
        Object localObject1 = null;
        int m = 0;
        int j = 0;
        int n = 0;
        int k = 0;
        int i = 0;
        Object localObject3;
        if ((paramAnonymousView.getTag() instanceof aw))
        {
          localObject3 = com.tencent.mm.plugin.sns.storage.h.auT(((aw)paramAnonymousView.getTag()).dgl);
          if ((paramAnonymousView instanceof LinearLayout))
          {
            i = 0;
            if (!((aw)paramAnonymousView.getTag()).yFj) {
              break label4585;
            }
            k = ((aw)paramAnonymousView.getTag()).index;
            if (k <= 0) {
              break label184;
            }
            j = 2;
          }
        }
        for (;;)
        {
          m = i;
          i = j;
          j = m;
          if ((localObject3 == null) || (!((p)localObject3).Pe(32)))
          {
            AppMethodBeat.o(163130);
            return;
            i = 1;
            break;
            label184:
            j = 1;
            continue;
            if ((paramAnonymousView.getTag() instanceof MaskImageView))
            {
              localObject3 = (MaskImageView)paramAnonymousView.getTag();
              if (!(((MaskImageView)localObject3).getTag() instanceof aw)) {
                break label4580;
              }
              localObject3 = com.tencent.mm.plugin.sns.storage.h.auT(((aw)((MaskImageView)localObject3).getTag()).dgl);
              localObject1 = localObject3;
              j = n;
              if ((paramAnonymousView instanceof LinearLayout)) {
                break label404;
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
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an))
            {
              localObject1 = (com.tencent.mm.plugin.sns.ui.an)paramAnonymousView.getTag();
              localObject3 = af.dHR().auT(((com.tencent.mm.plugin.sns.ui.an)localObject1).ddB);
              if ((paramAnonymousView instanceof LinearLayout))
              {
                j = 0;
                label314:
                if (!((com.tencent.mm.plugin.sns.ui.an)localObject1).yFj) {
                  break label4571;
                }
                k = ((com.tencent.mm.plugin.sns.ui.an)localObject1).yFk;
                if (k <= 0) {
                  break label344;
                }
                i = 2;
              }
            }
            for (;;)
            {
              break;
              j = 1;
              break label314;
              label344:
              i = 1;
              continue;
              if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
              {
                localObject3 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                localObject1 = com.tencent.mm.plugin.sns.storage.h.auS(((BaseTimeLineItem.BaseViewHolder)localObject3).dnn);
                if (!(localObject3 instanceof k.b)) {
                  break label4566;
                }
                j = ((k.b)localObject3).zfJ.index;
                if (j > 0) {
                  i = 2;
                }
              }
              for (;;)
              {
                label404:
                k = j;
                j = 0;
                localObject3 = localObject1;
                break;
                i = 1;
                continue;
                if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))
                {
                  localObject3 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).xIq;
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
                        localObject1 = b.a(b.this, (p)localObject3);
                        if (localObject1 != null) {
                          continue;
                        }
                        localObject1 = "";
                        localObject4 = ((p)localObject3).dLV().Id;
                        if (!((p)localObject3).dJU())
                        {
                          localObject5 = com.tencent.mm.plugin.report.service.h.wUl;
                          if (b.this.dbL != 0) {
                            continue;
                          }
                          m = 1;
                          if (j == 0) {
                            continue;
                          }
                          j = 1;
                          ((com.tencent.mm.plugin.report.service.h)localObject5).f(14066, new Object[] { Integer.valueOf(m), Integer.valueOf(j), localObject4, localObject1 });
                        }
                      }
                      catch (Exception localException)
                      {
                        ac.e("MicroMsg.TimelineClickListener", "report click ad card style error " + localException.getMessage());
                        continue;
                        localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject4).zbE;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).zbE;
                        continue;
                        if (b.this.yyv == null) {
                          continue;
                        }
                        b.this.yyv.dHw().D((p)localObject3);
                        boolean bool = ((p)localObject3).Pe(32);
                        if ((((TimeLineObject)localObject6).FQo.Etz != null) && (((TimeLineObject)localObject6).FQo.Etz.size() != 0)) {
                          continue;
                        }
                        ac.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                        AppMethodBeat.o(163130);
                        return;
                        btz localbtz = (btz)((TimeLineObject)localObject6).FQo.Etz.get(k);
                        if (!bool) {
                          continue;
                        }
                        af.dHO();
                        if ((com.tencent.mm.plugin.sns.model.f.t(localbtz)) || (localObject2 == null)) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).yoI.setVisibility(8);
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFg.setVisibility(0);
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFg.fuE();
                        af.dHO().z(localbtz);
                        paramAnonymousView = af.dHM();
                        localObject2 = bf.fbp();
                        ((bf)localObject2).gIh = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a(localbtz, 4, null, (bf)localObject2);
                        if (!bool) {
                          continue;
                        }
                        com.tencent.mm.plugin.sns.ad.d.m.a(m.b.xKC, m.a.xKt, (p)localObject3, b.this.dbL);
                        AppMethodBeat.o(163130);
                        return;
                        if ((!((p)localObject3).Pe(32)) || (!((p)localObject3).dFR().dJG())) {
                          continue;
                        }
                        String str = ((p)localObject3).dME().field_adxml;
                        if (k <= 0) {
                          continue;
                        }
                        Object localObject5 = "adTurnCanvasInfo";
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jz(str, (String)localObject5)) {
                          continue;
                        }
                        m = 1;
                        if ((m != 0) || (!bool) || (!af.dHO().u(localbtz)) || (localObject2 == null)) {
                          continue;
                        }
                        af.dHO().z(localbtz);
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).yoI.setVisibility(8);
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFg.setVisibility(8);
                        paramAnonymousView = af.dHO();
                        Object localObject4 = ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFd;
                        i = b.this.activity.hashCode();
                        j = ((com.tencent.mm.plugin.sns.ui.an)localObject2).position;
                        localObject5 = bf.fbp();
                        ((bf)localObject5).gIh = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a((p)localObject3, localbtz, (VideoSightView)localObject4, i, j, (bf)localObject5, bool);
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).yFd.start();
                        if (!bool) {
                          continue;
                        }
                        com.tencent.mm.plugin.sns.ad.d.m.a(m.b.xKC, m.a.xKt, (p)localObject3, b.this.dbL);
                        AppMethodBeat.o(163130);
                        return;
                        localObject5 = "adCanvasInfo";
                        continue;
                        m = 0;
                        continue;
                        if (b.this.dbL != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.d.ps(717);
                        ((com.tencent.mm.modelsns.d)localObject2).Dn(com.tencent.mm.plugin.sns.data.q.l((p)localObject3)).pv(((p)localObject3).field_type).eQ(((p)localObject3).Pe(32)).Dn(((p)localObject3).dMD()).Dn(localbtz.Id);
                        ((com.tencent.mm.modelsns.d)localObject2).aHZ();
                        if (b.this.dbL != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.d.ps(745);
                        ((com.tencent.mm.modelsns.d)localObject2).Dn(com.tencent.mm.plugin.sns.data.q.l((p)localObject3)).pv(((p)localObject3).field_type).eQ(((p)localObject3).Pe(32));
                        localObject2 = new int[2];
                        if (localObject4 == null) {
                          continue;
                        }
                        if (((BaseTimeLineItem.BaseViewHolder)localObject4).zbE.yFf == null) {
                          continue;
                        }
                        ((BaseTimeLineItem.BaseViewHolder)localObject4).zbE.yFf.getLocationInWindow((int[])localObject2);
                        j = ((BaseTimeLineItem.BaseViewHolder)localObject4).zbE.yFf.getWidth();
                        i = ((BaseTimeLineItem.BaseViewHolder)localObject4).zbE.yFf.getHeight();
                        com.tencent.mm.plugin.report.service.h.wUl.f(11444, new Object[] { Integer.valueOf(3) });
                        localObject4 = b.a(b.this, (p)localObject3);
                        if (!com.tencent.mm.plugin.sns.data.j.a(b.this.activity, (p)localObject3, (com.tencent.mm.plugin.sns.storage.a)localObject4, b.this.dbL, b.this.yJJ)) {
                          continue;
                        }
                        AppMethodBeat.o(163130);
                        return;
                        localObject2 = com.tencent.mm.modelsns.d.pt(717);
                        continue;
                        localObject2 = com.tencent.mm.modelsns.d.pt(745);
                        continue;
                        if (((TimeLineObject)localObject6).FQo.Ety != 27) {
                          continue;
                        }
                        ((k.b)localObject4).zfH.getLocationInWindow((int[])localObject2);
                        j = ((k.b)localObject4).zfH.getWidth();
                        i = ((k.b)localObject4).zfH.getHeight();
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) {
                          continue;
                        }
                        localObject4 = (com.tencent.mm.plugin.sns.ui.an)paramAnonymousView.getTag();
                        if (localObject4 == null) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFf.getLocationInWindow((int[])localObject2);
                        j = ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFf.getWidth();
                        i = ((com.tencent.mm.plugin.sns.ui.an)localObject4).yFf.getHeight();
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
                        b.this.i((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag());
                        n = b.this.dbL;
                        if (b.this.dbL != 0) {
                          continue;
                        }
                        m = 1;
                        paramAnonymousView = new SnsAdClick(n, m, ((p)localObject3).field_snsId, 22, 21);
                        com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.yJJ, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                        localObject4 = new Intent();
                        ((Intent)localObject4).putExtra("img_gallery_left", localObject2[0]);
                        ((Intent)localObject4).putExtra("img_gallery_top", localObject2[1]);
                        ((Intent)localObject4).putExtra("img_gallery_width", j);
                        ((Intent)localObject4).putExtra("img_gallery_height", i);
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_sns_id", ((p)localObject3).getSnsId());
                        ((Intent)localObject4).putExtra("sns_landing_pages_rawSnsId", ((p)localObject3).dLV().Id);
                        ((Intent)localObject4).putExtra("sns_landing_pages_ux_info", ((p)localObject3).dMD());
                        paramAnonymousView = ((p)localObject3).dLV();
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView = paramAnonymousView.FQo.Etz;
                        if (paramAnonymousView.size() <= k) {
                          continue;
                        }
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_thumb_url", ((btz)paramAnonymousView.get(k)).Fjh);
                        ((Intent)localObject4).setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                        i = 1;
                        if (b.this.dbL != 2) {
                          continue;
                        }
                        i = 16;
                        ((Intent)localObject4).putExtra("sns_landig_pages_from_source", i);
                        if (k <= 0) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dFR().dJS();
                        ((Intent)localObject4).putExtra("sns_landing_pages_xml", paramAnonymousView);
                        ((Intent)localObject4).putExtra("sns_landing_pages_rec_src", ((p)localObject3).dMF());
                        ((Intent)localObject4).putExtra("sns_landing_pages_xml_prefix", "adxml");
                        ((Intent)localObject4).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        ((Intent)localObject4).putExtra("sns_landing_is_native_sight_ad", true);
                        paramAnonymousView = b.this.activity;
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject4);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        b.this.activity.overridePendingTransition(0, 0);
                        AppMethodBeat.o(163130);
                        return;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        b.this.a((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag());
                        continue;
                        m = 2;
                        continue;
                        if (b.this.dbL != 1) {
                          continue;
                        }
                        i = 2;
                        continue;
                        paramAnonymousView = ((p)localObject3).dME().field_adxml;
                        continue;
                        paramAnonymousView = b.this;
                        localObject2 = b.a(b.this, (p)localObject3);
                        if (k <= 0) {
                          continue;
                        }
                        bool = true;
                        if (!b.a(paramAnonymousView, (com.tencent.mm.plugin.sns.storage.a)localObject2, (p)localObject3, bool)) {
                          continue;
                        }
                        j = b.this.dbL;
                        if (b.this.dbL != 0) {
                          continue;
                        }
                        i = 1;
                        paramAnonymousView = new SnsAdClick(j, i, ((p)localObject3).field_snsId, 22, 31);
                        com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.yJJ, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                        AppMethodBeat.o(163130);
                        return;
                        bool = false;
                        continue;
                        i = 2;
                        continue;
                        j = b.this.dbL;
                        if (b.this.dbL != 0) {
                          continue;
                        }
                        i = 1;
                        localObject4 = new SnsAdClick(j, i, ((p)localObject3).field_snsId, 22, 0);
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, b.this.yJJ, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
                        if (k <= 0) {
                          continue;
                        }
                        localObject2 = ((p)localObject3).dFR().ygm.yeD;
                        paramAnonymousView = (View)localObject2;
                        if (!bs.isNullOrNil((String)localObject2)) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dMB();
                        if (!bs.isNullOrNil(paramAnonymousView)) {
                          continue;
                        }
                        AppMethodBeat.o(163130);
                        return;
                        i = 2;
                        continue;
                        localObject2 = ((p)localObject3).dMC();
                        continue;
                        ac.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject3).dFR().yfv);
                        localObject5 = new Intent();
                        if (((p)localObject3).dFR().yfv != 0) {
                          continue;
                        }
                        bool = true;
                        if (!ab.ivP) {
                          continue;
                        }
                        bool = false;
                        localObject2 = paramAnonymousView;
                        if (localObject3 == null) {
                          continue;
                        }
                        localObject2 = paramAnonymousView;
                        if (!((p)localObject3).Pe(32)) {
                          continue;
                        }
                        Object localObject6 = b.a(b.this, (p)localObject3);
                        localObject2 = paramAnonymousView;
                        if (localObject6 == null) {
                          continue;
                        }
                        ((Intent)localObject5).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject6).dyy);
                        localObject2 = com.tencent.mm.plugin.sns.data.q.iV(paramAnonymousView, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dtx);
                        com.tencent.mm.plugin.sns.data.q.g((Intent)localObject5, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dtx);
                        ((Intent)localObject5).putExtra("KRightBtn", bool);
                        paramAnonymousView = new Bundle();
                        paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                        paramAnonymousView.putString("key_snsad_statextstr", ((p)localObject3).dLV().yAj);
                        ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
                        ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                        ((Intent)localObject5).putExtra("useJs", true);
                        ((Intent)localObject5).putExtra("srcUsername", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("stastic_scene", 15);
                        ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("pre_username", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("preUsername", ((p)localObject3).field_userName);
                        com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject5, b.this.activity);
                        AppMethodBeat.o(163130);
                        return;
                        bool = false;
                        continue;
                        if (((((TimeLineObject)localObject6).FQo.Ety != 1) || (((TimeLineObject)localObject6).FQo.Etz.size() != 1)) && (((TimeLineObject)localObject6).FQo.Ety != 7) && ((((TimeLineObject)localObject6).FQo.Ety != 27) || (((TimeLineObject)localObject6).FQo.Etz.size() <= k) || (((btz)((TimeLineObject)localObject6).FQo.Etz.get(k)).ndI != 2))) {
                          continue;
                        }
                        localObject2 = b.a(b.this, (p)localObject3);
                        if (!com.tencent.mm.plugin.sns.data.j.a(b.this.activity, (p)localObject3, (com.tencent.mm.plugin.sns.storage.a)localObject2, b.this.dbL, b.this.yJJ)) {
                          continue;
                        }
                        AppMethodBeat.o(163130);
                        return;
                        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                          continue;
                        }
                        localObject2 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.item.a.a)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.item.a.a)paramAnonymousView.getTag()).zcc;
                        if (!((p)localObject3).dFR().dJG()) {
                          continue;
                        }
                        localObject5 = ((p)localObject3).dME().field_adxml;
                        if (k <= 0) {
                          continue;
                        }
                        localObject4 = "adTurnCanvasInfo";
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jz((String)localObject5, (String)localObject4)) {
                          continue;
                        }
                        m = b.this.dbL;
                        if (b.this.dbL != 0) {
                          continue;
                        }
                        j = 1;
                        localObject4 = new SnsAdClick(m, j, ((p)localObject3).field_snsId, 21, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, b.this.yJJ, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
                        if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                          continue;
                        }
                        b.this.i((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag());
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
                        ((Intent)localObject2).putExtra("sns_landing_pages_rawSnsId", ((p)localObject3).dLV().Id);
                        ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", ((p)localObject3).dMD());
                        ((Intent)localObject2).putExtra("sns_landing_pages_aid", ((p)localObject3).dMz());
                        ((Intent)localObject2).putExtra("sns_landing_pages_traceid", ((p)localObject3).dMA());
                        paramAnonymousView = ((p)localObject3).dLV();
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView = paramAnonymousView.FQo.Etz;
                        if (paramAnonymousView.size() <= k) {
                          continue;
                        }
                        ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((btz)paramAnonymousView.get(k)).Fjh);
                        ((Intent)localObject2).setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                        i = 1;
                        if (b.this.dbL != 2) {
                          continue;
                        }
                        i = 16;
                        ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
                        if (k <= 0) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dFR().dJS();
                        ((Intent)localObject2).putExtra("sns_landing_pages_xml", paramAnonymousView);
                        ((Intent)localObject2).putExtra("sns_landing_pages_rec_src", ((p)localObject3).dMF());
                        ((Intent)localObject2).putExtra("sns_landing_pages_xml_prefix", "adxml");
                        ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        paramAnonymousView = b.this.activity;
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        b.this.activity.overridePendingTransition(0, 0);
                        if (b.this.yyv == null) {
                          continue;
                        }
                        b.this.yyv.dHw().D((p)localObject3);
                        AppMethodBeat.o(163130);
                        return;
                        if (!(paramAnonymousView.getTag() instanceof d.a)) {
                          continue;
                        }
                        localObject2 = ((d.a)paramAnonymousView.getTag()).zcc;
                        continue;
                        if (!(localObject2 instanceof k.b)) {
                          continue;
                        }
                        localObject2 = (TagImageView)((k.b)localObject2).zfJ.view;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof i.a)) {
                          continue;
                        }
                        localObject2 = ((i.a)paramAnonymousView.getTag()).zft;
                        continue;
                        localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject2).zdG.Pr(0);
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).zbL;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.c)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.c)paramAnonymousView.getTag()).zcc;
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
                        b.this.a((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag());
                        continue;
                        if (paramAnonymousView.size() <= 0) {
                          continue;
                        }
                        ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((btz)paramAnonymousView.get(0)).Fjh);
                        continue;
                        if (b.this.dbL != 1) {
                          continue;
                        }
                        i = 2;
                        continue;
                        paramAnonymousView = ((p)localObject3).dME().field_adxml;
                        continue;
                        paramAnonymousView = b.this;
                        localObject2 = b.a(b.this, (p)localObject3);
                        if (k <= 0) {
                          continue;
                        }
                        bool = true;
                        if (!b.a(paramAnonymousView, (com.tencent.mm.plugin.sns.storage.a)localObject2, (p)localObject3, bool)) {
                          continue;
                        }
                        k = b.this.dbL;
                        if (b.this.dbL != 0) {
                          continue;
                        }
                        j = 1;
                        paramAnonymousView = new SnsAdClick(k, j, ((p)localObject3).field_snsId, 31, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.yJJ, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                        AppMethodBeat.o(163130);
                        return;
                        bool = false;
                        continue;
                        j = 2;
                        continue;
                        if (k <= 0) {
                          continue;
                        }
                        localObject2 = ((p)localObject3).dFR().ygm.yeD;
                        paramAnonymousView = (View)localObject2;
                        if (!bs.isNullOrNil((String)localObject2)) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dMB();
                        if (!bs.isNullOrNil(paramAnonymousView)) {
                          continue;
                        }
                        AppMethodBeat.o(163130);
                        return;
                        localObject2 = ((p)localObject3).dMC();
                        continue;
                        k = b.this.dbL;
                        if (b.this.dbL != 0) {
                          continue;
                        }
                        j = 1;
                        localObject4 = new SnsAdClick(k, j, ((p)localObject3).field_snsId, 0, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, b.this.yJJ, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
                        ac.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject3).dFR().yfv);
                        localObject5 = new Intent();
                        if (((p)localObject3).dFR().yfv != 0) {
                          continue;
                        }
                        bool = true;
                        if (!ab.ivP) {
                          continue;
                        }
                        bool = false;
                        localObject2 = paramAnonymousView;
                        if (localObject3 == null) {
                          continue;
                        }
                        localObject2 = paramAnonymousView;
                        if (!((p)localObject3).Pe(32)) {
                          continue;
                        }
                        localObject6 = b.a(b.this, (p)localObject3);
                        localObject2 = paramAnonymousView;
                        if (localObject6 == null) {
                          continue;
                        }
                        ((Intent)localObject5).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject6).dyy);
                        localObject2 = com.tencent.mm.plugin.sns.data.q.iV(paramAnonymousView, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dtx);
                        com.tencent.mm.plugin.sns.data.q.g((Intent)localObject5, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dtx);
                        ((Intent)localObject5).putExtra("KRightBtn", bool);
                        paramAnonymousView = new Bundle();
                        paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                        paramAnonymousView.putString("key_snsad_statextstr", ((p)localObject3).dLV().yAj);
                        ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
                        ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                        ((Intent)localObject5).putExtra("useJs", true);
                        ((Intent)localObject5).putExtra("srcUsername", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("stastic_scene", 15);
                        ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("pre_username", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.wW(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("preUsername", ((p)localObject3).field_userName);
                        com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject5, b.this.activity);
                        AppMethodBeat.o(163130);
                        return;
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
                      if (((p)localObject3).dME().dFR().dJP())
                      {
                        localObject1 = ((p)localObject3).dME().dFR().dJJ();
                        localObject4 = ((p)localObject3).dMD();
                        com.tencent.mm.kernel.g.agP();
                        localObject5 = com.tencent.mm.kernel.a.afE();
                        x.b((String)localObject1, (String)localObject4, (String)localObject5, x.aA((String)localObject1, (String)localObject4, (String)localObject5), 0, "");
                      }
                      localObject6 = ((p)localObject3).dLV();
                      if (((((TimeLineObject)localObject6).FQo.Ety != 15) || (((TimeLineObject)localObject6).FQv == 1)) && ((((TimeLineObject)localObject6).FQo.Ety != 27) || (((TimeLineObject)localObject6).FQo.Etz.size() <= k) || (((btz)((TimeLineObject)localObject6).FQo.Etz.get(k)).ndI != 6))) {
                        continue;
                      }
                      ac.i("MicroMsg.TimelineClickListener", "onsight click");
                      localObject1 = null;
                      localObject4 = null;
                      if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) {
                        localObject1 = (com.tencent.mm.plugin.sns.ui.an)paramAnonymousView.getTag();
                      }
                      if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                        continue;
                      }
                      localObject4 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                      if (((TimeLineObject)localObject6).FQo.Ety != 27) {
                        continue;
                      }
                      localObject1 = ((k.b)localObject4).zfK;
                      if (localObject3 != null) {
                        continue;
                      }
                      AppMethodBeat.o(163130);
                      return;
                      localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).dyy;
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
                  label4566:
                  i = 0;
                }
              }
              label4571:
              i = 0;
              k = m;
            }
            label4580:
            i = 0;
          }
          label4585:
          j = 0;
        }
      }
    };
    this.zgJ = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(163132);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        Object localObject;
        if ((paramAnonymousContextMenuInfo instanceof s))
        {
          paramAnonymousContextMenuInfo = (s)paramAnonymousContextMenuInfo;
          localObject = paramAnonymousContextMenuInfo.yyZ;
          if (com.tencent.mm.br.d.aCT("favorite")) {
            switch (((TimeLineObject)localObject).FQo.Ety)
            {
            default: 
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, af.dHR().auT(paramAnonymousContextMenuInfo.ddB));
          AppMethodBeat.o(163132);
          return;
          paramAnonymousContextMenu.add(0, 4, 0, paramAnonymousView.getContext().getString(2131761941));
          localObject = new dy();
          ((dy)localObject).ddK.ddB = paramAnonymousContextMenuInfo.ddB;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          if (((dy)localObject).ddL.ddj)
          {
            paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755836));
            continue;
            paramAnonymousContextMenu.add(0, 5, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 9, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            localObject = new dy();
            ((dy)localObject).ddK.ddB = paramAnonymousContextMenuInfo.ddB;
            com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
            if (((dy)localObject).ddL.ddj)
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
            }
          }
        }
      }
      
      public final boolean eZ(View paramAnonymousView)
      {
        AppMethodBeat.i(163131);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof s))
        {
          localObject = (s)localObject;
          TimeLineObject localTimeLineObject = ((s)localObject).yyZ;
          if ((localTimeLineObject.FQo.Ety == 10) || (localTimeLineObject.FQo.Ety == 17) || (localTimeLineObject.FQo.Ety == 22) || (localTimeLineObject.FQo.Ety == 23))
          {
            AppMethodBeat.o(163131);
            return false;
          }
          b.this.zgp.a(paramAnonymousView, ((s)localObject).ddB, localTimeLineObject);
          AppMethodBeat.o(163131);
          return true;
        }
        AppMethodBeat.o(163131);
        return false;
      }
    };
    this.zfM = new com.tencent.mm.plugin.sight.decode.a.b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(163133);
        if ((paramAnonymousb != null) && (paramAnonymousInt == 0)) {
          if (paramAnonymousb.xCP == null) {
            break label88;
          }
        }
        label88:
        for (paramAnonymousb = (View)paramAnonymousb.xCP.get();; paramAnonymousb = null)
        {
          if ((paramAnonymousb != null) && ((paramAnonymousb instanceof com.tencent.mm.plugin.sight.decode.a.a)))
          {
            paramAnonymousb = (com.tencent.mm.plugin.sight.decode.a.a)paramAnonymousb;
            paramAnonymousb.getVideoPath();
            if ((paramAnonymousb.getTagObject() != null) && ((paramAnonymousb.getTagObject() instanceof com.tencent.mm.plugin.sns.ui.an))) {
              paramAnonymousb.getTagObject();
            }
          }
          AppMethodBeat.o(163133);
          return;
        }
      }
    };
    this.zgR = new b.33(this);
    this.zgS = new b.35(this);
    this.zgT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100257);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          Object localObject1 = paramAnonymousView.xRC;
          if ((localObject1 != null) && (!bs.gY(((daa)localObject1).FJe)) && (((daa)localObject1).FJe.get(0) != null))
          {
            Object localObject2 = ((dag)((daa)localObject1).FJe.get(0)).Md5;
            EmojiInfo localEmojiInfo = com.tencent.mm.storage.az.faZ().GXZ.aOT((String)localObject2);
            Intent localIntent = new Intent();
            localIntent.putExtra("custom_smiley_preview_md5", (String)localObject2);
            if ((localEmojiInfo.field_catalog != EmojiGroupInfo.Jsr) && (localEmojiInfo.field_catalog != EmojiGroupInfo.Jsq) && (localEmojiInfo.field_catalog != EmojiGroupInfo.Jsp)) {
              localIntent.putExtra("custom_smiley_preview_productid", localEmojiInfo.field_groupId);
            }
            com.tencent.mm.br.d.b(b.this.activity, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
            localObject2 = com.tencent.mm.plugin.sns.j.f.ydE;
            long l = x.asL(paramAnonymousView.yyH);
            paramAnonymousView = String.valueOf(((daa)localObject1).FIZ);
            localObject1 = com.tencent.mm.plugin.sns.data.q.wW(l);
            localObject1 = (f.a)((com.tencent.mm.plugin.sns.j.f)localObject2).ydP.get(localObject1);
            if ((localObject1 != null) && (!((f.a)localObject1).yeq.contains(paramAnonymousView))) {
              ((f.a)localObject1).yeq.add(paramAnonymousView);
            }
          }
        }
        AppMethodBeat.o(100257);
      }
    };
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, p paramp, int paramInt)
  {
    try
    {
      if (!bs.isNullOrNil(paramString1))
      {
        if (paramInt == 2) {}
        for (com.tencent.mm.plugin.sns.storage.a locala = paramp.dLS(); locala == null; locala = paramp.dFQ())
        {
          ac.e("MicroMsg.TimelineClickListener", "jumpWeApp adInfo==null");
          return false;
        }
        String str = com.tencent.mm.plugin.sns.data.q.wW(paramp.field_snsId) + ":" + locala.dtx + ":" + af.dHx() + ":" + System.currentTimeMillis();
        if (paramInt == 0) {}
        for (paramInt = 1045;; paramInt = 1046)
        {
          com.tencent.mm.plugin.sns.data.q.a(paramString1, paramString2, paramString3, paramp.dMz(), paramp.dMA(), str, locala.dtx, paramInt);
          return true;
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      ac.e("MicroMsg.TimelineClickListener", "jumpWeApp exp:" + paramString1.toString());
    }
  }
  
  public final void a(com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    if (this.zgn != null) {
      ac.w("MicroMsg.TimelineClickListener", "has already prepare detail click animation");
    }
    do
    {
      return;
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.b))
      {
        this.zgn = new com.tencent.mm.plugin.sns.ui.b.a.d((MMActivity)this.activity, parama);
        this.zgo = new com.tencent.mm.plugin.sns.ui.b.a.c((MMActivity)this.activity, parama);
        return;
      }
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
      {
        this.zgn = new com.tencent.mm.plugin.sns.ui.b.a.f((MMActivity)this.activity, parama);
        this.zgo = new com.tencent.mm.plugin.sns.ui.b.a.e((MMActivity)this.activity, parama);
        return;
      }
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.e))
      {
        this.zgn = new com.tencent.mm.plugin.sns.ui.b.a.j((MMActivity)this.activity, parama);
        this.zgo = new com.tencent.mm.plugin.sns.ui.b.a.i((MMActivity)this.activity, parama);
        return;
      }
    } while (!(parama instanceof com.tencent.mm.plugin.sns.ui.c.a.d));
    this.zgn = new com.tencent.mm.plugin.sns.ui.b.a.h((MMActivity)this.activity, parama);
    this.zgo = new com.tencent.mm.plugin.sns.ui.b.a.g((MMActivity)this.activity, parama);
  }
  
  public final void b(com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    this.yJJ = parami;
    if (this.zgp != null) {
      this.zgp.b(parami);
    }
  }
  
  public final void cVE()
  {
    this.zgp.cVE();
    com.tencent.mm.sdk.b.a.GpY.c(this.zhc);
    com.tencent.mm.sdk.b.a.GpY.c(this.zhd);
  }
  
  public abstract void d(View paramView, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void dF(Object paramObject);
  
  public abstract void dNn();
  
  public abstract void dNo();
  
  public abstract void dNp();
  
  public abstract void dNq();
  
  public abstract void eL(View paramView);
  
  public abstract void eM(View paramView);
  
  public abstract void eN(View paramView);
  
  public abstract void eO(View paramView);
  
  public abstract void eP(View paramView);
  
  public abstract void eQ(View paramView);
  
  public abstract void eR(View paramView);
  
  public final void i(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    if (this.zgl != null) {
      ac.w("MicroMsg.TimelineClickListener", "has already prepare click animation");
    }
    do
    {
      return;
      if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.a.a))
      {
        this.zgl = new com.tencent.mm.plugin.sns.ui.b.b.d((MMActivity)this.activity, paramBaseViewHolder);
        this.zgm = new com.tencent.mm.plugin.sns.ui.b.b.c((MMActivity)this.activity, paramBaseViewHolder);
        ((com.tencent.mm.plugin.sns.ui.item.a.a)paramBaseViewHolder).zeO = true;
        return;
      }
      if ((paramBaseViewHolder instanceof d.a))
      {
        this.zgl = new com.tencent.mm.plugin.sns.ui.b.b.f((MMActivity)this.activity, paramBaseViewHolder);
        this.zgm = new com.tencent.mm.plugin.sns.ui.b.b.e((MMActivity)this.activity, paramBaseViewHolder);
        ((d.a)paramBaseViewHolder).zeO = true;
        return;
      }
      if ((paramBaseViewHolder instanceof k.b))
      {
        this.zgl = new com.tencent.mm.plugin.sns.ui.b.b.j((MMActivity)this.activity, paramBaseViewHolder);
        this.zgm = new com.tencent.mm.plugin.sns.ui.b.b.i((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
    } while (!(paramBaseViewHolder instanceof i.a));
    this.zgl = new com.tencent.mm.plugin.sns.ui.b.b.h((MMActivity)this.activity, paramBaseViewHolder);
    this.zgm = new com.tencent.mm.plugin.sns.ui.b.b.g((MMActivity)this.activity, paramBaseViewHolder);
  }
  
  public final void removeListener()
  {
    this.zgp.removeListener();
    com.tencent.mm.sdk.b.a.GpY.d(this.zhc);
    com.tencent.mm.sdk.b.a.GpY.d(this.zhd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b
 * JD-Core Version:    0.7.0.1
 */