package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cts
  extends com.tencent.mm.bx.a
{
  public int HlO;
  public int HlP;
  public String gsM;
  public String gsN;
  public String gsO;
  public String gsP;
  public String nDT;
  public String orl;
  public int yVu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123640);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDT != null) {
        paramVarArgs.d(1, this.nDT);
      }
      paramVarArgs.aS(2, this.HlO);
      if (this.gsM != null) {
        paramVarArgs.d(3, this.gsM);
      }
      if (this.gsN != null) {
        paramVarArgs.d(4, this.gsN);
      }
      paramVarArgs.aS(5, this.yVu);
      paramVarArgs.aS(6, this.HlP);
      if (this.gsO != null) {
        paramVarArgs.d(7, this.gsO);
      }
      if (this.gsP != null) {
        paramVarArgs.d(8, this.gsP);
      }
      if (this.orl != null) {
        paramVarArgs.d(9, this.orl);
      }
      AppMethodBeat.o(123640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDT == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDT) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HlO);
      paramInt = i;
      if (this.gsM != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.gsM);
      }
      i = paramInt;
      if (this.gsN != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.gsN);
      }
      i = i + f.a.a.b.b.a.bz(5, this.yVu) + f.a.a.b.b.a.bz(6, this.HlP);
      paramInt = i;
      if (this.gsO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.gsO);
      }
      i = paramInt;
      if (this.gsP != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.gsP);
      }
      paramInt = i;
      if (this.orl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.orl);
      }
      AppMethodBeat.o(123640);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123640);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cts localcts = (cts)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123640);
          return -1;
        case 1: 
          localcts.nDT = locala.NPN.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 2: 
          localcts.HlO = locala.NPN.zc();
          AppMethodBeat.o(123640);
          return 0;
        case 3: 
          localcts.gsM = locala.NPN.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 4: 
          localcts.gsN = locala.NPN.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 5: 
          localcts.yVu = locala.NPN.zc();
          AppMethodBeat.o(123640);
          return 0;
        case 6: 
          localcts.HlP = locala.NPN.zc();
          AppMethodBeat.o(123640);
          return 0;
        case 7: 
          localcts.gsO = locala.NPN.readString();
          AppMethodBeat.o(123640);
          return 0;
        case 8: 
          localcts.gsP = locala.NPN.readString();
          AppMethodBeat.o(123640);
          return 0;
        }
        localcts.orl = locala.NPN.readString();
        AppMethodBeat.o(123640);
        return 0;
      }
      AppMethodBeat.o(123640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cts
 * JD-Core Version:    0.7.0.1
 */