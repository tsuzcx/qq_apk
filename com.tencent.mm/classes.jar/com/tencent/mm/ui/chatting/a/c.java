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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  extends RecyclerView.a
{
  public static e Pme;
  public static f Pmf = null;
  public String Pmg;
  private Context mContext;
  
  public c(Context paramContext, f paramf)
  {
    Pmf = paramf;
    this.mContext = paramContext;
  }
  
  private static long Cd(long paramLong)
  {
    AppMethodBeat.i(35050);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.gWr().b(localDate);
    AppMethodBeat.o(35050);
    return paramLong;
  }
  
  public final String Cc(long paramLong)
  {
    AppMethodBeat.i(35049);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.gWr().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35049);
    return localObject;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(35046);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494792, paramViewGroup, false));
      AppMethodBeat.o(35046);
      return paramViewGroup;
    }
    if (paramInt == 2147483646)
    {
      paramViewGroup = new RecyclerView.v(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131494761, paramViewGroup, false)) {};
      AppMethodBeat.o(35046);
      return paramViewGroup;
    }
    paramViewGroup = Pmf.N(paramViewGroup);
    AppMethodBeat.o(35046);
    return paramViewGroup;
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(35047);
    int i = getItemViewType(paramInt);
    b localb = Pmf.amy(paramInt);
    Object localObject;
    if (i == 2147483647)
    {
      localObject = Pmf.amy(paramInt + 1);
      if ((paramInt == getItemCount() - 1) || (Cd(((b)localObject).timestamp) != Cd(localb.timestamp)))
      {
        ((d)paramv).jUO.setVisibility(8);
        AppMethodBeat.o(35047);
        return;
      }
      ((d)paramv).jUO.setVisibility(0);
      ((d)paramv).jUO.setText(Cc(localb.timestamp));
      AppMethodBeat.o(35047);
      return;
    }
    a locala;
    TextView localTextView;
    Context localContext;
    if (i != 2147483646)
    {
      locala = (a)paramv;
      locala.convertView.setTag(Integer.valueOf(paramInt));
      a.b.c(locala.gvv, localb.username);
      localTextView = locala.kgE;
      localContext = this.mContext;
      if (!Util.isNullOrNil(this.Pmg)) {
        break label340;
      }
      if (!Util.isNullOrNil(localb.cgo)) {
        break label330;
      }
      if (!Util.isNullOrNil(localb.ogt)) {
        break label320;
      }
      localObject = localb.nickname;
    }
    for (;;)
    {
      localTextView.setText(l.b(localContext, (CharSequence)localObject, locala.kgE.getTextSize()));
      locala.timeTV.setText(m.h(this.mContext, localb.timestamp));
      locala.jVO.setText(localb.title);
      Pmf.a((a)paramv, paramInt);
      if (!Util.isNullOrNil(this.Pmg))
      {
        a.g(locala.kgE, this.Pmg);
        a.g(locala.jVO, this.Pmg);
      }
      AppMethodBeat.o(35047);
      return;
      label320:
      localObject = localb.ogt;
      continue;
      label330:
      localObject = localb.cgo;
      continue;
      label340:
      if (Util.isNullOrNil(localb.cgo))
      {
        if (!Util.isNullOrNil(localb.ogt))
        {
          if ((!Util.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.Pmg))) {
            localObject = localb.ogt + "(" + localb.nickname + ")";
          } else {
            localObject = localb.ogt;
          }
        }
        else {
          localObject = localb.nickname;
        }
      }
      else if ((!Util.isNullOrNil(localb.ogt)) && (localb.ogt.contains(this.Pmg))) {
        localObject = localb.cgo + "(" + localb.ogt + ")";
      } else if ((!Util.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.Pmg))) {
        localObject = localb.cgo + "(" + localb.nickname + ")";
      } else {
        localObject = localb.cgo;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35048);
    int i;
    if (Pmf == null)
    {
      i = 0;
      if (Pmf != null) {
        break label67;
      }
    }
    label67:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MediaHistoryListAdapter", " null == mIDetail?%s getItemCount:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(35048);
      return i;
      i = Pmf.getCount();
      break;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35045);
    paramInt = Pmf.amy(paramInt).getType();
    AppMethodBeat.o(35045);
    return paramInt;
  }
  
  public static class a
    extends RecyclerView.v
  {
    public View convertView;
    public ImageView gvv;
    public TextView jVO;
    public TextView kgE;
    public TextView timeTV;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35042);
      this.convertView = paramView;
      this.gvv = ((ImageView)paramView.findViewById(2131300432));
      this.kgE = ((TextView)paramView.findViewById(2131300489));
      this.timeTV = ((TextView)paramView.findViewById(2131300525));
      this.jVO = ((TextView)paramView.findViewById(2131300526));
      this.jVO.setSingleLine(false);
      this.jVO.setMaxLines(2);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35040);
          Object localObject = new b();
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
          if (c.gOI() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = c.gOJ().amy(i);
            c.gOI().a(paramAnonymousView, i, (c.b)localObject);
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
          ((b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).axR());
          if (c.gOI() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = c.gOJ().amy(i);
            c.gOI().b(paramAnonymousView, i, (c.b)localObject);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(35041);
          return true;
        }
      });
      AppMethodBeat.o(35042);
    }
    
    public static void g(TextView paramTextView, String paramString)
    {
      AppMethodBeat.i(35043);
      if (!Util.isNullOrNil(paramString))
      {
        paramTextView.getContext();
        paramTextView.setText(f.b(paramTextView.getText(), paramString));
      }
      AppMethodBeat.o(35043);
    }
  }
  
  public static abstract class b
  {
    Pattern Pmj = Pattern.compile("[._a-zA-Z0-9]+");
    public String cgo;
    public long msgId;
    public String nickname;
    public String ogt;
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
      this.cgo = paramString4;
      this.ogt = paramString5;
    }
    
    protected static boolean bmD(String paramString)
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
    
    public boolean bmC(String paramString)
    {
      if (!bmD(paramString))
      {
        if ((!Util.isNullOrNil(this.title)) && (ng(paramString, this.title.toLowerCase()))) {}
        while (((!Util.isNullOrNil(this.nickname)) && (ng(paramString, this.nickname.toLowerCase()))) || ((!Util.isNullOrNil(this.ogt)) && (ng(paramString, this.ogt.toLowerCase()))) || ((!Util.isNullOrNil(this.cgo)) && (ng(paramString, this.cgo.toLowerCase())))) {
          return true;
        }
      }
      do
      {
        return false;
        if (((!Util.isNullOrNil(this.title)) && (this.title.toLowerCase().contains(paramString))) || ((!Util.isNullOrNil(this.nickname)) && (this.nickname.toLowerCase().contains(paramString))) || ((!Util.isNullOrNil(this.ogt)) && (this.ogt.toLowerCase().contains(paramString)))) {
          break;
        }
      } while ((Util.isNullOrNil(this.cgo)) || (!this.cgo.toLowerCase().contains(paramString)));
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
    
    protected final boolean ng(String paramString1, String paramString2)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        paramString2 = this.Pmj.matcher(paramString2);
        boolean bool1 = false;
        while (paramString2.find())
        {
          String str = paramString2.group();
          boolean bool2 = str.startsWith(paramString1);
          Log.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", new Object[] { paramString1, str });
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
    
    public final boolean bmC(String paramString)
    {
      return false;
    }
    
    public final int getType()
    {
      return 2147483647;
    }
  }
  
  public final class d
    extends RecyclerView.v
  {
    TextView jUO;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35044);
      this.jUO = ((TextView)paramView.findViewById(2131299414));
      this.jUO.setTextColor(c.a(c.this).getResources().getColor(2131100393));
      paramView.findViewById(2131299180).setBackgroundColor(c.a(c.this).getResources().getColor(2131100387));
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
    public abstract RecyclerView.v N(ViewGroup paramViewGroup);
    
    public abstract void a(c.a parama, int paramInt);
    
    public abstract c.b amy(int paramInt);
    
    public abstract int getCount();
  }
  
  public static final class g
    extends c.b
  {
    public final int getType()
    {
      return 2147483646;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c
 * JD-Core Version:    0.7.0.1
 */