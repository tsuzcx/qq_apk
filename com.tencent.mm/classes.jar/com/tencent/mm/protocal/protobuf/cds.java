package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cds
  extends com.tencent.mm.bw.a
{
  public int DWT;
  public String Fsr;
  public b Fss;
  public b Fst;
  public b Fsu;
  public String Fsv;
  public int ndj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91577);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fsr != null) {
        paramVarArgs.d(1, this.Fsr);
      }
      paramVarArgs.aR(2, this.ndj);
      if (this.Fss != null) {
        paramVarArgs.c(3, this.Fss);
      }
      if (this.Fst != null) {
        paramVarArgs.c(4, this.Fst);
      }
      if (this.Fsu != null) {
        paramVarArgs.c(5, this.Fsu);
      }
      paramVarArgs.aR(6, this.DWT);
      if (this.Fsv != null) {
        paramVarArgs.d(7, this.Fsv);
      }
      AppMethodBeat.o(91577);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fsr == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fsr) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndj);
      paramInt = i;
      if (this.Fss != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Fss);
      }
      i = paramInt;
      if (this.Fst != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Fst);
      }
      paramInt = i;
      if (this.Fsu != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Fsu);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.DWT);
      paramInt = i;
      if (this.Fsv != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Fsv);
      }
      AppMethodBeat.o(91577);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91577);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cds localcds = (cds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91577);
          return -1;
        case 1: 
          localcds.Fsr = locala.LVo.readString();
          AppMethodBeat.o(91577);
          return 0;
        case 2: 
          localcds.ndj = locala.LVo.xF();
          AppMethodBeat.o(91577);
          return 0;
        case 3: 
          localcds.Fss = locala.LVo.gfk();
          AppMethodBeat.o(91577);
          return 0;
        case 4: 
          localcds.Fst = locala.LVo.gfk();
          AppMethodBeat.o(91577);
          return 0;
        case 5: 
          localcds.Fsu = locala.LVo.gfk();
          AppMethodBeat.o(91577);
          return 0;
        case 6: 
          localcds.DWT = locala.LVo.xF();
          AppMethodBeat.o(91577);
          return 0;
        }
        localcds.Fsv = locala.LVo.readString();
        AppMethodBeat.o(91577);
        return 0;
      }
      AppMethodBeat.o(91577);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cds
 * JD-Core Version:    0.7.0.1
 */