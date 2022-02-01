package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.i.a.ab;
import com.tencent.mm.plugin.i.a.ab.a;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.2;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.plugin.textstatus.a.p;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
public class SnsHeader
  extends LinearLayout
{
  private String DTT;
  private b EDA;
  private boolean EDB;
  private Map<Integer, View> EDC;
  private String EDD;
  Bitmap EDE;
  boolean EDF;
  c EDy;
  private a EDz;
  Animation ErS;
  Context context;
  boolean dJM;
  private Dialog dialog;
  String gna;
  private String sessionId;
  int type;
  String userName;
  
  public SnsHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98715);
    this.EDB = false;
    this.dJM = false;
    this.EDC = new HashMap();
    this.EDD = "";
    this.EDE = null;
    this.ErS = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.EDF = false;
    init(paramContext);
    AppMethodBeat.o(98715);
  }
  
  public SnsHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98716);
    this.EDB = false;
    this.dJM = false;
    this.EDC = new HashMap();
    this.EDD = "";
    this.EDE = null;
    this.ErS = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.EDF = false;
    init(paramContext);
    AppMethodBeat.o(98716);
  }
  
  static boolean fic()
  {
    boolean bool3 = true;
    AppMethodBeat.i(203582);
    boolean bool1;
    boolean bool2;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rRI, 1) == 1)
    {
      bool1 = true;
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        bool1 = true;
      }
      if (!bool1) {
        break label164;
      }
      if ((!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) || (((ad)com.tencent.mm.kernel.g.af(ad.class)).dxY())) {
        break label154;
      }
      bool2 = true;
      label88:
      boolean bool4 = ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).showFinderEntry();
      if ((!bool4) || (bool2)) {
        break label159;
      }
      bool1 = bool3;
      label112:
      Log.i("MicroMsg.SnsHeader", "timeline_live_list_show " + bool2 + "," + bool4);
    }
    label154:
    label159:
    label164:
    for (;;)
    {
      AppMethodBeat.o(203582);
      return bool1;
      bool1 = false;
      break;
      bool2 = false;
      break label88;
      bool1 = false;
      break label112;
    }
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(98721);
    this.context = paramContext;
    com.tencent.mm.kernel.g.aAi();
    this.EDF = ((e)com.tencent.mm.kernel.g.ah(e.class)).getStoryNewFeatureConfig().fng();
    Object localObject = aa.jQ(paramContext).inflate(2131496444, this, true);
    FrameLayout localFrameLayout = (FrameLayout)((View)localObject).findViewById(2131308212);
    this.EDy = new c();
    this.EDy.oSN = ((TextView)((View)localObject).findViewById(2131305440));
    this.EDy.gyr = ((ImageView)((View)localObject).findViewById(2131297134));
    this.EDy.Eob = ((TextView)((View)localObject).findViewById(2131307904));
    this.EDy.EDL = ((ImageView)((View)localObject).findViewById(2131308076));
    this.EDy.EDM = ((ImageView)((View)localObject).findViewById(2131308077));
    this.EDy.EDN = ((LinearLayout)((View)localObject).findViewById(2131307665));
    this.EDy.EDO = ((LinearLayout)((View)localObject).findViewById(2131308116));
    this.EDy.EDR = ((RelativeLayout)((View)localObject).findViewById(2131308130));
    this.EDy.EDS = ((LinearLayout)((View)localObject).findViewById(2131308131));
    this.EDy.EDT = ((ImageView)((View)localObject).findViewById(2131308132));
    this.EDy.EDV = ((ViewGroup)((View)localObject).findViewById(2131308122));
    this.ErS.setDuration(1000L);
    this.ErS.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.ErS.setInterpolator((Interpolator)localObject);
    if (!p.fvC())
    {
      localObject = this.EDy;
      com.tencent.mm.kernel.g.aAi();
      ((c)localObject).EDP = ((e)com.tencent.mm.kernel.g.ah(e.class)).getStoryUIFactory().hi(paramContext);
      this.EDy.EDQ = new SnsStoryHeaderView(paramContext);
      if (!this.EDF) {
        break label433;
      }
      localFrameLayout.addView(this.EDy.EDP);
      this.EDy.EDP.onCreateView();
    }
    for (;;)
    {
      this.EDy.EDL.setContentDescription(paramContext.getString(2131766005));
      this.EDy.EDL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98713);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          Log.d("MicroMsg.SnsHeader", "change backGround");
          if ((SnsHeader.b(SnsHeader.this) != null) && (SnsHeader.b(SnsHeader.this).isShowing()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98713);
            return;
          }
          if (SnsHeader.c(SnsHeader.this) != null) {
            SnsHeader.c(SnsHeader.this).fif();
          }
          if (SnsHeader.d(SnsHeader.this) == 1) {}
          final long l;
          for (paramAnonymousView = SnsHeader.e(SnsHeader.this);; paramAnonymousView = SnsHeader.f(SnsHeader.this))
          {
            paramAnonymousView = com.tencent.mm.plugin.sns.model.aj.faS().aQr(paramAnonymousView);
            l = paramAnonymousView.field_snsBgId;
            if ((SnsHeader.g(SnsHeader.this)) || (l != 0L)) {
              break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98713);
            return;
          }
          SnsHeader.a(SnsHeader.this, paramAnonymousView.feK());
          if ((SnsHeader.d(SnsHeader.this) == 1) || (SnsHeader.e(SnsHeader.this).trim().equals(SnsHeader.f(SnsHeader.this).trim())))
          {
            paramAnonymousView = new String[1];
            paramAnonymousView[0] = paramContext.getString(2131766286);
            SnsHeader.a(SnsHeader.this, false);
            if (!SnsHeader.h(SnsHeader.this)) {
              break label387;
            }
            localObject = paramContext.getString(2131766199);
            label281:
            if (!SnsHeader.h(SnsHeader.this)) {
              break label394;
            }
            paramContext.getString(2131755921);
          }
          for (;;)
          {
            SnsHeader.a(SnsHeader.this, h.a(SnsHeader.this.getContext(), (String)localObject, paramAnonymousView, new h.d()
            {
              public final void oj(int paramAnonymous2Int)
              {
                AppMethodBeat.i(203579);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(203579);
                  return;
                  if (!SnsHeader.h(SnsHeader.this)) {
                    SnsHeader.a(SnsHeader.this, l);
                  }
                }
              }
            }));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98713);
            return;
            if (SnsHeader.h(SnsHeader.this))
            {
              paramAnonymousView = new String[0];
              break;
            }
            paramAnonymousView = new String[1];
            paramAnonymousView[0] = paramContext.getString(2131766116);
            break;
            label387:
            localObject = "";
            break label281;
            label394:
            paramContext.getString(2131755761);
          }
        }
      });
      this.EDy.gyr.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(203580);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          paramAnonymousView = com.tencent.mm.plugin.sns.model.aj.faC().Kn(SnsHeader.f(SnsHeader.this));
          int i;
          if ((paramAnonymousView != null) && ((c.oR(paramAnonymousView.field_type)) || (SnsHeader.g(SnsHeader.this))))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", SnsHeader.f(SnsHeader.this));
            if ((SnsHeader.f(SnsHeader.this) != null) && (SnsHeader.f(SnsHeader.this).length() > 0))
            {
              if (SnsHeader.d(SnsHeader.this) != 1) {
                break label172;
              }
              i = 6;
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", i);
              com.tencent.mm.plugin.sns.c.a.jRt.c(paramAnonymousView, paramContext);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203580);
            return;
            label172:
            i = 1;
            break;
            paramAnonymousView = ((Activity)paramContext).getIntent();
            paramAnonymousView.putExtra("Contact_User", SnsHeader.f(SnsHeader.this));
            com.tencent.mm.plugin.sns.c.a.jRt.c(paramAnonymousView, paramContext);
          }
        }
      });
      AppMethodBeat.o(98721);
      return;
      label433:
      localFrameLayout.addView(this.EDy.EDQ);
      this.EDy.EDQ.setSessionId(this.sessionId);
      this.EDy.EDQ.setEnterObjectId(this.DTT);
    }
  }
  
  public final void fid()
  {
    AppMethodBeat.i(98723);
    String str1 = this.userName;
    if (this.type == 1) {
      str1 = this.gna;
    }
    Object localObject1 = com.tencent.mm.plugin.sns.model.aj.getAccSnsPath();
    Log.d("MicroMsg.SnsHeader", "MagicAsyncTask ".concat(String.valueOf(str1)));
    l locall = com.tencent.mm.plugin.sns.model.aj.faS().aQr(str1);
    String str2 = locall.field_bgId;
    Object localObject3 = locall.field_older_bgId;
    Log.d("MicroMsg.SnsHeader", "showName " + str1 + " get bgId : " + str2 + "  olderBgId：　" + (String)localObject3);
    localObject3 = r.aOh(str2);
    String str6 = str1 + "bg_";
    String str3 = str1 + "tbg_";
    String str4 = ar.ki((String)localObject1, str1);
    s.boN(str4);
    int i;
    String str5;
    if ((locall.field_local_flag & 0x1) > 0)
    {
      i = 1;
      if (i != 0)
      {
        Log.d("MicroMsg.SnsHeader", "bg is change");
        com.tencent.mm.plugin.sns.model.aj.faS().aQq(str1);
        if (s.YS(ar.ki((String)localObject1, str1) + str6))
        {
          s.deleteFile(ar.ki((String)localObject1, str1) + str3);
          s.bo(ar.ki((String)localObject1, str1), str6, str3);
        }
        locall.field_local_flag &= 0xFFFFFFFE;
        com.tencent.mm.plugin.sns.model.aj.faS().c(locall);
      }
      if ((s.YS(ar.ki(com.tencent.mm.plugin.sns.model.aj.getAccSnsPath(), str2) + (String)localObject3)) && (!s.YS(ar.ki((String)localObject1, str1) + str6)))
      {
        s.nw(ar.ki((String)localObject1, str2) + (String)localObject3, ar.ki((String)localObject1, str1) + str6);
        Log.d("MicroMsg.SnsHeader", "nwer id Name update");
      }
      str5 = locall.field_bgUrl;
      if (str2 == null) {
        break label773;
      }
      com.tencent.mm.plugin.sns.model.aj.faL();
      localObject1 = str4 + str6;
      this.context.hashCode();
      localObject3 = com.tencent.mm.plugin.sns.model.g.a((String)localObject1, str5, str2, true, bp.Oqt);
      Log.d("MicroMsg.SnsHeader", "set a new bg");
      localObject1 = localObject3;
      if (localObject3 == null) {
        s.deleteFile(str4 + str6);
      }
    }
    label686:
    Object localObject2;
    label773:
    for (localObject1 = localObject3;; localObject2 = null)
    {
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (str2 != null)
        {
          com.tencent.mm.plugin.sns.model.aj.faL();
          localObject1 = str4 + str3;
          this.context.hashCode();
          localObject3 = com.tencent.mm.plugin.sns.model.g.a((String)localObject1, str5, str2, false, bp.Oqt);
        }
      }
      if (this.EDy.EDL != null)
      {
        this.EDy.EDL.setImageBitmap((Bitmap)localObject3);
        if (localObject3 == null) {
          break label686;
        }
        this.EDy.EDL.setBackgroundDrawable(null);
      }
      for (;;)
      {
        this.EDy.EDN.setVisibility(8);
        if ((localObject3 == null) && ((this.type == 1) || (this.gna.equals(str1)))) {
          this.EDy.EDN.setVisibility(0);
        }
        this.EDB = locall.feK();
        AppMethodBeat.o(98723);
        return;
        i = 0;
        break;
        try
        {
          if ((this.EDE == null) || (this.EDE.isRecycled()))
          {
            Log.i("MicroMsg.SnsHeader", "decode bitmap by self");
            this.EDE = BackwardSupportUtil.BitmapFactory.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
          }
          localObject1 = new BitmapDrawable(this.EDE);
          this.EDy.EDL.setBackgroundDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.SnsHeader", localIOException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean fie()
  {
    AppMethodBeat.i(98724);
    if (this.EDy.EDO == null)
    {
      AppMethodBeat.o(98724);
      return false;
    }
    Object localObject = an.fbp();
    LinkedList localLinkedList = new LinkedList();
    final int i = 0;
    SnsInfo localSnsInfo1;
    boolean bool;
    for (;;)
    {
      if (i >= ((List)localObject).size()) {
        break label114;
      }
      localSnsInfo1 = (SnsInfo)((List)localObject).get(i);
      try
      {
        bool = ((cnc)new cnc().parseFrom(localSnsInfo1.field_postBuf)).Mtl;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localLinkedList.add(localSnsInfo1);
        }
      }
      i += 1;
    }
    label114:
    localObject = "";
    i = 0;
    for (;;)
    {
      if (i >= localLinkedList.size()) {
        break label224;
      }
      localSnsInfo1 = (SnsInfo)localLinkedList.get(i);
      try
      {
        bool = ((cnc)new cnc().parseFrom(localSnsInfo1.field_postBuf)).Mtl;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject = (String)localObject + ((SnsInfo)localLinkedList.get(i)).getLocalid() + " ";
        }
      }
      i += 1;
    }
    label224:
    Log.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[] { Integer.valueOf(localLinkedList.size()), localObject, this.EDD });
    if (((String)localObject).equals(this.EDD))
    {
      if (localLinkedList.size() > 0)
      {
        AppMethodBeat.o(98724);
        return true;
      }
      AppMethodBeat.o(98724);
      return false;
    }
    this.EDD = ((String)localObject);
    this.EDy.EDO.removeAllViews();
    localObject = this.EDy.EDO;
    label357:
    int j;
    final int k;
    label441:
    SnsInfo localSnsInfo2;
    TextView localTextView;
    if (localLinkedList.size() > 0)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      Collections.sort(localLinkedList, new d());
      i = 0;
      if (i >= localLinkedList.size()) {
        break label690;
      }
      j = ((SnsInfo)localLinkedList.get(i)).localid;
      k = localLinkedList.size();
      if ((!this.EDC.containsKey(Integer.valueOf(j))) || (this.EDC.get(Integer.valueOf(j)) == null)) {
        break label540;
      }
      localObject = (View)this.EDC.get(Integer.valueOf(j));
      localObject = (LinearLayout)localObject;
      ((LinearLayout)localObject).getChildAt(0).setTag(((SnsInfo)localLinkedList.get(i)).getLocalid());
      localSnsInfo2 = (SnsInfo)localLinkedList.get(i);
      localTextView = (TextView)((LinearLayout)localObject).findViewById(2131308183);
      if (localSnsInfo2.getTypeFlag() != 15) {
        break label597;
      }
      localTextView.setText(2131766177);
    }
    for (;;)
    {
      this.EDy.EDO.addView((View)localObject);
      i += 1;
      break label357;
      i = 8;
      break;
      label540:
      localObject = (LinearLayout)aa.jQ(this.context).inflate(2131495012, null);
      ((LinearLayout)localObject).getChildAt(0).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98714);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsHeader$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
          if ((paramAnonymousView.getTag() instanceof String))
          {
            Object localObject2 = (String)paramAnonymousView.getTag();
            Log.i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(localObject2)));
            paramAnonymousView = com.tencent.mm.plugin.sns.model.aj.faO().aQm((String)localObject2);
            if ((SnsHeader.i(SnsHeader.this) != null) && (paramAnonymousView != null))
            {
              localObject1 = new Intent();
              ((Intent)localObject1).setClass(SnsHeader.i(SnsHeader.this), SnsCommentDetailUI.class);
              if ((paramAnonymousView == null) || (paramAnonymousView.getUserName() == null) || (paramAnonymousView.getUserName().equals("")))
              {
                Log.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(98714);
                return;
              }
              ((Intent)localObject1).putExtra("INTENT_TALKER", paramAnonymousView.getUserName());
              ((Intent)localObject1).putExtra("INTENT_SNS_LOCAL_ID", (String)localObject2);
              ((Intent)localObject1).putExtra("INTENT_FROMGALLERY", true);
              localObject2 = k.tO(726);
              ((k)localObject2).tR(k).tR(i).tR(paramAnonymousView.getCreateTime());
              ((k)localObject2).bfK();
              localObject2 = SnsHeader.i(SnsHeader.this);
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/sns/ui/SnsHeader$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/SnsHeader$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
          try
          {
            localObject1 = (cnc)new cnc().parseFrom(paramAnonymousView.field_postBuf);
            if ((((cnc)localObject1).Mtd == 201) || (((cnc)localObject1).Mtd == 210) || (((cnc)localObject1).Mtd != 211))
            {
              ((cnc)localObject1).Mtl = true;
              paramAnonymousView.setPostBuf(((cnc)localObject1).toByteArray());
              com.tencent.mm.plugin.sns.model.aj.faO().d(paramAnonymousView.localid, paramAnonymousView);
            }
          }
          catch (Exception paramAnonymousView)
          {
            label361:
            break label361;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98714);
        }
      });
      this.EDC.put(Integer.valueOf(j), localObject);
      break label441;
      label597:
      if (localSnsInfo2.getTypeFlag() == 2) {
        localTextView.setText(2131766178);
      } else if (localSnsInfo2.getTypeFlag() == 1) {
        localTextView.setText(2131766169);
      } else if (localSnsInfo2.getTypeFlag() == 26) {
        localTextView.setText(2131766176);
      } else if (localSnsInfo2.getTypeFlag() == 28) {
        localTextView.setText(2131766174);
      } else {
        localTextView.setText(2131766175);
      }
    }
    label690:
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(98724);
      return true;
    }
    AppMethodBeat.o(98724);
    return false;
  }
  
  public final boolean fx(View paramView)
  {
    AppMethodBeat.i(203584);
    View localView = getFinderSnsRecyclerView();
    if (localView == null)
    {
      AppMethodBeat.o(203584);
      return false;
    }
    Rect localRect;
    if (localView.getVisibility() == 0)
    {
      i = 1;
      if (i == 0) {
        break label131;
      }
      localRect = new Rect();
      if (!paramView.getGlobalVisibleRect(localRect)) {
        break label139;
      }
    }
    label131:
    label139:
    for (int i = localRect.bottom;; i = 0)
    {
      paramView = new Rect();
      boolean bool = localView.getGlobalVisibleRect(paramView);
      int j = (int)(paramView.bottom - this.context.getResources().getDimension(2131165296));
      if ((bool) && (j > i))
      {
        AppMethodBeat.o(203584);
        return true;
        i = 0;
        break;
      }
      AppMethodBeat.o(203584);
      return false;
      AppMethodBeat.o(203584);
      return false;
    }
  }
  
  public View getFinderSnsRecyclerView()
  {
    AppMethodBeat.i(203583);
    if ((this.EDy != null) && (this.EDy.EDU != null))
    {
      View localView = this.EDy.EDU.dHc();
      AppMethodBeat.o(203583);
      return localView;
    }
    AppMethodBeat.o(203583);
    return null;
  }
  
  public int getLoadingGroupHeight()
  {
    AppMethodBeat.i(203585);
    int j = 0;
    int i = j;
    if (this.EDy != null)
    {
      i = j;
      if (this.EDy.EDS != null) {
        i = this.EDy.EDS.getHeight() + at.fromDPToPix(getContext(), 32);
      }
    }
    AppMethodBeat.o(203585);
    return i;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(98725);
    if ((this.EDy != null) && (this.EDy.EDP != null) && (this.EDF)) {
      this.EDy.EDP.fmT();
    }
    if ((this.EDy != null) && (this.EDy.EDQ != null) && (!this.EDF))
    {
      SnsStoryHeaderView localSnsStoryHeaderView = this.EDy.EDQ;
      Log.i("MicroMsg.SnsStoryHeaderView", "resume: ");
      localSnsStoryHeaderView.dLD = false;
      ((e)com.tencent.mm.kernel.g.ah(e.class)).getContactFetcher().fno();
      localSnsStoryHeaderView.post(new SnsStoryHeaderView.2(localSnsStoryHeaderView));
    }
    if ((this.type == 1) && (this.EDy != null) && (this.EDy.EDV != null) && (this.EDy.EDU != null))
    {
      if (!fic())
      {
        this.EDy.EDV.removeAllViews();
        this.EDy.EDV.setPadding(0, (int)this.context.getResources().getDimension(2131165303), 0, 0);
        if (this.EDy.EDQ != null) {
          this.EDy.EDQ.setTopLineVisibility(0);
        }
        Log.i("MicroMsg.SnsHeader", "disable2 finderSnsHeader");
        AppMethodBeat.o(98725);
        return;
      }
      this.EDy.EDU.dHd();
    }
    AppMethodBeat.o(98725);
  }
  
  public void setAvatarOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98722);
    if ((this.EDy != null) && (this.EDy.gyr != null)) {
      this.EDy.gyr.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98722);
  }
  
  public void setBackClickListener(a parama)
  {
    this.EDz = parama;
  }
  
  public void setEnterObjectId(String paramString)
  {
    AppMethodBeat.i(98720);
    this.DTT = paramString;
    if ((this.EDy != null) && (this.EDy.EDQ != null) && (!this.EDF)) {
      this.EDy.EDQ.setEnterObjectId(paramString);
    }
    AppMethodBeat.o(98720);
  }
  
  public void setHeadBgListener(b paramb)
  {
    this.EDA = paramb;
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(98719);
    this.sessionId = paramString;
    if ((this.EDy != null) && (this.EDy.EDQ != null) && (!this.EDF)) {
      this.EDy.EDQ.setSessionId(paramString);
    }
    AppMethodBeat.o(98719);
  }
  
  public void setStoryAction(SnsStoryHeaderView.a parama)
  {
    AppMethodBeat.i(98718);
    if ((this.EDy != null) && (this.EDy.EDQ != null) && (!this.EDF)) {
      this.EDy.EDQ.setStoryAction(parama);
    }
    AppMethodBeat.o(98718);
  }
  
  public static abstract interface a
  {
    public abstract boolean JQ(long paramLong);
    
    public abstract boolean fif();
  }
  
  public static abstract interface b {}
  
  final class c
  {
    ImageView EDL;
    ImageView EDM;
    LinearLayout EDN;
    LinearLayout EDO;
    AbsStoryHeaderTipView EDP;
    SnsStoryHeaderView EDQ;
    RelativeLayout EDR;
    LinearLayout EDS;
    ImageView EDT;
    ab EDU;
    ViewGroup EDV;
    TextView Eob;
    ImageView gyr;
    TextView oSN;
    
    c() {}
  }
  
  final class d
    implements Comparator<SnsInfo>
  {
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader
 * JD-Core Version:    0.7.0.1
 */