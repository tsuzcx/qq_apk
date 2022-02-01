package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gcw
  extends com.tencent.mm.bx.a
{
  public String YBL;
  public gbv acaF;
  public String acaQ;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147812);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acaF == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147812);
        throw paramVarArgs;
      }
      if (this.acaF != null)
      {
        paramVarArgs.qD(1, this.acaF.computeSize());
        this.acaF.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.YBL != null) {
        paramVarArgs.g(3, this.YBL);
      }
      if (this.acaQ != null) {
        paramVarArgs.g(4, this.acaQ);
      }
      AppMethodBeat.o(147812);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acaF == null) {
        break label512;
      }
    }
    label512:
    for (int i = i.a.a.a.qC(1, this.acaF.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.YBL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YBL);
      }
      paramInt = i;
      if (this.acaQ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.acaQ);
      }
      AppMethodBeat.o(147812);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.acaF == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147812);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147812);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gcw localgcw = (gcw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147812);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gbv localgbv = new gbv();
            if ((localObject != null) && (localObject.length > 0)) {
              localgbv.parseFrom((byte[])localObject);
            }
            localgcw.acaF = localgbv;
            paramInt += 1;
          }
          AppMethodBeat.o(147812);
          return 0;
        case 2: 
          localgcw.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(147812);
          return 0;
        case 3: 
          localgcw.YBL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(147812);
          return 0;
        }
        localgcw.acaQ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(147812);
        return 0;
      }
      AppMethodBeat.o(147812);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gcw
 * JD-Core Version:    0.7.0.1
 */