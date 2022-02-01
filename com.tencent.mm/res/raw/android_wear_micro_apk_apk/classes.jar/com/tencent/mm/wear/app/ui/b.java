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
  private ae ahZ;
  private com.tencent.mm.wear.app.f.b ahk;
  private c aia;
  private Context context;
  
  public b(Context paramContext)
  {
    this.context = paramContext;
    this.ahZ = new ae();
    this.ahZ.XV = true;
    this.ahZ.Yl = 0;
    paramContext = this.ahZ.Ym;
    com.tencent.mm.e.a.c localc = new com.tencent.mm.e.a.c();
    localc.Xj = "supers_offline_pay";
    localc.Xk = this.context.getString(2131165224);
    paramContext.add(localc);
  }
  
  public final void a(c paramc)
  {
    this.aia = paramc;
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
        localIterator = this.ahZ.Ym.iterator();
        while (localIterator.hasNext())
        {
          paramArrayOfByte.add(((com.tencent.mm.e.a.c)localIterator.next()).Xj);
          continue;
          return;
        }
      }
      catch (IOException paramArrayOfByte)
      {
        com.tencent.mm.wear.a.c.d.a("MicroMsg.ConversationListAdapter", paramArrayOfByte);
      }
    }
    Iterator localIterator = localae.Ym.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.a.c localc = (com.tencent.mm.e.a.c)localIterator.next();
      if (paramArrayOfByte.add(localc.Xj)) {
        this.ahZ.Ym.add(localc);
      }
    }
    this.ahZ.Yl = localae.Yl;
    this.ahZ.XV = localae.XV;
    com.tencent.mm.wear.a.b.a.amv.post(new Runnable()
    {
      public final void run()
      {
        b.this.notifyDataSetChanged();
        if (b.a(b.this) != null)
        {
          c localc = b.a(b.this);
          b.this.getCount();
          localc.nJ();
        }
      }
    });
  }
  
  public final com.tencent.mm.e.a.c cp(int paramInt)
  {
    return (com.tencent.mm.e.a.c)this.ahZ.Ym.get(paramInt);
  }
  
  public final int getCount()
  {
    return this.ahZ.Ym.size();
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
        ((d)localObject).aic = ((ImageView)paramView.findViewById(2131558443));
        ((d)localObject).aid = ((TextView)paramView.findViewById(2131558444));
        paramView.setTag(localObject);
        paramViewGroup = paramView;
      }
    }
    for (paramView = (View)localObject;; paramView = (View)localObject)
    {
      localObject = cp(paramInt);
      paramView.aid.setText(((com.tencent.mm.e.a.c)localObject).Xk);
      if (!((com.tencent.mm.e.a.c)localObject).Xj.equalsIgnoreCase("supers_offline_pay")) {
        break label172;
      }
      localObject = com.tencent.mm.wear.a.f.b.a(BitmapFactory.decodeResource(this.context.getResources(), 2130837591), 6.0F);
      paramView.aic.setImageBitmap((Bitmap)localObject);
      return paramViewGroup;
      paramView = LayoutInflater.from(this.context).inflate(2130903044, paramViewGroup, false);
      break;
      localObject = (d)paramView.getTag();
      paramViewGroup = paramView;
    }
    label172:
    com.tencent.mm.wear.app.c.a locala = new com.tencent.mm.wear.app.c.a();
    locala.agm = paramView.aic;
    locala.agn = 2130837531;
    locala.width = 96;
    locala.height = 96;
    locala.type = 3;
    locala.agi = ((com.tencent.mm.e.a.c)localObject).Xj;
    locala.agp = 10;
    h.mR().a(locala);
    return paramViewGroup;
  }
  
  public final boolean nI()
  {
    if (!this.ahZ.XV) {
      return false;
    }
    ad localad = new ad();
    localad.Yl = this.ahZ.Yl;
    if (this.ahk != null)
    {
      this.ahk.cancel();
      this.ahk = null;
    }
    try
    {
      this.ahk = new com.tencent.mm.wear.app.f.b(11008, localad.toByteArray());
      this.ahk.a(this);
      this.ahk.I(true);
      h.mP().a(this.ahk);
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