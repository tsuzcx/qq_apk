package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oe
  extends com.tencent.mm.bx.a
{
  public oc YRl;
  public LinkedList<od> YRm;
  public String YRn;
  
  public oe()
  {
    AppMethodBeat.i(124400);
    this.YRm = new LinkedList();
    AppMethodBeat.o(124400);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124401);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRl != null)
      {
        paramVarArgs.qD(1, this.YRl.computeSize());
        this.YRl.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.YRm);
      if (this.YRn != null) {
        paramVarArgs.g(6, this.YRn);
      }
      AppMethodBeat.o(124401);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRl == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = i.a.a.a.qC(1, this.YRl.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.YRm);
      paramInt = i;
      if (this.YRn != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YRn);
      }
      AppMethodBeat.o(124401);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YRm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124401);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        oe localoe = (oe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        default: 
          AppMethodBeat.o(124401);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new oc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((oc)localObject2).parseFrom((byte[])localObject1);
            }
            localoe.YRl = ((oc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124401);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new od();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((od)localObject2).parseFrom((byte[])localObject1);
            }
            localoe.YRm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124401);
          return 0;
        }
        localoe.YRn = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(124401);
        return 0;
      }
      AppMethodBeat.o(124401);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oe
 * JD-Core Version:    0.7.0.1
 */