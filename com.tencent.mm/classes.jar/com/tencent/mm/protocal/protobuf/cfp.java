package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cfp
  extends cqk
{
  public long AWD;
  public String AWE;
  public String AWG;
  public String AWH;
  public LinkedList<cfq> FtU;
  public in FtV;
  public int FtW;
  public int nWx;
  public String nWy;
  
  public cfp()
  {
    AppMethodBeat.i(91616);
    this.FtU = new LinkedList();
    AppMethodBeat.o(91616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91617);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91617);
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
      paramVarArgs.e(4, 8, this.FtU);
      paramVarArgs.aO(5, this.AWD);
      if (this.AWE != null) {
        paramVarArgs.d(6, this.AWE);
      }
      if (this.FtV != null)
      {
        paramVarArgs.ln(7, this.FtV.computeSize());
        this.FtV.writeFields(paramVarArgs);
      }
      if (this.AWG != null) {
        paramVarArgs.d(8, this.AWG);
      }
      if (this.AWH != null) {
        paramVarArgs.d(9, this.AWH);
      }
      paramVarArgs.aR(10, this.FtW);
      AppMethodBeat.o(91617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1034;
      }
    }
    label1034:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.FtU) + f.a.a.b.b.a.p(5, this.AWD);
      paramInt = i;
      if (this.AWE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.AWE);
      }
      i = paramInt;
      if (this.FtV != null) {
        i = paramInt + f.a.a.a.lm(7, this.FtV.computeSize());
      }
      paramInt = i;
      if (this.AWG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.AWG);
      }
      i = paramInt;
      if (this.AWH != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.AWH);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.FtW);
      AppMethodBeat.o(91617);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FtU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfp localcfp = (cfp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91617);
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
            localcfp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 2: 
          localcfp.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91617);
          return 0;
        case 3: 
          localcfp.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfp.FtU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 5: 
          localcfp.AWD = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91617);
          return 0;
        case 6: 
          localcfp.AWE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new in();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((in)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcfp.FtV = ((in)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91617);
          return 0;
        case 8: 
          localcfp.AWG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91617);
          return 0;
        case 9: 
          localcfp.AWH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91617);
          return 0;
        }
        localcfp.FtW = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91617);
        return 0;
      }
      AppMethodBeat.o(91617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfp
 * JD-Core Version:    0.7.0.1
 */