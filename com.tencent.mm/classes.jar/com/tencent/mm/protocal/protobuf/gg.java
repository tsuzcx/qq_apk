package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class gg
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> DTl;
  public long DTm;
  public String ddJ;
  public String djF;
  public String hOM;
  
  public gg()
  {
    AppMethodBeat.i(138168);
    this.DTl = new LinkedList();
    AppMethodBeat.o(138168);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138169);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djF == null)
      {
        paramVarArgs = new b("Not all required fields were included: roomname");
        AppMethodBeat.o(138169);
        throw paramVarArgs;
      }
      if (this.djF != null) {
        paramVarArgs.d(1, this.djF);
      }
      if (this.ddJ != null) {
        paramVarArgs.d(2, this.ddJ);
      }
      if (this.hOM != null) {
        paramVarArgs.d(3, this.hOM);
      }
      paramVarArgs.e(4, 1, this.DTl);
      paramVarArgs.aO(5, this.DTm);
      AppMethodBeat.o(138169);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djF == null) {
        break label486;
      }
    }
    label486:
    for (int i = f.a.a.b.b.a.e(1, this.djF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ddJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ddJ);
      }
      i = paramInt;
      if (this.hOM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hOM);
      }
      paramInt = f.a.a.a.c(4, 1, this.DTl);
      int j = f.a.a.b.b.a.p(5, this.DTm);
      AppMethodBeat.o(138169);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DTl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.djF == null)
        {
          paramVarArgs = new b("Not all required fields were included: roomname");
          AppMethodBeat.o(138169);
          throw paramVarArgs;
        }
        AppMethodBeat.o(138169);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        gg localgg = (gg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138169);
          return -1;
        case 1: 
          localgg.djF = locala.LVo.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 2: 
          localgg.ddJ = locala.LVo.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 3: 
          localgg.hOM = locala.LVo.readString();
          AppMethodBeat.o(138169);
          return 0;
        case 4: 
          localgg.DTl.add(locala.LVo.readString());
          AppMethodBeat.o(138169);
          return 0;
        }
        localgg.DTm = locala.LVo.xG();
        AppMethodBeat.o(138169);
        return 0;
      }
      AppMethodBeat.o(138169);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gg
 * JD-Core Version:    0.7.0.1
 */