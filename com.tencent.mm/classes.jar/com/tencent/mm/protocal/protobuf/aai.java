package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aai
  extends com.tencent.mm.cd.a
{
  public coi Phd;
  public coi Phe;
  public LinkedList<cov> Smz;
  public String subtitle;
  public String title;
  
  public aai()
  {
    AppMethodBeat.i(72460);
    this.Smz = new LinkedList();
    AppMethodBeat.o(72460);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72461);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.f(1, this.title);
      }
      if (this.subtitle != null) {
        paramVarArgs.f(2, this.subtitle);
      }
      paramVarArgs.e(3, 8, this.Smz);
      if (this.Phd != null)
      {
        paramVarArgs.oE(4, this.Phd.computeSize());
        this.Phd.writeFields(paramVarArgs);
      }
      if (this.Phe != null)
      {
        paramVarArgs.oE(5, this.Phe.computeSize());
        this.Phe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label660;
      }
    }
    label660:
    for (paramInt = g.a.a.b.b.a.g(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.subtitle != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.subtitle);
      }
      i += g.a.a.a.c(3, 8, this.Smz);
      paramInt = i;
      if (this.Phd != null) {
        paramInt = i + g.a.a.a.oD(4, this.Phd.computeSize());
      }
      i = paramInt;
      if (this.Phe != null) {
        i = paramInt + g.a.a.a.oD(5, this.Phe.computeSize());
      }
      AppMethodBeat.o(72461);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Smz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aai localaai = (aai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72461);
          return -1;
        case 1: 
          localaai.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 2: 
          localaai.subtitle = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cov();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cov)localObject2).parseFrom((byte[])localObject1);
            }
            localaai.Smz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new coi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((coi)localObject2).parseFrom((byte[])localObject1);
            }
            localaai.Phd = ((coi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new coi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((coi)localObject2).parseFrom((byte[])localObject1);
          }
          localaai.Phe = ((coi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      AppMethodBeat.o(72461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aai
 * JD-Core Version:    0.7.0.1
 */