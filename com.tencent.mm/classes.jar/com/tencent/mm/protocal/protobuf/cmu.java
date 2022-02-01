package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class cmu
  extends com.tencent.mm.bw.a
{
  public String AXc = "";
  public int HyJ;
  public boolean HyK;
  public boolean HyL;
  public boolean HyM;
  public boolean HyN;
  public boolean HyO;
  public boolean HyP;
  public int hBV;
  public int id;
  public int obQ;
  public boolean ooG;
  public int opt;
  public int otZ;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208563);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(208563);
        throw paramVarArgs;
      }
      if (this.AXc == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(208563);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.id);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.aS(3, this.hBV);
      paramVarArgs.aS(4, this.opt);
      paramVarArgs.aS(5, this.obQ);
      paramVarArgs.aS(6, this.otZ);
      paramVarArgs.aS(7, this.HyJ);
      if (this.AXc != null) {
        paramVarArgs.d(8, this.AXc);
      }
      paramVarArgs.bC(9, this.HyK);
      paramVarArgs.bC(10, this.HyL);
      paramVarArgs.bC(11, this.HyM);
      paramVarArgs.bC(12, this.HyN);
      paramVarArgs.bC(13, this.HyO);
      paramVarArgs.bC(14, this.ooG);
      paramVarArgs.bC(15, this.HyP);
      AppMethodBeat.o(208563);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.id) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.hBV) + f.a.a.b.b.a.bz(4, this.opt) + f.a.a.b.b.a.bz(5, this.obQ) + f.a.a.b.b.a.bz(6, this.otZ) + f.a.a.b.b.a.bz(7, this.HyJ);
      paramInt = i;
      if (this.AXc != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.AXc);
      }
      i = f.a.a.b.b.a.amF(9);
      int j = f.a.a.b.b.a.amF(10);
      int k = f.a.a.b.b.a.amF(11);
      int m = f.a.a.b.b.a.amF(12);
      int n = f.a.a.b.b.a.amF(13);
      int i1 = f.a.a.b.b.a.amF(14);
      int i2 = f.a.a.b.b.a.amF(15);
      AppMethodBeat.o(208563);
      return paramInt + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(208563);
        throw paramVarArgs;
      }
      if (this.AXc == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(208563);
        throw paramVarArgs;
      }
      AppMethodBeat.o(208563);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cmu localcmu = (cmu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208563);
        return -1;
      case 1: 
        localcmu.id = locala.OmT.zc();
        AppMethodBeat.o(208563);
        return 0;
      case 2: 
        localcmu.url = locala.OmT.readString();
        AppMethodBeat.o(208563);
        return 0;
      case 3: 
        localcmu.hBV = locala.OmT.zc();
        AppMethodBeat.o(208563);
        return 0;
      case 4: 
        localcmu.opt = locala.OmT.zc();
        AppMethodBeat.o(208563);
        return 0;
      case 5: 
        localcmu.obQ = locala.OmT.zc();
        AppMethodBeat.o(208563);
        return 0;
      case 6: 
        localcmu.otZ = locala.OmT.zc();
        AppMethodBeat.o(208563);
        return 0;
      case 7: 
        localcmu.HyJ = locala.OmT.zc();
        AppMethodBeat.o(208563);
        return 0;
      case 8: 
        localcmu.AXc = locala.OmT.readString();
        AppMethodBeat.o(208563);
        return 0;
      case 9: 
        localcmu.HyK = locala.OmT.gvY();
        AppMethodBeat.o(208563);
        return 0;
      case 10: 
        localcmu.HyL = locala.OmT.gvY();
        AppMethodBeat.o(208563);
        return 0;
      case 11: 
        localcmu.HyM = locala.OmT.gvY();
        AppMethodBeat.o(208563);
        return 0;
      case 12: 
        localcmu.HyN = locala.OmT.gvY();
        AppMethodBeat.o(208563);
        return 0;
      case 13: 
        localcmu.HyO = locala.OmT.gvY();
        AppMethodBeat.o(208563);
        return 0;
      case 14: 
        localcmu.ooG = locala.OmT.gvY();
        AppMethodBeat.o(208563);
        return 0;
      }
      localcmu.HyP = locala.OmT.gvY();
      AppMethodBeat.o(208563);
      return 0;
    }
    AppMethodBeat.o(208563);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmu
 * JD-Core Version:    0.7.0.1
 */