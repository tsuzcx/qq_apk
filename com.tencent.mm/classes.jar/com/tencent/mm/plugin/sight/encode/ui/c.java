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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.a.e.a;
import com.tencent.mm.ui.contact.a.e.b;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends q
{
  public static boolean yUG = true;
  public static boolean yUH = false;
  List<String> yUE;
  boolean yUF;
  
  public c(n paramn)
  {
    super(paramn, new ArrayList(), true, true);
    AppMethodBeat.i(28735);
    this.yUF = true;
    this.yUF = true;
    this.yUE = null;
    AppMethodBeat.o(28735);
  }
  
  public static boolean axA(String paramString)
  {
    AppMethodBeat.i(28740);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28740);
      return false;
    }
    boolean bool = paramString.endsWith("@search.tencent");
    AppMethodBeat.o(28740);
    return bool;
  }
  
  public static boolean axB(String paramString)
  {
    AppMethodBeat.i(28741);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28741);
      return false;
    }
    boolean bool = paramString.endsWith("@draft.tencent");
    AppMethodBeat.o(28741);
    return bool;
  }
  
  public static boolean axz(String paramString)
  {
    AppMethodBeat.i(28739);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28739);
      return false;
    }
    boolean bool = paramString.endsWith("@sns.tencent");
    AppMethodBeat.o(28739);
    return bool;
  }
  
  public final void ce(List<String> paramList)
  {
    AppMethodBeat.i(28737);
    clearCache();
    this.yUE = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(28737);
  }
  
  public final boolean dQK()
  {
    return this.yUF;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(28736);
    if (this.yUE == null)
    {
      AppMethodBeat.o(28736);
      return 0;
    }
    int i = this.yUE.size();
    AppMethodBeat.o(28736);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a rh(int paramInt)
  {
    AppMethodBeat.i(28738);
    if (this.yUE == null)
    {
      AppMethodBeat.o(28738);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      ad.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(28738);
      return null;
    }
    a locala = new a(paramInt);
    Object localObject = (String)this.yUE.get(paramInt);
    if (axz((String)localObject)) {
      localObject = new am("@sns.tencent");
    }
    for (;;)
    {
      locala.contact = ((am)localObject);
      locala.KmP = this.yUF;
      AppMethodBeat.o(28738);
      return locala;
      if (axA((String)localObject))
      {
        localObject = new am("@search.tencent");
      }
      else if (axB((String)localObject))
      {
        localObject = new am("@draft.tencent");
      }
      else
      {
        ba.aBQ();
        localObject = com.tencent.mm.model.c.azp().Bf((String)this.yUE.get(paramInt));
      }
    }
  }
  
  public final class a
    extends e
  {
    public a(int paramInt)
    {
      super();
    }
    
    public final a.b aRs()
    {
      AppMethodBeat.i(28733);
      b localb = new b();
      AppMethodBeat.o(28733);
      return localb;
    }
    
    public final a.a dJN()
    {
      AppMethodBeat.i(28734);
      a locala = new a();
      AppMethodBeat.o(28734);
      return locala;
    }
    
    public final class a
      extends e.a
    {
      public View yTD;
      public View yUJ;
      
      public a()
      {
        super();
      }
    }
    
    public final class b
      extends e.b
    {
      public b()
      {
        super();
      }
      
      public final View a(Context paramContext, ViewGroup paramViewGroup)
      {
        AppMethodBeat.i(28731);
        paramContext = LayoutInflater.from(paramContext).inflate(2131495460, paramViewGroup, false);
        paramViewGroup = (c.a.a)c.a.this.dJN();
        paramViewGroup.fOf = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.iVq = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.iCV = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.contentView = paramContext.findViewById(2131304518);
        paramViewGroup.iVs = ((CheckBox)paramContext.findViewById(2131304502));
        paramViewGroup.yTD = paramContext.findViewById(2131301189);
        paramViewGroup.yUJ = paramContext.findViewById(2131304452);
        paramContext.setTag(paramViewGroup);
        paramViewGroup.iVq.setTextColor(-1);
        paramViewGroup = (AbsListView.LayoutParams)paramContext.getLayoutParams();
        paramViewGroup.width = -1;
        paramContext.setLayoutParams(paramViewGroup);
        paramContext.setBackgroundResource(2131100017);
        AppMethodBeat.o(28731);
        return paramContext;
      }
      
      public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
      {
        AppMethodBeat.i(28732);
        am localam = parama1.contact;
        c.a.a locala = (c.a.a)parama;
        locala.contentView.setVisibility(0);
        locala.yUJ.setVisibility(8);
        locala.yTD.setVisibility(8);
        if (c.axB(localam.field_username))
        {
          locala.fOf.setImageResource(2131691172);
          locala.iVq.setText(2131763703);
          locala.iCV.setText(2131763701);
          locala.iCV.setVisibility(0);
          locala.iVs.setEnabled(false);
          if (c.yUH)
          {
            locala.contentView.setBackgroundResource(2131234043);
            locala.iVs.setVisibility(0);
            locala.iVs.setBackgroundResource(2131691180);
            locala.yTD.setVisibility(0);
          }
          for (;;)
          {
            c.e(paramContext, locala.contentView);
            parama = locala.fOf.getLayoutParams();
            parama.width = com.tencent.mm.cc.a.ax(paramContext, 2131166795);
            parama.height = com.tencent.mm.cc.a.ax(paramContext, 2131166795);
            locala.fOf.setLayoutParams(parama);
            parama = (LinearLayout.LayoutParams)locala.iVs.getLayoutParams();
            parama.height = com.tencent.mm.cc.a.ax(paramContext, 2131166801);
            parama.width = com.tencent.mm.cc.a.ax(paramContext, 2131166801);
            parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
            locala.iVs.setLayoutParams(parama);
            AppMethodBeat.o(28732);
            return;
            locala.contentView.setBackgroundResource(2131234047);
            locala.iVs.setVisibility(8);
            locala.iVs.setBackgroundResource(2131691182);
            locala.yTD.setVisibility(8);
          }
        }
        if (c.axz(localam.field_username))
        {
          locala.fOf.setImageResource(2131691179);
          locala.iVs.setVisibility(8);
          locala.iVq.setText(paramContext.getString(2131763713));
          locala.iCV.setVisibility(8);
          if (c.yUG)
          {
            locala.contentView.setBackgroundResource(2131234047);
            locala.yTD.setVisibility(8);
            c.e(paramContext, locala.contentView);
          }
        }
        for (;;)
        {
          parama = locala.fOf.getLayoutParams();
          parama.width = com.tencent.mm.cc.a.ax(paramContext, 2131166795);
          parama.height = com.tencent.mm.cc.a.ax(paramContext, 2131166795);
          locala.fOf.setLayoutParams(parama);
          parama = (LinearLayout.LayoutParams)locala.iVs.getLayoutParams();
          parama.height = com.tencent.mm.cc.a.ax(paramContext, 2131166801);
          parama.width = com.tencent.mm.cc.a.ax(paramContext, 2131166801);
          parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
          locala.iVs.setLayoutParams(parama);
          locala.iVs.setBackgroundResource(2131234042);
          AppMethodBeat.o(28732);
          return;
          locala.contentView.setBackgroundResource(2131234043);
          locala.yTD.setVisibility(0);
          break;
          if (c.axA(localam.field_username))
          {
            locala.contentView.setVisibility(8);
            locala.yUJ.setVisibility(0);
            AppMethodBeat.o(28732);
            return;
          }
          super.a(paramContext, parama, parama1, paramBoolean1, paramBoolean2);
          locala.contentView.setBackgroundResource(2131234047);
          c.e(paramContext, locala.contentView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.c
 * JD-Core Version:    0.7.0.1
 */