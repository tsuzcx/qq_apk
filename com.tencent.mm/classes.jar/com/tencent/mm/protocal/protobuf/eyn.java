package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eyn
  extends dyl
{
  public int CPw;
  public String CRQ;
  public String CRR;
  public eae Hnc;
  public String RYD;
  public fcr Sms;
  public eym Smu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Sms == null)
      {
        paramVarArgs = new b("Not all required fields were included: VoiceAttr");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.Smu == null)
      {
        paramVarArgs = new b("Not all required fields were included: UploadCtx");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(32487);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RYD != null) {
        paramVarArgs.f(2, this.RYD);
      }
      if (this.Sms != null)
      {
        paramVarArgs.oE(3, this.Sms.computeSize());
        this.Sms.writeFields(paramVarArgs);
      }
      if (this.Smu != null)
      {
        paramVarArgs.oE(4, this.Smu.computeSize());
        this.Smu.writeFields(paramVarArgs);
      }
      if (this.Hnc != null)
      {
        paramVarArgs.oE(5, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.CPw);
      if (this.CRR != null) {
        paramVarArgs.f(7, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(8, this.CRQ);
      }
      AppMethodBeat.o(32487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1080;
      }
    }
    label1080:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RYD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RYD);
      }
      i = paramInt;
      if (this.Sms != null) {
        i = paramInt + g.a.a.a.oD(3, this.Sms.computeSize());
      }
      paramInt = i;
      if (this.Smu != null) {
        paramInt = i + g.a.a.a.oD(4, this.Smu.computeSize());
      }
      i = paramInt;
      if (this.Hnc != null) {
        i = paramInt + g.a.a.a.oD(5, this.Hnc.computeSize());
      }
      i += g.a.a.b.b.a.bM(6, this.CPw);
      paramInt = i;
      if (this.CRR != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.CRR);
      }
      i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.CRQ);
      }
      AppMethodBeat.o(32487);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Sms == null)
        {
          paramVarArgs = new b("Not all required fields were included: VoiceAttr");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.Smu == null)
        {
          paramVarArgs = new b("Not all required fields were included: UploadCtx");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(32487);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eyn localeyn = (eyn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32487);
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
            localeyn.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 2: 
          localeyn.RYD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32487);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fcr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fcr)localObject2).parseFrom((byte[])localObject1);
            }
            localeyn.Sms = ((fcr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eym();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eym)localObject2).parseFrom((byte[])localObject1);
            }
            localeyn.Smu = ((eym)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 5: 
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
            localeyn.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32487);
          return 0;
        case 6: 
          localeyn.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32487);
          return 0;
        case 7: 
          localeyn.CRR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32487);
          return 0;
        }
        localeyn.CRQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32487);
        return 0;
      }
      AppMethodBeat.o(32487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyn
 * JD-Core Version:    0.7.0.1
 */