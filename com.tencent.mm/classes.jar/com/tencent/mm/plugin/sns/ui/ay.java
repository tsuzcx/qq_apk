package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.d.a.a;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.a;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.b;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.smiley.u;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class ay
  implements View.OnClickListener
{
  private SnsInfo PJQ;
  private l PYh;
  private c.b PYj;
  private com.tencent.mm.plugin.sns.ad.timeline.a.a.c QaL;
  private RoundedCornerFrameLayout RjY;
  private ImageView RjZ;
  private TextView Rka;
  private TextView Rkb;
  public Button Rkc;
  private View Rkd;
  private View Rke;
  private View Rkf;
  private ADXml.AdCardActionBtnInfo Rkg;
  private b Rkh;
  private int Rki;
  private int Rkj;
  c.a Rkk;
  private View mContentView;
  private Context mContext;
  private int xOq;
  
  public ay(Context paramContext, View paramView, int paramInt, l paraml, c.b paramb)
  {
    AppMethodBeat.i(308376);
    this.Rki = 0;
    this.Rkj = 0;
    this.Rkk = new c.a()
    {
      public final void a(AdClickActionInfo paramAnonymousAdClickActionInfo)
      {
        AppMethodBeat.i(308157);
        if ((paramAnonymousAdClickActionInfo == null) || (ay.d(ay.this) == null))
        {
          Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "adCardActionBtnInfo or mActionBtn is null, can not updateActionBtnTitle");
          AppMethodBeat.o(308157);
          return;
        }
        switch (paramAnonymousAdClickActionInfo.PLm)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(308157);
          return;
          if (!Util.isNullOrNil(paramAnonymousAdClickActionInfo.PLq))
          {
            ay.d(ay.this).setTextColor(-7829368);
            ay.d(ay.this).setText(paramAnonymousAdClickActionInfo.PLq);
            ay.d(ay.this).setEnabled(false);
            AppMethodBeat.o(308157);
            return;
            paramAnonymousAdClickActionInfo = paramAnonymousAdClickActionInfo.PLG;
            if (!Util.isNullOrNil(paramAnonymousAdClickActionInfo))
            {
              ay.d(ay.this).setText(paramAnonymousAdClickActionInfo);
              AppMethodBeat.o(308157);
              return;
              ay.this.Y(ay.e(ay.this));
              AppMethodBeat.o(308157);
              return;
              if ((ay.e(ay.this) != null) && (paramAnonymousAdClickActionInfo.PMg != null))
              {
                paramAnonymousAdClickActionInfo = com.tencent.mm.plugin.sns.ad.d.a.a(t.uA(ay.e(ay.this).field_snsId), paramAnonymousAdClickActionInfo.PMg);
                ay.a(ay.this, paramAnonymousAdClickActionInfo);
              }
            }
          }
        }
      }
    };
    Log.d("MicroMsg.SnsAdCardActionBtnCtrl", "init, source=" + paramInt + ", context=" + paramContext + ", static=" + paraml);
    this.mContext = paramContext;
    this.xOq = paramInt;
    this.PYh = paraml;
    this.PYj = paramb;
    this.mContentView = paramView;
    this.Rkf = this.mContentView.findViewById(b.f.action_btn_layout_sell_point);
    this.Rkf.setVisibility(4);
    this.Rke = paramView.findViewById(b.f.action_btn_layout_normal);
    this.Rke.setVisibility(0);
    this.Rkd = this.mContentView.findViewById(b.f.media_container);
    this.RjY = ((RoundedCornerFrameLayout)this.Rke.findViewById(b.f.action_icon_container));
    this.RjZ = ((ImageView)this.Rke.findViewById(b.f.action_icon));
    this.Rka = ((TextView)this.Rke.findViewById(b.f.action_title_txt));
    this.Rkb = ((TextView)this.Rke.findViewById(b.f.action_desc_txt));
    this.Rkc = ((Button)this.Rke.findViewById(b.f.action_btn));
    this.Rkc.setOnClickListener(this);
    this.RjY.setRadius(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 4));
    this.QaL = new com.tencent.mm.plugin.sns.ad.timeline.a.a.c(this.mContext, this.xOq, this.PYh, this.Rkk, new c.b()
    {
      public final void hbt()
      {
        AppMethodBeat.i(308609);
        if (ay.a(ay.this) != null) {
          ay.a(ay.this).hbt();
        }
        AppMethodBeat.o(308609);
      }
      
      public final ViewGroup hbu()
      {
        AppMethodBeat.i(308611);
        ViewGroup localViewGroup = (ViewGroup)ay.b(ay.this);
        AppMethodBeat.o(308611);
        return localViewGroup;
      }
    });
    AppMethodBeat.o(308376);
  }
  
  private static void a(String paramString1, String paramString2, TextView paramTextView1, TextView paramTextView2)
  {
    AppMethodBeat.i(308392);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramTextView1.setText(u.iVt().a(paramTextView1.getContext(), paramString1, paramTextView1.getTextSize()));
      paramTextView1.setVisibility(0);
      paramTextView1.setTypeface(Typeface.defaultFromStyle(1));
      if (!TextUtils.isEmpty(paramString2))
      {
        paramTextView2.setText(u.iVt().a(paramTextView2.getContext(), paramString2, paramTextView2.getTextSize()));
        paramTextView2.setVisibility(0);
        AppMethodBeat.o(308392);
        return;
      }
      paramTextView2.setVisibility(8);
      AppMethodBeat.o(308392);
      return;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramTextView1.setText(u.iVt().a(paramTextView1.getContext(), paramString2, paramTextView1.getTextSize()));
      paramTextView1.setVisibility(0);
      paramTextView1.setTypeface(Typeface.defaultFromStyle(0));
    }
    for (;;)
    {
      paramTextView2.setVisibility(8);
      AppMethodBeat.o(308392);
      return;
      paramTextView1.setVisibility(8);
    }
  }
  
  public static boolean a(SnsInfo paramSnsInfo, Context paramContext)
  {
    AppMethodBeat.i(308388);
    if ((paramSnsInfo == null) || (paramSnsInfo.getAdXml() == null))
    {
      AppMethodBeat.o(308388);
      return false;
    }
    if ((paramSnsInfo.getAdXml().adSellingPointInfo != null) && (!m.jP(paramContext)))
    {
      AppMethodBeat.o(308388);
      return true;
    }
    AppMethodBeat.o(308388);
    return false;
  }
  
  public static void b(SnsInfo paramSnsInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(308385);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(308385);
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("snsid", t.uA(paramSnsInfo.field_snsId));
      localJSONObject.put("uxinfo", paramSnsInfo.getUxinfo());
      localJSONObject.put("scene", paramInt1);
      paramSnsInfo = new JSONObject();
      paramSnsInfo.put("switchCount", paramInt2);
      localJSONObject.put("extInfo", paramSnsInfo);
      paramSnsInfo = localJSONObject.toString();
      Log.d("MicroMsg.SnsAdCardActionBtnCtrl", "reportChangeCount:".concat(String.valueOf(paramSnsInfo)));
      m.lU("timeline_sellingpoint_report", paramSnsInfo);
      AppMethodBeat.o(308385);
      return;
    }
    catch (Exception paramSnsInfo)
    {
      Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "reportChangeCount, exp=" + paramSnsInfo.toString());
      AppMethodBeat.o(308385);
    }
  }
  
  private void baC(String paramString)
  {
    AppMethodBeat.i(308378);
    if ((this.Rkg != null) && (this.Rkg.clickActionInfo != null) && (this.Rkg.clickActionInfo.PMg != null))
    {
      if ("0".equals(paramString))
      {
        this.Rkc.setText(this.Rkg.btnTitle);
        Ed(true);
        AppMethodBeat.o(308378);
        return;
      }
      if ("1".equals(paramString))
      {
        this.Rkc.setText(this.Rkg.clickActionInfo.PMg.PLd);
        Ed(true);
        this.Rkc.setTextColor(this.mContext.getResources().getColor(b.c.BW_0_Alpha_0_2));
        AppMethodBeat.o(308378);
        return;
      }
      if ("1000".equals(paramString))
      {
        this.Rkc.setText(this.Rkg.clickActionInfo.PMg.PLj);
        Ed(false);
      }
    }
    AppMethodBeat.o(308378);
  }
  
  private int getScene()
  {
    if (this.xOq == 0) {
      return 1;
    }
    return 2;
  }
  
  private void hnm()
  {
    AppMethodBeat.i(308382);
    this.Rki = 0;
    long l = 0L;
    if (this.PJQ != null) {
      l = this.PJQ.field_snsId;
    }
    ay.c.c(getScene(), l, this.Rki);
    AppMethodBeat.o(308382);
  }
  
  public final void Ed(boolean paramBoolean)
  {
    AppMethodBeat.i(308408);
    try
    {
      if (this.Rkc != null)
      {
        this.Rkc.setEnabled(paramBoolean);
        if (paramBoolean)
        {
          this.Rkc.setTextColor(this.mContext.getResources().getColor(b.c.blue_text_color));
          return;
        }
        this.Rkc.setTextColor(this.mContext.getResources().getColor(b.c.BW_0_Alpha_0_2));
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(308408);
    }
  }
  
  public final void Y(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(98297);
    if (paramSnsInfo == null)
    {
      Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "refreshUI, snsInfo==null");
      AppMethodBeat.o(98297);
      return;
    }
    this.PJQ = paramSnsInfo;
    this.Rkg = paramSnsInfo.getAdXml().adCardActionBtnInfo;
    if (this.Rkg != null)
    {
      this.QaL.a(this.Rkg.clickActionInfo, this.PJQ, 0);
      System.currentTimeMillis();
      a(paramSnsInfo.getAdXml().adCardTitle, paramSnsInfo.getAdXml().adCardDesc, this.Rka, this.Rkb);
      try
      {
        this.Rkc.setTextColor(this.mContext.getResources().getColor(b.c.blue_text_color));
        this.Rkc.setEnabled(true);
        if (this.Rkg.clickActionInfo.PLm == 2)
        {
          if (TextUtils.isEmpty(this.Rkc.getText().toString())) {
            this.Rkc.setText(this.Rkg.btnTitle);
          }
          new a(this.Rkc, this.Rkg.clickActionInfo.PLC, this.Rkg.clickActionInfo.PLB, this.Rkg.btnTitle).execute(new Void[0]);
          if ((TextUtils.isEmpty(this.Rkg.iconUrl)) || (m.jP(this.mContext))) {
            break label872;
          }
          this.RjY.setVisibility(0);
          com.tencent.mm.plugin.sns.ad.j.c.o(this.Rkg.iconUrl, this.RjZ);
          if (!a(paramSnsInfo, this.mContext)) {
            break label993;
          }
          Object localObject1 = paramSnsInfo.getAdXml().adSellingPointInfo;
          this.Rkf.setVisibility(0);
          localRoundedCornerFrameLayout = (RoundedCornerFrameLayout)this.Rkf.findViewById(b.f.action_icon_container);
          localRoundedCornerFrameLayout.setRadius(com.tencent.mm.cd.a.fromDPToPix(this.mContext, 4));
          ImageView localImageView = (ImageView)this.Rkf.findViewById(b.f.action_icon);
          TextView localTextView1 = (TextView)this.Rkf.findViewById(b.f.action_title_txt);
          TextView localTextView2 = (TextView)this.Rkf.findViewById(b.f.action_desc_txt);
          Button localButton = (Button)this.Rkf.findViewById(b.f.action_btn);
          localButton.setVisibility(4);
          localButton.setEnabled(false);
          if ((this.Rkc != null) && (this.Rkc.getText() != null)) {
            localButton.setText(this.Rkc.getText());
          }
          a(((e)localObject1).title, ((e)localObject1).description, localTextView1, localTextView2);
          if (TextUtils.isEmpty(((e)localObject1).iconUrl)) {
            break label884;
          }
          localRoundedCornerFrameLayout.setVisibility(0);
          com.tencent.mm.plugin.sns.ad.j.c.o(((e)localObject1).iconUrl, localImageView);
          localObject1 = new WeakReference(this);
          if (this.Rkh != null) {
            break label893;
          }
          this.Rkh = new b((WeakReference)localObject1, paramSnsInfo.getSnsId());
          Log.d("MicroMsg.SnsAdCardActionBtnCtrl", "anim started");
          b.a(this.Rkh).start();
          hnm();
          dp(1.0F);
          jdMethod_do(0.0F);
          AppMethodBeat.o(98297);
        }
      }
      finally
      {
        label633:
        String str2;
        for (;;)
        {
          RoundedCornerFrameLayout localRoundedCornerFrameLayout;
          Log.e("MicroMsg.SnsAdCardActionBtnCtrl", localObject2.toString());
          continue;
          if (this.Rkg.clickActionInfo.PLm == 6)
          {
            try
            {
              String str1 = t.uA(paramSnsInfo.field_snsId);
              if (Util.isNullOrNil(str1)) {
                continue;
              }
              if (!"1".equals(ai.bas(str1))) {
                break label633;
              }
              this.Rkc.setTextColor(-7829368);
              this.Rkc.setText(this.Rkg.clickActionInfo.PLq);
              this.Rkc.setEnabled(false);
              continue;
            }
            finally
            {
              Log.e("MicroMsg.SnsAdCardActionBtnCtrl", localObject3.toString());
            }
            continue;
            this.Rkc.setText(this.Rkg.btnTitle);
          }
          else if (this.Rkg.clickActionInfo.PLm == 7)
          {
            com.tencent.threadpool.h.ahAA.bm(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(308605);
                bx localbx = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
                if ((localbx != null) && (!Util.isNullOrNil(ay.c(ay.this).clickActionInfo.owR))) {
                  MMHandlerThread.postToMainThread(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(307683);
                      if ((this.lMP != null) && (d.rs(this.lMP.field_type)))
                      {
                        ay.d(ay.this).setText(ay.c(ay.this).clickActionInfo.PLG);
                        AppMethodBeat.o(307683);
                        return;
                      }
                      ay.d(ay.this).setText(ay.c(ay.this).btnTitle);
                      AppMethodBeat.o(307683);
                    }
                  });
                }
                AppMethodBeat.o(308605);
              }
            });
          }
          else if (this.Rkg.clickActionInfo.PLm == 13)
          {
            alS(this.Rkj);
            ((y)com.tencent.mm.kernel.h.ax(y.class)).b(this.Rkg.clickActionInfo.finderUsername, new y.a()
            {
              public final void onDone(final ch paramAnonymousch)
              {
                AppMethodBeat.i(308163);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179161);
                    if (paramAnonymousch != null)
                    {
                      int i = paramAnonymousch.dUB();
                      ay.a(ay.this, i);
                      Log.i("MicroMsg.SnsAdCardActionBtnCtrl", "getFinderContact, followFlg=" + i + ", userName=" + paramAnonymousch.getUsername());
                      ay.this.alS(i);
                      AppMethodBeat.o(179161);
                      return;
                    }
                    Log.e("MicroMsg.SnsAdCardActionBtnCtrl", "getFinderContact, iLocalFinderContact==null");
                    AppMethodBeat.o(179161);
                  }
                });
                AppMethodBeat.o(308163);
              }
            });
          }
          else if (this.Rkg.clickActionInfo.PLm == 16)
          {
            str2 = com.tencent.mm.plugin.sns.ad.d.a.a(t.uA(this.PJQ.field_snsId), this.Rkg.clickActionInfo.PMg);
            baC(str2);
            if ((this.Rkg.clickActionInfo.PMg != null) && (!"1000".equals(str2))) {
              com.tencent.mm.plugin.sns.ad.d.a.c(t.uA(this.PJQ.field_snsId), this.PJQ.getUxinfo(), this.Rkg.clickActionInfo.PMg.PKZ, new a.a()
              {
                public final void aw(boolean paramAnonymousBoolean, String paramAnonymousString)
                {
                  AppMethodBeat.i(308160);
                  if (paramAnonymousBoolean) {
                    ay.a(ay.this, paramAnonymousString);
                  }
                  AppMethodBeat.o(308160);
                }
              });
            }
          }
          else
          {
            this.Rkc.setText(this.Rkg.btnTitle);
            continue;
            label872:
            this.RjY.setVisibility(8);
            continue;
            label884:
            localRoundedCornerFrameLayout.setVisibility(8);
          }
        }
        label893:
        if (Util.isEqual(paramSnsInfo.getSnsId(), this.Rkh.PNx))
        {
          this.Rkh.Rks.Rku = str2;
          AppMethodBeat.o(98297);
          return;
        }
        b.a(this.Rkh).cancel();
        this.Rkh = new b(str2, paramSnsInfo.getSnsId());
        Log.d("MicroMsg.SnsAdCardActionBtnCtrl", "anim restarted");
        b.a(this.Rkh).start();
        hnm();
        dp(1.0F);
        jdMethod_do(0.0F);
        AppMethodBeat.o(98297);
        return;
      }
      label993:
      if (this.Rkh != null)
      {
        b.a(this.Rkh).cancel();
        this.Rkh = null;
      }
      hnm();
      dp(1.0F);
      jdMethod_do(0.0F);
      this.Rkf.setVisibility(8);
    }
    AppMethodBeat.o(98297);
  }
  
  public final void alS(int paramInt)
  {
    AppMethodBeat.i(308414);
    if (paramInt == 0)
    {
      this.Rkc.setText(this.Rkg.btnTitle);
      AppMethodBeat.o(308414);
      return;
    }
    this.Rkc.setText(this.Rkg.clickActionInfo.PMf);
    AppMethodBeat.o(308414);
  }
  
  public final void jdMethod_do(float paramFloat)
  {
    AppMethodBeat.i(308418);
    this.Rkf.setAlpha(paramFloat);
    AppMethodBeat.o(308418);
  }
  
  public final void dp(float paramFloat)
  {
    AppMethodBeat.i(308421);
    this.RjY.setAlpha(paramFloat);
    this.Rka.setAlpha(paramFloat);
    this.Rkb.setAlpha(paramFloat);
    AppMethodBeat.o(308421);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98298);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.QaL.jg(paramView);
    int i;
    if (a(this.PJQ, this.mContext))
    {
      if (this.xOq != 0) {
        break label124;
      }
      i = 1;
      if (this.PJQ == null) {
        break label129;
      }
    }
    label129:
    for (long l = this.PJQ.field_snsId;; l = 0L)
    {
      b(this.PJQ, i, ay.c.bc(i, l));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsAdCardActionBtnCtrl", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(98298);
      return;
      label124:
      i = 2;
      break;
    }
  }
  
  public static final class a
    extends AsyncTask<Void, Void, Integer>
  {
    Button QPn;
    String Rkp;
    String appid;
    String bJH;
    
    public a(Button paramButton, String paramString1, String paramString2, String paramString3)
    {
      this.bJH = paramString1;
      this.appid = paramString2;
      this.QPn = paramButton;
      this.Rkp = paramString3;
    }
  }
  
  static final class b
  {
    private static int Rkq = 1000;
    String PNx;
    private AnimatorSet Rkr;
    a<ay> Rks;
    private final Animator.AnimatorListener cip;
    
    public b(WeakReference<ay> paramWeakReference, String paramString)
    {
      AppMethodBeat.i(308255);
      this.cip = new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(308480);
          if (ay.b.b(ay.b.this) == null)
          {
            AppMethodBeat.o(308480);
            return;
          }
          paramAnonymousAnimator = (ay)ay.b.b(ay.b.this).get();
          if (paramAnonymousAnimator != null) {
            ay.f(paramAnonymousAnimator);
          }
          AppMethodBeat.o(308480);
        }
      };
      this.PNx = "";
      AnimatorSet localAnimatorSet = new AnimatorSet();
      this.Rkr = localAnimatorSet;
      this.Rks = new a(paramWeakReference);
      this.PNx = paramString;
      paramWeakReference = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      paramWeakReference.setDuration(Rkq);
      paramWeakReference.setStartDelay(3000L);
      paramWeakReference.addUpdateListener(new b(this.Rks, this.Rkr)
      {
        final void a(ay paramAnonymousay, float paramAnonymousFloat)
        {
          AppMethodBeat.i(308446);
          paramAnonymousay.dp(paramAnonymousFloat);
          AppMethodBeat.o(308446);
        }
      });
      paramString = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      paramString.setStartDelay(Rkq / 2 + 3000);
      paramString.setDuration(Rkq);
      paramString.addListener(this.cip);
      paramString.addUpdateListener(new b(this.Rks, this.Rkr)
      {
        final void a(ay paramAnonymousay, float paramAnonymousFloat)
        {
          AppMethodBeat.i(308463);
          paramAnonymousay.jdMethod_do(paramAnonymousFloat);
          AppMethodBeat.o(308463);
        }
      });
      ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
      localValueAnimator1.setDuration(Rkq);
      localValueAnimator1.setStartDelay(10000L);
      localValueAnimator1.addUpdateListener(new b(this.Rks, this.Rkr)
      {
        final void a(ay paramAnonymousay, float paramAnonymousFloat)
        {
          AppMethodBeat.i(308444);
          paramAnonymousay.jdMethod_do(paramAnonymousFloat);
          AppMethodBeat.o(308444);
        }
      });
      ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator2.setDuration(Rkq);
      localValueAnimator2.setStartDelay(Rkq / 2 + 10000);
      localValueAnimator2.addUpdateListener(new b(this.Rks, this.Rkr)
      {
        final void a(ay paramAnonymousay, float paramAnonymousFloat)
        {
          AppMethodBeat.i(308441);
          paramAnonymousay.dp(paramAnonymousFloat);
          AppMethodBeat.o(308441);
        }
      });
      localValueAnimator2.addListener(this.cip);
      localAnimatorSet.play(paramWeakReference);
      localAnimatorSet.play(paramString);
      localAnimatorSet.play(localValueAnimator1);
      localAnimatorSet.play(localValueAnimator2);
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        private boolean mCanceled;
        
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(308436);
          this.mCanceled = true;
          Log.d("MicroMsg.SnsAdCardActionBtnCtrl", "onAnimationCancel() called with: animation = [" + paramAnonymousAnimator + "]");
          AppMethodBeat.o(308436);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(308438);
          if (!this.mCanceled)
          {
            Log.d("MicroMsg.SnsAdCardActionBtnCtrl", "onAnimationEnd() called and repeat");
            paramAnonymousAnimator.start();
          }
          AppMethodBeat.o(308438);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          this.mCanceled = false;
        }
      });
      AppMethodBeat.o(308255);
    }
    
    static final class a<T>
    {
      WeakReference<T> Rku;
      
      public a(WeakReference<T> paramWeakReference)
      {
        this.Rku = paramWeakReference;
      }
      
      public final T get()
      {
        AppMethodBeat.i(308515);
        if (this.Rku == null)
        {
          AppMethodBeat.o(308515);
          return null;
        }
        Object localObject = this.Rku.get();
        AppMethodBeat.o(308515);
        return localObject;
      }
    }
    
    static abstract class b
      implements ValueAnimator.AnimatorUpdateListener
    {
      ay.b.a<ay> Rks;
      AnimatorSet cis;
      
      public b(ay.b.a<ay> parama, AnimatorSet paramAnimatorSet)
      {
        this.Rks = parama;
        this.cis = paramAnimatorSet;
      }
      
      abstract void a(ay paramay, float paramFloat);
      
      public void onAnimationUpdate(ValueAnimator paramValueAnimator)
      {
        float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
        paramValueAnimator = (ay)this.Rks.get();
        if (paramValueAnimator != null)
        {
          a(paramValueAnimator, f);
          return;
        }
        this.cis.cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ay
 * JD-Core Version:    0.7.0.1
 */