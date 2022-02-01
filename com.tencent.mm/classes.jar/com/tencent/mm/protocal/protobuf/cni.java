package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cni
  extends com.tencent.mm.bw.a
{
  public long MtO;
  public String content;
  public int extFlag;
  public int iXu;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209734);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.id);
      if (this.content != null) {
        paramVarArgs.e(2, this.content);
      }
      paramVarArgs.bb(3, this.MtO);
      paramVarArgs.aM(4, this.iXu);
      paramVarArgs.aM(5, this.extFlag);
      AppMethodBeat.o(209734);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.id) + 0;
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.content);
      }
      i = g.a.a.b.b.a.r(3, this.MtO);
      int j = g.a.a.b.b.a.bu(4, this.iXu);
      int k = g.a.a.b.b.a.bu(5, this.extFlag);
      AppMethodBeat.o(209734);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209734);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cni localcni = (cni)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209734);
        return -1;
      case 1: 
        localcni.id = locala.UbS.zl();
        AppMethodBeat.o(209734);
        return 0;
      case 2: 
        localcni.content = locala.UbS.readString();
        AppMethodBeat.o(209734);
        return 0;
      case 3: 
        localcni.MtO = locala.UbS.zl();
        AppMethodBeat.o(209734);
        return 0;
      case 4: 
        localcni.iXu = locala.UbS.zi();
        AppMethodBeat.o(209734);
        return 0;
      }
      localcni.extFlag = locala.UbS.zi();
      AppMethodBeat.o(209734);
      return 0;
    }
    AppMethodBeat.o(209734);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cni
 * JD-Core Version:    0.7.0.1
 */