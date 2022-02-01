package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bza
  extends com.tencent.mm.bw.a
{
  public String Ecn;
  public int FnS;
  public int FnT;
  public String FnU;
  public int FnV;
  public String hhs;
  public int nTd;
  public int tfK;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ecn != null) {
        paramVarArgs.d(1, this.Ecn);
      }
      paramVarArgs.aR(2, this.FnS);
      paramVarArgs.aR(3, this.tfK);
      paramVarArgs.aR(4, this.FnT);
      paramVarArgs.aR(5, this.nTd);
      paramVarArgs.aR(6, this.type);
      if (this.hhs != null) {
        paramVarArgs.d(7, this.hhs);
      }
      if (this.FnU != null) {
        paramVarArgs.d(8, this.FnU);
      }
      paramVarArgs.aR(9, this.FnV);
      AppMethodBeat.o(6416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ecn == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ecn) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FnS) + f.a.a.b.b.a.bx(3, this.tfK) + f.a.a.b.b.a.bx(4, this.FnT) + f.a.a.b.b.a.bx(5, this.nTd) + f.a.a.b.b.a.bx(6, this.type);
      paramInt = i;
      if (this.hhs != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hhs);
      }
      i = paramInt;
      if (this.FnU != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FnU);
      }
      paramInt = f.a.a.b.b.a.bx(9, this.FnV);
      AppMethodBeat.o(6416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(6416);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bza localbza = (bza)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(6416);
          return -1;
        case 1: 
          localbza.Ecn = locala.LVo.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 2: 
          localbza.FnS = locala.LVo.xF();
          AppMethodBeat.o(6416);
          return 0;
        case 3: 
          localbza.tfK = locala.LVo.xF();
          AppMethodBeat.o(6416);
          return 0;
        case 4: 
          localbza.FnT = locala.LVo.xF();
          AppMethodBeat.o(6416);
          return 0;
        case 5: 
          localbza.nTd = locala.LVo.xF();
          AppMethodBeat.o(6416);
          return 0;
        case 6: 
          localbza.type = locala.LVo.xF();
          AppMethodBeat.o(6416);
          return 0;
        case 7: 
          localbza.hhs = locala.LVo.readString();
          AppMethodBeat.o(6416);
          return 0;
        case 8: 
          localbza.FnU = locala.LVo.readString();
          AppMethodBeat.o(6416);
          return 0;
        }
        localbza.FnV = locala.LVo.xF();
        AppMethodBeat.o(6416);
        return 0;
      }
      AppMethodBeat.o(6416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bza
 * JD-Core Version:    0.7.0.1
 */