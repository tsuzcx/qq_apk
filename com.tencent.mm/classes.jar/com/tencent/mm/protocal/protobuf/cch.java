package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cch
  extends com.tencent.mm.bw.a
{
  public LinkedList<ccg> FqI;
  public int FqJ;
  public int FqK;
  public cqg FqL;
  public int FqM;
  public LinkedList<ccf> FqN;
  public boolean FqO;
  public LinkedList<cqg> FqP;
  public int state;
  public String vyz;
  
  public cch()
  {
    AppMethodBeat.i(117544);
    this.FqI = new LinkedList();
    this.FqN = new LinkedList();
    this.FqP = new LinkedList();
    AppMethodBeat.o(117544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117545);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vyz == null)
      {
        paramVarArgs = new b("Not all required fields were included: pid");
        AppMethodBeat.o(117545);
        throw paramVarArgs;
      }
      if (this.vyz != null) {
        paramVarArgs.d(1, this.vyz);
      }
      paramVarArgs.aR(2, this.state);
      paramVarArgs.e(3, 8, this.FqI);
      paramVarArgs.aR(4, this.FqJ);
      paramVarArgs.aR(5, this.FqK);
      if (this.FqL != null)
      {
        paramVarArgs.ln(6, this.FqL.computeSize());
        this.FqL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(7, this.FqM);
      paramVarArgs.e(8, 8, this.FqN);
      paramVarArgs.bl(9, this.FqO);
      paramVarArgs.e(10, 8, this.FqP);
      AppMethodBeat.o(117545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vyz == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.b.b.a.e(1, this.vyz) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.state) + f.a.a.a.c(3, 8, this.FqI) + f.a.a.b.b.a.bx(4, this.FqJ) + f.a.a.b.b.a.bx(5, this.FqK);
      paramInt = i;
      if (this.FqL != null) {
        paramInt = i + f.a.a.a.lm(6, this.FqL.computeSize());
      }
      i = f.a.a.b.b.a.bx(7, this.FqM);
      int j = f.a.a.a.c(8, 8, this.FqN);
      int k = f.a.a.b.b.a.fK(9);
      int m = f.a.a.a.c(10, 8, this.FqP);
      AppMethodBeat.o(117545);
      return paramInt + i + j + (k + 1) + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FqI.clear();
        this.FqN.clear();
        this.FqP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.vyz == null)
        {
          paramVarArgs = new b("Not all required fields were included: pid");
          AppMethodBeat.o(117545);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cch localcch = (cch)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117545);
          return -1;
        case 1: 
          localcch.vyz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(117545);
          return 0;
        case 2: 
          localcch.state = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117545);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcch.FqI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 4: 
          localcch.FqJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117545);
          return 0;
        case 5: 
          localcch.FqK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117545);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcch.FqL = ((cqg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 7: 
          localcch.FqM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(117545);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcch.FqN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 9: 
          localcch.FqO = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(117545);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcch.FqP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      AppMethodBeat.o(117545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cch
 * JD-Core Version:    0.7.0.1
 */