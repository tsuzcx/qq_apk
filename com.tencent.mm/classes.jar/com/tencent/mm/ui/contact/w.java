package com.tencent.mm.ui.contact;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.ui.base.MaskLayout;

public final class w
  extends LinearLayout
{
  private String Aeu;
  private Context context;
  
  public w(Context paramContext, String paramString)
  {
    super(paramContext);
    AppMethodBeat.i(33813);
    this.context = paramContext;
    this.Aeu = paramString;
    paramContext = View.inflate(getContext(), 2130970394, this);
    paramString = findViewById(2131823728);
    paramContext.setOnClickListener(new w.1(this));
    paramString.setOnTouchListener(new w.2(this));
    paramContext = (MaskLayout)paramString.findViewById(2131821837);
    ((b)g.E(b.class)).b(this.Aeu, "openim_acct_type_icon", b.a.gfE);
    if (this.Aeu.equals("cloudim")) {
      ((ImageView)paramContext.getContentView()).setImageResource(2131230944);
    }
    paramContext = ((b)g.E(b.class)).b(this.Aeu, "openim_acct_type_title", b.a.gfD);
    ((TextView)findViewById(2131823729)).setText(paramContext);
    AppMethodBeat.o(33813);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.contact.w
 * JD-Core Version:    0.7.0.1
 */