package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ent
  extends com.tencent.mm.cd.a
{
  public int HLC;
  public String OAC;
  public int StC;
  public LinkedList<String> UqA;
  public LinkedList<String> UqB;
  public long Uqy;
  public boolean Uqz;
  
  public ent()
  {
    AppMethodBeat.i(118452);
    this.UqA = new LinkedList();
    this.UqB = new LinkedList();
    AppMethodBeat.o(118452);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118453);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Uqy);
      paramVarArgs.aY(2, this.HLC);
      paramVarArgs.aY(3, this.StC);
      paramVarArgs.co(4, this.Uqz);
      paramVarArgs.e(5, 1, this.UqA);
      paramVarArgs.e(6, 1, this.UqB);
      if (this.OAC != null) {
        paramVarArgs.f(7, this.OAC);
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.Uqy) + 0 + g.a.a.b.b.a.bM(2, this.HLC) + g.a.a.b.b.a.bM(3, this.StC) + (g.a.a.b.b.a.gL(4) + 1) + g.a.a.a.c(5, 1, this.UqA) + g.a.a.a.c(6, 1, this.UqB);
      paramInt = i;
      if (this.OAC != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.OAC);
      }
      AppMethodBeat.o(118453);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UqA.clear();
      this.UqB.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ent localent = (ent)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118453);
        return -1;
      case 1: 
        localent.Uqy = locala.abFh.AN();
        AppMethodBeat.o(118453);
        return 0;
      case 2: 
        localent.HLC = locala.abFh.AK();
        AppMethodBeat.o(118453);
        return 0;
      case 3: 
        localent.StC = locala.abFh.AK();
        AppMethodBeat.o(118453);
        return 0;
      case 4: 
        localent.Uqz = locala.abFh.AB();
        AppMethodBeat.o(118453);
        return 0;
      case 5: 
        localent.UqA.add(locala.abFh.readString());
        AppMethodBeat.o(118453);
        return 0;
      case 6: 
        localent.UqB.add(locala.abFh.readString());
        AppMethodBeat.o(118453);
        return 0;
      }
      localent.OAC = locala.abFh.readString();
      AppMethodBeat.o(118453);
      return 0;
    }
    AppMethodBeat.o(118453);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ent
 * JD-Core Version:    0.7.0.1
 */