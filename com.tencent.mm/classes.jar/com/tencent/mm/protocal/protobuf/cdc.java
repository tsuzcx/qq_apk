package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cdc
  extends cvp
{
  public String Fxq;
  public LinkedList<cdg> GXl;
  public String GXm;
  public boolean GXn;
  public boolean GXo;
  public boolean GXp;
  public LinkedList<cdd> GXq;
  public boolean GXr;
  public String hBg;
  public boolean kzP;
  public int kzQ;
  public int kzR;
  public String kzS;
  public String kzT;
  
  public cdc()
  {
    AppMethodBeat.i(82461);
    this.GXl = new LinkedList();
    this.GXq = new LinkedList();
    AppMethodBeat.o(82461);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82462);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82462);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.GXl);
      if (this.hBg != null) {
        paramVarArgs.d(4, this.hBg);
      }
      if (this.GXm != null) {
        paramVarArgs.d(5, this.GXm);
      }
      if (this.Fxq != null) {
        paramVarArgs.d(6, this.Fxq);
      }
      paramVarArgs.bt(8, this.GXn);
      paramVarArgs.bt(9, this.GXo);
      paramVarArgs.bt(10, this.GXp);
      paramVarArgs.e(11, 8, this.GXq);
      paramVarArgs.bt(12, this.GXr);
      paramVarArgs.bt(13, this.kzP);
      paramVarArgs.aS(14, this.kzQ);
      paramVarArgs.aS(15, this.kzR);
      if (this.kzS != null) {
        paramVarArgs.d(16, this.kzS);
      }
      if (this.kzT != null) {
        paramVarArgs.d(17, this.kzT);
      }
      AppMethodBeat.o(82462);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1242;
      }
    }
    label1242:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(3, 8, this.GXl);
      paramInt = i;
      if (this.hBg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hBg);
      }
      i = paramInt;
      if (this.GXm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GXm);
      }
      paramInt = i;
      if (this.Fxq != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fxq);
      }
      i = paramInt + f.a.a.b.b.a.alV(8) + f.a.a.b.b.a.alV(9) + f.a.a.b.b.a.alV(10) + f.a.a.a.c(11, 8, this.GXq) + f.a.a.b.b.a.alV(12) + f.a.a.b.b.a.alV(13) + f.a.a.b.b.a.bz(14, this.kzQ) + f.a.a.b.b.a.bz(15, this.kzR);
      paramInt = i;
      if (this.kzS != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.kzS);
      }
      i = paramInt;
      if (this.kzT != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.kzT);
      }
      AppMethodBeat.o(82462);
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
          AppMethodBeat.o(82462);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82462);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdc localcdc = (cdc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          AppMethodBeat.o(82462);
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
            localcdc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
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
            localcdc.GXl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 4: 
          localcdc.hBg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 5: 
          localcdc.GXm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 6: 
          localcdc.Fxq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82462);
          return 0;
        case 8: 
          localcdc.GXn = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(82462);
          return 0;
        case 9: 
          localcdc.GXo = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(82462);
          return 0;
        case 10: 
          localcdc.GXp = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(82462);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdc.GXq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82462);
          return 0;
        case 12: 
          localcdc.GXr = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(82462);
          return 0;
        case 13: 
          localcdc.kzP = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(82462);
          return 0;
        case 14: 
          localcdc.kzQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82462);
          return 0;
        case 15: 
          localcdc.kzR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82462);
          return 0;
        case 16: 
          localcdc.kzS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82462);
          return 0;
        }
        localcdc.kzT = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(82462);
        return 0;
      }
      AppMethodBeat.o(82462);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdc
 * JD-Core Version:    0.7.0.1
 */