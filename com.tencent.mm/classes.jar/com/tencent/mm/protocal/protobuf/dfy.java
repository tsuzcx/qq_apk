package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfy
  extends com.tencent.mm.bw.a
{
  public boolean LXH;
  public int MKJ;
  public String dPS;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123639);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.LXH);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.e(3, this.md5);
      }
      paramVarArgs.aM(4, this.version);
      paramVarArgs.aM(5, this.MKJ);
      if (this.dPS != null) {
        paramVarArgs.e(6, this.dPS);
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.md5);
      }
      i = i + g.a.a.b.b.a.bu(4, this.version) + g.a.a.b.b.a.bu(5, this.MKJ);
      paramInt = i;
      if (this.dPS != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dPS);
      }
      AppMethodBeat.o(123639);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dfy localdfy = (dfy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123639);
        return -1;
      case 1: 
        localdfy.LXH = locala.UbS.yZ();
        AppMethodBeat.o(123639);
        return 0;
      case 2: 
        localdfy.url = locala.UbS.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 3: 
        localdfy.md5 = locala.UbS.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 4: 
        localdfy.version = locala.UbS.zi();
        AppMethodBeat.o(123639);
        return 0;
      case 5: 
        localdfy.MKJ = locala.UbS.zi();
        AppMethodBeat.o(123639);
        return 0;
      }
      localdfy.dPS = locala.UbS.readString();
      AppMethodBeat.o(123639);
      return 0;
    }
    AppMethodBeat.o(123639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfy
 * JD-Core Version:    0.7.0.1
 */