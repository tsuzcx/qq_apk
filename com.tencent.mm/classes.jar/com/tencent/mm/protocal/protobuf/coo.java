package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class coo
  extends bvk
{
  public int CreateTime;
  public int pIE;
  public long pIG;
  public int pIx;
  public int pIy;
  public int pIz;
  public String wDo;
  public String wDs;
  public bwc woP;
  public bwc woQ;
  public bwc xXk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80204);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(80204);
        throw paramVarArgs;
      }
      if (this.xXk == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(80204);
        throw paramVarArgs;
      }
      if (this.woP == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(80204);
        throw paramVarArgs;
      }
      if (this.woQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(80204);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIE);
      if (this.xXk != null)
      {
        paramVarArgs.iQ(3, this.xXk.computeSize());
        this.xXk.writeFields(paramVarArgs);
      }
      if (this.woP != null)
      {
        paramVarArgs.iQ(4, this.woP.computeSize());
        this.woP.writeFields(paramVarArgs);
      }
      if (this.woQ != null)
      {
        paramVarArgs.iQ(5, this.woQ.computeSize());
        this.woQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.pIx);
      paramVarArgs.aO(7, this.pIy);
      paramVarArgs.aO(8, this.pIz);
      paramVarArgs.aO(9, this.CreateTime);
      paramVarArgs.am(10, this.pIG);
      if (this.wDo != null) {
        paramVarArgs.e(11, this.wDo);
      }
      if (this.wDs != null) {
        paramVarArgs.e(12, this.wDs);
      }
      AppMethodBeat.o(80204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1354;
      }
    }
    label1354:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIE);
      paramInt = i;
      if (this.xXk != null) {
        paramInt = i + e.a.a.a.iP(3, this.xXk.computeSize());
      }
      i = paramInt;
      if (this.woP != null) {
        i = paramInt + e.a.a.a.iP(4, this.woP.computeSize());
      }
      paramInt = i;
      if (this.woQ != null) {
        paramInt = i + e.a.a.a.iP(5, this.woQ.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.pIx) + e.a.a.b.b.a.bl(7, this.pIy) + e.a.a.b.b.a.bl(8, this.pIz) + e.a.a.b.b.a.bl(9, this.CreateTime) + e.a.a.b.b.a.p(10, this.pIG);
      paramInt = i;
      if (this.wDo != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wDo);
      }
      i = paramInt;
      if (this.wDs != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.wDs);
      }
      AppMethodBeat.o(80204);
      return i;
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
          AppMethodBeat.o(80204);
          throw paramVarArgs;
        }
        if (this.xXk == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(80204);
          throw paramVarArgs;
        }
        if (this.woP == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(80204);
          throw paramVarArgs;
        }
        if (this.woQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(80204);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80204);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        coo localcoo = (coo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80204);
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
            localcoo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80204);
          return 0;
        case 2: 
          localcoo.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80204);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoo.xXk = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80204);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoo.woP = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80204);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcoo.woQ = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80204);
          return 0;
        case 6: 
          localcoo.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80204);
          return 0;
        case 7: 
          localcoo.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80204);
          return 0;
        case 8: 
          localcoo.pIz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80204);
          return 0;
        case 9: 
          localcoo.CreateTime = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80204);
          return 0;
        case 10: 
          localcoo.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(80204);
          return 0;
        case 11: 
          localcoo.wDo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80204);
          return 0;
        }
        localcoo.wDs = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(80204);
        return 0;
      }
      AppMethodBeat.o(80204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coo
 * JD-Core Version:    0.7.0.1
 */