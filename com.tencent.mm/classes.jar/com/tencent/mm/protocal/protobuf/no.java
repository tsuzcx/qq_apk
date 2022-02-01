package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class no
  extends com.tencent.mm.bx.a
{
  public int CLk;
  public int CLl;
  public LinkedList<np> CLm;
  public int type;
  public int uin;
  public int version;
  
  public no()
  {
    AppMethodBeat.i(124455);
    this.CLm = new LinkedList();
    AppMethodBeat.o(124455);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uin);
      paramVarArgs.aR(2, this.CLk);
      paramVarArgs.aR(3, this.CLl);
      paramVarArgs.e(4, 8, this.CLm);
      paramVarArgs.aR(5, this.version);
      paramVarArgs.aR(6, this.type);
      AppMethodBeat.o(124456);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.uin);
      i = f.a.a.b.b.a.bA(2, this.CLk);
      int j = f.a.a.b.b.a.bA(3, this.CLl);
      int k = f.a.a.a.c(4, 8, this.CLm);
      int m = f.a.a.b.b.a.bA(5, this.version);
      int n = f.a.a.b.b.a.bA(6, this.type);
      AppMethodBeat.o(124456);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CLm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124456);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      no localno = (no)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124456);
        return -1;
      case 1: 
        localno.uin = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124456);
        return 0;
      case 2: 
        localno.CLk = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124456);
        return 0;
      case 3: 
        localno.CLl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124456);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new np();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((np)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localno.CLm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124456);
        return 0;
      case 5: 
        localno.version = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124456);
        return 0;
      }
      localno.type = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(124456);
      return 0;
    }
    AppMethodBeat.o(124456);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.no
 * JD-Core Version:    0.7.0.1
 */