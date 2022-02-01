package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezu
  extends com.tencent.mm.bw.a
{
  public com.tencent.mm.bw.b KKz;
  public int KUy;
  public String MRZ;
  public boolean NvT;
  public boolean NvU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32564);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MRZ == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32564);
        throw paramVarArgs;
      }
      if (this.MRZ != null) {
        paramVarArgs.e(1, this.MRZ);
      }
      paramVarArgs.aM(2, this.KUy);
      if (this.KKz != null) {
        paramVarArgs.c(3, this.KKz);
      }
      paramVarArgs.cc(4, this.NvT);
      paramVarArgs.cc(5, this.NvU);
      AppMethodBeat.o(32564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MRZ == null) {
        break label465;
      }
    }
    label465:
    for (paramInt = g.a.a.b.b.a.f(1, this.MRZ) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KUy);
      paramInt = i;
      if (this.KKz != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.KKz);
      }
      i = g.a.a.b.b.a.fS(4);
      int j = g.a.a.b.b.a.fS(5);
      AppMethodBeat.o(32564);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.MRZ == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32564);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32564);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezu localezu = (ezu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32564);
          return -1;
        case 1: 
          localezu.MRZ = locala.UbS.readString();
          AppMethodBeat.o(32564);
          return 0;
        case 2: 
          localezu.KUy = locala.UbS.zi();
          AppMethodBeat.o(32564);
          return 0;
        case 3: 
          localezu.KKz = locala.UbS.hPo();
          AppMethodBeat.o(32564);
          return 0;
        case 4: 
          localezu.NvT = locala.UbS.yZ();
          AppMethodBeat.o(32564);
          return 0;
        }
        localezu.NvU = locala.UbS.yZ();
        AppMethodBeat.o(32564);
        return 0;
      }
      AppMethodBeat.o(32564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezu
 * JD-Core Version:    0.7.0.1
 */