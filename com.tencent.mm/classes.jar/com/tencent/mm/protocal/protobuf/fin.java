package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class fin
  extends com.tencent.mm.bx.a
{
  public String abJp;
  public String abJq;
  public String abJr;
  public String abJs;
  public String abJt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101531);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abJp == null)
      {
        paramVarArgs = new b("Not all required fields were included: videoFileMD5");
        AppMethodBeat.o(101531);
        throw paramVarArgs;
      }
      if (this.abJp != null) {
        paramVarArgs.g(1, this.abJp);
      }
      if (this.abJq != null) {
        paramVarArgs.g(2, this.abJq);
      }
      if (this.abJr != null) {
        paramVarArgs.g(3, this.abJr);
      }
      if (this.abJs != null) {
        paramVarArgs.g(4, this.abJs);
      }
      if (this.abJt != null) {
        paramVarArgs.g(5, this.abJt);
      }
      AppMethodBeat.o(101531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abJp == null) {
        break label498;
      }
    }
    label498:
    for (int i = i.a.a.b.b.a.h(1, this.abJp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abJq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abJq);
      }
      i = paramInt;
      if (this.abJr != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abJr);
      }
      paramInt = i;
      if (this.abJs != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abJs);
      }
      i = paramInt;
      if (this.abJt != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abJt);
      }
      AppMethodBeat.o(101531);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abJp == null)
        {
          paramVarArgs = new b("Not all required fields were included: videoFileMD5");
          AppMethodBeat.o(101531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101531);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fin localfin = (fin)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101531);
          return -1;
        case 1: 
          localfin.abJp = locala.ajGk.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 2: 
          localfin.abJq = locala.ajGk.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 3: 
          localfin.abJr = locala.ajGk.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 4: 
          localfin.abJs = locala.ajGk.readString();
          AppMethodBeat.o(101531);
          return 0;
        }
        localfin.abJt = locala.ajGk.readString();
        AppMethodBeat.o(101531);
        return 0;
      }
      AppMethodBeat.o(101531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fin
 * JD-Core Version:    0.7.0.1
 */