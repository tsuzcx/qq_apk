package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aae
  extends dyl
{
  public int CPw;
  public String CRQ;
  public String CRR;
  public int HlE;
  public long HlH;
  public int HmZ;
  public String RYD;
  public fcr Sms;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32166);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RYD != null) {
        paramVarArgs.f(2, this.RYD);
      }
      paramVarArgs.aY(3, this.HmZ);
      paramVarArgs.aY(4, this.HlE);
      if (this.Sms != null)
      {
        paramVarArgs.oE(5, this.Sms.computeSize());
        this.Sms.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.HlH);
      paramVarArgs.aY(7, this.CPw);
      if (this.CRR != null) {
        paramVarArgs.f(8, this.CRR);
      }
      if (this.CRQ != null) {
        paramVarArgs.f(9, this.CRQ);
      }
      AppMethodBeat.o(32166);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label797;
      }
    }
    label797:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RYD != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RYD);
      }
      i = i + g.a.a.b.b.a.bM(3, this.HmZ) + g.a.a.b.b.a.bM(4, this.HlE);
      paramInt = i;
      if (this.Sms != null) {
        paramInt = i + g.a.a.a.oD(5, this.Sms.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.HlH) + g.a.a.b.b.a.bM(7, this.CPw);
      paramInt = i;
      if (this.CRR != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.CRR);
      }
      i = paramInt;
      if (this.CRQ != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.CRQ);
      }
      AppMethodBeat.o(32166);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32166);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aae localaae = (aae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32166);
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
            localaae.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 2: 
          localaae.RYD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32166);
          return 0;
        case 3: 
          localaae.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32166);
          return 0;
        case 4: 
          localaae.HlE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32166);
          return 0;
        case 5: 
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
            localaae.Sms = ((fcr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32166);
          return 0;
        case 6: 
          localaae.HlH = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(32166);
          return 0;
        case 7: 
          localaae.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32166);
          return 0;
        case 8: 
          localaae.CRR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32166);
          return 0;
        }
        localaae.CRQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32166);
        return 0;
      }
      AppMethodBeat.o(32166);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aae
 * JD-Core Version:    0.7.0.1
 */