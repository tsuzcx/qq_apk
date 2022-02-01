package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzm
  extends com.tencent.mm.cd.a
{
  public eaa RGh;
  public String ROQ;
  public erh SpR;
  public int UeX;
  public int UeY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91674);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.UeX);
      paramVarArgs.aY(2, this.UeY);
      if (this.RGh != null)
      {
        paramVarArgs.oE(3, this.RGh.computeSize());
        this.RGh.writeFields(paramVarArgs);
      }
      if (this.SpR != null)
      {
        paramVarArgs.oE(4, this.SpR.computeSize());
        this.SpR.writeFields(paramVarArgs);
      }
      if (this.ROQ != null) {
        paramVarArgs.f(5, this.ROQ);
      }
      AppMethodBeat.o(91674);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.UeX) + 0 + g.a.a.b.b.a.bM(2, this.UeY);
      paramInt = i;
      if (this.RGh != null) {
        paramInt = i + g.a.a.a.oD(3, this.RGh.computeSize());
      }
      i = paramInt;
      if (this.SpR != null) {
        i = paramInt + g.a.a.a.oD(4, this.SpR.computeSize());
      }
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ROQ);
      }
      AppMethodBeat.o(91674);
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
      AppMethodBeat.o(91674);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      dzm localdzm = (dzm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91674);
        return -1;
      case 1: 
        localdzm.UeX = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91674);
        return 0;
      case 2: 
        localdzm.UeY = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91674);
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
          localdzm.RGh = ((eaa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new erh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((erh)localObject2).parseFrom((byte[])localObject1);
          }
          localdzm.SpR = ((erh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      }
      localdzm.ROQ = ((g.a.a.a.a)localObject1).abFh.readString();
      AppMethodBeat.o(91674);
      return 0;
    }
    AppMethodBeat.o(91674);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzm
 * JD-Core Version:    0.7.0.1
 */