package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ad
  extends cvp
{
  public String FqL;
  public int FqM;
  public int FqN;
  public String FqO;
  public dej FqP;
  public css FqQ;
  public dej FqR;
  public cov FqS;
  public ats FqT;
  public hu FqU;
  public String FqV;
  public String FqW;
  public int FqX;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32097);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32097);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FqL != null) {
        paramVarArgs.d(2, this.FqL);
      }
      paramVarArgs.aS(3, this.FqM);
      paramVarArgs.aS(4, this.FqN);
      if (this.FqO != null) {
        paramVarArgs.d(5, this.FqO);
      }
      if (this.FqP != null)
      {
        paramVarArgs.lC(6, this.FqP.computeSize());
        this.FqP.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.OpCode);
      if (this.FqQ != null)
      {
        paramVarArgs.lC(8, this.FqQ.computeSize());
        this.FqQ.writeFields(paramVarArgs);
      }
      if (this.FqR != null)
      {
        paramVarArgs.lC(9, this.FqR.computeSize());
        this.FqR.writeFields(paramVarArgs);
      }
      if (this.FqS != null)
      {
        paramVarArgs.lC(10, this.FqS.computeSize());
        this.FqS.writeFields(paramVarArgs);
      }
      if (this.FqT != null)
      {
        paramVarArgs.lC(11, this.FqT.computeSize());
        this.FqT.writeFields(paramVarArgs);
      }
      if (this.FqU != null)
      {
        paramVarArgs.lC(12, this.FqU.computeSize());
        this.FqU.writeFields(paramVarArgs);
      }
      if (this.FqV != null) {
        paramVarArgs.d(13, this.FqV);
      }
      if (this.FqW != null) {
        paramVarArgs.d(14, this.FqW);
      }
      paramVarArgs.aS(15, this.FqX);
      AppMethodBeat.o(32097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1739;
      }
    }
    label1739:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FqL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FqL);
      }
      i = i + f.a.a.b.b.a.bz(3, this.FqM) + f.a.a.b.b.a.bz(4, this.FqN);
      paramInt = i;
      if (this.FqO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FqO);
      }
      i = paramInt;
      if (this.FqP != null) {
        i = paramInt + f.a.a.a.lB(6, this.FqP.computeSize());
      }
      i += f.a.a.b.b.a.bz(7, this.OpCode);
      paramInt = i;
      if (this.FqQ != null) {
        paramInt = i + f.a.a.a.lB(8, this.FqQ.computeSize());
      }
      i = paramInt;
      if (this.FqR != null) {
        i = paramInt + f.a.a.a.lB(9, this.FqR.computeSize());
      }
      paramInt = i;
      if (this.FqS != null) {
        paramInt = i + f.a.a.a.lB(10, this.FqS.computeSize());
      }
      i = paramInt;
      if (this.FqT != null) {
        i = paramInt + f.a.a.a.lB(11, this.FqT.computeSize());
      }
      paramInt = i;
      if (this.FqU != null) {
        paramInt = i + f.a.a.a.lB(12, this.FqU.computeSize());
      }
      i = paramInt;
      if (this.FqV != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FqV);
      }
      paramInt = i;
      if (this.FqW != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FqW);
      }
      i = f.a.a.b.b.a.bz(15, this.FqX);
      AppMethodBeat.o(32097);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32097);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32097);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32097);
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
            localad.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 2: 
          localad.FqL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 3: 
          localad.FqM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32097);
          return 0;
        case 4: 
          localad.FqN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32097);
          return 0;
        case 5: 
          localad.FqO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dej();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dej)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FqP = ((dej)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 7: 
          localad.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32097);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new css();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((css)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FqQ = ((css)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dej();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dej)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FqR = ((dej)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cov();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FqS = ((cov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ats();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ats)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FqT = ((ats)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.FqU = ((hu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 13: 
          localad.FqV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 14: 
          localad.FqW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32097);
          return 0;
        }
        localad.FqX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32097);
        return 0;
      }
      AppMethodBeat.o(32097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ad
 * JD-Core Version:    0.7.0.1
 */