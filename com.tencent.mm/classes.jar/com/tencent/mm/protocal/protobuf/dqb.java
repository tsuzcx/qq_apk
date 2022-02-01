package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dqb
  extends com.tencent.mm.bx.a
{
  public edk aaWb;
  public String aaWl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32352);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaWl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactUsername");
        AppMethodBeat.o(32352);
        throw paramVarArgs;
      }
      if (this.aaWb == null)
      {
        paramVarArgs = new b("Not all required fields were included: PhoneNumListInfo");
        AppMethodBeat.o(32352);
        throw paramVarArgs;
      }
      if (this.aaWl != null) {
        paramVarArgs.g(1, this.aaWl);
      }
      if (this.aaWb != null)
      {
        paramVarArgs.qD(2, this.aaWb.computeSize());
        this.aaWb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32352);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaWl == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaWl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaWb != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaWb.computeSize());
      }
      AppMethodBeat.o(32352);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaWl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactUsername");
          AppMethodBeat.o(32352);
          throw paramVarArgs;
        }
        if (this.aaWb == null)
        {
          paramVarArgs = new b("Not all required fields were included: PhoneNumListInfo");
          AppMethodBeat.o(32352);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32352);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dqb localdqb = (dqb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32352);
          return -1;
        case 1: 
          localdqb.aaWl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32352);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          edk localedk = new edk();
          if ((localObject != null) && (localObject.length > 0)) {
            localedk.parseFrom((byte[])localObject);
          }
          localdqb.aaWb = localedk;
          paramInt += 1;
        }
        AppMethodBeat.o(32352);
        return 0;
      }
      AppMethodBeat.o(32352);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqb
 * JD-Core Version:    0.7.0.1
 */