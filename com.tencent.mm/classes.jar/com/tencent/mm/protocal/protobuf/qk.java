package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qk
  extends com.tencent.mm.bw.a
{
  public String DWC;
  public String EhG;
  public int EhH;
  public String EhI;
  public String abi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EhG != null) {
        paramVarArgs.d(1, this.EhG);
      }
      paramVarArgs.aR(2, this.EhH);
      if (this.abi != null) {
        paramVarArgs.d(3, this.abi);
      }
      if (this.DWC != null) {
        paramVarArgs.d(4, this.DWC);
      }
      if (this.EhI != null) {
        paramVarArgs.d(5, this.EhI);
      }
      AppMethodBeat.o(116466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EhG == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.EhG) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EhH);
      paramInt = i;
      if (this.abi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.abi);
      }
      i = paramInt;
      if (this.DWC != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DWC);
      }
      paramInt = i;
      if (this.EhI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EhI);
      }
      AppMethodBeat.o(116466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116466);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        qk localqk = (qk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116466);
          return -1;
        case 1: 
          localqk.EhG = locala.LVo.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 2: 
          localqk.EhH = locala.LVo.xF();
          AppMethodBeat.o(116466);
          return 0;
        case 3: 
          localqk.abi = locala.LVo.readString();
          AppMethodBeat.o(116466);
          return 0;
        case 4: 
          localqk.DWC = locala.LVo.readString();
          AppMethodBeat.o(116466);
          return 0;
        }
        localqk.EhI = locala.LVo.readString();
        AppMethodBeat.o(116466);
        return 0;
      }
      AppMethodBeat.o(116466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qk
 * JD-Core Version:    0.7.0.1
 */