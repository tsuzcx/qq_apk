package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dgd
  extends com.tencent.mm.bw.a
{
  public String GNO;
  public String HNu;
  public int HNv;
  public int HNw;
  public int HhE;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125773);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HNu != null) {
        paramVarArgs.d(1, this.HNu);
      }
      paramVarArgs.aS(2, this.HNv);
      if (this.nIJ != null) {
        paramVarArgs.d(3, this.nIJ);
      }
      if (this.GNO != null) {
        paramVarArgs.d(4, this.GNO);
      }
      paramVarArgs.aS(5, this.HhE);
      paramVarArgs.aS(6, this.HNw);
      AppMethodBeat.o(125773);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HNu == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.e(1, this.HNu) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HNv);
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nIJ);
      }
      i = paramInt;
      if (this.GNO != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GNO);
      }
      paramInt = f.a.a.b.b.a.bz(5, this.HhE);
      int j = f.a.a.b.b.a.bz(6, this.HNw);
      AppMethodBeat.o(125773);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125773);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dgd localdgd = (dgd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125773);
          return -1;
        case 1: 
          localdgd.HNu = locala.OmT.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 2: 
          localdgd.HNv = locala.OmT.zc();
          AppMethodBeat.o(125773);
          return 0;
        case 3: 
          localdgd.nIJ = locala.OmT.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 4: 
          localdgd.GNO = locala.OmT.readString();
          AppMethodBeat.o(125773);
          return 0;
        case 5: 
          localdgd.HhE = locala.OmT.zc();
          AppMethodBeat.o(125773);
          return 0;
        }
        localdgd.HNw = locala.OmT.zc();
        AppMethodBeat.o(125773);
        return 0;
      }
      AppMethodBeat.o(125773);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgd
 * JD-Core Version:    0.7.0.1
 */