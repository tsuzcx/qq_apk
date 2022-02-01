package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fyc
  extends com.tencent.mm.bx.a
{
  public dmj abVX;
  public int abVY;
  public eab abwz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91725);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abwz != null)
      {
        paramVarArgs.qD(1, this.abwz.computeSize());
        this.abwz.writeFields(paramVarArgs);
      }
      if (this.abVX != null)
      {
        paramVarArgs.qD(2, this.abVX.computeSize());
        this.abVX.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abVY);
      AppMethodBeat.o(91725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abwz == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = i.a.a.a.qC(1, this.abwz.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abVX != null) {
        i = paramInt + i.a.a.a.qC(2, this.abVX.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abVY);
      AppMethodBeat.o(91725);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91725);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fyc localfyc = (fyc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91725);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eab();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eab)localObject2).parseFrom((byte[])localObject1);
            }
            localfyc.abwz = ((eab)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmj)localObject2).parseFrom((byte[])localObject1);
            }
            localfyc.abVX = ((dmj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        }
        localfyc.abVY = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91725);
        return 0;
      }
      AppMethodBeat.o(91725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fyc
 * JD-Core Version:    0.7.0.1
 */