package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmr
  extends cvc
{
  public int GeI;
  public long GeJ;
  public long HfW;
  public int HfX;
  public String HfY;
  public long HfZ;
  public String uki;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32372);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aY(3, this.GeJ);
      if (this.uki != null) {
        paramVarArgs.d(4, this.uki);
      }
      paramVarArgs.aY(5, this.HfW);
      paramVarArgs.aS(6, this.HfX);
      if (this.HfY != null) {
        paramVarArgs.d(7, this.HfY);
      }
      paramVarArgs.aY(8, this.HfZ);
      AppMethodBeat.o(32372);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GeI) + f.a.a.b.b.a.p(3, this.GeJ);
      paramInt = i;
      if (this.uki != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uki);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.HfW) + f.a.a.b.b.a.bz(6, this.HfX);
      paramInt = i;
      if (this.HfY != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HfY);
      }
      i = f.a.a.b.b.a.p(8, this.HfZ);
      AppMethodBeat.o(32372);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32372);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmr localcmr = (cmr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32372);
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
            localcmr.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32372);
          return 0;
        case 2: 
          localcmr.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32372);
          return 0;
        case 3: 
          localcmr.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32372);
          return 0;
        case 4: 
          localcmr.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32372);
          return 0;
        case 5: 
          localcmr.HfW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32372);
          return 0;
        case 6: 
          localcmr.HfX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32372);
          return 0;
        case 7: 
          localcmr.HfY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32372);
          return 0;
        }
        localcmr.HfZ = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(32372);
        return 0;
      }
      AppMethodBeat.o(32372);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmr
 * JD-Core Version:    0.7.0.1
 */