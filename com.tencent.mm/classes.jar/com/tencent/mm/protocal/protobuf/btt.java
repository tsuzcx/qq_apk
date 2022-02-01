package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btt
  extends cvc
{
  public float FOA;
  public float FOB;
  public int GOk;
  public int GOl;
  public int Ggw;
  public String Ggx;
  public String Ggy;
  public int Ggz;
  public int OpCode;
  public String ihU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89929);
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
      if (this.ihU != null) {
        paramVarArgs.d(9, this.ihU);
      }
      paramVarArgs.aS(10, this.GOk);
      paramVarArgs.aS(11, this.GOl);
      AppMethodBeat.o(89929);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label804;
      }
    }
    label804:
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
      i += f.a.a.b.b.a.bz(8, this.Ggz);
      paramInt = i;
      if (this.ihU != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ihU);
      }
      i = f.a.a.b.b.a.bz(10, this.GOk);
      int j = f.a.a.b.b.a.bz(11, this.GOl);
      AppMethodBeat.o(89929);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(89929);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btt localbtt = (btt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89929);
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
            localbtt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89929);
          return 0;
        case 2: 
          localbtt.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89929);
          return 0;
        case 3: 
          localbtt.FOA = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(89929);
          return 0;
        case 4: 
          localbtt.FOB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(89929);
          return 0;
        case 5: 
          localbtt.Ggw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89929);
          return 0;
        case 6: 
          localbtt.Ggx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 7: 
          localbtt.Ggy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 8: 
          localbtt.Ggz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89929);
          return 0;
        case 9: 
          localbtt.ihU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 10: 
          localbtt.GOk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(89929);
          return 0;
        }
        localbtt.GOl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(89929);
        return 0;
      }
      AppMethodBeat.o(89929);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btt
 * JD-Core Version:    0.7.0.1
 */