package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class daz
  extends dyl
{
  public aqe RLM;
  public aqo SCW;
  public b SDI;
  public b SEd;
  public int SFA;
  public LinkedList<emr> SFB;
  public ayv SHo;
  public avq SIa;
  public b SIc;
  public epq SId;
  public ccb SIe;
  public String TIv;
  public biv TIw;
  public aqj TIx;
  public String TIy;
  public String from_username;
  public float latitude;
  public float longitude;
  public long object_id;
  public String object_nonce_id;
  public String sWA;
  public int scene;
  public String source;
  public bsx xGN;
  
  public daz()
  {
    AppMethodBeat.i(228420);
    this.SFB = new LinkedList();
    AppMethodBeat.o(228420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(228458);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLM != null)
      {
        paramVarArgs.oE(2, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      if (this.SDI != null) {
        paramVarArgs.c(3, this.SDI);
      }
      paramVarArgs.bm(4, this.object_id);
      paramVarArgs.i(6, this.longitude);
      paramVarArgs.i(7, this.latitude);
      paramVarArgs.aY(5, this.SFA);
      if (this.object_nonce_id != null) {
        paramVarArgs.f(8, this.object_nonce_id);
      }
      if (this.TIv != null) {
        paramVarArgs.f(9, this.TIv);
      }
      paramVarArgs.aY(10, this.scene);
      if (this.source != null) {
        paramVarArgs.f(11, this.source);
      }
      if (this.TIw != null)
      {
        paramVarArgs.oE(12, this.TIw.computeSize());
        this.TIw.writeFields(paramVarArgs);
      }
      if (this.TIx != null)
      {
        paramVarArgs.oE(13, this.TIx.computeSize());
        this.TIx.writeFields(paramVarArgs);
      }
      if (this.SEd != null) {
        paramVarArgs.c(14, this.SEd);
      }
      if (this.SCW != null)
      {
        paramVarArgs.oE(15, this.SCW.computeSize());
        this.SCW.writeFields(paramVarArgs);
      }
      if (this.from_username != null) {
        paramVarArgs.f(16, this.from_username);
      }
      if (this.sWA != null) {
        paramVarArgs.f(17, this.sWA);
      }
      if (this.SIa != null)
      {
        paramVarArgs.oE(18, this.SIa.computeSize());
        this.SIa.writeFields(paramVarArgs);
      }
      if (this.TIy != null) {
        paramVarArgs.f(19, this.TIy);
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
      if (this.SHo != null)
      {
        paramVarArgs.oE(25, this.SHo.computeSize());
        this.SHo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(228458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2390;
      }
    }
    label2390:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLM != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      i = paramInt;
      if (this.SDI != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.SDI);
      }
      i = i + g.a.a.b.b.a.p(4, this.object_id) + (g.a.a.b.b.a.gL(6) + 4) + (g.a.a.b.b.a.gL(7) + 4) + g.a.a.b.b.a.bM(5, this.SFA);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.object_nonce_id);
      }
      i = paramInt;
      if (this.TIv != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.TIv);
      }
      i += g.a.a.b.b.a.bM(10, this.scene);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.source);
      }
      i = paramInt;
      if (this.TIw != null) {
        i = paramInt + g.a.a.a.oD(12, this.TIw.computeSize());
      }
      paramInt = i;
      if (this.TIx != null) {
        paramInt = i + g.a.a.a.oD(13, this.TIx.computeSize());
      }
      i = paramInt;
      if (this.SEd != null) {
        i = paramInt + g.a.a.b.b.a.b(14, this.SEd);
      }
      paramInt = i;
      if (this.SCW != null) {
        paramInt = i + g.a.a.a.oD(15, this.SCW.computeSize());
      }
      i = paramInt;
      if (this.from_username != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.from_username);
      }
      paramInt = i;
      if (this.sWA != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.sWA);
      }
      i = paramInt;
      if (this.SIa != null) {
        i = paramInt + g.a.a.a.oD(18, this.SIa.computeSize());
      }
      paramInt = i;
      if (this.TIy != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.TIy);
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
      i = paramInt;
      if (this.SHo != null) {
        i = paramInt + g.a.a.a.oD(25, this.SHo.computeSize());
      }
      AppMethodBeat.o(228458);
      return i;
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
        AppMethodBeat.o(228458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        daz localdaz = (daz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(228458);
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
            localdaz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(228458);
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
            localdaz.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(228458);
          return 0;
        case 3: 
          localdaz.SDI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(228458);
          return 0;
        case 4: 
          localdaz.object_id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(228458);
          return 0;
        case 6: 
          localdaz.longitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(228458);
          return 0;
        case 7: 
          localdaz.latitude = Float.intBitsToFloat(((g.a.a.a.a)localObject1).abFh.AO());
          AppMethodBeat.o(228458);
          return 0;
        case 5: 
          localdaz.SFA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(228458);
          return 0;
        case 8: 
          localdaz.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(228458);
          return 0;
        case 9: 
          localdaz.TIv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(228458);
          return 0;
        case 10: 
          localdaz.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(228458);
          return 0;
        case 11: 
          localdaz.source = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(228458);
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
            localdaz.TIw = ((biv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(228458);
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
            localdaz.TIx = ((aqj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(228458);
          return 0;
        case 14: 
          localdaz.SEd = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(228458);
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
            localdaz.SCW = ((aqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(228458);
          return 0;
        case 16: 
          localdaz.from_username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(228458);
          return 0;
        case 17: 
          localdaz.sWA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(228458);
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
            localdaz.SIa = ((avq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(228458);
          return 0;
        case 19: 
          localdaz.TIy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(228458);
          return 0;
        case 20: 
          localdaz.SIc = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(228458);
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
            localdaz.SId = ((epq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(228458);
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
            localdaz.xGN = ((bsx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(228458);
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
            localdaz.SFB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(228458);
          return 0;
        case 24: 
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
            localdaz.SIe = ((ccb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(228458);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ayv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ayv)localObject2).parseFrom((byte[])localObject1);
          }
          localdaz.SHo = ((ayv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(228458);
        return 0;
      }
      AppMethodBeat.o(228458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daz
 * JD-Core Version:    0.7.0.1
 */