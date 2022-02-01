package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahp
  extends com.tencent.mm.bw.a
{
  public int dxw;
  public int index;
  public int nLC;
  public String qIF;
  public String query;
  public int scene;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.scene);
      paramVarArgs.aR(2, this.nLC);
      paramVarArgs.aR(3, this.index);
      if (this.sessionId != null) {
        paramVarArgs.d(4, this.sessionId);
      }
      if (this.query != null) {
        paramVarArgs.d(5, this.query);
      }
      if (this.qIF != null) {
        paramVarArgs.d(6, this.qIF);
      }
      paramVarArgs.aR(7, this.dxw);
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.scene) + 0 + f.a.a.b.b.a.bx(2, this.nLC) + f.a.a.b.b.a.bx(3, this.index);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sessionId);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.query);
      }
      paramInt = i;
      if (this.qIF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.qIF);
      }
      i = f.a.a.b.b.a.bx(7, this.dxw);
      AppMethodBeat.o(127475);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahp localahp = (ahp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127475);
        return -1;
      case 1: 
        localahp.scene = locala.LVo.xF();
        AppMethodBeat.o(127475);
        return 0;
      case 2: 
        localahp.nLC = locala.LVo.xF();
        AppMethodBeat.o(127475);
        return 0;
      case 3: 
        localahp.index = locala.LVo.xF();
        AppMethodBeat.o(127475);
        return 0;
      case 4: 
        localahp.sessionId = locala.LVo.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 5: 
        localahp.query = locala.LVo.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 6: 
        localahp.qIF = locala.LVo.readString();
        AppMethodBeat.o(127475);
        return 0;
      }
      localahp.dxw = locala.LVo.xF();
      AppMethodBeat.o(127475);
      return 0;
    }
    AppMethodBeat.o(127475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahp
 * JD-Core Version:    0.7.0.1
 */