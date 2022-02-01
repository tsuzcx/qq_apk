package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ra
  extends dyl
{
  public int Ilb;
  public String ImS;
  public String ImT;
  public String ImV;
  public int ImX;
  public String ImY;
  public String ImZ;
  public String Imv;
  public String Lwz;
  public aos RJh;
  public int RJi;
  public String RJq;
  public String RZA;
  public String RZB;
  public String RZj;
  public String RZp;
  public String RZq;
  public String RZr;
  public int RZs;
  public boolean RZt;
  public boolean RZu;
  public String RZv;
  public int RZw;
  public String RZx;
  public int RZy;
  public int RZz;
  public int channel;
  public String ktM;
  public String llO;
  public String nickname;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91374);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RZp == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_id");
        AppMethodBeat.o(91374);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ImY != null) {
        paramVarArgs.f(2, this.ImY);
      }
      if (this.RZp != null) {
        paramVarArgs.f(3, this.RZp);
      }
      paramVarArgs.aY(4, this.scene);
      if (this.RZq != null) {
        paramVarArgs.f(5, this.RZq);
      }
      if (this.ImS != null) {
        paramVarArgs.f(6, this.ImS);
      }
      paramVarArgs.aY(7, this.RJi);
      paramVarArgs.aY(8, this.channel);
      if (this.ImZ != null) {
        paramVarArgs.f(9, this.ImZ);
      }
      if (this.ImT != null) {
        paramVarArgs.f(10, this.ImT);
      }
      if (this.RZr != null) {
        paramVarArgs.f(11, this.RZr);
      }
      paramVarArgs.aY(12, this.RZs);
      paramVarArgs.aY(13, this.ImX);
      if (this.llO != null) {
        paramVarArgs.f(14, this.llO);
      }
      if (this.RJh != null)
      {
        paramVarArgs.oE(15, this.RJh.computeSize());
        this.RJh.writeFields(paramVarArgs);
      }
      if (this.RZj != null) {
        paramVarArgs.f(16, this.RZj);
      }
      paramVarArgs.aY(17, this.Ilb);
      paramVarArgs.co(18, this.RZt);
      paramVarArgs.co(19, this.RZu);
      if (this.Lwz != null) {
        paramVarArgs.f(20, this.Lwz);
      }
      if (this.ktM != null) {
        paramVarArgs.f(21, this.ktM);
      }
      if (this.RZv != null) {
        paramVarArgs.f(22, this.RZv);
      }
      if (this.ImV != null) {
        paramVarArgs.f(23, this.ImV);
      }
      if (this.nickname != null) {
        paramVarArgs.f(24, this.nickname);
      }
      if (this.Imv != null) {
        paramVarArgs.f(25, this.Imv);
      }
      paramVarArgs.aY(26, this.RZw);
      if (this.RZx != null) {
        paramVarArgs.f(27, this.RZx);
      }
      paramVarArgs.aY(28, this.RZy);
      paramVarArgs.aY(29, this.RZz);
      if (this.RJq != null) {
        paramVarArgs.f(30, this.RJq);
      }
      if (this.RZA != null) {
        paramVarArgs.f(31, this.RZA);
      }
      if (this.RZB != null) {
        paramVarArgs.f(32, this.RZB);
      }
      AppMethodBeat.o(91374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2134;
      }
    }
    label2134:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ImY != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ImY);
      }
      i = paramInt;
      if (this.RZp != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RZp);
      }
      i += g.a.a.b.b.a.bM(4, this.scene);
      paramInt = i;
      if (this.RZq != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RZq);
      }
      i = paramInt;
      if (this.ImS != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.ImS);
      }
      i = i + g.a.a.b.b.a.bM(7, this.RJi) + g.a.a.b.b.a.bM(8, this.channel);
      paramInt = i;
      if (this.ImZ != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.ImZ);
      }
      i = paramInt;
      if (this.ImT != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.ImT);
      }
      paramInt = i;
      if (this.RZr != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.RZr);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.RZs) + g.a.a.b.b.a.bM(13, this.ImX);
      paramInt = i;
      if (this.llO != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.llO);
      }
      i = paramInt;
      if (this.RJh != null) {
        i = paramInt + g.a.a.a.oD(15, this.RJh.computeSize());
      }
      paramInt = i;
      if (this.RZj != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.RZj);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.Ilb) + (g.a.a.b.b.a.gL(18) + 1) + (g.a.a.b.b.a.gL(19) + 1);
      paramInt = i;
      if (this.Lwz != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.Lwz);
      }
      i = paramInt;
      if (this.ktM != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.ktM);
      }
      paramInt = i;
      if (this.RZv != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.RZv);
      }
      i = paramInt;
      if (this.ImV != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.ImV);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.nickname);
      }
      i = paramInt;
      if (this.Imv != null) {
        i = paramInt + g.a.a.b.b.a.g(25, this.Imv);
      }
      i += g.a.a.b.b.a.bM(26, this.RZw);
      paramInt = i;
      if (this.RZx != null) {
        paramInt = i + g.a.a.b.b.a.g(27, this.RZx);
      }
      i = paramInt + g.a.a.b.b.a.bM(28, this.RZy) + g.a.a.b.b.a.bM(29, this.RZz);
      paramInt = i;
      if (this.RJq != null) {
        paramInt = i + g.a.a.b.b.a.g(30, this.RJq);
      }
      i = paramInt;
      if (this.RZA != null) {
        i = paramInt + g.a.a.b.b.a.g(31, this.RZA);
      }
      paramInt = i;
      if (this.RZB != null) {
        paramInt = i + g.a.a.b.b.a.g(32, this.RZB);
      }
      AppMethodBeat.o(91374);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RZp == null)
        {
          paramVarArgs = new b("Not all required fields were included: qrcode_id");
          AppMethodBeat.o(91374);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ra localra = (ra)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91374);
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
            localra.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 2: 
          localra.ImY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 3: 
          localra.RZp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 4: 
          localra.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91374);
          return 0;
        case 5: 
          localra.RZq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 6: 
          localra.ImS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 7: 
          localra.RJi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91374);
          return 0;
        case 8: 
          localra.channel = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91374);
          return 0;
        case 9: 
          localra.ImZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 10: 
          localra.ImT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 11: 
          localra.RZr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 12: 
          localra.RZs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91374);
          return 0;
        case 13: 
          localra.ImX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91374);
          return 0;
        case 14: 
          localra.llO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aos();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aos)localObject2).parseFrom((byte[])localObject1);
            }
            localra.RJh = ((aos)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 16: 
          localra.RZj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 17: 
          localra.Ilb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91374);
          return 0;
        case 18: 
          localra.RZt = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91374);
          return 0;
        case 19: 
          localra.RZu = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91374);
          return 0;
        case 20: 
          localra.Lwz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 21: 
          localra.ktM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 22: 
          localra.RZv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 23: 
          localra.ImV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 24: 
          localra.nickname = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 25: 
          localra.Imv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 26: 
          localra.RZw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91374);
          return 0;
        case 27: 
          localra.RZx = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 28: 
          localra.RZy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91374);
          return 0;
        case 29: 
          localra.RZz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91374);
          return 0;
        case 30: 
          localra.RJq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 31: 
          localra.RZA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91374);
          return 0;
        }
        localra.RZB = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91374);
        return 0;
      }
      AppMethodBeat.o(91374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ra
 * JD-Core Version:    0.7.0.1
 */