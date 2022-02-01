package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dh
  extends com.tencent.mm.bw.a
{
  public String DQm;
  public String DQn;
  public String iJU;
  public String iJV;
  public String iKc;
  public String ncR;
  public String tiv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91348);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iKc != null) {
        paramVarArgs.d(1, this.iKc);
      }
      if (this.iJU != null) {
        paramVarArgs.d(2, this.iJU);
      }
      if (this.iJV != null) {
        paramVarArgs.d(3, this.iJV);
      }
      if (this.tiv != null) {
        paramVarArgs.d(4, this.tiv);
      }
      if (this.ncR != null) {
        paramVarArgs.d(5, this.ncR);
      }
      if (this.DQm != null) {
        paramVarArgs.d(6, this.DQm);
      }
      if (this.DQn != null) {
        paramVarArgs.d(7, this.DQn);
      }
      AppMethodBeat.o(91348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iKc == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.iKc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iJU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iJU);
      }
      i = paramInt;
      if (this.iJV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iJV);
      }
      paramInt = i;
      if (this.tiv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tiv);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ncR);
      }
      paramInt = i;
      if (this.DQm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DQm);
      }
      i = paramInt;
      if (this.DQn != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DQn);
      }
      AppMethodBeat.o(91348);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91348);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dh localdh = (dh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91348);
          return -1;
        case 1: 
          localdh.iKc = locala.LVo.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 2: 
          localdh.iJU = locala.LVo.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 3: 
          localdh.iJV = locala.LVo.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 4: 
          localdh.tiv = locala.LVo.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 5: 
          localdh.ncR = locala.LVo.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 6: 
          localdh.DQm = locala.LVo.readString();
          AppMethodBeat.o(91348);
          return 0;
        }
        localdh.DQn = locala.LVo.readString();
        AppMethodBeat.o(91348);
        return 0;
      }
      AppMethodBeat.o(91348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dh
 * JD-Core Version:    0.7.0.1
 */