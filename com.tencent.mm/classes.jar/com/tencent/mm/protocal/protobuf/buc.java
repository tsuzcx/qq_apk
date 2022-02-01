package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buc
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int FfT;
  public String FjC;
  public int FjE;
  public int FjF;
  public int FjN;
  public String FjO;
  public int Fjj;
  public btu Fkb;
  public int Fkc;
  public LinkedList<btu> Fkd;
  public String Fke;
  public String Fkf;
  public String Fkg;
  public bsz Fkh;
  public int Fki;
  public int aUt;
  public int dfv;
  public String djj;
  public int gLY;
  public String md5;
  public String token;
  public String videoPath;
  
  public buc()
  {
    AppMethodBeat.i(125747);
    this.Fkd = new LinkedList();
    AppMethodBeat.o(125747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125748);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FjE);
      paramVarArgs.aR(2, this.FjF);
      paramVarArgs.aR(3, this.Fjj);
      if (this.Fkb != null)
      {
        paramVarArgs.ln(4, this.Fkb.computeSize());
        this.Fkb.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.Fkc);
      paramVarArgs.e(6, 8, this.Fkd);
      paramVarArgs.aR(7, this.gLY);
      paramVarArgs.aR(8, this.FfT);
      if (this.Desc != null) {
        paramVarArgs.d(9, this.Desc);
      }
      if (this.Fke != null) {
        paramVarArgs.d(10, this.Fke);
      }
      if (this.token != null) {
        paramVarArgs.d(11, this.token);
      }
      if (this.FjO != null) {
        paramVarArgs.d(12, this.FjO);
      }
      paramVarArgs.aR(13, this.FjN);
      if (this.videoPath != null) {
        paramVarArgs.d(14, this.videoPath);
      }
      if (this.Fkf != null) {
        paramVarArgs.d(15, this.Fkf);
      }
      if (this.Fkg != null) {
        paramVarArgs.d(16, this.Fkg);
      }
      if (this.md5 != null) {
        paramVarArgs.d(17, this.md5);
      }
      if (this.djj != null) {
        paramVarArgs.d(18, this.djj);
      }
      paramVarArgs.aR(19, this.aUt);
      paramVarArgs.aR(20, this.dfv);
      if (this.FjC != null) {
        paramVarArgs.d(21, this.FjC);
      }
      if (this.Fkh != null)
      {
        paramVarArgs.ln(22, this.Fkh.computeSize());
        this.Fkh.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(23, this.Fki);
      AppMethodBeat.o(125748);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FjE) + 0 + f.a.a.b.b.a.bx(2, this.FjF) + f.a.a.b.b.a.bx(3, this.Fjj);
      paramInt = i;
      if (this.Fkb != null) {
        paramInt = i + f.a.a.a.lm(4, this.Fkb.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Fkc) + f.a.a.a.c(6, 8, this.Fkd) + f.a.a.b.b.a.bx(7, this.gLY) + f.a.a.b.b.a.bx(8, this.FfT);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Desc);
      }
      i = paramInt;
      if (this.Fke != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Fke);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.token);
      }
      i = paramInt;
      if (this.FjO != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FjO);
      }
      i += f.a.a.b.b.a.bx(13, this.FjN);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.videoPath);
      }
      i = paramInt;
      if (this.Fkf != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Fkf);
      }
      paramInt = i;
      if (this.Fkg != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Fkg);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.md5);
      }
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.djj);
      }
      i = paramInt + f.a.a.b.b.a.bx(19, this.aUt) + f.a.a.b.b.a.bx(20, this.dfv);
      paramInt = i;
      if (this.FjC != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FjC);
      }
      i = paramInt;
      if (this.Fkh != null) {
        i = paramInt + f.a.a.a.lm(22, this.Fkh.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(23, this.Fki);
      AppMethodBeat.o(125748);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Fkd.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125748);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      buc localbuc = (buc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125748);
        return -1;
      case 1: 
        localbuc.FjE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125748);
        return 0;
      case 2: 
        localbuc.FjF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125748);
        return 0;
      case 3: 
        localbuc.Fjj = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125748);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbuc.Fkb = ((btu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 5: 
        localbuc.Fkc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125748);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbuc.Fkd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 7: 
        localbuc.gLY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125748);
        return 0;
      case 8: 
        localbuc.FfT = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125748);
        return 0;
      case 9: 
        localbuc.Desc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 10: 
        localbuc.Fke = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 11: 
        localbuc.token = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 12: 
        localbuc.FjO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 13: 
        localbuc.FjN = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125748);
        return 0;
      case 14: 
        localbuc.videoPath = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 15: 
        localbuc.Fkf = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 16: 
        localbuc.Fkg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 17: 
        localbuc.md5 = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 18: 
        localbuc.djj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 19: 
        localbuc.aUt = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125748);
        return 0;
      case 20: 
        localbuc.dfv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125748);
        return 0;
      case 21: 
        localbuc.FjC = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbuc.Fkh = ((bsz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      }
      localbuc.Fki = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(125748);
      return 0;
    }
    AppMethodBeat.o(125748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buc
 * JD-Core Version:    0.7.0.1
 */