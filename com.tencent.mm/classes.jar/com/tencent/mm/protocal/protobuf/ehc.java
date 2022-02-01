package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ehc
  extends dyy
{
  public int CqV;
  public eae RNM;
  public int UjB;
  public int UjD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32447);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32447);
        throw paramVarArgs;
      }
      if (this.RNM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32447);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.RNM != null)
      {
        paramVarArgs.oE(2, this.RNM.computeSize());
        this.RNM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.CqV);
      paramVarArgs.aY(4, this.UjB);
      paramVarArgs.aY(5, this.UjD);
      AppMethodBeat.o(32447);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label669;
      }
    }
    label669:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RNM != null) {
        i = paramInt + g.a.a.a.oD(2, this.RNM.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(3, this.CqV);
      int j = g.a.a.b.b.a.bM(4, this.UjB);
      int k = g.a.a.b.b.a.bM(5, this.UjD);
      AppMethodBeat.o(32447);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32447);
          throw paramVarArgs;
        }
        if (this.RNM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(32447);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32447);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ehc localehc = (ehc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32447);
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
            localehc.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32447);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localehc.RNM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32447);
          return 0;
        case 3: 
          localehc.CqV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32447);
          return 0;
        case 4: 
          localehc.UjB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32447);
          return 0;
        }
        localehc.UjD = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32447);
        return 0;
      }
      AppMethodBeat.o(32447);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehc
 * JD-Core Version:    0.7.0.1
 */