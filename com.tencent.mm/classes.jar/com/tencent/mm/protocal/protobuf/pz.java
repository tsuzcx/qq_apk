package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pz
  extends com.tencent.mm.bx.a
{
  public LinkedList<aku> FLh;
  public LinkedList<akt> FLi;
  public String FLj;
  public String FLk;
  public String FLl;
  
  public pz()
  {
    AppMethodBeat.i(91368);
    this.FLh = new LinkedList();
    this.FLi = new LinkedList();
    AppMethodBeat.o(91368);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FLh);
      paramVarArgs.e(2, 8, this.FLi);
      if (this.FLj != null) {
        paramVarArgs.d(3, this.FLj);
      }
      if (this.FLk != null) {
        paramVarArgs.d(4, this.FLk);
      }
      if (this.FLl != null) {
        paramVarArgs.d(5, this.FLl);
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FLh) + 0 + f.a.a.a.c(2, 8, this.FLi);
      paramInt = i;
      if (this.FLj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FLj);
      }
      i = paramInt;
      if (this.FLk != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FLk);
      }
      paramInt = i;
      if (this.FLl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FLl);
      }
      AppMethodBeat.o(91369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FLh.clear();
      this.FLi.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pz localpz = (pz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91369);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aku();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aku)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpz.FLh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new akt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((akt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpz.FLi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 3: 
        localpz.FLj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91369);
        return 0;
      case 4: 
        localpz.FLk = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91369);
        return 0;
      }
      localpz.FLl = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(91369);
      return 0;
    }
    AppMethodBeat.o(91369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pz
 * JD-Core Version:    0.7.0.1
 */