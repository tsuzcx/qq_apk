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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.mm.ui.widget.textview.a.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class TextPreviewUI
  extends MMActivity
  implements com.tencent.mm.al.f
{
  private int Bd;
  private boolean FeD = false;
  private TextView JBL = null;
  private com.tencent.mm.ui.widget.textview.a JEA;
  private com.tencent.mm.ui.widget.b.a JEB;
  private CharSequence JEC;
  private View JED;
  private View JEE;
  private View JEF;
  private CustomScrollView JEG;
  private final int JEH = 1;
  private final int JEI = 2;
  private boolean JEJ = false;
  private ToolsBar JEK;
  private View JEL;
  private int JEz;
  private TextView Wf = null;
  private int bottom = 0;
  private bu dBd;
  private final int nZA = 0;
  private CharSequence text = null;
  private Animation yTe;
  private Animation yTf;
  
  private void bC(final bu parambu)
  {
    AppMethodBeat.i(34950);
    final com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(getContext());
    localc.JXQ = new c.a()
    {
      public final void DQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(193878);
        localc.hide();
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(795L, 1L, 1L, false);
        if (!NetUtil.isConnected(TextPreviewUI.this.getContext()))
        {
          h.c(TextPreviewUI.this.getContext(), TextPreviewUI.this.getString(2131761535), TextPreviewUI.this.getString(2131762410), true);
          AppMethodBeat.o(193878);
          return;
        }
        ctd localctd = new ctd();
        localctd.qex = ((int)(paramAnonymousLong / 1000L));
        localctd.nEf = 1;
        localctd.HfH = 1;
        for (;;)
        {
          try
          {
            cbo localcbo = new cbo();
            localcbo.nDo = parambu.field_talker;
            localcbo.xbt = parambu.field_msgSvrId;
            localTextPreviewUI = TextPreviewUI.this;
            localObject2 = parambu;
            if ((!((bu)localObject2).isText()) && (!((bu)localObject2).frJ())) {
              continue;
            }
            localObject2 = ((ei)localObject2).field_content;
            i = bj.Bh((String)localObject2);
            localObject1 = localObject2;
            if (i != -1) {
              localObject1 = ((String)localObject2).substring(i + 1).trim();
            }
            localcbo.Title = ((String)localObject1);
            localctd.Gcf = new com.tencent.mm.bx.b(localcbo.toByteArray());
          }
          catch (IOException localIOException)
          {
            TextPreviewUI localTextPreviewUI;
            Object localObject2;
            int i;
            Object localObject1;
            ad.e("MicroMsg.TextPreviewUI", "[onOk] %s", new Object[] { localIOException.toString() });
            continue;
          }
          localObject1 = new y(1, localctd);
          ba.aiU().a((n)localObject1, 0);
          AppMethodBeat.o(193878);
          return;
          if ((((bu)localObject2).frQ()) || (((bu)localObject2).frR()))
          {
            localObject1 = ((ei)localObject2).field_content;
            i = ((ei)localObject2).field_content.indexOf(':');
            if (i != -1) {
              localObject1 = ((ei)localObject2).field_content.substring(i + 1);
            }
            if (localObject1 != null)
            {
              localObject1 = k.b.aA((String)localObject1, ((ei)localObject2).field_reserved);
              if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
              {
                localObject1 = ((k.b)localObject1).title;
                continue;
              }
            }
          }
          localObject1 = AllRemindMsgUI.a(localTextPreviewUI.getContext(), ((bu)localObject2).getType(), ((ei)localObject2).field_content, ((ei)localObject2).field_isSend);
          ad.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[] { Long.valueOf(((ei)localObject2).field_msgId), Integer.valueOf(((bu)localObject2).getType()), localObject1 });
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(193879);
        localc.hide();
        AppMethodBeat.o(193879);
      }
    };
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
    if (d.ly(19)) {
      getWindow().setFlags(67109888, 67109888);
    }
    this.JED = findViewById(2131305741);
    this.text = getIntent().getCharSequenceExtra("key_chat_text");
    this.JEz = getIntent().getIntExtra("key_msg_type", 0);
    long l = getIntent().getLongExtra("Chat_Msg_Id", 0L);
    ba.aBQ();
    this.dBd = com.tencent.mm.model.c.azs().xY(l);
    this.Wf = ((TextView)findViewById(2131300329));
    this.JBL = ((TextView)findViewById(2131300330));
    Object localObject = this.text;
    TextView localTextView = this.JBL;
    paramBundle = (Bundle)localObject;
    if ((localObject instanceof SpannableString))
    {
      localTextView.setText(((SpannableString)localObject).toString());
      k.n(localTextView, 1);
      paramBundle = localTextView.getText();
    }
    this.text = paramBundle;
    paramBundle = this.Wf;
    localObject = com.tencent.mm.cf.g.fng();
    getContext();
    paramBundle.setText(((com.tencent.mm.cf.g)localObject).b(this.text, this.Wf.getTextSize()));
    this.JEE = findViewById(2131301274);
    this.JEF = this.JEE.findViewById(2131301241);
    this.JEG = ((CustomScrollView)findViewById(2131300328));
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
    this.yTf = AnimationUtils.loadAnimation(getContext(), 2130772108);
    this.yTe = AnimationUtils.loadAnimation(getContext(), 2130772106);
    this.JEB = new com.tencent.mm.ui.widget.b.a(getContext(), this.Wf);
    this.JEB.Lal = true;
    this.JEB.Lao = false;
    this.JEB.Laj = new n.c()
    {
      public final void a(l paramAnonymousl, View paramAnonymousView)
      {
        AppMethodBeat.i(193881);
        TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 7, 0);
        paramAnonymousl.clear();
        paramAnonymousl.a(0, TextPreviewUI.this.getResources().getString(2131755701), 2131690381);
        int i = bl.F(TextPreviewUI.b(TextPreviewUI.this));
        if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.hh(TextPreviewUI.a(TextPreviewUI.this)).length())) {
          paramAnonymousl.a(1, TextPreviewUI.this.getResources().getString(2131761224), 2131691572);
        }
        paramAnonymousl.a(2, TextPreviewUI.this.getResources().getString(2131761223), 2131690478);
        AppMethodBeat.o(193881);
      }
    };
    this.JEB.Lai = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo) {}
    };
    this.JEB.KJz = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(193883);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(193883);
          return;
          ((ClipboardManager)aj.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.c(TextPreviewUI.this), TextPreviewUI.c(TextPreviewUI.this)));
          if (TextPreviewUI.d(TextPreviewUI.this) != null)
          {
            TextPreviewUI.d(TextPreviewUI.this).fNt();
            TextPreviewUI.d(TextPreviewUI.this).LfQ = true;
            TextPreviewUI.d(TextPreviewUI.this).LfR = true;
            TextPreviewUI.d(TextPreviewUI.this).fNs();
          }
          paramAnonymousMenuItem = TextPreviewUI.b(TextPreviewUI.this);
          if (TextPreviewUI.c(TextPreviewUI.this) == null) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = TextPreviewUI.c(TextPreviewUI.this).length())
          {
            TextPreviewUI.b(paramAnonymousMenuItem, 8, paramAnonymousInt);
            Toast.makeText(TextPreviewUI.this.getContext(), 2131755702, 0).show();
            AppMethodBeat.o(193883);
            return;
          }
          if (TextPreviewUI.d(TextPreviewUI.this) != null)
          {
            TextPreviewUI.d(TextPreviewUI.this).fNs();
            TextPreviewUI.d(TextPreviewUI.this).fNw();
            TextPreviewUI.d(TextPreviewUI.this).kp(0, TextPreviewUI.a(TextPreviewUI.this).getText().length());
            TextPreviewUI.d(TextPreviewUI.this).LfQ = false;
            TextPreviewUI.d(TextPreviewUI.this).LfR = false;
            TextPreviewUI.d(TextPreviewUI.this).fNv();
          }
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 10, 0);
          com.tencent.mm.sdk.platformtools.aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193882);
              if (TextPreviewUI.d(TextPreviewUI.this) != null) {
                TextPreviewUI.d(TextPreviewUI.this).fNA();
              }
              AppMethodBeat.o(193882);
            }
          }, 100L);
          AppMethodBeat.o(193883);
          return;
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 9, 0);
          TextPreviewUI.e(TextPreviewUI.this.getContext(), TextPreviewUI.c(TextPreviewUI.this));
        }
      }
    };
    if ((this.JEA == null) && (!bl.z(this.dBd)) && (!bl.A(this.dBd)))
    {
      paramBundle = new a.a(this.Wf, this.JEB);
      paramBundle.LfH = 2131100846;
      paramBundle.LfI = 2131100195;
      paramBundle.Lgc = com.tencent.mm.ui.aq.fromDPToPix(getContext(), 20);
      this.JEA = paramBundle.fNB();
      this.JEA.Lfz = new v()
      {
        public final void an(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(193884);
          TextPreviewUI.a(TextPreviewUI.this, paramAnonymousCharSequence);
          AppMethodBeat.o(193884);
        }
      };
    }
    this.JED.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34942);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((TextPreviewUI.d(TextPreviewUI.this) != null) && ((!TextPreviewUI.d(TextPreviewUI.this).LfQ) || (!TextPreviewUI.d(TextPreviewUI.this).LfR)))
        {
          TextPreviewUI.d(TextPreviewUI.this).fNt();
          TextPreviewUI.d(TextPreviewUI.this).LfQ = true;
          TextPreviewUI.d(TextPreviewUI.this).LfR = true;
          TextPreviewUI.d(TextPreviewUI.this).fNs();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((TextPreviewUI.d(TextPreviewUI.this) != null) && ((!TextPreviewUI.d(TextPreviewUI.this).LfQ) || (!TextPreviewUI.d(TextPreviewUI.this).LfR)))
        {
          TextPreviewUI.d(TextPreviewUI.this).fNt();
          TextPreviewUI.d(TextPreviewUI.this).LfQ = true;
          TextPreviewUI.d(TextPreviewUI.this).LfR = true;
          TextPreviewUI.d(TextPreviewUI.this).fNs();
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
    if (!bt.isNullOrNil(bl.D(this.dBd)))
    {
      this.JEE.setVisibility(0);
      this.JEF.setOnClickListener(new TextPreviewUI.15(this));
    }
    label773:
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(193886);
          TextPreviewUI.this.finish();
          AppMethodBeat.o(193886);
          return true;
        }
      });
      this.JEG.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(193875);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/TextPreviewUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(193875);
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
      this.JEG.setOnScrollChangeListener(new CustomScrollView.a()
      {
        public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(193876);
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
            AppMethodBeat.o(193876);
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
      ba.aiU().a(525, this);
      AppMethodBeat.o(34946);
      return;
      if ((!bl.z(this.dBd)) && (!bl.A(this.dBd)))
      {
        if (this.JEz == 1) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label773;
          }
          if (!am.ail(this.dBd.field_talker))
          {
            paramBundle = (ViewStub)findViewById(2131306449);
            if (paramBundle != null) {
              this.JEL = paramBundle.inflate();
            }
            this.JEK = ((ToolsBar)findViewById(2131305987));
            this.JEK.setVisibility(0);
          }
          if (this.JEK == null) {
            break;
          }
          this.JEK.b(0, new TextPreviewUI.6(this));
          this.JEK.b(1, new TextPreviewUI.7(this));
          this.JEK.b(2, new TextPreviewUI.8(this));
          break;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34951);
    super.onDestroy();
    ba.aiU().b(525, this);
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
    if (this.JEA != null)
    {
      if (!this.JEA.LfQ) {
        this.JEA.fNA();
      }
      if (!this.JEA.LfR) {
        this.JEA.fNv();
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
      h.c(localAppCompatActivity, paramn, getContext().getResources().getString(2131762410), true);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(34952);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI
 * JD-Core Version:    0.7.0.1
 */