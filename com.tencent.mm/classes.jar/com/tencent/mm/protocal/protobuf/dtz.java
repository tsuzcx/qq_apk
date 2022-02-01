package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtz
  extends dpc
{
  public long KMm;
  public String MVJ;
  public int MVK;
  public String MvT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207016);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MVJ != null) {
        paramVarArgs.e(3, this.MVJ);
      }
      if (this.MvT != null) {
        paramVarArgs.e(4, this.MvT);
      }
      paramVarArgs.bb(5, this.KMm);
      paramVarArgs.aM(6, this.MVK);
      AppMethodBeat.o(207016);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label526;
      }
    }
    label526:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MVJ != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MVJ);
      }
      i = paramInt;
      if (this.MvT != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MvT);
      }
      paramInt = g.a.a.b.b.a.r(5, this.KMm);
      int j = g.a.a.b.b.a.bu(6, this.MVK);
      AppMethodBeat.o(207016);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(207016);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dtz localdtz = (dtz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(207016);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdtz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207016);
          return 0;
        case 3: 
          localdtz.MVJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(207016);
          return 0;
        case 4: 
          localdtz.MvT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(207016);
          return 0;
        case 5: 
          localdtz.KMm = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(207016);
          return 0;
        }
        localdtz.MVK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(207016);
        return 0;
      }
      AppMethodBeat.o(207016);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtz
 * JD-Core Version:    0.7.0.1
 */