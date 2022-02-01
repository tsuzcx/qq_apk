package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gbc
  extends com.tencent.mm.bx.a
{
  public LinkedList<fzn> abXg;
  public int abZq;
  public int abZr;
  
  public gbc()
  {
    AppMethodBeat.i(115901);
    this.abXg = new LinkedList();
    AppMethodBeat.o(115901);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115902);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abZq);
      paramVarArgs.bS(2, this.abZr);
      paramVarArgs.e(3, 8, this.abXg);
      AppMethodBeat.o(115902);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abZq);
      i = i.a.a.b.b.a.cJ(2, this.abZr);
      int j = i.a.a.a.c(3, 8, this.abXg);
      AppMethodBeat.o(115902);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abXg.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(115902);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gbc localgbc = (gbc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115902);
        return -1;
      case 1: 
        localgbc.abZq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115902);
        return 0;
      case 2: 
        localgbc.abZr = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(115902);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fzn localfzn = new fzn();
        if ((localObject != null) && (localObject.length > 0)) {
          localfzn.parseFrom((byte[])localObject);
        }
        localgbc.abXg.add(localfzn);
        paramInt += 1;
      }
      AppMethodBeat.o(115902);
      return 0;
    }
    AppMethodBeat.o(115902);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbc
 * JD-Core Version:    0.7.0.1
 */