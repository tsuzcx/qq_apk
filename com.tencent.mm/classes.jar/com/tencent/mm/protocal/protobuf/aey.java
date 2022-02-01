package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aey
  extends com.tencent.mm.cd.a
{
  public dbu Srs;
  public LinkedList<ahr> Srt;
  public LinkedList<fbm> Sru;
  public String Srv;
  
  public aey()
  {
    AppMethodBeat.i(91431);
    this.Srt = new LinkedList();
    this.Sru = new LinkedList();
    AppMethodBeat.o(91431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91432);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Srs != null)
      {
        paramVarArgs.oE(1, this.Srs.computeSize());
        this.Srs.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Srt);
      paramVarArgs.e(3, 8, this.Sru);
      if (this.Srv != null) {
        paramVarArgs.f(4, this.Srv);
      }
      AppMethodBeat.o(91432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Srs == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = g.a.a.a.oD(1, this.Srs.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Srt) + g.a.a.a.c(3, 8, this.Sru);
      paramInt = i;
      if (this.Srv != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Srv);
      }
      AppMethodBeat.o(91432);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Srt.clear();
        this.Sru.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aey localaey = (aey)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91432);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbu)localObject2).parseFrom((byte[])localObject1);
            }
            localaey.Srs = ((dbu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahr)localObject2).parseFrom((byte[])localObject1);
            }
            localaey.Srt.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbm)localObject2).parseFrom((byte[])localObject1);
            }
            localaey.Sru.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91432);
          return 0;
        }
        localaey.Srv = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91432);
        return 0;
      }
      AppMethodBeat.o(91432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aey
 * JD-Core Version:    0.7.0.1
 */