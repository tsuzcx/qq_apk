package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ps
  extends com.tencent.mm.bw.a
{
  public LinkedList<no> Egk;
  public LinkedList<dwf> Egl;
  public LinkedList<acy> Egm;
  public LinkedList<dzg> Egn;
  public cov Ego;
  public b Egp;
  public LinkedList<cdc> Egq;
  public int ndI;
  
  public ps()
  {
    AppMethodBeat.i(117848);
    this.Egk = new LinkedList();
    this.Egl = new LinkedList();
    this.Egm = new LinkedList();
    this.Egn = new LinkedList();
    this.Egq = new LinkedList();
    AppMethodBeat.o(117848);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117849);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndI);
      paramVarArgs.e(2, 8, this.Egk);
      paramVarArgs.e(3, 8, this.Egl);
      paramVarArgs.e(4, 8, this.Egm);
      paramVarArgs.e(5, 8, this.Egn);
      if (this.Ego != null)
      {
        paramVarArgs.ln(6, this.Ego.computeSize());
        this.Ego.writeFields(paramVarArgs);
      }
      if (this.Egp != null) {
        paramVarArgs.c(7, this.Egp);
      }
      paramVarArgs.e(8, 8, this.Egq);
      AppMethodBeat.o(117849);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.ndI) + 0 + f.a.a.a.c(2, 8, this.Egk) + f.a.a.a.c(3, 8, this.Egl) + f.a.a.a.c(4, 8, this.Egm) + f.a.a.a.c(5, 8, this.Egn);
      paramInt = i;
      if (this.Ego != null) {
        paramInt = i + f.a.a.a.lm(6, this.Ego.computeSize());
      }
      i = paramInt;
      if (this.Egp != null) {
        i = paramInt + f.a.a.b.b.a.b(7, this.Egp);
      }
      paramInt = f.a.a.a.c(8, 8, this.Egq);
      AppMethodBeat.o(117849);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Egk.clear();
      this.Egl.clear();
      this.Egm.clear();
      this.Egn.clear();
      this.Egq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ps localps = (ps)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117849);
        return -1;
      case 1: 
        localps.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117849);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new no();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((no)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localps.Egk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localps.Egl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localps.Egm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dzg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dzg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localps.Egn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cov();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localps.Ego = ((cov)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117849);
        return 0;
      case 7: 
        localps.Egp = ((f.a.a.a.a)localObject1).LVo.gfk();
        AppMethodBeat.o(117849);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cdc();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cdc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localps.Egq.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117849);
      return 0;
    }
    AppMethodBeat.o(117849);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ps
 * JD-Core Version:    0.7.0.1
 */