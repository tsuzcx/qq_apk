package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bao
  extends com.tencent.mm.cd.a
{
  public LinkedList<baq> SMw;
  public LinkedList<String> SMx;
  
  public bao()
  {
    AppMethodBeat.i(205735);
    this.SMw = new LinkedList();
    this.SMx = new LinkedList();
    AppMethodBeat.o(205735);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205740);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SMw);
      paramVarArgs.e(2, 1, this.SMx);
      AppMethodBeat.o(205740);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.SMw);
      i = g.a.a.a.c(2, 1, this.SMx);
      AppMethodBeat.o(205740);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SMw.clear();
      this.SMx.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(205740);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bao localbao = (bao)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(205740);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          baq localbaq = new baq();
          if ((localObject != null) && (localObject.length > 0)) {
            localbaq.parseFrom((byte[])localObject);
          }
          localbao.SMw.add(localbaq);
          paramInt += 1;
        }
        AppMethodBeat.o(205740);
        return 0;
      }
      localbao.SMx.add(((g.a.a.a.a)localObject).abFh.readString());
      AppMethodBeat.o(205740);
      return 0;
    }
    AppMethodBeat.o(205740);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bao
 * JD-Core Version:    0.7.0.1
 */