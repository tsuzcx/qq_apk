package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public class jg
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public b RPc;
  public b RPd;
  public int RPe;
  public b RPf;
  public int vhf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133156);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RPc != null) {
        paramVarArgs.c(1, this.RPc);
      }
      paramVarArgs.aY(2, this.vhf);
      if (this.RPd != null) {
        paramVarArgs.c(3, this.RPd);
      }
      paramVarArgs.aY(4, this.RPe);
      if (this.RPf != null) {
        paramVarArgs.c(5, this.RPf);
      }
      paramVarArgs.aY(6, this.CPw);
      AppMethodBeat.o(133156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RPc == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = g.a.a.b.b.a.b(1, this.RPc) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.vhf);
      paramInt = i;
      if (this.RPd != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.RPd);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.RPe);
      paramInt = i;
      if (this.RPf != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.RPf);
      }
      i = g.a.a.b.b.a.bM(6, this.CPw);
      AppMethodBeat.o(133156);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(133156);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        jg localjg = (jg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133156);
          return -1;
        case 1: 
          localjg.RPc = locala.abFh.iUw();
          AppMethodBeat.o(133156);
          return 0;
        case 2: 
          localjg.vhf = locala.abFh.AK();
          AppMethodBeat.o(133156);
          return 0;
        case 3: 
          localjg.RPd = locala.abFh.iUw();
          AppMethodBeat.o(133156);
          return 0;
        case 4: 
          localjg.RPe = locala.abFh.AK();
          AppMethodBeat.o(133156);
          return 0;
        case 5: 
          localjg.RPf = locala.abFh.iUw();
          AppMethodBeat.o(133156);
          return 0;
        }
        localjg.CPw = locala.abFh.AK();
        AppMethodBeat.o(133156);
        return 0;
      }
      AppMethodBeat.o(133156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jg
 * JD-Core Version:    0.7.0.1
 */