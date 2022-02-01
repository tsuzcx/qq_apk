package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cep
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int Ftl;
  public String tkL;
  public String vxU;
  public String vxW;
  public String vxX;
  public int vxY;
  public String vxZ;
  public int vya;
  public int vyb;
  public String vyc;
  public String vyd;
  public String vye;
  public String vyf;
  public String vyg;
  public int vyh;
  public LinkedList<cza> vyi;
  
  public cep()
  {
    AppMethodBeat.i(91596);
    this.vyi = new LinkedList();
    AppMethodBeat.o(91596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91597);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vxU != null) {
        paramVarArgs.d(1, this.vxU);
      }
      paramVarArgs.aR(2, this.Ftl);
      if (this.vxW != null) {
        paramVarArgs.d(3, this.vxW);
      }
      paramVarArgs.aR(4, this.CreateTime);
      if (this.vxX != null) {
        paramVarArgs.d(5, this.vxX);
      }
      paramVarArgs.aR(6, this.vxY);
      if (this.vxZ != null) {
        paramVarArgs.d(7, this.vxZ);
      }
      paramVarArgs.aR(8, this.vya);
      paramVarArgs.aR(9, this.vyb);
      if (this.vyc != null) {
        paramVarArgs.d(10, this.vyc);
      }
      if (this.tkL != null) {
        paramVarArgs.d(11, this.tkL);
      }
      if (this.vyd != null) {
        paramVarArgs.d(12, this.vyd);
      }
      if (this.vye != null) {
        paramVarArgs.d(13, this.vye);
      }
      if (this.vyf != null) {
        paramVarArgs.d(14, this.vyf);
      }
      if (this.vyg != null) {
        paramVarArgs.d(15, this.vyg);
      }
      paramVarArgs.aR(16, this.vyh);
      paramVarArgs.e(17, 8, this.vyi);
      AppMethodBeat.o(91597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vxU == null) {
        break label1186;
      }
    }
    label1186:
    for (paramInt = f.a.a.b.b.a.e(1, this.vxU) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Ftl);
      paramInt = i;
      if (this.vxW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vxW);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.CreateTime);
      paramInt = i;
      if (this.vxX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vxX);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.vxY);
      paramInt = i;
      if (this.vxZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vxZ);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.vya) + f.a.a.b.b.a.bx(9, this.vyb);
      paramInt = i;
      if (this.vyc != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.vyc);
      }
      i = paramInt;
      if (this.tkL != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.tkL);
      }
      paramInt = i;
      if (this.vyd != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.vyd);
      }
      i = paramInt;
      if (this.vye != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.vye);
      }
      paramInt = i;
      if (this.vyf != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.vyf);
      }
      i = paramInt;
      if (this.vyg != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.vyg);
      }
      paramInt = f.a.a.b.b.a.bx(16, this.vyh);
      int j = f.a.a.a.c(17, 8, this.vyi);
      AppMethodBeat.o(91597);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.vyi.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cep localcep = (cep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91597);
          return -1;
        case 1: 
          localcep.vxU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 2: 
          localcep.Ftl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91597);
          return 0;
        case 3: 
          localcep.vxW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 4: 
          localcep.CreateTime = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91597);
          return 0;
        case 5: 
          localcep.vxX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 6: 
          localcep.vxY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91597);
          return 0;
        case 7: 
          localcep.vxZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 8: 
          localcep.vya = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91597);
          return 0;
        case 9: 
          localcep.vyb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91597);
          return 0;
        case 10: 
          localcep.vyc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 11: 
          localcep.tkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 12: 
          localcep.vyd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 13: 
          localcep.vye = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 14: 
          localcep.vyf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 15: 
          localcep.vyg = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91597);
          return 0;
        case 16: 
          localcep.vyh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91597);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cza();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cza)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcep.vyi.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91597);
        return 0;
      }
      AppMethodBeat.o(91597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cep
 * JD-Core Version:    0.7.0.1
 */