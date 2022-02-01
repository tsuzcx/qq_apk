package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dkd
  extends com.tencent.mm.bx.a
{
  public int YOO;
  public gol aaPX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259562);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaPX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NotifyData");
        AppMethodBeat.o(259562);
        throw paramVarArgs;
      }
      if (this.aaPX != null)
      {
        paramVarArgs.qD(1, this.aaPX.computeSize());
        this.aaPX.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YOO);
      AppMethodBeat.o(259562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaPX == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = i.a.a.a.qC(1, this.aaPX.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.YOO);
      AppMethodBeat.o(259562);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaPX == null)
        {
          paramVarArgs = new b("Not all required fields were included: NotifyData");
          AppMethodBeat.o(259562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dkd localdkd = (dkd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259562);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gol localgol = new gol();
            if ((localObject != null) && (localObject.length > 0)) {
              localgol.dg((byte[])localObject);
            }
            localdkd.aaPX = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(259562);
          return 0;
        }
        localdkd.YOO = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259562);
        return 0;
      }
      AppMethodBeat.o(259562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkd
 * JD-Core Version:    0.7.0.1
 */