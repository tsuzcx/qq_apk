package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ua
  extends com.tencent.mm.bw.a
{
  public LinkedList<ub> Eob;
  public int Eoc;
  public crm Eod;
  public int fsB;
  
  public ua()
  {
    AppMethodBeat.i(43085);
    this.Eob = new LinkedList();
    AppMethodBeat.o(43085);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43086);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fsB);
      paramVarArgs.e(2, 8, this.Eob);
      paramVarArgs.aR(3, this.Eoc);
      if (this.Eod != null)
      {
        paramVarArgs.ln(4, this.Eod.computeSize());
        this.Eod.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.fsB) + 0 + f.a.a.a.c(2, 8, this.Eob) + f.a.a.b.b.a.bx(3, this.Eoc);
      paramInt = i;
      if (this.Eod != null) {
        paramInt = i + f.a.a.a.lm(4, this.Eod.computeSize());
      }
      AppMethodBeat.o(43086);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Eob.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ua localua = (ua)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(43086);
        return -1;
      case 1: 
        localua.fsB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43086);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ub();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ub)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localua.Eob.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43086);
        return 0;
      case 3: 
        localua.Eoc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(43086);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new crm();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localua.Eod = ((crm)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(43086);
      return 0;
    }
    AppMethodBeat.o(43086);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ua
 * JD-Core Version:    0.7.0.1
 */