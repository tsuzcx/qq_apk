package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cye
  extends com.tencent.mm.bw.a
{
  public boolean LVl;
  public boolean LVm;
  public String MbW;
  public int MbZ;
  public int Mel;
  public String dNI;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123633);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.MbW != null) {
        paramVarArgs.e(2, this.MbW);
      }
      paramVarArgs.aM(3, this.MbZ);
      paramVarArgs.aM(4, this.version);
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.e(6, this.md5);
      }
      paramVarArgs.cc(20, this.LVl);
      paramVarArgs.cc(21, this.LVm);
      paramVarArgs.aM(22, this.Mel);
      AppMethodBeat.o(123633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = g.a.a.b.b.a.f(1, this.dNI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MbW != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MbW);
      }
      i = i + g.a.a.b.b.a.bu(3, this.MbZ) + g.a.a.b.b.a.bu(4, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.md5);
      }
      paramInt = g.a.a.b.b.a.fS(20);
      int j = g.a.a.b.b.a.fS(21);
      int k = g.a.a.b.b.a.bu(22, this.Mel);
      AppMethodBeat.o(123633);
      return i + (paramInt + 1) + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123633);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cye localcye = (cye)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123633);
          return -1;
        case 1: 
          localcye.dNI = locala.UbS.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 2: 
          localcye.MbW = locala.UbS.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 3: 
          localcye.MbZ = locala.UbS.zi();
          AppMethodBeat.o(123633);
          return 0;
        case 4: 
          localcye.version = locala.UbS.zi();
          AppMethodBeat.o(123633);
          return 0;
        case 5: 
          localcye.url = locala.UbS.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 6: 
          localcye.md5 = locala.UbS.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 20: 
          localcye.LVl = locala.UbS.yZ();
          AppMethodBeat.o(123633);
          return 0;
        case 21: 
          localcye.LVm = locala.UbS.yZ();
          AppMethodBeat.o(123633);
          return 0;
        }
        localcye.Mel = locala.UbS.zi();
        AppMethodBeat.o(123633);
        return 0;
      }
      AppMethodBeat.o(123633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cye
 * JD-Core Version:    0.7.0.1
 */