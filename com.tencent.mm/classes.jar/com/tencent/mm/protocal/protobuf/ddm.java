package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ddm
  extends cpx
{
  public String DSu;
  public ddk FNh;
  public ddk FNi;
  public int FNj;
  public int FNk;
  public String hkN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNh == null)
      {
        paramVarArgs = new b("Not all required fields were included: CommentDetail");
        AppMethodBeat.o(118439);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hkN != null) {
        paramVarArgs.d(2, this.hkN);
      }
      if (this.FNh != null)
      {
        paramVarArgs.ln(3, this.FNh.computeSize());
        this.FNh.writeFields(paramVarArgs);
      }
      if (this.FNi != null)
      {
        paramVarArgs.ln(6, this.FNi.computeSize());
        this.FNi.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.FNj);
      paramVarArgs.aR(5, this.FNk);
      if (this.DSu != null) {
        paramVarArgs.d(7, this.DSu);
      }
      AppMethodBeat.o(118439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hkN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hkN);
      }
      i = paramInt;
      if (this.FNh != null) {
        i = paramInt + f.a.a.a.lm(3, this.FNh.computeSize());
      }
      paramInt = i;
      if (this.FNi != null) {
        paramInt = i + f.a.a.a.lm(6, this.FNi.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.FNj) + f.a.a.b.b.a.bx(5, this.FNk);
      paramInt = i;
      if (this.DSu != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DSu);
      }
      AppMethodBeat.o(118439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FNh == null)
        {
          paramVarArgs = new b("Not all required fields were included: CommentDetail");
          AppMethodBeat.o(118439);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ddm localddm = (ddm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118439);
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
            localddm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 2: 
          localddm.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(118439);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddm.FNh = ((ddk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ddk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ddk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localddm.FNi = ((ddk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118439);
          return 0;
        case 4: 
          localddm.FNj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118439);
          return 0;
        case 5: 
          localddm.FNk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(118439);
          return 0;
        }
        localddm.DSu = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(118439);
        return 0;
      }
      AppMethodBeat.o(118439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddm
 * JD-Core Version:    0.7.0.1
 */