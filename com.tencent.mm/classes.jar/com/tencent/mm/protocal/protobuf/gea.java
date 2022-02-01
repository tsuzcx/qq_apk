package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gea
  extends com.tencent.mm.bx.a
{
  public String acbG;
  public String acbH;
  public gem acbI;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259992);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acbG != null) {
        paramVarArgs.g(1, this.acbG);
      }
      if (this.acbH != null) {
        paramVarArgs.g(2, this.acbH);
      }
      if (this.acbI != null)
      {
        paramVarArgs.qD(3, this.acbI.computeSize());
        this.acbI.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.type);
      AppMethodBeat.o(259992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acbG == null) {
        break label448;
      }
    }
    label448:
    for (int i = i.a.a.b.b.a.h(1, this.acbG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.acbH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.acbH);
      }
      i = paramInt;
      if (this.acbI != null) {
        i = paramInt + i.a.a.a.qC(3, this.acbI.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.type);
      AppMethodBeat.o(259992);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259992);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gea localgea = (gea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259992);
          return -1;
        case 1: 
          localgea.acbG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259992);
          return 0;
        case 2: 
          localgea.acbH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259992);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gem localgem = new gem();
            if ((localObject != null) && (localObject.length > 0)) {
              localgem.parseFrom((byte[])localObject);
            }
            localgea.acbI = localgem;
            paramInt += 1;
          }
          AppMethodBeat.o(259992);
          return 0;
        }
        localgea.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259992);
        return 0;
      }
      AppMethodBeat.o(259992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gea
 * JD-Core Version:    0.7.0.1
 */