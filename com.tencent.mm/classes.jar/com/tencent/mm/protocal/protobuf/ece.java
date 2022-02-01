package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ece
  extends com.tencent.mm.cd.a
{
  public long Sap;
  public String TdI;
  public cqh TwK;
  public int UgA;
  public LinkedList<ezc> UgB;
  
  public ece()
  {
    AppMethodBeat.i(117914);
    this.UgB = new LinkedList();
    AppMethodBeat.o(117914);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117915);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TdI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117915);
        throw paramVarArgs;
      }
      paramVarArgs.bm(1, this.Sap);
      if (this.TdI != null) {
        paramVarArgs.f(2, this.TdI);
      }
      if (this.TwK != null)
      {
        paramVarArgs.oE(3, this.TwK.computeSize());
        this.TwK.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.UgA);
      paramVarArgs.e(5, 8, this.UgB);
      AppMethodBeat.o(117915);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Sap) + 0;
      paramInt = i;
      if (this.TdI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TdI);
      }
      i = paramInt;
      if (this.TwK != null) {
        i = paramInt + g.a.a.a.oD(3, this.TwK.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.UgA);
      int j = g.a.a.a.c(5, 8, this.UgB);
      AppMethodBeat.o(117915);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UgB.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.TdI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117915);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117915);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ece localece = (ece)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117915);
        return -1;
      case 1: 
        localece.Sap = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(117915);
        return 0;
      case 2: 
        localece.TdI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117915);
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
          localece.TwK = ((cqh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117915);
        return 0;
      case 4: 
        localece.UgA = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(117915);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ezc();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ezc)localObject2).parseFrom((byte[])localObject1);
        }
        localece.UgB.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117915);
      return 0;
    }
    AppMethodBeat.o(117915);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ece
 * JD-Core Version:    0.7.0.1
 */