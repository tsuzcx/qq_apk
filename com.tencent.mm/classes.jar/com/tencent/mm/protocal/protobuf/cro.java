package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cro
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String DUp;
  public String EpI;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134254);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.EpI != null) {
        paramVarArgs.d(2, this.EpI);
      }
      if (this.DUp != null) {
        paramVarArgs.d(3, this.DUp);
      }
      paramVarArgs.aR(4, this.CreateTime);
      AppMethodBeat.o(134254);
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
      if (this.EpI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EpI);
      }
      i = paramInt;
      if (this.DUp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DUp);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.CreateTime);
      AppMethodBeat.o(134254);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(134254);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cro localcro = (cro)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134254);
          return -1;
        case 1: 
          localcro.Name = locala.LVo.readString();
          AppMethodBeat.o(134254);
          return 0;
        case 2: 
          localcro.EpI = locala.LVo.readString();
          AppMethodBeat.o(134254);
          return 0;
        case 3: 
          localcro.DUp = locala.LVo.readString();
          AppMethodBeat.o(134254);
          return 0;
        }
        localcro.CreateTime = locala.LVo.xF();
        AppMethodBeat.o(134254);
        return 0;
      }
      AppMethodBeat.o(134254);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cro
 * JD-Core Version:    0.7.0.1
 */