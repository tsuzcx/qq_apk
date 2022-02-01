package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ecw
  extends com.tencent.mm.bx.a
{
  public long FAf;
  public long HOL;
  public String HOM;
  public LinkedList<ecx> HON;
  
  public ecw()
  {
    AppMethodBeat.i(32534);
    this.HON = new LinkedList();
    AppMethodBeat.o(32534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32535);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HOM == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.HOL);
      paramVarArgs.aY(2, this.FAf);
      if (this.HOM != null) {
        paramVarArgs.d(3, this.HOM);
      }
      paramVarArgs.e(4, 8, this.HON);
      AppMethodBeat.o(32535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.HOL) + 0 + f.a.a.b.b.a.p(2, this.FAf);
      paramInt = i;
      if (this.HOM != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HOM);
      }
      i = f.a.a.a.c(4, 8, this.HON);
      AppMethodBeat.o(32535);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HON.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.HOM == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32535);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ecw localecw = (ecw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32535);
        return -1;
      case 1: 
        localecw.HOL = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(32535);
        return 0;
      case 2: 
        localecw.FAf = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(32535);
        return 0;
      case 3: 
        localecw.HOM = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32535);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ecx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ecx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localecw.HON.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32535);
      return 0;
    }
    AppMethodBeat.o(32535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecw
 * JD-Core Version:    0.7.0.1
 */