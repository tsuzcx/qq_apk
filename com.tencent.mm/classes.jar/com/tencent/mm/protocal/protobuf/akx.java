package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class akx
  extends cpx
{
  public aiu EDL;
  public int EEM;
  public int qYe;
  public b rpX;
  public int scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168988);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EEM);
      if (this.rpX != null) {
        paramVarArgs.c(3, this.rpX);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      paramVarArgs.aR(5, this.scene);
      if (this.EDL != null)
      {
        paramVarArgs.ln(6, this.EDL.computeSize());
        this.EDL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.qYe);
      AppMethodBeat.o(168988);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.EEM);
      paramInt = i;
      if (this.rpX != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.rpX);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.username);
      }
      i += f.a.a.b.b.a.bx(5, this.scene);
      paramInt = i;
      if (this.EDL != null) {
        paramInt = i + f.a.a.a.lm(6, this.EDL.computeSize());
      }
      i = f.a.a.b.b.a.bx(7, this.qYe);
      AppMethodBeat.o(168988);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168988);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akx localakx = (akx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168988);
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
            localakx.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168988);
          return 0;
        case 2: 
          localakx.EEM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168988);
          return 0;
        case 3: 
          localakx.rpX = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(168988);
          return 0;
        case 4: 
          localakx.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168988);
          return 0;
        case 5: 
          localakx.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168988);
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
            localakx.EDL = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168988);
          return 0;
        }
        localakx.qYe = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168988);
        return 0;
      }
      AppMethodBeat.o(168988);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akx
 * JD-Core Version:    0.7.0.1
 */