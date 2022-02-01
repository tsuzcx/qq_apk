package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adx
  extends com.tencent.mm.cd.a
{
  public eaa RGh;
  public abt Sbc;
  public dzd SqB;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.type);
      if (this.SqB != null)
      {
        paramVarArgs.oE(2, this.SqB.computeSize());
        this.SqB.writeFields(paramVarArgs);
      }
      if (this.RGh != null)
      {
        paramVarArgs.oE(3, this.RGh.computeSize());
        this.RGh.writeFields(paramVarArgs);
      }
      if (this.Sbc != null)
      {
        paramVarArgs.oE(4, this.Sbc.computeSize());
        this.Sbc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.type) + 0;
      paramInt = i;
      if (this.SqB != null) {
        paramInt = i + g.a.a.a.oD(2, this.SqB.computeSize());
      }
      i = paramInt;
      if (this.RGh != null) {
        i = paramInt + g.a.a.a.oD(3, this.RGh.computeSize());
      }
      paramInt = i;
      if (this.Sbc != null) {
        paramInt = i + g.a.a.a.oD(4, this.Sbc.computeSize());
      }
      AppMethodBeat.o(91426);
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
      AppMethodBeat.o(91426);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      adx localadx = (adx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91426);
        return -1;
      case 1: 
        localadx.type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91426);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dzd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dzd)localObject2).parseFrom((byte[])localObject1);
          }
          localadx.SqB = ((dzd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eaa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eaa)localObject2).parseFrom((byte[])localObject1);
          }
          localadx.RGh = ((eaa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91426);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new abt();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((abt)localObject2).parseFrom((byte[])localObject1);
        }
        localadx.Sbc = ((abt)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91426);
      return 0;
    }
    AppMethodBeat.o(91426);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adx
 * JD-Core Version:    0.7.0.1
 */