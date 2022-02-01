package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fk
  extends com.tencent.mm.bx.a
{
  public String CAc;
  public int CAd;
  public int CAe;
  public long CAf;
  public int CAg;
  public long gLf;
  public int idx;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124388);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CAc != null) {
        paramVarArgs.d(1, this.CAc);
      }
      paramVarArgs.aG(2, this.gLf);
      paramVarArgs.aR(3, this.idx);
      paramVarArgs.aR(4, this.CAd);
      paramVarArgs.aR(5, this.CAe);
      paramVarArgs.aG(6, this.CAf);
      paramVarArgs.aR(7, this.CAg);
      if (this.url != null) {
        paramVarArgs.d(8, this.url);
      }
      AppMethodBeat.o(124388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CAc == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.CAc) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.gLf) + f.a.a.b.b.a.bA(3, this.idx) + f.a.a.b.b.a.bA(4, this.CAd) + f.a.a.b.b.a.bA(5, this.CAe) + f.a.a.b.b.a.q(6, this.CAf) + f.a.a.b.b.a.bA(7, this.CAg);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.url);
      }
      AppMethodBeat.o(124388);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124388);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fk localfk = (fk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124388);
          return -1;
        case 1: 
          localfk.CAc = locala.KhF.readString();
          AppMethodBeat.o(124388);
          return 0;
        case 2: 
          localfk.gLf = locala.KhF.xT();
          AppMethodBeat.o(124388);
          return 0;
        case 3: 
          localfk.idx = locala.KhF.xS();
          AppMethodBeat.o(124388);
          return 0;
        case 4: 
          localfk.CAd = locala.KhF.xS();
          AppMethodBeat.o(124388);
          return 0;
        case 5: 
          localfk.CAe = locala.KhF.xS();
          AppMethodBeat.o(124388);
          return 0;
        case 6: 
          localfk.CAf = locala.KhF.xT();
          AppMethodBeat.o(124388);
          return 0;
        case 7: 
          localfk.CAg = locala.KhF.xS();
          AppMethodBeat.o(124388);
          return 0;
        }
        localfk.url = locala.KhF.readString();
        AppMethodBeat.o(124388);
        return 0;
      }
      AppMethodBeat.o(124388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fk
 * JD-Core Version:    0.7.0.1
 */