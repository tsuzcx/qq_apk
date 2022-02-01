package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gh
  extends com.tencent.mm.bw.a
{
  public int KKc;
  public int KKd;
  public int KKe;
  public int KKf;
  public int KKg;
  public String KKh;
  public int KKi;
  public int height;
  public long pHr;
  public String url;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103201);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      paramVarArgs.aM(2, this.KKc);
      paramVarArgs.aM(3, this.KKd);
      paramVarArgs.bb(4, this.pHr);
      paramVarArgs.aM(5, this.width);
      paramVarArgs.aM(6, this.height);
      paramVarArgs.aM(10, this.KKe);
      paramVarArgs.aM(11, this.KKf);
      paramVarArgs.aM(12, this.KKg);
      if (this.KKh != null) {
        paramVarArgs.e(13, this.KKh);
      }
      paramVarArgs.aM(15, this.KKi);
      AppMethodBeat.o(103201);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = g.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KKc) + g.a.a.b.b.a.bu(3, this.KKd) + g.a.a.b.b.a.r(4, this.pHr) + g.a.a.b.b.a.bu(5, this.width) + g.a.a.b.b.a.bu(6, this.height) + g.a.a.b.b.a.bu(10, this.KKe) + g.a.a.b.b.a.bu(11, this.KKf) + g.a.a.b.b.a.bu(12, this.KKg);
      paramInt = i;
      if (this.KKh != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.KKh);
      }
      i = g.a.a.b.b.a.bu(15, this.KKi);
      AppMethodBeat.o(103201);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(103201);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        gh localgh = (gh)paramVarArgs[1];
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
          localgh.url = locala.UbS.readString();
          AppMethodBeat.o(103201);
          return 0;
        case 2: 
          localgh.KKc = locala.UbS.zi();
          AppMethodBeat.o(103201);
          return 0;
        case 3: 
          localgh.KKd = locala.UbS.zi();
          AppMethodBeat.o(103201);
          return 0;
        case 4: 
          localgh.pHr = locala.UbS.zl();
          AppMethodBeat.o(103201);
          return 0;
        case 5: 
          localgh.width = locala.UbS.zi();
          AppMethodBeat.o(103201);
          return 0;
        case 6: 
          localgh.height = locala.UbS.zi();
          AppMethodBeat.o(103201);
          return 0;
        case 10: 
          localgh.KKe = locala.UbS.zi();
          AppMethodBeat.o(103201);
          return 0;
        case 11: 
          localgh.KKf = locala.UbS.zi();
          AppMethodBeat.o(103201);
          return 0;
        case 12: 
          localgh.KKg = locala.UbS.zi();
          AppMethodBeat.o(103201);
          return 0;
        case 13: 
          localgh.KKh = locala.UbS.readString();
          AppMethodBeat.o(103201);
          return 0;
        }
        localgh.KKi = locala.UbS.zi();
        AppMethodBeat.o(103201);
        return 0;
      }
      AppMethodBeat.o(103201);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gh
 * JD-Core Version:    0.7.0.1
 */