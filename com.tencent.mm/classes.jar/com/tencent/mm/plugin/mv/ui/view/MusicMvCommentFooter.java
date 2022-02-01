package com.tencent.mm.plugin.mv.ui.view;

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
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.d;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentModeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "curEditMode", "hasWindowFocus", "", "lastKeyboardShow", "moveHeight", "nextEditMode", "onCommentSend", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "smilePanelHeight", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "toSendET", "Lcom/tencent/mm/ui/widget/MMEditText;", "allGone", "", "getTrueHeight", "hideSmileyPanel", "init", "initEditText", "initEmojiBtn", "initSmilePanel", "onKeyboardHeightChanged", "height", "isResized", "onWindowFocusChanged", "onlyShowSmilePanel", "onlyShowVKB", "refreshBottomPanelHeight", "send", "setEditViewBackground", "id", "setOnCommentSendImp", "imp", "setVisibility", "visibility", "showSmileyPanel", "showState", "isShow", "Companion", "IOnCommentSend", "plugin-mv_release"})
public final class MusicMvCommentFooter
  extends LinearLayout
  implements com.tencent.mm.ui.tools.h
{
  public static final a Gor;
  private int BsC;
  private int Dqi;
  private MMEditText EOh;
  private WeImageView Gol;
  private int Gom;
  private int Gon;
  private boolean Goo;
  private b Gop;
  private boolean Goq;
  private ChatFooterPanel jPN;
  
  static
  {
    AppMethodBeat.i(237470);
    Gor = new a((byte)0);
    AppMethodBeat.o(237470);
  }
  
  public MusicMvCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237467);
    this.BsC = 200;
    this.Gom = 200;
    this.Gon = -1;
    init();
    AppMethodBeat.o(237467);
  }
  
  public MusicMvCommentFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237469);
    this.BsC = 200;
    this.Gom = 200;
    this.Gon = -1;
    init();
    AppMethodBeat.o(237469);
  }
  
  private final void aDL()
  {
    AppMethodBeat.i(237461);
    Log.i("Music.MusicMvCommentFooter", "hideSmileyPanel");
    Object localObject = this.Gol;
    if (localObject != null) {
      ((WeImageView)localObject).setImageResource(b.g.icons_outlined_emoji);
    }
    localObject = this.Gol;
    if (localObject != null)
    {
      Context localContext = getContext();
      p.j(localContext, "context");
      ((WeImageView)localObject).setIconColor(localContext.getResources().getColor(b.b.White));
    }
    localObject = this.jPN;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((ChatFooterPanel)localObject).animate().cancel();
    localObject = this.jPN;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    if (((ChatFooterPanel)localObject).getVisibility() == 0)
    {
      localObject = this.jPN;
      if (localObject == null) {
        p.bGy("smileyPanel");
      }
      ((ChatFooterPanel)localObject).onPause();
      localObject = this.jPN;
      if (localObject == null) {
        p.bGy("smileyPanel");
      }
      ((ChatFooterPanel)localObject).animate().alpha(0.0F).setDuration(175L).withEndAction((Runnable)new c(this)).start();
    }
    AppMethodBeat.o(237461);
  }
  
  private final void fhJ()
  {
    AppMethodBeat.i(237454);
    Log.i("Music.MusicMvCommentFooter", "onlyShowVKB");
    this.Gom = 201;
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(237454);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).showVKB();
    AppMethodBeat.o(237454);
  }
  
  private final void init()
  {
    AppMethodBeat.i(237459);
    View.inflate(getContext(), b.f.FZs, (ViewGroup)this);
    this.Gol = ((WeImageView)findViewById(b.e.FWR));
    Object localObject1 = this.Gol;
    if (localObject1 != null) {
      ((WeImageView)localObject1).setOnClickListener((View.OnClickListener)new e(this));
    }
    localObject1 = findViewById(b.e.FWP);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMEditText");
      AppMethodBeat.o(237459);
      throw ((Throwable)localObject1);
    }
    this.EOh = ((MMEditText)localObject1);
    localObject1 = this.EOh;
    if (localObject1 != null) {
      ((MMEditText)localObject1).setEnableSendBtn(true);
    }
    if (ar.hIF())
    {
      localObject1 = this.EOh;
      if (localObject1 != null) {
        ((MMEditText)localObject1).setImeOptions(268435456);
      }
    }
    localObject1 = this.EOh;
    if (localObject1 != null) {
      ((MMEditText)localObject1).setImeOptions(4);
    }
    Object localObject2 = this.EOh;
    if (localObject2 != null)
    {
      localObject1 = this.EOh;
      if (localObject1 == null) {
        break label492;
      }
    }
    label492:
    for (localObject1 = Integer.valueOf(((MMEditText)localObject1).getInputType() & 0xFFFFFFBF);; localObject1 = null)
    {
      if (localObject1 == null) {
        p.iCn();
      }
      ((MMEditText)localObject2).setInputType(((Integer)localObject1).intValue());
      c.i((EditText)this.EOh).axx(80).a(null);
      localObject1 = this.EOh;
      if (localObject1 != null)
      {
        localObject1 = ((MMEditText)localObject1).getInputExtras(true);
        if (localObject1 != null) {
          ((Bundle)localObject1).putBoolean("IS_CHAT_EDITOR", true);
        }
      }
      if (Build.VERSION.SDK_INT == 28)
      {
        localObject1 = this.EOh;
        if (localObject1 != null) {
          ((MMEditText)localObject1).setBreakStrategy(1);
        }
      }
      localObject1 = this.EOh;
      if (localObject1 != null) {
        ((MMEditText)localObject1).setOnEditorActionListener((TextView.OnEditorActionListener)new d(this));
      }
      localObject1 = (LinearLayout)findViewById(b.e.root_layout);
      localObject2 = e.hmu().fd(getContext());
      p.j(localObject2, "FooterFactory.getSmileyP…).getSmileyPanel(context)");
      this.jPN = ((ChatFooterPanel)localObject2);
      localObject2 = this.jPN;
      if (localObject2 == null) {
        p.bGy("smileyPanel");
      }
      ((ChatFooterPanel)localObject2).setEntranceScene(ChatFooterPanel.Rcu);
      localObject2 = this.jPN;
      if (localObject2 == null) {
        p.bGy("smileyPanel");
      }
      ((ChatFooterPanel)localObject2).setBackgroundResource(b.d.chat_footer_bg);
      localObject2 = this.jPN;
      if (localObject2 == null) {
        p.bGy("smileyPanel");
      }
      ((ChatFooterPanel)localObject2).hjp();
      localObject2 = this.jPN;
      if (localObject2 == null) {
        p.bGy("smileyPanel");
      }
      ((ChatFooterPanel)localObject2).setShowSend(true);
      localObject2 = this.jPN;
      if (localObject2 == null) {
        p.bGy("smileyPanel");
      }
      ((ChatFooterPanel)localObject2).setVisibility(4);
      this.Gon = KeyBoardUtil.getKeyBordHeightPx(getContext());
      localObject2 = this.jPN;
      if (localObject2 == null) {
        p.bGy("smileyPanel");
      }
      ((LinearLayout)localObject1).addView((View)localObject2, -1, this.Gon);
      localObject1 = this.jPN;
      if (localObject1 == null) {
        p.bGy("smileyPanel");
      }
      ((ChatFooterPanel)localObject1).setOnTextOperationListener((ChatFooterPanel.a)new f(this));
      AppMethodBeat.o(237459);
      return;
    }
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(237466);
    Log.i("Music.MusicMvCommentFooter", "onKeyboardHeightChanged: ".concat(String.valueOf(paramInt)));
    if (!this.Goo)
    {
      AppMethodBeat.o(237466);
      return;
    }
    if (paramInt > 0) {}
    for (paramBoolean = true; this.Goq == paramBoolean; paramBoolean = false)
    {
      Log.d("Music.MusicMvCommentFooter", "onKeyboardHeightChanged repeat");
      AppMethodBeat.o(237466);
      return;
    }
    if (this.Dqi == 0) {
      this.Dqi = paramInt;
    }
    Object localObject1;
    Object localObject2;
    if ((this.Gon != paramInt) && (paramInt != 0))
    {
      this.Gon = paramInt;
      Log.i("Music.MusicMvCommentFooter", "refreshBottomPanelHeight, " + this.Gon);
      if (this.Gon > 0)
      {
        KeyBoardUtil.saveKeyBordHeightPx(getContext(), this.Gon);
        localObject1 = new LinearLayout.LayoutParams(-1, this.Gon);
        localObject2 = this.jPN;
        if (localObject2 == null) {
          p.bGy("smileyPanel");
        }
        ((ChatFooterPanel)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    if (paramBoolean)
    {
      this.BsC = 201;
      aDL();
      this.Gom = 200;
      this.Goq = paramBoolean;
      AppMethodBeat.o(237466);
      return;
    }
    if (this.Gom == 200)
    {
      localObject1 = this.Gop;
      if (localObject1 != null) {
        ((b)localObject1).aSL(null);
      }
      this.BsC = 200;
      aDL();
    }
    for (;;)
    {
      this.Gom = 200;
      break;
      if (this.Gom == 202)
      {
        this.BsC = 202;
        Log.i("Music.MusicMvCommentFooter", "showSmileyPanel");
        localObject1 = this.Gol;
        if (localObject1 != null) {
          ((WeImageView)localObject1).setImageResource(b.g.icons_outlined_keyboard);
        }
        localObject1 = this.Gol;
        if (localObject1 != null)
        {
          localObject2 = getContext();
          p.j(localObject2, "context");
          ((WeImageView)localObject1).setIconColor(((Context)localObject2).getResources().getColor(b.b.White));
        }
        localObject1 = this.jPN;
        if (localObject1 == null) {
          p.bGy("smileyPanel");
        }
        ((ChatFooterPanel)localObject1).setVisibility(0);
        localObject1 = this.jPN;
        if (localObject1 == null) {
          p.bGy("smileyPanel");
        }
        ((ChatFooterPanel)localObject1).onResume();
        localObject1 = this.jPN;
        if (localObject1 == null) {
          p.bGy("smileyPanel");
        }
        ((ChatFooterPanel)localObject1).animate().cancel();
        localObject1 = this.jPN;
        if (localObject1 == null) {
          p.bGy("smileyPanel");
        }
        ((ChatFooterPanel)localObject1).animate().alpha(1.0F).setDuration(175L).start();
      }
    }
  }
  
  public final int getTrueHeight()
  {
    AppMethodBeat.i(237451);
    int i = this.Gon;
    int j = com.tencent.mm.ci.a.fromDPToPix(getContext(), 48);
    AppMethodBeat.o(237451);
    return i + j;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(237463);
    super.onWindowFocusChanged(paramBoolean);
    Log.i("Music.MusicMvCommentFooter", "onWindowFocusChanged: ".concat(String.valueOf(paramBoolean)));
    this.Goo = paramBoolean;
    if ((getVisibility() == 0) && (paramBoolean) && (this.BsC == 201)) {
      post((Runnable)new g(this));
    }
    AppMethodBeat.o(237463);
  }
  
  public final void setEditViewBackground(int paramInt)
  {
    AppMethodBeat.i(237452);
    MMEditText localMMEditText = this.EOh;
    if (localMMEditText != null)
    {
      localMMEditText.setBackground(getContext().getDrawable(paramInt));
      AppMethodBeat.o(237452);
      return;
    }
    AppMethodBeat.o(237452);
  }
  
  public final void setOnCommentSendImp(b paramb)
  {
    AppMethodBeat.i(237444);
    p.k(paramb, "imp");
    this.Gop = paramb;
    AppMethodBeat.o(237444);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(237449);
    super.setVisibility(paramInt);
    this.BsC = 200;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Music.MusicMvCommentFooter", "setVisibility, cutEditMode:" + this.BsC + ", isShow:" + bool);
      Log.i("Music.MusicMvCommentFooter", "showState ".concat(String.valueOf(bool)));
      if (bool) {
        break label170;
      }
      Log.i("Music.MusicMvCommentFooter", "allGone");
      this.Gom = 200;
      localObject = getContext();
      if (localObject != null) {
        break;
      }
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(237449);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).hideVKB();
    Object localObject = this.jPN;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setAlpha(0.0F);
    localObject = this.jPN;
    if (localObject == null) {
      p.bGy("smileyPanel");
    }
    ((ChatFooterPanel)localObject).setVisibility(4);
    label170:
    if (bool)
    {
      this.Goq = false;
      this.Goo = true;
      localObject = g.Xox;
      localObject = getContext();
      p.j(localObject, "context");
      localObject = (com.tencent.mm.plugin.mv.ui.uic.a)g.lm((Context)localObject).i(com.tencent.mm.plugin.mv.ui.uic.a.class);
      localh = (com.tencent.mm.ui.tools.h)this;
      ((com.tencent.mm.plugin.mv.ui.uic.a)localObject).Gik.add(localh);
      localObject = ((com.tencent.mm.plugin.mv.ui.uic.a)localObject).jij;
      if (localObject != null) {
        ((i)localObject).start();
      }
      localObject = this.EOh;
      if (localObject != null) {
        ((MMEditText)localObject).requestFocus();
      }
      fhJ();
      AppMethodBeat.o(237449);
      return;
    }
    localObject = g.Xox;
    localObject = getContext();
    p.j(localObject, "context");
    localObject = (com.tencent.mm.plugin.mv.ui.uic.a)g.lm((Context)localObject).i(com.tencent.mm.plugin.mv.ui.uic.a.class);
    com.tencent.mm.ui.tools.h localh = (com.tencent.mm.ui.tools.h)this;
    Collection localCollection = (Collection)((com.tencent.mm.plugin.mv.ui.uic.a)localObject).Gik;
    if (localCollection == null)
    {
      localObject = new t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
      AppMethodBeat.o(237449);
      throw ((Throwable)localObject);
    }
    ag.fc(localCollection).remove(localh);
    if (((com.tencent.mm.plugin.mv.ui.uic.a)localObject).Gik.isEmpty())
    {
      localObject = ((com.tencent.mm.plugin.mv.ui.uic.a)localObject).jij;
      if (localObject != null)
      {
        ((i)localObject).close();
        AppMethodBeat.o(237449);
        return;
      }
    }
    AppMethodBeat.o(237449);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$Companion;", "", "()V", "DELAY_MILLISECOND", "", "EDIT_MODE_KEYBOARD", "", "EDIT_MODE_NONE", "EDIT_MODE_SMILE_PANEL", "NORMAL_ANIMATOR_DURATION", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "", "onCommentSend", "", "toSendText", "", "emojiMd5", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void aSL(String paramString);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(MusicMvCommentFooter paramMusicMvCommentFooter) {}
    
    public final void run()
    {
      AppMethodBeat.i(225636);
      MusicMvCommentFooter.g(this.Gos).setVisibility(4);
      AppMethodBeat.o(225636);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"})
  static final class d
    implements TextView.OnEditorActionListener
  {
    d(MusicMvCommentFooter paramMusicMvCommentFooter) {}
    
    public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(231005);
      if (paramInt == 4)
      {
        MusicMvCommentFooter.d(this.Gos);
        AppMethodBeat.o(231005);
        return true;
      }
      AppMethodBeat.o(231005);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(MusicMvCommentFooter paramMusicMvCommentFooter) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(243243);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$initEmojiBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      Log.i("Music.MusicMvCommentFooter", "commentModeIv clicked, curEditMode:" + MusicMvCommentFooter.a(this.Gos));
      paramView = this.Gos;
      if (MusicMvCommentFooter.a(this.Gos) == 202) {
        MusicMvCommentFooter.b(this.Gos);
      }
      for (int i = 201;; i = 202)
      {
        MusicMvCommentFooter.a(paramView, i);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$initEmojiBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(243243);
        return;
        MusicMvCommentFooter.c(this.Gos);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$initSmilePanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-mv_release"})
  public static final class f
    implements ChatFooterPanel.a
  {
    public final void aDN()
    {
      AppMethodBeat.i(238956);
      Object localObject = MusicMvCommentFooter.f(this.Gos);
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
        AppMethodBeat.o(238956);
        return;
        localObject = null;
        break;
      }
      label62:
      MusicMvCommentFooter.d(this.Gos);
      AppMethodBeat.o(238956);
    }
    
    public final void aDO()
    {
      AppMethodBeat.i(238953);
      Object localObject = MusicMvCommentFooter.f(this.Gos);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(238953);
          return;
        }
      }
      AppMethodBeat.o(238953);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(238950);
      if (!Util.isNullOrNil(paramString))
      {
        MMEditText localMMEditText = MusicMvCommentFooter.f(this.Gos);
        if (localMMEditText != null)
        {
          localMMEditText.append(com.tencent.mm.ui.h.c.b.c(this.Gos.getContext(), (CharSequence)paramString, localMMEditText.getTextSize()));
          AppMethodBeat.o(238950);
          return;
        }
      }
      AppMethodBeat.o(238950);
    }
    
    public final void eE(boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(MusicMvCommentFooter paramMusicMvCommentFooter) {}
    
    public final void run()
    {
      AppMethodBeat.i(228701);
      Object localObject = MusicMvCommentFooter.f(this.Gos);
      if (localObject != null) {
        ((MMEditText)localObject).requestFocus();
      }
      localObject = this.Gos.getContext();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(228701);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).showVKB();
      AppMethodBeat.o(228701);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$send$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-mv_release"})
  public static final class h
    implements c.a
  {
    public final void abc(String paramString)
    {
      AppMethodBeat.i(225859);
      p.k(paramString, "text");
      Log.i("Music.MusicMvCommentFooter", "InputTextBoundaryCheck ok, ready to send, text:".concat(String.valueOf(paramString)));
      if (!Util.isNullOrNil(paramString))
      {
        MusicMvCommentFooter.b localb = MusicMvCommentFooter.e(this.Gos);
        if (localb != null) {
          localb.aSL(paramString);
        }
      }
      paramString = MusicMvCommentFooter.f(this.Gos);
      if (paramString == null) {
        p.iCn();
      }
      paramString.setText((CharSequence)"");
      AppMethodBeat.o(225859);
    }
    
    public final void abd(String paramString)
    {
      AppMethodBeat.i(225862);
      p.k(paramString, "text");
      AppMethodBeat.o(225862);
    }
    
    public final void dN(String paramString)
    {
      AppMethodBeat.i(225864);
      p.k(paramString, "text");
      com.tencent.mm.ui.base.h.p(this.Gos.getContext(), b.h.sns_upload_post_text_invalid_more, b.h.sns_upload_post_text_invalid_title);
      AppMethodBeat.o(225864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter
 * JD-Core Version:    0.7.0.1
 */