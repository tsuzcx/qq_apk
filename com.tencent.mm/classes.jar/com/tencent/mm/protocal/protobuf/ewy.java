package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ewy
  extends com.tencent.mm.bw.a
{
  public b Nur;
  public String description;
  public String rCq;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212321);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rCq != null) {
        paramVarArgs.e(1, this.rCq);
      }
      if (this.Nur != null) {
        paramVarArgs.c(2, this.Nur);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      if (this.description != null) {
        paramVarArgs.e(4, this.description);
      }
      AppMethodBeat.o(212321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rCq == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.rCq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nur != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Nur);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.title);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.description);
      }
      AppMethodBeat.o(212321);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212321);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ewy localewy = (ewy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(212321);
          return -1;
        case 1: 
          localewy.rCq = locala.UbS.readString();
          AppMethodBeat.o(212321);
          return 0;
        case 2: 
          localewy.Nur = locala.UbS.hPo();
          AppMethodBeat.o(212321);
          return 0;
        case 3: 
          localewy.title = locala.UbS.readString();
          AppMethodBeat.o(212321);
          return 0;
        }
        localewy.description = locala.UbS.readString();
        AppMethodBeat.o(212321);
        return 0;
      }
      AppMethodBeat.o(212321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewy
 * JD-Core Version:    0.7.0.1
 */