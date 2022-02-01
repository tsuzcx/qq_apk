package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eii
  extends com.tencent.mm.bw.a
{
  public int GjO;
  public LinkedList<aca> IDO;
  public String IDW;
  public String NhA;
  public LinkedList<String> NhB;
  public beo NhC;
  public LinkedList<eis> Nhy;
  public int Nhz;
  public int channelId;
  public String dDv;
  public String dPI;
  public String dVO;
  public String hes;
  public String nbg;
  public int offset;
  public String sGQ;
  public int scene;
  public String sessionId;
  public String url;
  public String wib;
  public int wwG;
  
  public eii()
  {
    AppMethodBeat.i(152996);
    this.IDO = new LinkedList();
    this.Nhy = new LinkedList();
    this.NhB = new LinkedList();
    AppMethodBeat.o(152996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152997);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hes != null) {
        paramVarArgs.e(1, this.hes);
      }
      if (this.sessionId != null) {
        paramVarArgs.e(2, this.sessionId);
      }
      if (this.dVO != null) {
        paramVarArgs.e(3, this.dVO);
      }
      paramVarArgs.aM(4, this.offset);
      if (this.dDv != null) {
        paramVarArgs.e(5, this.dDv);
      }
      paramVarArgs.aM(6, this.scene);
      if (this.url != null) {
        paramVarArgs.e(7, this.url);
      }
      if (this.dPI != null) {
        paramVarArgs.e(8, this.dPI);
      }
      paramVarArgs.e(9, 8, this.IDO);
      if (this.sGQ != null) {
        paramVarArgs.e(10, this.sGQ);
      }
      paramVarArgs.e(11, 8, this.Nhy);
      paramVarArgs.aM(12, this.GjO);
      paramVarArgs.aM(13, this.channelId);
      if (this.IDW != null) {
        paramVarArgs.e(14, this.IDW);
      }
      paramVarArgs.aM(15, this.Nhz);
      if (this.nbg != null) {
        paramVarArgs.e(16, this.nbg);
      }
      if (this.wib != null) {
        paramVarArgs.e(17, this.wib);
      }
      if (this.NhA != null) {
        paramVarArgs.e(18, this.NhA);
      }
      paramVarArgs.e(19, 1, this.NhB);
      paramVarArgs.aM(20, this.wwG);
      if (this.NhC != null)
      {
        paramVarArgs.ni(21, this.NhC.computeSize());
        this.NhC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hes == null) {
        break label1598;
      }
    }
    label1598:
    for (int i = g.a.a.b.b.a.f(1, this.hes) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.sessionId);
      }
      i = paramInt;
      if (this.dVO != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dVO);
      }
      i += g.a.a.b.b.a.bu(4, this.offset);
      paramInt = i;
      if (this.dDv != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.dDv);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.url);
      }
      i = paramInt;
      if (this.dPI != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.dPI);
      }
      i += g.a.a.a.c(9, 8, this.IDO);
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.sGQ);
      }
      i = paramInt + g.a.a.a.c(11, 8, this.Nhy) + g.a.a.b.b.a.bu(12, this.GjO) + g.a.a.b.b.a.bu(13, this.channelId);
      paramInt = i;
      if (this.IDW != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.IDW);
      }
      i = paramInt + g.a.a.b.b.a.bu(15, this.Nhz);
      paramInt = i;
      if (this.nbg != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.nbg);
      }
      i = paramInt;
      if (this.wib != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.wib);
      }
      paramInt = i;
      if (this.NhA != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.NhA);
      }
      i = paramInt + g.a.a.a.c(19, 1, this.NhB) + g.a.a.b.b.a.bu(20, this.wwG);
      paramInt = i;
      if (this.NhC != null) {
        paramInt = i + g.a.a.a.nh(21, this.NhC.computeSize());
      }
      AppMethodBeat.o(152997);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IDO.clear();
        this.Nhy.clear();
        this.NhB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eii localeii = (eii)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152997);
          return -1;
        case 1: 
          localeii.hes = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 2: 
          localeii.sessionId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 3: 
          localeii.dVO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 4: 
          localeii.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152997);
          return 0;
        case 5: 
          localeii.dDv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 6: 
          localeii.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152997);
          return 0;
        case 7: 
          localeii.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 8: 
          localeii.dPI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeii.IDO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 10: 
          localeii.sGQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eis();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eis)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeii.Nhy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 12: 
          localeii.GjO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152997);
          return 0;
        case 13: 
          localeii.channelId = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152997);
          return 0;
        case 14: 
          localeii.IDW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 15: 
          localeii.Nhz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152997);
          return 0;
        case 16: 
          localeii.nbg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 17: 
          localeii.wib = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 18: 
          localeii.NhA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 19: 
          localeii.NhB.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(152997);
          return 0;
        case 20: 
          localeii.wwG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152997);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new beo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((beo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeii.NhC = ((beo)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eii
 * JD-Core Version:    0.7.0.1
 */