package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ad
  extends cld
{
  public String CtA;
  public int CtB;
  public String Ctp;
  public int Ctq;
  public int Ctr;
  public String Cts;
  public ctl Ctt;
  public cij Ctu;
  public ctl Ctv;
  public ces Ctw;
  public amu Ctx;
  public hj Cty;
  public String Ctz;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32097);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32097);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ctp != null) {
        paramVarArgs.d(2, this.Ctp);
      }
      paramVarArgs.aR(3, this.Ctq);
      paramVarArgs.aR(4, this.Ctr);
      if (this.Cts != null) {
        paramVarArgs.d(5, this.Cts);
      }
      if (this.Ctt != null)
      {
        paramVarArgs.kX(6, this.Ctt.computeSize());
        this.Ctt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.OpCode);
      if (this.Ctu != null)
      {
        paramVarArgs.kX(8, this.Ctu.computeSize());
        this.Ctu.writeFields(paramVarArgs);
      }
      if (this.Ctv != null)
      {
        paramVarArgs.kX(9, this.Ctv.computeSize());
        this.Ctv.writeFields(paramVarArgs);
      }
      if (this.Ctw != null)
      {
        paramVarArgs.kX(10, this.Ctw.computeSize());
        this.Ctw.writeFields(paramVarArgs);
      }
      if (this.Ctx != null)
      {
        paramVarArgs.kX(11, this.Ctx.computeSize());
        this.Ctx.writeFields(paramVarArgs);
      }
      if (this.Cty != null)
      {
        paramVarArgs.kX(12, this.Cty.computeSize());
        this.Cty.writeFields(paramVarArgs);
      }
      if (this.Ctz != null) {
        paramVarArgs.d(13, this.Ctz);
      }
      if (this.CtA != null) {
        paramVarArgs.d(14, this.CtA);
      }
      paramVarArgs.aR(15, this.CtB);
      AppMethodBeat.o(32097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1739;
      }
    }
    label1739:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ctp != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ctp);
      }
      i = i + f.a.a.b.b.a.bA(3, this.Ctq) + f.a.a.b.b.a.bA(4, this.Ctr);
      paramInt = i;
      if (this.Cts != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Cts);
      }
      i = paramInt;
      if (this.Ctt != null) {
        i = paramInt + f.a.a.a.kW(6, this.Ctt.computeSize());
      }
      i += f.a.a.b.b.a.bA(7, this.OpCode);
      paramInt = i;
      if (this.Ctu != null) {
        paramInt = i + f.a.a.a.kW(8, this.Ctu.computeSize());
      }
      i = paramInt;
      if (this.Ctv != null) {
        i = paramInt + f.a.a.a.kW(9, this.Ctv.computeSize());
      }
      paramInt = i;
      if (this.Ctw != null) {
        paramInt = i + f.a.a.a.kW(10, this.Ctw.computeSize());
      }
      i = paramInt;
      if (this.Ctx != null) {
        i = paramInt + f.a.a.a.kW(11, this.Ctx.computeSize());
      }
      paramInt = i;
      if (this.Cty != null) {
        paramInt = i + f.a.a.a.kW(12, this.Cty.computeSize());
      }
      i = paramInt;
      if (this.Ctz != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Ctz);
      }
      paramInt = i;
      if (this.CtA != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.CtA);
      }
      i = f.a.a.b.b.a.bA(15, this.CtB);
      AppMethodBeat.o(32097);
      return paramInt + i;
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
          AppMethodBeat.o(32097);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32097);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32097);
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
            localad.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 2: 
          localad.Ctp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 3: 
          localad.Ctq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32097);
          return 0;
        case 4: 
          localad.Ctr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32097);
          return 0;
        case 5: 
          localad.Cts = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.Ctt = ((ctl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 7: 
          localad.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32097);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cij();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cij)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.Ctu = ((cij)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.Ctv = ((ctl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ces();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ces)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.Ctw = ((ces)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.Ctx = ((amu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localad.Cty = ((hj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 13: 
          localad.Ctz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 14: 
          localad.CtA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32097);
          return 0;
        }
        localad.CtB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32097);
        return 0;
      }
      AppMethodBeat.o(32097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ad
 * JD-Core Version:    0.7.0.1
 */