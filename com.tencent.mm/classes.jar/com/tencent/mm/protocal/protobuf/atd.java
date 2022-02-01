package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atd
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> EMi;
  public bb EhT;
  public String EnH;
  
  public atd()
  {
    AppMethodBeat.i(91482);
    this.EMi = new LinkedList();
    AppMethodBeat.o(91482);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91483);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.EMi);
      if (this.EhT != null)
      {
        paramVarArgs.ln(2, this.EhT.computeSize());
        this.EhT.writeFields(paramVarArgs);
      }
      if (this.EnH != null) {
        paramVarArgs.d(3, this.EnH);
      }
      AppMethodBeat.o(91483);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 1, this.EMi) + 0;
      paramInt = i;
      if (this.EhT != null) {
        paramInt = i + f.a.a.a.lm(2, this.EhT.computeSize());
      }
      i = paramInt;
      if (this.EnH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EnH);
      }
      AppMethodBeat.o(91483);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EMi.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91483);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      atd localatd = (atd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91483);
        return -1;
      case 1: 
        localatd.EMi.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(91483);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localatd.EhT = ((bb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91483);
        return 0;
      }
      localatd.EnH = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(91483);
      return 0;
    }
    AppMethodBeat.o(91483);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atd
 * JD-Core Version:    0.7.0.1
 */