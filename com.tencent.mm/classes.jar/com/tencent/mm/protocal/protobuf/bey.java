package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bey
  extends cwj
{
  public int GQy;
  public cik GTX;
  public cil GTY;
  public cil GTZ;
  public cim GUa;
  public int oGt;
  public String oGu;
  public int pqB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114033);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114033);
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
      if (this.GTX != null)
      {
        paramVarArgs.lJ(6, this.GTX.computeSize());
        this.GTX.writeFields(paramVarArgs);
      }
      if (this.GTY != null)
      {
        paramVarArgs.lJ(7, this.GTY.computeSize());
        this.GTY.writeFields(paramVarArgs);
      }
      if (this.GTZ != null)
      {
        paramVarArgs.lJ(8, this.GTZ.computeSize());
        this.GTZ.writeFields(paramVarArgs);
      }
      if (this.GUa != null)
      {
        paramVarArgs.lJ(9, this.GUa.computeSize());
        this.GUa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114033);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1174;
      }
    }
    label1174:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.pqB) + f.a.a.b.b.a.bz(5, this.GQy);
      paramInt = i;
      if (this.GTX != null) {
        paramInt = i + f.a.a.a.lI(6, this.GTX.computeSize());
      }
      i = paramInt;
      if (this.GTY != null) {
        i = paramInt + f.a.a.a.lI(7, this.GTY.computeSize());
      }
      paramInt = i;
      if (this.GTZ != null) {
        paramInt = i + f.a.a.a.lI(8, this.GTZ.computeSize());
      }
      i = paramInt;
      if (this.GUa != null) {
        i = paramInt + f.a.a.a.lI(9, this.GUa.computeSize());
      }
      AppMethodBeat.o(114033);
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
          AppMethodBeat.o(114033);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114033);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bey localbey = (bey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114033);
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
            localbey.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 2: 
          localbey.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114033);
          return 0;
        case 3: 
          localbey.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114033);
          return 0;
        case 4: 
          localbey.pqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114033);
          return 0;
        case 5: 
          localbey.GQy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114033);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cik();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cik)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbey.GTX = ((cik)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cil();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cil)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbey.GTY = ((cil)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cil();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cil)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbey.GTZ = ((cil)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cim();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cim)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbey.GUa = ((cim)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114033);
        return 0;
      }
      AppMethodBeat.o(114033);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bey
 * JD-Core Version:    0.7.0.1
 */