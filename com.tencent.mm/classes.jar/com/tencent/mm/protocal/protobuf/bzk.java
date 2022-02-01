package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzk
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int HiZ;
  public String HmE;
  public int HmG;
  public int HmH;
  public int HmP;
  public String HmQ;
  public int Hml;
  public bzc Hnd;
  public int Hne;
  public LinkedList<bzc> Hnf;
  public String Hng;
  public String Hnh;
  public String Hni;
  public byg Hnj;
  public int Hnk;
  public int beN;
  public int drW;
  public String dwb;
  public int hiJ;
  public String md5;
  public String token;
  public String videoPath;
  
  public bzk()
  {
    AppMethodBeat.i(125747);
    this.Hnf = new LinkedList();
    AppMethodBeat.o(125747);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125748);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HmG);
      paramVarArgs.aS(2, this.HmH);
      paramVarArgs.aS(3, this.Hml);
      if (this.Hnd != null)
      {
        paramVarArgs.lJ(4, this.Hnd.computeSize());
        this.Hnd.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.Hne);
      paramVarArgs.e(6, 8, this.Hnf);
      paramVarArgs.aS(7, this.hiJ);
      paramVarArgs.aS(8, this.HiZ);
      if (this.Desc != null) {
        paramVarArgs.d(9, this.Desc);
      }
      if (this.Hng != null) {
        paramVarArgs.d(10, this.Hng);
      }
      if (this.token != null) {
        paramVarArgs.d(11, this.token);
      }
      if (this.HmQ != null) {
        paramVarArgs.d(12, this.HmQ);
      }
      paramVarArgs.aS(13, this.HmP);
      if (this.videoPath != null) {
        paramVarArgs.d(14, this.videoPath);
      }
      if (this.Hnh != null) {
        paramVarArgs.d(15, this.Hnh);
      }
      if (this.Hni != null) {
        paramVarArgs.d(16, this.Hni);
      }
      if (this.md5 != null) {
        paramVarArgs.d(17, this.md5);
      }
      if (this.dwb != null) {
        paramVarArgs.d(18, this.dwb);
      }
      paramVarArgs.aS(19, this.beN);
      paramVarArgs.aS(20, this.drW);
      if (this.HmE != null) {
        paramVarArgs.d(21, this.HmE);
      }
      if (this.Hnj != null)
      {
        paramVarArgs.lJ(22, this.Hnj.computeSize());
        this.Hnj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(23, this.Hnk);
      AppMethodBeat.o(125748);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HmG) + 0 + f.a.a.b.b.a.bz(2, this.HmH) + f.a.a.b.b.a.bz(3, this.Hml);
      paramInt = i;
      if (this.Hnd != null) {
        paramInt = i + f.a.a.a.lI(4, this.Hnd.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Hne) + f.a.a.a.c(6, 8, this.Hnf) + f.a.a.b.b.a.bz(7, this.hiJ) + f.a.a.b.b.a.bz(8, this.HiZ);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Desc);
      }
      i = paramInt;
      if (this.Hng != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Hng);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.token);
      }
      i = paramInt;
      if (this.HmQ != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HmQ);
      }
      i += f.a.a.b.b.a.bz(13, this.HmP);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.videoPath);
      }
      i = paramInt;
      if (this.Hnh != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.Hnh);
      }
      paramInt = i;
      if (this.Hni != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.Hni);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.md5);
      }
      paramInt = i;
      if (this.dwb != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.dwb);
      }
      i = paramInt + f.a.a.b.b.a.bz(19, this.beN) + f.a.a.b.b.a.bz(20, this.drW);
      paramInt = i;
      if (this.HmE != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.HmE);
      }
      i = paramInt;
      if (this.Hnj != null) {
        i = paramInt + f.a.a.a.lI(22, this.Hnj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(23, this.Hnk);
      AppMethodBeat.o(125748);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hnf.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125748);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bzk localbzk = (bzk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125748);
        return -1;
      case 1: 
        localbzk.HmG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 2: 
        localbzk.HmH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 3: 
        localbzk.Hml = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bzc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzk.Hnd = ((bzc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 5: 
        localbzk.Hne = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bzc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bzc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzk.Hnf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      case 7: 
        localbzk.hiJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 8: 
        localbzk.HiZ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 9: 
        localbzk.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 10: 
        localbzk.Hng = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 11: 
        localbzk.token = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 12: 
        localbzk.HmQ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 13: 
        localbzk.HmP = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 14: 
        localbzk.videoPath = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 15: 
        localbzk.Hnh = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 16: 
        localbzk.Hni = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 17: 
        localbzk.md5 = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 18: 
        localbzk.dwb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 19: 
        localbzk.beN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 20: 
        localbzk.drW = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125748);
        return 0;
      case 21: 
        localbzk.HmE = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125748);
        return 0;
      case 22: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbzk.Hnj = ((byg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125748);
        return 0;
      }
      localbzk.Hnk = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(125748);
      return 0;
    }
    AppMethodBeat.o(125748);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzk
 * JD-Core Version:    0.7.0.1
 */