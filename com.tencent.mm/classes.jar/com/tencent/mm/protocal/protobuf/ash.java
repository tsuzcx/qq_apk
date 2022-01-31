package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ash
  extends bvk
{
  public String Desc;
  public String Title;
  public String nQe;
  public String xhA;
  public int xhc;
  public LinkedList<cuz> xhd;
  public String xhp;
  public String xhq;
  public String xhr;
  public String xhs;
  public String xht;
  public String xhu;
  public cvf xhv;
  public String xhw;
  public String xhx;
  public String xhy;
  public String xhz;
  
  public ash()
  {
    AppMethodBeat.i(28508);
    this.xhd = new LinkedList();
    AppMethodBeat.o(28508);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28509);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28509);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xhp != null) {
        paramVarArgs.e(2, this.xhp);
      }
      if (this.nQe != null) {
        paramVarArgs.e(3, this.nQe);
      }
      if (this.Title != null) {
        paramVarArgs.e(4, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(5, this.Desc);
      }
      if (this.xhq != null) {
        paramVarArgs.e(6, this.xhq);
      }
      if (this.xhr != null) {
        paramVarArgs.e(7, this.xhr);
      }
      if (this.xhs != null) {
        paramVarArgs.e(8, this.xhs);
      }
      if (this.xht != null) {
        paramVarArgs.e(9, this.xht);
      }
      if (this.xhu != null) {
        paramVarArgs.e(10, this.xhu);
      }
      if (this.xhv != null)
      {
        paramVarArgs.iQ(11, this.xhv.computeSize());
        this.xhv.writeFields(paramVarArgs);
      }
      if (this.xhw != null) {
        paramVarArgs.e(12, this.xhw);
      }
      if (this.xhx != null) {
        paramVarArgs.e(13, this.xhx);
      }
      if (this.xhy != null) {
        paramVarArgs.e(14, this.xhy);
      }
      if (this.xhz != null) {
        paramVarArgs.e(15, this.xhz);
      }
      if (this.xhA != null) {
        paramVarArgs.e(16, this.xhA);
      }
      paramVarArgs.aO(17, this.xhc);
      paramVarArgs.e(18, 8, this.xhd);
      AppMethodBeat.o(28509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1590;
      }
    }
    label1590:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xhp != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xhp);
      }
      i = paramInt;
      if (this.nQe != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nQe);
      }
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.Desc);
      }
      paramInt = i;
      if (this.xhq != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xhq);
      }
      i = paramInt;
      if (this.xhr != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xhr);
      }
      paramInt = i;
      if (this.xhs != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xhs);
      }
      i = paramInt;
      if (this.xht != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.xht);
      }
      paramInt = i;
      if (this.xhu != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xhu);
      }
      i = paramInt;
      if (this.xhv != null) {
        i = paramInt + e.a.a.a.iP(11, this.xhv.computeSize());
      }
      paramInt = i;
      if (this.xhw != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xhw);
      }
      i = paramInt;
      if (this.xhx != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.xhx);
      }
      paramInt = i;
      if (this.xhy != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.xhy);
      }
      i = paramInt;
      if (this.xhz != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.xhz);
      }
      paramInt = i;
      if (this.xhA != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.xhA);
      }
      i = e.a.a.b.b.a.bl(17, this.xhc);
      int j = e.a.a.a.c(18, 8, this.xhd);
      AppMethodBeat.o(28509);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xhd.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28509);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ash localash = (ash)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28509);
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
            localash.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28509);
          return 0;
        case 2: 
          localash.xhp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 3: 
          localash.nQe = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 4: 
          localash.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 5: 
          localash.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 6: 
          localash.xhq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 7: 
          localash.xhr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 8: 
          localash.xhs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 9: 
          localash.xht = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 10: 
          localash.xhu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvf();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvf)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localash.xhv = ((cvf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28509);
          return 0;
        case 12: 
          localash.xhw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 13: 
          localash.xhx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 14: 
          localash.xhy = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 15: 
          localash.xhz = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 16: 
          localash.xhA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28509);
          return 0;
        case 17: 
          localash.xhc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28509);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cuz();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cuz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localash.xhd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28509);
        return 0;
      }
      AppMethodBeat.o(28509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ash
 * JD-Core Version:    0.7.0.1
 */