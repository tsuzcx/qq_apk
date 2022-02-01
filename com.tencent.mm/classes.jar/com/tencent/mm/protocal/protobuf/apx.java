package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apx
  extends com.tencent.mm.bw.a
{
  public int EIN = 7;
  public long EIO = 0L;
  public int EIP = 0;
  public String EIQ = "";
  public String EIR = "";
  public boolean EIS = false;
  public int hTM = 0;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EIN);
      paramVarArgs.aO(2, this.EIO);
      paramVarArgs.aR(3, this.EIP);
      if (this.EIQ != null) {
        paramVarArgs.d(4, this.EIQ);
      }
      if (this.EIR != null) {
        paramVarArgs.d(5, this.EIR);
      }
      paramVarArgs.aR(6, this.hTM);
      paramVarArgs.bl(7, this.EIS);
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.EIN) + 0 + f.a.a.b.b.a.p(2, this.EIO) + f.a.a.b.b.a.bx(3, this.EIP);
      paramInt = i;
      if (this.EIQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EIQ);
      }
      i = paramInt;
      if (this.EIR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EIR);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.hTM);
      int j = f.a.a.b.b.a.fK(7);
      AppMethodBeat.o(122494);
      return i + paramInt + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(122494);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apx localapx = (apx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122494);
        return -1;
      case 1: 
        localapx.EIN = locala.LVo.xF();
        AppMethodBeat.o(122494);
        return 0;
      case 2: 
        localapx.EIO = locala.LVo.xG();
        AppMethodBeat.o(122494);
        return 0;
      case 3: 
        localapx.EIP = locala.LVo.xF();
        AppMethodBeat.o(122494);
        return 0;
      case 4: 
        localapx.EIQ = locala.LVo.readString();
        AppMethodBeat.o(122494);
        return 0;
      case 5: 
        localapx.EIR = locala.LVo.readString();
        AppMethodBeat.o(122494);
        return 0;
      case 6: 
        localapx.hTM = locala.LVo.xF();
        AppMethodBeat.o(122494);
        return 0;
      }
      localapx.EIS = locala.LVo.fZX();
      AppMethodBeat.o(122494);
      return 0;
    }
    AppMethodBeat.o(122494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apx
 * JD-Core Version:    0.7.0.1
 */