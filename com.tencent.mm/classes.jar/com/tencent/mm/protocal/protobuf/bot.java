package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bot
  extends dyy
{
  public String CNP;
  public int SZN;
  public String SZP;
  public String SZQ;
  public LinkedList<ckf> SZV;
  public int TaA;
  public eae TaB;
  public eae TaC;
  public eae Taj;
  public String Tao;
  public String Tap;
  public cmy Taq;
  public bob Tar;
  public String Tas;
  public int Tat;
  public LinkedList<pt> Tau;
  public String Tav;
  public String Taw;
  public String Tax;
  public afh Tay;
  public eae Taz;
  public String UserName;
  public String fwr;
  public String lpy;
  
  public bot()
  {
    AppMethodBeat.i(152553);
    this.Tau = new LinkedList();
    this.SZV = new LinkedList();
    AppMethodBeat.o(152553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152554);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tao != null) {
        paramVarArgs.f(2, this.Tao);
      }
      if (this.Tap != null) {
        paramVarArgs.f(3, this.Tap);
      }
      paramVarArgs.aY(4, this.SZN);
      if (this.fwr != null) {
        paramVarArgs.f(5, this.fwr);
      }
      if (this.lpy != null) {
        paramVarArgs.f(6, this.lpy);
      }
      if (this.Taq != null)
      {
        paramVarArgs.oE(7, this.Taq.computeSize());
        this.Taq.writeFields(paramVarArgs);
      }
      if (this.Tar != null)
      {
        paramVarArgs.oE(8, this.Tar.computeSize());
        this.Tar.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(9, this.UserName);
      }
      if (this.Tas != null) {
        paramVarArgs.f(15, this.Tas);
      }
      paramVarArgs.aY(16, this.Tat);
      paramVarArgs.e(17, 8, this.Tau);
      if (this.Tav != null) {
        paramVarArgs.f(18, this.Tav);
      }
      if (this.Taw != null) {
        paramVarArgs.f(20, this.Taw);
      }
      if (this.Tax != null) {
        paramVarArgs.f(21, this.Tax);
      }
      if (this.Tay != null)
      {
        paramVarArgs.oE(22, this.Tay.computeSize());
        this.Tay.writeFields(paramVarArgs);
      }
      if (this.Taz != null)
      {
        paramVarArgs.oE(23, this.Taz.computeSize());
        this.Taz.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(24, this.TaA);
      paramVarArgs.e(25, 8, this.SZV);
      if (this.CNP != null) {
        paramVarArgs.f(26, this.CNP);
      }
      if (this.SZP != null) {
        paramVarArgs.f(27, this.SZP);
      }
      if (this.Taj != null)
      {
        paramVarArgs.oE(28, this.Taj.computeSize());
        this.Taj.writeFields(paramVarArgs);
      }
      if (this.SZQ != null) {
        paramVarArgs.f(29, this.SZQ);
      }
      if (this.TaB != null)
      {
        paramVarArgs.oE(30, this.TaB.computeSize());
        this.TaB.writeFields(paramVarArgs);
      }
      if (this.TaC != null)
      {
        paramVarArgs.oE(31, this.TaC.computeSize());
        this.TaC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2410;
      }
    }
    label2410:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tao != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Tao);
      }
      i = paramInt;
      if (this.Tap != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tap);
      }
      i += g.a.a.b.b.a.bM(4, this.SZN);
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fwr);
      }
      i = paramInt;
      if (this.lpy != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.lpy);
      }
      paramInt = i;
      if (this.Taq != null) {
        paramInt = i + g.a.a.a.oD(7, this.Taq.computeSize());
      }
      i = paramInt;
      if (this.Tar != null) {
        i = paramInt + g.a.a.a.oD(8, this.Tar.computeSize());
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.UserName);
      }
      i = paramInt;
      if (this.Tas != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.Tas);
      }
      i = i + g.a.a.b.b.a.bM(16, this.Tat) + g.a.a.a.c(17, 8, this.Tau);
      paramInt = i;
      if (this.Tav != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.Tav);
      }
      i = paramInt;
      if (this.Taw != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.Taw);
      }
      paramInt = i;
      if (this.Tax != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.Tax);
      }
      i = paramInt;
      if (this.Tay != null) {
        i = paramInt + g.a.a.a.oD(22, this.Tay.computeSize());
      }
      paramInt = i;
      if (this.Taz != null) {
        paramInt = i + g.a.a.a.oD(23, this.Taz.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(24, this.TaA) + g.a.a.a.c(25, 8, this.SZV);
      paramInt = i;
      if (this.CNP != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.CNP);
      }
      i = paramInt;
      if (this.SZP != null) {
        i = paramInt + g.a.a.b.b.a.g(27, this.SZP);
      }
      paramInt = i;
      if (this.Taj != null) {
        paramInt = i + g.a.a.a.oD(28, this.Taj.computeSize());
      }
      i = paramInt;
      if (this.SZQ != null) {
        i = paramInt + g.a.a.b.b.a.g(29, this.SZQ);
      }
      paramInt = i;
      if (this.TaB != null) {
        paramInt = i + g.a.a.a.oD(30, this.TaB.computeSize());
      }
      i = paramInt;
      if (this.TaC != null) {
        i = paramInt + g.a.a.a.oD(31, this.TaC.computeSize());
      }
      AppMethodBeat.o(152554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tau.clear();
        this.SZV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bot localbot = (bot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 19: 
        default: 
          AppMethodBeat.o(152554);
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
            localbot.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 2: 
          localbot.Tao = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 3: 
          localbot.Tap = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 4: 
          localbot.SZN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152554);
          return 0;
        case 5: 
          localbot.fwr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 6: 
          localbot.lpy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cmy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cmy)localObject2).parseFrom((byte[])localObject1);
            }
            localbot.Taq = ((cmy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bob();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bob)localObject2).parseFrom((byte[])localObject1);
            }
            localbot.Tar = ((bob)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 9: 
          localbot.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 15: 
          localbot.Tas = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 16: 
          localbot.Tat = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152554);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new pt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((pt)localObject2).parseFrom((byte[])localObject1);
            }
            localbot.Tau.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 18: 
          localbot.Tav = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 20: 
          localbot.Taw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 21: 
          localbot.Tax = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new afh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((afh)localObject2).parseFrom((byte[])localObject1);
            }
            localbot.Tay = ((afh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 23: 
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
            localbot.Taz = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 24: 
          localbot.TaA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152554);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ckf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ckf)localObject2).parseFrom((byte[])localObject1);
            }
            localbot.SZV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 26: 
          localbot.CNP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 27: 
          localbot.SZP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 28: 
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
            localbot.Taj = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 29: 
          localbot.SZQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 30: 
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
            localbot.TaB = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        }
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
          localbot.TaC = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      AppMethodBeat.o(152554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bot
 * JD-Core Version:    0.7.0.1
 */