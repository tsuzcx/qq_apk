package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.ad.a;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.pluginsdk.ui.span.k.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.widget.InputPanelLinearLayout;
import com.tencent.mm.ui.widget.edittext.a.c;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SnsCommentFooter
  extends InputPanelLinearLayout
{
  public static String iIm;
  dzo DIu;
  com.tencent.mm.ui.widget.cedit.api.c ECK;
  private ImageView ECL;
  private ImageView ECM;
  private Button ECN;
  int ECO;
  private int ECP;
  private int ECQ;
  private String ECR;
  private b ECS;
  boolean ECT;
  private boolean ECU;
  private boolean ECV;
  public boolean ECW;
  private String ECX;
  private boolean ECY;
  private a ECZ;
  private c EDa;
  private bt EDb;
  MMActivity gte;
  private Button han;
  private String mSessionId;
  private int moe;
  ChatFooterPanel rum;
  int state;
  private ImageButton ziQ;
  private boolean ziS;
  public boolean ziT;
  private boolean ziU;
  boolean ziV;
  private TextWatcher ziW;
  
  public SnsCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(98650);
    this.DIu = null;
    this.ECO = 0;
    this.state = 0;
    this.ziS = false;
    this.ECP = -1;
    this.ECQ = -1;
    this.moe = 0;
    this.ECS = null;
    this.ECT = false;
    this.ECU = false;
    this.ECV = KeyBoardUtil.isPortOrientation(getContext());
    this.ziT = false;
    this.ziU = true;
    this.ECX = "";
    this.ECY = false;
    this.ziV = true;
    this.ziW = new TextWatcher()
    {
      private int EDi = 0;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(98639);
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
        {
          AppMethodBeat.o(98639);
          return;
        }
        if ((com.tencent.mm.plugin.sns.ui.widget.e.iY(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!Util.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (SnsCommentFooter.b(SnsCommentFooter.this).getText() != null) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
        {
          Log.i("MicroMsg.SnsCommentFooter", "cur text %s", new Object[] { SnsCommentFooter.b(SnsCommentFooter.this).getText() });
          SnsCommentFooter.a(SnsCommentFooter.this, "");
          SnsCommentFooter.e(SnsCommentFooter.this);
          SnsCommentFooter.this.ZI(8);
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
        SnsCommentFooter.b(SnsCommentFooter.this).gYJ();
        if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) && (SnsCommentFooter.this.ziV))
          {
            SnsCommentFooter.a(SnsCommentFooter.this, true);
            SnsCommentFooter.this.ziV = false;
          }
          if (i == 0)
          {
            SnsCommentFooter.a(SnsCommentFooter.this, false);
            SnsCommentFooter.this.ziV = true;
          }
          AppMethodBeat.o(98639);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98637);
        if (paramAnonymousCharSequence == null) {}
        for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = paramAnonymousCharSequence.length())
        {
          this.EDi = paramAnonymousInt1;
          AppMethodBeat.o(98637);
          return;
        }
      }
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(98638);
        if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < com.tencent.mm.plugin.sns.c.a.DCT))
        {
          SnsCommentFooter.this.ZI(16);
          Log.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
          AppMethodBeat.o(98638);
          return;
        }
        if (paramAnonymousCharSequence.length() - this.EDi > com.tencent.mm.plugin.sns.c.a.DCT)
        {
          SnsCommentFooter.this.setCommentFlag(16);
          Log.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
        }
        AppMethodBeat.o(98638);
      }
    };
    this.mSessionId = com.tencent.mm.plugin.fts.a.d.Nj(79);
    this.gte = ((MMActivity)paramContext);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
    {
      if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sdI, 0) == 1) {}
      for (bool = true;; bool = false)
      {
        this.ECT = bool;
        AppMethodBeat.o(98650);
        return;
      }
    }
    if (((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sdI, 0) == 1) {}
    for (;;)
    {
      this.ECT = bool;
      AppMethodBeat.o(98650);
      return;
      bool = false;
    }
  }
  
  public static void a(Context paramContext, Object paramObject, boolean paramBoolean, String paramString1, int paramInt, String paramString2, long paramLong)
  {
    AppMethodBeat.i(203561);
    if (!(paramObject instanceof SnsInfo))
    {
      AppMethodBeat.o(203561);
      return;
    }
    paramObject = (SnsInfo)paramObject;
    int k;
    int i;
    label43:
    String str;
    int j;
    if (paramBoolean)
    {
      k = 3;
      i = 1;
      if (!(paramContext instanceof SnsTimeLineUI)) {
        break label104;
      }
      i = 1;
      paramContext = paramObject.field_userName;
      str = com.tencent.mm.plugin.sns.data.r.Jb(paramObject.field_snsId);
      if (!paramObject.isAd()) {
        break label130;
      }
      j = 2;
    }
    for (;;)
    {
      com.tencent.mm.plugin.websearch.a.b.a(k, i, paramContext, str, j, String.valueOf(paramString1), iIm, paramInt, paramString2, paramLong);
      AppMethodBeat.o(203561);
      return;
      k = 2;
      break;
      label104:
      if ((paramContext instanceof SnsCommentDetailUI))
      {
        i = 3;
        break label43;
      }
      if (!(paramContext instanceof SnsCommentUI)) {
        break label43;
      }
      i = 2;
      break label43;
      label130:
      if (paramObject.isWxWork()) {
        j = 3;
      } else {
        j = 1;
      }
    }
  }
  
  private void cbL()
  {
    AppMethodBeat.i(98654);
    this.rum.onResume();
    if ((KeyBoardUtil.isPortOrientation(getContext())) && (fia())) {
      getInputPanelHelper().aQ(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98635);
          SnsCommentFooter.a(SnsCommentFooter.this).setVisibility(0);
          AppMethodBeat.o(98635);
        }
      });
    }
    for (;;)
    {
      if (this.EDa != null) {
        this.EDa.onShow();
      }
      AppMethodBeat.o(98654);
      return;
      this.rum.setVisibility(0);
    }
  }
  
  private void fhZ()
  {
    AppMethodBeat.i(98666);
    int i = KeyBoardUtil.getValidPanelHeight(getContext());
    if (this.rum != null)
    {
      this.rum.setPortHeightPx(i);
      ViewGroup.LayoutParams localLayoutParams = this.rum.getLayoutParams();
      if (localLayoutParams != null) {
        localLayoutParams.height = i;
      }
    }
    AppMethodBeat.o(98666);
  }
  
  private boolean fia()
  {
    AppMethodBeat.i(98667);
    int i = com.tencent.mm.ui.ao.aD(getContext());
    Log.i("MicroMsg.SnsCommentFooter", "is show key board %d, %d, %d", new Object[] { Integer.valueOf(this.ECQ), Integer.valueOf(this.ECP), Integer.valueOf(i) });
    if ((this.ECQ > 0) && (this.ECQ < this.ECP - i))
    {
      AppMethodBeat.o(98667);
      return true;
    }
    AppMethodBeat.o(98667);
    return false;
  }
  
  private void qT(boolean paramBoolean)
  {
    AppMethodBeat.i(98670);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772119);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772124);
    localAnimation1.setDuration(150L);
    localAnimation2.setDuration(150L);
    if ((this.han == null) || (this.ECN == null))
    {
      AppMethodBeat.o(98670);
      return;
    }
    if (paramBoolean)
    {
      if ((this.han.getVisibility() == 8) || (this.han.getVisibility() == 4))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.ECN.startAnimation(localAnimation1);
      this.ECN.setVisibility(0);
      this.han.startAnimation(localAnimation2);
      this.han.setVisibility(8);
    }
    for (;;)
    {
      this.ECN.getParent().requestLayout();
      AppMethodBeat.o(98670);
      return;
      if ((this.han.getVisibility() == 0) || (this.han.getVisibility() == 0))
      {
        AppMethodBeat.o(98670);
        return;
      }
      this.han.startAnimation(localAnimation1);
      this.han.setVisibility(0);
      this.ECN.startAnimation(localAnimation2);
      this.ECN.setVisibility(8);
    }
  }
  
  public final void ZI(int paramInt)
  {
    this.ECO &= (paramInt ^ 0xFFFFFFFF);
  }
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(98665);
    super.f(paramBoolean, paramInt);
    this.ziT = paramBoolean;
    if ((paramBoolean) && (getVisibility() == 0) && (this.EDb != null))
    {
      Log.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
      this.EDb.fjX();
    }
    this.ECK.CS(paramBoolean);
    if ((this.moe != paramInt) && (paramInt != 0))
    {
      this.moe = paramInt;
      i.C(getContext(), paramInt);
      fhZ();
    }
    AppMethodBeat.o(98665);
  }
  
  public final boolean fhV()
  {
    AppMethodBeat.i(98649);
    if ((this.ECK.getText() == null) || (Util.isNullOrNil(this.ECK.getText().toString())))
    {
      AppMethodBeat.o(98649);
      return true;
    }
    AppMethodBeat.o(98649);
    return false;
  }
  
  public final boolean fhW()
  {
    return this.state == 1;
  }
  
  public final void fhX()
  {
    AppMethodBeat.i(98655);
    if (this.ECK == null)
    {
      Log.e("MicroMsg.SnsCommentFooter", "send edittext is null");
      AppMethodBeat.o(98655);
      return;
    }
    this.ECK.removeTextChangedListener(this.ziW);
    this.ECK.addTextChangedListener(this.ziW);
    AppMethodBeat.o(98655);
  }
  
  public final void fhY()
  {
    AppMethodBeat.i(98660);
    this.ECK.setText("");
    this.ECK.setHint("");
    this.DIu = null;
    this.ECO = 0;
    this.state = 0;
    AppMethodBeat.o(98660);
  }
  
  public final void fib()
  {
    AppMethodBeat.i(98669);
    this.EDb = null;
    if (this.rum != null)
    {
      Log.i("MicroMsg.SnsCommentFooter", "commentfooter release");
      this.rum.goC();
      this.rum.destroy();
    }
    if (this.ECK != null) {
      this.ECK.destroy();
    }
    AppMethodBeat.o(98669);
  }
  
  public String getCommentAtPrefix()
  {
    return this.ECR;
  }
  
  public int getCommentFlag()
  {
    return this.ECO;
  }
  
  public dzo getCommentInfo()
  {
    AppMethodBeat.i(98661);
    if (this.DIu == null)
    {
      localdzo = new dzo();
      AppMethodBeat.o(98661);
      return localdzo;
    }
    dzo localdzo = this.DIu;
    AppMethodBeat.o(98661);
    return localdzo;
  }
  
  public final void o(final List<k> paramList, String paramString)
  {
    AppMethodBeat.i(98656);
    this.ECX = paramString;
    k localk;
    if (this.ECK != null)
    {
      if (Util.isNullOrNil(paramString)) {
        break label180;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localk = (k)localIterator.next();
        if (paramString.equals(localk.key)) {
          paramList.remove(localk);
        }
      }
    }
    label180:
    for (paramString = Util.nullAs(localk.text, "");; paramString = "")
    {
      if (!Util.isNullOrNil(paramString))
      {
        this.ECN.setVisibility(0);
        this.han.setVisibility(8);
        this.ECK.setText("");
        this.ECK.bol(paramString);
      }
      for (;;)
      {
        if (!this.ECY) {
          this.ECK.addTextChangedListener(new TextWatcher()
          {
            int EDi = 0;
            
            public final void afterTextChanged(Editable paramAnonymousEditable)
            {
              AppMethodBeat.i(98642);
              if (SnsCommentFooter.b(SnsCommentFooter.this).getText() == null)
              {
                AppMethodBeat.o(98642);
                return;
              }
              if ((com.tencent.mm.plugin.sns.ui.widget.e.iY(SnsCommentFooter.c(SnsCommentFooter.this), 8)) && (!Util.isNullOrNil(SnsCommentFooter.d(SnsCommentFooter.this))) && (!Util.isNullOrNil(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString())) && (!SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().startsWith(SnsCommentFooter.d(SnsCommentFooter.this))))
              {
                Log.i("MicroMsg.SnsCommentFooter", "commentAtPrefix [%s], curTxt [%s]", new Object[] { SnsCommentFooter.d(SnsCommentFooter.this), SnsCommentFooter.b(SnsCommentFooter.this).getText() });
                SnsCommentFooter.a(SnsCommentFooter.this, "");
                SnsCommentFooter.e(SnsCommentFooter.this);
                SnsCommentFooter.this.ZI(8);
                SnsCommentFooter.a(SnsCommentFooter.this, 0);
              }
              Log.d("MicroMsg.SnsCommentFooter", "update commentkey:" + SnsCommentFooter.f(SnsCommentFooter.this));
              if (!Util.isNullOrNil(SnsCommentFooter.f(SnsCommentFooter.this)))
              {
                paramAnonymousEditable = paramList.iterator();
                while (paramAnonymousEditable.hasNext())
                {
                  k localk = (k)paramAnonymousEditable.next();
                  if (SnsCommentFooter.f(SnsCommentFooter.this).equals(localk.key))
                  {
                    Log.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                    localk.text = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
                    localk.cSx = SnsCommentFooter.c(SnsCommentFooter.this);
                  }
                }
              }
              for (int i = 1;; i = 0)
              {
                if (i == 0)
                {
                  Log.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                  paramAnonymousEditable = new k();
                  paramAnonymousEditable.key = SnsCommentFooter.f(SnsCommentFooter.this);
                  paramAnonymousEditable.text = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
                  paramAnonymousEditable.cSx = SnsCommentFooter.c(SnsCommentFooter.this);
                  if ((paramAnonymousEditable.text != null) && (paramAnonymousEditable.text.length() > 0)) {
                    paramList.add(paramAnonymousEditable);
                  }
                }
                if (paramList.size() > 5)
                {
                  Log.d("MicroMsg.SnsCommentFooter", "comments remove");
                  paramList.remove(0);
                }
                SnsCommentFooter.b(SnsCommentFooter.this).gYJ();
                if (SnsCommentFooter.b(SnsCommentFooter.this).getText().toString().trim().length() > 0) {}
                for (boolean bool = true;; bool = false)
                {
                  if ((bool) && (SnsCommentFooter.this.ziV))
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.ziV = false;
                  }
                  if (!bool)
                  {
                    SnsCommentFooter.a(SnsCommentFooter.this, bool);
                    SnsCommentFooter.this.ziV = true;
                  }
                  AppMethodBeat.o(98642);
                  return;
                }
              }
            }
            
            public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(98641);
              if (paramAnonymousCharSequence == null) {}
              for (paramAnonymousInt1 = 0;; paramAnonymousInt1 = paramAnonymousCharSequence.length())
              {
                this.EDi = paramAnonymousInt1;
                AppMethodBeat.o(98641);
                return;
              }
            }
            
            public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
            {
              AppMethodBeat.i(98640);
              if ((paramAnonymousCharSequence == null) || (paramAnonymousCharSequence.length() < com.tencent.mm.plugin.sns.c.a.DCT))
              {
                SnsCommentFooter.this.ZI(16);
                Log.d("MicroMsg.SnsCommentFooter", "clean SNS_COMMENT_FLAG_FOLD");
                AppMethodBeat.o(98640);
                return;
              }
              if (paramAnonymousCharSequence.length() - this.EDi > com.tencent.mm.plugin.sns.c.a.DCT)
              {
                SnsCommentFooter.this.setCommentFlag(16);
                Log.d("MicroMsg.SnsCommentFooter", "add SNS_COMMENT_FLAG_FOLD");
              }
              AppMethodBeat.o(98640);
            }
          });
        }
        this.ECY = true;
        AppMethodBeat.o(98656);
        return;
        this.ECK.setText("");
      }
    }
  }
  
  public final void oY(boolean paramBoolean)
  {
    AppMethodBeat.i(98659);
    if (this.ECL != null)
    {
      if (paramBoolean)
      {
        this.ECL.setVisibility(0);
        if ((com.tencent.mm.n.h.aqJ().getInt("SnsAdAtFriendRedDot", 0) == 1) && (g.aAh().azQ().getBoolean(ar.a.Oiq, true)))
        {
          this.ECM.setVisibility(0);
          AppMethodBeat.o(98659);
          return;
        }
        this.ECM.setVisibility(8);
        AppMethodBeat.o(98659);
        return;
      }
      this.ECL.setVisibility(8);
      this.ECM.setVisibility(8);
    }
    AppMethodBeat.o(98659);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(98664);
    super.onConfigurationChanged(paramConfiguration);
    if (this.rum != null) {
      fhZ();
    }
    AppMethodBeat.o(98664);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(98668);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.ECP < paramInt4) {}
    for (paramInt1 = paramInt4;; paramInt1 = this.ECP)
    {
      this.ECP = paramInt1;
      this.ECQ = paramInt4;
      AppMethodBeat.o(98668);
      return;
    }
  }
  
  public void setAfterEditAction(Runnable paramRunnable)
  {
    AppMethodBeat.i(98651);
    paramRunnable = (ViewGroup)inflate(this.gte, 2131496429, this);
    this.ECL = ((ImageView)paramRunnable.findViewById(2131296622));
    this.ECM = ((ImageView)paramRunnable.findViewById(2131296623));
    this.han = ((Button)paramRunnable.findViewById(2131296637));
    this.ECN = ((Button)paramRunnable.findViewById(2131296630));
    this.ECK = ((com.tencent.mm.ui.widget.cedit.api.c)paramRunnable.findViewById(2131296626));
    this.ECK.refresh(((PluginWebSearch)g.ah(PluginWebSearch.class)).isUseSysEditText());
    a.e local2 = new a.e()
    {
      public final void A(List<a.c> paramAnonymousList, int paramAnonymousInt)
      {
        AppMethodBeat.i(203554);
        long l = cl.aWB();
        if ((((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag()) && (paramAnonymousInt != 8) && (paramAnonymousInt != 1))
        {
          paramAnonymousList.add(new a.c(SnsCommentFooter.h(SnsCommentFooter.this).getString(2131766606), 2));
          SnsCommentFooter.a(SnsCommentFooter.this.getContext(), SnsCommentFooter.this.getTag(), SnsCommentFooter.r(SnsCommentFooter.this), "", 1, "", l);
        }
        AppMethodBeat.o(203554);
      }
      
      public final void a(View paramAnonymousView, a.c paramAnonymousc, String paramAnonymousString)
      {
        AppMethodBeat.i(203555);
        long l = cl.aWB();
        if (paramAnonymousc.id == 2)
        {
          SnsCommentFooter.b(SnsCommentFooter.this).getText().insert(SnsCommentFooter.b(SnsCommentFooter.this).getSelectionStart(), SnsCommentFooter.h(SnsCommentFooter.this).getString(2131766606));
          SnsCommentFooter.a(SnsCommentFooter.this.getContext(), SnsCommentFooter.this.getTag(), SnsCommentFooter.r(SnsCommentFooter.this), "", 2, "", l);
        }
        AppMethodBeat.o(203555);
      }
    };
    this.ECK.a(((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseBrands(), ((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).getNeedReuseItems(), LocaleUtil.getCurrentLanguage(this.gte), local2);
    this.ECK.addTextChangedListener(new TextWatcher()
    {
      private List<ForegroundColorSpan> EDf;
      
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(203557);
        paramAnonymousEditable = SnsCommentFooter.b(SnsCommentFooter.this).getText();
        Object localObject = this.EDf.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramAnonymousEditable.removeSpan((ForegroundColorSpan)((Iterator)localObject).next());
        }
        this.EDf.clear();
        localObject = SnsCommentFooter.b(SnsCommentFooter.this).getText().toString();
        if (((com.tencent.mm.plugin.websearch.api.c)g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenInlineSnsTag())
        {
          localObject = k.a.Krb.matcher((CharSequence)localObject);
          while (((Matcher)localObject).find())
          {
            ((Matcher)localObject).group();
            int i = ((Matcher)localObject).start();
            int j = ((Matcher)localObject).end();
            ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(SnsCommentFooter.this.getResources().getColor(2131099784));
            this.EDf.add(localForegroundColorSpan);
            paramAnonymousEditable.setSpan(localForegroundColorSpan, i, j, 33);
          }
        }
        AppMethodBeat.o(203557);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    qT(false);
    this.ECL.setOnClickListener(new SnsCommentFooter.9(this));
    this.ziQ = ((ImageButton)paramRunnable.findViewById(2131296635));
    this.ziQ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98644);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        SnsCommentFooter.this.setModeClick(true);
        Log.i("MicroMsg.SnsCommentFooter", "state onClick" + SnsCommentFooter.i(SnsCommentFooter.this));
        if (SnsCommentFooter.i(SnsCommentFooter.this) == 0)
        {
          SnsCommentFooter.b(SnsCommentFooter.this).gYJ();
          SnsCommentFooter.this.gte.hideVKB();
          SnsCommentFooter.a(SnsCommentFooter.this, 1);
          SnsCommentFooter.j(SnsCommentFooter.this);
          SnsCommentFooter.this.setToSendTextColor(false);
          SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131231777);
          SnsCommentFooter.l(SnsCommentFooter.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98644);
          return;
          SnsCommentFooter.m(SnsCommentFooter.this);
          SnsCommentFooter.l(SnsCommentFooter.this);
          SnsCommentFooter.b(SnsCommentFooter.this).gYJ();
          SnsCommentFooter.this.gte.showVKB();
          SnsCommentFooter.this.setToSendTextColor(true);
          SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131690793);
          SnsCommentFooter.a(SnsCommentFooter.this, 0);
        }
      }
    });
    this.ECK.setHint(this.gte.getString(2131766285));
    paramRunnable = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(98645);
        SnsCommentFooter.this.setToSendTextColor(true);
        SnsCommentFooter.l(SnsCommentFooter.this);
        SnsCommentFooter.m(SnsCommentFooter.this);
        SnsCommentFooter.k(SnsCommentFooter.this).setImageResource(2131690793);
        if (SnsCommentFooter.n(SnsCommentFooter.this) != null) {
          SnsCommentFooter.n(SnsCommentFooter.this).fhU();
        }
        SnsCommentFooter.a(SnsCommentFooter.this, 0);
        AppMethodBeat.o(98645);
        return false;
      }
    };
    this.ECK.setOnTouchListener(paramRunnable);
    if (com.tencent.mm.pluginsdk.ui.chat.e.Knc == null)
    {
      this.rum = new com.tencent.mm.pluginsdk.ui.chat.d(this.gte);
      AppMethodBeat.o(98651);
      return;
    }
    this.rum = com.tencent.mm.pluginsdk.ui.chat.e.Knc.eZ(getContext());
    this.rum.setEntranceScene(ChatFooterPanel.KbG);
    this.rum.setVisibility(8);
    paramRunnable = (LinearLayout)findViewById(2131307157);
    this.moe = KeyBoardUtil.getValidPanelHeight(getContext());
    paramRunnable.addView(this.rum, -1, this.moe);
    if (!this.ECT) {
      this.rum.goD();
    }
    this.rum.onResume();
    this.rum.setOnTextOperationListener(new ChatFooterPanel.a()
    {
      public final void aHC()
      {
        AppMethodBeat.i(98647);
        if (SnsCommentFooter.b(SnsCommentFooter.this) != null)
        {
          if (SnsCommentFooter.b(SnsCommentFooter.this).getInputConnection() == null)
          {
            AppMethodBeat.o(98647);
            return;
          }
          SnsCommentFooter.b(SnsCommentFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
          SnsCommentFooter.b(SnsCommentFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
        }
        AppMethodBeat.o(98647);
      }
      
      public final void aHD() {}
      
      public final void append(String paramAnonymousString)
      {
        AppMethodBeat.i(98648);
        try
        {
          SnsCommentFooter.b(SnsCommentFooter.this).bol(paramAnonymousString);
          AppMethodBeat.o(98648);
          return;
        }
        catch (Exception paramAnonymousString)
        {
          Log.printErrStackTrace("MicroMsg.SnsCommentFooter", paramAnonymousString, "", new Object[0]);
          AppMethodBeat.o(98648);
        }
      }
      
      public final void eP(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(98646);
        SnsCommentFooter.this.setToSendTextColor(paramAnonymousBoolean);
        AppMethodBeat.o(98646);
      }
    });
    paramRunnable = ad.djd.VL();
    paramRunnable.djc = new ac.a()
    {
      public final void a(final com.tencent.mm.api.r paramAnonymousr)
      {
        AppMethodBeat.i(98631);
        if ((paramAnonymousr instanceof EmojiInfo))
        {
          boolean bool = false;
          String str;
          if ((SnsCommentFooter.o(SnsCommentFooter.this) != null) && (!Util.isNullOrNil(SnsCommentFooter.o(SnsCommentFooter.this).Username)))
          {
            str = SnsCommentFooter.o(SnsCommentFooter.this).Username;
            bool = true;
          }
          while (!SnsCommentFooter.p(SnsCommentFooter.this))
          {
            AppMethodBeat.o(98631);
            return;
            if ((SnsCommentFooter.this.getTag() != null) && ((SnsCommentFooter.this.getTag() instanceof SnsInfo)))
            {
              str = ((SnsInfo)SnsCommentFooter.this.getTag()).getUserName();
            }
            else
            {
              AppMethodBeat.o(98631);
              return;
            }
          }
          com.tencent.mm.plugin.sns.c.a.jRt.a(SnsCommentFooter.h(SnsCommentFooter.this), str, ((EmojiInfo)paramAnonymousr).field_md5, bool, new y.a()
          {
            public final void a(boolean paramAnonymous2Boolean, String paramAnonymous2String, int paramAnonymous2Int)
            {
              AppMethodBeat.i(98630);
              if ((SnsCommentFooter.q(SnsCommentFooter.this) != null) && (paramAnonymous2Boolean)) {
                if (!com.tencent.mm.plugin.sns.ui.widget.e.iY(SnsCommentFooter.c(SnsCommentFooter.this), 8)) {
                  break label94;
                }
              }
              label94:
              for (paramAnonymous2String = SnsCommentFooter.this.getCommentAtPrefix();; paramAnonymous2String = "")
              {
                SnsCommentFooter.q(SnsCommentFooter.this).kP(paramAnonymous2String, ((EmojiInfo)paramAnonymousr).field_md5);
                com.tencent.mm.plugin.report.service.h.CyF.dN(150, 81);
                AppMethodBeat.o(98630);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(98631);
      }
      
      public final void onHide() {}
    };
    this.rum.setCallback(paramRunnable);
    AppMethodBeat.o(98651);
  }
  
  public void setAnitiomAdjust(bt parambt)
  {
    this.EDb = parambt;
  }
  
  public void setCommentAtPrefix(String paramString)
  {
    this.ECR = paramString;
  }
  
  public void setCommentFlag(int paramInt)
  {
    this.ECO |= paramInt;
  }
  
  public void setCommentHint(String paramString)
  {
    AppMethodBeat.i(98658);
    if (!Util.isNullOrNil(paramString))
    {
      if (com.tencent.mm.plugin.sns.ui.widget.e.iY(this.ECO, 1))
      {
        this.ECK.setHint(l.b(getContext(), this.gte.getString(2131765936) + paramString + this.gte.getString(2131765997, new Object[] { Float.valueOf(this.ECK.getTextSize()) }), this.ECK.getTextSize()));
        AppMethodBeat.o(98658);
        return;
      }
      this.ECK.setHint(l.b(getContext(), paramString, this.ECK.getTextSize()));
      AppMethodBeat.o(98658);
      return;
    }
    this.ECK.setHint("");
    AppMethodBeat.o(98658);
  }
  
  public void setCommentInfo(dzo paramdzo)
  {
    this.DIu = paramdzo;
  }
  
  public void setFeedEmojiCommentEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(176296);
    this.ECU = paramBoolean;
    Log.i("MicroMsg.SnsCommentFooter", "setFeedEmojiCommentEnable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(176296);
  }
  
  public void setModeClick(boolean paramBoolean)
  {
    this.ziS = paramBoolean;
  }
  
  public void setOnCommentSendImp(final b paramb)
  {
    AppMethodBeat.i(98663);
    this.ECS = paramb;
    this.ECN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203560);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        com.tencent.mm.ui.widget.cedit.api.d.a(SnsCommentFooter.b(SnsCommentFooter.this)).aoq(com.tencent.mm.n.c.aqk()).CN(true).a(new c.a()
        {
          public final void Tw(String paramAnonymous2String)
          {
            AppMethodBeat.i(203558);
            SnsCommentFooter.b(SnsCommentFooter.this).getText();
            SnsCommentFooter.4.this.EDg.kP(SnsCommentFooter.b(SnsCommentFooter.this).getText().toString(), "");
            SnsCommentFooter.b(SnsCommentFooter.this).setText("");
            AppMethodBeat.o(203558);
          }
          
          public final void Tx(String paramAnonymous2String) {}
          
          public final void dv(String paramAnonymous2String)
          {
            AppMethodBeat.i(203559);
            com.tencent.mm.ui.base.h.n(SnsCommentFooter.h(SnsCommentFooter.this), 2131766298, 2131766299);
            AppMethodBeat.o(203559);
          }
        });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203560);
      }
    });
    AppMethodBeat.o(98663);
  }
  
  public void setOnEditTouchListener(a parama)
  {
    this.ECZ = parama;
  }
  
  public void setOnSmileyShowListener(c paramc)
  {
    this.EDa = paramc;
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(98657);
    if (this.ECK != null)
    {
      this.ECK.setText("");
      this.ECK.bol(paramString);
    }
    AppMethodBeat.o(98657);
  }
  
  public void setToSendTextColor(boolean paramBoolean)
  {
    AppMethodBeat.i(98662);
    if (this.ECK == null)
    {
      AppMethodBeat.o(98662);
      return;
    }
    if (paramBoolean)
    {
      this.ECK.setTextColor(getResources().getColor(2131100806));
      AppMethodBeat.o(98662);
      return;
    }
    this.ECK.setTextColor(getResources().getColor(2131100584));
    Log.i("MicroMsg.SnsCommentFooter", "focusEdt: %s, %s", new Object[] { Boolean.FALSE, this.ECK });
    if (this.ECK != null) {
      this.ECK.clearFocus();
    }
    AppMethodBeat.o(98662);
  }
  
  public void setVisibility(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(98652);
    this.state = 0;
    if (paramInt == 0) {
      bool = true;
    }
    vt(bool);
    super.setVisibility(paramInt);
    AppMethodBeat.o(98652);
  }
  
  public final void vt(boolean paramBoolean)
  {
    AppMethodBeat.i(98653);
    if (this.rum == null)
    {
      AppMethodBeat.o(98653);
      return;
    }
    this.ECW = paramBoolean;
    Log.i("MicroMsg.SnsCommentFooter", "showState ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      this.rum.setVisibility(8);
      this.ziQ.setImageResource(2131690793);
      this.gte.hideVKB();
      requestLayout();
      AppMethodBeat.o(98653);
      return;
    }
    iIm = com.tencent.mm.plugin.fts.a.d.Nj(79);
    if (this.state == 0)
    {
      this.ECK.gYJ();
      this.gte.showVKB();
      this.rum.setVisibility(8);
    }
    for (;;)
    {
      this.ziU = false;
      AppMethodBeat.o(98653);
      return;
      this.ECK.gYJ();
      this.gte.hideVKB();
      cbL();
    }
  }
  
  static abstract interface a
  {
    public abstract void fhU();
  }
  
  static abstract interface b
  {
    public abstract void kP(String paramString1, String paramString2);
  }
  
  static abstract interface c
  {
    public abstract void onShow();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter
 * JD-Core Version:    0.7.0.1
 */