package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdr
  extends cvc
{
  public float FOA;
  public float FOB;
  public int GAe;
  public int GAf;
  public int Height;
  public int Width;
  public String qei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56247);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.z(2, this.FOA);
      paramVarArgs.z(3, this.FOB);
      paramVarArgs.aS(4, this.Width);
      paramVarArgs.aS(5, this.Height);
      if (this.qei != null) {
        paramVarArgs.d(6, this.qei);
      }
      paramVarArgs.aS(7, this.GAe);
      paramVarArgs.aS(8, this.GAf);
      AppMethodBeat.o(56247);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label636;
      }
    }
    label636:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alU(2) + f.a.a.b.b.a.alU(3) + f.a.a.b.b.a.bz(4, this.Width) + f.a.a.b.b.a.bz(5, this.Height);
      paramInt = i;
      if (this.qei != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.qei);
      }
      i = f.a.a.b.b.a.bz(7, this.GAe);
      int j = f.a.a.b.b.a.bz(8, this.GAf);
      AppMethodBeat.o(56247);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(56247);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdr localbdr = (bdr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56247);
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
            localbdr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56247);
          return 0;
        case 2: 
          localbdr.FOA = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(56247);
          return 0;
        case 3: 
          localbdr.FOB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(56247);
          return 0;
        case 4: 
          localbdr.Width = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56247);
          return 0;
        case 5: 
          localbdr.Height = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56247);
          return 0;
        case 6: 
          localbdr.qei = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(56247);
          return 0;
        case 7: 
          localbdr.GAe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(56247);
          return 0;
        }
        localbdr.GAf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(56247);
        return 0;
      }
      AppMethodBeat.o(56247);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdr
 * JD-Core Version:    0.7.0.1
 */