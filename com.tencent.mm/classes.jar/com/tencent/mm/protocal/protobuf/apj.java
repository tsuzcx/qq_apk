package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apj
  extends com.tencent.mm.bx.a
{
  public FinderObject Glx;
  public apk GnR;
  public int dataType;
  public apw syv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209337);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dataType);
      if (this.GnR != null)
      {
        paramVarArgs.lC(2, this.GnR.computeSize());
        this.GnR.writeFields(paramVarArgs);
      }
      if (this.syv != null)
      {
        paramVarArgs.lC(3, this.syv.computeSize());
        this.syv.writeFields(paramVarArgs);
      }
      if (this.Glx != null)
      {
        paramVarArgs.lC(4, this.Glx.computeSize());
        this.Glx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209337);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.dataType) + 0;
      paramInt = i;
      if (this.GnR != null) {
        paramInt = i + f.a.a.a.lB(2, this.GnR.computeSize());
      }
      i = paramInt;
      if (this.syv != null) {
        i = paramInt + f.a.a.a.lB(3, this.syv.computeSize());
      }
      paramInt = i;
      if (this.Glx != null) {
        paramInt = i + f.a.a.a.lB(4, this.Glx.computeSize());
      }
      AppMethodBeat.o(209337);
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
      AppMethodBeat.o(209337);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      apj localapj = (apj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209337);
        return -1;
      case 1: 
        localapj.dataType = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209337);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localapj.GnR = ((apk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209337);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localapj.syv = ((apw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209337);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new FinderObject();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localapj.Glx = ((FinderObject)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209337);
      return 0;
    }
    AppMethodBeat.o(209337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apj
 * JD-Core Version:    0.7.0.1
 */