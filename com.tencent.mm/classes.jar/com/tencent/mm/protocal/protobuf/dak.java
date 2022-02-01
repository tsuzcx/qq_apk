package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dak
  extends cvc
{
  public String HqF;
  public String HqG;
  public String yXS;
  public long zyP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HqF != null) {
        paramVarArgs.d(2, this.HqF);
      }
      if (this.yXS != null) {
        paramVarArgs.d(3, this.yXS);
      }
      paramVarArgs.aY(4, this.zyP);
      if (this.HqG != null) {
        paramVarArgs.d(5, this.HqG);
      }
      AppMethodBeat.o(213156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HqF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HqF);
      }
      i = paramInt;
      if (this.yXS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.yXS);
      }
      i += f.a.a.b.b.a.p(4, this.zyP);
      paramInt = i;
      if (this.HqG != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HqG);
      }
      AppMethodBeat.o(213156);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(213156);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dak localdak = (dak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(213156);
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
            localdak.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(213156);
          return 0;
        case 2: 
          localdak.HqF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(213156);
          return 0;
        case 3: 
          localdak.yXS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(213156);
          return 0;
        case 4: 
          localdak.zyP = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(213156);
          return 0;
        }
        localdak.HqG = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(213156);
        return 0;
      }
      AppMethodBeat.o(213156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dak
 * JD-Core Version:    0.7.0.1
 */