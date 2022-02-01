package com.tencent.mm.ui.transmit;

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
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.d.a.a.a.b.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.hp;
import com.tencent.mm.autogen.a.rk;
import com.tencent.mm.autogen.a.tr;
import com.tencent.mm.autogen.a.tr.a;
import com.tencent.mm.autogen.a.tr.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.choosemsgfile.compat.a.a;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.message.k.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cq;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.plugin.base.stub.d.a;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.FinderFeedAlbumView;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.cc.c;
import com.tencent.mm.ui.ba;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.n;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.ae;
import com.tencent.mm.ui.contact.ai;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.select.MvvmSelectContactUI;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.contact.z.a;
import com.tencent.mm.ui.contact.z.b;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.a.e.a.b;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.util.b.a;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import junit.framework.Assert;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(19)
public class SelectConversationUI
  extends MMBaseSelectContactUI
{
  private static final int afNH;
  boolean AnG;
  private int[] Aqo;
  private TextView FZP;
  private int aeSs;
  private TextView aecz;
  private ArrayList<Long> afMC;
  private String afMD;
  private int afNI;
  private RelativeLayout afNJ;
  private RelativeLayout afNK;
  private LinearLayout afNL;
  private ImageView afNM;
  private TextView afNN;
  private boolean afNO;
  private boolean afNP;
  private boolean afNQ;
  private boolean afNR;
  private boolean afNS;
  private boolean afNT;
  private boolean afNU;
  boolean afNV;
  protected boolean afNW;
  private int afNX;
  private boolean afNY;
  private boolean afNZ;
  private MenuItem.OnMenuItemClickListener afOA;
  private long afOa;
  private String afOb;
  private String afOc;
  private Boolean afOd;
  private boolean afOe;
  protected boolean afOf;
  protected List<String> afOg;
  protected Map<String, Integer> afOh;
  private boolean afOi;
  private ReportUtil.ReportArgs afOj;
  private List<cc> afOk;
  private String afOl;
  private String afOm;
  private int afOn;
  private boolean afOo;
  private String afOp;
  private com.tencent.mm.ui.contact.z afOq;
  private ae afOr;
  private String afOs;
  private String afOt;
  private int afOu;
  private String afOv;
  private int afOw;
  private boolean afOx;
  protected boolean afOy;
  private MenuItem.OnMenuItemClickListener afOz;
  protected boolean afeW;
  private boolean afhx;
  private String emojiMD5;
  private int fromScene;
  private long hDn;
  private String hIG;
  private cc hTm;
  private String hWn;
  private String imagePath;
  private List<String> lMF;
  private long msgId;
  private int msgType;
  private int selectType;
  private long startTime;
  private String wtc;
  
  static
  {
    AppMethodBeat.i(39409);
    afNH = w.R(new int[] { 1, 2 });
    AppMethodBeat.o(39409);
  }
  
  public SelectConversationUI()
  {
    AppMethodBeat.i(39354);
    this.afNO = false;
    this.afNP = false;
    this.afNQ = false;
    this.afNR = false;
    this.afNS = false;
    this.afNT = false;
    this.afNU = false;
    this.AnG = false;
    this.afNV = false;
    this.fromScene = 0;
    this.afNW = false;
    this.afhx = false;
    this.afNY = false;
    this.afNZ = false;
    this.aeSs = -1;
    this.afOa = -1L;
    this.afOd = Boolean.FALSE;
    this.afOe = false;
    this.afOf = false;
    this.afOg = null;
    this.afOh = null;
    this.afOo = false;
    this.afMD = null;
    this.imagePath = null;
    this.afOp = null;
    this.wtc = null;
    this.afOw = 0;
    this.afOx = false;
    this.afOy = false;
    this.Aqo = new int[] { R.h.fzE, R.h.fzF, R.h.fzG, R.h.fzH, R.h.fzI };
    this.afOz = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(250866);
        paramAnonymousMenuItem = SelectConversationUI.this;
        boolean bool;
        if (!SelectConversationUI.this.afOf)
        {
          bool = true;
          paramAnonymousMenuItem.afOf = bool;
          SelectConversationUI.this.jyE().Mz(SelectConversationUI.this.afOf);
          SelectConversationUI.this.afeC.Mz(SelectConversationUI.this.afOf);
          SelectConversationUI.k(SelectConversationUI.this);
          SelectConversationUI.D(SelectConversationUI.this);
          if (com.tencent.mm.ui.contact.h.jyw()) {
            SelectConversationUI.E(SelectConversationUI.this);
          }
          if (SelectConversationUI.F(SelectConversationUI.this) != null)
          {
            paramAnonymousMenuItem = SelectConversationUI.F(SelectConversationUI.this);
            if (SelectConversationUI.this.afOf) {
              break label173;
            }
          }
        }
        label173:
        for (int i = SelectConversationUI.G(SelectConversationUI.this);; i = R.l.gUK)
        {
          paramAnonymousMenuItem.setText(i);
          if ((SelectConversationUI.this.afOf) && (SelectConversationUI.m(SelectConversationUI.this))) {
            com.tencent.mm.modelstat.a.c(SelectConversationUI.n(SelectConversationUI.this), 7);
          }
          AppMethodBeat.o(250866);
          return true;
          bool = false;
          break;
        }
      }
    };
    this.afOA = new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(250864);
        if (SelectConversationUI.a(SelectConversationUI.this, false))
        {
          AppMethodBeat.o(250864);
          return false;
        }
        paramAnonymousMenuItem = SelectConversationUI.this.afOg.iterator();
        while (paramAnonymousMenuItem.hasNext())
        {
          localObject = (String)paramAnonymousMenuItem.next();
          if (SelectConversationUI.this.bDg((String)localObject))
          {
            AppMethodBeat.o(250864);
            return false;
          }
        }
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.putExtra("Select_Conv_User", Util.listToString(SelectConversationUI.this.afOg, ","));
        Object localObject = (Intent)SelectConversationUI.this.getIntent().getParcelableExtra("Select_Conv_NextStep");
        if (localObject != null) {
          SelectConversationUI.a(SelectConversationUI.this, paramAnonymousMenuItem, (Intent)localObject);
        }
        for (;;)
        {
          AppMethodBeat.o(250864);
          return true;
          if (SelectConversationUI.H(SelectConversationUI.this))
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
  
  private boolean Nd(boolean paramBoolean)
  {
    AppMethodBeat.i(39394);
    if (paramBoolean)
    {
      if (this.afOg.size() < 9) {}
    }
    else {
      while (this.afOg.size() > 9)
      {
        String str = getString(R.l.gUB, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9)) });
        com.tencent.mm.ui.base.k.d(getContext(), str, "", new DialogInterface.OnClickListener()
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
  
  private int a(String paramString, int paramInt, com.tencent.mm.ui.contact.af paramaf)
  {
    int i = 2;
    AppMethodBeat.i(251025);
    if (paramInt == -1)
    {
      AppMethodBeat.o(251025);
      return 0;
    }
    if (paramInt == -2)
    {
      AppMethodBeat.o(251025);
      return 2;
    }
    HashSet localHashSet = jyR();
    int j;
    if (com.tencent.mm.ui.contact.h.jyw()) {
      if (paramaf.jzd() == 0)
      {
        j = 0;
        if ((Util.isNullOrNil(jyQ().getSearchContent())) && ((localHashSet == null) || (!localHashSet.contains(paramString)))) {
          break label111;
        }
        i = 3;
      }
    }
    label208:
    for (;;)
    {
      AppMethodBeat.o(251025);
      return i;
      j = this.Nnk.getHeaderViewsCount();
      break;
      label111:
      if ((paramaf.bBT(paramString)) && (paramInt == j))
      {
        i = 1;
      }
      else if ((!paramaf.bBS(paramString)) || (paramInt <= j + 1))
      {
        i = 0;
        continue;
        if (paramaf.jzd() == 0) {}
        for (j = 2;; j = 3)
        {
          if ((Util.isNullOrNil(jyQ().getSearchContent())) && ((localHashSet == null) || (!localHashSet.contains(paramString)))) {
            break label208;
          }
          i = 3;
          break;
        }
        if ((paramaf.bBT(paramString)) && (paramInt < paramaf.jzd() + j) && (paramInt > 0)) {
          i = 1;
        } else if ((!paramaf.bBS(paramString)) || (paramInt <= j + paramaf.jzd())) {
          i = 0;
        }
      }
    }
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39384);
    Object localObject = null;
    float f = paramInt2 / paramInt1;
    int k = 0;
    int j = 0;
    int m = bd.bs(paramContext, R.f.DialogBigImageMinHeight);
    paramInt1 = bd.bs(paramContext, R.f.DialogBigImageMaxHeight);
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
    AppMethodBeat.i(251087);
    Object localObject1 = new com.tencent.mm.loader.b.e.a();
    ((com.tencent.mm.loader.b.e.a)localObject1).nqd = true;
    ((com.tencent.mm.loader.b.e.a)localObject1).nqc = true;
    ((com.tencent.mm.loader.b.e.a)localObject1).nqp = true;
    Object localObject2 = ((com.tencent.mm.loader.b.e.a)localObject1).blI();
    View localView1 = View.inflate(this, R.i.share_finder_live_feed_to_chat_view, null);
    Object localObject3 = localView1.findViewById(R.h.finder_feed_container);
    localObject1 = (ImageView)((View)localObject3).findViewById(R.h.finder_auth_icon);
    ImageView localImageView = (ImageView)((View)localObject3).findViewById(R.h.finder_avatar);
    View localView2 = ((View)localObject3).findViewById(R.h.finder_olympic_invite_view);
    ((View)localObject3).findViewById(R.h.finder_share_view);
    Object localObject4 = com.tencent.mm.loader.e.noo;
    com.tencent.mm.loader.e.blh().a(Util.nullAsNil(paramb.HbV.headUrl), localImageView, (com.tencent.mm.loader.b.e)localObject2);
    localObject2 = (TextView)((View)localObject3).findViewById(R.h.finder_nickname);
    ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramb.HbV.nickName));
    com.tencent.mm.ui.aw.a(((TextView)localObject2).getPaint(), 0.8F);
    localImageView = (ImageView)((View)localObject3).findViewById(R.h.finder_thumb);
    localObject4 = (TextView)((View)localObject3).findViewById(R.h.finder_desc);
    if (TextUtils.isEmpty(paramb.HbV.desc))
    {
      ((TextView)localObject4).setVisibility(8);
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).fillAuthIcon((TextView)localObject2, (ImageView)localObject1, paramb, 12.0F);
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).loadImage(Util.nullAs(paramb.HbV.coverUrl, ""), localImageView);
      int i = (int)getContext().getResources().getDimension(R.f.Edge_18A);
      localImageView.setLayoutParams(new FrameLayout.LayoutParams(i, (int)(1.333333F * i)));
      localView2.setLayoutParams(new FrameLayout.LayoutParams(i, (int)(1.333333F * i)));
      if ((paramb.HbV.ZVq != null) && (!paramb.HbV.ZVq.isEmpty()) && (Objects.equals(paramb.HbV.eventId, "1")))
      {
        localObject1 = (ImageView)localView2.findViewById(R.h.finder_olympic_invite_bg);
        localObject2 = (ImageView)localView2.findViewById(R.h.finder_olympic_invite_icon);
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage((ImageView)localObject1, b.j.ahpn, R.g.finder_olympic_live_share_bg);
        ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).loadOlympicsImage((ImageView)localObject2, b.j.ahpo, R.g.finder_olympic_live_share_icon);
        localObject4 = (TextView)localView2.findViewById(R.h.finder_olympic_invite_text);
        ((TextView)localObject4).setTextSize(1, 14.0F);
        localObject1 = (TextView)localView2.findViewById(R.h.finder_olympic_invite_name);
        ((TextView)localObject1).setTextSize(1, 14.0F);
        localObject2 = (TextView)localView2.findViewById(R.h.finder_olympic_invite_you);
        ((TextView)localObject2).setTextSize(1, 13.0F);
        com.tencent.mm.ui.aw.a(((TextView)localObject4).getPaint(), 0.8F);
        com.tencent.mm.ui.aw.a(((TextView)localObject1).getPaint(), 0.8F);
        com.tencent.mm.ui.aw.a(((TextView)localObject2).getPaint(), 0.8F);
        if ((paramb.HbV.ZVr != null) && (!paramb.HbV.ZVr.isEmpty())) {
          break label791;
        }
        ((TextView)localObject1).setVisibility(8);
        label560:
        localObject1 = getContext().getResources().getString(R.l.finder_olympic_invite_text_3, new Object[] { paramb.HbV.ZVq });
        int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 12);
        localObject2 = ((String)localObject1).replace("\n", "");
        if (new StaticLayout((CharSequence)localObject2, 0, ((String)localObject2).length(), ((TextView)localObject4).getPaint(), i - j * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() > 1) {
          break label816;
        }
        localObject1 = localObject2;
      }
    }
    label791:
    label816:
    for (;;)
    {
      ((TextView)localObject4).setText((CharSequence)localObject1);
      localView2.setVisibility(0);
      localImageView.setVisibility(8);
      ((View)localObject3).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).setFinderLiveTagText(((View)localObject3).findViewById(R.h.finder_live_icon), paramb.HbV.ZVl);
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      localObject2 = q.t.DvI;
      localObject3 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((com.tencent.mm.plugin.finder.live.report.j)localObject1).a((q.t)localObject2, com.tencent.mm.plugin.finder.live.report.j.ah(paramb.HbV.liveId, paramb.HbV.feedId, ""));
      AppMethodBeat.o(251087);
      return localView1;
      ((TextView)localObject4).setVisibility(0);
      ((TextView)localObject4).setText(paramb.HbV.desc);
      break;
      ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramb.HbV.ZVr));
      ((TextView)localObject1).setVisibility(0);
      break label560;
    }
  }
  
  private View a(com.tencent.mm.plugin.findersdk.a.d paramd)
  {
    AppMethodBeat.i(251065);
    View localView = View.inflate(this, R.i.goi, null);
    TextView localTextView = (TextView)localView.findViewById(R.h.title);
    FinderFeedAlbumView localFinderFeedAlbumView = (FinderFeedAlbumView)localView.findViewById(R.h.feedAlbumView);
    localFinderFeedAlbumView.setItemViewWidth(com.tencent.mm.cd.a.fromDPToPix(localView.getContext(), 70));
    Object localObject = paramd.oUa.aacP;
    localObject = ((List)localObject).subList(0, Math.min(4, ((List)localObject).size()));
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < ((List)localObject).size())
    {
      dji localdji = new dji();
      localdji.url = ((String)paramd.oUa.aacP.get(i));
      localdji.url_token = ((String)paramd.oUa.aacQ.get(i));
      localdji.thumb_url_token = localdji.url_token;
      localdji.thumbUrl = localdji.url;
      localLinkedList.add(localdji);
      i += 1;
    }
    localFinderFeedAlbumView.setAdapter(new com.tencent.mm.plugin.finder.view.adapter.b(localLinkedList, false));
    localTextView.setText(paramd.oUa.title);
    AppMethodBeat.o(251065);
    return localView;
  }
  
  private View a(com.tencent.mm.plugin.findersdk.a.f paramf)
  {
    AppMethodBeat.i(163387);
    Object localObject1 = new com.tencent.mm.loader.b.e.a();
    ((com.tencent.mm.loader.b.e.a)localObject1).nqd = true;
    ((com.tencent.mm.loader.b.e.a)localObject1).nqc = true;
    ((com.tencent.mm.loader.b.e.a)localObject1).nqp = true;
    localObject1 = ((com.tencent.mm.loader.b.e.a)localObject1).blI();
    View localView1 = View.inflate(this, R.i.share_finder_feed_to_chat_view, null);
    View localView2 = localView1.findViewById(R.h.finder_feed_container);
    Object localObject2 = (ImageView)localView2.findViewById(R.h.finder_avatar);
    Object localObject3 = com.tencent.mm.loader.e.noo;
    com.tencent.mm.loader.e.blh().a(Util.nullAsNil(paramf.bCr()), (ImageView)localObject2, (com.tencent.mm.loader.b.e)localObject1);
    localObject2 = (TextView)localView2.findViewById(R.h.finder_nickname);
    localObject1 = av.GiL;
    ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, av.aBN(paramf.getNickname())));
    com.tencent.mm.ui.aw.a(((TextView)localObject2).getPaint(), 0.8F);
    localObject3 = (ImageView)localView2.findViewById(R.h.finder_thumb);
    localObject1 = (ImageView)localView2.findViewById(R.h.finder_mediaType);
    ImageIndicatorView localImageIndicatorView = (ImageIndicatorView)localView2.findViewById(R.h.chatting_item_finder_image_indicator);
    TextView localTextView1 = (TextView)localView2.findViewById(R.h.finder_desc);
    ImageView localImageView = (ImageView)localView2.findViewById(R.h.finder_auth_icon);
    label256:
    label296:
    int i;
    if (paramf.oUc.GfT == 1)
    {
      ((ImageView)localObject3).setVisibility(8);
      TextView localTextView2 = (TextView)localView2.findViewById(R.h.finder_text);
      localTextView2.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramf.oUc.desc));
      localTextView2.setVisibility(0);
      localTextView1.setVisibility(8);
      if ((paramf.oUc.GfT != 4) && (paramf.oUc.GfT != 6)) {
        break label557;
      }
      ((ImageView)localObject1).setVisibility(0);
      if (localImageIndicatorView != null) {
        localImageIndicatorView.setVisibility(8);
      }
      i = (int)getContext().getResources().getDimension(R.f.Edge_18A);
      localObject1 = null;
      if (!paramf.oUc.mediaList.isEmpty()) {
        localObject1 = (bvj)paramf.oUc.mediaList.get(0);
      }
      if (localObject1 == null) {
        break label621;
      }
      ((ImageView)localObject3).setLayoutParams(new FrameLayout.LayoutParams(i, (int)(androidx.core.b.a.g(((bvj)localObject1).height * 1.0F / ((bvj)localObject1).width, 1.0F, 1.333333F) * i)));
    }
    for (;;)
    {
      localView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      av.GiL.a(localImageView, (TextView)localObject2, paramf.oUc, (int)localImageView.getResources().getDimension(R.f.Edge_2A));
      paramf = (LinearLayout)localView1.findViewById(R.h.fyJ);
      if (paramf != null) {
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().e(paramf, R.g.fnO, R.g.fnN);
      }
      AppMethodBeat.o(163387);
      return localView1;
      if (paramf.oUc.mediaList.size() > 0) {
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).loadImage(((bvj)paramf.oUc.mediaList.get(0)).thumbUrl, (ImageView)localObject3);
      }
      if (Util.isNullOrNil(paramf.oUc.desc)) {
        break;
      }
      localTextView1.setVisibility(0);
      localTextView1.setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramf.oUc.desc));
      break label256;
      label557:
      if (paramf.oUc.GfT == 2)
      {
        ((ImageView)localObject1).setVisibility(8);
        if (localImageIndicatorView == null) {
          break label296;
        }
        localImageIndicatorView.setVisibility(0);
        localImageIndicatorView.RVj = paramf.oUc.hGP;
        break label296;
      }
      ((ImageView)localObject1).setVisibility(8);
      if (localImageIndicatorView == null) {
        break label296;
      }
      localImageIndicatorView.setVisibility(8);
      break label296;
      label621:
      ((ImageView)localObject3).setLayoutParams(new FrameLayout.LayoutParams(i, i));
    }
  }
  
  private View a(com.tencent.mm.plugin.findersdk.a.h paramh)
  {
    AppMethodBeat.i(251081);
    Object localObject1 = paramh.HbZ;
    paramh = View.inflate(this, R.i.share_finder_product_feed_to_chat_view, null);
    ((TextView)paramh.findViewById(R.h.title_tv)).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, Util.nullAsNil(((bth)localObject1).aabi)));
    Object localObject2 = (TextView)paramh.findViewById(R.h.desc_tv);
    Object localObject3 = new StringBuilder("¥");
    Object localObject4 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
    ((TextView)localObject2).setText(com.tencent.mm.plugin.finder.utils.aw.Uu(((bth)localObject1).aabk));
    localObject2 = (ImageView)paramh.findViewById(R.h.cover_iv);
    localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject3 = com.tencent.mm.plugin.finder.loader.p.eCn();
    localObject1 = new com.tencent.mm.plugin.finder.loader.s(((bth)localObject1).coverUrl, com.tencent.mm.plugin.finder.storage.v.FKZ);
    localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject3).a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
    AppMethodBeat.o(251081);
    return paramh;
  }
  
  private View a(com.tencent.mm.plugin.findersdk.a.j paramj)
  {
    AppMethodBeat.i(251079);
    Object localObject1 = new com.tencent.mm.loader.b.e.a();
    ((com.tencent.mm.loader.b.e.a)localObject1).nqd = true;
    ((com.tencent.mm.loader.b.e.a)localObject1).nqc = true;
    ((com.tencent.mm.loader.b.e.a)localObject1).nqp = true;
    Object localObject2 = ((com.tencent.mm.loader.b.e.a)localObject1).blI();
    localObject1 = View.inflate(this, R.i.share_finder_feed_to_chat_view, null);
    View localView = ((View)localObject1).findViewById(R.h.finder_feed_container);
    ImageView localImageView = (ImageView)localView.findViewById(R.h.finder_avatar);
    Object localObject3 = com.tencent.mm.loader.e.noo;
    com.tencent.mm.loader.e.blh().a(Util.nullAsNil(paramj.oUe.avatar), localImageView, (com.tencent.mm.loader.b.e)localObject2);
    localObject2 = (TextView)localView.findViewById(R.h.finder_nickname);
    ((TextView)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramj.oUe.nickname));
    com.tencent.mm.ui.aw.a(((TextView)localObject2).getPaint(), 0.8F);
    localObject2 = (ImageView)localView.findViewById(R.h.finder_thumb);
    localImageView = (ImageView)localView.findViewById(R.h.finder_mediaType);
    localObject3 = (TextView)localView.findViewById(R.h.finder_desc);
    if (paramj.oUe.mediaList.size() > 0)
    {
      if (!Util.isNullOrNil(((dob)paramj.oUe.mediaList.get(0)).coverUrl)) {
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).loadImage(((dob)paramj.oUe.mediaList.get(0)).coverUrl, (ImageView)localObject2);
      }
    }
    else
    {
      if (Util.isNullOrNil(paramj.oUe.desc)) {
        break label445;
      }
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.span.p.b(this, paramj.oUe.desc));
    }
    for (;;)
    {
      localImageView.setVisibility(0);
      int i = (int)getContext().getResources().getDimension(R.f.Edge_18A);
      paramj = (dob)paramj.oUe.mediaList.getFirst();
      ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(i, (int)(androidx.core.b.a.g(paramj.height * 1.0F / paramj.width, 1.0F, 1.333333F) * i)));
      localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      paramj = (LinearLayout)((View)localObject1).findViewById(R.h.fyJ);
      if (paramj != null) {
        ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().e(paramj, R.g.fnO, R.g.fnN);
      }
      AppMethodBeat.o(251079);
      return localObject1;
      ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).loadImage(((dob)paramj.oUe.mediaList.get(0)).thumbUrl, (ImageView)localObject2);
      break;
      label445:
      ((TextView)localObject3).setVisibility(8);
    }
  }
  
  private View a(String paramString, com.tencent.mm.message.k.b paramb, final com.tencent.mm.pluginsdk.ui.tools.b paramb1)
  {
    AppMethodBeat.i(251076);
    Object localObject = new com.tencent.mm.loader.b.e.a();
    ((com.tencent.mm.loader.b.e.a)localObject).nqd = true;
    ((com.tencent.mm.loader.b.e.a)localObject).nqc = true;
    ((com.tencent.mm.loader.b.e.a)localObject).nqp = true;
    ((com.tencent.mm.loader.b.e.a)localObject).blI();
    localObject = View.inflate(this, R.i.gol, null);
    ((RoundCornerRelativeLayout)((View)localObject).findViewById(R.h.round_corner_rl)).setRadius(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4));
    final View localView1 = ((View)localObject).findViewById(R.h.blur_bg_view);
    View localView2 = ((View)localObject).findViewById(R.h.music_container);
    MMRoundCornerImageView localMMRoundCornerImageView;
    TextView localTextView1;
    TextView localTextView3;
    if (com.tencent.mm.ui.aw.isDarkMode())
    {
      localView2.setBackgroundResource(R.g.sns_music_mv_dark_gradient_bg);
      localMMRoundCornerImageView = (MMRoundCornerImageView)localView2.findViewById(R.h.chatting_music_cover);
      localTextView1 = (TextView)localView2.findViewById(R.h.chatting_music_singer_name);
      TextView localTextView2 = (TextView)localView2.findViewById(R.h.chatting_music_song_name);
      localTextView3 = (TextView)localView2.findViewById(R.h.chatting_music_mv_info);
      localMMRoundCornerImageView.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.g.music_mv_cover_empty_lightmode));
      if (com.tencent.mm.ui.aw.isDarkMode()) {
        localMMRoundCornerImageView.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.g.music_mv_cover_empty_darkmode));
      }
      localTextView2.setText(paramb.getTitle());
      if (Util.isNullOrNil(paramb.getDescription())) {
        break label459;
      }
      localTextView1.setText(paramb.getDescription());
      localTextView1.setVisibility(0);
      label231:
      String str = paramb1.YqP;
      paramb1 = paramb1.YqQ;
      if (Util.isNullOrNil(paramb1)) {
        break label477;
      }
      ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6);
      ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 2);
      localView2.findViewById(R.h.padding_view).setVisibility(0);
      localTextView3.setText(paramb1 + getContext().getString(R.l.music_mv_info_share_suffix));
      localTextView3.setVisibility(0);
      label336:
      paramb1 = new boolean[1];
      paramb1[0] = 0;
      if (Util.isNullOrNil(str)) {
        break label495;
      }
      paramString = new com.tencent.mm.modelimage.loader.a.c.a();
      paramString.fullPath = com.tencent.mm.plugin.music.h.b.aPp(str);
      paramString.oKp = true;
      paramString.nrc = true;
      paramString.oKn = true;
      paramString.oKI = com.tencent.mm.cd.a.fromDPToPix(getContext(), 2);
      paramString = paramString.bKx();
      com.tencent.mm.modelimage.r.bKe().a(str, localMMRoundCornerImageView, paramString, new com.tencent.mm.modelimage.loader.b.h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.modelimage.loader.c.b paramAnonymousb)
        {
          AppMethodBeat.i(250874);
          if ((paramAnonymousb.bitmap != null) && (!paramAnonymousb.bitmap.isRecycled()))
          {
            paramAnonymousString = com.tencent.mm.b.g.getMessageDigest(paramAnonymousString.getBytes());
            paramAnonymousView = com.tencent.mm.plugin.comm.b.xeH;
            com.tencent.mm.plugin.comm.b.a(SelectConversationUI.this.getContext(), localView1, paramAnonymousb.bitmap, paramAnonymousString);
            AppMethodBeat.o(250874);
            return;
          }
          paramb1[0] = true;
          AppMethodBeat.o(250874);
        }
        
        public final void c(String paramAnonymousString, View paramAnonymousView) {}
      });
    }
    for (;;)
    {
      localView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      AppMethodBeat.o(251076);
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
      if (!paramb.bwo())
      {
        bh.bCz();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          paramb = null;
          if (!bBw(paramString)) {
            paramb = com.tencent.mm.modelimage.r.bKa().b(paramString, com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext()), false);
          }
          if ((paramb != null) && (!paramb.isRecycled()))
          {
            localMMRoundCornerImageView.setImageBitmap(paramb);
            paramString = com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
            paramb1 = com.tencent.mm.plugin.comm.b.xeH;
            com.tencent.mm.plugin.comm.b.a(getContext(), localView1, paramb, paramString);
            continue;
          }
          paramb1[0] = 1;
          continue;
        }
      }
      localMMRoundCornerImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.g.foI));
    }
  }
  
  private void a(final Intent paramIntent, o.a parama, final HashMap<String, Object> paramHashMap, boolean paramBoolean, String paramString1, String paramString2, final String paramString3)
  {
    AppMethodBeat.i(180098);
    String str1 = cq.d(paramHashMap.get("app_id"), null);
    int i = cq.j(paramHashMap.get("pkg_type"), 0);
    int j = cq.j(paramHashMap.get("pkg_version"), 0);
    String str2 = cq.d(paramHashMap.get("cache_key"), null);
    String str3 = cq.d(paramHashMap.get("path"), null);
    String str4 = cq.d(paramHashMap.get("delay_load_img_path"), null);
    Object localObject2 = cq.d(paramHashMap.get("nickname"), "");
    boolean bool2 = cq.dy(paramHashMap.get("is_dynamic"));
    int k = cq.j(paramHashMap.get("subType"), 0);
    int m = cq.j(paramHashMap.get("biz"), k.a.nQY.ordinal());
    Object localObject3;
    Object localObject1;
    if (k.a.uB(m))
    {
      localObject3 = cq.d(paramHashMap.get("tail_lang"), "");
      String str5 = cq.d(paramHashMap.get("icon_url"), "");
      localObject1 = new Bundle();
      ((Bundle)localObject1).putInt("key_biz", m);
      ((Bundle)localObject1).putString("key_footer_text_default", (String)localObject2);
      ((Bundle)localObject1).putString("key_footer_text", k.a.b(m, (String)localObject3, getContext()));
      ((Bundle)localObject1).putString("key_footer_icon", str5);
      Log.d("MicroMsg.SelectConversationUI", "defaultFooterTxt: %s, tailLang: %s.", new Object[] { localObject2, localObject3 });
      localObject2 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class);
      if (paramString3 != null) {
        break label749;
      }
    }
    label749:
    for (boolean bool1 = false;; bool1 = com.tencent.mm.model.ab.IL(paramString3))
    {
      localObject1 = ((com.tencent.mm.modelappbrand.k)localObject2).a(this, (Bundle)localObject1, bool1, new k.c()
      {
        public final void bEL()
        {
          AppMethodBeat.i(250911);
          paramIntent.putExtra("KShowTodoIntroduceView", 1);
          g.a(SelectConversationUI.this, null);
          AppMethodBeat.o(250911);
        }
        
        public final void gU(boolean paramAnonymousBoolean) {}
      });
      localObject2 = com.tencent.mm.plugin.appbrand.af.p.el(this);
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
        paramString1 = cq.d(paramHashMap.get("video_path"), "");
        paramHashMap = cq.d(paramHashMap.get("video_thumb_path"), "");
        ((Bundle)localObject3).putBoolean("is_video", true);
        ((Bundle)localObject3).putString("video_path", paramString1);
        ((Bundle)localObject3).putString("video_thumb_path", paramHashMap);
      }
      paramHashMap = new h(this);
      paramHashMap.afPO = new h.a()
      {
        public final void g(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
        {
          AppMethodBeat.i(250900);
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
            ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).b(this.rma, this.val$view);
            AppMethodBeat.o(250900);
            return;
            SelectConversationUI.A(SelectConversationUI.this);
            break;
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            if (SelectConversationUI.this.afOy) {
              SelectConversationUI.this.finish();
            }
          }
        }
      };
      ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).a((String)localObject2, (View)localObject1, (Bundle)localObject3, new com.tencent.mm.modelappbrand.k.b()
      {
        public final void vJ(int paramAnonymousInt)
        {
          AppMethodBeat.i(250856);
          Log.i("MicroMsg.SelectConversationUI", "onLoadImageResult() result:%d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          paramHashMap.jEb();
          AppMethodBeat.o(250856);
        }
      });
      parama.kL((View)localObject1);
      parama.I(Boolean.TRUE);
      parama.iLo();
      parama.uBy = new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(250857);
          ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).b(this.rma, this.val$view);
          AppMethodBeat.o(250857);
        }
      };
      parama.GGQ = jDK();
      {
        public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(250851);
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
            AppMethodBeat.o(250851);
            return;
            SelectConversationUI.A(SelectConversationUI.this);
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
        localObject2 = cq.d(paramHashMap.get("footer_icon"), "");
        localObject3 = cq.d(paramHashMap.get("footer_text"), "");
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
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(39342);
          Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", SelectConversationUI.x(SelectConversationUI.this));
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/transmit/SelectConversationUI$27", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$27", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.ne(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39342);
        }
      });
      AppMethodBeat.o(39378);
      return;
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(39343);
          Log.i("MicroMsg.SelectConversationUI", "[ImageGalleryUI] showImgGallery");
          Object localObject = new Intent(SelectConversationUI.this.getContext(), ImageGalleryUI.class);
          ((Intent)localObject).putExtra("img_gallery_msg_id", SelectConversationUI.C(SelectConversationUI.this));
          ((Intent)localObject).putExtra("img_gallery_msg_svr_id", SelectConversationUI.n(SelectConversationUI.this).field_msgSvrId);
          ((Intent)localObject).putExtra("img_gallery_talker", SelectConversationUI.n(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_gallery_chatroom_name", SelectConversationUI.n(SelectConversationUI.this).field_talker);
          ((Intent)localObject).putExtra("img_preview_only", true);
          SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/transmit/SelectConversationUI$28", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$28", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.ne(SelectConversationUI.this.getContext());
          AppMethodBeat.o(39343);
        }
      });
      AppMethodBeat.o(39378);
      return;
      bh.bCz();
      if (com.tencent.mm.model.c.bzD() == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      bh.bCz();
      Object localObject = com.tencent.mm.model.c.bzD().aLV(this.hWn);
      parama.a(new e.a.b()
      {
        public final void dTb()
        {
          AppMethodBeat.i(180091);
          Intent localIntent = new Intent();
          localIntent.putExtra("map_view_type", 1);
          localIntent.putExtra("kwebmap_slat", this.afOW.KbW);
          localIntent.putExtra("kwebmap_lng", this.afOW.KbX);
          localIntent.putExtra("Kwebmap_locaion", this.afOX);
          localIntent.putExtra("kShowshare", false);
          com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "location", ".ui.RedirectUI", localIntent);
          AppMethodBeat.o(180091);
        }
      });
      AppMethodBeat.o(39378);
      return;
      localObject = com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn));
      if (localObject == null)
      {
        AppMethodBeat.o(39378);
        return;
      }
      if (((((com.tencent.mm.message.k.b)localObject).type == 5) && (!com.tencent.mm.ui.chatting.o.i(this.hTm, this.aeSs))) || (((com.tencent.mm.message.k.b)localObject).type == 69))
      {
        parama.a(new e.a.b()
        {
          public final void dTb()
          {
            AppMethodBeat.i(180092);
            if (Util.isNullOrNil(this.val$url))
            {
              AppMethodBeat.o(180092);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", this.val$url);
            localIntent.putExtra("showShare", false);
            com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(180092);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.message.k.b)localObject).type == 6)
      {
        parama.a(new e.a.b()
        {
          public final void dTb()
          {
            AppMethodBeat.i(180093);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.C(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$31", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(180093);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.message.k.b)localObject).type == 24)
      {
        parama.a(new e.a.b()
        {
          public final void dTb()
          {
            AppMethodBeat.i(250859);
            rk localrk = new rk();
            localrk.hUw.context = SelectConversationUI.this.getContext();
            localrk.hUw.msgId = SelectConversationUI.C(SelectConversationUI.this);
            localrk.hUw.hUx = this.svq.nRF;
            localrk.hUw.hTH = false;
            localrk.hUw.scene = 7;
            localrk.publish();
            AppMethodBeat.o(250859);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if (((com.tencent.mm.message.k.b)localObject).type == 19)
      {
        parama.a(new e.a.b()
        {
          public final void dTb()
          {
            AppMethodBeat.i(250862);
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.C(SelectConversationUI.this));
            localIntent.putExtra("Retr_Security_Msg_Id", SelectConversationUI.C(SelectConversationUI.this));
            localIntent.putExtra("record_xml", this.svq.nRF);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(250862);
          }
        });
        AppMethodBeat.o(39378);
        return;
      }
      if ((((com.tencent.mm.message.k.b)localObject).type == 3) || (((com.tencent.mm.message.k.b)localObject).type == 76))
      {
        parama.a(new e.a.b()
        {
          public final void dTb()
          {
            AppMethodBeat.i(250863);
            Object localObject2 = com.tencent.mm.pluginsdk.model.app.u.ab(this.svq.url, "message");
            String str = com.tencent.mm.pluginsdk.model.app.u.ab(this.svq.nRc, "message");
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
              AppMethodBeat.o(250863);
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
      if (((com.tencent.mm.message.k.b)localObject).type == 4)
      {
        parama.a(new e.a.b()
        {
          public final void dTb() {}
        });
        AppMethodBeat.o(39378);
        return;
      }
      if ((((com.tencent.mm.message.k.b)localObject).type == 53) || (((com.tencent.mm.message.k.b)localObject).type == 57))
      {
        parama.a(new e.a.b()
        {
          public final void dTb()
          {
            AppMethodBeat.i(250871);
            Object localObject = new Intent(SelectConversationUI.this.getContext(), RetransmitPreviewUI.class);
            ((Intent)localObject).putExtra("Retr_Msg_content", this.svq.title);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/transmit/SelectConversationUI$36", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$36", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.ui.base.b.ne(SelectConversationUI.this.getContext());
            AppMethodBeat.o(250871);
          }
        });
        AppMethodBeat.o(39378);
        return;
        parama.a(new e.a.b()
        {
          public final void dTb()
          {
            AppMethodBeat.i(250872);
            Object localObject = n.nk(SelectConversationUI.this.getContext());
            localObject = com.tencent.mm.message.k.b.Hf(Util.processXml(com.tencent.mm.plugin.record.model.q.a(((tr)localObject).hXu.hXA.title, ((tr)localObject).hXu.hXA.desc, ((tr)localObject).hXu.hWG.hDr.hDt, ((tr)localObject).hXt.from, SelectConversationUI.C(SelectConversationUI.this))));
            if (localObject == null)
            {
              AppMethodBeat.o(250872);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("message_id", SelectConversationUI.C(SelectConversationUI.this));
            localIntent.putExtra("record_xml", ((com.tencent.mm.message.k.b)localObject).nRF);
            localIntent.putExtra("record_show_share", false);
            com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "record", ".ui.RecordMsgDetailUI", localIntent);
            AppMethodBeat.o(250872);
          }
        });
        AppMethodBeat.o(39378);
        return;
        n.nk(getContext());
        AppMethodBeat.o(39378);
        return;
        parama.a(new e.a.b()
        {
          public final void dTb()
          {
            AppMethodBeat.i(250873);
            Object localObject = new Intent();
            ((Intent)localObject).setClassName(SelectConversationUI.this.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            ((Intent)localObject).putExtra("app_msg_id", SelectConversationUI.C(SelectConversationUI.this));
            ((Intent)localObject).putExtra("app_show_share", false);
            SelectConversationUI localSelectConversationUI = SelectConversationUI.this;
            localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
            com.tencent.mm.hellhoundlib.a.a.b(localSelectConversationUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/transmit/SelectConversationUI$38", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localSelectConversationUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(localSelectConversationUI, "com/tencent/mm/ui/transmit/SelectConversationUI$38", "onContentClick", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(250873);
          }
        });
      }
    }
  }
  
  private void a(o.a parama, String paramString)
  {
    AppMethodBeat.i(39371);
    bh.bCz();
    com.tencent.mm.model.c.bzA().bxu(paramString);
    String str = com.tencent.mm.model.aa.getDisplayName(paramString);
    if (!Util.isNullOrNil(this.afOc)) {
      str = this.afOc;
    }
    parama.bra(bDk(paramString) + str);
    AppMethodBeat.o(39371);
  }
  
  private boolean a(final Intent paramIntent, final o.a parama, final String paramString)
  {
    AppMethodBeat.i(180097);
    Object localObject2 = (HashMap)getIntent().getSerializableExtra("appbrand_params");
    boolean bool1 = cq.dy(((HashMap)localObject2).get("is_weishi_video"));
    final boolean bool2 = cq.dy(((HashMap)localObject2).get("is_video"));
    if (bool1)
    {
      bool1 = a(parama, (HashMap)localObject2);
      AppMethodBeat.o(180097);
      return bool1;
    }
    int i = cq.j(((HashMap)localObject2).get("type"), 1);
    final String str2 = cq.d(((HashMap)localObject2).get("title"), "");
    final String str1 = cq.d(((HashMap)localObject2).get("img_url"), null);
    int j = cq.j(((HashMap)localObject2).get("biz"), k.a.nQY.ordinal());
    if ((!k.a.uB(j)) && ((i == 2) || (i == 3)))
    {
      if ((paramString != null) && (com.tencent.mm.chatroom.d.ab.aLX()) && (com.tencent.mm.model.ab.IL(paramString)) && (MultiProcessMMKV.getMMKV("group_to_do").getBoolean("introduce_dialog_first", true)))
      {
        MultiProcessMMKV.getMMKV("group_to_do").edit().putBoolean("introduce_dialog_first", false);
        g.a(this, new g.a()
        {
          public final void jxp()
          {
            AppMethodBeat.i(250807);
            paramIntent.putExtra("KShowTodoIntroduceView", 1);
            SelectConversationUI.a(SelectConversationUI.this, paramIntent, parama, this.afOQ, bool2, str1, str2, paramString);
            AppMethodBeat.o(250807);
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
      localObject2 = cq.d(((HashMap)localObject2).get("nickname"), null);
      if (Util.isNullOrNil((String)localObject2)) {}
      for (;;)
      {
        parama.bra((String)localObject1 + str2);
        localObject1 = new h(this);
        ((h)localObject1).afPO = new h.a()
        {
          public final void g(boolean paramAnonymousBoolean1, String paramAnonymousString, boolean paramAnonymousBoolean2)
          {
            AppMethodBeat.i(250812);
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
                AppMethodBeat.o(250812);
                return;
                SelectConversationUI.A(SelectConversationUI.this);
              }
            }
            SelectConversationUI.a(SelectConversationUI.this, 0, paramIntent);
            if (SelectConversationUI.this.afOy) {
              SelectConversationUI.this.finish();
            }
            AppMethodBeat.o(250812);
          }
        };
        com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
        {
          public final void bFg() {}
          
          public final void bFh()
          {
            AppMethodBeat.i(250793);
            this.afOS.jEb();
            AppMethodBeat.o(250793);
          }
          
          public final String key()
          {
            AppMethodBeat.i(250797);
            String str = com.tencent.mm.plugin.appbrand.af.p.el(this);
            AppMethodBeat.o(250797);
            return str;
          }
          
          public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
          {
            AppMethodBeat.i(250787);
            this.afOS.jEb();
            AppMethodBeat.o(250787);
          }
        }, str1, com.tencent.mm.modelappbrand.a.g.org);
        parama.I(Boolean.TRUE);
        parama.GGQ = jDK();
        {
          public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(250907);
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
              this.afOS.a(paramAnonymousBoolean, paramAnonymousString, paramAnonymousInt, false);
              AppMethodBeat.o(250907);
              return;
              label54:
              SelectConversationUI.A(SelectConversationUI.this);
            }
          }
        }.show();
        AppMethodBeat.o(180097);
        return true;
        localObject1 = Util.safeFormatString(getResources().getString(R.l.app_fake_native_app), new Object[] { localObject2 });
      }
    }
    parama.bra(getResources().getString(R.l.app_brand_default_name_with_brackets) + str2);
    parama.brb(str1).iLn();
    parama.I(Boolean.TRUE);
    AppMethodBeat.o(180097);
    return false;
  }
  
  private boolean a(o.a parama, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(39377);
    final String str = cq.d(paramHashMap.get("img_url"), null);
    if (!Util.isNullOrNil(str))
    {
      paramHashMap = new RelativeLayout(this);
      View localView = LayoutInflater.from(this).inflate(R.i.confirm_dialog_image_center, null);
      paramHashMap.addView(localView, new RelativeLayout.LayoutParams(-2, -2));
      ((RelativeLayout.LayoutParams)localView.getLayoutParams()).addRule(14);
      final ImageView localImageView = (ImageView)localView.findViewById(R.h.mm_alert_msg_icon);
      ((ImageView)localView.findViewById(R.h.image_status_icon)).setImageResource(R.k.video_icon_in_gird);
      parama.kL(paramHashMap);
      parama.iLo();
      com.tencent.mm.modelappbrand.a.b.bEY().a(new b.k()
      {
        public final void bFg() {}
        
        public final void bFh()
        {
          AppMethodBeat.i(250861);
          Log.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, image load fail:%", new Object[] { str });
          AppMethodBeat.o(250861);
        }
        
        public final String key()
        {
          return "SelectConversationUI#WEISHITHUMB";
        }
        
        public final void onBitmapLoaded(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(250855);
          if ((!SelectConversationUI.this.isFinishing()) && (paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled()) && (localImageView != null))
          {
            paramAnonymousBitmap = ba.b(SelectConversationUI.a(SelectConversationUI.this, paramAnonymousBitmap, localImageView, paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight()), bd.fromDPToPix(SelectConversationUI.this, 3));
            localImageView.setImageBitmap(paramAnonymousBitmap);
          }
          AppMethodBeat.o(250855);
        }
      }, str, null, null);
    }
    for (;;)
    {
      parama.I(Boolean.TRUE);
      AppMethodBeat.o(39377);
      return false;
      paramHashMap = cq.d(paramHashMap.get("msg_img_path"), null);
      if (!Util.isNullOrNil(paramHashMap))
      {
        Log.i("Weishi", "dealRetransmitFromWeishiVideoMiniProgram, imageUrl:%s, msgImgPath:%s", new Object[] { str, paramHashMap });
        parama.m(bDm(paramHashMap), 2);
      }
    }
  }
  
  private String aEi(int paramInt)
  {
    AppMethodBeat.i(251016);
    Object localObject;
    if (paramInt == 1) {
      localObject = this.afOl;
    }
    while (!Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(251016);
      return localObject;
      if (paramInt == 2)
      {
        localObject = this.afOm;
      }
      else
      {
        Log.e("MicroMsg.SelectConversationUI", "getMsgType: Parameter flag error ");
        AppMethodBeat.o(251016);
        return "0";
      }
    }
    if (!Util.isNullOrNil(this.afOk))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.afOk.iterator();
      if (localIterator.hasNext())
      {
        localObject = (cc)localIterator.next();
        if (localObject != null) {
          if (paramInt == 1) {
            localObject = String.valueOf(((cc)localObject).getType());
          }
        }
        for (;;)
        {
          localStringBuilder.append((String)localObject).append("｜");
          break;
          localObject = com.tencent.mm.message.k.b.Hf(((fi)localObject).field_content);
          if (localObject != null)
          {
            localObject = String.valueOf(((com.tencent.mm.message.k.b)localObject).type);
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
      this.afOl = ((String)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(251016);
      return localObject;
      if (this.hTm != null) {
        if (paramInt == 1) {
          localObject = String.valueOf(this.hTm.getType());
        }
      }
      for (;;)
      {
        localObject = String.valueOf(localObject);
        break;
        localObject = com.tencent.mm.message.k.b.Hf(this.hTm.field_content);
        if (localObject != null)
        {
          localObject = String.valueOf(((com.tencent.mm.message.k.b)localObject).type);
        }
        else
        {
          localObject = "0";
          continue;
          localObject = "0";
        }
      }
      label290:
      this.afOm = ((String)localObject);
    }
    label298:
    AppMethodBeat.o(251016);
    return "0";
  }
  
  private void aNr()
  {
    AppMethodBeat.i(39393);
    if (!jDw())
    {
      AppMethodBeat.o(39393);
      return;
    }
    if ((this.afOg != null) && (this.afOg.size() > 0))
    {
      updateOptionMenuText(1, jDK() + "(" + this.afOg.size() + ")");
      updateOptionMenuStyle(1, y.b.adEJ);
      updateOptionMenuListener(1, this.afOA, null);
      enableOptionMenu(1, true);
      AppMethodBeat.o(39393);
      return;
    }
    if (!this.afOf)
    {
      updateOptionMenuText(1, getString(R.l.app_multi_selected));
      updateOptionMenuStyle(1, y.b.adFa);
      updateOptionMenuListener(1, this.afOz, null);
      enableOptionMenu(1, true);
      if (this.KOt != null) {
        this.KOt.setVisibility(8);
      }
      jyG();
      AppMethodBeat.o(39393);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_single_selected));
    updateOptionMenuStyle(1, y.b.adFa);
    updateOptionMenuListener(1, this.afOz, null);
    enableOptionMenu(1, true);
    if (this.KOt != null) {
      this.KOt.setVisibility(0);
    }
    jyH();
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
    Object localObject2;
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
    case 31: 
    case 30: 
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
                parama.bra(this.hWn);
                parama.iLm();
                AppMethodBeat.o(180099);
                return;
                localObject1 = jDQ();
                paramString = (String)localObject1;
                if (localObject1 == null)
                {
                  paramString = (String)localObject1;
                  if (this.imagePath != null)
                  {
                    float f = com.tencent.mm.cd.a.getDensity(MMApplicationContext.getContext());
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
                parama.m(jDP(), 2);
                AppMethodBeat.o(180099);
                return;
                parama.m(jDP(), 2);
                AppMethodBeat.o(180099);
                return;
                parama.bra(jDO());
                AppMethodBeat.o(180099);
                return;
                if (!Util.isNullOrNil(this.emojiMD5))
                {
                  parama.brc(this.emojiMD5);
                  AppMethodBeat.o(180099);
                  return;
                }
                if (!Util.isNullOrNil(this.hTm.field_imgPath))
                {
                  parama.brc(this.hTm.field_imgPath);
                  AppMethodBeat.o(180099);
                  return;
                }
                parama.brc(this.imagePath);
                AppMethodBeat.o(180099);
                return;
                bh.bCz();
                paramString = com.tencent.mm.model.c.bzD().aLU(this.hWn);
                this.afOb = paramString.hgk;
                this.afOc = paramString.nickname;
                this.afOd = Boolean.valueOf(com.tencent.mm.model.ab.uY(paramString.WAW));
                a(parama, this.afOb);
                AppMethodBeat.o(180099);
                return;
                paramString = (com.tencent.mm.plugin.finder.api.e)com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn)).aK(com.tencent.mm.plugin.finder.api.e.class);
              } while (paramString == null);
              parama.bra(getString(R.l.app_finder_endorsement) + paramString.title);
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.b)com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn)).aK(com.tencent.mm.plugin.findersdk.a.b.class);
              if (paramString != null) {
                parama.kL(a(paramString));
              }
              parama.iLo();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.h)com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn)).aK(com.tencent.mm.plugin.findersdk.a.h.class);
              if (paramString != null) {
                parama.kL(a(paramString));
              }
              parama.iLo();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.f)com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn)).aK(com.tencent.mm.plugin.findersdk.a.f.class);
              if (paramString != null) {
                parama.kL(a(paramString));
              }
              parama.iLo();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.d)com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn)).aK(com.tencent.mm.plugin.findersdk.a.d.class);
              if (paramString != null) {
                parama.kL(a(paramString));
              }
              parama.iLo();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.j)com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn)).aK(com.tencent.mm.plugin.findersdk.a.j.class);
              if (paramString != null) {
                parama.kL(a(paramString));
              }
              parama.iLo();
              AppMethodBeat.o(180099);
              return;
              paramString = (com.tencent.mm.plugin.findersdk.a.e)com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn)).aK(com.tencent.mm.plugin.findersdk.a.e.class);
            } while (paramString == null);
            parama.bra(getString(R.l.app_finder_namecard) + paramString.nickname);
            AppMethodBeat.o(180099);
            return;
            paramString = (com.tencent.mm.plugin.findersdk.a.i)com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn)).aK(com.tencent.mm.plugin.findersdk.a.i.class);
          } while ((paramString == null) || (paramString.oTZ == null));
          localObject1 = getString(R.l.app_finder);
          if (paramString.oTZ.Auy == 1) {
            paramString = (String)localObject1 + getString(R.l.finder_topic_card_prefix, new Object[] { paramString.oTZ.topic });
          }
          for (;;)
          {
            parama.bra(paramString);
            AppMethodBeat.o(180099);
            return;
            if (paramString.oTZ.Auy == 4) {
              paramString = (String)localObject1 + paramString.oTZ.desc;
            } else {
              paramString = (String)localObject1 + paramString.oTZ.topic;
            }
          }
          paramString = (com.tencent.mm.plugin.findersdk.a.c)com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn)).aK(com.tencent.mm.plugin.findersdk.a.c.class);
        } while ((paramString == null) || (paramString.oTZ.aade == null));
        localObject1 = getString(R.l.app_finder);
        if (paramString.oTZ.Auy == 7)
        {
          localObject1 = new StringBuilder().append((String)localObject1);
          localObject2 = av.GiL;
        }
        for (paramString = av.a(paramString.oTZ.aade);; paramString = (String)localObject1 + paramString.oTZ.topic)
        {
          parama.bra(paramString);
          AppMethodBeat.o(180099);
          return;
        }
        paramString = (com.tencent.mm.plugin.findersdk.a.g)com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn)).aK(com.tencent.mm.plugin.findersdk.a.g.class);
      } while ((paramString == null) || (paramString.oUd == null));
      parama.bra(paramString.oUd.poiName);
      AppMethodBeat.o(180099);
      return;
    case 2: 
    case 10: 
      localObject2 = com.tencent.mm.message.k.b.Hf(Util.processXml(this.hWn));
      if ((this.hTm.iYe()) && (localObject2 == null)) {
        localObject2 = com.tencent.mm.message.k.b.aP(Util.processXml(this.hWn), Util.processXml(this.hWn));
      }
      break;
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        if (this.afOp != null)
        {
          paramString = getResources().getString(R.l.app_video);
          localObject1 = this.afOp;
          parama.bra(paramString + (String)localObject1);
        }
        AppMethodBeat.o(180099);
        return;
      }
      localObject1 = ((com.tencent.mm.message.k.b)localObject2).title;
      Object localObject3;
      if (com.tencent.mm.ui.chatting.o.i(this.hTm, this.aeSs))
      {
        localObject3 = getResources().getString(R.l.app_brand_default_name_with_brackets);
        paramString = (String)localObject1;
        localObject1 = localObject3;
        label1316:
        if (((com.tencent.mm.message.k.b)localObject2).type == 48) {
          localObject1 = getResources().getString(R.l.app_game_recording);
        }
        if (((com.tencent.mm.message.k.b)localObject2).type != 46) {
          break label2432;
        }
        parama.m(jDQ(), 2);
      }
      while ((this.afOf) && (10 == this.msgType) && (this.afOi))
      {
        com.tencent.mm.modelstat.a.c(this.hTm, 8);
        AppMethodBeat.o(180099);
        return;
        if (((com.tencent.mm.message.k.b)localObject2).type == 5)
        {
          localObject3 = getResources().getString(R.l.app_url);
          paramString = (String)localObject1;
          localObject1 = localObject3;
          break label1316;
        }
        if (((com.tencent.mm.message.k.b)localObject2).type == 6)
        {
          localObject3 = getResources().getString(R.l.app_file);
          paramString = (String)localObject1;
          localObject1 = localObject3;
          break label1316;
        }
        if (((com.tencent.mm.message.k.b)localObject2).type == 24)
        {
          localObject1 = getResources().getString(R.l.app_note);
          paramString = u((com.tencent.mm.message.k.b)localObject2);
          break label1316;
        }
        if (((com.tencent.mm.message.k.b)localObject2).type == 19)
        {
          localObject3 = getResources().getString(R.l.app_record);
          paramString = (String)localObject1;
          localObject1 = localObject3;
          break label1316;
        }
        if ((((com.tencent.mm.message.k.b)localObject2).type == 3) || (((com.tencent.mm.message.k.b)localObject2).type == 76))
        {
          localObject3 = (com.tencent.mm.pluginsdk.ui.tools.b)((com.tencent.mm.message.k.b)localObject2).aK(com.tencent.mm.pluginsdk.ui.tools.b.class);
          if (localObject3 != null)
          {
            localObject1 = com.tencent.mm.modelimage.r.bKa().d(this.hTm.field_imgPath, false, true);
            if (!Util.isNullOrNil((String)localObject1))
            {
              paramString = (String)localObject1;
              if (y.ZC((String)localObject1)) {}
            }
            else
            {
              paramString = this.afMD;
            }
            parama.kL(a(paramString, (com.tencent.mm.message.k.b)localObject2, (com.tencent.mm.pluginsdk.ui.tools.b)localObject3));
            parama.iLo();
            AppMethodBeat.o(180099);
            return;
          }
          localObject3 = getResources().getString(R.l.app_music);
          paramString = (String)localObject1;
          localObject1 = localObject3;
          break label1316;
        }
        if (((com.tencent.mm.message.k.b)localObject2).type == 4)
        {
          localObject3 = getResources().getString(R.l.app_video);
          paramString = (String)localObject1;
          localObject1 = localObject3;
          break label1316;
        }
        if (((com.tencent.mm.message.k.b)localObject2).type == 8)
        {
          localObject3 = getResources().getString(R.l.app_emoji_share);
          paramString = (String)localObject1;
          localObject1 = localObject3;
          break label1316;
        }
        if (((com.tencent.mm.message.k.b)localObject2).type == 44)
        {
          if (Util.isNullOrNil(((com.tencent.mm.message.k.b)localObject2).iab))
          {
            localObject3 = getResources().getString(R.l.app_shortvideo);
            paramString = (String)localObject1;
            localObject1 = localObject3;
            break label1316;
          }
          localObject3 = Util.safeFormatString(getResources().getString(R.l.app_fake_native_app), new Object[] { ((com.tencent.mm.message.k.b)localObject2).iab });
          paramString = (String)localObject1;
          localObject1 = localObject3;
          break label1316;
        }
        if ((((com.tencent.mm.message.k.b)localObject2).type == 33) || (((com.tencent.mm.message.k.b)localObject2).type == 36) || (((com.tencent.mm.message.k.b)localObject2).type == 48))
        {
          if ((((com.tencent.mm.message.k.b)localObject2).nTF == 2) || (((com.tencent.mm.message.k.b)localObject2).nTF == 3) || (((com.tencent.mm.message.k.b)localObject2).type == 36) || (((com.tencent.mm.message.k.b)localObject2).type == 48))
          {
            i = ((com.tencent.mm.message.k.b)localObject2).nTK;
            if (((com.tencent.mm.message.k.b)localObject2).gK(false))
            {
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("key_biz", i);
              ((Bundle)localObject1).putString("key_footer_text_default", ((com.tencent.mm.message.k.b)localObject2).iab);
              ((Bundle)localObject1).putString("key_footer_text", ((com.tencent.mm.message.k.b)localObject2).B(getContext(), false));
              ((Bundle)localObject1).putString("key_footer_icon", ((com.tencent.mm.message.k.b)localObject2).nTY);
              localObject3 = (com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class);
              if (paramString != null) {
                break label2344;
              }
            }
            label2344:
            for (boolean bool = false;; bool = com.tencent.mm.model.ab.IL(paramString))
            {
              paramString = ((com.tencent.mm.modelappbrand.k)localObject3).a(this, (Bundle)localObject1, bool, new k.c()
              {
                public final void bEL()
                {
                  AppMethodBeat.i(250852);
                  SelectConversationUI.B(SelectConversationUI.this);
                  g.a(SelectConversationUI.this, null);
                  AppMethodBeat.o(250852);
                }
                
                public final void gU(boolean paramAnonymousBoolean)
                {
                  AppMethodBeat.i(250858);
                  SelectConversationUI.b(SelectConversationUI.this, paramAnonymousBoolean);
                  AppMethodBeat.o(250858);
                }
              });
              parama.kL(paramString);
              parama.I(Boolean.TRUE);
              parama.iLo();
              Object localObject4 = com.tencent.mm.modelimage.r.bKa().d(this.hTm.field_imgPath, false, true);
              localObject1 = com.tencent.mm.plugin.appbrand.af.p.el(this);
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("app_id", ((com.tencent.mm.message.k.b)localObject2).nTE);
              ((Bundle)localObject3).putString("msg_id", String.format("%d-%d", new Object[] { Integer.valueOf(((com.tencent.mm.message.k.b)localObject2).nTW), Integer.valueOf(((com.tencent.mm.message.k.b)localObject2).nTH) }));
              ((Bundle)localObject3).putInt("msg_pkg_type", ((com.tencent.mm.message.k.b)localObject2).nTW);
              ((Bundle)localObject3).putInt("pkg_version", ((com.tencent.mm.message.k.b)localObject2).nTH);
              if (!Util.isNullOrNil((String)localObject4)) {
                ((Bundle)localObject3).putString("image_url", "file://".concat(String.valueOf(localObject4)));
              }
              localObject4 = (com.tencent.mm.message.a)((com.tencent.mm.message.k.b)localObject2).aK(com.tencent.mm.message.a.class);
              if (localObject4 != null)
              {
                ((Bundle)localObject3).putBoolean("is_dynamic_page", ((com.tencent.mm.message.a)localObject4).nOK);
                ((Bundle)localObject3).putString("cache_key", ((com.tencent.mm.message.a)localObject4).nOL);
                ((Bundle)localObject3).putInt("sub_type", ((com.tencent.mm.message.a)localObject4).nPa);
              }
              ((Bundle)localObject3).putString("title", ((com.tencent.mm.message.k.b)localObject2).title);
              ((Bundle)localObject3).putString("msg_path", ((com.tencent.mm.message.k.b)localObject2).nTC);
              ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).a((String)localObject1, paramString, (Bundle)localObject3);
              parama.uBy = new DialogInterface.OnDismissListener()
              {
                public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
                {
                  AppMethodBeat.i(250849);
                  ((com.tencent.mm.modelappbrand.k)com.tencent.mm.kernel.h.ax(com.tencent.mm.modelappbrand.k.class)).b(this.rma, paramString);
                  AppMethodBeat.o(250849);
                }
              };
              AppMethodBeat.o(180099);
              return;
              if (((com.tencent.mm.message.k.b)localObject2).type == 48)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putBoolean("is_video", true);
                ((Bundle)localObject1).putString("key_footer_icon", ((com.tencent.mm.message.k.b)localObject2).nTY);
                ((Bundle)localObject1).putString("key_footer_text", ((com.tencent.mm.message.k.b)localObject2).iab);
                break;
              }
              Log.w("MicroMsg.SelectConversationUI", "fake native share msg biz invalidate, biz: %d.", new Object[] { Integer.valueOf(i) });
              localObject1 = null;
              break;
            }
          }
          localObject3 = getResources().getString(R.l.app_brand_default_name_with_brackets);
          paramString = (String)localObject1;
          localObject1 = localObject3;
          break label1316;
        }
        if ((((com.tencent.mm.message.k.b)localObject2).type == 53) || (((com.tencent.mm.message.k.b)localObject2).type == 57))
        {
          localObject3 = "";
          paramString = (String)localObject1;
          localObject1 = localObject3;
          break label1316;
        }
        localObject3 = getResources().getString(R.l.app_app);
        paramString = (String)localObject1;
        localObject1 = localObject3;
        break label1316;
        label2432:
        if (((com.tencent.mm.message.k.b)localObject2).type == 69)
        {
          paramString = (com.tencent.mm.plugin.game.luggage.f.a)((com.tencent.mm.message.k.b)localObject2).aK(com.tencent.mm.plugin.game.luggage.f.a.class);
          if (paramString != null)
          {
            parama.bra(getResources().getString(R.l.app_game_namecard) + paramString.nickName);
            if (!Util.isNullOrNil(paramString.iconUrl)) {
              parama.brb(paramString.iconUrl).iLn();
            }
          }
        }
        else
        {
          localObject3 = paramString;
          if (paramString == null) {
            localObject3 = "";
          }
          parama.bra((String)localObject1 + (String)localObject3);
          if (((com.tencent.mm.message.k.b)localObject2).thumburl != null) {
            parama.brb(((com.tencent.mm.message.k.b)localObject2).thumburl).iLn();
          }
        }
      }
      paramString = Util.nullAs(n.nk(getContext()).hXu.hXA.title, "");
      parama.bra(getResources().getString(R.l.app_multi_record) + paramString);
      if ((!this.afOf) || (!this.afOi)) {
        break;
      }
      com.tencent.mm.modelstat.a.c(this.hTm, 8);
      AppMethodBeat.o(180099);
      return;
      paramString = n.nk(getContext());
      if ((paramString != null) && (paramString.hXt.hXy != null)) {}
      for (i = paramString.hXt.hXy.size();; i = 0)
      {
        paramString = getContext().getString(R.l.retransmit_msg_count, new Object[] { Integer.valueOf(i) });
        parama.bra(getResources().getString(R.l.app_multi_msg) + paramString);
        AppMethodBeat.o(180099);
        return;
        if (this.wtc == null) {
          break;
        }
        parama.bra(getResources().getString(R.l.app_file) + this.wtc);
        break;
      }
    }
  }
  
  private static boolean bBw(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(251072);
    Object localObject = com.tencent.mm.modelimage.r.bKa().d(paramString, false, true);
    if (!y.ZC((String)localObject))
    {
      AppMethodBeat.o(251072);
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
    AppMethodBeat.o(251072);
    return bool;
  }
  
  private static boolean bDf(String paramString)
  {
    AppMethodBeat.i(39364);
    if (au.bwO(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    if (au.bwF(paramString))
    {
      AppMethodBeat.o(39364);
      return true;
    }
    AppMethodBeat.o(39364);
    return false;
  }
  
  private void bDh(String paramString)
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
      com.tencent.mm.ui.base.k.d(this, getString(R.l.gVZ, new Object[] { paramString }), "", null);
      return;
    }
    finally
    {
      AppMethodBeat.o(39366);
    }
  }
  
  private boolean bDi(String paramString)
  {
    AppMethodBeat.i(250946);
    if ("conversationboxservice".equals(paramString))
    {
      paramString = new Intent(this, ConvBoxTransmitUI.class);
      paramString.putExtras(getIntent().getExtras());
      paramString.putExtra("KIsMultiSelect", this.afOf);
      paramString.putExtra("Select_Conv_User", Util.listToString(this.afOg, ","));
      startActivityForResult(paramString, 7);
      com.tencent.mm.ui.base.b.aR(getContext(), paramString);
      AppMethodBeat.o(250946);
      return true;
    }
    AppMethodBeat.o(250946);
    return false;
  }
  
  private void bDj(String paramString)
  {
    AppMethodBeat.i(39367);
    Log.i("MicroMsg.SelectConversationUI", "doChooseMsgFile userName:%s type:%s count:%d ", new Object[] { paramString, this.afOt, Integer.valueOf(this.afOu) });
    Log.i("MicroMsg.SelectConversationUI", "doChooseMsgFile extension:%s ", new Object[] { this.afOv });
    ((com.tencent.mm.choosemsgfile.compat.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.choosemsgfile.compat.a.class)).a(this, paramString, this.afOt, this.afOu, this.afOv, new a.a()
    {
      public final void a(int paramAnonymousInt, String paramAnonymousString, ArrayList<MsgFile> paramAnonymousArrayList)
      {
        AppMethodBeat.i(250791);
        Log.i("MicroMsg.SelectConversationUI", "resultCode:%d filePaths:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousArrayList });
        switch (paramAnonymousInt)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(250791);
          return;
          paramAnonymousString = new Intent();
          paramAnonymousString.putParcelableArrayListExtra("FILEPATHS", paramAnonymousArrayList);
          SelectConversationUI.this.setResult(-1, paramAnonymousString);
          SelectConversationUI.this.finish();
          AppMethodBeat.o(250791);
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
  
  private String bDk(String paramString)
  {
    int j = 0;
    AppMethodBeat.i(39372);
    bh.bCz();
    au localau = com.tencent.mm.model.c.bzA().bxu(paramString);
    Object localObject = getResources().getString(R.l.app_friend_card_personal);
    if (localau == null)
    {
      AppMethodBeat.o(39372);
      return localObject;
    }
    bh.bCz();
    localObject = com.tencent.mm.model.c.bzD().aLU(this.hWn);
    int i = j;
    if (localObject != null) {
      if (!com.tencent.mm.model.ab.uY(((cc.a)localObject).WAW))
      {
        i = j;
        if (!localau.iZC()) {}
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
      if (au.bwO(paramString)) {
        paramString = c(this, localau);
      } else if (au.bwQ(paramString)) {
        paramString = getResources().getString(R.l.app_friend_card_kefu);
      } else {
        paramString = getResources().getString(R.l.app_friend_card_personal);
      }
    }
  }
  
  private void bDl(String paramString)
  {
    AppMethodBeat.i(251013);
    Log.i("MicroMsg.SelectConversationUI", "resetData: recent forward control switch on");
    if (!Util.isNullOrNil(paramString))
    {
      if (com.tencent.mm.ui.contact.h.jyv()) {
        com.tencent.mm.ui.contact.h.bBN(paramString);
      }
      jh(paramString, this.afOn);
      jDM();
      AppMethodBeat.o(251013);
      return;
    }
    Log.e("MicroMsg.SelectConversationUI", "reportAndStorageRecentForward:  userName is empty ");
    AppMethodBeat.o(251013);
  }
  
  private static Bitmap bDm(String paramString)
  {
    AppMethodBeat.i(39383);
    localBitmap2 = com.tencent.mm.modelimage.r.bKa().Oa(paramString);
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
    finally
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
  
  private static int bzr(String paramString)
  {
    AppMethodBeat.i(250999);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(250999);
      return 0;
    }
    int i;
    if (com.tencent.mm.model.z.Iy(paramString)) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(250999);
      return i;
      if (au.bws(paramString)) {
        i = 2;
      } else if (au.bwE(paramString)) {
        i = 4;
      } else {
        i = 3;
      }
    }
  }
  
  public static String c(Context paramContext, au paramau)
  {
    AppMethodBeat.i(39373);
    paramau = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).a(paramau.field_openImAppid, "openim_card_type_name", com.tencent.mm.openim.api.e.a.prb);
    if (TextUtils.isEmpty(paramau)) {}
    for (paramContext = paramContext.getResources().getString(R.l.app_friend_card_personal);; paramContext = String.format("[%s]", new Object[] { paramau }))
    {
      AppMethodBeat.o(39373);
      return paramContext;
    }
  }
  
  private void d(Intent paramIntent1, Intent paramIntent2)
  {
    AppMethodBeat.i(39374);
    Log.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=".concat(String.valueOf(paramIntent2)));
    paramIntent2.putExtras(paramIntent1.getExtras());
    startActivityForResult(paramIntent2, 2);
    com.tencent.mm.ui.base.b.aR(getContext(), paramIntent2);
    AppMethodBeat.o(39374);
  }
  
  private int fJx()
  {
    if (this.fromScene == 17) {
      return 1;
    }
    if (this.afOi) {
      return 2;
    }
    if (this.afNQ) {
      return 3;
    }
    if (this.fromScene == 3) {
      return 4;
    }
    if (this.fromScene == 14) {
      return 5;
    }
    if ((this.fromScene == 1) || (this.afNP)) {
      return 6;
    }
    if (this.fromScene == 15) {
      return 7;
    }
    if ((this.fromScene == 16) || (this.afhx) || (this.afNZ)) {
      return 8;
    }
    if ((this.AnG) || (this.afNS)) {
      return 9;
    }
    return 0;
  }
  
  private void fzD()
  {
    AppMethodBeat.i(250941);
    String str;
    if (this.afOf) {
      str = getString(R.l.select_contact_from_contact);
    }
    for (int i = R.k.icons_filled_contacts;; i = R.k.icons_filled_add)
    {
      if (this.afNN != null) {
        this.afNN.setText(str);
      }
      if (this.afNM != null) {
        this.afNM.setImageResource(i);
      }
      AppMethodBeat.o(250941);
      return;
      str = getString(R.l.select_contact_conversation_create);
    }
  }
  
  private boolean jDJ()
  {
    AppMethodBeat.i(250949);
    long l1 = SystemClock.elapsedRealtime();
    long l2 = l1 - this.afOa;
    if ((l2 > 40L) && (l2 < 300L))
    {
      this.afOa = l1;
      AppMethodBeat.o(250949);
      return false;
    }
    this.afOa = l1;
    AppMethodBeat.o(250949);
    return true;
  }
  
  private String jDK()
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
  
  private void jDL()
  {
    AppMethodBeat.i(251004);
    Log.i("MicroMsg.SelectConversationUI", "resetData: recent forward control switch on");
    int j;
    String str;
    if (!Util.isNullOrNil(this.afOg))
    {
      j = 0;
      if (j >= this.afOg.size()) {
        break label161;
      }
      str = (String)this.afOg.get(j);
      if ((this.afOh == null) || (this.afOh.size() <= 0) || (!this.afOh.containsKey(str))) {
        break label172;
      }
    }
    label161:
    label172:
    for (int i = ((Integer)this.afOh.get(str)).intValue();; i = 0)
    {
      int k = i;
      if (i == 0) {
        k = -2;
      }
      jh(str, k);
      if ((com.tencent.mm.ui.contact.h.jyv()) && (j < 5)) {
        com.tencent.mm.ui.contact.h.bBN(str);
      }
      j += 1;
      break;
      Log.e("MicroMsg.SelectConversationUI", "reportAndStorageRecentForward:  mSelectedUserSet is empty ");
      AppMethodBeat.o(251004);
      return;
      jDM();
      AppMethodBeat.o(251004);
      return;
    }
  }
  
  private void jDM()
  {
    AppMethodBeat.i(251009);
    if (!Util.isNullOrNil(this.afOl)) {
      this.afOl = null;
    }
    if (!Util.isNullOrNil(this.afOm)) {
      this.afOm = null;
    }
    AppMethodBeat.o(251009);
  }
  
  private static int jDN()
  {
    int i = 1;
    AppMethodBeat.i(251027);
    if (com.tencent.mm.ui.contact.h.jyu() == 0) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(251027);
      return i;
      if (com.tencent.mm.ui.contact.h.jyw()) {
        i = 2;
      } else if (com.tencent.mm.ui.contact.h.jyu() != 1) {
        i = -1;
      }
    }
  }
  
  private String jDO()
  {
    AppMethodBeat.i(39380);
    bh.bCz();
    cc.c localc = com.tencent.mm.model.c.bzD().aLV(this.hWn);
    String str = "";
    if (localc != null) {
      str = localc.label;
    }
    str = getContext().getString(R.l.app_location) + str;
    AppMethodBeat.o(39380);
    return str;
  }
  
  private Bitmap jDP()
  {
    AppMethodBeat.i(39381);
    com.tencent.mm.modelvideo.v.bOh();
    Object localObject = com.tencent.mm.modelvideo.aa.PY(this.hTm.field_imgPath);
    if (localObject == null)
    {
      localObject = this.imagePath;
      if (com.tencent.mm.plugin.a.c.Sm(this.imagePath))
      {
        localObject = com.tencent.mm.plugin.mmsight.d.Pf((String)localObject);
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
  
  private Bitmap jDQ()
  {
    AppMethodBeat.i(39382);
    if (this.hTm == null)
    {
      AppMethodBeat.o(39382);
      return null;
    }
    String str = this.hTm.field_imgPath;
    localBitmap3 = com.tencent.mm.modelimage.r.bKa().Oa(str);
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
    finally
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
  
  private void jDR()
  {
    boolean bool = true;
    AppMethodBeat.i(39386);
    Log.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
    Intent localIntent;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpV, b.a.agrU, 0) == 1)
    {
      localIntent = new Intent(this, MvvmSelectContactUI.class);
      localIntent.putExtra("list_type", 14);
      localIntent.putExtra("titile", getString(R.l.address_title_select_contact));
      localIntent.putExtra("list_attr", w.affv);
      localIntent.putExtra("already_select_contact", Util.listToString(this.afOg, ","));
      localIntent.putExtra("max_limit_num", 9);
      if ((!this.afhx) || (!au.bwO(this.afOb))) {
        break label175;
      }
    }
    for (;;)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 5);
      AppMethodBeat.o(39386);
      return;
      localIntent = new Intent(this, SelectContactUI.class);
      break;
      label175:
      bool = false;
    }
  }
  
  private void jDS()
  {
    boolean bool = true;
    AppMethodBeat.i(39387);
    Log.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_attr", w.affs);
    localIntent.putExtra("list_type", 3);
    localIntent.putExtra("be_send_card_name", this.afOb);
    localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
    localIntent.putExtra("Add_SendCard", true);
    localIntent.putExtra("titile", getString(R.l.address_title_select_contact));
    if ((this.afhx) && (au.bwO(this.afOb))) {}
    for (;;)
    {
      localIntent.putExtra("Forbid_SelectChatRoom", bool);
      getContext().startActivityForResult(localIntent, 3);
      AppMethodBeat.o(39387);
      return;
      bool = false;
    }
  }
  
  private void jDT()
  {
    AppMethodBeat.i(39388);
    Log.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
    Intent localIntent = new Intent(this, SelectContactUI.class);
    localIntent.putExtra("list_type", 5);
    localIntent.putExtra("titile", getString(R.l.address_title_select_contact));
    if (((this.fromScene != 4) && (this.fromScene != 9)) || ((getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || (this.fromScene == 10)))
    {
      localIntent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
      localIntent.putExtra("list_attr", w.R(new int[] { 32, 16, 1, 2, 4, 16384 }));
    }
    for (;;)
    {
      getContext().startActivityForResult(localIntent, 1);
      AppMethodBeat.o(39388);
      return;
      if ((this.afNZ) && (!this.afOd.booleanValue()))
      {
        localIntent.putExtra("list_attr", w.R(new int[] { 16, 1, 2, 4, 16384 }));
        localIntent.putExtra("without_openim", true);
        localIntent.putExtra("KBlockOpenImFav", true);
      }
      else if (this.afNU)
      {
        localIntent.putExtra("list_attr", w.R(new int[] { w.affn, 16384, 64, 4096 }));
        localIntent.putExtra("without_openim", true);
        localIntent.putExtra("KBlockOpenImFav", true);
      }
      else
      {
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpV, b.a.agrU, 0) == 1) {
          localIntent.setClass(this, MvvmSelectContactUI.class);
        }
        localIntent.putExtra("list_attr", w.affu);
      }
    }
  }
  
  private void jh(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(251022);
    if ((com.tencent.mm.ui.contact.h.jyw()) && (this.afOq != null)) {}
    for (Object localObject = this.afOq; localObject == null; localObject = this.afOr)
    {
      AppMethodBeat.o(251022);
      return;
    }
    long l1 = com.tencent.mm.model.cn.bDu();
    long l2 = this.startTime;
    final int j = bzr(paramString);
    final String str1 = aEi(1);
    final int k = fJx();
    final int m = ((com.tencent.mm.ui.contact.af)localObject).bBQ(paramString);
    final int n = ((com.tencent.mm.ui.contact.af)localObject).bBR(paramString);
    final int i1 = a(paramString, paramInt, (com.tencent.mm.ui.contact.af)localObject);
    if (Util.isNullOrNil(this.afOg))
    {
      paramInt = 0;
      if (this.fromScene != 13) {
        break label218;
      }
    }
    label218:
    for (final int i = 1;; i = 0)
    {
      final int i2 = ((com.tencent.mm.ui.contact.af)localObject).jzc();
      final int i3 = jDN();
      String str2 = ((com.tencent.mm.ui.contact.af)localObject).jze();
      final int i4 = ((com.tencent.mm.ui.contact.af)localObject).jzf();
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(250816);
          String str = SelectConversationUI.y(SelectConversationUI.this);
          m.a(str1, j, m, n, i, paramInt, k, i1, paramString, str, i2, this.IAg, i4, i3, this.afOO);
          SelectConversationUI.z(SelectConversationUI.this);
          AppMethodBeat.o(250816);
        }
      });
      AppMethodBeat.o(251022);
      return;
      paramInt = 1;
      break;
    }
  }
  
  private void ji(String paramString, int paramInt)
  {
    AppMethodBeat.i(251091);
    iKA();
    MultiSelectContactView localMultiSelectContactView = this.KOt;
    if (localMultiSelectContactView != null) {
      localMultiSelectContactView.bqG(paramString);
    }
    if (this.afOg.contains(paramString))
    {
      this.afOg.remove(paramString);
      if (this.afOh.containsKey(paramString))
      {
        this.afOh.remove(paramString);
        AppMethodBeat.o(251091);
      }
    }
    else
    {
      this.afOg.add(paramString);
      this.afOh.put(paramString, Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(251091);
  }
  
  private void op(List<String> paramList)
  {
    AppMethodBeat.i(250938);
    if (this.afOq != null)
    {
      Object localObject1 = this.afOq;
      if (((com.tencent.mm.ui.contact.z)localObject1).afgw != null)
      {
        localObject1 = ((com.tencent.mm.ui.contact.z)localObject1).afgw;
        Object localObject2 = ((com.tencent.mm.ui.contact.a.o)localObject1).pUj;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            com.tencent.mm.ui.contact.ah localah = (com.tencent.mm.ui.contact.ah)((Iterator)localObject2).next();
            localah.afhj.isSelected = false;
            if (paramList != null)
            {
              Iterator localIterator = ((Iterable)paramList).iterator();
              while (localIterator.hasNext())
              {
                String str = (String)localIterator.next();
                if (kotlin.g.b.s.p(localah.afhj.afhk, str)) {
                  localah.afhj.isSelected = true;
                }
              }
            }
          }
        }
        paramList = ((com.tencent.mm.ui.contact.a.o)localObject1).ALE;
        if (paramList != null) {
          paramList.bZE.notifyChanged();
        }
      }
    }
    AppMethodBeat.o(250938);
  }
  
  private static String u(com.tencent.mm.message.k.b paramb)
  {
    AppMethodBeat.i(39385);
    Object localObject1 = new tr();
    ((tr)localObject1).hXt.type = 0;
    ((tr)localObject1).hXt.hXv = paramb.nRF;
    ((tr)localObject1).publish();
    com.tencent.mm.protocal.b.a.c localc = ((tr)localObject1).hXu.hXD;
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localc != null)
    {
      localObject1 = localObject2;
      if (paramb != null) {
        localObject1 = Util.nullAs(localc.desc, paramb.description);
      }
    }
    paramb = (com.tencent.mm.message.k.b)localObject1;
    if (!Util.isNullOrNil((String)localObject1)) {
      paramb = ((String)localObject1).replaceAll("\n", " ");
    }
    AppMethodBeat.o(39385);
    return paramb;
  }
  
  private void v(int paramInt, Intent paramIntent)
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
    Object localObject1;
    Object localObject2;
    String str;
    if ((this.msgType == 30) && (localIntent != null))
    {
      paramIntent = localIntent.getStringExtra("Select_Conv_User");
      localObject1 = com.tencent.mm.plugin.finder.utils.ah.Ghp;
      if (com.tencent.mm.plugin.finder.utils.ah.ffh() != null)
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.ah.Ghp;
        localObject1 = com.tencent.mm.plugin.finder.utils.ah.ffh();
        localObject2 = com.tencent.mm.plugin.finder.utils.ah.Ghp;
        localObject2 = com.tencent.mm.plugin.finder.utils.ah.Ghp;
        localObject2 = com.tencent.mm.plugin.finder.utils.ah.ffh().productId;
        str = Util.nullAsNil(paramIntent);
        if (!au.bwE(paramIntent)) {
          break label167;
        }
      }
    }
    label167:
    for (paramIntent = "group";; paramIntent = "chat")
    {
      com.tencent.mm.plugin.finder.utils.ah.a((bth)localObject1, "share_commodity_success", com.tencent.mm.plugin.finder.utils.ah.b((String)localObject2, str, paramIntent, null));
      super.setResult(paramInt, localIntent);
      AppMethodBeat.o(39396);
      return;
    }
  }
  
  private void v(final Intent paramIntent, final String paramString)
  {
    AppMethodBeat.i(39375);
    if (bDg(paramString))
    {
      AppMethodBeat.o(39375);
      return;
    }
    if (w.hasAttr(this.selectType, 256))
    {
      v(-1, paramIntent);
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
    if (au.bwE(paramString))
    {
      i = com.tencent.mm.model.v.getMembersCountByChatRoomName(paramString);
      if (this.afNY)
      {
        int j = Util.getInt(com.tencent.mm.k.i.aRC().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50);
        if (i > j)
        {
          Log.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
          com.tencent.mm.ui.base.k.c(this, getString(R.l.gUA, new Object[] { Integer.valueOf(j) }), "", true);
          AppMethodBeat.o(39375);
          return;
        }
      }
      getString(R.l.gUy, new Object[] { Integer.valueOf(i) });
    }
    o.a locala = new o.a(getContext());
    locala.gA(paramString);
    if (this.afhx)
    {
      a(locala, this.afOb);
      if (au.bwE(paramString)) {
        b(paramIntent, this.afOb, paramString);
      }
      for (;;)
      {
        locala.I(Boolean.TRUE);
        locala.GGQ = jDK();
        {
          public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
          {
            int i = 1;
            AppMethodBeat.i(39327);
            SelectConversationUI.this.hideVKB();
            boolean bool = paramIntent.getBooleanExtra("need_delete_chatroom_when_cancel", false);
            if (bool)
            {
              if (paramAnonymousBoolean)
              {
                paramAnonymousInt = 1;
                Log.i("MicroMsg.SelectContactReportLogic", "reportCreateChatroomOperation %d %d", new Object[] { Integer.valueOf(13943), Integer.valueOf(paramAnonymousInt) });
                com.tencent.mm.plugin.report.service.h.OAn.b(13943, new Object[] { Integer.valueOf(paramAnonymousInt) });
              }
            }
            else
            {
              if (!paramAnonymousBoolean) {
                break label278;
              }
              paramIntent.putExtra("custom_send_text", paramAnonymousString);
              paramIntent.putExtra("KSendGroupToDo", SelectConversationUI.v(SelectConversationUI.this));
              paramIntent.putExtra("KShowTodoIntroduceView", SelectConversationUI.w(SelectConversationUI.this));
              SelectConversationUI.a(SelectConversationUI.this, -1, paramIntent);
              com.tencent.mm.pluginsdk.ui.tools.r.a(SelectConversationUI.n(SelectConversationUI.this), SelectConversationUI.x(SelectConversationUI.this), paramString);
              if ((!SelectConversationUI.this.afOf) && (SelectConversationUI.m(SelectConversationUI.this))) {
                com.tencent.mm.modelstat.a.c(SelectConversationUI.n(SelectConversationUI.this), 5);
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
              SelectConversationUI.b(paramAnonymousString, str, paramAnonymousInt);
              AppMethodBeat.o(39327);
              return;
              paramAnonymousInt = 0;
              break;
              label278:
              if (bool)
              {
                paramAnonymousString = paramIntent.getStringExtra("Select_Contact");
                bh.bCz();
                com.tencent.mm.model.c.bzG().bxK(paramAnonymousString);
              }
              if ((!SelectConversationUI.this.afOf) && (SelectConversationUI.m(SelectConversationUI.this))) {
                com.tencent.mm.modelstat.a.c(SelectConversationUI.n(SelectConversationUI.this), 6);
              }
            }
          }
        }.show();
        AppMethodBeat.o(39375);
        return;
        a(paramIntent, this.afOb, paramString);
      }
    }
    Object localObject;
    if (this.afNP)
    {
      if ((getIntent().hasExtra("appbrand_params")) && (a(paramIntent, locala, null)))
      {
        AppMethodBeat.o(39375);
        return;
      }
      if (this.hDn != -1L)
      {
        a(locala);
        localObject = new hp();
        ((hp)localObject).hIF.hDn = this.hDn;
        ((hp)localObject).hIF.hIG = this.hIG;
        ((hp)localObject).hIF.hIH = this.msgType;
        ((hp)localObject).hIF.hII = locala;
        ((hp)localObject).hIF.hIJ = this.afOs;
        ((hp)localObject).hIF.hAh = getContext();
        ((hp)localObject).publish();
      }
      for (;;)
      {
        locala.I(Boolean.TRUE);
        break;
        if ((this.msgType == 17) && (this.afNX != 0))
        {
          localObject = getContext().getString(R.l.retransmit_msg_count, new Object[] { Integer.valueOf(this.afNX) });
          locala.bra(getResources().getString(R.l.app_multi_msg) + (String)localObject);
        }
      }
    }
    String str1;
    String str3;
    final String str2;
    if ((this.afNQ) && (!this.AnG))
    {
      localObject = (HashMap)getIntent().getSerializableExtra("webview_params");
      str1 = (String)((HashMap)localObject).get("img_url");
      str3 = (String)((HashMap)localObject).get("title");
      str2 = (String)((HashMap)localObject).get("url");
      if (!((HashMap)localObject).containsKey("item_show_type")) {
        break label952;
      }
    }
    label651:
    label952:
    for (int i = Util.getInt((String)((HashMap)localObject).get("item_show_type"), -1);; i = -1)
    {
      if (!this.afNV) {
        if (this.msgType == 4) {
          localObject = "";
        }
      }
      for (localObject = (String)localObject + str3;; localObject = getResources().getString(R.l.app_game_namecard) + (String)localObject)
      {
        locala.bra((String)localObject);
        locala.a(new e.a.b()
        {
          public final void dTb()
          {
            AppMethodBeat.i(250796);
            if (SelectConversationUI.u(SelectConversationUI.this) == 4)
            {
              AppMethodBeat.o(250796);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", str2);
            localIntent.putExtra("hide_option_menu", true);
            com.tencent.mm.br.c.b(SelectConversationUI.this.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(250796);
          }
        });
        locala.brb(str1).iLn();
        locala.I(Boolean.TRUE);
        break;
        if (i == 16)
        {
          localObject = getResources().getString(R.l.app_video);
          break label651;
        }
        localObject = getResources().getString(R.l.app_url);
        break label651;
        localObject = (String)((HashMap)localObject).get("nickname");
      }
      if ((this.afNR) && (a(paramIntent, locala, paramString)))
      {
        AppMethodBeat.o(39375);
        return;
      }
      if (this.afNT)
      {
        str1 = getResources().getString(R.l.app_golden_lucky);
        localObject = str1;
        if (this.wtc != null) {
          localObject = str1 + this.wtc;
        }
        locala.bra((String)localObject);
        locala.I(Boolean.FALSE);
        break;
      }
      if (this.afNU)
      {
        locala.bra(getResources().getString(R.l.app_red_cover_gift));
        locala.I(Boolean.FALSE);
        break;
      }
      b(locala, paramString);
      a(locala);
      locala.I(Boolean.TRUE);
      break;
    }
  }
  
  public void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(251166);
    Object localObject;
    if (this.afOf)
    {
      i = paramInt - getContentLV().getHeaderViewsCount();
      if (i < 0)
      {
        Log.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
        jDR();
        AppMethodBeat.o(251166);
        return;
      }
      paramAdapterView = jyE();
      paramView = paramAdapterView.aDt(i);
      if (paramView == null)
      {
        AppMethodBeat.o(251166);
        return;
      }
      if (paramView.contact == null)
      {
        AppMethodBeat.o(251166);
        return;
      }
      paramView = paramView.contact.field_username;
      Log.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[] { paramView });
      if (bDi(paramView))
      {
        AppMethodBeat.o(251166);
        return;
      }
      if ((!this.afOg.contains(paramView)) && (Nd(true)))
      {
        iKA();
        AppMethodBeat.o(251166);
        return;
      }
      ji(paramView, paramInt);
      aNr();
      if ((com.tencent.mm.ui.contact.h.jyw()) && (this.afOq != null))
      {
        localObject = this.afOq;
        if (((com.tencent.mm.ui.contact.z)localObject).afgw != null)
        {
          localObject = ((com.tencent.mm.ui.contact.z)localObject).afgw;
          kotlin.g.b.s.u(paramView, "userName");
          localObject = ((com.tencent.mm.ui.contact.a.o)localObject).pUj;
          if (localObject != null)
          {
            localObject = ((Iterable)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              com.tencent.mm.ui.contact.ah localah = (com.tencent.mm.ui.contact.ah)((Iterator)localObject).next();
              if (kotlin.g.b.s.p(localah.afhj.afhk, paramView))
              {
                ai localai = localah.afhj;
                if (!localah.afhj.isSelected) {}
                for (boolean bool = true;; bool = false)
                {
                  localai.isSelected = bool;
                  break;
                }
              }
            }
          }
        }
      }
      paramAdapterView.notifyDataSetChanged();
      AppMethodBeat.o(251166);
      return;
    }
    if (paramInt < getContentLV().getHeaderViewsCount())
    {
      Log.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[] { Integer.valueOf(paramInt) });
      if (this.afhx)
      {
        jDS();
        AppMethodBeat.o(251166);
        return;
      }
      jDT();
    }
    for (;;)
    {
      if (this.afOi) {
        com.tencent.mm.modelstat.a.c(this.hTm, 4);
      }
      AppMethodBeat.o(251166);
      return;
      paramAdapterView = (com.tencent.mm.ui.contact.a.a)getContentLV().getAdapter().getItem(paramInt);
      if (paramAdapterView == null)
      {
        AppMethodBeat.o(251166);
        return;
      }
      if (((paramAdapterView instanceof com.tencent.mm.ui.contact.a.b)) && (((com.tencent.mm.ui.contact.a.b)paramAdapterView).nickName == getResources().getString(R.l.address_official_accounts_title)))
      {
        Log.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("list_attr", 16384);
        com.tencent.mm.br.c.b(this, "brandservice", ".ui.BrandServiceIndexUI", paramAdapterView, 4);
        this.afNQ = true;
        AppMethodBeat.o(251166);
        return;
      }
      if ((paramAdapterView instanceof com.tencent.mm.ui.contact.a.h))
      {
        localObject = (com.tencent.mm.ui.contact.a.h)paramAdapterView;
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("scene", this.scene);
        paramView = new ArrayList();
        localObject = ((com.tencent.mm.ui.contact.a.a)localObject).FWt.Htg;
        int j = localObject.length;
        paramInt = i;
        while (paramInt < j)
        {
          paramView.add(localObject[paramInt]);
          paramInt += 1;
        }
        paramAdapterView.putExtra("query_phrase_list", paramView);
        com.tencent.mm.br.c.d(this, ".ui.transmit.MMCreateChatroomUI", paramAdapterView, 1);
        AppMethodBeat.o(251166);
        return;
      }
      paramAdapterView = paramAdapterView.contact;
      if (paramAdapterView == null)
      {
        AppMethodBeat.o(251166);
        return;
      }
      this.afOn = paramInt;
      aUj(paramAdapterView.field_username);
    }
  }
  
  public void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(39359);
    super.a(paramListView, paramInt);
    if (this.fromScene == 11)
    {
      AppMethodBeat.o(39359);
      return;
    }
    if (com.tencent.mm.ui.contact.h.jyw())
    {
      AppMethodBeat.o(39359);
      return;
    }
    if (this.aecz == null)
    {
      if (!this.afhx) {
        break label147;
      }
      this.afNI = R.l.gUK;
    }
    for (;;)
    {
      Object localObject = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(250842);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/transmit/SelectConversationUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (SelectConversationUI.this.afOf) {
            SelectConversationUI.o(SelectConversationUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250842);
            return;
            paramAnonymousView = SelectConversationUI.this.getIntent().getStringExtra("Select_App_Id");
            if ((SelectConversationUI.q(SelectConversationUI.this)) && (Util.isNullOrNil(paramAnonymousView))) {
              SelectConversationUI.r(SelectConversationUI.this);
            } else {
              SelectConversationUI.p(SelectConversationUI.this);
            }
          }
        }
      };
      String str = getString(this.afNI);
      View localView = com.tencent.mm.ui.af.mU(this).inflate(R.i.gkq, null);
      localView.setOnClickListener((View.OnClickListener)localObject);
      localObject = (TextView)localView.findViewById(R.h.content_tv);
      ((TextView)localObject).setText(str);
      paramListView.addHeaderView(localView);
      this.aecz = ((TextView)localObject);
      this.aecz.setVisibility(paramInt);
      AppMethodBeat.o(39359);
      return;
      label147:
      if (this.fromScene == 10) {
        this.afNI = R.l.gRh;
      } else {
        this.afNI = R.l.gUD;
      }
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(39390);
    if ((parama.afey) && (parama.contact != null))
    {
      boolean bool = this.afOg.contains(parama.contact.field_username);
      AppMethodBeat.o(39390);
      return bool;
    }
    AppMethodBeat.o(39390);
    return false;
  }
  
  public final void aNi()
  {
    AppMethodBeat.i(39356);
    super.aNi();
    this.afNO = getIntent().getBooleanExtra("select_is_ret", false);
    this.fromScene = getIntent().getIntExtra("scene_from", 0);
    Log.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[] { Integer.valueOf(this.fromScene) });
    if (this.fromScene == 1)
    {
      this.afNP = true;
      if (getIntent().getIntExtra("from_scene", -1) != 0) {
        break label630;
      }
    }
    Object localObject1;
    Object localObject2;
    label630:
    for (boolean bool = true;; bool = false)
    {
      this.afOi = bool;
      this.AnG = getIntent().getBooleanExtra("is_mp_video", false);
      this.afNV = getIntent().getBooleanExtra("is_game_card", false);
      this.afNW = getIntent().getBooleanExtra("send_to_biz", false);
      this.aeSs = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
      this.hDn = getIntent().getLongExtra("select_fav_local_id", -1L);
      this.hIG = getIntent().getStringExtra("select_fav_fake_local_id");
      this.afNX = getIntent().getIntExtra("select_fav_select_count", 0);
      this.afOe = getIntent().getBooleanExtra("mutil_select_is_ret", false);
      this.afhx = getIntent().getBooleanExtra("Select_Send_Card", false);
      this.afNZ = getIntent().getBooleanExtra("forward_card", false);
      this.afNY = getIntent().getBooleanExtra("Retr_Big_File", false);
      if (this.afhx) {
        this.afOb = getIntent().getStringExtra("Select_Talker_Name");
      }
      this.selectType = getIntent().getIntExtra("Select_Conv_Type", afNH);
      this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
      this.msgId = getIntent().getLongExtra("Retr_Msg_Id", -1L);
      bh.bCz();
      this.hTm = com.tencent.mm.model.c.bzD().sl(this.msgId);
      this.afMC = ((ArrayList)getIntent().getSerializableExtra("Retr_Msg_Id_List"));
      if (Util.isNullOrNil(this.afMC)) {
        break label635;
      }
      this.afOk = new ArrayList(this.afMC.size());
      localObject1 = this.afMC.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Long)((Iterator)localObject1).next();
        List localList = this.afOk;
        bh.bCz();
        localList.add(com.tencent.mm.model.c.bzD().sl(((Long)localObject2).longValue()));
      }
      if ((this.fromScene != 2) && (this.fromScene != 10))
      {
        if (this.fromScene == 3)
        {
          getIntent();
          bool = cq.dy(((HashMap)getIntent().getSerializableExtra("appbrand_params")).get("is_h5"));
          if (bool) {
            Log.i("MicroMsg.SelectConversationUI", "hy: is H5 link");
          }
          if (!bool) {}
        }
      }
      else
      {
        this.afNQ = true;
        break;
      }
      if (this.fromScene == 3)
      {
        this.afNR = true;
        break;
      }
      if (this.fromScene == 6)
      {
        this.afNS = true;
        break;
      }
      if (this.fromScene == 7)
      {
        this.afNT = true;
        break;
      }
      if (this.fromScene == 12)
      {
        this.afNU = true;
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
    this.afOp = getIntent().getStringExtra("ad_video_title");
    this.wtc = getIntent().getStringExtra("desc_title");
    this.emojiMD5 = getIntent().getStringExtra("Retr_Msg_thumb_path");
    if (getIntent().hasExtra("Retr_Msg_content_bytes")) {}
    for (this.hWn = new String(getIntent().getByteArrayExtra("Retr_Msg_content_bytes"));; this.hWn = getIntent().getStringExtra("Retr_Msg_content"))
    {
      this.afOs = getIntent().getStringExtra("Retr_fav_xml_str");
      this.afMD = getIntent().getStringExtra("Retr_Msg_thumb_path");
      if ((this.hWn == null) && (this.hTm != null)) {
        this.hWn = this.hTm.field_content;
      }
      if (this.hWn == null) {
        this.hWn = "";
      }
      this.afOj = ((ReportUtil.ReportArgs)getIntent().getParcelableExtra("Select_Report_Args"));
      this.afOt = getIntent().getStringExtra("KChooseMsgFileType");
      this.afOu = getIntent().getIntExtra("KChooseMsgFileCount", 9);
      this.afOv = getIntent().getStringExtra("KChooseMsgFileExtension");
      localObject1 = new HashSet();
      ((HashSet)localObject1).addAll(w.jyV());
      localObject2 = getIntent().getStringExtra("Select_block_List");
      if (!Util.isNullOrNil((String)localObject2)) {
        ((HashSet)localObject1).addAll(Util.stringsToList(((String)localObject2).split(",")));
      }
      if (w.hasAttr(this.selectType, 2))
      {
        localObject2 = w.jyW();
        w.j((HashSet)localObject2);
        ((HashSet)localObject1).addAll((Collection)localObject2);
      }
      if (!w.hasAttr(this.selectType, 4)) {
        w.k((HashSet)localObject1);
      }
      this.lMF = new ArrayList();
      this.lMF.addAll((Collection)localObject1);
      localObject1 = this.lMF;
      long l = System.currentTimeMillis();
      int i = ((List)localObject1).size();
      ((List)localObject1).addAll(com.tencent.mm.pluginsdk.platformtools.a.iIW());
      Log.i("MicroMsg.SelectConversationUI", "[fillBlockList] cost:%sms size:%s block size:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(((List)localObject1).size() - i) });
      if (w.hasAttr(this.selectType, 1)) {
        this.afeW = true;
      }
      if (jDw())
      {
        this.afOg = new LinkedList();
        this.afOh = new HashMap();
        if (jDw())
        {
          addTextOptionMenu(1, getString(R.l.app_multi_selected), this.afOz, null, y.b.adFa);
          aNr();
        }
      }
      AppMethodBeat.o(39356);
      return;
    }
  }
  
  protected final void aUj(String paramString)
  {
    AppMethodBeat.i(169903);
    Log.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[] { paramString });
    if (bDg(paramString))
    {
      AppMethodBeat.o(169903);
      return;
    }
    if (bDi(paramString))
    {
      AppMethodBeat.o(169903);
      return;
    }
    Intent localIntent1 = new Intent();
    localIntent1.putExtra("Select_Conv_User", paramString);
    Intent localIntent2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
    if (localIntent2 != null) {
      d(localIntent1, localIntent2);
    }
    for (;;)
    {
      hideVKB();
      AppMethodBeat.o(169903);
      return;
      if ((this.afNO) || (this.afhx) || (this.afNP) || (this.afNQ) || (this.afNR) || (this.AnG) || (this.afNU))
      {
        if (jDJ()) {
          v(localIntent1, paramString);
        }
      }
      else if (this.fromScene == 11)
      {
        bDj(paramString);
      }
      else
      {
        v(-1, localIntent1);
        finish();
      }
    }
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(39391);
    if (paramInt == 1)
    {
      this.afOg.remove(paramString);
      this.afOh.remove(paramString);
      jyE().notifyDataSetChanged();
      op(this.afOg);
      aNr();
    }
    AppMethodBeat.o(39391);
  }
  
  public final boolean bDg(String paramString)
  {
    AppMethodBeat.i(39365);
    if (!bDf(paramString))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if ((!Util.isNullOrNil(getIntent().getStringExtra("Select_App_Id"))) && (this.afhx))
    {
      AppMethodBeat.o(39365);
      return false;
    }
    if (this.afhx)
    {
      bh.bCz();
      if (au.ayS(com.tencent.mm.model.c.bzA().bxu(this.afOb).field_verifyFlag))
      {
        bDh(paramString);
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
    bh.bCz();
    String str = com.tencent.mm.model.c.bzD().aLU(this.hWn).hgk;
    bh.bCz();
    if (com.tencent.mm.model.ab.uY(com.tencent.mm.model.c.bzA().bxu(str).field_verifyFlag))
    {
      bDh(paramString);
      AppMethodBeat.o(39365);
      return true;
    }
    AppMethodBeat.o(39365);
    return false;
  }
  
  public com.tencent.mm.ui.contact.r bVA()
  {
    AppMethodBeat.i(39357);
    if (com.tencent.mm.ui.contact.h.jyw())
    {
      this.afOq = new com.tencent.mm.ui.contact.z(this, this.lMF, this.afeW, this.afOf, this.afNW, this.selectType);
      this.afOq.afgu = new z.b()
      {
        public final void bBU(String paramAnonymousString)
        {
          AppMethodBeat.i(250860);
          if (SelectConversationUI.this.afOf)
          {
            Log.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[] { paramAnonymousString });
            if ((!SelectConversationUI.this.afOg.contains(paramAnonymousString)) && (SelectConversationUI.a(SelectConversationUI.this, true)))
            {
              SelectConversationUI.i(SelectConversationUI.this);
              AppMethodBeat.o(250860);
              return;
            }
            SelectConversationUI.a(SelectConversationUI.this, paramAnonymousString, SelectConversationUI.j(SelectConversationUI.this).getHeaderViewsCount());
            SelectConversationUI.k(SelectConversationUI.this);
            SelectConversationUI.this.jyE().notifyDataSetChanged();
          }
          for (;;)
          {
            if (SelectConversationUI.m(SelectConversationUI.this)) {
              com.tencent.mm.modelstat.a.c(SelectConversationUI.n(SelectConversationUI.this), 4);
            }
            AppMethodBeat.o(250860);
            return;
            SelectConversationUI.a(SelectConversationUI.this, SelectConversationUI.l(SelectConversationUI.this).getHeaderViewsCount());
            SelectConversationUI.this.aUj(paramAnonymousString);
          }
        }
      };
      this.afOq.afgv = new z.a()
      {
        public final void onClick()
        {
          AppMethodBeat.i(250865);
          if (SelectConversationUI.this.afOf)
          {
            SelectConversationUI.o(SelectConversationUI.this);
            AppMethodBeat.o(250865);
            return;
          }
          SelectConversationUI.p(SelectConversationUI.this);
          AppMethodBeat.o(250865);
        }
      };
      localObject = this.afOq;
      AppMethodBeat.o(39357);
      return localObject;
    }
    this.afOr = new ae(this, this.lMF, this.afeW, this.afOf, this.afNW, this.selectType);
    Object localObject = this.afOr;
    AppMethodBeat.o(39357);
    return localObject;
  }
  
  public com.tencent.mm.ui.contact.p bVB()
  {
    AppMethodBeat.i(39358);
    com.tencent.mm.ui.contact.u localu = new com.tencent.mm.ui.contact.u(this, this.lMF, this.afOf, this.scene);
    AppMethodBeat.o(39358);
    return localu;
  }
  
  public boolean bVx()
  {
    AppMethodBeat.i(251197);
    if (jDw())
    {
      if (!this.afOf)
      {
        AppMethodBeat.o(251197);
        return true;
      }
      AppMethodBeat.o(251197);
      return false;
    }
    AppMethodBeat.o(251197);
    return true;
  }
  
  public boolean bVy()
  {
    return false;
  }
  
  public String bVz()
  {
    AppMethodBeat.i(39389);
    String str = getIntent().getStringExtra("Select_Conv_ui_title");
    if ((str == null) || (str.length() <= 0))
    {
      str = getString(R.l.gUH);
      AppMethodBeat.o(39389);
      return str;
    }
    AppMethodBeat.o(39389);
    return str;
  }
  
  public final String c(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(251229);
    int j;
    if ((parama.contact != null) && (au.bwz(parama.contact.field_username))) {
      if (this.afOg != null)
      {
        Iterator localIterator = this.afOg.iterator();
        int i = 0;
        j = i;
        if (!localIterator.hasNext()) {
          break label83;
        }
        if (!com.tencent.mm.model.v.Iv((String)localIterator.next())) {
          break label128;
        }
        i += 1;
      }
    }
    label128:
    for (;;)
    {
      break;
      j = 0;
      label83:
      if (j != 0)
      {
        parama = getString(R.l.select_conversation_cnt_in_conv_box, new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(251229);
        return parama;
      }
      parama = super.c(parama);
      AppMethodBeat.o(251229);
      return parama;
    }
  }
  
  public final int[] efu()
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
    arrayOfInt = super.efu();
    AppMethodBeat.o(39395);
    return arrayOfInt;
  }
  
  public void fYZ()
  {
    AppMethodBeat.i(39360);
    if (this.fromScene == 5) {
      com.tencent.mm.ui.base.k.a(this, getString(R.l.gMR), null, getString(R.l.send), getString(R.l.cancel), true, new SelectConversationUI.42(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(250837);
          SelectConversationUI.s(SelectConversationUI.this);
          SelectConversationUI.this.hideVKB();
          AppMethodBeat.o(250837);
        }
      });
    }
    for (;;)
    {
      if (this.afOj != null)
      {
        this.afOj.errCode = 0;
        ReportUtil.a(this, this.afOj, true);
      }
      AppMethodBeat.o(39360);
      return;
      super.fYZ();
      hideVKB();
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(251163);
    super.finish();
    overridePendingTransition(-1, R.a.sight_slide_bottom_out);
    AppMethodBeat.o(251163);
  }
  
  public void initView()
  {
    AppMethodBeat.i(251154);
    super.initView();
    if (com.tencent.mm.ui.contact.h.jyw())
    {
      this.afNJ = ((RelativeLayout)findViewById(R.h.recent_chatting_header_view));
      this.afNK = ((RelativeLayout)findViewById(R.h.header_view_rl));
      this.afNL = ((LinearLayout)findViewById(R.h.content_ll));
      this.afNM = ((ImageView)this.afNJ.findViewById(R.h.icon_iv));
      this.afNN = ((TextView)this.afNJ.findViewById(R.h.content_tv));
      this.FZP = ((TextView)this.afNJ.findViewById(R.h.header_title_tv));
      com.tencent.mm.ui.aw.d(this.FZP.getPaint());
      this.FZP.setText(getString(R.l.select_contact_conversation_cur));
      fzD();
      this.afNL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(250843);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/transmit/SelectConversationUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (SelectConversationUI.this.afOf) {
            SelectConversationUI.o(SelectConversationUI.this);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/transmit/SelectConversationUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250843);
            return;
            paramAnonymousView = SelectConversationUI.this.getIntent().getStringExtra("Select_App_Id");
            if ((SelectConversationUI.q(SelectConversationUI.this)) && (Util.isNullOrNil(paramAnonymousView))) {
              SelectConversationUI.r(SelectConversationUI.this);
            } else {
              SelectConversationUI.p(SelectConversationUI.this);
            }
          }
        }
      });
      this.Nnk.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        private int RUa;
        private SparseArray afOT;
        
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(250906);
          if (SelectConversationUI.a(SelectConversationUI.this) != null) {
            if (!SelectConversationUI.a(SelectConversationUI.this).afgn) {
              break label347;
            }
          }
          label199:
          label344:
          label347:
          for (paramAnonymousInt2 = 1;; paramAnonymousInt2 = 0)
          {
            if (SelectConversationUI.b(SelectConversationUI.this) != null)
            {
              if (paramAnonymousInt1 <= paramAnonymousInt2) {
                break label237;
              }
              SelectConversationUI.b(SelectConversationUI.this).setVisibility(0);
              if (SelectConversationUI.a(SelectConversationUI.this).afgz)
              {
                SelectConversationUI.c(SelectConversationUI.this).setBackground(SelectConversationUI.this.getContext().getResources().getDrawable(R.g.header_view_top_place_color_background));
                SelectConversationUI.d(SelectConversationUI.this).setBackground(SelectConversationUI.this.getContext().getResources().getDrawable(R.g.header_view_top_place_color_background));
              }
            }
            this.RUa = paramAnonymousInt1;
            View localView = paramAnonymousAbsListView.getChildAt(0);
            a locala;
            if (localView != null)
            {
              locala = (a)this.afOT.get(paramAnonymousInt1);
              paramAnonymousAbsListView = locala;
              if (locala == null) {
                paramAnonymousAbsListView = new a();
              }
              paramAnonymousAbsListView.height = localView.getHeight();
              paramAnonymousAbsListView.top = localView.getTop();
              this.afOT.append(paramAnonymousInt1, paramAnonymousAbsListView);
              paramAnonymousInt2 = 0;
              paramAnonymousInt1 = 0;
              if (paramAnonymousInt2 < this.RUa)
              {
                paramAnonymousAbsListView = (a)this.afOT.get(paramAnonymousInt2);
                if (paramAnonymousAbsListView == null) {
                  break label344;
                }
                paramAnonymousInt1 = paramAnonymousAbsListView.height + paramAnonymousInt1;
              }
            }
            for (;;)
            {
              paramAnonymousInt2 += 1;
              break label199;
              label237:
              SelectConversationUI.b(SelectConversationUI.this).setVisibility(8);
              break;
              locala = (a)this.afOT.get(this.RUa);
              paramAnonymousAbsListView = locala;
              if (locala == null) {
                paramAnonymousAbsListView = new a();
              }
              paramAnonymousInt1 -= paramAnonymousAbsListView.top;
              if (SelectConversationUI.e(SelectConversationUI.this) != null) {
                SelectConversationUI.f(SelectConversationUI.this).setY(-paramAnonymousInt1);
              }
              if (SelectConversationUI.g(SelectConversationUI.this) != null) {
                SelectConversationUI.h(SelectConversationUI.this).setY(-paramAnonymousInt1);
              }
              AppMethodBeat.o(250906);
              return;
            }
          }
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
        
        final class a
        {
          int height = 0;
          int top = 0;
          
          a() {}
        }
      });
    }
    AppMethodBeat.o(251154);
  }
  
  protected boolean jDw()
  {
    return this.afOe;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(39363);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      this.fromScene = paramIntent.getIntExtra("scene_from", 0);
      Log.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = " + paramIntent.toString());
      if (paramInt1 != 7) {
        break label297;
      }
      if (paramInt2 != -1) {
        break label183;
      }
      v(-1, paramIntent);
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      if (!TextUtils.isEmpty(paramIntent)) {
        jh(paramIntent, -2);
      }
      finish();
    }
    label183:
    label202:
    Object localObject1;
    label283:
    label297:
    Object localObject2;
    label742:
    do
    {
      do
      {
        Log.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(39363);
        return;
        Log.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + paramInt1 + ", resultCode = " + paramInt2 + ", data = null");
        break;
      } while (!this.afOf);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        if (!TextUtils.isEmpty(paramIntent)) {
          break label283;
        }
      }
      for (paramIntent = new LinkedList();; paramIntent = Util.stringsToList(paramIntent.split(",")))
      {
        localObject1 = paramIntent;
        if (paramIntent == null) {
          localObject1 = new LinkedList();
        }
        paramIntent = this.KOt;
        if (paramIntent != null) {
          paramIntent.mv((List)localObject1);
        }
        this.afOg = ((List)localObject1);
        aNr();
        jyE().notifyDataSetChanged();
        op(this.afOg);
        break;
        paramIntent = "";
        break label202;
      }
      if (paramInt1 == 1)
      {
        if ((paramInt2 == -1) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          Log.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
          localObject2 = (Intent)getIntent().getParcelableExtra("Select_Conv_NextStep");
          if (localObject2 != null)
          {
            if (bDg((String)localObject1))
            {
              AppMethodBeat.o(39363);
              return;
            }
            d(paramIntent, (Intent)localObject2);
            AppMethodBeat.o(39363);
            return;
          }
          if ((this.afNO) || (this.afhx) || (this.afNP) || (this.afNQ) || (this.afNR) || (this.afNU))
          {
            v(paramIntent, (String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          if (this.fromScene == 11)
          {
            bDj((String)localObject1);
            AppMethodBeat.o(39363);
            return;
          }
          v(-1, paramIntent);
          finish();
        }
        AppMethodBeat.o(39363);
        return;
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
          com.tencent.threadpool.h.ahAA.p(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(250838);
              SelectConversationUI.this.finish();
              AppMethodBeat.o(250838);
            }
          }, 1000L);
          if ((paramIntent != null) && (paramIntent.getBooleanExtra("Select_stay_in_wx", false)))
          {
            paramIntent = paramIntent.getStringExtra("scene_select_user_liast");
            if (!Util.isNullOrNil(paramIntent))
            {
              this.afOg = new LinkedList(Util.stringsToList(paramIntent.split(",")));
              if (!Util.isNullOrNil(this.afOg))
              {
                if (this.afOg.size() != 1) {
                  break label742;
                }
                bDl((String)this.afOg.get(0));
              }
            }
            for (;;)
            {
              paramIntent = new Intent(this, TaskRedirectUI.class);
              paramIntent.addFlags(268435456);
              paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
              com.tencent.mm.hellhoundlib.a.a.b(this, paramIntent.aYi(), "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              startActivity((Intent)paramIntent.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/transmit/SelectConversationUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ReportUtil.ap(false, 0);
              AppMethodBeat.o(39363);
              return;
              jDL();
            }
          }
          if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getBooleanExtra("Select_back_to_app", false)))
          {
            localObject1 = paramIntent.getStringExtra("scene_select_user_liast");
            if (!Util.isNullOrNil((String)localObject1))
            {
              this.afOg = new LinkedList(Util.stringsToList(((String)localObject1).split(",")));
              if (!Util.isNullOrNil(this.afOg))
              {
                if (this.afOg.size() != 1) {
                  break label870;
                }
                bDl((String)this.afOg.get(0));
              }
            }
            for (;;)
            {
              ReportUtil.a(this, ReportUtil.c(paramIntent.getExtras(), 0), false);
              AppMethodBeat.o(39363);
              return;
              jDL();
            }
            if (paramIntent != null) {
              this.afOj = ((ReportUtil.ReportArgs)paramIntent.getParcelableExtra("Select_Report_Args"));
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
            if ((!Util.isNullOrNil(paramIntent)) && (!bDg(paramIntent)))
            {
              localObject1 = new o.a(getContext());
              ((o.a)localObject1).gA(paramIntent);
              a((o.a)localObject1, this.afOb);
              localObject1 = ((o.a)localObject1).I(Boolean.TRUE);
              ((o.a)localObject1).GGQ = jDK();
              {
                public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
                {
                  AppMethodBeat.i(250803);
                  SelectConversationUI.this.hideVKB();
                  Intent localIntent;
                  if (paramAnonymousBoolean)
                  {
                    localIntent = new Intent();
                    if (!au.bwE(paramIntent)) {
                      break label94;
                    }
                    SelectConversationUI.c(localIntent, SelectConversationUI.t(SelectConversationUI.this), paramIntent);
                  }
                  for (;;)
                  {
                    localIntent.putExtra("custom_send_text", paramAnonymousString);
                    SelectConversationUI.a(SelectConversationUI.this, paramIntent);
                    SelectConversationUI.a(SelectConversationUI.this, -1, localIntent);
                    SelectConversationUI.this.finish();
                    AppMethodBeat.o(250803);
                    return;
                    label94:
                    SelectConversationUI.d(localIntent, SelectConversationUI.t(SelectConversationUI.this), paramIntent);
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
          v(paramIntent, paramIntent.getStringExtra("Select_Contact"));
        }
        AppMethodBeat.o(39363);
        return;
      }
    } while (paramInt1 != 5);
    label870:
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      localObject1 = this.afOg.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        this.KOt.bqH((String)localObject2);
      }
      if (!Util.isNullOrNil(paramIntent)) {
        this.afOg = Util.stringsToList(paramIntent.split(","));
      }
      for (;;)
      {
        paramIntent = this.afOg.iterator();
        while (paramIntent.hasNext())
        {
          localObject1 = (String)paramIntent.next();
          this.KOt.bqI((String)localObject1);
        }
        this.afOg.clear();
        this.afOh.clear();
      }
      aNr();
      jyE().notifyDataSetChanged();
      op(this.afOg);
    }
    AppMethodBeat.o(39363);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(39361);
    super.fYZ();
    AppMethodBeat.o(39361);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39355);
    super.onCreate(paramBundle);
    this.startTime = com.tencent.mm.model.cn.bDu();
    paramBundle = getIntent().getStringExtra("Select_App_Id");
    String str = getIntent().getStringExtra("Select_Open_Id");
    Log.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + paramBundle + ", openId = " + str);
    if ((!Util.isNullOrNil(paramBundle)) && (!Util.isNullOrNil(str))) {
      new com.tencent.mm.plugin.base.stub.d(this, paramBundle, str, new d.a()
      {
        public final void mC(boolean paramAnonymousBoolean)
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
      }).cZW();
    }
    com.tencent.mm.pluginsdk.h.x(this);
    AppMethodBeat.o(39355);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39392);
    super.onDestroy();
    removeAllOptionMenu();
    if (!this.afOo) {
      jh("", -1);
    }
    AppMethodBeat.o(39392);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(251217);
    super.onStop();
    AppMethodBeat.o(251217);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.SelectConversationUI
 * JD-Core Version:    0.7.0.1
 */