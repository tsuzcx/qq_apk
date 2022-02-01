package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abg
  extends com.tencent.mm.bx.a
{
  public zt FNf;
  public cwq FsR;
  public cvt GaX;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.GaX != null)
      {
        paramVarArgs.lC(2, this.GaX.computeSize());
        this.GaX.writeFields(paramVarArgs);
      }
      if (this.FsR != null)
      {
        paramVarArgs.lC(3, this.FsR.computeSize());
        this.FsR.writeFields(paramVarArgs);
      }
      if (this.FNf != null)
      {
        paramVarArgs.lC(4, this.FNf.computeSize());
        this.FNf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.GaX != null) {
        paramInt = i + f.a.a.a.lB(2, this.GaX.computeSize());
      }
      i = paramInt;
      if (this.FsR != null) {
        i = paramInt + f.a.a.a.lB(3, this.FsR.computeSize());
      }
      paramInt = i;
      if (this.FNf != null) {
        paramInt = i + f.a.a.a.lB(4, this.FNf.computeSize());
      }
      AppMethodBeat.o(91426);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      abg localabg = (abg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91426);
        return -1;
      case 1: 
        localabg.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91426);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cvt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabg.GaX = ((cvt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabg.FsR = ((cwq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new zt();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((zt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localabg.FNf = ((zt)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    AppMethodBeat.o(91426);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abg
 * JD-Core Version:    0.7.0.1
 */