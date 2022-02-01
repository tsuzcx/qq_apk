package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pc
  extends com.tencent.mm.bw.a
{
  public int GcK;
  public int GcL;
  public LinkedList<pd> GcM;
  public int type;
  public int uin;
  public int version;
  
  public pc()
  {
    AppMethodBeat.i(124455);
    this.GcM = new LinkedList();
    AppMethodBeat.o(124455);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uin);
      paramVarArgs.aS(2, this.GcK);
      paramVarArgs.aS(3, this.GcL);
      paramVarArgs.e(4, 8, this.GcM);
      paramVarArgs.aS(5, this.version);
      paramVarArgs.aS(6, this.type);
      AppMethodBeat.o(124456);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.uin);
      i = f.a.a.b.b.a.bz(2, this.GcK);
      int j = f.a.a.b.b.a.bz(3, this.GcL);
      int k = f.a.a.a.c(4, 8, this.GcM);
      int m = f.a.a.b.b.a.bz(5, this.version);
      int n = f.a.a.b.b.a.bz(6, this.type);
      AppMethodBeat.o(124456);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GcM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124456);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pc localpc = (pc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124456);
        return -1;
      case 1: 
        localpc.uin = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124456);
        return 0;
      case 2: 
        localpc.GcK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124456);
        return 0;
      case 3: 
        localpc.GcL = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124456);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((pd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpc.GcM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124456);
        return 0;
      case 5: 
        localpc.version = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124456);
        return 0;
      }
      localpc.type = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(124456);
      return 0;
    }
    AppMethodBeat.o(124456);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pc
 * JD-Core Version:    0.7.0.1
 */