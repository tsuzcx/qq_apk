package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class axd
  extends cqk
{
  public float EPb;
  public String EPc;
  public String Epl;
  public String action_data;
  public int nWx;
  public String nWy;
  public String person_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104370);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104370);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      if (this.person_id != null) {
        paramVarArgs.d(4, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.d(5, this.action_data);
      }
      paramVarArgs.x(6, this.EPb);
      if (this.Epl != null) {
        paramVarArgs.d(7, this.Epl);
      }
      if (this.EPc != null) {
        paramVarArgs.d(8, this.EPc);
      }
      AppMethodBeat.o(104370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label753;
      }
    }
    label753:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.person_id != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.person_id);
      }
      paramInt = i;
      if (this.action_data != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.action_data);
      }
      i = paramInt + (f.a.a.b.b.a.fK(6) + 4);
      paramInt = i;
      if (this.Epl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Epl);
      }
      i = paramInt;
      if (this.EPc != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EPc);
      }
      AppMethodBeat.o(104370);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104370);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axd localaxd = (axd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104370);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaxd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104370);
          return 0;
        case 2: 
          localaxd.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104370);
          return 0;
        case 3: 
          localaxd.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 4: 
          localaxd.person_id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 5: 
          localaxd.action_data = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 6: 
          localaxd.EPb = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(104370);
          return 0;
        case 7: 
          localaxd.Epl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104370);
          return 0;
        }
        localaxd.EPc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(104370);
        return 0;
      }
      AppMethodBeat.o(104370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axd
 * JD-Core Version:    0.7.0.1
 */