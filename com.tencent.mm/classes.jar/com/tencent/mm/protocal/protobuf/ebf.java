package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ebf
  extends com.tencent.mm.bx.a
{
  public long abgM;
  public ebe abgN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258234);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.abgM);
      if (this.abgN != null)
      {
        paramVarArgs.qD(2, this.abgN.computeSize());
        this.abgN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258234);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.abgM) + 0;
      paramInt = i;
      if (this.abgN != null) {
        paramInt = i + i.a.a.a.qC(2, this.abgN.computeSize());
      }
      AppMethodBeat.o(258234);
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
      AppMethodBeat.o(258234);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ebf localebf = (ebf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258234);
        return -1;
      case 1: 
        localebf.abgM = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258234);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ebe localebe = new ebe();
        if ((localObject != null) && (localObject.length > 0)) {
          localebe.parseFrom((byte[])localObject);
        }
        localebf.abgN = localebe;
        paramInt += 1;
      }
      AppMethodBeat.o(258234);
      return 0;
    }
    AppMethodBeat.o(258234);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebf
 * JD-Core Version:    0.7.0.1
 */