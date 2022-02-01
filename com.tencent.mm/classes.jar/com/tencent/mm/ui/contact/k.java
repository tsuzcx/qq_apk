package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.o;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;

public final class k
  extends LinearLayout
{
  private Context context;
  private String iNV;
  
  public k(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(37829);
    this.context = paramContext;
    this.iNV = paramString;
    paramContext = View.inflate(getContext(), 2131493993, this);
    paramString = findViewById(2131300138);
    paramContext.setOnClickListener(new k.1(this));
    paramString.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37828);
        if ((k.b(k.this) instanceof MMActivity)) {
          ((MMActivity)k.b(k.this)).hideVKB();
        }
        AppMethodBeat.o(37828);
        return false;
      }
    });
    bg.aVF();
    paramContext = com.tencent.mm.model.c.aSN().bjJ(this.iNV);
    if ((paramContext == null) || ((int)paramContext.gMZ <= 0))
    {
      Log.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", new Object[] { this.iNV });
      AppMethodBeat.o(37829);
      return;
    }
    paramString = (MaskLayout)paramString.findViewById(2131297440);
    a.b.c((ImageView)paramString.getContentView(), this.iNV);
    if (paramContext.field_verifyFlag != 0) {
      if (ay.a.iDs != null)
      {
        String str = ay.a.iDs.rW(paramContext.field_verifyFlag);
        if (str != null) {
          paramString.a(o.Nw(str), MaskLayout.a.OUJ);
        }
      }
    }
    for (;;)
    {
      ((TextView)findViewById(2131300139)).setText(paramContext.arI());
      AppMethodBeat.o(37829);
      return;
      paramString.setMaskBitmap(null);
      continue;
      paramString.setMaskBitmap(null);
      continue;
      paramString.setMaskBitmap(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k
 * JD-Core Version:    0.7.0.1
 */