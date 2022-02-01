package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class byp
  extends dpc
{
  public long LWJ;
  public String LWK;
  public String LWL;
  public abq LWM;
  public long LoC;
  public String MdW;
  public boolean MdX = false;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214310);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(214310);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.LoC);
      paramVarArgs.bb(3, this.LWJ);
      if (this.MdW != null) {
        paramVarArgs.e(4, this.MdW);
      }
      if (this.LWK != null) {
        paramVarArgs.e(5, this.LWK);
      }
      paramVarArgs.cc(6, this.MdX);
      if (this.LWL != null) {
        paramVarArgs.e(7, this.LWL);
      }
      if (this.LWM != null)
      {
        paramVarArgs.ni(8, this.LWM.computeSize());
        this.LWM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(214310);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LoC) + g.a.a.b.b.a.r(3, this.LWJ);
      paramInt = i;
      if (this.MdW != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MdW);
      }
      i = paramInt;
      if (this.LWK != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LWK);
      }
      i += g.a.a.b.b.a.fS(6) + 1;
      paramInt = i;
      if (this.LWL != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LWL);
      }
      i = paramInt;
      if (this.LWM != null) {
        i = paramInt + g.a.a.a.nh(8, this.LWM.computeSize());
      }
      AppMethodBeat.o(214310);
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
          AppMethodBeat.o(214310);
          throw paramVarArgs;
        }
        AppMethodBeat.o(214310);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        byp localbyp = (byp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214310);
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
            localbyp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214310);
          return 0;
        case 2: 
          localbyp.LoC = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(214310);
          return 0;
        case 3: 
          localbyp.LWJ = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(214310);
          return 0;
        case 4: 
          localbyp.MdW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214310);
          return 0;
        case 5: 
          localbyp.LWK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214310);
          return 0;
        case 6: 
          localbyp.MdX = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(214310);
          return 0;
        case 7: 
          localbyp.LWL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214310);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbyp.LWM = ((abq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(214310);
        return 0;
      }
      AppMethodBeat.o(214310);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byp
 * JD-Core Version:    0.7.0.1
 */