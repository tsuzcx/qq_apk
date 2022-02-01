package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chd
  extends com.tencent.mm.bx.a
{
  public String GDK;
  public int GDN;
  public int GFJ;
  public boolean Gxv;
  public boolean Gxw;
  public String duW;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123633);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.duW != null) {
        paramVarArgs.d(1, this.duW);
      }
      if (this.GDK != null) {
        paramVarArgs.d(2, this.GDK);
      }
      paramVarArgs.aS(3, this.GDN);
      paramVarArgs.aS(4, this.version);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(6, this.md5);
      }
      paramVarArgs.bt(20, this.Gxv);
      paramVarArgs.bt(21, this.Gxw);
      paramVarArgs.aS(22, this.GFJ);
      AppMethodBeat.o(123633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.duW == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.b.b.a.e(1, this.duW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GDK != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GDK);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GDN) + f.a.a.b.b.a.bz(4, this.version);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.md5);
      }
      paramInt = f.a.a.b.b.a.alV(20);
      int j = f.a.a.b.b.a.alV(21);
      int k = f.a.a.b.b.a.bz(22, this.GFJ);
      AppMethodBeat.o(123633);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123633);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chd localchd = (chd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123633);
          return -1;
        case 1: 
          localchd.duW = locala.NPN.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 2: 
          localchd.GDK = locala.NPN.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 3: 
          localchd.GDN = locala.NPN.zc();
          AppMethodBeat.o(123633);
          return 0;
        case 4: 
          localchd.version = locala.NPN.zc();
          AppMethodBeat.o(123633);
          return 0;
        case 5: 
          localchd.url = locala.NPN.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 6: 
          localchd.md5 = locala.NPN.readString();
          AppMethodBeat.o(123633);
          return 0;
        case 20: 
          localchd.Gxv = locala.NPN.grw();
          AppMethodBeat.o(123633);
          return 0;
        case 21: 
          localchd.Gxw = locala.NPN.grw();
          AppMethodBeat.o(123633);
          return 0;
        }
        localchd.GFJ = locala.NPN.zc();
        AppMethodBeat.o(123633);
        return 0;
      }
      AppMethodBeat.o(123633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chd
 * JD-Core Version:    0.7.0.1
 */