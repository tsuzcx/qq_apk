package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class daq
  extends com.tencent.mm.cd.a
{
  public String THE;
  public String THW;
  public dam THX;
  public dak THY;
  public dao THZ;
  public dap TIa;
  public boolean TIb;
  public dan TIc;
  public dan TId;
  public dan TIe;
  public int fNO;
  public String wmL;
  public long zUF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205515);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wmL != null) {
        paramVarArgs.f(1, this.wmL);
      }
      paramVarArgs.bm(2, this.zUF);
      if (this.THW != null) {
        paramVarArgs.f(3, this.THW);
      }
      paramVarArgs.aY(4, this.fNO);
      if (this.THE != null) {
        paramVarArgs.f(5, this.THE);
      }
      if (this.THX != null)
      {
        paramVarArgs.oE(6, this.THX.computeSize());
        this.THX.writeFields(paramVarArgs);
      }
      if (this.THY != null)
      {
        paramVarArgs.oE(7, this.THY.computeSize());
        this.THY.writeFields(paramVarArgs);
      }
      if (this.THZ != null)
      {
        paramVarArgs.oE(8, this.THZ.computeSize());
        this.THZ.writeFields(paramVarArgs);
      }
      if (this.TIa != null)
      {
        paramVarArgs.oE(9, this.TIa.computeSize());
        this.TIa.writeFields(paramVarArgs);
      }
      paramVarArgs.co(10, this.TIb);
      if (this.TIc != null)
      {
        paramVarArgs.oE(11, this.TIc.computeSize());
        this.TIc.writeFields(paramVarArgs);
      }
      if (this.TId != null)
      {
        paramVarArgs.oE(12, this.TId.computeSize());
        this.TId.writeFields(paramVarArgs);
      }
      if (this.TIe != null)
      {
        paramVarArgs.oE(13, this.TIe.computeSize());
        this.TIe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(205515);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wmL == null) {
        break label1408;
      }
    }
    label1408:
    for (paramInt = g.a.a.b.b.a.g(1, this.wmL) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.zUF);
      paramInt = i;
      if (this.THW != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.THW);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.fNO);
      paramInt = i;
      if (this.THE != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.THE);
      }
      i = paramInt;
      if (this.THX != null) {
        i = paramInt + g.a.a.a.oD(6, this.THX.computeSize());
      }
      paramInt = i;
      if (this.THY != null) {
        paramInt = i + g.a.a.a.oD(7, this.THY.computeSize());
      }
      i = paramInt;
      if (this.THZ != null) {
        i = paramInt + g.a.a.a.oD(8, this.THZ.computeSize());
      }
      paramInt = i;
      if (this.TIa != null) {
        paramInt = i + g.a.a.a.oD(9, this.TIa.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.gL(10) + 1);
      paramInt = i;
      if (this.TIc != null) {
        paramInt = i + g.a.a.a.oD(11, this.TIc.computeSize());
      }
      i = paramInt;
      if (this.TId != null) {
        i = paramInt + g.a.a.a.oD(12, this.TId.computeSize());
      }
      paramInt = i;
      if (this.TIe != null) {
        paramInt = i + g.a.a.a.oD(13, this.TIe.computeSize());
      }
      AppMethodBeat.o(205515);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205515);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        daq localdaq = (daq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205515);
          return -1;
        case 1: 
          localdaq.wmL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205515);
          return 0;
        case 2: 
          localdaq.zUF = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(205515);
          return 0;
        case 3: 
          localdaq.THW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205515);
          return 0;
        case 4: 
          localdaq.fNO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205515);
          return 0;
        case 5: 
          localdaq.THE = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205515);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dam();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dam)localObject2).parseFrom((byte[])localObject1);
            }
            localdaq.THX = ((dam)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205515);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dak();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dak)localObject2).parseFrom((byte[])localObject1);
            }
            localdaq.THY = ((dak)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205515);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dao();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dao)localObject2).parseFrom((byte[])localObject1);
            }
            localdaq.THZ = ((dao)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205515);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dap();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dap)localObject2).parseFrom((byte[])localObject1);
            }
            localdaq.TIa = ((dap)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205515);
          return 0;
        case 10: 
          localdaq.TIb = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(205515);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dan();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dan)localObject2).parseFrom((byte[])localObject1);
            }
            localdaq.TIc = ((dan)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205515);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dan();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dan)localObject2).parseFrom((byte[])localObject1);
            }
            localdaq.TId = ((dan)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205515);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dan();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dan)localObject2).parseFrom((byte[])localObject1);
          }
          localdaq.TIe = ((dan)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(205515);
        return 0;
      }
      AppMethodBeat.o(205515);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daq
 * JD-Core Version:    0.7.0.1
 */