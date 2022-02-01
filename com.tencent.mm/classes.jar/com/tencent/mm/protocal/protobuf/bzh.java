package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzh
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public int GUi;
  public int GUj;
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  public String jdl;
  public String nDo;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32348);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      paramVarArgs.aS(2, this.nEf);
      paramVarArgs.aS(3, this.jdc);
      if (this.jde != null) {
        paramVarArgs.d(4, this.jde);
      }
      if (this.jdd != null) {
        paramVarArgs.d(5, this.jdd);
      }
      if (this.jdf != null) {
        paramVarArgs.d(6, this.jdf);
      }
      paramVarArgs.aS(7, this.GUi);
      paramVarArgs.aS(8, this.GUj);
      if (this.jdl != null) {
        paramVarArgs.d(9, this.jdl);
      }
      if (this.FVo != null) {
        paramVarArgs.d(10, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(11, this.FVp);
      }
      AppMethodBeat.o(32348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = f.a.a.b.b.a.e(1, this.nDo) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEf) + f.a.a.b.b.a.bz(3, this.jdc);
      paramInt = i;
      if (this.jde != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jde);
      }
      i = paramInt;
      if (this.jdd != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jdd);
      }
      paramInt = i;
      if (this.jdf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jdf);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.GUi) + f.a.a.b.b.a.bz(8, this.GUj);
      paramInt = i;
      if (this.jdl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jdl);
      }
      i = paramInt;
      if (this.FVo != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.FVo);
      }
      paramInt = i;
      if (this.FVp != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FVp);
      }
      AppMethodBeat.o(32348);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32348);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bzh localbzh = (bzh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32348);
          return -1;
        case 1: 
          localbzh.nDo = locala.NPN.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 2: 
          localbzh.nEf = locala.NPN.zc();
          AppMethodBeat.o(32348);
          return 0;
        case 3: 
          localbzh.jdc = locala.NPN.zc();
          AppMethodBeat.o(32348);
          return 0;
        case 4: 
          localbzh.jde = locala.NPN.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 5: 
          localbzh.jdd = locala.NPN.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 6: 
          localbzh.jdf = locala.NPN.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 7: 
          localbzh.GUi = locala.NPN.zc();
          AppMethodBeat.o(32348);
          return 0;
        case 8: 
          localbzh.GUj = locala.NPN.zc();
          AppMethodBeat.o(32348);
          return 0;
        case 9: 
          localbzh.jdl = locala.NPN.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 10: 
          localbzh.FVo = locala.NPN.readString();
          AppMethodBeat.o(32348);
          return 0;
        }
        localbzh.FVp = locala.NPN.readString();
        AppMethodBeat.o(32348);
        return 0;
      }
      AppMethodBeat.o(32348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzh
 * JD-Core Version:    0.7.0.1
 */