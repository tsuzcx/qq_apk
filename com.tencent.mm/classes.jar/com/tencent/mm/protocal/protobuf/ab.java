package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ab
  extends bvk
{
  public int OpCode;
  public String wlb;
  public int wlc;
  public int wld;
  public String wle;
  public ccq wlf;
  public bta wlg;
  public ccq wlh;
  public bpx wli;
  public aeg wlj;
  public gm wlk;
  public String wll;
  public String wlm;
  public int wln;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28293);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28293);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wlb != null) {
        paramVarArgs.e(2, this.wlb);
      }
      paramVarArgs.aO(3, this.wlc);
      paramVarArgs.aO(4, this.wld);
      if (this.wle != null) {
        paramVarArgs.e(5, this.wle);
      }
      if (this.wlf != null)
      {
        paramVarArgs.iQ(6, this.wlf.computeSize());
        this.wlf.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.OpCode);
      if (this.wlg != null)
      {
        paramVarArgs.iQ(8, this.wlg.computeSize());
        this.wlg.writeFields(paramVarArgs);
      }
      if (this.wlh != null)
      {
        paramVarArgs.iQ(9, this.wlh.computeSize());
        this.wlh.writeFields(paramVarArgs);
      }
      if (this.wli != null)
      {
        paramVarArgs.iQ(10, this.wli.computeSize());
        this.wli.writeFields(paramVarArgs);
      }
      if (this.wlj != null)
      {
        paramVarArgs.iQ(11, this.wlj.computeSize());
        this.wlj.writeFields(paramVarArgs);
      }
      if (this.wlk != null)
      {
        paramVarArgs.iQ(12, this.wlk.computeSize());
        this.wlk.writeFields(paramVarArgs);
      }
      if (this.wll != null) {
        paramVarArgs.e(13, this.wll);
      }
      if (this.wlm != null) {
        paramVarArgs.e(14, this.wlm);
      }
      paramVarArgs.aO(15, this.wln);
      AppMethodBeat.o(28293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1739;
      }
    }
    label1739:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wlb != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wlb);
      }
      i = i + e.a.a.b.b.a.bl(3, this.wlc) + e.a.a.b.b.a.bl(4, this.wld);
      paramInt = i;
      if (this.wle != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wle);
      }
      i = paramInt;
      if (this.wlf != null) {
        i = paramInt + e.a.a.a.iP(6, this.wlf.computeSize());
      }
      i += e.a.a.b.b.a.bl(7, this.OpCode);
      paramInt = i;
      if (this.wlg != null) {
        paramInt = i + e.a.a.a.iP(8, this.wlg.computeSize());
      }
      i = paramInt;
      if (this.wlh != null) {
        i = paramInt + e.a.a.a.iP(9, this.wlh.computeSize());
      }
      paramInt = i;
      if (this.wli != null) {
        paramInt = i + e.a.a.a.iP(10, this.wli.computeSize());
      }
      i = paramInt;
      if (this.wlj != null) {
        i = paramInt + e.a.a.a.iP(11, this.wlj.computeSize());
      }
      paramInt = i;
      if (this.wlk != null) {
        paramInt = i + e.a.a.a.iP(12, this.wlk.computeSize());
      }
      i = paramInt;
      if (this.wll != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.wll);
      }
      paramInt = i;
      if (this.wlm != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.wlm);
      }
      i = e.a.a.b.b.a.bl(15, this.wln);
      AppMethodBeat.o(28293);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28293);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28293);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ab localab = (ab)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28293);
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
            localab.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28293);
          return 0;
        case 2: 
          localab.wlb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28293);
          return 0;
        case 3: 
          localab.wlc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28293);
          return 0;
        case 4: 
          localab.wld = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28293);
          return 0;
        case 5: 
          localab.wle = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28293);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localab.wlf = ((ccq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28293);
          return 0;
        case 7: 
          localab.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28293);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bta();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bta)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localab.wlg = ((bta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28293);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localab.wlh = ((ccq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28293);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localab.wli = ((bpx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28293);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localab.wlj = ((aeg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28293);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localab.wlk = ((gm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28293);
          return 0;
        case 13: 
          localab.wll = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28293);
          return 0;
        case 14: 
          localab.wlm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28293);
          return 0;
        }
        localab.wln = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28293);
        return 0;
      }
      AppMethodBeat.o(28293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ab
 * JD-Core Version:    0.7.0.1
 */