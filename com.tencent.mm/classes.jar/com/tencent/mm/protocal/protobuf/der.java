package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class der
  extends cld
{
  public String Ewi;
  public String Ewj;
  public cta Ewk;
  public int dhR;
  public String dhS;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152714);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152714);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dhR);
      if (this.dhS != null) {
        paramVarArgs.d(3, this.dhS);
      }
      if (this.Ewi != null) {
        paramVarArgs.d(4, this.Ewi);
      }
      if (this.Ewj != null) {
        paramVarArgs.d(5, this.Ewj);
      }
      if (this.Ewk != null)
      {
        paramVarArgs.kX(6, this.Ewk.computeSize());
        this.Ewk.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.version);
      AppMethodBeat.o(152714);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.dhR);
      paramInt = i;
      if (this.dhS != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dhS);
      }
      i = paramInt;
      if (this.Ewi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Ewi);
      }
      paramInt = i;
      if (this.Ewj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ewj);
      }
      i = paramInt;
      if (this.Ewk != null) {
        i = paramInt + f.a.a.a.kW(6, this.Ewk.computeSize());
      }
      paramInt = f.a.a.b.b.a.bA(7, this.version);
      AppMethodBeat.o(152714);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152714);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152714);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        der localder = (der)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152714);
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
            localder.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        case 2: 
          localder.dhR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152714);
          return 0;
        case 3: 
          localder.dhS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 4: 
          localder.Ewi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 5: 
          localder.Ewj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152714);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localder.Ewk = ((cta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152714);
          return 0;
        }
        localder.version = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152714);
        return 0;
      }
      AppMethodBeat.o(152714);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.der
 * JD-Core Version:    0.7.0.1
 */