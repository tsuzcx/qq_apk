package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bxw
  extends cqk
{
  public LinkedList<dkj> EPD;
  public com.tencent.mm.bw.b EQz;
  public float FmF;
  public String FmG;
  public String FmH;
  public String FmI;
  public int hNR;
  
  public bxw()
  {
    AppMethodBeat.i(120958);
    this.EPD = new LinkedList();
    AppMethodBeat.o(120958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(120959);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.hNR);
      paramVarArgs.e(3, 8, this.EPD);
      if (this.EQz != null) {
        paramVarArgs.c(4, this.EQz);
      }
      paramVarArgs.x(5, this.FmF);
      if (this.FmG != null) {
        paramVarArgs.d(6, this.FmG);
      }
      if (this.FmH != null) {
        paramVarArgs.d(7, this.FmH);
      }
      if (this.FmI != null) {
        paramVarArgs.d(8, this.FmI);
      }
      AppMethodBeat.o(120959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label833;
      }
    }
    label833:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.hNR) + f.a.a.a.c(3, 8, this.EPD);
      paramInt = i;
      if (this.EQz != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.EQz);
      }
      i = paramInt + (f.a.a.b.b.a.fK(5) + 4);
      paramInt = i;
      if (this.FmG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FmG);
      }
      i = paramInt;
      if (this.FmH != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FmH);
      }
      paramInt = i;
      if (this.FmI != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FmI);
      }
      AppMethodBeat.o(120959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EPD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(120959);
          throw paramVarArgs;
        }
        AppMethodBeat.o(120959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bxw localbxw = (bxw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120959);
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
            localbxw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 2: 
          localbxw.hNR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(120959);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbxw.EPD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 4: 
          localbxw.EQz = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(120959);
          return 0;
        case 5: 
          localbxw.FmF = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(120959);
          return 0;
        case 6: 
          localbxw.FmG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(120959);
          return 0;
        case 7: 
          localbxw.FmH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(120959);
          return 0;
        }
        localbxw.FmI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(120959);
        return 0;
      }
      AppMethodBeat.o(120959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxw
 * JD-Core Version:    0.7.0.1
 */