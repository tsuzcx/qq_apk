package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ali
  extends cpx
{
  public b EEJ;
  public aiu EEZ;
  public long EFa;
  public dir EFb;
  public int diw;
  public float dmL;
  public float doB;
  public String dol;
  public int exY;
  public anu qYj;
  public int rPI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168990);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EEZ != null)
      {
        paramVarArgs.ln(2, this.EEZ.computeSize());
        this.EEZ.writeFields(paramVarArgs);
      }
      if (this.EEJ != null) {
        paramVarArgs.c(3, this.EEJ);
      }
      paramVarArgs.aR(4, this.rPI);
      if (this.dol != null) {
        paramVarArgs.d(5, this.dol);
      }
      paramVarArgs.x(6, this.doB);
      paramVarArgs.x(7, this.dmL);
      paramVarArgs.aO(8, this.EFa);
      paramVarArgs.aR(9, this.diw);
      if (this.EFb != null)
      {
        paramVarArgs.ln(10, this.EFb.computeSize());
        this.EFb.writeFields(paramVarArgs);
      }
      if (this.qYj != null)
      {
        paramVarArgs.ln(11, this.qYj.computeSize());
        this.qYj.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.exY);
      AppMethodBeat.o(168990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1168;
      }
    }
    label1168:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EEZ != null) {
        paramInt = i + f.a.a.a.lm(2, this.EEZ.computeSize());
      }
      i = paramInt;
      if (this.EEJ != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.EEJ);
      }
      i += f.a.a.b.b.a.bx(4, this.rPI);
      paramInt = i;
      if (this.dol != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dol);
      }
      i = paramInt + (f.a.a.b.b.a.fK(6) + 4) + (f.a.a.b.b.a.fK(7) + 4) + f.a.a.b.b.a.p(8, this.EFa) + f.a.a.b.b.a.bx(9, this.diw);
      paramInt = i;
      if (this.EFb != null) {
        paramInt = i + f.a.a.a.lm(10, this.EFb.computeSize());
      }
      i = paramInt;
      if (this.qYj != null) {
        i = paramInt + f.a.a.a.lm(11, this.qYj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(12, this.exY);
      AppMethodBeat.o(168990);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(168990);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ali localali = (ali)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168990);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localali.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localali.EEZ = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 3: 
          localali.EEJ = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(168990);
          return 0;
        case 4: 
          localali.rPI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168990);
          return 0;
        case 5: 
          localali.dol = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(168990);
          return 0;
        case 6: 
          localali.doB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(168990);
          return 0;
        case 7: 
          localali.dmL = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(168990);
          return 0;
        case 8: 
          localali.EFa = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(168990);
          return 0;
        case 9: 
          localali.diw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(168990);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dir();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dir)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localali.EFb = ((dir)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localali.qYj = ((anu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168990);
          return 0;
        }
        localali.exY = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(168990);
        return 0;
      }
      AppMethodBeat.o(168990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ali
 * JD-Core Version:    0.7.0.1
 */