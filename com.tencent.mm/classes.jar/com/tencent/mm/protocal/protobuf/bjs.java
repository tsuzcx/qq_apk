package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bjs
  extends com.tencent.mm.bx.a
{
  public String DHP;
  public String DHQ;
  public String DHR;
  public String DHS;
  public String kXu;
  public int uaQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108147);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uaQ);
      if (this.kXu != null) {
        paramVarArgs.d(2, this.kXu);
      }
      if (this.DHP != null) {
        paramVarArgs.d(3, this.DHP);
      }
      if (this.DHQ != null) {
        paramVarArgs.d(4, this.DHQ);
      }
      if (this.DHR != null) {
        paramVarArgs.d(5, this.DHR);
      }
      if (this.DHS != null) {
        paramVarArgs.d(6, this.DHS);
      }
      AppMethodBeat.o(108147);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.uaQ) + 0;
      paramInt = i;
      if (this.kXu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.kXu);
      }
      i = paramInt;
      if (this.DHP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DHP);
      }
      paramInt = i;
      if (this.DHQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DHQ);
      }
      i = paramInt;
      if (this.DHR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DHR);
      }
      paramInt = i;
      if (this.DHS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DHS);
      }
      AppMethodBeat.o(108147);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(108147);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bjs localbjs = (bjs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(108147);
        return -1;
      case 1: 
        localbjs.uaQ = locala.KhF.xS();
        AppMethodBeat.o(108147);
        return 0;
      case 2: 
        localbjs.kXu = locala.KhF.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 3: 
        localbjs.DHP = locala.KhF.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 4: 
        localbjs.DHQ = locala.KhF.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 5: 
        localbjs.DHR = locala.KhF.readString();
        AppMethodBeat.o(108147);
        return 0;
      }
      localbjs.DHS = locala.KhF.readString();
      AppMethodBeat.o(108147);
      return 0;
    }
    AppMethodBeat.o(108147);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjs
 * JD-Core Version:    0.7.0.1
 */