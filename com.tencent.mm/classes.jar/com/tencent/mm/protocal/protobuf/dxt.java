package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dxt
  extends com.tencent.mm.bw.a
{
  public String GdY;
  public String GdZ;
  public String Gea;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GdY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Plugin");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.GdZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityPath");
        AppMethodBeat.o(32562);
        throw paramVarArgs;
      }
      if (this.GdY != null) {
        paramVarArgs.d(1, this.GdY);
      }
      if (this.GdZ != null) {
        paramVarArgs.d(2, this.GdZ);
      }
      if (this.Gea != null) {
        paramVarArgs.d(3, this.Gea);
      }
      AppMethodBeat.o(32562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GdY == null) {
        break label443;
      }
    }
    label443:
    for (int i = f.a.a.b.b.a.e(1, this.GdY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GdZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GdZ);
      }
      i = paramInt;
      if (this.Gea != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gea);
      }
      AppMethodBeat.o(32562);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.GdY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Plugin");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        if (this.GdZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityPath");
          AppMethodBeat.o(32562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32562);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxt localdxt = (dxt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32562);
          return -1;
        case 1: 
          localdxt.GdY = locala.LVo.readString();
          AppMethodBeat.o(32562);
          return 0;
        case 2: 
          localdxt.GdZ = locala.LVo.readString();
          AppMethodBeat.o(32562);
          return 0;
        }
        localdxt.Gea = locala.LVo.readString();
        AppMethodBeat.o(32562);
        return 0;
      }
      AppMethodBeat.o(32562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxt
 * JD-Core Version:    0.7.0.1
 */