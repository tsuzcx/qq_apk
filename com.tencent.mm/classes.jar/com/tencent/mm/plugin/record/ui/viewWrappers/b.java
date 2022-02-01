package com.tencent.mm.plugin.record.ui.viewWrappers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.kn;
import com.tencent.mm.loader.b.e.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.plugin.fav.ui.d.s;
import com.tencent.mm.plugin.findersdk.a.cp;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.a.a;
import com.tencent.mm.plugin.record.ui.h.a.c;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.aro;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.ask;
import com.tencent.mm.protocal.protobuf.atg;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.LinkedList;

public final class b
  implements h.b
{
  private IListener Akp;
  private int Aod;
  private View.OnClickListener Aot;
  private com.tencent.mm.plugin.record.ui.h.a NBA;
  public String NBq;
  public String NBr;
  public int NBs;
  boolean NCL;
  public String NCM;
  private e.a NCN;
  View.OnClickListener dpY;
  public int fromScene;
  MMHandler handler;
  private IListener rDF;
  
  public b(com.tencent.mm.plugin.record.ui.h.a parama, MMHandler paramMMHandler)
  {
    AppMethodBeat.i(28018);
    this.Aod = 0;
    this.NCL = false;
    this.NBs = -1;
    this.NCM = "";
    this.fromScene = 0;
    this.NCN = new e.a();
    this.dpY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28015);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
        Object localObject4 = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        Object localObject3;
        Object localObject2;
        switch (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.dataType)
        {
        case 9: 
        case 12: 
        case 13: 
        case 18: 
        case 20: 
        case 21: 
        case 24: 
        case 25: 
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28015);
          return;
        case 5: 
          b.a(paramAnonymousView.findViewById(R.h.icon), ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy);
          ((com.tencent.mm.plugin.record.ui.a.b)localObject4).NBq = b.this.NBq;
          ((com.tencent.mm.plugin.record.ui.a.b)localObject4).NCx = b.this.NBr;
          localObject3 = b.this;
          localObject2 = paramAnonymousView.getContext();
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy == null)
          {
            Log.w("MicroMsg.OtherViewWrapper", "go to web page error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.hIQ });
            com.tencent.mm.ui.base.k.cZ((Context)localObject2, ((Context)localObject2).getString(R.l.favorite_record_url_error));
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28015);
          return;
          paramAnonymousView = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy;
          if (paramAnonymousView != null) {
            if (paramAnonymousView.ZzJ) {
              paramAnonymousView = paramAnonymousView.canvasPageXml;
            }
          }
          for (;;)
          {
            if (Util.isNullOrNil(paramAnonymousView)) {
              break label476;
            }
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("sns_landing_pages_xml", paramAnonymousView);
            ((Intent)localObject1).putExtra("sns_landig_pages_from_source", 5);
            ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.nRr);
            ((Intent)localObject1).addFlags(268435456);
            ((Intent)localObject1).putExtra("msg_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
            com.tencent.mm.br.c.b((Context)localObject2, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject1, 1);
            break;
            if ((paramAnonymousView.Zzy != null) && (paramAnonymousView.Zzy.ZAj != null) && (paramAnonymousView.Zzy.ZAj.ZzJ)) {
              paramAnonymousView = paramAnonymousView.Zzy.ZAj.canvasPageXml;
            } else {
              paramAnonymousView = null;
            }
          }
          label476:
          Object localObject6 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.ZAf;
          localObject1 = "";
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.ZAj != null) {
            localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.ZAj.ZBV;
          }
          paramAnonymousView = (View)localObject1;
          if (localObject6 != null)
          {
            paramAnonymousView = (View)localObject1;
            if (Util.isNullOrNil((String)localObject1)) {
              paramAnonymousView = ((arh)localObject6).link;
            }
          }
          localObject1 = paramAnonymousView;
          if (Util.isNullOrNil(paramAnonymousView)) {
            localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.ZyM;
          }
          if (Util.isNullOrNil((String)localObject1))
          {
            Log.w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.hIQ });
            com.tencent.mm.ui.base.k.cZ((Context)localObject2, ((Context)localObject2).getString(R.l.favorite_record_url_error));
          }
          else
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("rawUrl", (String)localObject1);
            paramAnonymousView.putExtra("msgUsername", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).NBq);
            paramAnonymousView.putExtra("geta8key_username", ((b)localObject3).NCM);
            paramAnonymousView.putExtra("serverMsgID", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).NCx);
            if ((localObject6 != null) && (!Util.isNullOrNil(((arh)localObject6).hzi))) {
              paramAnonymousView.putExtra("srcDisplayname", com.tencent.mm.model.aa.getDisplayName(((arh)localObject6).hzi));
            }
            paramAnonymousView.putExtra("mode", 1);
            b.aF((Context)localObject2, paramAnonymousView);
            if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType == 1)
            {
              paramAnonymousView.putExtra("is_favorite_item", true);
              paramAnonymousView.putExtra("fav_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).xvD.field_localId);
              paramAnonymousView.putExtra("key_detail_can_delete", false);
              paramAnonymousView.putExtra("geta8key_scene", 72);
              paramAnonymousView.putExtra("from_scence", 4);
              localObject1 = com.tencent.mm.modelstat.a.c.Pu(com.tencent.mm.pluginsdk.model.k.class.getName());
              ((Bundle)localObject1).putInt("mm_rpt_fav_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).xvD.field_id);
              paramAnonymousView.putExtra("mm_report_bundle", (Bundle)localObject1);
              label811:
              if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy != null) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy != null) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.WKx != null) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.WKx.nQm == 16))
              {
                paramAnonymousView.putExtra("immersiveVideoStyle", 1);
                paramAnonymousView.putExtra("immersivePageBgIsDark", 1);
                paramAnonymousView.putExtra("webview_bg_color_rsID", 17170444);
              }
              if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy != null)
              {
                paramAnonymousView.putExtra("webpageTitle", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.title);
                paramAnonymousView.putExtra("thumbPath", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzf);
              }
              localObject1 = new Bundle();
              ((Bundle)localObject1).putString("key_snsad_statextstr", ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.iah);
              paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject1);
              paramAnonymousView.putExtra("key_enable_teen_mode_check", true);
              paramAnonymousView.putExtra("KMsgType", 2);
              if ((((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.WKx == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.WKx.nQo != 1) || (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GU(((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.WKx.nQm))) {
                break label1281;
              }
              localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.WKx;
              localObject3 = paramAnonymousView.getStringExtra("rawUrl");
              Log.i("MicroMsg.OtherViewWrapper", "jump to native video");
              if (((arn)localObject1).ZBl != null) {
                paramAnonymousView.putExtra("img_gallery_width", ((arn)localObject1).ZBl.width).putExtra("img_gallery_height", ((arn)localObject1).ZBl.height).putExtra("img_gallery_left", ((arn)localObject1).ZBl.left).putExtra("img_gallery_top", ((arn)localObject1).ZBl.top);
              }
              paramAnonymousView.addFlags(268435456);
              i = (int)(System.currentTimeMillis() / 1000L);
              localObject3 = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).e((String)localObject3, 24, 10000, i);
              if ((!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(24)) || (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a((Context)localObject2, (String)localObject3, ((arn)localObject1).nQm, 24, 10000, paramAnonymousView))) {
                break label1276;
              }
            }
            label1276:
            for (int i = 1; i == 0; i = 0)
            {
              com.tencent.mm.br.c.b((Context)localObject2, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              break;
              if (((com.tencent.mm.plugin.record.ui.a.b)localObject4).dataType != 0) {
                break label811;
              }
              paramAnonymousView.putExtra("geta8key_scene", 71);
              break label811;
            }
            label1281:
            com.tencent.mm.br.c.b((Context)localObject2, "webview", ".ui.tools.WebViewUI", paramAnonymousView, 1);
            continue;
            if ((!com.tencent.mm.plugin.fav.a.b.dQh()) && (WeChatBrands.Business.Entries.SessionChannels.checkAvailable(paramAnonymousView.getContext())) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy != null) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.ZAB != null))
            {
              localObject1 = new Intent();
              localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.ZAB;
              if (!Util.isNullOrNil(((bvl)localObject2).objectId))
              {
                ((Intent)localObject1).putExtra("feed_object_id", com.tencent.mm.ae.d.FK(((bvl)localObject2).objectId));
                ((Intent)localObject1).putExtra("feed_object_nonceId", ((bvl)localObject2).objectNonceId);
                ((Intent)localObject1).putExtra("business_type", 0);
                ((Intent)localObject1).putExtra("finder_user_name", ((bvl)localObject2).username);
                localObject3 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
                if (au.bwE(((fi)localObject3).field_talker))
                {
                  ((Intent)localObject1).putExtra("report_scene", 2);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_scene", 2);
                }
                for (;;)
                {
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_check", true);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_user_name", ((bvl)localObject2).nickname);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_user_id", ((bvl)localObject2).username);
                  ((Intent)localObject1).putExtra("report_uitype", 3);
                  ((Intent)localObject1).putExtra("from_user", ((fi)localObject3).field_talker);
                  ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(4, 2, 25, (Intent)localObject1);
                  ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderShareFeedUI(paramAnonymousView.getContext(), (Intent)localObject1);
                  break;
                  ((Intent)localObject1).putExtra("report_scene", 1);
                  ((Intent)localObject1).putExtra("key_finder_teen_mode_scene", 1);
                }
                if ((!com.tencent.mm.plugin.fav.a.b.dQh()) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy != null) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.ZAD != null))
                {
                  localObject1 = new Intent();
                  localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.ZAD;
                  if (!Util.isNullOrNil(((bmr)localObject2).liveId))
                  {
                    label1959:
                    label2761:
                    label3679:
                    label3692:
                    try
                    {
                      if (Util.isEqual(((bmr)localObject2).username, z.bAW()))
                      {
                        ((Intent)localObject1).putExtra("KEY_PARAMS_SOURCE_TYPE", ((bmr)localObject2).sourceType);
                        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveAnchorUI((Intent)localObject1, paramAnonymousView.getContext(), com.tencent.mm.ae.d.FK(((bmr)localObject2).feedId), Long.valueOf(com.tencent.mm.ae.d.FK(((bmr)localObject2).liveId)), ((bmr)localObject2).objectNonceId, ((bmr)localObject2).desc, "", "", "");
                        continue;
                      }
                      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveVisitorUI(null, paramAnonymousView.getContext(), com.tencent.mm.ae.d.FK(((bmr)localObject2).feedId), Long.valueOf(com.tencent.mm.ae.d.FK(((bmr)localObject2).liveId)), "", ((bmr)localObject2).objectNonceId, ((bmr)localObject2).desc, "", "", "", 0, "", 1, true);
                    }
                    catch (NumberFormatException paramAnonymousView) {}
                    if ((!com.tencent.mm.plugin.fav.a.b.dQh()) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy != null) && (((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.ZAN != null))
                    {
                      paramAnonymousView = ((com.tencent.mm.plugin.record.ui.a.b)localObject4).hIy.Zzy.ZAN;
                      localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((com.tencent.mm.plugin.record.ui.a.b)localObject4).msgId);
                      localObject2 = MMApplicationContext.getContext();
                      localObject3 = new Intent();
                      ((Intent)localObject3).putExtra("key_topic_title", paramAnonymousView.topic);
                      ((Intent)localObject3).putExtra("key_topic_type", paramAnonymousView.Auy);
                      if (paramAnonymousView.Auy == 4)
                      {
                        ((Intent)localObject3).putExtra("KEY_FOLLOW_ID", paramAnonymousView.aadd);
                        localObject4 = new boi();
                        if (paramAnonymousView.aadc != null)
                        {
                          ((boi)localObject4).ZWG = paramAnonymousView.aadc.ZWG;
                          ((boi)localObject4).longitude = paramAnonymousView.aadc.longitude;
                          ((boi)localObject4).latitude = paramAnonymousView.aadc.latitude;
                        }
                      }
                      int j;
                      try
                      {
                        ((Intent)localObject3).putExtra("key_topic_poi_location", ((boi)localObject4).toByteArray());
                        ((Intent)localObject3).putExtra("key_finder_teen_mode_check", true);
                        ((Intent)localObject3).putExtra("key_from_user", ((fi)localObject1).field_talker);
                        if (au.bwE(((fi)localObject1).field_talker))
                        {
                          i = 2;
                          ((Intent)localObject3).putExtra("key_report_scene", i);
                          ((Intent)localObject3).putExtra("KEY_TAB_TYPE", 6);
                          if (!au.bwE(((fi)localObject1).field_talker)) {
                            break label2336;
                          }
                          ((Intent)localObject3).putExtra("key_finder_teen_mode_scene", 2);
                          ((Intent)localObject3).putExtra("key_finder_teen_mode_user_name", "");
                          ((Intent)localObject3).putExtra("key_finder_teen_mode_user_id", "");
                          switch (paramAnonymousView.Auy)
                          {
                          default: 
                            i = 22;
                            ((Intent)localObject3).putExtra("key_activity_profile_src_type", "3");
                            paramAnonymousView = (com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
                            if (au.bwE(((fi)localObject1).field_talker))
                            {
                              j = 3;
                              paramAnonymousView.fillContextIdToIntent(j, 2, i, (Intent)localObject3);
                              ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderActivityProfileUI((Context)localObject2, (Intent)localObject3);
                              continue;
                              if ((paramAnonymousView.Auy != 7) || (paramAnonymousView.aade == null)) {
                                break label1959;
                              }
                              ((Intent)localObject3).putExtra("key_activity_name", paramAnonymousView.aade.ZDK);
                              ((Intent)localObject3).putExtra("key_activity_id", com.tencent.mm.ae.d.FK(paramAnonymousView.aade.ZDJ));
                              ((Intent)localObject3).putExtra("key_nick_name", paramAnonymousView.aade.ZDL);
                              ((Intent)localObject3).putExtra("key_cover_url", paramAnonymousView.iconUrl);
                              ((Intent)localObject3).putExtra("key_display_mask", paramAnonymousView.aade.FOi);
                            }
                            break;
                          }
                        }
                      }
                      catch (IOException localIOException1)
                      {
                        for (;;)
                        {
                          Log.e("MicroMsg.OtherViewWrapper", "location toByteArray exception");
                          continue;
                          i = 1;
                          continue;
                          label2336:
                          ((Intent)localObject3).putExtra("key_finder_teen_mode_scene", 1);
                          continue;
                          i = 59;
                          continue;
                          j = 2;
                        }
                      }
                      if ((!com.tencent.mm.plugin.fav.a.b.dQh()) && (localIOException1.hIy.Zzy != null) && (localIOException1.hIy.Zzy.ZAL != null))
                      {
                        paramAnonymousView = localIOException1.hIy.Zzy.ZAL;
                        localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localIOException1.msgId);
                        localObject2 = MMApplicationContext.getContext();
                        localObject3 = new Intent();
                        ((Intent)localObject3).putExtra("key_topic_title", paramAnonymousView.topic);
                        ((Intent)localObject3).putExtra("key_topic_type", paramAnonymousView.Auy);
                        if (paramAnonymousView.Auy == 4) {
                          ((Intent)localObject3).putExtra("KEY_FOLLOW_ID", paramAnonymousView.aadd);
                        }
                        boi localboi = new boi();
                        localboi.ZWG = paramAnonymousView.aadc.ZWG;
                        localboi.longitude = paramAnonymousView.aadc.longitude;
                        localboi.latitude = paramAnonymousView.aadc.latitude;
                        try
                        {
                          ((Intent)localObject3).putExtra("key_topic_poi_location", localboi.toByteArray());
                          ((Intent)localObject3).putExtra("key_from_user", ((fi)localObject1).field_talker);
                          if (au.bwE(((fi)localObject1).field_talker))
                          {
                            i = 2;
                            ((Intent)localObject3).putExtra("key_report_scene", i);
                            ((Intent)localObject3).putExtra("KEY_TAB_TYPE", 6);
                            if (!au.bwE(((fi)localObject1).field_talker)) {
                              break label2761;
                            }
                            ((Intent)localObject3).putExtra("key_finder_teen_mode_scene", 2);
                            ((Intent)localObject3).putExtra("key_finder_teen_mode_check", true);
                            ((Intent)localObject3).putExtra("key_finder_teen_mode_user_name", "");
                            ((Intent)localObject3).putExtra("key_finder_teen_mode_user_id", "");
                            switch (paramAnonymousView.Auy)
                            {
                            case 3: 
                            default: 
                              i = 22;
                              paramAnonymousView = (com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
                              if (au.bwE(((fi)localObject1).field_talker))
                              {
                                j = 3;
                                paramAnonymousView.fillContextIdToIntent(j, 2, i, (Intent)localObject3);
                                ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderTopicUI((Context)localObject2, (Intent)localObject3);
                              }
                              break;
                            }
                          }
                        }
                        catch (IOException localIOException2)
                        {
                          for (;;)
                          {
                            Log.e("MicroMsg.OtherViewWrapper", "location toByteArray exception");
                            continue;
                            i = 1;
                            continue;
                            ((Intent)localObject3).putExtra("key_finder_teen_mode_scene", 1);
                            continue;
                            i = 22;
                            continue;
                            i = 26;
                            continue;
                            i = 49;
                            continue;
                            j = 2;
                          }
                        }
                        if ((!com.tencent.mm.plugin.fav.a.b.dQh()) && (localIOException2.hIy.Zzy != null) && (localIOException2.hIy.Zzy.ZAL != null))
                        {
                          localObject1 = localIOException2.hIy.Zzy.ZAF;
                          localObject2 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localIOException2.msgId);
                          localObject3 = MMApplicationContext.getContext();
                          Object localObject5 = ((fi)localObject2).field_content;
                          paramAnonymousView = null;
                          if (localObject5 != null) {
                            paramAnonymousView = k.b.aP((String)localObject5, ((fi)localObject2).field_reserved);
                          }
                          if ((paramAnonymousView != null) && (localObject1 != null) && (!Util.isNullOrNil(((bvk)localObject1).username)))
                          {
                            paramAnonymousView = new Intent();
                            if (au.bwE(((fi)localObject2).field_talker))
                            {
                              paramAnonymousView.putExtra("key_finder_teen_mode_scene", 2);
                              paramAnonymousView.putExtra("key_from_profile_share_scene", 2);
                              label2954:
                              localObject5 = (com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
                              if (!au.bwE(((fi)localObject2).field_talker)) {
                                break label3112;
                              }
                            }
                            label3112:
                            for (i = 3;; i = 2)
                            {
                              ((com.tencent.mm.plugin.findersdk.a.cn)localObject5).fillContextIdToIntent(i, 3, 32, paramAnonymousView);
                              paramAnonymousView.putExtra("key_enter_profile_type", 4);
                              paramAnonymousView.putExtra("key_from_comment_scene", 11);
                              paramAnonymousView.putExtra("from_user", ((fi)localObject2).field_talker);
                              paramAnonymousView.putExtra("finder_username", ((bvk)localObject1).username);
                              paramAnonymousView.putExtra("key_finder_teen_mode_check", true);
                              paramAnonymousView.putExtra("key_finder_teen_mode_user_name", ((bvk)localObject1).nickname);
                              paramAnonymousView.putExtra("key_finder_teen_mode_user_id", ((bvk)localObject1).username);
                              ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderProfileUI((Context)localObject3, paramAnonymousView);
                              break;
                              paramAnonymousView.putExtra("key_finder_teen_mode_scene", 1);
                              paramAnonymousView.putExtra("key_from_profile_share_scene", 1);
                              break label2954;
                            }
                            if ((!com.tencent.mm.plugin.fav.a.b.dQh()) && (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.Zzy != null) && (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.Zzy.ZAH != null))
                            {
                              paramAnonymousView = ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.Zzy.ZAH;
                              localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId);
                              localObject2 = MMApplicationContext.getContext();
                              localObject3 = new Intent();
                              ((Intent)localObject3).putExtra("TITLE_WORDING", paramAnonymousView.title);
                              ((Intent)localObject3).putExtra("AUTO_REFRESH", true);
                              try
                              {
                                ((Intent)localObject3).putExtra("FINDER_SHARE_ALBUM", paramAnonymousView.toByteArray());
                                ((Intent)localObject3).putExtra("GET_REL_SCENE", 14);
                                ((Intent)localObject3).putExtra("STREAM_CARD_BUFFER", paramAnonymousView.AEA.toByteArray());
                                ((Intent)localObject3).putExtra("COMMENT_SCENE", 51);
                                ((Intent)localObject3).putExtra("CARD_ID", t.aXD(paramAnonymousView.cardId));
                                ((Intent)localObject3).putExtra("SHARED_USERNAME", ((fi)localObject1).field_talker);
                                if (au.bwE(((fi)localObject1).field_talker)) {}
                                for (i = 2;; i = 1)
                                {
                                  ((Intent)localObject3).putExtra("FROM_SHARE_SCENE", i);
                                  ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterAlbumRelatedTimelineUI((Context)localObject2, (Intent)localObject3);
                                  break;
                                }
                                b.a(paramAnonymousView.findViewById(R.h.icon), ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.Zzy);
                                localObject6 = paramAnonymousView.getContext();
                                paramAnonymousView = ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy;
                                if ((paramAnonymousView == null) || (paramAnonymousView.Zzy == null) || (paramAnonymousView.Zzy.ZAz == null)) {
                                  Log.w("MicroMsg.OtherViewWrapper", "handleMpVideoItem favMpMsgItem is null");
                                }
                                for (boolean bool = false; !bool; bool = s.a((Context)localObject6, paramAnonymousView.Zzy.ZAz, paramAnonymousView, false))
                                {
                                  if (((!Util.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.Ysw)) || (!Util.isNullOrNil(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.ZzW))) && (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.Zza > 0L)) {
                                    break label4120;
                                  }
                                  Log.w("MicroMsg.OtherViewWrapper", "full md5[%s], fullsize[%d], start use url", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.ZyW, Long.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.Zza) });
                                  localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.ZyM;
                                  paramAnonymousView = (View)localObject1;
                                  if (Util.isNullOrNil((String)localObject1)) {
                                    paramAnonymousView = ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.ZyQ;
                                  }
                                  if (!Util.isNullOrNil(paramAnonymousView)) {
                                    break label3933;
                                  }
                                  Log.w("MicroMsg.OtherViewWrapper", "go to video[webpage] error, url null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.hIQ });
                                  if ((((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType != 1) || (((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_itemStatus == 10) || (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.ZzM != 0)) {
                                    break label3692;
                                  }
                                  paramAnonymousView = new Intent();
                                  paramAnonymousView.putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_localId);
                                  paramAnonymousView.putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.hIQ);
                                  if (!com.tencent.mm.plugin.record.model.i.c((com.tencent.mm.plugin.record.ui.a.b)localObject5)) {
                                    break label3679;
                                  }
                                  b.a(paramAnonymousView, (com.tencent.mm.plugin.record.ui.a.b)localObject5, (Context)localObject6, com.tencent.mm.plugin.record.model.i.a((com.tencent.mm.plugin.record.ui.a.b)localObject5), com.tencent.mm.plugin.record.model.i.b((com.tencent.mm.plugin.record.ui.a.b)localObject5));
                                  break;
                                }
                                com.tencent.mm.plugin.fav.a.b.a((Context)localObject6, ".ui.detail.FavoriteFileDetailUI", paramAnonymousView, 1);
                                continue;
                                Intent localIntent = new Intent();
                                localObject1 = "";
                                paramAnonymousView = "";
                                if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 0)
                                {
                                  localObject2 = q.f(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId);
                                  if ((Util.isNullOrNil((String)localObject2)) || (!y.ZC((String)localObject2)))
                                  {
                                    com.tencent.mm.ui.base.k.cW((Context)localObject6, ((Context)localObject6).getString(R.l.favorite_record_video_error));
                                    continue;
                                  }
                                  localObject3 = q.c(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId);
                                  if (!Util.isNullOrNil((String)localObject3))
                                  {
                                    paramAnonymousView = (View)localObject2;
                                    localObject1 = localObject3;
                                    if (y.ZC((String)localObject3)) {}
                                  }
                                  else
                                  {
                                    localIntent.putExtra("key_detail_data_valid", false);
                                    localObject1 = localObject3;
                                    paramAnonymousView = (View)localObject2;
                                  }
                                }
                                for (;;)
                                {
                                  b.a(localIntent, (com.tencent.mm.plugin.record.ui.a.b)localObject5, (Context)localObject6, (String)localObject1, paramAnonymousView);
                                  break;
                                  if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 1)
                                  {
                                    localObject2 = com.tencent.mm.plugin.record.model.i.b((com.tencent.mm.plugin.record.ui.a.b)localObject5);
                                    if ((Util.isNullOrNil((String)localObject2)) || (!y.ZC((String)localObject2)))
                                    {
                                      com.tencent.mm.ui.base.k.cW((Context)localObject6, ((Context)localObject6).getString(R.l.favorite_record_video_error));
                                      break;
                                    }
                                    localObject3 = com.tencent.mm.plugin.record.model.i.a((com.tencent.mm.plugin.record.ui.a.b)localObject5);
                                    if (!Util.isNullOrNil((String)localObject3))
                                    {
                                      paramAnonymousView = (View)localObject2;
                                      localObject1 = localObject3;
                                      if (y.ZC((String)localObject3)) {}
                                    }
                                    else
                                    {
                                      localIntent.putExtra("key_detail_data_valid", false);
                                      paramAnonymousView = (View)localObject2;
                                      localObject1 = localObject3;
                                    }
                                  }
                                }
                                label3933:
                                localObject1 = new Intent();
                                ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
                                if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 1)
                                {
                                  ((Intent)localObject1).putExtra("is_favorite_item", true);
                                  ((Intent)localObject1).putExtra("fav_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_localId);
                                  ((Intent)localObject1).putExtra("key_detail_can_delete", false);
                                  ((Intent)localObject1).putExtra("geta8key_scene", 14);
                                  paramAnonymousView = com.tencent.mm.modelstat.a.c.Pu(com.tencent.mm.pluginsdk.model.k.class.getName());
                                  paramAnonymousView.putInt("mm_rpt_fav_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_id);
                                  ((Intent)localObject1).putExtra("mm_report_bundle", paramAnonymousView);
                                  Log.d("MicroMsg.OtherViewWrapper", "go to video, fav id %d, fav local id %d, data id %s", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_id), Long.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_localId), ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iOk() });
                                }
                                ((Intent)localObject1).putExtra("key_enable_teen_mode_check", true);
                                com.tencent.mm.br.c.b((Context)localObject6, "webview", ".ui.tools.WebViewUI", (Intent)localObject1, 1);
                                continue;
                                label4120:
                                if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 0)
                                {
                                  paramAnonymousView = new Intent();
                                  paramAnonymousView.putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId);
                                  paramAnonymousView.putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hXv);
                                  paramAnonymousView.putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iOk());
                                  paramAnonymousView.putExtra("key_detail_fav_video_scene_from", 1);
                                  if (q.d(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId))
                                  {
                                    b.a(paramAnonymousView, (com.tencent.mm.plugin.record.ui.a.b)localObject5, (Context)localObject6, q.c(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId), q.f(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId));
                                  }
                                  else
                                  {
                                    Log.i("MicroMsg.OtherViewWrapper", "RecordData.RECORD_TYPE: data not exist, go and download ");
                                    b.a(paramAnonymousView, (com.tencent.mm.plugin.record.ui.a.b)localObject5, (Context)localObject6, q.c(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId), q.f(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId), false);
                                  }
                                }
                                else if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 1)
                                {
                                  paramAnonymousView = new Intent();
                                  paramAnonymousView.putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_localId);
                                  paramAnonymousView.putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iOk());
                                  if (com.tencent.mm.plugin.record.model.i.c((com.tencent.mm.plugin.record.ui.a.b)localObject5))
                                  {
                                    b.a(paramAnonymousView, (com.tencent.mm.plugin.record.ui.a.b)localObject5, (Context)localObject6, com.tencent.mm.plugin.record.model.i.a((com.tencent.mm.plugin.record.ui.a.b)localObject5), com.tencent.mm.plugin.record.model.i.b((com.tencent.mm.plugin.record.ui.a.b)localObject5));
                                  }
                                  else
                                  {
                                    com.tencent.mm.plugin.fav.a.b.a((Context)localObject6, ".ui.detail.FavoriteFileDetailUI", paramAnonymousView, 1);
                                    continue;
                                    if (WeChatBrands.Business.Entries.SessionLocation.checkAvailable(paramAnonymousView.getContext()))
                                    {
                                      localObject6 = paramAnonymousView.getContext();
                                      if (localObject6 != null)
                                      {
                                        localObject1 = null;
                                        if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl() != null)
                                        {
                                          localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl().ZAh;
                                          localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl().iQn();
                                          paramAnonymousView = null;
                                          if (localObject2 != null) {
                                            if (Util.isNullOrNil(((arh)localObject2).iQq())) {
                                              break label4546;
                                            }
                                          }
                                          label4546:
                                          for (paramAnonymousView = com.tencent.mm.model.aa.getDisplayName(((arh)localObject2).iQq());; paramAnonymousView = com.tencent.mm.model.aa.getDisplayName(((arh)localObject2).hQQ))
                                          {
                                            localObject3 = paramAnonymousView;
                                            if (localObject2 == null)
                                            {
                                              localObject3 = paramAnonymousView;
                                              if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 1) {
                                                localObject3 = com.tencent.mm.model.aa.getDisplayName(((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_fromUser);
                                              }
                                            }
                                            if (localObject1 != null) {
                                              break label4558;
                                            }
                                            Log.w("MicroMsg.OtherViewWrapper", "go to location error, locItem null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iOk() });
                                            com.tencent.mm.ui.base.k.cW((Context)localObject6, ((Context)localObject6).getString(R.l.favorite_record_loc_error));
                                            break;
                                          }
                                          label4558:
                                          paramAnonymousView = new Intent();
                                          paramAnonymousView.putExtra("kwebmap_slat", ((arm)localObject1).lat);
                                          paramAnonymousView.putExtra("kwebmap_lng", ((arm)localObject1).lng);
                                          paramAnonymousView.putExtra("kPoiName", ((arm)localObject1).hVI);
                                          paramAnonymousView.putExtra("Kwebmap_locaion", ((arm)localObject1).label);
                                          if (((arm)localObject1).iQr() >= 0) {
                                            paramAnonymousView.putExtra("kwebmap_scale", ((arm)localObject1).iQr());
                                          }
                                          paramAnonymousView.putExtra("kisUsername", (String)localObject3);
                                          paramAnonymousView.putExtra("kwebmap_from_to", true);
                                          if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 1)
                                          {
                                            paramAnonymousView.putExtra("KFavLocSigleView", true);
                                            paramAnonymousView.putExtra("map_view_type", 2);
                                            paramAnonymousView.putExtra("kFavInfoLocalId", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_localId);
                                            paramAnonymousView.putExtra("kFavCanDel", false);
                                            paramAnonymousView.putExtra("kFavCanRemark", false);
                                            com.tencent.mm.br.c.b((Context)localObject6, "location", ".ui.RedirectUI", paramAnonymousView, 1);
                                            continue;
                                          }
                                          if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType != 0) {
                                            continue;
                                          }
                                          paramAnonymousView.putExtra("map_view_type", 1);
                                          com.tencent.mm.br.c.b((Context)localObject6, "location", ".ui.RedirectUI", paramAnonymousView, 1002);
                                          continue;
                                          if (!WeChatBrands.Business.Entries.SessionMusic.checkAvailable(paramAnonymousView.getContext())) {
                                            continue;
                                          }
                                          localObject2 = "";
                                          localObject1 = localObject2;
                                          if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD != null)
                                          {
                                            localObject1 = localObject2;
                                            if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_favProto != null)
                                            {
                                              localObject1 = localObject2;
                                              if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_favProto.iQs() != null) {
                                                localObject1 = ((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_favProto.iQs().appId;
                                              }
                                            }
                                          }
                                          localObject2 = localObject1;
                                          if (Util.isNullOrNil((String)localObject1))
                                          {
                                            localObject2 = localObject1;
                                            if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy != null)
                                            {
                                              localObject2 = localObject1;
                                              if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl() != null)
                                              {
                                                localObject2 = localObject1;
                                                if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl().iQn() != null) {
                                                  localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl().iQn().appId;
                                                }
                                              }
                                            }
                                          }
                                          localObject1 = com.tencent.mm.plugin.comm.a.xeG;
                                          if (com.tencent.mm.plugin.comm.a.aml((String)localObject2))
                                          {
                                            b.a(b.this, paramAnonymousView.getContext(), (com.tencent.mm.plugin.record.ui.a.b)localObject5);
                                            continue;
                                          }
                                          localObject1 = com.tencent.mm.plugin.comm.a.xeG;
                                          if (!com.tencent.mm.plugin.comm.a.dsO())
                                          {
                                            b.a(paramAnonymousView.getContext(), (com.tencent.mm.plugin.record.ui.a.b)localObject5);
                                            continue;
                                          }
                                          b.a(paramAnonymousView.getContext(), (com.tencent.mm.plugin.record.ui.a.b)localObject5);
                                          continue;
                                          b.a(b.this, paramAnonymousView.getContext(), (com.tencent.mm.plugin.record.ui.a.b)localObject5);
                                          continue;
                                          localObject2 = b.this;
                                          localObject1 = paramAnonymousView.getContext();
                                          bh.bCz();
                                          paramAnonymousView = com.tencent.mm.model.c.bzD().sl(((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId);
                                          if ((paramAnonymousView != null) && (paramAnonymousView.getStatus() == 1))
                                          {
                                            com.tencent.mm.ui.base.aa.makeText((Context)localObject1, R.l.favorite_record_sending_info_error, 0).show();
                                            continue;
                                          }
                                          long l = ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId;
                                          bh.bCz();
                                          localObject3 = com.tencent.mm.model.c.bzD().sl(l);
                                          if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD != null)
                                          {
                                            paramAnonymousView = String.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_id);
                                            ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).g(HandOffFile.fromFavItem(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, paramAnonymousView, (cc)localObject3, com.tencent.mm.plugin.fav.a.b.d(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy)));
                                            if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 0)
                                            {
                                              if ((!q.d(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId)) || (com.tencent.mm.pluginsdk.ui.tools.a.aK(q.c(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId), ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQj(), 2))) {
                                                break label5459;
                                              }
                                              i = 0;
                                              label5188:
                                              if (i != 0) {
                                                break label5469;
                                              }
                                              bh.bCz();
                                              paramAnonymousView = com.tencent.mm.model.c.bzD().sl(((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId);
                                              if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQk() <= 26214400L) {
                                                break label5464;
                                              }
                                            }
                                            label5459:
                                            label5464:
                                            for (i = 7;; i = 5)
                                            {
                                              com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1203L, 0L, 1L, false);
                                              paramAnonymousView = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQi(), Integer.valueOf(i), Long.valueOf(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQk()), Integer.valueOf(4), Long.valueOf((com.tencent.mm.model.cn.bDv() - paramAnonymousView.getCreateTime()) / 1000L), ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQj(), paramAnonymousView.aJK(), Integer.valueOf(2), ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iOk(), Long.valueOf(paramAnonymousView.aJH()), Long.valueOf(paramAnonymousView.getCreateTime()), Long.valueOf(com.tencent.mm.model.cn.bDu()), Integer.valueOf(1) });
                                              Log.i("MicroMsg.OtherViewWrapper", "reportKVStat 14665 %s", new Object[] { paramAnonymousView });
                                              com.tencent.mm.plugin.report.service.h.OAn.kvStat(14665, paramAnonymousView);
                                              break;
                                              if ((((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 1) && (com.tencent.mm.plugin.record.model.i.c((com.tencent.mm.plugin.record.ui.a.b)localObject5)) && (!com.tencent.mm.pluginsdk.ui.tools.a.aK(com.tencent.mm.plugin.record.model.i.a((com.tencent.mm.plugin.record.ui.a.b)localObject5), ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQj(), 2)))
                                              {
                                                i = 0;
                                                break label5188;
                                              }
                                              i = 1;
                                              break label5188;
                                            }
                                            label5469:
                                            if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 0)
                                            {
                                              paramAnonymousView = new Intent((Context)localObject1, RecordMsgFileUI.class);
                                              paramAnonymousView.putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId);
                                              if (((b)localObject2).fromScene == 2) {
                                                paramAnonymousView.putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hXv);
                                              }
                                              paramAnonymousView.putExtra("record_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iOk());
                                              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                                              com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramAnonymousView.aYi(), "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper", "goToFile", "(Landroid/content/Context;Lcom/tencent/mm/plugin/record/ui/recordData/RecordData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                              ((Context)localObject1).startActivity((Intent)paramAnonymousView.sb(0));
                                              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper", "goToFile", "(Landroid/content/Context;Lcom/tencent/mm/plugin/record/ui/recordData/RecordData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                              continue;
                                            }
                                            if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType != 1) {
                                              continue;
                                            }
                                            if (q.i(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId))
                                            {
                                              paramAnonymousView = new Intent();
                                              paramAnonymousView.putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_localId);
                                              com.tencent.mm.plugin.fav.a.b.a((Context)localObject1, ".ui.detail.FavoriteImgDetailUI", paramAnonymousView, 1);
                                              continue;
                                            }
                                            paramAnonymousView = new Intent();
                                            paramAnonymousView.putExtra("key_detail_info_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_localId);
                                            paramAnonymousView.putExtra("key_detail_data_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iOk());
                                            paramAnonymousView.putExtra("key_detail_can_delete", false);
                                            com.tencent.mm.plugin.fav.a.b.a((Context)localObject1, ".ui.detail.FavoriteFileDetailUI", paramAnonymousView, 1);
                                            continue;
                                            paramAnonymousView = paramAnonymousView.getContext();
                                            if ((((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl() == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl().iQo() == null))
                                            {
                                              Log.w("MicroMsg.OtherViewWrapper", "go to product error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iOk() });
                                              com.tencent.mm.ui.base.k.cW(paramAnonymousView, paramAnonymousView.getString(R.l.favorite_record_info_error));
                                              continue;
                                            }
                                            localObject1 = new Intent();
                                            ((Intent)localObject1).putExtra("key_Product_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl().iQo().getInfo());
                                            if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 1)
                                            {
                                              ((Intent)localObject1).putExtra("key_is_favorite_item", true);
                                              ((Intent)localObject1).putExtra("key_favorite_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_localId);
                                              ((Intent)localObject1).putExtra("key_can_delete_favorite_item", false);
                                              ((Intent)localObject1).putExtra("key_ProductUI_getProductInfoScene", 3);
                                            }
                                            com.tencent.mm.br.c.b(paramAnonymousView, "scanner", ".ui.ProductUI", (Intent)localObject1, 1);
                                            continue;
                                            paramAnonymousView = paramAnonymousView.getContext();
                                            if ((((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl() == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl().iQo() == null))
                                            {
                                              Log.w("MicroMsg.OtherViewWrapper", "go to mall product error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iOk() });
                                              com.tencent.mm.ui.base.k.cW(paramAnonymousView, paramAnonymousView.getString(R.l.favorite_record_info_error));
                                              continue;
                                            }
                                            localObject1 = new Intent();
                                            ((Intent)localObject1).putExtra("key_product_info", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl().iQo().getInfo());
                                            if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 1) {
                                              ((Intent)localObject1).putExtra("key_product_scene", 4);
                                            }
                                            com.tencent.mm.br.c.b(paramAnonymousView, "product", ".ui.MallProductUI", (Intent)localObject1, 1);
                                            continue;
                                            paramAnonymousView = paramAnonymousView.getContext();
                                            if ((((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl() == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl().iQp() == null))
                                            {
                                              Log.w("MicroMsg.OtherViewWrapper", "go to tv error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iOk() });
                                              com.tencent.mm.ui.base.k.cW(paramAnonymousView, paramAnonymousView.getString(R.l.favorite_record_info_error));
                                              continue;
                                            }
                                            localObject1 = new Intent();
                                            ((Intent)localObject1).putExtra("key_TV_getProductInfoScene", 3);
                                            ((Intent)localObject1).putExtra("key_TV_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQl().iQp().hZn);
                                            if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType == 1)
                                            {
                                              ((Intent)localObject1).putExtra("key_is_favorite_item", true);
                                              ((Intent)localObject1).putExtra("key_favorite_local_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).xvD.field_localId);
                                              ((Intent)localObject1).putExtra("key_can_delete_favorite_item", false);
                                            }
                                            com.tencent.mm.br.c.b(paramAnonymousView, "shake", ".ui.TVInfoUI", (Intent)localObject1, 1);
                                            continue;
                                            paramAnonymousView = paramAnonymousView.getContext();
                                            if (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.Zzy == null)
                                            {
                                              Log.w("MicroMsg.OtherViewWrapper", "go to friend card error, get data proto item null, dataid[%s]", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.hIQ });
                                              com.tencent.mm.ui.base.k.cZ(paramAnonymousView, paramAnonymousView.getString(R.l.favorite_record_info_error));
                                              continue;
                                            }
                                            localObject2 = ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.desc;
                                            bh.bCz();
                                            localObject1 = com.tencent.mm.model.c.bzD().aLU((String)localObject2);
                                            if (localObject1 == null)
                                            {
                                              Log.w("MicroMsg.OtherViewWrapper", "go to friend card error, parse content fail,[%s], dataid[%s]", new Object[] { localObject2, ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.hIQ });
                                              com.tencent.mm.ui.base.k.cZ(paramAnonymousView, paramAnonymousView.getString(R.l.favorite_record_info_error));
                                              continue;
                                            }
                                            if ((ab.IS(((cc.a)localObject1).hgk)) && (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramAnonymousView))) {
                                              continue;
                                            }
                                            localObject2 = new Intent();
                                            ((Intent)localObject2).putExtra("Contact_User", ((cc.a)localObject1).hgk);
                                            ((Intent)localObject2).putExtra("Contact_Alias", ((cc.a)localObject1).kDc);
                                            ((Intent)localObject2).putExtra("Contact_Nick", ((cc.a)localObject1).nickname);
                                            ((Intent)localObject2).putExtra("Contact_QuanPin", ((cc.a)localObject1).pTY);
                                            ((Intent)localObject2).putExtra("Contact_PyInitial", ((cc.a)localObject1).pTX);
                                            ((Intent)localObject2).putExtra("Contact_Uin", ((cc.a)localObject1).MXS);
                                            ((Intent)localObject2).putExtra("Contact_Mobile_MD5", ((cc.a)localObject1).adkz);
                                            ((Intent)localObject2).putExtra("Contact_full_Mobile_MD5", ((cc.a)localObject1).adkA);
                                            ((Intent)localObject2).putExtra("Contact_QQNick", ((cc.a)localObject1).jcv());
                                            ((Intent)localObject2).putExtra("User_From_Fmessage", false);
                                            ((Intent)localObject2).putExtra("Contact_Scene", ((cc.a)localObject1).scene);
                                            ((Intent)localObject2).putExtra("Contact_FMessageCard", true);
                                            ((Intent)localObject2).putExtra("Contact_RemarkName", ((cc.a)localObject1).pUc);
                                            ((Intent)localObject2).putExtra("Contact_VUser_Info_Flag", ((cc.a)localObject1).WAW);
                                            ((Intent)localObject2).putExtra("Contact_VUser_Info", ((cc.a)localObject1).verifyInfo);
                                            ((Intent)localObject2).putExtra("Contact_BrandIconURL", ((cc.a)localObject1).MVy);
                                            ((Intent)localObject2).putExtra("Contact_Province", ((cc.a)localObject1).getProvince());
                                            ((Intent)localObject2).putExtra("Contact_City", ((cc.a)localObject1).getCity());
                                            ((Intent)localObject2).putExtra("Contact_Sex", ((cc.a)localObject1).sex);
                                            ((Intent)localObject2).putExtra("Contact_Signature", ((cc.a)localObject1).signature);
                                            ((Intent)localObject2).putExtra("Contact_ShowUserName", false);
                                            ((Intent)localObject2).putExtra("Contact_KSnsIFlag", 0);
                                            b.aF(paramAnonymousView, (Intent)localObject2);
                                            com.tencent.mm.br.c.b(paramAnonymousView, "profile", ".ui.ContactInfoUI", (Intent)localObject2, 1);
                                            com.tencent.mm.bs.a.axl(((cc.a)localObject1).scene);
                                            continue;
                                            paramAnonymousView = paramAnonymousView.getContext();
                                            localObject1 = ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).RD(((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.getDesc());
                                            if (localObject1 == null)
                                            {
                                              Log.w("MicroMsg.OtherViewWrapper", "go to kefu card error, desc: %s", new Object[] { ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.getDesc() });
                                              com.tencent.mm.ui.base.k.cW(paramAnonymousView, paramAnonymousView.getString(R.l.favorite_record_info_error));
                                              continue;
                                            }
                                            localObject2 = new OpenIMKefuStartConversationRequest();
                                            ((OpenIMKefuStartConversationRequest)localObject2).context = paramAnonymousView;
                                            ((OpenIMKefuStartConversationRequest)localObject2).prw = 2;
                                            ((OpenIMKefuStartConversationRequest)localObject2).prx = com.tencent.mm.openim.api.h.a.xD(((OpenIMKefuStartConversationRequest)localObject2).prw);
                                            ((OpenIMKefuStartConversationRequest)localObject2).prE = true;
                                            ((OpenIMKefuStartConversationRequest)localObject2).prB = true;
                                            ((OpenIMKefuStartConversationRequest)localObject2).prD = true;
                                            ((OpenIMKefuStartConversationRequest)localObject2).prz = true;
                                            ((OpenIMKefuStartConversationRequest)localObject2).prA = paramAnonymousView.getString(R.l.open_im_kefu_start_conversation_error_tips);
                                            ((OpenIMKefuStartConversationRequest)localObject2).pry = new du();
                                            ((OpenIMKefuStartConversationRequest)localObject2).pry.YFW = ((com.tencent.mm.openim.a.e)localObject1).hFb;
                                            ((OpenIMKefuStartConversationRequest)localObject2).pry.username = ((com.tencent.mm.openim.a.e)localObject1).username;
                                            ((OpenIMKefuStartConversationRequest)localObject2).hBk = System.currentTimeMillis();
                                            ((com.tencent.mm.openim.api.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.d.class)).a((OpenIMKefuStartConversationRequest)localObject2);
                                            continue;
                                            localObject1 = b.this;
                                            paramAnonymousView = paramAnonymousView.getContext();
                                            if ((paramAnonymousView == null) || (((com.tencent.mm.plugin.record.ui.a.b)localObject5).dataType != 0) || (((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQm() == null)) {
                                              continue;
                                            }
                                            localObject2 = new Intent(paramAnonymousView, RecordMsgDetailUI.class);
                                            ((Intent)localObject2).putExtra("message_id", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).msgId);
                                            ((Intent)localObject2).putExtra("record_xml", ((com.tencent.mm.plugin.record.ui.a.b)localObject5).hIy.iQm());
                                            ((Intent)localObject2).putExtra("record_nest", true);
                                            ((Intent)localObject2).putExtra("from_scene", ((b)localObject1).fromScene);
                                            b.aF(paramAnonymousView, (Intent)localObject2);
                                            localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
                                            com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper", "goToRecord", "(Landroid/content/Context;Lcom/tencent/mm/plugin/record/ui/recordData/RecordData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                                            com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper", "goToRecord", "(Landroid/content/Context;Lcom/tencent/mm/plugin/record/ui/recordData/RecordData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                            continue;
                                            b.b(b.this, paramAnonymousView.getContext(), (com.tencent.mm.plugin.record.ui.a.b)localObject5);
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                              catch (IOException localIOException3)
                              {
                                for (;;)
                                {
                                  continue;
                                  paramAnonymousView = null;
                                  continue;
                                  localObject2 = null;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    };
    this.Aot = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(28016);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        if (!com.tencent.mm.compatible.util.e.aPU())
        {
          com.tencent.mm.ui.base.aa.j(paramAnonymousView.getContext(), null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28016);
          return;
        }
        localObject = (com.tencent.mm.plugin.record.ui.a.b)paramAnonymousView.getTag();
        if (b.f(((com.tencent.mm.plugin.record.ui.a.b)localObject).hIy))
        {
          Log.i("MicroMsg.OtherViewWrapper", "same song, do release");
          paramAnonymousView = new kn();
          paramAnonymousView.ioV = 2L;
          paramAnonymousView.iqr = 16L;
          cp.a(paramAnonymousView);
          com.tencent.mm.aw.a.bLi();
          if (!b.this.NCL) {
            b.this.handler.sendMessageAtFrontOfQueue(b.this.handler.obtainMessage(1));
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/record/ui/viewWrappers/OtherViewWrapper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(28016);
          return;
        }
        b.this.NCL = true;
        arh localarh = ((com.tencent.mm.plugin.record.ui.a.b)localObject).hIy.Zzy.ZAf;
        paramAnonymousView = new u(q.f(((com.tencent.mm.plugin.record.ui.a.b)localObject).hIy, ((com.tencent.mm.plugin.record.ui.a.b)localObject).msgId));
        label231:
        arf localarf;
        if (!paramAnonymousView.jKS()) {
          if (((com.tencent.mm.plugin.record.ui.a.b)localObject).hIy.hDd == null)
          {
            paramAnonymousView = "";
            localarf = ((com.tencent.mm.plugin.record.ui.a.b)localObject).hIy;
            if (localarf.Zzy == null) {
              break label555;
            }
          }
        }
        label555:
        for (localObject = localarf.Zzy.ZAJ;; localObject = null)
        {
          String str1 = localarf.title;
          String str2 = localarf.desc;
          String str3 = localarf.ZyM;
          String str4 = localarf.ZyQ;
          String str5 = localarf.ZyO;
          String str6 = localarf.hIQ;
          StringBuilder localStringBuilder = new StringBuilder();
          bh.bCz();
          paramAnonymousView = com.tencent.mm.aw.i.a(6, null, str1, str2, str3, str4, str5, str6, com.tencent.mm.model.c.bzV() + "web/", paramAnonymousView, "", localarh.appId, com.tencent.mm.aw.h.a(localarf.hIQ, (dtj)localObject));
          paramAnonymousView.oOM = localarf.songAlbumUrl;
          paramAnonymousView.oOE = localarf.songLyric;
          if ((localarf.Zzy != null) && (localarf.Zzy.ZAJ != null) && (!Util.isNullOrNil(localarf.Zzy.ZAJ.oOZ))) {
            paramAnonymousView.oOZ = localarf.Zzy.ZAJ.oOZ;
          }
          paramAnonymousView.oOW = localarf.hIQ;
          com.tencent.mm.aw.a.c(paramAnonymousView);
          paramAnonymousView = new kn();
          paramAnonymousView.ioV = 1L;
          paramAnonymousView.iqr = 16L;
          cp.a(paramAnonymousView);
          break;
          paramAnonymousView = new StringBuilder();
          bh.bCz();
          paramAnonymousView = new u(com.tencent.mm.model.c.bzV() + "web/" + com.tencent.mm.b.g.getMessageDigest(((com.tencent.mm.plugin.record.ui.a.b)localObject).hIy.hDd.getBytes()));
          if (paramAnonymousView.jKS()) {}
          for (paramAnonymousView = com.tencent.mm.vfs.ah.v(paramAnonymousView.jKT());; paramAnonymousView = "") {
            break;
          }
          paramAnonymousView = com.tencent.mm.vfs.ah.v(paramAnonymousView.jKT());
          break label231;
        }
      }
    };
    this.rDF = new OtherViewWrapper.3(this, com.tencent.mm.app.f.hfK);
    this.Akp = new OtherViewWrapper.4(this, com.tencent.mm.app.f.hfK);
    this.NBA = parama;
    this.handler = paramMMHandler;
    AppMethodBeat.o(28018);
  }
  
  static void a(Intent paramIntent, com.tencent.mm.plugin.record.ui.a.b paramb, Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(28024);
    a(paramIntent, paramb, paramContext, paramString1, paramString2, true);
    AppMethodBeat.o(28024);
  }
  
  static void a(Intent paramIntent, com.tencent.mm.plugin.record.ui.a.b paramb, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(28025);
    paramIntent.putExtra("key_detail_fav_path", paramString1);
    paramIntent.putExtra("key_detail_fav_thumb_path", paramString2);
    paramIntent.putExtra("key_detail_fav_video_duration", paramb.hIy.duration);
    paramIntent.putExtra("key_detail_statExtStr", paramb.hIy.iah);
    paramIntent.putExtra("key_detail_is_data_exist", paramBoolean);
    paramIntent.putExtra("key_detail_msg_uuid", paramb.hIy.pbn);
    com.tencent.mm.plugin.fav.a.b.a(paramContext, ".ui.detail.FavoriteVideoPlayUI", paramIntent, 1);
    AppMethodBeat.o(28025);
  }
  
  static void aF(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(28026);
    if ((paramContext instanceof Activity))
    {
      paramContext = ((Activity)paramContext).getIntent();
      if (paramContext != null)
      {
        paramIntent.putExtra("prePublishId", paramContext.getStringExtra("prePublishId"));
        paramIntent.putExtra("preUsername", paramContext.getStringExtra("preUsername"));
        paramIntent.putExtra("preChatName", paramContext.getStringExtra("preChatName"));
        paramIntent.putExtra("preChatTYPE", paramContext.getIntExtra("preChatTYPE", 0));
      }
    }
    AppMethodBeat.o(28026);
  }
  
  public static boolean f(arf paramarf)
  {
    AppMethodBeat.i(28021);
    com.tencent.mm.aw.f localf = com.tencent.mm.aw.a.bLn();
    if ((localf != null) && (localf.oOt == 6) && (Util.nullAs(paramarf.hIQ, "").equals(localf.oOv)) && (com.tencent.mm.aw.a.bLk()))
    {
      AppMethodBeat.o(28021);
      return true;
    }
    AppMethodBeat.o(28021);
    return false;
  }
  
  private static String getAppName(Context paramContext, String paramString)
  {
    AppMethodBeat.i(28020);
    am.b localb = am.a.okN;
    if (localb != null)
    {
      paramContext = localb.x(paramContext, paramString);
      AppMethodBeat.o(28020);
      return paramContext;
    }
    AppMethodBeat.o(28020);
    return "";
  }
  
  private static void x(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(305312);
    if (Util.isNullOrNil(paramString))
    {
      paramImageView.setImageResource(R.g.default_avatar);
      AppMethodBeat.o(305312);
      return;
    }
    a.b.g(paramImageView, paramString);
    AppMethodBeat.o(305312);
  }
  
  public final void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(28022);
    TextView localTextView2 = (TextView)paramView.findViewById(R.h.title);
    Object localObject2 = (TextView)paramView.findViewById(R.h.desc);
    TextView localTextView1 = (TextView)paramView.findViewById(R.h.source);
    paramObject = (MMImageView)paramView.findViewById(R.h.icon);
    Object localObject4 = paramView.findViewById(R.h.fUq);
    paramObject.setVisibility(0);
    ((View)localObject4).setVisibility(0);
    ImageView localImageView = (ImageView)paramView.findViewById(R.h.fJS);
    localImageView.setVisibility(8);
    Object localObject1 = paramView.findViewById(R.h.fUs);
    ((View)localObject1).setVisibility(0);
    ((View)localObject1).setTag(paramb);
    ((View)localObject1).setOnClickListener(this.dpY);
    paramView = paramView.findViewById(R.h.gbk);
    paramView.setVisibility(8);
    Object localObject3 = new h.a.a();
    if (paramb.dataType == 0) {
      ((h.a.a)localObject3).NBD = paramb.msgId;
    }
    for (;;)
    {
      ((h.a.a)localObject3).hIz = paramObject;
      ((h.a.a)localObject3).hIy = paramb.hIy;
      ((h.a.a)localObject3).height = this.Aod;
      ((h.a.a)localObject3).width = this.Aod;
      switch (paramb.hIy.dataType)
      {
      case 9: 
      case 12: 
      case 13: 
      case 18: 
      case 20: 
      case 21: 
      case 24: 
      case 25: 
      default: 
        ((View)localObject1).setVisibility(8);
        paramView.setVisibility(0);
        AppMethodBeat.o(28022);
        return;
        if (paramb.dataType == 1) {
          ((h.a.a)localObject3).NBD = paramb.xvD.field_localId;
        }
        break;
      }
    }
    localObject4 = paramb.hIy;
    paramView = "";
    localObject1 = null;
    paramObject = localObject1;
    if (localObject4 != null)
    {
      paramObject = localObject1;
      if (((arf)localObject4).Zzy != null) {
        paramObject = ((arf)localObject4).Zzy.ZAj;
      }
    }
    if (paramObject != null) {
      paramView = paramObject.title;
    }
    localObject1 = paramView;
    if (Util.isNullOrNil(paramView))
    {
      localObject1 = paramView;
      if (localObject4 != null) {
        localObject1 = ((arf)localObject4).title;
      }
    }
    if (Util.isNullOrNil((String)localObject1))
    {
      localTextView2.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      paramView = "";
      if (paramObject != null) {
        paramView = Util.getHost(paramObject.ZBV);
      }
      paramObject = null;
      localObject2 = paramObject;
      if (localObject4 != null)
      {
        localObject2 = paramObject;
        if (((arf)localObject4).Zzy != null) {
          localObject2 = ((arf)localObject4).Zzy.ZAf;
        }
      }
      localObject1 = paramView;
      if (localObject2 != null)
      {
        if (Util.isNullOrNil(((arh)localObject2).appId)) {
          break label726;
        }
        paramObject = Util.nullAs(getAppName(localTextView1.getContext(), ((arh)localObject2).appId), "");
        label565:
        if (!Util.isNullOrNil(paramObject))
        {
          localObject1 = paramObject;
          if (!paramObject.equals(((arh)localObject2).hzi)) {}
        }
        else
        {
          localObject1 = Util.getHost(((arh)localObject2).link);
        }
      }
      if (!Util.isNullOrNil((String)localObject1)) {
        break label812;
      }
      localTextView1.setVisibility(8);
      label615:
      ((h.a.a)localObject3).hIA = R.g.app_attach_file_icon_pic;
      this.NBA.a((h.a.a)localObject3);
      if ((paramb.hIy != null) && (paramb.hIy.Zzy != null) && (paramb.hIy.Zzy.WKx != null) && (paramb.hIy.Zzy.WKx.nQm == 16))
      {
        localImageView.setVisibility(0);
        localImageView.setImageResource(R.k.shortvideo_play_btn);
      }
    }
    for (;;)
    {
      localTextView1.setVisibility(8);
      AppMethodBeat.o(28022);
      return;
      localTextView2.setText((CharSequence)localObject1);
      localTextView2.setVisibility(0);
      break;
      label726:
      paramObject = paramView;
      if (Util.isNullOrNil(((arh)localObject2).hzi)) {
        break label565;
      }
      bh.bCz();
      paramObject = com.tencent.mm.model.c.bzA().JE(((arh)localObject2).hzi);
      if ((paramObject == null) || (!paramObject.field_username.equals(((arh)localObject2).hzi)))
      {
        az.a.okP.a(((arh)localObject2).hzi, "", null);
        paramObject = paramView;
        break label565;
      }
      paramObject = paramObject.aSV();
      break label565;
      label812:
      localTextView1.setText((CharSequence)localObject1);
      localTextView1.setVisibility(0);
      break label615;
      if (com.tencent.mm.plugin.fav.a.b.dQh())
      {
        ((View)localObject1).setVisibility(8);
        paramView.setVisibility(0);
      }
      else
      {
        paramView = paramb.hIy;
        if ((paramView.Zzy != null) && (paramView.Zzy.ZAB != null))
        {
          localObject1 = paramView.Zzy.ZAB;
          paramb = ((bvl)localObject1).nickname;
          paramView = paramb;
          if (((bvl)localObject1).mIK != null)
          {
            paramView = paramb;
            if (!((bvl)localObject1).mIK.isEmpty()) {
              paramView = ((bvl)localObject1).mIK;
            }
          }
          localTextView2.setText(Util.nullAsNil(paramView + MMApplicationContext.getContext().getString(R.l.favorite_sub_title_finder_tail)));
          localTextView2.setVisibility(0);
          ((TextView)localObject2).setVisibility(8);
          if (!Util.isNullOrNil(((bvl)localObject1).mediaList))
          {
            paramView = com.tencent.mm.loader.e.noo;
            paramView = com.tencent.mm.loader.e.blh();
            paramb = ((bvj)((bvl)localObject1).mediaList.get(0)).thumbUrl;
            localObject1 = this.NCN;
            ((e.a)localObject1).nqd = true;
            ((e.a)localObject1).nqc = true;
            paramView.a(paramb, paramObject, ((e.a)localObject1).blI());
          }
        }
        localImageView.setVisibility(8);
        continue;
        if (com.tencent.mm.plugin.fav.a.b.dQh())
        {
          ((View)localObject1).setVisibility(8);
          paramView.setVisibility(0);
        }
        else
        {
          paramView = paramb.hIy;
          if ((paramView.Zzy != null) && (paramView.Zzy.ZAD != null))
          {
            paramView = paramView.Zzy.ZAD;
            localTextView2.setText(Util.nullAsNil(paramView.nickName + MMApplicationContext.getContext().getString(R.l.favorite_sub_title_finder_live_tail)));
            localTextView2.setVisibility(0);
            ((TextView)localObject2).setVisibility(8);
            if (!Util.isNullOrNil(paramView.coverUrl))
            {
              paramb = com.tencent.mm.loader.e.noo;
              paramb = com.tencent.mm.loader.e.blh();
              paramView = paramView.coverUrl;
              localObject1 = this.NCN;
              ((e.a)localObject1).nqd = true;
              ((e.a)localObject1).nqc = true;
              paramb.a(paramView, paramObject, ((e.a)localObject1).blI());
            }
          }
          localImageView.setVisibility(8);
          continue;
          if (com.tencent.mm.plugin.fav.a.b.dQh())
          {
            ((View)localObject1).setVisibility(8);
            paramView.setVisibility(0);
            label1219:
            if (!com.tencent.mm.plugin.fav.a.b.dQh()) {
              break label1389;
            }
            ((View)localObject1).setVisibility(8);
            paramView.setVisibility(0);
          }
          for (;;)
          {
            if (!com.tencent.mm.plugin.fav.a.b.dQh()) {
              break label1520;
            }
            ((View)localObject1).setVisibility(8);
            paramView.setVisibility(0);
            break;
            localObject4 = paramb.hIy;
            e.a locala;
            if ((((arf)localObject4).Zzy != null) && (((arf)localObject4).Zzy.ZAN != null))
            {
              localObject3 = ((arf)localObject4).Zzy.ZAN;
              localTextView2.setText(Util.nullAsNil(((arf)localObject4).title));
              localTextView2.setVisibility(0);
              ((TextView)localObject2).setVisibility(8);
              if (!Util.isNullOrNil(((bvn)localObject3).iconUrl))
              {
                localObject4 = com.tencent.mm.loader.e.noo;
                localObject4 = com.tencent.mm.loader.e.blh();
                localObject3 = ((bvn)localObject3).iconUrl;
                locala = this.NCN;
                locala.nqd = true;
                locala.nqc = true;
                ((com.tencent.mm.loader.a)localObject4).a((String)localObject3, paramObject, locala.blI());
              }
            }
            localImageView.setVisibility(8);
            break label1219;
            label1389:
            localObject4 = paramb.hIy;
            if ((((arf)localObject4).Zzy != null) && (((arf)localObject4).Zzy.ZAL != null))
            {
              localObject3 = ((arf)localObject4).Zzy.ZAL;
              localTextView2.setText(Util.nullAsNil(((arf)localObject4).title));
              localTextView2.setVisibility(0);
              ((TextView)localObject2).setVisibility(8);
              if (!Util.isNullOrNil(((bvn)localObject3).iconUrl))
              {
                localObject4 = com.tencent.mm.loader.e.noo;
                localObject4 = com.tencent.mm.loader.e.blh();
                localObject3 = ((bvn)localObject3).iconUrl;
                locala = this.NCN;
                locala.nqd = true;
                locala.nqc = true;
                ((com.tencent.mm.loader.a)localObject4).a((String)localObject3, paramObject, locala.blI());
              }
            }
            localImageView.setVisibility(8);
          }
          label1520:
          paramb = paramb.hIy;
          if ((paramb.Zzy != null) && (paramb.Zzy.ZAF != null))
          {
            paramView = paramb.Zzy.ZAF;
            localTextView2.setText(Util.nullAsNil(paramb.title));
            localTextView2.setVisibility(0);
            ((TextView)localObject2).setVisibility(8);
            if (!Util.isNullOrNil(paramView.avatar))
            {
              paramb = com.tencent.mm.loader.e.noo;
              paramb = com.tencent.mm.loader.e.blh();
              paramView = paramView.avatar;
              localObject1 = this.NCN;
              ((e.a)localObject1).nqd = true;
              ((e.a)localObject1).nqc = true;
              paramb.a(paramView, paramObject, ((e.a)localObject1).blI());
            }
          }
          localImageView.setVisibility(8);
          continue;
          if (com.tencent.mm.plugin.fav.a.b.dQh())
          {
            ((View)localObject1).setVisibility(8);
            paramView.setVisibility(0);
          }
          else
          {
            paramb = paramb.hIy;
            if ((paramb.Zzy != null) && (paramb.Zzy.ZAH != null))
            {
              paramView = paramb.Zzy.ZAH;
              localTextView2.setText(Util.nullAsNil(paramb.title));
              localTextView2.setVisibility(0);
              ((TextView)localObject2).setVisibility(8);
              if (!Util.isNullOrNil(paramView.aacP))
              {
                paramb = new StringBuilder((String)paramView.aacP.getFirst());
                if (!Util.isNullOrNil(paramView.aacQ)) {
                  paramb.append((String)paramView.aacQ.getFirst());
                }
                paramView = com.tencent.mm.loader.e.noo;
                paramView = com.tencent.mm.loader.e.blh();
                paramb = paramb.toString();
                localObject1 = this.NCN;
                ((e.a)localObject1).nqd = true;
                ((e.a)localObject1).nqc = true;
                paramView.a(paramb, paramObject, ((e.a)localObject1).blI());
              }
            }
            localImageView.setVisibility(8);
            continue;
            paramb = paramb.hIy;
            if (Util.isNullOrNil(paramb.title))
            {
              localTextView2.setText(R.l.favorite_video);
              label1843:
              if (paramb.duration > 0) {
                break label1938;
              }
              ((TextView)localObject2).setVisibility(8);
              if (paramb.Zzy != null) {
                break label2059;
              }
              Log.w("MicroMsg.OtherViewWrapper", "video, get data proto item null, dataid[%s]", new Object[] { paramb.hIQ });
              localTextView1.setVisibility(8);
            }
            for (;;)
            {
              localImageView.setVisibility(0);
              localImageView.setImageResource(R.k.shortvideo_play_btn);
              ((h.a.a)localObject3).hIA = R.k.app_attach_file_icon_video;
              this.NBA.a((h.a.a)localObject3);
              break;
              localTextView2.setText(paramb.title);
              break label1843;
              label1938:
              ((TextView)localObject2).setVisibility(0);
              paramView = ((TextView)localObject2).getContext();
              int i = paramb.duration;
              if (i <= 0) {
                paramView = paramView.getString(R.l.favorite_voice_length, new Object[] { Integer.valueOf(0) });
              }
              for (;;)
              {
                ((TextView)localObject2).setText(paramView);
                break;
                paramInt = i / 60;
                i %= 60;
                if (paramInt == 0) {
                  paramView = paramView.getString(R.l.favorite_voice_length, new Object[] { Integer.valueOf(i) });
                } else {
                  paramView = paramView.getString(R.l.favorite_video_length, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
                }
              }
              label2059:
              paramView = paramb.Zzy.ZAf;
              if (!Util.isNullOrNil(paramView.appId))
              {
                paramView = getAppName(localTextView1.getContext(), paramView.appId);
                if (Util.isNullOrNil(paramView))
                {
                  localTextView1.setVisibility(8);
                }
                else
                {
                  localTextView1.setVisibility(0);
                  localTextView1.setText(paramView);
                }
              }
            }
            paramView = paramb.hIy;
            if (paramView.Zzy == null)
            {
              Log.w("MicroMsg.OtherViewWrapper", "location, get data proto item null, dataid[%s]", new Object[] { paramView.hIQ });
              localTextView2.setText(R.l.favorite_location);
              ((TextView)localObject2).setText("");
              localTextView1.setText("");
            }
            for (;;)
            {
              paramObject.setImageResource(R.k.app_attach_file_icon_location);
              break;
              paramView = paramView.Zzy.ZAh;
              if (Util.isNullOrNil(paramView.hVI))
              {
                localTextView2.setText(paramView.label);
                ((TextView)localObject2).setText(R.l.favorite_location);
                localTextView1.setText("");
              }
              else
              {
                localTextView2.setText(paramView.hVI);
                ((TextView)localObject2).setText(paramView.label);
                localTextView1.setText(R.l.favorite_location);
              }
            }
            localTextView2.setText(paramb.hIy.title);
            ((TextView)localObject2).setText(paramb.hIy.desc);
            localImageView.setTag(paramb);
            localImageView.setOnClickListener(this.Aot);
            localImageView.setImageResource(R.g.music_playicon);
            localImageView.setVisibility(0);
            if (f(paramb.hIy)) {
              localImageView.setImageResource(R.g.music_pauseicon);
            }
            localTextView1.setVisibility(8);
            ((h.a.a)localObject3).hIA = R.k.app_attach_file_icon_music;
            this.NBA.a((h.a.a)localObject3);
            continue;
            paramView = paramb.hIy;
            localTextView2.setText(paramView.title);
            ((TextView)localObject2).setVisibility(0);
            ((TextView)localObject2).setText(Util.getLengthStr((float)paramView.Zza));
            localTextView1.setVisibility(8);
            if (paramView.ZzM == 2) {
              ((TextView)localObject2).setText(">" + ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFileSizeLimitInMB(false) + "MB");
            }
            paramObject.setImageResource(com.tencent.mm.pluginsdk.f.boR(paramb.hIy.ZyU));
            continue;
            paramView = paramb.hIy;
            if (paramView.Zzy == null)
            {
              Log.w("MicroMsg.OtherViewWrapper", "product, get data proto item null, dataid[%s]", new Object[] { paramView.hIQ });
              localTextView2.setText("");
              ((TextView)localObject2).setText("");
              localTextView1.setText("");
            }
            for (;;)
            {
              ((h.a.a)localObject3).hIA = R.k.app_attach_file_icon_unknow;
              this.NBA.a((h.a.a)localObject3);
              break;
              paramb = paramView.Zzy.ZAl;
              localTextView2.setText(paramb.title);
              ((TextView)localObject2).setText(paramb.desc);
              paramView = paramView.Zzy.ZAf;
              localTextView1.setText(Util.nullAs(getAppName(localTextView1.getContext(), paramView.appId), localTextView1.getContext().getString(R.l.favorite_product)));
            }
            paramView = paramb.hIy;
            if (paramView.Zzy == null)
            {
              Log.w("MicroMsg.OtherViewWrapper", "mall product, get data proto item null, dataid[%s]", new Object[] { paramView.hIQ });
              localTextView2.setText("");
              ((TextView)localObject2).setText("");
              localTextView1.setText("");
            }
            for (;;)
            {
              ((h.a.a)localObject3).hIA = R.k.app_attach_file_icon_unknow;
              ((h.a.a)localObject3).hIy = null;
              this.NBA.a((h.a.a)localObject3);
              break;
              paramView = paramView.Zzy.ZAl;
              localTextView2.setText(paramView.title);
              ((TextView)localObject2).setText(paramView.desc);
              localTextView2.setSingleLine(false);
              localTextView2.setMaxLines(2);
              localTextView1.setVisibility(8);
            }
            paramView = paramb.hIy;
            if ((paramView.Zzy == null) || (paramView.Zzy.ZAn == null))
            {
              Log.w("MicroMsg.OtherViewWrapper", "tv, get data proto item null, dataid[%s]", new Object[] { paramView.hIQ });
              localTextView2.setText("");
              ((TextView)localObject2).setText("");
              localTextView1.setText("");
            }
            for (;;)
            {
              ((h.a.a)localObject3).hIA = R.k.app_attach_file_icon_unknow;
              ((h.a.a)localObject3).hIy = null;
              this.NBA.a((h.a.a)localObject3);
              break;
              paramb = paramView.Zzy.ZAn;
              localTextView2.setText(paramb.title);
              ((TextView)localObject2).setText(paramb.desc);
              paramView = paramView.Zzy.ZAf;
              localTextView1.setText(Util.nullAs(getAppName(localTextView1.getContext(), paramView.appId), localTextView1.getContext().getString(R.l.favorite_tv)));
            }
            paramView = paramb.hIy;
            bh.bCz();
            paramb = com.tencent.mm.model.c.bzD().aLU(paramView.desc);
            if (paramb == null) {
              Log.e("MicroMsg.OtherViewWrapper", "parse possible friend msg failed");
            }
            localObject1 = localTextView2.getContext();
            if (paramb != null) {}
            for (paramView = paramb.nickname;; paramView = "")
            {
              localTextView2.setText(p.b((Context)localObject1, paramView, localTextView2.getTextSize()));
              ((TextView)localObject2).setVisibility(8);
              localTextView1.setText(R.l.favorite_friend_card);
              localTextView1.setVisibility(0);
              x(paramObject, paramb.hgk);
              break;
            }
            paramView = paramb.hIy;
            paramView = ((com.tencent.mm.openim.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.c.class)).RD(paramView.desc);
            if (paramView == null)
            {
              Log.e("MicroMsg.OtherViewWrapper", "fillOpenImKefuCardContent parse failed");
              localTextView2.setText("");
              ((TextView)localObject2).setText("");
            }
            else
            {
              localTextView2.setText(Util.nullAsNil(paramView.getDisplayName()));
              localTextView2.setVisibility(0);
              ((TextView)localObject2).setVisibility(8);
              x(paramObject, paramView.username);
              continue;
              paramView = paramb.hIy;
              localTextView2.setText(paramView.title);
              ((TextView)localObject2).setVisibility(0);
              ((TextView)localObject2).setText(paramView.desc);
              paramObject.setVisibility(8);
              ((View)localObject4).setVisibility(8);
              continue;
              localObject1 = paramb.hIy;
              paramInt = paramb.hIy.dataType;
              paramView = "";
              if (localObject1 != null) {
                paramView = ((arf)localObject1).title;
              }
              if (Util.isNullOrNil(paramView))
              {
                localTextView2.setVisibility(8);
                label3179:
                paramView = "";
                if (19 == paramInt) {
                  paramView = ((TextView)localObject2).getContext().getString(R.l.app_brand_entrance);
                }
                if (!Util.isNullOrNil(paramView)) {
                  break label3292;
                }
                ((TextView)localObject2).setVisibility(8);
                label3214:
                paramView = new h.a.c();
                paramView.hIy = paramb.hIy;
                if (paramb.dataType != 0) {
                  break label3307;
                }
                paramView.NBD = paramb.msgId;
              }
              for (;;)
              {
                ((h.a.a)localObject3).hIA = R.g.app_attach_file_icon_pic;
                paramView = this.NBA.a(paramView);
                if (paramView == null) {
                  break label3329;
                }
                paramObject.setImageBitmap(paramView);
                break;
                localTextView2.setText(paramView);
                localTextView2.setVisibility(0);
                break label3179;
                label3292:
                ((TextView)localObject2).setText(paramView);
                ((TextView)localObject2).setVisibility(0);
                break label3214;
                label3307:
                if (paramb.dataType == 1) {
                  paramView.NBD = paramb.xvD.field_localId;
                }
              }
              label3329:
              this.NBA.a((h.a.a)localObject3);
            }
          }
        }
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(28019);
    View localView = View.inflate(paramContext, R.i.gnt, null);
    this.Aod = com.tencent.mm.cd.a.fromDPToPix(paramContext, 75);
    this.rDF.alive();
    this.Akp.alive();
    AppMethodBeat.o(28019);
    return localView;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(28023);
    Log.d("MicroMsg.OtherViewWrapper", "do destroy");
    this.NBA = null;
    this.handler = null;
    this.rDF.dead();
    this.Akp.dead();
    this.NCL = false;
    AppMethodBeat.o(28023);
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.viewWrappers.b
 * JD-Core Version:    0.7.0.1
 */