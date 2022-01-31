package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class v
  extends bvk
{
  public int cnK;
  public String kNv;
  public int state;
  public String title;
  public int type;
  public String wjW;
  public int wkA;
  public int wkB;
  public int wkC;
  public long wkD;
  public long wkE;
  public long wkF;
  public int wkG;
  public String wkH;
  public int wkI;
  public long wkJ;
  public LinkedList<t> wkb;
  public int wkh;
  public String wkr;
  public String wkv;
  public long wkw;
  public int wkx;
  public long wky;
  public int wkz;
  
  public v()
  {
    AppMethodBeat.i(56690);
    this.cnK = 268513600;
    this.kNv = "请求不成功，请稍候再试";
    this.wkb = new LinkedList();
    AppMethodBeat.o(56690);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56691);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56691);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(3, this.kNv);
      }
      if (this.wjW != null) {
        paramVarArgs.e(4, this.wjW);
      }
      if (this.title != null) {
        paramVarArgs.e(5, this.title);
      }
      paramVarArgs.aO(6, this.type);
      if (this.wkv != null) {
        paramVarArgs.e(7, this.wkv);
      }
      paramVarArgs.am(8, this.wkw);
      paramVarArgs.aO(9, this.wkx);
      paramVarArgs.am(10, this.wky);
      paramVarArgs.aO(11, this.wkz);
      paramVarArgs.aO(12, this.state);
      paramVarArgs.aO(13, this.wkA);
      paramVarArgs.aO(14, this.wkB);
      paramVarArgs.aO(15, this.wkh);
      paramVarArgs.aO(16, this.wkC);
      paramVarArgs.am(17, this.wkD);
      paramVarArgs.am(18, this.wkE);
      paramVarArgs.am(19, this.wkF);
      paramVarArgs.aO(20, this.wkG);
      if (this.wkr != null) {
        paramVarArgs.e(21, this.wkr);
      }
      paramVarArgs.e(22, 8, this.wkb);
      if (this.wkH != null) {
        paramVarArgs.e(23, this.wkH);
      }
      paramVarArgs.aO(24, this.wkI);
      paramVarArgs.am(25, this.wkJ);
      AppMethodBeat.o(56691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1626;
      }
    }
    label1626:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kNv);
      }
      i = paramInt;
      if (this.wjW != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wjW);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.title);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.type);
      paramInt = i;
      if (this.wkv != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wkv);
      }
      i = paramInt + e.a.a.b.b.a.p(8, this.wkw) + e.a.a.b.b.a.bl(9, this.wkx) + e.a.a.b.b.a.p(10, this.wky) + e.a.a.b.b.a.bl(11, this.wkz) + e.a.a.b.b.a.bl(12, this.state) + e.a.a.b.b.a.bl(13, this.wkA) + e.a.a.b.b.a.bl(14, this.wkB) + e.a.a.b.b.a.bl(15, this.wkh) + e.a.a.b.b.a.bl(16, this.wkC) + e.a.a.b.b.a.p(17, this.wkD) + e.a.a.b.b.a.p(18, this.wkE) + e.a.a.b.b.a.p(19, this.wkF) + e.a.a.b.b.a.bl(20, this.wkG);
      paramInt = i;
      if (this.wkr != null) {
        paramInt = i + e.a.a.b.b.a.f(21, this.wkr);
      }
      i = paramInt + e.a.a.a.c(22, 8, this.wkb);
      paramInt = i;
      if (this.wkH != null) {
        paramInt = i + e.a.a.b.b.a.f(23, this.wkH);
      }
      i = e.a.a.b.b.a.bl(24, this.wkI);
      int j = e.a.a.b.b.a.p(25, this.wkJ);
      AppMethodBeat.o(56691);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wkb.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56691);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56691);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56691);
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
            localv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56691);
          return 0;
        case 2: 
          localv.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        case 3: 
          localv.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56691);
          return 0;
        case 4: 
          localv.wjW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56691);
          return 0;
        case 5: 
          localv.title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56691);
          return 0;
        case 6: 
          localv.type = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        case 7: 
          localv.wkv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56691);
          return 0;
        case 8: 
          localv.wkw = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56691);
          return 0;
        case 9: 
          localv.wkx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        case 10: 
          localv.wky = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56691);
          return 0;
        case 11: 
          localv.wkz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        case 12: 
          localv.state = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        case 13: 
          localv.wkA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        case 14: 
          localv.wkB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        case 15: 
          localv.wkh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        case 16: 
          localv.wkC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        case 17: 
          localv.wkD = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56691);
          return 0;
        case 18: 
          localv.wkE = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56691);
          return 0;
        case 19: 
          localv.wkF = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(56691);
          return 0;
        case 20: 
          localv.wkG = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        case 21: 
          localv.wkr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56691);
          return 0;
        case 22: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localv.wkb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56691);
          return 0;
        case 23: 
          localv.wkH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56691);
          return 0;
        case 24: 
          localv.wkI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56691);
          return 0;
        }
        localv.wkJ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56691);
        return 0;
      }
      AppMethodBeat.o(56691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.v
 * JD-Core Version:    0.7.0.1
 */