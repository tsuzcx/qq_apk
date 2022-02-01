package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcx
  extends com.tencent.mm.bw.a
{
  public String FMA;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152696);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.FMA != null) {
        paramVarArgs.d(2, this.FMA);
      }
      AppMethodBeat.o(152696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FMA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FMA);
      }
      AppMethodBeat.o(152696);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152696);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dcx localdcx = (dcx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152696);
          return -1;
        case 1: 
          localdcx.Name = locala.LVo.readString();
          AppMethodBeat.o(152696);
          return 0;
        }
        localdcx.FMA = locala.LVo.readString();
        AppMethodBeat.o(152696);
        return 0;
      }
      AppMethodBeat.o(152696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcx
 * JD-Core Version:    0.7.0.1
 */