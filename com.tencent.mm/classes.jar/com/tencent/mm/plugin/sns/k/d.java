package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fdq;
import i.a.a.b;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String QCC;
  public int QCD;
  public String QCE;
  public fdq Qsc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96156);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.QCC == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.Qsc == null)
      {
        paramVarArgs = new b("Not all required fields were included: actionGroup");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.QCC != null) {
        paramVarArgs.g(1, this.QCC);
      }
      if (this.Qsc != null)
      {
        paramVarArgs.qD(2, this.Qsc.computeSize());
        this.Qsc.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.QCD);
      if (this.QCE != null) {
        paramVarArgs.g(4, this.QCE);
      }
      AppMethodBeat.o(96156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.QCC == null) {
        break label544;
      }
    }
    label544:
    for (paramInt = i.a.a.b.b.a.h(1, this.QCC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Qsc != null) {
        i = paramInt + i.a.a.a.qC(2, this.Qsc.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.QCD);
      paramInt = i;
      if (this.QCE != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.QCE);
      }
      AppMethodBeat.o(96156);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.QCC == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(96156);
          throw paramVarArgs;
        }
        if (this.Qsc == null)
        {
          paramVarArgs = new b("Not all required fields were included: actionGroup");
          AppMethodBeat.o(96156);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96156);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96156);
          return -1;
        case 1: 
          locald.QCC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(96156);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fdq localfdq = new fdq();
            if ((localObject != null) && (localObject.length > 0)) {
              localfdq.parseFrom((byte[])localObject);
            }
            locald.Qsc = localfdq;
            paramInt += 1;
          }
          AppMethodBeat.o(96156);
          return 0;
        case 3: 
          locald.QCD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(96156);
          return 0;
        }
        locald.QCE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(96156);
        return 0;
      }
      AppMethodBeat.o(96156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.d
 * JD-Core Version:    0.7.0.1
 */