package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzd
  extends cqk
{
  public String AWZ;
  public String AXa;
  public String AXb;
  public int AXc;
  public String AXd;
  public String AYl;
  public brl FnZ;
  public String Foa;
  public agt Fob;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91559);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91559);
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
      if (this.FnZ != null)
      {
        paramVarArgs.ln(4, this.FnZ.computeSize());
        this.FnZ.writeFields(paramVarArgs);
      }
      if (this.AWZ != null) {
        paramVarArgs.d(5, this.AWZ);
      }
      if (this.AXa != null) {
        paramVarArgs.d(6, this.AXa);
      }
      if (this.AXb != null) {
        paramVarArgs.d(7, this.AXb);
      }
      paramVarArgs.aR(8, this.AXc);
      if (this.AXd != null) {
        paramVarArgs.d(9, this.AXd);
      }
      if (this.Foa != null) {
        paramVarArgs.d(10, this.Foa);
      }
      if (this.Fob != null)
      {
        paramVarArgs.ln(11, this.Fob.computeSize());
        this.Fob.writeFields(paramVarArgs);
      }
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(91559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1234;
      }
    }
    label1234:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.FnZ != null) {
        i = paramInt + f.a.a.a.lm(4, this.FnZ.computeSize());
      }
      paramInt = i;
      if (this.AWZ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.AWZ);
      }
      i = paramInt;
      if (this.AXa != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.AXa);
      }
      paramInt = i;
      if (this.AXb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.AXb);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.AXc);
      paramInt = i;
      if (this.AXd != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.AXd);
      }
      i = paramInt;
      if (this.Foa != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Foa);
      }
      paramInt = i;
      if (this.Fob != null) {
        paramInt = i + f.a.a.a.lm(11, this.Fob.computeSize());
      }
      i = paramInt;
      if (this.AYl != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(91559);
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
          AppMethodBeat.o(91559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91559);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzd localbzd = (bzd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91559);
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
            localbzd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 2: 
          localbzd.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91559);
          return 0;
        case 3: 
          localbzd.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzd.FnZ = ((brl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        case 5: 
          localbzd.AWZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 6: 
          localbzd.AXa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 7: 
          localbzd.AXb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 8: 
          localbzd.AXc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91559);
          return 0;
        case 9: 
          localbzd.AXd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 10: 
          localbzd.Foa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91559);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((agt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzd.Fob = ((agt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91559);
          return 0;
        }
        localbzd.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91559);
        return 0;
      }
      AppMethodBeat.o(91559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzd
 * JD-Core Version:    0.7.0.1
 */