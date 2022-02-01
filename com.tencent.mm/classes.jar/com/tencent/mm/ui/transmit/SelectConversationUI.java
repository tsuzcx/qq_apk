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
import android.os.SystemClock;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.a;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.he;
import com.tencent.mm.f.a.px;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.f.a.sc.a;
import com.tencent.mm.f.a.sc.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.cp;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
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
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.w.b;
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
import java.util.Map;
import junit.framework.Assert;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(23)
public class SelectConversationUI
  extends MMBaseSelectContactUI
{
  private static final int XXm;
  private TextView Wvh;
  private ArrayList<Long> XWl;
  private String XWm;
  private long XXA;
  private String XXB;
  private String XXC;
  private Boolean XXD;
  private boolean XXE;
  private boolean XXF;
  private List<String> XXG;
  private boolean XXH;
  private ReportUtil.ReportArgs XXI;
  private List<ca> XXJ;
  private String XXK;
  private String XXL;
  private String XXM;
  private com.tencent.mm.ui.contact.ad XXN;
  private String XXO;
  private String XXP;
  private int XXQ;
  private String XXR;
  private int XXS;
  private boolean XXT;
  protected boolean XXU;
  private MenuItem.OnMenuItemClickListener XXV;
  private MenuItem.OnMenuItemClickListener XXW;
  private int XXn;
  private boolean XXo;
  private boolean XXp;
  private boolean XXq;
  private boolean XXr;
  private boolean XXs;
  private boolean XXt;
  private boolean XXu;
  boolean XXv;
  private boolean XXw;
  private int XXx;
  private boolean XXy;
  private boolean XXz;
  private int Xim;
  private boolean Xts;
  private boolean XvE;
  private Map<String, Integer> aadl;
  private int aadm;
  private String emojiMD5;
  private String fDQ;
  private ca fNz;
  private String fQs;
  private int fromScene;
  private long fyE;
  private String imagePath;
  private List<String> jkb;
  private long msgId;
  private int msgType;
  private int selectType;
  private long startTime;
  private String toD;
  boolean wRc;
  private int[] wTL;
  
  static
  {
    AppMethodBeat.i(39409);
    XXm = w.P(new int[] { 1, 2 });
    AppMethodBeat.o(39409);
  }
  
  public SelectConversationUI()
  {
    AppMethodBeat.i(39354);
    this.XXo = false;
    this.XXp = false;
    this.XXq = false;
    this.XXr = false;
    this.XXs = false;
    this.XXt = false;
    this.XXu = false;
    this.wRc = false;
    this.XXv = false;
    this.fromScene = 0;
    this.XXw = false;
    this.XvE = false;
    this.XXy = false;
    this.XXz = false;
    this.Xim = -1;
    this.XXA = -1L;
    this.XXD = Boolean.FALSE;
    this.XXE = false;
    this.XXF = false;
    this.XXG = null;
    this.aadl = null;
    this.XWm = null;
    this.imagePath = null;
    this.XXM = null;
    this.toD = null;
    this.XXS = 0;
    this.XXT = false;
    this.XXU = false;
    this.wTL = new int[] { R.h.dyT, R.h.dyU, R.h.dyV, R.h.dyW, R.h.dyX };
    this.XXV = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(277233);
        paramAnonymousMenuItem = SelectConversationUI.this;
        boolean bool;
        if (!SelectConversationUI.a(SelectConversationUI.this))
        {
          bool = true;
          SelectConversationUI.b(paramAnonymousMenuItem, bool);
          SelectConversationUI.this.hUP().GL(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.this.Xtb.GL(SelectConversationUI.a(SelectConversationUI.this));
          SelectConversationUI.r(SelectConversationUI.this);
          paramAnonymousMenuItem = SelectConversationUI.t(SelectConversationUI.this);
          if (SelectConversationUI.a(SelectConversationUI.this)) {
            break label144;
          }
        }
        label144:
        for (int i = SelectConversationUI.s(SelectConversationUI.this);; i = R.l.eSa)
        {
          paramAnonymousMenuItem.setText(i);
          if ((SelectConversationUI.a(SelectConversationUI.this)) && (SelectConversationUI.k(SelectConversationUI.this))) {
            com.tencent.mm.modelstat.a.c(SelectConversationUI.l(SelectConversationUI.this), 7);
          }
          AppMethodBeat.o(277233);
          return true;
          bool = false;
          break;
        }
      }
    };
    this.XXW = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(285785);
        if (SelectConversationUI.u(SelectConversationUI.this))
        {
          AppMethodBeat.o(285785);
          return false;
        }
        paramAnonymousMenuItem = SelectConversationUI.v(SelectConversationUI.this).iterator();
        while (paramAnonymousMenuItem.hasNext())
        {
          localObject = (String)paramAnonymousMenuItem.next();
          if (SelectConversationUI.this.bAP((String)localObject))
          {
            AppMethodBeat.o(285785);
            return false;
          }
        }
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Conv_User", Util.listToString(SelectConversationUI.v(SelectConversationUI.this), ","));
        Object localObject = (Intent)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject != null) {
          SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem, (Intent)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(285785);
          return true;
          if (SelectConversationUI.w(SelectConversationUI.this))
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
  
  private boolean Hi(boolean paramBoolean)
  {
    AppMethodBeat.i(39394);
    if (paramBoolean)
    {
      if (this.XXG.size() < 9) {}
    }
    else {
      while (this.XXG.size() > 9)
      {
        String str = getString(R.l.eRU, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9)) });
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
    int m = aw.aZ(paramContext, R.f.DialogBigImageMinHeight);
    paramInt1 = aw.aZ(paramContext, R.f.DialogBigImageMaxHeight);
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
  
  private View a(com.tencent.mm.plugin.findersdk.a.b paramb)
  {
    AppMethodBeat.i(280041);
    Object localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOB = true;
    Object localObject2 = ((e.a)localObject1).aRT();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    View localView;
    Object localObject3;
    label196:
    int i;
    if (((Integer)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() == 0)
    {
      localObject1 = View.inflate(this, R.i.eld, null);
      localView = ((View)localObject1).findViewById(R.h.finder_feed_container);
      localObject3 = (ImageView)localView.findViewById(R.h.finder_avatar);
      com.tencent.mm.loader.e locale = com.tencent.mm.loader.e.kMy;
      com.tencent.mm.loader.e.aRs().a(Util.nullAsNil(paramb.Bvb.headUrl), (ImageView)localObject3, (com.tencent.mm.loader.c.e)localObject2);
      localObject2 = (TextView)localView.findViewById(R.h.finder_nickname);
      ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramb.Bvb.nickName));
      ar.a(((TextView)localObject2).getPaint(), 0.8F);
      localObject2 = (ImageView)localView.findViewById(R.h.finder_thumb);
      localObject3 = (TextView)localView.findViewById(R.h.finder_desc);
      if (!TextUtils.isEmpty(paramb.Bvb.desc)) {
        break label315;
      }
      ((TextView)localObject3).setVisibility(8);
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(Util.nullAs(paramb.Bvb.coverUrl, ""), (ImageView)localObject2);
      i = (int)getContext().getResources().getDimension(R.f.Edge_18A);
      paramb = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Integer)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() != 0) {
        break label336;
      }
      ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, (int)(1.333333F * i)));
    }
    for (;;)
    {
      localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      AppMethodBeat.o(280041);
      return localObject1;
      localObject1 = View.inflate(this, R.i.ele, null);
      break;
      label315:
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(paramb.Bvb.desc);
      break label196;
      label336:
      ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, i));
    }
  }
  
  private View a(com.tencent.mm.plugin.findersdk.a.d paramd)
  {
    AppMethodBeat.i(280030);
    View localView = View.inflate(this, R.i.ela, null);
    TextView localTextView = (TextView)localView.findViewById(R.h.title);
    FinderFeedAlbumView localFinderFeedAlbumView = (FinderFeedAlbumView)localView.findViewById(R.h.feedAlbumView);
    localFinderFeedAlbumView.setItemViewWidth(com.tencent.mm.ci.a.fromDPToPix(localView.getContext(), 70));
    Object localObject = paramd.mbg.STk;
    localObject = ((List)localObject).subList(0, Math.min(4, ((List)localObject).size()));
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      csg localcsg = new csg();
      localcsg.url = ((String)paramd.mbg.STk.get(i));
      localcsg.url_token = ((String)paramd.mbg.STl.get(i));
      localcsg.thumb_url_token = localcsg.url_token;
      localcsg.thumbUrl = localcsg.url;
      localLinkedList.add(localcsg);
      i += 1;
    }
    localFinderFeedAlbumView.setAdapter(new com.tencent.mm.plugin.finder.view.adapter.b(localLinkedList, false));
    localTextView.setText(paramd.mbg.title);
    AppMethodBeat.o(280030);
    return localView;
  }
  
  private View a(com.tencent.mm.plugin.findersdk.a.f paramf)
  {
    AppMethodBeat.i(163387);
    Object localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOB = true;
    Object localObject2 = ((e.a)localObject1).aRT();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    int i;
    View localView;
    Object localObject3;
    Object localObject4;
    TextView localTextView1;
    if (((Integer)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() == 0)
    {
      i = R.i.elb;
      localObject1 = View.inflate(this, i, null);
      localView = ((View)localObject1).findViewById(R.h.finder_feed_container);
      localObject3 = (ImageView)localView.findViewById(R.h.finder_avatar);
      localObject4 = com.tencent.mm.loader.e.kMy;
      com.tencent.mm.loader.e.aRs().a(Util.nullAsNil(paramf.mbi.avatar), (ImageView)localObject3, (com.tencent.mm.loader.c.e)localObject2);
      localObject2 = (TextView)localView.findViewById(R.h.finder_nickname);
      ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramf.mbi.nickname));
      ar.a(((TextView)localObject2).getPaint(), 0.8F);
      localObject2 = (ImageView)localView.findViewById(R.h.finder_thumb);
      localObject3 = (ImageView)localView.findViewById(R.h.finder_mediaType);
      localObject4 = (ImageIndicatorView)localView.findViewById(R.h.dyc);
      localTextView1 = (TextView)localView.findViewById(R.h.finder_desc);
      if (paramf.mbi.ACQ != 1) {
        break label420;
      }
      ((ImageView)localObject2).setVisibility(8);
      TextView localTextView2 = (TextView)localView.findViewById(R.h.finder_text);
      localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramf.mbi.desc));
      localTextView2.setVisibility(0);
      label257:
      localTextView1.setVisibility(8);
      label264:
      if ((paramf.mbi.ACQ != 4) && (paramf.mbi.ACQ != 6)) {
        break label504;
      }
      ((ImageView)localObject3).setVisibility(0);
      if (localObject4 != null) {
        ((ImageIndicatorView)localObject4).setVisibility(8);
      }
      label305:
      i = (int)getContext().getResources().getDimension(R.f.Edge_18A);
      paramf = (bjc)paramf.mbi.mediaList.getFirst();
      localObject3 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Integer)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() != 0) {
        break label570;
      }
      ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, (int)(androidx.core.b.a.c(paramf.height * 1.0F / paramf.width, 1.0F, 1.333333F) * i)));
    }
    for (;;)
    {
      localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      AppMethodBeat.o(163387);
      return localObject1;
      i = R.i.elc;
      break;
      label420:
      if (paramf.mbi.mediaList.size() > 0) {
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(((bjc)paramf.mbi.mediaList.get(0)).thumbUrl, (ImageView)localObject2);
      }
      if (Util.isNullOrNil(paramf.mbi.desc)) {
        break label257;
      }
      localTextView1.setVisibility(0);
      localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, paramf.mbi.desc));
      break label264;
      label504:
      if (paramf.mbi.ACQ == 2)
      {
        ((ImageView)localObject3).setVisibility(8);
        if (localObject4 == null) {
          break label305;
        }
        ((ImageIndicatorView)localObject4).setVisibility(0);
        ((ImageIndicatorView)localObject4).Lsg = paramf.mbi.fCa;
        break label305;
      }
      ((ImageView)localObject3).setVisibility(8);
      if (localObject4 == null) {
        break label305;
      }
      ((ImageIndicatorView)localObject4).setVisibility(8);
      break label305;
      label570:
      ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, i));
    }
  }
  
  private View a(com.tencent.mm.plugin.findersdk.a.i parami)
  {
    AppMethodBeat.i(280039);
    Object localObject1 = new e.a();
    ((e.a)localObject1).kOp = true;
    ((e.a)localObject1).kOo = true;
    ((e.a)localObject1).kOB = true;
    Object localObject2 = ((e.a)localObject1).aRT();
    localObject1 = com.tencent.mm.plugin.finder.storage.d.AjH;
    int i;
    View localView;
    ImageView localImageView;
    Object localObject3;
    if (((Integer)com.tencent.mm.plugin.finder.storage.d.dXV().aSr()).intValue() == 0)
    {
      i = R.i.elb;
      localObject1 = View.inflate(this, i, null);
      localView = ((View)localObject1).findViewById(R.h.finder_feed_container);
      localImageView = (ImageView)localView.findViewById(R.h.finder_avatar);
      localObject3 = com.tencent.mm.loader.e.kMy;
      com.tencent.mm.loader.e.aRs().a(Util.nullAsNil(parami.mbk.avatar), localImageView, (com.tencent.mm.loader.c.e)localObject2);
      localObject2 = (TextView)localView.findViewById(R.h.finder_nickname);
      ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, parami.mbk.nickname));
      ar.a(((TextView)localObject2).getPaint(), 0.8F);
      localObject2 = (ImageView)localView.findViewById(R.h.finder_thumb);
      localImageView = (ImageView)localView.findViewById(R.h.finder_mediaType);
      localObject3 = (TextView)localView.findViewById(R.h.finder_desc);
      if (parami.mbk.mediaList.size() > 0)
      {
        if (Util.isNullOrNil(((cww)parami.mbk.mediaList.get(0)).coverUrl)) {
          break label396;
        }
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(((cww)parami.mbk.mediaList.get(0)).coverUrl, (ImageView)localObject2);
      }
      label260:
      if (Util.isNullOrNil(parami.mbk.desc)) {
        break label432;
      }
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this, parami.mbk.desc));
    }
    for (;;)
    {
      localImageView.setVisibility(0);
      i = (int)getContext().getResources().getDimension(R.f.Edge_18A);
      parami = (cww)parami.mbk.mediaList.getFirst();
      ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, (int)(androidx.core.b.a.c(parami.height * 1.0F / parami.width, 1.0F, 1.333333F) * i)));
      localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      AppMethodBeat.o(280039);
      return localObject1;
      i = R.i.elc;
      break;
      label396:
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(((cww)parami.mbk.mediaList.get(0)).thumbUrl, (ImageView)localObject2);
      break label260;
      label432:
      ((TextView)localObject3).setVisibility(8);
    }
  }
  
  private View a(String paramString, com.tencent.mm.aj.k.b paramb, final com.tencent.mm.pluginsdk.ui.tools.b paramb1)
  {
    AppMethodBeat.i(280036);
    Object localObject = new e.a();
    ((e.a)localObject).kOp = true;
    ((e.a)localObject).kOo = true;
    ((e.a)localObject).kOB = true;
    ((e.a)localObject).aRT();
    localObject = View.inflate(this, R.i.elh, null);
    ((RoundCornerRelativeLayout)((View)localObject).findViewById(R.h.round_corner_rl)).setRadius(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4));
    final View localView1 = ((View)localObject).findViewById(R.h.blur_bg_view);
    View localView2 = ((View)localObject).findViewById(R.h.music_container);
    MMRoundCornerImageView localMMRoundCornerImageView;
    TextView localTextView1;
    TextView localTextView3;
    if (ar.isDarkMode())
    {
      localView2.setBackgroundResource(R.g.sns_music_mv_dark_gradient_bg);
      localMMRoundCornerImageView = (MMRoundCornerImageView)localView2.findViewById(R.h.chatting_music_cover);
      localTextView1 = (TextView)localView2.findViewById(R.h.chatting_music_singer_name);
      TextView localTextView2 = (TextView)localView2.findViewById(R.h.chatting_music_song_name);
      localTextView3 = (TextView)localView2.findViewById(R.h.chatting_music_mv_info);
      localMMRoundCornerImageView.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.g.music_mv_cover_empty_lightmode));
      if (ar.isDarkMode()) {
        localMMRoundCornerImageView.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.g.music_mv_cover_empty_darkmode));
      }
      localTextView2.setText(paramb.getTitle());
      if (Util.isNullOrNil(paramb.getDescription())) {
        break label459;
      }
      localTextView1.setText(paramb.getDescription());
      localTextView1.setVisibility(0);
      label231:
      String str = paramb1.Ruw;
      paramb1 = paramb1.Rux;
      if (Util.isNullOrNil(paramb1)) {
        break label477;
      }
      ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 6);
      ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 2);
      localView2.findViewById(R.h.padding_view).setVisibility(0);
      localTextView3.setText(paramb1 + getContext().getString(R.l.music_mv_info_share_suffix));
      localTextView3.setVisibility(0);
      label336:
      paramb1 = new boolean[1];
      paramb1[0] = 0;
      if (Util.isNullOrNil(str)) {
        break label495;
      }
      paramString = new c.a();
      paramString.fullPath = com.tencent.mm.plugin.music.h.b.aSv(str);
      paramString.lRD = true;
      paramString.kPz = true;
      paramString.lRB = true;
      paramString.lRW = com.tencent.mm.ci.a.fromDPToPix(getContext(), 2);
      paramString = paramString.bmL();
      com.tencent.mm.ay.q.bml().a(str, localMMRoundCornerImageView, paramString, new com.tencent.mm.ay.a.c.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.ay.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(287777);
          if ((paramAnonymousb.bitmap != null) && (!paramAnonymousb.bitmap.isRecycled()))
          {
            paramAnonymousString = com.tencent.xweb.util.d.getMessageDigest(paramAnonymousString.getBytes());
            paramAnonymousView = com.tencent.mm.plugin.comm.b.ubp;
            com.tencent.mm.plugin.comm.b.a(SelectConversationUI.this.getContext(), localView1, paramAnonymousb.bitmap, paramAnonymousString);
            AppMethodBeat.o(287777);
            return;
          }
          paramb1[0] = true;
          AppMethodBeat.o(287777);
        }
      });
    }
    for (;;)
    {
      localView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      AppMethodBeat.o(280036);
      return localObject;
      localView2.setBackgroundResource(R.g.sns_music_mv_light_gradient_bg);
      break;
      label459:
      localTextView1.setText("");
      localTextView1.setVisibility(8);
      break label231;
      label477:
      localTextView3.setText("");
      localTextView3.setVisibility(8);
      break label336;
      label495:
      if (!paramb.bbv())
      {
        bh.beI();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          paramb = null;
          if (!bzI(paramString)) {
            paramb = com.tencent.mm.ay.q.bmh().b(paramString, com.tencent.mm.ci.a.getDensity(MMApplicationContext.getContext()), false);
          }
          if ((paramb != null) && (!paramb.isRecycled()))
          {
            localMMRoundCornerImageView.setImageBitmap(paramb);
            paramString = com.tencent.xweb.util.d.getMessageDigest(paramString.getBytes());
            paramb1 = com.tencent.mm.plugin.comm.b.ubp;
            com.tencent.mm.plugin.comm.b.a(getContext(), localView1, paramb, paramString);
            continue;
          }
          paramb1[0] = 1;
          continue;
        }
      }
      localMMRoundCornerImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.g.dok));
    }
  }
  
  private void a(final Intent paramIntent, o.a parama, final HashMap<String, Object> paramHashMap, boolean paramBoolean, String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(180098);
    String str1 = cp.d(paramHashMap.get("app_id"), null);
    int i = cp.h(paramHashMap.get("pkg_type"), 0);
    int j = cp.h(paramHashMap.get("pkg_version"), 0);
    String str2 = cp.d(paramHashMap.get("cache_key"), null);
    String str3 = cp.d(paramHashMap.get("path"), null);
    String str4 = cp.d(paramHashMap.get("delay_load_img_path"), null);
    Object localObject2 = cp.d(paramHashMap.get("nickname"), "");
    boolean bool2 = cp.cg(paramHashMap.get("is_dynamic"));
    int k = cp.h(paramHashMap.get("subType"), 0);
    int m = cp.h(paramHashMap.get("biz"), k.a.llS.ordinal());
    Object localObject3;
    Object localObject1;
    if (k.a.uB(m))
    {
      localObject3 = cp.d(paramHashMap.get("tail_lang"), "");
      String str5 = cp.d(paramHashMap.get("icon_url"), "");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_biz", m);
      ((Bundle)localObject1).putString("key_footer_text_default", (String)localObject2);
      ((Bundle)localObject1).putString("key_footer_text", k.a.b(m, (String)localObject3, getContext()));
      ((Bundle)localObject1).putString("key_footer_icon", str5);
      Log.d("MicroMsg.SelectConversationUI", "defaultFooterTxt: %s, tailLang: %s.", new Object[] { localObject2, localObject3 });
      localObject2 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class);
      if (paramString3 != null) {
        break label749;
      }
    }
    label749:
    for (boolean bool1 = false;; bool1 = ab.PW(paramString3))
    {
      localObject1 = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool1, new k.c()
      {
        public final void bgU()
        {
          AppMethodBeat.i(275959);
          paramIntent.putExtra("KShowTodoIntroduceView", 1);
          g.a(SelectConversationUI.this, null);
          AppMethodBeat.o(275959);
        }
        
        public final void gd(boolean paramAnonymousBoolean) {}
      });
      localObject2 = n.cP(this);
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("app_id", str1);
      ((Bundle)localObject3).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      ((Bundle)localObject3).putInt("msg_pkg_type", i);
      ((Bundle)localObject3).putInt("pkg_version", j);
      ((Bundle)localObject3).putString("image_url", paramString1);
      ((Bundle)localObject3).putBoolean("is_dynamic_page", bool2);
      ((Bundle)localObject3).putString("title", paramString2);
      ((Bundle)localObject3).putString("cache_key", str2);
      ((Bundle)localObject3).putString("msg_path", str3);
      ((Bundle)localObject3).putString("delay_load_img_path", str4);
      ((Bundle)localObject3).putInt("sub_type", k);
      if (paramBoolean)
      {
        paramString1 = cp.d(paramHashMap.get("video_path"), "");
        paramHashMap = cp.d(paramHashMap.get("video_thumb_path"), "");
        ((Bundle)localObject3).putBoolean("is_video", true);
        ((Bundle)localObject3).putString("video_path", paramString1);
        ((Bundle)localObject3).putString("video_thumb_path", paramHashMap);
      }
      paramHashMap = new h(this);
      paramHashMap.XZd = new h.a()
      {
        public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(271386);
          paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
          if (paramAnonymousBoolean1) {
            if (!Util.isNullOrNil(paramString3))
            {
              SelectConversationUI.a(SelectConversationUI.this, paramString3);
              paramIntent.putExtra("custom_send_text", paramAnonymousString);
              SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
              SelectConversationUI.this.finish();
            }
          }
          for (;;)
          {
            ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).a(this.oiy, this.val$view);
            AppMethodBeat.o(271386);
            return;
            SelectConversationUI.n(SelectConversationUI.this);
            break;
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            if (SelectConversationUI.this.XXU) {
              SelectConversationUI.this.finish();
            }
          }
        }
      };
      ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).a((String)localObject2, (View)localObject1, (Bundle)localObject3, new com.tencent.mm.modelappbrand.k.b()
      {
        public final void vA(int paramAnonymousInt)
        {
          AppMethodBeat.i(291236);
          Log.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramHashMap.hZj();
          AppMethodBeat.o(291236);
        }
      });
      parama.hv((View)localObject1);
      parama.w(Boolean.TRUE);
      parama.hkx();
      parama.rrn = new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(180089);
          ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).a(this.oiy, this.val$view);
          AppMethodBeat.o(180089);
        }
      };
      parama.RfV = hYU();
      {
        public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(279975);
          Object localObject;
          h localh;
          if (paramAnonymousBoolean)
          {
            if (!Util.isNullOrNil(paramString3)) {
              SelectConversationUI.a(SelectConversationUI.this, paramString3);
            }
          }
          else
          {
            SelectConversationUI.this.hideVKB();
            localObject = this.val$view.getTag(R.h.app_brand_todo_tag_share);
            localh = paramHashMap;
            if (localObject != null) {
              break label89;
            }
          }
          label89:
          for (boolean bool = false;; bool = ((Boolean)localObject).booleanValue())
          {
            localh.a(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt, bool);
            AppMethodBeat.o(279975);
            return;
            SelectConversationUI.n(SelectConversationUI.this);
            break;
          }
        }
      }.show();
      AppMethodBeat.o(180098);
      return;
      if (paramBoolean)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("is_video", true);
        localObject2 = cp.d(paramHashMap.get("footer_icon"), "");
        localObject3 = cp.d(paramHashMap.get("footer_text"), "");
        ((Bundle)localObject1).putString("key_footer_icon", (String)localObject2);
        ((Bundle)localObject1).putString("key_footer_text", (String)localObject3);
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
        public final void dml()
        {
          AppMethodBeat.i(39339);
          Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", SelectConversationUI.j(SelectConversationUI.this));
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$23", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.la(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39339);
        }
      });
      AppMethodBeat.o(39378);
      return;
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(180090);
          Log.i("MicroMsg.SelectConversationUI", "[ImageGalleryUI] showImgGallery");
          Object localObject = new Intent(SelectConversationUI.this.getContext(), ImageGalleryUI.class);
          ((Intent)localObject).putExtra("img_gallery_msg_id", SelectConversationUI.p(SelectConversationUI.this));
          ((Intent)localObject).putExtra("img_gallery_msg_svr_id", SelectConversationUI.l(SelectConversationUI.this).field_msgSvrId);
          ((Intent)localObject).putExtra("img_gallery_talker", SelectConversationUI.l(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_gallery_chatroom_name", SelectConversationUI.l(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_preview_only", true);
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/transmit/SelectConversationUI$24", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$24", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.la(SelectConversationUI.this.getContext());
          AppMethodBeat.o(180090);
        }
      });
      AppMethodBeat.o(39378);
      return;
      bh.beI();
      if (com.tencent.mm.model.c.bbO() == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      bh.beI();
      Object localObject = com.tencent.mm.model.c.bbO().aOV(this.fQs);
      parama.a(new d.a.b()
      {
        public final void dml()
        {
          AppMethodBeat.i(39340);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          localIntent.putExtra("kwebmap_slat", this.XYl.Ejn);
          localIntent.putExtra("kwebmap_lng", this.XYl.Ejo);
          localIntent.putExtra("Kwebmap_locaion", this.XYm);
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.by.c.b(SelectConversationUI.this.getContext(), "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(39340);
        }
      });
      AppMethodBeat.o(39378);
      return;
      localObject = com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs));
      if (localObject == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      if (((((com.tencent.mm.aj.k.b)localObject).type == 5) && (!com.tencent.mm.ui.chatting.m.i(this.fNz, this.Xim))) || (((com.tencent.mm.aj.k.b)localObject).type == 69))
      {
        parama.a(new d.a.b()
        {
          public final void dml()
          {
            AppMethodBeat.i(39341);
            if (Util.isNullOrNil(this.val$url))
            {
              AppMethodBeat.o(39341);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", this.val$url);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.by.c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(39341);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.aj.k.b)localObject).type == 6)
      {
        parama.a(new d.a.b()
        {
          public final void dml()
          {
            AppMethodBeat.i(39342);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.p(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/transmit/SelectConversationUI$27", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$27", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(39342);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.aj.k.b)localObject).type == 24)
      {
        parama.a(new d.a.b()
        {
          public final void dml()
          {
            AppMethodBeat.i(39343);
            px localpx = new px();
            localpx.fOD.context = SelectConversationUI.this.getContext();
            localpx.fOD.msgId = SelectConversationUI.p(SelectConversationUI.this);
            localpx.fOD.fOE = this.pqD.lmA;
            localpx.fOD.fNQ = false;
            localpx.fOD.scene = 7;
            EventCenter.instance.publish(localpx);
            AppMethodBeat.o(39343);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.aj.k.b)localObject).type == 19)
      {
        parama.a(new d.a.b()
        {
          public final void dml()
          {
            AppMethodBeat.i(180091);
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.p(SelectConversationUI.this));
            localIntent.putExtra("record_xml", this.pqD.lmA);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.by.c.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(180091);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if ((((com.tencent.mm.aj.k.b)localObject).type == 3) || (((com.tencent.mm.aj.k.b)localObject).type == 76))
      {
        parama.a(new d.a.b()
        {
          public final void dml()
          {
            AppMethodBeat.i(180092);
            Object localObject2 = com.tencent.mm.pluginsdk.model.app.q.V(this.pqD.url, "message");
            String str = com.tencent.mm.pluginsdk.model.app.q.V(this.pqD.llW, "message");
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
              com.tencent.mm.by.c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
              AppMethodBeat.o(180092);
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
      if (((com.tencent.mm.aj.k.b)localObject).type == 4)
      {
        parama.a(new d.a.b()
        {
          public final void dml()
          {
            AppMethodBeat.i(180093);
            AppMethodBeat.o(180093);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if ((((com.tencent.mm.aj.k.b)localObject).type == 53) || (((com.tencent.mm.aj.k.b)localObject).type == 57))
      {
        parama.a(new d.a.b()
        {
          public final void dml()
          {
            AppMethodBeat.i(202383);
            Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
            ((Intent)localObject).putExtra("Retr_Msg_content", this.pqD.title);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/transmit/SelectConversationUI$32", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$32", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.la(SelectConversationUI.this.getContext());
            AppMethodBeat.o(202383);
          }
        });
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void dml()
          {
            AppMethodBeat.i(265286);
            Object localObject = com.tencent.mm.ui.chatting.l.lg(SelectConversationUI.this.getContext());
            localObject = com.tencent.mm.aj.k.b.OQ(Util.processXml(com.tencent.mm.plugin.record.b.p.a(((sc)localObject).fRx.fRD.title, ((sc)localObject).fRx.fRD.desc, ((sc)localObject).fRx.fQJ.fyI.fyK, ((sc)localObject).fRw.from, SelectConversationUI.p(SelectConversationUI.this))));
            if (localObject == null)
            {
              AppMethodBeat.o(265286);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.p(SelectConversationUI.this));
            localIntent.putExtra("record_xml", ((com.tencent.mm.aj.k.b)localObject).lmA);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.by.c.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(265286);
          }
        });
        AppMethodBeat.o(39378);
        return;
        com.tencent.mm.ui.chatting.l.lg(getContext());
        AppMethodBeat.o(39378);
        return;
        parama.a(new d.a.b()
        {
          public final void dml()
          {
            AppMethodBeat.i(276857);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.p(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/transmit/SelectConversationUI$34", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$34", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(276857);
          }
        });
      }
    }
  }
  
  private void a(o.a parama, String paramString)
  {
    AppMethodBeat.i(39371);
    bh.beI();
    com.tencent.mm.model.c.bbL().bwg(paramString);
    String str = aa.PJ(paramString);
    if (!Util.isNullOrNil(this.XXC)) {
      str = this.XXC;
    }
    parama.brm(bAS(paramString) + str);
    AppMethodBeat.o(39371);
  }
  
  private boolean a(final Intent paramIntent, final o.a parama, final String paramString)
  {
    AppMethodBeat.i(180097);
    Object localObject2 = (HashMap)getIntent().getSerializableExtra("appbrand_params");
    boolean bool1 = cp.cg(((HashMap)localObject2).get("is_weishi_video"));
    final boolean bool2 = cp.cg(((HashMap)localObject2).get("is_video"));
    if (bool1)
    {
      bool1 = a(parama, (HashMap)localObject2);
      AppMethodBeat.o(180097);
      return bool1;
    }
    int i = cp.h(((HashMap)localObject2).get("type"), 1);
    final String str2 = cp.d(((HashMap)localObject2).get("title"), "");
    final String str1 = cp.d(((HashMap)localObject2).get("img_url"), null);
    int j = cp.h(((HashMap)localObject2).get("biz"), k.a.llS.ordinal());
    if ((!k.a.uB(j)) && ((i == 2) || (i == 3)))
    {
      if ((paramString != null) && (y.asb()) && (ab.PW(paramString)) && (MultiProcessMMKV.getMMKV("group_to_do").getBoolean("introduce_dialog_first", true)))
      {
        MultiProcessMMKV.getMMKV("group_to_do").edit().putBoolean("introduce_dialog_first", false);
        g.a(this, new g.a()
        {
          public final void hTM()
          {
            AppMethodBeat.i(270548);
            paramIntent.putExtra("KShowTodoIntroduceView", 1);
            SelectConversationUI.a(SelectConversationUI.this, paramIntent, parama, this.XYh, bool2, str1, str2, paramString);
            AppMethodBeat.o(270548);
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(180097);
        return true;
        a(paramIntent, parama, (HashMap)localObject2, bool2, str1, str2, paramString);
      }
    }
    if (k.a.uB(j))
    {
      Object localObject1 = getResources().getString(R.l.app_brand_default_name_with_brackets);
      localObject2 = cp.d(((HashMap)localObject2).get("nickname"), null);
      if (Util.isNullOrNil((String)localObject2)) {}
      for (;;)
      {
        parama.brm((String)localObject1 + str2);
        localObject1 = new h(this);
        ((h)localObject1).XZd = new h.a()
        {
          public final void e(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(180082);
            paramIntent.putExtra("KSendGroupToDo", paramAnonymousBoolean2);
            if (paramAnonymousBoolean1)
            {
              if (!Util.isNullOrNil(paramString)) {
                SelectConversationUI.a(SelectConversationUI.this, paramString);
              }
              for (;;)
              {
                paramIntent.putExtra("custom_send_text", paramAnonymousString);
                SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
                SelectConversationUI.this.finish();
                AppMethodBeat.o(180082);
                return;
                SelectConversationUI.n(SelectConversationUI.this);
              }
            }
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            if (SelectConversationUI.this.XXU) {
              SelectConversationUI.this.finish();
            }
            AppMethodBeat.o(180082);
          }
        };
        com.tencent.mm.modelappbrand.a.b.bhh().a(new b.k()
        {
          public final void G(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(291078);
            this.XYj.hZj();
            AppMethodBeat.o(291078);
          }
          
          public final void bhq() {}
          
          public final void bhr()
          {
            AppMethodBeat.i(291080);
            this.XYj.hZj();
            AppMethodBeat.o(291080);
          }
          
          public final String key()
          {
            AppMethodBeat.i(291081);
            String str = n.cP(this);
            AppMethodBeat.o(291081);
            return str;
          }
        }, str1, com.tencent.mm.modelappbrand.a.g.lzF);
        parama.w(Boolean.TRUE);
        parama.RfV = hYU();
        {
          public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(207508);
            if (paramAnonymousBoolean)
            {
              if (Util.isNullOrNil(paramString)) {
                break label54;
              }
              SelectConversationUI.a(SelectConversationUI.this, paramString);
            }
            for (;;)
            {
              SelectConversationUI.this.hideVKB();
              this.XYj.a(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt, false);
              AppMethodBeat.o(207508);
              return;
              label54:
              SelectConversationUI.n(SelectConversationUI.this);
            }
          }
        }.show();
        AppMethodBeat.o(180097);
        return true;
        localObject1 = Util.safeFormatString(getResources().getString(R.l.app_fake_native_app), new Object[] { localObject2 });
      }
    }
    parama.brm(getResources().getString(R.l.app_brand_default_name_with_brackets) + str2);
    parama.brn(str1).hkw();
    parama.w(Boolean.TRUE);
    AppMethodBeat.o(180097);
    return false;
  }
  
  private boolean a(o.a parama, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(39377);
    final String str = cp.d(paramHashMap.get("img_url"), null);
    if (!Util.isNullOrNil(str))
    {
      paramHashMap = new RelativeLayout(this);
      View localView = LayoutInflater.from(this).inflate(R.i.confirm_dialog_image_center, null);
      paramHashMap.addView(localView, new RelativeLayout.LayoutParams(-2, -2));
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(14);
      final ImageView localImageView = (ImageView)localView.findViewById(R.h.mm_alert_msg_icon);
      ((ImageView)localView.findViewById(R.h.image_status_icon)).setImageResource(R.k.video_icon_in_gird);
      parama.hv(paramHashMap);
      parama.hkx();
      com.tencent.mm.modelappbrand.a.b.bhh().a(new b.k()
      {
        public final void G(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(289718);
          if ((!SelectConversationUI.this.isFinishing()) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()) && (localImageView != null))
          {
            paramAnonymousBitmap = at.a(SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBitmap, localImageView, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight()), aw.fromDPToPix(SelectConversationUI.this, 3));
            localImageView.setImageBitmap(paramAnonymousBitmap);
          }
          AppMethodBeat.o(289718);
        }
        
        public final void bhq() {}
        
        public final void bhr()
        {
          AppMethodBeat.i(289719);
          Log.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", new Object[] { str });
          AppMethodBeat.o(289719);
        }
        
        public final String key()
        {
          return "SelectConversationUI#WEISHITHUMB";
        }
      }, str, null, null);
    }
    for (;;)
    {
      parama.w(Boolean.TRUE);
      AppMethodBeat.o(39377);
      return false;
      paramHashMap = cp.d(paramHashMap.get("msg_img_path"), null);
      if (!Util.isNullOrNil(paramHashMap))
      {
        Log.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", new Object[] { str, paramHashMap });
        parama.m(bAU(paramHashMap), 2);
      }
    }
  }
  
  private void atk()
  {
    AppMethodBeat.i(39393);
    if (!this.XXE)
    {
      AppMethodBeat.o(39393);
      return;
    }
    if ((this.XXG != null) && (this.XXG.size() > 0))
    {
      updateOptionMenuText(1, hYU() + "(" + this.XXG.size() + ")");
      updateOptionMenuListener(1, this.XXW, null);
      enableOptionMenu(1, true);
      AppMethodBeat.o(39393);
      return;
    }
    if (!this.XXF)
    {
      updateOptionMenuText(1, getString(R.l.app_multi_selected));
      updateOptionMenuListener(1, this.XXV, null);
      enableOptionMenu(1, true);
      if (this.ETP != null) {
        this.ETP.setVisibility(8);
      }
      hUS();
      AppMethodBeat.o(39393);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_single_selected));
    updateOptionMenuListener(1, this.XXV, null);
    enableOptionMenu(1, true);
    if (this.ETP != null) {
      this.ETP.setVisibility(0);
    }
    hUT();
    AppMethodBeat.o(39393);
  }
  
  private String axz(int paramInt)
  {
    AppMethodBeat.i(280021);
    Object localObject;
    if (paramInt == 1) {
      localObject = this.XXK;
    }
    while (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(280021);
      return localObject;
      if (paramInt == 2)
      {
        localObject = this.XXL;
      }
      else
      {
        Log.e("MicroMsg.SelectConversationUI", "getMsgType: Parameter flag error ");
        AppMethodBeat.o(280021);
        return "0";
      }
    }
    if (!Util.isNullOrNil(this.XXJ))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.XXJ.iterator();
      if (localIterator.hasNext())
      {
        localObject = (ca)localIterator.next();
        if (localObject != null) {
          if (paramInt == 1) {
            localObject = String.valueOf(((ca)localObject).getType());
          }
        }
        for (;;)
        {
          localStringBuilder.append((String)localObject).append("｜");
          break;
          localObject = com.tencent.mm.aj.k.b.OQ(((et)localObject).field_content);
          if (localObject != null)
          {
            localObject = String.valueOf(((com.tencent.mm.aj.k.b)localObject).type);
          }
          else
          {
            localObject = "0";
            continue;
            localObject = "0";
          }
        }
      }
      localObject = localStringBuilder.substring(0, localStringBuilder.length() - 1);
      if (Util.isNullOrNil((String)localObject)) {
        break label298;
      }
      if (paramInt != 1) {
        break label290;
      }
      this.XXK = ((String)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(280021);
      return localObject;
      if (this.fNz != null) {
        if (paramInt == 1) {
          localObject = String.valueOf(this.fNz.getType());
        }
      }
      for (;;)
      {
        localObject = String.valueOf(localObject);
        break;
        localObject = com.tencent.mm.aj.k.b.OQ(this.fNz.field_content);
        if (localObject != null)
        {
          localObject = String.valueOf(((com.tencent.mm.aj.k.b)localObject).type);
        }
        else
        {
          localObject = "0";
          continue;
          localObject = "0";
        }
      }
      label290:
      this.XXL = ((String)localObject);
    }
    label298:
    AppMethodBeat.o(280021);
    return "0";
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
    com.tencent.mm.aj.k.b localb;
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
    case 29: 
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
                parama.brm(this.fQs);
                parama.hkv();
                AppMethodBeat.o(180099);
                return;
                localObject1 = hYY();
                paramString = (String)localObject1;
                if (localObject1 == null)
                {
                  paramString = (String)localObject1;
                  if (this.imagePath != null)
                  {
                    float f = com.tencent.mm.ci.a.getDensity(MMApplicationContext.getContext());
                    paramString = BitmapUtil.getBitmapNative(this.imagePath, 140, 140, f);
                    int j = Exif.fromFile(this.imagePath).getOrientationInDegree();
                    i = j;
                    if (j < 0) {
                      i = 0;
                    }
                    paramString = BitmapUtil.rotate(paramString, i);
                  }
                }
                parama.m(paramString, 3);
                AppMethodBeat.o(180099);
                return;
                parama.m(hYX(), 2);
                AppMethodBeat.o(180099);
                return;
                parama.m(hYX(), 2);
                AppMethodBeat.o(180099);
                return;
                parama.brm(hYW());
                AppMethodBeat.o(180099);
                return;
                if (!Util.isNullOrNil(this.emojiMD5))
                {
                  parama.bro(this.emojiMD5);
                  AppMethodBeat.o(180099);
                  return;
                }
                if (!Util.isNullOrNil(this.fNz.field_imgPath))
                {
                  parama.bro(this.fNz.field_imgPath);
                  AppMethodBeat.o(180099);
                  return;
                }
                parama.bro(this.imagePath);
                AppMethodBeat.o(180099);
                return;
                bh.beI();
                paramString = com.tencent.mm.model.c.bbO().aOU(this.fQs);
                this.XXB = paramString.fcC;
                this.XXC = paramString.nickname;
                this.XXD = Boolean.valueOf(ab.uL(paramString.PKJ));
                a(parama, this.XXB);
                AppMethodBeat.o(180099);
                return;
                paramString = (com.tencent.mm.plugin.finder.api.e)com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs)).ar(com.tencent.mm.plugin.finder.api.e.class);
              } while (paramString == null);
              parama.brm(getString(R.l.app_finder_endorsement) + paramString.title);
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.b)com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs)).ar(com.tencent.mm.plugin.findersdk.a.b.class);
              if (paramString != null) {
                parama.hv(a(paramString));
              }
              parama.hkx();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.f)com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs)).ar(com.tencent.mm.plugin.findersdk.a.f.class);
              if (paramString != null) {
                parama.hv(a(paramString));
              }
              parama.hkx();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.d)com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs)).ar(com.tencent.mm.plugin.findersdk.a.d.class);
              if (paramString != null) {
                parama.hv(a(paramString));
              }
              parama.hkx();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.i)com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs)).ar(com.tencent.mm.plugin.findersdk.a.i.class);
              if (paramString != null) {
                parama.hv(a(paramString));
              }
              parama.hkx();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.e)com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs)).ar(com.tencent.mm.plugin.findersdk.a.e.class);
            } while (paramString == null);
            parama.brm(getString(R.l.app_finder_namecard) + paramString.nickname);
            AppMethodBeat.o(180099);
            return;
            paramString = (com.tencent.mm.plugin.findersdk.a.h)com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs)).ar(com.tencent.mm.plugin.findersdk.a.h.class);
          } while ((paramString == null) || (paramString.mbf == null));
          localObject1 = getString(R.l.app_finder);
          if (paramString.mbf.wXA == 1) {
            paramString = (String)localObject1 + getString(R.l.finder_topic_card_prefix, new Object[] { paramString.mbf.topic });
          }
          for (;;)
          {
            parama.brm(paramString);
            AppMethodBeat.o(180099);
            return;
            if (paramString.mbf.wXA == 4) {
              paramString = (String)localObject1 + paramString.mbf.desc;
            } else {
              paramString = (String)localObject1 + paramString.mbf.topic;
            }
          }
          paramString = (com.tencent.mm.plugin.findersdk.a.c)com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs)).ar(com.tencent.mm.plugin.findersdk.a.c.class);
        } while ((paramString == null) || (paramString.mbf.STw == null));
        localObject1 = getString(R.l.app_finder);
        if (paramString.mbf.wXA == 7) {}
        for (paramString = (String)localObject1 + MMApplicationContext.getContext().getString(R.l.finder_activity_share_conversation_wording, new Object[] { paramString.mbf.STw.SCS, paramString.mbf.STw.SCR });; paramString = (String)localObject1 + paramString.mbf.topic)
        {
          parama.brm(paramString);
          AppMethodBeat.o(180099);
          return;
        }
        paramString = (com.tencent.mm.plugin.findersdk.a.g)com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs)).ar(com.tencent.mm.plugin.findersdk.a.g.class);
      } while ((paramString == null) || (paramString.mbj == null));
      parama.brm(paramString.mbj.poiName);
      AppMethodBeat.o(180099);
      return;
    case 2: 
    case 10: 
      localb = com.tencent.mm.aj.k.b.OQ(Util.processXml(this.fQs));
      if ((this.fNz.hwA()) && (localb == null)) {
        localb = com.tencent.mm.aj.k.b.aG(Util.processXml(this.fQs), Util.processXml(this.fQs));
      }
      break;
    }
    for (;;)
    {
      if (localb == null)
      {
        if (this.XXM != null)
        {
          paramString = getResources().getString(R.l.app_video);
          localObject1 = this.XXM;
          parama.brm(paramString + (String)localObject1);
        }
        AppMethodBeat.o(180099);
        return;
      }
      localObject1 = localb.title;
      Object localObject2;
      if (com.tencent.mm.ui.chatting.m.i(this.fNz, this.Xim))
      {
        localObject2 = getResources().getString(R.l.app_brand_default_name_with_brackets);
        paramString = (String)localObject1;
        localObject1 = localObject2;
        label1282:
        if (localb.type == 48) {
          localObject1 = getResources().getString(R.l.app_game_recording);
        }
        if (localb.type != 46) {
          break label2398;
        }
        parama.m(hYY(), 2);
      }
      while ((this.XXF) && (10 == this.msgType) && (this.XXH))
      {
        com.tencent.mm.modelstat.a.c(this.fNz, 8);
        AppMethodBeat.o(180099);
        return;
        if (localb.type == 5)
        {
          localObject2 = getResources().getString(R.l.app_url);
          paramString = (String)localObject1;
          localObject1 = localObject2;
          break label1282;
        }
        if (localb.type == 6)
        {
          localObject2 = getResources().getString(R.l.app_file);
          paramString = (String)localObject1;
          localObject1 = localObject2;
          break label1282;
        }
        if (localb.type == 24)
        {
          localObject1 = getResources().getString(R.l.app_note);
          paramString = t(localb);
          break label1282;
        }
        if (localb.type == 19)
        {
          localObject2 = getResources().getString(R.l.app_record);
          paramString = (String)localObject1;
          localObject1 = localObject2;
          break label1282;
        }
        if ((localb.type == 3) || (localb.type == 76))
        {
          localObject2 = (com.tencent.mm.pluginsdk.ui.tools.b)localb.ar(com.tencent.mm.pluginsdk.ui.tools.b.class);
          if (localObject2 != null)
          {
            localObject1 = com.tencent.mm.ay.q.bmh().d(this.fNz.field_imgPath, false, true);
            if (!Util.isNullOrNil((String)localObject1))
            {
              paramString = (String)localObject1;
              if (com.tencent.mm.vfs.u.agG((String)localObject1)) {}
            }
            else
            {
              paramString = this.XWm;
            }
            parama.hv(a(paramString, localb, (com.tencent.mm.pluginsdk.ui.tools.b)localObject2));
            parama.hkx();
            AppMethodBeat.o(180099);
            return;
          }
          localObject2 = getResources().getString(R.l.app_music);
          paramString = (String)localObject1;
          localObject1 = localObject2;
          break label1282;
        }
        if (localb.type == 4)
        {
          localObject2 = getResources().getString(R.l.app_video);
          paramString = (String)localObject1;
          localObject1 = localObject2;
          break label1282;
        }
        if (localb.type == 8)
        {
          localObject2 = getResources().getString(R.l.app_emoji_share);
          paramString = (String)localObject1;
          localObject1 = localObject2;
          break label1282;
        }
        if (localb.type == 44)
        {
          if (Util.isNullOrNil(localb.fUe))
          {
            localObject2 = getResources().getString(R.l.app_shortvideo);
            paramString = (String)localObject1;
            localObject1 = localObject2;
            break label1282;
          }
          localObject2 = Util.safeFormatString(getResources().getString(R.l.app_fake_native_app), new Object[] { localb.fUe });
          paramString = (String)localObject1;
          localObject1 = localObject2;
          break label1282;
        }
        if ((localb.type == 33) || (localb.type == 36) || (localb.type == 48))
        {
          if ((localb.loC == 2) || (localb.loC == 3) || (localb.type == 36) || (localb.type == 48))
          {
            i = localb.loH;
            if (localb.fX(false))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("key_biz", i);
              ((Bundle)localObject1).putString("key_footer_text_default", localb.fUe);
              ((Bundle)localObject1).putString("key_footer_text", localb.z(getContext(), false));
              ((Bundle)localObject1).putString("key_footer_icon", localb.loV);
              localObject2 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class);
              if (paramString != null) {
                break label2310;
              }
            }
            label2310:
            for (boolean bool = false;; bool = ab.PW(paramString))
            {
              paramString = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool, new k.c()
              {
                public final void bgU()
                {
                  AppMethodBeat.i(289546);
                  SelectConversationUI.o(SelectConversationUI.this);
                  g.a(SelectConversationUI.this, null);
                  AppMethodBeat.o(289546);
                }
                
                public final void gd(boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(289547);
                  SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBoolean);
                  AppMethodBeat.o(289547);
                }
              });
              parama.hv(paramString);
              parama.w(Boolean.TRUE);
              parama.hkx();
              Object localObject3 = com.tencent.mm.ay.q.bmh().d(this.fNz.field_imgPath, false, true);
              localObject1 = n.cP(this);
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("app_id", localb.loB);
              ((Bundle)localObject2).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(localb.loT), Integer.valueOf(localb.loE) }));
              ((Bundle)localObject2).putInt("msg_pkg_type", localb.loT);
              ((Bundle)localObject2).putInt("pkg_version", localb.loE);
              if (!Util.isNullOrNil((String)localObject3)) {
                ((Bundle)localObject2).putString("image_url", "file://".concat(String.valueOf(localObject3)));
              }
              localObject3 = (com.tencent.mm.aj.a)localb.ar(com.tencent.mm.aj.a.class);
              if (localObject3 != null)
              {
                ((Bundle)localObject2).putBoolean("is_dynamic_page", ((com.tencent.mm.aj.a)localObject3).ljZ);
                ((Bundle)localObject2).putString("cache_key", ((com.tencent.mm.aj.a)localObject3).lka);
                ((Bundle)localObject2).putInt("sub_type", ((com.tencent.mm.aj.a)localObject3).lko);
              }
              ((Bundle)localObject2).putString("title", localb.title);
              ((Bundle)localObject2).putString("msg_path", localb.loz);
              ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).a((String)localObject1, paramString, (Bundle)localObject2);
              parama.rrn = new DialogInterface.OnDismissListener()
              {
                public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(231906);
                  ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ae(com.tencent.mm.modelappbrand.k.class)).a(this.oiy, paramString);
                  AppMethodBeat.o(231906);
                }
              };
              AppMethodBeat.o(180099);
              return;
              if (localb.type == 48)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putBoolean("is_video", true);
                ((Bundle)localObject1).putString("key_footer_icon", localb.loV);
                ((Bundle)localObject1).putString("key_footer_text", localb.fUe);
                break;
              }
              Log.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(i) });
              localObject1 = null;
              break;
            }
          }
          localObject2 = getResources().getString(R.l.app_brand_default_name_with_brackets);
          paramString = (String)localObject1;
          localObject1 = localObject2;
          break label1282;
        }
        if ((localb.type == 53) || (localb.type == 57))
        {
          localObject2 = "";
          paramString = (String)localObject1;
          localObject1 = localObject2;
          break label1282;
        }
        localObject2 = getResources().getString(R.l.app_app);
        paramString = (String)localObject1;
        localObject1 = localObject2;
        break label1282;
        label2398:
        if (localb.type == 69)
        {
          paramString = (com.tencent.mm.plugin.game.luggage.f.a)localb.ar(com.tencent.mm.plugin.game.luggage.f.a.class);
          if (paramString != null)
          {
            parama.brm(getResources().getString(R.l.app_game_namecard) + paramString.nickName);
            if (!Util.isNullOrNil(paramString.iconUrl)) {
              parama.brn(paramString.iconUrl).hkw();
            }
          }
        }
        else
        {
          localObject2 = paramString;
          if (paramString == null) {
            localObject2 = "";
          }
          parama.brm((String)localObject1 + (String)localObject2);
          if (localb.thumburl != null) {
            parama.brn(localb.thumburl).hkw();
          }
        }
      }
      paramString = Util.nullAs(com.tencent.mm.ui.chatting.l.lg(getContext()).fRx.fRD.title, "");
      parama.brm(getResources().getString(R.l.app_multi_record) + paramString);
      if ((!this.XXF) || (!this.XXH)) {
        break;
      }
      com.tencent.mm.modelstat.a.c(this.fNz, 8);
      AppMethodBeat.o(180099);
      return;
      paramString = com.tencent.mm.ui.chatting.l.lg(getContext());
      if (paramString.fRw.fRB != null) {}
      for (i = paramString.fRw.fRB.size();; i = 0)
      {
        paramString = getContext().getString(R.l.retransmit_msg_count, new Object[] { Integer.valueOf(i) });
        parama.brm(getResources().getString(R.l.app_multi_msg) + paramString);
        AppMethodBeat.o(180099);
        return;
        if (this.toD == null) {
          break;
        }
        parama.brm(getResources().getString(R.l.app_file) + this.toD);
        break;
      }
    }
  }
  
  private static boolean bAO(String paramString)
  {
    AppMethodBeat.i(39364);
    if (as.bvK(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    if (ab.PQ(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    AppMethodBeat.o(39364);
    return false;
  }
  
  private void bAQ(String paramString)
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
          paramString.append(aa.PJ(str));
          i = 1;
        }
      }
      com.tencent.mm.ui.base.h.d(this, getString(R.l.eTn, new Object[] { paramString }), "", null);
      AppMethodBeat.o(39366);
      return;
    }
    catch (Throwable paramString)
    {
      AppMethodBeat.o(39366);
    }
  }
  
  private void bAR(String paramString)
  {
    AppMethodBeat.i(39367);
    Log.i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", new Object[] { paramString, this.XXP, Integer.valueOf(this.XXQ) });
    Log.i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", new Object[] { this.XXR });
    ((com.tencent.mm.choosemsgfile.compat.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.choosemsgfile.compat.a.class)).a(this, paramString, this.XXP, this.XXQ, this.XXR, new com.tencent.mm.choosemsgfile.compat.a.a()
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
  
  private String bAS(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(39372);
    bh.beI();
    as localas = com.tencent.mm.model.c.bbL().bwg(paramString);
    Object localObject = getResources().getString(R.l.app_friend_card_personal);
    if (localas == null)
    {
      AppMethodBeat.o(39372);
      return localObject;
    }
    bh.beI();
    localObject = com.tencent.mm.model.c.bbO().aOU(this.fQs);
    int i = j;
    if (localObject != null) {
      if (!ab.uL(((ca.a)localObject).PKJ))
      {
        i = j;
        if (!localas.hxX()) {}
      }
      else
      {
        i = 1;
      }
    }
    if (i != 0) {
      paramString = getResources().getString(R.l.app_friend_card_biz);
    }
    for (;;)
    {
      AppMethodBeat.o(39372);
      return paramString;
      if (as.bvK(paramString)) {
        paramString = c(this, localas);
      } else {
        paramString = getResources().getString(R.l.app_friend_card_personal);
      }
    }
  }
  
  private static Bitmap bAU(String paramString)
  {
    AppMethodBeat.i(39383);
    localBitmap2 = com.tencent.mm.ay.q.bmh().VZ(paramString);
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
  
  private static int bIU(String paramString)
  {
    AppMethodBeat.i(293327);
    int i;
    if (z.PD(paramString)) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(293327);
      return i;
      if (ab.QO(paramString)) {
        i = 2;
      } else if (ab.Lj(paramString)) {
        i = 4;
      } else {
        i = 3;
      }
    }
  }
  
  private void bIV(String paramString)
  {
    AppMethodBeat.i(293330);
    Log.i("MicroMsg.SelectConversationUI", "resetData: recent forward control switch on");
    if (!Util.isNullOrNil(paramString))
    {
      if (com.tencent.mm.ui.contact.h.iWB() == 1) {
        com.tencent.mm.ui.contact.h.bzX(paramString);
      }
      iM(paramString, this.aadm);
      hYV();
      AppMethodBeat.o(293330);
      return;
    }
    Log.e("MicroMsg.SelectConversationUI", "reportAndStorageRecentForward:  userName is empty ");
    AppMethodBeat.o(293330);
  }
  
  private static boolean bzI(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(280033);
    Object localObject = com.tencent.mm.ay.q.bmh().d(paramString, false, true);
    if (!com.tencent.mm.vfs.u.agG((String)localObject))
    {
      AppMethodBeat.o(280033);
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
    AppMethodBeat.o(280033);
    return bool;
  }
  
  public static String c(Context paramContext, as paramas)
  {
    AppMethodBeat.i(39373);
    paramas = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a(paramas.field_openImAppid, "openim_card_type_name", com.tencent.mm.openim.a.a.a.mxX);
    if (TextUtils.isEmpty(paramas)) {}
    for (paramContext = paramContext.getResources().getString(R.l.app_friend_card_personal);; paramContext = String.format("[%s]", new Object[] { paramas }))
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
    com.tencent.mm.ui.base.b.aI(getContext(), paramIntent2);
    AppMethodBeat.o(39374);
  }
  
  private boolean hYT()
  {
    AppMethodBeat.i(280020);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = l1 - this.XXA;
    if ((l2 > 40L) && (l2 < 300L))
    {
      this.XXA = l1;
      AppMethodBeat.o(280020);
      return false;
    }
    this.XXA = l1;
    AppMethodBeat.o(280020);
    return true;
  }
  
  private String hYU()
  {
    AppMethodBeat.i(169904);
    String str2 = getIntent().getStringExtra("KSendWording");
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = getString(R.l.app_send);
    }
    AppMethodBeat.o(169904);
    return str1;
  }
  
  private void hYV()
  {
    AppMethodBeat.i(293329);
    if (!Util.isNullOrNil(this.XXK)) {
      this.XXK = null;
    }
    if (!Util.isNullOrNil(this.XXL)) {
      this.XXL = null;
    }
    AppMethodBeat.o(293329);
  }
  
  private String hYW()
  {
    AppMethodBeat.i(39380);
    bh.beI();
    ca.b localb = com.tencent.mm.model.c.bbO().aOV(this.fQs);
    String str = "";
    if (localb != null) {
      str = localb.label;
    }
    str = getContext().getString(R.l.app_location) + str;
    AppMethodBeat.o(39380);
    return str;
  }
  
  private Bitmap hYX()
  {
    AppMethodBeat.i(39381);
    com.tencent.mm.modelvideo.s.bqB();
    Object localObject = x.XU(this.fNz.field_imgPath);
    if (localObject == null)
    {
      localObject = this.imagePath;
      if (!com.tencent.mm.plugin.a.c.ZZ(this.imagePath))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.Xd((String)localObject);
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
  
  private Bitmap hYY()
  {
    AppMethodBeat.i(39382);
    if (this.fNz == null)
    {
      AppMethodBeat.o(39382);
      return null;
    }
    String str = this.fNz.field_imgPath;
    localBitmap3 = com.tencent.mm.ay.q.bmh().VZ(str);
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
  
  private void hYZ()
  {
    AppMethodBeat.i(39386);
    Log.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 14);
    localIntent.putExtra("titile", getString(R.l.address_title_select_contact));
    localIntent.putExtra("list_attr", w.XtQ);
    localIntent.putExtra("already_select_contact", Util.listToString(this.XXG, ","));
    localIntent.putExtra("max_limit_num", 9);
    if ((this.XvE) && (as.bvK(this.XXB))) {}
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 5);
      AppMethodBeat.o(39386);
      return;
    }
  }
  
  private void hZa()
  {
    boolean bool = true;
    AppMethodBeat.i(39387);
    Log.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", w.XtN);
    localIntent.putExtra("list_type", 3);
    localIntent.putExtra("be_send_card_name", this.XXB);
    localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
    localIntent.putExtra("Add_SendCard", true);
    localIntent.putExtra("titile", getString(R.l.address_title_select_contact));
    if ((this.XvE) && (as.bvK(this.XXB))) {}
    for (;;)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 3);
      AppMethodBeat.o(39387);
      return;
      bool = false;
    }
  }
  
  private void hZb()
  {
    AppMethodBeat.i(39388);
    Log.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 5);
    localIntent.putExtra("titile", getString(R.l.address_title_select_contact));
    if (((this.fromScene != 4) && (this.fromScene != 9)) || ((getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || (this.fromScene == 10)))
    {
      localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
      localIntent.putExtra("list_attr", w.P(new int[] { 32, 16, 1, 2, 4, 16384 }));
    }
    for (;;)
    {
      getContext().startActivityForResult(localIntent, 1);
      AppMethodBeat.o(39388);
      return;
      if ((this.XXz) && (!this.XXD.booleanValue()))
      {
        localIntent.putExtra("list_attr", w.P(new int[] { 16, 1, 2, 4, 16384 }));
        localIntent.putExtra("without_openim", true);
        localIntent.putExtra("KBlockOpenImFav", true);
      }
      else if (this.XXu)
      {
        localIntent.putExtra("list_attr", w.P(new int[] { w.XtJ, 16384, 64, 4096 }));
        localIntent.putExtra("without_openim", true);
        localIntent.putExtra("KBlockOpenImFav", true);
      }
      else
      {
        localIntent.putExtra("list_attr", w.XtP);
      }
    }
  }
  
  private void iM(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(293331);
    long l1 = cm.bfC();
    long l2 = this.startTime;
    final int n = bIU(paramString);
    final String str = axz(1);
    final int i;
    final int i1;
    final int i2;
    label76:
    final int j;
    label89:
    final int k;
    label101:
    final int i3;
    if (this.fromScene == 17)
    {
      i = 1;
      i1 = this.XXN.bIS(paramString);
      i2 = this.XXN.bIT(paramString);
      if (Util.isNullOrNil(hVd().getSearchContent())) {
        break label309;
      }
      paramInt = 3;
      if (!Util.isNullOrNil(this.XXG)) {
        break label376;
      }
      j = 0;
      if (this.fromScene != 13) {
        break label382;
      }
      k = 1;
      i3 = this.XXN.Xvt;
      if (com.tencent.mm.ui.contact.h.iWB() != 1) {
        break label388;
      }
    }
    label388:
    for (int m = 1;; m = 0)
    {
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(283451);
          String str = SelectConversationUI.m(SelectConversationUI.this);
          com.tencent.mm.ui.contact.m.a(str, n, i1, i2, k, j, i, paramInt, paramString, str, i3, this.CGc, this.aadn);
          AppMethodBeat.o(283451);
        }
      });
      AppMethodBeat.o(293331);
      return;
      if (this.XXH)
      {
        i = 2;
        break;
      }
      if (this.XXq)
      {
        i = 3;
        break;
      }
      if (this.fromScene == 3)
      {
        i = 4;
        break;
      }
      if (this.fromScene == 14)
      {
        i = 5;
        break;
      }
      if ((this.fromScene == 1) || (this.XXp))
      {
        i = 6;
        break;
      }
      if (this.fromScene == 15)
      {
        i = 7;
        break;
      }
      if ((this.fromScene == 16) || (this.XvE) || (this.XXz))
      {
        i = 8;
        break;
      }
      if ((this.wRc) || (this.XXs))
      {
        i = 9;
        break;
      }
      i = 0;
      break;
      label309:
      if ((this.XXN.bAd(paramString)) && (paramInt < this.XXN.aadi + 3) && (paramInt > 0))
      {
        paramInt = 1;
        break label76;
      }
      if ((this.XXN.bAc(paramString)) && (paramInt > this.XXN.aadi + 3))
      {
        paramInt = 2;
        break label76;
      }
      paramInt = 0;
      break label76;
      label376:
      j = 1;
      break label89;
      label382:
      k = 0;
      break label101;
    }
  }
  
  private void iWG()
  {
    AppMethodBeat.i(293328);
    Log.i("MicroMsg.SelectConversationUI", "resetData: recent forward control switch on");
    if (!Util.isNullOrNil(this.XXG))
    {
      int i = 0;
      while (i < this.XXG.size())
      {
        String str = (String)this.XXG.get(i);
        if ((this.aadl != null) && (this.aadl.size() > 0) && (this.aadl.containsKey(str))) {
          this.aadl.get(str);
        }
        iM(str, 0);
        if ((com.tencent.mm.ui.contact.h.iWB() == 1) && (i < 5)) {
          com.tencent.mm.ui.contact.h.bzX(str);
        }
        i += 1;
      }
    }
    Log.e("MicroMsg.SelectConversationUI", "reportAndStorageRecentForward:  mSelectedUserSet is empty ");
    AppMethodBeat.o(293328);
    return;
    hYV();
    AppMethodBeat.o(293328);
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
  
  private static String t(com.tencent.mm.aj.k.b paramb)
  {
    AppMethodBeat.i(39385);
    Object localObject1 = new sc();
    ((sc)localObject1).fRw.type = 0;
    ((sc)localObject1).fRw.fRy = paramb.lmA;
    EventCenter.instance.publish((IEvent)localObject1);
    com.tencent.mm.protocal.b.a.c localc = ((sc)localObject1).fRx.fRG;
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localc != null)
    {
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = Util.nullAs(localc.desc, paramb.description);
      }
    }
    paramb = (com.tencent.mm.aj.k.b)localObject1;
    if (!Util.isNullOrNil((String)localObject1)) {
      paramb = ((String)localObject1).replaceAll("\n", " ");
    }
    AppMethodBeat.o(39385);
    return paramb;
  }
  
  private void t(final Intent paramIntent, final String paramString)
  {
    AppMethodBeat.i(39375);
    if (bAP(paramString))
    {
      AppMethodBeat.o(39375);
      return;
    }
    if (w.hasAttr(this.selectType, 256))
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
    if (ab.Lj(paramString))
    {
      int i = v.Pu(paramString);
      if (this.XXy)
      {
        int j = Util.getInt(com.tencent.mm.n.h.axc().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50);
        if (i > j)
        {
          Log.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          com.tencent.mm.ui.base.h.c(this, getString(R.l.eRT, new Object[] { Integer.valueOf(j) }), "", true);
          AppMethodBeat.o(39375);
          return;
        }
      }
      getString(R.l.eRR, new Object[] { Integer.valueOf(i) });
    }
    o.a locala = new o.a(getContext());
    locala.ee(paramString);
    if (this.XvE)
    {
      a(locala, this.XXB);
      if (ab.Lj(paramString))
      {
        b(paramIntent, this.XXB, paramString);
        locala.w(Boolean.TRUE);
      }
    }
    for (;;)
    {
      locala.RfV = hYU();
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
              com.tencent.mm.plugin.report.service.h.IzE.a(13943, new Object[] { Integer.valueOf(paramAnonymousInt) });
            }
          }
          else
          {
            if (!paramAnonymousBoolean) {
              break label271;
            }
            paramIntent.putExtra("custom_send_text", paramAnonymousString);
            paramIntent.putExtra("KSendGroupToDo", SelectConversationUI.h(SelectConversationUI.this));
            paramIntent.putExtra("KShowTodoIntroduceView", SelectConversationUI.i(SelectConversationUI.this));
            SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
            com.tencent.mm.pluginsdk.ui.tools.s.nw(SelectConversationUI.j(SelectConversationUI.this), paramString);
            if ((!SelectConversationUI.a(SelectConversationUI.this)) && (SelectConversationUI.k(SelectConversationUI.this))) {
              com.tencent.mm.modelstat.a.c(SelectConversationUI.l(SelectConversationUI.this), 5);
            }
            Log.i("MicroMsg.SelectConversationUI", "onDialogClick:  forward click ok. UserName：" + paramString);
            SelectConversationUI.a(SelectConversationUI.this, paramString);
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
            label271:
            if (bool)
            {
              paramAnonymousString = paramIntent.getStringExtra("Select_Contact");
              bh.beI();
              com.tencent.mm.model.c.bbR().bwv(paramAnonymousString);
            }
            if ((!SelectConversationUI.a(SelectConversationUI.this)) && (SelectConversationUI.k(SelectConversationUI.this))) {
              com.tencent.mm.modelstat.a.c(SelectConversationUI.l(SelectConversationUI.this), 6);
            }
          }
        }
      }.show();
      AppMethodBeat.o(39375);
      return;
      a(paramIntent, this.XXB, paramString);
      break;
      Object localObject;
      if (this.XXp)
      {
        if ((getIntent().hasExtra("appbrand_params")) && (a(paramIntent, locala, null)))
        {
          AppMethodBeat.o(39375);
          return;
        }
        if (this.fyE != -1L)
        {
          a(locala);
          localObject = new he();
          ((he)localObject).fDP.fyE = this.fyE;
          ((he)localObject).fDP.fDQ = this.fDQ;
          ((he)localObject).fDP.fDR = this.msgType;
          ((he)localObject).fDP.fDS = locala;
          ((he)localObject).fDP.fDT = this.XXO;
          ((he)localObject).fDP.fvM = getContext();
          EventCenter.instance.publish((IEvent)localObject);
        }
        for (;;)
        {
          locala.w(Boolean.TRUE);
          break;
          if ((this.msgType == 17) && (this.XXx != 0))
          {
            localObject = getContext().getString(R.l.retransmit_msg_count, new Object[] { Integer.valueOf(this.XXx) });
            locala.brm(getResources().getString(R.l.app_multi_msg) + (String)localObject);
          }
        }
      }
      String str1;
      if ((this.XXq) && (!this.wRc))
      {
        localObject = (HashMap)getIntent().getSerializableExtra("webview_params");
        str1 = (String)((HashMap)localObject).get("img_url");
        String str3 = (String)((HashMap)localObject).get("title");
        final String str2 = (String)((HashMap)localObject).get("url");
        if (!this.XXv) {}
        for (localObject = getResources().getString(R.l.app_url) + str3;; localObject = getResources().getString(R.l.app_game_namecard) + (String)localObject)
        {
          locala.brm((String)localObject);
          locala.a(new d.a.b()
          {
            public final void dml()
            {
              AppMethodBeat.i(39352);
              Intent localIntent = new Intent();
              localIntent.putExtra("rawUrl", str2);
              localIntent.putExtra("showShare", false);
              com.tencent.mm.by.c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
              AppMethodBeat.o(39352);
            }
          });
          locala.brn(str1).hkw();
          locala.w(Boolean.TRUE);
          break;
          localObject = (String)((HashMap)localObject).get("nickname");
        }
      }
      if ((this.XXr) && (a(paramIntent, locala, paramString)))
      {
        AppMethodBeat.o(39375);
        return;
      }
      if (this.XXt)
      {
        str1 = getResources().getString(R.l.app_golden_lucky);
        localObject = str1;
        if (this.toD != null) {
          localObject = str1 + this.toD;
        }
        locala.brm((String)localObject);
        locala.w(Boolean.FALSE);
      }
      else if (this.XXu)
      {
        locala.brm(getResources().getString(R.l.app_red_cover_gift));
        locala.w(Boolean.FALSE);
      }
      else
      {
        b(locala, paramString);
        a(locala);
        locala.w(Boolean.TRUE);
      }
    }
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(280018);
    int i;
    Object localObject1;
    if (this.XXF)
    {
      i = paramInt - getContentLV().getHeaderViewsCount();
      if (i < 0)
      {
        Log.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
        hYZ();
        AppMethodBeat.o(280018);
        return;
      }
      paramView = hUP();
      localObject1 = paramView.awM(i);
      if (localObject1 == null)
      {
        AppMethodBeat.o(280018);
        return;
      }
      if (((com.tencent.mm.ui.contact.a.a)localObject1).contact == null)
      {
        AppMethodBeat.o(280018);
        return;
      }
      localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username;
      Log.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[] { localObject1 });
      if ((!this.XXG.contains(localObject1)) && (Hi(true)))
      {
        hUZ();
        AppMethodBeat.o(280018);
        return;
      }
      hUZ();
      this.ETP.bqR((String)localObject1);
      if (this.XXG.contains(localObject1))
      {
        this.XXG.remove(localObject1);
        if (this.aadl.containsKey(localObject1)) {
          this.aadl.remove(localObject1);
        }
      }
      for (;;)
      {
        atk();
        paramView.notifyDataSetChanged();
        AppMethodBeat.o(280018);
        return;
        this.XXG.add(localObject1);
        this.aadl.put(localObject1, Integer.valueOf(paramInt));
      }
    }
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      if (this.XvE)
      {
        hZa();
        AppMethodBeat.o(280018);
        return;
      }
      hZb();
    }
    for (;;)
    {
      if (this.XXH) {
        com.tencent.mm.modelstat.a.c(this.fNz, 4);
      }
      AppMethodBeat.o(280018);
      return;
      paramView = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
      if (paramView == null)
      {
        AppMethodBeat.o(280018);
        return;
      }
      if (((paramView instanceof com.tencent.mm.ui.contact.a.b)) && (((com.tencent.mm.ui.contact.a.b)paramView).nickName == getResources().getString(R.l.enM)))
      {
        Log.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
        paramView = new Intent();
        paramView.putExtra("list_attr", 16384);
        com.tencent.mm.by.c.b(this, "brandservice", ".ui.BrandServiceIndexUI", paramView, 4);
        this.XXq = true;
        AppMethodBeat.o(280018);
        return;
      }
      if ((paramView instanceof com.tencent.mm.ui.contact.a.h))
      {
        Object localObject2 = (com.tencent.mm.ui.contact.a.h)paramView;
        paramView = new Intent();
        paramView.putExtra("scene", this.scene);
        localObject1 = new ArrayList();
        localObject2 = ((com.tencent.mm.ui.contact.a.a)localObject2).BHY.BIy;
        i = localObject2.length;
        paramInt = 0;
        while (paramInt < i)
        {
          ((ArrayList)localObject1).add(localObject2[paramInt]);
          paramInt += 1;
        }
        paramView.putExtra("query_phrase_list", (Serializable)localObject1);
        com.tencent.mm.by.c.d(this, ".ui.transmit.MMCreateChatroomUI", paramView, 1);
        AppMethodBeat.o(280018);
        return;
      }
      paramView = paramView.contact;
      if (paramView == null)
      {
        AppMethodBeat.o(280018);
        return;
      }
      this.aadm = paramInt;
      aWT(paramView.field_username);
    }
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(39391);
    if (paramInt == 1)
    {
      this.XXG.remove(paramString);
      this.aadl.remove(paramString);
      hUP().notifyDataSetChanged();
      atk();
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
    if (this.Wvh == null)
    {
      if (!this.XvE) {
        break label134;
      }
      this.XXn = R.l.eSa;
    }
    for (;;)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39335);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/transmit/SelectConversationUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
      String str = getString(this.XXn);
      View localView = com.tencent.mm.ui.ad.kS(this).inflate(R.i.ehv, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(R.h.content_tv);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.Wvh = ((TextView)localObject);
      this.Wvh.setVisibility(paramInt);
      AppMethodBeat.o(39359);
      return;
      label134:
      if (this.fromScene == 10) {
        this.XXn = R.l.eOK;
      } else {
        this.XXn = R.l.eRV;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39390);
    if ((parama.XsX) && (parama.contact != null))
    {
      boolean bool = this.XXG.contains(parama.contact.field_username);
      AppMethodBeat.o(39390);
      return bool;
    }
    AppMethodBeat.o(39390);
    return false;
  }
  
  protected final void aWT(String paramString)
  {
    AppMethodBeat.i(169903);
    Log.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (bAP(paramString))
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
      if ((this.XXo) || (this.XvE) || (this.XXp) || (this.XXq) || (this.XXr) || (this.wRc) || (this.XXu))
      {
        if (hYT()) {
          t(localIntent1, paramString);
        }
      }
      else if (this.fromScene == 11)
      {
        bAR(paramString);
      }
      else
      {
        s(-1, localIntent1);
        finish();
      }
    }
  }
  
  public final void ata()
  {
    AppMethodBeat.i(39356);
    super.ata();
    this.XXo = getIntent().getBooleanExtra("select_is_ret", false);
    this.fromScene = getIntent().getIntExtra("scene_from", 0);
    Log.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    if (this.fromScene == 1)
    {
      this.XXp = true;
      if (getIntent().getIntExtra("from_scene", -1) != 0) {
        break label630;
      }
    }
    Object localObject1;
    Object localObject2;
    label630:
    for (boolean bool = true;; bool = false)
    {
      this.XXH = bool;
      this.wRc = getIntent().getBooleanExtra("is_mp_video", false);
      this.XXv = getIntent().getBooleanExtra("is_game_card", false);
      this.XXw = getIntent().getBooleanExtra("send_to_biz", false);
      this.Xim = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.fyE = getIntent().getLongExtra("select_fav_local_id", -1L);
      this.fDQ = getIntent().getStringExtra("select_fav_fake_local_id");
      this.XXx = getIntent().getIntExtra("select_fav_select_count", 0);
      this.XXE = getIntent().getBooleanExtra("mutil_select_is_ret", false);
      this.XvE = getIntent().getBooleanExtra("Select_Send_Card", false);
      this.XXz = getIntent().getBooleanExtra("forward_card", false);
      this.XXy = getIntent().getBooleanExtra("Retr_Big_File", false);
      if (this.XvE) {
        this.XXB = getIntent().getStringExtra("Select_Talker_Name");
      }
      this.selectType = getIntent().getIntExtra("Select_Conv_Type", XXm);
      this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
      this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      bh.beI();
      this.fNz = com.tencent.mm.model.c.bbO().Oq(this.msgId);
      this.XWl = ((ArrayList)getIntent().getSerializableExtra("Retr_Msg_Id_List"));
      if (Util.isNullOrNil(this.XWl)) {
        break label635;
      }
      this.XXJ = new ArrayList(this.XWl.size());
      localObject1 = this.XWl.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        List localList = this.XXJ;
        bh.beI();
        localList.add(com.tencent.mm.model.c.bbO().Oq(((Long)localObject2).longValue()));
      }
      if ((this.fromScene != 2) && (this.fromScene != 10))
      {
        if (this.fromScene == 3)
        {
          getIntent();
          bool = cp.cg(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("is_h5"));
          if (bool) {
            Log.i("MicroMsg.SelectConversationUI", "hy: is H5 link");
          }
          if (!bool) {}
        }
      }
      else
      {
        this.XXq = true;
        break;
      }
      if (this.fromScene == 3)
      {
        this.XXr = true;
        break;
      }
      if (this.fromScene == 6)
      {
        this.XXs = true;
        break;
      }
      if (this.fromScene == 7)
      {
        this.XXt = true;
        break;
      }
      if (this.fromScene == 12)
      {
        this.XXu = true;
        break;
      }
      if (this.fromScene != 11) {
        break;
      }
      overridePendingTransition(R.a.push_up_in, R.a.push_down_out);
      break;
    }
    label635:
    this.imagePath = getIntent().getStringExtra("image_path");
    this.XXM = getIntent().getStringExtra("ad_video_title");
    this.toD = getIntent().getStringExtra("desc_title");
    this.emojiMD5 = getIntent().getStringExtra("Retr_Msg_thumb_path");
    if (getIntent().hasExtra("Retr_Msg_content_bytes")) {}
    for (this.fQs = new String(getIntent().getByteArrayExtra("Retr_Msg_content_bytes"));; this.fQs = getIntent().getStringExtra("Retr_Msg_content"))
    {
      this.XXO = getIntent().getStringExtra("Retr_fav_xml_str");
      this.XWm = getIntent().getStringExtra("Retr_Msg_thumb_path");
      if ((this.fQs == null) && (this.fNz != null)) {
        this.fQs = this.fNz.field_content;
      }
      if (this.fQs == null) {
        this.fQs = "";
      }
      this.XXI = ((ReportUtil.ReportArgs)getIntent().getParcelableExtra("Select_Report_Args"));
      this.XXP = getIntent().getStringExtra("KChooseMsgFileType");
      this.XXQ = getIntent().getIntExtra("KChooseMsgFileCount", 9);
      this.XXR = getIntent().getStringExtra("KChooseMsgFileExtension");
      localObject1 = new HashSet();
      ((HashSet)localObject1).addAll(w.hVh());
      localObject2 = getIntent().getStringExtra("Select_block_List");
      if (!Util.isNullOrNil((String)localObject2)) {
        ((HashSet)localObject1).addAll(Util.stringsToList(((String)localObject2).split(",")));
      }
      if (w.hasAttr(this.selectType, 2))
      {
        localObject2 = w.hVi();
        w.h((HashSet)localObject2);
        ((HashSet)localObject1).addAll((Collection)localObject2);
      }
      this.jkb = new ArrayList();
      this.jkb.addAll((Collection)localObject1);
      localObject1 = this.jkb;
      long l = System.currentTimeMillis();
      int i = ((List)localObject1).size();
      ((List)localObject1).addAll(com.tencent.mm.pluginsdk.j.a.hhV());
      Log.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(((List)localObject1).size() - i) });
      if (w.hasAttr(this.selectType, 1)) {
        this.Xts = true;
      }
      if (this.XXE)
      {
        this.XXG = new LinkedList();
        this.aadl = new HashMap();
        if (this.XXE)
        {
          addTextOptionMenu(1, getString(R.l.app_multi_selected), this.XXV, null, w.b.Wao);
          atk();
        }
      }
      AppMethodBeat.o(39356);
      return;
    }
  }
  
  public final boolean bAP(String paramString)
  {
    AppMethodBeat.i(39365);
    if (!bAO(paramString))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if ((!Util.isNullOrNil(getIntent().getStringExtra("Select_App_Id"))) && (this.XvE))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if (this.XvE)
    {
      bh.beI();
      if (as.asD(com.tencent.mm.model.c.bbL().bwg(this.XXB).field_verifyFlag))
      {
        bAQ(paramString);
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
    bh.beI();
    String str = com.tencent.mm.model.c.bbO().aOU(this.fQs).fcC;
    bh.beI();
    if (ab.uL(com.tencent.mm.model.c.bbL().bwg(str).field_verifyFlag))
    {
      bAQ(paramString);
      AppMethodBeat.o(39365);
      return true;
    }
    AppMethodBeat.o(39365);
    return false;
  }
  
  public final boolean bwH()
  {
    return (!this.XXE) || (!this.XXF);
  }
  
  public final boolean bwI()
  {
    return false;
  }
  
  public final String bwJ()
  {
    AppMethodBeat.i(39389);
    String str = getIntent().getStringExtra("Select_Conv_ui_title");
    if ((str == null) || (str.length() <= 0))
    {
      str = getString(R.l.eRX);
      AppMethodBeat.o(39389);
      return str;
    }
    AppMethodBeat.o(39389);
    return str;
  }
  
  public final r bwK()
  {
    AppMethodBeat.i(39357);
    this.XXN = new com.tencent.mm.ui.contact.ad(this, this.jkb, this.Xts, this.XXF, this.XXw, this.selectType);
    com.tencent.mm.ui.contact.ad localad = this.XXN;
    AppMethodBeat.o(39357);
    return localad;
  }
  
  public final com.tencent.mm.ui.contact.p bwL()
  {
    AppMethodBeat.i(39358);
    com.tencent.mm.ui.contact.u localu = new com.tencent.mm.ui.contact.u(this, this.jkb, this.XXF, this.scene);
    AppMethodBeat.o(39358);
    return localu;
  }
  
  public final int[] dvA()
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
    arrayOfInt = super.dvA();
    AppMethodBeat.o(39395);
    return arrayOfInt;
  }
  
  public final void eQp()
  {
    AppMethodBeat.i(39360);
    if (this.fromScene == 5) {
      com.tencent.mm.ui.base.h.a(this, getString(R.l.eKW), null, getString(R.l.send), getString(R.l.cancel), true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
      if (this.XXI != null)
      {
        this.XXI.errCode = 0;
        ReportUtil.a(this, this.XXI, true);
      }
      AppMethodBeat.o(39360);
      return;
      super.eQp();
      hideVKB();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(39363);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      this.fromScene = paramIntent.getIntExtra("scene_from", 0);
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
          if (bAP((String)localObject1))
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
          if ((this.XXo) || (this.XvE) || (this.XXp) || (this.XXq) || (this.XXr) || (this.XXu))
          {
            t(paramIntent, (String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          if (this.fromScene == 11)
          {
            bAR((String)localObject1);
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
        com.tencent.e.h.ZvG.o(new Runnable()
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
          paramIntent = paramIntent.getStringExtra("scene_select_user_liast");
          if (!Util.isNullOrNil(paramIntent))
          {
            this.XXG = new LinkedList(Util.stringsToList(paramIntent.split(",")));
            if (!Util.isNullOrNil(this.XXG))
            {
              if (this.XXG.size() != 1) {
                break label562;
              }
              bIV((String)this.XXG.get(0));
            }
          }
          for (;;)
          {
            paramIntent = new Intent(this, TaskRedirectUI.class);
            paramIntent.addFlags(268435456);
            paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
            com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aFh(), "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent)paramIntent.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ReportUtil.ao(false, 0);
            AppMethodBeat.o(39363);
            return;
            label562:
            iWG();
          }
        }
        if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getBooleanExtra("Select_back_to_app", false)))
        {
          localObject1 = paramIntent.getStringExtra("scene_select_user_liast");
          if (!Util.isNullOrNil((String)localObject1))
          {
            this.XXG = new LinkedList(Util.stringsToList(((String)localObject1).split(",")));
            if (!Util.isNullOrNil(this.XXG))
            {
              if (this.XXG.size() != 1) {
                break label690;
              }
              bIV((String)this.XXG.get(0));
            }
          }
          for (;;)
          {
            ReportUtil.a(this, ReportUtil.d(paramIntent.getExtras(), 0), false);
            AppMethodBeat.o(39363);
            return;
            label690:
            iWG();
          }
          if (paramIntent != null) {
            this.XXI = ((ReportUtil.ReportArgs)paramIntent.getParcelableExtra("Select_Report_Args"));
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
          if ((!Util.isNullOrNil(paramIntent)) && (!bAP(paramIntent)))
          {
            localObject1 = new o.a(getContext());
            ((o.a)localObject1).ee(paramIntent);
            a((o.a)localObject1, this.XXB);
            localObject1 = ((o.a)localObject1).w(Boolean.TRUE);
            ((o.a)localObject1).RfV = hYU();
            {
              public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
              {
                AppMethodBeat.i(39350);
                SelectConversationUI.this.hideVKB();
                Intent localIntent;
                if (paramAnonymousBoolean)
                {
                  localIntent = new Intent();
                  if (!ab.Lj(paramIntent)) {
                    break label94;
                  }
                  SelectConversationUI.c(localIntent, SelectConversationUI.g(SelectConversationUI.this), paramIntent);
                }
                for (;;)
                {
                  localIntent.putExtra("custom_send_text", paramAnonymousString);
                  SelectConversationUI.a(SelectConversationUI.this, paramIntent);
                  SelectConversationUI.a(SelectConversationUI.this, -1, localIntent);
                  SelectConversationUI.this.finish();
                  AppMethodBeat.o(39350);
                  return;
                  label94:
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
        t(paramIntent, paramIntent.getStringExtra("Select_Contact"));
      }
      AppMethodBeat.o(39363);
      return;
    }
    if (paramInt1 == 5)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        localObject1 = this.XXG.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.ETP.bqS((String)localObject2);
        }
        if (!Util.isNullOrNil(paramIntent)) {
          this.XXG = Util.stringsToList(paramIntent.split(","));
        }
        for (;;)
        {
          paramIntent = this.XXG.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.ETP.bqT((String)localObject1);
          }
          this.XXG.clear();
          this.aadl.clear();
        }
        atk();
        hUP().notifyDataSetChanged();
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
    super.eQp();
    AppMethodBeat.o(39361);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39355);
    com.tencent.mm.pluginsdk.h.r(this);
    super.onCreate(paramBundle);
    this.startTime = cm.bfC();
    paramBundle = getIntent().getStringExtra("Select_App_Id");
    String str = getIntent().getStringExtra("Select_Open_Id");
    Log.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + paramBundle + ", openId = " + str);
    if ((!Util.isNullOrNil(paramBundle)) && (!Util.isNullOrNil(str))) {
      new com.tencent.mm.plugin.base.stub.d(this, paramBundle, str, new d.a()
      {
        public final void lk(boolean paramAnonymousBoolean)
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
      }).cxi();
    }
    com.tencent.mm.pluginsdk.h.s(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI
 * JD-Core Version:    0.7.0.1
 */