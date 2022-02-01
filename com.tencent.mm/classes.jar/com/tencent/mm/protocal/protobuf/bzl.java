package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzl
  extends com.tencent.mm.cd.a
  implements eip
{
  public dfg Tim;
  public int ret;
  
  public final int getRet()
  {
    return this.ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152581);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.ret);
      if (this.Tim != null)
      {
        paramVarArgs.oE(2, this.Tim.computeSize());
        this.Tim.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152581);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.ret) + 0;
      paramInt = i;
      if (this.Tim != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tim.computeSize());
      }
      AppMethodBeat.o(152581);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152581);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bzl localbzl = (bzl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152581);
        return -1;
      case 1: 
        localbzl.ret = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(152581);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dfg localdfg = new dfg();
        if ((localObject != null) && (localObject.length > 0)) {
          localdfg.parseFrom((byte[])localObject);
        }
        localbzl.Tim = localdfg;
        paramInt += 1;
      }
      AppMethodBeat.o(152581);
      return 0;
    }
    AppMethodBeat.o(152581);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzl
 * JD-Core Version:    0.7.0.1
 */