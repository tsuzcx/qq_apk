package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tw
  extends com.tencent.mm.bx.a
{
  public String FSp;
  public String FSq;
  public int FSr;
  public int FSs;
  public int FSt;
  public int FSu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123560);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FSp != null) {
        paramVarArgs.d(1, this.FSp);
      }
      if (this.FSq != null) {
        paramVarArgs.d(2, this.FSq);
      }
      paramVarArgs.aS(3, this.FSr);
      paramVarArgs.aS(4, this.FSs);
      paramVarArgs.aS(5, this.FSt);
      paramVarArgs.aS(6, this.FSu);
      AppMethodBeat.o(123560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FSp == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.FSp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FSq != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FSq);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.FSr);
      int j = f.a.a.b.b.a.bz(4, this.FSs);
      int k = f.a.a.b.b.a.bz(5, this.FSt);
      int m = f.a.a.b.b.a.bz(6, this.FSu);
      AppMethodBeat.o(123560);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123560);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        tw localtw = (tw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123560);
          return -1;
        case 1: 
          localtw.FSp = locala.NPN.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 2: 
          localtw.FSq = locala.NPN.readString();
          AppMethodBeat.o(123560);
          return 0;
        case 3: 
          localtw.FSr = locala.NPN.zc();
          AppMethodBeat.o(123560);
          return 0;
        case 4: 
          localtw.FSs = locala.NPN.zc();
          AppMethodBeat.o(123560);
          return 0;
        case 5: 
          localtw.FSt = locala.NPN.zc();
          AppMethodBeat.o(123560);
          return 0;
        }
        localtw.FSu = locala.NPN.zc();
        AppMethodBeat.o(123560);
        return 0;
      }
      AppMethodBeat.o(123560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tw
 * JD-Core Version:    0.7.0.1
 */