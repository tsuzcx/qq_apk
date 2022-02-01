package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dda
  extends com.tencent.mm.bx.a
{
  public fmp YCT;
  public String YMe;
  public LinkedList<fmp> nUC;
  
  public dda()
  {
    AppMethodBeat.i(91524);
    this.nUC = new LinkedList();
    AppMethodBeat.o(91524);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91525);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YCT != null)
      {
        paramVarArgs.qD(1, this.YCT.computeSize());
        this.YCT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.nUC);
      if (this.YMe != null) {
        paramVarArgs.g(3, this.YMe);
      }
      AppMethodBeat.o(91525);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YCT == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.YCT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.nUC);
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YMe);
      }
      AppMethodBeat.o(91525);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91525);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dda localdda = (dda)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        fmp localfmp;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91525);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localfmp = new fmp();
            if ((localObject != null) && (localObject.length > 0)) {
              localfmp.parseFrom((byte[])localObject);
            }
            localdda.YCT = localfmp;
            paramInt += 1;
          }
          AppMethodBeat.o(91525);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localfmp = new fmp();
            if ((localObject != null) && (localObject.length > 0)) {
              localfmp.parseFrom((byte[])localObject);
            }
            localdda.nUC.add(localfmp);
            paramInt += 1;
          }
          AppMethodBeat.o(91525);
          return 0;
        }
        localdda.YMe = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91525);
        return 0;
      }
      AppMethodBeat.o(91525);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dda
 * JD-Core Version:    0.7.0.1
 */