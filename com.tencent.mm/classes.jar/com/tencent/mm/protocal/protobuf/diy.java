package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class diy
  extends com.tencent.mm.bw.a
{
  public double Ecf;
  public double Ecg;
  public String Fqw;
  public String Name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.Ecg);
      paramVarArgs.e(2, this.Ecf);
      if (this.Name != null) {
        paramVarArgs.d(3, this.Name);
      }
      if (this.Fqw != null) {
        paramVarArgs.d(4, this.Fqw);
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 8 + 0 + (f.a.a.b.b.a.fK(2) + 8);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Name);
      }
      i = paramInt;
      if (this.Fqw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Fqw);
      }
      AppMethodBeat.o(56262);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(56262);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      diy localdiy = (diy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56262);
        return -1;
      case 1: 
        localdiy.Ecg = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(56262);
        return 0;
      case 2: 
        localdiy.Ecf = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(56262);
        return 0;
      case 3: 
        localdiy.Name = locala.LVo.readString();
        AppMethodBeat.o(56262);
        return 0;
      }
      localdiy.Fqw = locala.LVo.readString();
      AppMethodBeat.o(56262);
      return 0;
    }
    AppMethodBeat.o(56262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diy
 * JD-Core Version:    0.7.0.1
 */