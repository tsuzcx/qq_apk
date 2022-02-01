package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sb
  extends com.tencent.mm.cd.a
{
  public eaa RGh;
  public String ROQ;
  public clc Sbb;
  public abt Sbc;
  public int jDW;
  public int state;
  public String text;
  public int tpK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91384);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.state);
      if (this.RGh != null)
      {
        paramVarArgs.oE(2, this.RGh.computeSize());
        this.RGh.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.jDW);
      if (this.Sbb != null)
      {
        paramVarArgs.oE(4, this.Sbb.computeSize());
        this.Sbb.writeFields(paramVarArgs);
      }
      if (this.text != null) {
        paramVarArgs.f(5, this.text);
      }
      if (this.ROQ != null) {
        paramVarArgs.f(6, this.ROQ);
      }
      paramVarArgs.aY(7, this.tpK);
      if (this.Sbc != null)
      {
        paramVarArgs.oE(8, this.Sbc.computeSize());
        this.Sbc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.state) + 0;
      paramInt = i;
      if (this.RGh != null) {
        paramInt = i + g.a.a.a.oD(2, this.RGh.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.jDW);
      paramInt = i;
      if (this.Sbb != null) {
        paramInt = i + g.a.a.a.oD(4, this.Sbb.computeSize());
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.text);
      }
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ROQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.tpK);
      paramInt = i;
      if (this.Sbc != null) {
        paramInt = i + g.a.a.a.oD(8, this.Sbc.computeSize());
      }
      AppMethodBeat.o(91384);
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
      AppMethodBeat.o(91384);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      sb localsb = (sb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91384);
        return -1;
      case 1: 
        localsb.state = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91384);
        return 0;
      case 2: 
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
          localsb.RGh = ((eaa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 3: 
        localsb.jDW = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91384);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new clc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((clc)localObject2).parseFrom((byte[])localObject1);
          }
          localsb.Sbb = ((clc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 5: 
        localsb.text = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 6: 
        localsb.ROQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 7: 
        localsb.tpK = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91384);
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
        localsb.Sbc = ((abt)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    AppMethodBeat.o(91384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sb
 * JD-Core Version:    0.7.0.1
 */