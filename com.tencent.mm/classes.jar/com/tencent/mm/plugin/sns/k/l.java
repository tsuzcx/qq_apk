package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends com.tencent.mm.bx.a
{
  public LinkedList<Long> Adz;
  public LinkedList<Long> QCO;
  public int QCP;
  public int QCQ;
  public int QCR;
  public LinkedList<Long> QCS;
  public LinkedList<String> osR;
  public int state;
  public long timestamp;
  
  public l()
  {
    AppMethodBeat.i(179121);
    this.Adz = new LinkedList();
    this.QCO = new LinkedList();
    this.osR = new LinkedList();
    this.QCS = new LinkedList();
    AppMethodBeat.o(179121);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179122);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 3, this.Adz);
      paramVarArgs.bv(2, this.timestamp);
      paramVarArgs.bS(3, this.state);
      paramVarArgs.e(4, 3, this.QCO);
      paramVarArgs.bS(5, this.QCP);
      paramVarArgs.bS(6, this.QCQ);
      paramVarArgs.bS(7, this.QCR);
      paramVarArgs.e(8, 1, this.osR);
      paramVarArgs.e(9, 3, this.QCS);
      AppMethodBeat.o(179122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 3, this.Adz);
      int i = i.a.a.b.b.a.q(2, this.timestamp);
      int j = i.a.a.b.b.a.cJ(3, this.state);
      int k = i.a.a.a.c(4, 3, this.QCO);
      int m = i.a.a.b.b.a.cJ(5, this.QCP);
      int n = i.a.a.b.b.a.cJ(6, this.QCQ);
      int i1 = i.a.a.b.b.a.cJ(7, this.QCR);
      int i2 = i.a.a.a.c(8, 1, this.osR);
      int i3 = i.a.a.a.c(9, 3, this.QCS);
      AppMethodBeat.o(179122);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Adz.clear();
      this.QCO.clear();
      this.osR.clear();
      this.QCS.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(179122);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(179122);
        return -1;
      case 1: 
        locall.Adz.add(Long.valueOf(locala.ajGk.aaw()));
        AppMethodBeat.o(179122);
        return 0;
      case 2: 
        locall.timestamp = locala.ajGk.aaw();
        AppMethodBeat.o(179122);
        return 0;
      case 3: 
        locall.state = locala.ajGk.aar();
        AppMethodBeat.o(179122);
        return 0;
      case 4: 
        locall.QCO.add(Long.valueOf(locala.ajGk.aaw()));
        AppMethodBeat.o(179122);
        return 0;
      case 5: 
        locall.QCP = locala.ajGk.aar();
        AppMethodBeat.o(179122);
        return 0;
      case 6: 
        locall.QCQ = locala.ajGk.aar();
        AppMethodBeat.o(179122);
        return 0;
      case 7: 
        locall.QCR = locala.ajGk.aar();
        AppMethodBeat.o(179122);
        return 0;
      case 8: 
        locall.osR.add(locala.ajGk.readString());
        AppMethodBeat.o(179122);
        return 0;
      }
      locall.QCS.add(Long.valueOf(locala.ajGk.aaw()));
      AppMethodBeat.o(179122);
      return 0;
    }
    AppMethodBeat.o(179122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.l
 * JD-Core Version:    0.7.0.1
 */