package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnj
  extends com.tencent.mm.bx.a
{
  public boolean GzY;
  public int HgA;
  public String dxg;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.GzY);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aS(4, this.version);
      paramVarArgs.aS(5, this.HgA);
      if (this.dxg != null) {
        paramVarArgs.d(6, this.dxg);
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bz(4, this.version) + f.a.a.b.b.a.bz(5, this.HgA);
      paramInt = i;
      if (this.dxg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dxg);
      }
      AppMethodBeat.o(123639);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cnj localcnj = (cnj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123639);
        return -1;
      case 1: 
        localcnj.GzY = locala.NPN.grw();
        AppMethodBeat.o(123639);
        return 0;
      case 2: 
        localcnj.url = locala.NPN.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 3: 
        localcnj.md5 = locala.NPN.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 4: 
        localcnj.version = locala.NPN.zc();
        AppMethodBeat.o(123639);
        return 0;
      case 5: 
        localcnj.HgA = locala.NPN.zc();
        AppMethodBeat.o(123639);
        return 0;
      }
      localcnj.dxg = locala.NPN.readString();
      AppMethodBeat.o(123639);
      return 0;
    }
    AppMethodBeat.o(123639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnj
 * JD-Core Version:    0.7.0.1
 */