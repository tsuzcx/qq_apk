package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ejf
  extends com.tencent.mm.bw.a
{
  public long GGA;
  public long GGz;
  public long GJB;
  public int Gze;
  public int Gzu;
  public int Gzv;
  public float Gzw;
  public aeo NiP;
  public ekn NiQ;
  public long endTimeMs;
  public String path;
  public long startTimeMs;
  public int type;
  public float volume;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201302);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(201302);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.e(1, this.path);
      }
      paramVarArgs.aM(2, this.type);
      paramVarArgs.bb(3, this.startTimeMs);
      paramVarArgs.bb(4, this.endTimeMs);
      paramVarArgs.bb(5, this.GGz);
      paramVarArgs.bb(6, this.GGA);
      paramVarArgs.bb(7, this.GJB);
      paramVarArgs.aM(8, this.Gzu);
      paramVarArgs.aM(9, this.Gzv);
      paramVarArgs.E(10, this.Gzw);
      paramVarArgs.E(11, this.volume);
      if (this.NiP != null)
      {
        paramVarArgs.ni(12, this.NiP.computeSize());
        this.NiP.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(13, this.Gze);
      if (this.NiQ != null)
      {
        paramVarArgs.ni(14, this.NiQ.computeSize());
        this.NiQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(201302);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label1060;
      }
    }
    label1060:
    for (paramInt = g.a.a.b.b.a.f(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.type) + g.a.a.b.b.a.r(3, this.startTimeMs) + g.a.a.b.b.a.r(4, this.endTimeMs) + g.a.a.b.b.a.r(5, this.GGz) + g.a.a.b.b.a.r(6, this.GGA) + g.a.a.b.b.a.r(7, this.GJB) + g.a.a.b.b.a.bu(8, this.Gzu) + g.a.a.b.b.a.bu(9, this.Gzv) + (g.a.a.b.b.a.fS(10) + 4) + (g.a.a.b.b.a.fS(11) + 4);
      paramInt = i;
      if (this.NiP != null) {
        paramInt = i + g.a.a.a.nh(12, this.NiP.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(13, this.Gze);
      paramInt = i;
      if (this.NiQ != null) {
        paramInt = i + g.a.a.a.nh(14, this.NiQ.computeSize());
      }
      AppMethodBeat.o(201302);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(201302);
          throw paramVarArgs;
        }
        AppMethodBeat.o(201302);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ejf localejf = (ejf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201302);
          return -1;
        case 1: 
          localejf.path = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201302);
          return 0;
        case 2: 
          localejf.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201302);
          return 0;
        case 3: 
          localejf.startTimeMs = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(201302);
          return 0;
        case 4: 
          localejf.endTimeMs = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(201302);
          return 0;
        case 5: 
          localejf.GGz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(201302);
          return 0;
        case 6: 
          localejf.GGA = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(201302);
          return 0;
        case 7: 
          localejf.GJB = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(201302);
          return 0;
        case 8: 
          localejf.Gzu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201302);
          return 0;
        case 9: 
          localejf.Gzv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201302);
          return 0;
        case 10: 
          localejf.Gzw = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(201302);
          return 0;
        case 11: 
          localejf.volume = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(201302);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aeo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aeo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localejf.NiP = ((aeo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201302);
          return 0;
        case 13: 
          localejf.Gze = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201302);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ekn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ekn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localejf.NiQ = ((ekn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201302);
        return 0;
      }
      AppMethodBeat.o(201302);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejf
 * JD-Core Version:    0.7.0.1
 */