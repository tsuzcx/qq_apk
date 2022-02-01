package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efr
  extends com.tencent.mm.bx.a
{
  public int aatG;
  public String aatH;
  public String aatI;
  public fqo abld;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32369);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aatG);
      if (this.aatH != null) {
        paramVarArgs.g(2, this.aatH);
      }
      if (this.aatI != null) {
        paramVarArgs.g(3, this.aatI);
      }
      if (this.abld != null)
      {
        paramVarArgs.qD(4, this.abld.computeSize());
        this.abld.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aatG) + 0;
      paramInt = i;
      if (this.aatH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aatH);
      }
      i = paramInt;
      if (this.aatI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aatI);
      }
      paramInt = i;
      if (this.abld != null) {
        paramInt = i + i.a.a.a.qC(4, this.abld.computeSize());
      }
      AppMethodBeat.o(32369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      efr localefr = (efr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32369);
        return -1;
      case 1: 
        localefr.aatG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32369);
        return 0;
      case 2: 
        localefr.aatH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32369);
        return 0;
      case 3: 
        localefr.aatI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32369);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fqo localfqo = new fqo();
        if ((localObject != null) && (localObject.length > 0)) {
          localfqo.parseFrom((byte[])localObject);
        }
        localefr.abld = localfqo;
        paramInt += 1;
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    AppMethodBeat.o(32369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efr
 * JD-Core Version:    0.7.0.1
 */