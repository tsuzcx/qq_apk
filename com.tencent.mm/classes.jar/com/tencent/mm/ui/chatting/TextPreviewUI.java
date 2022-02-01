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
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.widget.textview.a.a;

@com.tencent.mm.ui.base.a(3)
public class TextPreviewUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private boolean Chd = false;
  private TextView Gof = null;
  private int GqR;
  private com.tencent.mm.ui.widget.textview.a GqS;
  private com.tencent.mm.ui.widget.b.a GqT;
  private CharSequence GqU;
  private View GqV;
  private View GqW;
  private View GqX;
  private CustomScrollView GqY;
  private final int GqZ = 1;
  private final int Gra = 2;
  private boolean Grb = false;
  private ToolsBar Grc;
  private View Grd;
  private TextView Tu = null;
  private int bottom = 0;
  private bl drF;
  private final int mVC = 0;
  private CharSequence text = null;
  private Animation wte;
  private Animation wtf;
  private int ym;
  
  private void bw(bl parambl)
  {
    AppMethodBeat.i(34950);
    com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(getContext());
    localc.GHz = new TextPreviewUI.4(this, localc, parambl);
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
    if (d.lf(19)) {
      getWindow().setFlags(67109888, 67109888);
    }
    this.GqV = findViewById(2131305741);
    this.text = getIntent().getCharSequenceExtra("key_chat_text");
    this.GqR = getIntent().getIntExtra("key_msg_type", 0);
    long l = getIntent().getLongExtra("Chat_Msg_Id", 0L);
    az.arV();
    this.drF = com.tencent.mm.model.c.apO().rm(l);
    this.Tu = ((TextView)findViewById(2131300329));
    this.Gof = ((TextView)findViewById(2131300330));
    Object localObject = this.text;
    TextView localTextView = this.Gof;
    paramBundle = (Bundle)localObject;
    if ((localObject instanceof SpannableString))
    {
      localTextView.setText(((SpannableString)localObject).toString());
      k.m(localTextView, 1);
      paramBundle = localTextView.getText();
    }
    this.text = paramBundle;
    paramBundle = this.Tu;
    localObject = com.tencent.mm.cg.g.eIa();
    getContext();
    paramBundle.setText(((com.tencent.mm.cg.g)localObject).b(this.text, this.Tu.getTextSize()));
    this.GqW = findViewById(2131301274);
    this.GqX = this.GqW.findViewById(2131301241);
    this.GqY = ((CustomScrollView)findViewById(2131300328));
    this.Tu.getViewTreeObserver().addOnPreDrawListener(new TextPreviewUI.1(this));
    this.wtf = AnimationUtils.loadAnimation(getContext(), 2130772108);
    this.wte = AnimationUtils.loadAnimation(getContext(), 2130772106);
    this.GqT = new com.tencent.mm.ui.widget.b.a(getContext(), this.Tu);
    this.GqT.HIv = true;
    this.GqT.HIu = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(34937);
        TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 7, 0);
        paramAnonymousContextMenu.clear();
        paramAnonymousContextMenu.add(0, 0, 0, TextPreviewUI.this.getResources().getString(2131755701));
        int i = bk.D(TextPreviewUI.b(TextPreviewUI.this));
        if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.gA(TextPreviewUI.a(TextPreviewUI.this)).length())) {
          paramAnonymousContextMenu.add(1, 1, 0, TextPreviewUI.this.getResources().getString(2131761224));
        }
        paramAnonymousContextMenu.add(1, 2, 0, TextPreviewUI.this.getResources().getString(2131761223));
        AppMethodBeat.o(34937);
      }
    };
    this.GqT.HrY = new n.d()
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
          ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.c(TextPreviewUI.this), TextPreviewUI.c(TextPreviewUI.this)));
          if (TextPreviewUI.d(TextPreviewUI.this) != null)
          {
            TextPreviewUI.d(TextPreviewUI.this).fgF();
            TextPreviewUI.d(TextPreviewUI.this).HNX = true;
            TextPreviewUI.d(TextPreviewUI.this).HNY = true;
            TextPreviewUI.d(TextPreviewUI.this).fgE();
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
            TextPreviewUI.d(TextPreviewUI.this).fgE();
            TextPreviewUI.d(TextPreviewUI.this).fgI();
            TextPreviewUI.d(TextPreviewUI.this).jQ(0, TextPreviewUI.a(TextPreviewUI.this).getText().length());
            TextPreviewUI.d(TextPreviewUI.this).HNX = false;
            TextPreviewUI.d(TextPreviewUI.this).HNY = false;
            TextPreviewUI.d(TextPreviewUI.this).fgH();
          }
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 10, 0);
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(34938);
              if (TextPreviewUI.d(TextPreviewUI.this) != null) {
                TextPreviewUI.d(TextPreviewUI.this).fgM();
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
    if ((this.GqS == null) && (!bk.x(this.drF)) && (!bk.y(this.drF)))
    {
      paramBundle = new a.a(this.Tu, this.GqT);
      paramBundle.HNO = 2131100846;
      paramBundle.HNP = 2131100195;
      this.GqS = paramBundle.fgN();
      this.GqS.HNG = new v()
      {
        public final void am(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(34940);
          TextPreviewUI.a(TextPreviewUI.this, paramAnonymousCharSequence);
          AppMethodBeat.o(34940);
        }
      };
    }
    this.GqV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34941);
        if ((TextPreviewUI.d(TextPreviewUI.this) != null) && ((!TextPreviewUI.d(TextPreviewUI.this).HNX) || (!TextPreviewUI.d(TextPreviewUI.this).HNY)))
        {
          TextPreviewUI.d(TextPreviewUI.this).fgF();
          TextPreviewUI.d(TextPreviewUI.this).HNX = true;
          TextPreviewUI.d(TextPreviewUI.this).HNY = true;
          TextPreviewUI.d(TextPreviewUI.this).fgE();
          AppMethodBeat.o(34941);
          return;
        }
        TextPreviewUI.this.finish();
        AppMethodBeat.o(34941);
      }
    });
    this.Tu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34942);
        if ((TextPreviewUI.d(TextPreviewUI.this) != null) && ((!TextPreviewUI.d(TextPreviewUI.this).HNX) || (!TextPreviewUI.d(TextPreviewUI.this).HNY)))
        {
          TextPreviewUI.d(TextPreviewUI.this).fgF();
          TextPreviewUI.d(TextPreviewUI.this).HNX = true;
          TextPreviewUI.d(TextPreviewUI.this).HNY = true;
          TextPreviewUI.d(TextPreviewUI.this).fgE();
          AppMethodBeat.o(34942);
          return;
        }
        TextPreviewUI.this.finish();
        AppMethodBeat.o(34942);
      }
    });
    if (!bt.isNullOrNil(bk.B(this.drF)))
    {
      this.GqW.setVisibility(0);
      this.GqX.setOnClickListener(new TextPreviewUI.13(this));
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
      this.GqY.setOnTouchListener(new View.OnTouchListener()
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
      this.GqY.setOnScrollChangeListener(new CustomScrollView.a()
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
      az.aeS().a(525, this);
      AppMethodBeat.o(34946);
      return;
      if ((!bk.x(this.drF)) && (!bk.y(this.drF)))
      {
        if (this.GqR == 1) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label724;
          }
          paramBundle = (ViewStub)findViewById(2131306449);
          if (paramBundle != null) {
            this.Grd = paramBundle.inflate();
          }
          this.Grc = ((ToolsBar)findViewById(2131305987));
          this.Grc.setVisibility(0);
          if (this.Grc == null) {
            break;
          }
          this.Grc.b(0, new View.OnClickListener()
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
          this.Grc.b(1, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(34935);
              TextPreviewUI.l(TextPreviewUI.this);
              AppMethodBeat.o(34935);
            }
          });
          this.Grc.b(2, new View.OnClickListener()
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
    az.aeS().b(525, this);
    AppMethodBeat.o(34951);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34948);
    super.onPause();
    f.d(false, true, true);
    AppMethodBeat.o(34948);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34947);
    super.onResume();
    f.d(true, true, true);
    if (this.GqS != null)
    {
      if (!this.GqS.HNX) {
        this.GqS.fgM();
      }
      if (!this.GqS.HNY) {
        this.GqS.fgH();
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
      ad.i("MicroMsg.TextPreviewUI", "set msg remind!");
      com.tencent.mm.ui.widget.snackbar.b.a(getContext(), getContext().getResources().getString(2131760231), "", null);
      AppMethodBeat.o(34952);
      return;
    }
    if (paramn.getType() == 525)
    {
      ad.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), bt.nullAsNil(paramString) });
      AppCompatActivity localAppCompatActivity = getContext();
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = getResources().getString(2131762409);
      }
      com.tencent.mm.ui.base.h.c(localAppCompatActivity, paramn, getContext().getResources().getString(2131762410), true);
      com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(795L, 4L, 1L, false);
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