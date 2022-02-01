package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zv
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> Sme;
  public String Smf;
  public long Smg;
  public int rWu;
  
  public zv()
  {
    AppMethodBeat.i(6401);
    this.Sme = new LinkedList();
    AppMethodBeat.o(6401);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6402);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      paramVarArgs.e(2, 1, this.Sme);
      if (this.Smf != null) {
        paramVarArgs.f(3, this.Smf);
      }
      paramVarArgs.bm(4, this.Smg);
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.rWu) + 0 + g.a.a.a.c(2, 1, this.Sme);
      paramInt = i;
      if (this.Smf != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Smf);
      }
      i = g.a.a.b.b.a.p(4, this.Smg);
      AppMethodBeat.o(6402);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Sme.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(6402);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      zv localzv = (zv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(6402);
        return -1;
      case 1: 
        localzv.rWu = locala.abFh.AK();
        AppMethodBeat.o(6402);
        return 0;
      case 2: 
        localzv.Sme.add(locala.abFh.readString());
        AppMethodBeat.o(6402);
        return 0;
      case 3: 
        localzv.Smf = locala.abFh.readString();
        AppMethodBeat.o(6402);
        return 0;
      }
      localzv.Smg = locala.abFh.AN();
      AppMethodBeat.o(6402);
      return 0;
    }
    AppMethodBeat.o(6402);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zv
 * JD-Core Version:    0.7.0.1
 */