package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fvt
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public gol abTU;
  public gol abTV;
  public int hjP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32492);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abTU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      if (this.abTV == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.hjP);
      if (this.IGG != null) {
        paramVarArgs.g(2, this.IGG);
      }
      if (this.abTU != null)
      {
        paramVarArgs.qD(3, this.abTU.computeSize());
        this.abTU.writeFields(paramVarArgs);
      }
      if (this.abTV != null)
      {
        paramVarArgs.qD(4, this.abTV.computeSize());
        this.abTV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.hjP) + 0;
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGG);
      }
      i = paramInt;
      if (this.abTU != null) {
        i = paramInt + i.a.a.a.qC(3, this.abTU.computeSize());
      }
      paramInt = i;
      if (this.abTV != null) {
        paramInt = i + i.a.a.a.qC(4, this.abTV.computeSize());
      }
      AppMethodBeat.o(32492);
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
      if (this.abTU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Icon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      if (this.abTV == null)
      {
        paramVarArgs = new b("Not all required fields were included: HDIcon");
        AppMethodBeat.o(32492);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fvt localfvt = (fvt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      gol localgol;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32492);
        return -1;
      case 1: 
        localfvt.hjP = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32492);
        return 0;
      case 2: 
        localfvt.IGG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32492);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localfvt.abTU = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(32492);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        localgol = new gol();
        if ((localObject != null) && (localObject.length > 0)) {
          localgol.dg((byte[])localObject);
        }
        localfvt.abTV = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(32492);
      return 0;
    }
    AppMethodBeat.o(32492);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvt
 * JD-Core Version:    0.7.0.1
 */