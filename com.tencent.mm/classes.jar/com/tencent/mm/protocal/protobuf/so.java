package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class so
  extends com.tencent.mm.bx.a
{
  public LinkedList<rt> FNZ;
  public dwb FPc;
  public int FPd;
  public int FPe;
  public String xNN;
  
  public so()
  {
    AppMethodBeat.i(219343);
    this.FNZ = new LinkedList();
    AppMethodBeat.o(219343);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(219344);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FPc == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(219344);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.FNZ);
      if (this.FPc != null)
      {
        paramVarArgs.lC(2, this.FPc.computeSize());
        this.FPc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.FPd);
      paramVarArgs.aS(4, this.FPe);
      if (this.xNN != null) {
        paramVarArgs.d(5, this.xNN);
      }
      AppMethodBeat.o(219344);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FNZ) + 0;
      paramInt = i;
      if (this.FPc != null) {
        paramInt = i + f.a.a.a.lB(2, this.FPc.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FPd) + f.a.a.b.b.a.bz(4, this.FPe);
      paramInt = i;
      if (this.xNN != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.xNN);
      }
      AppMethodBeat.o(219344);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FNZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.FPc == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(219344);
        throw paramVarArgs;
      }
      AppMethodBeat.o(219344);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      so localso = (so)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(219344);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localso.FNZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(219344);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localso.FPc = ((dwb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(219344);
        return 0;
      case 3: 
        localso.FPd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(219344);
        return 0;
      case 4: 
        localso.FPe = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(219344);
        return 0;
      }
      localso.xNN = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(219344);
      return 0;
    }
    AppMethodBeat.o(219344);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.so
 * JD-Core Version:    0.7.0.1
 */