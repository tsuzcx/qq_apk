package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjo
  extends cqk
{
  public qb EPI;
  public bkd EPK;
  public String FtL;
  public String FtM;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72563);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72563);
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
      if (this.EPK != null)
      {
        paramVarArgs.ln(4, this.EPK.computeSize());
        this.EPK.writeFields(paramVarArgs);
      }
      if (this.FtL != null) {
        paramVarArgs.d(5, this.FtL);
      }
      if (this.FtM != null) {
        paramVarArgs.d(6, this.FtM);
      }
      if (this.EPI != null)
      {
        paramVarArgs.ln(7, this.EPI.computeSize());
        this.EPI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.EPK != null) {
        i = paramInt + f.a.a.a.lm(4, this.EPK.computeSize());
      }
      paramInt = i;
      if (this.FtL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FtL);
      }
      i = paramInt;
      if (this.FtM != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FtM);
      }
      paramInt = i;
      if (this.EPI != null) {
        paramInt = i + f.a.a.a.lm(7, this.EPI.computeSize());
      }
      AppMethodBeat.o(72563);
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
          AppMethodBeat.o(72563);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjo localcjo = (cjo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72563);
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
            localcjo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 2: 
          localcjo.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72563);
          return 0;
        case 3: 
          localcjo.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjo.EPK = ((bkd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 5: 
          localcjo.FtL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 6: 
          localcjo.FtM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72563);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjo.EPI = ((qb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      AppMethodBeat.o(72563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjo
 * JD-Core Version:    0.7.0.1
 */