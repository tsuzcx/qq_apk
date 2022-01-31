package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wear.model.f.d;
import java.util.LinkedList;
import java.util.List;

final class b$a
  extends d
{
  private b$a(b paramb) {}
  
  public final void execute()
  {
    au.Dk().a(30, this.qRH);
    Object localObject = new LinkedList();
    ((LinkedList)localObject).add("gh_43f2581f6fd6");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(1));
    localObject = new com.tencent.mm.pluginsdk.model.m(1, (List)localObject, localLinkedList, "", "");
    au.Dk().a((com.tencent.mm.ah.m)localObject, 0);
  }
  
  public final String getName()
  {
    return "AddContactTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.b.a
 * JD-Core Version:    0.7.0.1
 */