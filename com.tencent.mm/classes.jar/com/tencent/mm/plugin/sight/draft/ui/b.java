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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.l;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.ui.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
  extends p<com.tencent.mm.modelvideo.j>
{
  private int itemHeight;
  private int itemWidth;
  b.a qUN;
  private b.b qUO;
  private b.c qUP;
  private Set<b.e> qUQ;
  private b.d qUR;
  a qUS;
  int qUT;
  int qUU;
  private int qUV;
  private int qUW;
  private c qUX;
  b.e qUY;
  
  public b(Context paramContext, a parama)
  {
    super(paramContext, null);
    AppMethodBeat.i(25005);
    this.qUN = new b.a(this, (byte)0);
    this.qUO = new b.b(this, (byte)0);
    this.qUP = new b.c(this, (byte)0);
    this.qUQ = new HashSet();
    this.qUR = b.d.qVa;
    this.qUT = 2131303715;
    this.qUU = 0;
    this.qUX = new b.1(this);
    this.qUS = parama;
    int i = paramContext.getResources().getDimensionPixelSize(2131428676) * 2;
    this.qUV = (paramContext.getResources().getDisplayMetrics().widthPixels / 3);
    this.itemWidth = (this.qUV - i);
    this.itemHeight = (this.itemWidth * 3 / 4);
    this.qUW = (i + this.itemHeight);
    AppMethodBeat.o(25005);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(25010);
    Kv();
    super.notifyDataSetChanged();
    AppMethodBeat.o(25010);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(25011);
    setCursor(o.alI().alz());
    AppMethodBeat.o(25011);
  }
  
  final void a(b.e parame)
  {
    AppMethodBeat.i(25007);
    if (parame == null)
    {
      parame = this.qUQ.iterator();
      while (parame.hasNext()) {
        ((b.e)parame.next()).qVf.setVisibility(8);
      }
      AppMethodBeat.o(25007);
      return;
    }
    Iterator localIterator = this.qUQ.iterator();
    if (localIterator.hasNext())
    {
      b.e locale = (b.e)localIterator.next();
      View localView = locale.qVf;
      if (parame == locale) {}
      for (int i = 8;; i = 0)
      {
        localView.setVisibility(i);
        break;
      }
    }
    AppMethodBeat.o(25007);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(25009);
    this.qUQ.clear();
    super.a(paramString, paramm);
    AppMethodBeat.o(25009);
  }
  
  public final boolean a(b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(25008);
    if (paramd == this.qUR)
    {
      if ((paramBoolean) && (this.qUS != null)) {
        this.qUS.cmV();
      }
      AppMethodBeat.o(25008);
      return false;
    }
    this.qUR = paramd;
    this.qUN.cmW();
    notifyDataSetChanged();
    if ((paramBoolean) && (this.qUS != null)) {
      this.qUS.cmV();
    }
    AppMethodBeat.o(25008);
    return true;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(25012);
    int i = super.getCount() / 3;
    AppMethodBeat.o(25012);
    return i + 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(25006);
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
        localObject2 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970745, paramView, false);
        localObject3 = new b.e((byte)0);
        ((b.e)localObject3).gcq = ((View)localObject2);
        ((b.e)localObject3).gcq.setTag(localObject3);
        ((b.e)localObject3).qVd = ((View)localObject2).findViewById(2131827789);
        ((b.e)localObject3).qVe = ((com.tencent.mm.plugin.sight.decode.a.a)((View)localObject2).findViewById(2131827790));
        ((b.e)localObject3).mDg = ((ImageView)((View)localObject2).findViewById(2131827791));
        ((b.e)localObject3).qVf = ((View)localObject2).findViewById(2131827793);
        ((b.e)localObject3).ivt = ((TextView)((View)localObject2).findViewById(2131827792));
        ((b.e)localObject3).ivt.setText(this.qUT);
        ((b.e)localObject3).qKC = ((ImageView)((View)localObject2).findViewById(2131827794));
        ((b.f)localObject1).qVh.add(localObject3);
        localObject4 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject4).height = this.qUW;
        paramView.addView((View)localObject2);
        ((View)localObject2).setOnClickListener(this.qUN);
        ((b.e)localObject3).qKC.setTag(localObject3);
        ((b.e)localObject3).qKC.setOnClickListener(this.qUP);
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
        if (i >= paramViewGroup.qVh.size()) {
          break label666;
        }
        j = paramInt * 3 + i;
        localObject1 = (b.e)paramViewGroup.qVh.get(i);
        this.qUQ.add(localObject1);
        ((b.e)localObject1).qVf.setVisibility(8);
        ((b.e)localObject1).ivt.setVisibility(8);
        ((b.e)localObject1).mDg.setBackgroundResource(2130840324);
        ((b.e)localObject1).qVe.bl(null, false);
        ((b.e)localObject1).qVe.setCanPlay(false);
        ((b.e)localObject1).qVe.setForceRecordState(false);
        ((ImageView)((b.e)localObject1).qVe).setBackgroundResource(0);
        if (j < getRealCount()) {
          break;
        }
        ((b.e)localObject1).qVg = null;
        ((b.e)localObject1).gcq.setVisibility(4);
        com.tencent.mm.ui.tools.j.s(((b.e)localObject1).qVd, 1.0F);
        i += 1;
      }
    }
    this.qUU -= 1;
    Object localObject4 = (com.tencent.mm.modelvideo.j)getItem(j);
    aw.aaz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ((b.e)localObject1).qVg = null;
      ((b.e)localObject1).qVe.cmx();
      if (b.d.qVb != this.qUR) {
        break label644;
      }
      ((b.e)localObject1).qKC.setVisibility(0);
      com.tencent.mm.ui.tools.j.s(((b.e)localObject1).qVd, 0.95F);
    }
    for (;;)
    {
      ((b.e)localObject1).gcq.setVisibility(0);
      break;
      ((b.e)localObject1).qVg = ((com.tencent.mm.modelvideo.j)localObject4);
      localObject2 = this.qUX;
      localObject3 = ((com.tencent.mm.modelvideo.j)localObject4).field_fileName;
      localObject4 = k.uW(((com.tencent.mm.modelvideo.j)localObject4).field_fileName);
      if (this.qUU <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = ((c)localObject2).x((String)localObject3, (String)localObject4, bool);
        ((ImageView)((b.e)localObject1).qVe).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((b.e)localObject1).qVe.setThumbBmp((Bitmap)localObject2);
        break;
      }
      label644:
      ((b.e)localObject1).qKC.setVisibility(8);
      com.tencent.mm.ui.tools.j.s(((b.e)localObject1).qVd, 1.0F);
    }
    label666:
    AppMethodBeat.o(25006);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b
 * JD-Core Version:    0.7.0.1
 */