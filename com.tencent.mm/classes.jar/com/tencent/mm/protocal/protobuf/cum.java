package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cum
  extends com.tencent.mm.cd.a
{
  public String SMU;
  public int TCc;
  public float TCg;
  public float TCh;
  public String TCi;
  public LinkedList<String> TCj;
  public LinkedList<String> TCk;
  public LinkedList<cun> TCl;
  public LinkedList<cuk> TCm;
  public int TCn;
  public int duration;
  public int fHa;
  public String lpX;
  public String mKO;
  
  public cum()
  {
    AppMethodBeat.i(169924);
    this.TCj = new LinkedList();
    this.TCk = new LinkedList();
    this.TCl = new LinkedList();
    this.TCm = new LinkedList();
    this.TCn = 1;
    AppMethodBeat.o(169924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169925);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TCi == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.TCc);
      paramVarArgs.i(2, this.TCg);
      paramVarArgs.i(3, this.TCh);
      if (this.TCi != null) {
        paramVarArgs.f(4, this.TCi);
      }
      paramVarArgs.e(5, 1, this.TCj);
      if (this.SMU != null) {
        paramVarArgs.f(6, this.SMU);
      }
      paramVarArgs.e(7, 1, this.TCk);
      paramVarArgs.e(8, 8, this.TCl);
      if (this.mKO != null) {
        paramVarArgs.f(9, this.mKO);
      }
      if (this.lpX != null) {
        paramVarArgs.f(10, this.lpX);
      }
      paramVarArgs.e(11, 8, this.TCm);
      paramVarArgs.aY(12, this.fHa);
      paramVarArgs.aY(13, this.duration);
      paramVarArgs.aY(14, this.TCn);
      AppMethodBeat.o(169925);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.TCc) + 0 + (g.a.a.b.b.a.gL(2) + 4) + (g.a.a.b.b.a.gL(3) + 4);
      paramInt = i;
      if (this.TCi != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TCi);
      }
      i = paramInt + g.a.a.a.c(5, 1, this.TCj);
      paramInt = i;
      if (this.SMU != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SMU);
      }
      i = paramInt + g.a.a.a.c(7, 1, this.TCk) + g.a.a.a.c(8, 8, this.TCl);
      paramInt = i;
      if (this.mKO != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.mKO);
      }
      i = paramInt;
      if (this.lpX != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.lpX);
      }
      paramInt = g.a.a.a.c(11, 8, this.TCm);
      int j = g.a.a.b.b.a.bM(12, this.fHa);
      int k = g.a.a.b.b.a.bM(13, this.duration);
      int m = g.a.a.b.b.a.bM(14, this.TCn);
      AppMethodBeat.o(169925);
      return i + paramInt + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TCj.clear();
      this.TCk.clear();
      this.TCl.clear();
      this.TCm.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.TCi == null)
      {
        paramVarArgs = new b("Not all required fields were included: music_url");
        AppMethodBeat.o(169925);
        throw paramVarArgs;
      }
      AppMethodBeat.o(169925);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cum localcum = (cum)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169925);
        return -1;
      case 1: 
        localcum.TCc = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169925);
        return 0;
      case 2: 
        localcum.TCg = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
        AppMethodBeat.o(169925);
        return 0;
      case 3: 
        localcum.TCh = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
        AppMethodBeat.o(169925);
        return 0;
      case 4: 
        localcum.TCi = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 5: 
        localcum.TCj.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 6: 
        localcum.SMU = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 7: 
        localcum.TCk.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(169925);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cun();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cun)localObject2).parseFrom((byte[])localObject1);
          }
          localcum.TCl.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 9: 
        localcum.mKO = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 10: 
        localcum.lpX = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169925);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cuk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cuk)localObject2).parseFrom((byte[])localObject1);
          }
          localcum.TCm.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169925);
        return 0;
      case 12: 
        localcum.fHa = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169925);
        return 0;
      case 13: 
        localcum.duration = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169925);
        return 0;
      }
      localcum.TCn = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(169925);
      return 0;
    }
    AppMethodBeat.o(169925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cum
 * JD-Core Version:    0.7.0.1
 */