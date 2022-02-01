package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cag
  extends com.tencent.mm.bx.a
{
  public String DWJ;
  public String DWK;
  public String DWL;
  public String DWM;
  public boolean DWN;
  public String DWO;
  public String dca;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72547);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DWJ != null) {
        paramVarArgs.d(1, this.DWJ);
      }
      if (this.DWK != null) {
        paramVarArgs.d(2, this.DWK);
      }
      if (this.dca != null) {
        paramVarArgs.d(3, this.dca);
      }
      if (this.DWL != null) {
        paramVarArgs.d(4, this.DWL);
      }
      if (this.DWM != null) {
        paramVarArgs.d(5, this.DWM);
      }
      paramVarArgs.bg(6, this.DWN);
      if (this.DWO != null) {
        paramVarArgs.d(7, this.DWO);
      }
      AppMethodBeat.o(72547);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWJ == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.DWJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DWK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DWK);
      }
      i = paramInt;
      if (this.dca != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dca);
      }
      paramInt = i;
      if (this.DWL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DWL);
      }
      i = paramInt;
      if (this.DWM != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DWM);
      }
      i += f.a.a.b.b.a.fY(6) + 1;
      paramInt = i;
      if (this.DWO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DWO);
      }
      AppMethodBeat.o(72547);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72547);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cag localcag = (cag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72547);
          return -1;
        case 1: 
          localcag.DWJ = locala.KhF.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 2: 
          localcag.DWK = locala.KhF.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 3: 
          localcag.dca = locala.KhF.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 4: 
          localcag.DWL = locala.KhF.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 5: 
          localcag.DWM = locala.KhF.readString();
          AppMethodBeat.o(72547);
          return 0;
        case 6: 
          localcag.DWN = locala.KhF.fHu();
          AppMethodBeat.o(72547);
          return 0;
        }
        localcag.DWO = locala.KhF.readString();
        AppMethodBeat.o(72547);
        return 0;
      }
      AppMethodBeat.o(72547);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cag
 * JD-Core Version:    0.7.0.1
 */