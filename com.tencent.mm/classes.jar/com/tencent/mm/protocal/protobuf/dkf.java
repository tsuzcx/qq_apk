package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkf
  extends cpx
{
  public blv FTj;
  public LinkedList<dt> FTk;
  public String link;
  public int scene;
  
  public dkf()
  {
    AppMethodBeat.i(152712);
    this.FTk = new LinkedList();
    AppMethodBeat.o(152712);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152713);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.link != null) {
        paramVarArgs.d(2, this.link);
      }
      paramVarArgs.aR(3, this.scene);
      if (this.FTj != null)
      {
        paramVarArgs.ln(4, this.FTj.computeSize());
        this.FTj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.FTk);
      AppMethodBeat.o(152713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label710;
      }
    }
    label710:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.link != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.link);
      }
      i += f.a.a.b.b.a.bx(3, this.scene);
      paramInt = i;
      if (this.FTj != null) {
        paramInt = i + f.a.a.a.lm(4, this.FTj.computeSize());
      }
      i = f.a.a.a.c(5, 8, this.FTk);
      AppMethodBeat.o(152713);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FTk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152713);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dkf localdkf = (dkf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152713);
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
            localdkf.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        case 2: 
          localdkf.link = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152713);
          return 0;
        case 3: 
          localdkf.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152713);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdkf.FTj = ((blv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkf.FTk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152713);
        return 0;
      }
      AppMethodBeat.o(152713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkf
 * JD-Core Version:    0.7.0.1
 */