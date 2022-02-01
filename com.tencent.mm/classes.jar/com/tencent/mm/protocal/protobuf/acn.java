package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acn
  extends com.tencent.mm.bw.a
{
  public int Esy;
  public int EuZ;
  public int Eva;
  public int Evb;
  public int Evc;
  public int Evd;
  public int Eve;
  public int channels;
  public int otT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EuZ);
      paramVarArgs.aR(2, this.Eva);
      paramVarArgs.aR(3, this.channels);
      paramVarArgs.aR(4, this.Evb);
      paramVarArgs.aR(5, this.Esy);
      paramVarArgs.aR(6, this.otT);
      paramVarArgs.aR(7, this.Evc);
      paramVarArgs.aR(8, this.Evd);
      paramVarArgs.aR(9, this.Eve);
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.EuZ);
      int i = f.a.a.b.b.a.bx(2, this.Eva);
      int j = f.a.a.b.b.a.bx(3, this.channels);
      int k = f.a.a.b.b.a.bx(4, this.Evb);
      int m = f.a.a.b.b.a.bx(5, this.Esy);
      int n = f.a.a.b.b.a.bx(6, this.otT);
      int i1 = f.a.a.b.b.a.bx(7, this.Evc);
      int i2 = f.a.a.b.b.a.bx(8, this.Evd);
      int i3 = f.a.a.b.b.a.bx(9, this.Eve);
      AppMethodBeat.o(90964);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(90964);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      acn localacn = (acn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(90964);
        return -1;
      case 1: 
        localacn.EuZ = locala.LVo.xF();
        AppMethodBeat.o(90964);
        return 0;
      case 2: 
        localacn.Eva = locala.LVo.xF();
        AppMethodBeat.o(90964);
        return 0;
      case 3: 
        localacn.channels = locala.LVo.xF();
        AppMethodBeat.o(90964);
        return 0;
      case 4: 
        localacn.Evb = locala.LVo.xF();
        AppMethodBeat.o(90964);
        return 0;
      case 5: 
        localacn.Esy = locala.LVo.xF();
        AppMethodBeat.o(90964);
        return 0;
      case 6: 
        localacn.otT = locala.LVo.xF();
        AppMethodBeat.o(90964);
        return 0;
      case 7: 
        localacn.Evc = locala.LVo.xF();
        AppMethodBeat.o(90964);
        return 0;
      case 8: 
        localacn.Evd = locala.LVo.xF();
        AppMethodBeat.o(90964);
        return 0;
      }
      localacn.Eve = locala.LVo.xF();
      AppMethodBeat.o(90964);
      return 0;
    }
    AppMethodBeat.o(90964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acn
 * JD-Core Version:    0.7.0.1
 */