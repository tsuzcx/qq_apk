package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.h;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
  extends r<j>
{
  private int iAj;
  private int ixe;
  private b.c ogA = new b.c(this, (byte)0);
  private Set<b.e> ogB = new HashSet();
  private b.d ogC = b.d.ogL;
  a ogD;
  int ogE = R.l.sight_draft_send;
  int ogF = 0;
  private int ogG;
  private int ogH;
  private c ogI = new b.1(this);
  b.e ogJ;
  b.a ogy = new b.a(this, (byte)0);
  private b.b ogz = new b.b(this, (byte)0);
  
  public b(Context paramContext, a parama)
  {
    super(paramContext, null);
    this.ogD = parama;
    int i = paramContext.getResources().getDimensionPixelSize(R.f.sight_draft_padding) * 2;
    this.ogG = (paramContext.getResources().getDisplayMetrics().widthPixels / 3);
    this.iAj = (this.ogG - i);
    this.ixe = (this.iAj * 3 / 4);
    this.ogH = (i + this.ixe);
  }
  
  final void a(b.e parame)
  {
    if (parame == null)
    {
      parame = this.ogB.iterator();
      while (parame.hasNext()) {
        ((b.e)parame.next()).ogQ.setVisibility(8);
      }
    }
    Iterator localIterator = this.ogB.iterator();
    if (localIterator.hasNext())
    {
      b.e locale = (b.e)localIterator.next();
      View localView = locale.ogQ;
      if (parame == locale) {}
      for (int i = 8;; i = 0)
      {
        localView.setVisibility(i);
        break;
      }
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    this.ogB.clear();
    super.a(paramString, paraml);
  }
  
  public final boolean a(b.d paramd, boolean paramBoolean)
  {
    if (paramd == this.ogC)
    {
      if ((paramBoolean) && (this.ogD != null)) {
        this.ogD.bBv();
      }
      return false;
    }
    this.ogC = paramd;
    this.ogy.bBw();
    notifyDataSetChanged();
    if ((paramBoolean) && (this.ogD != null)) {
      this.ogD.bBv();
    }
    return true;
  }
  
  public final int getCount()
  {
    return super.getCount() / 3 + 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = new b.f((byte)0);
      paramView = new LinearLayout(paramViewGroup.getContext());
      paramView.setOrientation(0);
      i = 0;
      while (i < 3)
      {
        localObject2 = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.sight_draft_list_item, paramView, false);
        localObject3 = new b.e((byte)0);
        ((b.e)localObject3).eML = ((View)localObject2);
        ((b.e)localObject3).eML.setTag(localObject3);
        ((b.e)localObject3).ogO = ((View)localObject2).findViewById(R.h.sight_play_area);
        ((b.e)localObject3).ogP = ((com.tencent.mm.plugin.sight.decode.a.a)((View)localObject2).findViewById(R.h.sight_view));
        ((b.e)localObject3).kiB = ((ImageView)((View)localObject2).findViewById(R.h.sight_view_mask));
        ((b.e)localObject3).ogQ = ((View)localObject2).findViewById(R.h.shadow_mask);
        ((b.e)localObject3).gSy = ((TextView)((View)localObject2).findViewById(R.h.sight_tips_tv));
        ((b.e)localObject3).gSy.setText(this.ogE);
        ((b.e)localObject3).nWs = ((ImageView)((View)localObject2).findViewById(R.h.sight_del_btn));
        ((b.f)localObject1).ogS.add(localObject3);
        localObject4 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject4).height = this.ogH;
        paramView.addView((View)localObject2);
        ((View)localObject2).setOnClickListener(this.ogy);
        ((b.e)localObject3).nWs.setTag(localObject3);
        ((b.e)localObject3).nWs.setOnClickListener(this.ogA);
        i += 1;
      }
      paramView.setTag(localObject1);
    }
    int j;
    for (paramViewGroup = (ViewGroup)localObject1;; paramViewGroup = (b.f)paramView.getTag())
    {
      i = 0;
      for (;;)
      {
        if (i >= paramViewGroup.ogS.size()) {
          return paramView;
        }
        j = paramInt * 3 + i;
        localObject1 = (b.e)paramViewGroup.ogS.get(i);
        this.ogB.add(localObject1);
        ((b.e)localObject1).ogQ.setVisibility(8);
        ((b.e)localObject1).gSy.setVisibility(8);
        ((b.e)localObject1).kiB.setBackgroundResource(R.g.sight_draft_mask);
        ((b.e)localObject1).ogP.aW(null, false);
        ((b.e)localObject1).ogP.setCanPlay(false);
        ((b.e)localObject1).ogP.setForceRecordState(false);
        ((ImageView)((b.e)localObject1).ogP).setBackgroundResource(0);
        if (j < getRealCount()) {
          break;
        }
        ((b.e)localObject1).ogR = null;
        ((b.e)localObject1).eML.setVisibility(4);
        h.p(((b.e)localObject1).ogO, 1.0F);
        i += 1;
      }
    }
    this.ogF -= 1;
    Object localObject4 = (j)getItem(j);
    au.Hx();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ((b.e)localObject1).ogR = null;
      ((b.e)localObject1).ogP.bAX();
      if (b.d.ogM != this.ogC) {
        break label639;
      }
      ((b.e)localObject1).nWs.setVisibility(0);
      h.p(((b.e)localObject1).ogO, 0.95F);
    }
    for (;;)
    {
      ((b.e)localObject1).eML.setVisibility(0);
      break;
      ((b.e)localObject1).ogR = ((j)localObject4);
      localObject2 = this.ogI;
      localObject3 = ((j)localObject4).field_fileName;
      localObject4 = k.nJ(((j)localObject4).field_fileName);
      if (this.ogF <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = ((c)localObject2).r((String)localObject3, (String)localObject4, bool);
        ((ImageView)((b.e)localObject1).ogP).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((b.e)localObject1).ogP.setThumbBmp((Bitmap)localObject2);
        break;
      }
      label639:
      ((b.e)localObject1).nWs.setVisibility(8);
      h.p(((b.e)localObject1).ogO, 1.0F);
    }
    return paramView;
  }
  
  public final void yc()
  {
    yd();
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    setCursor(o.Sv().dXw.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[] { "1" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b
 * JD-Core Version:    0.7.0.1
 */