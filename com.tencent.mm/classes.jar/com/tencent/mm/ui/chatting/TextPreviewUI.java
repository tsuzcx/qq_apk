package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bn;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.widget.textview.a.a;

@com.tencent.mm.ui.base.a(3)
public class TextPreviewUI
  extends MMActivity
  implements com.tencent.mm.ak.f
{
  private int Bd;
  private boolean Fxb = false;
  private TextView JWC = null;
  private boolean JZA = false;
  private ToolsBar JZB;
  private View JZC;
  private int JZq;
  private com.tencent.mm.ui.widget.textview.a JZr;
  private com.tencent.mm.ui.widget.b.a JZs;
  private CharSequence JZt;
  private View JZu;
  private View JZv;
  private View JZw;
  private CustomScrollView JZx;
  private final int JZy = 1;
  private final int JZz = 2;
  private TextView Wf = null;
  private int bottom = 0;
  private bv dCi;
  private final int ofk = 0;
  private CharSequence text = null;
  private Animation zjo;
  private Animation zjp;
  
  private void bB(bv parambv)
  {
    AppMethodBeat.i(34950);
    com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(getContext());
    localc.Kuj = new TextPreviewUI.5(this, localc, parambv);
    localc.show();
    AppMethodBeat.o(34950);
  }
  
  public int getLayoutId()
  {
    return 2131493465;
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
    if (d.lA(19)) {
      getWindow().setFlags(67109888, 67109888);
    }
    this.JZu = findViewById(2131305741);
    this.text = getIntent().getCharSequenceExtra("key_chat_text");
    this.JZq = getIntent().getIntExtra("key_msg_type", 0);
    long l = getIntent().getLongExtra("Chat_Msg_Id", 0L);
    bc.aCg();
    this.dCi = com.tencent.mm.model.c.azI().ys(l);
    this.Wf = ((TextView)findViewById(2131300329));
    this.JWC = ((TextView)findViewById(2131300330));
    Object localObject = this.text;
    TextView localTextView = this.JWC;
    paramBundle = (Bundle)localObject;
    if ((localObject instanceof SpannableString))
    {
      localTextView.setText(((SpannableString)localObject).toString());
      k.o(localTextView, 1);
      paramBundle = localTextView.getText();
    }
    this.text = paramBundle;
    paramBundle = this.Wf;
    localObject = com.tencent.mm.ce.g.fqZ();
    getContext();
    paramBundle.setText(((com.tencent.mm.ce.g)localObject).b(this.text, this.Wf.getTextSize()));
    this.JZv = findViewById(2131301274);
    this.JZw = this.JZv.findViewById(2131301241);
    this.JZx = ((CustomScrollView)findViewById(2131300328));
    this.Wf.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(34929);
        TextPreviewUI.a(TextPreviewUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
        if (TextPreviewUI.a(TextPreviewUI.this).getLineCount() == 1) {
          TextPreviewUI.a(TextPreviewUI.this).setGravity(1);
        }
        AppMethodBeat.o(34929);
        return false;
      }
    });
    this.zjp = AnimationUtils.loadAnimation(getContext(), 2130772108);
    this.zjo = AnimationUtils.loadAnimation(getContext(), 2130772106);
    this.JZs = new com.tencent.mm.ui.widget.b.a(getContext(), this.Wf);
    this.JZs.LwJ = true;
    this.JZs.LwM = false;
    this.JZs.LwH = new n.c()
    {
      public final void a(l paramAnonymousl, View paramAnonymousView)
      {
        AppMethodBeat.i(187188);
        TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 7, 0);
        paramAnonymousl.clear();
        paramAnonymousl.a(0, TextPreviewUI.this.getResources().getString(2131755701), 2131690381);
        int i = bn.F(TextPreviewUI.b(TextPreviewUI.this));
        if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.hm(TextPreviewUI.a(TextPreviewUI.this)).length())) {
          paramAnonymousl.a(1, TextPreviewUI.this.getResources().getString(2131761224), 2131691572);
        }
        paramAnonymousl.a(2, TextPreviewUI.this.getResources().getString(2131761223), 2131690478);
        AppMethodBeat.o(187188);
      }
    };
    this.JZs.LwG = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo) {}
    };
    this.JZs.LfT = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(187190);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(187190);
          return;
          ((ClipboardManager)ak.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.c(TextPreviewUI.this), TextPreviewUI.c(TextPreviewUI.this)));
          if (TextPreviewUI.d(TextPreviewUI.this) != null)
          {
            TextPreviewUI.d(TextPreviewUI.this).fRO();
            TextPreviewUI.d(TextPreviewUI.this).LCs = true;
            TextPreviewUI.d(TextPreviewUI.this).LCt = true;
            TextPreviewUI.d(TextPreviewUI.this).fRN();
          }
          paramAnonymousMenuItem = TextPreviewUI.b(TextPreviewUI.this);
          if (TextPreviewUI.c(TextPreviewUI.this) == null) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = TextPreviewUI.c(TextPreviewUI.this).length())
          {
            TextPreviewUI.b(paramAnonymousMenuItem, 8, paramAnonymousInt);
            Toast.makeText(TextPreviewUI.this.getContext(), 2131755702, 0).show();
            AppMethodBeat.o(187190);
            return;
          }
          if (TextPreviewUI.d(TextPreviewUI.this) != null)
          {
            TextPreviewUI.d(TextPreviewUI.this).fRN();
            TextPreviewUI.d(TextPreviewUI.this).fRR();
            TextPreviewUI.d(TextPreviewUI.this).kw(0, TextPreviewUI.a(TextPreviewUI.this).getText().length());
            TextPreviewUI.d(TextPreviewUI.this).LCs = false;
            TextPreviewUI.d(TextPreviewUI.this).LCt = false;
            TextPreviewUI.d(TextPreviewUI.this).fRQ();
          }
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 10, 0);
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187189);
              if (TextPreviewUI.d(TextPreviewUI.this) != null) {
                TextPreviewUI.d(TextPreviewUI.this).fRV();
              }
              AppMethodBeat.o(187189);
            }
          }, 100L);
          AppMethodBeat.o(187190);
          return;
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 9, 0);
          TextPreviewUI.e(TextPreviewUI.this.getContext(), TextPreviewUI.c(TextPreviewUI.this));
        }
      }
    };
    if ((this.JZr == null) && (!bn.z(this.dCi)) && (!bn.A(this.dCi)))
    {
      paramBundle = new a.a(this.Wf, this.JZs);
      paramBundle.LCj = 2131100846;
      paramBundle.LCk = 2131100195;
      paramBundle.LCE = aq.fromDPToPix(getContext(), 20);
      this.JZr = paramBundle.fRW();
      this.JZr.LCb = new v()
      {
        public final void am(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(187191);
          TextPreviewUI.a(TextPreviewUI.this, paramAnonymousCharSequence);
          AppMethodBeat.o(187191);
        }
      };
    }
    this.JZu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34942);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((TextPreviewUI.d(TextPreviewUI.this) != null) && ((!TextPreviewUI.d(TextPreviewUI.this).LCs) || (!TextPreviewUI.d(TextPreviewUI.this).LCt)))
        {
          TextPreviewUI.d(TextPreviewUI.this).fRO();
          TextPreviewUI.d(TextPreviewUI.this).LCs = true;
          TextPreviewUI.d(TextPreviewUI.this).LCt = true;
          TextPreviewUI.d(TextPreviewUI.this).fRN();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34942);
          return;
          TextPreviewUI.this.finish();
        }
      }
    });
    this.Wf.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34943);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((TextPreviewUI.d(TextPreviewUI.this) != null) && ((!TextPreviewUI.d(TextPreviewUI.this).LCs) || (!TextPreviewUI.d(TextPreviewUI.this).LCt)))
        {
          TextPreviewUI.d(TextPreviewUI.this).fRO();
          TextPreviewUI.d(TextPreviewUI.this).LCs = true;
          TextPreviewUI.d(TextPreviewUI.this).LCt = true;
          TextPreviewUI.d(TextPreviewUI.this).fRN();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(34943);
          return;
          TextPreviewUI.this.finish();
        }
      }
    });
    if (!bu.isNullOrNil(bn.D(this.dCi)))
    {
      this.JZv.setVisibility(0);
      this.JZw.setOnClickListener(new TextPreviewUI.15(this));
    }
    label773:
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187193);
          TextPreviewUI.this.finish();
          AppMethodBeat.o(187193);
          return true;
        }
      });
      this.JZx.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(187182);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/TextPreviewUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(187182);
            return false;
            TextPreviewUI.a(TextPreviewUI.this, true);
            continue;
            if (!TextPreviewUI.e(TextPreviewUI.this))
            {
              TextPreviewUI.b(TextPreviewUI.this, true);
              TextPreviewUI.a(TextPreviewUI.this, true);
              continue;
              TextPreviewUI.a(TextPreviewUI.this, false);
              TextPreviewUI.b(TextPreviewUI.this, false);
            }
          }
        }
      });
      this.JZx.setOnScrollChangeListener(new CustomScrollView.a()
      {
        public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(187183);
          TextPreviewUI.f(TextPreviewUI.this);
          int i;
          if (paramAnonymousScrollView.getChildAt(0).getMeasuredHeight() == paramAnonymousScrollView.getHeight() + paramAnonymousScrollView.getScrollY())
          {
            i = 1;
            if (i != 0) {
              TextPreviewUI.a(TextPreviewUI.this, paramAnonymousScrollView.getScrollY());
            }
            if ((paramAnonymousScrollView.getScrollY() > 0) && ((paramAnonymousScrollView.getScrollY() < TextPreviewUI.g(TextPreviewUI.this) - 10) || (TextPreviewUI.g(TextPreviewUI.this) <= 0))) {
              break label117;
            }
            TextPreviewUI.h(TextPreviewUI.this);
          }
          label117:
          while (!TextPreviewUI.i(TextPreviewUI.this))
          {
            TextPreviewUI.b(TextPreviewUI.this, paramAnonymousInt1 - paramAnonymousInt2);
            AppMethodBeat.o(187183);
            return;
            i = 0;
            break;
          }
          if (paramAnonymousInt2 > paramAnonymousInt1) {
            TextPreviewUI.h(TextPreviewUI.this);
          }
          for (;;)
          {
            TextPreviewUI.a(TextPreviewUI.this, false);
            break;
            if (paramAnonymousInt2 < paramAnonymousInt1) {
              TextPreviewUI.j(TextPreviewUI.this);
            }
          }
        }
      });
      bc.ajj().a(525, this);
      AppMethodBeat.o(34946);
      return;
      if ((!bn.z(this.dCi)) && (!bn.A(this.dCi)))
      {
        if (this.JZq == 1) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label773;
          }
          if (!an.aUx(this.dCi.field_talker))
          {
            paramBundle = (ViewStub)findViewById(2131306449);
            if (paramBundle != null) {
              this.JZC = paramBundle.inflate();
            }
            this.JZB = ((ToolsBar)findViewById(2131305987));
            this.JZB.setVisibility(0);
          }
          if (this.JZB == null) {
            break;
          }
          this.JZB.b(0, new TextPreviewUI.6(this));
          this.JZB.b(1, new TextPreviewUI.7(this));
          this.JZB.b(2, new TextPreviewUI.8(this));
          break;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34951);
    super.onDestroy();
    bc.ajj().b(525, this);
    AppMethodBeat.o(34951);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34948);
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.e(false, true, true);
    AppMethodBeat.o(34948);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34947);
    super.onResume();
    com.tencent.mm.plugin.ball.f.f.e(true, true, true);
    if (this.JZr != null)
    {
      if (!this.JZr.LCs) {
        this.JZr.fRV();
      }
      if (!this.JZr.LCt) {
        this.JZr.fRQ();
      }
    }
    AppMethodBeat.o(34947);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(34952);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      switch (paramn.getType())
      {
      default: 
        AppMethodBeat.o(34952);
        return;
      }
      ae.i("MicroMsg.TextPreviewUI", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(getContext(), getContext().getResources().getString(2131760231), "", null);
      AppMethodBeat.o(34952);
      return;
    }
    if (paramn.getType() == 525)
    {
      ae.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bu.nullAsNil(paramString) });
      AppCompatActivity localAppCompatActivity = getContext();
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = getResources().getString(2131762409);
      }
      h.c(localAppCompatActivity, paramn, getContext().getResources().getString(2131762410), true);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(34952);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI
 * JD-Core Version:    0.7.0.1
 */