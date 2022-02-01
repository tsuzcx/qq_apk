package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bjs
  extends com.tencent.mm.cd.a
{
  public FinderObject STY;
  public b STZ;
  public int jump_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206977);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.STY != null)
      {
        paramVarArgs.oE(1, this.STY.computeSize());
        this.STY.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.jump_type);
      if (this.STZ != null) {
        paramVarArgs.c(3, this.STZ);
      }
      AppMethodBeat.o(206977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.STY == null) {
        break label392;
      }
    }
    label392:
    for (paramInt = g.a.a.a.oD(1, this.STY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.jump_type);
      paramInt = i;
      if (this.STZ != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.STZ);
      }
      AppMethodBeat.o(206977);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206977);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bjs localbjs = (bjs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206977);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            FinderObject localFinderObject = new FinderObject();
            if ((localObject != null) && (localObject.length > 0)) {
              localFinderObject.parseFrom((byte[])localObject);
            }
            localbjs.STY = localFinderObject;
            paramInt += 1;
          }
          AppMethodBeat.o(206977);
          return 0;
        case 2: 
          localbjs.jump_type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(206977);
          return 0;
        }
        localbjs.STZ = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(206977);
        return 0;
      }
      AppMethodBeat.o(206977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjs
 * JD-Core Version:    0.7.0.1
 */