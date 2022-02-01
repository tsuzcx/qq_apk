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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c
  extends RecyclerView.a
{
  public static e WFP;
  public static f WFQ = null;
  public String WFR;
  private Context mContext;
  
  public c(Context paramContext, f paramf)
  {
    WFQ = paramf;
    this.mContext = paramContext;
  }
  
  private static long Im(long paramLong)
  {
    AppMethodBeat.i(35050);
    Date localDate = new Date(paramLong);
    paramLong = com.tencent.mm.ui.gridviewheaders.a.hWZ().b(localDate);
    AppMethodBeat.o(35050);
    return paramLong;
  }
  
  public final String Il(long paramLong)
  {
    AppMethodBeat.i(35049);
    Object localObject = new Date(paramLong);
    localObject = com.tencent.mm.ui.gridviewheaders.a.hWZ().a((Date)localObject, this.mContext);
    AppMethodBeat.o(35049);
    return localObject;
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(275620);
    if (paramInt == 2147483647)
    {
      paramViewGroup = new d(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.ehs, paramViewGroup, false));
      AppMethodBeat.o(275620);
      return paramViewGroup;
    }
    if (paramInt == 2147483646)
    {
      paramViewGroup = new RecyclerView.v(LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.fts_loading_footer, paramViewGroup, false)) {};
      AppMethodBeat.o(275620);
      return paramViewGroup;
    }
    paramViewGroup = WFQ.V(paramViewGroup);
    AppMethodBeat.o(275620);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(275621);
    int i = getItemViewType(paramInt);
    b localb = WFQ.avy(paramInt);
    Object localObject;
    if (i == 2147483647)
    {
      localObject = WFQ.avy(paramInt + 1);
      if ((paramInt == getItemCount() - 1) || (Im(((b)localObject).timestamp) != Im(localb.timestamp)))
      {
        ((d)paramv).mMb.setVisibility(8);
        AppMethodBeat.o(275621);
        return;
      }
      ((d)paramv).mMb.setVisibility(0);
      ((d)paramv).mMb.setText(Il(localb.timestamp));
      AppMethodBeat.o(275621);
      return;
    }
    a locala;
    TextView localTextView;
    Context localContext;
    if (i != 2147483646)
    {
      locala = (a)paramv;
      locala.convertView.setTag(Integer.valueOf(paramInt));
      a.b.c(locala.iZG, localb.username);
      localTextView = locala.mYd;
      localContext = this.mContext;
      if (!Util.isNullOrNil(this.WFR)) {
        break label340;
      }
      if (!Util.isNullOrNil(localb.cip)) {
        break label330;
      }
      if (!Util.isNullOrNil(localb.rif)) {
        break label320;
      }
      localObject = localb.nickname;
    }
    for (;;)
    {
      localTextView.setText(l.b(localContext, (CharSequence)localObject, locala.mYd.getTextSize()));
      locala.timeTV.setText(m.h(this.mContext, localb.timestamp));
      locala.mNb.setText(localb.title);
      WFQ.a((a)paramv, paramInt);
      if (!Util.isNullOrNil(this.WFR))
      {
        a.h(locala.mYd, this.WFR);
        a.h(locala.mNb, this.WFR);
      }
      AppMethodBeat.o(275621);
      return;
      label320:
      localObject = localb.rif;
      continue;
      label330:
      localObject = localb.cip;
      continue;
      label340:
      if (Util.isNullOrNil(localb.cip))
      {
        if (!Util.isNullOrNil(localb.rif))
        {
          if ((!Util.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.WFR))) {
            localObject = localb.rif + "(" + localb.nickname + ")";
          } else {
            localObject = localb.rif;
          }
        }
        else {
          localObject = localb.nickname;
        }
      }
      else if ((!Util.isNullOrNil(localb.rif)) && (localb.rif.contains(this.WFR))) {
        localObject = localb.cip + "(" + localb.rif + ")";
      } else if ((!Util.isNullOrNil(localb.nickname)) && (localb.nickname.contains(this.WFR))) {
        localObject = localb.cip + "(" + localb.nickname + ")";
      } else {
        localObject = localb.cip;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(35048);
    int i;
    if (WFQ == null)
    {
      i = 0;
      if (WFQ != null) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MediaHistoryListAdapter", " null == mIDetail?%s getItemCount:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
      AppMethodBeat.o(35048);
      return i;
      i = WFQ.getCount();
      break;
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(35045);
    paramInt = WFQ.avy(paramInt).getType();
    AppMethodBeat.o(35045);
    return paramInt;
  }
  
  public static class a
    extends RecyclerView.v
  {
    public View convertView;
    public ImageView iZG;
    public TextView mNb;
    public TextView mYd;
    public TextView timeTV;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(35042);
      this.convertView = paramView;
      this.iZG = ((ImageView)paramView.findViewById(R.h.fav_avatar));
      this.mYd = ((TextView)paramView.findViewById(R.h.fav_name));
      this.timeTV = ((TextView)paramView.findViewById(R.h.fav_time));
      this.mNb = ((TextView)paramView.findViewById(R.h.fav_title));
      this.mNb.setSingleLine(false);
      this.mNb.setMaxLines(2);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(35040);
          Object localObject = new b();
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
          if (c.hNU() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = c.hNV().avy(i);
            c.hNU().a(paramAnonymousView, i, (c.b)localObject);
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
          ((b)localObject).bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject).aFi());
          if (c.hNU() != null)
          {
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            localObject = c.hNV().avy(i);
            c.hNU().b(paramAnonymousView, i, (c.b)localObject);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/chatting/adapter/MediaHistoryListAdapter$BaseHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(35041);
          return true;
        }
      });
      AppMethodBeat.o(35042);
    }
    
    public static void h(TextView paramTextView, String paramString)
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
    Pattern WFU = Pattern.compile("[._a-zA-Z0-9]+");
    public String cip;
    public long msgId;
    public String nickname;
    public String rif;
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
      this.cip = paramString4;
      this.rif = paramString5;
    }
    
    protected static boolean bze(String paramString)
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
    
    public boolean bzd(String paramString)
    {
      if (!bze(paramString))
      {
        if ((!Util.isNullOrNil(this.title)) && (nZ(paramString, this.title.toLowerCase()))) {}
        while (((!Util.isNullOrNil(this.nickname)) && (nZ(paramString, this.nickname.toLowerCase()))) || ((!Util.isNullOrNil(this.rif)) && (nZ(paramString, this.rif.toLowerCase()))) || ((!Util.isNullOrNil(this.cip)) && (nZ(paramString, this.cip.toLowerCase())))) {
          return true;
        }
      }
      do
      {
        return false;
        if (((!Util.isNullOrNil(this.title)) && (this.title.toLowerCase().contains(paramString))) || ((!Util.isNullOrNil(this.nickname)) && (this.nickname.toLowerCase().contains(paramString))) || ((!Util.isNullOrNil(this.rif)) && (this.rif.toLowerCase().contains(paramString)))) {
          break;
        }
      } while ((Util.isNullOrNil(this.cip)) || (!this.cip.toLowerCase().contains(paramString)));
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
    
    protected final boolean nZ(String paramString1, String paramString2)
    {
      if (!Util.isNullOrNil(paramString2))
      {
        paramString2 = this.WFU.matcher(paramString2);
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
    
    public final boolean bzd(String paramString)
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
    TextView mMb;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(35044);
      this.mMb = ((TextView)paramView.findViewById(R.h.date_info));
      this.mMb.setTextColor(c.a(c.this).getResources().getColor(R.e.fav_record_date_color));
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
    public abstract RecyclerView.v V(ViewGroup paramViewGroup);
    
    public abstract void a(c.a parama, int paramInt);
    
    public abstract c.b avy(int paramInt);
    
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c
 * JD-Core Version:    0.7.0.1
 */