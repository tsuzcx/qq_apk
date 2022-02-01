package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqa
  extends com.tencent.mm.bw.a
{
  public long DMV;
  public int EbF;
  public String Eud;
  public String FeV;
  public String FeW;
  public int rotation;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190882);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DMV);
      if (this.FeV != null) {
        paramVarArgs.d(2, this.FeV);
      }
      paramVarArgs.aR(3, this.rotation);
      if (this.Eud != null) {
        paramVarArgs.d(4, this.Eud);
      }
      paramVarArgs.aR(5, this.EbF);
      if (this.FeW != null) {
        paramVarArgs.d(6, this.FeW);
      }
      AppMethodBeat.o(190882);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.DMV) + 0;
      paramInt = i;
      if (this.FeV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FeV);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.rotation);
      paramInt = i;
      if (this.Eud != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eud);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EbF);
      paramInt = i;
      if (this.FeW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FeW);
      }
      AppMethodBeat.o(190882);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(190882);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bqa localbqa = (bqa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(190882);
        return -1;
      case 1: 
        localbqa.DMV = locala.LVo.xG();
        AppMethodBeat.o(190882);
        return 0;
      case 2: 
        localbqa.FeV = locala.LVo.readString();
        AppMethodBeat.o(190882);
        return 0;
      case 3: 
        localbqa.rotation = locala.LVo.xF();
        AppMethodBeat.o(190882);
        return 0;
      case 4: 
        localbqa.Eud = locala.LVo.readString();
        AppMethodBeat.o(190882);
        return 0;
      case 5: 
        localbqa.EbF = locala.LVo.xF();
        AppMethodBeat.o(190882);
        return 0;
      }
      localbqa.FeW = locala.LVo.readString();
      AppMethodBeat.o(190882);
      return 0;
    }
    AppMethodBeat.o(190882);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqa
 * JD-Core Version:    0.7.0.1
 */