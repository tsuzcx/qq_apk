package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dco
  extends com.tencent.mm.bw.a
{
  public dcn FMi;
  public dcn FMj;
  public dcn FMk;
  public int FMl;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123655);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FMi != null)
      {
        paramVarArgs.ln(1, this.FMi.computeSize());
        this.FMi.writeFields(paramVarArgs);
      }
      if (this.FMj != null)
      {
        paramVarArgs.ln(2, this.FMj.computeSize());
        this.FMj.writeFields(paramVarArgs);
      }
      if (this.FMk != null)
      {
        paramVarArgs.ln(3, this.FMk.computeSize());
        this.FMk.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.scene);
      paramVarArgs.aR(5, this.FMl);
      AppMethodBeat.o(123655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FMi == null) {
        break label710;
      }
    }
    label710:
    for (int i = f.a.a.a.lm(1, this.FMi.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FMj != null) {
        paramInt = i + f.a.a.a.lm(2, this.FMj.computeSize());
      }
      i = paramInt;
      if (this.FMk != null) {
        i = paramInt + f.a.a.a.lm(3, this.FMk.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(4, this.scene);
      int j = f.a.a.b.b.a.bx(5, this.FMl);
      AppMethodBeat.o(123655);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123655);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dco localdco = (dco)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123655);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdco.FMi = ((dcn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdco.FMj = ((dcn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdco.FMk = ((dcn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 4: 
          localdco.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123655);
          return 0;
        }
        localdco.FMl = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123655);
        return 0;
      }
      AppMethodBeat.o(123655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dco
 * JD-Core Version:    0.7.0.1
 */