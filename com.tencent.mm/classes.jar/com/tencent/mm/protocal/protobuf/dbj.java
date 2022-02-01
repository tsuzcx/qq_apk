package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbj
  extends com.tencent.mm.cd.a
{
  public String GWV;
  public dbh TIH;
  public String TII;
  public String TIJ;
  public int TIK;
  public long TIL;
  public String TIM;
  public String TIm;
  public int createtime;
  public long fxU;
  public String jDI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(228636);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TIH != null)
      {
        paramVarArgs.oE(2, this.TIH.computeSize());
        this.TIH.writeFields(paramVarArgs);
      }
      if (this.TII != null) {
        paramVarArgs.f(3, this.TII);
      }
      if (this.TIJ != null) {
        paramVarArgs.f(4, this.TIJ);
      }
      paramVarArgs.bm(5, this.fxU);
      if (this.GWV != null) {
        paramVarArgs.f(6, this.GWV);
      }
      if (this.TIm != null) {
        paramVarArgs.f(7, this.TIm);
      }
      paramVarArgs.aY(9, this.createtime);
      paramVarArgs.aY(13, this.TIK);
      paramVarArgs.bm(14, this.TIL);
      if (this.jDI != null) {
        paramVarArgs.f(15, this.jDI);
      }
      if (this.TIM != null) {
        paramVarArgs.f(16, this.TIM);
      }
      AppMethodBeat.o(228636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TIH == null) {
        break label852;
      }
    }
    label852:
    for (int i = g.a.a.a.oD(2, this.TIH.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TII != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TII);
      }
      i = paramInt;
      if (this.TIJ != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TIJ);
      }
      i += g.a.a.b.b.a.p(5, this.fxU);
      paramInt = i;
      if (this.GWV != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.GWV);
      }
      i = paramInt;
      if (this.TIm != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TIm);
      }
      i = i + g.a.a.b.b.a.bM(9, this.createtime) + g.a.a.b.b.a.bM(13, this.TIK) + g.a.a.b.b.a.p(14, this.TIL);
      paramInt = i;
      if (this.jDI != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.jDI);
      }
      i = paramInt;
      if (this.TIM != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.TIM);
      }
      AppMethodBeat.o(228636);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(228636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dbj localdbj = (dbj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        default: 
          AppMethodBeat.o(228636);
          return -1;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dbh localdbh = new dbh();
            if ((localObject != null) && (localObject.length > 0)) {
              localdbh.parseFrom((byte[])localObject);
            }
            localdbj.TIH = localdbh;
            paramInt += 1;
          }
          AppMethodBeat.o(228636);
          return 0;
        case 3: 
          localdbj.TII = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(228636);
          return 0;
        case 4: 
          localdbj.TIJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(228636);
          return 0;
        case 5: 
          localdbj.fxU = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(228636);
          return 0;
        case 6: 
          localdbj.GWV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(228636);
          return 0;
        case 7: 
          localdbj.TIm = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(228636);
          return 0;
        case 9: 
          localdbj.createtime = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(228636);
          return 0;
        case 13: 
          localdbj.TIK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(228636);
          return 0;
        case 14: 
          localdbj.TIL = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(228636);
          return 0;
        case 15: 
          localdbj.jDI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(228636);
          return 0;
        }
        localdbj.TIM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(228636);
        return 0;
      }
      AppMethodBeat.o(228636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbj
 * JD-Core Version:    0.7.0.1
 */