package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhq
  extends com.tencent.mm.cd.a
{
  public boolean TdU;
  public boolean TdV;
  public int TnG;
  public String TnI;
  public int TnN;
  public String appid;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123633);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.TnI != null) {
        paramVarArgs.f(2, this.TnI);
      }
      paramVarArgs.aY(3, this.TnG);
      paramVarArgs.aY(4, this.version);
      if (this.url != null) {
        paramVarArgs.f(5, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.f(6, this.md5);
      }
      paramVarArgs.co(20, this.TdU);
      paramVarArgs.co(21, this.TdV);
      paramVarArgs.aY(22, this.TnN);
      AppMethodBeat.o(123633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = g.a.a.b.b.a.g(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TnI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.TnI);
      }
      i = i + g.a.a.b.b.a.bM(3, this.TnG) + g.a.a.b.b.a.bM(4, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.md5);
      }
      paramInt = g.a.a.b.b.a.gL(20);
      int j = g.a.a.b.b.a.gL(21);
      int k = g.a.a.b.b.a.bM(22, this.TnN);
      AppMethodBeat.o(123633);
      return i + (paramInt + 1) + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123633);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dhq localdhq = (dhq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123633);
          return -1;
        case 1: 
          localdhq.appid = locala.abFh.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 2: 
          localdhq.TnI = locala.abFh.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 3: 
          localdhq.TnG = locala.abFh.AK();
          AppMethodBeat.o(123633);
          return 0;
        case 4: 
          localdhq.version = locala.abFh.AK();
          AppMethodBeat.o(123633);
          return 0;
        case 5: 
          localdhq.url = locala.abFh.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 6: 
          localdhq.md5 = locala.abFh.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 20: 
          localdhq.TdU = locala.abFh.AB();
          AppMethodBeat.o(123633);
          return 0;
        case 21: 
          localdhq.TdV = locala.abFh.AB();
          AppMethodBeat.o(123633);
          return 0;
        }
        localdhq.TnN = locala.abFh.AK();
        AppMethodBeat.o(123633);
        return 0;
      }
      AppMethodBeat.o(123633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhq
 * JD-Core Version:    0.7.0.1
 */