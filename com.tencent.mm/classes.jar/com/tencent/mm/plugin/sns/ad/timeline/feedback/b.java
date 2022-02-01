package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class b
  implements View.OnClickListener
{
  private TextView awK;
  private View ijA;
  private Context mContext;
  private WeImageView xLi;
  private WeImageView xLj;
  private TextView xLk;
  private View xLl;
  private View xLm;
  private WeImageView xLn;
  private View xLo;
  private WeImageView xLp;
  private View xLq;
  private WeImageView xLr;
  private View xLs;
  ViewGroup xLt;
  View xLu;
  private TextView xLv;
  c xLw;
  private b xLx;
  
  b(Context paramContext, b paramb, c paramc)
  {
    this.mContext = paramContext;
    this.xLx = paramb;
    this.xLw = paramc;
  }
  
  private com.tencent.mm.plugin.sns.data.b dFS()
  {
    AppMethodBeat.i(199979);
    Object localObject = this.xLx.asF("unlike_tag").get("unlike_tag");
    if ((localObject instanceof com.tencent.mm.plugin.sns.data.b))
    {
      localObject = (com.tencent.mm.plugin.sns.data.b)localObject;
      AppMethodBeat.o(199979);
      return localObject;
    }
    AppMethodBeat.o(199979);
    return null;
  }
  
  public final void NX(int paramInt)
  {
    AppMethodBeat.i(199980);
    if ((this.xLi != null) && (this.xLj != null))
    {
      if (paramInt < 0)
      {
        this.xLi.setVisibility(8);
        this.xLj.setVisibility(0);
        AppMethodBeat.o(199980);
        return;
      }
      this.xLi.setVisibility(0);
      this.xLj.setVisibility(8);
    }
    AppMethodBeat.o(199980);
  }
  
  public final void ez(View paramView)
  {
    AppMethodBeat.i(199977);
    this.ijA = paramView;
    this.xLi = ((WeImageView)this.ijA.findViewById(2131308002));
    this.xLj = ((WeImageView)this.ijA.findViewById(2131307982));
    this.xLk = ((TextView)this.ijA.findViewById(2131307999));
    this.xLl = this.ijA.findViewById(2131307992);
    this.xLq = this.ijA.findViewById(2131307988);
    this.xLr = ((WeImageView)this.ijA.findViewById(2131307987));
    this.xLs = this.ijA.findViewById(2131307994);
    this.xLo = this.ijA.findViewById(2131307997);
    this.xLp = ((WeImageView)this.ijA.findViewById(2131307996));
    this.xLm = this.ijA.findViewById(2131307986);
    this.xLn = ((WeImageView)this.ijA.findViewById(2131307985));
    this.xLt = ((ViewGroup)this.ijA.findViewById(2131307993));
    this.xLu = this.ijA.findViewById(2131307990);
    this.awK = ((TextView)this.ijA.findViewById(2131308001));
    this.xLv = ((TextView)this.ijA.findViewById(2131308000));
    if (this.xLi != null) {
      this.xLi.setImageResource(2131691560);
    }
    if (this.xLj != null)
    {
      this.xLj.setImageResource(2131691560);
      this.xLj.setRotation(180.0F);
    }
    if (this.awK != null)
    {
      paramView = this.xLx;
      if (paramView != null)
      {
        paramView = paramView.asF("expand_title");
        if (com.tencent.mm.plugin.sns.ad.e.b.aA(paramView))
        {
          paramView = paramView.get("expand_title");
          if ((paramView instanceof CharSequence)) {
            this.awK.setText((CharSequence)paramView);
          }
        }
      }
    }
    if (this.xLp != null) {
      this.xLp.setImageResource(2131691558);
    }
    if (this.xLn != null) {
      this.xLn.setImageResource(2131691557);
    }
    if (this.xLr != null) {
      this.xLr.setImageResource(2131691559);
    }
    if (this.xLo != null) {
      this.xLo.setOnClickListener(this);
    }
    if (this.xLm != null) {
      this.xLm.setOnClickListener(this);
    }
    if (this.xLq != null) {
      this.xLq.setOnClickListener(this);
    }
    if (this.xLu != null) {
      this.xLu.setOnClickListener(this);
    }
    if (this.xLt != null)
    {
      paramView = this.xLx;
      if (paramView == null) {
        break label821;
      }
      paramView = paramView.asF("reason_list");
      if (!com.tencent.mm.plugin.sns.ad.e.b.aA(paramView)) {
        break label821;
      }
      paramView = paramView.get("reason_list");
      if (!(paramView instanceof Collection)) {
        break label821;
      }
    }
    label821:
    for (paramView = (Collection)paramView;; paramView = null)
    {
      if (com.tencent.mm.plugin.sns.ad.e.b.m(paramView))
      {
        paramView = paramView.iterator();
        while (paramView.hasNext())
        {
          d locald = (d)paramView.next();
          Context localContext = this.mContext;
          String str = locald.xLA;
          TextView localTextView = new TextView(localContext);
          localTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          localTextView.setSingleLine(true);
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
          localTextView.setBackgroundResource(2131234964);
          localTextView.setTextColor(this.mContext.getResources().getColorStateList(2131101213));
          int i = a.fromDPToPix(localContext, 12);
          int j = a.fromDPToPix(localContext, 8);
          localTextView.setPadding(i, j, i, j);
          localTextView.setTextSize(2, 14.0F);
          localTextView.setText(str);
          localTextView.setOnClickListener(new a());
          localTextView.setTag(2131307983, locald);
          this.xLt.addView(localTextView);
        }
      }
      paramView = this.xLx;
      if (paramView != null)
      {
        paramView = paramView.asF("is_special");
        if (com.tencent.mm.plugin.sns.ad.e.b.aA(paramView))
        {
          paramView = paramView.get("is_special");
          if (!(paramView instanceof Boolean)) {}
        }
      }
      for (boolean bool = ((Boolean)paramView).booleanValue();; bool = true)
      {
        if (bool)
        {
          this.xLl.setVisibility(8);
          this.xLk.setVisibility(0);
          paramView = this.xLx;
          if (paramView != null)
          {
            paramView = paramView.asF("special_prompt");
            if (com.tencent.mm.plugin.sns.ad.e.b.aA(paramView))
            {
              paramView = paramView.get("special_prompt");
              if ((paramView instanceof CharSequence)) {
                this.xLk.setText((CharSequence)paramView);
              }
            }
          }
        }
        AppMethodBeat.o(199977);
        return;
      }
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(199978);
    int i = paramView.getId();
    com.tencent.mm.plugin.sns.data.b localb;
    if (i == 2131307997)
    {
      if ((this.xLt != null) && (this.xLt.getChildCount() > 0))
      {
        this.xLt.setVisibility(0);
        if (this.xLs != null) {
          this.xLs.setVisibility(8);
        }
        if (this.awK != null)
        {
          this.awK.setTextColor(a.n(this.awK.getContext(), 2131101219));
          this.awK.setText(2131766818);
        }
        if (this.xLv != null)
        {
          this.xLv.setTextColor(a.n(this.xLv.getContext(), 2131101217));
          this.xLv.setText(this.xLv.getContext().getString(2131766819));
        }
      }
      if (this.xLw != null)
      {
        localb = dFS();
        if (localb != null) {
          paramView.setTag(localb);
        }
        this.xLw.a(paramView, 1, null);
      }
      AppMethodBeat.o(199978);
      return;
    }
    if (i == 2131307986)
    {
      if (this.xLw != null) {
        this.xLw.a(paramView, 2, null);
      }
      AppMethodBeat.o(199978);
      return;
    }
    if (i == 2131307988)
    {
      if (this.xLw != null) {
        this.xLw.a(paramView, 3, null);
      }
      AppMethodBeat.o(199978);
      return;
    }
    if ((i == 2131307990) && (this.xLw != null))
    {
      localb = dFS();
      if (localb != null) {
        paramView.setTag(localb);
      }
      this.xLw.a(paramView, 4, null);
    }
    AppMethodBeat.o(199978);
  }
  
  final class a
    implements View.OnClickListener
  {
    a() {}
    
    public final void onClick(View paramView)
    {
      int i = 0;
      AppMethodBeat.i(199976);
      try
      {
        Object localObject = b.this.xLt;
        if (localObject != null)
        {
          int j = ((ViewGroup)localObject).getChildCount();
          while (i < j)
          {
            ((ViewGroup)localObject).getChildAt(i).setSelected(false);
            i += 1;
          }
        }
        paramView.setSelected(true);
        if (b.this.xLu != null) {
          b.this.xLu.setVisibility(0);
        }
        localObject = b.this.xLw;
        if (localObject != null) {
          ((b.c)localObject).a(paramView, 5, paramView.getTag(2131307983));
        }
        AppMethodBeat.o(199976);
        return;
      }
      catch (Throwable paramView)
      {
        AppMethodBeat.o(199976);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract Map<String, Object> asF(String paramString);
  }
  
  public static abstract interface c
  {
    public abstract void a(View paramView, int paramInt, Object paramObject);
  }
  
  public static final class d
  {
    public final String xLA;
    public final int xLz;
    
    d(int paramInt, String paramString)
    {
      this.xLz = paramInt;
      this.xLA = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.feedback.b
 * JD-Core Version:    0.7.0.1
 */