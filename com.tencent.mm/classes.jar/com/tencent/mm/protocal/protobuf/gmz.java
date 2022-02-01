package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gmz
  extends com.tencent.mm.bx.a
{
  public gmn achK;
  public int acii;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153348);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.achK != null)
      {
        paramVarArgs.qD(1, this.achK.computeSize());
        this.achK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.acii);
      AppMethodBeat.o(153348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.achK == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = i.a.a.a.qC(1, this.achK.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.acii);
      AppMethodBeat.o(153348);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153348);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gmz localgmz = (gmz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153348);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gmn localgmn = new gmn();
            if ((localObject != null) && (localObject.length > 0)) {
              localgmn.parseFrom((byte[])localObject);
            }
            localgmz.achK = localgmn;
            paramInt += 1;
          }
          AppMethodBeat.o(153348);
          return 0;
        }
        localgmz.acii = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(153348);
        return 0;
      }
      AppMethodBeat.o(153348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmz
 * JD-Core Version:    0.7.0.1
 */