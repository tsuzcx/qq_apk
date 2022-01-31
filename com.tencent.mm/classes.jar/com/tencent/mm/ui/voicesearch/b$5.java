package com.tencent.mm.ui.voicesearch;

import java.util.ArrayList;
import java.util.List;

final class b$5
  implements Runnable
{
  b$5(b paramb, List paramList) {}
  
  public final void run()
  {
    if (b.a(this.wiQ) == null) {
      b.a(this.wiQ, new ArrayList());
    }
    b.a(this.wiQ).clear();
    b.a(this.wiQ).addAll(this.gFL);
    b.a(this.wiQ).add("officialaccounts");
    b.a(this.wiQ).add("helper_entry");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.voicesearch.b.5
 * JD-Core Version:    0.7.0.1
 */