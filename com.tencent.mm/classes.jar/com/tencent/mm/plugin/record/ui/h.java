package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableStringBuilder;
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
import com.tencent.mm.aw.o;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import java.util.LinkedList;
import java.util.List;

public abstract class h
  extends BaseAdapter
{
  protected Context context;
  ListView mListView;
  private int padding = com.tencent.mm.cd.a.fromDPToPix(this.context, 35);
  private Runnable qcN = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(27870);
      ad.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
      h.this.notifyDataSetChanged();
      AppMethodBeat.o(27870);
    }
  };
  protected ap rfb = null;
  protected List<afy> vaT = new LinkedList();
  i vbd;
  SparseArray<b> vbl = new SparseArray();
  boolean vbm = false;
  private boolean vbn = false;
  protected a vbo;
  protected a vbp;
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.rfb = new ap(Looper.getMainLooper())
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
    this.vbp = parama;
  }
  
  private afy Kd(int paramInt)
  {
    if (this.vaT == null) {}
    while ((paramInt < 0) || (paramInt >= this.vaT.size())) {
      return null;
    }
    return (afy)this.vaT.get(paramInt);
  }
  
  private static void alv(String paramString)
  {
    if (!w.sD(paramString))
    {
      com.tencent.mm.ak.i locali = new com.tencent.mm.ak.i();
      locali.username = paramString;
      p.auF().b(locali);
    }
  }
  
  private static int o(afy paramafy)
  {
    switch (paramafy.dataType)
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
    while (i < this.vbl.size())
    {
      b localb = (b)this.vbl.valueAt(i);
      if (localb != null) {
        localb.destroy();
      }
      i += 1;
    }
    if (this.vbp != null)
    {
      this.vbp.dgj();
      this.vbp = null;
    }
  }
  
  public final void dgq()
  {
    this.vbl.put(0, new d(this.context));
    this.vbl.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.vbp, this.mListView));
    this.vbl.put(2, new com.tencent.mm.plugin.record.ui.b.e());
    this.vbl.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.vbp, this.rfb));
    this.vbl.put(4, new com.tencent.mm.plugin.record.ui.b.c(this.vbp));
  }
  
  protected final void dgr()
  {
    this.rfb.post(this.qcN);
  }
  
  public int getCount()
  {
    if (this.vaT == null) {
      return 0;
    }
    return this.vaT.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return o(Kd(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    afy localafy = Kd(paramInt);
    Object localObject1 = (b)this.vbl.get(o(localafy));
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((b)localObject1).createView(this.context);
    }
    ImageView localImageView;
    Object localObject2;
    Object localObject3;
    switch (localafy.dataType)
    {
    default: 
      paramView = new com.tencent.mm.plugin.record.ui.a.b();
      paramView.djJ = localafy;
      d(paramView);
      ((b)localObject1).a(paramViewGroup, paramInt, paramView, this.vbd);
      localImageView = (ImageView)paramViewGroup.findViewById(2131303892);
      localObject2 = (TextView)paramViewGroup.findViewById(2131303896);
      localObject1 = localafy.DgV;
      paramView = (View)localObject1;
      if (localafy.DgT != null)
      {
        localObject3 = localafy.DgT.DhA;
        if (!((aga)localObject3).Die) {
          break;
        }
        localObject3 = v.si(((aga)localObject3).Did);
        paramView = (View)localObject1;
        if (!bt.isNullOrNil((String)localObject3)) {
          paramView = (String)localObject1 + "(" + (String)localObject3 + ")";
        }
      }
      label217:
      paramView = k.b(((TextView)localObject2).getContext(), paramView, ((TextView)localObject2).getTextSize());
      if (bt.isNullOrNil(localafy.Dhu))
      {
        ((TextView)localObject2).setText(paramView);
        paramView = (TextView)paramViewGroup.findViewById(2131303895);
        ad.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[] { localafy.DgX });
        if (localafy.DgX != null)
        {
          if (!this.vbm) {
            break label583;
          }
          localObject1 = localafy.DgX;
          paramView.setText(((String)localObject1).substring(((String)localObject1).indexOf("-") + 1));
        }
        label322:
        if (paramInt != 0) {
          break label864;
        }
        if (localafy.DgT == null) {
          break label829;
        }
        paramView = localafy.DgT.DhA;
        localImageView.setVisibility(0);
        if (!paramView.Die) {
          break label696;
        }
        alv(paramView.Did);
        if (!com.tencent.mm.am.a.e.xk(paramView.Did)) {
          break label639;
        }
        o.ayJ().loadImage(com.tencent.mm.am.a.e.xn(paramView.Did), localImageView);
      }
      break;
    }
    label583:
    label864:
    for (;;)
    {
      if (paramInt != getCount() - 1) {
        break label1245;
      }
      paramViewGroup.findViewById(2131303894).setVisibility(8);
      return paramViewGroup;
      paramView = new com.tencent.mm.plugin.record.ui.a.a();
      break;
      paramView = new com.tencent.mm.plugin.record.ui.a.c();
      break;
      paramView = (View)localObject1;
      if (!((aga)localObject3).DhZ) {
        break label217;
      }
      localObject3 = v.si(((aga)localObject3).dpv);
      paramView = (View)localObject1;
      if (bt.isNullOrNil((String)localObject3)) {
        break label217;
      }
      paramView = (String)localObject1 + "(" + (String)localObject3 + ")";
      break label217;
      localObject1 = localafy.Dhu;
      if (localObject1 == null) {}
      for (;;)
      {
        ((TextView)localObject2).setText(paramView);
        break;
        paramView = new SpannableStringBuilder(paramView);
        int i = paramView.length();
        paramView.append((CharSequence)localObject1);
        int j = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(aj.getContext().getResources().getColor(2131100723)), i, j, 33);
      }
      localObject1 = localafy.DgX.split(" ");
      if (localObject1.length < 2)
      {
        paramView.setText(localafy.DgX);
        break label322;
      }
      paramView.setText(localafy.DgX.substring(localObject1[0].length() + 1));
      break label322;
      label639:
      if ((af.aHH(paramView.Did)) && (localafy.Dhx) && (!bt.isNullOrNil(localafy.Dhw)))
      {
        o.ayJ().loadImage(localafy.Dhw, localImageView);
      }
      else
      {
        a.b.c(localImageView, paramView.Did);
        continue;
        if ((paramView.DhZ) && ((!u.aqG().equals(paramView.dpv)) || (!paramView.dpv.equals(paramView.toUser))))
        {
          if ((af.aHH(paramView.dpv)) && (localafy.Dhx) && (!bt.isNullOrNil(localafy.Dhw)))
          {
            o.ayJ().loadImage(localafy.Dhw, localImageView);
          }
          else
          {
            alv(paramView.dpv);
            a.b.c(localImageView, paramView.dpv);
          }
        }
        else
        {
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.vbn = true;
          continue;
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.vbn = true;
          continue;
          if ((paramInt > 0) && (!this.vbn))
          {
            paramView = "";
            localObject1 = localafy.DgT.DhA;
            if (Kd(paramInt - 1).DgT.DhA.Die) {
              paramView = Kd(paramInt - 1).DgT.DhA.Did;
            }
            for (;;)
            {
              localImageView.setVisibility(0);
              if (!localafy.DgT.DhA.Die) {
                break label1103;
              }
              localObject2 = localafy.DgT.DhA.Did;
              if (paramView.equals(localObject2)) {
                break label1094;
              }
              alv((String)localObject2);
              if (!com.tencent.mm.am.a.e.xk(((aga)localObject1).Did)) {
                break label1041;
              }
              o.ayJ().loadImage(com.tencent.mm.am.a.e.xn(((aga)localObject1).Did), localImageView);
              break;
              if (Kd(paramInt - 1).DgT.DhA.DhZ) {
                paramView = Kd(paramInt - 1).DgT.DhA.dpv;
              }
            }
            if ((af.aHH((String)localObject2)) && (localafy.Dhx) && (!bt.isNullOrNil(localafy.Dhw)))
            {
              o.ayJ().loadImage(localafy.Dhw, localImageView);
            }
            else
            {
              a.b.c(localImageView, (String)localObject2);
              continue;
              localImageView.setVisibility(4);
              continue;
              if (localafy.DgT.DhA.DhZ)
              {
                localObject1 = localafy.DgT.DhA.dpv;
                if (!paramView.equals(localObject1))
                {
                  if ((af.aHH((String)localObject1)) && (localafy.Dhx) && (!bt.isNullOrNil(localafy.Dhw)))
                  {
                    o.ayJ().loadImage(localafy.Dhw, localImageView);
                  }
                  else
                  {
                    alv((String)localObject1);
                    a.b.c(localImageView, (String)localObject1);
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
    label696:
    label829:
    label1094:
    label1103:
    label1245:
    paramViewGroup.findViewById(2131303894).setVisibility(0);
    label1041:
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
    
    public abstract void dgj();
    
    public static final class a
    {
      public afy djJ;
      public ImageView djK;
      public int djL;
      public int height;
      public long vbr;
      public int width;
    }
    
    public static final class b
    {
      public afy djJ;
      public boolean djM;
      public boolean djN;
      public int maxWidth;
      public long vbr;
    }
    
    public static final class c
    {
      public afy djJ;
      public long vbr;
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