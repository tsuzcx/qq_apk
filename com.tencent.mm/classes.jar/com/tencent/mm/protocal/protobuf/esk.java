package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esk
  extends com.tencent.mm.cd.a
{
  public String ARR;
  public int BkW;
  public int MWz;
  public LinkedList<aci> Pye;
  public String Pym;
  public LinkedList<esu> Uue;
  public int Uuf;
  public String Uug;
  public LinkedList<String> Uuh;
  public bls Uui;
  public int channelId;
  public String fIY;
  public String fPs;
  public String fwe;
  public String jQi;
  public int offset;
  public String qbv;
  public int scene;
  public String sessionId;
  public String url;
  public String wmL;
  
  public esk()
  {
    AppMethodBeat.i(152996);
    this.Pye = new LinkedList();
    this.Uue = new LinkedList();
    this.Uuh = new LinkedList();
    AppMethodBeat.o(152996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152997);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jQi != null) {
        paramVarArgs.f(1, this.jQi);
      }
      if (this.sessionId != null) {
        paramVarArgs.f(2, this.sessionId);
      }
      if (this.fPs != null) {
        paramVarArgs.f(3, this.fPs);
      }
      paramVarArgs.aY(4, this.offset);
      if (this.fwe != null) {
        paramVarArgs.f(5, this.fwe);
      }
      paramVarArgs.aY(6, this.scene);
      if (this.url != null) {
        paramVarArgs.f(7, this.url);
      }
      if (this.fIY != null) {
        paramVarArgs.f(8, this.fIY);
      }
      paramVarArgs.e(9, 8, this.Pye);
      if (this.wmL != null) {
        paramVarArgs.f(10, this.wmL);
      }
      paramVarArgs.e(11, 8, this.Uue);
      paramVarArgs.aY(12, this.MWz);
      paramVarArgs.aY(13, this.channelId);
      if (this.Pym != null) {
        paramVarArgs.f(14, this.Pym);
      }
      paramVarArgs.aY(15, this.Uuf);
      if (this.qbv != null) {
        paramVarArgs.f(16, this.qbv);
      }
      if (this.ARR != null) {
        paramVarArgs.f(17, this.ARR);
      }
      if (this.Uug != null) {
        paramVarArgs.f(18, this.Uug);
      }
      paramVarArgs.e(19, 1, this.Uuh);
      paramVarArgs.aY(20, this.BkW);
      if (this.Uui != null)
      {
        paramVarArgs.oE(21, this.Uui.computeSize());
        this.Uui.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jQi == null) {
        break label1532;
      }
    }
    label1532:
    for (int i = g.a.a.b.b.a.g(1, this.jQi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.sessionId);
      }
      i = paramInt;
      if (this.fPs != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fPs);
      }
      i += g.a.a.b.b.a.bM(4, this.offset);
      paramInt = i;
      if (this.fwe != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fwe);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.url);
      }
      i = paramInt;
      if (this.fIY != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.fIY);
      }
      i += g.a.a.a.c(9, 8, this.Pye);
      paramInt = i;
      if (this.wmL != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.wmL);
      }
      i = paramInt + g.a.a.a.c(11, 8, this.Uue) + g.a.a.b.b.a.bM(12, this.MWz) + g.a.a.b.b.a.bM(13, this.channelId);
      paramInt = i;
      if (this.Pym != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.Pym);
      }
      i = paramInt + g.a.a.b.b.a.bM(15, this.Uuf);
      paramInt = i;
      if (this.qbv != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.qbv);
      }
      i = paramInt;
      if (this.ARR != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.ARR);
      }
      paramInt = i;
      if (this.Uug != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.Uug);
      }
      i = paramInt + g.a.a.a.c(19, 1, this.Uuh) + g.a.a.b.b.a.bM(20, this.BkW);
      paramInt = i;
      if (this.Uui != null) {
        paramInt = i + g.a.a.a.oD(21, this.Uui.computeSize());
      }
      AppMethodBeat.o(152997);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Pye.clear();
        this.Uue.clear();
        this.Uuh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        esk localesk = (esk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152997);
          return -1;
        case 1: 
          localesk.jQi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 2: 
          localesk.sessionId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 3: 
          localesk.fPs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 4: 
          localesk.offset = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152997);
          return 0;
        case 5: 
          localesk.fwe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 6: 
          localesk.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152997);
          return 0;
        case 7: 
          localesk.url = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 8: 
          localesk.fIY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aci();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aci)localObject2).parseFrom((byte[])localObject1);
            }
            localesk.Pye.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 10: 
          localesk.wmL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esu)localObject2).parseFrom((byte[])localObject1);
            }
            localesk.Uue.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152997);
          return 0;
        case 12: 
          localesk.MWz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152997);
          return 0;
        case 13: 
          localesk.channelId = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152997);
          return 0;
        case 14: 
          localesk.Pym = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 15: 
          localesk.Uuf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152997);
          return 0;
        case 16: 
          localesk.qbv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 17: 
          localesk.ARR = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 18: 
          localesk.Uug = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152997);
          return 0;
        case 19: 
          localesk.Uuh.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(152997);
          return 0;
        case 20: 
          localesk.BkW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152997);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bls();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bls)localObject2).parseFrom((byte[])localObject1);
          }
          localesk.Uui = ((bls)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esk
 * JD-Core Version:    0.7.0.1
 */