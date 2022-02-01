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
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.av.o;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public abstract class h
  extends BaseAdapter
{
  protected Context context;
  ListView mListView;
  private int padding = com.tencent.mm.cc.a.fromDPToPix(this.context, 35);
  private Runnable qLs = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(27870);
      ac.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
      h.this.notifyDataSetChanged();
      AppMethodBeat.o(27870);
    }
  };
  protected ao snT = null;
  protected List<agx> wjH = new LinkedList();
  i wjR;
  SparseArray<h.b> wjZ = new SparseArray();
  boolean wka = false;
  private boolean wkb = false;
  protected a wkc;
  protected a wkd;
  
  public h(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.snT = new ao(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(27869);
        if (paramAnonymousMessage.what == 1)
        {
          ac.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
          h.this.notifyDataSetChanged();
        }
        AppMethodBeat.o(27869);
      }
    };
    this.wkd = parama;
  }
  
  private agx Mc(int paramInt)
  {
    if (this.wjH == null) {}
    while ((paramInt < 0) || (paramInt >= this.wjH.size())) {
      return null;
    }
    return (agx)this.wjH.get(paramInt);
  }
  
  private static void aqu(String paramString)
  {
    if (!w.wG(paramString))
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = paramString;
      p.aBw().b(locali);
    }
  }
  
  private static int o(agx paramagx)
  {
    switch (paramagx.dataType)
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
    while (i < this.wjZ.size())
    {
      h.b localb = (h.b)this.wjZ.valueAt(i);
      if (localb != null) {
        localb.destroy();
      }
      i += 1;
    }
    if (this.wkd != null)
    {
      this.wkd.dtQ();
      this.wkd = null;
    }
  }
  
  public final void dtX()
  {
    this.wjZ.put(0, new d(this.context));
    this.wjZ.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.wkd, this.mListView));
    this.wjZ.put(2, new com.tencent.mm.plugin.record.ui.b.e());
    this.wjZ.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.wkd, this.snT));
    this.wjZ.put(4, new com.tencent.mm.plugin.record.ui.b.c(this.wkd));
  }
  
  protected final void dtY()
  {
    this.snT.post(this.qLs);
  }
  
  public int getCount()
  {
    if (this.wjH == null) {
      return 0;
    }
    return this.wjH.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return o(Mc(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    agx localagx = Mc(paramInt);
    Object localObject1 = (h.b)this.wjZ.get(o(localagx));
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((h.b)localObject1).createView(this.context);
    }
    ImageView localImageView;
    Object localObject2;
    Object localObject3;
    switch (localagx.dataType)
    {
    default: 
      paramView = new com.tencent.mm.plugin.record.ui.a.b();
      paramView.dhe = localagx;
      d(paramView);
      ((h.b)localObject1).a(paramViewGroup, paramInt, paramView, this.wjR);
      localImageView = (ImageView)paramViewGroup.findViewById(2131303892);
      localObject2 = (TextView)paramViewGroup.findViewById(2131303896);
      localObject1 = localagx.EAb;
      paramView = (View)localObject1;
      if (localagx.EzZ != null)
      {
        localObject3 = localagx.EzZ.EAG;
        if (!((agz)localObject3).EBk) {
          break;
        }
        localObject3 = v.wl(((agz)localObject3).EBj);
        paramView = (View)localObject1;
        if (!bs.isNullOrNil((String)localObject3)) {
          paramView = (String)localObject1 + "(" + (String)localObject3 + ")";
        }
      }
      label217:
      paramView = k.b(((TextView)localObject2).getContext(), paramView, ((TextView)localObject2).getTextSize());
      if (bs.isNullOrNil(localagx.EAA))
      {
        ((TextView)localObject2).setText(paramView);
        paramView = (TextView)paramViewGroup.findViewById(2131303895);
        ac.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[] { localagx.EAd });
        if (localagx.EAd != null)
        {
          if (!this.wka) {
            break label583;
          }
          localObject1 = localagx.EAd;
          paramView.setText(((String)localObject1).substring(((String)localObject1).indexOf("-") + 1));
        }
        label322:
        if (paramInt != 0) {
          break label864;
        }
        if (localagx.EzZ == null) {
          break label829;
        }
        paramView = localagx.EzZ.EAG;
        localImageView.setVisibility(0);
        if (!paramView.EBk) {
          break label696;
        }
        aqu(paramView.EBj);
        if (!com.tencent.mm.al.a.e.Bq(paramView.EBj)) {
          break label639;
        }
        o.aFB().loadImage(com.tencent.mm.al.a.e.Bt(paramView.EBj), localImageView);
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
      if (!((agz)localObject3).EBf) {
        break label217;
      }
      localObject3 = v.wl(((agz)localObject3).dng);
      paramView = (View)localObject1;
      if (bs.isNullOrNil((String)localObject3)) {
        break label217;
      }
      paramView = (String)localObject1 + "(" + (String)localObject3 + ")";
      break label217;
      localObject1 = localagx.EAA;
      if (localObject1 == null) {}
      for (;;)
      {
        ((TextView)localObject2).setText(paramView);
        break;
        paramView = new SpannableStringBuilder(paramView);
        int i = paramView.length();
        paramView.append((CharSequence)localObject1);
        int j = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(com.tencent.mm.sdk.platformtools.ai.getContext().getResources().getColor(2131100723)), i, j, 33);
      }
      localObject1 = localagx.EAd.split(" ");
      if (localObject1.length < 2)
      {
        paramView.setText(localagx.EAd);
        break label322;
      }
      paramView.setText(localagx.EAd.substring(localObject1[0].length() + 1));
      break label322;
      label639:
      if ((com.tencent.mm.storage.ai.aNc(paramView.EBj)) && (localagx.EAD) && (!bs.isNullOrNil(localagx.EAC)))
      {
        o.aFB().loadImage(localagx.EAC, localImageView);
      }
      else
      {
        a.b.c(localImageView, paramView.EBj);
        continue;
        if ((paramView.EBf) && ((!u.axw().equals(paramView.dng)) || (!paramView.dng.equals(paramView.toUser))))
        {
          if ((com.tencent.mm.storage.ai.aNc(paramView.dng)) && (localagx.EAD) && (!bs.isNullOrNil(localagx.EAC)))
          {
            o.aFB().loadImage(localagx.EAC, localImageView);
          }
          else
          {
            aqu(paramView.dng);
            a.b.c(localImageView, paramView.dng);
          }
        }
        else
        {
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.wkb = true;
          continue;
          localImageView.setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.wkb = true;
          continue;
          if ((paramInt > 0) && (!this.wkb))
          {
            paramView = "";
            localObject1 = localagx.EzZ.EAG;
            if (Mc(paramInt - 1).EzZ.EAG.EBk) {
              paramView = Mc(paramInt - 1).EzZ.EAG.EBj;
            }
            for (;;)
            {
              localImageView.setVisibility(0);
              if (!localagx.EzZ.EAG.EBk) {
                break label1103;
              }
              localObject2 = localagx.EzZ.EAG.EBj;
              if (paramView.equals(localObject2)) {
                break label1094;
              }
              aqu((String)localObject2);
              if (!com.tencent.mm.al.a.e.Bq(((agz)localObject1).EBj)) {
                break label1041;
              }
              o.aFB().loadImage(com.tencent.mm.al.a.e.Bt(((agz)localObject1).EBj), localImageView);
              break;
              if (Mc(paramInt - 1).EzZ.EAG.EBf) {
                paramView = Mc(paramInt - 1).EzZ.EAG.dng;
              }
            }
            if ((com.tencent.mm.storage.ai.aNc((String)localObject2)) && (localagx.EAD) && (!bs.isNullOrNil(localagx.EAC)))
            {
              o.aFB().loadImage(localagx.EAC, localImageView);
            }
            else
            {
              a.b.c(localImageView, (String)localObject2);
              continue;
              localImageView.setVisibility(4);
              continue;
              if (localagx.EzZ.EAG.EBf)
              {
                localObject1 = localagx.EzZ.EAG.dng;
                if (!paramView.equals(localObject1))
                {
                  if ((com.tencent.mm.storage.ai.aNc((String)localObject1)) && (localagx.EAD) && (!bs.isNullOrNil(localagx.EAC)))
                  {
                    o.aFB().loadImage(localagx.EAC, localImageView);
                  }
                  else
                  {
                    aqu((String)localObject1);
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
    
    public abstract void dtQ();
    
    public static final class a
    {
      public agx dhe;
      public ImageView dhf;
      public int dhg;
      public int height;
      public int width;
      public long wkf;
    }
    
    public static final class b
    {
      public agx dhe;
      public boolean dhh;
      public boolean dhi;
      public int maxWidth;
      public long wkf;
    }
    
    public static final class c
    {
      public agx dhe;
      public long wkf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.h
 * JD-Core Version:    0.7.0.1
 */