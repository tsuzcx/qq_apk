package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class dei
  extends com.tencent.mm.bw.a
{
  public int MJq;
  public boolean MJr;
  public boolean MJs;
  public boolean MJt;
  public boolean MJu;
  public boolean MJv;
  public boolean MJw;
  public String hFF = "";
  public int id;
  public int iwc;
  public int pCV;
  public boolean pCb;
  public int pHw;
  public int pmM;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(224540);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(224540);
        throw paramVarArgs;
      }
      if (this.hFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(224540);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.id);
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      paramVarArgs.aM(3, this.iwc);
      paramVarArgs.aM(4, this.pCV);
      paramVarArgs.aM(5, this.pmM);
      paramVarArgs.aM(6, this.pHw);
      paramVarArgs.aM(7, this.MJq);
      if (this.hFF != null) {
        paramVarArgs.e(8, this.hFF);
      }
      paramVarArgs.cc(9, this.MJr);
      paramVarArgs.cc(10, this.MJs);
      paramVarArgs.cc(11, this.MJt);
      paramVarArgs.cc(12, this.MJu);
      paramVarArgs.cc(13, this.MJv);
      paramVarArgs.cc(14, this.pCb);
      paramVarArgs.cc(15, this.MJw);
      AppMethodBeat.o(224540);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.id) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.iwc) + g.a.a.b.b.a.bu(4, this.pCV) + g.a.a.b.b.a.bu(5, this.pmM) + g.a.a.b.b.a.bu(6, this.pHw) + g.a.a.b.b.a.bu(7, this.MJq);
      paramInt = i;
      if (this.hFF != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.hFF);
      }
      i = g.a.a.b.b.a.fS(9);
      int j = g.a.a.b.b.a.fS(10);
      int k = g.a.a.b.b.a.fS(11);
      int m = g.a.a.b.b.a.fS(12);
      int n = g.a.a.b.b.a.fS(13);
      int i1 = g.a.a.b.b.a.fS(14);
      int i2 = g.a.a.b.b.a.fS(15);
      AppMethodBeat.o(224540);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(224540);
        throw paramVarArgs;
      }
      if (this.hFF == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(224540);
        throw paramVarArgs;
      }
      AppMethodBeat.o(224540);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dei localdei = (dei)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(224540);
        return -1;
      case 1: 
        localdei.id = locala.UbS.zi();
        AppMethodBeat.o(224540);
        return 0;
      case 2: 
        localdei.url = locala.UbS.readString();
        AppMethodBeat.o(224540);
        return 0;
      case 3: 
        localdei.iwc = locala.UbS.zi();
        AppMethodBeat.o(224540);
        return 0;
      case 4: 
        localdei.pCV = locala.UbS.zi();
        AppMethodBeat.o(224540);
        return 0;
      case 5: 
        localdei.pmM = locala.UbS.zi();
        AppMethodBeat.o(224540);
        return 0;
      case 6: 
        localdei.pHw = locala.UbS.zi();
        AppMethodBeat.o(224540);
        return 0;
      case 7: 
        localdei.MJq = locala.UbS.zi();
        AppMethodBeat.o(224540);
        return 0;
      case 8: 
        localdei.hFF = locala.UbS.readString();
        AppMethodBeat.o(224540);
        return 0;
      case 9: 
        localdei.MJr = locala.UbS.yZ();
        AppMethodBeat.o(224540);
        return 0;
      case 10: 
        localdei.MJs = locala.UbS.yZ();
        AppMethodBeat.o(224540);
        return 0;
      case 11: 
        localdei.MJt = locala.UbS.yZ();
        AppMethodBeat.o(224540);
        return 0;
      case 12: 
        localdei.MJu = locala.UbS.yZ();
        AppMethodBeat.o(224540);
        return 0;
      case 13: 
        localdei.MJv = locala.UbS.yZ();
        AppMethodBeat.o(224540);
        return 0;
      case 14: 
        localdei.pCb = locala.UbS.yZ();
        AppMethodBeat.o(224540);
        return 0;
      }
      localdei.MJw = locala.UbS.yZ();
      AppMethodBeat.o(224540);
      return 0;
    }
    AppMethodBeat.o(224540);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dei
 * JD-Core Version:    0.7.0.1
 */