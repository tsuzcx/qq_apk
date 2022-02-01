package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class iv
  extends com.tencent.mm.bx.a
{
  public String FBN;
  public String FBO;
  public String FBP;
  public String FBQ;
  public String FBR;
  public String ozD;
  public String pkr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124392);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FBN != null) {
        paramVarArgs.d(1, this.FBN);
      }
      if (this.FBO != null) {
        paramVarArgs.d(2, this.FBO);
      }
      if (this.FBP != null) {
        paramVarArgs.d(3, this.FBP);
      }
      if (this.pkr != null) {
        paramVarArgs.d(4, this.pkr);
      }
      if (this.ozD != null) {
        paramVarArgs.d(5, this.ozD);
      }
      if (this.FBQ != null) {
        paramVarArgs.d(6, this.FBQ);
      }
      if (this.FBR != null) {
        paramVarArgs.d(7, this.FBR);
      }
      AppMethodBeat.o(124392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FBN == null) {
        break label578;
      }
    }
    label578:
    for (int i = f.a.a.b.b.a.e(1, this.FBN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FBO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FBO);
      }
      i = paramInt;
      if (this.FBP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FBP);
      }
      paramInt = i;
      if (this.pkr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pkr);
      }
      i = paramInt;
      if (this.ozD != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ozD);
      }
      paramInt = i;
      if (this.FBQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FBQ);
      }
      i = paramInt;
      if (this.FBR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FBR);
      }
      AppMethodBeat.o(124392);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124392);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        iv localiv = (iv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124392);
          return -1;
        case 1: 
          localiv.FBN = locala.NPN.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 2: 
          localiv.FBO = locala.NPN.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 3: 
          localiv.FBP = locala.NPN.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 4: 
          localiv.pkr = locala.NPN.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 5: 
          localiv.ozD = locala.NPN.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 6: 
          localiv.FBQ = locala.NPN.readString();
          AppMethodBeat.o(124392);
          return 0;
        }
        localiv.FBR = locala.NPN.readString();
        AppMethodBeat.o(124392);
        return 0;
      }
      AppMethodBeat.o(124392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iv
 * JD-Core Version:    0.7.0.1
 */