package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class yi
  extends dpc
{
  public fcd Ljo;
  public boolean Ljp;
  public String Ljq;
  public String Ljr;
  public boolean Ljs;
  public String Ljt;
  public String Lju;
  public String Ljv;
  public String Ljw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123562);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ljo != null)
      {
        paramVarArgs.ni(2, this.Ljo.computeSize());
        this.Ljo.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(3, this.Ljp);
      if (this.Ljq != null) {
        paramVarArgs.e(4, this.Ljq);
      }
      if (this.Ljr != null) {
        paramVarArgs.e(5, this.Ljr);
      }
      paramVarArgs.cc(6, this.Ljs);
      if (this.Ljt != null) {
        paramVarArgs.e(7, this.Ljt);
      }
      if (this.Lju != null) {
        paramVarArgs.e(8, this.Lju);
      }
      if (this.Ljv != null) {
        paramVarArgs.e(9, this.Ljv);
      }
      if (this.Ljw != null) {
        paramVarArgs.e(10, this.Ljw);
      }
      AppMethodBeat.o(123562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label966;
      }
    }
    label966:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ljo != null) {
        i = paramInt + g.a.a.a.nh(2, this.Ljo.computeSize());
      }
      i += g.a.a.b.b.a.fS(3) + 1;
      paramInt = i;
      if (this.Ljq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Ljq);
      }
      i = paramInt;
      if (this.Ljr != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Ljr);
      }
      i += g.a.a.b.b.a.fS(6) + 1;
      paramInt = i;
      if (this.Ljt != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Ljt);
      }
      i = paramInt;
      if (this.Lju != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Lju);
      }
      paramInt = i;
      if (this.Ljv != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Ljv);
      }
      i = paramInt;
      if (this.Ljw != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Ljw);
      }
      AppMethodBeat.o(123562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        yi localyi = (yi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123562);
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
            localyi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fcd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fcd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localyi.Ljo = ((fcd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 3: 
          localyi.Ljp = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(123562);
          return 0;
        case 4: 
          localyi.Ljq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 5: 
          localyi.Ljr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 6: 
          localyi.Ljs = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(123562);
          return 0;
        case 7: 
          localyi.Ljt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 8: 
          localyi.Lju = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 9: 
          localyi.Ljv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123562);
          return 0;
        }
        localyi.Ljw = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123562);
        return 0;
      }
      AppMethodBeat.o(123562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yi
 * JD-Core Version:    0.7.0.1
 */