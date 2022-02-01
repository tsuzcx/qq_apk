package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqf
  extends com.tencent.mm.cd.a
{
  public String SwF;
  public aoy UsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124562);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SwF != null) {
        paramVarArgs.f(1, this.SwF);
      }
      if (this.UsC != null)
      {
        paramVarArgs.oE(2, this.UsC.computeSize());
        this.UsC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SwF == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.b.b.a.g(1, this.SwF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UsC != null) {
        i = paramInt + g.a.a.a.oD(2, this.UsC.computeSize());
      }
      AppMethodBeat.o(124562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eqf localeqf = (eqf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124562);
          return -1;
        case 1: 
          localeqf.SwF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124562);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aoy localaoy = new aoy();
          if ((localObject != null) && (localObject.length > 0)) {
            localaoy.parseFrom((byte[])localObject);
          }
          localeqf.UsC = localaoy;
          paramInt += 1;
        }
        AppMethodBeat.o(124562);
        return 0;
      }
      AppMethodBeat.o(124562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqf
 * JD-Core Version:    0.7.0.1
 */