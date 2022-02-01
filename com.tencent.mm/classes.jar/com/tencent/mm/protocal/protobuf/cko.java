package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cko
  extends cvp
{
  public long CwM;
  public String CwN;
  public String CwP;
  public String CwQ;
  public LinkedList<ckp> HdZ;
  public iu Hea;
  public int Heb;
  public int ozR;
  public String ozS;
  
  public cko()
  {
    AppMethodBeat.i(91616);
    this.HdZ = new LinkedList();
    AppMethodBeat.o(91616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91617);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ozR);
      if (this.ozS != null) {
        paramVarArgs.d(3, this.ozS);
      }
      paramVarArgs.e(4, 8, this.HdZ);
      paramVarArgs.aY(5, this.CwM);
      if (this.CwN != null) {
        paramVarArgs.d(6, this.CwN);
      }
      if (this.Hea != null)
      {
        paramVarArgs.lC(7, this.Hea.computeSize());
        this.Hea.writeFields(paramVarArgs);
      }
      if (this.CwP != null) {
        paramVarArgs.d(8, this.CwP);
      }
      if (this.CwQ != null) {
        paramVarArgs.d(9, this.CwQ);
      }
      paramVarArgs.aS(10, this.Heb);
      AppMethodBeat.o(91617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1034;
      }
    }
    label1034:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.HdZ) + f.a.a.b.b.a.p(5, this.CwM);
      paramInt = i;
      if (this.CwN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CwN);
      }
      i = paramInt;
      if (this.Hea != null) {
        i = paramInt + f.a.a.a.lB(7, this.Hea.computeSize());
      }
      paramInt = i;
      if (this.CwP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CwP);
      }
      i = paramInt;
      if (this.CwQ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CwQ);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.Heb);
      AppMethodBeat.o(91617);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HdZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cko localcko = (cko)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91617);
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
            localcko.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 2: 
          localcko.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91617);
          return 0;
        case 3: 
          localcko.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcko.HdZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 5: 
          localcko.CwM = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(91617);
          return 0;
        case 6: 
          localcko.CwN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcko.Hea = ((iu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 8: 
          localcko.CwP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 9: 
          localcko.CwQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91617);
          return 0;
        }
        localcko.Heb = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91617);
        return 0;
      }
      AppMethodBeat.o(91617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cko
 * JD-Core Version:    0.7.0.1
 */