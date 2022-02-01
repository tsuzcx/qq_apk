package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aec
  extends com.tencent.mm.bw.a
{
  public String EwR;
  public int EwS;
  public String IconUrl;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104767);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.EwR != null) {
        paramVarArgs.d(3, this.EwR);
      }
      paramVarArgs.aR(4, this.EwS);
      AppMethodBeat.o(104767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.Name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.EwR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EwR);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.EwS);
      AppMethodBeat.o(104767);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104767);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aec localaec = (aec)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104767);
          return -1;
        case 1: 
          localaec.Name = locala.LVo.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 2: 
          localaec.IconUrl = locala.LVo.readString();
          AppMethodBeat.o(104767);
          return 0;
        case 3: 
          localaec.EwR = locala.LVo.readString();
          AppMethodBeat.o(104767);
          return 0;
        }
        localaec.EwS = locala.LVo.xF();
        AppMethodBeat.o(104767);
        return 0;
      }
      AppMethodBeat.o(104767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aec
 * JD-Core Version:    0.7.0.1
 */