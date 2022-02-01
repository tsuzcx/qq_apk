package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class coa
  extends cvp
{
  public LinkedList<cdg> GXl;
  public String GXm;
  public LinkedList<cdd> GXq;
  public boolean HgZ;
  public String duW;
  public String hBg;
  public boolean kzP;
  public int kzQ;
  public int kzR;
  public String kzS;
  public String kzT;
  
  public coa()
  {
    AppMethodBeat.i(82468);
    this.GXl = new LinkedList();
    this.GXq = new LinkedList();
    AppMethodBeat.o(82468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82469);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82469);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(2, this.HgZ);
      paramVarArgs.e(3, 8, this.GXl);
      if (this.duW != null) {
        paramVarArgs.d(4, this.duW);
      }
      if (this.hBg != null) {
        paramVarArgs.d(5, this.hBg);
      }
      if (this.GXm != null) {
        paramVarArgs.d(6, this.GXm);
      }
      paramVarArgs.e(7, 8, this.GXq);
      paramVarArgs.bt(8, this.kzP);
      paramVarArgs.aS(9, this.kzQ);
      paramVarArgs.aS(10, this.kzR);
      if (this.kzS != null) {
        paramVarArgs.d(11, this.kzS);
      }
      if (this.kzT != null) {
        paramVarArgs.d(12, this.kzT);
      }
      AppMethodBeat.o(82469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alV(2) + f.a.a.a.c(3, 8, this.GXl);
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.duW);
      }
      i = paramInt;
      if (this.hBg != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hBg);
      }
      paramInt = i;
      if (this.GXm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GXm);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.GXq) + f.a.a.b.b.a.alV(8) + f.a.a.b.b.a.bz(9, this.kzQ) + f.a.a.b.b.a.bz(10, this.kzR);
      paramInt = i;
      if (this.kzS != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.kzS);
      }
      i = paramInt;
      if (this.kzT != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.kzT);
      }
      AppMethodBeat.o(82469);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GXl.clear();
        this.GXq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82469);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coa localcoa = (coa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82469);
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
            localcoa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 2: 
          localcoa.HgZ = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(82469);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoa.GXl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 4: 
          localcoa.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 5: 
          localcoa.hBg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 6: 
          localcoa.GXm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcoa.GXq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 8: 
          localcoa.kzP = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(82469);
          return 0;
        case 9: 
          localcoa.kzQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82469);
          return 0;
        case 10: 
          localcoa.kzR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82469);
          return 0;
        case 11: 
          localcoa.kzS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82469);
          return 0;
        }
        localcoa.kzT = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(82469);
        return 0;
      }
      AppMethodBeat.o(82469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coa
 * JD-Core Version:    0.7.0.1
 */