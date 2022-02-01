package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eco
  extends com.tencent.mm.bw.a
{
  public int Gic;
  public String Gid;
  public String sVp;
  public String tlV;
  public String tlX;
  public String tlY;
  public int tlZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152730);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Gic);
      if (this.sVp != null) {
        paramVarArgs.d(2, this.sVp);
      }
      if (this.tlV != null) {
        paramVarArgs.d(3, this.tlV);
      }
      if (this.Gid != null) {
        paramVarArgs.d(4, this.Gid);
      }
      if (this.tlX != null) {
        paramVarArgs.d(5, this.tlX);
      }
      if (this.tlY != null) {
        paramVarArgs.d(6, this.tlY);
      }
      paramVarArgs.aR(7, this.tlZ);
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Gic) + 0;
      paramInt = i;
      if (this.sVp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sVp);
      }
      i = paramInt;
      if (this.tlV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlV);
      }
      paramInt = i;
      if (this.Gid != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gid);
      }
      i = paramInt;
      if (this.tlX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tlX);
      }
      paramInt = i;
      if (this.tlY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tlY);
      }
      i = f.a.a.b.b.a.bx(7, this.tlZ);
      AppMethodBeat.o(152730);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eco localeco = (eco)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152730);
        return -1;
      case 1: 
        localeco.Gic = locala.LVo.xF();
        AppMethodBeat.o(152730);
        return 0;
      case 2: 
        localeco.sVp = locala.LVo.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 3: 
        localeco.tlV = locala.LVo.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 4: 
        localeco.Gid = locala.LVo.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 5: 
        localeco.tlX = locala.LVo.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 6: 
        localeco.tlY = locala.LVo.readString();
        AppMethodBeat.o(152730);
        return 0;
      }
      localeco.tlZ = locala.LVo.xF();
      AppMethodBeat.o(152730);
      return 0;
    }
    AppMethodBeat.o(152730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eco
 * JD-Core Version:    0.7.0.1
 */