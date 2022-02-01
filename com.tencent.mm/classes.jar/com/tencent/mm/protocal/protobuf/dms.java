package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dms
  extends cvc
{
  public String FHU;
  public long FJW;
  public int FKa;
  public String FKb;
  public String HAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214025);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.FJW);
      paramVarArgs.aS(3, this.FKa);
      if (this.FHU != null) {
        paramVarArgs.d(4, this.FHU);
      }
      if (this.FKb != null) {
        paramVarArgs.d(5, this.FKb);
      }
      if (this.HAP != null) {
        paramVarArgs.d(6, this.HAP);
      }
      AppMethodBeat.o(214025);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FJW) + f.a.a.b.b.a.bz(3, this.FKa);
      paramInt = i;
      if (this.FHU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FHU);
      }
      i = paramInt;
      if (this.FKb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FKb);
      }
      paramInt = i;
      if (this.HAP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HAP);
      }
      AppMethodBeat.o(214025);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(214025);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dms localdms = (dms)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214025);
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
            localdms.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214025);
          return 0;
        case 2: 
          localdms.FJW = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(214025);
          return 0;
        case 3: 
          localdms.FKa = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(214025);
          return 0;
        case 4: 
          localdms.FHU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(214025);
          return 0;
        case 5: 
          localdms.FKb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(214025);
          return 0;
        }
        localdms.HAP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(214025);
        return 0;
      }
      AppMethodBeat.o(214025);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dms
 * JD-Core Version:    0.7.0.1
 */