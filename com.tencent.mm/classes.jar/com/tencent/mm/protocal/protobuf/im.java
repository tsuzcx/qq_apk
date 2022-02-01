package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class im
  extends com.tencent.mm.bw.a
{
  public LinkedList<aem> DWo;
  public String DWp;
  public String DWq;
  public String cZz;
  public String tGS;
  public String wEA;
  public String wEB;
  public long wEE;
  public String wEw;
  public int wEx;
  public int wEy;
  public String wEz;
  
  public im()
  {
    AppMethodBeat.i(72420);
    this.DWo = new LinkedList();
    AppMethodBeat.o(72420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72421);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.cZz != null) {
        paramVarArgs.d(1, this.cZz);
      }
      if (this.tGS != null) {
        paramVarArgs.d(2, this.tGS);
      }
      if (this.wEw != null) {
        paramVarArgs.d(3, this.wEw);
      }
      paramVarArgs.aR(4, this.wEx);
      paramVarArgs.aR(5, this.wEy);
      paramVarArgs.e(6, 8, this.DWo);
      if (this.wEz != null) {
        paramVarArgs.d(7, this.wEz);
      }
      if (this.wEA != null) {
        paramVarArgs.d(8, this.wEA);
      }
      if (this.wEB != null) {
        paramVarArgs.d(9, this.wEB);
      }
      if (this.DWp != null) {
        paramVarArgs.d(10, this.DWp);
      }
      if (this.DWq != null) {
        paramVarArgs.d(11, this.DWq);
      }
      paramVarArgs.aO(12, this.wEE);
      AppMethodBeat.o(72421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cZz == null) {
        break label918;
      }
    }
    label918:
    for (int i = f.a.a.b.b.a.e(1, this.cZz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tGS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tGS);
      }
      i = paramInt;
      if (this.wEw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wEw);
      }
      i = i + f.a.a.b.b.a.bx(4, this.wEx) + f.a.a.b.b.a.bx(5, this.wEy) + f.a.a.a.c(6, 8, this.DWo);
      paramInt = i;
      if (this.wEz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.wEz);
      }
      i = paramInt;
      if (this.wEA != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.wEA);
      }
      paramInt = i;
      if (this.wEB != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.wEB);
      }
      i = paramInt;
      if (this.DWp != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.DWp);
      }
      paramInt = i;
      if (this.DWq != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DWq);
      }
      i = f.a.a.b.b.a.p(12, this.wEE);
      AppMethodBeat.o(72421);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DWo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        im localim = (im)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72421);
          return -1;
        case 1: 
          localim.cZz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 2: 
          localim.tGS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 3: 
          localim.wEw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 4: 
          localim.wEx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72421);
          return 0;
        case 5: 
          localim.wEy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72421);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aem();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aem)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localim.DWo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72421);
          return 0;
        case 7: 
          localim.wEz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 8: 
          localim.wEA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 9: 
          localim.wEB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 10: 
          localim.DWp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 11: 
          localim.DWq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72421);
          return 0;
        }
        localim.wEE = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(72421);
        return 0;
      }
      AppMethodBeat.o(72421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.im
 * JD-Core Version:    0.7.0.1
 */