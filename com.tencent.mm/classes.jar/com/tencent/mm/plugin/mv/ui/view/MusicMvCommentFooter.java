package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
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
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commentModeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "curEditMode", "hasWindowFocus", "", "lastKeyboardShow", "moveHeight", "nextEditMode", "onCommentSend", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "smilePanelHeight", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "toSendET", "Lcom/tencent/mm/ui/widget/MMEditText;", "allGone", "", "getTrueHeight", "hideSmileyPanel", "init", "initEditText", "initEmojiBtn", "initSmilePanel", "onKeyboardHeightChanged", "height", "isResized", "onWindowFocusChanged", "onlyShowSmilePanel", "onlyShowVKB", "refreshBottomPanelHeight", "send", "setEditViewBackground", "id", "setOnCommentSendImp", "imp", "setVisibility", "visibility", "showSmileyPanel", "showState", "isShow", "Companion", "IOnCommentSend", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvCommentFooter
  extends LinearLayout
  implements h
{
  public static final MusicMvCommentFooter.a Mie;
  private int GZw;
  private int JjQ;
  private MMEditText KIG;
  private WeImageView Mif;
  private int Mig;
  private int Mih;
  private boolean Mii;
  private MusicMvCommentFooter.b Mij;
  private boolean Mik;
  private ChatFooterPanel moD;
  
  static
  {
    AppMethodBeat.i(287178);
    Mie = new MusicMvCommentFooter.a((byte)0);
    AppMethodBeat.o(287178);
  }
  
  public MusicMvCommentFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(287053);
    this.GZw = 200;
    this.Mig = 200;
    this.Mih = -1;
    init();
    AppMethodBeat.o(287053);
  }
  
  public MusicMvCommentFooter(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(287058);
    this.GZw = 200;
    this.Mig = 200;
    this.Mih = -1;
    init();
    AppMethodBeat.o(287058);
  }
  
  private static final void a(MusicMvCommentFooter paramMusicMvCommentFooter)
  {
    AppMethodBeat.i(287156);
    s.u(paramMusicMvCommentFooter, "this$0");
    ChatFooterPanel localChatFooterPanel = paramMusicMvCommentFooter.moD;
    paramMusicMvCommentFooter = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      paramMusicMvCommentFooter = null;
    }
    paramMusicMvCommentFooter.setVisibility(4);
    AppMethodBeat.o(287156);
  }
  
  private static final void a(MusicMvCommentFooter paramMusicMvCommentFooter, View paramView)
  {
    AppMethodBeat.i(287149);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramMusicMvCommentFooter);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMusicMvCommentFooter, "this$0");
    Log.i("Music.MusicMvCommentFooter", s.X("commentModeIv clicked, curEditMode:", Integer.valueOf(paramMusicMvCommentFooter.GZw)));
    if (paramMusicMvCommentFooter.GZw == 202) {
      paramMusicMvCommentFooter.grx();
    }
    for (int i = 201;; i = 202)
    {
      paramMusicMvCommentFooter.GZw = i;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287149);
      return;
      Log.i("Music.MusicMvCommentFooter", "onlyShowSmilePanel");
      paramMusicMvCommentFooter.Mig = 202;
      paramView = paramMusicMvCommentFooter.getContext();
      if (paramView == null)
      {
        paramMusicMvCommentFooter = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(287149);
        throw paramMusicMvCommentFooter;
      }
      ((MMActivity)paramView).hideVKB();
    }
  }
  
  private static final boolean a(MusicMvCommentFooter paramMusicMvCommentFooter, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(287151);
    s.u(paramMusicMvCommentFooter, "this$0");
    if (paramInt == 4)
    {
      paramMusicMvCommentFooter.send();
      AppMethodBeat.o(287151);
      return true;
    }
    AppMethodBeat.o(287151);
    return false;
  }
  
  private final void aWJ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(287145);
    Log.i("Music.MusicMvCommentFooter", "hideSmileyPanel");
    Object localObject1 = this.Mif;
    if (localObject1 != null) {
      ((WeImageView)localObject1).setImageResource(b.g.icons_outlined_emoji);
    }
    localObject1 = this.Mif;
    if (localObject1 != null) {
      ((WeImageView)localObject1).setIconColor(getContext().getResources().getColor(b.b.White));
    }
    ChatFooterPanel localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).animate().cancel();
    localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    if (((ChatFooterPanel)localObject1).getVisibility() == 0)
    {
      localChatFooterPanel = this.moD;
      localObject1 = localChatFooterPanel;
      if (localChatFooterPanel == null)
      {
        s.bIx("smileyPanel");
        localObject1 = null;
      }
      ((ChatFooterPanel)localObject1).onPause();
      localObject1 = this.moD;
      if (localObject1 != null) {
        break label178;
      }
      s.bIx("smileyPanel");
      localObject1 = localObject2;
    }
    label178:
    for (;;)
    {
      ((ChatFooterPanel)localObject1).animate().alpha(0.0F).setDuration(175L).withEndAction(new MusicMvCommentFooter..ExternalSyntheticLambda3(this)).start();
      AppMethodBeat.o(287145);
      return;
    }
  }
  
  private static final void b(MusicMvCommentFooter paramMusicMvCommentFooter)
  {
    AppMethodBeat.i(287159);
    s.u(paramMusicMvCommentFooter, "this$0");
    MMEditText localMMEditText = paramMusicMvCommentFooter.KIG;
    if (localMMEditText != null) {
      localMMEditText.requestFocus();
    }
    paramMusicMvCommentFooter = paramMusicMvCommentFooter.getContext();
    if (paramMusicMvCommentFooter == null)
    {
      paramMusicMvCommentFooter = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(287159);
      throw paramMusicMvCommentFooter;
    }
    ((MMActivity)paramMusicMvCommentFooter).showVKB();
    AppMethodBeat.o(287159);
  }
  
  private final void grA()
  {
    Object localObject2 = null;
    AppMethodBeat.i(287143);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(b.e.root_layout);
    Object localObject1 = e.Ykf.fZ(getContext());
    s.s(localObject1, "getSmileyPanel().getSmileyPanel(context)");
    this.moD = ((ChatFooterPanel)localObject1);
    ChatFooterPanel localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).setEntranceScene(ChatFooterPanel.XYz);
    localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).setBackgroundResource(b.d.chat_footer_bg);
    localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).iKh();
    localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).setShowSend(true);
    localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).setVisibility(4);
    this.Mih = KeyBoardUtil.getKeyBordHeightPx(getContext());
    localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    localLinearLayout.addView((View)localObject1, -1, this.Mih);
    localObject1 = this.moD;
    if (localObject1 == null)
    {
      s.bIx("smileyPanel");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ChatFooterPanel)localObject1).setOnTextOperationListener((ChatFooterPanel.a)new c(this));
      AppMethodBeat.o(287143);
      return;
    }
  }
  
  private final void grx()
  {
    AppMethodBeat.i(287066);
    Log.i("Music.MusicMvCommentFooter", "onlyShowVKB");
    this.Mig = 201;
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(287066);
      throw ((Throwable)localObject);
    }
    ((MMActivity)localObject).showVKB();
    AppMethodBeat.o(287066);
  }
  
  private final void gry()
  {
    AppMethodBeat.i(287074);
    this.Mif = ((WeImageView)findViewById(b.e.LSf));
    WeImageView localWeImageView = this.Mif;
    if (localWeImageView != null) {
      localWeImageView.setOnClickListener(new MusicMvCommentFooter..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(287074);
  }
  
  private final void grz()
  {
    AppMethodBeat.i(287086);
    Object localObject = findViewById(b.e.LSc);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMEditText");
      AppMethodBeat.o(287086);
      throw ((Throwable)localObject);
    }
    this.KIG = ((MMEditText)localObject);
    localObject = this.KIG;
    if (localObject != null) {
      ((MMEditText)localObject).setEnableSendBtn(true);
    }
    if (aw.jkQ())
    {
      localObject = this.KIG;
      if (localObject != null) {
        ((MMEditText)localObject).setImeOptions(268435456);
      }
    }
    localObject = this.KIG;
    if (localObject != null) {
      ((MMEditText)localObject).setImeOptions(4);
    }
    MMEditText localMMEditText = this.KIG;
    if (localMMEditText != null)
    {
      localObject = this.KIG;
      if (localObject != null) {
        break label223;
      }
    }
    label223:
    for (localObject = null;; localObject = Integer.valueOf(((MMEditText)localObject).getInputType() & 0xFFFFFFBF))
    {
      s.checkNotNull(localObject);
      localMMEditText.setInputType(((Integer)localObject).intValue());
      c.i((EditText)this.KIG).aEg(80).a(null);
      localObject = this.KIG;
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputExtras(true);
        if (localObject != null) {
          ((Bundle)localObject).putBoolean("IS_CHAT_EDITOR", true);
        }
      }
      if (Build.VERSION.SDK_INT == 28)
      {
        localObject = this.KIG;
        if (localObject != null) {
          ((MMEditText)localObject).setBreakStrategy(1);
        }
      }
      localObject = this.KIG;
      if (localObject != null) {
        ((MMEditText)localObject).setOnEditorActionListener(new MusicMvCommentFooter..ExternalSyntheticLambda1(this));
      }
      AppMethodBeat.o(287086);
      return;
    }
  }
  
  private final void init()
  {
    AppMethodBeat.i(287144);
    View.inflate(getContext(), b.f.LVp, (ViewGroup)this);
    gry();
    grz();
    grA();
    AppMethodBeat.o(287144);
  }
  
  private final void send()
  {
    AppMethodBeat.i(287141);
    c.i((EditText)this.KIG).aEg(80).Nc(true).a((c.a)new d(this));
    AppMethodBeat.o(287141);
  }
  
  public final int getTrueHeight()
  {
    AppMethodBeat.i(287219);
    int i = this.Mih;
    int j = com.tencent.mm.cd.a.fromDPToPix(getContext(), 48);
    AppMethodBeat.o(287219);
    return i + j;
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(287248);
    Log.i("Music.MusicMvCommentFooter", s.X("onKeyboardHeightChanged: ", Integer.valueOf(paramInt)));
    if (!this.Mii)
    {
      AppMethodBeat.o(287248);
      return;
    }
    if (paramInt > 0) {}
    for (paramBoolean = true; this.Mik == paramBoolean; paramBoolean = false)
    {
      Log.d("Music.MusicMvCommentFooter", "onKeyboardHeightChanged repeat");
      AppMethodBeat.o(287248);
      return;
    }
    if (this.JjQ == 0) {
      this.JjQ = paramInt;
    }
    if ((this.Mih != paramInt) && (paramInt != 0))
    {
      this.Mih = paramInt;
      Log.i("Music.MusicMvCommentFooter", s.X("refreshBottomPanelHeight, ", Integer.valueOf(this.Mih)));
      if (this.Mih > 0)
      {
        KeyBoardUtil.saveKeyBordHeightPx(getContext(), this.Mih);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.Mih);
        localChatFooterPanel = this.moD;
        localObject1 = localChatFooterPanel;
        if (localChatFooterPanel == null)
        {
          s.bIx("smileyPanel");
          localObject1 = null;
        }
        ((ChatFooterPanel)localObject1).setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      }
    }
    if (paramBoolean)
    {
      this.GZw = 201;
      aWJ();
      this.Mig = 200;
      this.Mik = paramBoolean;
      AppMethodBeat.o(287248);
      return;
    }
    if (this.Mig == 200)
    {
      localObject1 = this.Mij;
      if (localObject1 != null) {
        ((MusicMvCommentFooter.b)localObject1).aPG(null);
      }
      this.GZw = 200;
      aWJ();
    }
    while (this.Mig != 202)
    {
      this.Mig = 200;
      break;
    }
    this.GZw = 202;
    Log.i("Music.MusicMvCommentFooter", "showSmileyPanel");
    Object localObject1 = this.Mif;
    if (localObject1 != null) {
      ((WeImageView)localObject1).setImageResource(b.g.icons_outlined_keyboard);
    }
    localObject1 = this.Mif;
    if (localObject1 != null) {
      ((WeImageView)localObject1).setIconColor(getContext().getResources().getColor(b.b.White));
    }
    ChatFooterPanel localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).setVisibility(0);
    localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).onResume();
    localChatFooterPanel = this.moD;
    localObject1 = localChatFooterPanel;
    if (localChatFooterPanel == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).animate().cancel();
    localObject1 = this.moD;
    if (localObject1 == null)
    {
      s.bIx("smileyPanel");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((ChatFooterPanel)localObject1).animate().alpha(1.0F).setDuration(175L).start();
      break;
    }
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(287231);
    super.onWindowFocusChanged(paramBoolean);
    Log.i("Music.MusicMvCommentFooter", s.X("onWindowFocusChanged: ", Boolean.valueOf(paramBoolean)));
    this.Mii = paramBoolean;
    if ((getVisibility() == 0) && (paramBoolean) && (this.GZw == 201)) {
      post(new MusicMvCommentFooter..ExternalSyntheticLambda2(this));
    }
    AppMethodBeat.o(287231);
  }
  
  public final void setEditViewBackground(int paramInt)
  {
    AppMethodBeat.i(287224);
    MMEditText localMMEditText = this.KIG;
    if (localMMEditText != null) {
      localMMEditText.setBackground(getContext().getDrawable(paramInt));
    }
    AppMethodBeat.o(287224);
  }
  
  public final void setOnCommentSendImp(MusicMvCommentFooter.b paramb)
  {
    AppMethodBeat.i(287204);
    s.u(paramb, "imp");
    this.Mij = paramb;
    AppMethodBeat.o(287204);
  }
  
  public final void setVisibility(int paramInt)
  {
    h localh = null;
    AppMethodBeat.i(287215);
    super.setVisibility(paramInt);
    this.GZw = 200;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("Music.MusicMvCommentFooter", "setVisibility, cutEditMode:" + this.GZw + ", isShow:" + bool);
      Log.i("Music.MusicMvCommentFooter", s.X("showState ", Boolean.valueOf(bool)));
      if (bool) {
        break label183;
      }
      Log.i("Music.MusicMvCommentFooter", "allGone");
      this.Mig = 200;
      localObject1 = getContext();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(287215);
      throw ((Throwable)localObject1);
    }
    ((MMActivity)localObject1).hideVKB();
    Object localObject2 = this.moD;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("smileyPanel");
      localObject1 = null;
    }
    ((ChatFooterPanel)localObject1).setAlpha(0.0F);
    localObject1 = this.moD;
    if (localObject1 == null)
    {
      s.bIx("smileyPanel");
      localObject1 = localh;
    }
    for (;;)
    {
      ((ChatFooterPanel)localObject1).setVisibility(4);
      label183:
      if (!bool) {
        break;
      }
      this.Mik = false;
      this.Mii = true;
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = getContext();
      s.s(localObject1, "context");
      localObject1 = (com.tencent.mm.plugin.mv.ui.uic.a)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.mv.ui.uic.a.class);
      localh = (h)this;
      ((com.tencent.mm.plugin.mv.ui.uic.a)localObject1).Mdq.add(localh);
      localObject1 = ((com.tencent.mm.plugin.mv.ui.uic.a)localObject1).lKz;
      if (localObject1 != null) {
        ((i)localObject1).start();
      }
      localObject1 = this.KIG;
      if (localObject1 != null) {
        ((MMEditText)localObject1).requestFocus();
      }
      grx();
      AppMethodBeat.o(287215);
      return;
    }
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = getContext();
    s.s(localObject1, "context");
    localObject1 = (com.tencent.mm.plugin.mv.ui.uic.a)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.mv.ui.uic.a.class);
    localh = (h)this;
    localObject2 = (Collection)((com.tencent.mm.plugin.mv.ui.uic.a)localObject1).Mdq;
    if (localObject2 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
      AppMethodBeat.o(287215);
      throw ((Throwable)localObject1);
    }
    an.hA(localObject2).remove(localh);
    if (((com.tencent.mm.plugin.mv.ui.uic.a)localObject1).Mdq.isEmpty())
    {
      localObject1 = ((com.tencent.mm.plugin.mv.ui.uic.a)localObject1).lKz;
      if (localObject1 != null) {
        ((i)localObject1).close();
      }
    }
    AppMethodBeat.o(287215);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$initSmilePanel$1", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements ChatFooterPanel.a
  {
    c(MusicMvCommentFooter paramMusicMvCommentFooter) {}
    
    public final void aWL()
    {
      AppMethodBeat.i(286912);
      Object localObject = MusicMvCommentFooter.d(this.Mil);
      if (localObject == null)
      {
        localObject = null;
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
        AppMethodBeat.o(286912);
        return;
        localObject = ((MMEditText)localObject).getText();
        break;
      }
      label62:
      MusicMvCommentFooter.e(this.Mil);
      AppMethodBeat.o(286912);
    }
    
    public final void aWM()
    {
      AppMethodBeat.i(286890);
      Object localObject = MusicMvCommentFooter.d(this.Mil);
      if (localObject != null)
      {
        localObject = ((MMEditText)localObject).getInputConnection();
        if (localObject != null)
        {
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
          ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
        }
      }
      AppMethodBeat.o(286890);
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(286883);
      if (!Util.isNullOrNil(paramString))
      {
        MMEditText localMMEditText = MusicMvCommentFooter.d(this.Mil);
        if (localMMEditText != null) {
          localMMEditText.append(com.tencent.mm.ui.i.c.b.c(this.Mil.getContext(), (CharSequence)paramString, localMMEditText.getTextSize()));
        }
      }
      AppMethodBeat.o(286883);
    }
    
    public final void fp(boolean paramBoolean) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$send$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements c.a
  {
    d(MusicMvCommentFooter paramMusicMvCommentFooter) {}
    
    public final void Tw(String paramString)
    {
      AppMethodBeat.i(286847);
      s.u(paramString, "text");
      Log.i("Music.MusicMvCommentFooter", s.X("InputTextBoundaryCheck ok, ready to send, text:", paramString));
      if (!Util.isNullOrNil(paramString))
      {
        MusicMvCommentFooter.b localb = MusicMvCommentFooter.c(this.Mil);
        if (localb != null) {
          localb.aPG(paramString);
        }
      }
      paramString = MusicMvCommentFooter.d(this.Mil);
      s.checkNotNull(paramString);
      paramString.setText((CharSequence)"");
      AppMethodBeat.o(286847);
    }
    
    public final void Tx(String paramString)
    {
      AppMethodBeat.i(286855);
      s.u(paramString, "text");
      AppMethodBeat.o(286855);
    }
    
    public final void eY(String paramString)
    {
      AppMethodBeat.i(286863);
      s.u(paramString, "text");
      com.tencent.mm.ui.base.k.s(this.Mil.getContext(), b.h.sns_upload_post_text_invalid_more, b.h.sns_upload_post_text_invalid_title);
      AppMethodBeat.o(286863);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter
 * JD-Core Version:    0.7.0.1
 */