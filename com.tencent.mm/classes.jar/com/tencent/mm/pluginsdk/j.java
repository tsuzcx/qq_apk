package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a.b;
import com.tencent.mm.ui.y;

public abstract interface j
  extends a
{
  public abstract void G(String paramString, byte[] paramArrayOfByte);
  
  public abstract v a(y paramy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama);
  
  public abstract e a(Context paramContext, String paramString1, Bitmap paramBitmap, String paramString2, int paramInt, y.a parama);
  
  public abstract e a(Context paramContext, String paramString1, View paramView, String paramString2, y.a parama);
  
  public abstract e a(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, y.a parama, e.a.b paramb, DialogInterface.OnDismissListener paramOnDismissListener);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, y.a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama);
  
  public abstract void a(y paramy, String paramString1, String paramString2, String paramString3, y.a parama);
  
  public abstract e b(y paramy, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama);
  
  public abstract void b(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, y.a parama);
  
  public abstract void c(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama);
  
  public abstract void d(Context paramContext, String paramString1, String paramString2, String paramString3, y.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j
 * JD-Core Version:    0.7.0.1
 */