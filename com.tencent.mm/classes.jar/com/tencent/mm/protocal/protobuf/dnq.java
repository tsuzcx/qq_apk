package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnq
  extends com.tencent.mm.bx.a
{
  public int Category;
  public long HBG;
  public int HBH;
  public int HjJ;
  public LinkedList<String> HjL;
  public String hDa;
  
  public dnq()
  {
    AppMethodBeat.i(152998);
    this.HjL = new LinkedList();
    AppMethodBeat.o(152998);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152999);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hDa != null) {
        paramVarArgs.d(1, this.hDa);
      }
      paramVarArgs.aY(2, this.HBG);
      paramVarArgs.aS(3, this.HjJ);
      paramVarArgs.aS(4, this.HBH);
      paramVarArgs.aS(5, this.Category);
      paramVarArgs.e(6, 1, this.HjL);
      AppMethodBeat.o(152999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hDa == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.hDa) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HBG);
      int j = f.a.a.b.b.a.bz(3, this.HjJ);
      int k = f.a.a.b.b.a.bz(4, this.HBH);
      int m = f.a.a.b.b.a.bz(5, this.Category);
      int n = f.a.a.a.c(6, 1, this.HjL);
      AppMethodBeat.o(152999);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HjL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152999);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dnq localdnq = (dnq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152999);
          return -1;
        case 1: 
          localdnq.hDa = locala.NPN.readString();
          AppMethodBeat.o(152999);
          return 0;
        case 2: 
          localdnq.HBG = locala.NPN.zd();
          AppMethodBeat.o(152999);
          return 0;
        case 3: 
          localdnq.HjJ = locala.NPN.zc();
          AppMethodBeat.o(152999);
          return 0;
        case 4: 
          localdnq.HBH = locala.NPN.zc();
          AppMethodBeat.o(152999);
          return 0;
        case 5: 
          localdnq.Category = locala.NPN.zc();
          AppMethodBeat.o(152999);
          return 0;
        }
        localdnq.HjL.add(locala.NPN.readString());
        AppMethodBeat.o(152999);
        return 0;
      }
      AppMethodBeat.o(152999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnq
 * JD-Core Version:    0.7.0.1
 */