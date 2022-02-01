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
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
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
  public static boolean xFW = true;
  public static boolean xFX = false;
  List<String> xFU;
  boolean xFV;
  
  public c(n paramn)
  {
    super(paramn, new ArrayList(), true, true);
    AppMethodBeat.i(28735);
    this.xFV = true;
    this.xFV = true;
    this.xFU = null;
    AppMethodBeat.o(28735);
  }
  
  public static boolean asA(String paramString)
  {
    AppMethodBeat.i(28740);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28740);
      return false;
    }
    boolean bool = paramString.endsWith("@search.tencent");
    AppMethodBeat.o(28740);
    return bool;
  }
  
  public static boolean asB(String paramString)
  {
    AppMethodBeat.i(28741);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28741);
      return false;
    }
    boolean bool = paramString.endsWith("@draft.tencent");
    AppMethodBeat.o(28741);
    return bool;
  }
  
  public static boolean asz(String paramString)
  {
    AppMethodBeat.i(28739);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28739);
      return false;
    }
    boolean bool = paramString.endsWith("@sns.tencent");
    AppMethodBeat.o(28739);
    return bool;
  }
  
  public final void cd(List<String> paramList)
  {
    AppMethodBeat.i(28737);
    clearCache();
    this.xFU = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(28737);
  }
  
  public final boolean dFi()
  {
    return this.xFV;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(28736);
    if (this.xFU == null)
    {
      AppMethodBeat.o(28736);
      return 0;
    }
    int i = this.xFU.size();
    AppMethodBeat.o(28736);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a qH(int paramInt)
  {
    AppMethodBeat.i(28738);
    if (this.xFU == null)
    {
      AppMethodBeat.o(28738);
      return null;
    }
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      ac.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(28738);
      return null;
    }
    a locala = new a(paramInt);
    Object localObject = (String)this.xFU.get(paramInt);
    if (asz((String)localObject)) {
      localObject = new ai("@sns.tencent");
    }
    for (;;)
    {
      locala.contact = ((ai)localObject);
      locala.Iwh = this.xFV;
      AppMethodBeat.o(28738);
      return locala;
      if (asA((String)localObject))
      {
        localObject = new ai("@search.tencent");
      }
      else if (asB((String)localObject))
      {
        localObject = new ai("@draft.tencent");
      }
      else
      {
        az.ayM();
        localObject = com.tencent.mm.model.c.awB().aNt((String)this.xFU.get(paramInt));
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
    
    public final a.b aOg()
    {
      AppMethodBeat.i(28733);
      b localb = new b();
      AppMethodBeat.o(28733);
      return localb;
    }
    
    public final a.a dyv()
    {
      AppMethodBeat.i(28734);
      a locala = new a();
      AppMethodBeat.o(28734);
      return locala;
    }
    
    public final class a
      extends e.a
    {
      public View xET;
      public View xFZ;
      
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
        paramViewGroup = (c.a.a)c.a.this.dyv();
        paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.iCg = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.contentView = paramContext.findViewById(2131304518);
        paramViewGroup.iCi = ((CheckBox)paramContext.findViewById(2131304502));
        paramViewGroup.xET = paramContext.findViewById(2131301189);
        paramViewGroup.xFZ = paramContext.findViewById(2131304452);
        paramContext.setTag(paramViewGroup);
        paramViewGroup.iCg.setTextColor(-1);
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
        ai localai = parama1.contact;
        c.a.a locala = (c.a.a)parama;
        locala.contentView.setVisibility(0);
        locala.xFZ.setVisibility(8);
        locala.xET.setVisibility(8);
        if (c.asB(localai.field_username))
        {
          locala.fuY.setImageResource(2131691172);
          locala.iCg.setText(2131763703);
          locala.ijE.setText(2131763701);
          locala.ijE.setVisibility(0);
          locala.iCi.setEnabled(false);
          if (c.xFX)
          {
            locala.contentView.setBackgroundResource(2131234043);
            locala.iCi.setVisibility(0);
            locala.iCi.setBackgroundResource(2131691180);
            locala.xET.setVisibility(0);
          }
          for (;;)
          {
            c.e(paramContext, locala.contentView);
            parama = locala.fuY.getLayoutParams();
            parama.width = com.tencent.mm.cc.a.au(paramContext, 2131166795);
            parama.height = com.tencent.mm.cc.a.au(paramContext, 2131166795);
            locala.fuY.setLayoutParams(parama);
            parama = (LinearLayout.LayoutParams)locala.iCi.getLayoutParams();
            parama.height = com.tencent.mm.cc.a.au(paramContext, 2131166801);
            parama.width = com.tencent.mm.cc.a.au(paramContext, 2131166801);
            parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
            locala.iCi.setLayoutParams(parama);
            AppMethodBeat.o(28732);
            return;
            locala.contentView.setBackgroundResource(2131234047);
            locala.iCi.setVisibility(8);
            locala.iCi.setBackgroundResource(2131691182);
            locala.xET.setVisibility(8);
          }
        }
        if (c.asz(localai.field_username))
        {
          locala.fuY.setImageResource(2131691179);
          locala.iCi.setVisibility(8);
          locala.iCg.setText(paramContext.getString(2131763713));
          locala.ijE.setVisibility(8);
          if (c.xFW)
          {
            locala.contentView.setBackgroundResource(2131234047);
            locala.xET.setVisibility(8);
            c.e(paramContext, locala.contentView);
          }
        }
        for (;;)
        {
          parama = locala.fuY.getLayoutParams();
          parama.width = com.tencent.mm.cc.a.au(paramContext, 2131166795);
          parama.height = com.tencent.mm.cc.a.au(paramContext, 2131166795);
          locala.fuY.setLayoutParams(parama);
          parama = (LinearLayout.LayoutParams)locala.iCi.getLayoutParams();
          parama.height = com.tencent.mm.cc.a.au(paramContext, 2131166801);
          parama.width = com.tencent.mm.cc.a.au(paramContext, 2131166801);
          parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
          locala.iCi.setLayoutParams(parama);
          locala.iCi.setBackgroundResource(2131234042);
          AppMethodBeat.o(28732);
          return;
          locala.contentView.setBackgroundResource(2131234043);
          locala.xET.setVisibility(0);
          break;
          if (c.asA(localai.field_username))
          {
            locala.contentView.setVisibility(8);
            locala.xFZ.setVisibility(0);
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