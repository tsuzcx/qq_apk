package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtp
  extends com.tencent.mm.bw.a
{
  public float DPc;
  public String EsS;
  public String GbE;
  public String GbF;
  public String GbG;
  public int GbH;
  public float GbI;
  public String GbJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147791);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbE != null) {
        paramVarArgs.d(1, this.GbE);
      }
      if (this.EsS != null) {
        paramVarArgs.d(2, this.EsS);
      }
      if (this.GbF != null) {
        paramVarArgs.d(3, this.GbF);
      }
      if (this.GbG != null) {
        paramVarArgs.d(4, this.GbG);
      }
      paramVarArgs.aR(5, this.GbH);
      paramVarArgs.x(6, this.DPc);
      paramVarArgs.x(7, this.GbI);
      if (this.GbJ != null) {
        paramVarArgs.d(8, this.GbJ);
      }
      AppMethodBeat.o(147791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GbE == null) {
        break label592;
      }
    }
    label592:
    for (int i = f.a.a.b.b.a.e(1, this.GbE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EsS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EsS);
      }
      i = paramInt;
      if (this.GbF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GbF);
      }
      paramInt = i;
      if (this.GbG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GbG);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.GbH) + (f.a.a.b.b.a.fK(6) + 4) + (f.a.a.b.b.a.fK(7) + 4);
      paramInt = i;
      if (this.GbJ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GbJ);
      }
      AppMethodBeat.o(147791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147791);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtp localdtp = (dtp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147791);
          return -1;
        case 1: 
          localdtp.GbE = locala.LVo.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 2: 
          localdtp.EsS = locala.LVo.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 3: 
          localdtp.GbF = locala.LVo.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 4: 
          localdtp.GbG = locala.LVo.readString();
          AppMethodBeat.o(147791);
          return 0;
        case 5: 
          localdtp.GbH = locala.LVo.xF();
          AppMethodBeat.o(147791);
          return 0;
        case 6: 
          localdtp.DPc = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(147791);
          return 0;
        case 7: 
          localdtp.GbI = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(147791);
          return 0;
        }
        localdtp.GbJ = locala.LVo.readString();
        AppMethodBeat.o(147791);
        return 0;
      }
      AppMethodBeat.o(147791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtp
 * JD-Core Version:    0.7.0.1
 */