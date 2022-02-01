package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cs
  extends com.tencent.mm.bx.a
{
  public epj YEZ;
  public epj YFa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125703);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YEZ != null)
      {
        paramVarArgs.qD(1, this.YEZ.computeSize());
        this.YEZ.writeFields(paramVarArgs);
      }
      if (this.YFa != null)
      {
        paramVarArgs.qD(2, this.YFa.computeSize());
        this.YFa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YEZ == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.YEZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YFa != null) {
        i = paramInt + i.a.a.a.qC(2, this.YFa.computeSize());
      }
      AppMethodBeat.o(125703);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cs localcs = (cs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        epj localepj;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125703);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localepj = new epj();
            if ((localObject != null) && (localObject.length > 0)) {
              localepj.parseFrom((byte[])localObject);
            }
            localcs.YEZ = localepj;
            paramInt += 1;
          }
          AppMethodBeat.o(125703);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localepj = new epj();
          if ((localObject != null) && (localObject.length > 0)) {
            localepj.parseFrom((byte[])localObject);
          }
          localcs.YFa = localepj;
          paramInt += 1;
        }
        AppMethodBeat.o(125703);
        return 0;
      }
      AppMethodBeat.o(125703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cs
 * JD-Core Version:    0.7.0.1
 */