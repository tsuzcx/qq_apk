package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.el;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
  extends BaseAdapter
{
  private final Activity bMV;
  private final ah handler = new ah();
  private String lCN = "";
  final List<awd> list = new ArrayList();
  final Map<Integer, Integer> oMs = new HashMap();
  final Map<Integer, Integer> oMt = new HashMap();
  int oMu = 0;
  int oMv = 0;
  private final f.b oMw;
  private final g oMx;
  final a oMy;
  el oMz;
  
  public f(Activity paramActivity, String paramString, f.b paramb, a parama)
  {
    this.bMV = paramActivity;
    this.lCN = paramString;
    this.oMw = paramb;
    this.oMy = parama;
    this.oMx = new g(new f.1(this));
    yc();
  }
  
  private void a(int paramInt, ImageView paramImageView)
  {
    awd localawd = (awd)getItem(paramInt);
    paramImageView.setVisibility(0);
    f.b.a locala = new f.b.a();
    locala.bRV = "";
    locala.position = paramInt;
    paramImageView.setTag(locala);
    af.bDC().b(localawd, paramImageView, this.bMV.hashCode(), az.uBK);
  }
  
  public final int getCount()
  {
    return this.oMu;
  }
  
  public final Object getItem(int paramInt)
  {
    return this.list.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new f.c(this);
      paramView = View.inflate(this.bMV, i.g.sns_artist_item, null);
      paramViewGroup.fcy = ((TextView)paramView.findViewById(i.f.sns_title));
      paramViewGroup.oMG = ((TextView)paramView.findViewById(i.f.sns_title_en));
      paramViewGroup.oMH = ((ImageView)paramView.findViewById(i.f.img1));
      paramViewGroup.oMI = ((ImageView)paramView.findViewById(i.f.img2));
      paramViewGroup.oMJ = ((ImageView)paramView.findViewById(i.f.img3));
      paramViewGroup.oMK = ((LinearLayout)paramView.findViewById(i.f.listener_keeper));
      paramViewGroup.oML = paramView.findViewById(i.f.line_add);
      paramViewGroup.oMH.setOnClickListener(this.oMw.oMB);
      paramViewGroup.oMI.setOnClickListener(this.oMw.oMC);
      paramViewGroup.oMJ.setOnClickListener(this.oMw.oMD);
      paramView.setTag(paramViewGroup);
      if (this.oMs.get(Integer.valueOf(paramInt)) == null) {
        break label633;
      }
    }
    label339:
    label633:
    for (int i = ((Integer)this.oMs.get(Integer.valueOf(paramInt))).intValue();; i = -1)
    {
      paramViewGroup.oMH.setVisibility(8);
      paramViewGroup.oMI.setVisibility(8);
      paramViewGroup.oMJ.setVisibility(8);
      paramViewGroup.oML.setVisibility(8);
      if (paramViewGroup.oMA.lCN.equals("en"))
      {
        paramViewGroup.fcy.setVisibility(8);
        paramViewGroup.oMG.setVisibility(4);
      }
      for (;;)
      {
        if ((i < this.oMv) && (i != -1)) {
          break label339;
        }
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
        paramView.setVisibility(8);
        return paramView;
        paramViewGroup = (f.c)paramView.getTag();
        break;
        paramViewGroup.fcy.setVisibility(4);
        paramViewGroup.oMG.setVisibility(8);
      }
      if (i - 1 >= 0) {}
      for (String str = ((awd)getItem(i - 1)).kRN;; str = "")
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        paramView.setVisibility(0);
        if (this.oMt.get(Integer.valueOf(paramInt)) != null) {}
        for (paramInt = ((Integer)this.oMt.get(Integer.valueOf(paramInt))).intValue();; paramInt = 1)
        {
          awd localawd = (awd)getItem(i);
          if ((localawd.kRN.equals("")) || (!localawd.kRN.equals(str)))
          {
            if (!this.lCN.equals("en")) {
              break label577;
            }
            paramViewGroup.oMG.setVisibility(0);
            paramViewGroup.oMG.setText(localawd.kRN);
            paramViewGroup.oML.setVisibility(0);
          }
          for (;;)
          {
            if (paramInt > 0) {
              a(i, paramViewGroup.oMH);
            }
            if (paramInt >= 2) {
              a(i + 1, paramViewGroup.oMI);
            }
            if (paramInt >= 3) {
              a(i + 2, paramViewGroup.oMJ);
            }
            if (this.oMy == null) {
              break;
            }
            this.oMy.b(this.oMz);
            return paramView;
            paramViewGroup.fcy.setVisibility(0);
            paramViewGroup.fcy.setText(localawd.kRN);
            paramViewGroup.oML.setVisibility(0);
          }
        }
      }
    }
  }
  
  public final void yc()
  {
    if (this.oMx != null)
    {
      r.PK();
      String str = n.PH();
      y.d("MicroMsg.ArtistAdapter", "packgePath: " + str);
      this.oMx.eZ(this.lCN, str);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(el paramel);
    
    public abstract void b(el paramel);
    
    public abstract void bHh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f
 * JD-Core Version:    0.7.0.1
 */