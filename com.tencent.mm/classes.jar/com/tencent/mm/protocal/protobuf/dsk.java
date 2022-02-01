package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsk
  extends com.tencent.mm.bx.a
{
  public String GxA;
  public boolean HFm;
  public boolean HFn = false;
  public String MD5;
  public int Ret;
  public int xcK;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      paramVarArgs.aS(2, this.xcL);
      paramVarArgs.aS(3, this.xcK);
      if (this.MD5 != null) {
        paramVarArgs.d(4, this.MD5);
      }
      paramVarArgs.bt(5, this.HFm);
      if (this.GxA != null) {
        paramVarArgs.d(6, this.GxA);
      }
      paramVarArgs.bt(7, this.HFn);
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Ret) + 0 + f.a.a.b.b.a.bz(2, this.xcL) + f.a.a.b.b.a.bz(3, this.xcK);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.MD5);
      }
      i = paramInt + f.a.a.b.b.a.alV(5);
      paramInt = i;
      if (this.GxA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GxA);
      }
      i = f.a.a.b.b.a.alV(7);
      AppMethodBeat.o(104841);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dsk localdsk = (dsk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104841);
        return -1;
      case 1: 
        localdsk.Ret = locala.NPN.zc();
        AppMethodBeat.o(104841);
        return 0;
      case 2: 
        localdsk.xcL = locala.NPN.zc();
        AppMethodBeat.o(104841);
        return 0;
      case 3: 
        localdsk.xcK = locala.NPN.zc();
        AppMethodBeat.o(104841);
        return 0;
      case 4: 
        localdsk.MD5 = locala.NPN.readString();
        AppMethodBeat.o(104841);
        return 0;
      case 5: 
        localdsk.HFm = locala.NPN.grw();
        AppMethodBeat.o(104841);
        return 0;
      case 6: 
        localdsk.GxA = locala.NPN.readString();
        AppMethodBeat.o(104841);
        return 0;
      }
      localdsk.HFn = locala.NPN.grw();
      AppMethodBeat.o(104841);
      return 0;
    }
    AppMethodBeat.o(104841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsk
 * JD-Core Version:    0.7.0.1
 */