package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azy
  extends cqk
{
  public int ENU;
  public rg ENV;
  public int ENY;
  public int ENZ;
  public rv EOa;
  public rk EQX;
  public rd EQY;
  public String EQZ;
  public rj ERa;
  public int nWx;
  public String nWy;
  public int oGs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114029);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114029);
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
      if (this.EQX != null)
      {
        paramVarArgs.ln(7, this.EQX.computeSize());
        this.EQX.writeFields(paramVarArgs);
      }
      if (this.EQY != null)
      {
        paramVarArgs.ln(8, this.EQY.computeSize());
        this.EQY.writeFields(paramVarArgs);
      }
      if (this.EQZ != null) {
        paramVarArgs.d(10, this.EQZ);
      }
      paramVarArgs.aR(11, this.ENY);
      paramVarArgs.aR(12, this.ENZ);
      if (this.EOa != null)
      {
        paramVarArgs.ln(13, this.EOa.computeSize());
        this.EOa.writeFields(paramVarArgs);
      }
      if (this.ERa != null)
      {
        paramVarArgs.ln(14, this.ERa.computeSize());
        this.ERa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
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
      if (this.EQX != null) {
        i = paramInt + f.a.a.a.lm(7, this.EQX.computeSize());
      }
      paramInt = i;
      if (this.EQY != null) {
        paramInt = i + f.a.a.a.lm(8, this.EQY.computeSize());
      }
      i = paramInt;
      if (this.EQZ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.EQZ);
      }
      i = i + f.a.a.b.b.a.bx(11, this.ENY) + f.a.a.b.b.a.bx(12, this.ENZ);
      paramInt = i;
      if (this.EOa != null) {
        paramInt = i + f.a.a.a.lm(13, this.EOa.computeSize());
      }
      i = paramInt;
      if (this.ERa != null) {
        i = paramInt + f.a.a.a.lm(14, this.ERa.computeSize());
      }
      AppMethodBeat.o(114029);
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
          AppMethodBeat.o(114029);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azy localazy = (azy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(114029);
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
            localazy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 2: 
          localazy.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114029);
          return 0;
        case 3: 
          localazy.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 4: 
          localazy.oGs = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114029);
          return 0;
        case 5: 
          localazy.ENU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114029);
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
            localazy.ENV = ((rg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazy.EQX = ((rk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazy.EQY = ((rd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 10: 
          localazy.EQZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 11: 
          localazy.ENY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114029);
          return 0;
        case 12: 
          localazy.ENZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114029);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazy.EOa = ((rv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new rj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((rj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazy.ERa = ((rj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      AppMethodBeat.o(114029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azy
 * JD-Core Version:    0.7.0.1
 */