package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class df
  extends com.tencent.mm.bx.a
{
  public String CxQ;
  public String CxR;
  public String ijN;
  public String ijO;
  public String ijV;
  public String mAQ;
  public String saB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91348);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ijV != null) {
        paramVarArgs.d(1, this.ijV);
      }
      if (this.ijN != null) {
        paramVarArgs.d(2, this.ijN);
      }
      if (this.ijO != null) {
        paramVarArgs.d(3, this.ijO);
      }
      if (this.saB != null) {
        paramVarArgs.d(4, this.saB);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(5, this.mAQ);
      }
      if (this.CxQ != null) {
        paramVarArgs.d(6, this.CxQ);
      }
      if (this.CxR != null) {
        paramVarArgs.d(7, this.CxR);
      }
      AppMethodBeat.o(91348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ijV == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.ijV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ijN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ijN);
      }
      i = paramInt;
      if (this.ijO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ijO);
      }
      paramInt = i;
      if (this.saB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.saB);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.mAQ);
      }
      paramInt = i;
      if (this.CxQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CxQ);
      }
      i = paramInt;
      if (this.CxR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CxR);
      }
      AppMethodBeat.o(91348);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91348);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        df localdf = (df)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91348);
          return -1;
        case 1: 
          localdf.ijV = locala.KhF.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 2: 
          localdf.ijN = locala.KhF.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 3: 
          localdf.ijO = locala.KhF.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 4: 
          localdf.saB = locala.KhF.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 5: 
          localdf.mAQ = locala.KhF.readString();
          AppMethodBeat.o(91348);
          return 0;
        case 6: 
          localdf.CxQ = locala.KhF.readString();
          AppMethodBeat.o(91348);
          return 0;
        }
        localdf.CxR = locala.KhF.readString();
        AppMethodBeat.o(91348);
        return 0;
      }
      AppMethodBeat.o(91348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.df
 * JD-Core Version:    0.7.0.1
 */