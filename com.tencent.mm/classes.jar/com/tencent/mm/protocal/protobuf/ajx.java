package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajx
  extends cpx
{
  public aiu EDL;
  public int EEu;
  public int EEv;
  public long id;
  public String objectNonceId;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.id);
      paramVarArgs.aR(3, this.EEu);
      paramVarArgs.aR(4, this.EEv);
      if (this.objectNonceId != null) {
        paramVarArgs.d(5, this.objectNonceId);
      }
      if (this.EDL != null)
      {
        paramVarArgs.ln(6, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(7, this.sessionBuffer);
      }
      AppMethodBeat.o(168960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.id) + f.a.a.b.b.a.bx(3, this.EEu) + f.a.a.b.b.a.bx(4, this.EEv);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.objectNonceId);
      }
      i = paramInt;
      if (this.EDL != null) {
        i = paramInt + f.a.a.a.lm(6, this.EDL.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sessionBuffer);
      }
      AppMethodBeat.o(168960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168960);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajx localajx = (ajx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168960);
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
            localajx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168960);
          return 0;
        case 2: 
          localajx.id = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168960);
          return 0;
        case 3: 
          localajx.EEu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168960);
          return 0;
        case 4: 
          localajx.EEv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168960);
          return 0;
        case 5: 
          localajx.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168960);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajx.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168960);
          return 0;
        }
        localajx.sessionBuffer = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(168960);
        return 0;
      }
      AppMethodBeat.o(168960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajx
 * JD-Core Version:    0.7.0.1
 */