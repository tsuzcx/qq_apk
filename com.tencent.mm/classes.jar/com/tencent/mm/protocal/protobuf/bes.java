package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bes
  extends cwj
{
  public int GQC;
  public int GQD;
  public tr GQE;
  public int GQy;
  public tc GQz;
  public tg GTO;
  public sz GTP;
  public String GTQ;
  public tf GTR;
  public int oGt;
  public String oGu;
  public int pqB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114029);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114029);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.aS(4, this.pqB);
      paramVarArgs.aS(5, this.GQy);
      if (this.GQz != null)
      {
        paramVarArgs.lJ(6, this.GQz.computeSize());
        this.GQz.writeFields(paramVarArgs);
      }
      if (this.GTO != null)
      {
        paramVarArgs.lJ(7, this.GTO.computeSize());
        this.GTO.writeFields(paramVarArgs);
      }
      if (this.GTP != null)
      {
        paramVarArgs.lJ(8, this.GTP.computeSize());
        this.GTP.writeFields(paramVarArgs);
      }
      if (this.GTQ != null) {
        paramVarArgs.d(10, this.GTQ);
      }
      paramVarArgs.aS(11, this.GQC);
      paramVarArgs.aS(12, this.GQD);
      if (this.GQE != null)
      {
        paramVarArgs.lJ(13, this.GQE.computeSize());
        this.GQE.writeFields(paramVarArgs);
      }
      if (this.GTR != null)
      {
        paramVarArgs.lJ(14, this.GTR.computeSize());
        this.GTR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.pqB) + f.a.a.b.b.a.bz(5, this.GQy);
      paramInt = i;
      if (this.GQz != null) {
        paramInt = i + f.a.a.a.lI(6, this.GQz.computeSize());
      }
      i = paramInt;
      if (this.GTO != null) {
        i = paramInt + f.a.a.a.lI(7, this.GTO.computeSize());
      }
      paramInt = i;
      if (this.GTP != null) {
        paramInt = i + f.a.a.a.lI(8, this.GTP.computeSize());
      }
      i = paramInt;
      if (this.GTQ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GTQ);
      }
      i = i + f.a.a.b.b.a.bz(11, this.GQC) + f.a.a.b.b.a.bz(12, this.GQD);
      paramInt = i;
      if (this.GQE != null) {
        paramInt = i + f.a.a.a.lI(13, this.GQE.computeSize());
      }
      i = paramInt;
      if (this.GTR != null) {
        i = paramInt + f.a.a.a.lI(14, this.GTR.computeSize());
      }
      AppMethodBeat.o(114029);
      return i;
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
          AppMethodBeat.o(114029);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bes localbes = (bes)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(114029);
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
            localbes.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 2: 
          localbes.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114029);
          return 0;
        case 3: 
          localbes.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 4: 
          localbes.pqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114029);
          return 0;
        case 5: 
          localbes.GQy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114029);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbes.GQz = ((tc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbes.GTO = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbes.GTP = ((sz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 10: 
          localbes.GTQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 11: 
          localbes.GQC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114029);
          return 0;
        case 12: 
          localbes.GQD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114029);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbes.GQE = ((tr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbes.GTR = ((tf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      AppMethodBeat.o(114029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bes
 * JD-Core Version:    0.7.0.1
 */