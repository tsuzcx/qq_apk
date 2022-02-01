package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdk
  extends com.tencent.mm.cd.a
{
  public boolean SOt;
  public String SOu;
  public boolean SOv;
  public boolean SOw;
  public int SrY;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230230);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      paramVarArgs.co(2, this.SOt);
      if (this.SOu != null) {
        paramVarArgs.f(3, this.SOu);
      }
      paramVarArgs.co(4, this.SOv);
      paramVarArgs.co(5, this.SOw);
      paramVarArgs.aY(6, this.SrY);
      AppMethodBeat.o(230230);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = g.a.a.b.b.a.g(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.SOu != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SOu);
      }
      i = g.a.a.b.b.a.gL(4);
      int j = g.a.a.b.b.a.gL(5);
      int k = g.a.a.b.b.a.bM(6, this.SrY);
      AppMethodBeat.o(230230);
      return paramInt + (i + 1) + (j + 1) + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230230);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bdk localbdk = (bdk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(230230);
          return -1;
        case 1: 
          localbdk.appid = locala.abFh.readString();
          AppMethodBeat.o(230230);
          return 0;
        case 2: 
          localbdk.SOt = locala.abFh.AB();
          AppMethodBeat.o(230230);
          return 0;
        case 3: 
          localbdk.SOu = locala.abFh.readString();
          AppMethodBeat.o(230230);
          return 0;
        case 4: 
          localbdk.SOv = locala.abFh.AB();
          AppMethodBeat.o(230230);
          return 0;
        case 5: 
          localbdk.SOw = locala.abFh.AB();
          AppMethodBeat.o(230230);
          return 0;
        }
        localbdk.SrY = locala.abFh.AK();
        AppMethodBeat.o(230230);
        return 0;
      }
      AppMethodBeat.o(230230);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdk
 * JD-Core Version:    0.7.0.1
 */