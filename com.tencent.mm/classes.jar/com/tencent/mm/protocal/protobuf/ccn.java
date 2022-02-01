package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccn
  extends cvp
{
  public float GWo;
  public String GWp;
  public String GWq;
  public String GWr;
  public LinkedList<dqa> GyO;
  public com.tencent.mm.bx.b GzQ;
  public int ihf;
  
  public ccn()
  {
    AppMethodBeat.i(120958);
    this.GyO = new LinkedList();
    AppMethodBeat.o(120958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(120959);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ihf);
      paramVarArgs.e(3, 8, this.GyO);
      if (this.GzQ != null) {
        paramVarArgs.c(4, this.GzQ);
      }
      paramVarArgs.z(5, this.GWo);
      if (this.GWp != null) {
        paramVarArgs.d(6, this.GWp);
      }
      if (this.GWq != null) {
        paramVarArgs.d(7, this.GWq);
      }
      if (this.GWr != null) {
        paramVarArgs.d(8, this.GWr);
      }
      AppMethodBeat.o(120959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label829;
      }
    }
    label829:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ihf) + f.a.a.a.c(3, 8, this.GyO);
      paramInt = i;
      if (this.GzQ != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GzQ);
      }
      i = paramInt + f.a.a.b.b.a.alU(5);
      paramInt = i;
      if (this.GWp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GWp);
      }
      i = paramInt;
      if (this.GWq != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GWq);
      }
      paramInt = i;
      if (this.GWr != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GWr);
      }
      AppMethodBeat.o(120959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GyO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(120959);
          throw paramVarArgs;
        }
        AppMethodBeat.o(120959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ccn localccn = (ccn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120959);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 2: 
          localccn.ihf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(120959);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localccn.GyO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 4: 
          localccn.GzQ = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(120959);
          return 0;
        case 5: 
          localccn.GWo = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(120959);
          return 0;
        case 6: 
          localccn.GWp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(120959);
          return 0;
        case 7: 
          localccn.GWq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(120959);
          return 0;
        }
        localccn.GWr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(120959);
        return 0;
      }
      AppMethodBeat.o(120959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccn
 * JD-Core Version:    0.7.0.1
 */