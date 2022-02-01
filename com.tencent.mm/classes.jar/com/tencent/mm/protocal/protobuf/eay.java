package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eay
  extends com.tencent.mm.cd.a
{
  public eaz RLS;
  public String scope;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187607);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.f(1, this.scope);
      }
      if (this.RLS != null)
      {
        paramVarArgs.oE(2, this.RLS.computeSize());
        this.RLS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(187607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.b.b.a.g(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RLS != null) {
        i = paramInt + g.a.a.a.oD(2, this.RLS.computeSize());
      }
      AppMethodBeat.o(187607);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(187607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eay localeay = (eay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(187607);
          return -1;
        case 1: 
          localeay.scope = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(187607);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eaz localeaz = new eaz();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaz.parseFrom((byte[])localObject);
          }
          localeay.RLS = localeaz;
          paramInt += 1;
        }
        AppMethodBeat.o(187607);
        return 0;
      }
      AppMethodBeat.o(187607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eay
 * JD-Core Version:    0.7.0.1
 */