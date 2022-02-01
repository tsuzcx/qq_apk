package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
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
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.span.l.a;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class TextPreviewUI
  extends MMActivity
  implements com.tencent.mm.an.i
{
  private com.tencent.mm.ui.widget.b.a AYp;
  private com.tencent.mm.pluginsdk.ui.span.i DLY;
  private Animation JtK;
  private Animation JtL;
  private CharSequence LV;
  private int PS;
  private boolean RoI;
  private TextView WBt;
  private final int WEA;
  private final int WEC;
  private boolean WED;
  private String WEE;
  private boolean WEF;
  boolean WEG;
  private ToolsBar WEH;
  private View WEI;
  private int WEt;
  private com.tencent.mm.ui.widget.textview.a WEu;
  private CharSequence WEv;
  private View WEw;
  private View WEx;
  private View WEy;
  private CustomScrollView WEz;
  private int bottom;
  private ca fNz;
  private TextView rR;
  private final int szg;
  
  public TextPreviewUI()
  {
    AppMethodBeat.i(282736);
    this.rR = null;
    this.WBt = null;
    this.LV = null;
    this.szg = 0;
    this.WEA = 1;
    this.WEC = 2;
    this.bottom = 0;
    this.RoI = false;
    this.WED = false;
    this.WEF = false;
    this.DLY = new TextPreviewUI.1(this);
    this.WEG = false;
    AppMethodBeat.o(282736);
  }
  
  private void ck(ca paramca)
  {
    AppMethodBeat.i(34950);
    com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(getContext());
    localc.XbP = new TextPreviewUI.7(this, localc, paramca);
    localc.show();
    AppMethodBeat.o(34950);
  }
  
  private static boolean cl(ca paramca)
  {
    AppMethodBeat.i(282739);
    if ((ab.Lj(paramca.field_talker)) || (ab.PQ(paramca.field_talker)))
    {
      AppMethodBeat.o(282739);
      return true;
    }
    AppMethodBeat.o(282739);
    return false;
  }
  
  public int getLayoutId()
  {
    return R.i.edw;
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
    if (d.qV(19)) {
      getWindow().setFlags(67109888, 67109888);
    }
    this.WEw = findViewById(R.h.dWw);
    this.LV = getIntent().getCharSequenceExtra("key_chat_text");
    this.WEt = getIntent().getIntExtra("key_msg_type", 0);
    long l = getIntent().getLongExtra("Chat_Msg_Id", 0L);
    bh.beI();
    this.fNz = com.tencent.mm.model.c.bbO().Oq(l);
    this.rR = ((TextView)findViewById(R.h.dHK));
    this.WBt = ((TextView)findViewById(R.h.dHL));
    Object localObject1 = this.LV;
    paramBundle = this.WBt;
    Object localObject2 = this.fNz.field_talker;
    localObject1 = ((SpannableString)new SpannableString((CharSequence)localObject1)).toString();
    localObject2 = com.tencent.mm.pluginsdk.ui.span.t.ap(getIntent().getBooleanExtra("is_group_chat", false), com.tencent.mm.modelappbrand.a.SF((String)localObject2));
    Context localContext = paramBundle.getContext();
    int i = (int)paramBundle.getTextSize();
    l.a locala = l.Rsm;
    boolean bool;
    if (!bs.Q(this.fNz))
    {
      bool = true;
      paramBundle.setText(l.a(localContext, (CharSequence)localObject1, i, 1, localObject2, null, 1, locala, bool));
      this.LV = paramBundle.getText();
      this.rR.setText(com.tencent.mm.cl.h.htZ().a(getContext(), this.LV, this.rR.getTextSize()));
      this.WEE = com.tencent.mm.model.z.bcZ();
      paramBundle = com.tencent.mm.ui.chatting.m.a.WZH;
      com.tencent.mm.ui.chatting.m.a.a.a(this.rR, this.fNz, cl(this.fNz), this.WEE);
      this.WEx = findViewById(R.h.dKx);
      this.WEy = this.WEx.findViewById(R.h.dKv);
      this.WEz = ((CustomScrollView)findViewById(R.h.dHJ));
      this.rR.setMovementMethod(LinkMovementMethod.getInstance());
      this.rR.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          AppMethodBeat.i(201692);
          TextPreviewUI.a(TextPreviewUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
          if (TextPreviewUI.a(TextPreviewUI.this).getLineCount() == 1) {
            TextPreviewUI.a(TextPreviewUI.this).setGravity(1);
          }
          AppMethodBeat.o(201692);
          return false;
        }
      });
      this.JtL = AnimationUtils.loadAnimation(getContext(), R.a.push_up_in);
      this.JtK = AnimationUtils.loadAnimation(getContext(), R.a.push_down_out);
      this.AYp = new com.tencent.mm.ui.widget.b.a(getContext(), this.rR);
      this.AYp.Yri = true;
      this.AYp.Yrl = false;
      this.AYp.Yrg = new q.e()
      {
        public final void a(o paramAnonymouso, View paramAnonymousView)
        {
          AppMethodBeat.i(219965);
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 7, 0);
          paramAnonymouso.clear();
          paramAnonymouso.b(0, TextPreviewUI.this.getResources().getString(R.l.app_copy), R.k.icons_filled_copy);
          int i = bs.U(TextPreviewUI.b(TextPreviewUI.this));
          if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.iX(TextPreviewUI.a(TextPreviewUI.this)).length())) {
            paramAnonymouso.b(1, TextPreviewUI.this.getResources().getString(R.l.menu_select_all), R.k.icons_filled_allselect);
          }
          paramAnonymouso.b(2, TextPreviewUI.this.getResources().getString(R.l.menu_retransmits), R.k.icons_filled_share);
          TextPreviewUI.this.getContext();
          com.tencent.mm.ui.chatting.q.a.a(TextPreviewUI.c(TextPreviewUI.this), paramAnonymouso, TextPreviewUI.this.getResources(), TextPreviewUI.d(TextPreviewUI.this), TextPreviewUI.b(TextPreviewUI.this), 4);
          AppMethodBeat.o(219965);
        }
      };
      this.AYp.Yrf = new TextPreviewUI.13(this);
      this.AYp.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          boolean bool = false;
          AppMethodBeat.i(287321);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            AppMethodBeat.o(287321);
            return;
          case 0: 
            ClipboardHelper.setText(MMApplicationContext.getContext(), TextPreviewUI.d(TextPreviewUI.this), TextPreviewUI.d(TextPreviewUI.this));
            if (TextPreviewUI.e(TextPreviewUI.this) != null)
            {
              TextPreviewUI.e(TextPreviewUI.this).cpn();
              TextPreviewUI.e(TextPreviewUI.this).YwE = true;
              TextPreviewUI.e(TextPreviewUI.this).YwF = true;
              TextPreviewUI.e(TextPreviewUI.this).cpq();
            }
            paramAnonymousMenuItem = TextPreviewUI.b(TextPreviewUI.this);
            if (TextPreviewUI.d(TextPreviewUI.this) == null) {}
            for (paramAnonymousInt = 0;; paramAnonymousInt = TextPreviewUI.d(TextPreviewUI.this).length())
            {
              TextPreviewUI.b(paramAnonymousMenuItem, 8, paramAnonymousInt);
              Toast.makeText(TextPreviewUI.this.getContext(), R.l.app_copy_ok, 0).show();
              AppMethodBeat.o(287321);
              return;
            }
          case 1: 
            if (TextPreviewUI.e(TextPreviewUI.this) != null)
            {
              TextPreviewUI.e(TextPreviewUI.this).cpq();
              TextPreviewUI.e(TextPreviewUI.this).ieg();
              TextPreviewUI.e(TextPreviewUI.this).fj(0, TextPreviewUI.a(TextPreviewUI.this).getText().length());
              TextPreviewUI.e(TextPreviewUI.this).YwE = false;
              TextPreviewUI.e(TextPreviewUI.this).YwF = false;
              TextPreviewUI.e(TextPreviewUI.this).ief();
            }
            TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 10, 0);
            MMHandlerThread.postToMainThreadDelayed(new TextPreviewUI.14.1(this), 100L);
            AppMethodBeat.o(287321);
            return;
          case 2: 
            TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 9, 0);
            TextPreviewUI.e(TextPreviewUI.this.getContext(), TextPreviewUI.d(TextPreviewUI.this));
            AppMethodBeat.o(287321);
            return;
          }
          if ((TextPreviewUI.a(TextPreviewUI.this) != null) && (TextPreviewUI.a(TextPreviewUI.this).getText() != null) && (!Util.isNullOrNil(TextPreviewUI.d(TextPreviewUI.this))) && (TextPreviewUI.a(TextPreviewUI.this).getText().length() != TextPreviewUI.d(TextPreviewUI.this).length())) {}
          for (;;)
          {
            paramAnonymousMenuItem = TextPreviewUI.this;
            TextPreviewUI.this.getResources();
            com.tencent.mm.ui.chatting.q.a.a(paramAnonymousMenuItem, TextPreviewUI.d(TextPreviewUI.this), TextPreviewUI.b(TextPreviewUI.this), 4, bool);
            break;
            bool = true;
          }
        }
      };
      paramBundle = new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(290032);
          if (paramAnonymousMotionEvent.getAction() == 0) {
            TextPreviewUI.this.WEG = true;
          }
          if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 4))
          {
            TextPreviewUI.this.WEG = false;
            if (TextPreviewUI.a(TextPreviewUI.this).getMovementMethod() == null) {
              TextPreviewUI.a(TextPreviewUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(282518);
                  TextPreviewUI.a(TextPreviewUI.this).setMovementMethod(LinkMovementMethod.getInstance());
                  AppMethodBeat.o(282518);
                }
              });
            }
          }
          AppMethodBeat.o(290032);
          return false;
        }
      };
      if ((this.WEu == null) && (!bs.D(this.fNz)) && (!bs.L(this.fNz)) && (!bs.O(this.fNz)))
      {
        paramBundle = new com.tencent.mm.ui.widget.textview.a.a(this.rR, this.AYp, null, null, paramBundle);
        paramBundle.YnW = R.e.selected_blue;
        paramBundle.YnX = R.e.cursor_handle_color;
        paramBundle.YwP = aw.fromDPToPix(getContext(), 20);
        this.WEu = paramBundle.iel();
        this.WEu.Yww = new com.tencent.mm.ui.base.z()
        {
          public final void aH(CharSequence paramAnonymousCharSequence)
          {
            AppMethodBeat.i(279815);
            TextPreviewUI.a(TextPreviewUI.this, paramAnonymousCharSequence);
            if (TextPreviewUI.this.WEG) {
              TextPreviewUI.a(TextPreviewUI.this).setMovementMethod(null);
            }
            AppMethodBeat.o(279815);
          }
        };
      }
      this.WEw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(280736);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((TextPreviewUI.e(TextPreviewUI.this) != null) && ((!TextPreviewUI.e(TextPreviewUI.this).YwE) || (!TextPreviewUI.e(TextPreviewUI.this).YwF)))
          {
            TextPreviewUI.e(TextPreviewUI.this).cpn();
            TextPreviewUI.e(TextPreviewUI.this).YwE = true;
            TextPreviewUI.e(TextPreviewUI.this).YwF = true;
            TextPreviewUI.e(TextPreviewUI.this).cpq();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(280736);
            return;
            TextPreviewUI.this.finish();
          }
        }
      });
      this.rR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(284675);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (TextPreviewUI.e(TextPreviewUI.this) != null) {
            if ((TextPreviewUI.e(TextPreviewUI.this).YwE) && (TextPreviewUI.e(TextPreviewUI.this).YwF))
            {
              if (TextPreviewUI.f(TextPreviewUI.this))
              {
                TextPreviewUI.a(TextPreviewUI.this, false);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(284675);
                return;
              }
              TextPreviewUI.this.finish();
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(284675);
            return;
            TextPreviewUI.e(TextPreviewUI.this).cpn();
            TextPreviewUI.e(TextPreviewUI.this).YwE = true;
            TextPreviewUI.e(TextPreviewUI.this).YwF = true;
            TextPreviewUI.e(TextPreviewUI.this).cpq();
            continue;
            if (TextPreviewUI.f(TextPreviewUI.this))
            {
              TextPreviewUI.a(TextPreviewUI.this, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(284675);
              return;
            }
            TextPreviewUI.this.finish();
          }
        }
      });
      if (Util.isNullOrNil(bs.S(this.fNz))) {
        break label747;
      }
      this.WEx.setVisibility(0);
      this.WEy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(261438);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/TextPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
          localObject = new Intent(TextPreviewUI.this, WebViewUI.class);
          ((Intent)localObject).putExtra("rawUrl", bs.S(TextPreviewUI.b(TextPreviewUI.this)));
          ((Intent)localObject).putExtra("showShare", false);
          ((Intent)localObject).putExtra("show_bottom", false);
          ((Intent)localObject).putExtra("needRedirect", false);
          paramAnonymousView = TextPreviewUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/chatting/TextPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/ui/chatting/TextPreviewUI$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(261438);
        }
      });
    }
    label910:
    for (;;)
    {
      setBackBtn(new TextPreviewUI.3(this));
      this.WEz.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(256526);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(256526);
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
      this.WEz.setOnScrollChangeListener(new CustomScrollView.a()
      {
        public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(276625);
          TextPreviewUI.h(TextPreviewUI.this);
          int i;
          if (paramAnonymousScrollView.getChildAt(0).getMeasuredHeight() == paramAnonymousScrollView.getHeight() + paramAnonymousScrollView.getScrollY())
          {
            i = 1;
            if (i != 0) {
              TextPreviewUI.a(TextPreviewUI.this, paramAnonymousScrollView.getScrollY());
            }
            if ((paramAnonymousScrollView.getScrollY() > 0) && ((paramAnonymousScrollView.getScrollY() < TextPreviewUI.i(TextPreviewUI.this) - 10) || (TextPreviewUI.i(TextPreviewUI.this) <= 0))) {
              break label117;
            }
            TextPreviewUI.j(TextPreviewUI.this);
          }
          label117:
          while (!TextPreviewUI.k(TextPreviewUI.this))
          {
            TextPreviewUI.b(TextPreviewUI.this, paramAnonymousInt1 - paramAnonymousInt2);
            AppMethodBeat.o(276625);
            return;
            i = 0;
            break;
          }
          if (paramAnonymousInt2 > paramAnonymousInt1) {
            TextPreviewUI.j(TextPreviewUI.this);
          }
          for (;;)
          {
            TextPreviewUI.b(TextPreviewUI.this, false);
            break;
            if (paramAnonymousInt2 < paramAnonymousInt1) {
              TextPreviewUI.l(TextPreviewUI.this);
            }
          }
        }
      });
      bh.aGY().a(525, this);
      AppMethodBeat.o(34946);
      return;
      bool = false;
      break;
      label747:
      if ((!bs.D(this.fNz)) && (!bs.L(this.fNz)))
      {
        if (this.WEt == 1) {}
        for (i = 1;; i = 0)
        {
          if ((i != 0) || (bs.O(this.fNz))) {
            break label910;
          }
          if (!as.bvS(this.fNz.field_talker))
          {
            paramBundle = (ViewStub)findViewById(R.h.dZv);
            if (paramBundle != null) {
              this.WEI = paramBundle.inflate();
            }
            this.WEH = ((ToolsBar)findViewById(R.h.dXT));
            this.WEH.setVisibility(0);
          }
          if (this.WEH == null) {
            break;
          }
          this.WEH.b(0, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(279666);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/TextPreviewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (TextPreviewUI.b(TextPreviewUI.this) != null) {
                TextPreviewUI.e(TextPreviewUI.this.getContext(), TextPreviewUI.m(TextPreviewUI.this).toString());
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(279666);
            }
          });
          this.WEH.b(1, new TextPreviewUI.9(this));
          this.WEH.b(2, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(285816);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/TextPreviewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              TextPreviewUI.b(TextPreviewUI.this, TextPreviewUI.b(TextPreviewUI.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(285816);
            }
          });
          break;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34951);
    super.onDestroy();
    bh.aGY().b(525, this);
    AppMethodBeat.o(34951);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34948);
    super.onPause();
    f.d(false, true, true);
    l.b(this.DLY);
    AppMethodBeat.o(34948);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34947);
    super.onResume();
    f.d(true, true, true);
    if (this.WEu != null)
    {
      if (!this.WEu.YwE) {
        this.WEu.iek();
      }
      if (!this.WEu.YwF) {
        this.WEu.ief();
      }
    }
    l.a(this.DLY);
    AppMethodBeat.o(34947);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(34952);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramq.getType())
      {
      default: 
        AppMethodBeat.o(34952);
        return;
      }
      Log.i("MicroMsg.TextPreviewUI", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(getContext(), getContext().getResources().getString(R.l.eHQ), "", null);
      AppMethodBeat.o(34952);
      return;
    }
    if (paramq.getType() == 525)
    {
      Log.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Util.nullAsNil(paramString) });
      AppCompatActivity localAppCompatActivity = getContext();
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = getResources().getString(R.l.eQy);
      }
      com.tencent.mm.ui.base.h.c(localAppCompatActivity, paramq, getContext().getResources().getString(R.l.eQz), true);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(34952);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI
 * JD-Core Version:    0.7.0.1
 */