package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class drx
  extends cvw
{
  public int HYz;
  public String devicetype;
  public String fhy;
  public String wNY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.devicetype == null)
      {
        paramVarArgs = new b("Not all required fields were included: devicetype");
        AppMethodBeat.o(32477);
        throw paramVarArgs;
      }
      if (this.wNY == null)
      {
        paramVarArgs = new b("Not all required fields were included: deviceid");
        AppMethodBeat.o(32477);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.devicetype != null) {
        paramVarArgs.d(2, this.devicetype);
      }
      if (this.wNY != null) {
        paramVarArgs.d(3, this.wNY);
      }
      if (this.fhy != null) {
        paramVarArgs.d(4, this.fhy);
      }
      paramVarArgs.aS(5, this.HYz);
      AppMethodBeat.o(32477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label645;
      }
    }
    label645:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicetype != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.devicetype);
      }
      i = paramInt;
      if (this.wNY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wNY);
      }
      paramInt = i;
      if (this.fhy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fhy);
      }
      i = f.a.a.b.b.a.bz(5, this.HYz);
      AppMethodBeat.o(32477);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.devicetype == null)
        {
          paramVarArgs = new b("Not all required fields were included: devicetype");
          AppMethodBeat.o(32477);
          throw paramVarArgs;
        }
        if (this.wNY == null)
        {
          paramVarArgs = new b("Not all required fields were included: deviceid");
          AppMethodBeat.o(32477);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drx localdrx = (drx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32477);
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
            localdrx.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32477);
          return 0;
        case 2: 
          localdrx.devicetype = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32477);
          return 0;
        case 3: 
          localdrx.wNY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32477);
          return 0;
        case 4: 
          localdrx.fhy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32477);
          return 0;
        }
        localdrx.HYz = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32477);
        return 0;
      }
      AppMethodBeat.o(32477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drx
 * JD-Core Version:    0.7.0.1
 */