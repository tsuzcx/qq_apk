package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vy
  extends bvk
{
  public String gfM;
  public String wOA;
  public String wOB;
  public LinkedList<bib> wpb;
  
  public vy()
  {
    AppMethodBeat.i(80040);
    this.wpb = new LinkedList();
    AppMethodBeat.o(80040);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80041);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.gfM != null) {
        paramVarArgs.e(2, this.gfM);
      }
      paramVarArgs.e(3, 8, this.wpb);
      if (this.wOA != null) {
        paramVarArgs.e(4, this.wOA);
      }
      if (this.wOB != null) {
        paramVarArgs.e(5, this.wOB);
      }
      AppMethodBeat.o(80041);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gfM != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.gfM);
      }
      i += e.a.a.a.c(3, 8, this.wpb);
      paramInt = i;
      if (this.wOA != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wOA);
      }
      i = paramInt;
      if (this.wOB != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wOB);
      }
      AppMethodBeat.o(80041);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wpb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80041);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vy localvy = (vy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80041);
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
            localvy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80041);
          return 0;
        case 2: 
          localvy.gfM = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80041);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bib();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bib)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvy.wpb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80041);
          return 0;
        case 4: 
          localvy.wOA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80041);
          return 0;
        }
        localvy.wOB = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80041);
        return 0;
      }
      AppMethodBeat.o(80041);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vy
 * JD-Core Version:    0.7.0.1
 */