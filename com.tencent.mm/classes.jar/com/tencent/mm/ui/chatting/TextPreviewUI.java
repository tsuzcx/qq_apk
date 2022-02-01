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
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.widget.textview.a.a;

@com.tencent.mm.ui.base.a(3)
public class TextPreviewUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private boolean Dzu = false;
  private TextView HNW = null;
  private int HQJ;
  private com.tencent.mm.ui.widget.textview.a HQK;
  private com.tencent.mm.ui.widget.b.a HQL;
  private CharSequence HQM;
  private View HQN;
  private View HQO;
  private View HQP;
  private CustomScrollView HQQ;
  private final int HQR = 1;
  private final int HQS = 2;
  private boolean HQT = false;
  private ToolsBar HQU;
  private View HQV;
  private TextView Up = null;
  private int bottom = 0;
  private bo dpq;
  private final int nyc = 0;
  private CharSequence text = null;
  private Animation xEu;
  private Animation xEv;
  private int zl;
  
  private void by(bo parambo)
  {
    AppMethodBeat.i(34950);
    com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(getContext());
    localc.Ihv = new TextPreviewUI.4(this, localc, parambo);
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
    if (d.kZ(19)) {
      getWindow().setFlags(67109888, 67109888);
    }
    this.HQN = findViewById(2131305741);
    this.text = getIntent().getCharSequenceExtra("key_chat_text");
    this.HQJ = getIntent().getIntExtra("key_msg_type", 0);
    long l = getIntent().getLongExtra("Chat_Msg_Id", 0L);
    az.ayM();
    this.dpq = com.tencent.mm.model.c.awD().vP(l);
    this.Up = ((TextView)findViewById(2131300329));
    this.HNW = ((TextView)findViewById(2131300330));
    Object localObject = this.text;
    TextView localTextView = this.HNW;
    paramBundle = (Bundle)localObject;
    if ((localObject instanceof SpannableString))
    {
      localTextView.setText(((SpannableString)localObject).toString());
      k.m(localTextView, 1);
      paramBundle = localTextView.getText();
    }
    this.text = paramBundle;
    paramBundle = this.Up;
    localObject = com.tencent.mm.cf.g.eXw();
    getContext();
    paramBundle.setText(((com.tencent.mm.cf.g)localObject).b(this.text, this.Up.getTextSize()));
    this.HQO = findViewById(2131301274);
    this.HQP = this.HQO.findViewById(2131301241);
    this.HQQ = ((CustomScrollView)findViewById(2131300328));
    this.Up.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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
    this.xEv = AnimationUtils.loadAnimation(getContext(), 2130772108);
    this.xEu = AnimationUtils.loadAnimation(getContext(), 2130772106);
    this.HQL = new com.tencent.mm.ui.widget.b.a(getContext(), this.Up);
    this.HQL.JiS = true;
    this.HQL.JiR = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(34937);
        TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 7, 0);
        paramAnonymousContextMenu.clear();
        paramAnonymousContextMenu.add(0, 0, 0, TextPreviewUI.this.getResources().getString(2131755701));
        int i = bk.D(TextPreviewUI.b(TextPreviewUI.this));
        if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.gQ(TextPreviewUI.a(TextPreviewUI.this)).length())) {
          paramAnonymousContextMenu.add(1, 1, 0, TextPreviewUI.this.getResources().getString(2131761224));
        }
        paramAnonymousContextMenu.add(1, 2, 0, TextPreviewUI.this.getResources().getString(2131761223));
        AppMethodBeat.o(34937);
      }
    };
    this.HQL.ISv = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(34939);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(34939);
          return;
          ((ClipboardManager)ai.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.c(TextPreviewUI.this), TextPreviewUI.c(TextPreviewUI.this)));
          if (TextPreviewUI.d(TextPreviewUI.this) != null)
          {
            TextPreviewUI.d(TextPreviewUI.this).fwF();
            TextPreviewUI.d(TextPreviewUI.this).Jot = true;
            TextPreviewUI.d(TextPreviewUI.this).Jou = true;
            TextPreviewUI.d(TextPreviewUI.this).fwE();
          }
          paramAnonymousMenuItem = TextPreviewUI.b(TextPreviewUI.this);
          if (TextPreviewUI.c(TextPreviewUI.this) == null) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = TextPreviewUI.c(TextPreviewUI.this).length())
          {
            TextPreviewUI.b(paramAnonymousMenuItem, 8, paramAnonymousInt);
            Toast.makeText(TextPreviewUI.this.getContext(), 2131755702, 0).show();
            AppMethodBeat.o(34939);
            return;
          }
          if (TextPreviewUI.d(TextPreviewUI.this) != null)
          {
            TextPreviewUI.d(TextPreviewUI.this).fwE();
            TextPreviewUI.d(TextPreviewUI.this).fwI();
            TextPreviewUI.d(TextPreviewUI.this).kc(0, TextPreviewUI.a(TextPreviewUI.this).getText().length());
            TextPreviewUI.d(TextPreviewUI.this).Jot = false;
            TextPreviewUI.d(TextPreviewUI.this).Jou = false;
            TextPreviewUI.d(TextPreviewUI.this).fwH();
          }
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 10, 0);
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34938);
              if (TextPreviewUI.d(TextPreviewUI.this) != null) {
                TextPreviewUI.d(TextPreviewUI.this).fwM();
              }
              AppMethodBeat.o(34938);
            }
          }, 100L);
          AppMethodBeat.o(34939);
          return;
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 9, 0);
          TextPreviewUI.f(TextPreviewUI.this.getContext(), TextPreviewUI.c(TextPreviewUI.this));
        }
      }
    };
    if ((this.HQK == null) && (!bk.x(this.dpq)) && (!bk.y(this.dpq)))
    {
      paramBundle = new a.a(this.Up, this.HQL);
      paramBundle.Jok = 2131100846;
      paramBundle.Jol = 2131100195;
      this.HQK = paramBundle.fwN();
      this.HQK.Joc = new v()
      {
        public final void an(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(34940);
          TextPreviewUI.a(TextPreviewUI.this, paramAnonymousCharSequence);
          AppMethodBeat.o(34940);
        }
      };
    }
    this.HQN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34941);
        if ((TextPreviewUI.d(TextPreviewUI.this) != null) && ((!TextPreviewUI.d(TextPreviewUI.this).Jot) || (!TextPreviewUI.d(TextPreviewUI.this).Jou)))
        {
          TextPreviewUI.d(TextPreviewUI.this).fwF();
          TextPreviewUI.d(TextPreviewUI.this).Jot = true;
          TextPreviewUI.d(TextPreviewUI.this).Jou = true;
          TextPreviewUI.d(TextPreviewUI.this).fwE();
          AppMethodBeat.o(34941);
          return;
        }
        TextPreviewUI.this.finish();
        AppMethodBeat.o(34941);
      }
    });
    this.Up.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34942);
        if ((TextPreviewUI.d(TextPreviewUI.this) != null) && ((!TextPreviewUI.d(TextPreviewUI.this).Jot) || (!TextPreviewUI.d(TextPreviewUI.this).Jou)))
        {
          TextPreviewUI.d(TextPreviewUI.this).fwF();
          TextPreviewUI.d(TextPreviewUI.this).Jot = true;
          TextPreviewUI.d(TextPreviewUI.this).Jou = true;
          TextPreviewUI.d(TextPreviewUI.this).fwE();
          AppMethodBeat.o(34942);
          return;
        }
        TextPreviewUI.this.finish();
        AppMethodBeat.o(34942);
      }
    });
    if (!bs.isNullOrNil(bk.B(this.dpq)))
    {
      this.HQO.setVisibility(0);
      this.HQP.setOnClickListener(new TextPreviewUI.13(this));
    }
    label724:
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34944);
          TextPreviewUI.this.finish();
          AppMethodBeat.o(34944);
          return true;
        }
      });
      this.HQQ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(34945);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(34945);
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
      this.HQQ.setOnScrollChangeListener(new CustomScrollView.a()
      {
        public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(34930);
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
            AppMethodBeat.o(34930);
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
      az.agi().a(525, this);
      AppMethodBeat.o(34946);
      return;
      if ((!bk.x(this.dpq)) && (!bk.y(this.dpq)))
      {
        if (this.HQJ == 1) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label724;
          }
          paramBundle = (ViewStub)findViewById(2131306449);
          if (paramBundle != null) {
            this.HQV = paramBundle.inflate();
          }
          this.HQU = ((ToolsBar)findViewById(2131305987));
          this.HQU.setVisibility(0);
          if (this.HQU == null) {
            break;
          }
          this.HQU.b(0, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(34934);
              if (TextPreviewUI.b(TextPreviewUI.this) != null) {
                TextPreviewUI.f(TextPreviewUI.this.getContext(), TextPreviewUI.k(TextPreviewUI.this).toString());
              }
              AppMethodBeat.o(34934);
            }
          });
          this.HQU.b(1, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(34935);
              TextPreviewUI.l(TextPreviewUI.this);
              AppMethodBeat.o(34935);
            }
          });
          this.HQU.b(2, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(34936);
              TextPreviewUI.b(TextPreviewUI.this, TextPreviewUI.b(TextPreviewUI.this));
              AppMethodBeat.o(34936);
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
    az.agi().b(525, this);
    AppMethodBeat.o(34951);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34948);
    super.onPause();
    f.e(false, true, true);
    AppMethodBeat.o(34948);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34947);
    super.onResume();
    f.e(true, true, true);
    if (this.HQK != null)
    {
      if (!this.HQK.Jot) {
        this.HQK.fwM();
      }
      if (!this.HQK.Jou) {
        this.HQK.fwH();
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
      ac.i("MicroMsg.TextPreviewUI", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(getContext(), getContext().getResources().getString(2131760231), "", null);
      AppMethodBeat.o(34952);
      return;
    }
    if (paramn.getType() == 525)
    {
      ac.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bs.nullAsNil(paramString) });
      AppCompatActivity localAppCompatActivity = getContext();
      paramn = paramString;
      if (bs.isNullOrNil(paramString)) {
        paramn = getResources().getString(2131762409);
      }
      com.tencent.mm.ui.base.h.c(localAppCompatActivity, paramn, getContext().getResources().getString(2131762410), true);
      com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(795L, 4L, 1L, false);
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