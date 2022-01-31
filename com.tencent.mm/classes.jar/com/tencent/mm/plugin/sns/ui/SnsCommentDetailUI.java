package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.mm.h.a.gn;
import com.tencent.mm.h.a.gp;
import com.tencent.mm.h.a.si;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.b.h.a;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.b.a.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.kernel.j
public class SnsCommentDetailUI
  extends MMActivity
  implements com.tencent.mm.ah.f, h.a, b.b
{
  public static int oWt = 34;
  private String bRV;
  private String bSB = "";
  private String diG;
  private com.tencent.mm.sdk.b.c giK = new SnsCommentDetailUI.6(this);
  private boolean gvn = false;
  private int hQN = 0;
  private com.tencent.mm.ui.widget.b.a iep;
  private View.OnClickListener ifg = new SnsCommentDetailUI.35(this);
  private int ivk;
  private ClipboardManager kgn;
  private View.OnClickListener laS = new SnsCommentDetailUI.39(this);
  private int mScreenHeight;
  private int mScreenWidth;
  private boolean oND;
  private SnsCommentFooter oNF;
  private an oNH;
  private b oNN;
  private com.tencent.mm.plugin.sns.f.b oNO;
  private com.tencent.mm.ui.base.p oNQ = null;
  private View.OnTouchListener oPc = bk.crZ();
  private long oVQ = 0L;
  private long oVR = 0L;
  private View oVS;
  private TextView oVT;
  private LinearLayout oVU;
  private SnsDetailLuckyHeader oVV;
  private ListView oVW;
  private View oVX;
  private View oVY;
  private SnsCommentDetailUI.b oVZ;
  private Dialog oWA = null;
  private boolean oWB = false;
  private boolean oWC = false;
  private String oWD = "";
  private boolean oWE = true;
  private int oWF;
  private ag oWG = new ag();
  private com.tencent.mm.sdk.b.c oWH = new SnsCommentDetailUI.1(this);
  private com.tencent.mm.sdk.b.c oWI = new SnsCommentDetailUI.12(this);
  private com.tencent.mm.sdk.b.c oWJ = new SnsCommentDetailUI.23(this);
  private com.tencent.mm.sdk.b.c oWK = new com.tencent.mm.sdk.b.c() {};
  private c oWL = new c();
  private View.OnClickListener oWM = new SnsCommentDetailUI.36(this);
  private com.tencent.mm.sdk.b.c oWN = new SnsCommentDetailUI.5(this);
  private com.tencent.mm.sdk.b.c oWO = new SnsCommentDetailUI.7(this);
  boolean oWP = false;
  private LinearLayout oWQ = null;
  private boolean oWR = false;
  PhotosContent oWS = null;
  int oWT = 0;
  public am.b.a oWU = new SnsCommentDetailUI.19(this);
  private be oWV = null;
  private ScaleAnimation oWa;
  private ScaleAnimation oWb;
  LinearLayout oWc;
  LinearLayout oWd;
  private LinkedList<btd> oWe;
  private int oWf = -1;
  private boolean oWg = false;
  private aq oWh;
  private String oWi;
  private bd oWj;
  private int oWk = 0;
  private ImageView oWl;
  private j oWm;
  private boolean oWn = false;
  private long oWo = 0L;
  private bf oWp;
  private boolean oWq = false;
  private int oWr;
  private int oWs = 103;
  public int oWu = 210;
  private com.tencent.mm.plugin.sns.ui.b.a.a oWv;
  private com.tencent.mm.plugin.sns.a.b.g oWw;
  private com.tencent.mm.plugin.sns.ui.d.b oWx;
  private SnsTranslateResultView oWy;
  private boolean oWz = false;
  private LinearLayout oom;
  
  private static boolean bIA()
  {
    return (com.tencent.mm.plugin.sns.model.am.a.bEf() & 0x1) <= 0;
  }
  
  private void bIC()
  {
    if ((this.oVX == null) || (this.oVX.getVisibility() == 8)) {
      return;
    }
    this.oVX.startAnimation(this.oWb);
    this.oWb.setAnimationListener(new SnsCommentDetailUI.32(this));
  }
  
  private void bID()
  {
    if ((this.mController.uNh == 1) || (this.oNF.bIJ()))
    {
      this.oWL.run();
      return;
    }
    this.oND = true;
  }
  
  private void bIE()
  {
    if (this.oWl == null) {
      return;
    }
    this.oWl.setPressed(false);
    if (bf.Ma(this.bSB))
    {
      this.oWl.setImageResource(i.e.music_pauseicon);
      return;
    }
    this.oWl.setImageResource(i.e.music_playicon);
  }
  
  private int bIz()
  {
    int j = 0;
    int i = j;
    if (this.oVW != null)
    {
      i = j;
      if (this.oVW.getChildCount() > 1)
      {
        View localView = this.oVW.getChildAt(0);
        i = j;
        if (localView != null) {
          i = localView.getHeight();
        }
      }
    }
    return i;
  }
  
  private static boolean e(LinkedList<btd> paramLinkedList1, LinkedList<btd> paramLinkedList2)
  {
    if ((paramLinkedList1 == null) || (paramLinkedList2 == null)) {
      return false;
    }
    if (paramLinkedList1.size() != paramLinkedList2.size()) {
      return false;
    }
    int j = paramLinkedList1.size();
    int i = 0;
    while (i < j)
    {
      if (!((btd)paramLinkedList1.get(i)).sxM.equals(((btd)paramLinkedList2.get(i)).sxM)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean e(List<btd> paramList, boolean paramBoolean)
  {
    int k = BackwardSupportUtil.b.b(this, 32.0F);
    int m = BackwardSupportUtil.b.b(this, 6.0F);
    int i = BackwardSupportUtil.b.b(this, 10.0F);
    int j = BackwardSupportUtil.b.b(this, 17.0F);
    if (this.oVU == null) {
      return false;
    }
    int n = ((WindowManager)this.mController.uMN.getSystemService("window")).getDefaultDisplay().getWidth();
    float f = getResources().getDimension(i.d.NormalPadding);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[] { Integer.valueOf(n), Float.valueOf(f) });
    f = n - f * 2.0F;
    if (paramList.size() <= 0)
    {
      if (this.oVU.getParent() != null) {
        this.oVU.setVisibility(8);
      }
      this.oVU.removeAllViews();
      this.oVU.setVisibility(8);
      this.oom.setVisibility(8);
      return false;
    }
    this.oVU.getParent();
    this.oVU.removeAllViews();
    this.oVU.setVisibility(0);
    Object localObject1;
    if (this.ivk == 10) {
      if (!this.oWz)
      {
        this.oVU.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_arror);
        this.oVU.setPadding(0, m, 0, m);
        localObject1 = new ImageView(this.mController.uMN);
        if (this.ivk != 10) {
          break label657;
        }
        ((ImageView)localObject1).setImageResource(i.i.friendactivity_likeicon_golden);
      }
    }
    for (;;)
    {
      ((ImageView)localObject1).setPadding(i, j, i, 0);
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 49;
      ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((ImageView)localObject1).setClickable(false);
      ((ImageView)localObject1).setFocusable(false);
      this.oVU.addView((View)localObject1);
      n = com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, oWt);
      j = (int)(f - n) / (m + k);
      i = j;
      if ((int)(f - n) % (m + k) > k) {
        i = j + 1;
      }
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsCommentDetailUI", "guess size %d", new Object[] { Integer.valueOf(i) });
      localObject1 = new h(this.mController.uMN);
      ((h)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((h)localObject1).setLineMaxCounte(i);
      i = 0;
      while (i < paramList.size())
      {
        localObject2 = (btd)paramList.get(i);
        TouchImageView localTouchImageView = new TouchImageView(this.mController.uMN);
        localTouchImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        localTouchImageView.setImageResource(i.e.friendactivity_personalportrait);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(k, k);
        localLayoutParams.setMargins(0, m, m, 0);
        localTouchImageView.setLayoutParams(localLayoutParams);
        localTouchImageView.setTag(((btd)localObject2).sxM);
        a.b.p(localTouchImageView, ((btd)localObject2).sxM);
        localTouchImageView.setOnClickListener(this.ifg);
        ((h)localObject1).addView(localTouchImageView);
        i += 1;
      }
      localObject1 = jv(false);
      if (localObject1 != null)
      {
        if (this.diG.equals(((com.tencent.mm.plugin.sns.storage.n)localObject1).field_userName))
        {
          this.oVU.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_myself);
          break;
        }
        this.oVU.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_arror);
        break;
      }
      this.oVU.setBackgroundResource(i.e.friendactivity_comment_detail_list_golden_arror);
      break;
      this.oVU.setBackgroundResource(i.e.friendactivity_comment_detail_list_);
      break;
      label657:
      ((ImageView)localObject1).setImageResource(i.i.friendactivity_likeicon);
    }
    this.oVU.addView((View)localObject1);
    paramList = this.oom;
    if (paramBoolean) {}
    for (i = 8;; i = 0)
    {
      paramList.setVisibility(i);
      return true;
    }
  }
  
  private com.tencent.mm.plugin.sns.storage.a f(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    if (paramn != null)
    {
      if (getSource() == 2) {
        return paramn.bGc();
      }
      return paramn.bGb();
    }
    return null;
  }
  
  private int getSource()
  {
    if (this.oWF == 16) {
      return 2;
    }
    return 1;
  }
  
  private void ju(boolean paramBoolean)
  {
    this.oWg = false;
    if (this.oNF.bII())
    {
      this.oNF.bIL();
      this.oNF.setCommentHint(getString(i.j.sns_ui_comment));
    }
    this.oNF.jw(false);
    if (paramBoolean) {
      BackwardSupportUtil.c.a(this.oVW);
    }
  }
  
  private com.tencent.mm.plugin.sns.storage.n jv(boolean paramBoolean)
  {
    if (!bk.bl(this.oWi))
    {
      localn = com.tencent.mm.plugin.sns.storage.h.OB(this.oWi);
      if (localn == null)
      {
        if (paramBoolean) {
          Toast.makeText(this, i.j.sns_msg_not_found, 0).show();
        }
        finish();
        return null;
      }
      this.bRV = localn.bGk();
      return localn;
    }
    com.tencent.mm.plugin.sns.storage.n localn = com.tencent.mm.plugin.sns.storage.h.OA(this.bRV);
    if (localn == null)
    {
      finish();
      return null;
    }
    this.oWi = localn.bGE();
    return localn;
  }
  
  private LinearLayout yF(int paramInt)
  {
    if (this.oWQ == null)
    {
      this.oWQ = ((LinearLayout)com.tencent.mm.ui.y.gt(this).inflate(paramInt, null));
      return this.oWQ;
    }
    this.oWP = true;
    return this.oWQ;
  }
  
  public final void Ni(String paramString) {}
  
  public final void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, boolean paramBoolean3, boolean paramBoolean4, int paramInt, long paramLong) {}
  
  public final void bCt() {}
  
  final boolean bIB()
  {
    com.tencent.mm.plugin.sns.storage.n localn = jv(true);
    if (localn == null) {
      return false;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.oVS.toString());
    Object localObject1 = new DisplayMetrics();
    czi().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    this.mScreenWidth = ((DisplayMetrics)localObject1).widthPixels;
    this.mScreenHeight = ((DisplayMetrics)localObject1).heightPixels;
    int i;
    Object localObject5;
    Object localObject2;
    if (this.mScreenHeight < this.mScreenWidth)
    {
      i = this.mScreenHeight;
      this.mScreenWidth = i;
      this.oWr = af.bDN();
      localObject5 = localn.bGe();
      this.ivk = au.b(localn, false);
      localObject1 = (ImageView)this.oVS.findViewById(i.f.album_avatar_iv);
      if ((localObject1 != null) && (localn != null)) {
        break label241;
      }
      localObject2 = new StringBuilder("unknow error ? ");
      if (localObject1 != null) {
        break label229;
      }
      bool = true;
      label179:
      localObject1 = ((StringBuilder)localObject2).append(bool).append(" ");
      if (localn != null) {
        break label235;
      }
    }
    label229:
    label235:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsCommentDetailUI", bool);
      return false;
      i = this.mScreenWidth;
      break;
      bool = false;
      break label179;
    }
    label241:
    ((MaskImageButton)localObject1).wdF = localn.bGE();
    ((ImageView)localObject1).setTag(localn.getUserName());
    Object localObject6;
    label511:
    Object localObject3;
    if ((localn.bFZ() != null) && (localn.bFZ().oBA))
    {
      if (!bk.bl(localn.bFZ().oBC))
      {
        ((ImageView)localObject1).setTag(i.f.sns_prefer_avatar_url, localn.bFZ().oBC);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localn.bFZ().oBC, new SnsCommentDetailUI.20(this, (ImageView)localObject1));
      }
      ((ImageView)localObject1).setOnClickListener(this.oWx.poA);
      localObject2 = (TextView)this.oVS.findViewById(i.f.nickname_tv);
      com.tencent.mm.kernel.g.DQ();
      localObject6 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(localn.getUserName());
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + localn.getUserName() + " " + localn.bGk() + " " + localn.bGx());
      if ((localObject6 != null) && (((ad)localObject6).Bo() == 0))
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[] { localn.getUserName() });
        com.tencent.mm.model.am.a.Hh().a(localn.getUserName(), "", this.oWU);
      }
      if (localObject6 != null) {
        break label1239;
      }
      localObject1 = localn.getUserName();
      localObject3 = bk.aM((String)localObject1, "");
      if (!localn.mG()) {
        break label8730;
      }
      localObject1 = localn.bFZ();
      if (localObject1 == null) {
        break label8730;
      }
      if (!((com.tencent.mm.plugin.sns.storage.b)localObject1).oBA) {
        break label1249;
      }
      localObject3 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).oBB;
    }
    label786:
    label2706:
    label5779:
    label8213:
    label8727:
    label8730:
    for (;;)
    {
      label555:
      ((String)localObject3).length();
      label573:
      label882:
      int k;
      if (this.ivk == 10)
      {
        i = 3;
        localObject1 = new k(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject3));
        ((k)localObject1).a(new o(new com.tencent.mm.plugin.sns.data.a(localn.mG(), ((ad)localObject6).getUsername(), localn.bGE(), 2), this.oWm, i), (CharSequence)localObject3);
        ((TextView)localObject2).setOnTouchListener(new aa());
        ((TextView)localObject2).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        ((TextView)this.oVS.findViewById(i.f.type_desc_tv)).setText("");
        this.oWV = new be(this.oVS);
        if (!localn.mG()) {
          break label1284;
        }
        this.oWV.m(Long.valueOf(localn.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.oWV, 0, this.oWi, localn.field_snsId, f(localn).fVM));
        this.oWV.a(localn.bFZ(), f(localn));
        this.oWV.a(this.oWx.poK, this.oWx.poY);
        this.oWV.setVisibility(0);
        localObject1 = ((bxk)localObject5).tNo;
        this.oVT = ((TextView)this.oVS.findViewById(i.f.desc_tv));
        localObject2 = new ar(this.bRV, localn.bGE(), true, false, 2);
        this.oVT.setTag(localObject2);
        this.iep.c(this.oVT, this.oWx.poC, this.oWx.poz);
        if (!bk.bl((String)localObject1)) {
          break label1296;
        }
        this.oVT.setVisibility(8);
        localObject1 = (ViewStub)this.oVS.findViewById(i.f.images_keeper_li);
        if (!this.oWR) {
          ((ViewStub)localObject1).setLayoutResource(-1);
        }
        switch (this.ivk)
        {
        case 6: 
        case 7: 
        case 8: 
        case 12: 
        default: 
          ((ViewStub)localObject1).setVisibility(8);
          label987:
          if (((ViewStub)localObject1).getLayoutResource() != -1)
          {
            localObject2 = ((ViewStub)localObject1).inflate();
            if (this.oWv != null) {
              this.oWv.f((View)localObject2, this.oVY);
            }
            this.oWR = true;
            k = ((WindowManager)czi().getSystemService("window")).getDefaultDisplay().getWidth();
            if (this.ivk == 6) {
              break label1953;
            }
            if ((this.ivk != 2) && (this.ivk != 3) && (this.ivk != 4) && (this.ivk != 5)) {
              break label3443;
            }
            this.oWS = ((PhotosContent)findViewById(i.f.photo_content));
            if (this.oWS == null) {
              break label3400;
            }
            this.oWS.bHX();
            if (this.ivk != 2) {
              break label1522;
            }
          }
          break;
        }
      }
      label1239:
      label1249:
      label1522:
      for (i = 1;; i = aq.paC[this.ivk])
      {
        j = 0;
        while (j < i)
        {
          localObject1 = (TagImageView)this.oWS.findViewById(aq.paG[j]);
          this.oWS.a((TagImageView)localObject1);
          ((TagImageView)localObject1).setOnClickListener(this.oWx.oPK);
          this.iep.c((View)localObject1, this.oWx.poN, this.oWx.poz);
          j += 1;
        }
        if (localn.getUserName().endsWith("@ad")) {
          break;
        }
        a.b.p((ImageView)localObject1, localn.getUserName());
        break;
        localObject1 = ((ad)localObject6).Bq();
        break label511;
        if ((!bk.bl((String)localObject3)) || (bk.bl(((com.tencent.mm.plugin.sns.storage.b)localObject1).nickname))) {
          break label8730;
        }
        localObject3 = ((com.tencent.mm.plugin.sns.storage.b)localObject1).nickname;
        break label555;
        i = 2;
        break label573;
        this.oWV.setVisibility(8);
        break label786;
        this.oVT.setText((String)localObject1 + " ");
        com.tencent.mm.pluginsdk.ui.d.j.h(this.oVT, 2);
        this.oVT.setVisibility(0);
        break label882;
        ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_imagesline_one);
        break label987;
        ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_imagesline1);
        break label987;
        ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_imagesline2);
        break label987;
        ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_imagesline3);
        break label987;
        ((ViewStub)localObject1).setLayoutResource(i.g.sns_media_sight_item);
        break label987;
        ((ViewStub)localObject1).setLayoutResource(i.g.sns_hb_reward_item);
        break label987;
        ((ViewStub)localObject1).setLayoutResource(i.g.sns_ad_card_layout_item);
        this.oWv = new com.tencent.mm.plugin.sns.ui.b.a.b((bxk)localObject5, localn, this.oWx, this.oWw);
        break label987;
        ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_turn_media);
        this.oWv = new d((bxk)localObject5, localn, this.oWx, this.oWw);
        break label987;
        ((ViewStub)localObject1).setLayoutResource(i.g.sns_timeline_ad_full_card);
        this.oWv = new com.tencent.mm.plugin.sns.ui.b.a.c((bxk)localObject5, localn, this.oWx, this.oWw);
        break label987;
        ((ViewStub)localObject1).setVisibility(8);
        break label1028;
      }
      this.oWS.setImageViewWidth(this.oWr);
      localObject1 = new LinkedList();
      float f2;
      float f1;
      float f3;
      if ((localn.mG()) && (this.ivk == 2))
      {
        localObject2 = localn.bFZ();
        this.oWS.yD(0).setScaleType(QImageView.a.wkS);
        if ((localObject2 != null) && (!((com.tencent.mm.plugin.sns.storage.b)localObject2).bEJ()) && (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh > 0.0F) && (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi > 0.0F))
        {
          f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBj, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBk);
          f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBj, ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBk);
          if (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBg != 0) {
            break label3132;
          }
          f3 = f1;
          f1 = f2;
          if (f2 >= k - com.tencent.mm.cb.a.fromDPToPix(czi(), 50) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding))
          {
            f1 = k - com.tencent.mm.cb.a.fromDPToPix(czi(), 50) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding);
            f3 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh);
          }
          localObject4 = new awf();
          ((awf)localObject4).tsF = f1;
          ((awf)localObject4).tsG = f3;
          ((awf)localObject4).tsH = (((awf)localObject4).tsF * ((awf)localObject4).tsG);
          ((LinkedList)localObject1).add(localObject4);
        }
        if (!bk.bl(((com.tencent.mm.plugin.sns.storage.b)localObject2).oBm))
        {
          localObject4 = this.oWS;
          localObject7 = this.oWS.yD(0);
          com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBm, false, 41, new SnsCommentDetailUI.21(this, (PhotosContent)localObject4, (com.tencent.mm.plugin.sns.storage.b)localObject2, (TagImageView)localObject7));
        }
      }
      this.oVS.addOnAttachStateChangeListener(new SnsCommentDetailUI.22(this, (bxk)localObject5, localn, (LinkedList)localObject1));
      localObject2 = this.oWh;
      Object localObject4 = this.oWS;
      Object localObject7 = localn.bGE();
      i = hashCode();
      int j = this.ivk;
      localn.yr(32);
      ((aq)localObject2).a((PhotosContent)localObject4, (bxk)localObject5, (String)localObject7, i, j, -1, false, az.uBJ, (List)localObject1);
      for (;;)
      {
        label1953:
        localObject4 = (TextView)this.oVS.findViewById(i.f.album_address);
        if (!localn.mG()) {
          break label7519;
        }
        localObject2 = f(localn);
        if (localObject2 == null) {
          break label7509;
        }
        localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject2).oAd;
        localObject2 = ((com.tencent.mm.plugin.sns.storage.a)localObject2).oAe;
        ((TextView)localObject4).setTag(localn.bGE());
        if (bk.bl((String)localObject1)) {
          break label7509;
        }
        if (!bk.bl((String)localObject2)) {
          break label7471;
        }
        ((TextView)localObject4).setVisibility(0);
        label2035:
        ((TextView)localObject4).setText((CharSequence)localObject1);
        ((TextView)localObject4).setClickable(false);
        ((TextView)localObject4).setTextColor(-9211021);
        ((TextView)localObject4).setOnClickListener(this.oWx.poV);
        ((TextView)this.oVS.findViewById(i.f.album_publish_time)).setText(ay.l(czi(), localn.bGx() * 1000L));
        localObject4 = (AsyncTextView)this.oVS.findViewById(i.f.album_ad_tail_desc);
        ((TextView)localObject4).setOnClickListener(this.oWx.poZ);
        ((TextView)localObject4).setVisibility(8);
        localObject7 = (AsyncTextView)this.oVS.findViewById(i.f.album_ad_at_tail);
        ((TextView)localObject7).setOnClickListener(new SnsCommentDetailUI.26(this, localn, (ad)localObject6));
        ((TextView)localObject7).setVisibility(8);
        if (localn.mG())
        {
          localObject6 = f(localn);
          ((TextView)localObject4).setTag(localn.bGE());
          if (((com.tencent.mm.plugin.sns.storage.a)localObject6).oAf != com.tencent.mm.plugin.sns.storage.a.ozR) {
            break label7727;
          }
          if (bk.bl(((com.tencent.mm.plugin.sns.storage.a)localObject6).oAg)) {
            break label7717;
          }
          ((TextView)localObject4).setText(((com.tencent.mm.plugin.sns.storage.a)localObject6).oAg);
          ((TextView)localObject4).setVisibility(0);
          label2250:
          break label8014;
          label2251:
          if ((((TextView)localObject4).getVisibility() != 8) && (bk.bl(((com.tencent.mm.plugin.sns.storage.a)localObject6).oAh)))
          {
            ((TextView)localObject4).setTextColor(getResources().getColor(i.c.sns_word_color));
            ((TextView)localObject4).setOnClickListener(null);
          }
          if ((localn.bGe().tNr.sPK & 0x4) == 0) {
            break label8183;
          }
          ((TextView)localObject7).setTag(localn.bGE());
          ((TextView)localObject7).setVisibility(0);
          ((TextView)localObject7).setText(String.format("%s%s%s", new Object[] { czi().getResources().getString(i.j.sns_ad_at_tips1), localObject3, czi().getResources().getString(i.j.sns_ad_at_tips2) }));
        }
        label2377:
        localObject2 = (TextView)this.oVS.findViewById(i.f.album_from);
        ((TextView)localObject2).setOnTouchListener(new aa());
        localObject1 = com.tencent.mm.plugin.sns.c.a.eUS.n(this, ((bxk)localObject5).tNq.lsK);
        if (((bxk)localObject5).tNr.sPI == 26) {
          localObject1 = getString(i.j.favorite);
        }
        au.a((bxk)localObject5, this);
        if (!com.tencent.mm.plugin.sns.c.a.eUS.ct((String)localObject1)) {
          break label8193;
        }
        ((TextView)localObject2).setVisibility(0);
        localObject1 = new SpannableString(getString(i.j.sns_comefrome) + (String)localObject1);
        ((SpannableString)localObject1).setSpan(new a(), 0, ((SpannableString)localObject1).length(), 33);
        ((TextView)localObject2).setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        if ((((bxk)localObject5).tNq == null) || (!com.tencent.mm.pluginsdk.model.app.g.VR(((bxk)localObject5).tNq.lsK)))
        {
          ((TextView)localObject2).setTextColor(getResources().getColor(i.c.sns_word_color));
          ((TextView)localObject2).setOnTouchListener(null);
        }
        ((TextView)localObject2).setTag(localObject5);
        label2586:
        localObject1 = (TextView)this.oVS.findViewById(i.f.album_del);
        if (!localn.getUserName().equals(this.diG)) {
          break label8203;
        }
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setTag(localn.bGE() + ";" + localn.bGk());
        ((TextView)localObject1).setOnClickListener(new SnsCommentDetailUI.27(this));
        label2672:
        localObject3 = (TextView)this.oVS.findViewById(i.f.with_info_tv);
        localObject4 = com.tencent.mm.plugin.sns.model.aj.p(localn);
        if (localObject4 != null) {
          break label8213;
        }
        ((TextView)localObject3).setVisibility(8);
        this.oWa = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
        this.oWa.setDuration(150L);
        this.oWb = new ScaleAnimation(1.0F, 0.0F, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
        this.oWb.setDuration(150L);
        if (this.oVX == null)
        {
          this.oVX = this.oVS.findViewById(i.f.album_comment_container);
          this.oVX.setVisibility(8);
        }
        this.oWc = ((LinearLayout)this.oVS.findViewById(i.f.album_comment_li));
        this.oWc.setOnClickListener(new SnsCommentDetailUI.29(this, localn));
        this.oWc.setOnTouchListener(this.oPc);
        this.oWd = ((LinearLayout)this.oVS.findViewById(i.f.album_like_img));
        this.oWd.setOnClickListener(new SnsCommentDetailUI.30(this, localn));
        this.oWd.setOnTouchListener(this.oPc);
        localObject1 = (ImageButton)this.oVS.findViewById(i.f.album_show_comment_tv);
        localObject2 = jv(true);
        if ((localObject2 != null) && ((((com.tencent.mm.plugin.sns.storage.n)localObject2).bGz() & 0x1) != 0)) {
          ((ImageButton)localObject1).setVisibility(8);
        }
        if ((localObject2 != null) && (!((com.tencent.mm.plugin.sns.storage.n)localObject2).bGD())) {
          ((ImageButton)localObject1).setVisibility(8);
        }
        localObject2 = (ImageView)this.oWd.findViewById(i.f.album_like_icon);
        localObject3 = (ImageView)this.oWc.findViewById(i.f.album_comment_icon);
        localObject4 = (TextView)this.oWd.findViewById(i.f.album_like_tv);
        localObject5 = (TextView)this.oWc.findViewById(i.f.album_comment_tv);
        if (this.ivk == 10)
        {
          this.oVS.findViewById(i.f.album_comment_container).setBackgroundResource(i.e.friendactivity_comment_frame_bg_golden);
          ((ImageButton)localObject1).setImageResource(i.e.lucky_friendactivity_comment_icon);
          ((ImageView)localObject2).setImageResource(i.e.lucky_friendactivity_comment_likeicon);
          ((ImageView)localObject3).setImageResource(i.e.lucky_friendactivity_comment_writeicon);
          ((TextView)localObject4).setTextColor(getResources().getColor(i.c.sns_lucky_comment));
          ((TextView)localObject5).setTextColor(getResources().getColor(i.c.sns_lucky_comment));
          this.oWd.setBackgroundResource(i.e.lucky_sns_comment_btn_left);
          this.oWc.setBackgroundResource(i.e.lucky_sns_comment_btn_right);
        }
        ((ImageButton)localObject1).setOnClickListener(new SnsCommentDetailUI.31(this, localn, (TextView)localObject4, (TextView)localObject5, (ImageView)localObject2, (ImageView)localObject3));
        return true;
        label3132:
        if (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBg == 1)
        {
          i = k - com.tencent.mm.cb.a.fromDPToPix(czi(), 50) - com.tencent.mm.cb.a.fromDPToPix(czi(), 50) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding);
          j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi / ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh);
          localObject4 = new awf();
          if (i > 0) {
            f2 = i;
          }
          ((awf)localObject4).tsF = f2;
          if (j > 0) {
            f1 = j;
          }
          ((awf)localObject4).tsG = f1;
          ((awf)localObject4).tsH = (((awf)localObject4).tsF * ((awf)localObject4).tsG);
          ((LinkedList)localObject1).add(localObject4);
          break;
        }
        if (((com.tencent.mm.plugin.sns.storage.b)localObject2).oBg != 2) {
          break;
        }
        i = k - com.tencent.mm.cb.a.fromDPToPix(czi(), 50) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding);
        j = (int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBi / ((com.tencent.mm.plugin.sns.storage.b)localObject2).oBh);
        localObject4 = new awf();
        if (i > 0) {
          f2 = i;
        }
        ((awf)localObject4).tsF = f2;
        if (j > 0) {
          f1 = j;
        }
        ((awf)localObject4).tsG = f1;
        ((awf)localObject4).tsH = (((awf)localObject4).tsF * ((awf)localObject4).tsG);
        ((LinkedList)localObject1).add(localObject4);
        break;
        label3400:
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.ivk + ",stub is " + ((ViewStub)localObject1).toString());
        continue;
        label3443:
        if (this.ivk != 10) {
          break label3970;
        }
        this.oWS.bHX();
        localObject1 = (TagImageView)this.oWS.findViewById(i.f.album_img_0);
        this.oWS.a((TagImageView)localObject1);
        ((TagImageView)localObject1).setOnClickListener(this.oWx.oPK);
        localObject2 = localn.bGE();
        localObject4 = new ArrayList();
        ((List)localObject4).add(localObject1);
        localObject7 = new ao();
        ((ao)localObject7).bMB = ((String)localObject2);
        ((ao)localObject7).index = 0;
        ((ao)localObject7).oYz = ((List)localObject4);
        ((ao)localObject7).oVB = true;
        if (localObject1 != null) {
          ((TagImageView)localObject1).setTag(localObject7);
        }
        localObject1 = (TextView)this.oVS.findViewById(i.f.hb_tip);
        if (!com.tencent.mm.model.q.Gj().equals(((bxk)localObject5).hPY))
        {
          localObject2 = com.tencent.mm.plugin.sns.model.aj.q(localn);
          if ((((bto)localObject2).tKm != null) && (((bto)localObject2).tKm.tKO != 0))
          {
            ((TextView)localObject1).setText(getString(i.j.lucky_sns_reward_numbers, new Object[] { Integer.valueOf(((bto)localObject2).tKm.tKO) }));
            ((TextView)localObject1).setVisibility(0);
          }
        }
        for (;;)
        {
          localObject1 = localn.bGw();
          if (localObject1 == null) {
            break label3940;
          }
          if (!com.tencent.mm.model.q.Gj().equals(((bxk)localObject5).hPY)) {
            break label3768;
          }
          localObject1 = this.oWh;
          localObject2 = this.oWS;
          localObject4 = localn.bGE();
          i = hashCode();
          j = this.ivk;
          localn.yr(32);
          ((aq)localObject1).a((PhotosContent)localObject2, (bxk)localObject5, (String)localObject4, i, j, -1, false, az.uBJ, true);
          break;
          ((TextView)localObject1).setVisibility(8);
          continue;
          ((TextView)localObject1).setVisibility(8);
        }
        label3768:
        if (com.tencent.mm.plugin.sns.lucky.a.m.k(localn))
        {
          localObject1 = this.oWh;
          localObject2 = this.oWS;
          localObject4 = localn.bGE();
          i = hashCode();
          j = this.ivk;
          localn.yr(32);
          ((aq)localObject1).a((PhotosContent)localObject2, (bxk)localObject5, (String)localObject4, i, j, -1, false, az.uBJ, false);
        }
        else if (((awe)localObject1).cec == 0)
        {
          localObject1 = this.oWh;
          localObject2 = this.oWS;
          localObject4 = localn.bGE();
          i = hashCode();
          j = this.ivk;
          localn.yr(32);
          ((aq)localObject1).a((PhotosContent)localObject2, (bxk)localObject5, (String)localObject4, i, j, -1, false, az.uBJ, true);
        }
        else
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + ((awe)localObject1).cec);
          continue;
          label3940:
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + localn.bGE());
        }
      }
      label4193:
      Object localObject8;
      if (this.ivk == 9)
      {
        this.oWB = true;
        localObject2 = new aj();
        localObject1 = this.oVS;
        localObject4 = ((View)localObject1).findViewById(i.f.chatting_click_area);
        localObject7 = (com.tencent.mm.plugin.sight.decode.a.a)((View)localObject1).findViewById(i.f.image);
        ((aj)localObject2).oTH = ((View)localObject4);
        ((aj)localObject2).oGT = ((ImageView)((View)localObject1).findViewById(i.f.status_btn));
        ((aj)localObject2).oTI = ((MMPinProgressBtn)((View)localObject1).findViewById(i.f.progress));
        ((aj)localObject2).oGU = ((TextView)((View)localObject1).findViewById(i.f.errorTv));
        ((aj)localObject2).oTJ = ((TextView)((View)localObject1).findViewById(i.f.endtv));
        ((aj)localObject2).ogP = ((com.tencent.mm.plugin.sight.decode.a.a)localObject7);
        ((aj)localObject2).a((bxk)localObject5, 0, localn.bGE(), localn.mG());
        ((aj)localObject2).oGU.setVisibility(8);
        ((aj)localObject2).ogP.setTagObject(localObject2);
        ((View)localObject4).setTag(localObject2);
        ((aj)localObject2).oTH.setOnClickListener(this.oWx.poW);
        if (!localn.bEJ())
        {
          this.iep.c((View)localObject4, this.oWx.poP, this.oWx.poz);
          localObject1 = e.a((bxk)localObject5, ((aj)localObject2).ogP.getUIContext(), localn.mG());
          if (!localn.mG()) {
            break label8727;
          }
          localObject8 = localn.bFZ();
          if ((localObject8 == null) || (!((com.tencent.mm.plugin.sns.storage.b)localObject8).bEJ()) || (((com.tencent.mm.plugin.sns.storage.b)localObject8).oBh <= 0.0F) || (((com.tencent.mm.plugin.sns.storage.b)localObject8).oBi <= 0.0F)) {
            break label8727;
          }
          f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject8).oBh, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject8).oBj, ((com.tencent.mm.plugin.sns.storage.b)localObject8).oBk);
          f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject8).oBi, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject8).oBj, ((com.tencent.mm.plugin.sns.storage.b)localObject8).oBk);
          if (((com.tencent.mm.plugin.sns.storage.b)localObject8).oBg != 0) {
            break label4799;
          }
          f1 = f3;
          if (f3 >= k - com.tencent.mm.cb.a.fromDPToPix(czi(), 50) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding))
          {
            f1 = k - com.tencent.mm.cb.a.fromDPToPix(czi(), 50) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding);
            f2 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject8).oBi * f1 / ((com.tencent.mm.plugin.sns.storage.b)localObject8).oBh);
          }
          localObject1 = Pair.create(Integer.valueOf((int)f1), Integer.valueOf((int)f2));
        }
      }
      for (;;)
      {
        label4422:
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.sight.decode.a.a)localObject7).dL(((Integer)((Pair)localObject1).first).intValue(), ((Integer)((Pair)localObject1).second).intValue());
          localObject8 = ((aj)localObject2).oTJ.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject8).width = ((Integer)((Pair)localObject1).first).intValue();
          ((ViewGroup.LayoutParams)localObject8).height = ((Integer)((Pair)localObject1).second).intValue();
          ((aj)localObject2).oTJ.setLayoutParams((ViewGroup.LayoutParams)localObject8);
        }
        if ((((bxk)localObject5).tNr != null) && (((bxk)localObject5).tNr.sPJ.size() > 0))
        {
          localObject1 = (awd)((bxk)localObject5).tNr.sPJ.get(0);
          label4547:
          if (localn.mG())
          {
            ((aj)localObject2).ogP.setOnCompletionListener(new SnsCommentDetailUI.24(this, localn));
            if (!this.oWw.fG(localn.field_snsId)) {
              ((aj)localObject2).ogP.setOnDecodeDurationListener(new SnsCommentDetailUI.25(this, localn, (aj)localObject2));
            }
          }
          if ((((bxk)localObject5).tNr == null) || (((bxk)localObject5).tNr.sPJ.size() <= 0)) {
            break;
          }
          af.bDC();
          if (com.tencent.mm.plugin.sns.model.g.t((awd)localObject1)) {
            break label5062;
          }
          if (!af.bDC().w((awd)localObject1)) {
            break label4959;
          }
          ((aj)localObject2).oGT.setVisibility(8);
          ((aj)localObject2).oTI.setVisibility(0);
          ((aj)localObject2).oTI.cJO();
          label4684:
          ((com.tencent.mm.plugin.sight.decode.a.a)localObject7).setTagObject(localObject2);
          af.bDC().a(localn, (awd)localObject1, (com.tencent.mm.plugin.sight.decode.a.a)localObject7, hashCode(), 0, az.uBJ, localn.mG());
          ((View)localObject4).setTag(localObject2);
          if (this.oWw == null) {
            break;
          }
          if (!localn.mG()) {
            break label5348;
          }
          if (af.bDC().o(localn) != 5) {
            break label5342;
          }
          bool = true;
        }
        for (;;)
        {
          this.oWw.s(localn.field_snsId, bool);
          break;
          this.iep.c((View)localObject4, this.oWx.poR, this.oWx.poz);
          break label4193;
          label4799:
          if (((com.tencent.mm.plugin.sns.storage.b)localObject8).oBg == 1)
          {
            i = k - com.tencent.mm.cb.a.fromDPToPix(czi(), 50) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding);
            localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject8).oBi / ((com.tencent.mm.plugin.sns.storage.b)localObject8).oBh)));
            break label4422;
          }
          if (((com.tencent.mm.plugin.sns.storage.b)localObject8).oBg != 2) {
            break label8727;
          }
          i = k - com.tencent.mm.cb.a.fromDPToPix(czi(), 50) - getResources().getDimensionPixelSize(i.d.NormalPadding) - getResources().getDimensionPixelSize(i.d.NormalPadding);
          localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject8).oBi / ((com.tencent.mm.plugin.sns.storage.b)localObject8).oBh)));
          break label4422;
          localObject1 = null;
          break label4547;
          label4959:
          if ((localn.mG()) && (af.bDC().o(localn) == 5))
          {
            af.bDC().A((awd)localObject1);
            ((aj)localObject2).oGT.setVisibility(8);
            ((aj)localObject2).oTI.setVisibility(0);
            ((aj)localObject2).oTI.cJO();
            break label4684;
          }
          af.bDC().y((awd)localObject1);
          ((aj)localObject2).oGT.setVisibility(0);
          ((aj)localObject2).oTI.setVisibility(8);
          ((aj)localObject2).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this, i.i.shortvideo_play_btn));
          break label4684;
          label5062:
          if (af.bDC().u((awd)localObject1))
          {
            ((aj)localObject2).oGT.setVisibility(0);
            ((aj)localObject2).oTI.setVisibility(8);
            ((aj)localObject2).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this, i.i.shortvideo_play_btn));
          }
          for (;;)
          {
            if (!((aj)localObject2).ogP.bAY()) {
              break label5340;
            }
            com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsCommentDetailUI", "play video error " + ((awd)localObject1).lsK + " " + ((awd)localObject1).kSC + " " + ((awd)localObject1).trP);
            af.bDC().y((awd)localObject1);
            ((aj)localObject2).oGT.setVisibility(0);
            ((aj)localObject2).oTI.setVisibility(8);
            ((aj)localObject2).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this, i.i.shortvideo_play_btn));
            break;
            if (af.bDC().v((awd)localObject1))
            {
              ((aj)localObject2).oGT.setVisibility(8);
              ((aj)localObject2).oTI.setVisibility(8);
            }
            else if ((localn.mG()) && (af.bDC().o(localn) <= 5))
            {
              ((aj)localObject2).oGT.setVisibility(8);
              ((aj)localObject2).oTI.setVisibility(8);
            }
            else
            {
              af.bDC().y((awd)localObject1);
              ((aj)localObject2).oGT.setVisibility(0);
              ((aj)localObject2).oTI.setVisibility(8);
              ((aj)localObject2).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this, i.i.shortvideo_play_btn));
            }
          }
          label5340:
          break label4684;
          label5342:
          bool = false;
          continue;
          label5348:
          if (af.bDC().n(localn) == 5) {
            bool = true;
          } else {
            bool = false;
          }
        }
        if (this.ivk == 0)
        {
          localObject1 = (LinearLayout)this.oVS.findViewById(i.f.sns_meida_frame);
          localObject2 = yF(i.g.sns_media_sub_item);
          if (!this.oWP)
          {
            ((LinearLayout)localObject1).removeView(this.oWS);
            ((LinearLayout)localObject1).addView((View)localObject2, 3);
            if (((LinearLayout)localObject2).getLayoutParams() == null) {
              break label5764;
            }
          }
          for (localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject2).getLayoutParams());; localObject1 = new LinearLayout.LayoutParams(-1, -2))
          {
            ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
            ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            if (((bxk)localObject5).tNr.sPJ.isEmpty()) {
              break label5779;
            }
            localObject4 = (awd)((bxk)localObject5).tNr.sPJ.get(0);
            localObject1 = (MMImageView)((LinearLayout)localObject2).findViewById(i.f.image_left);
            af.bDC().a((awd)localObject4, (View)localObject1, i.i.app_attach_file_icon_music, hashCode(), az.uBJ);
            this.oWl = ((ImageView)((LinearLayout)localObject2).findViewById(i.f.state));
            this.oWl.setOnTouchListener(this.oPc);
            this.bSB = ((bxk)localObject5).lsK;
            bIE();
            bool = getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false);
            ((MMImageView)localObject1).setTag(new q((bxk)localObject5, this.oWi, bool));
            ((MMImageView)localObject1).setOnClickListener(this.oWp.pka);
            localObject7 = ((awd)localObject4).kRN;
            if (!bk.bl((String)localObject7)) {
              ((TextView)((LinearLayout)localObject2).findViewById(i.f.righttext)).setText((CharSequence)localObject7);
            }
            localObject4 = ((awd)localObject4).bGw;
            if (!bk.bl((String)localObject4)) {
              ((TextView)((LinearLayout)localObject2).findViewById(i.f.titletext)).setText(new SpannableString((CharSequence)localObject4), TextView.BufferType.SPANNABLE);
            }
            ((LinearLayout)localObject2).setTag(new q((bxk)localObject5, this.oWi));
            this.iep.c((View)localObject2, this.oWx.poO, this.oWx.poz);
            ((LinearLayout)localObject2).setOnClickListener(this.oWp.pbU);
            com.tencent.mm.plugin.sns.data.i.b((View)localObject1, this);
            break;
          }
          ((LinearLayout)localObject2).setVisibility(8);
          break;
        }
        if (this.ivk == 13)
        {
          this.oVT.setVisibility(8);
          this.oVY.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          break;
        }
        if ((this.ivk == 11) || (this.ivk == 14)) {
          break;
        }
        localObject1 = (LinearLayout)this.oVS.findViewById(i.f.sns_meida_frame);
        localObject7 = yF(i.g.sns_media_link_item);
        localObject8 = (MMImageView)((LinearLayout)localObject7).findViewById(i.f.image_left);
        if (!this.oWP)
        {
          ((LinearLayout)localObject1).removeView(this.oWS);
          ((LinearLayout)localObject1).addView((View)localObject7, 3);
          if (((LinearLayout)localObject7).getLayoutParams() != null)
          {
            localObject1 = new LinearLayout.LayoutParams(((LinearLayout)localObject7).getLayoutParams());
            label5928:
            ((LinearLayout.LayoutParams)localObject1).setMargins(((LinearLayout.LayoutParams)localObject1).leftMargin, com.tencent.mm.cb.a.fromDPToPix(this, 12), ((LinearLayout.LayoutParams)localObject1).rightMargin, ((LinearLayout.LayoutParams)localObject1).bottomMargin);
            ((LinearLayout)localObject7).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
        else
        {
          i = 0;
          if (!localn.mG()) {
            break label6359;
          }
          if (localn.bFZ().bEI())
          {
            i = 1;
            ((LinearLayout)localObject7).setTag(localn);
            ((LinearLayout)localObject7).setTag(i.f.link_ad_left_iv, localObject8);
            ((LinearLayout)localObject7).setOnClickListener(this.oWx.ppk);
          }
          j = 0;
        }
        for (;;)
        {
          if (i != 0)
          {
            this.iep.c((View)localObject7, this.oWx.poS, this.oWx.poz);
            label6046:
            if (!bIA()) {
              break label7080;
            }
            localObject1 = au.Pq(((bxk)localObject5).tNr.kSC);
            label6065:
            localObject2 = ((bxk)localObject5).tNr.bGw;
            if (i == 0) {
              break label8715;
            }
            localObject1 = ((bxk)localObject5).tNr.kRN;
          }
          for (;;)
          {
            ((LinearLayout)localObject7).findViewById(i.f.state).setVisibility(8);
            if (!((bxk)localObject5).tNr.sPJ.isEmpty())
            {
              ((MMImageView)localObject8).setVisibility(0);
              localObject4 = (awd)((bxk)localObject5).tNr.sPJ.get(0);
              if (((bxk)localObject5).tNr.sPI == 15)
              {
                ((ImageView)((LinearLayout)localObject7).findViewById(i.f.state)).setImageResource(i.e.music_playicon);
                ((ImageView)((LinearLayout)localObject7).findViewById(i.f.state)).setVisibility(0);
                af.bDC().a((awd)localObject4, (View)localObject8, i.i.app_attach_file_icon_video, hashCode(), az.cuY().Fp(((bxk)localObject5).mPL));
                localObject4 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject4;
                label6225:
                com.tencent.mm.plugin.sns.data.i.b((View)localObject8, this);
                if (((bxk)localObject5).tNr.sPI != 15) {
                  break label8712;
                }
                localObject2 = "";
                localObject1 = getString(i.j.sns_folder_sight_title);
              }
            }
            for (;;)
            {
              if (!bk.bl((String)localObject2))
              {
                ((LinearLayout)localObject7).findViewById(i.f.righttext).setVisibility(0);
                ((TextView)((LinearLayout)localObject7).findViewById(i.f.righttext)).setText((CharSequence)localObject2);
              }
              for (;;)
              {
                localObject2 = (TextView)((LinearLayout)localObject7).findViewById(i.f.titletext);
                if (bk.bl((String)localObject1)) {
                  break label7461;
                }
                ((TextView)localObject2).setVisibility(0);
                if (j == 0) {
                  break label7451;
                }
                ((TextView)localObject2).setText(com.tencent.mm.plugin.sns.data.i.a((String)localObject1, czi(), (TextView)localObject2));
                break;
                localObject1 = new LinearLayout.LayoutParams(-1, -2);
                break label5928;
                label6359:
                if (((bxk)localObject5).tNr.sPI == 9)
                {
                  if (((bxk)localObject5).tNr.sPJ.size() <= 0) {
                    break label8718;
                  }
                  ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                  ((LinearLayout)localObject7).setOnClickListener(this.oWp.pjU);
                  i = 0;
                  j = 0;
                  break label6018;
                }
                if (((bxk)localObject5).tNr.sPI == 10)
                {
                  if (((bxk)localObject5).tNr.sPJ.size() <= 0) {
                    break label8718;
                  }
                  ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                  ((LinearLayout)localObject7).setOnClickListener(this.oWp.pjW);
                  i = 0;
                  j = 0;
                  break label6018;
                }
                if (((bxk)localObject5).tNr.sPI == 17)
                {
                  if (((bxk)localObject5).tNr.sPJ.size() <= 0) {
                    break label8718;
                  }
                  ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                  ((LinearLayout)localObject7).setOnClickListener(this.oWp.pjX);
                  i = 0;
                  j = 0;
                  break label6018;
                }
                if (((bxk)localObject5).tNr.sPI == 22)
                {
                  if (((bxk)localObject5).tNr.sPJ.size() <= 0) {
                    break label8718;
                  }
                  ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                  ((LinearLayout)localObject7).setOnClickListener(this.oWp.pjY);
                  i = 0;
                  j = 0;
                  break label6018;
                }
                if (((bxk)localObject5).tNr.sPI == 23)
                {
                  if (((bxk)localObject5).tNr.sPJ.size() <= 0) {
                    break label8718;
                  }
                  ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                  ((LinearLayout)localObject7).setOnClickListener(this.oWp.pjZ);
                  i = 0;
                  j = 0;
                  break label6018;
                }
                if (((bxk)localObject5).tNr.sPI == 14)
                {
                  if (((bxk)localObject5).tNr.sPJ.size() <= 0) {
                    break label8718;
                  }
                  ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                  ((LinearLayout)localObject7).setOnClickListener(this.oWp.pjV);
                  i = 0;
                  j = 0;
                  break label6018;
                }
                if (((bxk)localObject5).tNr.sPI == 12)
                {
                  if (((bxk)localObject5).tNr.sPJ.size() <= 0) {
                    break label8718;
                  }
                  ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                  ((LinearLayout)localObject7).setOnClickListener(this.oWp.pkd);
                  i = 0;
                  j = 0;
                  break label6018;
                }
                if (((bxk)localObject5).tNr.sPI == 13)
                {
                  if (((bxk)localObject5).tNr.sPJ.size() <= 0) {
                    break label8718;
                  }
                  ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                  ((LinearLayout)localObject7).setOnClickListener(this.oWp.pke);
                  i = 0;
                  j = 0;
                  break label6018;
                }
                if (((bxk)localObject5).tNr.sPI == 15)
                {
                  if (((bxk)localObject5).tNr.sPJ.size() <= 0) {
                    break label8718;
                  }
                  ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                  ((LinearLayout)localObject7).setOnClickListener(this.oWx.poX);
                  i = 0;
                  j = 0;
                  break label6018;
                }
                if (((bxk)localObject5).tNr.sPI == 26)
                {
                  ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                  ((LinearLayout)localObject7).setOnClickListener(this.oWp.pkf);
                  i = 0;
                  j = 0;
                  break label6018;
                }
                ((LinearLayout)localObject7).setTag(new q((bxk)localObject5, this.oWi));
                ((LinearLayout)localObject7).setOnClickListener(this.oWp.pbU);
                if ((((bxk)localObject5).dQA & 0x1) <= 0) {
                  break label8718;
                }
                i = 0;
                j = 1;
                break label6018;
                this.iep.c((View)localObject7, this.oWx.poO, this.oWx.poz);
                break label6046;
                label7080:
                localObject1 = "";
                break label6065;
                if (((bxk)localObject5).tNr.sPI == 5)
                {
                  localObject2 = au.Pq(((awd)localObject4).kSC);
                  localObject1 = ((awd)localObject4).bGw;
                  ((LinearLayout)localObject7).findViewById(i.f.state).setVisibility(0);
                  af.bDC().a((awd)localObject4, (View)localObject8, i.i.app_attach_file_icon_video, hashCode(), az.uBJ);
                  break label6225;
                }
                if (((bxk)localObject5).tNr.sPI == 18)
                {
                  ((LinearLayout)localObject7).findViewById(i.f.state).setVisibility(0);
                  ((ImageView)((LinearLayout)localObject7).findViewById(i.f.state)).setImageResource(i.e.video_playicon_normal);
                  ((MMImageView)localObject8).setVisibility(0);
                  af.bDC().a((awd)localObject4, (View)localObject8, i.i.app_attach_file_icon_video, hashCode(), az.uBJ);
                  localObject4 = localObject1;
                  localObject1 = localObject2;
                  localObject2 = localObject4;
                  break label6225;
                }
                af.bDC().b((awd)localObject4, (View)localObject8, hashCode(), az.uBJ);
                localObject4 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject4;
                break label6225;
                if (((bxk)localObject5).tNr.sPI == 18)
                {
                  ((ImageView)((LinearLayout)localObject7).findViewById(i.f.state)).setVisibility(0);
                  ((ImageView)((LinearLayout)localObject7).findViewById(i.f.state)).setImageResource(i.e.video_playicon_normal);
                  ((MMImageView)localObject8).setVisibility(0);
                  af.bDC().a((View)localObject8, -1, i.i.app_attach_file_icon_video, hashCode());
                  localObject4 = localObject1;
                  localObject1 = localObject2;
                  localObject2 = localObject4;
                  break label6225;
                }
                if (((bxk)localObject5).tNr.sPI == 26)
                {
                  ((MMImageView)localObject8).setVisibility(0);
                  af.bDC().a((View)localObject8, -1, i.i.note_sns_link_default, hashCode());
                  localObject4 = localObject1;
                  localObject1 = localObject2;
                  localObject2 = localObject4;
                  break label6225;
                }
                ((MMImageView)localObject8).setVisibility(0);
                af.bDC().a((View)localObject8, -1, i.i.app_attach_file_icon_webpage, hashCode());
                localObject4 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject4;
                break label6225;
                ((LinearLayout)localObject7).findViewById(i.f.righttext).setVisibility(8);
              }
              label7451:
              ((TextView)localObject2).setText((CharSequence)localObject1);
              break;
              label7461:
              ((TextView)localObject2).setVisibility(8);
              break;
              label7471:
              ((TextView)localObject4).setVisibility(0);
              if (bk.bl((String)localObject1)) {
                break label2035;
              }
              ((TextView)localObject4).setTextColor(-11048043);
              ((TextView)localObject4).setClickable(true);
              ((TextView)localObject4).setText((CharSequence)localObject1);
              break label2056;
              label7509:
              ((TextView)localObject4).setVisibility(8);
              break label2056;
              label7519:
              if (((bxk)localObject5).tNp == null)
              {
                localObject1 = null;
                label7530:
                if (((bxk)localObject5).tNp != null) {
                  break label7590;
                }
              }
              label7590:
              for (localObject2 = null;; localObject2 = ((bxk)localObject5).tNp.lFn)
              {
                ((TextView)localObject4).setTag(localn.bGE());
                if ((!bk.bl((String)localObject1)) || (!bk.bl((String)localObject2))) {
                  break label7603;
                }
                ((TextView)localObject4).setVisibility(8);
                break;
                localObject1 = ((bxk)localObject5).tNp.ffj;
                break label7530;
              }
              label7603:
              ((TextView)localObject4).setVisibility(0);
              if (!bk.bl((String)localObject2))
              {
                ((TextView)localObject4).setTextColor(-11048043);
                ((TextView)localObject4).setClickable(true);
                if ((localn.field_snsId == 0L) && (!bk.bl((String)localObject1)))
                {
                  ((TextView)localObject4).setText((String)localObject1 + "·" + (String)localObject2);
                  break label2056;
                }
                ((TextView)localObject4).setText((CharSequence)localObject2);
                break label2056;
              }
              ((TextView)localObject4).setText((CharSequence)localObject1);
              ((TextView)localObject4).setClickable(false);
              ((TextView)localObject4).setTextColor(-9211021);
              break label2056;
              label7717:
              ((TextView)localObject4).setVisibility(8);
              break label2251;
              label7727:
              if (((com.tencent.mm.plugin.sns.storage.a)localObject6).oAf != com.tencent.mm.plugin.sns.storage.a.ozS) {
                break label2251;
              }
              if (!bk.bl(((com.tencent.mm.plugin.sns.storage.a)localObject6).oAg))
              {
                localObject1 = "";
                localObject8 = ((com.tencent.mm.plugin.sns.storage.a)localObject6).oAi.iterator();
                Object localObject9;
                if (((Iterator)localObject8).hasNext())
                {
                  localObject9 = (String)((Iterator)localObject8).next();
                  localObject2 = this.oWj.abk((String)localObject9);
                  if (localObject2 != null)
                  {
                    localObject2 = ((com.tencent.mm.n.a)localObject2).Bq();
                    if (!bk.bl((String)localObject2)) {
                      localObject2 = (String)localObject1 + (String)localObject2;
                    }
                  }
                  for (;;)
                  {
                    localObject1 = localObject2;
                    if (((com.tencent.mm.plugin.sns.storage.a)localObject6).oAi.getLast() == localObject9) {
                      break;
                    }
                    localObject1 = (String)localObject2 + ",";
                    break;
                    localObject2 = (String)localObject1 + (String)localObject9;
                    continue;
                    localObject2 = (String)localObject1 + (String)localObject9;
                  }
                }
                localObject2 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject6).oAg, new Object[] { localObject1 });
                ((TextView)localObject4).getTextSize();
                localObject8 = new k(com.tencent.mm.pluginsdk.ui.d.j.c(this, (CharSequence)localObject2, 1));
                ((k)localObject8).a(null, (CharSequence)localObject2);
                localObject2 = ((TextView)localObject4).getPaint();
                if (com.tencent.mm.cb.a.ad(this, (int)Layout.getDesiredWidth((CharSequence)localObject8, 0, ((k)localObject8).length(), (TextPaint)localObject2)) > this.oWu)
                {
                  label8014:
                  if (((String)localObject1).length() <= 1) {
                    break label2251;
                  }
                  localObject1 = ((String)localObject1).substring(0, ((String)localObject1).length() - 2);
                  localObject8 = String.format(((com.tencent.mm.plugin.sns.storage.a)localObject6).oAg, new Object[] { (String)localObject1 + "..." });
                  ((TextView)localObject4).getTextSize();
                  localObject9 = new k(com.tencent.mm.pluginsdk.ui.d.j.c(this, (CharSequence)localObject8, 1));
                  ((k)localObject9).a(null, (CharSequence)localObject8);
                  i = com.tencent.mm.cb.a.ad(this, (int)Layout.getDesiredWidth((CharSequence)localObject9, 0, ((k)localObject9).length(), (TextPaint)localObject2));
                  ((TextView)localObject4).setText((CharSequence)localObject9, TextView.BufferType.SPANNABLE);
                  ((TextView)localObject4).setVisibility(0);
                  if (i > this.oWu) {
                    break label2250;
                  }
                  break label2251;
                }
                ((TextView)localObject4).setText((CharSequence)localObject8, TextView.BufferType.SPANNABLE);
                ((TextView)localObject4).setVisibility(0);
                break label2251;
              }
              ((TextView)localObject4).setVisibility(8);
              break label2251;
              label8183:
              ((TextView)localObject7).setVisibility(8);
              break label2377;
              ((TextView)localObject2).setVisibility(8);
              break label2586;
              ((TextView)localObject1).setVisibility(8);
              break label2672;
              label8230:
              if (((bto)localObject4).tKe.size() <= 0) {
                ((TextView)localObject3).setVisibility(8);
              }
              for (;;)
              {
                if ((localObject4 == null) || (this.diG == null) || (!this.diG.equals(((bto)localObject4).sxM)) || (((((bto)localObject4).ttI != 3) || (((bto)localObject4).tKj == null)) && ((((bto)localObject4).ttI != 5) || (((bto)localObject4).tsx == null)))) {
                  break label8694;
                }
                this.oVS.findViewById(i.f.album_groupid).setVisibility(0);
                this.oVS.findViewById(i.f.album_groupid).setTag(Integer.valueOf(localn.oLk));
                this.oVS.findViewById(i.f.album_groupid).setOnClickListener(new SnsCommentDetailUI.28(this));
                break;
                if (this.diG.equals(((bto)localObject4).sxM))
                {
                  ((TextView)localObject3).setVisibility(0);
                  i = 0;
                  localObject5 = ((bto)localObject4).tKe.iterator();
                  localObject1 = "";
                  if (((Iterator)localObject5).hasNext())
                  {
                    localObject6 = (btd)((Iterator)localObject5).next();
                    if (i == 0)
                    {
                      i = 1;
                      localObject1 = (String)localObject1 + "  ";
                      label8442:
                      if (((btd)localObject6).tqh == null) {
                        break label8512;
                      }
                      localObject2 = new StringBuilder().append((String)localObject1);
                      localObject1 = ((btd)localObject6).tqh;
                    }
                    for (;;)
                    {
                      localObject1 = (String)localObject1;
                      break;
                      localObject1 = (String)localObject1 + ",  ";
                      break label8442;
                      label8512:
                      localObject7 = this.oWj.abl(((btd)localObject6).sxM);
                      localObject2 = new StringBuilder().append((String)localObject1);
                      if (localObject7 == null) {
                        localObject1 = ((btd)localObject6).sxM;
                      } else {
                        localObject1 = ((com.tencent.mm.n.a)localObject7).Bq();
                      }
                    }
                  }
                  ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.d.j.a(this, getString(i.j.sns_timeline_ui_with_to, new Object[] { localObject1 }), ((TextView)localObject3).getTextSize()));
                }
                else
                {
                  ((TextView)localObject3).setVisibility(8);
                  localObject1 = ((bto)localObject4).tKe.iterator();
                  if (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (btd)((Iterator)localObject1).next();
                    if (!this.diG.equals(((btd)localObject2).sxM)) {
                      break label8230;
                    }
                    ((TextView)localObject3).setVisibility(0);
                    localObject1 = getString(i.j.sns_timeline_ui_with_you);
                    ((TextView)localObject3).setVisibility(0);
                    ((TextView)localObject3).setText(com.tencent.mm.pluginsdk.ui.d.j.a(this, (CharSequence)localObject1, ((TextView)localObject3).getTextSize()));
                  }
                }
              }
              label8694:
              this.oVS.findViewById(i.f.album_groupid).setVisibility(8);
              break label2706;
            }
          }
          i = 0;
          j = 0;
        }
      }
    }
  }
  
  public final void ba(String paramString, boolean paramBoolean) {}
  
  public final void bb(String paramString, boolean paramBoolean) {}
  
  protected final int getLayoutId()
  {
    return i.g.sns_comment_detail;
  }
  
  protected final void initView()
  {
    setMMTitle(i.j.sns_comment_detial_ui_title);
    new SnsCommentDetailUI.17(this);
    setBackBtn(new SnsCommentDetailUI.18(this));
    this.diG = com.tencent.mm.model.q.Gj();
    if (af.bDo()) {
      finish();
    }
    com.tencent.mm.plugin.sns.storage.n localn = jv(true);
    if (localn == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.bRV);
      finish();
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.bRV + "localId " + this.oWi + "  username:" + localn.field_userName);
    Object localObject1 = (TextView)findViewById(i.f.content_collapse_hint);
    label285:
    int i;
    if (this.oWC)
    {
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setText(this.oWD);
      if ((v.OW(this.bRV)) || (!localn.bGG())) {
        break label629;
      }
      localObject1 = localn.bGw();
      findViewById(i.f.sns_post_again_ll).setVisibility(0);
      localObject2 = (TextView)findViewById(i.f.post_error_tv);
      switch (((awe)localObject1).tsu)
      {
      default: 
        if (!bk.bl(((awe)localObject1).tsC))
        {
          ((TextView)localObject2).setText(((awe)localObject1).tsC);
          findViewById(i.f.sns_post_btn).setVisibility(0);
          i = 1;
        }
        break;
      }
    }
    for (;;)
    {
      if (i != 0) {
        findViewById(i.f.sns_post_again_ll).setOnClickListener(new SnsCommentDetailUI.8(this, localn));
      }
      this.oVW = ((ListView)findViewById(i.f.album_comment_list));
      this.oVW.post(new SnsCommentDetailUI.9(this));
      this.oVW.setOnScrollListener(new SnsCommentDetailUI.10(this));
      this.oVS = com.tencent.mm.ui.y.gt(this.mController.uMN).inflate(i.g.sns_comment_detail_header, null);
      this.oVY = this.oVS.findViewById(i.f.images_keeper_lieaner_layout);
      this.oVS.setOnClickListener(this.oWM);
      this.oVW.addHeaderView(this.oVS);
      boolean bool = bIB();
      if (bool) {
        break label646;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader " + bool);
      finish();
      return;
      ((TextView)localObject1).setVisibility(8);
      break;
      if (!bk.bl(((awe)localObject1).tsC)) {
        ((TextView)localObject2).setText(((awe)localObject1).tsC);
      }
      for (;;)
      {
        findViewById(i.f.sns_post_btn).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(i.j.sns_post_error_ban_again);
      }
      if (!bk.bl(((awe)localObject1).tsC)) {
        ((TextView)localObject2).setText(((awe)localObject1).tsC);
      }
      for (;;)
      {
        findViewById(i.f.sns_post_btn).setVisibility(8);
        i = 0;
        break;
        ((TextView)localObject2).setText(i.j.sns_post_error_to_long_again);
      }
      if (!bk.bl(((awe)localObject1).tsC)) {
        ((TextView)localObject2).setText(((awe)localObject1).tsC);
      }
      for (;;)
      {
        findViewById(i.f.sns_post_btn).setVisibility(8);
        i = 1;
        break;
        ((TextView)localObject2).setText(i.j.sns_post_error_ten_min_again);
      }
      ((TextView)localObject2).setText(i.j.sns_post_error_touch_again);
      break label285;
      label629:
      findViewById(i.f.sns_post_again_ll).setVisibility(8);
      i = 0;
    }
    label646:
    localObject1 = jv(false);
    if (localObject1 != null) {
      this.ivk = au.b((com.tencent.mm.plugin.sns.storage.n)localObject1, false);
    }
    if ((this.ivk == 10) && (com.tencent.mm.model.q.Gj().equals(localn.field_userName)))
    {
      this.oVV = new SnsDetailLuckyHeader(this);
      localObject1 = new AbsListView.LayoutParams(-1, -2);
      this.oVV.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.oVV.setOnClickListener(this.oWM);
    }
    this.oVU = new LinearLayout(this.mController.uMN);
    localObject1 = new AbsListView.LayoutParams(-1, -2);
    this.oVU.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.oVU.setOnClickListener(this.oWM);
    BackwardSupportUtil.b.b(this, 2.0F);
    localObject1 = new AbsListView.LayoutParams(-1, 1);
    Object localObject2 = new LinearLayout(this.mController.uMN);
    ((LinearLayout)localObject2).setBackgroundResource(i.e.sns_divider_line);
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.oom = ((LinearLayout)localObject2);
    if ((localn.field_localPrivate & 0x1) != 0)
    {
      findViewById(i.f.comment_footer).setVisibility(8);
      localObject1 = new TextView(this);
      ((TextView)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      ((TextView)localObject1).setText(getString(i.j.sns_detail_private_tip));
      ((TextView)localObject1).setTextColor(getResources().getColor(i.c.black));
      ((TextView)localObject1).setGravity(17);
      ((TextView)localObject1).setPadding(0, BackwardSupportUtil.b.b(this, 7.0F), 0, 0);
      this.oVW.addFooterView((View)localObject1);
    }
    if (this.oVV != null)
    {
      this.oWz = true;
      this.oVW.addHeaderView(this.oVV);
    }
    localObject2 = com.tencent.mm.plugin.sns.model.aj.p(localn);
    Object localObject3;
    label1269:
    long l;
    if (localObject2 == null)
    {
      this.oVU.setVisibility(8);
      this.oVZ = new SnsCommentDetailUI.b(this, new LinkedList(), new LinkedList(), this, localn.bGE());
      this.oVW.addHeaderView(this.oVU);
      this.oVW.setAdapter(this.oVZ);
      this.oNF = ((SnsCommentFooter)findViewById(i.f.comment_footer));
      this.oNF.setOnEditTouchListener(new SnsCommentDetailUI.11(this, localn));
      this.oNF.setOnSmileyShowListener(new SnsCommentDetailUI.13(this));
      localObject1 = jv(true);
      if ((localObject1 != null) && (!((com.tencent.mm.plugin.sns.storage.n)localObject1).bGD())) {
        this.oNF.setVisibility(8);
      }
      this.oNF.setAfterEditAction(this.oWL);
      this.oNF.bIK();
      this.oNF.setOnCommentSendImp(new SnsCommentDetailUI.14(this, localn));
      localObject1 = this.oNF;
      localObject3 = new SnsCommentDetailUI.15(this);
      i = localn.field_likeFlag;
      ((SnsCommentFooter)localObject1).oXz.setVisibility(0);
      ((SnsCommentFooter)localObject1).oXz.setOnClickListener(new SnsCommentFooter.1((SnsCommentFooter)localObject1, (SnsCommentFooter.b)localObject3));
      this.oNF.setHeartBtnVisibility(8);
      this.oWn = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
      if (this.oWn)
      {
        this.oWo = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0L);
        if ((this.oWo != 0L) && (this.oVZ.oXs != null))
        {
          i = 0;
          if (i < this.oVZ.oXs.size())
          {
            localObject3 = (btd)this.oVZ.oXs.get(i);
            if (((btd)localObject3).tJu == 0) {
              break label1738;
            }
            l = ((btd)localObject3).tJu;
            label1315:
            if (l != this.oWo) {
              break label1776;
            }
            this.oVW.setSelection(i);
            localObject1 = this.oWj.abl(((btd)localObject3).sxM);
            if (localObject1 == null) {
              break label1748;
            }
            localObject1 = ((com.tencent.mm.n.a)localObject1).Bq();
            label1361:
            this.oNF.bIL();
            this.oNF.setCommentHint(getString(i.j.sns_reply) + (String)localObject1);
            this.oNF.setCommentInfo((btd)localObject3);
            if (((bto)localObject2).tJY.size() <= 0) {
              break label1803;
            }
            int j = i + 1;
            i = j;
            if (j > this.oVZ.getCount()) {
              i = this.oVZ.getCount() - 1;
            }
          }
        }
      }
    }
    label1803:
    for (;;)
    {
      this.oWL.Ln = i;
      if (this.oWn) {
        new ah().postDelayed(new SnsCommentDetailUI.16(this), 100L);
      }
      this.oWy = ((SnsTranslateResultView)this.oVS.findViewById(i.f.sns_translate_result_view));
      this.oWy.setResultTextSize(((TextView)this.oVS.findViewById(i.f.desc_tv)).getTextSize());
      this.oWy.getResultTextView().setBackgroundResource(i.e.sns_clickable_bg);
      localObject1 = new ar(this.bRV, localn.bGE(), false, true, 2);
      this.oWy.getResultTextView().setTag(localObject1);
      this.iep.c(this.oWy.getResultTextView(), this.oWx.poC, this.oWx.poz);
      if (ap.cr(this.bRV, 4))
      {
        localObject1 = ap.NJ(this.bRV);
        if ((localObject1 != null) && (((ap.b)localObject1).dYj))
        {
          this.oWy.setVisibility(0);
          this.oWy.a(null, 1, ((ap.b)localObject1).result, ((ap.b)localObject1).egI, false);
          return;
          this.oWe = ((bto)localObject2).tJY;
          e(((bto)localObject2).tJY, ((bto)localObject2).tKb.isEmpty());
          if (this.oVV != null) {
            this.oVV.a(localn, this.oWx);
          }
          this.oVZ = new SnsCommentDetailUI.b(this, ((bto)localObject2).tKb, ((bto)localObject2).tJY, this, localn.bGE());
          break;
          label1738:
          l = ((btd)localObject3).tJx;
          break label1315;
          label1748:
          if (((btd)localObject3).tqh != null)
          {
            localObject1 = ((btd)localObject3).tqh;
            break label1361;
          }
          localObject1 = ((btd)localObject3).sxM;
          break label1361;
          label1776:
          i += 1;
          break label1269;
        }
        this.oWy.setVisibility(8);
        return;
      }
      this.oWy.setVisibility(8);
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:" + paramInt1);
    if (paramInt1 == 15) {
      if ((this.oWx != null) && (this.oWx.poz != null)) {
        this.oWx.poz.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    do
    {
      do
      {
        do
        {
          String str;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (paramInt1 == 16)
                  {
                    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
                    paramIntent = new gn();
                    paramIntent.bOo.scene = 1;
                    com.tencent.mm.sdk.b.a.udP.m(paramIntent);
                    return;
                  }
                  if (paramInt1 != 2333) {
                    break;
                  }
                } while (paramIntent == null);
                paramIntent = paramIntent.getStringExtra("Select_Contact");
              } while (bk.bl(paramIntent));
              paramIntent = paramIntent.split(",");
            } while (paramIntent.length <= 0);
            this.oNF.bER.showVKB();
            str = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gV(paramIntent[0]);
          } while (bk.bl(str));
          this.oNF.bIL();
          this.oNF.setText("@" + str + " ");
          this.oNF.setCommentAtPrefix("@" + str + " ");
          this.oNF.setCommentInfo(new btd());
          this.oNF.getCommentInfo().sxM = paramIntent[0];
          this.oNF.setCommentFlag(8);
          return;
        } while (paramInt2 != -1);
        switch (paramInt1)
        {
        default: 
          return;
        }
      } while (paramInt2 != -1);
      paramIntent = managedQuery(paramIntent.getData(), null, null, null, null);
    } while (!paramIntent.moveToFirst());
    paramIntent = paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"));
    startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + paramIntent)));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = com.tencent.mm.plugin.sns.storage.h.OA(this.bRV);
    bto localbto = com.tencent.mm.plugin.sns.model.aj.p(paramConfiguration);
    e(localbto.tJY, localbto.tKb.isEmpty());
    if (this.oVV != null) {
      this.oVV.a(paramConfiguration, this.oWx);
    }
    if (this.oWS != null)
    {
      this.oWr = af.bDN();
      this.oWS.setImageViewWidth(this.oWr);
    }
  }
  
  /* Error */
  public void onCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: invokestatic 2660	com/tencent/mm/pluginsdk/e:k	(Lcom/tencent/mm/ui/MMActivity;)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial 2662	com/tencent/mm/ui/MMActivity:onCreate	(Landroid/os/Bundle;)V
    //   12: invokestatic 2666	com/tencent/mm/plugin/sns/model/af:bDv	()Lcom/tencent/mm/plugin/sns/model/am$a;
    //   15: iconst_5
    //   16: ldc_w 2668
    //   19: aload_0
    //   20: invokevirtual 2671	com/tencent/mm/plugin/sns/model/am$a:a	(ILjava/lang/String;Lcom/tencent/mm/plugin/sns/b/h$a;)V
    //   23: aload_0
    //   24: aload_0
    //   25: ldc_w 2673
    //   28: invokevirtual 2674	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: checkcast 2676	android/text/ClipboardManager
    //   34: putfield 952	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:kgn	Landroid/text/ClipboardManager;
    //   37: aload_0
    //   38: invokestatic 2682	java/lang/System:currentTimeMillis	()J
    //   41: putfield 148	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oVQ	J
    //   44: aload_0
    //   45: new 1330	com/tencent/mm/ui/widget/b/a
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 2683	com/tencent/mm/ui/widget/b/a:<init>	(Landroid/content/Context;)V
    //   53: putfield 314	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:iep	Lcom/tencent/mm/ui/widget/b/a;
    //   56: aload_0
    //   57: aload_0
    //   58: invokevirtual 2053	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   61: ldc_w 2685
    //   64: iconst_0
    //   65: invokevirtual 2689	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   68: putfield 908	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWF	I
    //   71: aload_0
    //   72: aload_0
    //   73: invokevirtual 2053	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   76: ldc_w 2691
    //   79: invokevirtual 2581	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   82: ldc 172
    //   84: invokestatic 1216	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   87: putfield 598	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:bRV	Ljava/lang/String;
    //   90: aload_0
    //   91: getfield 598	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:bRV	Ljava/lang/String;
    //   94: invokestatic 586	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   97: ifeq +24 -> 121
    //   100: aload_0
    //   101: ldc_w 2693
    //   104: aload_0
    //   105: invokevirtual 2053	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   108: ldc_w 2691
    //   111: lconst_0
    //   112: invokevirtual 2499	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   115: invokestatic 2697	com/tencent/mm/plugin/sns/storage/v:ak	(Ljava/lang/String;J)Ljava/lang/String;
    //   118: putfield 598	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:bRV	Ljava/lang/String;
    //   121: aload_0
    //   122: aload_0
    //   123: invokevirtual 2053	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   126: ldc_w 2699
    //   129: invokevirtual 2581	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   132: ldc 172
    //   134: invokestatic 1216	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   137: putfield 531	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWi	Ljava/lang/String;
    //   140: aload_0
    //   141: getfield 531	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWi	Ljava/lang/String;
    //   144: invokestatic 586	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   147: ifeq +32 -> 179
    //   150: aload_0
    //   151: invokevirtual 2053	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   154: ldc_w 2699
    //   157: iconst_m1
    //   158: invokevirtual 2689	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   161: istore_2
    //   162: iload_2
    //   163: iconst_m1
    //   164: if_icmpeq +15 -> 179
    //   167: aload_0
    //   168: ldc_w 2693
    //   171: iload_2
    //   172: i2l
    //   173: invokestatic 2697	com/tencent/mm/plugin/sns/storage/v:ak	(Ljava/lang/String;J)Ljava/lang/String;
    //   176: putfield 531	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWi	Ljava/lang/String;
    //   179: aload_0
    //   180: new 2701	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$2
    //   183: dup
    //   184: aload_0
    //   185: aload_0
    //   186: invokespecial 895	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   189: aload_0
    //   190: aload_0
    //   191: getfield 201	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWG	Lcom/tencent/mm/plugin/sns/model/ag;
    //   194: invokespecial 2704	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$2:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;ILandroid/app/Activity;Lcom/tencent/mm/plugin/sns/model/ae;)V
    //   197: putfield 281	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWx	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   200: aload_0
    //   201: getstatic 2707	com/tencent/mm/plugin/sns/i$f:timeline_root	I
    //   204: invokevirtual 1360	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:findViewById	(I)Landroid/view/View;
    //   207: checkcast 2709	android/widget/FrameLayout
    //   210: astore_1
    //   211: aload_0
    //   212: new 2711	com/tencent/mm/plugin/sns/f/b
    //   215: dup
    //   216: aload_0
    //   217: aload_0
    //   218: getfield 281	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWx	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   221: aload_1
    //   222: invokespecial 2714	com/tencent/mm/plugin/sns/f/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;)V
    //   225: putfield 2716	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oNO	Lcom/tencent/mm/plugin/sns/f/b;
    //   228: aload_0
    //   229: new 2718	com/tencent/mm/plugin/sns/ui/b
    //   232: dup
    //   233: aload_0
    //   234: aload_0
    //   235: getfield 281	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWx	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   238: aload_1
    //   239: aload_0
    //   240: getfield 2716	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oNO	Lcom/tencent/mm/plugin/sns/f/b;
    //   243: invokespecial 2721	com/tencent/mm/plugin/sns/ui/b:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/d/b;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/sns/f/b;)V
    //   246: putfield 959	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oNN	Lcom/tencent/mm/plugin/sns/ui/b;
    //   249: aload_0
    //   250: getfield 281	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWx	Lcom/tencent/mm/plugin/sns/ui/d/b;
    //   253: invokevirtual 2724	com/tencent/mm/plugin/sns/ui/d/b:bdj	()V
    //   256: aload_0
    //   257: aload_0
    //   258: invokevirtual 2053	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   261: ldc_w 2726
    //   264: iconst_0
    //   265: invokevirtual 2061	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   268: putfield 192	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWC	Z
    //   271: aload_0
    //   272: aload_0
    //   273: invokevirtual 2053	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   276: ldc_w 2728
    //   279: invokevirtual 2581	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   282: putfield 194	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWD	Ljava/lang/String;
    //   285: aload_0
    //   286: new 675	com/tencent/mm/plugin/sns/ui/bf
    //   289: dup
    //   290: aload_0
    //   291: new 2730	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$3
    //   294: dup
    //   295: aload_0
    //   296: invokespecial 2731	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$3:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   299: aload_0
    //   300: invokespecial 895	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   303: aload_0
    //   304: getfield 201	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWG	Lcom/tencent/mm/plugin/sns/model/ag;
    //   307: invokespecial 2734	com/tencent/mm/plugin/sns/ui/bf:<init>	(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/ui/bf$a;ILcom/tencent/mm/plugin/sns/model/ae;)V
    //   310: putfield 914	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWp	Lcom/tencent/mm/plugin/sns/ui/bf;
    //   313: invokestatic 2682	java/lang/System:currentTimeMillis	()J
    //   316: lstore 5
    //   318: aload_0
    //   319: invokevirtual 2053	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getIntent	()Landroid/content/Intent;
    //   322: ldc_w 2736
    //   325: invokevirtual 2740	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   328: astore_1
    //   329: aload_1
    //   330: ifnull +185 -> 515
    //   333: new 335	com/tencent/mm/protocal/c/bxk
    //   336: dup
    //   337: invokespecial 2741	com/tencent/mm/protocal/c/bxk:<init>	()V
    //   340: astore 7
    //   342: aload 7
    //   344: aload_1
    //   345: invokevirtual 2745	com/tencent/mm/protocal/c/bxk:aH	([B)Lcom/tencent/mm/bv/a;
    //   348: pop
    //   349: invokestatic 2749	com/tencent/mm/plugin/sns/model/af:bDF	()Lcom/tencent/mm/plugin/sns/storage/o;
    //   352: new 2751	java/math/BigInteger
    //   355: dup
    //   356: aload 7
    //   358: getfield 2049	com/tencent/mm/protocal/c/bxk:lsK	Ljava/lang/String;
    //   361: invokespecial 2752	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   364: invokevirtual 2755	java/math/BigInteger:longValue	()J
    //   367: invokevirtual 2760	com/tencent/mm/plugin/sns/storage/o:gt	(J)Lcom/tencent/mm/plugin/sns/storage/n;
    //   370: ifnonnull +646 -> 1016
    //   373: ldc_w 757
    //   376: ldc_w 2762
    //   379: invokestatic 1063	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: new 329	com/tencent/mm/plugin/sns/storage/n
    //   385: dup
    //   386: invokespecial 2763	com/tencent/mm/plugin/sns/storage/n:<init>	()V
    //   389: astore_1
    //   390: aload_1
    //   391: new 2751	java/math/BigInteger
    //   394: dup
    //   395: aload 7
    //   397: getfield 2049	com/tencent/mm/protocal/c/bxk:lsK	Ljava/lang/String;
    //   400: invokespecial 2752	java/math/BigInteger:<init>	(Ljava/lang/String;)V
    //   403: invokevirtual 2755	java/math/BigInteger:longValue	()J
    //   406: putfield 1281	com/tencent/mm/plugin/sns/storage/n:field_snsId	J
    //   409: aload_1
    //   410: aload 7
    //   412: invokevirtual 2767	com/tencent/mm/protocal/c/bxk:toByteArray	()[B
    //   415: putfield 2771	com/tencent/mm/plugin/sns/storage/n:field_content	[B
    //   418: aload_1
    //   419: aload 7
    //   421: getfield 2134	com/tencent/mm/protocal/c/bxk:mPL	I
    //   424: putfield 2774	com/tencent/mm/plugin/sns/storage/n:field_createTime	I
    //   427: aload_1
    //   428: aload 7
    //   430: getfield 1788	com/tencent/mm/protocal/c/bxk:hPY	Ljava/lang/String;
    //   433: putfield 881	com/tencent/mm/plugin/sns/storage/n:field_userName	Ljava/lang/String;
    //   436: aload_1
    //   437: aload 7
    //   439: getfield 339	com/tencent/mm/protocal/c/bxk:tNr	Lcom/tencent/mm/protocal/c/rp;
    //   442: getfield 344	com/tencent/mm/protocal/c/rp:sPI	I
    //   445: putfield 2777	com/tencent/mm/plugin/sns/storage/n:field_type	I
    //   448: aload_1
    //   449: invokevirtual 2780	com/tencent/mm/plugin/sns/storage/n:bGB	()V
    //   452: new 545	com/tencent/mm/protocal/c/bto
    //   455: dup
    //   456: invokespecial 2781	com/tencent/mm/protocal/c/bto:<init>	()V
    //   459: astore 7
    //   461: aload 7
    //   463: new 2783	com/tencent/mm/protocal/c/bmk
    //   466: dup
    //   467: invokespecial 2784	com/tencent/mm/protocal/c/bmk:<init>	()V
    //   470: putfield 2788	com/tencent/mm/protocal/c/bto:tJU	Lcom/tencent/mm/protocal/c/bmk;
    //   473: aload_1
    //   474: aload 7
    //   476: invokevirtual 2789	com/tencent/mm/protocal/c/bto:toByteArray	()[B
    //   479: putfield 2792	com/tencent/mm/plugin/sns/storage/n:field_attrBuf	[B
    //   482: invokestatic 2749	com/tencent/mm/plugin/sns/model/af:bDF	()Lcom/tencent/mm/plugin/sns/storage/o;
    //   485: aload_1
    //   486: invokevirtual 2795	com/tencent/mm/plugin/sns/storage/o:b	(Lcom/tencent/mm/sdk/e/c;)Z
    //   489: pop
    //   490: ldc_w 2797
    //   493: ldc_w 2799
    //   496: iconst_1
    //   497: anewarray 761	java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: invokestatic 2682	java/lang/System:currentTimeMillis	()J
    //   505: lload 5
    //   507: lsub
    //   508: invokestatic 1286	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   511: aastore
    //   512: invokestatic 1201	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   515: aload_0
    //   516: iconst_1
    //   517: invokespecial 327	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:jv	(Z)Lcom/tencent/mm/plugin/sns/storage/n;
    //   520: astore_1
    //   521: ldc_w 757
    //   524: new 497	java/lang/StringBuilder
    //   527: dup
    //   528: ldc_w 2801
    //   531: invokespecial 1059	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   534: aload_0
    //   535: getfield 598	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:bRV	Ljava/lang/String;
    //   538: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: ldc_w 2803
    //   544: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload_0
    //   548: getfield 531	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWi	Ljava/lang/String;
    //   551: invokevirtual 506	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 510	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 1063	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: aload_1
    //   561: ifnull +28 -> 589
    //   564: ldc_w 757
    //   567: ldc_w 2805
    //   570: iconst_1
    //   571: anewarray 761	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: aload_1
    //   577: getfield 881	com/tencent/mm/plugin/sns/storage/n:field_userName	Ljava/lang/String;
    //   580: ldc 172
    //   582: invokestatic 1216	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   585: aastore
    //   586: invokestatic 1201	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   589: aload_0
    //   590: getfield 598	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:bRV	Ljava/lang/String;
    //   593: invokestatic 1020	com/tencent/mm/plugin/sns/storage/v:OW	(Ljava/lang/String;)Z
    //   596: ifeq +56 -> 652
    //   599: aload_0
    //   600: getfield 598	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:bRV	Ljava/lang/String;
    //   603: invokestatic 2808	com/tencent/mm/plugin/sns/storage/v:MJ	(Ljava/lang/String;)Z
    //   606: ifeq +454 -> 1060
    //   609: aload_1
    //   610: ifnull +418 -> 1028
    //   613: aload_1
    //   614: getfield 881	com/tencent/mm/plugin/sns/storage/n:field_userName	Ljava/lang/String;
    //   617: invokestatic 2813	com/tencent/mm/model/s:hj	(Ljava/lang/String;)Z
    //   620: ifne +32 -> 652
    //   623: invokestatic 1169	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   626: pop
    //   627: invokestatic 2817	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   630: getfield 2823	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   633: new 2825	com/tencent/mm/plugin/sns/model/q
    //   636: dup
    //   637: aload_0
    //   638: getfield 598	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:bRV	Ljava/lang/String;
    //   641: invokestatic 2829	com/tencent/mm/plugin/sns/storage/v:OU	(Ljava/lang/String;)J
    //   644: invokespecial 2831	com/tencent/mm/plugin/sns/model/q:<init>	(J)V
    //   647: iconst_0
    //   648: invokevirtual 2836	com/tencent/mm/ah/p:a	(Lcom/tencent/mm/ah/m;I)Z
    //   651: pop
    //   652: invokestatic 1169	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   655: pop
    //   656: invokestatic 2817	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   659: getfield 2823	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   662: sipush 210
    //   665: aload_0
    //   666: invokevirtual 2839	com/tencent/mm/ah/p:a	(ILcom/tencent/mm/ah/f;)V
    //   669: invokestatic 1169	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   672: pop
    //   673: invokestatic 2817	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   676: getfield 2823	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   679: sipush 218
    //   682: aload_0
    //   683: invokevirtual 2839	com/tencent/mm/ah/p:a	(ILcom/tencent/mm/ah/f;)V
    //   686: invokestatic 1169	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   689: pop
    //   690: invokestatic 2817	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   693: getfield 2823	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   696: sipush 213
    //   699: aload_0
    //   700: invokevirtual 2839	com/tencent/mm/ah/p:a	(ILcom/tencent/mm/ah/f;)V
    //   703: invokestatic 1169	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   706: pop
    //   707: invokestatic 2817	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   710: getfield 2823	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   713: sipush 682
    //   716: aload_0
    //   717: invokevirtual 2839	com/tencent/mm/ah/p:a	(ILcom/tencent/mm/ah/f;)V
    //   720: invokestatic 1169	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   723: pop
    //   724: invokestatic 2817	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   727: getfield 2823	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   730: sipush 214
    //   733: aload_0
    //   734: invokevirtual 2839	com/tencent/mm/ah/p:a	(ILcom/tencent/mm/ah/f;)V
    //   737: invokestatic 1169	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   740: pop
    //   741: invokestatic 2817	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   744: getfield 2823	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   747: sipush 683
    //   750: aload_0
    //   751: invokevirtual 2839	com/tencent/mm/ah/p:a	(ILcom/tencent/mm/ah/f;)V
    //   754: aload_0
    //   755: invokestatic 2842	com/tencent/mm/plugin/sns/model/af:bDt	()Lcom/tencent/mm/storage/bd;
    //   758: putfield 2227	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWj	Lcom/tencent/mm/storage/bd;
    //   761: aload_0
    //   762: new 2844	com/tencent/mm/plugin/sns/ui/an
    //   765: dup
    //   766: aload_0
    //   767: invokespecial 2847	com/tencent/mm/plugin/sns/ui/an:<init>	(Landroid/app/Activity;)V
    //   770: putfield 956	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oNH	Lcom/tencent/mm/plugin/sns/ui/an;
    //   773: aload_0
    //   774: new 354	com/tencent/mm/plugin/sns/ui/aq
    //   777: dup
    //   778: aload_0
    //   779: getfield 439	com/tencent/mm/ui/MMActivity:mController	Lcom/tencent/mm/ui/s;
    //   782: getfield 445	com/tencent/mm/ui/s:uMN	Landroid/support/v7/app/AppCompatActivity;
    //   785: invokespecial 2848	com/tencent/mm/plugin/sns/ui/aq:<init>	(Landroid/content/Context;)V
    //   788: putfield 288	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWh	Lcom/tencent/mm/plugin/sns/ui/aq;
    //   791: aload_0
    //   792: new 2850	com/tencent/mm/plugin/sns/ui/j
    //   795: dup
    //   796: aload_0
    //   797: aload_0
    //   798: invokespecial 895	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   801: aload_0
    //   802: getfield 201	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWG	Lcom/tencent/mm/plugin/sns/model/ag;
    //   805: invokespecial 2853	com/tencent/mm/plugin/sns/ui/j:<init>	(Landroid/app/Activity;ILcom/tencent/mm/plugin/sns/model/ae;)V
    //   808: putfield 310	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWm	Lcom/tencent/mm/plugin/sns/ui/j;
    //   811: aload_1
    //   812: ifnull +12 -> 824
    //   815: aload_0
    //   816: aload_1
    //   817: iconst_0
    //   818: invokestatic 1102	com/tencent/mm/plugin/sns/ui/au:b	(Lcom/tencent/mm/plugin/sns/storage/n;Z)I
    //   821: putfield 284	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:ivk	I
    //   824: aload_1
    //   825: ifnull +39 -> 864
    //   828: aload_1
    //   829: bipush 32
    //   831: invokevirtual 976	com/tencent/mm/plugin/sns/storage/n:yr	(I)Z
    //   834: ifeq +30 -> 864
    //   837: aload_0
    //   838: getfield 908	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWF	I
    //   841: bipush 16
    //   843: if_icmpne +258 -> 1101
    //   846: aload_0
    //   847: new 1932	com/tencent/mm/plugin/sns/a/b/g
    //   850: dup
    //   851: iconst_2
    //   852: invokespecial 2855	com/tencent/mm/plugin/sns/a/b/g:<init>	(I)V
    //   855: putfield 292	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWw	Lcom/tencent/mm/plugin/sns/a/b/g;
    //   858: aload_1
    //   859: iconst_0
    //   860: invokestatic 1102	com/tencent/mm/plugin/sns/ui/au:b	(Lcom/tencent/mm/plugin/sns/storage/n;Z)I
    //   863: pop
    //   864: aload_0
    //   865: invokevirtual 2857	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:initView	()V
    //   868: aload_1
    //   869: ifnull +49 -> 918
    //   872: aload_1
    //   873: bipush 32
    //   875: invokevirtual 976	com/tencent/mm/plugin/sns/storage/n:yr	(I)Z
    //   878: ifeq +40 -> 918
    //   881: aload_1
    //   882: invokestatic 997	com/tencent/mm/plugin/sns/model/aj:p	(Lcom/tencent/mm/plugin/sns/storage/n;)Lcom/tencent/mm/protocal/c/bto;
    //   885: astore 7
    //   887: aload_0
    //   888: getfield 292	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWw	Lcom/tencent/mm/plugin/sns/a/b/g;
    //   891: iconst_0
    //   892: aload_1
    //   893: invokevirtual 601	com/tencent/mm/plugin/sns/storage/n:bGE	()Ljava/lang/String;
    //   896: aload_1
    //   897: invokevirtual 2860	com/tencent/mm/plugin/sns/storage/n:bGA	()Z
    //   900: aload_0
    //   901: getfield 971	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oVS	Landroid/view/View;
    //   904: aload_1
    //   905: getfield 1281	com/tencent/mm/plugin/sns/storage/n:field_snsId	J
    //   908: aload 7
    //   910: aload_0
    //   911: getfield 284	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:ivk	I
    //   914: iconst_2
    //   915: invokevirtual 2863	com/tencent/mm/plugin/sns/a/b/g:a	(ILjava/lang/String;ZLandroid/view/View;JLcom/tencent/mm/protocal/c/bto;II)V
    //   918: aload_0
    //   919: getfield 971	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oVS	Landroid/view/View;
    //   922: ifnull +86 -> 1008
    //   925: aload_1
    //   926: ifnull +82 -> 1008
    //   929: aload_0
    //   930: getfield 971	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oVS	Landroid/view/View;
    //   933: getstatic 1833	com/tencent/mm/plugin/sns/i$f:image	I
    //   936: invokevirtual 1108	android/view/View:findViewById	(I)Landroid/view/View;
    //   939: checkcast 1835	com/tencent/mm/plugin/sight/decode/a/a
    //   942: astore 7
    //   944: iload 4
    //   946: istore_3
    //   947: aload_1
    //   948: invokevirtual 333	com/tencent/mm/plugin/sns/storage/n:bGe	()Lcom/tencent/mm/protocal/c/bxk;
    //   951: getfield 339	com/tencent/mm/protocal/c/bxk:tNr	Lcom/tencent/mm/protocal/c/rp;
    //   954: ifnull +44 -> 998
    //   957: iload 4
    //   959: istore_3
    //   960: aload_1
    //   961: invokevirtual 333	com/tencent/mm/plugin/sns/storage/n:bGe	()Lcom/tencent/mm/protocal/c/bxk;
    //   964: getfield 339	com/tencent/mm/protocal/c/bxk:tNr	Lcom/tencent/mm/protocal/c/rp;
    //   967: getfield 344	com/tencent/mm/protocal/c/rp:sPI	I
    //   970: bipush 15
    //   972: if_icmpne +26 -> 998
    //   975: iload 4
    //   977: istore_3
    //   978: aload 7
    //   980: instanceof 2865
    //   983: ifeq +15 -> 998
    //   986: aload 7
    //   988: checkcast 2865	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView
    //   991: getfield 2869	com/tencent/mm/plugin/sight/decode/ui/SightPlayImageView:ofD	Lcom/tencent/mm/plugin/sight/decode/a/b;
    //   994: invokevirtual 2874	com/tencent/mm/plugin/sight/decode/a/b:bBa	()Z
    //   997: istore_3
    //   998: aload_1
    //   999: iconst_1
    //   1000: iload_3
    //   1001: aload_0
    //   1002: invokespecial 895	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:getSource	()I
    //   1005: invokestatic 2879	com/tencent/mm/plugin/sns/a/b/j:a	(Lcom/tencent/mm/plugin/sns/storage/n;ZZI)V
    //   1008: aload_0
    //   1009: getfield 691	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oVW	Landroid/widget/ListView;
    //   1012: ifnonnull +104 -> 1116
    //   1015: return
    //   1016: ldc_w 757
    //   1019: ldc_w 2881
    //   1022: invokestatic 1063	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1025: goto -510 -> 515
    //   1028: invokestatic 1169	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   1031: pop
    //   1032: invokestatic 2817	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   1035: getfield 2823	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   1038: new 2825	com/tencent/mm/plugin/sns/model/q
    //   1041: dup
    //   1042: aload_0
    //   1043: getfield 598	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:bRV	Ljava/lang/String;
    //   1046: invokestatic 2829	com/tencent/mm/plugin/sns/storage/v:OU	(Ljava/lang/String;)J
    //   1049: invokespecial 2831	com/tencent/mm/plugin/sns/model/q:<init>	(J)V
    //   1052: iconst_0
    //   1053: invokevirtual 2836	com/tencent/mm/ah/p:a	(Lcom/tencent/mm/ah/m;I)Z
    //   1056: pop
    //   1057: goto -405 -> 652
    //   1060: invokestatic 1169	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   1063: pop
    //   1064: invokestatic 2817	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   1067: getfield 2823	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   1070: new 2883	com/tencent/mm/plugin/sns/model/m
    //   1073: dup
    //   1074: aload_0
    //   1075: getfield 598	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:bRV	Ljava/lang/String;
    //   1078: invokestatic 2829	com/tencent/mm/plugin/sns/storage/v:OU	(Ljava/lang/String;)J
    //   1081: iconst_0
    //   1082: aload_0
    //   1083: aload_1
    //   1084: invokespecial 1290	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:f	(Lcom/tencent/mm/plugin/sns/storage/n;)Lcom/tencent/mm/plugin/sns/storage/a;
    //   1087: getfield 2886	com/tencent/mm/plugin/sns/storage/a:oAu	Ljava/lang/String;
    //   1090: invokespecial 2889	com/tencent/mm/plugin/sns/model/m:<init>	(JILjava/lang/String;)V
    //   1093: iconst_0
    //   1094: invokevirtual 2836	com/tencent/mm/ah/p:a	(Lcom/tencent/mm/ah/m;I)Z
    //   1097: pop
    //   1098: goto -446 -> 652
    //   1101: aload_0
    //   1102: new 1932	com/tencent/mm/plugin/sns/a/b/g
    //   1105: dup
    //   1106: iconst_1
    //   1107: invokespecial 2855	com/tencent/mm/plugin/sns/a/b/g:<init>	(I)V
    //   1110: putfield 292	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWw	Lcom/tencent/mm/plugin/sns/a/b/g;
    //   1113: goto -255 -> 858
    //   1116: aload_0
    //   1117: getfield 691	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oVW	Landroid/widget/ListView;
    //   1120: new 2891	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4
    //   1123: dup
    //   1124: aload_0
    //   1125: invokespecial 2892	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI$4:<init>	(Lcom/tencent/mm/plugin/sns/ui/SnsCommentDetailUI;)V
    //   1128: invokevirtual 2893	android/widget/ListView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   1131: getstatic 2573	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   1134: aload_0
    //   1135: getfield 249	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:giK	Lcom/tencent/mm/sdk/b/c;
    //   1138: invokevirtual 2896	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1141: pop
    //   1142: getstatic 2573	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   1145: aload_0
    //   1146: getfield 208	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWH	Lcom/tencent/mm/sdk/b/c;
    //   1149: invokevirtual 2896	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1152: pop
    //   1153: getstatic 2573	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   1156: aload_0
    //   1157: getfield 213	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWI	Lcom/tencent/mm/sdk/b/c;
    //   1160: invokevirtual 2896	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1163: pop
    //   1164: getstatic 2573	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   1167: aload_0
    //   1168: getfield 218	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWJ	Lcom/tencent/mm/sdk/b/c;
    //   1171: invokevirtual 2896	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1174: pop
    //   1175: getstatic 2573	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   1178: aload_0
    //   1179: getfield 221	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWK	Lcom/tencent/mm/sdk/b/c;
    //   1182: invokevirtual 2896	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1185: pop
    //   1186: getstatic 2573	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   1189: aload_0
    //   1190: getfield 244	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWN	Lcom/tencent/mm/sdk/b/c;
    //   1193: invokevirtual 2896	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1196: pop
    //   1197: getstatic 2573	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   1200: aload_0
    //   1201: getfield 254	com/tencent/mm/plugin/sns/ui/SnsCommentDetailUI:oWO	Lcom/tencent/mm/sdk/b/c;
    //   1204: invokevirtual 2896	com/tencent/mm/sdk/b/a:c	(Lcom/tencent/mm/sdk/b/c;)Z
    //   1207: pop
    //   1208: aload_0
    //   1209: invokestatic 2898	com/tencent/mm/pluginsdk/e:l	(Lcom/tencent/mm/ui/MMActivity;)V
    //   1212: return
    //   1213: astore_1
    //   1214: goto -699 -> 515
    //   1217: astore 7
    //   1219: goto -737 -> 482
    //   1222: astore 8
    //   1224: goto -806 -> 418
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1227	0	this	SnsCommentDetailUI
    //   0	1227	1	paramBundle	android.os.Bundle
    //   161	11	2	i	int
    //   946	55	3	bool1	boolean
    //   1	975	4	bool2	boolean
    //   316	190	5	l	long
    //   340	647	7	localObject	Object
    //   1217	1	7	localIOException	java.io.IOException
    //   1222	1	8	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   342	349	1213	java/io/IOException
    //   473	482	1217	java/io/IOException
    //   409	418	1222	java/lang/Exception
  }
  
  public void onDestroy()
  {
    af.bDv().a(this, 5);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(210, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(218, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(213, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(214, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(683, this);
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DO().dJT.b(682, this);
    af.bDC().M(this);
    com.tencent.mm.sdk.b.a.udP.d(this.giK);
    if (this.oWm != null) {
      this.oWm.activity = null;
    }
    aa.bHF();
    if (this.oNF != null) {
      this.oNF.bgu();
    }
    com.tencent.mm.plugin.sns.storage.n localn = jv(false);
    Object localObject1;
    Object localObject2;
    if ((this.oWw != null) && (localn != null) && (localn.yr(32)))
    {
      localObject1 = this.oWw;
      localObject2 = localn.bGE();
      long l = localn.field_snsId;
      ((com.tencent.mm.plugin.sns.a.b.g)localObject1).h(0, (String)localObject2, 2);
      localObject1 = f(localn);
      if (localObject1 != null) {
        break label449;
      }
      localObject1 = "";
      if (!localn.bEQ()) {
        break label457;
      }
      af.bDz().f(14652, new Object[] { com.tencent.mm.plugin.sns.a.b.f.a(localn.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId), localObject1, Long.valueOf(this.oVQ), Long.valueOf(System.currentTimeMillis()) }) });
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.modelsns.b.je(732);
      ((com.tencent.mm.modelsns.b)localObject2).ni(com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId)).ni((String)localObject1).ni(this.oVQ).ni(System.currentTimeMillis());
      ((com.tencent.mm.modelsns.b)localObject2).QX();
      this.oWx.ch();
      com.tencent.mm.sdk.b.a.udP.d(this.oWH);
      com.tencent.mm.sdk.b.a.udP.d(this.oWI);
      com.tencent.mm.sdk.b.a.udP.d(this.oWJ);
      com.tencent.mm.sdk.b.a.udP.d(this.oWK);
      com.tencent.mm.sdk.b.a.udP.d(this.oWN);
      com.tencent.mm.sdk.b.a.udP.d(this.oWO);
      super.onDestroy();
      return;
      label449:
      localObject1 = ((com.tencent.mm.plugin.sns.storage.a)localObject1).ovV;
      break;
      label457:
      af.bDz().f(12012, new Object[] { com.tencent.mm.plugin.sns.a.b.f.a(localn.field_snsId, new Object[] { com.tencent.mm.plugin.sns.data.i.fN(localn.field_snsId), localObject1, Long.valueOf(this.oVQ), Long.valueOf(System.currentTimeMillis()) }) });
    }
  }
  
  public final void onKeyboardStateChanged()
  {
    if (this.mController.uNh == 2)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
      this.oWg = false;
    }
    while (this.mController.uNh != 1) {
      return;
    }
    bIC();
    this.oND = false;
    this.oWL.run();
  }
  
  public void onPause()
  {
    af.bDA().b(this);
    super.onPause();
    this.oNF.jpC.onPause();
    new si().cbT.type = 1;
    if (this.oWw != null) {
      this.oWw.onPause();
    }
  }
  
  public void onResume()
  {
    af.bDA().a(this);
    si localsi = new si();
    localsi.cbT.cbU = 0;
    localsi.cbT.cbV = 1;
    localsi.cbT.cbW = 0;
    localsi.cbT.type = 0;
    com.tencent.mm.sdk.b.a.udP.m(localsi);
    if (this.oWw != null) {
      this.oWw.onResume();
    }
    if (this.oWv != null) {
      this.oWv.aqU();
    }
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm.getType() == 218) && (this.oNQ != null)) {
      this.oNQ.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = com.tencent.mm.plugin.sns.storage.h.OA(this.bRV);
      if (paramm != null) {
        break label78;
      }
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.bRV);
      finish();
    }
    label78:
    do
    {
      return;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.bRV + "  username:" + paramm.field_userName);
      if (this.oVS == null)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
        finish();
        return;
      }
      bIB();
      paramString = com.tencent.mm.plugin.sns.model.aj.p(paramm);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + paramString.tJY.size() + " " + paramString.tKb.size());
    } while (paramString == null);
    if (!e(this.oWe, paramString.tJY))
    {
      e(paramString.tJY, paramString.tKb.isEmpty());
      this.oWe = paramString.tJY;
    }
    if (this.oVV != null) {
      this.oVV.a(paramm, this.oWx);
    }
    paramm = this.oVZ;
    LinkedList localLinkedList = paramString.tKb;
    paramString = paramString.tJY;
    paramm.oXs = localLinkedList;
    paramm.oXt = paramString;
    this.oVZ.notifyDataSetChanged();
    paramString = this.oVZ;
    new ah().postDelayed(new SnsCommentDetailUI.b.1(paramString), 60L);
  }
  
  final class a
    extends o
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      SnsCommentDetailUI.j(SnsCommentDetailUI.this).pjS.onClick(paramView);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      int i = SnsCommentDetailUI.this.getResources().getColor(i.c.sns_link_bg_color);
      if (this.mmZ)
      {
        paramTextPaint.bgColor = i;
        return;
      }
      paramTextPaint.bgColor = 0;
    }
  }
  
  final class c
    implements Runnable
  {
    int Ln = -1;
    int ixe;
    private int oXx = -1;
    private int oXy = 10;
    private int offset = 0;
    
    c() {}
    
    public final void run()
    {
      this.oXy = 10;
      SnsCommentDetailUI.a(SnsCommentDetailUI.this);
      this.oXx = SnsCommentDetailUI.b(SnsCommentDetailUI.this).getTop();
      int i = this.oXx - this.ixe;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[] { Integer.valueOf(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(SnsCommentDetailUI.this)), Integer.valueOf(this.oXx), Integer.valueOf(SnsCommentDetailUI.b(SnsCommentDetailUI.this).getTop()), Integer.valueOf(i) });
      if (i == this.offset)
      {
        SnsCommentDetailUI.c(SnsCommentDetailUI.this).setSelectionFromTop(SnsCommentDetailUI.c(SnsCommentDetailUI.this).getHeaderViewsCount() + this.Ln, i);
        this.oXy = 0;
        this.offset = 0;
        return;
      }
      int j = this.oXy;
      this.oXy = (j - 1);
      if (j > 0)
      {
        new ah().postDelayed(this, 100L);
        this.offset = i;
        return;
      }
      this.offset = 0;
      this.oXy = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */