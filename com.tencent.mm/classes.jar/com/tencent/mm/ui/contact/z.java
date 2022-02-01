package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class z
  extends LinearLayout
{
  private String PYe;
  private Context context;
  
  public z(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(37933);
    this.context = paramContext;
    this.PYe = paramString;
    paramContext = View.inflate(getContext(), 2131495892, this);
    paramString = findViewById(2131300138);
    paramContext.setOnClickListener(new z.1(this));
    paramString.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37932);
        if ((z.b(z.this) instanceof MMActivity)) {
          ((MMActivity)z.b(z.this)).hideVKB();
        }
        AppMethodBeat.o(37932);
        return false;
      }
    });
    paramContext = (MaskLayout)paramString.findViewById(2131297440);
    ((a)g.af(a.class)).b(this.PYe, "openim_acct_type_icon", a.a.jGT);
    if (this.PYe.equals("cloudim")) {
      ((ImageView)paramContext.getContentView()).setImageResource(2131689732);
    }
    paramContext = ((a)g.af(a.class)).b(this.PYe, "openim_acct_type_title", a.a.jGS);
    ((TextView)findViewById(2131300139)).setText(paramContext);
    AppMethodBeat.o(37933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.z
 * JD-Core Version:    0.7.0.1
 */