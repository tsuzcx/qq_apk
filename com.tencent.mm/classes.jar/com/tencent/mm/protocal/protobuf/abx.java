package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abx
  extends com.tencent.mm.bx.a
{
  public int Dcu;
  public aby Dcv;
  public int Dcw;
  public aby Dcx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43094);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dcv == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.Dcx == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Dcu);
      if (this.Dcv != null)
      {
        paramVarArgs.kX(2, this.Dcv.computeSize());
        this.Dcv.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Dcw);
      if (this.Dcx != null)
      {
        paramVarArgs.kX(4, this.Dcx.computeSize());
        this.Dcx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Dcu) + 0;
      paramInt = i;
      if (this.Dcv != null) {
        paramInt = i + f.a.a.a.kW(2, this.Dcv.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.Dcw);
      paramInt = i;
      if (this.Dcx != null) {
        paramInt = i + f.a.a.a.kW(4, this.Dcx.computeSize());
      }
      AppMethodBeat.o(43094);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Dcv == null)
      {
        paramVarArgs = new b("Not all required fields were included: NightTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      if (this.Dcx == null)
      {
        paramVarArgs = new b("Not all required fields were included: AllDayTime");
        AppMethodBeat.o(43094);
        throw paramVarArgs;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      abx localabx = (abx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43094);
        return -1;
      case 1: 
        localabx.Dcu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43094);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aby();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aby)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabx.Dcv = ((aby)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43094);
        return 0;
      case 3: 
        localabx.Dcw = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(43094);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aby();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aby)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localabx.Dcx = ((aby)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43094);
      return 0;
    }
    AppMethodBeat.o(43094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abx
 * JD-Core Version:    0.7.0.1
 */