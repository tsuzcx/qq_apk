package com.tencent.mm.plugin.teenmode.a;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.z;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public abstract class a
{
  public abstract void a(Context paramContext, a.b paramb, a parama);
  
  public abstract String gV(Context paramContext);
  
  public static final class a
  {
    public long PRp;
    public k.b SYk;
    public String SYl;
    public e SYm;
    public String SYn;
    public String SYo;
    public LinearLayout SYp;
    public ImageView SYq;
    public ImageView SYr;
    public TextView SYs;
    public WeImageView SYt;
    public TextView mll;
    public TextView pmf;
    
    public final boolean hEo()
    {
      AppMethodBeat.i(278946);
      boolean bool = z.bAM().equals(this.SYn);
      AppMethodBeat.o(278946);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.a.a
 * JD-Core Version:    0.7.0.1
 */