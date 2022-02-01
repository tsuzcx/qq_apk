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
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  public static boolean zkQ = true;
  public static boolean zkR = false;
  List<String> zkO;
  boolean zkP;
  
  public c(n paramn)
  {
    super(paramn, new ArrayList(), true, true);
    AppMethodBeat.i(28735);
    this.zkP = true;
    this.zkP = true;
    this.zkO = null;
    AppMethodBeat.o(28735);
  }
  
  public static boolean ayP(String paramString)
  {
    AppMethodBeat.i(28739);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28739);
      return false;
    }
    boolean bool = paramString.endsWith("@sns.tencent");
    AppMethodBeat.o(28739);
    return bool;
  }
  
  public static boolean ayQ(String paramString)
  {
    AppMethodBeat.i(28740);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28740);
      return false;
    }
    boolean bool = paramString.endsWith("@search.tencent");
    AppMethodBeat.o(28740);
    return bool;
  }
  
  public static boolean ayR(String paramString)
  {
    AppMethodBeat.i(28741);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28741);
      return false;
    }
    boolean bool = paramString.endsWith("@draft.tencent");
    AppMethodBeat.o(28741);
    return bool;
  }
  
  public final void cg(List<String> paramList)
  {
    AppMethodBeat.i(28737);
    clearCache();
    this.zkO = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(28737);
  }
  
  public final boolean dUh()
  {
    return this.zkP;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(28736);
    if (this.zkO == null)
    {
      AppMethodBeat.o(28736);
      return 0;
    }
    int i = this.zkO.size();
    AppMethodBeat.o(28736);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a rk(int paramInt)
  {
    AppMethodBeat.i(28738);
    if (this.zkO == null)
    {
      AppMethodBeat.o(28738);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      ae.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(28738);
      return null;
    }
    a locala = new a(paramInt);
    Object localObject = (String)this.zkO.get(paramInt);
    if (ayP((String)localObject)) {
      localObject = new an("@sns.tencent");
    }
    for (;;)
    {
      locala.contact = ((an)localObject);
      locala.KJj = this.zkP;
      AppMethodBeat.o(28738);
      return locala;
      if (ayQ((String)localObject))
      {
        localObject = new an("@search.tencent");
      }
      else if (ayR((String)localObject))
      {
        localObject = new an("@draft.tencent");
      }
      else
      {
        bc.aCg();
        localObject = com.tencent.mm.model.c.azF().BH((String)this.zkO.get(paramInt));
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
    
    public final a.b aRR()
    {
      AppMethodBeat.i(28733);
      b localb = new b();
      AppMethodBeat.o(28733);
      return localb;
    }
    
    public final a.a dNf()
    {
      AppMethodBeat.i(28734);
      a locala = new a();
      AppMethodBeat.o(28734);
      return locala;
    }
    
    public final class a
      extends e.a
    {
      public View zjN;
      public View zkT;
      
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
        paramViewGroup = (c.a.a)c.a.this.dNf();
        paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.contentView = paramContext.findViewById(2131304518);
        paramViewGroup.iYl = ((CheckBox)paramContext.findViewById(2131304502));
        paramViewGroup.zjN = paramContext.findViewById(2131301189);
        paramViewGroup.zkT = paramContext.findViewById(2131304452);
        paramContext.setTag(paramViewGroup);
        paramViewGroup.iYj.setTextColor(-1);
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
        an localan = parama1.contact;
        c.a.a locala = (c.a.a)parama;
        locala.contentView.setVisibility(0);
        locala.zkT.setVisibility(8);
        locala.zjN.setVisibility(8);
        if (c.ayR(localan.field_username))
        {
          locala.fQl.setImageResource(2131691172);
          locala.iYj.setText(2131763703);
          locala.iFO.setText(2131763701);
          locala.iFO.setVisibility(0);
          locala.iYl.setEnabled(false);
          if (c.zkR)
          {
            locala.contentView.setBackgroundResource(2131234043);
            locala.iYl.setVisibility(0);
            locala.iYl.setBackgroundResource(2131691180);
            locala.zjN.setVisibility(0);
          }
          for (;;)
          {
            c.e(paramContext, locala.contentView);
            parama = locala.fQl.getLayoutParams();
            parama.width = com.tencent.mm.cb.a.ax(paramContext, 2131166795);
            parama.height = com.tencent.mm.cb.a.ax(paramContext, 2131166795);
            locala.fQl.setLayoutParams(parama);
            parama = (LinearLayout.LayoutParams)locala.iYl.getLayoutParams();
            parama.height = com.tencent.mm.cb.a.ax(paramContext, 2131166801);
            parama.width = com.tencent.mm.cb.a.ax(paramContext, 2131166801);
            parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
            locala.iYl.setLayoutParams(parama);
            AppMethodBeat.o(28732);
            return;
            locala.contentView.setBackgroundResource(2131234047);
            locala.iYl.setVisibility(8);
            locala.iYl.setBackgroundResource(2131691182);
            locala.zjN.setVisibility(8);
          }
        }
        if (c.ayP(localan.field_username))
        {
          locala.fQl.setImageResource(2131691179);
          locala.iYl.setVisibility(8);
          locala.iYj.setText(paramContext.getString(2131763713));
          locala.iFO.setVisibility(8);
          if (c.zkQ)
          {
            locala.contentView.setBackgroundResource(2131234047);
            locala.zjN.setVisibility(8);
            c.e(paramContext, locala.contentView);
          }
        }
        for (;;)
        {
          parama = locala.fQl.getLayoutParams();
          parama.width = com.tencent.mm.cb.a.ax(paramContext, 2131166795);
          parama.height = com.tencent.mm.cb.a.ax(paramContext, 2131166795);
          locala.fQl.setLayoutParams(parama);
          parama = (LinearLayout.LayoutParams)locala.iYl.getLayoutParams();
          parama.height = com.tencent.mm.cb.a.ax(paramContext, 2131166801);
          parama.width = com.tencent.mm.cb.a.ax(paramContext, 2131166801);
          parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
          locala.iYl.setLayoutParams(parama);
          locala.iYl.setBackgroundResource(2131234042);
          AppMethodBeat.o(28732);
          return;
          locala.contentView.setBackgroundResource(2131234043);
          locala.zjN.setVisibility(0);
          break;
          if (c.ayQ(localan.field_username))
          {
            locala.contentView.setVisibility(8);
            locala.zkT.setVisibility(0);
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