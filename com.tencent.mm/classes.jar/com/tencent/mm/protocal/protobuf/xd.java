package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class xd
  extends cvc
{
  public String FWA;
  public String FWB;
  public String FWC;
  public long FWD;
  public String FWE;
  public String FWF;
  public String FWy;
  public String FWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32161);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FWy != null) {
        paramVarArgs.d(2, this.FWy);
      }
      if (this.FWz != null) {
        paramVarArgs.d(3, this.FWz);
      }
      if (this.FWA != null) {
        paramVarArgs.d(4, this.FWA);
      }
      if (this.FWB != null) {
        paramVarArgs.d(5, this.FWB);
      }
      if (this.FWC != null) {
        paramVarArgs.d(6, this.FWC);
      }
      paramVarArgs.aY(7, this.FWD);
      if (this.FWE != null) {
        paramVarArgs.d(8, this.FWE);
      }
      if (this.FWF != null) {
        paramVarArgs.d(9, this.FWF);
      }
      AppMethodBeat.o(32161);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label797;
      }
    }
    label797:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FWy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FWy);
      }
      i = paramInt;
      if (this.FWz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FWz);
      }
      paramInt = i;
      if (this.FWA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FWA);
      }
      i = paramInt;
      if (this.FWB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FWB);
      }
      paramInt = i;
      if (this.FWC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FWC);
      }
      i = paramInt + f.a.a.b.b.a.p(7, this.FWD);
      paramInt = i;
      if (this.FWE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FWE);
      }
      i = paramInt;
      if (this.FWF != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FWF);
      }
      AppMethodBeat.o(32161);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32161);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xd localxd = (xd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32161);
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
            localxd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32161);
          return 0;
        case 2: 
          localxd.FWy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 3: 
          localxd.FWz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 4: 
          localxd.FWA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 5: 
          localxd.FWB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 6: 
          localxd.FWC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32161);
          return 0;
        case 7: 
          localxd.FWD = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(32161);
          return 0;
        case 8: 
          localxd.FWE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32161);
          return 0;
        }
        localxd.FWF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32161);
        return 0;
      }
      AppMethodBeat.o(32161);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xd
 * JD-Core Version:    0.7.0.1
 */