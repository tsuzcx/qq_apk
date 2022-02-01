package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class beu
  extends cwj
{
  public int GQy;
  public sz GTP;
  public te GTS;
  public tb GTT;
  public String GTU;
  public int oGt;
  public String oGu;
  public int pqB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(218617);
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
      if (this.GTS != null)
      {
        paramVarArgs.lJ(4, this.GTS.computeSize());
        this.GTS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.pqB);
      paramVarArgs.aS(6, this.GQy);
      if (this.GTT != null)
      {
        paramVarArgs.lJ(7, this.GTT.computeSize());
        this.GTT.writeFields(paramVarArgs);
      }
      if (this.GTP != null)
      {
        paramVarArgs.lJ(8, this.GTP.computeSize());
        this.GTP.writeFields(paramVarArgs);
      }
      if (this.GTU != null) {
        paramVarArgs.d(9, this.GTU);
      }
      AppMethodBeat.o(218617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.GTS != null) {
        i = paramInt + f.a.a.a.lI(4, this.GTS.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(5, this.pqB) + f.a.a.b.b.a.bz(6, this.GQy);
      paramInt = i;
      if (this.GTT != null) {
        paramInt = i + f.a.a.a.lI(7, this.GTT.computeSize());
      }
      i = paramInt;
      if (this.GTP != null) {
        i = paramInt + f.a.a.a.lI(8, this.GTP.computeSize());
      }
      paramInt = i;
      if (this.GTU != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GTU);
      }
      AppMethodBeat.o(218617);
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
          AppMethodBeat.o(218617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(218617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        beu localbeu = (beu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218617);
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
            localbeu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218617);
          return 0;
        case 2: 
          localbeu.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218617);
          return 0;
        case 3: 
          localbeu.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218617);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new te();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((te)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeu.GTS = ((te)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218617);
          return 0;
        case 5: 
          localbeu.pqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218617);
          return 0;
        case 6: 
          localbeu.GQy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218617);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbeu.GTT = ((tb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218617);
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
            localbeu.GTP = ((sz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218617);
          return 0;
        }
        localbeu.GTU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(218617);
        return 0;
      }
      AppMethodBeat.o(218617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beu
 * JD-Core Version:    0.7.0.1
 */