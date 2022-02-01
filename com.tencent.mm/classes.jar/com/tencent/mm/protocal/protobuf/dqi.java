package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dqi
  extends com.tencent.mm.cd.a
{
  public cit TXb;
  public aed TXc;
  public ql TXd;
  public int tpK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250469);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.tpK);
      if (this.TXb != null)
      {
        paramVarArgs.oE(2, this.TXb.computeSize());
        this.TXb.writeFields(paramVarArgs);
      }
      if (this.TXc != null)
      {
        paramVarArgs.oE(3, this.TXc.computeSize());
        this.TXc.writeFields(paramVarArgs);
      }
      if (this.TXd != null)
      {
        paramVarArgs.oE(4, this.TXd.computeSize());
        this.TXd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(250469);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.tpK) + 0;
      paramInt = i;
      if (this.TXb != null) {
        paramInt = i + g.a.a.a.oD(2, this.TXb.computeSize());
      }
      i = paramInt;
      if (this.TXc != null) {
        i = paramInt + g.a.a.a.oD(3, this.TXc.computeSize());
      }
      paramInt = i;
      if (this.TXd != null) {
        paramInt = i + g.a.a.a.oD(4, this.TXd.computeSize());
      }
      AppMethodBeat.o(250469);
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
      AppMethodBeat.o(250469);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dqi localdqi = (dqi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(250469);
        return -1;
      case 1: 
        localdqi.tpK = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(250469);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cit();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cit)localObject2).parseFrom((byte[])localObject1);
          }
          localdqi.TXb = ((cit)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250469);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aed();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aed)localObject2).parseFrom((byte[])localObject1);
          }
          localdqi.TXc = ((aed)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(250469);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new ql();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((ql)localObject2).parseFrom((byte[])localObject1);
        }
        localdqi.TXd = ((ql)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(250469);
      return 0;
    }
    AppMethodBeat.o(250469);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqi
 * JD-Core Version:    0.7.0.1
 */