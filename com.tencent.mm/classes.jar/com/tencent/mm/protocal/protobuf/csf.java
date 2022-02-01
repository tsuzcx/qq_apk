package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csf
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String EdG;
  public int FEG;
  public String FEH;
  public String Fbk;
  public String lLR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123643);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EdG != null) {
        paramVarArgs.d(1, this.EdG);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      paramVarArgs.aR(3, this.FEG);
      if (this.lLR != null) {
        paramVarArgs.d(4, this.lLR);
      }
      if (this.Fbk != null) {
        paramVarArgs.d(5, this.Fbk);
      }
      if (this.FEH != null) {
        paramVarArgs.d(6, this.FEH);
      }
      AppMethodBeat.o(123643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EdG == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.EdG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Desc);
      }
      i += f.a.a.b.b.a.bx(3, this.FEG);
      paramInt = i;
      if (this.lLR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.lLR);
      }
      i = paramInt;
      if (this.Fbk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fbk);
      }
      paramInt = i;
      if (this.FEH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FEH);
      }
      AppMethodBeat.o(123643);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123643);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csf localcsf = (csf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123643);
          return -1;
        case 1: 
          localcsf.EdG = locala.LVo.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 2: 
          localcsf.Desc = locala.LVo.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 3: 
          localcsf.FEG = locala.LVo.xF();
          AppMethodBeat.o(123643);
          return 0;
        case 4: 
          localcsf.lLR = locala.LVo.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 5: 
          localcsf.Fbk = locala.LVo.readString();
          AppMethodBeat.o(123643);
          return 0;
        }
        localcsf.FEH = locala.LVo.readString();
        AppMethodBeat.o(123643);
        return 0;
      }
      AppMethodBeat.o(123643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csf
 * JD-Core Version:    0.7.0.1
 */