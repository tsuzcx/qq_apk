package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.LinkedList;
import java.util.List;

public abstract class h
  extends BaseAdapter
{
  protected Context context;
  protected ak mHV = null;
  ListView mListView;
  private Runnable mvH = new h.2(this);
  protected List<aca> pZa = new LinkedList();
  i pZk;
  SparseArray<h.b> pZs = new SparseArray();
  boolean pZt = false;
  private boolean pZu = false;
  protected a pZv;
  protected h.a pZw;
  private int padding = com.tencent.mm.cb.a.fromDPToPix(this.context, 35);
  
  public h(Context paramContext, h.a parama)
  {
    this.context = paramContext;
    this.mHV = new h.1(this, Looper.getMainLooper());
    this.pZw = parama;
  }
  
  private aca Cn(int paramInt)
  {
    if (this.pZa == null) {}
    while ((paramInt < 0) || (paramInt >= this.pZa.size())) {
      return null;
    }
    return (aca)this.pZa.get(paramInt);
  }
  
  private static void XU(String paramString)
  {
    if (!t.nT(paramString))
    {
      com.tencent.mm.ah.h localh = new com.tencent.mm.ah.h();
      localh.username = paramString;
      com.tencent.mm.ah.o.adg().b(localh);
    }
  }
  
  private static int m(aca paramaca)
  {
    switch (paramaca.dataType)
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
  
  public final void cga()
  {
    this.pZs.put(0, new d(this.context));
    this.pZs.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.pZw, this.mListView));
    this.pZs.put(2, new com.tencent.mm.plugin.record.ui.b.e());
    this.pZs.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.pZw, this.mHV));
    this.pZs.put(4, new com.tencent.mm.plugin.record.ui.b.c(this.pZw));
  }
  
  protected final void cgb()
  {
    this.mHV.post(this.mvH);
  }
  
  public abstract void d(com.tencent.mm.plugin.record.ui.a.b paramb);
  
  public final void destroy()
  {
    int i = 0;
    while (i < this.pZs.size())
    {
      h.b localb = (h.b)this.pZs.valueAt(i);
      if (localb != null) {
        localb.destroy();
      }
      i += 1;
    }
    if (this.pZw != null)
    {
      this.pZw.cfT();
      this.pZw = null;
    }
  }
  
  public int getCount()
  {
    if (this.pZa == null) {
      return 0;
    }
    return this.pZa.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return m(Cn(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    aca localaca = Cn(paramInt);
    Object localObject1 = (h.b)this.pZs.get(m(localaca));
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((h.b)localObject1).createView(this.context);
    }
    Object localObject2;
    switch (localaca.dataType)
    {
    default: 
      paramView = new com.tencent.mm.plugin.record.ui.a.b();
      paramView.cuL = localaca;
      d(paramView);
      ((h.b)localObject1).a(paramViewGroup, paramInt, paramView, this.pZk);
      localObject1 = (ImageView)paramViewGroup.findViewById(2131820659);
      localObject2 = (TextView)paramViewGroup.findViewById(2131827106);
      paramView = j.b(((TextView)localObject2).getContext(), localaca.wTy, ((TextView)localObject2).getTextSize());
      if (bo.isNullOrNil(localaca.wTX))
      {
        ((TextView)localObject2).setText(paramView);
        paramView = (TextView)paramViewGroup.findViewById(2131827107);
        ab.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[] { localaca.wTA });
        if (localaca.wTA != null)
        {
          if (!this.pZt) {
            break label428;
          }
          localObject2 = localaca.wTA;
          paramView.setText(((String)localObject2).substring(((String)localObject2).indexOf("-") + 1));
        }
        label235:
        if (paramInt != 0) {
          break label709;
        }
        if (localaca.wTw == null) {
          break label674;
        }
        paramView = localaca.wTw.wUb;
        ((ImageView)localObject1).setVisibility(0);
        if (!paramView.wUB) {
          break label541;
        }
        XU(paramView.wUA);
        if (!com.tencent.mm.aj.a.e.sm(paramView.wUA)) {
          break label484;
        }
        com.tencent.mm.at.o.ahG().a(com.tencent.mm.aj.a.e.sp(paramView.wUA), (ImageView)localObject1);
      }
      break;
    }
    label428:
    label709:
    for (;;)
    {
      if (paramInt != getCount() - 1) {
        break label1090;
      }
      paramViewGroup.findViewById(2131820660).setVisibility(8);
      return paramViewGroup;
      paramView = new com.tencent.mm.plugin.record.ui.a.a();
      break;
      paramView = new com.tencent.mm.plugin.record.ui.a.c();
      break;
      String str = localaca.wTX;
      if (str == null) {}
      for (;;)
      {
        ((TextView)localObject2).setText(paramView);
        break;
        paramView = new SpannableStringBuilder(paramView);
        int i = paramView.length();
        paramView.append(str);
        int j = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(ah.getContext().getResources().getColor(2131690334)), i, j, 33);
      }
      localObject2 = localaca.wTA.split(" ");
      if (localObject2.length < 2)
      {
        paramView.setText(localaca.wTA);
        break label235;
      }
      paramView.setText(localaca.wTA.substring(localObject2[0].length() + 1));
      break label235;
      label484:
      if ((ad.arf(paramView.wUA)) && (localaca.wUa) && (!bo.isNullOrNil(localaca.wTZ)))
      {
        com.tencent.mm.at.o.ahG().a(localaca.wTZ, (ImageView)localObject1);
      }
      else
      {
        a.b.c((ImageView)localObject1, paramView.wUA);
        continue;
        if ((paramView.wUw) && ((!r.Zn().equals(paramView.czp)) || (!paramView.czp.equals(paramView.toUser))))
        {
          if ((ad.arf(paramView.czp)) && (localaca.wUa) && (!bo.isNullOrNil(localaca.wTZ)))
          {
            com.tencent.mm.at.o.ahG().a(localaca.wTZ, (ImageView)localObject1);
          }
          else
          {
            XU(paramView.czp);
            a.b.c((ImageView)localObject1, paramView.czp);
          }
        }
        else
        {
          ((ImageView)localObject1).setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.pZu = true;
          continue;
          ((ImageView)localObject1).setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          this.pZu = true;
          continue;
          if ((paramInt > 0) && (!this.pZu))
          {
            paramView = "";
            localObject2 = localaca.wTw.wUb;
            if (Cn(paramInt - 1).wTw.wUb.wUB) {
              paramView = Cn(paramInt - 1).wTw.wUb.wUA;
            }
            for (;;)
            {
              ((ImageView)localObject1).setVisibility(0);
              if (!localaca.wTw.wUb.wUB) {
                break label948;
              }
              str = localaca.wTw.wUb.wUA;
              if (paramView.equals(str)) {
                break label939;
              }
              XU(str);
              if (!com.tencent.mm.aj.a.e.sm(((acc)localObject2).wUA)) {
                break label886;
              }
              com.tencent.mm.at.o.ahG().a(com.tencent.mm.aj.a.e.sp(((acc)localObject2).wUA), (ImageView)localObject1);
              break;
              if (Cn(paramInt - 1).wTw.wUb.wUw) {
                paramView = Cn(paramInt - 1).wTw.wUb.czp;
              }
            }
            label886:
            if ((ad.arf(str)) && (localaca.wUa) && (!bo.isNullOrNil(localaca.wTZ)))
            {
              com.tencent.mm.at.o.ahG().a(localaca.wTZ, (ImageView)localObject1);
            }
            else
            {
              a.b.c((ImageView)localObject1, str);
              continue;
              ((ImageView)localObject1).setVisibility(4);
              continue;
              if (localaca.wTw.wUb.wUw)
              {
                localObject2 = localaca.wTw.wUb.czp;
                if (!paramView.equals(localObject2))
                {
                  if ((ad.arf((String)localObject2)) && (localaca.wUa) && (!bo.isNullOrNil(localaca.wTZ)))
                  {
                    com.tencent.mm.at.o.ahG().a(localaca.wTZ, (ImageView)localObject1);
                  }
                  else
                  {
                    XU((String)localObject2);
                    a.b.c((ImageView)localObject1, (String)localObject2);
                  }
                }
                else {
                  ((ImageView)localObject1).setVisibility(4);
                }
              }
              else
              {
                ((ImageView)localObject1).setVisibility(4);
              }
            }
          }
          else
          {
            ((ImageView)localObject1).setVisibility(8);
            paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
          }
        }
      }
    }
    label541:
    label674:
    label939:
    label948:
    label1090:
    paramViewGroup.findViewById(2131820660).setVisibility(0);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.h
 * JD-Core Version:    0.7.0.1
 */