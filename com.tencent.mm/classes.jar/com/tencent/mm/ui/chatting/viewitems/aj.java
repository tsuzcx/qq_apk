package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.v.n;

public final class aj
{
  public static final class a
    extends c
  {
    private aj.d aeRO;
    private a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37070);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.ggl);
        ((View)localObject).setTag(new aj.e().lK((View)localObject));
      }
      AppMethodBeat.o(37070);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(37071);
      this.aeiK = parama1;
      parama = (aj.e)parama;
      if (this.aeRO == null) {
        this.aeRO = new aj.d(this.aeiK, this);
      }
      aj.e.a(parama, paramInt, parama1, paramcc, false, this.aeRO, c(parama1));
      ((y)com.tencent.mm.kernel.h.ax(y.class)).chp();
      AppMethodBeat.o(37071);
    }
    
    public final boolean a(final MenuItem paramMenuItem, final a parama, final cc paramcc)
    {
      AppMethodBeat.i(37073);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = bt.X(paramcc);
        if (!Util.isNullOrNil(paramMenuItem)) {
          break label110;
        }
        paramMenuItem = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.OAn.b(16979, new Object[] { paramMenuItem.nTE, paramMenuItem.nTC, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, paramcc, a(parama, paramcc));
      }
      for (;;)
      {
        AppMethodBeat.o(37073);
        return false;
        label110:
        com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
        k.a(parama.aezO.getContext(), R.l.gUu, R.l.gUv, R.l.app_view_detail, R.l.gzo, true, new aj.a.1(this, paramMenuItem, parama), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(37069);
            paramAnonymousDialogInterface = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
            if (paramAnonymousDialogInterface != null) {
              com.tencent.mm.plugin.report.service.h.OAn.b(16979, new Object[] { paramAnonymousDialogInterface.nTE, paramAnonymousDialogInterface.nTC, Integer.valueOf(0), Integer.valueOf(2) });
            }
            e.b.a(parama, paramcc, aj.a.this.a(parama, paramcc));
            com.tencent.mm.plugin.report.service.h.OAn.b(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
            AppMethodBeat.o(37069);
          }
        });
      }
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255197);
      boolean bool = aj.a(this.aeiK, params, paramView, paramcc);
      AppMethodBeat.o(255197);
      return bool;
    }
    
    public final boolean c(View paramView, a parama, cc paramcc)
    {
      return true;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean fXn()
    {
      return false;
    }
    
    final boolean jxi()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements v.n
  {
    private aj.d aeRO;
    private a aeiK;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37074);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ap(paramLayoutInflater, R.i.ghj);
        ((View)localObject).setTag(new aj.e().lK((View)localObject));
      }
      AppMethodBeat.o(37074);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
    {
      AppMethodBeat.i(37075);
      this.aeiK = parama1;
      parama = (aj.e)parama;
      if (this.aeRO == null) {
        this.aeRO = new aj.d(this.aeiK, this);
      }
      aj.e.a(parama, paramInt, parama1, paramcc, true, this.aeRO, c(parama1));
      a(paramInt, parama, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
      ((y)com.tencent.mm.kernel.h.ax(y.class)).chp();
      AppMethodBeat.o(37075);
    }
    
    public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
    {
      AppMethodBeat.i(37077);
      if (paramMenuItem.getItemId() == 111)
      {
        paramMenuItem = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
        if (paramMenuItem != null) {
          com.tencent.mm.plugin.report.service.h.OAn.b(16979, new Object[] { paramMenuItem.nTE, paramMenuItem.nTC, Integer.valueOf(0), Integer.valueOf(2) });
        }
        e.b.a(parama, paramcc, a(parama, paramcc));
      }
      AppMethodBeat.o(37077);
      return false;
    }
    
    public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(255150);
      boolean bool = aj.a(this.aeiK, params, paramView, paramcc);
      AppMethodBeat.o(255150);
      return bool;
    }
    
    public final void b(View paramView, a parama, cc paramcc)
    {
      AppMethodBeat.i(255157);
      if (paramcc.fxR())
      {
        n.bx(paramcc);
        br.iu(paramcc.field_msgId);
        parama.jpK();
      }
      AppMethodBeat.o(255157);
    }
    
    public final boolean c(View paramView, a parama, cc paramcc)
    {
      return true;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 687865905);
    }
    
    public final boolean fXn()
    {
      return true;
    }
    
    final boolean jxi()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj
 * JD-Core Version:    0.7.0.1
 */