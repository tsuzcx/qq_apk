package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  extends RecyclerView.a
{
  public static e HRZ;
  public static f HSa = null;
  public String HSb;
  private Context mContext;
  
  public c(Context paramContext, f paramf)
  {
    HSa = paramf;
    this.mContext = paramContext;
  }
  
  private static long rI(long paramLong)
  {
    AppMethodBeat.i(35050);
    Date localDate = new Date(paramLong);
    paramLong = a.fsS().b(localDate);
    AppMethodBeat.o(35050);
    return paramLong;
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(35046);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494231, paramViewGroup, false));
      AppMethodBeat.o(35046);
      return paramViewGroup;
    }
    paramViewGroup = HSa.z(paramViewGroup);
    AppMethodBeat.o(35046);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(35047);
    int i = getItemViewType(paramInt);
    b localb = HSa.aaU(paramInt);
    Object localObject;
    if (i == 2147483647)
    {
      localObject = HSa.aaU(paramInt + 1);
      if ((paramInt == getItemCount() - 1) || (rI(((b)localObject).timestamp) != rI(localb.timestamp)))
      {
        ((d)paramw).iBM.setVisibility(8);
        AppMethodBeat.o(35047);
        return;
      }
      ((d)paramw).iBM.setVisibility(0);
      ((d)paramw).iBM.setText(rH(localb.timestamp));
      AppMethodBeat.o(35047);
      return;
    }
    a locala = (a)paramw;
    locala.sSS.setTag(Integer.valueOf(paramInt));
    a.b.c(locala.fuY, localb.username);
    TextView localTextView = locala.iMz;
    Context localContext = this.mContext;
    if (bs.isNullOrNil(this.HSb)) {
      if (bs.isNullOrNil(localb.bLt)) {
        if (bs.isNullOrNil(localb.mnK)) {
          localObject = localb.nickname;
        }
      }
    }
    for (;;)
    {
      localTextView.setText(k.b(localContext, (CharSequence)localObject, locala.iMz.getTextSize()));
      locala.fAz.setText(m.h(this.mContext, localb.timestamp));
      locala.iCg.setText(localb.title);
      HSa.a((a)paramw, paramInt);
      if (!bs.isNullOrNil(this.HSb))
      {
        a.d(locala.iMz, this.HSb);
        a.d(locala.iCg, this.HSb);
      }
      AppMethodBeat.o(35047);
      return;
      localObject = localb.mnK;
      continue;
      localObject = localb.bLt;
      continue;
      if (bs.isNullOrNil(localb.bLt))
      {
        if (!bs.isNullOrNil(localb.mnK))
        {
          if ((!bs.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.HSb))) {
            localObject = localb.mnK + "(" + localb.nickname + ")";
          } else {
            localObject = localb.mnK;
          }
        }
        else {
          localObject = localb.nickname;
        }
      }
      else if ((!bs.isNullOrNil(localb.mnK)) && (localb.mnK.contains(this.HSb))) {
        localObject = localb.bLt + "(" + localb.mnK + ")";
      } else if ((!bs.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.HSb))) {
        localObject = localb.bLt + "(" + localb.nickname + ")";
      } else {
        localObject = localb.bLt;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35048);
    int i;
    if (HSa == null)
    {
      i = 0;
      if (HSa != null) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.MediaHistoryListAdapter", " null == mIDetail?%s getItemCount:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(35048);
      return i;
      i = HSa.getCount();
      break;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35045);
    paramInt = HSa.aaU(paramInt).getType();
    AppMethodBeat.o(35045);
    return paramInt;
  }
  
  public final String rH(long paramLong)
  {
    AppMethodBeat.i(35049);
    Object localObject = new Date(paramLong);
    localObject = a.fsS().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35049);
    return localObject;
  }
  
  public static class a
    extends RecyclerView.w
  {
    public TextView fAz;
    public ImageView fuY;
    public TextView iCg;
    public TextView iMz;
    public View sSS;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35042);
      this.sSS = paramView;
      this.fuY = ((ImageView)paramView.findViewById(2131299761));
      this.iMz = ((TextView)paramView.findViewById(2131299814));
      this.fAz = ((TextView)paramView.findViewById(2131299847));
      this.iCg = ((TextView)paramView.findViewById(2131299848));
      this.iCg.setSingleLine(false);
      this.iCg.setMaxLines(2);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35040);
          if (c.fmh() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            c.b localb = c.fmi().aaU(i);
            c.fmh().a(paramAnonymousView, i, localb);
          }
          AppMethodBeat.o(35040);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35041);
          if (c.fmh() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            c.b localb = c.fmi().aaU(i);
            c.fmh().b(paramAnonymousView, i, localb);
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
      if (!bs.isNullOrNil(paramString))
      {
        paramTextView.getContext();
        paramTextView.setText(f.b(paramTextView.getText(), paramString));
      }
      AppMethodBeat.o(35043);
    }
  }
  
  public static abstract class b
  {
    Pattern HSd = Pattern.compile("[._a-zA-Z0-9]+");
    public String bLt;
    public String mnK;
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
      this.bLt = paramString4;
      this.mnK = paramString5;
    }
    
    protected static boolean aQh(String paramString)
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
    
    public boolean aQg(String paramString)
    {
      if (!aQh(paramString))
      {
        if ((!bs.isNullOrNil(this.title)) && (lN(paramString, this.title.toLowerCase()))) {}
        while (((!bs.isNullOrNil(this.nickname)) && (lN(paramString, this.nickname.toLowerCase()))) || ((!bs.isNullOrNil(this.mnK)) && (lN(paramString, this.mnK.toLowerCase()))) || ((!bs.isNullOrNil(this.bLt)) && (lN(paramString, this.bLt.toLowerCase())))) {
          return true;
        }
      }
      do
      {
        return false;
        if (((!bs.isNullOrNil(this.title)) && (this.title.toLowerCase().contains(paramString))) || ((!bs.isNullOrNil(this.nickname)) && (this.nickname.toLowerCase().contains(paramString))) || ((!bs.isNullOrNil(this.mnK)) && (this.mnK.toLowerCase().contains(paramString)))) {
          break;
        }
      } while ((bs.isNullOrNil(this.bLt)) || (!this.bLt.toLowerCase().contains(paramString)));
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
    
    protected final boolean lN(String paramString1, String paramString2)
    {
      if (!bs.isNullOrNil(paramString2))
      {
        paramString2 = this.HSd.matcher(paramString2);
        boolean bool1 = false;
        while (paramString2.find())
        {
          String str = paramString2.group();
          boolean bool2 = str.startsWith(paramString1);
          ac.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", new Object[] { paramString1, str });
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
  
  public static final class c
    extends c.b
  {
    public c(long paramLong)
    {
      this.timestamp = paramLong;
    }
    
    public final boolean aQg(String paramString)
    {
      return false;
    }
    
    public final int getType()
    {
      return 2147483647;
    }
  }
  
  public final class d
    extends RecyclerView.w
  {
    TextView iBM;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35044);
      this.iBM = ((TextView)paramView.findViewById(2131298930));
      this.iBM.setTextColor(c.a(c.this).getResources().getColor(2131100358));
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
    public abstract void a(c.a parama, int paramInt);
    
    public abstract c.b aaU(int paramInt);
    
    public abstract int getCount();
    
    public abstract RecyclerView.w z(ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c
 * JD-Core Version:    0.7.0.1
 */