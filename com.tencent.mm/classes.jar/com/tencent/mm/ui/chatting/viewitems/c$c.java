package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.ap;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.box.d;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.ah;
import com.tencent.mm.ui.chatting.component.api.av;
import com.tencent.mm.ui.widget.textview.a.f;
import com.tencent.mm.util.b.a;

public final class c$c
  implements View.OnLongClickListener
{
  private com.tencent.mm.ui.widget.b.a GAa;
  private int aeMA;
  private int aeMB;
  Object aeMC;
  a.f aeMh;
  private u.f aeMx;
  private b aeMy;
  private View aeMz;
  com.tencent.mm.ui.chatting.d.a aeiK;
  private PopupWindow.OnDismissListener mQ;
  private int mmp;
  private int x_down;
  private int y_down;
  
  public c$c(final c paramc, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(36741);
    this.aeMA = -1;
    this.mmp = -1;
    this.aeMB = -1;
    this.mQ = new a();
    this.aeiK = parama;
    this.aeMx = new u.f()
    {
      public final void OnCreateContextMMMenu(s paramAnonymouss, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
      {
        AppMethodBeat.i(255266);
        Object localObject = (bz)paramAnonymousView.getTag();
        if (localObject == null)
        {
          AppMethodBeat.o(255266);
          return;
        }
        int i = ((bz)localObject).position;
        if (((localObject instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localObject).viewType)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localObject = ((bz)localObject).hTm;
          if (localObject == null)
          {
            Log.e("MicroMsg.ChattingItem", "msg is null!");
            AppMethodBeat.o(255266);
            return;
          }
          if (((cc)localObject).fxR())
          {
            c.c.a(c.c.this, 49);
            boolean bool2 = c.c.this.aeMt.a(paramAnonymouss, paramAnonymousView, paramAnonymousContextMenuInfo, (cc)localObject);
            if ((au.bwN(c.c.b(c.c.this).getTalkerUserName())) || (au.bwL(c.c.b(c.c.this).getTalkerUserName())))
            {
              Log.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
              paramAnonymouss.removeItem(116);
            }
            if (!bool2) {
              break label944;
            }
            if (((((cc)localObject).iYl()) || (((cc)localObject).jbS()) || (((cc)localObject).jbJ())) && (!bt.I((cc)localObject)) && (!bt.O((cc)localObject)) && (!bt.F((cc)localObject)) && (!aj.aBu())) {
              paramAnonymouss.a(i, 137, c.c.b(c.c.this).aezO.getMMResources().getString(R.l.gyE), R.k.icons_filled_search_logo);
            }
            if ((!bt.F((cc)localObject)) && (!bt.O((cc)localObject)) && (c.c.this.aeMt.jxi())) {
              c.c.a(c.c.this, paramAnonymouss, (cc)localObject, i, bool1);
            }
            if ((!bt.F((cc)localObject)) && (!bt.O((cc)localObject)) && (c.c.a(c.c.this, (cc)localObject))) {
              c.c.a(c.c.this, paramAnonymouss, (cc)localObject, i);
            }
            if ((((cc)localObject).iYk()) && (((com.tencent.mm.plugin.websearch.api.c)h.az(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (!bt.I((cc)localObject)) && (!bt.O((cc)localObject)) && (!bt.F((cc)localObject)) && (!aj.aBu()))
            {
              paramAnonymouss.a(i, 137, c.c.b(c.c.this).aezO.getMMResources().getString(R.l.gyE), R.k.icons_filled_search_logo);
              paramAnonymousView = new ap();
              paramAnonymousContextMenuInfo = paramAnonymousView.kC("").kD(String.valueOf(((fi)localObject).field_msgSvrId));
              paramAnonymousContextMenuInfo.ioZ = 1;
              paramAnonymousContextMenuInfo.ilm = 1;
              paramAnonymousContextMenuInfo.imW = 67;
              paramAnonymousView.kE("");
              paramAnonymousView.kF("");
              if (!au.bwE(((fi)localObject).field_talker)) {
                break label908;
              }
              paramAnonymousView.imM = 2;
              label492:
              paramAnonymousView.kG("");
              paramAnonymousView.ipe = System.currentTimeMillis();
              paramAnonymousView.bMH();
              as.a(paramAnonymousView);
            }
            if (au.bwZ(((fi)localObject).field_talker))
            {
              if (paramAnonymouss.findItem(123) != null) {
                paramAnonymouss.removeItem(123);
              }
              if (paramAnonymouss.findItem(122) != null) {
                paramAnonymouss.removeItem(122);
              }
              if (paramAnonymouss.findItem(136) != null) {
                paramAnonymouss.removeItem(136);
              }
              if (paramAnonymouss.findItem(134) != null) {
                paramAnonymouss.removeItem(134);
              }
              if (paramAnonymouss.findItem(116) != null) {
                paramAnonymouss.removeItem(116);
              }
              if (paramAnonymouss.findItem(137) != null) {
                paramAnonymouss.removeItem(137);
              }
              if (paramAnonymouss.findItem(135) != null) {
                paramAnonymouss.removeItem(135);
              }
            }
            if (au.bwQ(c.c.b(c.c.this).getTalkerUserName()))
            {
              if (paramAnonymouss.findItem(123) != null) {
                paramAnonymouss.removeItem(123);
              }
              if (paramAnonymouss.findItem(136) != null) {
                paramAnonymouss.removeItem(136);
              }
              if (paramAnonymouss.findItem(134) != null) {
                paramAnonymouss.removeItem(134);
              }
            }
            if (!c.c.b(c.c.this).juH()) {
              break label916;
            }
            c.c.a(c.c.this, paramAnonymouss, i);
          }
          for (;;)
          {
            if (paramAnonymouss.findItem(123) != null)
            {
              paramAnonymouss.removeItem(100);
              paramAnonymouss.removeItem(123);
              c.c.b(c.c.this, paramAnonymouss, i);
            }
            if (((!au.bwZ(((fi)localObject).field_talker)) && (!bt.F((cc)localObject)) && (!bt.N((cc)localObject)) && (c.c.this.aeMt.jxk()) && (c.c.b(c.c.this).juH())) || (c.c.b(c.c.this).Uxa.iZC())) {
              c.c.b(c.c.this, paramAnonymouss, (cc)localObject, i);
            }
            paramAnonymousView = com.tencent.mm.util.i.agtt;
            if (com.tencent.mm.util.i.a(b.a.agqr, 0) == 1) {
              paramAnonymouss.a(i, 138, c.c.b(c.c.this).aezO.getMMResources().getString(R.l.app_debug), R.k.icons_filled_copy);
            }
            AppMethodBeat.o(255266);
            return;
            c.c.a(c.c.this, ((cc)localObject).getType());
            break;
            label908:
            paramAnonymousView.imM = 1;
            break label492;
            label916:
            if (paramAnonymouss.findItem(100) != null)
            {
              paramAnonymouss.removeItem(100);
              c.c.a(c.c.this, paramAnonymouss, i);
            }
          }
          label944:
          if (((cc)localObject).iYk())
          {
            bh.bCz();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
              ((av)c.c.b(c.c.this).cm(av.class)).a(paramAnonymouss, i, (cc)localObject);
            }
          }
          for (;;)
          {
            if (((fi)localObject).field_status == 5)
            {
              paramAnonymouss.a(i, 103, c.c.b(c.c.this).aezO.getMMResources().getString(R.l.gyy), R.k.icons_filled_refresh);
              com.tencent.mm.modelimage.i.c(r.bKa().af((cc)localObject));
            }
            if (paramAnonymouss.findItem(123) != null) {
              paramAnonymouss.removeItem(100);
            }
            if ((!bt.F((cc)localObject)) && (!bt.O((cc)localObject)) && (c.c.this.aeMt.jxi())) {
              c.c.a(c.c.this, paramAnonymouss, (cc)localObject, i, bool1);
            }
            if ((!bt.F((cc)localObject)) && (!bt.O((cc)localObject)) && (c.c.a(c.c.this, (cc)localObject))) {
              c.c.a(c.c.this, paramAnonymouss, (cc)localObject, i);
            }
            if ((au.bwZ(((fi)localObject).field_talker)) && (paramAnonymouss.findItem(123) != null)) {
              paramAnonymouss.removeItem(123);
            }
            paramAnonymousView = com.tencent.mm.util.i.agtt;
            if (com.tencent.mm.util.i.a(b.a.agqr, 0) == 1) {
              paramAnonymouss.a(i, 138, c.c.b(c.c.this).aezO.getMMResources().getString(R.l.app_debug), R.k.icons_filled_copy);
            }
            AppMethodBeat.o(255266);
            return;
            if (((cc)localObject).jbx()) {
              paramAnonymouss.a(i, 100, c.c.b(c.c.this).aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
            }
          }
        }
      }
    };
    this.aeMy = new b();
    AppMethodBeat.o(36741);
  }
  
  private void lr(View paramView)
  {
    AppMethodBeat.i(255333);
    Object localObject = (bz)paramView.getTag();
    if (localObject == null)
    {
      Log.w("MicroMsg.ChattingItem", "open menu but tag is null");
      AppMethodBeat.o(255333);
      return;
    }
    this.aeMy.aeMF = ((bz)localObject);
    if (this.GAa != null)
    {
      this.GAa.diW();
      this.GAa = null;
    }
    this.GAa = new com.tencent.mm.ui.widget.b.a(this.aeiK.aezO.getContext());
    this.GAa.agjw = true;
    this.aeMC = paramView.getTag(R.h.fYD);
    int[] arrayOfInt;
    cc localcc;
    if (((this.aeMC instanceof Boolean)) && (((Boolean)this.aeMC).booleanValue()))
    {
      if (a.a.jlv().jls())
      {
        this.GAa.agjG = true;
        this.GAa.agjB = true;
        this.GAa.agjH = true;
      }
    }
    else
    {
      if ((this.mQ instanceof a)) {
        ((a)this.mQ).aeMF = ((bz)localObject);
      }
      this.GAa.afLp = this.mQ;
      if (((localObject instanceof ChattingItemTranslate.a)) && (2 == ((ChattingItemTranslate.a)localObject).viewType) && (this.aeMh != null)) {
        this.aeMh.dismiss();
      }
      arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      localcc = ((bz)localObject).hTm;
      if ((!localcc.jbS()) && (!localcc.jbJ()) && (!localcc.iYl())) {
        break label494;
      }
      if (!au.bwE(localcc.field_talker)) {
        break label360;
      }
      localObject = br.JH(localcc.field_content);
      label291:
      if ((!localcc.jbJ()) && (!localcc.jbS())) {
        break label370;
      }
      localObject = k.b.Hf((String)localObject);
      if (localObject == null) {
        break label579;
      }
      localObject = ((k.b)localObject).title;
    }
    for (;;)
    {
      if (Util.isNullOrNil((String)localObject))
      {
        AppMethodBeat.o(255333);
        return;
        this.GAa.agjG = false;
        this.GAa.agjB = false;
        break;
        label360:
        localObject = localcc.field_content;
        break label291;
        label370:
        continue;
      }
      String str1 = ((d)h.az(d.class)).checkFirstHotWord((String)localObject);
      if (!Util.isNullOrNil(str1)) {
        this.aeMt.a(this.GAa, this.aeiK, str1);
      }
      if (Util.isNullOrNil(str1)) {
        this.GAa.agjF = null;
      }
      String str2 = "34_" + cn.bDw();
      c localc = this.aeMt;
      com.tencent.mm.ui.chatting.d.a locala = this.aeiK;
      if (!Util.isNullOrNil(str1)) {}
      for (boolean bool = true;; bool = false)
      {
        localc.a(locala, localcc, 1, bool, (String)localObject, false, str2, 1);
        label494:
        int i = arrayOfInt[0];
        int j = (int)(paramView.getWidth() / 2.0F);
        int k = arrayOfInt[1];
        this.GAa.a(paramView, this.aeMx, this.aeMy, i + j, k);
        if (this.aeiK != null)
        {
          this.aeiK.aE(false);
          this.aeiK.Mh(false);
          this.aeiK.aezV = false;
        }
        AppMethodBeat.o(255333);
        return;
      }
      label579:
      localObject = "";
    }
  }
  
  final void jxl()
  {
    AppMethodBeat.i(255449);
    if ((this.GAa != null) && (this.GAa.diW())) {
      this.GAa = null;
    }
    AppMethodBeat.o(255449);
  }
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(36742);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    if ((paramView.getTag(R.h.touch_loc) instanceof int[]))
    {
      paramView.getTag(R.h.touch_loc);
      lr(paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(36742);
      return true;
      if (((this.x_down == 0) && (this.y_down == 0)) || (!this.aeMz.equals(paramView))) {
        paramView.setOnTouchListener(new View.OnTouchListener()
        {
          public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(36738);
            c.c.b(c.c.this, (int)paramAnonymousMotionEvent.getRawX());
            c.c.c(c.c.this, (int)paramAnonymousMotionEvent.getRawY());
            c.c.a(c.c.this, paramAnonymousView);
            AppMethodBeat.o(36738);
            return false;
          }
        });
      } else {
        lr(paramView);
      }
    }
  }
  
  final void openContextMenu(View paramView)
  {
    AppMethodBeat.i(255439);
    lr(paramView);
    AppMethodBeat.o(255439);
  }
  
  final class a
    implements PopupWindow.OnDismissListener
  {
    public bz aeMF;
    
    a() {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(255086);
      if (((c.c.this.aeMC instanceof Boolean)) && (((Boolean)c.c.this.aeMC).booleanValue()) && (a.a.jlv().jls()) && (c.c.c(c.c.this) != null)) {
        c.c.c(c.c.this).dismiss();
      }
      k.b localb;
      int i;
      if ((this.aeMF != null) && (this.aeMF.hTm != null) && (this.aeMF.hTm.fxR()))
      {
        localb = k.b.aP(this.aeMF.hTm.field_content, this.aeMF.hTm.field_reserved);
        if (localb == null) {
          i = 0;
        }
      }
      for (;;)
      {
        c.a(c.c.d(c.c.this), c.c.b(c.c.this), c.c.e(c.c.this), c.c.f(c.c.this), c.c.g(c.c.this), i);
        c.c.d(c.c.this, -1);
        c.c.e(c.c.this, -1);
        c.c.a(c.c.this, -1);
        c.c.b(c.c.this).aE(true);
        AppMethodBeat.o(255086);
        return;
        i = localb.type;
        continue;
        i = 0;
      }
    }
  }
  
  final class b
    implements u.i
  {
    public bz aeMF;
    
    b() {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(36740);
      if (this.aeMF == null)
      {
        Log.e("MicroMsg.ChattingItem", "context item select failed, null dataTag");
        AppMethodBeat.o(36740);
        return;
      }
      if (((c.c.this.aeMt instanceof bj.a)) || ((c.c.this.aeMt instanceof bj.b))) {
        c.c.this.aeMt.a(paramMenuItem, c.c.b(c.c.this), this.aeMF);
      }
      for (;;)
      {
        ((ah)c.c.b(c.c.this).cm(ah.class)).a(paramMenuItem, c.c.this.aeMt);
        c.c.e(c.c.this, paramMenuItem.getItemId());
        c.c.d(c.c.this, paramInt);
        if (c.c.c(c.c.this) != null) {
          c.c.c(c.c.this).dismiss();
        }
        AppMethodBeat.o(36740);
        return;
        c.c.this.aeMt.a(paramMenuItem, c.c.b(c.c.this), this.aeMF.hTm);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.c
 * JD-Core Version:    0.7.0.1
 */