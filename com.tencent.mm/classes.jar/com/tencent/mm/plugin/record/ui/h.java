package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class h
  extends BaseAdapter
{
  i HDG;
  public String HDO = "";
  public String HDP = "";
  public int HDQ = -1;
  public String HDR = "";
  protected MMHandler HDS = null;
  SparseArray<b> HDT = new SparseArray();
  boolean HDU = false;
  boolean HDV = false;
  private boolean HDW = false;
  protected a HDX;
  protected a HDY;
  public int HDZ = 0;
  protected List<anm> HDy = new LinkedList();
  protected Context context;
  ListView mListView;
  private int padding = com.tencent.mm.ci.a.fromDPToPix(this.context, 35);
  private Runnable wJw = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(27870);
      Log.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
      h.this.notifyDataSetChanged();
      AppMethodBeat.o(27870);
    }
  };
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.HDS = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(27869);
        if (paramAnonymousMessage.what == 1)
        {
          Log.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
          h.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(27869);
      }
    };
    this.HDY = parama;
  }
  
  private static void aVB(String paramString)
  {
    if (!ab.Ql(paramString))
    {
      j localj = new j();
      localj.username = paramString;
      com.tencent.mm.am.q.bhP().b(localj);
    }
  }
  
  private anm ace(int paramInt)
  {
    if (this.HDy == null) {}
    while ((paramInt < 0) || (paramInt >= this.HDy.size())) {
      return null;
    }
    return (anm)this.HDy.get(paramInt);
  }
  
  private static int o(anm paramanm)
  {
    switch (paramanm.dataType)
    {
    default: 
      return 3;
    case 2: 
      return 1;
    case 1: 
      return 0;
    }
    return 2;
  }
  
  public abstract void a(a parama);
  
  public abstract void d(com.tencent.mm.plugin.record.ui.a.b paramb);
  
  public final void destroy()
  {
    int i = 0;
    while (i < this.HDT.size())
    {
      b localb = (b)this.HDT.valueAt(i);
      if (localb != null) {
        localb.destroy();
      }
      i += 1;
    }
    if (this.HDY != null)
    {
      this.HDY.fuw();
      this.HDY = null;
    }
  }
  
  public final void fuD()
  {
    this.HDT.put(0, new d(this.context));
    this.HDT.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.HDY, this.mListView));
    this.HDT.put(2, new com.tencent.mm.plugin.record.ui.b.e());
    com.tencent.mm.plugin.record.ui.b.b localb = new com.tencent.mm.plugin.record.ui.b.b(this.HDY, this.HDS);
    localb.HDO = this.HDO;
    localb.HDP = this.HDP;
    localb.HDQ = this.HDQ;
    localb.HFk = this.HDR;
    localb.fromScene = getFromScene();
    this.HDT.put(3, localb);
    this.HDT.put(4, new com.tencent.mm.plugin.record.ui.b.c(this.HDY));
  }
  
  protected final void fuE()
  {
    this.HDS.post(this.wJw);
  }
  
  public int getCount()
  {
    if (this.HDy == null) {
      return 0;
    }
    return this.HDy.size();
  }
  
  protected abstract int getFromScene();
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return o(ace(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    anm localanm = ace(paramInt);
    Object localObject1 = (b)this.HDT.get(o(localanm));
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((b)localObject1).createView(this.context);
    }
    ImageView localImageView;
    Object localObject3;
    Object localObject4;
    label235:
    String[] arrayOfString;
    switch (localanm.dataType)
    {
    default: 
      paramView = new com.tencent.mm.plugin.record.ui.a.b();
      paramView.fDI = localanm;
      paramView.HDO = this.HDO;
      paramView.HEV = this.HDP;
      d(paramView);
      ((b)localObject1).a(paramViewGroup, paramInt, paramView, this.HDG);
      localImageView = (ImageView)paramViewGroup.findViewById(R.h.dSr);
      localObject3 = (TextView)paramViewGroup.findViewById(R.h.dSv);
      localObject1 = localanm.SyI;
      paramView = (View)localObject1;
      if (localanm.SyG != null)
      {
        localObject4 = localanm.SyG.Szn;
        if (!((ano)localObject4).SAc) {
          break;
        }
        localObject4 = aa.PK(((ano)localObject4).SAb);
        paramView = (View)localObject1;
        if (!Util.isNullOrNil((String)localObject4)) {
          paramView = (String)localObject1 + "(" + (String)localObject4 + ")";
        }
      }
      paramView = l.b(((TextView)localObject3).getContext(), paramView, ((TextView)localObject3).getTextSize());
      if (Util.isNullOrNil(localanm.Szh))
      {
        ((TextView)localObject3).setText(paramView);
        localObject3 = (TextView)paramViewGroup.findViewById(R.h.dSu);
        Log.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[] { localanm.SyK });
        if (localanm.SyK != null)
        {
          if (!this.HDU) {
            break label710;
          }
          localObject4 = localanm.SyK;
          arrayOfString = localanm.SyK.split(" ");
          if (arrayOfString.length >= 2) {
            break label613;
          }
          ((TextView)localObject3).setText(localanm.SyK);
        }
        label352:
        if (paramInt != 0) {
          break label1149;
        }
        if (localanm.SyG == null) {
          break label1114;
        }
        paramView = localanm.SyG.Szn;
        localImageView.setVisibility(0);
        if (!paramView.SAc) {
          break label981;
        }
        aVB(paramView.SAb);
        if (!com.tencent.mm.ao.a.e.Vb(paramView.SAb)) {
          break label924;
        }
        com.tencent.mm.ay.q.bml().loadImage(com.tencent.mm.ao.a.e.Ve(paramView.SAb), localImageView);
      }
      break;
    }
    for (;;)
    {
      if (paramInt != getCount() - 1) {
        break label1529;
      }
      paramViewGroup.findViewById(R.h.dSt).setVisibility(8);
      return paramViewGroup;
      paramView = new com.tencent.mm.plugin.record.ui.a.a();
      break;
      paramView = new com.tencent.mm.plugin.record.ui.a.c();
      break;
      paramView = (View)localObject1;
      if (!((ano)localObject4).SzY) {
        break label235;
      }
      localObject4 = aa.PK(((ano)localObject4).fLi);
      paramView = (View)localObject1;
      if (Util.isNullOrNil((String)localObject4)) {
        break label235;
      }
      paramView = (String)localObject1 + "(" + (String)localObject4 + ")";
      break label235;
      localObject1 = localanm.Szh;
      if (localObject1 == null) {}
      for (;;)
      {
        ((TextView)localObject3).setText(paramView);
        break;
        paramView = new SpannableStringBuilder(paramView);
        int i = paramView.length();
        paramView.append((CharSequence)localObject1);
        int j = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(MMApplicationContext.getContext().getResources().getColor(c.b.open_im_display_name_color)), i, j, 33);
      }
      label613:
      paramView = arrayOfString[0];
      long l;
      try
      {
        l = new SimpleDateFormat("yyyy-MM-dd").parse(paramView).getTime();
        localObject1 = (String)DateFormat.format(this.context.getString(R.l.fmt_longdate), l);
        paramView = (View)localObject1;
      }
      catch (ParseException localParseException1)
      {
        label660:
        break label660;
      }
      ((TextView)localObject3).setText(paramView + " " + ((String)localObject4).substring(arrayOfString[0].length() + 1));
      break label352;
      label710:
      if (this.HDV)
      {
        localObject4 = localanm.SyK;
        arrayOfString = localanm.SyK.split(" ");
        if (arrayOfString.length < 2)
        {
          ((TextView)localObject3).setText(localanm.SyK);
          break label352;
        }
        paramView = arrayOfString[0].substring(arrayOfString[0].indexOf("-") + 1);
        try
        {
          l = new SimpleDateFormat("MM-dd").parse(paramView).getTime();
          String str = (String)DateFormat.format(this.context.getString(R.l.fmt_date), l);
          paramView = str;
        }
        catch (ParseException localParseException2)
        {
          break label819;
        }
        ((TextView)localObject3).setText(paramView + " " + ((String)localObject4).substring(arrayOfString[0].length() + 1));
        break label352;
      }
      label819:
      paramView = localanm.SyK.split(" ");
      if (paramView.length < 2)
      {
        ((TextView)localObject3).setText(localanm.SyK);
        break label352;
      }
      ((TextView)localObject3).setText(localanm.SyK.substring(paramView[0].length() + 1));
      break label352;
      label924:
      label1325:
      if ((as.bvK(paramView.SAb)) && (localanm.Szk) && (!Util.isNullOrNil(localanm.Szj)))
      {
        com.tencent.mm.ay.q.bml().loadImage(localanm.Szj, localImageView);
      }
      else
      {
        a.b.c(localImageView, paramView.SAb);
        continue;
        label981:
        label1114:
        label1378:
        label1387:
        if ((paramView.SzY) && ((!z.bcZ().equals(paramView.fLi)) || (!paramView.fLi.equals(paramView.toUser))))
        {
          if ((as.bvK(paramView.fLi)) && (localanm.Szk) && (!Util.isNullOrNil(localanm.Szj)))
          {
            com.tencent.mm.ay.q.bml().loadImage(localanm.Szj, localImageView);
          }
          else
          {
            aVB(paramView.fLi);
            a.b.c(localImageView, paramView.fLi);
          }
        }
        else
        {
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.HDW = true;
          continue;
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.HDW = true;
          continue;
          label1149:
          if ((paramInt > 0) && (!this.HDW))
          {
            paramView = "";
            Object localObject2 = localanm.SyG.Szn;
            if (ace(paramInt - 1).SyG.Szn.SAc) {
              paramView = ace(paramInt - 1).SyG.Szn.SAb;
            }
            for (;;)
            {
              localImageView.setVisibility(0);
              if (!localanm.SyG.Szn.SAc) {
                break label1387;
              }
              localObject3 = localanm.SyG.Szn.SAb;
              if (paramView.equals(localObject3)) {
                break label1378;
              }
              aVB((String)localObject3);
              if (!com.tencent.mm.ao.a.e.Vb(((ano)localObject2).SAb)) {
                break label1325;
              }
              com.tencent.mm.ay.q.bml().loadImage(com.tencent.mm.ao.a.e.Ve(((ano)localObject2).SAb), localImageView);
              break;
              if (ace(paramInt - 1).SyG.Szn.SzY) {
                paramView = ace(paramInt - 1).SyG.Szn.fLi;
              }
            }
            if ((as.bvK((String)localObject3)) && (localanm.Szk) && (!Util.isNullOrNil(localanm.Szj)))
            {
              com.tencent.mm.ay.q.bml().loadImage(localanm.Szj, localImageView);
            }
            else
            {
              a.b.c(localImageView, (String)localObject3);
              continue;
              localImageView.setVisibility(4);
              continue;
              if (localanm.SyG.Szn.SzY)
              {
                localObject2 = localanm.SyG.Szn.fLi;
                if (!paramView.equals(localObject2))
                {
                  if ((as.bvK((String)localObject2)) && (localanm.Szk) && (!Util.isNullOrNil(localanm.Szj)))
                  {
                    com.tencent.mm.ay.q.bml().loadImage(localanm.Szj, localImageView);
                  }
                  else
                  {
                    aVB((String)localObject2);
                    a.b.c(localImageView, (String)localObject2);
                  }
                }
                else {
                  localImageView.setVisibility(4);
                }
              }
              else
              {
                localImageView.setVisibility(4);
              }
            }
          }
          else
          {
            localImageView.setVisibility(8);
            paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          }
        }
      }
    }
    label1529:
    paramViewGroup.findViewById(R.h.dSt).setVisibility(0);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public static abstract interface a
  {
    public abstract Bitmap a(b paramb);
    
    public abstract Bitmap a(c paramc);
    
    public abstract void a(a parama);
    
    public abstract void fuw();
    
    public static final class a
    {
      public long HEb;
      public anm fDI;
      public ImageView fDJ;
      public int fDK;
      public int height;
      public int width;
    }
    
    public static final class b
    {
      public long HEb;
      public anm fDI;
      public boolean fDL;
      public boolean fDM;
      public int maxWidth;
    }
    
    public static final class c
    {
      public long HEb;
      public anm fDI;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(View paramView, int paramInt, com.tencent.mm.plugin.record.ui.a.b paramb, Object paramObject);
    
    public abstract View createView(Context paramContext);
    
    public abstract void destroy();
    
    public abstract void pause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.h
 * JD-Core Version:    0.7.0.1
 */