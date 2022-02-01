package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class avr
  extends dyl
{
  public aqo SCW;
  public aqe SDi;
  public LinkedList<emr> SFB;
  public String SHX;
  public String SHY;
  public aqj SHZ;
  public avq SIa;
  public String SIb;
  public b SIc;
  public epq SId;
  public ccb SIe;
  public int fEH;
  public String fcC;
  public String fcD;
  public b lastBuffer;
  public float latitude;
  public float longitude;
  public String objectNonceId;
  public int scene;
  public bsx xGN;
  public long xbk;
  public biv xcZ;
  public b xff;
  
  public avr()
  {
    AppMethodBeat.i(204112);
    this.SFB = new LinkedList();
    AppMethodBeat.o(204112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204113);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.bm(4, this.xbk);
      paramVarArgs.aY(5, this.fEH);
      paramVarArgs.i(6, this.longitude);
      paramVarArgs.i(7, this.latitude);
      if (this.objectNonceId != null) {
        paramVarArgs.f(8, this.objectNonceId);
      }
      if (this.SHX != null) {
        paramVarArgs.f(9, this.SHX);
      }
      paramVarArgs.aY(10, this.scene);
      if (this.SHY != null) {
        paramVarArgs.f(11, this.SHY);
      }
      if (this.xcZ != null)
      {
        paramVarArgs.oE(12, this.xcZ.computeSize());
        this.xcZ.writeFields(paramVarArgs);
      }
      if (this.SHZ != null)
      {
        paramVarArgs.oE(13, this.SHZ.computeSize());
        this.SHZ.writeFields(paramVarArgs);
      }
      if (this.xff != null) {
        paramVarArgs.c(14, this.xff);
      }
      if (this.SCW != null)
      {
        paramVarArgs.oE(15, this.SCW.computeSize());
        this.SCW.writeFields(paramVarArgs);
      }
      if (this.fcC != null) {
        paramVarArgs.f(16, this.fcC);
      }
      if (this.fcD != null) {
        paramVarArgs.f(17, this.fcD);
      }
      if (this.SIa != null)
      {
        paramVarArgs.oE(18, this.SIa.computeSize());
        this.SIa.writeFields(paramVarArgs);
      }
      if (this.SIb != null) {
        paramVarArgs.f(19, this.SIb);
      }
      if (this.SIc != null) {
        paramVarArgs.c(20, this.SIc);
      }
      if (this.SId != null)
      {
        paramVarArgs.oE(21, this.SId.computeSize());
        this.SId.writeFields(paramVarArgs);
      }
      if (this.xGN != null)
      {
        paramVarArgs.oE(22, this.xGN.computeSize());
        this.xGN.writeFields(paramVarArgs);
      }
      paramVarArgs.e(23, 8, this.SFB);
      if (this.SIe != null)
      {
        paramVarArgs.oE(24, this.SIe.computeSize());
        this.SIe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(204113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2256;
      }
    }
    label2256:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = i + g.a.a.b.b.a.p(4, this.xbk) + g.a.a.b.b.a.bM(5, this.fEH) + (g.a.a.b.b.a.gL(6) + 4) + (g.a.a.b.b.a.gL(7) + 4);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.objectNonceId);
      }
      i = paramInt;
      if (this.SHX != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SHX);
      }
      i += g.a.a.b.b.a.bM(10, this.scene);
      paramInt = i;
      if (this.SHY != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.SHY);
      }
      i = paramInt;
      if (this.xcZ != null) {
        i = paramInt + g.a.a.a.oD(12, this.xcZ.computeSize());
      }
      paramInt = i;
      if (this.SHZ != null) {
        paramInt = i + g.a.a.a.oD(13, this.SHZ.computeSize());
      }
      i = paramInt;
      if (this.xff != null) {
        i = paramInt + g.a.a.b.b.a.b(14, this.xff);
      }
      paramInt = i;
      if (this.SCW != null) {
        paramInt = i + g.a.a.a.oD(15, this.SCW.computeSize());
      }
      i = paramInt;
      if (this.fcC != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.fcC);
      }
      paramInt = i;
      if (this.fcD != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.fcD);
      }
      i = paramInt;
      if (this.SIa != null) {
        i = paramInt + g.a.a.a.oD(18, this.SIa.computeSize());
      }
      paramInt = i;
      if (this.SIb != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.SIb);
      }
      i = paramInt;
      if (this.SIc != null) {
        i = paramInt + g.a.a.b.b.a.b(20, this.SIc);
      }
      paramInt = i;
      if (this.SId != null) {
        paramInt = i + g.a.a.a.oD(21, this.SId.computeSize());
      }
      i = paramInt;
      if (this.xGN != null) {
        i = paramInt + g.a.a.a.oD(22, this.xGN.computeSize());
      }
      i += g.a.a.a.c(23, 8, this.SFB);
      paramInt = i;
      if (this.SIe != null) {
        paramInt = i + g.a.a.a.oD(24, this.SIe.computeSize());
      }
      AppMethodBeat.o(204113);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SFB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avr localavr = (avr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204113);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localavr.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204113);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localavr.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204113);
          return 0;
        case 3: 
          localavr.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(204113);
          return 0;
        case 4: 
          localavr.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(204113);
          return 0;
        case 5: 
          localavr.fEH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204113);
          return 0;
        case 6: 
          localavr.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(204113);
          return 0;
        case 7: 
          localavr.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(204113);
          return 0;
        case 8: 
          localavr.objectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204113);
          return 0;
        case 9: 
          localavr.SHX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204113);
          return 0;
        case 10: 
          localavr.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204113);
          return 0;
        case 11: 
          localavr.SHY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204113);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new biv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((biv)localObject2).parseFrom((byte[])localObject1);
            }
            localavr.xcZ = ((biv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204113);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqj)localObject2).parseFrom((byte[])localObject1);
            }
            localavr.SHZ = ((aqj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204113);
          return 0;
        case 14: 
          localavr.xff = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(204113);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqo)localObject2).parseFrom((byte[])localObject1);
            }
            localavr.SCW = ((aqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204113);
          return 0;
        case 16: 
          localavr.fcC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204113);
          return 0;
        case 17: 
          localavr.fcD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204113);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new avq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((avq)localObject2).parseFrom((byte[])localObject1);
            }
            localavr.SIa = ((avq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204113);
          return 0;
        case 19: 
          localavr.SIb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204113);
          return 0;
        case 20: 
          localavr.SIc = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(204113);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epq)localObject2).parseFrom((byte[])localObject1);
            }
            localavr.SId = ((epq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204113);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bsx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bsx)localObject2).parseFrom((byte[])localObject1);
            }
            localavr.xGN = ((bsx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204113);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emr)localObject2).parseFrom((byte[])localObject1);
            }
            localavr.SFB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204113);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ccb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ccb)localObject2).parseFrom((byte[])localObject1);
          }
          localavr.SIe = ((ccb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(204113);
        return 0;
      }
      AppMethodBeat.o(204113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avr
 * JD-Core Version:    0.7.0.1
 */