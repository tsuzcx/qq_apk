package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class na
  extends ckq
{
  public int CDE;
  public b CGV;
  public String CGY;
  public int CKK;
  public int dep;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118407);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CGV != null) {
        paramVarArgs.c(2, this.CGV);
      }
      paramVarArgs.aR(3, this.dep);
      paramVarArgs.aR(4, this.CKK);
      if (this.CGY != null) {
        paramVarArgs.d(5, this.CGY);
      }
      paramVarArgs.aR(6, this.CDE);
      AppMethodBeat.o(118407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CGV != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.CGV);
      }
      i = i + f.a.a.b.b.a.bA(3, this.dep) + f.a.a.b.b.a.bA(4, this.CKK);
      paramInt = i;
      if (this.CGY != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CGY);
      }
      i = f.a.a.b.b.a.bA(6, this.CDE);
      AppMethodBeat.o(118407);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(118407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        na localna = (na)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118407);
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
            localna.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118407);
          return 0;
        case 2: 
          localna.CGV = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(118407);
          return 0;
        case 3: 
          localna.dep = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118407);
          return 0;
        case 4: 
          localna.CKK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118407);
          return 0;
        case 5: 
          localna.CGY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(118407);
          return 0;
        }
        localna.CDE = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118407);
        return 0;
      }
      AppMethodBeat.o(118407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.na
 * JD-Core Version:    0.7.0.1
 */