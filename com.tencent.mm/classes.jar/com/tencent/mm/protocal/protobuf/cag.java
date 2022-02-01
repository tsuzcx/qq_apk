package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cag
  extends dop
{
  public String qvD;
  public String yQE;
  public String yXL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91517);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yQE != null) {
        paramVarArgs.e(2, this.yQE);
      }
      if (this.qvD != null) {
        paramVarArgs.e(3, this.qvD);
      }
      if (this.yXL != null) {
        paramVarArgs.e(4, this.yXL);
      }
      AppMethodBeat.o(91517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yQE != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.yQE);
      }
      i = paramInt;
      if (this.qvD != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qvD);
      }
      paramInt = i;
      if (this.yXL != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.yXL);
      }
      AppMethodBeat.o(91517);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91517);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cag localcag = (cag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91517);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcag.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91517);
          return 0;
        case 2: 
          localcag.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91517);
          return 0;
        case 3: 
          localcag.qvD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91517);
          return 0;
        }
        localcag.yXL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91517);
        return 0;
      }
      AppMethodBeat.o(91517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cag
 * JD-Core Version:    0.7.0.1
 */