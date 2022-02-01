package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dto
  extends com.tencent.mm.bw.a
{
  public b Ewb;
  public int FFA;
  public int GbD;
  public int ann;
  public String category;
  public int hTM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147790);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.hTM);
      paramVarArgs.aR(2, this.ann);
      if (this.category != null) {
        paramVarArgs.d(3, this.category);
      }
      if (this.Ewb != null) {
        paramVarArgs.c(4, this.Ewb);
      }
      paramVarArgs.aR(5, this.FFA);
      paramVarArgs.aR(6, this.GbD);
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.hTM) + 0 + f.a.a.b.b.a.bx(2, this.ann);
      paramInt = i;
      if (this.category != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.category);
      }
      i = paramInt;
      if (this.Ewb != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Ewb);
      }
      paramInt = f.a.a.b.b.a.bx(5, this.FFA);
      int j = f.a.a.b.b.a.bx(6, this.GbD);
      AppMethodBeat.o(147790);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dto localdto = (dto)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147790);
        return -1;
      case 1: 
        localdto.hTM = locala.LVo.xF();
        AppMethodBeat.o(147790);
        return 0;
      case 2: 
        localdto.ann = locala.LVo.xF();
        AppMethodBeat.o(147790);
        return 0;
      case 3: 
        localdto.category = locala.LVo.readString();
        AppMethodBeat.o(147790);
        return 0;
      case 4: 
        localdto.Ewb = locala.LVo.gfk();
        AppMethodBeat.o(147790);
        return 0;
      case 5: 
        localdto.FFA = locala.LVo.xF();
        AppMethodBeat.o(147790);
        return 0;
      }
      localdto.GbD = locala.LVo.xF();
      AppMethodBeat.o(147790);
      return 0;
    }
    AppMethodBeat.o(147790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dto
 * JD-Core Version:    0.7.0.1
 */