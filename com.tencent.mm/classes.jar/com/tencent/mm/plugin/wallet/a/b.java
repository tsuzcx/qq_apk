package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public String BgA;
  public String BgB;
  public m Bgt;
  public int Bgu;
  public String Bgv;
  public String Bgw;
  public String Bgx;
  public String Bgy;
  public String Bgz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91285);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Bgt != null)
      {
        paramVarArgs.ln(1, this.Bgt.computeSize());
        this.Bgt.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Bgu);
      if (this.Bgv != null) {
        paramVarArgs.d(3, this.Bgv);
      }
      if (this.Bgw != null) {
        paramVarArgs.d(4, this.Bgw);
      }
      if (this.Bgx != null) {
        paramVarArgs.d(5, this.Bgx);
      }
      if (this.Bgy != null) {
        paramVarArgs.d(6, this.Bgy);
      }
      if (this.Bgz != null) {
        paramVarArgs.d(7, this.Bgz);
      }
      if (this.BgA != null) {
        paramVarArgs.d(8, this.BgA);
      }
      if (this.BgB != null) {
        paramVarArgs.d(9, this.BgB);
      }
      AppMethodBeat.o(91285);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Bgt == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lm(1, this.Bgt.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Bgu);
      paramInt = i;
      if (this.Bgv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Bgv);
      }
      i = paramInt;
      if (this.Bgw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Bgw);
      }
      paramInt = i;
      if (this.Bgx != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Bgx);
      }
      i = paramInt;
      if (this.Bgy != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Bgy);
      }
      paramInt = i;
      if (this.Bgz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Bgz);
      }
      i = paramInt;
      if (this.BgA != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.BgA);
      }
      paramInt = i;
      if (this.BgB != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.BgB);
      }
      AppMethodBeat.o(91285);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91285);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91285);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.Bgt = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91285);
          return 0;
        case 2: 
          localb.Bgu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91285);
          return 0;
        case 3: 
          localb.Bgv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 4: 
          localb.Bgw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 5: 
          localb.Bgx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 6: 
          localb.Bgy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 7: 
          localb.Bgz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 8: 
          localb.BgA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91285);
          return 0;
        }
        localb.BgB = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91285);
        return 0;
      }
      AppMethodBeat.o(91285);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.b
 * JD-Core Version:    0.7.0.1
 */