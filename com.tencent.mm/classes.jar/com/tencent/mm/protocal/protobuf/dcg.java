package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcg
  extends com.tencent.mm.bw.a
{
  public int FLA;
  public int FLB;
  public LinkedList<Integer> FLC;
  public int FLD;
  public LinkedList<Integer> FLE;
  public int FLF;
  public LinkedList<Integer> FLG;
  public String FLH;
  public int FLu;
  public int FLv;
  public int FLw;
  public dqy FLx;
  public int FLy;
  public int FLz;
  
  public dcg()
  {
    AppMethodBeat.i(115851);
    this.FLC = new LinkedList();
    this.FLE = new LinkedList();
    this.FLG = new LinkedList();
    AppMethodBeat.o(115851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115852);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FLx == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.FLu);
      paramVarArgs.aR(2, this.FLv);
      paramVarArgs.aR(3, this.FLw);
      if (this.FLx != null)
      {
        paramVarArgs.ln(4, this.FLx.computeSize());
        this.FLx.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.FLy);
      paramVarArgs.aR(6, this.FLz);
      paramVarArgs.aR(7, this.FLA);
      paramVarArgs.aR(8, this.FLB);
      paramVarArgs.f(9, 2, this.FLC);
      paramVarArgs.aR(10, this.FLD);
      paramVarArgs.f(11, 2, this.FLE);
      paramVarArgs.aR(12, this.FLF);
      paramVarArgs.f(13, 2, this.FLG);
      if (this.FLH != null) {
        paramVarArgs.d(14, this.FLH);
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FLu) + 0 + f.a.a.b.b.a.bx(2, this.FLv) + f.a.a.b.b.a.bx(3, this.FLw);
      paramInt = i;
      if (this.FLx != null) {
        paramInt = i + f.a.a.a.lm(4, this.FLx.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FLy) + f.a.a.b.b.a.bx(6, this.FLz) + f.a.a.b.b.a.bx(7, this.FLA) + f.a.a.b.b.a.bx(8, this.FLB) + f.a.a.a.d(9, 2, this.FLC) + f.a.a.b.b.a.bx(10, this.FLD) + f.a.a.a.d(11, 2, this.FLE) + f.a.a.b.b.a.bx(12, this.FLF) + f.a.a.a.d(13, 2, this.FLG);
      paramInt = i;
      if (this.FLH != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FLH);
      }
      AppMethodBeat.o(115852);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FLC.clear();
      this.FLE.clear();
      this.FLG.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.FLx == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dcg localdcg = (dcg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115852);
        return -1;
      case 1: 
        localdcg.FLu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115852);
        return 0;
      case 2: 
        localdcg.FLv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115852);
        return 0;
      case 3: 
        localdcg.FLw = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115852);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcg.FLx = ((dqy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115852);
        return 0;
      case 5: 
        localdcg.FLy = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115852);
        return 0;
      case 6: 
        localdcg.FLz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115852);
        return 0;
      case 7: 
        localdcg.FLA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115852);
        return 0;
      case 8: 
        localdcg.FLB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115852);
        return 0;
      case 9: 
        localdcg.FLC = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
        AppMethodBeat.o(115852);
        return 0;
      case 10: 
        localdcg.FLD = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115852);
        return 0;
      case 11: 
        localdcg.FLE = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
        AppMethodBeat.o(115852);
        return 0;
      case 12: 
        localdcg.FLF = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115852);
        return 0;
      case 13: 
        localdcg.FLG = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
        AppMethodBeat.o(115852);
        return 0;
      }
      localdcg.FLH = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(115852);
      return 0;
    }
    AppMethodBeat.o(115852);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcg
 * JD-Core Version:    0.7.0.1
 */