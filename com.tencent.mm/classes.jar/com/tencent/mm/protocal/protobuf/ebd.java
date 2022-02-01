package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebd
  extends com.tencent.mm.bx.a
{
  public LinkedList<ebe> Ksg;
  public String ltm;
  
  public ebd()
  {
    AppMethodBeat.i(258203);
    this.Ksg = new LinkedList();
    AppMethodBeat.o(258203);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258205);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ltm != null) {
        paramVarArgs.g(1, this.ltm);
      }
      paramVarArgs.e(2, 8, this.Ksg);
      AppMethodBeat.o(258205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ltm == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.ltm) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.Ksg);
      AppMethodBeat.o(258205);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ksg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258205);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ebd localebd = (ebd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258205);
          return -1;
        case 1: 
          localebd.ltm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258205);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ebe localebe = new ebe();
          if ((localObject != null) && (localObject.length > 0)) {
            localebe.parseFrom((byte[])localObject);
          }
          localebd.Ksg.add(localebe);
          paramInt += 1;
        }
        AppMethodBeat.o(258205);
        return 0;
      }
      AppMethodBeat.o(258205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebd
 * JD-Core Version:    0.7.0.1
 */