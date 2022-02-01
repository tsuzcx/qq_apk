package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
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
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.a;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.pn.a;
import com.tencent.mm.g.a.pn.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.appbrand.aa.m;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.storage.bl.b;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.a.d.a.b;
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
  private static final int Hwc;
  private int GMW;
  private boolean GWl;
  private boolean GYn;
  private TextView Git;
  private int HwA;
  private boolean HwB;
  private MenuItem.OnMenuItemClickListener HwC;
  private MenuItem.OnMenuItemClickListener HwD;
  private int Hwd;
  private boolean Hwe;
  private boolean Hwf;
  private boolean Hwg;
  private boolean Hwh;
  private boolean Hwi;
  private boolean Hwj;
  private boolean Hwk;
  private int Hwl;
  private boolean Hwm;
  private boolean Hwn;
  private String Hwo;
  private String Hwp;
  private Boolean Hwq;
  private boolean Hwr;
  private boolean Hws;
  private List<String> Hwt;
  private ReportUtil.ReportArgs Hwu;
  private String Hwv;
  private String Hww;
  private String Hwx;
  private int Hwy;
  private String Hwz;
  private long deL;
  private String djR;
  private bl drF;
  private String duk;
  private String emojiMD5;
  private int fromScene;
  private List<String> fvP;
  private int ici;
  private String imagePath;
  private long msgId;
  private int msgType;
  private String nrX;
  boolean qkc;
  private int[] qmB;
  
  static
  {
    AppMethodBeat.i(39409);
    Hwc = u.I(new int[] { 1, 2 });
    AppMethodBeat.o(39409);
  }
  
  public SelectConversationUI()
  {
    AppMethodBeat.i(39354);
    this.Hwe = false;
    this.Hwf = false;
    this.Hwg = false;
    this.Hwh = false;
    this.Hwi = false;
    this.Hwj = false;
    this.qkc = false;
    this.fromScene = 0;
    this.Hwk = false;
    this.GYn = false;
    this.Hwm = false;
    this.Hwn = false;
    this.GMW = -1;
    this.Hwq = Boolean.FALSE;
    this.Hwr = false;
    this.Hws = false;
    this.Hwt = null;
    this.imagePath = null;
    this.Hwv = null;
    this.nrX = null;
    this.HwA = 0;
    this.HwB = false;
    this.qmB = new int[] { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
    this.HwC = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191855);
        paramAnonymousMenuItem = SelectConversationUI.this;
        boolean bool;
        if (!SelectConversationUI.a(SelectConversationUI.this))
        {
          bool = true;
          SelectConversationUI.b(paramAnonymousMenuItem, bool);
          SelectConversationUI.this.fbz().wu(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.this.GVX.wu(SelectConversationUI.a(SelectConversationUI.this));
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
          AppMethodBeat.o(191855);
          return true;
          bool = false;
          break;
        }
      }
    };
    this.HwD = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(191856);
        if (SelectConversationUI.q(SelectConversationUI.this))
        {
          AppMethodBeat.o(191856);
          return false;
        }
        paramAnonymousMenuItem = SelectConversationUI.r(SelectConversationUI.this).iterator();
        while (paramAnonymousMenuItem.hasNext())
        {
          localObject = (String)paramAnonymousMenuItem.next();
          if (SelectConversationUI.this.aLT((String)localObject))
          {
            AppMethodBeat.o(191856);
            return false;
          }
        }
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Conv_User", bt.n(SelectConversationUI.r(SelectConversationUI.this), ","));
        Object localObject = (Intent)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject != null) {
          SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem, (Intent)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(191856);
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
  
  private void VV()
  {
    AppMethodBeat.i(39393);
    if (!this.Hwr)
    {
      AppMethodBeat.o(39393);
      return;
    }
    if ((this.Hwt != null) && (this.Hwt.size() > 0))
    {
      updateOptionMenuText(1, feo() + "(" + this.Hwt.size() + ")");
      updateOptionMenuListener(1, this.HwD, null);
      enableOptionMenu(1, true);
      AppMethodBeat.o(39393);
      return;
    }
    if (!this.Hws)
    {
      updateOptionMenuText(1, getString(2131755819));
      updateOptionMenuListener(1, this.HwC, null);
      enableOptionMenu(1, true);
      if (this.twW != null) {
        this.twW.setVisibility(8);
      }
      fbB();
      AppMethodBeat.o(39393);
      return;
    }
    updateOptionMenuText(1, getString(2131755897));
    updateOptionMenuListener(1, this.HwC, null);
    enableOptionMenu(1, true);
    if (this.twW != null) {
      this.twW.setVisibility(0);
    }
    fbC();
    AppMethodBeat.o(39393);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39384);
    Object localObject = null;
    float f = paramInt2 / paramInt1;
    int k = 0;
    int j = 0;
    int m = ao.ap(paramContext, 2131165260);
    paramInt1 = ao.ap(paramContext, 2131165259);
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
    ((com.tencent.mm.loader.c.e.a)localObject1).gjE = true;
    ((com.tencent.mm.loader.c.e.a)localObject1).gjD = true;
    ((com.tencent.mm.loader.c.e.a)localObject1).gjP = true;
    Object localObject2 = ((com.tencent.mm.loader.c.e.a)localObject1).ahr();
    localObject1 = View.inflate(this, 2131495425, null);
    View localView = ((View)localObject1).findViewById(2131299997);
    Object localObject3 = (ImageView)localView.findViewById(2131299971);
    Object localObject4 = com.tencent.mm.loader.e.ghT;
    com.tencent.mm.loader.e.agS().a(bt.nullAsNil(paramb.htg.qDs), (ImageView)localObject3, (com.tencent.mm.loader.c.e)localObject2);
    ((TextView)localView.findViewById(2131300017)).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.htg.nickname));
    localObject4 = (ImageView)localView.findViewById(2131300076);
    localObject2 = (ImageView)localView.findViewById(2131300006);
    localObject3 = (TextView)localView.findViewById(2131299988);
    if (paramb.htg.Dmx == 1)
    {
      ((ImageView)localObject4).setVisibility(8);
      localObject4 = (TextView)localView.findViewById(2131300075);
      ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.htg.desc));
      ((TextView)localObject4).setVisibility(0);
      ((TextView)localObject3).setVisibility(8);
      label208:
      if ((paramb.htg.Dmx != 4) && (paramb.htg.Dmx != 6)) {
        break label352;
      }
      ((ImageView)localObject2).setImageResource(2131232379);
      ((ImageView)localObject2).setVisibility(0);
    }
    for (;;)
    {
      localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      AppMethodBeat.o(163387);
      return localObject1;
      if (paramb.htg.mediaList.size() > 0) {
        ((j)com.tencent.mm.kernel.g.ad(j.class)).loadImage(((alc)paramb.htg.mediaList.get(0)).thumbUrl, (ImageView)localObject4);
      }
      if (bt.isNullOrNil(paramb.htg.desc)) {
        break;
      }
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.htg.desc));
      break label208;
      label352:
      if ((paramb.htg.Dmx == 2) && (paramb.htg.mediaList.size() > 1))
      {
        ((ImageView)localObject2).setImageResource(2131232357);
        ((ImageView)localObject2).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject2).setVisibility(8);
      }
    }
  }
  
  private void a(final Intent paramIntent, o.a parama, final HashMap<String, Object> paramHashMap, boolean paramBoolean, String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(180098);
    String str1 = ch.c(paramHashMap.get("app_id"), null);
    int i = ch.getInt(paramHashMap.get("pkg_type"), 0);
    int j = ch.getInt(paramHashMap.get("pkg_version"), 0);
    String str2 = ch.c(paramHashMap.get("cache_key"), null);
    String str3 = ch.c(paramHashMap.get("path"), null);
    String str4 = ch.c(paramHashMap.get("delay_load_img_path"), null);
    Object localObject2 = ch.c(paramHashMap.get("nickname"), "");
    boolean bool2 = ch.bW(paramHashMap.get("is_dynamic"));
    int k = ch.getInt(paramHashMap.get("subType"), 0);
    int m = ch.getInt(paramHashMap.get("biz"), k.a.gGZ.ordinal());
    String str5;
    Object localObject1;
    if (k.a.isValid(m))
    {
      str5 = ch.c(paramHashMap.get("tail_lang"), "");
      String str6 = ch.c(paramHashMap.get("icon_url"), "");
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
    for (boolean bool1 = false;; bool1 = w.sr(paramString3))
    {
      paramString3 = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool1, new k.c()
      {
        public final void atO()
        {
          AppMethodBeat.i(191841);
          paramIntent.putExtra("KShowTodoIntroduceView", 1);
          e.a(SelectConversationUI.this, null);
          AppMethodBeat.o(191841);
        }
        
        public final void ec(boolean paramAnonymousBoolean) {}
      });
      localObject1 = m.cF(this);
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
        paramString1 = ch.c(paramHashMap.get("video_path"), "");
        paramHashMap = ch.c(paramHashMap.get("video_thumb_path"), "");
        ((Bundle)localObject2).putBoolean("is_video", true);
        ((Bundle)localObject2).putString("video_path", paramString1);
        ((Bundle)localObject2).putString("video_thumb_path", paramHashMap);
      }
      paramHashMap = new f(this);
      paramHashMap.Hxw = new f.a()
      {
        public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(191842);
          paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
          if (paramAnonymousBoolean1)
          {
            paramIntent.putExtra("custom_send_text", paramAnonymousString);
            SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
            SelectConversationUI.this.finish();
          }
          for (;;)
          {
            ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.jmq, paramString3);
            AppMethodBeat.o(191842);
            return;
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            SelectConversationUI.this.finish();
          }
        }
      };
      ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a((String)localObject1, paramString3, (Bundle)localObject2, new com.tencent.mm.modelappbrand.k.b()
      {
        public final void ny(int paramAnonymousInt)
        {
          AppMethodBeat.i(191843);
          ad.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramHashMap.feB();
          AppMethodBeat.o(191843);
        }
      });
      parama.fr(paramString3);
      parama.i(Boolean.TRUE);
      parama.eyj();
      parama.lYl = new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(191844);
          ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.jmq, paramString3);
          AppMethodBeat.o(191844);
        }
      };
      parama.BYB = feo();
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(191845);
          SelectConversationUI.this.hideVKB();
          Object localObject = paramString3.getTag(2131296837);
          f localf = paramHashMap;
          if (localObject == null) {}
          for (boolean bool = false;; bool = ((Boolean)localObject).booleanValue())
          {
            localf.a(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt, bool);
            AppMethodBeat.o(191845);
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
        localObject2 = ch.c(paramHashMap.get("footer_icon"), "");
        str5 = ch.c(paramHashMap.get("footer_text"), "");
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
      paramIntent.putExtra("received_card_name", bt.n(paramList, ","));
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
        public final void ckg()
        {
          AppMethodBeat.i(39338);
          Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", SelectConversationUI.j(SelectConversationUI.this));
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.jH(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39338);
        }
      });
      AppMethodBeat.o(39378);
      return;
      parama.a(new d.a.b()
      {
        public final void ckg()
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.jH(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39339);
        }
      });
      AppMethodBeat.o(39378);
      return;
      az.arV();
      if (com.tencent.mm.model.c.apO() == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      az.arV();
      Object localObject = com.tencent.mm.model.c.apO().agD(this.duk);
      parama.a(new d.a.b()
      {
        public final void ckg()
        {
          AppMethodBeat.i(180090);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          localIntent.putExtra("kwebmap_slat", this.HwK.sOv);
          localIntent.putExtra("kwebmap_lng", this.HwK.sOw);
          localIntent.putExtra("Kwebmap_locaion", this.HwL);
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.bs.d.b(SelectConversationUI.this.getContext(), "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(180090);
        }
      });
      AppMethodBeat.o(39378);
      return;
      localObject = com.tencent.mm.ai.k.b.rx(bt.aGg(this.duk));
      if (localObject == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      if ((((com.tencent.mm.ai.k.b)localObject).type == 5) && (!l.f(this.drF, this.GMW)))
      {
        parama.a(new d.a.b()
        {
          public final void ckg()
          {
            AppMethodBeat.i(39340);
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
          public final void ckg()
          {
            AppMethodBeat.i(39341);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.l(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/transmit/SelectConversationUI$26", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
          public final void ckg()
          {
            AppMethodBeat.i(39342);
            nq localnq = new nq();
            localnq.dsK.context = SelectConversationUI.this.getContext();
            localnq.dsK.msgId = SelectConversationUI.l(SelectConversationUI.this);
            localnq.dsK.dsL = this.kkS.gHI;
            localnq.dsK.drV = false;
            localnq.dsK.scene = 7;
            com.tencent.mm.sdk.b.a.ESL.l(localnq);
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
          public final void ckg()
          {
            AppMethodBeat.i(39343);
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.l(SelectConversationUI.this));
            localIntent.putExtra("record_xml", this.kkS.gHI);
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
          public final void ckg()
          {
            AppMethodBeat.i(180091);
            Object localObject2 = com.tencent.mm.pluginsdk.model.app.q.O(this.kkS.url, "message");
            String str = com.tencent.mm.pluginsdk.model.app.q.O(this.kkS.gHd, "message");
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
          public final void ckg()
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
          public final void ckg()
          {
            AppMethodBeat.i(180093);
            Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
            ((Intent)localObject).putExtra("Retr_Msg_content", this.kkS.title);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.jH(SelectConversationUI.this.getContext());
            AppMethodBeat.o(180093);
          }
        });
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void ckg()
          {
            AppMethodBeat.i(191851);
            Object localObject = com.tencent.mm.ui.chatting.k.jN(SelectConversationUI.this.getContext());
            localObject = com.tencent.mm.ai.k.b.rx(bt.aGg(n.a(((pn)localObject).dvc.dvj.title, ((pn)localObject).dvc.dvj.desc, ((pn)localObject).dvc.duB.deQ.deS, ((pn)localObject).dvb.dvh, SelectConversationUI.l(SelectConversationUI.this))));
            if (localObject == null)
            {
              AppMethodBeat.o(191851);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.l(SelectConversationUI.this));
            localIntent.putExtra("record_xml", ((com.tencent.mm.ai.k.b)localObject).gHI);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.bs.d.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(191851);
          }
        });
        AppMethodBeat.o(39378);
        return;
        com.tencent.mm.ui.chatting.k.jN(getContext());
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void ckg()
          {
            AppMethodBeat.i(191852);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.l(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(191852);
          }
        });
      }
    }
  }
  
  private void a(o.a parama, String paramString)
  {
    AppMethodBeat.i(39371);
    az.arV();
    com.tencent.mm.model.c.apM().aHW(paramString);
    String str = v.sh(paramString);
    if (!bt.isNullOrNil(this.Hwp)) {
      str = this.Hwp;
    }
    parama.aBX(aLW(paramString) + str);
    AppMethodBeat.o(39371);
  }
  
  private boolean a(final Intent paramIntent, final o.a parama, final String paramString)
  {
    AppMethodBeat.i(180097);
    Object localObject = (HashMap)getIntent().getSerializableExtra("appbrand_params");
    boolean bool1 = ch.bW(((HashMap)localObject).get("is_weishi_video"));
    final boolean bool2 = ch.bW(((HashMap)localObject).get("is_video"));
    if (bool1)
    {
      bool1 = a(parama, (HashMap)localObject);
      AppMethodBeat.o(180097);
      return bool1;
    }
    int i = ch.getInt(((HashMap)localObject).get("type"), 1);
    final String str2 = ch.c(((HashMap)localObject).get("title"), "");
    final String str1 = ch.c(((HashMap)localObject).get("img_url"), null);
    int j = ch.getInt(((HashMap)localObject).get("biz"), k.a.gGZ.ordinal());
    if ((!k.a.isValid(j)) && ((i == 2) || (i == 3)))
    {
      if ((paramString != null) && (com.tencent.mm.chatroom.d.y.UQ()) && (w.sr(paramString)) && (ax.aFC("group_to_do").getBoolean("introduce_dialog_first", true)))
      {
        ax.aFC("group_to_do").edit().putBoolean("introduce_dialog_first", false);
        e.a(this, new e.a()
        {
          public final void faL()
          {
            AppMethodBeat.i(180080);
            paramIntent.putExtra("KShowTodoIntroduceView", 1);
            SelectConversationUI.a(SelectConversationUI.this, paramIntent, parama, this.HwG, bool2, str1, str2, paramString);
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
      localObject = ch.c(((HashMap)localObject).get("nickname"), null);
      if (bt.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        parama.aBX(paramString + str2);
        paramString = new f(this);
        paramString.Hxw = new f.a()
        {
          public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(191837);
            paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
            if (paramAnonymousBoolean1)
            {
              paramIntent.putExtra("custom_send_text", paramAnonymousString);
              SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
              SelectConversationUI.this.finish();
              AppMethodBeat.o(191837);
              return;
            }
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            SelectConversationUI.this.finish();
            AppMethodBeat.o(191837);
          }
        };
        com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
        {
          public final String AL()
          {
            AppMethodBeat.i(191840);
            String str = m.cF(this);
            AppMethodBeat.o(191840);
            return str;
          }
          
          public final void E(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(191838);
            paramString.feB();
            AppMethodBeat.o(191838);
          }
          
          public final void auj() {}
          
          public final void nV()
          {
            AppMethodBeat.i(191839);
            paramString.feB();
            AppMethodBeat.o(191839);
          }
        }, str1, com.tencent.mm.modelappbrand.a.g.gSK);
        parama.i(Boolean.TRUE);
        parama.BYB = feo();
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
        paramString = bt.u(getResources().getString(2131756223), new Object[] { localObject });
      }
    }
    parama.aBX(getResources().getString(2131755375) + str2);
    parama.aBY(str1).eyi();
    parama.i(Boolean.TRUE);
    AppMethodBeat.o(180097);
    return false;
  }
  
  private boolean a(o.a parama, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(39377);
    final String str = ch.c(paramHashMap.get("img_url"), null);
    if (!bt.isNullOrNil(str))
    {
      paramHashMap = new RelativeLayout(this);
      View localView = LayoutInflater.from(this).inflate(2131493585, null);
      paramHashMap.addView(localView, new RelativeLayout.LayoutParams(-2, -2));
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(14);
      final ImageView localImageView = (ImageView)localView.findViewById(2131302310);
      ((ImageView)localView.findViewById(2131300961)).setImageResource(2131691361);
      parama.fr(paramHashMap);
      parama.eyj();
      com.tencent.mm.modelappbrand.a.b.aub().a(new b.k()
      {
        public final String AL()
        {
          return "SelectConversationUI#WEISHITHUMB";
        }
        
        public final void E(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(191846);
          if ((!SelectConversationUI.this.isFinishing()) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()) && (localImageView != null))
          {
            paramAnonymousBitmap = al.c(SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBitmap, localImageView, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight()), ao.fromDPToPix(SelectConversationUI.this, 3));
            localImageView.setImageBitmap(paramAnonymousBitmap);
          }
          AppMethodBeat.o(191846);
        }
        
        public final void auj() {}
        
        public final void nV()
        {
          AppMethodBeat.i(191847);
          ad.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", new Object[] { str });
          AppMethodBeat.o(191847);
        }
      }, str, null, null);
    }
    for (;;)
    {
      parama.i(Boolean.TRUE);
      AppMethodBeat.o(39377);
      return false;
      paramHashMap = ch.c(paramHashMap.get("msg_img_path"), null);
      if (!bt.isNullOrNil(paramHashMap))
      {
        ad.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", new Object[] { str, paramHashMap });
        parama.i(aLX(paramHashMap), 2);
      }
    }
  }
  
  private static boolean aLS(String paramString)
  {
    AppMethodBeat.i(39364);
    if (af.aHH(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    if (w.sn(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    AppMethodBeat.o(39364);
    return false;
  }
  
  private void aLU(String paramString)
  {
    AppMethodBeat.i(39366);
    try
    {
      Object localObject = bt.S(paramString.split(","));
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
          paramString.append(v.sh(str));
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
  
  private void aLV(String paramString)
  {
    AppMethodBeat.i(39367);
    ad.i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", new Object[] { paramString, this.Hwx, Integer.valueOf(this.Hwy) });
    ad.i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", new Object[] { this.Hwz });
    ((com.tencent.mm.choosemsgfile.compat.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.a.class)).a(this, paramString, this.Hwx, this.Hwy, this.Hwz, new a.a()
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
  
  private String aLW(String paramString)
  {
    AppMethodBeat.i(39372);
    az.arV();
    af localaf = com.tencent.mm.model.c.apM().aHW(paramString);
    Object localObject = getResources().getString(2131755784);
    if (localaf == null)
    {
      AppMethodBeat.o(39372);
      return localObject;
    }
    az.arV();
    localObject = com.tencent.mm.model.c.apO().agC(this.duk);
    boolean bool = false;
    if (localObject != null) {
      bool = w.mZ(((bl.a)localObject).AOL);
    }
    if (bool) {
      paramString = getResources().getString(2131755783);
    }
    for (;;)
    {
      AppMethodBeat.o(39372);
      return paramString;
      if (af.aHH(paramString)) {
        paramString = c(this, localaf);
      } else {
        paramString = getResources().getString(2131755784);
      }
    }
  }
  
  private static Bitmap aLX(String paramString)
  {
    AppMethodBeat.i(39383);
    localBitmap2 = com.tencent.mm.aw.o.ayF().yh(paramString);
    localBitmap1 = localBitmap2;
    if (localBitmap2 != null) {}
    try
    {
      int j = Exif.fromFile(paramString).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap1 = com.tencent.mm.sdk.platformtools.f.a(localBitmap2, i);
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
    com.tencent.mm.ui.base.b.W(getContext(), paramIntent2);
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
            parama.aBX(this.duk);
            parama.eyh();
            AppMethodBeat.o(180099);
            return;
            localObject1 = fer();
            paramString = (String)localObject1;
            if (localObject1 == null)
            {
              paramString = (String)localObject1;
              if (this.imagePath != null)
              {
                float f = com.tencent.mm.cd.a.getDensity(aj.getContext());
                paramString = com.tencent.mm.sdk.platformtools.f.a(this.imagePath, 140, 140, f);
                int j = Exif.fromFile(this.imagePath).getOrientationInDegree();
                i = j;
                if (j < 0) {
                  i = 0;
                }
                paramString = com.tencent.mm.sdk.platformtools.f.a(paramString, i);
              }
            }
            parama.i(paramString, 3);
            AppMethodBeat.o(180099);
            return;
            parama.i(feq(), 2);
            AppMethodBeat.o(180099);
            return;
            parama.i(feq(), 2);
            AppMethodBeat.o(180099);
            return;
            parama.aBX(fep());
            AppMethodBeat.o(180099);
            return;
            if (!bt.isNullOrNil(this.emojiMD5))
            {
              parama.aBZ(this.emojiMD5);
              AppMethodBeat.o(180099);
              return;
            }
            if (!bt.isNullOrNil(this.drF.field_imgPath))
            {
              parama.aBZ(this.drF.field_imgPath);
              AppMethodBeat.o(180099);
              return;
            }
            parama.aBZ(this.imagePath);
            AppMethodBeat.o(180099);
            return;
            az.arV();
            paramString = com.tencent.mm.model.c.apO().agC(this.duk);
            this.Hwo = paramString.yGA;
            this.Hwp = paramString.nickname;
            this.Hwq = Boolean.valueOf(w.mZ(paramString.AOL));
            a(parama, this.Hwo);
            AppMethodBeat.o(180099);
            return;
            paramString = (com.tencent.mm.plugin.finder.api.c)com.tencent.mm.ai.k.b.rx(bt.aGg(this.duk)).ao(com.tencent.mm.plugin.finder.api.c.class);
          } while (paramString == null);
          parama.aBX(getString(2131755776) + paramString.title);
          AppMethodBeat.o(180099);
          return;
          paramString = (com.tencent.mm.plugin.i.a.b)com.tencent.mm.ai.k.b.rx(bt.aGg(this.duk)).ao(com.tencent.mm.plugin.i.a.b.class);
          if (paramString != null) {
            parama.fr(a(paramString));
          }
          parama.eyj();
          AppMethodBeat.o(180099);
          return;
          paramString = (com.tencent.mm.plugin.i.a.a)com.tencent.mm.ai.k.b.rx(bt.aGg(this.duk)).ao(com.tencent.mm.plugin.i.a.a.class);
        } while (paramString == null);
        parama.aBX(getString(2131755777) + paramString.nickname);
        AppMethodBeat.o(180099);
        return;
        paramString = (com.tencent.mm.plugin.i.a.c)com.tencent.mm.ai.k.b.rx(bt.aGg(this.duk)).ao(com.tencent.mm.plugin.i.a.c.class);
      } while ((paramString == null) || (paramString.hth == null));
      localObject1 = getString(2131755775);
      if (paramString.hth.qSS == 1) {}
      for (paramString = (String)localObject1 + getString(2131759380, new Object[] { paramString.hth.dqA });; paramString = (String)localObject1 + paramString.hth.dqA)
      {
        parama.aBX(paramString);
        AppMethodBeat.o(180099);
        return;
      }
    case 2: 
    case 10: 
      localb = com.tencent.mm.ai.k.b.rx(bt.aGg(this.duk));
      if ((this.drF.eJL()) && (localb == null)) {
        localb = com.tencent.mm.ai.k.b.ar(bt.aGg(this.duk), bt.aGg(this.duk));
      }
      break;
    }
    for (;;)
    {
      if (localb == null)
      {
        if (this.Hwv != null)
        {
          paramString = getResources().getString(2131755926);
          localObject1 = this.Hwv;
          parama.aBX(paramString + (String)localObject1);
        }
        AppMethodBeat.o(180099);
        return;
      }
      localObject1 = localb.title;
      if (l.f(this.drF, this.GMW)) {
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
        parama.i(fer(), 2);
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
          localObject1 = n(localb);
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
          if (bt.isNullOrNil(localb.dxA)) {
            paramString = getResources().getString(2131755895);
          } else {
            paramString = bt.u(getResources().getString(2131756223), new Object[] { localb.dxA });
          }
        }
        else if ((localb.type == 33) || (localb.type == 36) || (localb.type == 48))
        {
          if ((localb.gJG == 2) || (localb.gJG == 3) || (localb.type == 36) || (localb.type == 48))
          {
            i = localb.gJL;
            if (localb.dY(false))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("key_biz", i);
              ((Bundle)localObject1).putString("key_footer_text_default", localb.dxA);
              ((Bundle)localObject1).putString("key_footer_text", localb.r(getContext(), false));
              ((Bundle)localObject1).putString("key_footer_icon", localb.gJS);
              localObject2 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class);
              if (paramString != null) {
                break label1695;
              }
            }
            label1695:
            for (boolean bool = false;; bool = w.sr(paramString))
            {
              paramString = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool, new k.c()
              {
                public final void atO()
                {
                  AppMethodBeat.i(191848);
                  SelectConversationUI.k(SelectConversationUI.this);
                  e.a(SelectConversationUI.this, null);
                  AppMethodBeat.o(191848);
                }
                
                public final void ec(boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(191849);
                  SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBoolean);
                  AppMethodBeat.o(191849);
                }
              });
              parama.fr(paramString);
              parama.i(Boolean.TRUE);
              parama.eyj();
              Object localObject3 = com.tencent.mm.aw.o.ayF().b(this.drF.field_imgPath, false, true);
              localObject1 = m.cF(this);
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("app_id", localb.gJF);
              ((Bundle)localObject2).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(localb.gJQ), Integer.valueOf(localb.gJI) }));
              ((Bundle)localObject2).putInt("msg_pkg_type", localb.gJQ);
              ((Bundle)localObject2).putInt("pkg_version", localb.gJI);
              if (!bt.isNullOrNil((String)localObject3)) {
                ((Bundle)localObject2).putString("image_url", "file://".concat(String.valueOf(localObject3)));
              }
              localObject3 = (com.tencent.mm.ai.a)localb.ao(com.tencent.mm.ai.a.class);
              if (localObject3 != null)
              {
                ((Bundle)localObject2).putBoolean("is_dynamic_page", ((com.tencent.mm.ai.a)localObject3).gFm);
                ((Bundle)localObject2).putString("cache_key", ((com.tencent.mm.ai.a)localObject3).gFn);
                ((Bundle)localObject2).putInt("sub_type", ((com.tencent.mm.ai.a)localObject3).gFB);
              }
              ((Bundle)localObject2).putString("title", localb.title);
              ((Bundle)localObject2).putString("msg_path", localb.gJD);
              ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a((String)localObject1, paramString, (Bundle)localObject2);
              parama.lYl = new DialogInterface.OnDismissListener()
              {
                public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(191850);
                  ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.jmq, paramString);
                  AppMethodBeat.o(191850);
                }
              };
              AppMethodBeat.o(180099);
              return;
              if (localb.type == 48)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putBoolean("is_video", true);
                ((Bundle)localObject1).putString("key_footer_icon", localb.gJS);
                ((Bundle)localObject1).putString("key_footer_text", localb.dxA);
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
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      parama.aBX(paramString + (String)localObject2);
      if (localb.thumburl == null) {
        break;
      }
      parama.aBY(localb.thumburl).eyi();
      AppMethodBeat.o(180099);
      return;
      paramString = bt.by(com.tencent.mm.ui.chatting.k.jN(getContext()).dvc.dvj.title, "");
      parama.aBX(getResources().getString(2131755818) + paramString);
      AppMethodBeat.o(180099);
      return;
      paramString = com.tencent.mm.ui.chatting.k.jN(getContext());
      if (paramString.dvb.dvg != null) {}
      for (i = paramString.dvb.dvg.size();; i = 0)
      {
        paramString = getContext().getString(2131762561, new Object[] { Integer.valueOf(i) });
        parama.aBX(getResources().getString(2131755817) + paramString);
        AppMethodBeat.o(180099);
        return;
        if (this.nrX == null) {
          break;
        }
        parama.aBX(getResources().getString(2131755773) + this.nrX);
        break;
      }
    }
  }
  
  public static String c(Context paramContext, af paramaf)
  {
    AppMethodBeat.i(39373);
    paramaf = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramaf.field_openImAppid, "openim_card_type_name", b.a.hNA);
    if (TextUtils.isEmpty(paramaf)) {}
    for (paramContext = paramContext.getResources().getString(2131755784);; paramContext = String.format("[%s]", new Object[] { paramaf }))
    {
      AppMethodBeat.o(39373);
      return paramContext;
    }
  }
  
  private String feo()
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
  
  private String fep()
  {
    AppMethodBeat.i(39380);
    az.arV();
    bl.b localb = com.tencent.mm.model.c.apO().agD(this.duk);
    String str = "";
    if (localb != null) {
      str = localb.label;
    }
    str = getContext().getString(2131755806) + str;
    AppMethodBeat.o(39380);
    return str;
  }
  
  private Bitmap feq()
  {
    AppMethodBeat.i(39381);
    com.tencent.mm.modelvideo.o.aCI();
    Object localObject = t.zR(this.drF.field_imgPath);
    if (localObject == null)
    {
      localObject = this.imagePath;
      if (!com.tencent.mm.plugin.a.c.BH(this.imagePath))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.zg((String)localObject);
        AppMethodBeat.o(39381);
        return localObject;
      }
      localObject = com.tencent.mm.sdk.platformtools.f.aFi((String)localObject);
      AppMethodBeat.o(39381);
      return localObject;
    }
    localObject = com.tencent.mm.sdk.platformtools.f.aFi((String)localObject);
    AppMethodBeat.o(39381);
    return localObject;
  }
  
  private Bitmap fer()
  {
    AppMethodBeat.i(39382);
    if (this.drF == null)
    {
      AppMethodBeat.o(39382);
      return null;
    }
    String str = this.drF.field_imgPath;
    localBitmap3 = com.tencent.mm.aw.o.ayF().yh(str);
    Bitmap localBitmap1 = localBitmap3;
    if (localBitmap3 != null) {}
    try
    {
      int j = Exif.fromFile(str).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap1 = com.tencent.mm.sdk.platformtools.f.a(localBitmap3, i);
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
  
  private void fes()
  {
    AppMethodBeat.i(39386);
    ad.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 14);
    localIntent.putExtra("titile", getString(2131755234));
    localIntent.putExtra("list_attr", u.GWH);
    localIntent.putExtra("already_select_contact", bt.n(this.Hwt, ","));
    localIntent.putExtra("max_limit_num", 9);
    if ((this.GYn) && (af.aHH(this.Hwo))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 5);
      AppMethodBeat.o(39386);
      return;
    }
  }
  
  private void fet()
  {
    boolean bool = true;
    AppMethodBeat.i(39387);
    ad.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", u.GWE);
    localIntent.putExtra("list_type", 3);
    localIntent.putExtra("be_send_card_name", this.Hwo);
    localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
    localIntent.putExtra("Add_SendCard", true);
    localIntent.putExtra("titile", getString(2131755234));
    if ((this.GYn) && (af.aHH(this.Hwo))) {}
    for (;;)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 3);
      AppMethodBeat.o(39387);
      return;
      bool = false;
    }
  }
  
  private void feu()
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
      if ((this.Hwn) && (!this.Hwq.booleanValue()))
      {
        localIntent.putExtra("list_attr", u.I(new int[] { 16, 1, 2, 4, 16384 }));
        localIntent.putExtra("without_openim", true);
        localIntent.putExtra("KBlockOpenImFav", true);
      }
      else
      {
        localIntent.putExtra("list_attr", u.GWG);
      }
    }
  }
  
  private void im(List<String> paramList)
  {
    AppMethodBeat.i(39397);
    long l = System.currentTimeMillis();
    int i = paramList.size();
    Object localObject2 = ac.tF(getString(2131760084));
    Cursor localCursor2 = null;
    Cursor localCursor1 = localCursor2;
    try
    {
      com.tencent.mm.kernel.g.afC();
      localCursor1 = localCursor2;
      localCursor2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().lb(((com.tencent.mm.model.ab)localObject2).getType(), "");
      localCursor1 = localCursor2;
      localCursor2.moveToFirst();
      for (;;)
      {
        localCursor1 = localCursor2;
        if (localCursor2.isAfterLast()) {
          break;
        }
        localCursor1 = localCursor2;
        localObject2 = new af();
        localCursor1 = localCursor2;
        ((af)localObject2).convertFrom(localCursor2);
        localCursor1 = localCursor2;
        paramList.add(((au)localObject2).field_username);
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
      ad.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(paramList.size() - i) });
      AppMethodBeat.o(39397);
    }
    localObject1.close();
    label234:
    ad.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(paramList.size() - i) });
    AppMethodBeat.o(39397);
  }
  
  private static String n(com.tencent.mm.ai.k.b paramb)
  {
    AppMethodBeat.i(39385);
    Object localObject1 = new pn();
    ((pn)localObject1).dvb.type = 0;
    ((pn)localObject1).dvb.dvd = paramb.gHI;
    com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
    com.tencent.mm.protocal.b.a.c localc = ((pn)localObject1).dvc.dvl;
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localc != null)
    {
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = bt.by(localc.desc, paramb.description);
      }
    }
    paramb = (com.tencent.mm.ai.k.b)localObject1;
    if (!bt.isNullOrNil((String)localObject1)) {
      paramb = ((String)localObject1).replaceAll("\n", " ");
    }
    AppMethodBeat.o(39385);
    return paramb;
  }
  
  private void q(int paramInt, Intent paramIntent)
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
    if (aLT(paramString))
    {
      AppMethodBeat.o(39375);
      return;
    }
    if (u.hasAttr(this.ici, 256))
    {
      q(-1, paramIntent);
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
    if (w.pF(paramString))
    {
      int i = com.tencent.mm.model.q.rY(paramString);
      if (this.Hwm)
      {
        int j = bt.getInt(com.tencent.mm.m.g.Zd().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50);
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
    locala.dL(paramString);
    if (this.GYn)
    {
      a(locala, this.Hwo);
      if (w.pF(paramString))
      {
        b(paramIntent, this.Hwo, paramString);
        locala.i(Boolean.TRUE);
      }
    }
    for (;;)
    {
      locala.BYB = feo();
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
              com.tencent.mm.plugin.report.service.h.vKh.f(13943, new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            com.tencent.mm.pluginsdk.ui.tools.o.kF(SelectConversationUI.j(SelectConversationUI.this), paramString);
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
              az.arV();
              com.tencent.mm.model.c.apR().aIl(paramAnonymousString);
            }
          }
        }
      }.show();
      AppMethodBeat.o(39375);
      return;
      a(paramIntent, this.Hwo, paramString);
      break;
      Object localObject1;
      if ((this.Hwf) && (!this.qkc))
      {
        if ((getIntent().hasExtra("appbrand_params")) && (a(paramIntent, locala, null)))
        {
          AppMethodBeat.o(39375);
          return;
        }
        if (this.deL != -1L)
        {
          a(locala);
          localObject1 = new go();
          ((go)localObject1).djQ.deL = this.deL;
          ((go)localObject1).djQ.djR = this.djR;
          ((go)localObject1).djQ.djS = this.msgType;
          ((go)localObject1).djQ.djT = locala;
          ((go)localObject1).djQ.djU = this.Hww;
          ((go)localObject1).djQ.dbX = getContext();
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        for (;;)
        {
          locala.i(Boolean.TRUE);
          break;
          if ((this.msgType == 17) && (this.Hwl != 0))
          {
            localObject1 = getContext().getString(2131762561, new Object[] { Integer.valueOf(this.Hwl) });
            locala.aBX(getResources().getString(2131755817) + (String)localObject1);
          }
        }
      }
      String str;
      if ((this.Hwg) && (!this.qkc))
      {
        Object localObject2 = (HashMap)getIntent().getSerializableExtra("webview_params");
        localObject1 = (String)((HashMap)localObject2).get("img_url");
        str = (String)((HashMap)localObject2).get("title");
        localObject2 = (String)((HashMap)localObject2).get("url");
        locala.aBX(getResources().getString(2131755920) + str);
        locala.a(new d.a.b()
        {
          public final void ckg()
          {
            AppMethodBeat.i(39352);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", this.val$url);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.bs.d.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(39352);
          }
        });
        locala.aBY((String)localObject1).eyi();
        locala.i(Boolean.TRUE);
      }
      else
      {
        if ((this.Hwh) && (a(paramIntent, locala, paramString)))
        {
          AppMethodBeat.o(39375);
          return;
        }
        if (this.Hwj)
        {
          str = getResources().getString(2131755788);
          localObject1 = str;
          if (this.nrX != null) {
            localObject1 = str + this.nrX;
          }
          locala.aBX((String)localObject1);
          locala.i(Boolean.FALSE);
        }
        else
        {
          b(locala, paramString);
          a(locala);
          locala.i(Boolean.TRUE);
        }
      }
    }
  }
  
  private boolean wJ(boolean paramBoolean)
  {
    AppMethodBeat.i(39394);
    if (paramBoolean)
    {
      if (this.Hwt.size() < 9) {}
    }
    else {
      while (this.Hwt.size() > 9)
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
  
  public final void N(int paramInt, String paramString)
  {
    AppMethodBeat.i(39391);
    if (paramInt == 1)
    {
      this.Hwt.remove(paramString);
      fbz().notifyDataSetChanged();
      VV();
    }
    AppMethodBeat.o(39391);
  }
  
  public final void VL()
  {
    AppMethodBeat.i(39356);
    super.VL();
    this.Hwe = getIntent().getBooleanExtra("select_is_ret", false);
    this.fromScene = getIntent().getIntExtra("scene_from", 0);
    ad.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    if (this.fromScene == 1) {
      this.Hwf = true;
    }
    for (;;)
    {
      this.qkc = getIntent().getBooleanExtra("is_mp_video", false);
      this.Hwk = getIntent().getBooleanExtra("send_to_biz", false);
      this.GMW = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.deL = getIntent().getLongExtra("select_fav_local_id", -1L);
      this.djR = getIntent().getStringExtra("select_fav_fake_local_id");
      this.Hwl = getIntent().getIntExtra("select_fav_select_count", 0);
      this.Hwr = getIntent().getBooleanExtra("mutil_select_is_ret", false);
      this.GYn = getIntent().getBooleanExtra("Select_Send_Card", false);
      this.Hwn = getIntent().getBooleanExtra("forward_card", false);
      this.Hwm = getIntent().getBooleanExtra("Retr_Big_File", false);
      if (this.GYn) {
        this.Hwo = getIntent().getStringExtra("Select_Talker_Name");
      }
      this.ici = getIntent().getIntExtra("Select_Conv_Type", Hwc);
      this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
      this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      az.arV();
      this.drF = com.tencent.mm.model.c.apO().rm(this.msgId);
      this.imagePath = getIntent().getStringExtra("image_path");
      this.Hwv = getIntent().getStringExtra("ad_video_title");
      this.nrX = getIntent().getStringExtra("desc_title");
      this.emojiMD5 = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.duk = getIntent().getStringExtra("Retr_Msg_content");
      this.Hww = getIntent().getStringExtra("Retr_fav_xml_str");
      if ((this.duk == null) && (this.drF != null)) {
        this.duk = this.drF.field_content;
      }
      if (this.duk == null) {
        this.duk = "";
      }
      this.Hwu = ((ReportUtil.ReportArgs)getIntent().getParcelableExtra("Select_Report_Args"));
      this.Hwx = getIntent().getStringExtra("KChooseMsgFileType");
      this.Hwy = getIntent().getIntExtra("KChooseMsgFileCount", 9);
      this.Hwz = getIntent().getStringExtra("KChooseMsgFileExtension");
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(u.fbL());
      Object localObject = getIntent().getStringExtra("Select_block_List");
      if (!bt.isNullOrNil((String)localObject)) {
        localHashSet.addAll(bt.S(((String)localObject).split(",")));
      }
      if (u.hasAttr(this.ici, 2))
      {
        localObject = u.fbM();
        u.i((HashSet)localObject);
        localHashSet.addAll((Collection)localObject);
      }
      this.fvP = new ArrayList();
      this.fvP.addAll(localHashSet);
      im(this.fvP);
      if (u.hasAttr(this.ici, 1)) {
        this.GWl = true;
      }
      if (this.Hwr)
      {
        this.Hwt = new LinkedList();
        if (this.Hwr)
        {
          addTextOptionMenu(1, getString(2131755819), this.HwC, null, r.b.FOB);
          VV();
        }
      }
      AppMethodBeat.o(39356);
      return;
      if ((this.fromScene != 2) && (this.fromScene != 10))
      {
        if (this.fromScene == 3)
        {
          getIntent();
          boolean bool = ch.bW(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("is_h5"));
          if (bool) {
            ad.i("MicroMsg.SelectConversationUI", "hy: is H5 link");
          }
          if (!bool) {}
        }
      }
      else
      {
        this.Hwg = true;
        continue;
      }
      if (this.fromScene == 3) {
        this.Hwh = true;
      } else if (this.fromScene == 6) {
        this.Hwi = true;
      } else if (this.fromScene == 7) {
        this.Hwj = true;
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
    if (this.Git == null)
    {
      if (!this.GYn) {
        break label134;
      }
      this.Hwd = 2131763014;
    }
    for (;;)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39335);
          if (SelectConversationUI.a(SelectConversationUI.this))
          {
            SelectConversationUI.b(SelectConversationUI.this);
            AppMethodBeat.o(39335);
            return;
          }
          paramAnonymousView = SelectConversationUI.this.getIntent().getStringExtra("Select_App_Id");
          if ((SelectConversationUI.c(SelectConversationUI.this)) && (bt.isNullOrNil(paramAnonymousView)))
          {
            SelectConversationUI.d(SelectConversationUI.this);
            AppMethodBeat.o(39335);
            return;
          }
          SelectConversationUI.e(SelectConversationUI.this);
          AppMethodBeat.o(39335);
        }
      };
      String str = getString(this.Hwd);
      View localView = com.tencent.mm.ui.y.js(this).inflate(2131494420, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131298778);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.Git = ((TextView)localObject);
      this.Git.setVisibility(paramInt);
      AppMethodBeat.o(39359);
      return;
      label134:
      if (this.fromScene == 10) {
        this.Hwd = 2131761807;
      } else {
        this.Hwd = 2131763002;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39390);
    if ((parama.GVT) && (parama.contact != null))
    {
      boolean bool = this.Hwt.contains(parama.contact.field_username);
      AppMethodBeat.o(39390);
      return bool;
    }
    AppMethodBeat.o(39390);
    return false;
  }
  
  public final boolean aHt()
  {
    return (!this.Hwr) || (!this.Hws);
  }
  
  public final boolean aHu()
  {
    return false;
  }
  
  public final String aHv()
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
  
  public final com.tencent.mm.ui.contact.q aHw()
  {
    AppMethodBeat.i(39357);
    com.tencent.mm.ui.contact.ab localab = new com.tencent.mm.ui.contact.ab(this, this.fvP, this.GWl, this.Hws, this.Hwk, this.ici);
    AppMethodBeat.o(39357);
    return localab;
  }
  
  public final com.tencent.mm.ui.contact.o aHx()
  {
    AppMethodBeat.i(39358);
    s locals = new s(this, this.fvP, this.Hws, this.scene);
    AppMethodBeat.o(39358);
    return locals;
  }
  
  public final boolean aLT(String paramString)
  {
    AppMethodBeat.i(39365);
    if (!aLS(paramString))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if ((!bt.isNullOrNil(getIntent().getStringExtra("Select_App_Id"))) && (this.GYn))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if (this.GYn)
    {
      az.arV();
      if (af.Wy(com.tencent.mm.model.c.apM().aHW(this.Hwo).field_verifyFlag))
      {
        aLU(paramString);
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
    az.arV();
    String str = com.tencent.mm.model.c.apO().agC(this.duk).yGA;
    az.arV();
    if (w.mZ(com.tencent.mm.model.c.apM().aHW(str).field_verifyFlag))
    {
      aLU(paramString);
      AppMethodBeat.o(39365);
      return true;
    }
    AppMethodBeat.o(39365);
    return false;
  }
  
  protected final void amr(String paramString)
  {
    AppMethodBeat.i(169903);
    ad.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (aLT(paramString))
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
      if ((this.Hwe) || (this.GYn) || (this.Hwf) || (this.Hwg) || (this.Hwh) || (this.qkc))
      {
        w(localIntent1, paramString);
      }
      else if (this.fromScene == 11)
      {
        aLV(paramString);
      }
      else
      {
        q(-1, localIntent1);
        finish();
      }
    }
  }
  
  public final int[] cMQ()
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
    arrayOfInt = super.cMQ();
    AppMethodBeat.o(39395);
    return arrayOfInt;
  }
  
  public final void cMR()
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
      if (this.Hwu != null)
      {
        this.Hwu.errCode = 0;
        ReportUtil.a(this, this.Hwu, true);
      }
      AppMethodBeat.o(39360);
      return;
      super.cMR();
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
          if (aLT((String)localObject1))
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
          if ((this.Hwe) || (this.GYn) || (this.Hwf) || (this.Hwg) || (this.Hwh))
          {
            w(paramIntent, (String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          if (this.fromScene == 11)
          {
            aLV((String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          q(-1, paramIntent);
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
        com.tencent.e.h.Iye.q(new Runnable()
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.adn(), "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ReportUtil.R(false, 0);
          AppMethodBeat.o(39363);
          return;
        }
        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getBooleanExtra("Select_back_to_app", false)))
        {
          ReportUtil.a(this, ReportUtil.c(paramIntent.getExtras(), 0), false);
          AppMethodBeat.o(39363);
          return;
          if (paramIntent != null) {
            this.Hwu = ((ReportUtil.ReportArgs)paramIntent.getParcelableExtra("Select_Report_Args"));
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
          if ((!bt.isNullOrNil(paramIntent)) && (!aLT(paramIntent)))
          {
            localObject1 = new o.a(getContext());
            ((o.a)localObject1).dL(paramIntent);
            a((o.a)localObject1, this.Hwo);
            localObject1 = ((o.a)localObject1).i(Boolean.TRUE);
            ((o.a)localObject1).BYB = feo();
            {
              public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
              {
                AppMethodBeat.i(39350);
                SelectConversationUI.this.hideVKB();
                Intent localIntent;
                if (paramAnonymousBoolean)
                {
                  localIntent = new Intent();
                  if (!w.pF(paramIntent)) {
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
        localObject1 = this.Hwt.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.twW.aBD((String)localObject2);
        }
        if (!bt.isNullOrNil(paramIntent)) {
          this.Hwt = bt.S(paramIntent.split(","));
        }
        for (;;)
        {
          paramIntent = this.Hwt.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.twW.aBE((String)localObject1);
          }
          this.Hwt.clear();
        }
        VV();
        fbz().notifyDataSetChanged();
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
    super.cMR();
    AppMethodBeat.o(39361);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39355);
    com.tencent.mm.pluginsdk.g.o(this);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Select_App_Id");
    String str = getIntent().getStringExtra("Select_Open_Id");
    ad.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + paramBundle + ", openId = " + str);
    if ((!bt.isNullOrNil(paramBundle)) && (!bt.isNullOrNil(str))) {
      new com.tencent.mm.plugin.base.stub.d(this, paramBundle, str, new d.a()
      {
        public final void it(boolean paramAnonymousBoolean)
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
      }).bAT();
    }
    com.tencent.mm.pluginsdk.g.p(this);
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
  
  public final void pT(int paramInt)
  {
    AppMethodBeat.i(39362);
    int i;
    Object localObject2;
    if (this.Hws)
    {
      i = paramInt - getContentLV().getHeaderViewsCount();
      if (i < 0)
      {
        ad.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
        fes();
        AppMethodBeat.o(39362);
        return;
      }
      localObject1 = fbz();
      localObject2 = ((p)localObject1).ZC(i);
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
      if ((!this.Hwt.contains(localObject2)) && (wJ(true)))
      {
        fbG();
        AppMethodBeat.o(39362);
        return;
      }
      fbG();
      this.twW.aBC((String)localObject2);
      if (this.Hwt.contains(localObject2)) {
        this.Hwt.remove(localObject2);
      }
      for (;;)
      {
        VV();
        ((p)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(39362);
        return;
        this.Hwt.add(localObject2);
      }
    }
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ad.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      if (this.GYn)
      {
        fet();
        AppMethodBeat.o(39362);
        return;
      }
      feu();
      AppMethodBeat.o(39362);
      return;
    }
    Object localObject1 = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (localObject1 == null)
    {
      AppMethodBeat.o(39362);
      return;
    }
    if (((localObject1 instanceof com.tencent.mm.ui.contact.a.b)) && (((com.tencent.mm.ui.contact.a.b)localObject1).bNK == getResources().getString(2131755219)))
    {
      ad.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("list_attr", 16384);
      com.tencent.mm.bs.d.b(this, "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject1, 4);
      this.Hwg = true;
      AppMethodBeat.o(39362);
      return;
    }
    if ((localObject1 instanceof com.tencent.mm.ui.contact.a.g))
    {
      Object localObject3 = (com.tencent.mm.ui.contact.a.g)localObject1;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("scene", this.scene);
      localObject2 = new ArrayList();
      localObject3 = ((com.tencent.mm.ui.contact.a.a)localObject3).roS.rps;
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
    amr(((au)localObject1).field_username);
    AppMethodBeat.o(39362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI
 * JD-Core Version:    0.7.0.1
 */