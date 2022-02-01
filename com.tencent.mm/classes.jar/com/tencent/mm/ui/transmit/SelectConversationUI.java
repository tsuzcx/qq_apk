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
import com.tencent.mm.ai.k.a;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qh.a;
import com.tencent.mm.g.a.qh.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ci;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.appbrand.z.n;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.storage.bu.b;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.l;
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
  private static final int KND;
  private TextView JvZ;
  private int KNE;
  private boolean KNF;
  private boolean KNG;
  private boolean KNH;
  private boolean KNI;
  private boolean KNJ;
  private boolean KNK;
  boolean KNL;
  private boolean KNM;
  private int KNN;
  private boolean KNO;
  private boolean KNP;
  private String KNQ;
  private String KNR;
  private Boolean KNS;
  private boolean KNT;
  private boolean KNU;
  private List<String> KNV;
  private ReportUtil.ReportArgs KNW;
  private String KNX;
  private String KNY;
  private String KNZ;
  private int KOa;
  private String KOb;
  private int KOc;
  private boolean KOd;
  private MenuItem.OnMenuItemClickListener KOe;
  private MenuItem.OnMenuItemClickListener KOf;
  private int Kdw;
  private boolean Knh;
  private boolean Kpl;
  private bu dBd;
  private String dDP;
  private long dnC;
  private String dsK;
  private String emojiMD5;
  private List<String> fSL;
  private int fromScene;
  private int iVz;
  private String imagePath;
  private long msgId;
  private int msgType;
  private String oys;
  boolean rCH;
  private int[] rFr;
  
  static
  {
    AppMethodBeat.i(39409);
    KND = u.I(new int[] { 1, 2 });
    AppMethodBeat.o(39409);
  }
  
  public SelectConversationUI()
  {
    AppMethodBeat.i(39354);
    this.KNF = false;
    this.KNG = false;
    this.KNH = false;
    this.KNI = false;
    this.KNJ = false;
    this.KNK = false;
    this.rCH = false;
    this.KNL = false;
    this.fromScene = 0;
    this.KNM = false;
    this.Kpl = false;
    this.KNO = false;
    this.KNP = false;
    this.Kdw = -1;
    this.KNS = Boolean.FALSE;
    this.KNT = false;
    this.KNU = false;
    this.KNV = null;
    this.imagePath = null;
    this.KNX = null;
    this.oys = null;
    this.KOc = 0;
    this.KOd = false;
    this.rFr = new int[] { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
    this.KOe = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(194823);
        paramAnonymousMenuItem = SelectConversationUI.this;
        boolean bool;
        if (!SelectConversationUI.a(SelectConversationUI.this))
        {
          bool = true;
          SelectConversationUI.b(paramAnonymousMenuItem, bool);
          SelectConversationUI.this.fId().yn(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.this.KmT.yn(SelectConversationUI.a(SelectConversationUI.this));
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
          AppMethodBeat.o(194823);
          return true;
          bool = false;
          break;
        }
      }
    };
    this.KOf = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(194824);
        if (SelectConversationUI.q(SelectConversationUI.this))
        {
          AppMethodBeat.o(194824);
          return false;
        }
        paramAnonymousMenuItem = SelectConversationUI.r(SelectConversationUI.this).iterator();
        while (paramAnonymousMenuItem.hasNext())
        {
          localObject = (String)paramAnonymousMenuItem.next();
          if (SelectConversationUI.this.aXt((String)localObject))
          {
            AppMethodBeat.o(194824);
            return false;
          }
        }
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Conv_User", bt.m(SelectConversationUI.r(SelectConversationUI.this), ","));
        Object localObject = (Intent)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject != null) {
          SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem, (Intent)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(194824);
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
  
  private void Zm()
  {
    AppMethodBeat.i(39393);
    if (!this.KNT)
    {
      AppMethodBeat.o(39393);
      return;
    }
    if ((this.KNV != null) && (this.KNV.size() > 0))
    {
      updateOptionMenuText(1, fKW() + "(" + this.KNV.size() + ")");
      updateOptionMenuListener(1, this.KOf, null);
      enableOptionMenu(1, true);
      AppMethodBeat.o(39393);
      return;
    }
    if (!this.KNU)
    {
      updateOptionMenuText(1, getString(2131755819));
      updateOptionMenuListener(1, this.KOe, null);
      enableOptionMenu(1, true);
      if (this.vIo != null) {
        this.vIo.setVisibility(8);
      }
      fIf();
      AppMethodBeat.o(39393);
      return;
    }
    updateOptionMenuText(1, getString(2131755897));
    updateOptionMenuListener(1, this.KOe, null);
    enableOptionMenu(1, true);
    if (this.vIo != null) {
      this.vIo.setVisibility(0);
    }
    fIg();
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
    ((com.tencent.mm.loader.c.e.a)localObject1).heb = true;
    ((com.tencent.mm.loader.c.e.a)localObject1).hea = true;
    ((com.tencent.mm.loader.c.e.a)localObject1).hen = true;
    Object localObject2 = ((com.tencent.mm.loader.c.e.a)localObject1).arf();
    localObject1 = View.inflate(this, 2131495425, null);
    View localView = ((View)localObject1).findViewById(2131299997);
    Object localObject3 = (ImageView)localView.findViewById(2131299971);
    Object localObject4 = com.tencent.mm.loader.e.hcm;
    com.tencent.mm.loader.e.aqF().a(bt.nullAsNil(paramb.inc.sjU), (ImageView)localObject3, (com.tencent.mm.loader.c.e)localObject2);
    localObject2 = (TextView)localView.findViewById(2131300017);
    ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.inc.nickname));
    al.a(((TextView)localObject2).getPaint(), 0.8F);
    localObject4 = (ImageView)localView.findViewById(2131300076);
    localObject2 = (ImageView)localView.findViewById(2131300006);
    localObject3 = (TextView)localView.findViewById(2131299988);
    if (paramb.inc.Gpi == 1)
    {
      ((ImageView)localObject4).setVisibility(8);
      localObject4 = (TextView)localView.findViewById(2131300075);
      ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.inc.desc));
      ((TextView)localObject4).setVisibility(0);
      ((TextView)localObject3).setVisibility(8);
      label223:
      if ((paramb.inc.Gpi != 4) && (paramb.inc.Gpi != 6)) {
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
      if (paramb.inc.mediaList.size() > 0) {
        ((com.tencent.mm.plugin.i.a.t)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.t.class)).loadImage(((ari)paramb.inc.mediaList.get(0)).thumbUrl, (ImageView)localObject4);
      }
      if (bt.isNullOrNil(paramb.inc.desc)) {
        break;
      }
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.inc.desc));
      break label223;
      label368:
      if ((paramb.inc.Gpi == 2) && (paramb.inc.mediaList.size() > 1)) {
        ((ImageView)localObject2).setImageResource(2131232357);
      }
    }
  }
  
  private void a(final Intent paramIntent, o.a parama, final HashMap<String, Object> paramHashMap, boolean paramBoolean, String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(180098);
    String str1 = ci.c(paramHashMap.get("app_id"), null);
    int i = ci.getInt(paramHashMap.get("pkg_type"), 0);
    int j = ci.getInt(paramHashMap.get("pkg_version"), 0);
    String str2 = ci.c(paramHashMap.get("cache_key"), null);
    String str3 = ci.c(paramHashMap.get("path"), null);
    String str4 = ci.c(paramHashMap.get("delay_load_img_path"), null);
    Object localObject2 = ci.c(paramHashMap.get("nickname"), "");
    boolean bool2 = ci.bW(paramHashMap.get("is_dynamic"));
    int k = ci.getInt(paramHashMap.get("subType"), 0);
    int m = ci.getInt(paramHashMap.get("biz"), k.a.hzJ.ordinal());
    String str5;
    Object localObject1;
    if (k.a.isValid(m))
    {
      str5 = ci.c(paramHashMap.get("tail_lang"), "");
      String str6 = ci.c(paramHashMap.get("icon_url"), "");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_biz", m);
      ((Bundle)localObject1).putString("key_footer_text_default", (String)localObject2);
      ((Bundle)localObject1).putString("key_footer_text", k.a.b(m, str5, getContext()));
      ((Bundle)localObject1).putString("key_footer_icon", str6);
      ad.d("MicroMsg.SelectConversationUI", "defaultFooterTxt: %s, tailLang: %s.", new Object[] { localObject2, str5 });
      localObject2 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class);
      if (paramString3 != null) {
        break label745;
      }
    }
    label745:
    for (boolean bool1 = false;; bool1 = w.zq(paramString3))
    {
      paramString3 = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool1, new k.c()
      {
        public final void aDI()
        {
          AppMethodBeat.i(194809);
          paramIntent.putExtra("KShowTodoIntroduceView", 1);
          e.a(SelectConversationUI.this, null);
          AppMethodBeat.o(194809);
        }
        
        public final void ez(boolean paramAnonymousBoolean) {}
      });
      localObject1 = n.cG(this);
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
        paramString1 = ci.c(paramHashMap.get("video_path"), "");
        paramHashMap = ci.c(paramHashMap.get("video_thumb_path"), "");
        ((Bundle)localObject2).putBoolean("is_video", true);
        ((Bundle)localObject2).putString("video_path", paramString1);
        ((Bundle)localObject2).putString("video_thumb_path", paramHashMap);
      }
      paramHashMap = new f(this);
      paramHashMap.KOY = new f.a()
      {
        public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(194810);
          paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
          if (paramAnonymousBoolean1)
          {
            paramIntent.putExtra("custom_send_text", paramAnonymousString);
            SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
            SelectConversationUI.this.finish();
          }
          for (;;)
          {
            ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.kgO, paramString3);
            AppMethodBeat.o(194810);
            return;
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            SelectConversationUI.this.finish();
          }
        }
      };
      ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a((String)localObject1, paramString3, (Bundle)localObject2, new com.tencent.mm.modelappbrand.k.b()
      {
        public final void oM(int paramAnonymousInt)
        {
          AppMethodBeat.i(194811);
          ad.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramHashMap.fLj();
          AppMethodBeat.o(194811);
        }
      });
      parama.fT(paramString3);
      parama.l(Boolean.TRUE);
      parama.fcC();
      parama.naV = new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(194812);
          ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.kgO, paramString3);
          AppMethodBeat.o(194812);
        }
      };
      parama.EVV = fKW();
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(194813);
          SelectConversationUI.this.hideVKB();
          Object localObject = paramString3.getTag(2131296837);
          f localf = paramHashMap;
          if (localObject == null) {}
          for (boolean bool = false;; bool = ((Boolean)localObject).booleanValue())
          {
            localf.a(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt, bool);
            AppMethodBeat.o(194813);
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
        localObject2 = ci.c(paramHashMap.get("footer_icon"), "");
        str5 = ci.c(paramHashMap.get("footer_text"), "");
        ((Bundle)localObject1).putString("key_footer_icon", (String)localObject2);
        ((Bundle)localObject1).putString("key_footer_text", str5);
        break;
      }
      ad.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(m) });
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
      paramIntent.putExtra("received_card_name", bt.m(paramList, ","));
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
        public final void cxz()
        {
          AppMethodBeat.i(39338);
          Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", SelectConversationUI.j(SelectConversationUI.this));
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.kd(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39338);
        }
      });
      AppMethodBeat.o(39378);
      return;
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(39339);
          ad.i("MicroMsg.SelectConversationUI", "[ImageGalleryUI] showImgGallery");
          Object localObject = new Intent(SelectConversationUI.this.getContext(), ImageGalleryUI.class);
          ((Intent)localObject).putExtra("img_gallery_msg_id", SelectConversationUI.l(SelectConversationUI.this));
          ((Intent)localObject).putExtra("img_gallery_msg_svr_id", SelectConversationUI.m(SelectConversationUI.this).field_msgSvrId);
          ((Intent)localObject).putExtra("img_gallery_talker", SelectConversationUI.m(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_gallery_chatroom_name", SelectConversationUI.m(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_preview_only", true);
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.kd(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39339);
        }
      });
      AppMethodBeat.o(39378);
      return;
      ba.aBQ();
      if (com.tencent.mm.model.c.azs() == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      ba.aBQ();
      Object localObject = com.tencent.mm.model.c.azs().aql(this.dDP);
      parama.a(new d.a.b()
      {
        public final void cxz()
        {
          AppMethodBeat.i(180090);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          localIntent.putExtra("kwebmap_slat", this.KOm.uZr);
          localIntent.putExtra("kwebmap_lng", this.KOm.uZs);
          localIntent.putExtra("Kwebmap_locaion", this.KOn);
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.bs.d.b(SelectConversationUI.this.getContext(), "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(180090);
        }
      });
      AppMethodBeat.o(39378);
      return;
      localObject = com.tencent.mm.ai.k.b.yr(bt.aRd(this.dDP));
      if (localObject == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      if (((((com.tencent.mm.ai.k.b)localObject).type == 5) && (!l.f(this.dBd, this.Kdw))) || (((com.tencent.mm.ai.k.b)localObject).type == 69))
      {
        parama.a(new d.a.b()
        {
          public final void cxz()
          {
            AppMethodBeat.i(39340);
            if (bt.isNullOrNil(this.val$url))
            {
              AppMethodBeat.o(39340);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", this.val$url);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.bs.d.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(39340);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ai.k.b)localObject).type == 6)
      {
        parama.a(new d.a.b()
        {
          public final void cxz()
          {
            AppMethodBeat.i(39341);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.l(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/transmit/SelectConversationUI$26", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$26", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(39341);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ai.k.b)localObject).type == 24)
      {
        parama.a(new d.a.b()
        {
          public final void cxz()
          {
            AppMethodBeat.i(39342);
            oh localoh = new oh();
            localoh.dCh.context = SelectConversationUI.this.getContext();
            localoh.dCh.msgId = SelectConversationUI.l(SelectConversationUI.this);
            localoh.dCh.dCi = this.liN.hAs;
            localoh.dCh.dBt = false;
            localoh.dCh.scene = 7;
            com.tencent.mm.sdk.b.a.IbL.l(localoh);
            AppMethodBeat.o(39342);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ai.k.b)localObject).type == 19)
      {
        parama.a(new d.a.b()
        {
          public final void cxz()
          {
            AppMethodBeat.i(39343);
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.l(SelectConversationUI.this));
            localIntent.putExtra("record_xml", this.liN.hAs);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.bs.d.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(39343);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ai.k.b)localObject).type == 3)
      {
        parama.a(new d.a.b()
        {
          public final void cxz()
          {
            AppMethodBeat.i(180091);
            Object localObject2 = com.tencent.mm.pluginsdk.model.app.q.Q(this.liN.url, "message");
            String str = com.tencent.mm.pluginsdk.model.app.q.Q(this.liN.hzN, "message");
            Object localObject1;
            if (ay.isMobile(SelectConversationUI.this.getContext()))
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
              com.tencent.mm.bs.d.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
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
      if (((com.tencent.mm.ai.k.b)localObject).type == 4)
      {
        parama.a(new d.a.b()
        {
          public final void cxz()
          {
            AppMethodBeat.i(180092);
            AppMethodBeat.o(180092);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if ((((com.tencent.mm.ai.k.b)localObject).type == 53) || (((com.tencent.mm.ai.k.b)localObject).type == 57))
      {
        parama.a(new d.a.b()
        {
          public final void cxz()
          {
            AppMethodBeat.i(180093);
            Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
            ((Intent)localObject).putExtra("Retr_Msg_content", this.liN.title);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.kd(SelectConversationUI.this.getContext());
            AppMethodBeat.o(180093);
          }
        });
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void cxz()
          {
            AppMethodBeat.i(194819);
            Object localObject = com.tencent.mm.ui.chatting.k.kj(SelectConversationUI.this.getContext());
            localObject = com.tencent.mm.ai.k.b.yr(bt.aRd(com.tencent.mm.plugin.record.b.p.a(((qh)localObject).dEO.dEV.title, ((qh)localObject).dEO.dEV.desc, ((qh)localObject).dEO.dEg.dnG.dnI, ((qh)localObject).dEN.dET, SelectConversationUI.l(SelectConversationUI.this))));
            if (localObject == null)
            {
              AppMethodBeat.o(194819);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.l(SelectConversationUI.this));
            localIntent.putExtra("record_xml", ((com.tencent.mm.ai.k.b)localObject).hAs);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.bs.d.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(194819);
          }
        });
        AppMethodBeat.o(39378);
        return;
        com.tencent.mm.ui.chatting.k.kj(getContext());
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void cxz()
          {
            AppMethodBeat.i(194820);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.l(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(194820);
          }
        });
      }
    }
  }
  
  private void a(o.a parama, String paramString)
  {
    AppMethodBeat.i(39371);
    ba.aBQ();
    com.tencent.mm.model.c.azp().aTj(paramString);
    String str = v.zf(paramString);
    if (!bt.isNullOrNil(this.KNR)) {
      str = this.KNR;
    }
    parama.aMS(aXw(paramString) + str);
    AppMethodBeat.o(39371);
  }
  
  private boolean a(final Intent paramIntent, final o.a parama, final String paramString)
  {
    AppMethodBeat.i(180097);
    Object localObject = (HashMap)getIntent().getSerializableExtra("appbrand_params");
    boolean bool1 = ci.bW(((HashMap)localObject).get("is_weishi_video"));
    final boolean bool2 = ci.bW(((HashMap)localObject).get("is_video"));
    if (bool1)
    {
      bool1 = a(parama, (HashMap)localObject);
      AppMethodBeat.o(180097);
      return bool1;
    }
    int i = ci.getInt(((HashMap)localObject).get("type"), 1);
    final String str2 = ci.c(((HashMap)localObject).get("title"), "");
    final String str1 = ci.c(((HashMap)localObject).get("img_url"), null);
    int j = ci.getInt(((HashMap)localObject).get("biz"), k.a.hzJ.ordinal());
    if ((!k.a.isValid(j)) && ((i == 2) || (i == 3)))
    {
      if ((paramString != null) && (y.Yd()) && (w.zq(paramString)) && (ax.aQz("group_to_do").getBoolean("introduce_dialog_first", true)))
      {
        ax.aQz("group_to_do").edit().putBoolean("introduce_dialog_first", false);
        e.a(this, new e.a()
        {
          public final void fHo()
          {
            AppMethodBeat.i(180080);
            paramIntent.putExtra("KShowTodoIntroduceView", 1);
            SelectConversationUI.a(SelectConversationUI.this, paramIntent, parama, this.KOi, bool2, str1, str2, paramString);
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
      localObject = ci.c(((HashMap)localObject).get("nickname"), null);
      if (bt.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        parama.aMS(paramString + str2);
        paramString = new f(this);
        paramString.KOY = new f.a()
        {
          public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(194805);
            paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
            if (paramAnonymousBoolean1)
            {
              paramIntent.putExtra("custom_send_text", paramAnonymousString);
              SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
              SelectConversationUI.this.finish();
              AppMethodBeat.o(194805);
              return;
            }
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            SelectConversationUI.this.finish();
            AppMethodBeat.o(194805);
          }
        };
        com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
        {
          public final String BM()
          {
            AppMethodBeat.i(194808);
            String str = n.cG(this);
            AppMethodBeat.o(194808);
            return str;
          }
          
          public final void E(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(194806);
            paramString.fLj();
            AppMethodBeat.o(194806);
          }
          
          public final void aEd() {}
          
          public final void ox()
          {
            AppMethodBeat.i(194807);
            paramString.fLj();
            AppMethodBeat.o(194807);
          }
        }, str1, com.tencent.mm.modelappbrand.a.g.hLC);
        parama.l(Boolean.TRUE);
        parama.EVV = fKW();
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
        paramString = bt.x(getResources().getString(2131756223), new Object[] { localObject });
      }
    }
    parama.aMS(getResources().getString(2131755375) + str2);
    parama.aMT(str1).fcB();
    parama.l(Boolean.TRUE);
    AppMethodBeat.o(180097);
    return false;
  }
  
  private boolean a(o.a parama, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(39377);
    final String str = ci.c(paramHashMap.get("img_url"), null);
    if (!bt.isNullOrNil(str))
    {
      paramHashMap = new RelativeLayout(this);
      View localView = LayoutInflater.from(this).inflate(2131493585, null);
      paramHashMap.addView(localView, new RelativeLayout.LayoutParams(-2, -2));
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(14);
      final ImageView localImageView = (ImageView)localView.findViewById(2131302310);
      ((ImageView)localView.findViewById(2131300961)).setImageResource(2131691361);
      parama.fT(paramHashMap);
      parama.fcC();
      com.tencent.mm.modelappbrand.a.b.aDV().a(new b.k()
      {
        public final String BM()
        {
          return "SelectConversationUI#WEISHITHUMB";
        }
        
        public final void E(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(194814);
          if ((!SelectConversationUI.this.isFinishing()) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()) && (localImageView != null))
          {
            paramAnonymousBitmap = an.c(SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBitmap, localImageView, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight()), aq.fromDPToPix(SelectConversationUI.this, 3));
            localImageView.setImageBitmap(paramAnonymousBitmap);
          }
          AppMethodBeat.o(194814);
        }
        
        public final void aEd() {}
        
        public final void ox()
        {
          AppMethodBeat.i(194815);
          ad.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", new Object[] { str });
          AppMethodBeat.o(194815);
        }
      }, str, null, null);
    }
    for (;;)
    {
      parama.l(Boolean.TRUE);
      AppMethodBeat.o(39377);
      return false;
      paramHashMap = ci.c(paramHashMap.get("msg_img_path"), null);
      if (!bt.isNullOrNil(paramHashMap))
      {
        ad.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", new Object[] { str, paramHashMap });
        parama.i(aXx(paramHashMap), 2);
      }
    }
  }
  
  private static boolean aXs(String paramString)
  {
    AppMethodBeat.i(39364);
    if (am.aSQ(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    if (w.zl(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    AppMethodBeat.o(39364);
    return false;
  }
  
  private void aXu(String paramString)
  {
    AppMethodBeat.i(39366);
    try
    {
      Object localObject = bt.U(paramString.split(","));
      paramString = new StringBuffer();
      localObject = ((List)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!bt.isNullOrNil(str))
        {
          if (i != 0) {
            paramString.append(",");
          }
          paramString.append(v.zf(str));
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
  
  private void aXv(String paramString)
  {
    AppMethodBeat.i(39367);
    ad.i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", new Object[] { paramString, this.KNZ, Integer.valueOf(this.KOa) });
    ad.i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", new Object[] { this.KOb });
    ((com.tencent.mm.choosemsgfile.compat.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.a.class)).a(this, paramString, this.KNZ, this.KOa, this.KOb, new a.a()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, ArrayList<MsgFile> paramAnonymousArrayList)
      {
        AppMethodBeat.i(39351);
        ad.i("MicroMsg.SelectConversationUI", "resultCode:%d filePaths:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousArrayList });
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
  
  private String aXw(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(39372);
    ba.aBQ();
    am localam = com.tencent.mm.model.c.azp().aTj(paramString);
    Object localObject = getResources().getString(2131755784);
    if (localam == null)
    {
      AppMethodBeat.o(39372);
      return localObject;
    }
    ba.aBQ();
    localObject = com.tencent.mm.model.c.azs().aqk(this.dDP);
    int i = j;
    if (localObject != null) {
      if (!w.on(((bu.a)localObject).DKi))
      {
        i = j;
        if (!localam.fqg()) {}
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
      if (am.aSQ(paramString)) {
        paramString = c(this, localam);
      } else {
        paramString = getResources().getString(2131755784);
      }
    }
  }
  
  private static Bitmap aXx(String paramString)
  {
    AppMethodBeat.i(39383);
    localBitmap2 = com.tencent.mm.aw.q.aIF().Fo(paramString);
    localBitmap1 = localBitmap2;
    if (localBitmap2 != null) {}
    try
    {
      int j = Exif.fromFile(paramString).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap1 = com.tencent.mm.sdk.platformtools.g.a(localBitmap2, i);
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.SelectConversationUI", paramString, "unexpected exception.", new Object[0]);
        localBitmap1 = localBitmap2;
      }
    }
    AppMethodBeat.o(39383);
    return localBitmap1;
  }
  
  private void b(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(39374);
    ad.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=".concat(String.valueOf(paramIntent2)));
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
    com.tencent.mm.ai.k.b localb;
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
            parama.aMS(this.dDP);
            parama.fcA();
            AppMethodBeat.o(180099);
            return;
            localObject1 = fKZ();
            paramString = (String)localObject1;
            if (localObject1 == null)
            {
              paramString = (String)localObject1;
              if (this.imagePath != null)
              {
                float f = com.tencent.mm.cc.a.getDensity(aj.getContext());
                paramString = com.tencent.mm.sdk.platformtools.g.a(this.imagePath, 140, 140, f);
                int j = Exif.fromFile(this.imagePath).getOrientationInDegree();
                i = j;
                if (j < 0) {
                  i = 0;
                }
                paramString = com.tencent.mm.sdk.platformtools.g.a(paramString, i);
              }
            }
            parama.i(paramString, 3);
            AppMethodBeat.o(180099);
            return;
            parama.i(fKY(), 2);
            AppMethodBeat.o(180099);
            return;
            parama.i(fKY(), 2);
            AppMethodBeat.o(180099);
            return;
            parama.aMS(fKX());
            AppMethodBeat.o(180099);
            return;
            if (!bt.isNullOrNil(this.emojiMD5))
            {
              parama.aMU(this.emojiMD5);
              AppMethodBeat.o(180099);
              return;
            }
            if (!bt.isNullOrNil(this.dBd.field_imgPath))
            {
              parama.aMU(this.dBd.field_imgPath);
              AppMethodBeat.o(180099);
              return;
            }
            parama.aMU(this.imagePath);
            AppMethodBeat.o(180099);
            return;
            ba.aBQ();
            paramString = com.tencent.mm.model.c.azs().aqk(this.dDP);
            this.KNQ = paramString.dHm;
            this.KNR = paramString.nickname;
            this.KNS = Boolean.valueOf(w.on(paramString.DKi));
            a(parama, this.KNQ);
            AppMethodBeat.o(180099);
            return;
            paramString = (com.tencent.mm.plugin.finder.api.d)com.tencent.mm.ai.k.b.yr(bt.aRd(this.dDP)).ao(com.tencent.mm.plugin.finder.api.d.class);
          } while (paramString == null);
          parama.aMS(getString(2131755776) + paramString.title);
          AppMethodBeat.o(180099);
          return;
          paramString = (com.tencent.mm.plugin.i.a.b)com.tencent.mm.ai.k.b.yr(bt.aRd(this.dDP)).ao(com.tencent.mm.plugin.i.a.b.class);
          if (paramString != null) {
            parama.fT(a(paramString));
          }
          parama.fcC();
          AppMethodBeat.o(180099);
          return;
          paramString = (com.tencent.mm.plugin.i.a.a)com.tencent.mm.ai.k.b.yr(bt.aRd(this.dDP)).ao(com.tencent.mm.plugin.i.a.a.class);
        } while (paramString == null);
        parama.aMS(getString(2131755777) + paramString.nickname);
        AppMethodBeat.o(180099);
        return;
        paramString = (com.tencent.mm.plugin.i.a.c)com.tencent.mm.ai.k.b.yr(bt.aRd(this.dDP)).ao(com.tencent.mm.plugin.i.a.c.class);
      } while ((paramString == null) || (paramString.ind == null));
      localObject1 = getString(2131755775);
      if (paramString.ind.sMj == 1) {}
      for (paramString = (String)localObject1 + getString(2131759380, new Object[] { paramString.ind.dzZ });; paramString = (String)localObject1 + paramString.ind.dzZ)
      {
        parama.aMS(paramString);
        AppMethodBeat.o(180099);
        return;
      }
    case 2: 
    case 10: 
      localb = com.tencent.mm.ai.k.b.yr(bt.aRd(this.dDP));
      if ((this.dBd.fpd()) && (localb == null)) {
        localb = com.tencent.mm.ai.k.b.aA(bt.aRd(this.dDP), bt.aRd(this.dDP));
      }
      break;
    }
    for (;;)
    {
      if (localb == null)
      {
        if (this.KNX != null)
        {
          paramString = getResources().getString(2131755926);
          localObject1 = this.KNX;
          parama.aMS(paramString + (String)localObject1);
        }
        AppMethodBeat.o(180099);
        return;
      }
      localObject1 = localb.title;
      if (l.f(this.dBd, this.Kdw)) {
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
        parama.i(fKZ(), 2);
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
          if (bt.isNullOrNil(localb.dHp)) {
            paramString = getResources().getString(2131755895);
          } else {
            paramString = bt.x(getResources().getString(2131756223), new Object[] { localb.dHp });
          }
        }
        else if ((localb.type == 33) || (localb.type == 36) || (localb.type == 48))
        {
          if ((localb.hCp == 2) || (localb.hCp == 3) || (localb.type == 36) || (localb.type == 48))
          {
            i = localb.hCu;
            if (localb.ev(false))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("key_biz", i);
              ((Bundle)localObject1).putString("key_footer_text_default", localb.dHp);
              ((Bundle)localObject1).putString("key_footer_text", localb.t(getContext(), false));
              ((Bundle)localObject1).putString("key_footer_icon", localb.hCB);
              localObject2 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class);
              if (paramString != null) {
                break label1695;
              }
            }
            label1695:
            for (boolean bool = false;; bool = w.zq(paramString))
            {
              paramString = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool, new k.c()
              {
                public final void aDI()
                {
                  AppMethodBeat.i(194816);
                  SelectConversationUI.k(SelectConversationUI.this);
                  e.a(SelectConversationUI.this, null);
                  AppMethodBeat.o(194816);
                }
                
                public final void ez(boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(194817);
                  SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBoolean);
                  AppMethodBeat.o(194817);
                }
              });
              parama.fT(paramString);
              parama.l(Boolean.TRUE);
              parama.fcC();
              Object localObject3 = com.tencent.mm.aw.q.aIF().c(this.dBd.field_imgPath, false, true);
              localObject1 = n.cG(this);
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("app_id", localb.hCo);
              ((Bundle)localObject2).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(localb.hCz), Integer.valueOf(localb.hCr) }));
              ((Bundle)localObject2).putInt("msg_pkg_type", localb.hCz);
              ((Bundle)localObject2).putInt("pkg_version", localb.hCr);
              if (!bt.isNullOrNil((String)localObject3)) {
                ((Bundle)localObject2).putString("image_url", "file://".concat(String.valueOf(localObject3)));
              }
              localObject3 = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
              if (localObject3 != null)
              {
                ((Bundle)localObject2).putBoolean("is_dynamic_page", ((com.tencent.mm.ai.a)localObject3).hxV);
                ((Bundle)localObject2).putString("cache_key", ((com.tencent.mm.ai.a)localObject3).hxW);
                ((Bundle)localObject2).putInt("sub_type", ((com.tencent.mm.ai.a)localObject3).hyk);
              }
              ((Bundle)localObject2).putString("title", localb.title);
              ((Bundle)localObject2).putString("msg_path", localb.hCm);
              ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a((String)localObject1, paramString, (Bundle)localObject2);
              parama.naV = new DialogInterface.OnDismissListener()
              {
                public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(194818);
                  ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.kgO, paramString);
                  AppMethodBeat.o(194818);
                }
              };
              AppMethodBeat.o(180099);
              return;
              if (localb.type == 48)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putBoolean("is_video", true);
                ((Bundle)localObject1).putString("key_footer_icon", localb.hCB);
                ((Bundle)localObject1).putString("key_footer_text", localb.dHp);
                break;
              }
              ad.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(i) });
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
          parama.aMS(getResources().getString(2131758001) + paramString.bVF);
          if (!bt.isNullOrNil(paramString.iconUrl)) {
            parama.aMT(paramString.iconUrl).fcB();
          }
        }
        AppMethodBeat.o(180099);
        return;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      parama.aMS(paramString + (String)localObject2);
      if (localb.thumburl == null) {
        break;
      }
      parama.aMT(localb.thumburl).fcB();
      AppMethodBeat.o(180099);
      return;
      paramString = bt.bI(com.tencent.mm.ui.chatting.k.kj(getContext()).dEO.dEV.title, "");
      parama.aMS(getResources().getString(2131755818) + paramString);
      AppMethodBeat.o(180099);
      return;
      paramString = com.tencent.mm.ui.chatting.k.kj(getContext());
      if (paramString.dEN.dES != null) {}
      for (i = paramString.dEN.dES.size();; i = 0)
      {
        paramString = getContext().getString(2131762561, new Object[] { Integer.valueOf(i) });
        parama.aMS(getResources().getString(2131755817) + paramString);
        AppMethodBeat.o(180099);
        return;
        if (this.oys == null) {
          break;
        }
        parama.aMS(getResources().getString(2131755773) + this.oys);
        break;
      }
    }
  }
  
  public static String c(Context paramContext, am paramam)
  {
    AppMethodBeat.i(39373);
    paramam = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramam.field_openImAppid, "openim_card_type_name", b.a.iHt);
    if (TextUtils.isEmpty(paramam)) {}
    for (paramContext = paramContext.getResources().getString(2131755784);; paramContext = String.format("[%s]", new Object[] { paramam }))
    {
      AppMethodBeat.o(39373);
      return paramContext;
    }
  }
  
  private String fKW()
  {
    AppMethodBeat.i(169904);
    String str2 = getIntent().getStringExtra("KSendWording");
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = getString(2131755884);
    }
    AppMethodBeat.o(169904);
    return str1;
  }
  
  private String fKX()
  {
    AppMethodBeat.i(39380);
    ba.aBQ();
    bu.b localb = com.tencent.mm.model.c.azs().aql(this.dDP);
    String str = "";
    if (localb != null) {
      str = localb.label;
    }
    str = getContext().getString(2131755806) + str;
    AppMethodBeat.o(39380);
    return str;
  }
  
  private Bitmap fKY()
  {
    AppMethodBeat.i(39381);
    com.tencent.mm.modelvideo.o.aMJ();
    Object localObject = com.tencent.mm.modelvideo.t.Hi(this.dBd.field_imgPath);
    if (localObject == null)
    {
      localObject = this.imagePath;
      if (!com.tencent.mm.plugin.a.c.Ja(this.imagePath))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.Gq((String)localObject);
        AppMethodBeat.o(39381);
        return localObject;
      }
      localObject = com.tencent.mm.sdk.platformtools.g.aQf((String)localObject);
      AppMethodBeat.o(39381);
      return localObject;
    }
    localObject = com.tencent.mm.sdk.platformtools.g.aQf((String)localObject);
    AppMethodBeat.o(39381);
    return localObject;
  }
  
  private Bitmap fKZ()
  {
    AppMethodBeat.i(39382);
    if (this.dBd == null)
    {
      AppMethodBeat.o(39382);
      return null;
    }
    String str = this.dBd.field_imgPath;
    localBitmap3 = com.tencent.mm.aw.q.aIF().Fo(str);
    Bitmap localBitmap1 = localBitmap3;
    if (localBitmap3 != null) {}
    try
    {
      int j = Exif.fromFile(str).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap1 = com.tencent.mm.sdk.platformtools.g.a(localBitmap3, i);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.SelectConversationUI", localThrowable, "unexpected exception.", new Object[0]);
        Bitmap localBitmap2 = localBitmap3;
      }
    }
    AppMethodBeat.o(39382);
    return localBitmap1;
  }
  
  private void fLa()
  {
    AppMethodBeat.i(39386);
    ad.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 14);
    localIntent.putExtra("titile", getString(2131755234));
    localIntent.putExtra("list_attr", u.KnD);
    localIntent.putExtra("already_select_contact", bt.m(this.KNV, ","));
    localIntent.putExtra("max_limit_num", 9);
    if ((this.Kpl) && (am.aSQ(this.KNQ))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 5);
      AppMethodBeat.o(39386);
      return;
    }
  }
  
  private void fLb()
  {
    boolean bool = true;
    AppMethodBeat.i(39387);
    ad.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", u.KnA);
    localIntent.putExtra("list_type", 3);
    localIntent.putExtra("be_send_card_name", this.KNQ);
    localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
    localIntent.putExtra("Add_SendCard", true);
    localIntent.putExtra("titile", getString(2131755234));
    if ((this.Kpl) && (am.aSQ(this.KNQ))) {}
    for (;;)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 3);
      AppMethodBeat.o(39387);
      return;
      bool = false;
    }
  }
  
  private void fLc()
  {
    AppMethodBeat.i(39388);
    ad.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 5);
    localIntent.putExtra("titile", getString(2131755234));
    if (((this.fromScene != 4) && (this.fromScene != 9)) || ((getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || (this.fromScene == 10)))
    {
      localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
      localIntent.putExtra("list_attr", u.I(new int[] { 32, 16, 1, 2, 4, 16384 }));
    }
    for (;;)
    {
      getContext().startActivityForResult(localIntent, 1);
      AppMethodBeat.o(39388);
      return;
      if ((this.KNP) && (!this.KNS.booleanValue()))
      {
        localIntent.putExtra("list_attr", u.I(new int[] { 16, 1, 2, 4, 16384 }));
        localIntent.putExtra("without_openim", true);
        localIntent.putExtra("KBlockOpenImFav", true);
      }
      else
      {
        localIntent.putExtra("list_attr", u.KnC);
      }
    }
  }
  
  private static String o(com.tencent.mm.ai.k.b paramb)
  {
    AppMethodBeat.i(39385);
    Object localObject1 = new qh();
    ((qh)localObject1).dEN.type = 0;
    ((qh)localObject1).dEN.dEP = paramb.hAs;
    com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
    com.tencent.mm.protocal.b.a.c localc = ((qh)localObject1).dEO.dEY;
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localc != null)
    {
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = bt.bI(localc.desc, paramb.description);
      }
    }
    paramb = (com.tencent.mm.ai.k.b)localObject1;
    if (!bt.isNullOrNil((String)localObject1)) {
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
    if (aXt(paramString))
    {
      AppMethodBeat.o(39375);
      return;
    }
    if (u.hasAttr(this.iVz, 256))
    {
      r(-1, paramIntent);
      finish();
      AppMethodBeat.o(39375);
      return;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
      AppMethodBeat.o(39375);
      return;
    }
    if (w.vF(paramString))
    {
      int i = com.tencent.mm.model.q.yS(paramString);
      if (this.KNO)
      {
        int j = bt.getInt(com.tencent.mm.n.g.acA().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50);
        if (i > j)
        {
          ad.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          com.tencent.mm.ui.base.h.c(this, getString(2131762995, new Object[] { Integer.valueOf(j) }), "", true);
          AppMethodBeat.o(39375);
          return;
        }
      }
      getString(2131762993, new Object[] { Integer.valueOf(i) });
    }
    o.a locala = new o.a(getContext());
    locala.dP(paramString);
    if (this.Kpl)
    {
      a(locala, this.KNQ);
      if (w.vF(paramString))
      {
        b(paramIntent, this.KNQ, paramString);
        locala.l(Boolean.TRUE);
      }
    }
    for (;;)
    {
      locala.EVV = fKW();
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
              ad.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", new Object[] { Integer.valueOf(13943), Integer.valueOf(paramAnonymousInt) });
              com.tencent.mm.plugin.report.service.g.yhR.f(13943, new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            com.tencent.mm.pluginsdk.ui.tools.o.lB(SelectConversationUI.j(SelectConversationUI.this), paramString);
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
              ba.aBQ();
              com.tencent.mm.model.c.azv().aTx(paramAnonymousString);
            }
          }
        }
      }.show();
      AppMethodBeat.o(39375);
      return;
      a(paramIntent, this.KNQ, paramString);
      break;
      Object localObject;
      if (this.KNG)
      {
        if ((getIntent().hasExtra("appbrand_params")) && (a(paramIntent, locala, null)))
        {
          AppMethodBeat.o(39375);
          return;
        }
        if (this.dnC != -1L)
        {
          a(locala);
          localObject = new gs();
          ((gs)localObject).dsJ.dnC = this.dnC;
          ((gs)localObject).dsJ.dsK = this.dsK;
          ((gs)localObject).dsJ.dsL = this.msgType;
          ((gs)localObject).dsJ.dsM = locala;
          ((gs)localObject).dsJ.dsN = this.KNY;
          ((gs)localObject).dsJ.dkO = getContext();
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        }
        for (;;)
        {
          locala.l(Boolean.TRUE);
          break;
          if ((this.msgType == 17) && (this.KNN != 0))
          {
            localObject = getContext().getString(2131762561, new Object[] { Integer.valueOf(this.KNN) });
            locala.aMS(getResources().getString(2131755817) + (String)localObject);
          }
        }
      }
      String str1;
      if ((this.KNH) && (!this.rCH))
      {
        localObject = (HashMap)getIntent().getSerializableExtra("webview_params");
        str1 = (String)((HashMap)localObject).get("img_url");
        String str3 = (String)((HashMap)localObject).get("title");
        final String str2 = (String)((HashMap)localObject).get("url");
        if (!this.KNL) {}
        for (localObject = getResources().getString(2131755920) + str3;; localObject = getResources().getString(2131758001) + (String)localObject)
        {
          locala.aMS((String)localObject);
          locala.a(new d.a.b()
          {
            public final void cxz()
            {
              AppMethodBeat.i(39352);
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", str2);
              localIntent.putExtra("showShare", false);
              com.tencent.mm.bs.d.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
              AppMethodBeat.o(39352);
            }
          });
          locala.aMT(str1).fcB();
          locala.l(Boolean.TRUE);
          break;
          localObject = (String)((HashMap)localObject).get("nickname");
        }
      }
      if ((this.KNI) && (a(paramIntent, locala, paramString)))
      {
        AppMethodBeat.o(39375);
        return;
      }
      if (this.KNK)
      {
        str1 = getResources().getString(2131755788);
        localObject = str1;
        if (this.oys != null) {
          localObject = str1 + this.oys;
        }
        locala.aMS((String)localObject);
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
  
  private boolean yE(boolean paramBoolean)
  {
    AppMethodBeat.i(39394);
    if (paramBoolean)
    {
      if (this.KNV.size() < 9) {}
    }
    else {
      while (this.KNV.size() > 9)
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
      this.KNV.remove(paramString);
      fId().notifyDataSetChanged();
      Zm();
    }
    AppMethodBeat.o(39391);
  }
  
  public final void Zd()
  {
    AppMethodBeat.i(39356);
    super.Zd();
    this.KNF = getIntent().getBooleanExtra("select_is_ret", false);
    this.fromScene = getIntent().getIntExtra("scene_from", 0);
    ad.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    if (this.fromScene == 1) {
      this.KNG = true;
    }
    for (;;)
    {
      this.rCH = getIntent().getBooleanExtra("is_mp_video", false);
      this.KNL = getIntent().getBooleanExtra("is_game_card", false);
      this.KNM = getIntent().getBooleanExtra("send_to_biz", false);
      this.Kdw = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.dnC = getIntent().getLongExtra("select_fav_local_id", -1L);
      this.dsK = getIntent().getStringExtra("select_fav_fake_local_id");
      this.KNN = getIntent().getIntExtra("select_fav_select_count", 0);
      this.KNT = getIntent().getBooleanExtra("mutil_select_is_ret", false);
      this.Kpl = getIntent().getBooleanExtra("Select_Send_Card", false);
      this.KNP = getIntent().getBooleanExtra("forward_card", false);
      this.KNO = getIntent().getBooleanExtra("Retr_Big_File", false);
      if (this.Kpl) {
        this.KNQ = getIntent().getStringExtra("Select_Talker_Name");
      }
      this.iVz = getIntent().getIntExtra("Select_Conv_Type", KND);
      this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
      this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      ba.aBQ();
      this.dBd = com.tencent.mm.model.c.azs().xY(this.msgId);
      this.imagePath = getIntent().getStringExtra("image_path");
      this.KNX = getIntent().getStringExtra("ad_video_title");
      this.oys = getIntent().getStringExtra("desc_title");
      this.emojiMD5 = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.dDP = getIntent().getStringExtra("Retr_Msg_content");
      this.KNY = getIntent().getStringExtra("Retr_fav_xml_str");
      if ((this.dDP == null) && (this.dBd != null)) {
        this.dDP = this.dBd.field_content;
      }
      if (this.dDP == null) {
        this.dDP = "";
      }
      this.KNW = ((ReportUtil.ReportArgs)getIntent().getParcelableExtra("Select_Report_Args"));
      this.KNZ = getIntent().getStringExtra("KChooseMsgFileType");
      this.KOa = getIntent().getIntExtra("KChooseMsgFileCount", 9);
      this.KOb = getIntent().getStringExtra("KChooseMsgFileExtension");
      Object localObject1 = new HashSet();
      ((HashSet)localObject1).addAll(u.fIp());
      Object localObject2 = getIntent().getStringExtra("Select_block_List");
      if (!bt.isNullOrNil((String)localObject2)) {
        ((HashSet)localObject1).addAll(bt.U(((String)localObject2).split(",")));
      }
      if (u.hasAttr(this.iVz, 2))
      {
        localObject2 = u.fIq();
        u.i((HashSet)localObject2);
        ((HashSet)localObject1).addAll((Collection)localObject2);
      }
      this.fSL = new ArrayList();
      this.fSL.addAll((Collection)localObject1);
      localObject1 = this.fSL;
      long l = System.currentTimeMillis();
      int i = ((List)localObject1).size();
      ((List)localObject1).addAll(com.tencent.mm.pluginsdk.i.d.far());
      ad.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(((List)localObject1).size() - i) });
      if (u.hasAttr(this.iVz, 1)) {
        this.Knh = true;
      }
      if (this.KNT)
      {
        this.KNV = new LinkedList();
        if (this.KNT)
        {
          addTextOptionMenu(1, getString(2131755819), this.KOe, null, s.b.JbS);
          Zm();
        }
      }
      AppMethodBeat.o(39356);
      return;
      if ((this.fromScene != 2) && (this.fromScene != 10))
      {
        if (this.fromScene == 3)
        {
          getIntent();
          boolean bool = ci.bW(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("is_h5"));
          if (bool) {
            ad.i("MicroMsg.SelectConversationUI", "hy: is H5 link");
          }
          if (!bool) {}
        }
      }
      else
      {
        this.KNH = true;
        continue;
      }
      if (this.fromScene == 3) {
        this.KNI = true;
      } else if (this.fromScene == 6) {
        this.KNJ = true;
      } else if (this.fromScene == 7) {
        this.KNK = true;
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
    if (this.JvZ == null)
    {
      if (!this.Kpl) {
        break label134;
      }
      this.KNE = 2131763014;
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
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/transmit/SelectConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (SelectConversationUI.a(SelectConversationUI.this)) {
            SelectConversationUI.b(SelectConversationUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(39335);
            return;
            paramAnonymousView = SelectConversationUI.this.getIntent().getStringExtra("Select_App_Id");
            if ((SelectConversationUI.c(SelectConversationUI.this)) && (bt.isNullOrNil(paramAnonymousView))) {
              SelectConversationUI.d(SelectConversationUI.this);
            } else {
              SelectConversationUI.e(SelectConversationUI.this);
            }
          }
        }
      };
      String str = getString(this.KNE);
      View localView = z.jO(this).inflate(2131494420, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131298778);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.JvZ = ((TextView)localObject);
      this.JvZ.setVisibility(paramInt);
      AppMethodBeat.o(39359);
      return;
      label134:
      if (this.fromScene == 10) {
        this.KNE = 2131761807;
      } else {
        this.KNE = 2131763002;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39390);
    if ((parama.KmP) && (parama.contact != null))
    {
      boolean bool = this.KNV.contains(parama.contact.field_username);
      AppMethodBeat.o(39390);
      return bool;
    }
    AppMethodBeat.o(39390);
    return false;
  }
  
  public final boolean aRu()
  {
    return (!this.KNT) || (!this.KNU);
  }
  
  public final boolean aRv()
  {
    return false;
  }
  
  public final String aRw()
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
  
  public final com.tencent.mm.ui.contact.q aRx()
  {
    AppMethodBeat.i(39357);
    ab localab = new ab(this, this.fSL, this.Knh, this.KNU, this.KNM, this.iVz);
    AppMethodBeat.o(39357);
    return localab;
  }
  
  public final com.tencent.mm.ui.contact.o aRy()
  {
    AppMethodBeat.i(39358);
    s locals = new s(this, this.fSL, this.KNU, this.scene);
    AppMethodBeat.o(39358);
    return locals;
  }
  
  public final boolean aXt(String paramString)
  {
    AppMethodBeat.i(39365);
    if (!aXs(paramString))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if ((!bt.isNullOrNil(getIntent().getStringExtra("Select_App_Id"))) && (this.Kpl))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if (this.Kpl)
    {
      ba.aBQ();
      if (am.aaR(com.tencent.mm.model.c.azp().aTj(this.KNQ).field_verifyFlag))
      {
        aXu(paramString);
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
    ba.aBQ();
    String str = com.tencent.mm.model.c.azs().aqk(this.dDP).dHm;
    ba.aBQ();
    if (w.on(com.tencent.mm.model.c.azp().aTj(str).field_verifyFlag))
    {
      aXu(paramString);
      AppMethodBeat.o(39365);
      return true;
    }
    AppMethodBeat.o(39365);
    return false;
  }
  
  protected final void awy(String paramString)
  {
    AppMethodBeat.i(169903);
    ad.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (aXt(paramString))
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
      if ((this.KNF) || (this.Kpl) || (this.KNG) || (this.KNH) || (this.KNI) || (this.rCH))
      {
        w(localIntent1, paramString);
      }
      else if (this.fromScene == 11)
      {
        aXv(paramString);
      }
      else
      {
        r(-1, localIntent1);
        finish();
      }
    }
  }
  
  public final int[] djJ()
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
    arrayOfInt = super.djJ();
    AppMethodBeat.o(39395);
    return arrayOfInt;
  }
  
  public final void djK()
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
      if (this.KNW != null)
      {
        this.KNW.errCode = 0;
        ReportUtil.a(this, this.KNW, true);
      }
      AppMethodBeat.o(39360);
      return;
      super.djK();
      hideVKB();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(39363);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ad.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    Object localObject1;
    Object localObject2;
    while (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        ad.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
        localObject2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject2 != null)
        {
          if (aXt((String)localObject1))
          {
            AppMethodBeat.o(39363);
            return;
            ad.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
          }
          else
          {
            b(paramIntent, (Intent)localObject2);
            AppMethodBeat.o(39363);
          }
        }
        else
        {
          if ((this.KNF) || (this.Kpl) || (this.KNG) || (this.KNH) || (this.KNI))
          {
            w(paramIntent, (String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          if (this.fromScene == 11)
          {
            aXv((String)localObject1);
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
        com.tencent.e.h.LTJ.r(new Runnable()
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
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahp(), "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ReportUtil.V(false, 0);
          AppMethodBeat.o(39363);
          return;
        }
        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getBooleanExtra("Select_back_to_app", false)))
        {
          ReportUtil.a(this, ReportUtil.d(paramIntent.getExtras(), 0), false);
          AppMethodBeat.o(39363);
          return;
          if (paramIntent != null) {
            this.KNW = ((ReportUtil.ReportArgs)paramIntent.getParcelableExtra("Select_Report_Args"));
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
          if ((!bt.isNullOrNil(paramIntent)) && (!aXt(paramIntent)))
          {
            localObject1 = new o.a(getContext());
            ((o.a)localObject1).dP(paramIntent);
            a((o.a)localObject1, this.KNQ);
            localObject1 = ((o.a)localObject1).l(Boolean.TRUE);
            ((o.a)localObject1).EVV = fKW();
            {
              public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
              {
                AppMethodBeat.i(39350);
                SelectConversationUI.this.hideVKB();
                Intent localIntent;
                if (paramAnonymousBoolean)
                {
                  localIntent = new Intent();
                  if (!w.vF(paramIntent)) {
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
        localObject1 = this.KNV.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.vIo.aMy((String)localObject2);
        }
        if (!bt.isNullOrNil(paramIntent)) {
          this.KNV = bt.U(paramIntent.split(","));
        }
        for (;;)
        {
          paramIntent = this.KNV.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.vIo.aMz((String)localObject1);
          }
          this.KNV.clear();
        }
        Zm();
        fId().notifyDataSetChanged();
      }
      AppMethodBeat.o(39363);
      return;
    }
    ad.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(39363);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39361);
    super.djK();
    AppMethodBeat.o(39361);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39355);
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Select_App_Id");
    String str = getIntent().getStringExtra("Select_Open_Id");
    ad.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + paramBundle + ", openId = " + str);
    if ((!bt.isNullOrNil(paramBundle)) && (!bt.isNullOrNil(str))) {
      new com.tencent.mm.plugin.base.stub.d(this, paramBundle, str, new d.a()
      {
        public final void jc(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(39323);
          boolean bool = SelectConversationUI.this.isFinishing();
          ad.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + paramAnonymousBoolean + ", isFinishing = " + bool);
          if ((!paramAnonymousBoolean) && (!bool))
          {
            ReportUtil.ReportArgs localReportArgs = (ReportUtil.ReportArgs)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Report_Args");
            ReportUtil.a(SelectConversationUI.this, localReportArgs, false);
            SelectConversationUI.this.finish();
          }
          AppMethodBeat.o(39323);
        }
      }).bMa();
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
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(39362);
    int i;
    Object localObject2;
    if (this.KNU)
    {
      i = paramInt - getContentLV().getHeaderViewsCount();
      if (i < 0)
      {
        ad.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
        fLa();
        AppMethodBeat.o(39362);
        return;
      }
      localObject1 = fId();
      localObject2 = ((com.tencent.mm.ui.contact.p)localObject1).aen(i);
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
      ad.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[] { localObject2 });
      if ((!this.KNV.contains(localObject2)) && (yE(true)))
      {
        fIk();
        AppMethodBeat.o(39362);
        return;
      }
      fIk();
      this.vIo.aMx((String)localObject2);
      if (this.KNV.contains(localObject2)) {
        this.KNV.remove(localObject2);
      }
      for (;;)
      {
        Zm();
        ((com.tencent.mm.ui.contact.p)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(39362);
        return;
        this.KNV.add(localObject2);
      }
    }
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ad.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      if (this.Kpl)
      {
        fLb();
        AppMethodBeat.o(39362);
        return;
      }
      fLc();
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
      ad.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("list_attr", 16384);
      com.tencent.mm.bs.d.b(this, "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject1, 4);
      this.KNH = true;
      AppMethodBeat.o(39362);
      return;
    }
    if ((localObject1 instanceof com.tencent.mm.ui.contact.a.g))
    {
      Object localObject3 = (com.tencent.mm.ui.contact.a.g)localObject1;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("scene", this.scene);
      localObject2 = new ArrayList();
      localObject3 = ((com.tencent.mm.ui.contact.a.a)localObject3).tun.tuN;
      i = localObject3.length;
      paramInt = 0;
      while (paramInt < i)
      {
        ((ArrayList)localObject2).add(localObject3[paramInt]);
        paramInt += 1;
      }
      ((Intent)localObject1).putExtra("query_phrase_list", (Serializable)localObject2);
      com.tencent.mm.bs.d.c(this, ".ui.transmit.MMCreateChatroomUI", (Intent)localObject1, 1);
      AppMethodBeat.o(39362);
      return;
    }
    localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact;
    if (localObject1 == null)
    {
      AppMethodBeat.o(39362);
      return;
    }
    awy(((aw)localObject1).field_username);
    AppMethodBeat.o(39362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI
 * JD-Core Version:    0.7.0.1
 */