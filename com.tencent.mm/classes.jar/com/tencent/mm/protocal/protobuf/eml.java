package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eml
  extends com.tencent.mm.bx.a
{
  public gjf abqM;
  public gje abqN;
  public gje abqO;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257365);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.version);
      if (this.abqM != null)
      {
        paramVarArgs.qD(2, this.abqM.computeSize());
        this.abqM.writeFields(paramVarArgs);
      }
      if (this.abqN != null)
      {
        paramVarArgs.qD(3, this.abqN.computeSize());
        this.abqN.writeFields(paramVarArgs);
      }
      if (this.abqO != null)
      {
        paramVarArgs.qD(4, this.abqO.computeSize());
        this.abqO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257365);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.version) + 0;
      paramInt = i;
      if (this.abqM != null) {
        paramInt = i + i.a.a.a.qC(2, this.abqM.computeSize());
      }
      i = paramInt;
      if (this.abqN != null) {
        i = paramInt + i.a.a.a.qC(3, this.abqN.computeSize());
      }
      paramInt = i;
      if (this.abqO != null) {
        paramInt = i + i.a.a.a.qC(4, this.abqO.computeSize());
      }
      AppMethodBeat.o(257365);
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
      AppMethodBeat.o(257365);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      eml localeml = (eml)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257365);
        return -1;
      case 1: 
        localeml.version = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257365);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gjf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gjf)localObject2).parseFrom((byte[])localObject1);
          }
          localeml.abqM = ((gjf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257365);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gje();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gje)localObject2).parseFrom((byte[])localObject1);
          }
          localeml.abqN = ((gje)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257365);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new gje();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((gje)localObject2).parseFrom((byte[])localObject1);
        }
        localeml.abqO = ((gje)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257365);
      return 0;
    }
    AppMethodBeat.o(257365);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eml
 * JD-Core Version:    0.7.0.1
 */