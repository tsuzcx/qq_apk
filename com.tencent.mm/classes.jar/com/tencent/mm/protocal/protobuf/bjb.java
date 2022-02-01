package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjb
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> LSP;
  public bf Lcc;
  public String LhT;
  
  public bjb()
  {
    AppMethodBeat.i(91482);
    this.LSP = new LinkedList();
    AppMethodBeat.o(91482);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91483);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.LSP);
      if (this.Lcc != null)
      {
        paramVarArgs.ni(2, this.Lcc.computeSize());
        this.Lcc.writeFields(paramVarArgs);
      }
      if (this.LhT != null) {
        paramVarArgs.e(3, this.LhT);
      }
      AppMethodBeat.o(91483);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 1, this.LSP) + 0;
      paramInt = i;
      if (this.Lcc != null) {
        paramInt = i + g.a.a.a.nh(2, this.Lcc.computeSize());
      }
      i = paramInt;
      if (this.LhT != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LhT);
      }
      AppMethodBeat.o(91483);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LSP.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91483);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bjb localbjb = (bjb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91483);
        return -1;
      case 1: 
        localbjb.LSP.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(91483);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbjb.Lcc = ((bf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91483);
        return 0;
      }
      localbjb.LhT = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91483);
      return 0;
    }
    AppMethodBeat.o(91483);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjb
 * JD-Core Version:    0.7.0.1
 */