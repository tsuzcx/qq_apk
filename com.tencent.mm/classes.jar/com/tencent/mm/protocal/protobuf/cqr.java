package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqr
  extends cpx
{
  public int CreateTime;
  public String DRb;
  public int FDI;
  public int FDJ;
  public int FDK;
  public long FDL;
  public String tlJ;
  public String tlK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32415);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DRb != null) {
        paramVarArgs.d(2, this.DRb);
      }
      paramVarArgs.aR(3, this.FDI);
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(5, this.FDJ);
      if (this.tlK != null) {
        paramVarArgs.d(6, this.tlK);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(7, this.tlJ);
      }
      paramVarArgs.aR(8, this.FDK);
      paramVarArgs.aO(9, this.FDL);
      AppMethodBeat.o(32415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label733;
      }
    }
    label733:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DRb != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.DRb);
      }
      i = i + f.a.a.b.b.a.bx(3, this.FDI) + f.a.a.b.b.a.bx(4, this.CreateTime) + f.a.a.b.b.a.bx(5, this.FDJ);
      paramInt = i;
      if (this.tlK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tlK);
      }
      i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.tlJ);
      }
      paramInt = f.a.a.b.b.a.bx(8, this.FDK);
      int j = f.a.a.b.b.a.p(9, this.FDL);
      AppMethodBeat.o(32415);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqr localcqr = (cqr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32415);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqr.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32415);
          return 0;
        case 2: 
          localcqr.DRb = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 3: 
          localcqr.FDI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32415);
          return 0;
        case 4: 
          localcqr.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32415);
          return 0;
        case 5: 
          localcqr.FDJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32415);
          return 0;
        case 6: 
          localcqr.tlK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 7: 
          localcqr.tlJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32415);
          return 0;
        case 8: 
          localcqr.FDK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32415);
          return 0;
        }
        localcqr.FDL = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(32415);
        return 0;
      }
      AppMethodBeat.o(32415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqr
 * JD-Core Version:    0.7.0.1
 */