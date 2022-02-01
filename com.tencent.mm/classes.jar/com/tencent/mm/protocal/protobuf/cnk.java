package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnk
  extends cvc
{
  public int Cyj;
  public String Cyu;
  public String Hfb;
  public String HgB;
  public int HgC;
  public String HgD;
  public int uxm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91636);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HgB != null) {
        paramVarArgs.d(2, this.HgB);
      }
      paramVarArgs.aS(3, this.HgC);
      paramVarArgs.aS(4, this.uxm);
      if (this.HgD != null) {
        paramVarArgs.d(5, this.HgD);
      }
      if (this.Hfb != null) {
        paramVarArgs.d(7, this.Hfb);
      }
      paramVarArgs.aS(8, this.Cyj);
      if (this.Cyu != null) {
        paramVarArgs.d(100, this.Cyu);
      }
      AppMethodBeat.o(91636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HgB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HgB);
      }
      i = i + f.a.a.b.b.a.bz(3, this.HgC) + f.a.a.b.b.a.bz(4, this.uxm);
      paramInt = i;
      if (this.HgD != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HgD);
      }
      i = paramInt;
      if (this.Hfb != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hfb);
      }
      i += f.a.a.b.b.a.bz(8, this.Cyj);
      paramInt = i;
      if (this.Cyu != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.Cyu);
      }
      AppMethodBeat.o(91636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnk localcnk = (cnk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91636);
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
            localcnk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91636);
          return 0;
        case 2: 
          localcnk.HgB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 3: 
          localcnk.HgC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91636);
          return 0;
        case 4: 
          localcnk.uxm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91636);
          return 0;
        case 5: 
          localcnk.HgD = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 7: 
          localcnk.Hfb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 8: 
          localcnk.Cyj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91636);
          return 0;
        }
        localcnk.Cyu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91636);
        return 0;
      }
      AppMethodBeat.o(91636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnk
 * JD-Core Version:    0.7.0.1
 */