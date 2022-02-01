package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class eaw
  extends com.tencent.mm.bx.a
{
  public long LwA;
  public String Lze;
  public int Lzq;
  public int Lzr;
  public int Lzs;
  public b Lzt;
  public b Lzu;
  public b Lzv;
  public String Lzw;
  public long Lzx;
  public long Lzy;
  public String Lzz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Lzq);
      if (this.Lze != null) {
        paramVarArgs.d(2, this.Lze);
      }
      paramVarArgs.aR(3, this.Lzr);
      paramVarArgs.aR(4, this.Lzs);
      if (this.Lzt != null) {
        paramVarArgs.c(5, this.Lzt);
      }
      if (this.Lzu != null) {
        paramVarArgs.c(6, this.Lzu);
      }
      if (this.Lzv != null) {
        paramVarArgs.c(7, this.Lzv);
      }
      if (this.Lzw != null) {
        paramVarArgs.d(8, this.Lzw);
      }
      paramVarArgs.aG(9, this.Lzx);
      paramVarArgs.aG(10, this.Lzy);
      paramVarArgs.aG(11, this.LwA);
      if (this.Lzz != null) {
        paramVarArgs.d(12, this.Lzz);
      }
      AppMethodBeat.o(202520);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Lzq) + 0;
      paramInt = i;
      if (this.Lze != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Lze);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.Lzr) + f.a.a.b.b.a.bA(4, this.Lzs);
      paramInt = i;
      if (this.Lzt != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.Lzt);
      }
      i = paramInt;
      if (this.Lzu != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.Lzu);
      }
      paramInt = i;
      if (this.Lzv != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.Lzv);
      }
      i = paramInt;
      if (this.Lzw != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Lzw);
      }
      i = i + f.a.a.b.b.a.q(9, this.Lzx) + f.a.a.b.b.a.q(10, this.Lzy) + f.a.a.b.b.a.q(11, this.LwA);
      paramInt = i;
      if (this.Lzz != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Lzz);
      }
      AppMethodBeat.o(202520);
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
      AppMethodBeat.o(202520);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eaw localeaw = (eaw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(202520);
        return -1;
      case 1: 
        localeaw.Lzq = locala.KhF.xS();
        AppMethodBeat.o(202520);
        return 0;
      case 2: 
        localeaw.Lze = locala.KhF.readString();
        AppMethodBeat.o(202520);
        return 0;
      case 3: 
        localeaw.Lzr = locala.KhF.xS();
        AppMethodBeat.o(202520);
        return 0;
      case 4: 
        localeaw.Lzs = locala.KhF.xS();
        AppMethodBeat.o(202520);
        return 0;
      case 5: 
        localeaw.Lzt = locala.KhF.fMu();
        AppMethodBeat.o(202520);
        return 0;
      case 6: 
        localeaw.Lzu = locala.KhF.fMu();
        AppMethodBeat.o(202520);
        return 0;
      case 7: 
        localeaw.Lzv = locala.KhF.fMu();
        AppMethodBeat.o(202520);
        return 0;
      case 8: 
        localeaw.Lzw = locala.KhF.readString();
        AppMethodBeat.o(202520);
        return 0;
      case 9: 
        localeaw.Lzx = locala.KhF.xT();
        AppMethodBeat.o(202520);
        return 0;
      case 10: 
        localeaw.Lzy = locala.KhF.xT();
        AppMethodBeat.o(202520);
        return 0;
      case 11: 
        localeaw.LwA = locala.KhF.xT();
        AppMethodBeat.o(202520);
        return 0;
      }
      localeaw.Lzz = locala.KhF.readString();
      AppMethodBeat.o(202520);
      return 0;
    }
    AppMethodBeat.o(202520);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaw
 * JD-Core Version:    0.7.0.1
 */