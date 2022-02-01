package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bze
  extends cld
{
  public String DVQ;
  public String DoP;
  public String DoQ;
  public int oXv;
  public String oXw;
  public String rZo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91584);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91584);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.DoP != null) {
        paramVarArgs.d(2, this.DoP);
      }
      if (this.rZo != null) {
        paramVarArgs.d(3, this.rZo);
      }
      if (this.DoQ != null) {
        paramVarArgs.d(4, this.DoQ);
      }
      paramVarArgs.aR(5, this.oXv);
      if (this.oXw != null) {
        paramVarArgs.d(6, this.oXw);
      }
      if (this.DVQ != null) {
        paramVarArgs.d(7, this.DVQ);
      }
      AppMethodBeat.o(91584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DoP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DoP);
      }
      i = paramInt;
      if (this.rZo != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rZo);
      }
      paramInt = i;
      if (this.DoQ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DoQ);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.oXv);
      paramInt = i;
      if (this.oXw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.oXw);
      }
      i = paramInt;
      if (this.DVQ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DVQ);
      }
      AppMethodBeat.o(91584);
      return i;
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
          AppMethodBeat.o(91584);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91584);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bze localbze = (bze)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91584);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbze.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91584);
          return 0;
        case 2: 
          localbze.DoP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91584);
          return 0;
        case 3: 
          localbze.rZo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91584);
          return 0;
        case 4: 
          localbze.DoQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91584);
          return 0;
        case 5: 
          localbze.oXv = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91584);
          return 0;
        case 6: 
          localbze.oXw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91584);
          return 0;
        }
        localbze.DVQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91584);
        return 0;
      }
      AppMethodBeat.o(91584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bze
 * JD-Core Version:    0.7.0.1
 */