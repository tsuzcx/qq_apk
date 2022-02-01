package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ajk
  extends cpx
{
  public aiu EDL;
  public b EEb;
  public aje EEc;
  public int EEd;
  public int EEe;
  public String hlG;
  public String nickname;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.EEb != null) {
        paramVarArgs.c(3, this.EEb);
      }
      if (this.hlG != null) {
        paramVarArgs.d(4, this.hlG);
      }
      if (this.EDL != null)
      {
        paramVarArgs.ln(5, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      if (this.signature != null) {
        paramVarArgs.d(6, this.signature);
      }
      if (this.EEc != null)
      {
        paramVarArgs.ln(7, this.EEc.computeSize());
        this.EEc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.EEd);
      paramVarArgs.aR(9, this.EEe);
      AppMethodBeat.o(168948);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label958;
      }
    }
    label958:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.EEb != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.EEb);
      }
      paramInt = i;
      if (this.hlG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hlG);
      }
      i = paramInt;
      if (this.EDL != null) {
        i = paramInt + f.a.a.a.lm(5, this.EDL.computeSize());
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.signature);
      }
      i = paramInt;
      if (this.EEc != null) {
        i = paramInt + f.a.a.a.lm(7, this.EEc.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(8, this.EEd);
      int j = f.a.a.b.b.a.bx(9, this.EEe);
      AppMethodBeat.o(168948);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168948);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajk localajk = (ajk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168948);
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
            localajk.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 2: 
          localajk.nickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 3: 
          localajk.EEb = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(168948);
          return 0;
        case 4: 
          localajk.hlG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajk.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 6: 
          localajk.signature = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168948);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aje();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aje)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localajk.EEc = ((aje)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168948);
          return 0;
        case 8: 
          localajk.EEd = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168948);
          return 0;
        }
        localajk.EEe = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168948);
        return 0;
      }
      AppMethodBeat.o(168948);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajk
 * JD-Core Version:    0.7.0.1
 */