package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends cpx
{
  public String DMk;
  public String DMl;
  public int DMm;
  public LinkedList<rl> DMp;
  public int dvQ;
  
  public am()
  {
    AppMethodBeat.i(113924);
    this.DMp = new LinkedList();
    AppMethodBeat.o(113924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.DMp);
      paramVarArgs.aR(3, this.dvQ);
      if (this.DMk != null) {
        paramVarArgs.d(4, this.DMk);
      }
      if (this.DMl != null) {
        paramVarArgs.d(5, this.DMl);
      }
      paramVarArgs.aR(6, this.DMm);
      AppMethodBeat.o(113925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.DMp) + f.a.a.b.b.a.bx(3, this.dvQ);
      paramInt = i;
      if (this.DMk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DMk);
      }
      i = paramInt;
      if (this.DMl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DMl);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.DMm);
      AppMethodBeat.o(113925);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DMp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113925);
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
            localam.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localam.DMp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 3: 
          localam.dvQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113925);
          return 0;
        case 4: 
          localam.DMk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113925);
          return 0;
        case 5: 
          localam.DMl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113925);
          return 0;
        }
        localam.DMm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(113925);
        return 0;
      }
      AppMethodBeat.o(113925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.am
 * JD-Core Version:    0.7.0.1
 */