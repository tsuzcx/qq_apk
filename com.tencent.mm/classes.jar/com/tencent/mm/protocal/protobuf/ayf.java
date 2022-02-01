package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayf
  extends cqk
{
  public bta EOd;
  public qb EPI;
  public bis EPJ;
  public bkd EPK;
  public biu Epe;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72489);
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
      if (this.Epe != null)
      {
        paramVarArgs.ln(4, this.Epe.computeSize());
        this.Epe.writeFields(paramVarArgs);
      }
      if (this.EPI != null)
      {
        paramVarArgs.ln(8, this.EPI.computeSize());
        this.EPI.writeFields(paramVarArgs);
      }
      if (this.EOd != null)
      {
        paramVarArgs.ln(9, this.EOd.computeSize());
        this.EOd.writeFields(paramVarArgs);
      }
      if (this.EPJ != null)
      {
        paramVarArgs.ln(10, this.EPJ.computeSize());
        this.EPJ.writeFields(paramVarArgs);
      }
      if (this.EPK != null)
      {
        paramVarArgs.ln(11, this.EPK.computeSize());
        this.EPK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1254;
      }
    }
    label1254:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.Epe != null) {
        i = paramInt + f.a.a.a.lm(4, this.Epe.computeSize());
      }
      paramInt = i;
      if (this.EPI != null) {
        paramInt = i + f.a.a.a.lm(8, this.EPI.computeSize());
      }
      i = paramInt;
      if (this.EOd != null) {
        i = paramInt + f.a.a.a.lm(9, this.EOd.computeSize());
      }
      paramInt = i;
      if (this.EPJ != null) {
        paramInt = i + f.a.a.a.lm(10, this.EPJ.computeSize());
      }
      i = paramInt;
      if (this.EPK != null) {
        i = paramInt + f.a.a.a.lm(11, this.EPK.computeSize());
      }
      AppMethodBeat.o(72489);
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
          AppMethodBeat.o(72489);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayf localayf = (ayf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(72489);
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
            localayf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 2: 
          localayf.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72489);
          return 0;
        case 3: 
          localayf.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72489);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new biu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((biu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayf.Epe = ((biu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayf.EPI = ((qb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayf.EOd = ((bta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bis();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bis)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayf.EPJ = ((bis)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localayf.EPK = ((bkd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72489);
        return 0;
      }
      AppMethodBeat.o(72489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayf
 * JD-Core Version:    0.7.0.1
 */