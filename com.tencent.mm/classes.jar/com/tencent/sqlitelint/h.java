package com.tencent.sqlitelint;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.b.b;
import com.tencent.matrix.b.c;
import com.tencent.sqlitelint.a.a;
import java.util.List;

public class h
  extends b
{
  public Context mContext;
  public final a wRi;
  
  public h(a parama)
  {
    this.wRi = parama;
  }
  
  public final void a(Application paramApplication, c paramc)
  {
    super.a(paramApplication, paramc);
    e.ag(paramApplication);
    this.mContext = paramApplication.getApplicationContext();
  }
  
  public final String getTag()
  {
    return "SQLiteLint";
  }
  
  public final void start()
  {
    super.start();
    if (!this.boE) {}
    for (;;)
    {
      return;
      e.a(new com.tencent.sqlitelint.behaviour.b.a.a()
      {
        public final void a(SQLiteLintIssue paramAnonymousSQLiteLintIssue)
        {
          if (paramAnonymousSQLiteLintIssue == null) {
            return;
          }
          h.a(h.this, paramAnonymousSQLiteLintIssue);
        }
      });
      List localList = this.wRi.wRH;
      int i = 0;
      while (i < localList.size())
      {
        com.tencent.sqlitelint.a.a.a locala = (com.tencent.sqlitelint.a.a.a)localList.get(i);
        String str = locala.wRI.wQW;
        e.a(this.mContext, locala.wRI, locala.wRJ);
        e.dW(str, locala.wRK);
        e.z(str, locala.wRL);
        i += 1;
      }
    }
  }
  
  public final void stop()
  {
    super.stop();
    if (!this.boE) {
      return;
    }
    List localList = this.wRi.wRH;
    int i = 0;
    while (i < localList.size())
    {
      e.afW(((com.tencent.sqlitelint.a.a.a)localList.get(i)).wRI.wQW);
      i += 1;
    }
    e.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.h
 * JD-Core Version:    0.7.0.1
 */