package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ta
  extends com.tencent.mm.bw.a
{
  public String FKu;
  public String GiA;
  public ti GiB;
  public String GiC;
  public String Gio;
  public int Giz;
  public String Gjb;
  public String dJb;
  public int mwj;
  public String oFG;
  public String pqW;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218606);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dJb != null) {
        paramVarArgs.d(1, this.dJb);
      }
      if (this.FKu != null) {
        paramVarArgs.d(2, this.FKu);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.oFG != null) {
        paramVarArgs.d(4, this.oFG);
      }
      if (this.Gjb != null) {
        paramVarArgs.d(5, this.Gjb);
      }
      if (this.Gio != null) {
        paramVarArgs.d(6, this.Gio);
      }
      paramVarArgs.aS(7, this.mwj);
      if (this.pqW != null) {
        paramVarArgs.d(8, this.pqW);
      }
      paramVarArgs.aS(9, this.Giz);
      if (this.GiA != null) {
        paramVarArgs.d(10, this.GiA);
      }
      if (this.GiB != null)
      {
        paramVarArgs.lJ(11, this.GiB.computeSize());
        this.GiB.writeFields(paramVarArgs);
      }
      if (this.GiC != null) {
        paramVarArgs.d(12, this.GiC);
      }
      AppMethodBeat.o(218606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dJb == null) {
        break label954;
      }
    }
    label954:
    for (int i = f.a.a.b.b.a.e(1, this.dJb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FKu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FKu);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.oFG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oFG);
      }
      i = paramInt;
      if (this.Gjb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gjb);
      }
      paramInt = i;
      if (this.Gio != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gio);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.mwj);
      paramInt = i;
      if (this.pqW != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.pqW);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.Giz);
      paramInt = i;
      if (this.GiA != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GiA);
      }
      i = paramInt;
      if (this.GiB != null) {
        i = paramInt + f.a.a.a.lI(11, this.GiB.computeSize());
      }
      paramInt = i;
      if (this.GiC != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GiC);
      }
      AppMethodBeat.o(218606);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ta localta = (ta)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218606);
          return -1;
        case 1: 
          localta.dJb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218606);
          return 0;
        case 2: 
          localta.FKu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218606);
          return 0;
        case 3: 
          localta.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218606);
          return 0;
        case 4: 
          localta.oFG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218606);
          return 0;
        case 5: 
          localta.Gjb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218606);
          return 0;
        case 6: 
          localta.Gio = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218606);
          return 0;
        case 7: 
          localta.mwj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218606);
          return 0;
        case 8: 
          localta.pqW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218606);
          return 0;
        case 9: 
          localta.Giz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218606);
          return 0;
        case 10: 
          localta.GiA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218606);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ti();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localta.GiB = ((ti)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218606);
          return 0;
        }
        localta.GiC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(218606);
        return 0;
      }
      AppMethodBeat.o(218606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ta
 * JD-Core Version:    0.7.0.1
 */