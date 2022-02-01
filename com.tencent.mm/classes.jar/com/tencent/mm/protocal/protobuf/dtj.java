package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtj
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> GbA;
  public int GbB;
  public String Gby;
  public String Gbz;
  
  public dtj()
  {
    AppMethodBeat.i(147784);
    this.GbA = new LinkedList();
    AppMethodBeat.o(147784);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147785);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gby != null) {
        paramVarArgs.d(1, this.Gby);
      }
      if (this.Gbz != null) {
        paramVarArgs.d(2, this.Gbz);
      }
      paramVarArgs.e(3, 1, this.GbA);
      paramVarArgs.aR(4, this.GbB);
      AppMethodBeat.o(147785);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gby == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gby) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gbz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Gbz);
      }
      paramInt = f.a.a.a.c(3, 1, this.GbA);
      int j = f.a.a.b.b.a.bx(4, this.GbB);
      AppMethodBeat.o(147785);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GbA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(147785);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtj localdtj = (dtj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147785);
          return -1;
        case 1: 
          localdtj.Gby = locala.LVo.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 2: 
          localdtj.Gbz = locala.LVo.readString();
          AppMethodBeat.o(147785);
          return 0;
        case 3: 
          localdtj.GbA.add(locala.LVo.readString());
          AppMethodBeat.o(147785);
          return 0;
        }
        localdtj.GbB = locala.LVo.xF();
        AppMethodBeat.o(147785);
        return 0;
      }
      AppMethodBeat.o(147785);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtj
 * JD-Core Version:    0.7.0.1
 */