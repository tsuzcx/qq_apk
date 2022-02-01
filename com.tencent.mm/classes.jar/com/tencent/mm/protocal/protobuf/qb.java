package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qb
  extends com.tencent.mm.bw.a
{
  public String BZV;
  public String EgJ;
  public String dsu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72426);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EgJ != null) {
        paramVarArgs.d(1, this.EgJ);
      }
      if (this.BZV != null) {
        paramVarArgs.d(2, this.BZV);
      }
      if (this.dsu != null) {
        paramVarArgs.d(3, this.dsu);
      }
      AppMethodBeat.o(72426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EgJ == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.EgJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.BZV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.BZV);
      }
      i = paramInt;
      if (this.dsu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dsu);
      }
      AppMethodBeat.o(72426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72426);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        qb localqb = (qb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72426);
          return -1;
        case 1: 
          localqb.EgJ = locala.LVo.readString();
          AppMethodBeat.o(72426);
          return 0;
        case 2: 
          localqb.BZV = locala.LVo.readString();
          AppMethodBeat.o(72426);
          return 0;
        }
        localqb.dsu = locala.LVo.readString();
        AppMethodBeat.o(72426);
        return 0;
      }
      AppMethodBeat.o(72426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qb
 * JD-Core Version:    0.7.0.1
 */