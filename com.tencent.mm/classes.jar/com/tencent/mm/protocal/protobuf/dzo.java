package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dzo
  extends com.tencent.mm.bx.a
{
  public String OjA;
  public LinkedList<String> aaTg;
  public String key;
  public String value;
  
  public dzo()
  {
    AppMethodBeat.i(117535);
    this.aaTg = new LinkedList();
    AppMethodBeat.o(117535);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117536);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(117536);
        throw paramVarArgs;
      }
      if (this.value == null)
      {
        paramVarArgs = new b("Not all required fields were included: value");
        AppMethodBeat.o(117536);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.g(1, this.key);
      }
      if (this.value != null) {
        paramVarArgs.g(2, this.value);
      }
      if (this.OjA != null) {
        paramVarArgs.g(3, this.OjA);
      }
      paramVarArgs.e(4, 1, this.aaTg);
      AppMethodBeat.o(117536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label486;
      }
    }
    label486:
    for (int i = i.a.a.b.b.a.h(1, this.key) + 0;; i = 0)
    {
      paramInt = i;
      if (this.value != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.value);
      }
      i = paramInt;
      if (this.OjA != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.OjA);
      }
      paramInt = i.a.a.a.c(4, 1, this.aaTg);
      AppMethodBeat.o(117536);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaTg.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(117536);
          throw paramVarArgs;
        }
        if (this.value == null)
        {
          paramVarArgs = new b("Not all required fields were included: value");
          AppMethodBeat.o(117536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117536);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dzo localdzo = (dzo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117536);
          return -1;
        case 1: 
          localdzo.key = locala.ajGk.readString();
          AppMethodBeat.o(117536);
          return 0;
        case 2: 
          localdzo.value = locala.ajGk.readString();
          AppMethodBeat.o(117536);
          return 0;
        case 3: 
          localdzo.OjA = locala.ajGk.readString();
          AppMethodBeat.o(117536);
          return 0;
        }
        localdzo.aaTg.add(locala.ajGk.readString());
        AppMethodBeat.o(117536);
        return 0;
      }
      AppMethodBeat.o(117536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzo
 * JD-Core Version:    0.7.0.1
 */