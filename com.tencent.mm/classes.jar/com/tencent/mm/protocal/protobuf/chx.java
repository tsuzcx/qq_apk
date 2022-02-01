package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chx
  extends com.tencent.mm.bw.a
{
  public boolean GQV;
  public boolean GQW;
  public String GXn;
  public int GXq;
  public int GZl;
  public String dwb;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123633);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dwb != null) {
        paramVarArgs.d(1, this.dwb);
      }
      if (this.GXn != null) {
        paramVarArgs.d(2, this.GXn);
      }
      paramVarArgs.aS(3, this.GXq);
      paramVarArgs.aS(4, this.version);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(6, this.md5);
      }
      paramVarArgs.bC(20, this.GQV);
      paramVarArgs.bC(21, this.GQW);
      paramVarArgs.aS(22, this.GZl);
      AppMethodBeat.o(123633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dwb == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.b.b.a.e(1, this.dwb) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GXn != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GXn);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GXq) + f.a.a.b.b.a.bz(4, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.md5);
      }
      paramInt = f.a.a.b.b.a.amF(20);
      int j = f.a.a.b.b.a.amF(21);
      int k = f.a.a.b.b.a.bz(22, this.GZl);
      AppMethodBeat.o(123633);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123633);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chx localchx = (chx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123633);
          return -1;
        case 1: 
          localchx.dwb = locala.OmT.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 2: 
          localchx.GXn = locala.OmT.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 3: 
          localchx.GXq = locala.OmT.zc();
          AppMethodBeat.o(123633);
          return 0;
        case 4: 
          localchx.version = locala.OmT.zc();
          AppMethodBeat.o(123633);
          return 0;
        case 5: 
          localchx.url = locala.OmT.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 6: 
          localchx.md5 = locala.OmT.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 20: 
          localchx.GQV = locala.OmT.gvY();
          AppMethodBeat.o(123633);
          return 0;
        case 21: 
          localchx.GQW = locala.OmT.gvY();
          AppMethodBeat.o(123633);
          return 0;
        }
        localchx.GZl = locala.OmT.zc();
        AppMethodBeat.o(123633);
        return 0;
      }
      AppMethodBeat.o(123633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chx
 * JD-Core Version:    0.7.0.1
 */