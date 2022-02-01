package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uf
  extends com.tencent.mm.cd.a
{
  public String SeA;
  public String SeB;
  public String SeC;
  public String SeD;
  public LinkedList<ud> SeE;
  public LinkedList<uc> SeF;
  public String SeG;
  public String SeH;
  public up SeI;
  public ud SeJ;
  public int SeK;
  public int SeL;
  public int SeM;
  public long SeN;
  public int Sep;
  public String Seq;
  public up Ser;
  public String Ses;
  
  public uf()
  {
    AppMethodBeat.i(113954);
    this.SeE = new LinkedList();
    this.SeF = new LinkedList();
    AppMethodBeat.o(113954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113955);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SeA != null) {
        paramVarArgs.f(1, this.SeA);
      }
      if (this.SeB != null) {
        paramVarArgs.f(2, this.SeB);
      }
      if (this.SeC != null) {
        paramVarArgs.f(3, this.SeC);
      }
      if (this.SeD != null) {
        paramVarArgs.f(4, this.SeD);
      }
      paramVarArgs.e(5, 8, this.SeE);
      paramVarArgs.aY(6, this.Sep);
      if (this.Seq != null) {
        paramVarArgs.f(7, this.Seq);
      }
      if (this.Ser != null)
      {
        paramVarArgs.oE(8, this.Ser.computeSize());
        this.Ser.writeFields(paramVarArgs);
      }
      if (this.Ses != null) {
        paramVarArgs.f(9, this.Ses);
      }
      paramVarArgs.e(10, 8, this.SeF);
      if (this.SeG != null) {
        paramVarArgs.f(11, this.SeG);
      }
      if (this.SeH != null) {
        paramVarArgs.f(12, this.SeH);
      }
      if (this.SeI != null)
      {
        paramVarArgs.oE(13, this.SeI.computeSize());
        this.SeI.writeFields(paramVarArgs);
      }
      if (this.SeJ != null)
      {
        paramVarArgs.oE(14, this.SeJ.computeSize());
        this.SeJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(15, this.SeK);
      paramVarArgs.aY(16, this.SeL);
      paramVarArgs.aY(17, this.SeM);
      paramVarArgs.bm(18, this.SeN);
      AppMethodBeat.o(113955);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SeA == null) {
        break label1520;
      }
    }
    label1520:
    for (int i = g.a.a.b.b.a.g(1, this.SeA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SeB != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SeB);
      }
      i = paramInt;
      if (this.SeC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SeC);
      }
      paramInt = i;
      if (this.SeD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SeD);
      }
      i = paramInt + g.a.a.a.c(5, 8, this.SeE) + g.a.a.b.b.a.bM(6, this.Sep);
      paramInt = i;
      if (this.Seq != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Seq);
      }
      i = paramInt;
      if (this.Ser != null) {
        i = paramInt + g.a.a.a.oD(8, this.Ser.computeSize());
      }
      paramInt = i;
      if (this.Ses != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.Ses);
      }
      i = paramInt + g.a.a.a.c(10, 8, this.SeF);
      paramInt = i;
      if (this.SeG != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.SeG);
      }
      i = paramInt;
      if (this.SeH != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.SeH);
      }
      paramInt = i;
      if (this.SeI != null) {
        paramInt = i + g.a.a.a.oD(13, this.SeI.computeSize());
      }
      i = paramInt;
      if (this.SeJ != null) {
        i = paramInt + g.a.a.a.oD(14, this.SeJ.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(15, this.SeK);
      int j = g.a.a.b.b.a.bM(16, this.SeL);
      int k = g.a.a.b.b.a.bM(17, this.SeM);
      int m = g.a.a.b.b.a.p(18, this.SeN);
      AppMethodBeat.o(113955);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SeE.clear();
        this.SeF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113955);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        uf localuf = (uf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113955);
          return -1;
        case 1: 
          localuf.SeA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 2: 
          localuf.SeB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 3: 
          localuf.SeC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 4: 
          localuf.SeD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ud();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ud)localObject2).parseFrom((byte[])localObject1);
            }
            localuf.SeE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 6: 
          localuf.Sep = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(113955);
          return 0;
        case 7: 
          localuf.Seq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new up();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((up)localObject2).parseFrom((byte[])localObject1);
            }
            localuf.Ser = ((up)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 9: 
          localuf.Ses = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uc)localObject2).parseFrom((byte[])localObject1);
            }
            localuf.SeF.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 11: 
          localuf.SeG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 12: 
          localuf.SeH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(113955);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new up();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((up)localObject2).parseFrom((byte[])localObject1);
            }
            localuf.SeI = ((up)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ud();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ud)localObject2).parseFrom((byte[])localObject1);
            }
            localuf.SeJ = ((ud)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113955);
          return 0;
        case 15: 
          localuf.SeK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(113955);
          return 0;
        case 16: 
          localuf.SeL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(113955);
          return 0;
        case 17: 
          localuf.SeM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(113955);
          return 0;
        }
        localuf.SeN = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(113955);
        return 0;
      }
      AppMethodBeat.o(113955);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uf
 * JD-Core Version:    0.7.0.1
 */