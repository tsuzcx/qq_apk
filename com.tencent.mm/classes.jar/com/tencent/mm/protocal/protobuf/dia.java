package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dia
  extends com.tencent.mm.bw.a
{
  public LinkedList<yh> BYq;
  public String BYy;
  public String EDw;
  public LinkedList<dik> FQV;
  public int FQW;
  public String FQX;
  public LinkedList<String> FQY;
  public ape FQZ;
  public int cGY;
  public String cZL;
  public String dlj;
  public String drf;
  public String jKB;
  public int offset;
  public String qox;
  public String rzt;
  public int scene;
  public String sessionId;
  public int tCS;
  public String url;
  public int zZU;
  
  public dia()
  {
    AppMethodBeat.i(152996);
    this.BYq = new LinkedList();
    this.FQV = new LinkedList();
    this.FQY = new LinkedList();
    AppMethodBeat.o(152996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152997);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.jKB != null) {
        paramVarArgs.d(1, this.jKB);
      }
      if (this.sessionId != null) {
        paramVarArgs.d(2, this.sessionId);
      }
      if (this.drf != null) {
        paramVarArgs.d(3, this.drf);
      }
      paramVarArgs.aR(4, this.offset);
      if (this.cZL != null) {
        paramVarArgs.d(5, this.cZL);
      }
      paramVarArgs.aR(6, this.scene);
      if (this.url != null) {
        paramVarArgs.d(7, this.url);
      }
      if (this.dlj != null) {
        paramVarArgs.d(8, this.dlj);
      }
      paramVarArgs.e(9, 8, this.BYq);
      if (this.qox != null) {
        paramVarArgs.d(10, this.qox);
      }
      paramVarArgs.e(11, 8, this.FQV);
      paramVarArgs.aR(12, this.zZU);
      paramVarArgs.aR(13, this.cGY);
      if (this.BYy != null) {
        paramVarArgs.d(14, this.BYy);
      }
      paramVarArgs.aR(15, this.FQW);
      if (this.EDw != null) {
        paramVarArgs.d(16, this.EDw);
      }
      if (this.rzt != null) {
        paramVarArgs.d(17, this.rzt);
      }
      if (this.FQX != null) {
        paramVarArgs.d(18, this.FQX);
      }
      paramVarArgs.e(19, 1, this.FQY);
      paramVarArgs.aR(20, this.tCS);
      if (this.FQZ != null)
      {
        paramVarArgs.ln(21, this.FQZ.computeSize());
        this.FQZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jKB == null) {
        break label1598;
      }
    }
    label1598:
    for (int i = f.a.a.b.b.a.e(1, this.jKB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sessionId);
      }
      i = paramInt;
      if (this.drf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.drf);
      }
      i += f.a.a.b.b.a.bx(4, this.offset);
      paramInt = i;
      if (this.cZL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.cZL);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.url);
      }
      i = paramInt;
      if (this.dlj != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dlj);
      }
      i += f.a.a.a.c(9, 8, this.BYq);
      paramInt = i;
      if (this.qox != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.qox);
      }
      i = paramInt + f.a.a.a.c(11, 8, this.FQV) + f.a.a.b.b.a.bx(12, this.zZU) + f.a.a.b.b.a.bx(13, this.cGY);
      paramInt = i;
      if (this.BYy != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.BYy);
      }
      i = paramInt + f.a.a.b.b.a.bx(15, this.FQW);
      paramInt = i;
      if (this.EDw != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.EDw);
      }
      i = paramInt;
      if (this.rzt != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.rzt);
      }
      paramInt = i;
      if (this.FQX != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FQX);
      }
      i = paramInt + f.a.a.a.c(19, 1, this.FQY) + f.a.a.b.b.a.bx(20, this.tCS);
      paramInt = i;
      if (this.FQZ != null) {
        paramInt = i + f.a.a.a.lm(21, this.FQZ.computeSize());
      }
      AppMethodBeat.o(152997);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.BYq.clear();
        this.FQV.clear();
        this.FQY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dia localdia = (dia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152997);
          return -1;
        case 1: 
          localdia.jKB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 2: 
          localdia.sessionId = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 3: 
          localdia.drf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 4: 
          localdia.offset = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152997);
          return 0;
        case 5: 
          localdia.cZL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 6: 
          localdia.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152997);
          return 0;
        case 7: 
          localdia.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 8: 
          localdia.dlj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdia.BYq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 10: 
          localdia.qox = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dik();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dik)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdia.FQV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 12: 
          localdia.zZU = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152997);
          return 0;
        case 13: 
          localdia.cGY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152997);
          return 0;
        case 14: 
          localdia.BYy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 15: 
          localdia.FQW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152997);
          return 0;
        case 16: 
          localdia.EDw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 17: 
          localdia.rzt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 18: 
          localdia.FQX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 19: 
          localdia.FQY.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(152997);
          return 0;
        case 20: 
          localdia.tCS = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152997);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ape();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ape)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdia.FQZ = ((ape)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      AppMethodBeat.o(152997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dia
 * JD-Core Version:    0.7.0.1
 */