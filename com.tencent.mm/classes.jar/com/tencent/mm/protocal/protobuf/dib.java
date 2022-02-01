package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dib
  extends com.tencent.mm.bw.a
{
  public int Category;
  public long FRa;
  public int FRb;
  public int FzB;
  public LinkedList<String> FzD;
  public String hkR;
  
  public dib()
  {
    AppMethodBeat.i(152998);
    this.FzD = new LinkedList();
    AppMethodBeat.o(152998);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152999);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hkR != null) {
        paramVarArgs.d(1, this.hkR);
      }
      paramVarArgs.aO(2, this.FRa);
      paramVarArgs.aR(3, this.FzB);
      paramVarArgs.aR(4, this.FRb);
      paramVarArgs.aR(5, this.Category);
      paramVarArgs.e(6, 1, this.FzD);
      AppMethodBeat.o(152999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hkR == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.b.b.a.e(1, this.hkR) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.FRa);
      int j = f.a.a.b.b.a.bx(3, this.FzB);
      int k = f.a.a.b.b.a.bx(4, this.FRb);
      int m = f.a.a.b.b.a.bx(5, this.Category);
      int n = f.a.a.a.c(6, 1, this.FzD);
      AppMethodBeat.o(152999);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FzD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152999);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dib localdib = (dib)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152999);
          return -1;
        case 1: 
          localdib.hkR = locala.LVo.readString();
          AppMethodBeat.o(152999);
          return 0;
        case 2: 
          localdib.FRa = locala.LVo.xG();
          AppMethodBeat.o(152999);
          return 0;
        case 3: 
          localdib.FzB = locala.LVo.xF();
          AppMethodBeat.o(152999);
          return 0;
        case 4: 
          localdib.FRb = locala.LVo.xF();
          AppMethodBeat.o(152999);
          return 0;
        case 5: 
          localdib.Category = locala.LVo.xF();
          AppMethodBeat.o(152999);
          return 0;
        }
        localdib.FzD.add(locala.LVo.readString());
        AppMethodBeat.o(152999);
        return 0;
      }
      AppMethodBeat.o(152999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dib
 * JD-Core Version:    0.7.0.1
 */