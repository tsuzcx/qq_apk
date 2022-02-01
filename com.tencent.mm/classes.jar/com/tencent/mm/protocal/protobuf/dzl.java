package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzl
  extends com.tencent.mm.cd.a
{
  public LinkedList<cxg> UeW;
  public String title;
  
  public dzl()
  {
    AppMethodBeat.i(72583);
    this.UeW = new LinkedList();
    AppMethodBeat.o(72583);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72584);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.UeW);
      if (this.title != null) {
        paramVarArgs.f(2, this.title);
      }
      AppMethodBeat.o(72584);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.UeW) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.title);
      }
      AppMethodBeat.o(72584);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UeW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(72584);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dzl localdzl = (dzl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72584);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cxg localcxg = new cxg();
          if ((localObject != null) && (localObject.length > 0)) {
            localcxg.parseFrom((byte[])localObject);
          }
          localdzl.UeW.add(localcxg);
          paramInt += 1;
        }
        AppMethodBeat.o(72584);
        return 0;
      }
      localdzl.title = ((g.a.a.a.a)localObject).abFh.readString();
      AppMethodBeat.o(72584);
      return 0;
    }
    AppMethodBeat.o(72584);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzl
 * JD-Core Version:    0.7.0.1
 */