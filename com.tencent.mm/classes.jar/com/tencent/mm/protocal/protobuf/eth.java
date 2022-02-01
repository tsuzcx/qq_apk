package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eth
  extends com.tencent.mm.cd.a
{
  public long MQV;
  public long MQW;
  public int NmG;
  public int Nna;
  public int Nnb;
  public float Nnc;
  public long NwS;
  public aex Uvu;
  public eus Uvv;
  public long endTimeMs;
  public String path;
  public long startTimeMs;
  public int type;
  public float volume;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(255109);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(255109);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.f(1, this.path);
      }
      paramVarArgs.aY(2, this.type);
      paramVarArgs.bm(3, this.startTimeMs);
      paramVarArgs.bm(4, this.endTimeMs);
      paramVarArgs.bm(5, this.MQV);
      paramVarArgs.bm(6, this.MQW);
      paramVarArgs.bm(7, this.NwS);
      paramVarArgs.aY(8, this.Nna);
      paramVarArgs.aY(9, this.Nnb);
      paramVarArgs.i(10, this.Nnc);
      paramVarArgs.i(11, this.volume);
      if (this.Uvu != null)
      {
        paramVarArgs.oE(12, this.Uvu.computeSize());
        this.Uvu.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.NmG);
      if (this.Uvv != null)
      {
        paramVarArgs.oE(14, this.Uvv.computeSize());
        this.Uvv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(255109);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label1016;
      }
    }
    label1016:
    for (paramInt = g.a.a.b.b.a.g(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.type) + g.a.a.b.b.a.p(3, this.startTimeMs) + g.a.a.b.b.a.p(4, this.endTimeMs) + g.a.a.b.b.a.p(5, this.MQV) + g.a.a.b.b.a.p(6, this.MQW) + g.a.a.b.b.a.p(7, this.NwS) + g.a.a.b.b.a.bM(8, this.Nna) + g.a.a.b.b.a.bM(9, this.Nnb) + (g.a.a.b.b.a.gL(10) + 4) + (g.a.a.b.b.a.gL(11) + 4);
      paramInt = i;
      if (this.Uvu != null) {
        paramInt = i + g.a.a.a.oD(12, this.Uvu.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.NmG);
      paramInt = i;
      if (this.Uvv != null) {
        paramInt = i + g.a.a.a.oD(14, this.Uvv.computeSize());
      }
      AppMethodBeat.o(255109);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(255109);
          throw paramVarArgs;
        }
        AppMethodBeat.o(255109);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eth localeth = (eth)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(255109);
          return -1;
        case 1: 
          localeth.path = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(255109);
          return 0;
        case 2: 
          localeth.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255109);
          return 0;
        case 3: 
          localeth.startTimeMs = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(255109);
          return 0;
        case 4: 
          localeth.endTimeMs = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(255109);
          return 0;
        case 5: 
          localeth.MQV = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(255109);
          return 0;
        case 6: 
          localeth.MQW = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(255109);
          return 0;
        case 7: 
          localeth.NwS = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(255109);
          return 0;
        case 8: 
          localeth.Nna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255109);
          return 0;
        case 9: 
          localeth.Nnb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255109);
          return 0;
        case 10: 
          localeth.Nnc = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(255109);
          return 0;
        case 11: 
          localeth.volume = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(255109);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aex();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aex)localObject2).parseFrom((byte[])localObject1);
            }
            localeth.Uvu = ((aex)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(255109);
          return 0;
        case 13: 
          localeth.NmG = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(255109);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eus();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eus)localObject2).parseFrom((byte[])localObject1);
          }
          localeth.Uvv = ((eus)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(255109);
        return 0;
      }
      AppMethodBeat.o(255109);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eth
 * JD-Core Version:    0.7.0.1
 */