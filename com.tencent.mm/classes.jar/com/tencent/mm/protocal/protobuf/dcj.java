package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcj
  extends com.tencent.mm.bx.a
{
  public boolean EtP;
  public String EtQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(182773);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.EtP);
      if (this.EtQ != null) {
        paramVarArgs.d(2, this.EtQ);
      }
      AppMethodBeat.o(182773);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0;
      paramInt = i;
      if (this.EtQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EtQ);
      }
      AppMethodBeat.o(182773);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(182773);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dcj localdcj = (dcj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(182773);
        return -1;
      case 1: 
        localdcj.EtP = locala.KhF.fHu();
        AppMethodBeat.o(182773);
        return 0;
      }
      localdcj.EtQ = locala.KhF.readString();
      AppMethodBeat.o(182773);
      return 0;
    }
    AppMethodBeat.o(182773);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcj
 * JD-Core Version:    0.7.0.1
 */