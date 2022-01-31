package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class vl
  extends bvk
{
  public int wOi;
  public aeh wOj;
  public kw wOk;
  public String wyh;
  public bqx wyn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11742);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(11742);
        throw paramVarArgs;
      }
      if (this.wyn == null)
      {
        paramVarArgs = new b("Not all required fields were included: qy_base_resp");
        AppMethodBeat.o(11742);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wyn != null)
      {
        paramVarArgs.iQ(2, this.wyn.computeSize());
        this.wyn.writeFields(paramVarArgs);
      }
      if (this.wyh != null) {
        paramVarArgs.e(3, this.wyh);
      }
      paramVarArgs.aO(4, this.wOi);
      if (this.wOj != null)
      {
        paramVarArgs.iQ(5, this.wOj.computeSize());
        this.wOj.writeFields(paramVarArgs);
      }
      if (this.wOk != null)
      {
        paramVarArgs.iQ(6, this.wOk.computeSize());
        this.wOk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(11742);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label990;
      }
    }
    label990:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wyn != null) {
        paramInt = i + e.a.a.a.iP(2, this.wyn.computeSize());
      }
      i = paramInt;
      if (this.wyh != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wyh);
      }
      i += e.a.a.b.b.a.bl(4, this.wOi);
      paramInt = i;
      if (this.wOj != null) {
        paramInt = i + e.a.a.a.iP(5, this.wOj.computeSize());
      }
      i = paramInt;
      if (this.wOk != null) {
        i = paramInt + e.a.a.a.iP(6, this.wOk.computeSize());
      }
      AppMethodBeat.o(11742);
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
          AppMethodBeat.o(11742);
          throw paramVarArgs;
        }
        if (this.wyn == null)
        {
          paramVarArgs = new b("Not all required fields were included: qy_base_resp");
          AppMethodBeat.o(11742);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11742);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vl localvl = (vl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11742);
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
            localvl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11742);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvl.wyn = ((bqx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11742);
          return 0;
        case 3: 
          localvl.wyh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(11742);
          return 0;
        case 4: 
          localvl.wOi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11742);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvl.wOj = ((aeh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11742);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kw();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((kw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localvl.wOk = ((kw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(11742);
        return 0;
      }
      AppMethodBeat.o(11742);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vl
 * JD-Core Version:    0.7.0.1
 */