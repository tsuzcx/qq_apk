package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aw
  extends com.tencent.mm.bw.a
{
  public int DNa;
  public String DNb;
  public String DNc;
  public int DNd;
  public int DNe;
  public String DNf;
  public int DNg;
  public String DNh;
  public String DNi;
  public int DNj;
  public String DNk;
  public String iJY;
  public String ncR;
  public String ndW;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133142);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      paramVarArgs.aR(3, this.DNa);
      if (this.DNb != null) {
        paramVarArgs.d(4, this.DNb);
      }
      if (this.DNc != null) {
        paramVarArgs.d(5, this.DNc);
      }
      if (this.iJY != null) {
        paramVarArgs.d(6, this.iJY);
      }
      paramVarArgs.aR(8, this.ndj);
      paramVarArgs.aR(9, this.DNd);
      paramVarArgs.aR(10, this.DNe);
      if (this.DNf != null) {
        paramVarArgs.d(11, this.DNf);
      }
      paramVarArgs.aR(12, this.DNg);
      if (this.DNh != null) {
        paramVarArgs.d(13, this.DNh);
      }
      if (this.DNi != null) {
        paramVarArgs.d(14, this.DNi);
      }
      paramVarArgs.aR(15, this.DNj);
      if (this.DNk != null) {
        paramVarArgs.d(16, this.DNk);
      }
      AppMethodBeat.o(133142);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label978;
      }
    }
    label978:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ndW);
      }
      i += f.a.a.b.b.a.bx(3, this.DNa);
      paramInt = i;
      if (this.DNb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DNb);
      }
      i = paramInt;
      if (this.DNc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DNc);
      }
      paramInt = i;
      if (this.iJY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iJY);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.ndj) + f.a.a.b.b.a.bx(9, this.DNd) + f.a.a.b.b.a.bx(10, this.DNe);
      paramInt = i;
      if (this.DNf != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DNf);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.DNg);
      paramInt = i;
      if (this.DNh != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.DNh);
      }
      i = paramInt;
      if (this.DNi != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.DNi);
      }
      i += f.a.a.b.b.a.bx(15, this.DNj);
      paramInt = i;
      if (this.DNk != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DNk);
      }
      AppMethodBeat.o(133142);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(133142);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(133142);
          return -1;
        case 1: 
          localaw.ncR = locala.LVo.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 2: 
          localaw.ndW = locala.LVo.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 3: 
          localaw.DNa = locala.LVo.xF();
          AppMethodBeat.o(133142);
          return 0;
        case 4: 
          localaw.DNb = locala.LVo.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 5: 
          localaw.DNc = locala.LVo.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 6: 
          localaw.iJY = locala.LVo.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 8: 
          localaw.ndj = locala.LVo.xF();
          AppMethodBeat.o(133142);
          return 0;
        case 9: 
          localaw.DNd = locala.LVo.xF();
          AppMethodBeat.o(133142);
          return 0;
        case 10: 
          localaw.DNe = locala.LVo.xF();
          AppMethodBeat.o(133142);
          return 0;
        case 11: 
          localaw.DNf = locala.LVo.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 12: 
          localaw.DNg = locala.LVo.xF();
          AppMethodBeat.o(133142);
          return 0;
        case 13: 
          localaw.DNh = locala.LVo.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 14: 
          localaw.DNi = locala.LVo.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 15: 
          localaw.DNj = locala.LVo.xF();
          AppMethodBeat.o(133142);
          return 0;
        }
        localaw.DNk = locala.LVo.readString();
        AppMethodBeat.o(133142);
        return 0;
      }
      AppMethodBeat.o(133142);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aw
 * JD-Core Version:    0.7.0.1
 */