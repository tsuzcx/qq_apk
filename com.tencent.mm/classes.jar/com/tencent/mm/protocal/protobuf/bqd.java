package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqd
  extends com.tencent.mm.bw.a
{
  public long DMV;
  public boolean DVV;
  public int EQE;
  public int EQG;
  public int EbF;
  public boolean ErE;
  public String Eud;
  public int Ffa;
  public String Ffb;
  public LinkedList<String> Ffc;
  public boolean Ffd;
  public String Ffe;
  public String Fff;
  public String Ffg;
  public String Ffh;
  public int nUv;
  public int status;
  
  public bqd()
  {
    AppMethodBeat.i(190885);
    this.Ffc = new LinkedList();
    AppMethodBeat.o(190885);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190886);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.DMV);
      if (this.Eud != null) {
        paramVarArgs.d(2, this.Eud);
      }
      paramVarArgs.aR(3, this.EbF);
      paramVarArgs.aR(4, this.nUv);
      paramVarArgs.aR(5, this.status);
      paramVarArgs.aR(6, this.EQE);
      paramVarArgs.aR(7, this.Ffa);
      paramVarArgs.aR(8, this.EQG);
      if (this.Ffb != null) {
        paramVarArgs.d(9, this.Ffb);
      }
      paramVarArgs.e(10, 1, this.Ffc);
      paramVarArgs.bl(11, this.DVV);
      paramVarArgs.bl(12, this.ErE);
      paramVarArgs.bl(13, this.Ffd);
      if (this.Ffe != null) {
        paramVarArgs.d(14, this.Ffe);
      }
      if (this.Fff != null) {
        paramVarArgs.d(15, this.Fff);
      }
      if (this.Ffg != null) {
        paramVarArgs.d(16, this.Ffg);
      }
      if (this.Ffh != null) {
        paramVarArgs.d(17, this.Ffh);
      }
      AppMethodBeat.o(190886);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.DMV) + 0;
      paramInt = i;
      if (this.Eud != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eud);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.EbF) + f.a.a.b.b.a.bx(4, this.nUv) + f.a.a.b.b.a.bx(5, this.status) + f.a.a.b.b.a.bx(6, this.EQE) + f.a.a.b.b.a.bx(7, this.Ffa) + f.a.a.b.b.a.bx(8, this.EQG);
      paramInt = i;
      if (this.Ffb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Ffb);
      }
      i = paramInt + f.a.a.a.c(10, 1, this.Ffc) + (f.a.a.b.b.a.fK(11) + 1) + (f.a.a.b.b.a.fK(12) + 1) + (f.a.a.b.b.a.fK(13) + 1);
      paramInt = i;
      if (this.Ffe != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Ffe);
      }
      i = paramInt;
      if (this.Fff != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Fff);
      }
      paramInt = i;
      if (this.Ffg != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Ffg);
      }
      i = paramInt;
      if (this.Ffh != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.Ffh);
      }
      AppMethodBeat.o(190886);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ffc.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(190886);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bqd localbqd = (bqd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(190886);
        return -1;
      case 1: 
        localbqd.DMV = locala.LVo.xG();
        AppMethodBeat.o(190886);
        return 0;
      case 2: 
        localbqd.Eud = locala.LVo.readString();
        AppMethodBeat.o(190886);
        return 0;
      case 3: 
        localbqd.EbF = locala.LVo.xF();
        AppMethodBeat.o(190886);
        return 0;
      case 4: 
        localbqd.nUv = locala.LVo.xF();
        AppMethodBeat.o(190886);
        return 0;
      case 5: 
        localbqd.status = locala.LVo.xF();
        AppMethodBeat.o(190886);
        return 0;
      case 6: 
        localbqd.EQE = locala.LVo.xF();
        AppMethodBeat.o(190886);
        return 0;
      case 7: 
        localbqd.Ffa = locala.LVo.xF();
        AppMethodBeat.o(190886);
        return 0;
      case 8: 
        localbqd.EQG = locala.LVo.xF();
        AppMethodBeat.o(190886);
        return 0;
      case 9: 
        localbqd.Ffb = locala.LVo.readString();
        AppMethodBeat.o(190886);
        return 0;
      case 10: 
        localbqd.Ffc.add(locala.LVo.readString());
        AppMethodBeat.o(190886);
        return 0;
      case 11: 
        localbqd.DVV = locala.LVo.fZX();
        AppMethodBeat.o(190886);
        return 0;
      case 12: 
        localbqd.ErE = locala.LVo.fZX();
        AppMethodBeat.o(190886);
        return 0;
      case 13: 
        localbqd.Ffd = locala.LVo.fZX();
        AppMethodBeat.o(190886);
        return 0;
      case 14: 
        localbqd.Ffe = locala.LVo.readString();
        AppMethodBeat.o(190886);
        return 0;
      case 15: 
        localbqd.Fff = locala.LVo.readString();
        AppMethodBeat.o(190886);
        return 0;
      case 16: 
        localbqd.Ffg = locala.LVo.readString();
        AppMethodBeat.o(190886);
        return 0;
      }
      localbqd.Ffh = locala.LVo.readString();
      AppMethodBeat.o(190886);
      return 0;
    }
    AppMethodBeat.o(190886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqd
 * JD-Core Version:    0.7.0.1
 */