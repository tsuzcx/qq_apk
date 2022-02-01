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
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.a;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.g.a.rc.a;
import com.tencent.mm.g.a.rc.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.co;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bck;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.m;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
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
  private static final int Qzd;
  private int PMs;
  private boolean PWC;
  private boolean PYG;
  private TextView PbU;
  private String Qyg;
  private int QzA;
  private String QzB;
  private int QzC;
  private boolean QzD;
  protected boolean QzE;
  private MenuItem.OnMenuItemClickListener QzF;
  private MenuItem.OnMenuItemClickListener QzG;
  private int Qze;
  private boolean Qzf;
  private boolean Qzg;
  private boolean Qzh;
  private boolean Qzi;
  private boolean Qzj;
  private boolean Qzk;
  boolean Qzl;
  private boolean Qzm;
  private int Qzn;
  private boolean Qzo;
  private boolean Qzp;
  private String Qzq;
  private String Qzr;
  private Boolean Qzs;
  private boolean Qzt;
  private boolean Qzu;
  private List<String> Qzv;
  private ReportUtil.ReportArgs Qzw;
  private String Qzx;
  private String Qzy;
  private String Qzz;
  private long dFW;
  private String dLb;
  private ca dTX;
  private String dWG;
  private String emojiMD5;
  private int fromScene;
  private List<String> gzY;
  private String imagePath;
  private int jVX;
  private long msgId;
  private int msgType;
  private String pSD;
  boolean tkE;
  private int[] tnn;
  
  static
  {
    AppMethodBeat.i(39409);
    Qzd = u.Q(new int[] { 1, 2 });
    AppMethodBeat.o(39409);
  }
  
  public SelectConversationUI()
  {
    AppMethodBeat.i(39354);
    this.Qzf = false;
    this.Qzg = false;
    this.Qzh = false;
    this.Qzi = false;
    this.Qzj = false;
    this.Qzk = false;
    this.tkE = false;
    this.Qzl = false;
    this.fromScene = 0;
    this.Qzm = false;
    this.PYG = false;
    this.Qzo = false;
    this.Qzp = false;
    this.PMs = -1;
    this.Qzs = Boolean.FALSE;
    this.Qzt = false;
    this.Qzu = false;
    this.Qzv = null;
    this.Qyg = null;
    this.imagePath = null;
    this.Qzx = null;
    this.pSD = null;
    this.QzC = 0;
    this.QzD = false;
    this.QzE = false;
    this.tnn = new int[] { 2131298531, 2131298532, 2131298533, 2131298534, 2131298535 };
    this.QzF = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(234498);
        paramAnonymousMenuItem = SelectConversationUI.this;
        boolean bool;
        if (!SelectConversationUI.a(SelectConversationUI.this))
        {
          bool = true;
          SelectConversationUI.b(paramAnonymousMenuItem, bool);
          SelectConversationUI.this.gUP().Cp(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.this.PWl.Cp(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.n(SelectConversationUI.this);
          paramAnonymousMenuItem = SelectConversationUI.p(SelectConversationUI.this);
          if (SelectConversationUI.a(SelectConversationUI.this)) {
            break label112;
          }
        }
        label112:
        for (int i = SelectConversationUI.o(SelectConversationUI.this);; i = 2131765151)
        {
          paramAnonymousMenuItem.setText(i);
          AppMethodBeat.o(234498);
          return true;
          bool = false;
          break;
        }
      }
    };
    this.QzG = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(234499);
        if (SelectConversationUI.q(SelectConversationUI.this))
        {
          AppMethodBeat.o(234499);
          return false;
        }
        paramAnonymousMenuItem = SelectConversationUI.r(SelectConversationUI.this).iterator();
        while (paramAnonymousMenuItem.hasNext())
        {
          localObject = (String)paramAnonymousMenuItem.next();
          if (SelectConversationUI.this.bob((String)localObject))
          {
            AppMethodBeat.o(234499);
            return false;
          }
        }
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Conv_User", Util.listToString(SelectConversationUI.r(SelectConversationUI.this), ","));
        Object localObject = (Intent)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject != null) {
          SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem, (Intent)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(234499);
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
  
  private boolean CO(boolean paramBoolean)
  {
    AppMethodBeat.i(39394);
    if (paramBoolean)
    {
      if (this.Qzv.size() < 9) {}
    }
    else {
      while (this.Qzv.size() > 9)
      {
        String str = getString(2131765133, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9)) });
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
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39384);
    Object localObject = null;
    float f = paramInt2 / paramInt1;
    int k = 0;
    int j = 0;
    int m = at.aH(paramContext, 2131165264);
    paramInt1 = at.aH(paramContext, 2131165263);
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
    AppMethodBeat.i(234505);
    Object localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    ((e.a)localObject1).hZV = true;
    Object localObject2 = ((e.a)localObject1).aJT();
    localObject1 = View.inflate(this, 2131496295, null);
    View localView = ((View)localObject1).findViewById(2131300824);
    Object localObject3 = (ImageView)localView.findViewById(2131300773);
    com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.hXU;
    com.tencent.mm.loader.e.aJs().a(Util.nullAsNil(paramb.wDV.headUrl), (ImageView)localObject3, (com.tencent.mm.loader.c.e)localObject2);
    localObject2 = (TextView)localView.findViewById(2131301380);
    ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramb.wDV.nickName));
    ao.a(((TextView)localObject2).getPaint(), 0.8F);
    localObject2 = (ImageView)localView.findViewById(2131301497);
    localView.findViewById(2131301355);
    localObject3 = (TextView)localView.findViewById(2131300801);
    if (TextUtils.isEmpty(paramb.wDV.desc)) {
      ((TextView)localObject3).setVisibility(8);
    }
    for (;;)
    {
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).loadImage(paramb.wDV.coverUrl, (ImageView)localObject2);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      AppMethodBeat.o(234505);
      return localObject1;
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(paramb.wDV.desc);
    }
  }
  
  private View a(com.tencent.mm.plugin.i.a.d paramd)
  {
    AppMethodBeat.i(234501);
    View localView = View.inflate(this, 2131496293, null);
    TextView localTextView = (TextView)localView.findViewById(2131309195);
    FinderFeedAlbumView localFinderFeedAlbumView = (FinderFeedAlbumView)localView.findViewById(2131300556);
    localFinderFeedAlbumView.setItemViewWidth(com.tencent.mm.cb.a.fromDPToPix(localView.getContext(), 70));
    Object localObject = paramd.jle.LLt;
    localObject = ((List)localObject).subList(0, Math.min(4, ((List)localObject).size()));
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      cjl localcjl = new cjl();
      localcjl.url = ((String)paramd.jle.LLt.get(i));
      localcjl.url_token = ((String)paramd.jle.LLu.get(i));
      localcjl.thumb_url_token = localcjl.url_token;
      localcjl.thumbUrl = localcjl.url;
      localLinkedList.add(localcjl);
      i += 1;
    }
    localFinderFeedAlbumView.setAdapter(new com.tencent.mm.plugin.finder.view.adapter.b(localLinkedList, false));
    localTextView.setText(paramd.jle.title);
    AppMethodBeat.o(234501);
    return localView;
  }
  
  private View a(com.tencent.mm.plugin.i.a.f paramf)
  {
    AppMethodBeat.i(163387);
    Object localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    ((e.a)localObject1).hZV = true;
    Object localObject2 = ((e.a)localObject1).aJT();
    localObject1 = View.inflate(this, 2131496294, null);
    View localView = ((View)localObject1).findViewById(2131300824);
    Object localObject3 = (ImageView)localView.findViewById(2131300773);
    Object localObject4 = com.tencent.mm.loader.e.hXU;
    com.tencent.mm.loader.e.aJs().a(Util.nullAsNil(paramf.jlg.uNR), (ImageView)localObject3, (com.tencent.mm.loader.c.e)localObject2);
    localObject2 = (TextView)localView.findViewById(2131301380);
    ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramf.jlg.nickname));
    ao.a(((TextView)localObject2).getPaint(), 0.8F);
    localObject4 = (ImageView)localView.findViewById(2131301497);
    localObject2 = (ImageView)localView.findViewById(2131301355);
    localObject3 = (TextView)localView.findViewById(2131300801);
    if (paramf.jlg.vXJ == 1)
    {
      ((ImageView)localObject4).setVisibility(8);
      localObject4 = (TextView)localView.findViewById(2131301496);
      ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramf.jlg.desc));
      ((TextView)localObject4).setVisibility(0);
      ((TextView)localObject3).setVisibility(8);
      label223:
      if ((paramf.jlg.vXJ != 4) && (paramf.jlg.vXJ != 6)) {
        break label368;
      }
      ((ImageView)localObject2).setImageResource(2131232751);
    }
    for (;;)
    {
      ((ImageView)localObject2).setVisibility(8);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      AppMethodBeat.o(163387);
      return localObject1;
      if (paramf.jlg.mediaList.size() > 0) {
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).loadImage(((bch)paramf.jlg.mediaList.get(0)).thumbUrl, (ImageView)localObject4);
      }
      if (Util.isNullOrNil(paramf.jlg.desc)) {
        break;
      }
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramf.jlg.desc));
      break label223;
      label368:
      if ((paramf.jlg.vXJ == 2) && (paramf.jlg.mediaList.size() > 1)) {
        ((ImageView)localObject2).setImageResource(2131232681);
      }
    }
  }
  
  private View a(com.tencent.mm.plugin.i.a.i parami)
  {
    AppMethodBeat.i(234504);
    Object localObject1 = new e.a();
    ((e.a)localObject1).hZJ = true;
    ((e.a)localObject1).hZI = true;
    ((e.a)localObject1).hZV = true;
    Object localObject2 = ((e.a)localObject1).aJT();
    localObject1 = View.inflate(this, 2131496294, null);
    View localView = ((View)localObject1).findViewById(2131300824);
    ImageView localImageView = (ImageView)localView.findViewById(2131300773);
    Object localObject3 = com.tencent.mm.loader.e.hXU;
    com.tencent.mm.loader.e.aJs().a(Util.nullAsNil(parami.jlh.uNR), localImageView, (com.tencent.mm.loader.c.e)localObject2);
    localObject2 = (TextView)localView.findViewById(2131301380);
    ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, parami.jlh.nickname));
    ao.a(((TextView)localObject2).getPaint(), 0.8F);
    localObject2 = (ImageView)localView.findViewById(2131301497);
    localImageView = (ImageView)localView.findViewById(2131301355);
    localObject3 = (TextView)localView.findViewById(2131300801);
    if (parami.jlh.mediaList.size() > 0)
    {
      if (!Util.isNullOrNil(((cok)parami.jlh.mediaList.get(0)).coverUrl)) {
        ((aj)com.tencent.mm.kernel.g.ah(aj.class)).loadImage(((cok)parami.jlh.mediaList.get(0)).coverUrl, (ImageView)localObject2);
      }
    }
    else
    {
      if (Util.isNullOrNil(parami.jlh.desc)) {
        break label342;
      }
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, parami.jlh.desc));
    }
    for (;;)
    {
      localImageView.setImageResource(2131232751);
      localImageView.setVisibility(8);
      localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      AppMethodBeat.o(234504);
      return localObject1;
      ((aj)com.tencent.mm.kernel.g.ah(aj.class)).loadImage(((cok)parami.jlh.mediaList.get(0)).thumbUrl, (ImageView)localObject2);
      break;
      label342:
      ((TextView)localObject3).setVisibility(8);
    }
  }
  
  private View a(String paramString, com.tencent.mm.ag.k.b paramb, com.tencent.mm.pluginsdk.ui.tools.b paramb1)
  {
    AppMethodBeat.i(234503);
    Object localObject = new e.a();
    ((e.a)localObject).hZJ = true;
    ((e.a)localObject).hZI = true;
    ((e.a)localObject).hZV = true;
    ((e.a)localObject).aJT();
    localObject = View.inflate(this, 2131496301, null);
    ((RoundCornerRelativeLayout)((View)localObject).findViewById(2131307176)).setRadius(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4));
    View localView1 = ((View)localObject).findViewById(2131297645);
    View localView2 = ((View)localObject).findViewById(2131305087);
    MMRoundCornerImageView localMMRoundCornerImageView;
    TextView localTextView1;
    TextView localTextView3;
    if (ao.isDarkMode())
    {
      localView2.setBackgroundResource(2131234996);
      localMMRoundCornerImageView = (MMRoundCornerImageView)localView2.findViewById(2131298519);
      localTextView1 = (TextView)localView2.findViewById(2131298523);
      TextView localTextView2 = (TextView)localView2.findViewById(2131298524);
      localTextView3 = (TextView)localView2.findViewById(2131298521);
      localTextView2.setText(paramb.getTitle());
      if (Util.isNullOrNil(paramb.getDescription())) {
        break label419;
      }
      localTextView1.setText(paramb.getDescription());
      localTextView1.setVisibility(0);
      label191:
      String str = paramb1.Ktp;
      paramb1 = paramb1.Ktq;
      if (Util.isNullOrNil(paramb1)) {
        break label437;
      }
      ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6);
      ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 2);
      localView2.findViewById(2131305768).setVisibility(0);
      localTextView3.setText(paramb1 + getContext().getString(2131763368));
      localTextView3.setVisibility(0);
      label296:
      paramb1 = new boolean[1];
      paramb1[0] = 0;
      if (Util.isNullOrNil(str)) {
        break label455;
      }
      paramString = new c.a();
      paramString.fullPath = com.tencent.mm.plugin.music.h.b.aIf(str);
      paramString.jbf = true;
      paramString.iaT = true;
      paramString.jbd = true;
      paramString.jbx = com.tencent.mm.cb.a.fromDPToPix(getContext(), 2);
      paramString = paramString.bdv();
      com.tencent.mm.av.q.bcV().a(str, localMMRoundCornerImageView, paramString, new SelectConversationUI.28(this, localView1, paramb1));
    }
    for (;;)
    {
      localView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      AppMethodBeat.o(234503);
      return localObject;
      localView2.setBackgroundResource(2131234997);
      break;
      label419:
      localTextView1.setText("");
      localTextView1.setVisibility(8);
      break label191;
      label437:
      localTextView3.setText("");
      localTextView3.setVisibility(8);
      break label296;
      label455:
      if (!paramb.aSy())
      {
        bg.aVF();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          paramb = null;
          if (!bnh(paramString)) {
            paramb = com.tencent.mm.av.q.bcR().b(paramString, com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext()), false);
          }
          if ((paramb != null) && (!paramb.isRecycled()))
          {
            localMMRoundCornerImageView.setImageBitmap(paramb);
            paramString = com.tencent.xweb.util.d.getMessageDigest(paramString.getBytes());
            paramb1 = com.tencent.mm.plugin.comm.b.qCp;
            com.tencent.mm.plugin.comm.b.a(getContext(), localView1, paramb, paramString);
            continue;
          }
          paramb1[0] = 1;
          continue;
        }
      }
      localMMRoundCornerImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), 2131234278));
    }
  }
  
  private void a(final Intent paramIntent, o.a parama, final HashMap<String, Object> paramHashMap, boolean paramBoolean, String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(180098);
    String str1 = co.c(paramHashMap.get("app_id"), null);
    int i = co.getInt(paramHashMap.get("pkg_type"), 0);
    int j = co.getInt(paramHashMap.get("pkg_version"), 0);
    String str2 = co.c(paramHashMap.get("cache_key"), null);
    String str3 = co.c(paramHashMap.get("path"), null);
    String str4 = co.c(paramHashMap.get("delay_load_img_path"), null);
    Object localObject2 = co.c(paramHashMap.get("nickname"), "");
    boolean bool2 = co.cg(paramHashMap.get("is_dynamic"));
    int k = co.getInt(paramHashMap.get("subType"), 0);
    int m = co.getInt(paramHashMap.get("biz"), k.a.iwD.ordinal());
    String str5;
    Object localObject1;
    if (k.a.isValid(m))
    {
      str5 = co.c(paramHashMap.get("tail_lang"), "");
      String str6 = co.c(paramHashMap.get("icon_url"), "");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_biz", m);
      ((Bundle)localObject1).putString("key_footer_text_default", (String)localObject2);
      ((Bundle)localObject1).putString("key_footer_text", k.a.b(m, str5, getContext()));
      ((Bundle)localObject1).putString("key_footer_icon", str6);
      Log.d("MicroMsg.SelectConversationUI", "defaultFooterTxt: %s, tailLang: %s.", new Object[] { localObject2, str5 });
      localObject2 = (k)com.tencent.mm.kernel.g.af(k.class);
      if (paramString3 != null) {
        break label745;
      }
    }
    label745:
    for (boolean bool1 = false;; bool1 = com.tencent.mm.model.ab.IE(paramString3))
    {
      paramString3 = ((k)localObject2).a(this, (Bundle)localObject1, bool1, new k.c()
      {
        public final void aXL()
        {
          AppMethodBeat.i(234483);
          paramIntent.putExtra("KShowTodoIntroduceView", 1);
          g.a(SelectConversationUI.this, null);
          AppMethodBeat.o(234483);
        }
        
        public final void ft(boolean paramAnonymousBoolean) {}
      });
      localObject1 = n.cO(this);
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
        paramString1 = co.c(paramHashMap.get("video_path"), "");
        paramHashMap = co.c(paramHashMap.get("video_thumb_path"), "");
        ((Bundle)localObject2).putBoolean("is_video", true);
        ((Bundle)localObject2).putString("video_path", paramString1);
        ((Bundle)localObject2).putString("video_thumb_path", paramHashMap);
      }
      paramHashMap = new h(this);
      paramHashMap.QAE = new h.a()
      {
        public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(234484);
          paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
          if (paramAnonymousBoolean1)
          {
            paramIntent.putExtra("custom_send_text", paramAnonymousString);
            SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
            SelectConversationUI.this.finish();
          }
          for (;;)
          {
            ((k)com.tencent.mm.kernel.g.af(k.class)).a(this.lnN, paramString3);
            AppMethodBeat.o(234484);
            return;
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            if (SelectConversationUI.this.QzE) {
              SelectConversationUI.this.finish();
            }
          }
        }
      };
      ((k)com.tencent.mm.kernel.g.af(k.class)).a((String)localObject1, paramString3, (Bundle)localObject2, new com.tencent.mm.modelappbrand.k.b()
      {
        public final void sD(int paramAnonymousInt)
        {
          AppMethodBeat.i(234485);
          Log.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramHashMap.gYw();
          AppMethodBeat.o(234485);
        }
      });
      parama.gl(paramString3);
      parama.p(Boolean.TRUE);
      parama.gpz();
      parama.opQ = new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(234486);
          ((k)com.tencent.mm.kernel.g.af(k.class)).a(this.lnN, paramString3);
          AppMethodBeat.o(234486);
        }
      };
      parama.Kfh = gYi();
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(234487);
          SelectConversationUI.this.hideVKB();
          Object localObject = paramString3.getTag(2131296929);
          h localh = paramHashMap;
          if (localObject == null) {}
          for (boolean bool = false;; bool = ((Boolean)localObject).booleanValue())
          {
            localh.a(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt, bool);
            AppMethodBeat.o(234487);
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
        localObject2 = co.c(paramHashMap.get("footer_icon"), "");
        str5 = co.c(paramHashMap.get("footer_text"), "");
        ((Bundle)localObject1).putString("key_footer_icon", (String)localObject2);
        ((Bundle)localObject1).putString("key_footer_text", str5);
        break;
      }
      Log.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(m) });
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
      paramIntent.putExtra("received_card_name", Util.listToString(paramList, ","));
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
        public final void cXd()
        {
          AppMethodBeat.i(39338);
          Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", SelectConversationUI.j(SelectConversationUI.this));
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$22", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.kc(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39338);
        }
      });
      AppMethodBeat.o(39378);
      return;
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(39339);
          Log.i("MicroMsg.SelectConversationUI", "[ImageGalleryUI] showImgGallery");
          Object localObject = new Intent(SelectConversationUI.this.getContext(), ImageGalleryUI.class);
          ((Intent)localObject).putExtra("img_gallery_msg_id", SelectConversationUI.l(SelectConversationUI.this));
          ((Intent)localObject).putExtra("img_gallery_msg_svr_id", SelectConversationUI.m(SelectConversationUI.this).field_msgSvrId);
          ((Intent)localObject).putExtra("img_gallery_talker", SelectConversationUI.m(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_gallery_chatroom_name", SelectConversationUI.m(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_preview_only", true);
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.kc(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39339);
        }
      });
      AppMethodBeat.o(39378);
      return;
      bg.aVF();
      if (com.tencent.mm.model.c.aSQ() == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      bg.aVF();
      Object localObject = com.tencent.mm.model.c.aSQ().aEL(this.dWG);
      parama.a(new d.a.b()
      {
        public final void cXd()
        {
          AppMethodBeat.i(180090);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          localIntent.putExtra("kwebmap_slat", this.QzN.yFu);
          localIntent.putExtra("kwebmap_lng", this.QzN.yFv);
          localIntent.putExtra("Kwebmap_locaion", this.QzO);
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(180090);
        }
      });
      AppMethodBeat.o(39378);
      return;
      localObject = com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG));
      if (localObject == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      if (((((com.tencent.mm.ag.k.b)localObject).type == 5) && (!m.f(this.dTX, this.PMs))) || (((com.tencent.mm.ag.k.b)localObject).type == 69))
      {
        parama.a(new d.a.b()
        {
          public final void cXd()
          {
            AppMethodBeat.i(39340);
            if (Util.isNullOrNil(this.val$url))
            {
              AppMethodBeat.o(39340);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", this.val$url);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(39340);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ag.k.b)localObject).type == 6)
      {
        parama.a(new d.a.b()
        {
          public final void cXd()
          {
            AppMethodBeat.i(39341);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.l(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI$26", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$26", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(39341);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ag.k.b)localObject).type == 24)
      {
        parama.a(new d.a.b()
        {
          public final void cXd()
          {
            AppMethodBeat.i(39342);
            pa localpa = new pa();
            localpa.dVb.context = SelectConversationUI.this.getContext();
            localpa.dVb.msgId = SelectConversationUI.l(SelectConversationUI.this);
            localpa.dVb.dVc = this.msv.ixl;
            localpa.dVb.dUo = false;
            localpa.dVb.scene = 7;
            EventCenter.instance.publish(localpa);
            AppMethodBeat.o(39342);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.ag.k.b)localObject).type == 19)
      {
        parama.a(new d.a.b()
        {
          public final void cXd()
          {
            AppMethodBeat.i(39343);
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.l(SelectConversationUI.this));
            localIntent.putExtra("record_xml", this.msv.ixl);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(39343);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if ((((com.tencent.mm.ag.k.b)localObject).type == 3) || (((com.tencent.mm.ag.k.b)localObject).type == 76))
      {
        parama.a(new d.a.b()
        {
          public final void cXd()
          {
            AppMethodBeat.i(180091);
            Object localObject2 = com.tencent.mm.pluginsdk.model.app.q.R(this.msv.url, "message");
            String str = com.tencent.mm.pluginsdk.model.app.q.R(this.msv.iwH, "message");
            Object localObject1;
            if (NetStatusUtil.isMobile(SelectConversationUI.this.getContext()))
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
              com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
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
      if (((com.tencent.mm.ag.k.b)localObject).type == 4)
      {
        parama.a(new d.a.b()
        {
          public final void cXd()
          {
            AppMethodBeat.i(180092);
            AppMethodBeat.o(180092);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if ((((com.tencent.mm.ag.k.b)localObject).type == 53) || (((com.tencent.mm.ag.k.b)localObject).type == 57))
      {
        parama.a(new d.a.b()
        {
          public final void cXd()
          {
            AppMethodBeat.i(180093);
            Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
            ((Intent)localObject).putExtra("Retr_Msg_content", this.msv.title);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.kc(SelectConversationUI.this.getContext());
            AppMethodBeat.o(180093);
          }
        });
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void cXd()
          {
            AppMethodBeat.i(234493);
            Object localObject = com.tencent.mm.ui.chatting.l.ki(SelectConversationUI.this.getContext());
            localObject = com.tencent.mm.ag.k.b.HD(Util.processXml(com.tencent.mm.plugin.record.b.p.a(((rc)localObject).dXG.dXM.title, ((rc)localObject).dXG.dXM.desc, ((rc)localObject).dXG.dWX.dFZ.dGb, ((rc)localObject).dXF.from, SelectConversationUI.l(SelectConversationUI.this))));
            if (localObject == null)
            {
              AppMethodBeat.o(234493);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.l(SelectConversationUI.this));
            localIntent.putExtra("record_xml", ((com.tencent.mm.ag.k.b)localObject).ixl);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(234493);
          }
        });
        AppMethodBeat.o(39378);
        return;
        com.tencent.mm.ui.chatting.l.ki(getContext());
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void cXd()
          {
            AppMethodBeat.i(234494);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.l(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$33", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(234494);
          }
        });
      }
    }
  }
  
  private void a(o.a parama, String paramString)
  {
    AppMethodBeat.i(39371);
    bg.aVF();
    com.tencent.mm.model.c.aSN().bjJ(paramString);
    String str = com.tencent.mm.model.aa.getDisplayName(paramString);
    if (!Util.isNullOrNil(this.Qzr)) {
      str = this.Qzr;
    }
    parama.beQ(boe(paramString) + str);
    AppMethodBeat.o(39371);
  }
  
  private boolean a(final Intent paramIntent, final o.a parama, final String paramString)
  {
    AppMethodBeat.i(180097);
    Object localObject = (HashMap)getIntent().getSerializableExtra("appbrand_params");
    boolean bool1 = co.cg(((HashMap)localObject).get("is_weishi_video"));
    final boolean bool2 = co.cg(((HashMap)localObject).get("is_video"));
    if (bool1)
    {
      bool1 = a(parama, (HashMap)localObject);
      AppMethodBeat.o(180097);
      return bool1;
    }
    int i = co.getInt(((HashMap)localObject).get("type"), 1);
    final String str2 = co.c(((HashMap)localObject).get("title"), "");
    final String str1 = co.c(((HashMap)localObject).get("img_url"), null);
    int j = co.getInt(((HashMap)localObject).get("biz"), k.a.iwD.ordinal());
    if ((!k.a.isValid(j)) && ((i == 2) || (i == 3)))
    {
      if ((paramString != null) && (y.ama()) && (com.tencent.mm.model.ab.IE(paramString)) && (MultiProcessMMKV.getMMKV("group_to_do").getBoolean("introduce_dialog_first", true)))
      {
        MultiProcessMMKV.getMMKV("group_to_do").edit().putBoolean("introduce_dialog_first", false);
        g.a(this, new g.a()
        {
          public final void gUb()
          {
            AppMethodBeat.i(180080);
            paramIntent.putExtra("KShowTodoIntroduceView", 1);
            SelectConversationUI.a(SelectConversationUI.this, paramIntent, parama, this.QzJ, bool2, str1, str2, paramString);
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
      paramString = getResources().getString(2131755413);
      localObject = co.c(((HashMap)localObject).get("nickname"), null);
      if (Util.isNullOrNil((String)localObject)) {}
      for (;;)
      {
        parama.beQ(paramString + str2);
        paramString = new h(this);
        paramString.QAE = new h.a()
        {
          public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(234479);
            paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
            if (paramAnonymousBoolean1)
            {
              paramIntent.putExtra("custom_send_text", paramAnonymousString);
              SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
              SelectConversationUI.this.finish();
              AppMethodBeat.o(234479);
              return;
            }
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            if (SelectConversationUI.this.QzE) {
              SelectConversationUI.this.finish();
            }
            AppMethodBeat.o(234479);
          }
        };
        com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
        {
          public final void I(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(234480);
            paramString.gYw();
            AppMethodBeat.o(234480);
          }
          
          public final String Lb()
          {
            AppMethodBeat.i(234482);
            String str = n.cO(this);
            AppMethodBeat.o(234482);
            return str;
          }
          
          public final void aYg() {}
          
          public final void oD()
          {
            AppMethodBeat.i(234481);
            paramString.gYw();
            AppMethodBeat.o(234481);
          }
        }, str1, com.tencent.mm.modelappbrand.a.g.iJB);
        parama.p(Boolean.TRUE);
        parama.Kfh = gYi();
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
        paramString = Util.safeFormatString(getResources().getString(2131755807), new Object[] { localObject });
      }
    }
    parama.beQ(getResources().getString(2131755413) + str2);
    parama.beR(str1).gpy();
    parama.p(Boolean.TRUE);
    AppMethodBeat.o(180097);
    return false;
  }
  
  private boolean a(o.a parama, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(39377);
    final String str = co.c(paramHashMap.get("img_url"), null);
    if (!Util.isNullOrNil(str))
    {
      paramHashMap = new RelativeLayout(this);
      View localView = LayoutInflater.from(this).inflate(2131493702, null);
      paramHashMap.addView(localView, new RelativeLayout.LayoutParams(-2, -2));
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(14);
      final ImageView localImageView = (ImageView)localView.findViewById(2131304705);
      ((ImageView)localView.findViewById(2131302597)).setImageResource(2131691695);
      parama.gl(paramHashMap);
      parama.gpz();
      com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k()
      {
        public final void I(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(234488);
          if ((!SelectConversationUI.this.isFinishing()) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()) && (localImageView != null))
          {
            paramAnonymousBitmap = aq.a(SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBitmap, localImageView, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight()), at.fromDPToPix(SelectConversationUI.this, 3));
            localImageView.setImageBitmap(paramAnonymousBitmap);
          }
          AppMethodBeat.o(234488);
        }
        
        public final String Lb()
        {
          return "SelectConversationUI#WEISHITHUMB";
        }
        
        public final void aYg() {}
        
        public final void oD()
        {
          AppMethodBeat.i(234489);
          Log.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", new Object[] { str });
          AppMethodBeat.o(234489);
        }
      }, str, null, null);
    }
    for (;;)
    {
      parama.p(Boolean.TRUE);
      AppMethodBeat.o(39377);
      return false;
      paramHashMap = co.c(paramHashMap.get("msg_img_path"), null);
      if (!Util.isNullOrNil(paramHashMap))
      {
        Log.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", new Object[] { str, paramHashMap });
        parama.l(bof(paramHashMap), 2);
      }
    }
  }
  
  private void ani()
  {
    AppMethodBeat.i(39393);
    if (!this.Qzt)
    {
      AppMethodBeat.o(39393);
      return;
    }
    if ((this.Qzv != null) && (this.Qzv.size() > 0))
    {
      updateOptionMenuText(1, gYi() + "(" + this.Qzv.size() + ")");
      updateOptionMenuListener(1, this.QzG, null);
      enableOptionMenu(1, true);
      AppMethodBeat.o(39393);
      return;
    }
    if (!this.Qzu)
    {
      updateOptionMenuText(1, getString(2131755904));
      updateOptionMenuListener(1, this.QzF, null);
      enableOptionMenu(1, true);
      if (this.zoy != null) {
        this.zoy.setVisibility(8);
      }
      gUR();
      AppMethodBeat.o(39393);
      return;
    }
    updateOptionMenuText(1, getString(2131755989));
    updateOptionMenuListener(1, this.QzF, null);
    enableOptionMenu(1, true);
    if (this.zoy != null) {
      this.zoy.setVisibility(0);
    }
    gUS();
    AppMethodBeat.o(39393);
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
    com.tencent.mm.ag.k.b localb;
    switch (this.msgType)
    {
    case 6: 
    case 7: 
    case 14: 
    case 15: 
    case 17: 
    case 24: 
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
    case 23: 
    case 18: 
    case 22: 
    case 26: 
    case 20: 
    case 21: 
    case 25: 
    case 27: 
    case 28: 
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
                AppMethodBeat.o(180099);
                return;
                parama.beQ(this.dWG);
                parama.gpx();
                AppMethodBeat.o(180099);
                return;
                localObject1 = gYl();
                paramString = (String)localObject1;
                if (localObject1 == null)
                {
                  paramString = (String)localObject1;
                  if (this.imagePath != null)
                  {
                    float f = com.tencent.mm.cb.a.getDensity(MMApplicationContext.getContext());
                    paramString = BitmapUtil.getBitmapNative(this.imagePath, 140, 140, f);
                    int j = Exif.fromFile(this.imagePath).getOrientationInDegree();
                    i = j;
                    if (j < 0) {
                      i = 0;
                    }
                    paramString = BitmapUtil.rotate(paramString, i);
                  }
                }
                parama.l(paramString, 3);
                AppMethodBeat.o(180099);
                return;
                parama.l(gYk(), 2);
                AppMethodBeat.o(180099);
                return;
                parama.l(gYk(), 2);
                AppMethodBeat.o(180099);
                return;
                parama.beQ(gYj());
                AppMethodBeat.o(180099);
                return;
                if (!Util.isNullOrNil(this.emojiMD5))
                {
                  parama.beS(this.emojiMD5);
                  AppMethodBeat.o(180099);
                  return;
                }
                if (!Util.isNullOrNil(this.dTX.field_imgPath))
                {
                  parama.beS(this.dTX.field_imgPath);
                  AppMethodBeat.o(180099);
                  return;
                }
                parama.beS(this.imagePath);
                AppMethodBeat.o(180099);
                return;
                bg.aVF();
                paramString = com.tencent.mm.model.c.aSQ().aEK(this.dWG);
                this.Qzq = paramString.dkU;
                this.Qzr = paramString.nickname;
                this.Qzs = Boolean.valueOf(com.tencent.mm.model.ab.rR(paramString.IOs));
                a(parama, this.Qzq);
                AppMethodBeat.o(180099);
                return;
                paramString = (com.tencent.mm.plugin.finder.api.d)com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.finder.api.d.class);
              } while (paramString == null);
              parama.beQ(getString(2131755854) + paramString.title);
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.i.a.b)com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.b.class);
              if (paramString != null) {
                parama.gl(a(paramString));
              }
              parama.gpz();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.i.a.f)com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.f.class);
              if (paramString != null) {
                parama.gl(a(paramString));
              }
              parama.gpz();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.i.a.d)com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.d.class);
              if (paramString != null) {
                parama.gl(a(paramString));
              }
              parama.gpz();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.i.a.i)com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.i.class);
              if (paramString != null) {
                parama.gl(a(paramString));
              }
              parama.gpz();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.i.a.e)com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.e.class);
            } while (paramString == null);
            parama.beQ(getString(2131755856) + paramString.nickname);
            AppMethodBeat.o(180099);
            return;
            paramString = (com.tencent.mm.plugin.i.a.h)com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.h.class);
          } while ((paramString == null) || (paramString.jld == null));
          localObject1 = getString(2131755853);
          if (paramString.jld.tvC == 1) {
            paramString = (String)localObject1 + getString(2131760641, new Object[] { paramString.jld.dST });
          }
          for (;;)
          {
            parama.beQ(paramString);
            AppMethodBeat.o(180099);
            return;
            if (paramString.jld.tvC == 4) {
              paramString = (String)localObject1 + paramString.jld.desc;
            } else {
              paramString = (String)localObject1 + paramString.jld.dST;
            }
          }
          paramString = (com.tencent.mm.plugin.i.a.c)com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.c.class);
        } while ((paramString == null) || (paramString.jld.LLD == null));
        localObject1 = getString(2131755853);
        if (paramString.jld.tvC == 7) {}
        for (paramString = (String)localObject1 + MMApplicationContext.getContext().getString(2131759523, new Object[] { paramString.jld.LLD.LAr, paramString.jld.LLD.LAq });; paramString = (String)localObject1 + paramString.jld.dST)
        {
          parama.beQ(paramString);
          AppMethodBeat.o(180099);
          return;
        }
        paramString = (com.tencent.mm.plugin.i.a.g)com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG)).as(com.tencent.mm.plugin.i.a.g.class);
      } while ((paramString == null) || (paramString.wDZ == null));
      parama.beQ(paramString.wDZ.kHV);
      AppMethodBeat.o(180099);
      return;
    case 2: 
    case 10: 
      localb = com.tencent.mm.ag.k.b.HD(Util.processXml(this.dWG));
      if ((this.dTX.gAt()) && (localb == null)) {
        localb = com.tencent.mm.ag.k.b.aD(Util.processXml(this.dWG), Util.processXml(this.dWG));
      }
      break;
    }
    for (;;)
    {
      if (localb == null)
      {
        if (this.Qzx != null)
        {
          paramString = getResources().getString(2131756018);
          localObject1 = this.Qzx;
          parama.beQ(paramString + (String)localObject1);
        }
        AppMethodBeat.o(180099);
        return;
      }
      localObject1 = localb.title;
      if (m.f(this.dTX, this.PMs))
      {
        localObject2 = getResources().getString(2131755413);
        paramString = (String)localObject1;
        localObject1 = localObject2;
      }
      for (;;)
      {
        if (localb.type == 48) {
          localObject1 = getResources().getString(2131755867);
        }
        if (localb.type != 46) {
          break;
        }
        parama.l(gYl(), 2);
        AppMethodBeat.o(180099);
        return;
        if (localb.type == 5)
        {
          localObject2 = getResources().getString(2131756012);
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
        else if (localb.type == 6)
        {
          localObject2 = getResources().getString(2131755851);
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
        else if (localb.type == 24)
        {
          localObject1 = getResources().getString(2131755920);
          paramString = t(localb);
        }
        else if (localb.type == 19)
        {
          localObject2 = getResources().getString(2131755961);
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
        else if ((localb.type == 3) || (localb.type == 76))
        {
          localObject2 = (com.tencent.mm.pluginsdk.ui.tools.b)localb.as(com.tencent.mm.pluginsdk.ui.tools.b.class);
          if (localObject2 != null)
          {
            localObject1 = com.tencent.mm.av.q.bcR().d(this.dTX.field_imgPath, false, true);
            if (!Util.isNullOrNil((String)localObject1))
            {
              paramString = (String)localObject1;
              if (com.tencent.mm.vfs.s.YS((String)localObject1)) {}
            }
            else
            {
              paramString = this.Qyg;
            }
            parama.gl(a(paramString, localb, (com.tencent.mm.pluginsdk.ui.tools.b)localObject2));
            parama.gpz();
            AppMethodBeat.o(180099);
            return;
          }
          localObject2 = getResources().getString(2131755905);
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
        else if (localb.type == 4)
        {
          localObject2 = getResources().getString(2131756018);
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
        else if (localb.type == 8)
        {
          localObject2 = getResources().getString(2131755795);
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
        else if (localb.type == 44)
        {
          if (Util.isNullOrNil(localb.eah))
          {
            localObject2 = getResources().getString(2131755987);
            paramString = (String)localObject1;
            localObject1 = localObject2;
          }
          else
          {
            localObject2 = Util.safeFormatString(getResources().getString(2131755807), new Object[] { localb.eah });
            paramString = (String)localObject1;
            localObject1 = localObject2;
          }
        }
        else if ((localb.type == 33) || (localb.type == 36) || (localb.type == 48))
        {
          if ((localb.izk == 2) || (localb.izk == 3) || (localb.type == 36) || (localb.type == 48))
          {
            i = localb.izp;
            if (localb.fn(false))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("key_biz", i);
              ((Bundle)localObject1).putString("key_footer_text_default", localb.eah);
              ((Bundle)localObject1).putString("key_footer_text", localb.w(getContext(), false));
              ((Bundle)localObject1).putString("key_footer_icon", localb.izB);
              localObject2 = (k)com.tencent.mm.kernel.g.af(k.class);
              if (paramString != null) {
                break label2274;
              }
            }
            label2274:
            for (boolean bool = false;; bool = com.tencent.mm.model.ab.IE(paramString))
            {
              paramString = ((k)localObject2).a(this, (Bundle)localObject1, bool, new k.c()
              {
                public final void aXL()
                {
                  AppMethodBeat.i(234490);
                  SelectConversationUI.k(SelectConversationUI.this);
                  g.a(SelectConversationUI.this, null);
                  AppMethodBeat.o(234490);
                }
                
                public final void ft(boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(234491);
                  SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBoolean);
                  AppMethodBeat.o(234491);
                }
              });
              parama.gl(paramString);
              parama.p(Boolean.TRUE);
              parama.gpz();
              Object localObject3 = com.tencent.mm.av.q.bcR().d(this.dTX.field_imgPath, false, true);
              localObject1 = n.cO(this);
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("app_id", localb.izj);
              ((Bundle)localObject2).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(localb.izz), Integer.valueOf(localb.izm) }));
              ((Bundle)localObject2).putInt("msg_pkg_type", localb.izz);
              ((Bundle)localObject2).putInt("pkg_version", localb.izm);
              if (!Util.isNullOrNil((String)localObject3)) {
                ((Bundle)localObject2).putString("image_url", "file://".concat(String.valueOf(localObject3)));
              }
              localObject3 = (com.tencent.mm.ag.a)localb.as(com.tencent.mm.ag.a.class);
              if (localObject3 != null)
              {
                ((Bundle)localObject2).putBoolean("is_dynamic_page", ((com.tencent.mm.ag.a)localObject3).iuQ);
                ((Bundle)localObject2).putString("cache_key", ((com.tencent.mm.ag.a)localObject3).iuR);
                ((Bundle)localObject2).putInt("sub_type", ((com.tencent.mm.ag.a)localObject3).ivf);
              }
              ((Bundle)localObject2).putString("title", localb.title);
              ((Bundle)localObject2).putString("msg_path", localb.izh);
              ((k)com.tencent.mm.kernel.g.af(k.class)).a((String)localObject1, paramString, (Bundle)localObject2);
              parama.opQ = new DialogInterface.OnDismissListener()
              {
                public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(234492);
                  ((k)com.tencent.mm.kernel.g.af(k.class)).a(this.lnN, paramString);
                  AppMethodBeat.o(234492);
                }
              };
              AppMethodBeat.o(180099);
              return;
              if (localb.type == 48)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putBoolean("is_video", true);
                ((Bundle)localObject1).putString("key_footer_icon", localb.izB);
                ((Bundle)localObject1).putString("key_footer_text", localb.eah);
                break;
              }
              Log.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(i) });
              localObject1 = null;
              break;
            }
          }
          localObject2 = getResources().getString(2131755413);
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
        else if ((localb.type == 53) || (localb.type == 57))
        {
          localObject2 = "";
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = getResources().getString(2131755313);
          paramString = (String)localObject1;
          localObject1 = localObject2;
        }
      }
      if (localb.type == 69)
      {
        paramString = (com.tencent.mm.plugin.game.luggage.f.a)localb.as(com.tencent.mm.plugin.game.luggage.f.a.class);
        if (paramString != null)
        {
          parama.beQ(getResources().getString(2131755866) + paramString.nickName);
          if (!Util.isNullOrNil(paramString.iconUrl)) {
            parama.beR(paramString.iconUrl).gpy();
          }
        }
        AppMethodBeat.o(180099);
        return;
      }
      Object localObject2 = paramString;
      if (paramString == null) {
        localObject2 = "";
      }
      parama.beQ((String)localObject1 + (String)localObject2);
      if (localb.thumburl == null) {
        break;
      }
      parama.beR(localb.thumburl).gpy();
      AppMethodBeat.o(180099);
      return;
      paramString = Util.nullAs(com.tencent.mm.ui.chatting.l.ki(getContext()).dXG.dXM.title, "");
      parama.beQ(getResources().getString(2131755903) + paramString);
      AppMethodBeat.o(180099);
      return;
      paramString = com.tencent.mm.ui.chatting.l.ki(getContext());
      if (paramString.dXF.dXK != null) {}
      for (i = paramString.dXF.dXK.size();; i = 0)
      {
        paramString = getContext().getString(2131764630, new Object[] { Integer.valueOf(i) });
        parama.beQ(getResources().getString(2131755902) + paramString);
        AppMethodBeat.o(180099);
        return;
        if (this.pSD == null) {
          break;
        }
        parama.beQ(getResources().getString(2131755851) + this.pSD);
        break;
      }
    }
  }
  
  private static boolean bnh(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(234502);
    Object localObject = com.tencent.mm.av.q.bcR().d(paramString, false, true);
    if (!com.tencent.mm.vfs.s.YS((String)localObject))
    {
      AppMethodBeat.o(234502);
      return false;
    }
    paramString = new BitmapFactory.Options();
    paramString.inJustDecodeBounds = true;
    localObject = BitmapUtil.decodeFile((String)localObject, paramString);
    if (paramString.outWidth * paramString.outHeight > 1048576)
    {
      Log.i("MicroMsg.SelectConversationUI", "Bitmap to big:%d/%d", new Object[] { Integer.valueOf(paramString.outWidth), Integer.valueOf(paramString.outHeight) });
      bool = true;
    }
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    AppMethodBeat.o(234502);
    return bool;
  }
  
  private static boolean boa(String paramString)
  {
    AppMethodBeat.i(39364);
    if (as.bjp(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    if (com.tencent.mm.model.ab.Iy(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    AppMethodBeat.o(39364);
    return false;
  }
  
  private void boc(String paramString)
  {
    AppMethodBeat.i(39366);
    try
    {
      Object localObject = Util.stringsToList(paramString.split(","));
      paramString = new StringBuffer();
      localObject = ((List)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!Util.isNullOrNil(str))
        {
          if (i != 0) {
            paramString.append(",");
          }
          paramString.append(com.tencent.mm.model.aa.getDisplayName(str));
          i = 1;
        }
      }
      com.tencent.mm.ui.base.h.d(this, getString(2131765837, new Object[] { paramString }), "", null);
      AppMethodBeat.o(39366);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(39366);
    }
  }
  
  private void bod(String paramString)
  {
    AppMethodBeat.i(39367);
    Log.i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", new Object[] { paramString, this.Qzz, Integer.valueOf(this.QzA) });
    Log.i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", new Object[] { this.QzB });
    ((com.tencent.mm.choosemsgfile.compat.a)com.tencent.mm.kernel.g.af(com.tencent.mm.choosemsgfile.compat.a.class)).a(this, paramString, this.Qzz, this.QzA, this.QzB, new com.tencent.mm.choosemsgfile.compat.a.a()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, ArrayList<MsgFile> paramAnonymousArrayList)
      {
        AppMethodBeat.i(39351);
        Log.i("MicroMsg.SelectConversationUI", "resultCode:%d filePaths:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousArrayList });
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
  
  private String boe(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(39372);
    bg.aVF();
    as localas = com.tencent.mm.model.c.aSN().bjJ(paramString);
    Object localObject = getResources().getString(2131755864);
    if (localas == null)
    {
      AppMethodBeat.o(39372);
      return localObject;
    }
    bg.aVF();
    localObject = com.tencent.mm.model.c.aSQ().aEK(this.dWG);
    int i = j;
    if (localObject != null) {
      if (!com.tencent.mm.model.ab.rR(((ca.a)localObject).IOs))
      {
        i = j;
        if (!localas.gBM()) {}
      }
      else
      {
        i = 1;
      }
    }
    if (i != 0) {
      paramString = getResources().getString(2131755863);
    }
    for (;;)
    {
      AppMethodBeat.o(39372);
      return paramString;
      if (as.bjp(paramString)) {
        paramString = c(this, localas);
      } else {
        paramString = getResources().getString(2131755864);
      }
    }
  }
  
  private static Bitmap bof(String paramString)
  {
    AppMethodBeat.i(39383);
    localBitmap2 = com.tencent.mm.av.q.bcR().OB(paramString);
    localBitmap1 = localBitmap2;
    if (localBitmap2 != null) {}
    try
    {
      int j = Exif.fromFile(paramString).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap1 = BitmapUtil.rotate(localBitmap2, i);
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SelectConversationUI", paramString, "unexpected exception.", new Object[0]);
        localBitmap1 = localBitmap2;
      }
    }
    AppMethodBeat.o(39383);
    return localBitmap1;
  }
  
  public static String c(Context paramContext, as paramas)
  {
    AppMethodBeat.i(39373);
    paramas = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a(paramas.field_openImAppid, "openim_card_type_name", com.tencent.mm.openim.a.a.a.jGS);
    if (TextUtils.isEmpty(paramas)) {}
    for (paramContext = paramContext.getResources().getString(2131755864);; paramContext = String.format("[%s]", new Object[] { paramas }))
    {
      AppMethodBeat.o(39373);
      return paramContext;
    }
  }
  
  private void c(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(39374);
    Log.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=".concat(String.valueOf(paramIntent2)));
    paramIntent2.putExtras(paramIntent1.getExtras());
    startActivityForResult(paramIntent2, 2);
    com.tencent.mm.ui.base.b.az(getContext(), paramIntent2);
    AppMethodBeat.o(39374);
  }
  
  private String gYi()
  {
    AppMethodBeat.i(169904);
    String str2 = getIntent().getStringExtra("KSendWording");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = getString(2131755976);
    }
    AppMethodBeat.o(169904);
    return str1;
  }
  
  private String gYj()
  {
    AppMethodBeat.i(39380);
    bg.aVF();
    ca.b localb = com.tencent.mm.model.c.aSQ().aEL(this.dWG);
    String str = "";
    if (localb != null) {
      str = localb.label;
    }
    str = getContext().getString(2131755888) + str;
    AppMethodBeat.o(39380);
    return str;
  }
  
  private Bitmap gYk()
  {
    AppMethodBeat.i(39381);
    com.tencent.mm.modelvideo.o.bhj();
    Object localObject = t.Qx(this.dTX.field_imgPath);
    if (localObject == null)
    {
      localObject = this.imagePath;
      if (!com.tencent.mm.plugin.a.c.Sx(this.imagePath))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.PF((String)localObject);
        AppMethodBeat.o(39381);
        return localObject;
      }
      localObject = BitmapUtil.getBitmapNative((String)localObject);
      AppMethodBeat.o(39381);
      return localObject;
    }
    localObject = BitmapUtil.getBitmapNative((String)localObject);
    AppMethodBeat.o(39381);
    return localObject;
  }
  
  private Bitmap gYl()
  {
    AppMethodBeat.i(39382);
    if (this.dTX == null)
    {
      AppMethodBeat.o(39382);
      return null;
    }
    String str = this.dTX.field_imgPath;
    localBitmap3 = com.tencent.mm.av.q.bcR().OB(str);
    Bitmap localBitmap1 = localBitmap3;
    if (localBitmap3 != null) {}
    try
    {
      int j = Exif.fromFile(str).getOrientationInDegree();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      localBitmap1 = BitmapUtil.rotate(localBitmap3, i);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.SelectConversationUI", localThrowable, "unexpected exception.", new Object[0]);
        Bitmap localBitmap2 = localBitmap3;
      }
    }
    AppMethodBeat.o(39382);
    return localBitmap1;
  }
  
  private void gYm()
  {
    AppMethodBeat.i(39386);
    Log.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 14);
    localIntent.putExtra("titile", getString(2131755268));
    localIntent.putExtra("list_attr", u.PWY);
    localIntent.putExtra("already_select_contact", Util.listToString(this.Qzv, ","));
    localIntent.putExtra("max_limit_num", 9);
    if ((this.PYG) && (as.bjp(this.Qzq))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 5);
      AppMethodBeat.o(39386);
      return;
    }
  }
  
  private void gYn()
  {
    boolean bool = true;
    AppMethodBeat.i(39387);
    Log.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", u.PWV);
    localIntent.putExtra("list_type", 3);
    localIntent.putExtra("be_send_card_name", this.Qzq);
    localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
    localIntent.putExtra("Add_SendCard", true);
    localIntent.putExtra("titile", getString(2131755268));
    if ((this.PYG) && (as.bjp(this.Qzq))) {}
    for (;;)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 3);
      AppMethodBeat.o(39387);
      return;
      bool = false;
    }
  }
  
  private void gYo()
  {
    AppMethodBeat.i(39388);
    Log.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 5);
    localIntent.putExtra("titile", getString(2131755268));
    if (((this.fromScene != 4) && (this.fromScene != 9)) || ((getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || (this.fromScene == 10)))
    {
      localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
      localIntent.putExtra("list_attr", u.Q(new int[] { 32, 16, 1, 2, 4, 16384 }));
    }
    for (;;)
    {
      getContext().startActivityForResult(localIntent, 1);
      AppMethodBeat.o(39388);
      return;
      if ((this.Qzp) && (!this.Qzs.booleanValue()))
      {
        localIntent.putExtra("list_attr", u.Q(new int[] { 16, 1, 2, 4, 16384 }));
        localIntent.putExtra("without_openim", true);
        localIntent.putExtra("KBlockOpenImFav", true);
      }
      else
      {
        localIntent.putExtra("list_attr", u.PWX);
      }
    }
  }
  
  private void s(int paramInt, Intent paramIntent)
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
  
  private static String t(com.tencent.mm.ag.k.b paramb)
  {
    AppMethodBeat.i(39385);
    Object localObject1 = new rc();
    ((rc)localObject1).dXF.type = 0;
    ((rc)localObject1).dXF.dXH = paramb.ixl;
    EventCenter.instance.publish((IEvent)localObject1);
    com.tencent.mm.protocal.b.a.c localc = ((rc)localObject1).dXG.dXP;
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localc != null)
    {
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = Util.nullAs(localc.desc, paramb.description);
      }
    }
    paramb = (com.tencent.mm.ag.k.b)localObject1;
    if (!Util.isNullOrNil((String)localObject1)) {
      paramb = ((String)localObject1).replaceAll("\n", " ");
    }
    AppMethodBeat.o(39385);
    return paramb;
  }
  
  private void u(final Intent paramIntent, final String paramString)
  {
    AppMethodBeat.i(39375);
    if (bob(paramString))
    {
      AppMethodBeat.o(39375);
      return;
    }
    if (u.hasAttr(this.jVX, 256))
    {
      s(-1, paramIntent);
      finish();
      AppMethodBeat.o(39375);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
      AppMethodBeat.o(39375);
      return;
    }
    if (com.tencent.mm.model.ab.Eq(paramString))
    {
      int i = v.Ie(paramString);
      if (this.Qzo)
      {
        int j = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50);
        if (i > j)
        {
          Log.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          com.tencent.mm.ui.base.h.c(this, getString(2131765132, new Object[] { Integer.valueOf(j) }), "", true);
          AppMethodBeat.o(39375);
          return;
        }
      }
      getString(2131765130, new Object[] { Integer.valueOf(i) });
    }
    o.a locala = new o.a(getContext());
    locala.ea(paramString);
    if (this.PYG)
    {
      a(locala, this.Qzq);
      if (com.tencent.mm.model.ab.Eq(paramString))
      {
        b(paramIntent, this.Qzq, paramString);
        locala.p(Boolean.TRUE);
      }
    }
    for (;;)
    {
      locala.Kfh = gYi();
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
              Log.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", new Object[] { Integer.valueOf(13943), Integer.valueOf(paramAnonymousInt) });
              com.tencent.mm.plugin.report.service.h.CyF.a(13943, new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            com.tencent.mm.pluginsdk.ui.tools.q.mG(SelectConversationUI.j(SelectConversationUI.this), paramString);
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
              bg.aVF();
              com.tencent.mm.model.c.aST().bjW(paramAnonymousString);
            }
          }
        }
      }.show();
      AppMethodBeat.o(39375);
      return;
      a(paramIntent, this.Qzq, paramString);
      break;
      Object localObject;
      if (this.Qzg)
      {
        if ((getIntent().hasExtra("appbrand_params")) && (a(paramIntent, locala, null)))
        {
          AppMethodBeat.o(39375);
          return;
        }
        if (this.dFW != -1L)
        {
          a(locala);
          localObject = new gx();
          ((gx)localObject).dLa.dFW = this.dFW;
          ((gx)localObject).dLa.dLb = this.dLb;
          ((gx)localObject).dLa.dLc = this.msgType;
          ((gx)localObject).dLa.dLd = locala;
          ((gx)localObject).dLa.dLe = this.Qzy;
          ((gx)localObject).dLa.dDg = getContext();
          EventCenter.instance.publish((IEvent)localObject);
        }
        for (;;)
        {
          locala.p(Boolean.TRUE);
          break;
          if ((this.msgType == 17) && (this.Qzn != 0))
          {
            localObject = getContext().getString(2131764630, new Object[] { Integer.valueOf(this.Qzn) });
            locala.beQ(getResources().getString(2131755902) + (String)localObject);
          }
        }
      }
      String str1;
      if ((this.Qzh) && (!this.tkE))
      {
        localObject = (HashMap)getIntent().getSerializableExtra("webview_params");
        str1 = (String)((HashMap)localObject).get("img_url");
        String str3 = (String)((HashMap)localObject).get("title");
        final String str2 = (String)((HashMap)localObject).get("url");
        if (!this.Qzl) {}
        for (localObject = getResources().getString(2131756012) + str3;; localObject = getResources().getString(2131755866) + (String)localObject)
        {
          locala.beQ((String)localObject);
          locala.a(new d.a.b()
          {
            public final void cXd()
            {
              AppMethodBeat.i(39352);
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", str2);
              localIntent.putExtra("showShare", false);
              com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
              AppMethodBeat.o(39352);
            }
          });
          locala.beR(str1).gpy();
          locala.p(Boolean.TRUE);
          break;
          localObject = (String)((HashMap)localObject).get("nickname");
        }
      }
      if ((this.Qzi) && (a(paramIntent, locala, paramString)))
      {
        AppMethodBeat.o(39375);
        return;
      }
      if (this.Qzk)
      {
        str1 = getResources().getString(2131755869);
        localObject = str1;
        if (this.pSD != null) {
          localObject = str1 + this.pSD;
        }
        locala.beQ((String)localObject);
        locala.p(Boolean.FALSE);
      }
      else
      {
        b(locala, paramString);
        a(locala);
        locala.p(Boolean.TRUE);
      }
    }
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(234500);
    int i;
    Object localObject1;
    if (this.Qzu)
    {
      i = paramInt - getContentLV().getHeaderViewsCount();
      if (i < 0)
      {
        Log.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
        gYm();
        AppMethodBeat.o(234500);
        return;
      }
      paramView = gUP();
      localObject1 = paramView.anH(i);
      if (localObject1 == null)
      {
        AppMethodBeat.o(234500);
        return;
      }
      if (((com.tencent.mm.ui.contact.a.a)localObject1).contact == null)
      {
        AppMethodBeat.o(234500);
        return;
      }
      localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username;
      Log.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[] { localObject1 });
      if ((!this.Qzv.contains(localObject1)) && (CO(true)))
      {
        gUW();
        AppMethodBeat.o(234500);
        return;
      }
      gUW();
      this.zoy.bev((String)localObject1);
      if (this.Qzv.contains(localObject1)) {
        this.Qzv.remove(localObject1);
      }
      for (;;)
      {
        ani();
        paramView.notifyDataSetChanged();
        AppMethodBeat.o(234500);
        return;
        this.Qzv.add(localObject1);
      }
    }
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      if (this.PYG)
      {
        gYn();
        AppMethodBeat.o(234500);
        return;
      }
      gYo();
      AppMethodBeat.o(234500);
      return;
    }
    paramView = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
    if (paramView == null)
    {
      AppMethodBeat.o(234500);
      return;
    }
    if (((paramView instanceof com.tencent.mm.ui.contact.a.b)) && (((com.tencent.mm.ui.contact.a.b)paramView).nickName == getResources().getString(2131755252)))
    {
      Log.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
      paramView = new Intent();
      paramView.putExtra("list_attr", 16384);
      com.tencent.mm.br.c.b(this, "brandservice", ".ui.BrandServiceIndexUI", paramView, 4);
      this.Qzh = true;
      AppMethodBeat.o(234500);
      return;
    }
    if ((paramView instanceof com.tencent.mm.ui.contact.a.g))
    {
      Object localObject2 = (com.tencent.mm.ui.contact.a.g)paramView;
      paramView = new Intent();
      paramView.putExtra("scene", this.scene);
      localObject1 = new ArrayList();
      localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject2).wWd.wWD;
      i = localObject2.length;
      paramInt = 0;
      while (paramInt < i)
      {
        ((ArrayList)localObject1).add(localObject2[paramInt]);
        paramInt += 1;
      }
      paramView.putExtra("query_phrase_list", (Serializable)localObject1);
      com.tencent.mm.br.c.c(this, ".ui.transmit.MMCreateChatroomUI", paramView, 1);
      AppMethodBeat.o(234500);
      return;
    }
    paramView = paramView.contact;
    if (paramView == null)
    {
      AppMethodBeat.o(234500);
      return;
    }
    aMp(paramView.field_username);
    AppMethodBeat.o(234500);
  }
  
  public final void T(int paramInt, String paramString)
  {
    AppMethodBeat.i(39391);
    if (paramInt == 1)
    {
      this.Qzv.remove(paramString);
      gUP().notifyDataSetChanged();
      ani();
    }
    AppMethodBeat.o(39391);
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
    if (this.PbU == null)
    {
      if (!this.PYG) {
        break label134;
      }
      this.Qze = 2131765151;
    }
    for (;;)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39335);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/transmit/SelectConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (SelectConversationUI.a(SelectConversationUI.this)) {
            SelectConversationUI.b(SelectConversationUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(39335);
            return;
            paramAnonymousView = SelectConversationUI.this.getIntent().getStringExtra("Select_App_Id");
            if ((SelectConversationUI.c(SelectConversationUI.this)) && (Util.isNullOrNil(paramAnonymousView))) {
              SelectConversationUI.d(SelectConversationUI.this);
            } else {
              SelectConversationUI.e(SelectConversationUI.this);
            }
          }
        }
      };
      String str = getString(this.Qze);
      View localView = com.tencent.mm.ui.aa.jQ(this).inflate(2131494993, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(2131299223);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.PbU = ((TextView)localObject);
      this.PbU.setVisibility(paramInt);
      AppMethodBeat.o(39359);
      return;
      label134:
      if (this.fromScene == 10) {
        this.Qze = 2131763781;
      } else {
        this.Qze = 2131765139;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39390);
    if ((parama.PWh) && (parama.contact != null))
    {
      boolean bool = this.Qzv.contains(parama.contact.field_username);
      AppMethodBeat.o(39390);
      return bool;
    }
    AppMethodBeat.o(39390);
    return false;
  }
  
  protected final void aMp(String paramString)
  {
    AppMethodBeat.i(169903);
    Log.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (bob(paramString))
    {
      AppMethodBeat.o(169903);
      return;
    }
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("Select_Conv_User", paramString);
    Intent localIntent2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
    if (localIntent2 != null) {
      c(localIntent1, localIntent2);
    }
    for (;;)
    {
      hideVKB();
      AppMethodBeat.o(169903);
      return;
      if ((this.Qzf) || (this.PYG) || (this.Qzg) || (this.Qzh) || (this.Qzi) || (this.tkE))
      {
        u(localIntent1, paramString);
      }
      else if (this.fromScene == 11)
      {
        bod(paramString);
      }
      else
      {
        s(-1, localIntent1);
        finish();
      }
    }
  }
  
  public final void amZ()
  {
    AppMethodBeat.i(39356);
    super.amZ();
    this.Qzf = getIntent().getBooleanExtra("select_is_ret", false);
    this.fromScene = getIntent().getIntExtra("scene_from", 0);
    Log.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    if (this.fromScene == 1) {
      this.Qzg = true;
    }
    for (;;)
    {
      this.tkE = getIntent().getBooleanExtra("is_mp_video", false);
      this.Qzl = getIntent().getBooleanExtra("is_game_card", false);
      this.Qzm = getIntent().getBooleanExtra("send_to_biz", false);
      this.PMs = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.dFW = getIntent().getLongExtra("select_fav_local_id", -1L);
      this.dLb = getIntent().getStringExtra("select_fav_fake_local_id");
      this.Qzn = getIntent().getIntExtra("select_fav_select_count", 0);
      this.Qzt = getIntent().getBooleanExtra("mutil_select_is_ret", false);
      this.PYG = getIntent().getBooleanExtra("Select_Send_Card", false);
      this.Qzp = getIntent().getBooleanExtra("forward_card", false);
      this.Qzo = getIntent().getBooleanExtra("Retr_Big_File", false);
      if (this.PYG) {
        this.Qzq = getIntent().getStringExtra("Select_Talker_Name");
      }
      this.jVX = getIntent().getIntExtra("Select_Conv_Type", Qzd);
      this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
      this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      bg.aVF();
      this.dTX = com.tencent.mm.model.c.aSQ().Hb(this.msgId);
      this.imagePath = getIntent().getStringExtra("image_path");
      this.Qzx = getIntent().getStringExtra("ad_video_title");
      this.pSD = getIntent().getStringExtra("desc_title");
      this.emojiMD5 = getIntent().getStringExtra("Retr_Msg_thumb_path");
      this.dWG = getIntent().getStringExtra("Retr_Msg_content");
      this.Qzy = getIntent().getStringExtra("Retr_fav_xml_str");
      this.Qyg = getIntent().getStringExtra("Retr_Msg_thumb_path");
      if ((this.dWG == null) && (this.dTX != null)) {
        this.dWG = this.dTX.field_content;
      }
      if (this.dWG == null) {
        this.dWG = "";
      }
      this.Qzw = ((ReportUtil.ReportArgs)getIntent().getParcelableExtra("Select_Report_Args"));
      this.Qzz = getIntent().getStringExtra("KChooseMsgFileType");
      this.QzA = getIntent().getIntExtra("KChooseMsgFileCount", 9);
      this.QzB = getIntent().getStringExtra("KChooseMsgFileExtension");
      Object localObject1 = new HashSet();
      ((HashSet)localObject1).addAll(u.gVb());
      Object localObject2 = getIntent().getStringExtra("Select_block_List");
      if (!Util.isNullOrNil((String)localObject2)) {
        ((HashSet)localObject1).addAll(Util.stringsToList(((String)localObject2).split(",")));
      }
      if (u.hasAttr(this.jVX, 2))
      {
        localObject2 = u.gVc();
        u.h((HashSet)localObject2);
        ((HashSet)localObject1).addAll((Collection)localObject2);
      }
      this.gzY = new ArrayList();
      this.gzY.addAll((Collection)localObject1);
      localObject1 = this.gzY;
      long l = System.currentTimeMillis();
      int i = ((List)localObject1).size();
      ((List)localObject1).addAll(com.tencent.mm.pluginsdk.i.a.gnp());
      Log.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(((List)localObject1).size() - i) });
      if (u.hasAttr(this.jVX, 1)) {
        this.PWC = true;
      }
      if (this.Qzt)
      {
        this.Qzv = new LinkedList();
        if (this.Qzt)
        {
          addTextOptionMenu(1, getString(2131755904), this.QzF, null, t.b.OGU);
          ani();
        }
      }
      AppMethodBeat.o(39356);
      return;
      if ((this.fromScene != 2) && (this.fromScene != 10))
      {
        if (this.fromScene == 3)
        {
          getIntent();
          boolean bool = co.cg(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("is_h5"));
          if (bool) {
            Log.i("MicroMsg.SelectConversationUI", "hy: is H5 link");
          }
          if (!bool) {}
        }
      }
      else
      {
        this.Qzh = true;
        continue;
      }
      if (this.fromScene == 3) {
        this.Qzi = true;
      } else if (this.fromScene == 6) {
        this.Qzj = true;
      } else if (this.fromScene == 7) {
        this.Qzk = true;
      } else if (this.fromScene == 11) {
        overridePendingTransition(2130772132, 2130772130);
      }
    }
  }
  
  public final boolean bmA()
  {
    return false;
  }
  
  public final String bmB()
  {
    AppMethodBeat.i(39389);
    String str = getIntent().getStringExtra("Select_Conv_ui_title");
    if ((str == null) || (str.length() <= 0))
    {
      str = getString(2131765142);
      AppMethodBeat.o(39389);
      return str;
    }
    AppMethodBeat.o(39389);
    return str;
  }
  
  public final com.tencent.mm.ui.contact.q bmC()
  {
    AppMethodBeat.i(39357);
    com.tencent.mm.ui.contact.ab localab = new com.tencent.mm.ui.contact.ab(this, this.gzY, this.PWC, this.Qzu, this.Qzm, this.jVX);
    AppMethodBeat.o(39357);
    return localab;
  }
  
  public final com.tencent.mm.ui.contact.o bmD()
  {
    AppMethodBeat.i(39358);
    com.tencent.mm.ui.contact.s locals = new com.tencent.mm.ui.contact.s(this, this.gzY, this.Qzu, this.scene);
    AppMethodBeat.o(39358);
    return locals;
  }
  
  public final boolean bmz()
  {
    return (!this.Qzt) || (!this.Qzu);
  }
  
  public final boolean bob(String paramString)
  {
    AppMethodBeat.i(39365);
    if (!boa(paramString))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if ((!Util.isNullOrNil(getIntent().getStringExtra("Select_App_Id"))) && (this.PYG))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if (this.PYG)
    {
      bg.aVF();
      if (as.akh(com.tencent.mm.model.c.aSN().bjJ(this.Qzq).field_verifyFlag))
      {
        boc(paramString);
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
    bg.aVF();
    String str = com.tencent.mm.model.c.aSQ().aEK(this.dWG).dkU;
    bg.aVF();
    if (com.tencent.mm.model.ab.rR(com.tencent.mm.model.c.aSN().bjJ(str).field_verifyFlag))
    {
      boc(paramString);
      AppMethodBeat.o(39365);
      return true;
    }
    AppMethodBeat.o(39365);
    return false;
  }
  
  public final int[] egI()
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
    arrayOfInt = super.egI();
    AppMethodBeat.o(39395);
    return arrayOfInt;
  }
  
  public final void egJ()
  {
    AppMethodBeat.i(39360);
    if (this.fromScene == 5) {
      com.tencent.mm.ui.base.h.a(this, getString(2131762723), null, getString(2131765202), getString(2131756929), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      if (this.Qzw != null)
      {
        this.Qzw.errCode = 0;
        ReportUtil.a(this, this.Qzw, true);
      }
      AppMethodBeat.o(39360);
      return;
      super.egJ();
      hideVKB();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(39363);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      Log.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
    }
    Object localObject1;
    Object localObject2;
    while (paramInt1 == 1) {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        Log.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
        localObject2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject2 != null)
        {
          if (bob((String)localObject1))
          {
            AppMethodBeat.o(39363);
            return;
            Log.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
          }
          else
          {
            c(paramIntent, (Intent)localObject2);
            AppMethodBeat.o(39363);
          }
        }
        else
        {
          if ((this.Qzf) || (this.PYG) || (this.Qzg) || (this.Qzh) || (this.Qzi))
          {
            u(paramIntent, (String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          if (this.fromScene == 11)
          {
            bod((String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          s(-1, paramIntent);
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
        com.tencent.f.h.RTc.o(new Runnable()
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
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.axQ(), "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ReportUtil.ab(false, 0);
          AppMethodBeat.o(39363);
          return;
        }
        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getBooleanExtra("Select_back_to_app", false)))
        {
          ReportUtil.a(this, ReportUtil.d(paramIntent.getExtras(), 0), false);
          AppMethodBeat.o(39363);
          return;
          if (paramIntent != null) {
            this.Qzw = ((ReportUtil.ReportArgs)paramIntent.getParcelableExtra("Select_Report_Args"));
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
          if ((!Util.isNullOrNil(paramIntent)) && (!bob(paramIntent)))
          {
            localObject1 = new o.a(getContext());
            ((o.a)localObject1).ea(paramIntent);
            a((o.a)localObject1, this.Qzq);
            localObject1 = ((o.a)localObject1).p(Boolean.TRUE);
            ((o.a)localObject1).Kfh = gYi();
            {
              public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
              {
                AppMethodBeat.i(39350);
                SelectConversationUI.this.hideVKB();
                Intent localIntent;
                if (paramAnonymousBoolean)
                {
                  localIntent = new Intent();
                  if (!com.tencent.mm.model.ab.Eq(paramIntent)) {
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
        u(paramIntent, paramIntent.getStringExtra("Select_Contact"));
      }
      AppMethodBeat.o(39363);
      return;
    }
    if (paramInt1 == 5)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        localObject1 = this.Qzv.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.zoy.bew((String)localObject2);
        }
        if (!Util.isNullOrNil(paramIntent)) {
          this.Qzv = Util.stringsToList(paramIntent.split(","));
        }
        for (;;)
        {
          paramIntent = this.Qzv.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.zoy.bex((String)localObject1);
          }
          this.Qzv.clear();
        }
        ani();
        gUP().notifyDataSetChanged();
      }
      AppMethodBeat.o(39363);
      return;
    }
    Log.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
    AppMethodBeat.o(39363);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39361);
    super.egJ();
    AppMethodBeat.o(39361);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39355);
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getStringExtra("Select_App_Id");
    String str = getIntent().getStringExtra("Select_Open_Id");
    Log.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + paramBundle + ", openId = " + str);
    if ((!Util.isNullOrNil(paramBundle)) && (!Util.isNullOrNil(str))) {
      new com.tencent.mm.plugin.base.stub.d(this, paramBundle, str, new d.a()
      {
        public final void jZ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(39323);
          boolean bool = SelectConversationUI.this.isFinishing();
          Log.i("MicroMsg.SelectConversationUI", "onCheckEnd, isPass = " + paramAnonymousBoolean + ", isFinishing = " + bool);
          if ((!paramAnonymousBoolean) && (!bool))
          {
            ReportUtil.ReportArgs localReportArgs = (ReportUtil.ReportArgs)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Report_Args");
            ReportUtil.a(SelectConversationUI.this, localReportArgs, false);
            SelectConversationUI.this.finish();
          }
          AppMethodBeat.o(39323);
        }
      }).cjR();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI
 * JD-Core Version:    0.7.0.1
 */