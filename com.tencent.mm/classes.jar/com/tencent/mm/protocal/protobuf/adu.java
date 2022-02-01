package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adu
  extends ckq
{
  public String DdY;
  public int DdZ;
  public long Dea;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32193);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DdZ);
      paramVarArgs.aG(3, this.Dea);
      if (this.DdY != null) {
        paramVarArgs.d(4, this.DdY);
      }
      paramVarArgs.aR(5, this.Scene);
      AppMethodBeat.o(32193);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label513;
      }
    }
    label513:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.DdZ) + f.a.a.b.b.a.q(3, this.Dea);
      paramInt = i;
      if (this.DdY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DdY);
      }
      i = f.a.a.b.b.a.bA(5, this.Scene);
      AppMethodBeat.o(32193);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32193);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        adu localadu = (adu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32193);
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
            localadu.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32193);
          return 0;
        case 2: 
          localadu.DdZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32193);
          return 0;
        case 3: 
          localadu.Dea = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32193);
          return 0;
        case 4: 
          localadu.DdY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32193);
          return 0;
        }
        localadu.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32193);
        return 0;
      }
      AppMethodBeat.o(32193);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adu
 * JD-Core Version:    0.7.0.1
 */