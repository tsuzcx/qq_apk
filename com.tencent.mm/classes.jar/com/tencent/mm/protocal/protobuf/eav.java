package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eav
  extends com.tencent.mm.bx.a
{
  public String Lzk;
  public String Lzl;
  public int Lzm;
  public int Lzn;
  public long Lzo;
  public long Lzp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202519);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Lzk != null) {
        paramVarArgs.d(1, this.Lzk);
      }
      if (this.Lzl != null) {
        paramVarArgs.d(2, this.Lzl);
      }
      paramVarArgs.aR(3, this.Lzm);
      paramVarArgs.aR(4, this.Lzn);
      paramVarArgs.aG(5, this.Lzo);
      paramVarArgs.aG(6, this.Lzp);
      AppMethodBeat.o(202519);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lzk == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.Lzk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lzl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Lzl);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.Lzm);
      int j = f.a.a.b.b.a.bA(4, this.Lzn);
      int k = f.a.a.b.b.a.q(5, this.Lzo);
      int m = f.a.a.b.b.a.q(6, this.Lzp);
      AppMethodBeat.o(202519);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(202519);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eav localeav = (eav)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(202519);
          return -1;
        case 1: 
          localeav.Lzk = locala.KhF.readString();
          AppMethodBeat.o(202519);
          return 0;
        case 2: 
          localeav.Lzl = locala.KhF.readString();
          AppMethodBeat.o(202519);
          return 0;
        case 3: 
          localeav.Lzm = locala.KhF.xS();
          AppMethodBeat.o(202519);
          return 0;
        case 4: 
          localeav.Lzn = locala.KhF.xS();
          AppMethodBeat.o(202519);
          return 0;
        case 5: 
          localeav.Lzo = locala.KhF.xT();
          AppMethodBeat.o(202519);
          return 0;
        }
        localeav.Lzp = locala.KhF.xT();
        AppMethodBeat.o(202519);
        return 0;
      }
      AppMethodBeat.o(202519);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eav
 * JD-Core Version:    0.7.0.1
 */