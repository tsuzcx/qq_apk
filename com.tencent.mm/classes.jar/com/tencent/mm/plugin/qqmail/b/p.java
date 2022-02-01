package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class p
  extends com.tencent.mm.bx.a
{
  public String name;
  public String sOr;
  public int uLx;
  public int uLy;
  public String uLz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122694);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      if (this.sOr == null)
      {
        paramVarArgs = new b("Not all required fields were included: addr");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.uLx);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.sOr != null) {
        paramVarArgs.d(3, this.sOr);
      }
      paramVarArgs.aR(4, this.uLy);
      if (this.uLz != null) {
        paramVarArgs.d(5, this.uLz);
      }
      AppMethodBeat.o(122694);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.uLx) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.sOr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sOr);
      }
      i += f.a.a.b.b.a.bA(4, this.uLy);
      paramInt = i;
      if (this.uLz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uLz);
      }
      AppMethodBeat.o(122694);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      if (this.sOr == null)
      {
        paramVarArgs = new b("Not all required fields were included: addr");
        AppMethodBeat.o(122694);
        throw paramVarArgs;
      }
      AppMethodBeat.o(122694);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122694);
        return -1;
      case 1: 
        localp.uLx = locala.KhF.xS();
        AppMethodBeat.o(122694);
        return 0;
      case 2: 
        localp.name = locala.KhF.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 3: 
        localp.sOr = locala.KhF.readString();
        AppMethodBeat.o(122694);
        return 0;
      case 4: 
        localp.uLy = locala.KhF.xS();
        AppMethodBeat.o(122694);
        return 0;
      }
      localp.uLz = locala.KhF.readString();
      AppMethodBeat.o(122694);
      return 0;
    }
    AppMethodBeat.o(122694);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.p
 * JD-Core Version:    0.7.0.1
 */