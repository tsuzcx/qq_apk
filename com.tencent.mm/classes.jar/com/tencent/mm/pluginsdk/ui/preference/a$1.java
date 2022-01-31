package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.b.c;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28028);
    paramView = View.inflate(a.a(this.waD), 2130970676, null);
    ((TextView)paramView.findViewById(2131827574)).setVisibility(8);
    TextView localTextView = (TextView)paramView.findViewById(2131823234);
    localTextView.setVisibility(0);
    localTextView.setText("50");
    EditText localEditText = (EditText)paramView.findViewById(2131827575);
    localEditText.setSingleLine(false);
    c.d(localEditText).QS(100).a(null);
    localEditText.addTextChangedListener(new a.1.1(this, localTextView));
    h.a(a.a(this.waD), a.a(this.waD).getString(2131297058), paramView, new a.1.2(this, localEditText), null);
    localEditText.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(28027);
        if ((a.a(a.1.this.waD) instanceof MMActivity)) {
          ((MMActivity)a.a(a.1.this.waD)).showVKB();
        }
        AppMethodBeat.o(28027);
      }
    });
    AppMethodBeat.o(28028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a.1
 * JD-Core Version:    0.7.0.1
 */