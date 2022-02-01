package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class awi
  extends dyl
{
  public aqe SDi;
  public String SHp;
  public String SIL;
  public int SIM;
  public String SIN;
  public long SIO;
  public awk SIP;
  public int fUN;
  public String finderUsername;
  public long liveId;
  public String object_nonce_id;
  public int scene;
  public b xak;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230914);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(3, this.liveId);
      if (this.xak != null) {
        paramVarArgs.c(4, this.xak);
      }
      paramVarArgs.bm(5, this.xbk);
      if (this.finderUsername != null) {
        paramVarArgs.f(6, this.finderUsername);
      }
      paramVarArgs.aY(7, this.scene);
      if (this.SIL != null) {
        paramVarArgs.f(8, this.SIL);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.f(9, this.object_nonce_id);
      }
      if (this.SHp != null) {
        paramVarArgs.f(10, this.SHp);
      }
      paramVarArgs.aY(11, this.SIM);
      if (this.SIN != null) {
        paramVarArgs.f(12, this.SIN);
      }
      paramVarArgs.aY(13, this.fUN);
      paramVarArgs.bm(14, this.SIO);
      if (this.SIP != null)
      {
        paramVarArgs.oE(15, this.SIP.computeSize());
        this.SIP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(230914);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1196;
      }
    }
    label1196:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i += g.a.a.b.b.a.p(3, this.liveId);
      paramInt = i;
      if (this.xak != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.xak);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.xbk);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.finderUsername);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.scene);
      paramInt = i;
      if (this.SIL != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SIL);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.object_nonce_id);
      }
      paramInt = i;
      if (this.SHp != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SHp);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.SIM);
      paramInt = i;
      if (this.SIN != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.SIN);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.fUN) + g.a.a.b.b.a.p(14, this.SIO);
      paramInt = i;
      if (this.SIP != null) {
        paramInt = i + g.a.a.a.oD(15, this.SIP.computeSize());
      }
      AppMethodBeat.o(230914);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230914);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        awi localawi = (awi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230914);
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
            localawi.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230914);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localawi.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230914);
          return 0;
        case 3: 
          localawi.liveId = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230914);
          return 0;
        case 4: 
          localawi.xak = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230914);
          return 0;
        case 5: 
          localawi.xbk = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230914);
          return 0;
        case 6: 
          localawi.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230914);
          return 0;
        case 7: 
          localawi.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230914);
          return 0;
        case 8: 
          localawi.SIL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230914);
          return 0;
        case 9: 
          localawi.object_nonce_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230914);
          return 0;
        case 10: 
          localawi.SHp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230914);
          return 0;
        case 11: 
          localawi.SIM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230914);
          return 0;
        case 12: 
          localawi.SIN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230914);
          return 0;
        case 13: 
          localawi.fUN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(230914);
          return 0;
        case 14: 
          localawi.SIO = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230914);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new awk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((awk)localObject2).parseFrom((byte[])localObject1);
          }
          localawi.SIP = ((awk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(230914);
        return 0;
      }
      AppMethodBeat.o(230914);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awi
 * JD-Core Version:    0.7.0.1
 */