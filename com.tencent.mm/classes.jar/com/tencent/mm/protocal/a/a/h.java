package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bx.a
{
  public int CrJ;
  public int Crq;
  public int Crr;
  public o Crs;
  public o Crt;
  public int Cru;
  public int Crv;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143949);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ret);
      paramVarArgs.aR(2, this.Crq);
      paramVarArgs.aR(3, this.Crr);
      if (this.Crs != null)
      {
        paramVarArgs.kX(4, this.Crs.computeSize());
        this.Crs.writeFields(paramVarArgs);
      }
      if (this.Crt != null)
      {
        paramVarArgs.kX(5, this.Crt.computeSize());
        this.Crt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.Cru);
      paramVarArgs.aR(7, this.CrJ);
      paramVarArgs.aR(8, this.Crv);
      AppMethodBeat.o(143949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.ret) + 0 + f.a.a.b.b.a.bA(2, this.Crq) + f.a.a.b.b.a.bA(3, this.Crr);
      paramInt = i;
      if (this.Crs != null) {
        paramInt = i + f.a.a.a.kW(4, this.Crs.computeSize());
      }
      i = paramInt;
      if (this.Crt != null) {
        i = paramInt + f.a.a.a.kW(5, this.Crt.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(6, this.Cru);
      int j = f.a.a.b.b.a.bA(7, this.CrJ);
      int k = f.a.a.b.b.a.bA(8, this.Crv);
      AppMethodBeat.o(143949);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143949);
        return -1;
      case 1: 
        localh.ret = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143949);
        return 0;
      case 2: 
        localh.Crq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143949);
        return 0;
      case 3: 
        localh.Crr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143949);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.Crs = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143949);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localh.Crt = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143949);
        return 0;
      case 6: 
        localh.Cru = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143949);
        return 0;
      case 7: 
        localh.CrJ = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143949);
        return 0;
      }
      localh.Crv = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(143949);
      return 0;
    }
    AppMethodBeat.o(143949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.h
 * JD-Core Version:    0.7.0.1
 */