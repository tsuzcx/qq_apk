package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cfc
  extends dyy
{
  public int TmH;
  public LinkedList<ezp> TmI;
  public int rWt;
  
  public cfc()
  {
    AppMethodBeat.i(32285);
    this.TmI = new LinkedList();
    AppMethodBeat.o(32285);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32286);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32286);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rWt);
      paramVarArgs.aY(3, this.TmH);
      paramVarArgs.e(4, 8, this.TmI);
      AppMethodBeat.o(32286);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label560;
      }
    }
    label560:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rWt);
      int j = g.a.a.b.b.a.bM(3, this.TmH);
      int k = g.a.a.a.c(4, 8, this.TmI);
      AppMethodBeat.o(32286);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TmI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32286);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32286);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cfc localcfc = (cfc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32286);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcfc.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32286);
          return 0;
        case 2: 
          localcfc.rWt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32286);
          return 0;
        case 3: 
          localcfc.TmH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32286);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ezp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ezp)localObject2).parseFrom((byte[])localObject1);
          }
          localcfc.TmI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32286);
        return 0;
      }
      AppMethodBeat.o(32286);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfc
 * JD-Core Version:    0.7.0.1
 */