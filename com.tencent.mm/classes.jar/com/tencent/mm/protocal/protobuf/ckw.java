package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckw
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public String Njp;
  public cyx YNl;
  public int aasS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82415);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idd);
      if (this.YNl != null)
      {
        paramVarArgs.qD(2, this.YNl.computeSize());
        this.YNl.writeFields(paramVarArgs);
      }
      if (this.Njp != null) {
        paramVarArgs.g(3, this.Njp);
      }
      paramVarArgs.bS(4, this.aasS);
      AppMethodBeat.o(82415);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Idd) + 0;
      paramInt = i;
      if (this.YNl != null) {
        paramInt = i + i.a.a.a.qC(2, this.YNl.computeSize());
      }
      i = paramInt;
      if (this.Njp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Njp);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.aasS);
      AppMethodBeat.o(82415);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(82415);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ckw localckw = (ckw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(82415);
        return -1;
      case 1: 
        localckw.Idd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(82415);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cyx localcyx = new cyx();
          if ((localObject != null) && (localObject.length > 0)) {
            localcyx.parseFrom((byte[])localObject);
          }
          localckw.YNl = localcyx;
          paramInt += 1;
        }
        AppMethodBeat.o(82415);
        return 0;
      case 3: 
        localckw.Njp = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(82415);
        return 0;
      }
      localckw.aasS = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(82415);
      return 0;
    }
    AppMethodBeat.o(82415);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckw
 * JD-Core Version:    0.7.0.1
 */