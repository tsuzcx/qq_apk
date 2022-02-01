package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amm
  extends com.tencent.mm.bw.a
{
  public String EFH;
  public String EFI;
  public String EFJ;
  public String EFK;
  public int EFL;
  public String EFM;
  public String EFN;
  public String appName;
  public String iTS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169017);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFH != null) {
        paramVarArgs.d(1, this.EFH);
      }
      if (this.EFI != null) {
        paramVarArgs.d(2, this.EFI);
      }
      if (this.EFJ != null) {
        paramVarArgs.d(3, this.EFJ);
      }
      if (this.appName != null) {
        paramVarArgs.d(4, this.appName);
      }
      if (this.EFK != null) {
        paramVarArgs.d(5, this.EFK);
      }
      if (this.iTS != null) {
        paramVarArgs.d(6, this.iTS);
      }
      paramVarArgs.aR(7, this.EFL);
      if (this.EFM != null) {
        paramVarArgs.d(8, this.EFM);
      }
      if (this.EFN != null) {
        paramVarArgs.d(9, this.EFN);
      }
      AppMethodBeat.o(169017);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFH == null) {
        break label686;
      }
    }
    label686:
    for (int i = f.a.a.b.b.a.e(1, this.EFH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EFI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EFI);
      }
      i = paramInt;
      if (this.EFJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EFJ);
      }
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.appName);
      }
      i = paramInt;
      if (this.EFK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EFK);
      }
      paramInt = i;
      if (this.iTS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.iTS);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.EFL);
      paramInt = i;
      if (this.EFM != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EFM);
      }
      i = paramInt;
      if (this.EFN != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EFN);
      }
      AppMethodBeat.o(169017);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169017);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        amm localamm = (amm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169017);
          return -1;
        case 1: 
          localamm.EFH = locala.LVo.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 2: 
          localamm.EFI = locala.LVo.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 3: 
          localamm.EFJ = locala.LVo.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 4: 
          localamm.appName = locala.LVo.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 5: 
          localamm.EFK = locala.LVo.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 6: 
          localamm.iTS = locala.LVo.readString();
          AppMethodBeat.o(169017);
          return 0;
        case 7: 
          localamm.EFL = locala.LVo.xF();
          AppMethodBeat.o(169017);
          return 0;
        case 8: 
          localamm.EFM = locala.LVo.readString();
          AppMethodBeat.o(169017);
          return 0;
        }
        localamm.EFN = locala.LVo.readString();
        AppMethodBeat.o(169017);
        return 0;
      }
      AppMethodBeat.o(169017);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amm
 * JD-Core Version:    0.7.0.1
 */