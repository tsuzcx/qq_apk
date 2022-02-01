package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class js
  extends dyl
{
  public LinkedList<djh> RPo;
  public int RPp;
  public int RPq;
  
  public js()
  {
    AppMethodBeat.i(91362);
    this.RPo = new LinkedList();
    AppMethodBeat.o(91362);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91363);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.RPo);
      paramVarArgs.aY(3, this.RPp);
      paramVarArgs.aY(4, this.RPq);
      AppMethodBeat.o(91363);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.RPo);
      int j = g.a.a.b.b.a.bM(3, this.RPp);
      int k = g.a.a.b.b.a.bM(4, this.RPq);
      AppMethodBeat.o(91363);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RPo.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91363);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        js localjs = (js)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91363);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localjs.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91363);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new djh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((djh)localObject2).parseFrom((byte[])localObject1);
            }
            localjs.RPo.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91363);
          return 0;
        case 3: 
          localjs.RPp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91363);
          return 0;
        }
        localjs.RPq = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91363);
        return 0;
      }
      AppMethodBeat.o(91363);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.js
 * JD-Core Version:    0.7.0.1
 */