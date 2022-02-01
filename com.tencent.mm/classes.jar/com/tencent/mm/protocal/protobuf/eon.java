package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class eon
  extends com.tencent.mm.bx.a
{
  public awr YGg;
  public b ZEQ;
  public LinkedList<aep> absP;
  
  public eon()
  {
    AppMethodBeat.i(259414);
    this.absP = new LinkedList();
    AppMethodBeat.o(259414);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259421);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGg != null)
      {
        paramVarArgs.qD(1, this.YGg.computeSize());
        this.YGg.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(2, this.ZEQ);
      }
      paramVarArgs.e(3, 8, this.absP);
      AppMethodBeat.o(259421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGg == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.YGg.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ZEQ);
      }
      paramInt = i.a.a.a.c(3, 8, this.absP);
      AppMethodBeat.o(259421);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.absP.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eon localeon = (eon)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259421);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awr)localObject2).parseFrom((byte[])localObject1);
            }
            localeon.YGg = ((awr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259421);
          return 0;
        case 2: 
          localeon.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259421);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aep();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aep)localObject2).parseFrom((byte[])localObject1);
          }
          localeon.absP.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259421);
        return 0;
      }
      AppMethodBeat.o(259421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eon
 * JD-Core Version:    0.7.0.1
 */