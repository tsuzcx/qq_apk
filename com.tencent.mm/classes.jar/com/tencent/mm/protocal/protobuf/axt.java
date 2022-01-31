package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class axt
  extends bvk
{
  public String ntp;
  public LinkedList<bwv> wYt;
  public String wnz;
  public axe xmS;
  public String xmU;
  public String xmV;
  public String xmW;
  
  public axt()
  {
    AppMethodBeat.i(96257);
    this.wYt = new LinkedList();
    AppMethodBeat.o(96257);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96258);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96258);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xmS != null)
      {
        paramVarArgs.iQ(2, this.xmS.computeSize());
        this.xmS.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.wYt);
      if (this.ntp != null) {
        paramVarArgs.e(4, this.ntp);
      }
      if (this.wnz != null) {
        paramVarArgs.e(5, this.wnz);
      }
      if (this.xmU != null) {
        paramVarArgs.e(6, this.xmU);
      }
      if (this.xmV != null) {
        paramVarArgs.e(7, this.xmV);
      }
      if (this.xmW != null) {
        paramVarArgs.e(8, this.xmW);
      }
      AppMethodBeat.o(96258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xmS != null) {
        i = paramInt + e.a.a.a.iP(2, this.xmS.computeSize());
      }
      i += e.a.a.a.c(3, 8, this.wYt);
      paramInt = i;
      if (this.ntp != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntp);
      }
      i = paramInt;
      if (this.wnz != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wnz);
      }
      paramInt = i;
      if (this.xmU != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xmU);
      }
      i = paramInt;
      if (this.xmV != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xmV);
      }
      paramInt = i;
      if (this.xmW != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xmW);
      }
      AppMethodBeat.o(96258);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wYt.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(96258);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96258);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axt localaxt = (axt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96258);
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
            localaxt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96258);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axe();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axe)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxt.xmS = ((axe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96258);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaxt.wYt.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96258);
          return 0;
        case 4: 
          localaxt.ntp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96258);
          return 0;
        case 5: 
          localaxt.wnz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96258);
          return 0;
        case 6: 
          localaxt.xmU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96258);
          return 0;
        case 7: 
          localaxt.xmV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96258);
          return 0;
        }
        localaxt.xmW = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96258);
        return 0;
      }
      AppMethodBeat.o(96258);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axt
 * JD-Core Version:    0.7.0.1
 */