package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class cbz
  extends com.tencent.mm.bx.a
{
  public int DYk;
  public boolean DYl;
  public boolean DYm;
  public boolean DYn;
  public boolean DYo;
  public boolean DYp;
  public boolean DYq;
  public int gGx;
  public int id;
  public int mSu;
  public boolean ndr;
  public int nee;
  public int niJ;
  public String url;
  public String yaG = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(193013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(193013);
        throw paramVarArgs;
      }
      if (this.yaG == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(193013);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.id);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.aR(3, this.gGx);
      paramVarArgs.aR(4, this.nee);
      paramVarArgs.aR(5, this.mSu);
      paramVarArgs.aR(6, this.niJ);
      paramVarArgs.aR(7, this.DYk);
      if (this.yaG != null) {
        paramVarArgs.d(8, this.yaG);
      }
      paramVarArgs.bg(9, this.DYl);
      paramVarArgs.bg(10, this.DYm);
      paramVarArgs.bg(11, this.DYn);
      paramVarArgs.bg(12, this.DYo);
      paramVarArgs.bg(13, this.DYp);
      paramVarArgs.bg(14, this.ndr);
      paramVarArgs.bg(15, this.DYq);
      AppMethodBeat.o(193013);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.id) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.gGx) + f.a.a.b.b.a.bA(4, this.nee) + f.a.a.b.b.a.bA(5, this.mSu) + f.a.a.b.b.a.bA(6, this.niJ) + f.a.a.b.b.a.bA(7, this.DYk);
      paramInt = i;
      if (this.yaG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.yaG);
      }
      i = f.a.a.b.b.a.fY(9);
      int j = f.a.a.b.b.a.fY(10);
      int k = f.a.a.b.b.a.fY(11);
      int m = f.a.a.b.b.a.fY(12);
      int n = f.a.a.b.b.a.fY(13);
      int i1 = f.a.a.b.b.a.fY(14);
      int i2 = f.a.a.b.b.a.fY(15);
      AppMethodBeat.o(193013);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(193013);
        throw paramVarArgs;
      }
      if (this.yaG == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(193013);
        throw paramVarArgs;
      }
      AppMethodBeat.o(193013);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cbz localcbz = (cbz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(193013);
        return -1;
      case 1: 
        localcbz.id = locala.KhF.xS();
        AppMethodBeat.o(193013);
        return 0;
      case 2: 
        localcbz.url = locala.KhF.readString();
        AppMethodBeat.o(193013);
        return 0;
      case 3: 
        localcbz.gGx = locala.KhF.xS();
        AppMethodBeat.o(193013);
        return 0;
      case 4: 
        localcbz.nee = locala.KhF.xS();
        AppMethodBeat.o(193013);
        return 0;
      case 5: 
        localcbz.mSu = locala.KhF.xS();
        AppMethodBeat.o(193013);
        return 0;
      case 6: 
        localcbz.niJ = locala.KhF.xS();
        AppMethodBeat.o(193013);
        return 0;
      case 7: 
        localcbz.DYk = locala.KhF.xS();
        AppMethodBeat.o(193013);
        return 0;
      case 8: 
        localcbz.yaG = locala.KhF.readString();
        AppMethodBeat.o(193013);
        return 0;
      case 9: 
        localcbz.DYl = locala.KhF.fHu();
        AppMethodBeat.o(193013);
        return 0;
      case 10: 
        localcbz.DYm = locala.KhF.fHu();
        AppMethodBeat.o(193013);
        return 0;
      case 11: 
        localcbz.DYn = locala.KhF.fHu();
        AppMethodBeat.o(193013);
        return 0;
      case 12: 
        localcbz.DYo = locala.KhF.fHu();
        AppMethodBeat.o(193013);
        return 0;
      case 13: 
        localcbz.DYp = locala.KhF.fHu();
        AppMethodBeat.o(193013);
        return 0;
      case 14: 
        localcbz.ndr = locala.KhF.fHu();
        AppMethodBeat.o(193013);
        return 0;
      }
      localcbz.DYq = locala.KhF.fHu();
      AppMethodBeat.o(193013);
      return 0;
    }
    AppMethodBeat.o(193013);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbz
 * JD-Core Version:    0.7.0.1
 */