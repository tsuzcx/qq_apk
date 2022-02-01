package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcg
  extends com.tencent.mm.bx.a
{
  public String CJK;
  public int CXP;
  public String DoR;
  public int Egp;
  public LinkedList<dcf> EtI;
  public boolean EtJ;
  public LinkedList<dci> EtK;
  public String EtL;
  public String Md5;
  public int Version;
  public int mBH;
  
  public dcg()
  {
    AppMethodBeat.i(6438);
    this.EtI = new LinkedList();
    this.EtK = new LinkedList();
    AppMethodBeat.o(6438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6439);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBH);
      paramVarArgs.aR(2, this.Version);
      if (this.CJK != null) {
        paramVarArgs.d(3, this.CJK);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(4, this.Md5);
      }
      paramVarArgs.aR(5, this.CXP);
      paramVarArgs.aR(6, this.Egp);
      paramVarArgs.e(7, 8, this.EtI);
      paramVarArgs.bg(8, this.EtJ);
      if (this.DoR != null) {
        paramVarArgs.d(9, this.DoR);
      }
      paramVarArgs.e(10, 8, this.EtK);
      if (this.EtL != null) {
        paramVarArgs.d(11, this.EtL);
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.mBH) + 0 + f.a.a.b.b.a.bA(2, this.Version);
      paramInt = i;
      if (this.CJK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CJK);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Md5);
      }
      i = i + f.a.a.b.b.a.bA(5, this.CXP) + f.a.a.b.b.a.bA(6, this.Egp) + f.a.a.a.c(7, 8, this.EtI) + (f.a.a.b.b.a.fY(8) + 1);
      paramInt = i;
      if (this.DoR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DoR);
      }
      i = paramInt + f.a.a.a.c(10, 8, this.EtK);
      paramInt = i;
      if (this.EtL != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EtL);
      }
      AppMethodBeat.o(6439);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EtI.clear();
      this.EtK.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dcg localdcg = (dcg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(6439);
        return -1;
      case 1: 
        localdcg.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(6439);
        return 0;
      case 2: 
        localdcg.Version = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(6439);
        return 0;
      case 3: 
        localdcg.CJK = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 4: 
        localdcg.Md5 = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 5: 
        localdcg.CXP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(6439);
        return 0;
      case 6: 
        localdcg.Egp = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(6439);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dcf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dcf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcg.EtI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      case 8: 
        localdcg.EtJ = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(6439);
        return 0;
      case 9: 
        localdcg.DoR = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dci();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dci)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcg.EtK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      }
      localdcg.EtL = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(6439);
      return 0;
    }
    AppMethodBeat.o(6439);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcg
 * JD-Core Version:    0.7.0.1
 */