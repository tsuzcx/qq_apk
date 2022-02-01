package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkm
  extends com.tencent.mm.bw.a
{
  public float Faf;
  public float Fag;
  public float Fah;
  public String Fai;
  public String Label;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32326);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.Faf);
      paramVarArgs.x(2, this.Fag);
      paramVarArgs.x(3, this.Fah);
      if (this.Label != null) {
        paramVarArgs.d(4, this.Label);
      }
      if (this.Fai != null) {
        paramVarArgs.d(5, this.Fai);
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 4 + 0 + (f.a.a.b.b.a.fK(2) + 4) + (f.a.a.b.b.a.fK(3) + 4);
      paramInt = i;
      if (this.Label != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Label);
      }
      i = paramInt;
      if (this.Fai != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Fai);
      }
      AppMethodBeat.o(32326);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32326);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bkm localbkm = (bkm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32326);
        return -1;
      case 1: 
        localbkm.Faf = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(32326);
        return 0;
      case 2: 
        localbkm.Fag = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(32326);
        return 0;
      case 3: 
        localbkm.Fah = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(32326);
        return 0;
      case 4: 
        localbkm.Label = locala.LVo.readString();
        AppMethodBeat.o(32326);
        return 0;
      }
      localbkm.Fai = locala.LVo.readString();
      AppMethodBeat.o(32326);
      return 0;
    }
    AppMethodBeat.o(32326);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkm
 * JD-Core Version:    0.7.0.1
 */