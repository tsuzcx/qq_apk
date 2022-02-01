package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xc
  extends com.tencent.mm.bw.a
{
  public String Erw;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50084);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Erw != null) {
        paramVarArgs.d(1, this.Erw);
      }
      paramVarArgs.e(2, this.longitude);
      paramVarArgs.e(3, this.latitude);
      AppMethodBeat.o(50084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Erw == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = f.a.a.b.b.a.e(1, this.Erw) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(50084);
      return paramInt + (i + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(50084);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        xc localxc = (xc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50084);
          return -1;
        case 1: 
          localxc.Erw = locala.LVo.readString();
          AppMethodBeat.o(50084);
          return 0;
        case 2: 
          localxc.longitude = Double.longBitsToDouble(locala.LVo.gab());
          AppMethodBeat.o(50084);
          return 0;
        }
        localxc.latitude = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(50084);
        return 0;
      }
      AppMethodBeat.o(50084);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xc
 * JD-Core Version:    0.7.0.1
 */