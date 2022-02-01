package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmb
  extends com.tencent.mm.bw.a
{
  public aac Fzq;
  public boolean Fzr;
  public boolean Fzs;
  public boolean Fzt;
  public boolean Fzu;
  public boolean Fzv;
  public boolean Fzw;
  public boolean Fzx;
  public boolean Fzy;
  public boolean Fzz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fzq != null)
      {
        paramVarArgs.ln(1, this.Fzq.computeSize());
        this.Fzq.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(2, this.Fzr);
      paramVarArgs.bl(3, this.Fzs);
      paramVarArgs.bl(4, this.Fzt);
      paramVarArgs.bl(5, this.Fzu);
      paramVarArgs.bl(6, this.Fzv);
      paramVarArgs.bl(7, this.Fzw);
      paramVarArgs.bl(8, this.Fzx);
      paramVarArgs.bl(9, this.Fzy);
      paramVarArgs.bl(10, this.Fzz);
      AppMethodBeat.o(91659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fzq == null) {
        break label714;
      }
    }
    label714:
    for (paramInt = f.a.a.a.lm(1, this.Fzq.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      int n = f.a.a.b.b.a.fK(6);
      int i1 = f.a.a.b.b.a.fK(7);
      int i2 = f.a.a.b.b.a.fK(8);
      int i3 = f.a.a.b.b.a.fK(9);
      int i4 = f.a.a.b.b.a.fK(10);
      AppMethodBeat.o(91659);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1) + (i3 + 1) + (i4 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cmb localcmb = (cmb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91659);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aac();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aac)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcmb.Fzq = ((aac)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91659);
          return 0;
        case 2: 
          localcmb.Fzr = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91659);
          return 0;
        case 3: 
          localcmb.Fzs = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91659);
          return 0;
        case 4: 
          localcmb.Fzt = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91659);
          return 0;
        case 5: 
          localcmb.Fzu = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91659);
          return 0;
        case 6: 
          localcmb.Fzv = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91659);
          return 0;
        case 7: 
          localcmb.Fzw = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91659);
          return 0;
        case 8: 
          localcmb.Fzx = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91659);
          return 0;
        case 9: 
          localcmb.Fzy = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91659);
          return 0;
        }
        localcmb.Fzz = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(91659);
        return 0;
      }
      AppMethodBeat.o(91659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmb
 * JD-Core Version:    0.7.0.1
 */