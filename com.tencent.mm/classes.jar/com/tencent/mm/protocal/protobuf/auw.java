package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class auw
  extends cwj
{
  public LinkedList<String> GLR;
  public LinkedList<String> GLS;
  public LinkedList<String> GLT;
  public LinkedList<aux> GLU;
  public String Title;
  public String ucQ;
  
  public auw()
  {
    AppMethodBeat.i(42635);
    this.GLR = new LinkedList();
    this.GLS = new LinkedList();
    this.GLT = new LinkedList();
    this.GLU = new LinkedList();
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
      if (this.ucQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: JsonData");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.e(3, 1, this.GLR);
      if (this.ucQ != null) {
        paramVarArgs.d(4, this.ucQ);
      }
      paramVarArgs.e(5, 1, this.GLS);
      paramVarArgs.e(6, 1, this.GLT);
      paramVarArgs.e(7, 8, this.GLU);
      AppMethodBeat.o(42636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      i += f.a.a.a.c(3, 1, this.GLR);
      paramInt = i;
      if (this.ucQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ucQ);
      }
      i = f.a.a.a.c(5, 1, this.GLS);
      int j = f.a.a.a.c(6, 1, this.GLT);
      int k = f.a.a.a.c(7, 8, this.GLU);
      AppMethodBeat.o(42636);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLR.clear();
        this.GLS.clear();
        this.GLT.clear();
        this.GLU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        if (this.ucQ == null)
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
        auw localauw = (auw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42636);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localauw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42636);
          return 0;
        case 2: 
          localauw.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 3: 
          localauw.GLR.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 4: 
          localauw.ucQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 5: 
          localauw.GLS.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 6: 
          localauw.GLT.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(42636);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aux();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aux)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localauw.GLU.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auw
 * JD-Core Version:    0.7.0.1
 */