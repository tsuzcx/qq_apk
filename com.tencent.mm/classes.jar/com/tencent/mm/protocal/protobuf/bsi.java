package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsi
  extends com.tencent.mm.bw.a
{
  public int Eae;
  public int FbR;
  public int Fhl;
  public int Fhm;
  public String Fhn;
  public int Fho;
  public int Scene;
  public String djj;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147770);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aR(3, this.FbR);
      paramVarArgs.aR(4, this.Eae);
      paramVarArgs.aR(5, this.Scene);
      paramVarArgs.aR(6, this.Fhl);
      paramVarArgs.aR(7, this.Fhm);
      if (this.Fhn != null) {
        paramVarArgs.d(8, this.Fhn);
      }
      paramVarArgs.aR(9, this.Fho);
      AppMethodBeat.o(147770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.djj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i = i + f.a.a.b.b.a.bx(3, this.FbR) + f.a.a.b.b.a.bx(4, this.Eae) + f.a.a.b.b.a.bx(5, this.Scene) + f.a.a.b.b.a.bx(6, this.Fhl) + f.a.a.b.b.a.bx(7, this.Fhm);
      paramInt = i;
      if (this.Fhn != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Fhn);
      }
      i = f.a.a.b.b.a.bx(9, this.Fho);
      AppMethodBeat.o(147770);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147770);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsi localbsi = (bsi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147770);
          return -1;
        case 1: 
          localbsi.djj = locala.LVo.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 2: 
          localbsi.username = locala.LVo.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 3: 
          localbsi.FbR = locala.LVo.xF();
          AppMethodBeat.o(147770);
          return 0;
        case 4: 
          localbsi.Eae = locala.LVo.xF();
          AppMethodBeat.o(147770);
          return 0;
        case 5: 
          localbsi.Scene = locala.LVo.xF();
          AppMethodBeat.o(147770);
          return 0;
        case 6: 
          localbsi.Fhl = locala.LVo.xF();
          AppMethodBeat.o(147770);
          return 0;
        case 7: 
          localbsi.Fhm = locala.LVo.xF();
          AppMethodBeat.o(147770);
          return 0;
        case 8: 
          localbsi.Fhn = locala.LVo.readString();
          AppMethodBeat.o(147770);
          return 0;
        }
        localbsi.Fho = locala.LVo.xF();
        AppMethodBeat.o(147770);
        return 0;
      }
      AppMethodBeat.o(147770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsi
 * JD-Core Version:    0.7.0.1
 */