package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cdw
  extends cvp
{
  public String Cyu;
  public boolean GNn;
  public bvy GXL;
  public String GXM;
  public ajj GXN;
  public int GXO;
  public int GXP;
  public int GXQ;
  public LinkedList<afa> GXR;
  public LinkedList<csm> GXS;
  public LinkedList<is> GXT;
  public ckz GXU;
  public int GXV;
  public int ozR;
  public String ozS;
  
  public cdw()
  {
    AppMethodBeat.i(91561);
    this.GXR = new LinkedList();
    this.GXS = new LinkedList();
    this.GXT = new LinkedList();
    AppMethodBeat.o(91561);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91562);
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
      paramVarArgs.aS(4, this.GXO);
      paramVarArgs.aS(5, this.GXP);
      paramVarArgs.aS(6, this.GXQ);
      paramVarArgs.e(8, 8, this.GXR);
      if (this.GXL != null)
      {
        paramVarArgs.lC(9, this.GXL.computeSize());
        this.GXL.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.GXS);
      paramVarArgs.e(11, 8, this.GXT);
      paramVarArgs.bt(12, this.GNn);
      if (this.GXU != null)
      {
        paramVarArgs.lC(13, this.GXU.computeSize());
        this.GXU.writeFields(paramVarArgs);
      }
      if (this.GXM != null) {
        paramVarArgs.d(14, this.GXM);
      }
      if (this.GXN != null)
      {
        paramVarArgs.lC(15, this.GXN.computeSize());
        this.GXN.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.GXV);
      if (this.Cyu != null) {
        paramVarArgs.d(100, this.Cyu);
      }
      AppMethodBeat.o(91562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1750;
      }
    }
    label1750:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ozR);
      paramInt = i;
      if (this.ozS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ozS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GXO) + f.a.a.b.b.a.bz(5, this.GXP) + f.a.a.b.b.a.bz(6, this.GXQ) + f.a.a.a.c(8, 8, this.GXR);
      paramInt = i;
      if (this.GXL != null) {
        paramInt = i + f.a.a.a.lB(9, this.GXL.computeSize());
      }
      i = paramInt + f.a.a.a.c(10, 8, this.GXS) + f.a.a.a.c(11, 8, this.GXT) + f.a.a.b.b.a.alV(12);
      paramInt = i;
      if (this.GXU != null) {
        paramInt = i + f.a.a.a.lB(13, this.GXU.computeSize());
      }
      i = paramInt;
      if (this.GXM != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.GXM);
      }
      paramInt = i;
      if (this.GXN != null) {
        paramInt = i + f.a.a.a.lB(15, this.GXN.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.GXV);
      paramInt = i;
      if (this.Cyu != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.Cyu);
      }
      AppMethodBeat.o(91562);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GXR.clear();
        this.GXS.clear();
        this.GXT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cdw localcdw = (cdw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91562);
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
            localcdw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 2: 
          localcdw.ozR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91562);
          return 0;
        case 3: 
          localcdw.ozS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 4: 
          localcdw.GXO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91562);
          return 0;
        case 5: 
          localcdw.GXP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91562);
          return 0;
        case 6: 
          localcdw.GXQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91562);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afa();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdw.GXR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdw.GXL = ((bvy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdw.GXS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new is();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((is)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdw.GXT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 12: 
          localcdw.GNn = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91562);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdw.GXU = ((ckz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 14: 
          localcdw.GXM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91562);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ajj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ajj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcdw.GXN = ((ajj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91562);
          return 0;
        case 16: 
          localcdw.GXV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91562);
          return 0;
        }
        localcdw.Cyu = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91562);
        return 0;
      }
      AppMethodBeat.o(91562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdw
 * JD-Core Version:    0.7.0.1
 */