package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.a.a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class n
  extends ClickableSpan
  implements a
{
  private int dIk;
  private String fKV;
  private WeakReference<View> fy = null;
  boolean mEnable = true;
  public boolean mmZ = false;
  private Context sjZ = null;
  private int ske;
  private h skf = null;
  private m skg = null;
  
  public n() {}
  
  public n(int paramInt, m paramm)
  {
    int j;
    int i;
    if (paramm != null)
    {
      j = paramm.linkColor;
      i = paramm.backgroundColor;
    }
    for (;;)
    {
      if ((j == 0) && (i == 0)) {
        AX(paramInt);
      }
      for (;;)
      {
        this.skf = new h();
        this.skg = paramm;
        return;
        eY(j, i);
      }
      i = 0;
      j = 0;
    }
  }
  
  public void AX(int paramInt)
  {
    Context localContext = ae.getContext();
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      eY(localContext.getResources().getColor(a.b.chat_url_color), -5908174);
      return;
    case 2: 
      eY(localContext.getResources().getColor(a.b.link_color), localContext.getResources().getColor(a.b.sns_link_bg_color));
      return;
    }
    eY(localContext.getResources().getColor(a.b.sns_lucky_item_gold), localContext.getResources().getColor(a.b.sns_link_bg_color));
  }
  
  public final void eY(int paramInt1, int paramInt2)
  {
    this.ske = paramInt1;
    this.dIk = paramInt2;
  }
  
  public final int getType()
  {
    if (this.skg == null) {
      return 2147483647;
    }
    return this.skg.type;
  }
  
  public final void mf(boolean paramBoolean)
  {
    this.mmZ = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    h localh;
    m localm;
    if ((this.skf != null) && (this.skg != null) && (this.mEnable))
    {
      localObject2 = this.skf;
      if (this.sjZ == null) {
        break label92;
      }
      localObject1 = this.sjZ;
      ((h)localObject2).mContext = ((Context)localObject1);
      localh = this.skf;
      localm = this.skg;
      if (System.currentTimeMillis() - localh.qrB > localh.qrA) {
        break label100;
      }
      y.e("MicroMsg.MMSpanClickListener", "process pass");
    }
    for (;;)
    {
      this.skf.mContext = null;
      return;
      label92:
      localObject1 = paramView.getContext();
      break;
      label100:
      localh.qrB = System.currentTimeMillis();
      if (localm == null)
      {
        y.e("MicroMsg.MMSpanClickListener", "onClick error, hrefInfo is null!");
      }
      else
      {
        y.d("MicroMsg.MMSpanClickListener", "MMSpanClickListener.onClick, hrefInfo type = %d", new Object[] { Integer.valueOf(localm.type) });
        if (localh.mContext != null) {
          break label163;
        }
        y.e("MicroMsg.MMSpanClickListener", "onClick error, context is null!");
      }
    }
    label163:
    if ((j.sjH != null) && (j.sjH.size() > 0))
    {
      int i = j.sjH.size();
      localObject1 = (g)j.sjH.getLast();
      y.d("MicroMsg.MMSpanClickListener", "spanCallbackList.size:%d, get the last callback", new Object[] { Integer.valueOf(i) });
    }
    for (;;)
    {
      bi localbi;
      if ((paramView != null) && ((paramView.getTag() instanceof c)))
      {
        localbi = ((c)paramView.getTag()).bWO;
        if (localbi != null)
        {
          localObject2 = localbi.field_talker;
          paramView = (View)localObject2;
          if (!s.gZ((String)localObject2)) {}
        }
      }
      for (paramView = bd.iI(localbi.field_content);; paramView = null)
      {
        localm.username = paramView;
        if (!TextUtils.isEmpty(localh.fKV)) {
          localm.fKV = localh.fKV;
        }
        b.a.sjn.a(localh.mContext, localm, (g)localObject1);
        localm.fKV = null;
        break;
      }
      localObject1 = null;
    }
  }
  
  public final void setContext(Context paramContext)
  {
    this.sjZ = paramContext;
    this.skf.mContext = paramContext;
  }
  
  public final void setSessionId(String paramString)
  {
    this.fKV = paramString;
    if (this.skf != null) {
      this.skf.fKV = this.fKV;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.ske);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.linkColor = this.ske;
    if (this.mmZ)
    {
      paramTextPaint.bgColor = this.dIk;
      return;
    }
    paramTextPaint.bgColor = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.n
 * JD-Core Version:    0.7.0.1
 */