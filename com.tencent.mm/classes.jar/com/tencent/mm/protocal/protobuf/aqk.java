package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aqk
  extends cqk
{
  public LinkedList<String> EJr;
  public LinkedList<String> EJs;
  public LinkedList<String> EJt;
  public LinkedList<aql> EJu;
  public String Title;
  public String sVu;
  
  public aqk()
  {
    AppMethodBeat.i(42635);
    this.EJr = new LinkedList();
    this.EJs = new LinkedList();
    this.EJt = new LinkedList();
    this.EJu = new LinkedList();
    AppMethodBeat.o(42635);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42636);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
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
      if (this.sVu == null)
      {
        paramVarArgs = new b("Not all required fields were included: JsonData");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.e(3, 1, this.EJr);
      if (this.sVu != null) {
        paramVarArgs.d(4, this.sVu);
      }
      paramVarArgs.e(5, 1, this.EJs);
      paramVarArgs.e(6, 1, this.EJt);
      paramVarArgs.e(7, 8, this.EJu);
      AppMethodBeat.o(42636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      i += f.a.a.a.c(3, 1, this.EJr);
      paramInt = i;
      if (this.sVu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sVu);
      }
      i = f.a.a.a.c(5, 1, this.EJs);
      int j = f.a.a.a.c(6, 1, this.EJt);
      int k = f.a.a.a.c(7, 8, this.EJu);
      AppMethodBeat.o(42636);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EJr.clear();
        this.EJs.clear();
        this.EJt.clear();
        this.EJu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        if (this.sVu == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqk localaqk = (aqk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42636);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaqk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42636);
          return 0;
        case 2: 
          localaqk.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 3: 
          localaqk.EJr.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 4: 
          localaqk.sVu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 5: 
          localaqk.EJs.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 6: 
          localaqk.EJt.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(42636);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aql();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaqk.EJu.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqk
 * JD-Core Version:    0.7.0.1
 */