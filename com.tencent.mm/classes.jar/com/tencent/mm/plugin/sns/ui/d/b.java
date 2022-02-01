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
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.a.vn;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sns.a.b.m.a;
import com.tencent.mm.plugin.sns.a.b.m.b;
import com.tencent.mm.plugin.sns.k.f.a;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.storage.a.c;
import com.tencent.mm.plugin.sns.storage.a.c.a;
import com.tencent.mm.plugin.sns.storage.b.d;
import com.tencent.mm.plugin.sns.storage.b.i;
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
import com.tencent.mm.plugin.sns.ui.ai;
import com.tencent.mm.plugin.sns.ui.b.b.b.a;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.plugin.sns.ui.be.b;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.d.a;
import com.tencent.mm.plugin.sns.ui.item.i.a;
import com.tencent.mm.plugin.sns.ui.item.k.a;
import com.tencent.mm.plugin.sns.ui.item.k.b;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.cuo;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bc;
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
  int dep = 0;
  private ClipboardManager qiE;
  public View.OnTouchListener rFq;
  public com.tencent.mm.plugin.sight.decode.a.b.e xSR;
  public View.OnClickListener xTA;
  public View.OnClickListener xTB;
  public View.OnClickListener xTC;
  public View.OnClickListener xTD;
  public View.OnClickListener xTE;
  public View.OnClickListener xTF;
  public c xTG;
  public c xTH;
  public c xTI;
  public c xTJ;
  public c xTK;
  public c xTL;
  public c xTM;
  c xTN;
  public View.OnClickListener xTO;
  public View.OnClickListener xTP;
  public View.OnClickListener xTQ;
  public View.OnClickListener xTR;
  public View.OnClickListener xTS;
  public View.OnClickListener xTT;
  public View.OnClickListener xTU;
  public View.OnClickListener xTV;
  public View.OnClickListener xTW;
  public View.OnClickListener xTX;
  public View.OnClickListener xTY;
  public AdapterView.OnItemClickListener xTZ;
  volatile com.tencent.mm.plugin.sns.ui.b.b.b xTp;
  volatile com.tencent.mm.plugin.sns.ui.b.b.a xTq;
  volatile com.tencent.mm.plugin.sns.ui.b.a.b xTr;
  volatile com.tencent.mm.plugin.sns.ui.b.a.a xTs;
  public a xTt;
  public View.OnClickListener xTu;
  public View.OnLongClickListener xTv;
  public c xTw;
  public View.OnClickListener xTx;
  public View.OnClickListener xTy;
  public View.OnClickListener xTz;
  public AdapterView.OnItemClickListener xUa;
  public View.OnClickListener xUb = new View.OnClickListener()
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
      p localp = b.eL(paramAnonymousView);
      if ((localp == null) || (!localp.Nb(32)))
      {
        AppMethodBeat.o(100199);
        return;
      }
      int j;
      int i;
      Object localObject;
      label121:
      int k;
      if (localp.dyh().dxs().dvq())
      {
        j = x.jh(localp.dyh().dxs().dvk(), localp.dyg());
        if (j > 0)
        {
          i = 1;
          localObject = localp.dyh().dxs().dvk();
          String str1 = localp.dyg();
          com.tencent.mm.kernel.g.afz();
          String str2 = com.tencent.mm.kernel.a.aeo();
          if (i == 0) {
            break label215;
          }
          if (i == 0) {
            break label220;
          }
          k = 0;
          label128:
          x.c((String)localObject, str1, str2, j, k, "");
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject = localp.dxy();
        if ((((TimeLineObject)localObject).Etm.DaB == 15) && (((TimeLineObject)localObject).Ett != 1))
        {
          b.a(b.this, paramAnonymousView, localp, 1001, localp.dyh().dxs().dvr(), bool);
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
        if (((((TimeLineObject)localObject).Etm.DaB == 1) && (((TimeLineObject)localObject).Etm.DaC.size() == 1)) || (((TimeLineObject)localObject).Etm.DaB == 7)) {
          b.b(b.this, paramAnonymousView, localp, 1001, localp.dyh().dxs().dvr(), bool);
        }
        AppMethodBeat.o(100199);
        return;
      }
    }
  };
  public View.OnClickListener xUc = new View.OnClickListener()
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
      p localp = b.eL(paramAnonymousView);
      if ((localp == null) || (!localp.Nb(32)))
      {
        AppMethodBeat.o(100219);
        return;
      }
      int j;
      int i;
      Object localObject;
      label121:
      int k;
      if (localp.dyh().dxs().dvq())
      {
        j = x.jh(localp.dyh().dxs().dvk(), localp.dyg());
        if (j > 0)
        {
          i = 1;
          localObject = localp.dyh().dxs().dvk();
          String str1 = localp.dyg();
          com.tencent.mm.kernel.g.afz();
          String str2 = com.tencent.mm.kernel.a.aeo();
          if (i == 0) {
            break label215;
          }
          if (i == 0) {
            break label220;
          }
          k = 0;
          label128:
          x.c((String)localObject, str1, str2, j, k, "");
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject = localp.dxy();
        if ((((TimeLineObject)localObject).Etm.DaB == 15) && (((TimeLineObject)localObject).Ett != 1))
        {
          b.a(b.this, paramAnonymousView, localp, 1002, localp.dyh().dxs().dvs(), bool);
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
        if (((((TimeLineObject)localObject).Etm.DaB == 1) && (((TimeLineObject)localObject).Etm.DaC.size() == 1)) || (((TimeLineObject)localObject).Etm.DaB == 7)) {
          b.b(b.this, paramAnonymousView, localp, 1002, localp.dyh().dxs().dvs(), bool);
        }
        AppMethodBeat.o(100219);
        return;
      }
    }
  };
  public View.OnClickListener xUd;
  public be.b xUe;
  int xUf;
  private com.tencent.mm.sdk.b.c<vn> xUg = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.sdk.b.c<vm> xUh = new com.tencent.mm.sdk.b.c() {};
  public View.OnClickListener xUi = new View.OnClickListener()
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
        localObject1 = com.tencent.mm.plugin.sns.storage.h.apJ(((BaseTimeLineItem.BaseViewHolder)localObject2).dpC);
        localObject3 = ((BaseTimeLineItem.BaseViewHolder)localObject2).xQz;
        localObject2 = null;
      }
      for (;;)
      {
        Object localObject4;
        Object localObject5;
        int i;
        if (localObject1 != null)
        {
          localObject4 = ((p)localObject1).dyh();
          int k = ((com.tencent.mm.plugin.sns.storage.e)localObject4).getSource();
          if ((localObject1 != null) && (((p)localObject1).Nb(32)))
          {
            localObject5 = b.a(b.this, (p)localObject1);
            if ((((p)localObject1).dxs().dvh()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(((p)localObject1).dyh().field_adxml)))
            {
              localObject5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.G((p)localObject1);
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
                label188:
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
                paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
                paramAnonymousView.putExtra("img_gallery_width", i);
                paramAnonymousView.putExtra("img_gallery_height", j);
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", ((p)localObject1).getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", ((p)localObject1).dxy().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", ((p)localObject1).dyg());
                localObject2 = ((p)localObject1).dxy();
                if (localObject2 != null)
                {
                  localObject2 = ((TimeLineObject)localObject2).Etm.DaC;
                  if (((List)localObject2).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((bpi)((List)localObject2).get(0)).DMQ);
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
                paramAnonymousView.putExtra("sns_landing_pages_xml", ((p)localObject1).dyh().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", ((p)localObject1).dyi());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject2 = b.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramAnonymousView.adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject2).startActivity((Intent)paramAnonymousView.lS(0));
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
            if ((localObject5 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject5).wRT == 1))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject5).wRV);
              paramAnonymousView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject5).wRW);
              paramAnonymousView.putExtra("key_from_scene", 21);
              paramAnonymousView.putExtra("key_stastic_scene", 15);
              com.tencent.mm.bs.d.b(b.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
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
          localObject2 = ((p)localObject1).dyf();
          paramAnonymousView = (View)localObject2;
          if (bt.isNullOrNil((String)localObject2)) {
            paramAnonymousView = ((p)localObject1).dye();
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject1).dxs().wSL);
          localObject5 = new Intent();
          if (((p)localObject1).dxs().wSL != 0) {
            break label1209;
          }
        }
        label1204:
        label1209:
        for (boolean bool = true;; bool = false)
        {
          if (ab.hVL) {
            bool = false;
          }
          localObject2 = paramAnonymousView;
          if (localObject1 != null)
          {
            localObject2 = paramAnonymousView;
            if (((p)localObject1).Nb(32))
            {
              com.tencent.mm.plugin.sns.storage.a locala = b.a(b.this, (p)localObject1);
              localObject2 = paramAnonymousView;
              if (locala != null)
              {
                ((Intent)localObject5).putExtra("KsnsViewId", locala.dAM);
                localObject2 = com.tencent.mm.plugin.sns.data.q.iy(paramAnonymousView, locala.dvK);
                com.tencent.mm.plugin.sns.data.q.g((Intent)localObject5, locala.dvK);
              }
            }
          }
          ((Intent)localObject5).putExtra("KRightBtn", bool);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject3);
          paramAnonymousView.putString("key_snsad_statextstr", ((com.tencent.mm.plugin.sns.storage.e)localObject4).dxy().xns);
          ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
          ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
          ((Intent)localObject5).putExtra("useJs", true);
          ((Intent)localObject5).putExtra("srcUsername", ((p)localObject1).field_userName);
          ((Intent)localObject5).putExtra("stastic_scene", 15);
          ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(((p)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("pre_username", ((p)localObject1).field_userName);
          ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(((p)localObject1).field_snsId));
          ((Intent)localObject5).putExtra("preUsername", ((p)localObject1).field_userName);
          com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject5, b.this.activity);
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
  ae xlD;
  public View.OnClickListener xno;
  protected com.tencent.mm.plugin.sns.a.b.i xwT;
  
  public b(int paramInt, Activity paramActivity, ae paramae)
  {
    this.dep = paramInt;
    this.activity = paramActivity;
    this.xlD = paramae;
    this.xUf = bt.getInt(com.tencent.mm.m.g.Zd().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[] { Integer.valueOf(this.xUf) });
    this.qiE = ((ClipboardManager)com.tencent.mm.sdk.platformtools.aj.getContext().getSystemService("clipboard"));
    this.xTt = new a(this.activity, this.dep, this.xlD);
    this.xTE = new View.OnClickListener()
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
        com.tencent.mm.plugin.sns.storage.e locale = af.dtx().sY(l);
        p localp = locale.dxE();
        com.tencent.mm.plugin.sns.a.b.m.a(m.b.wzb, m.a.wyZ, locale.dxE(), b.this.dep);
        locale.getSource();
        paramAnonymousView = localp.dyf();
        if (bt.isNullOrNil(paramAnonymousView)) {
          paramAnonymousView = localp.dye();
        }
        for (;;)
        {
          Object localObject1;
          int i;
          Object localObject2;
          int j;
          if (localp.Nb(32))
          {
            localObject1 = b.a(b.this, localp);
            i = -1;
            localObject2 = com.tencent.mm.model.c.d.atz().aHi("Sns_CanvasAd_DetailLink_JumpWay");
            if (((com.tencent.mm.storage.a)localObject2).isValid()) {
              i = bt.getInt(((com.tencent.mm.storage.a)localObject2).field_value, -1);
            }
            if ((localObject1 != null) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).wRT == 1))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_card_id", ((com.tencent.mm.plugin.sns.storage.a)localObject1).wRV);
              paramAnonymousView.putExtra("key_card_ext", ((com.tencent.mm.plugin.sns.storage.a)localObject1).wRW);
              paramAnonymousView.putExtra("key_from_scene", 21);
              paramAnonymousView.putExtra("key_stastic_scene", 15);
              com.tencent.mm.bs.d.b(b.this.activity, "card", ".ui.CardDetailUI", paramAnonymousView);
              j = b.this.dep;
              if (b.this.dep == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 11);
                com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.xwT, localp, 3);
                com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                AppMethodBeat.o(100258);
                return;
              }
            }
            if ((localObject1 != null) && (i == 1))
            {
              if ((localp.dxs().dvh()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(localp.dyh().field_adxml)))
              {
                paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.G(localp);
                if (!bt.isNullOrNil(paramAnonymousView)) {
                  locale.field_adxml = paramAnonymousView;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dxy().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dyg());
                paramAnonymousView.putExtra("sns_landing_pages_aid", localp.dyc());
                paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.dyd());
                localObject1 = localp.dxy();
                if (localObject1 != null)
                {
                  localObject1 = ((TimeLineObject)localObject1).Etm.DaC;
                  if (((List)localObject1).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((bpi)((List)localObject1).get(0)).DMQ);
                  }
                }
                paramAnonymousView.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (b.this.dep == 2)
                {
                  i = 16;
                  paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                  paramAnonymousView.putExtra("sns_landing_pages_xml", localp.dyh().field_adxml);
                  paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                  paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dyi());
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                  localObject1 = b.this.activity;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)paramAnonymousView.lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  b.this.activity.overridePendingTransition(0, 0);
                  j = b.this.dep;
                  if (b.this.dep != 0) {
                    break label744;
                  }
                }
                label744:
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 21);
                  com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.xwT, localp, 3);
                  com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                  AppMethodBeat.o(100258);
                  return;
                  if (b.this.dep != 1) {
                    break;
                  }
                  i = 10;
                  break;
                }
              }
            }
            else if ((localObject1 != null) && (i == 0))
            {
              if ((!localp.dxs().dvh()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(localp.dyh().field_adxml))) {
                break label1869;
              }
              localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.G(localp);
              if (!bt.isNullOrNil((String)localObject1)) {
                locale.field_adxml = ((String)localObject1);
              }
              localObject1 = bw.K(localp.dyh().field_adxml, "adxml");
              if (localObject1 != null)
              {
                localObject1 = bt.by((String)((Map)localObject1).get(".adxml.adCanvasInfo.shareWebUrl"), "");
                if (!bt.isNullOrNil((String)localObject1)) {
                  paramAnonymousView = (View)localObject1;
                }
              }
            }
          }
          label1863:
          label1869:
          for (;;)
          {
            j = b.this.dep;
            label878:
            Intent localIntent;
            if (b.this.dep == 0)
            {
              i = 1;
              localObject2 = new SnsAdClick(j, i, localp.field_snsId, 3, 0);
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, b.this.xwT, localp, 3);
              com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + localp.dxs().wSL);
              localIntent = new Intent();
              if (localp.dxs().wSL != 0) {
                break label1863;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              if (ab.hVL) {
                bool = false;
              }
              localObject1 = paramAnonymousView;
              if (localp.Nb(32))
              {
                com.tencent.mm.plugin.sns.storage.a locala = b.a(b.this, localp);
                localObject1 = paramAnonymousView;
                if (locala != null)
                {
                  localIntent.putExtra("KsnsViewId", locala.dAM);
                  localObject1 = com.tencent.mm.plugin.sns.data.q.iy(paramAnonymousView, locala.dvK);
                  com.tencent.mm.plugin.sns.data.q.g(localIntent, locala.dvK);
                }
              }
              localIntent.putExtra("KRightBtn", bool);
              paramAnonymousView = new Bundle();
              paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject2);
              paramAnonymousView.putString("key_snsad_statextstr", locale.dxy().xns);
              localIntent.putExtra("jsapiargs", paramAnonymousView);
              localIntent.putExtra("rawUrl", (String)localObject1);
              localIntent.putExtra("useJs", true);
              localIntent.putExtra("srcUsername", localp.field_userName);
              localIntent.putExtra("sns_local_id", localp.dxX());
              localIntent.putExtra("stastic_scene", 15);
              localIntent.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId));
              localIntent.putExtra("pre_username", localp.field_userName);
              localIntent.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId));
              localIntent.putExtra("preUsername", localp.field_userName);
              com.tencent.mm.plugin.sns.d.a.hYt.i(localIntent, b.this.activity);
              AppMethodBeat.o(100258);
              return;
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + localp.dyh().field_adxml);
              break;
              if ((localObject1 != null) && (i == -1) && (((com.tencent.mm.plugin.sns.storage.a)localObject1).wRT == 3))
              {
                if ((!localp.dxs().dvh()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(localp.dyh().field_adxml))) {
                  break label1869;
                }
                paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.G(localp);
                if (!bt.isNullOrNil(paramAnonymousView)) {
                  locale.field_adxml = paramAnonymousView;
                }
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
                paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dxy().Id);
                paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dyg());
                paramAnonymousView.putExtra("sns_landing_pages_aid", localp.dyc());
                paramAnonymousView.putExtra("sns_landing_pages_traceid", localp.dyd());
                localObject1 = localp.dxy();
                if (localObject1 != null)
                {
                  localObject1 = ((TimeLineObject)localObject1).Etm.DaC;
                  if (((List)localObject1).size() > 0) {
                    paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((bpi)((List)localObject1).get(0)).DMQ);
                  }
                }
                paramAnonymousView.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                i = 9;
                if (b.this.dep == 2)
                {
                  i = 16;
                  paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                  paramAnonymousView.putExtra("sns_landing_pages_xml", localp.dyh().field_adxml);
                  paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dyi());
                  paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                  paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                  localObject1 = b.this.activity;
                  paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Activity)localObject1).startActivity((Intent)paramAnonymousView.lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  b.this.activity.overridePendingTransition(0, 0);
                  j = b.this.dep;
                  if (b.this.dep != 0) {
                    break label1771;
                  }
                }
                label1771:
                for (i = 1;; i = 2)
                {
                  paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 21);
                  com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.xwT, localp, 3);
                  com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                  AppMethodBeat.o(100258);
                  return;
                  if (b.this.dep != 1) {
                    break;
                  }
                  i = 10;
                  break;
                }
              }
              if (!b.a(b.this, (com.tencent.mm.plugin.sns.storage.a)localObject1, localp, false)) {
                break label1869;
              }
              j = b.this.dep;
              if (b.this.dep == 0) {}
              for (i = 1;; i = 2)
              {
                paramAnonymousView = new SnsAdClick(j, i, localp.field_snsId, 3, 31);
                com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.xwT, localp, 3);
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
    this.xTP = new View.OnClickListener()
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
        p localp = af.dtu().apK(paramAnonymousView);
        if (localp == null)
        {
          AppMethodBeat.o(100259);
          return;
        }
        if (localp.Nb(32))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "click the ad poi button");
          localObject1 = b.a(b.this, localp);
          if (localObject1 == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "the adInfo is null");
            AppMethodBeat.o(100259);
            return;
          }
          int j = b.this.dep;
          if (b.this.dep == 0) {}
          for (int i = 1;; i = 2)
          {
            localObject2 = new SnsAdClick(j, i, localp.field_snsId, 19, 0);
            com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, b.this.xwT, localp, 19);
            com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
            if (!bt.isNullOrNil(((com.tencent.mm.plugin.sns.storage.a)localObject1).wSb)) {
              break;
            }
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
            AppMethodBeat.o(100259);
            return;
          }
          if (b.this.dep == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.d.oE(724);; paramAnonymousView = com.tencent.mm.modelsns.d.oF(724))
          {
            paramAnonymousView.zi(com.tencent.mm.plugin.sns.data.q.l(localp)).oH(localp.field_type).ew(localp.Nb(32)).zi(localp.dyg()).zi("").zi("").zi("").zi("").zi(((com.tencent.mm.plugin.sns.storage.a)localObject1).wSa).zi("").zi("");
            paramAnonymousView.aBj();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "open webview url : " + ((com.tencent.mm.plugin.sns.storage.a)localObject1).wSb);
            paramAnonymousView = new Intent();
            if ((localp != null) && (localp.Nb(32)))
            {
              localObject3 = b.a(b.this, localp);
              if (localObject3 != null) {
                paramAnonymousView.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject3).dAM);
              }
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putParcelable("KSnsAdTag", (Parcelable)localObject2);
            paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject3);
            paramAnonymousView.putExtra("useJs", true);
            paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId));
            paramAnonymousView.putExtra("pre_username", localp.field_userName);
            paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId));
            paramAnonymousView.putExtra("preUsername", localp.field_userName);
            paramAnonymousView.putExtra("rawUrl", com.tencent.mm.plugin.sns.data.q.iy(((com.tencent.mm.plugin.sns.storage.a)localObject1).wSb, ((com.tencent.mm.plugin.sns.storage.a)localObject1).dvK));
            com.tencent.mm.plugin.sns.d.a.hYt.i(paramAnonymousView, b.this.activity);
            AppMethodBeat.o(100259);
            return;
          }
        }
        Object localObject2 = localp.dxy();
        Object localObject3 = ((TimeLineObject)localObject2).Etk;
        Object localObject1 = new Intent();
        if (b.this.dep == 0) {}
        for (paramAnonymousView = com.tencent.mm.modelsns.d.oE(724);; paramAnonymousView = com.tencent.mm.modelsns.d.oF(724))
        {
          paramAnonymousView.zi(com.tencent.mm.plugin.sns.data.q.l(localp)).oH(localp.field_type).ew(localp.Nb(32)).zi(localp.dyg()).zi(((bmn)localObject3).DlE).oH(((bmn)localObject3).xog).zi(((bmn)localObject3).COJ).zi(((bmn)localObject3).COI).zi(((bmn)localObject3).goQ).zi(((bmn)localObject3).xoe).zi(((bmn)localObject3).ijO);
          paramAnonymousView.aBj();
          if (!bt.isNullOrNil(((bmn)localObject3).DlE)) {
            break;
          }
          ((Intent)localObject1).putExtra("map_view_type", 7);
          ((Intent)localObject1).putExtra("kwebmap_slat", ((bmn)localObject3).COJ);
          ((Intent)localObject1).putExtra("kwebmap_lng", ((bmn)localObject3).COI);
          ((Intent)localObject1).putExtra("kPoiName", ((bmn)localObject3).goQ);
          ((Intent)localObject1).putExtra("Kwebmap_locaion", ((bmn)localObject3).xoe);
          com.tencent.mm.bs.d.b(b.this.activity, "location", ".ui.RedirectUI", (Intent)localObject1);
          AppMethodBeat.o(100259);
          return;
        }
        if (b.this.xUf == 0) {}
        for (paramAnonymousView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[] { ((bmn)localObject3).DlE });; paramAnonymousView = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[] { ((bmn)localObject3).DlE, ((TimeLineObject)localObject2).Id }))
        {
          ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
          com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject1, b.this.activity);
          AppMethodBeat.o(100259);
          return;
        }
      }
    };
    this.xTT = new View.OnClickListener()
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
        paramAnonymousView = af.dtu().apK(paramAnonymousView);
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(100260);
          return;
        }
        if (paramAnonymousView.Nb(32))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
          paramAnonymousView = b.a(b.this, paramAnonymousView);
          if (paramAnonymousView == null)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "the adInfo is null");
            AppMethodBeat.o(100260);
            return;
          }
          if (bt.isNullOrNil(paramAnonymousView.wSe))
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
            AppMethodBeat.o(100260);
            return;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "open webview url : " + paramAnonymousView.wSe);
          Intent localIntent = new Intent();
          localIntent.putExtra("jsapiargs", new Bundle());
          localIntent.putExtra("useJs", true);
          String str = com.tencent.mm.plugin.sns.data.q.iy(paramAnonymousView.wSe, paramAnonymousView.dvK);
          com.tencent.mm.plugin.sns.data.q.g(localIntent, paramAnonymousView.dvK);
          localIntent.putExtra("rawUrl", str);
          com.tencent.mm.plugin.sns.d.a.hYt.i(localIntent, b.this.activity);
          AppMethodBeat.o(100260);
          return;
        }
        AppMethodBeat.o(100260);
      }
    };
    this.xTU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100261);
        Object localObject;
        int j;
        if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          localObject = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dgg;
          localObject = af.dtu().apK((String)localObject);
          if (localObject == null)
          {
            AppMethodBeat.o(100261);
            return;
          }
          if (((p)localObject).Nb(32))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
            j = b.this.dep;
            if (b.this.dep != 0) {
              break label139;
            }
          }
        }
        label139:
        for (int i = 1;; i = 2)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(j, i, ((p)localObject).field_snsId, 24, 0);
          com.tencent.mm.plugin.sns.data.j.a(localSnsAdClick, b.this.xwT, (p)localObject, 24);
          com.tencent.mm.plugin.sns.data.q.a(localSnsAdClick);
          b.this.ez(paramAnonymousView);
          AppMethodBeat.o(100261);
          return;
        }
      }
    };
    this.xTu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        boolean bool = false;
        int m = 1;
        int k = 1;
        AppMethodBeat.i(100262);
        Object localObject2 = (String)paramAnonymousView.getTag();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(localObject2)));
        Object localObject3 = new Intent();
        Object localObject1;
        int j;
        int i;
        if (((paramAnonymousView instanceof MaskImageButton)) && (((MaskImageButton)paramAnonymousView).glT != null))
        {
          paramAnonymousView = (String)((MaskImageButton)paramAnonymousView).glT;
          localObject1 = af.dtu().apK(paramAnonymousView);
          if ((localObject1 != null) && (((p)localObject1).Nb(32)))
          {
            com.tencent.mm.plugin.sns.storage.b localb = ((p)localObject1).dxs();
            j = b.this.dep;
            if (b.this.dep == 0) {}
            for (i = 1;; i = 2)
            {
              paramAnonymousView = new SnsAdClick(j, i, ((p)localObject1).field_snsId, 1, 0);
              com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.xwT, (p)localObject1, 1);
              com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
              if ((localb == null) || (localb.wSV != 1) || (bt.isNullOrNil(localb.wSW))) {
                break;
              }
              localObject2 = localb.wSW;
              localObject3 = b.a(b.this, (p)localObject1);
              paramAnonymousView = (View)localObject2;
              if (localObject3 != null) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iy((String)localObject2, ((com.tencent.mm.plugin.sns.storage.a)localObject3).dvK);
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "headClickParam url " + paramAnonymousView + " " + localb.wSX);
              localObject2 = new Intent();
              if (localb.wSX == 0) {
                bool = true;
              }
              ((Intent)localObject2).putExtra("KsnsViewId", b.a(b.this, (p)localObject1).dAM);
              ((Intent)localObject2).putExtra("KRightBtn", bool);
              ((Intent)localObject2).putExtra("jsapiargs", new Bundle());
              ((Intent)localObject2).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject2).putExtra("useJs", true);
              com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject2, b.this.activity);
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
            if (b.this.dep != 0) {
              break label615;
            }
            if (paramAnonymousView.Nb(32))
            {
              j = 722;
              localObject1 = com.tencent.mm.modelsns.d.oE(j);
              ((com.tencent.mm.modelsns.d)localObject1).zi(com.tencent.mm.plugin.sns.data.q.l(paramAnonymousView)).oH(paramAnonymousView.field_type).ew(paramAnonymousView.Nb(32)).zi(paramAnonymousView.dyg()).zi((String)localObject2);
              ((com.tencent.mm.modelsns.d)localObject1).aBj();
            }
          }
          else
          {
            if (i == 0) {
              break label649;
            }
            j = b.this.dep;
            if (b.this.dep != 0) {
              break label644;
            }
          }
          label644:
          for (i = 1;; i = 2)
          {
            localObject1 = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 1, 0);
            com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject1, b.this.xwT, paramAnonymousView, 1);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            ((Intent)localObject3).putExtra("KSnsAdTag", (Parcelable)localObject1);
            ((Intent)localObject3).putExtra("Contact_Scene", 78);
            i = k;
            if (b.this.dep == 0) {
              i = 6;
            }
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            com.tencent.mm.plugin.sns.d.a.hYt.c((Intent)localObject3, b.this.activity);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "startContactInfo, addScene=78");
            AppMethodBeat.o(100262);
            return;
            j = 721;
            break;
            label615:
            if (paramAnonymousView.Nb(32)) {}
            for (j = 722;; j = 721)
            {
              localObject1 = com.tencent.mm.modelsns.d.oF(j);
              break;
            }
          }
          label649:
          b.this.xlD.dsZ().a(paramAnonymousView, true);
          if (b.this.dep == 0) {}
          for (paramAnonymousView = com.tencent.mm.modelsns.d.oE(746);; paramAnonymousView = com.tencent.mm.modelsns.d.oF(746))
          {
            localObject1 = u.aqG();
            paramAnonymousView.zi((String)localObject2).ew(((String)localObject2).endsWith((String)localObject1));
            paramAnonymousView.b((Intent)localObject3, "intent_key_StatisticsOplog");
            i = m;
            if (b.this.dep == 0) {
              i = 6;
            }
            ((Intent)localObject3).putExtra("CONTACT_INFO_UI_SOURCE", i);
            ((Intent)localObject3).putExtra("Contact_User", (String)localObject2);
            com.tencent.mm.plugin.sns.d.a.hYt.c((Intent)localObject3, b.this.activity);
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
    this.xTv = new b.2(this);
    this.xTw = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100203);
        paramAnonymousView = (ba)paramAnonymousView.getTag();
        paramAnonymousContextMenuInfo = af.dtu().apJ(paramAnonymousView.dpC);
        if (paramAnonymousContextMenuInfo == null)
        {
          AppMethodBeat.o(100203);
          return;
        }
        paramAnonymousContextMenu.add(0, 0, 0, b.this.activity.getString(2131755701));
        if (com.tencent.mm.bs.d.axB("favorite")) {
          paramAnonymousContextMenu.add(0, 1, 0, b.this.activity.getString(2131761941));
        }
        TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.dxy();
        if ((paramAnonymousView.xCS) || ((localTimeLineObject != null) && (localTimeLineObject.Eto != 1) && (!paramAnonymousView.xCT)))
        {
          if (paramAnonymousView.dBG()) {
            break label143;
          }
          com.tencent.mm.plugin.sns.model.ap.a(paramAnonymousContextMenu, true);
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
          AppMethodBeat.o(100203);
          return;
          label143:
          com.tencent.mm.plugin.sns.model.ap.b(paramAnonymousContextMenu, true);
        }
      }
      
      public final boolean eM(View paramAnonymousView)
      {
        AppMethodBeat.i(100204);
        if ((paramAnonymousView.getTag() instanceof ba))
        {
          Object localObject = (ba)paramAnonymousView.getTag();
          localObject = af.dtu().apJ(((ba)localObject).dpC);
          if (localObject == null)
          {
            AppMethodBeat.o(100204);
            return false;
          }
          String str = ((p)localObject).dxX();
          b.this.xTt.a(paramAnonymousView, str, ((p)localObject).dxy());
          AppMethodBeat.o(100204);
          return true;
        }
        AppMethodBeat.o(100204);
        return false;
      }
    };
    this.xTL = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100206);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if (((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousContextMenuInfo instanceof p)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.an)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.aw)) || ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.c.a.a))) {
          if ((paramAnonymousContextMenuInfo instanceof BaseTimeLineItem.BaseViewHolder)) {
            paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.h.apJ(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).dpC);
          }
        }
        for (;;)
        {
          if (!paramAnonymousContextMenuInfo.Nb(32))
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
              paramAnonymousContextMenuInfo = af.dtu().apK(paramAnonymousContextMenuInfo.dgg);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw))
            {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag()).diQ;
              paramAnonymousContextMenuInfo = af.dtu().apK(paramAnonymousContextMenuInfo);
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
              paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).wwP;
            }
          }
          else
          {
            if ((paramAnonymousContextMenuInfo.dxs() == null) || (!paramAnonymousContextMenuInfo.dxs().dvm()))
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (b.a(b.this, paramAnonymousContextMenuInfo).wSl != null)
            {
              AppMethodBeat.o(100206);
              return;
            }
            if (com.tencent.mm.bs.d.axB("favorite"))
            {
              if (paramAnonymousContextMenuInfo.dxs().dvm()) {
                paramAnonymousContextMenu.add(0, 20, 0, paramAnonymousView.getContext().getString(2131761941));
              }
              dx localdx = new dx();
              localdx.dgp.dgg = paramAnonymousContextMenuInfo.dxX();
              com.tencent.mm.sdk.b.a.ESL.l(localdx);
              if (localdx.dgq.dfO) {
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
      
      public final boolean eM(View paramAnonymousView)
      {
        AppMethodBeat.i(100205);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof p)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw)) || ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.h.apJ(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dpC);
          }
        }
        for (;;)
        {
          if (localObject != null)
          {
            if (!((p)localObject).Nb(32))
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
                localObject = af.dtu().apK(((com.tencent.mm.plugin.sns.ui.an)localObject).dgg);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw))
              {
                localObject = ((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag()).diQ;
                localObject = af.dtu().apK((String)localObject);
                continue;
              }
              if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                localObject = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).wwP;
              }
            }
            else
            {
              if ((((p)localObject).dxs() == null) || (!((p)localObject).dxs().dvm()))
              {
                AppMethodBeat.o(100205);
                return false;
              }
              b.this.xTt.a(paramAnonymousView, ((p)localObject).dxX(), ((p)localObject).dxy());
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
    this.xTM = new c()
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
          paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.storage.h.apJ(((BaseTimeLineItem.BaseViewHolder)paramAnonymousContextMenuInfo).dpC);
        }
        for (;;)
        {
          Object localObject;
          com.tencent.mm.plugin.sns.storage.a locala;
          if (com.tencent.mm.bs.d.axB("favorite"))
          {
            localObject = paramAnonymousContextMenuInfo.dxs();
            locala = b.a(b.this, paramAnonymousContextMenuInfo);
            if (((com.tencent.mm.plugin.sns.storage.b)localObject).dvl())
            {
              if (!((com.tencent.mm.plugin.sns.storage.b)localObject).dvh()) {
                break label192;
              }
              paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
          for (;;)
          {
            localObject = new dx();
            ((dx)localObject).dgp.dgg = paramAnonymousContextMenuInfo.dxX();
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            if (((dx)localObject).dgq.dfO) {
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
            if (locala.wRT == 0) {
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
          label222:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean eM(View paramAnonymousView)
      {
        AppMethodBeat.i(100207);
        Object localObject;
        if (((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) || ((paramAnonymousView.getTag() instanceof p)))
        {
          localObject = paramAnonymousView.getTag();
          if ((localObject instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject = com.tencent.mm.plugin.sns.storage.h.apJ(((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dpC);
          }
        }
        for (;;)
        {
          if (localObject != null) {
            b.this.xTt.a(paramAnonymousView, ((p)localObject).dxX(), ((p)localObject).dxy());
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
    this.xTI = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100209);
        if ((paramAnonymousView.getTag() instanceof s)) {
          b.this.xTN.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
        }
        AppMethodBeat.o(100209);
      }
      
      public final boolean eM(View paramAnonymousView)
      {
        AppMethodBeat.i(100210);
        if ((paramAnonymousView.getTag() instanceof s))
        {
          String str = ((s)paramAnonymousView.getTag()).dgg;
          p localp = af.dtu().apK(str);
          b.this.xTt.a(paramAnonymousView, str, localp.dxy());
          AppMethodBeat.o(100210);
          return true;
        }
        AppMethodBeat.o(100210);
        return false;
      }
    };
    this.xTH = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100211);
        int j;
        int i;
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw)))
        {
          paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag()).diQ;
          p localp = af.dtu().apK(paramAnonymousContextMenuInfo);
          if (com.tencent.mm.bs.d.axB("favorite"))
          {
            paramAnonymousContextMenu.add(0, 2, 0, b.this.activity.getString(2131761941));
            dx localdx = new dx();
            localdx.dgp.dgg = paramAnonymousContextMenuInfo;
            com.tencent.mm.sdk.b.a.ESL.l(localdx);
            if (localdx.dgq.dfO) {
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
      
      public final boolean eM(View paramAnonymousView)
      {
        AppMethodBeat.i(100212);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag()).diQ;
          p localp = af.dtu().apK(str);
          b.this.xTt.a(paramAnonymousView, str, localp.dxy());
          AppMethodBeat.o(100212);
          return true;
        }
        AppMethodBeat.o(100212);
        return false;
      }
    };
    this.xTK = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(100214);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if ((paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.aw)) {
          paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousContextMenuInfo).diQ;
        }
        for (;;)
        {
          if (paramAnonymousContextMenuInfo != null)
          {
            paramAnonymousContextMenuInfo = af.dtu().apK(paramAnonymousContextMenuInfo);
            TimeLineObject localTimeLineObject = paramAnonymousContextMenuInfo.dxy();
            if (com.tencent.mm.bs.d.axB("favorite")) {
              switch (localTimeLineObject.Etm.DaB)
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
            paramAnonymousContextMenuInfo = ((s)paramAnonymousContextMenuInfo).dgg;
            break;
            paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(2131761941));
          }
          label158:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean eM(View paramAnonymousView)
      {
        AppMethodBeat.i(100213);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof com.tencent.mm.plugin.sns.ui.aw)) {
          localObject = ((com.tencent.mm.plugin.sns.ui.aw)localObject).diQ;
        }
        for (;;)
        {
          if (localObject != null)
          {
            p localp = af.dtu().apK((String)localObject);
            b.this.xTt.a(paramAnonymousView, (String)localObject, localp.dxy());
            AppMethodBeat.o(100213);
            return true;
            if ((localObject instanceof s)) {
              localObject = ((s)localObject).dgg;
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
    this.xno = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100215);
        Object localObject1 = null;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw)) {
          localObject1 = ((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag()).diQ;
        }
        Object localObject2;
        for (;;)
        {
          localObject2 = com.tencent.mm.plugin.sns.storage.h.apK((String)localObject1);
          if (localObject2 != null) {
            break;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(localObject1)));
          AppMethodBeat.o(100215);
          return;
          if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
            localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).dgg;
          } else if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
            localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).wwP.dxX();
          }
        }
        if ((((p)localObject2).Nb(32)) && (((p)localObject2).dxs() != null) && ((((p)localObject2).dxs().dvm()) || (((p)localObject2).dxs().dvn())))
        {
          b.this.xUd.onClick(paramAnonymousView);
          AppMethodBeat.o(100215);
          return;
        }
        if (((p)localObject2).dxy().Etm.DaB == 21)
        {
          if (u.aqG().equals(((p)localObject2).field_userName))
          {
            ((p)localObject2).dxy();
            com.tencent.mm.plugin.sns.lucky.a.m.p((p)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.m.o((p)localObject2);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.lI(25);
          }
          if (!u.aqG().equals(((p)localObject2).field_userName))
          {
            com.tencent.mm.plugin.sns.lucky.b.a.a(2, (p)localObject2);
            com.tencent.mm.plugin.sns.lucky.a.b.lI(30);
          }
        }
        int i;
        Object localObject3;
        if (((p)localObject2).Nb(32))
        {
          b.a(b.this, (p)localObject2);
          if ((((p)localObject2).dxs().dvh()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(((p)localObject2).dyh().field_adxml)))
          {
            localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.G((p)localObject2);
            if (!bt.isNullOrNil((String)localObject1)) {
              ((p)localObject2).dyh().field_adxml = ((String)localObject1);
            }
            int j = b.this.dep;
            if (b.this.dep == 0)
            {
              i = 1;
              localObject1 = new SnsAdClick(j, i, ((p)localObject2).field_snsId, 21, 21);
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject1, b.this.xwT, (p)localObject2, 21);
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
              ((Intent)localObject1).putExtra("sns_landing_pages_rawSnsId", ((p)localObject2).dxy().Id);
              ((Intent)localObject1).putExtra("sns_landing_pages_ux_info", ((p)localObject2).dyg());
              ((Intent)localObject1).putExtra("sns_landing_pages_aid", ((p)localObject2).dyc());
              ((Intent)localObject1).putExtra("sns_landing_pages_traceid", ((p)localObject2).dyd());
              localObject3 = ((p)localObject2).dxy();
              if (localObject3 != null)
              {
                localObject3 = ((TimeLineObject)localObject3).Etm.DaC;
                if (((List)localObject3).size() > 0)
                {
                  ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((bpi)((List)localObject3).get(0)).DMQ);
                  ((Intent)localObject1).putExtra("sns_landing_pages_from_outer_index", ((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag()).index);
                }
              }
              ((Intent)localObject1).setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
              if (b.this.dep != 2) {
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
          ((Intent)localObject1).putExtra("sns_landing_pages_xml", ((p)localObject2).dyh().field_adxml);
          ((Intent)localObject1).putExtra("sns_landing_pages_rec_src", ((p)localObject2).dyi());
          ((Intent)localObject1).putExtra("sns_landing_pages_xml_prefix", "adxml");
          ((Intent)localObject1).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
          ((Intent)localObject1).putExtra("sns_landing_pages_is_normal_ad_animation", true);
          localObject3 = b.this.activity;
          localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject3).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject3, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$17", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          b.this.activity.overridePendingTransition(0, 0);
          if (b.this.xlD != null) {
            b.this.xlD.dsZ().C((p)localObject2);
          }
          label839:
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag();
          if ((paramAnonymousView.xvU) && (localObject2 != null))
          {
            com.tencent.mm.plugin.sns.ui.a.c.f((p)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.ui.a.c.g((p)localObject2, paramAnonymousView.index);
            com.tencent.mm.plugin.sns.model.ay.aoQ(((p)localObject2).dxX());
          }
          if (localObject2 != null)
          {
            localObject1 = ((p)localObject2).dxy();
            if (localObject1 != null) {
              if (((TimeLineObject)localObject1).Etl != null) {
                break label1009;
              }
            }
          }
          label971:
          label1009:
          for (paramAnonymousView = null;; paramAnonymousView = ((TimeLineObject)localObject1).Etl.Id)
          {
            if (!bt.isNullOrNil(paramAnonymousView))
            {
              localObject2 = com.tencent.mm.plugin.sns.d.a.hYu.eL(paramAnonymousView);
              com.tencent.mm.plugin.sns.d.a.hYu.a(null, paramAnonymousView, (String)localObject2, ((TimeLineObject)localObject1).mAQ, 2, 4, 4, ((TimeLineObject)localObject1).Etq, ((TimeLineObject)localObject1).Id);
            }
            AppMethodBeat.o(100215);
            return;
            i = 2;
            break;
            if (b.this.dep != 1) {
              break label1021;
            }
            i = 2;
            break label639;
            b.this.dE(paramAnonymousView);
            break label839;
            b.this.dE(paramAnonymousView);
            break label839;
          }
          label1021:
          i = 1;
        }
      }
    };
    this.xTx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100216);
        paramAnonymousView.getTag();
        b.this.dE(paramAnonymousView);
        AppMethodBeat.o(100216);
      }
    };
    this.xTy = new View.OnClickListener()
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
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymous2DialogInterface)));
            p localp = af.dtu().apK(paramAnonymous2DialogInterface);
            if (localp == null)
            {
              com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", new Object[] { paramAnonymous2DialogInterface });
              AppMethodBeat.o(100217);
              return;
            }
            Object localObject2;
            if (localp.dxZ())
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "dead item");
              af.dtu().Nf(localp.xiB);
              if (b.this.xUe != null) {
                b.this.xUe.dCb();
              }
              if (b.this.dep == 0)
              {
                localObject1 = com.tencent.mm.modelsns.d.oE(739);
                localObject2 = ((com.tencent.mm.modelsns.d)localObject1).zi(com.tencent.mm.plugin.sns.data.q.l(localp)).oH(localp.field_type);
                if (!localp.dxZ()) {
                  break label234;
                }
                paramAnonymous2DialogInterface = "2";
              }
              for (;;)
              {
                ((com.tencent.mm.modelsns.d)localObject2).zi(paramAnonymous2DialogInterface);
                ((com.tencent.mm.modelsns.d)localObject1).aBj();
                if (localp.field_type == 21) {
                  com.tencent.mm.plugin.sns.lucky.a.g.dsq().dss();
                }
                AppMethodBeat.o(100217);
                return;
                localObject1 = com.tencent.mm.modelsns.d.oF(739);
                break;
                label234:
                if (localp.field_snsId == 0L) {
                  paramAnonymous2DialogInterface = "1";
                } else {
                  paramAnonymous2DialogInterface = "0";
                }
              }
            }
            if (localp.dtd())
            {
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "cancel item " + localp.dxX());
              af.dtq().z(localp);
              b.this.dyQ();
              AppMethodBeat.o(100217);
              return;
            }
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "delete by server");
            paramAnonymous2DialogInterface = localp.getSnsId();
            af.dtt().sL(x.anz(paramAnonymous2DialogInterface));
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.sns.model.q(x.anz(paramAnonymous2DialogInterface), 1), 0);
            af.dtu().delete(x.anz(paramAnonymous2DialogInterface));
            af.dtz().tc(x.anz(paramAnonymous2DialogInterface));
            com.tencent.mm.plugin.sns.storage.i.tb(x.anz(paramAnonymous2DialogInterface));
            b.this.dyQ();
            Object localObject1 = localp.dxy();
            if (localObject1 != null)
            {
              if (((TimeLineObject)localObject1).Etl != null) {
                break label580;
              }
              paramAnonymous2DialogInterface = null;
              if ((!bt.isNullOrNil(paramAnonymous2DialogInterface)) && (com.tencent.mm.plugin.sns.d.a.hYu.eN(paramAnonymous2DialogInterface)))
              {
                localObject2 = com.tencent.mm.plugin.sns.d.a.hYu.eL(paramAnonymous2DialogInterface);
                qh localqh = new qh();
                localqh.dvO.appId = paramAnonymous2DialogInterface;
                localqh.dvO.dvQ = ((TimeLineObject)localObject1).mAQ;
                localqh.dvO.dvP = ((String)localObject2);
                localqh.dvO.mediaTagName = ((TimeLineObject)localObject1).Etq;
                com.tencent.mm.sdk.b.a.ESL.l(localqh);
              }
            }
            if (b.this.dep == 0)
            {
              localObject1 = com.tencent.mm.modelsns.d.oE(739);
              label532:
              localObject2 = ((com.tencent.mm.modelsns.d)localObject1).zi(com.tencent.mm.plugin.sns.data.q.l(localp)).oH(localp.field_type);
              if (!localp.dxZ()) {
                break label601;
              }
              paramAnonymous2DialogInterface = "2";
            }
            for (;;)
            {
              ((com.tencent.mm.modelsns.d)localObject2).zi(paramAnonymous2DialogInterface);
              ((com.tencent.mm.modelsns.d)localObject1).aBj();
              AppMethodBeat.o(100217);
              return;
              label580:
              paramAnonymous2DialogInterface = ((TimeLineObject)localObject1).Etl.Id;
              break;
              localObject1 = com.tencent.mm.modelsns.d.oF(739);
              break label532;
              label601:
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
    this.xTz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100220);
        paramAnonymousView = (String)paramAnonymousView.getTag();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(paramAnonymousView)));
        paramAnonymousView = af.dtu().apK(paramAnonymousView).dxy();
        com.tencent.mm.protocal.protobuf.ay localay = paramAnonymousView.wLl;
        if (localay.CuY == null)
        {
          AppMethodBeat.o(100220);
          return;
        }
        String str = com.tencent.mm.plugin.sns.d.a.hYu.eL(localay.CuY.hnC);
        int i = 0;
        if (paramAnonymousView.Etm.DaB == 1) {
          i = 2;
        }
        while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(paramAnonymousView, b.this.activity))
        {
          com.tencent.mm.plugin.sns.d.a.hYu.a(b.this.activity, localay.CuY.hnC, str, paramAnonymousView.mAQ, i, 11, 9, localay.CuY.CuS, paramAnonymousView.Id);
          AppMethodBeat.o(100220);
          return;
          if (paramAnonymousView.Etm.DaB == 3) {
            i = 5;
          } else if (paramAnonymousView.Etm.DaB == 15) {
            i = 38;
          }
        }
        switch (localay.mBH)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(100220);
          return;
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", localay.Url);
          com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject, b.this.activity);
          com.tencent.mm.plugin.sns.d.a.hYu.a(b.this.activity, localay.CuY.hnC, str, paramAnonymousView.mAQ, i, 11, 1, localay.CuY.CuS, paramAnonymousView.Id);
          AppMethodBeat.o(100220);
          return;
          if (localay.Scene == 1)
          {
            localObject = new ho();
            ((ho)localObject).dlk.actionCode = 2;
            ((ho)localObject).dlk.scene = 3;
            ((ho)localObject).dlk.appId = localay.CuY.hnC;
            ((ho)localObject).dlk.context = b.this.activity;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            com.tencent.mm.plugin.sns.d.a.hYu.a(b.this.activity, localay.CuY.hnC, str, paramAnonymousView.mAQ, i, 11, 6, localay.CuY.CuS, paramAnonymousView.Id);
            AppMethodBeat.o(100220);
            return;
            int j = ai.a(b.this.activity, localay);
            if (j == 1)
            {
              localObject = new ho();
              ((ho)localObject).dlk.context = b.this.activity;
              ((ho)localObject).dlk.actionCode = 2;
              ((ho)localObject).dlk.appId = localay.CuY.hnC;
              ((ho)localObject).dlk.messageAction = localay.CuY.CuU;
              ((ho)localObject).dlk.messageExt = localay.CuY.CuT;
              ((ho)localObject).dlk.scene = 3;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
              com.tencent.mm.plugin.sns.d.a.hYu.a(b.this.activity, localay.CuY.hnC, str, paramAnonymousView.mAQ, i, 11, 6, localay.CuY.CuS, paramAnonymousView.Id);
              AppMethodBeat.o(100220);
              return;
            }
            if (j == 2)
            {
              localObject = new ho();
              ((ho)localObject).dlk.context = b.this.activity;
              ((ho)localObject).dlk.actionCode = 1;
              ((ho)localObject).dlk.appId = localay.CuY.hnC;
              ((ho)localObject).dlk.messageAction = localay.CuY.CuU;
              ((ho)localObject).dlk.messageExt = localay.CuY.CuT;
              ((ho)localObject).dlk.scene = 3;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
              com.tencent.mm.plugin.sns.d.a.hYu.a(b.this.activity, localay.CuY.hnC, str, paramAnonymousView.mAQ, i, 11, 3, localay.CuY.CuS, paramAnonymousView.Id);
            }
          }
        }
      }
    };
    this.xTF = new View.OnClickListener()
    {
      private static void aqP(String paramAnonymousString)
      {
        AppMethodBeat.i(100222);
        long l = af.dtu().apK(paramAnonymousString).field_snsId;
        Object localObject1 = af.dtu().th(l);
        if (localObject1 != null)
        {
          Object localObject2 = ((p)localObject1).dxy();
          if (localObject2 != null)
          {
            localObject2 = ((TimeLineObject)localObject2).Etm.DaC;
            if (((List)localObject2).size() > 0) {
              ((List)localObject2).get(0);
            }
          }
          localObject2 = com.tencent.mm.plugin.sns.model.aj.t((p)localObject1);
          localObject1 = new ArrayList();
          localObject2 = ((SnsObject)localObject2).SnsRedEnvelops.Enk;
          if (localObject2 != null)
          {
            int i = 0;
            while (i < ((List)localObject2).size())
            {
              cux localcux = (cux)((List)localObject2).get(i);
              com.tencent.mm.plugin.l.a.a locala = new com.tencent.mm.plugin.l.a.a();
              locala.kGt = localcux.Username;
              locala.sXF = localcux.CreateTime;
              locala.sXG = localcux.Emd;
              ((List)localObject1).add(locala);
              i += 1;
            }
          }
          com.tencent.mm.plugin.l.a.u(paramAnonymousString, (List)localObject1);
        }
        AppMethodBeat.o(100222);
      }
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100221);
        if ((paramAnonymousView.getTag() instanceof p))
        {
          paramAnonymousView = (p)paramAnonymousView.getTag();
          if ((paramAnonymousView.field_type == 21) && (u.aqG().equals(paramAnonymousView.field_userName)))
          {
            paramAnonymousView.dxy();
            com.tencent.mm.plugin.sns.lucky.a.m.p(paramAnonymousView);
            com.tencent.mm.plugin.sns.lucky.a.m.o(paramAnonymousView);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.lI(24);
          }
          Object localObject2 = new Intent();
          ((Intent)localObject2).putExtra("key_sendid", paramAnonymousView.getSnsId());
          ((Intent)localObject2).putExtra("key_feedid", paramAnonymousView.dxX());
          ((Intent)localObject2).setClassName(b.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
          Object localObject1 = b.this.activity;
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localObject1 = paramAnonymousView.dxX();
          paramAnonymousView.getSnsId();
          aqP((String)localObject1);
        }
        AppMethodBeat.o(100221);
      }
    };
    this.xTA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100223);
        b.this.ey(paramAnonymousView);
        AppMethodBeat.o(100223);
      }
    };
    this.xTB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100224);
        b.this.eB(paramAnonymousView);
        AppMethodBeat.o(100224);
      }
    };
    this.xTC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100225);
        if ((paramAnonymousView.getTag() instanceof String))
        {
          paramAnonymousView = (String)paramAnonymousView.getTag();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(paramAnonymousView)));
          com.tencent.mm.plugin.sns.model.aj.Mp(x.aqg(paramAnonymousView));
          com.tencent.mm.plugin.sns.model.aj.Mn(x.aqg(paramAnonymousView));
          af.dtq().drS();
          b.this.dyQ();
          if (b.this.xUe != null) {
            b.this.xUe.dCb();
          }
        }
        AppMethodBeat.o(100225);
      }
    };
    this.xTD = new b.18(this);
    this.xTG = new c()
    {
      private static boolean c(com.tencent.mm.plugin.sns.ui.m paramAnonymousm)
      {
        AppMethodBeat.i(100227);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (paramAnonymousm != null)
        {
          bool1 = bool2;
          if (paramAnonymousm.wFh != null)
          {
            bool1 = bool2;
            if (!bt.gL(paramAnonymousm.wFh.Emf)) {
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
          if (((!com.tencent.mm.plugin.sns.ui.widget.e.hA(paramAnonymousView.wFh.Eme, 16)) || (paramAnonymousView.scene == 2)) && (!c(paramAnonymousView))) {
            paramAnonymousContextMenu.add(0, 11, 0, b.this.activity.getString(2131755701));
          }
          if ((paramAnonymousView.mAQ != null) && (paramAnonymousView.mAQ.equals(u.aqG()))) {
            paramAnonymousContextMenu.add(0, 7, 0, b.this.activity.getString(2131755707));
          }
          if ((!com.tencent.mm.plugin.sns.ui.widget.e.hA(paramAnonymousView.wFh.Eme, 16)) && (!c(paramAnonymousView)))
          {
            paramAnonymousContextMenuInfo = paramAnonymousView.xlP;
            StringBuilder localStringBuilder = new StringBuilder();
            if (paramAnonymousView.wFh.Ema != 0)
            {
              l = paramAnonymousView.wFh.Ema;
              paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.ap.iG(paramAnonymousContextMenuInfo, l);
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
          paramAnonymousView = com.tencent.mm.plugin.sns.model.ap.aoL(paramAnonymousContextMenuInfo);
          if ((paramAnonymousView != null) && (paramAnonymousView.gPQ) && (!paramAnonymousView.aEj) && ((i & paramAnonymousView.evt) != 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label285;
            }
            com.tencent.mm.plugin.sns.model.ap.a(paramAnonymousContextMenu, false);
            AppMethodBeat.o(100228);
            return;
            l = paramAnonymousView.wFh.Emc;
            break;
            label265:
            if (paramAnonymousView.scene != 2) {
              break label296;
            }
            i = 4;
            break label201;
          }
          label285:
          com.tencent.mm.plugin.sns.model.ap.b(paramAnonymousContextMenu, false);
          AppMethodBeat.o(100228);
          return;
          label296:
          i = -1;
        }
      }
      
      public final boolean eM(View paramAnonymousView)
      {
        AppMethodBeat.i(100229);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m))
        {
          Object localObject = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          localObject = af.dtu().apJ(((com.tencent.mm.plugin.sns.ui.m)localObject).xlP);
          b.this.xTt.a(paramAnonymousView, ((p)localObject).dxX(), ((p)localObject).dxy());
          AppMethodBeat.o(100229);
          return true;
        }
        AppMethodBeat.o(100229);
        return false;
      }
    };
    this.rFq = new b.20(this);
    this.xTO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100231);
        if ((paramAnonymousView.getTag() instanceof ba))
        {
          paramAnonymousView = (ba)paramAnonymousView.getTag();
          Object localObject = af.dtu().apJ(paramAnonymousView.dpC);
          if (localObject == null)
          {
            AppMethodBeat.o(100231);
            return;
          }
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("sns_text_show", ((p)localObject).dxy().Etj);
          paramAnonymousView.putExtra("sns_local_id", ((p)localObject).dxX());
          paramAnonymousView.setClass(b.this.activity, SnsSingleTextViewUI.class);
          localObject = b.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$28", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject).startActivity((Intent)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$28", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(100231);
      }
    };
    this.xTR = new View.OnClickListener()
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
          localObject2 = (bpi)locals.xmh.Etm.DaC.get(0);
          localObject1 = locals.dgg;
          af.dtu().apJ((String)localObject1);
          localObject1 = "";
          localObject3 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject2).Id);
          str1 = "";
          String str2 = com.tencent.mm.plugin.sns.data.q.i((bpi)localObject2);
          if (com.tencent.mm.vfs.i.eK((String)localObject3 + str2))
          {
            localObject1 = (String)localObject3 + str2;
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.q.d((bpi)localObject2);
          }
          if (com.tencent.mm.vfs.i.eK((String)localObject3 + com.tencent.mm.plugin.sns.data.q.o((bpi)localObject2)))
          {
            localObject1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.q.o((bpi)localObject2);
            str1 = (String)localObject3 + com.tencent.mm.plugin.sns.data.q.m((bpi)localObject2);
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
          paramAnonymousView.putExtra("intent_localid", locals.dgg);
          paramAnonymousView.putExtra("intent_isad", false);
          paramAnonymousView.putExtra("intent_from_scene", b.this.dep);
          paramAnonymousView.putExtra("img_gallery_left", localObject2[0]);
          paramAnonymousView.putExtra("img_gallery_top", localObject2[1]);
          paramAnonymousView.putExtra("img_gallery_width", i);
          paramAnonymousView.putExtra("img_gallery_height", j);
          localObject1 = b.this.activity;
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Activity)localObject1).startActivity((Intent)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          b.this.activity.overridePendingTransition(0, 0);
          b.a(b.this, locals.xmh);
          AppMethodBeat.o(100232);
          return;
          label491:
          paramAnonymousView.getLocationInWindow((int[])localObject2);
          i = paramAnonymousView.getWidth();
        }
      }
    };
    this.xTQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100239);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "onsight click");
        Object localObject1;
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) {
          localObject1 = (com.tencent.mm.plugin.sns.ui.an)paramAnonymousView.getTag();
        }
        for (;;)
        {
          final p localp = af.dtu().apK(((com.tencent.mm.plugin.sns.ui.an)localObject1).dgg);
          if (localp == null)
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "onsight click but info is null localid %s", new Object[] { ((com.tencent.mm.plugin.sns.ui.an)localObject1).dgg });
            AppMethodBeat.o(100239);
            return;
            if ((paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
            {
              localObject1 = ((BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag()).xOO;
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
              localObject1 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).xOO;
            }
          }
          else
          {
            if (b.this.xlD != null) {
              b.this.xlD.dsZ().C(localp);
            }
            final boolean bool = localp.Nb(32);
            if ((bool) && (localp.dxs() != null) && ((localp.dxs().dvm()) || (localp.dxs().dvn())))
            {
              b.this.xUd.onClick(paramAnonymousView);
              AppMethodBeat.o(100239);
              return;
            }
            final TimeLineObject localTimeLineObject = ((com.tencent.mm.plugin.sns.ui.an)localObject1).xsl;
            if ((localTimeLineObject.Etm.DaC == null) || (localTimeLineObject.Etm.DaC.size() == 0))
            {
              com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
              AppMethodBeat.o(100239);
              return;
            }
            final bpi localbpi = (bpi)localTimeLineObject.Etm.DaC.get(0);
            if (bool)
            {
              af.dtr();
              if (!com.tencent.mm.plugin.sns.model.f.t(localbpi))
              {
                ((com.tencent.mm.plugin.sns.ui.an)localObject1).xbT.setVisibility(8);
                ((com.tencent.mm.plugin.sns.ui.an)localObject1).xsq.setVisibility(0);
                ((com.tencent.mm.plugin.sns.ui.an)localObject1).xsq.feJ();
                af.dtr().z(localbpi);
                paramAnonymousView = af.dtp();
                localObject1 = bc.eLL();
                ((bc)localObject1).tGD = localTimeLineObject.CreateTime;
                paramAnonymousView.a(localbpi, 4, null, (bc)localObject1);
                if (bool) {
                  com.tencent.mm.plugin.sns.a.b.m.a(m.b.wzb, m.a.wyS, localp, b.this.dep);
                }
                AppMethodBeat.o(100239);
                return;
              }
            }
            if ((localp.Nb(32)) && (localp.dxs().dvh()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(localp.dyh().field_adxml))) {}
            int j;
            Object localObject3;
            for (int i = 1; (i == 0) && (bool) && (af.dtr().u(localbpi)); i = 0)
            {
              af.dtr().z(localbpi);
              ((com.tencent.mm.plugin.sns.ui.an)localObject1).xbT.setVisibility(8);
              ((com.tencent.mm.plugin.sns.ui.an)localObject1).xsq.setVisibility(8);
              paramAnonymousView = af.dtr();
              localObject2 = ((com.tencent.mm.plugin.sns.ui.an)localObject1).xsn;
              i = b.this.activity.hashCode();
              j = ((com.tencent.mm.plugin.sns.ui.an)localObject1).position;
              localObject3 = bc.eLL();
              ((bc)localObject3).tGD = localTimeLineObject.CreateTime;
              paramAnonymousView.a(localp, localbpi, (VideoSightView)localObject2, i, j, (bc)localObject3, bool);
              ((com.tencent.mm.plugin.sns.ui.an)localObject1).xsn.start();
              if (bool) {
                com.tencent.mm.plugin.sns.a.b.m.a(m.b.wzb, m.a.wyS, localp, b.this.dep);
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
            if (b.this.dep == 0)
            {
              localObject2 = com.tencent.mm.modelsns.d.oE(717);
              ((com.tencent.mm.modelsns.d)localObject2).zi(com.tencent.mm.plugin.sns.data.q.l(localp)).oH(localp.field_type).ew(localp.Nb(32)).zi(localp.dyg()).zi(localbpi.Id);
              ((com.tencent.mm.modelsns.d)localObject2).aBj();
              if (b.this.dep != 0) {
                break label1448;
              }
              locald = com.tencent.mm.modelsns.d.oE(745);
              locald.zi(com.tencent.mm.plugin.sns.data.q.l(localp)).oH(localp.field_type).ew(localp.Nb(32));
              if (bool)
              {
                m = b.this.dep;
                if (b.this.dep != 0) {
                  break label1459;
                }
                i = 1;
                long l = localp.field_snsId;
                if (!localp.dxs().dvh()) {
                  break label1464;
                }
                j = 21;
                if (!localp.dxs().dvh()) {
                  break label1470;
                }
                k = 21;
                label753:
                localObject2 = new SnsAdClick(m, i, l, j, k);
                if (!localp.dxs().dvh()) {
                  break label1476;
                }
                com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, b.this.xwT, localp, 21);
              }
            }
            Object localObject4;
            for (;;)
            {
              com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject2);
              if ((!localp.dxs().dvh()) || (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(localp.dyh().field_adxml))) {
                com.tencent.mm.plugin.sns.a.b.m.a(m.b.wzb, m.a.wyT, localp, b.this.dep);
              }
              localObject2 = "";
              localObject4 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), localbpi.Id);
              localObject3 = "";
              String str = com.tencent.mm.plugin.sns.data.q.i(localbpi);
              if (com.tencent.mm.vfs.i.eK((String)localObject4 + str))
              {
                localObject2 = (String)localObject4 + str;
                localObject3 = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.d(localbpi);
              }
              if (com.tencent.mm.vfs.i.eK((String)localObject4 + com.tencent.mm.plugin.sns.data.q.o(localbpi)))
              {
                localObject2 = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.o(localbpi);
                localObject3 = (String)localObject4 + com.tencent.mm.plugin.sns.data.q.m(localbpi);
              }
              localObject4 = new int[2];
              paramAnonymousView.getLocationInWindow((int[])localObject4);
              i = paramAnonymousView.getWidth();
              j = paramAnonymousView.getHeight();
              com.tencent.mm.plugin.report.service.h.vKh.f(11444, new Object[] { Integer.valueOf(3) });
              if (bool) {
                break label1495;
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
              paramAnonymousView = new Intent();
              paramAnonymousView.setClass(b.this.activity, SnsOnlineVideoActivity.class);
              paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
              paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
              paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.an)localObject1).dgg);
              paramAnonymousView.putExtra("intent_isad", bool);
              paramAnonymousView.putExtra("intent_from_scene", b.this.dep);
              paramAnonymousView.putExtra("sns_video_scene", ((com.tencent.mm.plugin.sns.ui.an)localObject1).xss);
              localObject2 = com.tencent.mm.plugin.sns.ui.video.d.dDS().aqT(localTimeLineObject.Id);
              if ((localObject2 != null) && (((SnsTimelineVideoView)localObject2).isPlaying()))
              {
                paramAnonymousView.putExtra("intent_fromplayingvideo", true);
                paramAnonymousView.putExtra("intent_fromplayingvideo_tlobjid", localTimeLineObject.Id);
                paramAnonymousView.putExtra("intent_session_id", ((SnsTimelineVideoView)localObject2).getSessionId());
                paramAnonymousView.putExtra("intent_session_timestamp", ((SnsTimelineVideoView)localObject2).getSessionTimestamp());
                if (((com.tencent.mm.plugin.sns.ui.an)localObject1).xsm != null) {
                  ((com.tencent.mm.plugin.sns.ui.an)localObject1).xsm.findViewById(2131305799).setVisibility(0);
                }
              }
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              locald.b(paramAnonymousView, "intent_key_StatisticsOplog");
              localObject1 = b.this.activity;
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Activity)localObject1).startActivity((Intent)paramAnonymousView.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              b.this.activity.overridePendingTransition(0, 0);
              b.a(b.this, localp.dxy());
              AppMethodBeat.o(100239);
              return;
              localObject2 = com.tencent.mm.modelsns.d.oF(717);
              break;
              label1448:
              locald = com.tencent.mm.modelsns.d.oF(745);
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
              com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject2, b.this.xwT, localp, 17);
            }
            label1495:
            if ((localp.Nb(32)) && (localp.dxs().dvh()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.apF(localp.dyh().field_adxml)))
            {
              paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.G(localp);
              if (!bt.isNullOrNil(paramAnonymousView)) {
                localp.dyh().field_adxml = paramAnonymousView;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
              paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
              paramAnonymousView.putExtra("img_gallery_width", i);
              paramAnonymousView.putExtra("img_gallery_height", j);
              paramAnonymousView.putExtra("sns_landing_pages_share_sns_id", localp.getSnsId());
              paramAnonymousView.putExtra("sns_landing_pages_rawSnsId", localp.dxy().Id);
              paramAnonymousView.putExtra("sns_landing_pages_ux_info", localp.dyg());
              localObject1 = localp.dxy();
              if (localObject1 != null)
              {
                localObject1 = ((TimeLineObject)localObject1).Etm.DaC;
                if (((List)localObject1).size() > 0) {
                  paramAnonymousView.putExtra("sns_landing_pages_share_thumb_url", ((bpi)((List)localObject1).get(0)).DMQ);
                }
              }
              paramAnonymousView.setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
              i = 1;
              if (b.this.dep == 2) {
                i = 16;
              }
              for (;;)
              {
                paramAnonymousView.putExtra("sns_landig_pages_from_source", i);
                paramAnonymousView.putExtra("sns_landing_pages_xml", localp.dyh().field_adxml);
                paramAnonymousView.putExtra("sns_landing_pages_rec_src", localp.dyi());
                paramAnonymousView.putExtra("sns_landing_pages_xml_prefix", "adxml");
                paramAnonymousView.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                paramAnonymousView.putExtra("sns_landing_pages_is_normal_ad_animation", true);
                paramAnonymousView.putExtra("sns_landing_is_native_sight_ad", true);
                localObject1 = b.this.activity;
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, paramAnonymousView.adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Activity)localObject1).startActivity((Intent)paramAnonymousView.lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                b.this.activity.overridePendingTransition(0, 0);
                AppMethodBeat.o(100239);
                return;
                if (b.this.dep == 1) {
                  i = 2;
                }
              }
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.setClass(b.this.activity, SnsSightPlayerUI.class);
            paramAnonymousView.putExtra("intent_videopath", (String)localObject2);
            paramAnonymousView.putExtra("intent_thumbpath", (String)localObject3);
            paramAnonymousView.putExtra("intent_localid", ((com.tencent.mm.plugin.sns.ui.an)localObject1).dgg);
            paramAnonymousView.putExtra("intent_isad", bool);
            paramAnonymousView.putExtra("intent_from_scene", b.this.dep);
            paramAnonymousView.putExtra("img_gallery_left", localObject4[0]);
            paramAnonymousView.putExtra("img_gallery_top", localObject4[1]);
            paramAnonymousView.putExtra("img_gallery_width", i);
            paramAnonymousView.putExtra("img_gallery_height", j);
            locald.b(paramAnonymousView, "intent_key_StatisticsOplog");
            Object localObject2 = b.this.activity;
            paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, paramAnonymousView.adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Activity)localObject2).startActivity((Intent)paramAnonymousView.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            b.this.activity.overridePendingTransition(0, 0);
            new com.tencent.mm.sdk.platformtools.ap().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100238);
                if (af.dtr().u(localbpi))
                {
                  this.xUr.xsn.e(null, false, 0);
                  com.tencent.mm.plugin.sns.model.f localf = af.dtr();
                  p localp = localp;
                  bpi localbpi = localbpi;
                  VideoSightView localVideoSightView = this.xUr.xsn;
                  int i = b.this.activity.hashCode();
                  int j = this.xUr.position;
                  bc localbc = bc.eLL();
                  localbc.tGD = localTimeLineObject.CreateTime;
                  localf.a(localp, localbpi, localVideoSightView, i, j, localbc, bool);
                  this.xUr.xsn.start();
                  this.xUr.xbT.setVisibility(0);
                  this.xUr.xsq.setVisibility(8);
                  this.xUr.xbT.setImageDrawable(com.tencent.mm.cd.a.l(b.this.activity, 2131691166));
                }
                AppMethodBeat.o(100238);
              }
            }, 500L);
            paramAnonymousView = new int[3];
            if ((!bool) && (af.dtr().a(localp, paramAnonymousView) > 5))
            {
              af.dtr().y(localbpi);
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
                paramAnonymousView = localp.dxy();
                localObject1 = new com.tencent.mm.modelsns.f();
                ((com.tencent.mm.modelsns.f)localObject1).o("20FeedId", paramAnonymousView.Id + ",");
                ((com.tencent.mm.modelsns.f)localObject1).o("21AdUxInfo", localp.dyg() + ",");
                for (;;)
                {
                  try
                  {
                    paramAnonymousView = (SnsObject)new SnsObject().parseFrom(localp.field_attrBuf);
                    if (paramAnonymousView.ObjectOperations == null) {
                      continue;
                    }
                    paramAnonymousView = (cvi)new cvi().parseFrom(paramAnonymousView.ObjectOperations.getBufferToBytes());
                    if (paramAnonymousView.EmU == null) {
                      continue;
                    }
                    k = paramAnonymousView.EmU.DbH;
                  }
                  catch (Exception paramAnonymousView)
                  {
                    k = 0;
                    com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.TimelineClickListener", paramAnonymousView, "", new Object[0]);
                    j = 0;
                    continue;
                    if (com.tencent.mm.sdk.platformtools.ay.is2G(com.tencent.mm.sdk.platformtools.aj.getContext()))
                    {
                      i = 2;
                      continue;
                    }
                    if (com.tencent.mm.sdk.platformtools.ay.is3G(com.tencent.mm.sdk.platformtools.aj.getContext()))
                    {
                      i = 3;
                      continue;
                    }
                    if (!com.tencent.mm.sdk.platformtools.ay.is4G(com.tencent.mm.sdk.platformtools.aj.getContext())) {
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
                    j = paramAnonymousView.EmU.DbI;
                    ((com.tencent.mm.modelsns.f)localObject1).o("22LayerId", k + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).o("23ExpId", j + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).o("24ClickState", i + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).o("25ClickTime", bt.aGK() + ",");
                    i = 0;
                    if (!com.tencent.mm.sdk.platformtools.ay.isWifi(com.tencent.mm.sdk.platformtools.aj.getContext())) {
                      continue;
                    }
                    i = 1;
                    ((com.tencent.mm.modelsns.f)localObject1).o("26NetworkType", i + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).o("27IsFlowControl", n + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).o("28AutoDownloadSetting", i1 + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).o("29IsAutoPlay", m + ",");
                    ((com.tencent.mm.modelsns.f)localObject1).o("30IsFlowControlDatePeriod", i2 + ",");
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + ((com.tencent.mm.modelsns.f)localObject1).PW());
                    com.tencent.mm.plugin.report.service.h.vKh.f(13323, new Object[] { localObject1 });
                    AppMethodBeat.o(100239);
                    return;
                  }
                  catch (Exception paramAnonymousView) {}
                }
                if ((!bool) || (af.dtr().b(localp, paramAnonymousView) <= 5)) {
                  break label2822;
                }
                af.dtr().y(localbpi);
                i = 1;
                break;
              }
            }
          }
          localObject1 = null;
        }
      }
    };
    this.xTJ = new c()
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
          if (bt.aGh(com.tencent.mm.m.g.Zd().getValue("SIGHTCannotTransmitForFav")) != 0) {
            break label308;
          }
          if (paramAnonymousView.xsl.Etm.DaC.size() <= 0) {
            break label301;
          }
          paramAnonymousContextMenuInfo = (bpi)paramAnonymousView.xsl.Etm.DaC.get(0);
          String str = paramAnonymousContextMenuInfo.Id;
          str = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), str) + com.tencent.mm.plugin.sns.data.q.d(paramAnonymousContextMenuInfo);
          paramAnonymousContextMenuInfo = at.a(paramAnonymousView.dgg, paramAnonymousContextMenuInfo);
          boolean bool1 = com.tencent.mm.vfs.i.eK(str);
          boolean bool2 = com.tencent.mm.vfs.i.eK(paramAnonymousContextMenuInfo);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if ((!bool1) || (!bool2)) {
            break label308;
          }
        }
        label301:
        label308:
        for (int i = 1;; i = 0)
        {
          if (com.tencent.mm.bs.d.axB("favorite")) {
            paramAnonymousContextMenu.add(0, 10, 0, b.this.activity.getString(2131761941));
          }
          if (i != 0)
          {
            paramAnonymousContextMenuInfo = new dx();
            paramAnonymousContextMenuInfo.dgp.dgg = paramAnonymousView.dgg;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousContextMenuInfo);
            if (paramAnonymousContextMenuInfo.dgq.dfO) {
              paramAnonymousContextMenu.add(0, 18, 0, b.this.activity.getString(2131755836));
            }
          }
          AppMethodBeat.o(100240);
          return;
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TimelineOnCreateContextMenuListener", "sight item had not attch.");
        }
      }
      
      public final boolean eM(View paramAnonymousView)
      {
        AppMethodBeat.i(100241);
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.an)paramAnonymousView.getTag()).dgg;
          p localp = af.dtu().apK(str);
          b.this.xTt.a(paramAnonymousView, str, localp.dxy());
          AppMethodBeat.o(100241);
          return true;
        }
        AppMethodBeat.o(100241);
        return false;
      }
    };
    this.xTS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100242);
        b.this.eC(paramAnonymousView);
        if ((paramAnonymousView.getTag() == null) || (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
        {
          AppMethodBeat.o(100242);
          return;
        }
        Object localObject = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
        paramAnonymousView = af.dtu().apK(((com.tencent.mm.plugin.sns.data.b)localObject).dgg);
        if (paramAnonymousView == null)
        {
          AppMethodBeat.o(100242);
          return;
        }
        int j;
        if (paramAnonymousView.Nb(32))
        {
          ((com.tencent.mm.plugin.sns.data.b)localObject).wAf = System.currentTimeMillis();
          j = b.this.dep;
          if (b.this.dep != 0) {
            break label148;
          }
        }
        label148:
        for (int i = 1;; i = 2)
        {
          localObject = new SnsAdClick(j, i, paramAnonymousView.field_snsId, 20, 0);
          com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject, b.this.xwT, paramAnonymousView, 20);
          com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject);
          AppMethodBeat.o(100242);
          return;
        }
      }
    };
    this.xTZ = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100243);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "unlike click");
        if (!(paramAnonymousAdapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c))
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
          AppMethodBeat.o(100243);
          return;
        }
        Object localObject2 = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
        p localp = af.dtu().apK(((com.tencent.mm.plugin.sns.data.b)localObject2).dgg);
        if (localp == null) {
          try
          {
            b.this.dyS();
            AppMethodBeat.o(100243);
            return;
          }
          catch (Exception paramAnonymousAdapterView)
          {
            com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "onUnLikeFinishError exp=" + paramAnonymousAdapterView.toString());
            AppMethodBeat.o(100243);
            return;
          }
        }
        Object localObject1;
        if (paramAnonymousInt == 0)
        {
          if (localp.Nb(32))
          {
            localObject1 = b.a(b.this, localp);
            if (localObject1 != null) {
              break label312;
            }
          }
          label312:
          for (localObject1 = "";; localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).dAM)
          {
            ((com.tencent.mm.plugin.sns.c.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.sns.c.d.class)).a(11855, localp.dyi(), new Object[] { Integer.valueOf(3), localObject1, Integer.valueOf(localp.dyi()) });
            if (!((com.tencent.mm.plugin.sns.data.b)localObject2).wAe.xLs.wSm.dvf()) {
              break;
            }
            paramAnonymousView = (com.tencent.mm.plugin.sns.ui.c)paramAnonymousAdapterView.getAdapter();
            paramAnonymousView.jzV += 1;
            paramAnonymousView.notifyDataSetChanged();
            paramAnonymousAdapterView.setOnItemClickListener(b.this.xUa);
            b.this.dyR();
            paramAnonymousAdapterView = new a.c.a();
            paramAnonymousAdapterView.wSD = a.c.a.wSz;
            paramAnonymousAdapterView.wAf = ((com.tencent.mm.plugin.sns.data.b)localObject2).wAf;
            paramAnonymousAdapterView.wSE = 0L;
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.q(localp.field_snsId, 8, paramAnonymousAdapterView);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousAdapterView, 0);
            AppMethodBeat.o(100243);
            return;
          }
          if (((com.tencent.mm.plugin.sns.data.b)localObject2).wAe.xLs.wSq)
          {
            AppMethodBeat.o(100243);
            return;
          }
          b.this.eD(paramAnonymousView);
          paramAnonymousAdapterView = new a.c.a();
          paramAnonymousAdapterView.wAf = ((com.tencent.mm.plugin.sns.data.b)localObject2).wAf;
          paramAnonymousAdapterView.wSE = System.currentTimeMillis();
          paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.q(localp.field_snsId, 8, paramAnonymousAdapterView);
          com.tencent.mm.kernel.g.afC();
          com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousAdapterView, 0);
          AppMethodBeat.o(100243);
          return;
        }
        if (((com.tencent.mm.plugin.sns.data.b)localObject2).wAe.xLr.wTF == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
          AppMethodBeat.o(100243);
          return;
        }
        paramAnonymousAdapterView = ((com.tencent.mm.plugin.sns.data.b)localObject2).wAe.xLr.wTF;
        paramAnonymousInt -= 1;
        if (paramAnonymousInt < paramAnonymousAdapterView.list.size()) {
          paramAnonymousAdapterView = ((com.tencent.mm.plugin.sns.storage.b.e)paramAnonymousAdapterView.list.get(paramAnonymousInt)).url;
        }
        try
        {
          paramAnonymousView = String.format("snsid=%s", new Object[] { localp.dxy().Id });
          localObject1 = String.format("aid=%s", new Object[] { localp.dyc() });
          localObject2 = String.format("traceid=%s", new Object[] { localp.dyd() });
          com.tencent.mm.kernel.g.afz();
          paramAnonymousView = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.n(paramAnonymousAdapterView, new String[] { paramAnonymousView, localObject1, localObject2, String.format("uin=%s", new Object[] { com.tencent.mm.kernel.a.aeo() }) });
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
        paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId));
        paramAnonymousView.putExtra("pre_username", localp.field_userName);
        paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(localp.field_snsId));
        paramAnonymousView.putExtra("preUsername", localp.field_userName);
        com.tencent.mm.plugin.sns.d.a.hYt.i(paramAnonymousView, b.this.activity);
        AppMethodBeat.o(100243);
      }
    };
    this.xUa = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(100244);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
        {
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
          if (paramAnonymousInt < paramAnonymousAdapterView.wAe.xLs.wSm.dve().size())
          {
            if (paramAnonymousAdapterView.wAe.xLs.wSq)
            {
              AppMethodBeat.o(100244);
              return;
            }
            a.c.a locala = (a.c.a)paramAnonymousAdapterView.wAe.xLs.wSm.dve().get(paramAnonymousInt);
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[] { locala.wSA, Integer.valueOf(locala.wSD) });
            p localp = af.dtu().apK(paramAnonymousAdapterView.dgg);
            if (localp == null)
            {
              AppMethodBeat.o(100244);
              return;
            }
            b.this.eD(paramAnonymousView);
            locala.wAf = paramAnonymousAdapterView.wAf;
            locala.wSE = System.currentTimeMillis();
            paramAnonymousAdapterView = new com.tencent.mm.plugin.sns.model.q(localp.field_snsId, 8, locala);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousAdapterView, 0);
          }
        }
        AppMethodBeat.o(100244);
      }
    };
    this.xTY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100245);
        if ((paramAnonymousView.getTag() instanceof TimeLineObject))
        {
          TimeLineObject localTimeLineObject = (TimeLineObject)paramAnonymousView.getTag();
          ald localald = localTimeLineObject.Etm.DaG;
          Intent localIntent = new Intent();
          localIntent.putExtra("feed_object_id", com.tencent.mm.plugin.sns.data.q.anR(localald.objectId));
          localIntent.putExtra("feed_object_nonceId", localald.objectNonceId);
          localIntent.putExtra("report_scene", 3);
          localIntent.putExtra("from_user", localTimeLineObject.mAQ);
          ((com.tencent.mm.plugin.i.a.j)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.j.class)).enterFinderShareFeedUI(paramAnonymousView.getContext(), localIntent);
        }
        AppMethodBeat.o(100245);
      }
    };
    this.xUd = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163130);
        if ((paramAnonymousView.getTag() == null) || ((!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) && (!(paramAnonymousView.getTag() instanceof MaskImageView)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a))))
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
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aw))
        {
          localObject3 = com.tencent.mm.plugin.sns.storage.h.apK(((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag()).diQ);
          if ((paramAnonymousView instanceof LinearLayout))
          {
            i = 0;
            if (!((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag()).xst) {
              break label4585;
            }
            k = ((com.tencent.mm.plugin.sns.ui.aw)paramAnonymousView.getTag()).index;
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
          if ((localObject3 == null) || (!((p)localObject3).Nb(32)))
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
              if (!(((MaskImageView)localObject3).getTag() instanceof com.tencent.mm.plugin.sns.ui.aw)) {
                break label4580;
              }
              localObject3 = com.tencent.mm.plugin.sns.storage.h.apK(((com.tencent.mm.plugin.sns.ui.aw)((MaskImageView)localObject3).getTag()).diQ);
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
              localObject3 = af.dtu().apK(((com.tencent.mm.plugin.sns.ui.an)localObject1).dgg);
              if ((paramAnonymousView instanceof LinearLayout))
              {
                j = 0;
                label314:
                if (!((com.tencent.mm.plugin.sns.ui.an)localObject1).xst) {
                  break label4571;
                }
                k = ((com.tencent.mm.plugin.sns.ui.an)localObject1).xsu;
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
                localObject1 = com.tencent.mm.plugin.sns.storage.h.apJ(((BaseTimeLineItem.BaseViewHolder)localObject3).dpC);
                if (!(localObject3 instanceof k.b)) {
                  break label4566;
                }
                j = ((k.b)localObject3).xSO.index;
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
                  localObject3 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).wwP;
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
                        localObject4 = ((p)localObject3).dxy().Id;
                        if (!((p)localObject3).dvv())
                        {
                          localObject5 = com.tencent.mm.plugin.report.service.h.vKh;
                          if (b.this.dep != 0) {
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
                        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "report click ad card style error " + localException.getMessage());
                        continue;
                        localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject4).xOO;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.a)paramAnonymousView.getTag()).xOO;
                        continue;
                        if (b.this.xlD == null) {
                          continue;
                        }
                        b.this.xlD.dsZ().C((p)localObject3);
                        boolean bool = ((p)localObject3).Nb(32);
                        if ((((TimeLineObject)localObject6).Etm.DaC != null) && (((TimeLineObject)localObject6).Etm.DaC.size() != 0)) {
                          continue;
                        }
                        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                        AppMethodBeat.o(163130);
                        return;
                        bpi localbpi = (bpi)((TimeLineObject)localObject6).Etm.DaC.get(k);
                        if (!bool) {
                          continue;
                        }
                        af.dtr();
                        if ((com.tencent.mm.plugin.sns.model.f.t(localbpi)) || (localObject2 == null)) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setVisibility(8);
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.setVisibility(0);
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.feJ();
                        af.dtr().z(localbpi);
                        paramAnonymousView = af.dtp();
                        localObject2 = bc.eLL();
                        ((bc)localObject2).tGD = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a(localbpi, 4, null, (bc)localObject2);
                        if (!bool) {
                          continue;
                        }
                        com.tencent.mm.plugin.sns.a.b.m.a(m.b.wzb, m.a.wyS, (p)localObject3, b.this.dep);
                        AppMethodBeat.o(163130);
                        return;
                        if ((!((p)localObject3).Nb(32)) || (!((p)localObject3).dxs().dvh())) {
                          continue;
                        }
                        String str = ((p)localObject3).dyh().field_adxml;
                        if (k <= 0) {
                          continue;
                        }
                        Object localObject5 = "adTurnCanvasInfo";
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jb(str, (String)localObject5)) {
                          continue;
                        }
                        m = 1;
                        if ((m != 0) || (!bool) || (!af.dtr().u(localbpi)) || (localObject2 == null)) {
                          continue;
                        }
                        af.dtr().z(localbpi);
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xbT.setVisibility(8);
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsq.setVisibility(8);
                        paramAnonymousView = af.dtr();
                        Object localObject4 = ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsn;
                        i = b.this.activity.hashCode();
                        j = ((com.tencent.mm.plugin.sns.ui.an)localObject2).position;
                        localObject5 = bc.eLL();
                        ((bc)localObject5).tGD = ((TimeLineObject)localObject6).CreateTime;
                        paramAnonymousView.a((p)localObject3, localbpi, (VideoSightView)localObject4, i, j, (bc)localObject5, bool);
                        ((com.tencent.mm.plugin.sns.ui.an)localObject2).xsn.start();
                        if (!bool) {
                          continue;
                        }
                        com.tencent.mm.plugin.sns.a.b.m.a(m.b.wzb, m.a.wyS, (p)localObject3, b.this.dep);
                        AppMethodBeat.o(163130);
                        return;
                        localObject5 = "adCanvasInfo";
                        continue;
                        m = 0;
                        continue;
                        if (b.this.dep != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.d.oE(717);
                        ((com.tencent.mm.modelsns.d)localObject2).zi(com.tencent.mm.plugin.sns.data.q.l((p)localObject3)).oH(((p)localObject3).field_type).ew(((p)localObject3).Nb(32)).zi(((p)localObject3).dyg()).zi(localbpi.Id);
                        ((com.tencent.mm.modelsns.d)localObject2).aBj();
                        if (b.this.dep != 0) {
                          continue;
                        }
                        localObject2 = com.tencent.mm.modelsns.d.oE(745);
                        ((com.tencent.mm.modelsns.d)localObject2).zi(com.tencent.mm.plugin.sns.data.q.l((p)localObject3)).oH(((p)localObject3).field_type).ew(((p)localObject3).Nb(32));
                        localObject2 = new int[2];
                        if (localObject4 == null) {
                          continue;
                        }
                        if (((BaseTimeLineItem.BaseViewHolder)localObject4).xOO.xsp == null) {
                          continue;
                        }
                        ((BaseTimeLineItem.BaseViewHolder)localObject4).xOO.xsp.getLocationInWindow((int[])localObject2);
                        j = ((BaseTimeLineItem.BaseViewHolder)localObject4).xOO.xsp.getWidth();
                        i = ((BaseTimeLineItem.BaseViewHolder)localObject4).xOO.xsp.getHeight();
                        com.tencent.mm.plugin.report.service.h.vKh.f(11444, new Object[] { Integer.valueOf(3) });
                        localObject4 = b.a(b.this, (p)localObject3);
                        if (!com.tencent.mm.plugin.sns.data.j.a(b.this.activity, (p)localObject3, (com.tencent.mm.plugin.sns.storage.a)localObject4, b.this.dep, b.this.xwT)) {
                          continue;
                        }
                        AppMethodBeat.o(163130);
                        return;
                        localObject2 = com.tencent.mm.modelsns.d.oF(717);
                        continue;
                        localObject2 = com.tencent.mm.modelsns.d.oF(745);
                        continue;
                        if (((TimeLineObject)localObject6).Etm.DaB != 27) {
                          continue;
                        }
                        ((k.b)localObject4).xSM.getLocationInWindow((int[])localObject2);
                        j = ((k.b)localObject4).xSM.getWidth();
                        i = ((k.b)localObject4).xSM.getHeight();
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) {
                          continue;
                        }
                        localObject4 = (com.tencent.mm.plugin.sns.ui.an)paramAnonymousView.getTag();
                        if (localObject4 == null) {
                          continue;
                        }
                        ((com.tencent.mm.plugin.sns.ui.an)localObject4).xsp.getLocationInWindow((int[])localObject2);
                        j = ((com.tencent.mm.plugin.sns.ui.an)localObject4).xsp.getWidth();
                        i = ((com.tencent.mm.plugin.sns.ui.an)localObject4).xsp.getHeight();
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
                        n = b.this.dep;
                        if (b.this.dep != 0) {
                          continue;
                        }
                        m = 1;
                        paramAnonymousView = new SnsAdClick(n, m, ((p)localObject3).field_snsId, 22, 21);
                        com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.xwT, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                        localObject4 = new Intent();
                        ((Intent)localObject4).putExtra("img_gallery_left", localObject2[0]);
                        ((Intent)localObject4).putExtra("img_gallery_top", localObject2[1]);
                        ((Intent)localObject4).putExtra("img_gallery_width", j);
                        ((Intent)localObject4).putExtra("img_gallery_height", i);
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_sns_id", ((p)localObject3).getSnsId());
                        ((Intent)localObject4).putExtra("sns_landing_pages_rawSnsId", ((p)localObject3).dxy().Id);
                        ((Intent)localObject4).putExtra("sns_landing_pages_ux_info", ((p)localObject3).dyg());
                        paramAnonymousView = ((p)localObject3).dxy();
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView = paramAnonymousView.Etm.DaC;
                        if (paramAnonymousView.size() <= k) {
                          continue;
                        }
                        ((Intent)localObject4).putExtra("sns_landing_pages_share_thumb_url", ((bpi)paramAnonymousView.get(k)).DMQ);
                        ((Intent)localObject4).setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                        i = 1;
                        if (b.this.dep != 2) {
                          continue;
                        }
                        i = 16;
                        ((Intent)localObject4).putExtra("sns_landig_pages_from_source", i);
                        if (k <= 0) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dxs().dvt();
                        ((Intent)localObject4).putExtra("sns_landing_pages_xml", paramAnonymousView);
                        ((Intent)localObject4).putExtra("sns_landing_pages_rec_src", ((p)localObject3).dyi());
                        ((Intent)localObject4).putExtra("sns_landing_pages_xml_prefix", "adxml");
                        ((Intent)localObject4).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        ((Intent)localObject4).putExtra("sns_landing_is_native_sight_ad", true);
                        paramAnonymousView = b.this.activity;
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject4);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
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
                        if (b.this.dep != 1) {
                          continue;
                        }
                        i = 2;
                        continue;
                        paramAnonymousView = ((p)localObject3).dyh().field_adxml;
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
                        j = b.this.dep;
                        if (b.this.dep != 0) {
                          continue;
                        }
                        i = 1;
                        paramAnonymousView = new SnsAdClick(j, i, ((p)localObject3).field_snsId, 22, 31);
                        com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.xwT, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a(paramAnonymousView);
                        AppMethodBeat.o(163130);
                        return;
                        bool = false;
                        continue;
                        i = 2;
                        continue;
                        j = b.this.dep;
                        if (b.this.dep != 0) {
                          continue;
                        }
                        i = 1;
                        localObject4 = new SnsAdClick(j, i, ((p)localObject3).field_snsId, 22, 0);
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, b.this.xwT, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
                        if (k <= 0) {
                          continue;
                        }
                        localObject2 = ((p)localObject3).dxs().wTC.wRX;
                        paramAnonymousView = (View)localObject2;
                        if (!bt.isNullOrNil((String)localObject2)) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dye();
                        if (!bt.isNullOrNil(paramAnonymousView)) {
                          continue;
                        }
                        AppMethodBeat.o(163130);
                        return;
                        i = 2;
                        continue;
                        localObject2 = ((p)localObject3).dyf();
                        continue;
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject3).dxs().wSL);
                        localObject5 = new Intent();
                        if (((p)localObject3).dxs().wSL != 0) {
                          continue;
                        }
                        bool = true;
                        if (!ab.hVL) {
                          continue;
                        }
                        bool = false;
                        localObject2 = paramAnonymousView;
                        if (localObject3 == null) {
                          continue;
                        }
                        localObject2 = paramAnonymousView;
                        if (!((p)localObject3).Nb(32)) {
                          continue;
                        }
                        Object localObject6 = b.a(b.this, (p)localObject3);
                        localObject2 = paramAnonymousView;
                        if (localObject6 == null) {
                          continue;
                        }
                        ((Intent)localObject5).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject6).dAM);
                        localObject2 = com.tencent.mm.plugin.sns.data.q.iy(paramAnonymousView, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dvK);
                        com.tencent.mm.plugin.sns.data.q.g((Intent)localObject5, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dvK);
                        ((Intent)localObject5).putExtra("KRightBtn", bool);
                        paramAnonymousView = new Bundle();
                        paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                        paramAnonymousView.putString("key_snsad_statextstr", ((p)localObject3).dxy().xns);
                        ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
                        ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                        ((Intent)localObject5).putExtra("useJs", true);
                        ((Intent)localObject5).putExtra("srcUsername", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("stastic_scene", 15);
                        ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("pre_username", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("preUsername", ((p)localObject3).field_userName);
                        com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject5, b.this.activity);
                        AppMethodBeat.o(163130);
                        return;
                        bool = false;
                        continue;
                        if (((((TimeLineObject)localObject6).Etm.DaB != 1) || (((TimeLineObject)localObject6).Etm.DaC.size() != 1)) && (((TimeLineObject)localObject6).Etm.DaB != 7) && ((((TimeLineObject)localObject6).Etm.DaB != 27) || (((TimeLineObject)localObject6).Etm.DaC.size() <= k) || (((bpi)((TimeLineObject)localObject6).Etm.DaC.get(k)).mBH != 2))) {
                          continue;
                        }
                        localObject2 = b.a(b.this, (p)localObject3);
                        if (!com.tencent.mm.plugin.sns.data.j.a(b.this.activity, (p)localObject3, (com.tencent.mm.plugin.sns.storage.a)localObject2, b.this.dep, b.this.xwT)) {
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
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.item.a.a)paramAnonymousView.getTag()).xPm;
                        if (!((p)localObject3).dxs().dvh()) {
                          continue;
                        }
                        localObject5 = ((p)localObject3).dyh().field_adxml;
                        if (k <= 0) {
                          continue;
                        }
                        localObject4 = "adTurnCanvasInfo";
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.jb((String)localObject5, (String)localObject4)) {
                          continue;
                        }
                        m = b.this.dep;
                        if (b.this.dep != 0) {
                          continue;
                        }
                        j = 1;
                        localObject4 = new SnsAdClick(m, j, ((p)localObject3).field_snsId, 21, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, b.this.xwT, (p)localObject3, 22);
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
                        ((Intent)localObject2).putExtra("sns_landing_pages_rawSnsId", ((p)localObject3).dxy().Id);
                        ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", ((p)localObject3).dyg());
                        ((Intent)localObject2).putExtra("sns_landing_pages_aid", ((p)localObject3).dyc());
                        ((Intent)localObject2).putExtra("sns_landing_pages_traceid", ((p)localObject3).dyd());
                        paramAnonymousView = ((p)localObject3).dxy();
                        if (paramAnonymousView == null) {
                          continue;
                        }
                        paramAnonymousView = paramAnonymousView.Etm.DaC;
                        if (paramAnonymousView.size() <= k) {
                          continue;
                        }
                        ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((bpi)paramAnonymousView.get(k)).DMQ);
                        ((Intent)localObject2).setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                        i = 1;
                        if (b.this.dep != 2) {
                          continue;
                        }
                        i = 16;
                        ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
                        if (k <= 0) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dxs().dvt();
                        ((Intent)localObject2).putExtra("sns_landing_pages_xml", paramAnonymousView);
                        ((Intent)localObject2).putExtra("sns_landing_pages_rec_src", ((p)localObject3).dyi());
                        ((Intent)localObject2).putExtra("sns_landing_pages_xml_prefix", "adxml");
                        ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        paramAnonymousView = b.this.activity;
                        localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
                        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        b.this.activity.overridePendingTransition(0, 0);
                        if (b.this.xlD == null) {
                          continue;
                        }
                        b.this.xlD.dsZ().C((p)localObject3);
                        AppMethodBeat.o(163130);
                        return;
                        if (!(paramAnonymousView.getTag() instanceof d.a)) {
                          continue;
                        }
                        localObject2 = ((d.a)paramAnonymousView.getTag()).xPm;
                        continue;
                        if (!(localObject2 instanceof k.b)) {
                          continue;
                        }
                        localObject2 = (TagImageView)((k.b)localObject2).xSO.view;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof i.a)) {
                          continue;
                        }
                        localObject2 = ((i.a)paramAnonymousView.getTag()).xSy;
                        continue;
                        localObject2 = ((BaseTimeLineItem.BaseViewHolder)localObject2).xQQ.No(0);
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                          continue;
                        }
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.b)paramAnonymousView.getTag()).xOV;
                        continue;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.c)) {
                          continue;
                        }
                        localObject2 = ((com.tencent.mm.plugin.sns.ui.c.a.c)paramAnonymousView.getTag()).xPm;
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
                        ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((bpi)paramAnonymousView.get(0)).DMQ);
                        continue;
                        if (b.this.dep != 1) {
                          continue;
                        }
                        i = 2;
                        continue;
                        paramAnonymousView = ((p)localObject3).dyh().field_adxml;
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
                        k = b.this.dep;
                        if (b.this.dep != 0) {
                          continue;
                        }
                        j = 1;
                        paramAnonymousView = new SnsAdClick(k, j, ((p)localObject3).field_snsId, 31, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.j.a(paramAnonymousView, b.this.xwT, (p)localObject3, 22);
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
                        localObject2 = ((p)localObject3).dxs().wTC.wRX;
                        paramAnonymousView = (View)localObject2;
                        if (!bt.isNullOrNil((String)localObject2)) {
                          continue;
                        }
                        paramAnonymousView = ((p)localObject3).dye();
                        if (!bt.isNullOrNil(paramAnonymousView)) {
                          continue;
                        }
                        AppMethodBeat.o(163130);
                        return;
                        localObject2 = ((p)localObject3).dyf();
                        continue;
                        k = b.this.dep;
                        if (b.this.dep != 0) {
                          continue;
                        }
                        j = 1;
                        localObject4 = new SnsAdClick(k, j, ((p)localObject3).field_snsId, 0, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.j.a((SnsAdClick)localObject4, b.this.xwT, (p)localObject3, 22);
                        com.tencent.mm.plugin.sns.data.q.a((SnsAdClick)localObject4);
                        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "adlink url " + paramAnonymousView + " " + ((p)localObject3).dxs().wSL);
                        localObject5 = new Intent();
                        if (((p)localObject3).dxs().wSL != 0) {
                          continue;
                        }
                        bool = true;
                        if (!ab.hVL) {
                          continue;
                        }
                        bool = false;
                        localObject2 = paramAnonymousView;
                        if (localObject3 == null) {
                          continue;
                        }
                        localObject2 = paramAnonymousView;
                        if (!((p)localObject3).Nb(32)) {
                          continue;
                        }
                        localObject6 = b.a(b.this, (p)localObject3);
                        localObject2 = paramAnonymousView;
                        if (localObject6 == null) {
                          continue;
                        }
                        ((Intent)localObject5).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject6).dAM);
                        localObject2 = com.tencent.mm.plugin.sns.data.q.iy(paramAnonymousView, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dvK);
                        com.tencent.mm.plugin.sns.data.q.g((Intent)localObject5, ((com.tencent.mm.plugin.sns.storage.a)localObject6).dvK);
                        ((Intent)localObject5).putExtra("KRightBtn", bool);
                        paramAnonymousView = new Bundle();
                        paramAnonymousView.putParcelable("KSnsAdTag", (Parcelable)localObject4);
                        paramAnonymousView.putString("key_snsad_statextstr", ((p)localObject3).dxy().xns);
                        ((Intent)localObject5).putExtra("jsapiargs", paramAnonymousView);
                        ((Intent)localObject5).putExtra("rawUrl", (String)localObject2);
                        ((Intent)localObject5).putExtra("useJs", true);
                        ((Intent)localObject5).putExtra("srcUsername", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("stastic_scene", 15);
                        ((Intent)localObject5).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("pre_username", ((p)localObject3).field_userName);
                        ((Intent)localObject5).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.q.st(((p)localObject3).field_snsId));
                        ((Intent)localObject5).putExtra("preUsername", ((p)localObject3).field_userName);
                        com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject5, b.this.activity);
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
                      if (((p)localObject3).dyh().dxs().dvq())
                      {
                        localObject1 = ((p)localObject3).dyh().dxs().dvk();
                        localObject4 = ((p)localObject3).dyg();
                        com.tencent.mm.kernel.g.afz();
                        localObject5 = com.tencent.mm.kernel.a.aeo();
                        x.c((String)localObject1, (String)localObject4, (String)localObject5, x.ay((String)localObject1, (String)localObject4, (String)localObject5), 0, "");
                      }
                      localObject6 = ((p)localObject3).dxy();
                      if (((((TimeLineObject)localObject6).Etm.DaB != 15) || (((TimeLineObject)localObject6).Ett == 1)) && ((((TimeLineObject)localObject6).Etm.DaB != 27) || (((TimeLineObject)localObject6).Etm.DaC.size() <= k) || (((bpi)((TimeLineObject)localObject6).Etm.DaC.get(k)).mBH != 6))) {
                        continue;
                      }
                      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.TimelineClickListener", "onsight click");
                      localObject1 = null;
                      localObject4 = null;
                      if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.an)) {
                        localObject1 = (com.tencent.mm.plugin.sns.ui.an)paramAnonymousView.getTag();
                      }
                      if (!(paramAnonymousView.getTag() instanceof BaseTimeLineItem.BaseViewHolder)) {
                        continue;
                      }
                      localObject4 = (BaseTimeLineItem.BaseViewHolder)paramAnonymousView.getTag();
                      if (((TimeLineObject)localObject6).Etm.DaB != 27) {
                        continue;
                      }
                      localObject1 = ((k.b)localObject4).xSP;
                      if (localObject3 != null) {
                        continue;
                      }
                      AppMethodBeat.o(163130);
                      return;
                      localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).dAM;
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
    this.xTN = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(163132);
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        Object localObject;
        if ((paramAnonymousContextMenuInfo instanceof s))
        {
          paramAnonymousContextMenuInfo = (s)paramAnonymousContextMenuInfo;
          localObject = paramAnonymousContextMenuInfo.xmh;
          if (com.tencent.mm.bs.d.axB("favorite")) {
            switch (((TimeLineObject)localObject).Etm.DaB)
            {
            default: 
              paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            }
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, af.dtu().apK(paramAnonymousContextMenuInfo.dgg));
          AppMethodBeat.o(163132);
          return;
          paramAnonymousContextMenu.add(0, 4, 0, paramAnonymousView.getContext().getString(2131761941));
          localObject = new dx();
          ((dx)localObject).dgp.dgg = paramAnonymousContextMenuInfo.dgg;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          if (((dx)localObject).dgq.dfO)
          {
            paramAnonymousContextMenu.add(0, 18, 0, paramAnonymousView.getContext().getString(2131755836));
            continue;
            paramAnonymousContextMenu.add(0, 5, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 9, 0, paramAnonymousView.getContext().getString(2131761941));
            continue;
            paramAnonymousContextMenu.add(0, 3, 0, paramAnonymousView.getContext().getString(2131761941));
            localObject = new dx();
            ((dx)localObject).dgp.dgg = paramAnonymousContextMenuInfo.dgg;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
            if (((dx)localObject).dgq.dfO)
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
      
      public final boolean eM(View paramAnonymousView)
      {
        AppMethodBeat.i(163131);
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof s))
        {
          localObject = (s)localObject;
          TimeLineObject localTimeLineObject = ((s)localObject).xmh;
          if ((localTimeLineObject.Etm.DaB == 10) || (localTimeLineObject.Etm.DaB == 17) || (localTimeLineObject.Etm.DaB == 22) || (localTimeLineObject.Etm.DaB == 23))
          {
            AppMethodBeat.o(163131);
            return false;
          }
          b.this.xTt.a(paramAnonymousView, ((s)localObject).dgg, localTimeLineObject);
          AppMethodBeat.o(163131);
          return true;
        }
        AppMethodBeat.o(163131);
        return false;
      }
    };
    this.xSR = new com.tencent.mm.plugin.sight.decode.a.b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(163133);
        if ((paramAnonymousb != null) && (paramAnonymousInt == 0)) {
          if (paramAnonymousb.wrz == null) {
            break label88;
          }
        }
        label88:
        for (paramAnonymousb = (View)paramAnonymousb.wrz.get();; paramAnonymousb = null)
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
    this.xTV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100250);
        b.this.eE(paramAnonymousView);
        AppMethodBeat.o(100250);
      }
    };
    this.xTW = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100256);
        b.this.dyT();
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.e)))
        {
          paramAnonymousView = af.dtu().apK(((com.tencent.mm.plugin.sns.data.e)paramAnonymousView.getTag()).dgg);
          if (paramAnonymousView != null)
          {
            com.tencent.mm.plugin.sns.k.f localf = com.tencent.mm.plugin.sns.k.f.wQY;
            com.tencent.mm.plugin.sns.k.f.apo(paramAnonymousView.field_userName);
            paramAnonymousView = new com.tencent.mm.plugin.sns.model.q(paramAnonymousView.field_snsId, 9);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(paramAnonymousView, 0);
          }
        }
        AppMethodBeat.o(100256);
      }
    };
    this.xTX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(100257);
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.m)))
        {
          paramAnonymousView = (com.tencent.mm.plugin.sns.ui.m)paramAnonymousView.getTag();
          Object localObject1 = paramAnonymousView.wFh;
          if ((localObject1 != null) && (!bt.gL(((cuo)localObject1).Emf)) && (((cuo)localObject1).Emf.get(0) != null))
          {
            Object localObject2 = ((cuu)((cuo)localObject1).Emf.get(0)).Md5;
            EmojiInfo localEmojiInfo = com.tencent.mm.storage.aw.eLx().FyY.aJx((String)localObject2);
            Intent localIntent = new Intent();
            localIntent.putExtra("custom_smiley_preview_md5", (String)localObject2);
            if ((localEmojiInfo.field_catalog != EmojiGroupInfo.LBP) && (localEmojiInfo.field_catalog != EmojiGroupInfo.LBO) && (localEmojiInfo.field_catalog != EmojiGroupInfo.LBN)) {
              localIntent.putExtra("custom_smiley_preview_productid", localEmojiInfo.field_groupId);
            }
            com.tencent.mm.bs.d.b(b.this.activity, "emoji", ".ui.CustomSmileyPreviewUI", localIntent, 1111);
            localObject2 = com.tencent.mm.plugin.sns.k.f.wQY;
            long l = x.anz(paramAnonymousView.xlP);
            paramAnonymousView = String.valueOf(((cuo)localObject1).Ema);
            localObject1 = com.tencent.mm.plugin.sns.data.q.st(l);
            localObject1 = (f.a)((com.tencent.mm.plugin.sns.k.f)localObject2).wRj.get(localObject1);
            if ((localObject1 != null) && (!((f.a)localObject1).wRK.contains(paramAnonymousView))) {
              ((f.a)localObject1).wRK.add(paramAnonymousView);
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
      if (!bt.isNullOrNil(paramString1))
      {
        if (paramInt == 2) {}
        for (com.tencent.mm.plugin.sns.storage.a locala = paramp.dxv(); locala == null; locala = paramp.dxu())
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "jumpWeApp adInfo==null");
          return false;
        }
        String str = com.tencent.mm.plugin.sns.data.q.st(paramp.field_snsId) + ":" + locala.dvK + ":" + af.dta() + ":" + System.currentTimeMillis();
        if (paramInt == 0) {}
        for (paramInt = 1045;; paramInt = 1046)
        {
          com.tencent.mm.plugin.sns.data.q.a(paramString1, paramString2, paramString3, paramp.dyc(), paramp.dyd(), str, locala.dvK, paramInt);
          return true;
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.TimelineClickListener", "jumpWeApp exp:" + paramString1.toString());
    }
  }
  
  public final void a(com.tencent.mm.plugin.sns.ui.c.a.a parama)
  {
    if (this.xTr != null) {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TimelineClickListener", "has already prepare detail click animation");
    }
    do
    {
      return;
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.b))
      {
        this.xTr = new com.tencent.mm.plugin.sns.ui.b.a.d((MMActivity)this.activity, parama);
        this.xTs = new com.tencent.mm.plugin.sns.ui.b.a.c((MMActivity)this.activity, parama);
        return;
      }
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.c))
      {
        this.xTr = new com.tencent.mm.plugin.sns.ui.b.a.f((MMActivity)this.activity, parama);
        this.xTs = new com.tencent.mm.plugin.sns.ui.b.a.e((MMActivity)this.activity, parama);
        return;
      }
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.c.a.e))
      {
        this.xTr = new com.tencent.mm.plugin.sns.ui.b.a.j((MMActivity)this.activity, parama);
        this.xTs = new com.tencent.mm.plugin.sns.ui.b.a.i((MMActivity)this.activity, parama);
        return;
      }
    } while (!(parama instanceof com.tencent.mm.plugin.sns.ui.c.a.d));
    this.xTr = new com.tencent.mm.plugin.sns.ui.b.a.h((MMActivity)this.activity, parama);
    this.xTs = new com.tencent.mm.plugin.sns.ui.b.a.g((MMActivity)this.activity, parama);
  }
  
  public final void b(com.tencent.mm.plugin.sns.a.b.i parami)
  {
    this.xwT = parami;
    if (this.xTt != null) {
      this.xTt.b(parami);
    }
  }
  
  public final void cIt()
  {
    this.xTt.cIt();
    com.tencent.mm.sdk.b.a.ESL.c(this.xUg);
    com.tencent.mm.sdk.b.a.ESL.c(this.xUh);
  }
  
  public abstract void d(View paramView, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void dE(Object paramObject);
  
  public abstract void dyQ();
  
  public abstract void dyR();
  
  public abstract void dyS();
  
  public abstract void dyT();
  
  public abstract void eA(View paramView);
  
  public abstract void eB(View paramView);
  
  public abstract void eC(View paramView);
  
  public abstract void eD(View paramView);
  
  public abstract void eE(View paramView);
  
  public abstract void ey(View paramView);
  
  public abstract void ez(View paramView);
  
  public final void i(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    if (this.xTp != null) {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.TimelineClickListener", "has already prepare click animation");
    }
    do
    {
      return;
      if ((paramBaseViewHolder instanceof com.tencent.mm.plugin.sns.ui.item.a.a))
      {
        this.xTp = new com.tencent.mm.plugin.sns.ui.b.b.d((MMActivity)this.activity, paramBaseViewHolder);
        this.xTq = new com.tencent.mm.plugin.sns.ui.b.b.c((MMActivity)this.activity, paramBaseViewHolder);
        ((com.tencent.mm.plugin.sns.ui.item.a.a)paramBaseViewHolder).xRT = true;
        return;
      }
      if ((paramBaseViewHolder instanceof d.a))
      {
        this.xTp = new com.tencent.mm.plugin.sns.ui.b.b.f((MMActivity)this.activity, paramBaseViewHolder);
        this.xTq = new com.tencent.mm.plugin.sns.ui.b.b.e((MMActivity)this.activity, paramBaseViewHolder);
        ((d.a)paramBaseViewHolder).xRT = true;
        return;
      }
      if ((paramBaseViewHolder instanceof k.b))
      {
        this.xTp = new com.tencent.mm.plugin.sns.ui.b.b.j((MMActivity)this.activity, paramBaseViewHolder);
        this.xTq = new com.tencent.mm.plugin.sns.ui.b.b.i((MMActivity)this.activity, paramBaseViewHolder);
        return;
      }
    } while (!(paramBaseViewHolder instanceof i.a));
    this.xTp = new com.tencent.mm.plugin.sns.ui.b.b.h((MMActivity)this.activity, paramBaseViewHolder);
    this.xTq = new com.tencent.mm.plugin.sns.ui.b.b.g((MMActivity)this.activity, paramBaseViewHolder);
  }
  
  public final void removeListener()
  {
    this.xTt.removeListener();
    com.tencent.mm.sdk.b.a.ESL.d(this.xUg);
    com.tencent.mm.sdk.b.a.ESL.d(this.xUh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b
 * JD-Core Version:    0.7.0.1
 */