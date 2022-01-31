package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.view.View;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.b.c;

public abstract interface i
  extends a
{
  public abstract o a(q paramq, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama);
  
  public abstract c a(Context paramContext, String paramString1, View paramView, String paramString2, q.a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, q.a parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama);
  
  public abstract void a(q paramq, String paramString1, String paramString2, String paramString3, q.a parama);
  
  public abstract c b(q paramq, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, q.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i
 * JD-Core Version:    0.7.0.1
 */