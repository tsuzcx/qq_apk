package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpz
  extends cqk
{
  public String EfL;
  public dm FCX;
  public int dae;
  public String oxf;
  public String skK;
  public String tGS;
  public String wET;
  public String wEU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72582);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72582);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.dae);
      if (this.oxf != null) {
        paramVarArgs.d(3, this.oxf);
      }
      if (this.skK != null) {
        paramVarArgs.d(4, this.skK);
      }
      if (this.EfL != null) {
        paramVarArgs.d(5, this.EfL);
      }
      if (this.wET != null) {
        paramVarArgs.d(6, this.wET);
      }
      if (this.wEU != null) {
        paramVarArgs.d(7, this.wEU);
      }
      if (this.tGS != null) {
        paramVarArgs.d(8, this.tGS);
      }
      if (this.FCX != null)
      {
        paramVarArgs.ln(9, this.FCX.computeSize());
        this.FCX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72582);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.dae);
      paramInt = i;
      if (this.oxf != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oxf);
      }
      i = paramInt;
      if (this.skK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.skK);
      }
      paramInt = i;
      if (this.EfL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EfL);
      }
      i = paramInt;
      if (this.wET != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.wET);
      }
      paramInt = i;
      if (this.wEU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wEU);
      }
      i = paramInt;
      if (this.tGS != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.tGS);
      }
      paramInt = i;
      if (this.FCX != null) {
        paramInt = i + f.a.a.a.lm(9, this.FCX.computeSize());
      }
      AppMethodBeat.o(72582);
      return paramInt;
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
          AppMethodBeat.o(72582);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpz localcpz = (cpz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72582);
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
            localcpz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72582);
          return 0;
        case 2: 
          localcpz.dae = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72582);
          return 0;
        case 3: 
          localcpz.oxf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 4: 
          localcpz.skK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 5: 
          localcpz.EfL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 6: 
          localcpz.wET = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 7: 
          localcpz.wEU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72582);
          return 0;
        case 8: 
          localcpz.tGS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72582);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcpz.FCX = ((dm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72582);
        return 0;
      }
      AppMethodBeat.o(72582);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpz
 * JD-Core Version:    0.7.0.1
 */