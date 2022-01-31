package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class agt
  extends bvk
{
  public int cnK;
  public String kNv;
  public LinkedList<String> ubt;
  public String wZs;
  
  public agt()
  {
    AppMethodBeat.i(56809);
    this.ubt = new LinkedList();
    AppMethodBeat.o(56809);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56810);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56810);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.ubt);
      paramVarArgs.aO(3, this.cnK);
      if (this.kNv != null) {
        paramVarArgs.e(4, this.kNv);
      }
      if (this.wZs != null) {
        paramVarArgs.e(5, this.wZs);
      }
      AppMethodBeat.o(56810);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 1, this.ubt) + e.a.a.b.b.a.bl(3, this.cnK);
      paramInt = i;
      if (this.kNv != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kNv);
      }
      i = paramInt;
      if (this.wZs != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wZs);
      }
      AppMethodBeat.o(56810);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ubt.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56810);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56810);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        agt localagt = (agt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56810);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56810);
          return 0;
        case 2: 
          localagt.ubt.add(((e.a.a.a.a)localObject1).CLY.readString());
          AppMethodBeat.o(56810);
          return 0;
        case 3: 
          localagt.cnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56810);
          return 0;
        case 4: 
          localagt.kNv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56810);
          return 0;
        }
        localagt.wZs = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56810);
        return 0;
      }
      AppMethodBeat.o(56810);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agt
 * JD-Core Version:    0.7.0.1
 */