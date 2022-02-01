package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bzt
  extends dyy
{
  public String RLJ;
  public int RLe;
  public String RUd;
  public int RXo;
  public String Sas;
  public eae TgD;
  public String TgM;
  public int TgN;
  public int Tiv;
  public LinkedList<dhe> Tiw;
  public String Url;
  
  public bzt()
  {
    AppMethodBeat.i(56250);
    this.Tiw = new LinkedList();
    AppMethodBeat.o(56250);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56251);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.TgD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(56251);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Tiv);
      paramVarArgs.e(3, 8, this.Tiw);
      paramVarArgs.aY(4, this.RLe);
      paramVarArgs.aY(5, this.RXo);
      if (this.TgD != null)
      {
        paramVarArgs.oE(6, this.TgD.computeSize());
        this.TgD.writeFields(paramVarArgs);
      }
      if (this.Url != null) {
        paramVarArgs.f(7, this.Url);
      }
      if (this.TgM != null) {
        paramVarArgs.f(8, this.TgM);
      }
      if (this.RUd != null) {
        paramVarArgs.f(9, this.RUd);
      }
      if (this.RLJ != null) {
        paramVarArgs.f(10, this.RLJ);
      }
      paramVarArgs.aY(11, this.TgN);
      if (this.Sas != null) {
        paramVarArgs.f(12, this.Sas);
      }
      AppMethodBeat.o(56251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1120;
      }
    }
    label1120:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Tiv) + g.a.a.a.c(3, 8, this.Tiw) + g.a.a.b.b.a.bM(4, this.RLe) + g.a.a.b.b.a.bM(5, this.RXo);
      paramInt = i;
      if (this.TgD != null) {
        paramInt = i + g.a.a.a.oD(6, this.TgD.computeSize());
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Url);
      }
      paramInt = i;
      if (this.TgM != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TgM);
      }
      i = paramInt;
      if (this.RUd != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.RUd);
      }
      paramInt = i;
      if (this.RLJ != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RLJ);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.TgN);
      paramInt = i;
      if (this.Sas != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.Sas);
      }
      AppMethodBeat.o(56251);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tiw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        if (this.TgD == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(56251);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bzt localbzt = (bzt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56251);
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
            localbzt.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 2: 
          localbzt.Tiv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(56251);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhe)localObject2).parseFrom((byte[])localObject1);
            }
            localbzt.Tiw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 4: 
          localbzt.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(56251);
          return 0;
        case 5: 
          localbzt.RXo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(56251);
          return 0;
        case 6: 
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
            localbzt.TgD = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(56251);
          return 0;
        case 7: 
          localbzt.Url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 8: 
          localbzt.TgM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 9: 
          localbzt.RUd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 10: 
          localbzt.RLJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(56251);
          return 0;
        case 11: 
          localbzt.TgN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(56251);
          return 0;
        }
        localbzt.Sas = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(56251);
        return 0;
      }
      AppMethodBeat.o(56251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzt
 * JD-Core Version:    0.7.0.1
 */