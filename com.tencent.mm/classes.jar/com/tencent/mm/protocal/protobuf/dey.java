package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dey
  extends cwj
{
  public he HKf;
  public int HLY;
  public hd HLZ;
  public String HMa;
  public LinkedList<hf> HMb;
  public String HMc;
  public String HMd;
  public hg HMe;
  public LinkedList<hg> HMf;
  public dwg HMg;
  public boolean HMh;
  public String HMi;
  public hc HMj;
  public String HqM;
  public String dqk;
  public String hDU;
  public String title;
  
  public dey()
  {
    AppMethodBeat.i(123652);
    this.HMb = new LinkedList();
    this.HMf = new LinkedList();
    AppMethodBeat.o(123652);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123653);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HKf != null)
      {
        paramVarArgs.lJ(2, this.HKf.computeSize());
        this.HKf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.HLY);
      if (this.HLZ != null)
      {
        paramVarArgs.lJ(4, this.HLZ.computeSize());
        this.HLZ.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.HqM != null) {
        paramVarArgs.d(6, this.HqM);
      }
      if (this.hDU != null) {
        paramVarArgs.d(7, this.hDU);
      }
      if (this.HMa != null) {
        paramVarArgs.d(8, this.HMa);
      }
      paramVarArgs.e(9, 8, this.HMb);
      if (this.HMc != null) {
        paramVarArgs.d(10, this.HMc);
      }
      if (this.HMd != null) {
        paramVarArgs.d(11, this.HMd);
      }
      if (this.HMe != null)
      {
        paramVarArgs.lJ(12, this.HMe.computeSize());
        this.HMe.writeFields(paramVarArgs);
      }
      paramVarArgs.e(13, 8, this.HMf);
      if (this.dqk != null) {
        paramVarArgs.d(14, this.dqk);
      }
      if (this.HMg != null)
      {
        paramVarArgs.lJ(15, this.HMg.computeSize());
        this.HMg.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(16, this.HMh);
      if (this.HMi != null) {
        paramVarArgs.d(17, this.HMi);
      }
      if (this.HMj != null)
      {
        paramVarArgs.lJ(19, this.HMj.computeSize());
        this.HMj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2002;
      }
    }
    label2002:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HKf != null) {
        i = paramInt + f.a.a.a.lI(2, this.HKf.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.HLY);
      paramInt = i;
      if (this.HLZ != null) {
        paramInt = i + f.a.a.a.lI(4, this.HLZ.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      paramInt = i;
      if (this.HqM != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HqM);
      }
      i = paramInt;
      if (this.hDU != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hDU);
      }
      paramInt = i;
      if (this.HMa != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HMa);
      }
      i = paramInt + f.a.a.a.c(9, 8, this.HMb);
      paramInt = i;
      if (this.HMc != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HMc);
      }
      i = paramInt;
      if (this.HMd != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.HMd);
      }
      paramInt = i;
      if (this.HMe != null) {
        paramInt = i + f.a.a.a.lI(12, this.HMe.computeSize());
      }
      i = paramInt + f.a.a.a.c(13, 8, this.HMf);
      paramInt = i;
      if (this.dqk != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.dqk);
      }
      i = paramInt;
      if (this.HMg != null) {
        i = paramInt + f.a.a.a.lI(15, this.HMg.computeSize());
      }
      i += f.a.a.b.b.a.amF(16);
      paramInt = i;
      if (this.HMi != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.HMi);
      }
      i = paramInt;
      if (this.HMj != null) {
        i = paramInt + f.a.a.a.lI(19, this.HMj.computeSize());
      }
      AppMethodBeat.o(123653);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HMb.clear();
        this.HMf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123653);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dey localdey = (dey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(123653);
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
            localdey.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new he();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((he)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdey.HKf = ((he)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 3: 
          localdey.HLY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123653);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdey.HLZ = ((hd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 5: 
          localdey.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 6: 
          localdey.HqM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 7: 
          localdey.hDU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 8: 
          localdey.HMa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdey.HMb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 10: 
          localdey.HMc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 11: 
          localdey.HMd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdey.HMe = ((hg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdey.HMf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 14: 
          localdey.dqk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdey.HMg = ((dwg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 16: 
          localdey.HMh = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(123653);
          return 0;
        case 17: 
          localdey.HMi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(123653);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdey.HMj = ((hc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      AppMethodBeat.o(123653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dey
 * JD-Core Version:    0.7.0.1
 */