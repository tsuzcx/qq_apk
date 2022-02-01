package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eas
  extends com.tencent.mm.bx.a
{
  public int CJd;
  public long LwA;
  public boolean LwF;
  public boolean LwO;
  public String LwZ;
  public int LyP;
  public int LyR;
  public int Lza;
  public String Lzb;
  public LinkedList<String> Lzc;
  public boolean Lzd;
  public String Lze;
  public String Lzf;
  public String Lzg;
  public String Lzh;
  public int nrv;
  public int status;
  
  public eas()
  {
    AppMethodBeat.i(202515);
    this.Lzc = new LinkedList();
    AppMethodBeat.o(202515);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202516);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.LwA);
      if (this.LwZ != null) {
        paramVarArgs.d(2, this.LwZ);
      }
      paramVarArgs.aR(3, this.CJd);
      paramVarArgs.aR(4, this.nrv);
      paramVarArgs.aR(5, this.status);
      paramVarArgs.aR(6, this.LyP);
      paramVarArgs.aR(7, this.Lza);
      paramVarArgs.aR(8, this.LyR);
      if (this.Lzb != null) {
        paramVarArgs.d(9, this.Lzb);
      }
      paramVarArgs.e(10, 1, this.Lzc);
      paramVarArgs.bg(11, this.LwF);
      paramVarArgs.bg(12, this.LwO);
      paramVarArgs.bg(13, this.Lzd);
      if (this.Lze != null) {
        paramVarArgs.d(14, this.Lze);
      }
      if (this.Lzf != null) {
        paramVarArgs.d(15, this.Lzf);
      }
      if (this.Lzg != null) {
        paramVarArgs.d(16, this.Lzg);
      }
      if (this.Lzh != null) {
        paramVarArgs.d(17, this.Lzh);
      }
      AppMethodBeat.o(202516);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.LwA) + 0;
      paramInt = i;
      if (this.LwZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.LwZ);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.CJd) + f.a.a.b.b.a.bA(4, this.nrv) + f.a.a.b.b.a.bA(5, this.status) + f.a.a.b.b.a.bA(6, this.LyP) + f.a.a.b.b.a.bA(7, this.Lza) + f.a.a.b.b.a.bA(8, this.LyR);
      paramInt = i;
      if (this.Lzb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Lzb);
      }
      i = paramInt + f.a.a.a.c(10, 1, this.Lzc) + (f.a.a.b.b.a.fY(11) + 1) + (f.a.a.b.b.a.fY(12) + 1) + (f.a.a.b.b.a.fY(13) + 1);
      paramInt = i;
      if (this.Lze != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Lze);
      }
      i = paramInt;
      if (this.Lzf != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Lzf);
      }
      paramInt = i;
      if (this.Lzg != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Lzg);
      }
      i = paramInt;
      if (this.Lzh != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.Lzh);
      }
      AppMethodBeat.o(202516);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lzc.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(202516);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eas localeas = (eas)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(202516);
        return -1;
      case 1: 
        localeas.LwA = locala.KhF.xT();
        AppMethodBeat.o(202516);
        return 0;
      case 2: 
        localeas.LwZ = locala.KhF.readString();
        AppMethodBeat.o(202516);
        return 0;
      case 3: 
        localeas.CJd = locala.KhF.xS();
        AppMethodBeat.o(202516);
        return 0;
      case 4: 
        localeas.nrv = locala.KhF.xS();
        AppMethodBeat.o(202516);
        return 0;
      case 5: 
        localeas.status = locala.KhF.xS();
        AppMethodBeat.o(202516);
        return 0;
      case 6: 
        localeas.LyP = locala.KhF.xS();
        AppMethodBeat.o(202516);
        return 0;
      case 7: 
        localeas.Lza = locala.KhF.xS();
        AppMethodBeat.o(202516);
        return 0;
      case 8: 
        localeas.LyR = locala.KhF.xS();
        AppMethodBeat.o(202516);
        return 0;
      case 9: 
        localeas.Lzb = locala.KhF.readString();
        AppMethodBeat.o(202516);
        return 0;
      case 10: 
        localeas.Lzc.add(locala.KhF.readString());
        AppMethodBeat.o(202516);
        return 0;
      case 11: 
        localeas.LwF = locala.KhF.fHu();
        AppMethodBeat.o(202516);
        return 0;
      case 12: 
        localeas.LwO = locala.KhF.fHu();
        AppMethodBeat.o(202516);
        return 0;
      case 13: 
        localeas.Lzd = locala.KhF.fHu();
        AppMethodBeat.o(202516);
        return 0;
      case 14: 
        localeas.Lze = locala.KhF.readString();
        AppMethodBeat.o(202516);
        return 0;
      case 15: 
        localeas.Lzf = locala.KhF.readString();
        AppMethodBeat.o(202516);
        return 0;
      case 16: 
        localeas.Lzg = locala.KhF.readString();
        AppMethodBeat.o(202516);
        return 0;
      }
      localeas.Lzh = locala.KhF.readString();
      AppMethodBeat.o(202516);
      return 0;
    }
    AppMethodBeat.o(202516);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eas
 * JD-Core Version:    0.7.0.1
 */