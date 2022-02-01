package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjz
  extends com.tencent.mm.cd.a
{
  public int ChC;
  public int Oxu;
  public String SkU;
  public long SqZ;
  public String TfK;
  public int TrA;
  public int TrB;
  public String TrC;
  public String Try;
  public dkt Trz;
  public int state;
  public int tnN;
  public String tpo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72505);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TfK != null) {
        paramVarArgs.f(1, this.TfK);
      }
      if (this.SkU != null) {
        paramVarArgs.f(2, this.SkU);
      }
      paramVarArgs.bm(3, this.SqZ);
      paramVarArgs.aY(4, this.state);
      if (this.Try != null) {
        paramVarArgs.f(5, this.Try);
      }
      paramVarArgs.aY(6, this.Oxu);
      if (this.Trz != null)
      {
        paramVarArgs.oE(7, this.Trz.computeSize());
        this.Trz.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.ChC);
      paramVarArgs.aY(9, this.tnN);
      paramVarArgs.aY(10, this.TrA);
      paramVarArgs.aY(11, this.TrB);
      if (this.TrC != null) {
        paramVarArgs.f(12, this.TrC);
      }
      if (this.tpo != null) {
        paramVarArgs.f(13, this.tpo);
      }
      AppMethodBeat.o(72505);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TfK == null) {
        break label904;
      }
    }
    label904:
    for (paramInt = g.a.a.b.b.a.g(1, this.TfK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SkU != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SkU);
      }
      i = i + g.a.a.b.b.a.p(3, this.SqZ) + g.a.a.b.b.a.bM(4, this.state);
      paramInt = i;
      if (this.Try != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Try);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.Oxu);
      paramInt = i;
      if (this.Trz != null) {
        paramInt = i + g.a.a.a.oD(7, this.Trz.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.ChC) + g.a.a.b.b.a.bM(9, this.tnN) + g.a.a.b.b.a.bM(10, this.TrA) + g.a.a.b.b.a.bM(11, this.TrB);
      paramInt = i;
      if (this.TrC != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.TrC);
      }
      i = paramInt;
      if (this.tpo != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.tpo);
      }
      AppMethodBeat.o(72505);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72505);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cjz localcjz = (cjz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72505);
          return -1;
        case 1: 
          localcjz.TfK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 2: 
          localcjz.SkU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 3: 
          localcjz.SqZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(72505);
          return 0;
        case 4: 
          localcjz.state = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72505);
          return 0;
        case 5: 
          localcjz.Try = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72505);
          return 0;
        case 6: 
          localcjz.Oxu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72505);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dkt localdkt = new dkt();
            if ((localObject != null) && (localObject.length > 0)) {
              localdkt.parseFrom((byte[])localObject);
            }
            localcjz.Trz = localdkt;
            paramInt += 1;
          }
          AppMethodBeat.o(72505);
          return 0;
        case 8: 
          localcjz.ChC = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72505);
          return 0;
        case 9: 
          localcjz.tnN = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72505);
          return 0;
        case 10: 
          localcjz.TrA = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72505);
          return 0;
        case 11: 
          localcjz.TrB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72505);
          return 0;
        case 12: 
          localcjz.TrC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72505);
          return 0;
        }
        localcjz.tpo = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72505);
        return 0;
      }
      AppMethodBeat.o(72505);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjz
 * JD-Core Version:    0.7.0.1
 */