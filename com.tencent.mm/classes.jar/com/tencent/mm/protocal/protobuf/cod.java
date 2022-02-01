package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cod
  extends com.tencent.mm.bw.a
{
  public boolean GTy;
  public int HAa;
  public String dyl;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.GTy);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aS(4, this.version);
      paramVarArgs.aS(5, this.HAa);
      if (this.dyl != null) {
        paramVarArgs.d(6, this.dyl);
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bz(4, this.version) + f.a.a.b.b.a.bz(5, this.HAa);
      paramInt = i;
      if (this.dyl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dyl);
      }
      AppMethodBeat.o(123639);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cod localcod = (cod)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123639);
        return -1;
      case 1: 
        localcod.GTy = locala.OmT.gvY();
        AppMethodBeat.o(123639);
        return 0;
      case 2: 
        localcod.url = locala.OmT.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 3: 
        localcod.md5 = locala.OmT.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 4: 
        localcod.version = locala.OmT.zc();
        AppMethodBeat.o(123639);
        return 0;
      case 5: 
        localcod.HAa = locala.OmT.zc();
        AppMethodBeat.o(123639);
        return 0;
      }
      localcod.dyl = locala.OmT.readString();
      AppMethodBeat.o(123639);
      return 0;
    }
    AppMethodBeat.o(123639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cod
 * JD-Core Version:    0.7.0.1
 */