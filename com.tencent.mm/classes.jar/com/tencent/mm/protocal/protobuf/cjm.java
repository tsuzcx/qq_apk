package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjm
  extends com.tencent.mm.bw.a
{
  public int Mpa;
  public LinkedList<cjl> Mpb;
  public int Mpc;
  public long Mpd;
  public long Mpe;
  public long Mpf;
  public LinkedList<cjj> Mpg;
  public dmr Mph;
  public String clientId;
  public long hdA;
  public int ibG;
  public int postStage;
  public long zZb;
  
  public cjm()
  {
    AppMethodBeat.i(169081);
    this.Mpb = new LinkedList();
    this.Mpg = new LinkedList();
    AppMethodBeat.o(169081);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169082);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.clientId != null) {
        paramVarArgs.e(1, this.clientId);
      }
      paramVarArgs.aM(2, this.ibG);
      paramVarArgs.aM(3, this.Mpa);
      paramVarArgs.e(4, 8, this.Mpb);
      paramVarArgs.aM(5, this.Mpc);
      paramVarArgs.aM(6, this.postStage);
      paramVarArgs.bb(7, this.Mpd);
      paramVarArgs.bb(8, this.zZb);
      paramVarArgs.bb(9, this.Mpe);
      paramVarArgs.bb(10, this.hdA);
      paramVarArgs.bb(11, this.Mpf);
      paramVarArgs.e(12, 8, this.Mpg);
      if (this.Mph != null)
      {
        paramVarArgs.ni(13, this.Mph.computeSize());
        this.Mph.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169082);
      return 0;
    }
    if (paramInt == 1) {
      if (this.clientId == null) {
        break label1042;
      }
    }
    label1042:
    for (paramInt = g.a.a.b.b.a.f(1, this.clientId) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.ibG) + g.a.a.b.b.a.bu(3, this.Mpa) + g.a.a.a.c(4, 8, this.Mpb) + g.a.a.b.b.a.bu(5, this.Mpc) + g.a.a.b.b.a.bu(6, this.postStage) + g.a.a.b.b.a.r(7, this.Mpd) + g.a.a.b.b.a.r(8, this.zZb) + g.a.a.b.b.a.r(9, this.Mpe) + g.a.a.b.b.a.r(10, this.hdA) + g.a.a.b.b.a.r(11, this.Mpf) + g.a.a.a.c(12, 8, this.Mpg);
      paramInt = i;
      if (this.Mph != null) {
        paramInt = i + g.a.a.a.nh(13, this.Mph.computeSize());
      }
      AppMethodBeat.o(169082);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Mpb.clear();
        this.Mpg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cjm localcjm = (cjm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169082);
          return -1;
        case 1: 
          localcjm.clientId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169082);
          return 0;
        case 2: 
          localcjm.ibG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169082);
          return 0;
        case 3: 
          localcjm.Mpa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169082);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjm.Mpb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        case 5: 
          localcjm.Mpc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169082);
          return 0;
        case 6: 
          localcjm.postStage = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169082);
          return 0;
        case 7: 
          localcjm.Mpd = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169082);
          return 0;
        case 8: 
          localcjm.zZb = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169082);
          return 0;
        case 9: 
          localcjm.Mpe = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169082);
          return 0;
        case 10: 
          localcjm.hdA = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169082);
          return 0;
        case 11: 
          localcjm.Mpf = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(169082);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjm.Mpg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169082);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcjm.Mph = ((dmr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169082);
        return 0;
      }
      AppMethodBeat.o(169082);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjm
 * JD-Core Version:    0.7.0.1
 */