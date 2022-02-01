package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dvn
  extends dyy
{
  public String DNV;
  public String GHy;
  public String OmF;
  public int TUS;
  public String UbA;
  public String UbB;
  public String UbC;
  public boolean Ubx;
  public boolean Uby;
  public String Ubz;
  public ctd fZQ;
  public int status;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91666);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91666);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      paramVarArgs.co(4, this.Ubx);
      paramVarArgs.co(5, this.Uby);
      paramVarArgs.aY(6, this.status);
      if (this.Ubz != null) {
        paramVarArgs.f(7, this.Ubz);
      }
      if (this.UbA != null) {
        paramVarArgs.f(8, this.UbA);
      }
      paramVarArgs.aY(9, this.TUS);
      if (this.DNV != null) {
        paramVarArgs.f(10, this.DNV);
      }
      if (this.GHy != null) {
        paramVarArgs.f(11, this.GHy);
      }
      if (this.UbB != null) {
        paramVarArgs.f(12, this.UbB);
      }
      if (this.UbC != null) {
        paramVarArgs.f(13, this.UbC);
      }
      if (this.fZQ != null)
      {
        paramVarArgs.oE(99, this.fZQ.computeSize());
        this.fZQ.writeFields(paramVarArgs);
      }
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(91666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1238;
      }
    }
    label1238:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt + (g.a.a.b.b.a.gL(4) + 1) + (g.a.a.b.b.a.gL(5) + 1) + g.a.a.b.b.a.bM(6, this.status);
      paramInt = i;
      if (this.Ubz != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Ubz);
      }
      i = paramInt;
      if (this.UbA != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.UbA);
      }
      i += g.a.a.b.b.a.bM(9, this.TUS);
      paramInt = i;
      if (this.DNV != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.DNV);
      }
      i = paramInt;
      if (this.GHy != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.GHy);
      }
      paramInt = i;
      if (this.UbB != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.UbB);
      }
      i = paramInt;
      if (this.UbC != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.UbC);
      }
      paramInt = i;
      if (this.fZQ != null) {
        paramInt = i + g.a.a.a.oD(99, this.fZQ.computeSize());
      }
      i = paramInt;
      if (this.OmF != null) {
        i = paramInt + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(91666);
      return i;
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
          AppMethodBeat.o(91666);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvn localdvn = (dvn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91666);
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
            localdvn.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91666);
          return 0;
        case 2: 
          localdvn.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91666);
          return 0;
        case 3: 
          localdvn.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 4: 
          localdvn.Ubx = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91666);
          return 0;
        case 5: 
          localdvn.Uby = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(91666);
          return 0;
        case 6: 
          localdvn.status = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91666);
          return 0;
        case 7: 
          localdvn.Ubz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 8: 
          localdvn.UbA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 9: 
          localdvn.TUS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91666);
          return 0;
        case 10: 
          localdvn.DNV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 11: 
          localdvn.GHy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 12: 
          localdvn.UbB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 13: 
          localdvn.UbC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91666);
          return 0;
        case 99: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ctd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ctd)localObject2).parseFrom((byte[])localObject1);
            }
            localdvn.fZQ = ((ctd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91666);
          return 0;
        }
        localdvn.OmF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91666);
        return 0;
      }
      AppMethodBeat.o(91666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvn
 * JD-Core Version:    0.7.0.1
 */