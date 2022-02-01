package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.m;
import com.tencent.mm.pluginsdk.ui.span.p.a;
import com.tencent.mm.pluginsdk.ui.span.x;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.base.ad;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bd;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class TextPreviewUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private com.tencent.mm.ui.widget.b.a GAa;
  private m JDk;
  private Animation PHj;
  private Animation PHk;
  private boolean YkZ;
  private TextView aeiN;
  private int aelT;
  private com.tencent.mm.ui.widget.textview.a aelU;
  private CharSequence aelV;
  private View aelW;
  private View aelX;
  private View aelY;
  private CustomScrollView aelZ;
  private final int aema;
  private final int aemb;
  private boolean aemc;
  private String aemd;
  private boolean aeme;
  private boolean aemf;
  boolean aemg;
  private ToolsBar aemh;
  private View aemi;
  private CharSequence bba;
  private int bottom;
  private int bwk;
  private cc hTm;
  private TextView sQ;
  private final int vEM;
  
  public TextPreviewUI()
  {
    AppMethodBeat.i(254028);
    this.sQ = null;
    this.aeiN = null;
    this.bba = null;
    this.vEM = 0;
    this.aema = 1;
    this.aemb = 2;
    this.bottom = 0;
    this.YkZ = false;
    this.aemc = false;
    this.aeme = false;
    this.aemf = false;
    this.JDk = new m()
    {
      public final Object a(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
      {
        AppMethodBeat.i(253673);
        TextPreviewUI.a(TextPreviewUI.this, true);
        AppMethodBeat.o(253673);
        return null;
      }
      
      public final Object b(com.tencent.mm.pluginsdk.ui.applet.u paramAnonymousu)
      {
        return null;
      }
    };
    this.aemg = false;
    AppMethodBeat.o(254028);
  }
  
  private void cy(cc paramcc)
  {
    AppMethodBeat.i(34950);
    com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(getContext());
    localc.aeLx = new TextPreviewUI.7(this, localc, paramcc);
    localc.show();
    AppMethodBeat.o(34950);
  }
  
  private static boolean cz(cc paramcc)
  {
    AppMethodBeat.i(254033);
    if ((au.bwE(paramcc.field_talker)) || (au.bwF(paramcc.field_talker)))
    {
      AppMethodBeat.o(254033);
      return true;
    }
    AppMethodBeat.o(254033);
    return false;
  }
  
  public int getLayoutId()
  {
    return R.i.ggm;
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(34949);
    finish();
    AppMethodBeat.o(34949);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34946);
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    if (d.rb(19)) {
      getWindow().setFlags(67109888, 67109888);
    }
    this.aelW = findViewById(R.h.fZc);
    this.bba = getIntent().getCharSequenceExtra("key_chat_text");
    this.aelT = getIntent().getIntExtra("key_msg_type", 0);
    long l = getIntent().getLongExtra("Chat_Msg_Id", 0L);
    bh.bCz();
    this.hTm = com.tencent.mm.model.c.bzD().sl(l);
    this.sQ = ((TextView)findViewById(R.h.fIW));
    this.aeiN = ((TextView)findViewById(R.h.fIX));
    Object localObject1 = this.bba;
    paramBundle = this.aeiN;
    Object localObject2 = this.hTm.field_talker;
    localObject1 = ((SpannableString)new SpannableString((CharSequence)localObject1)).toString();
    Bundle localBundle = x.aq(getIntent().getBooleanExtra("is_group_chat", false), com.tencent.mm.modelappbrand.a.KG((String)localObject2));
    localBundle.putString("geta8key_username", (String)localObject2);
    localBundle.putInt("KMsgType", this.hTm.getType());
    localObject2 = paramBundle.getContext();
    int i = (int)paramBundle.getTextSize();
    p.a locala = com.tencent.mm.pluginsdk.ui.span.p.YoF;
    boolean bool;
    if (!bt.U(this.hTm))
    {
      bool = true;
      paramBundle.setText(com.tencent.mm.pluginsdk.ui.span.p.a((Context)localObject2, (CharSequence)localObject1, i, 1, localBundle, null, 1, locala, bool));
      this.bba = paramBundle.getText();
      this.sQ.setText(com.tencent.mm.smiley.u.iVt().a(getContext(), this.bba, this.sQ.getTextSize()));
      this.aemd = z.bAM();
      paramBundle = com.tencent.mm.ui.chatting.i.a.aeJh;
      com.tencent.mm.ui.chatting.i.a.a.a(this.sQ, this.hTm, cz(this.hTm), this.aemd);
      this.aelX = findViewById(R.h.fLV);
      this.aelY = this.aelX.findViewById(R.h.fLT);
      this.aelZ = ((CustomScrollView)findViewById(R.h.fIS));
      this.sQ.setMovementMethod(LinkMovementMethod.getInstance());
      paramBundle = this.sQ.getViewTreeObserver();
      this.aeme = getIntent().getBooleanExtra("key_chat_preview_hide_toolbar", false);
      paramBundle.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(254263);
          TextPreviewUI.a(TextPreviewUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
          if (TextPreviewUI.a(TextPreviewUI.this).getLineCount() == 1) {
            TextPreviewUI.a(TextPreviewUI.this).setGravity(1);
          }
          AppMethodBeat.o(254263);
          return false;
        }
      });
      this.PHk = AnimationUtils.loadAnimation(getContext(), R.a.push_up_in);
      this.PHj = AnimationUtils.loadAnimation(getContext(), R.a.push_down_out);
      this.GAa = new com.tencent.mm.ui.widget.b.a(getContext(), this.sQ);
      this.GAa.agjw = true;
      this.GAa.agjB = false;
      this.GAa.agju = new u.f()
      {
        public final void OnCreateContextMMMenu(com.tencent.mm.ui.base.s paramAnonymouss, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
        {
          AppMethodBeat.i(254245);
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 7, 0);
          paramAnonymouss.clear();
          paramAnonymouss.a(0, TextPreviewUI.this.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
          int i = bt.Y(TextPreviewUI.b(TextPreviewUI.this));
          if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.mu(TextPreviewUI.a(TextPreviewUI.this)).length())) {
            paramAnonymouss.a(1, TextPreviewUI.this.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
          }
          paramAnonymouss.a(2, TextPreviewUI.this.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
          TextPreviewUI.this.getContext();
          com.tencent.mm.ui.chatting.m.a.a(TextPreviewUI.c(TextPreviewUI.this), paramAnonymouss, TextPreviewUI.this.getResources(), TextPreviewUI.d(TextPreviewUI.this), TextPreviewUI.b(TextPreviewUI.this), 4);
          AppMethodBeat.o(254245);
        }
      };
      this.GAa.agjt = new TextPreviewUI.13(this);
      this.GAa.GAC = new u.i()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          boolean bool = false;
          AppMethodBeat.i(254254);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            AppMethodBeat.o(254254);
            return;
          case 0: 
            ClipboardHelper.setText(MMApplicationContext.getContext(), TextPreviewUI.d(TextPreviewUI.this), TextPreviewUI.d(TextPreviewUI.this));
            if (TextPreviewUI.e(TextPreviewUI.this) != null)
            {
              TextPreviewUI.e(TextPreviewUI.this).cRQ();
              TextPreviewUI.e(TextPreviewUI.this).agoW = true;
              TextPreviewUI.e(TextPreviewUI.this).agoX = true;
              TextPreviewUI.e(TextPreviewUI.this).cRT();
            }
            paramAnonymousMenuItem = TextPreviewUI.b(TextPreviewUI.this);
            if (TextPreviewUI.d(TextPreviewUI.this) == null) {}
            for (paramAnonymousInt = 0;; paramAnonymousInt = TextPreviewUI.d(TextPreviewUI.this).length())
            {
              TextPreviewUI.b(paramAnonymousMenuItem, 8, paramAnonymousInt);
              Toast.makeText(TextPreviewUI.this.getContext(), R.l.app_copy_ok, 0).show();
              AppMethodBeat.o(254254);
              return;
            }
          case 1: 
            if (TextPreviewUI.e(TextPreviewUI.this) != null)
            {
              TextPreviewUI.e(TextPreviewUI.this).cRT();
              TextPreviewUI.e(TextPreviewUI.this).jJp();
              TextPreviewUI.e(TextPreviewUI.this).gc(0, TextPreviewUI.a(TextPreviewUI.this).getText().length());
              TextPreviewUI.e(TextPreviewUI.this).agoW = false;
              TextPreviewUI.e(TextPreviewUI.this).agoX = false;
              TextPreviewUI.e(TextPreviewUI.this).jJo();
            }
            TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 10, 0);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(253825);
                if (TextPreviewUI.e(TextPreviewUI.this) != null) {
                  TextPreviewUI.e(TextPreviewUI.this).jJt();
                }
                AppMethodBeat.o(253825);
              }
            }, 100L);
            AppMethodBeat.o(254254);
            return;
          case 2: 
            TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 9, 0);
            TextPreviewUI.d(TextPreviewUI.this.getContext(), TextPreviewUI.d(TextPreviewUI.this));
            AppMethodBeat.o(254254);
            return;
          }
          if ((TextPreviewUI.a(TextPreviewUI.this) != null) && (TextPreviewUI.a(TextPreviewUI.this).getText() != null) && (!Util.isNullOrNil(TextPreviewUI.d(TextPreviewUI.this))) && (TextPreviewUI.a(TextPreviewUI.this).getText().length() != TextPreviewUI.d(TextPreviewUI.this).length())) {}
          for (;;)
          {
            paramAnonymousMenuItem = TextPreviewUI.this;
            TextPreviewUI.this.getResources();
            com.tencent.mm.ui.chatting.m.a.a(paramAnonymousMenuItem, TextPreviewUI.d(TextPreviewUI.this), TextPreviewUI.b(TextPreviewUI.this), 4, bool);
            break;
            bool = true;
          }
        }
      };
      paramBundle = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(254259);
          if (paramAnonymousMotionEvent.getAction() == 0) {
            TextPreviewUI.this.aemg = true;
          }
          if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 4))
          {
            TextPreviewUI.this.aemg = false;
            if (TextPreviewUI.a(TextPreviewUI.this).getMovementMethod() == null) {
              TextPreviewUI.a(TextPreviewUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(254253);
                  TextPreviewUI.a(TextPreviewUI.this).setMovementMethod(LinkMovementMethod.getInstance());
                  AppMethodBeat.o(254253);
                }
              });
            }
          }
          AppMethodBeat.o(254259);
          return false;
        }
      };
      if ((this.aelU == null) && (!bt.F(this.hTm)) && (!bt.N(this.hTm)) && (!bt.Q(this.hTm)))
      {
        paramBundle = new com.tencent.mm.ui.widget.textview.a.a(this.sQ, this.GAa, null, null, paramBundle);
        paramBundle.aggi = R.e.selected_blue;
        paramBundle.aggj = R.e.cursor_handle_color;
        paramBundle.agph = bd.fromDPToPix(getContext(), 20);
        this.aelU = paramBundle.jJu();
        this.aelU.agoO = new ad()
        {
          public final void aV(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(254268);
            TextPreviewUI.a(TextPreviewUI.this, paramAnonymousCharSequence);
            if (TextPreviewUI.this.aemg) {
              TextPreviewUI.a(TextPreviewUI.this).setMovementMethod(null);
            }
            AppMethodBeat.o(254268);
          }
        };
      }
      this.aelW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(254271);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if ((TextPreviewUI.e(TextPreviewUI.this) != null) && ((!TextPreviewUI.e(TextPreviewUI.this).agoW) || (!TextPreviewUI.e(TextPreviewUI.this).agoX)))
          {
            TextPreviewUI.e(TextPreviewUI.this).cRQ();
            TextPreviewUI.e(TextPreviewUI.this).agoW = true;
            TextPreviewUI.e(TextPreviewUI.this).agoX = true;
            TextPreviewUI.e(TextPreviewUI.this).cRT();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254271);
            return;
            TextPreviewUI.this.finish();
          }
        }
      });
      this.sQ.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(254272);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (TextPreviewUI.e(TextPreviewUI.this) != null) {
            if ((TextPreviewUI.e(TextPreviewUI.this).agoW) && (TextPreviewUI.e(TextPreviewUI.this).agoX))
            {
              if (TextPreviewUI.f(TextPreviewUI.this))
              {
                TextPreviewUI.a(TextPreviewUI.this, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254272);
                return;
              }
              TextPreviewUI.this.finish();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254272);
            return;
            TextPreviewUI.e(TextPreviewUI.this).cRQ();
            TextPreviewUI.e(TextPreviewUI.this).agoW = true;
            TextPreviewUI.e(TextPreviewUI.this).agoX = true;
            TextPreviewUI.e(TextPreviewUI.this).cRT();
            continue;
            if (TextPreviewUI.f(TextPreviewUI.this))
            {
              TextPreviewUI.a(TextPreviewUI.this, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(254272);
              return;
            }
            TextPreviewUI.this.finish();
          }
        }
      });
      if (Util.isNullOrNil(bt.W(this.hTm))) {
        break label789;
      }
      this.aelX.setVisibility(0);
      this.aelY.setOnClickListener(new TextPreviewUI.2(this));
    }
    label789:
    while ((bt.F(this.hTm)) || (bt.N(this.hTm)))
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(253666);
          TextPreviewUI.this.finish();
          AppMethodBeat.o(253666);
          return true;
        }
      });
      this.aelZ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(253668);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(253668);
            return false;
            TextPreviewUI.b(TextPreviewUI.this, true);
            continue;
            if (!TextPreviewUI.g(TextPreviewUI.this))
            {
              TextPreviewUI.c(TextPreviewUI.this, true);
              TextPreviewUI.b(TextPreviewUI.this, true);
              continue;
              TextPreviewUI.b(TextPreviewUI.this, false);
              TextPreviewUI.c(TextPreviewUI.this, false);
            }
          }
        }
      });
      this.aelZ.setOnScrollChangeListener(new CustomScrollView.a()
      {
        public final void onScrollChange(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(253690);
          TextPreviewUI.h(TextPreviewUI.this);
          if (paramAnonymousScrollView.getChildAt(0).getMeasuredHeight() == paramAnonymousScrollView.getHeight() + paramAnonymousScrollView.getScrollY())
          {
            paramAnonymousInt1 = 1;
            if (paramAnonymousInt1 != 0) {
              TextPreviewUI.a(TextPreviewUI.this, paramAnonymousScrollView.getScrollY());
            }
            if ((paramAnonymousScrollView.getScrollY() > 0) && ((paramAnonymousScrollView.getScrollY() < TextPreviewUI.i(TextPreviewUI.this) - 10) || (TextPreviewUI.i(TextPreviewUI.this) <= 0))) {
              break label115;
            }
            TextPreviewUI.j(TextPreviewUI.this);
          }
          label115:
          while (!TextPreviewUI.k(TextPreviewUI.this))
          {
            TextPreviewUI.b(TextPreviewUI.this, paramAnonymousInt2 - paramAnonymousInt4);
            AppMethodBeat.o(253690);
            return;
            paramAnonymousInt1 = 0;
            break;
          }
          if (paramAnonymousInt4 > paramAnonymousInt2) {
            TextPreviewUI.j(TextPreviewUI.this);
          }
          for (;;)
          {
            TextPreviewUI.b(TextPreviewUI.this, false);
            break;
            if (paramAnonymousInt4 < paramAnonymousInt2) {
              TextPreviewUI.l(TextPreviewUI.this);
            }
          }
        }
      });
      bh.aZW().a(525, this);
      AppMethodBeat.o(34946);
      return;
      bool = false;
      break;
    }
    if (this.aelT == 1)
    {
      i = 1;
      label819:
      if ((i != 0) || (bt.Q(this.hTm))) {
        break label963;
      }
      if (!au.bwZ(this.hTm.field_talker))
      {
        paramBundle = (ViewStub)findViewById(R.h.gcp);
        if (paramBundle != null) {
          this.aemi = paramBundle.inflate();
        }
        this.aemh = ((ToolsBar)findViewById(R.h.gaz));
        paramBundle = this.aemh;
        if (this.aeme) {
          break label965;
        }
      }
    }
    label963:
    label965:
    for (i = 0;; i = 8)
    {
      paramBundle.setVisibility(i);
      if (this.aemh == null) {
        break;
      }
      this.aemh.b(0, new TextPreviewUI.8(this));
      this.aemh.b(1, new TextPreviewUI.9(this));
      this.aemh.b(2, new TextPreviewUI.10(this));
      break;
      i = 0;
      break label819;
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34951);
    super.onDestroy();
    bh.aZW().b(525, this);
    AppMethodBeat.o(34951);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34948);
    super.onPause();
    f.d(false, true, true);
    com.tencent.mm.pluginsdk.ui.span.p.b(this.JDk);
    AppMethodBeat.o(34948);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34947);
    super.onResume();
    f.d(true, true, true);
    if (this.aelU != null)
    {
      if (!this.aelU.agoW) {
        this.aelU.jJt();
      }
      if (!this.aelU.agoX) {
        this.aelU.jJo();
      }
    }
    com.tencent.mm.pluginsdk.ui.span.p.a(this.JDk);
    AppMethodBeat.o(34947);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(34952);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramp.getType())
      {
      default: 
        AppMethodBeat.o(34952);
        return;
      }
      Log.i("MicroMsg.TextPreviewUI", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(getContext(), getContext().getResources().getString(R.l.gJw), "", null);
      AppMethodBeat.o(34952);
      return;
    }
    if (paramp.getType() == 525)
    {
      Log.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Util.nullAsNil(paramString) });
      AppCompatActivity localAppCompatActivity = getContext();
      paramp = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramp = getResources().getString(R.l.gTe);
      }
      k.c(localAppCompatActivity, paramp, getContext().getResources().getString(R.l.gTf), true);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(34952);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI
 * JD-Core Version:    0.7.0.1
 */