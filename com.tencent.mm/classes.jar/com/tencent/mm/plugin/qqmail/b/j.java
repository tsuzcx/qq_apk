package com.tencent.mm.plugin.qqmail.b;

import d.a.a.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bv.a
{
  public String content;
  public int ndr;
  public String nds;
  public LinkedList<o> ndt = new LinkedList();
  public LinkedList<o> ndu = new LinkedList();
  public LinkedList<o> ndv = new LinkedList();
  public LinkedList<ai> ndw = new LinkedList();
  public String ndx;
  public int ndy = 5;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.content == null) {
        throw new b("Not all required fields were included: content");
      }
      paramVarArgs.gB(1, this.ndr);
      if (this.nds != null) {
        paramVarArgs.d(2, this.nds);
      }
      paramVarArgs.d(3, 8, this.ndt);
      paramVarArgs.d(4, 8, this.ndu);
      paramVarArgs.d(5, 8, this.ndv);
      paramVarArgs.d(6, 8, this.ndw);
      if (this.ndx != null) {
        paramVarArgs.d(7, this.ndx);
      }
      if (this.content != null) {
        paramVarArgs.d(8, this.content);
      }
      paramVarArgs.gB(9, this.ndy);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.ndr) + 0;
      paramInt = i;
      if (this.nds != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.nds);
      }
      i = paramInt + d.a.a.a.c(3, 8, this.ndt) + d.a.a.a.c(4, 8, this.ndu) + d.a.a.a.c(5, 8, this.ndv) + d.a.a.a.c(6, 8, this.ndw);
      paramInt = i;
      if (this.ndx != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.ndx);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.content);
      }
      return i + d.a.a.a.gy(9, this.ndy);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ndt.clear();
      this.ndu.clear();
      this.ndv.clear();
      this.ndw.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.content == null) {
        throw new b("Not all required fields were included: content");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localj.ndr = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localj.nds = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localj.ndt.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localj.ndu.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localj.ndv.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ai();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ai)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localj.ndw.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        localj.ndx = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 8: 
        localj.content = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localj.ndy = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.j
 * JD-Core Version:    0.7.0.1
 */