package com.tencent.mm.plugin.mv.ui.view;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.ui.uic.KeyboardProviderUIC;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentModeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "curEditMode", "hasWindowFocus", "", "lastKeyboardShow", "moveHeight", "nextEditMode", "onCommentSend", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "smilePanelHeight", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "toSendET", "Lcom/tencent/mm/ui/widget/MMEditText;", "allGone", "", "getTrueHeight", "hideSmileyPanel", "init", "initEditText", "initEmojiBtn", "initSmilePanel", "onKeyboardHeightChanged", "height", "isResized", "onWindowFocusChanged", "onlyShowSmilePanel", "onlyShowVKB", "refreshBottomPanelHeight", "send", "setEditViewBackground", "id", "setOnCommentSendImp", "imp", "setVisibility", "visibility", "showSmileyPanel", "showState", "isShow", "Companion", "IOnCommentSend", "plugin-mv_release"})
public final class MusicMvCommentFooter
  extends LinearLayout
  implements g
{
  public static final a AxI;
  private WeImageView AxC;
  private int AxD;
  private int AxE;
  private boolean AxF;
  private b AxG;
  private boolean AxH;
  private ChatFooterPanel rum;
  private int wBU;
  private int ygg;
  private MMEditText ziR;
  
  static
  {
    AppMethodBeat.i(257494);
    AxI = new a((byte)0);
    AppMethodBeat.o(257494);
  }
  
  public MusicMvCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(257492);
    this.wBU = 200;
    this.AxD = 200;
    this.AxE = -1;
    init();
    AppMethodBeat.o(257492);
  }
  
  public MusicMvCommentFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(257493);
    this.wBU = 200;
    this.AxD = 200;
    this.AxE = -1;
    init();
    AppMethodBeat.o(257493);
  }
  
  private final void cbM()
  {
    AppMethodBeat.i(257489);
    Log.i("Music.MusicMvCommentFooter", "hideSmileyPanel");
    Object localObject = this.AxC;
    if (localObject != null) {
      ((WeImageView)localObject).setImageResource(2131690793);
    }
    localObject = this.AxC;
    if (localObject != null)
    {
      Context localContext = getContext();
      p.g(localContext, "context");
      ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(2131099844));
    }
    localObject = this.rum;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((ChatFooterPanel)localObject).animate().cancel();
    localObject = this.rum;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    if (((ChatFooterPanel)localObject).getVisibility() == 0)
    {
      localObject = this.rum;
      if (localObject == null) {
        p.btv("smileyPanel");
      }
      ((ChatFooterPanel)localObject).onPause();
      localObject = this.rum;
      if (localObject == null) {
        p.btv("smileyPanel");
      }
      ((ChatFooterPanel)localObject).animate().alpha(0.0F).setDuration(175L).withEndAction((Runnable)new c(this)).start();
    }
    AppMethodBeat.o(257489);
  }
  
  private final void ewq()
  {
    AppMethodBeat.i(257487);
    Log.i("Music.MusicMvCommentFooter", "onlyShowVKB");
    this.AxD = 201;
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(257487);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).showVKB();
    AppMethodBeat.o(257487);
  }
  
  private final void init()
  {
    AppMethodBeat.i(257488);
    View.inflate(getContext(), 2131495781, (ViewGroup)this);
    this.AxC = ((WeImageView)findViewById(2131298956));
    Object localObject1 = this.AxC;
    if (localObject1 != null) {
      ((WeImageView)localObject1).setOnClickListener((View.OnClickListener)new e(this));
    }
    localObject1 = findViewById(2131298935);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMEditText");
      AppMethodBeat.o(257488);
      throw ((Throwable)localObject1);
    }
    this.ziR = ((MMEditText)localObject1);
    localObject1 = this.ziR;
    if (localObject1 != null) {
      ((MMEditText)localObject1).setEnableSendBtn(true);
    }
    if (ao.gJI())
    {
      localObject1 = this.ziR;
      if (localObject1 != null) {
        ((MMEditText)localObject1).setImeOptions(268435456);
      }
    }
    localObject1 = this.ziR;
    if (localObject1 != null) {
      ((MMEditText)localObject1).setImeOptions(4);
    }
    Object localObject2 = this.ziR;
    if (localObject2 != null)
    {
      localObject1 = this.ziR;
      if (localObject1 == null) {
        break label492;
      }
    }
    label492:
    for (localObject1 = Integer.valueOf(((MMEditText)localObject1).getInputType() & 0xFFFFFFBF);; localObject1 = null)
    {
      if (localObject1 == null) {
        p.hyc();
      }
      ((MMEditText)localObject2).setInputType(((Integer)localObject1).intValue());
      c.f((EditText)this.ziR).aoq(80).a(null);
      localObject1 = this.ziR;
      if (localObject1 != null)
      {
        localObject1 = ((MMEditText)localObject1).getInputExtras(true);
        if (localObject1 != null) {
          ((Bundle)localObject1).putBoolean("IS_CHAT_EDITOR", true);
        }
      }
      if (Build.VERSION.SDK_INT == 28)
      {
        localObject1 = this.ziR;
        if (localObject1 != null) {
          ((MMEditText)localObject1).setBreakStrategy(1);
        }
      }
      localObject1 = this.ziR;
      if (localObject1 != null) {
        ((MMEditText)localObject1).setOnEditorActionListener((TextView.OnEditorActionListener)new d(this));
      }
      localObject1 = (LinearLayout)findViewById(2131307165);
      localObject2 = e.grv().eZ(getContext());
      p.g(localObject2, "FooterFactory.getSmileyP…).getSmileyPanel(context)");
      this.rum = ((ChatFooterPanel)localObject2);
      localObject2 = this.rum;
      if (localObject2 == null) {
        p.btv("smileyPanel");
      }
      ((ChatFooterPanel)localObject2).setEntranceScene(ChatFooterPanel.KbP);
      localObject2 = this.rum;
      if (localObject2 == null) {
        p.btv("smileyPanel");
      }
      ((ChatFooterPanel)localObject2).setBackgroundResource(2131231612);
      localObject2 = this.rum;
      if (localObject2 == null) {
        p.btv("smileyPanel");
      }
      ((ChatFooterPanel)localObject2).goD();
      localObject2 = this.rum;
      if (localObject2 == null) {
        p.btv("smileyPanel");
      }
      ((ChatFooterPanel)localObject2).setShowSend(true);
      localObject2 = this.rum;
      if (localObject2 == null) {
        p.btv("smileyPanel");
      }
      ((ChatFooterPanel)localObject2).setVisibility(4);
      this.AxE = KeyBoardUtil.getKeyBordHeightPx(getContext());
      localObject2 = this.rum;
      if (localObject2 == null) {
        p.btv("smileyPanel");
      }
      ((LinearLayout)localObject1).addView((View)localObject2, -1, this.AxE);
      localObject1 = this.rum;
      if (localObject1 == null) {
        p.btv("smileyPanel");
      }
      ((ChatFooterPanel)localObject1).setOnTextOperationListener((ChatFooterPanel.a)new f(this));
      AppMethodBeat.o(257488);
      return;
    }
  }
  
  public final int getTrueHeight()
  {
    AppMethodBeat.i(257485);
    int i = this.AxE;
    int j = com.tencent.mm.cb.a.fromDPToPix(getContext(), 48);
    AppMethodBeat.o(257485);
    return i + j;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(257490);
    super.onWindowFocusChanged(paramBoolean);
    Log.i("Music.MusicMvCommentFooter", "onWindowFocusChanged: ".concat(String.valueOf(paramBoolean)));
    this.AxF = paramBoolean;
    if ((getVisibility() == 0) && (paramBoolean) && (this.wBU == 201)) {
      post((Runnable)new g(this));
    }
    AppMethodBeat.o(257490);
  }
  
  public final void setEditViewBackground(int paramInt)
  {
    AppMethodBeat.i(257486);
    MMEditText localMMEditText = this.ziR;
    if (localMMEditText != null)
    {
      localMMEditText.setBackground(getContext().getDrawable(paramInt));
      AppMethodBeat.o(257486);
      return;
    }
    AppMethodBeat.o(257486);
  }
  
  public final void setOnCommentSendImp(b paramb)
  {
    AppMethodBeat.i(257483);
    p.h(paramb, "imp");
    this.AxG = paramb;
    AppMethodBeat.o(257483);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(257484);
    super.setVisibility(paramInt);
    this.wBU = 200;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Music.MusicMvCommentFooter", "setVisibility, cutEditMode:" + this.wBU + ", isShow:" + bool);
      Log.i("Music.MusicMvCommentFooter", "showState ".concat(String.valueOf(bool)));
      if (bool) {
        break label170;
      }
      Log.i("Music.MusicMvCommentFooter", "allGone");
      this.AxD = 200;
      localObject = getContext();
      if (localObject != null) {
        break;
      }
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(257484);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).hideVKB();
    Object localObject = this.rum;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setAlpha(0.0F);
    localObject = this.rum;
    if (localObject == null) {
      p.btv("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setVisibility(4);
    label170:
    if (bool)
    {
      this.AxH = false;
      this.AxF = true;
      localObject = com.tencent.mm.ui.component.a.PRN;
      localObject = getContext();
      p.g(localObject, "context");
      localObject = (KeyboardProviderUIC)com.tencent.mm.ui.component.a.ko((Context)localObject).get(KeyboardProviderUIC.class);
      localg = (g)this;
      ((KeyboardProviderUIC)localObject).AsQ.add(localg);
      localObject = ((KeyboardProviderUIC)localObject).gyh;
      if (localObject != null) {
        ((com.tencent.mm.ui.tools.h)localObject).start();
      }
      localObject = this.ziR;
      if (localObject != null) {
        ((MMEditText)localObject).requestFocus();
      }
      ewq();
      AppMethodBeat.o(257484);
      return;
    }
    localObject = com.tencent.mm.ui.component.a.PRN;
    localObject = getContext();
    p.g(localObject, "context");
    localObject = (KeyboardProviderUIC)com.tencent.mm.ui.component.a.ko((Context)localObject).get(KeyboardProviderUIC.class);
    g localg = (g)this;
    Collection localCollection = (Collection)((KeyboardProviderUIC)localObject).AsQ;
    if (localCollection == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
      AppMethodBeat.o(257484);
      throw ((Throwable)localObject);
    }
    af.eV(localCollection).remove(localg);
    if (((KeyboardProviderUIC)localObject).AsQ.isEmpty())
    {
      localObject = ((KeyboardProviderUIC)localObject).gyh;
      if (localObject != null)
      {
        ((com.tencent.mm.ui.tools.h)localObject).close();
        AppMethodBeat.o(257484);
        return;
      }
    }
    AppMethodBeat.o(257484);
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(257491);
    Log.i("Music.MusicMvCommentFooter", "onKeyboardHeightChanged: ".concat(String.valueOf(paramInt)));
    if (!this.AxF)
    {
      AppMethodBeat.o(257491);
      return;
    }
    if (paramInt > 0) {}
    for (paramBoolean = true; this.AxH == paramBoolean; paramBoolean = false)
    {
      Log.d("Music.MusicMvCommentFooter", "onKeyboardHeightChanged repeat");
      AppMethodBeat.o(257491);
      return;
    }
    if (this.ygg == 0) {
      this.ygg = paramInt;
    }
    Object localObject1;
    Object localObject2;
    if ((this.AxE != paramInt) && (paramInt != 0))
    {
      this.AxE = paramInt;
      Log.i("Music.MusicMvCommentFooter", "refreshBottomPanelHeight, " + this.AxE);
      if (this.AxE > 0)
      {
        KeyBoardUtil.saveKeyBordHeightPx(getContext(), this.AxE);
        localObject1 = new LinearLayout.LayoutParams(-1, this.AxE);
        localObject2 = this.rum;
        if (localObject2 == null) {
          p.btv("smileyPanel");
        }
        ((ChatFooterPanel)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    if (paramBoolean)
    {
      this.wBU = 201;
      cbM();
      this.AxD = 200;
      this.AxH = paramBoolean;
      AppMethodBeat.o(257491);
      return;
    }
    if (this.AxD == 200)
    {
      localObject1 = this.AxG;
      if (localObject1 != null) {
        ((b)localObject1).aIq(null);
      }
      this.wBU = 200;
      cbM();
    }
    for (;;)
    {
      this.AxD = 200;
      break;
      if (this.AxD == 202)
      {
        this.wBU = 202;
        Log.i("Music.MusicMvCommentFooter", "showSmileyPanel");
        localObject1 = this.AxC;
        if (localObject1 != null) {
          ((WeImageView)localObject1).setImageResource(2131690821);
        }
        localObject1 = this.AxC;
        if (localObject1 != null)
        {
          localObject2 = getContext();
          p.g(localObject2, "context");
          ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(2131099844));
        }
        localObject1 = this.rum;
        if (localObject1 == null) {
          p.btv("smileyPanel");
        }
        ((ChatFooterPanel)localObject1).setVisibility(0);
        localObject1 = this.rum;
        if (localObject1 == null) {
          p.btv("smileyPanel");
        }
        ((ChatFooterPanel)localObject1).onResume();
        localObject1 = this.rum;
        if (localObject1 == null) {
          p.btv("smileyPanel");
        }
        ((ChatFooterPanel)localObject1).animate().cancel();
        localObject1 = this.rum;
        if (localObject1 == null) {
          p.btv("smileyPanel");
        }
        ((ChatFooterPanel)localObject1).animate().alpha(1.0F).setDuration(175L).start();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$Companion;", "", "()V", "DELAY_MILLISECOND", "", "EDIT_MODE_KEYBOARD", "", "EDIT_MODE_NONE", "EDIT_MODE_SMILE_PANEL", "NORMAL_ANIMATOR_DURATION", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "", "onCommentSend", "", "toSendText", "", "emojiMd5", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void aIq(String paramString);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MusicMvCommentFooter paramMusicMvCommentFooter) {}
    
    public final void run()
    {
      AppMethodBeat.i(257473);
      MusicMvCommentFooter.g(this.AxJ).setVisibility(4);
      AppMethodBeat.o(257473);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class d
    implements TextView.OnEditorActionListener
  {
    d(MusicMvCommentFooter paramMusicMvCommentFooter) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(257474);
      if (paramInt == 4)
      {
        MusicMvCommentFooter.d(this.AxJ);
        AppMethodBeat.o(257474);
        return true;
      }
      AppMethodBeat.o(257474);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(MusicMvCommentFooter paramMusicMvCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257475);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$initEmojiBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.i("Music.MusicMvCommentFooter", "commentModeIv clicked, curEditMode:" + MusicMvCommentFooter.a(this.AxJ));
      paramView = this.AxJ;
      if (MusicMvCommentFooter.a(this.AxJ) == 202) {
        MusicMvCommentFooter.b(this.AxJ);
      }
      for (int i = 201;; i = 202)
      {
        MusicMvCommentFooter.a(paramView, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$initEmojiBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257475);
        return;
        MusicMvCommentFooter.c(this.AxJ);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$initSmilePanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-mv_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void aHC()
    {
      AppMethodBeat.i(257477);
      Object localObject = MusicMvCommentFooter.f(this.AxJ);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(257477);
          return;
        }
      }
      AppMethodBeat.o(257477);
    }
    
    public final void aHD()
    {
      AppMethodBeat.i(257478);
      Object localObject = MusicMvCommentFooter.f(this.AxJ);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getText();
        localObject = (CharSequence)localObject;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label57;
        }
      }
      label57:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label62;
        }
        AppMethodBeat.o(257478);
        return;
        localObject = null;
        break;
      }
      label62:
      MusicMvCommentFooter.d(this.AxJ);
      AppMethodBeat.o(257478);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(257476);
      if (!Util.isNullOrNil(paramString))
      {
        MMEditText localMMEditText = MusicMvCommentFooter.f(this.AxJ);
        if (localMMEditText != null)
        {
          localMMEditText.append(com.tencent.mm.ui.g.c.b.c(this.AxJ.getContext(), (CharSequence)paramString, localMMEditText.getTextSize()));
          AppMethodBeat.o(257476);
          return;
        }
      }
      AppMethodBeat.o(257476);
    }
    
    public final void eP(boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(MusicMvCommentFooter paramMusicMvCommentFooter) {}
    
    public final void run()
    {
      AppMethodBeat.i(257479);
      Object localObject = MusicMvCommentFooter.f(this.AxJ);
      if (localObject != null) {
        ((MMEditText)localObject).requestFocus();
      }
      localObject = this.AxJ.getContext();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(257479);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).showVKB();
      AppMethodBeat.o(257479);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$send$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-mv_release"})
  public static final class h
    implements c.a
  {
    public final void Tw(String paramString)
    {
      AppMethodBeat.i(257480);
      p.h(paramString, "text");
      Log.i("Music.MusicMvCommentFooter", "InputTextBoundaryCheck ok, ready to send, text:".concat(String.valueOf(paramString)));
      if (!Util.isNullOrNil(paramString))
      {
        MusicMvCommentFooter.b localb = MusicMvCommentFooter.e(this.AxJ);
        if (localb != null) {
          localb.aIq(paramString);
        }
      }
      paramString = MusicMvCommentFooter.f(this.AxJ);
      if (paramString == null) {
        p.hyc();
      }
      paramString.setText((CharSequence)"");
      AppMethodBeat.o(257480);
    }
    
    public final void Tx(String paramString)
    {
      AppMethodBeat.i(257481);
      p.h(paramString, "text");
      AppMethodBeat.o(257481);
    }
    
    public final void dv(String paramString)
    {
      AppMethodBeat.i(257482);
      p.h(paramString, "text");
      com.tencent.mm.ui.base.h.n(this.AxJ.getContext(), 2131766298, 2131766299);
      AppMethodBeat.o(257482);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter
 * JD-Core Version:    0.7.0.1
 */