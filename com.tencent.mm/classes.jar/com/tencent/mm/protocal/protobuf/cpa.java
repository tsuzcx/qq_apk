package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpa
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String RYJ;
  public String SessionId;
  public int Tkv;
  public String Tkx;
  public cqh TwK;
  public aam TwL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212401);
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
      paramVarArgs.aY(3, this.CPw);
      if (this.TwL != null)
      {
        paramVarArgs.oE(4, this.TwL.computeSize());
        this.TwL.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.Tkv);
      if (this.Tkx != null) {
        paramVarArgs.f(6, this.Tkx);
      }
      if (this.SessionId != null) {
        paramVarArgs.f(7, this.SessionId);
      }
      AppMethodBeat.o(212401);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RYJ == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.b.b.a.g(1, this.RYJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TwK != null) {
        i = paramInt + g.a.a.a.oD(2, this.TwK.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.CPw);
      paramInt = i;
      if (this.TwL != null) {
        paramInt = i + g.a.a.a.oD(4, this.TwL.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Tkv);
      paramInt = i;
      if (this.Tkx != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tkx);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SessionId);
      }
      AppMethodBeat.o(212401);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(212401);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cpa localcpa = (cpa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212401);
          return -1;
        case 1: 
          localcpa.RYJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(212401);
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
            localcpa.TwK = ((cqh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(212401);
          return 0;
        case 3: 
          localcpa.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(212401);
          return 0;
        case 4: 
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
            localcpa.TwL = ((aam)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(212401);
          return 0;
        case 5: 
          localcpa.Tkv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(212401);
          return 0;
        case 6: 
          localcpa.Tkx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(212401);
          return 0;
        }
        localcpa.SessionId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(212401);
        return 0;
      }
      AppMethodBeat.o(212401);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpa
 * JD-Core Version:    0.7.0.1
 */