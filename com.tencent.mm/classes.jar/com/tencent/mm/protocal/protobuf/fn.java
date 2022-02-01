package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fn
  extends com.tencent.mm.bx.a
{
  public int CAi;
  public int CAj;
  public int CAk;
  public int CAl;
  public int CAm;
  public String CAn;
  public int CAo;
  public int height;
  public long niE;
  public String url;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103201);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.aR(2, this.CAi);
      paramVarArgs.aR(3, this.CAj);
      paramVarArgs.aG(4, this.niE);
      paramVarArgs.aR(5, this.width);
      paramVarArgs.aR(6, this.height);
      paramVarArgs.aR(10, this.CAk);
      paramVarArgs.aR(11, this.CAl);
      paramVarArgs.aR(12, this.CAm);
      if (this.CAn != null) {
        paramVarArgs.d(13, this.CAn);
      }
      paramVarArgs.aR(15, this.CAo);
      AppMethodBeat.o(103201);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CAi) + f.a.a.b.b.a.bA(3, this.CAj) + f.a.a.b.b.a.q(4, this.niE) + f.a.a.b.b.a.bA(5, this.width) + f.a.a.b.b.a.bA(6, this.height) + f.a.a.b.b.a.bA(10, this.CAk) + f.a.a.b.b.a.bA(11, this.CAl) + f.a.a.b.b.a.bA(12, this.CAm);
      paramInt = i;
      if (this.CAn != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.CAn);
      }
      i = f.a.a.b.b.a.bA(15, this.CAo);
      AppMethodBeat.o(103201);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(103201);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fn localfn = (fn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        case 8: 
        case 9: 
        case 14: 
        default: 
          AppMethodBeat.o(103201);
          return -1;
        case 1: 
          localfn.url = locala.KhF.readString();
          AppMethodBeat.o(103201);
          return 0;
        case 2: 
          localfn.CAi = locala.KhF.xS();
          AppMethodBeat.o(103201);
          return 0;
        case 3: 
          localfn.CAj = locala.KhF.xS();
          AppMethodBeat.o(103201);
          return 0;
        case 4: 
          localfn.niE = locala.KhF.xT();
          AppMethodBeat.o(103201);
          return 0;
        case 5: 
          localfn.width = locala.KhF.xS();
          AppMethodBeat.o(103201);
          return 0;
        case 6: 
          localfn.height = locala.KhF.xS();
          AppMethodBeat.o(103201);
          return 0;
        case 10: 
          localfn.CAk = locala.KhF.xS();
          AppMethodBeat.o(103201);
          return 0;
        case 11: 
          localfn.CAl = locala.KhF.xS();
          AppMethodBeat.o(103201);
          return 0;
        case 12: 
          localfn.CAm = locala.KhF.xS();
          AppMethodBeat.o(103201);
          return 0;
        case 13: 
          localfn.CAn = locala.KhF.readString();
          AppMethodBeat.o(103201);
          return 0;
        }
        localfn.CAo = locala.KhF.xS();
        AppMethodBeat.o(103201);
        return 0;
      }
      AppMethodBeat.o(103201);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fn
 * JD-Core Version:    0.7.0.1
 */