package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gdq
  extends com.tencent.mm.bx.a
{
  public gol YFI;
  public String YOM;
  public gol YOQ;
  public String acbw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133207);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YOQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.YFI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(133207);
        throw paramVarArgs;
      }
      if (this.acbw != null) {
        paramVarArgs.g(1, this.acbw);
      }
      if (this.YOQ != null)
      {
        paramVarArgs.qD(2, this.YOQ.computeSize());
        this.YOQ.writeFields(paramVarArgs);
      }
      if (this.YOM != null) {
        paramVarArgs.g(3, this.YOM);
      }
      if (this.YFI != null)
      {
        paramVarArgs.qD(4, this.YFI.computeSize());
        this.YFI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acbw == null) {
        break label634;
      }
    }
    label634:
    for (int i = i.a.a.b.b.a.h(1, this.acbw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YOQ != null) {
        paramInt = i + i.a.a.a.qC(2, this.YOQ.computeSize());
      }
      i = paramInt;
      if (this.YOM != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YOM);
      }
      paramInt = i;
      if (this.YFI != null) {
        paramInt = i + i.a.a.a.qC(4, this.YFI.computeSize());
      }
      AppMethodBeat.o(133207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YOQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: KSid");
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        if (this.YFI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(133207);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gdq localgdq = (gdq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        gol localgol;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133207);
          return -1;
        case 1: 
          localgdq.acbw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(133207);
          return 0;
        case 2: 
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
            localgdq.YOQ = localgol;
            paramInt += 1;
          }
          AppMethodBeat.o(133207);
          return 0;
        case 3: 
          localgdq.YOM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(133207);
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
          localgdq.YFI = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(133207);
        return 0;
      }
      AppMethodBeat.o(133207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdq
 * JD-Core Version:    0.7.0.1
 */