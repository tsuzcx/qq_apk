package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfy
  extends dyl
{
  public int CPw;
  public int Tnf;
  public int Tng;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32307);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.CPw);
      paramVarArgs.aY(3, this.Tnf);
      paramVarArgs.aY(4, this.Tng);
      AppMethodBeat.o(32307);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.CPw);
      int j = g.a.a.b.b.a.bM(3, this.Tnf);
      int k = g.a.a.b.b.a.bM(4, this.Tng);
      AppMethodBeat.o(32307);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32307);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cfy localcfy = (cfy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32307);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localcfy.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32307);
          return 0;
        case 2: 
          localcfy.CPw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32307);
          return 0;
        case 3: 
          localcfy.Tnf = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32307);
          return 0;
        }
        localcfy.Tng = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32307);
        return 0;
      }
      AppMethodBeat.o(32307);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfy
 * JD-Core Version:    0.7.0.1
 */