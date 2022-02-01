package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.am.f;
import com.tencent.mm.am.q;
import com.tencent.mm.bl.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.w;
import java.util.List;

public final class l
  extends RelativeLayout
{
  public static Boolean Xss = Boolean.TRUE;
  private final MTimerHandler WFA;
  private View Xst;
  private MStorage.IOnStorageChange Xsu;
  private boolean Xsv;
  private Context context;
  private View fyN;
  private boolean isVisible;
  
  public l(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(37837);
    this.context = null;
    this.fyN = null;
    this.Xst = null;
    this.isVisible = true;
    this.WFA = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(37831);
        Log.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
        l.hUI();
        l.a(l.this);
        AppMethodBeat.o(37831);
        return false;
      }
    }, true);
    this.Xsu = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(37832);
        Log.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
        if (!l.b(l.this).stopped()) {
          l.b(l.this).stopTimer();
        }
        paramAnonymousString = l.b(l.this);
        if (l.c(l.this)) {}
        for (long l = 500L;; l = 1000L)
        {
          paramAnonymousString.startTimer(l);
          AppMethodBeat.o(37832);
          return;
        }
      }
    };
    this.Xsv = false;
    this.context = paramContext;
    d.bqc().add(this.Xsu);
    hUG();
    init();
    AppMethodBeat.o(37837);
  }
  
  private void a(bl parambl)
  {
    AppMethodBeat.i(37840);
    if (this.context == null)
    {
      Log.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
      AppMethodBeat.o(37840);
      return;
    }
    TextView localTextView;
    Object localObject;
    boolean bool;
    if (com.tencent.mm.ci.a.ko(this.context))
    {
      this.fyN = View.inflate(this.context, R.i.ehl, this);
      ((TextView)this.fyN.findViewById(R.h.dHz)).setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.context, parambl.field_displayName));
      localTextView = (TextView)this.fyN.findViewById(R.h.dHy);
      localObject = d.bqb().aOw(parambl.field_talker);
      Context localContext = this.context;
      int i = ((bn)localObject).field_type;
      int j = parambl.field_addScene;
      String str = ((bn)localObject).field_msgContent;
      if (((bn)localObject).hzg()) {
        break label246;
      }
      bool = true;
      label139:
      localObject = com.tencent.mm.pluginsdk.ui.preference.b.a(localContext, i, j, str, bool);
      if (!Util.isNullOrNil((String)localObject)) {
        break label252;
      }
      localTextView.setVisibility(8);
    }
    for (;;)
    {
      this.Xst = this.fyN.findViewById(R.h.dHl);
      this.fyN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37835);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/FMessageContactView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
          bh.beI();
          com.tencent.mm.model.c.aHp().i(143618, Integer.valueOf(0));
          com.tencent.mm.by.c.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37835);
        }
      });
      a.b.c((ImageView)((MaskLayout)this.fyN.findViewById(R.h.dHg)).getContentView(), parambl.field_talker);
      AppMethodBeat.o(37840);
      return;
      this.fyN = View.inflate(this.context, R.i.ehk, this);
      break;
      label246:
      bool = false;
      break label139;
      label252:
      localTextView.setText((CharSequence)localObject);
    }
  }
  
  private void hUF()
  {
    AppMethodBeat.i(37839);
    if (this.context == null)
    {
      Log.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
      AppMethodBeat.o(37839);
      return;
    }
    this.fyN = View.inflate(this.context, R.i.ehi, this);
    this.Xst = this.fyN.findViewById(R.h.dHw);
    Object localObject = this.Xst.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = ((int)(com.tencent.mm.ci.a.aZ(this.context, R.f.ContactListHeight) * com.tencent.mm.ci.a.kn(this.context)));
    this.Xst.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.fyN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37834);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/FMessageContactView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
        com.tencent.mm.by.c.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37834);
      }
    });
    localObject = (MaskLayout)this.fyN.findViewById(R.h.dHg);
    q.bhz();
    Bitmap localBitmap = f.TK("fmessage");
    ((ImageView)((MaskLayout)localObject).getContentView()).setImageBitmap(localBitmap);
    AppMethodBeat.o(37839);
  }
  
  private static void hUG()
  {
    AppMethodBeat.i(37843);
    int i = d.bqc().hze();
    Log.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      bh.beI();
      com.tencent.mm.model.c.aHp().i(143618, Integer.valueOf(i));
    }
    AppMethodBeat.o(37843);
  }
  
  public static void hUH()
  {
    AppMethodBeat.i(37844);
    bh.beI();
    if (com.tencent.mm.model.c.aGK())
    {
      bh.beI();
      if (com.tencent.mm.model.c.aHp().getInt(143618, 0) > 0) {
        ab.aN("fmessage", 2);
      }
    }
    bh.beI();
    com.tencent.mm.model.c.aHp().i(143618, Integer.valueOf(0));
    AppMethodBeat.o(37844);
  }
  
  private void init()
  {
    AppMethodBeat.i(37838);
    Object localObject = d.bqc().hzc();
    int i = ((List)localObject).size();
    Log.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", new Object[] { Integer.valueOf(i) });
    removeAllViews();
    if (i <= 0)
    {
      hUF();
      localObject = this.fyN.findViewById(R.h.dHl);
      if (localObject != null) {
        if (!this.isVisible) {
          break label199;
        }
      }
    }
    label199:
    for (i = 0;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      this.Xst.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(37833);
          if ((l.d(l.this) instanceof MMActivity)) {
            ((MMActivity)l.d(l.this)).hideVKB();
          }
          AppMethodBeat.o(37833);
          return false;
        }
      });
      i = d.bqc().hze();
      Log.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", new Object[] { Integer.valueOf(i) });
      localObject = (TextView)this.fyN.findViewById(R.h.dHu);
      ((TextView)localObject).setBackgroundResource(w.lE(this.context));
      if (i > 0) {
        break label205;
      }
      ((TextView)localObject).setVisibility(8);
      Xss = Boolean.FALSE;
      AppMethodBeat.o(37838);
      return;
      if (i == 1)
      {
        a((bl)((List)localObject).get(0));
        break;
      }
      kC((List)localObject);
      break;
    }
    label205:
    ((TextView)localObject).setVisibility(0);
    Xss = Boolean.TRUE;
    if (i > 99)
    {
      ((TextView)localObject).setText("");
      ((TextView)localObject).setBackgroundResource(R.k.badge_count_more);
      AppMethodBeat.o(37838);
      return;
    }
    ((TextView)localObject).setText(String.valueOf(i));
    ((TextView)localObject).setBackgroundResource(w.bj(this.context, i));
    AppMethodBeat.o(37838);
  }
  
  private void kC(List<bl> paramList)
  {
    AppMethodBeat.i(37841);
    if (this.context == null)
    {
      Log.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
      AppMethodBeat.o(37841);
      return;
    }
    this.fyN = View.inflate(this.context, R.i.ehj, this);
    int i = paramList.size();
    Log.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", new Object[] { Integer.valueOf(i) });
    Object localObject = (bl)paramList.get(0);
    MaskLayout localMaskLayout = (MaskLayout)this.fyN.findViewById(R.h.dHg);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((bl)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    localObject = (bl)paramList.get(1);
    localMaskLayout = (MaskLayout)this.fyN.findViewById(R.h.dHh);
    a.b.c((ImageView)localMaskLayout.getContentView(), ((bl)localObject).field_talker);
    localMaskLayout.setVisibility(0);
    if (i > 2)
    {
      localObject = (bl)paramList.get(2);
      localMaskLayout = (MaskLayout)this.fyN.findViewById(R.h.dHi);
      a.b.c((ImageView)localMaskLayout.getContentView(), ((bl)localObject).field_talker);
      localMaskLayout.setVisibility(0);
    }
    if (i > 3)
    {
      paramList = (bl)paramList.get(3);
      localObject = (MaskLayout)this.fyN.findViewById(R.h.dHj);
      a.b.c((ImageView)((MaskLayout)localObject).getContentView(), paramList.field_talker);
      ((MaskLayout)localObject).setVisibility(0);
    }
    this.Xst = this.fyN.findViewById(R.h.dHl);
    this.Xst.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37836);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/FMessageContactView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
        bh.beI();
        com.tencent.mm.model.c.aHp().i(143618, Integer.valueOf(0));
        com.tencent.mm.by.c.b(l.d(l.this), "subapp", ".ui.friend.FMessageConversationUI", new Intent());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/FMessageContactView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37836);
      }
    });
    AppMethodBeat.o(37841);
  }
  
  public final void detach()
  {
    AppMethodBeat.i(291143);
    if (bh.aHB()) {
      d.bqc().remove(this.Xsu);
    }
    AppMethodBeat.o(291143);
  }
  
  public final void setFrontGround(boolean paramBoolean)
  {
    this.Xsv = paramBoolean;
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(37842);
    Log.d("MicroMsg.FMessageContactView", "setVisible visible = ".concat(String.valueOf(paramBoolean)));
    View localView = this.fyN.findViewById(R.h.dHl);
    if (localView != null) {
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.isVisible = paramBoolean;
      AppMethodBeat.o(37842);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.l
 * JD-Core Version:    0.7.0.1
 */