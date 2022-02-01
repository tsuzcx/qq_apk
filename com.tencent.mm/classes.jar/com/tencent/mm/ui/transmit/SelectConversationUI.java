package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
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
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.a;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.qi;
import com.tencent.mm.g.a.qi.a;
import com.tencent.mm.g.a.qi.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.r;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.plugin.appbrand.y.n;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bv.b;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.chatting.m;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.ab;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.a.d.a.b;
import com.tencent.mm.ui.z;
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
  private static final int Lkb;
  private TextView JQP;
  private boolean KJB;
  private boolean KLF;
  private int KzP;
  private int LkA;
  private boolean LkB;
  private MenuItem.OnMenuItemClickListener LkC;
  private MenuItem.OnMenuItemClickListener LkD;
  private int Lkc;
  private boolean Lkd;
  private boolean Lke;
  private boolean Lkf;
  private boolean Lkg;
  private boolean Lkh;
  private boolean Lki;
  boolean Lkj;
  private boolean Lkk;
  private int Lkl;
  private boolean Lkm;
  private boolean Lkn;
  private String Lko;
  private String Lkp;
  private Boolean Lkq;
  private boolean Lkr;
  private boolean Lks;
  private List<String> Lkt;
  private ReportUtil.ReportArgs Lku;
  private String Lkv;
  private String Lkw;
  private String Lkx;
  private int Lky;
  private String Lkz;
  private bv dCi;
  private String dEU;
  private long doH;
  private String dtQ;
  private String emojiMD5;
  private List<String> fUR;
  private int fromScene;
  private int iYs;
  private String imagePath;
  private long msgId;
  private int msgType;
  private String oEU;
  boolean rKS;
  private int[] rNC;
  
  static
  {
    AppMethodBeat.i(39409);
    Lkb = u.J(new int[] { 1, 2 });
    AppMethodBeat.o(39409);
  }
  
  public SelectConversationUI()
  {
    AppMethodBeat.i(39354);
    this.Lkd = false;
    this.Lke = false;
    this.Lkf = false;
    this.Lkg = false;
    this.Lkh = false;
    this.Lki = false;
    this.rKS = false;
    this.Lkj = false;
    this.fromScene = 0;
    this.Lkk = false;
    this.KLF = false;
    this.Lkm = false;
    this.Lkn = false;
    this.KzP = -1;
    this.Lkq = Boolean.FALSE;
    this.Lkr = false;
    this.Lks = false;
    this.Lkt = null;
    this.imagePath = null;
    this.Lkv = null;
    this.oEU = null;
    this.LkA = 0;
    this.LkB = false;
    this.rNC = new int[] { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
    this.LkC = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(188225);
        paramAnonymousMenuItem = SelectConversationUI.this;
        boolean bool;
        if (!SelectConversationUI.a(SelectConversationUI.this))
        {
          bool = true;
          SelectConversationUI.b(paramAnonymousMenuItem, bool);
          SelectConversationUI.this.fMv().yA(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.this.KJn.yA(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.n(SelectConversationUI.this);
          paramAnonymousMenuItem = SelectConversationUI.p(SelectConversationUI.this);
          if (SelectConversationUI.a(SelectConversationUI.this)) {
            break label112;
          }
        }
        label112:
        for (int i = SelectConversationUI.o(SelectConversationUI.this);; i = 2131763014)
        {
          paramAnonymousMenuItem.setText(i);
          AppMethodBeat.o(188225);
          return true;
          bool = false;
          break;
        }
      }
    };
    this.LkD = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(188226);
        if (SelectConversationUI.q(SelectConversationUI.this))
        {
          AppMethodBeat.o(188226);
          return false;
        }
        paramAnonymousMenuItem = SelectConversationUI.r(SelectConversationUI.this).iterator();
        while (paramAnonymousMenuItem.hasNext())
        {
          localObject = (String)paramAnonymousMenuItem.next();
          if (SelectConversationUI.this.aYV((String)localObject))
          {
            AppMethodBeat.o(188226);
            return false;
          }
        }
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Conv_User", bu.m(SelectConversationUI.r(SelectConversationUI.this), ","));
        Object localObject = (Intent)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject != null) {
          SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem, (Intent)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(188226);
          return true;
          if (SelectConversationUI.s(SelectConversationUI.this))
          {
            SelectConversationUI.a(SelectConversationUI.this, -1, paramAnonymousMenuItem);
            SelectConversationUI.this.finish();
          }
          else
          {
            SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem);
          }
        }
      }
    };
    AppMethodBeat.o(39354);
  }
  
  private void Zv()
  {
    AppMethodBeat.i(39393);
    if (!this.Lkr)
    {
      AppMethodBeat.o(39393);
      return;
    }
    if ((this.Lkt != null) && (this.Lkt.size() > 0))
    {
      updateOptionMenuText(1, fPp() + "(" + this.Lkt.size() + ")");
      updateOptionMenuListener(1, this.LkD, null);
      enableOptionMenu(1, true);
      AppMethodBeat.o(39393);
      return;
    }
    if (!this.Lks)
    {
      updateOptionMenuText(1, getString(2131755819));
      updateOptionMenuListener(1, this.LkC, null);
      enableOptionMenu(1, true);
      if (this.vUs != null) {
        this.vUs.setVisibility(8);
      }
      fMx();
      AppMethodBeat.o(39393);
      return;
    }
    updateOptionMenuText(1, getString(2131755897));
    updateOptionMenuListener(1, this.LkC, null);
    enableOptionMenu(1, true);
    if (this.vUs != null) {
      this.vUs.setVisibility(0);
    }
    fMy();
    AppMethodBeat.o(39393);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39384);
    Object localObject = null;
    float f = paramInt2 / paramInt1;
    int k = 0;
    int j = 0;
    int m = aq.ay(paramContext, 2131165260);
    paramInt1 = aq.ay(paramContext, 2131165259);
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
      AppMethodBeat.o(39384);
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
  
  private View a(com.tencent.mm.plugin.i.a.b paramb)
  {
    AppMethodBeat.i(163387);
    Object localObject1 = new com.tencent.mm.loader.c.e.a();
    ((com.tencent.mm.loader.c.e.a)localObject1).hgP = true;
    ((com.tencent.mm.loader.c.e.a)localObject1).hgO = true;
    ((com.tencent.mm.loader.c.e.a)localObject1).hhb = true;
    Object localObject2 = ((com.tencent.mm.loader.c.e.a)localObject1).aru();
    localObject1 = View.inflate(this, 2131495425, null);
    View localView = ((View)localObject1).findViewById(2131299997);
    Object localObject3 = (ImageView)localView.findViewById(2131299971);
    Object localObject4 = com.tencent.mm.loader.e.hfa;
    com.tencent.mm.loader.e.aqU().a(bu.nullAsNil(paramb.ipW.ssR), (ImageView)localObject3, (com.tencent.mm.loader.c.e)localObject2);
    localObject2 = (TextView)localView.findViewById(2131300017);
    ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.ipW.nickname));
    al.a(((TextView)localObject2).getPaint(), 0.8F);
    localObject4 = (ImageView)localView.findViewById(2131300076);
    localObject2 = (ImageView)localView.findViewById(2131300006);
    localObject3 = (TextView)localView.findViewById(2131299988);
    if (paramb.ipW.GIy == 1)
    {
      ((ImageView)localObject4).setVisibility(8);
      localObject4 = (TextView)localView.findViewById(2131300075);
      ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.ipW.desc));
      ((TextView)localObject4).setVisibility(0);
      ((TextView)localObject3).setVisibility(8);
      label223:
      if ((paramb.ipW.GIy != 4) && (paramb.ipW.GIy != 6)) {
        break label368;
      }
      ((ImageView)localObject2).setImageResource(2131232379);
    }
    for (;;)
    {
      ((ImageView)localObject2).setVisibility(8);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      AppMethodBeat.o(163387);
      return localObject1;
      if (paramb.ipW.mediaList.size() > 0) {
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).loadImage(((arx)paramb.ipW.mediaList.get(0)).thumbUrl, (ImageView)localObject4);
      }
      if (bu.isNullOrNil(paramb.ipW.desc)) {
        break;
      }
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.ipW.desc));
      break label223;
      label368:
      if ((paramb.ipW.GIy == 2) && (paramb.ipW.mediaList.size() > 1)) {
        ((ImageView)localObject2).setImageResource(2131232357);
      }
    }
  }
  
  private void a(final Intent paramIntent, o.a parama, final HashMap<String, Object> paramHashMap, boolean paramBoolean, String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(180098);
    String str1 = ck.c(paramHashMap.get("app_id"), null);
    int i = ck.getInt(paramHashMap.get("pkg_type"), 0);
    int j = ck.getInt(paramHashMap.get("pkg_version"), 0);
    String str2 = ck.c(paramHashMap.get("cache_key"), null);
    String str3 = ck.c(paramHashMap.get("path"), null);
    String str4 = ck.c(paramHashMap.get("delay_load_img_path"), null);
    Object localObject2 = ck.c(paramHashMap.get("nickname"), "");
    boolean bool2 = ck.bW(paramHashMap.get("is_dynamic"));
    int k = ck.getInt(paramHashMap.get("subType"), 0);
    int m = ck.getInt(paramHashMap.get("biz"), k.a.hCx.ordinal());
    String str5;
    Object localObject1;
    if (k.a.isValid(m))
    {
      str5 = ck.c(paramHashMap.get("tail_lang"), "");
      String str6 = ck.c(paramHashMap.get("icon_url"), "");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_biz", m);
      ((Bundle)localObject1).putString("key_footer_text_default", (String)localObject2);
      ((Bundle)localObject1).putString("key_footer_text", k.a.b(m, str5, getContext()));
      ((Bundle)localObject1).putString("key_footer_icon", str6);
      ae.d("MicroMsg.SelectConversationUI", "defaultFooterTxt: %s, tailLang: %s.", new Object[] { localObject2, str5 });
      localObject2 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class);
      if (paramString3 != null) {
        break label745;
      }
    }
    label745:
    for (boolean bool1 = false;; bool1 = x.Aa(paramString3))
    {
      paramString3 = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool1, new k.c()
      {
        public final void aDY()
        {
          AppMethodBeat.i(188211);
          paramIntent.putExtra("KShowTodoIntroduceView", 1);
          e.a(SelectConversationUI.this, null);
          AppMethodBeat.o(188211);
        }
        
        public final void eB(boolean paramAnonymousBoolean) {}
      });
      localObject1 = n.cH(this);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("app_id", str1);
      ((Bundle)localObject2).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      ((Bundle)localObject2).putInt("msg_pkg_type", i);
      ((Bundle)localObject2).putInt("pkg_version", j);
      ((Bundle)localObject2).putString("image_url", paramString1);
      ((Bundle)localObject2).putBoolean("is_dynamic_page", bool2);
      ((Bundle)localObject2).putString("title", paramString2);
      ((Bundle)localObject2).putString("cache_key", str2);
      ((Bundle)localObject2).putString("msg_path", str3);
      ((Bundle)localObject2).putString("delay_load_img_path", str4);
      ((Bundle)localObject2).putInt("sub_type", k);
      if (paramBoolean)
      {
        paramString1 = ck.c(paramHashMap.get("video_path"), "");
        paramHashMap = ck.c(paramHashMap.get("video_thumb_path"), "");
        ((Bundle)localObject2).putBoolean("is_video", true);
        ((Bundle)localObject2).putString("video_path", paramString1);
        ((Bundle)localObject2).putString("video_thumb_path", paramHashMap);
      }
      paramHashMap = new f(this);
      paramHashMap.Llw = new f.a()
      {
        public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(188212);
          paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
          if (paramAnonymousBoolean1)
          {
            paramIntent.putExtra("custom_send_text", paramAnonymousString);
            SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
            SelectConversationUI.this.finish();
          }
          for (;;)
          {
            ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.kke, paramString3);
            AppMethodBeat.o(188212);
            return;
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            SelectConversationUI.this.finish();
          }
        }
      };
      ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a((String)localObject1, paramString3, (Bundle)localObject2, new com.tencent.mm.modelappbrand.k.b()
      {
        public final void oP(int paramAnonymousInt)
        {
          AppMethodBeat.i(188213);
          ae.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramHashMap.fPC();
          AppMethodBeat.o(188213);
        }
      });
      parama.fS(paramString3);
      parama.l(Boolean.TRUE);
      parama.fgq();
      parama.ngd = new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(188214);
          ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.kke, paramString3);
          AppMethodBeat.o(188214);
        }
      };
      parama.Foq = fPp();
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(188215);
          SelectConversationUI.this.hideVKB();
          Object localObject = paramString3.getTag(2131296837);
          f localf = paramHashMap;
          if (localObject == null) {}
          for (boolean bool = false;; bool = ((Boolean)localObject).booleanValue())
          {
            localf.a(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt, bool);
            AppMethodBeat.o(188215);
            return;
          }
        }
      }.show();
      AppMethodBeat.o(180098);
      return;
      if (paramBoolean)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("is_video", true);
        localObject2 = ck.c(paramHashMap.get("footer_icon"), "");
        str5 = ck.c(paramHashMap.get("footer_text"), "");
        ((Bundle)localObject1).putString("key_footer_icon", (String)localObject2);
        ((Bundle)localObject1).putString("key_footer_text", str5);
        break;
      }
      ae.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(m) });
      localObject1 = null;
      break;
    }
  }
  
  private static void a(Intent paramIntent, String paramString1, String paramString2)
  {
    AppMethodBeat.i(39368);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString2);
    a(paramIntent, paramString1, localLinkedList);
    AppMethodBeat.o(39368);
  }
  
  private static void a(Intent paramIntent, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(39369);
    if (paramList.size() > 0)
    {
      paramIntent.putExtra("be_send_card_name", paramString);
      paramIntent.putExtra("received_card_name", bu.m(paramList, ","));
      paramIntent.putExtra("Is_Chatroom", false);
    }
    AppMethodBeat.o(39369);
  }
  
  private void a(o.a parama)
  {
    AppMethodBeat.i(39378);
    switch (this.msgType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39378);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(39338);
          Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", SelectConversationUI.j(SelectConversationUI.this));
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.kk(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39338);
        }
      });
      AppMethodBeat.o(39378);
      return;
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(39339);
          ae.i("MicroMsg.SelectConversationUI", "[ImageGalleryUI] showImgGallery");
          Object localObject = new Intent(SelectConversationUI.this.getContext(), ImageGalleryUI.class);
          ((Intent)localObject).putExtra("img_gallery_msg_id", SelectConversationUI.l(SelectConversationUI.this));
          ((Intent)localObject).putExtra("img_gallery_msg_svr_id", SelectConversationUI.m(SelectConversationUI.this).field_msgSvrId);
          ((Intent)localObject).putExtra("img_gallery_talker", SelectConversationUI.m(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_gallery_chatroom_name", SelectConversationUI.m(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_preview_only", true);
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.kk(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39339);
        }
      });
      AppMethodBeat.o(39378);
      return;
      bc.aCg();
      if (com.tencent.mm.model.c.azI() == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      bc.aCg();
      Object localObject = com.tencent.mm.model.c.azI().arq(this.dEU);
      parama.a(new d.a.b()
      {
        public final void cza()
        {
          AppMethodBeat.i(180090);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          localIntent.putExtra("kwebmap_slat", this.LkK.vlC);
          localIntent.putExtra("kwebmap_lng", this.LkK.vlD);
          localIntent.putExtra("Kwebmap_locaion", this.LkL);
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.br.d.b(SelectConversationUI.this.getContext(), "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(180090);
        }
      });
      AppMethodBeat.o(39378);
      return;
      localObject = com.tencent.mm.ah.k.b.zb(bu.aSA(this.dEU));
      if (localObject == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      if (((((com.tencent.mm.ah.k.b)localObject).type == 5) && (!m.f(this.dCi, this.KzP))) || (((com.tencent.mm.ah.k.b)localObject).type == 69))
      {
        parama.a(new d.a.b()
        {
          public final void cza()
          {
            AppMethodBeat.i(39340);
            if (bu.isNullOrNil(this.val$url))
            {
              AppMethodBeat.o(39340);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", this.val$url);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.br.d.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(39340);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ah.k.b)localObject).type == 6)
      {
        parama.a(new d.a.b()
        {
          public final void cza()
          {
            AppMethodBeat.i(39341);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.l(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/transmit/SelectConversationUI$26", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$26", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(39341);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ah.k.b)localObject).type == 24)
      {
        parama.a(new d.a.b()
        {
          public final void cza()
          {
            AppMethodBeat.i(39342);
            oi localoi = new oi();
            localoi.dDm.context = SelectConversationUI.this.getContext();
            localoi.dDm.msgId = SelectConversationUI.l(SelectConversationUI.this);
            localoi.dDm.dDn = this.lmz.hDg;
            localoi.dDm.dCy = false;
            localoi.dDm.scene = 7;
            com.tencent.mm.sdk.b.a.IvT.l(localoi);
            AppMethodBeat.o(39342);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ah.k.b)localObject).type == 19)
      {
        parama.a(new d.a.b()
        {
          public final void cza()
          {
            AppMethodBeat.i(39343);
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.l(SelectConversationUI.this));
            localIntent.putExtra("record_xml", this.lmz.hDg);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.br.d.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(39343);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ah.k.b)localObject).type == 3)
      {
        parama.a(new d.a.b()
        {
          public final void cza()
          {
            AppMethodBeat.i(180091);
            Object localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q(this.lmz.url, "message");
            String str = com.tencent.mm.pluginsdk.model.app.q.Q(this.lmz.hCB, "message");
            Object localObject1;
            if (az.isMobile(SelectConversationUI.this.getContext()))
            {
              localObject1 = localObject2;
              if (str != null)
              {
                if (str.length() > 0) {
                  break label117;
                }
                localObject1 = localObject2;
              }
            }
            for (;;)
            {
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
              ((Intent)localObject2).putExtra("showShare", false);
              com.tencent.mm.br.d.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
              AppMethodBeat.o(180091);
              return;
              if (localObject2 != null)
              {
                localObject1 = localObject2;
                if (((String)localObject2).length() > 0) {}
              }
              else
              {
                label117:
                localObject1 = str;
              }
            }
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ah.k.b)localObject).type == 4)
      {
        parama.a(new d.a.b()
        {
          public final void cza()
          {
            AppMethodBeat.i(180092);
            AppMethodBeat.o(180092);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if ((((com.tencent.mm.ah.k.b)localObject).type == 53) || (((com.tencent.mm.ah.k.b)localObject).type == 57))
      {
        parama.a(new d.a.b()
        {
          public final void cza()
          {
            AppMethodBeat.i(180093);
            Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
            ((Intent)localObject).putExtra("Retr_Msg_content", this.lmz.title);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.kk(SelectConversationUI.this.getContext());
            AppMethodBeat.o(180093);
          }
        });
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void cza()
          {
            AppMethodBeat.i(188221);
            Object localObject = l.kq(SelectConversationUI.this.getContext());
            localObject = com.tencent.mm.ah.k.b.zb(bu.aSA(com.tencent.mm.plugin.record.b.p.a(((qi)localObject).dFT.dGa.title, ((qi)localObject).dFT.dGa.desc, ((qi)localObject).dFT.dFl.doL.doN, ((qi)localObject).dFS.dFY, SelectConversationUI.l(SelectConversationUI.this))));
            if (localObject == null)
            {
              AppMethodBeat.o(188221);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.l(SelectConversationUI.this));
            localIntent.putExtra("record_xml", ((com.tencent.mm.ah.k.b)localObject).hDg);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.br.d.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(188221);
          }
        });
        AppMethodBeat.o(39378);
        return;
        l.kq(getContext());
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void cza()
          {
            AppMethodBeat.i(188222);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.l(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(188222);
          }
        });
      }
    }
  }
  
  private void a(o.a parama, String paramString)
  {
    AppMethodBeat.i(39371);
    bc.aCg();
    com.tencent.mm.model.c.azF().aUK(paramString);
    String str = w.zP(paramString);
    if (!bu.isNullOrNil(this.Lkp)) {
      str = this.Lkp;
    }
    parama.aOo(aYY(paramString) + str);
    AppMethodBeat.o(39371);
  }
  
  private boolean a(final Intent paramIntent, final o.a parama, final String paramString)
  {
    AppMethodBeat.i(180097);
    Object localObject = (HashMap)getIntent().getSerializableExtra("appbrand_params");
    boolean bool1 = ck.bW(((HashMap)localObject).get("is_weishi_video"));
    final boolean bool2 = ck.bW(((HashMap)localObject).get("is_video"));
    if (bool1)
    {
      bool1 = a(parama, (HashMap)localObject);
      AppMethodBeat.o(180097);
      return bool1;
    }
    int i = ck.getInt(((HashMap)localObject).get("type"), 1);
    final String str2 = ck.c(((HashMap)localObject).get("title"), "");
    final String str1 = ck.c(((HashMap)localObject).get("img_url"), null);
    int j = ck.getInt(((HashMap)localObject).get("biz"), k.a.hCx.ordinal());
    if ((!k.a.isValid(j)) && ((i == 2) || (i == 3)))
    {
      if ((paramString != null) && (y.Yn()) && (x.Aa(paramString)) && (ay.aRW("group_to_do").getBoolean("introduce_dialog_first", true)))
      {
        ay.aRW("group_to_do").edit().putBoolean("introduce_dialog_first", false);
        e.a(this, new e.a()
        {
          public final void fLG()
          {
            AppMethodBeat.i(180080);
            paramIntent.putExtra("KShowTodoIntroduceView", 1);
            SelectConversationUI.a(SelectConversationUI.this, paramIntent, parama, this.LkG, bool2, str1, str2, paramString);
            AppMethodBeat.o(180080);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(180097);
        return true;
        a(paramIntent, parama, (HashMap)localObject, bool2, str1, str2, paramString);
      }
    }
    if (k.a.isValid(j))
    {
      paramString = getResources().getString(2131755375);
      localObject = ck.c(((HashMap)localObject).get("nickname"), null);
      if (bu.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        parama.aOo(paramString + str2);
        paramString = new f(this);
        paramString.Llw = new f.a()
        {
          public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(188207);
            paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
            if (paramAnonymousBoolean1)
            {
              paramIntent.putExtra("custom_send_text", paramAnonymousString);
              SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
              SelectConversationUI.this.finish();
              AppMethodBeat.o(188207);
              return;
            }
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            SelectConversationUI.this.finish();
            AppMethodBeat.o(188207);
          }
        };
        com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
        {
          public final String BN()
          {
            AppMethodBeat.i(188210);
            String str = n.cH(this);
            AppMethodBeat.o(188210);
            return str;
          }
          
          public final void F(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(188208);
            paramString.fPC();
            AppMethodBeat.o(188208);
          }
          
          public final void aEt() {}
          
          public final void ox()
          {
            AppMethodBeat.i(188209);
            paramString.fPC();
            AppMethodBeat.o(188209);
          }
        }, str1, com.tencent.mm.modelappbrand.a.g.hOv);
        parama.l(Boolean.TRUE);
        parama.Foq = fPp();
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(39327);
            SelectConversationUI.this.hideVKB();
            paramString.a(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt, false);
            AppMethodBeat.o(39327);
          }
        }.show();
        AppMethodBeat.o(180097);
        return true;
        paramString = bu.x(getResources().getString(2131756223), new Object[] { localObject });
      }
    }
    parama.aOo(getResources().getString(2131755375) + str2);
    parama.aOp(str1).fgp();
    parama.l(Boolean.TRUE);
    AppMethodBeat.o(180097);
    return false;
  }
  
  private boolean a(o.a parama, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(39377);
    final String str = ck.c(paramHashMap.get("img_url"), null);
    if (!bu.isNullOrNil(str))
    {
      paramHashMap = new RelativeLayout(this);
      View localView = LayoutInflater.from(this).inflate(2131493585, null);
      paramHashMap.addView(localView, new RelativeLayout.LayoutParams(-2, -2));
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(14);
      final ImageView localImageView = (ImageView)localView.findViewById(2131302310);
      ((ImageView)localView.findViewById(2131300961)).setImageResource(2131691361);
      parama.fS(paramHashMap);
      parama.fgq();
      com.tencent.mm.modelappbrand.a.b.aEl().a(new b.k()
      {
        public final String BN()
        {
          return "SelectConversationUI#WEISHITHUMB";
        }
        
        public final void F(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(188216);
          if ((!SelectConversationUI.this.isFinishing()) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()) && (localImageView != null))
          {
            paramAnonymousBitmap = com.tencent.mm.ui.an.c(SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBitmap, localImageView, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight()), aq.fromDPToPix(SelectConversationUI.this, 3));
            localImageView.setImageBitmap(paramAnonymousBitmap);
          }
          AppMethodBeat.o(188216);
        }
        
        public final void aEt() {}
        
        public final void ox()
        {
          AppMethodBeat.i(188217);
          ae.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", new Object[] { str });
          AppMethodBeat.o(188217);
        }
      }, str, null, null);
    }
    for (;;)
    {
      parama.l(Boolean.TRUE);
      AppMethodBeat.o(39377);
      return false;
      paramHashMap = ck.c(paramHashMap.get("msg_img_path"), null);
      if (!bu.isNullOrNil(paramHashMap))
      {
        ae.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", new Object[] { str, paramHashMap });
        parama.i(aYZ(paramHashMap), 2);
      }
    }
  }
  
  private static boolean aYU(String paramString)
  {
    AppMethodBeat.i(39364);
    if (com.tencent.mm.storage.an.aUq(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    if (x.zV(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    AppMethodBeat.o(39364);
    return false;
  }
  
  private void aYW(String paramString)
  {
    AppMethodBeat.i(39366);
    try
    {
      Object localObject = bu.U(paramString.split(","));
      paramString = new StringBuffer();
      localObject = ((List)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!bu.isNullOrNil(str))
        {
          if (i != 0) {
            paramString.append(",");
          }
          paramString.append(w.zP(str));
          i = 1;
        }
      }
      com.tencent.mm.ui.base.h.d(this, getString(2131763649, new Object[] { paramString }), "", null);
      AppMethodBeat.o(39366);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(39366);
    }
  }
  
  private void aYX(String paramString)
  {
    AppMethodBeat.i(39367);
    ae.i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", new Object[] { paramString, this.Lkx, Integer.valueOf(this.Lky) });
    ae.i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", new Object[] { this.Lkz });
    ((com.tencent.mm.choosemsgfile.compat.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.a.class)).a(this, paramString, this.Lkx, this.Lky, this.Lkz, new com.tencent.mm.choosemsgfile.compat.a.a()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, ArrayList<MsgFile> paramAnonymousArrayList)
      {
        AppMethodBeat.i(39351);
        ae.i("MicroMsg.SelectConversationUI", "resultCode:%d filePaths:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousArrayList });
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(39351);
          return;
          paramAnonymousString = new Intent();
          paramAnonymousString.putParcelableArrayListExtra("FILEPATHS", paramAnonymousArrayList);
          SelectConversationUI.this.setResult(-1, paramAnonymousString);
          SelectConversationUI.this.finish();
          AppMethodBeat.o(39351);
          return;
          paramAnonymousArrayList = new Intent();
          paramAnonymousArrayList.putExtra("ERRMSG", paramAnonymousString);
          SelectConversationUI.this.setResult(1, paramAnonymousArrayList);
          SelectConversationUI.this.finish();
        }
      }
    });
    AppMethodBeat.o(39367);
  }
  
  private String aYY(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(39372);
    bc.aCg();
    com.tencent.mm.storage.an localan = com.tencent.mm.model.c.azF().aUK(paramString);
    Object localObject = getResources().getString(2131755784);
    if (localan == null)
    {
      AppMethodBeat.o(39372);
      return localObject;
    }
    bc.aCg();
    localObject = com.tencent.mm.model.c.azI().arp(this.dEU);
    int i = j;
    if (localObject != null) {
      if (!x.oq(((bv.a)localObject).Ecg))
      {
        i = j;
        if (!localan.fug()) {}
      }
      else
      {
        i = 1;
      }
    }
    if (i != 0) {
      paramString = getResources().getString(2131755783);
    }
    for (;;)
    {
      AppMethodBeat.o(39372);
      return paramString;
      if (com.tencent.mm.storage.an.aUq(paramString)) {
        paramString = c(this, localan);
      } else {
        paramString = getResources().getString(2131755784);
      }
    }
  }
  
  private static Bitmap aYZ(String paramString)
  {
    AppMethodBeat.i(39383);
    localBitmap2 = com.tencent.mm.av.q.aIX().FQ(paramString);
    localBitmap1 = localBitmap2;
    if (localBitmap2 != null) {}
    try
    {
      int j = Exif.fromFile(paramString).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap1 = com.tencent.mm.sdk.platformtools.h.a(localBitmap2, i);
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.SelectConversationUI", paramString, "unexpected exception.", new Object[0]);
        localBitmap1 = localBitmap2;
      }
    }
    AppMethodBeat.o(39383);
    return localBitmap1;
  }
  
  private void b(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(39374);
    ae.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=".concat(String.valueOf(paramIntent2)));
    paramIntent2.putExtras(paramIntent1.getExtras());
    startActivityForResult(paramIntent2, 2);
    com.tencent.mm.ui.base.b.am(getContext(), paramIntent2);
    AppMethodBeat.o(39374);
  }
  
  private static void b(Intent paramIntent, String paramString1, String paramString2)
  {
    AppMethodBeat.i(39370);
    if (paramString1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("cardNameToSend is null", bool);
      paramIntent.putExtra("be_send_card_name", paramString1);
      paramIntent.putExtra("received_card_name", paramString2);
      paramIntent.putExtra("Is_Chatroom", true);
      AppMethodBeat.o(39370);
      return;
    }
  }
  
  private void b(o.a parama, final String paramString)
  {
    AppMethodBeat.i(180099);
    Object localObject1;
    int i;
    com.tencent.mm.ah.k.b localb;
    switch (this.msgType)
    {
    case 6: 
    case 7: 
    case 14: 
    case 15: 
    case 17: 
    default: 
    case 4: 
    case 0: 
    case 16: 
    case 1: 
    case 11: 
    case 9: 
    case 5: 
    case 8: 
    case 19: 
    case 18: 
    case 20: 
    case 21: 
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(180099);
            return;
            parama.aOo(this.dEU);
            parama.fgo();
            AppMethodBeat.o(180099);
            return;
            localObject1 = fPs();
            paramString = (String)localObject1;
            if (localObject1 == null)
            {
              paramString = (String)localObject1;
              if (this.imagePath != null)
              {
                float f = com.tencent.mm.cb.a.getDensity(ak.getContext());
                paramString = com.tencent.mm.sdk.platformtools.h.a(this.imagePath, 140, 140, f);
                int j = Exif.fromFile(this.imagePath).getOrientationInDegree();
                i = j;
                if (j < 0) {
                  i = 0;
                }
                paramString = com.tencent.mm.sdk.platformtools.h.a(paramString, i);
              }
            }
            parama.i(paramString, 3);
            AppMethodBeat.o(180099);
            return;
            parama.i(fPr(), 2);
            AppMethodBeat.o(180099);
            return;
            parama.i(fPr(), 2);
            AppMethodBeat.o(180099);
            return;
            parama.aOo(fPq());
            AppMethodBeat.o(180099);
            return;
            if (!bu.isNullOrNil(this.emojiMD5))
            {
              parama.aOq(this.emojiMD5);
              AppMethodBeat.o(180099);
              return;
            }
            if (!bu.isNullOrNil(this.dCi.field_imgPath))
            {
              parama.aOq(this.dCi.field_imgPath);
              AppMethodBeat.o(180099);
              return;
            }
            parama.aOq(this.imagePath);
            AppMethodBeat.o(180099);
            return;
            bc.aCg();
            paramString = com.tencent.mm.model.c.azI().arp(this.dEU);
            this.Lko = paramString.cUA;
            this.Lkp = paramString.nickname;
            this.Lkq = Boolean.valueOf(x.oq(paramString.Ecg));
            a(parama, this.Lko);
            AppMethodBeat.o(180099);
            return;
            paramString = (com.tencent.mm.plugin.finder.api.d)com.tencent.mm.ah.k.b.zb(bu.aSA(this.dEU)).ao(com.tencent.mm.plugin.finder.api.d.class);
          } while (paramString == null);
          parama.aOo(getString(2131755776) + paramString.title);
          AppMethodBeat.o(180099);
          return;
          paramString = (com.tencent.mm.plugin.i.a.b)com.tencent.mm.ah.k.b.zb(bu.aSA(this.dEU)).ao(com.tencent.mm.plugin.i.a.b.class);
          if (paramString != null) {
            parama.fS(a(paramString));
          }
          parama.fgq();
          AppMethodBeat.o(180099);
          return;
          paramString = (com.tencent.mm.plugin.i.a.a)com.tencent.mm.ah.k.b.zb(bu.aSA(this.dEU)).ao(com.tencent.mm.plugin.i.a.a.class);
        } while (paramString == null);
        parama.aOo(getString(2131755777) + paramString.nickname);
        AppMethodBeat.o(180099);
        return;
        paramString = (com.tencent.mm.plugin.i.a.c)com.tencent.mm.ah.k.b.zb(bu.aSA(this.dEU)).ao(com.tencent.mm.plugin.i.a.c.class);
      } while ((paramString == null) || (paramString.ipX == null));
      localObject1 = getString(2131755775);
      if (paramString.ipX.sXu == 1) {}
      for (paramString = (String)localObject1 + getString(2131759380, new Object[] { paramString.ipX.dBe });; paramString = (String)localObject1 + paramString.ipX.dBe)
      {
        parama.aOo(paramString);
        AppMethodBeat.o(180099);
        return;
      }
    case 2: 
    case 10: 
      localb = com.tencent.mm.ah.k.b.zb(bu.aSA(this.dEU));
      if ((this.dCi.fta()) && (localb == null)) {
        localb = com.tencent.mm.ah.k.b.aB(bu.aSA(this.dEU), bu.aSA(this.dEU));
      }
      break;
    }
    for (;;)
    {
      if (localb == null)
      {
        if (this.Lkv != null)
        {
          paramString = getResources().getString(2131755926);
          localObject1 = this.Lkv;
          parama.aOo(paramString + (String)localObject1);
        }
        AppMethodBeat.o(180099);
        return;
      }
      localObject1 = localb.title;
      if (m.f(this.dCi, this.KzP)) {
        paramString = getResources().getString(2131755375);
      }
      for (;;)
      {
        if (localb.type == 48) {
          paramString = getResources().getString(2131755786);
        }
        if (localb.type != 46) {
          break;
        }
        parama.i(fPs(), 2);
        AppMethodBeat.o(180099);
        return;
        if (localb.type == 5)
        {
          paramString = getResources().getString(2131755920);
        }
        else if (localb.type == 6)
        {
          paramString = getResources().getString(2131755773);
        }
        else if (localb.type == 24)
        {
          paramString = getResources().getString(2131755834);
          localObject1 = o(localb);
        }
        else if (localb.type == 19)
        {
          paramString = getResources().getString(2131755872);
        }
        else if (localb.type == 3)
        {
          paramString = getResources().getString(2131755820);
        }
        else if (localb.type == 4)
        {
          paramString = getResources().getString(2131755926);
        }
        else if (localb.type == 8)
        {
          paramString = getResources().getString(2131755724);
        }
        else if (localb.type == 44)
        {
          if (bu.isNullOrNil(localb.dIu)) {
            paramString = getResources().getString(2131755895);
          } else {
            paramString = bu.x(getResources().getString(2131756223), new Object[] { localb.dIu });
          }
        }
        else if ((localb.type == 33) || (localb.type == 36) || (localb.type == 48))
        {
          if ((localb.hFe == 2) || (localb.hFe == 3) || (localb.type == 36) || (localb.type == 48))
          {
            i = localb.hFj;
            if (localb.ex(false))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("key_biz", i);
              ((Bundle)localObject1).putString("key_footer_text_default", localb.dIu);
              ((Bundle)localObject1).putString("key_footer_text", localb.t(getContext(), false));
              ((Bundle)localObject1).putString("key_footer_icon", localb.hFt);
              localObject2 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class);
              if (paramString != null) {
                break label1695;
              }
            }
            label1695:
            for (boolean bool = false;; bool = x.Aa(paramString))
            {
              paramString = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool, new k.c()
              {
                public final void aDY()
                {
                  AppMethodBeat.i(188218);
                  SelectConversationUI.k(SelectConversationUI.this);
                  e.a(SelectConversationUI.this, null);
                  AppMethodBeat.o(188218);
                }
                
                public final void eB(boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(188219);
                  SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBoolean);
                  AppMethodBeat.o(188219);
                }
              });
              parama.fS(paramString);
              parama.l(Boolean.TRUE);
              parama.fgq();
              Object localObject3 = com.tencent.mm.av.q.aIX().c(this.dCi.field_imgPath, false, true);
              localObject1 = n.cH(this);
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("app_id", localb.hFd);
              ((Bundle)localObject2).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(localb.hFr), Integer.valueOf(localb.hFg) }));
              ((Bundle)localObject2).putInt("msg_pkg_type", localb.hFr);
              ((Bundle)localObject2).putInt("pkg_version", localb.hFg);
              if (!bu.isNullOrNil((String)localObject3)) {
                ((Bundle)localObject2).putString("image_url", "file://".concat(String.valueOf(localObject3)));
              }
              localObject3 = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
              if (localObject3 != null)
              {
                ((Bundle)localObject2).putBoolean("is_dynamic_page", ((com.tencent.mm.ah.a)localObject3).hAJ);
                ((Bundle)localObject2).putString("cache_key", ((com.tencent.mm.ah.a)localObject3).hAK);
                ((Bundle)localObject2).putInt("sub_type", ((com.tencent.mm.ah.a)localObject3).hAY);
              }
              ((Bundle)localObject2).putString("title", localb.title);
              ((Bundle)localObject2).putString("msg_path", localb.hFb);
              ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a((String)localObject1, paramString, (Bundle)localObject2);
              parama.ngd = new DialogInterface.OnDismissListener()
              {
                public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(188220);
                  ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.kke, paramString);
                  AppMethodBeat.o(188220);
                }
              };
              AppMethodBeat.o(180099);
              return;
              if (localb.type == 48)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putBoolean("is_video", true);
                ((Bundle)localObject1).putString("key_footer_icon", localb.hFt);
                ((Bundle)localObject1).putString("key_footer_text", localb.dIu);
                break;
              }
              ae.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(i) });
              localObject1 = null;
              break;
            }
          }
          paramString = getResources().getString(2131755375);
        }
        else if ((localb.type == 53) || (localb.type == 57))
        {
          paramString = "";
        }
        else
        {
          paramString = getResources().getString(2131755278);
        }
      }
      if (localb.type == 69)
      {
        paramString = (com.tencent.mm.plugin.game.luggage.e.a)localb.ao(com.tencent.mm.plugin.game.luggage.e.a.class);
        if (paramString != null)
        {
          parama.aOo(getResources().getString(2131758001) + paramString.bVF);
          if (!bu.isNullOrNil(paramString.iconUrl)) {
            parama.aOp(paramString.iconUrl).fgp();
          }
        }
        AppMethodBeat.o(180099);
        return;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      parama.aOo(paramString + (String)localObject2);
      if (localb.thumburl == null) {
        break;
      }
      parama.aOp(localb.thumburl).fgp();
      AppMethodBeat.o(180099);
      return;
      paramString = bu.bI(l.kq(getContext()).dFT.dGa.title, "");
      parama.aOo(getResources().getString(2131755818) + paramString);
      AppMethodBeat.o(180099);
      return;
      paramString = l.kq(getContext());
      if (paramString.dFS.dFX != null) {}
      for (i = paramString.dFS.dFX.size();; i = 0)
      {
        paramString = getContext().getString(2131762561, new Object[] { Integer.valueOf(i) });
        parama.aOo(getResources().getString(2131755817) + paramString);
        AppMethodBeat.o(180099);
        return;
        if (this.oEU == null) {
          break;
        }
        parama.aOo(getResources().getString(2131755773) + this.oEU);
        break;
      }
    }
  }
  
  public static String c(Context paramContext, com.tencent.mm.storage.an paraman)
  {
    AppMethodBeat.i(39373);
    paraman = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).a(paraman.field_openImAppid, "openim_card_type_name", com.tencent.mm.openim.a.a.a.iKm);
    if (TextUtils.isEmpty(paraman)) {}
    for (paramContext = paramContext.getResources().getString(2131755784);; paramContext = String.format("[%s]", new Object[] { paraman }))
    {
      AppMethodBeat.o(39373);
      return paramContext;
    }
  }
  
  private String fPp()
  {
    AppMethodBeat.i(169904);
    String str2 = getIntent().getStringExtra("KSendWording");
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      str1 = getString(2131755884);
    }
    AppMethodBeat.o(169904);
    return str1;
  }
  
  private String fPq()
  {
    AppMethodBeat.i(39380);
    bc.aCg();
    bv.b localb = com.tencent.mm.model.c.azI().arq(this.dEU);
    String str = "";
    if (localb != null) {
      str = localb.label;
    }
    str = getContext().getString(2131755806) + str;
    AppMethodBeat.o(39380);
    return str;
  }
  
  private Bitmap fPr()
  {
    AppMethodBeat.i(39381);
    com.tencent.mm.modelvideo.o.aNh();
    Object localObject = com.tencent.mm.modelvideo.t.HK(this.dCi.field_imgPath);
    if (localObject == null)
    {
      localObject = this.imagePath;
      if (!com.tencent.mm.plugin.a.c.Jz(this.imagePath))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.GS((String)localObject);
        AppMethodBeat.o(39381);
        return localObject;
      }
      localObject = com.tencent.mm.sdk.platformtools.h.aRC((String)localObject);
      AppMethodBeat.o(39381);
      return localObject;
    }
    localObject = com.tencent.mm.sdk.platformtools.h.aRC((String)localObject);
    AppMethodBeat.o(39381);
    return localObject;
  }
  
  private Bitmap fPs()
  {
    AppMethodBeat.i(39382);
    if (this.dCi == null)
    {
      AppMethodBeat.o(39382);
      return null;
    }
    String str = this.dCi.field_imgPath;
    localBitmap3 = com.tencent.mm.av.q.aIX().FQ(str);
    Bitmap localBitmap1 = localBitmap3;
    if (localBitmap3 != null) {}
    try
    {
      int j = Exif.fromFile(str).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap1 = com.tencent.mm.sdk.platformtools.h.a(localBitmap3, i);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.SelectConversationUI", localThrowable, "unexpected exception.", new Object[0]);
        Bitmap localBitmap2 = localBitmap3;
      }
    }
    AppMethodBeat.o(39382);
    return localBitmap1;
  }
  
  private void fPt()
  {
    AppMethodBeat.i(39386);
    ae.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 14);
    localIntent.putExtra("titile", getString(2131755234));
    localIntent.putExtra("list_attr", u.KJX);
    localIntent.putExtra("already_select_contact", bu.m(this.Lkt, ","));
    localIntent.putExtra("max_limit_num", 9);
    if ((this.KLF) && (com.tencent.mm.storage.an.aUq(this.Lko))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 5);
      AppMethodBeat.o(39386);
      return;
    }
  }
  
  private void fPu()
  {
    boolean bool = true;
    AppMethodBeat.i(39387);
    ae.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", u.KJU);
    localIntent.putExtra("list_type", 3);
    localIntent.putExtra("be_send_card_name", this.Lko);
    localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
    localIntent.putExtra("Add_SendCard", true);
    localIntent.putExtra("titile", getString(2131755234));
    if ((this.KLF) && (com.tencent.mm.storage.an.aUq(this.Lko))) {}
    for (;;)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 3);
      AppMethodBeat.o(39387);
      return;
      bool = false;
    }
  }
  
  private void fPv()
  {
    AppMethodBeat.i(39388);
    ae.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 5);
    localIntent.putExtra("titile", getString(2131755234));
    if (((this.fromScene != 4) && (this.fromScene != 9)) || ((getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || (this.fromScene == 10)))
    {
      localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
      localIntent.putExtra("list_attr", u.J(new int[] { 32, 16, 1, 2, 4, 16384 }));
    }
    for (;;)
    {
      getContext().startActivityForResult(localIntent, 1);
      AppMethodBeat.o(39388);
      return;
      if ((this.Lkn) && (!this.Lkq.booleanValue()))
      {
        localIntent.putExtra("list_attr", u.J(new int[] { 16, 1, 2, 4, 16384 }));
        localIntent.putExtra("without_openim", true);
        localIntent.putExtra("KBlockOpenImFav", true);
      }
      else
      {
        localIntent.putExtra("list_attr", u.KJW);
      }
    }
  }
  
  private static String o(com.tencent.mm.ah.k.b paramb)
  {
    AppMethodBeat.i(39385);
    Object localObject1 = new qi();
    ((qi)localObject1).dFS.type = 0;
    ((qi)localObject1).dFS.dFU = paramb.hDg;
    com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
    com.tencent.mm.protocal.b.a.c localc = ((qi)localObject1).dFT.dGd;
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localc != null)
    {
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = bu.bI(localc.desc, paramb.description);
      }
    }
    paramb = (com.tencent.mm.ah.k.b)localObject1;
    if (!bu.isNullOrNil((String)localObject1)) {
      paramb = ((String)localObject1).replaceAll("\n", " ");
    }
    AppMethodBeat.o(39385);
    return paramb;
  }
  
  private void r(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(39396);
    Intent localIntent = paramIntent;
    if (this.msgType == 5)
    {
      localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.putExtra("emoji_thumb_path", this.emojiMD5);
      localIntent.putExtra("emoji_activity_id", getIntent().getStringExtra("emoji_activity_id"));
    }
    super.setResult(paramInt, localIntent);
    AppMethodBeat.o(39396);
  }
  
  private void w(final Intent paramIntent, final String paramString)
  {
    AppMethodBeat.i(39375);
    if (aYV(paramString))
    {
      AppMethodBeat.o(39375);
      return;
    }
    if (u.hasAttr(this.iYs, 256))
    {
      r(-1, paramIntent);
      finish();
      AppMethodBeat.o(39375);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      ae.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
      AppMethodBeat.o(39375);
      return;
    }
    if (x.wb(paramString))
    {
      int i = r.zC(paramString);
      if (this.Lkm)
      {
        int j = bu.getInt(com.tencent.mm.n.g.acL().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50);
        if (i > j)
        {
          ae.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          com.tencent.mm.ui.base.h.c(this, getString(2131762995, new Object[] { Integer.valueOf(j) }), "", true);
          AppMethodBeat.o(39375);
          return;
        }
      }
      getString(2131762993, new Object[] { Integer.valueOf(i) });
    }
    o.a locala = new o.a(getContext());
    locala.dQ(paramString);
    if (this.KLF)
    {
      a(locala, this.Lko);
      if (x.wb(paramString))
      {
        b(paramIntent, this.Lko, paramString);
        locala.l(Boolean.TRUE);
      }
    }
    for (;;)
    {
      locala.Foq = fPp();
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          int i = 1;
          AppMethodBeat.i(39353);
          SelectConversationUI.this.hideVKB();
          boolean bool = paramIntent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
          if (bool)
          {
            if (paramAnonymousBoolean)
            {
              paramAnonymousInt = 1;
              ae.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", new Object[] { Integer.valueOf(13943), Integer.valueOf(paramAnonymousInt) });
              com.tencent.mm.plugin.report.service.g.yxI.f(13943, new Object[] { Integer.valueOf(paramAnonymousInt) });
            }
          }
          else
          {
            if (!paramAnonymousBoolean) {
              break label205;
            }
            paramIntent.putExtra("custom_send_text", paramAnonymousString);
            paramIntent.putExtra("KSendGroupToDo", SelectConversationUI.h(SelectConversationUI.this));
            paramIntent.putExtra("KShowTodoIntroduceView", SelectConversationUI.i(SelectConversationUI.this));
            SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
            com.tencent.mm.pluginsdk.ui.tools.o.lI(SelectConversationUI.j(SelectConversationUI.this), paramString);
            SelectConversationUI.this.finish();
          }
          for (;;)
          {
            paramAnonymousString = SelectConversationUI.this;
            String str = paramString;
            paramAnonymousInt = i;
            if (paramAnonymousBoolean) {
              paramAnonymousInt = 2;
            }
            SelectConversationUI.a(paramAnonymousString, str, paramAnonymousInt);
            AppMethodBeat.o(39353);
            return;
            paramAnonymousInt = 0;
            break;
            label205:
            if (bool)
            {
              paramAnonymousString = paramIntent.getStringExtra("Select_Contact");
              bc.aCg();
              com.tencent.mm.model.c.azL().aUY(paramAnonymousString);
            }
          }
        }
      }.show();
      AppMethodBeat.o(39375);
      return;
      a(paramIntent, this.Lko, paramString);
      break;
      Object localObject;
      if (this.Lke)
      {
        if ((getIntent().hasExtra("appbrand_params")) && (a(paramIntent, locala, null)))
        {
          AppMethodBeat.o(39375);
          return;
        }
        if (this.doH != -1L)
        {
          a(locala);
          localObject = new gt();
          ((gt)localObject).dtP.doH = this.doH;
          ((gt)localObject).dtP.dtQ = this.dtQ;
          ((gt)localObject).dtP.dtR = this.msgType;
          ((gt)localObject).dtP.dtS = locala;
          ((gt)localObject).dtP.dtT = this.Lkw;
          ((gt)localObject).dtP.dlQ = getContext();
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        }
        for (;;)
        {
          locala.l(Boolean.TRUE);
          break;
          if ((this.msgType == 17) && (this.Lkl != 0))
          {
            localObject = getContext().getString(2131762561, new Object[] { Integer.valueOf(this.Lkl) });
            locala.aOo(getResources().getString(2131755817) + (String)localObject);
          }
        }
      }
      String str1;
      if ((this.Lkf) && (!this.rKS))
      {
        localObject = (HashMap)getIntent().getSerializableExtra("webview_params");
        str1 = (String)((HashMap)localObject).get("img_url");
        String str3 = (String)((HashMap)localObject).get("title");
        final String str2 = (String)((HashMap)localObject).get("url");
        if (!this.Lkj) {}
        for (localObject = getResources().getString(2131755920) + str3;; localObject = getResources().getString(2131758001) + (String)localObject)
        {
          locala.aOo((String)localObject);
          locala.a(new d.a.b()
          {
            public final void cza()
            {
              AppMethodBeat.i(39352);
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", str2);
              localIntent.putExtra("showShare", false);
              com.tencent.mm.br.d.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
              AppMethodBeat.o(39352);
            }
          });
          locala.aOp(str1).fgp();
          locala.l(Boolean.TRUE);
          break;
          localObject = (String)((HashMap)localObject).get("nickname");
        }
      }
      if ((this.Lkg) && (a(paramIntent, locala, paramString)))
      {
        AppMethodBeat.o(39375);
        return;
      }
      if (this.Lki)
      {
        str1 = getResources().getString(2131755788);
        localObject = str1;
        if (this.oEU != null) {
          localObject = str1 + this.oEU;
        }
        locala.aOo((String)localObject);
        locala.l(Boolean.FALSE);
      }
      else
      {
        b(locala, paramString);
        a(locala);
        locala.l(Boolean.TRUE);
      }
    }
  }
  
  private boolean yS(boolean paramBoolean)
  {
    AppMethodBeat.i(39394);
    if (paramBoolean)
    {
      if (this.Lkt.size() < 9) {}
    }
    else {
      while (this.Lkt.size() > 9)
      {
        String str = getString(2131762996, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9)) });
        com.tencent.mm.ui.base.h.d(getContext(), str, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        AppMethodBeat.o(39394);
        return true;
      }
    }
    AppMethodBeat.o(39394);
    return false;
  }
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(39391);
    if (paramInt == 1)
    {
      this.Lkt.remove(paramString);
      fMv().notifyDataSetChanged();
      Zv();
    }
    AppMethodBeat.o(39391);
  }
  
  public final void Zm()
  {
    AppMethodBeat.i(39356);
    super.Zm();
    this.Lkd = getIntent().getBooleanExtra("select_is_ret", false);
    this.fromScene = getIntent().getIntExtra("scene_from", 0);
    ae.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    if (this.fromScene == 1) {
      this.Lke = true;
    }
    for (;;)
    {
      this.rKS = getIntent().getBooleanExtra("is_mp_video", false);
      this.Lkj = getIntent().getBooleanExtra("is_game_card", false);
      this.Lkk = getIntent().getBooleanExtra("send_to_biz", false);
      this.KzP = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.doH = getIntent().getLongExtra("select_fav_local_id", -1L);
      this.dtQ = getIntent().getStringExtra("select_fav_fake_local_id");
      this.Lkl = getIntent().getIntExtra("select_fav_select_count", 0);
      this.Lkr = getIntent().getBooleanExtra("mutil_select_is_ret", false);
      this.KLF = getIntent().getBooleanExtra("Select_Send_Card", false);
      this.Lkn = getIntent().getBooleanExtra("forward_card", false);
      this.Lkm = getIntent().getBooleanExtra("Retr_Big_File", false);
      if (this.KLF) {
        this.Lko = getIntent().getStringExtra("Select_Talker_Name");
      }
      this.iYs = getIntent().getIntExtra("Select_Conv_Type", Lkb);
      this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
      this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      bc.aCg();
      this.dCi = com.tencent.mm.model.c.azI().ys(this.msgId);
      this.imagePath = getIntent().getStringExtra("image_path");
      this.Lkv = getIntent().getStringExtra("ad_video_title");
      this.oEU = getIntent().getStringExtra("desc_title");
      this.emojiMD5 = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.dEU = getIntent().getStringExtra("Retr_Msg_content");
      this.Lkw = getIntent().getStringExtra("Retr_fav_xml_str");
      if ((this.dEU == null) && (this.dCi != null)) {
        this.dEU = this.dCi.field_content;
      }
      if (this.dEU == null) {
        this.dEU = "";
      }
      this.Lku = ((ReportUtil.ReportArgs)getIntent().getParcelableExtra("Select_Report_Args"));
      this.Lkx = getIntent().getStringExtra("KChooseMsgFileType");
      this.Lky = getIntent().getIntExtra("KChooseMsgFileCount", 9);
      this.Lkz = getIntent().getStringExtra("KChooseMsgFileExtension");
      Object localObject1 = new HashSet();
      ((HashSet)localObject1).addAll(u.fMH());
      Object localObject2 = getIntent().getStringExtra("Select_block_List");
      if (!bu.isNullOrNil((String)localObject2)) {
        ((HashSet)localObject1).addAll(bu.U(((String)localObject2).split(",")));
      }
      if (u.hasAttr(this.iYs, 2))
      {
        localObject2 = u.fMI();
        u.i((HashSet)localObject2);
        ((HashSet)localObject1).addAll((Collection)localObject2);
      }
      this.fUR = new ArrayList();
      this.fUR.addAll((Collection)localObject1);
      localObject1 = this.fUR;
      long l = System.currentTimeMillis();
      int i = ((List)localObject1).size();
      ((List)localObject1).addAll(com.tencent.mm.pluginsdk.i.d.fef());
      ae.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(((List)localObject1).size() - i) });
      if (u.hasAttr(this.iYs, 1)) {
        this.KJB = true;
      }
      if (this.Lkr)
      {
        this.Lkt = new LinkedList();
        if (this.Lkr)
        {
          addTextOptionMenu(1, getString(2131755819), this.LkC, null, s.b.JwA);
          Zv();
        }
      }
      AppMethodBeat.o(39356);
      return;
      if ((this.fromScene != 2) && (this.fromScene != 10))
      {
        if (this.fromScene == 3)
        {
          getIntent();
          boolean bool = ck.bW(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("is_h5"));
          if (bool) {
            ae.i("MicroMsg.SelectConversationUI", "hy: is H5 link");
          }
          if (!bool) {}
        }
      }
      else
      {
        this.Lkf = true;
        continue;
      }
      if (this.fromScene == 3) {
        this.Lkg = true;
      } else if (this.fromScene == 6) {
        this.Lkh = true;
      } else if (this.fromScene == 7) {
        this.Lki = true;
      } else if (this.fromScene == 11) {
        overridePendingTransition(2130772108, 2130772106);
      }
    }
  }
  
  public final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(39359);
    super.a(paramListView, paramInt);
    if (this.fromScene == 11)
    {
      AppMethodBeat.o(39359);
      return;
    }
    if (this.JQP == null)
    {
      if (!this.KLF) {
        break label134;
      }
      this.Lkc = 2131763014;
    }
    for (;;)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39335);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/transmit/SelectConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (SelectConversationUI.a(SelectConversationUI.this)) {
            SelectConversationUI.b(SelectConversationUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(39335);
            return;
            paramAnonymousView = SelectConversationUI.this.getIntent().getStringExtra("Select_App_Id");
            if ((SelectConversationUI.c(SelectConversationUI.this)) && (bu.isNullOrNil(paramAnonymousView))) {
              SelectConversationUI.d(SelectConversationUI.this);
            } else {
              SelectConversationUI.e(SelectConversationUI.this);
            }
          }
        }
      };
      String str = getString(this.Lkc);
      View localView = z.jV(this).inflate(2131494420, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131298778);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.JQP = ((TextView)localObject);
      this.JQP.setVisibility(paramInt);
      AppMethodBeat.o(39359);
      return;
      label134:
      if (this.fromScene == 10) {
        this.Lkc = 2131761807;
      } else {
        this.Lkc = 2131763002;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39390);
    if ((parama.KJj) && (parama.contact != null))
    {
      boolean bool = this.Lkt.contains(parama.contact.field_username);
      AppMethodBeat.o(39390);
      return bool;
    }
    AppMethodBeat.o(39390);
    return false;
  }
  
  public final boolean aRT()
  {
    return (!this.Lkr) || (!this.Lks);
  }
  
  public final boolean aRU()
  {
    return false;
  }
  
  public final String aRV()
  {
    AppMethodBeat.i(39389);
    String str = getIntent().getStringExtra("Select_Conv_ui_title");
    if ((str == null) || (str.length() <= 0))
    {
      str = getString(2131763005);
      AppMethodBeat.o(39389);
      return str;
    }
    AppMethodBeat.o(39389);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.q aRW()
  {
    AppMethodBeat.i(39357);
    ab localab = new ab(this, this.fUR, this.KJB, this.Lks, this.Lkk, this.iYs);
    AppMethodBeat.o(39357);
    return localab;
  }
  
  public final com.tencent.mm.ui.contact.o aRX()
  {
    AppMethodBeat.i(39358);
    s locals = new s(this, this.fUR, this.Lks, this.scene);
    AppMethodBeat.o(39358);
    return locals;
  }
  
  public final boolean aYV(String paramString)
  {
    AppMethodBeat.i(39365);
    if (!aYU(paramString))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if ((!bu.isNullOrNil(getIntent().getStringExtra("Select_App_Id"))) && (this.KLF))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if (this.KLF)
    {
      bc.aCg();
      if (com.tencent.mm.storage.an.abz(com.tencent.mm.model.c.azF().aUK(this.Lko).field_verifyFlag))
      {
        aYW(paramString);
        AppMethodBeat.o(39365);
        return true;
      }
    }
    switch (this.msgType)
    {
    case 6: 
    case 7: 
    default: 
      AppMethodBeat.o(39365);
      return false;
    case 5: 
      AppMethodBeat.o(39365);
      return false;
    }
    bc.aCg();
    String str = com.tencent.mm.model.c.azI().arp(this.dEU).cUA;
    bc.aCg();
    if (x.oq(com.tencent.mm.model.c.azF().aUK(str).field_verifyFlag))
    {
      aYW(paramString);
      AppMethodBeat.o(39365);
      return true;
    }
    AppMethodBeat.o(39365);
    return false;
  }
  
  protected final void axN(String paramString)
  {
    AppMethodBeat.i(169903);
    ae.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (aYV(paramString))
    {
      AppMethodBeat.o(169903);
      return;
    }
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("Select_Conv_User", paramString);
    Intent localIntent2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
    if (localIntent2 != null) {
      b(localIntent1, localIntent2);
    }
    for (;;)
    {
      hideVKB();
      AppMethodBeat.o(169903);
      return;
      if ((this.Lkd) || (this.KLF) || (this.Lke) || (this.Lkf) || (this.Lkg) || (this.rKS))
      {
        w(localIntent1, paramString);
      }
      else if (this.fromScene == 11)
      {
        aYX(paramString);
      }
      else
      {
        r(-1, localIntent1);
        finish();
      }
    }
  }
  
  public final int[] dmI()
  {
    AppMethodBeat.i(39395);
    int[] arrayOfInt = getIntent().getIntArrayExtra("search_range");
    if ((this.fromScene == 4) || (this.fromScene == 10))
    {
      AppMethodBeat.o(39395);
      return new int[] { 131072 };
    }
    if (arrayOfInt != null)
    {
      AppMethodBeat.o(39395);
      return arrayOfInt;
    }
    arrayOfInt = super.dmI();
    AppMethodBeat.o(39395);
    return arrayOfInt;
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(39360);
    if (this.fromScene == 5) {
      com.tencent.mm.ui.base.h.a(this, getString(2131760949), null, getString(2131763051), getString(2131756766), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39345);
          paramAnonymousDialogInterface.dismiss();
          AppMethodBeat.o(39345);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(39348);
          SelectConversationUI.f(SelectConversationUI.this);
          SelectConversationUI.this.hideVKB();
          AppMethodBeat.o(39348);
        }
      });
    }
    for (;;)
    {
      if (this.Lku != null)
      {
        this.Lku.errCode = 0;
        ReportUtil.a(this, this.Lku, true);
      }
      AppMethodBeat.o(39360);
      return;
      super.dmJ();
      hideVKB();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(39363);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ae.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    Object localObject1;
    Object localObject2;
    while (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        ae.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
        localObject2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject2 != null)
        {
          if (aYV((String)localObject1))
          {
            AppMethodBeat.o(39363);
            return;
            ae.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
          }
          else
          {
            b(paramIntent, (Intent)localObject2);
            AppMethodBeat.o(39363);
          }
        }
        else
        {
          if ((this.Lkd) || (this.KLF) || (this.Lke) || (this.Lkf) || (this.Lkg))
          {
            w(paramIntent, (String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          if (this.fromScene == 11)
          {
            aYX((String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          r(-1, paramIntent);
          finish();
        }
      }
      else
      {
        AppMethodBeat.o(39363);
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
        AppMethodBeat.o(39363);
        return;
        com.tencent.e.h.MqF.r(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(39349);
            SelectConversationUI.this.finish();
            AppMethodBeat.o(39349);
          }
        }, 1000L);
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("Select_stay_in_wx", false)))
        {
          paramIntent = new Intent(this, TaskRedirectUI.class);
          paramIntent.addFlags(268435456);
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahE(), "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ReportUtil.Z(false, 0);
          AppMethodBeat.o(39363);
          return;
        }
        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getBooleanExtra("Select_back_to_app", false)))
        {
          ReportUtil.a(this, ReportUtil.d(paramIntent.getExtras(), 0), false);
          AppMethodBeat.o(39363);
          return;
          if (paramIntent != null) {
            this.Lku = ((ReportUtil.ReportArgs)paramIntent.getParcelableExtra("Select_Report_Args"));
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
        AppMethodBeat.o(39363);
        return;
        if (paramIntent != null)
        {
          paramIntent = paramIntent.getStringExtra("received_card_name");
          if ((!bu.isNullOrNil(paramIntent)) && (!aYV(paramIntent)))
          {
            localObject1 = new o.a(getContext());
            ((o.a)localObject1).dQ(paramIntent);
            a((o.a)localObject1, this.Lko);
            localObject1 = ((o.a)localObject1).l(Boolean.TRUE);
            ((o.a)localObject1).Foq = fPp();
            {
              public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
              {
                AppMethodBeat.i(39350);
                SelectConversationUI.this.hideVKB();
                Intent localIntent;
                if (paramAnonymousBoolean)
                {
                  localIntent = new Intent();
                  if (!x.wb(paramIntent)) {
                    break label83;
                  }
                  SelectConversationUI.c(localIntent, SelectConversationUI.g(SelectConversationUI.this), paramIntent);
                }
                for (;;)
                {
                  localIntent.putExtra("custom_send_text", paramAnonymousString);
                  SelectConversationUI.a(SelectConversationUI.this, -1, localIntent);
                  SelectConversationUI.this.finish();
                  AppMethodBeat.o(39350);
                  return;
                  label83:
                  SelectConversationUI.d(localIntent, SelectConversationUI.g(SelectConversationUI.this), paramIntent);
                }
              }
            }.show();
          }
        }
      }
    }
    if (paramInt1 == 4)
    {
      if ((paramInt2 == -1) && (paramIntent != null)) {
        w(paramIntent, paramIntent.getStringExtra("Select_Contact"));
      }
      AppMethodBeat.o(39363);
      return;
    }
    if (paramInt1 == 5)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        localObject1 = this.Lkt.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.vUs.aNU((String)localObject2);
        }
        if (!bu.isNullOrNil(paramIntent)) {
          this.Lkt = bu.U(paramIntent.split(","));
        }
        for (;;)
        {
          paramIntent = this.Lkt.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.vUs.aNV((String)localObject1);
          }
          this.Lkt.clear();
        }
        Zv();
        fMv().notifyDataSetChanged();
      }
      AppMethodBeat.o(39363);
      return;
    }
    ae.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(39363);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39361);
    super.dmJ();
    AppMethodBeat.o(39361);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39355);
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Select_App_Id");
    String str = getIntent().getStringExtra("Select_Open_Id");
    ae.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + paramBundle + ", openId = " + str);
    if ((!bu.isNullOrNil(paramBundle)) && (!bu.isNullOrNil(str))) {
      new com.tencent.mm.plugin.base.stub.d(this, paramBundle, str, new d.a()
      {
        public final void jb(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(39323);
          boolean bool = SelectConversationUI.this.isFinishing();
          ae.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + paramAnonymousBoolean + ", isFinishing = " + bool);
          if ((!paramAnonymousBoolean) && (!bool))
          {
            ReportUtil.ReportArgs localReportArgs = (ReportUtil.ReportArgs)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Report_Args");
            ReportUtil.a(SelectConversationUI.this, localReportArgs, false);
            SelectConversationUI.this.finish();
          }
          AppMethodBeat.o(39323);
        }
      }).bMY();
    }
    com.tencent.mm.pluginsdk.h.r(this);
    AppMethodBeat.o(39355);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39392);
    super.onDestroy();
    removeAllOptionMenu();
    AppMethodBeat.o(39392);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(39362);
    int i;
    Object localObject2;
    if (this.Lks)
    {
      i = paramInt - getContentLV().getHeaderViewsCount();
      if (i < 0)
      {
        ae.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
        fPt();
        AppMethodBeat.o(39362);
        return;
      }
      localObject1 = fMv();
      localObject2 = ((com.tencent.mm.ui.contact.p)localObject1).aeW(i);
      if (localObject2 == null)
      {
        AppMethodBeat.o(39362);
        return;
      }
      if (((com.tencent.mm.ui.contact.a.a)localObject2).contact == null)
      {
        AppMethodBeat.o(39362);
        return;
      }
      localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject2).contact.field_username;
      ae.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[] { localObject2 });
      if ((!this.Lkt.contains(localObject2)) && (yS(true)))
      {
        fMC();
        AppMethodBeat.o(39362);
        return;
      }
      fMC();
      this.vUs.aNT((String)localObject2);
      if (this.Lkt.contains(localObject2)) {
        this.Lkt.remove(localObject2);
      }
      for (;;)
      {
        Zv();
        ((com.tencent.mm.ui.contact.p)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(39362);
        return;
        this.Lkt.add(localObject2);
      }
    }
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ae.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      if (this.KLF)
      {
        fPu();
        AppMethodBeat.o(39362);
        return;
      }
      fPv();
      AppMethodBeat.o(39362);
      return;
    }
    Object localObject1 = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (localObject1 == null)
    {
      AppMethodBeat.o(39362);
      return;
    }
    if (((localObject1 instanceof com.tencent.mm.ui.contact.a.b)) && (((com.tencent.mm.ui.contact.a.b)localObject1).bVF == getResources().getString(2131755219)))
    {
      ae.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("list_attr", 16384);
      com.tencent.mm.br.d.b(this, "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject1, 4);
      this.Lkf = true;
      AppMethodBeat.o(39362);
      return;
    }
    if ((localObject1 instanceof com.tencent.mm.ui.contact.a.g))
    {
      Object localObject3 = (com.tencent.mm.ui.contact.a.g)localObject1;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("scene", this.scene);
      localObject2 = new ArrayList();
      localObject3 = ((com.tencent.mm.ui.contact.a.a)localObject3).tFe.tFE;
      i = localObject3.length;
      paramInt = 0;
      while (paramInt < i)
      {
        ((ArrayList)localObject2).add(localObject3[paramInt]);
        paramInt += 1;
      }
      ((Intent)localObject1).putExtra("query_phrase_list", (Serializable)localObject2);
      com.tencent.mm.br.d.c(this, ".ui.transmit.MMCreateChatroomUI", (Intent)localObject1, 1);
      AppMethodBeat.o(39362);
      return;
    }
    localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact;
    if (localObject1 == null)
    {
      AppMethodBeat.o(39362);
      return;
    }
    axN(((aw)localObject1).field_username);
    AppMethodBeat.o(39362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI
 * JD-Core Version:    0.7.0.1
 */