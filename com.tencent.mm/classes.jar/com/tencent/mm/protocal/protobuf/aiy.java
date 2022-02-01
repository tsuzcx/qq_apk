package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aiy
  extends cwj
{
  public cru Gmp;
  public bqo GyE;
  public int dPd;
  public int dPe;
  public int dmy;
  public int doQ;
  public String phe;
  public String vAE;
  public String vwq;
  public String vxA;
  public String vxB;
  public String vxC;
  public int vxD;
  public String vxE;
  public String vxF;
  public int vxx;
  public int vxz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91453);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      paramVarArgs.aS(4, this.doQ);
      if (this.vwq != null) {
        paramVarArgs.d(5, this.vwq);
      }
      paramVarArgs.aS(6, this.dPd);
      paramVarArgs.aS(7, this.dPe);
      if (this.vAE != null) {
        paramVarArgs.d(8, this.vAE);
      }
      paramVarArgs.aS(9, this.vxx);
      if (this.Gmp != null)
      {
        paramVarArgs.lJ(10, this.Gmp.computeSize());
        this.Gmp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.vxz);
      if (this.vxA != null) {
        paramVarArgs.d(12, this.vxA);
      }
      if (this.vxB != null) {
        paramVarArgs.d(13, this.vxB);
      }
      if (this.vxC != null) {
        paramVarArgs.d(14, this.vxC);
      }
      paramVarArgs.aS(15, this.vxD);
      if (this.vxE != null) {
        paramVarArgs.d(16, this.vxE);
      }
      if (this.vxF != null) {
        paramVarArgs.d(17, this.vxF);
      }
      if (this.GyE != null)
      {
        paramVarArgs.lJ(18, this.GyE.computeSize());
        this.GyE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1478;
      }
    }
    label1478:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.doQ);
      paramInt = i;
      if (this.vwq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vwq);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.dPd) + f.a.a.b.b.a.bz(7, this.dPe);
      paramInt = i;
      if (this.vAE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.vAE);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.vxx);
      paramInt = i;
      if (this.Gmp != null) {
        paramInt = i + f.a.a.a.lI(10, this.Gmp.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.vxz);
      paramInt = i;
      if (this.vxA != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.vxA);
      }
      i = paramInt;
      if (this.vxB != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.vxB);
      }
      paramInt = i;
      if (this.vxC != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.vxC);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.vxD);
      paramInt = i;
      if (this.vxE != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.vxE);
      }
      i = paramInt;
      if (this.vxF != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.vxF);
      }
      paramInt = i;
      if (this.GyE != null) {
        paramInt = i + f.a.a.a.lI(18, this.GyE.computeSize());
      }
      AppMethodBeat.o(91453);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aiy localaiy = (aiy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91453);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaiy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 2: 
          localaiy.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 3: 
          localaiy.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 4: 
          localaiy.doQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 5: 
          localaiy.vwq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 6: 
          localaiy.dPd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 7: 
          localaiy.dPe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 8: 
          localaiy.vAE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 9: 
          localaiy.vxx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cru();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaiy.Gmp = ((cru)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 11: 
          localaiy.vxz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 12: 
          localaiy.vxA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 13: 
          localaiy.vxB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 14: 
          localaiy.vxC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 15: 
          localaiy.vxD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91453);
          return 0;
        case 16: 
          localaiy.vxE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 17: 
          localaiy.vxF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91453);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaiy.GyE = ((bqo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91453);
        return 0;
      }
      AppMethodBeat.o(91453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiy
 * JD-Core Version:    0.7.0.1
 */