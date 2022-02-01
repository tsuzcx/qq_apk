package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.2;
import com.tencent.mm.plugin.sns.ui.view.SnsStoryHeaderView.a;
import com.tencent.mm.plugin.story.api.AbsStoryHeaderTipView;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.api.j;
import com.tencent.mm.plugin.story.api.l.c;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.z;
import com.tencent.mm.vfs.i;
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
  Context context;
  boolean dfZ;
  private Dialog dialog;
  String fnC;
  private String sessionId;
  private int type;
  String userName;
  Animation yAN;
  c yLH;
  private a yLI;
  private b yLJ;
  private boolean yLK;
  private Map<Integer, View> yLL;
  private String yLM;
  Bitmap yLN;
  boolean yLO;
  private String ycH;
  
  public SnsHeader(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(98715);
    this.yLK = false;
    this.dfZ = false;
    this.yLL = new HashMap();
    this.yLM = "";
    this.yLN = null;
    this.yAN = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.yLO = false;
    init(paramContext);
    AppMethodBeat.o(98715);
  }
  
  public SnsHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98716);
    this.yLK = false;
    this.dfZ = false;
    this.yLL = new HashMap();
    this.yLM = "";
    this.yLN = null;
    this.yAN = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.yLO = false;
    init(paramContext);
    AppMethodBeat.o(98716);
  }
  
  private void init(final Context paramContext)
  {
    AppMethodBeat.i(98721);
    this.context = paramContext;
    g.agS();
    this.yLO = ((e)g.ad(e.class)).getStoryNewFeatureConfig().dUI();
    Object localObject = z.jD(paramContext).inflate(2131495552, this, true);
    FrameLayout localFrameLayout = (FrameLayout)((View)localObject).findViewById(2131305057);
    this.yLH = new c();
    this.yLH.nbZ = ((TextView)((View)localObject).findViewById(2131302867));
    this.yLH.fxQ = ((ImageView)((View)localObject).findViewById(2131297008));
    this.yLH.yxl = ((TextView)((View)localObject).findViewById(2131304821));
    this.yLH.yLT = ((ImageView)((View)localObject).findViewById(2131304937));
    this.yLH.yLU = ((ImageView)((View)localObject).findViewById(2131304938));
    this.yLH.yLV = ((LinearLayout)((View)localObject).findViewById(2131304613));
    this.yLH.yLW = ((LinearLayout)((View)localObject).findViewById(2131304976));
    this.yLH.yLZ = ((RelativeLayout)((View)localObject).findViewById(2131304981));
    this.yLH.yMa = ((LinearLayout)((View)localObject).findViewById(2131304982));
    this.yLH.yMb = ((ImageView)((View)localObject).findViewById(2131307247));
    this.yAN.setDuration(1000L);
    this.yAN.setRepeatCount(-1);
    localObject = new LinearInterpolator();
    this.yAN.setInterpolator((Interpolator)localObject);
    localObject = this.yLH;
    g.agS();
    ((c)localObject).yLX = ((e)g.ad(e.class)).getStoryUIFactory().gp(paramContext);
    this.yLH.yLY = new SnsStoryHeaderView(paramContext);
    if (this.yLO)
    {
      localFrameLayout.addView(this.yLH.yLX);
      this.yLH.yLX.onCreateView();
    }
    for (;;)
    {
      this.yLH.yLT.setContentDescription(paramContext.getString(2131763783));
      this.yLH.yLT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98712);
          ac.d("MicroMsg.SnsHeader", "change backGround");
          if ((SnsHeader.a(SnsHeader.this) != null) && (SnsHeader.a(SnsHeader.this).isShowing()))
          {
            AppMethodBeat.o(98712);
            return;
          }
          if (SnsHeader.b(SnsHeader.this) != null) {
            SnsHeader.b(SnsHeader.this).dPH();
          }
          if (SnsHeader.c(SnsHeader.this) == 1) {}
          final long l;
          for (paramAnonymousView = SnsHeader.d(SnsHeader.this);; paramAnonymousView = SnsHeader.e(SnsHeader.this))
          {
            paramAnonymousView = af.dHV().auY(paramAnonymousView);
            l = paramAnonymousView.field_snsBgId;
            if ((SnsHeader.f(SnsHeader.this)) || (l != 0L)) {
              break;
            }
            AppMethodBeat.o(98712);
            return;
          }
          SnsHeader.a(SnsHeader.this, paramAnonymousView.dMk());
          String str;
          if ((SnsHeader.c(SnsHeader.this) == 1) || (SnsHeader.d(SnsHeader.this).trim().equals(SnsHeader.e(SnsHeader.this).trim())))
          {
            paramAnonymousView = new String[1];
            paramAnonymousView[0] = paramContext.getString(2131764047);
            SnsHeader.a(SnsHeader.this, false);
            if (!SnsHeader.g(SnsHeader.this)) {
              break label319;
            }
            str = paramContext.getString(2131763965);
            label225:
            if (!SnsHeader.g(SnsHeader.this)) {
              break label326;
            }
            paramContext.getString(2131755835);
          }
          for (;;)
          {
            SnsHeader.a(SnsHeader.this, h.a(SnsHeader.this.getContext(), str, paramAnonymousView, new h.c()
            {
              public final void kG(int paramAnonymous2Int)
              {
                AppMethodBeat.i(98711);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(98711);
                  return;
                  if (!SnsHeader.g(SnsHeader.this)) {
                    SnsHeader.a(SnsHeader.this, l);
                  }
                }
              }
            }));
            AppMethodBeat.o(98712);
            return;
            if (SnsHeader.g(SnsHeader.this))
            {
              paramAnonymousView = new String[0];
              break;
            }
            paramAnonymousView = new String[1];
            paramAnonymousView[0] = paramContext.getString(2131763889);
            break;
            label319:
            str = "";
            break label225;
            label326:
            paramContext.getString(2131755691);
          }
        }
      });
      this.yLH.fxQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          int i = 1;
          AppMethodBeat.i(98713);
          paramAnonymousView = af.dHF().aNt(SnsHeader.e(SnsHeader.this));
          if ((paramAnonymousView != null) && ((b.ln(paramAnonymousView.field_type)) || (SnsHeader.f(SnsHeader.this))))
          {
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", SnsHeader.e(SnsHeader.this));
            if ((SnsHeader.e(SnsHeader.this) != null) && (SnsHeader.e(SnsHeader.this).length() > 0))
            {
              if (SnsHeader.c(SnsHeader.this) == 1) {
                i = 6;
              }
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", i);
              com.tencent.mm.plugin.sns.c.a.iyx.c(paramAnonymousView, paramContext);
            }
            AppMethodBeat.o(98713);
            return;
          }
          paramAnonymousView = ((Activity)paramContext).getIntent();
          paramAnonymousView.putExtra("Contact_User", SnsHeader.e(SnsHeader.this));
          com.tencent.mm.plugin.sns.c.a.iyx.c(paramAnonymousView, paramContext);
          AppMethodBeat.o(98713);
        }
      });
      AppMethodBeat.o(98721);
      return;
      localFrameLayout.addView(this.yLH.yLY);
      this.yLH.yLY.setSessionId(this.sessionId);
      this.yLH.yLY.setEnterObjectId(this.ycH);
    }
  }
  
  public final void dPF()
  {
    AppMethodBeat.i(98723);
    String str1 = this.userName;
    if (this.type == 1) {
      str1 = this.fnC;
    }
    Object localObject1 = af.getAccSnsPath();
    ac.d("MicroMsg.SnsHeader", "MagicAsyncTask ".concat(String.valueOf(str1)));
    com.tencent.mm.plugin.sns.storage.n localn = af.dHV().auY(str1);
    String str2 = localn.field_bgId;
    Object localObject3 = localn.field_older_bgId;
    ac.d("MicroMsg.SnsHeader", "showName " + str1 + " get bgId : " + str2 + "  olderBgId：　" + (String)localObject3);
    localObject3 = com.tencent.mm.plugin.sns.data.q.asO(str2);
    String str6 = str1 + "bg_";
    String str3 = str1 + "tbg_";
    String str4 = an.jc((String)localObject1, str1);
    i.aSh(str4);
    int i;
    String str5;
    if ((localn.field_local_flag & 0x1) > 0)
    {
      i = 1;
      if (i != 0)
      {
        ac.d("MicroMsg.SnsHeader", "bg is change");
        af.dHV().auX(str1);
        if (i.eA(an.jc((String)localObject1, str1) + str6))
        {
          i.deleteFile(an.jc((String)localObject1, str1) + str3);
          i.aT(an.jc((String)localObject1, str1), str6, str3);
        }
        localn.field_local_flag &= 0xFFFFFFFE;
        af.dHV().c(localn);
      }
      if ((i.eA(an.jc(af.getAccSnsPath(), str2) + (String)localObject3)) && (!i.eA(an.jc((String)localObject1, str1) + str6)))
      {
        i.lZ(an.jc((String)localObject1, str2) + (String)localObject3, an.jc((String)localObject1, str1) + str6);
        ac.d("MicroMsg.SnsHeader", "nwer id Name update");
      }
      str5 = localn.field_bgUrl;
      if (str2 == null) {
        break label780;
      }
      af.dHO();
      localObject1 = str4 + str6;
      this.context.hashCode();
      localObject3 = com.tencent.mm.plugin.sns.model.f.a((String)localObject1, str5, str2, true, bf.GYH);
      ac.d("MicroMsg.SnsHeader", "set a new bg");
      localObject1 = localObject3;
      if (localObject3 == null) {
        i.deleteFile(str4 + str6);
      }
    }
    label691:
    Object localObject2;
    label780:
    for (localObject1 = localObject3;; localObject2 = null)
    {
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (str2 != null)
        {
          af.dHO();
          localObject1 = str4 + str3;
          this.context.hashCode();
          localObject3 = com.tencent.mm.plugin.sns.model.f.a((String)localObject1, str5, str2, false, bf.GYH);
        }
      }
      if (this.yLH.yLT != null)
      {
        this.yLH.yLT.setImageBitmap((Bitmap)localObject3);
        if (localObject3 == null) {
          break label691;
        }
        this.yLH.yLT.setBackgroundDrawable(null);
      }
      for (;;)
      {
        this.yLH.yLV.setVisibility(8);
        if ((localObject3 == null) && ((this.type == 1) || (this.fnC.equals(str1)))) {
          this.yLH.yLV.setVisibility(0);
        }
        this.yLK = localn.dMk();
        AppMethodBeat.o(98723);
        return;
        i = 0;
        break;
        try
        {
          if ((this.yLN == null) || (this.yLN.isRecycled()))
          {
            ac.i("MicroMsg.SnsHeader", "decode bitmap by self");
            this.yLN = com.tencent.mm.sdk.platformtools.f.decodeStream(this.context.getAssets().open("resource/friendactivity_mycover_bg.jpg"));
          }
          localObject1 = new BitmapDrawable(this.yLN);
          this.yLH.yLT.setBackgroundDrawable((Drawable)localObject1);
        }
        catch (IOException localIOException)
        {
          ac.printErrStackTrace("MicroMsg.SnsHeader", localIOException, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean dPG()
  {
    AppMethodBeat.i(98724);
    if (this.yLH.yLW == null)
    {
      AppMethodBeat.o(98724);
      return false;
    }
    Object localObject = aj.dIo();
    LinkedList localLinkedList = new LinkedList();
    final int i = 0;
    p localp1;
    boolean bool;
    for (;;)
    {
      if (i >= ((List)localObject).size()) {
        break label114;
      }
      localp1 = (p)((List)localObject).get(i);
      try
      {
        bool = ((bua)new bua().parseFrom(localp1.field_postBuf)).FjV;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localLinkedList.add(localp1);
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
      localp1 = (p)localLinkedList.get(i);
      try
      {
        bool = ((bua)new bua().parseFrom(localp1.field_postBuf)).FjV;
        if (!bool) {
          break;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject = (String)localObject + ((p)localLinkedList.get(i)).dMu() + " ";
        }
      }
      i += 1;
    }
    label224:
    ac.i("MicroMsg.SnsHeader", "refreshError %s %s %s", new Object[] { Integer.valueOf(localLinkedList.size()), localObject, this.yLM });
    if (((String)localObject).equals(this.yLM))
    {
      if (localLinkedList.size() > 0)
      {
        AppMethodBeat.o(98724);
        return true;
      }
      AppMethodBeat.o(98724);
      return false;
    }
    this.yLM = ((String)localObject);
    this.yLH.yLW.removeAllViews();
    localObject = this.yLH.yLW;
    label358:
    int j;
    final int k;
    label442:
    p localp2;
    TextView localTextView;
    if (localLinkedList.size() > 0)
    {
      i = 0;
      ((LinearLayout)localObject).setVisibility(i);
      Collections.sort(localLinkedList, new d());
      i = 0;
      if (i >= localLinkedList.size()) {
        break label670;
      }
      j = ((p)localLinkedList.get(i)).yvp;
      k = localLinkedList.size();
      if ((!this.yLL.containsKey(Integer.valueOf(j))) || (this.yLL.get(Integer.valueOf(j)) == null)) {
        break label541;
      }
      localObject = (View)this.yLL.get(Integer.valueOf(j));
      localObject = (LinearLayout)localObject;
      ((LinearLayout)localObject).getChildAt(0).setTag(((p)localLinkedList.get(i)).dMu());
      localp2 = (p)localLinkedList.get(i);
      localTextView = (TextView)((LinearLayout)localObject).findViewById(2131305032);
      if (localp2.field_type != 15) {
        break label598;
      }
      localTextView.setText(2131763947);
    }
    for (;;)
    {
      this.yLH.yLW.addView((View)localObject);
      i += 1;
      break label358;
      i = 8;
      break;
      label541:
      localObject = (LinearLayout)z.jD(this.context).inflate(2131494434, null);
      ((LinearLayout)localObject).getChildAt(0).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(98714);
          if ((paramAnonymousView.getTag() instanceof String))
          {
            Object localObject2 = (String)paramAnonymousView.getTag();
            ac.i("MicroMsg.SnsHeader", "sns Header localId ".concat(String.valueOf(localObject2)));
            paramAnonymousView = af.dHR().auT((String)localObject2);
            if ((SnsHeader.h(SnsHeader.this) != null) && (paramAnonymousView != null))
            {
              Object localObject1 = new Intent();
              ((Intent)localObject1).setClass(SnsHeader.h(SnsHeader.this), SnsCommentDetailUI.class);
              if ((paramAnonymousView == null) || (paramAnonymousView.field_userName == null) || (paramAnonymousView.field_userName.equals("")))
              {
                ac.i("MicroMsg.SnsHeader", "error cntinfo or username is null");
                AppMethodBeat.o(98714);
                return;
              }
              ((Intent)localObject1).putExtra("INTENT_TALKER", paramAnonymousView.field_userName);
              ((Intent)localObject1).putExtra("INTENT_SNS_LOCAL_ID", (String)localObject2);
              ((Intent)localObject1).putExtra("INTENT_FROMGALLERY", true);
              localObject2 = d.ps(726);
              ((d)localObject2).pv(k).pv(i).pv(paramAnonymousView.field_createTime);
              ((d)localObject2).aHZ();
              localObject2 = SnsHeader.h(SnsHeader.this);
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/sns/ui/SnsHeader$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              try
              {
                localObject1 = (bua)new bua().parseFrom(paramAnonymousView.field_postBuf);
                if ((((bua)localObject1).FjN == 201) || (((bua)localObject1).FjN == 210) || (((bua)localObject1).FjN != 211))
                {
                  ((bua)localObject1).FjV = true;
                  paramAnonymousView.field_postBuf = ((bua)localObject1).toByteArray();
                  af.dHR().b(paramAnonymousView.yvp, paramAnonymousView);
                }
                AppMethodBeat.o(98714);
                return;
              }
              catch (Exception paramAnonymousView) {}
            }
          }
          AppMethodBeat.o(98714);
        }
      });
      this.yLL.put(Integer.valueOf(j), localObject);
      break label442;
      label598:
      if (localp2.field_type == 2) {
        localTextView.setText(2131766824);
      } else if (localp2.field_type == 1) {
        localTextView.setText(2131763942);
      } else if (localp2.field_type == 26) {
        localTextView.setText(2131766823);
      } else {
        localTextView.setText(2131766822);
      }
    }
    label670:
    if (localLinkedList.size() > 0)
    {
      AppMethodBeat.o(98724);
      return true;
    }
    AppMethodBeat.o(98724);
    return false;
  }
  
  public int getLoadingGroupHeight()
  {
    AppMethodBeat.i(200513);
    int j = 0;
    int i = j;
    if (this.yLH != null)
    {
      i = j;
      if (this.yLH.yMa != null) {
        i = this.yLH.yMa.getHeight() + ao.fromDPToPix(getContext(), 32);
      }
    }
    AppMethodBeat.o(200513);
    return i;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(98725);
    if ((this.yLH != null) && (this.yLH.yLX != null) && (this.yLO)) {
      this.yLH.yLX.dUw();
    }
    if ((this.yLH != null) && (this.yLH.yLY != null) && (!this.yLO))
    {
      SnsStoryHeaderView localSnsStoryHeaderView = this.yLH.yLY;
      ac.i("MicroMsg.SnsStoryHeaderView", "resume: ");
      localSnsStoryHeaderView.dhO = false;
      ((e)g.ad(e.class)).getContactFetcher().dUQ();
      localSnsStoryHeaderView.post(new SnsStoryHeaderView.2(localSnsStoryHeaderView));
    }
    AppMethodBeat.o(98725);
  }
  
  public void setAvatarOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(98722);
    if ((this.yLH != null) && (this.yLH.fxQ != null)) {
      this.yLH.fxQ.setOnClickListener(paramOnClickListener);
    }
    AppMethodBeat.o(98722);
  }
  
  public void setBackClickListener(a parama)
  {
    this.yLI = parama;
  }
  
  public void setEnterObjectId(String paramString)
  {
    AppMethodBeat.i(98720);
    this.ycH = paramString;
    if ((this.yLH != null) && (this.yLH.yLY != null) && (!this.yLO)) {
      this.yLH.yLY.setEnterObjectId(paramString);
    }
    AppMethodBeat.o(98720);
  }
  
  public void setHeadBgListener(b paramb)
  {
    this.yLJ = paramb;
  }
  
  public void setSessionId(String paramString)
  {
    AppMethodBeat.i(98719);
    this.sessionId = paramString;
    if ((this.yLH != null) && (this.yLH.yLY != null) && (!this.yLO)) {
      this.yLH.yLY.setSessionId(paramString);
    }
    AppMethodBeat.o(98719);
  }
  
  public void setStoryAction(SnsStoryHeaderView.a parama)
  {
    AppMethodBeat.i(98718);
    if ((this.yLH != null) && (this.yLH.yLY != null) && (!this.yLO)) {
      this.yLH.yLY.setStoryAction(parama);
    }
    AppMethodBeat.o(98718);
  }
  
  public void setType(int paramInt)
  {
    AppMethodBeat.i(98717);
    this.type = paramInt;
    if ((paramInt == 1) && (this.yLH.yxl != null)) {
      this.yLH.yxl.setVisibility(8);
    }
    if (this.yLH != null)
    {
      if ((this.yLH.yLX != null) && (this.yLO)) {
        this.yLH.yLX.setSnsType(paramInt);
      }
      if ((this.yLH.yLY != null) && (!this.yLO)) {
        this.yLH.yLY.setSnsType(paramInt);
      }
    }
    if (paramInt != 1)
    {
      if ((this.yLH.yLX != null) && (this.yLH.yLX.getParent() != null) && ((this.yLH.yLX.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.yLH.yLX.getParent()).removeView(this.yLH.yLX);
      }
      if ((this.yLH.yLY != null) && (this.yLH.yLY.getParent() != null) && ((this.yLH.yLY.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.yLH.yLY.getParent()).removeView(this.yLH.yLY);
      }
    }
    if (paramInt == 1)
    {
      this.yLH.yMa.setPadding(0, ap.dT(this.context) + ap.ej(this.context) - getResources().getDimensionPixelSize(2131166841), 0, ao.fromDPToPix(this.context, 10));
      AppMethodBeat.o(98717);
      return;
    }
    if (paramInt == 2) {
      this.yLH.yMa.setPadding(0, ap.dT(this.context) + ap.ej(this.context) + ao.fromDPToPix(getContext(), 90) + ao.fromDPToPix(getContext(), 48), 0, 0);
    }
    AppMethodBeat.o(98717);
  }
  
  public static abstract interface a
  {
    public abstract boolean dPH();
    
    public abstract boolean xP(long paramLong);
  }
  
  public static abstract interface b {}
  
  final class c
  {
    ImageView fxQ;
    TextView nbZ;
    ImageView yLT;
    ImageView yLU;
    LinearLayout yLV;
    LinearLayout yLW;
    AbsStoryHeaderTipView yLX;
    SnsStoryHeaderView yLY;
    RelativeLayout yLZ;
    LinearLayout yMa;
    ImageView yMb;
    TextView yxl;
    
    c() {}
  }
  
  final class d
    implements Comparator<p>
  {
    d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsHeader
 * JD-Core Version:    0.7.0.1
 */