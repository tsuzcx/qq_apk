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
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
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
  private int padding = com.tencent.mm.cb.a.fromDPToPix(this.context, 35);
  private Runnable rDG = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(27870);
      ae.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
      h.this.notifyDataSetChanged();
      AppMethodBeat.o(27870);
    }
  };
  protected aq tvo = null;
  i xHE;
  SparseArray<b> xHM = new SparseArray();
  boolean xHN = false;
  boolean xHO = false;
  private boolean xHP = false;
  protected a xHQ;
  protected a xHR;
  protected List<ajx> xHu = new LinkedList();
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.tvo = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(27869);
        if (paramAnonymousMessage.what == 1)
        {
          ae.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
          h.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(27869);
      }
    };
    this.xHR = parama;
  }
  
  private ajx Oh(int paramInt)
  {
    if (this.xHu == null) {}
    while ((paramInt < 0) || (paramInt >= this.xHu.size())) {
      return null;
    }
    return (ajx)this.xHu.get(paramInt);
  }
  
  private static void awI(String paramString)
  {
    if (!x.An(paramString))
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = paramString;
      p.aEN().b(locali);
    }
  }
  
  private static int o(ajx paramajx)
  {
    switch (paramajx.dataType)
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
  
  public final void dHL()
  {
    this.xHM.put(0, new d(this.context));
    this.xHM.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.xHR, this.mListView));
    this.xHM.put(2, new com.tencent.mm.plugin.record.ui.b.e());
    this.xHM.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.xHR, this.tvo));
    this.xHM.put(4, new com.tencent.mm.plugin.record.ui.b.c(this.xHR));
  }
  
  protected final void dHM()
  {
    this.tvo.post(this.rDG);
  }
  
  public final void destroy()
  {
    int i = 0;
    while (i < this.xHM.size())
    {
      b localb = (b)this.xHM.valueAt(i);
      if (localb != null) {
        localb.destroy();
      }
      i += 1;
    }
    if (this.xHR != null)
    {
      this.xHR.dHE();
      this.xHR = null;
    }
  }
  
  public int getCount()
  {
    if (this.xHu == null) {
      return 0;
    }
    return this.xHu.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return o(Oh(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ajx localajx = Oh(paramInt);
    Object localObject1 = (b)this.xHM.get(o(localajx));
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((b)localObject1).createView(this.context);
    }
    ImageView localImageView;
    Object localObject3;
    Object localObject4;
    label217:
    String[] arrayOfString;
    switch (localajx.dataType)
    {
    default: 
      paramView = new com.tencent.mm.plugin.record.ui.a.b();
      paramView.dtI = localajx;
      d(paramView);
      ((b)localObject1).a(paramViewGroup, paramInt, paramView, this.xHE);
      localImageView = (ImageView)paramViewGroup.findViewById(2131303892);
      localObject3 = (TextView)paramViewGroup.findViewById(2131303896);
      localObject1 = localajx.GAw;
      paramView = (View)localObject1;
      if (localajx.GAu != null)
      {
        localObject4 = localajx.GAu.GBb;
        if (!((ajz)localObject4).GBF) {
          break;
        }
        localObject4 = w.zQ(((ajz)localObject4).GBE);
        paramView = (View)localObject1;
        if (!bu.isNullOrNil((String)localObject4)) {
          paramView = (String)localObject1 + "(" + (String)localObject4 + ")";
        }
      }
      paramView = k.b(((TextView)localObject3).getContext(), paramView, ((TextView)localObject3).getTextSize());
      if (bu.isNullOrNil(localajx.GAV))
      {
        ((TextView)localObject3).setText(paramView);
        localObject3 = (TextView)paramViewGroup.findViewById(2131303895);
        ae.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[] { localajx.GAy });
        if (localajx.GAy != null)
        {
          if (!this.xHN) {
            break label692;
          }
          localObject4 = localajx.GAy;
          arrayOfString = localajx.GAy.split(" ");
          if (arrayOfString.length >= 2) {
            break label595;
          }
          ((TextView)localObject3).setText(localajx.GAy);
        }
        label334:
        if (paramInt != 0) {
          break label1131;
        }
        if (localajx.GAu == null) {
          break label1096;
        }
        paramView = localajx.GAu.GBb;
        localImageView.setVisibility(0);
        if (!paramView.GBF) {
          break label963;
        }
        awI(paramView.GBE);
        if (!com.tencent.mm.al.a.e.ER(paramView.GBE)) {
          break label906;
        }
        q.aJb().loadImage(com.tencent.mm.al.a.e.EU(paramView.GBE), localImageView);
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
      if (!((ajz)localObject4).GBA) {
        break label217;
      }
      localObject4 = w.zQ(((ajz)localObject4).dzZ);
      paramView = (View)localObject1;
      if (bu.isNullOrNil((String)localObject4)) {
        break label217;
      }
      paramView = (String)localObject1 + "(" + (String)localObject4 + ")";
      break label217;
      localObject1 = localajx.GAV;
      if (localObject1 == null) {}
      for (;;)
      {
        ((TextView)localObject3).setText(paramView);
        break;
        paramView = new SpannableStringBuilder(paramView);
        int i = paramView.length();
        paramView.append((CharSequence)localObject1);
        int j = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(ak.getContext().getResources().getColor(2131100723)), i, j, 33);
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
      if (this.xHO)
      {
        localObject4 = localajx.GAy;
        arrayOfString = localajx.GAy.split(" ");
        if (arrayOfString.length < 2)
        {
          ((TextView)localObject3).setText(localajx.GAy);
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
      paramView = localajx.GAy.split(" ");
      if (paramView.length < 2)
      {
        ((TextView)localObject3).setText(localajx.GAy);
        break label334;
      }
      ((TextView)localObject3).setText(localajx.GAy.substring(paramView[0].length() + 1));
      break label334;
      label906:
      label1308:
      if ((an.aUq(paramView.GBE)) && (localajx.GAY) && (!bu.isNullOrNil(localajx.GAX)))
      {
        q.aJb().loadImage(localajx.GAX, localImageView);
      }
      else
      {
        a.b.c(localImageView, paramView.GBE);
        continue;
        label963:
        label1096:
        label1361:
        label1370:
        if ((paramView.GBA) && ((!v.aAC().equals(paramView.dzZ)) || (!paramView.dzZ.equals(paramView.toUser))))
        {
          if ((an.aUq(paramView.dzZ)) && (localajx.GAY) && (!bu.isNullOrNil(localajx.GAX)))
          {
            q.aJb().loadImage(localajx.GAX, localImageView);
          }
          else
          {
            awI(paramView.dzZ);
            a.b.c(localImageView, paramView.dzZ);
          }
        }
        else
        {
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.xHP = true;
          continue;
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.xHP = true;
          continue;
          label1131:
          if ((paramInt > 0) && (!this.xHP))
          {
            paramView = "";
            Object localObject2 = localajx.GAu.GBb;
            if (Oh(paramInt - 1).GAu.GBb.GBF) {
              paramView = Oh(paramInt - 1).GAu.GBb.GBE;
            }
            for (;;)
            {
              localImageView.setVisibility(0);
              if (!localajx.GAu.GBb.GBF) {
                break label1370;
              }
              localObject3 = localajx.GAu.GBb.GBE;
              if (paramView.equals(localObject3)) {
                break label1361;
              }
              awI((String)localObject3);
              if (!com.tencent.mm.al.a.e.ER(((ajz)localObject2).GBE)) {
                break label1308;
              }
              q.aJb().loadImage(com.tencent.mm.al.a.e.EU(((ajz)localObject2).GBE), localImageView);
              break;
              if (Oh(paramInt - 1).GAu.GBb.GBA) {
                paramView = Oh(paramInt - 1).GAu.GBb.dzZ;
              }
            }
            if ((an.aUq((String)localObject3)) && (localajx.GAY) && (!bu.isNullOrNil(localajx.GAX)))
            {
              q.aJb().loadImage(localajx.GAX, localImageView);
            }
            else
            {
              a.b.c(localImageView, (String)localObject3);
              continue;
              localImageView.setVisibility(4);
              continue;
              if (localajx.GAu.GBb.GBA)
              {
                localObject2 = localajx.GAu.GBb.dzZ;
                if (!paramView.equals(localObject2))
                {
                  if ((an.aUq((String)localObject2)) && (localajx.GAY) && (!bu.isNullOrNil(localajx.GAX)))
                  {
                    q.aJb().loadImage(localajx.GAX, localImageView);
                  }
                  else
                  {
                    awI((String)localObject2);
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
    
    public abstract void dHE();
    
    public static final class a
    {
      public ajx dtI;
      public ImageView dtJ;
      public int dtK;
      public int height;
      public int width;
      public long xHT;
    }
    
    public static final class b
    {
      public ajx dtI;
      public boolean dtL;
      public boolean dtM;
      public int maxWidth;
      public long xHT;
    }
    
    public static final class c
    {
      public ajx dtI;
      public long xHT;
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