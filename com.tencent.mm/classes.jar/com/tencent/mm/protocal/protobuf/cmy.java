package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmy
  extends com.tencent.mm.bx.a
{
  public String CLe;
  public String DFQ;
  public String Desc;
  public int EhH;
  public String EhI;
  public String lmb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123643);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CLe != null) {
        paramVarArgs.d(1, this.CLe);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      paramVarArgs.aR(3, this.EhH);
      if (this.lmb != null) {
        paramVarArgs.d(4, this.lmb);
      }
      if (this.DFQ != null) {
        paramVarArgs.d(5, this.DFQ);
      }
      if (this.EhI != null) {
        paramVarArgs.d(6, this.EhI);
      }
      AppMethodBeat.o(123643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLe == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.CLe) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Desc);
      }
      i += f.a.a.b.b.a.bA(3, this.EhH);
      paramInt = i;
      if (this.lmb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.lmb);
      }
      i = paramInt;
      if (this.DFQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DFQ);
      }
      paramInt = i;
      if (this.EhI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EhI);
      }
      AppMethodBeat.o(123643);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123643);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cmy localcmy = (cmy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123643);
          return -1;
        case 1: 
          localcmy.CLe = locala.KhF.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 2: 
          localcmy.Desc = locala.KhF.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 3: 
          localcmy.EhH = locala.KhF.xS();
          AppMethodBeat.o(123643);
          return 0;
        case 4: 
          localcmy.lmb = locala.KhF.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 5: 
          localcmy.DFQ = locala.KhF.readString();
          AppMethodBeat.o(123643);
          return 0;
        }
        localcmy.EhI = locala.KhF.readString();
        AppMethodBeat.o(123643);
        return 0;
      }
      AppMethodBeat.o(123643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmy
 * JD-Core Version:    0.7.0.1
 */