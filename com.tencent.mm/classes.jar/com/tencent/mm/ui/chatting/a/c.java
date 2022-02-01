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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  extends RecyclerView.a
{
  public static e JFR;
  public static f JFS = null;
  public String JFT;
  private Context mContext;
  
  public c(Context paramContext, f paramf)
  {
    JFS = paramf;
    this.mContext = paramContext;
  }
  
  private static long tH(long paramLong)
  {
    AppMethodBeat.i(35050);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.fJG().b(localDate);
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
    paramViewGroup = JFS.D(paramViewGroup);
    AppMethodBeat.o(35046);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(35047);
    int i = getItemViewType(paramInt);
    b localb = JFS.adg(paramInt);
    Object localObject;
    if (i == 2147483647)
    {
      localObject = JFS.adg(paramInt + 1);
      if ((paramInt == getItemCount() - 1) || (tH(((b)localObject).timestamp) != tH(localb.timestamp)))
      {
        ((d)paramw).iUW.setVisibility(8);
        AppMethodBeat.o(35047);
        return;
      }
      ((d)paramw).iUW.setVisibility(0);
      ((d)paramw).iUW.setText(tG(localb.timestamp));
      AppMethodBeat.o(35047);
      return;
    }
    a locala = (a)paramw;
    locala.tPw.setTag(Integer.valueOf(paramInt));
    a.b.c(locala.fOf, localb.username);
    TextView localTextView = locala.jfJ;
    Context localContext = this.mContext;
    if (bt.isNullOrNil(this.JFT)) {
      if (bt.isNullOrNil(localb.bVG)) {
        if (bt.isNullOrNil(localb.mOm)) {
          localObject = localb.nickname;
        }
      }
    }
    for (;;)
    {
      localTextView.setText(k.b(localContext, (CharSequence)localObject, locala.jfJ.getTextSize()));
      locala.fTP.setText(m.h(this.mContext, localb.timestamp));
      locala.iVq.setText(localb.title);
      JFS.a((a)paramw, paramInt);
      if (!bt.isNullOrNil(this.JFT))
      {
        a.d(locala.jfJ, this.JFT);
        a.d(locala.iVq, this.JFT);
      }
      AppMethodBeat.o(35047);
      return;
      localObject = localb.mOm;
      continue;
      localObject = localb.bVG;
      continue;
      if (bt.isNullOrNil(localb.bVG))
      {
        if (!bt.isNullOrNil(localb.mOm))
        {
          if ((!bt.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.JFT))) {
            localObject = localb.mOm + "(" + localb.nickname + ")";
          } else {
            localObject = localb.mOm;
          }
        }
        else {
          localObject = localb.nickname;
        }
      }
      else if ((!bt.isNullOrNil(localb.mOm)) && (localb.mOm.contains(this.JFT))) {
        localObject = localb.bVG + "(" + localb.mOm + ")";
      } else if ((!bt.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.JFT))) {
        localObject = localb.bVG + "(" + localb.nickname + ")";
      } else {
        localObject = localb.bVG;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35048);
    int i;
    if (JFS == null)
    {
      i = 0;
      if (JFS != null) {
        break label65;
      }
    }
    label65:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.MediaHistoryListAdapter", " null == mIDetail?%s getItemCount:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(35048);
      return i;
      i = JFS.getCount();
      break;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35045);
    paramInt = JFS.adg(paramInt).getType();
    AppMethodBeat.o(35045);
    return paramInt;
  }
  
  public final String tG(long paramLong)
  {
    AppMethodBeat.i(35049);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.fJG().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35049);
    return localObject;
  }
  
  public static class a
    extends RecyclerView.w
  {
    public ImageView fOf;
    public TextView fTP;
    public TextView iVq;
    public TextView jfJ;
    public View tPw;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35042);
      this.tPw = paramView;
      this.fOf = ((ImageView)paramView.findViewById(2131299761));
      this.jfJ = ((TextView)paramView.findViewById(2131299814));
      this.fTP = ((TextView)paramView.findViewById(2131299847));
      this.iVq = ((TextView)paramView.findViewById(2131299848));
      this.iVq.setSingleLine(false);
      this.iVq.setMaxLines(2);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35040);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          if (c.fCA() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = c.fCB().adg(i);
            c.fCA().a(paramAnonymousView, i, (c.b)localObject);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(35040);
        }
      });
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35041);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).ahq());
          if (c.fCA() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = c.fCB().adg(i);
            c.fCA().b(paramAnonymousView, i, (c.b)localObject);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
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
        paramTextView.setText(f.b(paramTextView.getText(), paramString));
      }
      AppMethodBeat.o(35043);
    }
  }
  
  public static abstract class b
  {
    Pattern JFV = Pattern.compile("[._a-zA-Z0-9]+");
    public String bVG;
    public String mOm;
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
      this.bVG = paramString4;
      this.mOm = paramString5;
    }
    
    protected static boolean aVY(String paramString)
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
    
    public boolean aVX(String paramString)
    {
      if (!aVY(paramString))
      {
        if ((!bt.isNullOrNil(this.title)) && (ml(paramString, this.title.toLowerCase()))) {}
        while (((!bt.isNullOrNil(this.nickname)) && (ml(paramString, this.nickname.toLowerCase()))) || ((!bt.isNullOrNil(this.mOm)) && (ml(paramString, this.mOm.toLowerCase()))) || ((!bt.isNullOrNil(this.bVG)) && (ml(paramString, this.bVG.toLowerCase())))) {
          return true;
        }
      }
      do
      {
        return false;
        if (((!bt.isNullOrNil(this.title)) && (this.title.toLowerCase().contains(paramString))) || ((!bt.isNullOrNil(this.nickname)) && (this.nickname.toLowerCase().contains(paramString))) || ((!bt.isNullOrNil(this.mOm)) && (this.mOm.toLowerCase().contains(paramString)))) {
          break;
        }
      } while ((bt.isNullOrNil(this.bVG)) || (!this.bVG.toLowerCase().contains(paramString)));
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
    
    protected final boolean ml(String paramString1, String paramString2)
    {
      if (!bt.isNullOrNil(paramString2))
      {
        paramString2 = this.JFV.matcher(paramString2);
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
  
  public static final class c
    extends c.b
  {
    public c(long paramLong)
    {
      this.timestamp = paramLong;
    }
    
    public final boolean aVX(String paramString)
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
    TextView iUW;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35044);
      this.iUW = ((TextView)paramView.findViewById(2131298930));
      this.iUW.setTextColor(c.a(c.this).getResources().getColor(2131100358));
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
    public abstract RecyclerView.w D(ViewGroup paramViewGroup);
    
    public abstract void a(c.a parama, int paramInt);
    
    public abstract c.b adg(int paramInt);
    
    public abstract int getCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c
 * JD-Core Version:    0.7.0.1
 */