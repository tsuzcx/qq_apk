package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahn
  extends com.tencent.mm.bx.a
{
  public boolean LXq;
  public int ZqA;
  public LinkedList<fhb> ZqB;
  public gny Zqy;
  public LinkedList<fhc> Zqz;
  public int fZW;
  public LinkedList<gnw> likeList;
  
  public ahn()
  {
    AppMethodBeat.i(259214);
    this.Zqz = new LinkedList();
    this.likeList = new LinkedList();
    this.ZqB = new LinkedList();
    AppMethodBeat.o(259214);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259221);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.fZW);
      if (this.Zqy != null)
      {
        paramVarArgs.qD(2, this.Zqy.computeSize());
        this.Zqy.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.Zqz);
      paramVarArgs.bS(4, this.ZqA);
      paramVarArgs.e(5, 8, this.likeList);
      paramVarArgs.di(6, this.LXq);
      paramVarArgs.e(7, 8, this.ZqB);
      AppMethodBeat.o(259221);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.fZW) + 0;
      paramInt = i;
      if (this.Zqy != null) {
        paramInt = i + i.a.a.a.qC(2, this.Zqy.computeSize());
      }
      i = i.a.a.a.c(3, 8, this.Zqz);
      int j = i.a.a.b.b.a.cJ(4, this.ZqA);
      int k = i.a.a.a.c(5, 8, this.likeList);
      int m = i.a.a.b.b.a.ko(6);
      int n = i.a.a.a.c(7, 8, this.ZqB);
      AppMethodBeat.o(259221);
      return paramInt + i + j + k + (m + 1) + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zqz.clear();
      this.likeList.clear();
      this.ZqB.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259221);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      ahn localahn = (ahn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259221);
        return -1;
      case 1: 
        localahn.fZW = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259221);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gny();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gny)localObject2).parseFrom((byte[])localObject1);
          }
          localahn.Zqy = ((gny)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259221);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhc)localObject2).parseFrom((byte[])localObject1);
          }
          localahn.Zqz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259221);
        return 0;
      case 4: 
        localahn.ZqA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259221);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gnw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gnw)localObject2).parseFrom((byte[])localObject1);
          }
          localahn.likeList.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259221);
        return 0;
      case 6: 
        localahn.LXq = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(259221);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fhb();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fhb)localObject2).parseFrom((byte[])localObject1);
        }
        localahn.ZqB.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(259221);
      return 0;
    }
    AppMethodBeat.o(259221);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahn
 * JD-Core Version:    0.7.0.1
 */