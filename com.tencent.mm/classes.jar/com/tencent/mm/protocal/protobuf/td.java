package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class td
  extends cpx
{
  public String DQs;
  public String DQt;
  public String Enm;
  public String Enn;
  public int uiK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DQs == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.DQt == null)
      {
        paramVarArgs = new b("Not all required fields were included: trans_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.Enn == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_open_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
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
      if (this.Enm != null) {
        paramVarArgs.d(4, this.Enm);
      }
      if (this.Enn != null) {
        paramVarArgs.d(5, this.Enn);
      }
      paramVarArgs.aR(6, this.uiK);
      AppMethodBeat.o(91412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
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
      paramInt = i;
      if (this.Enm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Enm);
      }
      i = paramInt;
      if (this.Enn != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Enn);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.uiK);
      AppMethodBeat.o(91412);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.DQs == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.DQt == null)
        {
          paramVarArgs = new b("Not all required fields were included: trans_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.Enn == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_open_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        td localtd = (td)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91412);
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
            localtd.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91412);
          return 0;
        case 2: 
          localtd.DQs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 3: 
          localtd.DQt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 4: 
          localtd.Enm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 5: 
          localtd.Enn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91412);
          return 0;
        }
        localtd.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91412);
        return 0;
      }
      AppMethodBeat.o(91412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.td
 * JD-Core Version:    0.7.0.1
 */