package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sq
  extends com.tencent.mm.bx.a
{
  public LinkedList<abo> FPf;
  public int FPg;
  public String FPh;
  public String FpV;
  public String name;
  
  public sq()
  {
    AppMethodBeat.i(32155);
    this.FPf = new LinkedList();
    AppMethodBeat.o(32155);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FPf);
      if (this.FpV != null) {
        paramVarArgs.d(2, this.FpV);
      }
      paramVarArgs.aS(3, this.FPg);
      if (this.FPh != null) {
        paramVarArgs.d(4, this.FPh);
      }
      if (this.name != null) {
        paramVarArgs.d(5, this.name);
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FPf) + 0;
      paramInt = i;
      if (this.FpV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FpV);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FPg);
      paramInt = i;
      if (this.FPh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FPh);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.name);
      }
      AppMethodBeat.o(32156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FPf.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      sq localsq = (sq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32156);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((abo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localsq.FPf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32156);
        return 0;
      case 2: 
        localsq.FpV = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32156);
        return 0;
      case 3: 
        localsq.FPg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32156);
        return 0;
      case 4: 
        localsq.FPh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32156);
        return 0;
      }
      localsq.name = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(32156);
      return 0;
    }
    AppMethodBeat.o(32156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sq
 * JD-Core Version:    0.7.0.1
 */