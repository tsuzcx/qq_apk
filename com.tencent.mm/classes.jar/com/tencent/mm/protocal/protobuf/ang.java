package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ang
  extends cld
{
  public LinkedList<String> Dor;
  public LinkedList<String> Dos;
  public LinkedList<String> Dot;
  public LinkedList<anh> Dou;
  public String Title;
  public String rNF;
  
  public ang()
  {
    AppMethodBeat.i(42635);
    this.Dor = new LinkedList();
    this.Dos = new LinkedList();
    this.Dot = new LinkedList();
    this.Dou = new LinkedList();
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
      if (this.rNF == null)
      {
        paramVarArgs = new b("Not all required fields were included: JsonData");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.e(3, 1, this.Dor);
      if (this.rNF != null) {
        paramVarArgs.d(4, this.rNF);
      }
      paramVarArgs.e(5, 1, this.Dos);
      paramVarArgs.e(6, 1, this.Dot);
      paramVarArgs.e(7, 8, this.Dou);
      AppMethodBeat.o(42636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      i += f.a.a.a.c(3, 1, this.Dor);
      paramInt = i;
      if (this.rNF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rNF);
      }
      i = f.a.a.a.c(5, 1, this.Dos);
      int j = f.a.a.a.c(6, 1, this.Dot);
      int k = f.a.a.a.c(7, 8, this.Dou);
      AppMethodBeat.o(42636);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Dor.clear();
        this.Dos.clear();
        this.Dot.clear();
        this.Dou.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        if (this.rNF == null)
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
        ang localang = (ang)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42636);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localang.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42636);
          return 0;
        case 2: 
          localang.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 3: 
          localang.Dor.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 4: 
          localang.rNF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 5: 
          localang.Dos.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 6: 
          localang.Dot.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(42636);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new anh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((anh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localang.Dou.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ang
 * JD-Core Version:    0.7.0.1
 */