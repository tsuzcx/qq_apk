package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnq
  extends dyl
{
  public int TuP;
  public foh TuQ;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123620);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      paramVarArgs.aY(3, this.TuP);
      if (this.TuQ != null)
      {
        paramVarArgs.oE(4, this.TuQ.computeSize());
        this.TuQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lVG);
      }
      i += g.a.a.b.b.a.bM(3, this.TuP);
      paramInt = i;
      if (this.TuQ != null) {
        paramInt = i + g.a.a.a.oD(4, this.TuQ.computeSize());
      }
      AppMethodBeat.o(123620);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123620);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnq localcnq = (cnq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123620);
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
            localcnq.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123620);
          return 0;
        case 2: 
          localcnq.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123620);
          return 0;
        case 3: 
          localcnq.TuP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123620);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new foh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((foh)localObject2).parseFrom((byte[])localObject1);
          }
          localcnq.TuQ = ((foh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123620);
        return 0;
      }
      AppMethodBeat.o(123620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnq
 * JD-Core Version:    0.7.0.1
 */