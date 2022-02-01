package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class don
  extends com.tencent.mm.bx.a
{
  public double FIb;
  public double FIc;
  public String Hag;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.FIc);
      paramVarArgs.e(2, this.FIb);
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.Hag != null) {
        paramVarArgs.d(4, this.Hag);
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alT(1) + 0 + f.a.a.b.b.a.alT(2);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Name);
      }
      i = paramInt;
      if (this.Hag != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hag);
      }
      AppMethodBeat.o(56262);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      don localdon = (don)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56262);
        return -1;
      case 1: 
        localdon.FIc = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(56262);
        return 0;
      case 2: 
        localdon.FIb = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(56262);
        return 0;
      case 3: 
        localdon.Name = locala.NPN.readString();
        AppMethodBeat.o(56262);
        return 0;
      }
      localdon.Hag = locala.NPN.readString();
      AppMethodBeat.o(56262);
      return 0;
    }
    AppMethodBeat.o(56262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.don
 * JD-Core Version:    0.7.0.1
 */