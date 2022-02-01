package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class din
  extends com.tencent.mm.bw.a
{
  public String HPF;
  public String HPG;
  public String HPH;
  public String HPI;
  public String HPJ;
  public String HPK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(197205);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HPF != null) {
        paramVarArgs.d(1, this.HPF);
      }
      if (this.HPG != null) {
        paramVarArgs.d(2, this.HPG);
      }
      if (this.HPH != null) {
        paramVarArgs.d(3, this.HPH);
      }
      if (this.HPI != null) {
        paramVarArgs.d(4, this.HPI);
      }
      if (this.HPJ != null) {
        paramVarArgs.d(5, this.HPJ);
      }
      if (this.HPK != null) {
        paramVarArgs.d(6, this.HPK);
      }
      AppMethodBeat.o(197205);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HPF == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.HPF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HPG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HPG);
      }
      i = paramInt;
      if (this.HPH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HPH);
      }
      paramInt = i;
      if (this.HPI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HPI);
      }
      i = paramInt;
      if (this.HPJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HPJ);
      }
      paramInt = i;
      if (this.HPK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HPK);
      }
      AppMethodBeat.o(197205);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(197205);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        din localdin = (din)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(197205);
          return -1;
        case 1: 
          localdin.HPF = locala.OmT.readString();
          AppMethodBeat.o(197205);
          return 0;
        case 2: 
          localdin.HPG = locala.OmT.readString();
          AppMethodBeat.o(197205);
          return 0;
        case 3: 
          localdin.HPH = locala.OmT.readString();
          AppMethodBeat.o(197205);
          return 0;
        case 4: 
          localdin.HPI = locala.OmT.readString();
          AppMethodBeat.o(197205);
          return 0;
        case 5: 
          localdin.HPJ = locala.OmT.readString();
          AppMethodBeat.o(197205);
          return 0;
        }
        localdin.HPK = locala.OmT.readString();
        AppMethodBeat.o(197205);
        return 0;
      }
      AppMethodBeat.o(197205);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.din
 * JD-Core Version:    0.7.0.1
 */