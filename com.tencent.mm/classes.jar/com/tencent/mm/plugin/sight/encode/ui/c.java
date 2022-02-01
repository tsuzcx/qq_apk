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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  public static boolean DpH = true;
  public static boolean DpI = false;
  List<String> DpF;
  boolean DpG;
  
  public c(n paramn)
  {
    super(paramn, new ArrayList(), true, true);
    AppMethodBeat.i(28735);
    this.DpG = true;
    this.DpG = true;
    this.DpF = null;
    AppMethodBeat.o(28735);
  }
  
  public static boolean aNA(String paramString)
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
  
  public static boolean aNB(String paramString)
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
  
  public static boolean aNz(String paramString)
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
  
  public final void cv(List<String> paramList)
  {
    AppMethodBeat.i(28737);
    clearCache();
    this.DpF = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(28737);
  }
  
  public final boolean eWh()
  {
    return this.DpG;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(28736);
    if (this.DpF == null)
    {
      AppMethodBeat.o(28736);
      return 0;
    }
    int i = this.DpF.size();
    AppMethodBeat.o(28736);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a va(int paramInt)
  {
    AppMethodBeat.i(28738);
    if (this.DpF == null)
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
    Object localObject = (String)this.DpF.get(paramInt);
    if (aNz((String)localObject)) {
      localObject = new as("@sns.tencent");
    }
    for (;;)
    {
      locala.contact = ((as)localObject);
      locala.PWh = this.DpG;
      AppMethodBeat.o(28738);
      return locala;
      if (aNA((String)localObject))
      {
        localObject = new as("@search.tencent");
      }
      else if (aNB((String)localObject))
      {
        localObject = new as("@draft.tencent");
      }
      else
      {
        bg.aVF();
        localObject = com.tencent.mm.model.c.aSN().Kn((String)this.DpF.get(paramInt));
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
    
    public final a.b bmx()
    {
      AppMethodBeat.i(28733);
      b localb = new b();
      AppMethodBeat.o(28733);
      return localb;
    }
    
    public final a.a eOf()
    {
      AppMethodBeat.i(28734);
      a locala = new a();
      AppMethodBeat.o(28734);
      return locala;
    }
    
    public final class a
      extends e.a
    {
      public View Bnt;
      public View DpK;
      
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
        paramContext = LayoutInflater.from(paramContext).inflate(2131496333, paramViewGroup, false);
        paramViewGroup = (c.a.a)c.a.this.eOf();
        paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
        paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
        paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
        paramViewGroup.contentView = paramContext.findViewById(2131307533);
        paramViewGroup.jVQ = ((CheckBox)paramContext.findViewById(2131307508));
        paramViewGroup.Bnt = paramContext.findViewById(2131302861);
        paramViewGroup.DpK = paramContext.findViewById(2131307428);
        paramContext.setTag(paramViewGroup);
        paramViewGroup.jVO.setTextColor(-1);
        paramViewGroup = (AbsListView.LayoutParams)paramContext.getLayoutParams();
        paramViewGroup.width = -1;
        paramContext.setLayoutParams(paramViewGroup);
        paramContext.setBackgroundResource(2131100042);
        AppMethodBeat.o(28731);
        return paramContext;
      }
      
      public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
      {
        AppMethodBeat.i(28732);
        as localas = parama1.contact;
        c.a.a locala = (c.a.a)parama;
        locala.contentView.setVisibility(0);
        locala.DpK.setVisibility(8);
        locala.Bnt.setVisibility(8);
        if (c.aNB(localas.field_username))
        {
          locala.gvv.setImageResource(2131691488);
          locala.jVO.setText(2131765894);
          locala.jBR.setText(2131765892);
          locala.jBR.setVisibility(0);
          locala.jVQ.setEnabled(false);
          if (c.DpI)
          {
            locala.contentView.setBackgroundResource(2131234885);
            locala.jVQ.setVisibility(0);
            locala.jVQ.setBackgroundResource(2131691496);
            locala.Bnt.setVisibility(0);
          }
          for (;;)
          {
            c.e(paramContext, locala.contentView);
            parama = locala.gvv.getLayoutParams();
            parama.width = com.tencent.mm.cb.a.aG(paramContext, 2131166919);
            parama.height = com.tencent.mm.cb.a.aG(paramContext, 2131166919);
            locala.gvv.setLayoutParams(parama);
            parama = (LinearLayout.LayoutParams)locala.jVQ.getLayoutParams();
            parama.height = com.tencent.mm.cb.a.aG(paramContext, 2131166925);
            parama.width = com.tencent.mm.cb.a.aG(paramContext, 2131166925);
            parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
            locala.jVQ.setLayoutParams(parama);
            AppMethodBeat.o(28732);
            return;
            locala.contentView.setBackgroundResource(2131234889);
            locala.jVQ.setVisibility(8);
            locala.jVQ.setBackgroundResource(2131691498);
            locala.Bnt.setVisibility(8);
          }
        }
        if (c.aNz(localas.field_username))
        {
          locala.gvv.setImageResource(2131691495);
          locala.jVQ.setVisibility(8);
          locala.jVO.setText(paramContext.getString(2131765904));
          locala.jBR.setVisibility(8);
          if (c.DpH)
          {
            locala.contentView.setBackgroundResource(2131234889);
            locala.Bnt.setVisibility(8);
            c.e(paramContext, locala.contentView);
          }
        }
        for (;;)
        {
          parama = locala.gvv.getLayoutParams();
          parama.width = com.tencent.mm.cb.a.aG(paramContext, 2131166919);
          parama.height = com.tencent.mm.cb.a.aG(paramContext, 2131166919);
          locala.gvv.setLayoutParams(parama);
          parama = (LinearLayout.LayoutParams)locala.jVQ.getLayoutParams();
          parama.height = com.tencent.mm.cb.a.aG(paramContext, 2131166925);
          parama.width = com.tencent.mm.cb.a.aG(paramContext, 2131166925);
          parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
          locala.jVQ.setLayoutParams(parama);
          locala.jVQ.setBackgroundResource(2131234884);
          AppMethodBeat.o(28732);
          return;
          locala.contentView.setBackgroundResource(2131234885);
          locala.Bnt.setVisibility(0);
          break;
          if (c.aNA(localas.field_username))
          {
            locala.contentView.setVisibility(8);
            locala.DpK.setVisibility(0);
            AppMethodBeat.o(28732);
            return;
          }
          super.a(paramContext, parama, parama1, paramBoolean1, paramBoolean2);
          locala.contentView.setBackgroundResource(2131234889);
          c.e(paramContext, locala.contentView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.c
 * JD-Core Version:    0.7.0.1
 */