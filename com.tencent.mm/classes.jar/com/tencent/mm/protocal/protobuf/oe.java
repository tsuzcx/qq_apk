package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class oe
  extends cwj
{
  public long GbK;
  public int GbL;
  public int GbM;
  public long GbN;
  public int GbO;
  public LinkedList<oc> GbP;
  public int GbQ;
  public LinkedList<csk> GbR;
  public String Gbi;
  public int dEu;
  public int nzX;
  
  public oe()
  {
    AppMethodBeat.i(124440);
    this.GbP = new LinkedList();
    this.GbR = new LinkedList();
    AppMethodBeat.o(124440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124441);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.GbK);
      paramVarArgs.aS(3, this.GbL);
      paramVarArgs.aS(4, this.GbM);
      paramVarArgs.aZ(5, this.GbN);
      paramVarArgs.aS(6, this.GbO);
      paramVarArgs.e(7, 8, this.GbP);
      paramVarArgs.aS(8, this.GbQ);
      if (this.Gbi != null) {
        paramVarArgs.d(9, this.Gbi);
      }
      paramVarArgs.aS(10, this.nzX);
      paramVarArgs.aS(11, this.dEu);
      paramVarArgs.e(12, 8, this.GbR);
      AppMethodBeat.o(124441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1058;
      }
    }
    label1058:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GbK) + f.a.a.b.b.a.bz(3, this.GbL) + f.a.a.b.b.a.bz(4, this.GbM) + f.a.a.b.b.a.p(5, this.GbN) + f.a.a.b.b.a.bz(6, this.GbO) + f.a.a.a.c(7, 8, this.GbP) + f.a.a.b.b.a.bz(8, this.GbQ);
      paramInt = i;
      if (this.Gbi != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Gbi);
      }
      i = f.a.a.b.b.a.bz(10, this.nzX);
      int j = f.a.a.b.b.a.bz(11, this.dEu);
      int k = f.a.a.a.c(12, 8, this.GbR);
      AppMethodBeat.o(124441);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GbP.clear();
        this.GbR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oe localoe = (oe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124441);
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
            localoe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 2: 
          localoe.GbK = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124441);
          return 0;
        case 3: 
          localoe.GbL = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124441);
          return 0;
        case 4: 
          localoe.GbM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124441);
          return 0;
        case 5: 
          localoe.GbN = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(124441);
          return 0;
        case 6: 
          localoe.GbO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124441);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localoe.GbP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 8: 
          localoe.GbQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124441);
          return 0;
        case 9: 
          localoe.Gbi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124441);
          return 0;
        case 10: 
          localoe.nzX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124441);
          return 0;
        case 11: 
          localoe.dEu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124441);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((csk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localoe.GbR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124441);
        return 0;
      }
      AppMethodBeat.o(124441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oe
 * JD-Core Version:    0.7.0.1
 */