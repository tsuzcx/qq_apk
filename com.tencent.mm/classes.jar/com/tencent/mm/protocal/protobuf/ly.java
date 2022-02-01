package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ly
  extends dyy
{
  public int RFx;
  public eii RMf;
  public String RMg;
  public int RMk;
  public int RQX;
  public String RQY;
  public dbz RRc;
  public String RRe;
  public int RRf;
  public String RRg;
  public cke RRh;
  public qr RRi;
  public dca RRj;
  public String RRk;
  public int RRl;
  public eai RRm;
  public String RRn;
  public String RRo;
  public String RRp;
  public String RRq;
  public int RRr;
  public String Username;
  public String fAo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134244);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134244);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fAo != null) {
        paramVarArgs.f(2, this.fAo);
      }
      if (this.RRe != null) {
        paramVarArgs.f(3, this.RRe);
      }
      paramVarArgs.aY(4, this.RRf);
      if (this.RRg != null) {
        paramVarArgs.f(5, this.RRg);
      }
      if (this.Username != null) {
        paramVarArgs.f(6, this.Username);
      }
      if (this.RRh != null)
      {
        paramVarArgs.oE(7, this.RRh.computeSize());
        this.RRh.writeFields(paramVarArgs);
      }
      if (this.RRi != null)
      {
        paramVarArgs.oE(8, this.RRi.computeSize());
        this.RRi.writeFields(paramVarArgs);
      }
      if (this.RRj != null)
      {
        paramVarArgs.oE(9, this.RRj.computeSize());
        this.RRj.writeFields(paramVarArgs);
      }
      if (this.RMg != null) {
        paramVarArgs.f(10, this.RMg);
      }
      paramVarArgs.aY(11, this.RFx);
      if (this.RRk != null) {
        paramVarArgs.f(12, this.RRk);
      }
      paramVarArgs.aY(13, this.RRl);
      if (this.RRm != null)
      {
        paramVarArgs.oE(14, this.RRm.computeSize());
        this.RRm.writeFields(paramVarArgs);
      }
      if (this.RRn != null) {
        paramVarArgs.f(15, this.RRn);
      }
      if (this.RRo != null) {
        paramVarArgs.f(16, this.RRo);
      }
      if (this.RMf != null)
      {
        paramVarArgs.oE(17, this.RMf.computeSize());
        this.RMf.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(18, this.RMk);
      if (this.RRp != null) {
        paramVarArgs.f(19, this.RRp);
      }
      if (this.RRq != null) {
        paramVarArgs.f(20, this.RRq);
      }
      paramVarArgs.aY(21, this.RQX);
      if (this.RQY != null) {
        paramVarArgs.f(22, this.RQY);
      }
      paramVarArgs.aY(23, this.RRr);
      if (this.RRc != null)
      {
        paramVarArgs.oE(24, this.RRc.computeSize());
        this.RRc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2092;
      }
    }
    label2092:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fAo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fAo);
      }
      i = paramInt;
      if (this.RRe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RRe);
      }
      i += g.a.a.b.b.a.bM(4, this.RRf);
      paramInt = i;
      if (this.RRg != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RRg);
      }
      i = paramInt;
      if (this.Username != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.Username);
      }
      paramInt = i;
      if (this.RRh != null) {
        paramInt = i + g.a.a.a.oD(7, this.RRh.computeSize());
      }
      i = paramInt;
      if (this.RRi != null) {
        i = paramInt + g.a.a.a.oD(8, this.RRi.computeSize());
      }
      paramInt = i;
      if (this.RRj != null) {
        paramInt = i + g.a.a.a.oD(9, this.RRj.computeSize());
      }
      i = paramInt;
      if (this.RMg != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.RMg);
      }
      i += g.a.a.b.b.a.bM(11, this.RFx);
      paramInt = i;
      if (this.RRk != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.RRk);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.RRl);
      paramInt = i;
      if (this.RRm != null) {
        paramInt = i + g.a.a.a.oD(14, this.RRm.computeSize());
      }
      i = paramInt;
      if (this.RRn != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.RRn);
      }
      paramInt = i;
      if (this.RRo != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.RRo);
      }
      i = paramInt;
      if (this.RMf != null) {
        i = paramInt + g.a.a.a.oD(17, this.RMf.computeSize());
      }
      i += g.a.a.b.b.a.bM(18, this.RMk);
      paramInt = i;
      if (this.RRp != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.RRp);
      }
      i = paramInt;
      if (this.RRq != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.RRq);
      }
      i += g.a.a.b.b.a.bM(21, this.RQX);
      paramInt = i;
      if (this.RQY != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.RQY);
      }
      i = paramInt + g.a.a.b.b.a.bM(23, this.RRr);
      paramInt = i;
      if (this.RRc != null) {
        paramInt = i + g.a.a.a.oD(24, this.RRc.computeSize());
      }
      AppMethodBeat.o(134244);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(134244);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ly locally = (ly)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134244);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            locally.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 2: 
          locally.fAo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 3: 
          locally.RRe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 4: 
          locally.RRf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134244);
          return 0;
        case 5: 
          locally.RRg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 6: 
          locally.Username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cke();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cke)localObject2).parseFrom((byte[])localObject1);
            }
            locally.RRh = ((cke)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qr)localObject2).parseFrom((byte[])localObject1);
            }
            locally.RRi = ((qr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dca();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dca)localObject2).parseFrom((byte[])localObject1);
            }
            locally.RRj = ((dca)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 10: 
          locally.RMg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 11: 
          locally.RFx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134244);
          return 0;
        case 12: 
          locally.RRk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 13: 
          locally.RRl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134244);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eai();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eai)localObject2).parseFrom((byte[])localObject1);
            }
            locally.RRm = ((eai)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 15: 
          locally.RRn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 16: 
          locally.RRo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eii();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eii)localObject2).parseFrom((byte[])localObject1);
            }
            locally.RMf = ((eii)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134244);
          return 0;
        case 18: 
          locally.RMk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134244);
          return 0;
        case 19: 
          locally.RRp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 20: 
          locally.RRq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 21: 
          locally.RQX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134244);
          return 0;
        case 22: 
          locally.RQY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(134244);
          return 0;
        case 23: 
          locally.RRr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(134244);
          return 0;
        }
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
          locally.RRc = ((dbz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(134244);
        return 0;
      }
      AppMethodBeat.o(134244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ly
 * JD-Core Version:    0.7.0.1
 */