package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aow
  extends cpx
{
  public aiu EDL;
  public String EEI;
  public int EHM;
  public String firstPageMD5;
  public b lastBuffer;
  public String username;
  public long xRo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169070);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aO(3, this.xRo);
      if (this.firstPageMD5 != null) {
        paramVarArgs.d(4, this.firstPageMD5);
      }
      if (this.EEI != null) {
        paramVarArgs.d(5, this.EEI);
      }
      paramVarArgs.aR(6, this.EHM);
      if (this.EDL != null)
      {
        paramVarArgs.ln(7, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(8, this.lastBuffer);
      }
      AppMethodBeat.o(169070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i += f.a.a.b.b.a.p(3, this.xRo);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.firstPageMD5);
      }
      i = paramInt;
      if (this.EEI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EEI);
      }
      i += f.a.a.b.b.a.bx(6, this.EHM);
      paramInt = i;
      if (this.EDL != null) {
        paramInt = i + f.a.a.a.lm(7, this.EDL.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(8, this.lastBuffer);
      }
      AppMethodBeat.o(169070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169070);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aow localaow = (aow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169070);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaow.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        case 2: 
          localaow.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 3: 
          localaow.xRo = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169070);
          return 0;
        case 4: 
          localaow.firstPageMD5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 5: 
          localaow.EEI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 6: 
          localaow.EHM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169070);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaow.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        }
        localaow.lastBuffer = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(169070);
        return 0;
      }
      AppMethodBeat.o(169070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aow
 * JD-Core Version:    0.7.0.1
 */