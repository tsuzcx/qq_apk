package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ajl
  extends cwj
{
  public LinkedList<btn> GmO;
  public cnh GyO;
  public String GyP;
  public String GyQ;
  public String GyR;
  public String GyS;
  public float GyT;
  public String GyU;
  public int roq;
  public String ror;
  
  public ajl()
  {
    AppMethodBeat.i(104361);
    this.GmO = new LinkedList();
    AppMethodBeat.o(104361);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104362);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104362);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GmO);
      if (this.GyO != null)
      {
        paramVarArgs.lJ(3, this.GyO.computeSize());
        this.GyO.writeFields(paramVarArgs);
      }
      if (this.GyP != null) {
        paramVarArgs.d(4, this.GyP);
      }
      if (this.GyQ != null) {
        paramVarArgs.d(5, this.GyQ);
      }
      if (this.GyR != null) {
        paramVarArgs.d(6, this.GyR);
      }
      if (this.GyS != null) {
        paramVarArgs.d(7, this.GyS);
      }
      paramVarArgs.y(8, this.GyT);
      paramVarArgs.aS(9, this.roq);
      if (this.ror != null) {
        paramVarArgs.d(10, this.ror);
      }
      if (this.GyU != null) {
        paramVarArgs.d(11, this.GyU);
      }
      AppMethodBeat.o(104362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1109;
      }
    }
    label1109:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GmO);
      paramInt = i;
      if (this.GyO != null) {
        paramInt = i + f.a.a.a.lI(3, this.GyO.computeSize());
      }
      i = paramInt;
      if (this.GyP != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GyP);
      }
      paramInt = i;
      if (this.GyQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GyQ);
      }
      i = paramInt;
      if (this.GyR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GyR);
      }
      paramInt = i;
      if (this.GyS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GyS);
      }
      i = paramInt + f.a.a.b.b.a.amE(8) + f.a.a.b.b.a.bz(9, this.roq);
      paramInt = i;
      if (this.ror != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ror);
      }
      i = paramInt;
      if (this.GyU != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GyU);
      }
      AppMethodBeat.o(104362);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GmO.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104362);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajl localajl = (ajl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104362);
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
            localajl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajl.GmO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajl.GyO = ((cnh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104362);
          return 0;
        case 4: 
          localajl.GyP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 5: 
          localajl.GyQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 6: 
          localajl.GyR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 7: 
          localajl.GyS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104362);
          return 0;
        case 8: 
          localajl.GyT = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(104362);
          return 0;
        case 9: 
          localajl.roq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104362);
          return 0;
        case 10: 
          localajl.ror = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104362);
          return 0;
        }
        localajl.GyU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(104362);
        return 0;
      }
      AppMethodBeat.o(104362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajl
 * JD-Core Version:    0.7.0.1
 */