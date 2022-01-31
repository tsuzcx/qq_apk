package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bhh
  extends bvk
{
  public int koj;
  public String kok;
  public String tNy;
  public boolean xoA;
  public bax xwj;
  public String xwk;
  public int xwl;
  public int xwm;
  public int xwn;
  public LinkedList<yp> xwo;
  public LinkedList<bsw> xwp;
  public LinkedList<hh> xwq;
  public bmv xwr;
  
  public bhh()
  {
    AppMethodBeat.i(56869);
    this.xwo = new LinkedList();
    this.xwp = new LinkedList();
    this.xwq = new LinkedList();
    AppMethodBeat.o(56869);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56870);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56870);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      paramVarArgs.aO(4, this.xwl);
      paramVarArgs.aO(5, this.xwm);
      paramVarArgs.aO(6, this.xwn);
      paramVarArgs.e(8, 8, this.xwo);
      if (this.xwj != null)
      {
        paramVarArgs.iQ(9, this.xwj.computeSize());
        this.xwj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.xwp);
      paramVarArgs.e(11, 8, this.xwq);
      paramVarArgs.aS(12, this.xoA);
      if (this.xwr != null)
      {
        paramVarArgs.iQ(13, this.xwr.computeSize());
        this.xwr.writeFields(paramVarArgs);
      }
      if (this.xwk != null) {
        paramVarArgs.e(14, this.xwk);
      }
      if (this.tNy != null) {
        paramVarArgs.e(100, this.tNy);
      }
      AppMethodBeat.o(56870);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1542;
      }
    }
    label1542:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xwl) + e.a.a.b.b.a.bl(5, this.xwm) + e.a.a.b.b.a.bl(6, this.xwn) + e.a.a.a.c(8, 8, this.xwo);
      paramInt = i;
      if (this.xwj != null) {
        paramInt = i + e.a.a.a.iP(9, this.xwj.computeSize());
      }
      i = paramInt + e.a.a.a.c(10, 8, this.xwp) + e.a.a.a.c(11, 8, this.xwq) + (e.a.a.b.b.a.eW(12) + 1);
      paramInt = i;
      if (this.xwr != null) {
        paramInt = i + e.a.a.a.iP(13, this.xwr.computeSize());
      }
      i = paramInt;
      if (this.xwk != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.xwk);
      }
      paramInt = i;
      if (this.tNy != null) {
        paramInt = i + e.a.a.b.b.a.f(100, this.tNy);
      }
      AppMethodBeat.o(56870);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xwo.clear();
        this.xwp.clear();
        this.xwq.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56870);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56870);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bhh localbhh = (bhh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56870);
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
            localbhh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56870);
          return 0;
        case 2: 
          localbhh.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56870);
          return 0;
        case 3: 
          localbhh.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56870);
          return 0;
        case 4: 
          localbhh.xwl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56870);
          return 0;
        case 5: 
          localbhh.xwm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56870);
          return 0;
        case 6: 
          localbhh.xwn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56870);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhh.xwo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56870);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bax();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bax)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhh.xwj = ((bax)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56870);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhh.xwp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56870);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhh.xwq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56870);
          return 0;
        case 12: 
          localbhh.xoA = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56870);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmv();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmv)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbhh.xwr = ((bmv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56870);
          return 0;
        case 14: 
          localbhh.xwk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56870);
          return 0;
        }
        localbhh.tNy = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56870);
        return 0;
      }
      AppMethodBeat.o(56870);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhh
 * JD-Core Version:    0.7.0.1
 */