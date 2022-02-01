package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class emr
  extends com.tencent.mm.cd.a
{
  public mf Upj;
  public ezq Upk;
  public dhb Upl;
  public long Upm;
  public int Upn;
  public long Upo;
  public long Upp;
  public b Upq;
  public long Upr;
  public String Ups;
  public long Upt;
  public String finderUsername;
  public int mediaType;
  public String objectNonceId;
  public String sessionBuffer;
  public int uin;
  public long xbk;
  public int xkX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169091);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.xbk);
      if (this.Upj != null)
      {
        paramVarArgs.oE(2, this.Upj.computeSize());
        this.Upj.writeFields(paramVarArgs);
      }
      if (this.Upk != null)
      {
        paramVarArgs.oE(3, this.Upk.computeSize());
        this.Upk.writeFields(paramVarArgs);
      }
      if (this.Upl != null)
      {
        paramVarArgs.oE(4, this.Upl.computeSize());
        this.Upl.writeFields(paramVarArgs);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.f(5, this.objectNonceId);
      }
      if (this.finderUsername != null) {
        paramVarArgs.f(6, this.finderUsername);
      }
      paramVarArgs.bm(7, this.Upm);
      paramVarArgs.aY(8, this.Upn);
      if (this.sessionBuffer != null) {
        paramVarArgs.f(9, this.sessionBuffer);
      }
      paramVarArgs.bm(10, this.Upo);
      paramVarArgs.aY(11, this.xkX);
      paramVarArgs.bm(12, this.Upp);
      if (this.Upq != null) {
        paramVarArgs.c(13, this.Upq);
      }
      paramVarArgs.aY(14, this.mediaType);
      paramVarArgs.bm(15, this.Upr);
      if (this.Ups != null) {
        paramVarArgs.f(16, this.Ups);
      }
      paramVarArgs.bm(17, this.Upt);
      paramVarArgs.aY(18, this.uin);
      AppMethodBeat.o(169091);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.xbk) + 0;
      paramInt = i;
      if (this.Upj != null) {
        paramInt = i + g.a.a.a.oD(2, this.Upj.computeSize());
      }
      i = paramInt;
      if (this.Upk != null) {
        i = paramInt + g.a.a.a.oD(3, this.Upk.computeSize());
      }
      paramInt = i;
      if (this.Upl != null) {
        paramInt = i + g.a.a.a.oD(4, this.Upl.computeSize());
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.objectNonceId);
      }
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.finderUsername);
      }
      i = paramInt + g.a.a.b.b.a.p(7, this.Upm) + g.a.a.b.b.a.bM(8, this.Upn);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.sessionBuffer);
      }
      i = paramInt + g.a.a.b.b.a.p(10, this.Upo) + g.a.a.b.b.a.bM(11, this.xkX) + g.a.a.b.b.a.p(12, this.Upp);
      paramInt = i;
      if (this.Upq != null) {
        paramInt = i + g.a.a.b.b.a.b(13, this.Upq);
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.mediaType) + g.a.a.b.b.a.p(15, this.Upr);
      paramInt = i;
      if (this.Ups != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.Ups);
      }
      i = g.a.a.b.b.a.p(17, this.Upt);
      int j = g.a.a.b.b.a.bM(18, this.uin);
      AppMethodBeat.o(169091);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169091);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      emr localemr = (emr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169091);
        return -1;
      case 1: 
        localemr.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169091);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((mf)localObject2).parseFrom((byte[])localObject1);
          }
          localemr.Upj = ((mf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ezq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ezq)localObject2).parseFrom((byte[])localObject1);
          }
          localemr.Upk = ((ezq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhb)localObject2).parseFrom((byte[])localObject1);
          }
          localemr.Upl = ((dhb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 5: 
        localemr.objectNonceId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 6: 
        localemr.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 7: 
        localemr.Upm = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169091);
        return 0;
      case 8: 
        localemr.Upn = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169091);
        return 0;
      case 9: 
        localemr.sessionBuffer = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 10: 
        localemr.Upo = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169091);
        return 0;
      case 11: 
        localemr.xkX = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169091);
        return 0;
      case 12: 
        localemr.Upp = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169091);
        return 0;
      case 13: 
        localemr.Upq = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(169091);
        return 0;
      case 14: 
        localemr.mediaType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169091);
        return 0;
      case 15: 
        localemr.Upr = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169091);
        return 0;
      case 16: 
        localemr.Ups = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 17: 
        localemr.Upt = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(169091);
        return 0;
      }
      localemr.uin = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(169091);
      return 0;
    }
    AppMethodBeat.o(169091);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emr
 * JD-Core Version:    0.7.0.1
 */