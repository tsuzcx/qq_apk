package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dpk
  extends com.tencent.mm.bw.a
{
  public double Gax;
  public double Gay;
  public String HtG;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.Gay);
      paramVarArgs.e(2, this.Gax);
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.HtG != null) {
        paramVarArgs.d(4, this.HtG);
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amD(1) + 0 + f.a.a.b.b.a.amD(2);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Name);
      }
      i = paramInt;
      if (this.HtG != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HtG);
      }
      AppMethodBeat.o(56262);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dpk localdpk = (dpk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56262);
        return -1;
      case 1: 
        localdpk.Gay = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(56262);
        return 0;
      case 2: 
        localdpk.Gax = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(56262);
        return 0;
      case 3: 
        localdpk.Name = locala.OmT.readString();
        AppMethodBeat.o(56262);
        return 0;
      }
      localdpk.HtG = locala.OmT.readString();
      AppMethodBeat.o(56262);
      return 0;
    }
    AppMethodBeat.o(56262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpk
 * JD-Core Version:    0.7.0.1
 */