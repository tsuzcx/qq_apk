package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ui.widget.a.c;

public final class RadarMemberView$j
  implements TextWatcher
{
  public final void afterTextChanged(Editable paramEditable)
  {
    boolean bool = false;
    g.k(paramEditable, "s");
    int j = 50 - paramEditable.length();
    int i = j;
    if (j < 0) {
      i = 0;
    }
    Object localObject = RadarMemberView.f(this.nmh);
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)String.valueOf(i));
    }
    localObject = RadarMemberView.g(this.nmh);
    if (localObject != null)
    {
      localObject = ((c)localObject).getButton(-1);
      if (localObject != null)
      {
        if (paramEditable.length() > 0) {
          bool = true;
        }
        ((Button)localObject).setEnabled(bool);
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    g.k(paramCharSequence, "s");
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    g.k(paramCharSequence, "s");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarMemberView.j
 * JD-Core Version:    0.7.0.1
 */