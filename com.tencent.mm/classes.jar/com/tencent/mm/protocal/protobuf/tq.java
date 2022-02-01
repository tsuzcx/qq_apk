package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tq
  extends com.tencent.mm.bx.a
{
  public LinkedList<tr> CVr;
  public int CVs;
  public cmf CVt;
  public int fpb;
  
  public tq()
  {
    AppMethodBeat.i(43085);
    this.CVr = new LinkedList();
    AppMethodBeat.o(43085);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43086);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fpb);
      paramVarArgs.e(2, 8, this.CVr);
      paramVarArgs.aR(3, this.CVs);
      if (this.CVt != null)
      {
        paramVarArgs.kX(4, this.CVt.computeSize());
        this.CVt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.fpb) + 0 + f.a.a.a.c(2, 8, this.CVr) + f.a.a.b.b.a.bA(3, this.CVs);
      paramInt = i;
      if (this.CVt != null) {
        paramInt = i + f.a.a.a.kW(4, this.CVt.computeSize());
      }
      AppMethodBeat.o(43086);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CVr.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      tq localtq = (tq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43086);
        return -1;
      case 1: 
        localtq.fpb = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43086);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localtq.CVr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43086);
        return 0;
      case 3: 
        localtq.CVs = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43086);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cmf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localtq.CVt = ((cmf)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    AppMethodBeat.o(43086);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tq
 * JD-Core Version:    0.7.0.1
 */