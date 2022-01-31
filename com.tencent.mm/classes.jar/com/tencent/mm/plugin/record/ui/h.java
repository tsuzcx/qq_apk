package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.R.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public abstract class h
  extends BaseAdapter
{
  ListView Nn;
  protected Context context;
  private Runnable kbl = new h.2(this);
  protected ah ntK = null;
  SparseArray<h.b> ntL = new SparseArray();
  boolean ntM = false;
  private boolean ntN = false;
  protected a ntO;
  protected h.a ntP;
  protected List<xv> ntu = new LinkedList();
  private int padding = com.tencent.mm.cb.a.fromDPToPix(this.context, 35);
  
  public h(Context paramContext, h.a parama)
  {
    this.context = paramContext;
    this.ntK = new ah(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          y.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
          h.this.notifyDataSetChanged();
        }
      }
    };
    this.ntP = parama;
  }
  
  private static void LJ(String paramString)
  {
    if (!s.hk(paramString))
    {
      com.tencent.mm.ag.h localh = new com.tencent.mm.ag.h();
      localh.username = paramString;
      com.tencent.mm.ag.o.Kh().a(localh);
    }
  }
  
  private static int m(xv paramxv)
  {
    switch (paramxv.aYU)
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
  
  private xv wC(int paramInt)
  {
    if (this.ntu == null) {}
    while ((paramInt < 0) || (paramInt >= this.ntu.size())) {
      return null;
    }
    return (xv)this.ntu.get(paramInt);
  }
  
  public abstract void a(a parama);
  
  public final void bvJ()
  {
    this.ntL.put(0, new d(this.context));
    this.ntL.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.ntP, this.Nn));
    this.ntL.put(2, new com.tencent.mm.plugin.record.ui.b.e());
    this.ntL.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.ntP, this.ntK));
    this.ntL.put(4, new com.tencent.mm.plugin.record.ui.b.c(this.ntP));
  }
  
  protected final void bvK()
  {
    this.ntK.post(this.kbl);
  }
  
  public abstract void d(com.tencent.mm.plugin.record.ui.a.b paramb);
  
  public final void destroy()
  {
    int i = 0;
    while (i < this.ntL.size())
    {
      h.b localb = (h.b)this.ntL.valueAt(i);
      if (localb != null) {
        localb.destroy();
      }
      i += 1;
    }
    if (this.ntP != null)
    {
      this.ntP.bvC();
      this.ntP = null;
    }
  }
  
  public int getCount()
  {
    if (this.ntu == null) {
      return 0;
    }
    return this.ntu.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return m(wC(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1 = wC(paramInt);
    Object localObject2 = (h.b)this.ntL.get(m((xv)localObject1));
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = ((h.b)localObject2).dZ(this.context);
    }
    Object localObject3;
    switch (((xv)localObject1).aYU)
    {
    default: 
      paramView = new com.tencent.mm.plugin.record.ui.a.b();
      paramView.bNt = ((xv)localObject1);
      d(paramView);
      ((h.b)localObject2).a(paramViewGroup, paramInt, paramView);
      localObject2 = (ImageView)paramViewGroup.findViewById(R.h.record_listitem_avatar);
      localObject3 = (TextView)paramViewGroup.findViewById(R.h.record_listitem_title);
      paramView = j.a(((TextView)localObject3).getContext(), ((xv)localObject1).sVC, ((TextView)localObject3).getTextSize());
      if (bk.bl(((xv)localObject1).sWb))
      {
        ((TextView)localObject3).setText(paramView);
        paramView = (TextView)paramViewGroup.findViewById(R.h.record_listitem_time);
        y.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[] { ((xv)localObject1).sVE });
        if (((xv)localObject1).sVE != null)
        {
          if (!this.ntM) {
            break label427;
          }
          localObject3 = ((xv)localObject1).sVE;
          paramView.setText(((String)localObject3).substring(((String)localObject3).indexOf("-") + 1));
        }
        label234:
        if (paramInt != 0) {
          break label626;
        }
        if (((xv)localObject1).sVA == null) {
          break label591;
        }
        paramView = ((xv)localObject1).sVA.sWd;
        ((ImageView)localObject2).setVisibility(0);
        if (!paramView.sWC) {
          break label499;
        }
        LJ(paramView.sWB);
        if (!com.tencent.mm.ai.a.e.lq(paramView.sWB)) {
          break label483;
        }
        com.tencent.mm.as.o.ON().a(com.tencent.mm.ai.a.e.lt(paramView.sWB), (ImageView)localObject2);
      }
      break;
    }
    label427:
    label483:
    label626:
    for (;;)
    {
      if (paramInt != getCount() - 1) {
        break label929;
      }
      paramViewGroup.findViewById(R.h.record_listitem_end_divider).setVisibility(8);
      return paramViewGroup;
      paramView = new com.tencent.mm.plugin.record.ui.a.a();
      break;
      paramView = new com.tencent.mm.plugin.record.ui.a.c();
      break;
      String str = ((xv)localObject1).sWb;
      if (str == null) {}
      for (;;)
      {
        ((TextView)localObject3).setText(paramView);
        break;
        paramView = new SpannableStringBuilder(paramView);
        int i = paramView.length();
        paramView.append(str);
        int j = paramView.length();
        paramView.setSpan(new ForegroundColorSpan(ae.getContext().getResources().getColor(com.tencent.mm.plugin.comm.a.b.open_im_display_name_color)), i, j, 33);
      }
      localObject3 = ((xv)localObject1).sVE.split(" ");
      if (localObject3.length < 2)
      {
        paramView.setText(((xv)localObject1).sVE);
        break label234;
      }
      paramView.setText(((xv)localObject1).sVE.substring(localObject3[0].length() + 1));
      break label234;
      com.tencent.mm.pluginsdk.ui.a.b.a((ImageView)localObject2, paramView.sWB, 0.1F, false);
      continue;
      label499:
      if ((paramView.sWx) && ((!q.Gj().equals(paramView.bRO)) || (!paramView.bRO.equals(paramView.toUser))))
      {
        LJ(paramView.bRO);
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView)localObject2, paramView.bRO, 0.1F, false);
      }
      else
      {
        ((ImageView)localObject2).setVisibility(8);
        paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
        this.ntN = true;
        continue;
        ((ImageView)localObject2).setVisibility(8);
        paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
        this.ntN = true;
        continue;
        if ((paramInt > 0) && (!this.ntN))
        {
          paramView = "";
          localObject3 = ((xv)localObject1).sVA.sWd;
          if (wC(paramInt - 1).sVA.sWd.sWC) {
            paramView = wC(paramInt - 1).sVA.sWd.sWB;
          }
          for (;;)
          {
            ((ImageView)localObject2).setVisibility(0);
            if (!((xv)localObject1).sVA.sWd.sWC) {
              break label826;
            }
            localObject1 = ((xv)localObject1).sVA.sWd.sWB;
            if (paramView.equals(localObject1)) {
              break label817;
            }
            LJ((String)localObject1);
            if (!com.tencent.mm.ai.a.e.lq(((xx)localObject3).sWB)) {
              break label803;
            }
            com.tencent.mm.as.o.ON().a(com.tencent.mm.ai.a.e.lt(((xx)localObject3).sWB), (ImageView)localObject2);
            break;
            if (wC(paramInt - 1).sVA.sWd.sWx) {
              paramView = wC(paramInt - 1).sVA.sWd.bRO;
            }
          }
          com.tencent.mm.pluginsdk.ui.a.b.a((ImageView)localObject2, (String)localObject1, 0.1F, false);
          continue;
          ((ImageView)localObject2).setVisibility(4);
          continue;
          if (((xv)localObject1).sVA.sWd.sWx)
          {
            localObject1 = ((xv)localObject1).sVA.sWd.bRO;
            if (!paramView.equals(localObject1))
            {
              LJ((String)localObject1);
              com.tencent.mm.pluginsdk.ui.a.b.a((ImageView)localObject2, (String)localObject1, 0.1F, false);
            }
            else
            {
              ((ImageView)localObject2).setVisibility(4);
            }
          }
          else
          {
            ((ImageView)localObject2).setVisibility(4);
          }
        }
        else
        {
          ((ImageView)localObject2).setVisibility(8);
          paramViewGroup.setPadding(this.padding, paramViewGroup.getPaddingTop(), this.padding, paramViewGroup.getPaddingBottom());
        }
      }
    }
    label591:
    paramViewGroup.findViewById(R.h.record_listitem_end_divider).setVisibility(0);
    label803:
    label817:
    label826:
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.h
 * JD-Core Version:    0.7.0.1
 */