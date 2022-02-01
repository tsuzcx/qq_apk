package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctq
  extends cpx
{
  public String Eel;
  public long FCA;
  public long FCv;
  public int FFk;
  public long FFl;
  public boolean FFm;
  public ebj FFn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117921);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Eel != null) {
        paramVarArgs.d(2, this.Eel);
      }
      paramVarArgs.aO(3, this.FCv);
      paramVarArgs.aR(4, this.FFk);
      paramVarArgs.aO(5, this.FFl);
      paramVarArgs.bl(6, this.FFm);
      if (this.FFn != null)
      {
        paramVarArgs.ln(7, this.FFn.computeSize());
        this.FFn.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.FCA);
      AppMethodBeat.o(117921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eel != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eel);
      }
      i = i + f.a.a.b.b.a.p(3, this.FCv) + f.a.a.b.b.a.bx(4, this.FFk) + f.a.a.b.b.a.p(5, this.FFl) + (f.a.a.b.b.a.fK(6) + 1);
      paramInt = i;
      if (this.FFn != null) {
        paramInt = i + f.a.a.a.lm(7, this.FFn.computeSize());
      }
      i = f.a.a.b.b.a.p(8, this.FCA);
      AppMethodBeat.o(117921);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(117921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctq localctq = (ctq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117921);
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
            localctq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        case 2: 
          localctq.Eel = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117921);
          return 0;
        case 3: 
          localctq.FCv = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(117921);
          return 0;
        case 4: 
          localctq.FFk = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117921);
          return 0;
        case 5: 
          localctq.FFl = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(117921);
          return 0;
        case 6: 
          localctq.FFm = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(117921);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctq.FFn = ((ebj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117921);
          return 0;
        }
        localctq.FCA = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(117921);
        return 0;
      }
      AppMethodBeat.o(117921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctq
 * JD-Core Version:    0.7.0.1
 */