package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bcb
  extends dpc
{
  public LinkedList<bdu> LLh;
  public int LLi;
  public int LLj;
  public LinkedList<azl> LLk;
  public int LLl;
  public int continueFlag;
  public String dPI;
  public int offset;
  public b tVM;
  public LinkedList<FinderObject> tbD;
  public LinkedList<bbz> zns;
  
  public bcb()
  {
    AppMethodBeat.i(169049);
    this.zns = new LinkedList();
    this.tbD = new LinkedList();
    this.LLh = new LinkedList();
    this.LLk = new LinkedList();
    AppMethodBeat.o(169049);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169050);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.zns);
      paramVarArgs.aM(3, this.offset);
      paramVarArgs.aM(4, this.continueFlag);
      paramVarArgs.e(5, 8, this.tbD);
      if (this.tVM != null) {
        paramVarArgs.c(6, this.tVM);
      }
      if (this.dPI != null) {
        paramVarArgs.e(7, this.dPI);
      }
      paramVarArgs.e(8, 8, this.LLh);
      paramVarArgs.aM(9, this.LLi);
      paramVarArgs.aM(10, this.LLj);
      paramVarArgs.e(11, 8, this.LLk);
      paramVarArgs.aM(12, this.LLl);
      AppMethodBeat.o(169050);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1226;
      }
    }
    label1226:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.zns) + g.a.a.b.b.a.bu(3, this.offset) + g.a.a.b.b.a.bu(4, this.continueFlag) + g.a.a.a.c(5, 8, this.tbD);
      paramInt = i;
      if (this.tVM != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.tVM);
      }
      i = paramInt;
      if (this.dPI != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.dPI);
      }
      paramInt = g.a.a.a.c(8, 8, this.LLh);
      int j = g.a.a.b.b.a.bu(9, this.LLi);
      int k = g.a.a.b.b.a.bu(10, this.LLj);
      int m = g.a.a.a.c(11, 8, this.LLk);
      int n = g.a.a.b.b.a.bu(12, this.LLl);
      AppMethodBeat.o(169050);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.zns.clear();
        this.tbD.clear();
        this.LLh.clear();
        this.LLk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169050);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bcb localbcb = (bcb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169050);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bbz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bbz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcb.zns.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 3: 
          localbcb.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169050);
          return 0;
        case 4: 
          localbcb.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169050);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcb.tbD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 6: 
          localbcb.tVM = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(169050);
          return 0;
        case 7: 
          localbcb.dPI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169050);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcb.LLh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        case 9: 
          localbcb.LLi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169050);
          return 0;
        case 10: 
          localbcb.LLj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169050);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbcb.LLk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169050);
          return 0;
        }
        localbcb.LLl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169050);
        return 0;
      }
      AppMethodBeat.o(169050);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcb
 * JD-Core Version:    0.7.0.1
 */