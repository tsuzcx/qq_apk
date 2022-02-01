package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ere
  extends com.tencent.mm.cd.a
{
  public String IbE;
  public eaa RGh;
  public String ROQ;
  public long Utp;
  public int Utq;
  public aim Utr;
  public int Uts;
  public float size;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.Utp);
      if (this.IbE != null) {
        paramVarArgs.f(2, this.IbE);
      }
      if (this.text != null) {
        paramVarArgs.f(3, this.text);
      }
      paramVarArgs.i(4, this.size);
      if (this.RGh != null)
      {
        paramVarArgs.oE(5, this.RGh.computeSize());
        this.RGh.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.Utq);
      if (this.ROQ != null) {
        paramVarArgs.f(7, this.ROQ);
      }
      if (this.Utr != null)
      {
        paramVarArgs.oE(8, this.Utr.computeSize());
        this.Utr.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.Uts);
      AppMethodBeat.o(91713);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.Utp) + 0;
      paramInt = i;
      if (this.IbE != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.IbE);
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.text);
      }
      i += g.a.a.b.b.a.gL(4) + 4;
      paramInt = i;
      if (this.RGh != null) {
        paramInt = i + g.a.a.a.oD(5, this.RGh.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.Utq);
      paramInt = i;
      if (this.ROQ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ROQ);
      }
      i = paramInt;
      if (this.Utr != null) {
        i = paramInt + g.a.a.a.oD(8, this.Utr.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(11, this.Uts);
      AppMethodBeat.o(91713);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ere localere = (ere)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 9: 
      case 10: 
      default: 
        AppMethodBeat.o(91713);
        return -1;
      case 1: 
        localere.Utp = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(91713);
        return 0;
      case 2: 
        localere.IbE = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 3: 
        localere.text = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 4: 
        localere.size = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
        AppMethodBeat.o(91713);
        return 0;
      case 5: 
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
          localere.RGh = ((eaa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91713);
        return 0;
      case 6: 
        localere.Utq = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91713);
        return 0;
      case 7: 
        localere.ROQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aim();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aim)localObject2).parseFrom((byte[])localObject1);
          }
          localere.Utr = ((aim)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91713);
        return 0;
      }
      localere.Uts = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(91713);
      return 0;
    }
    AppMethodBeat.o(91713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ere
 * JD-Core Version:    0.7.0.1
 */