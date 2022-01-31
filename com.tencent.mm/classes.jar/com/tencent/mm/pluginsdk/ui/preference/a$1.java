package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    paramView = View.inflate(a.a(this.sie), R.i.sendrequest_dialog, null);
    ((TextView)paramView.findViewById(R.h.sendrequest_tip)).setVisibility(8);
    TextView localTextView = (TextView)paramView.findViewById(R.h.wordcount);
    localTextView.setVisibility(0);
    localTextView.setText("50");
    EditText localEditText = (EditText)paramView.findViewById(R.h.sendrequest_content);
    localEditText.setSingleLine(false);
    c.d(localEditText).Ig(100).a(null);
    localEditText.addTextChangedListener(new a.1.1(this, localTextView));
    h.a(a.a(this.sie), a.a(this.sie).getString(R.l.app_reply), paramView, new a.1.2(this, localEditText), null);
    localEditText.post(new Runnable()
    {
      public final void run()
      {
        if ((a.a(a.1.this.sie) instanceof MMActivity)) {
          ((MMActivity)a.a(a.1.this.sie)).showVKB();
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.a.1
 * JD-Core Version:    0.7.0.1
 */