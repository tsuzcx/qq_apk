package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmt
  extends com.tencent.mm.bw.a
{
  public String EOw;
  public boolean FUy;
  public boolean FUz = false;
  public String MD5;
  public int Ret;
  public int vTH;
  public int vTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      paramVarArgs.aR(2, this.vTI);
      paramVarArgs.aR(3, this.vTH);
      if (this.MD5 != null) {
        paramVarArgs.d(4, this.MD5);
      }
      paramVarArgs.bl(5, this.FUy);
      if (this.EOw != null) {
        paramVarArgs.d(6, this.EOw);
      }
      paramVarArgs.bl(7, this.FUz);
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ret) + 0 + f.a.a.b.b.a.bx(2, this.vTI) + f.a.a.b.b.a.bx(3, this.vTH);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.MD5);
      }
      i = paramInt + (f.a.a.b.b.a.fK(5) + 1);
      paramInt = i;
      if (this.EOw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EOw);
      }
      i = f.a.a.b.b.a.fK(7);
      AppMethodBeat.o(104841);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dmt localdmt = (dmt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104841);
        return -1;
      case 1: 
        localdmt.Ret = locala.LVo.xF();
        AppMethodBeat.o(104841);
        return 0;
      case 2: 
        localdmt.vTI = locala.LVo.xF();
        AppMethodBeat.o(104841);
        return 0;
      case 3: 
        localdmt.vTH = locala.LVo.xF();
        AppMethodBeat.o(104841);
        return 0;
      case 4: 
        localdmt.MD5 = locala.LVo.readString();
        AppMethodBeat.o(104841);
        return 0;
      case 5: 
        localdmt.FUy = locala.LVo.fZX();
        AppMethodBeat.o(104841);
        return 0;
      case 6: 
        localdmt.EOw = locala.LVo.readString();
        AppMethodBeat.o(104841);
        return 0;
      }
      localdmt.FUz = locala.LVo.fZX();
      AppMethodBeat.o(104841);
      return 0;
    }
    AppMethodBeat.o(104841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmt
 * JD-Core Version:    0.7.0.1
 */