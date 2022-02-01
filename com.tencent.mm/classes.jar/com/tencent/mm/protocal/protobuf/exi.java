package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class exi
  extends dyl
{
  public int HmZ;
  public int Hna;
  public int Hnb;
  public eae Hnc;
  public String SrU;
  public String lps;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90777);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(90777);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lps != null) {
        paramVarArgs.f(2, this.lps);
      }
      paramVarArgs.aY(3, this.HmZ);
      paramVarArgs.aY(4, this.Hna);
      paramVarArgs.aY(5, this.Hnb);
      if (this.Hnc != null)
      {
        paramVarArgs.oE(6, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      if (this.SrU != null) {
        paramVarArgs.f(7, this.SrU);
      }
      AppMethodBeat.o(90777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lps != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.lps);
      }
      i = i + g.a.a.b.b.a.bM(3, this.HmZ) + g.a.a.b.b.a.bM(4, this.Hna) + g.a.a.b.b.a.bM(5, this.Hnb);
      paramInt = i;
      if (this.Hnc != null) {
        paramInt = i + g.a.a.a.oD(6, this.Hnc.computeSize());
      }
      i = paramInt;
      if (this.SrU != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SrU);
      }
      AppMethodBeat.o(90777);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(90777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        exi localexi = (exi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90777);
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
            localexi.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        case 2: 
          localexi.lps = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(90777);
          return 0;
        case 3: 
          localexi.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(90777);
          return 0;
        case 4: 
          localexi.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(90777);
          return 0;
        case 5: 
          localexi.Hnb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(90777);
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
            localexi.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        }
        localexi.SrU = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(90777);
        return 0;
      }
      AppMethodBeat.o(90777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exi
 * JD-Core Version:    0.7.0.1
 */