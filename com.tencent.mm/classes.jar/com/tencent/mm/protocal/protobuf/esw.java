package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esw
  extends com.tencent.mm.cd.a
{
  public String UuR;
  public String UuS;
  public LinkedList<aoz> UuT;
  
  public esw()
  {
    AppMethodBeat.i(153008);
    this.UuT = new LinkedList();
    AppMethodBeat.o(153008);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153009);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UuR != null) {
        paramVarArgs.f(1, this.UuR);
      }
      if (this.UuS != null) {
        paramVarArgs.f(2, this.UuS);
      }
      paramVarArgs.e(3, 8, this.UuT);
      AppMethodBeat.o(153009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UuR == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = g.a.a.b.b.a.g(1, this.UuR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UuS != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UuS);
      }
      paramInt = g.a.a.a.c(3, 8, this.UuT);
      AppMethodBeat.o(153009);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UuT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        esw localesw = (esw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153009);
          return -1;
        case 1: 
          localesw.UuR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153009);
          return 0;
        case 2: 
          localesw.UuS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153009);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aoz localaoz = new aoz();
          if ((localObject != null) && (localObject.length > 0)) {
            localaoz.parseFrom((byte[])localObject);
          }
          localesw.UuT.add(localaoz);
          paramInt += 1;
        }
        AppMethodBeat.o(153009);
        return 0;
      }
      AppMethodBeat.o(153009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esw
 * JD-Core Version:    0.7.0.1
 */