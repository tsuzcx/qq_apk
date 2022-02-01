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
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.av.q;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
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
  i BHC;
  public String BHK = "";
  public String BHL = "";
  SparseArray<b> BHM = new SparseArray();
  boolean BHN = false;
  boolean BHO = false;
  private boolean BHP = false;
  protected a BHQ;
  protected a BHR;
  public int BHS = 0;
  protected List<aml> BHs = new LinkedList();
  protected Context context;
  ListView mListView;
  private int padding = com.tencent.mm.cb.a.fromDPToPix(this.context, 35);
  private Runnable tdl = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(27870);
      Log.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
      h.this.notifyDataSetChanged();
      AppMethodBeat.o(27870);
    }
  };
  protected MMHandler wMu = null;
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.wMu = new MMHandler(Looper.getMainLooper())
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
    this.BHR = parama;
  }
  
  private aml Vw(int paramInt)
  {
    if (this.BHs == null) {}
    while ((paramInt < 0) || (paramInt >= this.BHs.size())) {
      return null;
    }
    return (aml)this.BHs.get(paramInt);
  }
  
  private static void aLa(String paramString)
  {
    if (!ab.IS(paramString))
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = paramString;
      p.aYB().b(locali);
    }
  }
  
  private static int o(aml paramaml)
  {
    switch (paramaml.dataType)
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
    while (i < this.BHM.size())
    {
      b localb = (b)this.BHM.valueAt(i);
      if (localb != null) {
        localb.destroy();
      }
      i += 1;
    }
    if (this.BHR != null)
    {
      this.BHR.eIr();
      this.BHR = null;
    }
  }
  
  public final void eIy()
  {
    this.BHM.put(0, new d(this.context));
    this.BHM.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.BHR, this.mListView));
    this.BHM.put(2, new com.tencent.mm.plugin.record.ui.b.e());
    com.tencent.mm.plugin.record.ui.b.b localb = new com.tencent.mm.plugin.record.ui.b.b(this.BHR, this.wMu);
    localb.BHK = this.BHK;
    localb.BHL = this.BHL;
    this.BHM.put(3, localb);
    this.BHM.put(4, new com.tencent.mm.plugin.record.ui.b.c(this.BHR));
  }
  
  protected final void eIz()
  {
    this.wMu.post(this.tdl);
  }
  
  public int getCount()
  {
    if (this.BHs == null) {
      return 0;
    }
    return this.BHs.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return o(Vw(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aml localaml = Vw(paramInt);
    Object localObject1 = (b)this.BHM.get(o(localaml));
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((b)localObject1).createView(this.context);
    }
    ImageView localImageView;
    Object localObject3;
    Object localObject4;
    label233:
    String[] arrayOfString;
    switch (localaml.dataType)
    {
    default: 
      paramView = new com.tencent.mm.plugin.record.ui.a.b();
      paramView.dKT = localaml;
      paramView.BHK = this.BHK;
      paramView.BIN = this.BHL;
      d(paramView);
      ((b)localObject1).a(paramViewGroup, paramInt, paramView, this.BHC);
      localImageView = (ImageView)paramViewGroup.findViewById(2131306721);
      localObject3 = (TextView)paramViewGroup.findViewById(2131306725);
      localObject1 = localaml.Lwj;
      paramView = (View)localObject1;
      if (localaml.Lwh != null)
      {
        localObject4 = localaml.Lwh.LwO;
        if (!((amn)localObject4).LxB) {
          break;
        }
        localObject4 = aa.Is(((amn)localObject4).LxA);
        paramView = (View)localObject1;
        if (!Util.isNullOrNil((String)localObject4)) {
          paramView = (String)localObject1 + "(" + (String)localObject4 + ")";
        }
      }
      paramView = l.b(((TextView)localObject3).getContext(), paramView, ((TextView)localObject3).getTextSize());
      if (Util.isNullOrNil(localaml.LwI))
      {
        ((TextView)localObject3).setText(paramView);
        localObject3 = (TextView)paramViewGroup.findViewById(2131306724);
        Log.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[] { localaml.Lwl });
        if (localaml.Lwl != null)
        {
          if (!this.BHN) {
            break label708;
          }
          localObject4 = localaml.Lwl;
          arrayOfString = localaml.Lwl.split(" ");
          if (arrayOfString.length >= 2) {
            break label611;
          }
          ((TextView)localObject3).setText(localaml.Lwl);
        }
        label350:
        if (paramInt != 0) {
          break label1147;
        }
        if (localaml.Lwh == null) {
          break label1112;
        }
        paramView = localaml.Lwh.LwO;
        localImageView.setVisibility(0);
        if (!paramView.LxB) {
          break label979;
        }
        aLa(paramView.LxA);
        if (!com.tencent.mm.al.a.e.NF(paramView.LxA)) {
          break label922;
        }
        q.bcV().loadImage(com.tencent.mm.al.a.e.NI(paramView.LxA), localImageView);
      }
      break;
    }
    for (;;)
    {
      if (paramInt != getCount() - 1) {
        break label1527;
      }
      paramViewGroup.findViewById(2131306723).setVisibility(8);
      return paramViewGroup;
      paramView = new com.tencent.mm.plugin.record.ui.a.a();
      break;
      paramView = new com.tencent.mm.plugin.record.ui.a.c();
      break;
      paramView = (View)localObject1;
      if (!((amn)localObject4).Lxx) {
        break label233;
      }
      localObject4 = aa.Is(((amn)localObject4).dRL);
      paramView = (View)localObject1;
      if (Util.isNullOrNil((String)localObject4)) {
        break label233;
      }
      paramView = (String)localObject1 + "(" + (String)localObject4 + ")";
      break label233;
      localObject1 = localaml.LwI;
      if (localObject1 == null) {}
      for (;;)
      {
        ((TextView)localObject3).setText(paramView);
        break;
        paramView = new SpannableStringBuilder(paramView);
        int i = paramView.length();
        paramView.append((CharSequence)localObject1);
        int j = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(MMApplicationContext.getContext().getResources().getColor(2131100917)), i, j, 33);
      }
      label611:
      paramView = arrayOfString[0];
      long l;
      try
      {
        l = new SimpleDateFormat("yyyy-MM-dd").parse(paramView).getTime();
        localObject1 = (String)DateFormat.format(this.context.getString(2131760832), l);
        paramView = (View)localObject1;
      }
      catch (ParseException localParseException1)
      {
        label658:
        break label658;
      }
      ((TextView)localObject3).setText(paramView + " " + ((String)localObject4).substring(arrayOfString[0].length() + 1));
      break label350;
      label708:
      if (this.BHO)
      {
        localObject4 = localaml.Lwl;
        arrayOfString = localaml.Lwl.split(" ");
        if (arrayOfString.length < 2)
        {
          ((TextView)localObject3).setText(localaml.Lwl);
          break label350;
        }
        paramView = arrayOfString[0].substring(arrayOfString[0].indexOf("-") + 1);
        try
        {
          l = new SimpleDateFormat("MM-dd").parse(paramView).getTime();
          String str = (String)DateFormat.format(this.context.getString(2131760813), l);
          paramView = str;
        }
        catch (ParseException localParseException2)
        {
          break label817;
        }
        ((TextView)localObject3).setText(paramView + " " + ((String)localObject4).substring(arrayOfString[0].length() + 1));
        break label350;
      }
      label817:
      paramView = localaml.Lwl.split(" ");
      if (paramView.length < 2)
      {
        ((TextView)localObject3).setText(localaml.Lwl);
        break label350;
      }
      ((TextView)localObject3).setText(localaml.Lwl.substring(paramView[0].length() + 1));
      break label350;
      label922:
      label1323:
      if ((as.bjp(paramView.LxA)) && (localaml.LwL) && (!Util.isNullOrNil(localaml.LwK)))
      {
        q.bcV().loadImage(localaml.LwK, localImageView);
      }
      else
      {
        a.b.c(localImageView, paramView.LxA);
        continue;
        label979:
        label1112:
        label1376:
        label1385:
        if ((paramView.Lxx) && ((!z.aTY().equals(paramView.dRL)) || (!paramView.dRL.equals(paramView.toUser))))
        {
          if ((as.bjp(paramView.dRL)) && (localaml.LwL) && (!Util.isNullOrNil(localaml.LwK)))
          {
            q.bcV().loadImage(localaml.LwK, localImageView);
          }
          else
          {
            aLa(paramView.dRL);
            a.b.c(localImageView, paramView.dRL);
          }
        }
        else
        {
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.BHP = true;
          continue;
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.BHP = true;
          continue;
          label1147:
          if ((paramInt > 0) && (!this.BHP))
          {
            paramView = "";
            Object localObject2 = localaml.Lwh.LwO;
            if (Vw(paramInt - 1).Lwh.LwO.LxB) {
              paramView = Vw(paramInt - 1).Lwh.LwO.LxA;
            }
            for (;;)
            {
              localImageView.setVisibility(0);
              if (!localaml.Lwh.LwO.LxB) {
                break label1385;
              }
              localObject3 = localaml.Lwh.LwO.LxA;
              if (paramView.equals(localObject3)) {
                break label1376;
              }
              aLa((String)localObject3);
              if (!com.tencent.mm.al.a.e.NF(((amn)localObject2).LxA)) {
                break label1323;
              }
              q.bcV().loadImage(com.tencent.mm.al.a.e.NI(((amn)localObject2).LxA), localImageView);
              break;
              if (Vw(paramInt - 1).Lwh.LwO.Lxx) {
                paramView = Vw(paramInt - 1).Lwh.LwO.dRL;
              }
            }
            if ((as.bjp((String)localObject3)) && (localaml.LwL) && (!Util.isNullOrNil(localaml.LwK)))
            {
              q.bcV().loadImage(localaml.LwK, localImageView);
            }
            else
            {
              a.b.c(localImageView, (String)localObject3);
              continue;
              localImageView.setVisibility(4);
              continue;
              if (localaml.Lwh.LwO.Lxx)
              {
                localObject2 = localaml.Lwh.LwO.dRL;
                if (!paramView.equals(localObject2))
                {
                  if ((as.bjp((String)localObject2)) && (localaml.LwL) && (!Util.isNullOrNil(localaml.LwK)))
                  {
                    q.bcV().loadImage(localaml.LwK, localImageView);
                  }
                  else
                  {
                    aLa((String)localObject2);
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
    label1527:
    paramViewGroup.findViewById(2131306723).setVisibility(0);
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
    
    public abstract void eIr();
    
    public static final class a
    {
      public long BHU;
      public aml dKT;
      public ImageView dKU;
      public int dKV;
      public int height;
      public int width;
    }
    
    public static final class b
    {
      public long BHU;
      public aml dKT;
      public boolean dKW;
      public boolean dKX;
      public int maxWidth;
    }
    
    public static final class c
    {
      public long BHU;
      public aml dKT;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.h
 * JD-Core Version:    0.7.0.1
 */