package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  extends RecyclerView.a
{
  public static e aens;
  public static f aent = null;
  public String aenu;
  private Context mContext;
  
  public c(Context paramContext, f paramf)
  {
    aent = paramf;
    this.mContext = paramContext;
  }
  
  private static long kE(long paramLong)
  {
    AppMethodBeat.i(35050);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.jBw().b(localDate);
    AppMethodBeat.o(35050);
    return paramLong;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(254375);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gkn, paramViewGroup, false));
      AppMethodBeat.o(254375);
      return paramViewGroup;
    }
    if (paramInt == 2147483646)
    {
      paramViewGroup = new RecyclerView.v(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.fts_loading_footer, paramViewGroup, false)) {};
      AppMethodBeat.o(254375);
      return paramViewGroup;
    }
    paramViewGroup = aent.af(paramViewGroup);
    AppMethodBeat.o(254375);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(254380);
    int i = getItemViewType(paramInt);
    b localb = aent.aCa(paramInt);
    Object localObject;
    if (i == 2147483647)
    {
      localObject = aent.aCa(paramInt + 1);
      if ((paramInt == getItemCount() - 1) || (kE(((b)localObject).timestamp) != kE(localb.timestamp)))
      {
        ((d)paramv).pIJ.setVisibility(8);
        AppMethodBeat.o(254380);
        return;
      }
      ((d)paramv).pIJ.setVisibility(0);
      ((d)paramv).pIJ.setText(kD(localb.timestamp));
      AppMethodBeat.o(254380);
      return;
    }
    a locala;
    TextView localTextView;
    Context localContext;
    if (i != 2147483646)
    {
      locala = (a)paramv;
      locala.convertView.setTag(Integer.valueOf(paramInt));
      a.b.g(locala.lBC, localb.username);
      localTextView = locala.pUL;
      localContext = this.mContext;
      if (!Util.isNullOrNil(this.aenu)) {
        break label340;
      }
      if (!Util.isNullOrNil(localb.dYO)) {
        break label330;
      }
      if (!Util.isNullOrNil(localb.uqb)) {
        break label320;
      }
      localObject = localb.nickname;
    }
    for (;;)
    {
      localTextView.setText(p.b(localContext, (CharSequence)localObject, locala.pUL.getTextSize()));
      locala.timeTV.setText(m.h(this.mContext, localb.timestamp));
      locala.pJJ.setText(localb.title);
      aent.a((a)paramv, paramInt);
      if (!Util.isNullOrNil(this.aenu))
      {
        a.i(locala.pUL, this.aenu);
        a.i(locala.pJJ, this.aenu);
      }
      AppMethodBeat.o(254380);
      return;
      label320:
      localObject = localb.uqb;
      continue;
      label330:
      localObject = localb.dYO;
      continue;
      label340:
      if (Util.isNullOrNil(localb.dYO))
      {
        if (!Util.isNullOrNil(localb.uqb))
        {
          if ((!Util.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.aenu))) {
            localObject = localb.uqb + "(" + localb.nickname + ")";
          } else {
            localObject = localb.uqb;
          }
        }
        else {
          localObject = localb.nickname;
        }
      }
      else if ((!Util.isNullOrNil(localb.uqb)) && (localb.uqb.contains(this.aenu))) {
        localObject = localb.dYO + "(" + localb.uqb + ")";
      } else if ((!Util.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.aenu))) {
        localObject = localb.dYO + "(" + localb.nickname + ")";
      } else {
        localObject = localb.dYO;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35048);
    int i;
    if (aent == null)
    {
      i = 0;
      if (aent != null) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MediaHistoryListAdapter", " null == mIDetail?%s getItemCount:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(35048);
      return i;
      i = aent.getCount();
      break;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35045);
    paramInt = aent.aCa(paramInt).getType();
    AppMethodBeat.o(35045);
    return paramInt;
  }
  
  public final String kD(long paramLong)
  {
    AppMethodBeat.i(35049);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.jBw().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35049);
    return localObject;
  }
  
  public static class a
    extends RecyclerView.v
  {
    public View convertView;
    public ImageView lBC;
    public TextView pJJ;
    public TextView pUL;
    public TextView timeTV;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35042);
      this.convertView = paramView;
      this.lBC = ((ImageView)paramView.findViewById(R.h.fav_avatar));
      this.pUL = ((TextView)paramView.findViewById(R.h.fav_name));
      this.timeTV = ((TextView)paramView.findViewById(R.h.fav_time));
      this.pJJ = ((TextView)paramView.findViewById(R.h.fav_title));
      this.pJJ.setSingleLine(false);
      this.pJJ.setMaxLines(2);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35040);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          if (c.jqB() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = c.jqC().aCa(i);
            c.jqB().a(paramAnonymousView, i, (c.b)localObject);
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
          ((b)localObject).cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aYj());
          if (c.jqB() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = c.jqC().aCa(i);
            c.jqB().b(paramAnonymousView, i, (c.b)localObject);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(35041);
          return true;
        }
      });
      AppMethodBeat.o(35042);
    }
    
    public static void i(TextView paramTextView, String paramString)
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
    Pattern aenx = Pattern.compile("[._a-zA-Z0-9]+");
    public String dYO;
    public long msgId;
    public String nickname;
    public long timestamp;
    public String title;
    public int type;
    public String uqb;
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
      this.dYO = paramString4;
      this.uqb = paramString5;
    }
    
    protected static boolean bAI(String paramString)
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
    
    public boolean bAH(String paramString)
    {
      if (!bAI(paramString))
      {
        if ((!Util.isNullOrNil(this.title)) && (pY(paramString, this.title.toLowerCase()))) {}
        while (((!Util.isNullOrNil(this.nickname)) && (pY(paramString, this.nickname.toLowerCase()))) || ((!Util.isNullOrNil(this.uqb)) && (pY(paramString, this.uqb.toLowerCase()))) || ((!Util.isNullOrNil(this.dYO)) && (pY(paramString, this.dYO.toLowerCase())))) {
          return true;
        }
      }
      do
      {
        return false;
        if (((!Util.isNullOrNil(this.title)) && (this.title.toLowerCase().contains(paramString))) || ((!Util.isNullOrNil(this.nickname)) && (this.nickname.toLowerCase().contains(paramString))) || ((!Util.isNullOrNil(this.uqb)) && (this.uqb.toLowerCase().contains(paramString)))) {
          break;
        }
      } while ((Util.isNullOrNil(this.dYO)) || (!this.dYO.toLowerCase().contains(paramString)));
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
    
    protected final boolean pY(String paramString1, String paramString2)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        paramString2 = this.aenx.matcher(paramString2);
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
    
    public final boolean bAH(String paramString)
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
    TextView pIJ;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35044);
      this.pIJ = ((TextView)paramView.findViewById(R.h.date_info));
      this.pIJ.setTextColor(c.a(c.this).getResources().getColor(R.e.fav_record_date_color));
      paramView.findViewById(R.h.content).setBackgroundColor(c.a(c.this).getResources().getColor(R.e.fav_listitem_divider_bg));
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
    
    public abstract c.b aCa(int paramInt);
    
    public abstract RecyclerView.v af(ViewGroup paramViewGroup);
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c
 * JD-Core Version:    0.7.0.1
 */