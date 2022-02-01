package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwl
  extends com.tencent.mm.bw.a
{
  public double Gax;
  public double Gay;
  public String Hjv;
  public String Hjw;
  public String Hjx;
  public String qkD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32338);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.Gay);
      paramVarArgs.e(2, this.Gax);
      if (this.qkD != null) {
        paramVarArgs.d(3, this.qkD);
      }
      if (this.Hjv != null) {
        paramVarArgs.d(4, this.Hjv);
      }
      if (this.Hjw != null) {
        paramVarArgs.d(5, this.Hjw);
      }
      if (this.Hjx != null) {
        paramVarArgs.d(6, this.Hjx);
      }
      AppMethodBeat.o(32338);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amD(1) + 0 + f.a.a.b.b.a.amD(2);
      paramInt = i;
      if (this.qkD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qkD);
      }
      i = paramInt;
      if (this.Hjv != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hjv);
      }
      paramInt = i;
      if (this.Hjw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hjw);
      }
      i = paramInt;
      if (this.Hjx != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hjx);
      }
      AppMethodBeat.o(32338);
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
      AppMethodBeat.o(32338);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bwl localbwl = (bwl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32338);
        return -1;
      case 1: 
        localbwl.Gay = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(32338);
        return 0;
      case 2: 
        localbwl.Gax = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(32338);
        return 0;
      case 3: 
        localbwl.qkD = locala.OmT.readString();
        AppMethodBeat.o(32338);
        return 0;
      case 4: 
        localbwl.Hjv = locala.OmT.readString();
        AppMethodBeat.o(32338);
        return 0;
      case 5: 
        localbwl.Hjw = locala.OmT.readString();
        AppMethodBeat.o(32338);
        return 0;
      }
      localbwl.Hjx = locala.OmT.readString();
      AppMethodBeat.o(32338);
      return 0;
    }
    AppMethodBeat.o(32338);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwl
 * JD-Core Version:    0.7.0.1
 */