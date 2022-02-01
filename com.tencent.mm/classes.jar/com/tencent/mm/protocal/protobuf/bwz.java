package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bwz
  extends cvc
{
  public int GQV;
  public LinkedList<b> GQW;
  public long GQX;
  public long GQY;
  public float dAp;
  public float dyz;
  public long xze;
  
  public bwz()
  {
    AppMethodBeat.i(169918);
    this.GQW = new LinkedList();
    AppMethodBeat.o(169918);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169919);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GQV);
      paramVarArgs.z(3, this.dyz);
      paramVarArgs.z(4, this.dAp);
      paramVarArgs.e(5, 6, this.GQW);
      paramVarArgs.aY(6, this.xze);
      paramVarArgs.aY(7, this.GQX);
      paramVarArgs.aY(8, this.GQY);
      AppMethodBeat.o(169919);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GQV);
      int j = f.a.a.b.b.a.alU(3);
      int k = f.a.a.b.b.a.alU(4);
      int m = f.a.a.a.c(5, 6, this.GQW);
      int n = f.a.a.b.b.a.p(6, this.xze);
      int i1 = f.a.a.b.b.a.p(7, this.GQX);
      int i2 = f.a.a.b.b.a.p(8, this.GQY);
      AppMethodBeat.o(169919);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GQW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169919);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwz localbwz = (bwz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169919);
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
            localbwz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169919);
          return 0;
        case 2: 
          localbwz.GQV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169919);
          return 0;
        case 3: 
          localbwz.dyz = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169919);
          return 0;
        case 4: 
          localbwz.dAp = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(169919);
          return 0;
        case 5: 
          localbwz.GQW.add(((f.a.a.a.a)localObject1).NPN.gxI());
          AppMethodBeat.o(169919);
          return 0;
        case 6: 
          localbwz.xze = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169919);
          return 0;
        case 7: 
          localbwz.GQX = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(169919);
          return 0;
        }
        localbwz.GQY = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(169919);
        return 0;
      }
      AppMethodBeat.o(169919);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwz
 * JD-Core Version:    0.7.0.1
 */