package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.e.b;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter
  extends BasePanelKeybordLayout
{
  private ImageButton KIF;
  private boolean KIJ;
  private MMEditText Rxv;
  SightRangeWidget Rxw;
  SightLocationWidget Rxx;
  MMActivity lzt;
  ChatFooterPanel moD;
  
  public SnsSightUploadSayFooter(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(99122);
    this.Rxv = null;
    this.KIJ = true;
    this.lzt = ((MMActivity)paramContext);
    paramContext = (ViewGroup)inflate(this.lzt, b.g.sns_sight_upload_say_footer, this);
    this.KIF = ((ImageButton)paramContext.findViewById(b.f.album_comment_mode_iv));
    this.KIF.setOnClickListener(new SnsSightUploadSayFooter.4(this));
    if (e.Ykf == null) {
      this.moD = new d(this.lzt);
    }
    for (;;)
    {
      this.Rxw = ((SightRangeWidget)paramContext.findViewById(b.f.range_widget));
      this.Rxw.Rbp = null;
      this.Rxw.style = 1;
      this.Rxx = ((SightLocationWidget)paramContext.findViewById(b.f.location_widget));
      AppMethodBeat.o(99122);
      return;
      this.moD = e.Ykf.fZ(getContext());
      this.moD.setEntranceScene(ChatFooterPanel.NEu);
      this.moD.setVisibility(8);
      ((LinearLayout)findViewById(b.f.root)).addView(this.moD, -1, 0);
      this.moD.iKh();
      this.moD.onResume();
      this.moD.setOnTextOperationListener(new ChatFooterPanel.a()
      {
        public final void aWL() {}
        
        public final void aWM()
        {
          AppMethodBeat.i(99120);
          SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
          SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
          AppMethodBeat.o(99120);
        }
        
        public final void append(String paramAnonymousString)
        {
          AppMethodBeat.i(99121);
          try
          {
            SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).bDt(paramAnonymousString);
            AppMethodBeat.o(99121);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            Log.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", paramAnonymousString, "", new Object[0]);
            AppMethodBeat.o(99121);
          }
        }
        
        public final void fp(boolean paramAnonymousBoolean) {}
      });
    }
  }
  
  private void aWJ()
  {
    AppMethodBeat.i(99124);
    this.moD.onPause();
    this.moD.setVisibility(8);
    AppMethodBeat.o(99124);
  }
  
  public djv getLocation()
  {
    AppMethodBeat.i(99126);
    djv localdjv = this.Rxx.getLocation();
    AppMethodBeat.o(99126);
    return localdjv;
  }
  
  public List<View> getPanelView()
  {
    AppMethodBeat.i(99125);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.moD);
    AppMethodBeat.o(99125);
    return localArrayList;
  }
  
  public void setMMEditText(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(99123);
    this.Rxv = paramMMEditText;
    paramMMEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(99117);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sns/ui/SnsSightUploadSayFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (SnsSightUploadSayFooter.this.getVisibility() == 8) {
          SnsSightUploadSayFooter.this.setVisibility(0);
        }
        if (SnsSightUploadSayFooter.this.moD.getVisibility() == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            SnsSightUploadSayFooter.a(SnsSightUploadSayFooter.this);
          }
          a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSightUploadSayFooter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99117);
          return;
        }
      }
    });
    paramMMEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        return false;
      }
    });
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99118);
        SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).performClick();
        SnsSightUploadSayFooter.b(SnsSightUploadSayFooter.this).requestFocus();
        SnsSightUploadSayFooter.c(SnsSightUploadSayFooter.this).showVKB();
        AppMethodBeat.o(99118);
      }
    }, 200L);
    AppMethodBeat.o(99123);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSightUploadSayFooter
 * JD-Core Version:    0.7.0.1
 */