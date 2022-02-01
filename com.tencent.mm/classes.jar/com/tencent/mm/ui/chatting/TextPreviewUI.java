package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ce.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.e;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.x;
import com.tencent.mm.ui.chatting.view.c.a;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@com.tencent.mm.ui.base.a(3)
public class TextPreviewUI
  extends MMActivity
  implements com.tencent.mm.ak.i
{
  private int Bj;
  private Animation Dof;
  private Animation Dog;
  private boolean KnW;
  private TextView PhQ;
  private int PkK;
  private com.tencent.mm.ui.widget.textview.a PkL;
  private CharSequence PkM;
  private View PkN;
  private View PkO;
  private View PkP;
  private CustomScrollView PkQ;
  private final int PkR;
  private final int PkS;
  private boolean PkT;
  private String PkU;
  private boolean PkV;
  boolean PkW;
  private ToolsBar PkX;
  private View PkY;
  private TextView Ws;
  private int bottom;
  private ca dTX;
  private final int pqh;
  private CharSequence text;
  private com.tencent.mm.ui.widget.b.a wnj;
  private com.tencent.mm.pluginsdk.ui.span.i ylW;
  
  public TextPreviewUI()
  {
    AppMethodBeat.i(232945);
    this.Ws = null;
    this.PhQ = null;
    this.text = null;
    this.pqh = 0;
    this.PkR = 1;
    this.PkS = 2;
    this.bottom = 0;
    this.KnW = false;
    this.PkT = false;
    this.PkV = false;
    this.ylW = new com.tencent.mm.pluginsdk.ui.span.i()
    {
      public final Object a(u paramAnonymousu)
      {
        AppMethodBeat.i(232925);
        TextPreviewUI.a(TextPreviewUI.this, true);
        AppMethodBeat.o(232925);
        return null;
      }
      
      public final Object b(u paramAnonymousu)
      {
        return null;
      }
    };
    this.PkW = false;
    AppMethodBeat.o(232945);
  }
  
  private void bQ(final ca paramca)
  {
    AppMethodBeat.i(34950);
    final com.tencent.mm.ui.chatting.view.c localc = new com.tencent.mm.ui.chatting.view.c(getContext());
    localc.PGz = new c.a()
    {
      public final void Nt(long paramAnonymousLong)
      {
        AppMethodBeat.i(232931);
        localc.hide();
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(795L, 1L, 1L, false);
        if (!NetUtil.isConnected(TextPreviewUI.this.getContext()))
        {
          com.tencent.mm.ui.base.h.c(TextPreviewUI.this.getContext(), TextPreviewUI.this.getString(2131763501), TextPreviewUI.this.getString(2131764476), true);
          AppMethodBeat.o(232931);
          return;
        }
        dmn localdmn = new dmn();
        localdmn.rBX = ((int)(paramAnonymousLong / 1000L));
        localdmn.oUv = 1;
        localdmn.MJT = 1;
        for (;;)
        {
          try
          {
            crk localcrk = new crk();
            localcrk.UserName = paramca.field_talker;
            localcrk.Brn = paramca.field_msgSvrId;
            localTextPreviewUI = TextPreviewUI.this;
            localObject2 = paramca;
            if ((!((ca)localObject2).isText()) && (!((ca)localObject2).gDq())) {
              continue;
            }
            localObject2 = ((eo)localObject2).field_content;
            i = bp.Kp((String)localObject2);
            localObject1 = localObject2;
            if (i != -1) {
              localObject1 = ((String)localObject2).substring(i + 1).trim();
            }
            localcrk.Title = ((String)localObject1);
            localdmn.Lqr = new com.tencent.mm.bw.b(localcrk.toByteArray());
          }
          catch (IOException localIOException)
          {
            TextPreviewUI localTextPreviewUI;
            Object localObject2;
            int i;
            Object localObject1;
            Log.e("MicroMsg.TextPreviewUI", "[onOk] %s", new Object[] { localIOException.toString() });
            continue;
          }
          localObject1 = new com.tencent.mm.modelsimple.z(1, localdmn);
          bg.azz().a((q)localObject1, 0);
          AppMethodBeat.o(232931);
          return;
          if ((((ca)localObject2).gDx()) || (((ca)localObject2).gDy()))
          {
            localObject1 = ((eo)localObject2).field_content;
            i = ((eo)localObject2).field_content.indexOf(':');
            if (i != -1) {
              localObject1 = ((eo)localObject2).field_content.substring(i + 1);
            }
            if (localObject1 != null)
            {
              localObject1 = k.b.aD((String)localObject1, ((eo)localObject2).field_reserved);
              if ((localObject1 != null) && ((((k.b)localObject1).type == 53) || (((k.b)localObject1).type == 57)))
              {
                localObject1 = ((k.b)localObject1).title;
                continue;
              }
            }
          }
          localObject1 = AllRemindMsgUI.a(localTextPreviewUI.getContext(), ((ca)localObject2).getType(), ((eo)localObject2).field_content, ((eo)localObject2).field_isSend);
          Log.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", new Object[] { Long.valueOf(((eo)localObject2).field_msgId), Integer.valueOf(((ca)localObject2).getType()), localObject1 });
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(232932);
        localc.hide();
        AppMethodBeat.o(232932);
      }
    };
    localc.show();
    AppMethodBeat.o(34950);
  }
  
  private static boolean bR(ca paramca)
  {
    AppMethodBeat.i(232946);
    if ((ab.Eq(paramca.field_talker)) || (ab.Iy(paramca.field_talker)))
    {
      AppMethodBeat.o(232946);
      return true;
    }
    AppMethodBeat.o(232946);
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493567;
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
    if (d.oD(19)) {
      getWindow().setFlags(67109888, 67109888);
    }
    this.PkN = findViewById(2131309008);
    this.text = getIntent().getCharSequenceExtra("key_chat_text");
    this.PkK = getIntent().getIntExtra("key_msg_type", 0);
    long l = getIntent().getLongExtra("Chat_Msg_Id", 0L);
    bg.aVF();
    this.dTX = com.tencent.mm.model.c.aSQ().Hb(l);
    this.Ws = ((TextView)findViewById(2131301837));
    this.PhQ = ((TextView)findViewById(2131301838));
    Object localObject = this.text;
    paramBundle = this.PhQ;
    localObject = ((SpannableString)new SpannableString((CharSequence)localObject)).toString();
    Bundle localBundle = com.tencent.mm.pluginsdk.ui.span.t.Ao(getIntent().getBooleanExtra("is_group_chat", false));
    paramBundle.setText(l.a(paramBundle.getContext(), (CharSequence)localObject, (int)paramBundle.getTextSize(), 1, localBundle, null, 1, l.Krf));
    this.text = paramBundle.getText();
    this.Ws.setText(g.gxZ().a(getContext(), this.text, this.Ws.getTextSize()));
    this.PkU = com.tencent.mm.model.z.aTY();
    paramBundle = com.tencent.mm.ui.chatting.l.a.PEV;
    com.tencent.mm.ui.chatting.l.a.a.a(this.Ws, this.dTX, bR(this.dTX), this.PkU);
    this.PkO = findViewById(2131302971);
    this.PkP = this.PkO.findViewById(2131302934);
    this.PkQ = ((CustomScrollView)findViewById(2131301836));
    this.Ws.setMovementMethod(LinkMovementMethod.getInstance());
    this.Ws.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(232936);
        TextPreviewUI.a(TextPreviewUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
        if (TextPreviewUI.a(TextPreviewUI.this).getLineCount() == 1) {
          TextPreviewUI.a(TextPreviewUI.this).setGravity(1);
        }
        AppMethodBeat.o(232936);
        return false;
      }
    });
    this.Dog = AnimationUtils.loadAnimation(getContext(), 2130772132);
    this.Dof = AnimationUtils.loadAnimation(getContext(), 2130772130);
    this.wnj = new com.tencent.mm.ui.widget.b.a(getContext(), this.Ws);
    this.wnj.QSv = true;
    this.wnj.QSy = false;
    this.wnj.QSt = new o.e()
    {
      public final void a(m paramAnonymousm, View paramAnonymousView)
      {
        AppMethodBeat.i(232937);
        TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 7, 0);
        paramAnonymousm.clear();
        paramAnonymousm.b(0, TextPreviewUI.this.getResources().getString(2131755772), 2131690525);
        int i = br.O(TextPreviewUI.b(TextPreviewUI.this));
        if ((i <= 0) || (i >= com.tencent.mm.ui.widget.textview.b.hB(TextPreviewUI.a(TextPreviewUI.this)).length())) {
          paramAnonymousm.b(1, TextPreviewUI.this.getResources().getString(2131763038), 2131690480);
        }
        paramAnonymousm.b(2, TextPreviewUI.this.getResources().getString(2131763036), 2131690674);
        AppMethodBeat.o(232937);
      }
    };
    this.wnj.QSs = new View.OnCreateContextMenuListener()
    {
      public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo) {}
    };
    this.wnj.HLY = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(232939);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(232939);
          return;
          ClipboardHelper.setText(MMApplicationContext.getContext(), TextPreviewUI.c(TextPreviewUI.this), TextPreviewUI.c(TextPreviewUI.this));
          if (TextPreviewUI.d(TextPreviewUI.this) != null)
          {
            TextPreviewUI.d(TextPreviewUI.this).hbA();
            TextPreviewUI.d(TextPreviewUI.this).QXW = true;
            TextPreviewUI.d(TextPreviewUI.this).QXX = true;
            TextPreviewUI.d(TextPreviewUI.this).hbz();
          }
          paramAnonymousMenuItem = TextPreviewUI.b(TextPreviewUI.this);
          if (TextPreviewUI.c(TextPreviewUI.this) == null) {}
          for (paramAnonymousInt = 0;; paramAnonymousInt = TextPreviewUI.c(TextPreviewUI.this).length())
          {
            TextPreviewUI.b(paramAnonymousMenuItem, 8, paramAnonymousInt);
            Toast.makeText(TextPreviewUI.this.getContext(), 2131755773, 0).show();
            AppMethodBeat.o(232939);
            return;
          }
          if (TextPreviewUI.d(TextPreviewUI.this) != null)
          {
            TextPreviewUI.d(TextPreviewUI.this).hbz();
            TextPreviewUI.d(TextPreviewUI.this).hcR();
            TextPreviewUI.d(TextPreviewUI.this).lE(0, TextPreviewUI.a(TextPreviewUI.this).getText().length());
            TextPreviewUI.d(TextPreviewUI.this).QXW = false;
            TextPreviewUI.d(TextPreviewUI.this).QXX = false;
            TextPreviewUI.d(TextPreviewUI.this).hcQ();
          }
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 10, 0);
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(232938);
              if (TextPreviewUI.d(TextPreviewUI.this) != null) {
                TextPreviewUI.d(TextPreviewUI.this).hcV();
              }
              AppMethodBeat.o(232938);
            }
          }, 100L);
          AppMethodBeat.o(232939);
          return;
          TextPreviewUI.b(TextPreviewUI.b(TextPreviewUI.this), 9, 0);
          TextPreviewUI.e(TextPreviewUI.this.getContext(), TextPreviewUI.c(TextPreviewUI.this));
        }
      }
    };
    paramBundle = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(232941);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          TextPreviewUI.this.PkW = true;
        }
        if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 3) || (paramAnonymousMotionEvent.getAction() == 4))
        {
          TextPreviewUI.this.PkW = false;
          if (TextPreviewUI.a(TextPreviewUI.this).getMovementMethod() == null) {
            TextPreviewUI.a(TextPreviewUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(232940);
                TextPreviewUI.a(TextPreviewUI.this).setMovementMethod(LinkMovementMethod.getInstance());
                AppMethodBeat.o(232940);
              }
            });
          }
        }
        AppMethodBeat.o(232941);
        return false;
      }
    };
    if ((this.PkL == null) && (!br.B(this.dTX)) && (!br.J(this.dTX)))
    {
      paramBundle = new com.tencent.mm.ui.widget.textview.a.a(this.Ws, this.wnj, null, null, paramBundle);
      paramBundle.QPi = 2131101045;
      paramBundle.QPj = 2131100228;
      paramBundle.QYh = at.fromDPToPix(getContext(), 20);
      this.PkL = paramBundle.hcW();
      this.PkL.QXO = new x()
      {
        public final void as(CharSequence paramAnonymousCharSequence)
        {
          AppMethodBeat.i(232942);
          TextPreviewUI.a(TextPreviewUI.this, paramAnonymousCharSequence);
          if (TextPreviewUI.this.PkW) {
            TextPreviewUI.a(TextPreviewUI.this).setMovementMethod(null);
          }
          AppMethodBeat.o(232942);
        }
      };
    }
    this.PkN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232943);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((TextPreviewUI.d(TextPreviewUI.this) != null) && ((!TextPreviewUI.d(TextPreviewUI.this).QXW) || (!TextPreviewUI.d(TextPreviewUI.this).QXX)))
        {
          TextPreviewUI.d(TextPreviewUI.this).hbA();
          TextPreviewUI.d(TextPreviewUI.this).QXW = true;
          TextPreviewUI.d(TextPreviewUI.this).QXX = true;
          TextPreviewUI.d(TextPreviewUI.this).hbz();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(232943);
          return;
          TextPreviewUI.this.finish();
        }
      }
    });
    this.Ws.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(232944);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (TextPreviewUI.d(TextPreviewUI.this) != null) {
          if ((TextPreviewUI.d(TextPreviewUI.this).QXW) && (TextPreviewUI.d(TextPreviewUI.this).QXX))
          {
            if (TextPreviewUI.e(TextPreviewUI.this))
            {
              TextPreviewUI.a(TextPreviewUI.this, false);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(232944);
              return;
            }
            TextPreviewUI.this.finish();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(232944);
          return;
          TextPreviewUI.d(TextPreviewUI.this).hbA();
          TextPreviewUI.d(TextPreviewUI.this).QXW = true;
          TextPreviewUI.d(TextPreviewUI.this).QXX = true;
          TextPreviewUI.d(TextPreviewUI.this).hbz();
          continue;
          if (TextPreviewUI.e(TextPreviewUI.this))
          {
            TextPreviewUI.a(TextPreviewUI.this, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/TextPreviewUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(232944);
            return;
          }
          TextPreviewUI.this.finish();
        }
      }
    });
    if (!Util.isNullOrNil(br.M(this.dTX)))
    {
      this.PkO.setVisibility(0);
      this.PkP.setOnClickListener(new TextPreviewUI.2(this));
    }
    label845:
    for (;;)
    {
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(232927);
          TextPreviewUI.this.finish();
          AppMethodBeat.o(232927);
          return true;
        }
      });
      this.PkQ.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(232928);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(232928);
            return false;
            TextPreviewUI.b(TextPreviewUI.this, true);
            continue;
            if (!TextPreviewUI.f(TextPreviewUI.this))
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
      this.PkQ.setOnScrollChangeListener(new CustomScrollView.a()
      {
        public final void a(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(232929);
          TextPreviewUI.g(TextPreviewUI.this);
          int i;
          if (paramAnonymousScrollView.getChildAt(0).getMeasuredHeight() == paramAnonymousScrollView.getHeight() + paramAnonymousScrollView.getScrollY())
          {
            i = 1;
            if (i != 0) {
              TextPreviewUI.a(TextPreviewUI.this, paramAnonymousScrollView.getScrollY());
            }
            if ((paramAnonymousScrollView.getScrollY() > 0) && ((paramAnonymousScrollView.getScrollY() < TextPreviewUI.h(TextPreviewUI.this) - 10) || (TextPreviewUI.h(TextPreviewUI.this) <= 0))) {
              break label117;
            }
            TextPreviewUI.i(TextPreviewUI.this);
          }
          label117:
          while (!TextPreviewUI.j(TextPreviewUI.this))
          {
            TextPreviewUI.b(TextPreviewUI.this, paramAnonymousInt1 - paramAnonymousInt2);
            AppMethodBeat.o(232929);
            return;
            i = 0;
            break;
          }
          if (paramAnonymousInt2 > paramAnonymousInt1) {
            TextPreviewUI.i(TextPreviewUI.this);
          }
          for (;;)
          {
            TextPreviewUI.b(TextPreviewUI.this, false);
            break;
            if (paramAnonymousInt2 < paramAnonymousInt1) {
              TextPreviewUI.k(TextPreviewUI.this);
            }
          }
        }
      });
      bg.azz().a(525, this);
      AppMethodBeat.o(34946);
      return;
      if ((!br.B(this.dTX)) && (!br.J(this.dTX)))
      {
        if (this.PkK == 1) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label845;
          }
          if (!as.bjw(this.dTX.field_talker))
          {
            paramBundle = (ViewStub)findViewById(2131309891);
            if (paramBundle != null) {
              this.PkY = paramBundle.inflate();
            }
            this.PkX = ((ToolsBar)findViewById(2131309292));
            this.PkX.setVisibility(0);
          }
          if (this.PkX == null) {
            break;
          }
          this.PkX.b(0, new TextPreviewUI.8(this));
          this.PkX.b(1, new TextPreviewUI.9(this));
          this.PkX.b(2, new TextPreviewUI.10(this));
          break;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34951);
    super.onDestroy();
    bg.azz().b(525, this);
    AppMethodBeat.o(34951);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34948);
    super.onPause();
    f.e(false, true, true);
    l.b(this.ylW);
    AppMethodBeat.o(34948);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34947);
    super.onResume();
    f.e(true, true, true);
    if (this.PkL != null)
    {
      if (!this.PkL.QXW) {
        this.PkL.hcV();
      }
      if (!this.PkL.QXX) {
        this.PkL.hcQ();
      }
    }
    l.a(this.ylW);
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
      com.tencent.mm.ui.widget.snackbar.b.a(getContext(), getContext().getResources().getString(2131761617), "", null);
      AppMethodBeat.o(34952);
      return;
    }
    if (paramq.getType() == 525)
    {
      Log.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(525), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Util.nullAsNil(paramString) });
      AppCompatActivity localAppCompatActivity = getContext();
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = getResources().getString(2131764475);
      }
      com.tencent.mm.ui.base.h.c(localAppCompatActivity, paramq, getContext().getResources().getString(2131764476), true);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(795L, 4L, 1L, false);
    }
    AppMethodBeat.o(34952);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.TextPreviewUI
 * JD-Core Version:    0.7.0.1
 */