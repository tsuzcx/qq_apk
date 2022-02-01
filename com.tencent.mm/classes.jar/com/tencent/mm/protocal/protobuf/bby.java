package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bby
  extends com.tencent.mm.bx.a
{
  public FinderObject ABJ;
  public asp ZMH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259573);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ABJ != null)
      {
        paramVarArgs.qD(1, this.ABJ.computeSize());
        this.ABJ.writeFields(paramVarArgs);
      }
      if (this.ZMH != null)
      {
        paramVarArgs.qD(2, this.ZMH.computeSize());
        this.ZMH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ABJ == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.ABJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZMH != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZMH.computeSize());
      }
      AppMethodBeat.o(259573);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bby localbby = (bby)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259573);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localbby.ABJ = ((FinderObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259573);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new asp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((asp)localObject2).parseFrom((byte[])localObject1);
          }
          localbby.ZMH = ((asp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259573);
        return 0;
      }
      AppMethodBeat.o(259573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bby
 * JD-Core Version:    0.7.0.1
 */