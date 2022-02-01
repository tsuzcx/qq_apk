package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asx
  extends com.tencent.mm.bx.a
{
  public boc GqT;
  public int GqU = -1;
  public int GqV = -1;
  public boolean GqW = false;
  public int GqX = -1;
  public int type = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122490);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.GqT != null)
      {
        paramVarArgs.lC(2, this.GqT.computeSize());
        this.GqT.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GqU);
      paramVarArgs.aS(4, this.GqV);
      paramVarArgs.bt(5, this.GqW);
      paramVarArgs.aS(6, this.GqX);
      AppMethodBeat.o(122490);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.GqT != null) {
        paramInt = i + f.a.a.a.lB(2, this.GqT.computeSize());
      }
      i = f.a.a.b.b.a.bz(3, this.GqU);
      int j = f.a.a.b.b.a.bz(4, this.GqV);
      int k = f.a.a.b.b.a.alV(5);
      int m = f.a.a.b.b.a.bz(6, this.GqX);
      AppMethodBeat.o(122490);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(122490);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      asx localasx = (asx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122490);
        return -1;
      case 1: 
        localasx.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122490);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((boc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasx.GqT = ((boc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122490);
        return 0;
      case 3: 
        localasx.GqU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122490);
        return 0;
      case 4: 
        localasx.GqV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122490);
        return 0;
      case 5: 
        localasx.GqW = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(122490);
        return 0;
      }
      localasx.GqX = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(122490);
      return 0;
    }
    AppMethodBeat.o(122490);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asx
 * JD-Core Version:    0.7.0.1
 */