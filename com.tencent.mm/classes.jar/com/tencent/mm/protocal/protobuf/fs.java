package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class fs
  extends com.tencent.mm.bx.a
{
  public int CAt;
  public int CAu;
  public fx CAv;
  public fr CAw;
  public int OpCode;
  public String hnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32118);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hnC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.OpCode);
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      paramVarArgs.aR(3, this.CAt);
      paramVarArgs.aR(4, this.CAu);
      if (this.CAv != null)
      {
        paramVarArgs.kX(5, this.CAv.computeSize());
        this.CAv.writeFields(paramVarArgs);
      }
      if (this.CAw != null)
      {
        paramVarArgs.kX(6, this.CAw.computeSize());
        this.CAw.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.OpCode) + 0;
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.CAt) + f.a.a.b.b.a.bA(4, this.CAu);
      paramInt = i;
      if (this.CAv != null) {
        paramInt = i + f.a.a.a.kW(5, this.CAv.computeSize());
      }
      i = paramInt;
      if (this.CAw != null) {
        i = paramInt + f.a.a.a.kW(6, this.CAw.computeSize());
      }
      AppMethodBeat.o(32118);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.hnC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      fs localfs = (fs)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32118);
        return -1;
      case 1: 
        localfs.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32118);
        return 0;
      case 2: 
        localfs.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32118);
        return 0;
      case 3: 
        localfs.CAt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32118);
        return 0;
      case 4: 
        localfs.CAu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32118);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localfs.CAv = ((fx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32118);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new fr();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((fr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localfs.CAw = ((fr)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    AppMethodBeat.o(32118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fs
 * JD-Core Version:    0.7.0.1
 */