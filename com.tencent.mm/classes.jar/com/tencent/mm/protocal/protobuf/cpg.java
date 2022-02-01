package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpg
  extends cwj
{
  public dok GQG;
  public ru GSz;
  public long GoT;
  public long GoU;
  public bpe Guc;
  public ccd HAT;
  public cwv HcC;
  public LinkedList<cji> cTY;
  public int oGt;
  public String oGu;
  
  public cpg()
  {
    AppMethodBeat.i(72560);
    this.cTY = new LinkedList();
    AppMethodBeat.o(72560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72561);
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
      if (this.Guc != null)
      {
        paramVarArgs.lJ(4, this.Guc.computeSize());
        this.Guc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.cTY);
      paramVarArgs.aZ(6, this.GoT);
      paramVarArgs.aZ(7, this.GoU);
      if (this.HcC != null)
      {
        paramVarArgs.lJ(8, this.HcC.computeSize());
        this.HcC.writeFields(paramVarArgs);
      }
      if (this.GSz != null)
      {
        paramVarArgs.lJ(9, this.GSz.computeSize());
        this.GSz.writeFields(paramVarArgs);
      }
      if (this.GQG != null)
      {
        paramVarArgs.lJ(10, this.GQG.computeSize());
        this.GQG.writeFields(paramVarArgs);
      }
      if (this.HAT != null)
      {
        paramVarArgs.lJ(11, this.HAT.computeSize());
        this.HAT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72561);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1470;
      }
    }
    label1470:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.Guc != null) {
        i = paramInt + f.a.a.a.lI(4, this.Guc.computeSize());
      }
      i = i + f.a.a.a.c(5, 8, this.cTY) + f.a.a.b.b.a.p(6, this.GoT) + f.a.a.b.b.a.p(7, this.GoU);
      paramInt = i;
      if (this.HcC != null) {
        paramInt = i + f.a.a.a.lI(8, this.HcC.computeSize());
      }
      i = paramInt;
      if (this.GSz != null) {
        i = paramInt + f.a.a.a.lI(9, this.GSz.computeSize());
      }
      paramInt = i;
      if (this.GQG != null) {
        paramInt = i + f.a.a.a.lI(10, this.GQG.computeSize());
      }
      i = paramInt;
      if (this.HAT != null) {
        i = paramInt + f.a.a.a.lI(11, this.HAT.computeSize());
      }
      AppMethodBeat.o(72561);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.cTY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72561);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpg localcpg = (cpg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72561);
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
            localcpg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 2: 
          localcpg.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72561);
          return 0;
        case 3: 
          localcpg.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72561);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpg.Guc = ((bpe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cji();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cji)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpg.cTY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 6: 
          localcpg.GoT = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72561);
          return 0;
        case 7: 
          localcpg.GoU = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72561);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpg.HcC = ((cwv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ru();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpg.GSz = ((ru)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dok();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpg.GQG = ((dok)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcpg.HAT = ((ccd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      AppMethodBeat.o(72561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpg
 * JD-Core Version:    0.7.0.1
 */