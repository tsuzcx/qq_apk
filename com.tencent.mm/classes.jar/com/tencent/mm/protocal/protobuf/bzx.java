package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzx
  extends cqk
{
  public String DXU;
  public cfz DXV;
  public cbk DXW;
  public String FoF;
  public String FoM;
  public blk FoN;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72531);
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
      if (this.FoF != null) {
        paramVarArgs.d(4, this.FoF);
      }
      if (this.DXU != null) {
        paramVarArgs.d(5, this.DXU);
      }
      if (this.FoM != null) {
        paramVarArgs.d(6, this.FoM);
      }
      if (this.DXV != null)
      {
        paramVarArgs.ln(7, this.DXV.computeSize());
        this.DXV.writeFields(paramVarArgs);
      }
      if (this.DXW != null)
      {
        paramVarArgs.ln(8, this.DXW.computeSize());
        this.DXW.writeFields(paramVarArgs);
      }
      if (this.FoN != null)
      {
        paramVarArgs.ln(9, this.FoN.computeSize());
        this.FoN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.FoF != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FoF);
      }
      paramInt = i;
      if (this.DXU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DXU);
      }
      i = paramInt;
      if (this.FoM != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FoM);
      }
      paramInt = i;
      if (this.DXV != null) {
        paramInt = i + f.a.a.a.lm(7, this.DXV.computeSize());
      }
      i = paramInt;
      if (this.DXW != null) {
        i = paramInt + f.a.a.a.lm(8, this.DXW.computeSize());
      }
      paramInt = i;
      if (this.FoN != null) {
        paramInt = i + f.a.a.a.lm(9, this.FoN.computeSize());
      }
      AppMethodBeat.o(72531);
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
          AppMethodBeat.o(72531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzx localbzx = (bzx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72531);
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
            localbzx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 2: 
          localbzx.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72531);
          return 0;
        case 3: 
          localbzx.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 4: 
          localbzx.FoF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 5: 
          localbzx.DXU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 6: 
          localbzx.FoM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzx.DXV = ((cfz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzx.DXW = ((cbk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new blk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((blk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzx.FoN = ((blk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      AppMethodBeat.o(72531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzx
 * JD-Core Version:    0.7.0.1
 */