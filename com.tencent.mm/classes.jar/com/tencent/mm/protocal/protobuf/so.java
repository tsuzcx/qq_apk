package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class so
  extends cpx
{
  public String DQs;
  public String DQt;
  public String Emy;
  public String Emz;
  public int channel;
  public int uiK;
  public int wJT;
  public String wLn;
  public String wLo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91403);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DQs != null) {
        paramVarArgs.d(2, this.DQs);
      }
      if (this.DQt != null) {
        paramVarArgs.d(3, this.DQt);
      }
      paramVarArgs.aR(4, this.uiK);
      if (this.wLo != null) {
        paramVarArgs.d(5, this.wLo);
      }
      if (this.wLn != null) {
        paramVarArgs.d(6, this.wLn);
      }
      paramVarArgs.aR(7, this.channel);
      paramVarArgs.aR(8, this.wJT);
      if (this.Emy != null) {
        paramVarArgs.d(9, this.Emy);
      }
      if (this.Emz != null) {
        paramVarArgs.d(10, this.Emz);
      }
      AppMethodBeat.o(91403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label810;
      }
    }
    label810:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DQs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DQs);
      }
      i = paramInt;
      if (this.DQt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DQt);
      }
      i += f.a.a.b.b.a.bx(4, this.uiK);
      paramInt = i;
      if (this.wLo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wLo);
      }
      i = paramInt;
      if (this.wLn != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.wLn);
      }
      i = i + f.a.a.b.b.a.bx(7, this.channel) + f.a.a.b.b.a.bx(8, this.wJT);
      paramInt = i;
      if (this.Emy != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Emy);
      }
      i = paramInt;
      if (this.Emz != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Emz);
      }
      AppMethodBeat.o(91403);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        so localso = (so)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91403);
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
            localso.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91403);
          return 0;
        case 2: 
          localso.DQs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 3: 
          localso.DQt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 4: 
          localso.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91403);
          return 0;
        case 5: 
          localso.wLo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 6: 
          localso.wLn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 7: 
          localso.channel = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91403);
          return 0;
        case 8: 
          localso.wJT = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91403);
          return 0;
        case 9: 
          localso.Emy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91403);
          return 0;
        }
        localso.Emz = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91403);
        return 0;
      }
      AppMethodBeat.o(91403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.so
 * JD-Core Version:    0.7.0.1
 */