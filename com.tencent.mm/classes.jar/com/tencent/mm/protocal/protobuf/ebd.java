package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebd
  extends com.tencent.mm.bx.a
{
  public int HNO;
  public ebh HNP;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HNO);
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      if (this.HNP != null)
      {
        paramVarArgs.lC(3, this.HNP.computeSize());
        this.HNP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209421);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HNO) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = paramInt;
      if (this.HNP != null) {
        i = paramInt + f.a.a.a.lB(3, this.HNP.computeSize());
      }
      AppMethodBeat.o(209421);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209421);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ebd localebd = (ebd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209421);
        return -1;
      case 1: 
        localebd.HNO = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209421);
        return 0;
      case 2: 
        localebd.Name = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(209421);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ebh();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ebh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localebd.HNP = ((ebh)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(209421);
      return 0;
    }
    AppMethodBeat.o(209421);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebd
 * JD-Core Version:    0.7.0.1
 */