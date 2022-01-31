package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.gq;
import com.tencent.mm.h.a.rx;
import com.tencent.mm.h.a.ry;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.q.a.a;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.a.b;
import com.tencent.mm.plugin.sns.storage.a.b.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.au.a;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.c.b.a;
import com.tencent.mm.plugin.sns.ui.c.d.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.btk;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class b
{
  Activity activity;
  public View.OnTouchListener ifd;
  private ClipboardManager kgn;
  com.tencent.mm.plugin.sns.model.ae oOe;
  public View.OnClickListener oPK;
  public View.OnClickListener poA;
  public View.OnLongClickListener poB;
  public c poC;
  public View.OnClickListener poD;
  public View.OnClickListener poE;
  public View.OnClickListener poF;
  public View.OnClickListener poG;
  public View.OnClickListener poH;
  public View.OnClickListener poI;
  public View.OnClickListener poJ;
  public View.OnClickListener poK;
  public View.OnClickListener poL;
  public c poM;
  public c poN;
  public c poO;
  public c poP;
  public c poQ;
  public c poR;
  public c poS;
  c poT;
  public View.OnClickListener poU;
  public View.OnClickListener poV;
  public View.OnClickListener poW;
  public View.OnClickListener poX;
  public View.OnClickListener poY;
  public View.OnClickListener poZ;
  public com.tencent.mm.plugin.sight.decode.a.b.e poo;
  volatile com.tencent.mm.plugin.sns.ui.a.b.b pov;
  volatile com.tencent.mm.plugin.sns.ui.a.b.a pow;
  volatile com.tencent.mm.plugin.sns.ui.a.a.b pox;
  volatile com.tencent.mm.plugin.sns.ui.a.a.a poy;
  public a poz;
  public View.OnClickListener ppa;
  public AdapterView.OnItemClickListener ppb;
  public AdapterView.OnItemClickListener ppc;
  public View.OnClickListener ppd = new b.1(this);
  public View.OnClickListener ppe = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      boolean bool = false;
      if (paramAnonymousView.getTag() == null) {}
      n localn;
      do
      {
        return;
        localn = b.dc(paramAnonymousView);
      } while ((localn == null) || (!localn.yr(32)));
      int j;
      int i;
      label72:
      Object localObject;
      label105:
      int k;
      if (localn.bGN().bFZ().bEM())
      {
        j = v.eY(localn.bGN().bFZ().bEH(), localn.bGM());
        if (j > 0)
        {
          i = 1;
          localObject = localn.bGN().bFZ().bEH();
          String str1 = localn.bGM();
          com.tencent.mm.kernel.g.DN();
          String str2 = com.tencent.mm.kernel.a.CL();
          if (i == 0) {
            break label192;
          }
          if (i == 0) {
            break label197;
          }
          k = 0;
          label112:
          v.g((String)localObject, str1, str2, j, k);
          if (i != 0) {}
        }
      }
      for (bool = true;; bool = false)
      {
        localObject = localn.bGe();
        if ((((bxk)localObject).tNr.sPI == 15) && (((bxk)localObject).tNy != 1))
        {
          b.a(b.this, paramAnonymousView, localn, 1002, localn.bGN().bFZ().bEO(), bool);
          return;
          i = 0;
          break label72;
          label192:
          j = 2;
          break label105;
          label197:
          k = 1;
          break label112;
        }
        if (((((bxk)localObject).tNr.sPI != 1) || (((bxk)localObject).tNr.sPJ.size() != 1)) && (((bxk)localObject).tNr.sPI != 7)) {
          break;
        }
        b.b(b.this, paramAnonymousView, localn, 1002, localn.bGN().bFZ().bEO(), bool);
        return;
      }
    }
  };
  public View.OnClickListener ppf;
  public au.a ppg;
  int pph;
  private com.tencent.mm.sdk.b.c<ry> ppi = new b.23(this);
  private com.tencent.mm.sdk.b.c<rx> ppj = new b.33(this);
  public View.OnClickListener ppk = new b.32(this);
  int source = 0;
  
  public b(int paramInt, Activity paramActivity, com.tencent.mm.plugin.sns.model.ae paramae)
  {
    this.source = paramInt;
    this.activity = paramActivity;
    this.oOe = paramae;
    this.pph = bk.getInt(com.tencent.mm.m.g.AA().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
    y.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[] { Integer.valueOf(this.pph) });
    this.kgn = ((ClipboardManager)this.activity.getSystemService("clipboard"));
    this.poz = new a(this.activity, this.source, this.oOe);
    this.poK = new b.34(this);
    this.poV = new b.35(this);
    this.poZ = new b.36(this);
    this.ppa = new b.37(this);
    this.poA = new b.38(this);
    this.poB = new b.2(this);
    this.poC = new b.3(this);
    this.poR = new b.4(this);
    this.poS = new b.5(this);
    this.poO = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.q)) {
          b.this.poT.onCreateContextMenu(paramAnonymousContextMenu, paramAnonymousView, paramAnonymousContextMenuInfo);
        }
      }
      
      public final boolean dd(View paramAnonymousView)
      {
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.q))
        {
          String str = ((com.tencent.mm.plugin.sns.ui.q)paramAnonymousView.getTag()).bJQ;
          n localn = com.tencent.mm.plugin.sns.model.af.bDF().OB(str);
          b.this.poz.a(paramAnonymousView, str, localn.bGe());
          return true;
        }
        return false;
      }
    };
    this.poN = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        int j;
        int i;
        if ((paramAnonymousView != null) && ((paramAnonymousView.getTag() instanceof ao)))
        {
          paramAnonymousContextMenuInfo = ((ao)paramAnonymousView.getTag()).bMB;
          n localn = com.tencent.mm.plugin.sns.model.af.bDF().OB(paramAnonymousContextMenuInfo);
          if (com.tencent.mm.br.d.SP("favorite"))
          {
            paramAnonymousContextMenu.add(0, 2, 0, b.this.activity.getString(i.j.plugin_favorite_opt));
            do localdo = new do();
            localdo.bJZ.bJQ = paramAnonymousContextMenuInfo;
            com.tencent.mm.sdk.b.a.udP.m(localdo);
            if (localdo.bKa.bJy) {
              paramAnonymousContextMenu.add(0, 18, 0, b.this.activity.getString(i.j.app_open));
            }
          }
          com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, localn);
          paramAnonymousContextMenu = paramAnonymousContextMenu.add(0, 21, 0, b.this.activity.getString(i.j.sns_edit_image));
          paramAnonymousContextMenuInfo = new int[2];
          if (paramAnonymousView == null) {
            break label231;
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
          return;
          label231:
          i = 0;
          j = 0;
        }
      }
      
      public final boolean dd(View paramAnonymousView)
      {
        if ((paramAnonymousView.getTag() instanceof ao))
        {
          String str = ((ao)paramAnonymousView.getTag()).bMB;
          n localn = com.tencent.mm.plugin.sns.model.af.bDF().OB(str);
          b.this.poz.a(paramAnonymousView, str, localn.bGe());
          return true;
        }
        return false;
      }
    };
    this.poQ = new c()
    {
      public final void a(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        paramAnonymousContextMenuInfo = paramAnonymousView.getTag();
        if ((paramAnonymousContextMenuInfo instanceof ao)) {
          paramAnonymousContextMenuInfo = ((ao)paramAnonymousContextMenuInfo).bMB;
        }
        for (;;)
        {
          if (paramAnonymousContextMenuInfo != null)
          {
            paramAnonymousContextMenuInfo = com.tencent.mm.plugin.sns.model.af.bDF().OB(paramAnonymousContextMenuInfo);
            bxk localbxk = paramAnonymousContextMenuInfo.bGe();
            if (com.tencent.mm.br.d.SP("favorite")) {
              switch (localbxk.tNr.sPI)
              {
              }
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.sns.abtest.a.a(paramAnonymousContextMenu, paramAnonymousContextMenuInfo);
            return;
            if (!(paramAnonymousContextMenuInfo instanceof com.tencent.mm.plugin.sns.ui.q)) {
              break label151;
            }
            paramAnonymousContextMenuInfo = ((com.tencent.mm.plugin.sns.ui.q)paramAnonymousContextMenuInfo).bJQ;
            break;
            paramAnonymousContextMenu.add(0, 10, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
            continue;
            paramAnonymousContextMenu.add(0, 2, 0, paramAnonymousView.getContext().getString(i.j.plugin_favorite_opt));
          }
          label151:
          paramAnonymousContextMenuInfo = null;
        }
      }
      
      public final boolean dd(View paramAnonymousView)
      {
        Object localObject = paramAnonymousView.getTag();
        if ((localObject instanceof ao)) {
          localObject = ((ao)localObject).bMB;
        }
        for (;;)
        {
          if (localObject != null)
          {
            n localn = com.tencent.mm.plugin.sns.model.af.bDF().OB((String)localObject);
            b.this.poz.a(paramAnonymousView, (String)localObject, localn.bGe());
            return true;
            if ((localObject instanceof com.tencent.mm.plugin.sns.ui.q)) {
              localObject = ((com.tencent.mm.plugin.sns.ui.q)localObject).bJQ;
            }
          }
          else
          {
            return false;
          }
          localObject = null;
        }
      }
    };
    this.oPK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Object localObject1;
        if ((paramAnonymousView.getTag() instanceof ao)) {
          localObject1 = ((ao)paramAnonymousView.getTag()).bMB;
        }
        for (;;)
        {
          Object localObject2 = com.tencent.mm.plugin.sns.storage.h.OB((String)localObject1);
          if (localObject2 == null)
          {
            y.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId " + (String)localObject1);
            return;
            if ((paramAnonymousView.getTag() instanceof a.c))
            {
              localObject1 = ((a.c)paramAnonymousView.getTag()).bJQ;
              continue;
            }
            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a)) {
              localObject1 = ((com.tencent.mm.plugin.sns.ui.b.a.a)paramAnonymousView.getTag()).oUH.bGE();
            }
          }
          else
          {
            if ((((n)localObject2).yr(32)) && (((n)localObject2).bFZ() != null) && ((((n)localObject2).bFZ().bEJ()) || (((n)localObject2).bFZ().bEK())))
            {
              b.this.ppf.onClick(paramAnonymousView);
              return;
            }
            if (((n)localObject2).bGe().tNr.sPI == 21)
            {
              if (com.tencent.mm.model.q.Gj().equals(((n)localObject2).field_userName))
              {
                localObject1 = ((n)localObject2).bGe().lsK;
                com.tencent.mm.plugin.sns.lucky.a.m.m((n)localObject2);
                com.tencent.mm.plugin.sns.lucky.a.m.l((n)localObject2);
                System.currentTimeMillis();
                com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(25);
              }
              if (!com.tencent.mm.model.q.Gj().equals(((n)localObject2).field_userName))
              {
                com.tencent.mm.plugin.sns.lucky.b.a.a(2, (n)localObject2);
                com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(30);
              }
            }
            int i;
            if (((n)localObject2).yr(32))
            {
              b.a(b.this, (n)localObject2);
              if ((((n)localObject2).bFZ().bEE()) && (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Ow(((n)localObject2).bGN().field_adxml)))
              {
                localObject1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.z((n)localObject2);
                if (!bk.bl((String)localObject1)) {
                  ((n)localObject2).bGN().field_adxml = ((String)localObject1);
                }
                int j = b.this.source;
                if (b.this.source == 0)
                {
                  i = 1;
                  com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(j, i, ((n)localObject2).field_snsId, 21, 21));
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
                  ((Intent)localObject1).putExtra("sns_landing_pages_share_sns_id", ((n)localObject2).bGk());
                  ((Intent)localObject1).putExtra("sns_landing_pages_rawSnsId", ((n)localObject2).bGe().lsK);
                  ((Intent)localObject1).putExtra("sns_landing_pages_ux_info", ((n)localObject2).bGM());
                  ((Intent)localObject1).putExtra("sns_landing_pages_aid", ((n)localObject2).bGJ());
                  ((Intent)localObject1).putExtra("sns_landing_pages_traceid", ((n)localObject2).bGK());
                  localObject3 = ((n)localObject2).bGe();
                  if (localObject3 != null)
                  {
                    localObject3 = ((bxk)localObject3).tNr.sPJ;
                    if (((List)localObject3).size() > 0)
                    {
                      ((Intent)localObject1).putExtra("sns_landing_pages_share_thumb_url", ((awd)((List)localObject3).get(0)).trP);
                      ((Intent)localObject1).putExtra("sns_landing_pages_from_outer_index", ((ao)paramAnonymousView.getTag()).index);
                    }
                  }
                  ((Intent)localObject1).setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                  if (b.this.source != 2) {
                    break label863;
                  }
                  i = 16;
                }
              }
            }
            for (;;)
            {
              label610:
              ((Intent)localObject1).putExtra("sns_landig_pages_from_source", i);
              ((Intent)localObject1).putExtra("sns_landing_pages_xml", ((n)localObject2).bGN().field_adxml);
              ((Intent)localObject1).putExtra("sns_landing_pages_rec_src", ((n)localObject2).bGO());
              ((Intent)localObject1).putExtra("sns_landing_pages_xml_prefix", "adxml");
              ((Intent)localObject1).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
              b.this.activity.startActivity((Intent)localObject1);
              b.this.activity.overridePendingTransition(0, 0);
              if (b.this.oOe != null) {
                b.this.oOe.bDk().y((n)localObject2);
              }
              label724:
              paramAnonymousView = (ao)paramAnonymousView.getTag();
              if ((paramAnonymousView.oVB) && (localObject2 != null))
              {
                aw.b((n)localObject2, paramAnonymousView.index);
                aw.c((n)localObject2, paramAnonymousView.index);
                com.tencent.mm.plugin.sns.model.av.NP(((n)localObject2).bGE());
              }
              if (localObject2 == null) {
                break;
              }
              localObject1 = ((n)localObject2).bGe();
              if (localObject1 == null) {
                break;
              }
              if (((bxk)localObject1).tNq == null) {}
              for (paramAnonymousView = null;; paramAnonymousView = ((bxk)localObject1).tNq.lsK)
              {
                if ((bk.bl(paramAnonymousView)) || (!com.tencent.mm.plugin.sns.c.a.eUS.cu(paramAnonymousView))) {
                  break label911;
                }
                localObject2 = com.tencent.mm.plugin.sns.c.a.eUS.cs(paramAnonymousView);
                com.tencent.mm.plugin.sns.c.a.eUS.a(null, paramAnonymousView, (String)localObject2, ((bxk)localObject1).hPY, 2, 4, 4, ((bxk)localObject1).tNv, ((bxk)localObject1).lsK);
                return;
                i = 2;
                break;
                label863:
                if (b.this.source != 1) {
                  break label913;
                }
                i = 2;
                break label610;
                b.this.bE(paramAnonymousView);
                break label724;
                b.this.bE(paramAnonymousView);
                break label724;
              }
              label911:
              break;
              label913:
              i = 1;
            }
          }
          localObject1 = null;
        }
      }
    };
    this.poD = new b.10(this);
    this.poE = new b.11(this);
    this.poF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = (String)paramAnonymousView.getTag();
        y.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + paramAnonymousView);
        paramAnonymousView = com.tencent.mm.plugin.sns.model.af.bDF().OB(paramAnonymousView).bGe();
        com.tencent.mm.protocal.c.av localav = paramAnonymousView.ouC;
        if (localav.sug == null) {}
        String str;
        int i;
        int j;
        do
        {
          do
          {
            return;
            str = com.tencent.mm.plugin.sns.c.a.eUS.cs(localav.sug.euK);
            i = 0;
            if (paramAnonymousView.tNr.sPI == 1) {
              i = 2;
            }
            while (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(paramAnonymousView, b.this.activity))
            {
              com.tencent.mm.plugin.sns.c.a.eUS.a(b.this.activity, localav.sug.euK, str, paramAnonymousView.hPY, i, 11, 9, localav.sug.sua, paramAnonymousView.lsK);
              return;
              if (paramAnonymousView.tNr.sPI == 3) {
                i = 5;
              } else if (paramAnonymousView.tNr.sPI == 15) {
                i = 38;
              }
            }
            switch (localav.hQR)
            {
            default: 
              return;
            case 4: 
              localObject = new Intent();
              ((Intent)localObject).putExtra("rawUrl", localav.kSC);
              com.tencent.mm.plugin.sns.c.a.eUR.j((Intent)localObject, b.this.activity);
              com.tencent.mm.plugin.sns.c.a.eUS.a(b.this.activity, localav.sug.euK, str, paramAnonymousView.hPY, i, 11, 1, localav.sug.sua, paramAnonymousView.lsK);
              return;
            }
          } while (localav.pyo != 1);
          localObject = new gq();
          ((gq)localObject).bOu.actionCode = 2;
          ((gq)localObject).bOu.scene = 3;
          ((gq)localObject).bOu.appId = localav.sug.euK;
          ((gq)localObject).bOu.context = b.this.activity;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
          com.tencent.mm.plugin.sns.c.a.eUS.a(b.this.activity, localav.sug.euK, str, paramAnonymousView.hPY, i, 11, 6, localav.sug.sua, paramAnonymousView.lsK);
          return;
          j = com.tencent.mm.plugin.sns.ui.af.a(b.this.activity, localav);
          if (j == 1)
          {
            localObject = new gq();
            ((gq)localObject).bOu.context = b.this.activity;
            ((gq)localObject).bOu.actionCode = 2;
            ((gq)localObject).bOu.appId = localav.sug.euK;
            ((gq)localObject).bOu.messageAction = localav.sug.suc;
            ((gq)localObject).bOu.messageExt = localav.sug.sub;
            ((gq)localObject).bOu.scene = 3;
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
            com.tencent.mm.plugin.sns.c.a.eUS.a(b.this.activity, localav.sug.euK, str, paramAnonymousView.hPY, i, 11, 6, localav.sug.sua, paramAnonymousView.lsK);
            return;
          }
        } while (j != 2);
        Object localObject = new gq();
        ((gq)localObject).bOu.context = b.this.activity;
        ((gq)localObject).bOu.actionCode = 1;
        ((gq)localObject).bOu.appId = localav.sug.euK;
        ((gq)localObject).bOu.messageAction = localav.sug.suc;
        ((gq)localObject).bOu.messageExt = localav.sug.sub;
        ((gq)localObject).bOu.scene = 3;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        com.tencent.mm.plugin.sns.c.a.eUS.a(b.this.activity, localav.sug.euK, str, paramAnonymousView.hPY, i, 11, 3, localav.sug.sua, paramAnonymousView.lsK);
      }
    };
    this.poL = new View.OnClickListener()
    {
      private static void Pt(String paramAnonymousString)
      {
        long l = com.tencent.mm.plugin.sns.model.af.bDF().OB(paramAnonymousString).field_snsId;
        Object localObject1 = com.tencent.mm.plugin.sns.model.af.bDF().gt(l);
        if (localObject1 != null)
        {
          Object localObject2 = ((n)localObject1).bGe();
          if (localObject2 != null)
          {
            localObject2 = ((bxk)localObject2).tNr.sPJ;
            if (((List)localObject2).size() > 0) {
              ((List)localObject2).get(0);
            }
          }
          localObject2 = com.tencent.mm.plugin.sns.model.aj.q((n)localObject1);
          localObject1 = new ArrayList();
          localObject2 = ((bto)localObject2).tKm.tKP;
          if (localObject2 != null)
          {
            int i = 0;
            while (i < ((List)localObject2).size())
            {
              btk localbtk = (btk)((List)localObject2).get(i);
              a.a locala = new a.a();
              locala.hcm = localbtk.sxM;
              locala.lKK = localbtk.mPL;
              locala.lKL = localbtk.tJy;
              ((List)localObject1).add(locala);
              i += 1;
            }
          }
          com.tencent.mm.plugin.q.a.o(paramAnonymousString, (List)localObject1);
        }
      }
      
      public final void onClick(View paramAnonymousView)
      {
        if ((paramAnonymousView.getTag() instanceof n))
        {
          paramAnonymousView = (n)paramAnonymousView.getTag();
          if ((paramAnonymousView.field_type == 21) && (com.tencent.mm.model.q.Gj().equals(paramAnonymousView.field_userName)))
          {
            localObject = paramAnonymousView.bGe().lsK;
            com.tencent.mm.plugin.sns.lucky.a.m.m(paramAnonymousView);
            com.tencent.mm.plugin.sns.lucky.a.m.l(paramAnonymousView);
            System.currentTimeMillis();
            com.tencent.mm.plugin.sns.lucky.a.b.jdMethod_if(24);
          }
          Object localObject = new Intent();
          ((Intent)localObject).putExtra("key_sendid", paramAnonymousView.bGk());
          ((Intent)localObject).putExtra("key_feedid", paramAnonymousView.bGE());
          ((Intent)localObject).setClassName(b.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
          b.this.activity.startActivity((Intent)localObject);
          localObject = paramAnonymousView.bGE();
          paramAnonymousView.bGk();
          Pt((String)localObject);
        }
      }
    };
    this.poG = new b.15(this);
    this.poH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        b.this.cW(paramAnonymousView);
      }
    };
    this.poI = new b.17(this);
    this.poJ = new b.18(this);
    this.poM = new b.19(this);
    this.ifd = new b.20(this);
    this.poU = new b.21(this);
    this.poX = new b.22(this);
    this.poW = new b.24(this);
    this.poP = new b.25(this);
    this.poY = new b.26(this);
    this.ppb = new b.27(this);
    this.ppc = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((paramAnonymousView.getTag() != null) && ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
        {
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.data.b)paramAnonymousView.getTag();
          if ((paramAnonymousInt < paramAnonymousAdapterView.omM.pjN.oAp.bED().size()) && (!paramAnonymousAdapterView.omM.pjN.oAt)) {
            break label61;
          }
        }
        label61:
        a.b.a locala;
        n localn;
        do
        {
          return;
          locala = (a.b.a)paramAnonymousAdapterView.omM.pjN.oAp.bED().get(paramAnonymousInt);
          y.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[] { locala.oAz, Integer.valueOf(locala.oAC) });
          localn = com.tencent.mm.plugin.sns.model.af.bDF().OB(paramAnonymousAdapterView.bJQ);
        } while (localn == null);
        locala.omN = paramAnonymousAdapterView.omN;
        locala.oAD = System.currentTimeMillis();
        paramAnonymousAdapterView = new r(localn.field_snsId, 8, locala);
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(paramAnonymousAdapterView, 0);
        b.this.cY(paramAnonymousView);
      }
    };
    this.ppf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if ((paramAnonymousView.getTag() == null) || ((!(paramAnonymousView.getTag() instanceof a.c)) && (!(paramAnonymousView.getTag() instanceof ao)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aj)) && (!(paramAnonymousView.getTag() instanceof MaskImageView)) && (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a)))) {
          return;
        }
        Object localObject1 = null;
        int m = 0;
        int j = 0;
        int n = 0;
        int k = 0;
        int i = 0;
        Object localObject3;
        if ((paramAnonymousView.getTag() instanceof ao))
        {
          localObject3 = com.tencent.mm.plugin.sns.storage.h.OB(((ao)paramAnonymousView.getTag()).bMB);
          if ((paramAnonymousView instanceof LinearLayout))
          {
            i = 0;
            label108:
            if (!((ao)paramAnonymousView.getTag()).oTK) {
              break label4034;
            }
            k = ((ao)paramAnonymousView.getTag()).index;
            if (k <= 0) {
              break label559;
            }
          }
        }
        label140:
        label148:
        label183:
        label951:
        label1854:
        label4034:
        for (j = 2;; j = 0) {
          for (;;)
          {
            m = i;
            i = j;
            j = m;
            if ((localObject3 == null) || (!((n)localObject3).yr(32))) {
              break;
            }
            try
            {
              localObject1 = b.a(b.this, (n)localObject3);
              if (localObject1 == null)
              {
                localObject1 = "";
                localObject4 = ((n)localObject3).bGe().lsK;
                if (!((n)localObject3).bEQ())
                {
                  localObject5 = com.tencent.mm.plugin.report.service.h.nFQ;
                  if (b.this.source != 0) {
                    break label874;
                  }
                  m = 1;
                  label219:
                  if (j == 0) {
                    break label880;
                  }
                }
              }
              label719:
              label874:
              label880:
              for (j = 1;; j = 2)
              {
                ((com.tencent.mm.plugin.report.service.h)localObject5).f(14066, new Object[] { Integer.valueOf(m), Integer.valueOf(j), localObject4, localObject1 });
                if (((n)localObject3).bGN().bFZ().bEM())
                {
                  localObject1 = ((n)localObject3).bGN().bFZ().bEH();
                  localObject4 = ((n)localObject3).bGM();
                  com.tencent.mm.kernel.g.DN();
                  localObject5 = com.tencent.mm.kernel.a.CL();
                  v.g((String)localObject1, (String)localObject4, (String)localObject5, v.ac((String)localObject1, (String)localObject4, (String)localObject5), 0);
                }
                localbxk = ((n)localObject3).bGe();
                if (((localbxk.tNr.sPI != 15) || (localbxk.tNy == 1)) && ((localbxk.tNr.sPI != 27) || (localbxk.tNr.sPJ.size() <= k) || (((awd)localbxk.tNr.sPJ.get(k)).hQR != 6))) {
                  break label2572;
                }
                y.i("MicroMsg.TimelineClickListener", "onsight click");
                localObject1 = null;
                localObject4 = null;
                if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aj)) {
                  localObject1 = (com.tencent.mm.plugin.sns.ui.aj)paramAnonymousView.getTag();
                }
                if (!(paramAnonymousView.getTag() instanceof a.c)) {
                  break label926;
                }
                localObject4 = (a.c)paramAnonymousView.getTag();
                if (localbxk.tNr.sPI != 27) {
                  break label916;
                }
                localObject1 = ((com.tencent.mm.plugin.sns.ui.c.j.b)localObject4).pon;
                if (localObject3 == null) {
                  break;
                }
                if (b.this.oOe != null) {
                  b.this.oOe.bDk().y((n)localObject3);
                }
                bool = ((n)localObject3).yr(32);
                if ((localbxk.tNr.sPJ != null) && (localbxk.tNr.sPJ.size() != 0)) {
                  break label951;
                }
                y.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                return;
                i = 1;
                break label108;
                j = 1;
                break label140;
                if ((paramAnonymousView.getTag() instanceof MaskImageView))
                {
                  localObject3 = (MaskImageView)paramAnonymousView.getTag();
                  if (!(((MaskImageView)localObject3).getTag() instanceof ao)) {
                    break label4029;
                  }
                  localObject3 = com.tencent.mm.plugin.sns.storage.h.OB(((ao)((MaskImageView)localObject3).getTag()).bMB);
                  localObject1 = localObject3;
                  j = n;
                  if ((paramAnonymousView instanceof LinearLayout)) {
                    break label779;
                  }
                  i = 1;
                  localObject1 = localObject3;
                  m = 0;
                  k = 0;
                  localObject3 = localObject1;
                  j = i;
                  i = m;
                  break label148;
                }
                if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aj))
                {
                  localObject1 = (com.tencent.mm.plugin.sns.ui.aj)paramAnonymousView.getTag();
                  localObject3 = com.tencent.mm.plugin.sns.model.af.bDF().OB(((com.tencent.mm.plugin.sns.ui.aj)localObject1).bJQ);
                  if ((paramAnonymousView instanceof LinearLayout))
                  {
                    j = 0;
                    if (!((com.tencent.mm.plugin.sns.ui.aj)localObject1).oTK) {
                      break label4020;
                    }
                    k = ((com.tencent.mm.plugin.sns.ui.aj)localObject1).oTL;
                    if (k <= 0) {
                      break label719;
                    }
                  }
                  for (i = 2;; i = 1)
                  {
                    break;
                    j = 1;
                    break label689;
                  }
                }
                if ((paramAnonymousView.getTag() instanceof a.c))
                {
                  localObject3 = (a.c)paramAnonymousView.getTag();
                  localObject1 = com.tencent.mm.plugin.sns.storage.h.OA(((a.c)localObject3).bRV);
                  if (!(localObject3 instanceof com.tencent.mm.plugin.sns.ui.c.j.b)) {
                    break label4015;
                  }
                  j = ((com.tencent.mm.plugin.sns.ui.c.j.b)localObject3).pom.index;
                  if (j > 0) {
                    i = 2;
                  }
                }
                do
                {
                  for (;;)
                  {
                    k = j;
                    j = 0;
                    localObject3 = localObject1;
                    break;
                    i = 1;
                  }
                  if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a)) {
                    break label4006;
                  }
                  localObject3 = ((com.tencent.mm.plugin.sns.ui.b.a.a)paramAnonymousView.getTag()).oUH;
                  localObject1 = localObject3;
                  j = n;
                } while (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.d));
                j = ((com.tencent.mm.plugin.sns.ui.b.a.d)paramAnonymousView.getTag()).currentIndex;
                if (j > 0) {}
                for (i = 2;; i = 1)
                {
                  localObject1 = localObject3;
                  break;
                }
                localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).fVM;
                break label183;
                m = 2;
                break label219;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Object localObject4;
                Object localObject5;
                bxk localbxk;
                boolean bool;
                y.e("MicroMsg.TimelineClickListener", "report click ad card style error " + localException.getMessage());
                continue;
                Object localObject2 = ((a.c)localObject4).plQ;
                continue;
                if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a))
                {
                  localObject2 = ((com.tencent.mm.plugin.sns.ui.b.a.a)paramAnonymousView.getTag()).plQ;
                  continue;
                  awd localawd = (awd)localbxk.tNr.sPJ.get(k);
                  if (bool)
                  {
                    com.tencent.mm.plugin.sns.model.af.bDC();
                    if ((!com.tencent.mm.plugin.sns.model.g.t(localawd)) && (localObject2 != null))
                    {
                      ((com.tencent.mm.plugin.sns.ui.aj)localObject2).oGT.setVisibility(8);
                      ((com.tencent.mm.plugin.sns.ui.aj)localObject2).oTI.setVisibility(0);
                      ((com.tencent.mm.plugin.sns.ui.aj)localObject2).oTI.cJO();
                      com.tencent.mm.plugin.sns.model.af.bDC().z(localawd);
                      paramAnonymousView = com.tencent.mm.plugin.sns.model.af.bDA();
                      localObject2 = az.cvd();
                      ((az)localObject2).time = localbxk.mPL;
                      paramAnonymousView.a(localawd, 4, null, (az)localObject2);
                      if (!bool) {
                        break;
                      }
                      j.a(com.tencent.mm.plugin.sns.a.b.j.b.olY, com.tencent.mm.plugin.sns.a.b.j.a.olP, (n)localObject3, b.this.source);
                      return;
                    }
                  }
                  if ((((n)localObject3).yr(32)) && (((n)localObject3).bFZ().bEE()))
                  {
                    String str = ((n)localObject3).bGN().field_adxml;
                    if (k > 0)
                    {
                      localObject5 = "adTurnCanvasInfo";
                      label1121:
                      if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.eW(str, (String)localObject5)) {
                        break label1280;
                      }
                    }
                  }
                  for (m = 1;; m = 0)
                  {
                    if ((m != 0) || (!bool) || (!com.tencent.mm.plugin.sns.model.af.bDC().u(localawd)) || (localObject2 == null)) {
                      break label1286;
                    }
                    com.tencent.mm.plugin.sns.model.af.bDC().z(localawd);
                    ((com.tencent.mm.plugin.sns.ui.aj)localObject2).oGT.setVisibility(8);
                    ((com.tencent.mm.plugin.sns.ui.aj)localObject2).oTI.setVisibility(8);
                    paramAnonymousView = com.tencent.mm.plugin.sns.model.af.bDC();
                    localObject4 = ((com.tencent.mm.plugin.sns.ui.aj)localObject2).ogP;
                    i = b.this.activity.hashCode();
                    j = ((com.tencent.mm.plugin.sns.ui.aj)localObject2).position;
                    localObject2 = az.cvd();
                    ((az)localObject2).time = localbxk.mPL;
                    paramAnonymousView.a((n)localObject3, localawd, (com.tencent.mm.plugin.sight.decode.a.a)localObject4, i, j, (az)localObject2, bool);
                    if (!bool) {
                      break;
                    }
                    j.a(com.tencent.mm.plugin.sns.a.b.j.b.olY, com.tencent.mm.plugin.sns.a.b.j.a.olP, (n)localObject3, b.this.source);
                    return;
                    localObject5 = "adCanvasInfo";
                    break label1121;
                  }
                  if (b.this.source == 0)
                  {
                    localObject2 = com.tencent.mm.modelsns.b.jd(717);
                    ((com.tencent.mm.modelsns.b)localObject2).ni(com.tencent.mm.plugin.sns.data.i.j((n)localObject3)).jg(((n)localObject3).field_type).cb(((n)localObject3).yr(32)).ni(((n)localObject3).bGM()).ni(localawd.lsK);
                    ((com.tencent.mm.modelsns.b)localObject2).QX();
                    if (b.this.source != 0) {
                      break label1854;
                    }
                    localObject2 = com.tencent.mm.modelsns.b.jd(745);
                    label1373:
                    ((com.tencent.mm.modelsns.b)localObject2).ni(com.tencent.mm.plugin.sns.data.i.j((n)localObject3)).jg(((n)localObject3).field_type).cb(((n)localObject3).yr(32));
                    localObject5 = new int[2];
                    if (localObject4 == null) {
                      break label1918;
                    }
                    if (((a.c)localObject4).plQ.oTH == null) {
                      break label1865;
                    }
                    ((a.c)localObject4).plQ.oTH.getLocationInWindow((int[])localObject5);
                    j = ((a.c)localObject4).plQ.oTH.getWidth();
                    i = ((a.c)localObject4).plQ.oTH.getHeight();
                  }
                  for (;;)
                  {
                    com.tencent.mm.plugin.report.service.h.nFQ.f(11444, new Object[] { Integer.valueOf(3) });
                    if (m != 0)
                    {
                      if ((paramAnonymousView.getTag() instanceof a.c))
                      {
                        b.this.f((a.c)paramAnonymousView.getTag());
                        label1509:
                        n = b.this.source;
                        if (b.this.source != 0) {
                          break label2023;
                        }
                        m = 1;
                        label1531:
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(n, m, ((n)localObject3).field_snsId, 22, 21));
                        localObject2 = new Intent();
                        ((Intent)localObject2).putExtra("img_gallery_left", localObject5[0]);
                        ((Intent)localObject2).putExtra("img_gallery_top", localObject5[1]);
                        ((Intent)localObject2).putExtra("img_gallery_width", j);
                        ((Intent)localObject2).putExtra("img_gallery_height", i);
                        ((Intent)localObject2).putExtra("sns_landing_pages_share_sns_id", ((n)localObject3).bGk());
                        ((Intent)localObject2).putExtra("sns_landing_pages_rawSnsId", ((n)localObject3).bGe().lsK);
                        ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", ((n)localObject3).bGM());
                        paramAnonymousView = ((n)localObject3).bGe();
                        if (paramAnonymousView != null)
                        {
                          paramAnonymousView = paramAnonymousView.tNr.sPJ;
                          if (paramAnonymousView.size() > k) {
                            ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((awd)paramAnonymousView.get(k)).trP);
                          }
                        }
                        ((Intent)localObject2).setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                        i = 1;
                        if (b.this.source != 2) {
                          break label2029;
                        }
                        i = 16;
                        label1738:
                        ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
                        if (k <= 0) {
                          break label2045;
                        }
                      }
                      label1865:
                      label2023:
                      label2029:
                      label2045:
                      for (paramAnonymousView = ((n)localObject3).bFZ().bEP();; paramAnonymousView = ((n)localObject3).bGN().field_adxml)
                      {
                        ((Intent)localObject2).putExtra("sns_landing_pages_xml", paramAnonymousView);
                        ((Intent)localObject2).putExtra("sns_landing_pages_rec_src", ((n)localObject3).bGO());
                        ((Intent)localObject2).putExtra("sns_landing_pages_xml_prefix", "adxml");
                        ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        ((Intent)localObject2).putExtra("sns_landing_is_native_sight_ad", true);
                        b.this.activity.startActivity((Intent)localObject2);
                        b.this.activity.overridePendingTransition(0, 0);
                        return;
                        localObject2 = com.tencent.mm.modelsns.b.je(717);
                        break;
                        localObject2 = com.tencent.mm.modelsns.b.je(745);
                        break label1373;
                        if (localbxk.tNr.sPI != 27) {
                          break label3996;
                        }
                        ((com.tencent.mm.plugin.sns.ui.c.j.b)localObject4).pok.getLocationInWindow((int[])localObject5);
                        j = ((com.tencent.mm.plugin.sns.ui.c.j.b)localObject4).pok.getWidth();
                        i = ((com.tencent.mm.plugin.sns.ui.c.j.b)localObject4).pok.getHeight();
                        break label1460;
                        label1918:
                        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.aj))
                        {
                          localObject2 = (com.tencent.mm.plugin.sns.ui.aj)paramAnonymousView.getTag();
                          if (localObject2 != null) {
                            ((com.tencent.mm.plugin.sns.ui.aj)localObject2).oTH.getLocationInWindow((int[])localObject5);
                          }
                          j = ((com.tencent.mm.plugin.sns.ui.aj)localObject2).oTH.getWidth();
                          i = ((com.tencent.mm.plugin.sns.ui.aj)localObject2).oTH.getHeight();
                          break label1460;
                        }
                        if (paramAnonymousView != null) {
                          paramAnonymousView.getLocationInWindow((int[])localObject5);
                        }
                        j = paramAnonymousView.getWidth();
                        i = paramAnonymousView.getHeight();
                        break label1460;
                        if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a)) {
                          break label1509;
                        }
                        b.this.a((com.tencent.mm.plugin.sns.ui.b.a.a)paramAnonymousView.getTag());
                        break label1509;
                        m = 2;
                        break label1531;
                        if (b.this.source != 1) {
                          break label1738;
                        }
                        i = 2;
                        break label1738;
                      }
                    }
                    paramAnonymousView = b.this;
                    localObject2 = b.a(b.this, (n)localObject3);
                    if (k > 0)
                    {
                      bool = true;
                      if (!b.a(paramAnonymousView, (com.tencent.mm.plugin.sns.storage.a)localObject2, (n)localObject3, bool)) {
                        break label2147;
                      }
                      j = b.this.source;
                      if (b.this.source != 0) {
                        break label2142;
                      }
                    }
                    label2142:
                    for (i = 1;; i = 2)
                    {
                      com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(j, i, ((n)localObject3).field_snsId, 22, 31));
                      return;
                      bool = false;
                      break;
                    }
                    label2147:
                    j = b.this.source;
                    if (b.this.source == 0)
                    {
                      i = 1;
                      localObject4 = new SnsAdClick(j, i, ((n)localObject3).field_snsId, 22, 0);
                      com.tencent.mm.plugin.sns.data.i.a((SnsAdClick)localObject4);
                      if (k <= 0) {
                        break label2557;
                      }
                      paramAnonymousView = ((n)localObject3).bFZ().oBx.oAa;
                      localObject2 = paramAnonymousView;
                      if (bk.bl(paramAnonymousView)) {
                        localObject2 = ((n)localObject3).getAdLink();
                      }
                      if (bk.bl((String)localObject2)) {
                        break;
                      }
                      y.i("MicroMsg.TimelineClickListener", "adlink url " + (String)localObject2 + " " + ((n)localObject3).bFZ().oAG);
                      paramAnonymousView = new Intent();
                      if (((n)localObject3).bFZ().oAG != 0) {
                        break label2566;
                      }
                    }
                    for (bool = true;; bool = false)
                    {
                      if (com.tencent.mm.platformtools.ae.eSY) {
                        bool = false;
                      }
                      if ((localObject3 != null) && (((n)localObject3).yr(32)))
                      {
                        localObject5 = b.a(b.this, (n)localObject3);
                        if (localObject5 != null) {
                          paramAnonymousView.putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject5).fVM);
                        }
                      }
                      paramAnonymousView.putExtra("KRightBtn", bool);
                      localObject5 = new Bundle();
                      ((Bundle)localObject5).putParcelable("KSnsAdTag", (Parcelable)localObject4);
                      ((Bundle)localObject5).putString("key_snsad_statextstr", ((n)localObject3).bGe().oPO);
                      paramAnonymousView.putExtra("jsapiargs", (Bundle)localObject5);
                      paramAnonymousView.putExtra("rawUrl", (String)localObject2);
                      paramAnonymousView.putExtra("useJs", true);
                      paramAnonymousView.putExtra("srcUsername", ((n)localObject3).field_userName);
                      paramAnonymousView.putExtra("stastic_scene", 15);
                      paramAnonymousView.putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(((n)localObject3).field_snsId));
                      paramAnonymousView.putExtra("pre_username", ((n)localObject3).field_userName);
                      paramAnonymousView.putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(((n)localObject3).field_snsId));
                      paramAnonymousView.putExtra("preUsername", ((n)localObject3).field_userName);
                      com.tencent.mm.plugin.sns.c.a.eUR.j(paramAnonymousView, b.this.activity);
                      return;
                      i = 2;
                      break;
                      label2557:
                      paramAnonymousView = ((n)localObject3).bGL();
                      break label2208;
                    }
                    if (((localbxk.tNr.sPI != 1) || (localbxk.tNr.sPJ.size() != 1)) && (localbxk.tNr.sPI != 7) && ((localbxk.tNr.sPI != 27) || (localbxk.tNr.sPJ.size() <= k) || (((awd)localbxk.tNr.sPJ.get(k)).hQR != 2))) {
                      break;
                    }
                    if ((paramAnonymousView.getTag() instanceof a.c))
                    {
                      localObject2 = (a.c)paramAnonymousView.getTag();
                      if ((paramAnonymousView.getTag() instanceof b.a)) {
                        localObject2 = ((b.a)paramAnonymousView.getTag()).pmj;
                      }
                    }
                    for (;;)
                    {
                      if (((n)localObject3).bFZ().bEE())
                      {
                        localObject5 = ((n)localObject3).bGN().field_adxml;
                        if (k > 0)
                        {
                          localObject4 = "adTurnCanvasInfo";
                          if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.eW((String)localObject5, (String)localObject4)) {
                            break label3461;
                          }
                          m = b.this.source;
                          if (b.this.source != 0) {
                            break label3367;
                          }
                          j = 1;
                          label2767:
                          com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(m, j, ((n)localObject3).field_snsId, 21, i, (byte)0));
                          if (!(paramAnonymousView.getTag() instanceof a.c)) {
                            break label3372;
                          }
                          b.this.f((a.c)paramAnonymousView.getTag());
                          label2813:
                          paramAnonymousView = new int[2];
                          ((View)localObject2).getLocationInWindow(paramAnonymousView);
                          i = ((View)localObject2).getWidth();
                          j = ((View)localObject2).getHeight();
                          localObject2 = new Intent();
                          ((Intent)localObject2).putExtra("img_gallery_left", paramAnonymousView[0]);
                          ((Intent)localObject2).putExtra("img_gallery_top", paramAnonymousView[1]);
                          ((Intent)localObject2).putExtra("img_gallery_width", i);
                          ((Intent)localObject2).putExtra("img_gallery_height", j);
                          ((Intent)localObject2).putExtra("sns_landing_pages_share_sns_id", ((n)localObject3).bGk());
                          ((Intent)localObject2).putExtra("sns_landing_pages_rawSnsId", ((n)localObject3).bGe().lsK);
                          ((Intent)localObject2).putExtra("sns_landing_pages_ux_info", ((n)localObject3).bGM());
                          ((Intent)localObject2).putExtra("sns_landing_pages_aid", ((n)localObject3).bGJ());
                          ((Intent)localObject2).putExtra("sns_landing_pages_traceid", ((n)localObject3).bGK());
                          paramAnonymousView = ((n)localObject3).bGe();
                          if (paramAnonymousView != null)
                          {
                            paramAnonymousView = paramAnonymousView.tNr.sPJ;
                            if (paramAnonymousView.size() <= k) {
                              break label3399;
                            }
                            ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((awd)paramAnonymousView.get(k)).trP);
                          }
                          label3013:
                          ((Intent)localObject2).setClass(b.this.activity, SnsAdNativeLandingPagesUI.class);
                          i = 1;
                          if (b.this.source != 2) {
                            break label3433;
                          }
                          i = 16;
                          label3045:
                          ((Intent)localObject2).putExtra("sns_landig_pages_from_source", i);
                          if (k <= 0) {
                            break label3449;
                          }
                        }
                        label3399:
                        label3433:
                        label3449:
                        for (paramAnonymousView = ((n)localObject3).bFZ().bEP();; paramAnonymousView = ((n)localObject3).bGN().field_adxml)
                        {
                          ((Intent)localObject2).putExtra("sns_landing_pages_xml", paramAnonymousView);
                          ((Intent)localObject2).putExtra("sns_landing_pages_rec_src", ((n)localObject3).bGO());
                          ((Intent)localObject2).putExtra("sns_landing_pages_xml_prefix", "adxml");
                          ((Intent)localObject2).putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                          b.this.activity.startActivity((Intent)localObject2);
                          b.this.activity.overridePendingTransition(0, 0);
                          if (b.this.oOe == null) {
                            break;
                          }
                          b.this.oOe.bDk().y((n)localObject3);
                          return;
                          if ((paramAnonymousView.getTag() instanceof d.a))
                          {
                            localObject2 = ((d.a)paramAnonymousView.getTag()).pmj;
                            break label2705;
                          }
                          if ((localObject2 instanceof com.tencent.mm.plugin.sns.ui.c.j.b))
                          {
                            localObject2 = (TagImageView)((com.tencent.mm.plugin.sns.ui.c.j.b)localObject2).pom.view;
                            break label2705;
                          }
                          localObject2 = ((a.c)localObject2).pmZ.yD(0);
                          break label2705;
                          if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a))
                          {
                            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.b))
                            {
                              localObject2 = ((com.tencent.mm.plugin.sns.ui.b.a.b)paramAnonymousView.getTag()).plX;
                              break label2705;
                            }
                            if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.c))
                            {
                              localObject2 = ((com.tencent.mm.plugin.sns.ui.b.a.c)paramAnonymousView.getTag()).pmj;
                              break label2705;
                            }
                            if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.d)) {
                              break label3990;
                            }
                            localObject2 = ((com.tencent.mm.plugin.sns.ui.b.a.d)paramAnonymousView.getTag()).contentView;
                            break label2705;
                          }
                          if ((paramAnonymousView.getTag() instanceof MaskImageView))
                          {
                            localObject2 = (MaskImageView)paramAnonymousView.getTag();
                            break label2705;
                          }
                          if (!(paramAnonymousView.getTag() instanceof TagImageView)) {
                            break label3990;
                          }
                          localObject2 = (TagImageView)paramAnonymousView;
                          break label2705;
                          localObject4 = "adCanvasInfo";
                          break label2736;
                          j = 2;
                          break label2767;
                          if (!(paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.ui.b.a.a)) {
                            break label2813;
                          }
                          b.this.a((com.tencent.mm.plugin.sns.ui.b.a.a)paramAnonymousView.getTag());
                          break label2813;
                          if (paramAnonymousView.size() <= 0) {
                            break label3013;
                          }
                          ((Intent)localObject2).putExtra("sns_landing_pages_share_thumb_url", ((awd)paramAnonymousView.get(0)).trP);
                          break label3013;
                          if (b.this.source != 1) {
                            break label3045;
                          }
                          i = 2;
                          break label3045;
                        }
                      }
                      paramAnonymousView = b.this;
                      localObject2 = b.a(b.this, (n)localObject3);
                      if (k > 0)
                      {
                        bool = true;
                        if (!b.a(paramAnonymousView, (com.tencent.mm.plugin.sns.storage.a)localObject2, (n)localObject3, bool)) {
                          break label3553;
                        }
                        k = b.this.source;
                        if (b.this.source != 0) {
                          break label3548;
                        }
                      }
                      label3548:
                      for (j = 1;; j = 2)
                      {
                        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(k, j, ((n)localObject3).field_snsId, 31, i, (byte)0));
                        return;
                        bool = false;
                        break;
                      }
                      label3553:
                      if (k > 0)
                      {
                        paramAnonymousView = ((n)localObject3).bFZ().oBx.oAa;
                        localObject2 = paramAnonymousView;
                        if (bk.bl(paramAnonymousView)) {
                          localObject2 = ((n)localObject3).getAdLink();
                        }
                        if (bk.bl((String)localObject2)) {
                          break;
                        }
                        k = b.this.source;
                        if (b.this.source != 0) {
                          break label3979;
                        }
                        j = 1;
                        paramAnonymousView = new SnsAdClick(k, j, ((n)localObject3).field_snsId, 0, i, (byte)0);
                        com.tencent.mm.plugin.sns.data.i.a(paramAnonymousView);
                        y.i("MicroMsg.TimelineClickListener", "adlink url " + (String)localObject2 + " " + ((n)localObject3).bFZ().oAG);
                        localObject4 = new Intent();
                        if (((n)localObject3).bFZ().oAG != 0) {
                          break label3984;
                        }
                      }
                      for (bool = true;; bool = false)
                      {
                        if (com.tencent.mm.platformtools.ae.eSY) {
                          bool = false;
                        }
                        if ((localObject3 != null) && (((n)localObject3).yr(32)))
                        {
                          localObject5 = b.a(b.this, (n)localObject3);
                          if (localObject5 != null) {
                            ((Intent)localObject4).putExtra("KsnsViewId", ((com.tencent.mm.plugin.sns.storage.a)localObject5).fVM);
                          }
                        }
                        ((Intent)localObject4).putExtra("KRightBtn", bool);
                        localObject5 = new Bundle();
                        ((Bundle)localObject5).putParcelable("KSnsAdTag", paramAnonymousView);
                        ((Bundle)localObject5).putString("key_snsad_statextstr", ((n)localObject3).bGe().oPO);
                        ((Intent)localObject4).putExtra("jsapiargs", (Bundle)localObject5);
                        ((Intent)localObject4).putExtra("rawUrl", (String)localObject2);
                        ((Intent)localObject4).putExtra("useJs", true);
                        ((Intent)localObject4).putExtra("srcUsername", ((n)localObject3).field_userName);
                        ((Intent)localObject4).putExtra("stastic_scene", 15);
                        ((Intent)localObject4).putExtra("KPublisherId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(((n)localObject3).field_snsId));
                        ((Intent)localObject4).putExtra("pre_username", ((n)localObject3).field_userName);
                        ((Intent)localObject4).putExtra("prePublishId", "sns_" + com.tencent.mm.plugin.sns.data.i.fN(((n)localObject3).field_snsId));
                        ((Intent)localObject4).putExtra("preUsername", ((n)localObject3).field_userName);
                        com.tencent.mm.plugin.sns.c.a.eUR.j((Intent)localObject4, b.this.activity);
                        return;
                        paramAnonymousView = ((n)localObject3).bGL();
                        break;
                        j = 2;
                        break label3616;
                      }
                      localObject2 = null;
                    }
                    i = 0;
                    j = 0;
                  }
                }
                continue;
                localObject2 = null;
                j = n;
                continue;
                i = 0;
                continue;
                i = 0;
                k = m;
                continue;
                i = 0;
              }
            }
          }
        }
      }
    };
    this.poT = new b.30(this);
    this.poo = new b.31(this);
  }
  
  final void a(com.tencent.mm.plugin.sns.ui.b.a.a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.sns.ui.b.a.b))
    {
      this.pox = new com.tencent.mm.plugin.sns.ui.a.a.d((MMActivity)this.activity, parama);
      this.poy = new com.tencent.mm.plugin.sns.ui.a.a.c((MMActivity)this.activity, parama);
    }
    do
    {
      return;
      if ((parama instanceof com.tencent.mm.plugin.sns.ui.b.a.c))
      {
        this.pox = new com.tencent.mm.plugin.sns.ui.a.a.f((MMActivity)this.activity, parama);
        this.poy = new com.tencent.mm.plugin.sns.ui.a.a.e((MMActivity)this.activity, parama);
        return;
      }
    } while (!(parama instanceof com.tencent.mm.plugin.sns.ui.b.a.d));
    this.pox = new com.tencent.mm.plugin.sns.ui.a.a.h((MMActivity)this.activity, parama);
    this.poy = new com.tencent.mm.plugin.sns.ui.a.a.g((MMActivity)this.activity, parama);
  }
  
  public abstract void b(View paramView, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void bE(Object paramObject);
  
  public abstract void bHo();
  
  public abstract void bHp();
  
  public final void bdj()
  {
    a locala = this.poz;
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.a(218, locala);
    com.tencent.mm.sdk.b.a.udP.c(this.ppi);
    com.tencent.mm.sdk.b.a.udP.c(this.ppj);
  }
  
  public abstract void cT(View paramView);
  
  public abstract void cU(View paramView);
  
  public abstract void cV(View paramView);
  
  public abstract void cW(View paramView);
  
  public abstract void cX(View paramView);
  
  public abstract void cY(View paramView);
  
  public final void ch()
  {
    a locala = this.poz;
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(218, locala);
    com.tencent.mm.sdk.b.a.udP.d(this.ppi);
    com.tencent.mm.sdk.b.a.udP.d(this.ppj);
  }
  
  final void f(a.c paramc)
  {
    if ((paramc instanceof b.a))
    {
      this.pov = new com.tencent.mm.plugin.sns.ui.a.b.d((MMActivity)this.activity, paramc);
      this.pow = new com.tencent.mm.plugin.sns.ui.a.b.c((MMActivity)this.activity, paramc);
    }
    do
    {
      return;
      if ((paramc instanceof d.a))
      {
        this.pov = new com.tencent.mm.plugin.sns.ui.a.b.f((MMActivity)this.activity, paramc);
        this.pow = new com.tencent.mm.plugin.sns.ui.a.b.e((MMActivity)this.activity, paramc);
        return;
      }
    } while (!(paramc instanceof com.tencent.mm.plugin.sns.ui.c.j.b));
    this.pov = new com.tencent.mm.plugin.sns.ui.a.b.h((MMActivity)this.activity, paramc);
    this.pow = new com.tencent.mm.plugin.sns.ui.a.b.g((MMActivity)this.activity, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b
 * JD-Core Version:    0.7.0.1
 */