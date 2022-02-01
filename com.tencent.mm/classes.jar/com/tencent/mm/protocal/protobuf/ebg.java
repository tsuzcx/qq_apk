package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebg
  extends dyy
{
  public String SjB;
  public LinkedList<ddj> TKY;
  public String TKZ;
  public boolean TLa;
  public boolean TLb;
  public boolean TLc;
  public LinkedList<ddg> TLd;
  public boolean TLe;
  public com.tencent.mm.cd.b Ugc;
  public com.tencent.mm.cd.b Ugg;
  public String Ugj;
  public String lnp;
  public boolean oDO;
  public int oDP;
  public int oDQ;
  public String oDR;
  public String oDS;
  
  public ebg()
  {
    AppMethodBeat.i(82474);
    this.TKY = new LinkedList();
    this.TLd = new LinkedList();
    AppMethodBeat.o(82474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82475);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.TKY);
      if (this.lnp != null) {
        paramVarArgs.f(4, this.lnp);
      }
      if (this.TKZ != null) {
        paramVarArgs.f(5, this.TKZ);
      }
      if (this.SjB != null) {
        paramVarArgs.f(6, this.SjB);
      }
      paramVarArgs.co(8, this.TLa);
      paramVarArgs.co(9, this.TLb);
      paramVarArgs.co(10, this.TLc);
      paramVarArgs.e(11, 8, this.TLd);
      paramVarArgs.co(12, this.TLe);
      paramVarArgs.co(13, this.oDO);
      paramVarArgs.aY(14, this.oDP);
      paramVarArgs.aY(15, this.oDQ);
      if (this.oDR != null) {
        paramVarArgs.f(16, this.oDR);
      }
      if (this.oDS != null) {
        paramVarArgs.f(17, this.oDS);
      }
      if (this.Ugj != null) {
        paramVarArgs.f(21, this.Ugj);
      }
      if (this.Ugg != null) {
        paramVarArgs.c(22, this.Ugg);
      }
      if (this.Ugc != null) {
        paramVarArgs.c(24, this.Ugc);
      }
      AppMethodBeat.o(82475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1388;
      }
    }
    label1388:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(3, 8, this.TKY);
      paramInt = i;
      if (this.lnp != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.lnp);
      }
      i = paramInt;
      if (this.TKZ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TKZ);
      }
      paramInt = i;
      if (this.SjB != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SjB);
      }
      i = paramInt + (g.a.a.b.b.a.gL(8) + 1) + (g.a.a.b.b.a.gL(9) + 1) + (g.a.a.b.b.a.gL(10) + 1) + g.a.a.a.c(11, 8, this.TLd) + (g.a.a.b.b.a.gL(12) + 1) + (g.a.a.b.b.a.gL(13) + 1) + g.a.a.b.b.a.bM(14, this.oDP) + g.a.a.b.b.a.bM(15, this.oDQ);
      paramInt = i;
      if (this.oDR != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.oDR);
      }
      i = paramInt;
      if (this.oDS != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.oDS);
      }
      paramInt = i;
      if (this.Ugj != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.Ugj);
      }
      i = paramInt;
      if (this.Ugg != null) {
        i = paramInt + g.a.a.b.b.a.b(22, this.Ugg);
      }
      paramInt = i;
      if (this.Ugc != null) {
        paramInt = i + g.a.a.b.b.a.b(24, this.Ugc);
      }
      AppMethodBeat.o(82475);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TKY.clear();
        this.TLd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82475);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebg localebg = (ebg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        case 18: 
        case 19: 
        case 20: 
        case 23: 
        default: 
          AppMethodBeat.o(82475);
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
            localebg.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82475);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddj)localObject2).parseFrom((byte[])localObject1);
            }
            localebg.TKY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82475);
          return 0;
        case 4: 
          localebg.lnp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 5: 
          localebg.TKZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 6: 
          localebg.SjB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 8: 
          localebg.TLa = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(82475);
          return 0;
        case 9: 
          localebg.TLb = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(82475);
          return 0;
        case 10: 
          localebg.TLc = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(82475);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddg)localObject2).parseFrom((byte[])localObject1);
            }
            localebg.TLd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82475);
          return 0;
        case 12: 
          localebg.TLe = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(82475);
          return 0;
        case 13: 
          localebg.oDO = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(82475);
          return 0;
        case 14: 
          localebg.oDP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(82475);
          return 0;
        case 15: 
          localebg.oDQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(82475);
          return 0;
        case 16: 
          localebg.oDR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 17: 
          localebg.oDS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 21: 
          localebg.Ugj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82475);
          return 0;
        case 22: 
          localebg.Ugg = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(82475);
          return 0;
        }
        localebg.Ugc = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(82475);
        return 0;
      }
      AppMethodBeat.o(82475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebg
 * JD-Core Version:    0.7.0.1
 */