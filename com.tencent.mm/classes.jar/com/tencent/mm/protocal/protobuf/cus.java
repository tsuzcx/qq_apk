package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cus
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public int CQK;
  public String SessionId;
  public long TCv;
  public String TCw;
  public int Tkv;
  public cqh TwK;
  public aam TwL;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117878);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CPw);
      paramVarArgs.aY(2, this.Tkv);
      if (this.TwK != null)
      {
        paramVarArgs.oE(3, this.TwK.computeSize());
        this.TwK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.CQK);
      if (this.vhq != null) {
        paramVarArgs.f(5, this.vhq);
      }
      paramVarArgs.bm(6, this.TCv);
      if (this.SessionId != null) {
        paramVarArgs.f(7, this.SessionId);
      }
      if (this.TCw != null) {
        paramVarArgs.f(8, this.TCw);
      }
      if (this.TwL != null)
      {
        paramVarArgs.oE(9, this.TwL.computeSize());
        this.TwL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CPw) + 0 + g.a.a.b.b.a.bM(2, this.Tkv);
      paramInt = i;
      if (this.TwK != null) {
        paramInt = i + g.a.a.a.oD(3, this.TwK.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.CQK);
      paramInt = i;
      if (this.vhq != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.vhq);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.TCv);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SessionId);
      }
      i = paramInt;
      if (this.TCw != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TCw);
      }
      paramInt = i;
      if (this.TwL != null) {
        paramInt = i + g.a.a.a.oD(9, this.TwL.computeSize());
      }
      AppMethodBeat.o(117878);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cus localcus = (cus)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117878);
        return -1;
      case 1: 
        localcus.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117878);
        return 0;
      case 2: 
        localcus.Tkv = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117878);
        return 0;
      case 3: 
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
          localcus.TwK = ((cqh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117878);
        return 0;
      case 4: 
        localcus.CQK = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117878);
        return 0;
      case 5: 
        localcus.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117878);
        return 0;
      case 6: 
        localcus.TCv = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(117878);
        return 0;
      case 7: 
        localcus.SessionId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117878);
        return 0;
      case 8: 
        localcus.TCw = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117878);
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
        localcus.TwL = ((aam)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    AppMethodBeat.o(117878);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cus
 * JD-Core Version:    0.7.0.1
 */