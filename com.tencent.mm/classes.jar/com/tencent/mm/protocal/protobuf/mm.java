package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class mm
  extends dyl
{
  public ml IKy;
  public String RRY;
  public String RRZ;
  public b RSg;
  public String RSh;
  public int RSi;
  public int RSj;
  public long RSk;
  public boolean RSl;
  public boolean RSm;
  public GoodsObject RSn;
  public int RSo;
  public int RSp;
  public mj RSq;
  public mk RSr;
  public long RSs;
  public int mode;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124394);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RSg != null) {
        paramVarArgs.c(2, this.RSg);
      }
      paramVarArgs.aY(11, this.type);
      paramVarArgs.aY(12, this.mode);
      if (this.RRY != null) {
        paramVarArgs.f(13, this.RRY);
      }
      if (this.RRZ != null) {
        paramVarArgs.f(14, this.RRZ);
      }
      if (this.RSh != null) {
        paramVarArgs.f(15, this.RSh);
      }
      paramVarArgs.aY(16, this.RSi);
      paramVarArgs.aY(17, this.RSj);
      paramVarArgs.bm(18, this.RSk);
      paramVarArgs.co(19, this.RSl);
      paramVarArgs.co(20, this.RSm);
      if (this.RSn != null)
      {
        paramVarArgs.oE(21, this.RSn.computeSize());
        this.RSn.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(22, this.RSo);
      paramVarArgs.aY(23, this.RSp);
      if (this.IKy != null)
      {
        paramVarArgs.oE(26, this.IKy.computeSize());
        this.IKy.writeFields(paramVarArgs);
      }
      if (this.RSq != null)
      {
        paramVarArgs.oE(31, this.RSq.computeSize());
        this.RSq.writeFields(paramVarArgs);
      }
      if (this.RSr != null)
      {
        paramVarArgs.oE(32, this.RSr.computeSize());
        this.RSr.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(50, this.RSs);
      AppMethodBeat.o(124394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1588;
      }
    }
    label1588:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RSg != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.RSg);
      }
      i = i + g.a.a.b.b.a.bM(11, this.type) + g.a.a.b.b.a.bM(12, this.mode);
      paramInt = i;
      if (this.RRY != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.RRY);
      }
      i = paramInt;
      if (this.RRZ != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.RRZ);
      }
      paramInt = i;
      if (this.RSh != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.RSh);
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.RSi) + g.a.a.b.b.a.bM(17, this.RSj) + g.a.a.b.b.a.p(18, this.RSk) + (g.a.a.b.b.a.gL(19) + 1) + (g.a.a.b.b.a.gL(20) + 1);
      paramInt = i;
      if (this.RSn != null) {
        paramInt = i + g.a.a.a.oD(21, this.RSn.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(22, this.RSo) + g.a.a.b.b.a.bM(23, this.RSp);
      paramInt = i;
      if (this.IKy != null) {
        paramInt = i + g.a.a.a.oD(26, this.IKy.computeSize());
      }
      i = paramInt;
      if (this.RSq != null) {
        i = paramInt + g.a.a.a.oD(31, this.RSq.computeSize());
      }
      paramInt = i;
      if (this.RSr != null) {
        paramInt = i + g.a.a.a.oD(32, this.RSr.computeSize());
      }
      i = g.a.a.b.b.a.p(50, this.RSs);
      AppMethodBeat.o(124394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        mm localmm = (mm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124394);
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
            localmm.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 2: 
          localmm.RSg = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(124394);
          return 0;
        case 11: 
          localmm.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124394);
          return 0;
        case 12: 
          localmm.mode = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124394);
          return 0;
        case 13: 
          localmm.RRY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 14: 
          localmm.RRZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 15: 
          localmm.RSh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 16: 
          localmm.RSi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124394);
          return 0;
        case 17: 
          localmm.RSj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124394);
          return 0;
        case 18: 
          localmm.RSk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(124394);
          return 0;
        case 19: 
          localmm.RSl = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(124394);
          return 0;
        case 20: 
          localmm.RSm = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(124394);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new GoodsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((GoodsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localmm.RSn = ((GoodsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 22: 
          localmm.RSo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124394);
          return 0;
        case 23: 
          localmm.RSp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124394);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ml();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ml)localObject2).parseFrom((byte[])localObject1);
            }
            localmm.IKy = ((ml)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 31: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new mj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((mj)localObject2).parseFrom((byte[])localObject1);
            }
            localmm.RSq = ((mj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 32: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new mk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((mk)localObject2).parseFrom((byte[])localObject1);
            }
            localmm.RSr = ((mk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        }
        localmm.RSs = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(124394);
        return 0;
      }
      AppMethodBeat.o(124394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mm
 * JD-Core Version:    0.7.0.1
 */