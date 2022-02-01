package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dap
  extends com.tencent.mm.bx.a
{
  public String Esl;
  public dar Esm;
  public String Esn;
  public LinkedList<daq> Eso;
  public String Esp;
  public long Esq;
  public dat Esr;
  
  public dap()
  {
    AppMethodBeat.i(124556);
    this.Eso = new LinkedList();
    AppMethodBeat.o(124556);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124557);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Esl != null) {
        paramVarArgs.d(1, this.Esl);
      }
      if (this.Esm != null)
      {
        paramVarArgs.kX(2, this.Esm.computeSize());
        this.Esm.writeFields(paramVarArgs);
      }
      if (this.Esn != null) {
        paramVarArgs.d(3, this.Esn);
      }
      paramVarArgs.e(4, 8, this.Eso);
      if (this.Esp != null) {
        paramVarArgs.d(5, this.Esp);
      }
      paramVarArgs.aG(6, this.Esq);
      if (this.Esr != null)
      {
        paramVarArgs.kX(7, this.Esr.computeSize());
        this.Esr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Esl == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.b.b.a.e(1, this.Esl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Esm != null) {
        paramInt = i + f.a.a.a.kW(2, this.Esm.computeSize());
      }
      i = paramInt;
      if (this.Esn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Esn);
      }
      i += f.a.a.a.c(4, 8, this.Eso);
      paramInt = i;
      if (this.Esp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Esp);
      }
      i = paramInt + f.a.a.b.b.a.q(6, this.Esq);
      paramInt = i;
      if (this.Esr != null) {
        paramInt = i + f.a.a.a.kW(7, this.Esr.computeSize());
      }
      AppMethodBeat.o(124557);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eso.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dap localdap = (dap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124557);
          return -1;
        case 1: 
          localdap.Esl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dar();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dar)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdap.Esm = ((dar)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 3: 
          localdap.Esn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new daq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((daq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdap.Eso.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124557);
          return 0;
        case 5: 
          localdap.Esp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124557);
          return 0;
        case 6: 
          localdap.Esq = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124557);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dat();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dat)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdap.Esr = ((dat)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124557);
        return 0;
      }
      AppMethodBeat.o(124557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dap
 * JD-Core Version:    0.7.0.1
 */