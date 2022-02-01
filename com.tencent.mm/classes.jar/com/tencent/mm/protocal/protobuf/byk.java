package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byk
  extends cvw
{
  public int COB;
  public String FNW;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91535);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.type);
      paramVarArgs.aS(3, this.COB);
      if (this.FNW != null) {
        paramVarArgs.d(4, this.FNW);
      }
      AppMethodBeat.o(91535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type) + f.a.a.b.b.a.bz(3, this.COB);
      paramInt = i;
      if (this.FNW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FNW);
      }
      AppMethodBeat.o(91535);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91535);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byk localbyk = (byk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91535);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91535);
          return 0;
        case 2: 
          localbyk.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91535);
          return 0;
        case 3: 
          localbyk.COB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91535);
          return 0;
        }
        localbyk.FNW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91535);
        return 0;
      }
      AppMethodBeat.o(91535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byk
 * JD-Core Version:    0.7.0.1
 */