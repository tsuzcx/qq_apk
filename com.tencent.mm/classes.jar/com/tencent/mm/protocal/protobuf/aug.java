package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aug
  extends cvp
{
  public LinkedList<String> Gst;
  public LinkedList<String> Gsu;
  public LinkedList<String> Gsv;
  public LinkedList<auh> Gsw;
  public String Title;
  public String tRZ;
  
  public aug()
  {
    AppMethodBeat.i(42635);
    this.Gst = new LinkedList();
    this.Gsu = new LinkedList();
    this.Gsv = new LinkedList();
    this.Gsw = new LinkedList();
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
      if (this.tRZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: JsonData");
        AppMethodBeat.o(42636);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.e(3, 1, this.Gst);
      if (this.tRZ != null) {
        paramVarArgs.d(4, this.tRZ);
      }
      paramVarArgs.e(5, 1, this.Gsu);
      paramVarArgs.e(6, 1, this.Gsv);
      paramVarArgs.e(7, 8, this.Gsw);
      AppMethodBeat.o(42636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      i += f.a.a.a.c(3, 1, this.Gst);
      paramInt = i;
      if (this.tRZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tRZ);
      }
      i = f.a.a.a.c(5, 1, this.Gsu);
      int j = f.a.a.a.c(6, 1, this.Gsv);
      int k = f.a.a.a.c(7, 8, this.Gsw);
      AppMethodBeat.o(42636);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gst.clear();
        this.Gsu.clear();
        this.Gsv.clear();
        this.Gsw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        if (this.tRZ == null)
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
        aug localaug = (aug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42636);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaug.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42636);
          return 0;
        case 2: 
          localaug.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 3: 
          localaug.Gst.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 4: 
          localaug.tRZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(42636);
          return 0;
        case 5: 
          localaug.Gsu.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(42636);
          return 0;
        case 6: 
          localaug.Gsv.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(42636);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new auh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((auh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaug.Gsw.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aug
 * JD-Core Version:    0.7.0.1
 */