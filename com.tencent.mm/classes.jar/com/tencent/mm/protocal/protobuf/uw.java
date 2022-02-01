package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class uw
  extends cqk
{
  public dzq EoS;
  public boolean EoT;
  public String EoU;
  public String EoV;
  public boolean EoW;
  public String EoX;
  public String EoY;
  public String EoZ;
  public String Epa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.EoS != null)
      {
        paramVarArgs.ln(2, this.EoS.computeSize());
        this.EoS.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(3, this.EoT);
      if (this.EoU != null) {
        paramVarArgs.d(4, this.EoU);
      }
      if (this.EoV != null) {
        paramVarArgs.d(5, this.EoV);
      }
      paramVarArgs.bl(6, this.EoW);
      if (this.EoX != null) {
        paramVarArgs.d(7, this.EoX);
      }
      if (this.EoY != null) {
        paramVarArgs.d(8, this.EoY);
      }
      if (this.EoZ != null) {
        paramVarArgs.d(9, this.EoZ);
      }
      if (this.Epa != null) {
        paramVarArgs.d(10, this.Epa);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EoS != null) {
        i = paramInt + f.a.a.a.lm(2, this.EoS.computeSize());
      }
      i += f.a.a.b.b.a.fK(3) + 1;
      paramInt = i;
      if (this.EoU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EoU);
      }
      i = paramInt;
      if (this.EoV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EoV);
      }
      i += f.a.a.b.b.a.fK(6) + 1;
      paramInt = i;
      if (this.EoX != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EoX);
      }
      i = paramInt;
      if (this.EoY != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EoY);
      }
      paramInt = i;
      if (this.EoZ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EoZ);
      }
      i = paramInt;
      if (this.Epa != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Epa);
      }
      AppMethodBeat.o(123562);
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
          AppMethodBeat.o(123562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uw localuw = (uw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123562);
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
            localuw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localuw.EoS = ((dzq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 3: 
          localuw.EoT = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(123562);
          return 0;
        case 4: 
          localuw.EoU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 5: 
          localuw.EoV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 6: 
          localuw.EoW = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(123562);
          return 0;
        case 7: 
          localuw.EoX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 8: 
          localuw.EoY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 9: 
          localuw.EoZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123562);
          return 0;
        }
        localuw.Epa = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123562);
        return 0;
      }
      AppMethodBeat.o(123562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uw
 * JD-Core Version:    0.7.0.1
 */