package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxa
  extends com.tencent.mm.bx.a
{
  public String Epg;
  public boolean Eph;
  public boolean Epi;
  public String appName;
  public int bUc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116816);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Epg != null) {
        paramVarArgs.d(1, this.Epg);
      }
      if (this.appName != null) {
        paramVarArgs.d(2, this.appName);
      }
      paramVarArgs.aR(3, this.bUc);
      paramVarArgs.bg(4, this.Eph);
      paramVarArgs.bg(5, this.Epi);
      AppMethodBeat.o(116816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Epg == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = f.a.a.b.b.a.e(1, this.Epg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appName != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.appName);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.bUc);
      int j = f.a.a.b.b.a.fY(4);
      int k = f.a.a.b.b.a.fY(5);
      AppMethodBeat.o(116816);
      return i + paramInt + (j + 1) + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(116816);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cxa localcxa = (cxa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116816);
          return -1;
        case 1: 
          localcxa.Epg = locala.KhF.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 2: 
          localcxa.appName = locala.KhF.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 3: 
          localcxa.bUc = locala.KhF.xS();
          AppMethodBeat.o(116816);
          return 0;
        case 4: 
          localcxa.Eph = locala.KhF.fHu();
          AppMethodBeat.o(116816);
          return 0;
        }
        localcxa.Epi = locala.KhF.fHu();
        AppMethodBeat.o(116816);
        return 0;
      }
      AppMethodBeat.o(116816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxa
 * JD-Core Version:    0.7.0.1
 */