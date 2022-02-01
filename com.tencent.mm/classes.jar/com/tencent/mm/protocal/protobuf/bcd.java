package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bcd
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public b RLO;
  public String SHp;
  public String SKd;
  public String SKg;
  public int SKo;
  public int SKp;
  public boolean SNF;
  public String SNG;
  public long klE;
  public long object_id;
  public String request_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229504);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLM != null)
      {
        paramVarArgs.oE(2, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      if (this.RLN != null) {
        paramVarArgs.f(3, this.RLN);
      }
      paramVarArgs.bm(4, this.object_id);
      paramVarArgs.bm(5, this.klE);
      if (this.SKd != null) {
        paramVarArgs.f(6, this.SKd);
      }
      paramVarArgs.aY(7, this.SKo);
      paramVarArgs.aY(8, this.SKp);
      if (this.request_id != null) {
        paramVarArgs.f(9, this.request_id);
      }
      if (this.SKg != null) {
        paramVarArgs.f(10, this.SKg);
      }
      if (this.RLO != null) {
        paramVarArgs.c(11, this.RLO);
      }
      paramVarArgs.co(12, this.SNF);
      if (this.SNG != null) {
        paramVarArgs.f(13, this.SNG);
      }
      if (this.SHp != null) {
        paramVarArgs.f(14, this.SHp);
      }
      AppMethodBeat.o(229504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1074;
      }
    }
    label1074:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLM != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RLN);
      }
      i = i + g.a.a.b.b.a.p(4, this.object_id) + g.a.a.b.b.a.p(5, this.klE);
      paramInt = i;
      if (this.SKd != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SKd);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.SKo) + g.a.a.b.b.a.bM(8, this.SKp);
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.request_id);
      }
      i = paramInt;
      if (this.SKg != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.SKg);
      }
      paramInt = i;
      if (this.RLO != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.RLO);
      }
      i = paramInt + (g.a.a.b.b.a.gL(12) + 1);
      paramInt = i;
      if (this.SNG != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.SNG);
      }
      i = paramInt;
      if (this.SHp != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.SHp);
      }
      AppMethodBeat.o(229504);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bcd localbcd = (bcd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229504);
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
            localbcd.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229504);
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
            localbcd.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229504);
          return 0;
        case 3: 
          localbcd.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229504);
          return 0;
        case 4: 
          localbcd.object_id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229504);
          return 0;
        case 5: 
          localbcd.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229504);
          return 0;
        case 6: 
          localbcd.SKd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229504);
          return 0;
        case 7: 
          localbcd.SKo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229504);
          return 0;
        case 8: 
          localbcd.SKp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(229504);
          return 0;
        case 9: 
          localbcd.request_id = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229504);
          return 0;
        case 10: 
          localbcd.SKg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229504);
          return 0;
        case 11: 
          localbcd.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(229504);
          return 0;
        case 12: 
          localbcd.SNF = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(229504);
          return 0;
        case 13: 
          localbcd.SNG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229504);
          return 0;
        }
        localbcd.SHp = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(229504);
        return 0;
      }
      AppMethodBeat.o(229504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcd
 * JD-Core Version:    0.7.0.1
 */