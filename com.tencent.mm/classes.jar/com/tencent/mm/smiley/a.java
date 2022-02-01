package com.tencent.mm.smiley;

import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/smiley/AbsEmojiNode;", "Lcom/tencent/mm/smiley/IEmojiNode;", "defaultChildrenSize", "", "(I)V", "children", "Landroid/util/SparseArray;", "getChildren", "()Landroid/util/SparseArray;", "data", "Lcom/tencent/mm/smiley/IEmojiItem;", "getData", "()Lcom/tencent/mm/smiley/IEmojiItem;", "setData", "(Lcom/tencent/mm/smiley/IEmojiItem;)V", "createNode", "get", "key", "put", "", "item", "start", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements n
{
  private l acwK;
  public final SparseArray<a> acwL;
  
  public a(int paramInt)
  {
    this.acwL = new SparseArray(paramInt);
  }
  
  public void a(l paraml)
  {
    this.acwK = paraml;
  }
  
  public final void a(l paraml, int paramInt)
  {
    int i = paramInt;
    Object localObject = this;
    s.u(paraml, "item");
    if (i >= 0) {
      if (i <= paraml.aTW().length - 1) {
        paramInt = 1;
      }
    }
    for (;;)
    {
      if (paramInt != 0)
      {
        paramInt = paraml.aTW()[i];
        a locala2 = ((a)localObject).aym(paramInt);
        a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = ((a)localObject).aTX();
          ((a)localObject).acwL.put(paramInt, locala1);
        }
        if (paraml.aTW().length - 1 > i)
        {
          i += 1;
          localObject = locala1;
          break;
          paramInt = 0;
          continue;
          paramInt = 0;
          continue;
        }
        locala1.a(paraml);
      }
    }
  }
  
  public abstract a aTX();
  
  public final a aym(int paramInt)
  {
    return (a)this.acwL.get(paramInt);
  }
  
  public l iUH()
  {
    return this.acwK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.a
 * JD-Core Version:    0.7.0.1
 */