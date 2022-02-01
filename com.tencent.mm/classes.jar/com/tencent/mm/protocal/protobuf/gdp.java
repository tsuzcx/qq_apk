package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gdp
  extends com.tencent.mm.bx.a
{
  public String YOM;
  public String YON;
  public gol YOQ;
  public String acbw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133206);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YOQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(133206);
        throw paramVarArgs;
      }
      if (this.YOM != null) {
        paramVarArgs.g(1, this.YOM);
      }
      if (this.YON != null) {
        paramVarArgs.g(2, this.YON);
      }
      if (this.acbw != null) {
        paramVarArgs.g(3, this.acbw);
      }
      if (this.YOQ != null)
      {
        paramVarArgs.qD(4, this.YOQ.computeSize());
        this.YOQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YOM == null) {
        break label512;
      }
    }
    label512:
    for (int i = i.a.a.b.b.a.h(1, this.YOM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YON != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YON);
      }
      i = paramInt;
      if (this.acbw != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acbw);
      }
      paramInt = i;
      if (this.YOQ != null) {
        paramInt = i + i.a.a.a.qC(4, this.YOQ.computeSize());
      }
      AppMethodBeat.o(133206);
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
          AppMethodBeat.o(133206);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133206);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gdp localgdp = (gdp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133206);
          return -1;
        case 1: 
          localgdp.YOM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 2: 
          localgdp.YON = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(133206);
          return 0;
        case 3: 
          localgdp.acbw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(133206);
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
          localgdp.YOQ = localgol;
          paramInt += 1;
        }
        AppMethodBeat.o(133206);
        return 0;
      }
      AppMethodBeat.o(133206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdp
 * JD-Core Version:    0.7.0.1
 */