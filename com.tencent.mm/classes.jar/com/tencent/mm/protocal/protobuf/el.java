package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class el
  extends bvk
{
  public String fgl;
  public String url;
  public int wqA;
  public int wqB;
  public dy wqC;
  public cqv wqD;
  public String wqE;
  public bca wqF;
  public ei wqG;
  public LinkedList<ev> wqw;
  public int wqx;
  public String wqy;
  public int wqz;
  
  public el()
  {
    AppMethodBeat.i(14694);
    this.wqw = new LinkedList();
    AppMethodBeat.o(14694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14695);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(14695);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.wqw);
      paramVarArgs.aO(3, this.wqx);
      if (this.wqy != null) {
        paramVarArgs.e(4, this.wqy);
      }
      paramVarArgs.aO(5, this.wqz);
      paramVarArgs.aO(6, this.wqA);
      paramVarArgs.aO(7, this.wqB);
      if (this.wqC != null)
      {
        paramVarArgs.iQ(8, this.wqC.computeSize());
        this.wqC.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(9, this.url);
      }
      if (this.fgl != null) {
        paramVarArgs.e(10, this.fgl);
      }
      if (this.wqD != null)
      {
        paramVarArgs.iQ(11, this.wqD.computeSize());
        this.wqD.writeFields(paramVarArgs);
      }
      if (this.wqE != null) {
        paramVarArgs.e(12, this.wqE);
      }
      if (this.wqF != null)
      {
        paramVarArgs.iQ(13, this.wqF.computeSize());
        this.wqF.writeFields(paramVarArgs);
      }
      if (this.wqG != null)
      {
        paramVarArgs.iQ(14, this.wqG.computeSize());
        this.wqG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(14695);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1566;
      }
    }
    label1566:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.wqw) + e.a.a.b.b.a.bl(3, this.wqx);
      paramInt = i;
      if (this.wqy != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wqy);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wqz) + e.a.a.b.b.a.bl(6, this.wqA) + e.a.a.b.b.a.bl(7, this.wqB);
      paramInt = i;
      if (this.wqC != null) {
        paramInt = i + e.a.a.a.iP(8, this.wqC.computeSize());
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.url);
      }
      paramInt = i;
      if (this.fgl != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.fgl);
      }
      i = paramInt;
      if (this.wqD != null) {
        i = paramInt + e.a.a.a.iP(11, this.wqD.computeSize());
      }
      paramInt = i;
      if (this.wqE != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wqE);
      }
      i = paramInt;
      if (this.wqF != null) {
        i = paramInt + e.a.a.a.iP(13, this.wqF.computeSize());
      }
      paramInt = i;
      if (this.wqG != null) {
        paramInt = i + e.a.a.a.iP(14, this.wqG.computeSize());
      }
      AppMethodBeat.o(14695);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wqw.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(14695);
          throw paramVarArgs;
        }
        AppMethodBeat.o(14695);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        el localel = (el)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(14695);
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
            localel.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14695);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ev();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ev)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localel.wqw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14695);
          return 0;
        case 3: 
          localel.wqx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14695);
          return 0;
        case 4: 
          localel.wqy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14695);
          return 0;
        case 5: 
          localel.wqz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14695);
          return 0;
        case 6: 
          localel.wqA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14695);
          return 0;
        case 7: 
          localel.wqB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14695);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dy();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localel.wqC = ((dy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14695);
          return 0;
        case 9: 
          localel.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14695);
          return 0;
        case 10: 
          localel.fgl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14695);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localel.wqD = ((cqv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14695);
          return 0;
        case 12: 
          localel.wqE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14695);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bca();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bca)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localel.wqF = ((bca)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14695);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ei();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ei)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localel.wqG = ((ei)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(14695);
        return 0;
      }
      AppMethodBeat.o(14695);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.el
 * JD-Core Version:    0.7.0.1
 */