package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cdr
  extends bvk
{
  public String woO;
  public LinkedList<SnsObject> wuP;
  public String xOk;
  public int xOo;
  public int xOp;
  public ceu xOq;
  public int xtO;
  
  public cdr()
  {
    AppMethodBeat.i(94568);
    this.wuP = new LinkedList();
    AppMethodBeat.o(94568);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94569);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(94569);
        throw paramVarArgs;
      }
      if (this.xOq == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerConfig");
        AppMethodBeat.o(94569);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xOk != null) {
        paramVarArgs.e(2, this.xOk);
      }
      paramVarArgs.aO(3, this.xtO);
      paramVarArgs.e(4, 8, this.wuP);
      paramVarArgs.aO(5, this.xOo);
      if (this.woO != null) {
        paramVarArgs.e(6, this.woO);
      }
      paramVarArgs.aO(7, this.xOp);
      if (this.xOq != null)
      {
        paramVarArgs.iQ(8, this.xOq.computeSize());
        this.xOq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xOk != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xOk);
      }
      i = i + e.a.a.b.b.a.bl(3, this.xtO) + e.a.a.a.c(4, 8, this.wuP) + e.a.a.b.b.a.bl(5, this.xOo);
      paramInt = i;
      if (this.woO != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.woO);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.xOp);
      paramInt = i;
      if (this.xOq != null) {
        paramInt = i + e.a.a.a.iP(8, this.xOq.computeSize());
      }
      AppMethodBeat.o(94569);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wuP.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(94569);
          throw paramVarArgs;
        }
        if (this.xOq == null)
        {
          paramVarArgs = new b("Not all required fields were included: ServerConfig");
          AppMethodBeat.o(94569);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94569);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cdr localcdr = (cdr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94569);
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
            localcdr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94569);
          return 0;
        case 2: 
          localcdr.xOk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94569);
          return 0;
        case 3: 
          localcdr.xtO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94569);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcdr.wuP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94569);
          return 0;
        case 5: 
          localcdr.xOo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94569);
          return 0;
        case 6: 
          localcdr.woO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94569);
          return 0;
        case 7: 
          localcdr.xOp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94569);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ceu();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ceu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcdr.xOq = ((ceu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94569);
        return 0;
      }
      AppMethodBeat.o(94569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdr
 * JD-Core Version:    0.7.0.1
 */