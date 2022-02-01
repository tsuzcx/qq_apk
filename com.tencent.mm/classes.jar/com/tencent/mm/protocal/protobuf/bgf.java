package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bgf
  extends dpc
{
  public LinkedList<String> LPV;
  public LinkedList<String> LPW;
  public LinkedList<String> LPX;
  public LinkedList<bgg> LPY;
  public String Title;
  public String xuE;
  
  public bgf()
  {
    AppMethodBeat.i(42635);
    this.LPV = new LinkedList();
    this.LPW = new LinkedList();
    this.LPX = new LinkedList();
    this.LPY = new LinkedList();
    AppMethodBeat.o(42635);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.xuE == null)
      {
        paramVarArgs = new b("Not all required fields were included: JsonData");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      paramVarArgs.e(3, 1, this.LPV);
      if (this.xuE != null) {
        paramVarArgs.e(4, this.xuE);
      }
      paramVarArgs.e(5, 1, this.LPW);
      paramVarArgs.e(6, 1, this.LPX);
      paramVarArgs.e(7, 8, this.LPY);
      AppMethodBeat.o(42636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Title);
      }
      i += g.a.a.a.c(3, 1, this.LPV);
      paramInt = i;
      if (this.xuE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xuE);
      }
      i = g.a.a.a.c(5, 1, this.LPW);
      int j = g.a.a.a.c(6, 1, this.LPX);
      int k = g.a.a.a.c(7, 8, this.LPY);
      AppMethodBeat.o(42636);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LPV.clear();
        this.LPW.clear();
        this.LPX.clear();
        this.LPY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(42636);
          throw paramVarArgs;
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(42636);
          throw paramVarArgs;
        }
        if (this.xuE == null)
        {
          paramVarArgs = new b("Not all required fields were included: JsonData");
          AppMethodBeat.o(42636);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bgf localbgf = (bgf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42636);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbgf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42636);
          return 0;
        case 2: 
          localbgf.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 3: 
          localbgf.LPV.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 4: 
          localbgf.xuE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 5: 
          localbgf.LPW.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 6: 
          localbgf.LPX.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(42636);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bgg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbgf.LPY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(42636);
        return 0;
      }
      AppMethodBeat.o(42636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgf
 * JD-Core Version:    0.7.0.1
 */