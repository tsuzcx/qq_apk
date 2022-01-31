package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

public class TbsMediaFactory
{
  private Context a = null;
  private bi b = null;
  private DexLoader c = null;
  
  public TbsMediaFactory(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    a();
  }
  
  private void a()
  {
    if (this.a == null) {}
    do
    {
      return;
      if (this.b == null)
      {
        o.a(true).a(this.a, false, false, null);
        this.b = o.a(true).a();
        if (this.b != null) {
          this.c = this.b.b();
        }
      }
    } while ((this.b != null) && (this.c != null));
    throw new RuntimeException("tbs core dex(s) load failure !!!");
  }
  
  public TbsMediaPlayer createPlayer()
  {
    if ((this.b == null) || (this.c == null)) {
      throw new RuntimeException("tbs core dex(s) did not loaded !!!");
    }
    return new TbsMediaPlayer(new ba(this.c, this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsMediaFactory
 * JD-Core Version:    0.7.0.1
 */