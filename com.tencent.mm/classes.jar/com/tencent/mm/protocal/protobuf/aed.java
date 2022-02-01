package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aed
  extends ckq
{
  public int Scene;
  public String gKr;
  public int mBH;
  public int vJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190930);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.gKr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Content");
        AppMethodBeat.o(190930);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mBH);
      paramVarArgs.aR(3, this.Scene);
      paramVarArgs.aR(4, this.vJz);
      if (this.gKr != null) {
        paramVarArgs.d(5, this.gKr);
      }
      AppMethodBeat.o(190930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH) + f.a.a.b.b.a.bA(3, this.Scene) + f.a.a.b.b.a.bA(4, this.vJz);
      paramInt = i;
      if (this.gKr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gKr);
      }
      AppMethodBeat.o(190930);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.gKr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Content");
          AppMethodBeat.o(190930);
          throw paramVarArgs;
        }
        AppMethodBeat.o(190930);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aed localaed = (aed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190930);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaed.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190930);
          return 0;
        case 2: 
          localaed.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(190930);
          return 0;
        case 3: 
          localaed.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(190930);
          return 0;
        case 4: 
          localaed.vJz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(190930);
          return 0;
        }
        localaed.gKr = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(190930);
        return 0;
      }
      AppMethodBeat.o(190930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aed
 * JD-Core Version:    0.7.0.1
 */