package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fzy
  extends esc
{
  public int JHe;
  public int JHk;
  public int JHl;
  public int JHp;
  public LinkedList<fzs> YKL;
  public long ZvA;
  public int abIU;
  public long abKe;
  public int abXF;
  public int abXG;
  public int abXH;
  public LinkedList<fzs> abXI;
  public com.tencent.mm.bx.b abne;
  
  public fzy()
  {
    AppMethodBeat.i(125499);
    this.YKL = new LinkedList();
    this.abXI = new LinkedList();
    AppMethodBeat.o(125499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125500);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125500);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.abKe);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.e(4, 8, this.YKL);
      paramVarArgs.bS(5, this.abIU);
      paramVarArgs.bS(6, this.JHk);
      paramVarArgs.bS(7, this.JHl);
      paramVarArgs.bS(8, this.JHe);
      paramVarArgs.bS(9, this.JHp);
      paramVarArgs.bS(10, this.abXF);
      paramVarArgs.bS(11, this.abXG);
      if (this.abne != null) {
        paramVarArgs.d(12, this.abne);
      }
      paramVarArgs.bS(13, this.abXH);
      paramVarArgs.e(14, 8, this.abXI);
      AppMethodBeat.o(125500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1072;
      }
    }
    label1072:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.abKe) + i.a.a.b.b.a.q(3, this.ZvA) + i.a.a.a.c(4, 8, this.YKL) + i.a.a.b.b.a.cJ(5, this.abIU) + i.a.a.b.b.a.cJ(6, this.JHk) + i.a.a.b.b.a.cJ(7, this.JHl) + i.a.a.b.b.a.cJ(8, this.JHe) + i.a.a.b.b.a.cJ(9, this.JHp) + i.a.a.b.b.a.cJ(10, this.abXF) + i.a.a.b.b.a.cJ(11, this.abXG);
      paramInt = i;
      if (this.abne != null) {
        paramInt = i + i.a.a.b.b.a.c(12, this.abne);
      }
      i = i.a.a.b.b.a.cJ(13, this.abXH);
      int j = i.a.a.a.c(14, 8, this.abXI);
      AppMethodBeat.o(125500);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YKL.clear();
        this.abXI.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125500);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fzy localfzy = (fzy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125500);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfzy.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 2: 
          localfzy.abKe = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125500);
          return 0;
        case 3: 
          localfzy.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125500);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzs)localObject2).parseFrom((byte[])localObject1);
            }
            localfzy.YKL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125500);
          return 0;
        case 5: 
          localfzy.abIU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125500);
          return 0;
        case 6: 
          localfzy.JHk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125500);
          return 0;
        case 7: 
          localfzy.JHl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125500);
          return 0;
        case 8: 
          localfzy.JHe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125500);
          return 0;
        case 9: 
          localfzy.JHp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125500);
          return 0;
        case 10: 
          localfzy.abXF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125500);
          return 0;
        case 11: 
          localfzy.abXG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125500);
          return 0;
        case 12: 
          localfzy.abne = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(125500);
          return 0;
        case 13: 
          localfzy.abXH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125500);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fzs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fzs)localObject2).parseFrom((byte[])localObject1);
          }
          localfzy.abXI.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125500);
        return 0;
      }
      AppMethodBeat.o(125500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzy
 * JD-Core Version:    0.7.0.1
 */