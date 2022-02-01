package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.a.f.a;
import com.tencent.mm.ui.contact.a.f.b;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends r
{
  public static boolean PIK = true;
  public static boolean PIL = false;
  List<String> PII;
  boolean PIJ;
  
  public c(o paramo)
  {
    super(paramo, new ArrayList(), true, true);
    AppMethodBeat.i(28735);
    this.PIJ = true;
    this.PIJ = true;
    this.PII = null;
    AppMethodBeat.o(28735);
  }
  
  public static boolean aWb(String paramString)
  {
    AppMethodBeat.i(28739);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28739);
      return false;
    }
    boolean bool = paramString.endsWith("@sns.tencent");
    AppMethodBeat.o(28739);
    return bool;
  }
  
  public static boolean aWc(String paramString)
  {
    AppMethodBeat.i(28740);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28740);
      return false;
    }
    boolean bool = paramString.endsWith("@search.tencent");
    AppMethodBeat.o(28740);
    return bool;
  }
  
  public static boolean aWd(String paramString)
  {
    AppMethodBeat.i(28741);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28741);
      return false;
    }
    boolean bool = paramString.endsWith("@draft.tencent");
    AppMethodBeat.o(28741);
    return bool;
  }
  
  public final void ek(List<String> paramList)
  {
    AppMethodBeat.i(28737);
    clearCache();
    this.PII = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(28737);
  }
  
  public final boolean gZe()
  {
    return this.PIJ;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(28736);
    if (this.PII == null)
    {
      AppMethodBeat.o(28736);
      return 0;
    }
    int i = this.PII.size();
    AppMethodBeat.o(28736);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(28738);
    if (this.PII == null)
    {
      AppMethodBeat.o(28738);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      Log.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(28738);
      return null;
    }
    a locala = new a(paramInt);
    Object localObject = (String)this.PII.get(paramInt);
    if (aWb((String)localObject)) {
      localObject = new au("@sns.tencent");
    }
    for (;;)
    {
      locala.contact = ((au)localObject);
      locala.afey = this.PIJ;
      AppMethodBeat.o(28738);
      return locala;
      if (aWc((String)localObject))
      {
        localObject = new au("@search.tencent");
      }
      else if (aWd((String)localObject))
      {
        localObject = new au("@draft.tencent");
      }
      else
      {
        bh.bCz();
        localObject = com.tencent.mm.model.c.bzA().JE((String)this.PII.get(paramInt));
      }
    }
  }
  
  public final class a
    extends f
  {
    public a(int paramInt)
    {
      super();
    }
    
    public final a.b bVv()
    {
      AppMethodBeat.i(28733);
      b localb = new b();
      AppMethodBeat.o(28733);
      return localb;
    }
    
    public final a.a bVw()
    {
      AppMethodBeat.i(28734);
      a locala = new a();
      AppMethodBeat.o(28734);
      return locala;
    }
    
    public final class a
      extends f.a
    {
      public View NfI;
      public View PIN;
      
      public a()
      {
        super();
      }
    }
    
    public final class b
      extends f.b
    {
      public b()
      {
        super();
      }
      
      public final View a(Context paramContext, ViewGroup paramViewGroup)
      {
        AppMethodBeat.i(28731);
        paramContext = LayoutInflater.from(paramContext).inflate(R.i.got, paramViewGroup, false);
        paramViewGroup = (c.a.a)c.a.this.bVw();
        paramViewGroup.lBC = ((ImageView)paramContext.findViewById(R.h.avatar_iv));
        paramViewGroup.pJJ = ((TextView)paramContext.findViewById(R.h.title_tv));
        paramViewGroup.plr = ((TextView)paramContext.findViewById(R.h.desc_tv));
        paramViewGroup.contentView = paramContext.findViewById(R.h.select_item_content_layout);
        paramViewGroup.pJL = ((CheckBox)paramContext.findViewById(R.h.select_cb));
        paramViewGroup.NfI = paramContext.findViewById(R.h.fLH);
        paramViewGroup.PIN = paramContext.findViewById(R.h.search_view);
        paramContext.setTag(paramViewGroup);
        paramViewGroup.pJJ.setTextColor(-1);
        paramViewGroup = (AbsListView.LayoutParams)paramContext.getLayoutParams();
        paramViewGroup.width = -1;
        paramContext.setLayoutParams(paramViewGroup);
        paramContext.setBackgroundResource(R.e.black);
        AppMethodBeat.o(28731);
        return paramContext;
      }
      
      public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
      {
        AppMethodBeat.i(28732);
        au localau = parama1.contact;
        c.a.a locala = (c.a.a)parama;
        locala.contentView.setVisibility(0);
        locala.PIN.setVisibility(8);
        locala.NfI.setVisibility(8);
        if (c.aWd(localau.field_username))
        {
          locala.lBC.setImageResource(R.k.sight_icon_draft_item);
          locala.pJJ.setText(R.l.gWo);
          locala.plr.setText(R.l.gWn);
          locala.plr.setVisibility(0);
          locala.pJL.setEnabled(false);
          if (c.PIL)
          {
            locala.contentView.setBackgroundResource(R.g.fpl);
            locala.pJL.setVisibility(0);
            locala.pJL.setBackgroundResource(R.k.sight_list_checkbox_selected);
            locala.NfI.setVisibility(0);
          }
          for (;;)
          {
            c.g(paramContext, locala.contentView);
            parama = locala.lBC.getLayoutParams();
            parama.width = com.tencent.mm.cd.a.br(paramContext, R.f.fmb);
            parama.height = com.tencent.mm.cd.a.br(paramContext, R.f.fmb);
            locala.lBC.setLayoutParams(parama);
            parama = (LinearLayout.LayoutParams)locala.pJL.getLayoutParams();
            parama.height = com.tencent.mm.cd.a.br(paramContext, R.f.fmc);
            parama.width = com.tencent.mm.cd.a.br(paramContext, R.f.fmc);
            parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
            locala.pJL.setLayoutParams(parama);
            AppMethodBeat.o(28732);
            return;
            locala.contentView.setBackgroundResource(R.g.fpm);
            locala.pJL.setVisibility(8);
            locala.pJL.setBackgroundResource(R.k.sight_list_checkbox_unselected);
            locala.NfI.setVisibility(8);
          }
        }
        if (c.aWb(localau.field_username))
        {
          locala.lBC.setImageResource(R.k.sight_item_sns_icon);
          locala.pJL.setVisibility(8);
          locala.pJJ.setText(paramContext.getString(R.l.gWp));
          locala.plr.setVisibility(8);
          if (c.PIK)
          {
            locala.contentView.setBackgroundResource(R.g.fpm);
            locala.NfI.setVisibility(8);
            c.g(paramContext, locala.contentView);
          }
        }
        for (;;)
        {
          parama = locala.lBC.getLayoutParams();
          parama.width = com.tencent.mm.cd.a.br(paramContext, R.f.fmb);
          parama.height = com.tencent.mm.cd.a.br(paramContext, R.f.fmb);
          locala.lBC.setLayoutParams(parama);
          parama = (LinearLayout.LayoutParams)locala.pJL.getLayoutParams();
          parama.height = com.tencent.mm.cd.a.br(paramContext, R.f.fmc);
          parama.width = com.tencent.mm.cd.a.br(paramContext, R.f.fmc);
          parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
          locala.pJL.setLayoutParams(parama);
          locala.pJL.setBackgroundResource(R.g.fpk);
          AppMethodBeat.o(28732);
          return;
          locala.contentView.setBackgroundResource(R.g.fpl);
          locala.NfI.setVisibility(0);
          break;
          if (c.aWc(localau.field_username))
          {
            locala.contentView.setVisibility(8);
            locala.PIN.setVisibility(0);
            AppMethodBeat.o(28732);
            return;
          }
          super.a(paramContext, parama, parama1, paramBoolean1, paramBoolean2);
          locala.contentView.setBackgroundResource(R.g.fpm);
          c.g(paramContext, locala.contentView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.c
 * JD-Core Version:    0.7.0.1
 */