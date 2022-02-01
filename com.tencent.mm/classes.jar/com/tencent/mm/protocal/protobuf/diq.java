package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class diq
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public int CQK;
  public String RYJ;
  public String SessionId;
  public String TQa;
  public int TQb;
  public int TQc;
  public int Tkv;
  public String Tkx;
  public cqh TwK;
  public aam TwL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117889);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RYJ != null) {
        paramVarArgs.f(1, this.RYJ);
      }
      if (this.TwK != null)
      {
        paramVarArgs.oE(2, this.TwK.computeSize());
        this.TwK.writeFields(paramVarArgs);
      }
      if (this.SessionId != null) {
        paramVarArgs.f(3, this.SessionId);
      }
      if (this.Tkx != null) {
        paramVarArgs.f(4, this.Tkx);
      }
      if (this.TQa != null) {
        paramVarArgs.f(5, this.TQa);
      }
      paramVarArgs.aY(6, this.TQb);
      paramVarArgs.aY(7, this.Tkv);
      paramVarArgs.aY(8, this.TQc);
      paramVarArgs.aY(9, this.CPw);
      paramVarArgs.aY(10, this.CQK);
      if (this.TwL != null)
      {
        paramVarArgs.oE(11, this.TwL.computeSize());
        this.TwL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RYJ == null) {
        break label886;
      }
    }
    label886:
    for (int i = g.a.a.b.b.a.g(1, this.RYJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TwK != null) {
        paramInt = i + g.a.a.a.oD(2, this.TwK.computeSize());
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SessionId);
      }
      paramInt = i;
      if (this.Tkx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tkx);
      }
      i = paramInt;
      if (this.TQa != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TQa);
      }
      i = i + g.a.a.b.b.a.bM(6, this.TQb) + g.a.a.b.b.a.bM(7, this.Tkv) + g.a.a.b.b.a.bM(8, this.TQc) + g.a.a.b.b.a.bM(9, this.CPw) + g.a.a.b.b.a.bM(10, this.CQK);
      paramInt = i;
      if (this.TwL != null) {
        paramInt = i + g.a.a.a.oD(11, this.TwL.computeSize());
      }
      AppMethodBeat.o(117889);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        diq localdiq = (diq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117889);
          return -1;
        case 1: 
          localdiq.RYJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqh)localObject2).parseFrom((byte[])localObject1);
            }
            localdiq.TwK = ((cqh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117889);
          return 0;
        case 3: 
          localdiq.SessionId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 4: 
          localdiq.Tkx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 5: 
          localdiq.TQa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 6: 
          localdiq.TQb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117889);
          return 0;
        case 7: 
          localdiq.Tkv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117889);
          return 0;
        case 8: 
          localdiq.TQc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117889);
          return 0;
        case 9: 
          localdiq.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117889);
          return 0;
        case 10: 
          localdiq.CQK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(117889);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aam();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aam)localObject2).parseFrom((byte[])localObject1);
          }
          localdiq.TwL = ((aam)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117889);
        return 0;
      }
      AppMethodBeat.o(117889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diq
 * JD-Core Version:    0.7.0.1
 */