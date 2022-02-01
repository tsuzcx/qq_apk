package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dps
  extends com.tencent.mm.cd.a
{
  public int TWD;
  public boolean TWE;
  public boolean TgY;
  public String fJj;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123639);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.TgY);
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.f(3, this.md5);
      }
      paramVarArgs.aY(4, this.version);
      paramVarArgs.aY(5, this.TWD);
      if (this.fJj != null) {
        paramVarArgs.f(6, this.fJj);
      }
      paramVarArgs.co(7, this.TWE);
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.md5);
      }
      i = i + g.a.a.b.b.a.bM(4, this.version) + g.a.a.b.b.a.bM(5, this.TWD);
      paramInt = i;
      if (this.fJj != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fJj);
      }
      i = g.a.a.b.b.a.gL(7);
      AppMethodBeat.o(123639);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dps localdps = (dps)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123639);
        return -1;
      case 1: 
        localdps.TgY = locala.abFh.AB();
        AppMethodBeat.o(123639);
        return 0;
      case 2: 
        localdps.url = locala.abFh.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 3: 
        localdps.md5 = locala.abFh.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 4: 
        localdps.version = locala.abFh.AK();
        AppMethodBeat.o(123639);
        return 0;
      case 5: 
        localdps.TWD = locala.abFh.AK();
        AppMethodBeat.o(123639);
        return 0;
      case 6: 
        localdps.fJj = locala.abFh.readString();
        AppMethodBeat.o(123639);
        return 0;
      }
      localdps.TWE = locala.abFh.AB();
      AppMethodBeat.o(123639);
      return 0;
    }
    AppMethodBeat.o(123639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dps
 * JD-Core Version:    0.7.0.1
 */