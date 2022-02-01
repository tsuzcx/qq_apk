package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gih
  extends com.tencent.mm.bx.a
{
  public int aceP;
  public gij aceQ;
  public long aceR;
  public int aceS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258530);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aceP);
      if (this.aceQ != null)
      {
        paramVarArgs.qD(2, this.aceQ.computeSize());
        this.aceQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.aceR);
      paramVarArgs.bS(4, this.aceS);
      AppMethodBeat.o(258530);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aceP) + 0;
      paramInt = i;
      if (this.aceQ != null) {
        paramInt = i + i.a.a.a.qC(2, this.aceQ.computeSize());
      }
      i = i.a.a.b.b.a.q(3, this.aceR);
      int j = i.a.a.b.b.a.cJ(4, this.aceS);
      AppMethodBeat.o(258530);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258530);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gih localgih = (gih)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258530);
        return -1;
      case 1: 
        localgih.aceP = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258530);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gij localgij = new gij();
          if ((localObject != null) && (localObject.length > 0)) {
            localgij.parseFrom((byte[])localObject);
          }
          localgih.aceQ = localgij;
          paramInt += 1;
        }
        AppMethodBeat.o(258530);
        return 0;
      case 3: 
        localgih.aceR = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(258530);
        return 0;
      }
      localgih.aceS = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(258530);
      return 0;
    }
    AppMethodBeat.o(258530);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gih
 * JD-Core Version:    0.7.0.1
 */