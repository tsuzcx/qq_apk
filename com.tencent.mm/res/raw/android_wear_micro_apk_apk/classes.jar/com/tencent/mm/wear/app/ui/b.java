package com.tencent.mm.wear.app.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.wear.app.b.h;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  extends BaseAdapter
  implements com.tencent.mm.wear.app.f.d
{
  private com.tencent.mm.wear.app.f.b adI;
  private ae aex;
  private c aey;
  private Context context;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
    this.aex = new ae();
    this.aex.Wa = true;
    this.aex.Wq = 0;
    paramContext = this.aex.Wr;
    com.tencent.mm.e.a.c localc = new com.tencent.mm.e.a.c();
    localc.Vo = "supers_offline_pay";
    localc.Vp = this.context.getString(2131165224);
    paramContext.add(localc);
  }
  
  public final void a(c paramc)
  {
    this.aey = paramc;
  }
  
  public final void b(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ae localae;
    if (paramInt2 == 0)
    {
      localae = new ae();
      try
      {
        localae.h(paramArrayOfByte);
        paramArrayOfByte = new HashSet();
        localIterator = this.aex.Wr.iterator();
        while (localIterator.hasNext())
        {
          paramArrayOfByte.add(((com.tencent.mm.e.a.c)localIterator.next()).Vo);
          continue;
          return;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.ConversationListAdapter", paramArrayOfByte);
      }
    }
    Iterator localIterator = localae.Wr.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.a.c localc = (com.tencent.mm.e.a.c)localIterator.next();
      if (paramArrayOfByte.add(localc.Vo)) {
        this.aex.Wr.add(localc);
      }
    }
    this.aex.Wq = localae.Wq;
    this.aex.Wa = localae.Wa;
    com.tencent.mm.wear.a.b.a.aiT.post(new Runnable()
    {
      public final void run()
      {
        b.this.notifyDataSetChanged();
        if (b.a(b.this) != null)
        {
          c localc = b.a(b.this);
          b.this.getCount();
          localc.mX();
        }
      }
    });
  }
  
  public final com.tencent.mm.e.a.c bT(int paramInt)
  {
    return (com.tencent.mm.e.a.c)this.aex.Wr.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.aex.Wr.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null) {
      if (MMActivity.isRect())
      {
        paramView = LayoutInflater.from(this.context).inflate(2130903043, paramViewGroup, false);
        localObject = new d(this, (byte)0);
        ((d)localObject).aeA = ((ImageView)paramView.findViewById(2131558442));
        ((d)localObject).aeB = ((TextView)paramView.findViewById(2131558443));
        paramView.setTag(localObject);
        paramViewGroup = paramView;
      }
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      localObject = bT(paramInt);
      paramView.aeB.setText(((com.tencent.mm.e.a.c)localObject).Vp);
      if (!((com.tencent.mm.e.a.c)localObject).Vo.equalsIgnoreCase("supers_offline_pay")) {
        break label172;
      }
      localObject = com.tencent.mm.wear.a.f.b.a(BitmapFactory.decodeResource(this.context.getResources(), 2130837591), 6.0F);
      paramView.aeA.setImageBitmap((Bitmap)localObject);
      return paramViewGroup;
      paramView = LayoutInflater.from(this.context).inflate(2130903044, paramViewGroup, false);
      break;
      localObject = (d)paramView.getTag();
      paramViewGroup = paramView;
    }
    label172:
    com.tencent.mm.wear.app.c.a locala = new com.tencent.mm.wear.app.c.a();
    locala.acL = paramView.aeA;
    locala.acM = 2130837531;
    locala.width = 96;
    locala.height = 96;
    locala.type = 3;
    locala.acH = ((com.tencent.mm.e.a.c)localObject).Vo;
    locala.acO = 10;
    h.me().a(locala);
    return paramViewGroup;
  }
  
  public final boolean mW()
  {
    if (!this.aex.Wa) {
      return false;
    }
    ad localad = new ad();
    localad.Wq = this.aex.Wq;
    if (this.adI != null)
    {
      this.adI.cancel();
      this.adI = null;
    }
    try
    {
      this.adI = new com.tencent.mm.wear.app.f.b(11008, localad.toByteArray());
      this.adI.a(this);
      this.adI.F(true);
      h.mc().a(this.adI);
      return true;
    }
    catch (IOException localIOException)
    {
      com.tencent.mm.wear.a.c.d.a("MicroMsg.ConversationListAdapter", localIOException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.b
 * JD-Core Version:    0.7.0.1
 */