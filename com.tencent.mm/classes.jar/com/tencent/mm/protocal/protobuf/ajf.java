package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ajf
  extends bvk
{
  public String ID;
  public int Scene;
  public long jJO;
  public int jKs;
  public SKBuiltinBuffer_t wsu;
  public int wta;
  public LinkedList<vd> wtb;
  public String wtc;
  public String wtd;
  public String wte;
  public int wti;
  public String wtj;
  public String wtk;
  public String xaK;
  
  public ajf()
  {
    AppMethodBeat.i(28423);
    this.wtb = new LinkedList();
    AppMethodBeat.o(28423);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28424);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28424);
        throw paramVarArgs;
      }
      if (this.wsu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(28424);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ID != null) {
        paramVarArgs.e(2, this.ID);
      }
      if (this.wsu != null)
      {
        paramVarArgs.iQ(3, this.wsu.computeSize());
        this.wsu.writeFields(paramVarArgs);
      }
      if (this.wtj != null) {
        paramVarArgs.e(4, this.wtj);
      }
      if (this.wtk != null) {
        paramVarArgs.e(5, this.wtk);
      }
      paramVarArgs.aO(6, this.jKs);
      paramVarArgs.aO(7, this.wta);
      paramVarArgs.e(8, 8, this.wtb);
      if (this.xaK != null) {
        paramVarArgs.e(9, this.xaK);
      }
      if (this.wtc != null) {
        paramVarArgs.e(10, this.wtc);
      }
      if (this.wtd != null) {
        paramVarArgs.e(11, this.wtd);
      }
      paramVarArgs.aO(12, this.wti);
      paramVarArgs.aO(13, this.Scene);
      paramVarArgs.am(14, this.jJO);
      if (this.wte != null) {
        paramVarArgs.e(15, this.wte);
      }
      AppMethodBeat.o(28424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1379;
      }
    }
    label1379:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ID != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ID);
      }
      i = paramInt;
      if (this.wsu != null) {
        i = paramInt + e.a.a.a.iP(3, this.wsu.computeSize());
      }
      paramInt = i;
      if (this.wtj != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wtj);
      }
      i = paramInt;
      if (this.wtk != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wtk);
      }
      i = i + e.a.a.b.b.a.bl(6, this.jKs) + e.a.a.b.b.a.bl(7, this.wta) + e.a.a.a.c(8, 8, this.wtb);
      paramInt = i;
      if (this.xaK != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xaK);
      }
      i = paramInt;
      if (this.wtc != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.wtc);
      }
      paramInt = i;
      if (this.wtd != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wtd);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.wti) + e.a.a.b.b.a.bl(13, this.Scene) + e.a.a.b.b.a.p(14, this.jJO);
      paramInt = i;
      if (this.wte != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.wte);
      }
      AppMethodBeat.o(28424);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wtb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28424);
          throw paramVarArgs;
        }
        if (this.wsu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(28424);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28424);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ajf localajf = (ajf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28424);
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
            localajf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28424);
          return 0;
        case 2: 
          localajf.ID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28424);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localajf.wsu = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28424);
          return 0;
        case 4: 
          localajf.wtj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28424);
          return 0;
        case 5: 
          localajf.wtk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28424);
          return 0;
        case 6: 
          localajf.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28424);
          return 0;
        case 7: 
          localajf.wta = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28424);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localajf.wtb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28424);
          return 0;
        case 9: 
          localajf.xaK = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28424);
          return 0;
        case 10: 
          localajf.wtc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28424);
          return 0;
        case 11: 
          localajf.wtd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28424);
          return 0;
        case 12: 
          localajf.wti = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28424);
          return 0;
        case 13: 
          localajf.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28424);
          return 0;
        case 14: 
          localajf.jJO = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28424);
          return 0;
        }
        localajf.wte = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28424);
        return 0;
      }
      AppMethodBeat.o(28424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajf
 * JD-Core Version:    0.7.0.1
 */