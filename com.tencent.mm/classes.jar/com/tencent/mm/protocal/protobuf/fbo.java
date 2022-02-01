package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbo
  extends com.tencent.mm.cd.a
{
  public int GcW;
  public LinkedList<oz> RXm;
  public int SFr;
  public String UBI;
  public String UBJ;
  public long UBK;
  public LinkedList<coz> UBL;
  public boolean UBM;
  public int aNf;
  public int eventId;
  public String fFe;
  public String id;
  public long timestamp;
  public int type;
  public String typeName;
  
  public fbo()
  {
    AppMethodBeat.i(257059);
    this.id = "";
    this.UBI = "";
    this.typeName = "";
    this.fFe = "";
    this.UBJ = "";
    this.eventId = 0;
    this.timestamp = 0L;
    this.UBK = 0L;
    this.SFr = 0;
    this.RXm = new LinkedList();
    this.UBL = new LinkedList();
    this.UBM = true;
    this.type = -1;
    AppMethodBeat.o(257059);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257060);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.f(1, this.id);
      }
      if (this.UBI != null) {
        paramVarArgs.f(2, this.UBI);
      }
      if (this.typeName != null) {
        paramVarArgs.f(3, this.typeName);
      }
      if (this.fFe != null) {
        paramVarArgs.f(4, this.fFe);
      }
      if (this.UBJ != null) {
        paramVarArgs.f(5, this.UBJ);
      }
      paramVarArgs.aY(6, this.eventId);
      paramVarArgs.aY(7, this.aNf);
      paramVarArgs.aY(8, this.GcW);
      paramVarArgs.bm(9, this.timestamp);
      paramVarArgs.bm(10, this.UBK);
      paramVarArgs.aY(11, this.SFr);
      paramVarArgs.e(12, 8, this.RXm);
      paramVarArgs.e(13, 8, this.UBL);
      paramVarArgs.co(14, this.UBM);
      paramVarArgs.aY(15, this.type);
      AppMethodBeat.o(257060);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label1082;
      }
    }
    label1082:
    for (int i = g.a.a.b.b.a.g(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UBI != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UBI);
      }
      i = paramInt;
      if (this.typeName != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.typeName);
      }
      paramInt = i;
      if (this.fFe != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fFe);
      }
      i = paramInt;
      if (this.UBJ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UBJ);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.eventId);
      int j = g.a.a.b.b.a.bM(7, this.aNf);
      int k = g.a.a.b.b.a.bM(8, this.GcW);
      int m = g.a.a.b.b.a.p(9, this.timestamp);
      int n = g.a.a.b.b.a.p(10, this.UBK);
      int i1 = g.a.a.b.b.a.bM(11, this.SFr);
      int i2 = g.a.a.a.c(12, 8, this.RXm);
      int i3 = g.a.a.a.c(13, 8, this.UBL);
      int i4 = g.a.a.b.b.a.gL(14);
      int i5 = g.a.a.b.b.a.bM(15, this.type);
      AppMethodBeat.o(257060);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RXm.clear();
        this.UBL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(257060);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fbo localfbo = (fbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257060);
          return -1;
        case 1: 
          localfbo.id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(257060);
          return 0;
        case 2: 
          localfbo.UBI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(257060);
          return 0;
        case 3: 
          localfbo.typeName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(257060);
          return 0;
        case 4: 
          localfbo.fFe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(257060);
          return 0;
        case 5: 
          localfbo.UBJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(257060);
          return 0;
        case 6: 
          localfbo.eventId = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(257060);
          return 0;
        case 7: 
          localfbo.aNf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(257060);
          return 0;
        case 8: 
          localfbo.GcW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(257060);
          return 0;
        case 9: 
          localfbo.timestamp = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(257060);
          return 0;
        case 10: 
          localfbo.UBK = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(257060);
          return 0;
        case 11: 
          localfbo.SFr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(257060);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new oz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((oz)localObject2).parseFrom((byte[])localObject1);
            }
            localfbo.RXm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257060);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new coz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((coz)localObject2).parseFrom((byte[])localObject1);
            }
            localfbo.UBL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257060);
          return 0;
        case 14: 
          localfbo.UBM = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(257060);
          return 0;
        }
        localfbo.type = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(257060);
        return 0;
      }
      AppMethodBeat.o(257060);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbo
 * JD-Core Version:    0.7.0.1
 */