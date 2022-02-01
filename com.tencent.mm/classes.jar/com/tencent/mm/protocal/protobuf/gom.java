package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gom
  extends com.tencent.mm.bx.a
{
  public boolean aklp;
  public bmr aklq;
  public int aklr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(369685);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.aklp);
      if (this.aklq != null)
      {
        paramVarArgs.qD(2, this.aklq.computeSize());
        this.aklq.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aklr);
      AppMethodBeat.o(369685);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.ko(1) + 1 + 0;
      paramInt = i;
      if (this.aklq != null) {
        paramInt = i + i.a.a.a.qC(2, this.aklq.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.aklr);
      AppMethodBeat.o(369685);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(369685);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gom localgom = (gom)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(369685);
        return -1;
      case 1: 
        localgom.aklp = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(369685);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bmr localbmr = new bmr();
          if ((localObject != null) && (localObject.length > 0)) {
            localbmr.parseFrom((byte[])localObject);
          }
          localgom.aklq = localbmr;
          paramInt += 1;
        }
        AppMethodBeat.o(369685);
        return 0;
      }
      localgom.aklr = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(369685);
      return 0;
    }
    AppMethodBeat.o(369685);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gom
 * JD-Core Version:    0.7.0.1
 */