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
import android.text.TextUtils;
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
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.findersdk.a.ac;
import com.tencent.mm.plugin.findersdk.a.ac.a;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.2;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.vfs.u;
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
  Animation KFn;
  c KRn;
  private a KRo;
  private b KRp;
  private boolean KRq;
  private Map<Integer, View> KRr;
  private String KRs;
  Bitmap KRt;
  boolean KRu;
  private String Khd;
  Context context;
  private Dialog dialog;
  boolean fCB;
  String iRj;
  private String sessionId;
  int type;
  String userName;
  
  public SnsHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98715);
    this.KRq = false;
    this.fCB = false;
    this.KRr = new HashMap();
    this.KRs = "";
    this.KRt = null;
    this.KFn = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.KRu = false;
    init(paramContext);
    AppMethodBeat.o(98715);
  }
  
  public SnsHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98716);
    this.KRq = false;
    this.fCB = false;
    this.KRr = new HashMap();
    this.KRs = "";
    this.KRt = null;
    this.KFn = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.KRu = false;
    init(paramContext);
    AppMethodBeat.o(98716);
  }
  
  static boolean fWo()
  {
    boolean bool3 = true;
    AppMethodBeat.i(196679);
    boolean bool1;
    boolean bool2;
    if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vye, 1) == 1)
    {
      bool1 = true;
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED)) {
        bool1 = true;
      }
      if (!bool1) {
        break label164;
      }
      if ((!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM()) || (((ae)com.tencent.mm.kernel.h.ae(ae.class)).dYU())) {
        break label154;
      }
      bool2 = true;
      label88:
      boolean bool4 = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).showFinderEntry();
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
      AppMethodBeat.o(196679);
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
    com.tencent.mm.kernel.h.aHH();
    this.KRu = ((e)com.tencent.mm.kernel.h.ag(e.class)).getStoryNewFeatureConfig().gbz();
    Object localObject = ad.kS(paramContext).inflate(i.g.sns_header_item2, this, true);
    FrameLayout localFrameLayout = (FrameLayout)((View)localObject).findViewById(i.f.sns_story_header_container);
    this.KRn = new c();
    this.KRn.rUM = ((TextView)((View)localObject).findViewById(i.f.nickname_tv));
    this.KRn.jiu = ((ImageView)((View)localObject).findViewById(i.f.avatar_iv));
    this.KRn.KBk = ((TextView)((View)localObject).findViewById(i.f.sign_tv));
    this.KRn.KRA = ((ImageView)((View)localObject).findViewById(i.f.sns_back_ll));
    this.KRn.KRB = ((ImageView)((View)localObject).findViewById(i.f.sns_back_mask));
    this.KRn.KRC = ((LinearLayout)((View)localObject).findViewById(i.f.setting_bg));
    this.KRn.KRD = ((LinearLayout)((View)localObject).findViewById(i.f.sns_error_list));
    this.KRn.KRG = ((RelativeLayout)((View)localObject).findViewById(i.f.sns_header_group));
    this.KRn.KRH = ((LinearLayout)((View)localObject).findViewById(i.f.sns_header_loading_group));
    this.KRn.KRI = ((ImageView)((View)localObject).findViewById(i.f.sns_header_next_progress));
    this.KRn.KRK = ((ViewGroup)((View)localObject).findViewById(i.f.sns_finder_live_list_container));
    this.KFn.setDuration(1000L);
    this.KFn.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.KFn.setInterpolator((Interpolator)localObject);
    if (!com.tencent.mm.plugin.textstatus.a.t.gkZ())
    {
      localObject = this.KRn;
      com.tencent.mm.kernel.h.aHH();
      ((c)localObject).KRE = ((e)com.tencent.mm.kernel.h.ag(e.class)).getStoryUIFactory().ij(paramContext);
      this.KRn.KRF = new SnsStoryHeaderView(paramContext);
      if (!this.KRu) {
        break label435;
      }
      localFrameLayout.addView(this.KRn.KRE);
      this.KRn.KRE.onCreateView();
    }
    for (;;)
    {
      this.KRn.KRA.setContentDescription(paramContext.getString(i.j.sns_background_desc));
      this.KRn.KRA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98713);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          Log.d("MicroMsg.SnsHeader", "change backGround");
          if ((SnsHeader.b(SnsHeader.this) != null) && (SnsHeader.b(SnsHeader.this).isShowing()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98713);
            return;
          }
          if (SnsHeader.c(SnsHeader.this) != null) {
            SnsHeader.c(SnsHeader.this).fWr();
          }
          if (SnsHeader.d(SnsHeader.this) == 1) {}
          final long l;
          for (paramAnonymousView = SnsHeader.e(SnsHeader.this);; paramAnonymousView = SnsHeader.f(SnsHeader.this))
          {
            paramAnonymousView = aj.fOM().bbr(paramAnonymousView);
            l = paramAnonymousView.field_snsBgId;
            if ((SnsHeader.g(SnsHeader.this)) || ((l != 0L) && (!TextUtils.isEmpty(paramAnonymousView.field_bgUrl)))) {
              break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98713);
            return;
          }
          SnsHeader.a(SnsHeader.this, paramAnonymousView.fSE());
          if ((SnsHeader.d(SnsHeader.this) == 1) || (SnsHeader.e(SnsHeader.this).trim().equals(SnsHeader.f(SnsHeader.this).trim())))
          {
            paramAnonymousView = new String[1];
            paramAnonymousView[0] = paramContext.getString(i.j.sns_ui_setback);
            SnsHeader.a(SnsHeader.this, false);
            if (!SnsHeader.h(SnsHeader.this)) {
              break label401;
            }
            localObject = paramContext.getString(i.j.sns_set_has_like_bg);
            label293:
            if (!SnsHeader.h(SnsHeader.this)) {
              break label408;
            }
            paramContext.getString(i.j.app_ok);
          }
          for (;;)
          {
            SnsHeader.a(SnsHeader.this, com.tencent.mm.ui.base.h.a(SnsHeader.this.getContext(), (String)localObject, paramAnonymousView, new h.d()
            {
              public final void qy(int paramAnonymous2Int)
              {
                AppMethodBeat.i(252345);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(252345);
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
            paramAnonymousView[0] = paramContext.getString(i.j.sns_love_back);
            break;
            label401:
            localObject = "";
            break label293;
            label408:
            paramContext.getString(i.j.app_cancel);
          }
        }
      });
      this.KRn.jiu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(224894);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          paramAnonymousView = aj.fOw().RG(SnsHeader.f(SnsHeader.this));
          int i;
          if ((paramAnonymousView != null) && ((d.rk(paramAnonymousView.field_type)) || (SnsHeader.g(SnsHeader.this))))
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
              com.tencent.mm.plugin.sns.c.a.mIG.c(paramAnonymousView, paramContext);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsHeader$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(224894);
            return;
            label172:
            i = 1;
            break;
            paramAnonymousView = ((Activity)paramContext).getIntent();
            paramAnonymousView.putExtra("Contact_User", SnsHeader.f(SnsHeader.this));
            com.tencent.mm.plugin.sns.c.a.mIG.c(paramAnonymousView, paramContext);
          }
        }
      });
      AppMethodBeat.o(98721);
      return;
      label435:
      localFrameLayout.addView(this.KRn.KRF);
      this.KRn.KRF.setSessionId(this.sessionId);
      this.KRn.KRF.setEnterObjectId(this.Khd);
    }
  }
  
  public final void fWp()
  {
    AppMethodBeat.i(98723);
    String str1 = this.userName;
    if (this.type == 1) {
      str1 = this.iRj;
    }
    Object localObject1 = aj.getAccSnsPath();
    Log.d("MicroMsg.SnsHeader", "MagicAsyncTask ".concat(String.valueOf(str1)));
    com.tencent.mm.plugin.sns.storage.l locall = aj.fOM().bbr(str1);
    String str2 = locall.field_bgId;
    Object localObject3 = locall.field_older_bgId;
    Log.d("MicroMsg.SnsHeader", "showName " + str1 + " get bgId : " + str2 + "  olderBgId：　" + (String)localObject3);
    localObject3 = com.tencent.mm.plugin.sns.data.t.aZd(str2);
    String str6 = str1 + "bg_";
    String str3 = str1 + "tbg_";
    String str4 = aq.kD((String)localObject1, str1);
    u.bBD(str4);
    int i;
    String str5;
    if ((locall.field_local_flag & 0x1) > 0)
    {
      i = 1;
      if (i != 0)
      {
        Log.d("MicroMsg.SnsHeader", "bg is change");
        aj.fOM().bbq(str1);
        if (u.agG(aq.kD((String)localObject1, str1) + str6))
        {
          u.deleteFile(aq.kD((String)localObject1, str1) + str3);
          u.bj(aq.kD((String)localObject1, str1), str6, str3);
        }
        locall.field_local_flag &= 0xFFFFFFFE;
        aj.fOM().c(locall);
      }
      if ((u.agG(aq.kD(aj.getAccSnsPath(), str2) + (String)localObject3)) && (!u.agG(aq.kD((String)localObject1, str1) + str6)))
      {
        u.on(aq.kD((String)localObject1, str2) + (String)localObject3, aq.kD((String)localObject1, str1) + str6);
        Log.d("MicroMsg.SnsHeader", "nwer id Name update");
      }
      str5 = locall.field_bgUrl;
      if (str2 == null) {
        break label773;
      }
      aj.fOF();
      localObject1 = str4 + str6;
      this.context.hashCode();
      localObject3 = g.a((String)localObject1, str5, str2, true, bp.VGp);
      Log.d("MicroMsg.SnsHeader", "set a new bg");
      localObject1 = localObject3;
      if (localObject3 == null) {
        u.deleteFile(str4 + str6);
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
          aj.fOF();
          localObject1 = str4 + str3;
          this.context.hashCode();
          localObject3 = g.a((String)localObject1, str5, str2, false, bp.VGp);
        }
      }
      if (this.KRn.KRA != null)
      {
        this.KRn.KRA.setImageBitmap((Bitmap)localObject3);
        if (localObject3 == null) {
          break label686;
        }
        this.KRn.KRA.setBackgroundDrawable(null);
      }
      for (;;)
      {
        this.KRn.KRC.setVisibility(8);
        if ((localObject3 == null) && ((this.type == 1) || (this.iRj.equals(str1)))) {
          this.KRn.KRC.setVisibility(0);
        }
        this.KRq = locall.fSE();
        AppMethodBeat.o(98723);
        return;
        i = 0;
        break;
        try
        {
          if ((this.KRt == null) || (this.KRt.isRecycled()))
          {
            Log.i("MicroMsg.SnsHeader", "decode bitmap by self");
            this.KRt = BackwardSupportUtil.BitmapFactory.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
          }
          localObject1 = new BitmapDrawable(this.KRt);
          this.KRn.KRA.setBackgroundDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          Log.printErrStackTrace("MicroMsg.SnsHeader", localIOException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean fWq()
  {
    AppMethodBeat.i(98724);
    if (this.KRn.KRD == null)
    {
      AppMethodBeat.o(98724);
      return false;
    }
    Object localObject = an.fPj();
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
        bool = ((cvu)new cvu().parseFrom(localSnsInfo1.field_postBuf)).TEr;
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
        bool = ((cvu)new cvu().parseFrom(localSnsInfo1.field_postBuf)).TEr;
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
    Log.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[] { Integer.valueOf(localLinkedList.size()), localObject, this.KRs });
    if (((String)localObject).equals(this.KRs))
    {
      if (localLinkedList.size() > 0)
      {
        AppMethodBeat.o(98724);
        return true;
      }
      AppMethodBeat.o(98724);
      return false;
    }
    this.KRs = ((String)localObject);
    this.KRn.KRD.removeAllViews();
    localObject = this.KRn.KRD;
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
      if ((!this.KRr.containsKey(Integer.valueOf(j))) || (this.KRr.get(Integer.valueOf(j)) == null)) {
        break label540;
      }
      localObject = (View)this.KRr.get(Integer.valueOf(j));
      localObject = (LinearLayout)localObject;
      ((LinearLayout)localObject).getChildAt(0).setTag(((SnsInfo)localLinkedList.get(i)).getLocalid());
      localSnsInfo2 = (SnsInfo)localLinkedList.get(i);
      localTextView = (TextView)((LinearLayout)localObject).findViewById(i.f.sns_notify_tips2);
      if (localSnsInfo2.getTypeFlag() != 15) {
        break label597;
      }
      localTextView.setText(i.j.sns_post_sight_error);
    }
    for (;;)
    {
      this.KRn.KRD.addView((View)localObject);
      i += 1;
      break label357;
      i = 8;
      break;
      label540:
      localObject = (LinearLayout)ad.kS(this.context).inflate(i.g.header_error_list, null);
      ((LinearLayout)localObject).getChildAt(0).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98714);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsHeader$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
          if ((paramAnonymousView.getTag() instanceof String))
          {
            Object localObject2 = (String)paramAnonymousView.getTag();
            Log.i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(localObject2)));
            paramAnonymousView = aj.fOI().bbl((String)localObject2);
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
              localObject2 = com.tencent.mm.modelsns.l.wO(726);
              ((com.tencent.mm.modelsns.l)localObject2).wR(k).wR(i).wR(paramAnonymousView.getCreateTime());
              ((com.tencent.mm.modelsns.l)localObject2).bpa();
              localObject2 = SnsHeader.i(SnsHeader.this);
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
              com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/sns/ui/SnsHeader$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/sns/ui/SnsHeader$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
          try
          {
            localObject1 = (cvu)new cvu().parseFrom(paramAnonymousView.field_postBuf);
            if ((((cvu)localObject1).TEj == 201) || (((cvu)localObject1).TEj == 210) || (((cvu)localObject1).TEj != 211))
            {
              ((cvu)localObject1).TEr = true;
              paramAnonymousView.setPostBuf(((cvu)localObject1).toByteArray());
              aj.fOI().d(paramAnonymousView.localid, paramAnonymousView);
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
      this.KRr.put(Integer.valueOf(j), localObject);
      break label441;
      label597:
      if (localSnsInfo2.getTypeFlag() == 2) {
        localTextView.setText(i.j.sns_post_text_error);
      } else if (localSnsInfo2.getTypeFlag() == 1) {
        localTextView.setText(i.j.sns_post_error);
      } else if (localSnsInfo2.getTypeFlag() == 26) {
        localTextView.setText(i.j.sns_post_note_error);
      } else if (localSnsInfo2.getTypeFlag() == 28) {
        localTextView.setText(i.j.sns_post_finder_media_error);
      } else {
        localTextView.setText(i.j.sns_post_link_error);
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
  
  public final boolean gE(View paramView)
  {
    AppMethodBeat.i(196685);
    View localView = getFinderSnsRecyclerView();
    if (localView == null)
    {
      AppMethodBeat.o(196685);
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
      int j = (int)(paramView.bottom - this.context.getResources().getDimension(i.d.Edge_2A));
      if ((bool) && (j > i))
      {
        AppMethodBeat.o(196685);
        return true;
        i = 0;
        break;
      }
      AppMethodBeat.o(196685);
      return false;
      AppMethodBeat.o(196685);
      return false;
    }
  }
  
  public View getFinderSnsRecyclerView()
  {
    AppMethodBeat.i(196680);
    if ((this.KRn != null) && (this.KRn.KRJ != null))
    {
      View localView = this.KRn.KRJ.ejd();
      AppMethodBeat.o(196680);
      return localView;
    }
    AppMethodBeat.o(196680);
    return null;
  }
  
  public int getLoadingGroupHeight()
  {
    AppMethodBeat.i(196745);
    int j = 0;
    int i = j;
    if (this.KRn != null)
    {
      i = j;
      if (this.KRn.KRH != null) {
        i = this.KRn.KRH.getHeight() + aw.fromDPToPix(getContext(), 32);
      }
    }
    AppMethodBeat.o(196745);
    return i;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(98725);
    if ((this.KRn != null) && (this.KRn.KRE != null) && (this.KRu)) {
      this.KRn.KRE.gbm();
    }
    if ((this.KRn != null) && (this.KRn.KRF != null) && (!this.KRu))
    {
      SnsStoryHeaderView localSnsStoryHeaderView = this.KRn.KRF;
      Log.i("MicroMsg.SnsStoryHeaderView", "resume: ");
      localSnsStoryHeaderView.fEs = false;
      ((e)com.tencent.mm.kernel.h.ag(e.class)).getContactFetcher().gbH();
      localSnsStoryHeaderView.post(new SnsStoryHeaderView.2(localSnsStoryHeaderView));
    }
    if ((this.type == 1) && (this.KRn != null) && (this.KRn.KRK != null) && (this.KRn.KRJ != null))
    {
      if (!fWo())
      {
        this.KRn.KRK.removeAllViews();
        this.KRn.KRK.setPadding(0, (int)this.context.getResources().getDimension(i.d.Edge_4A), 0, 0);
        if (this.KRn.KRF != null) {
          this.KRn.KRF.setTopLineVisibility(0);
        }
        Log.i("MicroMsg.SnsHeader", "disable2 finderSnsHeader");
        AppMethodBeat.o(98725);
        return;
      }
      this.KRn.KRJ.eje();
    }
    AppMethodBeat.o(98725);
  }
  
  public void setAvatarOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98722);
    if ((this.KRn != null) && (this.KRn.jiu != null)) {
      this.KRn.jiu.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98722);
  }
  
  public void setBackClickListener(a parama)
  {
    this.KRo = parama;
  }
  
  public void setEnterObjectId(String paramString)
  {
    AppMethodBeat.i(98720);
    this.Khd = paramString;
    if ((this.KRn != null) && (this.KRn.KRF != null) && (!this.KRu)) {
      this.KRn.KRF.setEnterObjectId(paramString);
    }
    AppMethodBeat.o(98720);
  }
  
  public void setHeadBgListener(b paramb)
  {
    this.KRp = paramb;
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(98719);
    this.sessionId = paramString;
    if ((this.KRn != null) && (this.KRn.KRF != null) && (!this.KRu)) {
      this.KRn.KRF.setSessionId(paramString);
    }
    AppMethodBeat.o(98719);
  }
  
  public void setStoryAction(SnsStoryHeaderView.a parama)
  {
    AppMethodBeat.i(98718);
    if ((this.KRn != null) && (this.KRn.KRF != null) && (!this.KRu)) {
      this.KRn.KRF.setStoryAction(parama);
    }
    AppMethodBeat.o(98718);
  }
  
  public static abstract interface a
  {
    public abstract boolean Rk(long paramLong);
    
    public abstract boolean fWr();
  }
  
  public static abstract interface b {}
  
  final class c
  {
    TextView KBk;
    ImageView KRA;
    ImageView KRB;
    LinearLayout KRC;
    LinearLayout KRD;
    AbsStoryHeaderTipView KRE;
    SnsStoryHeaderView KRF;
    RelativeLayout KRG;
    LinearLayout KRH;
    ImageView KRI;
    ac KRJ;
    ViewGroup KRK;
    ImageView jiu;
    TextView rUM;
    
    c() {}
  }
  
  final class d
    implements Comparator<SnsInfo>
  {
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader
 * JD-Core Version:    0.7.0.1
 */