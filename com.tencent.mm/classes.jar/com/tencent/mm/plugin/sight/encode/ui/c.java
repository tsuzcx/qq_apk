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
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
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
  public static boolean Jvm = true;
  public static boolean Jvn = false;
  List<String> Jvk;
  boolean Jvl;
  
  public c(o paramo)
  {
    super(paramo, new ArrayList(), true, true);
    AppMethodBeat.i(28735);
    this.Jvl = true;
    this.Jvl = true;
    this.Jvk = null;
    AppMethodBeat.o(28735);
  }
  
  public static boolean aYj(String paramString)
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
  
  public static boolean aYk(String paramString)
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
  
  public static boolean aYl(String paramString)
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
  
  public final void cs(List<String> paramList)
  {
    AppMethodBeat.i(28737);
    clearCache();
    this.Jvk = paramList;
    notifyDataSetChanged();
    AppMethodBeat.o(28737);
  }
  
  public final boolean fJk()
  {
    return this.Jvl;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(28736);
    if (this.Jvk == null)
    {
      AppMethodBeat.o(28736);
      return 0;
    }
    int i = this.Jvk.size();
    AppMethodBeat.o(28736);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(28738);
    if (this.Jvk == null)
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
    Object localObject = (String)this.Jvk.get(paramInt);
    if (aYj((String)localObject)) {
      localObject = new as("@sns.tencent");
    }
    for (;;)
    {
      locala.contact = ((as)localObject);
      locala.XsX = this.Jvl;
      AppMethodBeat.o(28738);
      return locala;
      if (aYk((String)localObject))
      {
        localObject = new as("@search.tencent");
      }
      else if (aYl((String)localObject))
      {
        localObject = new as("@draft.tencent");
      }
      else
      {
        bh.beI();
        localObject = com.tencent.mm.model.c.bbL().RG((String)this.Jvk.get(paramInt));
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
    
    public final a.b bwF()
    {
      AppMethodBeat.i(28733);
      b localb = new b();
      AppMethodBeat.o(28733);
      return localb;
    }
    
    public final a.a bwG()
    {
      AppMethodBeat.i(28734);
      a locala = new a();
      AppMethodBeat.o(28734);
      return locala;
    }
    
    public final class a
      extends f.a
    {
      public View HhP;
      public View Jvp;
      
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
        paramContext = LayoutInflater.from(paramContext).inflate(R.i.elo, paramViewGroup, false);
        paramViewGroup = (c.a.a)c.a.this.bwG();
        paramViewGroup.iZG = ((ImageView)paramContext.findViewById(R.h.avatar_iv));
        paramViewGroup.mNb = ((TextView)paramContext.findViewById(R.h.title_tv));
        paramViewGroup.mrM = ((TextView)paramContext.findViewById(R.h.desc_tv));
        paramViewGroup.contentView = paramContext.findViewById(R.h.select_item_content_layout);
        paramViewGroup.mNd = ((CheckBox)paramContext.findViewById(R.h.select_cb));
        paramViewGroup.HhP = paramContext.findViewById(R.h.dKm);
        paramViewGroup.Jvp = paramContext.findViewById(R.h.dTs);
        paramContext.setTag(paramViewGroup);
        paramViewGroup.mNb.setTextColor(-1);
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
        as localas = parama1.contact;
        c.a.a locala = (c.a.a)parama;
        locala.contentView.setVisibility(0);
        locala.Jvp.setVisibility(8);
        locala.HhP.setVisibility(8);
        if (c.aYl(localas.field_username))
        {
          locala.iZG.setImageResource(R.k.sight_icon_draft_item);
          locala.mNb.setText(R.l.eTx);
          locala.mrM.setText(R.l.eTw);
          locala.mrM.setVisibility(0);
          locala.mNd.setEnabled(false);
          if (c.Jvn)
          {
            locala.contentView.setBackgroundResource(R.g.doX);
            locala.mNd.setVisibility(0);
            locala.mNd.setBackgroundResource(R.k.sight_list_checkbox_selected);
            locala.HhP.setVisibility(0);
          }
          for (;;)
          {
            c.e(paramContext, locala.contentView);
            parama = locala.iZG.getLayoutParams();
            parama.width = com.tencent.mm.ci.a.aY(paramContext, R.f.dlJ);
            parama.height = com.tencent.mm.ci.a.aY(paramContext, R.f.dlJ);
            locala.iZG.setLayoutParams(parama);
            parama = (LinearLayout.LayoutParams)locala.mNd.getLayoutParams();
            parama.height = com.tencent.mm.ci.a.aY(paramContext, R.f.dlK);
            parama.width = com.tencent.mm.ci.a.aY(paramContext, R.f.dlK);
            parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
            locala.mNd.setLayoutParams(parama);
            AppMethodBeat.o(28732);
            return;
            locala.contentView.setBackgroundResource(R.g.doY);
            locala.mNd.setVisibility(8);
            locala.mNd.setBackgroundResource(R.k.sight_list_checkbox_unselected);
            locala.HhP.setVisibility(8);
          }
        }
        if (c.aYj(localas.field_username))
        {
          locala.iZG.setImageResource(R.k.sight_item_sns_icon);
          locala.mNd.setVisibility(8);
          locala.mNb.setText(paramContext.getString(R.l.eTy));
          locala.mrM.setVisibility(8);
          if (c.Jvm)
          {
            locala.contentView.setBackgroundResource(R.g.doY);
            locala.HhP.setVisibility(8);
            c.e(paramContext, locala.contentView);
          }
        }
        for (;;)
        {
          parama = locala.iZG.getLayoutParams();
          parama.width = com.tencent.mm.ci.a.aY(paramContext, R.f.dlJ);
          parama.height = com.tencent.mm.ci.a.aY(paramContext, R.f.dlJ);
          locala.iZG.setLayoutParams(parama);
          parama = (LinearLayout.LayoutParams)locala.mNd.getLayoutParams();
          parama.height = com.tencent.mm.ci.a.aY(paramContext, R.f.dlK);
          parama.width = com.tencent.mm.ci.a.aY(paramContext, R.f.dlK);
          parama.setMargins(parama.leftMargin, parama.topMargin, 0, parama.bottomMargin);
          locala.mNd.setLayoutParams(parama);
          locala.mNd.setBackgroundResource(R.g.doW);
          AppMethodBeat.o(28732);
          return;
          locala.contentView.setBackgroundResource(R.g.doX);
          locala.HhP.setVisibility(0);
          break;
          if (c.aYk(localas.field_username))
          {
            locala.contentView.setVisibility(8);
            locala.Jvp.setVisibility(0);
            AppMethodBeat.o(28732);
            return;
          }
          super.a(paramContext, parama, parama1, paramBoolean1, paramBoolean2);
          locala.contentView.setBackgroundResource(R.g.doY);
          c.e(paramContext, locala.contentView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.ui.c
 * JD-Core Version:    0.7.0.1
 */