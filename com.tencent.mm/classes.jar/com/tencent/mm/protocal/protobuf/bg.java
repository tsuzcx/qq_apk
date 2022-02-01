package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bg
  extends com.tencent.mm.bw.a
{
  public boolean DNO = false;
  public boolean DNP = false;
  public boolean DNQ = false;
  public boolean DNR = false;
  public String DNS = "";
  public String DNT = "";
  public String DNU = "";
  public String DNV = "";
  public int DNW = -1;
  public String qqh = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.DNO);
      paramVarArgs.bl(2, this.DNP);
      paramVarArgs.bl(3, this.DNQ);
      paramVarArgs.bl(4, this.DNR);
      if (this.DNS != null) {
        paramVarArgs.d(5, this.DNS);
      }
      if (this.DNT != null) {
        paramVarArgs.d(6, this.DNT);
      }
      if (this.DNU != null) {
        paramVarArgs.d(7, this.DNU);
      }
      if (this.DNV != null) {
        paramVarArgs.d(8, this.DNV);
      }
      paramVarArgs.aR(9, this.DNW);
      if (this.qqh != null) {
        paramVarArgs.d(10, this.qqh);
      }
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0 + (f.a.a.b.b.a.fK(2) + 1) + (f.a.a.b.b.a.fK(3) + 1) + (f.a.a.b.b.a.fK(4) + 1);
      paramInt = i;
      if (this.DNS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DNS);
      }
      i = paramInt;
      if (this.DNT != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DNT);
      }
      paramInt = i;
      if (this.DNU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DNU);
      }
      i = paramInt;
      if (this.DNV != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DNV);
      }
      i += f.a.a.b.b.a.bx(9, this.DNW);
      paramInt = i;
      if (this.qqh != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qqh);
      }
      AppMethodBeat.o(122480);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bg localbg = (bg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122480);
        return -1;
      case 1: 
        localbg.DNO = locala.LVo.fZX();
        AppMethodBeat.o(122480);
        return 0;
      case 2: 
        localbg.DNP = locala.LVo.fZX();
        AppMethodBeat.o(122480);
        return 0;
      case 3: 
        localbg.DNQ = locala.LVo.fZX();
        AppMethodBeat.o(122480);
        return 0;
      case 4: 
        localbg.DNR = locala.LVo.fZX();
        AppMethodBeat.o(122480);
        return 0;
      case 5: 
        localbg.DNS = locala.LVo.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 6: 
        localbg.DNT = locala.LVo.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 7: 
        localbg.DNU = locala.LVo.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 8: 
        localbg.DNV = locala.LVo.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 9: 
        localbg.DNW = locala.LVo.xF();
        AppMethodBeat.o(122480);
        return 0;
      }
      localbg.qqh = locala.LVo.readString();
      AppMethodBeat.o(122480);
      return 0;
    }
    AppMethodBeat.o(122480);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bg
 * JD-Core Version:    0.7.0.1
 */