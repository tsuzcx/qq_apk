package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmx
  extends com.tencent.mm.cd.a
{
  public fhs SXN;
  public LinkedList<bmw> SXO;
  
  public bmx()
  {
    AppMethodBeat.i(250066);
    this.SXO = new LinkedList();
    AppMethodBeat.o(250066);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250068);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SXN != null)
      {
        paramVarArgs.oE(1, this.SXN.computeSize());
        this.SXN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SXO);
      AppMethodBeat.o(250068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SXN == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = g.a.a.a.oD(1, this.SXN.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.SXO);
      AppMethodBeat.o(250068);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SXO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250068);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bmx localbmx = (bmx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250068);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhs)localObject2).parseFrom((byte[])localObject1);
            }
            localbmx.SXN = ((fhs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(250068);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bmw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bmw)localObject2).parseFrom((byte[])localObject1);
          }
          localbmx.SXO.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250068);
        return 0;
      }
      AppMethodBeat.o(250068);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmx
 * JD-Core Version:    0.7.0.1
 */