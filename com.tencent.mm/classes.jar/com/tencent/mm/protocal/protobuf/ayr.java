package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayr
  extends cqk
{
  public int DWU;
  public String DWV;
  public LinkedList<afb> EPX;
  public int EPY;
  
  public ayr()
  {
    AppMethodBeat.i(91487);
    this.EPX = new LinkedList();
    AppMethodBeat.o(91487);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91488);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91488);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.EPX);
      paramVarArgs.aR(3, this.EPY);
      paramVarArgs.aR(4, this.DWU);
      if (this.DWV != null) {
        paramVarArgs.d(5, this.DWV);
      }
      AppMethodBeat.o(91488);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.EPX) + f.a.a.b.b.a.bx(3, this.EPY) + f.a.a.b.b.a.bx(4, this.DWU);
      paramInt = i;
      if (this.DWV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DWV);
      }
      AppMethodBeat.o(91488);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EPX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91488);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91488);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayr localayr = (ayr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91488);
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
            localayr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91488);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((afb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayr.EPX.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91488);
          return 0;
        case 3: 
          localayr.EPY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91488);
          return 0;
        case 4: 
          localayr.DWU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91488);
          return 0;
        }
        localayr.DWV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91488);
        return 0;
      }
      AppMethodBeat.o(91488);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayr
 * JD-Core Version:    0.7.0.1
 */