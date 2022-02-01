package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class geh
  extends com.tencent.mm.bx.a
{
  public String acbS;
  public uz acbT;
  public boolean acbU;
  public String acbV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91731);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acbS != null) {
        paramVarArgs.g(1, this.acbS);
      }
      if (this.acbT != null)
      {
        paramVarArgs.qD(2, this.acbT.computeSize());
        this.acbT.writeFields(paramVarArgs);
      }
      paramVarArgs.di(3, this.acbU);
      if (this.acbV != null) {
        paramVarArgs.g(4, this.acbV);
      }
      AppMethodBeat.o(91731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acbS == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.b.b.a.h(1, this.acbS) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acbT != null) {
        i = paramInt + i.a.a.a.qC(2, this.acbT.computeSize());
      }
      i += i.a.a.b.b.a.ko(3) + 1;
      paramInt = i;
      if (this.acbV != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.acbV);
      }
      AppMethodBeat.o(91731);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        geh localgeh = (geh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91731);
          return -1;
        case 1: 
          localgeh.acbS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91731);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            uz localuz = new uz();
            if ((localObject != null) && (localObject.length > 0)) {
              localuz.parseFrom((byte[])localObject);
            }
            localgeh.acbT = localuz;
            paramInt += 1;
          }
          AppMethodBeat.o(91731);
          return 0;
        case 3: 
          localgeh.acbU = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(91731);
          return 0;
        }
        localgeh.acbV = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91731);
        return 0;
      }
      AppMethodBeat.o(91731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.geh
 * JD-Core Version:    0.7.0.1
 */