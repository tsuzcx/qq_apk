package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ta
  extends bvk
{
  public String Md5;
  public int Version;
  public int wLx;
  public LinkedList<ckj> wLy;
  public int wLz;
  public String wyV;
  
  public ta()
  {
    AppMethodBeat.i(14721);
    this.wLy = new LinkedList();
    AppMethodBeat.o(14721);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14722);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(14722);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.Version);
      if (this.wyV != null) {
        paramVarArgs.e(3, this.wyV);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(4, this.Md5);
      }
      paramVarArgs.aO(5, this.wLx);
      paramVarArgs.e(6, 8, this.wLy);
      paramVarArgs.aO(7, this.wLz);
      AppMethodBeat.o(14722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.Version);
      paramInt = i;
      if (this.wyV != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wyV);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.Md5);
      }
      paramInt = e.a.a.b.b.a.bl(5, this.wLx);
      int j = e.a.a.a.c(6, 8, this.wLy);
      int k = e.a.a.b.b.a.bl(7, this.wLz);
      AppMethodBeat.o(14722);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wLy.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(14722);
          throw paramVarArgs;
        }
        AppMethodBeat.o(14722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ta localta = (ta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(14722);
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
            localta.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14722);
          return 0;
        case 2: 
          localta.Version = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14722);
          return 0;
        case 3: 
          localta.wyV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14722);
          return 0;
        case 4: 
          localta.Md5 = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14722);
          return 0;
        case 5: 
          localta.wLx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14722);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localta.wLy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(14722);
          return 0;
        }
        localta.wLz = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(14722);
        return 0;
      }
      AppMethodBeat.o(14722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ta
 * JD-Core Version:    0.7.0.1
 */