package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfh
  extends com.tencent.mm.bw.a
{
  public String EaV;
  public LinkedList<boh> EfT;
  public int FOA;
  public int FOB;
  public String FOC;
  public String FOD;
  public int FOE;
  public int FOv;
  public int FOw;
  public int FOx;
  public int FOy;
  public int FOz;
  public String Fhh;
  public String Title;
  
  public dfh()
  {
    AppMethodBeat.i(152702);
    this.EfT = new LinkedList();
    AppMethodBeat.o(152702);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152703);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fhh != null) {
        paramVarArgs.d(1, this.Fhh);
      }
      paramVarArgs.aR(2, this.FOv);
      paramVarArgs.aR(3, this.FOw);
      paramVarArgs.aR(4, this.FOx);
      paramVarArgs.aR(5, this.FOy);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      paramVarArgs.e(7, 8, this.EfT);
      paramVarArgs.aR(8, this.FOz);
      if (this.EaV != null) {
        paramVarArgs.d(9, this.EaV);
      }
      paramVarArgs.aR(10, this.FOA);
      paramVarArgs.aR(11, this.FOB);
      if (this.FOC != null) {
        paramVarArgs.d(12, this.FOC);
      }
      if (this.FOD != null) {
        paramVarArgs.d(13, this.FOD);
      }
      paramVarArgs.aR(14, this.FOE);
      AppMethodBeat.o(152703);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fhh == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fhh) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FOv) + f.a.a.b.b.a.bx(3, this.FOw) + f.a.a.b.b.a.bx(4, this.FOx) + f.a.a.b.b.a.bx(5, this.FOy);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.EfT) + f.a.a.b.b.a.bx(8, this.FOz);
      paramInt = i;
      if (this.EaV != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EaV);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.FOA) + f.a.a.b.b.a.bx(11, this.FOB);
      paramInt = i;
      if (this.FOC != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FOC);
      }
      i = paramInt;
      if (this.FOD != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FOD);
      }
      paramInt = f.a.a.b.b.a.bx(14, this.FOE);
      AppMethodBeat.o(152703);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EfT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152703);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfh localdfh = (dfh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152703);
          return -1;
        case 1: 
          localdfh.Fhh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 2: 
          localdfh.FOv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152703);
          return 0;
        case 3: 
          localdfh.FOw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152703);
          return 0;
        case 4: 
          localdfh.FOx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152703);
          return 0;
        case 5: 
          localdfh.FOy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152703);
          return 0;
        case 6: 
          localdfh.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new boh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((boh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfh.EfT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152703);
          return 0;
        case 8: 
          localdfh.FOz = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152703);
          return 0;
        case 9: 
          localdfh.EaV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 10: 
          localdfh.FOA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152703);
          return 0;
        case 11: 
          localdfh.FOB = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152703);
          return 0;
        case 12: 
          localdfh.FOC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152703);
          return 0;
        case 13: 
          localdfh.FOD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152703);
          return 0;
        }
        localdfh.FOE = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152703);
        return 0;
      }
      AppMethodBeat.o(152703);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfh
 * JD-Core Version:    0.7.0.1
 */