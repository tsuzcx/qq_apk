package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Context;
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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.a;
import com.tencent.mm.af.j.b;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.a;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ce;
import com.tencent.mm.model.s;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.k;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.b.c.a.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@com.tencent.mm.kernel.i
@com.tencent.mm.ui.base.a(23)
public class SelectConversationUI
  extends MMBaseSelectContactUI
{
  private static final int AzQ;
  private boolean AAa;
  private String AAb;
  private String AAc;
  private Boolean AAd;
  private boolean AAe;
  private boolean AAf;
  private List<String> AAg;
  private ReportUtil.ReportArgs AAh;
  private String AAi;
  private String AAj;
  private String AAk;
  private int AAl;
  private String AAm;
  private MenuItem.OnMenuItemClickListener AAn;
  private MenuItem.OnMenuItemClickListener AAo;
  private boolean AdB;
  private boolean AeW;
  private int AzR;
  private boolean AzS;
  private boolean AzT;
  private boolean AzU;
  private boolean AzV;
  private boolean AzW;
  private boolean AzX;
  private boolean AzY;
  private int AzZ;
  private String cDI;
  private bi cEE;
  private long cpM;
  private long cpO;
  private List<String> ejc;
  private int fromScene;
  private int gpS;
  private String imagePath;
  private String kmS;
  private String lsX;
  private int[] mEF;
  private int msgType;
  private int zUQ;
  private TextView zun;
  
  static
  {
    AppMethodBeat.i(35207);
    AzQ = com.tencent.mm.ui.contact.t.F(new int[] { 1, 2 });
    AppMethodBeat.o(35207);
  }
  
  public SelectConversationUI()
  {
    AppMethodBeat.i(35153);
    this.AzS = false;
    this.AzT = false;
    this.AzU = false;
    this.AzV = false;
    this.AzW = false;
    this.AzX = false;
    this.fromScene = 0;
    this.AzY = false;
    this.AeW = false;
    this.AAa = false;
    this.zUQ = -1;
    this.AAd = Boolean.FALSE;
    this.AAe = false;
    this.AAf = false;
    this.AAg = null;
    this.imagePath = null;
    this.AAi = null;
    this.kmS = null;
    this.mEF = new int[] { 2131822717, 2131822718, 2131822719, 2131822720, 2131822721 };
    this.AAn = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(35144);
        paramAnonymousMenuItem = SelectConversationUI.this;
        boolean bool;
        if (!SelectConversationUI.a(SelectConversationUI.this))
        {
          bool = true;
          SelectConversationUI.a(paramAnonymousMenuItem, bool);
          SelectConversationUI.this.dLW().ri(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.this.Adp.ri(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.k(SelectConversationUI.this);
          paramAnonymousMenuItem = SelectConversationUI.m(SelectConversationUI.this);
          if (SelectConversationUI.a(SelectConversationUI.this)) {
            break label112;
          }
        }
        label112:
        for (int i = SelectConversationUI.l(SelectConversationUI.this);; i = 2131303068)
        {
          paramAnonymousMenuItem.setText(i);
          AppMethodBeat.o(35144);
          return true;
          bool = false;
          break;
        }
      }
    };
    this.AAo = new SelectConversationUI.22(this);
    AppMethodBeat.o(35153);
  }
  
  private void Km()
  {
    AppMethodBeat.i(35191);
    if (!this.AAe)
    {
      AppMethodBeat.o(35191);
      return;
    }
    if ((this.AAg != null) && (this.AAg.size() > 0))
    {
      updateOptionMenuText(1, getString(2131297067) + "(" + this.AAg.size() + ")");
      updateOptionMenuListener(1, this.AAo, null);
      enableOptionMenu(1, true);
      AppMethodBeat.o(35191);
      return;
    }
    if (!this.AAf)
    {
      updateOptionMenuText(1, getString(2131297002));
      updateOptionMenuListener(1, this.AAn, null);
      enableOptionMenu(1, true);
      AppMethodBeat.o(35191);
      return;
    }
    updateOptionMenuText(1, getString(2131297079));
    updateOptionMenuListener(1, this.AAn, null);
    enableOptionMenu(1, true);
    AppMethodBeat.o(35191);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(35183);
    Object localObject = null;
    float f = paramInt2 / paramInt1;
    int k = 0;
    int j = 0;
    int m = al.ap(paramContext, 2131427567);
    paramInt1 = al.ap(paramContext, 2131427566);
    int i = 0;
    paramInt2 = 0;
    if ((f > 0.0F) && (f < 0.5D))
    {
      j = (int)(m / f);
      paramInt2 = m;
      k = m;
      i = paramInt1;
    }
    for (;;)
    {
      paramContext = localObject;
      if (k > 0)
      {
        paramContext = localObject;
        if (j > 0)
        {
          paramContext = localObject;
          if (paramBitmap != null)
          {
            paramContext = Bitmap.createScaledBitmap(paramBitmap, j, k, true);
            paramImageView.setLayoutParams(new FrameLayout.LayoutParams(i, paramInt2));
          }
        }
      }
      AppMethodBeat.o(35183);
      return paramContext;
      if ((f >= 0.5D) && (f < 1.0F))
      {
        k = (int)(paramInt1 * f);
        paramInt2 = k;
        i = paramInt1;
        j = paramInt1;
      }
      else if ((f >= 1.0F) && (f < 2.0F))
      {
        j = (int)(paramInt1 / f);
        paramInt2 = paramInt1;
        i = j;
        k = paramInt1;
      }
      else if (f >= 2.0F)
      {
        k = (int)(m * f);
        i = m;
        j = m;
        paramInt2 = paramInt1;
      }
    }
  }
  
  private void a(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(35173);
    ab.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=".concat(String.valueOf(paramIntent2)));
    paramIntent2.putExtras(paramIntent1.getExtras());
    startActivityForResult(paramIntent2, 2);
    com.tencent.mm.ui.base.b.K(getContext(), paramIntent2);
    AppMethodBeat.o(35173);
  }
  
  private static void a(Intent paramIntent, String paramString1, String paramString2)
  {
    AppMethodBeat.i(35167);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString2);
    a(paramIntent, paramString1, localLinkedList);
    AppMethodBeat.o(35167);
  }
  
  private static void a(Intent paramIntent, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(35168);
    if (paramList.size() > 0)
    {
      paramIntent.putExtra("be_send_card_name", paramString);
      paramIntent.putExtra("received_card_name", com.tencent.mm.platformtools.ah.d(paramList, ","));
      paramIntent.putExtra("Is_Chatroom", false);
    }
    AppMethodBeat.o(35168);
  }
  
  private void a(g.a parama)
  {
    AppMethodBeat.i(35177);
    Object localObject2;
    Object localObject1;
    int i;
    j.b localb;
    switch (this.msgType)
    {
    case 6: 
    case 7: 
    case 14: 
    case 15: 
    default: 
      AppMethodBeat.o(35177);
      return;
    case 4: 
      parama.amm(this.cDI);
      parama.dny();
      AppMethodBeat.o(35177);
      return;
    case 0: 
    case 16: 
      localObject2 = dOo();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.imagePath != null)
        {
          float f = com.tencent.mm.cb.a.getDensity(com.tencent.mm.sdk.platformtools.ah.getContext());
          localObject1 = com.tencent.mm.sdk.platformtools.d.l(this.imagePath, f);
          int j = Exif.fromFile(this.imagePath).getOrientationInDegree();
          i = j;
          if (j < 0) {
            i = 0;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject1, i);
        }
      }
      parama.d((Bitmap)localObject1, 3);
      AppMethodBeat.o(35177);
      return;
    case 1: 
      parama.d(dOn(), 2);
      AppMethodBeat.o(35177);
      return;
    case 11: 
      parama.d(dOn(), 2);
      AppMethodBeat.o(35177);
      return;
    case 9: 
      parama.amm(dOm());
      AppMethodBeat.o(35177);
      return;
    case 5: 
      if (!bo.isNullOrNil(this.lsX))
      {
        parama.amo(this.lsX);
        AppMethodBeat.o(35177);
        return;
      }
      if (!bo.isNullOrNil(this.cEE.field_imgPath))
      {
        parama.amo(this.cEE.field_imgPath);
        AppMethodBeat.o(35177);
        return;
      }
      parama.amo(this.imagePath);
      AppMethodBeat.o(35177);
      return;
    case 8: 
      aw.aaz();
      localObject1 = com.tencent.mm.model.c.YC().Ty(this.cDI);
      this.AAb = ((bi.a)localObject1).tac;
      this.AAc = ((bi.a)localObject1).nickname;
      this.AAd = Boolean.valueOf(com.tencent.mm.model.t.ku(((bi.a)localObject1).uOT));
      a(parama, this.AAb);
      AppMethodBeat.o(35177);
      return;
    case 2: 
    case 10: 
      localb = j.b.mY(bo.apU(this.cDI));
      if ((this.cEE.dvV()) && (localb == null)) {
        localb = j.b.ab(bo.apU(this.cDI), bo.apU(this.cDI));
      }
      break;
    }
    for (;;)
    {
      if (localb == null)
      {
        if (this.AAi != null)
        {
          localObject1 = getResources().getString(2131297102);
          localObject2 = this.AAi;
          parama.amm((String)localObject1 + (String)localObject2);
        }
        AppMethodBeat.o(35177);
        return;
      }
      localObject2 = localb.title;
      if (com.tencent.mm.ui.chatting.l.f(this.cEE, this.zUQ)) {
        localObject1 = getResources().getString(2131296607);
      }
      for (;;)
      {
        if (localb.type == 48) {
          localObject1 = getResources().getString(2131296971);
        }
        if (localb.type != 46) {
          break;
        }
        parama.d(dOo(), 2);
        AppMethodBeat.o(35177);
        return;
        if (localb.type == 5)
        {
          localObject1 = getResources().getString(2131297097);
        }
        else if (localb.type == 6)
        {
          localObject1 = getResources().getString(2131296962);
        }
        else if (localb.type == 24)
        {
          localObject1 = getResources().getString(2131297017);
          localObject2 = i(localb);
        }
        else if (localb.type == 19)
        {
          localObject1 = getResources().getString(2131297055);
        }
        else if (localb.type == 3)
        {
          localObject1 = getResources().getString(2131297003);
        }
        else if (localb.type == 4)
        {
          localObject1 = getResources().getString(2131297102);
        }
        else if (localb.type == 8)
        {
          localObject1 = getResources().getString(2131296917);
        }
        else if ((localb.type == 33) || (localb.type == 36) || (localb.type == 44) || (localb.type == 48))
        {
          if ((localb.fiZ == 2) || (localb.fiZ == 3) || (localb.type == 36) || (localb.type == 48))
          {
            i = localb.fje;
            if (localb.cH(false))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("key_biz", i);
              ((Bundle)localObject1).putString("key_footer_text_default", localb.cGO);
              ((Bundle)localObject1).putString("key_footer_text", localb.q(getContext(), false));
              ((Bundle)localObject1).putString("key_footer_icon", localb.fjj);
            }
            for (;;)
            {
              localObject1 = ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).e(this, (Bundle)localObject1);
              parama.eC((View)localObject1);
              parama.i(Boolean.TRUE);
              parama.dnA();
              Object localObject4 = com.tencent.mm.at.o.ahC().c(this.cEE.field_imgPath, false, true);
              localObject2 = com.tencent.mm.plugin.appbrand.s.n.bt(this);
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("app_id", localb.fiY);
              ((Bundle)localObject3).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(localb.fjh), Integer.valueOf(localb.fjb) }));
              ((Bundle)localObject3).putInt("msg_pkg_type", localb.fjh);
              ((Bundle)localObject3).putInt("pkg_version", localb.fjb);
              if (!bo.isNullOrNil((String)localObject4)) {
                ((Bundle)localObject3).putString("image_url", "file://".concat(String.valueOf(localObject4)));
              }
              localObject4 = (com.tencent.mm.af.a)localb.R(com.tencent.mm.af.a.class);
              if (localObject4 != null)
              {
                ((Bundle)localObject3).putBoolean("is_dynamic_page", ((com.tencent.mm.af.a)localObject4).ffc);
                ((Bundle)localObject3).putString("cache_key", ((com.tencent.mm.af.a)localObject4).ffd);
              }
              ((Bundle)localObject3).putString("title", localb.title);
              ((Bundle)localObject3).putString("msg_path", localb.fiW);
              ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).a((String)localObject2, (View)localObject1, (Bundle)localObject3);
              parama.jiU = new SelectConversationUI.6(this, (String)localObject2, (View)localObject1);
              AppMethodBeat.o(35177);
              return;
              if (localb.type == 48)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putBoolean("is_video", true);
                ((Bundle)localObject1).putString("key_footer_icon", localb.fjj);
                ((Bundle)localObject1).putString("key_footer_text", localb.cGO);
              }
              else
              {
                ab.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(i) });
                localObject1 = null;
              }
            }
          }
          localObject1 = getResources().getString(2131296607);
        }
        else
        {
          localObject1 = getResources().getString(2131296543);
        }
      }
      Object localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = "";
      }
      parama.amm((String)localObject1 + (String)localObject3);
      if (localb.thumburl == null) {
        break;
      }
      parama.amn(localb.thumburl).dnz();
      AppMethodBeat.o(35177);
      return;
      localObject1 = com.tencent.mm.platformtools.ah.bf(k.il(getContext()).cEA.cEI.title, "");
      parama.amm(getResources().getString(2131297001) + (String)localObject1);
      AppMethodBeat.o(35177);
      return;
      localObject1 = k.il(getContext());
      if (((oa)localObject1).cEz.cEF != null) {}
      for (i = ((oa)localObject1).cEz.cEF.size();; i = 0)
      {
        localObject1 = getContext().getString(2131302652, new Object[] { Integer.valueOf(i) });
        parama.amm(getResources().getString(2131297000) + (String)localObject1);
        AppMethodBeat.o(35177);
        return;
        if (this.kmS == null) {
          break;
        }
        parama.amm(getResources().getString(2131296962) + this.kmS);
        break;
      }
    }
  }
  
  private void a(g.a parama, String paramString)
  {
    AppMethodBeat.i(35170);
    aw.aaz();
    com.tencent.mm.model.c.YA().aru(paramString);
    String str = s.nE(paramString);
    if (!bo.isNullOrNil(this.AAc)) {
      str = this.AAc;
    }
    parama.amm(avd(paramString) + str);
    AppMethodBeat.o(35170);
  }
  
  private boolean a(Intent paramIntent, g.a parama)
  {
    AppMethodBeat.i(35175);
    Object localObject2 = (HashMap)getIntent().getSerializableExtra("appbrand_params");
    boolean bool2 = ce.aR(((HashMap)localObject2).get("is_weishi_video"));
    boolean bool1 = ce.aR(((HashMap)localObject2).get("is_video"));
    if (bool2)
    {
      bool1 = a(parama, (HashMap)localObject2);
      AppMethodBeat.o(35175);
      return bool1;
    }
    int i = ce.getInt(((HashMap)localObject2).get("type"), 1);
    String str1 = ce.f(((HashMap)localObject2).get("title"), "");
    String str2 = ce.f(((HashMap)localObject2).get("img_url"), null);
    if ((i == 2) || (i == 3))
    {
      String str3 = ce.f(((HashMap)localObject2).get("app_id"), null);
      i = ce.getInt(((HashMap)localObject2).get("pkg_type"), 0);
      int j = ce.getInt(((HashMap)localObject2).get("pkg_version"), 0);
      String str4 = ce.f(((HashMap)localObject2).get("cache_key"), null);
      String str5 = ce.f(((HashMap)localObject2).get("path"), null);
      String str6 = ce.f(((HashMap)localObject2).get("delay_load_img_path"), null);
      String str7 = ce.f(((HashMap)localObject2).get("nickname"), "");
      bool2 = ce.aR(((HashMap)localObject2).get("is_dynamic"));
      int k = ce.getInt(((HashMap)localObject2).get("biz"), j.a.fgr.ordinal());
      Object localObject3;
      Object localObject1;
      if (j.a.isValid(k))
      {
        localObject3 = ce.f(((HashMap)localObject2).get("tail_lang"), "");
        String str8 = ce.f(((HashMap)localObject2).get("icon_url"), "");
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("key_biz", k);
        ((Bundle)localObject1).putString("key_footer_text_default", str7);
        ((Bundle)localObject1).putString("key_footer_text", j.a.b(k, (String)localObject3, getContext()));
        ((Bundle)localObject1).putString("key_footer_icon", str8);
        ab.d("MicroMsg.SelectConversationUI", "defaultFooterTxt: %s, tailLang: %s.", new Object[] { str7, localObject3 });
      }
      for (;;)
      {
        localObject1 = ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).e(this, (Bundle)localObject1);
        str7 = com.tencent.mm.plugin.appbrand.s.n.bt(this);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putString("app_id", str3);
        ((Bundle)localObject3).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
        ((Bundle)localObject3).putInt("msg_pkg_type", i);
        ((Bundle)localObject3).putInt("pkg_version", j);
        ((Bundle)localObject3).putString("image_url", str2);
        ((Bundle)localObject3).putBoolean("is_dynamic_page", bool2);
        ((Bundle)localObject3).putString("title", str1);
        ((Bundle)localObject3).putString("cache_key", str4);
        ((Bundle)localObject3).putString("msg_path", str5);
        ((Bundle)localObject3).putString("delay_load_img_path", str6);
        if (bool1)
        {
          str1 = ce.f(((HashMap)localObject2).get("video_path"), "");
          localObject2 = ce.f(((HashMap)localObject2).get("video_thumb_path"), "");
          ((Bundle)localObject3).putBoolean("is_video", true);
          ((Bundle)localObject3).putString("video_path", str1);
          ((Bundle)localObject3).putString("video_thumb_path", (String)localObject2);
        }
        localObject2 = new e(this);
        ((e)localObject2).AAY = new SelectConversationUI.30(this, paramIntent, str7, (View)localObject1);
        ((com.tencent.mm.modelappbrand.i)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.i.class)).a(str7, (View)localObject1, (Bundle)localObject3, new SelectConversationUI.2(this, (e)localObject2));
        parama.eC((View)localObject1);
        parama.i(Boolean.TRUE);
        parama.dnA();
        parama.jiU = new SelectConversationUI.3(this, str7, (View)localObject1);
        parama.LU(2131297067).a(new SelectConversationUI.4(this, (e)localObject2)).gwf.show();
        AppMethodBeat.o(35175);
        return true;
        if (bool1)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("is_video", true);
          str7 = ce.f(((HashMap)localObject2).get("footer_icon"), "");
          localObject3 = ce.f(((HashMap)localObject2).get("footer_text"), "");
          ((Bundle)localObject1).putString("key_footer_icon", str7);
          ((Bundle)localObject1).putString("key_footer_text", (String)localObject3);
        }
        else
        {
          ab.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(k) });
          localObject1 = null;
        }
      }
    }
    parama.amm(getResources().getString(2131296607) + str1);
    parama.amn(str2).dnz();
    parama.i(Boolean.TRUE);
    AppMethodBeat.o(35175);
    return false;
  }
  
  private boolean a(g.a parama, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(35176);
    String str = ce.f(paramHashMap.get("img_url"), null);
    if (!com.tencent.mm.platformtools.ah.isNullOrNil(str))
    {
      paramHashMap = new RelativeLayout(this);
      View localView = LayoutInflater.from(this).inflate(2130969200, null);
      paramHashMap.addView(localView, new RelativeLayout.LayoutParams(-2, -2));
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(14);
      ImageView localImageView = (ImageView)localView.findViewById(2131822985);
      ((ImageView)localView.findViewById(2131822988)).setImageResource(2131232155);
      parama.eC(paramHashMap);
      parama.dnA();
      com.tencent.mm.modelappbrand.a.b.acD().a(new SelectConversationUI.5(this, localImageView, str), str, null, null);
    }
    for (;;)
    {
      parama.i(Boolean.TRUE);
      AppMethodBeat.o(35176);
      return false;
      paramHashMap = ce.f(paramHashMap.get("msg_img_path"), null);
      if (!com.tencent.mm.platformtools.ah.isNullOrNil(paramHashMap))
      {
        ab.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", new Object[] { str, paramHashMap });
        parama.d(ave(paramHashMap), 2);
      }
    }
  }
  
  private static boolean auZ(String paramString)
  {
    AppMethodBeat.i(35163);
    if (ad.arf(paramString))
    {
      AppMethodBeat.o(35163);
      return true;
    }
    if (com.tencent.mm.model.t.nK(paramString))
    {
      AppMethodBeat.o(35163);
      return true;
    }
    AppMethodBeat.o(35163);
    return false;
  }
  
  private void avb(String paramString)
  {
    AppMethodBeat.i(35165);
    try
    {
      Object localObject = com.tencent.mm.platformtools.ah.h(paramString.split(","));
      paramString = new StringBuffer();
      localObject = ((List)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!com.tencent.mm.platformtools.ah.isNullOrNil(str))
        {
          if (i != 0) {
            paramString.append(",");
          }
          paramString.append(s.nE(str));
          i = 1;
        }
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131303667, new Object[] { paramString }), "", null);
      AppMethodBeat.o(35165);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(35165);
    }
  }
  
  private void avc(String paramString)
  {
    AppMethodBeat.i(35166);
    ab.i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", new Object[] { paramString, this.AAk, Integer.valueOf(this.AAl) });
    ab.i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", new Object[] { this.AAm });
    ((com.tencent.mm.choosemsgfile.compat.a)com.tencent.mm.kernel.g.E(com.tencent.mm.choosemsgfile.compat.a.class)).a(this, paramString, this.AAk, this.AAl, this.AAm, new a.a()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, ArrayList<MsgFile> paramAnonymousArrayList)
      {
        AppMethodBeat.i(35149);
        ab.i("MicroMsg.SelectConversationUI", "resultCode:%d filePaths:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousArrayList });
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(35149);
          return;
          paramAnonymousString = new Intent();
          paramAnonymousString.putParcelableArrayListExtra("FILEPATHS", paramAnonymousArrayList);
          SelectConversationUI.this.setResult(-1, paramAnonymousString);
          SelectConversationUI.this.finish();
          AppMethodBeat.o(35149);
          return;
          paramAnonymousArrayList = new Intent();
          paramAnonymousArrayList.putExtra("ERRMSG", paramAnonymousString);
          SelectConversationUI.this.setResult(1, paramAnonymousArrayList);
          SelectConversationUI.this.finish();
        }
      }
    });
    AppMethodBeat.o(35166);
  }
  
  private String avd(String paramString)
  {
    AppMethodBeat.i(35171);
    aw.aaz();
    ad localad = com.tencent.mm.model.c.YA().aru(paramString);
    String str = getResources().getString(2131296969);
    if (localad == null)
    {
      AppMethodBeat.o(35171);
      return str;
    }
    if (com.tencent.mm.model.t.ku(localad.field_verifyFlag)) {
      paramString = getResources().getString(2131296968);
    }
    for (;;)
    {
      AppMethodBeat.o(35171);
      return paramString;
      if (ad.arf(paramString)) {
        paramString = c(this, localad);
      } else {
        paramString = getResources().getString(2131296969);
      }
    }
  }
  
  private static Bitmap ave(String paramString)
  {
    AppMethodBeat.i(35182);
    localBitmap2 = com.tencent.mm.at.o.ahC().tf(paramString);
    localBitmap1 = localBitmap2;
    if (localBitmap2 != null) {}
    try
    {
      int j = Exif.fromFile(paramString).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap1 = com.tencent.mm.sdk.platformtools.d.b(localBitmap2, i);
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SelectConversationUI", paramString, "unexpected exception.", new Object[0]);
        localBitmap1 = localBitmap2;
      }
    }
    AppMethodBeat.o(35182);
    return localBitmap1;
  }
  
  private static void b(Intent paramIntent, String paramString1, String paramString2)
  {
    AppMethodBeat.i(35169);
    if (paramString1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("cardNameToSend is null", bool);
      paramIntent.putExtra("be_send_card_name", paramString1);
      paramIntent.putExtra("received_card_name", paramString2);
      paramIntent.putExtra("Is_Chatroom", true);
      AppMethodBeat.o(35169);
      return;
    }
  }
  
  private void b(g.a parama)
  {
    AppMethodBeat.i(35178);
    switch (this.msgType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35178);
      return;
      parama.a(new SelectConversationUI.7(this));
      AppMethodBeat.o(35178);
      return;
      parama.a(new c.a.b()
      {
        public final void byw()
        {
          AppMethodBeat.i(35132);
          ab.i("MicroMsg.SelectConversationUI", "[ImageGalleryUI] showImgGallery");
          Intent localIntent = new Intent(SelectConversationUI.this.getContext(), ImageGalleryUI.class);
          localIntent.putExtra("img_gallery_msg_id", SelectConversationUI.i(SelectConversationUI.this));
          localIntent.putExtra("img_gallery_msg_svr_id", SelectConversationUI.j(SelectConversationUI.this).field_msgSvrId);
          localIntent.putExtra("img_gallery_talker", SelectConversationUI.j(SelectConversationUI.this).field_talker);
          localIntent.putExtra("img_gallery_chatroom_name", SelectConversationUI.j(SelectConversationUI.this).field_talker);
          localIntent.putExtra("img_preview_only", true);
          SelectConversationUI.this.startActivity(localIntent);
          com.tencent.mm.ui.base.b.jdMethod_if(SelectConversationUI.this.getContext());
          AppMethodBeat.o(35132);
        }
      });
      AppMethodBeat.o(35178);
      return;
      aw.aaz();
      Object localObject = com.tencent.mm.model.c.YC().Tz(this.cDI);
      parama.a(new SelectConversationUI.9(this, (bi.b)localObject, ((bi.b)localObject).label));
      AppMethodBeat.o(35178);
      return;
      localObject = j.b.mY(bo.apU(this.cDI));
      if (localObject == null)
      {
        AppMethodBeat.o(35178);
        return;
      }
      if ((((j.b)localObject).type == 5) && (!com.tencent.mm.ui.chatting.l.f(this.cEE, this.zUQ)))
      {
        parama.a(new SelectConversationUI.10(this, ((j.b)localObject).url));
        AppMethodBeat.o(35178);
        return;
      }
      if (((j.b)localObject).type == 6)
      {
        parama.a(new SelectConversationUI.11(this));
        AppMethodBeat.o(35178);
        return;
      }
      if (((j.b)localObject).type == 24)
      {
        parama.a(new SelectConversationUI.13(this, (j.b)localObject));
        AppMethodBeat.o(35178);
        return;
      }
      if (((j.b)localObject).type == 19)
      {
        parama.a(new c.a.b()
        {
          public final void byw()
          {
            AppMethodBeat.i(35138);
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.i(SelectConversationUI.this));
            localIntent.putExtra("record_xml", this.iaj.fhc);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.bq.d.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(35138);
          }
        });
        AppMethodBeat.o(35178);
        return;
      }
      if (((j.b)localObject).type == 3)
      {
        parama.a(new SelectConversationUI.15(this, (j.b)localObject));
        AppMethodBeat.o(35178);
        return;
      }
      if (((j.b)localObject).type == 4)
      {
        parama.a(new c.a.b()
        {
          public final void byw() {}
        });
        AppMethodBeat.o(35178);
        return;
        parama.a(new SelectConversationUI.17(this));
        AppMethodBeat.o(35178);
        return;
        k.il(getContext());
        AppMethodBeat.o(35178);
        return;
        parama.a(new SelectConversationUI.18(this));
      }
    }
  }
  
  public static String c(Context paramContext, ad paramad)
  {
    AppMethodBeat.i(35172);
    paramad = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).a(paramad.field_openImAppid, "openim_card_type_name", b.a.gfD);
    if (TextUtils.isEmpty(paramad)) {}
    for (paramContext = paramContext.getResources().getString(2131296969);; paramContext = String.format("[%s]", new Object[] { paramad }))
    {
      AppMethodBeat.o(35172);
      return paramContext;
    }
  }
  
  private String dOm()
  {
    AppMethodBeat.i(35179);
    aw.aaz();
    bi.b localb = com.tencent.mm.model.c.YC().Tz(this.cDI);
    String str = "";
    if (localb != null) {
      str = localb.label;
    }
    str = getContext().getString(2131296989) + str;
    AppMethodBeat.o(35179);
    return str;
  }
  
  private Bitmap dOn()
  {
    AppMethodBeat.i(35180);
    com.tencent.mm.modelvideo.o.alE();
    String str = com.tencent.mm.modelvideo.t.vg(this.cEE.field_imgPath);
    Object localObject = str;
    if (str == null) {
      localObject = this.imagePath;
    }
    localObject = com.tencent.mm.sdk.platformtools.d.aoV((String)localObject);
    AppMethodBeat.o(35180);
    return localObject;
  }
  
  private Bitmap dOo()
  {
    AppMethodBeat.i(35181);
    if (this.cEE == null)
    {
      AppMethodBeat.o(35181);
      return null;
    }
    String str = this.cEE.field_imgPath;
    localBitmap3 = com.tencent.mm.at.o.ahC().tf(str);
    Bitmap localBitmap1 = localBitmap3;
    if (localBitmap3 != null) {}
    try
    {
      int j = Exif.fromFile(str).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap1 = com.tencent.mm.sdk.platformtools.d.b(localBitmap3, i);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SelectConversationUI", localThrowable, "unexpected exception.", new Object[0]);
        Bitmap localBitmap2 = localBitmap3;
      }
    }
    AppMethodBeat.o(35181);
    return localBitmap1;
  }
  
  private void dOp()
  {
    AppMethodBeat.i(35185);
    ab.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 14);
    localIntent.putExtra("titile", getString(2131296502));
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.t.AdZ);
    localIntent.putExtra("already_select_contact", com.tencent.mm.platformtools.ah.d(this.AAg, ","));
    localIntent.putExtra("max_limit_num", 9);
    if ((this.AeW) && (ad.arf(this.AAb))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 5);
      AppMethodBeat.o(35185);
      return;
    }
  }
  
  private void dOq()
  {
    boolean bool = true;
    AppMethodBeat.i(35186);
    ab.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.t.AdW);
    localIntent.putExtra("list_type", 3);
    localIntent.putExtra("be_send_card_name", this.AAb);
    localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
    localIntent.putExtra("Add_SendCard", true);
    localIntent.putExtra("titile", getString(2131296502));
    if ((this.AeW) && (ad.arf(this.AAb))) {}
    for (;;)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 3);
      AppMethodBeat.o(35186);
      return;
      bool = false;
    }
  }
  
  private void dOr()
  {
    AppMethodBeat.i(35187);
    ab.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 5);
    localIntent.putExtra("titile", getString(2131296502));
    if (((this.fromScene != 4) && (this.fromScene != 9)) || ((getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || (this.fromScene == 10)))
    {
      localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
      localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.t.F(new int[] { 32, 16, 1, 2, 4, 16384 }));
    }
    for (;;)
    {
      getContext().startActivityForResult(localIntent, 1);
      AppMethodBeat.o(35187);
      return;
      localIntent.putExtra("list_attr", com.tencent.mm.ui.contact.t.AdY);
    }
  }
  
  private void fG(List<String> paramList)
  {
    AppMethodBeat.i(35195);
    long l = System.currentTimeMillis();
    int i = paramList.size();
    Object localObject2 = z.oS(getString(2131300540));
    Cursor localCursor2 = null;
    Cursor localCursor1 = localCursor2;
    try
    {
      com.tencent.mm.kernel.g.RM();
      localCursor1 = localCursor2;
      localCursor2 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().e(((com.tencent.mm.model.y)localObject2).getType(), "", null);
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
        ((ad)localObject2).convertFrom(localCursor2);
        localCursor1 = localCursor2;
        paramList.add(((aq)localObject2).field_username);
        localCursor1 = localCursor2;
        localCursor2.moveToNext();
      }
      if (localObject1 == null) {
        break label234;
      }
    }
    finally
    {
      if (localCursor1 != null) {
        localCursor1.close();
      }
      ab.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(paramList.size() - i) });
      AppMethodBeat.o(35195);
    }
    localObject1.close();
    label234:
    ab.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(paramList.size() - i) });
    AppMethodBeat.o(35195);
  }
  
  private static String i(j.b paramb)
  {
    AppMethodBeat.i(35184);
    Object localObject = new oa();
    ((oa)localObject).cEz.type = 0;
    ((oa)localObject).cEz.cEB = paramb.fhc;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    localObject = bo.bf(((oa)localObject).cEA.cEK.desc, paramb.description);
    paramb = (j.b)localObject;
    if (!com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject)) {
      paramb = ((String)localObject).replaceAll("\n", " ");
    }
    AppMethodBeat.o(35184);
    return paramb;
  }
  
  private void o(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(35194);
    Intent localIntent = paramIntent;
    if (this.msgType == 5)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("emoji_thumb_path", this.lsX);
      localIntent.putExtra("emoji_activity_id", getIntent().getStringExtra("emoji_activity_id"));
    }
    super.setResult(paramInt, localIntent);
    AppMethodBeat.o(35194);
  }
  
  private boolean rw(boolean paramBoolean)
  {
    AppMethodBeat.i(35192);
    if (paramBoolean)
    {
      if (this.AAg.size() < 9) {}
    }
    else {
      while (this.AAg.size() > 9)
      {
        String str = getString(2131303052, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9)) });
        com.tencent.mm.ui.base.h.a(getContext(), str, getString(2131297056), new SelectConversationUI.24(this));
        AppMethodBeat.o(35192);
        return true;
      }
    }
    AppMethodBeat.o(35192);
    return false;
  }
  
  private void t(final Intent paramIntent, final String paramString)
  {
    AppMethodBeat.i(35174);
    if (ava(paramString))
    {
      AppMethodBeat.o(35174);
      return;
    }
    if (com.tencent.mm.ui.contact.t.hI(this.gpS, 256))
    {
      o(-1, paramIntent);
      finish();
      AppMethodBeat.o(35174);
      return;
    }
    if (com.tencent.mm.platformtools.ah.isNullOrNil(paramString))
    {
      ab.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
      AppMethodBeat.o(35174);
      return;
    }
    if (com.tencent.mm.model.t.lA(paramString))
    {
      int i = com.tencent.mm.model.n.nv(paramString);
      if (this.AAa)
      {
        int j = com.tencent.mm.platformtools.ah.getInt(com.tencent.mm.m.g.Nq().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50);
        if (i > j)
        {
          ab.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          com.tencent.mm.ui.base.h.b(this, getString(2131303051, new Object[] { Integer.valueOf(j) }), "", true);
          AppMethodBeat.o(35174);
          return;
        }
      }
      getString(2131303049, new Object[] { Integer.valueOf(i) });
    }
    g.a locala = new g.a(getContext());
    locala.cq(paramString);
    if (this.AeW)
    {
      a(locala, this.AAb);
      if (com.tencent.mm.model.t.lA(paramString))
      {
        b(paramIntent, this.AAb, paramString);
        locala.i(Boolean.TRUE);
      }
    }
    for (;;)
    {
      
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(35151);
          SelectConversationUI.this.hideVKB();
          boolean bool = paramIntent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
          if (bool) {
            if (!paramAnonymousBoolean) {
              break label136;
            }
          }
          label136:
          for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
          {
            ab.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", new Object[] { Integer.valueOf(13943), Integer.valueOf(paramAnonymousInt) });
            com.tencent.mm.plugin.report.service.h.qsU.e(13943, new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (!paramAnonymousBoolean) {
              break;
            }
            paramIntent.putExtra("custom_send_text", paramAnonymousString);
            SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
            com.tencent.mm.pluginsdk.ui.tools.l.hY(SelectConversationUI.h(SelectConversationUI.this), paramString);
            SelectConversationUI.this.finish();
            AppMethodBeat.o(35151);
            return;
          }
          if (bool)
          {
            paramAnonymousString = paramIntent.getStringExtra("Select_Contact");
            aw.aaz();
            com.tencent.mm.model.c.YF().arF(paramAnonymousString);
          }
          AppMethodBeat.o(35151);
        }
      }.show();
      AppMethodBeat.o(35174);
      return;
      a(paramIntent, this.AAb, paramString);
      break;
      Object localObject1;
      if (this.AzT)
      {
        if (this.cpM != -1L)
        {
          b(locala);
          localObject1 = new gg();
          ((gg)localObject1).cuS.cpM = this.cpM;
          ((gg)localObject1).cuS.cuT = locala;
          ((gg)localObject1).cuS.cuU = this.AAj;
          ((gg)localObject1).cuS.cnh = getContext();
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        for (;;)
        {
          locala.i(Boolean.TRUE);
          break;
          if ((this.msgType == 17) && (this.AzZ != 0))
          {
            localObject1 = getContext().getString(2131302652, new Object[] { Integer.valueOf(this.AzZ) });
            locala.amm(getResources().getString(2131297000) + (String)localObject1);
          }
        }
      }
      String str;
      if (this.AzU)
      {
        Object localObject2 = (HashMap)getIntent().getSerializableExtra("webview_params");
        localObject1 = (String)((HashMap)localObject2).get("img_url");
        str = (String)((HashMap)localObject2).get("title");
        localObject2 = (String)((HashMap)localObject2).get("url");
        locala.amm(getResources().getString(2131297097) + str);
        locala.a(new c.a.b()
        {
          public final void byw()
          {
            AppMethodBeat.i(35150);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", this.val$url);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.bq.d.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(35150);
          }
        });
        locala.amn((String)localObject1).dnz();
        locala.i(Boolean.TRUE);
      }
      else
      {
        if ((this.AzV) && (a(paramIntent, locala)))
        {
          AppMethodBeat.o(35174);
          return;
        }
        if (this.AzX)
        {
          str = getResources().getString(2131296973);
          localObject1 = str;
          if (this.kmS != null) {
            localObject1 = str + this.kmS;
          }
          locala.amm((String)localObject1);
          locala.i(Boolean.FALSE);
        }
        else
        {
          a(locala);
          b(locala);
          locala.i(Boolean.TRUE);
        }
      }
    }
  }
  
  public final void Kc()
  {
    AppMethodBeat.i(35155);
    super.Kc();
    this.AzS = getIntent().getBooleanExtra("select_is_ret", false);
    this.fromScene = getIntent().getIntExtra("scene_from", 0);
    ab.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    if (this.fromScene == 1) {
      this.AzT = true;
    }
    for (;;)
    {
      this.AzY = getIntent().getBooleanExtra("send_to_biz", false);
      this.zUQ = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.cpM = getIntent().getLongExtra("select_fav_local_id", -1L);
      this.AzZ = getIntent().getIntExtra("select_fav_select_count", 0);
      this.AAe = getIntent().getBooleanExtra("mutil_select_is_ret", false);
      this.AeW = getIntent().getBooleanExtra("Select_Send_Card", false);
      this.AAa = getIntent().getBooleanExtra("Retr_Big_File", false);
      if (this.AeW) {
        this.AAb = getIntent().getStringExtra("Select_Talker_Name");
      }
      this.gpS = getIntent().getIntExtra("Select_Conv_Type", AzQ);
      this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
      this.cpO = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      aw.aaz();
      this.cEE = com.tencent.mm.model.c.YC().kB(this.cpO);
      this.imagePath = getIntent().getStringExtra("image_path");
      this.AAi = getIntent().getStringExtra("ad_video_title");
      this.kmS = getIntent().getStringExtra("desc_title");
      this.lsX = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.cDI = getIntent().getStringExtra("Retr_Msg_content");
      this.AAj = getIntent().getStringExtra("Retr_fav_xml_str");
      if ((this.cDI == null) && (this.cEE != null)) {
        this.cDI = this.cEE.field_content;
      }
      this.AAh = ((ReportUtil.ReportArgs)getIntent().getParcelableExtra("Select_Report_Args"));
      this.AAk = getIntent().getStringExtra("KChooseMsgFileType");
      this.AAl = getIntent().getIntExtra("KChooseMsgFileCount", 9);
      this.AAm = getIntent().getStringExtra("KChooseMsgFileExtension");
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(com.tencent.mm.ui.contact.t.dMg());
      Object localObject = getIntent().getStringExtra("Select_block_List");
      if (!com.tencent.mm.platformtools.ah.isNullOrNil((String)localObject)) {
        localHashSet.addAll(com.tencent.mm.platformtools.ah.h(((String)localObject).split(",")));
      }
      if (com.tencent.mm.ui.contact.t.hI(this.gpS, 2))
      {
        localObject = com.tencent.mm.ui.contact.t.dMh();
        com.tencent.mm.ui.contact.t.i((HashSet)localObject);
        localHashSet.addAll((Collection)localObject);
      }
      this.ejc = new ArrayList();
      this.ejc.addAll(localHashSet);
      fG(this.ejc);
      if (com.tencent.mm.ui.contact.t.hI(this.gpS, 1)) {
        this.AdB = true;
      }
      if (this.AAe)
      {
        this.AAg = new LinkedList();
        if (this.AAe)
        {
          addTextOptionMenu(1, getString(2131297002), this.AAn, null, q.b.zby);
          Km();
        }
      }
      AppMethodBeat.o(35155);
      return;
      if ((this.fromScene == 2) || (this.fromScene == 10)) {
        this.AzU = true;
      } else if (this.fromScene == 3) {
        this.AzV = true;
      } else if (this.fromScene == 6) {
        this.AzW = true;
      } else if (this.fromScene == 7) {
        this.AzX = true;
      } else if (this.fromScene == 11) {
        overridePendingTransition(2131034230, 2131034228);
      }
    }
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(35158);
    super.a(paramListView, paramInt);
    if (this.fromScene == 11)
    {
      AppMethodBeat.o(35158);
      return;
    }
    if (this.zun == null)
    {
      if (!this.AeW) {
        break label134;
      }
      this.AzR = 2131303068;
    }
    for (;;)
    {
      Object localObject = new SelectConversationUI.12(this);
      String str = getString(this.AzR);
      View localView = w.hM(this).inflate(2130969849, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131823022);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.zun = ((TextView)localObject);
      this.zun.setVisibility(paramInt);
      AppMethodBeat.o(35158);
      return;
      label134:
      if (this.fromScene == 10) {
        this.AzR = 2131302023;
      } else {
        this.AzR = 2131303056;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(35189);
    if ((parama.Adl) && (parama.contact != null))
    {
      boolean bool = this.AAg.contains(parama.contact.field_username);
      AppMethodBeat.o(35189);
      return bool;
    }
    AppMethodBeat.o(35189);
    return false;
  }
  
  public final boolean apa()
  {
    return false;
  }
  
  public final boolean apb()
  {
    return false;
  }
  
  public final String apc()
  {
    AppMethodBeat.i(35188);
    String str = getIntent().getStringExtra("Select_Conv_ui_title");
    if ((str == null) || (str.length() <= 0))
    {
      str = getString(2131303059);
      AppMethodBeat.o(35188);
      return str;
    }
    AppMethodBeat.o(35188);
    return str;
  }
  
  public final p apd()
  {
    AppMethodBeat.i(35156);
    com.tencent.mm.ui.contact.y localy = new com.tencent.mm.ui.contact.y(this, this.ejc, this.AdB, this.AAf, this.AzY, this.gpS);
    AppMethodBeat.o(35156);
    return localy;
  }
  
  public final com.tencent.mm.ui.contact.n ape()
  {
    AppMethodBeat.i(35157);
    r localr = new r(this, this.ejc, this.AAf, this.scene);
    AppMethodBeat.o(35157);
    return localr;
  }
  
  public final boolean ava(String paramString)
  {
    AppMethodBeat.i(35164);
    if (!auZ(paramString))
    {
      AppMethodBeat.o(35164);
      return false;
    }
    if ((!com.tencent.mm.platformtools.ah.isNullOrNil(getIntent().getStringExtra("Select_App_Id"))) && (this.AeW))
    {
      AppMethodBeat.o(35164);
      return false;
    }
    if (this.AeW)
    {
      aw.aaz();
      if (ad.Nt(com.tencent.mm.model.c.YA().aru(this.AAb).field_verifyFlag))
      {
        avb(paramString);
        AppMethodBeat.o(35164);
        return true;
      }
    }
    switch (this.msgType)
    {
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(35164);
      return false;
    case 5: 
      AppMethodBeat.o(35164);
      return false;
    }
    aw.aaz();
    String str = com.tencent.mm.model.c.YC().Ty(this.cDI).tac;
    aw.aaz();
    if (com.tencent.mm.model.t.ku(com.tencent.mm.model.c.YA().aru(str).field_verifyFlag))
    {
      avb(paramString);
      AppMethodBeat.o(35164);
      return true;
    }
    AppMethodBeat.o(35164);
    return false;
  }
  
  public final int[] bOp()
  {
    AppMethodBeat.i(35193);
    int[] arrayOfInt = getIntent().getIntArrayExtra("search_range");
    if ((this.fromScene == 4) || (this.fromScene == 10))
    {
      AppMethodBeat.o(35193);
      return new int[] { 131072 };
    }
    if (arrayOfInt != null)
    {
      AppMethodBeat.o(35193);
      return arrayOfInt;
    }
    arrayOfInt = super.bOp();
    AppMethodBeat.o(35193);
    return arrayOfInt;
  }
  
  public final void bOq()
  {
    AppMethodBeat.i(35159);
    if (this.fromScene == 5) {
      com.tencent.mm.ui.base.h.a(this, getString(2131301304), null, getString(2131303103), getString(2131297837), true, new SelectConversationUI.23(this), new SelectConversationUI.25(this));
    }
    for (;;)
    {
      if (this.AAh != null)
      {
        this.AAh.errCode = 0;
        ReportUtil.a(this, this.AAh, true);
      }
      AppMethodBeat.o(35159);
      return;
      super.bOq();
      hideVKB();
    }
  }
  
  public final boolean dMa()
  {
    return true;
  }
  
  public final void mL(int paramInt)
  {
    AppMethodBeat.i(35161);
    int i;
    Object localObject2;
    if (this.AAf)
    {
      i = paramInt - getContentLV().getHeaderViewsCount();
      if (i < 0)
      {
        ab.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
        dOp();
        AppMethodBeat.o(35161);
        return;
      }
      localObject1 = dLW();
      localObject2 = ((com.tencent.mm.ui.contact.o)localObject1).Qt(i);
      if (localObject2 == null)
      {
        AppMethodBeat.o(35161);
        return;
      }
      if (((com.tencent.mm.ui.contact.a.a)localObject2).contact == null)
      {
        AppMethodBeat.o(35161);
        return;
      }
      localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject2).contact.field_username;
      ab.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[] { localObject2 });
      if ((!this.AAg.contains(localObject2)) && (rw(true)))
      {
        dMc();
        AppMethodBeat.o(35161);
        return;
      }
      dMc();
      this.oCs.ama((String)localObject2);
      if (this.AAg.contains(localObject2)) {
        this.AAg.remove(localObject2);
      }
      for (;;)
      {
        Km();
        ((com.tencent.mm.ui.contact.o)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(35161);
        return;
        this.AAg.add(localObject2);
      }
    }
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ab.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      if (this.AeW)
      {
        dOq();
        AppMethodBeat.o(35161);
        return;
      }
      dOr();
      AppMethodBeat.o(35161);
      return;
    }
    Object localObject1 = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (localObject1 == null)
    {
      AppMethodBeat.o(35161);
      return;
    }
    if (((localObject1 instanceof com.tencent.mm.ui.contact.a.b)) && (((com.tencent.mm.ui.contact.a.b)localObject1).blZ == getResources().getString(2131296487)))
    {
      ab.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("list_attr", 16384);
      com.tencent.mm.bq.d.b(this, "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject1, 4);
      this.AzU = true;
      AppMethodBeat.o(35161);
      return;
    }
    Object localObject3;
    if ((localObject1 instanceof com.tencent.mm.ui.contact.a.g))
    {
      localObject3 = (com.tencent.mm.ui.contact.a.g)localObject1;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("scene", this.scene);
      localObject2 = new ArrayList();
      localObject3 = ((com.tencent.mm.ui.contact.a.a)localObject3).mRX.mSy;
      i = localObject3.length;
      paramInt = 0;
      while (paramInt < i)
      {
        ((ArrayList)localObject2).add(localObject3[paramInt]);
        paramInt += 1;
      }
      ((Intent)localObject1).putExtra("query_phrase_list", (Serializable)localObject2);
      com.tencent.mm.bq.d.b(this, ".ui.transmit.MMCreateChatroomUI", (Intent)localObject1, 1);
      AppMethodBeat.o(35161);
      return;
    }
    localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact;
    if (localObject1 == null)
    {
      AppMethodBeat.o(35161);
      return;
    }
    localObject1 = ((aq)localObject1).field_username;
    ab.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[] { localObject1 });
    if (!ava((String)localObject1))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Select_Conv_User", (String)localObject1);
      localObject3 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
      if (localObject3 == null) {
        break label599;
      }
      a((Intent)localObject2, (Intent)localObject3);
    }
    for (;;)
    {
      hideVKB();
      AppMethodBeat.o(35161);
      return;
      label599:
      if ((this.AzS) || (this.AeW) || (this.AzT) || (this.AzU) || (this.AzV))
      {
        t((Intent)localObject2, (String)localObject1);
      }
      else if (this.fromScene == 11)
      {
        avc((String)localObject1);
      }
      else
      {
        o(-1, (Intent)localObject2);
        finish();
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35162);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ab.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    Object localObject1;
    Object localObject2;
    while (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        ab.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
        localObject2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject2 != null)
        {
          if (ava((String)localObject1))
          {
            AppMethodBeat.o(35162);
            return;
            ab.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
          }
          else
          {
            a(paramIntent, (Intent)localObject2);
            AppMethodBeat.o(35162);
          }
        }
        else
        {
          if ((this.AzS) || (this.AeW) || (this.AzT) || (this.AzU) || (this.AzV))
          {
            t(paramIntent, (String)localObject1);
            AppMethodBeat.o(35162);
            return;
          }
          if (this.fromScene == 11)
          {
            avc((String)localObject1);
            AppMethodBeat.o(35162);
            return;
          }
          o(-1, paramIntent);
          finish();
        }
      }
      else
      {
        AppMethodBeat.o(35162);
        return;
      }
    }
    if (paramInt1 == 2)
    {
      switch (paramInt2)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(35162);
        return;
        finish();
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("Select_stay_in_wx", false)))
        {
          paramIntent = new Intent(this, TaskRedirectUI.class);
          paramIntent.addFlags(268435456);
          startActivity(paramIntent);
          ReportUtil.G(false, 0);
          AppMethodBeat.o(35162);
          return;
          if (paramIntent != null) {
            this.AAh = ((ReportUtil.ReportArgs)paramIntent.getParcelableExtra("Select_Report_Args"));
          }
        }
      }
    }
    if (paramInt1 == 3)
    {
      switch (paramInt2)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(35162);
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("received_card_name");
          if ((!bo.isNullOrNil(paramIntent)) && (!ava(paramIntent)))
          {
            localObject1 = new g.a(getContext());
            ((g.a)localObject1).cq(paramIntent);
            a((g.a)localObject1, this.AAb);
            ((g.a)localObject1).i(Boolean.TRUE).LU(2131297067).a(new SelectConversationUI.26(this, paramIntent)).gwf.show();
          }
        }
      }
    }
    if (paramInt1 == 4)
    {
      if ((paramInt2 == -1) && (paramIntent != null)) {
        t(paramIntent, paramIntent.getStringExtra("Select_Contact"));
      }
      AppMethodBeat.o(35162);
      return;
    }
    if (paramInt1 == 5)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        localObject1 = this.AAg.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.oCs.amb((String)localObject2);
        }
        if (!com.tencent.mm.platformtools.ah.isNullOrNil(paramIntent)) {
          this.AAg = com.tencent.mm.platformtools.ah.h(paramIntent.split(","));
        }
        for (;;)
        {
          paramIntent = this.AAg.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.oCs.amc((String)localObject1);
          }
          this.AAg.clear();
        }
        Km();
        dLW().notifyDataSetChanged();
      }
      AppMethodBeat.o(35162);
      return;
    }
    ab.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(35162);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(35160);
    super.bOq();
    AppMethodBeat.o(35160);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(35154);
    f.m(this);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Select_App_Id");
    String str = getIntent().getStringExtra("Select_Open_Id");
    ab.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + paramBundle + ", openId = " + str);
    if ((!com.tencent.mm.platformtools.ah.isNullOrNil(paramBundle)) && (!com.tencent.mm.platformtools.ah.isNullOrNil(str))) {
      new com.tencent.mm.plugin.base.stub.d(this, paramBundle, str, new SelectConversationUI.1(this)).aVE();
    }
    f.n(this);
    AppMethodBeat.o(35154);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(154013);
    super.onDestroy();
    removeAllOptionMenu();
    AppMethodBeat.o(154013);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wK(String paramString)
  {
    AppMethodBeat.i(35190);
    this.AAg.remove(paramString);
    dLW().notifyDataSetChanged();
    Km();
    AppMethodBeat.o(35190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI
 * JD-Core Version:    0.7.0.1
 */