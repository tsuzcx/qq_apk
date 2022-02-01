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
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.a;
import com.tencent.mm.g.a.pw.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.g.j;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.storage.bo.b;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.ab;
import com.tencent.mm.ui.contact.p;
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
  private static final int IWz;
  private TextView HIi;
  private int IWA;
  private boolean IWB;
  private boolean IWC;
  private boolean IWD;
  private boolean IWE;
  private boolean IWF;
  private boolean IWG;
  private boolean IWH;
  private int IWI;
  private boolean IWJ;
  private boolean IWK;
  private String IWL;
  private String IWM;
  private Boolean IWN;
  private boolean IWO;
  private boolean IWP;
  private List<String> IWQ;
  private ReportUtil.ReportArgs IWR;
  private String IWS;
  private String IWT;
  private String IWU;
  private int IWV;
  private String IWW;
  private int IWX;
  private boolean IWY;
  private MenuItem.OnMenuItemClickListener IWZ;
  private MenuItem.OnMenuItemClickListener IXa;
  private int ImY;
  private boolean Iwz;
  private boolean IyD;
  private long dcg;
  private String dhm;
  private bo dpq;
  private String drV;
  private String emojiMD5;
  private int fromScene;
  private List<String> fzw;
  private int iCp;
  private String imagePath;
  private long msgId;
  private int msgType;
  private String nUX;
  boolean qSE;
  private int[] qVd;
  
  static
  {
    AppMethodBeat.i(39409);
    IWz = u.I(new int[] { 1, 2 });
    AppMethodBeat.o(39409);
  }
  
  public SelectConversationUI()
  {
    AppMethodBeat.i(39354);
    this.IWB = false;
    this.IWC = false;
    this.IWD = false;
    this.IWE = false;
    this.IWF = false;
    this.IWG = false;
    this.qSE = false;
    this.fromScene = 0;
    this.IWH = false;
    this.IyD = false;
    this.IWJ = false;
    this.IWK = false;
    this.ImY = -1;
    this.IWN = Boolean.FALSE;
    this.IWO = false;
    this.IWP = false;
    this.IWQ = null;
    this.imagePath = null;
    this.IWS = null;
    this.nUX = null;
    this.IWX = 0;
    this.IWY = false;
    this.qVd = new int[] { 2131298154, 2131298155, 2131298156, 2131298157, 2131298158 };
    this.IWZ = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196970);
        paramAnonymousMenuItem = SelectConversationUI.this;
        boolean bool;
        if (!SelectConversationUI.a(SelectConversationUI.this))
        {
          bool = true;
          SelectConversationUI.b(paramAnonymousMenuItem, bool);
          SelectConversationUI.this.frq().xA(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.this.Iwl.xA(SelectConversationUI.a(SelectConversationUI.this));
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
          AppMethodBeat.o(196970);
          return true;
          bool = false;
          break;
        }
      }
    };
    this.IXa = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(196971);
        if (SelectConversationUI.q(SelectConversationUI.this))
        {
          AppMethodBeat.o(196971);
          return false;
        }
        paramAnonymousMenuItem = SelectConversationUI.r(SelectConversationUI.this).iterator();
        while (paramAnonymousMenuItem.hasNext())
        {
          localObject = (String)paramAnonymousMenuItem.next();
          if (SelectConversationUI.this.aRv((String)localObject))
          {
            AppMethodBeat.o(196971);
            return false;
          }
        }
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Conv_User", bs.n(SelectConversationUI.r(SelectConversationUI.this), ","));
        Object localObject = (Intent)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject != null) {
          SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem, (Intent)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(196971);
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
  
  private void WT()
  {
    AppMethodBeat.i(39393);
    if (!this.IWO)
    {
      AppMethodBeat.o(39393);
      return;
    }
    if ((this.IWQ != null) && (this.IWQ.size() > 0))
    {
      updateOptionMenuText(1, fuj() + "(" + this.IWQ.size() + ")");
      updateOptionMenuListener(1, this.IXa, null);
      enableOptionMenu(1, true);
      AppMethodBeat.o(39393);
      return;
    }
    if (!this.IWP)
    {
      updateOptionMenuText(1, getString(2131755819));
      updateOptionMenuListener(1, this.IWZ, null);
      enableOptionMenu(1, true);
      if (this.uFo != null) {
        this.uFo.setVisibility(8);
      }
      frs();
      AppMethodBeat.o(39393);
      return;
    }
    updateOptionMenuText(1, getString(2131755897));
    updateOptionMenuListener(1, this.IWZ, null);
    enableOptionMenu(1, true);
    if (this.uFo != null) {
      this.uFo.setVisibility(0);
    }
    frt();
    AppMethodBeat.o(39393);
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39384);
    Object localObject = null;
    float f = paramInt2 / paramInt1;
    int k = 0;
    int j = 0;
    int m = ao.av(paramContext, 2131165260);
    paramInt1 = ao.av(paramContext, 2131165259);
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
    ((com.tencent.mm.loader.c.e.a)localObject1).gKq = true;
    ((com.tencent.mm.loader.c.e.a)localObject1).gKp = true;
    ((com.tencent.mm.loader.c.e.a)localObject1).gKC = true;
    Object localObject2 = ((com.tencent.mm.loader.c.e.a)localObject1).aot();
    localObject1 = View.inflate(this, 2131495425, null);
    View localView = ((View)localObject1).findViewById(2131299997);
    Object localObject3 = (ImageView)localView.findViewById(2131299971);
    Object localObject4 = com.tencent.mm.loader.e.gIC;
    com.tencent.mm.loader.e.anT().a(bs.nullAsNil(paramb.hTI.ruB), (ImageView)localObject3, (com.tencent.mm.loader.c.e)localObject2);
    ((TextView)localView.findViewById(2131300017)).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.hTI.nickname));
    localObject4 = (ImageView)localView.findViewById(2131300076);
    localObject2 = (ImageView)localView.findViewById(2131300006);
    localObject3 = (TextView)localView.findViewById(2131299988);
    if (paramb.hTI.EGJ == 1)
    {
      ((ImageView)localObject4).setVisibility(8);
      localObject4 = (TextView)localView.findViewById(2131300075);
      ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.hTI.desc));
      ((TextView)localObject4).setVisibility(0);
      ((TextView)localObject3).setVisibility(8);
      label208:
      if ((paramb.hTI.EGJ != 4) && (paramb.hTI.EGJ != 6)) {
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
      if (paramb.hTI.mediaList.size() > 0) {
        ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).loadImage(((anw)paramb.hTI.mediaList.get(0)).thumbUrl, (ImageView)localObject4);
      }
      if (bs.isNullOrNil(paramb.hTI.desc)) {
        break;
      }
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.k.c(this, paramb.hTI.desc));
      break label208;
      label352:
      if ((paramb.hTI.EGJ == 2) && (paramb.hTI.mediaList.size() > 1))
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
    boolean bool2 = ch.bU(paramHashMap.get("is_dynamic"));
    int k = ch.getInt(paramHashMap.get("subType"), 0);
    int m = ch.getInt(paramHashMap.get("biz"), k.a.hhA.ordinal());
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
      ac.d("MicroMsg.SelectConversationUI", "defaultFooterTxt: %s, tailLang: %s.", new Object[] { localObject2, str5 });
      localObject2 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class);
      if (paramString3 != null) {
        break label745;
      }
    }
    label745:
    for (boolean bool1 = false;; bool1 = w.wu(paramString3))
    {
      paramString3 = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool1, new k.c()
      {
        public final void aAF()
        {
          AppMethodBeat.i(196956);
          paramIntent.putExtra("KShowTodoIntroduceView", 1);
          e.a(SelectConversationUI.this, null);
          AppMethodBeat.o(196956);
        }
        
        public final void ex(boolean paramAnonymousBoolean) {}
      });
      localObject1 = m.cE(this);
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
      paramHashMap.IXT = new f.a()
      {
        public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(196957);
          paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
          if (paramAnonymousBoolean1)
          {
            paramIntent.putExtra("custom_send_text", paramAnonymousString);
            SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
            SelectConversationUI.this.finish();
          }
          for (;;)
          {
            ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.jMD, paramString3);
            AppMethodBeat.o(196957);
            return;
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            SelectConversationUI.this.finish();
          }
        }
      };
      ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a((String)localObject1, paramString3, (Bundle)localObject2, new com.tencent.mm.modelappbrand.k.b()
      {
        public final void om(int paramAnonymousInt)
        {
          AppMethodBeat.i(196958);
          ac.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramHashMap.fuw();
          AppMethodBeat.o(196958);
        }
      });
      parama.fE(paramString3);
      parama.i(Boolean.TRUE);
      parama.eND();
      parama.mAn = new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(196959);
          ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.jMD, paramString3);
          AppMethodBeat.o(196959);
        }
      };
      parama.DqS = fuj();
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(196960);
          SelectConversationUI.this.hideVKB();
          Object localObject = paramString3.getTag(2131296837);
          f localf = paramHashMap;
          if (localObject == null) {}
          for (boolean bool = false;; bool = ((Boolean)localObject).booleanValue())
          {
            localf.a(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt, bool);
            AppMethodBeat.o(196960);
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
      ac.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(m) });
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
      paramIntent.putExtra("received_card_name", bs.n(paramList, ","));
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
        public final void crN()
        {
          AppMethodBeat.i(39338);
          Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", SelectConversationUI.j(SelectConversationUI.this));
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.jS(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39338);
        }
      });
      AppMethodBeat.o(39378);
      return;
      parama.a(new d.a.b()
      {
        public final void crN()
        {
          AppMethodBeat.i(39339);
          ac.i("MicroMsg.SelectConversationUI", "[ImageGalleryUI] showImgGallery");
          Object localObject = new Intent(SelectConversationUI.this.getContext(), ImageGalleryUI.class);
          ((Intent)localObject).putExtra("img_gallery_msg_id", SelectConversationUI.l(SelectConversationUI.this));
          ((Intent)localObject).putExtra("img_gallery_msg_svr_id", SelectConversationUI.m(SelectConversationUI.this).field_msgSvrId);
          ((Intent)localObject).putExtra("img_gallery_talker", SelectConversationUI.m(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_gallery_chatroom_name", SelectConversationUI.m(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_preview_only", true);
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.jS(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39339);
        }
      });
      AppMethodBeat.o(39378);
      return;
      az.ayM();
      if (com.tencent.mm.model.c.awD() == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      az.ayM();
      Object localObject = com.tencent.mm.model.c.awD().alx(this.drV);
      parama.a(new d.a.b()
      {
        public final void crN()
        {
          AppMethodBeat.i(180090);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          localIntent.putExtra("kwebmap_slat", this.IXh.tWI);
          localIntent.putExtra("kwebmap_lng", this.IXh.tWJ);
          localIntent.putExtra("Kwebmap_locaion", this.IXi);
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.br.d.b(SelectConversationUI.this.getContext(), "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(180090);
        }
      });
      AppMethodBeat.o(39378);
      return;
      localObject = com.tencent.mm.ah.k.b.vA(bs.aLx(this.drV));
      if (localObject == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      if ((((com.tencent.mm.ah.k.b)localObject).type == 5) && (!com.tencent.mm.ui.chatting.l.f(this.dpq, this.ImY)))
      {
        parama.a(new d.a.b()
        {
          public final void crN()
          {
            AppMethodBeat.i(39340);
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
          public final void crN()
          {
            AppMethodBeat.i(39341);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.l(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/transmit/SelectConversationUI$26", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
          public final void crN()
          {
            AppMethodBeat.i(39342);
            nz localnz = new nz();
            localnz.dqu.context = SelectConversationUI.this.getContext();
            localnz.dqu.msgId = SelectConversationUI.l(SelectConversationUI.this);
            localnz.dqu.dqv = this.kMk.hij;
            localnz.dqu.dpG = false;
            localnz.dqu.scene = 7;
            com.tencent.mm.sdk.b.a.GpY.l(localnz);
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
          public final void crN()
          {
            AppMethodBeat.i(39343);
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.l(SelectConversationUI.this));
            localIntent.putExtra("record_xml", this.kMk.hij);
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
          public final void crN()
          {
            AppMethodBeat.i(180091);
            Object localObject2 = com.tencent.mm.pluginsdk.model.app.q.P(this.kMk.url, "message");
            String str = com.tencent.mm.pluginsdk.model.app.q.P(this.kMk.hhE, "message");
            Object localObject1;
            if (ax.isMobile(SelectConversationUI.this.getContext()))
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
          public final void crN()
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
          public final void crN()
          {
            AppMethodBeat.i(180093);
            Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
            ((Intent)localObject).putExtra("Retr_Msg_content", this.kMk.title);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.jS(SelectConversationUI.this.getContext());
            AppMethodBeat.o(180093);
          }
        });
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void crN()
          {
            AppMethodBeat.i(196966);
            Object localObject = com.tencent.mm.ui.chatting.k.jY(SelectConversationUI.this.getContext());
            localObject = com.tencent.mm.ah.k.b.vA(bs.aLx(n.a(((pw)localObject).dsO.dsV.title, ((pw)localObject).dsO.dsV.desc, ((pw)localObject).dsO.dsm.dck.dcm, ((pw)localObject).dsN.dsT, SelectConversationUI.l(SelectConversationUI.this))));
            if (localObject == null)
            {
              AppMethodBeat.o(196966);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.l(SelectConversationUI.this));
            localIntent.putExtra("record_xml", ((com.tencent.mm.ah.k.b)localObject).hij);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.br.d.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(196966);
          }
        });
        AppMethodBeat.o(39378);
        return;
        com.tencent.mm.ui.chatting.k.jY(getContext());
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void crN()
          {
            AppMethodBeat.i(196967);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.l(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(196967);
          }
        });
      }
    }
  }
  
  private void a(o.a parama, String paramString)
  {
    AppMethodBeat.i(39371);
    az.ayM();
    com.tencent.mm.model.c.awB().aNr(paramString);
    String str = v.wk(paramString);
    if (!bs.isNullOrNil(this.IWM)) {
      str = this.IWM;
    }
    parama.aHp(aRy(paramString) + str);
    AppMethodBeat.o(39371);
  }
  
  private boolean a(final Intent paramIntent, final o.a parama, final String paramString)
  {
    AppMethodBeat.i(180097);
    Object localObject = (HashMap)getIntent().getSerializableExtra("appbrand_params");
    boolean bool1 = ch.bU(((HashMap)localObject).get("is_weishi_video"));
    final boolean bool2 = ch.bU(((HashMap)localObject).get("is_video"));
    if (bool1)
    {
      bool1 = a(parama, (HashMap)localObject);
      AppMethodBeat.o(180097);
      return bool1;
    }
    int i = ch.getInt(((HashMap)localObject).get("type"), 1);
    final String str2 = ch.c(((HashMap)localObject).get("title"), "");
    final String str1 = ch.c(((HashMap)localObject).get("img_url"), null);
    int j = ch.getInt(((HashMap)localObject).get("biz"), k.a.hhA.ordinal());
    if ((!k.a.isValid(j)) && ((i == 2) || (i == 3)))
    {
      if ((paramString != null) && (y.VM()) && (w.wu(paramString)) && (aw.aKT("group_to_do").getBoolean("introduce_dialog_first", true)))
      {
        aw.aKT("group_to_do").edit().putBoolean("introduce_dialog_first", false);
        e.a(this, new e.a()
        {
          public final void fqB()
          {
            AppMethodBeat.i(180080);
            paramIntent.putExtra("KShowTodoIntroduceView", 1);
            SelectConversationUI.a(SelectConversationUI.this, paramIntent, parama, this.IXd, bool2, str1, str2, paramString);
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
      if (bs.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        parama.aHp(paramString + str2);
        paramString = new f(this);
        paramString.IXT = new f.a()
        {
          public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(196952);
            paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
            if (paramAnonymousBoolean1)
            {
              paramIntent.putExtra("custom_send_text", paramAnonymousString);
              SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
              SelectConversationUI.this.finish();
              AppMethodBeat.o(196952);
              return;
            }
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            SelectConversationUI.this.finish();
            AppMethodBeat.o(196952);
          }
        };
        com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
        {
          public final String Ap()
          {
            AppMethodBeat.i(196955);
            String str = m.cE(this);
            AppMethodBeat.o(196955);
            return str;
          }
          
          public final void E(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(196953);
            paramString.fuw();
            AppMethodBeat.o(196953);
          }
          
          public final void aBa() {}
          
          public final void of()
          {
            AppMethodBeat.i(196954);
            paramString.fuw();
            AppMethodBeat.o(196954);
          }
        }, str1, com.tencent.mm.modelappbrand.a.g.htk);
        parama.i(Boolean.TRUE);
        parama.DqS = fuj();
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
        paramString = bs.u(getResources().getString(2131756223), new Object[] { localObject });
      }
    }
    parama.aHp(getResources().getString(2131755375) + str2);
    parama.aHq(str1).eNC();
    parama.i(Boolean.TRUE);
    AppMethodBeat.o(180097);
    return false;
  }
  
  private boolean a(o.a parama, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(39377);
    final String str = ch.c(paramHashMap.get("img_url"), null);
    if (!bs.isNullOrNil(str))
    {
      paramHashMap = new RelativeLayout(this);
      View localView = LayoutInflater.from(this).inflate(2131493585, null);
      paramHashMap.addView(localView, new RelativeLayout.LayoutParams(-2, -2));
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(14);
      final ImageView localImageView = (ImageView)localView.findViewById(2131302310);
      ((ImageView)localView.findViewById(2131300961)).setImageResource(2131691361);
      parama.fE(paramHashMap);
      parama.eND();
      com.tencent.mm.modelappbrand.a.b.aAS().a(new b.k()
      {
        public final String Ap()
        {
          return "SelectConversationUI#WEISHITHUMB";
        }
        
        public final void E(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(196961);
          if ((!SelectConversationUI.this.isFinishing()) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()) && (localImageView != null))
          {
            paramAnonymousBitmap = al.c(SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBitmap, localImageView, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight()), ao.fromDPToPix(SelectConversationUI.this, 3));
            localImageView.setImageBitmap(paramAnonymousBitmap);
          }
          AppMethodBeat.o(196961);
        }
        
        public final void aBa() {}
        
        public final void of()
        {
          AppMethodBeat.i(196962);
          ac.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", new Object[] { str });
          AppMethodBeat.o(196962);
        }
      }, str, null, null);
    }
    for (;;)
    {
      parama.i(Boolean.TRUE);
      AppMethodBeat.o(39377);
      return false;
      paramHashMap = ch.c(paramHashMap.get("msg_img_path"), null);
      if (!bs.isNullOrNil(paramHashMap))
      {
        ac.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", new Object[] { str, paramHashMap });
        parama.i(aRz(paramHashMap), 2);
      }
    }
  }
  
  private static boolean aRu(String paramString)
  {
    AppMethodBeat.i(39364);
    if (com.tencent.mm.storage.ai.aNc(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    if (w.wq(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    AppMethodBeat.o(39364);
    return false;
  }
  
  private void aRw(String paramString)
  {
    AppMethodBeat.i(39366);
    try
    {
      Object localObject = bs.S(paramString.split(","));
      paramString = new StringBuffer();
      localObject = ((List)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!bs.isNullOrNil(str))
        {
          if (i != 0) {
            paramString.append(",");
          }
          paramString.append(v.wk(str));
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
  
  private void aRx(String paramString)
  {
    AppMethodBeat.i(39367);
    ac.i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", new Object[] { paramString, this.IWU, Integer.valueOf(this.IWV) });
    ac.i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", new Object[] { this.IWW });
    ((com.tencent.mm.choosemsgfile.compat.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.choosemsgfile.compat.a.class)).a(this, paramString, this.IWU, this.IWV, this.IWW, new a.a()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, ArrayList<MsgFile> paramAnonymousArrayList)
      {
        AppMethodBeat.i(39351);
        ac.i("MicroMsg.SelectConversationUI", "resultCode:%d filePaths:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousArrayList });
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
  
  private String aRy(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(39372);
    az.ayM();
    com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNr(paramString);
    Object localObject = getResources().getString(2131755784);
    if (localai == null)
    {
      AppMethodBeat.o(39372);
      return localObject;
    }
    az.ayM();
    localObject = com.tencent.mm.model.c.awD().alw(this.drV);
    int i = j;
    if (localObject != null) {
      if (!w.nN(((bo.a)localObject).Chb))
      {
        i = j;
        if (!localai.fad()) {}
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
      if (com.tencent.mm.storage.ai.aNc(paramString)) {
        paramString = c(this, localai);
      } else {
        paramString = getResources().getString(2131755784);
      }
    }
  }
  
  private static Bitmap aRz(String paramString)
  {
    AppMethodBeat.i(39383);
    localBitmap2 = com.tencent.mm.av.o.aFx().Cm(paramString);
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
        ac.printErrStackTrace("MicroMsg.SelectConversationUI", paramString, "unexpected exception.", new Object[0]);
        localBitmap1 = localBitmap2;
      }
    }
    AppMethodBeat.o(39383);
    return localBitmap1;
  }
  
  private void b(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(39374);
    ac.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=".concat(String.valueOf(paramIntent2)));
    paramIntent2.putExtras(paramIntent1.getExtras());
    startActivityForResult(paramIntent2, 2);
    com.tencent.mm.ui.base.b.ak(getContext(), paramIntent2);
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
            parama.aHp(this.drV);
            parama.eNB();
            AppMethodBeat.o(180099);
            return;
            localObject1 = fum();
            paramString = (String)localObject1;
            if (localObject1 == null)
            {
              paramString = (String)localObject1;
              if (this.imagePath != null)
              {
                float f = com.tencent.mm.cc.a.getDensity(com.tencent.mm.sdk.platformtools.ai.getContext());
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
            parama.i(ful(), 2);
            AppMethodBeat.o(180099);
            return;
            parama.i(ful(), 2);
            AppMethodBeat.o(180099);
            return;
            parama.aHp(fuk());
            AppMethodBeat.o(180099);
            return;
            if (!bs.isNullOrNil(this.emojiMD5))
            {
              parama.aHr(this.emojiMD5);
              AppMethodBeat.o(180099);
              return;
            }
            if (!bs.isNullOrNil(this.dpq.field_imgPath))
            {
              parama.aHr(this.dpq.field_imgPath);
              AppMethodBeat.o(180099);
              return;
            }
            parama.aHr(this.imagePath);
            AppMethodBeat.o(180099);
            return;
            az.ayM();
            paramString = com.tencent.mm.model.c.awD().alw(this.drV);
            this.IWL = paramString.zTO;
            this.IWM = paramString.nickname;
            this.IWN = Boolean.valueOf(w.nN(paramString.Chb));
            a(parama, this.IWL);
            AppMethodBeat.o(180099);
            return;
            paramString = (com.tencent.mm.plugin.finder.api.c)com.tencent.mm.ah.k.b.vA(bs.aLx(this.drV)).ao(com.tencent.mm.plugin.finder.api.c.class);
          } while (paramString == null);
          parama.aHp(getString(2131755776) + paramString.title);
          AppMethodBeat.o(180099);
          return;
          paramString = (com.tencent.mm.plugin.i.a.b)com.tencent.mm.ah.k.b.vA(bs.aLx(this.drV)).ao(com.tencent.mm.plugin.i.a.b.class);
          if (paramString != null) {
            parama.fE(a(paramString));
          }
          parama.eND();
          AppMethodBeat.o(180099);
          return;
          paramString = (com.tencent.mm.plugin.i.a.a)com.tencent.mm.ah.k.b.vA(bs.aLx(this.drV)).ao(com.tencent.mm.plugin.i.a.a.class);
        } while (paramString == null);
        parama.aHp(getString(2131755777) + paramString.nickname);
        AppMethodBeat.o(180099);
        return;
        paramString = (com.tencent.mm.plugin.i.a.c)com.tencent.mm.ah.k.b.vA(bs.aLx(this.drV)).ao(com.tencent.mm.plugin.i.a.c.class);
      } while ((paramString == null) || (paramString.hTJ == null));
      localObject1 = getString(2131755775);
      if (paramString.hTJ.rPI == 1) {}
      for (paramString = (String)localObject1 + getString(2131759380, new Object[] { paramString.hTJ.dol });; paramString = (String)localObject1 + paramString.hTJ.dol)
      {
        parama.aHp(paramString);
        AppMethodBeat.o(180099);
        return;
      }
    case 2: 
    case 10: 
      localb = com.tencent.mm.ah.k.b.vA(bs.aLx(this.drV));
      if ((this.dpq.eZj()) && (localb == null)) {
        localb = com.tencent.mm.ah.k.b.az(bs.aLx(this.drV), bs.aLx(this.drV));
      }
      break;
    }
    for (;;)
    {
      if (localb == null)
      {
        if (this.IWS != null)
        {
          paramString = getResources().getString(2131755926);
          localObject1 = this.IWS;
          parama.aHp(paramString + (String)localObject1);
        }
        AppMethodBeat.o(180099);
        return;
      }
      localObject1 = localb.title;
      if (com.tencent.mm.ui.chatting.l.f(this.dpq, this.ImY)) {
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
        parama.i(fum(), 2);
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
          if (bs.isNullOrNil(localb.dvm)) {
            paramString = getResources().getString(2131755895);
          } else {
            paramString = bs.u(getResources().getString(2131756223), new Object[] { localb.dvm });
          }
        }
        else if ((localb.type == 33) || (localb.type == 36) || (localb.type == 48))
        {
          if ((localb.hkg == 2) || (localb.hkg == 3) || (localb.type == 36) || (localb.type == 48))
          {
            i = localb.hkl;
            if (localb.et(false))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("key_biz", i);
              ((Bundle)localObject1).putString("key_footer_text_default", localb.dvm);
              ((Bundle)localObject1).putString("key_footer_text", localb.r(getContext(), false));
              ((Bundle)localObject1).putString("key_footer_icon", localb.hks);
              localObject2 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class);
              if (paramString != null) {
                break label1695;
              }
            }
            label1695:
            for (boolean bool = false;; bool = w.wu(paramString))
            {
              paramString = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool, new k.c()
              {
                public final void aAF()
                {
                  AppMethodBeat.i(196963);
                  SelectConversationUI.k(SelectConversationUI.this);
                  e.a(SelectConversationUI.this, null);
                  AppMethodBeat.o(196963);
                }
                
                public final void ex(boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(196964);
                  SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBoolean);
                  AppMethodBeat.o(196964);
                }
              });
              parama.fE(paramString);
              parama.i(Boolean.TRUE);
              parama.eND();
              Object localObject3 = com.tencent.mm.av.o.aFx().b(this.dpq.field_imgPath, false, true);
              localObject1 = m.cE(this);
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("app_id", localb.hkf);
              ((Bundle)localObject2).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(localb.hkq), Integer.valueOf(localb.hki) }));
              ((Bundle)localObject2).putInt("msg_pkg_type", localb.hkq);
              ((Bundle)localObject2).putInt("pkg_version", localb.hki);
              if (!bs.isNullOrNil((String)localObject3)) {
                ((Bundle)localObject2).putString("image_url", "file://".concat(String.valueOf(localObject3)));
              }
              localObject3 = (com.tencent.mm.ah.a)localb.ao(com.tencent.mm.ah.a.class);
              if (localObject3 != null)
              {
                ((Bundle)localObject2).putBoolean("is_dynamic_page", ((com.tencent.mm.ah.a)localObject3).hfN);
                ((Bundle)localObject2).putString("cache_key", ((com.tencent.mm.ah.a)localObject3).hfO);
                ((Bundle)localObject2).putInt("sub_type", ((com.tencent.mm.ah.a)localObject3).hgc);
              }
              ((Bundle)localObject2).putString("title", localb.title);
              ((Bundle)localObject2).putString("msg_path", localb.hkd);
              ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a((String)localObject1, paramString, (Bundle)localObject2);
              parama.mAn = new DialogInterface.OnDismissListener()
              {
                public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(196965);
                  ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.modelappbrand.k.class)).a(this.jMD, paramString);
                  AppMethodBeat.o(196965);
                }
              };
              AppMethodBeat.o(180099);
              return;
              if (localb.type == 48)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putBoolean("is_video", true);
                ((Bundle)localObject1).putString("key_footer_icon", localb.hks);
                ((Bundle)localObject1).putString("key_footer_text", localb.dvm);
                break;
              }
              ac.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(i) });
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
      parama.aHp(paramString + (String)localObject2);
      if (localb.thumburl == null) {
        break;
      }
      parama.aHq(localb.thumburl).eNC();
      AppMethodBeat.o(180099);
      return;
      paramString = bs.bG(com.tencent.mm.ui.chatting.k.jY(getContext()).dsO.dsV.title, "");
      parama.aHp(getResources().getString(2131755818) + paramString);
      AppMethodBeat.o(180099);
      return;
      paramString = com.tencent.mm.ui.chatting.k.jY(getContext());
      if (paramString.dsN.dsS != null) {}
      for (i = paramString.dsN.dsS.size();; i = 0)
      {
        paramString = getContext().getString(2131762561, new Object[] { Integer.valueOf(i) });
        parama.aHp(getResources().getString(2131755817) + paramString);
        AppMethodBeat.o(180099);
        return;
        if (this.nUX == null) {
          break;
        }
        parama.aHp(getResources().getString(2131755773) + this.nUX);
        break;
      }
    }
  }
  
  public static String c(Context paramContext, com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(39373);
    paramai = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramai.field_openImAppid, "openim_card_type_name", b.a.inW);
    if (TextUtils.isEmpty(paramai)) {}
    for (paramContext = paramContext.getResources().getString(2131755784);; paramContext = String.format("[%s]", new Object[] { paramai }))
    {
      AppMethodBeat.o(39373);
      return paramContext;
    }
  }
  
  private String fuj()
  {
    AppMethodBeat.i(169904);
    String str2 = getIntent().getStringExtra("KSendWording");
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      str1 = getString(2131755884);
    }
    AppMethodBeat.o(169904);
    return str1;
  }
  
  private String fuk()
  {
    AppMethodBeat.i(39380);
    az.ayM();
    bo.b localb = com.tencent.mm.model.c.awD().alx(this.drV);
    String str = "";
    if (localb != null) {
      str = localb.label;
    }
    str = getContext().getString(2131755806) + str;
    AppMethodBeat.o(39380);
    return str;
  }
  
  private Bitmap ful()
  {
    AppMethodBeat.i(39381);
    com.tencent.mm.modelvideo.o.aJy();
    Object localObject = t.DW(this.dpq.field_imgPath);
    if (localObject == null)
    {
      localObject = this.imagePath;
      if (!com.tencent.mm.plugin.a.c.FL(this.imagePath))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.Dl((String)localObject);
        AppMethodBeat.o(39381);
        return localObject;
      }
      localObject = com.tencent.mm.sdk.platformtools.f.aKz((String)localObject);
      AppMethodBeat.o(39381);
      return localObject;
    }
    localObject = com.tencent.mm.sdk.platformtools.f.aKz((String)localObject);
    AppMethodBeat.o(39381);
    return localObject;
  }
  
  private Bitmap fum()
  {
    AppMethodBeat.i(39382);
    if (this.dpq == null)
    {
      AppMethodBeat.o(39382);
      return null;
    }
    String str = this.dpq.field_imgPath;
    localBitmap3 = com.tencent.mm.av.o.aFx().Cm(str);
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
        ac.printErrStackTrace("MicroMsg.SelectConversationUI", localThrowable, "unexpected exception.", new Object[0]);
        Bitmap localBitmap2 = localBitmap3;
      }
    }
    AppMethodBeat.o(39382);
    return localBitmap1;
  }
  
  private void fun()
  {
    AppMethodBeat.i(39386);
    ac.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 14);
    localIntent.putExtra("titile", getString(2131755234));
    localIntent.putExtra("list_attr", u.IwV);
    localIntent.putExtra("already_select_contact", bs.n(this.IWQ, ","));
    localIntent.putExtra("max_limit_num", 9);
    if ((this.IyD) && (com.tencent.mm.storage.ai.aNc(this.IWL))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 5);
      AppMethodBeat.o(39386);
      return;
    }
  }
  
  private void fuo()
  {
    boolean bool = true;
    AppMethodBeat.i(39387);
    ac.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", u.IwS);
    localIntent.putExtra("list_type", 3);
    localIntent.putExtra("be_send_card_name", this.IWL);
    localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
    localIntent.putExtra("Add_SendCard", true);
    localIntent.putExtra("titile", getString(2131755234));
    if ((this.IyD) && (com.tencent.mm.storage.ai.aNc(this.IWL))) {}
    for (;;)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 3);
      AppMethodBeat.o(39387);
      return;
      bool = false;
    }
  }
  
  private void fup()
  {
    AppMethodBeat.i(39388);
    ac.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
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
      if ((this.IWK) && (!this.IWN.booleanValue()))
      {
        localIntent.putExtra("list_attr", u.I(new int[] { 16, 1, 2, 4, 16384 }));
        localIntent.putExtra("without_openim", true);
        localIntent.putExtra("KBlockOpenImFav", true);
      }
      else
      {
        localIntent.putExtra("list_attr", u.IwU);
      }
    }
  }
  
  private static String n(com.tencent.mm.ah.k.b paramb)
  {
    AppMethodBeat.i(39385);
    Object localObject1 = new pw();
    ((pw)localObject1).dsN.type = 0;
    ((pw)localObject1).dsN.dsP = paramb.hij;
    com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
    com.tencent.mm.protocal.b.a.c localc = ((pw)localObject1).dsO.dsX;
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localc != null)
    {
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = bs.bG(localc.desc, paramb.description);
      }
    }
    paramb = (com.tencent.mm.ah.k.b)localObject1;
    if (!bs.isNullOrNil((String)localObject1)) {
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
    if (aRv(paramString))
    {
      AppMethodBeat.o(39375);
      return;
    }
    if (u.hasAttr(this.iCp, 256))
    {
      r(-1, paramIntent);
      finish();
      AppMethodBeat.o(39375);
      return;
    }
    if (bs.isNullOrNil(paramString))
    {
      ac.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
      AppMethodBeat.o(39375);
      return;
    }
    if (w.sQ(paramString))
    {
      int i = com.tencent.mm.model.q.wb(paramString);
      if (this.IWJ)
      {
        int j = bs.getInt(com.tencent.mm.m.g.ZY().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50);
        if (i > j)
        {
          ac.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          com.tencent.mm.ui.base.h.c(this, getString(2131762995, new Object[] { Integer.valueOf(j) }), "", true);
          AppMethodBeat.o(39375);
          return;
        }
      }
      getString(2131762993, new Object[] { Integer.valueOf(i) });
    }
    o.a locala = new o.a(getContext());
    locala.dM(paramString);
    if (this.IyD)
    {
      a(locala, this.IWL);
      if (w.sQ(paramString))
      {
        b(paramIntent, this.IWL, paramString);
        locala.i(Boolean.TRUE);
      }
    }
    for (;;)
    {
      locala.DqS = fuj();
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
              ac.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", new Object[] { Integer.valueOf(13943), Integer.valueOf(paramAnonymousInt) });
              com.tencent.mm.plugin.report.service.h.wUl.f(13943, new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            com.tencent.mm.pluginsdk.ui.tools.o.lc(SelectConversationUI.j(SelectConversationUI.this), paramString);
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
              az.ayM();
              com.tencent.mm.model.c.awG().aNG(paramAnonymousString);
            }
          }
        }
      }.show();
      AppMethodBeat.o(39375);
      return;
      a(paramIntent, this.IWL, paramString);
      break;
      Object localObject1;
      if ((this.IWC) && (!this.qSE))
      {
        if ((getIntent().hasExtra("appbrand_params")) && (a(paramIntent, locala, null)))
        {
          AppMethodBeat.o(39375);
          return;
        }
        if (this.dcg != -1L)
        {
          a(locala);
          localObject1 = new gp();
          ((gp)localObject1).dhl.dcg = this.dcg;
          ((gp)localObject1).dhl.dhm = this.dhm;
          ((gp)localObject1).dhl.dhn = this.msgType;
          ((gp)localObject1).dhl.dho = locala;
          ((gp)localObject1).dhl.dhp = this.IWT;
          ((gp)localObject1).dhl.cZw = getContext();
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        for (;;)
        {
          locala.i(Boolean.TRUE);
          break;
          if ((this.msgType == 17) && (this.IWI != 0))
          {
            localObject1 = getContext().getString(2131762561, new Object[] { Integer.valueOf(this.IWI) });
            locala.aHp(getResources().getString(2131755817) + (String)localObject1);
          }
        }
      }
      String str;
      if ((this.IWD) && (!this.qSE))
      {
        Object localObject2 = (HashMap)getIntent().getSerializableExtra("webview_params");
        localObject1 = (String)((HashMap)localObject2).get("img_url");
        str = (String)((HashMap)localObject2).get("title");
        localObject2 = (String)((HashMap)localObject2).get("url");
        locala.aHp(getResources().getString(2131755920) + str);
        locala.a(new d.a.b()
        {
          public final void crN()
          {
            AppMethodBeat.i(39352);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", this.val$url);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.br.d.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(39352);
          }
        });
        locala.aHq((String)localObject1).eNC();
        locala.i(Boolean.TRUE);
      }
      else
      {
        if ((this.IWE) && (a(paramIntent, locala, paramString)))
        {
          AppMethodBeat.o(39375);
          return;
        }
        if (this.IWG)
        {
          str = getResources().getString(2131755788);
          localObject1 = str;
          if (this.nUX != null) {
            localObject1 = str + this.nUX;
          }
          locala.aHp((String)localObject1);
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
  
  private boolean xQ(boolean paramBoolean)
  {
    AppMethodBeat.i(39394);
    if (paramBoolean)
    {
      if (this.IWQ.size() < 9) {}
    }
    else {
      while (this.IWQ.size() > 9)
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
  
  public final void O(int paramInt, String paramString)
  {
    AppMethodBeat.i(39391);
    if (paramInt == 1)
    {
      this.IWQ.remove(paramString);
      frq().notifyDataSetChanged();
      WT();
    }
    AppMethodBeat.o(39391);
  }
  
  public final void WJ()
  {
    AppMethodBeat.i(39356);
    super.WJ();
    this.IWB = getIntent().getBooleanExtra("select_is_ret", false);
    this.fromScene = getIntent().getIntExtra("scene_from", 0);
    ac.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    if (this.fromScene == 1) {
      this.IWC = true;
    }
    for (;;)
    {
      this.qSE = getIntent().getBooleanExtra("is_mp_video", false);
      this.IWH = getIntent().getBooleanExtra("send_to_biz", false);
      this.ImY = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.dcg = getIntent().getLongExtra("select_fav_local_id", -1L);
      this.dhm = getIntent().getStringExtra("select_fav_fake_local_id");
      this.IWI = getIntent().getIntExtra("select_fav_select_count", 0);
      this.IWO = getIntent().getBooleanExtra("mutil_select_is_ret", false);
      this.IyD = getIntent().getBooleanExtra("Select_Send_Card", false);
      this.IWK = getIntent().getBooleanExtra("forward_card", false);
      this.IWJ = getIntent().getBooleanExtra("Retr_Big_File", false);
      if (this.IyD) {
        this.IWL = getIntent().getStringExtra("Select_Talker_Name");
      }
      this.iCp = getIntent().getIntExtra("Select_Conv_Type", IWz);
      this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
      this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      az.ayM();
      this.dpq = com.tencent.mm.model.c.awD().vP(this.msgId);
      this.imagePath = getIntent().getStringExtra("image_path");
      this.IWS = getIntent().getStringExtra("ad_video_title");
      this.nUX = getIntent().getStringExtra("desc_title");
      this.emojiMD5 = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.drV = getIntent().getStringExtra("Retr_Msg_content");
      this.IWT = getIntent().getStringExtra("Retr_fav_xml_str");
      if ((this.drV == null) && (this.dpq != null)) {
        this.drV = this.dpq.field_content;
      }
      if (this.drV == null) {
        this.drV = "";
      }
      this.IWR = ((ReportUtil.ReportArgs)getIntent().getParcelableExtra("Select_Report_Args"));
      this.IWU = getIntent().getStringExtra("KChooseMsgFileType");
      this.IWV = getIntent().getIntExtra("KChooseMsgFileCount", 9);
      this.IWW = getIntent().getStringExtra("KChooseMsgFileExtension");
      Object localObject1 = new HashSet();
      ((HashSet)localObject1).addAll(u.frC());
      Object localObject2 = getIntent().getStringExtra("Select_block_List");
      if (!bs.isNullOrNil((String)localObject2)) {
        ((HashSet)localObject1).addAll(bs.S(((String)localObject2).split(",")));
      }
      if (u.hasAttr(this.iCp, 2))
      {
        localObject2 = u.frD();
        u.i((HashSet)localObject2);
        ((HashSet)localObject1).addAll((Collection)localObject2);
      }
      this.fzw = new ArrayList();
      this.fzw.addAll((Collection)localObject1);
      localObject1 = this.fzw;
      long l = System.currentTimeMillis();
      int i = ((List)localObject1).size();
      ((List)localObject1).addAll(j.fdj());
      ac.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(((List)localObject1).size() - i) });
      if (u.hasAttr(this.iCp, 1)) {
        this.Iwz = true;
      }
      if (this.IWO)
      {
        this.IWQ = new LinkedList();
        if (this.IWO)
        {
          addTextOptionMenu(1, getString(2131755819), this.IWZ, null, s.b.Hom);
          WT();
        }
      }
      AppMethodBeat.o(39356);
      return;
      if ((this.fromScene != 2) && (this.fromScene != 10))
      {
        if (this.fromScene == 3)
        {
          getIntent();
          boolean bool = ch.bU(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("is_h5"));
          if (bool) {
            ac.i("MicroMsg.SelectConversationUI", "hy: is H5 link");
          }
          if (!bool) {}
        }
      }
      else
      {
        this.IWD = true;
        continue;
      }
      if (this.fromScene == 3) {
        this.IWE = true;
      } else if (this.fromScene == 6) {
        this.IWF = true;
      } else if (this.fromScene == 7) {
        this.IWG = true;
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
    if (this.HIi == null)
    {
      if (!this.IyD) {
        break label134;
      }
      this.IWA = 2131763014;
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
          if ((SelectConversationUI.c(SelectConversationUI.this)) && (bs.isNullOrNil(paramAnonymousView)))
          {
            SelectConversationUI.d(SelectConversationUI.this);
            AppMethodBeat.o(39335);
            return;
          }
          SelectConversationUI.e(SelectConversationUI.this);
          AppMethodBeat.o(39335);
        }
      };
      String str = getString(this.IWA);
      View localView = z.jD(this).inflate(2131494420, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131298778);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.HIi = ((TextView)localObject);
      this.HIi.setVisibility(paramInt);
      AppMethodBeat.o(39359);
      return;
      label134:
      if (this.fromScene == 10) {
        this.IWA = 2131761807;
      } else {
        this.IWA = 2131763002;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39390);
    if ((parama.Iwh) && (parama.contact != null))
    {
      boolean bool = this.IWQ.contains(parama.contact.field_username);
      AppMethodBeat.o(39390);
      return bool;
    }
    AppMethodBeat.o(39390);
    return false;
  }
  
  public final boolean aOi()
  {
    return (!this.IWO) || (!this.IWP);
  }
  
  public final boolean aOj()
  {
    return false;
  }
  
  public final String aOk()
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
  
  public final com.tencent.mm.ui.contact.q aOl()
  {
    AppMethodBeat.i(39357);
    ab localab = new ab(this, this.fzw, this.Iwz, this.IWP, this.IWH, this.iCp);
    AppMethodBeat.o(39357);
    return localab;
  }
  
  public final com.tencent.mm.ui.contact.o aOm()
  {
    AppMethodBeat.i(39358);
    s locals = new s(this, this.fzw, this.IWP, this.scene);
    AppMethodBeat.o(39358);
    return locals;
  }
  
  public final boolean aRv(String paramString)
  {
    AppMethodBeat.i(39365);
    if (!aRu(paramString))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if ((!bs.isNullOrNil(getIntent().getStringExtra("Select_App_Id"))) && (this.IyD))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if (this.IyD)
    {
      az.ayM();
      if (com.tencent.mm.storage.ai.YI(com.tencent.mm.model.c.awB().aNr(this.IWL).field_verifyFlag))
      {
        aRw(paramString);
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
    az.ayM();
    String str = com.tencent.mm.model.c.awD().alw(this.drV).zTO;
    az.ayM();
    if (w.nN(com.tencent.mm.model.c.awB().aNr(str).field_verifyFlag))
    {
      aRw(paramString);
      AppMethodBeat.o(39365);
      return true;
    }
    AppMethodBeat.o(39365);
    return false;
  }
  
  protected final void ary(String paramString)
  {
    AppMethodBeat.i(169903);
    ac.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (aRv(paramString))
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
      if ((this.IWB) || (this.IyD) || (this.IWC) || (this.IWD) || (this.IWE) || (this.qSE))
      {
        w(localIntent1, paramString);
      }
      else if (this.fromScene == 11)
      {
        aRx(paramString);
      }
      else
      {
        r(-1, localIntent1);
        finish();
      }
    }
  }
  
  public final int[] daw()
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
    arrayOfInt = super.daw();
    AppMethodBeat.o(39395);
    return arrayOfInt;
  }
  
  public final void dax()
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
      if (this.IWR != null)
      {
        this.IWR.errCode = 0;
        ReportUtil.a(this, this.IWR, true);
      }
      AppMethodBeat.o(39360);
      return;
      super.dax();
      hideVKB();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(39363);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      ac.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    Object localObject1;
    Object localObject2;
    while (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        ac.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
        localObject2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject2 != null)
        {
          if (aRv((String)localObject1))
          {
            AppMethodBeat.o(39363);
            return;
            ac.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
          }
          else
          {
            b(paramIntent, (Intent)localObject2);
            AppMethodBeat.o(39363);
          }
        }
        else
        {
          if ((this.IWB) || (this.IyD) || (this.IWC) || (this.IWD) || (this.IWE))
          {
            w(paramIntent, (String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          if (this.fromScene == 11)
          {
            aRx((String)localObject1);
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
        com.tencent.e.h.JZN.q(new Runnable()
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.aeD(), "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ReportUtil.U(false, 0);
          AppMethodBeat.o(39363);
          return;
        }
        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getBooleanExtra("Select_back_to_app", false)))
        {
          ReportUtil.a(this, ReportUtil.c(paramIntent.getExtras(), 0), false);
          AppMethodBeat.o(39363);
          return;
          if (paramIntent != null) {
            this.IWR = ((ReportUtil.ReportArgs)paramIntent.getParcelableExtra("Select_Report_Args"));
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
          if ((!bs.isNullOrNil(paramIntent)) && (!aRv(paramIntent)))
          {
            localObject1 = new o.a(getContext());
            ((o.a)localObject1).dM(paramIntent);
            a((o.a)localObject1, this.IWL);
            localObject1 = ((o.a)localObject1).i(Boolean.TRUE);
            ((o.a)localObject1).DqS = fuj();
            {
              public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
              {
                AppMethodBeat.i(39350);
                SelectConversationUI.this.hideVKB();
                Intent localIntent;
                if (paramAnonymousBoolean)
                {
                  localIntent = new Intent();
                  if (!w.sQ(paramIntent)) {
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
        localObject1 = this.IWQ.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.uFo.aGV((String)localObject2);
        }
        if (!bs.isNullOrNil(paramIntent)) {
          this.IWQ = bs.S(paramIntent.split(","));
        }
        for (;;)
        {
          paramIntent = this.IWQ.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.uFo.aGW((String)localObject1);
          }
          this.IWQ.clear();
        }
        WT();
        frq().notifyDataSetChanged();
      }
      AppMethodBeat.o(39363);
      return;
    }
    ac.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(39363);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39361);
    super.dax();
    AppMethodBeat.o(39361);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39355);
    com.tencent.mm.pluginsdk.g.o(this);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Select_App_Id");
    String str = getIntent().getStringExtra("Select_Open_Id");
    ac.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + paramBundle + ", openId = " + str);
    if ((!bs.isNullOrNil(paramBundle)) && (!bs.isNullOrNil(str))) {
      new com.tencent.mm.plugin.base.stub.d(this, paramBundle, str, new d.a()
      {
        public final void iT(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(39323);
          boolean bool = SelectConversationUI.this.isFinishing();
          ac.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + paramAnonymousBoolean + ", isFinishing = " + bool);
          if ((!paramAnonymousBoolean) && (!bool))
          {
            ReportUtil.ReportArgs localReportArgs = (ReportUtil.ReportArgs)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Report_Args");
            ReportUtil.a(SelectConversationUI.this, localReportArgs, false);
            SelectConversationUI.this.finish();
          }
          AppMethodBeat.o(39323);
        }
      }).bHP();
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
  
  public final void qG(int paramInt)
  {
    AppMethodBeat.i(39362);
    int i;
    Object localObject2;
    if (this.IWP)
    {
      i = paramInt - getContentLV().getHeaderViewsCount();
      if (i < 0)
      {
        ac.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
        fun();
        AppMethodBeat.o(39362);
        return;
      }
      localObject1 = frq();
      localObject2 = ((p)localObject1).abQ(i);
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
      ac.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[] { localObject2 });
      if ((!this.IWQ.contains(localObject2)) && (xQ(true)))
      {
        frx();
        AppMethodBeat.o(39362);
        return;
      }
      frx();
      this.uFo.aGU((String)localObject2);
      if (this.IWQ.contains(localObject2)) {
        this.IWQ.remove(localObject2);
      }
      for (;;)
      {
        WT();
        ((p)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(39362);
        return;
        this.IWQ.add(localObject2);
      }
    }
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      ac.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      if (this.IyD)
      {
        fuo();
        AppMethodBeat.o(39362);
        return;
      }
      fup();
      AppMethodBeat.o(39362);
      return;
    }
    Object localObject1 = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (localObject1 == null)
    {
      AppMethodBeat.o(39362);
      return;
    }
    if (((localObject1 instanceof com.tencent.mm.ui.contact.a.b)) && (((com.tencent.mm.ui.contact.a.b)localObject1).bLs == getResources().getString(2131755219)))
    {
      ac.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("list_attr", 16384);
      com.tencent.mm.br.d.b(this, "brandservice", ".ui.BrandServiceIndexUI", (Intent)localObject1, 4);
      this.IWD = true;
      AppMethodBeat.o(39362);
      return;
    }
    if ((localObject1 instanceof com.tencent.mm.ui.contact.a.g))
    {
      Object localObject3 = (com.tencent.mm.ui.contact.a.g)localObject1;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("scene", this.scene);
      localObject2 = new ArrayList();
      localObject3 = ((com.tencent.mm.ui.contact.a.a)localObject3).sxM.sym;
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
    ary(((av)localObject1).field_username);
    AppMethodBeat.o(39362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI
 * JD-Core Version:    0.7.0.1
 */