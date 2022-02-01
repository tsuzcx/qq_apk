package com.tencent.mm.ui.component.glocom;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16})
public final class b$a
{
  public static void a(b paramb, MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(205921);
    p.k(paramMMFragmentActivity, "activity");
    Object localObject = g.Xox;
    paramMMFragmentActivity = (a)g.b((AppCompatActivity)paramMMFragmentActivity).i(a.class);
    p.k(paramb, "gloCom");
    if (paramMMFragmentActivity.XoQ.containsKey(paramb.getTag()))
    {
      paramMMFragmentActivity = (LinkedList)paramMMFragmentActivity.XoQ.get(paramb.getTag());
      if (paramMMFragmentActivity != null)
      {
        paramMMFragmentActivity.add(paramb);
        AppMethodBeat.o(205921);
        return;
      }
      AppMethodBeat.o(205921);
      return;
    }
    paramMMFragmentActivity = (Map)paramMMFragmentActivity.XoQ;
    localObject = paramb.getTag();
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramb);
    paramMMFragmentActivity.put(localObject, localLinkedList);
    AppMethodBeat.o(205921);
  }
  
  public static void b(b paramb, MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(205923);
    p.k(paramMMFragmentActivity, "activity");
    Object localObject = g.Xox;
    paramMMFragmentActivity = (a)g.b((AppCompatActivity)paramMMFragmentActivity).i(a.class);
    p.k(paramb, "gloCom");
    localObject = (LinkedList)paramMMFragmentActivity.XoQ.get(paramb.getTag());
    if (localObject != null)
    {
      ((LinkedList)localObject).remove(paramb);
      if (((LinkedList)localObject).isEmpty()) {
        paramMMFragmentActivity.XoQ.remove(paramb.getTag());
      }
      AppMethodBeat.o(205923);
      return;
    }
    AppMethodBeat.o(205923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.glocom.b.a
 * JD-Core Version:    0.7.0.1
 */