package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdg
  extends com.tencent.mm.bx.a
{
  public boolean DZy;
  public int DZz;
  public String dnK;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.DZy);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aR(4, this.version);
      paramVarArgs.aR(5, this.DZz);
      if (this.dnK != null) {
        paramVarArgs.d(6, this.dnK);
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bA(4, this.version) + f.a.a.b.b.a.bA(5, this.DZz);
      paramInt = i;
      if (this.dnK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dnK);
      }
      AppMethodBeat.o(123639);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123639);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cdg localcdg = (cdg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123639);
        return -1;
      case 1: 
        localcdg.DZy = locala.KhF.fHu();
        AppMethodBeat.o(123639);
        return 0;
      case 2: 
        localcdg.url = locala.KhF.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 3: 
        localcdg.md5 = locala.KhF.readString();
        AppMethodBeat.o(123639);
        return 0;
      case 4: 
        localcdg.version = locala.KhF.xS();
        AppMethodBeat.o(123639);
        return 0;
      case 5: 
        localcdg.DZz = locala.KhF.xS();
        AppMethodBeat.o(123639);
        return 0;
      }
      localcdg.dnK = locala.KhF.readString();
      AppMethodBeat.o(123639);
      return 0;
    }
    AppMethodBeat.o(123639);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdg
 * JD-Core Version:    0.7.0.1
 */