package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bqm
  extends cwj
{
  public cqt FZD;
  public String FZx;
  public String GtG;
  public String GtH;
  public int GtI;
  public auj GtJ;
  public ni GtK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124518);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124518);
        throw paramVarArgs;
      }
      if (this.FZD == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(124518);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FZD != null)
      {
        paramVarArgs.lJ(2, this.FZD.computeSize());
        this.FZD.writeFields(paramVarArgs);
      }
      if (this.FZx != null) {
        paramVarArgs.d(3, this.FZx);
      }
      paramVarArgs.aS(4, this.GtI);
      if (this.GtJ != null)
      {
        paramVarArgs.lJ(5, this.GtJ.computeSize());
        this.GtJ.writeFields(paramVarArgs);
      }
      if (this.GtK != null)
      {
        paramVarArgs.lJ(6, this.GtK.computeSize());
        this.GtK.writeFields(paramVarArgs);
      }
      if (this.GtG != null) {
        paramVarArgs.d(7, this.GtG);
      }
      if (this.GtH != null) {
        paramVarArgs.d(8, this.GtH);
      }
      AppMethodBeat.o(124518);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1098;
      }
    }
    label1098:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FZD != null) {
        paramInt = i + f.a.a.a.lI(2, this.FZD.computeSize());
      }
      i = paramInt;
      if (this.FZx != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FZx);
      }
      i += f.a.a.b.b.a.bz(4, this.GtI);
      paramInt = i;
      if (this.GtJ != null) {
        paramInt = i + f.a.a.a.lI(5, this.GtJ.computeSize());
      }
      i = paramInt;
      if (this.GtK != null) {
        i = paramInt + f.a.a.a.lI(6, this.GtK.computeSize());
      }
      paramInt = i;
      if (this.GtG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GtG);
      }
      i = paramInt;
      if (this.GtH != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GtH);
      }
      AppMethodBeat.o(124518);
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
          AppMethodBeat.o(124518);
          throw paramVarArgs;
        }
        if (this.FZD == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(124518);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124518);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bqm localbqm = (bqm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124518);
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
            localbqm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqm.FZD = ((cqt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 3: 
          localbqm.FZx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124518);
          return 0;
        case 4: 
          localbqm.GtI = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124518);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((auj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqm.GtJ = ((auj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ni();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ni)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbqm.GtK = ((ni)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124518);
          return 0;
        case 7: 
          localbqm.GtG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124518);
          return 0;
        }
        localbqm.GtH = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124518);
        return 0;
      }
      AppMethodBeat.o(124518);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqm
 * JD-Core Version:    0.7.0.1
 */