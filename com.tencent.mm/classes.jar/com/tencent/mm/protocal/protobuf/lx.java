package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lx
  extends dyl
{
  public String RMJ;
  public eae RMN;
  public String RMg;
  public int RNt;
  public String RQN;
  public String RQO;
  public int RQP;
  public String RQQ;
  public int RQR;
  public String RQS;
  public String RQT;
  public eae RQU;
  public int RQV;
  public int RQW;
  public int RQX;
  public String RQY;
  public eae RQZ;
  public String RRa;
  public eix RRb;
  public dbz RRc;
  public String RRd;
  public String UserName;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134243);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.RQN != null) {
        paramVarArgs.f(3, this.RQN);
      }
      paramVarArgs.aY(4, this.RNt);
      if (this.RQO != null) {
        paramVarArgs.f(5, this.RQO);
      }
      paramVarArgs.aY(6, this.RQP);
      if (this.RQQ != null) {
        paramVarArgs.f(7, this.RQQ);
      }
      if (this.RMg != null) {
        paramVarArgs.f(8, this.RMg);
      }
      paramVarArgs.aY(9, this.RQR);
      if (this.RQS != null) {
        paramVarArgs.f(10, this.RQS);
      }
      if (this.RQT != null) {
        paramVarArgs.f(11, this.RQT);
      }
      if (this.RQU != null)
      {
        paramVarArgs.oE(12, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      if (this.vhq != null) {
        paramVarArgs.f(13, this.vhq);
      }
      paramVarArgs.aY(14, this.RQV);
      paramVarArgs.aY(15, this.RQW);
      if (this.RMJ != null) {
        paramVarArgs.f(16, this.RMJ);
      }
      paramVarArgs.aY(17, this.RQX);
      if (this.RQY != null) {
        paramVarArgs.f(18, this.RQY);
      }
      if (this.RQZ != null)
      {
        paramVarArgs.oE(19, this.RQZ.computeSize());
        this.RQZ.writeFields(paramVarArgs);
      }
      if (this.RMN != null)
      {
        paramVarArgs.oE(20, this.RMN.computeSize());
        this.RMN.writeFields(paramVarArgs);
      }
      if (this.RRa != null) {
        paramVarArgs.f(21, this.RRa);
      }
      if (this.RRb != null)
      {
        paramVarArgs.oE(22, this.RRb.computeSize());
        this.RRb.writeFields(paramVarArgs);
      }
      if (this.RRc != null)
      {
        paramVarArgs.oE(23, this.RRc.computeSize());
        this.RRc.writeFields(paramVarArgs);
      }
      if (this.RRd != null) {
        paramVarArgs.f(24, this.RRd);
      }
      AppMethodBeat.o(134243);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1970;
      }
    }
    label1970:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.RQN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RQN);
      }
      i += g.a.a.b.b.a.bM(4, this.RNt);
      paramInt = i;
      if (this.RQO != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RQO);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.RQP);
      paramInt = i;
      if (this.RQQ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RQQ);
      }
      i = paramInt;
      if (this.RMg != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RMg);
      }
      i += g.a.a.b.b.a.bM(9, this.RQR);
      paramInt = i;
      if (this.RQS != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RQS);
      }
      i = paramInt;
      if (this.RQT != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.RQT);
      }
      paramInt = i;
      if (this.RQU != null) {
        paramInt = i + g.a.a.a.oD(12, this.RQU.computeSize());
      }
      i = paramInt;
      if (this.vhq != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.vhq);
      }
      i = i + g.a.a.b.b.a.bM(14, this.RQV) + g.a.a.b.b.a.bM(15, this.RQW);
      paramInt = i;
      if (this.RMJ != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.RMJ);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.RQX);
      paramInt = i;
      if (this.RQY != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.RQY);
      }
      i = paramInt;
      if (this.RQZ != null) {
        i = paramInt + g.a.a.a.oD(19, this.RQZ.computeSize());
      }
      paramInt = i;
      if (this.RMN != null) {
        paramInt = i + g.a.a.a.oD(20, this.RMN.computeSize());
      }
      i = paramInt;
      if (this.RRa != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.RRa);
      }
      paramInt = i;
      if (this.RRb != null) {
        paramInt = i + g.a.a.a.oD(22, this.RRb.computeSize());
      }
      i = paramInt;
      if (this.RRc != null) {
        i = paramInt + g.a.a.a.oD(23, this.RRc.computeSize());
      }
      paramInt = i;
      if (this.RRd != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.RRd);
      }
      AppMethodBeat.o(134243);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(134243);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        lx locallx = (lx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134243);
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
            locallx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 2: 
          locallx.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 3: 
          locallx.RQN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 4: 
          locallx.RNt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134243);
          return 0;
        case 5: 
          locallx.RQO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 6: 
          locallx.RQP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134243);
          return 0;
        case 7: 
          locallx.RQQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 8: 
          locallx.RMg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 9: 
          locallx.RQR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134243);
          return 0;
        case 10: 
          locallx.RQS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 11: 
          locallx.RQT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            locallx.RQU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 13: 
          locallx.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 14: 
          locallx.RQV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134243);
          return 0;
        case 15: 
          locallx.RQW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134243);
          return 0;
        case 16: 
          locallx.RMJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 17: 
          locallx.RQX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134243);
          return 0;
        case 18: 
          locallx.RQY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            locallx.RQZ = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            locallx.RMN = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 21: 
          locallx.RRa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134243);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eix();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eix)localObject2).parseFrom((byte[])localObject1);
            }
            locallx.RRb = ((eix)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbz)localObject2).parseFrom((byte[])localObject1);
            }
            locallx.RRc = ((dbz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134243);
          return 0;
        }
        locallx.RRd = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(134243);
        return 0;
      }
      AppMethodBeat.o(134243);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lx
 * JD-Core Version:    0.7.0.1
 */