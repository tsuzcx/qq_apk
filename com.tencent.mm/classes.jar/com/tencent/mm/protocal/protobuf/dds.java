package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dds
  extends com.tencent.mm.bw.a
{
  public int FNo;
  public String FNp;
  public String FNq;
  public String FNr;
  public String FNs;
  public int height;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168761);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FNo);
      if (this.FNp != null) {
        paramVarArgs.d(2, this.FNp);
      }
      if (this.FNq != null) {
        paramVarArgs.d(3, this.FNq);
      }
      paramVarArgs.aR(4, this.height);
      paramVarArgs.aR(5, this.width);
      if (this.FNr != null) {
        paramVarArgs.d(6, this.FNr);
      }
      if (this.FNs != null) {
        paramVarArgs.d(7, this.FNs);
      }
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FNo) + 0;
      paramInt = i;
      if (this.FNp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FNp);
      }
      i = paramInt;
      if (this.FNq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FNq);
      }
      i = i + f.a.a.b.b.a.bx(4, this.height) + f.a.a.b.b.a.bx(5, this.width);
      paramInt = i;
      if (this.FNr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNr);
      }
      i = paramInt;
      if (this.FNs != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FNs);
      }
      AppMethodBeat.o(168761);
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
      AppMethodBeat.o(168761);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dds localdds = (dds)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(168761);
        return -1;
      case 1: 
        localdds.FNo = locala.LVo.xF();
        AppMethodBeat.o(168761);
        return 0;
      case 2: 
        localdds.FNp = locala.LVo.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 3: 
        localdds.FNq = locala.LVo.readString();
        AppMethodBeat.o(168761);
        return 0;
      case 4: 
        localdds.height = locala.LVo.xF();
        AppMethodBeat.o(168761);
        return 0;
      case 5: 
        localdds.width = locala.LVo.xF();
        AppMethodBeat.o(168761);
        return 0;
      case 6: 
        localdds.FNr = locala.LVo.readString();
        AppMethodBeat.o(168761);
        return 0;
      }
      localdds.FNs = locala.LVo.readString();
      AppMethodBeat.o(168761);
      return 0;
    }
    AppMethodBeat.o(168761);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dds
 * JD-Core Version:    0.7.0.1
 */