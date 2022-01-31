package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.h.a.gd;
import com.tencent.mm.h.a.nd;
import com.tencent.mm.h.a.nd.a;
import com.tencent.mm.h.a.nd.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.r;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.i.a;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.a.c.a.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@com.tencent.mm.kernel.j
@com.tencent.mm.ui.base.a(19)
public class SelectConversationUI
  extends MMBaseSelectContactUI
{
  private static final int wgZ = com.tencent.mm.ui.contact.s.v(new int[] { 1, 2 });
  private long bIr;
  private long bIt;
  private String bVV;
  private bi bWO;
  private List<String> dru;
  private int eXV;
  private int fromScene = 0;
  private String ilV = null;
  private String imagePath = null;
  private int[] kka = { R.h.chatting_note_thumb_iv_0, R.h.chatting_note_thumb_iv_1, R.h.chatting_note_thumb_iv_2, R.h.chatting_note_thumb_iv_3, R.h.chatting_note_thumb_iv_4 };
  private int msgType;
  private int vDF = -1;
  private boolean vLZ;
  private boolean vNs = false;
  private TextView vfO;
  private int wha;
  private boolean whb = false;
  private boolean whc = false;
  private boolean whd = false;
  private boolean whe = false;
  private boolean whf = false;
  private boolean whg = false;
  private boolean whh = false;
  private int whi;
  private boolean whj = false;
  private String whk;
  private String whl;
  private Boolean whm = Boolean.valueOf(false);
  private boolean whn = false;
  private boolean who = false;
  private List<String> whp = null;
  private ReportUtil.ReportArgs whq;
  private String whr;
  private String whs = null;
  private String wht;
  private MenuItem.OnMenuItemClickListener whu = new SelectConversationUI.19(this);
  private MenuItem.OnMenuItemClickListener whv = new MenuItem.OnMenuItemClickListener()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      if (SelectConversationUI.n(SelectConversationUI.this)) {
        return false;
      }
      paramAnonymousMenuItem = SelectConversationUI.o(SelectConversationUI.this).iterator();
      while (paramAnonymousMenuItem.hasNext())
      {
        localObject = (String)paramAnonymousMenuItem.next();
        if (SelectConversationUI.this.aer((String)localObject)) {
          return false;
        }
      }
      paramAnonymousMenuItem = new Intent();
      paramAnonymousMenuItem.putExtra("Select_Conv_User", ah.c(SelectConversationUI.o(SelectConversationUI.this), ","));
      Object localObject = (Intent)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
      if (localObject != null) {
        SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem, (Intent)localObject);
      }
      for (;;)
      {
        return true;
        if (SelectConversationUI.p(SelectConversationUI.this))
        {
          SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem);
          SelectConversationUI.this.finish();
        }
        else
        {
          SelectConversationUI.b(SelectConversationUI.this, paramAnonymousMenuItem);
        }
      }
    }
  };
  
  private void a(Intent paramIntent1, Intent paramIntent2)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=" + paramIntent2);
    paramIntent2.putExtras(paramIntent1.getExtras());
    startActivityForResult(paramIntent2, 2);
    com.tencent.mm.ui.base.b.D(this.mController.uMN, paramIntent2);
  }
  
  private static void a(Intent paramIntent, String paramString1, String paramString2)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString2);
    a(paramIntent, paramString1, localLinkedList);
  }
  
  private static void a(Intent paramIntent, String paramString, List<String> paramList)
  {
    if (paramList.size() > 0)
    {
      paramIntent.putExtra("be_send_card_name", paramString);
      paramIntent.putExtra("received_card_name", ah.c(paramList, ","));
      paramIntent.putExtra("Is_Chatroom", false);
    }
  }
  
  private void a(com.tencent.mm.pluginsdk.ui.applet.g.a parama)
  {
    Object localObject2;
    Object localObject1;
    int i;
    com.tencent.mm.ae.g.a locala;
    switch (this.msgType)
    {
    case 6: 
    case 7: 
    case 14: 
    case 15: 
    default: 
      return;
    case 4: 
      parama.WF(this.bVV);
      parama.cmI();
      return;
    case 0: 
    case 16: 
      localObject2 = cJx();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.imagePath != null)
        {
          float f = com.tencent.mm.cb.a.getDensity(ae.getContext());
          localObject1 = com.tencent.mm.sdk.platformtools.c.f(this.imagePath, f);
          int j = Exif.fromFile(this.imagePath).getOrientationInDegree();
          i = j;
          if (j < 0) {
            i = 0;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.c.b((Bitmap)localObject1, i);
        }
      }
      parama.d((Bitmap)localObject1, 3);
      return;
    case 1: 
      parama.d(cJw(), 2);
      return;
    case 11: 
      parama.d(cJw(), 2);
      return;
    case 9: 
      au.Hx();
      localObject2 = com.tencent.mm.model.c.Fy().HO(this.bVV);
      localObject1 = "";
      if (localObject2 != null) {
        localObject1 = ((bi.b)localObject2).label;
      }
      parama.WF(this.mController.uMN.getString(R.l.app_location) + (String)localObject1);
      return;
    case 5: 
      if (!bk.bl(this.whr))
      {
        parama.WH(this.whr);
        return;
      }
      if (!bk.bl(this.bWO.field_imgPath))
      {
        parama.WH(this.bWO.field_imgPath);
        return;
      }
      parama.WH(this.imagePath);
      return;
    case 8: 
      au.Hx();
      localObject1 = com.tencent.mm.model.c.Fy().HN(this.bVV);
      this.whk = ((bi.a)localObject1).pyp;
      this.whl = ((bi.a)localObject1).nickname;
      this.whm = Boolean.valueOf(com.tencent.mm.model.s.hI(((bi.a)localObject1).qZn));
      a(parama, this.whk);
      return;
    case 2: 
    case 10: 
      locala = com.tencent.mm.ae.g.a.gp(bk.ZQ(this.bVV));
      if ((this.bWO.ctz()) && (locala == null)) {
        locala = com.tencent.mm.ae.g.a.M(bk.ZQ(this.bVV), bk.ZQ(this.bVV));
      }
      break;
    }
    for (;;)
    {
      if (locala == null)
      {
        if (this.whs == null) {
          break;
        }
        localObject1 = getResources().getString(R.l.app_video);
        localObject2 = this.whs;
        parama.WF((String)localObject1 + (String)localObject2);
        return;
      }
      localObject2 = locala.title;
      if (com.tencent.mm.ui.chatting.m.e(this.bWO, this.vDF)) {
        localObject1 = getResources().getString(R.l.app_brand_default_name_with_brackets);
      }
      for (;;)
      {
        Object localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = "";
        }
        parama.WF((String)localObject1 + (String)localObject3);
        if (locala.thumburl == null) {
          break;
        }
        parama.WG(locala.thumburl).cmJ();
        return;
        if (locala.type == 5)
        {
          localObject1 = getResources().getString(R.l.app_url);
          localObject3 = locala.url;
        }
        else if (locala.type == 6)
        {
          localObject1 = getResources().getString(R.l.app_file);
        }
        else if (locala.type == 24)
        {
          localObject1 = getResources().getString(R.l.app_note);
          localObject2 = new nd();
          ((nd)localObject2).bWJ.type = 0;
          ((nd)localObject2).bWJ.bWL = locala.dRd;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
          localObject2 = bk.aM(((nd)localObject2).bWK.bWT.desc, locala.description).replaceAll("\n", " ");
        }
        else if (locala.type == 19)
        {
          localObject1 = getResources().getString(R.l.app_record);
        }
        else if (locala.type == 3)
        {
          localObject1 = getResources().getString(R.l.app_music);
        }
        else if (locala.type == 4)
        {
          localObject1 = getResources().getString(R.l.app_video);
        }
        else if (locala.type == 8)
        {
          localObject1 = getResources().getString(R.l.app_emoji_share);
        }
        else if ((locala.type == 33) || (locala.type == 36))
        {
          if ((locala.dTa == 2) || (locala.dTa == 3) || (locala.type == 36))
          {
            localObject1 = ((i)com.tencent.mm.kernel.g.r(i.class)).bt(this);
            parama.dw((View)localObject1);
            parama.g(Boolean.valueOf(true));
            parama.cmK();
            Object localObject4 = com.tencent.mm.as.o.OJ().b(this.bWO.field_imgPath, false, true);
            localObject2 = com.tencent.mm.plugin.appbrand.u.o.aX(this);
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("app_id", locala.dSZ);
            ((Bundle)localObject3).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(locala.dTf), Integer.valueOf(locala.dTc) }));
            ((Bundle)localObject3).putInt("msg_pkg_type", locala.dTf);
            ((Bundle)localObject3).putInt("pkg_version", locala.dTc);
            if (!bk.bl((String)localObject4)) {
              ((Bundle)localObject3).putString("image_url", "file://" + (String)localObject4);
            }
            localObject4 = (com.tencent.mm.ae.a)locala.A(com.tencent.mm.ae.a.class);
            if (localObject4 != null)
            {
              ((Bundle)localObject3).putBoolean("is_dynamic_page", ((com.tencent.mm.ae.a)localObject4).dPD);
              ((Bundle)localObject3).putString("cache_key", ((com.tencent.mm.ae.a)localObject4).dPE);
            }
            ((Bundle)localObject3).putString("title", locala.title);
            ((Bundle)localObject3).putString("msg_path", locala.dSX);
            ((i)com.tencent.mm.kernel.g.r(i.class)).a((String)localObject2, (View)localObject1, (Bundle)localObject3);
            parama.hsn = new SelectConversationUI.4(this, (String)localObject2, (View)localObject1);
            return;
          }
          localObject1 = getResources().getString(R.l.app_brand_default_name_with_brackets);
        }
        else
        {
          localObject1 = getResources().getString(R.l.app_app);
        }
      }
      localObject1 = ah.aM(l.gQ(this.mController.uMN).bWK.bWS.title, "");
      parama.WF(getResources().getString(R.l.app_multi_record) + (String)localObject1);
      return;
      localObject1 = l.gQ(this.mController.uMN);
      if (((nd)localObject1).bWJ.bWP != null) {}
      for (i = ((nd)localObject1).bWJ.bWP.size();; i = 0)
      {
        localObject1 = this.mController.uMN.getString(R.l.retransmit_msg_count, new Object[] { Integer.valueOf(i) });
        parama.WF(getResources().getString(R.l.app_multi_msg) + (String)localObject1);
        return;
        if (this.ilV == null) {
          break;
        }
        parama.WF(getResources().getString(R.l.app_file) + this.ilV);
        return;
      }
    }
  }
  
  private void a(com.tencent.mm.pluginsdk.ui.applet.g.a parama, String paramString)
  {
    au.Hx();
    com.tencent.mm.model.c.Fw().abj(paramString);
    String str = r.gV(paramString);
    if (!bk.bl(this.whl)) {
      str = this.whl;
    }
    au.Hx();
    ad localad = com.tencent.mm.model.c.Fw().abj(paramString);
    if (com.tencent.mm.model.s.hI(localad.field_verifyFlag)) {
      paramString = getResources().getString(R.l.app_friend_card_biz);
    }
    for (;;)
    {
      parama.WF(paramString + str);
      return;
      if (ad.aaU(paramString)) {
        paramString = d(this, localad);
      } else {
        paramString = getResources().getString(R.l.app_friend_card_personal);
      }
    }
  }
  
  private boolean a(final Intent paramIntent, com.tencent.mm.pluginsdk.ui.applet.g.a parama)
  {
    Object localObject2 = (HashMap)getIntent().getSerializableExtra("appbrand_params");
    int i = cc.getInt(((HashMap)localObject2).get("type"), 1);
    Object localObject1 = cc.e(((HashMap)localObject2).get("title"), "");
    String str1 = cc.e(((HashMap)localObject2).get("img_url"), null);
    if ((i == 2) || (i == 3))
    {
      String str2 = cc.e(((HashMap)localObject2).get("app_id"), null);
      i = cc.getInt(((HashMap)localObject2).get("pkg_type"), 0);
      int j = cc.getInt(((HashMap)localObject2).get("pkg_version"), 0);
      String str3 = cc.e(((HashMap)localObject2).get("cache_key"), null);
      String str4 = cc.e(((HashMap)localObject2).get("path"), null);
      String str5 = cc.e(((HashMap)localObject2).get("delay_load_img_path"), null);
      boolean bool = cc.ax(((HashMap)localObject2).get("is_dynamic"));
      localObject2 = ((i)com.tencent.mm.kernel.g.r(i.class)).bt(this);
      final String str6 = com.tencent.mm.plugin.appbrand.u.o.aX(this);
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", str2);
      localBundle.putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      localBundle.putInt("msg_pkg_type", i);
      localBundle.putInt("pkg_version", j);
      localBundle.putString("image_url", str1);
      localBundle.putBoolean("is_dynamic_page", bool);
      localBundle.putString("title", (String)localObject1);
      localBundle.putString("cache_key", str3);
      localBundle.putString("msg_path", str4);
      localBundle.putString("delay_load_img_path", str5);
      localObject1 = new e(this);
      ((e)localObject1).wie = new e.a()
      {
        public final void t(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          if (paramAnonymousBoolean)
          {
            paramIntent.putExtra("custom_send_text", paramAnonymousString);
            SelectConversationUI.a(SelectConversationUI.this, paramIntent);
            SelectConversationUI.this.finish();
          }
          ((i)com.tencent.mm.kernel.g.r(i.class)).b(str6, this.val$view);
        }
      };
      ((i)com.tencent.mm.kernel.g.r(i.class)).a(str6, (View)localObject2, localBundle, new i.a()
      {
        public final void ic(int paramAnonymousInt)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          e locale = this.whx;
          locale.wic = true;
          if (locale.jC())
          {
            ai.S(locale.gmy);
            locale.cJI();
          }
        }
      });
      parama.dw((View)localObject2);
      parama.g(Boolean.valueOf(true));
      parama.cmK();
      parama.hsn = new SelectConversationUI.2(this, str6, (View)localObject2);
      parama.DY(R.l.app_send).a(new SelectConversationUI.3(this, (e)localObject1)).few.show();
      return true;
    }
    parama.WF(getResources().getString(R.l.app_brand_default_name_with_brackets) + (String)localObject1);
    parama.WG(str1).cmJ();
    parama.g(Boolean.valueOf(true));
    return false;
  }
  
  private void aes(String paramString)
  {
    try
    {
      Object localObject = ah.h(paramString.split(","));
      paramString = new StringBuffer();
      localObject = ((List)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!ah.bl(str))
        {
          if (i != 0) {
            paramString.append(",");
          }
          paramString.append(r.gV(str));
          i = 1;
        }
      }
      h.a(this, getString(R.l.share_openim_forbiden_waring, new Object[] { paramString }), "", null);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  private void au(Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (this.msgType == 5)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("emoji_thumb_path", this.whr);
      localIntent.putExtra("emoji_activity_id", getIntent().getStringExtra("emoji_activity_id"));
    }
    super.setResult(-1, localIntent);
  }
  
  private static void b(Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramString1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("cardNameToSend is null", bool);
      paramIntent.putExtra("be_send_card_name", paramString1);
      paramIntent.putExtra("received_card_name", paramString2);
      paramIntent.putExtra("Is_Chatroom", true);
      return;
    }
  }
  
  private void b(com.tencent.mm.pluginsdk.ui.applet.g.a parama)
  {
    switch (this.msgType)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 14: 
    case 15: 
    default: 
    case 4: 
    case 0: 
    case 1: 
    case 11: 
    case 16: 
    case 9: 
    case 2: 
    case 10: 
      Object localObject;
      do
      {
        do
        {
          return;
          parama.a(new SelectConversationUI.5(this));
          return;
          parama.a(new SelectConversationUI.6(this));
          return;
          au.Hx();
          localObject = com.tencent.mm.model.c.Fy().HO(this.bVV);
          parama.a(new SelectConversationUI.7(this, (bi.b)localObject, ((bi.b)localObject).label));
          return;
          localObject = com.tencent.mm.ae.g.a.gp(bk.ZQ(this.bVV));
        } while (localObject == null);
        if ((((com.tencent.mm.ae.g.a)localObject).type == 5) && (!com.tencent.mm.ui.chatting.m.e(this.bWO, this.vDF)))
        {
          parama.a(new SelectConversationUI.8(this, ((com.tencent.mm.ae.g.a)localObject).url));
          return;
        }
        if (((com.tencent.mm.ae.g.a)localObject).type == 6)
        {
          parama.a(new SelectConversationUI.9(this));
          return;
        }
        if (((com.tencent.mm.ae.g.a)localObject).type == 24)
        {
          parama.a(new SelectConversationUI.10(this, (com.tencent.mm.ae.g.a)localObject));
          return;
        }
        if (((com.tencent.mm.ae.g.a)localObject).type == 19)
        {
          parama.a(new SelectConversationUI.11(this, (com.tencent.mm.ae.g.a)localObject));
          return;
        }
        if (((com.tencent.mm.ae.g.a)localObject).type == 3)
        {
          parama.a(new c.a.b()
          {
            public final void aSe()
            {
              Object localObject2 = p.u(this.gBQ.url, "message");
              String str = p.u(this.gBQ.dQu, "message");
              Object localObject1;
              if (aq.isMobile(SelectConversationUI.this.mController.uMN))
              {
                localObject1 = localObject2;
                if (str != null)
                {
                  if (str.length() > 0) {
                    break label113;
                  }
                  localObject1 = localObject2;
                }
              }
              for (;;)
              {
                localObject2 = new Intent();
                ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
                ((Intent)localObject2).putExtra("showShare", false);
                com.tencent.mm.br.d.b(SelectConversationUI.this.mController.uMN, "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
                return;
                if (localObject2 != null)
                {
                  localObject1 = localObject2;
                  if (((String)localObject2).length() > 0) {}
                }
                else
                {
                  label113:
                  localObject1 = str;
                }
              }
            }
          });
          return;
        }
      } while (((com.tencent.mm.ae.g.a)localObject).type != 4);
      parama.a(new SelectConversationUI.14(this));
      return;
    case 13: 
      parama.a(new SelectConversationUI.15(this));
      return;
    case 12: 
      l.gQ(this.mController.uMN);
      return;
    }
    parama.a(new SelectConversationUI.16(this));
  }
  
  private void cJA()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 5);
    localIntent.putExtra("titile", getString(R.l.address_title_select_contact));
    if (((this.fromScene != 4) && (this.fromScene != 9)) || ((getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || (this.fromScene == 10)))
    {
      localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
      localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.v(new int[] { 32, 16, 1, 2, 4, 16384 }));
    }
    for (;;)
    {
      this.mController.uMN.startActivityForResult(localIntent, 1);
      return;
      localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.vMw);
    }
  }
  
  private Bitmap cJw()
  {
    com.tencent.mm.modelvideo.o.Sr();
    String str2 = t.nT(this.bWO.field_imgPath);
    String str1 = str2;
    if (str2 == null) {
      str1 = this.imagePath;
    }
    return com.tencent.mm.sdk.platformtools.c.YW(str1);
  }
  
  private Bitmap cJx()
  {
    Object localObject;
    if (this.bWO == null) {
      localObject = null;
    }
    String str;
    Bitmap localBitmap;
    do
    {
      return localObject;
      str = this.bWO.field_imgPath;
      localObject = com.tencent.mm.as.o.OJ();
      float f = com.tencent.mm.cb.a.getDensity(ae.getContext());
      localBitmap = com.tencent.mm.sdk.platformtools.c.b(((com.tencent.mm.as.g)localObject).b(str, false, true), f, 0);
      localObject = localBitmap;
    } while (localBitmap == null);
    try
    {
      int j = Exif.fromFile(str).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localObject = com.tencent.mm.sdk.platformtools.c.b(localBitmap, i);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.SelectConversationUI", localThrowable, "unexpected exception.", new Object[0]);
    }
    return localBitmap;
  }
  
  private void cJy()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 14);
    localIntent.putExtra("titile", getString(R.l.address_title_select_contact));
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.vMx);
    localIntent.putExtra("already_select_contact", ah.c(this.whp, ","));
    localIntent.putExtra("max_limit_num", 9);
    if ((this.vNs) && (ad.aaU(this.whk))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      this.mController.uMN.startActivityForResult(localIntent, 5);
      return;
    }
  }
  
  private void cJz()
  {
    boolean bool = true;
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.s.vMu);
    localIntent.putExtra("list_type", 3);
    localIntent.putExtra("be_send_card_name", this.whk);
    localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
    localIntent.putExtra("Add_SendCard", true);
    localIntent.putExtra("titile", getString(R.l.address_title_select_contact));
    if ((this.vNs) && (ad.aaU(this.whk))) {}
    for (;;)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      this.mController.uMN.startActivityForResult(localIntent, 3);
      return;
      bool = false;
    }
  }
  
  public static String d(Context paramContext, ad paramad)
  {
    paramad = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).a(paramad.field_openImAppid, "openim_card_type_name", b.a.ePI);
    if (TextUtils.isEmpty(paramad)) {
      return paramContext.getResources().getString(R.l.app_friend_card_personal);
    }
    return String.format("[%s]", new Object[] { paramad });
  }
  
  private void et(List<String> paramList)
  {
    Cursor localCursor2 = null;
    long l = System.currentTimeMillis();
    int i = paramList.size();
    Object localObject2 = com.tencent.mm.model.y.il(getString(R.l.group_blacklist));
    Cursor localCursor1 = localCursor2;
    try
    {
      com.tencent.mm.kernel.g.DQ();
      localCursor1 = localCursor2;
      localCursor2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().d(((com.tencent.mm.model.x)localObject2).getType(), "", null);
      localCursor1 = localCursor2;
      localCursor2.moveToFirst();
      for (;;)
      {
        localCursor1 = localCursor2;
        if (localCursor2.isAfterLast()) {
          break;
        }
        localCursor1 = localCursor2;
        localObject2 = new ad();
        localCursor1 = localCursor2;
        ((ad)localObject2).d(localCursor2);
        localCursor1 = localCursor2;
        paramList.add(((ao)localObject2).field_username);
        localCursor1 = localCursor2;
        localCursor2.moveToNext();
      }
      if (localObject1 == null) {
        break label222;
      }
    }
    finally
    {
      if (localCursor1 != null) {
        localCursor1.close();
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(paramList.size() - i) });
    }
    localObject1.close();
    label222:
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(paramList.size() - i) });
  }
  
  private boolean nM(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.whp.size() < 9) {}
    }
    else {
      while (this.whp.size() > 9)
      {
        String str = getString(R.l.select_contact_num_limit_tips_withgroup, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9)) });
        h.a(this.mController.uMN, str, getString(R.l.app_remind), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        return true;
      }
    }
    return false;
  }
  
  private void o(Intent paramIntent, String paramString)
  {
    if (aer(paramString)) {
      return;
    }
    if (com.tencent.mm.ui.contact.s.fA(this.eXV, 256))
    {
      au(paramIntent);
      finish();
      return;
    }
    if (ah.bl(paramString))
    {
      com.tencent.mm.sdk.platformtools.y.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
      return;
    }
    if (com.tencent.mm.model.s.fn(paramString))
    {
      int i = com.tencent.mm.model.m.gM(paramString);
      if (this.whj)
      {
        int j = ah.getInt(com.tencent.mm.m.g.AA().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50);
        if (i > j)
        {
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          h.b(this, getString(R.l.select_contact_num_limit_tips_bigfile, new Object[] { Integer.valueOf(j) }), "", true);
          return;
        }
      }
      getString(R.l.select_contact_num, new Object[] { Integer.valueOf(i) });
    }
    com.tencent.mm.pluginsdk.ui.applet.g.a locala = new com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController.uMN);
    locala.bM(paramString);
    if (this.vNs)
    {
      a(locala, this.whk);
      if (com.tencent.mm.model.s.fn(paramString))
      {
        b(paramIntent, this.whk, paramString);
        label220:
        locala.g(Boolean.valueOf(true));
      }
    }
    for (;;)
    {
      locala.DY(R.l.app_send).a(new SelectConversationUI.26(this, paramIntent)).few.show();
      return;
      a(paramIntent, this.whk, paramString);
      break label220;
      if (this.whc)
      {
        if (this.bIr != -1L)
        {
          b(locala);
          paramString = new gd();
          paramString.bNA.bIr = this.bIr;
          paramString.bNA.bNB = locala;
          paramString.bNA.bNC = this.wht;
          paramString.bNA.bGa = this.mController.uMN;
          com.tencent.mm.sdk.b.a.udP.m(paramString);
        }
        for (;;)
        {
          locala.g(Boolean.valueOf(true));
          break;
          if ((this.msgType == 17) && (this.whi != 0))
          {
            paramString = this.mController.uMN.getString(R.l.retransmit_msg_count, new Object[] { Integer.valueOf(this.whi) });
            locala.WF(getResources().getString(R.l.app_multi_msg) + paramString);
          }
        }
      }
      String str;
      if (this.whd)
      {
        Object localObject = (HashMap)getIntent().getSerializableExtra("webview_params");
        paramString = (String)((HashMap)localObject).get("img_url");
        str = (String)((HashMap)localObject).get("title");
        localObject = (String)((HashMap)localObject).get("url");
        locala.WF(getResources().getString(R.l.app_url) + str);
        locala.a(new SelectConversationUI.25(this, (String)localObject));
        locala.WG(paramString).cmJ();
        locala.g(Boolean.valueOf(true));
      }
      else
      {
        if ((this.whe) && (a(paramIntent, locala))) {
          break;
        }
        if (this.whg)
        {
          str = getResources().getString(R.l.app_golden_lucky);
          paramString = str;
          if (this.ilV != null) {
            paramString = str + this.ilV;
          }
          locala.WF(paramString);
          locala.g(Boolean.valueOf(false));
        }
        else
        {
          a(locala);
          b(locala);
          locala.g(Boolean.valueOf(true));
        }
      }
    }
  }
  
  private void xU()
  {
    if (!this.whn) {
      return;
    }
    if ((this.whp != null) && (this.whp.size() > 0))
    {
      updateOptionMenuText(1, getString(R.l.app_send) + "(" + this.whp.size() + ")");
      a(this.whv);
      enableOptionMenu(1, true);
      return;
    }
    if (!this.who)
    {
      updateOptionMenuText(1, getString(R.l.app_multi_selected));
      a(this.whu);
      enableOptionMenu(1, true);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_single_selected));
    a(this.whu);
    enableOptionMenu(1, true);
  }
  
  protected final boolean VC()
  {
    return false;
  }
  
  protected final boolean VD()
  {
    return false;
  }
  
  protected final String VE()
  {
    String str2 = getIntent().getStringExtra("Select_Conv_ui_title");
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() > 0) {}
    }
    else
    {
      str1 = getString(R.l.select_conversation_title);
    }
    return str1;
  }
  
  protected final com.tencent.mm.ui.contact.o VF()
  {
    return new com.tencent.mm.ui.contact.x(this, this.dru, this.vLZ, this.who, this.whh, this.eXV);
  }
  
  protected final com.tencent.mm.ui.contact.m VG()
  {
    return new q(this, this.dru, this.who, this.scene);
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    super.a(paramListView, paramInt);
    if (this.vfO == null)
    {
      if (!this.vNs) {
        break label106;
      }
      this.wha = R.l.select_more_contact;
    }
    for (;;)
    {
      Object localObject = new SelectConversationUI.12(this);
      String str = getString(this.wha);
      View localView = com.tencent.mm.ui.y.gt(this).inflate(R.i.group_card_item, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(R.h.content_tv);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.vfO = ((TextView)localObject);
      this.vfO.setVisibility(paramInt);
      return;
      label106:
      if (this.fromScene == 10) {
        this.wha = R.l.open_main_contact_title;
      } else {
        this.wha = R.l.select_conversation_create;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    if ((parama.vLJ) && (parama.dnp != null)) {
      return this.whp.contains(parama.dnp.field_username);
    }
    return false;
  }
  
  public final boolean aer(String paramString)
  {
    int i;
    if (ad.aaU(paramString))
    {
      i = 1;
      if (i != 0) {
        break label32;
      }
    }
    label32:
    String str;
    do
    {
      return false;
      if (com.tencent.mm.model.s.hb(paramString))
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      if (!ah.bl(getIntent().getStringExtra("Select_App_Id")))
      {
        aes(paramString);
        return true;
      }
      if (this.vNs)
      {
        au.Hx();
        if (ad.Fn(com.tencent.mm.model.c.Fw().abj(this.whk).field_verifyFlag))
        {
          aes(paramString);
          return true;
        }
      }
      switch (this.msgType)
      {
      case 5: 
      case 6: 
      case 7: 
      default: 
        return false;
      }
      au.Hx();
      str = com.tencent.mm.model.c.Fy().HN(this.bVV).pyp;
      au.Hx();
    } while (!com.tencent.mm.model.s.hI(com.tencent.mm.model.c.Fw().abj(str).field_verifyFlag));
    aes(paramString);
    return true;
  }
  
  public final int[] bgw()
  {
    int[] arrayOfInt2 = getIntent().getIntArrayExtra("search_range");
    int[] arrayOfInt1;
    if ((this.fromScene == 4) || (this.fromScene == 10))
    {
      arrayOfInt1 = new int[1];
      arrayOfInt1[0] = 131072;
    }
    do
    {
      return arrayOfInt1;
      arrayOfInt1 = arrayOfInt2;
    } while (arrayOfInt2 != null);
    return super.bgw();
  }
  
  protected final void bgx()
  {
    if (this.fromScene == 5) {
      h.a(this, getString(R.l.lucky_money_select_contact_cancel_notify), null, getString(R.l.send), getString(R.l.cancel), true, new SelectConversationUI.22(this), new SelectConversationUI.23(this));
    }
    for (;;)
    {
      if (this.whq != null)
      {
        this.whq.errCode = 0;
        ReportUtil.a(this, this.whq, true);
      }
      return;
      super.bgx();
      XM();
    }
  }
  
  protected final boolean cHI()
  {
    return true;
  }
  
  public final void jP(int paramInt)
  {
    int i;
    if (this.who)
    {
      i = paramInt - getContentLV().getHeaderViewsCount();
      if (i < 0)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
        cJy();
      }
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = cHE();
            localObject2 = ((n)localObject1).HK(i);
          } while ((localObject2 == null) || (((com.tencent.mm.ui.contact.a.a)localObject2).dnp == null));
          localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject2).dnp.field_username;
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[] { localObject2 });
          if ((!this.whp.contains(localObject2)) && (nM(true)))
          {
            cHK();
            return;
          }
          cHK();
          this.mbR.Wv((String)localObject2);
          if (this.whp.contains(localObject2)) {
            this.whp.remove(localObject2);
          }
          for (;;)
          {
            xU();
            ((n)localObject1).notifyDataSetChanged();
            return;
            this.whp.add(localObject2);
          }
          if (paramInt < getContentLV().getHeaderViewsCount())
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
            if (this.vNs)
            {
              cJz();
              return;
            }
            cJA();
            return;
          }
          localObject1 = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
        } while (localObject1 == null);
        if (((localObject1 instanceof com.tencent.mm.ui.contact.a.b)) && (((com.tencent.mm.ui.contact.a.b)localObject1).aVr == getResources().getString(R.l.address_official_accounts_title)))
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("list_attr", 16384);
          com.tencent.mm.br.d.b(this, "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject1, 4);
          this.whd = true;
          return;
        }
        if ((localObject1 instanceof f))
        {
          localObject3 = (f)localObject1;
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("scene", this.scene);
          localObject2 = new ArrayList();
          localObject3 = ((com.tencent.mm.ui.contact.a.a)localObject3).kwi.kwI;
          i = localObject3.length;
          paramInt = 0;
          while (paramInt < i)
          {
            ((ArrayList)localObject2).add(localObject3[paramInt]);
            paramInt += 1;
          }
          ((Intent)localObject1).putExtra("query_phrase_list", (Serializable)localObject2);
          com.tencent.mm.br.d.c(this, ".ui.transmit.MMCreateChatroomUI", (Intent)localObject1, 1);
          return;
        }
        localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).dnp;
      } while (localObject1 == null);
      localObject1 = ((ao)localObject1).field_username;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[] { localObject1 });
    } while (aer((String)localObject1));
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("Select_Conv_User", (String)localObject1);
    Object localObject3 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
    if (localObject3 != null) {
      a((Intent)localObject2, (Intent)localObject3);
    }
    for (;;)
    {
      XM();
      return;
      if ((this.whb) || (this.vNs) || (this.whc) || (this.whd) || (this.whe))
      {
        o((Intent)localObject2, (String)localObject1);
      }
      else
      {
        au((Intent)localObject2);
        finish();
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject2;
    if (paramIntent != null)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
      if (paramInt1 != 1) {
        break label236;
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
        localObject2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject2 == null) {
          break label183;
        }
        if (!aer((String)localObject1)) {
          break label175;
        }
      }
    }
    label175:
    label183:
    label236:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
                break;
                a(paramIntent, (Intent)localObject2);
                return;
                if ((this.whb) || (this.vNs) || (this.whc) || (this.whd) || (this.whe))
                {
                  o(paramIntent, (String)localObject1);
                  return;
                }
                au(paramIntent);
                finish();
                return;
                if (paramInt1 != 2) {
                  break label334;
                }
                switch (paramInt2)
                {
                default: 
                  return;
                case -1: 
                  finish();
                }
              } while ((paramIntent == null) || (!paramIntent.getBooleanExtra("Select_stay_in_wx", false)));
              paramIntent = new Intent(this, TaskRedirectUI.class);
              paramIntent.addFlags(268435456);
              startActivity(paramIntent);
              ReportUtil.y(false, 0);
              return;
            } while (paramIntent == null);
            this.whq = ((ReportUtil.ReportArgs)paramIntent.getParcelableExtra("Select_Report_Args"));
            return;
            if (paramInt1 != 3) {
              break label454;
            }
            switch (paramInt2)
            {
            default: 
              return;
            }
          } while (paramIntent == null);
          paramIntent = paramIntent.getStringExtra("received_card_name");
        } while ((bk.bl(paramIntent)) || (aer(paramIntent)));
        localObject1 = new com.tencent.mm.pluginsdk.ui.applet.g.a(this.mController.uMN);
        ((com.tencent.mm.pluginsdk.ui.applet.g.a)localObject1).bM(paramIntent);
        a((com.tencent.mm.pluginsdk.ui.applet.g.a)localObject1, this.whk);
        ((com.tencent.mm.pluginsdk.ui.applet.g.a)localObject1).g(Boolean.valueOf(true)).DY(R.l.app_send).a(new SelectConversationUI.24(this, paramIntent)).few.show();
        return;
        if (paramInt1 != 4) {
          break label481;
        }
      } while ((paramInt2 != -1) || (paramIntent == null));
      o(paramIntent, paramIntent.getStringExtra("Select_Contact"));
      return;
      if (paramInt1 != 5) {
        break label635;
      }
    } while ((paramInt2 != -1) || (paramIntent == null));
    label334:
    label481:
    paramIntent = paramIntent.getStringExtra("Select_Conv_User");
    label454:
    Object localObject1 = this.whp.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      this.mbR.Ww((String)localObject2);
    }
    if (!ah.bl(paramIntent)) {
      this.whp = ah.h(paramIntent.split(","));
    }
    for (;;)
    {
      paramIntent = this.whp.iterator();
      while (paramIntent.hasNext())
      {
        localObject1 = (String)paramIntent.next();
        this.mbR.bz((String)localObject1, false);
      }
      this.whp.clear();
    }
    xU();
    cHE().notifyDataSetChanged();
    return;
    label635:
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = " + paramInt1);
  }
  
  public void onBackPressed()
  {
    super.bgx();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    com.tencent.mm.pluginsdk.e.k(this);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Select_App_Id");
    String str = getIntent().getStringExtra("Select_Open_Id");
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + paramBundle + ", openId = " + str);
    if ((!ah.bl(paramBundle)) && (!ah.bl(str))) {
      new com.tencent.mm.plugin.base.stub.d(this, paramBundle, str, new SelectConversationUI.1(this)).awa();
    }
    com.tencent.mm.pluginsdk.e.l(this);
  }
  
  public final void pw(String paramString)
  {
    this.whp.remove(paramString);
    cHE().notifyDataSetChanged();
    xU();
  }
  
  protected final void xK()
  {
    super.xK();
    this.whb = getIntent().getBooleanExtra("select_is_ret", false);
    this.fromScene = getIntent().getIntExtra("scene_from", 0);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    if (this.fromScene == 1) {
      this.whc = true;
    }
    for (;;)
    {
      this.whh = getIntent().getBooleanExtra("send_to_biz", false);
      this.vDF = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.bIr = getIntent().getLongExtra("select_fav_local_id", -1L);
      this.whi = getIntent().getIntExtra("select_fav_select_count", 0);
      this.whn = getIntent().getBooleanExtra("mutil_select_is_ret", false);
      this.vNs = getIntent().getBooleanExtra("Select_Send_Card", false);
      this.whj = getIntent().getBooleanExtra("Retr_Big_File", false);
      if (this.vNs) {
        this.whk = getIntent().getStringExtra("Select_Talker_Name");
      }
      this.eXV = getIntent().getIntExtra("Select_Conv_Type", wgZ);
      this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
      this.bIt = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      au.Hx();
      this.bWO = com.tencent.mm.model.c.Fy().fd(this.bIt);
      this.imagePath = getIntent().getStringExtra("image_path");
      this.whs = getIntent().getStringExtra("ad_video_title");
      this.ilV = getIntent().getStringExtra("desc_title");
      this.whr = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.bVV = getIntent().getStringExtra("Retr_Msg_content");
      this.wht = getIntent().getStringExtra("Retr_fav_xml_str");
      if ((this.bVV == null) && (this.bWO != null)) {
        this.bVV = this.bWO.field_content;
      }
      this.whq = ((ReportUtil.ReportArgs)getIntent().getParcelableExtra("Select_Report_Args"));
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(com.tencent.mm.ui.contact.s.cHO());
      Object localObject = getIntent().getStringExtra("Select_block_List");
      if (!ah.bl((String)localObject)) {
        localHashSet.addAll(ah.h(((String)localObject).split(",")));
      }
      if (com.tencent.mm.ui.contact.s.fA(this.eXV, 2))
      {
        localObject = com.tencent.mm.ui.contact.s.cHP();
        com.tencent.mm.ui.contact.s.h((HashSet)localObject);
        localHashSet.addAll((Collection)localObject);
      }
      this.dru = new ArrayList();
      this.dru.addAll(localHashSet);
      et(this.dru);
      if (com.tencent.mm.ui.contact.s.fA(this.eXV, 1)) {
        this.vLZ = true;
      }
      if (this.whn)
      {
        this.whp = new LinkedList();
        if (this.whn)
        {
          a(1, getString(R.l.app_multi_selected), this.whu, s.b.uNx);
          xU();
        }
      }
      return;
      if ((this.fromScene == 2) || (this.fromScene == 10)) {
        this.whd = true;
      } else if (this.fromScene == 3) {
        this.whe = true;
      } else if (this.fromScene == 6) {
        this.whf = true;
      } else if (this.fromScene == 7) {
        this.whg = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI
 * JD-Core Version:    0.7.0.1
 */