package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dug
  extends com.tencent.mm.cd.a
{
  public int RVf;
  public String RVi;
  public LinkedList<String> RXF;
  public String RXO;
  public int SvY;
  public String SwH;
  public String SwI;
  public LinkedList<dur> UaA;
  public int UaB;
  public String UaC;
  public duu UaD;
  public LinkedList<String> UaE;
  public String UaF;
  public int UaG;
  
  public dug()
  {
    AppMethodBeat.i(206114);
    this.UaA = new LinkedList();
    this.RXF = new LinkedList();
    this.UaE = new LinkedList();
    AppMethodBeat.o(206114);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206115);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RXO != null) {
        paramVarArgs.f(1, this.RXO);
      }
      paramVarArgs.e(2, 8, this.UaA);
      paramVarArgs.aY(3, this.RVf);
      paramVarArgs.aY(4, this.UaB);
      if (this.RVi != null) {
        paramVarArgs.f(5, this.RVi);
      }
      paramVarArgs.e(6, 1, this.RXF);
      if (this.SwI != null) {
        paramVarArgs.f(7, this.SwI);
      }
      if (this.SwH != null) {
        paramVarArgs.f(8, this.SwH);
      }
      if (this.UaC != null) {
        paramVarArgs.f(9, this.UaC);
      }
      if (this.UaD != null)
      {
        paramVarArgs.oE(10, this.UaD.computeSize());
        this.UaD.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.SvY);
      paramVarArgs.e(12, 1, this.UaE);
      if (this.UaF != null) {
        paramVarArgs.f(13, this.UaF);
      }
      paramVarArgs.aY(14, this.UaG);
      AppMethodBeat.o(206115);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RXO == null) {
        break label1070;
      }
    }
    label1070:
    for (paramInt = g.a.a.b.b.a.g(1, this.RXO) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.UaA) + g.a.a.b.b.a.bM(3, this.RVf) + g.a.a.b.b.a.bM(4, this.UaB);
      paramInt = i;
      if (this.RVi != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RVi);
      }
      i = paramInt + g.a.a.a.c(6, 1, this.RXF);
      paramInt = i;
      if (this.SwI != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SwI);
      }
      i = paramInt;
      if (this.SwH != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.SwH);
      }
      paramInt = i;
      if (this.UaC != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.UaC);
      }
      i = paramInt;
      if (this.UaD != null) {
        i = paramInt + g.a.a.a.oD(10, this.UaD.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(11, this.SvY) + g.a.a.a.c(12, 1, this.UaE);
      paramInt = i;
      if (this.UaF != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.UaF);
      }
      i = g.a.a.b.b.a.bM(14, this.UaG);
      AppMethodBeat.o(206115);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UaA.clear();
        this.RXF.clear();
        this.UaE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206115);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dug localdug = (dug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206115);
          return -1;
        case 1: 
          localdug.RXO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206115);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dur)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.UaA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206115);
          return 0;
        case 3: 
          localdug.RVf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206115);
          return 0;
        case 4: 
          localdug.UaB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206115);
          return 0;
        case 5: 
          localdug.RVi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206115);
          return 0;
        case 6: 
          localdug.RXF.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(206115);
          return 0;
        case 7: 
          localdug.SwI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206115);
          return 0;
        case 8: 
          localdug.SwH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206115);
          return 0;
        case 9: 
          localdug.UaC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206115);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new duu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((duu)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.UaD = ((duu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206115);
          return 0;
        case 11: 
          localdug.SvY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206115);
          return 0;
        case 12: 
          localdug.UaE.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(206115);
          return 0;
        case 13: 
          localdug.UaF = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206115);
          return 0;
        }
        localdug.UaG = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(206115);
        return 0;
      }
      AppMethodBeat.o(206115);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dug
 * JD-Core Version:    0.7.0.1
 */