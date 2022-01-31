package com.tencent.sqlitelint;

import android.content.Context;
import com.tencent.sqlitelint.util.SQLite3ProfileHooker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class f
  implements b
{
  final Context mContext;
  final String wQW;
  final c wQX;
  private final List<com.tencent.sqlitelint.behaviour.a> wRe;
  
  f(Context paramContext, e.a parama, e.b paramb)
  {
    this.mContext = paramContext;
    com.tencent.sqlitelint.behaviour.a.c.wRD.initialize(paramContext);
    this.wQW = parama.wQW;
    this.wQX = parama.wQX;
    if (e.cPQ() == e.c.wRb) {
      SQLite3ProfileHooker.cPU();
    }
    SQLiteLintNativeBridge.nativeInstall(this.wQW);
    this.wRe = new ArrayList();
    this.wRe.add(new com.tencent.sqlitelint.behaviour.a.b());
    if ((paramb.wQZ & 0x1) > 0)
    {
      i = 1;
      if (i != 0) {
        this.wRe.add(new com.tencent.sqlitelint.behaviour.alert.a(paramContext, this.wQW));
      }
      if ((paramb.wQZ & 0x2) <= 0) {
        break label166;
      }
    }
    label166:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        this.wRe.add(new com.tencent.sqlitelint.behaviour.b.a(e.wQV));
      }
      return;
      i = 0;
      break;
    }
  }
  
  public final void ey(List<SQLiteLintIssue> paramList)
  {
    int j = 0;
    Iterator localIterator = paramList.iterator();
    int i;
    for (;;)
    {
      i = j;
      if (!localIterator.hasNext()) {
        break;
      }
      SQLiteLintIssue localSQLiteLintIssue = (SQLiteLintIssue)localIterator.next();
      if (com.tencent.sqlitelint.behaviour.a.a.afY(localSQLiteLintIssue.id)) {
        localSQLiteLintIssue.isNew = false;
      } else {
        localSQLiteLintIssue.isNew = true;
      }
    }
    while (i < this.wRe.size())
    {
      ((com.tencent.sqlitelint.behaviour.a)this.wRe.get(i)).ey(paramList);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.f
 * JD-Core Version:    0.7.0.1
 */