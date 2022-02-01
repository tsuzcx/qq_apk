package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cey
  extends dyy
{
  public LinkedList<blw> RIz;
  public String TmA;
  public String TmB;
  public String TmC;
  public String TmD;
  public boolean TmE;
  public int TmF;
  public String TmG;
  public LinkedList<String> Tmp;
  public String Tmq;
  public String Tmr;
  public boolean Tmt;
  public LinkedList<fqm> Tmy;
  public LinkedList<fqn> Tmz;
  public String lmG;
  public boolean viu;
  
  public cey()
  {
    AppMethodBeat.i(32282);
    this.Tmy = new LinkedList();
    this.Tmz = new LinkedList();
    this.Tmp = new LinkedList();
    this.RIz = new LinkedList();
    AppMethodBeat.o(32282);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32283);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.TmA == null)
      {
        paramVarArgs = new b("Not all required fields were included: championcoverurl");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.TmB == null)
      {
        paramVarArgs = new b("Not all required fields were included: championmotto");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.lmG == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32283);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Tmy);
      paramVarArgs.e(3, 8, this.Tmz);
      paramVarArgs.e(4, 1, this.Tmp);
      if (this.TmA != null) {
        paramVarArgs.f(5, this.TmA);
      }
      if (this.TmB != null) {
        paramVarArgs.f(6, this.TmB);
      }
      if (this.lmG != null) {
        paramVarArgs.f(7, this.lmG);
      }
      if (this.TmC != null) {
        paramVarArgs.f(8, this.TmC);
      }
      if (this.Tmq != null) {
        paramVarArgs.f(9, this.Tmq);
      }
      paramVarArgs.co(10, this.viu);
      if (this.Tmr != null) {
        paramVarArgs.f(11, this.Tmr);
      }
      paramVarArgs.e(12, 8, this.RIz);
      paramVarArgs.co(13, this.Tmt);
      if (this.TmD != null) {
        paramVarArgs.f(14, this.TmD);
      }
      paramVarArgs.co(15, this.TmE);
      paramVarArgs.aY(16, this.TmF);
      if (this.TmG != null) {
        paramVarArgs.f(17, this.TmG);
      }
      AppMethodBeat.o(32283);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1589;
      }
    }
    label1589:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Tmy) + g.a.a.a.c(3, 8, this.Tmz) + g.a.a.a.c(4, 1, this.Tmp);
      paramInt = i;
      if (this.TmA != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TmA);
      }
      i = paramInt;
      if (this.TmB != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TmB);
      }
      paramInt = i;
      if (this.lmG != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.lmG);
      }
      i = paramInt;
      if (this.TmC != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TmC);
      }
      paramInt = i;
      if (this.Tmq != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Tmq);
      }
      i = paramInt + (g.a.a.b.b.a.gL(10) + 1);
      paramInt = i;
      if (this.Tmr != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Tmr);
      }
      i = paramInt + g.a.a.a.c(12, 8, this.RIz) + (g.a.a.b.b.a.gL(13) + 1);
      paramInt = i;
      if (this.TmD != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.TmD);
      }
      i = paramInt + (g.a.a.b.b.a.gL(15) + 1) + g.a.a.b.b.a.bM(16, this.TmF);
      paramInt = i;
      if (this.TmG != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.TmG);
      }
      AppMethodBeat.o(32283);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tmy.clear();
        this.Tmz.clear();
        this.Tmp.clear();
        this.RIz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.TmA == null)
        {
          paramVarArgs = new b("Not all required fields were included: championcoverurl");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.TmB == null)
        {
          paramVarArgs = new b("Not all required fields were included: championmotto");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        if (this.lmG == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32283);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32283);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cey localcey = (cey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32283);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localcey.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqm)localObject2).parseFrom((byte[])localObject1);
            }
            localcey.Tmy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqn)localObject2).parseFrom((byte[])localObject1);
            }
            localcey.Tmz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 4: 
          localcey.Tmp.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(32283);
          return 0;
        case 5: 
          localcey.TmA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 6: 
          localcey.TmB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 7: 
          localcey.lmG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 8: 
          localcey.TmC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 9: 
          localcey.Tmq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 10: 
          localcey.viu = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(32283);
          return 0;
        case 11: 
          localcey.Tmr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new blw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((blw)localObject2).parseFrom((byte[])localObject1);
            }
            localcey.RIz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32283);
          return 0;
        case 13: 
          localcey.Tmt = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(32283);
          return 0;
        case 14: 
          localcey.TmD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32283);
          return 0;
        case 15: 
          localcey.TmE = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(32283);
          return 0;
        case 16: 
          localcey.TmF = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32283);
          return 0;
        }
        localcey.TmG = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32283);
        return 0;
      }
      AppMethodBeat.o(32283);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cey
 * JD-Core Version:    0.7.0.1
 */