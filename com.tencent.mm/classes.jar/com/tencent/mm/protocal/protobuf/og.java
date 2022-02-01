package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class og
  extends cpx
{
  public int DLC;
  public String DLD;
  public String EaV;
  public bre Eef;
  public cry Eeg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EaV != null) {
        paramVarArgs.d(2, this.EaV);
      }
      if (this.Eef != null)
      {
        paramVarArgs.ln(3, this.Eef.computeSize());
        this.Eef.writeFields(paramVarArgs);
      }
      if (this.Eeg != null)
      {
        paramVarArgs.ln(4, this.Eeg.computeSize());
        this.Eeg.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.DLC);
      if (this.DLD != null) {
        paramVarArgs.d(6, this.DLD);
      }
      AppMethodBeat.o(32149);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EaV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EaV);
      }
      i = paramInt;
      if (this.Eef != null) {
        i = paramInt + f.a.a.a.lm(3, this.Eef.computeSize());
      }
      paramInt = i;
      if (this.Eeg != null) {
        paramInt = i + f.a.a.a.lm(4, this.Eeg.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.DLC);
      paramInt = i;
      if (this.DLD != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DLD);
      }
      AppMethodBeat.o(32149);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32149);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        og localog = (og)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32149);
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
            localog.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 2: 
          localog.EaV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32149);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bre();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bre)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localog.Eef = ((bre)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cry();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localog.Eeg = ((cry)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32149);
          return 0;
        case 5: 
          localog.DLC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32149);
          return 0;
        }
        localog.DLD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32149);
        return 0;
      }
      AppMethodBeat.o(32149);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.og
 * JD-Core Version:    0.7.0.1
 */