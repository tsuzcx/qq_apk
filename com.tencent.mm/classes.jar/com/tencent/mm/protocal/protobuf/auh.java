package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class auh
  extends com.tencent.mm.bx.a
{
  public LinkedList<pu> ZEL;
  public LinkedList<bpl> ZEM;
  
  public auh()
  {
    AppMethodBeat.i(257818);
    this.ZEL = new LinkedList();
    this.ZEM = new LinkedList();
    AppMethodBeat.o(257818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257823);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZEL);
      paramVarArgs.e(2, 8, this.ZEM);
      AppMethodBeat.o(257823);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.ZEL);
      i = i.a.a.a.c(2, 8, this.ZEM);
      AppMethodBeat.o(257823);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZEL.clear();
      this.ZEM.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257823);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      auh localauh = (auh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257823);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new pu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((pu)localObject2).parseFrom((byte[])localObject1);
          }
          localauh.ZEL.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257823);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bpl();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bpl)localObject2).parseFrom((byte[])localObject1);
        }
        localauh.ZEM.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257823);
      return 0;
    }
    AppMethodBeat.o(257823);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auh
 * JD-Core Version:    0.7.0.1
 */