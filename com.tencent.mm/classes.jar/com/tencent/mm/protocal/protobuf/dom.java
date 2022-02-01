package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dom
  extends com.tencent.mm.bw.a
{
  public int BJf;
  public LinkedList<aaj> DTg;
  public String DTo;
  public String GEi;
  public LinkedList<dow> HVo;
  public int HVp;
  public String HVq;
  public LinkedList<String> HVr;
  public ato HVs;
  public int cSM;
  public String dEb;
  public String dmf;
  public String dyb;
  public String kid;
  public int offset;
  public String rfA;
  public String sBn;
  public int scene;
  public String sessionId;
  public int uRo;
  public String url;
  
  public dom()
  {
    AppMethodBeat.i(152996);
    this.DTg = new LinkedList();
    this.HVo = new LinkedList();
    this.HVr = new LinkedList();
    AppMethodBeat.o(152996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152997);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.kid != null) {
        paramVarArgs.d(1, this.kid);
      }
      if (this.sessionId != null) {
        paramVarArgs.d(2, this.sessionId);
      }
      if (this.dEb != null) {
        paramVarArgs.d(3, this.dEb);
      }
      paramVarArgs.aS(4, this.offset);
      if (this.dmf != null) {
        paramVarArgs.d(5, this.dmf);
      }
      paramVarArgs.aS(6, this.scene);
      if (this.url != null) {
        paramVarArgs.d(7, this.url);
      }
      if (this.dyb != null) {
        paramVarArgs.d(8, this.dyb);
      }
      paramVarArgs.e(9, 8, this.DTg);
      if (this.rfA != null) {
        paramVarArgs.d(10, this.rfA);
      }
      paramVarArgs.e(11, 8, this.HVo);
      paramVarArgs.aS(12, this.BJf);
      paramVarArgs.aS(13, this.cSM);
      if (this.DTo != null) {
        paramVarArgs.d(14, this.DTo);
      }
      paramVarArgs.aS(15, this.HVp);
      if (this.GEi != null) {
        paramVarArgs.d(16, this.GEi);
      }
      if (this.sBn != null) {
        paramVarArgs.d(17, this.sBn);
      }
      if (this.HVq != null) {
        paramVarArgs.d(18, this.HVq);
      }
      paramVarArgs.e(19, 1, this.HVr);
      paramVarArgs.aS(20, this.uRo);
      if (this.HVs != null)
      {
        paramVarArgs.lJ(21, this.HVs.computeSize());
        this.HVs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kid == null) {
        break label1598;
      }
    }
    label1598:
    for (int i = f.a.a.b.b.a.e(1, this.kid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sessionId);
      }
      i = paramInt;
      if (this.dEb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dEb);
      }
      i += f.a.a.b.b.a.bz(4, this.offset);
      paramInt = i;
      if (this.dmf != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.dmf);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.url);
      }
      i = paramInt;
      if (this.dyb != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.dyb);
      }
      i += f.a.a.a.c(9, 8, this.DTg);
      paramInt = i;
      if (this.rfA != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.rfA);
      }
      i = paramInt + f.a.a.a.c(11, 8, this.HVo) + f.a.a.b.b.a.bz(12, this.BJf) + f.a.a.b.b.a.bz(13, this.cSM);
      paramInt = i;
      if (this.DTo != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.DTo);
      }
      i = paramInt + f.a.a.b.b.a.bz(15, this.HVp);
      paramInt = i;
      if (this.GEi != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GEi);
      }
      i = paramInt;
      if (this.sBn != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.sBn);
      }
      paramInt = i;
      if (this.HVq != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.HVq);
      }
      i = paramInt + f.a.a.a.c(19, 1, this.HVr) + f.a.a.b.b.a.bz(20, this.uRo);
      paramInt = i;
      if (this.HVs != null) {
        paramInt = i + f.a.a.a.lI(21, this.HVs.computeSize());
      }
      AppMethodBeat.o(152997);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DTg.clear();
        this.HVo.clear();
        this.HVr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dom localdom = (dom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152997);
          return -1;
        case 1: 
          localdom.kid = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 2: 
          localdom.sessionId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 3: 
          localdom.dEb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 4: 
          localdom.offset = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152997);
          return 0;
        case 5: 
          localdom.dmf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 6: 
          localdom.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152997);
          return 0;
        case 7: 
          localdom.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 8: 
          localdom.dyb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdom.DTg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 10: 
          localdom.rfA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dow();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dow)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdom.HVo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 12: 
          localdom.BJf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152997);
          return 0;
        case 13: 
          localdom.cSM = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152997);
          return 0;
        case 14: 
          localdom.DTo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 15: 
          localdom.HVp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152997);
          return 0;
        case 16: 
          localdom.GEi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 17: 
          localdom.sBn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 18: 
          localdom.HVq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 19: 
          localdom.HVr.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(152997);
          return 0;
        case 20: 
          localdom.uRo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152997);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ato();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ato)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdom.HVs = ((ato)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      AppMethodBeat.o(152997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dom
 * JD-Core Version:    0.7.0.1
 */