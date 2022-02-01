package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebv
  extends com.tencent.mm.bw.a
{
  public int Fnr;
  public String GfC;
  public int Ghh;
  public String Ghi;
  public int Ghj;
  public boolean Ghk = false;
  public boolean Ghl = false;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ghh);
      paramVarArgs.aR(2, this.Fnr);
      if (this.session_id != null) {
        paramVarArgs.d(3, this.session_id);
      }
      if (this.Ghi != null) {
        paramVarArgs.d(4, this.Ghi);
      }
      if (this.GfC != null) {
        paramVarArgs.d(5, this.GfC);
      }
      paramVarArgs.aR(6, this.Ghj);
      paramVarArgs.bl(7, this.Ghk);
      paramVarArgs.bl(8, this.Ghl);
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ghh) + 0 + f.a.a.b.b.a.bx(2, this.Fnr);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.session_id);
      }
      i = paramInt;
      if (this.Ghi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Ghi);
      }
      paramInt = i;
      if (this.GfC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GfC);
      }
      i = f.a.a.b.b.a.bx(6, this.Ghj);
      int j = f.a.a.b.b.a.fK(7);
      int k = f.a.a.b.b.a.fK(8);
      AppMethodBeat.o(117961);
      return paramInt + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ebv localebv = (ebv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117961);
        return -1;
      case 1: 
        localebv.Ghh = locala.LVo.xF();
        AppMethodBeat.o(117961);
        return 0;
      case 2: 
        localebv.Fnr = locala.LVo.xF();
        AppMethodBeat.o(117961);
        return 0;
      case 3: 
        localebv.session_id = locala.LVo.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 4: 
        localebv.Ghi = locala.LVo.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 5: 
        localebv.GfC = locala.LVo.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 6: 
        localebv.Ghj = locala.LVo.xF();
        AppMethodBeat.o(117961);
        return 0;
      case 7: 
        localebv.Ghk = locala.LVo.fZX();
        AppMethodBeat.o(117961);
        return 0;
      }
      localebv.Ghl = locala.LVo.fZX();
      AppMethodBeat.o(117961);
      return 0;
    }
    AppMethodBeat.o(117961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebv
 * JD-Core Version:    0.7.0.1
 */