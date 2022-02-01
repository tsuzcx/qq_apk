package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqj
  extends cvc
{
  public float FOA;
  public float FOB;
  public int Ggw;
  public String Ggx;
  public String Ggy;
  public int Ggz;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127296);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      paramVarArgs.z(3, this.FOA);
      paramVarArgs.z(4, this.FOB);
      paramVarArgs.aS(5, this.Ggw);
      if (this.Ggx != null) {
        paramVarArgs.d(6, this.Ggx);
      }
      if (this.Ggy != null) {
        paramVarArgs.d(7, this.Ggy);
      }
      paramVarArgs.aS(8, this.Ggz);
      AppMethodBeat.o(127296);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label648;
      }
    }
    label648:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode) + f.a.a.b.b.a.alU(3) + f.a.a.b.b.a.alU(4) + f.a.a.b.b.a.bz(5, this.Ggw);
      paramInt = i;
      if (this.Ggx != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ggx);
      }
      i = paramInt;
      if (this.Ggy != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Ggy);
      }
      paramInt = f.a.a.b.b.a.bz(8, this.Ggz);
      AppMethodBeat.o(127296);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127296);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqj localcqj = (cqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127296);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127296);
          return 0;
        case 2: 
          localcqj.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127296);
          return 0;
        case 3: 
          localcqj.FOA = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(127296);
          return 0;
        case 4: 
          localcqj.FOB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(127296);
          return 0;
        case 5: 
          localcqj.Ggw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127296);
          return 0;
        case 6: 
          localcqj.Ggx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127296);
          return 0;
        case 7: 
          localcqj.Ggy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127296);
          return 0;
        }
        localcqj.Ggz = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(127296);
        return 0;
      }
      AppMethodBeat.o(127296);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqj
 * JD-Core Version:    0.7.0.1
 */