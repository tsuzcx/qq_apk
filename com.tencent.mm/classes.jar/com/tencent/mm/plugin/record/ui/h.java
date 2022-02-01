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
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.aw.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class h
  extends BaseAdapter
{
  protected Context context;
  ListView mListView;
  private int padding = com.tencent.mm.cc.a.fromDPToPix(this.context, 35);
  private Runnable rvu = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(27870);
      ad.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
      h.this.notifyDataSetChanged();
      AppMethodBeat.o(27870);
    }
  };
  protected ap tkw = null;
  i xrH;
  SparseArray<b> xrP = new SparseArray();
  boolean xrQ = false;
  boolean xrR = false;
  private boolean xrS = false;
  protected a xrT;
  protected a xrU;
  protected List<ajn> xrx = new LinkedList();
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.tkw = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(27869);
        if (paramAnonymousMessage.what == 1)
        {
          ad.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
          h.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(27869);
      }
    };
    this.xrU = parama;
  }
  
  private ajn NB(int paramInt)
  {
    if (this.xrx == null) {}
    while ((paramInt < 0) || (paramInt >= this.xrx.size())) {
      return null;
    }
    return (ajn)this.xrx.get(paramInt);
  }
  
  private static void avt(String paramString)
  {
    if (!w.zD(paramString))
    {
      com.tencent.mm.ak.i locali = new com.tencent.mm.ak.i();
      locali.username = paramString;
      p.aEx().b(locali);
    }
  }
  
  private static int o(ajn paramajn)
  {
    switch (paramajn.dataType)
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
  
  public final void dEu()
  {
    this.xrP.put(0, new d(this.context));
    this.xrP.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.xrU, this.mListView));
    this.xrP.put(2, new com.tencent.mm.plugin.record.ui.b.e());
    this.xrP.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.xrU, this.tkw));
    this.xrP.put(4, new com.tencent.mm.plugin.record.ui.b.c(this.xrU));
  }
  
  protected final void dEv()
  {
    this.tkw.post(this.rvu);
  }
  
  public final void destroy()
  {
    int i = 0;
    while (i < this.xrP.size())
    {
      b localb = (b)this.xrP.valueAt(i);
      if (localb != null) {
        localb.destroy();
      }
      i += 1;
    }
    if (this.xrU != null)
    {
      this.xrU.dEn();
      this.xrU = null;
    }
  }
  
  public int getCount()
  {
    if (this.xrx == null) {
      return 0;
    }
    return this.xrx.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return o(NB(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ajn localajn = NB(paramInt);
    Object localObject1 = (b)this.xrP.get(o(localajn));
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((b)localObject1).createView(this.context);
    }
    ImageView localImageView;
    Object localObject3;
    Object localObject4;
    label217:
    String[] arrayOfString;
    switch (localajn.dataType)
    {
    default: 
      paramView = new com.tencent.mm.plugin.record.ui.a.b();
      paramView.dsC = localajn;
      d(paramView);
      ((b)localObject1).a(paramViewGroup, paramInt, paramView, this.xrH);
      localImageView = (ImageView)paramViewGroup.findViewById(2131303892);
      localObject3 = (TextView)paramViewGroup.findViewById(2131303896);
      localObject1 = localajn.GhN;
      paramView = (View)localObject1;
      if (localajn.GhL != null)
      {
        localObject4 = localajn.GhL.Gis;
        if (!((ajp)localObject4).GiW) {
          break;
        }
        localObject4 = v.zg(((ajp)localObject4).GiV);
        paramView = (View)localObject1;
        if (!bt.isNullOrNil((String)localObject4)) {
          paramView = (String)localObject1 + "(" + (String)localObject4 + ")";
        }
      }
      paramView = k.b(((TextView)localObject3).getContext(), paramView, ((TextView)localObject3).getTextSize());
      if (bt.isNullOrNil(localajn.Gim))
      {
        ((TextView)localObject3).setText(paramView);
        localObject3 = (TextView)paramViewGroup.findViewById(2131303895);
        ad.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[] { localajn.GhP });
        if (localajn.GhP != null)
        {
          if (!this.xrQ) {
            break label692;
          }
          localObject4 = localajn.GhP;
          arrayOfString = localajn.GhP.split(" ");
          if (arrayOfString.length >= 2) {
            break label595;
          }
          ((TextView)localObject3).setText(localajn.GhP);
        }
        label334:
        if (paramInt != 0) {
          break label1131;
        }
        if (localajn.GhL == null) {
          break label1096;
        }
        paramView = localajn.GhL.Gis;
        localImageView.setVisibility(0);
        if (!paramView.GiW) {
          break label963;
        }
        avt(paramView.GiV);
        if (!com.tencent.mm.am.a.e.Ep(paramView.GiV)) {
          break label906;
        }
        q.aIJ().loadImage(com.tencent.mm.am.a.e.Es(paramView.GiV), localImageView);
      }
      break;
    }
    for (;;)
    {
      if (paramInt != getCount() - 1) {
        break label1512;
      }
      paramViewGroup.findViewById(2131303894).setVisibility(8);
      return paramViewGroup;
      paramView = new com.tencent.mm.plugin.record.ui.a.a();
      break;
      paramView = new com.tencent.mm.plugin.record.ui.a.c();
      break;
      paramView = (View)localObject1;
      if (!((ajp)localObject4).GiR) {
        break label217;
      }
      localObject4 = v.zg(((ajp)localObject4).dyU);
      paramView = (View)localObject1;
      if (bt.isNullOrNil((String)localObject4)) {
        break label217;
      }
      paramView = (String)localObject1 + "(" + (String)localObject4 + ")";
      break label217;
      localObject1 = localajn.Gim;
      if (localObject1 == null) {}
      for (;;)
      {
        ((TextView)localObject3).setText(paramView);
        break;
        paramView = new SpannableStringBuilder(paramView);
        int i = paramView.length();
        paramView.append((CharSequence)localObject1);
        int j = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(aj.getContext().getResources().getColor(2131100723)), i, j, 33);
      }
      label595:
      paramView = arrayOfString[0];
      long l;
      try
      {
        l = new SimpleDateFormat("yyyy-MM-dd").parse(paramView).getTime();
        localObject1 = (String)DateFormat.format(this.context.getString(2131759517), l);
        paramView = (View)localObject1;
      }
      catch (ParseException localParseException1)
      {
        label642:
        break label642;
      }
      ((TextView)localObject3).setText(paramView + " " + ((String)localObject4).substring(arrayOfString[0].length() + 1));
      break label334;
      label692:
      if (this.xrR)
      {
        localObject4 = localajn.GhP;
        arrayOfString = localajn.GhP.split(" ");
        if (arrayOfString.length < 2)
        {
          ((TextView)localObject3).setText(localajn.GhP);
          break label334;
        }
        paramView = arrayOfString[0].substring(arrayOfString[0].indexOf("-") + 1);
        try
        {
          l = new SimpleDateFormat("MM-dd").parse(paramView).getTime();
          String str = (String)DateFormat.format(this.context.getString(2131759498), l);
          paramView = str;
        }
        catch (ParseException localParseException2)
        {
          break label801;
        }
        ((TextView)localObject3).setText(paramView + " " + ((String)localObject4).substring(arrayOfString[0].length() + 1));
        break label334;
      }
      label801:
      paramView = localajn.GhP.split(" ");
      if (paramView.length < 2)
      {
        ((TextView)localObject3).setText(localajn.GhP);
        break label334;
      }
      ((TextView)localObject3).setText(localajn.GhP.substring(paramView[0].length() + 1));
      break label334;
      label906:
      label1308:
      if ((am.aSQ(paramView.GiV)) && (localajn.Gip) && (!bt.isNullOrNil(localajn.Gio)))
      {
        q.aIJ().loadImage(localajn.Gio, localImageView);
      }
      else
      {
        a.b.c(localImageView, paramView.GiV);
        continue;
        label963:
        label1096:
        label1361:
        label1370:
        if ((paramView.GiR) && ((!u.aAm().equals(paramView.dyU)) || (!paramView.dyU.equals(paramView.toUser))))
        {
          if ((am.aSQ(paramView.dyU)) && (localajn.Gip) && (!bt.isNullOrNil(localajn.Gio)))
          {
            q.aIJ().loadImage(localajn.Gio, localImageView);
          }
          else
          {
            avt(paramView.dyU);
            a.b.c(localImageView, paramView.dyU);
          }
        }
        else
        {
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.xrS = true;
          continue;
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.xrS = true;
          continue;
          label1131:
          if ((paramInt > 0) && (!this.xrS))
          {
            paramView = "";
            Object localObject2 = localajn.GhL.Gis;
            if (NB(paramInt - 1).GhL.Gis.GiW) {
              paramView = NB(paramInt - 1).GhL.Gis.GiV;
            }
            for (;;)
            {
              localImageView.setVisibility(0);
              if (!localajn.GhL.Gis.GiW) {
                break label1370;
              }
              localObject3 = localajn.GhL.Gis.GiV;
              if (paramView.equals(localObject3)) {
                break label1361;
              }
              avt((String)localObject3);
              if (!com.tencent.mm.am.a.e.Ep(((ajp)localObject2).GiV)) {
                break label1308;
              }
              q.aIJ().loadImage(com.tencent.mm.am.a.e.Es(((ajp)localObject2).GiV), localImageView);
              break;
              if (NB(paramInt - 1).GhL.Gis.GiR) {
                paramView = NB(paramInt - 1).GhL.Gis.dyU;
              }
            }
            if ((am.aSQ((String)localObject3)) && (localajn.Gip) && (!bt.isNullOrNil(localajn.Gio)))
            {
              q.aIJ().loadImage(localajn.Gio, localImageView);
            }
            else
            {
              a.b.c(localImageView, (String)localObject3);
              continue;
              localImageView.setVisibility(4);
              continue;
              if (localajn.GhL.Gis.GiR)
              {
                localObject2 = localajn.GhL.Gis.dyU;
                if (!paramView.equals(localObject2))
                {
                  if ((am.aSQ((String)localObject2)) && (localajn.Gip) && (!bt.isNullOrNil(localajn.Gio)))
                  {
                    q.aIJ().loadImage(localajn.Gio, localImageView);
                  }
                  else
                  {
                    avt((String)localObject2);
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
    label1512:
    paramViewGroup.findViewById(2131303894).setVisibility(0);
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
    
    public abstract void dEn();
    
    public static final class a
    {
      public ajn dsC;
      public ImageView dsD;
      public int dsE;
      public int height;
      public int width;
      public long xrW;
    }
    
    public static final class b
    {
      public ajn dsC;
      public boolean dsF;
      public boolean dsG;
      public int maxWidth;
      public long xrW;
    }
    
    public static final class c
    {
      public ajn dsC;
      public long xrW;
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