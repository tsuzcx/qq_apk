package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aeo
  extends com.tencent.mm.bx.a
{
  public String DeI;
  public LinkedList<String> DeJ;
  public boolean DeK;
  public String Dex;
  
  public aeo()
  {
    AppMethodBeat.i(32203);
    this.DeJ = new LinkedList();
    AppMethodBeat.o(32203);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dex == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(32204);
        throw paramVarArgs;
      }
      if (this.Dex != null) {
        paramVarArgs.d(1, this.Dex);
      }
      if (this.DeI != null) {
        paramVarArgs.d(2, this.DeI);
      }
      paramVarArgs.e(3, 1, this.DeJ);
      paramVarArgs.bg(4, this.DeK);
      AppMethodBeat.o(32204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dex == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = f.a.a.b.b.a.e(1, this.Dex) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DeI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DeI);
      }
      paramInt = f.a.a.a.c(3, 1, this.DeJ);
      int j = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(32204);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DeJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dex == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(32204);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32204);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aeo localaeo = (aeo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32204);
          return -1;
        case 1: 
          localaeo.Dex = locala.KhF.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 2: 
          localaeo.DeI = locala.KhF.readString();
          AppMethodBeat.o(32204);
          return 0;
        case 3: 
          localaeo.DeJ.add(locala.KhF.readString());
          AppMethodBeat.o(32204);
          return 0;
        }
        localaeo.DeK = locala.KhF.fHu();
        AppMethodBeat.o(32204);
        return 0;
      }
      AppMethodBeat.o(32204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeo
 * JD-Core Version:    0.7.0.1
 */