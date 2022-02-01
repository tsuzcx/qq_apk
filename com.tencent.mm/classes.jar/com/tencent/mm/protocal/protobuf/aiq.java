package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aiq
  extends com.tencent.mm.bx.a
{
  public LinkedList<dxf> YFR;
  public String pss;
  
  public aiq()
  {
    AppMethodBeat.i(152531);
    this.YFR = new LinkedList();
    AppMethodBeat.o(152531);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152532);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.pss != null) {
        paramVarArgs.g(1, this.pss);
      }
      paramVarArgs.e(2, 8, this.YFR);
      AppMethodBeat.o(152532);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pss == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.pss) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.YFR);
      AppMethodBeat.o(152532);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFR.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152532);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aiq localaiq = (aiq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152532);
          return -1;
        case 1: 
          localaiq.pss = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152532);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dxf localdxf = new dxf();
          if ((localObject != null) && (localObject.length > 0)) {
            localdxf.parseFrom((byte[])localObject);
          }
          localaiq.YFR.add(localdxf);
          paramInt += 1;
        }
        AppMethodBeat.o(152532);
        return 0;
      }
      AppMethodBeat.o(152532);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiq
 * JD-Core Version:    0.7.0.1
 */