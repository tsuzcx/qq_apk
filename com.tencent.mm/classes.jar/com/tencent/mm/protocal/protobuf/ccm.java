package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ccm
  extends cvc
{
  public int GWh;
  public int GWi;
  public b GWj;
  public int GWk;
  public String GWl;
  public String GWm;
  public String GWn;
  public b GzQ;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GWh);
      paramVarArgs.aS(3, this.GWi);
      if (this.GWj != null) {
        paramVarArgs.c(4, this.GWj);
      }
      paramVarArgs.aS(5, this.GWk);
      if (this.GzQ != null) {
        paramVarArgs.c(6, this.GzQ);
      }
      if (this.GWl != null) {
        paramVarArgs.d(7, this.GWl);
      }
      if (this.GWm != null) {
        paramVarArgs.d(8, this.GWm);
      }
      if (this.GWn != null) {
        paramVarArgs.d(9, this.GWn);
      }
      paramVarArgs.aS(10, this.Scene);
      AppMethodBeat.o(120957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GWh) + f.a.a.b.b.a.bz(3, this.GWi);
      paramInt = i;
      if (this.GWj != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GWj);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GWk);
      paramInt = i;
      if (this.GzQ != null) {
        paramInt = i + f.a.a.b.b.a.b(6, this.GzQ);
      }
      i = paramInt;
      if (this.GWl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GWl);
      }
      paramInt = i;
      if (this.GWm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GWm);
      }
      i = paramInt;
      if (this.GWn != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GWn);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.Scene);
      AppMethodBeat.o(120957);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(120957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccm localccm = (ccm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120957);
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
            localccm.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120957);
          return 0;
        case 2: 
          localccm.GWh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(120957);
          return 0;
        case 3: 
          localccm.GWi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(120957);
          return 0;
        case 4: 
          localccm.GWj = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(120957);
          return 0;
        case 5: 
          localccm.GWk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(120957);
          return 0;
        case 6: 
          localccm.GzQ = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(120957);
          return 0;
        case 7: 
          localccm.GWl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 8: 
          localccm.GWm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 9: 
          localccm.GWn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(120957);
          return 0;
        }
        localccm.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(120957);
        return 0;
      }
      AppMethodBeat.o(120957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccm
 * JD-Core Version:    0.7.0.1
 */