package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oh
  extends com.tencent.mm.bw.a
{
  public LinkedList<ewv> KUa;
  public LinkedList<String> KUc;
  public String KUd;
  public String KUe;
  
  public oh()
  {
    AppMethodBeat.i(212234);
    this.KUa = new LinkedList();
    this.KUc = new LinkedList();
    AppMethodBeat.o(212234);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212235);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(15, 8, this.KUa);
      paramVarArgs.e(17, 1, this.KUc);
      if (this.KUd != null) {
        paramVarArgs.e(18, this.KUd);
      }
      if (this.KUe != null) {
        paramVarArgs.e(19, this.KUe);
      }
      AppMethodBeat.o(212235);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(15, 8, this.KUa) + 0 + g.a.a.a.c(17, 1, this.KUc);
      paramInt = i;
      if (this.KUd != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.KUd);
      }
      i = paramInt;
      if (this.KUe != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.KUe);
      }
      AppMethodBeat.o(212235);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KUa.clear();
      this.KUc.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(212235);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      oh localoh = (oh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 16: 
      default: 
        AppMethodBeat.o(212235);
        return -1;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ewv();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ewv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localoh.KUa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212235);
        return 0;
      case 17: 
        localoh.KUc.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(212235);
        return 0;
      case 18: 
        localoh.KUd = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212235);
        return 0;
      }
      localoh.KUe = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(212235);
      return 0;
    }
    AppMethodBeat.o(212235);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oh
 * JD-Core Version:    0.7.0.1
 */