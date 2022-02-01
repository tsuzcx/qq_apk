package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buq
  extends com.tencent.mm.bx.a
{
  public boolean FBr;
  public int FHr;
  public boolean FYO;
  public long Fsa;
  public int GOE;
  public String GOF;
  public LinkedList<String> GOG;
  public boolean GOH;
  public String GOI;
  public String GOJ;
  public String GOK;
  public String GOL;
  public String Gbw;
  public int GzV;
  public int GzX;
  public int oxQ;
  public int status;
  
  public buq()
  {
    AppMethodBeat.i(211962);
    this.GOG = new LinkedList();
    AppMethodBeat.o(211962);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211963);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Fsa);
      if (this.Gbw != null) {
        paramVarArgs.d(2, this.Gbw);
      }
      paramVarArgs.aS(3, this.FHr);
      paramVarArgs.aS(4, this.oxQ);
      paramVarArgs.aS(5, this.status);
      paramVarArgs.aS(6, this.GzV);
      paramVarArgs.aS(7, this.GOE);
      paramVarArgs.aS(8, this.GzX);
      if (this.GOF != null) {
        paramVarArgs.d(9, this.GOF);
      }
      paramVarArgs.e(10, 1, this.GOG);
      paramVarArgs.bt(11, this.FBr);
      paramVarArgs.bt(12, this.FYO);
      paramVarArgs.bt(13, this.GOH);
      if (this.GOI != null) {
        paramVarArgs.d(14, this.GOI);
      }
      if (this.GOJ != null) {
        paramVarArgs.d(15, this.GOJ);
      }
      if (this.GOK != null) {
        paramVarArgs.d(16, this.GOK);
      }
      if (this.GOL != null) {
        paramVarArgs.d(17, this.GOL);
      }
      AppMethodBeat.o(211963);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Fsa) + 0;
      paramInt = i;
      if (this.Gbw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gbw);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FHr) + f.a.a.b.b.a.bz(4, this.oxQ) + f.a.a.b.b.a.bz(5, this.status) + f.a.a.b.b.a.bz(6, this.GzV) + f.a.a.b.b.a.bz(7, this.GOE) + f.a.a.b.b.a.bz(8, this.GzX);
      paramInt = i;
      if (this.GOF != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GOF);
      }
      i = paramInt + f.a.a.a.c(10, 1, this.GOG) + f.a.a.b.b.a.alV(11) + f.a.a.b.b.a.alV(12) + f.a.a.b.b.a.alV(13);
      paramInt = i;
      if (this.GOI != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.GOI);
      }
      i = paramInt;
      if (this.GOJ != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.GOJ);
      }
      paramInt = i;
      if (this.GOK != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GOK);
      }
      i = paramInt;
      if (this.GOL != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.GOL);
      }
      AppMethodBeat.o(211963);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GOG.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(211963);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      buq localbuq = (buq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(211963);
        return -1;
      case 1: 
        localbuq.Fsa = locala.NPN.zd();
        AppMethodBeat.o(211963);
        return 0;
      case 2: 
        localbuq.Gbw = locala.NPN.readString();
        AppMethodBeat.o(211963);
        return 0;
      case 3: 
        localbuq.FHr = locala.NPN.zc();
        AppMethodBeat.o(211963);
        return 0;
      case 4: 
        localbuq.oxQ = locala.NPN.zc();
        AppMethodBeat.o(211963);
        return 0;
      case 5: 
        localbuq.status = locala.NPN.zc();
        AppMethodBeat.o(211963);
        return 0;
      case 6: 
        localbuq.GzV = locala.NPN.zc();
        AppMethodBeat.o(211963);
        return 0;
      case 7: 
        localbuq.GOE = locala.NPN.zc();
        AppMethodBeat.o(211963);
        return 0;
      case 8: 
        localbuq.GzX = locala.NPN.zc();
        AppMethodBeat.o(211963);
        return 0;
      case 9: 
        localbuq.GOF = locala.NPN.readString();
        AppMethodBeat.o(211963);
        return 0;
      case 10: 
        localbuq.GOG.add(locala.NPN.readString());
        AppMethodBeat.o(211963);
        return 0;
      case 11: 
        localbuq.FBr = locala.NPN.grw();
        AppMethodBeat.o(211963);
        return 0;
      case 12: 
        localbuq.FYO = locala.NPN.grw();
        AppMethodBeat.o(211963);
        return 0;
      case 13: 
        localbuq.GOH = locala.NPN.grw();
        AppMethodBeat.o(211963);
        return 0;
      case 14: 
        localbuq.GOI = locala.NPN.readString();
        AppMethodBeat.o(211963);
        return 0;
      case 15: 
        localbuq.GOJ = locala.NPN.readString();
        AppMethodBeat.o(211963);
        return 0;
      case 16: 
        localbuq.GOK = locala.NPN.readString();
        AppMethodBeat.o(211963);
        return 0;
      }
      localbuq.GOL = locala.NPN.readString();
      AppMethodBeat.o(211963);
      return 0;
    }
    AppMethodBeat.o(211963);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buq
 * JD-Core Version:    0.7.0.1
 */