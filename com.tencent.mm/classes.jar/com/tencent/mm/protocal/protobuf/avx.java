package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avx
  extends cqk
{
  public int ENU;
  public rg ENV;
  public rm ENW;
  public String ENX;
  public int ENY;
  public int ENZ;
  public rv EOa;
  public int nWx;
  public String nWy;
  public int oGs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206452);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(206452);
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
      paramVarArgs.aR(4, this.oGs);
      paramVarArgs.aR(5, this.ENU);
      if (this.ENV != null)
      {
        paramVarArgs.ln(6, this.ENV.computeSize());
        this.ENV.writeFields(paramVarArgs);
      }
      if (this.ENW != null)
      {
        paramVarArgs.ln(7, this.ENW.computeSize());
        this.ENW.writeFields(paramVarArgs);
      }
      if (this.ENX != null) {
        paramVarArgs.d(8, this.ENX);
      }
      paramVarArgs.aR(9, this.ENY);
      paramVarArgs.aR(10, this.ENZ);
      if (this.EOa != null)
      {
        paramVarArgs.ln(11, this.EOa.computeSize());
        this.EOa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(206452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1170;
      }
    }
    label1170:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.oGs) + f.a.a.b.b.a.bx(5, this.ENU);
      paramInt = i;
      if (this.ENV != null) {
        paramInt = i + f.a.a.a.lm(6, this.ENV.computeSize());
      }
      i = paramInt;
      if (this.ENW != null) {
        i = paramInt + f.a.a.a.lm(7, this.ENW.computeSize());
      }
      paramInt = i;
      if (this.ENX != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ENX);
      }
      i = paramInt + f.a.a.b.b.a.bx(9, this.ENY) + f.a.a.b.b.a.bx(10, this.ENZ);
      paramInt = i;
      if (this.EOa != null) {
        paramInt = i + f.a.a.a.lm(11, this.EOa.computeSize());
      }
      AppMethodBeat.o(206452);
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
          AppMethodBeat.o(206452);
          throw paramVarArgs;
        }
        AppMethodBeat.o(206452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avx localavx = (avx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206452);
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
            localavx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206452);
          return 0;
        case 2: 
          localavx.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206452);
          return 0;
        case 3: 
          localavx.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206452);
          return 0;
        case 4: 
          localavx.oGs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206452);
          return 0;
        case 5: 
          localavx.ENU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206452);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavx.ENV = ((rg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206452);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavx.ENW = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(206452);
          return 0;
        case 8: 
          localavx.ENX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(206452);
          return 0;
        case 9: 
          localavx.ENY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206452);
          return 0;
        case 10: 
          localavx.ENZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(206452);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavx.EOa = ((rv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(206452);
        return 0;
      }
      AppMethodBeat.o(206452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avx
 * JD-Core Version:    0.7.0.1
 */