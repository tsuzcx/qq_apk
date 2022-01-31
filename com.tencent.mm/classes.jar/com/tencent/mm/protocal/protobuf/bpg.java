package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bpg
  extends bvk
{
  public String cwc;
  public String fhP;
  public boolean xDj;
  public LinkedList<bgs> xDk;
  public boolean xDl;
  public int xDm;
  public int xDn;
  public String xDo;
  public String xDp;
  public LinkedList<bgv> xvT;
  public String xvU;
  
  public bpg()
  {
    AppMethodBeat.i(10232);
    this.xvT = new LinkedList();
    this.xDk = new LinkedList();
    AppMethodBeat.o(10232);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10233);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(10233);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xDj);
      paramVarArgs.e(3, 8, this.xvT);
      if (this.cwc != null) {
        paramVarArgs.e(4, this.cwc);
      }
      if (this.fhP != null) {
        paramVarArgs.e(5, this.fhP);
      }
      if (this.xvU != null) {
        paramVarArgs.e(6, this.xvU);
      }
      paramVarArgs.e(7, 8, this.xDk);
      paramVarArgs.aS(8, this.xDl);
      paramVarArgs.aO(9, this.xDm);
      paramVarArgs.aO(10, this.xDn);
      if (this.xDo != null) {
        paramVarArgs.e(11, this.xDo);
      }
      if (this.xDp != null) {
        paramVarArgs.e(12, this.xDp);
      }
      AppMethodBeat.o(10233);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1136;
      }
    }
    label1136:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 1) + e.a.a.a.c(3, 8, this.xvT);
      paramInt = i;
      if (this.cwc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.cwc);
      }
      i = paramInt;
      if (this.fhP != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.fhP);
      }
      paramInt = i;
      if (this.xvU != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xvU);
      }
      i = paramInt + e.a.a.a.c(7, 8, this.xDk) + (e.a.a.b.b.a.eW(8) + 1) + e.a.a.b.b.a.bl(9, this.xDm) + e.a.a.b.b.a.bl(10, this.xDn);
      paramInt = i;
      if (this.xDo != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xDo);
      }
      i = paramInt;
      if (this.xDp != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xDp);
      }
      AppMethodBeat.o(10233);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xvT.clear();
        this.xDk.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(10233);
          throw paramVarArgs;
        }
        AppMethodBeat.o(10233);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bpg localbpg = (bpg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10233);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10233);
          return 0;
        case 2: 
          localbpg.xDj = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(10233);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpg.xvT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10233);
          return 0;
        case 4: 
          localbpg.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10233);
          return 0;
        case 5: 
          localbpg.fhP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10233);
          return 0;
        case 6: 
          localbpg.xvU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10233);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgs();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbpg.xDk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10233);
          return 0;
        case 8: 
          localbpg.xDl = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(10233);
          return 0;
        case 9: 
          localbpg.xDm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10233);
          return 0;
        case 10: 
          localbpg.xDn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10233);
          return 0;
        case 11: 
          localbpg.xDo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10233);
          return 0;
        }
        localbpg.xDp = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(10233);
        return 0;
      }
      AppMethodBeat.o(10233);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpg
 * JD-Core Version:    0.7.0.1
 */