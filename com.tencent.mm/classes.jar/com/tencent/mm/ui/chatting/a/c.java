package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  extends RecyclerView.a
{
  public static e Gsh;
  public static f Gsi = null;
  public String Gsj;
  private Context mContext;
  
  public c(Context paramContext, f paramf)
  {
    Gsi = paramf;
    this.mContext = paramContext;
  }
  
  private static long nW(long paramLong)
  {
    AppMethodBeat.i(35050);
    Date localDate = new Date(paramLong);
    paramLong = a.fcX().b(localDate);
    AppMethodBeat.o(35050);
    return paramLong;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(35046);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494231, paramViewGroup, false));
      AppMethodBeat.o(35046);
      return paramViewGroup;
    }
    paramViewGroup = Gsi.y(paramViewGroup);
    AppMethodBeat.o(35046);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(35047);
    int i = getItemViewType(paramInt);
    b localb = Gsi.YJ(paramInt);
    Object localObject;
    if (i == 2147483647)
    {
      localObject = Gsi.YJ(paramInt + 1);
      if ((paramInt == getItemCount() - 1) || (nW(((b)localObject).timestamp) != nW(localb.timestamp)))
      {
        ((d)paramv).ibF.setVisibility(8);
        AppMethodBeat.o(35047);
        return;
      }
      ((d)paramv).ibF.setVisibility(0);
      ((d)paramv).ibF.setText(nV(localb.timestamp));
      AppMethodBeat.o(35047);
      return;
    }
    a locala = (a)paramv;
    locala.rLd.setTag(Integer.valueOf(paramInt));
    a.b.c(locala.frr, localb.username);
    TextView localTextView = locala.imt;
    Context localContext = this.mContext;
    if (bt.isNullOrNil(this.Gsj)) {
      if (bt.isNullOrNil(localb.bNL)) {
        if (bt.isNullOrNil(localb.lLN)) {
          localObject = localb.nickname;
        }
      }
    }
    for (;;)
    {
      localTextView.setText(k.b(localContext, (CharSequence)localObject, locala.imt.getTextSize()));
      locala.fwS.setText(m.h(this.mContext, localb.timestamp));
      locala.ica.setText(localb.title);
      Gsi.a((a)paramv, paramInt);
      if (!bt.isNullOrNil(this.Gsj))
      {
        a.d(locala.imt, this.Gsj);
        a.d(locala.ica, this.Gsj);
      }
      AppMethodBeat.o(35047);
      return;
      localObject = localb.lLN;
      continue;
      localObject = localb.bNL;
      continue;
      if (bt.isNullOrNil(localb.bNL))
      {
        if (!bt.isNullOrNil(localb.lLN))
        {
          if ((!bt.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.Gsj))) {
            localObject = localb.lLN + "(" + localb.nickname + ")";
          } else {
            localObject = localb.lLN;
          }
        }
        else {
          localObject = localb.nickname;
        }
      }
      else if ((!bt.isNullOrNil(localb.lLN)) && (localb.lLN.contains(this.Gsj))) {
        localObject = localb.bNL + "(" + localb.lLN + ")";
      } else if ((!bt.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.Gsj))) {
        localObject = localb.bNL + "(" + localb.nickname + ")";
      } else {
        localObject = localb.bNL;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35048);
    int i;
    if (Gsi == null)
    {
      i = 0;
      if (Gsi != null) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.MediaHistoryListAdapter", " null == mIDetail?%s getItemCount:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(35048);
      return i;
      i = Gsi.getCount();
      break;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35045);
    paramInt = Gsi.YJ(paramInt).getType();
    AppMethodBeat.o(35045);
    return paramInt;
  }
  
  public final String nV(long paramLong)
  {
    AppMethodBeat.i(35049);
    Object localObject = new Date(paramLong);
    localObject = a.fcX().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35049);
    return localObject;
  }
  
  public static class a
    extends RecyclerView.v
  {
    public ImageView frr;
    public TextView fwS;
    public TextView ica;
    public TextView imt;
    public View rLd;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35042);
      this.rLd = paramView;
      this.frr = ((ImageView)paramView.findViewById(2131299761));
      this.imt = ((TextView)paramView.findViewById(2131299814));
      this.fwS = ((TextView)paramView.findViewById(2131299847));
      this.ica = ((TextView)paramView.findViewById(2131299848));
      this.ica.setSingleLine(false);
      this.ica.setMaxLines(2);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35040);
          if (c.eWv() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            c.b localb = c.eWw().YJ(i);
            c.eWv().a(paramAnonymousView, i, localb);
          }
          AppMethodBeat.o(35040);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35041);
          if (c.eWv() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            c.b localb = c.eWw().YJ(i);
            c.eWv().b(paramAnonymousView, i, localb);
          }
          AppMethodBeat.o(35041);
          return true;
        }
      });
      AppMethodBeat.o(35042);
    }
    
    public static void d(TextView paramTextView, String paramString)
    {
      AppMethodBeat.i(35043);
      if (!bt.isNullOrNil(paramString))
      {
        paramTextView.getContext();
        paramTextView.setText(f.a(paramTextView.getText(), paramString));
      }
      AppMethodBeat.o(35043);
    }
  }
  
  public static abstract class b
  {
    Pattern Gsl = Pattern.compile("[._a-zA-Z0-9]+");
    public String bNL;
    public String lLN;
    public long msgId;
    public String nickname;
    public long timestamp;
    public String title;
    public int type;
    public String username;
    
    public b() {}
    
    public b(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      this.timestamp = paramLong1;
      this.type = paramInt;
      this.title = paramString1;
      this.msgId = paramLong2;
      this.username = paramString2;
      this.nickname = paramString3;
      this.bNL = paramString4;
      this.lLN = paramString5;
    }
    
    protected static boolean aKE(String paramString)
    {
      boolean bool2 = false;
      paramString = paramString.toCharArray();
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < paramString.length)
        {
          if ((paramString[i] >= '一') && (paramString[i] <= 40891)) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public boolean aKD(String paramString)
    {
      if (!aKE(paramString))
      {
        if ((!bt.isNullOrNil(this.title)) && (lq(paramString, this.title.toLowerCase()))) {}
        while (((!bt.isNullOrNil(this.nickname)) && (lq(paramString, this.nickname.toLowerCase()))) || ((!bt.isNullOrNil(this.lLN)) && (lq(paramString, this.lLN.toLowerCase()))) || ((!bt.isNullOrNil(this.bNL)) && (lq(paramString, this.bNL.toLowerCase())))) {
          return true;
        }
      }
      do
      {
        return false;
        if (((!bt.isNullOrNil(this.title)) && (this.title.toLowerCase().contains(paramString))) || ((!bt.isNullOrNil(this.nickname)) && (this.nickname.toLowerCase().contains(paramString))) || ((!bt.isNullOrNil(this.lLN)) && (this.lLN.toLowerCase().contains(paramString)))) {
          break;
        }
      } while ((bt.isNullOrNil(this.bNL)) || (!this.bNL.toLowerCase().contains(paramString)));
      return true;
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject != null) && ((paramObject instanceof b))) {
        return this.msgId == ((b)paramObject).msgId;
      }
      return super.equals(paramObject);
    }
    
    public int getType()
    {
      return this.type;
    }
    
    protected final boolean lq(String paramString1, String paramString2)
    {
      if (!bt.isNullOrNil(paramString2))
      {
        paramString2 = this.Gsl.matcher(paramString2);
        boolean bool1 = false;
        while (paramString2.find())
        {
          String str = paramString2.group();
          boolean bool2 = str.startsWith(paramString1);
          ad.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", new Object[] { paramString1, str });
          bool1 = bool2;
          if (bool2) {
            bool1 = bool2;
          }
        }
        return bool1;
      }
      return false;
    }
  }
  
  public final class d
    extends RecyclerView.v
  {
    TextView ibF;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35044);
      this.ibF = ((TextView)paramView.findViewById(2131298930));
      this.ibF.setTextColor(c.a(c.this).getResources().getColor(2131100358));
      paramView.findViewById(2131298739).setBackgroundColor(c.a(c.this).getResources().getColor(2131100352));
      AppMethodBeat.o(35044);
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(View paramView, int paramInt, c.b paramb);
    
    public abstract void b(View paramView, int paramInt, c.b paramb);
  }
  
  public static abstract interface f
  {
    public abstract c.b YJ(int paramInt);
    
    public abstract void a(c.a parama, int paramInt);
    
    public abstract int getCount();
    
    public abstract RecyclerView.v y(ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c
 * JD-Core Version:    0.7.0.1
 */