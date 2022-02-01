package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dur
  extends com.tencent.mm.cd.a
{
  public String RXK;
  public int SvY;
  public String SwH;
  public String SwI;
  public int UaB;
  public String UaC;
  public duu UaD;
  public String UaF;
  public mh UaW;
  public cmo UaX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206224);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UaW != null)
      {
        paramVarArgs.oE(1, this.UaW.computeSize());
        this.UaW.writeFields(paramVarArgs);
      }
      if (this.UaX != null)
      {
        paramVarArgs.oE(2, this.UaX.computeSize());
        this.UaX.writeFields(paramVarArgs);
      }
      if (this.RXK != null) {
        paramVarArgs.f(3, this.RXK);
      }
      if (this.SwI != null) {
        paramVarArgs.f(4, this.SwI);
      }
      if (this.SwH != null) {
        paramVarArgs.f(5, this.SwH);
      }
      if (this.UaC != null) {
        paramVarArgs.f(6, this.UaC);
      }
      paramVarArgs.aY(7, this.UaB);
      if (this.UaD != null)
      {
        paramVarArgs.oE(8, this.UaD.computeSize());
        this.UaD.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.SvY);
      if (this.UaF != null) {
        paramVarArgs.f(10, this.UaF);
      }
      AppMethodBeat.o(206224);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UaW == null) {
        break label952;
      }
    }
    label952:
    for (int i = g.a.a.a.oD(1, this.UaW.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UaX != null) {
        paramInt = i + g.a.a.a.oD(2, this.UaX.computeSize());
      }
      i = paramInt;
      if (this.RXK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RXK);
      }
      paramInt = i;
      if (this.SwI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SwI);
      }
      i = paramInt;
      if (this.SwH != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SwH);
      }
      paramInt = i;
      if (this.UaC != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.UaC);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.UaB);
      paramInt = i;
      if (this.UaD != null) {
        paramInt = i + g.a.a.a.oD(8, this.UaD.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.SvY);
      paramInt = i;
      if (this.UaF != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.UaF);
      }
      AppMethodBeat.o(206224);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(206224);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dur localdur = (dur)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(206224);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new mh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((mh)localObject2).parseFrom((byte[])localObject1);
            }
            localdur.UaW = ((mh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206224);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cmo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cmo)localObject2).parseFrom((byte[])localObject1);
            }
            localdur.UaX = ((cmo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206224);
          return 0;
        case 3: 
          localdur.RXK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206224);
          return 0;
        case 4: 
          localdur.SwI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206224);
          return 0;
        case 5: 
          localdur.SwH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206224);
          return 0;
        case 6: 
          localdur.UaC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(206224);
          return 0;
        case 7: 
          localdur.UaB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206224);
          return 0;
        case 8: 
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
            localdur.UaD = ((duu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(206224);
          return 0;
        case 9: 
          localdur.SvY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(206224);
          return 0;
        }
        localdur.UaF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(206224);
        return 0;
      }
      AppMethodBeat.o(206224);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dur
 * JD-Core Version:    0.7.0.1
 */