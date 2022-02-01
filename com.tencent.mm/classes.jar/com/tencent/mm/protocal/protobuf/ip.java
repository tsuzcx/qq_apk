package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ip
  extends com.tencent.mm.bw.a
{
  public String FTJ;
  public String FTL;
  public boolean FTV;
  public String FTW;
  public String dlT;
  public String uVs;
  public String yhW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19405);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uVs != null) {
        paramVarArgs.d(1, this.uVs);
      }
      if (this.yhW != null) {
        paramVarArgs.d(2, this.yhW);
      }
      if (this.dlT != null) {
        paramVarArgs.d(3, this.dlT);
      }
      paramVarArgs.bC(4, this.FTV);
      if (this.FTL != null) {
        paramVarArgs.d(5, this.FTL);
      }
      if (this.FTJ != null) {
        paramVarArgs.d(6, this.FTJ);
      }
      if (this.FTW != null) {
        paramVarArgs.d(7, this.FTW);
      }
      AppMethodBeat.o(19405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uVs == null) {
        break label571;
      }
    }
    label571:
    for (int i = f.a.a.b.b.a.e(1, this.uVs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yhW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.yhW);
      }
      i = paramInt;
      if (this.dlT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlT);
      }
      i += f.a.a.b.b.a.amF(4);
      paramInt = i;
      if (this.FTL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FTL);
      }
      i = paramInt;
      if (this.FTJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FTJ);
      }
      paramInt = i;
      if (this.FTW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FTW);
      }
      AppMethodBeat.o(19405);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(19405);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ip localip = (ip)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(19405);
          return -1;
        case 1: 
          localip.uVs = locala.OmT.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 2: 
          localip.yhW = locala.OmT.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 3: 
          localip.dlT = locala.OmT.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 4: 
          localip.FTV = locala.OmT.gvY();
          AppMethodBeat.o(19405);
          return 0;
        case 5: 
          localip.FTL = locala.OmT.readString();
          AppMethodBeat.o(19405);
          return 0;
        case 6: 
          localip.FTJ = locala.OmT.readString();
          AppMethodBeat.o(19405);
          return 0;
        }
        localip.FTW = locala.OmT.readString();
        AppMethodBeat.o(19405);
        return 0;
      }
      AppMethodBeat.o(19405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ip
 * JD-Core Version:    0.7.0.1
 */