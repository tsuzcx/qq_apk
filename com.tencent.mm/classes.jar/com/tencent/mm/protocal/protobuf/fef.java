package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fef
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public String Username;
  public gol abDk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125786);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abDk == null)
      {
        paramVarArgs = new b("Not all required fields were included: HBBuffer");
        AppMethodBeat.o(125786);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.g(1, this.Username);
      }
      paramVarArgs.bS(2, this.CreateTime);
      if (this.abDk != null)
      {
        paramVarArgs.qD(3, this.abDk.computeSize());
        this.abDk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125786);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = i.a.a.b.b.a.h(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.CreateTime);
      paramInt = i;
      if (this.abDk != null) {
        paramInt = i + i.a.a.a.qC(3, this.abDk.computeSize());
      }
      AppMethodBeat.o(125786);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abDk == null)
        {
          paramVarArgs = new b("Not all required fields were included: HBBuffer");
          AppMethodBeat.o(125786);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125786);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fef localfef = (fef)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125786);
          return -1;
        case 1: 
          localfef.Username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125786);
          return 0;
        case 2: 
          localfef.CreateTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125786);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          gol localgol = new gol();
          if ((localObject != null) && (localObject.length > 0)) {
            localgol.dg((byte[])localObject);
          }
          localfef.abDk = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(125786);
        return 0;
      }
      AppMethodBeat.o(125786);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fef
 * JD-Core Version:    0.7.0.1
 */