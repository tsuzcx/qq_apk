package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class kx
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b sGa;
  public com.tencent.mm.bv.b sGb;
  public LinkedList<bpy> sGc = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sGa == null) {
        throw new d.a.a.b("Not all required fields were included: Title");
      }
      if (this.sGb == null) {
        throw new d.a.a.b("Not all required fields were included: ServiceUrl");
      }
      if (this.sGa != null) {
        paramVarArgs.b(1, this.sGa);
      }
      if (this.sGb != null) {
        paramVarArgs.b(2, this.sGb);
      }
      paramVarArgs.d(3, 8, this.sGc);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sGa == null) {
        break label429;
      }
    }
    label429:
    for (paramInt = d.a.a.a.a(1, this.sGa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sGb != null) {
        i = paramInt + d.a.a.a.a(2, this.sGb);
      }
      return i + d.a.a.a.c(3, 8, this.sGc);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sGc.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sGa == null) {
          throw new d.a.a.b("Not all required fields were included: Title");
        }
        if (this.sGb != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: ServiceUrl");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        kx localkx = (kx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localkx.sGa = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 2: 
          localkx.sGb = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpy();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bpy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localkx.sGc.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.kx
 * JD-Core Version:    0.7.0.1
 */