package com.tencent.mm.ui.chatting.j.a;

import android.text.Spannable;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMTextView.a;

public class a
{
  private static volatile a vzs = null;
  private static final ai vzt = new ai();
  
  public static void a(CharSequence paramCharSequence, bi parambi)
  {
    a(paramCharSequence, parambi, 1);
  }
  
  private static void a(CharSequence paramCharSequence, bi parambi, int paramInt)
  {
    if ((paramCharSequence instanceof Spannable)) {
      vzt.O(new a.b(paramCharSequence, parambi, paramInt));
    }
  }
  
  public static a cGT()
  {
    if (vzs == null) {
      try
      {
        if (vzs == null) {
          vzs = new a();
        }
        a locala = vzs;
        return locala;
      }
      finally {}
    }
    return vzs;
  }
  
  public static MMTextView.a cGU()
  {
    return a.a.vzu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.a.a
 * JD-Core Version:    0.7.0.1
 */