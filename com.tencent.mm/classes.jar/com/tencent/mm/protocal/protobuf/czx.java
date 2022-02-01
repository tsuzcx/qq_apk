package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czx
  extends com.tencent.mm.bx.a
{
  public int OfA;
  public String Ofy;
  public String Ofz;
  public String id;
  public long timestamp;
  public String wsM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72499);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      if (this.Ofy != null) {
        paramVarArgs.g(2, this.Ofy);
      }
      if (this.Ofz != null) {
        paramVarArgs.g(3, this.Ofz);
      }
      if (this.wsM != null) {
        paramVarArgs.g(4, this.wsM);
      }
      paramVarArgs.bv(6, this.timestamp);
      paramVarArgs.bS(5, this.OfA);
      AppMethodBeat.o(72499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label482;
      }
    }
    label482:
    for (int i = i.a.a.b.b.a.h(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ofy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Ofy);
      }
      i = paramInt;
      if (this.Ofz != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Ofz);
      }
      paramInt = i;
      if (this.wsM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.wsM);
      }
      i = i.a.a.b.b.a.q(6, this.timestamp);
      int j = i.a.a.b.b.a.cJ(5, this.OfA);
      AppMethodBeat.o(72499);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72499);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        czx localczx = (czx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72499);
          return -1;
        case 1: 
          localczx.id = locala.ajGk.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 2: 
          localczx.Ofy = locala.ajGk.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 3: 
          localczx.Ofz = locala.ajGk.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 4: 
          localczx.wsM = locala.ajGk.readString();
          AppMethodBeat.o(72499);
          return 0;
        case 6: 
          localczx.timestamp = locala.ajGk.aaw();
          AppMethodBeat.o(72499);
          return 0;
        }
        localczx.OfA = locala.ajGk.aar();
        AppMethodBeat.o(72499);
        return 0;
      }
      AppMethodBeat.o(72499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czx
 * JD-Core Version:    0.7.0.1
 */