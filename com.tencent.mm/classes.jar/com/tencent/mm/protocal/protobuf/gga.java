package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gga
  extends com.tencent.mm.bx.a
{
  public long YKx;
  public long accP;
  public String accQ;
  public LinkedList<ggb> accR;
  
  public gga()
  {
    AppMethodBeat.i(32534);
    this.accR = new LinkedList();
    AppMethodBeat.o(32534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32535);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.accQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.accP);
      paramVarArgs.bv(2, this.YKx);
      if (this.accQ != null) {
        paramVarArgs.g(3, this.accQ);
      }
      paramVarArgs.e(4, 8, this.accR);
      AppMethodBeat.o(32535);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.accP) + 0 + i.a.a.b.b.a.q(2, this.YKx);
      paramInt = i;
      if (this.accQ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.accQ);
      }
      i = i.a.a.a.c(4, 8, this.accR);
      AppMethodBeat.o(32535);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.accR.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.accQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: TotalMsg");
        AppMethodBeat.o(32535);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32535);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gga localgga = (gga)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32535);
        return -1;
      case 1: 
        localgga.accP = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(32535);
        return 0;
      case 2: 
        localgga.YKx = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(32535);
        return 0;
      case 3: 
        localgga.accQ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32535);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ggb localggb = new ggb();
        if ((localObject != null) && (localObject.length > 0)) {
          localggb.parseFrom((byte[])localObject);
        }
        localgga.accR.add(localggb);
        paramInt += 1;
      }
      AppMethodBeat.o(32535);
      return 0;
    }
    AppMethodBeat.o(32535);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gga
 * JD-Core Version:    0.7.0.1
 */