package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvl
  extends com.tencent.mm.bx.a
{
  public int HHN;
  public tz HHO;
  public tz HHP;
  public int HHQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117940);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HHN);
      if (this.HHO != null)
      {
        paramVarArgs.lC(4, this.HHO.computeSize());
        this.HHO.writeFields(paramVarArgs);
      }
      if (this.HHP != null)
      {
        paramVarArgs.lC(5, this.HHP.computeSize());
        this.HHP.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HHQ);
      AppMethodBeat.o(117940);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HHN) + 0;
      paramInt = i;
      if (this.HHO != null) {
        paramInt = i + f.a.a.a.lB(4, this.HHO.computeSize());
      }
      i = paramInt;
      if (this.HHP != null) {
        i = paramInt + f.a.a.a.lB(5, this.HHP.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.HHQ);
      AppMethodBeat.o(117940);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117940);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dvl localdvl = (dvl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 2: 
      case 3: 
      default: 
        AppMethodBeat.o(117940);
        return -1;
      case 1: 
        localdvl.HHN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117940);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvl.HHO = ((tz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdvl.HHP = ((tz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117940);
        return 0;
      }
      localdvl.HHQ = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(117940);
      return 0;
    }
    AppMethodBeat.o(117940);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvl
 * JD-Core Version:    0.7.0.1
 */