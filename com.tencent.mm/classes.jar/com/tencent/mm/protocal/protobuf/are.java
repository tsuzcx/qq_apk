package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class are
  extends bvk
{
  public int wsg;
  public String xgu;
  public String xgv;
  public LinkedList<String> xgw;
  
  public are()
  {
    AppMethodBeat.i(102379);
    this.xgw = new LinkedList();
    AppMethodBeat.o(102379);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102380);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(102380);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xgu != null) {
        paramVarArgs.e(2, this.xgu);
      }
      paramVarArgs.aO(3, this.wsg);
      if (this.xgv != null) {
        paramVarArgs.e(4, this.xgv);
      }
      paramVarArgs.e(5, 1, this.xgw);
      AppMethodBeat.o(102380);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xgu != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xgu);
      }
      i += e.a.a.b.b.a.bl(3, this.wsg);
      paramInt = i;
      if (this.xgv != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xgv);
      }
      i = e.a.a.a.c(5, 1, this.xgw);
      AppMethodBeat.o(102380);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xgw.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(102380);
          throw paramVarArgs;
        }
        AppMethodBeat.o(102380);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        are localare = (are)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(102380);
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
            localare.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(102380);
          return 0;
        case 2: 
          localare.xgu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(102380);
          return 0;
        case 3: 
          localare.wsg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(102380);
          return 0;
        case 4: 
          localare.xgv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(102380);
          return 0;
        }
        localare.xgw.add(((e.a.a.a.a)localObject1).CLY.readString());
        AppMethodBeat.o(102380);
        return 0;
      }
      AppMethodBeat.o(102380);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.are
 * JD-Core Version:    0.7.0.1
 */