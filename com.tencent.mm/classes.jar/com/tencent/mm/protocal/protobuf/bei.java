package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bei
  extends com.tencent.mm.bw.a
{
  public cng LIA;
  public String LOd;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209717);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.id);
      if (this.LIA != null)
      {
        paramVarArgs.ni(2, this.LIA.computeSize());
        this.LIA.writeFields(paramVarArgs);
      }
      if (this.LOd != null) {
        paramVarArgs.e(3, this.LOd);
      }
      AppMethodBeat.o(209717);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.id) + 0;
      paramInt = i;
      if (this.LIA != null) {
        paramInt = i + g.a.a.a.nh(2, this.LIA.computeSize());
      }
      i = paramInt;
      if (this.LOd != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LOd);
      }
      AppMethodBeat.o(209717);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209717);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bei localbei = (bei)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209717);
        return -1;
      case 1: 
        localbei.id = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(209717);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cng();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cng)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbei.LIA = ((cng)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209717);
        return 0;
      }
      localbei.LOd = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(209717);
      return 0;
    }
    AppMethodBeat.o(209717);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bei
 * JD-Core Version:    0.7.0.1
 */