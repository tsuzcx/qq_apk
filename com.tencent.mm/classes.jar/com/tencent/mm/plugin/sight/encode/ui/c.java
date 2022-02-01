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
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  public static boolean wuG = true;
  public static boolean wuH = false;
  List<String> wuE;
  boolean wuF;
  
  public c(n paramn)
  {
    super(paramn, new ArrayList(), true, true);
    AppMethodBeat.i(28735);
    this.wuF = true;
    this.wuF = true;
    this.wuE = null;
    AppMethodBeat.o(28735);
  }
  
  public static boolean anq(String paramString)
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
  
  public static boolean anr(String paramString)
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
  
  public static boolean ans(String paramString)
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
  
  public final void cc(List<String> paramList)
  {
    AppMethodBeat.i(28737);
    clearCache();
    this.wuE = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(28737);
  }
  
  public final boolean dqZ()
  {
    return this.wuF;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(28736);
    if (this.wuE == null)
    {
      AppMethodBeat.o(28736);
      return 0;
    }
    int i = this.wuE.size();
    AppMethodBeat.o(28736);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a pU(int paramInt)
  {
    AppMethodBeat.i(28738);
    if (this.wuE == null)
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
    Object localObject = (String)this.wuE.get(paramInt);
    if (anq((String)localObject)) {
      localObject = new af("@sns.tencent");
    }
    for (;;)
    {
      locala.contact = ((af)localObject);
      locala.GVT = this.wuF;
      AppMethodBeat.o(28738);
      return locala;
      if (anr((String)localObject))
      {
        localObject = new af("@search.tencent");
      }
      else if (ans((String)localObject))
      {
        localObject = new af("@draft.tencent");
      }
      else
      {
        az.arV();
        localObject = com.tencent.mm.model.c.apM().aHY((String)this.wuE.get(paramInt));
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
    
    public final a.b aHr()
    {
      AppMethodBeat.i(28733);
      b localb = new b();
      AppMethodBeat.o(28733);
      return localb;
    }
    
    public final a.a dkt()
    {
      AppMethodBeat.i(28734);
      a locala = new a();
      AppMethodBeat.o(28734);
      return locala;
    }
    
    public final class a
      extends e.a
    {
      public View wtD;
      public View wuJ;
      
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
        paramViewGroup = (c.a.a)c.a.this.dkt();
        paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.ica = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.hJe = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.contentView = paramContext.findViewById(2131304518);
        paramViewGroup.icb = ((CheckBox)paramContext.findViewById(2131304502));
        paramViewGroup.wtD = paramContext.findViewById(2131301189);
        paramViewGroup.wuJ = paramContext.findViewById(2131304452);
        paramContext.setTag(paramViewGroup);
        paramViewGroup.ica.setTextColor(-1);
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
        af localaf = parama1.contact;
        c.a.a locala = (c.a.a)parama;
        locala.contentView.setVisibility(0);
        locala.wuJ.setVisibility(8);
        locala.wtD.setVisibility(8);
        if (c.ans(localaf.field_username))
        {
          locala.frr.setImageResource(2131691172);
          locala.ica.setText(2131763703);
          locala.hJe.setText(2131763701);
          locala.hJe.setVisibility(0);
          locala.icb.setEnabled(false);
          if (c.wuH)
          {
            locala.contentView.setBackgroundResource(2131234043);
            locala.icb.setVisibility(0);
            locala.icb.setBackgroundResource(2131691180);
            locala.wtD.setVisibility(0);
          }
          for (;;)
          {
            c.e(paramContext, locala.contentView);
            parama = locala.frr.getLayoutParams();
            parama.width = com.tencent.mm.cd.a.ao(paramContext, 2131166795);
            parama.height = com.tencent.mm.cd.a.ao(paramContext, 2131166795);
            locala.frr.setLayoutParams(parama);
            parama = (LinearLayout.LayoutParams)locala.icb.getLayoutParams();
            parama.height = com.tencent.mm.cd.a.ao(paramContext, 2131166801);
            parama.width = com.tencent.mm.cd.a.ao(paramContext, 2131166801);
            parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
            locala.icb.setLayoutParams(parama);
            AppMethodBeat.o(28732);
            return;
            locala.contentView.setBackgroundResource(2131234047);
            locala.icb.setVisibility(8);
            locala.icb.setBackgroundResource(2131691182);
            locala.wtD.setVisibility(8);
          }
        }
        if (c.anq(localaf.field_username))
        {
          locala.frr.setImageResource(2131691179);
          locala.icb.setVisibility(8);
          locala.ica.setText(paramContext.getString(2131763713));
          locala.hJe.setVisibility(8);
          if (c.wuG)
          {
            locala.contentView.setBackgroundResource(2131234047);
            locala.wtD.setVisibility(8);
            c.e(paramContext, locala.contentView);
          }
        }
        for (;;)
        {
          parama = locala.frr.getLayoutParams();
          parama.width = com.tencent.mm.cd.a.ao(paramContext, 2131166795);
          parama.height = com.tencent.mm.cd.a.ao(paramContext, 2131166795);
          locala.frr.setLayoutParams(parama);
          parama = (LinearLayout.LayoutParams)locala.icb.getLayoutParams();
          parama.height = com.tencent.mm.cd.a.ao(paramContext, 2131166801);
          parama.width = com.tencent.mm.cd.a.ao(paramContext, 2131166801);
          parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
          locala.icb.setLayoutParams(parama);
          locala.icb.setBackgroundResource(2131234042);
          AppMethodBeat.o(28732);
          return;
          locala.contentView.setBackgroundResource(2131234043);
          locala.wtD.setVisibility(0);
          break;
          if (c.anr(localaf.field_username))
          {
            locala.contentView.setVisibility(8);
            locala.wuJ.setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.c
 * JD-Core Version:    0.7.0.1
 */