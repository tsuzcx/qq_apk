package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpm
  extends cwj
{
  public String CPZ;
  public av HAZ;
  public dno HBa;
  public clu HBb;
  public String HBc;
  public String HxN;
  public String HxO;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72565);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72565);
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
      if (this.HxN != null) {
        paramVarArgs.d(4, this.HxN);
      }
      if (this.HxO != null) {
        paramVarArgs.d(5, this.HxO);
      }
      if (this.HAZ != null)
      {
        paramVarArgs.lJ(6, this.HAZ.computeSize());
        this.HAZ.writeFields(paramVarArgs);
      }
      if (this.HBa != null)
      {
        paramVarArgs.lJ(7, this.HBa.computeSize());
        this.HBa.writeFields(paramVarArgs);
      }
      if (this.HBb != null)
      {
        paramVarArgs.lJ(8, this.HBb.computeSize());
        this.HBb.writeFields(paramVarArgs);
      }
      if (this.HBc != null) {
        paramVarArgs.d(9, this.HBc);
      }
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
      }
      AppMethodBeat.o(72565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1210;
      }
    }
    label1210:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.HxN != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HxN);
      }
      paramInt = i;
      if (this.HxO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HxO);
      }
      i = paramInt;
      if (this.HAZ != null) {
        i = paramInt + f.a.a.a.lI(6, this.HAZ.computeSize());
      }
      paramInt = i;
      if (this.HBa != null) {
        paramInt = i + f.a.a.a.lI(7, this.HBa.computeSize());
      }
      i = paramInt;
      if (this.HBb != null) {
        i = paramInt + f.a.a.a.lI(8, this.HBb.computeSize());
      }
      paramInt = i;
      if (this.HBc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HBc);
      }
      i = paramInt;
      if (this.CPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(72565);
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
          AppMethodBeat.o(72565);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpm localcpm = (cpm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72565);
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
            localcpm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 2: 
          localcpm.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72565);
          return 0;
        case 3: 
          localcpm.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 4: 
          localcpm.HxN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 5: 
          localcpm.HxO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72565);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new av();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((av)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpm.HAZ = ((av)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dno();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dno)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpm.HBa = ((dno)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpm.HBb = ((clu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72565);
          return 0;
        case 9: 
          localcpm.HBc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72565);
          return 0;
        }
        localcpm.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72565);
        return 0;
      }
      AppMethodBeat.o(72565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpm
 * JD-Core Version:    0.7.0.1
 */