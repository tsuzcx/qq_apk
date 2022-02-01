package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfn
  extends com.tencent.mm.bx.a
{
  public int CreateTime;
  public int DeleteFlag;
  public int HtG;
  public int HtH;
  public long HtI;
  public long HtJ;
  public int HtL;
  public LinkedList<dft> HtM;
  public int HtN;
  public String Hub;
  public int IsNotRichText;
  public String Nickname;
  public String Username;
  public String hDa;
  public int nEf;
  public int tRT;
  
  public dfn()
  {
    AppMethodBeat.i(125778);
    this.HtM = new LinkedList();
    AppMethodBeat.o(125778);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125779);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.Nickname != null) {
        paramVarArgs.d(2, this.Nickname);
      }
      paramVarArgs.aS(3, this.tRT);
      paramVarArgs.aS(4, this.nEf);
      if (this.hDa != null) {
        paramVarArgs.d(5, this.hDa);
      }
      paramVarArgs.aS(6, this.CreateTime);
      paramVarArgs.aS(7, this.HtH);
      paramVarArgs.aS(8, this.HtG);
      if (this.Hub != null) {
        paramVarArgs.d(9, this.Hub);
      }
      paramVarArgs.aS(10, this.IsNotRichText);
      paramVarArgs.aY(11, this.HtI);
      paramVarArgs.aY(12, this.HtJ);
      paramVarArgs.aS(13, this.DeleteFlag);
      paramVarArgs.aS(14, this.HtL);
      paramVarArgs.e(15, 8, this.HtM);
      paramVarArgs.aS(16, this.HtN);
      AppMethodBeat.o(125779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1050;
      }
    }
    label1050:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nickname != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Nickname);
      }
      i = i + f.a.a.b.b.a.bz(3, this.tRT) + f.a.a.b.b.a.bz(4, this.nEf);
      paramInt = i;
      if (this.hDa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hDa);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.CreateTime) + f.a.a.b.b.a.bz(7, this.HtH) + f.a.a.b.b.a.bz(8, this.HtG);
      paramInt = i;
      if (this.Hub != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hub);
      }
      i = f.a.a.b.b.a.bz(10, this.IsNotRichText);
      int j = f.a.a.b.b.a.p(11, this.HtI);
      int k = f.a.a.b.b.a.p(12, this.HtJ);
      int m = f.a.a.b.b.a.bz(13, this.DeleteFlag);
      int n = f.a.a.b.b.a.bz(14, this.HtL);
      int i1 = f.a.a.a.c(15, 8, this.HtM);
      int i2 = f.a.a.b.b.a.bz(16, this.HtN);
      AppMethodBeat.o(125779);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HtM.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125779);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfn localdfn = (dfn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125779);
          return -1;
        case 1: 
          localdfn.Username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 2: 
          localdfn.Nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 3: 
          localdfn.tRT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 4: 
          localdfn.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 5: 
          localdfn.hDa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 6: 
          localdfn.CreateTime = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 7: 
          localdfn.HtH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 8: 
          localdfn.HtG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 9: 
          localdfn.Hub = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125779);
          return 0;
        case 10: 
          localdfn.IsNotRichText = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 11: 
          localdfn.HtI = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125779);
          return 0;
        case 12: 
          localdfn.HtJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125779);
          return 0;
        case 13: 
          localdfn.DeleteFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 14: 
          localdfn.HtL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125779);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dft();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dft)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfn.HtM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125779);
          return 0;
        }
        localdfn.HtN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125779);
        return 0;
      }
      AppMethodBeat.o(125779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfn
 * JD-Core Version:    0.7.0.1
 */